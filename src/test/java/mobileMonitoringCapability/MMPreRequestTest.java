package mobileMonitoringCapability;

import java.io.IOException;

import org.testng.annotations.Test;

import com.microsoft.playwright.Page;

import api.MMAPIRequests;
import genericUtilities.ExcelUtility;
import genericUtilities.IPathConstant;
import genericUtilities.JavaUtility;
import playWrightFactory.BaseClass;

public class MMPreRequestTest extends BaseClass{
	ExcelUtility excel=new ExcelUtility();
	@Test
	public void createNewUser() throws IOException
	{
		MMAPIRequests requestPage =new MMAPIRequests();
		String app = System.getenv("Application");
		excel.wrightDataToExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmCrashesSheet ,"application",app);
		page.waitForTimeout(1000);
	
		String[] appVersionsForAndroid = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath, IPathConstant.mmLoadSheet, "appVersionsForAndroid").split(",");
		String[] appVersionsForIos = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath, IPathConstant.mmLoadSheet, "appVersionsForIos").split(",");
		String[] devicesForAndroid = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath, IPathConstant.mmLoadSheet, "devicesForAndroid").split(",");
		String[] countriesForAndroid = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath, IPathConstant.mmLoadSheet, "countriesForAndroid").split(",");
		String[] crashesForAndroid =excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath, IPathConstant.mmLoadSheet, "crashesForAndroid").split(",");
		String[] httpRequestsForAndroid=excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath, IPathConstant.mmLoadSheet, "httpRequestsForAndroid").split(",");
		String[] devicesForIos = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath, IPathConstant.mmLoadSheet, "devicesForIos").split(",");
		String[] countriesForIos = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath, IPathConstant.mmLoadSheet, "countriesForIos").split(",");
		String[] crashesForIos =excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath, IPathConstant.mmLoadSheet, "crashesForIos").split(",");
		String[] httpRequestsForIos = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath, IPathConstant.mmLoadSheet, "httpRequestsForIos").split(",");
		int AndroidNewUserCount = Integer.parseInt(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath, IPathConstant.mmLoadSheet, "androidNewUserCount"));
		int IosNewUserCount = Integer.parseInt(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath, IPathConstant.mmLoadSheet, "IosNewUserCount"));
		String application = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath, IPathConstant.mmCrashesSheet, "application");
		String[] os = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath, IPathConstant.mmLoadSheet, "osType").split(",");
		String platformForAndroid = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath, IPathConstant.mmLoadSheet, "AndroidPlatform");
		String platformForIos = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath, IPathConstant.mmLoadSheet, "IOSPlatform");
		String[] status = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath, IPathConstant.mmLoadSheet, "KPIStatus").split(",");
		String responseTimeForAndroid = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath, IPathConstant.mmLoadSheet, "responseTimeForAndroid");
		String responseTimeForIos = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath, IPathConstant.mmLoadSheet, "responseTimeForIos");
		String[] statusCode = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath, IPathConstant.mmLoadSheet, "statusCode").split(",");
		String userIDForPerformanceCall = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath, IPathConstant.mmLoadSheet, "AndroidUserId0");
		
		String[] httpRequestForPerformance = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath, IPathConstant.mmLoadSheet, "httpRequestsForPerformance").split(",");
		String stackTrace = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath, IPathConstant.mmLoadSheet, "stackTrace");
		String memoryUsageForAndroid = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath, IPathConstant.mmLoadSheet, "memoryUsageForAndroid");
		String memoryUsageforIos = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath, IPathConstant.mmLoadSheet, "memoryUsageforIos");
		
		
	//trigger load for New users, app Launches and KPIs for android
		
		for(int i=0;i<AndroidNewUserCount;i++)
		{
			String userId = requestPage.regesterNewUser(page,appVersionsForAndroid[i],platformForAndroid,os[0],devicesForAndroid[i],application,countriesForAndroid[i],httpRequestsForAndroid[i],status[i],responseTimeForAndroid,statusCode[i]);
			excel.wrightDataToExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet ,"AndroidUserId"+i,userId);
			page.waitForTimeout(2000);
		}

		
		//trigger load for New users, app Launches and KPIs for IOS
		
		for(int i=0;i<IosNewUserCount;i++)
		{
			String userID = requestPage.regesterNewUser(page,appVersionsForIos[i],platformForIos,os[1],devicesForIos[i],application,countriesForIos[i],httpRequestsForIos[i],status[i],responseTimeForIos,statusCode[i]);
			excel.wrightDataToExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet ,"IOSUserId"+i,userID);
			
			page.waitForTimeout(2000);
		}
		
		//trigger load for Top http requests
		
				for(int i=0;i<httpRequestForPerformance.length;i++)
				{
					
					requestPage.performanceRequest(page,appVersionsForAndroid[0],platformForAndroid,os[0],devicesForAndroid[0],application,countriesForAndroid[0],httpRequestForPerformance[0],status[i],responseTimeForAndroid,statusCode[i],userIDForPerformanceCall.split(",")[0]);
					page.waitForTimeout(3000);
				}
				
				ExcelUtility eutil=new ExcelUtility();
				JavaUtility jutil=new JavaUtility();

				
				
		
		//trigger the crashes for Android and Ios
				int count = 0;
				for(int i=0;i<crashesForAndroid.length;i++)
				{	

					String[] andriodID = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath, IPathConstant.mmLoadSheet, "AndroidUserId"+count).split(",");
					System.out.println(andriodID[0]+"------"+andriodID[1]+"------"+crashesForAndroid[i]+"------"+stackTrace+"------"+memoryUsageForAndroid+"------"+os[0]+"------"+platformForAndroid+"------"+appVersionsForAndroid[count]+"------"+countriesForAndroid[count]+"------"+devicesForAndroid[count]);
					requestPage.crashRequest(page, application,andriodID[0],andriodID[1],crashesForAndroid[i],stackTrace,Long.parseLong(memoryUsageForAndroid),os[0],platformForAndroid,appVersionsForAndroid[count],countriesForAndroid[count],devicesForAndroid[count]);
					String[] iosID = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath, IPathConstant.mmLoadSheet, "IosUserId"+count).split(",");
				
					page.waitForTimeout(3000);
					
					System.out.println(iosID[0]+"------"+iosID[1]+"------"+crashesForIos[i]+"------"+stackTrace+"------"+Long.parseLong(memoryUsageforIos)+"------"+os[1]+"------"+platformForIos+"------"+appVersionsForIos[count]+"------"+countriesForIos[count]+"------"+devicesForIos[count]);
					requestPage.crashRequest(page, application,iosID[0],iosID[1],crashesForIos[i],stackTrace,Long.parseLong(memoryUsageforIos),os[1],platformForIos,appVersionsForIos[count],countriesForIos[count],devicesForIos[count]);
					System.out.println("count  :"+ count);
					System.out.println(i%2);
					if(i!=0 && i%2 != 0)
					{
						count++;
					}
					page.waitForTimeout(3000);
				
				}
		
		
				eutil.wrightDataToExcelByUsingKeyProperty(IPathConstant.MMexcelPath, IPathConstant.mmLoadSheet, "LastOccurred",jutil.getTheSystemDateAndTime("dd/MM/yyy HH:mm") );
				eutil.wrightDataToExcelByUsingKeyProperty(IPathConstant.MMexcelPath, IPathConstant.mmLoadSheet, "LastOccurred1",jutil.getTheCustomeTimeAndDateBasedOnTheCurrentSystemTime("dd/MM/yyy HH:mm",1,0,0,0,0,0,0) );
		
	}

}
