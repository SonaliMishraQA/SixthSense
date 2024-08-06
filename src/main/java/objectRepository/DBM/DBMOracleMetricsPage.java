package objectRepository.DBM;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Locator.HoverOptions;

import genericUtilities.ExcelUtility;
import genericUtilities.GenericMethods;
import genericUtilities.IPathConstant;
import objectRepository.CommonPage;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;

import java.io.IOException;
import java.math.RoundingMode;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class DBMOracleMetricsPage {


    Page page;
    ExcelUtility eutil = new ExcelUtility();
    GenericMethods util=new GenericMethods();
    DBMOracleHardwarePage hardware;
    CommonPage common;

    private String databasePageTitle = "#title-text-database";
    private String selectDatabaseTypeDropDown= "#btn-arrow-down-search-select-database-type";
    private String selectDatabaseTypeTextField = "#input-search-sel-search-select-database-type";
    private String selectServiceDropDown = "#btn-arrow-down-search-select-database-service";

    private String metricsTab="xpath = //div[@class='item' and .='Metrics ']" ;
    private String serviceSearchResult ="xpath =//span[contains(@id,'search-select-database-service')]";
    private String selectDataBaseDropDown = "#btn-arrow-down-search-select-database-instance";
    private String databaseSearchResult= "//span[contains(@id,'search-select-database-instance')]" ;


    private String selectServiceTextField = "#input-search-sel-search-select-database-service" ;
    private String firstDbTypeFromDropDown ="xpath =//span[@id='search-select-database-type-0-single']";
    private String dataBaseTypeSearchResult ="xpath = //span[contains(@id,'search-select-database-type')]" ;
    private String hostCpuUtilizationGraphTitle ="xpath = //div[@id='apexchartsvuechart-line-0']/ancestor::div[@class='chart-body']/preceding-sibling::div[@class='line-header']/div[@class='line-title']";
    private String hostCpuUtilizationGraphYaxisTitle =" xpath = //div[@id='apexchartsvuechart-line-0']/descendant::*[name()='g' and @class='apexcharts-yaxis-title']" ;
    private String hostCpuUtilizationGraphXaxisTitle ="xpath = //div[@id='apexchartsvuechart-line-0']/descendant::*[name()='g' and @class='apexcharts-xaxis-title']";
    private String hostCpuUtilizationGraphZoomOutBtn = "id = 'Host-cpu-utilization-zoom-out'";
    private String hostCpuUtilizationGraphZoomInBtn = "#Host-cpu-utilization-zoom-in" ;
    private String hostCpuUtilizationGraphZoomResetBtn = "#Host-cpu-utilization-zoom-reset";
    private String hostCpuUtilizationGraphXaxisPoints ="xpath =//div[@id='apexchartsvuechart-line-0']/descendant::*[name()='line' and @class='apexcharts-xaxis-tick']" ;
    private String hostCpuUtilizationGraphTooltipTitle ="xpath =//div[@id='apexchartsvuechart-line-0']/descendant::div[@class='apexcharts-tooltip-title']";
    private String hostCpuUtilizationGraphTooltipValue ="xpath = //div[@id='apexchartsvuechart-line-0']/descendant::span[@class='apexcharts-tooltip-text-y-value']";

    private String hostCPUUtilizationxAxisLabels= "xpath = //div[@id='apexchartsvuechart-line-0']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-label apexcharts-xaxis-label' and contains(.,'-')]" ;
    private String diskReadPerSecondxAxisLabels= "xpath = //div[@id='apexchartsvuechart-line-1']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-label apexcharts-xaxis-label' and contains(.,'-')]" ;
    private String diskWritePerSecondxAxisLabels= "xpath = //div[@id='apexchartsvuechart-line-2']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-label apexcharts-xaxis-label' and contains(.,'-')]" ;
    private String NumberofLongRunningQueriesxAxisLabels= "xpath = //div[@id='apexchartsvuechart-line-3']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-label apexcharts-xaxis-label' and contains(.,'-')]" ;
    private String userTransationxAxisLabels= "xpath = //div[@id='apexchartsvuechart-line-4']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-label apexcharts-xaxis-label' and contains(.,'-')]" ;
    private String NumberofRedologfileSwitchAxisLabels= "xpath = //div[@id='apexchartsvuechart-line-5']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-label apexcharts-xaxis-label' and contains(.,'-')]" ;
    private String NumberofRedologfilewaitAxisLabels= "xpath = //div[@id='apexchartsvuechart-line-6']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-label apexcharts-xaxis-label' and contains(.,'-')]" ;
    private String HitRatiofortheSGAAxisLabels= "xpath = //div[@id='apexchartsvuechart-line-7']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-label apexcharts-xaxis-label' and contains(.,'-')]" ;
    private String SGACachebleMemoryperStatementAxisLabels= "xpath = //div[@id='apexchartsvuechart-line-8']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-label apexcharts-xaxis-label' and contains(.,'-')]" ;
    private String SGACachebleMemoryperUserAxisLabels= "xpath = //div[@id='apexchartsvuechart-line-9']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-label apexcharts-xaxis-label' and contains(.,'-')]" ;

    private String  diskReadPerSecondGraphTitle ="xpath = //div[@id='apexchartsvuechart-line-1']/ancestor::div[@class='chart-body']/preceding-sibling::div[@class='line-header']/div[@class='line-title']";
    private String  diskReadPerSecondGraphYaxisTitle ="xpath = //div[@id='apexchartsvuechart-line-1']/descendant::*[name()='g' and @class='apexcharts-yaxis-title']" ;
    private String  diskReadPerSecondGraphXaxisTitle =" xpath = //div[@id='apexchartsvuechart-line-1']/descendant::*[name()='g' and @class='apexcharts-xaxis-title']";
    private String diskReadPerSecondGraphZoomOutBtn = "#Disk-read-per-second-zoom-out";
    private String diskReadPerSecondGraphZoomInBtn = "#Disk-read-per-second-zoom-in";
    private String diskReadPerSecondGraphZoomResetBtn = "#Disk-read-per-second-zoom-reset";
    private String diskReadPerSecondGraphXaxisPoints ="xpath =//div[@id='apexchartsvuechart-line-1']/descendant::*[name()='line' and @class='apexcharts-xaxis-tick']";
    private String diskReadPerSecondGraphTooltipTitle ="xpath = //div[@id='apexchartsvuechart-line-1']/descendant::div[@class='apexcharts-tooltip-title']";
    private String diskReadPerSecondGraphTooltipValue ="xpath = //div[@id='apexchartsvuechart-line-1']/descendant::span[@class='apexcharts-tooltip-text-y-value']";

    private String diskWritePerSecondGraphTitle ="xpath = //div[@id='apexchartsvuechart-line-2']/ancestor::div[@class='chart-body']/preceding-sibling::div[@class='line-header']/div[@class='line-title']";
    private String diskWritePerSecondGraphYaxisTitle ="xpath = //div[@id='apexchartsvuechart-line-2']/descendant::*[name()='g' and @class='apexcharts-yaxis-title']" ;
    private String diskWritePerSecondGraphXaxisTitle ="xpath = //div[@id='apexchartsvuechart-line-2']/descendant::*[name()='g' and @class='apexcharts-xaxis-title']";
    private String diskWritePerSecondGraphZoomOutBtn  = "#Disk-write-per-second-zoom-out";
    private String diskWritePerSecondGraphZoomInBtn = "#Disk-write-per-second-zoom-in" ;
    private String diskWritePerSecondGraphZoomResetBtn = "$Disk-write-per-second-zoom-reset";
    private String diskWritePerSecondGraphXaxisPoints ="xpath = //div[@id='apexchartsvuechart-line-2']/descendant::*[name()='line' and @class='apexcharts-xaxis-tick']" ;
    private String diskWritePerSecondGraphTooltipTitle ="xpath = //div[@id='apexchartsvuechart-line-2']/descendant::div[@class='apexcharts-tooltip-title']";
    private String diskWritePerSecondGraphTooltipValue ="xpath = //div[@id='apexchartsvuechart-line-2']/descendant::span[@class='apexcharts-tooltip-text-y-value']";

    private String numberOfLongRunningQueriesGraphTitle =" xpath = //div[@id='apexchartsvuechart-line-3']/ancestor::div[@class='chart-body']/preceding-sibling::div[@class='line-header']/div[@class='line-title']";
    private String numberOfLongRunningQueriesGraphYaxisTitle ="xpath = //div[@id='apexchartsvuechart-line-3']/descendant::*[name()='g' and @class='apexcharts-yaxis-title']";
    private String numberOfLongRunningQueriesGraphXaxisTitle=" xpath = //div[@id='apexchartsvuechart-line-3']/descendant::*[name()='g' and @class='apexcharts-xaxis-title']";
    private String numberOfLongRunningQueriesGraphZoomOutBtn = "#Number-of-long-running-(>-60s)-queries-zoom-out";
    private String numberOfLongRunningQueriesGraphZoomInBtn = "#Number-of-long-running-(>-60s)-queries-zoom-in";
    private String numberOfLongRunningQueriesGraphZoomResetBtn  = "#Number-of-long-running-(>-60s)-queries-zoom-reset";
    private String numberOfLongRunningQueriesGraphXaxisPoints= "xpath = //div[@id='apexchartsvuechart-line-3']/descendant::*[name()='line' and @class='apexcharts-xaxis-tick']";
    private String numberOfLongRunningQueriesGraphTooltipTitle= "xpath = //div[@id='apexchartsvuechart-line-3']/descendant::div[@class='apexcharts-tooltip-title']";
    private String numberOfLongRunningQueriesGraphTooltipValue= "xpath = //div[@id='apexchartsvuechart-line-3']/descendant::span[@class='apexcharts-tooltip-text-y-value']";

    private String userTransactionGraphTitle ="xpath = //div[@id='apexchartsvuechart-line-4']/ancestor::div[@class='chart-body']/preceding-sibling::div[@class='line-header']/div[@class='line-title']";
    private String userTransactionGraphYaxisTitle="xpath = //div[@id='apexchartsvuechart-line-4']/descendant::*[name()='g' and @class='apexcharts-yaxis-title']";
    private String userTransactionGraphXaxisTitle ="xpath = //div[@id='apexchartsvuechart-line-4']/descendant::*[name()='g' and @class='apexcharts-xaxis-title']" ;
    private String userTransactionGraphZoomOutBtn = "#User-transaction-zoom-out";
    private String userTransactionGraphZoomInBtn = "#User-transaction-zoom-in" ;
    private String userTransactionGraphZoomResetBtn = "#User-transaction-zoom-reset";
    private String userTransactionGraphXaxisPoints="xpath = //div[@id='apexchartsvuechart-line-4']/descendant::*[name()='line' and @class='apexcharts-xaxis-tick']";
    private String userTransactionGraphTooltipTitle ="xpath = //div[@id='apexchartsvuechart-line-4']/descendant::div[@class='apexcharts-tooltip-title']";
    private String userTransactionGraphTooltipValue ="xpath = //div[@id='apexchartsvuechart-line-4']/descendant::span[@class='apexcharts-tooltip-text-y-value']" ;

    private String numberOfRedoLogFileSwitchGraphTitle ="xpath = //div[@id='apexchartsvuechart-line-5']/ancestor::div[@class='chart-body']/preceding-sibling::div[@class='line-header']/div[@class='line-title']" ;
    private String numberOfRedoLogFileSwitchGraphYaxisTitle ="xpath = //div[@id='apexchartsvuechart-line-5']/descendant::*[name()='g' and @class='apexcharts-yaxis-title']" ;
    private String numberOfRedoLogFileSwitchGraphXaxisTitle ="xpath = //div[@id='apexchartsvuechart-line-5']/descendant::*[name()='g' and @class='apexcharts-xaxis-title']" ;
    private String numberOfRedoLogFileSwitchGraphZoomOutBtn  = "#Number-of-redo-log-file-switch-zoom-out";
    private String numberOfRedoLogFileSwitchGraphZoomInBtn = "#Number-of-redo-log-file-switch-zoom-in";
    private String numberOfRedoLogFileSwitchGraphZoomResetBtn = "#Number-of-redo-log-file-switch-zoom-reset" ;
    private String numberOfRedoLogFileSwitchGraphXaxisPoints ="xpath = //div[@id='apexchartsvuechart-line-5']/descendant::*[name()='line' and @class='apexcharts-xaxis-tick']";
    private String numberOfRedoLogFileSwitchGraphTooltipTitle ="xpath = //div[@id='apexchartsvuechart-line-5']/descendant::div[@class='apexcharts-tooltip-title']";
    private String numberOfRedoLogFileSwitchGraphTooltipValue ="xpath = //div[@id='apexchartsvuechart-line-5']/descendant::span[@class='apexcharts-tooltip-text-y-value']";

    private String numberOfRedoLogFileWaitsGraphTitle ="xpath = //div[@id='apexchartsvuechart-line-6']/ancestor::div[@class='chart-body']/preceding-sibling::div[@class='line-header']/div[@class='line-title']";
    private String numberOfRedoLogFileWaitsGraphYaxisTitle ="xpath = //div[@id='apexchartsvuechart-line-6']/descendant::*[name()='g' and @class='apexcharts-yaxis-title']";
    private String numberOfRedoLogFileWaitsGraphXaxisTitle ="xpath = //div[@id='apexchartsvuechart-line-6']/descendant::*[name()='g' and @class='apexcharts-xaxis-title']";
    private String numberOfRedoLogFileWaitsGraphZoomOutBtn = "#Number-of-redo-log-file-waits-zoom-out" ;
    private String numberOfRedoLogFileWaitsGraphZoomInBtn = "#Number-of-redo-log-file-waits-zoom-in"  ;
    private String numberOfRedoLogFileWaitsGraphZoomResetBtn = "#Number-of-redo-log-file-waits-zoom-reset" ;
    private String numberOfRedoLogFileWaitsGraphXaxisPoints = "xpath = //div[@id='apexchartsvuechart-line-6']/descendant::*[name()='line' and @class='apexcharts-xaxis-tick']" ;
    private String numberOfRedoLogFileWaitsGraphTooltipTitle = "xpath = //div[@id='apexchartsvuechart-line-6']/descendant::div[@class='apexcharts-tooltip-title']" ;
    private String numberOfRedoLogFileWaitsGraphTooltipValue ="xpath = //div[@id='apexchartsvuechart-line-6']/descendant::span[@class='apexcharts-tooltip-text-y-value']" ;

    private String hitRatioForTheSgaGraphTitle  ="xpath = //div[@id='apexchartsvuechart-line-7']/ancestor::div[@class='chart-body']/preceding-sibling::div[@class='line-header']/div[@class='line-title']" ;
    private String hitRatioForTheSgaGraphYaxisTitle ="xpath = //div[@id='apexchartsvuechart-line-7']/descendant::*[name()='g' and @class='apexcharts-yaxis-title']" ;
    private String hitRatioForTheSgaGraphXaxisTitle ="xpath = //div[@id='apexchartsvuechart-line-7']/descendant::*[name()='g' and @class='apexcharts-xaxis-title']" ;
    private String hitRatioForTheSgaGraphZoomOutBtn  = "#Hit-ratio-for-the-SGA-zoom-out";
    private String hitRatioForTheSgaGraphZoomInBtn = "#Hit-ratio-for-the-SGA-zoom-in" ;
    private String hitRatioForTheSgaGraphZoomResetBtn = "#Hit-ratio-for-the-SGA-zoom-reset" ;
    private String hitRatioForTheSgaGraphXaxisPoints ="xpath = //div[@id='apexchartsvuechart-line-7']/descendant::*[name()='line' and @class='apexcharts-xaxis-tick']"  ;
    private String hitRatioForTheSgaGraphTooltipTitle ="xpath = //div[@id='apexchartsvuechart-line-7']/descendant::div[@class='apexcharts-tooltip-title']" ;
    private String hitRatioForTheSgaGraphTooltipValue ="xpath = //div[@id='apexchartsvuechart-line-7']/descendant::span[@class='apexcharts-tooltip-text-y-value']";

    private String sgaCacheableMemoryPerStatementGraphTitle ="xpath = //div[@id='apexchartsvuechart-line-8']/ancestor::div[@class='chart-body']/preceding-sibling::div[@class='line-header']/div[@class='line-title']" ;
    private String sgaCacheableMemoryPerStatementGraphYaxisTitle ="xpath = //div[@id='apexchartsvuechart-line-8']/descendant::*[name()='g' and @class='apexcharts-yaxis-title']";
    private String sgaCacheableMemoryPerStatementGraphXaxisTitle ="xpath = //div[@id='apexchartsvuechart-line-8']/descendant::*[name()='g' and @class='apexcharts-xaxis-title']" ;
    private String sgaCacheableMemoryPerStatementGraphZoomOutBtn = "#SGA-cacheable-memory-per-statement-zoom-out";
    private String sgaCacheableMemoryPerStatementGraphZoomInBtn="#SGA-cacheable-memory-per-statement-zoom-in";
    private String sgaCacheableMemoryPerStatementGraphZoomResetBtn  = "#SGA-cacheable-memory-per-statement-zoom-reset" ;
    private String sgaCacheableMemoryPerStatementGraphXaxisPoints ="xpath = //div[@id='apexchartsvuechart-line-8']/descendant::*[name()='line' and @class='apexcharts-xaxis-tick']" ;
    private String sgaCacheableMemoryPerStatementGraphTooltipTitle ="xpath = //div[@id='apexchartsvuechart-line-8']/descendant::div[@class='apexcharts-tooltip-title']";
    private String sgaCacheableMemoryPerStatementGraphTooltipValue ="xpath = //div[@id='apexchartsvuechart-line-8']/descendant::span[@class='apexcharts-tooltip-text-y-value']";

    private String sgaCacheableMemoryPerUserGraphTitle ="xpath = //div[@id='apexchartsvuechart-line-9']/ancestor::div[@class='chart-body']/preceding-sibling::div[@class='line-header']/div[@class='line-title']" ;
    private String sgaCacheableMemoryPerUserGraphYaxisTitle ="xpath = //div[@id='apexchartsvuechart-line-9']/descendant::*[name()='g' and @class='apexcharts-yaxis-title']";
    private String sgaCacheableMemoryPerUserGraphXaxisTitle ="xpath = //div[@id='apexchartsvuechart-line-9']/descendant::*[name()='g' and @class='apexcharts-xaxis-title']";
    private String sgaCacheableMemoryPerUserGraphZoomOutBtn= "#SGA-cacheable-memory-per-user-zoom-out";
    private String sgaCacheableMemoryPerUserGraphZoomInBtn = "#SGA-cacheable-memory-per-user-zoom-in" ;
    private String sgaCacheableMemoryPerUserGraphZoomResetBtn = "#SGA-cacheable-memory-per-user-zoom-reset";
    private String sgaCacheableMemoryPerUserGraphXaxisPoints ="xpath = //div[@id='apexchartsvuechart-line-9']/descendant::*[name()='line' and @class='apexcharts-xaxis-tick']" ;
    private String sgaCacheableMemoryPerUserGraphTooltipTitle ="xpath = //div[@id='apexchartsvuechart-line-9']/descendant::div[@class='apexcharts-tooltip-title']";
    private String sgaCacheableMemoryPerUserGraphTooltipValue ="xpath = //div[@id='apexchartsvuechart-line-9']/descendant::span[@class='apexcharts-tooltip-text-y-value']";

    private String calanderValue = "xpath = //div[@class='selected-text ellipsis bg-text']";

    public DBMOracleMetricsPage(Page page) {
        this.page=page;
        hardware = new DBMOracleHardwarePage(this.page);
        common = new CommonPage(page);
    }


        public void validateTheGivenTimeLine()
        {
            util.validateTheGraphdisplayingTheDataAsPerGivenTimeLines(page,hostCPUUtilizationxAxisLabels,calanderValue,allWidgetXAxisLabels());
        }


    public void verify_the_Xaxis_Title_Of_Host_CPU_Utilization_Graph(String readDataFromExcelByUsingKeyProperty) {
        util.ValidateTheTitle(page, hostCpuUtilizationGraphXaxisTitle, readDataFromExcelByUsingKeyProperty);
    }


    public List<String> allWidgetXPoints()
    {
        ArrayList<String> xPoint = new ArrayList<String>();
        xPoint.add(hostCpuUtilizationGraphXaxisPoints);
        xPoint.add(diskReadPerSecondGraphXaxisPoints);
        xPoint.add(diskWritePerSecondGraphXaxisPoints);
        xPoint.add(numberOfLongRunningQueriesGraphXaxisPoints);
        xPoint.add(userTransactionGraphXaxisPoints);
        xPoint.add(numberOfRedoLogFileSwitchGraphXaxisPoints);
        xPoint.add(numberOfRedoLogFileWaitsGraphXaxisPoints);
        xPoint.add(hitRatioForTheSgaGraphXaxisPoints);
        xPoint.add(sgaCacheableMemoryPerStatementGraphXaxisPoints);
        xPoint.add(sgaCacheableMemoryPerUserGraphXaxisPoints);
        return xPoint;
    }


    public List<String> allWidgetXAxisLabels()
    {
        ArrayList<String> xPoint = new ArrayList<String>();
        xPoint.add(hostCPUUtilizationxAxisLabels);
        xPoint.add(HitRatiofortheSGAAxisLabels);
        xPoint.add(diskReadPerSecondxAxisLabels);
        xPoint.add(diskWritePerSecondxAxisLabels);
        xPoint.add(userTransationxAxisLabels);
        xPoint.add(NumberofRedologfileSwitchAxisLabels);
        xPoint.add(NumberofRedologfilewaitAxisLabels);
        xPoint.add(SGACachebleMemoryperStatementAxisLabels);
        xPoint.add(SGACachebleMemoryperUserAxisLabels);
        xPoint.add(NumberofLongRunningQueriesxAxisLabels);
        return xPoint;
    }


    public void selectDatabase(String DatabaseType){
        util.selectTheOptionFromDropDownBySearch(page, selectDatabaseTypeDropDown, selectDatabaseTypeTextField, DatabaseType, dataBaseTypeSearchResult);
    }


    public  void verify_the_Title_Of_Host_CPU_Utilization_Graph(String readDataFromExcelByUsingKeyProperty) {
        Assert.assertTrue(page.locator(hostCpuUtilizationGraphTitle).isVisible());
        util.ValidateTheTitle(page, hostCpuUtilizationGraphTitle, readDataFromExcelByUsingKeyProperty);
    }

    public void NavigateToMetricsSection(){
        page.click(metricsTab);
        page.waitForSelector(hostCpuUtilizationGraphTitle);
        Assert.assertTrue(page.isVisible(hostCpuUtilizationGraphTitle));
    }

    public void selectservice(String ServiceName){
        util.selectTheOptionFromDropDownBySearch(page,selectServiceDropDown,selectServiceTextField,ServiceName,serviceSearchResult);
    }


    public void selectDatabase1(String DatabaseType){
        util.selectTheOptionFromDropDownBySearch(page, selectDataBaseDropDown, selectServiceTextField, DatabaseType, databaseSearchResult);

    }


    public void verify_the_Yaxis_Title_Of_Host_CPU_Utilization_Graph(String readDataFromExcelByUsingKeyProperty) {
        util.ValidateTheTitle(page,hostCpuUtilizationGraphYaxisTitle, readDataFromExcelByUsingKeyProperty);
    }

    public void validate_host_CPU_utilization_graph_zoomin() {
        util.graphZoomIn(page, hostCpuUtilizationGraphZoomInBtn, hostCpuUtilizationGraphZoomResetBtn, allWidgetXPoints());
    }

    public void validate_host_CPU_utilization_graph_zoomout() {
        util.graphZoomOut(page, hostCpuUtilizationGraphZoomInBtn,hostCpuUtilizationGraphZoomOutBtn, hostCpuUtilizationGraphZoomResetBtn, allWidgetXPoints());
    }

    public void validate_host_CPU_utilization_graph_zoomReset() {
        util.graphZoomReset(page, hostCpuUtilizationGraphZoomInBtn, hostCpuUtilizationGraphZoomResetBtn, allWidgetXPoints());
    }

    public void validate_host_CPU_utilization_graph_zoomDragnDrop() {
        util.graphZoomInByDragAndDrop(page,hostCpuUtilizationGraphXaxisPoints,hostCpuUtilizationGraphZoomResetBtn,allWidgetXPoints());
    }

    public void verify_the_Title_Of_disk_read_per_second_Graph(String readDataFromExcelByUsingKeyProperty) {
        util.ValidateTheTitle(page,diskReadPerSecondGraphTitle, readDataFromExcelByUsingKeyProperty);
    }

    public void verify_th_Xaxis_Title_Of_disk_read_per_second_Graph(String readDataFromExcelByUsingKeyProperty) {
        util.ValidateTheTitle(page,diskReadPerSecondGraphXaxisTitle, readDataFromExcelByUsingKeyProperty);
    }

    public void verify_th_Yaxis_Title_Of_disk_read_per_second_Graph(String readDataFromExcelByUsingKeyProperty) {
        util.ValidateTheTitle(page,diskReadPerSecondGraphYaxisTitle, readDataFromExcelByUsingKeyProperty);
    }

    public void validate_disk_read_per_second_graph_zoomin() {
        util.graphZoomIn(page, diskReadPerSecondGraphZoomInBtn, hostCpuUtilizationGraphZoomResetBtn, allWidgetXPoints());
    }

    public void validate_disk_read_per_second_graph_zoomout() {
        util.graphZoomOut(page, diskReadPerSecondGraphZoomInBtn,diskReadPerSecondGraphZoomOutBtn, diskReadPerSecondGraphZoomResetBtn, allWidgetXPoints());
    }

    public void validate_disk_read_per_second_graph_zoomReset() {
        util.graphZoomReset(page,diskReadPerSecondGraphZoomInBtn, diskReadPerSecondGraphZoomResetBtn, allWidgetXPoints());
    }

    public void validate_disk_read_per_second_graph_zoomDragnDrop() {
        util.graphZoomInByDragAndDrop(page,diskReadPerSecondGraphXaxisPoints,diskReadPerSecondGraphZoomResetBtn,allWidgetXPoints());
    }

    public void verify_the_Title_Of_disk_write_per_second_Graph(String readDataFromExcelByUsingKeyProperty) {
        util.ValidateTheTitle(page,diskWritePerSecondGraphTitle, readDataFromExcelByUsingKeyProperty);
    }

    public void verify_the_Xaxis_Title_Of_disk_write_per_second_Graph(String readDataFromExcelByUsingKeyProperty) {
        util.ValidateTheTitle(page,diskReadPerSecondGraphXaxisTitle, readDataFromExcelByUsingKeyProperty);
    }

    public void verify_the_Yaxis_Title_Of_disk_write_per_second_Graph(String readDataFromExcelByUsingKeyProperty) {
        util.ValidateTheTitle(page,diskReadPerSecondGraphYaxisTitle, readDataFromExcelByUsingKeyProperty);
    }

    public void validate_disk_write_per_second_graph_zoomin() {
        util.graphZoomIn(page, diskWritePerSecondGraphZoomInBtn, diskWritePerSecondGraphZoomResetBtn, allWidgetXPoints());
    }

    public void validate_disk_write_per_second_graph_zoomout() {
        util.graphZoomOut(page, diskWritePerSecondGraphZoomInBtn,diskWritePerSecondGraphZoomOutBtn, diskWritePerSecondGraphZoomResetBtn, allWidgetXPoints());
    }

    public void validate_disk_write_per_second_graph_zoomReset() {
        util.graphZoomReset(page, diskWritePerSecondGraphZoomInBtn, diskWritePerSecondGraphZoomResetBtn, allWidgetXPoints());

    }

    public void validate_disk_write_per_second_graph_zoomDragnDrop() {
        util.graphZoomInByDragAndDrop(page,diskWritePerSecondGraphXaxisPoints, diskWritePerSecondGraphZoomResetBtn, allWidgetXPoints());
    }

    public void verify_the_Title_Of_long_running_gt60_queries_Graph(String readDataFromExcelByUsingKeyProperty) {
        util.ValidateTheTitle(page,numberOfLongRunningQueriesGraphTitle, readDataFromExcelByUsingKeyProperty);
    }

    public void verify_the_Xaxis_Title_Of_long_running_gt60_queries_Graph(String readDataFromExcelByUsingKeyProperty) {
        util.ValidateTheTitle(page,numberOfLongRunningQueriesGraphXaxisTitle, readDataFromExcelByUsingKeyProperty);
    }

    public void verify_the_Yaxis_Title_Of_long_running_gt60_queries_Graph(String readDataFromExcelByUsingKeyProperty) {
        util.ValidateTheTitle(page,numberOfLongRunningQueriesGraphYaxisTitle, readDataFromExcelByUsingKeyProperty);
    }

    public void validate_no_of_long_running_gt60_queries_graph_zoomin() {
        util.graphZoomIn(page, numberOfLongRunningQueriesGraphZoomInBtn, numberOfLongRunningQueriesGraphZoomResetBtn, allWidgetXPoints());
    }

    public void validate_no_of_long_running_gt60_queries_graph_zoomOut() {
        util.graphZoomOut(page, numberOfLongRunningQueriesGraphZoomInBtn, numberOfLongRunningQueriesGraphZoomOutBtn,numberOfLongRunningQueriesGraphZoomResetBtn, allWidgetXPoints());
    }

    public void validate_no_of_long_running_gt60_queries_graph_zoomReset() {
        util.graphZoomReset(page, numberOfLongRunningQueriesGraphZoomInBtn,numberOfLongRunningQueriesGraphZoomResetBtn, allWidgetXPoints());
    }

    public void validate_no_of_long_running_gt60_queries_graph_zoomDragnDrop() {
        util.graphZoomInByDragAndDrop(page,numberOfLongRunningQueriesGraphXaxisPoints ,numberOfLongRunningQueriesGraphZoomResetBtn, allWidgetXPoints());
    }

    public void verify_the_Title_Of_of_user_transaction_Graph(String readDataFromExcelByUsingKeyProperty) {
        util.ValidateTheTitle(page,userTransactionGraphTitle, readDataFromExcelByUsingKeyProperty);
    }

    public void verify_the_Xaxis_Title_Of_of_user_transaction_Graph(String readDataFromExcelByUsingKeyProperty) {
        util.ValidateTheTitle(page,userTransactionGraphXaxisTitle, readDataFromExcelByUsingKeyProperty);
    }

    public void verify_the_Yaxis_Title_Of_of_user_transaction_Graph(String readDataFromExcelByUsingKeyProperty) {
        util.ValidateTheTitle(page,userTransactionGraphYaxisTitle, readDataFromExcelByUsingKeyProperty);
    }

    public void validate_user_transaction_graph_zoomin() {
        util.graphZoomIn(page, userTransactionGraphZoomInBtn, userTransactionGraphZoomResetBtn, allWidgetXPoints());
    }

    public void validate_user_transaction_graph_zoomout() {
        util.graphZoomOut(page, userTransactionGraphZoomInBtn, userTransactionGraphZoomOutBtn,userTransactionGraphZoomResetBtn, allWidgetXPoints());
    }

    public void validate_user_transaction_graph_zoomReset() {
        util.graphZoomReset(page,userTransactionGraphZoomInBtn,userTransactionGraphZoomResetBtn,allWidgetXPoints());
    }

    public void validate_user_transaction_graph_zoomDragnDrop() {
        util.graphZoomInByDragAndDrop(page,userTransactionGraphXaxisPoints,userTransactionGraphZoomResetBtn,allWidgetXPoints());
    }

    public void verify_the_Title_Of_no_of_redo_file_switch_Graph(String readDataFromExcelByUsingKeyProperty) {
        util.ValidateTheTitle(page,numberOfRedoLogFileSwitchGraphTitle, readDataFromExcelByUsingKeyProperty);
    }

    public void verify_the_Xaxis_Title_Of_no_of_redo_file_switch_Graph(String readDataFromExcelByUsingKeyProperty) {
        util.ValidateTheTitle(page,numberOfRedoLogFileSwitchGraphXaxisTitle, readDataFromExcelByUsingKeyProperty);
    }


    public void verify_the_Yaxis_Title_Of_no_of_redo_file_switch_Graph(String readDataFromExcelByUsingKeyProperty) {
        util.ValidateTheTitle(page,numberOfRedoLogFileSwitchGraphYaxisTitle, readDataFromExcelByUsingKeyProperty);
    }

    public void validate_no_of_redo_file_switch_graph_zoomin() {
        util.graphZoomIn(page, numberOfRedoLogFileSwitchGraphZoomInBtn, numberOfRedoLogFileSwitchGraphZoomResetBtn, allWidgetXPoints());
    }

    public void validate_no_of_redo_file_switch_graph_zoomOut() {
        util.graphZoomOut(page, numberOfRedoLogFileSwitchGraphZoomInBtn, numberOfRedoLogFileSwitchGraphZoomOutBtn,numberOfRedoLogFileSwitchGraphZoomResetBtn, allWidgetXPoints());
    }

    public void validate_no_of_redo_file_switch_graph_zoomReset() {
        util.graphZoomReset(page, numberOfRedoLogFileSwitchGraphZoomInBtn,numberOfRedoLogFileSwitchGraphZoomResetBtn, allWidgetXPoints());
    }

    public void validate_no_of_redo_file_switch_graph_zoomDragnDrop() {
        util.graphZoomInByDragAndDrop(page,numberOfLongRunningQueriesGraphXaxisPoints,numberOfRedoLogFileSwitchGraphZoomResetBtn,allWidgetXPoints());
    }

    public void verify_the_Title_Of_No_of_redo_log_file_waits_Graph(String readDataFromExcelByUsingKeyProperty) {
        util.ValidateTheTitle(page,numberOfRedoLogFileWaitsGraphTitle, readDataFromExcelByUsingKeyProperty);
    }

    public void verify_the_XaxisTitle_Of_No_of_redo_log_file_waits_Graph(String readDataFromExcelByUsingKeyProperty) {
        util.ValidateTheTitle(page,numberOfRedoLogFileWaitsGraphXaxisTitle, readDataFromExcelByUsingKeyProperty);
    }

    public void verify_the_YaxisTitle_Of_No_of_redo_log_file_waits_Graph(String readDataFromExcelByUsingKeyProperty) {
        util.ValidateTheTitle(page,numberOfRedoLogFileWaitsGraphYaxisTitle, readDataFromExcelByUsingKeyProperty);
    }

    public void validate_no_of_redo_file_waits_graph_zoomIn() {
        util.graphZoomIn(page, numberOfRedoLogFileWaitsGraphZoomInBtn, numberOfRedoLogFileWaitsGraphZoomResetBtn,allWidgetXPoints());
    }

    public void validate_no_of_redo_file_waits_graph_zoomOut() {
        util.graphZoomOut(page, numberOfRedoLogFileWaitsGraphZoomInBtn, numberOfRedoLogFileWaitsGraphZoomOutBtn,numberOfRedoLogFileWaitsGraphZoomResetBtn, allWidgetXPoints());
    }

    public void validate_no_of_redo_file_waits_graph_zoomReset() {
        util.graphZoomReset(page, numberOfRedoLogFileWaitsGraphZoomInBtn,numberOfRedoLogFileWaitsGraphZoomResetBtn, allWidgetXPoints());
    }

    public void validate_no_of_redo_file_waits_graph_zoomDragnDrop() {
        util.graphZoomInByDragAndDrop(page, numberOfRedoLogFileWaitsGraphXaxisPoints,numberOfRedoLogFileWaitsGraphZoomResetBtn, allWidgetXPoints());
    }

    public void verify_the_Title_Of_Hit_ratio_for_the_SGA_Graph(String readDataFromExcelByUsingKeyProperty) {
        util.ValidateTheTitle(page,hitRatioForTheSgaGraphTitle, readDataFromExcelByUsingKeyProperty);
    }

    public void verify_the_Xaxis_Title_Of_Hit_ratio_for_the_SGA_Graph(String readDataFromExcelByUsingKeyProperty) {
        util.ValidateTheTitle(page,hitRatioForTheSgaGraphXaxisTitle, readDataFromExcelByUsingKeyProperty);
    }

    public void verify_the_Yaxis_Title_Of_Hit_ratio_for_the_SGA_Graph(String readDataFromExcelByUsingKeyProperty) {
        util.ValidateTheTitle(page,hitRatioForTheSgaGraphYaxisTitle, readDataFromExcelByUsingKeyProperty);
    }

    public void validate_Hit_ratio_for_the_SGA_graph_zoomDragIn() {
        util.graphZoomIn(page, hitRatioForTheSgaGraphZoomInBtn, hitRatioForTheSgaGraphZoomResetBtn,allWidgetXPoints());
    }

    public void validate_Hit_ratio_for_the_SGA_graph_zoomOut() {
        util.graphZoomOut(page, hitRatioForTheSgaGraphZoomInBtn, hitRatioForTheSgaGraphZoomOutBtn,hitRatioForTheSgaGraphZoomResetBtn,allWidgetXPoints());
    }

    public void validate_Hit_ratio_for_the_SGA_graph_zoomReset() {
        util.graphZoomReset(page, hitRatioForTheSgaGraphZoomInBtn,hitRatioForTheSgaGraphZoomResetBtn,allWidgetXPoints());
    }

    public void validate_Hit_ratio_for_the_SGA_graph_zoomDragnDrop() {
        util.graphZoomInByDragAndDrop(page, hitRatioForTheSgaGraphXaxisTitle,hitRatioForTheSgaGraphZoomResetBtn,allWidgetXPoints());
    }

    public void verify_the_Title_Of_SGA_Cacheable_memory_per_statement_Graph(String readDataFromExcelByUsingKeyProperty) {
        util.ValidateTheTitle(page,sgaCacheableMemoryPerStatementGraphTitle, readDataFromExcelByUsingKeyProperty);
    }

    public void verify_the_Xaxis_Title_Of_SGA_Cacheable_memory_per_statement_Graph(String readDataFromExcelByUsingKeyProperty) {
        util.ValidateTheTitle(page,sgaCacheableMemoryPerStatementGraphXaxisTitle, readDataFromExcelByUsingKeyProperty);
    }

    public void verify_the_Yaxis_Title_Of_SGA_Cacheable_memory_per_statement_Graph(String readDataFromExcelByUsingKeyProperty) {
        util.ValidateTheTitle(page,sgaCacheableMemoryPerStatementGraphYaxisTitle, readDataFromExcelByUsingKeyProperty);
    }

    public void validate_SGA_Cacheable_memory_per_statement_graph_zoomIn() {
        util.graphZoomIn(page, hitRatioForTheSgaGraphZoomInBtn, hitRatioForTheSgaGraphZoomResetBtn,allWidgetXPoints());
    }

    public void validate_SGA_Cacheable_memory_per_statement_graph_zoomOut() {
        util.graphZoomOut(page, sgaCacheableMemoryPerStatementGraphZoomInBtn, sgaCacheableMemoryPerStatementGraphZoomOutBtn,sgaCacheableMemoryPerStatementGraphZoomResetBtn,allWidgetXPoints());
    }

    public void validate_SGA_Cacheable_memory_per_statement_graph_zoomReset() {
        util.graphZoomReset(page,  sgaCacheableMemoryPerStatementGraphZoomInBtn,sgaCacheableMemoryPerStatementGraphZoomResetBtn,allWidgetXPoints());
    }

    public void validate_SGA_Cacheable_memory_per_statement_graph_zoomDragnDrop() {
        util.graphZoomInByDragAndDrop(page, sgaCacheableMemoryPerStatementGraphXaxisPoints,sgaCacheableMemoryPerStatementGraphZoomResetBtn,allWidgetXPoints());
    }

    public void verify_the_Title_Of_SGA_Cacheable_memory_per_user_Graph(String readDataFromExcelByUsingKeyProperty) {
        util.ValidateTheTitle(page,sgaCacheableMemoryPerUserGraphTitle, readDataFromExcelByUsingKeyProperty);
    }

    public void verify_the_Xaxis_Title_Of_SGA_Cacheable_memory_per_user_Graph(String readDataFromExcelByUsingKeyProperty) {
        util.ValidateTheTitle(page,sgaCacheableMemoryPerUserGraphXaxisTitle, readDataFromExcelByUsingKeyProperty);
    }

    public void verify_the_Yaxis_Title_Of_SGA_Cacheable_memory_per_user_Graph(String readDataFromExcelByUsingKeyProperty) {
        util.ValidateTheTitle(page,sgaCacheableMemoryPerUserGraphYaxisTitle, readDataFromExcelByUsingKeyProperty);
    }

    public void validate_SGA_Cacheable_memory_per_user_graph_zoomIn() {
        util.graphZoomIn(page,sgaCacheableMemoryPerUserGraphZoomInBtn,sgaCacheableMemoryPerUserGraphZoomResetBtn,allWidgetXPoints());
    }

    public void validate_SGA_Cacheable_memory_per_user_graph_zoomOut() {
        util.graphZoomOut(page, sgaCacheableMemoryPerUserGraphZoomInBtn,sgaCacheableMemoryPerUserGraphZoomOutBtn, sgaCacheableMemoryPerUserGraphZoomResetBtn, allWidgetXPoints());
    }
    public void validate_SGA_Cacheable_memory_per_user_graph_zoomReset() {
        util.graphZoomReset(page, sgaCacheableMemoryPerUserGraphZoomInBtn,sgaCacheableMemoryPerUserGraphZoomResetBtn,allWidgetXPoints());
    }

    public void validate_SGA_Cacheable_memory_per_user_graph_zoomDragnDrop() {
        util.graphZoomInByDragAndDrop(page,sgaCacheableMemoryPerStatementGraphXaxisPoints,sgaCacheableMemoryPerStatementGraphZoomResetBtn,allWidgetXPoints());
    }
    
    public void validateUserTransactionValueInMetricsPage() throws EncryptedDocumentException, IOException, SQLException {
    	page.pause();
    	ResultSet resultSet = hardware.connectToJdbcAndExecuteTheQuery(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.oracleSheet, "dataValidation_query1"));
    	double value = 0.0;
    	int dbValue = 0, uiValue = 0;
		while (resultSet.next()) {
            if(resultSet.getString(2).equalsIgnoreCase("User Transaction Per Sec"))
            {
                value = resultSet.getDouble(3);
                break;
            }
        }
        System.out.println("Actual DB value: "+ value);
		common.selectTheTimeLineFromCalender(IPathConstant.fiveMinutesTimeRange);
        DecimalFormat df=new DecimalFormat("#");
		df.setRoundingMode(RoundingMode.UP);
        dbValue = (Integer.parseInt(df.format(value)));
        System.out.println("dbvalue: "+ dbValue);
        NavigateToMetricsSection();
        page.waitForTimeout(500);
        Locator xpoint = page.locator(userTransactionGraphXaxisPoints);
        HoverOptions hoverOpt = new HoverOptions();
        hoverOpt.setForce(true);
        hoverOpt.setPosition(0, -10);
        xpoint.last().hover(hoverOpt);
        page.waitForSelector(userTransactionGraphTooltipValue);
        uiValue = Integer.parseInt(page.textContent(userTransactionGraphTooltipValue).trim());
        if(dbValue == uiValue) {
            System.out.println("uivalue: "+ uiValue);
            Assert.assertTrue(dbValue == uiValue);
        }
        else {
        	hoverOpt.setPosition(2, -10);
            xpoint.nth(xpoint.count()-2).hover(hoverOpt);
            page.waitForSelector(userTransactionGraphTooltipValue);
            uiValue = Integer.parseInt(page.textContent(userTransactionGraphTooltipValue).trim());
            System.out.println("uivalue: "+ uiValue);
            Assert.assertTrue(dbValue == uiValue);
        }
        resultSet.close();
    }
    
    public void validateHostCpuUtilizationValueInMetricsPage() throws EncryptedDocumentException, IOException, SQLException {
    	ResultSet resultSet = hardware.connectToJdbcAndExecuteTheQuery(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.oracleSheet, "dataValidation_query1"));
    	double dbValue = 0.0, uiValue = 0.0;
		while (resultSet.next()) {
            if(resultSet.getString(2).equalsIgnoreCase("Host CPU Utilization (%)"))
            {
            	dbValue = resultSet.getDouble(3);
                break;
            }
        }
//		DecimalFormat df=new DecimalFormat("#");
//		df.setRoundingMode(RoundingMode.UP);
		common.selectTheTimeLineFromCalender(IPathConstant.fiveMinutesTimeRange);
        dbValue = (double)Math.round(dbValue);
        System.out.println("dbvalue: "+ dbValue);
        page.pause();
		NavigateToMetricsSection();
		page.waitForTimeout(300);
        Locator xpoint = page.locator(hostCpuUtilizationGraphXaxisPoints);
        HoverOptions hoverOpt = new HoverOptions();
        hoverOpt.setForce(true);
        hoverOpt.setPosition(0, -10);
        xpoint.last().hover(hoverOpt);
//        page.waitForSelector(hostCpuUtilizationGraphTooltipValue);
        page.waitForTimeout(200);
        uiValue = Double.parseDouble(page.textContent(hostCpuUtilizationGraphTooltipValue).trim());
        if(dbValue == uiValue) {
            System.out.println("uivalue: "+ uiValue);
            Assert.assertTrue(dbValue == uiValue);
        }
        else {
        	hoverOpt.setPosition(2, -10);
            xpoint.nth(xpoint.count()-2).hover(hoverOpt);
            page.waitForSelector(hostCpuUtilizationGraphTooltipValue);
            uiValue = Double.parseDouble(page.textContent(hostCpuUtilizationGraphTooltipValue).trim());
            System.out.println("uivalue: "+ uiValue);
            Assert.assertTrue(dbValue == uiValue);
        }
        resultSet.close();
    }
    
    public void validateDiskReadPerSecondValueInMetricsPage() throws EncryptedDocumentException, IOException, SQLException {
    	ResultSet resultSet = hardware.connectToJdbcAndExecuteTheQuery(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.oracleSheet, "dataValidation_query4"));
    	int value = 0;
    	double dbValue = 0.0, uiValue = 0.0;
		while (resultSet.next()) {
            	value = resultSet.getInt("ReadTime");
        }
		DecimalFormat df=new DecimalFormat("#.#");
		df.setRoundingMode(RoundingMode.UP);
        dbValue = (Double.parseDouble(df.format(value)));
        System.out.println("dbvalue: "+ dbValue);
		common.selectTheTimeLineFromCalender(IPathConstant.fiveMinutesTimeRange);
		NavigateToMetricsSection();
		page.waitForTimeout(300);
        Locator xpoint = page.locator(diskReadPerSecondGraphXaxisPoints);
        HoverOptions hoverOpt = new HoverOptions();
        hoverOpt.setForce(true);
        hoverOpt.setPosition(0, -10);
        xpoint.last().hover(hoverOpt);
        page.waitForSelector(diskReadPerSecondGraphTooltipValue);
        uiValue = Double.parseDouble(page.textContent(diskReadPerSecondGraphTooltipValue).trim());
        if(dbValue == uiValue) {
            System.out.println("uivalue: "+ uiValue);
            Assert.assertTrue(dbValue == uiValue);
        }
        else {
        	hoverOpt.setPosition(2, -10);
            xpoint.nth(xpoint.count()-2).hover(hoverOpt);
            page.waitForSelector(diskReadPerSecondGraphTooltipValue);
            uiValue = Double.parseDouble(page.textContent(diskReadPerSecondGraphTooltipValue).trim());
            System.out.println("uivalue: "+ uiValue);
            Assert.assertTrue(dbValue == uiValue);
        }
        resultSet.close();
    }
   
    public void validateDiskWritePerSecondValueInMetricsPage() throws EncryptedDocumentException, IOException, SQLException {
    	ResultSet resultSet = hardware.connectToJdbcAndExecuteTheQuery(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.oracleSheet, "dataValidation_query4"));
    	int value = 0;
    	double dbValue = 0.0, uiValue = 0.0, uiValue1 = 0.0, difference = 0.0;
    	while (resultSet.next()) {
        	value = resultSet.getInt("WriteTime");
    }
		DecimalFormat df=new DecimalFormat("#.#");
//		df.setRoundingMode(RoundingMode.UP);
        dbValue = (Double.parseDouble(df.format(value)));
        System.out.println("dbvalue: "+ dbValue);
		common.selectTheTimeLineFromCalender(IPathConstant.fiveMinutesTimeRange);
		NavigateToMetricsSection();
		page.waitForTimeout(300);
        Locator xpoint = page.locator(diskWritePerSecondGraphXaxisPoints);
        HoverOptions hoverOpt = new HoverOptions();
        hoverOpt.setForce(true);
        hoverOpt.setPosition(0, -10);
        xpoint.last().hover(hoverOpt);
        page.waitForSelector(diskWritePerSecondGraphTooltipValue);
        uiValue = Double.parseDouble(page.textContent(diskWritePerSecondGraphTooltipValue).trim());
        hoverOpt.setPosition(2, -10);
        xpoint.nth(xpoint.count()-2).hover(hoverOpt);
        page.waitForSelector(diskWritePerSecondGraphTooltipValue);
        uiValue1 = Double.parseDouble(page.textContent(diskWritePerSecondGraphTooltipValue).trim());
        difference = uiValue1 - uiValue;
        System.out.println("uivalue: "+ difference);
        resultSet.close();    
    }
}
