package alerts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.microsoft.playwright.APIRequest;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.RequestOptions;

import api.MMAPIRequests;
import genericUtilities.ExcelUtility;
import genericUtilities.IPathConstant;
import objectRepository.HomePage;
import objectRepository.Alerts.AlertsPage;
import playWrightFactory.BaseClass;
import pojoRepository.BM.BmAngularLoadPojo;

public class Alerts_Pre_RequestTest extends BaseClass {

	ExcelUtility excel=new ExcelUtility();
	Playwright playWright = Playwright.create();
	APIRequest request = playWright.request();
	APIRequestContext requestContext = request.newContext();
	ObjectMapper objMap = new ObjectMapper();
	
	String url;
	String authorization;
	String teamId;
	
	@Test(groups = {"Alerts", "Regression"})
	public void TC_01_Creat_APM_Applications() throws IOException
	{
		 String env=page.url();
         if(env.startsWith("https://qa"))
         {
              Runtime.getRuntime().exec(new String[]{"bash","-c","cd /var/lib/jenkins/workspace/Alerts_Regression_TestSuite/ && sh ApplicatioCreation_QA.json"});
         }
         else if(env.startsWith("https://stg"))
         {
             Runtime.getRuntime().exec(new String[]{"bash","-c","cd /var/lib/jenkins/workspace/Alerts_Regression_TestSuite/ && sh ApplicatioCreation_STG.json"});
         }
         page.reload();
         page.waitForTimeout(5000);
         
	}
	
	
	@Test(groups = {"Alerts", "Regression"})
	public void TC_03_Create_MM_Applications() throws IOException
	{
		String androidApplication = System.getenv("MMAndroidApplication");
		String iosApplication = System.getenv("MMIosApplication");
//		String androidApplication = "Alerts_Android";
//		String iosApplication = "Alerts_IOS";
		
		MMAPIRequests requestPage =new MMAPIRequests();
		requestPage.regesterNewUser(page,"9.9.9","222","Ios","apple",iosApplication,"US","www.ios.com","true","1000","200");
		
		requestPage.regesterNewUser(page,"6.6.6","222","Android","Vivo",androidApplication,"US","www.Android.com","true","1000","200");
	}
	
	@Test(groups = {"Alerts", "Regression"})
	public void TC_04_Create_BM_Applications() throws IOException
	{
		String angularApplication = System.getenv("BMAngularApplication");
		String reactApplication = System.getenv("BMReactApplication");
//		String angularApplication = "Alets_Angular";
//		String reactApplication = "Alets_React";
		
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
			String name = angularApplication+","+reactApplication;
			//create angular application 
			for(int i=0;i<name.split(",").length;i++)
			{
			String appName = name.split(",")[i];
			String service = "{'name':'"+appName+"','teamID':'"+teamId+"','type':'B'}";
			String contentType = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmDataValidationSheet, "contentType");
			String endpoint = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmDataValidationSheet, "loadEndpoint");
			
				BmAngularLoadPojo data = new BmAngularLoadPojo("/alerts", service);
				APIResponse response = requestContext.post(url+endpoint, 
						RequestOptions.create()
						.setHeader("content-type", contentType)
						.setHeader("teamid", teamId)
						.setHeader("Authorization", authorization)
						.setData(data));
				Assert.assertTrue(response.status() == 204);
			}
			System.out.println(" Load generated");
			
			
	}
		
	

}





