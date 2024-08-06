package objectRepository.DBM;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import genericUtilities.GenericMethods;
import objectRepository.CommonPage;

public class PostgresMetrics {
    Page page;
	GenericMethods util=new GenericMethods();
    CommonPage comPage = new CommonPage(page);


private String metricsTab = "xpath = //div[contains(@class,'router') and .='Metrics ']";

//************************************* Bulk operations**************************** */
private String bulkOperationsWidgetTitle = "xpath = //div[@class='wrapper']/descendant::div[@class='line-title'][position()=1]";
private String bulkOperationsZoomOut = "#Bulk-operations-zoom-out";
private String bulkOperationsZoomIn = "#Bulk-operations-zoom-in";
private String bulkOperationsReset = "#Bulk-operations-zoom-reset";
private String bulkOperationsXaxisLines = "xpath = //div[@id='apexchartsvuechart-line-0']/ancestor::div[@class='chart-line']/descendant::*[name()='line' and @class='apexcharts-xaxis-tick']";
private String bulkOperationsXaxisValues = "xpath = //div[@id='apexchartsvuechart-line-0']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-label apexcharts-xaxis-label']/child::*[name()='tspan' and contains(text(),'-')]" ;
private String bulkOperationsXaxisTitle = "xpath = //div[@id='apexchartsvuechart-line-0']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-title-text chart-lables']";
private String bulkOperationsYaxisTitle = "xpath = //div[@id='apexchartsvuechart-line-0']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-yaxis-title-text chart-lables']";
private String bulkOperationsToolTipTitle = "xpath = //div[@id='apexchartsvuechart-line-0']/ancestor::div[@class='chart-box']/descendant::div[@class='apexcharts-tooltip-title']";
private String bulkOperationsToolTipLabelList = "xpath = //div[@id='apexchartsvuechart-line-0']/ancestor::div[@class='chart-box']/descendant::span[@class='apexcharts-tooltip-marker' and not(contains(@style,'none;'))]/parent::div[@class='apexcharts-tooltip-series-group apexcharts-active' and not(contains(@style,'none;'))]/descendant::span[@class='apexcharts-tooltip-text-y-label']";
private String bulkOperationsApexVisibleSeries = "xpath = //div[@id='apexchartsvuechart-line-0']/ancestor::div[@class='chart-box']/descendant::*[name()='g' and @class='apexcharts-series']/descendant::*[name()='circle'][position()=1]";
private String bulkOperationsApexSeries = "xpath = //div[@id='apexchartsvuechart-line-0']/ancestor::div[@class='chart-box']/descendant::*[name()='g' and @class='apexcharts-series-markers-wrap apexcharts-hidden-element-shown']/descendant::*[name()='circle'][position()=1]";
private String bulkOperationsToolTipValueList = "xpath = //div[@id='apexchartsvuechart-line-0']/ancestor::div[@class='chart-box']/descendant::span[@class='apexcharts-tooltip-marker' and not(contains(@style,'none;'))]/parent::div[@class='apexcharts-tooltip-series-group apexcharts-active' and not(contains(@style,'none;'))]/descendant::span[@class='apexcharts-tooltip-text-y-value']";
private String bulkOperationsWidgetLegendsList = "xpath = //div[@id='apexchartsvuechart-line-0']/ancestor::div[@class='chart-line']/descendant::span[@class='apexcharts-legend-text']";
private String bulkOperationsWidgetLegendsColorList = "xpath = //div[@id='apexchartsvuechart-line-0']/ancestor::div[@class='chart-line']/descendant::span[contains(@class,'apexcharts-legend-marker')]";
private String bulkOperationsWidgetActiveLegendsList = "xpath = //div[@id='apexchartsvuechart-line-0']/descendant::div[@class='apexcharts-tooltip-series-group apexcharts-active']/descendant::span[@class='apexcharts-tooltip-text-y-label']";
private String bulkOpWidgetActiveLegendsColorList = "xpath = //div[@id='apexchartsvuechart-line-0']/ancestor::div[@class='chart-line']/descendant::div[@class='apexcharts-legend-series']/child::span[@class='apexcharts-legend-marker']";
private String bulkOperationsLegendsLineList = "xpath = //div[@id='apexchartsvuechart-line-0']//*[name()='g' and @class='apexcharts-series']/*[name()='path']";
private String bulkOperationsLegendsToolTipColorList = "xpath = //div[@id='apexchartsvuechart-line-0']/descendant::div[@class='apexcharts-tooltip apexcharts-theme-dark apexcharts-active']/descendant::span[@class='apexcharts-tooltip-marker']";

//************************************* Confis operations**************************** */
private String confisOperationsWidgetTitle = "xpath = //div[@class='wrapper']/descendant::div[@class='line-title'][position()=2]";
private String confisOperationsZoomOut = "#Confis-operations-zoom-out";
private String confisOperationsZoomIn = "#Confis-operations-zoom-in";
private String confisOperationsReset = "#Confis-operations-zoom-reset";
private String confisOperationsXaxisLines = "xpath = //div[@id='apexchartsvuechart-line-1']/ancestor::div[@class='chart-line']/descendant::*[name()='line' and @class='apexcharts-xaxis-tick']";
private String confisOperationsXaxisTitle = "xpath = //div[@id='apexchartsvuechart-line-1']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-title-text chart-lables']";
private String confisOperationsYaxisTitle = "xpath = //div[@id='apexchartsvuechart-line-1']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-yaxis-title-text chart-lables']";
private String confisOperationsToolTipTitle = "xpath = //div[@id='apexchartsvuechart-line-1']/ancestor::div[@class='chart-box']/descendant::div[@class='apexcharts-tooltip-title']";
private String confisOperationsToolTipLabelList = "xpath = //div[@id='apexchartsvuechart-line-1']/ancestor::div[@class='chart-box']/descendant::span[@class='apexcharts-tooltip-marker' and not(contains(@style,'none;'))]/parent::div[@class='apexcharts-tooltip-series-group apexcharts-active' and not(contains(@style,'none;'))]/descendant::span[@class='apexcharts-tooltip-text-y-label']";
private String confisOperationsApexVisibleSeries = "xpath = //div[@id='apexchartsvuechart-line-1']/ancestor::div[@class='chart-box']/descendant::*[name()='g' and @class='apexcharts-series']/descendant::*[name()='circle'][position()=1]";
private String confisOperationsApexSeries = "xpath = //div[@id='apexchartsvuechart-line-1']/ancestor::div[@class='chart-box']/descendant::*[name()='g' and @class='apexcharts-series-markers-wrap apexcharts-hidden-element-shown']/descendant::*[name()='circle'][position()=1]";
private String confisOperationsToolTipValueList = "xpath = //div[@id='apexchartsvuechart-line-1']/ancestor::div[@class='chart-box']/descendant::span[@class='apexcharts-tooltip-marker' and not(contains(@style,'none;'))]/parent::div[@class='apexcharts-tooltip-series-group apexcharts-active' and not(contains(@style,'none;'))]/descendant::span[@class='apexcharts-tooltip-text-y-value']";
private String confisOperationsWidgetLegendsList = "xpath = //div[@id='apexchartsvuechart-line-1']/ancestor::div[@class='chart-line']/descendant::span[@class='apexcharts-legend-text']";
private String confisOperationsWidgetLegendsColorList = "xpath = //div[@id='apexchartsvuechart-line-1']/ancestor::div[@class='chart-line']/descendant::span[contains(@class,'apexcharts-legend-marker')]";
private String confisOperationsWidgetActiveLegendsList = "xpath = //div[@id='apexchartsvuechart-line-1']/descendant::div[@class='apexcharts-tooltip-series-group apexcharts-active']/descendant::span[@class='apexcharts-tooltip-text-y-label']";
private String confisOpWidgetActiveLegendsColorList = "xpath = //div[@id='apexchartsvuechart-line-1']/ancestor::div[@class='chart-line']/descendant::div[@class='apexcharts-legend-series']/child::span[@class='apexcharts-legend-marker']";
private String confisOperationsLegendsLineList = "xpath = //div[@id='apexchartsvuechart-line-1']//*[name()='g' and @class='apexcharts-series']/*[name()='path']";
private String confisOperationsLegendsToolTipColorList = "xpath = //div[@id='apexchartsvuechart-line-1']/descendant::div[@class='apexcharts-tooltip apexcharts-theme-dark apexcharts-active']/descendant::span[@class='apexcharts-tooltip-marker']";
private String confisOperationsXaxisValues = "xpath = //div[@id='apexchartsvuechart-line-1']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-label apexcharts-xaxis-label']/child::*[name()='tspan' and contains(text(),'-')]" ;



//************************************* Tup operations**************************** */
private String tupOperationsWidgetTitle = "xpath = //div[@class='wrapper']/descendant::div[@class='line-title'][position()=3]";
private String tupOperationsZoomOut = "#Tup-operations-zoom-out";
private String tupOperationsZoomIn = "#Tup-operations-zoom-in";
private String tupOperationsReset = "#Tup-operations-zoom-reset";
private String tupOperationsXaxisLines = "xpath = //div[@id='apexchartsvuechart-line-2']/ancestor::div[@class='chart-line']/descendant::*[name()='line' and @class='apexcharts-xaxis-tick']";
private String tupOperationsXaxisTitle = "xpath = //div[@id='apexchartsvuechart-line-2']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-title-text chart-lables']";
private String tupOperationsYaxisTitle = "xpath = //div[@id='apexchartsvuechart-line-2']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-yaxis-title-text chart-lables']";
private String tupOperationsToolTipTitle = "xpath = //div[@id='apexchartsvuechart-line-2']/ancestor::div[@class='chart-box']/descendant::div[@class='apexcharts-tooltip-title']";
private String tupOperationsApexVisibleSeries = "xpath = //div[@id='apexchartsvuechart-line-2']/ancestor::div[@class='chart-box']/descendant::*[name()='g' and @class='apexcharts-series']/descendant::*[name()='circle'][position()=1]";
private String tupOperationsApexSeries = "xpath = //div[@id='apexchartsvuechart-line-2']/ancestor::div[@class='chart-box']/descendant::*[name()='g' and @class='apexcharts-series-markers-wrap apexcharts-hidden-element-shown']/descendant::*[name()='circle'][position()=1]";
private String tupOperationsToolTipLabelList = "xpath = //div[@id='apexchartsvuechart-line-2']/ancestor::div[@class='chart-box']/descendant::span[@class='apexcharts-tooltip-marker' and not(contains(@style,'none;'))]/parent::div[@class='apexcharts-tooltip-series-group apexcharts-active' and not(contains(@style,'none;'))]/descendant::span[@class='apexcharts-tooltip-text-y-label']";
private String tupOperationsToolTipValueList = "xpath = //div[@id='apexchartsvuechart-line-2']/ancestor::div[@class='chart-box']/descendant::span[@class='apexcharts-tooltip-marker' and not(contains(@style,'none;'))]/parent::div[@class='apexcharts-tooltip-series-group apexcharts-active' and not(contains(@style,'none;'))]/descendant::span[@class='apexcharts-tooltip-text-y-value']";
private String tupOperationsWidgetLegendsList = "xpath = //div[@id='apexchartsvuechart-line-2']/ancestor::div[@class='chart-line']/descendant::span[@class='apexcharts-legend-text']";
private String tupOperationsWidgetLegendsColorList = "xpath = //div[@id='apexchartsvuechart-line-2']/ancestor::div[@class='chart-line']/descendant::span[contains(@class,'apexcharts-legend-marker')]";
private String tupOperationsWidgetActiveLegendsList = "xpath = //div[@id='apexchartsvuechart-line-2']/descendant::div[@class='apexcharts-tooltip-series-group apexcharts-active']/descendant::span[@class='apexcharts-tooltip-text-y-label']";
private String tupOpWidgetActiveLegendsColorList = "xpath = //div[@id='apexchartsvuechart-line-2']/ancestor::div[@class='chart-line']/descendant::div[@class='apexcharts-legend-series']/child::span[@class='apexcharts-legend-marker']";
private String tupOperationsLegendsLineList = "xpath = //div[@id='apexchartsvuechart-line-2']//*[name()='g' and @class='apexcharts-series']/*[name()='path']";
private String tupOperationsLegendsToolTipColorList = "xpath = //div[@id='apexchartsvuechart-line-2']/descendant::div[@class='apexcharts-tooltip apexcharts-theme-dark apexcharts-active']/descendant::span[@class='apexcharts-tooltip-marker']";
private String tupOperationsXaxisValues = "xpath = //div[@id='apexchartsvuechart-line-2']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-label apexcharts-xaxis-label']/child::*[name()='tspan' and contains(text(),'-')]" ;


//************************************* Xact operations**************************** */
private String xactOperationsWidgetTitle = "xpath = //div[@class='wrapper']/descendant::div[@class='line-title'][position()=4]";
private String xactOperationsZoomOut = "#Xact-operations-zoom-out";
private String xactOperationsZoomIn = "#Xact-operations-zoom-in";
private String xactOperationsReset = "#Xact-operations-zoom-reset";
private String xactOperationsXaxisLines = "xpath = xpath = //div[@id='apexchartsvuechart-line-3']/ancestor::div[@class='chart-line']/descendant::*[name()='line' and @class='apexcharts-xaxis-tick']";
private String xactOperationsXaxisTitle = "xpath = //div[@id='apexchartsvuechart-line-3']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-title-text chart-lables']";
private String xactOperationsYaxisTitle = "xpath = //div[@id='apexchartsvuechart-line-3']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-yaxis-title-text chart-lables']";
private String xactOperationsToolTipTitle = "xpath = //div[@id='apexchartsvuechart-line-3']/ancestor::div[@class='chart-box']/descendant::div[@class='apexcharts-tooltip-title']";
private String xactOperationsApexVisibleSeries = "xpath = //div[@id='apexchartsvuechart-line-3']/ancestor::div[@class='chart-box']/descendant::*[name()='g' and @class='apexcharts-series']/descendant::*[name()='circle'][position()=1]";
private String xactOperationsApexSeries = "xpath = //div[@id='apexchartsvuechart-line-3']/ancestor::div[@class='chart-box']/descendant::*[name()='g' and @class='apexcharts-series-markers-wrap apexcharts-hidden-element-shown']/descendant::*[name()='circle'][position()=1]";
private String xactOperationsToolTipLabelList = "xpath = //div[@id='apexchartsvuechart-line-3']/ancestor::div[@class='chart-box']/descendant::span[@class='apexcharts-tooltip-marker' and not(contains(@style,'none;'))]/parent::div[@class='apexcharts-tooltip-series-group apexcharts-active' and not(contains(@style,'none;'))]/descendant::span[@class='apexcharts-tooltip-text-y-label']";
private String xactOperationsToolTipValueList = "xpath = //div[@id='apexchartsvuechart-line-3']/ancestor::div[@class='chart-box']/descendant::span[@class='apexcharts-tooltip-marker' and not(contains(@style,'none;'))]/parent::div[@class='apexcharts-tooltip-series-group apexcharts-active' and not(contains(@style,'none;'))]/descendant::span[@class='apexcharts-tooltip-text-y-value']";
private String xactOperationsWidgetLegendsList = "xpath = //div[@id='apexchartsvuechart-line-3']/ancestor::div[@class='chart-line']/descendant::span[@class='apexcharts-legend-text']";
private String xactOperationsWidgetLegendsColorList = "xpath = //div[@id='apexchartsvuechart-line-3']/ancestor::div[@class='chart-line']/descendant::span[contains(@class,'apexcharts-legend-marker')]";
private String xactOperationsWidgetActiveLegendsList = "xpath = //div[@id='apexchartsvuechart-line-3']/descendant::div[@class='apexcharts-tooltip-series-group apexcharts-active']/descendant::span[@class='apexcharts-tooltip-text-y-label']";
private String xactOpWidgetActiveLegendsColorList = "xpath = //div[@id='apexchartsvuechart-line-3']/ancestor::div[@class='chart-line']/descendant::div[@class='apexcharts-legend-series']/child::span[@class='apexcharts-legend-marker']";
private String xactOperationsLegendsLineList = "xpath = //div[@id='apexchartsvuechart-line-3']//*[name()='g' and @class='apexcharts-series']/*[name()='path']";
private String xactOperationsLegendsToolTipColorList = "xpath = //div[@id='apexchartsvuechart-line-3']/descendant::div[@class='apexcharts-tooltip apexcharts-theme-dark apexcharts-active']/descendant::span[@class='apexcharts-tooltip-marker']";
private String xactOperationsXaxisValues = "xpath = //div[@id='apexchartsvuechart-line-3']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-label apexcharts-xaxis-label']/child::*[name()='tspan' and contains(text(),'-')]" ;

private String calanderValue = "xpath = //div[@class='selected-text ellipsis bg-text']";



public PostgresMetrics(Page page)
{
    this.page= page;
}

public List<String> allWidgetXPoints()
{
	 ArrayList<String> xPoint = new ArrayList<String>();
	 xPoint.add(bulkOperationsXaxisLines);
	 xPoint.add(confisOperationsXaxisLines);
	 xPoint.add(tupOperationsXaxisLines);
	 xPoint.add(xactOperationsXaxisLines);
	 return xPoint;
}

public List<String> allWidgetXValues()
{
	 ArrayList<String> xValue = new ArrayList<String>();
	 xValue.add(bulkOperationsXaxisValues);
	 xValue.add(confisOperationsXaxisValues);
	 xValue.add(tupOperationsXaxisValues);
	 xValue.add(xactOperationsXaxisValues);
	 return xValue;
}

public void validateMetricsTabPresence() {
	page.waitForSelector(metricsTab);
 	Locator title= page.locator(metricsTab);
 	Assert.assertTrue(title.isVisible());
    
}

public void validatingNavigationToMetricsTab() {
	page.waitForSelector(metricsTab);
	page.locator(metricsTab).click();
	page.waitForSelector(bulkOperationsWidgetTitle);
	Locator title = page.locator(bulkOperationsWidgetTitle);
	Assert.assertTrue(title.isVisible());
	
}



public void validateBulkOperationsWidgetTitle(String expectedTitle) {
   util.ValidateTheTitle(page, bulkOperationsWidgetTitle, expectedTitle);
}


public void validateBulkOperationsZoomOut() {
   util.graphZoomOut(page, bulkOperationsZoomIn, bulkOperationsZoomOut, bulkOperationsReset,allWidgetXPoints() );
}

public void validateBulkOperationsZoomIn() {
    util.graphZoomIn(page, bulkOperationsZoomIn, bulkOperationsReset,allWidgetXPoints());
}

public void validateBulkOperationsReset() {
    util.graphZoomReset(page, bulkOperationsZoomIn, bulkOperationsReset,allWidgetXPoints());
}

public void validateBulkOperationsXaxisDragDrop() {
    util.graphZoomInByDragAndDrop(page, bulkOperationsXaxisLines, bulkOperationsReset,allWidgetXPoints());
}

public void validateBulkOperationsXaxisTitleToolTip() {
    util.validateWidgetToolTips(page, bulkOperationsXaxisLines, bulkOperationsToolTipTitle);
}

public void validateBulkOperationsYaxisTitle(String expectedTitle) {
    util.ValidateTheTitle(page, bulkOperationsYaxisTitle, expectedTitle);
}

public void validateBulkOperationsXaxisTitle(String expectedTitle) {
    util.ValidateTheTitle(page, bulkOperationsXaxisTitle, expectedTitle);
}

public void validateBulkOperationsWidgetLegendsList(String expectedLegendsList) {
    util.validateWidgetLegendsText(page, bulkOperationsWidgetLegendsList, expectedLegendsList);
}

public void validateBulkOperationsWidgetLegendsFunctionality() {
    util.validateWidgetLegends(page, bulkOperationsWidgetLegendsList, bulkOperationsWidgetLegendsColorList, bulkOperationsLegendsLineList, bulkOperationsLegendsToolTipColorList, bulkOperationsXaxisLines, bulkOperationsWidgetActiveLegendsList);
}

public void validateConfisOperationsWidgetTitle(String expectedTitle) {
    util.ValidateTheTitle(page, confisOperationsWidgetTitle,expectedTitle );
}

public void validateConfisOperationsZoomOut() {
    util.graphZoomOut(page, confisOperationsZoomIn, confisOperationsZoomOut, confisOperationsReset, allWidgetXPoints());
}


public void validateConfisOperationsZoomIn() {
    util.graphZoomIn(page, confisOperationsZoomIn, confisOperationsReset, allWidgetXPoints());
}

public void validateConfisOperationsReset() {
    util.graphZoomReset(page,confisOperationsZoomIn, confisOperationsReset, allWidgetXPoints());
}

public void validateConfisOperationsXaxisDragDrop() {
util.graphZoomInByDragAndDrop(page, bulkOperationsXaxisLines, bulkOperationsReset,allWidgetXPoints());
}

public void validateConfisOperationsXaxisTitle(String expectedTitle) {
   util.ValidateTheTitle(page, confisOperationsXaxisTitle, expectedTitle);
}

public void validateConfisOperationsYaxisTitle(String expectedTitle) {
    util.ValidateTheTitle(page, confisOperationsYaxisTitle, expectedTitle);
}

public void validateConfisOperationsToolTipTitleHover() {
    util.validateWidgetToolTips(page, confisOperationsXaxisLines,confisOperationsToolTipTitle);
}

public void validateConfisOperationsWidgetLegendsList(String expectedLegendsList) {
    util.validateWidgetLegendsText(page, confisOperationsWidgetLegendsList, expectedLegendsList);
}

public  void validateConfisOperationsWidgetActiveLegendsFunctionality() {
   util.validateWidgetLegends(page, confisOperationsWidgetActiveLegendsList, confisOperationsWidgetLegendsColorList, confisOperationsLegendsLineList, confisOperationsLegendsToolTipColorList, confisOperationsXaxisLines, confisOperationsWidgetActiveLegendsList);
}

public  void validateTupOperationsWidgetTitle(String expectedTitle) {
    util.ValidateTheTitle(page, tupOperationsWidgetTitle, expectedTitle);
}

public  void validateTupOperationsZoomOut() {
    util.graphZoomOut(page, tupOperationsZoomIn, tupOperationsZoomOut, tupOperationsReset, allWidgetXPoints());
}

public  void validateTupOperationsZoomIn() {
    util.graphZoomIn(page, tupOperationsZoomIn, tupOperationsReset, allWidgetXPoints());
}

public  void validateTupOperationsReset() {
    util.graphZoomReset(page, tupOperationsZoomIn, tupOperationsReset, allWidgetXPoints());
}

public void validateTupOperationsXaxisDragDrop() {
util.graphZoomInByDragAndDrop(page, tupOperationsXaxisLines, tupOperationsReset,allWidgetXPoints());
}

public  void validateTupOperationsXaxisTitle(String expectedTitle) {
    util.ValidateTheTitle(page, tupOperationsXaxisTitle, expectedTitle);
}

public  void validateTupOperationsYaxisTitle(String expectedTitle) {
    util.ValidateTheTitle(page, tupOperationsYaxisTitle, expectedTitle);
}

public  void validateTupOperationsToolTipTitleHover() {
    util.validateWidgetToolTips(page, tupOperationsXaxisLines, tupOperationsToolTipTitle);
}

public  void validateTupOperationsWidgetLegendsList(String expectedLegendsList) {
    util.validateWidgetLegendsText(page, tupOperationsWidgetLegendsList, expectedLegendsList);
}

public  void validateTupOperationsWidgetActiveLegendsListFuncationality() {
	util.validateWidgetLegends(page, tupOperationsWidgetLegendsList, tupOperationsWidgetLegendsColorList, tupOperationsLegendsLineList, tupOperationsLegendsToolTipColorList, tupOperationsXaxisLines, tupOperationsWidgetActiveLegendsList);
}

public  void validateXactOperationsWidgetTitle(String expectedTitle) {
	util.ValidateTheTitle(page, xactOperationsWidgetTitle, expectedTitle);
}

public  void validateXactOperationsZoomOut() {
	util.graphZoomOut(page, xactOperationsZoomIn, xactOperationsZoomOut, xactOperationsReset, allWidgetXPoints());
}

public  void validateXactOperationsZoomIn() {
	util.graphZoomIn(page, xactOperationsZoomIn, xactOperationsReset, allWidgetXPoints());
}

public  void validateXactOperationsReset() {
	util.graphZoomReset(page, xactOperationsZoomIn, xactOperationsReset, allWidgetXPoints());
}

public void validateXactOperationsXaxisDragDrop() {
util.graphZoomInByDragAndDrop(page, xactOperationsXaxisLines, xactOperationsReset,allWidgetXPoints());
}

public  void validateXactOperationsXaxisTitle(String expectedTitle) {
	util.ValidateTheTitle(page, xactOperationsXaxisTitle, expectedTitle);
}

public  void validateXactOperationsYaxisTitle(String expectedTitle) {
	util.ValidateTheTitle(page, xactOperationsYaxisTitle, expectedTitle);
}

public  void validateXactOperationsToolTipTitleHover() {
	util.validateWidgetToolTips(page, xactOperationsXaxisLines, xactOperationsToolTipTitle);
}

public  void validateXactOperationsWidgetLegendsList(String expectedLegendsList) {
	util.validateWidgetLegendsText(page, xactOperationsWidgetLegendsList, expectedLegendsList);
}

public  void validateXactOperationsWidgetActiveLegendsFunctionality() {
	util.validateWidgetLegends(page, xactOperationsWidgetActiveLegendsList, xactOperationsWidgetLegendsColorList, xactOperationsLegendsLineList, xactOperationsLegendsToolTipColorList, xactOperationsXaxisLines, xactOpWidgetActiveLegendsColorList);

}

public void validateTheGivenTimeLine()
{
	util.validateTheGraphdisplayingTheDataAsPerGivenTimeLines(page,bulkOperationsXaxisValues,calanderValue,allWidgetXValues());
}


public void validateTheCustomTimeLine(String period)
{
	util.validateCustomTimeLine(page,bulkOperationsXaxisValues,period,allWidgetXValues());
}




    
}