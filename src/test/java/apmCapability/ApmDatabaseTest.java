package apmCapability;

import org.testng.annotations.Test;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import genericUtilities.ExcelUtility;
import genericUtilities.GenericMethods;
import genericUtilities.IPathConstant;
import objectRepository.CommonPage;
import objectRepository.APM.ApmApplicationPage;
import objectRepository.APM.ApmDatabasePage;
import objectRepository.APM.ApmEndpointPage;
import playWrightFactory.BaseClass;

public class ApmDatabaseTest extends BaseClass{
	
	
	GenericMethods util;
	ExcelUtility eutil;
	ApmDatabasePage dBPage;
	
	
	@BeforeMethod
	public void preRequest() throws EncryptedDocumentException, IOException
	{
		eutil=new ExcelUtility();
		commPage = new CommonPage(page);
		dBPage = new ApmDatabasePage(page);
		ApmApplicationPage appPage=new ApmApplicationPage(page);
		
		//Navigate to APM capability
		commPage.navigateToApm();
		
		//navigate to dashboard page
		appPage.navigateToDashBoardTab();
		
		//navigate to dataBase page
		dBPage.navigateToDatabaseTab();
	
		//select the Time line 
		commPage.selectTheTimeLineFromCalender("1 month");
		
		//select the Application
		appPage.selectTheApplicationForAPM(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.apmApplicationSheet, "application"));
		
	}
	
	@Test(groups = {"APM","UI","Regression"})
	public void TC_01_validate_The_Database_Page()
	{
		//navigate to dataBase page
		dBPage.navigateToDatabaseTab();
		
		//validate the page
		dBPage.validatedataBasepage();
	}

	@Test(groups = {"APM","UI","Regression"})
	public void TC_02_validate_The_Load_Graph_Title() throws EncryptedDocumentException, IOException
	{
		dBPage.validateLoadTitle(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.apmDatabaseSheet, "LoadWidgetTitle"));
	}
	
	@Test(groups = {"APM","UI","Regression"})
	public void TC_03_validate_The_Load_Graph_Xaxis_Title() throws EncryptedDocumentException, IOException
	{
		dBPage.validateLoadXaxisTitle(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.apmDatabaseSheet, "LoadWidgetXaxisTitle"));
	}
	

	@Test(groups = {"APM","UI","Regression"})
	public void TC_04_validate_The_Load_Graph_Yaxis_Title() throws EncryptedDocumentException, IOException
	{
		dBPage.validateLoadYaxisTitle(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.apmDatabaseSheet, "LoadWidgetYaxisTitle"));
	}
	

	@Test(groups = {"APM","UI","Regression"})
	public void TC_05_validate_The_Load_Graph_ZoomIn_Btn()
	{
		dBPage.validateLoadZoomIn();
	}
	

	@Test(groups = {"APM","UI","Regression"})
	public void TC_06_validate_The_Load_Graph_ZoomOut_Btn()
	{
		dBPage.validateLoadZoomOut();
	}
	

	@Test(groups = {"APM","UI","Regression"})
	public void TC_07_validate_The_Load_Graph_Reset_Btn()
	{
		dBPage.validateLoadZoomReset();
	}
	

	@Test(groups = {"APM","UI","Regression"})
	public void TC_08_validate_The_Load_Graph_Xaxis_Drag_And_Drop()
	{
		dBPage.validateLoadDragDrop();
	}

	@Test(groups = {"APM","UI","Regression"})
	public void TC_09_validate_The_Load_Graph_Tooltip_By_Hover() throws InterruptedException
	{
		dBPage.validateLoadTooltipTitle();
	}
	
	@Test(groups = {"APM","UI","Regression"})
	public void TC_10_validate_The_Access_Error_Graph_Title() throws EncryptedDocumentException, IOException
	{
		dBPage.validateErrorTitle(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.apmDatabaseSheet, "ErrorWidgetTitle"));
	}
	
	@Test(groups = {"APM","UI","Regression"})
	public void TC_11_validate_The_Access_Error_Graph_Xaxis_Title() throws EncryptedDocumentException, IOException
	{
		dBPage.validateErrorXaxisTitle(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.apmDatabaseSheet, "ErrorWidgetXaxisTitle"));
	}
	

	@Test(groups = {"APM","UI","Regression"})
	public void TC_12_validate_The_Access_Error_Graph_Yaxis_Title() throws EncryptedDocumentException, IOException
	{
		dBPage.validateErrorYaxisTitle(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.apmDatabaseSheet, "ErrorWidgetYaxisTitle"));
	}
	

	@Test(groups = {"APM","UI","Regression"})
	public void TC_13_validate_The_Access_Error_Graph_ZoomIn_Btn()
	{
		dBPage.validateErrorZoomIn();
	}
	

	@Test(groups = {"APM","UI","Regression"})
	public void TC_14_validate_The_Access_Error_Graph_ZoomOut_Btn()
	{
		dBPage.validateErrorZoomOut();
	}
	

	@Test(groups = {"APM","UI","Regression"})
	public void TC_15_validate_The_Access_Error_Graph_Reset_Btn()
	{
		dBPage.validateErrorZoomReset();
	}
	

	@Test(groups = {"APM","UI","Regression"})
	public void TC_16_validate_The_Access_Error_Graph_Xaxis_Drag_And_Drop()
	{
		dBPage.validatErrorDragDrop();
	}

	@Test(groups = {"APM","UI","Regression"})
	public void TC_17_validate_The_Access_Error_Graph_Tooltip_ByHover() throws InterruptedException
	{
		dBPage.validateErrorTooltipTitle();
	}
	
	@Test(groups = {"APM","UI","Regression"})
	public void TC_18_validate_The_Response_Time_Graph_Title() throws EncryptedDocumentException, IOException
	{
		dBPage.validateResposeTimeTitle(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.apmDatabaseSheet, "ResponseTimeWidgetTitle"));
	}
	
	@Test(groups = {"APM","UI","Regression"})
	public void TC_19_validate_The_Response_Time_Graph_Xaxis_Title() throws EncryptedDocumentException, IOException
	{
		dBPage.validateResposeTimeXaxisTitle(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.apmDatabaseSheet, "ResponseTimeWidgetXaxisTitle"));
	}
	

	@Test(groups = {"APM","UI","Regression"})
	public void TC_20_validate_The_Response_Time_Graph_Yaxis_Title() throws EncryptedDocumentException, IOException
	{
		dBPage.validateResposeTimeYaxisTitle(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.apmDatabaseSheet, "ResponseTimeWidgetYaxisTitle"));
	}
	

	@Test(groups = {"APM","UI","Regression"})
	public void TC_21_validate_The_Response_Time_Graph_ZoomIn_Btn()
	{
		dBPage.validateResposeTimeZoomIn();
	}
	

	@Test(groups = {"APM","UI","Regression"})
	public void TC_22_validate_The_Response_Time_Graph_ZoomOut_Btn()
	{
		dBPage.validateResposeTimeZoomOut();
	}
	

	@Test(groups = {"APM","UI","Regression"})
	public void TC_23_validate_The_Response_Time_Graph_Reset_Btn()
	{
		dBPage.validateResposeTimeZoomReset();
	}
	

	@Test(groups = {"APM","UI","Regression"})
	public void TC_24_validate_The_Response_Time_Graph_Xaxis_Drag_And_Drop()
	{
		dBPage.validateResposeTimeDragDrop();
	}

	@Test(groups = {"APM","UI","Regression"})
	public void TC_25_validate_The_Response_Time_Graph_Tooltip_By_Hover() throws InterruptedException
	{
		dBPage.validateResposeTimeTooltipTitle();
	}
	

	@Test(groups = {"APM","UI","Regression"})
	public void TC_26_validate_The_Percentaile_Respose_Time_Graph_Title() throws EncryptedDocumentException, IOException
	{
		dBPage.validatePercentileResponseTimeTitle(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.apmDatabaseSheet, "PercentileResponseTimeWidgetTitle"));
	}
	
	@Test(groups = {"APM","UI","Regression"})
	public void TC_27_validate_The_Percentaile_Respose_Time_Graph_Xaxis_Title() throws EncryptedDocumentException, IOException
	{
		dBPage.validatePercentileResponseTimeXaxisTitle(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.apmDatabaseSheet, "PercentileResponseTimeWidgetXaxisTitle"));
	}
	

	@Test(groups = {"APM","UI","Regression"})
	public void TC_28_validate_The_Percentaile_Respose_Time_Graph_Yaxis_Title() throws EncryptedDocumentException, IOException
	{
		dBPage.validatePercentileResponseTimeYaxisTitle(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.apmDatabaseSheet, "PercentileResponseTimeWidgetYaxisTitle"));
	}
	

	@Test(groups = {"APM","UI","Regression"})
	public void TC_29_validate_The_Percentaile_Respose_Time_Graph_ZoomIn_Btn()
	{
		dBPage.validatePercentileResponseTimeZoomIn();
	}
	

	@Test(groups = {"APM","UI","Regression"})
	public void TC_30_validate_The_Percentaile_Respose_Time_Graph_ZoomOut_Btn()
	{
		dBPage.validatePercentileResponseTimeZoomOut();
	}
	

	@Test(groups = {"APM","UI","Regression"})
	public void TC_31_validate_The_Percentaile_Respose_Time_Graph_Reset_Btn()
	{
		dBPage.validatePercentileResponseTimeZoomReset();
	}
	

	@Test(groups = {"APM","UI","Regression"})
	public void TC_32_validate_The_Percentaile_Respose_Time_Graph_Xaxis_Drag_And_Drop()
	{
		dBPage.validatePercentileResponseTimeDragDrop();
	}

	@Test(groups = {"APM","UI","Regression"})
	public void TC_33_validate_The_Percentaile_Respose_Time_Graph_Tooltip_By_Hover() throws InterruptedException
	{
		dBPage.validatePercentileResponseTimeTooltipTitle();
	}
	
	@Test(groups = {"APM","UI","Regression"})
	public void TC_34_validate_The_Percentail_Respose_Time_Graph_Legends_Text() throws EncryptedDocumentException, IOException
	{
		dBPage.validateWidgetLegendsForPercentailResposeTimeGraph(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.apmDatabaseSheet, "PercentileResponseTimeWidgetLegendsText"));
	}
	
	@Test(groups = {"APM","UI","Regression"})
	public void TC_35_validate_The_Percentaile_Respose_Time_Graph_Legends() throws InterruptedException
	{	
		dBPage.validatepercentileResponseTimewidgetLegends();
	}


	@Test(groups = {"APM","UI","Regression"})
	public void TC_36_validate_The_All_Widget_Data_By_Selecting_5Mins_TimeLine()
	{
		//select the time line from calendar
		commPage.selectTheTimeLineFromCalender(IPathConstant.fiveMinutesTimeRange);
		//Validate whether the widgets are displaying the proper time line or not
		dBPage.validateTheGivenTimeLine();
		
		
	}
	@Test(groups = {"APM","UI","Regression"})
	public void TC_37_validate_The_All_Widgets_Data_By_Selecting_15Mins_TimeLine()
	{
		//select the time line from calendar
		commPage.selectTheTimeLineFromCalender(IPathConstant.fifteenMinutesTimeRange);

		//Validate whether the widgets are displaying the proper time line or not
		dBPage.validateTheGivenTimeLine();
		
		
	}
	
	@Test(groups = {"APM","UI","Regression"})
	public void TC_38_validate_The_All_Widgets_Data_By_Selecting_30Mins_TimeLine()
	{
		//select the time line from calendar
		commPage.selectTheTimeLineFromCalender(IPathConstant.thirtyMinutesTimeRange);

		//Validate whether the widgets are displaying the proper time line or not
		dBPage.validateTheGivenTimeLine();
	
		
	}
	
	@Test(groups = {"APM","UI","Regression"})
	public void TC_39_validate_The_All_Widgets_Data_By_Selecting_60Mins_TimeLine()
	{
		//select the time line from calendar
		commPage.selectTheTimeLineFromCalender(IPathConstant.sixtyMinutesTimeRange);

		//Validate whether the widgets are displaying the proper time line or not
		dBPage.validateTheGivenTimeLine();
	}
	
	@Test(groups = {"APM","UI","Regression"})
	public void TC_40_validate_The_All_Widgets_Data_By_Selecting_3hours_TimeLine()
	{
		//select the time line from calendar
		commPage.selectTheTimeLineFromCalender(IPathConstant.threeHoursTimeRange);

		//Validate whether the widgets are displaying the proper time line or not
		dBPage.validateTheGivenTimeLine();
		
		
	}
	
	@Test(groups = {"APM","UI","Regression"})
	public void TC_41_validate_The_All_Widgets_Data_By_Selecting_6hours_TimeLine()
	{
		//select the time line from calendar
		commPage.selectTheTimeLineFromCalender(IPathConstant.sixHoursTimeRange);

		//Validate whether the widgets are displaying the proper time line or not
		dBPage.validateTheGivenTimeLine();
		
	}
	
	@Test(groups = {"APM","UI","Regression"})
	public void TC_42_validate_The_All_Widgets_Data_By_Selecting_12hours_TimeLine()
	{
		//select the time line from calendar
		commPage.selectTheTimeLineFromCalender(IPathConstant.twelveHoursTimeRange);

		//Validate whether the widgets are displaying the proper time line or not
		dBPage.validateTheGivenTimeLine();
		
	}
	
	@Test(groups = {"APM","UI","Regression"})
	public void TC_43_validate_The_All_Widgets_Data_By_Selecting_1day_TimeLine()
	{
		//select the time line from calendar
		commPage.selectTheTimeLineFromCalender(IPathConstant.oneDayTimeRange);

		//Validate whether the widgets are displaying the proper time line or not
		dBPage.validateTheGivenTimeLine();
		
	}
	
	@Test(groups = {"APM","UI","Regression"})
	public void TC_44_validate_The_All_Widgets_Data_By_Selecting_1week_TimeLine()
	{
		//select the time line from calendar
		commPage.selectTheTimeLineFromCalender(IPathConstant.oneWeekTimeRange);

		//Validate whether the widgets are displaying the proper time line or not
		dBPage.validateTheGivenTimeLine();
		
	}
	
	@Test(groups = {"APM","UI","Regression"})
	public void TC_45_validate_The_All_Widgets_Data_By_Selecting_1month_TimeLine()
	{
		//select the time line from calendar
		commPage.selectTheTimeLineFromCalender(IPathConstant.oneMonthTimeRange);

		//Validate whether the widgets are displaying the proper time line or not
		dBPage.validateTheGivenTimeLine();
	}
	
	@Test(groups = {"APM","UI","Regression"})
	public void TC_46_validate_The_All_Widgets_By_selecting_custom_Time_For_Minutes_Range() throws EncryptedDocumentException, IOException
	{
		//select the time line from calendar
		commPage.selectTheCustomeTimeLine(IPathConstant.customTimeRange, eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customMinutesRange") );
		
		//Validate whether the widgets are displaying the proper time line or not
		dBPage.validateTheCustomTimeLine(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customMinutesRange"));
	}
	
	
	@Test(groups = {"APM","UI","Regression"})
	public void TC_47_validate_The_All_Widgets_By_selecting_custom_Time_For_Hours_Range() throws EncryptedDocumentException, IOException
	{
		//select the time line from calendar
		commPage.selectTheCustomeTimeLine(IPathConstant.customTimeRange, eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customHoursRange"));
		
		//Validate whether the widgets are displaying the proper time line or not
		dBPage.validateTheCustomTimeLine(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customHoursRange"));
	}
	
	@Test(groups = {"APM","UI","Regression"})
	public void TC_48_validate_The_All_Widgets_By_selecting_custom_Time_For_Days_Range() throws EncryptedDocumentException, IOException
	{
		//select the time line from calendar
		commPage.selectTheCustomeTimeLine(IPathConstant.customTimeRange, eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customDaysRange"));

		//Validate whether the widgets are displaying the proper time line or not
		dBPage.validateTheCustomTimeLine(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customDaysRange"));
	}
	
	@Test(groups = {"APM","UI","Regression"})
	public void TC_49_validate_The_All_Widgets_By_selecting_custom_Time_For_Future_date()
	{
		//select the future time line from calendar
		commPage.validateTheFutureTimeLine();
	}
	
	@Test(groups = {"APM","UI","Regression"})
	public void TC_50_navigate_To_Query_Page_Validate_Whether_Query_Page_Displayed_Or_Not()
	{
		//click on the Query tab
		dBPage.clickOnTheQueryTab();
		
		
		//validate the QueryPage
		dBPage.ValidateTheQueryPage();
		
	}
	
	@Test(groups = {"APM","UI","Regression"})
	public void TC_51_validate_Default_Query_Threshold_value() throws EncryptedDocumentException, IOException
	{
		//click on the Query tab
		dBPage.clickOnTheQueryTab();
				
		dBPage.validateTheQueryThresholdSelectedValue(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.apmDatabaseSheet, "defaultQueryThresholdValue"));
	}
	
	@Test(groups = {"APM","UI","Regression"})
	public void TC_52_vallidate_The_Query_Threshold_Dropdown_Functionality() throws EncryptedDocumentException, IOException
	{
		//click on the Query tab
		dBPage.clickOnTheQueryTab();
		
		dBPage.selectTheQueryThreshold(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.apmDatabaseSheet, "1msQueryThreshold"));
		
		dBPage.validateTheQueryThresholdSelectedValue(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.apmDatabaseSheet, "1msQueryThreshold"));
	}
	
	@Test(groups = {"APM","UI","Regression"})
	public void TC_53_validate_The_Query_Threshold_DropDown_Values() throws EncryptedDocumentException, IOException
	{
		//click on the Query tab
		dBPage.clickOnTheQueryTab();
				
		dBPage.validateTheQueryThreshouldDropDownValues(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.apmDatabaseSheet, "queryThresholdValues"));
	}
	
	@Test(groups = {"APM","UI","Regression"})
	public void TC_54_validate_The_Search_function_Query_Page_For_Valid_Data() throws EncryptedDocumentException, IOException
	{			
		//click on the Query tab
		dBPage.clickOnTheQueryTab();
		
		dBPage.selectTheQueryThreshold(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.apmDatabaseSheet, "1msQueryThreshold"));
		page.waitForTimeout(500);	
		dBPage.validateSearchWithValidaData();
		
	}
	
	@Test(groups = {"APM","UI","Regression"})
	public void TC_55_validate_The_Search_function_Query_Page_For_Invalid_Data() throws EncryptedDocumentException, IOException
	{
		

		ApmApplicationPage appPage=new ApmApplicationPage(page);
		//select the Application
		appPage.selectTheApplicationForAPM("Java_UAT_K8s");
				
		//click on the Query tab
		dBPage.clickOnTheQueryTab();
		
		dBPage.selectTheQueryThreshold(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.apmDatabaseSheet, "1msQueryThreshold"));
		
		dBPage.validateSearchWithInvalidData();
	}
	
	@Test(groups = {"APM","UI","Regression"})
	public void TC_56_validate_The_Query_Table_Header_column1() throws EncryptedDocumentException, IOException
	{
		//click on the Query tab
		dBPage.clickOnTheQueryTab();
				
		dBPage.validateFirstColumnOfQueryTable(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.apmDatabaseSheet, "QueryTableFirstColumnText"));
	}
	
	@Test(groups = {"APM","UI","Regression"})
	public void TC_57_validate_The_Query_Table_Header_column2() throws EncryptedDocumentException, IOException
	{
		//click on the Query tab
		dBPage.clickOnTheQueryTab();
				
		dBPage.validateSecondColumnOfQueryTable(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.apmDatabaseSheet, "QueryTableSecondColumnText"));
	}
	
	@Test(groups = {"APM","UI","Regression"})
	public void TC_58_validate_The_Query_Table_Header_column3() throws EncryptedDocumentException, IOException
	{
		//click on the Query tab
		dBPage.clickOnTheQueryTab();
				
		dBPage.validateThridColumnOfQueryTable(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.apmDatabaseSheet, "QueryTableThirdColumnText"));
	}
	
	@Test(groups = {"APM","UI","Regression"})
	public void TC_59_validate_The_Query_Table_Header_column4() throws EncryptedDocumentException, IOException
	{
		//click on the Query tab
		dBPage.clickOnTheQueryTab();
				
		dBPage.validateFourthColumnOfQueryTable(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.apmDatabaseSheet, "QueryTableFourthColumnText"));
	}
	
	
	
	
	

}
