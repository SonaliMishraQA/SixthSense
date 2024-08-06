package apmCapability;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;
import genericUtilities.ExcelUtility;
import genericUtilities.IPathConstant;
import objectRepository.SettingsPage;
import playWrightFactory.BaseClass;

public class APMPreRequestsTest extends BaseClass {
	
	SettingsPage setPage;
	ExcelUtility eutil=new ExcelUtility();
	
	
	@Test(groups = {"APM", "Regression"})
	public void TC_01_set_The_Apdex_Configuration_Response_Time_Threshold_Value() throws EncryptedDocumentException, IOException
	{
		setPage=new SettingsPage(page);
		
		//navigate to setting capability
		commPage.navigateToSettings();
		
		//navigate to the application  page		
		setPage.navigateToApplicationPage();
		
		setPage.setTheApdexConfigurationWithGivenResponseTime(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.apmApplicationSheet, "APMResponseTime"),
															eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.apmApplicationSheet, "application"),
															eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath, IPathConstant.messageSheet, "Settings_ResponseTimeThresholdValue"),IPathConstant.alertsAPMCapability);
				
	}
	@Test(groups = {"APM", "Regression"})
	public void TC_02_set_Trace_Latency_Value() throws EncryptedDocumentException, IOException
	{
		setPage=new SettingsPage(page);
		//navigate to setting capability
		commPage.navigateToSettings();
				
		//navigate to the application  page		
		setPage.navigateToApplicationPage();
		
		//set the trace latency 
		setPage.setTraceLatency(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.apmApplicationSheet, "miniumTracelatency"),
				eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.apmApplicationSheet, "maximumSpans"),
				eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath, IPathConstant.messageSheet, "Settings-Teace Retention message"),
				eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.apmApplicationSheet, "application"));
	}
	
	@Test(groups = {"APM", "Regression"})
	public void TC_03_set_The_Database_Query_Latency() throws EncryptedDocumentException, IOException
	{
		setPage=new SettingsPage(page);
		
		//navigate to setting capability
		commPage.navigateToSettings();
						
		//navigate to the application  page		
		setPage.navigateToApplicationPage();
		
		//set the trace latency 
		setPage.setDBQueryLatency(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.apmApplicationSheet, "miniumTracelatency"),
						eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath, IPathConstant.messageSheet, "Settings-Teace Retention message"),
						eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.apmApplicationSheet, "application"));
	}
	
	@Test(groups = {"APM", "Regression"})
	public void TC_04_push_The_APM_Load() throws IOException
	{
		 String env=page.url();
         for( int i=0;i<20;i++)
         {
         if(env.startsWith("https://qa"))
         {
             Runtime.getRuntime().exec(new String[]{"bash","-c","cd /var/lib/jenkins/workspace/APM_Regression_TestSuite/ && sh autscript_QA.json && sh GoodApdex_QA.json && sh FairApdex_QA.json && sh PoorApdex_QA.json"});
             
         }
         else if(env.startsWith("https://stg"))
         {
             Runtime.getRuntime().exec(new String[]{"bash","-c","cd /var/lib/jenkins/workspace/APM_Regression_TestSuite/ && sh autscript_STG.json && sh GoodApdex_STG.json && sh FairApdex_STG.json && sh PoorApdex_STG.json"});
            
         }
              page.waitForTimeout(2000);
         }
         page.reload();
         page.waitForTimeout(5000);
         
	}

}
