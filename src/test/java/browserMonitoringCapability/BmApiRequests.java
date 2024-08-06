package browserMonitoringCapability;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microsoft.playwright.APIRequest;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.RequestOptions;

import genericUtilities.ExcelUtility;
import genericUtilities.IPathConstant;
import objectRepository.CommonPage;
import objectRepository.SettingsPage;
import objectRepository.BM.BmApplicationPage;
import objectRepository.BM.BmErrorsPage;
import objectRepository.BM.BmPagesPage;
import pojoRepository.BM.BMAngularErrorPojo;
import pojoRepository.BM.BmAngularLoadPojo;
import pojoRepository.BM.BmReactErrorPojo;
import pojoRepository.BM.BmReactLoadPojo;

public class BmApiRequests {
	Page page;
	ExcelUtility excel = new ExcelUtility();
	Playwright playWright = Playwright.create();
	APIRequest request = playWright.request();
	APIRequestContext requestContext = request.newContext();
	ObjectMapper objMap = new ObjectMapper();
	CommonPage common;
	BmApplicationPage bmApp;
	
	String url;
	String authorization;
	String teamId;
	
	public BmApiRequests(Page page) {
		this.page = page;
		common = new CommonPage(this.page);
	}

	public int generatePerformanceLoadForBMAngularApplication() throws IOException {
		String[] counts = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmDataValidationSheet, "angularLoad_counts").split(",");
		String[] pagePaths = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmDataValidationSheet, "angularLoad_pagePaths").split(",");
		int count = 0;
		for (int i=0; i<counts.length; i++) {
			bmAngularLoadRequest(Integer.parseInt(counts[i]), pagePaths[i]);
			page.waitForTimeout(2000);
			count = count + Integer.parseInt(counts[i]);
		}
		return count;
	}
	
	public int generatePerformanceLoadForBMReactApplication() throws IOException {
		String[] counts = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmDataValidationSheet, "reactLoad_counts").split(",");
		String[] pagePaths = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmDataValidationSheet, "reactLoad_pagePaths").split(",");
		int count = 0;
		for (int i=0; i<counts.length; i++) {
			bmReactLoadRequest(Integer.parseInt(counts[i]), pagePaths[i]);
			page.waitForTimeout(2000);
			count = count + Integer.parseInt(counts[i]);
		}
		return count;
	}
	
	public int generateErrorLoadForBMAngularApplication() throws IOException, NumberFormatException, EncryptedDocumentException, InterruptedException {
		String[] counts = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmDataValidationSheet, "angularError_counts").split(",");
		String[] pagePaths = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmDataValidationSheet, "angularError_pagePaths").split(",");
		String[] category = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmDataValidationSheet, "angularError_categories").split(",");
		int count = 0;
		for (int i=0; i<counts.length ; i++) {
			bmAngularErrorRequest(Integer.parseInt(counts[i]), pagePaths[i], category[i]);
			page.waitForTimeout(2000);
			count = count + Integer.parseInt(counts[i]);
		}
		return count;
	}
	
	public int generateErrorLoadForBMReactApplication() throws IOException, NumberFormatException, EncryptedDocumentException, InterruptedException {
		String[] counts = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmDataValidationSheet, "reactError_counts").split(",");
		String[] pagePaths = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmDataValidationSheet, "reactError_pagePaths").split(",");
		String[] category = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmDataValidationSheet, "reactError_categories").split(",");
		int count = 0;
		for (int i=0; i<counts.length ; i++) {
			bmReactErrorRequest(Integer.parseInt(counts[i]), pagePaths[i], category[i]);
			page.waitForTimeout(2000);
			count = count + Integer.parseInt(counts[i]);
		}
		return count;
	}
	
	public void bmAngularLoadRequest(int num, String pagePath) throws NumberFormatException, EncryptedDocumentException, IOException {
		if(page.url().contains("://qa")){
			url = IPathConstant.BM_QA_URI;
			authorization = IPathConstant.BM_QA_BEARERTOKEN;
			teamId = IPathConstant.BM_QA_TEAMID;
		}
		else if(page.url().contains("://stg")){
			url = IPathConstant.BM_STG_URI;
			authorization = IPathConstant.BM_STG_BEARERTOKEN;
			teamId = IPathConstant.BM_STG_TEAMID;
		}
		String appName = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmDataValidationSheet, "angularApplicationName");
		String service = "{'name':'"+appName+"','teamID':'"+teamId+"','type':'B'}";
		String contentType = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmDataValidationSheet, "contentType");
		String endpoint = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmDataValidationSheet, "loadEndpoint");
		
		for(int j=0; j<num; j++ ) {
			BmAngularLoadPojo data = new BmAngularLoadPojo(pagePath, service);
			APIResponse response = requestContext.post(url+endpoint, 
					RequestOptions.create()
					.setHeader("content-type", contentType)
					.setHeader("teamid", teamId)
					.setHeader("Authorization", authorization)
					.setData(data));
			Assert.assertTrue(response.status() == 204);
		}
		System.out.println(num+" Load generated");
	}

	public void bmAngularErrorRequest(int num, String pagePath, String category) throws NumberFormatException, EncryptedDocumentException, IOException, InterruptedException {
		if(page.url().contains("://qa")){
			url = IPathConstant.BM_QA_URI;
			authorization = IPathConstant.BM_QA_BEARERTOKEN;
			teamId = IPathConstant.BM_QA_TEAMID;
		}
		else if(page.url().contains("://stg")){
			url = IPathConstant.BM_STG_URI;
			authorization = IPathConstant.BM_STG_BEARERTOKEN;
			teamId = IPathConstant.BM_STG_TEAMID;
		}	
		
		List<String> eventList = new ArrayList<>();
		List<String> userList = new ArrayList<>();
		int random = 0;
		String eventId;
		String userId;

		long timeStamp = System.currentTimeMillis();
		String appName = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmDataValidationSheet, "angularApplicationName");
		String service = "{'name':'"+appName+"','teamID':'"+teamId+"','type':'B'}";
		String contentType = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmDataValidationSheet, "contentType");
		String endpoint = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmDataValidationSheet, "errorEndpoint");
		
		for(int i=0; i<num; i++) {
		random = new Random().nextInt(1000);
		for(; ;){
			eventId = "ce2aa2bd-d275-4716-a0ad-86d5133f"+random;
			userId = "69637f2f-be83-4f52-b615-13cfa4bc4"+random;
			if(eventList.contains(eventId))
			random = new Random().nextInt(1000);
			else
			break;
		}
		//BMAngularErrorPojo data = new BMAngularErrorPojo(eventId, service, pagePath, category, timeStamp, userId);
		 String data = "{\n"
				    + " \"uniqueId\":\""+eventId+"\",\n"
				    + " \"service\":\""+service+"\",\n"
				    + " \"serviceVersion\":\""+excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmDataValidationSheet, "angularError_serviceVersion")+"\",\n"
				    + " \"pagePath\":\""+pagePath+"\",\n"
				    + " \"category\":\""+category+"\",\n"
				    + " \"grade\":\""+excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmDataValidationSheet, "angularError_grade")+"\",\n"
				    + " \"errorUrl\":\""+excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmDataValidationSheet, "angularError_errorUrl")+"\",\n"
				    + " \"message\":\"error category:"+category+"\r\nError: XMLHttpRequest method:GET, url: http://localhost:8080/user, status: 404\r\n\",\n"
				    + " \"stack\":\"loadend:Error\n    at XMLHttpRequest.xhrEvent (http://10.196.141.10:8083/vendor.js:58922:51)\n    at XMLHttpRequest.wrapped (http://10.196.141.10:8083/vendor.js:61850:21)\n    at _ZoneDelegate.invokeTask (http://10.196.141.10:8083/polyfills.js:415:31)\n    at Object.onInvokeTask (http://10.196.141.10:8083/vendor.js:37195:33)\n    at _ZoneDelegate.invokeTask (http://10.196.141.10:8083/polyfills.js:414:60)\n    at Zone.runTask (http://10.196.141.10:8083/polyfills.js:187:47)\n    at ZoneTask.invokeTask [as invoke] (http://10.196.141.10:8083/polyfills.js:496:34)\n    at invokeTask (http://10.196.141.10:8083/polyfills.js:1670:18)\n    at globalCallback (http://10.196.141.10:8083/polyfills.js:1701:29)\n    at XMLHttpRequest.globalZoneAwareCallback (http://10.196.141.10:8083/polyfills.js:1734:16)\",\n"
				    + " \"timestamp\":"+timeStamp+",\n"
				    + " \"environment\":\""+excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmDataValidationSheet, "angularError_environment")+"\",\n" 
				    + " \"level\":\""+excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmDataValidationSheet, "angularError_level")+"\",\n"
				    + " \"exception\":{\"type\":\"Error: XMLHttpRequest\",\"value\":\"method:GET, url: http://localhost:8080/user,\n      status: 404\",\"module\":\"\",\"thread_id\":0,\"stacktrace\":{\"frames\":[]}},\n"
				    + " \"errorName\":\"Error: XMLHttpRequest method:GET, url: http://localhost:8080/user, status: 404\",\"userAgent\":\""+excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmDataValidationSheet, "angularError_userAgent")+"\",\"sdk\":{\"name\":\""+excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmDataValidationSheet, "angularError_sdkName")+"\",\"version\":\""+excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmDataValidationSheet, "angularError_sdkVersion")+"\"},\n"
				    + " \"userId\":\""+userId+"\",\n"
				    + " \"countryCode\":\""+excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmDataValidationSheet, "angularError_countryCode")+"\",\n"
				    + " \"breadcrumbs\":[{\"timestamp\":"+timeStamp+",\"type\":\"Debug\",\"message\":\"Angular is running in development mode. Call enableProdMode() to enable production mode.\",\"level\":\"Info\",\"category\":\"console\"},\n"
				    + "                 {\"timestamp\":"+timeStamp+",\"type\":\"Navigation\",\"category\":\"navigation\",\"data\":[{\"key\":\"to\",\"value\":\"/\"},{\"key\":\"from\",\"value\":\"/\"}],\"level\":\"Info\"},\n"
				    + "                 {\"timestamp\":"+timeStamp+",\"type\":\"HTTP\",\"category\":\"xhr\",\"data\":[{\"key\":\"method\",\"value\":\"GET\"},{\"key\":\"url\",\"value\":\"http://10.196.141.10:8083/sockjs-node/info?t=1693813114441\"},\n"
				    + "                 {\"key\":\"status_code\",\"value\":200}],\n"
				    + " \"level\":\"Info\"},\n"
				    + " {\"timestamp\":"+timeStamp+",\n"
				    + " \"type\":\"HTTP\",\"category\":\"xhr\",\"data\":[{\"key\":\"method\",\"value\":\"GET\"},\n"
				    + " {\"key\":\"url\",\"value\":\"http://localhost:8080/user\"},\n"
				    + " {\"key\":\"status_code\",\"value\":404}],\n"
				    + " \"level\":\"Info\"},\n"
				    + " {\"timestamp\":"+timeStamp+",\"type\":\"Debug\",\"message\":\"oops [object Object]\",\"level\":\"Info\",\"category\":\"console\"},\n"
				    + " {\"type\":\"Error\",\"category\":\"exception\",\"level\":\"Error\",\"message\":\"Error: XMLHttpRequest method:GET<br/> url: http://localhost:8080/user<br/> status: 404\",\"timestamp\":"+timeStamp+"}],\n"
				    + " \"os\":\""+excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmDataValidationSheet, "angularError_os")+"\",\"device\":\""+excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmDataValidationSheet, "angularError_device")+"\",\"browser\":\""+excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmDataValidationSheet, "angularError_browser")+"\",\"syntheticUser\":false,\"traceId\":\""+excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmDataValidationSheet, "angularError_traceId")+"\"}";
		eventList.add(eventId);
		userList.add(userId);
		
		APIResponse response = requestContext.post(url+endpoint, 
				RequestOptions.create()
				.setHeader("content-type", contentType)
				.setHeader("teamid", teamId)
				.setHeader("Authorization", authorization)
				.setData(data));
		//System.out.println(response.status());
		Assert.assertTrue(response.status() == 204);
		}
		System.out.println(num + " Error generated");
	}
	
	public void bmReactLoadRequest(int num, String pagePath) throws NumberFormatException, EncryptedDocumentException, IOException {
		if(page.url().contains("://qa")){
			url = IPathConstant.BM_QA_URI;
			authorization = IPathConstant.BM_QA_BEARERTOKEN;
			teamId = IPathConstant.BM_QA_TEAMID;
		}
		else if(page.url().contains("://stg")){
			url = IPathConstant.BM_STG_URI;
			authorization = IPathConstant.BM_STG_BEARERTOKEN;
			teamId = IPathConstant.BM_STG_TEAMID;
		}
		String appName = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmDataValidationSheet, "reactApplicationName");
		String service = "{'name':'"+appName+"','teamID':'"+teamId+"','type':'B'}";
		String contentType = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmDataValidationSheet, "contentType");
		String endpoint = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmDataValidationSheet, "loadEndpoint");
		
		for(int j=0; j<num; j++ ) {
			BmReactLoadPojo data = new BmReactLoadPojo(pagePath, service);
			APIResponse response = requestContext.post(url+endpoint, 
					RequestOptions.create()
					.setHeader("content-type", contentType)
					.setHeader("teamid", teamId)
					.setHeader("Authorization", authorization)
					.setData(data));
			Assert.assertTrue(response.status() == 204);
		}
		System.out.println(num+" Load generated");
	}

	public void bmReactErrorRequest(int num, String pagePath, String category) throws NumberFormatException, EncryptedDocumentException, IOException, InterruptedException {
		if(page.url().contains("://qa")){
			url = IPathConstant.BM_QA_URI;
			authorization = IPathConstant.BM_QA_BEARERTOKEN;
			teamId = IPathConstant.BM_QA_TEAMID;
		}
		else if(page.url().contains("://stg")){
			url = IPathConstant.BM_STG_URI;
			authorization = IPathConstant.BM_STG_BEARERTOKEN;
			teamId = IPathConstant.BM_STG_TEAMID;
		}	
		
		List<String> eventList = new ArrayList<>();
		List<String> userList = new ArrayList<>();
		int random = 0;
		String eventId;
		String userId;

		long timeStamp = System.currentTimeMillis();
		String appName = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmDataValidationSheet, "reactApplicationName");
		String service = "{'name':'"+appName+"','teamID':'"+teamId+"','type':'B'}";
		String contentType = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmDataValidationSheet, "contentType");
		String endpoint = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmDataValidationSheet, "errorEndpoint");
		
		for(int i=0; i<num; i++) {
		random = new Random().nextInt(1000);
			for(; ;){
				eventId = "ff441062-2be1-480e-b41d-006d34379"+random;
				userId = "9e9b96ce-4a32-4161-"+random+"-f25031922cb9";
				if(eventList.contains(eventId))
					random = new Random().nextInt(1000);
				else
					break;
			}
			//BmReactErrorPojo data = new BmReactErrorPojo(eventId, service, pagePath, category, timeStamp, userId);
			String data = bmReactErrorApiBody(eventId, service, pagePath, category, timeStamp, userId);
			eventList.add(eventId);
			userList.add(userId);
			
			APIResponse response = requestContext.post(url+endpoint, 
					RequestOptions.create()
					.setHeader("content-type", contentType)
					.setHeader("teamid", teamId)
					.setHeader("Authorization", authorization)
					.setData(data));
			//System.out.println(response.status());
			Assert.assertTrue(response.status() == 204);
			}
			System.out.println(num + " Error generated");
		}
	
	public void validateUserIdAndEventId() throws EncryptedDocumentException, IOException {
		if(page.url().contains("://qa")){
			url = IPathConstant.BM_QA_URI;
			authorization = IPathConstant.BM_QA_BEARERTOKEN;
			teamId = IPathConstant.BM_QA_TEAMID;
		}
		else if(page.url().contains("://stg")){
			url = IPathConstant.BM_STG_URI;
			authorization = IPathConstant.BM_STG_BEARERTOKEN;
			teamId = IPathConstant.BM_STG_TEAMID;
		}	
		
		List<String> eventList = new ArrayList<>();
		List<String> userList = new ArrayList<>();
		int random = 0;
		String eventId;
		String userId;

		long timeStamp = System.currentTimeMillis();
		String appName = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmDataValidationSheet, "reactApplicationName");
		String service = "{'name':'"+appName+"','teamID':'"+teamId+"','type':'B'}";
		String contentType = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmDataValidationSheet, "contentType");
		String endpoint = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmDataValidationSheet, "errorEndpoint");
		
		for(int i=0; i<10; i++) {
		random = new Random().nextInt(1000);
			for(; ;){
				eventId = "ff441062-2be1-480e-b41d-006d34379"+random;
				userId = "9e9b96ce-4a32-4161-"+random+"-f25031922cb9";
				if(eventList.contains(eventId))
					random = new Random().nextInt(1000);
				else
					break;
			}
			String data = bmReactErrorApiBody(eventId, service, "/", "ajax", timeStamp, userId);
			eventList.add(eventId);
			userList.add(userId);
			
			APIResponse response = requestContext.post(url+endpoint, 
					RequestOptions.create()
					.setHeader("content-type", contentType)
					.setHeader("teamid", teamId)
					.setHeader("Authorization", authorization)
					.setData(data));
			//System.out.println(response.status());
			Assert.assertTrue(response.status() == 204);
			}
		System.out.println("Error generated");
		new BmApplicationPage(page).selectApplication(appName);
		page.waitForTimeout(2000);
		BmErrorsPage bmError = new BmErrorsPage(page);
		bmError.validateUserIdAndEventId(eventList, userList);
		
		}
	
	public void generateThePerformanceLoadWIthMultiplePagesAndValidate() throws NumberFormatException, EncryptedDocumentException, IOException {
		LinkedHashSet<String> paths = new LinkedHashSet<>();	
		if(page.url().contains("://qa")){
				url = IPathConstant.BM_QA_URI;
				authorization = IPathConstant.BM_QA_BEARERTOKEN;
				teamId = IPathConstant.BM_QA_TEAMID;
			}
			else if(page.url().contains("://stg")){
				url = IPathConstant.BM_STG_URI;
				authorization = IPathConstant.BM_STG_BEARERTOKEN;
				teamId = IPathConstant.BM_STG_TEAMID;
			}
			String appName = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmDataValidationSheet, "angularApplicationName");
			String service = "{'name':'"+appName+"','teamID':'"+teamId+"','type':'B'}";
			String contentType = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmDataValidationSheet, "contentType");
			String endpoint = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmDataValidationSheet, "loadEndpoint");
			String path = "";
			for(int j=0; j<30; j++ ) {
				path = "/path"+new Random().nextInt(1000);
				BmAngularLoadPojo data = new BmAngularLoadPojo(path, service);
				APIResponse response = requestContext.post(url+endpoint, 
						RequestOptions.create()
						.setHeader("content-type", contentType)
						.setHeader("teamid", teamId)
						.setHeader("Authorization", authorization)
						.setData(data));
				Assert.assertTrue(response.status() == 204);
				paths.add(path);
				page.waitForTimeout(100);
			}
			page.waitForTimeout(2000);
			System.out.println(paths.size()+" Load generated");
			page.waitForTimeout(2000);
			new BmApplicationPage(page).selectApplication(appName);
			new CommonPage(page).selectTheTimeLineFromCalender(IPathConstant.fiveMinutesTimeRange);
			page.waitForTimeout(2000);
			new BmPagesPage(page).validateThePagePaths(paths);
		}

	public void setApdexResponseTimeAndValidateApdexScoreByPushingLoad() throws EncryptedDocumentException, IOException {
		common.navigateToSettings();
		String adpexConfirmationMsg = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath, IPathConstant.messageSheet, "Bm_apdexConfigurationConfirmationMessage");
		String thresholdTime = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmApplicationSheet, "apdexThresholdTime");
		String appName = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmApplicationSheet, "bmApplicationName");
		SettingsPage setting = new SettingsPage(page);
		setting.navigateToApplicationPage();
		setting.setTheApdexConfigurationWithGivenResponseTime(thresholdTime, appName, adpexConfirmationMsg, "Browser monitoring");
		
		new CommonPage(page).navigateToBrowserMonitoring();
		String[] pagePaths = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmDataValidationSheet, "angularLoad_pagePaths").split(",");
		bmAngularLoadRequest(1, pagePaths[0]);
		page.waitForTimeout(60000);
		bmAngularLoadRequest(1, pagePaths[0]);
		page.waitForTimeout(5000);
		new BmApplicationPage(page).selectApplication(appName);
		new CommonPage(page).selectTheTimeLineFromCalender(IPathConstant.fiveMinutesTimeRange);
		//new BmApplicationPage(page).validateApdexScore(thresholdTime);
	}
	
	public String bmReactErrorApiBody(String eventId, String service, String pagePath, String category, long timeStamp, String userId) throws EncryptedDocumentException, IOException {
		return "{\"uniqueId\":\""+eventId+"\",\"service\":\""+service+"\",\"serviceVersion\":\""+excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmDataValidationSheet, "reactError_serviceVersion")+"\",\"pagePath\":\""+pagePath+"\",\"category\":\""+category+"\","
				+ "\"grade\":\""+excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmDataValidationSheet, "reactError_grade")+"\","
				+ "\"errorUrl\":\""+excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmDataValidationSheet, "reactError_errorUrl")+"\","
				+ "\"message\":\""+excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmDataValidationSheet, "reactError_message")+"\","
				+ "\"stack\":\""+excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmDataValidationSheet, "reactError_stack")+"\","
				+ "\"timestamp\":"+timeStamp+",\"environment\":\""+excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmDataValidationSheet, "reactError_environment")+"\","
				+ "\"level\":\""+excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmDataValidationSheet, "reactError_level")+"\","
				+ "\"exception\":{\"type\":\"Error:XMLHttpRequest\",\"value\":\"method:GET,url:http://localhost:8084/user1234,\\nstatus:0\",\"module\":\"\",\"thread_id\":0,\"stacktrace\":{\"frames\":[]}},\"errorName\":\"Error:XMLHttpRequestmethod:GET,url:http://localhost:8084/user1234,status:0\","
				+ "\"userAgent\":\""+excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmDataValidationSheet, "reactError_userAgent")+"\","
				+ "\"sdk\":{\"name\":\""+excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmDataValidationSheet, "reactError_sdkName")+"\",\"version\":\""+excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmDataValidationSheet, "reactError_sdkVersion")+"\"},"
				+ "\"userId\":\""+userId+"\",\"countryCode\":\""+excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmDataValidationSheet, "reactError_countryCode")+"\","
				+ "\"breadcrumbs\":[{\"timestamp\":1701689608691,\"type\":\"Debug\",\"message\":\"Warning:InvalidDOMproperty`%s`.Didyoumean`%s`?%sclassclassName\\natdiv\\natnav\\natNavbar\\natApp(http://localhost:3000/static/js/bundle.js:47:82)\\natRouter(http://localhost:3000/static/js/bundle.js:51963:15)\\natBrowserRouter(http://localhost:3000/static/js/bundle.js:50019:5)\",\"level\":\"Error\",\"category\":\"console\"},"
				+ "{\"timestamp\":1701689608692,\"type\":\"Debug\",\"message\":\"Warning:validateDOMNesting(...):%scannotappearasadescendantof<%s>.%s<a>a\\nata\\natli\\nata\\natLinkWithRef(http://localhost:3000/static/js/bundle.js:50131:7)\\natNavLinkWithRef(http://localhost:3000/static/js/bundle.js:50205:23)\\natul\\natnav\\natNavbar\\natApp(http://localhost:3000/static/js/bundle.js:47:82)\\natRouter(http://localhost:3000/static/js/bundle.js:51963:15)\\natBrowserRouter(http://localhost:3000/static/js/bundle.js:50019:5)\",\"level\":\"Error\",\"category\":\"console\"},"
				+ "{\"timestamp\":1701689608695,\"type\":\"Debug\",\"message\":\"Warning:InvalidDOMproperty`%s`.Didyoumean`%s`?%sfill-rulefillRule\\natpath\\natsvg\\nata\\natdiv\\natdiv\\natdiv\\natsection\\natHome(http://localhost:3000/static/js/bundle.js:1544:51)\\natRenderedRoute(http://localhost:3000/static/js/bundle.js:51403:5)\\natRoutes(http://localhost:3000/static/js/bundle.js:52025:5)\\natApp(http://localhost:3000/static/js/bundle.js:47:82)\\natRouter(http://localhost:3000/static/js/bundle.js:51963:15)\\natBrowserRouter(http://localhost:3000/static/js/bundle.js:50019:5)\",\"level\":\"Error\",\"category\":\"console\"},"
				+ "{\"timestamp\":1701689608695,\"type\":\"Debug\",\"message\":\"Warning:InvalidDOMproperty`%s`.Didyoumean`%s`?%sclip-ruleclipRule\\natpath\\natsvg\\nata\\natdiv\\natdiv\\natdiv\\natsection\\natHome(http://localhost:3000/static/js/bundle.js:1544:51)\\natRenderedRoute(http://localhost:3000/static/js/bundle.js:51403:5)\\natRoutes(http://localhost:3000/static/js/bundle.js:52025:5)\\natApp(http://localhost:3000/static/js/bundle.js:47:82)\\natRouter(http://localhost:3000/static/js/bundle.js:51963:15)\\natBrowserRouter(http://localhost:3000/static/js/bundle.js:50019:5)\",\"level\":\"Error\",\"category\":\"console\"},"
				+ "{\"timestamp\":1701689608695,\"type\":\"Debug\",\"message\":\"Warning:InvalidDOMproperty`%s`.Didyoumean`%s`?%sstroke-linecapstrokeLinecap\\natpath\\natsvg\\nata\\natdiv\\natdiv\\natdiv\\natsection\\natHome(http://localhost:3000/static/js/bundle.js:1544:51)\\natRenderedRoute(http://localhost:3000/static/js/bundle.js:51403:5)\\natRoutes(http://localhost:3000/static/js/bundle.js:52025:5)\\natApp(http://localhost:3000/static/js/bundle.js:47:82)\\natRouter(http://localhost:3000/static/js/bundle.js:51963:15)\\natBrowserRouter(http://localhost:3000/static/js/bundle.js:50019:5)\",\"level\":\"Error\",\"category\":\"console\"},"
				+ "{\"timestamp\":1701689608695,\"type\":\"Debug\",\"message\":\"Warning:InvalidDOMproperty`%s`.Didyoumean`%s`?%sstroke-linejoinstrokeLinejoin\\natpath\\natsvg\\nata\\natdiv\\natdiv\\natdiv\\natsection\\natHome(http://localhost:3000/static/js/bundle.js:1544:51)\\natRenderedRoute(http://localhost:3000/static/js/bundle.js:51403:5)\\natRoutes(http://localhost:3000/static/js/bundle.js:52025:5)\\natApp(http://localhost:3000/static/js/bundle.js:47:82)\\natRouter(http://localhost:3000/static/js/bundle.js:51963:15)\\natBrowserRouter(http://localhost:3000/static/js/bundle.js:50019:5)\",\"level\":\"Error\",\"category\":\"console\"},"
				+ "{\"timestamp\":1701689608695,\"type\":\"Debug\",\"message\":\"Warning:InvalidDOMproperty`%s`.Didyoumean`%s`?%sstroke-widthstrokeWidth\\natpath\\natsvg\\nata\\natdiv\\natdiv\\natdiv\\natsection\\natHome(http://localhost:3000/static/js/bundle.js:1544:51)\\natRenderedRoute(http://localhost:3000/static/js/bundle.js:51403:5)\\natRoutes(http://localhost:3000/static/js/bundle.js:52025:5)\\natApp(http://localhost:3000/static/js/bundle.js:47:82)\\natRouter(http://localhost:3000/static/js/bundle.js:51963:15)\\natBrowserRouter(http://localhost:3000/static/js/bundle.js:50019:5)\",\"level\":\"Error\",\"category\":\"console\"},"
				+ "{\"timestamp\":1701689608726,\"type\":\"HTTP\",\"category\":\"xhr\",\"data\":[{\"key\":\"method\",\"value\":\"GET\"},{\"key\":\"url\",\"value\":\"http://localhost:8084/user1234\"},{\"key\":\"status_code\",\"value\":0}],\"level\":\"Info\"},{\"type\":\"Error\",\"category\":\"exception\",\"level\":\"Error\",\"message\":\"Error:XMLHttpRequestmethod:GET<br/>url:http://localhost:8084/user1234<br/>status:0\",\"timestamp\":1701689608726}],"
				+ "\"os\":\""+excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmDataValidationSheet, "reactError_os")+"\","
				+ "\"device\":\""+excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmDataValidationSheet, "reactError_device")+"\","
				+ "\"browser\":\""+excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmDataValidationSheet, "reactError_browser")+"\",\"syntheticUser\":false,"
						+ "\"traceId\":\""+excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmDataValidationSheet, "reactError_traceId")+"\"}";
	}
}

//System.out.println("Status code : "+response.status());
//System.out.println("Status code text : "+response.statusText());
//System.out.println(response.body());
//JsonNode respBody = objMap.readTree(response.body());
//System.out.println("Response body - JsonNode format : "+respBody);
//String status = respBody.get("status").asText();
//System.out.println("Status attribute from response body : "+status);

