package apmCapability;

import org.testng.annotations.Test;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import genericUtilities.ExcelUtility;
import genericUtilities.GenericMethods;
import genericUtilities.IPathConstant;
import objectRepository.CommonPage;
import objectRepository.APM.ApmEndpointPage;
import objectRepository.APM.ApmTopologyPage;
import playWrightFactory.BaseClass;

public class ApmTopologyTest extends BaseClass{
	GenericMethods util;
	CommonPage common;
	ApmTopologyPage topo;
	ApmEndpointPage endpoint;
	ExcelUtility excel = new ExcelUtility();
	
	@BeforeMethod
	public void bmConfig() throws EncryptedDocumentException, IOException, InterruptedException {
		topo = new ApmTopologyPage(page);
		endpoint = new ApmEndpointPage(page);
		common = new CommonPage(page);
		util = new GenericMethods();
		common.navigateToApm();
		common.selectTheTimeLineFromCalender(IPathConstant.oneMonthTimeRange);
		endpoint.selectApplication();
		topo.navigateToTopologyPage();
	}
	
	@Test (groups = {"APM", "UI", "Regression"})
	public void TC01_validate_whether_Add_Group_Button_is_Working() throws EncryptedDocumentException, IOException {
		topo.validateAddGroupButton();
	}
	
	@Test (groups = {"APM", "UI", "Regression"})
	public void TC02_validate_Groupname_Text_Field_In_Add_Group_Popup_With_No_Data() throws EncryptedDocumentException, IOException {
		topo.validateGroupnameFieldOfAddGroupPopupWithNoData();
	}
	
	@Test (groups = {"APM", "UI", "Regression"})
	public void TC03_validate_Groupname_Text_Field_In_Add_Group_Popup_With_Duplicate_Data() throws EncryptedDocumentException, IOException {
		topo.validateGroupnameFieldOfAddGroupPopupWithDuplicateData();
	}
	
	@Test (groups = {"APM", "UI", "Regression"})
	public void TC04_validate_Applications_Option_In_Add_Group_Popup_With_No_Data() throws EncryptedDocumentException, IOException {
		topo.validateApplicationsOptionInAddGroupPopupWithNoData();
	}

	@Test (groups = {"APM", "UI", "Regression"})
	public void TC05_validate_Clear_Button_Functionality_In_Add_Group_Popup() throws EncryptedDocumentException, IOException {
		topo.validateClearButtonFunctionalityInAddGroupPopup();
	}
	
	@Test (groups = {"APM", "UI", "Regression"})
	public void TC06_validate_Adding_Application_In_Add_Group_Popup() throws EncryptedDocumentException, IOException {
		topo.validateAddingApplicationInAddGroupPopup();
	}
	
	@Test (groups = {"APM", "UI", "Regression"})
	public void TC07_validate_Whether_Selected_Application_Is_Displaying_As_An_Individual_Token() throws EncryptedDocumentException, IOException {
		topo.validateWhetherSelectedApplicationIsDisplayingAsAnIndividualToken();
	}
	
	@Test (groups = {"APM", "UI", "Regression"})
	public void TC08_validate_Whether_New_Group_With_Single_Application_Can_Be_Added() throws EncryptedDocumentException, IOException {
		topo.validateWhetherNewGroupwithSingleApplicationCanBeAdded();
	}
	
	@Test (groups = {"APM", "UI", "Regression"})
	public void TC09_validate_Whether_A_Group_Can_Be_Edited() throws EncryptedDocumentException, IOException {
		topo.validateWhetherAGroupCanBeEdited();
	}
	
	@Test (groups = {"APM", "UI", "Regression"})
	public void TC10_validate_Whether_A_Group_Can_Be_Deleted() throws EncryptedDocumentException, IOException {
		String grpName = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.topologyPageSheet, "groupNameForEditingGroup");
		topo.validateWhetherAGroupCanBeDeleted(grpName);
	}
	
	@Test (groups = {"APM", "UI", "Regression"})
	public void TC11_validate_Whether_New_Group_With_Multiple_Applications_Can_Be_Added() throws EncryptedDocumentException, IOException {
		topo.validateWhetherNewGroupwithMultipleApplicationsCanBeAdded();
	}
	
	@Test (groups = {"APM", "UI", "Regression"})
	public void TC12_validate_The_First_Column_Name_In_Table_View() throws EncryptedDocumentException, IOException {
		topo.validateTheFirstColumnNameInTableView();
	}
	
	@Test (groups = {"APM", "UI", "Regression"})
	public void TC13_validate_The_Second_Column_Name_In_Table_View() throws EncryptedDocumentException, IOException {
		topo.validateTheSecondColumnNameInTableView();
	}
	
	@Test (groups = {"APM", "UI", "Regression"})
	public void TC14_validate_The_Third_Column_Name_In_Table_View() throws EncryptedDocumentException, IOException {
		topo.validateTheThirdColumnNameInTableView();
	}
	
	@Test (groups = {"APM", "UI", "Regression"})
	public void TC15_validate_The_Fourth_Column_Name_In_Table_View() throws EncryptedDocumentException, IOException {
		topo.validateTheFourthColumnNameInTableView();
	}
	
	@Test (groups = {"APM", "UI", "Regression"})
	public void TC16_validate_The_Fifth_Column_Name_In_Table_View() throws EncryptedDocumentException, IOException {
		topo.validateTheFifthColumnNameInTableView();
	}
	
	@Test (groups = {"APM", "UI", "Regression"})
	public void TC17_validate_The_Sixth_Column_Name_In_Table_View() throws EncryptedDocumentException, IOException {
		topo.validateTheSixthColumnNameInTableView();
	}
	
	@Test (groups = {"APM", "UI", "Regression"})
	public void TC18_validate_Naviagtion_To_Alerts_Page_From_Topology_Page() {
		topo.validateNaviagtionToAlertsPageFromTopologyPage();
	}
	
	@Test (groups = {"APM", "UI", "Regression"})
	public void TC19_validate_Naviagtion_To_Endpoint_Page_From_Topology_Page() {
		topo.validateNaviagtionToEndpointPageFromTopologyPage();
	}

	@Test (groups = {"APM", "UI", "Regression"})
	public void TC20_validate_Naviagtion_To_Instance_Page_From_Topology_Page() {
		topo.validateNaviagtionToInstancePageFromTopologyPage();
	}
	
	@Test (groups = {"APM", "UI", "Regression"})
	public void TC21_validate_Naviagtion_To_Trace_Page_From_Topology_Page() {
		topo.validateNaviagtionToTracePageFromTopologyPage();
	}
	
	@Test (groups = {"APM", "UI", "Regression"})
	public void TC22_validate_Naviagtion_To_APM_Page_From_Topology_Page() {
		topo.validateNaviagtionToApmPageFromTopologyPage();
	}

	@Test (groups = {"APM", "UI", "Regression"})
	public void TC23_validate_Naviagtion_To_Infrastructure_Page_From_Topology_Page() {
		topo.validateNaviagtionToInfrastructurePageFromTopologyPage();
	}
	
	@Test (groups = {"APM", "UI", "Regression"})
	public void TC24_validate_Whether_Apdex_Value_Is_Displayed_In_The_Apdex_Graph_Header() {
		topo.validateWhetherApdexValueIsDisplayedInApdexGraphHeader();
	}
	
	@Test (groups = {"APM", "UI", "Regression"})
	public void TC25_validate_Whether_Response_Time_Value_Is_Displayed_In_The_Response_Time_Graph_Header() {
		topo.validateWhetherResponseTimeValueIsDisplayedInResponseTimeGraphHeader();
	}
	
	@Test (groups = {"APM", "UI", "Regression"})
	public void TC26_validate_Whether_Error_Value_Is_Displayed_In_The_Error_Graph_Header() {
		topo.validateWhetherErrorValueIsDisplayedInErrorGraphHeader();
	}
	
	@Test (groups = {"APM", "UI", "Regression"})
	public void TC27_validate_Whether_Error_Percentage_Value_Is_Displayed_In_The_Error_Graph_Header() {
		topo.validateWhetherErrorPercentageValueIsDisplayedInErrorGraphHeader();
	}
	
	@Test (groups = {"APM", "UI", "Regression"})
	public void TC28_validate_Whether_Errors_Per_Minute_Value_Is_Displayed_In_The_Error_Graph_Header() {
		topo.validateWhetherErrorsPerMinValueIsDisplayedInErrorGraphHeader();
	}
	
	@Test (groups = {"APM", "UI", "Regression"})
	public void TC29_validate_The_Functionality_Of_Left_Application_Overview_Panel_Close_Button() {
		topo.validateTheFunctionalityOfLeftApplicationOverviewPanelCloseButton();
	}
	
	@Test (groups = {"APM", "UI", "Regression"})
	public void TC30_validate_The_Functionality_Of_Right_Application_Overview_Panel_Close_Button() {
		topo.validateTheFunctionalityOfRightApplicationOverviewPanelCloseButton();
	}
	
	@Test (groups = {"APM", "UI", "Regression"})
	public void TC31_validate_Whether_Health_Toolbar_Is_Displayed() {
		topo.validateWhetherHealthToolbarIsDisplayed();
	}

	@Test (groups = {"APM", "UI", "Regression"})
	public void TC32_validate_The_Good_Health_Indicator_In_Health_Bar() throws EncryptedDocumentException, IOException {
		topo.validateTheGoodHealthIndicatorInHealthBar();
	}
	
	@Test (groups = {"APM", "UI", "Regression"})
	public void TC33_validate_The_Fair_Health_Indicator_In_Health_Bar() throws EncryptedDocumentException, IOException {
		topo.validateTheFairHealthIndicatorInHealthBar();
	}
	
	@Test (groups = {"APM", "UI", "Regression"})
	public void TC34_validate_The_Poor_Health_Indicator_In_Health_Bar() throws EncryptedDocumentException, IOException {
		topo.validateThePoorHealthIndicatorInHealthBar();
	}
	
	@Test (groups = {"APM", "UI", "Regression"})
	public void TC35_validate_Whether_Health_Tooltip_Is_Displayed() {
		topo.validateWhetherHealthTooltipIsDisplayed();
	}
	
	@Test (groups = {"APM", "UI", "Regression"})
	public void TC36_validate_Good_Health_Indicator_Value_In_The_Health_Tooltip () throws EncryptedDocumentException, IOException {
		topo.validateGoodHealthIndicatorValueInTheHealthTooltip();
	}
	
	@Test (groups = {"APM", "UI", "Regression"})
	public void TC37_validate_Fair_Health_Indicator_Value_In_The_Health_Tooltip () throws EncryptedDocumentException, IOException {
		topo.validateFairHealthIndicatorValueInTheHealthTooltip();
	}
	
	@Test (groups = {"APM", "UI", "Regression"})
	public void TC38_validate_Poor_Health_Indicator_Value_In_The_Health_Tooltip () throws EncryptedDocumentException, IOException {
		topo.validatePoorHealthIndicatorValueInTheHealthTooltip();
	}
	
	@Test (groups = {"APM", "UI", "Regression"})
	public void TC39_validate_The_Soft_Refresh_Options_Selection() throws EncryptedDocumentException, IOException {
		common.validateRefreshOptionsForAvailabilityAndSelection();
	}
	
	@AfterMethod
	public void closethePopupIfPresent() {
		topo.closeThePopup();
	}
}

