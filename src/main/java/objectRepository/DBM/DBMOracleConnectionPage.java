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


public class DBMOracleConnectionPage {

    Page page;
    ExcelUtility eutil = new ExcelUtility();
    GenericMethods util=new GenericMethods();
    DBMOracleHardwarePage hardware;
    CommonPage common;

    private String databaseNavigationBtn= "#side-nav-database";
    private String databasePageTitle = "#title-text-database";
    private String selectDatabaseTypeDropDown= "#btn-arrow-down-search-select-database-type";
    private String selectDatabaseTypeTextField = "#input-search-sel-search-select-database-type";
    private String firstDbTypeFromDropDown ="xpath =//span[@id='search-select-database-type-0-single']";
    private String dataBaseTypeSearchResult ="xpath = //span[contains(@id,'search-select-database-type')]" ;
    private String selectedDatabaseType ="xpath = //div[@id='search-select-database-type']/div[@class='selected-item-text semiBold']";
    private String selectServiceDropDown = "#btn-arrow-down-search-select-database-service";
    private String selectServiceTextField = "#input-search-sel-search-select-database-service" ;
    private String firstServiceFromDropDown = "#search-select-database-service-0-single";
    private String serviceSearchResult ="xpath =//span[contains(@id,'search-select-database-service')]";
    private String  selectedService ="xpath = //div[@id='search-select-database-service']/descendant::div[@class='selected-item-text semiBold']" ;
    private String selectDataBaseDropDown = "#btn-arrow-down-search-select-database-instance";
    private String selectDataBaseTextField = "#input-search-sel-search-select-database-instance" ;
    private String firstDbFromDropDown = "#search-select-database-instance-0-single";
    private String databaseSearchResult= "//span[contains(@id,'search-select-database-instance')]" ;
    private String selectedDatabase ="xpath = //div[@id='search-select-database-instance']/descendant::div[@class='selected-item-text semiBold']";
    private String activeTab="xpath = //div[@class='router activeRouter']";
    private String hardwareTab ="xpath = //div[@class='item' and .=' Hardware ']";
    private String queryPerformanceTab="xpath = //div[@class='item' and .=' Query performance ' or @class='item' and .=' Query Performance ']";
    private String  connectionsTab ="xpath = //div[@class='item' and .='Connections ']";
    private String metricsTab="xpath = //div[@class='item' and .=' Metrics ']" ;

    private String calendarIcon ="xpath = //span[@class='selected-icon']";
    private String selectedTimeLine ="xpath = //div[contains(@class,'selected-text ellipsis')]";

    private String numberofConnectionsGraphTitle = "xpath = //div[@id='apexchartsvuechart-line-0']/ancestor::div[@class='chart-body']/preceding-sibling::div[@class='line-header']/div[@class='line-title']";
    private String numberofConnectionsGraphYaxisTitle = "xpath = //div[@id='apexchartsvuechart-line-0']/descendant::*[name()='g' and @class='apexcharts-yaxis-title']" ;
    private String  numberofConnectionsGraphXaxisTitle ="xpath = //div[@id='apexchartsvuechart-line-0']/descendant::*[name()='g' and @class='apexcharts-xaxis-title']" ;
    private String  numberofConnectionsGraphZoomOutBtn ="id = 'Number-of-connections-zoom-out' " ;
    private String numberofConnectionsGraphZoomInBtn = "id = 'Number-of-connections-zoom-in'";
    private String  numberofConnectionsGraphZoomResetBtn = "id = 'Number-of-connections-zoom-reset'";
    private String numberofConnectionsGraphXaxisPoints = "xpath = //div[@id='apexchartsvuechart-line-0']/descendant::*[name()='line' and @class='apexcharts-xaxis-tick']";
    private String numberofConnectionsGraphTooltipTitle ="xpath = //div[@id='apexchartsvuechart-line-0']/descendant::div[@class='apexcharts-tooltip-title']" ;
    private String numberofConnectionsGraphTooltipLabel = "xpath = //div[@id='apexchartsvuechart-line-0']/descendant::span[@class='apexcharts-tooltip-text-y-label']";
    private String numberofConnectionsGraphTooltipValue = "xpath = //div[@id='apexchartsvuechart-line-0']/descendant::span[@class='apexcharts-tooltip-text-y-value']";
    private String numberofConnectionsGraphLegends = "xpath = //div[@id='apexchartsvuechart-line-0']//span[@class='apexcharts-legend-text']";
    private String AllGraphActiveLegend = "xpath = //div[@id='apexchartsvuechart-line-0']//span[@class='apexcharts-legend-marker']" ;
    private String numberofConnectionsGraphActiveLegendLine = "xpath = //div[@id='apexchartsvuechart-line-0']//*[name()='g' and @class='apexcharts-series']//*[name()='circle']";
    private String ConnectionsnSessionGraphLegendsColorList = "xpath = //div[@id='apexchartsvuechart-line-0']/descendant::span[contains(@class,'apexcharts-legend-marker')]";

    private String NumberofconnectionxAxisLabels = "xpath = //div[@id='apexchartsvuechart-line-0']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-label apexcharts-xaxis-label' and contains(.,'-')]" ;
    private String NumberofSessionsxAxisLabels = "xpath = //div[@id='apexchartsvuechart-line-1']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-label apexcharts-xaxis-label' and contains(.,'-')]" ;
    private String numberofSessionsGraphTitle=  "xpath =  //div[@id='apexchartsvuechart-line-1']/ancestor::div[@class='chart-body']/preceding-sibling::div[@class='line-header']/div[@class='line-title']" ;
    private String numberofSessionsGraphYaxisTitle = "xpath = //div[@id='apexchartsvuechart-line-1']/descendant::*[name()='g' and @class='apexcharts-yaxis-title']" ;
    private String numberofSessionsGraphXaxisTitle  ="xpath = //div[@id='apexchartsvuechart-line-1']/descendant::*[name()='g' and @class='apexcharts-xaxis-title']" ;
    private String numberofSessionsGraphZoomOutBtn ="id = 'Number-of-sessions-zoom-out '" ;
    private String numberofSessionsGraphZoomInBtn = "id = 'Number-of-sessions-zoom-in'";
    private String AlllegendLists ="//div[@id='apexchartsvuechart-line-0']/descendant::span[contains(@class,'apexcharts-legend-text')]";
    private String AllLegendColorList ="//div[@id='apexchartsvuechart-line-0']/descendant::span[contains(@class,'apexcharts-legend-marker')] ";
    private String AllLegendTooltipColor ="//div[@id='apexchartsvuechart-line-0']/descendant::div[@class='apexcharts-tooltip apexcharts-theme-dark apexcharts-active']/descendant::span[@class='apexcharts-tooltip-marker']";
    private String AllLegendToolTipName ="//div[@id='apexchartsvuechart-line-0']/descendant::div[@class='apexcharts-tooltip apexcharts-theme-dark apexcharts-active']/descendant::span[@class='apexcharts-tooltip-text-y-label']";
    private String numberofSessionsGraphZoomResetBtn ="id = 'Number-of-sessions-zoom-reset'";
    private String numberofSessionsGraphXaxisPoints ="xpath = //div[@id='apexchartsvuechart-line-1']/descendant::*[name()='line' and @class='apexcharts-xaxis-tick']";
    private String numberofSessionsGraphTooltipTitle ="xpath = //div[@id='apexchartsvuechart-line-1']/descendant::div[@class='apexcharts-tooltip-title']";
    private String numberofSessionsGraphTooltipLabel ="xpath =//div[@id='apexchartsvuechart-line-1']/descendant::span[@class='apexcharts-tooltip-text-y-label']";
    private String numberofSessionsGraphTooltipValue ="xpath = //div[@id='apexchartsvuechart-line-1']/descendant::span[@class='apexcharts-tooltip-text-y-value']";
    private String numberofSessionsGraphLegends = "xpath = //div[@id='apexchartsvuechart-line-1']//span[@class='apexcharts-legend-text']" ;
    private String numberofSessionsGraphActiveLegend = "xpath = //div[@id='apexchartsvuechart-line-1']//span[@class='apexcharts-legend-marker']" ;
    private String numberofSessionsGraphActiveLegendLine= "xpath = //div[@id='apexchartsvuechart-line-1']//*[name()='g' and @class='apexcharts-series']//*[name()='circle']";

    private String sessionDetailsTitle ="xpath =//table[@class='table-container']/caption[@class='title']";
    private String userNameColumnTitle ="xpath = //table[@class='table-container']//td[@class='header-td'])[1]";
    private String queriesExecutedColumnTitle ="xpath = //table[@class='table-container']//td[@class='header-td'])[2]" ;
    private String timestampColumnTitle ="xpath = //table[@class='table-container']//td[@class='header-td'])[3]";

    private String calanderValue = "xpath = //div[@class='selected-text ellipsis bg-text']";

    private String ConnectionsnsessionsGraphTooltipText = "//div[@id='apexchartsvuechart-line-0']/descendant::div[@class='apexcharts-tooltip-series-group apexcharts-active']/descendant::span[@class='apexcharts-tooltip-text-y-label']";


    public DBMOracleConnectionPage(Page page) {
        this.page=page;
        hardware = new DBMOracleHardwarePage(this.page);
        common = new CommonPage(page);
    }

    public void selectDatabase(String DatabaseType) {
        util.selectTheOptionFromDropDownBySearch(page, selectDatabaseTypeDropDown, selectDatabaseTypeTextField, DatabaseType, dataBaseTypeSearchResult);
    }

    public void selectservice(String Service) {
        util.selectTheOptionFromDropDownBySearch(page,selectServiceDropDown,selectServiceTextField,Service,serviceSearchResult);
    }

    public void selectDatabase1(String DatabaseType) {
        util.selectTheOptionFromDropDownBySearch(page, selectDataBaseDropDown, selectServiceTextField, DatabaseType, databaseSearchResult);
    }

    public void NavigateToConnectionSection() {
        page.click(connectionsTab);
        page.waitForSelector(numberofConnectionsGraphTitle);
        Assert.assertTrue(page.isVisible(numberofConnectionsGraphTitle));
    }

    public List<String> allWidgetXaxisLabels()
    {
        ArrayList<String> xAxisLabel = new ArrayList<String>();
        xAxisLabel.add(NumberofconnectionxAxisLabels);
        xAxisLabel.add(NumberofSessionsxAxisLabels);
        return xAxisLabel;
    }

    public List<String> allWidgetXaxisPoints()
    {
        ArrayList<String> xAxisPoints = new ArrayList<String>();
        xAxisPoints.add(numberofConnectionsGraphXaxisPoints);
        xAxisPoints.add(numberofSessionsGraphXaxisPoints);
        return xAxisPoints;
    }




    public void verify_the_Title_Of_Number_of_connections_Graph(String readDataFromExcelByUsingKeyProperty) throws IOException {
        Assert.assertTrue(page.locator(numberofConnectionsGraphTitle).isVisible());
        Assert.assertEquals(readDataFromExcelByUsingKeyProperty,page.locator(numberofConnectionsGraphTitle).innerText());
    }

    public void verify_the_Xaxis_Title_Of_Number_of_connections_Graph(String readDataFromExcelByUsingKeyProperty) throws IOException {
        Assert.assertTrue(page.locator(numberofConnectionsGraphXaxisTitle).isVisible());
        Assert.assertEquals(readDataFromExcelByUsingKeyProperty,page.locator(numberofConnectionsGraphXaxisTitle).innerText());
    }

    public void verify_the_Yaxis_Title_Of_Number_of_connections_Graph(String readDataFromExcelByUsingKeyProperty) throws IOException {
        Assert.assertTrue(page.locator(numberofConnectionsGraphYaxisTitle).isVisible());
        Assert.assertEquals(readDataFromExcelByUsingKeyProperty,page.locator(numberofConnectionsGraphYaxisTitle).innerText());
    }

    public void validate_Number_of_connections_graph_zoomin() {
        util.graphZoomIn(page, numberofConnectionsGraphZoomInBtn, numberofConnectionsGraphZoomResetBtn,allWidgetXaxisPoints() );
    }

    public void validate_Number_of_connections_graph_zoomOut() {
        util.graphZoomOut(page, numberofConnectionsGraphZoomInBtn,numberofConnectionsGraphZoomOutBtn, numberofConnectionsGraphZoomResetBtn, allWidgetXaxisPoints());
    }

    public void validate_Number_of_connections_graph_zoomReset() {
        util.graphZoomReset(page, numberofConnectionsGraphZoomInBtn, numberofConnectionsGraphZoomResetBtn, allWidgetXaxisPoints());
    }

    public void validate_Number_of_connections_graph_zoomDragnDrop() {
        util.graphZoomInByDragAndDrop(page,numberofConnectionsGraphXaxisPoints,numberofConnectionsGraphZoomResetBtn,allWidgetXaxisPoints());
    }

    public void validate_the_one_legend_name_in_Number_of_connections(String readDataFromExcelByUsingKeyProperty) {
        util.validateWidgetLegendsText(page, numberofSessionsGraphTitle, readDataFromExcelByUsingKeyProperty);
    }

    public void verify_the_Title_Of_Number_of_sessions_Graph(String readDataFromExcelByUsingKeyProperty) throws IOException {
        Assert.assertTrue(page.locator(numberofConnectionsGraphXaxisTitle).isVisible());
        Assert.assertEquals(readDataFromExcelByUsingKeyProperty,page.locator(numberofConnectionsGraphXaxisTitle).innerText());
    }

    public void verify_the_Xaxis_Title_Of_Number_of_sessions_Graph(String readDataFromExcelByUsingKeyProperty) throws IOException {
        Assert.assertTrue(page.locator(numberofSessionsGraphXaxisTitle).isVisible());
        Assert.assertEquals(readDataFromExcelByUsingKeyProperty,page.locator(numberofSessionsGraphXaxisTitle).innerText());
    }

    public void verify_the_Yaxis_Title_Of_Number_of_sessions_Graph(String readDataFromExcelByUsingKeyProperty) throws IOException {
        Assert.assertTrue(page.locator(numberofSessionsGraphXaxisTitle).isVisible());
        Assert.assertEquals(readDataFromExcelByUsingKeyProperty,page.locator(numberofSessionsGraphXaxisTitle).innerText());
    }

    public void validate_Number_of_sessions_graph_zoomin() {
        util.graphZoomIn(page, numberofSessionsGraphZoomInBtn, numberofSessionsGraphZoomResetBtn,allWidgetXaxisPoints() );
    }

    public void validate_Number_of_sessions_graph_zoomOut() {
        util.graphZoomOut(page, numberofSessionsGraphZoomInBtn,numberofSessionsGraphZoomOutBtn, numberofSessionsGraphZoomResetBtn, allWidgetXaxisPoints());
    }

    public void validate_Number_of_sessions_graph_zoomReset() {
        util.graphZoomReset(page, numberofSessionsGraphZoomInBtn, numberofSessionsGraphZoomResetBtn, allWidgetXaxisPoints());
    }

    public void validate_Number_of_sessions_graph_zoomDragnDrop() {
        util.graphZoomInByDragAndDrop(page,numberofSessionsGraphXaxisPoints,numberofSessionsGraphZoomResetBtn,allWidgetXaxisPoints());
    }

    public void verify_the_Title_Of_Number_of_session_details_section(String readDataFromExcelByUsingKeyProperty) {
        Assert.assertTrue(page.locator(sessionDetailsTitle).isVisible());
        Assert.assertEquals(readDataFromExcelByUsingKeyProperty,page.locator(sessionDetailsTitle).innerText());
    }

    public void verify_the_first_column_Of_session_details_table(String readDataFromExcelByUsingKeyProperty) {
        Assert.assertTrue(page.locator(userNameColumnTitle).isVisible());
        Assert.assertEquals(readDataFromExcelByUsingKeyProperty,page.locator(userNameColumnTitle).innerText());
    }

    public void verify_the_second_column_Of_session_details_table(String readDataFromExcelByUsingKeyProperty) {
        Assert.assertTrue(page.locator(queriesExecutedColumnTitle).isVisible());
        Assert.assertEquals(readDataFromExcelByUsingKeyProperty,page.locator(queriesExecutedColumnTitle).innerText());
    }

    public void verify_the_third_column_Of_session_details_table(String readDataFromExcelByUsingKeyProperty) {
        Assert.assertTrue(page.locator(timestampColumnTitle).isVisible());
        Assert.assertEquals(readDataFromExcelByUsingKeyProperty,page.locator(timestampColumnTitle).innerText());
    }

    public void validateTheGivenTimeLine()
    {
        util.validateTheGraphdisplayingTheDataAsPerGivenTimeLines(page,NumberofconnectionxAxisLabels,calanderValue,allWidgetXaxisLabels());
    }


    public void validateTheCustomTimeLine(String period)
    {
        util.validateCustomTimeLine(page,NumberofconnectionxAxisLabels,period,allWidgetXaxisLabels());
    }

    public void validateNumberOfSessionsWidgetLegendsList(String readDataFromExcelByUsingKeyProperty) {
        util.validateWidgetLegendsText(page, numberofSessionsGraphLegends, readDataFromExcelByUsingKeyProperty);
    }

    public void validateNumberofconnectionsgraphlegend() {
        util.validateWidgetLegends(page, AlllegendLists, AllLegendColorList,AllLegendToolTipName ,AllLegendTooltipColor ,numberofConnectionsGraphXaxisPoints,ConnectionsnsessionsGraphTooltipText);
    }
    
    public void validateTheNumberOfActiveConnectionsInConnectionsPage() throws EncryptedDocumentException, NumberFormatException, IOException, SQLException {
    	ResultSet resultSet = hardware.connectToJdbcAndExecuteTheQuery(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.oracleSheet, "dataValidation_query5"));
    	int dbActiveUser = 0;
        int uiActiveUser = 0;
		while (resultSet.next()) {
            // Retrieve data from each row
                dbActiveUser = resultSet.getInt("ACTIVE_USER_CONNECTIONS");
                System.out.println(dbActiveUser);
        }
		common.selectTheTimeLineFromCalender(IPathConstant.fiveMinutesTimeRange);
		NavigateToConnectionSection();
		page.waitForTimeout(300);
        Locator xpoint = page.locator(numberofConnectionsGraphXaxisPoints);
        HoverOptions hoverOpt = new HoverOptions();
        hoverOpt.setForce(true);
        hoverOpt.setPosition(0, -10);
        xpoint.last().hover(hoverOpt);
        page.waitForTimeout(100);
        Locator tooltipName = page.locator(numberofConnectionsGraphTooltipLabel);
        Locator tooltipValue = page.locator(numberofConnectionsGraphTooltipValue);
        for(int i=0; i<tooltipName.count(); i++) {
        	if(tooltipName.nth(i).textContent().trim().equalsIgnoreCase(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.oracleSheet, "Connection_no_of_connection_graph_legend1"))) {
        		uiActiveUser = Integer.parseInt(tooltipValue.nth(i).textContent().trim().replace(".0", ""));
        		break;
        	}
        }
        if(dbActiveUser == uiActiveUser) {
        	System.out.println(uiActiveUser);
        	Assert.assertTrue(dbActiveUser == uiActiveUser);
        }
        else {
        	hoverOpt.setPosition(2, -10);
            xpoint.nth(xpoint.count()-2).hover(hoverOpt);
            page.waitForTimeout(100);
            Locator tooltipName1 = page.locator(numberofConnectionsGraphTooltipLabel);
            Locator tooltipValue1 = page.locator(numberofConnectionsGraphTooltipValue);
            for(int i=0; i<tooltipName1.count(); i++) {
            	if(tooltipName1.nth(i).textContent().trim().equalsIgnoreCase(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.oracleSheet, "Connection_no_of_connection_graph_legend1"))) {
            		uiActiveUser = Integer.parseInt(tooltipValue1.nth(i).textContent().trim().replace(".0", ""));
            		System.out.println(uiActiveUser);
                	Assert.assertTrue(dbActiveUser == uiActiveUser);
            	}
            }
        }
        resultSet.close();
    }
    
    public void validateTheNumberOfInactiveConnectionsInConnectionsPage() throws EncryptedDocumentException, NumberFormatException, IOException, SQLException {
    	ResultSet resultSet = hardware.connectToJdbcAndExecuteTheQuery(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.oracleSheet, "dataValidation_query5"));
    	int dbActiveUser = 0;
        int uiActiveUser = 0;
		while (resultSet.next()) {
            // Retrieve data from each row
                dbActiveUser = resultSet.getInt("INACTIVE_USER_CONNECTIONS");
                System.out.println(dbActiveUser);
        }
		common.selectTheTimeLineFromCalender(IPathConstant.fiveMinutesTimeRange);
		NavigateToConnectionSection();
		page.waitForTimeout(300);
        Locator xpoint = page.locator(numberofConnectionsGraphXaxisPoints);
        HoverOptions hoverOpt = new HoverOptions();
        hoverOpt.setForce(true);
        hoverOpt.setPosition(0, -10);
        xpoint.last().hover(hoverOpt);
        page.waitForTimeout(100);
        Locator tooltipName = page.locator(numberofConnectionsGraphTooltipLabel);
        Locator tooltipValue = page.locator(numberofConnectionsGraphTooltipValue);
        for(int i=0; i<tooltipName.count(); i++) {
        	if(tooltipName.nth(i).textContent().trim().equalsIgnoreCase(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.oracleSheet, "Connection_no_of_connection_graph_legend2"))) {
        		uiActiveUser = Integer.parseInt(tooltipValue.nth(i).textContent().trim().replace(".0", ""));
        		break;
        	}
        }
        if(dbActiveUser == uiActiveUser) {
        	System.out.println(uiActiveUser);
        	Assert.assertTrue(dbActiveUser == uiActiveUser);
        }
        else {
        	hoverOpt.setPosition(2, -10);
            xpoint.nth(xpoint.count()-2).hover(hoverOpt);
            page.waitForTimeout(100);
            Locator tooltipName1 = page.locator(numberofConnectionsGraphTooltipLabel);
            Locator tooltipValue1 = page.locator(numberofConnectionsGraphTooltipValue);
            for(int i=0; i<tooltipName1.count(); i++) {
            	if(tooltipName1.nth(i).textContent().trim().equalsIgnoreCase(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.oracleSheet, "Connection_no_of_connection_graph_legend2"))) {
            		uiActiveUser = Integer.parseInt(tooltipValue1.nth(i).textContent().trim().replace(".0", ""));
            		System.out.println(uiActiveUser);
                	Assert.assertTrue(dbActiveUser == uiActiveUser);
            	}
            }
        }
        resultSet.close();
    }
    
    public void validateTheNumberOfActiveSessionsInConnectionsPage() throws EncryptedDocumentException, NumberFormatException, IOException, SQLException {
    	ResultSet resultSet = hardware.connectToJdbcAndExecuteTheQuery(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.oracleSheet, "dataValidation_query5"));
    	int dbActiveSession = 0;
        int uiActiveSession = 0;
		while (resultSet.next()) {
            // Retrieve data from each row
			dbActiveSession = resultSet.getInt("ACTIVE_SESSION_COUNT");
                System.out.println(dbActiveSession);
        }
		common.selectTheTimeLineFromCalender(IPathConstant.fiveMinutesTimeRange);
		NavigateToConnectionSection();
		page.waitForTimeout(300);
        Locator xpoint = page.locator(numberofSessionsGraphXaxisPoints);
        HoverOptions hoverOpt = new HoverOptions();
        hoverOpt.setForce(true);
        hoverOpt.setPosition(0, -10);
        xpoint.last().hover(hoverOpt);
        page.waitForTimeout(100);
        Locator tooltipName = page.locator(numberofSessionsGraphTooltipLabel);
        Locator tooltipValue = page.locator(numberofSessionsGraphTooltipValue);
        for(int i=0; i<tooltipName.count(); i++) {
        	if(tooltipName.nth(i).textContent().trim().equalsIgnoreCase(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.oracleSheet, "Connection_no_of_sessions_graph_legend1"))) {
        		uiActiveSession = Integer.parseInt(tooltipValue.nth(i).textContent().trim());
        		break;
        	}
        }
        if(dbActiveSession == uiActiveSession) {
        	System.out.println(uiActiveSession);
        	Assert.assertTrue(dbActiveSession == uiActiveSession);
        }
        else {
        	hoverOpt.setPosition(2, -10);
            xpoint.nth(xpoint.count()-2).hover(hoverOpt);
            page.waitForTimeout(100);
            Locator tooltipName1 = page.locator(numberofConnectionsGraphTooltipLabel);
            Locator tooltipValue1 = page.locator(numberofConnectionsGraphTooltipValue);
            for(int i=0; i<tooltipName1.count(); i++) {
            	if(tooltipName1.nth(i).textContent().trim().equalsIgnoreCase(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.oracleSheet, "Connection_no_of_sessions_graph_legend1"))) {
            		uiActiveSession = Integer.parseInt(tooltipValue1.nth(i).textContent().trim());
            		System.out.println(uiActiveSession);
                	Assert.assertTrue(dbActiveSession == uiActiveSession);
            	}
            }
        }
        resultSet.close();
    }
    
    public void validateTheNumberOfAbandonedSessionsInConnectionsPage() throws EncryptedDocumentException, NumberFormatException, IOException, SQLException {
    	ResultSet resultSet = hardware.connectToJdbcAndExecuteTheQuery(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.oracleSheet, "dataValidation_query5"));
    	int dbAbandonedSession = 0;
        int uiAbandonedSession = 0;
		while (resultSet.next()) {
            // Retrieve data from each row
			dbAbandonedSession = resultSet.getInt("ABANDONED_SESSION_COUNT");
                System.out.println(dbAbandonedSession);
        }
		common.selectTheTimeLineFromCalender(IPathConstant.fiveMinutesTimeRange);
		NavigateToConnectionSection();
		page.waitForTimeout(300);
        Locator xpoint = page.locator(numberofSessionsGraphXaxisPoints);
        HoverOptions hoverOpt = new HoverOptions();
        hoverOpt.setForce(true);
        hoverOpt.setPosition(0, -10);
        xpoint.last().hover(hoverOpt);
        page.waitForTimeout(100);
        Locator tooltipName = page.locator(numberofSessionsGraphTooltipLabel);
        Locator tooltipValue = page.locator(numberofSessionsGraphTooltipValue);
        for(int i=0; i<tooltipName.count(); i++) {
        	if(tooltipName.nth(i).textContent().trim().equalsIgnoreCase(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.oracleSheet, "Connection_no_of_sessions_graph_legend2"))) {
        		uiAbandonedSession = Integer.parseInt(tooltipValue.nth(i).textContent().trim());
        		break;
        	}
        }
        if(dbAbandonedSession == uiAbandonedSession) {
        	System.out.println(uiAbandonedSession);
        	Assert.assertTrue(dbAbandonedSession == uiAbandonedSession);
        }
        else {
        	hoverOpt.setPosition(2, -10);
            xpoint.nth(xpoint.count()-2).hover(hoverOpt);
            page.waitForTimeout(100);
            Locator tooltipName1 = page.locator(numberofConnectionsGraphTooltipLabel);
            Locator tooltipValue1 = page.locator(numberofConnectionsGraphTooltipValue);
            for(int i=0; i<tooltipName1.count(); i++) {
            	if(tooltipName1.nth(i).textContent().trim().equalsIgnoreCase(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.oracleSheet, "Connection_no_of_sessions_graph_legend2"))) {
            		uiAbandonedSession = Integer.parseInt(tooltipValue1.nth(i).textContent().trim());
            		System.out.println(uiAbandonedSession);
                	Assert.assertTrue(dbAbandonedSession == uiAbandonedSession);
            	}
            }
        }
        resultSet.close();
    }
}