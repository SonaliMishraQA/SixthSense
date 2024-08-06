package apmCapability;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import genericUtilities.ExcelUtility;
import genericUtilities.GenericMethods;
import genericUtilities.IPathConstant;
import objectRepository.CommonPage;
import objectRepository.HomePage;
import objectRepository.APM.ApmApplicationPage;
import objectRepository.APM.ApmEndpointPage;
import playWrightFactory.BaseClass;

public class ApmDashBoardEndpointDataValidationTest extends BaseClass{
	
	GenericMethods util;
	ApmEndpointPage endPage;
	ExcelUtility eutil;
	ApmApplicationPage appPage;
	
	
	@BeforeMethod
	public void preRequest() throws EncryptedDocumentException, IOException
	{
		eutil=new ExcelUtility();
		endPage = new ApmEndpointPage(page);
		commPage = new CommonPage(page);
		appPage=new ApmApplicationPage(page);
		
		//Navigate to APM capability
		commPage.navigateToApm();
		
		//navigate to dashboard page
		appPage.navigateToDashBoardTab();
		
		//navigate to endPage page
		endPage.navigateToEndpointPage();
	
		//select the Time line 
		commPage.selectTheTimeLineFromCalender(IPathConstant.sixHoursTimeRange);
		
		//select the Application
		appPage.selectTheApplicationForAPM(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.apmApplicationSheet, "application"));
		
	}
	
	@AfterMethod
	public void postRequest()
	{
		endPage.closeSpanInfoWindow();
	}
	
	
	@Test(groups = {"APM", "Regression"})
	public void TC_01_push_Some_Load_And_Validate_The_EndPoints_List() throws EncryptedDocumentException, IOException
	{
		endPage.validateEndpointList(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.apmEndpointSheet, "endpointsList"));
		
	}
	
	
	@Test(groups = {"APM", "Regression"})
	public void TC_02_push_Some_Load_And_Validate_The_ErrorPercentageList() throws EncryptedDocumentException, IOException
	{
		endPage.validateErrorPercentageList(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.apmEndpointSheet, "errorPercentageList"));
		
	}
	
	@Test(groups = {"APM", "Regression"})
	public void TC_03_push_Some_Load_And_Validate_The_Errors_List() throws EncryptedDocumentException, IOException
	{
		endPage.validateErrorsList(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.apmEndpointSheet, "errorsList"));
	}
	
	@Test(groups = {"APM", "Regression"})
	public void TC_04_push_Some_Load_And_Validate_The_Errors_Per_Min_List() throws EncryptedDocumentException, IOException
	{
		endPage.validateErrorsPerMinList(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.apmEndpointSheet, "errorsList"));
	}
	
	@Test(groups = {"APM", "Regression"})
	public void TC_05_push_Some_Load_And_Validate_The_Response_Time() throws EncryptedDocumentException, IOException
	{
		endPage.validateResponseTimeList(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.apmEndpointSheet, "responseTime"));
	}
	
	@Test(groups = {"APM", "Regression"})
	public void TC_06_push_Some_Load_And_Validate_The_Calls_List() throws EncryptedDocumentException, IOException
	{
		endPage.validateCallsList(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.apmEndpointSheet, "callsList"));
	}
	
	@Test(groups = {"APM", "Regression"})
	public void TC_07_push_Some_Load_And_Validate_The_Cals_Per_Min_List() throws EncryptedDocumentException, IOException
	{
		endPage.validateCallsPerMinList(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.apmEndpointSheet, "callsList"));
	}
	
	@Test(groups = {"APM", "Regression"})
	public void TC_08_validate_Load_Widget_Yaxis_Values()
	{
		endPage.validateLoadGraphYaxisValues();
	}
	
	@Test(groups = {"APM", "Regression"})
	public void TC_09_validate_Error_Widget_Yaxis_Values()
	{
		endPage.validateErrorGraphYaxisValues();
	}
	
	@Test(groups = {"APM", "Regression"})
	public void TC_10_validate_Average_Response_Time_Of_Response_Time_Widget_Yaxis_Values()
	{
		endPage.validateResponseTimeGraphAverageresponseTime();
	}
	@Test(groups = {"APM", "Regression"})
	public void TC_11_validate_The_Percentile_Values_Of_Percentaile_Response_Time_Widget()
	{
		endPage.validatePercentailWidgetYaxisValues();
	}
	
	@Test(groups = {"APM", "Regression"})
	public void TC_12_validate_The_Status_Code_Of_4xx_Error_Call() throws EncryptedDocumentException, IOException
	{
		endPage.validateTheStatusCode(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.apmEndpointSheet, "4xxEndPoint"),
										eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.apmEndpointSheet, "4xxStatusCode"));
	}
	
	@Test(groups = {"APM", "Regression"})
	public void TC_13_validate_The_Status_Code_Of_5xx_Error_Call() throws EncryptedDocumentException, IOException
	{
	
		endPage.validateTheStatusCode(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.apmEndpointSheet, "5xxEndPont"),
				eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.apmEndpointSheet, "5xxStatusCode"));
	}
	
	@Test(groups = {"APM", "Regression"})
	public void TC_14_validate_The_Status_Code_Of_Success_Call() throws EncryptedDocumentException, IOException
	{
		endPage.validateTheStatusCode(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.apmEndpointSheet, "successEndPoint"),
				eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.apmEndpointSheet, "successStatusCode"));

	}
	
	@Test(groups = {"APM", "Regression"})
	public void TC_15_validate_The_Slow_Trace_Button()
	{
		endPage.validateSlowTraceBtn();
	}
	
	@Test(groups = {"APM", "Regression"})
	public void TC_16_validate_The_Error_Trace_Button()
	{
		endPage.validateErrorTraceBtn();
	}
	
	
	
	
	
	

}
