package apmCapability;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import genericUtilities.GenericMethods;
import genericUtilities.IPathConstant;
import objectRepository.CommonPage;
import objectRepository.APM.ApmEndpointPage;
import objectRepository.APM.ApmTracePage;
import playWrightFactory.BaseClass;

public class ApmTraceTest extends BaseClass{
	GenericMethods util;
	CommonPage common;
	ApmTracePage trace;
	ApmEndpointPage endpoint;
	
	@BeforeMethod
	public void bmConfig() throws EncryptedDocumentException, IOException, InterruptedException {
		trace = new ApmTracePage(page);
		endpoint = new ApmEndpointPage(page);
		common = new CommonPage(page);
		util = new GenericMethods();
		common.navigateToApm();
		common.selectTheTimeLineFromCalender(IPathConstant.oneMonthTimeRange);
		endpoint.selectApplication();
		trace.navigateToTracePage();
	}
	
	@Test (groups = {"APM","UI","Regression"})
	public void TC01_validate_Selecting_All_Instancece_Option_From_Dropdown() throws EncryptedDocumentException, IOException {
		trace.selectAllInstanceFromDropdown();
	}
	
	@Test (groups = {"APM","UI","Regression"})
	public void TC02_validate_Selecting_All_Status_Option_From_Dropdown() throws EncryptedDocumentException, IOException {
		trace.selectAllStatusFromDropdown();
	}
	
	@Test (groups = {"APM","UI","Regression"})
	public void TC03_validate_Selecting_Success_Status_Option_From_Dropdown() throws EncryptedDocumentException, IOException {
		trace.selectSuccessStatusFromDropdown();
	}
	
	@Test (groups = {"APM","UI","Regression"})
	public void TC04_validate_Selecting_Error_Status_Option_From_Dropdown() throws EncryptedDocumentException, IOException {
		trace.selectErrorStatusFromDropdown();
	}
	
	@Test (groups = {"APM","UI","Regression"})
	public void TC05_validate_Selecting_All_Endpoints_Option_From_Dropdown() throws EncryptedDocumentException, IOException {
		trace.selectAllEndpointsFromDropdown();
	}
	
	@Test (groups = {"APM","UI","Regression"})
	public void TC06_validate_Selecting_Particular_Endpoints_Option_From_Dropdown() throws EncryptedDocumentException, IOException {
		trace.selectParticularEndpointFromDropdown();
	}
	
	@Test (groups = {"APM","UI","Regression"})
	public void TC07_validate_TraceId_Copy_Button_Functionality() throws EncryptedDocumentException, IOException {
		trace.clickOnTraceidCopyBtnAndValidate();
	}
	
	@Test (groups = {"APM","UI","Regression"})
	public void TC08_validate_Search_By_Trace_Id_Feature () {
		trace.searchAndValidateEndpointForTheTraceId();
	}
	
	@Test (groups = {"APM","UI","Regression"})
	public void TC09_validate_Search_By_Response_Time_For_Less_Than_Or_Equal_To_The_Specified_Time () throws NumberFormatException, EncryptedDocumentException, IOException {
		trace.validateSearchTracesByResponseTimeForLessThanOrEqualToSpecifiedTime();
	}
	
	@Test (groups = {"APM","UI","Regression"})
	public void TC10_validate_Search_By_Response_Time_For_Greater_Than_Or_Equal_To_The_Specified_Time () throws NumberFormatException, EncryptedDocumentException, IOException {
		trace.validateSearchTracesByResponseTimeForGreaterThanOrEqualToSpecifiedTime();
	}
	
	@Test (groups = {"APM","UI","Regression"})
	public void TC11_validate_Search_By_Response_Time_Is_Between_The_Specified_Time () throws NumberFormatException, EncryptedDocumentException, IOException {
		trace.validateSearchTracesByResponseTimeIsBetweenTheSpecifiedTime();
	}
	
	@Test (groups = {"APM","UI","Regression"})
	public void TC12_validate_Sorting_The_Traces_By_Execution_Start_Time() {
		trace.sortTracesByExecutionStartingTimeAndValidate();
	}
	
	@Test (groups = {"APM","UI","Regression"})
	public void TC13_validate_Sorting_The_Traces_By_Execution_Duration() {
		trace.sortTracesByExecutionDurationAndValidate();
	}
	
	@Test (groups = {"APM","UI","Regression"})
	public void TC14_validate_The_First_Column_Name_Of_Trace_Table() throws EncryptedDocumentException, IOException {
		trace.validateTheFirstColumnNameOfTraceTable();
	}
	
	@Test (groups = {"APM","UI","Regression"})
	public void TC15_validate_The_Second_Column_Name_Of_Trace_Table() throws EncryptedDocumentException, IOException {
		trace.validateTheSecondColumnNameOfTraceTable();
	}
	
	@Test (groups = {"APM","UI","Regression"})
	public void TC16_validate_The_Third_Column_Name_Of_Trace_Table() throws EncryptedDocumentException, IOException {
		trace.validateTheThirdColumnNameOfTraceTable();
	}
	
	@Test (groups = {"APM","UI","Regression"})
	public void TC17_validate_The_Fourth_Column_Name_Of_Trace_Table() throws EncryptedDocumentException, IOException {
		trace.validateTheFourthColumnNameOfTraceTable();
	}
	
	@Test (groups = {"APM","UI","Regression"})
	public void TC18_validate_The_Fifth_Column_Name_Of_Trace_Table() throws EncryptedDocumentException, IOException {
		trace.validateTheFifthColumnNameOfTraceTable();
	}
	
	@Test (groups = {"APM","UI","Regression"})
	public void TC19_validate_The_sixth_Column_Name_Of_Trace_Table() throws EncryptedDocumentException, IOException {
		trace.validateTheSixthColumnNameOfTraceTable();
	}
	
	@Test (groups = {"APM","UI","Regression"})
	public void TC20_validate_The_Seventh_Column_Name_Of_Trace_Table() throws EncryptedDocumentException, IOException {
		trace.validateTheSeventhColumnNameOfTraceTable();
	}
	
	@Test (groups = {"APM","UI","Regression"})
	public void TC21_validate_The_Trace_Endpoint_In_The_Trace_Table() throws EncryptedDocumentException, IOException {
		trace.validateTheTraceEndpointInTheTraceTable();
	}
	
	@Test (groups = {"APM","UI","Regression"})
	public void TC22_validate_The_Trace_Endpoint_In_The_Trace_Table_Header() throws EncryptedDocumentException, IOException {
		trace.validateTheTraceEndpointInTheTraceTableHeader();
	}
	
	@Test (groups = {"APM","UI","Regression"})
	public void TC23_validate_The_Trace_Start_Time_In_The_Trace_Table() throws EncryptedDocumentException, IOException {
		trace.validateTheTraceStartTimeInTheTraceTable();
	}
	
	@Test (groups = {"APM","UI","Regression"})
	public void TC24_validate_The_Trace_Response_Time_In_The_Trace_Table() throws EncryptedDocumentException, IOException {
		trace.validateTheTraceResponseTimeInTheTraceTable();
	}
	
	@Test (groups = {"APM","UI","Regression"})
	public void TC25_validate_The_Trace_Application_Name_In_The_Trace_Table() throws EncryptedDocumentException, IOException {
		trace.validateTheTraceApplicationNameInTheTraceTable();
	}
	
	@Test (groups = {"APM","UI","Regression"})
	public void TC26_validate_The_Trace_Start_Time_In_The_Trace_Table_Header() throws EncryptedDocumentException, IOException {
		trace.validateTheTraceStartTimeInTheTraceTableHeader();
	}
	
	@Test (groups = {"APM","UI","Regression"})
	public void TC27_validate_The_Trace_Duration_In_The_Trace_Table_Header() throws EncryptedDocumentException, IOException {
		trace.validateTheTraceDurationInTheTraceTableHeader();
	}
	
	@Test (groups = {"APM","UI","Regression"})
	public void TC28_validate_The_Number_Of_Spans_In_The_Trace_Table_Header() throws EncryptedDocumentException, IOException {
		trace.validateTheNumberOfSpansInTheTraceTableHeader();
	}
	
	@Test (groups = {"APM","UI","Regression"})
	public void TC29_validate_Whether_The_Span_Info_Page_Is_Displayed() throws EncryptedDocumentException, IOException {
		trace.validateWhetherTheSpanInfoPageIsDisplayed();
	}
	
	@Test (groups = {"APM","UI","Regression"})
	public void TC30_validate_The_Application_Name_In_Span_Info_Page() throws EncryptedDocumentException, IOException {
		trace.validateTheApplicationNameInSpanInfoPage();
	}
	
	@Test (groups = {"APM","UI","Regression"})
	public void TC31_validate_The_Trace_Endpoint_In_Span_Info_Page() throws EncryptedDocumentException, IOException {
		trace.validateTheTraceEndpointInSpanInfoPage();
	}
	
	@Test (groups = {"APM","UI","Regression"})
	public void TC32_validate_The_Functionality_Of_Endpoint_Copy_Button_In_Span_Info_Page() throws EncryptedDocumentException, IOException {
		trace.validateFunctionalityOfEndpointCopyInSpanInfoPage();
	}
	
	@Test (groups = {"APM","UI","Regression"})
	public void TC33_validate_The_Trace_Component_In_Span_Info_Page() throws EncryptedDocumentException, IOException {
		trace.validateTheTraceComponentInTheSpanInfoPage();
	}
	
	@Test (groups = {"APM","UI","Regression"})
	public void TC34_validate_The_Trace_Url_In_Span_Info_Page() throws EncryptedDocumentException, IOException {
		trace.validateTheTraceUrlInTheSpanInfoPage();
	}
	
	@Test (groups = {"APM","UI","Regression"})
	public void TC35_validate_The_Functionality_Of_Url_Copy_Button_In_Span_Info_Page() throws EncryptedDocumentException, IOException, InterruptedException {
		trace.validateFunctionalityOfUrlCopyInSpanInfoPage();
	}
	
	@Test (groups = {"APM","UI","Regression"})
	public void TC36_validate_The_Error_Value_In_Span_Info_Page() throws EncryptedDocumentException, IOException, InterruptedException {
		trace.validateTheErrorInTheSpanInfoPage();
	}
	
	@Test (groups = {"APM","UI","Regression"})
	public void TC37_validate_The_Trace_Endpoint_Under_The_List_Tab() throws EncryptedDocumentException, IOException {
		trace.validateTheTraceEndpointUnderTheListTab();
	}
	
	@Test (groups = {"APM","UI","Regression"})
	public void TC38_validate_The_Trace_Endpoint_Under_The_List_Tab_Tooltip() throws EncryptedDocumentException, IOException {
		trace.validateTheTraceEndpointUnderTheListTabTooltip();
	}
	
	@Test (groups = {"APM","UI","Regression"})
	public void TC39_validate_The_Trace_Response_Time_Under_The_List_Tab() throws EncryptedDocumentException, IOException {
		trace.validateTheTraceResponseTimeUnderTheListTab();
	}
	
	@Test (groups = {"APM","UI","Regression"})
	public void TC40_validate_The_Trace_Response_Time_In_Trace_Root_Under_The_List_Tab() throws EncryptedDocumentException, IOException {
		trace.validateTheTraceResponseTimeInTraceRootUnderTheListTab();
	}
	
	@Test (groups = {"APM","UI","Regression"})
	public void TC41_validate_The_Trace_Application_Name_Under_The_List_Tab() throws EncryptedDocumentException, IOException {
		trace.validateTheTraceApplicationNameUnderListTab();
	}
	
	@Test (groups = {"APM","UI","Regression"})
	public void TC42_validate_Whether_The_Span_Info_Page_Is_Displayed_From_List_Tab() throws EncryptedDocumentException, IOException {
		trace.validateWhetherTheSpanInfoPageIsDisplayedFromListTab();
	}
	
	@Test (groups = {"APM","UI","Regression"})
	public void TC43_validate_The_Trace_Endpoint_Under_The_Tree_Tab() throws EncryptedDocumentException, IOException {
		trace.validateTheTraceEndpointUnderTheTreeTab();
	}
	
	@Test (groups = {"APM","UI","Regression"})
	public void TC44_validate_The_Trace_Id_Under_The_Tree_Tab() throws EncryptedDocumentException, IOException {
		trace.validateTheTraceIdUnderTheTreeTab();
	}
	
	@Test (groups = {"APM","UI","Regression"})
	public void TC45_validate_Whether_The_Span_Info_Page_Is_Displayed_From_Tree_Tab() throws EncryptedDocumentException, IOException {
		trace.validateWhetherTheSpanInfoPageIsDisplayedFromTreeTab();
	}
	
	@Test (groups = {"APM","UI","Regression"})
	public void TC46_validate_The_First_Column_Name_OF_The_Spn_Info_Page() throws EncryptedDocumentException, IOException {
		trace.validateTheFirstColumnNameOfSpanInfoPage();
	}
	
	@Test (groups = {"APM","UI","Regression"})
	public void TC47_validate_The_Second_Column_Name_OF_The_Spn_Info_Page() throws EncryptedDocumentException, IOException {
		trace.validateTheSecondColumnNameOfSpanInfoPage();
	}
	
	@Test (groups = {"APM","UI","Regression"})
	public void TC48_validate_Whether_The_Download_Report_Button_Is_Active_In_Trace_Page() throws EncryptedDocumentException, IOException {
		trace.validateWhetherTheDownloadReportButtonIsActive();
	}
	
	@Test
	public void TC49_validate_Functionality_Of_Download_Report_In_Trace_Page() throws EncryptedDocumentException, IOException {
		trace.validateFunctionalityOfDownloadReportInTracePage();
	}
	
	@Test (groups = {"APM","UI","Regression"})
	public void TC50_validate_Whether_The_Download_Button_Is_Active_In_Span_Info_Page() throws EncryptedDocumentException, IOException {
		trace.validateWhetherTheDownloadReportButtonIsActiveInSpanInfoPage();
	}
	
	@Test
	public void TC51_validate_Functionality_Of_Download_Report_In_Span_Info_Page() throws EncryptedDocumentException, IOException {
		trace.validateFunctionalityOfDownloadReportInSpanInfoPage();
	}
	
	@Test (groups = {"APM","UI","Regression"})
	public void TC52_validate_Whether_The_Download_Image_Icon_Is_Active() throws EncryptedDocumentException, IOException {
		trace.validateWhetherTheDownloadImageIconIsActive();
	}
	
	@Test (groups = {"APM", "UI", "Regression"})
	public void TC_53_validate_The_Functionality_Of_Download_Image_Icon() throws EncryptedDocumentException, IOException {
		trace.validateTheFunctionalityOfDownloadImageIcon();
	}
	
	@Test (groups = {"APM", "UI", "Regression"})
	public void TC54_validate_The_Soft_Refresh_Options_Selection() throws EncryptedDocumentException, IOException {
		common.validateRefreshOptionsForAvailabilityAndSelection();
	}
	
	@AfterMethod
	public void AmConfig() {
		trace.closeSpanInfoWindow();
	}
}
	