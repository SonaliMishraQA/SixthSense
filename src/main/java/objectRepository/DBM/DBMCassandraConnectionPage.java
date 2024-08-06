package objectRepository.DBM;

import com.microsoft.playwright.Page;
import genericUtilities.ExcelUtility;
import genericUtilities.GenericMethods;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class DBMCassandraConnectionPage {
    Page page;
    ExcelUtility eutil;
    GenericMethods util = new GenericMethods();
    private String selectDatabaseTypeDropDown= "#btn-arrow-down-search-select-database-type";
    private String selectDatabaseTypeTextField = "#input-search-sel-search-select-database-type";
    private String selectServiceDropDown = "#btn-arrow-down-search-select-database-service";
    private String selectServiceTextField = "#input-search-sel-search-select-database-service" ;
    private String connectionsAndSessionsGraphTitle = "xpath = //div[@id='apexchartsvuechart-area-0']/ancestor::div[@class='chart-body']/preceding-sibling::div[@class='line-header']/div[@class='line-title']";
    private String connectionsAndSessionsGraphYaxisTitle = "xpath = //div[@id='apexchartsvuechart-area-0']/descendant::*[name()='g' and @class='apexcharts-yaxis-title']";
    private String connectionsAndSessionsGraphXaxisTitle = "xpath = //div[@id='apexchartsvuechart-area-0']/descendant::*[name()='g' and @class='apexcharts-xaxis-title']";
    private String connectionsAndSessionsGraphZoomOutBtn = "#Connections-&-Sessions-zoom-out";
    private String connectionsAndSessionsGraphZoomInBtn = "#Connections-&-Sessions-zoom-in";
    private String connectionsAndSessionsGraphZoomResetBtn = "#Connections-&-Sessions-zoom-reset";
    private String connectionsAndSessionsGraphXaxisPoints = "xpath = //div[@id='apexchartsvuechart-area-0']/descendant::*[name()='line' and @class='apexcharts-xaxis-tick']";
    private String heartbeatXaxisPoints = "xpath = //div[@id='apexchartsvuechart-area-1']/descendant::*[name()='line' and @class='apexcharts-xaxis-tick']";

    private String connectionsAndSessionsGraphTooltipTitle = "xpath = //div[@id='apexchartsvuechart-area-0']/descendant::div[@class='apexcharts-tooltip-title']";
    private String connectionsAndSessionsGraphTooltipLabel = "xpath = //div[@id='apexchartsvuechart-area-0']/descendant::span[@class='apexcharts-tooltip-text-y-label']";
    private String connectionsAndSessionsGraphTooltipValue = "xpath = //div[@id='apexchartsvuechart-area-0']/descendant::span[@class='apexcharts-tooltip-text-y-value']";
    private String connectionsAndSessionsGraphLegends = "xpath = //div[@id='apexchartsvuechart-area-0']/descendant::span[contains(@class,'apexcharts-legend-text')]";
    private String connectionsAndSessionsGraphActiveLegend = "xpath = //div[@id='apexchartsvuechart-area-0']//span[@class='apexcharts-legend-marker']";

    //legends xpaths
    private String connectionsAndSessionsGraphActiveLegendLine = "xpath = //div[@id='apexchartsvuechart-area-0']//*[name()='g' and @class='apexcharts-series']//*[name()='circle']";
    private String connectionsAndSessionsGraphlegendColorList ="xpath= //div[@id='apexchartsvuechart-area-0']/descendant::span[contains(@class,'apexcharts-legend-marker')]";
    private String connectionsAndSessionsGraphLinesList="xpath= //div[@id='apexchartsvuechart-area-0']/descendant::[name()='g' and @class='apexcharts-series']/child::[name()='path' and @fill='none']";
    private String connectionAndSessionGraphToolTipColorList  ="xpath= //div[@id='apexchartsvuechart-area-0']/descendant::div[@class='apexcharts-tooltip apexcharts-theme-dark apexcharts-active']/descendant::span[@class='apexcharts-tooltip-marker']";
    private String xAxisLabelsforconectionsnsessions = "xpath = //div[@id='apexchartsvuechart-area-0']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-label apexcharts-xaxis-label' and contains(.,'-')]";
    private String xAxisLabelsforHeartbeatGraph="//div[@id='apexchartsvuechart-area-1']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-label apexcharts-xaxis-label' and contains(.,'-')]";
    private String heartbeatGraphTitle = "xpath = //div[@id='apexchartsvuechart-area-1']/ancestor::div[@class='chart-body']/preceding-sibling::div[@class='line-header']/div[@class='line-title']";
    private String heartbeatGraphYaxisTitle = "xpath = //div[@id='apexchartsvuechart-area-1']/descendant::*[name()='g' and @class='apexcharts-yaxis-title']";
    private String heartbeatGraphXaxisTitle = "xpath = //div[@id='apexchartsvuechart-area-1']/descendant::*[name()='g' and @class='apexcharts-xaxis-title']";
    private String heartbeatGraphZoomOutBtn = "#Heartbeat-zoom-out";
    private String heartbeatGraphZoomInBtn = "#Heartbeat-zoom-in";
    private String heartbeatGraphZoomResetBtn = "#Heartbeat-zoom-reset";
    private String heartbeatGraphXaxisPoints = "xpath = //div[@id='apexchartsvuechart-area-1']/descendant::*[name()='line' and @class='apexcharts-xaxis-tick']";
    private String heartbeatGraphTooltipTitle = "xpath = //div[@id='apexchartsvuechart-area-1']/descendant::div[@class='apexcharts-tooltip-title']";
    private String heartbeatGraphTooltipLabel = "xpath = //div[@id='apexchartsvuechart-area-1']/descendant::span[@class='apexcharts-tooltip-text-y-label']";
    private String heartbeatGraphLegends = "xpath = //div[@id='apexchartsvuechart-area-1']//span[@class='apexcharts-legend-text']";
    private String heartbeatGraphActiveLegend = "xpath = //div[@id='apexchartsvuechart-area-1']//span[@class='apexcharts-legend-marker']";

    private String heartbeatGraphTooltipValue = "xpath = //div[@id='apexchartsvuechart-area-1']/descendant::span[@class='apexcharts-tooltip-text-y-value']";
    private String heartbeatGraphActiveLegendLine = "xpath = //div[@id='apexchartsvuechart-area-1']//*[name()='g' and @class='apexcharts-series']//*[name()='circle']";

    private String sessionDetailsTitle = "xpath = //table[@class='table-container']/caption[@class='title']";
    private String userNameColumnTitle = "xpath = //table[@class='table-container']//td[@class='header-td'])[1]";
    private String queriesExecutedColumnTitle = "xpath = //table[@class='table-container']//td[@class='header-td'])[2]";
    private String timestampColumnTitle = "xpath = //table[@class='table-container']//td[@class='header-td'])[3]";
    private String calanderValue = "xpath = //div[@class='selected-text ellipsis bg-text']";
    private String  connectionsTab ="xpath = //div[@class='router' and .='Connections ']";
    private String serviceSearchResult ="xpath =//span[contains(@id,'search-select-database-service')]";
    private String dataBaseTypeSearchResult ="xpath = //span[contains(@id,'search-select-database-type')]" ;
    private String SessionDetailsFirstColumnTitle="xpath= //div[@class='header-slot-default' and .='User name']";
    private String SessionDetailsSecondColumnTitle="xpath= //div[@class='header-slot-default' and .='Queries executed']";
    private String SessionDetailsThirdColumnTitle="xpath= //div[@class='header-slot-default' and .='Timestamp']";



    public DBMCassandraConnectionPage(Page page) {
        this.page=page;
    }


    public List<String> allWidgetXaxisLabels()
    {
        ArrayList<String> xLabel = new ArrayList<String>();
        xLabel.add(xAxisLabelsforconectionsnsessions);
        xLabel.add(xAxisLabelsforHeartbeatGraph);
        return xLabel;
    }


    public List<String> allXpoint(){
        ArrayList<String> xpoints = new ArrayList<String>();
        xpoints.add(connectionsAndSessionsGraphXaxisPoints);
        xpoints.add(heartbeatXaxisPoints);
        return xpoints;
    }


    public void selectDatabase(String DatabaseType) {
        util.selectTheOptionFromDropDownBySearch(page, selectDatabaseTypeDropDown, selectDatabaseTypeTextField, DatabaseType, dataBaseTypeSearchResult);
    }

    public void selectservice(String Service) {
        util.selectTheOptionFromDropDownBySearch(page,selectServiceDropDown,selectServiceTextField,Service,serviceSearchResult);
    }


    public void NavigateToConnectionSection() {
        Assert.assertTrue(page.locator(connectionsTab).isVisible());
        page.click(connectionsTab);
    }




    public void validateTheCustomTimeLine(String period)
    {
        util.validateCustomTimeLine(page,xAxisLabelsforconectionsnsessions,period,allWidgetXaxisLabels());
    }

    public void validateTitleOfConnectionsnSessionsGraph(String readDataFromExcelByUsingKeyProperty) {
        Assert.assertTrue(page.locator(connectionsAndSessionsGraphTitle).isVisible());
        Assert.assertEquals(readDataFromExcelByUsingKeyProperty,page.locator(connectionsAndSessionsGraphTitle).innerText());
    }

    public void validateXaxisTitleOfConnectionsnSessionsGraph(String readDataFromExcelByUsingKeyProperty) {
        Assert.assertTrue(page.locator(connectionsAndSessionsGraphXaxisTitle).isVisible());
        Assert.assertEquals(readDataFromExcelByUsingKeyProperty,page.locator(connectionsAndSessionsGraphXaxisTitle).innerText());
    }

    public void validateYaxisTitleOfConnectionsnSessionsGraph(String readDataFromExcelByUsingKeyProperty) {
        Assert.assertTrue(page.locator(connectionsAndSessionsGraphYaxisTitle).isVisible());
        Assert.assertEquals(readDataFromExcelByUsingKeyProperty,page.locator(connectionsAndSessionsGraphYaxisTitle).innerText());
    }


    public void validateFunctionalityOfConnectionsnSessionsGraphZoomIn() {
        util.graphZoomIn(page, connectionsAndSessionsGraphZoomInBtn, connectionsAndSessionsGraphZoomResetBtn,allXpoint() );
    }

    public void validateFunctionalityOfConnectionsnSessionsGraphZoomOut() {
        util.graphZoomOut(page, connectionsAndSessionsGraphZoomInBtn, connectionsAndSessionsGraphZoomOutBtn,connectionsAndSessionsGraphZoomResetBtn,allXpoint() );
    }

    public void validateFunctionalityOfConnectionsnSessionsGraphZoomReset() {
        util.graphZoomReset(page, connectionsAndSessionsGraphZoomInBtn,connectionsAndSessionsGraphZoomResetBtn,allXpoint() );
    }

    public void validateDragnDropOfConnectionsnSessionsGraphZoomIn() {
        util.graphZoomInByDragAndDrop(page,connectionsAndSessionsGraphXaxisPoints ,connectionsAndSessionsGraphZoomResetBtn,allXpoint() );
    }

    public void validate_the_one_legend_name_in_connections_and_sessions(String readDataFromExcelByUsingKeyProperty) {
        util.validateWidgetLegendsText(page, connectionsAndSessionsGraphLegends, readDataFromExcelByUsingKeyProperty);
    }

    public void validateTitleOfhearbeatGraph(String readDataFromExcelByUsingKeyProperty) {
        Assert.assertTrue(page.locator(heartbeatGraphTitle).isVisible());
        Assert.assertEquals(readDataFromExcelByUsingKeyProperty,page.locator(heartbeatGraphTitle).innerText());
    }

    public void validateFunctionalityOfHeartGraphZoomIn() {
        util.graphZoomIn(page, heartbeatGraphZoomInBtn, heartbeatGraphZoomResetBtn,allXpoint() );
    }

    public void validateFunctionalityOfHeartGraphZoomOut() {
        util.graphZoomOut(page, heartbeatGraphZoomInBtn,heartbeatGraphZoomOutBtn, heartbeatGraphZoomResetBtn,allXpoint() );
    }

    public void validateFunctionalityOfHeartGraphZoomReset() {
        util.graphZoomReset(page, heartbeatGraphZoomInBtn, heartbeatGraphZoomResetBtn,allXpoint() );
    }

    public void validateDragnDropFunctionalityOfHeartGraphZoomIn() {
        util.graphZoomInByDragAndDrop(page, heartbeatGraphXaxisPoints, heartbeatGraphZoomResetBtn,allXpoint());
    }

    public void validateTitleOfSessionDetailsSection(String readDataFromExcelByUsingKeyProperty) {
        Assert.assertTrue(page.locator(sessionDetailsTitle).isVisible());
        Assert.assertEquals(readDataFromExcelByUsingKeyProperty,page.locator(sessionDetailsTitle).innerText());
    }

    public void validateFirstColumnTitleOfSessionDetails(String readDataFromExcelByUsingKeyProperty) {
        Assert.assertTrue(page.locator(SessionDetailsFirstColumnTitle).isVisible());
        Assert.assertEquals(readDataFromExcelByUsingKeyProperty,page.locator(SessionDetailsFirstColumnTitle).innerText());
    }

    public void validateSecondColumnTitleOfSessionDetails(String readDataFromExcelByUsingKeyProperty) {
        Assert.assertTrue(page.locator(SessionDetailsSecondColumnTitle).isVisible());
        Assert.assertEquals(readDataFromExcelByUsingKeyProperty,page.locator(SessionDetailsSecondColumnTitle).innerText());

    }

    public void validateThirdColumnTitleOfSessionDetails(String readDataFromExcelByUsingKeyProperty) {
        Assert.assertTrue(page.locator(SessionDetailsThirdColumnTitle).isVisible());
        Assert.assertEquals(readDataFromExcelByUsingKeyProperty,page.locator(SessionDetailsThirdColumnTitle).innerText());
    }

    public void validateTheGivenTimeLine() {
        util.validateTheGraphdisplayingTheDataAsPerGivenTimeLines(page,xAxisLabelsforHeartbeatGraph,calanderValue,allWidgetXaxisLabels());
    }

    public void validateNumberofconnectionsgraphlegend() {
        util.validateWidgetLegends(page,connectionsAndSessionsGraphLegends,connectionsAndSessionsGraphlegendColorList,connectionsAndSessionsGraphLinesList,connectionAndSessionGraphToolTipColorList,connectionsAndSessionsGraphXaxisPoints,connectionsAndSessionsGraphTooltipLabel);
    }
}