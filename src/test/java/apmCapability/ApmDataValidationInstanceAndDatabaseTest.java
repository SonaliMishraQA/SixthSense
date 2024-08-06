package apmCapability;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import genericUtilities.GenericMethods;
import genericUtilities.IPathConstant;
import objectRepository.CommonPage;
import objectRepository.APM.ApmApplicationPage;
import objectRepository.APM.ApmDatabasePage;
import objectRepository.APM.ApmEndpointPage;
import objectRepository.APM.ApmInstancePage;
import objectRepository.APM.ApmTopologyPage;
import playWrightFactory.BaseClass;

public class ApmDataValidationInstanceAndDatabaseTest extends BaseClass{
	GenericMethods util;
	CommonPage common;
	ApmTopologyPage topo;
	ApmEndpointPage endpoint;
	ApmDatabasePage database;
	ApmInstancePage instance;
	ApmApplicationPage dashboard;
	
	@BeforeMethod
	public void bmConfig() throws EncryptedDocumentException, IOException, InterruptedException {
		topo = new ApmTopologyPage(page);
		endpoint = new ApmEndpointPage(page);
		common = new CommonPage(page);
		database = new ApmDatabasePage(page);
		instance = new ApmInstancePage(page);
		dashboard = new ApmApplicationPage(page);
		util = new GenericMethods();
		common.navigateToApm();
		common.selectTheTimeLineFromCalender(IPathConstant.sixHoursTimeRange);
		endpoint.selectApplication();
	}
	
	@Test (groups = {"APM", "Regression"})
	public void TC01_validate_The_Number_Of_Calls_In_Load_Graph_Header_In_Database_Page() throws EncryptedDocumentException, IOException {
		database.navigateToDatabasePage();
		database.validateNumberOfCallsInLoadGraphHeader();
	}
	
	@Test (groups = {"APM", "Regression"})
	public void TC02_validate_The_Number_Of_Calls_In_Load_Graph_In_Database_Page() throws EncryptedDocumentException, IOException {
		database.navigateToDatabasePage();
		database.validateNumberOfCallsInLoadGraph();
	}
	
	@Test (groups = {"APM", "Regression"})
	public void TC03_validate_The_Calls_Per_Minute_In_Load_Graph_Header_In_Database_Page() throws EncryptedDocumentException, IOException {
		database.navigateToDatabasePage();
		common.selectTheTimeLineFromCalender(IPathConstant.sixtyMinutesTimeRange);
		database.validateCallsPerMinuteInLoadGraphHeader();
	}
	
	@Test (groups = {"APM", "Regression"})
	public void TC04_validate_The_Number_Of_Errors_In_Access_Error_Graph_Header_In_Database_Page() throws EncryptedDocumentException, IOException {
		database.navigateToDatabasePage();
		database.validateNumberOfErrorsInAccessErrorGraphHeader();
	}
	
	@Test (groups = {"APM", "Regression"})
	public void TC05_validate_The_Number_Of_Errors_In_Access_Error_Graph_In_Database_Page() throws EncryptedDocumentException, IOException {
		database.navigateToDatabasePage();
		database.validateNumberOfErrorsInAccessErrorGraph();
	}
	
	@Test (groups = {"APM", "Regression"})
	public void TC06_validate_The_Errors_Per_Minute_In_Access_Error_Graph_Header_In_Database_Page() throws EncryptedDocumentException, IOException {
		database.navigateToDatabasePage();
		common.selectTheTimeLineFromCalender(IPathConstant.threeHoursTimeRange);
		database.validateErrorsPerMinuteInAccessErrorGraphHeader();
	}
	
	@Test (groups = {"APM", "Regression"})
	public void TC07_validate_The_Errors_Percentage_In_Access_Error_Graph_Header_In_Database_Page() throws EncryptedDocumentException, IOException {
		database.navigateToDatabasePage();
		database.validateErrorsPercentageInAccessErrorGraphHeader();
	}
	
	@Test (groups = {"APM", "Regression"})
	public void TC08_validate_The_Average_Response_Time_In_Response_Time_Graph_In_Database_Page() {
		database.navigateToDatabasePage();
		database.validateTheAverageResponseTimeInResponseTimeGraph();
	}
	
	@Test (groups = {"APM", "Regression"})
	public void TC09_validate_The_Query_Statement_In_Query_Page() throws EncryptedDocumentException, IOException {
		database.navigateToDatabasePage();
		database.validateTheQueryStatementInQueryPage();
	}
	
	@Test (groups = {"APM", "Regression"})
	public void TC10_validate_Whether_The_Query_Statement_Copy_Button_Is_Working() throws EncryptedDocumentException, IOException {
		database.navigateToDatabasePage();
		database.validateTheQueryStatementCopyButton();
	}
	
	@Test (groups = {"APM", "Regression"})
	public void TC11_validate_The_Query_CountIn_Query_Page() throws EncryptedDocumentException, IOException {
		database.navigateToDatabasePage();
		database.validateTheQueryCountForTheQueryStatement();
	}
	
	@Test (groups = {"APM", "Regression"})
	public void TC12_validate_The_Database_Name_In_Database_Page() throws EncryptedDocumentException, IOException {
		database.navigateToDatabasePage();
		database.validateTheDatabaseNameInDatabasePage();
	}
	
	@Test (groups = {"APM", "Regression"})
	public void TC13_validate_The_Instances_Names_In_Instance_Page() throws EncryptedDocumentException, IOException, InterruptedException {
		instance.navigateToInstancePage();
		instance.validateTheInstancesNamesInInstancePage();
	}
	
	@Test (groups = {"APM", "Regression"})
	public void TC14_validate_The_Number_Of_Calls_On_Instance_Page_Table() throws InterruptedException {
		dashboard.navigateToApplicationPage();
		int calls = dashboard.getNumberOfCallsFromLoadGraphHeader();
		instance.navigateToInstancePage();
		instance.validateTheNummberOfCallsOnInstancePage(calls);
	}
	
	@Test (groups = {"APM", "Regression"})
	public void TC15_validate_The_Number_Of_Errors_On_Instance_Page_Table() throws InterruptedException {
		dashboard.navigateToApplicationPage();
		int errors = dashboard.getNumberOfErrorsFromErrorGraphHeader();
		instance.navigateToInstancePage();
		instance.validateTheNummberOfErrorsOnInstancePage(errors);
	}
	
	@Test (groups = {"APM", "Regression"})
	public void TC16_validate_The_Percentile_Response_Time_On_Database_Page() throws EncryptedDocumentException, IOException {
		database.navigateToDatabasePage();
		database.validateThePercentileResponseTimeOnDatabasePage();
	}
}
