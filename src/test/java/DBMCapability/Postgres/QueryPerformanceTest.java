package DBMCapability.Postgres;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.*;

import genericUtilities.ExcelUtility;
import genericUtilities.GenericMethods;
import genericUtilities.IPathConstant;
import objectRepository.CommonPage;
import objectRepository.DBM.PostgresQueryPerformancePage;
import playWrightFactory.BaseClass;

public class QueryPerformanceTest extends BaseClass {
    GenericMethods util = new GenericMethods(); 
    CommonPage compage;
    ExcelUtility eutil = new ExcelUtility();
    PostgresQueryPerformancePage pQueryPerf;

    @BeforeMethod
    public void preRequest() throws EncryptedDocumentException, IOException {
        CommonPage compage = new CommonPage(page);
        pQueryPerf = new PostgresQueryPerformancePage(page);
      //  String status = "Smoke";
      //  if(status.equals("Smokes"))
       // { 
            compage.navigateToDBM();

        //Navigate to Query Performance tab
        pQueryPerf.clickOnQueryPerformanceTab();

        //Select the specific time line in the calendar
        commPage.selectTheTimeLineFromCalender("1 month");
        pQueryPerf.selectDBMtype(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.postgresGreeshma, "DBMtype"));
		
		//select the service 
		//pQueryPerf.selectDbservice(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.postgresGreeshma, "DBMservice"));

        //Select the specific application to validate the data
        pQueryPerf.selectTheApplicationForDBM(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.postgresSheet,"Application_name"));
        pQueryPerf.validateSelectNodeDropDown(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.postgresSheet,"Hostname"));
        pQueryPerf.clickOnQueryPerformanceTab();

  //  }
        //Naviagte to DBM Capability
        
    }
    @Test (groups = {"DBM","UI","Regression","Postgres"})
    public void TC_01_ValidateQueryPerformanceTab() throws EncryptedDocumentException, IOException{

        pQueryPerf.validateQueryPerformanceTab(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.postgresSheet, "Tab_name"));
    }
    @Test (groups = {"DBM","UI","Regression","Postgres"})
    public void TC_02_Validate_no_data() throws EncryptedDocumentException, IOException{
        pQueryPerf.getNoDataText(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.postgresSheet, "QueryPerformance_noDataText"));

    }
    @Test (groups = {"DBM","UI","Regression","Postgres"})
    public void TC_03_ValidateDownloadReportButton() throws EncryptedDocumentException, IOException{
        pQueryPerf.getDownloadReportBtn(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.postgresSheet, "QueryPerformance_downloadButton"));
    }
    @Test (groups = {"DBM","UI","Regression","Postgres"})
    public void TC_04_Validate_Query_performance_table_header_column1() throws EncryptedDocumentException, IOException{
        pQueryPerf.getQueryList(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.postgresSheet, "QuyeryPerformance_queryColumnname"));
    }
    @Test (dataProvider = "pagination", groups = {"DBM","UI","Regression","Postgres"})
    public void TC_05_Validate_Show_Dropdown_for_value_10(String num) throws EncryptedDocumentException, IOException{
       pQueryPerf.selectPaginationAndValidate(Integer.parseInt(num));
    }
  
	@DataProvider 
	public Object[][] pagination() throws Exception, Exception {
		return eutil.fetchAllTheDataFromExcelSheet(IPathConstant.commExcelPath, IPathConstant.commonPaginationSheet);
    }
    @Test (groups = {"DBM","UI","Regression","Postgres"})
    public void TC_06_Validate_Refresh_Button_Availability(){
        pQueryPerf.getRefreshButton();
    }
    @Test (groups = {"DBM","UI","Regression","Postgres"})
    public void TC_07_Validate_Query_threshold_dropdown_for_1ms() throws EncryptedDocumentException, IOException{ 
        pQueryPerf.getQueryThresholdDropdown(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.postgresSheet, "QueryPerformance_1msDropdown"));
    }
    @Test (groups = {"DBM","UI","Regression","Postgres"})
    public void TC_08_Validate_Query_threshold_dropdown_for_100ms() throws EncryptedDocumentException, IOException{
        pQueryPerf.getQueryThresholdDropdown(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.postgresSheet, "QueryPerformance_100msDropdown"));
    }
    @Test (groups = {"DBM","UI","Regression","Postgres"})
    public void TC_09_Validate_Query_threshold_dropdown_for_200ms() throws EncryptedDocumentException, IOException{
        pQueryPerf.getQueryThresholdDropdown(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.postgresSheet, "QueryPerformance_200msDropdown"));
    }
    @Test (groups = {"DBM","UI","Regression","Postgres"})
    public void TC_10_Validate_Query_threshold_dropdown_for_500ms() throws EncryptedDocumentException, IOException{
        pQueryPerf.getQueryThresholdDropdown(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.postgresSheet, "QueryPerformance_500msDropdown"));
    }
    @Test (groups = {"DBM","UI","Regression","Postgres"})
    public void TC_11_Validate_Query_threshold_dropdown_for_1s() throws EncryptedDocumentException, IOException{
        pQueryPerf.getQueryThresholdDropdown(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.postgresSheet, "QueryPerformance_1sDropdown"));
    }
    @Test (groups = {"DBM","UI","Regression","Postgres"})
    public void TC_12_Validate_Query_threshold_dropdown_for_3s() throws EncryptedDocumentException, IOException{
        pQueryPerf.getQueryThresholdDropdown(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.postgresSheet, "QueryPerformance_3sDropdown"));
    }
    @Test (groups = {"DBM","UI","Regression","Postgres"})
    public void TC_13_Validate_Query_threshold_dropdown_for_5s() throws EncryptedDocumentException, IOException{
        pQueryPerf.getQueryThresholdDropdown(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.postgresSheet, "QueryPerformance_5sDropdown"));
    }
    @Test (groups = {"DBM","UI","Regression","Postgres"})
    public void TC_14_Validate_Query_threshold_dropdown_for_10s() throws EncryptedDocumentException, IOException{
        pQueryPerf.getQueryThresholdDropdown(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.postgresSheet, "QueryPerformance_10sDropdown"));
    }
    @Test (groups = {"DBM","UI","Regression","Postgres"})
    public void TC_15_Validate_Download_Success_Message() throws EncryptedDocumentException, IOException{
        pQueryPerf.getDownloadSuccessMsg(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.postgresSheet, "QueryPerformance_SuccessMessage"));   
    }
    @Test (groups = {"DBM","UI","Regression","Postgres"})
    public void TC_16_Validate_Query_performance_table_header_column2() throws EncryptedDocumentException, IOException{
        pQueryPerf.getTotalExcutionList(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.postgresSheet, "QuyeryPerformance_TotalExecutionColumnname"));
    }
    @Test (groups = {"DBM","UI","Regression","Postgres"})
    public void TC_17_Validate_Query_performance_table_header_column3() throws EncryptedDocumentException, IOException{
        pQueryPerf.getExecutionTimeList(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.postgresSheet, "QuyeryPerformance_ExecutionTimeColumnname"));
    }
    @Test (groups = {"DBM","UI","Regression","Postgres"})
    public void TC_18_Validate_Query_performance_table_header_column4() throws EncryptedDocumentException, IOException{
        pQueryPerf.getTimeStampList(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.postgresSheet, "QuyeryPerformance_TimestampColumnname"));
    }
    
    
}
