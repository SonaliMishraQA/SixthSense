package objectRepository.BM;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.bag.SynchronizedSortedBag;
import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Locator.HoverOptions;
import com.microsoft.playwright.options.LoadState;

import genericUtilities.ExcelUtility;
import genericUtilities.GenericMethods;
import genericUtilities.IPathConstant;

public class BmApplicationPage {
	Page page;
	GenericMethods util = new GenericMethods();
	ExcelUtility excel = new ExcelUtility();

	private String selectApplicationDropdownBtn = "#btn-arrow-down-search-select-application";
	private String searchApplicationTextField = "#input-search-sel-search-select-application";
	private String selectApplicationSearchResult = "xpath = //span[@class='selected-item-text']";
	private String searchApplicationCloseBtn = "xpath = btn-close-btn";
	private String selectedApplication = "xpath = //div[@class='selected-item-text']";
	
	private String applicationTab = "#nav-tab-application";
	private String apdexScoreWidgetTitle = "xpath = //div[@class='gauge-semi-chart-title']";
	private String apdexScoreInWidget = "xpath = //div[@class='vue-apexcharts']/descendant::*[name()='g' and @class='apexcharts-datalabels-group']";
	private String apdexImageInWidget = "xpath = //*[name()='g' and @class='apexcharts-series apexcharts-radial-series']/*[name()='path']";
	private String apdexHealthIndicatorLabel = "xpath = //div[@class='apdex-label-header']";	
	private String goodApdexStatusIndicator = "xpath = //div[@class='apdex-status-indicator apdex-bg-good']";
	private String goodApdexStatusLabel = "xpath = //div[@class='apdex-status-label-text apdex-color-good']";
	private String goodApdexStatusValue = "xpath = //div[@class='apdex-status-value-text apdex-color-good']";
	private String fairApdexStatusIndicator = "xpath = //div[@class='apdex-status-indicator apdex-bg-fair']";
	private String fairApdexStatusLabel = "xpath = //div[@class='apdex-status-label-text apdex-color-fair']";
	private String fairApdexStatusValue = "xpath = //div[@class='apdex-status-value-text apdex-color-fair']";
	private String poorApdexStatusIndicator = "xpath = //div[@class='apdex-status-indicator apdex-bg-poor']";
	private String poorApdexStatusLabel = "xpath = //div[@class='apdex-status-label-text apdex-color-poor']";
	private String poorApdexStatusValue = "xpath = //div[@class='apdex-status-value-text apdex-color-poor']";
	
	private String loadWidgetTitle = "xpath = //div[@id='apexchartsvuechart-line-1']/ancestor::div[@class='chart-body']/preceding-sibling::div/div[@class='line-title']";
	private String loadWidgetXaxisTitle = "xpath = //div[@id='apexchartsvuechart-line-1']/descendant::*[name()='g' and @class='apexcharts-xaxis-title']";
	private String loadWidgetYaxisTitle = "xpath = //div[@id='apexchartsvuechart-line-1']/descendant::*[name()='g' and @class='apexcharts-yaxis-title']";
	private String loadWidgetZoomInBtn = "#Load-zoom-in";
	private String loadWidgetZoomOutBtn = "#Load-zoom-out";
	private String loadWidgetZoomResetBtn = "#Load-zoom-reset";
	private String loadWidgetXaxisPoints = "xpath = //div[@id='apexchartsvuechart-line-1']//*[name()='line' and @class='apexcharts-xaxis-tick']";
	private String loadWidgetTooltipTitle = "xpath = //div[@id='apexchartsvuechart-line-1']//div[@class='apexcharts-tooltip-title']";
	private String loadWidgetTooltipValue = "xpath = //div[@id='apexchartsvuechart-line-1']/descendant::span[@class='apexcharts-tooltip-text-y-value']";
	private String loadWidgetXaxisLabels = "xpath = //div[@id='apexchartsvuechart-line-1']//*[name()='g' and @class='apexcharts-xaxis-texts-g']//*[name()='tspan' and contains(text(),'-')]";
	private String callsOnLoadWidgetHeader = "xpath = //span[@class='line-content-calls']";
	private String cpmOnLoadWidgetHeader = "xpath = //span[@class='line-content-calls']/following-sibling::span";
	
	private String loadTimeWidgetTitle = "xpath = //div[@id='apexchartsvuechart-line-2']/ancestor::div[@class='chart-body']/preceding-sibling::div/div[@class='line-title']";
	private String loadTimeWidgetXaxisTitle = "xpath = //div[@id='apexchartsvuechart-line-2']/descendant::*[name()='g' and @class='apexcharts-xaxis-title']";
	private String loadTimeWidgetYaxisTitle = "xpath = //div[@id='apexchartsvuechart-line-2']/descendant::*[name()='g' and @class='apexcharts-yaxis-title']";
	private String loadTimeWidgetZoomInBtn = "#Load-time-zoom-in";
	private String loadTimeWidgetZoomOutBtn = "#Load-time-zoom-out";
	private String loadTimeWidgetZoomResetBtn = "#Load-time-zoom-reset";
	private String loadTimeWidgetXaxisPoints = "xpath = //div[@id='apexchartsvuechart-line-2']//*[name()='line' and @class='apexcharts-xaxis-tick']";
	private String loadTimeWidgetTooltipTitle = "xpath = //div[@id='apexchartsvuechart-line-2']//div[@class='apexcharts-tooltip-title']";
	private String loadTimeWidgetTooltipValue = "xpath = //div[@id='apexchartsvuechart-line-2']/descendant::span[@class='apexcharts-tooltip-text-y-value']";
	private String loadTimeWidgetXaxisLabels = "xpath = //div[@id='apexchartsvuechart-line-2']//*[name()='g' and @class='apexcharts-xaxis-texts-g']//*[name()='tspan' and contains(text(),'-')]";
	private String averageRespTimeOnLoadTimeWidgetHeader = "xpath = //div[contains(.,'Load time')]/following-sibling::div[@class='line-content']";
	
	private String errorWidgetTitle = "xpath = //div[@id='apexchartsvuechart-line-3']/ancestor::div[@class='chart-body']/preceding-sibling::div/div[@class='line-title']";
	private String errorWidgetXaxisTitle = "xpath = //div[@id='apexchartsvuechart-line-3']/descendant::*[name()='g' and @class='apexcharts-xaxis-title']";
	private String errorWidgetYaxisTitle = "xpath = //div[@id='apexchartsvuechart-line-3']/descendant::*[name()='g' and @class='apexcharts-yaxis-title']";
	private String errorWidgetZoomInBtn = "#Error-zoom-in";
	private String errorWidgetZoomOutBtn = "#Error-zoom-out";
	private String errorWidgetZoomResetBtn = "#Error-zoom-reset";
	private String errorWidgetXaxisPoints = "xpath = //div[@id='apexchartsvuechart-line-3']//*[name()='line' and @class='apexcharts-xaxis-tick']";
	private String errorWidgetTooltipTitle = "xpath = //div[@id='apexchartsvuechart-line-3']//div[@class='apexcharts-tooltip-title']";
	private String errorWidgetTooltipValue = "xpath = //div[@id='apexchartsvuechart-line-3']/descendant::span[@class='apexcharts-tooltip-text-y-value']";
	private String errorWidgetXaxisLabels = "xpath = //div[@id='apexchartsvuechart-line-3']//*[name()='g' and @class='apexcharts-xaxis-texts-g']//*[name()='tspan' and contains(text(),'-')]";
	private String epmOnErrorWidgetHeader = "xpath = //span[@class='line-errors']/following-sibling::span";
	private String errorsOnErrorWidgetHeader = "xpath = //span[@class='line-errors']";
	
	private String userImpactedByErrorsWidgetTitle = "xpath = //div[@class='bar-title']";
	private String userImpactedByErrorsWidgetXaxisTitle = "xpath = //div[@id='apexchartsvuechart-bar-0']//*[name()='g' and @class='apexcharts-xaxis-title']";
	private String userImpactedByErrorsWidgetYaxisTitle = "xpath = //div[@id='apexchartsvuechart-bar-0']//*[name()='g' and @class='apexcharts-yaxis-title']";
	private String userImpactedByErrorsWidgetXaxisPoints = "xpath = //div[@id='apexchartsvuechart-bar-0']/descendant::*[name()='line' and @class='apexcharts-xaxis-tick']";
	private String userImpactedByErrorsWidgetTooltipTitle = "xpath = //div[@id='apexchartsvuechart-bar-0']/descendant::div[@class='apexcharts-tooltip-title']";
	private String userImpactedByErrorsWidgetTooltipValue = "xpath = //div[@id='apexchartsvuechart-bar-0']/descendant::span[@class='apexcharts-tooltip-text-y-value']";
	private String userImpactedByErrorsWidgetXaxisLabels = "xpath = //div[@id='apexchartsvuechart-bar-0']//*[name()='g' and @class='apexcharts-xaxis-texts-g']//*[name()='tspan' and contains(text(),'-')]";
	
	private String errorCountmapWidgetTitle = ".slow-title";
	private String errorMapToolTipTitle = "xpath = //div[@class='vue-map-legend-header']/span";
	private String errorMapToolTipValue = "xpath = //div[@class='vue-map-legend-content']/span";
	private String countriesOnErrorMap = "xpath = //div[@class='multi-header-card-body']//*[name()='path']";
	private String indiaOnErrorMap = "xpath = //div[@class='multi-header-card-body']//*[name()='path' and @id='IN']";
	private String selectedTimeline = "xpath = //div[@class='selected-text ellipsis bg-text']";

	List<String> xPoints = new ArrayList<String>();
	{
		xPoints.add(loadWidgetXaxisPoints);
		xPoints.add(loadTimeWidgetXaxisPoints);
		xPoints.add(errorWidgetXaxisPoints);
	}
	
	List<String> xaxisLabels = new ArrayList<String>();
	{
		xaxisLabels.add(loadWidgetXaxisLabels);
		xaxisLabels.add(loadTimeWidgetXaxisLabels);
		xaxisLabels.add(errorWidgetXaxisLabels);
		xaxisLabels.add(userImpactedByErrorsWidgetXaxisLabels);
	}
	
	public BmApplicationPage(Page page) {
		this.page = page;
	}
	
	public void selectApplication() throws EncryptedDocumentException, IOException{
		String application = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath,IPathConstant.bmApplicationSheet, "bmApplicationName");
		util.selectTheOptionFromDropDownBySearch(page, selectApplicationDropdownBtn, searchApplicationTextField, application, selectApplicationSearchResult);
	}
	
	public void selectApplication(String application) throws EncryptedDocumentException, IOException{
		util.selectTheOptionFromDropDownBySearch(page, selectApplicationDropdownBtn, searchApplicationTextField, application, selectApplicationSearchResult);
	}
	
	public void validateWhetherTheApplicationTabIsActiveByDefault() {
		Assert.assertTrue(page.getAttribute(applicationTab, "class").contains("activeRouter"));
	}
	
	public void validateTheTitleOfApdexScoreWidget() throws EncryptedDocumentException, IOException {
		String title = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath,IPathConstant.bmApplicationSheet, "apdexScoreWidgetTitle");
		util.ValidateTheTitle(page, apdexScoreWidgetTitle, title);
	}
	
	public void validateTheTitleOfHealthIndicatorLabelInApdexScoreWidget() throws EncryptedDocumentException, IOException {
		String title = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath,IPathConstant.bmApplicationSheet, "apdexHealthIndicatorLabel");
		util.ValidateTheTitle(page, apdexHealthIndicatorLabel, title);
	}
	
	public void validateTheLabelAndValueOfGoodHealthIndicatorInApdexScoreWidget() throws EncryptedDocumentException, IOException {
		String label = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath,IPathConstant.bmApplicationSheet, "goodApdexStatusLabel");
		util.ValidateTheTitle(page, goodApdexStatusLabel, label);
		String value = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath,IPathConstant.bmApplicationSheet, "goodApdexStatusValue");
		util.ValidateTheTitle(page, goodApdexStatusValue, value);
	}
	
	public void validateTheLabelAndValueOfFairHealthIndicatorInApdexScoreWidget() throws EncryptedDocumentException, IOException {
		String label = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath,IPathConstant.bmApplicationSheet, "fairApdexStatusLabel");
		util.ValidateTheTitle(page, fairApdexStatusLabel, label);
		String value = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath,IPathConstant.bmApplicationSheet, "fairApdexStatusValue");
		util.ValidateTheTitle(page, fairApdexStatusValue, value);
	}
	
	public void validateTheLabelAndValueOfPoorHealthIndicatorInApdexScoreWidget() throws EncryptedDocumentException, IOException {
		String label = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath,IPathConstant.bmApplicationSheet, "poorApdexStatusLabel");
		util.ValidateTheTitle(page, poorApdexStatusLabel, label);
		String value = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath,IPathConstant.bmApplicationSheet, "poorApdexStatusValue");
		util.ValidateTheTitle(page, poorApdexStatusValue, value);
	}
	
	public void validateTheColorOfTheGoodHealthIndicatorElementsInApdexScoreWidget() throws EncryptedDocumentException, IOException {
		String expectedColor = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath,IPathConstant.bmApplicationSheet, "goodApdexColor");
		String iconColor = (String) page.locator(goodApdexStatusIndicator).evaluate("element => window.getComputedStyle(element).getPropertyValue('background-color')");
		Assert.assertTrue(iconColor.contains(expectedColor));
		String labelColor = (String) page.locator(goodApdexStatusLabel).evaluate("element => window.getComputedStyle(element).getPropertyValue('color')");
		Assert.assertTrue(labelColor.contains(expectedColor));
		String valueColor = (String) page.locator(goodApdexStatusValue).evaluate("element => window.getComputedStyle(element).getPropertyValue('color')");
		Assert.assertTrue(valueColor.contains(expectedColor));
	}
	
	public void validateTheColorOfTheFairHealthIndicatorElementsInApdexScoreWidget() throws EncryptedDocumentException, IOException {
		String expectedColor = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath,IPathConstant.bmApplicationSheet, "fairApdexColor");
		String iconColor = (String) page.locator(fairApdexStatusIndicator).evaluate("element => window.getComputedStyle(element).getPropertyValue('background-color')");
		Assert.assertTrue(iconColor.contains(expectedColor));
		String labelColor = (String) page.locator(fairApdexStatusLabel).evaluate("element => window.getComputedStyle(element).getPropertyValue('color')");
		Assert.assertTrue(labelColor.contains(expectedColor));
		String valueColor = (String) page.locator(fairApdexStatusValue).evaluate("element => window.getComputedStyle(element).getPropertyValue('color')");
		Assert.assertTrue(valueColor.contains(expectedColor));
	}
	
	public void validateTheColorOfThePoorHealthIndicatorElementsInApdexScoreWidget() throws EncryptedDocumentException, IOException {
		String expectedColor = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath,IPathConstant.bmApplicationSheet, "poorApdexColor");
		String iconColor = (String) page.locator(poorApdexStatusIndicator).evaluate("element => window.getComputedStyle(element).getPropertyValue('background-color')");
		Assert.assertTrue(iconColor.contains(expectedColor));
		String labelColor = (String) page.locator(poorApdexStatusLabel).evaluate("element => window.getComputedStyle(element).getPropertyValue('color')");
		Assert.assertTrue(labelColor.contains(expectedColor));
		String valueColor = (String) page.locator(poorApdexStatusValue).evaluate("element => window.getComputedStyle(element).getPropertyValue('color')");
		Assert.assertTrue(valueColor.contains(expectedColor));
	}
	
	public void validateTheColorOfTheApdexScoreIndicatorInApdexScoreWidget() throws EncryptedDocumentException, IOException {
		page.waitForSelector(apdexImageInWidget);
		double apdexScore = Double.parseDouble(page.textContent(apdexScoreInWidget).trim());
		System.out.println(apdexScore);
		String actualColor = (String) page.locator(apdexImageInWidget).evaluate("element => window.getComputedStyle(element).getPropertyValue('stroke')");
		if(apdexScore >= 0.00 && apdexScore <= 0.68){
			String expectedColor = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath,IPathConstant.bmApplicationSheet, "poorApdexColor");
			System.out.print("Poor -> expectedColor: "+expectedColor+"  "+"actualColor: "+actualColor);
			Assert.assertTrue(actualColor.contains(expectedColor));
		}
		else if(apdexScore >= 0.69 && apdexScore <= 0.83){
			String expectedColor = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath,IPathConstant.bmApplicationSheet, "fairApdexColor");
			System.out.print("Fair -> expectedColor: "+expectedColor+"  "+"actualColor: "+actualColor);
			Assert.assertTrue(actualColor.contains(expectedColor));
		}
		else if(apdexScore >= 0.84 && apdexScore <= 1.00){
			String expectedColor = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath,IPathConstant.bmApplicationSheet, "goodApdexColor");
			System.out.print("Good -> expectedColor: "+expectedColor+"  "+"actualColor: "+actualColor);
			Assert.assertTrue(actualColor.contains(expectedColor));
		}
	}
	
	public void validateTheTitleOfLoadWidget() throws EncryptedDocumentException, IOException {
		String title = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath,IPathConstant.bmApplicationSheet, "loadWidgetTitle");
		util.ValidateTheTitle(page, loadWidgetTitle, title);
	}
	
	public void validateTheXaxisTitleOfLoadWidget() throws EncryptedDocumentException, IOException {
		String title = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath,IPathConstant.bmApplicationSheet, "xaxisTitle");
		util.ValidateTheTitle(page, loadWidgetXaxisTitle, title);
	}
	
	public void validateTheYaxisTitleOfLoadWidget() throws EncryptedDocumentException, IOException {
		String title = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath,IPathConstant.bmApplicationSheet, "loadWidgetYaxisTitle");
		util.ValidateTheTitle(page, loadWidgetYaxisTitle, title);
	}
	
	public void validateTheFunctionalityOfLoadWidgetZoomInButton () {
		util.graphZoomIn(page, loadWidgetZoomInBtn, loadWidgetZoomResetBtn, xPoints);
	}
	
	public void validateTheFunctionalityOfLoadWidgetZoomOutButton () {
		util.graphZoomOut(page, loadWidgetZoomInBtn, loadWidgetZoomOutBtn, loadWidgetZoomResetBtn, xPoints);
	}
	
	public void validateTheFunctionalityOfLoadWidgetZoomResetButton () {
		util.graphZoomReset(page, loadWidgetZoomInBtn, loadWidgetZoomResetBtn, xPoints);
	}
	
	public void validateZoomInByDragAndDropForLoadWidget() {
		util.graphZoomInByDragAndDrop(page, loadWidgetXaxisPoints, loadWidgetZoomResetBtn, xPoints);
	}
	
	public void validateWhetherTheTooltipIsDisplayingForLoadWidget() {
		util.validateWidgetToolTips(page, loadWidgetXaxisPoints, loadWidgetTooltipTitle);
	}
	
	public void validateTheTitleOfLoadTimeWidget() throws EncryptedDocumentException, IOException {
		String title = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath,IPathConstant.bmApplicationSheet, "loadTimeWidgetTitle");
		util.ValidateTheTitle(page, loadTimeWidgetTitle, title);
	}
	
	public void validateTheXaxisTitleOfLoadTimeWidget() throws EncryptedDocumentException, IOException {
		String title = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath,IPathConstant.bmApplicationSheet, "xaxisTitle");
		util.ValidateTheTitle(page, loadTimeWidgetXaxisTitle, title);
	}
	
	public void validateTheYaxisTitleOfLoadTimeWidget() throws EncryptedDocumentException, IOException {
		String title = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath,IPathConstant.bmApplicationSheet, "loadTimeWidgetYaxisTitle");
		util.ValidateTheTitle(page, loadTimeWidgetYaxisTitle, title);
	}
	
	public void validateTheFunctionalityOfLoadTimeWidgetZoomInButton () {
		util.graphZoomIn(page, loadTimeWidgetZoomInBtn, loadTimeWidgetZoomResetBtn, xPoints);
	}
	
	public void validateTheFunctionalityOfLoadTimeWidgetZoomOutButton () {
		util.graphZoomOut(page, loadTimeWidgetZoomInBtn, loadTimeWidgetZoomOutBtn, loadTimeWidgetZoomResetBtn, xPoints);
	}
	
	public void validateTheFunctionalityOfLoadTimeWidgetZoomResetButton () {
		util.graphZoomReset(page, loadTimeWidgetZoomInBtn, loadTimeWidgetZoomResetBtn, xPoints);
	}
	
	public void validateZoomInByDragAndDropForLoadTimeWidget() {
		util.graphZoomInByDragAndDrop(page, loadTimeWidgetXaxisPoints, loadTimeWidgetZoomResetBtn, xPoints);
	}
	
	public void validateWhetherTheTooltipIsDisplayingForLoadTimeWidget() {
		util.validateWidgetToolTips(page, loadTimeWidgetXaxisPoints, loadTimeWidgetTooltipTitle);
	}
	
	public void validateTheTitleOfErrorWidget() throws EncryptedDocumentException, IOException {
		String title = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath,IPathConstant.bmApplicationSheet, "errorWidgetTitle");
		util.ValidateTheTitle(page, errorWidgetTitle, title);
	}
	
	public void validateTheXaxisTitleOfErrorWidget() throws EncryptedDocumentException, IOException {
		String title = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath,IPathConstant.bmApplicationSheet, "xaxisTitle");
		util.ValidateTheTitle(page, errorWidgetXaxisTitle, title);
	}
	
	public void validateTheYaxisTitleOfErrorWidget() throws EncryptedDocumentException, IOException {
		String title = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath,IPathConstant.bmApplicationSheet, "errorWidgetYaxisTitle");
		util.ValidateTheTitle(page, errorWidgetYaxisTitle, title);
	}
	
	public void validateTheFunctionalityOfErrorWidgetZoomInButton () {
		util.graphZoomIn(page, errorWidgetZoomInBtn, errorWidgetZoomResetBtn, xPoints);
	}
	
	public void validateTheFunctionalityOfErrorWidgetZoomOutButton () {
		util.graphZoomOut(page, errorWidgetZoomInBtn, errorWidgetZoomOutBtn, errorWidgetZoomResetBtn, xPoints);
	}
	
	public void validateTheFunctionalityOfErrorWidgetZoomResetButton () {
		util.graphZoomReset(page, errorWidgetZoomInBtn, errorWidgetZoomResetBtn, xPoints);
	}
	
	public void validateZoomInByDragAndDropForErrorWidget() {
		util.graphZoomInByDragAndDrop(page, errorWidgetXaxisPoints, errorWidgetZoomResetBtn, xPoints);
	}
	
	public void validateWhetherTheTooltipIsDisplayingForErrorWidget() {
		util.validateWidgetToolTips(page, errorWidgetXaxisPoints, errorWidgetTooltipTitle);
	}
	
	public void validateTheTitleOfUserImpactedByErrorsWidget() throws EncryptedDocumentException, IOException {
		String title = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath,IPathConstant.bmApplicationSheet, "userImpactedWidgetTitle");
		util.ValidateTheTitle(page, userImpactedByErrorsWidgetTitle, title);
	}
	
	public void validateTheXaxisTitleOfUserImpactedByErrorsWidget() throws EncryptedDocumentException, IOException {
		String title = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath,IPathConstant.bmApplicationSheet, "xaxisTitle");
		util.ValidateTheTitle(page, userImpactedByErrorsWidgetXaxisTitle, title);
	}
	
	public void validateTheYaxisTitleOfUserImpactedByErrorsWidget() throws EncryptedDocumentException, IOException {
		String title = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath,IPathConstant.bmApplicationSheet, "userImpactedWidgetYaxisTitle");
		util.ValidateTheTitle(page, userImpactedByErrorsWidgetYaxisTitle, title);
	}
	
	public void validateWhetherTheTooltipIsDisplayingForUserImpactedByErrorsWidget() {
		util.validateWidgetToolTips(page, userImpactedByErrorsWidgetXaxisPoints, userImpactedByErrorsWidgetTooltipTitle);
	}
	
	public void validateTheTitleOfErrorCountMapWidget() throws EncryptedDocumentException, IOException {
		String title = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath,IPathConstant.bmApplicationSheet, "errorCountMapWidgetTitle");
		util.ValidateTheTitle(page, errorCountmapWidgetTitle, title);
	}
	
	public void ValidateTheXaxisLablesAccordingToTheSelectedTimeline() {
		page.waitForTimeout(1000);
		util.validateTheGraphdisplayingTheDataAsPerGivenTimeLines(page, loadWidgetXaxisLabels, selectedTimeline, xaxisLabels);
	}
	
	public void validateTheCustomTimeLine(String period)
	{
		page.waitForSelector(loadWidgetXaxisLabels);
		page.waitForTimeout(1000);
		util.validateCustomTimeLine(page,loadWidgetXaxisLabels,period,xaxisLabels);
	}
	
	public void validateTheLoadInApplicationPageLoadGraphHeader(int expectedLoad) {
		page.click("#btn-refresh");
		page.waitForLoadState();
		page.click(applicationTab);
		page.waitForSelector(callsOnLoadWidgetHeader);
		page.waitForTimeout(2000);
		int actualLoad = Integer.parseInt(page.textContent(callsOnLoadWidgetHeader).trim().replace(" calls", ""));
		System.out.println("expectedLoad : "+expectedLoad+"\t actualLoad :"+actualLoad);
		Assert.assertTrue(actualLoad == expectedLoad);
	}
	
	public void validateTheLoadInApplicationPageLoadGraph(int expectedLoad) {
		page.waitForTimeout(1000);
		int actualLoad = util.getTheSummationFromTheWidgetTooltip(page, loadWidgetXaxisPoints, loadWidgetTooltipValue);
		System.out.println("expectedLoad : "+expectedLoad+"\t actualLoad :"+actualLoad);
		Assert.assertTrue(actualLoad == expectedLoad);
	}
	
	public void validateTheCallsPerMinuteInLoadGraph() {
		page.waitForTimeout(1000);
		int load = Integer.parseInt(page.textContent(callsOnLoadWidgetHeader).trim().replace(" calls", ""));
		int mins = Integer.parseInt(page.textContent(selectedTimeline).trim().replace(" mins",""));
		int expectedCpm = load/mins;
		int actualCpm = Integer.parseInt(page.textContent(cpmOnLoadWidgetHeader).trim().replace(" calls/min", ""));
		System.out.println("expectedCpm : "+expectedCpm+"\t actualCpm :"+actualCpm);
		Assert.assertTrue(actualCpm == expectedCpm);
	}
	
	public void validateTheLoadTimeInLoadGraph() {
		page.waitForTimeout(1000);
		int calls = 0;
		int respTime = 0;
		page.waitForTimeout(1000);
		page.waitForTimeout(1000);
	    int num=page.locator(loadWidgetXaxisPoints).count();
	    HoverOptions hoverOptions=new HoverOptions();
	    hoverOptions.setForce(true);
	       for(int i=0;i<num;i++) {
	    	   if(i==num-1)
	    	   {
	    	       hoverOptions.setPosition(1,-10);
	    	   }else
	    	   {
	    	    hoverOptions.setPosition(2,-10);
	    	   }
    		   page.locator(loadWidgetXaxisPoints).nth(i).hover(hoverOptions); 
    		   page.waitForTimeout(200);
    		   calls = calls + Integer.parseInt(page.locator(loadWidgetTooltipValue).textContent().trim());
    		   respTime = respTime + (Integer.parseInt(page.locator(loadWidgetTooltipValue).textContent().trim()) * Integer.parseInt(page.locator(loadTimeWidgetTooltipValue).textContent().trim()));
	    	 }
	       int expectedRespTime = respTime/calls;
	       int actualRespTime = Integer.parseInt(page.textContent(averageRespTimeOnLoadTimeWidgetHeader).trim().replace(" ms average", ""));
	       System.out.println("expectedRespTime : "+expectedRespTime+"\t actualrespTime : "+actualRespTime);
	       Assert.assertTrue(actualRespTime == expectedRespTime);
	}
	
	public int getavgRespTime() {
		page.click(applicationTab);
		page.waitForTimeout(1000);
		return Integer.parseInt(page.textContent(averageRespTimeOnLoadTimeWidgetHeader).trim().replace(" ms average", ""));
	}
	
	public void validateTheErrorInApplicationPageErrorGraphHeader(int expectedError) {
		page.waitForTimeout(500);
		page.click("#btn-refresh");
		page.waitForLoadState();
		page.waitForTimeout(2000);
		page.click(applicationTab);
		page.waitForSelector(errorsOnErrorWidgetHeader);
		int actualError = Integer.parseInt(page.textContent(errorsOnErrorWidgetHeader).trim().replace(" errors", ""));
		System.out.println("expectedError : "+expectedError+"\t actualError :"+actualError);
		Assert.assertTrue(actualError == expectedError);
	}
	
	public void validateTheErrorInApplicationPageErrorGraph(int expectedError) {
		page.waitForSelector(errorsOnErrorWidgetHeader);
		page.waitForTimeout(1000);
		int actualError = util.getTheSummationFromTheWidgetTooltip(page, errorWidgetXaxisPoints, errorWidgetTooltipValue);
		System.out.println("expectedError : "+expectedError+"\t actualError :"+actualError);
		Assert.assertTrue(actualError == expectedError);
	}
	
	public void validateTheErrorInApplicationPageErrorCountMap(int expectedError) {
		HoverOptions hoverOpt = new HoverOptions();
		hoverOpt.setForce(true);
		page.waitForTimeout(1000);
		int actualError = 0;
		Locator countries = page.locator(countriesOnErrorMap);
		for(int i=0; i<countries.count(); i++) {
			countries.nth(i).hover(hoverOpt);
			try{
				page.waitForSelector(errorMapToolTipValue);
				page.waitForTimeout(100);
				if(Integer.parseInt(page.textContent(errorMapToolTipValue).trim()) > 0)
				{
					System.out.println(page.textContent(errorMapToolTipTitle).trim()+"\t"+page.textContent(errorMapToolTipValue).trim());
					actualError = actualError + Integer.parseInt(page.textContent(errorMapToolTipValue).trim());
				}
			}catch(Exception e) {
				i++;
			}
		}
		System.out.println("expectedError : "+expectedError+"\t actualErrors : "+actualError);
		Assert.assertTrue(actualError == expectedError);
	}
	
	public void validateTheErrorsPerMinuteInErrorGraph() {
		page.waitForTimeout(1000);
		int error = Integer.parseInt(page.textContent(errorsOnErrorWidgetHeader).trim().replace(" errors", ""));
		int mins = Integer.parseInt(page.textContent(selectedTimeline).trim().replace(" mins",""));
		int expectedEpm = error/mins;
		int actualEpm = Integer.parseInt(page.textContent(epmOnErrorWidgetHeader).trim().replace(" errors/min", ""));
		System.out.println("expectedEpm : "+expectedEpm+"\t actualEpm :"+actualEpm);
		Assert.assertTrue(actualEpm == expectedEpm);
	}
	
	public void validateTheUsersImpactedByErrors() throws EncryptedDocumentException, IOException {
		String[] errors = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmDataValidationSheet, "angularError_counts").split(",");
		int expectedUsers = 0;
		for (String err : errors) {
			expectedUsers = expectedUsers + Integer.parseInt(err);
		}
	      int actualUsers = util.getTheSummationFromTheWidgetTooltip(page, userImpactedByErrorsWidgetXaxisPoints, userImpactedByErrorsWidgetTooltipValue);
	        System.out.println("actualUsers : " + actualUsers + "\t expectedUsers :"+ expectedUsers);
	        Assert.assertTrue(actualUsers == expectedUsers);
	}
	
	public void validateApdexScore(String thresholdTime) {
		HoverOptions hoverOptions = new HoverOptions();
		hoverOptions.setForce(true);
		int respTime = Integer.parseInt(thresholdTime);
		int toolTipData=0;
		int satisfiedLoad = 0;
		int tolaratedLoad = 0;
		//int frustratedLoad = 0;
		Locator xpoints = page.locator(loadWidgetXaxisPoints);
		for(int i=0; i<xpoints.count(); i++)
		{
			if(i==xpoints.count()-1)
	    	   {
	    	       hoverOptions.setPosition(1,-10);
	    	   }else
	    	   {
	    	    hoverOptions.setPosition(2,-10);
	    	   }
 		   page.locator(loadWidgetXaxisPoints).nth(i).hover(hoverOptions); 
 		   page.waitForTimeout(200);
 		   if(page.textContent(loadWidgetTooltipValue).equalsIgnoreCase("1.0") || page.textContent(loadWidgetTooltipValue).equalsIgnoreCase("1")) {	
				String tooltip= page.textContent(loadTimeWidgetTooltipValue).trim();
				System.out.println(tooltip);
            	if (tooltip != "")
				toolTipData = Integer.parseInt(tooltip);

				if(toolTipData <= respTime)
					satisfiedLoad++;
				else if(toolTipData > respTime && toolTipData <= (respTime*4))
					tolaratedLoad++;
			}
		}
		double tolLoad = tolaratedLoad/2;
		double expectedApdexVal = (satisfiedLoad + tolLoad)/2;
		double actualApdexVal = Double.parseDouble(page.textContent(apdexScoreInWidget).trim());
		System.out.println("expectedApdexVal    "+expectedApdexVal);
		System.out.println("actualApdexVal    "+actualApdexVal);
		Assert.assertTrue(actualApdexVal == expectedApdexVal);
	}
}
