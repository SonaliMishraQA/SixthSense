package browserMonitoringCapability;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import genericUtilities.ExcelUtility;
import genericUtilities.GenericMethods;
import genericUtilities.IPathConstant;
import objectRepository.CommonPage;
import objectRepository.BM.BmApplicationPage;
import playWrightFactory.BaseClass;

public class BmApplicationTest extends BaseClass{
	GenericMethods util = new GenericMethods();
	CommonPage common;
	BmApplicationPage bmApp;
	ExcelUtility excel = new ExcelUtility();
	
	@BeforeMethod
	public void bmConfig() throws EncryptedDocumentException, IOException, InterruptedException {
		bmApp = new BmApplicationPage(page);
		common = new CommonPage(page);
		common.navigateToBrowserMonitoring();
		common.selectTheTimeLineFromCalender(IPathConstant.oneMonthTimeRange);
		bmApp.selectApplication();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC01_validate_Whether_The_Application_Tab_Is_Active_By_Default() {
		bmApp.validateWhetherTheApplicationTabIsActiveByDefault();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC02_validate_The_Title_Of_Apdex_Score_Widget() throws EncryptedDocumentException, IOException {
		bmApp.validateTheTitleOfApdexScoreWidget();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC03_validate_The_Title_Of_Health_Indicator_Label_In_Apdex_Score_Widget() throws EncryptedDocumentException, IOException {
		bmApp.validateTheTitleOfHealthIndicatorLabelInApdexScoreWidget();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC04_validate_The_Label_And_Value_Of_Good_Health_Indicator_In_Apdex_Score_Widget() throws EncryptedDocumentException, IOException {
		bmApp.validateTheLabelAndValueOfGoodHealthIndicatorInApdexScoreWidget();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC05_validate_The_Label_And_Value_Of_Fair_Health_Indicator_In_Apdex_Score_Widget() throws EncryptedDocumentException, IOException {
		bmApp.validateTheLabelAndValueOfFairHealthIndicatorInApdexScoreWidget();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC06_validate_The_Label_And_Value_Of_Poor_Health_Indicator_In_Apdex_Score_Widget() throws EncryptedDocumentException, IOException {
		bmApp.validateTheLabelAndValueOfPoorHealthIndicatorInApdexScoreWidget();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC07_validate_The_Color_Of_The_Good_Health_Indicator_Elements_In_Apdex_Score_Widget() throws EncryptedDocumentException, IOException {
		bmApp.validateTheColorOfTheGoodHealthIndicatorElementsInApdexScoreWidget();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC08_validate_The_Color_Of_The_Fair_Health_Indicator_Elements_In_Apdex_Score_Widget() throws EncryptedDocumentException, IOException {
		bmApp.validateTheColorOfTheFairHealthIndicatorElementsInApdexScoreWidget();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC09_validate_The_Color_Of_The_Poor_Health_Indicator_Elements_In_Apdex_Score_Widget() throws EncryptedDocumentException, IOException {
		bmApp.validateTheColorOfThePoorHealthIndicatorElementsInApdexScoreWidget();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC10_validate_The_Color_Of_The_Apdex_Score_Indicator_In_Apdex_Score_Widget() throws EncryptedDocumentException, IOException {
		bmApp.validateTheColorOfTheApdexScoreIndicatorInApdexScoreWidget();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC11_validate_The_Title_Of_Load_Widget() throws EncryptedDocumentException, IOException {
		bmApp.validateTheTitleOfLoadWidget();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC12_validate_The_Xaxis_Title_Of_Load_Widget() throws EncryptedDocumentException, IOException {
		bmApp.validateTheXaxisTitleOfLoadWidget();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC13_validate_The_Yaxis_Title_Of_Load_Widget() throws EncryptedDocumentException, IOException {
		bmApp.validateTheYaxisTitleOfLoadWidget();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC14_validate_The_Functionality_Of_Load_Widget_Zoom_In_Button() throws EncryptedDocumentException, IOException {
		bmApp.validateTheFunctionalityOfLoadWidgetZoomInButton();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC15_validate_The_Functionality_Of_Load_Widget_Zoom_Out_Button() throws EncryptedDocumentException, IOException {
		bmApp.validateTheFunctionalityOfLoadWidgetZoomOutButton();
	}

	@Test (groups = {"BM","UI","Regression"})
	public void TC16_validate_The_Functionality_Of_Load_Widget_Zoom_Reset_Button() throws EncryptedDocumentException, IOException {
		bmApp.validateTheFunctionalityOfLoadWidgetZoomResetButton();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC17_validate_Zoom_In_By_Drag_And_Drop_For_Load_Widget() throws EncryptedDocumentException, IOException {
		bmApp.validateZoomInByDragAndDropForLoadWidget();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC18_validate_Whether_The_Tooltip_Is_Displaying_For_Load_Widget() {
		bmApp.validateWhetherTheTooltipIsDisplayingForLoadWidget();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC19_validate_The_Title_Of_Load_Time_Widget() throws EncryptedDocumentException, IOException {
		bmApp.validateTheTitleOfLoadTimeWidget();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC20_validate_The_Xaxis_Title_Of_Load_Time_Widget() throws EncryptedDocumentException, IOException {
		bmApp.validateTheXaxisTitleOfLoadTimeWidget();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC21_validate_The_Yaxis_Title_Of_Load_Time_Widget() throws EncryptedDocumentException, IOException {
		bmApp.validateTheYaxisTitleOfLoadTimeWidget();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC22_validate_The_Functionality_Of_Load_Time_Widget_Zoom_In_Button() throws EncryptedDocumentException, IOException {
		bmApp.validateTheFunctionalityOfLoadTimeWidgetZoomInButton();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC23_validate_The_Functionality_Of_Load_Time_Widget_Zoom_Out_Button() throws EncryptedDocumentException, IOException {
		bmApp.validateTheFunctionalityOfLoadTimeWidgetZoomOutButton();
	}

	@Test (groups = {"BM","UI","Regression"})
	public void TC24_validate_The_Functionality_Of_Load_Time_Widget_Zoom_Reset_Button() throws EncryptedDocumentException, IOException {
		bmApp.validateTheFunctionalityOfLoadTimeWidgetZoomResetButton();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC25_validate_Zoom_In_By_Drag_And_Drop_For_Load_Time_Widget() throws EncryptedDocumentException, IOException {
		bmApp.validateZoomInByDragAndDropForLoadTimeWidget();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC26_validate_Whether_The_Tooltip_Is_Displaying_For_Load_Time_Widget() {
		bmApp.validateWhetherTheTooltipIsDisplayingForLoadTimeWidget();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC27_validate_The_Title_Of_Error_Widget() throws EncryptedDocumentException, IOException {
		bmApp.validateTheTitleOfErrorWidget();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC28_validate_The_Xaxis_Title_Of_Error_Widget() throws EncryptedDocumentException, IOException {
		bmApp.validateTheXaxisTitleOfErrorWidget();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC29_validate_The_Yaxis_Title_Of_Error_Widget() throws EncryptedDocumentException, IOException {
		bmApp.validateTheYaxisTitleOfErrorWidget();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC30_validate_The_Functionality_Of_Error_Widget_Zoom_In_Button() throws EncryptedDocumentException, IOException {
		bmApp.validateTheFunctionalityOfErrorWidgetZoomInButton();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC31_validate_The_Functionality_Of_Error_Widget_Zoom_Out_Button() throws EncryptedDocumentException, IOException {
		bmApp.validateTheFunctionalityOfErrorWidgetZoomOutButton();
	}

	@Test (groups = {"BM","UI","Regression"})
	public void TC32_validate_The_Functionality_Of_Error_Widget_Zoom_Reset_Button() throws EncryptedDocumentException, IOException {
		bmApp.validateTheFunctionalityOfErrorWidgetZoomResetButton();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC33_validate_Zoom_In_By_Drag_And_Drop_For_Error_Widget() throws EncryptedDocumentException, IOException {
		bmApp.validateZoomInByDragAndDropForErrorWidget();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC34_validate_Whether_The_Tooltip_Is_Displaying_For_Error_Widget() {
		bmApp.validateWhetherTheTooltipIsDisplayingForErrorWidget();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC35_validate_The_Title_Of_User_Impacted_By_Errors_Widget() throws EncryptedDocumentException, IOException {
		bmApp.validateTheTitleOfUserImpactedByErrorsWidget();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC36_validate_The_Xaxis_Title_Of_User_Impacted_By_Errors_Widget() throws EncryptedDocumentException, IOException {
		bmApp.validateTheXaxisTitleOfUserImpactedByErrorsWidget();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC37_validate_The_Yaxis_Title_Of_User_Impacted_By_Errors_Widget() throws EncryptedDocumentException, IOException {
		bmApp.validateTheYaxisTitleOfUserImpactedByErrorsWidget();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC38_validate_Whether_The_Tooltip_Is_Displaying_For_User_Impacted_By_Errors_Widget() {
		bmApp.validateWhetherTheTooltipIsDisplayingForUserImpactedByErrorsWidget();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC39_validate_The_Title_Of_Error_Count_Map_Widget() throws EncryptedDocumentException, IOException {
		bmApp.validateTheTitleOfErrorCountMapWidget();
	}

	@Test (groups = {"BM","UI","Regression"})
	public void TC40_validate_Whether_The_Xaxis_Lables_Are_According_To_5_Mins_Timeline() {
		common.selectTheTimeLineFromCalender(IPathConstant.fiveMinutesTimeRange);
		bmApp.ValidateTheXaxisLablesAccordingToTheSelectedTimeline();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC41_validate_Whether_The_Xaxis_Lables_Are_According_To_15_Mins_Timeline() {
		common.selectTheTimeLineFromCalender(IPathConstant.fifteenMinutesTimeRange);
		bmApp.ValidateTheXaxisLablesAccordingToTheSelectedTimeline();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC42_validate_Whether_The_Xaxis_Lables_Are_According_To_30_Mins_Timeline() {
		common.selectTheTimeLineFromCalender(IPathConstant.thirtyMinutesTimeRange);
		bmApp.ValidateTheXaxisLablesAccordingToTheSelectedTimeline();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC43_validate_Whether_The_Xaxis_Lables_Are_According_To_60_Mins_Timeline() {
		common.selectTheTimeLineFromCalender(IPathConstant.sixtyMinutesTimeRange);
		bmApp.ValidateTheXaxisLablesAccordingToTheSelectedTimeline();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC44_validate_Whether_The_Xaxis_Lables_Are_According_To_3_Hours_Timeline() {
		common.selectTheTimeLineFromCalender(IPathConstant.threeHoursTimeRange);
		bmApp.ValidateTheXaxisLablesAccordingToTheSelectedTimeline();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC45_validate_Whether_The_Xaxis_Lables_Are_According_To_6_Hours_Timeline() {
		common.selectTheTimeLineFromCalender(IPathConstant.sixHoursTimeRange);
		bmApp.ValidateTheXaxisLablesAccordingToTheSelectedTimeline();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC46_validate_Whether_The_Xaxis_Lables_Are_According_To_12_Hours_Timeline() {
		common.selectTheTimeLineFromCalender(IPathConstant.twelveHoursTimeRange);
		bmApp.ValidateTheXaxisLablesAccordingToTheSelectedTimeline();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC47_validate_Whether_The_Xaxis_Lables_Are_According_To_1_Day_Timeline() {
		common.selectTheTimeLineFromCalender(IPathConstant.oneDayTimeRange);
		bmApp.ValidateTheXaxisLablesAccordingToTheSelectedTimeline();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC48_validate_Whether_The_Xaxis_Lables_Are_According_To_1_Week_Timeline() {
		common.selectTheTimeLineFromCalender(IPathConstant.oneWeekTimeRange);
		bmApp.ValidateTheXaxisLablesAccordingToTheSelectedTimeline();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC49_validate_Whether_The_Xaxis_Lables_Are_According_To_1_Month_Timeline() {
		common.selectTheTimeLineFromCalender(IPathConstant.oneMonthTimeRange);
		bmApp.ValidateTheXaxisLablesAccordingToTheSelectedTimeline();
	}
	
	@Test
	public void TC50_validate_The_All_Widgets_By_selecting_custom_Time_For_Minutes_Range() throws EncryptedDocumentException, IOException{
		common.selectTheTimeLineFromCalender(IPathConstant.fiveMinutesTimeRange);
		commPage.selectTheCustomeTimeLine(IPathConstant.customTimeRange, excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customMinutesRange"));
		bmApp.validateTheCustomTimeLine(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customMinutesRange"));
	}
	
	@Test
	public void TC51_validate_The_All_Widgets_By_selecting_custom_Time_For_Hours_Range() throws EncryptedDocumentException, IOException{
		//common.selectTheTimeLineFromCalender(IPathConstant.fiveMinutesTimeRange);
		commPage.selectTheCustomeTimeLine(IPathConstant.customTimeRange, excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customHoursRange"));
		bmApp.validateTheCustomTimeLine(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customHoursRange"));
	}
	
	@Test
	public void TC52_validate_The_All_Widgets_By_selecting_custom_Time_For_Days_Range() throws EncryptedDocumentException, IOException{
		common.selectTheTimeLineFromCalender(IPathConstant.fiveMinutesTimeRange);
		commPage.selectTheCustomeTimeLine(IPathConstant.customTimeRange, excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customDaysRange"));
		bmApp.validateTheCustomTimeLine(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customDaysRange"));
	}
	
	@Test
	public void TC53_validate_The_All_Widgets_By_selecting_custom_Time_For_Future_date(){
		common.selectTheTimeLineFromCalender(IPathConstant.fiveMinutesTimeRange);
		commPage.validateTheFutureTimeLine();
	}
	
	@Test (groups = {"BM", "UI", "Regression"})
	public void TC54_validate_The_Soft_Refresh_Options_Selection() throws EncryptedDocumentException, IOException {
		common.validateRefreshOptionsForAvailabilityAndSelection();
	}
}

