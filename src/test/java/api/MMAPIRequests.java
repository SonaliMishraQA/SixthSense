package api;

import java.io.IOException;
import java.util.Random;

import org.testng.Assert;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;
import com.microsoft.playwright.APIRequest;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.RequestOptions;

import genericUtilities.IPathConstant;
import genericUtilities.JavaUtility;
import objectRepository.MM.MMCrashesPage;
import playWrightFactory.PlaywrightFactory;
import pojoRepository.MMCrashPojo;
import pojoRepository.MMLaunchPojo;
import pojoRepository.MMPerformancePojo;
import pojoRepository.MMUserRegestrationPojo;

public class MMAPIRequests {
	
	JavaUtility jutil=new JavaUtility();
	
	Playwright playWright1 = Playwright.create();
	
	public String regesterNewUser(Page page,String version,String platform,String os,String device,String application,String country,String httpRequest,String status,String responseTime,String statusCode) throws IOException
	{
		APIRequest request = playWright1.request();
		APIRequestContext requestContext = request.newContext();
		ObjectMapper objMap = new ObjectMapper();

		String url=page.url();
		String uri="";
		String teamId="";
		String bearerToken="";
		
		//https://stg-http-collector-observability.sixthsense.rakuten.com/mobile";
		String userRegestrationEndPoint = "/mobile/management/userregistration";
		String apLaunchEndpoint = "/mobile/event";
		if(url.startsWith("https://stg"))
		{
			uri=IPathConstant.MOBILE_STG_URI;
			bearerToken=IPathConstant.MOBILE_STG_ACCESSTOKEN;
			teamId=IPathConstant.MOBILE_STG_TEAMID;
			
		}else if (url.startsWith("https://qa"))
		{
			uri=IPathConstant.MOBILE_QA_URI;
			bearerToken=IPathConstant.MOBILE_QA_ACCESSTOKEN;
			teamId=IPathConstant.MOBILE_QA_TEAMID;
			
		}else if (url.startsWith("https://perf"))
		{
			uri=IPathConstant.MOBILE_PERF_URI;
			bearerToken=IPathConstant.MOBILE_PERF_ACCESSTOKEN;
			teamId=IPathConstant.MOBILE_PERF_TEAMID;
		}
		
		String userID="";String sessionID="";
		Random ran =new Random();
		int ranNumber=ran.nextInt((9999 - 100) + 1) + 10;
	         userID = "D5D1B44D-"+ranNumber+"-45D9-"+ranNumber+"-1C88330BD8BF";
			sessionID = "0C7"+ranNumber+"648-E8CE-FD6-AB7D-10C"+ranNumber+"BCFDB";
		long time=System.currentTimeMillis();
		String service="{'name':'"+application+"','teamID':'"+teamId+"','type':'M'}";
		

		//initialise the appLaunch payload
		 String Body1 = "{\n" +
	                "    \"startTime\":\""+time+"\" ,\n" +
	                "    \"device\": \""+device+"\",\n" +
	                "    \"service\": \""+service+"\",\n" +
	                "    \"serviceVersion\": \""+version+"\",\n" +
	                "    \"country\": \""+country+"\",\n" +
	                "    \"name\": \"App_Launched\",\n" +
	                "    \"platform\": \""+platform+"\",\n" +
	                "    \"userId\": \""+userID+"\",\n" +
	                "    \"os\": \""+os+"\",\n" +
	                "    \"sessionId\": \""+sessionID+"\"\n" +
	                "}";
		 //set the header and payload details
		APIResponse response1 = requestContext.post(uri+ apLaunchEndpoint, 
				RequestOptions.create()
				.setHeader("content-type", "application/json")
				.setHeader("teamid", teamId)
				.setHeader("Authorization",bearerToken )
				.setData(Body1));
		//print the response 
		System.out.println("Status code : "+response1.status());
		Assert.assertEquals(response1.status(), 200);
		System.out.println("Status code text : "+response1.statusText());
		JsonNode respBody1 = objMap.readTree(response1.body());
		System.out.println("Response body - JsonNode format : "+respBody1);
		// Get the value for response1.status() == 200..299{
		// call user registrartion
		
	    ////} else {
		  // log the error and break
	    /////}
		System.out.println("=============app launch performed==========");	
		
		page.waitForTimeout(2500);
		
		// initialise the new user payload
		 String Body = "{\n"
					+ "    \"serviceVersion\": \""+version+"\",\n"
					+ "    \"userId\": \""+userID+"\",\n"
					+ "    \"platform\": \""+platform+"\",\n"
					+ "    \"device\": \""+device+"\",\n"
					+ "    \"registrationTime\": "+time+",\n"
					+ "    \"os\": \""+os+"\",\n"
					+ "    \"service\": \"{'name':'"+application+"','teamID':'"+teamId+"','type':'M'}\",\n"
					+ "    \"country\": \""+country+"\"\n"
					+ "}";
			//set header details and payload						
			APIResponse response = requestContext.post(uri+ userRegestrationEndPoint, 
					RequestOptions.create()
					.setHeader("content-type", "application/json")
					.setHeader("teamid", teamId)
					.setHeader("Authorization",bearerToken )
					.setData(Body));
			//print the response 
			System.out.println("Status code : "+response.status());
			Assert.assertEquals(response.status(), 200);
			System.out.println("Status code text : "+response.statusText());
			System.out.println(response.body());
			JsonNode respBody = objMap.readTree(response.body());
			System.out.println("Response body - JsonNode format : "+respBody);
			
			System.out.println("=============new user created==========");
			
	
			page.waitForTimeout(2500);
			
			MMPerformancePojo data2=new MMPerformancePojo(status,time,httpRequest,platform,responseTime,device,statusCode,os,httpRequest,"0",service,country,version,"1",userID);
			APIResponse response2 = requestContext.post(uri+ "/mobile/performance", 
					RequestOptions.create()
					.setHeader("content-type", "application/json")
					.setHeader("teamid", teamId)
					.setHeader("Authorization",bearerToken )
					.setData(data2));
			
			System.out.println("Status code : "+response2.status());
			Assert.assertEquals(response2.status(), 200);
			System.out.println("Status code text : "+response2.statusText());
			System.out.println("=============performance call triggred==========");
			
			
			page.waitForTimeout(2500);
			return userID+","+sessionID;
			
			
		
	}
	
	public void performanceRequest(Page page,String version,String platform,String os,String device,String application,String country,String httpRequest,String status,String responseTime,String statusCode,String userID)
	{
		APIRequest request = playWright1.request();
		APIRequestContext requestContext = request.newContext();
		ObjectMapper objMap = new ObjectMapper();

		String url=page.url();
		String uri="";
		String teamId="";
		String bearerToken="";
	
		if(url.startsWith("https://stg"))
		{
			uri=IPathConstant.MOBILE_STG_URI;
			bearerToken=IPathConstant.MOBILE_STG_ACCESSTOKEN;
			teamId=IPathConstant.MOBILE_STG_TEAMID;
			
		}else if (url.startsWith("https://qa"))
		{
			uri=IPathConstant.MOBILE_QA_URI;
			bearerToken=IPathConstant.MOBILE_QA_ACCESSTOKEN;
			teamId=IPathConstant.MOBILE_QA_TEAMID;
			
		}else if (url.startsWith("https://perf"))
		{
			uri=IPathConstant.MOBILE_PERF_URI;
			bearerToken=IPathConstant.MOBILE_PERF_ACCESSTOKEN;
			teamId=IPathConstant.MOBILE_PERF_TEAMID;
		}
		long time=System.currentTimeMillis();
		String service="{'name':'"+application+"','teamID':'"+teamId+"','type':'M'}";
		MMPerformancePojo data2=new MMPerformancePojo(status,time,httpRequest,platform,responseTime,device,statusCode,os,httpRequest,"0",service,country,version,"1",userID);
		APIResponse response2 = requestContext.post(uri+ "/mobile/performance", 
				RequestOptions.create()
				.setHeader("content-type", "application/json")
				.setHeader("teamid", teamId)
				.setHeader("Authorization",bearerToken )
				.setData(data2));
		
		System.out.println("Status code : "+response2.status());
		Assert.assertEquals(response2.status(), 200);
		System.out.println("Status code text : "+response2.statusText());
		
		System.out.println("=============performance call for androd user triggred==========");
		page.waitForTimeout(3000);
	}
	
	public void crashRequest(Page page,String application,String userID,String sessionID,String crashReason,String stackTrace,long memoryUsage,String os,String platform,String version,String country,String device) throws IOException
	{
		APIRequest request = playWright1.request();
		APIRequestContext requestContext = request.newContext();
		ObjectMapper objMap = new ObjectMapper();

		String url=page.url();
		String uri="";
		String teamId="";
		String bearerToken="";
		if(url.startsWith("https://stg"))
		{
			uri=IPathConstant.MOBILE_STG_URI;
			bearerToken=IPathConstant.MOBILE_STG_ACCESSTOKEN;
			teamId=IPathConstant.MOBILE_STG_TEAMID;
			
		}else if (url.startsWith("https://qa"))
		{
			uri=IPathConstant.MOBILE_QA_URI;
			bearerToken=IPathConstant.MOBILE_QA_ACCESSTOKEN;
			teamId=IPathConstant.MOBILE_QA_TEAMID;
			
		}else if (url.startsWith("https://perf"))
		{
			uri=IPathConstant.MOBILE_PERF_URI;
			bearerToken=IPathConstant.MOBILE_PERF_ACCESSTOKEN;
			teamId=IPathConstant.MOBILE_PERF_TEAMID;
		}
		long time=System.currentTimeMillis();
		String service="{'name':'"+application+"','teamID':'"+teamId+"','type':'M'}";

	//	MMCrashPojo data=new MMCrashPojo(userID,sessionID,time,crashReason,stackTrace,memoryUsage,os,platform,version,service,country,device);
		
		String Body = "[\n"
			    + "  {\n"
			    + "    \"uniqueId\": \""+userID+"\",\n"
			    +"      \"crashId\": \""+crashReason+"\",\n" 
			    + "    \"sessionId\": \""+sessionID+"\",\n"
			    + "    \"crashTime\": "+time+",\n"
			    + "    \"crashReason\": \""+crashReason+"\",\n"
			    + "    \"fileName\": \"MainActivity.kt\",\n"
			    + "    \"lineNo\": \"57\",\n"
			    + "    \"crashStackTrace\": \""+stackTrace+"\",\n"
			    + "    \"memoryUsage\":"+memoryUsage+",\n"
			    + "    \"os\": \""+os+"\",\n"
			    + "    \"platform\": \""+platform+"\",\n"
			    + "    \"serviceVersion\": \""+version+"\",\n"
			    + "    \"deviceInfo\": \""+device+"\",\n"
			    + "    \"service\": \"{'name':'"+application+"','teamID':'"+teamId+"','type':'M'}\",\n"
			    + "    \"country\": \""+country+"\"\n"
			    + "  }\n"
			    + "]";
		
		APIResponse response = requestContext.post(uri+ "/mobile/crashReports", 
				RequestOptions.create()
				.setHeader("content-type", "application/json")
				.setHeader("teamid", teamId)
				.setHeader("Authorization",bearerToken )
				.setData(Body));
		
		//JsonObject js = new JsonObject();
		
		System.out.println(response.text());
		System.out.println("Status code : "+response.status());
		Assert.assertEquals(response.status(), 200);
		System.out.println("Status code text : "+response.statusText());
		JsonNode respBody = objMap.readTree(response.body());
		System.out.println("Response body - JsonNode format : "+respBody);
		
		System.out.println("=============crash call triggred==========");
		page.waitForTimeout(3000);
		
	}
}