package browserMonitoringCapability;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import genericUtilities.ExcelUtility;
import genericUtilities.GenericMethods;
import genericUtilities.IPathConstant;
import objectRepository.BM.BmApplicationPage;
import objectRepository.BM.BmErrorsPage;
import playWrightFactory.BaseClass;

public class BMErrorsTest extends BaseClass{
	GenericMethods util = new GenericMethods();
	ExcelUtility excel = new ExcelUtility();
	BmApplicationPage bmApp;
	BmErrorsPage bmErrors;

	@BeforeMethod
	public void bmConfig() throws EncryptedDocumentException, IOException, InterruptedException {
		bmApp = new BmApplicationPage(page);
		bmErrors = new BmErrorsPage(page);
		commPage.navigateToBrowserMonitoring();
		commPage.selectTheTimeLineFromCalender(IPathConstant.oneMonthTimeRange);
		bmApp.selectApplication();
		bmErrors.navigateToErrorsTab();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC01_validate_Whether_The_Search_Errors_Text_Field_Is_Present() throws EncryptedDocumentException, IOException {
		bmErrors.validateWhetherTheSearchErrorsTextFieldIsPresent();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC02_validate_The_Functionality_Of_Search_Errors_For_Valid_Data() throws EncryptedDocumentException, IOException {
		bmErrors.validateTheFunctionalityOfSearchErrorsForValidData();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC03_validate_The_Functionality_Of_Search_Errors_For_Invalid_Data() {
		bmErrors.validateTheFunctionalityOfSearchErrorsForInvalidData();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC04_validate_The_First_Column_Title_In_The_Errors_Table() throws EncryptedDocumentException, IOException {
		bmErrors.validateTheFirstColumnTitlteInTheErrorsTable();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC05_validate_The_Second_Column_Title_In_The_Errors_Table() throws EncryptedDocumentException, IOException {
		bmErrors.validateTheSecondColumnTitlteInTheErrorsTable();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC06_validate_The_Third_Column_Title_In_The_Errors_Table() throws EncryptedDocumentException, IOException {
		bmErrors.validateTheThirdColumnTitlteInTheErrorsTable();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC07_validate_The_Fourth_Column_Title_In_The_Errors_Table() throws EncryptedDocumentException, IOException {
		bmErrors.validateTheFourthColumnTitlteInTheErrorsTable();
	}

	@Test (groups = {"BM","UI","Regression"})
	public void TC08_validate_The_Ascending_Functionality_Of_Last_Occurred_Column_In_The_Errors_Table() {
		bmErrors.validateTheAscendingFunctionalityOfLastOccurredColumn();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC09_validate_The_Descending_Functionality_Of_Last_Occurred_Column_In_The_Errors_Table() {
		bmErrors.validateTheDescendingFunctionalityOfLastOccurredColumn();
	}
	
	@Test (dataProvider = "pagination", groups = {"BM","UI","Regression"})
	public void TC10_validate_Pagination_In_Errors_Page(String num) {
		bmErrors.validatePagination(Integer.parseInt(num));
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC11_validate_Whether_The_Download_Report_Button_Is_Active_In_Errors_Page() throws EncryptedDocumentException, IOException {
		bmErrors.validateWhetherTheDownloadReportButtonIsActive();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC12_validate_Functionality_Of_Download_Report_In_Errors_Page() throws EncryptedDocumentException, IOException {
		bmErrors.validateFunctionalityOfDownloadReportInErrorsPage();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC13_validate_Navigation_To_Errors_Events_Page() {
		bmErrors.navigateToErrorsEventsPage();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC14_validate_The_Number_Of_Events_In_Errors_Events_Page_Header() throws EncryptedDocumentException, IOException {
		bmErrors.validateTheNumberOfEventsInErrorsEventsPageHeader();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC15_validate_The_Number_Of_Events_In_Errors_Events_Page_Table() throws EncryptedDocumentException, IOException {
		bmErrors.validateTheNumberOfEventsInErrorsEventsPageTable();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC16_validate_Whether_The_Download_Report_Button_Is_Active_In_Errors_Events_Page() throws EncryptedDocumentException, IOException {
		bmErrors.navigateToErrorsEventsPage();
		bmErrors.validateWhetherTheDownloadReportButtonIsActive();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC17_validate_Functionality_Of_Download_Report_In_Errors_Events_Page() throws EncryptedDocumentException, IOException {
		bmErrors.navigateToErrorsEventsPage();
		bmErrors.validateFunctionalityOfDownloadReportInErrorsEventsPage();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC18_validate_The_First_Column_Title_In_The_Errors_Events_Table() throws EncryptedDocumentException, IOException {
		bmErrors.validateTheFirstColumnTitlteInTheErrorsEventsTable();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC19_validate_The_Second_Column_Title_In_The_Errors_Events_Table() throws EncryptedDocumentException, IOException {
		bmErrors.validateTheSecondColumnTitlteInTheErrorsEventsTable();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC20_validate_The_Third_Column_Title_In_The_Errors_Events_Table() throws EncryptedDocumentException, IOException {
		bmErrors.validateTheThirdColumnTitlteInTheErrorsEventsTable();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC21_validate_The_Fourth_Column_Title_In_The_Errors_Events_Table() throws EncryptedDocumentException, IOException {
		bmErrors.validateTheFourthColumnTitlteInTheErrorsEventsTable();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC22_validate_The_Fifth_Column_Title_In_The_Errors_Events_Table() throws EncryptedDocumentException, IOException {
		bmErrors.validateTheFifthColumnTitlteInTheErrorsEventsTable();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC23_validate_The_Sixth_Column_Title_In_The_Errors_Events_Table() throws EncryptedDocumentException, IOException {
		bmErrors.validateTheSixthColumnTitlteInTheErrorsEventsTable();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC24_validate_The_Ascending_Functionality_Of_Date_And_Time_Column_In_The_Errors_Events_Table() {
		bmErrors.navigateToErrorsEventsPage();
		bmErrors.validateTheAscendingFunctionalityOfDateAndTimeColumn();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC25_validate_The_Descending_Functionality_Of_Date_And_Time_Column_In_The_Errors_Events_Table() {
		bmErrors.navigateToErrorsEventsPage();
		bmErrors.validateTheDescendingFunctionalityOfDateAndTimeColumn();
	}
	
	@Test (dataProvider = "pagination", groups = {"BM","UI","Regression"})
	public void TC26_validate_Pagination_In_Errors_Events_Page(String num) {
		bmErrors.navigateToErrorsEventsPage();
		bmErrors.validatePagination(Integer.parseInt(num));
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC27_validate_The_Default_Text_On_Select_Filter_Dropdown_In_Errors_Events_Page() throws EncryptedDocumentException, IOException {
		bmErrors.navigateToErrorsEventsPage();
		bmErrors.validateTheDefaultTextOnSelectFilterDropdown();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC28_validate_Whether_Search_Feature_Is_Disabled_When_Filter_Is_Not_Selected_In_Errors_Events_Page() throws EncryptedDocumentException, IOException {
		bmErrors.navigateToErrorsEventsPage();
		bmErrors.validateWhetherSearchFeatureIsDisabledWhenFilterIsNotSelected();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC29_validate_Search_By_Event_ID_Feature_In_Errors_Events_Page_For_Valid_Data() throws EncryptedDocumentException, IOException {
		bmErrors.navigateToErrorsEventsPage();
		bmErrors.validateSearchByEventIdForValidData();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC30_validate_Search_By_Event_ID_Feature_In_Errors_Events_Page_For_Invalid_Data() throws EncryptedDocumentException, IOException {
		bmErrors.navigateToErrorsEventsPage();
		bmErrors.validateSearchByEventIdForInvalidData();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC31_validate_Search_By_User_ID_Feature_In_Errors_Events_Page_for_Valid_Data() throws EncryptedDocumentException, IOException {
		bmErrors.navigateToErrorsEventsPage();
		bmErrors.validateSearchByUserIdForValidData();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC32_validate_Search_By_User_ID_Feature_In_Errors_Events_Page_for_Invalid_Data() throws EncryptedDocumentException, IOException {
		bmErrors.navigateToErrorsEventsPage();
		bmErrors.validateSearchByUserIdForInvalidData();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC33_validate_Search_By_Browser_And_Version_Feature_In_Errors_Events_Page_For_Valid_Data() throws EncryptedDocumentException, IOException {
		bmErrors.navigateToErrorsEventsPage();
		bmErrors.validateSearchByBrowserAndVersionForValidData();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC34_validate_Search_By_Browser_And_Version_Feature_In_Errors_Events_Page_For_Invalid_Data() throws EncryptedDocumentException, IOException {
		bmErrors.navigateToErrorsEventsPage();
		bmErrors.validateSearchByBrowserAndVersionForInvalidData();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC35_validate_Search_By_Device_Feature_In_Errors_Events_Page_For_Valid_Data() throws EncryptedDocumentException, IOException {
		bmErrors.navigateToErrorsEventsPage();
		bmErrors.validateSearchByDeviceForValidData();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC36_validate_Search_By_Device_Feature_In_Errors_Events_Page_For_Invalid_Data() throws EncryptedDocumentException, IOException {
		bmErrors.navigateToErrorsEventsPage();
		bmErrors.validateSearchByDeviceForInvalidData();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC37_validate_Search_By_OS_Feature_In_Errors_Events_Page_For_Valid_Data() throws EncryptedDocumentException, IOException {
		bmErrors.navigateToErrorsEventsPage();
		bmErrors.validateSearchByOsForValidData();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC38_validate_Search_By_OS_Feature_In_Errors_Events_Page_For_Invalid_Data() throws EncryptedDocumentException, IOException {
		bmErrors.navigateToErrorsEventsPage();
		bmErrors.validateSearchByOsForInvalidData();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC39_validate_Search_Chip_For_Multiple_Filter_Search_In_Errors_Events_Page() throws EncryptedDocumentException, IOException {
		bmErrors.navigateToErrorsEventsPage();
		bmErrors.validateSearchChipForMultipleSearches();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC40_validate_The_Functionality_Of_Search_Chip_Close_Button_In_Errors_Events_Page() throws EncryptedDocumentException, IOException {
		bmErrors.navigateToErrorsEventsPage();
		bmErrors.validateTheFunctionalityOfSearchChipCloseButton();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC41_validate_The_Functionality_Of_Clear_Filter_Button_In_Errors_Events_Page() throws EncryptedDocumentException, IOException {
		bmErrors.navigateToErrorsEventsPage();
		bmErrors.validateTheFunctionalityOfClearFilterButton();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC42_validate_The_Functionality_Of_Back_Button_In_Errors_Events_Page() throws EncryptedDocumentException, IOException {
		bmErrors.navigateToErrorsEventsPage();
		bmErrors.validateTheFunctionalityOfBackButtonInErrorsEventsPage();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC43_validate_Navigation_To_Events_Detsils_Page_By_Clicking_On_Event_Id_In_Errors_Events_Page() throws EncryptedDocumentException, IOException {
		bmErrors.navigateToErrorsEventsPage();
		bmErrors.validateNavigationToEventsDetsilsPageByClickingOnEventId();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC44_validate_Navigation_To_Events_Detsils_Page_By_Clicking_On_User_Id_In_Errors_Events_Page() throws EncryptedDocumentException, IOException {
		bmErrors.navigateToErrorsEventsPage();
		bmErrors.validateNavigationToEventsDetsilsPageByClickingOnUserId();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC45_validate_Navigation_To_Events_Detsils_Page_By_Clicking_On_Browser_And_Version_In_Errors_Events_Page() throws EncryptedDocumentException, IOException {
		bmErrors.navigateToErrorsEventsPage();
		bmErrors.validateNavigationToEventsDetsilsPageByClickingOnBrowserAndVersion();
	}

	@Test (groups = {"BM","UI","Regression"})
	public void TC46_validate_Navigation_To_Events_Detsils_Page_By_Clicking_On_Device_In_Errors_Events_Page() throws EncryptedDocumentException, IOException {
		bmErrors.navigateToErrorsEventsPage();
		bmErrors.validateNavigationToEventsDetsilsPageByClickingOnDevice();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC47_validate_Navigation_To_Events_Detsils_Page_By_Clicking_On_OS_In_Errors_Events_Page() throws EncryptedDocumentException, IOException {
		bmErrors.navigateToErrorsEventsPage();
		bmErrors.validateNavigationToEventsDetsilsPageByClickingOnOs();
	}
	
	@Test (groups = {"BM","UI","Regression"})
	public void TC48_validate_Navigation_To_Events_Detsils_Page_By_Clicking_On_Date_And_Time_In_Errors_Events_Page() throws EncryptedDocumentException, IOException {
		bmErrors.navigateToErrorsEventsPage();
		bmErrors.validateNavigationToEventsDetsilsPageByClickingOnDateAndTime();
	}
	
	@DataProvider 
	public Object[][] pagination() throws Exception, Exception {
		return excel.fetchAllTheDataFromExcelSheet(IPathConstant.commExcelPath, IPathConstant.commonPaginationSheet);
	}
}

