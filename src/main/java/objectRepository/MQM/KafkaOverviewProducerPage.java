package objectRepository.MQM;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;

import genericUtilities.ExcelUtility;
import genericUtilities.GenericMethods;
import java.util.ArrayList;
import java.util.List;

public class KafkaOverviewProducerPage 
{
	Page page;
	GenericMethods util = new GenericMethods();
	ExcelUtility excel = new ExcelUtility();
	
	private String selectMessageQueueDropdown = "#btn-arrow-down-mq-select-message-queue";
	private String selectSearchFieldMQDropdown = "#input-search-sel-mq-select-message-queue";
	private String selectMQDropdown = "#mq-select-message-queue-0-single";
	private String selectServiceNameDropdown = "#btn-arrow-down-mq-select-service-name";
	private String selectSearchFieldServiceNameDropdown = "#input-search-sel-mq-select-service-name";
	private String searchedApplication = "xpath = //span[@id='mq-select-service-name-0-single']";
	private String calenderView = "xpath = //div[@class='selected-text ellipsis bg-text']";
	private String overviewTab = "xpath = //div[@class='navtab']/div[@class='item' and position()=1]/child::div";
	private String producerTab = "xpath = //div[@class='overviewTabSelector']/child::div[@class][position()=2]";
		
//Request rate Graph 
	private String requestRateGraphTitle = "xpath = //div[@class='overviewTabSelector']/child::div[@class='kafkaTabItem kafkaActiveTab']/child::span[.='Producer']/ancestor::div[@class='overviewTabSelector']/following-sibling::div//div[.='Request rate ']";
	private String requestRateXaxis = "xpath = //div[.='Request rate ']/following-sibling::div/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-title-text chart-lables']";
	private String requestRateYaxis = "xpath = //div[.='Request rate ']/following-sibling::div/descendant::*[name()='text' and @class='apexcharts-text apexcharts-yaxis-title-text chart-lables']";
	private String requestRateXaxisLine = "xpath = //div[.='Request rate ']/following-sibling::div/descendant::*[name()='line' and @class='apexcharts-xaxis-tick']";
	private String requestRateXaxisValues = "xpath = //div[@id='apexchartschart-kafka_broker_bytes_in_per_sec']/descendant::*[name()='tspan' and contains(.,'-')]";
	private String requestRateZoomOut = "xpath = (//div[.='Request rate ']/descendant::span[@class='icon-class'])[position()=1]";
	private String requestRateZoomIn = "xpath = (//div[.='Request rate ']/descendant::span[@class='icon-class'])[position()=2]";
	private String requestRateLegendTitle1 = "xpath = (//div[.='Request rate ']/following-sibling::div/descendant::div[@class='header-heading'])[position()=1]";
	private String requestRateLegendTitle2 = "xpath = (//div[.='Request rate ']/following-sibling::div/descendant::div[@class='header-heading'])[position()=2]";
	private String requestRateLegendTitle3 = "xpath = (//div[.='Request rate ']/following-sibling::div/descendant::div[@class='header-heading'])[position()=3]";
	private String requestRateToolTipTitle = "xpath = //div[.='Request rate ']/following-sibling::div/descendant::div[@class='apexcharts-tooltip-title']";
	
//Response rate Graph 
	private String responseRateGraphTitle = "xpath = //div[@class='overviewTabSelector']/child::div[@class='kafkaTabItem kafkaActiveTab']/child::span[.='Producer']/ancestor::div[@class='overviewTabSelector']/following-sibling::div//div[.='Response rate ']";
	private String responseRateXaxis = "xpath = //div[.='Response rate ']/following-sibling::div/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-title-text chart-lables']";
	private String responseRateYaxis = "xpath = //div[.='Response rate ']/following-sibling::div/descendant::*[name()='text' and @class='apexcharts-text apexcharts-yaxis-title-text chart-lables']";
	private String responseRateXaxisLine = "xpath = //div[.='Response rate ']/following-sibling::div/descendant::*[name()='line' and @class='apexcharts-xaxis-tick']";
	private String responseRateXaxisValues = "xpath = //div[@id='apexchartschart-kafka_broker_bytes_out_per_sec']/descendant::*[name()='tspan' and contains(.,'-')]";
	private String responseRateZoomOut = "xpath = (//div[.='Response rate ']/descendant::span[@class='icon-class'])[position()=1]";
	private String responseRateZoomIn = "xpath = (//div[.='Response rate ']/descendant::span[@class='icon-class'])[position()=2]";
	private String responseRateLegendTitle1 = "xpath = (//div[.='Response rate ']/following-sibling::div/descendant::div[@class='header-heading'])[position()=1]";
	private String responseRateLegendTitle2 = "xpath = (//div[.='Response rate ']/following-sibling::div/descendant::div[@class='header-heading'])[position()=2]";
	private String responseRateLegendTitle3 = "xpath = (//div[.='Response rate ']/following-sibling::div/descendant::div[@class='header-heading'])[position()=3]";
	private String responseRateToolTipTitle = "xpath = //div[.='Response rate ']/following-sibling::div/descendant::div[@class='apexcharts-tooltip-title']";
	
//Error rate Graph 
	private String errorRateGraphTitle = "xpath = //div[@class='overviewTabSelector']/child::div[@class='kafkaTabItem kafkaActiveTab']/child::span[.='Producer']/ancestor::div[@class='overviewTabSelector']/following-sibling::div//div[.='Error rate ']";
	private String errorRateXaxis = "xpath = //div[.='Error rate ']/following-sibling::div/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-title-text chart-lables']";
	private String errorRateYaxis = "xpath = //div[.='Error rate ']/following-sibling::div/descendant::*[name()='text' and @class='apexcharts-text apexcharts-yaxis-title-text chart-lables']";
	private String errorRateXaxisLine = "xpath = //div[.='Error rate ']/following-sibling::div/descendant::*[name()='line' and @class='apexcharts-xaxis-tick']";
	private String errorRateXaxisValues = "xpath = //div[@id='apexchartschart-kafka_broker_total_produce_requests_per_sec']/descendant::*[name()='tspan' and contains(.,'-')]";
	private String errorRateZoomOut = "xpath = (//div[.='Error rate ']/descendant::span[@class='icon-class'])[position()=1]";
	private String errorRateZoomIn = "xpath = (//div[.='Error rate ']/descendant::span[@class='icon-class'])[position()=2]";
	private String errorRateLegendTitle1 = "xpath = (//div[.='Error rate ']/following-sibling::div/descendant::div[@class='header-heading'])[position()=1]";
	private String errorRateLegendTitle2 = "xpath = (//div[.='Error rate ']/following-sibling::div/descendant::div[@class='header-heading'])[position()=2]";
	private String errorRateLegendTitle3 = "xpath = (//div[.='Error rate ']/following-sibling::div/descendant::div[@class='header-heading'])[position()=3]";
	private String errorRateToolTipTitle = "xpath = //div[.='Error rate ']/following-sibling::div/descendant::div[@class='apexcharts-tooltip-title']";
	
//Request avg latency Graph 
	private String requestAvgLatencyGraphTitle = "xpath = //div[@class='overviewTabSelector']/child::div[@class='kafkaTabItem kafkaActiveTab']/child::span[.='Producer']/ancestor::div[@class='overviewTabSelector']/following-sibling::div//div[.='Request avg latency ']";
	private String requestAvgLatencyXaxis = "xpath = //div[.='Request avg latency ']/following-sibling::div/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-title-text chart-lables']";
	private String requestAvgLatencyYaxis = "xpath = //div[.='Request avg latency ']/following-sibling::div/descendant::*[name()='text' and @class='apexcharts-text apexcharts-yaxis-title-text chart-lables']";
	private String requestAvgLatencyXaxisLine = "xpath = //div[.='Request avg latency ']/following-sibling::div/descendant::*[name()='line' and @class='apexcharts-xaxis-tick']";
	private String requestAvgLatencyXaxisValues = "xpath = //div[@id='apexchartschart-kafka_broker_total_fetch_requests_per_sec']/descendant::*[name()='tspan' and contains(.,'-')]";
	private String requestAvgLatencyZoomOut = "xpath = (//div[.='Request avg latency ']/descendant::span[@class='icon-class'])[position()=1]";
	private String requestAvgLatencyZoomIn = "xpath = (//div[.='Request avg latency ']/descendant::span[@class='icon-class'])[position()=2]";
	private String requestAvgLatencyLegendTitle1 = "xpath = (//div[.='Request avg latency ']/following-sibling::div/descendant::div[@class='header-heading'])[position()=1]";
	private String requestAvgLatencyLegendTitle2 = "xpath = (//div[.='Request avg latency ']/following-sibling::div/descendant::div[@class='header-heading'])[position()=2]";
	private String requestAvgLatencyLegendTitle3 = "xpath = (//div[.='Request avg latency ']/following-sibling::div/descendant::div[@class='header-heading'])[position()=3]";
	private String requestAvgLatencyToolTipTitle = "xpath = //div[.='Request avg latency ']/following-sibling::div/descendant::div[@class='apexcharts-tooltip-title']";
	
//No. of producers Graph 
	private String noOfProducersGraphTitle = "xpath = (//div[@class='overviewTabSelector']/child::div[@class='kafkaTabItem kafkaActiveTab']/child::span[.='Producer']/ancestor::div[@class='overviewTabSelector']/following-sibling::div//div[.=' No. of producers'])[position()=1]";
	private String noOfProducersXaxis = "xpath = //div[.=' No. of producers']/following-sibling::div/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-title-text chart-lables']";
	private String noOfProducersYaxis = "xpath = //div[.=' No. of producers']/following-sibling::div/descendant::*[name()='text' and @class='apexcharts-text apexcharts-yaxis-title-text chart-lables']";
	private String noOfProducersXaxisLine = "xpath = //div[.=' No. of producers']/following-sibling::div/descendant::*[name()='line' and @class='apexcharts-xaxis-tick']";
	private String noOfProducersXaxisValues = "xpath = //div[@id='apexchartsvuechart-line-0']/descendant::*[name()='tspan' and contains(.,'-')]";
	private String noOfProducersZoomOut = "xpath = (//div[.=' No. of producers']/descendant::span[@class='icon-class'])[position()=1]";
	private String noOfProducersZoomIn = "xpath = (//div[.=' No. of producers']/descendant::span[@class='icon-class'])[position()=2]";
	private String noOfProducersZoomReset = "xpath = (//div[.=' No. of producers']/descendant::span[@class='icon-class'])[position()=3]";
	private String noOfProducersToolTipTitle = "xpath = //div[.=' No. of producers']/following-sibling::div/descendant::div[@class='apexcharts-tooltip-title']";
	
//Expand Button
	private String requestRateExpand = "xpath = (//div[.='Request rate ']/descendant::span[@class='icon-class'])[position()=3]";
	private String responseRateExpand = "xpath = (//div[.='Response rate ']/descendant::span[@class='icon-class'])[position()=3]";	
	private String errorRateExpand = "xpath = (//div[.='Error rate ']/descendant::span[@class='icon-class'])[position()=3]";	
	private String requestAvgLatencyExpand = "xpath = (//div[.='Request avg latency ']/descendant::span[@class='icon-class'])[position()=3]";	
	
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

	public KafkaOverviewProducerPage(Page page) {
		this.page = page;
	}

	public void navigateToKafka(String messageQueue) {
		util.selectTheOptionFromDropDownBySearch(page, selectMessageQueueDropdown, selectSearchFieldMQDropdown, messageQueue, selectMQDropdown);
		page.waitForLoadState(LoadState.NETWORKIDLE);
	}

	public void selectServiceName(String application) {
		 util.selectTheOptionFromDropDownBySearch(page, selectServiceNameDropdown, selectSearchFieldServiceNameDropdown, application, searchedApplication); 
		 page.waitForLoadState(LoadState.NETWORKIDLE); 
	}
	 
	public void navigateToOverviewTab() {
		page.locator(overviewTab).click();
		page.waitForLoadState(LoadState.NETWORKIDLE);
	}

	public void validateOverviewTitle(String expectedTitle) {
		String actualTitle = page.locator(overviewTab).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
		page.waitForLoadState(LoadState.NETWORKIDLE);
	}
	
/*
 * Producer Tab
 */

	public void validateProducerTabTitle(String expectedTitle) {
		String actualTitle = page.locator(producerTab).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}
	
	public void clickOnProducerTab() {
			page.locator(producerTab).click();
			page.waitForLoadState(LoadState.NETWORKIDLE);
	}
	
/*
 * Request Rate Graph
 */

	public void validateRequestRateGraphTitle(String expectedTitle) {		  
		String actualTitle = page.locator(requestRateGraphTitle).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateRequestRateZoomInBtn() {		  
		util.graphZoomIn(page, requestRateZoomIn, requestRateXaxisValues);
	}

	public void validateRequestRateZoomOutBtn() {
		util.graphZoomOut(page, requestRateZoomIn, requestRateZoomOut, requestRateXaxisValues);
	}

	public void validateRequestRateGraphXaxisTitle(String expectedTitle) {	 
		String actualTitle = page.locator(requestRateXaxis).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateRequestRateGraphYaxisTitle(String expectedTitle) {	 
		String actualTitle = page.locator(requestRateYaxis).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateRequestRateGraphLegendTitle1(String expectedTitle) {
		String actualTitle = page.locator(requestRateLegendTitle1).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateRequestRateGraphLegendTitle2(String expectedTitle) {	 
		String actualTitle = page.locator(requestRateLegendTitle2).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateRequestRateGraphLegendTitle3(String expectedTitle) {	 
		String actualTitle = page.locator(requestRateLegendTitle3).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateRequestRateToolTipTitle() {	 
		util.validateWidgetToolTips(page, requestRateXaxisLine, requestRateToolTipTitle);
	}

	public void validateRequestRateDragAndDrop() {
		util.graphZoomInByDragAndDrop(page, requestRateXaxisLine, requestRateZoomOut, requestRateXaxisValues);
	}
	public void validateRequestRateExpandViewXAxisTitle() { 
		util.validateExpandViewTexts(page, requestRateXaxis, requestRateExpand, expandViewCloseBtn, expandViewXaxisTitle);
	}

	public void validateRequestRateExpandViewYAxisTitle() {
		util.validateExpandViewTexts(page, requestRateYaxis, requestRateExpand, expandViewCloseBtn, expandViewYaxisTitle);
	}

	public void validateRequestRateExpandViewWidgetTitle() {
		util.validateExpandViewTexts(page, requestRateGraphTitle, requestRateExpand, expandViewCloseBtn, expandViewWidgetTitle);
	}

	public void validateRequestRateExpandViewLegendHeader1() {	 
		util.validateExpandViewTexts(page, requestRateLegendTitle1, requestRateExpand, expandViewCloseBtn, expandViewLegendColumn1HeaderTitle);
	}

	public void validateRequestRateExpandViewLegendHeader2() {	 
		util.validateExpandViewTexts(page, requestRateLegendTitle2 ,requestRateExpand, expandViewCloseBtn, expandViewLegendColumn2HeaderTitle);
	}

	public void validateRequestRateExpandViewLegendHeader3() {	 
		util.validateExpandViewTexts(page, requestRateLegendTitle3 ,requestRateExpand, expandViewCloseBtn, expandViewLegendColumn3HeaderTitle);
	}

	public void validateRequestRateExpandViewZoomIn() {
		util.ExpandViewZoomInBtn(page, expandViewZoomInBtn, requestRateExpand, expandViewCloseBtn, expandViewXaxisValues);
	}

	public void validateRequestRateExpandViewZoomOut() {
		util.ExpandViewZoomOutBtn(page, expandViewZoomInBtn, requestRateExpand, expandViewCloseBtn, expandViewZoomOutBtn, expandViewXaxisValues);
	}

	public void validateRequestRateExpandViewWidgetDragDrop() {
		util.ExpandViewWidgetDragDrop(page, requestRateExpand, expandViewCloseBtn, expandViewXaxisLines, expandViewZoomOutBtn, expandViewXaxisValues);
	}
	
/*
 * Response Rate Graph
 */

	public void validateResponseRateGraphTitle(String expectedTitle) {		  
		String actualTitle = page.locator(responseRateGraphTitle).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateResponseRateZoomInBtn() {		  
		util.graphZoomIn(page, responseRateZoomIn, responseRateXaxisValues);
	}

	public void validateResponseRateZoomOutBtn() {
		util.graphZoomOut(page, responseRateZoomIn, responseRateZoomOut, responseRateXaxisValues);
	}

	public void validateResponseRateGraphXaxisTitle(String expectedTitle) {	 
		String actualTitle = page.locator(responseRateXaxis).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateResponseRateGraphYaxisTitle(String expectedTitle) {	 
		String actualTitle = page.locator(responseRateYaxis).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateResponseRateGraphLegendTitle1(String expectedTitle) {
		String actualTitle = page.locator(responseRateLegendTitle1).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateResponseRateGraphLegendTitle2(String expectedTitle) {	 
		String actualTitle = page.locator(responseRateLegendTitle2).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateResponseRateGraphLegendTitle3(String expectedTitle) {	 
		String actualTitle = page.locator(responseRateLegendTitle3).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateResponseRateToolTipTitle() {	 
		util.validateWidgetToolTips(page, responseRateXaxisLine, responseRateToolTipTitle);
	}

	public void validateResponseRateDragAndDrop() {
		util.graphZoomInByDragAndDrop(page, responseRateXaxisLine, responseRateZoomOut, responseRateXaxisValues);
	}
	public void validateResponseRateExpandViewXAxisTitle() { 
		util.validateExpandViewTexts(page, responseRateXaxis, responseRateExpand, expandViewCloseBtn, expandViewXaxisTitle);
	}

	public void validateResponseRateExpandViewYAxisTitle() {
		util.validateExpandViewTexts(page, responseRateYaxis, responseRateExpand, expandViewCloseBtn, expandViewYaxisTitle);
	}

	public void validateResponseRateExpandViewWidgetTitle() {
		util.validateExpandViewTexts(page, responseRateGraphTitle, responseRateExpand, expandViewCloseBtn, expandViewWidgetTitle);
	}

	public void validateResponseRateExpandViewLegendHeader1() {	 
		util.validateExpandViewTexts(page, responseRateLegendTitle1, responseRateExpand, expandViewCloseBtn, expandViewLegendColumn1HeaderTitle);
	}

	public void validateResponseRateExpandViewLegendHeader2() {	 
		util.validateExpandViewTexts(page, responseRateLegendTitle2 ,responseRateExpand, expandViewCloseBtn, expandViewLegendColumn2HeaderTitle);
	}

	public void validateResponseRateExpandViewLegendHeader3() {	 
		util.validateExpandViewTexts(page, responseRateLegendTitle3 ,responseRateExpand, expandViewCloseBtn, expandViewLegendColumn3HeaderTitle);
	}

	public void validateResponseRateExpandViewZoomIn() {
		util.ExpandViewZoomInBtn(page, expandViewZoomInBtn, responseRateExpand, expandViewCloseBtn, expandViewXaxisValues);
	}

	public void validateResponseRateExpandViewZoomOut() {
		util.ExpandViewZoomOutBtn(page, expandViewZoomInBtn, responseRateExpand, expandViewCloseBtn, expandViewZoomOutBtn, expandViewXaxisValues);
	}

	public void validateResponseRateExpandViewWidgetDragDrop() {
		util.ExpandViewWidgetDragDrop(page, responseRateExpand, expandViewCloseBtn, expandViewXaxisLines, expandViewZoomOutBtn, expandViewXaxisValues);
	}
	
/*
 * Error Rate Graph
 */

	public void validateErrorRateGraphTitle(String expectedTitle) {		  
		String actualTitle = page.locator(errorRateGraphTitle).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateErrorRateZoomInBtn() {		  
		util.graphZoomIn(page, errorRateZoomIn, errorRateXaxisValues);
	}

	public void validateErrorRateZoomOutBtn() {
		util.graphZoomOut(page, errorRateZoomIn, errorRateZoomOut, errorRateXaxisValues);
	}

	public void validateErrorRateGraphXaxisTitle(String expectedTitle) {	 
		String actualTitle = page.locator(errorRateXaxis).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateErrorRateGraphYaxisTitle(String expectedTitle) {	 
		String actualTitle = page.locator(errorRateYaxis).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateErrorRateGraphLegendTitle1(String expectedTitle) {
		String actualTitle = page.locator(errorRateLegendTitle1).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateErrorRateGraphLegendTitle2(String expectedTitle) {	 
		String actualTitle = page.locator(errorRateLegendTitle2).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateErrorRateGraphLegendTitle3(String expectedTitle) {	 
		String actualTitle = page.locator(errorRateLegendTitle3).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateErrorRateToolTipTitle() {	 
		util.validateWidgetToolTips(page, errorRateXaxisLine, errorRateToolTipTitle);
	}

	public void validateErrorRateDragAndDrop() {
		util.graphZoomInByDragAndDrop(page, errorRateXaxisLine, errorRateZoomOut, errorRateXaxisValues);
	}
	public void validateErrorRateExpandViewXAxisTitle() { 
		util.validateExpandViewTexts(page, errorRateXaxis, errorRateExpand, expandViewCloseBtn, expandViewXaxisTitle);
	}

	public void validateErrorRateExpandViewYAxisTitle() {
		util.validateExpandViewTexts(page, errorRateYaxis, errorRateExpand, expandViewCloseBtn, expandViewYaxisTitle);
	}

	public void validateErrorRateExpandViewWidgetTitle() {
		util.validateExpandViewTexts(page, errorRateGraphTitle, errorRateExpand, expandViewCloseBtn, expandViewWidgetTitle);
	}

	public void validateErrorRateExpandViewLegendHeader1() {	 
		util.validateExpandViewTexts(page, errorRateLegendTitle1, errorRateExpand, expandViewCloseBtn, expandViewLegendColumn1HeaderTitle);
	}

	public void validateErrorRateExpandViewLegendHeader2() {	 
		util.validateExpandViewTexts(page, errorRateLegendTitle2 ,errorRateExpand, expandViewCloseBtn, expandViewLegendColumn2HeaderTitle);
	}

	public void validateErrorRateExpandViewLegendHeader3() {	 
		util.validateExpandViewTexts(page, errorRateLegendTitle3 ,errorRateExpand, expandViewCloseBtn, expandViewLegendColumn3HeaderTitle);
	}

	public void validateErrorRateExpandViewZoomIn() {
		util.ExpandViewZoomInBtn(page, expandViewZoomInBtn, errorRateExpand, expandViewCloseBtn, expandViewXaxisValues);
	}

	public void validateErrorRateExpandViewZoomOut() {
		util.ExpandViewZoomOutBtn(page, expandViewZoomInBtn, errorRateExpand, expandViewCloseBtn, expandViewZoomOutBtn, expandViewXaxisValues);
	}

	public void validateErrorRateExpandViewWidgetDragDrop() {
		util.ExpandViewWidgetDragDrop(page, errorRateExpand, expandViewCloseBtn, expandViewXaxisLines, expandViewZoomOutBtn, expandViewXaxisValues);
	}
	
/*
 * Request avg latency Graph
 */

	public void validateRequestAvgLatencyGraphTitle(String expectedTitle) {		  
		String actualTitle = page.locator(requestAvgLatencyGraphTitle).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateRequestAvgLatencyZoomInBtn() {		  
		util.graphZoomIn(page, requestAvgLatencyZoomIn, requestAvgLatencyXaxisValues);
	}

	public void validateRequestAvgLatencyZoomOutBtn() {
		util.graphZoomOut(page, requestAvgLatencyZoomIn, requestAvgLatencyZoomOut, requestAvgLatencyXaxisValues);
	}

	public void validateRequestAvgLatencyGraphXaxisTitle(String expectedTitle) {	 
		String actualTitle = page.locator(requestAvgLatencyXaxis).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateRequestAvgLatencyGraphYaxisTitle(String expectedTitle) {	 
		String actualTitle = page.locator(requestAvgLatencyYaxis).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateRequestAvgLatencyGraphLegendTitle1(String expectedTitle) {
		String actualTitle = page.locator(requestAvgLatencyLegendTitle1).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateRequestAvgLatencyGraphLegendTitle2(String expectedTitle) {	 
		String actualTitle = page.locator(requestAvgLatencyLegendTitle2).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateRequestAvgLatencyGraphLegendTitle3(String expectedTitle) {	 
		String actualTitle = page.locator(requestAvgLatencyLegendTitle3).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateRequestAvgLatencyToolTipTitle() {	 
		util.validateWidgetToolTips(page, requestAvgLatencyXaxisLine, requestAvgLatencyToolTipTitle);
	}

	public void validateRequestAvgLatencyDragAndDrop() {
		util.graphZoomInByDragAndDrop(page, requestAvgLatencyXaxisLine, requestAvgLatencyZoomOut, requestAvgLatencyXaxisValues);
	}
	public void validateRequestAvgLatencyExpandViewXAxisTitle() { 
		util.validateExpandViewTexts(page, requestAvgLatencyXaxis, requestAvgLatencyExpand, expandViewCloseBtn, expandViewXaxisTitle);
	}

	public void validateRequestAvgLatencyExpandViewYAxisTitle() {
		util.validateExpandViewTexts(page, requestAvgLatencyYaxis, requestAvgLatencyExpand, expandViewCloseBtn, expandViewYaxisTitle);
	}

	public void validateRequestAvgLatencyExpandViewWidgetTitle() {
		util.validateExpandViewTexts(page, requestAvgLatencyGraphTitle, requestAvgLatencyExpand, expandViewCloseBtn, expandViewWidgetTitle);
	}

	public void validateRequestAvgLatencyExpandViewLegendHeader1() {	 
		util.validateExpandViewTexts(page, requestAvgLatencyLegendTitle1, requestAvgLatencyExpand, expandViewCloseBtn, expandViewLegendColumn1HeaderTitle);
	}

	public void validateRequestAvgLatencyExpandViewLegendHeader2() {	 
		util.validateExpandViewTexts(page, requestAvgLatencyLegendTitle2 ,requestAvgLatencyExpand, expandViewCloseBtn, expandViewLegendColumn2HeaderTitle);
	}

	public void validateRequestAvgLatencyExpandViewLegendHeader3() {	 
		util.validateExpandViewTexts(page, requestAvgLatencyLegendTitle3 ,requestAvgLatencyExpand, expandViewCloseBtn, expandViewLegendColumn3HeaderTitle);
	}

	public void validateRequestAvgLatencyExpandViewZoomIn() {
		util.ExpandViewZoomInBtn(page, expandViewZoomInBtn, requestAvgLatencyExpand, expandViewCloseBtn, expandViewXaxisValues);
	}

	public void validateRequestAvgLatencyExpandViewZoomOut() {
		util.ExpandViewZoomOutBtn(page, expandViewZoomInBtn, requestAvgLatencyExpand, expandViewCloseBtn, expandViewZoomOutBtn, expandViewXaxisValues);
	}

	public void validateRequestAvgLatencyExpandViewWidgetDragDrop() {
		util.ExpandViewWidgetDragDrop(page, requestAvgLatencyExpand, expandViewCloseBtn, expandViewXaxisLines, expandViewZoomOutBtn, expandViewXaxisValues);
	}
	
/*
 * No. of producers Graph
 */

	public void validateNoOfProducersGraphTitle(String expectedTitle) {		  
		String actualTitle = page.locator(noOfProducersGraphTitle).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateNoOfProducersZoomInBtn( ){
		util.graphZoomIn(page, noOfProducersZoomIn, noOfProducersZoomReset, allWidgetXValues());
	}
	
	public void validateNoOfProducersZoomOutBtn( ){
		util.graphZoomOut(page, noOfProducersZoomIn, noOfProducersZoomOut, noOfProducersZoomReset, allWidgetXValues());
	}
	
	public void validateNoOfProducersZoomResetBtn( ){
		util.graphZoomReset(page, noOfProducersZoomIn, noOfProducersZoomReset, allWidgetXValues());
	}

	public void validateNoOfProducersGraphXaxisTitle(String expectedTitle) {	 
		String actualTitle = page.locator(noOfProducersXaxis).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateNoOfProducersGraphYaxisTitle(String expectedTitle) {	 
		String actualTitle = page.locator(noOfProducersYaxis).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateNoOfProducersToolTipTitle() {	 
		util.validateWidgetToolTips(page, noOfProducersXaxisLine, noOfProducersToolTipTitle);
	}

	public void validateNoOfProducersDragAndDrop() {
		util.graphZoomInByDragAndDrop(page, noOfProducersXaxisLine, noOfProducersZoomOut, noOfProducersXaxisValues);
	}
	
/*
 * Calendar
 */
		
	public void validateTheCustomTimeLine(String period) {
		util.validateCustomTimeLine(page, requestRateXaxisValues, period, WidgetXValues(period));
	}
		
	public void validateXaxisValuesForKafkaOverviewProducerPage() {
		util.validateTheGraphdisplayingTheDataAsPerGivenTimeLines(page, requestRateXaxisValues, calenderView, allWidgetXValues());
	}
	
	public List<String> allWidgetXValues() {
		ArrayList<String> xValue = new ArrayList<String>();
		xValue.add(requestRateXaxisValues);
		xValue.add(responseRateXaxisValues);
		xValue.add(errorRateXaxisValues);
		xValue.add(requestAvgLatencyXaxisValues);
		xValue.add(noOfProducersXaxisValues);
		return xValue;
	}
}
