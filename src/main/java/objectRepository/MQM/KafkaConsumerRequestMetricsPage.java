package objectRepository.MQM;

import java.util.ArrayList;
import java.util.List;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;

import genericUtilities.ExcelUtility;
import genericUtilities.GenericMethods;

public class KafkaConsumerRequestMetricsPage 
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
	private String consumerTab = "xpath = //div[@class='navtab']/div[@class='item' and position()=3]/child::div";
	private String requestMetricsTab = "xpath = //div[@class='consumerTabSelector']/child::div[@class][position()=2]";
	private String consumerTitle = "xpath = //div[@class='kafkaConsumerDropdown']/descendant::div[@class='heading']";
	private String selectNameDropDown = "#btn-arrow-down-kafka-select-consumer";
	private String activeTickMark = "xpath = //input[@id='input-search-sel-kafka-select-consumer']/parent::div/following-sibling::div/child::div[@class='option']/span/span";
	private String nameSearchResults = "xpath = //input[@id='input-search-sel-kafka-select-consumer']/parent::div/following-sibling::div/child::div[@class='option'][1]";
	
	
//Incoming Bytes Graph
	private String incomingBytesGraphTitle = "xpath = //div[@class='consumerTabSelector']/child::div[@class='kafkaTabItem kafkaActiveTab']/child::span[.='Request metrics']/ancestor::div[@class='kafkaConsumerActions']/following-sibling::div//div[.='Incoming bytes ']";
	private String incomingBytesXaxis = "xpath = //div[.='Incoming bytes ']/following-sibling::div/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-title-text chart-lables']";
	private String incomingBytesYaxis = "xpath = //div[.='Incoming bytes ']/following-sibling::div/descendant::*[name()='text' and @class='apexcharts-text apexcharts-yaxis-title-text chart-lables']";
	private String incomingBytesXaxisLine = "xpath = //div[.='Incoming bytes ']/following-sibling::div/descendant::*[name()='line' and @class='apexcharts-xaxis-tick']";
	private String incomingBytesXaxisValues = "xpath =//div[@id='apexchartschart-kafka_consumer_records_lag']/descendant::*[name()='tspan' and contains(.,'-')]";
	private String incomingBytesZoomOut = "xpath = (//div[.='Incoming bytes ']/descendant::span[@class='icon-class'])[position()=1]";
	private String incomingBytesZoomIn = "xpath = (//div[.='Incoming bytes ']/descendant::span[@class='icon-class'])[position()=2]";
	private String incomingBytesLegendTitle1 = "xpath = (//div[.='Incoming bytes ']/following-sibling::div/descendant::div[@class='header-heading'])[position()=1]";
	private String incomingBytesLegendTitle2 = "xpath = (//div[.='Incoming bytes ']/following-sibling::div/descendant::div[@class='header-heading'])[position()=2]";
	private String incomingBytesLegendTitle3 = "xpath = (//div[.='Incoming bytes ']/following-sibling::div/descendant::div[@class='header-heading'])[position()=3]";
	private String incomingBytesToolTipTitle = "xpath = //div[.='Incoming bytes ']/following-sibling::div/descendant::div[@class='apexcharts-tooltip-title']";
		
//Outgoing Bytes Graph
	private String outgoingBytesGraphTitle = "xpath = //div[@class='consumerTabSelector']/child::div[@class='kafkaTabItem kafkaActiveTab']/child::span[.='Request metrics']/ancestor::div[@class='kafkaConsumerActions']/following-sibling::div//div[.='Outgoing bytes ']";
	private String outgoingBytesXaxis = "xpath = //div[.='Outgoing bytes ']/following-sibling::div/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-title-text chart-lables']";
	private String outgoingBytesYaxis = "xpath = //div[.='Outgoing bytes ']/following-sibling::div/descendant::*[name()='text' and @class='apexcharts-text apexcharts-yaxis-title-text chart-lables']";
	private String outgoingBytesXaxisLine = "xpath = //div[.='Outgoing bytes ']/following-sibling::div/descendant::*[name()='line' and @class='apexcharts-xaxis-tick']";
	private String outgoingBytesXaxisValues = "xpath =//div[@id='apexchartschart-kafka_consumer_records_lead']/descendant::*[name()='tspan' and contains(.,'-')]";
	private String outgoingBytesZoomOut = "xpath = (//div[.='Outgoing bytes ']/descendant::span[@class='icon-class'])[position()=1]";
	private String outgoingBytesZoomIn = "xpath = (//div[.='Outgoing bytes ']/descendant::span[@class='icon-class'])[position()=2]";
	private String outgoingBytesLegendTitle1 = "xpath = (//div[.='Outgoing bytes ']/following-sibling::div/descendant::div[@class='header-heading'])[position()=1]";
	private String outgoingBytesLegendTitle2 = "xpath = (//div[.='Outgoing bytes ']/following-sibling::div/descendant::div[@class='header-heading'])[position()=2]";
	private String outgoingBytesLegendTitle3 = "xpath = (//div[.='Outgoing bytes ']/following-sibling::div/descendant::div[@class='header-heading'])[position()=3]";
	private String outgoingBytesToolTipTitle = "xpath = //div[.='Outgoing bytes ']/following-sibling::div/descendant::div[@class='apexcharts-tooltip-title']";

//Average Fetch Latency Graph
	private String averageFetchLatencyGraphTitle = "xpath = //div[@class='consumerTabSelector']/child::div[@class='kafkaTabItem kafkaActiveTab']/child::span[.='Request metrics']/ancestor::div[@class='kafkaConsumerActions']/following-sibling::div//div[.='Average fetch latency ']";
	private String averageFetchLatencyXaxis = "xpath = //div[.='Average fetch latency ']/following-sibling::div/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-title-text chart-lables']";
	private String averageFetchLatencyYaxis = "xpath = //div[.='Average fetch latency ']/following-sibling::div/descendant::*[name()='text' and @class='apexcharts-text apexcharts-yaxis-title-text chart-lables']";
	private String averageFetchLatencyXaxisLine = "xpath = //div[.='Average fetch latency ']/following-sibling::div/descendant::*[name()='line' and @class='apexcharts-xaxis-tick']";
	private String averageFetchLatencyXaxisValues = "xpath =//div[@id='apexchartschart-kafka_consumer_fetch_latency_avg']/descendant::*[name()='tspan' and contains(.,'-')]";
	private String averageFetchLatencyZoomOut = "xpath = (//div[.='Average fetch latency ']/descendant::span[@class='icon-class'])[position()=1]";
	private String averageFetchLatencyZoomIn = "xpath = (//div[.='Average fetch latency ']/descendant::span[@class='icon-class'])[position()=2]";
	private String averageFetchLatencyLegendTitle1 = "xpath = (//div[.='Average fetch latency ']/following-sibling::div/descendant::div[@class='header-heading'])[position()=1]";
	private String averageFetchLatencyLegendTitle2 = "xpath = (//div[.='Average fetch latency ']/following-sibling::div/descendant::div[@class='header-heading'])[position()=2]";
	private String averageFetchLatencyLegendTitle3 = "xpath = (//div[.='Average fetch latency ']/following-sibling::div/descendant::div[@class='header-heading'])[position()=3]";
	private String averageFetchLatencyToolTipTitle = "xpath = //div[.='Average fetch latency ']/following-sibling::div/descendant::div[@class='apexcharts-tooltip-title']";

//Maximum Fetch Latency Graph
	private String maximumFetchLatencyGraphTitle = "xpath = //div[@class='consumerTabSelector']/child::div[@class='kafkaTabItem kafkaActiveTab']/child::span[.='Request metrics']/ancestor::div[@class='kafkaConsumerActions']/following-sibling::div//div[.='Maximum fetch latency ']";
	private String maximumFetchLatencyXaxis = "xpath = //div[.='Maximum fetch latency ']/following-sibling::div/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-title-text chart-lables']";
	private String maximumFetchLatencyYaxis = "xpath = //div[.='Maximum fetch latency ']/following-sibling::div/descendant::*[name()='text' and @class='apexcharts-text apexcharts-yaxis-title-text chart-lables']";
	private String maximumFetchLatencyXaxisLine = "xpath = //div[.='Maximum fetch latency ']/following-sibling::div/descendant::*[name()='line' and @class='apexcharts-xaxis-tick']";
	private String maximumFetchLatencyXaxisValues = "xpath =//div[@id='apexchartschart-kafka_consumer_fetch_latency_max']/descendant::*[name()='tspan' and contains(.,'-')]";
	private String maximumFetchLatencyZoomOut = "xpath = (//div[.='Maximum fetch latency ']/descendant::span[@class='icon-class'])[position()=1]";
	private String maximumFetchLatencyZoomIn = "xpath = (//div[.='Maximum fetch latency ']/descendant::span[@class='icon-class'])[position()=2]";
	private String maximumFetchLatencyLegendTitle1 = "xpath = (//div[.='Maximum fetch latency ']/following-sibling::div/descendant::div[@class='header-heading'])[position()=1]";
	private String maximumFetchLatencyLegendTitle2 = "xpath = (//div[.='Maximum fetch latency ']/following-sibling::div/descendant::div[@class='header-heading'])[position()=2]";
	private String maximumFetchLatencyLegendTitle3 = "xpath = (//div[.='Maximum fetch latency ']/following-sibling::div/descendant::div[@class='header-heading'])[position()=3]";
	private String maximumFetchLatencyToolTipTitle = "xpath = //div[.='Maximum fetch latency ']/following-sibling::div/descendant::div[@class='apexcharts-tooltip-title']";
	
	
//Expand Button
	private String incomingBytesExpand = "xpath = (//div[.='Incoming bytes ']/descendant::span[@class='icon-class'])[position()=3]";
	private String outgoingBytesExpand = "xpath = (//div[.='Outgoing bytes ']/descendant::span[@class='icon-class'])[position()=3]";	
	private String averageFetchLatencyExpand = "xpath = (//div[.='Average fetch latency ']/descendant::span[@class='icon-class'])[position()=3]";	
	private String maximumFetchLatencyExpand = "xpath = (//div[.='Maximum fetch latency ']/descendant::span[@class='icon-class'])[position()=3]";	

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
	
	public KafkaConsumerRequestMetricsPage(Page page) {
		this.page = page;
	}

	public void navigateToKafka(String messageQueue) {
		util.selectTheOptionFromDropDownBySearch(page, selectMessageQueueDropdown, selectSearchFieldMQDropdown, messageQueue, selectMQDropdown);
		page.waitForLoadState(LoadState.NETWORKIDLE);
	}

	public void selectServiceName(String application) {
		 util.selectTheOptionFromDropDownBySearch(page, selectServiceNameDropdown, selectSearchFieldServiceNameDropdown, application, searchedApplication); 
		 page.waitForLoadState(LoadState.NETWORKIDLE); }
	 

	public void navigateToConsumerTab() {
		page.locator(consumerTab).click();
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
 * Request Metrics Tab
 */

	public void validateRequestMetricsTabTitle(String expectedTitle) {
		String actualTitle = page.locator(requestMetricsTab).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void clickOnRequestMetricsTab() {
			page.locator(requestMetricsTab).click();
			page.waitForLoadState(LoadState.NETWORKIDLE);
	}
	
/*
 * Incoming Bytes Graph
 */

	public void validateIncomingBytesGraphTitle(String expectedTitle) {		  
		String actualTitle = page.locator(incomingBytesGraphTitle).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateIncomingBytesZoomInBtn() {		  
		util.graphZoomIn(page, incomingBytesZoomIn, incomingBytesXaxisValues);
	}

	public void validateIncomingBytesZoomOutBtn() {
		util.graphZoomOut(page, incomingBytesZoomIn, incomingBytesZoomOut, incomingBytesXaxisValues);
	}

	public void validateIncomingBytesGraphXaxisTitle(String expectedTitle) {	 
		String actualTitle = page.locator(incomingBytesXaxis).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateIncomingBytesGraphYaxisTitle(String expectedTitle) {	 
		String actualTitle = page.locator(incomingBytesYaxis).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateIncomingBytesGraphLegendTitle1(String expectedTitle) {
		String actualTitle = page.locator(incomingBytesLegendTitle1).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateIncomingBytesGraphLegendTitle2(String expectedTitle) {	 
		String actualTitle = page.locator(incomingBytesLegendTitle2).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateIncomingBytesGraphLegendTitle3(String expectedTitle) {	 
		String actualTitle = page.locator(incomingBytesLegendTitle3).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateIncomingBytesToolTipTitle() {	 
		util.validateWidgetToolTips(page, incomingBytesXaxisLine, incomingBytesToolTipTitle);
	}

	public void validateIncomingBytesDragAndDrop() {
		util.graphZoomInByDragAndDrop(page, incomingBytesXaxisLine, incomingBytesZoomOut, incomingBytesXaxisValues);
	}
	public void validateIncomingBytesExpandViewXAxisTitle() { 
		util.validateExpandViewTexts(page, incomingBytesXaxis, incomingBytesExpand, expandViewCloseBtn, expandViewXaxisTitle);
	}

	public void validateIncomingBytesExpandViewYAxisTitle() {
		util.validateExpandViewTexts(page, incomingBytesYaxis, incomingBytesExpand, expandViewCloseBtn, expandViewYaxisTitle);
	}

	public void validateIncomingBytesExpandViewWidgetTitle() {
		util.validateExpandViewTexts(page, incomingBytesGraphTitle, incomingBytesExpand, expandViewCloseBtn, expandViewWidgetTitle);
	}

	public void validateIncomingBytesExpandViewLegendHeader1() {	 
		util.validateExpandViewTexts(page, incomingBytesLegendTitle1, incomingBytesExpand, expandViewCloseBtn, expandViewLegendColumn1HeaderTitle);
	}

	public void validateIncomingBytesExpandViewLegendHeader2() {	 
		util.validateExpandViewTexts(page, incomingBytesLegendTitle2 ,incomingBytesExpand, expandViewCloseBtn, expandViewLegendColumn2HeaderTitle);
	}

	public void validateIncomingBytesExpandViewLegendHeader3() {	 
		util.validateExpandViewTexts(page, incomingBytesLegendTitle3 ,incomingBytesExpand, expandViewCloseBtn, expandViewLegendColumn3HeaderTitle);
	}

	public void validateIncomingBytesExpandViewZoomIn() {
		util.ExpandViewZoomInBtn(page, expandViewZoomInBtn, incomingBytesExpand, expandViewCloseBtn, expandViewXaxisValues);
	}

	public void validateIncomingBytesExpandViewZoomOut() {
		util.ExpandViewZoomOutBtn(page, expandViewZoomInBtn, incomingBytesExpand, expandViewCloseBtn, expandViewZoomOutBtn, expandViewXaxisValues);
	}

	public void validateIncomingBytesExpandViewWidgetDragDrop() {
		util.ExpandViewWidgetDragDrop(page, incomingBytesExpand, expandViewCloseBtn, expandViewXaxisLines, expandViewZoomOutBtn, expandViewXaxisValues);
	}
	
/*
 * Outgoing Bytes Graph
 */

	public void validateOutgoingBytesGraphTitle(String expectedTitle) {		  
		String actualTitle = page.locator(outgoingBytesGraphTitle).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateOutgoingBytesZoomInBtn() {		  
		util.graphZoomIn(page, outgoingBytesZoomIn, outgoingBytesXaxisValues);
	}

	public void validateOutgoingBytesZoomOutBtn() {
		util.graphZoomOut(page, outgoingBytesZoomIn, outgoingBytesZoomOut, outgoingBytesXaxisValues);
	}

	public void validateOutgoingBytesGraphXaxisTitle(String expectedTitle) {	 
		String actualTitle = page.locator(outgoingBytesXaxis).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateOutgoingBytesGraphYaxisTitle(String expectedTitle) {	 
		String actualTitle = page.locator(outgoingBytesYaxis).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateOutgoingBytesGraphLegendTitle1(String expectedTitle) {
		String actualTitle = page.locator(outgoingBytesLegendTitle1).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateOutgoingBytesGraphLegendTitle2(String expectedTitle) {	 
		String actualTitle = page.locator(outgoingBytesLegendTitle2).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateOutgoingBytesGraphLegendTitle3(String expectedTitle) {	 
		String actualTitle = page.locator(outgoingBytesLegendTitle3).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateOutgoingBytesToolTipTitle() {	 
		util.validateWidgetToolTips(page, outgoingBytesXaxisLine, outgoingBytesToolTipTitle);
	}

	public void validateOutgoingBytesDragAndDrop() {
		util.graphZoomInByDragAndDrop(page, outgoingBytesXaxisLine, outgoingBytesZoomOut, outgoingBytesXaxisValues);
	}
	public void validateOutgoingBytesExpandViewXAxisTitle() { 
		util.validateExpandViewTexts(page, outgoingBytesXaxis, outgoingBytesExpand, expandViewCloseBtn, expandViewXaxisTitle);
	}

	public void validateOutgoingBytesExpandViewYAxisTitle() {
		util.validateExpandViewTexts(page, outgoingBytesYaxis, outgoingBytesExpand, expandViewCloseBtn, expandViewYaxisTitle);
	}

	public void validateOutgoingBytesExpandViewWidgetTitle() {
		util.validateExpandViewTexts(page, outgoingBytesGraphTitle, outgoingBytesExpand, expandViewCloseBtn, expandViewWidgetTitle);
	}

	public void validateOutgoingBytesExpandViewLegendHeader1() {	 
		util.validateExpandViewTexts(page, outgoingBytesLegendTitle1, outgoingBytesExpand, expandViewCloseBtn, expandViewLegendColumn1HeaderTitle);
	}

	public void validateOutgoingBytesExpandViewLegendHeader2() {	 
		util.validateExpandViewTexts(page, outgoingBytesLegendTitle2 ,outgoingBytesExpand, expandViewCloseBtn, expandViewLegendColumn2HeaderTitle);
	}

	public void validateOutgoingBytesExpandViewLegendHeader3() {	 
		util.validateExpandViewTexts(page, outgoingBytesLegendTitle3 ,outgoingBytesExpand, expandViewCloseBtn, expandViewLegendColumn3HeaderTitle);
	}

	public void validateOutgoingBytesExpandViewZoomIn() {
		util.ExpandViewZoomInBtn(page, expandViewZoomInBtn, outgoingBytesExpand, expandViewCloseBtn, expandViewXaxisValues);
	}

	public void validateOutgoingBytesExpandViewZoomOut() {
		util.ExpandViewZoomOutBtn(page, expandViewZoomInBtn, outgoingBytesExpand, expandViewCloseBtn, expandViewZoomOutBtn, expandViewXaxisValues);
	}

	public void validateOutgoingBytesExpandViewWidgetDragDrop() {
		util.ExpandViewWidgetDragDrop(page, outgoingBytesExpand, expandViewCloseBtn, expandViewXaxisLines, expandViewZoomOutBtn, expandViewXaxisValues);
	}
	
/*
 * Average Fetch Latency Graph
 */

	public void validateAverageFetchLatencyGraphTitle(String expectedTitle) {		  
		String actualTitle = page.locator(averageFetchLatencyGraphTitle).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateAverageFetchLatencyZoomInBtn() {		  
		util.graphZoomIn(page, averageFetchLatencyZoomIn, averageFetchLatencyXaxisValues);
	}

	public void validateAverageFetchLatencyZoomOutBtn() {
		util.graphZoomOut(page, averageFetchLatencyZoomIn, averageFetchLatencyZoomOut, averageFetchLatencyXaxisValues);
	}

	public void validateAverageFetchLatencyGraphXaxisTitle(String expectedTitle) {	 
		String actualTitle = page.locator(averageFetchLatencyXaxis).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateAverageFetchLatencyGraphYaxisTitle(String expectedTitle) {	 
		String actualTitle = page.locator(averageFetchLatencyYaxis).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateAverageFetchLatencyGraphLegendTitle1(String expectedTitle) {
		String actualTitle = page.locator(averageFetchLatencyLegendTitle1).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateAverageFetchLatencyGraphLegendTitle2(String expectedTitle) {	 
		String actualTitle = page.locator(averageFetchLatencyLegendTitle2).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateAverageFetchLatencyGraphLegendTitle3(String expectedTitle) {	 
		String actualTitle = page.locator(averageFetchLatencyLegendTitle3).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateAverageFetchLatencyToolTipTitle() {	 
		util.validateWidgetToolTips(page, averageFetchLatencyXaxisLine, averageFetchLatencyToolTipTitle);
	}

	public void validateAverageFetchLatencyDragAndDrop() {
		util.graphZoomInByDragAndDrop(page, averageFetchLatencyXaxisLine, averageFetchLatencyZoomOut, averageFetchLatencyXaxisValues);
	}
	public void validateAverageFetchLatencyExpandViewXAxisTitle() { 
		util.validateExpandViewTexts(page, averageFetchLatencyXaxis, averageFetchLatencyExpand, expandViewCloseBtn, expandViewXaxisTitle);
	}

	public void validateAverageFetchLatencyExpandViewYAxisTitle() {
		util.validateExpandViewTexts(page, averageFetchLatencyYaxis, averageFetchLatencyExpand, expandViewCloseBtn, expandViewYaxisTitle);
	}

	public void validateAverageFetchLatencyExpandViewWidgetTitle() {
		util.validateExpandViewTexts(page, averageFetchLatencyGraphTitle, averageFetchLatencyExpand, expandViewCloseBtn, expandViewWidgetTitle);
	}

	public void validateAverageFetchLatencyExpandViewLegendHeader1() {	 
		util.validateExpandViewTexts(page, averageFetchLatencyLegendTitle1, averageFetchLatencyExpand, expandViewCloseBtn, expandViewLegendColumn1HeaderTitle);
	}

	public void validateAverageFetchLatencyExpandViewLegendHeader2() {	 
		util.validateExpandViewTexts(page, averageFetchLatencyLegendTitle2 ,averageFetchLatencyExpand, expandViewCloseBtn, expandViewLegendColumn2HeaderTitle);
	}

	public void validateAverageFetchLatencyExpandViewLegendHeader3() {	 
		util.validateExpandViewTexts(page, averageFetchLatencyLegendTitle3 ,averageFetchLatencyExpand, expandViewCloseBtn, expandViewLegendColumn3HeaderTitle);
	}

	public void validateAverageFetchLatencyExpandViewZoomIn() {
		util.ExpandViewZoomInBtn(page, expandViewZoomInBtn, averageFetchLatencyExpand, expandViewCloseBtn, expandViewXaxisValues);
	}

	public void validateAverageFetchLatencyExpandViewZoomOut() {
		util.ExpandViewZoomOutBtn(page, expandViewZoomInBtn, averageFetchLatencyExpand, expandViewCloseBtn, expandViewZoomOutBtn, expandViewXaxisValues);
	}

	public void validateAverageFetchLatencyExpandViewWidgetDragDrop() {
		util.ExpandViewWidgetDragDrop(page, averageFetchLatencyExpand, expandViewCloseBtn, expandViewXaxisLines, expandViewZoomOutBtn, expandViewXaxisValues);
	}
	
	
/*
 * Maximum Fetch Latency Graph
 */

	public void validateMaximumFetchLatencyGraphTitle(String expectedTitle) {		  
		String actualTitle = page.locator(maximumFetchLatencyGraphTitle).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateMaximumFetchLatencyZoomInBtn() {		  
		util.graphZoomIn(page, maximumFetchLatencyZoomIn, maximumFetchLatencyXaxisValues);
	}

	public void validateMaximumFetchLatencyZoomOutBtn() {
		util.graphZoomOut(page, maximumFetchLatencyZoomIn, maximumFetchLatencyZoomOut, maximumFetchLatencyXaxisValues);
	}

	public void validateMaximumFetchLatencyGraphXaxisTitle(String expectedTitle) {	 
		String actualTitle = page.locator(maximumFetchLatencyXaxis).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateMaximumFetchLatencyGraphYaxisTitle(String expectedTitle) {	 
		String actualTitle = page.locator(maximumFetchLatencyYaxis).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateMaximumFetchLatencyGraphLegendTitle1(String expectedTitle) {
		String actualTitle = page.locator(maximumFetchLatencyLegendTitle1).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateMaximumFetchLatencyGraphLegendTitle2(String expectedTitle) {	 
		String actualTitle = page.locator(maximumFetchLatencyLegendTitle2).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateMaximumFetchLatencyGraphLegendTitle3(String expectedTitle) {	 
		String actualTitle = page.locator(maximumFetchLatencyLegendTitle3).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateMaximumFetchLatencyToolTipTitle() {	 
		util.validateWidgetToolTips(page, maximumFetchLatencyXaxisLine, maximumFetchLatencyToolTipTitle);
	}

	public void validateMaximumFetchLatencyDragAndDrop() {
		util.graphZoomInByDragAndDrop(page, maximumFetchLatencyXaxisLine, maximumFetchLatencyZoomOut, maximumFetchLatencyXaxisValues);
	}
	public void validateMaximumFetchLatencyExpandViewXAxisTitle() { 
		util.validateExpandViewTexts(page, maximumFetchLatencyXaxis, maximumFetchLatencyExpand, expandViewCloseBtn, expandViewXaxisTitle);
	}

	public void validateMaximumFetchLatencyExpandViewYAxisTitle() {
		util.validateExpandViewTexts(page, maximumFetchLatencyYaxis, maximumFetchLatencyExpand, expandViewCloseBtn, expandViewYaxisTitle);
	}

	public void validateMaximumFetchLatencyExpandViewWidgetTitle() {
		util.validateExpandViewTexts(page, maximumFetchLatencyGraphTitle, maximumFetchLatencyExpand, expandViewCloseBtn, expandViewWidgetTitle);
	}

	public void validateMaximumFetchLatencyExpandViewLegendHeader1() {	 
		util.validateExpandViewTexts(page, maximumFetchLatencyLegendTitle1, maximumFetchLatencyExpand, expandViewCloseBtn, expandViewLegendColumn1HeaderTitle);
	}

	public void validateMaximumFetchLatencyExpandViewLegendHeader2() {	 
		util.validateExpandViewTexts(page, maximumFetchLatencyLegendTitle2 ,maximumFetchLatencyExpand, expandViewCloseBtn, expandViewLegendColumn2HeaderTitle);
	}

	public void validateMaximumFetchLatencyExpandViewLegendHeader3() {	 
		util.validateExpandViewTexts(page, maximumFetchLatencyLegendTitle3 ,maximumFetchLatencyExpand, expandViewCloseBtn, expandViewLegendColumn3HeaderTitle);
	}

	public void validateMaximumFetchLatencyExpandViewZoomIn() {
		util.ExpandViewZoomInBtn(page, expandViewZoomInBtn, maximumFetchLatencyExpand, expandViewCloseBtn, expandViewXaxisValues);
	}

	public void validateMaximumFetchLatencyExpandViewZoomOut() {
		util.ExpandViewZoomOutBtn(page, expandViewZoomInBtn, maximumFetchLatencyExpand, expandViewCloseBtn, expandViewZoomOutBtn, expandViewXaxisValues);
	}

	public void validateMaximumFetchLatencyExpandViewWidgetDragDrop() {
		util.ExpandViewWidgetDragDrop(page, maximumFetchLatencyExpand, expandViewCloseBtn, expandViewXaxisLines, expandViewZoomOutBtn, expandViewXaxisValues);
	}
		
	
/*
 * Calendar
 */
		
	public void validateTheCustomTimeLine(String period) {
		util.validateCustomTimeLine(page, incomingBytesXaxisValues, period, WidgetXValues(period));
	}
		
	public void validateXaxisValuesForKafkaConsumerRequestMetricsPage() {
		util.validateTheGraphdisplayingTheDataAsPerGivenTimeLines(page, incomingBytesXaxisValues, calenderView, allWidgetXValues());
	}
	
	public List<String> allWidgetXValues() {
		ArrayList<String> xValue = new ArrayList<String>();
		xValue.add(incomingBytesXaxisValues);
		xValue.add(outgoingBytesXaxisValues);
		xValue.add(averageFetchLatencyXaxisValues);
		xValue.add(maximumFetchLatencyXaxisValues);
		return xValue;
	}
	
}