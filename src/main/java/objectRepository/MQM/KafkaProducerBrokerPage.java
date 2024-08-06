package objectRepository.MQM;

import java.util.ArrayList;
import java.util.List;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;

import genericUtilities.ExcelUtility;
import genericUtilities.GenericMethods;

public class KafkaProducerBrokerPage 
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
	private String producerTab = "xpath = //div[@class='navtab']/div[@class='item' and position()=2]/child::div";
	private String brokerTab = "xpath = //div[@class='kafkaProducerTabSelector']/child::div[@class][position()=1]";
	private String producerTitle = "xpath = //div[@class='kafkaDropdownSelector']/descendant::div[@class='heading']";
	private String selectNameDropDown = "#btn-arrow-down-mq-select-participant";
	private String activeTickMark = "xpath = //input[@id='input-search-sel-mq-select-participant']/parent::div/following-sibling::div/child::div[@class='option']/span/span";
	private String nameSearchResults = "xpath = //input[@id='input-search-sel-mq-select-participant']/parent::div/following-sibling::div/child::div[@class='option'][1]";
	
//Incoming Bytes Graph
	private String incomingBytesGraphTitle = "xpath = //div[@class='kafkaProducerTabSelector']/child::div[@class='kafkaTabItem kafkaActiveTab']/child::span[.='Broker']/ancestor::div[@class='kafkaProducerActions']/following-sibling::div//div[.='Incoming bytes ']";
	private String incomingBytesXaxis = "xpath = //div[.='Incoming bytes ']/following-sibling::div/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-title-text chart-lables']";
	private String incomingBytesYaxis = "xpath = //div[.='Incoming bytes ']/following-sibling::div/descendant::*[name()='text' and @class='apexcharts-text apexcharts-yaxis-title-text chart-lables']";
	private String incomingBytesXaxisLine = "xpath = //div[.='Incoming bytes ']/following-sibling::div/descendant::*[name()='line' and @class='apexcharts-xaxis-tick']";
	private String incomingBytesXaxisValues = "xpath = //div[@id='apexchartschart-kafka_producer_incoming_byte_rate']/descendant::*[name()='tspan' and contains(.,'-')]";
	private String incomingBytesZoomOut = "xpath = (//div[.='Incoming bytes ']/descendant::span[@class='icon-class'])[position()=1]";
	private String incomingBytesZoomIn = "xpath = (//div[.='Incoming bytes ']/descendant::span[@class='icon-class'])[position()=2]";
	private String incomingBytesLegendTitle1 = "xpath = (//div[.='Incoming bytes ']/following-sibling::div/descendant::div[@class='header-heading'])[position()=1]";
	private String incomingBytesLegendTitle2 = "xpath = (//div[.='Incoming bytes ']/following-sibling::div/descendant::div[@class='header-heading'])[position()=2]";
	private String incomingBytesLegendTitle3 = "xpath = (//div[.='Incoming bytes ']/following-sibling::div/descendant::div[@class='header-heading'])[position()=3]";
	private String incomingBytesToolTipTitle = "xpath = //div[.='Incoming bytes ']/following-sibling::div/descendant::div[@class='apexcharts-tooltip-title']";

//Outgoing Bytes Graph
	private String outgoingBytesGraphTitle = "xpath = //div[@class='kafkaProducerTabSelector']/child::div[@class='kafkaTabItem kafkaActiveTab']/child::span[.='Broker']/ancestor::div[@class='kafkaProducerActions']/following-sibling::div//div[.='Outgoing bytes ']";
	private String outgoingBytesXaxis = "xpath = //div[.='Outgoing bytes ']/following-sibling::div/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-title-text chart-lables']";
	private String outgoingBytesYaxis = "xpath = //div[.='Outgoing bytes ']/following-sibling::div/descendant::*[name()='text' and @class='apexcharts-text apexcharts-yaxis-title-text chart-lables']";
	private String outgoingBytesXaxisLine = "xpath = //div[.='Outgoing bytes ']/following-sibling::div/descendant::*[name()='line' and @class='apexcharts-xaxis-tick']";
	private String outgoingBytesXaxisValues = "xpath = //div[@id='apexchartschart-kafka_producer_outgoing_byte_rate']/descendant::*[name()='tspan' and contains(.,'-')]";
	private String outgoingBytesZoomOut = "xpath = (//div[.='Outgoing bytes ']/descendant::span[@class='icon-class'])[position()=1]";
	private String outgoingBytesZoomIn = "xpath = (//div[.='Outgoing bytes ']/descendant::span[@class='icon-class'])[position()=2]";
	private String outgoingBytesLegendTitle1 = "xpath = (//div[.='Outgoing bytes ']/following-sibling::div/descendant::div[@class='header-heading'])[position()=1]";
	private String outgoingBytesLegendTitle2 = "xpath = (//div[.='Outgoing bytes ']/following-sibling::div/descendant::div[@class='header-heading'])[position()=2]";
	private String outgoingBytesLegendTitle3 = "xpath = (//div[.='Outgoing bytes ']/following-sibling::div/descendant::div[@class='header-heading'])[position()=3]";
	private String outgoingBytesToolTipTitle = "xpath = //div[.='Outgoing bytes ']/following-sibling::div/descendant::div[@class='apexcharts-tooltip-title']";

//Request Size Graph
	private String requestSizeGraphTitle = "xpath = //div[@class='kafkaProducerTabSelector']/child::div[@class='kafkaTabItem kafkaActiveTab']/child::span[.='Broker']/ancestor::div[@class='kafkaProducerActions']/following-sibling::div//div[.='Request size ']";
	private String requestSizeXaxis = "xpath = //div[.='Request size ']/following-sibling::div/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-title-text chart-lables']";
	private String requestSizeYaxis = "xpath = //div[.='Request size ']/following-sibling::div/descendant::*[name()='text' and @class='apexcharts-text apexcharts-yaxis-title-text chart-lables']";
	private String requestSizeXaxisLine = "xpath = //div[.='Request size ']/following-sibling::div/descendant::*[name()='line' and @class='apexcharts-xaxis-tick']";
	private String requestSizeXaxisValues = "xpath = //div[@id='apexchartschart-kafka_producer_request_size_avg']/descendant::*[name()='tspan' and contains(.,'-')]";
	private String requestSizeZoomOut = "xpath = (//div[.='Request size ']/descendant::span[@class='icon-class'])[position()=1]";
	private String requestSizeZoomIn = "xpath = (//div[.='Request size ']/descendant::span[@class='icon-class'])[position()=2]";
	private String requestSizeLegendTitle1 = "xpath = (//div[.='Request size ']/following-sibling::div/descendant::div[@class='header-heading'])[position()=1]";
	private String requestSizeLegendTitle2 = "xpath = (//div[.='Request size ']/following-sibling::div/descendant::div[@class='header-heading'])[position()=2]";
	private String requestSizeLegendTitle3 = "xpath = (//div[.='Request size ']/following-sibling::div/descendant::div[@class='header-heading'])[position()=3]";
	private String requestSizeToolTipTitle = "xpath = //div[.='Request size ']/following-sibling::div/descendant::div[@class='apexcharts-tooltip-title']";
	
//Response Rate Graph
	private String responseRateGraphTitle = "xpath = //div[@class='kafkaProducerTabSelector']/child::div[@class='kafkaTabItem kafkaActiveTab']/child::span[.='Broker']/ancestor::div[@class='kafkaProducerActions']/following-sibling::div//div[.='Response rate ']";
	private String responseRateXaxis = "xpath = //div[.='Response rate ']/following-sibling::div/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-title-text chart-lables']";
	private String responseRateYaxis = "xpath = //div[.='Response rate ']/following-sibling::div/descendant::*[name()='text' and @class='apexcharts-text apexcharts-yaxis-title-text chart-lables']";
	private String responseRateXaxisLine = "xpath = //div[.='Response rate ']/following-sibling::div/descendant::*[name()='line' and @class='apexcharts-xaxis-tick']";
	private String responseRateXaxisValues = "xpath = //div[@id='apexchartschart-kafka_producer_response_rate']/descendant::*[name()='tspan' and contains(.,'-')]";
	private String responseRateZoomOut = "xpath = (//div[.='Response rate ']/descendant::span[@class='icon-class'])[position()=1]";
	private String responseRateZoomIn = "xpath = (//div[.='Response rate ']/descendant::span[@class='icon-class'])[position()=2]";
	private String responseRateLegendTitle1 = "xpath = (//div[.='Response rate ']/following-sibling::div/descendant::div[@class='header-heading'])[position()=1]";
	private String responseRateLegendTitle2 = "xpath = (//div[.='Response rate ']/following-sibling::div/descendant::div[@class='header-heading'])[position()=2]";
	private String responseRateLegendTitle3 = "xpath = (//div[.='Response rate ']/following-sibling::div/descendant::div[@class='header-heading'])[position()=3]";
	private String responseRateToolTipTitle = "xpath = //div[.='Response rate ']/following-sibling::div/descendant::div[@class='apexcharts-tooltip-title']";
	
//Expand Button
	private String incomingBytesExpand = "xpath = (//div[.='Incoming bytes ']/descendant::span[@class='icon-class'])[position()=3]";
	private String outgoingBytesExpand = "xpath = (//div[.='Outgoing bytes ']/descendant::span[@class='icon-class'])[position()=3]";	
	private String requestSizeExpand = "xpath = (//div[.='Request size ']/descendant::span[@class='icon-class'])[position()=3]";	
	private String responseRateExpand = "xpath = (//div[.='Response rate ']/descendant::span[@class='icon-class'])[position()=3]";	

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
	
	public KafkaProducerBrokerPage(Page page) {
		this.page = page;
	}

	public void navigateToKafka(String messageQueue) {
		util.selectTheOptionFromDropDownBySearch(page, selectMessageQueueDropdown, selectSearchFieldMQDropdown, messageQueue, selectMQDropdown);
		page.waitForLoadState(LoadState.NETWORKIDLE);
	}

	public void selectServiceName(String application) {
		 util.selectTheOptionFromDropDownBySearch(page, selectServiceNameDropdown, selectSearchFieldServiceNameDropdown, application, searchedApplication); 
		 page.waitForLoadState(LoadState.NETWORKIDLE); }
	 

	public void navigateToProducerTab() {
		page.locator(producerTab).click();
		page.waitForLoadState(LoadState.NETWORKIDLE);
	}

	public void validateProducerTitle(String expectedTitle) {
		String actualTitle = page.locator(producerTab).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
		page.waitForLoadState(LoadState.NETWORKIDLE);
	}
	
/*
 * Broker Tab
 */

	public void validateBrokerTabTitle(String expectedTitle) {
		String actualTitle = page.locator(brokerTab).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void clickOnBrokerTab() {
		page.locator(brokerTab).click();
		page.waitForLoadState(LoadState.NETWORKIDLE);
	}
	
	public void validateProducerSelectTitle(String expectedTitle) {
		String actualTitle = page.locator(producerTitle).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}
	
	public void validateProducerSelectDropDown() {
		util.SelectTheMulitpleOptionFromDropDown(page, selectNameDropDown, activeTickMark, listOfNames()); 
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
 * Request Size Graph
 */

	public void validateRequestSizeGraphTitle(String expectedTitle) {		  
		String actualTitle = page.locator(requestSizeGraphTitle).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateRequestSizeZoomInBtn() {		  
		util.graphZoomIn(page, requestSizeZoomIn, requestSizeXaxisValues);
	}

	public void validateRequestSizeZoomOutBtn() {
		util.graphZoomOut(page, requestSizeZoomIn, requestSizeZoomOut, requestSizeXaxisValues);
	}

	public void validateRequestSizeGraphXaxisTitle(String expectedTitle) {	 
		String actualTitle = page.locator(requestSizeXaxis).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateRequestSizeGraphYaxisTitle(String expectedTitle) {	 
		String actualTitle = page.locator(requestSizeYaxis).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateRequestSizeGraphLegendTitle1(String expectedTitle) {
		String actualTitle = page.locator(requestSizeLegendTitle1).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateRequestSizeGraphLegendTitle2(String expectedTitle) {	 
		String actualTitle = page.locator(requestSizeLegendTitle2).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateRequestSizeGraphLegendTitle3(String expectedTitle) {	 
		String actualTitle = page.locator(requestSizeLegendTitle3).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateRequestSizeToolTipTitle() {	 
		util.validateWidgetToolTips(page, requestSizeXaxisLine, requestSizeToolTipTitle);
	}

	public void validateRequestSizeDragAndDrop() {
		util.graphZoomInByDragAndDrop(page, requestSizeXaxisLine, requestSizeZoomOut, requestSizeXaxisValues);
	}
	public void validateRequestSizeExpandViewXAxisTitle() { 
		util.validateExpandViewTexts(page, requestSizeXaxis, requestSizeExpand, expandViewCloseBtn, expandViewXaxisTitle);
	}

	public void validateRequestSizeExpandViewYAxisTitle() {
		page.reload();
		util.validateExpandViewTexts(page, requestSizeYaxis, requestSizeExpand, expandViewCloseBtn, expandViewYaxisTitle);
	}

	public void validateRequestSizeExpandViewWidgetTitle() {
		util.validateExpandViewTexts(page, requestSizeGraphTitle, requestSizeExpand, expandViewCloseBtn, expandViewWidgetTitle);
	}

	public void validateRequestSizeExpandViewLegendHeader1() {	 
		util.validateExpandViewTexts(page, requestSizeLegendTitle1, requestSizeExpand, expandViewCloseBtn, expandViewLegendColumn1HeaderTitle);
	}

	public void validateRequestSizeExpandViewLegendHeader2() {	 
		util.validateExpandViewTexts(page, requestSizeLegendTitle2 ,requestSizeExpand, expandViewCloseBtn, expandViewLegendColumn2HeaderTitle);
	}

	public void validateRequestSizeExpandViewLegendHeader3() {	 
		util.validateExpandViewTexts(page, requestSizeLegendTitle3 ,requestSizeExpand, expandViewCloseBtn, expandViewLegendColumn3HeaderTitle);
	}

	public void validateRequestSizeExpandViewZoomIn() {
		util.ExpandViewZoomInBtn(page, expandViewZoomInBtn, requestSizeExpand, expandViewCloseBtn, expandViewXaxisValues);
	}

	public void validateRequestSizeExpandViewZoomOut() {
		util.ExpandViewZoomOutBtn(page, expandViewZoomInBtn, requestSizeExpand, expandViewCloseBtn, expandViewZoomOutBtn, expandViewXaxisValues);
	}

	public void validateRequestSizeExpandViewWidgetDragDrop() {
		util.ExpandViewWidgetDragDrop(page, requestSizeExpand, expandViewCloseBtn, expandViewXaxisLines, expandViewZoomOutBtn, expandViewXaxisValues);
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
		page.waitForTimeout(2000);
		util.validateWidgetToolTips(page, responseRateXaxisLine, responseRateToolTipTitle);
	}

	public void validateResponseRateDragAndDrop() {
		page.waitForTimeout(2000);
		util.graphZoomInByDragAndDrop(page, responseRateXaxisLine, responseRateZoomOut, responseRateXaxisValues);
	}
	public void validateResponseRateExpandViewXAxisTitle() { 
		util.validateExpandViewTexts(page, responseRateXaxis, responseRateExpand, expandViewCloseBtn, expandViewXaxisTitle);
	}

	public void validateResponseRateExpandViewYAxisTitle() {
		page.reload();
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
 * Calendar
 */
		
	public void validateTheCustomTimeLine(String period) {
		util.validateCustomTimeLine(page, incomingBytesXaxisValues, period, WidgetXValues(period));
	}
		
	public void validateXaxisValuesForKafkaProducerBrokerPage() {
		util.validateTheGraphdisplayingTheDataAsPerGivenTimeLines(page, incomingBytesXaxisValues, calenderView, allWidgetXValues());
	}
	
	public List<String> allWidgetXValues() {
		ArrayList<String> xValue = new ArrayList<String>();
		xValue.add(incomingBytesXaxisValues);
		xValue.add(outgoingBytesXaxisValues);
		xValue.add(requestSizeXaxisValues);
		xValue.add(responseRateXaxisValues);
		return xValue;
	}
}