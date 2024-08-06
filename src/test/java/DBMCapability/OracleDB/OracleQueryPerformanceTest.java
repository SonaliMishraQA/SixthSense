package DBMCapability.OracleDB;


import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;
import genericUtilities.ExcelUtility;
import genericUtilities.IPathConstant;
import objectRepository.CommonPage;
import objectRepository.HomePage;
import objectRepository.DBM.OracleQueryperformance;
import objectRepository.DBM.PostgresHardware;
import playWrightFactory.BaseClass;

public class OracleQueryPerformanceTest extends BaseClass{
	
	HomePage homePage;
	ExcelUtility eutil;
	OracleQueryperformance qpPage;
	PostgresHardware hardwarePage;
	CommonPage comPage;
	
	@BeforeMethod
	public void preRequest() throws EncryptedDocumentException, IOException, InterruptedException
	{
		eutil=new ExcelUtility();
		homePage=new HomePage(page);
		qpPage=new OracleQueryperformance(page);
		hardwarePage = new PostgresHardware(page);
		Thread.sleep(5000);
		
		//Navigate to DBM capability
		commPage.navigateToDBM();

		//select the DBM type
		hardwarePage.selectDBMtype(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.oracleGreeshma, "DBMType"));
		
		//select the service 
		hardwarePage.selectDbservice(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.oracleGreeshma, "DBMservice"));
		
		// selecting the database option
		//hardwarePage.selectdatabse();
		
		//navigating to the Query performance tab
		//qpPage.validateQueryPerformanceNavigation();
	}
	
	@Test(groups = {"DBM","UI","Regression","Oracle"})
     public void TC_01_validatingQueryPerformanceTabIsPresent(){
		page.pause();
		qpPage.validateQueryPerformanceTab();
	}
	
	@Test(groups = {"DBM","UI","Regression","Oracle"})
	public void TC_02_NavigationToQueryPerformanceTab() {
		qpPage.validateQueryPerformanceNavigation();
	}
	
	@Test(groups = {"DBM","UI","Regression","Oracle"})
	public void TC_03_validatingQueryThresholdTitleText() throws EncryptedDocumentException, IOException {
		qpPage.validatingQueryThresholdTitle(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.postgresSheet, "QueryPerformance_QueryThreshold"));
	}
	
	@Test(groups = {"DBM","UI","Regression","Oracle"})
	public void TC_04_validateQueryColumnTitle() throws EncryptedDocumentException, IOException {
		qpPage.validateQueryColumnTitle(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.oracleGreeshma, "QuyeryPerformance_queryColumnname"));
	}
	
	@Test(groups = {"DBM","UI","Regression","Oracle"})
	public void TC_05_validateTotalExecColumnTitle() throws EncryptedDocumentException, IOException{
		qpPage.validateTotalExeTimeColumnTitle(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.oracleGreeshma, "QuyeryPerformance_TotalExecutionColumnname"));
		
		}
	
	@Test(groups = {"DBM","UI","Regression","Oracle"})
	public void TC_06_validateTimestampColumnTitle() throws EncryptedDocumentException, IOException{
		qpPage.validateTimestampColumnTitle(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.oracleGreeshma, "QuyeryPerformance_TimestampColumnname"));
	}
	
	@Test
	public void TC_07_validateExecutionTimeColumnTitle() throws EncryptedDocumentException, IOException{
		qpPage.validateExecutionTimeColumnTitle(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.oracleGreeshma, "QuyeryPerformance_ExecutionTimeColumnname"));
	}
	
	@Test(groups = {"DBM","UI","Regression","Oracle"})
	public void TC_08_validateNodataQueryColumnValue() throws EncryptedDocumentException, IOException{
		qpPage.validateQueryColumnDataNodata(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.oracleGreeshma, "QueryPerformance_noDataText"));
		
	}
	
	@Test(groups = {"DBM","UI","Regression","Oracle"})
	public void TC_09_validateNoDataTotalExecutionColumnValue()throws EncryptedDocumentException, IOException{
		qpPage.validateTotalExeTimeColumnNoData(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.oracleGreeshma, "QueryPerformance_noDataText"));
	}
	
	@Test(groups = {"DBM","UI","Regression","Oracle"})
	public void TC_10_validateNoDataExecutionTimeColumnValue()throws EncryptedDocumentException, IOException{
		qpPage.validateExecutionTimeColumnNoData(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.oracleGreeshma, "QueryPerformance_noDataText"));
	}
	
	@Test(groups = {"DBM","UI","Regression","Oracle"})
	public void TC_11_validateNodataTimestampColumnValue()throws EncryptedDocumentException, IOException{
		qpPage.validateTimestampColumnNoData(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.oracleGreeshma, "QueryPerformance_noDataText"));
	}
	
	@Test(groups = {"DBM","UI","Regression","Oracle"})
	public void TC_12_validateDownloadReportButtonisPresent() {
		qpPage.validateDownloadReportBtnPresence();
	}
	
	@Test(groups = {"DBM","UI","Regression","Oracle"})
	public void TC_13_validatingDefaultQueryThreshold() throws EncryptedDocumentException, IOException {
		qpPage.validateDefaultQueryThresholdValue(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.oracleGreeshma, "QueryPerformanceDropdownList3"));
	}
	
	@Test(groups = {"DBM","UI","Regression","Oracle"})
	public void TC_14_selecting1msThresholdValue() throws EncryptedDocumentException, IOException{
		qpPage.selectAndvalidateQueryThresholdValue(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.oracleGreeshma, "QueryPerformanceDropdownList1"));
	}
	
	@Test(groups = {"DBM","UI","Regression","Oracle"})
	public void TC_15_selecting100msThresholdValue() throws EncryptedDocumentException, IOException{
		qpPage.selectAndvalidateQueryThresholdValue(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.oracleGreeshma, "QueryPerformanceDropdownList2"));
	}
	
	@Test
	public void TC_16_selecting200msThresholdValue() throws EncryptedDocumentException, IOException{
		qpPage.selectAndvalidateQueryThresholdValue(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.oracleGreeshma, "QueryPerformanceDropdownList3"));
	}
	
	@Test(groups = {"DBM","UI","Regression","Oracle"})
	public void TC_17_selecting500msThresholdValue() throws EncryptedDocumentException, IOException{
		qpPage.selectAndvalidateQueryThresholdValue(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.oracleGreeshma, "QueryPerformanceDropdownList4"));
	}
	
	@Test(groups = {"DBM","UI","Regression","Oracle"})
	public void TC_18_selecting1sThresholdValue() throws EncryptedDocumentException, IOException{
		qpPage.selectAndvalidateQueryThresholdValue(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.oracleGreeshma, "QueryPerformanceDropdownList5"));
	}
	
	@Test(groups = {"DBM","UI","Regression","Oracle"})
	public void TC_19_selecting3sThresholdValue() throws EncryptedDocumentException, IOException{
		qpPage.selectAndvalidateQueryThresholdValue(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.oracleGreeshma, "QueryPerformanceDropdownList6"));
	}
	
	@Test(groups = {"DBM","UI","Regression","Oracle"})
	public void TC_20_selecting5sThresholdValue() throws EncryptedDocumentException, IOException{
		qpPage.selectAndvalidateQueryThresholdValue(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.oracleGreeshma, "QueryPerformanceDropdownList7"));
	}
	
	@Test(groups = {"DBM","UI","Regression","Oracle"})
	public void TC_21_selecting10sThresholdValue() throws EncryptedDocumentException, IOException{
		qpPage.selectAndvalidateQueryThresholdValue(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.oracleGreeshma, "QueryPerformanceDropdownList8"));
	}
	
	@Test(groups = {"DBM","UI","Regression","Oracle"})
	public void TC_22_selecting20PaginationOption()throws EncryptedDocumentException, IOException{
		qpPage.selectAndValidatePaginationOptions(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.oracleGreeshma, "QueryPerformance_pagination20dropdown"));
	}
	
	@Test(groups = {"DBM","UI","Regression","Oracle"})
	public void TC_23_selecting50PaginationOption() throws EncryptedDocumentException, IOException{
		qpPage.selectAndValidatePaginationOptions(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.oracleGreeshma, "QueryPerformance_pagination50dropdown"));
	}
	
	public void TC_24_validatingDefaultPaginationSelected() throws EncryptedDocumentException, IOException {
		qpPage.validateDefaultSelectedPagination(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.oracleGreeshma, "QueryPerformance_pagination10dropdown"));
	}
	
	
	
	
}