package objectRepository.DBM;

import com.microsoft.playwright.Page;
import genericUtilities.ExcelUtility;
import genericUtilities.GenericMethods;
import genericUtilities.IPathConstant;
import objectRepository.CommonPage;
import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MysqlConnectionsPage {

    Page page;
    ExcelUtility excel = new ExcelUtility();
    GenericMethods util = new GenericMethods();

    private String connectionsTab = "xpath =//div[@class='navtab']/child::div[@class='item' and position()=3]/child::div";

    private String selectDatabaseDropdown = "#btn-arrow-down-search-select-database-type";
    private String DatabaseSearchboxInputField = "#input-search-sel-search-select-database-type";
    private String DatabaseSearchResults = "#search-select-database-type-0-single";
    private String selectServiceDropdown = "#btn-arrow-down-search-select-database-service";
    private String ServiceSearchboxInputField = "#input-search-sel-search-select-database-service";
    private String ServiceSearchResults = "#search-select-database-service-0-single";
    private String nodeDropDown = "#btn-arrow-down-search-select-database-instance" ;
    private String nodeSearhInputField = "#input-search-sel-search-select-database-instance";
    private String nodeSearchResults = "#search-select-database-instance-0-single";

    private String sessionDetails="xpath=//div[@class = 'table-component-container']/child::table[@class='table-container']/child::caption";
    private String userName="xpath=//thead[@class='header-container header-secondary']/descendant::div[@class='header-slot-default'][position()=1]";
    private String queryExecuted="xpath=//thead[@class='header-container header-secondary']/descendant::div[@class='header-slot-default'][position()=2]";
    private String timeStamp="xpath=//thead[@class='header-container header-secondary']/descendant::div[@class='header-slot-default'][position()=3]";
    private String deadLock="xpath=//thead[@class='header-container header-secondary']/descendant::div[@class='header-slot-default'][position()=4]";

    private String totalThreadsConnectedWidgetTitle="xpath=//div[@class='wrapper']/descendant::div[@class='line-title'][position()=1]";
    private String totalThreadsConnectedZoomOutBtn = "#Total-threads-connected-zoom-out";
    private String totalThreadsConnectedZoomInBtn= "#Total-threads-connected-zoom-in";
    private String totalThreadsConnectedResetBtn= "#Total-threads-connected-zoom-reset";
    private String totalThreadsConnectedXaxisLines ="xpath=//div[@id='apexchartsvuechart-line-0']/ancestor::div[@class='chart-line']/descendant::*[name()='line' and @class='apexcharts-xaxis-tick']";
    private String totalThreadsConnectedXaxisValues="xpath=//div[@id='apexchartsvuechart-line-0']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-label apexcharts-xaxis-label']/child::*[name()='tspan' and contains(text(),'-')]";
    private String totalThreadsConnectedXaxisTitle="xpath=//div[@id='apexchartsvuechart-line-0']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-title-text chart-lables']";
    private String totalThreadsConnectedYaxisTitle="xpath=//div[@id='apexchartsvuechart-line-0']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-yaxis-title-text chart-lables']";
    private String totalThreadsConnectedToolTipTitle="xpath=//div[@id='apexchartsvuechart-line-0']/ancestor::div[@class='chart-box']/descendant::div[@class='apexcharts-tooltip-title']";
    private String totalThreadsConnectedTooltipValue="xpath=//div[@id='apexchartsvuechart-line-0']/ancestor::div[@class='chart-box']/descendant::div[@class='apexcharts-tooltip-text']";

    private String totalThreadsRunningWidgetTitle="xpath=//div[@class='wrapper']/descendant::div[@class='line-title'][position()=2]";
    private String totalThreadsRunningZoomOutBtn="#Total-threads-running-zoom-out";
    private String totalThreadsRunningZoomInBtn ="#Total-threads-running-zoom-in";
    private String totalThreadsRunningResetBtn = "#Total-threads-running-zoom-reset" ;
    private String totalThreadsRunningXaxisLines="xpath=//div[@id='apexchartsvuechart-line-1']/ancestor::div[@class='chart-line']/descendant::*[name()='line' and @class='apexcharts-xaxis-tick']";
    private String totalThreadsRunningXaxisValues="xpath=//div[@id='apexchartsvuechart-line-1']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-label apexcharts-xaxis-label']/child::*[name()='tspan' and contains(text(),'-')]";
    private String totalThreadsRunningXaxisTitle="xpath=//div[@id='apexchartsvuechart-line-1']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-title-text chart-lables']";
    private String totalThreadsRunningYaxisTitle="xpath=//div[@id='apexchartsvuechart-line-1']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-yaxis-title-text chart-lables']";
    private String totalThreadsRunningToolTipTitle="xpath=//div[@id='apexchartsvuechart-line-1']/ancestor::div[@class='chart-box']/descendant::div[@class='apexcharts-tooltip-title']";
    private String totalThreadsRunningTooltipValue="xpath=//div[@id='apexchartsvuechart-line-1']/ancestor::div[@class='chart-box']/descendant::div[@class='apexcharts-tooltip-text']";


    private String calendarValue = "xpath = //div[@class='selected-text ellipsis bg-text']";

    public MysqlConnectionsPage(Page page)
    {
        this.page = page;
    }

    public List<String> allWidgetXPoints(){
        ArrayList<String> xPoint = new ArrayList<String>();
        xPoint.add(totalThreadsConnectedXaxisLines);
        xPoint.add(totalThreadsRunningXaxisLines);
        return xPoint;
    }

    public List<String> allWidgetXValues(){
        ArrayList<String> xValue = new ArrayList<String>();
        xValue.add(totalThreadsConnectedXaxisValues);
        xValue.add(totalThreadsRunningXaxisValues);
        return xValue;
    }

    public void navigateToMysqlDatabase()throws EncryptedDocumentException, IOException {
        String database = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.mySqlSheet, "Database");
        util.selectTheOptionFromDropDownBySearch(page, selectDatabaseDropdown, DatabaseSearchboxInputField, database, DatabaseSearchResults);
    }
    public void navigateToConnectionsTab() {
        page.locator(connectionsTab).click();
        page.waitForSelector(totalThreadsConnectedWidgetTitle);
        Assert.assertTrue(page.locator(connectionsTab).isVisible());
    }

    public void selectServiceFromDropDown() throws IOException {
        String service = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.mySqlSheet, "Service");
        util.selectTheOptionFromDropDownBySearch(page, selectServiceDropdown, ServiceSearchboxInputField, service, ServiceSearchResults);
    }

    public void selectNodeFromDropDown() throws IOException {
        String node = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.mySqlSheet, "Node");
        util.selectTheOptionFromDropDownBySearch(page, nodeDropDown, nodeSearhInputField, node, nodeSearchResults);
    }

    public void validateConnectionsTabTitle(String expectedTitle) {
        String actualTitle = page.locator(connectionsTab).textContent().trim();
        util.ValidateTheTitle(actualTitle, expectedTitle);
    }
    public void validateSessionDetailsTableTitle(String expectedTitle) {
        String actualTitle = page.locator(sessionDetails).textContent().trim();
        util.ValidateTheTitle(actualTitle, expectedTitle);
    }

    public void validateSessionDetailsTableUserNameTitleHeaderTitle(String expectedTitle) {
        String actualTitle = page.locator(userName).textContent().trim();
        util.ValidateTheTitle(actualTitle, expectedTitle);
    }

    public void valiatetSessionDetailsTableQueryExecutedHeaderTitle(String expectedTitle) {
        String actualTitle = page.locator(queryExecuted).textContent().trim();
        util.ValidateTheTitle(actualTitle, expectedTitle);
    }

    public void validateSessiondetailsTableTimeStampHeaderTitle(String expectedTitle) {
        String actualTitle = page.locator(timeStamp).textContent().trim();
        util.ValidateTheTitle(actualTitle, expectedTitle);
    }

    public void validateSessiondetailsTableDeadLockHeaderTitle(String expectedTitle) {
        String actualTitle = page.locator(deadLock).textContent().trim();
        util.ValidateTheTitle(actualTitle, expectedTitle);
    }

    public void validateTotalThreadsConnectedWidvalidateTitle(String expectedTitle) {
        String actualTitle = page.locator(totalThreadsConnectedWidgetTitle).textContent().trim();
        util.ValidateTheTitle(actualTitle, expectedTitle);
    }

    public void validateTotalThreadsConnectedZoomOutBtn() {
        util.graphZoomOut(page, totalThreadsConnectedZoomInBtn, totalThreadsConnectedZoomOutBtn, totalThreadsConnectedResetBtn, allWidgetXPoints());
    }

    public void validateTotalThreadsConnectedZoomInBtn() {
        util.graphZoomIn(page, totalThreadsConnectedZoomInBtn, totalThreadsConnectedResetBtn, allWidgetXPoints());
    }

    public void validateTotalThreadsConnectedResetBtn() {
        util.graphZoomReset(page, totalThreadsConnectedZoomInBtn, totalThreadsConnectedResetBtn, allWidgetXPoints());
    }

    public void validateTotalThreadsConnectedDragDrop() {
        util.graphZoomInByDragAndDrop(page, totalThreadsConnectedXaxisLines, totalThreadsConnectedResetBtn, allWidgetXPoints());
    }

    public void validateTotalThreadsConnectedXaxisValues() {
    	page.locator(totalThreadsConnectedWidgetTitle).scrollIntoViewIfNeeded();
        util.validateTheGraphdisplayingTheDataAsPerGivenTimeLines(page, totalThreadsConnectedXaxisValues, calendarValue, allWidgetXValues());
    }

    public void validateTotalThreadsConnectedXaxisTitle(String expectedTitle) {
        String actualTitle = page.locator(totalThreadsConnectedXaxisTitle).textContent().trim();
        util.ValidateTheTitle(actualTitle, expectedTitle);
    }

    public void validateTotalThreadsConnectedYaxisTitle(String expectedTitle) {
        String actualTitle = page.locator(totalThreadsConnectedYaxisTitle).textContent().trim();
        util.ValidateTheTitle(actualTitle, expectedTitle);
    }

    public void validateTotalThreadsConnectedtoolTipTitle(){
    	page.locator(totalThreadsConnectedWidgetTitle).scrollIntoViewIfNeeded();
    	util.validateWidgetToolTips(page, totalThreadsConnectedXaxisLines, totalThreadsConnectedToolTipTitle);
    }

    public void validateTotalThreadsRunningWidvalidateTitle(String expectedTitle) {
        String actualTitle = page.locator(totalThreadsRunningWidgetTitle).textContent().trim();
        util.ValidateTheTitle(actualTitle, expectedTitle);
    }

    public void validateTotalThreadsRunningZoomOutBtn() {
        util.graphZoomOut(page, totalThreadsRunningZoomInBtn, totalThreadsRunningZoomOutBtn, totalThreadsRunningResetBtn, allWidgetXPoints());
    }

    public void validateTotalThreadsRunningZoomInBtn() {
        util.graphZoomIn(page, totalThreadsRunningZoomInBtn, totalThreadsRunningResetBtn, allWidgetXPoints());
    }

    public void validateTotalThreadsRunningResetBtn() {
        util.graphZoomReset(page, totalThreadsRunningZoomInBtn, totalThreadsRunningResetBtn, allWidgetXPoints());
    }

    public void validateTotalThreadsRunningDragDrop() {
        util.graphZoomInByDragAndDrop(page, totalThreadsRunningXaxisLines, totalThreadsRunningResetBtn, allWidgetXPoints());
    }

    public void validateTotalThreadsRunningXaxisValues() {
        util.validateTheGraphdisplayingTheDataAsPerGivenTimeLines(page, totalThreadsRunningXaxisValues, calendarValue, allWidgetXValues());
    }

    public void validateTotalThreadsRunningXaxisTitle(String expectedTitle) {
        String actualTitle = page.locator(totalThreadsRunningXaxisTitle).textContent().trim();
        util.ValidateTheTitle(actualTitle, expectedTitle);
    }

    public void validateTotalThreadsRunningYaxisTitle(String expectedTitle) {
        String actualTitle = page.locator(totalThreadsRunningYaxisTitle).textContent().trim();
        util.ValidateTheTitle(actualTitle, expectedTitle);
    }

    public void validateTotalThreadsRunningtoolTipTitle(){
        util.validateWidgetToolTips(page, totalThreadsRunningXaxisLines, totalThreadsRunningToolTipTitle);
    }

    public void validateTheCustomTimeLine(String period)
    {
        util.validateCustomTimeLine(page,totalThreadsConnectedXaxisValues,period,allWidgetXValues());
    }

}
