package DBMCapability.MySql;


import org.testng.annotations.Test;

import org.testng.annotations.BeforeMethod;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;
import genericUtilities.ExcelUtility;
import genericUtilities.IPathConstant;
import objectRepository.CommonPage;
import objectRepository.HomePage;
import objectRepository.DBM.MysqlQueryPerformancePage;
import playWrightFactory.BaseClass;

public class MysqlQueryPerformanceTest extends BaseClass{
	
	HomePage homePage;
	ExcelUtility eutil = new ExcelUtility();
	MysqlQueryPerformancePage qpPage;
	CommonPage comPage;
	
	@BeforeMethod
	public void preRequest() throws EncryptedDocumentException, IOException, InterruptedException
	{
		comPage = new CommonPage(page);
	//	eutil=new ExcelUtility();
		homePage=new HomePage(page);
		qpPage=new MysqlQueryPerformancePage(page);
		Thread.sleep(5000);
		
		//Navigate to DBM capability
		comPage.navigateToDBM();
		
		//select the DBM type
		qpPage.selectDBMtype(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.mySqlNeelesh, "DBMtype"));
		
		//select the service 
		qpPage.selectDbservice(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.mySqlNeelesh, "DBMService"));
		 //Select the specific node to validate data
		 qpPage.validateSelectNodeDropDown(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.mySqlSheet,"Hostname"));
		// selecting the database option
		//qpPage.selectdatabse();
		
		//navigating to the Query performance tab
		qpPage.validateQueryPerformanceNavigation();
	}
	
	@Test
    public void TC_01_validatingQueryPerformanceTabIsPresent(){
		qpPage.validateQueryPerformanceTab();
	}
	
	@Test
	public void TC_02_NavigationToQueryPerformanceTab() {
		qpPage.validateQueryPerformanceNavigation();
	}
	
	@Test
	public void TC_03_validatingQueryThresholdTitleText() throws EncryptedDocumentException, IOException {
		qpPage.validatingQueryThresholdTitle(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.postgresSheet, "QueryPerformance_QueryThreshold"));
	}
	
	@Test
	public void TC_04_validateQueryColumnTitle() throws EncryptedDocumentException, IOException {
		qpPage.validateQueryColumnTitle(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.mySqlNeelesh, "QuyeryPerformance_queryColumnname"));
	}
	
	@Test
	public void TC_05_validateAvgColumnTitle() throws EncryptedDocumentException, IOException{
		qpPage.validateTotalExeTimeColumnTitle(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.mySqlNeelesh, "QuyeryPerformance_TotalExecutionColumnname"));
		
		}
	
	@Test
	public void TC_06_validateTimestampColumnTitle() throws EncryptedDocumentException, IOException{
		qpPage.validateTimestampColumnTitle(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.mySqlNeelesh, "QuyeryPerformance_TimestampColumnname"));
	}
	
	/*@Test
	public void TC_07_validateExecutionTimeColumnTitle() throws EncryptedDocumentException, IOException{
		qpPage.validateExecutionTimeColumnTitle(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.mySqlNeelesh, "QuyeryPerformance_ExecutionTimeColumnname"));
	}*/
	
	@Test
	public void TC_08_validateNodataQueryColumnValue() throws EncryptedDocumentException, IOException{
		qpPage.validateQueryColumnDataNodata(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.mySqlNeelesh, ""));
		
	}
	
	@Test
	public void TC_10_validateNoDataTotalExecutionColumnValue()throws EncryptedDocumentException, IOException{
		qpPage.validateTotalExeTimeColumnNoData(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.mySqlNeelesh, ""));
	}
	
	@Test
	public void TC_11_validateNoDataExecutionTimeColumnValue()throws EncryptedDocumentException, IOException{
		qpPage.validateExecutionTimeColumnNoData(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.mySqlNeelesh, ""));
	}
	
	@Test
	public void TC_12_validateNodataTimestampColumnValue()throws EncryptedDocumentException, IOException{
		qpPage.validateTimestampColumnNoData(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.mySqlNeelesh, "QueryPerformance_noDataText"));
	}
	
	@Test
	public void TC_13_validateDownloadReportButtonisPresent() {
		qpPage.validateDownloadReportBtnPresence();
	}
	
	@Test
	public void TC_14_validatingDefaultQueryThreshold() throws EncryptedDocumentException, IOException {
		qpPage.validateDefaultQueryThresholdValue(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.mySqlNeelesh, "QueryPerformanceDropdownList3"));
	}
	
	@Test
	public void TC_15_selecting1msThresholdValue() throws EncryptedDocumentException, IOException{
		qpPage.selectAndvalidateQueryThresholdValue(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.mySqlNeelesh, "QueryPerformanceDropdownList1"));
	}
	
	@Test
	public void TC_16_selecting100msThresholdValue() throws EncryptedDocumentException, IOException{
		qpPage.selectAndvalidateQueryThresholdValue(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.mySqlNeelesh, "QueryPerformanceDropdownList2"));
	}
	
	@Test
	public void TC_17_selecting200msThresholdValue() throws EncryptedDocumentException, IOException{
		qpPage.selectAndvalidateQueryThresholdValue(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.mySqlNeelesh, "QueryPerformanceDropdownList3"));
	}
	
	@Test
	public void TC_18_selecting500msThresholdValue() throws EncryptedDocumentException, IOException{
		qpPage.selectAndvalidateQueryThresholdValue(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.mySqlNeelesh, "QueryPerformanceDropdownList4"));
	}
	
	@Test
	public void TC_19_selecting1sThresholdValue() throws EncryptedDocumentException, IOException{
		qpPage.selectAndvalidateQueryThresholdValue(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.mySqlNeelesh, "QueryPerformanceDropdownList5"));
	}
	
	@Test
	public void TC_20_selecting3sThresholdValue() throws EncryptedDocumentException, IOException{
		qpPage.selectAndvalidateQueryThresholdValue(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.mySqlNeelesh, "QueryPerformanceDropdownList6"));
	}
	
	@Test
	public void TC_21_selecting5sThresholdValue() throws EncryptedDocumentException, IOException{
		qpPage.selectAndvalidateQueryThresholdValue(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.mySqlNeelesh, "QueryPerformanceDropdownList7"));
	}
	
	@Test
	public void TC_22_selecting10sThresholdValue() throws EncryptedDocumentException, IOException{
		qpPage.selectAndvalidateQueryThresholdValue(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.mySqlNeelesh, "QueryPerformanceDropdownList8"));
	}
	@Test (dataProvider = "pagination", groups = {"DBM","UI","Regression","Mysql"})
    public void TC_23_Validate_Show_Dropdown_for_value_10(String num) throws EncryptedDocumentException, IOException{
		qpPage.selectPaginationAndValidate(Integer.parseInt(num));
    }
  
	@DataProvider 
	public Object[][] pagination() throws Exception, Exception {
		return eutil.fetchAllTheDataFromExcelSheet(IPathConstant.commExcelPath, IPathConstant.commonPaginationSheet);
    }
	
	/*@Test
	public void TC_24_selecting20PaginationOption()throws EncryptedDocumentException, IOException{
		qpPage.selectAndValidatePaginationOptions(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.mySqlNeelesh, "QueryPerformance_pagination20dropdown"));
	}
	
	@Test
	public void TC_25_selecting50PaginationOption() throws EncryptedDocumentException, IOException{
		qpPage.selectAndValidatePaginationOptions(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.mySqlNeelesh, "QueryPerformance_pagination50dropdown"));
	}
	@Test
	public void TC_26_validatingDefaultPaginationSelected() throws EncryptedDocumentException, IOException {
		qpPage.validateDefaultSelectedPagination(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.mySqlNeelesh, "QueryPerformance_pagination10dropdown"));
	}*/
	
}