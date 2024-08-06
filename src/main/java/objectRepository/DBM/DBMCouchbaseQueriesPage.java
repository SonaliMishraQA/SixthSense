package objectRepository.DBM;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import genericUtilities.ExcelUtility;
import genericUtilities.GenericMethods;

public class DBMCouchbaseQueriesPage {
	
	Page page;
	GenericMethods util = new GenericMethods();
	
	private String queriesTab = "xpath = //div[@class='item']/child::div[contains(@class,'router') and contains(text(),'Queries')]"  ;
    private String queryThresholdTitle = "xpath = //div[@class='query-dropdown']/descendant::div[@class='heading']" ;
    private String queryThresholdDropdown = "#btn-arrow-down-query-threshold-select";
    private String selectedQuery = "xpath = //div[@id='query-threshold-select']/child::div[@class='selected-item-text']";
    private String queryThresholdDropDownList = "xpath = //div[@class='select-box active']/descendant::div[@class='option']/descendant::span[@class='selected-item-text']" ;
    private String queryTableQueryNameHeaderTitle = "xpath = //thead[@class='header-container header-primary']/descendant::td/child::div/child::div[contains(text(),'Query name')]";
    private String queryTableTotalExecutionHeaderTitle = "xpath = //thead[@class='header-container header-primary']/descendant::td/child::div/child::div[contains(text(),'Total execution')]";
    private String queryTableExecutiontimeHeaderTitle = "xpath = //thead[@class='header-container header-primary']/descendant::td/child::div/descendant::div[contains(text(),'Execution time(s)')]";
    private String queryTableTimeStampHeaderTitle = "xpath = //thead[@class='header-container header-primary']/descendant::td/child::div/child::div[contains(text(),'Timestamp')]";
    private String queryList = "xpath = //div[@class='virtual-list-box']/descendant::span[@class='query']"  ;
    private String totalExcutionList = "xpath = //div[@class='virtual-list-box']/descendant::td[@class='body-td' and position()=2]/child::div"  ;
    private String executionTimeList = "xpath = //div[@class='virtual-list-box']/descendant::td[@class='body-td' and position()=3]/child::div"  ;
    private String timeStampList = "xpath = //div[@class='virtual-list-box']/descendant::td[@class='body-td' and position()=4]/child::div"  ;
    
    private String showDropdown = "xpath = //div[@class='selected-text-container']"  ;
    private String showDropdownValue10 = "xpath = //div[@class='items invert']/child::div[text()=' 10 ']"  ;
    private String showDropdownValue20 = "xpath = //div[@class='items invert']/child::div[text()=' 20 ']"  ;
    private String showDropdownValue50 = "xpath = //div[@class='items invert']/child::div[text()=' 50 ']"  ;
    private String noDataText = "xpath = //div[@class='inner-text']"  ;

    private String downloadReportBtn = "#rex-pdf-download"  ;
    private String downloadSuccessMsg = "xpath = //div[.='The PDF report has been downloaded successfully.']"  ;
    private String closeSuccessMsg = "xpath = //i[@class='anticon anticon-close ant-notification-close-icon']"  ;
    private String refreshButton = "xpath = //div[@id='btn-refresh']"  ;

    private String requestsWidgetTitle = "xpath = //div[@class='wrapper']/descendant::div[@class='line-title'][position()=1]" ;
    private String requestsZoomOut = "#Requests-zoom-out" ;
    private String requestsZoomIn = "#Requests-zoom-in"  ;
    private String requestsReset = "#Requests-zoom-reset" ;
    private String requestsXaxisLines = "xpath = //div[@id='apexchartsvuechart-line-0']/descendant::*[name()='line' and @class='apexcharts-xaxis-tick']";
    private String requestsXaxisValues = "xpath = //div[text()=' Requests']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-label apexcharts-xaxis-label']/child::*[name()='tspan' and contains(text(),'-')]" ;
    private String requestsXaxisTitle = "xpath = //div[text()=' Requests']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-title-text chart-lables']";
    private String requestsYaxisTitle = "xpath = //div[text()=' Requests']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-yaxis-title-text chart-lables']";
    private String requestsToolTipTitle = "xpath = //div[@id='apexchartsvuechart-line-0']/descendant::div[@class='apexcharts-tooltip-title']";
    private String requestsToolTipTextList = "xpath = //div[@id = 'apexchartsvuechart-line-0']/descendant::div[@class = 'apexcharts-tooltip-y-group']/child::span[@class = 'apexcharts-tooltip-text-y-label']";
    private String requestsToolTipColorList = "xpath = //div[@id='apexchartsvuechart-line-0']/descendant::span[contains(@class,'apexcharts-legend-marker')]";
    private String requestsWidgetLegendsLineList = "xpath = //div[@id='apexchartsvuechart-line-0']/descendant::*[name()='g' and @class='apexcharts-series']/child::*[name()='path' and @fill='none']";
    private String requestsToolTipValueList = "xpath = //div[text()=' Requests']/ancestor::div[@class='chart-box']/descendant::span[@class='apexcharts-tooltip-marker' and not(contains(@style,'none;'))]/parent::div[@class='apexcharts-tooltip-series-group apexcharts-active' and not(contains(@style,'none;'))]/descendant::span[@class='apexcharts-tooltip-text-y-value']";
    private String requestsWidgetLegendsList = "xpath = //div[@id='apexchartsvuechart-line-0']/descendant::span[contains(@class,'apexcharts-legend-text')]";
    private String requestsWidgetLegendsColorList = "xpath = //div[@id='apexchartsvuechart-line-0']/descendant::span[contains(@class,'apexcharts-legend-marker')]";

    private String requestTimeDistributionWidgetTitle = "xpath = //div[@class='wrapper']/descendant::div[@class='line-title'][position()=2]" ;
    private String requestTimeDistributionZoomOut = "#Request-time-distribution-zoom-out"  ;
    private String requestTimeDistributionZoomIn = "#Request-time-distribution-zoom-in"  ;
    private String requestTimeDistributionReset = "#Request-time-distribution-zoom-reset"  ;
    private String requestTimeDistributionXaxisLines = "xpath = //div[text()=' Request time distribution']/ancestor::div[@class='chart-line']/descendant::*[name()='line' and @class='apexcharts-xaxis-tick']";
    private String requestTimeDistributionXaxisValues = "xpath = //div[text()=' Request time distribution']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-label apexcharts-xaxis-label']/child::*[name()='tspan' and contains(text(),'-')]";
    private String requestTimeDistributionXaxisTitle = "xpath = //div[text()=' Request time distribution']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-title-text chart-lables']";
    private String requestTimeDistributionYaxisTitle = "xpath = //div[text()=' Request time distribution']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-yaxis-title-text chart-lables']";
    private String requestTimeDistributionToolTipTitle = "xpath = //div[text()=' Request time distribution']/ancestor::div[@class='chart-box']/descendant::div[@class='apexcharts-tooltip-title']";
    private String requestTimeDistributionToolTipTextList = "xpath = //div[@id = 'apexchartsvuechart-line-1']/descendant::div[@class = 'apexcharts-tooltip-y-group']/child::span[@class = 'apexcharts-tooltip-text-y-label']";
    private String requestTimeDistributionToolTipColorList = "xpath = //div[@id='apexchartsvuechart-line-1']/descendant::span[contains(@class,'apexcharts-legend-marker')]";
    private String requestTimeDistributionWidgetLegendsLineList = "xpath = //div[@id='apexchartsvuechart-line-1']/descendant::*[name()='g' and @class='apexcharts-series']/child::*[name()='path' and @fill='none']";
    private String requestTimeDistributionToolTipValueList = "xpath = //div[text()=' Request time distribution']/ancestor::div[@class='chart-box']/descendant::span[@class='apexcharts-tooltip-marker' and not(contains(@style,'none;'))]/parent::div[@class='apexcharts-tooltip-series-group apexcharts-active' and not(contains(@style,'none;'))]/descendant::span[@class='apexcharts-tooltip-text-y-value']";
    private String requestTimeDistributionWidgetLegendsList = "xpath = //div[@id='apexchartsvuechart-line-1']/descendant::span[contains(@class,'apexcharts-legend-text')]";
    private String requestTimeDistributionWidgetLegendsColorList = "xpath = //div[@id='apexchartsvuechart-line-1']/descendant::span[contains(@class,'apexcharts-legend-marker')]";

    private String requestThreadCountWidgetTitle = "xpath = //div[@class='wrapper']/descendant::div[@class='line-title'][position()=3]" ;
    private String requestThreadCountZoomOutBtn = "#Request-thread-count-zoom-out"  ;
    private String requestThreadCountZoomInBtn = "#Request-thread-count-zoom-in" ;
    private String requestThreadCountResetBtn = "#Request-thread-count-zoom-reset" ;
    private String requestThreadCountXaxisLines = "xpath = //div[text()=' Request thread count']/ancestor::div[@class='chart-line']/descendant::*[name()='line' and @class='apexcharts-xaxis-tick']";
    private String requestThreadCountXaxisValues = "xpath = //div[text()=' Request thread count']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-label apexcharts-xaxis-label']/child::*[name()='tspan' and contains(text(),'-')]";
    private String requestThreadCountXaxisTitle = "xpath = //div[text()=' Request thread count']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-title-text chart-lables']";
    private String requestThreadCountYaxisTitle = "xpath = //div[text()=' Request thread count']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-yaxis-title-text chart-lables']";
    private String requestThreadCountToolTipTitle = "xpath = //div[text()=' Request thread count']/ancestor::div[@class='chart-box']/descendant::div[@class='apexcharts-tooltip-title']";
    private String requestThreadCountTooltipValue = "xpath = //div[text()=' Request thread count']/ancestor::div[@class='chart-box']/descendant::div[@class='apexcharts-tooltip-text']";
    

    private String gcCountWidgetTitle = "xpath = //div[@class='wrapper']/descendant::div[@class='line-title'][position()=4]" ;
    private String gcCountZoomOutBtn = "#GC-count-zoom-out"  ;
    private String gcCountZoomInBtn = "#GC-count-zoom-in" ;
    private String gcCountResetBtn = "#GC-count-zoom-reset" ;
    private String gcCountXaxisLines = "xpath = //div[text()=' GC count']/ancestor::div[@class='chart-line']/descendant::*[name()='line' and @class='apexcharts-xaxis-tick']";
    private String gcCountXaxisValues = "xpath = //div[text()=' GC count']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-label apexcharts-xaxis-label']/child::*[name()='tspan' and contains(text(),'-')]";
    private String gcCountXaxisTitle = "xpath = //div[text()=' GC count']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-title-text chart-lables']";
    private String gcCountYaxisTitle = "xpath = //div[text()=' GC count']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-yaxis-title-text chart-lables']";
    private String gcCountToolTipTitle = "xpath = //div[text()=' GC count']/ancestor::div[@class='chart-box']/descendant::div[@class='apexcharts-tooltip-title']";
    private String gcCountTooltipValue = "xpath = //div[text()=' GC count']/ancestor::div[@class='chart-box']/descendant::div[@class='apexcharts-tooltip-text']";

    private String calendarValue = "xpath = //div[@class='selected-text ellipsis bg-text']";
    
    public DBMCouchbaseQueriesPage(Page page) {
		this.page = page;
	}
    
   public List<String> allWidgetXPoints(){
	   ArrayList<String> xPoint = new ArrayList<String>();
	   xPoint.add(requestsXaxisLines);
	   xPoint.add(requestTimeDistributionXaxisLines);
	   xPoint.add(requestThreadCountXaxisLines);
	   xPoint.add(gcCountXaxisLines);
	   return xPoint;
   }
   
   public List<String> allWidgetXValues(){
	   ArrayList<String> xValue = new ArrayList<String>();
	   xValue.add(requestsXaxisValues);
	   xValue.add(requestTimeDistributionXaxisValues);
	   xValue.add(requestThreadCountXaxisValues);
	   xValue.add(gcCountXaxisValues);
	   return xValue;
   }
   public void validateQueriesPageWidgets()
   {
	   Assert.assertTrue(page.locator(requestsWidgetTitle).isVisible());
	   Assert.assertTrue(page.locator(requestTimeDistributionWidgetTitle).isVisible());
	   Assert.assertTrue(page.locator(requestThreadCountWidgetTitle).isVisible());
	   Assert.assertTrue(page.locator(gcCountWidgetTitle).isVisible());
   }

   
   public void navigateToQueriesPage() {
		 page.waitForSelector(queriesTab);
		 page.locator(queriesTab).click();
		 page.waitForSelector(requestsWidgetTitle);
		 Assert.assertTrue(page.locator(requestsWidgetTitle).isVisible());
	}
   
   public void validateQueriesPageTitle(String expectedTile) {
	   String actualtitle = page.locator(queriesTab).textContent().trim();
	   util.ValidateTheTitle(actualtitle, expectedTile);
   }
    
    public void validateRequestsWidgetTitle(String expectedTitle) {
    	String actualTitle = page.locator(requestsWidgetTitle).textContent().trim();
        util.ValidateTheTitle(actualTitle, expectedTitle);
    }

    public void validateRequestsZoomOut() {
        util.graphZoomOut(page, requestsZoomIn, requestsZoomOut, requestsReset, allWidgetXPoints());
    }

    public void validateRequestsZoomIn() {
        util.graphZoomIn(page, requestsZoomIn, requestsReset, allWidgetXPoints());
    }

    public void validateRequestsReset() {
        util.graphZoomReset(page, requestsZoomIn, requestsReset, allWidgetXPoints());
    }
    
    public void validateRequestsDragDrop() {
//    	page.locator(requestsWidgetTitle).first().scrollIntoViewIfNeeded();
    	util.graphZoomInByDragAndDrop(page, requestsXaxisLines, requestsReset, allWidgetXPoints());
    }


    public void validateRequestsXaxisValues() {
    	util.validateTheGraphdisplayingTheDataAsPerGivenTimeLines(page, requestsXaxisValues, calendarValue, allWidgetXValues());
    }

    public void validateRequestsXaxisTitle(String expectedTitle) {
    	String actualTitle = page.locator(requestsXaxisTitle).textContent().trim();
        util.ValidateTheTitle(actualTitle, expectedTitle);
    }

    public void validateRequestsYaxisTitle(String expectedTitle) {
    	String actualTitle = page.locator(requestsYaxisTitle).textContent().trim();
        util.ValidateTheTitle(actualTitle, expectedTitle);
    }

    public void validateRequestsToolTipTitle() {
        util.validateWidgetToolTips(page, requestsXaxisLines, requestsToolTipTitle);
    }
    
    public void validateRequestsWidgetLegendsText(String expectedLegends) {
        util.validateWidgetLegendsText(page, requestsWidgetLegendsList, expectedLegends);
    }

    public void validateRequestsWidgetLegendsWithRespectiveToolTips() {
        util.validateWidgetLegends(page, requestsWidgetLegendsList, requestsWidgetLegendsColorList, requestsWidgetLegendsLineList, requestsToolTipColorList, requestsXaxisLines, requestsToolTipTextList);
    }


    public void validateRequestTimeDistributionWidgetTitle(String expectedTitle) {
    	String actualTitle = page.locator(requestTimeDistributionWidgetTitle).textContent().trim();
        util.ValidateTheTitle(actualTitle, expectedTitle);
    }

    public void validateRequestTimeDistributionZoomOut() {
        util.graphZoomOut(page, requestTimeDistributionZoomIn, requestTimeDistributionZoomOut, requestTimeDistributionReset, allWidgetXPoints());
    }

    public void validateRequestTimeDistributionZoomIn() {
        util.graphZoomIn(page, requestTimeDistributionZoomIn, requestTimeDistributionReset, allWidgetXPoints());
    }

    public void validateRequestTimeDistributionReset() {
        util.graphZoomReset(page, requestTimeDistributionZoomIn, requestTimeDistributionReset, allWidgetXPoints());
    }
    
    public void validateRequestTimeDistributionDragDrop() {
    	util.graphZoomInByDragAndDrop(page, requestTimeDistributionXaxisLines, requestTimeDistributionReset, allWidgetXPoints());
    }


    public void validateRequestTimeDistributionXaxisValues() {
    	util.validateTheGraphdisplayingTheDataAsPerGivenTimeLines(page, requestTimeDistributionXaxisValues, calendarValue, allWidgetXValues());
    }

    public void validateRequestTimeDistributionXaxisTitle(String expectedTitle) {
    	String actualTitle = page.locator(requestTimeDistributionXaxisTitle).textContent().trim();
        util.ValidateTheTitle(actualTitle, expectedTitle);
    }

    public void validateRequestTimeDistributionYaxisTitle(String expectedTitle) {
    	String actualTitle = page.locator(requestTimeDistributionYaxisTitle).textContent().trim();
        util.ValidateTheTitle(actualTitle, expectedTitle);
    }

    public void validateRequestTimeDistributionToolTipTitle() {
    	page.locator(requestTimeDistributionWidgetTitle).first().scrollIntoViewIfNeeded();
        util.validateWidgetToolTips(page, requestTimeDistributionXaxisLines, requestTimeDistributionToolTipTitle);
    }
    
    public void validateRequestTimeDistributionWidgetLegendsText(String expectedLegends) {
        util.validateWidgetLegendsText(page, requestTimeDistributionWidgetLegendsList, expectedLegends);
    }

    public void validateRequestTimeDistributionWidgetLegendsWithRespectiveToolTips() {
    	page.locator(requestTimeDistributionWidgetTitle).scrollIntoViewIfNeeded();
        util.validateWidgetLegends(page, requestTimeDistributionWidgetLegendsList, requestTimeDistributionWidgetLegendsColorList, requestTimeDistributionWidgetLegendsLineList, requestTimeDistributionToolTipColorList, requestTimeDistributionXaxisLines, requestTimeDistributionToolTipTextList);
    }
    
    public void validateRequestThreadCountWidgetTitle(String expectedTitle) {
    	String actualTitle = page.locator(requestThreadCountWidgetTitle).textContent().trim();
        util.ValidateTheTitle(actualTitle, expectedTitle);
    }

    public void validateRequestThreadCountZoomOut() {
        util.graphZoomOut(page, requestThreadCountZoomInBtn, requestThreadCountZoomOutBtn, requestThreadCountResetBtn, allWidgetXPoints());
    }

    public void validateRequestThreadCountZoomIn() {
        util.graphZoomIn(page, requestThreadCountZoomInBtn, requestThreadCountResetBtn, allWidgetXPoints());
    }

    public void validateRequestThreadCountReset() {
        util.graphZoomReset(page, requestThreadCountZoomInBtn, requestThreadCountResetBtn, allWidgetXPoints());
    }
    
    public void validateRequestThreadCountDragDrop() {
    	util.graphZoomInByDragAndDrop(page, requestThreadCountXaxisLines, requestThreadCountResetBtn, allWidgetXPoints());
    }


    public void validateRequestThreadCountXaxisValues() {
    	util.validateTheGraphdisplayingTheDataAsPerGivenTimeLines(page, requestThreadCountXaxisValues, calendarValue, allWidgetXValues());
    }

    public void validateRequestThreadCountXaxisTitle(String expectedTitle) {
    	String actualTitle = page.locator(requestThreadCountXaxisTitle).textContent().trim();
        util.ValidateTheTitle(actualTitle, expectedTitle);
    }

    public void validateRequestThreadCountYaxisTitle(String expectedTitle) {
    	String actualTitle = page.locator(requestThreadCountYaxisTitle).textContent().trim();
        util.ValidateTheTitle(actualTitle, expectedTitle);
    }

    public void validateRequestThreadCountToolTipTitle() {
    	page.locator(requestThreadCountWidgetTitle).first().scrollIntoViewIfNeeded();
        util.validateWidgetToolTips(page, requestThreadCountXaxisLines, requestThreadCountToolTipTitle);
    }
    
    public void validateGcCountWidgetTitle(String expectedTitle) {
    	String actualTitle = page.locator(gcCountWidgetTitle).textContent().trim();
        util.ValidateTheTitle(actualTitle, expectedTitle);
    }

    public void validateGcCountZoomOut() {
        util.graphZoomOut(page, gcCountZoomInBtn, gcCountZoomOutBtn, gcCountResetBtn, allWidgetXPoints());
    }

    public void validateGcCountZoomIn() {
        util.graphZoomIn(page, gcCountZoomInBtn, gcCountResetBtn, allWidgetXPoints());
    }

    public void validateGcCountReset() {
        util.graphZoomReset(page, gcCountZoomInBtn, gcCountResetBtn, allWidgetXPoints());
    }
    
    public void validateGcCountDragDrop() {
    	util.graphZoomInByDragAndDrop(page, gcCountXaxisLines, gcCountResetBtn, allWidgetXPoints());
    }


    public void validateGcCountXaxisValues() {
    	util.validateTheGraphdisplayingTheDataAsPerGivenTimeLines(page, gcCountXaxisValues, calendarValue, allWidgetXValues());
    }

    public void validateGcCountXaxisTitle(String expectedTitle) {
    	String actualTitle = page.locator(gcCountXaxisTitle).textContent().trim();
        util.ValidateTheTitle(actualTitle, expectedTitle);
    }

    public void validateGcCountYaxisTitle(String expectedTitle) {
    	String actualTitle = page.locator(gcCountYaxisTitle).textContent().trim();
        util.ValidateTheTitle(actualTitle, expectedTitle);
    }

    public void validateGcCountToolTipTitle() {
    	page.locator(gcCountWidgetTitle).first().scrollIntoViewIfNeeded();
        util.validateWidgetToolTips(page, gcCountXaxisLines, gcCountToolTipTitle);
    }

    public void validateQueryThresholdTitle(String expectedTitle) {
    	String actualTitle = page.locator(queryThresholdTitle).textContent().trim();
        util.ValidateTheTitle(actualTitle, expectedTitle);
    }

    public void validateQueryNameHeaderTitle(String expectedTitle) {
    	String actualTitle = page.locator(queryTableQueryNameHeaderTitle).textContent().trim();
        util.ValidateTheTitle(actualTitle, expectedTitle);
    }

    public void validateTotalExecutionHeaderTitle(String expectedTitle) {
    	String actualTitle = page.locator(queryTableTotalExecutionHeaderTitle).textContent().trim();
        util.ValidateTheTitle(actualTitle, expectedTitle);
    }
    
    public void validateExecutionTimeHeaderTitle(String expectedTitle) {
    	String actualTitle = page.locator(queryTableExecutiontimeHeaderTitle).textContent().trim();
        util.ValidateTheTitle(actualTitle, expectedTitle);
    }

    public void validateTimeStampHeaderTitle(String expectedTitle) {
    	String actualTitle = page.locator(queryTableTimeStampHeaderTitle).textContent().trim();
        util.ValidateTheTitle(actualTitle, expectedTitle);
    }
    
    public void validateQueryThresholdDropdown() {
        util.selectTheOptionFromDropDown(page, queryThresholdDropdown, executionTimeList);
    }

	public void validateTheCustomTimeLine(String period) {
		util.validateCustomTimeLine(page,requestsXaxisValues,period,allWidgetXValues());
	}
	
	public void validateTheQuerythresholdDropdown(String expectedValues) {
		validateAllOptionsAvailableInDropdown(page, queryThresholdDropdown, queryThresholdDropDownList, selectedQuery, expectedValues);
	}
	
	/**
	 * this method will select and validate all the options present in a dropdown
	 * @param page
	 * @param dropdown(dropdown button)
	 * @param actualValues
	 * @param selectedItem
	 * @param expectedValues
	 */
	
	public void validateAllOptionsAvailableInDropdown(Page page, String dropdown, String actualValues, String selectedItem, String expectedValues) {
		System.out.println(expectedValues);
		String[] evalues = expectedValues.split(",");
		for(String val : evalues) {
		    page.click(dropdown);
		    //page.waitForSelector(actualValues);
		    //page.locator(actualValues).scrollIntoViewIfNeeded();;
		    Locator values1 = page.locator(actualValues);
		    for(int i=0;i<values1.count();i++) {
		    	if(values1.nth(i).textContent().trim().equals(val)){
		    		values1.nth(i).click();
		    		break;
		        }
		    }
		Assert.assertTrue(page.textContent(selectedItem).equalsIgnoreCase(val));		
	    }
	}
	

}
	
