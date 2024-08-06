package apmCapability;


import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import genericUtilities.ExcelUtility;
import genericUtilities.IPathConstant;
import objectRepository.CommonPage;
import objectRepository.HomePage;
import objectRepository.APM.ApmApplicationPage;
import playWrightFactory.BaseClass;

public class APMDashBoardApplicationTest extends BaseClass{
	
	HomePage homePage;
	ExcelUtility eutil;
	ApmApplicationPage appPage;
	
	@BeforeMethod
	public void preRequest() throws EncryptedDocumentException, IOException
	{
		eutil=new ExcelUtility();
		homePage=new HomePage(page);
		appPage=new ApmApplicationPage(page);
		commPage=new CommonPage(page);
		
		//Navigate to APM capability
		commPage.navigateToApm();
		
		page.waitForLoadState();
		
		//navigate to dashboard page
		appPage.navigateToDashBoardTab();
		
		page.waitForLoadState();
		
		//navigate to Application page
		appPage.navigateToApplicationPage();
		
		//select the Application
		appPage.selectTheApplicationForAPM(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.apmApplicationSheet, "application"));
	
	
	}
	
	@Test(groups = {"APM","UI","Regression"})
	public void TC_01_validate_The_Apm_Capability_Side_Nav_Btn() throws EncryptedDocumentException, IOException
	{
		//select the Time line 
		commPage.selectTheTimeLineFromCalender(IPathConstant.oneMonthTimeRange);
		
		
		
		//Navigate to APM capability
		commPage.navigateToApm();
		
		//validate whether it is navigating to the APM page or not
		appPage.validateAPMPagetitle("APM");
		
	}
	
	@Test(groups = {"APM","UI","Regression"})
	public void TC_02_validate_The_DashBoard_Tab()
	{
		
		//Navigate to APM capability
		commPage.navigateToApm();
		
		//Validate Whether it is displaying the Application, end point, instance, database and infrastructure tabs or not 
		appPage.validateDashBoardPage();
				
	}
	
	@Test(groups = {"APM","UI","Regression"})
	public void TC_03_validate_The_Application_Page_isDisplaying_By_Default_or_Not()
	{
		//Navigate to APM capability
		commPage.navigateToApm();
				
		//validate the application page title
		appPage.validateApplicationPageDispalyingByDeafultOrNot();
	}
	
	@Test(groups = {"APM","UI","Regression"})
	public void TC_04_validate_The_Select_Application_DropDown() throws EncryptedDocumentException, IOException
	{
		
		//select the Application
		appPage.selectTheApplicationForAPM(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.apmApplicationSheet, "application"));
		
		//validate whether the desired application selected or not
		appPage.validateTheSelectApplicationDropDown(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.apmApplicationSheet, "application"));		
	}
	
	@Test(groups = {"APM","UI","Regression"})
	public void TC_05_validate_The_Apdex_Score_Title() throws EncryptedDocumentException, IOException
	{
		//Validate the Apdex score title
		appPage.validateApdexScoreTitle(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.apmApplicationSheet, "apdexScoreTitle"));
	}
	
	@Test(groups = {"APM","UI","Regression"})
	public void TC_06_validate_The_Colour_Of_The_Apdex_Score_Indicator() throws EncryptedDocumentException, IOException
	{
		appPage.validateApdexScoreIndicatorColour(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.apmApplicationSheet, "apdexScoreColorForGood"),
												eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.apmApplicationSheet, "apdexScoreColorForFair"),
												eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.apmApplicationSheet, "apdexScoreColorForPoor"));
	}
	

	@Test(dataProvider = "getDataFromDataProvider",groups = {"APM","UI","Regression"})
	public void TC_07_validate_AppicationPage_ApdexScore_Health_Indicator_Text(String Name,String Value)
	{
		System.out.println("name: "+Name+"---------Value :"+Value);
		//validate the Apdex health indicator
		appPage.validateTheApdexHealthIndicatorText(Name,Value);
		
	}
	
	@Test(groups = {"APM","UI","Regression"})
	public void TC_08_validate_The_Apdex_Health_Indicator_Colour_For_Good()throws EncryptedDocumentException, IOException
	{
		//Validate the colour of the health indicator good icon,label and value 
		appPage.validateColourOfTheHealthIndicatorGoodIconLabelAndValue(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.apmApplicationSheet, "apdexScoreColorForGood"));
	}
	
	@Test(groups = {"APM","UI","Regression"})
	public void TC_09_validate_The_Apdex_Health_Indicator_Colour_For_Fair()throws EncryptedDocumentException, IOException
	{
		//Validate the colour of the health indicator Fair icon,label and value
		appPage.validateColourOfTheHealthIndicatorFairIconLabelAndValue(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.apmApplicationSheet, "apdexScoreColorForFair"));
		
	}
	
	@Test(groups = {"APM","UI","Regression"})
	public void TC_10_validate_The_Apdex_Health_Indicator_Colour_For_Poor()throws EncryptedDocumentException, IOException
	{
		//Validate the colour of the health indicator poor icon,label and value
		appPage.validateColourOfTheHealthIndicatorPoorIconLabelAndValue(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.apmApplicationSheet, "apdexScoreColorForPoor"));
	}
	
	@Test(groups = {"APM","UI","Regression"})
	public void TC_11_validate_The_Load_Graph_Title() throws EncryptedDocumentException, IOException
	{
		appPage.validateLoadTitle(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.apmApplicationSheet, "LoadWidgetTitle"));
	}
	
	@Test(groups = {"APM","UI","Regression"})
	public void TC_12_validate_The_Load_Graph_Xaxis_Title() throws EncryptedDocumentException, IOException
	{
		appPage.validateLoadXaxisTitle(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.apmApplicationSheet, "LoadWidgetXaxisTitle"));
	}
	

	@Test(groups = {"APM","UI","Regression"})
	public void TC_13_validate_The_Load_Graph_Yaxis_Title() throws EncryptedDocumentException, IOException
	{
		appPage.validateLoadYaxisTitle(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.apmApplicationSheet, "LoadWidgetYaxisTitle"));
	}
	
	
	@Test(groups = {"APM","UI","Regression"})
	public void TC_14_validate_The_Load_Graph_ZoomIn_Btn()
	{
		appPage.validateLoadZoomIn();
	}
	

	@Test(groups = {"APM","UI","Regression"})
	public void TC_15_validate_The_Load_Graph_ZoomOut_Btn()
	{
		appPage.validateLoadZoomOut();
	}
	

	@Test(groups = {"APM","UI","Regression"})
	public void TC_16_validate_The_Load_Graph_Reset_Btn()
	{
		appPage.validateLoadZoomReset();
	}
	

	@Test(groups = {"APM","UI","Regression"})
	public void TC_17_validate_The_Load_Graph_Xaxis_Drag_And_Drop()
	{
		appPage.validateLoadDragDrop();
	}

	@Test(groups = {"APM","UI","Regression"})
	public void TC_18_validate_The_Load_Graph_Tooltip_By_Hover() throws InterruptedException
	{
		appPage.validateLoadTooltipTitle();
	}
	
	@Test(groups = {"APM","UI","Regression"})
	public void TC_19_validate_The_Error_Graph_Title() throws EncryptedDocumentException, IOException
	{
		appPage.validateErrorTitle(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.apmApplicationSheet, "ErrorWidgetTitle"));
	}
	
	@Test(groups = {"APM","UI","Regression"})
	public void TC_20_validate_The_Error_Graph_Xaxis_Title() throws EncryptedDocumentException, IOException
	{
		appPage.validateErrorXaxisTitle(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.apmApplicationSheet, "ErrorWidgetXaxisTitle"));
	}
	

	@Test(groups = {"APM","UI","Regression"})
	public void TC_21_validate_The_Error_Graph_Yaxis_Title() throws EncryptedDocumentException, IOException
	{
		appPage.validateErrorYaxisTitle(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.apmApplicationSheet, "ErrorWidgetYaxisTitle"));
	}
	

	@Test(groups = {"APM","UI","Regression"})
	public void TC_22_validate_The_Error_Graph_ZoomIn_Btn()
	{
		appPage.validateErrorZoomIn();
	}
	

	@Test(groups = {"APM","UI","Regression"})
	public void TC_23_validate_The_Error_Graph_ZoomOut_Btn()
	{
		appPage.validateErrorZoomOut();
	}
	

	@Test(groups = {"APM","UI","Regression"})
	public void TC_24_validate_The_ErrorGraph_Reset_Btn()
	{
		appPage.validateErrorZoomReset();
	}
	

	@Test(groups = {"APM","UI","Regression"})
	public void TC_25_validate_The_Error_Graph_Tooltip_By_Hover() throws InterruptedException
	{
		page.waitForTimeout(500);
		appPage.validateErrorTooltipTitle();
	}
	
	@Test(groups = {"APM","UI","Regression"})
	public void TC_26_validate_The_Error_Graph_Xaxis_Drag_And_Drop()
	{
		appPage.validatErrorDragDrop();
	}

	
	
	@Test(groups = {"APM","UI","Regression"})
	public void TC_27_validate_The_Error_GraphLegends_Text() throws EncryptedDocumentException, IOException
	{
		appPage.validateErrorLegendsText(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.apmApplicationSheet, "ErrorGraphLegendsText"));
	}
	
	@Test(groups = {"APM","UI","Regression"})
	public void TC_28_validate_The_Error_Graph_Legends() throws InterruptedException
	{
		page.waitForTimeout(500);
		appPage.validatewidgetLegendsForErrorGraph();
	}
	
	@Test(groups = {"APM","UI","Regression"})
	public void TC_29_validate_The_Response_Time_Graph_Title() throws EncryptedDocumentException, IOException
	{
		appPage.validateResposeTimeTitle(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.apmApplicationSheet, "ResponseTimeWidgetTitle"));
	}
	
	@Test(groups = {"APM","UI","Regression"})
	public void TC_30_validate_The_Response_Time_Graph_Xaxis_Title() throws EncryptedDocumentException, IOException
	{
		appPage.validateResposeTimeXaxisTitle(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.apmApplicationSheet, "ResponseTimeWidgetXaxisTitle"));
	}
	

	@Test(groups = {"APM","UI","Regression"})
	public void TC_31_validate_The_Response_Time_Graph_Yaxis_Title() throws EncryptedDocumentException, IOException
	{
		appPage.validateResposeTimeYaxisTitle(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.apmApplicationSheet, "ResponseTimeWidgetYaxisTitle"));
	}
	

	@Test(groups = {"APM","UI","Regression"})
	public void TC_32_validate_The_Response_Time_Graph_ZoomIn_Btn()
	{
		appPage.validateResposeTimeZoomIn();
	}
	

	@Test(groups = {"APM","UI","Regression"})
	public void TC_33_validate_The_Response_Time_Graph_ZoomOut_Btn()
	{
		appPage.validateResposeTimeZoomOut();
	}
	

	@Test(groups = {"APM","UI","Regression"})
	public void TC_34_validate_The_Response_Time_Graph_Reset_Btn()
	{
		appPage.validateResposeTimeZoomReset();
	}
	

	@Test(groups = {"APM","UI","Regression"})
	public void TC_35_validate_The_Response_Time_Graph_Xaxis_Drag_And_Drop()
	{
		appPage.validateResposeTimeDragDrop();
	}

	@Test(groups = {"APM","UI","Regression"})
	public void TC_36_validate_The_Response_Time_Graph_Tooltip_By_Hover() throws InterruptedException
	{
		appPage.validateResposeTimeTooltipTitle();
	}
	

	@Test(groups = {"APM","UI","Regression"})
	public void TC_37_validate_The_Percentaile_Respose_Time_Graph_Title() throws EncryptedDocumentException, IOException
	{
		appPage.validatePercentileResponseTimeTitle(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.apmApplicationSheet, "PercentileResponseTimeWidgetTitle"));
	}
	
	@Test(groups = {"APM","UI","Regression"})
	public void TC_38_validate_The_Percentaile_Respose_Time_Graph_Xaxis_Title() throws EncryptedDocumentException, IOException
	{
		appPage.validatePercentileResponseTimeXaxisTitle(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.apmApplicationSheet, "PercentileResponseTimeWidgetXaxisTitle"));
	}
	

	@Test(groups = {"APM","UI","Regression"})
	public void TC_39_validate_The_Percentaile_Respose_Time_Graph_Yaxis_Title() throws EncryptedDocumentException, IOException
	{
		appPage.validatePercentileResponseTimeYaxisTitle(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.apmApplicationSheet, "PercentileResponseTimeWidgetYaxisTitle"));
	}
	

	@Test(groups = {"APM","UI","Regression"})
	public void TC_40_validate_The_Percentaile_Respose_Time_Graph_ZoomIn_Btn()
	{
		appPage.validatePercentileResponseTimeZoomIn();
	}
	

	@Test(groups = {"APM","UI","Regression"})
	public void TC_41_validate_The_Percentaile_Respose_Time_Graph_ZoomOut_Btn()
	{
		appPage.validatePercentileResponseTimeZoomOut();
	}
	

	@Test(groups = {"APM","UI","Regression"})
	public void TC_42_validate_The_Percentaile_Respose_Time_Graph_ResetBtn()
	{
		appPage.validatePercentileResponseTimeZoomReset();
	}
	

	@Test(groups = {"APM","UI","Regression"})
	public void TC_43_validate_The_Percentaile_Respose_Time_Graph_Xaxis_Drag_And_Drop()
	{
		appPage.validatePercentileResponseTimeDragDrop();
	}

	@Test(groups = {"APM","UI","Regression"})
	public void TC_44_validate_The_Percentaile_Respose_Time_Graph_Tooltip_By_Hover() throws InterruptedException
	{
		appPage.validatePercentileResponseTimeTooltipTitle();
	}
	
	@Test(groups = {"APM","UI","Regression"})
	public void TC_45_validate_The_Percentail_Respose_Time_Graph_Legends_Text() throws EncryptedDocumentException, IOException
	{
		appPage.validateWidgetLegendsForPercentailResposeTimeGraph(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.apmApplicationSheet, "PercentileResponseTimeWidgetLegendsText"));
	}
	
	@Test(groups = {"APM","UI","Regression"})
	public void TC_46_validate_The_Percentaile_Respose_Time_Graph_Legends() throws InterruptedException
	{	
		appPage.validatepercentileResponseTimewidgetLegends();
	}
	
	@Test(groups = {"APM","UI","Regression"})
	public void TC_47_validate_The_EndPoint_By_Error_Tab()
	{
		appPage.validateEndpointByErrorTab();
	}
	
	@Test(groups = {"APM","UI","Regression"})
	public void TC_48_validate_The_Instance_By_Error_Tab()
	{
		appPage.validateInstanceByErrorTab();
	}
	
	@Test(groups = {"APM","UI","Regression"})
	public void TC_49_validate_EndPoint_By_Respose_Time_Tab()
	{
		appPage.validateEndpointByResponseTimeTab();
	}
	
	@Test(groups = {"APM","UI","Regression"})
	public void TC_50_validate_Instance_By_Respose_Time_Tab()
	{
		appPage.validateInstanceByResponseTimeTab();
	}
	

	@Test(groups = {"APM","UI","Regression"})
	public void TC_51_validate_The_All_Widget_Data_By_Selecting_5Mins_TimeLine()
	{
		//select the time line from calendar
		commPage.selectTheTimeLineFromCalender(IPathConstant.fiveMinutesTimeRange);

		//Validate whether the widgets are displaying the proper time line or not
		appPage.validateTheGivenTimeLine();
		
		
	}
	@Test(groups = {"APM","UI","Regression"})
	public void TC_52_validate_The_All_Widgets_Data_By_Selecting_15Mins_TimeLine()
	{
		//select the time line from calendar
		commPage.selectTheTimeLineFromCalender(IPathConstant.fifteenMinutesTimeRange);

		//Validate whether the widgets are displaying the proper time line or not
		appPage.validateTheGivenTimeLine();
		
		
	}
	
	@Test(groups = {"APM","UI","Regression"})
	public void TC_53_validate_The_All_Widgets_Data_By_Selecting_30Mins_TimeLine()
	{
		//select the time line from calendar
		commPage.selectTheTimeLineFromCalender(IPathConstant.thirtyMinutesTimeRange);

		//Validate whether the widgets are displaying the proper time line or not
		appPage.validateTheGivenTimeLine();
	
		
	}
	
	@Test(groups = {"APM","UI","Regression"})
	public void TC_54_validate_The_All_Widgets_Data_By_Selecting_60Mins_TimeLine()
	{
		//select the time line from calendar
		commPage.selectTheTimeLineFromCalender(IPathConstant.sixtyMinutesTimeRange);
		page.waitForTimeout(500);
		//Validate whether the widgets are displaying the proper time line or not
		appPage.validateTheGivenTimeLine();
		
		
	}
	
	@Test(groups = {"APM","UI","Regression"})
	public void TC_55_validate_The_All_Widgets_Data_By_Selecting_3hours_TimeLine()
	{
		//select the time line from calendar
		commPage.selectTheTimeLineFromCalender(IPathConstant.threeHoursTimeRange);

		//Validate whether the widgets are displaying the proper time line or not
		appPage.validateTheGivenTimeLine();
		
		
	}
	
	@Test(groups = {"APM","UI","Regression"})
	public void TC_56_validate_The_All_Widgets_Data_By_Selecting_6hours_TimeLine()
	{
		//select the time line from calendar
		commPage.selectTheTimeLineFromCalender(IPathConstant.sixHoursTimeRange);

		//Validate whether the widgets are displaying the proper time line or not
		appPage.validateTheGivenTimeLine();
		
	}
	
	@Test(groups = {"APM","UI","Regression"})
	public void TC_57_validate_The_All_Widgets_Data_By_Selecting_12hours_TimeLine()
	{
		//select the time line from calendar
		commPage.selectTheTimeLineFromCalender(IPathConstant.twelveHoursTimeRange);

		//Validate whether the widgets are displaying the proper time line or not
		appPage.validateTheGivenTimeLine();
		
	}
	
	@Test(groups = {"APM","UI","Regression"})
	public void TC_58_validate_The_All_Widgets_Data_By_Selecting_1day_TimeLine()
	{
		//select the time line from calendar
		commPage.selectTheTimeLineFromCalender(IPathConstant.oneDayTimeRange);
		page.waitForTimeout(500);
		//Validate whether the widgets are displaying the proper time line or not
		appPage.validateTheGivenTimeLine();
		
	}
	
	@Test(groups = {"APM","UI","Regression"})
	public void TC_59_validate_The_All_Widgets_Data_By_Selecting_1week_TimeLine()
	{
		//select the time line from calendar
		commPage.selectTheTimeLineFromCalender(IPathConstant.oneWeekTimeRange);

		//Validate whether the widgets are displaying the proper time line or not
		appPage.validateTheGivenTimeLine();
		
	}
	
	@Test(groups = {"APM","UI","Regression"})
	public void TC_60_validate_The_All_Widgets_Data_By_Selecting_1month_TimeLine()
	{
		//select the time line from calendar
		commPage.selectTheTimeLineFromCalender(IPathConstant.oneMonthTimeRange);

		//Validate whether the widgets are displaying the proper time line or not
		appPage.validateTheGivenTimeLine();
		
	}
	
	@Test(groups = {"APM","UI","Regression"})
	public void TC_61_validate_The_All_Widgets_By_selecting_custom_Time_For_Minutes_Range() throws EncryptedDocumentException, IOException
	{
		
		//select the time line from calendar
		commPage.selectTheCustomeTimeLine(IPathConstant.customTimeRange, eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customMinutesRange") );
		
		
		//Validate whether the widgets are displaying the proper time line or not
		appPage.validateTheCustomTimeLine(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customMinutesRange"));
		
		
	}
	
	
	@Test(groups = {"APM","UI","Regression"})
	public void TC_62_validate_The_All_Widgets_By_selecting_custom_Time_For_Hours_Range() throws EncryptedDocumentException, IOException
	{	
		//select the time line from calendar
		commPage.selectTheCustomeTimeLine(IPathConstant.customTimeRange, eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customHoursRange"));

		//Validate whether the widgets are displaying the proper time line or not
		appPage.validateTheCustomTimeLine(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customHoursRange"));
				
		
		
	}
	
	@Test(groups = {"APM","UI","Regression"})
	public void TC_63_validate_The_All_Widgets_By_selecting_custom_Time_For_Days_Range() throws EncryptedDocumentException, IOException
	{
		//select the time line from calendar
		commPage.selectTheCustomeTimeLine(IPathConstant.customTimeRange, eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customDaysRange"));
		
		//Validate whether the widgets are displaying the proper time line or not
		appPage.validateTheCustomTimeLine(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customDaysRange"));
				
		
		
	}
	
	@Test(groups = {"APM","UI","Regression"})
	public void TC_64_validate_The_All_Widgets_By_selecting_custom_Time_For_Future_date()
	{
		//select the time line from calendar
		commPage.selectTheTimeLineFromCalender(IPathConstant.fiveMinutesTimeRange);
		
		//select the future time line from calendar
		commPage.validateTheFutureTimeLine();
		
	}
	
	@DataProvider
	public Object[][] getDataFromDataProvider() throws Throwable
	{
		
		return eutil.fetchAllTheDataFromExcelSheet(IPathConstant.commExcelPath,IPathConstant.apdexLabelSheet);
		
	}

}
