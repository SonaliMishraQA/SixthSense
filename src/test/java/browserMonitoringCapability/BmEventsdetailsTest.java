package browserMonitoringCapability;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import genericUtilities.ExcelUtility;
import genericUtilities.GenericMethods;
import genericUtilities.IPathConstant;
import objectRepository.BM.BmApplicationPage;
import objectRepository.BM.BmErrorsPage;
import objectRepository.BM.BmEventsDetailsPage;
import playWrightFactory.BaseClass;

public class BmEventsdetailsTest extends BaseClass{

	GenericMethods util = new GenericMethods();
	ExcelUtility excel = new ExcelUtility();
	BmApplicationPage bmApp;
	BmErrorsPage bmErrors;
	BmEventsDetailsPage bmEvents;

	@BeforeMethod
	public void bmConfig() throws EncryptedDocumentException, IOException, InterruptedException {
		bmApp = new BmApplicationPage(page);
		bmEvents = new BmEventsDetailsPage(page);
		bmErrors = new BmErrorsPage(page);
		commPage.navigateToBrowserMonitoring();
		commPage.selectTheTimeLineFromCalender(IPathConstant.oneMonthTimeRange);
		bmApp.selectApplication();
		bmErrors.navigateToErrorsTab();
		bmErrors.navigateToErrorsEventsPage();
		bmErrors.validateNavigationToEventsDetsilsPageByClickingOnEventId();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC01_validate_The_Functionality_Of_Back_Button_In_Events_Details_Page() throws EncryptedDocumentException, IOException {
		bmEvents.validateTheFunctionalityOfBackButtonInEventsDetailsPage();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC02_validate_Whether_The_Download_Report_Button_Is_Active_In_Events_Details_Page() throws EncryptedDocumentException, IOException {
		bmEvents.validateWhetherTheDownloadReportButtonIsActive();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC03_validate_Functionality_Of_Download_Report_In_Events_Details_Page() throws EncryptedDocumentException, IOException {
		bmEvents.validateFunctionalityOfDownloadReportInErrorsPage();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC04_validate_The_Functionality_Of_Event_Id_Copy_Button_In_Events_Details_Page() throws EncryptedDocumentException, IOException, InterruptedException {
		bmEvents.validateFunctionalityOfEventIdCopyButtonInEnentsDetailsPage();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC05_validate_The_Functionality_Of_Event_Id_Copy_Button_In_Events_Details_Page() throws EncryptedDocumentException, IOException, InterruptedException {
		bmEvents.validateFunctionalityOfEventIdCopyButtonInEnentsDetailsPage();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC06_validate_Whether_The_Application_Key_Is_Displayed_In_Events_Details_Page() throws EncryptedDocumentException, IOException, InterruptedException {
		bmEvents.validateWhetherTheApplicationKeyIsDisplayedInEnentsDetailsPage();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC07_validate_Whether_The_Application_Version_Key_Is_Displayed_In_Events_Details_Page() throws EncryptedDocumentException, IOException, InterruptedException {
		bmEvents.validateWhetherTheApplicationVersionKeyIsDisplayedInEnentsDetailsPage();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC08_validate_Whether_The_Environment_Key_Is_Displayed_In_Events_Details_Page() throws EncryptedDocumentException, IOException, InterruptedException {
		bmEvents.validateWhetherTheEnvironmentKeyIsDisplayedInEnentsDetailsPage();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC09_validate_Whether_The_Error_URL_Key_Is_Displayed_In_Events_Details_Page() throws EncryptedDocumentException, IOException, InterruptedException {
		bmEvents.validateWhetherTheErrorUrlKeyIsDisplayedInEnentsDetailsPage();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC10_validate_Whether_The_Page_Path_Key_Is_Displayed_In_Events_Details_Page() throws EncryptedDocumentException, IOException, InterruptedException {
		bmEvents.validateWhetherThePagePathKeyIsDisplayedInEnentsDetailsPage();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC11_validate_Whether_The_Error_Key_Is_Displayed_In_Events_Details_Page() throws EncryptedDocumentException, IOException, InterruptedException {
		bmEvents.validateWhetherTheErrorKeyIsDisplayedInEnentsDetailsPage();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC12_validate_Whether_The_Category_Key_Is_Displayed_In_Events_Details_Page() throws EncryptedDocumentException, IOException, InterruptedException {
		bmEvents.validateWhetherTheCategoryKeyIsDisplayedInEnentsDetailsPage();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC13_validate_Whether_The_Time_Key_Is_Displayed_In_Events_Details_Page() throws EncryptedDocumentException, IOException, InterruptedException {
		bmEvents.validateWhetherTheTimeKeyIsDisplayedInEnentsDetailsPage();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC14_validate_Whether_The_Error_Type_Key_Is_Displayed_In_Events_Details_Page() throws EncryptedDocumentException, IOException, InterruptedException {
		bmEvents.validateWhetherTheErrorTypeKeyIsDisplayedInEnentsDetailsPage();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC15_validate_Whether_The_Message_Key_Is_Displayed_In_Events_Details_Page() throws EncryptedDocumentException, IOException, InterruptedException {
		bmEvents.validateWhetherTheMessageKeyIsDisplayedInEnentsDetailsPage();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC16_validate_Whether_The_Name_Key_Is_Displayed_In_Events_Details_Page() throws EncryptedDocumentException, IOException, InterruptedException {
		bmEvents.validateWhetherTheNameKeyIsDisplayedInEnentsDetailsPage();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC17_validate_Whether_The_Version_Key_Is_Displayed_In_Events_Details_Page() throws EncryptedDocumentException, IOException, InterruptedException {
		bmEvents.validateWhetherTheVersionKeyIsDisplayedInEnentsDetailsPage();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC18_validate_Whether_The_User_Agent_Key_Is_Displayed_In_Events_Details_Page() throws EncryptedDocumentException, IOException, InterruptedException {
		bmEvents.validateWhetherTheUserAgentKeyIsDisplayedInEnentsDetailsPage();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC19_validate_The_Default_State_Of_Exception_Expansion_Button_In_Events_Details_Page() throws EncryptedDocumentException, IOException, InterruptedException {
		bmEvents.validateTheDefaultStateOfExceptionExpansionButtonInEnentsDetailsPage();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC20_validate_The_Functionality_Of_Exception_Expansion_Button_In_Events_Details_Page() throws EncryptedDocumentException, IOException, InterruptedException {
		bmEvents.validateTheFunctionalityOfExceptionExpansionButtonInEnentsDetailsPage();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC21_validate_The_Title_Of_Breadcrumb_Section_In_Events_Details_Page() throws EncryptedDocumentException, IOException, InterruptedException {
		bmEvents.validateTheTitleOfBreadcrumbSectionInEnentsDetailsPage();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC22_validate_The_Title_Of_First_Column_Of_Breadcrumb_Table_In_Events_Details_Page() throws EncryptedDocumentException, IOException, InterruptedException {
		bmEvents.validateTheTitleOfFirstColumnOfBreadcrumbTableInEnentsDetailsPage();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC23_validate_The_Title_Of_Second_Column_Of_Breadcrumb_Table_In_Events_Details_Page() throws EncryptedDocumentException, IOException, InterruptedException {
		bmEvents.validateTheTitleOfSecondColumnOfBreadcrumbTableInEnentsDetailsPage();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC24_validate_The_Title_Of_Third_Column_Of_Breadcrumb_Table_In_Events_Details_Page() throws EncryptedDocumentException, IOException, InterruptedException {
		bmEvents.validateTheTitleOfThirdColumnOfBreadcrumbTableInEnentsDetailsPage();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC25_validate_The_Title_Of_Fourth_Column_Of_Breadcrumb_Table_In_Events_Details_Page() throws EncryptedDocumentException, IOException, InterruptedException {
		bmEvents.validateTheTitleOfFourthColumnOfBreadcrumbTableInEnentsDetailsPage();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC26_validate_The_Title_Of_Fifth_Column_Of_Breadcrumb_Table_In_Events_Details_Page() throws EncryptedDocumentException, IOException, InterruptedException {
		bmEvents.validateTheTitleOfFifthColumnOfBreadcrumbTableInEnentsDetailsPage();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC27_validate_The_Ascending_Functionality_Of_Time_Column_In_Breadcrumb_Table() {
		bmEvents.validateTheAscendingFunctionalityOfTimeColumn();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC28_validate_The_Descending_Functionality_Of_Time_Column_In_Breadcrumb_Table() {
		bmEvents.validateTheDescendingFunctionalityOfTimeColumn();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC29_validate_The_Default_Text_On_Select_Filter_Dropdown_In_Errors_Events_Page() throws EncryptedDocumentException, IOException {
		bmEvents.validateTheDefaultTextOnSelectFilterDropdown();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC30_validate_Whether_The_Search_Breadcrumbs_Text_Field_Is_Present() throws EncryptedDocumentException, IOException {
		bmEvents.validateWhetherTheSearchBreadcrumbsTextFieldIsPresent();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC31_validate_The_Functionality_Of_Search_Breadcrumbs_For_Valid_Data() throws EncryptedDocumentException, IOException {
		bmEvents.validateTheFunctionalityOfSearchBreadcrumbsForValidData();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC32_validate_The_Functionality_Of_Search_Breadcrumbs_For_Invalid_Data() throws EncryptedDocumentException, IOException {
		bmEvents.validateTheFunctionalityOfSearchBreadcrumbsForInvalidData();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC33_validate_The_Search_For_Level_Filter_Options_Through_Search_Breadcrumbs_TextField() throws EncryptedDocumentException, IOException {
		bmEvents.validateTheSearchForLevelFilterOptionsThroughSearchBreadcrumbsTextField();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC34_validate_The_Filter_Option_Selection_Functionality() {
		bmEvents.validateTheFilterOptionSelectionFunctionality();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC35_validate_The_Filter_Option_Deselection_Functionality() throws EncryptedDocumentException, IOException {
		bmEvents.validateTheFilterOptionDeselectionFunctionality();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC36_validate_The_Color_Of_Warning_Filter_Option_In_Select_Filter_Dropdown() throws EncryptedDocumentException, IOException {
		bmEvents.validateTheColorOfWarningFilterOptionInSelectFilterDropdown();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC37_validate_The_Color_Of_Info_Filter_Option_In_Select_Filter_Dropdown() throws EncryptedDocumentException, IOException {
		bmEvents.validateTheColorOfInfoFilterOptionInSelectFilterDropdown();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC38_validate_The_Color_Of_Error_Filter_Option_In_Select_Filter_Dropdown() throws EncryptedDocumentException, IOException {
		bmEvents.validateTheColorOfErrorFilterOptionInSelectFilterDropdown();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC39_validate_The_Select_Filter_Functionality_For_Debug() throws EncryptedDocumentException, IOException {
		bmEvents.validateTheSelectFilterFunctionalityForDebug();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC40_validate_The_Select_Filter_Functionality_For_Navigation() throws EncryptedDocumentException, IOException {
		bmEvents.validateTheSelectFilterFunctionalityForNavigation();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC41_validate_The_Select_Filter_Functionality_For_User_Action() throws EncryptedDocumentException, IOException {
		bmEvents.validateTheSelectFilterFunctionalityForUserAction();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC42_validate_The_Select_Filter_Functionality_For_Type_Error() throws EncryptedDocumentException, IOException {
		bmEvents.validateTheSelectFilterFunctionalityForTypeError();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC43_validate_The_Select_Filter_Functionality_For_HTTP() throws EncryptedDocumentException, IOException {
		bmEvents.validateTheSelectFilterFunctionalityForHttp();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC44_validate_The_Select_Filter_Functionality_For_Warning() throws EncryptedDocumentException, IOException {
		bmEvents.validateTheSelectFilterFunctionalityForWarning();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC45_validate_The_Select_Filter_Functionality_For_Info() throws EncryptedDocumentException, IOException {
		bmEvents.validateTheSelectFilterFunctionalityForInfo();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC46_validate_The_Select_Filter_Functionality_For_Level_Error() throws EncryptedDocumentException, IOException {
		bmEvents.validateTheSelectFilterFunctionalityForLevelError();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC47_validate_Whether_Clear_Filter_Option_Is_Displaying_On_Selecting_Filter() throws EncryptedDocumentException, IOException {
		bmEvents.validateWhetherClearFilterOptionIsDisplayingOnSelectingFilter();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC48_validate_The_Functionality_Of_Clear_Filter_Option() throws EncryptedDocumentException, IOException {
		bmEvents.validateTheFunctionalityOfClearFilterOption();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC49_validate_The_Color_Of_The_Category_Column_Data_In_Breadcrumb_Table() throws EncryptedDocumentException, IOException {
		bmEvents.validateTheColorOfTheCategoryColumnDataInBreadcrumbTable();
	}
}