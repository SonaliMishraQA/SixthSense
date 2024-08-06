package objectRepository.DBM;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import genericUtilities.GenericMethods;
import objectRepository.CommonPage;


public class PostgresHardware {
    Page page;
	GenericMethods util=new GenericMethods();
    CommonPage comPage = new CommonPage(page);



private String dataBaseNavigationBtn = "xpath = //div[@id='side-nav-database']";
private String dataBasePageTitle = "#title-text-database";
private String dataBaseTypeDropDown = "#btn-arrow-down-search-select-database-type";
private String dataBaseTypeTextField = "#input-search-sel-search-select-database-type";
private String firstDbTypeFromDropDown = "xpath = //span[@id='search-select-database-type-0-single']";
private String selectedDbType = "xpath =//*[@id='search-select-database-type']/div";
private String serviceDropDown = "#btn-arrow-down-search-select-database-service";
private String serviceTextField = "#input-search-sel-search-select-database-service";
private String firstServiceFromDropDown = "xpath = //span[@id='search-select-database-service-0-single']";
private String selectedDbService = "xpath = //*[@id='search-select-database-service']/div";
private String dataBaseDropDown = "#btn-arrow-down-search-select-database-instance";
private String dataBaseTextField = "#input-search-sel-search-select-database-instance";
private String databseInOption = "xpath = //*[@id='search-select-database-instance-0-single']";
private String selecteddatabase = "xpath = //*[@id='search-select-database-instance']/div";
private String firstDbFromDropDown = "xpath = //span[@id='search-select-database-instance-0-single']";
private String hardWareTab = "xpath = //div[@class='navtab']/child::div[@class='item' and position()=1]/child::div";
private String queryPerformanceTab = "xpath = //div[@class='navtab navtab']/child::div[@class='item' and position()=2]/child::div";
private String connectionsTab = "xpath = //div[@class='navtab navtab']/child::div[@class='item' and position()=3]/child::div";
private String metricsTab = "xpath = //div[@class='navtab navtab']/child::div[@class='item' and position()=4]/child::div";

//*********************************************       Hard ware page        ********************************* */
private String typeOfOsLegend = "xpath = //div[@class='wrapper-card']/child::div[@class='card-element' and position()=1]/descendant::div[@class='textLabel']";
private String hostNameLegend = "xpath = //div[@class='wrapper-card']/child::div[@class='card-element' and position()=3]/descendant::div[@class='textLabel']";
private String architectureLegend = "xpath = //div[@class='wrapper-card']/child::div[@class='card-element' and position()=2]/descendant::div[@class='textLabel']";
private String availabilityLegend = "xpath = //div[@class='wrapper-card']/child::div[@class='card-element' and position()=4]/descendant::div[@class='textLabel']";
private String averageCpuUsageLegend = "xpath = //div[@class='wrapper-card-storage']/descendant::div[@class='textLabel'][position()=1]";
private String averageMemoryUsageLegend = "xpath = //div[@class='wrapper-card-storage']/descendant::div[@class='textLabel'][position()=2]";
private String typeOfOsValue = "xpath = //div[@class='textLabel' and text()='Type of OS ']/preceding-sibling::div[@class='textVal fair']";
private String architectureValue = "xpath = //div[@class='textLabel' and text()='Architecture ']/preceding-sibling::div[@class='textVal fair']";
private String hostNameValue = "xpath = //div[@class='textLabel' and text()='Host name ']/preceding-sibling::div[@class='textVal fair']";
private String availabilityValue = "xpath = //div[@class='textLabel' and text()='Availability ']/preceding-sibling::div[@class='textVal fair']";
private String averageCpuUsageValue = "xpath = //div[@class='textLabel' and text()='Average CPU usage(%) ']/preceding-sibling::div[@class='textVal fair']";
private String averageMemoryUsageValue = "xpath = //div[@class='textLabel' and text()='Average memory usage(bytes) ']/preceding-sibling::div[@class='textVal fair']"; 

private String diskUsageCardTitle = "xpath = //div[@class='card-header']";
private String diskUsageCardNodataText = "xpath = //div[@class='no-data-icon']/descendant::div[@class='inner-text']";
private String diskUsageApplicationText = "xpath = //div[@class='progress-header-content-identifier']";
private String storageUsageValue = "xpath = //div[@class='progress-info']/child::div[position()=1]/child::div[@class='progress-info-content-identifier-value']";
private String storageUsageLegend = "xpath = //div[@class='progress-info']/child::div[position()=1]/child::div[@class='progress-info-content-identifier']";
private String storageAvailableLegend = "xpath = //div[@class='progress-info']/child::div[position()=2]/child::div[@class='progress-info-content-identifier']";
private String storageAvailableValue = "xpath = //div[@class='progress-info']/child::div[position()=2]/child::div[@class='green-color-text']";
private String cpuUsageWidgetTitle = "xpath = //div[@class='wrapper']/descendant::div[@class='line-title'][position()=1]";
private String cpuUsageZoomOutBtn = "xpath = //span[@id='CPU-usage-zoom-out']";
private String cpuUsageZoomInBtn = "xpath = //span[@id='CPU-usage-zoom-in']";
private String cpuUsageResetBtn = "xpath = //span[@id='CPU-usage-zoom-reset']";
private String cpuUsageXaxisLines = "xpath = //div[@id='apexchartsvuechart-line-0']/ancestor::div[@class='chart-line']/descendant::*[name()='line' and @class='apexcharts-xaxis-tick']";

private String cpuUsageXaxisValues = "xpath = //div[@id='apexchartsvuechart-line-0']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-label apexcharts-xaxis-label']/child::*[name()='tspan' and contains(text(),'-')]";
private String cpuUsageXaxisTitle = "xpath = //div[@id='apexchartsvuechart-line-0']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-title-text chart-lables']";
private String cpuUsageYaxisTitle = "xpath = //div[@id='apexchartsvuechart-line-0']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-yaxis-title-text chart-lables']";
private String cpuUsageToolTipTitle = "xpath = //div[@id='apexchartsvuechart-line-0']/ancestor::div[@class='chart-box']/descendant::div[@class='apexcharts-tooltip-title']";
private String cpuUsageTooltipValue = "xpath = //div[@id='apexchartsvuechart-line-0']/ancestor::div[@class='chart-box']/descendant::div[@class='apexcharts-tooltip-text']";
private String bulkOperationsXaxisValues = "xpath = //div[@id='apexchartsvuechart-line-0']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-label apexcharts-xaxis-label']/child::*[name()='tspan' and contains(text(),'-')]" ;


private String memoryUsageWidgetTitle = "xpath = //div[@class='wrapper']/descendant::div[@class='line-title'][position()=2]";
private String memoryUsageZoomOutBtn = "#Memory-usage-zoom-out";
private String memoryUsageZoomInBtn = "#Memory-usage-zoom-in";
private String memoryUsageResetBtn = "#Memory-usage-zoom-reset";
private String memoryUsageXaxisLines = "xpath = //div[@id='apexchartsvuechart-line-1']/ancestor::div[@class='chart-line']/descendant::*[name()='line' and @class='apexcharts-xaxis-tick']";
private String memoryUsageXaxisTitle = "xpath = //div[@id='apexchartsvuechart-line-1']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-title-text chart-lables']";
private String memoryUsageYaxisTitle = "xpath = //div[@id='apexchartsvuechart-line-1']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-yaxis-title-text chart-lables']";
private String memoryUsageToolTipTitle = "xpath = //div[@id='apexchartsvuechart-line-1']/ancestor::div[@class='chart-box']/descendant::div[@class='apexcharts-tooltip-title']";
private String memoryUsageTooltipValue = "xpath = //div[@id='apexchartsvuechart-line-1']/ancestor::div[@class='chart-box']/descendant::div[@class='apexcharts-tooltip-text']";
private String memoryUsageXaxisValues = "xpath = //div[@id='apexchartsvuechart-line-1']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-label apexcharts-xaxis-label']/child::*[name()='tspan' and contains(text(),'-')]";


private String networkIOWidgetTitle = "xpath = //div[@class='wrapper']/descendant::div[@class='line-title'][position()=3]";
private String networkIOZoomOut = "#Network-I\\/O-zoom-out";
//private String networkIOZoomIn = "#Network-I/O-zoom-in";
private String networkIOZoomIn = "#Network-I\\/O-zoom-in";
private String networkIOReset = "#Network-I\\/O-zoom-reset";
private String networkIOXaxisLines = "xpath = //div[@id='apexchartsvuechart-line-2']/ancestor::div[@class='chart-line']/descendant::*[name()='line' and @class='apexcharts-xaxis-tick']";
private String networkIOXaxisTitle = "xpath = //div[@id='apexchartsvuechart-line-2']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-title-text chart-lables']";
private String networkIOYaxisTitle = "xpath = //div[@id='apexchartsvuechart-line-2']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-yaxis-title-text chart-lables']";
private String networkIOToolTipTitle = "xpath = //div[@id='apexchartsvuechart-line-2']/ancestor::div[@class='chart-box']/descendant::div[@class='apexcharts-tooltip-title']";
private String networkIOToolTipLabelList = "xpath = //div[@id='apexchartsvuechart-line-2']/ancestor::div[@class='chart-box']/descendant::div[@class='apexcharts-tooltip-series-group apexcharts-active' and not(contains(@style,'none;'))]/descendant::span[@class='apexcharts-tooltip-text-y-label']";
private String networkIOToolTipValueList = "xpath = //div[@id='apexchartsvuechart-line-2']/ancestor::div[@class='chart-box']/descendant::span[@class='apexcharts-tooltip-text-y-value']";
private String netWorkIOWidgetLegendsList  = "xpath = //div[@id='apexchartsvuechart-line-2']/ancestor::div[@class='chart-line']/descendant::span[@class='apexcharts-legend-text']";
private String netWorkIOWidgetLegendsColorList  = "xpath = //div[@id='apexchartsvuechart-line-2']/ancestor::div[@class='chart-line']/descendant::div[@class='apexcharts-legend-series']/child::span[@class='apexcharts-legend-marker']";
private String netwrokIOWidgetLegendsLineList = "xpath = //div[@id='apexchartsvuechart-line-2']//*[name()='g' and @class='apexcharts-series']/*[name()='path']";
private String networkIOWidgetsLegendsToolTipColorList = "xpath = //div[@id='apexchartsvuechart-line-2']/descendant::div[@class='apexcharts-tooltip apexcharts-theme-dark apexcharts-active']/descendant::div[@class='apexcharts-tooltip-series-group apexcharts-active']/descendant::span[@class='apexcharts-tooltip-marker']";
private String networkIOwidgetLegendsActiveToolTipText = "xpath = //div[@id='apexchartsvuechart-line-2']/descendant::div[@class='apexcharts-tooltip apexcharts-theme-dark apexcharts-active']/descendant::div[@class='apexcharts-tooltip-text']/descendant::span[@class='apexcharts-tooltip-text-y-label']";
private String networkIOXaxisValues = "xpath = //div[@id='apexchartsvuechart-line-2']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-label apexcharts-xaxis-label']/child::*[name()='tspan' and contains(text(),'-')]";

private String connectionsAndSessionWidgetTitle = "xpath = //div[@class='wrapper']/descendant::div[@class='line-title'][position()=4]";
private String connectionsAndSessionZoomOut = "#Connections-\\&-sessions-zoom-out";
private String connectionsAndSessionZoomIn = "#Connections-\\&-sessions-zoom-in";
private String connectionsAndSessionReset = "#Connections-\\&-sessions-zoom-reset";
private String connectionsAndSessionXaxisLines  = "xpath = //div[@id='apexchartsvuechart-line-3']/ancestor::div[@class='chart-line']/descendant::*[name()='line' and @class='apexcharts-xaxis-tick']";
private String connectionsAndSessionXaxisTitle = "xpath = //div[@id='apexchartsvuechart-line-3']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-title-text chart-lables']";
private String connectionsAndSessionYaxisTitle = "xpath = //div[@id='apexchartsvuechart-line-3']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-yaxis-title-text chart-lables']";
private String connectionsAndSessionToolTipTitle = "xpath = //div[@id='apexchartsvuechart-line-3']/ancestor::div[@class='chart-box']/descendant::div[@class='apexcharts-tooltip-title']";
private String connectionsAndSessionToolTipLabelList = "xpath = //div[@id='apexchartsvuechart-line-3']/ancestor::div[@class='chart-box']/descendant::span[@class='apexcharts-tooltip-marker' and not(contains(@style,'none;'))]/parent::div[@class='apexcharts-tooltip-series-group apexcharts-active' and not(contains(@style,'none;'))]/descendant::span[@class='apexcharts-tooltip-text-y-label']";
private String connectionsAndSessionToolTipValueList  = "xpath = //div[@id='apexchartsvuechart-line-3']/ancestor::div[@class='chart-box']/descendant::span[@class='apexcharts-tooltip-text-y-value']";
private String connectionsAndSessionWidgetLegendsList  = "xpath = //div[@id='apexchartsvuechart-line-3']/ancestor::div[@class='chart-line']/descendant::span[@class='apexcharts-legend-text']";
private String connectionsAndSessionWidgetActiveToolTipList  = "xpath = //div[@id='apexchartsvuechart-line-3']/descendant::div[@class='apexcharts-tooltip apexcharts-theme-dark apexcharts-active']/descendant::div[@class='apexcharts-tooltip-text']/descendant::span[@class='apexcharts-tooltip-text-y-label']";
private String connectionAndSessionLegendToolTipColorList = "xpath = //div[@id='apexchartsvuechart-line-3']/descendant::div[@class='apexcharts-tooltip apexcharts-theme-dark apexcharts-active']/descendant::div[@class='apexcharts-tooltip-series-group apexcharts-active']/descendant::span[@class='apexcharts-tooltip-marker']";
private String connectionAndSessionLegendsColorList = "xpath = //div[@id='apexchartsvuechart-line-3']/ancestor::div[@class='chart-line']/descendant::div[@class='apexcharts-legend-series']/child::span[@class='apexcharts-legend-marker']";
private String connectionsAndSessionLegendLineList = "xpath = //div[@id='apexchartsvuechart-line-3']//*[name()='g' and @class='apexcharts-series']/*[name()='path']";
private String connectionsAndSessionXaxisValues = "xpath = //div[@id='apexchartsvuechart-line-3']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-label apexcharts-xaxis-label']/child::*[name()='tspan' and contains(text(),'-')]";

private String calanderValue = "xpath = //div[@class='selected-text ellipsis bg-text']";
private String softRefresh ="xpath = //div[@id='btn-refresh']/span";

public PostgresHardware(Page page)
{
    this.page= page;
}

public List<String> allWidgetXPoints()
{
	 ArrayList<String> xPoint = new ArrayList<String>();
	 xPoint.add(networkIOXaxisLines);
	 xPoint.add(memoryUsageXaxisLines);
	 xPoint.add(cpuUsageXaxisLines);
	 xPoint.add(connectionsAndSessionXaxisLines);
	 return xPoint;
}

public List<String> allWidgetXValues()
{
	 ArrayList<String> xValue = new ArrayList<String>();
	 xValue.add(cpuUsageXaxisValues);
	 xValue.add(memoryUsageXaxisValues);
	 xValue.add(networkIOXaxisValues);
	 xValue.add(connectionsAndSessionXaxisValues);
	 return xValue;
}

public String getSoftRefresh() {
    return softRefresh;
}

//validating the page title
public void validateDBMPagetitle(String expectedTitle )
	{
		util.ValidateTheTitle(page, dataBasePageTitle, expectedTitle);
	}
//selecting the DBM type
public void selectDBMtype(String DBMtype ) {
	util.selectTheOptionFromDropDownBySearch(page, dataBaseTypeDropDown, dataBaseTypeTextField, DBMtype, firstDbTypeFromDropDown);
	
}
//validating the selected DBM type
public void validatingtheselectedDBMtype(String expectedDBMtype) {
	String actualDBMtype = page.locator(selectedDbType).textContent().trim();
	Assert.assertEquals(actualDBMtype, expectedDBMtype);
}
//selecting the service
public void selectDbservice(String DBservice) {
	util.selectTheOptionFromDropDownBySearch(page, serviceDropDown, serviceTextField, DBservice, firstServiceFromDropDown);
}
//validating the selected service
public void validateselectedDbservice(String expectedservice) {
	String actualDBMservice = page.locator(selectedDbService).textContent().trim();
	Assert.assertEquals(actualDBMservice, expectedservice);
}
//selecting the database
public void selectdatabse() {
	util.selectTheOptionFromDropDown(page, dataBaseDropDown, databseInOption);
}
//validating the selected database
public void validateselecteddatabse(String expecteddatabse) {
	String actualdatabse = page.locator(selecteddatabase).textContent().trim();
	Assert.assertEquals(actualdatabse, expecteddatabse);
}

//validating the Hardware tab
public void validateHardWareTabIsSelectedByDefault() {
	
	page.waitForSelector(hardWareTab);
	Locator title= page.locator(hardWareTab);
	Assert.assertTrue(title.isVisible());
}


public void getTypeOfOsLegend(String expectedText) {
	page.waitForSelector(typeOfOsLegend);
	Locator legend= page.locator(typeOfOsLegend);
	Assert.assertTrue(legend.isVisible());
    util.ValidateTheTitle(page, typeOfOsLegend, expectedText);
    
}

public void getHostNameLegend(String expectedText) {
	page.waitForSelector(hostNameLegend);
	Locator legend= page.locator(hostNameLegend);
	Assert.assertTrue(legend.isVisible());
	util.ValidateTheTitle(page, hostNameLegend, expectedText);
}

public void getArchitectureLegend(String expectedText) {
	page.waitForSelector(architectureLegend);
	Locator legend= page.locator(architectureLegend);
	Assert.assertTrue(legend.isVisible());
	util.ValidateTheTitle(page, architectureLegend, expectedText);
	
}

public void getAvailabilityLegend(String expectedText) {
	page.waitForSelector(availabilityLegend);
	Locator legend= page.locator(availabilityLegend);
	Assert.assertTrue(legend.isVisible());
	util.ValidateTheTitle(page, availabilityLegend, expectedText);
	
	
}

public void getAverageCpuUsageLegend(String expectedText) {
	page.waitForSelector(averageCpuUsageLegend);
	Locator legend= page.locator(averageCpuUsageLegend);
	Assert.assertTrue(legend.isVisible());
	util.ValidateTheTitle(page, averageCpuUsageLegend, expectedText);
	
}

public void getAverageMemoryUsageLegend(String expectedText) {
	page.waitForSelector(averageMemoryUsageLegend);
	Locator legend= page.locator(averageMemoryUsageLegend);
	Assert.assertTrue(legend.isVisible());
	util.ValidateTheTitle(page, averageMemoryUsageLegend, expectedText);
	
	
}

public void validatingOSTypeWhenNoData(String expectedValue) {
	if(page.locator(typeOfOsValue).isVisible()) 
	util.ValidateTheTitle(page, typeOfOsValue, expectedValue);
	else
	 	   System.out.println("There is data available");
}


public void validatingArchitectureValueWhenNoData(String expectedValue) {
	if(page.locator(architectureValue).isVisible()) 
	util.ValidateTheTitle(page, architectureValue, expectedValue);
	else
	 	   System.out.println("There is data available");
}

public void validatingHostnameValueWhenNoData(String expectedValue) {
	if(page.locator(hostNameValue).isVisible()) 
    util.ValidateTheTitle(page, hostNameValue, expectedValue);
	else
	 	   System.out.println("There is data available");
}

public void validatingAvailabilityValueWhenNoData(String expectedValue) {
	if(page.locator(availabilityValue).isVisible()) 
		util.ValidateTheTitle(page, availabilityValue, expectedValue);
	     else
	 	   System.out.println("There is data available");
}

public void validatingAverageCpuUsageValueWhenNoData(String expectedValue) {
   if(page.locator(averageCpuUsageValue).isVisible()) 
 	 util.ValidateTheTitle(page, averageCpuUsageValue, expectedValue);
     else
 	   System.out.println("There is data available");
}

public void validatingAverageMemoryUsageValueWhenNoData(String expectedValue) {
    if(page.locator(averageMemoryUsageValue).isVisible()) 
    	util.ValidateTheTitle(page, averageMemoryUsageValue, expectedValue);
      else
  	   System.out.println("There is data available");
}

public void validateTheInactiveAvailabilityStatus(String expectedStatus) {
	util.ValidateTheTitle(page, availabilityValue, expectedStatus);
}

public void validateTheActiveAvailabilityStatus(String expectedStatus) {
	util.ValidateTheTitle(page, availabilityValue, expectedStatus);
}

public void getDiskUsageCardTitle(String expectedText) {
    page.waitForSelector(diskUsageCardTitle);
	Locator legend= page.locator(diskUsageCardTitle);
	Assert.assertTrue(legend.isVisible());
	util.ValidateTheTitle(page, diskUsageCardTitle, expectedText);
}

public void getDiskUsageCardNodataText(String expectedValue) {
    if(page.locator(diskUsageCardNodataText).isVisible()) 
    	util.ValidateTheTitle(page, diskUsageCardNodataText, expectedValue);
       else
   	   System.out.println("There is data available");
}


public void getCpuUsageWidgetTitle(String expectedText) {
    page.waitForSelector(cpuUsageWidgetTitle);
	Locator legend= page.locator(cpuUsageWidgetTitle);
	Assert.assertTrue(legend.isVisible());
	util.ValidateTheTitle(page, cpuUsageWidgetTitle, expectedText);
}

public void validateCpuUsageZoomOutBtn() {
   util.graphZoomOut(page, cpuUsageZoomInBtn, cpuUsageZoomOutBtn, cpuUsageResetBtn,allWidgetXPoints());
}

public void validateCpuUsageZoomInBtn() {
    util.graphZoomIn(page, cpuUsageZoomInBtn, cpuUsageResetBtn, allWidgetXPoints());
}

public void validateCpuUsageResetBtn() {
    util.graphZoomReset(page, cpuUsageZoomInBtn, cpuUsageResetBtn, allWidgetXPoints());
}
public void validateCpuUsageDragdrop() {
	util.graphZoomInByDragAndDrop(page, cpuUsageXaxisLines, cpuUsageResetBtn, allWidgetXPoints());
}

public void validateCpuUsageXaxisTitle(String expectedTitle) {
    util.ValidateTheTitle(page, cpuUsageXaxisTitle, expectedTitle);
}

public void validateCpuUsageYaxisTitle(String expectedTitle) {
	util.ValidateTheTitle(page, cpuUsageYaxisTitle, expectedTitle);
}

public void validateCpuUsageToolTipTitle() {
   util.validateWidgetToolTips(page, cpuUsageXaxisLines, cpuUsageToolTipTitle);
}


public void getMemoryUsageWidgetTitle(String expectedText) {
    page.waitForSelector(memoryUsageWidgetTitle);
	Locator legend= page.locator(memoryUsageWidgetTitle);
	Assert.assertTrue(legend.isVisible());
	util.ValidateTheTitle(page, memoryUsageWidgetTitle, expectedText);
	}

public void validateMemoryUsageZoomOutBtn() {
    util.graphZoomOut(page, memoryUsageZoomInBtn, memoryUsageZoomOutBtn, memoryUsageResetBtn, allWidgetXPoints());
}

public void validatetMemoryUsageZoomInBtn() {
    util.graphZoomIn(page, memoryUsageZoomInBtn, memoryUsageResetBtn,allWidgetXPoints());
}

public void validateMemoryUsageResetBtn() {
    util.graphZoomReset(page, memoryUsageZoomInBtn, memoryUsageResetBtn, allWidgetXPoints());
}

public void validateMemoryUsageXaxisTitle(String expectedTitle) {
   util.ValidateTheTitle(page, memoryUsageXaxisTitle, expectedTitle);
}

public void validateMemoryUsageYaxisTitle(String expectedTitle) {
   util.ValidateTheTitle(page, memoryUsageYaxisTitle, expectedTitle); 
}

public void validateMemoryUsageToolTipTitle() {
    util.validateWidgetToolTips(page, memoryUsageXaxisLines, memoryUsageToolTipTitle);
}

public void validateMemoryUsageDragdrop() {
	util.graphZoomInByDragAndDrop(page, memoryUsageXaxisLines, memoryUsageResetBtn, allWidgetXPoints());
}


public void getNetworkIOWidgetTitle(String expectedText) {
    page.waitForSelector(networkIOWidgetTitle);
	Locator legend= page.locator(networkIOWidgetTitle);
	Assert.assertTrue(legend.isVisible());
	util.ValidateTheTitle(page, networkIOWidgetTitle, expectedText);
}

public void validateNetworkIOZoomOut() {
    util.graphZoomOut(page, networkIOZoomIn, networkIOZoomOut, networkIOReset,allWidgetXPoints());
}

public void validateNetworkIOZoomIn() {
   util.graphZoomIn(page, networkIOZoomIn, networkIOReset, allWidgetXPoints()); ;
}

public void validateNetworkIOReset() {
   util.graphZoomReset(page, networkIOZoomIn, networkIOReset,allWidgetXPoints());
}

public void validateNetworkIOXaxisTitle(String expectedTitle) {
    util.ValidateTheTitle(page,networkIOXaxisTitle, expectedTitle);
}

public void validateNetworkIOYaxisTitle(String expectedTitle) {
    util.ValidateTheTitle(page,networkIOYaxisTitle, expectedTitle);
}

public void validateNetworkIOToolTipTitle() {
    util.validateWidgetToolTips(page, networkIOXaxisLines, networkIOToolTipTitle);
}

public void validateNetworkIODragAndDrop() {
	util.graphZoomInByDragAndDrop(page, networkIOXaxisLines, networkIOReset, allWidgetXPoints());
}

public void validateNetworkIOLegendsfunctionality() {
	util.validateWidgetLegends(page, netWorkIOWidgetLegendsList, netWorkIOWidgetLegendsColorList, netwrokIOWidgetLegendsLineList ,networkIOWidgetsLegendsToolTipColorList ,networkIOXaxisLines,networkIOwidgetLegendsActiveToolTipText);
	
}

public void validateConnectionAndSessionLegendsFunctionality() {
	util.validateWidgetLegends(page, connectionsAndSessionWidgetLegendsList, connectionAndSessionLegendsColorList, connectionsAndSessionLegendLineList ,connectionAndSessionLegendToolTipColorList ,connectionsAndSessionXaxisLines,connectionsAndSessionWidgetActiveToolTipList);
	
}

public void validateNetWorkIOWidgetLegendstext(String expectedLegendsList) {
    util.validateWidgetLegendsText(page,netWorkIOWidgetLegendsList,expectedLegendsList);
}

public void getConnectionsAndSessionWidgetTitle(String expectedText) {
    page.waitForSelector(connectionsAndSessionWidgetTitle);
	Locator legend= page.locator(connectionsAndSessionWidgetTitle);
	Assert.assertTrue(legend.isVisible());
	util.ValidateTheTitle(page,connectionsAndSessionWidgetTitle, expectedText);
}

public void validateConnectionsAndSessionZoomOut() {
    util.graphZoomOut(page, connectionsAndSessionZoomIn, connectionsAndSessionZoomOut, connectionsAndSessionReset, allWidgetXPoints());
}

public void validateConnectionsAndSessionZoomIn() {
    util.graphZoomIn(page, connectionsAndSessionZoomIn, connectionsAndSessionReset, allWidgetXPoints());
}

public void validateConnectionsAndSessionReset() {
    util.graphZoomReset(page, connectionsAndSessionZoomIn, connectionsAndSessionReset, allWidgetXPoints());
}

public void validateConnectionsAndSessionXaxisTitle(String expectedText) {
    util.ValidateTheTitle(page, connectionsAndSessionXaxisTitle, expectedText);
}

public void validateConnectionsAndSessionYaxisTitle(String expectedText) {
	util.ValidateTheTitle(page, connectionsAndSessionYaxisTitle, expectedText);
}

public void validateConnectionsAndSessionToolTipTitle() {
   util.validateWidgetToolTips(page, connectionsAndSessionXaxisLines, connectionsAndSessionToolTipTitle);
}

public void validateConnectionsAndSessionsDragAndDrop() {
	util.graphZoomInByDragAndDrop(page, connectionsAndSessionXaxisLines, connectionsAndSessionReset, allWidgetXPoints());
}

public String getConnectionsAndSessionToolTipLabelList() {
    return connectionsAndSessionToolTipLabelList;
}

public String getConnectionsAndSessionToolTipValueList() {
    return connectionsAndSessionToolTipValueList;
}

public void getConnectionsAndSessionWidgetLegendsList(String expectedLegends) {
    util.validateWidgetLegendsText(page,connectionsAndSessionWidgetLegendsList,expectedLegends);
}

public void validateTheGivenTimeLine()
{
	util.validateTheGraphdisplayingTheDataAsPerGivenTimeLines(page,cpuUsageXaxisValues,calanderValue,allWidgetXValues());
}


public void validateTheCustomTimeLine(String period)
{
	util.validateCustomTimeLine(page,cpuUsageXaxisValues,period,allWidgetXValues());
}



    
}