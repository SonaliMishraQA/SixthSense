package DBMCapability.Cassandra;

import genericUtilities.ExcelUtility;
import genericUtilities.IPathConstant;
import objectRepository.APM.ApmApplicationPage;
import objectRepository.DBM.CassandraMetricsPage;
import objectRepository.DBM.CassandraQueryPerformancePage;
import objectRepository.HomePage;
import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import playWrightFactory.BaseClass;

import java.io.IOException;

public class CassandraQueryPerformanceTest extends BaseClass {


    HomePage homePage;
    ExcelUtility eutil = new ExcelUtility();
    ApmApplicationPage appPage;
    CassandraQueryPerformancePage cassandraQueryPerformancePage;



    @BeforeMethod
    public void preRequest() throws EncryptedDocumentException, IOException
    {
        homePage=new HomePage(page);
      cassandraQueryPerformancePage=new CassandraQueryPerformancePage(page);
        //Navigate to APM capability
        commPage.navigateToDBM();

        cassandraQueryPerformancePage.selectDataBaseType("Cassandra");

        cassandraQueryPerformancePage.clickOnQueryPerformanceTab();
        //navigate to dashboard page//select the Time line
        commPage.selectTheTimeLineFromCalender("1 month");
    }

    @Test(groups={"DBM","Cassandra","UI","Regression"})
    public void TC_01_validateFirstColumnNameOfQueryPerformanceTable() throws IOException {
        cassandraQueryPerformancePage.validateFirstColumnNameOfQueryPerformanceTable(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "Query performance_Table Entries Query header Title").trim());
    }

    @Test(groups={"DBM","Cassandra","UI","Regression"})
    public void TC_02_validateSecondColumnNameOfQueryPerformanceTable() throws IOException {
        cassandraQueryPerformancePage.validateSecondColumnNameOfQueryPerformanceTable(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "Query performance_Table Entries Total execution Title").trim());
    }

    @Test(groups={"DBM","Cassandra","UI","Regression"})
    public void TC_03_validateThirdColumnNameOfQueryPerformanceTable() throws IOException {
        cassandraQueryPerformancePage.validateThirdColumnNameOfQueryPerformanceTable(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "Query performance_Table Entries Execution time Title").trim());
    }

    @Test(groups={"DBM","Cassandra","UI","Regression"})
    public void TC_04_validateFourthColumnNameOfQueryPerformanceTable() throws IOException {
        cassandraQueryPerformancePage.validateFourthColumnNameOfQueryPerformanceTable(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "Query performance_Table Entries Timestamp Title").trim());
    }

    @Test(groups={"DBM","Cassandra","UI","Regression"})
    public void TC_05_validateQueriesExecutionTimeUnder1msAsPerQueryThresholdSelection() throws IOException {
        cassandraQueryPerformancePage.querySelectionDropDownSelection(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "Query performance Query Threshold Drop down value 1ms").trim());
        cassandraQueryPerformancePage.validateQueriesExecutionTimeAsPerQuerySelectionOrNot(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "Query performance Query Threshold Drop down value 1ms").trim());
    }

    @Test(groups={"DBM","Cassandra","UI","Regression"})
    public void TC_06_validateQueriesExecutionTimeUnder100msAsPerQueryThresholdSelection() throws IOException {
        cassandraQueryPerformancePage.querySelectionDropDownSelection(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "Query performance_Query Threshold Drop down value 100ms").trim());
        cassandraQueryPerformancePage.validateQueriesExecutionTimeAsPerQuerySelectionOrNot(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "Query performance_Query Threshold Drop down value 100ms").trim());
    }

    @Test(groups={"DBM","Cassandra","UI","Regression"})
    public void TC_07_validateQueriesExecutionTimeUnder200msAsPerQueryThresholdSelection() throws IOException {
        cassandraQueryPerformancePage.querySelectionDropDownSelection(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "Query performance_Query Threshold Drop down value 200ms").trim());
        cassandraQueryPerformancePage.validateQueriesExecutionTimeAsPerQuerySelectionOrNot(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "Query performance_Query Threshold Drop down value 200ms").trim());
    }

    @Test(groups={"DBM","Cassandra","UI","Regression"})
    public void TC_08_validateQueriesExecutionTimeUnder500msAsPerQueryThresholdSelection() throws IOException {
        cassandraQueryPerformancePage.querySelectionDropDownSelection(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "Query performance_Query Threshold Drop down value 500ms").trim());
        cassandraQueryPerformancePage.validateQueriesExecutionTimeAsPerQuerySelectionOrNot(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "Query performance_Query Threshold Drop down value 500ms").trim());
    }

    @Test(groups={"DBM","Cassandra","UI","Regression"})
    public void TC_09_validateQueriesExecutionTimeUnder1sAsPerQueryThresholdSelection() throws IOException {
        cassandraQueryPerformancePage.querySelectionDropDownSelection(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "Query performance_Query Threshold Drop down value 1s").trim());
        cassandraQueryPerformancePage.validateQueriesExecutionTimeAsPerQuerySelectionOrNot(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "Query performance_Query Threshold Drop down value 1s").trim());
    }

    @Test(groups={"DBM","Cassandra","UI","Regression"})
    public void TC_10_validateQueriesExecutionTimeUnder3sAsPerQueryThresholdSelection() throws IOException {
        cassandraQueryPerformancePage.querySelectionDropDownSelection(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "Query performance_Query Threshold Drop down value 3s").trim());
        cassandraQueryPerformancePage.validateQueriesExecutionTimeAsPerQuerySelectionOrNot(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "Query performance_Query Threshold Drop down value 3s").trim());
    }

    @Test(groups={"DBM","Cassandra","UI","Regression"})
    public void TC_11_validateQueriesExecutionTimeUnder5sAsPerQueryThresholdSelection() throws IOException {
        cassandraQueryPerformancePage.querySelectionDropDownSelection(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "Query performance_Query Threshold Drop down value 5s").trim());
        cassandraQueryPerformancePage.validateQueriesExecutionTimeAsPerQuerySelectionOrNot(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "Query performance_Query Threshold Drop down value 5s").trim());
    }

    @Test(groups={"DBM","Cassandra","UI","Regression"})
    public void TC_12_validateQueriesExecutionTimeUnder10sAsPerQueryThresholdSelection() throws IOException {
        cassandraQueryPerformancePage.querySelectionDropDownSelection(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "Query performance_Query Threshold Drop down value 10s").trim());
        cassandraQueryPerformancePage.validateQueriesExecutionTimeAsPerQuerySelectionOrNot(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "Query performance_Query Threshold Drop down value 10s").trim());
    }

//    @Test
//    public void TC_13_validateNumberOfQueriesAreAsPerPaginationDropDownSelection10PerPage() throws IOException {
//        cassandraQueryPerformancePage.querySelectionDropDownSelection(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "Query performance_Query Threshold Drop down value 1ms").trim());
//
//        cassandraQueryPerformancePage.selectPaginationDropDownPerPageValue("10");
//        //cassandraQueryPerformancePage.querySelectionDropDownSelection(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "Query performance_Table Entries Timestamp Title").trim());
//        cassandraQueryPerformancePage.validateNumberOfQueriesAreAsPerPaginationDropDownSelection(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "Query performance_Pagination_DropDownValue 10 Per Page").trim());
//    }
//
//    @Test
//    public void TC_14_validateNumberOfQueriesAreAsPerPaginationDropDownSelection20PerPage() throws IOException {
//        cassandraQueryPerformancePage.querySelectionDropDownSelection(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "Query performance_Query Threshold Drop down value 1ms").trim());
//
//        cassandraQueryPerformancePage.selectPaginationDropDownPerPageValue("20");
//
//        //cassandraQueryPerformancePage.querySelectionDropDownSelection(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "Query performance_Table Entries Timestamp Title").trim());
//        cassandraQueryPerformancePage.validateNumberOfQueriesAreAsPerPaginationDropDownSelection(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "Query performance_Pagination_DropDownValue 20 Per Page").trim());
//    }
//
//    @Test
//    public void TC_15_validateNumberOfQueriesAreAsPerPaginationDropDownSelection50PerPage() throws IOException {
//        cassandraQueryPerformancePage.querySelectionDropDownSelection(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "Query performance_Query Threshold Drop down value 1ms").trim());
//
//       // cassandraQueryPerformancePage.selectPaginationDropDownPerPageValue("50");
//
//        //cassandraQueryPerformancePage.querySelectionDropDownSelection(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "Query performance_Table Entries Timestamp Title").trim());
//        cassandraQueryPerformancePage.validateNumberOfQueriesAreAsPerPaginationDropDownSelection(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "Query performance_Pagination_DropDownValue 50 Per Page").trim());
//    }

    @Test(dataProvider = "pagination",groups={"DBM","Cassandra","UI","Regression"})
    public void TC_16_validateNumberOfQueriesAreAsPerPaginationDropDownSelection50PerPage(String num) throws IOException {
   // System.out.println(num);
    System.out.println(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet,"Query performance Query Threshold Drop down value 1ms"));
        cassandraQueryPerformancePage.querySelectionDropDownSelection(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "Query_performance_Query_Threshold_Drop_down_value_1ms").trim());
        cassandraQueryPerformancePage.validateNumberOfQueriesAreAsPerPaginationDropDownSelection(Integer.parseInt(num));
    }

    @DataProvider
    public Object[][] pagination() throws Throwable
    {
        return eutil.fetchAllTheDataFromExcelSheet(IPathConstant.commExcelPath, IPathConstant.commonPaginationSheet);    }

    @Test(groups={"DBM","Cassandra","UI","Regression"})
    public void TC_17_validateDownloadButtonPresence() throws IOException {
        cassandraQueryPerformancePage.querySelectionDropDownSelection(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "Query performance_Query Threshold Drop down value 1ms").trim());
        cassandraQueryPerformancePage.validateDownloadButtonPresence();
    }

    @Test(groups={"DBM","Cassandra","UI","Regression"})
    public void TC_18_validateDownloadReportButtonFunctionality() throws IOException {
      //  cassandraQueryPerformancePage.querySelectionDropDownSelection(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "Query performance_Query Threshold Drop down value 1ms").trim());
      //  cassandraQueryPerformancePage.validateDownloadReportButtonFunctionality();
        cassandraQueryPerformancePage.validateDownloadReportButtonFunctionality();

    }




}
