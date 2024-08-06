package objectRepository.BM;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Locator.HoverOptions;
import com.microsoft.playwright.options.LoadState;

import genericUtilities.ExcelUtility;
import genericUtilities.GenericMethods;
import genericUtilities.IPathConstant;
import objectRepository.CommonPage;

public class BmPagesPage {

	Page page;
	GenericMethods util = new GenericMethods();
	ExcelUtility excel = new ExcelUtility();
	CommonPage common = new CommonPage(page);
	BmErrorsPage bmError;
	BmApplicationPage bmApp;
	
	private String pagesTab = "#nav-tab-pages";
	private String searchPageTextField = "xpath = //input[@class='search-box']";
	private String searchBtn = "#btn-search";
	private String softRefreshBtn = "xpath = //div[@id='btn-refresh']/span";
	private String clearSearchBtn = "#btn-clear-search";
	private String noDataIcon = "xpath = //div[@class='no-data-icon']//div[@class='inner-text']";

	private String firstColumn = "xpath = (//div[@class='test'])[1]";
	private String secondColumn = "xpath = (//div[@class='test'])[2]";
	private String thirdColumn = "xpath = (//div[@class='test'])[3]";
	private String fourthColumn = "xpath = (//div[@class='test'])[4]";
	private String fifthColumn = "xpath = (//div[@class='test'])[5]";
	private String sixthColumn = "xpath = (//div[@class='test'])[6]";
	private String firstNameInTable = "#redirect-0-0";
	private String firstErrorsInTable = "#redirect-0-1";
	private String firstCallsInTable = "#redirect-0-4";
	private String firstCpmInTable = "#redirect-0-5";
	private String errorsAscBtn = "#sort-errors-asc";
	private String errorsDescBtn = "#sort-errors-des";
	private String epmAscBtn = "#sort-epm-asc";
	private String epmDescBtn = "#sort-epm-des";
	private String responseTimeAscBtn = "#sort-respTime-asc";
	private String responseTimeDescBtn = "#sort-respTime-des";
	private String callsAscBtn = "#sort-calls-asc";
	private String callsDescBtn = "#sort-calls-des";
	private String cpmAscBtn = "#sort-cpm-asc";
	private String cpmDescBtn = "#sort-cpm-des";
	private String nameColumnData = "xpath = //div[@class='main-row']/div[1]";
	private String errorsColumnData = "xpath = //div[@class='main-row']/div[2]";
	private String epmColumnData = "xpath = //div[@class='main-row']/div[3]";
	private String responseTimeColumnData = "xpath = //div[@class='main-row']/div[4]";
	private String callsColumnData = "xpath = //div[@class='main-row']/div[5]";
	private String cpmColumnData = "xpath = //div[@class='main-row']/div[6]";
	 
	private String backBtnOnPagesGraphPage = "xpath = //button[@class='icon-class']";
	private String pageNameOnPagesGraphPage = "xpath = //span[@class='icon-label']";
	private String loadWidgetTitle = "xpath = //div[@id='apexchartsvuechart-line-0']/ancestor::div[@class='chart-body']/preceding-sibling::div/div[@class='line-title']";
	private String loadWidgetXaxisTitle = "xpath = //div[@id='apexchartsvuechart-line-0']//*[name()='g' and @class='apexcharts-xaxis-title']";
	private String loadWidgetYaxisTitle = "xpath = //div[@id='apexchartsvuechart-line-0']//*[name()='g' and @class='apexcharts-yaxis-title']";
	private String loadWidgetZoomInBtn = "#Load-zoom-in";
	private String loadWidgetZoomOutBtn = "#Load-zoom-out";
	private String loadWidgetZoomResetBtn = "#Load-zoom-reset";
	private String loadWidgetXaxisPoints = "xpath = //div[@id='apexchartsvuechart-line-0']//*[name()='line' and @class='apexcharts-xaxis-tick']";
	private String loadWidgetTooltipTitle = "xpath = //div[@id='apexchartsvuechart-line-0']//div[@class='apexcharts-tooltip-title']";
	private String loadWidgetTooltipValue = "xpath = //div[@id='apexchartsvuechart-line-0']/descendant::span[@class='apexcharts-tooltip-text-y-value']";
	private String loadWidgetXaxisLabels = "xpath = //div[@id='apexchartsvuechart-line-0']//*[name()='g' and @class='apexcharts-xaxis-texts-g']//*[name()='tspan' and contains(text(),'-')]";
	private String callsOnLoadWidgetHeader = "xpath = //span[@class='line-content-calls']";
	private String cpmOnLoadWidgetHeader = "xpath = //span[@class='line-content-calls']/following-sibling::span";
		
	private String userCentricPageWidgetTitle = "xpath = //div[@id='apexchartsvuechart-area-0']/ancestor::div[@class='chart-body']/preceding-sibling::div/div[@class='line-title']";
	private String userCentricPageWidgetXaxisTitle = "xpath = //div[@id='apexchartsvuechart-area-0']//*[name()='g' and @class='apexcharts-xaxis-title']";
	private String userCentricPageWidgetYaxisTitle = "xpath = //div[@id='apexchartsvuechart-area-0']//*[name()='g' and @class='apexcharts-yaxis-title']";
	private String userCentricPageWidgetZoomInBtn = "#User-centric-page-load-and-event-execution-time-zoom-in";
	private String userCentricPageWidgetZoomOutBtn = "#User-centric-page-load-and-event-execution-time-zoom-out";
	private String userCentricPageWidgetZoomResetBtn = "#User-centric-page-load-and-event-execution-time-zoom-reset";
	private String userCentricPageWidgetXaxisPoints = "xpath = //div[@id='apexchartsvuechart-area-0']//*[name()='line' and @class='apexcharts-xaxis-tick']";
	private String userCentricPageWidgetTooltipTitle = "xpath = //div[@id='apexchartsvuechart-area-0']//div[@class='apexcharts-tooltip-title']";
	private String userCentricPageWidgetTooltipLabel = "xpath = //div[@id='apexchartsvuechart-area-0']/descendant::span[@class='apexcharts-tooltip-text-y-label']";
	private String userCentricPageWidgetTooltipValue = "xpath = //div[@id='apexchartsvuechart-area-0']/descendant::span[@class='apexcharts-tooltip-text-y-value']";
	private String userCentricPageWidgetXaxisLabels = "xpath = //div[@id='apexchartsvuechart-area-0']//*[name()='g' and @class='apexcharts-xaxis-texts-g']//*[name()='tspan' and contains(text(),'-')]";
	private String userCentricPageWidgetLegendsList = "xpath = //div[@id='apexchartsvuechart-area-0']/descendant::span[contains(@class,'apexcharts-legend-text')]";
	private String userCentricPageWidgetLegendsColorList = "xpath = //div[@id='apexchartsvuechart-area-0']/descendant::span[contains(@class,'apexcharts-legend-marker')]";
	private String userCentricPageWidgetLegendsLinesList = "xpath = //div[@id='apexchartsvuechart-area-0']/descendant::*[name()='g' and @class='apexcharts-series']/child::*[name()='path' and @fill='none']";
	private String userCentricPageWidgetTooltipColorList = "xpath = //div[@id='apexchartsvuechart-area-0']/descendant::div[@class='apexcharts-tooltip apexcharts-theme-dark apexcharts-active']/descendant::span[@class='apexcharts-tooltip-marker']";
	
	private String errorWidgetTitle = "xpath = //div[@id='apexchartsvuechart-area-1']/ancestor::div[@class='chart-body']/preceding-sibling::div/div[@class='line-title']";
	private String errorWidgetXaxisTitle = "xpath = //div[@id='apexchartsvuechart-area-1']//*[name()='g' and @class='apexcharts-xaxis-title']";
	private String errorWidgetYaxisTitle = "xpath = //div[@id='apexchartsvuechart-area-1']//*[name()='g' and @class='apexcharts-yaxis-title']";
	private String errorWidgetZoomInBtn = "#Error-zoom-in";
	private String errorWidgetZoomOutBtn = "#Error-zoom-out";
	private String errorWidgetZoomResetBtn = "#Error-zoom-reset";
	private String errorWidgetXaxisPoints = "xpath = //div[@id='apexchartsvuechart-area-1']//*[name()='line' and @class='apexcharts-xaxis-tick']";
	private String errorWidgetTooltipTitle = "xpath = //div[@id='apexchartsvuechart-area-1']//div[@class='apexcharts-tooltip-title']";
	private String errorWidgetTooltipLabel = "xpath = //div[@id='apexchartsvuechart-area-1']/descendant::span[@class='apexcharts-tooltip-text-y-label']";
	private String errorWidgetTooltipValue = "xpath = //div[@id='apexchartsvuechart-area-1']/descendant::span[@class='apexcharts-tooltip-text-y-value']";
	private String errorWidgetXaxisLabels = "xpath = //div[@id='apexchartsvuechart-area-1']//*[name()='g' and @class='apexcharts-xaxis-texts-g']//*[name()='tspan' and contains(text(),'-')]";
	private String errorWidgetLegendsList = "xpath = //div[@id='apexchartsvuechart-area-1']/descendant::span[contains(@class,'apexcharts-legend-text')]";
	private String errorWidgetLegendsColorList = "xpath = //div[@id='apexchartsvuechart-area-1']/descendant::span[contains(@class,'apexcharts-legend-marker')]";
	private String errorWidgetLegendsLinesList = "xpath = //div[@id='apexchartsvuechart-area-1']/descendant::*[name()='g' and @class='apexcharts-series']/child::*[name()='path' and @fill='none']";
	private String errorWidgetTooltipColorList = "xpath = //div[@id='apexchartsvuechart-area-1']/descendant::div[@class='apexcharts-tooltip apexcharts-theme-dark apexcharts-active']/descendant::span[@class='apexcharts-tooltip-marker']";
	private String viewErrorsOnErrorWidgetHeader = "xpath = //div[@class='custom-button']";
	
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
		xPoints.add(userCentricPageWidgetXaxisPoints);
		xPoints.add(errorWidgetXaxisPoints);
	}
	
	List<String> xaxisLabels = new ArrayList<String>();
	{
		xaxisLabels.add(loadWidgetXaxisLabels);
		xaxisLabels.add(userCentricPageWidgetXaxisLabels);
		xaxisLabels.add(errorWidgetXaxisLabels);
		xaxisLabels.add(userImpactedByErrorsWidgetXaxisLabels);
	}
	
	public BmPagesPage(Page page) {
		this.page = page;
	}
	
	public void navigateToPagesTab() {
		page.waitForTimeout(300);
		page.click(pagesTab);
		page.waitForTimeout(200);
		page.waitForURL("**/pages/pages-table");
		Assert.assertTrue(page.isVisible(searchPageTextField));
	}
	
	public void validateWhetherTheSearchPagesTextFieldIsPresent() throws EncryptedDocumentException, IOException {
		String expectedText = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmPagesSheet, "searchPageTextFieldPlaceHolder");
		String actualText = page.getAttribute(searchPageTextField, "placeholder");
		util.ValidateTheTitle(actualText, expectedText);
	}
	
	public void validateTheFunctionalityOfSearchPagesForValidData() {
		util.validateSearchFunctionalityWithValidData(page,  nameColumnData, searchPageTextField, searchBtn, nameColumnData);
	}
	
	public void validateTheFunctionalityOfSearchPagesForInvalidData() {
		util.validateSearchFunctionalityWithInvalidData(page, searchPageTextField, searchBtn, noDataIcon);
	}
	
	public void validateTheFirstColumnTitlteInThePagesTable() throws EncryptedDocumentException, IOException {
		String title = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmPagesSheet, "pagesTableFirstColumnName");
		util.ValidateTheTitle(page, firstColumn, title);
	}
	
	public void validateTheSecondColumnTitlteInThePagesTable() throws EncryptedDocumentException, IOException {
		String title = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmPagesSheet, "pagesTableSecondColumnName");
		util.ValidateTheTitle(page, secondColumn, title);
	}
	
	public void validateTheThirdColumnTitlteInThePagesTable() throws EncryptedDocumentException, IOException {
		String title = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmPagesSheet, "pagesTableThirdColumnName");
		util.ValidateTheTitle(page, thirdColumn, title);
	}
	
	public void validateTheFourthColumnTitlteInThePagesTable() throws EncryptedDocumentException, IOException {
		String title = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmPagesSheet, "pagesTableFourthColumnName");
		util.ValidateTheTitle(page, fourthColumn, title);
	}
	
	public void validateTheFifthColumnTitlteInThePagesTable() throws EncryptedDocumentException, IOException {
		String title = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmPagesSheet, "pagesTableFifthColumnName");
		util.ValidateTheTitle(page, fifthColumn, title);
	}
	
	public void validateTheSixthColumnTitlteInThePagesTable() throws EncryptedDocumentException, IOException {
		String title = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmPagesSheet, "pagesTableSixthColumnName");
		util.ValidateTheTitle(page, sixthColumn, title);
	}
	
	public void validateTheAscendingFunctionalityOfErrorsColumn() {
		util.sortTheColumnInAscendingOrderAndValidateTheColumnData(page, errorsAscBtn, errorsColumnData);
	}
	
	public void validateTheDescendingFunctionalityOfErrorsColumn() {
		util.sortTheColumnInDescendingOrderAndValidateTheColumnData(page, errorsDescBtn, errorsColumnData);
	}
	
	public void validateTheAscendingFunctionalityOfErrorsPerMinuteColumn() {
		page.hover(thirdColumn);
		util.sortTheColumnInAscendingOrderAndValidateTheColumnData(page, epmAscBtn, epmColumnData);
	}
	
	public void validateTheDescendingFunctionalityOfErrorsPerMinuteColumn() {
		page.hover(thirdColumn);
		util.sortTheColumnInDescendingOrderAndValidateTheColumnData(page, epmDescBtn, epmColumnData);
	}
	
	public void validateTheAscendingFunctionalityOfResponseTimeColumn() {
		page.hover(fourthColumn);
		util.sortTheColumnInAscendingOrderAndValidateTheColumnData(page, responseTimeAscBtn, responseTimeColumnData);
	}
	
	public void validateTheDescendingFunctionalityOfResponseTimeColumn() {
		page.hover(fourthColumn);
		util.sortTheColumnInDescendingOrderAndValidateTheColumnData(page, responseTimeDescBtn, responseTimeColumnData);
	}
	
	public void validateTheAscendingFunctionalityOfCallsColumn() {
		page.hover(fifthColumn);
		util.sortTheColumnInAscendingOrderAndValidateTheColumnData(page, callsAscBtn, callsColumnData);
	}
	
	public void validateTheDescendingFunctionalityOfCallsColumn() {
		page.hover(fifthColumn);
		util.sortTheColumnInDescendingOrderAndValidateTheColumnData(page, callsDescBtn, callsColumnData);
	}
	
	public void validateTheAscendingFunctionalityOfCallsPerMinuteColumn() {
		page.hover(sixthColumn);
		util.sortTheColumnInAscendingOrderAndValidateTheColumnData(page, cpmAscBtn, cpmColumnData);
	}
	
	public void validateTheDescendingFunctionalityOfCallsPerMinuteColumn() {
		page.hover(sixthColumn);
		util.sortTheColumnInDescendingOrderAndValidateTheColumnData(page, cpmDescBtn, cpmColumnData);
	}
	
	public void validateTheNavigationToPagesGraphPage() {
		String expectedPageName = page.locator(nameColumnData).nth(0).textContent().trim();
		page.locator(nameColumnData).nth(0).click();
		page.waitForSelector(pageNameOnPagesGraphPage);
		String pageNameOnGraphPage = page.textContent(pageNameOnPagesGraphPage).trim();
		System.out.println("expectedPageName : "+expectedPageName+"\t actualPageName : "+pageNameOnGraphPage);
		Assert.assertTrue(pageNameOnGraphPage.equals(expectedPageName));
	}
	
	public void validateTheFunctionalityOfBackButtonOnPagesGraphPage() {
		validateTheNavigationToPagesGraphPage();
		page.click(backBtnOnPagesGraphPage);
		page.waitForURL("**/pages/pages-table");
		Assert.assertTrue(page.isVisible(searchPageTextField));
	}
	
	public void validatePagination(int num) {
		common.selectPaginationAndValidate(page, num, nameColumnData);
	}
	
	public void validateTheTitleOfLoadWidget() throws EncryptedDocumentException, IOException {
		validateTheNavigationToPagesGraphPage();
		String title = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath,IPathConstant.bmPagesSheet, "loadWidgetTitle");
		util.ValidateTheTitle(page, loadWidgetTitle, title);
	}
	
	public void validateTheXaxisTitleOfLoadWidget() throws EncryptedDocumentException, IOException {
		validateTheNavigationToPagesGraphPage();
		String title = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath,IPathConstant.bmPagesSheet, "xaxisTitle");
		util.ValidateTheTitle(page, loadWidgetXaxisTitle, title);
	}
	
	public void validateTheYaxisTitleOfLoadWidget() throws EncryptedDocumentException, IOException {
		validateTheNavigationToPagesGraphPage();
		String title = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath,IPathConstant.bmPagesSheet, "loadWidgetYaxisTitle");
		util.ValidateTheTitle(page, loadWidgetYaxisTitle, title);
	}
	
	public void validateTheFunctionalityOfLoadWidgetZoomInButton () {
		validateTheNavigationToPagesGraphPage();
		util.graphZoomIn(page, loadWidgetZoomInBtn, loadWidgetZoomResetBtn, xPoints);
	}
	
	public void validateTheFunctionalityOfLoadWidgetZoomOutButton () {
		validateTheNavigationToPagesGraphPage();
		util.graphZoomOut(page, loadWidgetZoomInBtn, loadWidgetZoomOutBtn, loadWidgetZoomResetBtn, xPoints);
	}
	
	public void validateTheFunctionalityOfLoadWidgetZoomResetButton () {
		validateTheNavigationToPagesGraphPage();
		util.graphZoomReset(page, loadWidgetZoomInBtn, loadWidgetZoomResetBtn, xPoints);
	}
	
	public void validateZoomInByDragAndDropForLoadWidget() {
		validateTheNavigationToPagesGraphPage();
		util.graphZoomInByDragAndDrop(page, loadWidgetXaxisPoints, loadWidgetZoomResetBtn, xPoints);
	}
	
	public void validateWhetherTheTooltipIsDisplayingForLoadWidget() {
		validateTheNavigationToPagesGraphPage();
		util.validateWidgetToolTips(page, loadWidgetXaxisPoints, loadWidgetTooltipTitle);
	}
	
	public void validateTheTitleOfUserCentricPageLoadWidget() throws EncryptedDocumentException, IOException {
		validateTheNavigationToPagesGraphPage();
		String title = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath,IPathConstant.bmPagesSheet, "userCentricPageWidgetTitle");
		util.ValidateTheTitle(page, userCentricPageWidgetTitle, title);
	}
	
	public void validateTheXaxisTitleOfUserCentricPageLoadWidget() throws EncryptedDocumentException, IOException {
		validateTheNavigationToPagesGraphPage();
		String title = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath,IPathConstant.bmPagesSheet, "xaxisTitle");
		util.ValidateTheTitle(page, userCentricPageWidgetXaxisTitle, title);
	}
	
	public void validateTheYaxisTitleOfUserCentricPageLoadWidget() throws EncryptedDocumentException, IOException {
		validateTheNavigationToPagesGraphPage();
		String title = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath,IPathConstant.bmPagesSheet, "userCentricPageWidgetYaxisTitle");
		util.ValidateTheTitle(page, userCentricPageWidgetYaxisTitle, title);
	}
	
	public void validateTheFunctionalityOfUserCentricPageLoadWidgetZoomInButton () {
		validateTheNavigationToPagesGraphPage();
		util.graphZoomIn(page, userCentricPageWidgetZoomInBtn, userCentricPageWidgetZoomResetBtn, xPoints);
	}
	
	public void validateTheFunctionalityOfUserCentricPageLoadWidgetZoomOutButton () {
		validateTheNavigationToPagesGraphPage();
		util.graphZoomOut(page, userCentricPageWidgetZoomInBtn, userCentricPageWidgetZoomOutBtn, userCentricPageWidgetZoomResetBtn, xPoints);
	}
	
	public void validateTheFunctionalityOfUserCentricPageLoadWidgetZoomResetButton () {
		validateTheNavigationToPagesGraphPage();
		util.graphZoomReset(page, userCentricPageWidgetZoomInBtn, userCentricPageWidgetZoomResetBtn, xPoints);
	}
	
	public void validateZoomInByDragAndDropForUserCentricPageLoadWidget() {
		validateTheNavigationToPagesGraphPage();
		util.graphZoomInByDragAndDrop(page, userCentricPageWidgetXaxisPoints, userCentricPageWidgetZoomResetBtn, xPoints);
	}
	
	public void validateWhetherTheTooltipIsDisplayingForUserCentricPageLoadWidget() {
		validateTheNavigationToPagesGraphPage();
		util.validateWidgetToolTips(page, userCentricPageWidgetXaxisPoints, userCentricPageWidgetTooltipTitle);
	}
	
	public void validateTheLegendsLabelInUserCentricPageWidget(String legend) throws EncryptedDocumentException, IOException {
		validateTheNavigationToPagesGraphPage();
		page.waitForSelector(userCentricPageWidgetLegendsList);
		util.validateWidgetLegendsText(page, userCentricPageWidgetLegendsList, legend);
    }
	
	public void validateTheLegendsColorInUserCentricPageWidget() throws EncryptedDocumentException, IOException {
		validateTheNavigationToPagesGraphPage();
		page.waitForSelector(userCentricPageWidgetLegendsList);
		util.validateWidgetLegends(page, userCentricPageWidgetLegendsList, userCentricPageWidgetLegendsColorList, userCentricPageWidgetLegendsLinesList, userCentricPageWidgetTooltipColorList, userCentricPageWidgetXaxisPoints, userCentricPageWidgetTooltipLabel);
    }
	
	public void validateTheTitleOfErrorWidget() throws EncryptedDocumentException, IOException {
		validateTheNavigationToPagesGraphPage();
		String title = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath,IPathConstant.bmPagesSheet, "errorWidgetTitle");
		util.ValidateTheTitle(page, errorWidgetTitle, title);
	}
	
	public void validateTheXaxisTitleOfErrorWidget() throws EncryptedDocumentException, IOException {
		validateTheNavigationToPagesGraphPage();
		String title = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath,IPathConstant.bmPagesSheet, "xaxisTitle");
		util.ValidateTheTitle(page, errorWidgetXaxisTitle, title);
	}
	
	public void validateTheYaxisTitleOfErrorWidget() throws EncryptedDocumentException, IOException {
		validateTheNavigationToPagesGraphPage();
		String title = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath,IPathConstant.bmPagesSheet, "errorWidgetYaxisTitle");
		util.ValidateTheTitle(page, errorWidgetYaxisTitle, title);
	}
	
	public void validateTheFunctionalityOfErrorWidgetZoomInButton () {
		validateTheNavigationToPagesGraphPage();
		util.graphZoomIn(page, errorWidgetZoomInBtn, errorWidgetZoomResetBtn, xPoints);
	}
	
	public void validateTheFunctionalityOfErrorWidgetZoomOutButton () {
		validateTheNavigationToPagesGraphPage();
		util.graphZoomOut(page, errorWidgetZoomInBtn, errorWidgetZoomOutBtn, errorWidgetZoomResetBtn, xPoints);
	}
	
	public void validateTheFunctionalityOfErrorWidgetZoomResetButton () {
		validateTheNavigationToPagesGraphPage();
		util.graphZoomReset(page, errorWidgetZoomInBtn, errorWidgetZoomResetBtn, xPoints);
	}
	
	public void validateZoomInByDragAndDropForErrorWidget() {
		validateTheNavigationToPagesGraphPage();
		util.graphZoomInByDragAndDrop(page, errorWidgetXaxisPoints, errorWidgetZoomResetBtn, xPoints);
	}
	
	public void validateWhetherTheTooltipIsDisplayingForErrorWidget() {
		validateTheNavigationToPagesGraphPage();
		util.validateWidgetToolTips(page, errorWidgetXaxisPoints, errorWidgetTooltipTitle);
	}
	
	public void validateTheVisibilityAndNavigationOfViewErrorsLinkInErrorWidget() {
		validateTheNavigationToPagesGraphPage();
		page.waitForSelector(viewErrorsOnErrorWidgetHeader);
		Assert.assertTrue(page.isVisible(viewErrorsOnErrorWidgetHeader));
		page.click(viewErrorsOnErrorWidgetHeader);
		page.waitForURL("**/errors?entity=Endpoint");
		Assert.assertTrue(page.url().contains("errors?entity=Endpoint"));
	}
	
	public void validateTheLegendsLabelInErrorWidget(String legend) throws EncryptedDocumentException, IOException {
		validateTheNavigationToPagesGraphPage();
		page.waitForSelector(errorWidgetLegendsList);
		util.validateWidgetLegendsText(page, errorWidgetLegendsList, legend);
    }
	
	public void validateTheLegendsColorInErrorWidget() throws EncryptedDocumentException, IOException {
		validateTheNavigationToPagesGraphPage();
		page.waitForSelector(errorWidgetLegendsList);
		util.validateWidgetLegends(page, errorWidgetLegendsList, errorWidgetLegendsColorList, errorWidgetLegendsLinesList, errorWidgetTooltipColorList, errorWidgetXaxisPoints, errorWidgetTooltipLabel);
    }
	
	public void validateTheTitleOfUserImpactedByErrorsWidget() throws EncryptedDocumentException, IOException {
		validateTheNavigationToPagesGraphPage();
		String title = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath,IPathConstant.bmPagesSheet, "userImpactedWidgetTitle");
		util.ValidateTheTitle(page, userImpactedByErrorsWidgetTitle, title);
	}
	
	public void validateTheXaxisTitleOfUserImpactedByErrorsWidget() throws EncryptedDocumentException, IOException {
		validateTheNavigationToPagesGraphPage();
		String title = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath,IPathConstant.bmPagesSheet, "xaxisTitle");
		util.ValidateTheTitle(page, userImpactedByErrorsWidgetXaxisTitle, title);
	}
	
	public void validateTheYaxisTitleOfUserImpactedByErrorsWidget() throws EncryptedDocumentException, IOException {
		validateTheNavigationToPagesGraphPage();
		String title = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath,IPathConstant.bmPagesSheet, "userImpactedWidgetYaxisTitle");
		util.ValidateTheTitle(page, userImpactedByErrorsWidgetYaxisTitle, title);
	}
	
	public void validateWhetherTheTooltipIsDisplayingForUserImpactedByErrorsWidget() {
		validateTheNavigationToPagesGraphPage();
		util.validateWidgetToolTips(page, userImpactedByErrorsWidgetXaxisPoints, userImpactedByErrorsWidgetTooltipTitle);
	}
	
	public void validateTheTitleOfErrorCountMapWidget() throws EncryptedDocumentException, IOException {
		validateTheNavigationToPagesGraphPage();
		String title = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath,IPathConstant.bmPagesSheet, "errorCountMapWidgetTitle");
		util.ValidateTheTitle(page, errorCountmapWidgetTitle, title);
	}
	
	public void validateTheNumberOfCallsFromPagesTableInPagesGraphPageLoadWidgetHeader() {
		page.waitForSelector(callsColumnData);
		String expectedCalls = page.locator(callsColumnData).nth(0).textContent().trim();
		page.locator(nameColumnData).nth(0).click();
		page.waitForSelector(pageNameOnPagesGraphPage);
		String actualCalls = page.textContent(callsOnLoadWidgetHeader).trim().replace(" calls", "");
		System.out.println("expectedCalls : "+expectedCalls+"\t actualCalls : "+actualCalls);
		Assert.assertTrue(actualCalls.equals(expectedCalls));
	}
	
	public void validateTheNumberOfCallsFromPagesTableInPagesGraphPageLoadWidgetGraph() {
		page.waitForSelector(callsColumnData);
		String calls = page.locator(callsColumnData).nth(0).textContent().trim();
		page.locator(nameColumnData).nth(0).click();
		page.waitForSelector(pageNameOnPagesGraphPage);
		int expectedCalls = Integer.parseInt(calls);
		int actualCalls = util.getTheSummationFromTheWidgetTooltip(page, loadWidgetXaxisPoints, loadWidgetTooltipValue);
		System.out.println("expectedCalls : "+expectedCalls+"\t actualCalls : "+actualCalls);
		Assert.assertTrue(actualCalls == expectedCalls);
	}
	
	public void validateTheCallsPerMinuteFromPagesTableInPagesGraphPageLoadWidgetHeader() {
		page.waitForSelector(cpmColumnData);
		String expectedCpm = page.locator(cpmColumnData).nth(0).textContent().trim();
		page.locator(nameColumnData).nth(0).click();
		page.waitForSelector(pageNameOnPagesGraphPage);
		String actualCpm = page.textContent(cpmOnLoadWidgetHeader).trim().replace(" calls/min", "");
		System.out.println("expectedCpm : "+expectedCpm+"\t actualCpm : "+actualCpm);
		Assert.assertTrue(actualCpm.equals(expectedCpm));
	}
	
	public void validateTheNumberOfErrorsFromPagesTableInPagesGraphPageErrorWidgetGraph() {
		page.waitForSelector(errorsColumnData);
		String errors = page.locator(errorsColumnData).nth(0).textContent().trim();
		page.locator(nameColumnData).nth(0).click();
		page.waitForSelector(pageNameOnPagesGraphPage);
		int expectedErrors = Integer.parseInt(errors);
		page.locator(errorWidgetXaxisPoints).nth(3).scrollIntoViewIfNeeded();
		page.waitForTimeout(1500);
	    int num=page.locator(errorWidgetXaxisPoints).count();
	    HoverOptions hoverOptions=new HoverOptions();
	    hoverOptions.setForce(true);
	    int actualErrors=0;int count = 0;
	       for(int i=0;i<num;i++)
			 {
	    	   if(count==num-1)
	    	   {
	    	       hoverOptions.setPosition(1,-10);
	    		   page.locator( errorWidgetXaxisPoints).nth(i).hover(hoverOptions); 
	    	   }else
	    	   {
	    	    hoverOptions.setPosition(2,-10);
	    		page.locator( errorWidgetXaxisPoints).nth(i).hover(hoverOptions);  
	    	   }
	    	   count++;
	    		page.waitForTimeout(200);
	    		int tipValue = 0;
	    		Locator tooltip = page.locator(errorWidgetTooltipValue);
	    		for(int j=0; j<tooltip.count(); j++) {
	    			try {
	    				tipValue = tipValue + Integer.parseInt(tooltip.nth(j).textContent().trim());
					} catch (NumberFormatException e) {
						tipValue = tipValue + (int)Double.parseDouble(tooltip.nth(j).textContent().trim());
					}
	    		}
	    		actualErrors = actualErrors + tipValue;
	    	 }
		System.out.println("expectedErrors : "+expectedErrors+"\t actualErrors : "+actualErrors);
		Assert.assertTrue(actualErrors == expectedErrors);
	}
	
	public void validateTheNumberOfErrorsFromPagesTableInPagesGraphPageErrorCountMapWidget() {
		HoverOptions hoverOpt = new HoverOptions();
		hoverOpt.setForce(true);
		page.waitForSelector(errorsColumnData);
		String errors = page.locator(errorsColumnData).nth(0).textContent().trim();
		page.locator(nameColumnData).nth(0).click();
		page.waitForSelector(pageNameOnPagesGraphPage);
		int expectedErrors = Integer.parseInt(errors);
		
		int actualErrors = 0;
		Locator countries = page.locator(countriesOnErrorMap);
		for(int i=0; i<countries.count(); i++) {
			countries.nth(i).hover(hoverOpt);
			try{
				page.waitForSelector(errorMapToolTipValue);
				page.waitForTimeout(100);
				if(Integer.parseInt(page.textContent(errorMapToolTipValue).trim()) > 0)
				{
					System.out.println(page.textContent(errorMapToolTipTitle).trim()+"\t"+page.textContent(errorMapToolTipValue).trim());
					actualErrors = actualErrors + Integer.parseInt(page.textContent(errorMapToolTipValue).trim());
				}
			}catch(Exception e) {
				i++;
			}
		}
		System.out.println("expectedErrors : "+expectedErrors+"\t actualErrors : "+actualErrors);
		Assert.assertTrue(actualErrors == expectedErrors);
	}
	
	public void validateTheNumberOfErrorsFromPagesTableInErrorPageTableThroughViewErrorLink() {
		bmError = new BmErrorsPage(page);
		page.waitForSelector(errorsColumnData);
		String errors = page.locator(errorsColumnData).nth(0).textContent().trim();
		page.locator(nameColumnData).nth(0).click();
		page.waitForSelector(pageNameOnPagesGraphPage);
		int expectedErrors = Integer.parseInt(errors);
		
		page.click(viewErrorsOnErrorWidgetHeader);
		int actualErrors = bmError.getEventsTotalFromTable();
		System.out.println("expectedErrors : "+expectedErrors+"\t actualErrors : "+actualErrors);
		Assert.assertTrue(actualErrors == expectedErrors);
	}
	
	public void validateWhetherClickingOnErrorDataInPagesTableNavigatesToErrorPage() {
		page.waitForSelector(errorsColumnData);
		page.locator(errorsColumnData).first().click();
		page.waitForURL("**/browser/errors");
		Assert.assertTrue(page.url().contains("/browser/errors"));
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
	
	public void validateTheLoadInPagesTable(int expectedLoad) {
		navigateToPagesTab();
		page.waitForSelector(callsColumnData);
		int actualLoad = 0;
		Locator calls = page.locator(callsColumnData);
		for(int i=0; i<calls.count(); i++) {
			actualLoad = actualLoad + Integer.parseInt(calls.nth(i).textContent().trim());
		}
		System.out.println("expectedLoad : "+expectedLoad+"\t actualLoad :"+actualLoad);
		Assert.assertTrue(actualLoad == expectedLoad);
	}
	
	public void validateAverageResponseTimeInPagesPage() {
		bmApp = new BmApplicationPage(page);
		navigateToPagesTab();
		page.waitForSelector(responseTimeColumnData);
		int respTime = 0;
		Locator time = page.locator(responseTimeColumnData);
		for(int i=0; i<time.count(); i++) {
			respTime = respTime + Integer.parseInt(time.nth(i).textContent().trim());
		}
		int actualRespTime = respTime/time.count();
		int expectedRespTime = bmApp.getavgRespTime();
		System.out.println("expectedRespTime : "+expectedRespTime+"\t actualrespTime : "+actualRespTime);
	    Assert.assertTrue(actualRespTime == expectedRespTime);
	}
	
	public void selectLegend_Browser_app_page_redirect_avg_AndValidateTheValueInGraph() throws EncryptedDocumentException, IOException {
		page.waitForSelector(userCentricPageWidgetLegendsLinesList);
		deselectAllTheLegendsInUserCentricPageLoadGraph();
		page.waitForTimeout(300);
		String[] data = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmPagesSheet, "userCentricPageWidgetLegends").split(",");
		String expectedValue = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmDataValidationSheet, "angularLoad_redirectTime");
		validateTheLegendValue(data[0], expectedValue);
	}
	
	public void selectLegend_Browser_app_page_dns_avg_AndValidateTheValueInGraph() throws EncryptedDocumentException, IOException {
		page.waitForSelector(userCentricPageWidgetLegendsLinesList);
		deselectAllTheLegendsInUserCentricPageLoadGraph();
		page.waitForTimeout(300);
		String[] data = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmPagesSheet, "userCentricPageWidgetLegends").split(",");
		String expectedValue = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmDataValidationSheet, "angularLoad_dnsTime");
		validateTheLegendValue(data[1], expectedValue);
	}
	
	public void selectLegend_Browser_app_page_ttfb_avg_AndValidateTheValueInGraph() throws EncryptedDocumentException, IOException {
		page.waitForSelector(userCentricPageWidgetLegendsLinesList);
		deselectAllTheLegendsInUserCentricPageLoadGraph();
		page.waitForTimeout(300);
		String[] data = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmPagesSheet, "userCentricPageWidgetLegends").split(",");
		String expectedValue = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmDataValidationSheet, "angularLoad_ttfbTime");
		validateTheLegendValue(data[2], expectedValue);
	}
	
	public void selectLegend_Browser_app_page_tcp_avg_AndValidateTheValueInGraph() throws EncryptedDocumentException, IOException {
		page.waitForSelector(userCentricPageWidgetLegendsLinesList);
		deselectAllTheLegendsInUserCentricPageLoadGraph();
		page.waitForTimeout(300);
		String[] data = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmPagesSheet, "userCentricPageWidgetLegends").split(",");
		String expectedValue = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmDataValidationSheet, "angularLoad_tcpTime");
		validateTheLegendValue(data[3], expectedValue);
	}
	
	public void selectLegend_Browser_app_page_trans_avg_AndValidateTheValueInGraph() throws EncryptedDocumentException, IOException {
		page.waitForSelector(userCentricPageWidgetLegendsLinesList);
		deselectAllTheLegendsInUserCentricPageLoadGraph();
		page.waitForTimeout(300);
		String[] data = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmPagesSheet, "userCentricPageWidgetLegends").split(",");
		String expectedValue = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmDataValidationSheet, "angularLoad_transTime");
		validateTheLegendValue(data[4], expectedValue);
	}
	
	public void selectLegend_Browser_app_page_dom_analysis_avg_AndValidateTheValueInGraph() throws EncryptedDocumentException, IOException {
		page.waitForSelector(userCentricPageWidgetLegendsLinesList);
		deselectAllTheLegendsInUserCentricPageLoadGraph();
		page.waitForTimeout(300);
		String[] data = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmPagesSheet, "userCentricPageWidgetLegends").split(",");
		String expectedValue = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmDataValidationSheet, "angularLoad_domAnalysisTime");
		validateTheLegendValue(data[5], expectedValue);
	}
	
	public void selectLegend_Browser_app_page_fpt_avg_AndValidateTheValueInGraph() throws EncryptedDocumentException, IOException {
		page.waitForSelector(userCentricPageWidgetLegendsLinesList);
		deselectAllTheLegendsInUserCentricPageLoadGraph();
		page.waitForTimeout(300);
		String[] data = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmPagesSheet, "userCentricPageWidgetLegends").split(",");
		String expectedValue = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmDataValidationSheet, "angularLoad_fptTime");
		validateTheLegendValue(data[6], expectedValue);
	}
	
	public void selectLegend_Browser_app_page_dom_ready_avg_AndValidateTheValueInGraph() throws EncryptedDocumentException, IOException {
		page.waitForSelector(userCentricPageWidgetLegendsLinesList);
		deselectAllTheLegendsInUserCentricPageLoadGraph();
		page.waitForTimeout(300);
		String[] data = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmPagesSheet, "userCentricPageWidgetLegends").split(",");
		String expectedValue = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmDataValidationSheet, "angularLoad_domReadyTime");
		validateTheLegendValue(data[7], expectedValue);
	}
	
	public void selectLegend_Browser_app_page_load_page_avg_AndValidateTheValueInGraph() throws EncryptedDocumentException, IOException {
		page.waitForSelector(userCentricPageWidgetLegendsLinesList);
		deselectAllTheLegendsInUserCentricPageLoadGraph();
		page.waitForTimeout(300);
		String[] data = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmPagesSheet, "userCentricPageWidgetLegends").split(",");
		String expectedValue = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmDataValidationSheet, "angularLoad_loadPageTime");
		validateTheLegendValue(data[8], expectedValue);
	}
	
	public void selectLegend_Browser_app_page_res_avg_AndValidateTheValueInGraph() throws EncryptedDocumentException, IOException {
		page.waitForSelector(userCentricPageWidgetLegendsLinesList);
		deselectAllTheLegendsInUserCentricPageLoadGraph();
		page.waitForTimeout(300);
		String[] data = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmPagesSheet, "userCentricPageWidgetLegends").split(",");
		String expectedValue = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmDataValidationSheet, "angularLoad_resTime");
		validateTheLegendValue(data[9], expectedValue);
	}
	
	public void selectLegend_Browser_app_page_ttl_avg_AndValidateTheValueInGraph() throws EncryptedDocumentException, IOException {
		page.waitForSelector(userCentricPageWidgetLegendsLinesList);
		deselectAllTheLegendsInUserCentricPageLoadGraph();
		page.waitForTimeout(300);
		String[] data = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmPagesSheet, "userCentricPageWidgetLegends").split(",");
		String expectedValue = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmDataValidationSheet, "angularLoad_ttlTime");
		validateTheLegendValue(data[11], expectedValue);
	}
	
	public void selectLegend_Browser_app_page_first_pack_avg_AndValidateTheValueInGraph() throws EncryptedDocumentException, IOException {
		page.waitForSelector(userCentricPageWidgetLegendsLinesList);
		deselectAllTheLegendsInUserCentricPageLoadGraph();
		page.waitForTimeout(300);
		String[] data = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmPagesSheet, "userCentricPageWidgetLegends").split(",");
		String expectedValue = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmDataValidationSheet, "angularLoad_firstPackTime");
		validateTheLegendValue(data[12], expectedValue);
	}
	
	public void selectLegend_Browser_app_page_fmp_avg_AndValidateTheValueInGraph() throws EncryptedDocumentException, IOException {
		page.waitForSelector(userCentricPageWidgetLegendsLinesList);
		deselectAllTheLegendsInUserCentricPageLoadGraph();
		page.waitForTimeout(300);
		String[] data = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmPagesSheet, "userCentricPageWidgetLegends").split(",");
		String expectedValue = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmDataValidationSheet, "angularLoad_fmpTime");
		validateTheLegendValue(data[13], expectedValue);
	}
		
	public void validateTheLegendValue(String legend, String value) {
		int expectedValue = Integer.parseInt(value);
		HoverOptions hoverOpt = new HoverOptions();
		int count = 0;
		int actualValue = 0;
		hoverOpt.setForce(true);
		Locator legends = page.locator(userCentricPageWidgetLegendsList);
		for(int i=0; i<legends.count(); i++) {
			if(legends.nth(i).textContent().trim().equals(legend)) {
			legends.nth(i).click();
			break;
			}
		}
		
		Locator xpoints = page.locator(userCentricPageWidgetXaxisPoints);
		for(int i=0; i<xpoints.count(); i++) {
			if(i == xpoints.count()-1)
				hoverOpt.setPosition(1, -10);
			else
				hoverOpt.setPosition(2, -10);
			
		xpoints.nth(i).hover(hoverOpt);
		page.waitForTimeout(300);
		Locator tooltip = page.locator(userCentricPageWidgetTooltipValue);
		for(int j=0; j<tooltip.count(); j++) {
			if(tooltip.nth(j).isVisible())
				actualValue = actualValue + (int)Double.parseDouble(page.locator(userCentricPageWidgetTooltipValue).nth(j).textContent().trim());
		}
		if(!page.textContent(loadWidgetTooltipValue).trim().equals("0"))
			count++;
		}
		System.out.println(actualValue+"\t"+count);
		actualValue = actualValue/count;
		System.out.println("expectedValue : "+expectedValue+"\t actualValue : "+actualValue);
		Assert.assertTrue(actualValue == expectedValue);
	}
	
	public void deselectAllTheLegendsInUserCentricPageLoadGraph() {
		Locator legends = page.locator(userCentricPageWidgetLegendsList);
		for(int i=0; i<legends.count(); i++) {
			legends.nth(i).click();
			page.waitForTimeout(100);
		}
	}
	
	public void deselectAllTheLegendsInErrorGraph() {
		Locator legends = page.locator(errorWidgetLegendsList);
		for(int i=0; i<legends.count(); i++) {
			legends.nth(i).click();
			page.waitForTimeout(100);
		}
	}
	
	public void validateTheErrorInPagesTable(int expectedError) {
		navigateToPagesTab();
		page.waitForSelector(errorsColumnData);
		int actualError = 0;
		Locator errors = page.locator(errorsColumnData);
		for(int i=0; i<errors.count(); i++) {
			actualError = actualError + Integer.parseInt(errors.nth(i).textContent().trim());
		}
		System.out.println("expectedError : "+expectedError+"\t actualLoad :"+actualError);
		Assert.assertTrue(actualError == expectedError);
	}
	
	public void validateTheErrorGraphInPagesGraphPageForAjaxCategoryErrors() throws EncryptedDocumentException, IOException {
		String category="", path=""; int count=0;
		String[] paths = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmDataValidationSheet, "angularError_pagePaths").split(",");
		String[] cat = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmDataValidationSheet, "angularError_categories").split(",");
		String[] counts = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmDataValidationSheet, "angularError_counts").split(",");
		for(int i=0; i<cat.length; i++) {
			if(cat[i].equalsIgnoreCase("ajax")) {
				category = cat[i];
				path = paths[i];
				count = Integer.parseInt(counts[i]);
				break;
			}
		}
		System.out.println(category +"\t"+path+"\t"+count);
		validateTheErrorGraphInPagesGraphPageForSpecificCategoryErrors(category, path, count);
	}
	
	public void validateTheErrorGraphInPagesGraphPageForJsCategoryErrors() throws EncryptedDocumentException, IOException {
		String category="", path=""; int count=0;
		String[] paths = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmDataValidationSheet, "angularError_pagePaths").split(",");
		String[] cat = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmDataValidationSheet, "angularError_categories").split(",");
		String[] counts = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmDataValidationSheet, "angularError_counts").split(",");
		for(int i=0; i<cat.length; i++) {
			if(cat[i].equalsIgnoreCase("js")) {
				category = cat[i];
				path = paths[i];
				count = Integer.parseInt(counts[i]);
				break;
			}
		}
		System.out.println(category +"\t"+path+"\t"+count);
		validateTheErrorGraphInPagesGraphPageForSpecificCategoryErrors(category, path, count);
	}
	
	public void validateTheErrorGraphInPagesGraphPageForResourceCategoryErrors() throws EncryptedDocumentException, IOException {
		String category="", path=""; int count=0;
		String[] paths = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmDataValidationSheet, "angularError_pagePaths").split(",");
		String[] cat = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmDataValidationSheet, "angularError_categories").split(",");
		String[] counts = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmDataValidationSheet, "angularError_counts").split(",");
		for(int i=0; i<cat.length; i++) {
			if(cat[i].equalsIgnoreCase("resource")) {
				category = cat[i];
				path = paths[i];
				count = Integer.parseInt(counts[i]);
				break;
			}
		}
		System.out.println(category +"\t"+path+"\t"+count);
		validateTheErrorGraphInPagesGraphPageForSpecificCategoryErrors(category, path, count);
	}
	
	public void validateTheErrorGraphInPagesGraphPageForSpecificCategoryErrors(String cat, String path, int count) {
		navigateToPagesTab();
		page.waitForSelector(nameColumnData);
		Locator paths = page.locator(nameColumnData);
		for(int i=0; i<paths.count(); i++) {
			if(paths.nth(i).textContent().trim().equalsIgnoreCase(path)) {
				paths.nth(i).click();
				page.waitForSelector(pageNameOnPagesGraphPage);
				Assert.assertTrue(page.textContent(pageNameOnPagesGraphPage).trim().equals(path));
				break;
			}
		}
		Locator legends = page.locator(errorWidgetLegendsList);
		page.waitForTimeout(1000);
		for(int i=0; i<legends.count(); i++) {
			if(!legends.nth(i).textContent().trim().toLowerCase().contains(cat)) {
				legends.nth(i).click();
				page.waitForTimeout(100);
			}
			else {
				page.waitForTimeout(100);
				continue;
			}
		}
		int actualValue = 0;
		HoverOptions hoverOpt = new HoverOptions();
		hoverOpt.setForce(true);
		int num=page.locator(errorWidgetXaxisPoints).count();
		Locator xpoints = page.locator(errorWidgetXaxisPoints);
		for(int i=0; i<xpoints.count(); i++) {
			if(i == xpoints.count()-1)
				hoverOpt.setPosition(1, -10);
			else
				hoverOpt.setPosition(2, -10);
			
		xpoints.nth(i).hover(hoverOpt);
		page.waitForTimeout(300);
		Locator tooltip = page.locator(errorWidgetTooltipValue);
		for(int j=0; j<tooltip.count(); j++) {
			if(tooltip.nth(j).isVisible())
				actualValue = actualValue + Integer.parseInt(page.locator(errorWidgetTooltipValue).nth(j).textContent().trim());
		}
		}
		System.out.println(actualValue+"\t"+count);
		System.out.println("expectedValue : "+count+"\t actualValue : "+actualValue);
		Assert.assertTrue(actualValue == count);
	}
	
	public void validateThePagePaths(LinkedHashSet<String> paths) {
		navigateToPagesTab();
		page.waitForSelector(nameColumnData);
		page.waitForTimeout(1000);
		validatePagination(50);
		page.waitForTimeout(1000);
		Locator names = page.locator(nameColumnData);
		for (String path : paths) {
			boolean flag = false;
			for(int i=0; i<names.count();i++) {
				if(names.nth(i).textContent().trim().equalsIgnoreCase(path)) {
					flag = true;
					break;
				}
			}
			Assert.assertTrue(flag);
		}
	}
}
