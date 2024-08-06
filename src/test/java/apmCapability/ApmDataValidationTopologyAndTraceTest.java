package apmCapability;

import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import genericUtilities.ExcelUtility;
import genericUtilities.GenericMethods;
import genericUtilities.IPathConstant;
import objectRepository.CommonPage;
import objectRepository.APM.ApmApplicationPage;
import objectRepository.APM.ApmDatabasePage;
import objectRepository.APM.ApmEndpointPage;
import objectRepository.APM.ApmTopologyPage;
import objectRepository.APM.ApmTracePage;
import playWrightFactory.BaseClass;

public class ApmDataValidationTopologyAndTraceTest extends BaseClass{
	GenericMethods util;
	CommonPage common;
	ApmTopologyPage topo;
	ApmEndpointPage endpoint;
	ApmTracePage trace;
	ApmApplicationPage dashboard;
	ApmDatabasePage database;
	ExcelUtility excel = new ExcelUtility();
	
	@BeforeMethod
	public void bmConfig() throws EncryptedDocumentException, IOException, InterruptedException {
		topo = new ApmTopologyPage(page);
		trace = new ApmTracePage(page);
		endpoint = new ApmEndpointPage(page);
		common = new CommonPage(page);
		dashboard = new ApmApplicationPage(page);
		database = new ApmDatabasePage(page);
		util = new GenericMethods();
		common.navigateToApm();
		common.selectTheTimeLineFromCalender(IPathConstant.sixHoursTimeRange);
		endpoint.selectApplication();
	}
	
	@Test (groups = {"APM","Regression"})
	public void TC001_validate_The_Endpoints_Names_In_Trace_Page_Under_All_Status() throws InterruptedException, EncryptedDocumentException, IOException {
		trace.navigateToTracePage();
		trace.validateEndpointsNamesUnderAllStatus();
	}
	
	@Test (groups = {"APM","Regression"})
	public void TC002_validate_The_Endpoints_Names_In_Trace_Page_Under_Success_Status() throws InterruptedException, EncryptedDocumentException, IOException {
		trace.navigateToTracePage();
		trace.validateEndpointsNamesUnderSuccessStatus();
	}
	
	@Test (groups = {"APM","Regression"})
	public void TC003_validate_The_Endpoints_Names_In_Trace_Page_Under_Error_Status() throws InterruptedException, EncryptedDocumentException, IOException {
		trace.navigateToTracePage();
		trace.validateEndpointsNamesUnderErrorStatus();
	}
	
	@Test (groups = {"APM","Regression"})
	public void TC004_validate_The_Endpoints_Search_Result_For_The_Endpoint_Names() throws InterruptedException, EncryptedDocumentException, IOException {
		trace.navigateToTracePage();
		trace.validateEndpointsSearchResultsForTheEndpointNames();
	}
	
	@Test (groups = {"APM","Regression"})
	public void TC005_validate_Whether_New_Group_With_Single_Application_Can_Be_Added() throws EncryptedDocumentException, IOException {
		topo.navigateToTopologyPage();
		topo.validateWhetherNewGroupwithSingleApplicationCanBeAdded();
	}
	
	@Test (groups = {"APM","Regression"})
	public void TC006_validate_The_User_As_Source_In_The_Table_View() throws EncryptedDocumentException, IOException {
		topo.navigateToTopologyPage();
		topo.selectApplicationGroupAndTableViewForDataValidation();
		topo.validateTheUserInTheSourceColumnOfTheTable();
	}
	
	@Test (groups = {"APM","Regression"})
	public void TC007_validate_The_User_Indicator_In_Source_In_The_Table_View() throws EncryptedDocumentException, IOException {
		topo.navigateToTopologyPage();
		topo.selectApplicationGroupAndTableViewForDataValidation();
		topo.validateTheUserIndicatorInTheSourceColumnOfTheTable();
	}
	
	@Test (groups = {"APM","Regression"})
	public void TC008_validate_The_Application_Name_As_Destination_In_The_Table_View() throws EncryptedDocumentException, IOException {
		topo.navigateToTopologyPage();
		topo.selectApplicationGroupAndTableViewForDataValidation();
		topo.validateTheApplicationNameInTheDestinationColumnOfTheTable();
	}
	
	@Test (groups = {"APM","Regression"})
	public void TC009_validate_whether_The_Application_Indicator_Is_According_To_The_Apdex() throws EncryptedDocumentException, IOException {
		dashboard.navigateToApplicationPage();
		String apdexColor = dashboard.getApdexImageColor();
		topo.navigateToTopologyPage();
		topo.selectApplicationGroupAndTableViewForDataValidation();
		topo.validateWhetherTheApplicationIndicatorIsAccordingToTheApdex(apdexColor);
	}
	
	@Test (groups = {"APM","Regression"})
	public void TC010_validate_The_Application_Name_In_The_Map_View() throws EncryptedDocumentException, IOException {
		topo.navigateToTopologyPage();
		topo.selectApplicationGroupAndMapViewForDataValidation();
		topo.validateTheApplicationNameInTheMapView();
	}
	
	@Test (groups = {"APM","Regression"})
	public void TC011_validate_Whether_The_Server_Detect_Point_Is_Displayed() throws EncryptedDocumentException, IOException {
		topo.navigateToTopologyPage();
		topo.selectApplicationGroupAndMapViewForDataValidation();
		topo.validateWhetherTheServerDetectPointIsPDisplayed();
	}
	
	@Test (groups = {"APM","Regression"})
	public void TC012_validate_Whether_The_Detect_Point_Graph_For_Server_Is_Displayed() throws EncryptedDocumentException, IOException {
		topo.navigateToServerDetectPointGraph();
	}
	
	@Test (groups = {"APM","Regression"})
	public void TC013_validate_The_Functionality_Of_Detect_Point_Graph_Close_Button() throws EncryptedDocumentException, IOException {
		topo.navigateToTopologyPage();
		topo.selectApplicationGroupAndMapViewForDataValidation();
		topo.validateTheFunctionalityOfDetectPointGraphCloseButton();
	}
	
	@Test (groups = {"APM","Regression"})
	public void TC014_validate_The_Title_Of_Detect_Point_Response_Time_Graph() throws EncryptedDocumentException, IOException {
		topo.navigateToServerDetectPointGraph();
		topo.validateTheTitleOfDetectPointResponseTimeGraph();
	}
	
	@Test (groups = {"APM","Regression"})
	public void TC015_validate_The_Xaxis_Title_Of_Detect_Point_Response_Time_Graph() throws EncryptedDocumentException, IOException {
		topo.navigateToServerDetectPointGraph();
		topo.validateTheXaxisTitleOfDetectPointResponseTimeGraph();
	}
	
	@Test (groups = {"APM","Regression"})
	public void TC016_validate_The_Yaxis_Title_Of_Detect_Point_Response_Time_Graph() throws EncryptedDocumentException, IOException {
		topo.navigateToServerDetectPointGraph();
		topo.validateTheYaxisTitleOfDetectPointResponseTimeGraph();
	}
	
	@Test (groups = {"APM","Regression"})
	public void TC017_validate_The_Functionality_Of_Detect_Point_Response_Time_Graph_Zoom_In_Button() throws EncryptedDocumentException, IOException {
		topo.navigateToServerDetectPointGraph();
		topo.validateTheFunctionalityOfDetectPointResponseTimeGraphZoomInButton();
	}
	
	@Test (groups = {"APM","Regression"})
	public void TC018_validate_The_Functionality_Of_Detect_Point_Response_Time_Graph_Zoom_Out_Button() throws EncryptedDocumentException, IOException {
		topo.navigateToServerDetectPointGraph();
		topo.validateTheFunctionalityOfDetectPointResponseTimeGraphZoomOutButton();
	}
	
	@Test (groups = {"APM","Regression"})
	public void TC019_validate_The_Functionality_Of_Detect_Point_Response_Time_Graph_Zoom_Reset_Button() throws EncryptedDocumentException, IOException {
		topo.navigateToServerDetectPointGraph();
		topo.validateTheFunctionalityOfDetectPointResponseTimeGraphZoomResetButton();
	}
	
	@Test (groups = {"APM","Regression"})
	public void TC020_validate_Zoom_In_By_Drag_And_Drop_For_Detect_Point_Response_Time_Graph() throws EncryptedDocumentException, IOException {
		topo.navigateToServerDetectPointGraph();
		topo.validateZoomInByDragAndDropForDetectPointResponseTimeGraph();
	}

	@Test (groups = {"APM","Regression"})
	public void TC021_validate_Whether_The_Tooltip_Is_Displaying_For_Detect_Point_Response_Time_Graph() throws EncryptedDocumentException, IOException {
		topo.navigateToServerDetectPointGraph();
		topo.validateWhetherTheTooltipIsDisplayingForDetectPointResponseTimeGraph();
	}
	
	@Test (groups = {"APM","Regression"})
	public void TC022_validate_The_Title_Of_Detect_Point_Percentile_Response_Time_Graph() throws EncryptedDocumentException, IOException {
		topo.navigateToServerDetectPointGraph();
		topo.validateTheTitleOfDetectPointPercentileResponseTimeGraph();
	}
	
	@Test (groups = {"APM","Regression"})
	public void TC023_validate_The_Xaxis_Title_Of_Detect_Point_Percentile_Response_Time_Graph() throws EncryptedDocumentException, IOException {
		topo.navigateToServerDetectPointGraph();
		topo.validateTheXaxisTitleOfDetectPointPercentileResponseTimeGraph();
	}
	
	@Test (groups = {"APM","Regression"})
	public void TC024_validate_The_Yaxis_Title_Of_Detect_Point_Percentile_Response_Time_Graph() throws EncryptedDocumentException, IOException {
		topo.navigateToServerDetectPointGraph();
		topo.validateTheYaxisTitleOfDetectPointPercentileResponseTimeGraph();
	}
	
	@Test (groups = {"APM","Regression"})
	public void TC025_validate_The_Functionality_Of_Detect_Point_Percentile_Response_Time_Graph_Zoom_In_Button() throws EncryptedDocumentException, IOException {
		topo.navigateToServerDetectPointGraph();
		topo.validateTheFunctionalityOfDetectPointPercentileResponseTimeGraphZoomInButton();
	}
	
	@Test (groups = {"APM","Regression"})
	public void TC026_validate_The_Functionality_Of_Detect_Point_Percentile_Response_Time_Graph_Zoom_Out_Button() throws EncryptedDocumentException, IOException {
		topo.navigateToServerDetectPointGraph();
		topo.validateTheFunctionalityOfDetectPointPercentileResponseTimeGraphZoomOutButton();
	}
	
	@Test (groups = {"APM","Regression"})
	public void TC027_validate_The_Functionality_Of_Detect_Point_Percentile_Response_Time_Graph_Zoom_Reset_Button() throws EncryptedDocumentException, IOException {
		topo.navigateToServerDetectPointGraph();
		topo.validateTheFunctionalityOfDetectPointPercentileResponseTimeGraphZoomResetButton();
	}
	
	@Test (groups = {"APM","Regression"})
	public void TC028_validate_Zoom_In_By_Drag_And_Drop_For_Detect_Point_Percentile_Response_Time_Graph() throws EncryptedDocumentException, IOException {
		topo.navigateToServerDetectPointGraph();
		topo.validateZoomInByDragAndDropForDetectPointPercentileResponseTimeGraph();
	}

	@Test (groups = {"APM","Regression"})
	public void TC029_validate_Whether_The_Tooltip_Is_Displaying_For_Detect_Point_Percentile_Response_Time_Graph() throws EncryptedDocumentException, IOException {
		topo.navigateToServerDetectPointGraph();
		topo.validateWhetherTheTooltipIsDisplayingForDetectPointPercentileResponseTimeGraph();
	}
	
	@Test (groups = {"APM","Regression"})
	public void TC030_validate_The_Legends_Label_In_Detect_Point_Percentile_Response_Time_Graph() throws EncryptedDocumentException, IOException {
		topo.navigateToServerDetectPointGraph();
		String legendNames =  excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.topologyPageSheet, "detectPointPercentileResponseTimeWidgetLegendsText");
		topo.validateTheLegendsLabelInDetectPointPercentileResponseTimeGraph(legendNames);
	}
	
	@Test (groups = {"APM","Regression"})
	public void TC031_validate_The_Legends_Color_In_Detect_Point_Percentile_Response_Time_Graph() throws EncryptedDocumentException, IOException {
		topo.navigateToServerDetectPointGraph();
		topo.validateTheLegendsColorInDetectPointPercentileResponseTimeGraph();
	}	
	
	@Test (groups = {"APM","Regression"})
	public void TC032_validate_The_Title_Of_Detect_Point_Load_Graph() throws EncryptedDocumentException, IOException {
		topo.navigateToServerDetectPointGraph();
		topo.validateTheTitleOfDetectPointLoadGraph();
	}
	
	@Test (groups = {"APM","Regression"})
	public void TC033_validate_The_Xaxis_Title_Of_Detect_Point_Load_Graph() throws EncryptedDocumentException, IOException {
		topo.navigateToServerDetectPointGraph();
		topo.validateTheXaxisTitleOfDetectPointLoadGraph();
	}
	
	@Test (groups = {"APM","Regression"})
	public void TC034_validate_The_Yaxis_Title_Of_Detect_Point_Load_Graph() throws EncryptedDocumentException, IOException {
		topo.navigateToServerDetectPointGraph();
		topo.validateTheYaxisTitleOfDetectPointLoadGraph();
	}
	
	@Test (groups = {"APM","Regression"})
	public void TC035_validate_The_Functionality_Of_Detect_Point_Load_Graph_Zoom_In_Button() throws EncryptedDocumentException, IOException {
		topo.navigateToServerDetectPointGraph();
		topo.validateTheFunctionalityOfDetectPointLoadGraphZoomInButton();
	}
	
	@Test (groups = {"APM","Regression"})
	public void TC036_validate_The_Functionality_Of_Detect_Point_Load_Graph_Zoom_Out_Button() throws EncryptedDocumentException, IOException {
		topo.navigateToServerDetectPointGraph();
		topo.validateTheFunctionalityOfDetectPointLoadGraphZoomOutButton();
	}
	
	@Test (groups = {"APM","Regression"})
	public void TC037_validate_The_Functionality_Of_Detect_Point_Load_Graph_Zoom_Reset_Button() throws EncryptedDocumentException, IOException {
		topo.navigateToServerDetectPointGraph();
		topo.validateTheFunctionalityOfDetectPointLoadGraphZoomResetButton();
	}
	
	@Test (groups = {"APM","Regression"})
	public void TC038_validate_Zoom_In_By_Drag_And_Drop_For_Detect_Point_Load_Graph() throws EncryptedDocumentException, IOException {
		topo.navigateToServerDetectPointGraph();
		topo.validateZoomInByDragAndDropForDetectPointLoadGraph();
	}

	@Test (groups = {"APM","Regression"})
	public void TC039_validate_Whether_The_Tooltip_Is_Displaying_For_Detect_Point_Load_Graph() throws EncryptedDocumentException, IOException {
		topo.navigateToServerDetectPointGraph();
		topo.validateWhetherTheTooltipIsDisplayingForDetectPointLoadGraph();
	}
	
	@Test (groups = {"APM","Regression"})
	public void TC040_validate_The_Title_Of_Detect_Point_Error_Graph() throws EncryptedDocumentException, IOException {
		topo.navigateToServerDetectPointGraph();
		topo.validateTheTitleOfDetectPointErrorGraph();
	}
	
	@Test (groups = {"APM","Regression"})
	public void TC041_validate_The_Xaxis_Title_Of_Detect_Point_Error_Graph() throws EncryptedDocumentException, IOException {
		topo.navigateToServerDetectPointGraph();
		topo.validateTheXaxisTitleOfDetectPointErrorGraph();
	}
	
	@Test (groups = {"APM","Regression"})
	public void TC042_validate_The_Yaxis_Title_Of_Detect_Point_Error_Graph() throws EncryptedDocumentException, IOException {
		topo.navigateToServerDetectPointGraph();
		topo.validateTheYaxisTitleOfDetectPointErrorGraph();
	}
	
	@Test (groups = {"APM","Regression"})
	public void TC043_validate_The_Functionality_Of_Detect_Point_Error_Graph_Zoom_In_Button() throws EncryptedDocumentException, IOException {
		topo.navigateToServerDetectPointGraph();
		topo.validateTheFunctionalityOfDetectPointErrorGraphZoomInButton();
	}
	
	@Test (groups = {"APM","Regression"})
	public void TC044_validate_The_Functionality_Of_Detect_Point_Error_Graph_Zoom_Out_Button() throws EncryptedDocumentException, IOException {
		topo.navigateToServerDetectPointGraph();
		topo.validateTheFunctionalityOfDetectPointErrorGraphZoomOutButton();
	}
	
	@Test (groups = {"APM","Regression"})
	public void TC045_validate_The_Functionality_Of_Detect_Point_Error_Graph_Zoom_Reset_Button() throws EncryptedDocumentException, IOException {
		topo.navigateToServerDetectPointGraph();
		topo.validateTheFunctionalityOfDetectPointErrorGraphZoomResetButton();
	}
	
	@Test (groups = {"APM","Regression"})
	public void TC046_validate_Zoom_In_By_Drag_And_Drop_For_Detect_Point_Error_Graph() throws EncryptedDocumentException, IOException {
		topo.navigateToServerDetectPointGraph();
		topo.validateZoomInByDragAndDropForDetectPointErrorGraph();
	}

	@Test (groups = {"APM","Regression"})
	public void TC047_validate_Whether_The_Tooltip_Is_Displaying_For_Detect_Point_Error_Graph() throws EncryptedDocumentException, IOException {
		topo.navigateToServerDetectPointGraph();
		topo.validateWhetherTheTooltipIsDisplayingForDetectPointErrorGraph();
	}
	
	@Test (groups = {"APM","Regression"})
	public void TC048_validate_Whether_The_Xaxis_Lables_Are_According_To_5_Mins_Timeline() throws EncryptedDocumentException, IOException {
		topo.navigateToServerDetectPointGraph();
		common.selectTheTimeLineFromCalender(IPathConstant.fiveMinutesTimeRange);
		topo.ValidateTheXaxisLablesAccordingToTheSelectedTimeline();
	}
	
	@Test (groups = {"APM","Regression"})
	public void TC049_validate_Whether_The_Xaxis_Lables_Are_According_To_15_Mins_Timeline() throws EncryptedDocumentException, IOException {
		topo.navigateToServerDetectPointGraph();
		common.selectTheTimeLineFromCalender(IPathConstant.fifteenMinutesTimeRange);
		topo.ValidateTheXaxisLablesAccordingToTheSelectedTimeline();
	}
	
	@Test (groups = {"APM","Regression"})
	public void TC050_validate_Whether_The_Xaxis_Lables_Are_According_To_30_Mins_Timeline() throws EncryptedDocumentException, IOException {
		topo.navigateToServerDetectPointGraph();
		common.selectTheTimeLineFromCalender(IPathConstant.thirtyMinutesTimeRange);
		topo.ValidateTheXaxisLablesAccordingToTheSelectedTimeline();
	}
	
	@Test (groups = {"APM","Regression"})
	public void TC051_validate_Whether_The_Xaxis_Lables_Are_According_To_60_Mins_Timeline() throws EncryptedDocumentException, IOException {
		topo.navigateToServerDetectPointGraph();
		common.selectTheTimeLineFromCalender(IPathConstant.sixtyMinutesTimeRange);
		topo.ValidateTheXaxisLablesAccordingToTheSelectedTimeline();
	}
	
	@Test (groups = {"APM","Regression"})
	public void TC052_validate_Whether_The_Xaxis_Lables_Are_According_To_3_Hours_Timeline() throws EncryptedDocumentException, IOException {
		topo.navigateToServerDetectPointGraph();
		common.selectTheTimeLineFromCalender(IPathConstant.threeHoursTimeRange);
		topo.ValidateTheXaxisLablesAccordingToTheSelectedTimeline();
	}
	
	@Test (groups = {"APM","Regression"})
	public void TC053_validate_Whether_The_Xaxis_Lables_Are_According_To_6_Hours_Timeline() throws EncryptedDocumentException, IOException {
		topo.navigateToServerDetectPointGraph();
		common.selectTheTimeLineFromCalender(IPathConstant.sixHoursTimeRange);
		topo.ValidateTheXaxisLablesAccordingToTheSelectedTimeline();
	}
	
	@Test (groups = {"APM","Regression"})
	public void TC054_validate_Whether_The_Xaxis_Lables_Are_According_To_12_Hours_Timeline() throws EncryptedDocumentException, IOException {
		topo.navigateToServerDetectPointGraph();
		common.selectTheTimeLineFromCalender(IPathConstant.twelveHoursTimeRange);
		topo.ValidateTheXaxisLablesAccordingToTheSelectedTimeline();
	}
	
	@Test (groups = {"APM","Regression"})
	public void TC055_validate_Whether_The_Xaxis_Lables_Are_According_To_1_Day_Timeline() throws EncryptedDocumentException, IOException {
		topo.navigateToServerDetectPointGraph();
		common.selectTheTimeLineFromCalender(IPathConstant.oneDayTimeRange);
		topo.ValidateTheXaxisLablesAccordingToTheSelectedTimeline();
	}
	
	@Test (groups = {"APM","Regression"})
	public void TC056_validate_Whether_The_Xaxis_Lables_Are_According_To_1_Week_Timeline() throws EncryptedDocumentException, IOException {
		topo.navigateToServerDetectPointGraph();
		common.selectTheTimeLineFromCalender(IPathConstant.oneWeekTimeRange);
		topo.ValidateTheXaxisLablesAccordingToTheSelectedTimeline();
	}
	
	@Test (groups = {"APM","Regression"})
	public void TC057_validate_Whether_The_Xaxis_Lables_Are_According_To_1_Month_Timeline() throws EncryptedDocumentException, IOException {
		topo.navigateToServerDetectPointGraph();
		common.selectTheTimeLineFromCalender(IPathConstant.oneMonthTimeRange);
		topo.ValidateTheXaxisLablesAccordingToTheSelectedTimeline();
	}
	
	@Test (groups = {"APM","Regression"})
	public void TC058_validate_The_All_Widgets_By_selecting_custom_Time_For_Minutes_Range() throws EncryptedDocumentException, IOException{
		topo.navigateToServerDetectPointGraph();
		commPage.selectTheCustomeTimeLine(IPathConstant.customTimeRange, excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customMinutesRange"));
		topo.validateTheCustomTimeLineForDetectPointGraphs(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customMinutesRange"));
	}
	
	@Test (groups = {"APM","Regression"})
	public void TC059_validate_The_All_Widgets_By_selecting_custom_Time_For_Hours_Range() throws EncryptedDocumentException, IOException{
		topo.navigateToServerDetectPointGraph();
		commPage.selectTheCustomeTimeLine(IPathConstant.customTimeRange, excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customHoursRange"));
		topo.validateTheCustomTimeLineForDetectPointGraphs(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customHoursRange"));
	}
	
	@Test (groups = {"APM","Regression"})
	public void TC060_validate_The_All_Widgets_By_selecting_custom_Time_For_Days_Range() throws EncryptedDocumentException, IOException{
		topo.navigateToServerDetectPointGraph();
		commPage.selectTheCustomeTimeLine(IPathConstant.customTimeRange, excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customDaysRange"));
		topo.validateTheCustomTimeLineForDetectPointGraphs(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customDaysRange"));
	}
	
	@Test (groups = {"APM","Regression"})
	public void TC061_validate_The_All_Widgets_By_selecting_custom_Time_For_Future_date() throws EncryptedDocumentException, IOException{
		topo.navigateToServerDetectPointGraph();
		commPage.validateTheFutureTimeLine();
	}
	
	@Test (groups = {"APM","Regression"})
	public void TC062_validate_The_Response_Time_From_Server_Detect_Point_Tooltip_In_The_Server_Response_Time_Graph() throws EncryptedDocumentException, IOException{
		topo.navigateToTopologyPage();
		topo.selectApplicationGroupAndMapViewForDataValidation();
		topo.validateWhetherTheDetectPointGraphForServerIsPDisplayed();
		topo.fetchResponseTimeFromServerDetectPointTooltipAnValidateInTheResponseTimeGraph();
	}

	@Test (groups = {"APM","Regression"})
	public void TC063_validate_The_Call_Per_Minute_From_Server_Detect_Point_Tooltip_In_The_Server_Load_Graph() throws EncryptedDocumentException, IOException{
		topo.navigateToTopologyPage();
		topo.selectApplicationGroupAndMapViewForDataValidation();
		topo.validateWhetherTheDetectPointGraphForServerIsPDisplayed();
		topo.fetchCallsPerMinuteFromServerDetectPointTooltipAnValidateInTheLoadGraph();
	}
	
	@Test (groups = {"APM","Regression"})
	public void TC064_validate_The_Topology_Block_Application_Name_In_Application_Overview_Graph() throws EncryptedDocumentException, IOException {
		topo.navigateToTopologyPage();
		topo.selectApplicationGroupAndMapViewForDataValidation();
		topo.navigateToApplicationOverviewGraph();
		topo.fetchTheApplicationNameFromTopoBlockAndValidateInApplicationOverviewGraphPanels();
	}
	
	@Test (groups = {"APM","Regression"})
	public void TC065_validate_The_Topology_Block_Application_Server_Name_In_Application_Overview_Graph() throws EncryptedDocumentException, IOException {
		topo.navigateToTopologyPage();
		topo.selectApplicationGroupAndMapViewForDataValidation();
		topo.navigateToApplicationOverviewGraph();
		topo.fetchTheApplicationServerNameFromTopoBlockAndValidateInApplicationOverviewGraphPanels();
	}
	
	@Test (groups = {"APM","Regression"})
	public void TC066_validate_Whether_The_Apdex_Value_In_Application_Overview_Graph_Header_Is_According_To_The_Apdex_On_Dashboard_Page() throws EncryptedDocumentException, IOException {
		String apdexOnDashboard = dashboard.getApdexScore();
		topo.validateWhetherTheApdexValueInApplicationOverviewGraphHeaderIsAccordingToTheApdexOnDashboardPage(apdexOnDashboard);
	}
	
	@Test (groups = {"APM","Regression"})
	public void TC067_validate_The_Title_Of_Apdex_Graph_In_Application_Overview_Panel() throws EncryptedDocumentException, IOException {
		topo.validateTheTitleOfApdexGraph();
	}
	
	@Test (groups = {"APM","Regression"})
	public void TC068_validate_The_Xaxis_Title_Of_Apdex_Graph_In_Application_Overview_Panel() throws EncryptedDocumentException, IOException {
		topo.validateTheXaxisTitleOfApdexGraph();
	}
	
	@Test (groups = {"APM","Regression"})
	public void TC069_validate_The_Yaxis_Title_Of_Apdex_Graph_In_Application_Overview_Panel() throws EncryptedDocumentException, IOException {
		topo.validateTheYaxisTitleOfApdexGraph();
	}
	
	@Test (groups = {"APM","Regression"})
	public void TC070_validate_The_Functionality_Of_Apdex_Graph_Zoom_In_Button () throws EncryptedDocumentException, IOException {
		topo.validateTheFunctionalityOfApdexGraphZoomInButton();
	}
	
	@Test (groups = {"APM","Regression"})
	public void TC071_validate_The_Functionality_Of_Apdex_Graph_Zoom_Out_Button () throws EncryptedDocumentException, IOException {
		topo.validateTheFunctionalityOfApdexGraphZoomOutButton();
	}
	
	@Test (groups = {"APM","Regression"})
	public void TC072_validate_The_Functionality_Of_Apdex_Graph_Zoom_Reset_Button () throws EncryptedDocumentException, IOException {
		topo.validateTheFunctionalityOfApdexGraphZoomResetButton();
	}
	
	@Test (groups = {"APM","Regression"}) 
	public void TC073_validate_Zoom_In_By_Drag_And_Drop_For_Apdex_Graph() throws EncryptedDocumentException, IOException {
		page.waitForTimeout(1000);
		topo.validateZoomInByDragAndDropForApdexGraph();
	}

	@Test (groups = {"APM","Regression"}) 
	public void TC074_validate_Whether_The_Tooltip_Is_Displaying_For_Apdex_Graph() throws EncryptedDocumentException, IOException {
		topo.validateWhetherTheTooltipIsDisplayingForApdexGraph();
	}
	
	@Test (groups = {"APM","Regression"})
	public void TC075_validate_The_Title_Of_Response_Time_Graph_In_Application_Overview_Panel() throws EncryptedDocumentException, IOException {
		topo.validateTheTitleOfResponseTimeGraph();
	}
	
	@Test (groups = {"APM","Regression"})
	public void TC076_validate_The_Xaxis_Title_Of_Response_Time_Graph_In_Application_Overview_Panel() throws EncryptedDocumentException, IOException {
		topo.validateTheXaxisTitleOfResponseTimeGraph();
	}
	
	@Test (groups = {"APM","Regression"})
	public void TC077_validate_The_Yaxis_Title_Of_Response_Time_Graph_In_Application_Overview_Panel() throws EncryptedDocumentException, IOException {
		topo.validateTheYaxisTitleOfResponseTimeGraph();
	}
	
	@Test (groups = {"APM","Regression"})
	public void TC078_validate_The_Functionality_Of_Response_Time_Graph_Zoom_In_Button () throws EncryptedDocumentException, IOException {
		topo.validateTheFunctionalityOfResponseTimeGraphZoomInButton();
	}
	
	@Test (groups = {"APM","Regression"})
	public void TC079_validate_The_Functionality_Of_Response_Time_Graph_Zoom_Out_Button () throws EncryptedDocumentException, IOException {
		topo.validateTheFunctionalityOfResponseTimeGraphZoomOutButton();
	}
	
	@Test (groups = {"APM","Regression"})
	public void TC080_validate_The_Functionality_Of_Response_Time_Graph_Zoom_Reset_Button () throws EncryptedDocumentException, IOException {
		topo.validateTheFunctionalityOfResponseTimeGraphZoomResetButton();
	}
	
	@Test (groups = {"APM","Regression"}) 
	public void TC081_validate_Zoom_In_By_Drag_And_Drop_For_Response_Time_Graph() throws EncryptedDocumentException, IOException {
		page.waitForTimeout(1000);
		topo.validateZoomInByDragAndDropForResponseTimeGraph();
	}
	
	@Test (groups = {"APM","Regression"}) 
	public void TC082_validate_Whether_The_Tooltip_Is_Displaying_For_Response_Time_Graph() throws EncryptedDocumentException, IOException {
		topo.validateWhetherTheTooltipIsDisplayingForResponseTimeGraph();
	}
	
	@Test (groups = {"APM","Regression"})
	public void TC083_validate_The_Title_Of_Error_Graph_In_Application_Overview_Panel() throws EncryptedDocumentException, IOException {
		topo.validateTheTitleOfErrorGraph();
	}
	
	@Test (groups = {"APM","Regression"})
	public void TC084_validate_The_Xaxis_Title_Of_Error_Graph_In_Application_Overview_Panel() throws EncryptedDocumentException, IOException {
		topo.validateTheXaxisTitleOfErrorGraph();
	}
	
	@Test (groups = {"APM","Regression"})
	public void TC085_validate_The_Yaxis_Title_Of_Error_Graph_In_Application_Overview_Panel() throws EncryptedDocumentException, IOException {
		topo.validateTheYaxisTitleOfErrorGraph();
	}
	
	@Test (groups = {"APM","Regression"})
	public void TC086_validate_The_Functionality_Of_Error_Graph_Zoom_In_Button () throws EncryptedDocumentException, IOException {
		topo.validateTheFunctionalityOfErrorGraphZoomInButton();
	}
	
	@Test (groups = {"APM","Regression"})
	public void TC087_validate_The_Functionality_Of_Error_Graph_Zoom_Out_Button () throws EncryptedDocumentException, IOException {
		topo.validateTheFunctionalityOfErrorGraphZoomOutButton();
	}
	
	@Test (groups = {"APM","Regression"})
	public void TC088_validate_The_Functionality_Of_Error_Graph_Zoom_Reset_Button () throws EncryptedDocumentException, IOException {
		topo.validateTheFunctionalityOfErrorGraphZoomResetButton();
	}
	
	@Test (groups = {"APM","Regression"}) 
	public void TC089_validate_Zoom_In_By_Drag_And_Drop_For_Error_Graph() throws EncryptedDocumentException, IOException {
		topo.validateZoomInByDragAndDropForErrorGraph();
	}
	
	@Test (groups = {"APM","Regression"}) 
	public void TC090_validate_Whether_The_Tooltip_Is_Displaying_For_Eror_Graph() throws EncryptedDocumentException, IOException {
		topo.validateWhetherTheTooltipIsDisplayingForErrorGraph();
	}
	
	@Test (groups = {"APM","UI","Regression"})
	public void TC091_validate_Whether_The_Xaxis_Lables_Are_According_To_5_Mins_Timeline() throws EncryptedDocumentException, IOException {
		topo.navigateToTopologyPage();
		topo.selectApplicationGroupAndMapViewForDataValidation();
		topo.navigateToApplicationOverviewGraph();
    	common.selectTheTimeLineFromCalender(IPathConstant.fiveMinutesTimeRange);
		topo.validateTheXaxisLabelsAreAsPerSelectedTimeLineForApplicationOverviewGraphs();
	}
	
	@Test (groups = {"APM","UI","Regression"})
	public void TC092_validate_Whether_The_Xaxis_Lables_Are_According_To_15_Mins_Timeline() throws EncryptedDocumentException, IOException {
		topo.navigateToTopologyPage();
		topo.selectApplicationGroupAndMapViewForDataValidation();
		topo.navigateToApplicationOverviewGraph();
    	common.selectTheTimeLineFromCalender(IPathConstant.fifteenMinutesTimeRange);
		topo.validateTheXaxisLabelsAreAsPerSelectedTimeLineForApplicationOverviewGraphs();
	}
	
	@Test (groups = {"APM","UI","Regression"})
	public void TC093_validate_Whether_The_Xaxis_Lables_Are_According_To_30_Mins_Timeline() throws EncryptedDocumentException, IOException {
		topo.navigateToTopologyPage();
		topo.selectApplicationGroupAndMapViewForDataValidation();
		topo.navigateToApplicationOverviewGraph();
    	common.selectTheTimeLineFromCalender(IPathConstant.thirtyMinutesTimeRange);
		topo.validateTheXaxisLabelsAreAsPerSelectedTimeLineForApplicationOverviewGraphs();
	}
	
	@Test (groups = {"APM","UI","Regression"})
	public void TC094_validate_Whether_The_Xaxis_Lables_Are_According_To_60_Mins_Timeline() throws EncryptedDocumentException, IOException {
		topo.navigateToTopologyPage();
		topo.selectApplicationGroupAndMapViewForDataValidation();
		topo.navigateToApplicationOverviewGraph();
    	common.selectTheTimeLineFromCalender(IPathConstant.sixtyMinutesTimeRange);
		topo.validateTheXaxisLabelsAreAsPerSelectedTimeLineForApplicationOverviewGraphs();
	}
	
	@Test (groups = {"APM","UI","Regression"})
	public void TC095_validate_Whether_The_Xaxis_Lables_Are_According_To_3_Hours_Timeline() throws EncryptedDocumentException, IOException {
		topo.navigateToTopologyPage();
		topo.selectApplicationGroupAndMapViewForDataValidation();
		topo.navigateToApplicationOverviewGraph();
    	common.selectTheTimeLineFromCalender(IPathConstant.threeHoursTimeRange);
		topo.validateTheXaxisLabelsAreAsPerSelectedTimeLineForApplicationOverviewGraphs();
	}

	@Test (groups = {"APM","UI","Regression"})
	public void TC096_validate_Whether_The_Xaxis_Lables_Are_According_To_6_Hours_Timeline() throws EncryptedDocumentException, IOException {
		topo.navigateToTopologyPage();
		topo.selectApplicationGroupAndMapViewForDataValidation();
		topo.navigateToApplicationOverviewGraph();
    	common.selectTheTimeLineFromCalender(IPathConstant.sixHoursTimeRange);
		topo.validateTheXaxisLabelsAreAsPerSelectedTimeLineForApplicationOverviewGraphs();
	}
	
	@Test (groups = {"APM","UI","Regression"})
	public void TC097_validate_Whether_The_Xaxis_Lables_Are_According_To_12_Hours_Timeline() throws EncryptedDocumentException, IOException {
		topo.navigateToTopologyPage();
		topo.selectApplicationGroupAndMapViewForDataValidation();
		topo.navigateToApplicationOverviewGraph();
    	common.selectTheTimeLineFromCalender(IPathConstant.twelveHoursTimeRange);
		topo.validateTheXaxisLabelsAreAsPerSelectedTimeLineForApplicationOverviewGraphs();
	}

	@Test (groups = {"APM","UI","Regression"})
	public void TC098_validate_Whether_The_Xaxis_Lables_Are_According_To_1_Day_Timeline() throws EncryptedDocumentException, IOException {
		topo.navigateToTopologyPage();
		topo.selectApplicationGroupAndMapViewForDataValidation();
		topo.navigateToApplicationOverviewGraph();
    	common.selectTheTimeLineFromCalender(IPathConstant.oneDayTimeRange);
		topo.validateTheXaxisLabelsAreAsPerSelectedTimeLineForApplicationOverviewGraphs();
	}
	
	@Test (groups = {"APM","UI","Regression"})
	public void TC099_validate_Whether_The_Xaxis_Lables_Are_According_To_1_Week_Timeline() throws EncryptedDocumentException, IOException {
		topo.navigateToTopologyPage();
		topo.selectApplicationGroupAndMapViewForDataValidation();
		topo.navigateToApplicationOverviewGraph();
    	common.selectTheTimeLineFromCalender(IPathConstant.oneWeekTimeRange);
		topo.validateTheXaxisLabelsAreAsPerSelectedTimeLineForApplicationOverviewGraphs();
	}
	
	@Test (groups = {"APM","UI","Regression"})
	public void TC100_validate_Whether_The_Xaxis_Lables_Are_According_To_1_Month_Timeline() throws EncryptedDocumentException, IOException {
		topo.navigateToTopologyPage();
		topo.selectApplicationGroupAndMapViewForDataValidation();
		topo.navigateToApplicationOverviewGraph();
    	common.selectTheTimeLineFromCalender(IPathConstant.oneMonthTimeRange);
		topo.validateTheXaxisLabelsAreAsPerSelectedTimeLineForApplicationOverviewGraphs();
	}
	
	@Test
	public void TC101_validate_The_All_Widgets_By_selecting_custom_Time_For_Minutes_Range() throws EncryptedDocumentException, IOException
	{
		topo.navigateToTopologyPage();
		topo.selectApplicationGroupAndMapViewForDataValidation();
		topo.navigateToApplicationOverviewGraph();
		commPage.selectTheCustomeTimeLine(IPathConstant.customTimeRange, excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customMinutesRange"));
		topo.validateTheCustomTimeLine(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customMinutesRange"));
	}
	
	@Test
	public void TC102_validate_The_All_Widgets_By_selecting_custom_Time_For_Hours_Range() throws EncryptedDocumentException, IOException
	{
		topo.navigateToTopologyPage();
		topo.selectApplicationGroupAndMapViewForDataValidation();
		topo.navigateToApplicationOverviewGraph();
		commPage.selectTheCustomeTimeLine(IPathConstant.customTimeRange, excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customHoursRange"));
		topo.validateTheCustomTimeLine(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customHoursRange"));
	}
	
	@Test
	public void TC103_validate_The_All_Widgets_By_selecting_custom_Time_For_Days_Range() throws EncryptedDocumentException, IOException
	{
		topo.navigateToTopologyPage();
		topo.selectApplicationGroupAndMapViewForDataValidation();
		topo.navigateToApplicationOverviewGraph();
		commPage.selectTheCustomeTimeLine(IPathConstant.customTimeRange, excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customDaysRange"));
		topo.validateTheCustomTimeLine(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customDaysRange"));
	}
	
	@Test
	public void TC104_validate_The_All_Widgets_By_selecting_custom_Time_For_Future_date() throws EncryptedDocumentException, IOException
	{
		topo.navigateToTopologyPage();
		topo.selectApplicationGroupAndMapViewForDataValidation();
		topo.navigateToApplicationOverviewGraph();
		commPage.validateTheFutureTimeLine();
	}
	
	@Test (groups = {"APM","Regression"}) 
	public void TC105_validate_Whether_The_Server_Detect_Point_Is_Displayed_In_Table_View() throws EncryptedDocumentException, IOException {
		topo.navigateToTopologyPage();
		topo.selectApplicationGroupAndTableViewForDataValidation();
		topo.validateWhetherTheServerDetectPointIsDisplayedInTableView();
	}
	
	@Test (groups = {"APM","Regression"}) 
	public void TC106_validate_The_Source_Name_Of_The_Server_Detect_Point_In_Table_View() throws EncryptedDocumentException, IOException {
		topo.navigateToTopologyPage();
		topo.selectApplicationGroupAndTableViewForDataValidation();
		topo.validateTheSourceNameOfTheServerDetectPointInTableView();
	}

	@Test (groups = {"APM","Regression"}) 
	public void TC107_validate_The_Destination_Name_Of_The_Server_Detect_Point_In_Table_View() throws EncryptedDocumentException, IOException {
		topo.navigateToTopologyPage();
		topo.selectApplicationGroupAndTableViewForDataValidation();
		topo.validateTheDestinationNameOfTheServerDetectPointInTableView();
	}
	
	@Test (groups = {"APM","Regression"}) 
	public void TC108_validate_The_Calls_Per_Minute_Of_The_Server_Detect_Point_In_Table_View() throws EncryptedDocumentException, IOException {
		topo.navigateToTopologyPage();
		topo.selectApplicationGroupAndMapViewForDataValidation();
		topo.validateTheCallsPerMinuteOfTheServerDetectPointInTableView();
	}
	
	@Test (groups = {"APM","Regression"}) 
	public void TC109_validate_The_Response_Time_Of_The_Server_Detect_Point_In_Table_View() throws EncryptedDocumentException, IOException {
		topo.navigateToTopologyPage();
		topo.selectApplicationGroupAndMapViewForDataValidation();
		topo.validateTheResponseTimeOfTheServerDetectPointInTableView();
	}
	
	@Test (groups = {"APM","Regression"}) 
	public void TC110_validate_The_Average_Response_Time_From_Dashboard_In_Topology_Application_Overview_Graph() throws EncryptedDocumentException, IOException {
    	String expectedRespTime = dashboard.getAverageResponsetime();
    	topo.navigateToTopologyPage();
		topo.selectApplicationGroupAndMapViewForDataValidation();
		topo.validateTheAverageResponseTimeFromDashboardInTopologyApplicationOverviewGraph(expectedRespTime);
	}
	
	@Test (groups = {"APM","Regression"}) 
	public void TC111_validate_The_Average_Response_Time_From_Dashboard_In_Topology_Server_Detect_Point_Graph() throws EncryptedDocumentException, IOException {
    	String expectedRespTime = dashboard.getAverageResponsetime();
    	topo.navigateToTopologyPage();
		topo.selectApplicationGroupAndMapViewForDataValidation();
		topo.validateTheAverageResponseTimeFromDashboardInTopologyServerDetectPointGraph(expectedRespTime);
	}
	
	@Test (groups = {"APM","Regression"}) 
	public void TC112_validate_The_Average_Response_Time_From_Dashboard_In_Topology_Server_Detect_Point_Tooltip() throws EncryptedDocumentException, IOException {
		String expectedRespTime = dashboard.getAverageResponsetime();
    	topo.navigateToTopologyPage();
		topo.selectApplicationGroupAndMapViewForDataValidation();
		topo.validateTheAverageResponseTimeFromDashboardInTopologyServerDetectPointTooltip(expectedRespTime);
	}
	
	@Test (groups = {"APM","Regression"}) 
	public void TC113_validate_The_Number_Of_Errors_From_Dashboard_In_Topology_Application_Overview_Graph_Header() throws EncryptedDocumentException, IOException {
    	int expectedErrors = dashboard.getNumberOfErrorsFromErrorGraphHeader();
    	topo.navigateToTopologyPage();
		topo.selectApplicationGroupAndMapViewForDataValidation();
		topo.validateTheNumberOfErrorsFromDashboardInTopologyApplicationOverviewGraphHeader(expectedErrors);
	}
	
	@Test (groups = {"APM","Regression"}) 
	public void TC114_validate_The_Number_Of_Errors_From_Dashboard_In_Topology_Application_Overview_Graph() throws EncryptedDocumentException, IOException {
    	int expectedErrors = dashboard.getNumberOfErrorsFromErrorGraphHeader();
    	topo.navigateToTopologyPage();
		topo.selectApplicationGroupAndMapViewForDataValidation();
		topo.validateTheNumberOfErrorsFromDashboardInTopologyApplicationOverviewGraph(expectedErrors);
	}
	
	@Test (groups = {"APM","Regression"}) 
	public void TC115_validate_The_Number_Of_Errors_From_Dashboard_In_Topology_Server_Detect_Point_Graph_Header() throws EncryptedDocumentException, IOException {
    	int expectedErrors = dashboard.getNumberOfErrorsFromErrorGraphHeader();
		topo.validateTheNumberOfErrorsFromDashboardInTopologyServerDetectPointGraphHeader(expectedErrors);
	}
	
	@Test (groups = {"APM","Regression"}) 
	public void TC116_validate_The_Number_Of_Errors_From_Dashboard_In_Topology_Server_Detect_Point_Graph() throws EncryptedDocumentException, IOException {
		int expectedErrors = dashboard.getNumberOfErrorsFromErrorGraphHeader();
		topo.validateTheNumberOfErrorsFromDashboardInTopologyServerDetectPointGraph(expectedErrors);
	}
	
	@Test (groups = {"APM","Regression"}) 
	public void TC117_validate_The_Errors_Per_Mminute_From_Dashboard_In_Topology_Application_Overview_Graph_Header() throws EncryptedDocumentException, IOException {
    	String epm = dashboard.getErrorsPerMinute();
    	topo.navigateToTopologyPage();
		topo.selectApplicationGroupAndMapViewForDataValidation();
		topo.validateTheErrorsPerMinuteFromDashboardInTopologyApplicationOverviewGraphHeader(epm);
	}
	
	@Test (groups = {"APM","Regression"}) 
	public void TC118_validate_The_Errors_Per_Mminute_From_Dashboard_In_Topology_Server_Detect_Point_Graph_Header() throws EncryptedDocumentException, IOException {
		String epm = dashboard.getErrorsPerMinute();
		topo.validateTheErrorsPerMinuteFromDashboardInTopologyServerDetectPointGraphHeader(epm);
	}
	
	@Test (groups = {"APM","Regression"}) 
	public void TC119_validate_The_Errors_Percentage_In_Topology_Application_Overview_Graph_Header() throws EncryptedDocumentException, IOException {
    	int calls = dashboard.getNumberOfCallsFromLoadGraphHeader();
    	int errors = dashboard.getNumberOfErrorsFromErrorGraphHeader();
    	topo.navigateToTopologyPage();
		topo.selectApplicationGroupAndMapViewForDataValidation();
		topo.validateTheErrorsPercentageInTopologyApplicationOverviewGraphHeader(calls, errors);
	}
	
	@Test (groups = {"APM","Regression"}) 
	public void TC120_validate_The_Errors_Percentage_In_Topology_Server_Detect_Point_Graph_Header() throws EncryptedDocumentException, IOException {
    	int calls = dashboard.getNumberOfCallsFromLoadGraphHeader();
    	int errors = dashboard.getNumberOfErrorsFromErrorGraphHeader();
		topo.validateTheErrorsPercentageInTopologyServerDetectPointGraphHeader(calls, errors);
	}
	
	@Test (groups = {"APM","Regression"}) 
	public void TC121_validate_The_Number_Of_Calls_From_Dashboard_In_Topology_Server_Detect_Point_Graph_Header() throws EncryptedDocumentException, IOException {
    	int expectedCalls = dashboard.getNumberOfCallsFromLoadGraphHeader();
		topo.validateTheNumberOfCallsFromDashboardInTopologyServerDetectPointGraphHeader(expectedCalls);
	}
	
	@Test (groups = {"APM","Regression"}) 
	public void TC122_validate_The_Number_Of_Calls_From_Dashboard_In_Topology_Server_Detect_Point_Graph() throws EncryptedDocumentException, IOException {
    	int expectedCalls = dashboard.getNumberOfCallsFromLoadGraphHeader();
		topo.validateTheNumberOfCallsFromDashboardInTopologyServerDetectPointGraph(expectedCalls);
	}
	
	@Test (groups = {"APM","Regression"}) 
	public void TC123_validate_The_Calls_Per_Minute_From_Dashboard_In_Topology_Server_Detect_Point_Graph_Header() throws EncryptedDocumentException, IOException {
    	String expectedCpm = dashboard.getCallsPerMinute();
		topo.validateTheCallsPerMinuteFromDashboardInTopologyServerDetectPointGraphHeader(expectedCpm);
	}
	
	@Test (groups = {"APM","Regression"}) 
	public void TC124_validate_The_Calls_Per_Minute_From_Dashboard_In_Topology_Server_Detect_Point_tooltip() throws EncryptedDocumentException, IOException {
    	String expectedCpm = dashboard.getCallsPerMinute();
    	topo.navigateToTopologyPage();
		topo.selectApplicationGroupAndMapViewForDataValidation();
		topo.validateTheCallsPerMinuteFromDashboardInTopologyServerDetectPointTooltip(expectedCpm);
	}
	
	@Test (groups = {"APM","Regression"})
	public void TC125_validate_Whether_The_Detect_Point_Graph_For_Client_Is_Displayed() throws EncryptedDocumentException, IOException {
		topo.navigateToTopologyPage();
		topo.selectApplicationGroupAndMapViewForDataValidation();
		topo.validateWhetherTheDetectPointGraphForClientIsPDisplayed();
	}
	
	@Test (groups = {"APM","Regression"}) 
	public void TC126_validate_Whether_The_Client_Detect_Point_Is_Displayed_In_Table_View() throws EncryptedDocumentException, IOException {
		topo.navigateToTopologyPage();
		topo.selectApplicationGroupAndTableViewForDataValidation();
		topo.validateWhetherTheClientDetectPointIsDisplayedInTableView();
	}
	
	@Test (groups = {"APM","Regression"}) 
	public void TC127_validate_The_Source_Name_Of_The_Client_Detect_Point_In_Table_View() throws EncryptedDocumentException, IOException {
		topo.navigateToTopologyPage();
		topo.selectApplicationGroupAndTableViewForDataValidation();
		topo.validateTheSourceNameOfTheClientDetectPointInTableView();
	}
	
	@Test (groups = {"APM","Regression"}) 
	public void TC128_validate_The_Destination_Name_Of_The_Client_Detect_Point_In_Table_View() throws EncryptedDocumentException, IOException {
		topo.navigateToTopologyPage();
		topo.selectApplicationGroupAndTableViewForDataValidation();
		topo.validateTheDestinationNameOfTheClientDetectPointInTableView();
	}
	
	@Test (groups = {"APM","Regression"}) 
	public void TC129_validate_The_Calls_Per_Minute_Of_The_Client_Detect_Point_In_Table_View() throws EncryptedDocumentException, IOException {
		topo.navigateToTopologyPage();
		topo.selectApplicationGroupAndMapViewForDataValidation();
		topo.validateTheCallsPerMinuteOfTheClientDetectPointInTableView();
	}
	
	@Test (groups = {"APM","Regression"}) 
	public void TC130_validate_The_Response_Time_Of_The_Client_Detect_Point_In_Table_View() throws EncryptedDocumentException, IOException {
		topo.navigateToTopologyPage();
		topo.selectApplicationGroupAndMapViewForDataValidation();
		topo.validateTheResponseTimeOfTheClientDetectPointInTableView();
	}
	
	@Test (groups = {"APM","Regression"}) 
	public void TC131_validate_The_Average_Response_Time_From_Database_Page_In_Topology_Client_Detect_Point_Graph() throws EncryptedDocumentException, IOException {
		String expectedRespTime = database.getAverageResponseTimeFromResponseTimeGraph();
		topo.validateTheAverageResponseTimeFromDatabasePageInTopologyClientDetectPointGraph(expectedRespTime);
	}
	
	@Test (groups = {"APM","Regression"}) 
	public void TC132_validate_The_Average_Response_Time_From_Database_Page_In_Topology_Client_Detect_Point_Tooltip() throws EncryptedDocumentException, IOException {
		database.navigateToDatabasePage();
		String expectedRespTime = database.getAverageResponseTimeFromResponseTimeGraph();
		topo.navigateToTopologyPage();
		topo.selectApplicationGroupAndMapViewForDataValidation();
		topo.validateTheAverageResponseTimeFromDatabasePageInTopologyClientDetectPointTooltip(expectedRespTime);
	}
	
	@Test (groups = {"APM","Regression"}) 
	public void TC133_validate_The_Number_Of_Calls_From_Database_Page_In_Topology_Client_Detect_Point_Graph_Header() throws EncryptedDocumentException, IOException {
		database.navigateToDatabasePage();
		String calls = database.getNumberOfCallsFromLoadGraph();
		topo.validateTheNumberOfCallsFromDatabasePageInTopologyClientDetectPointGraphHeader(calls);
	}
	
	@Test (groups = {"APM","Regression"}) 
	public void TC134_validate_The_Number_Of_Calls_From_Database_Page_In_Topology_Client_Detect_Point_Graph() throws EncryptedDocumentException, IOException {
		database.navigateToDatabasePage();
		String calls = database.getNumberOfCallsFromLoadGraph();
		topo.validateTheNumberOfCallsFromDatabasePageInTopologyClientDetectPointGraph(calls);
	}
	
	@Test (groups = {"APM","Regression"}) 
	public void TC135_validate_The_Calls_Per_Minute_From_Database_Page_In_Topology_Client_Detect_Point_Graph_Header() throws EncryptedDocumentException, IOException {
		database.navigateToDatabasePage();
		String expectedCpm = database.getCallsPerMinuteFromLoadGraph();
		topo.validateTheCallsPerMinuteFromDatabasePageInTopologyClientDetectPointGraphHeader(expectedCpm);
	}
	
	@Test (groups = {"APM","Regression"}) 
	public void TC136_validate_The_Calls_Per_Minute_From_Database_Page_In_Topology_Client_Detect_Point_Tooltip() throws EncryptedDocumentException, IOException {
    	String expectedCpm = database.getCallsPerMinuteFromLoadGraph();
    	topo.navigateToTopologyPage();
		topo.selectApplicationGroupAndMapViewForDataValidation();
		topo.validateTheCallsPerMinuteFromDatabasePageInTopologyClientDetectPointTooltip(expectedCpm);
	}
	
	@Test (groups = {"APM","Regression"}) 
	public void TC137_validate_The_Number_Of_Errors_From_Database_Page_In_Topology_Client_Detect_Point_Graph_Header() throws EncryptedDocumentException, IOException {
		database.navigateToDatabasePage();
		String errors = database.getNumberOfErrorsFromAccessErrorGraph();
		topo.validateTheNumberOfErrorsFromDatabasePageInTopologyClientDetectPointGraphHeader(errors);
	}
	
	@Test (groups = {"APM","Regression"}) 
	public void TC138_validate_The_Number_Of_Errors_From_Database_Page_In_Topology_Client_Detect_Point_Graph() throws EncryptedDocumentException, IOException {
		database.navigateToDatabasePage();
		String errors = database.getNumberOfErrorsFromAccessErrorGraph();
		topo.validateTheNumberOfErrorsFromDatabasePageInTopologyClientDetectPointGraph(errors);
	}
	
	@Test (groups = {"APM","Regression"}) 
	public void TC139_validate_The_Errors_Per_Minute_From_Database_Page_In_Topology_Client_Detect_Point_Graph_Header() throws EncryptedDocumentException, IOException {
		database.navigateToDatabasePage();
		String epm = database.getErrorsPerMinuteFromAccessErrorGraph();
		topo.validateTheErrorsPerMinuteFromDatabasePageInTopologyClientDetectPointGraphHeader(epm);
	}
	
	@Test (groups = {"APM","Regression"}) 
	public void TC140_validate_The_Errors_Percentage_From_Database_Page_In_Topology_Client_Detect_Point_Graph_Header() throws EncryptedDocumentException, IOException {
		database.navigateToDatabasePage();
		String errorPercent = database.getErrorsPercentageFromAccessErrorGraph();
		topo.validateTheErrorsPercentageFromDatabasePageInTopologyClientDetectPointGraphHeader(errorPercent);
	}
	
	@Test (groups = {"APM","Regression"}) 
	public void TC141_validate_The_Percentile_Response_Time_Value_From_Database_Page_In_Client_Detect_Point_Graph() throws EncryptedDocumentException, IOException {
		List<Object> expectedPercentileRespTimeValues = database.getPercentileResponseTime();
    	topo.navigateToClientDetectPointGraph();
		topo.validateThePercentileResponseTimeValueFromDatabasePageInDetectPointGraph(expectedPercentileRespTimeValues);
	}
	
	@Test (groups = {"APM","Regression"}) 
	public void TC142_validate_The_Percentile_Response_Time_Value_From_Database_Page_In_Server_Detect_Point_Graph() throws EncryptedDocumentException, IOException {
		List<Object> expectedPercentileRespTimeValues = dashboard.getPercentileResponseTime();
		topo.navigateToServerDetectPointGraph();
		topo.validateThePercentileResponseTimeValueFromDatabasePageInDetectPointGraph(expectedPercentileRespTimeValues);
	}
	
	@Test (groups = {"APM","Regression"}) 
	public void TC143_validate_Whether_The_Show_Instance_Dependancy_Button_Is_Present_With_Client_Detect_point_Graph_Panel() throws EncryptedDocumentException, IOException {
		topo.navigateToClientDetectPointGraph();
		topo.validateWhetherTheShowInstanceDependancyButtonIsPresentWithClientDetectpointGraphPanel();
	}
	
	@Test (groups = {"APM","Regression"}) 
	public void TC144_validate_The_Functionality_Of_Show_Instance_Dependancy_Button_In_Client_Detect_point_Graph_Panel() throws EncryptedDocumentException, IOException {
		topo.navigateToClientDetectPointGraph();
		topo.validateTheFunctionalityOfShowInstanceDependancyButtonInClientDetectpointGraphPanel();
	}
	
	@Test (groups = {"APM","Regression"}) 
	public void TC145_validate_The_Functionality_Of_Hide_Instance_Dependancy_Button_In_Client_Detect_point_Graph_Panel() throws EncryptedDocumentException, IOException {
		topo.navigateToClientDetectPointGraph();
		topo.validateTheFunctionalityOfHideInstanceDependancyButtonInClientDetectpointGraphPanel();
	}
	
	@Test (groups = {"APM","Regression"}) 
	public void TC146_validate_The_Functionality_Of_Instance_Dependancy_Close_Button_In_Client_Detect_point_Graph_Panel() throws EncryptedDocumentException, IOException {
		topo.navigateToClientDetectPointGraph();
		topo.validateTheFunctionalityOfInstanceDependancyCloseButtonInClientDetectpointGraphPanel();
	}
	
	@Test (groups = {"APM","Regression"}) 
	public void TC147_delete_The_Application_Group() throws EncryptedDocumentException, IOException {
		topo.navigateToTopologyPage();
		String grpName = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.topologyPageSheet, "groupNameForAddingGroup");
		topo.validateWhetherAGroupCanBeDeleted(grpName);
	}
	
	@Test (groups = {"APM","Regression"})
	public void TC148_validate_The_Number_Of_Traces_Per_Endoint_InTrace_Page() throws EncryptedDocumentException, IOException {
		trace.validateTheNumberOfTracesPerEndpoint();
	}
	
	@AfterMethod
	public void closethePopupIfPresent() {
		topo.closeThePopup();
	}
}