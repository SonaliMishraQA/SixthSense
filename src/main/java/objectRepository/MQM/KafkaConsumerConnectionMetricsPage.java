package objectRepository.MQM;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import genericUtilities.ExcelUtility;
import genericUtilities.GenericMethods;

import java.util.ArrayList;
import java.util.List;

import com.microsoft.playwright.options.LoadState;

public class KafkaConsumerConnectionMetricsPage
{
	Page page;
	GenericMethods util = new GenericMethods();
	ExcelUtility excel = new ExcelUtility();

	private String selectMessageQueueDropdown = "#btn-arrow-down-mq-select-message-queue";
	private String selectSearchFieldMQDropdown = "#input-search-sel-mq-select-message-queue";
	private String selectMQDropdown = "#mq-select-message-queue-0-single";
	private String SelectServiceNameDropdown = "#btn-arrow-down-mq-select-service-name";
	private String SelectSearchFieldServiceNameDropdown = "#input-search-sel-mq-select-service-name";
	private String SearchedApplication = "xpath = //span[@id='mq-select-service-name-0-single']";
	private String calenderView = "xpath = //div[@class='selected-text ellipsis bg-text']";
	private String consumerTab = "xpath = //div[@class='navtab']/div[@class='item' and position()=3]/child::div";
	private String connectionMetricsTab = "xpath = //div[@class='consumerTabSelector']/child::div[@class][position()=3]";
	private String consumerTitle = "xpath = //div[@class='kafkaConsumerDropdown']/descendant::div[@class='heading']";
	private String selectNameDropDown = "#btn-arrow-down-kafka-select-consumer";
	private String activeTickMark = "xpath = //input[@id='input-search-sel-kafka-select-consumer']/parent::div/following-sibling::div/child::div[@class='option']/span/span";
	private String nameSearchResults = "xpath = //input[@id='input-search-sel-kafka-select-consumer']/parent::div/following-sibling::div/child::div[@class='option'][1]";
	
		
//Connection creation rate Graph 
	private String connectionCreationRateGraphTitle = "xpath = //div[@class='consumerTabSelector']/child::div[@class='kafkaTabItem kafkaActiveTab']/child::span[.='Connection metrics']/ancestor::div[@class='kafkaConsumerActions']/following-sibling::div//div[.='Connection creation rate ']";
	private String connectionCreationRateXaxis = "xpath = //div[.='Connection creation rate ']/following-sibling::div/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-title-text chart-lables']";
	private String connectionCreationRateYaxis = "xpath = //div[.='Connection creation rate ']/following-sibling::div/descendant::*[name()='text' and @class='apexcharts-text apexcharts-yaxis-title-text chart-lables']";
	private String connectionCreationRateXaxisLine = "xpath = //div[.='Connection creation rate ']/following-sibling::div/descendant::*[name()='line' and @class='apexcharts-xaxis-tick']";
	private String connectionCreationRateXaxisValues = "xpath = //div[@id='apexchartschart-kafka_consumer_records_lag']/descendant::*[name()='tspan' and contains(.,'-')]";
	private String connectionCreationRateZoomOut = "xpath = (//div[.='Connection creation rate ']/descendant::span[@class='icon-class'])[position()=1]";
	private String connectionCreationRateZoomIn = "xpath = (//div[.='Connection creation rate ']/descendant::span[@class='icon-class'])[position()=2]";
	private String connectionCreationRateLegendTitle1 = "xpath = (//div[.='Connection creation rate ']/following-sibling::div/descendant::div[@class='header-heading'])[position()=1]";
	private String connectionCreationRateLegendTitle2 = "xpath = (//div[.='Connection creation rate ']/following-sibling::div/descendant::div[@class='header-heading'])[position()=2]";
	private String connectionCreationRateLegendTitle3 = "xpath = (//div[.='Connection creation rate ']/following-sibling::div/descendant::div[@class='header-heading'])[position()=3]";
	private String connectionCreationRateToolTipTitle = "xpath = //div[.='Connection creation rate ']/following-sibling::div/descendant::div[@class='apexcharts-tooltip-title']";
	
//Connection close rate Graph 
	private String connectionCloseRateGraphTitle = "xpath = //div[@class='consumerTabSelector']/child::div[@class='kafkaTabItem kafkaActiveTab']/child::span[.='Connection metrics']/ancestor::div[@class='kafkaConsumerActions']/following-sibling::div//div[.='Connection close rate ']";
	private String connectionCloseRateXaxis = "xpath = //div[.='Connection close rate ']/following-sibling::div/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-title-text chart-lables']";
	private String connectionCloseRateYaxis = "xpath = //div[.='Connection close rate ']/following-sibling::div/descendant::*[name()='text' and @class='apexcharts-text apexcharts-yaxis-title-text chart-lables']";
	private String connectionCloseRateXaxisLine = "xpath = //div[.='Connection close rate ']/following-sibling::div/descendant::*[name()='line' and @class='apexcharts-xaxis-tick']";
	private String connectionCloseRateXaxisValues = "xpath = //div[@id='apexchartschart-kafka_consumer_records_lead']/descendant::*[name()='tspan' and contains(.,'-')]";
	private String connectionCloseRateZoomOut = "xpath = (//div[.='Connection close rate ']/descendant::span[@class='icon-class'])[position()=1]";
	private String connectionCloseRateZoomIn = "xpath = (//div[.='Connection close rate ']/descendant::span[@class='icon-class'])[position()=2]";
	private String connectionCloseRateLegendTitle1 = "xpath = (//div[.='Connection close rate ']/following-sibling::div/descendant::div[@class='header-heading'])[position()=1]";
	private String connectionCloseRateLegendTitle2 = "xpath = (//div[.='Connection close rate ']/following-sibling::div/descendant::div[@class='header-heading'])[position()=2]";
	private String connectionCloseRateLegendTitle3 = "xpath = (//div[.='Connection close rate ']/following-sibling::div/descendant::div[@class='header-heading'])[position()=3]";
	private String connectionCloseRateToolTipTitle = "xpath = //div[.='Connection close rate ']/following-sibling::div/descendant::div[@class='apexcharts-tooltip-title']";
	
//I/O Wait Ratio Graph 
	private String iOWaitRatioGraphTitle = "xpath = //div[@class='consumerTabSelector']/child::div[@class='kafkaTabItem kafkaActiveTab']/child::span[.='Connection metrics']/ancestor::div[@class='kafkaConsumerActions']/following-sibling::div//div[.='I/O wait ratio ']";
	private String iOWaitRatioXaxis = "xpath = //div[.='I/O wait ratio ']/following-sibling::div/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-title-text chart-lables']";
	private String iOWaitRatioYaxis = "xpath = //div[.='I/O wait ratio ']/following-sibling::div/descendant::*[name()='text' and @class='apexcharts-text apexcharts-yaxis-title-text chart-lables']";
	private String iOWaitRatioXaxisLine = "xpath = //div[.='I/O wait ratio ']/following-sibling::div/descendant::*[name()='line' and @class='apexcharts-xaxis-tick']";
	private String iOWaitRatioXaxisValues = "xpath = //div[@id='apexchartschart-kafka_consumer_io_wait_ratio']/descendant::*[name()='tspan' and contains(.,'-')]";
	private String iOWaitRatioZoomOut = "xpath = (//div[.='I/O wait ratio ']/descendant::span[@class='icon-class'])[position()=1]";
	private String iOWaitRatioZoomIn = "xpath = (//div[.='I/O wait ratio ']/descendant::span[@class='icon-class'])[position()=2]";
	private String iOWaitRatioLegendTitle1 = "xpath = (//div[.='I/O wait ratio ']/following-sibling::div/descendant::div[@class='header-heading'])[position()=1]";
	private String iOWaitRatioLegendTitle2 = "xpath = (//div[.='I/O wait ratio ']/following-sibling::div/descendant::div[@class='header-heading'])[position()=2]";
	private String iOWaitRatioLegendTitle3 = "xpath = (//div[.='I/O wait ratio ']/following-sibling::div/descendant::div[@class='header-heading'])[position()=3]";
	private String iOWaitRatioToolTipTitle = "xpath = //div[.='I/O wait ratio ']/following-sibling::div/descendant::div[@class='apexcharts-tooltip-title']";
	
//I/O wait time average Graph 
	private String iOWaitTimeAverageGraphTitle = "xpath = //div[@class='consumerTabSelector']/child::div[@class='kafkaTabItem kafkaActiveTab']/child::span[.='Connection metrics']/ancestor::div[@class='kafkaConsumerActions']/following-sibling::div//div[.='I/O wait time average ']";
	private String iOWaitTimeAverageXaxis = "xpath = //div[.='I/O wait time average ']/following-sibling::div/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-title-text chart-lables']";
	private String iOWaitTimeAverageYaxis = "xpath = //div[.='I/O wait time average ']/following-sibling::div/descendant::*[name()='text' and @class='apexcharts-text apexcharts-yaxis-title-text chart-lables']";
	private String iOWaitTimeAverageXaxisLine = "xpath = //div[.='I/O wait time average ']/following-sibling::div/descendant::*[name()='line' and @class='apexcharts-xaxis-tick']";
	private String iOWaitTimeAverageXaxisValues = "xpath = //div[@id='apexchartschart-kafka_consumer_io_wait_time_ns_avg']/descendant::*[name()='tspan' and contains(.,'-')]";
	private String iOWaitTimeAverageZoomOut = "xpath = (//div[.='I/O wait time average ']/descendant::span[@class='icon-class'])[position()=1]";
	private String iOWaitTimeAverageZoomIn = "xpath = (//div[.='I/O wait time average ']/descendant::span[@class='icon-class'])[position()=2]";
	private String iOWaitTimeAverageLegendTitle1 = "xpath = (//div[.='I/O wait time average ']/following-sibling::div/descendant::div[@class='header-heading'])[position()=1]";
	private String iOWaitTimeAverageLegendTitle2 = "xpath = (//div[.='I/O wait time average ']/following-sibling::div/descendant::div[@class='header-heading'])[position()=2]";
	private String iOWaitTimeAverageLegendTitle3 = "xpath = (//div[.='I/O wait time average ']/following-sibling::div/descendant::div[@class='header-heading'])[position()=3]";
	private String iOWaitTimeAverageToolTipTitle = "xpath = //div[.='I/O wait time average ']/following-sibling::div/descendant::div[@class='apexcharts-tooltip-title']";
		
//Expand Button
	private String connectionCreationRateExpand = "xpath = (//div[.='Connection creation rate ']/descendant::span[@class='icon-class'])[position()=3]";
	private String connectionCloseRateExpand = "xpath = (//div[.='Connection close rate ']/descendant::span[@class='icon-class'])[position()=3]";	
	private String iOWaitRatioExpand = "xpath = (//div[.='I/O wait ratio ']/descendant::span[@class='icon-class'])[position()=3]";	
	private String iOWaitTimeAverageExpand = "xpath = (//div[.='I/O wait time average ']/descendant::span[@class='icon-class'])[position()=3]";	

//Expand View
	private String expandViewWidgetTitle = "xpath = //div[@class='ant-modal-content']//descendant::div[@class='card crd']/child::div[@class='card-header']";
	private String expandViewZoomOutBtn = "xpath =(//div[@class='ant-modal-content']//descendant::div[@class='card crd']/child::div[@class='card-header']/descendant::span[@class='icon-class'])[position()=1]";
	private String expandViewZoomInBtn = "xpath =(//div[@class='ant-modal-content']//descendant::div[@class='card crd']/child::div[@class='card-header']/descendant::span[@class='icon-class'])[position()=2]";
	private String expandViewCloseBtn = "xpath = //div[@class='ant-modal-content']/child::div[@class='ant-modal-footer']/child::button[contains(.,'Close')]";
	private String expandViewXaxisTitle = "xpath = //div[@class='ant-modal-content']//descendant::div[@class='card crd']/child::div[@class='card-body']//descendant::*[name()='g' and @class='apexcharts-xaxis-title']";
	private String expandViewYaxisTitle = "xpath = //div[@class='ant-modal-content']//descendant::div[@class='card crd']/child::div[@class='card-body']//descendant::*[name()='g' and @class='apexcharts-yaxis-title']";
	private String expandViewXaxisLines = "xpath = //div[@class='ant-modal-content']//descendant::div[@class='card crd']/child::div[@class='card-body']/descendant::*[name()='line' and @class='apexcharts-xaxis-tick']";
	private String expandViewXaxisValues = "xpath = //div[@class='ant-modal-content']//descendant::div[@class='card crd']/child::div[@class='card-body']/descendant::*[name()='text' and contains(.,'-')]";
	private String expandViewLegendColumn1HeaderTitle = "xpath =(//div[@class='ant-modal-content']//descendant::div[@class='card crd']/descendant::div[@class='legend']/descendant::div[@class='header-heading'])[position()=1]";
	private String expandViewLegendColumn2HeaderTitle = "xpath =(//div[@class='ant-modal-content']//descendant::div[@class='card crd']/descendant::div[@class='legend']/descendant::div[@class='header-heading'])[position()=2]";
	private String expandViewLegendColumn3HeaderTitle = "xpath =(//div[@class='ant-modal-content']//descendant::div[@class='card crd']/descendant::div[@class='legend']/descendant::div[@class='header-heading'])[position()=3]";
	
	
	public List<String> WidgetXValues(String XValue) {
		ArrayList<String> xValue = new ArrayList<String>();
		xValue.add(XValue);
		return xValue;
	}
	
	private List<String> listOfNames() {
		page.locator(selectNameDropDown).click();
		ArrayList<String> values = new ArrayList<String>();
		Locator options = page.locator(nameSearchResults);
		for (int i = 0; i < options.count(); i++) {

			String option = options.nth(i).textContent();
			System.out.println(option);
			values.add(option);
		}
		page.locator(selectNameDropDown).click();
		return values;
	}

	public KafkaConsumerConnectionMetricsPage(Page page) {
		this.page = page;
	}

	public void navigateToKafka(String messageQueue) {
		util.selectTheOptionFromDropDownBySearch(page, selectMessageQueueDropdown, selectSearchFieldMQDropdown, messageQueue, selectMQDropdown);
		page.waitForLoadState(LoadState.NETWORKIDLE);
	}

	public void selectServiceName(String application) {
		 util.selectTheOptionFromDropDownBySearch(page, SelectServiceNameDropdown, SelectSearchFieldServiceNameDropdown, application, SearchedApplication); 
		 page.waitForLoadState(LoadState.NETWORKIDLE); 
	}
	 
	public void navigateToConsumerTab() {
		page.locator(consumerTab).click();
		page.waitForLoadState(LoadState.NETWORKIDLE);
	}

	public void clickOnConnectionMetricsTab() {
		page.locator(connectionMetricsTab).click();
		page.waitForLoadState(LoadState.NETWORKIDLE);
	}
	
	public void validateConsumerTitle(String expectedTitle) {
		String actualTitle = page.locator(consumerTab).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
		page.waitForLoadState(LoadState.NETWORKIDLE);
	}
	
	public void validateConsumerSelectTitle(String expectedTitle) {
		String actualTitle = page.locator(consumerTitle).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}
	
	public void validateConsumerSelectDropDown() {
		util.SelectTheMulitpleOptionFromDropDown(page, selectNameDropDown, activeTickMark, listOfNames()); 
		page.waitForLoadState(LoadState.NETWORKIDLE); 
	}
	
/*
 * Connection Metrics Tab
 */

	public void validateConnectionMetricsTabTitle(String expectedTitle) {
		String actualTitle = page.locator(connectionMetricsTab).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}
	
/*
 * Connection Creation Rate Graph
 */

	public void validateConnectionCreationRateGraphTitle(String expectedTitle) {		  
		String actualTitle = page.locator(connectionCreationRateGraphTitle).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateConnectionCreationRateZoomInBtn() {		  
		util.graphZoomIn(page, connectionCreationRateZoomIn, connectionCreationRateXaxisValues);
	}

	public void validateConnectionCreationRateZoomOutBtn() {
		util.graphZoomOut(page, connectionCreationRateZoomIn, connectionCreationRateZoomOut, connectionCreationRateXaxisValues);
	}

	public void validateConnectionCreationRateGraphXaxisTitle(String expectedTitle) {	 
		String actualTitle = page.locator(connectionCreationRateXaxis).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateConnectionCreationRateGraphYaxisTitle(String expectedTitle) {	 
		String actualTitle = page.locator(connectionCreationRateYaxis).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateConnectionCreationRateGraphLegendTitle1(String expectedTitle) {
		String actualTitle = page.locator(connectionCreationRateLegendTitle1).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateConnectionCreationRateGraphLegendTitle2(String expectedTitle) {	 
		String actualTitle = page.locator(connectionCreationRateLegendTitle2).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateConnectionCreationRateGraphLegendTitle3(String expectedTitle) {	 
		String actualTitle = page.locator(connectionCreationRateLegendTitle3).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateConnectionCreationRateToolTipTitle() {	 
		util.validateWidgetToolTips(page, connectionCreationRateXaxisLine, connectionCreationRateToolTipTitle);
	}

	public void validateConnectionCreationRateDragAndDrop() {
		util.graphZoomInByDragAndDrop(page, connectionCreationRateXaxisLine, connectionCreationRateZoomOut, connectionCreationRateXaxisValues);
	}
	public void validateConnectionCreationRateExpandViewXAxisTitle() { 
		util.validateExpandViewTexts(page, connectionCreationRateXaxis, connectionCreationRateExpand, expandViewCloseBtn, expandViewXaxisTitle);
	}

	public void validateConnectionCreationRateExpandViewYAxisTitle() {
		util.validateExpandViewTexts(page, connectionCreationRateYaxis, connectionCreationRateExpand, expandViewCloseBtn, expandViewYaxisTitle);
	}

	public void validateConnectionCreationRateExpandViewWidgetTitle() {
		util.validateExpandViewTexts(page, connectionCreationRateGraphTitle, connectionCreationRateExpand, expandViewCloseBtn, expandViewWidgetTitle);
	}

	public void validateConnectionCreationRateExpandViewLegendHeader1() {	 
		util.validateExpandViewTexts(page, connectionCreationRateLegendTitle1, connectionCreationRateExpand, expandViewCloseBtn, expandViewLegendColumn1HeaderTitle);
	}

	public void validateConnectionCreationRateExpandViewLegendHeader2() {	 
		util.validateExpandViewTexts(page, connectionCreationRateLegendTitle2 ,connectionCreationRateExpand, expandViewCloseBtn, expandViewLegendColumn2HeaderTitle);
	}

	public void validateConnectionCreationRateExpandViewLegendHeader3() {	 
		util.validateExpandViewTexts(page, connectionCreationRateLegendTitle3 ,connectionCreationRateExpand, expandViewCloseBtn, expandViewLegendColumn3HeaderTitle);
	}

	public void validateConnectionCreationRateExpandViewZoomIn() {
		util.ExpandViewZoomInBtn(page, expandViewZoomInBtn, connectionCreationRateExpand, expandViewCloseBtn, expandViewXaxisValues);
	}

	public void validateConnectionCreationRateExpandViewZoomOut() {
		util.ExpandViewZoomOutBtn(page, expandViewZoomInBtn, connectionCreationRateExpand, expandViewCloseBtn, expandViewZoomOutBtn, expandViewXaxisValues);
	}

	public void validateConnectionCreationRateExpandViewWidgetDragDrop() {
		util.ExpandViewWidgetDragDrop(page, connectionCreationRateExpand, expandViewCloseBtn, expandViewXaxisLines, expandViewZoomOutBtn, expandViewXaxisValues);
	}
	
/*
 * Connection Close Rate Graph
 */

	public void validateConnectionCloseRateGraphTitle(String expectedTitle) {		  
		String actualTitle = page.locator(connectionCloseRateGraphTitle).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateConnectionCloseRateZoomInBtn() {		  
		util.graphZoomIn(page, connectionCloseRateZoomIn, connectionCloseRateXaxisValues);
	}

	public void validateConnectionCloseRateZoomOutBtn() {
		util.graphZoomOut(page, connectionCloseRateZoomIn, connectionCloseRateZoomOut, connectionCloseRateXaxisValues);
	}

	public void validateConnectionCloseRateGraphXaxisTitle(String expectedTitle) {	 
		String actualTitle = page.locator(connectionCloseRateXaxis).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateConnectionCloseRateGraphYaxisTitle(String expectedTitle) {	 
		String actualTitle = page.locator(connectionCloseRateYaxis).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateConnectionCloseRateGraphLegendTitle1(String expectedTitle) {
		String actualTitle = page.locator(connectionCloseRateLegendTitle1).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateConnectionCloseRateGraphLegendTitle2(String expectedTitle) {	 
		String actualTitle = page.locator(connectionCloseRateLegendTitle2).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateConnectionCloseRateGraphLegendTitle3(String expectedTitle) {	 
		String actualTitle = page.locator(connectionCloseRateLegendTitle3).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateConnectionCloseRateToolTipTitle() {	 
		util.validateWidgetToolTips(page, connectionCloseRateXaxisLine, connectionCloseRateToolTipTitle);
	}

	public void validateConnectionCloseRateDragAndDrop() {
		util.graphZoomInByDragAndDrop(page, connectionCloseRateXaxisLine, connectionCloseRateZoomOut, connectionCloseRateXaxisValues);
	}
	public void validateConnectionCloseRateExpandViewXAxisTitle() { 
		util.validateExpandViewTexts(page, connectionCloseRateXaxis, connectionCloseRateExpand, expandViewCloseBtn, expandViewXaxisTitle);
	}

	public void validateConnectionCloseRateExpandViewYAxisTitle() {
		util.validateExpandViewTexts(page, connectionCloseRateYaxis, connectionCloseRateExpand, expandViewCloseBtn, expandViewYaxisTitle);
	}

	public void validateConnectionCloseRateExpandViewWidgetTitle() {
		util.validateExpandViewTexts(page, connectionCloseRateGraphTitle, connectionCloseRateExpand, expandViewCloseBtn, expandViewWidgetTitle);
	}

	public void validateConnectionCloseRateExpandViewLegendHeader1() {	 
		util.validateExpandViewTexts(page, connectionCloseRateLegendTitle1, connectionCloseRateExpand, expandViewCloseBtn, expandViewLegendColumn1HeaderTitle);
	}

	public void validateConnectionCloseRateExpandViewLegendHeader2() {	 
		util.validateExpandViewTexts(page, connectionCloseRateLegendTitle2 ,connectionCloseRateExpand, expandViewCloseBtn, expandViewLegendColumn2HeaderTitle);
	}

	public void validateConnectionCloseRateExpandViewLegendHeader3() {	 
		util.validateExpandViewTexts(page, connectionCloseRateLegendTitle3 ,connectionCloseRateExpand, expandViewCloseBtn, expandViewLegendColumn3HeaderTitle);
	}

	public void validateConnectionCloseRateExpandViewZoomIn() {
		util.ExpandViewZoomInBtn(page, expandViewZoomInBtn, connectionCloseRateExpand, expandViewCloseBtn, expandViewXaxisValues);
	}

	public void validateConnectionCloseRateExpandViewZoomOut() {
		util.ExpandViewZoomOutBtn(page, expandViewZoomInBtn, connectionCloseRateExpand, expandViewCloseBtn, expandViewZoomOutBtn, expandViewXaxisValues);
	}

	public void validateConnectionCloseRateExpandViewWidgetDragDrop() {
		util.ExpandViewWidgetDragDrop(page, connectionCloseRateExpand, expandViewCloseBtn, expandViewXaxisLines, expandViewZoomOutBtn, expandViewXaxisValues);
	}
	
/*
 * I/O wait ratio Graph
 */

	public void validateiOWaitRatioGraphTitle(String expectedTitle) {		  
		String actualTitle = page.locator(iOWaitRatioGraphTitle).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateiOWaitRatioZoomInBtn() {		  
		util.graphZoomIn(page, iOWaitRatioZoomIn, iOWaitRatioXaxisValues);
	}

	public void validateiOWaitRatioZoomOutBtn() {
		util.graphZoomOut(page, iOWaitRatioZoomIn, iOWaitRatioZoomOut, iOWaitRatioXaxisValues);
	}

	public void validateiOWaitRatioGraphXaxisTitle(String expectedTitle) {	 
		String actualTitle = page.locator(iOWaitRatioXaxis).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateiOWaitRatioGraphYaxisTitle(String expectedTitle) {	 
		String actualTitle = page.locator(iOWaitRatioYaxis).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateiOWaitRatioGraphLegendTitle1(String expectedTitle) {
		String actualTitle = page.locator(iOWaitRatioLegendTitle1).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateiOWaitRatioGraphLegendTitle2(String expectedTitle) {	 
		String actualTitle = page.locator(iOWaitRatioLegendTitle2).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateiOWaitRatioGraphLegendTitle3(String expectedTitle) {	 
		String actualTitle = page.locator(iOWaitRatioLegendTitle3).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateiOWaitRatioToolTipTitle() {	 
		util.validateWidgetToolTips(page, iOWaitRatioXaxisLine, iOWaitRatioToolTipTitle);
	}

	public void validateiOWaitRatioDragAndDrop() {
		util.graphZoomInByDragAndDrop(page, iOWaitRatioXaxisLine, iOWaitRatioZoomOut, iOWaitRatioXaxisValues);
	}
	public void validateiOWaitRatioExpandViewXAxisTitle() { 
		util.validateExpandViewTexts(page, iOWaitRatioXaxis, iOWaitRatioExpand, expandViewCloseBtn, expandViewXaxisTitle);
	}

	public void validateiOWaitRatioExpandViewYAxisTitle() {
		util.validateExpandViewTexts(page, iOWaitRatioYaxis, iOWaitRatioExpand, expandViewCloseBtn, expandViewYaxisTitle);
	}

	public void validateiOWaitRatioExpandViewWidgetTitle() {
		util.validateExpandViewTexts(page, iOWaitRatioGraphTitle, iOWaitRatioExpand, expandViewCloseBtn, expandViewWidgetTitle);
	}

	public void validateiOWaitRatioExpandViewLegendHeader1() {	 
		util.validateExpandViewTexts(page, iOWaitRatioLegendTitle1, iOWaitRatioExpand, expandViewCloseBtn, expandViewLegendColumn1HeaderTitle);
	}

	public void validateiOWaitRatioExpandViewLegendHeader2() {	 
		util.validateExpandViewTexts(page, iOWaitRatioLegendTitle2 ,iOWaitRatioExpand, expandViewCloseBtn, expandViewLegendColumn2HeaderTitle);
	}

	public void validateiOWaitRatioExpandViewLegendHeader3() {	 
		util.validateExpandViewTexts(page, iOWaitRatioLegendTitle3 ,iOWaitRatioExpand, expandViewCloseBtn, expandViewLegendColumn3HeaderTitle);
	}

	public void validateiOWaitRatioExpandViewZoomIn() {
		util.ExpandViewZoomInBtn(page, expandViewZoomInBtn, iOWaitRatioExpand, expandViewCloseBtn, expandViewXaxisValues);
	}

	public void validateiOWaitRatioExpandViewZoomOut() {
		util.ExpandViewZoomOutBtn(page, expandViewZoomInBtn, iOWaitRatioExpand, expandViewCloseBtn, expandViewZoomOutBtn, expandViewXaxisValues);
	}

	public void validateiOWaitRatioExpandViewWidgetDragDrop() {
		util.ExpandViewWidgetDragDrop(page, iOWaitRatioExpand, expandViewCloseBtn, expandViewXaxisLines, expandViewZoomOutBtn, expandViewXaxisValues);
	}
	
/*
 * I/O wait time average Graph
 */

	public void validateiOWaitTimeAverageGraphTitle(String expectedTitle) {		  
		String actualTitle = page.locator(iOWaitTimeAverageGraphTitle).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateiOWaitTimeAverageZoomInBtn() {		  
		util.graphZoomIn(page, iOWaitTimeAverageZoomIn, iOWaitTimeAverageXaxisValues);
	}

	public void validateiOWaitTimeAverageZoomOutBtn() {
		util.graphZoomOut(page, iOWaitTimeAverageZoomIn, iOWaitTimeAverageZoomOut, iOWaitTimeAverageXaxisValues);
	}

	public void validateiOWaitTimeAverageGraphXaxisTitle(String expectedTitle) {	 
		String actualTitle = page.locator(iOWaitTimeAverageXaxis).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateiOWaitTimeAverageGraphYaxisTitle(String expectedTitle) {	 
		String actualTitle = page.locator(iOWaitTimeAverageYaxis).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateiOWaitTimeAverageGraphLegendTitle1(String expectedTitle) {
		String actualTitle = page.locator(iOWaitTimeAverageLegendTitle1).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateiOWaitTimeAverageGraphLegendTitle2(String expectedTitle) {	 
		String actualTitle = page.locator(iOWaitTimeAverageLegendTitle2).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateiOWaitTimeAverageGraphLegendTitle3(String expectedTitle) {	 
		String actualTitle = page.locator(iOWaitTimeAverageLegendTitle3).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateiOWaitTimeAverageToolTipTitle() {	 
		util.validateWidgetToolTips(page, iOWaitTimeAverageXaxisLine, iOWaitTimeAverageToolTipTitle);
	}

	public void validateiOWaitTimeAverageDragAndDrop() {
		util.graphZoomInByDragAndDrop(page, iOWaitTimeAverageXaxisLine, iOWaitTimeAverageZoomOut, iOWaitTimeAverageXaxisValues);
	}
	public void validateiOWaitTimeAverageExpandViewXAxisTitle() { 
		util.validateExpandViewTexts(page, iOWaitTimeAverageXaxis, iOWaitTimeAverageExpand, expandViewCloseBtn, expandViewXaxisTitle);
	}

	public void validateiOWaitTimeAverageExpandViewYAxisTitle() {
		util.validateExpandViewTexts(page, iOWaitTimeAverageYaxis, iOWaitTimeAverageExpand, expandViewCloseBtn, expandViewYaxisTitle);
	}

	public void validateiOWaitTimeAverageExpandViewWidgetTitle() {
		util.validateExpandViewTexts(page, iOWaitTimeAverageGraphTitle, iOWaitTimeAverageExpand, expandViewCloseBtn, expandViewWidgetTitle);
	}

	public void validateiOWaitTimeAverageExpandViewLegendHeader1() {	 
		util.validateExpandViewTexts(page, iOWaitTimeAverageLegendTitle1, iOWaitTimeAverageExpand, expandViewCloseBtn, expandViewLegendColumn1HeaderTitle);
	}

	public void validateiOWaitTimeAverageExpandViewLegendHeader2() {	 
		util.validateExpandViewTexts(page, iOWaitTimeAverageLegendTitle2 ,iOWaitTimeAverageExpand, expandViewCloseBtn, expandViewLegendColumn2HeaderTitle);
	}

	public void validateiOWaitTimeAverageExpandViewLegendHeader3() {	 
		util.validateExpandViewTexts(page, iOWaitTimeAverageLegendTitle3 ,iOWaitTimeAverageExpand, expandViewCloseBtn, expandViewLegendColumn3HeaderTitle);
	}

	public void validateiOWaitTimeAverageExpandViewZoomIn() {
		util.ExpandViewZoomInBtn(page, expandViewZoomInBtn, iOWaitTimeAverageExpand, expandViewCloseBtn, expandViewXaxisValues);
	}

	public void validateiOWaitTimeAverageExpandViewZoomOut() {
		util.ExpandViewZoomOutBtn(page, expandViewZoomInBtn, iOWaitTimeAverageExpand, expandViewCloseBtn, expandViewZoomOutBtn, expandViewXaxisValues);
	}

	public void validateiOWaitTimeAverageExpandViewWidgetDragDrop() {
		util.ExpandViewWidgetDragDrop(page, iOWaitTimeAverageExpand, expandViewCloseBtn, expandViewXaxisLines, expandViewZoomOutBtn, expandViewXaxisValues);
	}
	
/*
 * Calendar
 */
		
	public void validateTheCustomTimeLine(String period) {
		util.validateCustomTimeLine(page, connectionCreationRateXaxisValues, period, WidgetXValues(period));
	}
		
	public void validateXaxisValuesForKafkaConsumerConnectionMetricsPage() {
		util.validateTheGraphdisplayingTheDataAsPerGivenTimeLines(page, connectionCreationRateXaxisValues, calenderView, allWidgetXValues());
	}
	
	public List<String> allWidgetXValues() {
		ArrayList<String> xValue = new ArrayList<String>();
		xValue.add(connectionCreationRateXaxisValues);
		xValue.add(connectionCloseRateXaxisValues);
		xValue.add(iOWaitRatioXaxisValues);
		xValue.add(iOWaitTimeAverageXaxisValues);
		return xValue;
	}
}
