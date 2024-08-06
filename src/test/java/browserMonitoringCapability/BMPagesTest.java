package browserMonitoringCapability;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import genericUtilities.ExcelUtility;
import genericUtilities.GenericMethods;
import genericUtilities.IPathConstant;
import objectRepository.CommonPage;
import objectRepository.BM.BmApplicationPage;
import objectRepository.BM.BmPagesPage;
import playWrightFactory.BaseClass;

public class BMPagesTest extends BaseClass {
	GenericMethods util = new GenericMethods();
	BmApplicationPage bmApp;
	BmPagesPage bmPages;
	ExcelUtility excel = new ExcelUtility();
	
	@BeforeMethod
	public void bmConfig() throws EncryptedDocumentException, IOException, InterruptedException {
		bmApp = new BmApplicationPage(page);
		bmPages = new BmPagesPage(page);
		commPage.navigateToBrowserMonitoring();
		commPage.selectTheTimeLineFromCalender(IPathConstant.oneMonthTimeRange);
		bmApp.selectApplication();
		bmPages.navigateToPagesTab();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC01_validate_Whether_The_Search_Pages_Text_Field_Is_Present() throws EncryptedDocumentException, IOException {
		bmPages.validateWhetherTheSearchPagesTextFieldIsPresent();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC02_validate_The_Functionality_Of_Search_Pages_For_Valid_Data() throws EncryptedDocumentException, IOException {
		bmPages.validateTheFunctionalityOfSearchPagesForValidData();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC03_validate_The_Functionality_Of_Search_Pages_For_Invalid_Data() throws EncryptedDocumentException, IOException {
		bmPages.validateTheFunctionalityOfSearchPagesForInvalidData();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC04_validate_The_First_Column_Title_In_The_Pages_Table() throws EncryptedDocumentException, IOException {
		bmPages.validateTheFirstColumnTitlteInThePagesTable();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC05_validate_The_Second_Column_Title_In_The_Pages_Table() throws EncryptedDocumentException, IOException {
		bmPages.validateTheSecondColumnTitlteInThePagesTable();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC06_validate_The_Third_Column_Title_In_The_Pages_Table() throws EncryptedDocumentException, IOException {
		bmPages.validateTheThirdColumnTitlteInThePagesTable();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC07_validate_The_Fourth_Column_Title_In_The_Pages_Table() throws EncryptedDocumentException, IOException {
		bmPages.validateTheFourthColumnTitlteInThePagesTable();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC08_validate_The_Fifth_Column_Title_In_The_Pages_Table() throws EncryptedDocumentException, IOException {
		bmPages.validateTheFifthColumnTitlteInThePagesTable();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC09_validate_The_Sixth_Column_Title_In_The_Pages_Table() throws EncryptedDocumentException, IOException {
		bmPages.validateTheSixthColumnTitlteInThePagesTable();
	}	
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC10_validate_The_Ascending_Functionality_Of_Errors_Column_In_The_Pages_Table() throws EncryptedDocumentException, IOException {
		bmPages.validateTheAscendingFunctionalityOfErrorsColumn();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC11_validate_The_Descending_Functionality_Of_Errors_Column_In_The_Pages_Table() throws EncryptedDocumentException, IOException {
		bmPages.validateTheDescendingFunctionalityOfErrorsColumn();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC12_validate_The_Ascending_Functionality_Of_Errors_Per_Minute_Column_In_The_Pages_Table() throws EncryptedDocumentException, IOException {
		bmPages.validateTheAscendingFunctionalityOfErrorsPerMinuteColumn();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC13_validate_The_Descending_Functionality_Of_Errors_Per_Minute_Column_In_The_Pages_Table() throws EncryptedDocumentException, IOException {
		bmPages.validateTheDescendingFunctionalityOfErrorsPerMinuteColumn();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC14_validate_The_Ascending_Functionality_Of_Response_Time_Column_In_The_Pages_Table() throws EncryptedDocumentException, IOException {
		bmPages.validateTheAscendingFunctionalityOfResponseTimeColumn();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC15_validate_The_Descending_Functionality_Of_Response_Time_Column_In_The_Pages_Table() throws EncryptedDocumentException, IOException {
		bmPages.validateTheDescendingFunctionalityOfResponseTimeColumn();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC16_validate_The_Ascending_Functionality_Of_Calls_Column_In_The_Pages_Table() throws EncryptedDocumentException, IOException {
		bmPages.validateTheAscendingFunctionalityOfCallsColumn();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC17_validate_The_Descending_Functionality_Of_Calls_Column_In_The_Pages_Table() throws EncryptedDocumentException, IOException {
		bmPages.validateTheDescendingFunctionalityOfCallsColumn();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC18_validate_The_Ascending_Functionality_Of_Calls_Per_Minute_Column_In_The_Pages_Table() throws EncryptedDocumentException, IOException {
		bmPages.validateTheAscendingFunctionalityOfCallsPerMinuteColumn();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC19_validate_The_Descending_Functionality_Of_Calls_Per_Minute_Column_In_The_Pages_Table() throws EncryptedDocumentException, IOException {
		bmPages.validateTheDescendingFunctionalityOfCallsPerMinuteColumn();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC20_validate_The_Navigation_To_Pages_Graph_Page() throws EncryptedDocumentException, IOException {
		bmPages.validateTheNavigationToPagesGraphPage();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC21_validate_The_Functionality_Of_Back_Button_On_Pages_Graph_Page() throws EncryptedDocumentException, IOException {
		bmPages.validateTheFunctionalityOfBackButtonOnPagesGraphPage();
	}
	
	@Test (dataProvider = "pagination", groups = {"APM","UI","Regression"})
	public void TC22_validate_Pagination(String num) {
		bmPages.validatePagination(Integer.parseInt(num));
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC23_validate_The_Title_Of_Load_Widget() throws EncryptedDocumentException, IOException {
		bmPages.validateTheTitleOfLoadWidget();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC24_validate_The_Xaxis_Title_Of_Load_Widget() throws EncryptedDocumentException, IOException {
		bmPages.validateTheXaxisTitleOfLoadWidget();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC25_validate_The_Yaxis_Title_Of_Load_Widget() throws EncryptedDocumentException, IOException {
		bmPages.validateTheYaxisTitleOfLoadWidget();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC26_validate_The_Functionality_Of_Load_Widget_Zoom_In_Button() throws EncryptedDocumentException, IOException {
		bmPages.validateTheFunctionalityOfLoadWidgetZoomInButton();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC27_validate_The_Functionality_Of_Load_Widget_Zoom_Out_Button() throws EncryptedDocumentException, IOException {
		bmPages.validateTheFunctionalityOfLoadWidgetZoomOutButton();
	}

	@Test (groups = {"BM","UI","Regression"})
	public void TC28_validate_The_Functionality_Of_Load_Widget_Zoom_Reset_Button() throws EncryptedDocumentException, IOException {
		bmPages.validateTheFunctionalityOfLoadWidgetZoomResetButton();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC29_validate_Zoom_In_By_Drag_And_Drop_For_Load_Widget() throws EncryptedDocumentException, IOException {
		bmPages.validateZoomInByDragAndDropForLoadWidget();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC30_validate_Whether_The_Tooltip_Is_Displaying_For_Load_Widget() {
		bmPages.validateWhetherTheTooltipIsDisplayingForLoadWidget();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC31_validate_The_Title_Of_User_Centric_Page_Load_Widget() throws EncryptedDocumentException, IOException {
		bmPages.validateTheTitleOfUserCentricPageLoadWidget();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC32_validate_The_Xaxis_Title_Of_User_Centric_Page_Widget() throws EncryptedDocumentException, IOException {
		bmPages.validateTheXaxisTitleOfUserCentricPageLoadWidget();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC33_validate_The_Yaxis_Title_Of_User_Centric_Page_Widget() throws EncryptedDocumentException, IOException {
		bmPages.validateTheYaxisTitleOfUserCentricPageLoadWidget();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC34_validate_The_Functionality_Of_User_Centric_Page_Widget_Zoom_In_Button() throws EncryptedDocumentException, IOException {
		bmPages.validateTheFunctionalityOfUserCentricPageLoadWidgetZoomInButton();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC35_validate_The_Functionality_Of_User_Centric_Page_Widget_Zoom_Out_Button() throws EncryptedDocumentException, IOException {
		bmPages.validateTheFunctionalityOfUserCentricPageLoadWidgetZoomOutButton();
	}

	@Test (groups = {"BM","UI","Regression"})
	public void TC36_validate_The_Functionality_Of_User_Centric_Page_Widget_Zoom_Reset_Button() throws EncryptedDocumentException, IOException {
		bmPages.validateTheFunctionalityOfUserCentricPageLoadWidgetZoomResetButton();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC37_validate_Zoom_In_By_Drag_And_Drop_For_User_Centric_Page_Widget() throws EncryptedDocumentException, IOException {
		bmPages.validateZoomInByDragAndDropForUserCentricPageLoadWidget();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC38_validate_Whether_The_Tooltip_Is_Displaying_For_User_Centric_Page_Widget() {
		bmPages.validateWhetherTheTooltipIsDisplayingForUserCentricPageLoadWidget();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC39_validate_The_Legends_Label_In_User_Centric_Page_Widget() throws EncryptedDocumentException, IOException {
		String legendNames =  excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmPagesSheet, "userCentricPageWidgetLegends");
		bmPages.validateTheLegendsLabelInUserCentricPageWidget(legendNames);
	}
	
	@Test (groups = {"APM","Regression"})
	public void TC40_validate_The_Legends_Color_In_User_Centric_Page_Widget() throws EncryptedDocumentException, IOException {
		bmPages.validateTheLegendsColorInUserCentricPageWidget();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC41_validate_The_Title_Of_Error_Widget() throws EncryptedDocumentException, IOException {
		bmPages.validateTheTitleOfErrorWidget();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC42_validate_The_Xaxis_Title_Of_Error_Widget() throws EncryptedDocumentException, IOException {
		bmPages.validateTheXaxisTitleOfErrorWidget();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC43_validate_The_Yaxis_Title_Of_Error_Widget() throws EncryptedDocumentException, IOException {
		bmPages.validateTheYaxisTitleOfErrorWidget();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC44_validate_The_Functionality_Of_Error_Widget_Zoom_In_Button() throws EncryptedDocumentException, IOException {
		bmPages.validateTheFunctionalityOfErrorWidgetZoomInButton();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC45_validate_The_Functionality_Of_Error_Widget_Zoom_Out_Button() throws EncryptedDocumentException, IOException {
		bmPages.validateTheFunctionalityOfErrorWidgetZoomOutButton();
	}

	@Test (groups = {"BM","UI","Regression"})
	public void TC46_validate_The_Functionality_Of_Error_Widget_Zoom_Reset_Button() throws EncryptedDocumentException, IOException {
		bmPages.validateTheFunctionalityOfErrorWidgetZoomResetButton();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC47_validate_Zoom_In_By_Drag_And_Drop_For_Error_Widget() throws EncryptedDocumentException, IOException {
		bmPages.validateZoomInByDragAndDropForErrorWidget();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC48_validate_Whether_The_Tooltip_Is_Displaying_For_Error_Widget() {
		bmPages.validateWhetherTheTooltipIsDisplayingForErrorWidget();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC49_validate_The_Visibility_And_Navigation_Of_View_Errors_Link_In_Error_Widget() {
		bmPages.validateTheVisibilityAndNavigationOfViewErrorsLinkInErrorWidget();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC50_validate_The_Legends_Label_In_Error_Widget() throws EncryptedDocumentException, IOException {
		String legendNames =  excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmPagesSheet, "errorWidgetLegends");
		bmPages.validateTheLegendsLabelInErrorWidget(legendNames);
	}
	
	@Test (groups = {"APM","Regression"})
	public void TC51_validate_The_Legends_Color_In_Error_Widget() throws EncryptedDocumentException, IOException {
		bmPages.validateTheLegendsColorInErrorWidget();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC52_validate_The_Title_Of_User_Impacted_By_Errors_Widget() throws EncryptedDocumentException, IOException {
		bmPages.validateTheTitleOfUserImpactedByErrorsWidget();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC53_validate_The_Xaxis_Title_Of_User_Impacted_By_Errors_Widget() throws EncryptedDocumentException, IOException {
		bmPages.validateTheXaxisTitleOfUserImpactedByErrorsWidget();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC54_validate_The_Yaxis_Title_Of_User_Impacted_By_Errors_Widget() throws EncryptedDocumentException, IOException {
		bmPages.validateTheYaxisTitleOfUserImpactedByErrorsWidget();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC55_validate_Whether_The_Tooltip_Is_Displaying_For_User_Impacted_By_Errors_Widget() {
		bmPages.validateWhetherTheTooltipIsDisplayingForUserImpactedByErrorsWidget();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC56_validate_The_Title_Of_Error_Count_Map_Widget() throws EncryptedDocumentException, IOException {
		bmPages.validateTheTitleOfErrorCountMapWidget();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC57_validate_The_Number_Of_Calls_From_Pages_Table_In_Pages_Graph_Page_Load_Widget_Header() throws EncryptedDocumentException, IOException {
		bmPages.validateTheNumberOfCallsFromPagesTableInPagesGraphPageLoadWidgetHeader();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC58_validate_The_Number_Of_Calls_From_Pages_Table_In_Pages_Graph_Page_Load_Widget_Graph() throws EncryptedDocumentException, IOException {
		bmPages.validateTheNumberOfCallsFromPagesTableInPagesGraphPageLoadWidgetGraph();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC59_validate_The_Calls_Per_Minute_From_Pages_Table_In_Pages_Graph_Page_Load_Widget_Header() throws EncryptedDocumentException, IOException {
		bmPages.validateTheCallsPerMinuteFromPagesTableInPagesGraphPageLoadWidgetHeader();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC60_validate_The_Number_Of_Errors_From_Pages_Table_In_Pages_Graph_Page_Error_Widget_Graph() throws EncryptedDocumentException, IOException {
		bmPages.validateTheNumberOfErrorsFromPagesTableInPagesGraphPageErrorWidgetGraph();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC61_validate_The_Number_Of_Errors_From_Pages_Table_In_Error_Page_Table_Through_View_Error_Link() throws EncryptedDocumentException, IOException {
		bmPages.validateTheNumberOfErrorsFromPagesTableInErrorPageTableThroughViewErrorLink();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC62_validate_The_Number_Of_Errors_From_Pages_Table_In_Pages_Graph_Page_Error_Count_Map_Widget() throws EncryptedDocumentException, IOException {
		bmPages.validateTheNumberOfErrorsFromPagesTableInPagesGraphPageErrorCountMapWidget();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC63_validate_Whether_Clicking_On_Error_Data_In_Pages_Table_Navigates_To_Error_Page() {
		bmPages.validateWhetherClickingOnErrorDataInPagesTableNavigatesToErrorPage();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC64_validate_Whether_The_Xaxis_Lables_Are_According_To_5_Mins_Timeline() {
		bmPages.validateTheNavigationToPagesGraphPage();
		commPage.selectTheTimeLineFromCalender(IPathConstant.fiveMinutesTimeRange);
		bmPages.ValidateTheXaxisLablesAccordingToTheSelectedTimeline();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC65_validate_Whether_The_Xaxis_Lables_Are_According_To_15_Mins_Timeline() {
		bmPages.validateTheNavigationToPagesGraphPage();
		commPage.selectTheTimeLineFromCalender(IPathConstant.fifteenMinutesTimeRange);
		bmPages.ValidateTheXaxisLablesAccordingToTheSelectedTimeline();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC66_validate_Whether_The_Xaxis_Lables_Are_According_To_30_Mins_Timeline() {
		bmPages.validateTheNavigationToPagesGraphPage();
		commPage.selectTheTimeLineFromCalender(IPathConstant.thirtyMinutesTimeRange);
		bmPages.ValidateTheXaxisLablesAccordingToTheSelectedTimeline();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC67_validate_Whether_The_Xaxis_Lables_Are_According_To_60_Mins_Timeline() {
		bmPages.validateTheNavigationToPagesGraphPage();
		commPage.selectTheTimeLineFromCalender(IPathConstant.sixtyMinutesTimeRange);
		bmPages.ValidateTheXaxisLablesAccordingToTheSelectedTimeline();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC68_validate_Whether_The_Xaxis_Lables_Are_According_To_3_Hours_Timeline() {
		bmPages.validateTheNavigationToPagesGraphPage();
		commPage.selectTheTimeLineFromCalender(IPathConstant.threeHoursTimeRange);
		bmPages.ValidateTheXaxisLablesAccordingToTheSelectedTimeline();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC69_validate_Whether_The_Xaxis_Lables_Are_According_To_6_Hours_Timeline() {
		bmPages.validateTheNavigationToPagesGraphPage();
		commPage.selectTheTimeLineFromCalender(IPathConstant.sixHoursTimeRange);
		bmPages.ValidateTheXaxisLablesAccordingToTheSelectedTimeline();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC70_validate_Whether_The_Xaxis_Lables_Are_According_To_12_Hours_Timeline() {
		bmPages.validateTheNavigationToPagesGraphPage();
		commPage.selectTheTimeLineFromCalender(IPathConstant.twelveHoursTimeRange);
		bmPages.ValidateTheXaxisLablesAccordingToTheSelectedTimeline();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC71_validate_Whether_The_Xaxis_Lables_Are_According_To_1_Day_Timeline() {
		bmPages.validateTheNavigationToPagesGraphPage();
		commPage.selectTheTimeLineFromCalender(IPathConstant.oneDayTimeRange);
		bmPages.ValidateTheXaxisLablesAccordingToTheSelectedTimeline();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC72_validate_Whether_The_Xaxis_Lables_Are_According_To_1_Week_Timeline() {
		bmPages.validateTheNavigationToPagesGraphPage();
		commPage.selectTheTimeLineFromCalender(IPathConstant.oneWeekTimeRange);
		bmPages.ValidateTheXaxisLablesAccordingToTheSelectedTimeline();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC73_validate_Whether_The_Xaxis_Lables_Are_According_To_1_Month_Timeline() {
		bmPages.validateTheNavigationToPagesGraphPage();
		commPage.selectTheTimeLineFromCalender(IPathConstant.oneMonthTimeRange);
		bmPages.ValidateTheXaxisLablesAccordingToTheSelectedTimeline();
	}
	
	@Test
	public void TC74_validate_The_All_Widgets_By_selecting_custom_Time_For_Minutes_Range() throws EncryptedDocumentException, IOException{
		bmPages.validateTheNavigationToPagesGraphPage();
		commPage.selectTheTimeLineFromCalender(IPathConstant.fiveMinutesTimeRange);
		commPage.selectTheCustomeTimeLine(IPathConstant.customTimeRange, excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customMinutesRange"));
		bmPages.validateTheCustomTimeLine(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customMinutesRange"));
	}
	
	@Test
	public void TC75_validate_The_All_Widgets_By_selecting_custom_Time_For_Hours_Range() throws EncryptedDocumentException, IOException{
		bmPages.validateTheNavigationToPagesGraphPage();
		commPage.selectTheTimeLineFromCalender(IPathConstant.fiveMinutesTimeRange);
		commPage.selectTheCustomeTimeLine(IPathConstant.customTimeRange, excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customHoursRange"));
		bmPages.validateTheCustomTimeLine(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customHoursRange"));
	}
	
	@Test
	public void TC76_validate_The_All_Widgets_By_selecting_custom_Time_For_Days_Range() throws EncryptedDocumentException, IOException{
		bmPages.validateTheNavigationToPagesGraphPage();
		commPage.selectTheTimeLineFromCalender(IPathConstant.fiveMinutesTimeRange);
		commPage.selectTheCustomeTimeLine(IPathConstant.customTimeRange, excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customDaysRange"));
		bmPages.validateTheCustomTimeLine(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customDaysRange"));
	}
	
	@Test
	public void TC77_validate_The_All_Widgets_By_selecting_custom_Time_For_Future_date(){
		bmPages.validateTheNavigationToPagesGraphPage();
		commPage.selectTheTimeLineFromCalender(IPathConstant.fiveMinutesTimeRange);
		commPage.validateTheFutureTimeLine();
	}
	
	@Test (groups = {"BM", "UI", "Regression"})
	public void TC78_validate_The_Soft_Refresh_Options_Selection() throws EncryptedDocumentException, IOException {
		commPage.validateRefreshOptionsForAvailabilityAndSelection();
	}
	
	@DataProvider 
	public Object[][] pagination() throws Exception, Exception {
		return excel.fetchAllTheDataFromExcelSheet(IPathConstant.commExcelPath, IPathConstant.commonPaginationSheet);
	}
}
