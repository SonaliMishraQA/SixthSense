package objectRepository.DBM;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import genericUtilities.ExcelUtility;
import genericUtilities.GenericMethods;
import objectRepository.CommonPage;


public class PostgresConnections {
    Page page;
	GenericMethods util=new GenericMethods();
    CommonPage comPage = new CommonPage(page);

    

private String connectionsTab ="xpath = //div[contains(@class,'router') and .='Connections ']";
private String sessionDetailsTableTitle ="xpath = //caption[@class='title']" ;
private String sessionDetailsTableHeadreDetails ="xpath = //table[@class='table-container']/descendant::tr/descendant::div";
private String sessionDetailsNoDataText ="xpath = //div[@class='inner-text']";

//************************************* Number of connections**************************** */
private String numberOfConnectionsWidgetTitle = "xpath = //div[@class='wrapper']/descendant::div[@class='line-title'][position()=1]";
private String numberOfConnectionsZoomOut = "#Number-of-connections-zoom-out" ;
private String numberOfConnectionsZoomIn = "#Number-of-connections-zoom-in";
private String numberOfConnectionsReset = "#Number-of-connections-zoom-reset";
private String numberOfConnectionsXaxisLines = "xpath = //div[@id='apexchartsvuechart-line-0']/ancestor::div[@class='chart-line']/descendant::*[name()='line' and @class='apexcharts-xaxis-tick']";
private String numberOfConnectionsXaxisValues = "xpath = //div[@id='apexchartsvuechart-line-0']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-label apexcharts-xaxis-label']/child::*[name()='tspan' and contains(text(),'-')]";
private String numberOfConnectionsXaxisTitle = "xpath = //div[@id='apexchartsvuechart-line-0']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-title-text chart-lables']";
private String numberOfConnectionsYaxisTitle = "xpath = //div[@id='apexchartsvuechart-line-0']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-yaxis-title-text chart-lables']";
private String numberOfConnectionsToolTipTitle = "xpath = //div[@id='apexchartsvuechart-line-0']/ancestor::div[@class='chart-box']/descendant::div[@class='apexcharts-tooltip-title']";
private String numberOfConnectionsToolTipLabelList = "xpath = //div[@id='apexchartsvuechart-line-0']/ancestor::div[@class='chart-box']/descendant::span[@class='apexcharts-tooltip-marker' and not(contains(@style,'none;'))]/parent::div[@class='apexcharts-tooltip-series-group apexcharts-active' and not(contains(@style,'none;'))]/descendant::span[@class='apexcharts-tooltip-text-y-label']";
private String numberOfConnectionsApexVisibleSeries = "xpath = //div[@id='apexchartsvuechart-line-0']/ancestor::div[@class='chart-box']/descendant::*[name()='g' and @class='apexcharts-series']/descendant::*[name()='circle'][position()=1]";
private String numberOfConnectionsApexSeries = "xpath = //div[@id='apexchartsvuechart-line-0']/ancestor::div[@class='chart-box']/descendant::*[name()='g' and @class='apexcharts-series-markers-wrap apexcharts-hidden-element-shown']/descendant::*[name()='circle'][position()=1]";
private String numberOfConnectionsToolTipValueList = "xpath = //div[@id='apexchartsvuechart-line-0']/ancestor::div[@class='chart-box']/descendant::span[@class='apexcharts-tooltip-marker' and not(contains(@style,'none;'))]/parent::div[@class='apexcharts-tooltip-series-group apexcharts-active' and not(contains(@style,'none;'))]/descendant::span[@class='apexcharts-tooltip-text-y-value']";
private String numberOfConnectionsWidgetLegendsList ="xpath = //div[@id='apexchartsvuechart-line-0']/ancestor::div[@class='chart-line']/descendant::span[@class='apexcharts-legend-text']";
private String numberOfConnectionsWidgetLegendsColorList = "xpath = //div[@id='apexchartsvuechart-line-0']/ancestor::div[@class='chart-line']/descendant::span[contains(@class,'apexcharts-legend-marker')]";
private String numberOfConnectionsWidgetActiveLegendsList = "xpath = //div[@id='apexchartsvuechart-line-0']/descendant::div[@class='apexcharts-tooltip apexcharts-theme-dark apexcharts-active']/descendant::div[@class='apexcharts-tooltip-text']/descendant::span[@class='apexcharts-tooltip-text-y-label']";
private String numberOfConWidgetActiveLegendsColorList = "xpath = //div[@id='apexchartsvuechart-line-0']/ancestor::div[@class='chart-line']/descendant::div[@class='apexcharts-legend-series']/child::span[@class='apexcharts-legend-marker']";
private String numberOfConWidgetLegendLineList ="xpath = //div[@id='apexchartsvuechart-line-0']//*[name()='g' and @class='apexcharts-series']/*[name()='path']";
private String numberOfConWidgetToolTipLegendColorList = "xpath = //div[@id='apexchartsvuechart-line-0']/descendant::div[@class='apexcharts-tooltip apexcharts-theme-dark apexcharts-active']/descendant::div[@class='apexcharts-tooltip-series-group apexcharts-active']/descendant::span[@class='apexcharts-tooltip-marker']";
private String numberOfSessionWidgetToolTipLegendColorList = "xpath = //div[@id='apexchartsvuechart-line-1']/descendant::div[@class='apexcharts-tooltip apexcharts-theme-dark apexcharts-active']/descendant::div[@class='apexcharts-tooltip-series-group apexcharts-active']/descendant::span[@class='apexcharts-tooltip-marker']";


//************************************* Number of Sessions**************************** */
private String numberOfSessionsWidgetTitle = "xpath = //div[@class='wrapper']/descendant::div[@class='line-title'][position()=2]";
private String numberOfSessionsZoomOut = "#Number-of-sessions-zoom-out";
private String numberOfSessionsZoomIn = "#Number-of-sessions-zoom-in";
private String numberOfSessionsReset = "#Number-of-sessions-zoom-reset";
private String numberOfSessionsXaxisLines = "xpath = //div[@id='apexchartsvuechart-line-1']/ancestor::div[@class='chart-line']/descendant::*[name()='line' and @class='apexcharts-xaxis-tick']";
private String numberOfSessionsXaxisValues = "xpath = //div[@id='apexchartsvuechart-line-1']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-label apexcharts-xaxis-label']/child::*[name()='tspan' and contains(text(),'-')]";
private String numberOfSessionsXaxisTitle = "xpath = //div[@id='apexchartsvuechart-line-1']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-title-text chart-lables']";
private String numberOfSessionsYaxisTitle = "xpath = //div[@id='apexchartsvuechart-line-1']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-yaxis-title-text chart-lables']";
private String numberOfSessionsToolTipTitle = "xpath = //div[@id='apexchartsvuechart-line-1']/ancestor::div[@class='chart-box']/descendant::div[@class='apexcharts-tooltip-title']";
private String numberOfSessionsToolTipLabelList = "xpath = //div[@id='apexchartsvuechart-line-1']/ancestor::div[@class='chart-box']/descendant::span[@class='apexcharts-tooltip-marker' and not(contains(@style,'none;'))]/parent::div[@class='apexcharts-tooltip-series-group apexcharts-active' and not(contains(@style,'none;'))]/descendant::span[@class='apexcharts-tooltip-text-y-label']";
private String numberOfSessionsApexVisibleSeries = "xpath = //div[@id='apexchartsvuechart-line-1']/ancestor::div[@class='chart-box']/descendant::*[name()='g' and @class='apexcharts-series']/descendant::*[name()='circle'][position()=1]";
private String numberOfSessionsApexSeries = "xpath = //div[@id='apexchartsvuechart-line-1']/ancestor::div[@class='chart-box']/descendant::*[name()='g' and @class='apexcharts-series-markers-wrap apexcharts-hidden-element-shown']/descendant::*[name()='circle'][position()=1]";
private String numberOfSessionsToolTipValueList = "xpath = //div[@id='apexchartsvuechart-line-1']/ancestor::div[@class='chart-box']/descendant::span[@class='apexcharts-tooltip-marker' and not(contains(@style,'none;'))]/parent::div[@class='apexcharts-tooltip-series-group apexcharts-active' and not(contains(@style,'none;'))]/descendant::span[@class='apexcharts-tooltip-text-y-value']";
private String numberOfSessionsWidgetLegendsList = "xpath = //div[@id='apexchartsvuechart-line-1']/ancestor::div[@class='chart-line']/descendant::span[@class='apexcharts-legend-text']";
private String numberOfSessionsWidgetLegendsColorList = "xpath = //div[@id='apexchartsvuechart-line-1']/ancestor::div[@class='chart-line']/descendant::span[contains(@class,'apexcharts-legend-marker')]";
private String numberOfSessionsWidgetActiveLegendsList = "xpath = //div[@id='apexchartsvuechart-line-1']/descendant::div[@class='apexcharts-tooltip apexcharts-theme-dark apexcharts-active']/descendant::div[@class='apexcharts-tooltip-text']/descendant::span[@class='apexcharts-tooltip-text-y-label']";
private String numberOfSesWidgetActiveLegendsColorList = "xpath = //div[@id='apexchartsvuechart-line-1']/ancestor::div[@class='chart-line']/descendant::div[@class='apexcharts-legend-series']/child::span[@class='apexcharts-legend-marker']";
private String numberOfSessWidgetLegendLineList ="xpath = //div[@id='apexchartsvuechart-line-1']//*[name()='g' and @class='apexcharts-series']/*[name()='path']";


private String calanderValue = "xpath = //div[@class='selected-text ellipsis bg-text']";


public PostgresConnections(Page page)
{
    this.page= page;
}

public List<String> allWidgetXPoints()
{
	 ArrayList<String> xPoint = new ArrayList<String>();
	 xPoint.add(numberOfSessionsXaxisLines);
	 xPoint.add(numberOfConnectionsXaxisLines);
	 return xPoint;
}

public List<String> allWidgetXValues()
{
	 ArrayList<String> xValue = new ArrayList<String>();
	 xValue.add(numberOfConnectionsXaxisValues);
	 xValue.add(numberOfSessionsXaxisValues);
	 return xValue;
}

public void validateConnectionsTabPresence() {
	page.waitForSelector(connectionsTab);
 	Locator title= page.locator(connectionsTab);
 	Assert.assertTrue(title.isVisible());
    
}

public void validatingNavigationToConnectionsTab() {
	page.waitForSelector(connectionsTab);
	page.locator(connectionsTab).click();
	page.waitForSelector(sessionDetailsTableTitle);
	Locator title = page.locator(sessionDetailsTableTitle);
	Assert.assertTrue(title.isVisible());
	
}


public void validateSessionDetailsTableTitle(String expectedTitle) {
    util.ValidateTheTitle(page, sessionDetailsTableTitle, expectedTitle);;
}


public void validateSessionDetailsTableHeadreDetailColumns(String expectedColumnName) {
	Locator column = page.locator(sessionDetailsTableHeadreDetails);
	boolean flag =false;
	for(int i=0;i<column.count();i++) {
		if(column.nth(i).textContent().trim().equals(expectedColumnName)){
			flag = true;
			break;
		}
	}
	Assert.assertEquals(flag, true);
}


public void validateSessionDetailsNoDataText(String expectedValue) {
   String actualValue = page.locator(sessionDetailsNoDataText).textContent().trim();
   if(page.locator(sessionDetailsNoDataText).isVisible()) 
	   Assert.assertEquals(actualValue, expectedValue);
    else
	   System.out.println("There is data available");
	   }


public void validateNumberOfConnectionsWidgetTitle(String expectedTitle) {
    util.ValidateTheTitle(page, numberOfConnectionsWidgetTitle, expectedTitle); 
    String val = page.locator(numberOfConnectionsWidgetTitle).textContent().trim();
    System.out.print(val);
    System.out.print(expectedTitle);
}


public void validateNumberOfConnectionsZoomOut() {
   util.graphZoomOut(page, numberOfConnectionsZoomIn, numberOfConnectionsZoomOut, numberOfConnectionsReset, allWidgetXPoints());
}


public void validateNumberOfConnectionsZoomIn() {
    util.graphZoomIn(page, numberOfConnectionsZoomIn, numberOfConnectionsReset, allWidgetXPoints());
}


public void validateNumberOfConnectionsReset() {
	util.graphZoomReset(page, numberOfConnectionsZoomIn, numberOfConnectionsReset, allWidgetXPoints());
}


public void validateNumberOfConnectionsDragaDrop() {
    util.graphZoomInByDragAndDrop(page, numberOfConnectionsXaxisLines,numberOfConnectionsReset, allWidgetXPoints());
}



public void validateNumberOfConnectionsXaxisTitle(String expectedTitle) {
   util.ValidateTheTitle(page, numberOfConnectionsXaxisTitle, expectedTitle); 
}


public void validateNumberOfConnectionsYaxisTitle(String expectedTitle) {
   util.ValidateTheTitle(page, numberOfConnectionsYaxisTitle, expectedTitle);
}


public void validateNumberOfConnectionsToolTipTitle() {
   util.validateWidgetToolTips(page, numberOfConnectionsXaxisLines, numberOfConnectionsToolTipTitle);
}

public void validateNumberOfConnectionsWidgetLegendsList(String expectedLegendsList) {
    util.validateWidgetLegendsText(page, numberOfConnectionsWidgetLegendsList, expectedLegendsList);
}


public void validateNumberOfConnectionsWidgetLegendsFunctionality() {
    util.validateWidgetLegends(page, numberOfConnectionsWidgetLegendsList, numberOfConnectionsWidgetLegendsColorList, numberOfConWidgetLegendLineList, numberOfConWidgetToolTipLegendColorList, numberOfConnectionsXaxisLines, numberOfConnectionsWidgetActiveLegendsList);
}


public void validateNumberOfSessionsWidgetTitle(String expectedTitle) {
    util.ValidateTheTitle(page, numberOfSessionsWidgetTitle, expectedTitle);
}


public void validateNumberOfSessionsZoomOut() {
	page.waitForSelector(numberOfSessionsXaxisLines);
    util.graphZoomOut(page, numberOfSessionsZoomIn, numberOfSessionsZoomOut, numberOfSessionsReset, allWidgetXPoints());
}


public void validateNumberOfSessionsZoomIn() {
	page.waitForSelector(numberOfSessionsXaxisLines);
    util.graphZoomIn(page, numberOfSessionsZoomIn, numberOfSessionsReset, allWidgetXPoints());
}


public void validateNumberOfSessionsReset() {
    util.graphZoomReset(page, numberOfSessionsZoomIn, numberOfSessionsReset, allWidgetXPoints());
}


public void validateNumberOfSessionsXaxisDragDrop() {
    util.graphZoomInByDragAndDrop(page, numberOfSessionsXaxisLines, numberOfSessionsReset, allWidgetXPoints());
}


public void validateNumberOfSessionsXaxisTitle(String expectedTitle) {
	
    util.ValidateTheTitle(page, numberOfSessionsXaxisTitle, expectedTitle);
}


public void validateNumberOfSessionsYaxisTitle(String expectedTitle) {
   util.ValidateTheTitle(page, numberOfSessionsYaxisTitle, expectedTitle);
}


public void validateNumberOfSessionsToolTipTitle() {
    util.validateWidgetToolTips(page, numberOfSessionsXaxisLines,numberOfSessionsToolTipTitle);
}


public void validateNumberOfSessionsWidgetLegendsList(String expectedLegendList) {
    util.validateWidgetLegendsText(page, numberOfSessionsWidgetLegendsList, expectedLegendList);
}


public void validateNumberOfSessionsWidgetLegendsFunctionality() {
    util.validateWidgetLegends(page, numberOfSessionsWidgetLegendsList, numberOfSessionsWidgetLegendsColorList, numberOfSessWidgetLegendLineList, numberOfSessionWidgetToolTipLegendColorList, numberOfSessionsXaxisLines, numberOfSessionsWidgetActiveLegendsList);
}

public void validateTheGivenTimeLine()
{
	util.validateTheGraphdisplayingTheDataAsPerGivenTimeLines(page,numberOfConnectionsXaxisValues,calanderValue,allWidgetXValues());
}


public void validateTheCustomTimeLine(String period)
{
	util.validateCustomTimeLine(page,numberOfConnectionsXaxisValues,period,allWidgetXValues());
}



}