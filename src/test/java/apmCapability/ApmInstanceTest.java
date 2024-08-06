package apmCapability;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import genericUtilities.ExcelUtility;
import genericUtilities.GenericMethods;
import genericUtilities.IPathConstant;
import objectRepository.CommonPage;
import objectRepository.APM.ApmEndpointPage;
import objectRepository.APM.ApmInstancePage;
import playWrightFactory.BaseClass;

public class ApmInstanceTest extends BaseClass {
	GenericMethods util;
	CommonPage common;
	ApmInstancePage instance;
	ApmEndpointPage endpoint;
	ExcelUtility excel = new ExcelUtility();
	
	@BeforeMethod
	public void bmConfig() throws EncryptedDocumentException, IOException, InterruptedException {
		instance = new ApmInstancePage(page);
		endpoint = new ApmEndpointPage(page);
		common = new CommonPage(page);
		util = new GenericMethods();
		common.navigateToApm();
		common.selectTheTimeLineFromCalender(IPathConstant.oneMonthTimeRange);
		endpoint.selectApplication();
		instance.navigateToInstancePage();
	}
	
	@Test (groups = {"APM","UI","Regression"})
	public void TC01_validate_The_First_Column_Name_of_InstancePage_Table() throws EncryptedDocumentException, IOException {
		instance.validateFirstColNameOfInstancePageTable();
	}

	@Test (groups = {"APM","UI","Regression"})
	public void TC02_validate_The_Second_Column_Name_of_InstancePage_Table() throws EncryptedDocumentException, IOException {
		instance.validateSecondColNameOfInstancePageTable();
	}
	
	@Test (groups = {"APM","UI","Regression"})
	public void TC03_validate_The_Third_Column_Name_of_InstancePage_Table() throws EncryptedDocumentException, IOException {
		instance.validateThirdColNameOfInstancePageTable();
	}
	
	@Test (groups = {"APM","UI","Regression"})
	public void TC04_validate_The_Fourth_Column_Name_of_InstancePage_Table() throws EncryptedDocumentException, IOException {
		instance.validateFourthColNameOfInstancePageTable();
	}
	
	@Test (groups = {"APM","UI","Regression"})
	public void TC05_validate_The_Fifth_Column_Name_of_InstancePage_Table() throws EncryptedDocumentException, IOException {
		instance.validateFifthColNameOfInstancePageTable();
	}
	
	@Test (groups = {"APM","UI","Regression"})
	public void TC06_validate_The_Sixth_Column_Name_of_InstancePage_Table() throws EncryptedDocumentException, IOException {
		instance.validateSixthColNameOfInstancePageTable();
	}
	
	@Test (groups = {"APM","UI","Regression"})
	public void TC07_validate_The_Seventh_Column_Name_of_InstancePage_Table() throws EncryptedDocumentException, IOException {
		instance.validateSeventhColNameOfInstancePageTable();
	}
	
	@Test (groups = {"APM","UI","Regression"})
	public void TC08_validate_Serach_Instances_Functionality_With_Valid_Data() {
		instance.validateSearchInstanceFunctionalityWithValidData();
	}
	
	@Test (groups = {"APM","UI","Regression"})
	public void TC09_validate_Serach_Instances_Functionality_With_Invalid_Data() {
		instance.validateSearchInstanceFunctionalityWithInvalidData();
	}
	
	@Test (groups = {"APM","UI","Regression"})
	public void TC10_validate_Edit_Instances_Functionality() throws EncryptedDocumentException, IOException {
		instance.validateTheEditInstanceFunctionality();
	}
	
	@Test (groups = {"APM","UI","Regression"})
	public void TC11_validate_The_Ascending_Functionality_Of_Error_Percentage_Column() {
		instance.sortErrorPercentageColInAscOrderAndValidate();
	}
	
	@Test (groups = {"APM","UI","Regression"})
	public void TC12_validate_The_Descending_Functionality_Of_Error_Percentage_Column() {
		instance.sortErrorPercentageColInDesOrderAndValidate();
	}
	
	@Test (groups = {"APM","UI","Regression"})
	public void TC13_validate_The_Ascending_Functionality_Of_Errors_Column() {
		instance.sortErrorsColInAscOrderAndValidate();
	}
	
	@Test (groups = {"APM","UI","Regression"})
	public void TC14_validate_The_Descending_Functionality_Of_Errors_Column() {
		instance.sortErrorsColInDesOrderAndValidate();
	}
	
	@Test (groups = {"APM","UI","Regression"})
	public void TC15_validate_The_Ascending_Functionality_Of_Errors_Per_Minute_Column() {
		instance.sortErrorsPerMinColInAscOrderAndValidate();
	}
	
	@Test (groups = {"APM","UI","Regression"})
	public void TC16_validate_The_Descending_Functionality_Of_Errors_Per_Minute_Column() {
		instance.sortErrorsPerMinColInDesOrderAndValidate();
	}
	
	@Test (groups = {"APM","UI","Regression"})
	public void TC17_validate_The_Ascending_Functionality_Of_Response_Time_Column() {
		instance.sortResponseTimeColInAscOrderAndValidate();
	}
	
	@Test (groups = {"APM","UI","Regression"})
	public void TC18_validate_The_Descending_Functionality_Of_Response_Time_Column() {
		instance.sortResponseTimeColInDesOrderAndValidate();
	}
	
	@Test (groups = {"APM","UI","Regression"})
	public void TC19_validate_The_Ascending_Functionality_Of_Calls_Column() {
		instance.sortCallsColInAscOrderAndValidate();
	}
	
	@Test (groups = {"APM","UI","Regression"})
	public void TC20_validate_The_Descending_Functionality_Of_Calls_Column() {
		instance.sortCallsColInDesOrderAndValidate();
	}
	
	@Test (groups = {"APM","UI","Regression"})
	public void TC21_validate_The_Ascending_Functionality_Of_Calls_Per_Minute_Column() {
		instance.sortCallsPerMinColInAscOrderAndValidate();
	}
	
	@Test (groups = {"APM","UI","Regression"})
	public void TC22_validate_The_Descending_Functionality_Of_Calls_Per_Minute_Column() {
		instance.sortCallsPerMinColInDesOrderAndValidate();
	}
	
	@Test (groups = {"APM","UI","Regression"})
	public void TC23_validate_The_Navigation_To_Instance_Graph_Page() {
		instance.navigateToInstanceGraphPageAndValidateTheInstanceName();
	}
	
	@Test (groups = {"APM","UI","Regression"})
	public void TC24_validate_The_Functionality_Of_Back_Button_Of_Instance_Graph_Page() {
		instance.clickOnBackButtonOfInstanceGraphPageAndValidate();
	}
	
	@Test (groups = {"APM","UI","Regression"})
	public void TC25_validate_The_Load_Graph_Title_In_Instance_Graph_Page() throws EncryptedDocumentException, IOException {
		instance.validateTheLoadGraphTitleInInstanceGraphPage();
	}
	
	@Test (groups = {"APM","UI","Regression"})
	public void TC26_validate_The_Load_Graph_Xaxis_Title_In_Instance_Graph_Page() throws EncryptedDocumentException, IOException {
		instance.validateTheLoadGraphXaxisTitleInInstanceGraphPage();
	}
	
	@Test (groups = {"APM","UI","Regression"})
	public void TC27_validate_The_Load_Graph_Yaxis_Title_In_Instance_Graph_Page() throws EncryptedDocumentException, IOException {
		instance.validateTheLoadGraphYaxisTitleInInstanceGraphPage();
	}
	
	@Test (groups = {"APM","UI","Regression"})
	public void TC28_validate_The_Functionality_Of_Load_Graph_Zoom_In_Button() throws EncryptedDocumentException, IOException {
		instance.validateTheFunctionalityOfLoadGraphZoomInButton();
	}
	
	@Test (groups = {"APM","UI","Regression"})
	public void TC29_validate_The_Functionality_Of_Load_Graph_Zoom_Out_Button() throws EncryptedDocumentException, IOException {
		instance.validateTheFunctionalityOfLoadGraphZoomOutButton();
	}
	
	@Test (groups = {"APM","UI","Regression"})
	public void TC30_validate_The_Functionality_Of_Load_Graph_Zoom_Reset_Button() throws EncryptedDocumentException, IOException {
		instance.validateTheFunctionalityOfLoadGraphZoomResetButton();
	}
	
	@Test (groups = {"APM","UI","Regression"})
	public void TC31_validate_Zoom_In_By_Drag_And_Drop_For_Load_Graph() throws EncryptedDocumentException, IOException {
		instance.validateZoomInByDragAndDropForLoadGraph();
	}
	
	@Test (groups = {"APM","UI","Regression"})
	public void TC32_validate_Whether_The_Tooltip_Is_Displaying_For_Load_Graph() {
		instance.validateWhetherTheTooltipIsDisplayingForLoadGraph();
	}
	
	@Test (groups = {"APM","UI","Regression"})
	public void TC33_validate_The_Error_Graph_Title_In_Instance_Graph_Page() throws EncryptedDocumentException, IOException {
		instance.validateTheErrorGraphTitleInInstanceGraphPage();
	}
	
	@Test (groups = {"APM","UI","Regression"})
	public void TC34_validate_The_Error_Graph_Xaxis_Title_In_Instance_Graph_Page() throws EncryptedDocumentException, IOException {
		instance.validateTheErrorGraphXaxisTitleInInstanceGraphPage();
	}
	
	@Test (groups = {"APM","UI","Regression"})
	public void TC35_validate_The_Error_Graph_Yaxis_Title_In_Instance_Graph_Page() throws EncryptedDocumentException, IOException {
		instance.validateTheErrorGraphYaxisTitleInInstanceGraphPage();
	}
	
	@Test (groups = {"APM","UI","Regression"})
	public void TC36_validate_The_Functionality_Of_Error_Graph_Zoom_In_Button() throws EncryptedDocumentException, IOException {
		instance.validateTheFunctionalityOfErrorGraphZoomInButton();
	}
	
	@Test (groups = {"APM","UI","Regression"})
	public void TC37_validate_The_Functionality_Of_Error_Graph_Zoom_Out_Button() throws EncryptedDocumentException, IOException {
		instance.validateTheFunctionalityOfErrorGraphZoomOutButton();
	}
	
	@Test (groups = {"APM","UI","Regression"})
	public void TC38_validate_The_Functionality_Of_Error_Graph_Zoom_Reset_Button() throws EncryptedDocumentException, IOException {
		instance.validateTheFunctionalityOfErrorGraphZoomResetButton();
	}
	
	@Test (groups = {"APM","UI","Regression"})
	public void TC39_validate_Zoom_In_By_Drag_And_Drop_For_Error_Graph() throws EncryptedDocumentException, IOException {
		instance.validateZoomInByDragAndDropForErrorGraph();
	}
	
	@Test (groups = {"APM","UI","Regression"})
	public void TC40_validate_Whether_The_Tooltip_Is_Displaying_For_Error_Graph() {
		instance.validateWhetherTheTooltipIsDisplayingForErrorGraph();
	}
	
	@Test (groups = {"APM","UI","Regression"})
	public void TC41_validate_The_ResponseTime_Graph_Title_In_Instance_Graph_Page() throws EncryptedDocumentException, IOException {
		instance.validateTheResponseTimeGraphTitleInInstanceGraphPage();
	}
	
	@Test (groups = {"APM","UI","Regression"})
	public void TC42_validate_The_ResponseTime_Graph_Xaxis_Title_In_Instance_Graph_Page() throws EncryptedDocumentException, IOException {
		instance.validateTheResponseTimeGraphXaxisTitleInInstanceGraphPage();
	}
	
	@Test (groups = {"APM","UI","Regression"})
	public void TC43_validate_The_ResponseTime_Graph_Yaxis_Title_In_Instance_Graph_Page() throws EncryptedDocumentException, IOException {
		instance.validateTheResponseTimeGraphYaxisTitleInInstanceGraphPage();
	}
	
	@Test (groups = {"APM","UI","Regression"})
	public void TC44_validate_The_Functionality_Of_ResponseTime_Graph_Zoom_In_Button() throws EncryptedDocumentException, IOException {
		instance.validateTheFunctionalityOfResponseTimeGraphZoomInButton();
	}
	
	@Test (groups = {"APM","UI","Regression"})
	public void TC45_validate_The_Functionality_Of_ResponseTime_Graph_Zoom_Out_Button() throws EncryptedDocumentException, IOException {
		instance.validateTheFunctionalityOfResponseTimeGraphZoomOutButton();
	}
	
	@Test (groups = {"APM","UI","Regression"})
	public void TC46_validate_The_Functionality_Of_ResponseTime_Graph_Zoom_Reset_Button() throws EncryptedDocumentException, IOException {
		instance.validateTheFunctionalityOfResponseTimeGraphZoomResetButton();
	}
	
	@Test (groups = {"APM","UI","Regression"})
	public void TC47_validate_Zoom_In_By_Drag_And_Drop_For_ResponseTime_Graph() throws EncryptedDocumentException, IOException {
		instance.validateZoomInByDragAndDropForResponseTimeGraph();
	}
	
	@Test (groups = {"APM","UI","Regression"})
	public void TC48_validate_Whether_The_Tooltip_Is_Displaying_For_ResponseTime_Graph() {
		instance.validateWhetherTheTooltipIsDisplayingForResponseTimeGraph();
	}
	
	@Test (groups = {"APM","UI","Regression"})
	public void TC49_validate_First_Error_Percentage_In_Instance_Graph_Page() throws EncryptedDocumentException, IOException {
		instance.validateFirstErrorPercentageInInstanceGraphPage();
	}
	
	@Test (groups = {"APM","UI","Regression"})
	public void TC50_validate_First_Errors_In_Instance_Graph_Page() throws EncryptedDocumentException, IOException {
		instance.validateFirstErrorsInInstanceGraphPage();
	}
	
	@Test (groups = {"APM","UI","Regression"})
	public void TC51_validate_First_Error_Per_Minute_In_Instance_Graph_Page() throws EncryptedDocumentException, IOException {
		instance.validateFirstErrorPerMinInInstanceGraphPage();
	}
	
	@Test (groups = {"APM","UI","Regression"})
	public void TC52_validate_First_Calls_In_Instance_Graph_Page() throws EncryptedDocumentException, IOException {
		instance.validateFirstCallsInInstanceGraphPage();
	}
	
	@Test (groups = {"APM","UI","Regression"})
	public void TC53_validate_First_Calls_Per_Minute_In_Instance_Graph_Page() throws EncryptedDocumentException, IOException {
		instance.validateFirstCallsPerMinInInstanceGraphPage();
	}
	
	@Test (groups = {"APM","UI","Regression"})
	public void TC54_validate_First_Response_Time_In_Instance_Graph_Page() throws EncryptedDocumentException, IOException {
		instance.validateFirstResponseTimeInInstanceGraphPage();
	}
	
	@Test (groups = {"APM","UI","Regression"})
	public void TC55_validate_Whether_The_Xaxis_Lables_Are_According_To_5_Mins_Timeline() {
		common.selectTheTimeLineFromCalender(IPathConstant.fiveMinutesTimeRange);
		instance.ValidateTheXaxisLablesAccordingToTheSelectedTimeline();
	}
	
	@Test (groups = {"APM","UI","Regression"})
	public void TC56_validate_Whether_The_Xaxis_Lables_Are_According_To_15_Mins_Timeline() {
		common.selectTheTimeLineFromCalender(IPathConstant.fifteenMinutesTimeRange);
		instance.ValidateTheXaxisLablesAccordingToTheSelectedTimeline();
	}
	
	@Test (groups = {"APM","UI","Regression"})
	public void TC57_validate_Whether_The_Xaxis_Lables_Are_According_To_30_Mins_Timeline() {
		common.selectTheTimeLineFromCalender(IPathConstant.thirtyMinutesTimeRange);
		instance.ValidateTheXaxisLablesAccordingToTheSelectedTimeline();	}
	
	@Test (groups = {"APM","UI","Regression"})
	public void TC58_validate_Whether_The_Xaxis_Lables_Are_According_To_60_Mins_Timeline() {
		common.selectTheTimeLineFromCalender(IPathConstant.sixtyMinutesTimeRange);
		instance.ValidateTheXaxisLablesAccordingToTheSelectedTimeline();
	}
	
	@Test (groups = {"APM","UI","Regression"})
	public void TC59_validate_Whether_The_Xaxis_Lables_Are_According_To_3_Hours_Timeline() {
		common.selectTheTimeLineFromCalender(IPathConstant.threeHoursTimeRange);
		instance.ValidateTheXaxisLablesAccordingToTheSelectedTimeline();
	}
	
	@Test (groups = {"APM","UI","Regression"})
	public void TC60_validate_Whether_The_Xaxis_Lables_Are_According_To_6_Hours_Timeline() {
		common.selectTheTimeLineFromCalender(IPathConstant.sixHoursTimeRange);
		instance.ValidateTheXaxisLablesAccordingToTheSelectedTimeline();
	}
	
	@Test (groups = {"APM","UI","Regression"})
	public void TC61_validate_Whether_The_Xaxis_Lables_Are_According_To_12_Hours_Timeline() {
		common.selectTheTimeLineFromCalender(IPathConstant.twelveHoursTimeRange);
		instance.ValidateTheXaxisLablesAccordingToTheSelectedTimeline();
	}
	
	@Test (groups = {"APM","UI","Regression"})
	public void TC62_validate_Whether_The_Xaxis_Lables_Are_According_To_1_Day_Timeline() {
		common.selectTheTimeLineFromCalender(IPathConstant.oneDayTimeRange);
		instance.ValidateTheXaxisLablesAccordingToTheSelectedTimeline();
	}
	
	@Test (groups = {"APM","UI","Regression"})
	public void TC63_validate_Whether_The_Xaxis_Lables_Are_According_To_1_Week_Timeline() {
		common.selectTheTimeLineFromCalender(IPathConstant.oneWeekTimeRange);
		instance.ValidateTheXaxisLablesAccordingToTheSelectedTimeline();
	}
	
	@Test (groups = {"APM","UI","Regression"})
	public void TC64_validate_Whether_The_Xaxis_Lables_Are_According_To_1_Month_Timeline() {
		common.selectTheTimeLineFromCalender(IPathConstant.oneMonthTimeRange);
		instance.ValidateTheXaxisLablesAccordingToTheSelectedTimeline();
	}
	
	@Test
	public void TC65_validate_The_All_Widgets_By_selecting_custom_Time_For_Minutes_Range() throws EncryptedDocumentException, IOException{
		instance.navigateToInstanceGraphPageAndValidateTheInstanceName();
		commPage.selectTheCustomeTimeLine(IPathConstant.customTimeRange, excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customMinutesRange"));
		instance.validateTheCustomTimeLine(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customMinutesRange"));
	}
	
	@Test
	public void TC66_validate_The_All_Widgets_By_selecting_custom_Time_For_Hours_Range() throws EncryptedDocumentException, IOException{
		instance.navigateToInstanceGraphPageAndValidateTheInstanceName();
		commPage.selectTheCustomeTimeLine(IPathConstant.customTimeRange, excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customHoursRange"));
		instance.validateTheCustomTimeLine(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customHoursRange"));
	}
	
	@Test
	public void TC67_validate_The_All_Widgets_By_selecting_custom_Time_For_Days_Range() throws EncryptedDocumentException, IOException{
		instance.navigateToInstanceGraphPageAndValidateTheInstanceName();
		commPage.selectTheCustomeTimeLine(IPathConstant.customTimeRange, excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customDaysRange"));
		instance.validateTheCustomTimeLine(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customDaysRange"));
	}
	
	@Test
	public void TC68_validate_The_All_Widgets_By_selecting_custom_Time_For_Future_date() throws EncryptedDocumentException, IOException{
		instance.navigateToInstanceGraphPageAndValidateTheInstanceName();
		common.selectTheTimeLineFromCalender(IPathConstant.fiveMinutesTimeRange);
		commPage.validateTheFutureTimeLine();
	}
	
	@Test (dataProvider = "pagination", groups = {"APM","UI","Regression"})
	public void TC69_validate_Pagination(String num) {
		instance.validatePagination(Integer.parseInt(num));
	}
	
	@Test (groups = {"APM", "UI", "Regression"})
	public void TC70_validate_The_Soft_Refresh_Options_Selection() throws EncryptedDocumentException, IOException {
		common.validateRefreshOptionsForAvailabilityAndSelection();
	}
	
	@DataProvider 
	public Object[][] pagination() throws Exception, Exception {
		return excel.fetchAllTheDataFromExcelSheet(IPathConstant.commExcelPath, IPathConstant.commonPaginationSheet);
	}
}
