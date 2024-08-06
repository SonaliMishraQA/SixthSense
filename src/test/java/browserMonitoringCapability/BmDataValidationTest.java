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
import objectRepository.BM.BmEventsDetailsPage;
import objectRepository.BM.BmPagesPage;
import playWrightFactory.BaseClass;

public class BmDataValidationTest extends BaseClass{
	
	BmApplicationPage bmApp;
	BmApiRequests bmApiReq;
	BmPagesPage bmPage;
	BmEventsDetailsPage bmEvents;
	BmErrorsPage bmErrors;
	GenericMethods util = new GenericMethods();
	ExcelUtility excel = new ExcelUtility();
	
	
	@BeforeMethod
	public void bmConfig() {
		bmApp = new BmApplicationPage(page);
		bmPage = new BmPagesPage(page);
		bmErrors = new BmErrorsPage(page);
		bmEvents = new BmEventsDetailsPage(page);
		commPage.navigateToBrowserMonitoring();
		bmApiReq = new BmApiRequests(page);
	}

	@Test (groups = {"BM","Regression"})
	public void TC01_generate_Performance_Load_For_BM_Angular_Application_And_Validate() throws IOException {
		int load = bmApiReq.generatePerformanceLoadForBMAngularApplication();
		selectTimeLineAndApplicationForBMAngularLoad();
		bmApp.validateTheLoadInApplicationPageLoadGraphHeader(load);
		bmApp.validateTheLoadInApplicationPageLoadGraph(load);
		bmPage.validateTheLoadInPagesTable(load);
	}
	
	@Test (groups = {"BM","Regression"})
	public void TC02_validate_The_Calls_Per_Minute_In_Load_Graph() throws EncryptedDocumentException, IOException {
		selectTimeLineAndApplicationForBMAngularLoad();
		bmApp.validateTheCallsPerMinuteInLoadGraph();
	}
	
	@Test (groups = {"BM","Regression"})
	public void TC03_validate_The_Load_Time() throws EncryptedDocumentException, IOException {
		selectTimeLineAndApplicationForBMAngularLoad();
		bmApp.validateTheLoadTimeInLoadGraph();
		bmPage.validateAverageResponseTimeInPagesPage();
	}
	
	@Test (groups = {"BM","Regression"})
	public void TC04_validate_The_Legend_browser_app_page_redirect_avg_In_User_Centric_Page_Load_And_Event_Execution_Time_Graph() throws EncryptedDocumentException, IOException {
		selectTimeLineAndApplicationForBMAngularLoad();
		bmPage.navigateToPagesTab();
		bmPage.validateTheNavigationToPagesGraphPage();
		bmPage.selectLegend_Browser_app_page_redirect_avg_AndValidateTheValueInGraph();
	}
	
	@Test (groups = {"BM","Regression"})
	public void TC05_validate_The_Legend_browser_app_page_dns_avg_In_User_Centric_Page_Load_And_Event_Execution_Time_Graph() throws EncryptedDocumentException, IOException {
		selectTimeLineAndApplicationForBMAngularLoad();
		bmPage.navigateToPagesTab();
		bmPage.validateTheNavigationToPagesGraphPage();
		bmPage.selectLegend_Browser_app_page_dns_avg_AndValidateTheValueInGraph();
	}
	
	@Test (groups = {"BM","Regression"})
	public void TC06_validate_The_Legend_browser_app_page_ttfb_avg_In_User_Centric_Page_Load_And_Event_Execution_Time_Graph() throws EncryptedDocumentException, IOException {
		selectTimeLineAndApplicationForBMAngularLoad();
		bmPage.navigateToPagesTab();
		bmPage.validateTheNavigationToPagesGraphPage();
		bmPage.selectLegend_Browser_app_page_ttfb_avg_AndValidateTheValueInGraph();
	}
	
	@Test (groups = {"BM","Regression"})
	public void TC07_validate_The_Legend_browser_app_page_tcp_avg_In_User_Centric_Page_Load_And_Event_Execution_Time_Graph() throws EncryptedDocumentException, IOException {
		selectTimeLineAndApplicationForBMAngularLoad();
		bmPage.navigateToPagesTab();
		bmPage.validateTheNavigationToPagesGraphPage();
		bmPage.selectLegend_Browser_app_page_tcp_avg_AndValidateTheValueInGraph();
	}
	
	@Test (groups = {"BM","Regression"})
	public void TC08_validate_The_Legend_browser_app_page_trans_avg_In_User_Centric_Page_Load_And_Event_Execution_Time_Graph() throws EncryptedDocumentException, IOException {
		selectTimeLineAndApplicationForBMAngularLoad();
		bmPage.navigateToPagesTab();
		bmPage.validateTheNavigationToPagesGraphPage();
		bmPage.selectLegend_Browser_app_page_trans_avg_AndValidateTheValueInGraph();
	}
	
	@Test (groups = {"BM","Regression"})
	public void TC09_validate_The_Legend_browser_app_page_dom_analysis_avg_In_User_Centric_Page_Load_And_Event_Execution_Time_Graph() throws EncryptedDocumentException, IOException {
		selectTimeLineAndApplicationForBMAngularLoad();
		bmPage.navigateToPagesTab();
		bmPage.validateTheNavigationToPagesGraphPage();
		bmPage.selectLegend_Browser_app_page_dom_analysis_avg_AndValidateTheValueInGraph();
	}
	
	@Test (groups = {"BM","Regression"})
	public void TC10_validate_The_Legend_browser_app_page_fpt_avg_In_User_Centric_Page_Load_And_Event_Execution_Time_Graph() throws EncryptedDocumentException, IOException {
		selectTimeLineAndApplicationForBMAngularLoad();
		bmPage.navigateToPagesTab();
		bmPage.validateTheNavigationToPagesGraphPage();
		bmPage.selectLegend_Browser_app_page_fpt_avg_AndValidateTheValueInGraph();
	}
	
	@Test (groups = {"BM","Regression"})
	public void TC11_validate_The_Legend_browser_app_page_dom_ready_avg_In_User_Centric_Page_Load_And_Event_Execution_Time_Graph() throws EncryptedDocumentException, IOException {
		selectTimeLineAndApplicationForBMAngularLoad();
		bmPage.navigateToPagesTab();
		bmPage.validateTheNavigationToPagesGraphPage();
		bmPage.selectLegend_Browser_app_page_dom_ready_avg_AndValidateTheValueInGraph();
	}
	
	@Test (groups = {"BM","Regression"})
	public void TC12_validate_The_Legend_browser_app_page_load_page_avg_In_User_Centric_Page_Load_And_Event_Execution_Time_Graph() throws EncryptedDocumentException, IOException {
		selectTimeLineAndApplicationForBMAngularLoad();
		bmPage.navigateToPagesTab();
		bmPage.validateTheNavigationToPagesGraphPage();
		bmPage.selectLegend_Browser_app_page_load_page_avg_AndValidateTheValueInGraph();
	}
	
	@Test (groups = {"BM","Regression"})
	public void TC13_validate_The_Legend_browser_app_page_res_avg_In_User_Centric_Page_Load_And_Event_Execution_Time_Graph() throws EncryptedDocumentException, IOException {
		selectTimeLineAndApplicationForBMAngularLoad();
		bmPage.navigateToPagesTab();
		bmPage.validateTheNavigationToPagesGraphPage();
		bmPage.selectLegend_Browser_app_page_res_avg_AndValidateTheValueInGraph();
	}
	
	@Test (groups = {"BM","Regression"})
	public void TC14_validate_The_Legend_browser_app_page_ttl_avg_In_User_Centric_Page_Load_And_Event_Execution_Time_Graph() throws EncryptedDocumentException, IOException {
		selectTimeLineAndApplicationForBMAngularLoad();
		bmPage.navigateToPagesTab();
		bmPage.validateTheNavigationToPagesGraphPage();
		bmPage.selectLegend_Browser_app_page_ttl_avg_AndValidateTheValueInGraph();
	}
	
	@Test (groups = {"BM","Regression"})
	public void TC15_validate_The_Legend_browser_app_page_first_pack_avg_In_User_Centric_Page_Load_And_Event_Execution_Time_Graph() throws EncryptedDocumentException, IOException {
		selectTimeLineAndApplicationForBMAngularLoad();
		bmPage.navigateToPagesTab();
		bmPage.validateTheNavigationToPagesGraphPage();
		bmPage.selectLegend_Browser_app_page_first_pack_avg_AndValidateTheValueInGraph();
	}
	
	@Test (groups = {"BM","Regression"})
	public void TC16_validate_The_Legend_browser_app_page_fmp_avg_In_User_Centric_Page_Load_And_Event_Execution_Time_Graph() throws EncryptedDocumentException, IOException {
		selectTimeLineAndApplicationForBMAngularLoad();
		bmPage.navigateToPagesTab();
		bmPage.validateTheNavigationToPagesGraphPage();
		bmPage.selectLegend_Browser_app_page_fmp_avg_AndValidateTheValueInGraph();
	}
	
	@Test (groups = {"BM","Regression"})
	public void TC17_generate_Error_Load_For_BM_Angular_Application_And_Validate() throws IOException, NumberFormatException, EncryptedDocumentException, InterruptedException {
		int error = bmApiReq.generateErrorLoadForBMAngularApplication();
		System.out.println(error);
		selectTimeLineAndApplicationForBMAngularLoad();
		bmApp.validateTheErrorInApplicationPageErrorGraphHeader(error);
		bmApp.validateTheErrorInApplicationPageErrorGraph(error);
		bmApp.validateTheErrorInApplicationPageErrorCountMap(error);
		bmPage.validateTheErrorInPagesTable(error);
	}
	
	@Test (groups = {"BM","Regression"})
	public void TC18_validate_The_Errors_Per_Minute_In_Error_Graph() throws EncryptedDocumentException, IOException {
		selectTimeLineAndApplicationForBMAngularLoad();
		bmApp.validateTheErrorsPerMinuteInErrorGraph();
	}
	
	@Test (groups = {"BM","Regression"})
	public void TC19_validate_The_Users_Impacted_By_Errors() throws EncryptedDocumentException, IOException {
		selectTimeLineAndApplicationForBMAngularLoad();
		bmApp.validateTheUsersImpactedByErrors();
	}
	
	@Test (groups = {"BM","Regression"})
	public void TC20_validate_The_Application_Key_And_Value_For_Angular_Application() throws EncryptedDocumentException, IOException {
		selectTimeLineAndApplicationForBMAngularLoad();
		navigateToEventsDetailsPage();
		bmEvents.validateTheApplicationKeyAndValueForAngularApplication();
	}
	
	@Test (groups = {"BM","Regression"})
	public void TC21_validate_The_Application_Version_Key_And_Value_For_Angular_Application() throws EncryptedDocumentException, IOException {
		selectTimeLineAndApplicationForBMAngularLoad();
		navigateToEventsDetailsPage();
		bmEvents.validateTheApplicationVersionKeyAndValueForAngularApplication();
	}
	
	@Test (groups = {"BM","Regression"})
	public void TC22_validate_The_Environment_Key_And_Value_For_Angular_Application() throws EncryptedDocumentException, IOException {
		selectTimeLineAndApplicationForBMAngularLoad();
		navigateToEventsDetailsPage();
		bmEvents.validateTheEnvironmentKeyAndValueForAngularApplication();
	}
	
	@Test (groups = {"BM","Regression"})
	public void TC23_validate_The_Error_URL_Key_And_Value_For_Angular_Application() throws EncryptedDocumentException, IOException {
		selectTimeLineAndApplicationForBMAngularLoad();
		navigateToEventsDetailsPage();
		bmEvents.validateTheErrorUrlKeyAndValueForAngularApplication();
	}
	
	@Test (groups = {"BM","Regression"})
	public void TC24_validate_The_Page_Path_Key_And_Value_For_Angular_Application() throws EncryptedDocumentException, IOException {
		selectTimeLineAndApplicationForBMAngularLoad();
		navigateToEventsDetailsPage();
		bmEvents.validateThePagePathKeyAndValueForAngularApplication();
	}
	
	@Test (groups = {"BM","Regression"})
	public void TC25_validate_The_Error_Key_And_Value_For_Angular_Application() throws EncryptedDocumentException, IOException {
		selectTimeLineAndApplicationForBMAngularLoad();
		navigateToEventsDetailsPage();
		bmEvents.validateTheErrorKeyAndValueForAngularApplication();
	}
	
	@Test (groups = {"BM","Regression"})
	public void TC26_validate_The_Category_Key_And_Value_For_Angular_Application() throws EncryptedDocumentException, IOException {
		selectTimeLineAndApplicationForBMAngularLoad();
		navigateToEventsDetailsPage();
		bmEvents.validateTheCategoryKeyAndValueForAngularApplication();
	}
	
	@Test (groups = {"BM","Regression"})
	public void TC27_validate_The_Time_Key_And_Value_For_Angular_Application() throws EncryptedDocumentException, IOException {
		selectTimeLineAndApplicationForBMAngularLoad();
		bmErrors.navigateToErrorsTab();
		bmErrors.navigateToErrorsEventsPage();
		bmEvents.validateTheTimeKeyAndValueForAngularApplication();
	}
	
	@Test (groups = {"BM","Regression"})
	public void TC28_validate_The_Error_Type_Key_And_Value_For_Angular_Application() throws EncryptedDocumentException, IOException {
		selectTimeLineAndApplicationForBMAngularLoad();
		navigateToEventsDetailsPage();
		bmEvents.validateTheErrorTypeKeyAndValueForAngularApplication();
	}
	
	@Test (groups = {"BM","Regression"})
	public void TC29_validate_The_Message_Key_And_Value_For_Angular_Application() throws EncryptedDocumentException, IOException {
		selectTimeLineAndApplicationForBMAngularLoad();
		navigateToEventsDetailsPage();
		bmEvents.validateTheMessageKeyAndValueForAngularApplication();
	}
	
	@Test (groups = {"BM","Regression"})
	public void TC30_validate_The_Name_Key_And_Value_For_Angular_Application() throws EncryptedDocumentException, IOException {
		selectTimeLineAndApplicationForBMAngularLoad();
		navigateToEventsDetailsPage();
		bmEvents.validateTheNameKeyAndValueForAngularApplication();
	}
	
	@Test (groups = {"BM","Regression"})
	public void TC31_validate_The_Version_Key_And_Value_For_Angular_Application() throws EncryptedDocumentException, IOException {
		selectTimeLineAndApplicationForBMAngularLoad();
		navigateToEventsDetailsPage();
		bmEvents.validateTheVersionKeyAndValueForAngularApplication();
	}
	
	@Test (groups = {"BM","Regression"})
	public void TC32_validate_The_User_Agent_Key_And_Value_For_Angular_Application() throws EncryptedDocumentException, IOException {
		selectTimeLineAndApplicationForBMAngularLoad();
		navigateToEventsDetailsPage();
		bmEvents.validateTheUserAgentKeyAndValueForAngularApplication();
	}
	
	@Test (groups = {"BM","Regression"})
	public void TC33_generate_Performance_Load_For_BM_React_Application_And_Validate() throws IOException {
		int load = bmApiReq.generatePerformanceLoadForBMReactApplication();
		selectTimeLineAndApplicationForBMReactLoad();
		bmApp.validateTheLoadInApplicationPageLoadGraphHeader(load);
		bmApp.validateTheLoadInApplicationPageLoadGraph(load);
		bmPage.validateTheLoadInPagesTable(load);
	}
	
	@Test (groups = {"BM","Regression"})
	public void TC34_generate_Error_Load_For_BM_React_Application_And_Validate() throws NumberFormatException, EncryptedDocumentException, IOException, InterruptedException {
		int error = bmApiReq.generateErrorLoadForBMReactApplication();
		System.out.println(error);
		selectTimeLineAndApplicationForBMReactLoad();
		bmApp.validateTheErrorInApplicationPageErrorGraphHeader(error);
		bmApp.validateTheErrorInApplicationPageErrorGraph(error);
		bmApp.validateTheErrorInApplicationPageErrorCountMap(error);
		bmPage.validateTheErrorInPagesTable(error);
	}
	
	@Test (groups = {"BM","Regression"})
	public void TC35_validate_The_Application_Key_And_Value_For_React_Application() throws EncryptedDocumentException, IOException {
		selectTimeLineAndApplicationForBMReactLoad();
		navigateToEventsDetailsPage();
		bmEvents.validateTheApplicationKeyAndValueForReactApplication();
	}
	
	@Test (groups = {"BM","Regression"})
	public void TC36_validate_The_Application_Version_Key_And_Value_For_React_Application() throws EncryptedDocumentException, IOException {
		selectTimeLineAndApplicationForBMReactLoad();
		navigateToEventsDetailsPage();
		bmEvents.validateTheApplicationVersionKeyAndValueForReactApplication();
	}
	
	@Test (groups = {"BM","Regression"})
	public void TC37_validate_The_Environment_Key_And_Value_For_React_Application() throws EncryptedDocumentException, IOException {
		selectTimeLineAndApplicationForBMReactLoad();
		navigateToEventsDetailsPage();
		bmEvents.validateTheEnvironmentKeyAndValueForReactApplication();
	}
	
	@Test (groups = {"BM","Regression"})
	public void TC38_validate_The_Error_URL_Key_And_Value_For_React_Application() throws EncryptedDocumentException, IOException {
		selectTimeLineAndApplicationForBMReactLoad();
		navigateToEventsDetailsPage();
		bmEvents.validateTheErrorUrlKeyAndValueForReactApplication();
	}
	
	@Test (groups = {"BM","Regression"})
	public void TC39_validate_The_Page_Path_Key_And_Value_For_React_Application() throws EncryptedDocumentException, IOException {
		selectTimeLineAndApplicationForBMReactLoad();
		navigateToEventsDetailsPage();
		bmEvents.validateThePagePathKeyAndValueForReactApplication();
	}
	
	@Test (groups = {"BM","Regression"})
	public void TC40_validate_The_Error_Key_And_Value_For_React_Application() throws EncryptedDocumentException, IOException {
		selectTimeLineAndApplicationForBMReactLoad();
		navigateToEventsDetailsPage();
		bmEvents.validateTheErrorKeyAndValueForReactApplication();
	}
	
	@Test (groups = {"BM","Regression"})
	public void TC41_validate_The_Category_Key_And_Value_For_React_Application() throws EncryptedDocumentException, IOException {
		selectTimeLineAndApplicationForBMReactLoad();
		navigateToEventsDetailsPage();
		bmEvents.validateTheCategoryKeyAndValueForReactApplication();
	}
	
	@Test (groups = {"BM","Regression"})
	public void TC42_validate_The_Time_Key_And_Value_For_React_Application() throws EncryptedDocumentException, IOException {
		selectTimeLineAndApplicationForBMReactLoad();
		bmErrors.navigateToErrorsTab();
		bmErrors.navigateToErrorsEventsPage();
		bmEvents.validateTheTimeKeyAndValueForReactApplication();
	}
	
	@Test (groups = {"BM","Regression"})
	public void TC43_validate_The_Error_Type_Key_And_Value_For_React_Application() throws EncryptedDocumentException, IOException {
		selectTimeLineAndApplicationForBMReactLoad();
		navigateToEventsDetailsPage();
		bmEvents.validateTheErrorTypeKeyAndValueForReactApplication();
	}
	
	@Test (groups = {"BM","Regression"})
	public void TC44_validate_The_Message_Key_And_Value_For_React_Application() throws EncryptedDocumentException, IOException {
		selectTimeLineAndApplicationForBMReactLoad();
		navigateToEventsDetailsPage();
		bmEvents.validateTheMessageKeyAndValueForReactApplication();
	}
	
	@Test (groups = {"BM","Regression"})
	public void TC45_validate_The_Name_Key_And_Value_For_React_Application() throws EncryptedDocumentException, IOException {
		selectTimeLineAndApplicationForBMReactLoad();
		navigateToEventsDetailsPage();
		bmEvents.validateTheNameKeyAndValueForReactApplication();
	}
	
	@Test (groups = {"BM","Regression"})
	public void TC46_validate_The_Version_Key_And_Value_For_React_Application() throws EncryptedDocumentException, IOException {
		selectTimeLineAndApplicationForBMReactLoad();
		navigateToEventsDetailsPage();
		bmEvents.validateTheVersionKeyAndValueForReactApplication();
	}
	
	@Test (groups = {"BM","Regression"})
	public void TC47_validate_The_User_Agent_Key_And_Value_For_React_Application() throws EncryptedDocumentException, IOException {
		selectTimeLineAndApplicationForBMReactLoad();
		navigateToEventsDetailsPage();
		bmEvents.validateTheUserAgentKeyAndValueForReactApplication();
	}
	
	@Test (groups = {"BM","Regression"})
	public void TC48_validate_The_Error_Graph_In_Pages_Graph_Page_For_Ajax_Category_Errors() throws EncryptedDocumentException, IOException {
		selectTimeLineAndApplicationForBMAngularLoad();
		bmPage.validateTheErrorGraphInPagesGraphPageForAjaxCategoryErrors();
	}
	
	@Test (groups = {"BM","Regression"})
	public void TC49_validate_The_Error_Graph_In_Pages_Graph_Page_For_Js_Category_Errors() throws EncryptedDocumentException, IOException {
		selectTimeLineAndApplicationForBMAngularLoad();
		bmPage.validateTheErrorGraphInPagesGraphPageForJsCategoryErrors();
	}
	
	@Test (groups = {"BM","Regression"})
	public void TC50_validate_The_Error_Graph_In_Pages_Graph_Page_For_Resource_Category_Errors() throws EncryptedDocumentException, IOException {
		selectTimeLineAndApplicationForBMAngularLoad();
		bmPage.validateTheErrorGraphInPagesGraphPageForResourceCategoryErrors();
	}
	
	@Test (groups = {"BM","Regression"})
	public void TC51_validate_The_User_Id_And_Event_Id() throws EncryptedDocumentException, IOException {
		bmApiReq.validateUserIdAndEventId();
	}
	
	@Test (groups = {"BM","Regression"})
	public void TC52_generate_The_Performance_Load_With_Multiple_Pages_And_Validate() throws EncryptedDocumentException, IOException {
		bmApiReq.generateThePerformanceLoadWIthMultiplePagesAndValidate();
	}
	
	@Test (groups = {"BM","Regression"})
	public void TC53_validate_Apdex_Score() throws EncryptedDocumentException, IOException {
		bmApiReq.setApdexResponseTimeAndValidateApdexScoreByPushingLoad();
	}
	
	public void selectTimeLineAndApplicationForBMAngularLoad() throws EncryptedDocumentException, IOException {
		String application = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmDataValidationSheet, "angularApplicationName");
		bmApp.selectApplication(application);
		page.waitForTimeout(2000);
		commPage.selectTheTimeLineFromCalender(IPathConstant.fifteenMinutesTimeRange);
		page.waitForTimeout(5000);
	}
	
	public void selectTimeLineAndApplicationForBMReactLoad() throws EncryptedDocumentException, IOException {
		String application = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmDataValidationSheet, "reactApplicationName");
		commPage.selectTheTimeLineFromCalender(IPathConstant.fifteenMinutesTimeRange);
		page.waitForTimeout(2000);
		bmApp.selectApplication(application);
		page.waitForTimeout(5000);
	}
	
	public void navigateToEventsDetailsPage() {
		bmErrors.navigateToErrorsTab();
		bmErrors.navigateToErrorsEventsPage();
		bmErrors.validateNavigationToEventsDetsilsPageByClickingOnEventId();
	}
}