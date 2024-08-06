package objectRepository.DBM;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import genericUtilities.ExcelUtility;
import genericUtilities.GenericMethods;
import genericUtilities.IPathConstant;

public class DBMCouchbaseNodePage {
	Page page;
	GenericMethods util = new GenericMethods();
	ExcelUtility excel = new ExcelUtility();
	

    private String nodeTab = "xpath = //div[@class='navtab']/child::div[@class='item' and position()=2]/child::div" ;
    private String nodeDropDown = "#btn-arrow-down-search-select-database-instance" ;
    private String nodeSearhInputField = "#input-search-sel-search-select-database-instance";
    private String nodeSearchResults = "xpath = //div[@id='search-select-database-instance']/following-sibling::div/descendant::span[@class='selected-item-text']";
    private String nodeDropdownDefaultValue = "xpath  = //div[@id='search-select-database-instance']/child::div";

    private String nodeName = "xpath = //div[@class='card-body']/child::div[@class='cards' and position()=1]/descendant::div[@class='textLabel']" ;
    private String nodeVersion = "xpath = //div[@class='card-body']/child::div[@class='cards' and position()=2]/descendant::div[@class='textLabel']" ;
    private String nodeStatus = "xpath = //div[@class='card-body']/child::div[@class='cards' and position()=3]/descendant::div[@class='textLabel']" ;
    private String nodeOs = "xpath = //div[@class='card-body']/child::div[@class='cards' and position()=4]/descendant::div[@class='textLabel']" ;
    private String nodeUpTime = "xpath = //div[@class='card-body']/child::div[@class='cards' and position()=5]/descendant::div[@class='textLabel']" ;

    private String nodeNameValue = "xpath = //div[@class='card-body']/child::div[@class='cards' and position()=1]/descendant::div[@class='textVal fair']"  ;
    private String nodeVersionValue = "xpath = //div[@class='card-body']/child::div[@class='cards' and position()=2]/descendant::div[@class='textVal fair']" ;
    private String nodeStatusValue = "xpath = //div[@class='card-body']/child::div[@class='cards' and position()=3]/descendant::div[@class='textVal fair']" ;
    private String nodeOsValue = "xpath = //div[@class='card-body']/child::div[@class='cards' and position()=4]/descendant::div[@class='textVal fair']" ;
    private String nodeUpTimeValue = "xpath = //div[@class='card-body']/child::div[@class='cards' and position()=5]/descendant::div[@class='textVal fair']" ;

    private String nodeUsedText = "xpath = //div[@class='card-color-info']/descendant::div[@class='circle primary' ]/following-sibling::div" ;
    private String nodeAvailableText = "xpath = //div[@class='card-color-info']/descendant::div[@class='circle secondary' ]/following-sibling::div" ;
    private String nodeUsedIcon = "xpath = //div[@class='card-color-info']/descendant::div[@class='circle primary' ]" ;
    private String nodeAvailableIcon = "xpath = //div[@class='card-color-info']/descendant::div[@class='circle secondary' ]" ;

    private String nodeDiskUsageCardTitle = "xpath = //div[@class='card-header']" ;
    private String nodeDiskUsageCardNodataText = "xpath = //div[@class='no-data-icon']/descendant::div[@class='inner-text']" ;
    private String nodeDiskUsageApplicationText = "xpath = //div[@class='progress-header-content-identifier']" ;
    private String nodeStorageUsageValue = "xpath = //div[@class='progress-info']/child::div[position()=1]/child::div[@class='progress-info-content-identifier-value']" ;
    private String nodeStorageUsageLegend = "xpath = //div[@class='progress-info']/child::div[position()=1]/child::div[@class='progress-info-content-identifier']";
    private String nodeStorageAvailableLegend = "xpath = //div[@class='progress-info']/child::div[position()=2]/child::div[@class='progress-info-content-identifier']";
    private String nodeStorageAvailableValue = "xpath = //div[@class='progress-info']/child::div[position()=2]/child::div[@class='green-color-text']" ;
    
    private String nodeCpuUsageWidgetTitle = "xpath = //div[@class='wrapper']/descendant::div[@class='line-title'][position()=1]" ;
    private String nodeCpuUsageZoomOutBtn = "#CPU-usage-zoom-out" ;
    private String nodeCpuUsageZoomInBtn = "#CPU-usage-zoom-in" ;
    private String nodeCpuUsageResetBtn = "#CPU-usage-zoom-reset" ;
    private String nodeCpuUsageXaxisLines = "xpath = //div[text()=' CPU usage']/ancestor::div[@class='chart-line']/descendant::*[name()='line' and @class='apexcharts-xaxis-tick']";
    private String nodeCpuUsageXaxisValues = "xpath = //div[text()=' CPU usage']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-label apexcharts-xaxis-label']/child::*[name()='tspan' and contains(text(),'-')]";
    private String nodeCpuUsageXaxisTitle = "xpath = //div[text()=' CPU usage']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-title-text chart-lables']";
    private String nodeCpuUsageYaxisTitle = "xpath = //div[text()=' CPU usage']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-yaxis-title-text chart-lables']";
    private String nodeCpuUsageToolTipTitle = "xpath = //div[text()=' CPU usage']/ancestor::div[@class='chart-box']/descendant::div[@class='apexcharts-tooltip-title']";
    private String nodeCpuUsageTooltipValue = "xpath = //div[text()=' CPU usage']/ancestor::div[@class='chart-box']/descendant::div[@class='apexcharts-tooltip-text']";

    private String nodeRamUsageWidgetTitle = "xpath = //div[@class='wrapper']/descendant::div[@class='line-title'][position()=2]"  ;
    private String nodeRamUsageZoomOutBtn = "#RAM-usage-zoom-out" ;
    private String nodeRamUsageZoomInBtn = "#RAM-usage-zoom-in" ;
    private String nodeRamUsageResetBtn = "#RAM-usage-zoom-reset" ;
    private String nodeRamUsageXaxisLines = "xpath = //div[text()=' RAM usage']/ancestor::div[@class='chart-line']/descendant::*[name()='line' and @class='apexcharts-xaxis-tick']";
    private String nodeRamUsageXaxisValues = "xpath = //div[text()=' RAM usage']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-label apexcharts-xaxis-label']/child::*[name()='tspan' and contains(text(),'-')]";
    private String nodeRamUsageXaxisTitle = "xpath = //div[text()=' RAM usage']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-title-text chart-lables']";
    private String nodeRamUsageYaxisTitle = "xpath = //div[text()=' RAM usage']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-yaxis-title-text chart-lables']";
    private String nodeRamUsageToolTipTitle = "xpath = //div[text()=' RAM usage']/ancestor::div[@class='chart-box']/descendant::div[@class='apexcharts-tooltip-title']";
    private String nodeRamUsageTooltipValue = "xpath = //div[text()=' RAM usage']/ancestor::div[@class='chart-box']/descendant::div[@class='apexcharts-tooltip-text']";

    private String nodeSwapMemoryWidgetTitle = "xpath = //div[@class='wrapper']/descendant::div[@class='line-title'][position()=3]"  ;
    private String nodeSwapMemoryZoomOutBtn = "#Swap-memory-zoom-out" ;
    private String nodeSwapMemoryZoomInBtn = "#Swap-memory-zoom-in" ;
    private String nodeSwapMemoryResetBtn= "#Swap-memory-zoom-reset" ;
    private String nodeSwapMemoryXaxisLines = "xpath = //div[text()=' Swap memory']/ancestor::div[@class='chart-line']/descendant::*[name()='line' and @class='apexcharts-xaxis-tick']";
    private String nodeSwapMemoryXaxisValues = "xpath = //div[text()=' Swap memory']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-label apexcharts-xaxis-label']/child::*[name()='tspan' and contains(text(),'-')]";
    private String nodeSwapMemoryXaxisTitle = "xpath = //div[text()=' Swap memory']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-title-text chart-lables']";
    private String nodeSwapMemoryYaxisTitle = "xpath = //div[text()=' Swap memory']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-yaxis-title-text chart-lables']";
    private String nodeSwapMemoryToolTipTitle = "xpath = //div[text()=' Swap memory']/ancestor::div[@class='chart-box']/descendant::div[@class='apexcharts-tooltip-title']";
    private String nodeSwapMemoryTooltipValue = "xpath = //div[text()=' Swap memory']/ancestor::div[@class='chart-box']/descendant::div[@class='apexcharts-tooltip-text']";
    
    private String nodeOperationsWidgetTitle = "xpath = //div[@class='wrapper']/descendant::div[@class='line-title'][position()=4]"   ;
    private String nodeOperationsZoomOut = "#Node-operations-zoom-out"  ;
    private String nodeOperationsZoomIn = "#Node-operations-zoom-in"  ;
    private String nodeOperationsReset = "#Node-operations-zoom-reset"  ;
    private String nodeOperationsXaxisLines = "xpath = //div[text()=' Node operations']/ancestor::div[@class='chart-line']/descendant::*[name()='line' and @class='apexcharts-xaxis-tick']";
    private String nodeOperationsXaxisValues = "xpath = //div[text()=' Node operations']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-label apexcharts-xaxis-label']/child::*[name()='tspan' and contains(text(),'-')]" ;
    private String nodeOperationsXaxisTitle = "xpath = //div[text()=' Node operations']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-title-text chart-lables']";
    private String nodeOperationsYaxisTitle = "xpath = //div[text()=' Node operations']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-yaxis-title-text chart-lables']";
    private String nodeOperationsToolTipTitle = "xpath = //div[text()=' Node operations']/ancestor::div[@class='chart-box']/descendant::div[@class='apexcharts-tooltip-title']";
    private String nodeOperationsToolTipTextList = "xpath = //div[text()=' Node operations']/ancestor::div[@class='chart-box']/descendant::span[@class='apexcharts-tooltip-marker' and not(contains(@style,'none;'))]/parent::div[@class='apexcharts-tooltip-series-group apexcharts-active' and not(contains(@style,'none;'))]/descendant::span[@class='apexcharts-tooltip-text-y-label']";
    private String nodeOperationsToolTipColorList = "xpath = //div[text()=' Node operations']/ancestor::div[@class='chart-box']/descendant::span[@class='apexcharts-tooltip-marker' and not(contains(@style,'none;'))]/parent::div[@class='apexcharts-tooltip-series-group apexcharts-active' and not(contains(@style,'none;'))]/descendant::span[@class='apexcharts-tooltip-marker']";
    private String nodeOperationsLegendsLineList = "xpath = //div[text()=' Node operations']/ancestor::div[@class='chart-box']/descendant::*[name()='g' and @class='apexcharts-series']/descendant::*[name()='circle'][position()=1]";
    private String nodeOperationsToolTipValueList = "xpath = //div[text()=' Node operations']/ancestor::div[@class='chart-box']/descendant::span[@class='apexcharts-tooltip-marker' and not(contains(@style,'none;'))]/parent::div[@class='apexcharts-tooltip-series-group apexcharts-active' and not(contains(@style,'none;'))]/descendant::span[@class='apexcharts-tooltip-text-y-value']";
    private String nodeOperationsWidgetLegendsList = "xpath = //div[text()=' Node operations']/ancestor::div[@class='chart-line']/descendant::span[@class='apexcharts-legend-text']";
    private String nodeOperationsWidgetLegendsColorList = "xpath = //div[text()=' Node operations']/ancestor::div[@class='chart-line']/descendant::span[contains(@class,'apexcharts-legend-marker')]";

    private String nodeCurrentItemsWidgetTitle = "xpath = //div[@class='wrapper']/descendant::div[@class='line-title'][position()=5]"  ;
    private String nodeCurrentItemsZoomOutBtn = "#Current-items-zoom-out" ;
    private String nodeCurrentItemsZoomInBtn = "#Current-items-zoom-in" ;
    private String nodeCurrentItemsResetBtn = "#Current-items-zoom-reset" ;
    private String nodeCurrentItemsXaxisLines = "xpath = //div[text()=' Current items']/ancestor::div[@class='chart-line']/descendant::*[name()='line' and @class='apexcharts-xaxis-tick']";
    private String nodeCurrentItemsXaxisValues = "xpath = //div[text()=' Current items']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-label apexcharts-xaxis-label']/child::*[name()='tspan' and contains(text(),'-')]";
    private String nodeCurrentItemsXaxisTitle = "xpath = //div[text()=' Current items']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-title-text chart-lables']";
    private String nodeCurrentItemsYaxisTitle = "xpath = //div[text()=' Current items']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-yaxis-title-text chart-lables']";
    private String nodeCurrentItemsToolTipTitle = "xpath = //div[text()=' Current items']/ancestor::div[@class='chart-box']/descendant::div[@class='apexcharts-tooltip-title']";
    private String nodeCurrentItemsTooltipValue = "xpath = //div[text()=' Current items']/ancestor::div[@class='chart-box']/descendant::div[@class='apexcharts-tooltip-text']";

    private String nodeReplicaWidgetTitle = "xpath = //div[@class='wrapper']/descendant::div[@class='line-title'][position()=6]"  ;
    private String nodeReplicaZoomOutBtn = "#Node-replica-zoom-out" ;
    private String nodeReplicaZoomInBtn = "#Node-replica-zoom-in" ;
    private String nodeReplicaResetBtn = "#Node-replica-zoom-reset" ;
    private String nodeReplicaXaxisLines = "xpath = //div[text()=' Node replica']/ancestor::div[@class='chart-line']/descendant::*[name()='line' and @class='apexcharts-xaxis-tick']";
    private String nodeReplicaXaxisValues = "xpath = //div[text()=' Node replica']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-label apexcharts-xaxis-label']/child::*[name()='tspan' and contains(text(),'-')]";
    private String nodeReplicaXaxisTitle = "xpath = //div[text()=' Node replica']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-title-text chart-lables']";
    private String nodeReplicaYaxisTitle = "xpath = //div[text()=' Node replica']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-yaxis-title-text chart-lables']";
    private String nodeReplicaToolTipTitle = "xpath = //div[text()=' Node replica']/ancestor::div[@class='chart-box']/descendant::div[@class='apexcharts-tooltip-title']";
    private String nodeReplicaTooltipValue = "xpath = //div[text()=' Node replica']/ancestor::div[@class='chart-box']/descendant::div[@class='apexcharts-tooltip-text']";


    private String nodeDocsDataSizeWidgetTitle = "xpath = //div[@class='wrapper']/descendant::div[@class='line-title'][position()=7]"  ;
    private String nodeDocsDataSizeZoomOutBtn = "#Docs-data-size-zoom-out" ;
    private String nodeDocsDataSizeZoomInBtn = "#Docs-data-size-zoom-in" ;
    private String nodeDocsDataSizeResetBtn = "#Docs-data-size-zoom-reset" ;
    private String nodeDocsDataSizeXaxisLines = "xpath = //div[text()=' Docs data size']/ancestor::div[@class='chart-line']/descendant::*[name()='line' and @class='apexcharts-xaxis-tick']";
    private String nodeDocsDataSizeXaxisValues = "xpath = //div[text()=' Docs data size']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-label apexcharts-xaxis-label']/child::*[name()='tspan' and contains(text(),'-')]";
    private String nodeDocsDataSizeXaxisTitle = "xpath = //div[text()=' Docs data size']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-title-text chart-lables']";
    private String nodeDocsDataSizeYaxisTitle = "xpath = //div[text()=' Docs data size']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-yaxis-title-text chart-lables']";
    private String nodeDocsDataSizeToolTipTitle = "xpath = //div[text()=' Docs data size']/ancestor::div[@class='chart-box']/descendant::div[@class='apexcharts-tooltip-title']";
    private String nodeDocsDataSizeTooltipValue = "xpath = //div[text()=' Docs data size']/ancestor::div[@class='chart-box']/descendant::div[@class='apexcharts-tooltip-text']";


    private String nodeMcdMemoryWidgetTitle = "xpath = //div[@class='wrapper']/descendant::div[@class='line-title'][position()=8]"  ;
    private String nodeMcdMemoryZoomOutBtn = "#MCD-memory-zoom-out" ;
    private String nodeMcdMemoryZoomInBtn = "#MCD-memory-zoom-in" ;
    private String nodeMcdMemoryResetBtn = "#MCD-memory-zoom-reset" ;
    private String nodeMcdMemoryXaxisLines = "xpath = //div[text()=' MCD memory']/ancestor::div[@class='chart-line']/descendant::*[name()='line' and @class='apexcharts-xaxis-tick']";
    private String nodeMcdMemoryXaxisValues = "xpath = //div[text()=' MCD memory']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-label apexcharts-xaxis-label']/child::*[name()='tspan' and contains(text(),'-')]";
    private String nodeMcdMemoryXaxisTitle = "xpath = //div[text()=' MCD memory']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-title-text chart-lables']";
    private String nodeMcdMemoryYaxisTitle = "xpath = //div[text()=' MCD memory']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-yaxis-title-text chart-lables']";
    private String nodeMcdMemoryToolTipTitle = "xpath = //div[text()=' MCD memory']/ancestor::div[@class='chart-box']/descendant::div[@class='apexcharts-tooltip-title']";
    private String nodeMcdMemoryTooltipValue = "xpath = //div[text()=' MCD memory']/ancestor::div[@class='chart-box']/descendant::div[@class='apexcharts-tooltip-text']";

    private String calendarValue = "xpath = //div[@class='selected-text ellipsis bg-text']";
    private String softRefresh = "#btn-refresh";

    
    
    public DBMCouchbaseNodePage(Page page) {
    	this.page=page;
	}
    
    public List<String> allWidgetXPoints(){
    	ArrayList<String> xPoint = new ArrayList<String>();
    	xPoint.add(nodeCpuUsageXaxisLines);
    	xPoint.add(nodeRamUsageXaxisLines);
    	xPoint.add(nodeCurrentItemsXaxisLines);
    	xPoint.add(nodeDocsDataSizeXaxisLines);
    	xPoint.add(nodeMcdMemoryXaxisLines);
    	xPoint.add(nodeOperationsXaxisLines);
    	xPoint.add(nodeReplicaXaxisLines);
    	xPoint.add(nodeSwapMemoryXaxisLines);
    	return xPoint;
    }
    
    public List<String> allWidgetXValues(){
    	ArrayList<String> xValue = new ArrayList<String>();
    	xValue.add(nodeCpuUsageXaxisValues);
    	xValue.add(nodeRamUsageXaxisValues);
    	xValue.add(nodeCurrentItemsXaxisValues);
    	xValue.add(nodeDocsDataSizeXaxisValues);
    	xValue.add(nodeMcdMemoryXaxisValues);
    	xValue.add(nodeOperationsXaxisValues);
    	xValue.add(nodeReplicaXaxisValues);
    	xValue.add(nodeSwapMemoryXaxisValues);
    	return xValue;
    }
    
    public void validateTheUpTimeOnNodePage(String expectedNodeUpTimeInSec)
    {
    	page.waitForSelector(nodeUpTimeValue);
    	String actualUptime =  page.locator(nodeUpTimeValue).textContent().trim().replace(" ","");
    	String time = "";
    	int actualUpTimeInSec = 0;
    	for(int i=0;i<actualUptime.length()-1;i++)
    	{
    		if(Character.isDigit(actualUptime.charAt(i)))
    		{
    			time =time+actualUptime.charAt(i);
    			if(actualUptime.charAt(i+1) == 'm')
    			{
    				actualUpTimeInSec = actualUpTimeInSec + Integer.parseInt(time)*60;
    				time = "";
    				System.out.println(actualUpTimeInSec);
    			}
    			else if(actualUptime.charAt(i+1) == 'h')
    			{
    				actualUpTimeInSec = actualUpTimeInSec + Integer.parseInt(time)*60*60;
    				time = "";
    				System.out.println(actualUpTimeInSec);
    			}
    			else if(actualUptime.charAt(i+1) == 'd')
    			{
    				actualUpTimeInSec = actualUpTimeInSec + Integer.parseInt(time)*60*60*24;
    				time = "";
    			}
    			else if(actualUptime.charAt(i+1) == 's')
    			{
    				actualUpTimeInSec = actualUpTimeInSec + Integer.parseInt(time);
    				time = "";
    				System.out.println(actualUpTimeInSec);
    			}
    		
    		}
    		
    	}
    	System.out.println("actualUpTimeInSec :"+actualUpTimeInSec);
    	
    	Assert.assertTrue(actualUpTimeInSec <= Integer.parseInt(expectedNodeUpTimeInSec) &&  Integer.parseInt(expectedNodeUpTimeInSec) <= actualUpTimeInSec+150);
    	
    }
    
    public void validateNodesFromDropdown() throws EncryptedDocumentException, IOException
    {
    	String firstNode = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.couchBaseSheet, "select_Firstnode");
    	String secondNode = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.couchBaseSheet, "select_Secondnode");
    	//select the application from drop down
		page.locator(nodeDropDown).click();

		page.waitForSelector(nodeSearchResults);
		Locator actualsearchedApplications=page.locator(nodeSearchResults);				
	
		Assert.assertTrue(actualsearchedApplications.nth(0).textContent().trim().equalsIgnoreCase(firstNode));
		Assert.assertTrue(actualsearchedApplications.nth(1).textContent().trim().equalsIgnoreCase(secondNode));
    }
    
    public void validateNodePageWidgets()
    {
    	page.waitForSelector(nodeMcdMemoryWidgetTitle);
    	Assert.assertTrue(page.locator(nodeCpuUsageWidgetTitle).isVisible());
    	Assert.assertTrue(page.locator(nodeRamUsageWidgetTitle).isVisible());
    	Assert.assertTrue(page.locator(nodeDiskUsageCardTitle).isVisible());
    	Assert.assertTrue(page.locator(nodeSwapMemoryWidgetTitle).isVisible());
    	Assert.assertTrue(page.locator(nodeOperationsWidgetTitle).isVisible());
    	Assert.assertTrue(page.locator(nodeReplicaWidgetTitle).isVisible());
    	Assert.assertTrue(page.locator(nodeDocsDataSizeWidgetTitle).isVisible());
    	Assert.assertTrue(page.locator(nodeMcdMemoryWidgetTitle).isVisible());
    }
    
    public void navigateToNodeTab() {
		page.locator(nodeTab).click();
		page.waitForSelector(nodeName);
		Assert.assertTrue(page.locator(nodeName).isVisible());
		
	}
    
    public void validateNodePageTitle(String expectedTitle) {
    	String actualTitle = page.locator(nodeTab).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
    
    public void selectNodeFromDropDown() throws EncryptedDocumentException, IOException {
    	String node = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.couchBaseSheet, "select_Secondnode");
    	util.selectTheOptionFromDropDownBySearch(page, nodeDropDown, nodeSearhInputField, node, nodeSearchResults);
    }
    
    

    public void validateNodeName(String expectedTitle) {
    	String actualTitle = page.locator(nodeName).textContent().trim();
        util.ValidateTheTitle(actualTitle, expectedTitle);
    }

    public void validateNodeVersion(String expectedTitle) {
    	String actualTitle = page.locator(nodeVersion).textContent().trim();
        util.ValidateTheTitle(actualTitle, expectedTitle);
    }

    public void validateNodeStatus(String expectedTitle) {
    	String actualTitle = page.locator(nodeStatus).textContent().trim();
        util.ValidateTheTitle(actualTitle, expectedTitle);
    }

    public void validateNodeOs(String expectedTitle) {
    	String actualTitle = page.locator(nodeOs).textContent().trim();
        util.ValidateTheTitle(actualTitle, expectedTitle);
    }


    public void validateNodeUpTime(String expectedTitle) {
    	String actualTitle = page.locator(nodeUpTime).textContent().trim();
        util.ValidateTheTitle(actualTitle, expectedTitle);
    }


    public void validateNodeNameValue(String expectedTitle) {
    	String actualTitle = page.locator(nodeNameValue).textContent().trim();
    	String titleFromDropDown = page.locator(nodeDropdownDefaultValue).textContent().trim();
    	Assert.assertEquals(titleFromDropDown, actualTitle);
        Assert.assertTrue(expectedTitle.contains(actualTitle));
    }

    public void validateNodeVersionValue(String expectedTitle) {
    	String actualTitle = page.locator(nodeVersionValue).textContent().trim();
        util.ValidateTheTitle(actualTitle, expectedTitle);
    }

    public void validateNodeStatusValue(String expectedTitle) {
    	String actualTitle = page.locator(nodeStatusValue).textContent().trim();
        util.ValidateTheTitle(actualTitle, expectedTitle);
    }

    public void validateNodeOsValue(String expectedTitle) {
    	String actualTitle = page.locator(nodeOsValue).textContent().trim();
        util.ValidateTheTitle(actualTitle, expectedTitle);
    }

    
    public void validateDiskUsageCardTitle(String expectedTitle) {
    	page.waitForSelector(nodeDiskUsageCardTitle);
    	String actualTitle = page.locator(nodeDiskUsageCardTitle).textContent().trim();
        System.out.println(actualTitle);
        System.out.println(expectedTitle);
        util.ValidateTheTitle(actualTitle, expectedTitle);
    }


    public void validateUsedText(String expectedTitle) {
    	String actualTitle = page.locator(nodeUsedText).textContent().trim();
        util.ValidateTheTitle(actualTitle, expectedTitle);
    }

    public void validateAvailableText(String expectedTitle) {
    	String actualTitle = page.locator(nodeAvailableText).textContent().trim();
        util.ValidateTheTitle(actualTitle, expectedTitle);
    }

    public void validateUsedIcon(String expectedColor) {
        validateTheLegendsColor(page, nodeUsedIcon, expectedColor);
    }

    public void validateAvailableIcon(String expectedColor) {
        validateTheLegendsColor(page, nodeAvailableIcon, expectedColor);
    }

    public void validateDiskUsageCardNodataText(String expectedTitle) {
    	String actualTitle = page.locator(nodeDiskUsageCardNodataText).textContent().trim();
        Assert.assertTrue(actualTitle.contains(expectedTitle));
    }


    public void validateDiskUsageApplicationText(String expectedTitle) {
    	String actualTitle = page.locator(nodeAvailableText).textContent().trim();
        util.ValidateTheTitle(actualTitle, expectedTitle);
    }


    public void validateStorageUsageValue(String expectedTitle) {
    	String actualTitle = page.locator(nodeAvailableText).textContent().trim();
        util.ValidateTheTitle(actualTitle, expectedTitle);
    }


    public void validateStorageUsageLegend(String expectedTitle) {
    	String actualTitle = page.locator(nodeStorageUsageLegend).textContent().trim();
        util.ValidateTheTitle(actualTitle, expectedTitle);
    }

    public void validateStorageAvailableLegend(String expectedTitle) {
    	String actualTitle = page.locator(nodeStorageAvailableLegend).textContent().trim();
        util.ValidateTheTitle(actualTitle, expectedTitle);
    }

    public void validateStorageAvailableValue(String expectedTitle) {
    	String actualTitle = page.locator(nodeStorageAvailableValue).textContent().trim();
        util.ValidateTheTitle(actualTitle, expectedTitle);
    }

    public void validateCpuUsagewidgetTitle(String expectedTitle) {
    	String actualTitle = page.locator(nodeCpuUsageWidgetTitle).textContent().trim();
        util.ValidateTheTitle(actualTitle, expectedTitle);
    }

    public void validateCpuUsageZoomInBtn() {
        util.graphZoomIn(page, nodeCpuUsageZoomInBtn, nodeCpuUsageResetBtn, allWidgetXPoints());
    }

    public void validateCpuUsageZoomOutBtn() {
        util.graphZoomOut(page, nodeCpuUsageZoomInBtn, nodeCpuUsageZoomOutBtn, nodeCpuUsageResetBtn, allWidgetXPoints());
    }

    public void validateCpuUsageResetBtn() {
        util.graphZoomReset(page, nodeCpuUsageZoomInBtn, nodeCpuUsageResetBtn, allWidgetXPoints());
    }

    
    public void validateCpuUsageGraphDragDrop() {
    	util.graphZoomInByDragAndDrop(page, nodeCpuUsageXaxisLines, nodeCpuUsageResetBtn, allWidgetXPoints());
    }
    
    public void validateCpuUsageXaxisValues() {
        util.validateTheGraphdisplayingTheDataAsPerGivenTimeLines(page, nodeCpuUsageXaxisValues, calendarValue, allWidgetXValues());
    }

    public void validateCpuUsageXaxisTitle(String expectedTitle) {
    	String actualTitle = page.locator(nodeCpuUsageXaxisTitle).textContent().trim();
        util.ValidateTheTitle(actualTitle, expectedTitle);
    }

    public void validateCpuUsageYaxisTitle(String expectedTitle) {
    	String actualTitle = page.locator(nodeCpuUsageYaxisTitle).textContent().trim();
        util.ValidateTheTitle(actualTitle, expectedTitle);
    }

    public void validateCpuUsageToolTipTitle() {
    	page.waitForSelector(nodeCpuUsageXaxisLines);
        util.validateWidgetToolTips(page, nodeCpuUsageXaxisLines, nodeCpuUsageToolTipTitle);
    }

//    public void validateCpuUsageTooltipValue() {
//        return CpuUsageTooltipValue;
//    }

    public void validateRamUsagewidgetTitle(String expectedTitle) {
    	String actualTitle = page.locator(nodeRamUsageWidgetTitle).textContent().trim();
        util.ValidateTheTitle(actualTitle, expectedTitle);
    }

    public void validateRamUsageZoomInBtn() {
        util.graphZoomIn(page, nodeRamUsageZoomInBtn, nodeRamUsageResetBtn, allWidgetXPoints());
    }

    public void validateRamUsageZoomOutBtn() {
        util.graphZoomOut(page, nodeRamUsageZoomInBtn, nodeRamUsageZoomOutBtn, nodeRamUsageResetBtn, allWidgetXPoints());
    }

    public void validateRamUsageResetBtn() {
        util.graphZoomReset(page, nodeRamUsageZoomInBtn, nodeRamUsageResetBtn, allWidgetXPoints());
    }
    
    public void validateRAMUsageGraphDragDrop() {
    	util.graphZoomInByDragAndDrop(page, nodeRamUsageXaxisLines, nodeRamUsageResetBtn, allWidgetXPoints());
    }

    public void validateRamUsageXaxisValues() {
        util.validateTheGraphdisplayingTheDataAsPerGivenTimeLines(page, nodeRamUsageXaxisValues, calendarValue, allWidgetXValues());
    }

    public void validateRamUsageXaxisTitle(String expectedTitle) {
    	String actualTitle = page.locator(nodeRamUsageXaxisTitle).textContent().trim();
        util.ValidateTheTitle(actualTitle, expectedTitle);
    }

    public void validateRamUsageYaxisTitle(String expectedTitle) {
    	String actualTitle = page.locator(nodeRamUsageYaxisTitle).textContent().trim();
        util.ValidateTheTitle(actualTitle, expectedTitle);
    }

    public void validateRamUsageToolTipTitle() {
        util.validateWidgetToolTips(page, nodeRamUsageXaxisLines, nodeRamUsageToolTipTitle);
    }

//    public void validateRamUsageTooltipValue() {
//        return RamUsageTooltipValue;
//    }

    public void validateSwapMemorywidgetTitle(String expectedTitle) {
    	String actualTitle = page.locator(nodeSwapMemoryWidgetTitle).textContent().trim();
        util.ValidateTheTitle(actualTitle, expectedTitle);
    }

    public void validateSwapMemoryZoomInBtn() {
        util.graphZoomIn(page, nodeSwapMemoryZoomInBtn, nodeSwapMemoryResetBtn, allWidgetXPoints());
    }

    public void validateSwapMemoryZoomOutBtn() {
        util.graphZoomOut(page, nodeSwapMemoryZoomInBtn, nodeSwapMemoryZoomOutBtn, nodeSwapMemoryResetBtn, allWidgetXPoints());
    }

    public void validateSwapMemoryResetBtn() {
        util.graphZoomReset(page, nodeSwapMemoryZoomInBtn, nodeSwapMemoryResetBtn, allWidgetXPoints());
    }
    
    public void validateSwapMemoryGraphDragDrop() {
    	util.graphZoomInByDragAndDrop(page, nodeSwapMemoryXaxisLines, nodeSwapMemoryResetBtn, allWidgetXPoints());
    }

    public void validateSwapMemoryXaxisValues() {
        util.validateTheGraphdisplayingTheDataAsPerGivenTimeLines(page, nodeSwapMemoryXaxisValues, calendarValue, allWidgetXValues());
    }

    public void validateSwapMemoryXaxisTitle(String expectedTitle) {
    	String actualTitle = page.locator(nodeSwapMemoryXaxisTitle).textContent().trim();
        util.ValidateTheTitle(actualTitle, expectedTitle);
    }

    public void validateSwapMemoryYaxisTitle(String expectedTitle) {
    	String actualTitle = page.locator(nodeSwapMemoryYaxisTitle).textContent().trim();
        util.ValidateTheTitle(actualTitle, expectedTitle);
    }

    public void validateSwapMemoryToolTipTitle() {
    	page.waitForSelector(nodeSwapMemoryXaxisValues);
        util.validateWidgetToolTips(page, nodeSwapMemoryXaxisLines, nodeSwapMemoryToolTipTitle);
    }
    

//    public void getSwapMemoryTooltipValue() {
//        return swapMemoryTooltipValue;
//    }

    public void validatenodeOperationswidgetTitle(String expectedTitle) {
    	String actualTitle = page.locator(nodeOperationsWidgetTitle).textContent().trim();
        util.ValidateTheTitle(actualTitle, expectedTitle);
    }

    public void validatenodeOperationsZoomInBtn() {
        util.graphZoomIn(page, nodeOperationsZoomIn, nodeOperationsReset, allWidgetXPoints());
    }

    public void validatenodeOperationsZoomOutBtn() {
        util.graphZoomOut(page, nodeOperationsZoomIn, nodeOperationsZoomOut, nodeOperationsReset, allWidgetXPoints());
    }

    public void validatenodeOperationsResetBtn() {
        util.graphZoomReset(page, nodeOperationsZoomIn, nodeOperationsReset, allWidgetXPoints());
    }
    
    public void validateNodeOperationsGraphDragDrop() {
    	util.graphZoomInByDragAndDrop(page, nodeOperationsXaxisLines, nodeOperationsReset, allWidgetXPoints());
    }

    public void validatenodeOperationsXaxisValues() {
        util.validateTheGraphdisplayingTheDataAsPerGivenTimeLines(page, nodeOperationsXaxisValues, calendarValue, allWidgetXValues());
    }

    public void validatenodeOperationsXaxisTitle(String expectedTitle) {
    	String actualTitle = page.locator(nodeOperationsXaxisTitle).textContent().trim();
        util.ValidateTheTitle(actualTitle, expectedTitle);
    }

    public void validatenodeOperationsYaxisTitle(String expectedTitle) {
    	String actualTitle = page.locator(nodeOperationsYaxisTitle).textContent().trim();
        util.ValidateTheTitle(actualTitle, expectedTitle);
    }

    public void validatenodeOperationsToolTipTitle() {
        util.validateWidgetToolTips(page, nodeOperationsXaxisLines, nodeOperationsToolTipTitle);
    }

    public void validateNodeOperationsWidgetLegendsText(String expectedLegends) {
        util.validateWidgetLegendsText(page, nodeOperationsWidgetLegendsList, expectedLegends);
    }

    public void validateNodeOperationsLegendsWithRespectiveToolTips() {
        util.validateWidgetLegends(page, nodeOperationsWidgetLegendsList, nodeOperationsWidgetLegendsColorList, nodeOperationsLegendsLineList, nodeOperationsToolTipColorList, nodeOperationsXaxisLines, nodeOperationsToolTipTextList);
    }

    public void validateCurrentItemswidgetTitle(String expectedTitle) {
    	String actualTitle = page.locator(nodeCurrentItemsWidgetTitle).textContent().trim();
        util.ValidateTheTitle(actualTitle, expectedTitle);
    }

    public void validateCurrentItemsZoomInBtn() {
        util.graphZoomIn(page, nodeCurrentItemsZoomInBtn, nodeCurrentItemsResetBtn, allWidgetXPoints());
    }

    public void validateCurrentItemsZoomOutBtn() {
        util.graphZoomOut(page, nodeCurrentItemsZoomInBtn, nodeCurrentItemsZoomOutBtn, nodeCurrentItemsResetBtn, allWidgetXPoints());
    }

    public void validateCurrentItemsResetBtn() {
        util.graphZoomReset(page, nodeCurrentItemsZoomInBtn, nodeCurrentItemsResetBtn, allWidgetXPoints());
    }
    
    public void validateCurrentItemsGraphDragDrop() {
    	util.graphZoomInByDragAndDrop(page, nodeCurrentItemsXaxisLines, nodeCurrentItemsResetBtn, allWidgetXPoints());
    }

    public void validateCurrentItemsXaxisValues() {
        util.validateTheGraphdisplayingTheDataAsPerGivenTimeLines(page, nodeCurrentItemsXaxisValues, calendarValue, allWidgetXValues());
    }

    public void validateCurrentItemsXaxisTitle(String expectedTitle) {
    	String actualTitle = page.locator(nodeCurrentItemsXaxisTitle).textContent().trim();
        util.ValidateTheTitle(actualTitle, expectedTitle);
    }

    public void validateCurrentItemsYaxisTitle(String expectedTitle) {
    	String actualTitle = page.locator(nodeCurrentItemsYaxisTitle).textContent().trim();
        util.ValidateTheTitle(actualTitle, expectedTitle);
    }

    public void validateCurrentItemsToolTipTitle() {
        util.validateWidgetToolTips(page, nodeCurrentItemsXaxisLines, nodeCurrentItemsToolTipTitle);
    }    

//    public String getCurrentItemsTooltipValue() {
//       return nodeCurrentItemsTooltipValue;
//    }

    public void validatenodeReplicawidgetTitle(String expectedTitle) {
    	String actualTitle = page.locator(nodeReplicaWidgetTitle).textContent().trim();
        util.ValidateTheTitle(actualTitle, expectedTitle);
    }

    public void validatenodeReplicaZoomInBtn() {
        util.graphZoomIn(page, nodeReplicaZoomInBtn, nodeReplicaResetBtn, allWidgetXPoints());
    }

    public void validatenodeReplicaZoomOutBtn() {
        util.graphZoomOut(page, nodeReplicaZoomInBtn, nodeReplicaZoomOutBtn, nodeReplicaResetBtn, allWidgetXPoints());
    }

    public void validatenodeReplicaResetBtn() {
        util.graphZoomReset(page, nodeReplicaZoomInBtn, nodeReplicaResetBtn, allWidgetXPoints());
    }
    
    public void validateNodeReplicaGraphDragDrop() {
    	util.graphZoomInByDragAndDrop(page, nodeReplicaXaxisLines, nodeReplicaResetBtn, allWidgetXPoints());
    }

    public void validatenodeReplicaXaxisValues() {
        util.validateTheGraphdisplayingTheDataAsPerGivenTimeLines(page, nodeReplicaXaxisValues, calendarValue, allWidgetXValues());
    }

    public void validatenodeReplicaXaxisTitle(String expectedTitle) {
    	String actualTitle = page.locator(nodeReplicaXaxisTitle).textContent().trim();
        util.ValidateTheTitle(actualTitle, expectedTitle);
    }

    public void validatenodeReplicaYaxisTitle(String expectedTitle) {
    	String actualTitle = page.locator(nodeReplicaYaxisTitle).textContent().trim();
        util.ValidateTheTitle(actualTitle, expectedTitle);
    }

    public void validatenodeReplicaToolTipTitle() {
    	page.locator(nodeReplicaWidgetTitle).scrollIntoViewIfNeeded();
        util.validateWidgetToolTips(page, nodeReplicaXaxisLines, nodeReplicaToolTipTitle);
    }
    
//    public void getNodeReplicaTooltipValue() {
//        return nodeReplicaTooltipValue;
//    }

    public void validateDocsDataSizewidgetTitle(String expectedTitle) {
    	String actualTitle = page.locator(nodeDocsDataSizeWidgetTitle).textContent().trim();
        util.ValidateTheTitle(actualTitle, expectedTitle);
    }

    public void validateDocsDataSizeZoomInBtn() {
        util.graphZoomIn(page, nodeDocsDataSizeZoomInBtn, nodeDocsDataSizeResetBtn, allWidgetXPoints());
    }

    public void validateDocsDataSizeZoomOutBtn() {
        util.graphZoomOut(page, nodeDocsDataSizeZoomInBtn, nodeDocsDataSizeZoomOutBtn, nodeDocsDataSizeResetBtn, allWidgetXPoints());
    }

    public void validateDocsDataSizeResetBtn() {
        util.graphZoomReset(page, nodeDocsDataSizeZoomInBtn, nodeDocsDataSizeResetBtn, allWidgetXPoints());
    }
    
    public void validateDocsDataSizeGraphDragDrop() {
    	util.graphZoomInByDragAndDrop(page, nodeDocsDataSizeXaxisLines, nodeDocsDataSizeResetBtn, allWidgetXPoints());
    }

    public void validateDocsDataSizeXaxisValues() {
        util.validateTheGraphdisplayingTheDataAsPerGivenTimeLines(page, nodeDocsDataSizeXaxisValues, calendarValue, allWidgetXValues());
    }

    public void validateDocsDataSizeXaxisTitle(String expectedTitle) {
    	String actualTitle = page.locator(nodeDocsDataSizeXaxisTitle).textContent().trim();
        util.ValidateTheTitle(actualTitle, expectedTitle);
    }

    public void validateDocsDataSizeYaxisTitle(String expectedTitle) {
    	String actualTitle = page.locator(nodeDocsDataSizeYaxisTitle).textContent().trim();
        util.ValidateTheTitle(actualTitle, expectedTitle);
    }

    public void validateDocsDataSizeToolTipTitle() {
        util.validateWidgetToolTips(page, nodeDocsDataSizeXaxisLines, nodeDocsDataSizeToolTipTitle);
    }
    
//    public void getDocsDataSizeTooltipValue() {
//        return docsDataSizeTooltipValue;
//    }

    public void validateMcdMemorywidgetTitle(String expectedTitle) {
    	String actualTitle = page.locator(nodeMcdMemoryWidgetTitle).textContent().trim();
        util.ValidateTheTitle(actualTitle, expectedTitle);
    }

    public void validateMcdMemoryZoomInBtn() {
        util.graphZoomIn(page, nodeMcdMemoryZoomInBtn, nodeMcdMemoryResetBtn, allWidgetXPoints());
    }

    public void validateMcdMemoryZoomOutBtn() {
        util.graphZoomOut(page, nodeMcdMemoryZoomInBtn, nodeMcdMemoryZoomOutBtn, nodeMcdMemoryResetBtn, allWidgetXPoints());
    }

    public void validateMcdMemoryResetBtn() {
        util.graphZoomReset(page, nodeMcdMemoryZoomInBtn, nodeMcdMemoryResetBtn, allWidgetXPoints());
    }
    
    public void validateMcdMemoryGraphDragDrop() {
    	util.graphZoomInByDragAndDrop(page, nodeMcdMemoryXaxisLines, nodeMcdMemoryResetBtn, allWidgetXPoints());
    }

    public void validateMcdMemoryXaxisValues() {
        util.validateTheGraphdisplayingTheDataAsPerGivenTimeLines(page, nodeMcdMemoryXaxisValues, calendarValue, allWidgetXValues());
    }

    public void validateMcdMemoryXaxisTitle(String expectedTitle) {
    	String actualTitle = page.locator(nodeMcdMemoryXaxisTitle).textContent().trim();
        util.ValidateTheTitle(actualTitle, expectedTitle);
    }

    public void validateMcdMemoryYaxisTitle(String expectedTitle) {
    	String actualTitle = page.locator(nodeMcdMemoryYaxisTitle).textContent().trim();
        util.ValidateTheTitle(actualTitle, expectedTitle);
    }

    public void validateMcdMemoryToolTipTitle() {
        util.validateWidgetToolTips(page, nodeMcdMemoryXaxisLines, nodeMcdMemoryToolTipTitle);
    }

	public void validateTheCustomTimeLine(String period) {
		util.validateCustomTimeLine(page,nodeCpuUsageXaxisValues,period,allWidgetXValues());
		
	}
    
//    public void getMcdMemoryTooltipValue() {
//        return mcdMemoryTooltipValue;
//    }
	
	public void validateTheLegendsColor(Page page, String element ,String expectedColor)
    {
    	String actualColor =  (String) page.locator(element).evaluate("element => getComputedStyle(element).color");
    	//actualColor = actualColor.replace(")", "");
    	Assert.assertEquals(actualColor.contains(expectedColor),true);
    }

	

    
    
    
}