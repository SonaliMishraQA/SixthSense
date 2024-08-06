package objectRepository.APM;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Page.WaitForSelectorOptions;
import com.microsoft.playwright.options.LoadState;
import com.microsoft.playwright.Locator.HoverOptions;

import genericUtilities.ExcelUtility;
import genericUtilities.GenericMethods;
import genericUtilities.IPathConstant;
import objectRepository.CommonPage;

public class ApmInstancePage {
	
	Page page;
	GenericMethods util = new GenericMethods();
	CommonPage common;
	static ExcelUtility excel = new ExcelUtility();
	
	private String instanceTab = "#dasboard-tab-instance";
	private String documentationBtn = "#view-doc-btn";
	private String softRefreshBtn = "#btn-refresh";
	private String firstColumn = "xpath = (//div[@class='endpointTable page']//div[@class='test'])[1]";
	private String secondColumn = "xpath = (//div[@class='endpointTable page']//div[@class='test'])[2]";
	private String thirdColumn = "xpath = (//div[@class='endpointTable page']//div[@class='test'])[3]";
	private String fourthColumn = "xpath = (//div[@class='endpointTable page']//div[@class='test'])[4]";
	private String fifthColumn = "xpath = (//div[@class='endpointTable page']//div[@class='test'])[5]";
	private String sixthColumn = "xpath = (//div[@class='endpointTable page']//div[@class='test'])[6]";
	private String seventhColumn = "xpath = (//div[@class='endpointTable page']//div[@class='test'])[7]";
	private String searchInstancesTextField = "xpath = //div[@id='search-container']//input[@class='search-box']";
	private String searchResult = "xpath = //div[@class='cell-action-container']//span[@class='cursor-pointer' or @class='active-instance-id']";
	private String noDataIcon = "xpath = //div[@class='no-data-icon']//div[@class='inner-text']";
	private String firstInstanceName = "xpath = (//div[@class='main-row']//div[@class='cell-with-active-instances'])[1]/span[2]";
	private String searchBtn = "#btn-search";
	private String clearSearchBtn = "#btn-clear-search";
	private String firstInstanceEditBtn = "xpath = (//div[@class='main-row'])[1]//*[name()='svg' and @id='edit_filled']";
	private String resetBtn = "#edit-cancel-btn";
	private String updateBtn = "#edit-confirm-btn";
	private String editInstanceNameTextField = "#instance-name-input";
	private String editInstanceConfirmationMessage = "xpath = //div[@class='ant-notification-notice-with-icon']";
	private String messgaeCloseBtn = "xpath = //*[name()='svg' and @data-icon='close']";
	private String errorPercentColumnHead = "xpath = //div[@class='test' and .='Error (%) ']";
	private String errorsPercentAscBtn = "#sort-errorPercent-asc";
	private String errorsPercentDesBtn = "#sort-errorPercent-des";
	private String errorPercentColData = "xpath = //div[@id='redirect-1-1' or contains(@id,'-1') and not(contains(@id,'1-'))]";
	private String firstInstanceErrorPercent = "#redirect-0-1";
	private String errorsColumnHead = "xpath = //div[@class='test' and .='Errors ']";
	private String errorsOnTable = "xpath = (//div[@class='table-td border-right'])[position() mod 3 =0 and not(position() mod 6 =0)]";
	private String errorsAscBtn = "#sort-errors-asc";
	private String errorsDesBtn = "#sort-errors-des";
	private String errorsColData = "xpath = //div[@id='redirect-2-2' or contains(@id,'-2') and not(contains(@id,'2-'))]";
	private String firstInstanceError = "#redirect-0-2";
	private String epmColumnHead = "xpath = //div[@class='test' and .='Errors/min ']";
	private String epmAscBtn = "#sort-epm-asc";
	private String epmDesBtn = "#sort-epm-des";
	private String epmColData = "xpath = //div[@id='redirect-3-3' or contains(@id,'-3') and not(contains(@id,'3-'))]";
	private String firstInstanceEpm = "#redirect-0-3";
	private String responseTimeColumnHead = "xpath = //div[@class='test' and .='Response time (ms) ']";
	private String responseTimeAscBtn = "#sort-respTime-asc";
	private String responseTimeDesBtn = "#sort-respTime-des";
	private String responseTimeColData = "xpath = //div[@id='redirect-4-4' or contains(@id,'-4') and not(contains(@id,'4-'))]";
	private String firstInstanceResponseTime = "#redirect-0-4";
	private String callsColumnHead = "xpath = //div[@class='test' and .='Calls ']";
	private String callsOnTable = "xpath = (//div[@class='table-td border-right'])[position() mod 6 =0]";
	private String callsAscBtn = "#sort-calls-asc";
	private String callsDesBtn = "#sort-calls-des";
	private String callsColData = "xpath = //div[@id='redirect-5-5' or contains(@id,'-5') and not(contains(@id,'5-'))]";
	private String firstInstanceCall = "#redirect-0-5";
	private String cpmColumnHead = "xpath = //div[@class='test' and .='Calls/min ']";
	private String cpmAscBtn = "#sort-cpm-asc";
	private String cpmDesBtn = "#sort-cpm-des";
	private String cpmColData = "xpath = //div[@id='redirect-6-6' or contains(@id,'-6') and not(contains(@id,'6-'))]";
	private String firstInstanceCpm = "#redirect-0-6";
	private String secondInstanceCpm = "#redirect-1-6";
	private String graphPageBackBtn = "xpath = //button[@class='icon-class']";

	private String instanceGraphHeader = "xpath = //span[@class='icon-label']";
	private String loadGraphHeader = "xpath = //div[@id='apexchartsvuechart-line-0']/ancestor::div[@class='chart-body']/preceding-sibling::div[@class='line-header']/div[@class='line-title']";
	private String loadGraphYAxis = "xpath = //div[@id='apexchartsvuechart-line-0']//*[name()='g' and @class='apexcharts-yaxis-title']";
	private String loadGraphXAxis = "xpath = //div[@id='apexchartsvuechart-line-0']//*[name()='g' and @class='apexcharts-xaxis-title']";
	private String loadGraphZoomOutBtn = "#Load-zoom-out";
	private String loadGraphZoomInBtn = "#Load-zoom-in";
	private String loadGraphZoomResetBtn = "#Load-zoom-reset";
	private String loadGraphPointXpath = "xpath = //div[@id='apexchartsvuechart-line-0']//*[name()='line' and @class='apexcharts-xaxis-tick']";
	private String loadGraphTooltipTitle = "xpath = //div[@id='apexchartsvuechart-line-0']//div[@class='apexcharts-tooltip-title']";
	private String loadGraphTooltipText = "xpath = //div[@id='apexchartsvuechart-line-0']//span[@class='apexcharts-tooltip-text-y-value']";
	private String loadGraphCalls = "xpath = //span[@class='line-content-calls']";
	private String loadGraphCpm = "xpath = //div[@class='line-content']/span[2]";
	private String loadGraphXaxisLabels = "//div[@id='apexchartsvuechart-line-0']/descendant::*[name()='g' and @class='apexcharts-xaxis-texts-g']//*[name()='tspan' and contains(text(),'-')]";
	
	private String errorGraphHeader = "xpath = //div[@id='apexchartsvuechart-line-1']/ancestor::div[@class='chart-body']/preceding-sibling::div[@class='line-header']/div[@class='line-title']";
	private String errorGraphYAxis = "xpath = //div[@id='apexchartsvuechart-line-1']//*[name()='g' and @class='apexcharts-yaxis-title']";
	private String errorGraphXAxis = "xpath = //div[@id='apexchartsvuechart-line-1']//*[name()='g' and @class='apexcharts-xaxis-title']";
	private String errorGraphZoomOutBtn = "#Error-zoom-out";
	private String errorGraphZoomInBtn = "#Error-zoom-in";
	private String errorGraphZoomResetBtn = "#Error-zoom-reset";
	private String errorTracesBtn = "xpath = //div[@class='custom-button' and text()=' Error traces ']";
	private String errorGraphPointXpath = "xpath = //div[@id='apexchartsvuechart-line-1']//*[name()='line' and @class='apexcharts-xaxis-tick']";
	private String errorGraphTooltipTitle = "xpath = //div[@id='apexchartsvuechart-line-1']//div[@class='apexcharts-tooltip-title']";
	private String errorGraphTooltipText = "xpath = //div[@id='apexchartsvuechart-line-1']//span[@class='apexcharts-tooltip-text-y-value']";
	private String errorGraphErrorPercentage = "xpath = //span[@class='line-error-percentage']";
	private String errorGraphErrors = "xpath = //span[@class='line-errors']";
	private String errorGraphEpm = "xpath = //div[@class='line-content-error']/span[3]";
	private String errorGraphXaxisLabels = "//div[@id='apexchartsvuechart-line-1']/descendant::*[name()='g' and @class='apexcharts-xaxis-texts-g']//*[name()='tspan' and contains(text(),'-')]";
	
	private String responseTimeGraphHeader = "xpath = //div[@id='apexchartsvuechart-line-2']/ancestor::div[@class='chart-body']/preceding-sibling::div[@class='line-header']/div[@class='line-title']";
	private String responseTimeGraphYAxis = "xpath = //div[@id='apexchartsvuechart-line-2']//*[name()='g' and @class='apexcharts-yaxis-title']";
	private String responseTimeGraphXAxis = "xpath = //div[@id='apexchartsvuechart-line-2']//*[name()='g' and @class='apexcharts-xaxis-title']";
	private String responseTimeGraphZoomOutBtn = "#Response-time-zoom-out";
	private String responseTimeGraphZoomInBtn = "#Response-time-zoom-in";
	private String responseTimeGraphZoomResetBtn = "#Response-time-zoom-reset";
	private String slowTracesBtn = "xpath = //div[@class='custom-button' and text()=' Slow traces ']";
	private String responseTimeGraphPointXpath = "xpath = //div[@id='apexchartsvuechart-line-2']//*[name()='line' and @class='apexcharts-xaxis-tick']";
	private String responseTimeGraphTooltipTitle = "xpath = //div[@id='apexchartsvuechart-line-2']//div[@class='apexcharts-tooltip-title']";
	private String responseTimeGraphTooltipText = "xpath = //div[@id='apexchartsvuechart-line-2']//span[@class='apexcharts-tooltip-text-y-value']";
	private String responseTimeGraphAvgResponseTime = "xpath = //div[@id='apexchartsvuechart-line-2']/ancestor::div[@class='chart-body']/preceding-sibling::div/div[@class='line-content']";
	private String responseTimeGraphXaxisLabels = "//div[@id='apexchartsvuechart-line-2']/descendant::*[name()='g' and @class='apexcharts-xaxis-texts-g']//*[name()='tspan' and contains(text(),'-')]";
	
	private String jvmCpuPercentGraphHeader = "xpath = //div[@id='apexchartsvuechart-line-3']/ancestor::div[@class='chart-body']/preceding-sibling::div[@class='line-header']/div[@class='line-title']";
	private String jvmCpuPercentGraphYAxis = "xpath = //div[@id='apexchartsvuechart-line-3']//*[name()='g' and @class='apexcharts-yaxis-title']";
	private String jvmCpuPercentGraphXAxis = "xpath = //div[@id='apexchartsvuechart-line-3']//*[name()='g' and @class='apexcharts-xaxis-title']";
	private String jvmCpuPercentGraphZoomOutBtn = "#JVM-CPU-(%)-zoom-out";
	private String jvmCpuPercentGraphZoomInBtn = "#JVM-CPU-(%)-zoom-in";
	private String jvmCpuPercentGraphZoomResetBtn = "#JVM-CPU-(%)-zoom-reset";
	private String jvmCpuPercentGraphPointXpath = "xpath = //div[@id='apexchartsvuechart-line-3']//*[name()='line' and @class='apexcharts-xaxis-tick']";
	private String jvmCpuPercentGraphTooltipTitle = "xpath = //div[@id='apexchartsvuechart-line-3']//div[@class='apexcharts-tooltip-title']";
	private String jvmCpuPercentGraphTooltipText = "xpath = //div[@id='apexchartsvuechart-line-3']//span[@class='apexcharts-tooltip-text-y-value']";

	private String jvmMemoryGraphHeader = "xpath = //div[@id='apexchartsvuechart-line-4']/ancestor::div[@class='chart-body']/preceding-sibling::div[@class='line-header']/div[@class='line-title']";
	private String jvmMemoryGraphYAxis = "xpath = //div[@id='apexchartsvuechart-line-4']//*[name()='g' and @class='apexcharts-yaxis-title']";
	private String jvmMemoryGraphXAxis = "xpath = //div[@id='apexchartsvuechart-line-4']//*[name()='g' and @class='apexcharts-xaxis-title']";
	private String jvmMemoryGraphZoomOutBtn = "#JVM-memory-(MB)-zoom-out";
	private String jvmMemoryGraphZoomInBtn = "#JVM-memory-(MB)-zoom-in";
	private String jvmMemoryGraphZoomResetBtn = "#JVM-memory-(MB)-zoom-reset";
	private String jvmMemoryGraphPointXpath = "xpath = //div[@id='apexchartsvuechart-line-4']//*[name()='line' and @class='apexcharts-xaxis-tick']";
	private String jvmMemoryGraphTooltipTitle = "xpath = //div[@id='apexchartsvuechart-line-4']//div[@class='apexcharts-tooltip-title']";
	private String jvmMemoryGraphTooltipText = "xpath = //div[@id='apexchartsvuechart-line-4']//span[@class='apexcharts-tooltip-text-y-value']";

	private String gcTimeGraphHeader = "xpath = //div[@id='apexchartsvuechart-line-5']/ancestor::div[@class='chart-body']/preceding-sibling::div[@class='line-header']/div[@class='line-title']";
	private String gcTimeGraphYAxis = "xpath = //div[@id='apexchartsvuechart-line-5']//*[name()='g' and @class='apexcharts-yaxis-title']";
	private String gcTimeGraphXAxis = "xpath = //div[@id='apexchartsvuechart-line-5']//*[name()='g' and @class='apexcharts-xaxis-title']";
	private String gcTimeGraphZoomOutBtn = "#GC-time-(ms)-zoom-out";
	private String gcTimeGraphZoomInBtn = "#GC-time-(ms)-zoom-in";
	private String gcTimeGraphZoomResetBtn = "#GC-time-(ms)-zoom-reset";
	private String gcTimeGraphPointXpath = "xpath = //div[@id='apexchartsvuechart-line-5']//*[name()='line' and @class='apexcharts-xaxis-tick']";
	private String gcTimeGraphTooltipTitle = "xpath = //div[@id='apexchartsvuechart-line-5']//div[@class='apexcharts-tooltip-title']";
	private String gcTimeGraphTooltipText = "xpath = //div[@id='apexchartsvuechart-line-5']//span[@class='apexcharts-tooltip-text-y-value']";

	private String gcCountGraphHeader = "xpath = //div[@id='apexchartsvuechart-line-6']/ancestor::div[@class='chart-body']/preceding-sibling::div[@class='line-header']/div[@class='line-title']";
	private String gcCountGraphYAxis = "xpath = //div[@id='apexchartsvuechart-line-6']//*[name()='g' and @class='apexcharts-yaxis-title']";
	private String gcCountGraphXAxis = "xpath = //div[@id='apexchartsvuechart-line-6']//*[name()='g' and @class='apexcharts-xaxis-title']";
	private String gcCountGraphZoomOutBtn = "#GC-count-zoom-out";
	private String gcCountGraphZoomInBtn = "#GC-count-zoom-in";
	private String gcCountGraphZoomResetBtn = "#GC-count-zoom-reset";
	private String gcCountGraphPointXpath = "xpath = //div[@id='apexchartsvuechart-line-6']//*[name()='line' and @class='apexcharts-xaxis-tick']";
	private String gcCountGraphTooltipTitle = "xpath = //div[@id='apexchartsvuechart-line-6']//div[@class='apexcharts-tooltip-title']";
	private String gcCountGraphTooltipText = "xpath = //div[@id='apexchartsvuechart-line-6']//span[@class='apexcharts-tooltip-text-y-value']";

	private String threadCountGraphHeader = "xpath = //div[@id='apexchartsvuechart-line-7']/ancestor::div[@class='chart-body']/preceding-sibling::div[@class='line-header']/div[@class='line-title']";
	private String threadCountGraphYAxis = "xpath = //div[@id='apexchartsvuechart-line-7']//*[name()='g' and @class='apexcharts-yaxis-title']";
	private String threadCountGraphXAxis = "xpath = //div[@id='apexchartsvuechart-line-7']//*[name()='g' and @class='apexcharts-xaxis-title']";
	private String threadCountGraphZoomOutBtn = "#Thread-count-zoom-out";
	private String threadCountGraphZoomInBtn = "#Thread-count-zoom-in";
	private String threadCountGraphZoomResetBtn = "#Thread-count-zoom-reset";
	private String threadCountGraphPointXpath = "xpath = //div[@id='apexchartsvuechart-line-7']//*[name()='line' and @class='apexcharts-xaxis-tick']";
	private String threadCountGraphTooltipTitle = "xpath = //div[@id='apexchartsvuechart-line-7']//div[@class='apexcharts-tooltip-title']";
	private String threadCountGraphTooltipText = "xpath = //div[@id='apexchartsvuechart-line-7']//span[@class='apexcharts-tooltip-text-y-value']";
	private String selectedTimeline = "xpath = //div[@class='selected-text ellipsis bg-text']";

	List<String> xPoints = new ArrayList<String>();
	{
		xPoints.add(loadGraphPointXpath);
		xPoints.add(errorGraphPointXpath);
		xPoints.add(responseTimeGraphPointXpath);
	}
	
	List<String> xaxisLabels = new ArrayList<String>();
	{
		xaxisLabels.add(loadGraphXaxisLabels);
		xaxisLabels.add(errorGraphXaxisLabels);
		xaxisLabels.add(responseTimeGraphXaxisLabels);
	}
	
	public ApmInstancePage(Page page) {
		this.page = page;
	}
	
	public void navigateToInstancePage() throws InterruptedException {
		common = new CommonPage(page);
		ElementHandle ele = page.querySelector(instanceTab);
		page.click(instanceTab);
		page.waitForURL("**/instance/*");
		Assert.assertTrue(ele.getAttribute("class").contains("activeTab"));
		Assert.assertTrue(page.isVisible(firstColumn));
	}
	
	public void validateFirstColNameOfInstancePageTable() throws EncryptedDocumentException, IOException {
		// Fetch the first column name from the excel sheet where the test data is stored
		String expectedData = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.instancePageSheet, "firstColumnName");
		// Fetch the first column name from the UI and validate with expected data
		Assert.assertTrue(page.textContent(firstColumn).trim().equalsIgnoreCase(expectedData));
	}
	
	public void validateSecondColNameOfInstancePageTable() throws EncryptedDocumentException, IOException {
		String expectedData = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.instancePageSheet, "secondColumnName");
		Assert.assertTrue(page.textContent(secondColumn).trim().equalsIgnoreCase(expectedData));
	}
	
	public void validateThirdColNameOfInstancePageTable() throws EncryptedDocumentException, IOException {
		String expectedData = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.instancePageSheet, "thirdColumnName");
		Assert.assertTrue(page.textContent(thirdColumn).trim().equalsIgnoreCase(expectedData));
	}
	
	public void validateFourthColNameOfInstancePageTable() throws EncryptedDocumentException, IOException {
		String expectedData = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.instancePageSheet, "fourthColumnName");
		Assert.assertTrue(page.textContent(fourthColumn).trim().equalsIgnoreCase(expectedData));
	}
	
	public void validateFifthColNameOfInstancePageTable() throws EncryptedDocumentException, IOException {
		String expectedData = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.instancePageSheet, "fifthColumnName");
		Assert.assertTrue(page.textContent(fifthColumn).trim().equalsIgnoreCase(expectedData));
	}
	
	public void validateSixthColNameOfInstancePageTable() throws EncryptedDocumentException, IOException {
		String expectedData = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.instancePageSheet, "sixthColumnName");
		Assert.assertTrue(page.textContent(sixthColumn).trim().equalsIgnoreCase(expectedData));
	}
	
	public void validateSeventhColNameOfInstancePageTable() throws EncryptedDocumentException, IOException {
		String expectedData = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.instancePageSheet, "seventhColumnName");
		Assert.assertTrue(page.textContent(seventhColumn).trim().equalsIgnoreCase(expectedData));
	}
	
	public void validateSearchInstanceFunctionalityWithValidData() {
		util.validateSearchFunctionalityWithValidData(page, firstInstanceName, searchInstancesTextField, searchBtn, searchResult);
	}
	
	public void validateSearchInstanceFunctionalityWithInvalidData() {
		util.validateSearchFunctionalityWithInvalidData(page, searchInstancesTextField, searchBtn, noDataIcon);
	}
	
	public void validateTheEditInstanceFunctionality() throws EncryptedDocumentException, IOException {
		// Pick the first instance name from the Instance page table
		String inst = page.textContent(firstInstanceName).trim();
		String message = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath, IPathConstant.messageSheet, "InstancePage_EditInstanceConfirmationMessage");
		//System.out.println("instance "+instance);
		// Edit the Instance name and validate
		page.click(firstInstanceEditBtn);
		Locator editTextField = page.locator(editInstanceNameTextField);
		editTextField.clear();
		editTextField.fill("Observability");
		page.click(updateBtn);
		Assert.assertTrue(page.textContent(editInstanceConfirmationMessage).contains(message));
		page.click(messgaeCloseBtn);
		page.waitForSelector(firstInstanceName);
		page.waitForTimeout(300);
		String changedText = page.textContent(firstInstanceName).trim();
		Assert.assertTrue(changedText.equals("Observability"));
		// Reset the Instance name and validate
		page.click(firstInstanceEditBtn);
		page.click(resetBtn);
		Assert.assertTrue(page.textContent(editInstanceConfirmationMessage).contains(message));
		page.click(messgaeCloseBtn);
		page.waitForTimeout(300);
		Assert.assertTrue(page.textContent(firstInstanceName).trim().equals(inst));		
	}
	
	public void sortErrorPercentageColInAscOrderAndValidate() {
		page.hover(errorPercentColumnHead);
		util.sortTheColumnInAscendingOrderAndValidateTheColumnData(page, errorsPercentAscBtn, errorPercentColData);
	}
	
	public void sortErrorPercentageColInDesOrderAndValidate() {
		page.hover(errorPercentColumnHead);
		util.sortTheColumnInDescendingOrderAndValidateTheColumnData(page, errorsPercentDesBtn, errorPercentColData);
	}
	
	public void sortErrorsColInAscOrderAndValidate() {
		page.hover(errorsColumnHead);
		util.sortTheColumnInAscendingOrderAndValidateTheColumnData(page, errorsAscBtn, errorsColData);
	}
	
	public void sortErrorsColInDesOrderAndValidate() {
		page.hover(errorsColumnHead);
		util.sortTheColumnInDescendingOrderAndValidateTheColumnData(page, errorsDesBtn, errorsColData);
	}
	
	public void sortErrorsPerMinColInAscOrderAndValidate() {
		page.hover(epmColumnHead);
		util.sortTheColumnInAscendingOrderAndValidateTheColumnData(page, epmAscBtn, epmColData);
	}
	
	public void sortErrorsPerMinColInDesOrderAndValidate() {
		page.hover(epmColumnHead);
		util.sortTheColumnInDescendingOrderAndValidateTheColumnData(page, epmDesBtn, epmColData);
	}
	
	public void sortResponseTimeColInAscOrderAndValidate() {
		page.hover(responseTimeColumnHead);
		util.sortTheColumnInAscendingOrderAndValidateTheColumnData(page, responseTimeAscBtn, responseTimeColData);
	}
	
	public void sortResponseTimeColInDesOrderAndValidate() {
		page.hover(responseTimeColumnHead);
		util.sortTheColumnInDescendingOrderAndValidateTheColumnData(page, responseTimeDesBtn, responseTimeColData);
	}
	
	public void sortCallsColInAscOrderAndValidate() {
		page.hover(callsColumnHead);
		util.sortTheColumnInAscendingOrderAndValidateTheColumnData(page, callsAscBtn, callsColData);
	}
	
	public void sortCallsColInDesOrderAndValidate() {
		page.hover(callsColumnHead);
		util.sortTheColumnInDescendingOrderAndValidateTheColumnData(page, callsDesBtn, callsColData);
	}
	
	public void sortCallsPerMinColInAscOrderAndValidate() {
		page.hover(cpmColumnHead);
		util.sortTheColumnInAscendingOrderAndValidateTheColumnData(page, cpmAscBtn, cpmColData);
	}
	
	public void sortCallsPerMinColInDesOrderAndValidate() {
		page.hover(cpmColumnHead);
		util.sortTheColumnInDescendingOrderAndValidateTheColumnData(page, cpmDesBtn, cpmColData);
	}
	
	public void navigateToInstanceGraphPageAndValidateTheInstanceName() {
		String instance = page.textContent(firstInstanceName).trim();
		page.click(firstInstanceName);
		page.waitForURL("**/instance-graph");
		assertTrue(page.textContent(instanceGraphHeader).trim().equals(instance));
		page.waitForSelector(loadGraphHeader);
	}
	
	public void clickOnBackButtonOfInstanceGraphPageAndValidate() {
		page.click(firstInstanceName);
		page.waitForURL("**/instance-graph");
		page.click(graphPageBackBtn);
		page.waitForSelector(firstColumn);
		Assert.assertTrue(page.isVisible(firstColumn));
	}
	
	public void validateTheLoadGraphTitleInInstanceGraphPage() throws EncryptedDocumentException, IOException {
		String expectedTitle = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.instancePageSheet, "loadGraphTitle");
		page.click(firstInstanceName);
		page.waitForURL("**/instance-graph");
		util.ValidateTheTitle(page, loadGraphHeader, expectedTitle);
	}
	
	public void validateTheLoadGraphXaxisTitleInInstanceGraphPage() throws EncryptedDocumentException, IOException {
		String expectedTitle = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.instancePageSheet, "xAxisTitle");
		page.click(firstInstanceName);
		page.waitForURL("**/instance-graph");
		util.ValidateTheTitle(page, loadGraphXAxis, expectedTitle);
	}
	
	public void validateTheLoadGraphYaxisTitleInInstanceGraphPage() throws EncryptedDocumentException, IOException {
		String expectedTitle = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.instancePageSheet, "loadGraphYaxisTitle");
		page.click(firstInstanceName);
		page.waitForURL("**/instance-graph");
		util.ValidateTheTitle(page, loadGraphYAxis, expectedTitle);
	}
	
	public void validateTheFunctionalityOfLoadGraphZoomInButton () {
		page.click(firstInstanceName);
		page.waitForURL("**/instance-graph");
		util.graphZoomIn(page, loadGraphZoomInBtn, loadGraphZoomResetBtn, xPoints);
	}
	
	public void validateTheFunctionalityOfLoadGraphZoomOutButton () {
		page.click(firstInstanceName);
		page.waitForURL("**/instance-graph");
		util.graphZoomOut(page, loadGraphZoomInBtn, loadGraphZoomOutBtn, loadGraphZoomResetBtn, xPoints);
	}
	
	public void validateTheFunctionalityOfLoadGraphZoomResetButton () {
		page.click(firstInstanceName);
		page.waitForURL("**/instance-graph");
		util.graphZoomReset(page, loadGraphZoomInBtn, loadGraphZoomResetBtn, xPoints);
	}
	
	public void validateZoomInByDragAndDropForLoadGraph() {
		page.click(firstInstanceName);
		page.waitForURL("**/instance-graph");
		util.graphZoomInByDragAndDrop(page, loadGraphPointXpath, loadGraphZoomResetBtn, xPoints);
	}
	
	public void validateTheErrorGraphTitleInInstanceGraphPage() throws EncryptedDocumentException, IOException {
		String expectedTitle = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.instancePageSheet, "errorGraphTitle");
		page.click(firstInstanceName);
		page.waitForURL("**/instance-graph");
		util.ValidateTheTitle(page, errorGraphHeader, expectedTitle);
	}
	
	public void validateTheErrorGraphXaxisTitleInInstanceGraphPage() throws EncryptedDocumentException, IOException {
		String expectedTitle = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.instancePageSheet, "xAxisTitle");
		page.click(firstInstanceName);
		page.waitForURL("**/instance-graph");
		util.ValidateTheTitle(page, errorGraphXAxis, expectedTitle);
	}
	
	public void validateTheErrorGraphYaxisTitleInInstanceGraphPage() throws EncryptedDocumentException, IOException {
		String expectedTitle = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.instancePageSheet, "errorGraphYaxisTitle");
		page.click(firstInstanceName);
		page.waitForURL("**/instance-graph");
		util.ValidateTheTitle(page, errorGraphYAxis, expectedTitle);
	}
	
	public void validateTheFunctionalityOfErrorGraphZoomInButton () {
		page.click(firstInstanceName);
		page.waitForURL("**/instance-graph");
		util.graphZoomIn(page, errorGraphZoomInBtn, errorGraphZoomResetBtn, xPoints);
	}
	
	public void validateTheFunctionalityOfErrorGraphZoomOutButton () {
		page.click(firstInstanceName);
		page.waitForURL("**/instance-graph");
		util.graphZoomOut(page, errorGraphZoomInBtn, errorGraphZoomOutBtn, errorGraphZoomResetBtn, xPoints);
	}
	
	public void validateTheFunctionalityOfErrorGraphZoomResetButton () {
		page.click(firstInstanceName);
		page.waitForURL("**/instance-graph");
		util.graphZoomReset(page, errorGraphZoomInBtn, errorGraphZoomResetBtn, xPoints);
	}
	
	public void validateZoomInByDragAndDropForErrorGraph() {
		page.click(firstInstanceName);
		page.waitForURL("**/instance-graph");
		util.graphZoomInByDragAndDrop(page, errorGraphPointXpath, errorGraphZoomResetBtn, xPoints);
	}
	
	public void validateTheResponseTimeGraphTitleInInstanceGraphPage() throws EncryptedDocumentException, IOException {
		String expectedTitle = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.instancePageSheet, "responseTimeGraphTitle");
		page.click(firstInstanceName);
		page.waitForURL("**/instance-graph");
		util.ValidateTheTitle(page, responseTimeGraphHeader, expectedTitle);
	}
	
	public void validateTheResponseTimeGraphXaxisTitleInInstanceGraphPage() throws EncryptedDocumentException, IOException {
		String expectedTitle = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.instancePageSheet, "xAxisTitle");
		page.click(firstInstanceName);
		page.waitForURL("**/instance-graph");
		util.ValidateTheTitle(page, responseTimeGraphXAxis, expectedTitle);
	}
	
	public void validateTheResponseTimeGraphYaxisTitleInInstanceGraphPage() throws EncryptedDocumentException, IOException {
		String expectedTitle = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.instancePageSheet, "responseTimeGraphYaxisTitle");
		page.click(firstInstanceName);
		page.waitForURL("**/instance-graph");
		util.ValidateTheTitle(page, responseTimeGraphYAxis, expectedTitle);
	}
	
	public void validateTheFunctionalityOfResponseTimeGraphZoomInButton () {
		page.click(firstInstanceName);
		page.waitForURL("**/instance-graph");
		util.graphZoomIn(page, responseTimeGraphZoomInBtn, responseTimeGraphZoomResetBtn, xPoints);
	}
	
	public void validateTheFunctionalityOfResponseTimeGraphZoomOutButton () {
		page.click(firstInstanceName);
		page.waitForURL("**/instance-graph");
		util.graphZoomOut(page, responseTimeGraphZoomInBtn, responseTimeGraphZoomOutBtn, responseTimeGraphZoomResetBtn, xPoints);
	}
	
	public void validateTheFunctionalityOfResponseTimeGraphZoomResetButton () {
		page.click(firstInstanceName);
		page.waitForURL("**/instance-graph");
		util.graphZoomReset(page, responseTimeGraphZoomInBtn, responseTimeGraphZoomResetBtn, xPoints);
	}
	
	public void validateZoomInByDragAndDropForResponseTimeGraph() {
		page.click(firstInstanceName);
		page.waitForURL("**/instance-graph");
		util.graphZoomInByDragAndDrop(page, responseTimeGraphPointXpath, responseTimeGraphZoomResetBtn, xPoints);
	}
	
	public void validateFirstErrorPercentageInInstanceGraphPage() {
		String errorPercentFromTable = page.textContent(firstInstanceErrorPercent).trim();
		page.click(firstInstanceName);
		page.waitForTimeout(1500);
		page.waitForSelector(errorGraphErrorPercentage).isVisible();
		String errorPercentFromGraph = page.textContent(errorGraphErrorPercentage).trim().replace("%", "");
		System.out.println("errorPercentFromTable : "+errorPercentFromTable+"\terrorPercentFromGraph : "+errorPercentFromGraph);
		Assert.assertTrue(errorPercentFromGraph.equals(errorPercentFromTable));
	}
	
	public void validateFirstErrorsInInstanceGraphPage() {
		String errorsFromTable = page.textContent(firstInstanceError).trim();
		page.click(firstInstanceName);
		page.waitForSelector(errorGraphErrorPercentage);
		String errorsFromGraph = page.textContent(errorGraphErrors).trim().replace(" errors", "");
		System.out.println("errorsFromTable : "+errorsFromTable+"\terrorsFromGraph : "+errorsFromGraph);
		Assert.assertTrue(errorsFromGraph.equals(errorsFromTable));
		int errorsFromGraphTooltip = util.getTheSummationFromTheWidgetTooltip(page, errorGraphPointXpath, errorGraphTooltipText);
		System.out.println("Errors from tooltip : "+String.valueOf(errorsFromGraphTooltip));
		Assert.assertTrue(String.valueOf(errorsFromGraphTooltip).equals(errorsFromTable));
	}
	
	public void validateFirstErrorPerMinInInstanceGraphPage() {
		String epmFromTable = page.textContent(firstInstanceEpm).trim();
		page.click(firstInstanceName);
		page.waitForSelector(errorGraphEpm);
		String epmFromGraph = page.textContent(errorGraphEpm).trim().replace(" errors/min", "");
		System.out.println("epmFromTable : "+epmFromTable+"\tepmFromGraph : "+epmFromGraph);
		Assert.assertTrue(epmFromGraph.equals(epmFromTable));
	}
	
	public void validateFirstCallsInInstanceGraphPage() {
		String callsFromTable = page.textContent(firstInstanceCall).trim();
		page.click(firstInstanceName);
		page.waitForSelector(errorGraphErrorPercentage);
		String callsFromGraph = page.textContent(loadGraphCalls).trim().replace(" calls", "");
		System.out.println("callsFromTable : "+callsFromTable+"\tcallsFromGraph : "+callsFromGraph);
		Assert.assertTrue(callsFromGraph.equals(callsFromTable));
		int callsFromGraphTooltip = util.getTheSummationFromTheWidgetTooltip(page, loadGraphPointXpath, loadGraphTooltipText);
		System.out.println("Calls from tooltip : "+String.valueOf(callsFromGraphTooltip));
		Assert.assertTrue(String.valueOf(callsFromGraphTooltip).equals(callsFromTable));
	}
	
	public void validateFirstCallsPerMinInInstanceGraphPage() {
		String cpmFromTable = page.textContent(firstInstanceCpm).trim();
		page.click(firstInstanceName);
		page.waitForSelector(loadGraphCpm);
		String cpmFromGraph = page.textContent(loadGraphCpm).trim().replace(" calls/min", "");
		System.out.println("cpmFromTable : "+cpmFromTable+"\tcpmFromGraph : "+cpmFromGraph);
		Assert.assertTrue(cpmFromGraph.equals(cpmFromTable));
	}
	
	public void validateFirstResponseTimeInInstanceGraphPage() {
		String respFromTable = page.textContent(firstInstanceResponseTime).trim();
		page.click(firstInstanceName);
		page.waitForSelector(errorGraphEpm);
		String respFromGraph = page.textContent(responseTimeGraphAvgResponseTime).trim().replace(" ms", "");
		System.out.println("respFromTable : "+respFromTable+"\trespFromGraph : "+respFromGraph);
		Assert.assertTrue(respFromGraph.equals(respFromTable));
		int avgRespTime = util.getAverageResponseTimeFromGraphTooltip(page, responseTimeGraphPointXpath, responseTimeGraphTooltipText, loadGraphTooltipText);
	    Assert.assertTrue(avgRespTime == Integer.parseInt(respFromTable));
	}
	
	public void ValidateTheXaxisLablesAccordingToTheSelectedTimeline() {
		page.click(firstInstanceName);
		page.waitForURL("**/instance-graph");
		util.validateTheGraphdisplayingTheDataAsPerGivenTimeLines(page, loadGraphXaxisLabels, selectedTimeline, xaxisLabels);
	}
	
//	public void selecCustomTimelineAndValidateTheXaxisLables() {
//		common.selectTheTimeLineFromCalender(IPathConstant.fiveMinutesTimeRange);
//		//common.selectTheCustomeTimeLine();
//		page.click(firstInstanceName);
//		page.waitForURL("**/instance-graph");
//	}
	
	public void validatePagination(int num) {
		common.selectPaginationAndValidate(page, num, searchResult);
	}
	
	public void validateTheInstancesNamesInInstancePage() throws EncryptedDocumentException, IOException {
		String data = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.apmDataValidationSheet, "instances");
		page.waitForSelector(searchResult);
		String[] instances = data.split(",");
		int count = 0;
		Locator tableData = page.locator(searchResult);
		for (String expectedString : instances) {
			for(int i=0; i<tableData.count(); i++)
			{
				if(tableData.nth(i).textContent().trim().equalsIgnoreCase(expectedString)) {
					count++;
					break;
				}
			}
		}
		Assert.assertTrue(count == 6);
	}
	
	public void validateTheNummberOfCallsOnInstancePage(int calls) {
		page.waitForSelector(callsOnTable);
		Locator callsOnInstance = page.locator(callsOnTable);
		int sum = 0;
		for(int i=0; i<callsOnInstance.count(); i++) {
			int call = Integer.parseInt(callsOnInstance.nth(i).textContent().trim());
			sum += call;
		}
		System.out.println("Sum = : "+sum+"\t calls : "+calls);
		Assert.assertTrue(sum == calls);
	}
	
	public void validateTheNummberOfErrorsOnInstancePage(int errors) {
		page.waitForSelector(errorsOnTable);
		Locator errorsOnInstance = page.locator(errorsOnTable);
		int sum = 0;
		for(int i=0; i<errorsOnInstance.count(); i++) {
			int error = Integer.parseInt(errorsOnInstance.nth(i).textContent().trim());
			sum += error;
		}
		System.out.println("Sum = : "+sum+"\t errors : "+errors);
		Assert.assertTrue(sum == errors);
	}
	
	public void validateTheCustomTimeLine(String period)
	{
		page.waitForSelector(loadGraphXaxisLabels);
		util.validateCustomTimeLine(page,loadGraphXaxisLabels,period,xaxisLabels);
	}

	public void validateWhetherTheTooltipIsDisplayingForLoadGraph() {
		page.click(firstInstanceName);
		page.waitForURL("**/instance-graph");
		util.validateWidgetToolTips(page, loadGraphPointXpath, loadGraphTooltipTitle);
	}
	
	public void validateWhetherTheTooltipIsDisplayingForErrorGraph() {
		page.click(firstInstanceName);
		page.waitForURL("**/instance-graph");
		util.validateWidgetToolTips(page, errorGraphPointXpath, errorGraphTooltipTitle);
	}
	
	public void validateWhetherTheTooltipIsDisplayingForResponseTimeGraph() {
		page.click(firstInstanceName);
		page.waitForURL("**/instance-graph");
		util.validateWidgetToolTips(page, responseTimeGraphPointXpath, responseTimeGraphTooltipTitle);
	}
}
