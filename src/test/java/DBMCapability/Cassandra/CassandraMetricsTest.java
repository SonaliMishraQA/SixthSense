package DBMCapability.Cassandra;

import genericUtilities.ExcelUtility;
import genericUtilities.IPathConstant;
import objectRepository.APM.ApmApplicationPage;
import objectRepository.DBM.CassandraHardwarePage;
import objectRepository.DBM.CassandraMetricsPage;
import objectRepository.HomePage;
import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import playWrightFactory.BaseClass;

import java.io.IOException;

public class CassandraMetricsTest extends BaseClass {


    HomePage homePage;
    ExcelUtility eutil;
    ApmApplicationPage appPage;
    CassandraMetricsPage metricsPage;



    @BeforeMethod
    public void preRequest() throws EncryptedDocumentException, IOException
    {
        eutil=new ExcelUtility();
        homePage=new HomePage(page);
      metricsPage=new CassandraMetricsPage(page);
        //Navigate to APM capability
        commPage.navigateToDBM();

        metricsPage.selectDataBaseType("Cassandra");
      //  metricsPage.selectServiceType();
      //  metricsPage.selectDataInstanceTypeDropdown();


        metricsPage.clickOnMetricsTab();
        //navigate to dashboard page//select the Time line
        commPage.selectTheTimeLineFromCalender("1 month");
    }

    @Test(groups={"DBM","Cassandra","UI","Regression"})
    public void TC_01_validateTheLoadGraphTitleTextUnderMetricsTab() throws IOException {
        System.out.println(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "Metrics_Load Graph Title label").trim());
        metricsPage.validateTheLoadGraphTitleTextUnderMetricsTab(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "Metrics_Load Graph Title label").trim());
    }

    @Test(groups={"DBM","Cassandra","UI","Regression"})
    public void TC_02_validateTheLoadGraphXaxisTitleTextUnderMetricsTab() throws IOException {
        metricsPage.validateTheLoadGraphXaxisTitleTextUnderMetricsTab(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "Metrics_Load Graph_x-axis label").trim());
    }

    @Test(groups={"DBM","Cassandra","UI","Regression"})
    public void TC_03_validateTheLoadGraphYaxisTitleTextUnderMetricsTab() throws IOException {
        metricsPage.validateTheLoadGraphYaxisTitleTextUnderMetricsTab(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "Metrics_Load Graph_y-axis label").trim());
    }

    @Test(groups={"DBM","Cassandra","UI","Regression"})
    public void TC_04_validateLoadGraphZoomIn() throws IOException {
        // System.out.print(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "Hardware_Disk Usage Card No dataText label").trim());
        metricsPage.validateLoadGraphZoomIn();
    }

    @Test(groups={"DBM","Cassandra","UI","Regression"})
    public void TC_05_validateLoadGraphZoomOut() throws IOException {
        // System.out.print(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "Hardware_Disk Usage Card No dataText label").trim());
        metricsPage.validateLoadGraphZoomOut();
    }

    @Test(groups={"DBM","Cassandra","UI","Regression"})
    public void TC_06_validateLoadGraphZoomReset() throws IOException {
        // System.out.print(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "Hardware_Disk Usage Card No dataText label").trim());
        metricsPage.validateLoadGraphZoomReset();
    }

    @Test(groups={"DBM","Cassandra","UI","Regression"})
    public void TC_07_validateTheDatabaseSizeGraphTitleTextUnderMetricsTab() throws IOException {
        metricsPage.validateTheDatabaseSizeGraphTitleTextUnderMetricsTab(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "Metrics_Database Size Graph Title label").trim());
    }

    @Test(groups={"DBM","Cassandra","UI","Regression"})
    public void TC_08_validateTheDatabaseSizeGraphXaxisTitleTextUnderMetricsTab() throws IOException {
        metricsPage.validateTheDatabaseSizeGraphXaxisTitleTextUnderMetricsTab(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "Metrics_Database Size Graph_x-axis label").trim());
    }

    @Test(groups={"DBM","Cassandra","UI","Regression"})
    public void TC_09_validateTheDatabaseSizeGraphYaxisTitleTextUnderMetricsTab() throws IOException {
        metricsPage.validateTheDatabaseSizeGraphYaxisTitleTextUnderMetricsTab(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "Metrics_Database Size Graph_y-axis label").trim());
    }

    @Test(groups={"DBM","Cassandra","UI","Regression"})
    public void TC_10_validateDataBaseSizeGraphZoomIn() throws IOException {
        // System.out.print(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "Hardware_Disk Usage Card No dataText label").trim());
        metricsPage.validateDataBaseSizeGraphZoomIn();
    }

    @Test(groups={"DBM","Cassandra","UI","Regression"})
    public void TC_11_validateDataBaseSizeGraphZoomOut() throws IOException {
        // System.out.print(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "Hardware_Disk Usage Card No dataText label").trim());
        metricsPage.validateDataBaseSizeGraphZoomOut();
    }

    @Test(groups={"DBM","Cassandra","UI","Regression"})
    public void TC_12_validateDataBaseSizeGraphZoomReset() throws IOException {
        // System.out.print(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "Hardware_Disk Usage Card No dataText label").trim());
        metricsPage.validateDataBaseSizeGraphZoomReset();
    }

    @Test(groups={"DBM","Cassandra","UI","Regression"})
    public void TC_13_validateTheSSTablePendingHintsGraphTitleTextUnderMetricsTab() throws IOException {
        metricsPage.validateTheSSTablePendingHintsGraphTitleTextUnderMetricsTab(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "Metrics_SS Table & Pending Hints Graph Title label").trim());
    }

    @Test(groups={"DBM","Cassandra","UI","Regression"})
    public void TC_14_validateTheSSTablePendingHintsGraphXaxisTitleTextUnderMetricsTab() throws IOException {
        metricsPage.validateTheSSTablePendingHintsGraphXaxisTitleTextUnderMetricsTab(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "Metrics_SS Table & Pending Hints Graph_x-axis label").trim());
    }

    @Test(groups={"DBM","Cassandra","UI","Regression"})
    public void TC_15_validateTheSSTablePendingHintsGraphYaxisTitleTextUnderMetricsTab() throws IOException {
        metricsPage.validateTheSSTablePendingHintsGraphYaxisTitleTextUnderMetricsTab(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "Metrics_SS Table & Pending Hints Graph_y-axis label").trim());
    }

    @Test(groups={"DBM","Cassandra","UI","Regression"})
    public void TC_16_validateSSTablePendingHintsGraphZoomIn() throws IOException {
        // System.out.print(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "Hardware_Disk Usage Card No dataText label").trim());
        metricsPage.validateSSTablePendingHintsGraphZoomIn();
    }

    @Test(groups={"DBM","Cassandra","UI","Regression"})
    public void TC_17_validateSSTablePendingHintsGraphZoomOut() throws IOException {
        // System.out.print(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "Hardware_Disk Usage Card No dataText label").trim());
        metricsPage.validateSSTablePendingHintsGraphZoomOut();
    }

    @Test(groups={"DBM","Cassandra","UI","Regression"})
    public void TC_18_validateSSTablePendingHintsGraphZoomReset() throws IOException {
        // System.out.print(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "Hardware_Disk Usage Card No dataText label").trim());
        metricsPage.validateSSTablePendingHintsGraphZoomReset();
    }

    @Test(groups={"DBM","Cassandra","UI","Regression"})
    public void TC_19_validateThekeyspaceCountGraphTitleTextUnderMetricsTab() throws IOException {
        metricsPage.validateThekeyspaceCountGraphTitleTextUnderMetricsTab(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "Metrics_Keyspace Count Graph Title label").trim());
    }

    @Test(groups={"DBM","Cassandra","UI","Regression"})
    public void TC_20_validateThekeyspaceCountGraphXaxisTitleTextUnderMetricsTab() throws IOException {
        metricsPage.validateThekeyspaceCountGraphXaxisTitleTextUnderMetricsTab(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "Metrics_Keyspace Count Graph_x-axis label").trim());
    }

    @Test(groups={"DBM","Cassandra","UI","Regression"})
    public void TC_21_validateThekeyspaceCountGraphYaxisTitleTextUnderMetricsTab() throws IOException {
        metricsPage.validateThekeyspaceCountGraphYaxisTitleTextUnderMetricsTab(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "Metrics_Keyspace Count Graph_y-axis label").trim());
    }

    @Test(groups={"DBM","Cassandra","UI","Regression"})
    public void TC_22_validatekeyspaceCountGraphZoomIn() throws IOException {
        // System.out.print(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "Hardware_Disk Usage Card No dataText label").trim());
        metricsPage.validatekeyspaceCountGraphZoomIn();
    }

    @Test(groups={"DBM","Cassandra","UI","Regression"})
    public void TC_23_validatekeyspaceCountGraphZoomOut() throws IOException {
        // System.out.print(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "Hardware_Disk Usage Card No dataText label").trim());
        metricsPage.validatekeyspaceCountGraphZoomOut();
    }

    @Test(groups={"DBM","Cassandra","UI","Regression"})
    public void TC_24_validatekeyspaceCountGraphZoomReset() throws IOException {
        // System.out.print(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "Hardware_Disk Usage Card No dataText label").trim());
        metricsPage.validatekeyspaceCountGraphZoomReset();
    }

    @Test(groups={"DBM","Cassandra","UI","Regression"})
    public void TC_25_validateTheLocalReadScanWriteGraphTitleTextUnderMetricsTab() throws IOException {
        metricsPage.validateTheLocalReadScanWriteGraphTitleTextUnderMetricsTab(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "Metrics_Local Read, Scan, Write Graph Title label").trim());
    }

    @Test(groups={"DBM","Cassandra","UI","Regression"})
    public void TC_26_validateTheLocalReadScanWriteGraphXaxisTitleTextUnderMetricsTab() throws IOException {
        metricsPage.validateTheLocalReadScanWriteGraphXaxisTitleTextUnderMetricsTab(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "Metrics_Local Read, Scan, Write Graph_x-axis label").trim());
    }

    @Test(groups={"DBM","Cassandra","UI","Regression"})
    public void TC_27_validateThelocalReadScanWriteGraphYaxisTitleTextUnderMetricsTab() throws IOException {
        metricsPage.validateThelocalReadScanWriteGraphYaxisTitleTextUnderMetricsTab(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "Metrics_Local Read, Scan, Write Graph_y-axis label").trim());
    }

    @Test(groups={"DBM","Cassandra","UI","Regression"})
    public void TC_28_validateLocalReadScanWriteGraphZoomIn() throws IOException {
        // System.out.print(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "Hardware_Disk Usage Card No dataText label").trim());
        metricsPage.validateLocalReadScanWriteGraphZoomIn();
    }

    @Test(groups={"DBM","Cassandra","UI","Regression"})
    public void TC_29_validateLocalReadScanWriteGraphZoomOut() throws IOException {
        // System.out.print(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "Hardware_Disk Usage Card No dataText label").trim());
        metricsPage.validateLocalReadScanWriteGraphZoomOut();
    }

    @Test(groups={"DBM","Cassandra","UI","Regression"})
    public void TC_30_validateLocalReadScanWriteGraphZoomReset() throws IOException {
        // System.out.print(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "Hardware_Disk Usage Card No dataText label").trim());
        metricsPage.validateLocalReadScanWriteGraphZoomReset();
    }

    @Test(groups={"DBM","Cassandra","UI","Regression"})
    public void TC_31_validateTheCacheGraphTitleTextUnderMetricsTab() throws IOException {
        metricsPage.validateTheCacheGraphTitleTextUnderMetricsTab(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "Metrics_Cache Graph Title label").trim());
    }

    @Test(groups={"DBM","Cassandra","UI","Regression"})
    public void TC_32_validateTheCacheGraphXaxisTitleTextUnderMetricsTab() throws IOException {
        metricsPage.validateTheCacheGraphXaxisTitleTextUnderMetricsTab(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "Metrics_Cache Graph_x-axis label").trim());
    }

    @Test(groups={"DBM","Cassandra","UI","Regression"})
    public void TC_33_validateTheCacheGraphYaxisTitleTextUnderMetricsTab() throws IOException {
        metricsPage.validateTheCacheGraphYaxisTitleTextUnderMetricsTab(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "Metrics_Cache Graph_y-axis label").trim());
    }

    @Test(groups={"DBM","Cassandra","UI","Regression"})
    public void TC_34_validateCacheGraphZoomIn() throws IOException {
        // System.out.print(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "Hardware_Disk Usage Card No dataText label").trim());
        metricsPage.validateCacheGraphZoomIn();
    }

    @Test(groups={"DBM","Cassandra","UI","Regression"})
    public void TC_35_validateCacheGraphZoomOut() throws IOException {
        // System.out.print(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "Hardware_Disk Usage Card No dataText label").trim());
        metricsPage.validateCacheGraphZoomOut();
    }

    @Test(groups={"DBM","Cassandra","UI","Regression"})
    public void TC_36_validateCacheGraphZoomReset() throws IOException {
        // System.out.print(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "Hardware_Disk Usage Card No dataText label").trim());
        metricsPage.validateCacheGraphZoomReset();
    }

    @Test(groups={"DBM","Cassandra","UI","Regression"})
    public void TC_37_validateTheCompactionGraphTitleTextUnderMetricsTab() throws IOException {
        metricsPage.validateTheCompactionGraphTitleTextUnderMetricsTab(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "Metrics_Compaction Graph Title label").trim());
    }

    @Test(groups={"DBM","Cassandra","UI","Regression"})
    public void TC_38_validateTheCompactionGraphXaxisTitleTextUnderMetricsTab() throws IOException {
        metricsPage.validateTheCompactionGraphXaxisTitleTextUnderMetricsTab(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "Metrics_Compaction Graph_x-axis label").trim());
    }

    @Test(groups={"DBM","Cassandra","UI","Regression"})
    public void TC_39_validateTheCompactionGraphYaxisTitleTextUnderMetricsTab() throws IOException {
        metricsPage.validateTheCompactionGraphYaxisTitleTextUnderMetricsTab(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "Metrics_Compaction Graph_y-axis label").trim());
    }

    @Test(groups={"DBM","Cassandra","UI","Regression"})
    public void TC_40_validateCompactionGraphZoomIn() throws IOException {
        // System.out.print(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "Hardware_Disk Usage Card No dataText label").trim());
        metricsPage.validateCompactionGraphZoomIn();
    }

    @Test(groups={"DBM","Cassandra","UI","Regression"})
    public void TC_41_validateCompactionGraphZoomOut() throws IOException {
        // System.out.print(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "Hardware_Disk Usage Card No dataText label").trim());
        metricsPage.validateCompactionGraphZoomOut();
    }

    @Test(groups={"DBM","Cassandra","UI","Regression"})
    public void TC_42_validateCompactionGraphZoomReset() throws IOException {
        // System.out.print(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "Hardware_Disk Usage Card No dataText label").trim());
        metricsPage.validateCompactionGraphZoomReset();
    }

    @Test(groups={"DBM","Cassandra","UI","Regression"})
    public void TC_43_validateLoadDragDrop() throws IOException {
        // System.out.print(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "Hardware_Disk Usage Card No dataText label").trim());
        metricsPage.validateLoadGraphDragDrop();
    }

    @Test(groups={"DBM","Cassandra","UI","Regression"})
    public void TC_44_validateThePreparedStatementsGraphTitleTextUnderMetricsTab() throws IOException {
        metricsPage.validateThePreparedStatementsGraphTitleTextUnderMetricsTab(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "Metrics_Prepared Statements Graph Title label").trim());
    }

    @Test(groups={"DBM","Cassandra","UI","Regression"})
    public void TC_45_validateThePreparedStatementsGraphXaxisTitleTextUnderMetricsTab() throws IOException {
        metricsPage.validateThePreparedStatementsGraphXaxisTitleTextUnderMetricsTab(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "Metrics_Prepared Statements Graph_x-axis label").trim());
    }

    @Test(groups={"DBM","Cassandra","UI","Regression"})
    public void TC_46_validateThePreparedStatementsGraphYaxisTitleTextUnderMetricsTab() throws IOException {
        metricsPage.validateThePreparedStatementsGraphYaxisTitleTextUnderMetricsTab(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "Metrics_Prepared Statements Graph_y-axis label").trim());
    }

    @Test(groups={"DBM","Cassandra","UI","Regression"})
    public void TC_47_validatePreparedStatementsGraphZoomIn() throws IOException {
        // System.out.print(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "Hardware_Disk Usage Card No dataText label").trim());
        metricsPage.validatePreparedStatementsGraphZoomIn();
    }

    @Test(groups={"DBM","Cassandra","UI","Regression"})
    public void TC_48_validatePreparedStatementsGraphZoomOut() throws IOException {
        // System.out.print(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "Hardware_Disk Usage Card No dataText label").trim());
        metricsPage.validatePreparedStatementsGraphZoomOut();
    }

    @Test(groups={"DBM","Cassandra","UI","Regression"})
    public void TC_49_validatePreparedStatementsGraphZoomReset() throws IOException {
        // System.out.print(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "Hardware_Disk Usage Card No dataText label").trim());
        metricsPage.validatePreparedStatementsGraphZoomReset();
    }

    @Test(groups={"DBM","Cassandra","UI","Regression"})
    public void TC_50_validatePreparedStatementsGraphDragDrop() throws IOException {
        // System.out.print(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "Hardware_Disk Usage Card No dataText label").trim());
        metricsPage.validatePreparedStatementsGraphDragDrop();
    }

    @Test(groups={"DBM","Cassandra","UI","Regression"})
    public void TC_51_validateDataBaseSizeGraphDragDrop() throws IOException {
        // System.out.print(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "Hardware_Disk Usage Card No dataText label").trim());
        metricsPage.validateDataBaseSizeGraphDragDrop();
    }

    @Test(groups={"DBM","Cassandra","UI","Regression"})
    public void TC_52_validateSSTablePendingHintsGraphDragDrop() throws IOException {
        // System.out.print(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "Hardware_Disk Usage Card No dataText label").trim());
        metricsPage.validateSSTablePendingHintsGraphDragDrop();
    }

    @Test(groups={"DBM","Cassandra","UI","Regression"})
    public void TC_53_validatekeyspaceCountGraphDragDrop() throws IOException {
        // System.out.print(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "Hardware_Disk Usage Card No dataText label").trim());
        metricsPage.validatekeyspaceCountGraphDragDrop();
    }

    @Test(groups={"DBM","Cassandra","UI","Regression"})
    public void TC_54_validateLocalReadScanWriteGraphDragDrop() throws IOException {
        // System.out.print(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "Hardware_Disk Usage Card No dataText label").trim());
        metricsPage.validateLocalReadScanWriteGraphDragDrop();
    }

    @Test(groups={"DBM","Cassandra","UI","Regression"})
    public void TC_55_validateCacheGraphDragDrop() throws IOException {
        // System.out.print(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "Hardware_Disk Usage Card No dataText label").trim());
        metricsPage.validateCacheGraphDragDrop();
    }

    @Test(groups={"DBM","Cassandra","UI","Regression"})
    public void TC_56_validateTheTaskGraphTitleTextUnderMetricsTab() throws IOException {
        metricsPage.validateTheTaskGraphTitleTextUnderMetricsTab(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "Metrics_Task Graph Title label").trim());
    }

    @Test(groups={"DBM","Cassandra","UI","Regression"})
    public void TC_57_validateTheTaskGraphXaxisTitleTextUnderMetricsTab() throws IOException {
        metricsPage.validateTheTaskGraphXaxisTitleTextUnderMetricsTab(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "Metrics_Task Graph_x-axis label").trim());
    }

    @Test(groups={"DBM","Cassandra","UI","Regression"})
    public void TC_58_validateTheTaskGraphYaxisTitleTextUnderMetricsTab() throws IOException {
        metricsPage.validateTheTaskGraphYaxisTitleTextUnderMetricsTab(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "Metrics_Task Graph_y-axis label").trim());
    }

    @Test(groups={"DBM","Cassandra","UI","Regression"})
    public void TC_59_validateTaskGraphZoomIn() throws IOException {
        // System.out.print(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "Hardware_Disk Usage Card No dataText label").trim());
        metricsPage.validateTaskGraphZoomIn();
    }

    @Test(groups={"DBM","Cassandra","UI","Regression"})
    public void TC_60_validateTaskGraphZoomOut() throws IOException {
        // System.out.print(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "Hardware_Disk Usage Card No dataText label").trim());
        metricsPage.validateTaskGraphZoomOut();
    }

    @Test(groups={"DBM","Cassandra","UI","Regression"})
    public void TC_61_validateTaskGraphZoomReset() throws IOException {
        // System.out.print(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "Hardware_Disk Usage Card No dataText label").trim());
        metricsPage.validateTaskGraphZoomReset();
    }

    @Test(groups={"DBM","Cassandra","UI","Regression"})
    public void TC_62_validateTaskGraphDragDrop() throws IOException {
        // System.out.print(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "Hardware_Disk Usage Card No dataText label").trim());
        metricsPage.validateTaskGraphDragDrop();
    }

    @Test(groups={"DBM","Cassandra","UI","Regression"})
    public void TC_63_validateTheLatencyGraphTitleTextUnderMetricsTab() throws IOException {
        metricsPage.validateTheLatencyGraphTitleTextUnderMetricsTab(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "Metrics_Latency Graph Title label").trim());
    }

    @Test(groups={"DBM","Cassandra","UI","Regression"})
    public void TC_64_validateTheLatencyGraphXaxisTitleTextUnderMetricsTab() throws IOException {
        metricsPage.validateTheLatencyGraphXaxisTitleTextUnderMetricsTab(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "Metrics_Latency Graph_x-axis label").trim());
    }

    @Test(groups={"DBM","Cassandra","UI","Regression"})
    public void TC_65_validateTheLatencyGraphYaxisTitleTextUnderMetricsTab() throws IOException {
        metricsPage.validateTheLatencyGraphYaxisTitleTextUnderMetricsTab(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "Metrics_Latency Graph_y-axis label").trim());
    }

    @Test(groups={"DBM","Cassandra","UI","Regression"})
    public void TC_66_validateLatencyGraphZoomIn() throws IOException {
        // System.out.print(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "Hardware_Disk Usage Card No dataText label").trim());
        metricsPage.validateLatencyGraphZoomIn();
    }

    @Test(groups={"DBM","Cassandra","UI","Regression"})
    public void TC_67_validateLatencyGraphZoomOut() throws IOException {
        // System.out.print(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "Hardware_Disk Usage Card No dataText label").trim());
        metricsPage.validateLatencyGraphZoomOut();
    }

    @Test(groups={"DBM","Cassandra","UI","Regression"})
    public void TC_68_validateLatencyGraphZoomReset() throws IOException {
        // System.out.print(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "Hardware_Disk Usage Card No dataText label").trim());
        metricsPage.validateLatencyGraphZoomReset();
    }

    @Test(groups={"DBM","Cassandra","UI","Regression"})
    public void TC_69_validateLatencyGraphDragDrop() throws IOException {
        // System.out.print(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "Hardware_Disk Usage Card No dataText label").trim());
        metricsPage.validateLatencyGraphDragDrop();
    }

    @Test(groups={"DBM","Cassandra","UI","Regression"})
    public void TC_70_validate_The_All_Widget_Data_By_Selecting_5Mins_TimeLine()
    {
        //select the time line from calendar
        commPage.selectTheTimeLineFromCalender(IPathConstant.fiveMinutesTimeRange);

        //Validate whether the widgets are displaying the proper time line or not
        metricsPage.validateTheGivenTimeLine();
    }
    @Test(groups={"DBM","Cassandra","UI","Regression"})
    public void TC_71_validate_The_All_Widgets_Data_By_Selecting_15Mins_TimeLine()
    {
        //select the time line from calendar
        commPage.selectTheTimeLineFromCalender(IPathConstant.fifteenMinutesTimeRange);

        //Validate whether the widgets are displaying the proper time line or not
        metricsPage.validateTheGivenTimeLine();
    }

    @Test(groups={"DBM","Cassandra","UI","Regression"})
    public void TC_72_validate_The_All_Widgets_Data_By_Selecting_30Mins_TimeLine()
    {
        //select the time line from calendar
        commPage.selectTheTimeLineFromCalender(IPathConstant.thirtyMinutesTimeRange);

        //Validate whether the widgets are displaying the proper time line or not
        metricsPage.validateTheGivenTimeLine();
    }

    @Test(groups={"DBM","Cassandra","UI","Regression"})
    public void TC_73_validate_The_All_Widgets_Data_By_Selecting_60Mins_TimeLine()
    {
        //select the time line from calendar
        commPage.selectTheTimeLineFromCalender(IPathConstant.sixtyMinutesTimeRange);

        //Validate whether the widgets are displaying the proper time line or not
        metricsPage.validateTheGivenTimeLine();
    }

    @Test(groups={"DBM","Cassandra","UI","Regression"})
    public void TC_74_validate_The_All_Widgets_Data_By_Selecting_3hours_TimeLine()
    {
        //select the time line from calendar
        commPage.selectTheTimeLineFromCalender(IPathConstant.threeHoursTimeRange);

        //Validate whether the widgets are displaying the proper time line or not
        metricsPage.validateTheGivenTimeLine();
    }

    @Test(groups={"DBM","Cassandra","UI","Regression"})
    public void TC_75_validate_The_All_Widgets_Data_By_Selecting_6hours_TimeLine()
    {
        //select the time line from calendar
        commPage.selectTheTimeLineFromCalender(IPathConstant.sixHoursTimeRange);

        //Validate whether the widgets are displaying the proper time line or not
        metricsPage.validateTheGivenTimeLine();
    }

    @Test(groups={"DBM","Cassandra","UI","Regression"})
    public void TC_76_validate_The_All_Widgets_Data_By_Selecting_12hours_TimeLine()
    {
        //select the time line from calendar
        commPage.selectTheTimeLineFromCalender(IPathConstant.twelveHoursTimeRange);

        //Validate whether the widgets are displaying the proper time line or not
        metricsPage.validateTheGivenTimeLine();
    }

    @Test(groups={"DBM","Cassandra","UI","Regression"})
    public void TC_77_validate_The_All_Widgets_Data_By_Selecting_1day_TimeLine()
    {
        //select the time line from calendar
        commPage.selectTheTimeLineFromCalender(IPathConstant.oneDayTimeRange);

        //Validate whether the widgets are displaying the proper time line or not
        metricsPage.validateTheGivenTimeLine();
    }

    @Test(groups={"DBM","Cassandra","UI","Regression"})
    public void TC_78_validate_The_All_Widgets_Data_By_Selecting_1week_TimeLine()
    {
        //select the time line from calendar
        commPage.selectTheTimeLineFromCalender(IPathConstant.oneWeekTimeRange);

        //Validate whether the widgets are displaying the proper time line or not
        metricsPage.validateTheGivenTimeLine();
    }

    @Test(groups={"DBM","Cassandra","UI","Regression"})
    public void TC_79_validate_The_All_Widgets_Data_By_Selecting_1month_TimeLine()
    {
        //select the time line from calendar
        commPage.selectTheTimeLineFromCalender(IPathConstant.oneMonthTimeRange);

        //Validate whether the widgets are displaying the proper time line or not
        metricsPage.validateTheGivenTimeLine();
    }

    @Test(groups={"DBM","Cassandra","UI","Regression"})
    public void TC_80_validate_The_All_Widgets_By_selecting_custom_Time_For_Minutes_Range() throws EncryptedDocumentException, IOException
    {
        //select the time line from calendar
        commPage.selectTheCustomeTimeLine(IPathConstant.customTimeRange, eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customMinutesRange") );

        //Validate whether the widgets are displaying the proper time line or not
        metricsPage.validateTheCustomTimeLine(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customMinutesRange"));
    }


    @Test(groups={"DBM","Cassandra","UI","Regression"})
    public void TC_81_validate_The_All_Widgets_By_selecting_custom_Time_For_Hours_Range() throws EncryptedDocumentException, IOException
    {
        //select the time line from calendar
        commPage.selectTheCustomeTimeLine(IPathConstant.customTimeRange, eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customHoursRange"));

        //Validate whether the widgets are displaying the proper time line or not
        metricsPage.validateTheCustomTimeLine(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customHoursRange"));
    }

    @Test(groups={"DBM","Cassandra","UI","Regression"})
    public void TC_82_validate_The_All_Widgets_By_selecting_custom_Time_For_Days_Range() throws EncryptedDocumentException, IOException
    {
        //select the time line from calendar
        commPage.selectTheCustomeTimeLine(IPathConstant.customTimeRange, eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customDaysRange"));

        //Validate whether the widgets are displaying the proper time line or not
        metricsPage.validateTheCustomTimeLine(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customDaysRange"));
    }

    @Test(groups={"DBM","Cassandra","UI","Regression"})
    public void TC_83_validate_The_All_Widgets_By_selecting_custom_Time_For_Future_date()
    {
        commPage.selectTheTimeLineFromCalender(IPathConstant.fiveMinutesTimeRange);

        //select the future time line from calendar
        commPage.validateTheFutureTimeLine();
    }

    @Test(groups={"DBM","Cassandra","UI","Regression"})
    public void TC_84_validatessTablePendingHintsGraphLegendsText() throws IOException {
        //select the future time line from calendar
        metricsPage.validatessTablePendingHintsGraphLegendsText(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "Metrics_SS Table & Pending Hints Legend Names").trim());
    }

    @Test(groups={"DBM","Cassandra","UI","Regression"})
    public void TC_85_validatelatencyGraphLegendsText() throws IOException {
        //select the future time line from calendar
        metricsPage.validatelatencyGraphLegendsText(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "Metrics_Latency Legend Names").trim());
    }

    @Test(groups={"DBM","Cassandra","UI","Regression"})
    public void TC_86_validatepreparedStatementsGraphLegendsText() throws IOException {
        //select the future time line from calendar
        metricsPage.validatepreparedStatementsGraphLegendsText(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "Metrics_Prepared Statements Legend Names").trim());
    }

    @Test(groups={"DBM","Cassandra","UI","Regression"})
    public void TC_87_validatetaskGraphLegendsText() throws IOException {
        //select the future time line from calendar
        metricsPage.validatetaskGraphLegendsText(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "Metrics_Task Legend Names").trim());
    }

    @Test(groups={"DBM","Cassandra","UI","Regression"})
    public void TC_88_validatelocalReadScanWriteGraphLegendsText() throws IOException {
        //select the future time line from calendar
        metricsPage.validatelocalReadScanWriteGraphLegendsText(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "Metrics_Local Read, Scan, Write Legend Names").trim());
    }

    @Test(groups={"DBM","Cassandra","UI","Regression"})
    public void TC_90_validatecacheGraphLegendsText() throws IOException {
        //select the future time line from calendar
        metricsPage.validatecacheGraphLegendsText(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "Metrics_Cache Legend Names").trim());
    }

    @Test(groups={"DBM","Cassandra","UI","Regression"})
    public void TC_91_validatecompactionGraphLegendsText() throws IOException {
        //select the future time line from calendar
        metricsPage.validatecompactionGraphLegendsText(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "Metrics_Compaction Legend Names").trim());
    }

    @Test(groups={"DBM","Cassandra","UI","Regression"})
    public void TC_92_validateTheLegendsLatencyGraph() throws IOException {
        //select the future time line from calendar
       // page.pause();
        metricsPage.validateTheLegendsLatencyGraph();
    }


    @Test(groups={"DBM","Cassandra","UI","Regression"})
    public void TC_93_validateTheLegendsPreparedStatementsGraph() throws IOException {
        //select the future time line from calendar
        // page.pause();
        metricsPage.validateTheLegendsPreparedStatementsGraph();
    }

    @Test(groups={"DBM","Cassandra","UI","Regression"})
    public void TC_94_validateTheLegendsTaskGraph() throws IOException {
        //select the future time line from calendar
        // page.pause();
        metricsPage.validateTheLegendsTaskGraph();
    }

    @Test(groups={"DBM","Cassandra","UI","Regression"})
    public void TC_95_validateTheLegendslocalReadScanWriteGraph() throws IOException {
        //select the future time line from calendar
        // page.pause();
        metricsPage.validateTheLegendslocalReadScanWriteGraph();
    }

    @Test(groups={"DBM","Cassandra","UI","Regression"})
    public void TC_96_validateTheLegendsCacheGraphLegends() throws IOException {
        //select the future time line from calendar
        // page.pause();
        metricsPage.validateTheLegendsCacheGraphLegends();
    }

    @Test(groups={"DBM","Cassandra","UI","Regression"})
    public void TC_97_validateTheLegendsCompactionGraphLegends() throws IOException {
        //select the future time line from calendar
        // page.pause();
        //page.pause();
        metricsPage.validateTheLegendsCompactionGraphLegends();
    }






}
