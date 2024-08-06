package DBMCapability.MySql;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.*;

import genericUtilities.ExcelUtility;
import genericUtilities.GenericMethods;
import genericUtilities.IPathConstant;
import objectRepository.CommonPage;
import objectRepository.DBM.MysqlMetricsPage;
import playWrightFactory.BaseClass;

public class MetricsTest extends BaseClass {
    GenericMethods util = new GenericMethods(); 
    MysqlMetricsPage metricsPage;
    CommonPage compage;
    ExcelUtility eutil = new ExcelUtility();

    @BeforeMethod
    public void preRequest() throws EncryptedDocumentException, IOException {
      
     /* compage = new CommonPage(page);
        metricsPage = new MysqlMetricsPage(page);
        //Naviagte to DBM Capability
        compage.navigateToDBM();
        //Select the specific time line in the calendar
        commPage.selectTheTimeLineFromCalender("1 month");
        //Select the specific application to validate the data
        metricsPage.selectTheApplicationForAPM("staging-mysql");
        //Select the specific node to validate data
        metricsPage.validateSelectNodeDropDown("localhost");
        //Navigate to Metrics tab
        metricsPage.validateMetricsTab();
         */
    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_001_ValidateInnoDBBufferPoolPageDataChart() throws EncryptedDocumentException, IOException{
        compage = new CommonPage(page);
        metricsPage = new MysqlMetricsPage(page);
        //Naviagte to DBM Capability
        compage.navigateToDBM();
        //Select the specific time line in the calendar
        commPage.selectTheTimeLineFromCalender("1 month");
        //Select the specific application to validate the data
        metricsPage.selectTheApplicationForAPM(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.mySqlSheet,"Application_name"));
        //Select the specific node to validate data
        metricsPage.validateSelectNodeDropDown(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.mySqlSheet,"Hostname"));

        //Navigate to Metrics tab
        metricsPage.validateMetricsTab();
    
        metricsPage.getInnoDBBufferPoolPagesDataWidvalidateTitle(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.mySqlSheet, "Metrics_Inno_DB_buffer_pool_pages_data"));
    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_002_ValidateInnoDBBufferPoolPageDataChartXaxis() throws EncryptedDocumentException, IOException{
        metricsPage.getInnoDBBufferPoolPagesDataXaxisTitle(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.mySqlSheet, "Metrics_allXaxes"));

    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_003_ValidateInnoDBBufferPoolPageDataChartYaxis() throws EncryptedDocumentException, IOException{
        metricsPage.getInnoDBBufferPoolPagesDataYaxisTitle(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.mySqlSheet, "Metrics_Inno_DB_buffer_pool_pages_data_Yaxis"));
    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_004_ValidateInnoDBBufferPoolPageDataChartZoomInButton() throws EncryptedDocumentException, IOException{
        metricsPage.getInnoDBBufferPoolPagesDataZoomInBtn();
    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_005_ValidateInnoDBBufferPoolPageDataChartZoomOutButton(){
        metricsPage.getInnoDBBufferPoolPagesDataZoomOutBtn();

    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_006_ValidateInnoDBBufferPoolPageDataChartZoomResetButton(){
        metricsPage.getInnoDBBufferPoolPagesDataResetBtn();
    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_007_ValidateInnoDBBufferPoolPageDataExpandTimelineChart(){
       metricsPage.InnoDBBufferPoolPageDataExpandTimelineChart();
    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_008_ValidateInnoDBBufferPoolPageFreeChart() throws EncryptedDocumentException, IOException{
        metricsPage.getInnoDBBufferPoolPagesFreeTitle(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.mySqlSheet, "Metrics_Inno_DB_buffer_pool_pages_free"));
    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_009_TC_008_ValidateInnoDBBufferPoolPageFreeChartXaxis() throws EncryptedDocumentException, IOException{ 
        metricsPage.getInnoDBBufferPoolPageFreeChartXaxisTitle(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.mySqlSheet, "Metrics_allXaxes"));
    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_010_ValidateInnoDBBufferPoolPageFreeChartYaxis() throws EncryptedDocumentException, IOException{
        metricsPage.getInnoDBBufferPoolPageFreeChartYaxisTitle(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.mySqlSheet, "Metrics_Inno_DB_buffer_pool_pages_free_Yaxis"));
    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_011_ValidateInnoDBBufferPoolPageFreeChartZoomInButton() throws EncryptedDocumentException, IOException{
        metricsPage.getInnoDBBufferPoolPageFreeChartZoomInButton();
    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_012_ValidateInnoDBBufferPoolPageFreeChartZoomOutButton() throws EncryptedDocumentException, IOException{
        metricsPage.getInnoDBBufferPoolPageFreeChartZoomOutButton();
    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_013_ValidateInnoDBBufferPoolPageFreeChartZoomResetButton() throws EncryptedDocumentException, IOException{
        metricsPage.getInnoDBBufferPoolPageFreeChartZoomResetButton();
    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_014_ValidateInnoDBBufferPoolPageFreeExpandTimelineChart() throws EncryptedDocumentException, IOException{
        metricsPage.getInnoDBBufferPoolPageFreeExpandTimelineChart();
    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_015_ValidateInnoDBRowLockCurrentWaitsChart() throws EncryptedDocumentException, IOException{
        metricsPage.getInnoDBRowLockCurrentWaitsChartTitle(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.mySqlSheet, "Metrics_Inno_DB_row_lock_current_waits"));
    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_016_ValidateInnoDBRowLockCurrentWaitsChartXaxis() throws EncryptedDocumentException, IOException{
        metricsPage.getInnoDBRowLockCurrentWaitsChartXaxisTitle(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.mySqlSheet, "Metrics_allXaxes"));
    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_017_ValidateInnoDBRowLockCurrentWaitsChartYaxis() throws EncryptedDocumentException, IOException{
        metricsPage.getInnoDBRowLockCurrentWaitsChartYaxisTitle(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.mySqlSheet, "Metrics_Inno_DB_row_lock_current_waits_Yaxis"));   
    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_018_ValidateInnoDBRowLockCurrentWaitsChartZoomInButton() throws EncryptedDocumentException, IOException{
        metricsPage.getInnoDBRowLockCurrentWaitsChartZoomInButton();
    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_019_ValidateInnoDBRowLockCurrentWaitsChartZoomOutButton() throws EncryptedDocumentException, IOException{
        metricsPage.getInnoDBRowLockCurrentWaitsChartZoomOutButton();
    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_020_ValidateInnoDBRowLockCurrentWaitsChartZoomResetButton() throws EncryptedDocumentException, IOException{
        metricsPage.getInnoDBRowLockCurrentWaitsChartZoomResetButton();
    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_021_ValidateInnoDBRowLockCurrentWaitsExpandTimelineChart() throws EncryptedDocumentException, IOException{
      metricsPage.getInnoDBRowLockCurrentWaitsExpandTimelineChart();
    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_022_ValidateInnoDBRowLockTimeAverageChart() throws EncryptedDocumentException, IOException{
        metricsPage.getInnoDBRowLockTimeAverageChartTitle(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.mySqlSheet, "Metrics_Inno_DB_row_lock_time_average"));

    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_023_TC_022_ValidateInnoDBRowLockTimeAverageChartXaxis() throws EncryptedDocumentException, IOException{
        metricsPage.getInnoDBRowLockTimeAverageChartXaxis(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.mySqlSheet, "Metrics_allXaxes"));
    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_024_ValidateInnoDBRowLockTimeAverageChartYaxis() throws EncryptedDocumentException, IOException{
        metricsPage.getInnoDBRowLockTimeAverageChartYaxis(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.mySqlSheet, "Metrics_Inno_DB_row_lock_time_average_Yaxis"));
    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_025_ValidateInnoDBRowLockTimeAverageChartZoomInButton(){
        metricsPage.getInnoDBRowLockTimeAverageChartZoomInButton();

    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_026_ValidateInnoDBRowLockTimeAverageChartZoomOutButton(){
        metricsPage.getInnoDBRowLockTimeAverageChartZoomOutButton();
    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_027_ValidateInnoDBRowLockTimeAverageChartZoomResetButton(){
        metricsPage.getInnoDBRowLockTimeAverageChartZoomResetButton();
    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_028_ValidateInnoDBRowLockTimeAverageExpandTimelineChart(){
       metricsPage.getInnoDBRowLockTimeAverageExpandTimelineChart();
    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_029_ValidateInnoDBRowLockWaitsPerSecChart() throws EncryptedDocumentException, IOException{ 
        metricsPage.getInnoDBRowLockWaitsPerSecChartTitle(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.mySqlSheet, "Metrics_Inno_DB_row_lock_waits_per_second"));
    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_030_ValidateInnoDBRowLockWaitsPerSecChartXaxis() throws EncryptedDocumentException, IOException{
        metricsPage.getInnoDBRowLockWaitsPerSecChartXaxis(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.mySqlSheet, "Metrics_allXaxes"));
    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_031_ValidateInnoDBRowLockWaitsPerSecCharYaxis() throws EncryptedDocumentException, IOException{
        metricsPage.getInnoDBRowLockWaitsPerSecChartYaxis(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.mySqlSheet, "Metrics_Inno_DB_row_lock_waits_per_second_Yaxis"));
    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_032_ValidateInnoDBRowLockWaitsPerSecChartZoomInButton() throws EncryptedDocumentException, IOException{
        metricsPage.getInnoDBRowLockWaitsPerSecChartZoomInButton();
    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_033_ValidateInnoDBRowLockWaitsPerSecChartZoomOutButton() throws EncryptedDocumentException, IOException{
        metricsPage.getInnoDBRowLockWaitsPerSecChartZoomOutButton();
    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_034_ValidateInnoDBRowLockWaitsPerSecChartZoomResetButton() throws EncryptedDocumentException, IOException{
        metricsPage.getInnoDBRowLockWaitsPerSecChartZoomResetButton();
    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_035_ValidateInnoDBRowLockWaitsPerSecExpandTimeLineChart() throws EncryptedDocumentException, IOException{
        metricsPage.getInnoDBRowLockWaitsPerSecExpandTimeLineChart();
    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_036_ValidateInnoDBRowLockWaitsChart() throws EncryptedDocumentException, IOException{
        metricsPage.getInnoDBRowLockWaitsChartTitle(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.mySqlSheet, "Metrics_Inno_DB_row_lock_waits"));
    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_037_ValidateInnoDBRowLockWaitsChartXaxis() throws EncryptedDocumentException, IOException{
        metricsPage.getInnoDBRowLockWaitsChartXaxisTitle(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.mySqlSheet, "Metrics_allXaxes"));   
    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_038_ValidateInnoDBRowLockWaitsChartYaxis() throws EncryptedDocumentException, IOException{
        metricsPage.InnoDBRowLockWaitsChartYaxis(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.mySqlSheet, "Metrics_Inno_DB_row_lock_waits_Yaxis"));
    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_039_ValidateInnoDBRowLockWaitsChartZoomInButton() throws EncryptedDocumentException, IOException{
        metricsPage.InnoDBRowLockWaitsChartZoomInButton();
    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_040_ValidateInnoDBRowLockWaitsChartZoomOutButton() throws EncryptedDocumentException, IOException{
        metricsPage.InnoDBRowLockWaitsChartZoomOutButton();
    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_041_ValidateInnoDBRowLockWaitsChartZoomResetButton() throws EncryptedDocumentException, IOException{
        metricsPage.InnoDBRowLockWaitsChartZoomResetButton();
    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_042_ValidateInnoDBRowLockWaitsExpandTimeLineChart() throws EncryptedDocumentException, IOException{
        metricsPage.getInnoDBRowLockWaitsExpandTimeLineChart();

    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_043_ValidateTotalOpenFilesChart() throws EncryptedDocumentException, IOException{
        metricsPage.getTotalOpenFilesChartTitle(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.mySqlSheet, "Metrics_Total_open_files"));
    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_044_ValidateTotalOpenFilesChartXaxis() throws EncryptedDocumentException, IOException{
        metricsPage.getTotalOpenFilesChartXaxisTitle(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.mySqlSheet, "Metrics_allXaxes"));
    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_045_ValidateTotalOpenFilesChartYaxis() throws EncryptedDocumentException, IOException{
        metricsPage.getTotalOpenFilesChartYaxisTitle(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.mySqlSheet, "Metrics_Total_open_files_Yaxis"));

    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_046_ValidateTotalOpenFilesChartZoomInButton(){
        metricsPage.getTotalOpenFilesChartZoomInButton();
    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_047_ValidateTotalOpenFilesChartZoomOutButton(){
        metricsPage.getTotalOpenFilesChartZoomOutButton();
    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_048_ValidateTotalOpenFilesChartZoomResetButton(){
        metricsPage.getTotalOpenFilesChartZoomResetButton();
    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_049_ValidateTotalOpenFilesExpandTimeLineChart() throws EncryptedDocumentException, IOException{ 
       metricsPage.getTotalOpenFilesExpandTimeLineChart();
    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_050_ValidateTotalOpenTablesChart() throws EncryptedDocumentException, IOException{
        metricsPage.getTotalOpenTablesChartTitle(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.mySqlSheet, "Metrics_Total_open_tables"));
    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_051_ValidateTotalOpenTablesChartXaxis() throws EncryptedDocumentException, IOException{
        metricsPage.getTotalOpenTablesChartXaxis(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.mySqlSheet, "Metrics_allXaxes"));
    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_052_ValidateTotalOpenTablesChartYaxis() throws EncryptedDocumentException, IOException{
        metricsPage.getTotalOpenTablesChartYaxis(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.mySqlSheet, "Metrics_Total_open_tables_Yaxis"));
    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_053_ValidateTotalOpenTablesChartZoomInButton() throws EncryptedDocumentException, IOException{
        metricsPage.getTotalOpenTablesChartZoomInButton();
    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_054_ValidateTotalOpenTablesChartZoomOutButton() throws EncryptedDocumentException, IOException{
        metricsPage.getTotalOpenTablesChartZoomOutButton();
    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_055_ValidateTotalOpenTablesChartZoomResetButton() throws EncryptedDocumentException, IOException{
        metricsPage.getTotalOpenTablesChartZoomResetButton();
    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_056_ValidateTotalOpenTablesExpandTimeLineChart() throws EncryptedDocumentException, IOException{
       metricsPage.getTotalOpenTablesExpandTimeLineChart();
    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_057_ValidateMaxUsedConnectionsChart() throws EncryptedDocumentException, IOException{
        metricsPage.getMaxUsedConnectionsChartTitle(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.mySqlSheet, "Metrics_Max_used_connections"));   
    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_058_ValidateMaxUsedConnectionsChartXaxis() throws EncryptedDocumentException, IOException{
        metricsPage.getMaxUsedConnectionsChartXaxisTitle(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.mySqlSheet, "Metrics_allXaxes"));
    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_059_ValidateMaxUsedConnectionsChartYaxis() throws EncryptedDocumentException, IOException{
        metricsPage.getMaxUsedConnectionsChartYaxisTitle(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.mySqlSheet, "Metrics_Max_used_connections_Yaxis"));
    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_060_ValidateMaxUsedConnectionsChartZoomInButton() throws EncryptedDocumentException, IOException{
        metricsPage.getMaxUsedConnectionsChartZoomInButton();
    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_061_ValidateMaxUsedConnectionsChartZoomOutButton() throws EncryptedDocumentException, IOException{
        metricsPage.getMaxUsedConnectionsChartZoomOutButton();
    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_062_ValidateMaxUsedConnectionsChartZoomResteButton() throws EncryptedDocumentException, IOException{
        metricsPage.getMaxUsedConnectionsChartZoomResetButton();

    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_063_ValidateMaxUsedConnectionsExpandTimeLineChart() throws EncryptedDocumentException, IOException{
      metricsPage.getMaxUsedConnectionsExpandTimeLineChart();
    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_064_ValidateNetConnectionErrorPerSecChart() throws EncryptedDocumentException, IOException{
        metricsPage.getNetConnectionErrorPerSecChartTitle(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.mySqlSheet, "Metrics_Net_connection_errors_per_second"));
    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_065_ValidateNetConnectionErrorPerSecChartXaxis() throws EncryptedDocumentException, IOException{
        metricsPage.getNetConnectionErrorPerSecChartXaxisTitle(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.mySqlSheet, "Metrics_allXaxes"));

    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_066_ValidateNetConnectionErrorPerSecChartYaxis() throws EncryptedDocumentException, IOException{
        metricsPage.getNetConnectionErrorPerSecChartYaxisTitle(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.mySqlSheet, "Metrics_Net_connection_errors_per_second_Yaxis"));
    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_067_ValidateNetConnectionErrorPerSecChartZoomInButton(){
        metricsPage.getNetConnectionErrorPerSecChartZoomInButton();
    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_068_ValidateNetConnectionErrorPerSecChartZoomOutButton(){
        metricsPage.getNetConnectionErrorPerSecChartZoomButton();
    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_069_ValidateNetConnectionErrorPerSecChartZoomResetButton() throws EncryptedDocumentException, IOException{ 
        metricsPage.getNetConnectionErrorPerSecChartZoomResetButton();
    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_070_ValidateNetConnectionErrorPerSecExpandTimeLineChart() throws EncryptedDocumentException, IOException{
      metricsPage.getNetConnectionErrorPerSecExpandTimeLineChart();
    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_071_ValidateNetConnectionErrorsChart() throws EncryptedDocumentException, IOException{
        metricsPage.getNetConnectionErrorsChartTitle(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.mySqlSheet, "Metrics_Net_connection_errors"));
    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_072_ValidateNetConnectionErrorsChartXaxis() throws EncryptedDocumentException, IOException{
        metricsPage.getNetConnectionErrorsChartXaxis(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.mySqlSheet, "Metrics_allXaxes"));
    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_073_ValidateNetConnectionErrorsChartYaxis() throws EncryptedDocumentException, IOException{
        metricsPage.getNetConnectionErrorsChartYaxisTitle(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.mySqlSheet, "Metrics_Net_connection_errors_Yaxis"));
    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_074_ValidateNetConnectionErrorsChartZoomInButton() throws EncryptedDocumentException, IOException{
        metricsPage.getNetConnectionErrorsChartZoomInButton();
    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_075_ValidateNetConnectionErrorsChartZoomOutButton() throws EncryptedDocumentException, IOException{
        metricsPage.getNetConnectionErrorsChartZoomOutButton();
    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_076_ValidateNetConnectionErrorsChartZoomResetButton() throws EncryptedDocumentException, IOException{
        metricsPage.getNetConnectionErrorsChartZoomResetButton();
    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_077_ValidateNetConnectionErrorsExpandTimeLineChart() throws EncryptedDocumentException, IOException{
      metricsPage.getNetConnectionErrorsExpandTimeLineChart();
    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_078_ValidateSelectQueriesCountChart() throws EncryptedDocumentException, IOException{
        metricsPage.getSelectQueriesCountChartTitle(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.mySqlSheet, "Metrics_Select_queries_count"));
    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_079_ValidateSelectQueriesCountChartXaxis() throws EncryptedDocumentException, IOException{
        metricsPage.getSelectQueriesCountChartXaxis(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.mySqlSheet, "Metrics_allXaxes"));
    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_080_ValidateSelectQueriesCountChartYaxis() throws EncryptedDocumentException, IOException{
        metricsPage.getSelectQueriesCountChartYaxisTitle(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.mySqlSheet, "Metrics_Select_queries_count_Yaxis"));
    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_081_ValidateSelectQueriesCountChartZoomInButton() throws EncryptedDocumentException, IOException{
        metricsPage.getSelectQueriesCountChartZoomInButton();
    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_082_ValidateSelectQueriesCountChartZoomOutButton() throws EncryptedDocumentException, IOException{
        metricsPage.getSelectQueriesCountChartZoomOutButton();

    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_083_ValidateSelectQueriesCountChartZoomResetButton() throws EncryptedDocumentException, IOException{
        metricsPage.getSelectQueriesCountChartZoomResetButton();
    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_084_ValidateSelectQueriesCountExpandTimeLineChart() throws EncryptedDocumentException, IOException{
       metricsPage.getSelectQueriesCountExpandTimeLineChart();
    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_085_ValidateInsertQueriesCountChart() throws EncryptedDocumentException, IOException{
        metricsPage.getInsertQueriesCountChartTitle(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.mySqlSheet, "Metrics_Insert_queries_count"));

    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_086_ValidateInsertQueriesCountChartXaxis() throws EncryptedDocumentException, IOException{
        metricsPage.getInsertQueriesCountChartXaxisTitle(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.mySqlSheet, "Metrics_allXaxes"));
    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_087_ValidateInsertQueriesCountChartYaxis() throws EncryptedDocumentException, IOException{
        metricsPage.getInsertQueriesCountChartYaxisTitle(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.mySqlSheet, "Metrics_Insert_queries_count_Yaxis"));
    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_088_ValidateInsertQueriesCountChartZoomInButton(){
        metricsPage.getInsertQueriesCountChartZoomInButton();
    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_089_ValidateInsertQueriesCountChartZoomOutButton() throws EncryptedDocumentException, IOException{ 
        metricsPage.getInsertQueriesCountChartZoomOutButton();
    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_090_ValidateInsertQueriesCountChartZoomResetButton() throws EncryptedDocumentException, IOException{
        metricsPage.getInsertQueriesCountChartZoomResetButton();
    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_091_ValidateInsertQueriesCountExpandTimeLineChart() throws EncryptedDocumentException, IOException{
      metricsPage.getInsertQueriesCountExpandTimeLineChart();
    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_092_ValidateSelectQueriesPerSecChart() throws EncryptedDocumentException, IOException{
        metricsPage.getSelectQueriesPerSecChartTitle(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.mySqlSheet, "Metrics_Select_queries_per_second"));
    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_093_ValidateSelectQueriesPerSecChartXaxis() throws EncryptedDocumentException, IOException{
        metricsPage.getSelectQueriesPerSecChartXaxisTitle(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.mySqlSheet, "Metrics_allXaxes"));
    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_094_ValidateSelectQueriesPerSecChartYaxis() throws EncryptedDocumentException, IOException{
        metricsPage.getSelectQueriesPerSecChartYaxisTitle(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.mySqlSheet, "Metrics_Select_queries_per_second_Yaxis"));
    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_095_ValidateSelectQueriesPerSecChartZoomInButton() throws EncryptedDocumentException, IOException{
        metricsPage.getSelectQueriesPerSecChartZoomInButton();
    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_096_ValidateSelectQueriesPerSecChartZoomOutButtton() throws EncryptedDocumentException, IOException{
        metricsPage.getSelectQueriesPerSecChartZoomOutButton();
    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_097_ValidateSelectQueriesPerSecChartZoomResetButton() throws EncryptedDocumentException, IOException{
        metricsPage.getSelectQueriesPerSecChartZoomResetButton();   
    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_098_ValidateSelectQueriesPerSecExpandTimeLineChart() throws EncryptedDocumentException, IOException{
      metricsPage.getSelectQueriesPerSecExpandTimeLineChart();
    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_099_ValidateInsertQueriesPerSecChart() throws EncryptedDocumentException, IOException{
        metricsPage.getInsertQueriesPerSecChartTitle(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.mySqlSheet, "Metrics_Insert_queries_per_second"));
    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_100_ValidateInsertQueriesPerSecChartXaxis() throws EncryptedDocumentException, IOException{
        metricsPage.getInsertQueriesPerSecChartXaxisTitle(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.mySqlSheet, "Metrics_allXaxes"));
    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_101_ValidateInsertQueriesPerSecChartYaxis() throws EncryptedDocumentException, IOException{
        metricsPage.getInsertQueriesPerSecChartYaxisTitle(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.mySqlSheet, "Metrics_Insert_queries_per_second_Yaxis"));
    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_102_ValidateInsertQueriesPerSecChartZoomInButton() throws EncryptedDocumentException, IOException{
        metricsPage.getInsertQueriesPerSecChartZoomInButton();

    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_103_ValidateInsertQueriesPerSecChartZoomOutButton() throws EncryptedDocumentException, IOException{
        metricsPage.getInsertQueriesPerSecChartZoomOutButton();
    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_104_ValidateInsertQueriesPerSecChartZoomResetButton() throws EncryptedDocumentException, IOException{
        metricsPage.getInsertQueriesPerSecChartZoomResetButton();
    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_105_ValidateInsertQueriesPerSecExpandTimeLineChart(){
       metricsPage.getInsertQueriesPerSecExpandTimeLineChart();

    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_106_ValidateSlowQueriesPerSecChart() throws EncryptedDocumentException, IOException{
        metricsPage.getSlowQueriesPerSecChartTitle(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.mySqlSheet, "Metrics_Slow_queries_per_second"));
    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_107_ValidateSlowQueriesPerSecChartXaxis() throws EncryptedDocumentException, IOException{
        metricsPage.getSlowQueriesPerSecChartXaxisTitle(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.mySqlSheet, "Metrics_allXaxes"));
    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_108_ValidateSlowQueriesPerSecChartYaxis() throws EncryptedDocumentException, IOException{
        metricsPage.getSlowQueriesPerSecChartYaxisTitle(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.mySqlSheet, "Metrics_Slow_queries_per_second_Yaxis"));
    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_109_ValidateSlowQueriesPerSecChartZoomInButton() throws EncryptedDocumentException, IOException{ 
        metricsPage.getSlowQueriesPerSecChartZoomInButton();
    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_110_ValidateSlowQueriesPerSecChartZoomOutButton() throws EncryptedDocumentException, IOException{
        metricsPage.getSlowQueriesPerSecChartZoomOutButton();
    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_111_ValidateSlowQueriesPerSecChartZoomResetButton() throws EncryptedDocumentException, IOException{
        metricsPage.getSlowQueriesPerSecChartZoomResetButton();
    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_112_ValidateSlowQueriesPerSecExpandTimeLineChart() throws EncryptedDocumentException, IOException{
      metricsPage.getSlowQueriesPerSecExpandTimeLineChart();
    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_113_ValidateSlowQueriesCountChart() throws EncryptedDocumentException, IOException{
        metricsPage.getSLowQueriesCountTitle(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.mySqlSheet, "Metrics_Slow_queries_count"));
    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_114_ValidateSlowQueriesCountChartXaxis() throws EncryptedDocumentException, IOException{
        metricsPage.getSLowQueriesCountXaxisTitle(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.mySqlSheet, "Metrics_allXaxes"));
    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_115_ValidateSlowQueriesCountChartYaxis() throws EncryptedDocumentException, IOException{
        metricsPage.getSLowQueriesCountYaxisTitle(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.mySqlSheet, "Metrics_Slow_queries_count_Yaxis"));
    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_116_ValidateSlowQueriesCountChartZoomInButton() throws EncryptedDocumentException, IOException{
        metricsPage.getSLowQueriesCountZoomInButton();
    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_117_ValidateSlowQueriesCountChartZoomOutButton() throws EncryptedDocumentException, IOException{
        metricsPage.getSLowQueriesCountZoomOutButton();   
    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_118_ValidateSlowQueriesCountChartZoomResetButton() throws EncryptedDocumentException, IOException{
        metricsPage.getSLowQueriesCountZoomResetButton();
    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_119_ValidateSlowQueriesCountExpandTimeLineChart() throws EncryptedDocumentException, IOException{
       metricsPage.getSlowQueriesCountExpandTimeLineChart();
    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_120_ValidateQueriesCountChart() throws EncryptedDocumentException, IOException{
        metricsPage.getQueriesCountChartTitle(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.mySqlSheet, "Metrics_Queries_count"));
    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_121_ValidateQueriesCountChartXaxis() throws EncryptedDocumentException, IOException{
        metricsPage.getQueriesCountChartXaxisTitle(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.mySqlSheet, "Metrics_allXaxes"));
    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_122_ValidateQueriesCountChartYaxis() throws EncryptedDocumentException, IOException{
        metricsPage.getQueriesCountChartYaxisTitle(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.mySqlSheet, "Metrics_Queries_count_Yaxis"));

    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_123_ValidateQueriesCountChartZoomInButton() throws EncryptedDocumentException, IOException{
        metricsPage.getQueriesCountChartZoomInButton();
    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_124_ValidateQueriesCountChartZoomOutButton() throws EncryptedDocumentException, IOException{
        metricsPage.getQueriesCountChartZoomOutButton();
    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_125_ValidateQueriesCountChartZoomResetButton(){
        metricsPage.getQueriesCountChartZoomResetButton();

    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_126_ValidateQueriesCountExpandTimeLineChart(){
        metricsPage.getQueriesCountExpandTimeLineChart();
    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_127_ValidateQueriesPerSecChart() throws EncryptedDocumentException, IOException{
        metricsPage.getQueriesPerSecChartTitle(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.mySqlSheet, "Metrics_Queries_per_second"));
    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_128_ValidateQueriesPerSecChartXaxis() throws EncryptedDocumentException, IOException{
        metricsPage.getQueriesPerSecChartXaxisTitle(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.mySqlSheet, "Metrics_allXaxes"));
    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_129_ValidateQueriesPerSecChartYaxis() throws EncryptedDocumentException, IOException{ 
        metricsPage.getQueriesPerSecChartYaxisTitle(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.mySqlSheet, "Metrics_Queries_per_second_Yaxis"));
    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_130_ValidateQueriesPerSecChartZoomInButton() throws EncryptedDocumentException, IOException{
        metricsPage.getQueriesPerSecChartZoomInButton();
    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_131_ValidateQueriesPerSecChartZoomOutButton() throws EncryptedDocumentException, IOException{
        metricsPage.getQueriesPerSecChartZoomOutButton();
    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_132_ValidateQueriesPerSecChartZoomResetButton() throws EncryptedDocumentException, IOException{
        metricsPage.getQueriesPerSecChartZoomResetButton();
    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_133_ValidateQueriesPerSecExpandTimeLineChart() throws EncryptedDocumentException, IOException{
        metricsPage.getQueriesPerSecExpandTimeLineChart();
    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_134_ValidateDeadLockCountChart() throws EncryptedDocumentException, IOException{
        metricsPage.getDeadLockCountChartTitle(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.mySqlSheet, "Metrics_Deadlock_count"));
    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_135_ValidateDeadLockCountChartXaxis() throws EncryptedDocumentException, IOException{
        metricsPage.getDeadLockCountChartXaxisTitle(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.mySqlSheet, "Metrics_allXaxes"));
    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_136_ValidateDeadLockCountChartYaxis() throws EncryptedDocumentException, IOException{
        metricsPage.getDeadLockCountChartYaxisTitle(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.mySqlSheet, "Metrics_Deadlock_count_Yaxis"));
    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_137_ValidateDeadLockCountChartZoomInButton() throws EncryptedDocumentException, IOException{
        metricsPage.getDeadLockCountChartZoomInButton();   
    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_138_ValidateDeadLockCountChartZoomOutButton() throws EncryptedDocumentException, IOException{
        metricsPage.getDeadLockCountChartZoomOutButton();
    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_139_ValidateDeadLockCountChartZoomResetButton() throws EncryptedDocumentException, IOException{
        metricsPage.getDeadLockCountChartZoomResetButton();
    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_140_ValidateDeadLockCountExpandTimeLineChart() throws EncryptedDocumentException, IOException{
       metricsPage.getDeadLockCountExpandTimeLineChart();
    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_141_ValidatePreparedStatementPerSecChart() throws EncryptedDocumentException, IOException{
        metricsPage.getPreparedStatementPerSecChartTitle(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.mySqlSheet, "Metrics_Prepared_statements_per_second"));
    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_142_ValidatePreparedStatementPerSecChartXaxis() throws EncryptedDocumentException, IOException{
        metricsPage.getPreparedStatementPerSecChartXaxisTitle(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.mySqlSheet, "Metrics_allXaxes"));
    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_143_ValidatePreparedStatementPerSecChartYaxis() throws EncryptedDocumentException, IOException{
        metricsPage.getPreparedStatementPerSecChartYaxisTitle(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.mySqlSheet, "Metrics_Prepared_statements_per_second_Yaxis"));
    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_144_ValidatePreparedStatementPerSecChartZoomInButton() throws EncryptedDocumentException, IOException{
        metricsPage.getPreparedStatementPerSecChartZoomInButton();   
    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_145_ValidatePreparedStatementPerSecChartZoomOutButton() throws EncryptedDocumentException, IOException{
        metricsPage.getPreparedStatementPerSecChartZoomOutButton();
    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_146_ValidatePreparedStatementPerSecChartZoomResetButton() throws EncryptedDocumentException, IOException{
        metricsPage.getPreparedStatementPerSecChartZoomResetButton();
    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_147_ValidatePreparedStatementPerSecExpandTimeLineChart() throws EncryptedDocumentException, IOException{
       metricsPage.getPreparedStatementPerSecExpandTimeLineChart();
    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_148_ValidatePreparedStatementsChart() throws EncryptedDocumentException, IOException{
        metricsPage.validatePreparedStatementsChartTitle(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.mySqlSheet, "Metrics_Prepared_statements"));
    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_149_ValidatePreparedStatementsChartXaxis() throws EncryptedDocumentException, IOException{
        metricsPage.validatePreparedStatementsChartXaxisTitle(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.mySqlSheet, "Metrics_allXaxes"));

    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_150_ValidatePreparedStatementsChartYaxis() throws EncryptedDocumentException, IOException{
        metricsPage.validatePreparedStatementsChartYaxisTitle(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.mySqlSheet, "Metrics_Prepared_statements_Yaxis"));
    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_151_ValidatePreparedStatementsChartZoomInButton() throws EncryptedDocumentException, IOException{
        metricsPage.validatePreparedStatementsChartZoomInButton();
    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_152_ValidatePreparedStatementsChartZoomOutButton(){
        metricsPage.validatePreparedStatementsChartZoomOutButton();

    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_153_ValidatePreparedStatementsChartZoomResetButton(){
        metricsPage.validatePreparedStatementsChartZoomResetButton();
    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_154_ValidatePreparedStatementsExpandTimeLineChart(){
      metricsPage.getPreparedStatementsExpandTimeLineChart();
    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_155_ValidateInnoDBBufferPoolPagesDataToolTip(){
        metricsPage.getInnoDBBufferPoolPagesDataToolTip();
    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_156_ValidateInnoDBBufferPoolPagesFreeToolTip() throws EncryptedDocumentException, IOException{ 
        metricsPage.getInnoDBBufferPoolPagesFreeToolTip();
    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_157_ValidateInnoDBRowLockCurrentWaitsToolTip() throws EncryptedDocumentException, IOException{
        metricsPage.getInnoDBRowLockCurrentWaitsToolTip();
    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_158_ValidateInnoDBRowLockTimeAverageToolTip() throws EncryptedDocumentException, IOException{
        metricsPage.getInnoDBRowLockTimeAverageToolTip();
    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_159_ValidateInnoDBRowLockWaitsPerSecToolTip() throws EncryptedDocumentException, IOException{
        metricsPage.getInnoDBRowLockWaitsPerSecToolTip();
    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_160_ValidateInnoDBRowLockWaitsToolTip() throws EncryptedDocumentException, IOException{
        metricsPage.getQueryInnoDBRowLockWaitsToolTip();
    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_161_ValidateTotalOpenFilesToolTip() throws EncryptedDocumentException, IOException{
        metricsPage.getTotalOpenFilesToolTip();
    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_162_ValidateTotalOpenTablesToolTip() throws EncryptedDocumentException, IOException{
        metricsPage.getTotalOpenTablesToolTip();
    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_163_ValidateMaxUsedConnectionsToolTip() throws EncryptedDocumentException, IOException{
        metricsPage.getMaxUsedConnectionsToolTip();
    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_164_ValidateNetConnectionErrorsPerSecToolTip() throws EncryptedDocumentException, IOException{
        metricsPage.getNetConnectionErrorsPerSecToolTip();
    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_165_ValidateNetConnectionErrorsToolTip() throws EncryptedDocumentException, IOException{
        metricsPage.getNetConnectionErrorsToolTip();
    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_166_ValidateSelectQueriesCountToolTip() throws EncryptedDocumentException, IOException{
        metricsPage.getSelectQueriesCountToolTip();
    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_167_ValidateInsertQueriesCountToolTip() throws EncryptedDocumentException, IOException{
        metricsPage.getInsertQueriesCountToolTip();
    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_168_ValidateSelectQueriesPerSecToolTip() throws EncryptedDocumentException, IOException{
        metricsPage.getSelectQueriesPerSecToolTip();
    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_169_ValidateInsertQueriesPerSecToolTip() throws EncryptedDocumentException, IOException{
        metricsPage.getInsertQueriesPerSecToolTip();
    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_170_ValidateSlowQueriesPerSecTip() throws EncryptedDocumentException, IOException{
        metricsPage.getSlowQueriesPerSecToolTip();
    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_171_ValidateSlowQueriesCountToolTip() throws EncryptedDocumentException, IOException{
        metricsPage.getSlowQueriesCountToolTip();
    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_172_ValidateQueriesCountToolTip() throws EncryptedDocumentException, IOException{
        metricsPage.getQueriesCountToolTip();
    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_173_ValidateQueriesPerSecToolTip() throws EncryptedDocumentException, IOException{
        metricsPage.getQueriesPerSecToolTip();
    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_174_ValidateDeadlockCountToolTip() throws EncryptedDocumentException, IOException{
        metricsPage.getDeadlockCountToolTip();
    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_175_ValidatePreparedStatementsPerSecToolTip() throws EncryptedDocumentException, IOException{
        metricsPage.getPreparedStatementsPerSecToolTip();
    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_176_ValidatePreparedStatementsToolTip() throws EncryptedDocumentException, IOException{
        metricsPage.getPreparedStatementsToolTip();
    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_177_ValidateGraphFor5mins() throws EncryptedDocumentException, IOException{
        commPage.selectTheTimeLineFromCalender(IPathConstant.fiveMinutesTimeRange);
        //page.reload();
       // page.waitForTimeout(2000);
        metricsPage.validateTheGivenTimeLine();
    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_178_ValidateGraphFor15mins() throws EncryptedDocumentException, IOException{
        commPage.selectTheTimeLineFromCalender(IPathConstant.fifteenMinutesTimeRange);
        page.waitForTimeout(2000);
        metricsPage.validateTheGivenTimeLine();
    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_179_ValidateGraphFor30mins() throws EncryptedDocumentException, IOException{
        commPage.selectTheTimeLineFromCalender(IPathConstant.thirtyMinutesTimeRange);
        page.waitForTimeout(2000);
        metricsPage.validateTheGivenTimeLine();
    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_180_ValidateGraphFor60mins() throws EncryptedDocumentException, IOException{
        commPage.selectTheTimeLineFromCalender(IPathConstant.sixtyMinutesTimeRange);
        page.waitForTimeout(2000);
        metricsPage.validateTheGivenTimeLine();
    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_181_ValidateGraphFor3Hours() throws EncryptedDocumentException, IOException{
        commPage.selectTheTimeLineFromCalender(IPathConstant.threeHoursTimeRange);
        page.waitForTimeout(2000);
        metricsPage.validateTheGivenTimeLine();

    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_182_ValidateGraphFor6Hours() throws EncryptedDocumentException, IOException{
        commPage.selectTheTimeLineFromCalender(IPathConstant.sixHoursTimeRange);
        page.waitForTimeout(2000);
        metricsPage.validateTheGivenTimeLine();
    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_183_ValidateGraphFor12Hours() throws EncryptedDocumentException, IOException{
        commPage.selectTheTimeLineFromCalender(IPathConstant.twelveHoursTimeRange);
        page.waitForTimeout(2000);
        metricsPage.validateTheGivenTimeLine();
    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_184_ValidateGraphFor1Day(){
        commPage.selectTheTimeLineFromCalender(IPathConstant.oneDayTimeRange);
        page.waitForTimeout(2000);
        metricsPage.validateTheGivenTimeLine();

    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_185_ValidateGraphFor1Week(){
        commPage.selectTheTimeLineFromCalender(IPathConstant.oneWeekTimeRange);
        page.waitForTimeout(2000);
        metricsPage.validateTheGivenTimeLine();
    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_186_ValidateGraphFor1Month(){
        commPage.selectTheTimeLineFromCalender(IPathConstant.oneMonthTimeRange);
        page.waitForTimeout(2000);
        metricsPage.validateTheGivenTimeLine();

    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_187_ValidateCustomTimeLineForCustomTimeLineForMinutesRange() throws EncryptedDocumentException, IOException{
        commPage.selectTheCustomeTimeLine(IPathConstant.customTimeRange, eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customMinutesRange") );
        page.waitForTimeout(2000);
        metricsPage.validateTheCustomTimeLine(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customMinutesRange"));
    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_188_ValidateCustomTimeLineCustomTimeLineForHoursRange() throws EncryptedDocumentException, IOException{ 
        commPage.selectTheCustomeTimeLine(IPathConstant.customTimeRange, eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customHoursRange") );
        page.waitForTimeout(2000);
        metricsPage.validateTheCustomTimeLine(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customHoursRange"));
    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_189_ValidateCustomTimeLineCustomTimeLineForDaysRange() throws EncryptedDocumentException, IOException{ 
        commPage.selectTheCustomeTimeLine(IPathConstant.customTimeRange, eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customDaysRange") );
        page.waitForTimeout(2000);
        metricsPage.validateTheCustomTimeLine(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customDaysRange"));
    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_190_ValidateCustomTimeLineForFutureTime() throws EncryptedDocumentException, IOException{
        commPage.validateTheFutureTimeLine();
    }
    @Test (groups = {"DBM","UI","Regression","MySQL"})
    public void TC_191_ValidateRefreshButton() {
        metricsPage.clickOnRefreshButton();
    }
}