package apmCapability;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import genericUtilities.ExcelUtility;
import genericUtilities.IPathConstant;
import objectRepository.CommonPage;
import objectRepository.HomePage;
import objectRepository.SettingsPage;
import objectRepository.APM.ApmApplicationPage;
import playWrightFactory.BaseClass;

public class APMDashBoardApplicationDataValidationTest extends BaseClass{
	
	SettingsPage setPage;
	ExcelUtility eutil;
	ApmApplicationPage appPage;
	
	@BeforeMethod
	public void preRequest() throws EncryptedDocumentException, IOException
	{
		setPage = new SettingsPage(page);
		eutil= new ExcelUtility();
		appPage =new ApmApplicationPage(page);
		commPage=new CommonPage(page);
		
		//Navigate to APM capability
		commPage.navigateToApm();
		
		page.waitForLoadState();
		
		//navigate to dashboard page
		appPage.navigateToDashBoardTab();
		
		page.waitForLoadState();
		
		//navigate to Application page
		appPage.navigateToApplicationPage();
		
		//select the Time line 
		commPage.selectTheTimeLineFromCalender(IPathConstant.sixHoursTimeRange);
	}
	
	@Test(groups = {"APM", "Regression"})
	public void TC_01_validate_The_Good_Apdex_Score() throws EncryptedDocumentException, IOException
	{	

		//select the Application
		appPage.selectTheApplicationForAPM(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.apmApplicationSheet, "applicationForGoodApdex"));
		
		//validate the apdex score for good
		appPage.validateApdexValue(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.apmApplicationSheet, "GoodApdexSatisfiedCalls"),
									eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.apmApplicationSheet, "GoodApdexTolaratedCalls"),
									eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.apmApplicationSheet, "GoodApdexFrustedCalls"));
		
	}
	
	@Test(groups = {"APM", "Regression"})
	public void TC_02_validate_The_Fair_Apdex_Score() throws EncryptedDocumentException, IOException
	{	

		//select the Application
		appPage.selectTheApplicationForAPM(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.apmApplicationSheet, "applicationForFairApdex"));
		 
		//validate the apdex score for good
		appPage.validateApdexValue(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.apmApplicationSheet, "FairApdexSatisfiedCalls"),
											eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.apmApplicationSheet, "FairApdexTolaratedCalls"),
											eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.apmApplicationSheet, "FairApdexFrustedCalls"));
				
	}
	
	@Test(groups = {"APM", "Regression"})
	public void TC_03_validate_The_Poor_Apdex_Score() throws EncryptedDocumentException, IOException
	{	

		//select the Application
		appPage.selectTheApplicationForAPM(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.apmApplicationSheet, "applicationForPoorApdex"));
		 
		//validate the apdex score for good
		appPage.validateApdexValue(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.apmApplicationSheet, "PoorApdexSatisfiedCalls"),
													eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.apmApplicationSheet, "PoorApdexTolaratedCalls"),
													eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.apmApplicationSheet, "PoorApdexFrustedCalls"));
							
	}
	
	@Test(groups = {"APM", "Regression"})
	public void TC_04_validate_The_Load_Widget_Calls_Value() throws EncryptedDocumentException, IOException
	{
		
		//select the Application
		appPage.selectTheApplicationForAPM(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.apmApplicationSheet, "application"));
				
				
		//validate the total calls on load graph
		appPage.validateTotalCallsOnLoadWidget(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.apmApplicationSheet, "APMTotalCalls"));

	}
	
	@Test(groups = {"APM", "Regression"})
	public void TC_05_validate_The_Load_Widget_Calls_Per_Min_Value() throws EncryptedDocumentException, IOException
	{
		
		//select the Application
		appPage.selectTheApplicationForAPM(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.apmApplicationSheet, "application"));
				
				
		//validate the call/min of load graph
		appPage.validateTotalCallsPerMinOnLoadWidget();
				
			
	}
	
	@Test(groups = {"APM", "Regression"})
	public void TC_06_validate_The_Error_Widget_Total_Errors() throws EncryptedDocumentException, IOException
	{	
		//select the Application
		appPage.selectTheApplicationForAPM(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.apmApplicationSheet, "application"));
				

		//validate the total errors on error graph
		appPage.validateTotalErrorCallsOnErrorWidget(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.apmApplicationSheet, "APMErrorCalls"));

	}
	
	@Test(groups = {"APM", "Regression"})
	public void TC_07_validate_The_Error_Widge_Errors_Per_Min() throws EncryptedDocumentException, IOException
	{
		//select the Application
		appPage.selectTheApplicationForAPM(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.apmApplicationSheet, "application"));
				
				
		//validate the total errors on error graph
		appPage.validateTotalErrorCallsPerMinOnErrorWidget();
	}
	

	@Test(groups = {"APM", "Regression"})
	public void TC_08_validate_The_Load_Widget_Graph_Value() throws EncryptedDocumentException, IOException
	{
		
		//select the Application
		appPage.selectTheApplicationForAPM(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.apmApplicationSheet, "application"));
				
		
		appPage.validateTheLoadWidgetSummationOfyAxisValues(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.apmApplicationSheet, "APMTotalCalls"));
	}
	
	@Test(groups = {"APM", "Regression"})
	public void TC_09_validate_The_Response_Time_Widget_Average_Response_Value() throws EncryptedDocumentException, IOException
	{
		
		//select the Application
		appPage.selectTheApplicationForAPM(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.apmApplicationSheet, "application"));
				

		appPage.validateTheAverageResponseTime();
	}
	
	@Test(groups = {"APM", "Regression"})
	public void TC_10_validate_The_Percentile_Response_Time_Widget_Values() throws EncryptedDocumentException, IOException
	{
		//select the Application
		appPage.selectTheApplicationForAPM(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.apmApplicationSheet, "application"));
				
				
		appPage.validatePercentileResponse(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.apmApplicationSheet, "ResponseTimes"));
	}
	
	@Test(groups = {"APM", "Regression"})
	public void TC_11_validate_The_Endpoint_By_Error_Values() throws EncryptedDocumentException, IOException
	{
		//select the Application
		appPage.selectTheApplicationForAPM(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.apmApplicationSheet, "application"));
				
				
		appPage.validateEndpointByErrorValues(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.apmApplicationSheet, "endPoints"));
	}
	
	@Test(groups = {"APM", "Regression"})
	public void TC_12_validate_The_Copy_Icon_Of_Endpoint_By_Error_Tab() throws EncryptedDocumentException, IOException
	{
		
		//select the Application
		appPage.selectTheApplicationForAPM(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.apmApplicationSheet, "application"));
				
				
		//click on the endpoint by error tab
		appPage.clickOnTheEndPointByErrorTab();

		//validate the copy icon
		appPage.validateTheCopyBtn(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath, IPathConstant.messageSheet, "CopyConfirmationMessgae"));
	}
	
	@Test(groups = {"APM", "Regression"})
	public void TC_13_validate_The_Endpoint_By_Error_Values_Are_In_Descending_Order_Or_Not() throws EncryptedDocumentException, IOException
	{
		//select the Application
		appPage.selectTheApplicationForAPM(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.apmApplicationSheet, "application"));
				
				
		appPage.validateValuesAreInDescendingOrderForEndpointByErrorTab();
	}
	
	@Test(groups = {"APM", "Regression"})
	public void TC_14_validate_The_Endpoint_By_Error_Value_Integration_With_Endpoint_Page() throws EncryptedDocumentException, IOException
	{
		//select the Application
		appPage.selectTheApplicationForAPM(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.apmApplicationSheet, "application"));
				
				
		//click on the endpoint by error tab
		appPage.clickOnTheEndPointByErrorTab();
		
		
		//validate the integration
		appPage.validateTheEndpointByErrorTabIntegrationWithEndpointPage();
	}
	
	@Test(groups = {"APM", "Regression"})
	public void TC_15_validate_The_Instance_By_Error_Values() throws EncryptedDocumentException, IOException
	{
		//select the Application
		appPage.selectTheApplicationForAPM(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.apmApplicationSheet, "application"));
				
				
		//click on the Instance by error tab
		appPage.clickOnTheInstanceByErrorTab();
		
		appPage.validateInstanceByErrorValues(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.apmDataValidationSheet, "instancesByErrorTab"));
	}
	
	@Test(groups = {"APM", "Regression"})
	public void TC_16_validate_The_Copy_Icon_Of_Instance_By_ErrorTab() throws EncryptedDocumentException, IOException
	{
		
		//select the Application
		appPage.selectTheApplicationForAPM(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.apmApplicationSheet, "application"));
				
				
		//click on the Instance by error tab
		appPage.clickOnTheInstanceByErrorTab();
				
		//validate the copy icon
		appPage.validateTheCopyBtn(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath, IPathConstant.messageSheet, "CopyConfirmationMessgae"));

	}
	
	@Test(groups = {"APM", "Regression"})
	public void TC_17_validate_The_Instance_By_Error_Values_Are_In_Descending_Order_Or_Not() throws EncryptedDocumentException, IOException
	{
		//select the Application
		appPage.selectTheApplicationForAPM(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.apmApplicationSheet, "application"));
				
		//click on the Instance by error tab
		appPage.clickOnTheInstanceByErrorTab();
				
		appPage.validateValuesAreInDescendingOrderForInstanceByErrorTab();
	}
	
	@Test(groups = {"APM", "Regression"})
	public void TC_18_validate_The_Instance_By_Error_Value_Integration_With_Instance_Page()throws EncryptedDocumentException, IOException
	{
		//select the Application
		appPage.selectTheApplicationForAPM(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.apmApplicationSheet, "application"));
				
				
		//click on the endpoint by error tab
		appPage.clickOnTheInstanceByErrorTab();
				
		//validate the integration
		appPage.validateTheInstanceByErrorTabIntegrationWithEndpointPage();
	}
	
	@Test(groups = {"APM", "Regression"})
	public void TC_19_validate_The_Endpoint_By_Response_Time_Values() throws EncryptedDocumentException, IOException
	{
		//select the Application
		appPage.selectTheApplicationForAPM(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.apmApplicationSheet, "application"));
				
		//click on the end point by response time  tab
		appPage.clickOnTheEndPointByResponseTimeTab();
				
		appPage.validateEndpointByResponseTimeValues(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.apmApplicationSheet, "endPoints"));
	}
	
	@Test(groups = {"APM", "Regression"})
	public void TC_20_validate_The_Copy_Icon_Of_Endpoint_By_Response_Time_Tab() throws EncryptedDocumentException, IOException
	{
		//select the Application
		appPage.selectTheApplicationForAPM(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.apmApplicationSheet, "application"));
				
		//click on the end point by response time  tab
		appPage.clickOnTheEndPointByResponseTimeTab();
//		page.pause();
		//validate the copy icon
		appPage.validateTheCopyBtn(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath, IPathConstant.messageSheet, "CopyConfirmationMessgae"));

	}
	
	@Test(groups = {"APM", "Regression"})
	public void TC_21_validate_The_Endpoint_By_Response_Time_Values_Are_In_Descending_Order_Or_Not() throws EncryptedDocumentException, IOException
	{
		//select the Application
		appPage.selectTheApplicationForAPM(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.apmApplicationSheet, "application"));
				
		//click on the end point by response time  tab
		appPage.clickOnTheEndPointByResponseTimeTab();
				
		appPage.validateValuesAreInDescendingOrderForEndpointByResponseTimeTab();
	}
	
	@Test(groups = {"APM", "Regression"})
	public void TC_22_validate_The_Endpoint_By_Response_Time_Value_Integration_With_Endpoint_Page()throws EncryptedDocumentException, IOException
	{
		//select the Application
		appPage.selectTheApplicationForAPM(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.apmApplicationSheet, "application"));
				
		//click on the endpoint by error tab
		appPage.clickOnTheEndPointByResponseTimeTab();
						
		//validate the integration
		appPage.validateTheEndpointByResponseTimeTabIntegrationWithEndpointPage();
	}
	
	@Test(groups = {"APM", "Regression"})
	public void TC_23_validate_The_Instance_By_Response_Time_Values() throws EncryptedDocumentException, IOException
	{
		//select the Application
		appPage.selectTheApplicationForAPM(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.apmApplicationSheet, "application"));
				
		//click on the instance by response time  tab
		appPage.clickOnTheInstanceByResponseTimeTab();
				
		appPage.validateInstanceByResponseTimeValues(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.apmDataValidationSheet, "instancesByErrorTab"));
	}
	
	@Test(groups = {"APM", "Regression"})
	public void TC_24_validate_The_Copy_Icon_Of_Instance_By_Response_Time_Tab() throws EncryptedDocumentException, IOException
	{
		//select the Application
		appPage.selectTheApplicationForAPM(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.apmApplicationSheet, "application"));
				
		//click on the instance by response time  tab
		appPage.clickOnTheInstanceByResponseTimeTab();
		
		//validate the copy icon
		appPage.validateTheCopyBtn(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath, IPathConstant.messageSheet, "CopyConfirmationMessgae"));

	}
	
	@Test(groups = {"APM", "Regression"})
	public void TC_25_validate_The_Instance_By_Response_Time_Values_Are_In_Descending_Order_Or_Not()throws EncryptedDocumentException, IOException
	{
		//select the Application
		appPage.selectTheApplicationForAPM(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.apmApplicationSheet, "application"));
				
		//click on the instance by response time  tab
		appPage.clickOnTheInstanceByResponseTimeTab();
				
		appPage.validateValuesAreInDescendingOrderForInstanceByResponseTimeTab();
	}
	
	@Test(groups = {"APM", "Regression"})
	public void TC_26_validate_The_Instance_By_Response_Time_Value_Integration_With_Instance_Page()throws EncryptedDocumentException, IOException
	{
		//select the Application
		appPage.selectTheApplicationForAPM(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.apmApplicationSheet, "application"));
				
		//click on the endpoint by error tab
		appPage.clickOnTheInstanceByResponseTimeTab();
								
		//validate the integration
		appPage.validateTheInstanceByResponseTimeTabIntegrationWithEndpointPage();
	}
	
	@Test(groups = {"APM", "Regression"})
	public void TC_27_validate_The_ErrorPercentage_By_Generating_5xx_And_4xx_Series_Errors() throws EncryptedDocumentException, IOException
	{
		//select the Application
		appPage.selectTheApplicationForAPM(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.apmApplicationSheet, "application"));
				
		appPage.validateErrorPercentageOfErrorGraphLegends(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.apmApplicationSheet, "4xxErrors"),
														eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.apmApplicationSheet, "5xxErros"));
	}
	
	@Test(groups = {"APM", "Regression"})
	public void TC_28_validate_The_Percentage_Of_Errors_On_YAxis() throws EncryptedDocumentException, IOException
	{
		//select the Application
		appPage.selectTheApplicationForAPM(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.apmApplicationSheet, "application"));
		page.waitForTimeout(500);	
		appPage.validatePercentageOfErrorsOnYaxis();
	}

}
