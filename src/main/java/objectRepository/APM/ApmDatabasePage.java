package objectRepository.APM;

import java.io.IOException;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.LinkedHashMap;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Locator.HoverOptions;
import com.microsoft.playwright.options.LoadState;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Page.WaitForSelectorOptions;

import genericUtilities.ExcelUtility;
import genericUtilities.GenericMethods;
import genericUtilities.IPathConstant;
import objectRepository.CommonPage;

public class ApmDatabasePage {

	Page page;
	GenericMethods util = new GenericMethods();
	CommonPage common = new CommonPage(page);
	ExcelUtility excel = new ExcelUtility();
	
	private String databaseTab = "#dasboard-tab-appdb";
	private String searchDatabaseDropDown = "#select-search-search-database";
	private String searchDatabaseTextField = "#input-search-sel-select-search-search-database";
	private String searchDbResults = "xpath = //span[contains(@id,'select-search-search-database')]";
	private String searchFieldCloseBtn = "#btn-close-btn";
	private String overallTab = "#database-tab-overall";
	private String queryTab = "#database-tab-query";

	private String loadGraphHeader = "xpath = //div[@id='apexchartsvuechart-line-0']/ancestor::div[@class='chart-body']/preceding-sibling::div[@class='line-header']/div[@class='line-title']";
	private String callsOnLoadGraphHeader = "xpath = //span[@class='line-content-calls']";
	private String callsPerMinOnLoadGraphHeader = "xpath = //span[@class='line-content-calls']/following-sibling::span";
	private String loadGraphXAxisTitle = "xpath = //div[@id='apexchartsvuechart-line-0']//*[name()='g' and @class='apexcharts-xaxis-title']";
	private String loadGraphYAxisTitle = "xpath = //div[@id='apexchartsvuechart-line-0']//*[name()='g' and @class='apexcharts-yaxis-title']";
	private String loadGraphZoomOutBtn = "#Load-zoom-out";
	private String loadGraphZoomInBtn = "#Load-zoom-in";
	private String loadGraphZoomResetBtn = "#Load-zoom-reset";
	private String loadGraphXPoints = "xpath = //div[@id='apexchartsvuechart-line-0']//*[name()='line' and @class='apexcharts-xaxis-tick']";
	private String loadGraphTooltip = "xpath = //div[@id='apexchartsvuechart-line-0']//span[@class='apexcharts-tooltip-text-y-value']";
	private String loadXaxisValues = "xpath = //div[text()=' Load']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-label apexcharts-xaxis-label']/child::*[name()='tspan' and contains(normalize-space(text()),'-')]";

	private String accessErrorGraphHeader = "xpath = //div[@id='apexchartsvuechart-line-1']/ancestor::div[@class='chart-body']/preceding-sibling::div[@class='line-header']/div[@class='line-title']";
	private String errorPercentOnAccessErrorGraphHeader = "xpath = //span[@class='line-error-percentage']";
	private String errorsOnAccessErrorGraphHeader = "xpath = //span[@class='line-errors']";
	private String errorsPerMinOnAccessErrorGraphHeader = "xpath = //span[@class='line-errors']/following-sibling::span";
	private String accessErrorGraphXAxisTitle = "xpath = //div[@id='apexchartsvuechart-line-1']//*[name()='g' and @class='apexcharts-xaxis-title']";
	private String accessErrorGraphYAxisTitle = "xpath = //div[@id='apexchartsvuechart-line-1']//*[name()='g' and @class='apexcharts-yaxis-title']";
	private String accessErrorGraphZoomOutBtn = "#Access-error-zoom-out";
	private String accessErrorGraphZoomInBtn = "#Access-error-zoom-in";
	private String accessErrorGraphZoomResetBtn ="#Access-error-zoom-reset";
	private String accessErrorGraphXPoints = "xpath = //div[@id='apexchartsvuechart-line-1']//*[name()='line' and @class='apexcharts-xaxis-tick']";
	private String errorGraphXaxisValues = "xpath = //div[text()=' Access error']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-label apexcharts-xaxis-label']/child::*[name()='tspan' and contains(normalize-space(text()),'-')]";
	private String accessErrorGraphTooltip = "xpath = //div[@id='apexchartsvuechart-line-1']//span[@class='apexcharts-tooltip-text-y-value']";

	private String responseTimeGraphHeader = "xpath = //div[@id='apexchartsvuechart-line-2']/ancestor::div[@class='chart-body']/preceding-sibling::div[@class='line-header']/div[@class='line-title']";
	private String respTimeAvgOnResponseTimeGraphHeader = "xpath = //div[@id='apexchartsvuechart-line-2']/ancestor::div[@class='chart-body']/preceding-sibling::div[@class='line-header']/div[@class='line-content']";
	private String responseTimeGraphXAxisTitle = "xpath = //div[@id='apexchartsvuechart-line-2']//*[name()='g' and @class='apexcharts-xaxis-title']";
	private String responseTimeGraphYAxisTitle = "xpath = //div[@id='apexchartsvuechart-line-2']//*[name()='g' and @class='apexcharts-yaxis-title']";
	private String responseTimeGraphZoomOutBtn = "#Response-time-zoom-out";
	private String responseTimeGraphZoomInBtn = "#Response-time-zoom-in";
	private String responseTimeGraphZoomResetBtn = "#Response-time-zoom-reset";
	private String responseTimeGraphXPoints = "xpath = //div[@id='apexchartsvuechart-line-2']//*[name()='line' and @class='apexcharts-xaxis-tick']";
	private String responseTimeGraphXaxisValues = "xpath =  //div[text()=' Response time']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-label apexcharts-xaxis-label']/child::*[name()='tspan' and contains(normalize-space(text()),'-')]";
	private String responseTimeGraphTooltip = "xpath = //div[@id='apexchartsvuechart-line-2']//span[@class='apexcharts-tooltip-text-y-value']";
	private String percentileRespTimeGraphTooltipLabel = "xpath = //div[@id='apexchartsvuechart-area-0']//div[@class='apexcharts-tooltip-series-group apexcharts-active']//span[@class='apexcharts-tooltip-text-y-label']";
	private String percentileRespTimeGraphTooltipValue = "xpath = //div[@id='apexchartsvuechart-area-0']//div[@class='apexcharts-tooltip-series-group apexcharts-active']//span[@class='apexcharts-tooltip-text-y-value']";

	private String percentileRespTimeGraphHeader = "xpath = //div[@id='apexchartsvuechart-area-0']/ancestor::div[@class='chart-body']/preceding-sibling::div[@class='line-header']/div[@class='line-title']";
	private String percentileRespTimeGraphXAxisTitle = "xpath = //div[@id='apexchartsvuechart-area-0']//*[name()='g' and @class='apexcharts-xaxis-title']";
	private String percentileRespTimeGraphYAxisTitle = "xpath = //div[@id='apexchartsvuechart-area-0']//*[name()='g' and @class='apexcharts-yaxis-title']";
	private String percentileRespTimeGraphZoomOutBtn = "#Percentile-response-time-zoom-out";
	private String percentileRespTimeGraphZoomInBtn = "#Percentile-response-time-zoom-in";
	private String percentileRespTimeGraphZoomResetBtn = "#Percentile-response-time-zoom-reset";
	private String percentileRespTimeGraphXPoints = "xpath = //div[@id='apexchartsvuechart-area-0']//*[name()='line' and @class='apexcharts-xaxis-tick']";
	private String percentileResponseTimeGraphXaxisValues = "xpath = //div[text()=' Percentile response time']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-label apexcharts-xaxis-label']/child::*[name()='tspan' and contains(normalize-space(text()),'-')]";
	private String percentileResponseTimeGraphToolTip = "xpath =//div[@id='apexchartsvuechart-area-0']/descendant::div[@class='apexcharts-tooltip apexcharts-theme-dark apexcharts-active']";
	private String percentileResponseTimeGraphLegendsList= "xpath = //div[@id='apexchartsvuechart-area-0']/descendant::span[contains(@class,'apexcharts-legend-text')]";
    private String percentileResponseTimeGraphLegendsColorList = "xpath = //div[@id='apexchartsvuechart-area-0']/descendant::span[contains(@class,'apexcharts-legend-marker')]";
    private String percentileResponseTimeGraphlegendsLineList = "xpath = //div[@id='apexchartsvuechart-area-0']/descendant::*[name()='g' and @class='apexcharts-series']/child::*[name()='path' and @fill='none']";
    private String percentileResponseTimeGraphToolTipColorList = "xpath = //div[@id='apexchartsvuechart-area-0']/descendant::div[@class='apexcharts-tooltip apexcharts-theme-dark apexcharts-active']/descendant::span[@class='apexcharts-tooltip-marker']";
    private String percentileResponseTimeGraphToolTipText = "xpath = //div[@id='apexchartsvuechart-area-0']/descendant::div[@class='apexcharts-tooltip-series-group apexcharts-active']/descendant::span[@class='apexcharts-tooltip-text-y-label']";
    private String percentilrTooltipLable = "xpath = //div[@id='apexchartsvuechart-area-0']//span[@class='apexcharts-tooltip-text-y-label']";
    private String percentilrTooltipValue = "xpath = //div[@id='apexchartsvuechart-area-0']//span[@class='apexcharts-tooltip-text-y-value']";

    private String percentailWidgetP50TooltipValue = "xpath = //div[@id='apexchartsvuechart-area-0']/descendant::div[@class='apexcharts-tooltip apexcharts-theme-dark apexcharts-active']/child::div[position()=2]/descendant::div[@class='apexcharts-tooltip-y-group']" ;
    private String percentailWidgetP75TooltipValue = "xpath = //div[@id='apexchartsvuechart-area-0']/descendant::div[@class='apexcharts-tooltip apexcharts-theme-dark apexcharts-active']/child::div[position()=3]/descendant::div[@class='apexcharts-tooltip-y-group']" ;
    private String percentailWidgetP90TooltipValue = "xpath = //div[@id='apexchartsvuechart-area-0']/descendant::div[@class='apexcharts-tooltip apexcharts-theme-dark apexcharts-active']/child::div[position()=4]/descendant::div[@class='apexcharts-tooltip-y-group']" ;
    private String percentailWidgetP95TooltipValue = "xpath = //div[@id='apexchartsvuechart-area-0']/descendant::div[@class='apexcharts-tooltip apexcharts-theme-dark apexcharts-active']/child::div[position()=5]/descendant::div[@class='apexcharts-tooltip-y-group']" ;
    private String percentailWidgetP99TooltipValue = "xpath = //div[@id='apexchartsvuechart-area-0']/descendant::div[@class='apexcharts-tooltip apexcharts-theme-dark apexcharts-active']/child::div[position()=6]/descendant::div[@class='apexcharts-tooltip-y-group']";
     

	private String queryThresholdDropDownBtn = "#btn-arrow-down-query-threshold-select";
	private String queryThresholdValues ="xpath = //span[contains(@id,'query-threshold-select')]";
	private String queryThresholdSelected = "xpath = //div[@id='query-threshold-select']/div[@class='selected-item-text']"; 
	private String queryStatementculumnData = "//div[@class='data-container']/descendant::div[@class='main-row']/descendant::span[@class='td-span' and position()=1]";
	private String queryStatementFirstQuery = "//div[@class='data-container']/descendant::span[@class='td-span'][1]";
	private String searchQueryTextField = "xpath = //input[@placeholder='Search query']";
	private String noDataIcon = "//div[@class='no-data-icon']";
	private String clearSearchBtn = "#btn-clear-search";
	private String searchBtn = "#btn-search";
	private String firstColumn = "xpath = (//div[@class='test'])[1]";
	private String secondColumn = "xpath = (//div[@class='test'])[2]";
	private String thirdColumn = "xpath = (//div[@class='test'])[3]";
	private String fourthColumn = "xpath = (//div[@class='test'])[4]";
	private String copyQueryBtn = "xpath = //button[@class='action-btn']";
	private String queryStatements = "xpath = (//div[@class='main-row']//span[@class='td-span'])[1]";
	private String maxRespTimes = "xpath = (//div[@class='main-row']//span[@class='td-span'])[2]";
	private String queryCounts = "xpath = (//div[@class='main-row']//span[@class='td-span'])[3]";
	private String selectedTimeline = "xpath = //div[@class='selected-text ellipsis bg-text']";
	private String confirmationMessage = "xpath = //div[@class='ant-notification-notice-with-icon']";
    private String messgaeCloseBtn = "xpath = //*[name()='svg' and @data-icon='close']";	
	private String calanderValue = "xpath = //div[@class='selected-text ellipsis bg-text']";
	
	public ApmDatabasePage(Page page) {
		this.page = page;
	}	
	
	public void navigateToDatabasePage() {
    	page.click(databaseTab);
		page.waitForURL("**/dashboard/appdb/overall");
		Assert.assertTrue(page.isVisible(overallTab));
    }
	
	public void validateNumberOfCallsInLoadGraphHeader() throws EncryptedDocumentException, IOException {
		page.waitForSelector(loadGraphHeader);
		String expectedLoad = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.apmDataValidationSheet, "apmDatabaseCalls");
		String actualLoad = page.textContent(callsOnLoadGraphHeader).trim().replace(" calls", "");
		System.out.println("expectedLoad : "+expectedLoad+"\t actualLoad : "+actualLoad);
		Assert.assertTrue(actualLoad.equals(expectedLoad));
	}
	
	public void validateNumberOfCallsInLoadGraph() throws EncryptedDocumentException, IOException {
		page.waitForSelector(loadGraphHeader);
		int expectedLoad = Integer.parseInt(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.apmDataValidationSheet, "apmDatabaseCalls"));
		int actualLoad = util.getTheSummationFromTheWidgetTooltip(page, loadGraphXPoints, loadGraphTooltip);
		System.out.println("expectedLoad : "+expectedLoad+"\t actualLoad : "+actualLoad);
		Assert.assertTrue(actualLoad == expectedLoad);
	}
	public List<String> allWidgetXPoints()
	{
		 ArrayList<String> xPoint = new ArrayList<String>();
		 xPoint.add(loadGraphXPoints);
		 xPoint.add(accessErrorGraphXPoints);
		 xPoint.add(responseTimeGraphXPoints);
		 xPoint.add(percentileRespTimeGraphXPoints);
		 return xPoint;
	}
	
	public List<String> allWidgetXValues()
	{
		 ArrayList<String> xValue = new ArrayList<String>();
		 xValue.add(loadXaxisValues);
		 xValue.add(errorGraphXaxisValues);
		 xValue.add(responseTimeGraphXaxisValues);
		 xValue.add(percentileResponseTimeGraphXaxisValues);
		 return xValue;
	}
	
	public void navigateToDatabaseTab()
	{
		page.locator(databaseTab).click();
	}
	
	public void clickOnTheQueryTab()
	{
		page.click(queryTab);
		page.waitForLoadState();
	}
	
	public void validateFirstColumnOfQueryTable(String expectedText)
	{
		Assert.assertEquals(page.locator(firstColumn).textContent().trim(), expectedText);
	}
	
	public void validateSecondColumnOfQueryTable(String expectedText)
	{
		Assert.assertEquals(page.locator(secondColumn).textContent().trim(), expectedText);
	}
	
	public void validateThridColumnOfQueryTable(String expectedText)
	{
		Assert.assertEquals(page.locator(thirdColumn).textContent().trim(), expectedText);
	}
	
	public void validateFourthColumnOfQueryTable(String expectedText)
	{
		Assert.assertEquals(page.locator(fourthColumn).textContent().trim(), expectedText);
	}
	
	public void selectTheQueryThreshold(String value)
	{
		page.locator(queryThresholdDropDownBtn).click();
		Locator acutalValues = page.locator(queryThresholdValues);
		
		for (int i = 0 ;i<acutalValues.count();i++)
		{
			System.out.println(acutalValues.nth(i).textContent().trim()+"=========="+value);
            if(acutalValues.nth(i).textContent().trim().equalsIgnoreCase(value))
            {
            	acutalValues.nth(i).click();
                break;
            }
        }
		
	}
	
	public void validateSearchWithValidaData()
	{
		page.waitForSelector(queryStatementFirstQuery);
		String firstElement= page.locator(queryStatementFirstQuery).textContent().trim();
		util.validateSearchFunctionalityWithValidData(page, firstElement, searchQueryTextField, searchBtn,queryStatementculumnData );
	}
	
	public void validateSearchWithInvalidData()
	{
		util.validateSearchFunctionalityWithInvalidData(page, searchQueryTextField, searchBtn, noDataIcon);
	}
	
	public void validateTheQueryThreshouldDropDownValues(String values)
	{
		String[] expectedvalues = values.split(",");
		page.locator(queryThresholdDropDownBtn).click();
		Locator actualValues = page.locator(queryThresholdValues);
		Assert.assertEquals(actualValues.count(), expectedvalues.length);
		for(int i=0;i<actualValues.count();i++)
		{
			Assert.assertEquals(actualValues.nth(i).textContent().trim(), expectedvalues[i]);
		}
	}
	
	public void validateTheQueryThresholdSelectedValue(String expectedValue)
	{
		String actualtext = page.locator(queryThresholdSelected).textContent().trim();
		Assert.assertEquals(actualtext, expectedValue);
	}
	
	public void ValidateTheQueryPage()
	{
		//validathe the URL
		String expectedUrl="**/apm/dashboard/appdb/query";
		page.waitForURL(expectedUrl);
		Assert.assertTrue(page.url().endsWith("/apm/dashboard/appdb/query"));
		
		//validate the queryThresholdDropDownBtn ois visible or not on Query page
		Assert.assertTrue(page.locator(queryThresholdDropDownBtn).isVisible());
	}
	
	public void validatedataBasepage()
	{
		Assert.assertTrue(page.locator(overallTab).isVisible());
		Assert.assertTrue(page.locator(queryTab).isVisible());
	}
	
	public void validateLoadTitle(String expectedTitle)
	{
		util.ValidateTheTitle(page.locator(loadGraphHeader).textContent().trim(), expectedTitle);
	}
	
	public void validateLoadXaxisTitle(String expectedTitle)
	{
		util.ValidateTheTitle(page.locator(loadGraphXAxisTitle).textContent().trim(), expectedTitle);
	}
	
	public void validateLoadYaxisTitle(String expectedTitle)
	{
		util.ValidateTheTitle(page.locator(loadGraphYAxisTitle).textContent().trim(), expectedTitle);
	}
	
	public void validateLoadZoomIn()
	{
		page.waitForURL("**/apm/dashboard/appdb/overall");
		util.graphZoomIn(page, loadGraphZoomInBtn, loadGraphZoomResetBtn, allWidgetXPoints());
	}
	
	public void validateLoadZoomOut()
	{
		page.waitForURL("**/apm/dashboard/appdb/overall");
		util.graphZoomOut(page, loadGraphZoomInBtn,loadGraphZoomOutBtn, loadGraphZoomResetBtn, allWidgetXPoints());
	}
	
	public void validateLoadZoomReset()
	{
		page.waitForURL("**/apm/dashboard/appdb/overall");
		util.graphZoomReset(page, loadGraphZoomInBtn, loadGraphZoomResetBtn, allWidgetXPoints());
	}
	
	public void validateLoadDragDrop()
	{
		page.waitForURL("**/apm/dashboard/appdb/overall");
		util.graphZoomInByDragAndDrop(page, loadGraphXPoints, loadGraphZoomResetBtn, allWidgetXPoints());
	}
	
	public void validateLoadTooltipTitle() throws InterruptedException
	{
		page.waitForURL("**/apm/dashboard/appdb/overall");
		util.validateWidgetToolTips(page,loadGraphXPoints, loadGraphTooltip);
	}
	

	public void validateErrorTitle(String expectedTitle)
	{
		util.ValidateTheTitle(page.locator(accessErrorGraphHeader).textContent().trim(), expectedTitle);
	}
	
	public void validateErrorXaxisTitle(String expectedTitle)
	{
		util.ValidateTheTitle(page.locator(accessErrorGraphXAxisTitle).textContent().trim(), expectedTitle);
	}
	
	public void validateErrorYaxisTitle(String expectedTitle)
	{
		util.ValidateTheTitle(page.locator(accessErrorGraphYAxisTitle).textContent().trim(), expectedTitle);
	}
	
	public void validateErrorZoomIn()
	{
		page.waitForURL("**/apm/dashboard/appdb/overall");
		util.graphZoomIn(page, accessErrorGraphZoomInBtn, accessErrorGraphZoomResetBtn, allWidgetXPoints());
	}
	
	public void validateErrorZoomOut()
	{
		page.waitForURL("**/apm/dashboard/appdb/overall");
		util.graphZoomOut(page, accessErrorGraphZoomInBtn,accessErrorGraphZoomOutBtn, accessErrorGraphZoomResetBtn, allWidgetXPoints());
	}
	
	public void validateErrorZoomReset()
	{
		page.waitForURL("**/apm/dashboard/appdb/overall");
		util.graphZoomReset(page, accessErrorGraphZoomInBtn, accessErrorGraphZoomResetBtn, allWidgetXPoints());
	}
	
	public void validatErrorDragDrop()
	{
		page.waitForURL("**/apm/dashboard/appdb/overall");
		util.graphZoomInByDragAndDrop(page, loadGraphXPoints, accessErrorGraphZoomResetBtn, allWidgetXPoints());
	}
	
	public void validateErrorTooltipTitle() throws InterruptedException
	{
		page.waitForURL("**/apm/dashboard/appdb/overall");
		util.validateWidgetToolTips(page, loadGraphXPoints, accessErrorGraphTooltip);
	}
	
	
	public void validateResposeTimeTitle(String expectedTitle)
	{
		util.ValidateTheTitle(page.locator(responseTimeGraphHeader).textContent().trim(), expectedTitle);
	}
	
	public void validateResposeTimeXaxisTitle(String expectedTitle)
	{
		util.ValidateTheTitle(page.locator(responseTimeGraphXAxisTitle).textContent().trim(), expectedTitle);
	}
	
	public void validateResposeTimeYaxisTitle(String expectedTitle)
	{
		util.ValidateTheTitle(page.locator(responseTimeGraphYAxisTitle).textContent().trim(), expectedTitle);
	}
	
	public void validateResposeTimeZoomIn()
	{
		page.waitForURL("**/apm/dashboard/appdb/overall");
		util.graphZoomIn(page, responseTimeGraphZoomInBtn, responseTimeGraphZoomResetBtn, allWidgetXPoints());
	}
	
	public void validateResposeTimeZoomOut()
	{
		page.waitForURL("**/apm/dashboard/appdb/overall");
		util.graphZoomOut(page, responseTimeGraphZoomInBtn,responseTimeGraphZoomOutBtn, responseTimeGraphZoomResetBtn, allWidgetXPoints());
	}
	
	public void validateResposeTimeZoomReset()
	{
		page.waitForURL("**/apm/dashboard/appdb/overall");
		util.graphZoomReset(page, responseTimeGraphZoomInBtn, responseTimeGraphZoomResetBtn, allWidgetXPoints());
	}
	
	public void validateResposeTimeDragDrop()
	{
		page.waitForURL("**/apm/dashboard/appdb/overall");
		util.graphZoomInByDragAndDrop(page, responseTimeGraphXPoints, responseTimeGraphZoomResetBtn, allWidgetXPoints());
	}
	
	public void validateResposeTimeTooltipTitle() throws InterruptedException
	{
		page.waitForURL("**/apm/dashboard/appdb/overall");
		util.validateWidgetToolTips(page, responseTimeGraphXPoints, responseTimeGraphTooltip);
	}
	
	public void validatePercentileResponseTimeTitle(String expectedTitle)
	{
		util.ValidateTheTitle(page.locator(percentileRespTimeGraphHeader).textContent().trim(), expectedTitle);
	}
	
	public void validatePercentileResponseTimeXaxisTitle(String expectedTitle)
	{
		util.ValidateTheTitle(page.locator(percentileRespTimeGraphXAxisTitle).textContent().trim(), expectedTitle);
	}
	
	public void validatePercentileResponseTimeYaxisTitle(String expectedTitle)
	{
		util.ValidateTheTitle(page.locator(percentileRespTimeGraphYAxisTitle).textContent().trim(), expectedTitle);
	}
	
	public void validatePercentileResponseTimeZoomIn()
	{
		page.waitForURL("**/apm/dashboard/appdb/overall");
		util.graphZoomIn(page, percentileRespTimeGraphZoomInBtn, percentileRespTimeGraphZoomResetBtn, allWidgetXPoints());
	}
	
	public void validatePercentileResponseTimeZoomOut()
	{
		page.waitForURL("**/apm/dashboard/appdb/overall");
		util.graphZoomOut(page, percentileRespTimeGraphZoomInBtn,percentileRespTimeGraphZoomOutBtn, percentileRespTimeGraphZoomResetBtn, allWidgetXPoints());
	}
	
	public void validatePercentileResponseTimeZoomReset()
	{
		page.waitForURL("**/apm/dashboard/appdb/overall");
		util.graphZoomReset(page, percentileRespTimeGraphZoomInBtn, percentileRespTimeGraphZoomResetBtn, allWidgetXPoints());
	}
	
	public void validatePercentileResponseTimeDragDrop()
	{
		page.waitForURL("**/apm/dashboard/appdb/overall");
		util.graphZoomInByDragAndDrop(page, percentileRespTimeGraphXPoints, percentileRespTimeGraphZoomResetBtn, allWidgetXPoints());
	}
	
	public void validatePercentileResponseTimeTooltipTitle() throws InterruptedException
	{
		page.waitForURL("**/apm/dashboard/appdb/overall");
		util.validateWidgetToolTips(page,percentileRespTimeGraphXPoints, percentileResponseTimeGraphToolTip);
	}
	
	public void validateWidgetLegendsForPercentailResposeTimeGraph(String expectedLegends)
	{
		page.waitForURL("**/apm/dashboard/appdb/overall");
		util.validateWidgetLegendsText(page,percentileResponseTimeGraphLegendsList,expectedLegends );
	}
	
	public void validatepercentileResponseTimewidgetLegends()
	{
		page.waitForTimeout(1000);
		page.waitForURL("**/apm/dashboard/appdb/overall");
		util.validateWidgetLegends(page, percentileResponseTimeGraphLegendsList, percentileResponseTimeGraphLegendsColorList,percentileResponseTimeGraphlegendsLineList ,percentileResponseTimeGraphToolTipColorList ,percentileRespTimeGraphXPoints,percentileResponseTimeGraphToolTipText);
	}
	public void validateTheGivenTimeLine()
	{
		page.waitForTimeout(2000);
		page.waitForURL("**/apm/dashboard/appdb/overall");
		util.validateTheGraphdisplayingTheDataAsPerGivenTimeLines(page,loadXaxisValues,calanderValue,allWidgetXValues());
	}
	

	public void validateTheCustomTimeLine(String period)
	{
		System.out.println("period: "+period);
		page.waitForTimeout(2000);
		page.waitForURL("**/apm/dashboard/appdb/overall");
		util.validateCustomTimeLine(page,loadXaxisValues,period,allWidgetXValues());
	}
		
	public void validateCallsPerMinuteInLoadGraphHeader() throws EncryptedDocumentException, IOException {
		page.waitForSelector(loadGraphHeader);
		int expectedCpm = 0;
		String cpmInHeader = page.textContent(callsPerMinOnLoadGraphHeader).trim().replace(" calls/min", "");
		int load = Integer.parseInt(page.textContent(callsOnLoadGraphHeader).trim().replace(" calls", ""));
		String timeline = page.textContent(selectedTimeline).trim();
		if(timeline.contains("mins"))
		{
			int time = Integer.parseInt(timeline.replace(" mins",""));
			expectedCpm = load/time;
		}
		else
		{
			expectedCpm = 0;
		}
		int actualCpm = Integer.parseInt(cpmInHeader);
		System.out.println("expectedCpm :"+expectedCpm+"\t actualCpm :"+actualCpm);
		Assert.assertTrue(actualCpm == expectedCpm);
	}
	
	public void validateNumberOfErrorsInAccessErrorGraphHeader() throws EncryptedDocumentException, IOException {
		page.waitForSelector(loadGraphHeader);
		String expectedErrors = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.apmDataValidationSheet, "apmDatabaseErrors");
		String actualErrors = page.textContent(errorsOnAccessErrorGraphHeader).trim().replace(" errors", "");
		System.out.println("expectedErrors : "+expectedErrors+"\t actualErrors : "+actualErrors);
		Assert.assertTrue(actualErrors.equals(expectedErrors));
	}
	
	public void validateNumberOfErrorsInAccessErrorGraph() throws EncryptedDocumentException, IOException {
		page.waitForSelector(accessErrorGraphHeader);
		int expectedError = Integer.parseInt(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.apmDataValidationSheet, "apmDatabaseErrors"));
		int actualError = util.getTheSummationFromTheWidgetTooltip(page, accessErrorGraphXPoints, accessErrorGraphTooltip);
		System.out.println("expectedError : "+expectedError+"\t actualError : "+actualError);
		Assert.assertTrue(actualError == expectedError);
	}
	
	public void validateErrorsPerMinuteInAccessErrorGraphHeader() throws EncryptedDocumentException, IOException {
		page.waitForSelector(accessErrorGraphHeader);
		int expectedEpm = 0;
		String epmInHeader = page.textContent(errorsPerMinOnAccessErrorGraphHeader).trim().replace(" errors/min", "");
		int error = Integer.parseInt(page.textContent(errorsOnAccessErrorGraphHeader).trim().replace(" errors", ""));
		String timeline = page.textContent(selectedTimeline).trim();
		if(timeline.contains("mins"))
		{
			int time = Integer.parseInt(timeline.replace(" mins",""));
			expectedEpm = error/time;
		}
		else
		{
			expectedEpm = 0;
		}
		int actualEpm = Integer.parseInt(epmInHeader);
		System.out.println("expectedEpm :"+expectedEpm+"\t actualEpm :"+actualEpm);
		Assert.assertTrue(actualEpm == expectedEpm);
	}
	
	public void validateErrorsPercentageInAccessErrorGraphHeader() {
		page.waitForSelector(accessErrorGraphHeader);
		DecimalFormat df=new DecimalFormat("#.##");
		//df.setRoundingMode(RoundingMode.UP);
        String errorPercent = page.textContent(errorPercentOnAccessErrorGraphHeader).trim().replace("%", "");
		int errors = Integer.parseInt(page.textContent(errorsOnAccessErrorGraphHeader).trim().replace(" errors", ""));
        int calls = Integer.parseInt(page.textContent(callsOnLoadGraphHeader).trim().replace(" calls", ""));
        double expectedErrorPercent = (Double.parseDouble(df.format(errors*100/calls)));
        double actualErrorPercent = Double.parseDouble(errorPercent);
        System.out.println("actualErrorPercent :"+actualErrorPercent+"\t expectedErrorPercent :"+expectedErrorPercent);
        Assert.assertTrue(actualErrorPercent == expectedErrorPercent);
	}
	
	public void validateTheAverageResponseTimeInResponseTimeGraph() {
		page.waitForSelector(responseTimeGraphHeader);
		HoverOptions hoverOpt = new HoverOptions();
		hoverOpt.setForce(true);
		String avgRespTime = page.textContent(respTimeAvgOnResponseTimeGraphHeader).trim().replace(" ms average", "");
        int expectedAvgRespTime = Integer.parseInt(avgRespTime);
        int totalCalls = 0;
        int totalRespTime = 0;
        Locator loadXpoints = page.locator(loadGraphXPoints);

        page.waitForTimeout(1000);
        for(int i=0; i<loadXpoints.count(); i++){
        	if(i == loadXpoints.count()-1)
        		hoverOpt.setPosition(0, -10);
        	else
        		hoverOpt.setPosition(2, -10);
        			
        	loadXpoints.nth(i).hover(hoverOpt);
        	page.waitForSelector(loadGraphTooltip);
            int loadTooltip = (int)Double.parseDouble(page.textContent(loadGraphTooltip));
            totalCalls += loadTooltip;

            int respTimeTooltip = Integer.parseInt(page.textContent(responseTimeGraphTooltip));
            totalRespTime += (loadTooltip*respTimeTooltip);
            page.waitForTimeout(50);
		}
        System.out.println("totalCalls : "+totalCalls);
        System.out.println("totalRespTime :"+totalRespTime);
        int actualRespTime = totalRespTime/totalCalls;
        System.out.println("actualRespTime :"+actualRespTime+"\t expectedAvgRespTime :"+expectedAvgRespTime);
        Assert.assertTrue(actualRespTime == expectedAvgRespTime);
	}
	
	public void validateTheQueryStatementInQueryPage() throws EncryptedDocumentException, IOException {
		String expectedQuery = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.apmDataValidationSheet, "queryStatement");
		page.click(queryTab);
		page.waitForSelector(queryThresholdDropDownBtn);
		util.selectTheOptionFromDropDown(page, queryThresholdDropDownBtn, "1ms");
		page.waitForSelector(queryStatements);
		Locator queries = page.locator(queryStatements);
		boolean flag = false;
		for(int i=0; i<queries.count(); i++) {
			if(queries.nth(i).textContent().trim().equals(expectedQuery)) {
				flag = true;
				break;
			}
		}
		Assert.assertTrue(flag);
	}
	
	public void validateTheQueryStatementCopyButton() throws EncryptedDocumentException, IOException {
		String messgae = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath, IPathConstant.messageSheet, "CopyConfirmationMessgae");
		page.click(queryTab);
		page.waitForSelector(queryThresholdDropDownBtn);
		util.selectTheOptionFromDropDown(page, queryThresholdDropDownBtn, "1ms");
		page.waitForSelector(queryStatements);
		Assert.assertTrue(page.isVisible(copyQueryBtn));
		page.click(copyQueryBtn);
		page.waitForSelector(confirmationMessage);
		Assert.assertTrue(page.textContent(confirmationMessage).trim().contains(messgae));
		page.click(messgaeCloseBtn);
	}
	
	public void validateTheQueryCountForTheQueryStatement() throws EncryptedDocumentException, IOException {
		String query = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.apmDataValidationSheet, "queryStatement");
		String count = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.apmDataValidationSheet, "queryCount");
		Locator statements = page.locator(queryStatements);
		Locator counts = page.locator(queryCounts);
		page.click(queryTab);
		page.waitForSelector(queryThresholdDropDownBtn);
		util.selectTheOptionFromDropDown(page, queryThresholdDropDownBtn, "1ms");
		page.waitForSelector(queryStatements);
		for(int i=0; i<statements.count(); i++)
        {
            if(statements.nth(i).textContent().trim().equals(query)) {
            	//System.out.println("expectedCount : "+ count+"actualCount : "+counts.nth(i).textContent().trim());
                Assert.assertTrue(counts.nth(i).textContent().trim().equals(count));
                break;
            }
        }
	}
	
	public void validateTheDatabaseNameInDatabasePage() throws EncryptedDocumentException, IOException {
		String dbName = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.apmDataValidationSheet, "databaseName");
		page.click(searchDatabaseDropDown);
		page.fill(searchDatabaseTextField, dbName);
		Assert.assertTrue(page.locator(searchDbResults).count() == 1);
	}
	
	public void validateThePercentileResponseTimeOnDatabasePage() throws EncryptedDocumentException, IOException {
		page.waitForSelector(percentileRespTimeGraphHeader);
		LinkedHashMap<String,String> expectedPercentile = new LinkedHashMap<String,String>();
		String ResponseTimes = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.apmDataValidationSheet, "ResponseTimes");
		String[] responseTime=ResponseTimes.split(",");
		//System.out.println(responseTime.length);
		DecimalFormat df=new DecimalFormat("#");
		df.setRoundingMode(RoundingMode.UP);
		String expectedP50= df.format((50.0/100.0)*responseTime.length);
		String expectedP75= df.format((75.0/100.0)*responseTime.length);
		String expectedP90= df.format((90.0/100.0)*responseTime.length);
		String expectedP95= df.format((95.0/100.0)*responseTime.length);
		String expectedP99= df.format((99.0/100.0)*responseTime.length);
        expectedPercentile.put("P50",responseTime[Integer.parseInt(expectedP50)-1]);
        expectedPercentile.put("P75",responseTime[Integer.parseInt(expectedP75)-1]);
        expectedPercentile.put("P90",responseTime[Integer.parseInt(expectedP90)-1]);
        expectedPercentile.put("P95",responseTime[Integer.parseInt(expectedP95)-1]);
        expectedPercentile.put("P99",responseTime[Integer.parseInt(expectedP99)-1]);		
        System.out.println("expectedPercentile : "+expectedPercentile);
        
        HoverOptions hoverOpt = new HoverOptions();
        hoverOpt.setForce(true);
        hoverOpt.setPosition(2, -10);
        Locator points = page.locator(percentileRespTimeGraphXPoints);
        
		LinkedHashMap<String,String> actualPercentile = new LinkedHashMap<String,String>();
		for(int i=0; i<points.count(); i++){
			points.nth(i).hover(hoverOpt);
            page.waitForSelector(percentileRespTimeGraphTooltipLabel);
            
         	Locator labels = page.locator(percentileRespTimeGraphTooltipLabel);
         	Locator tooltip = page.locator(percentileRespTimeGraphTooltipValue);
			
         	LinkedHashMap<String, String> percentileValues = new LinkedHashMap<String,String>();
			int sum=0;
			for(int j=0; j<labels.count(); j++) {
				percentileValues.put(labels.nth(j).textContent().trim().toUpperCase(), tooltip.nth(j).textContent().trim().toUpperCase());
				sum = sum + (Integer.parseInt(tooltip.nth(j).textContent().trim()));
			}
			if(sum!=0)
				actualPercentile.putAll(percentileValues);
		}
		System.out.println("actualPercentile :"+actualPercentile+"\n expectedPercentile :"+expectedPercentile);
		Assert.assertTrue(actualPercentile.equals(expectedPercentile));
	}
	
	public String getAverageResponseTimeFromResponseTimeGraph() {
		navigateToDatabasePage();
		page.waitForLoadState(LoadState.DOMCONTENTLOADED);
		page.waitForTimeout(1500);
		String respTime = page.textContent(respTimeAvgOnResponseTimeGraphHeader).trim().replace(" ms average", "");
		return respTime;
	}
	
	public String getNumberOfCallsFromLoadGraph() {
		navigateToDatabasePage();
		page.waitForLoadState(LoadState.DOMCONTENTLOADED);
		page.waitForTimeout(1500);
		String calls = page.textContent(callsOnLoadGraphHeader).trim().replace(" calls", "");
		return calls;
	}
	
	public String getCallsPerMinuteFromLoadGraph() {
		navigateToDatabasePage();
		page.waitForLoadState(LoadState.DOMCONTENTLOADED);
		page.waitForTimeout(1500);
		String cpm = page.textContent(callsPerMinOnLoadGraphHeader).trim().replace(" calls/min", "");
		return cpm;
	}
	
	public String getNumberOfErrorsFromAccessErrorGraph() {
		navigateToDatabasePage();
		page.waitForLoadState(LoadState.DOMCONTENTLOADED);
		page.waitForTimeout(1500);
		String errors = page.textContent(errorsOnAccessErrorGraphHeader).trim().replace(" errors", "");
		return errors;
	}
	
	public String getErrorsPerMinuteFromAccessErrorGraph() {
		navigateToDatabasePage();
		page.waitForLoadState(LoadState.DOMCONTENTLOADED);
		page.waitForTimeout(1500);
		String epm = page.textContent(errorsPerMinOnAccessErrorGraphHeader).trim().replace(" errors/min", "");
		return epm;
	}
	
	public String getErrorsPercentageFromAccessErrorGraph() {
		navigateToDatabasePage();
		page.waitForLoadState(LoadState.DOMCONTENTLOADED);
		page.waitForTimeout(1500);
		String errorPercent = page.textContent(errorPercentOnAccessErrorGraphHeader).trim().replace("%", "");
		return errorPercent;
	}
	
	public List<Object> getPercentileResponseTime() {
		navigateToDatabasePage();
		page.waitForLoadState(LoadState.DOMCONTENTLOADED);
		page.waitForTimeout(1500);
		List<Object> expectedPercentile = new ArrayList<Object>();
		HoverOptions hoverOpt = new HoverOptions();
		hoverOpt.setForce(true);
		Locator data = page.locator(percentileRespTimeGraphXPoints);
		for (int i=0; i<data.count(); i++) {
			if(i==data.count()-1) 
				hoverOpt.setPosition(0, -10);
			else
				hoverOpt.setPosition(2, -10);

			data.nth(i).hover(hoverOpt);
			page.waitForSelector(percentileResponseTimeGraphToolTip);
			Locator label = page.locator(percentileRespTimeGraphTooltipLabel);
			Locator value = page.locator(percentileRespTimeGraphTooltipValue);
				HashMap<String, String> percentileValues = new HashMap<String,String>();
				int sum=0;
				for(int j=0; j<label.count(); j++) {
					page.waitForTimeout(50);
					percentileValues.put(label.nth(j).textContent().trim().toUpperCase(), value.nth(j).textContent().trim().toUpperCase());
					sum = sum + (Integer.parseInt(value.nth(j).textContent().trim()));
				}
				if(sum!=0)
					expectedPercentile.add(percentileValues);
		}
		System.out.println(expectedPercentile);
		return expectedPercentile;
	}
}
