package objectRepository.MQM;

import java.util.ArrayList;
import java.util.List;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;

import genericUtilities.ExcelUtility;
import genericUtilities.GenericMethods;

public class KafkaProducerTopicPage 
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
	private String topicTab = "xpath = //div[@class='kafkaProducerTabSelector']/child::div[@class][position()=2]";
	private String producerTitle = "xpath = //div[@class='kafkaDropdownSelector']/descendant::div[@class='heading'][position()=2]";
	private String selectProducerDropDown = "#btn-arrow-down-kafka-select-producer";
	private String selectOptionProducer = "#kafka-select-producer-0-single";
	private String activeTickMark = "xpath = //input[@id='input-search-sel-mq-select-participant']/parent::div/following-sibling::div/child::div[@class='option']/span/span";
	private String nameSearchResults = "xpath = //input[@id='input-search-sel-mq-select-participant']/parent::div/following-sibling::div/child::div[@class='option'][1]";
	private String topicTitle = "xpath = //div[@class='kafkaDropdownSelector']/descendant::div[@class='heading'][position()=1]";
	private String selectTopicDropDown = "#btn-arrow-down-mq-select-participant";
	
//Record send rate Graph
	private String recordSendRateGraphTitle = "xpath = //div[@class='kafkaProducerTabSelector']/child::div[@class='kafkaTabItem kafkaActiveTab']/child::span[.='Topic']/ancestor::div[@class='kafkaProducerActions']/following-sibling::div//div[.='Record send rate ']";
	private String recordSendRateXaxis = "xpath = //div[.='Record send rate ']/following-sibling::div/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-title-text chart-lables']";
	private String recordSendRateYaxis = "xpath = //div[.='Record send rate ']/following-sibling::div/descendant::*[name()='text' and @class='apexcharts-text apexcharts-yaxis-title-text chart-lables']";
	private String recordSendRateXaxisLine = "xpath = //div[.='Record send rate ']/following-sibling::div/descendant::*[name()='line' and @class='apexcharts-xaxis-tick']";
	private String recordSendRateXaxisValues = "xpath = //div[@id='apexchartschart-kafka_producer_incoming_byte_rate']/descendant::*[name()='tspan' and contains(.,'-')]";
	private String recordSendRateZoomOut = "xpath = (//div[.='Record send rate ']/descendant::span[@class='icon-class'])[position()=1]";
	private String recordSendRateZoomIn = "xpath = (//div[.='Record send rate ']/descendant::span[@class='icon-class'])[position()=2]";
	private String recordSendRateLegendTitle1 = "xpath = (//div[.='Record send rate ']/following-sibling::div/descendant::div[@class='header-heading'])[position()=1]";
	private String recordSendRateLegendTitle2 = "xpath = (//div[.='Record send rate ']/following-sibling::div/descendant::div[@class='header-heading'])[position()=2]";
	private String recordSendRateLegendTitle3 = "xpath = (//div[.='Record send rate ']/following-sibling::div/descendant::div[@class='header-heading'])[position()=3]";
	private String recordSendRateToolTipTitle = "xpath = //div[.='Record send rate ']/following-sibling::div/descendant::div[@class='apexcharts-tooltip-title']";

//Record send total Graph
	private String recordSendTotalGraphTitle = "xpath = //div[@class='kafkaProducerTabSelector']/child::div[@class='kafkaTabItem kafkaActiveTab']/child::span[.='Topic']/ancestor::div[@class='kafkaProducerActions']/following-sibling::div//div[.='Record send total ']";
	private String recordSendTotalXaxis = "xpath = //div[.='Record send total ']/following-sibling::div/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-title-text chart-lables']";
	private String recordSendTotalYaxis = "xpath = //div[.='Record send total ']/following-sibling::div/descendant::*[name()='text' and @class='apexcharts-text apexcharts-yaxis-title-text chart-lables']";
	private String recordSendTotalXaxisLine = "xpath = //div[.='Record send total ']/following-sibling::div/descendant::*[name()='line' and @class='apexcharts-xaxis-tick']";
	private String recordSendTotalXaxisValues = "xpath = //div[@id='apexchartschart-kafka_producer_outgoing_byte_rate']/descendant::*[name()='tspan' and contains(.,'-')]";
	private String recordSendTotalZoomOut = "xpath = (//div[.='Record send total ']/descendant::span[@class='icon-class'])[position()=1]";
	private String recordSendTotalZoomIn = "xpath = (//div[.='Record send total ']/descendant::span[@class='icon-class'])[position()=2]";
	private String recordSendTotalLegendTitle1 = "xpath = (//div[.='Record send total ']/following-sibling::div/descendant::div[@class='header-heading'])[position()=1]";
	private String recordSendTotalLegendTitle2 = "xpath = (//div[.='Record send total ']/following-sibling::div/descendant::div[@class='header-heading'])[position()=2]";
	private String recordSendTotalLegendTitle3 = "xpath = (//div[.='Record send total ']/following-sibling::div/descendant::div[@class='header-heading'])[position()=3]";
	private String recordSendTotalToolTipTitle = "xpath = //div[.='Record send total ']/following-sibling::div/descendant::div[@class='apexcharts-tooltip-title']";
	
//Record error rate Graph
	private String recordErrorRateGraphTitle = "xpath = //div[@class='kafkaProducerTabSelector']/child::div[@class='kafkaTabItem kafkaActiveTab']/child::span[.='Topic']/ancestor::div[@class='kafkaProducerActions']/following-sibling::div//div[.='Record error rate ']";
	private String recordErrorRateXaxis = "xpath = //div[.='Record error rate ']/following-sibling::div/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-title-text chart-lables']";
	private String recordErrorRateYaxis = "xpath = //div[.='Record error rate ']/following-sibling::div/descendant::*[name()='text' and @class='apexcharts-text apexcharts-yaxis-title-text chart-lables']";
	private String recordErrorRateXaxisLine = "xpath = //div[.='Record error rate ']/following-sibling::div/descendant::*[name()='line' and @class='apexcharts-xaxis-tick']";
	private String recordErrorRateXaxisValues = "xpath = //div[@id='apexchartschart-kafka_producer_request_size_avg']/descendant::*[name()='tspan' and contains(.,'-')]";
	private String recordErrorRateZoomOut = "xpath = (//div[.='Record error rate ']/descendant::span[@class='icon-class'])[position()=1]";
	private String recordErrorRateZoomIn = "xpath = (//div[.='Record error rate ']/descendant::span[@class='icon-class'])[position()=2]";
	private String recordErrorRateLegendTitle1 = "xpath = (//div[.='Record error rate ']/following-sibling::div/descendant::div[@class='header-heading'])[position()=1]";
	private String recordErrorRateLegendTitle2 = "xpath = (//div[.='Record error rate ']/following-sibling::div/descendant::div[@class='header-heading'])[position()=2]";
	private String recordErrorRateLegendTitle3 = "xpath = (//div[.='Record error rate ']/following-sibling::div/descendant::div[@class='header-heading'])[position()=3]";
	private String recordErrorRateToolTipTitle = "xpath = //div[.='Record error rate ']/following-sibling::div/descendant::div[@class='apexcharts-tooltip-title']";

//Record error total Graph
	private String recordErrorTotalGraphTitle = "xpath = //div[@class='kafkaProducerTabSelector']/child::div[@class='kafkaTabItem kafkaActiveTab']/child::span[.='Topic']/ancestor::div[@class='kafkaProducerActions']/following-sibling::div//div[.='Record error total ']";
	private String recordErrorTotalXaxis = "xpath = //div[.='Record error total ']/following-sibling::div/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-title-text chart-lables']";
	private String recordErrorTotalYaxis = "xpath = //div[.='Record error total ']/following-sibling::div/descendant::*[name()='text' and @class='apexcharts-text apexcharts-yaxis-title-text chart-lables']";
	private String recordErrorTotalXaxisLine = "xpath = //div[.='Record error total ']/following-sibling::div/descendant::*[name()='line' and @class='apexcharts-xaxis-tick']";
	private String recordErrorTotalXaxisValues = "xpath = //div[@id='apexchartschart-kafka_producer_response_rate']/descendant::*[name()='tspan' and contains(.,'-')]";
	private String recordErrorTotalZoomOut = "xpath = (//div[.='Record error total ']/descendant::span[@class='icon-class'])[position()=1]";
	private String recordErrorTotalZoomIn = "xpath = (//div[.='Record error total ']/descendant::span[@class='icon-class'])[position()=2]";
	private String recordErrorTotalLegendTitle1 = "xpath = (//div[.='Record error total ']/following-sibling::div/descendant::div[@class='header-heading'])[position()=1]";
	private String recordErrorTotalLegendTitle2 = "xpath = (//div[.='Record error total ']/following-sibling::div/descendant::div[@class='header-heading'])[position()=2]";
	private String recordErrorTotalLegendTitle3 = "xpath = (//div[.='Record error total ']/following-sibling::div/descendant::div[@class='header-heading'])[position()=3]";
	private String recordErrorTotalToolTipTitle = "xpath = //div[.='Record error total ']/following-sibling::div/descendant::div[@class='apexcharts-tooltip-title']";
	
//Expand Button
	private String recordSendRateExpand = "xpath = (//div[.='Record send rate ']/descendant::span[@class='icon-class'])[position()=3]";
	private String recordSendTotalExpand = "xpath = (//div[.='Record send total ']/descendant::span[@class='icon-class'])[position()=3]";	
	private String recordErrorRateExpand = "xpath = (//div[.='Record error rate ']/descendant::span[@class='icon-class'])[position()=3]";	
	private String recordErrorTotalExpand = "xpath = (//div[.='Record error total ']/descendant::span[@class='icon-class'])[position()=3]";	

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
		page.locator(selectTopicDropDown).click();
		ArrayList<String> values = new ArrayList<String>();
		Locator options = page.locator(nameSearchResults);
		for (int i = 0; i < options.count(); i++) {

			String option = options.nth(i).textContent();
			System.out.println(option);
			values.add(option);
		}
		page.locator(selectTopicDropDown).click();
		return values;
	}
	
	public KafkaProducerTopicPage(Page page) {
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
	
	public void validateTopicSelectTitle(String expectedTitle) {
		String actualTitle = page.locator(topicTitle).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}
	
	public void validateTopicSelectDropDown() {
		util.SelectTheMulitpleOptionFromDropDown(page, selectTopicDropDown, activeTickMark, listOfNames()); 
		page.waitForLoadState(LoadState.NETWORKIDLE); 
	}
	
	public void validateProducerSelectTitle(String expectedTitle) {
		String actualTitle = page.locator(producerTitle).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}
	
	public void validateProducerSelectDropDown() {
		util.selectTheOptionFromDropDown(page, selectProducerDropDown, selectOptionProducer);
		page.waitForLoadState(LoadState.NETWORKIDLE); 
	}
	
	
/*
 * Topic Tab
 */

	public void validateTopicTabTitle(String expectedTitle) {
		String actualTitle = page.locator(topicTab).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void clickOnTopicTab() {
			page.locator(topicTab).click();
			page.waitForLoadState(LoadState.NETWORKIDLE);
	}
	
/*
 * Record Send Rate Graph
 */

	public void validateRecordSendRateGraphTitle(String expectedTitle) {		  
		String actualTitle = page.locator(recordSendRateGraphTitle).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateRecordSendRateZoomInBtn() {		  
		util.graphZoomIn(page, recordSendRateZoomIn, recordSendRateXaxisValues);
	}

	public void validateRecordSendRateZoomOutBtn() {
		util.graphZoomOut(page, recordSendRateZoomIn, recordSendRateZoomOut, recordSendRateXaxisValues);
	}

	public void validateRecordSendRateGraphXaxisTitle(String expectedTitle) {	 
		String actualTitle = page.locator(recordSendRateXaxis).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateRecordSendRateGraphYaxisTitle(String expectedTitle) {	 
		String actualTitle = page.locator(recordSendRateYaxis).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateRecordSendRateGraphLegendTitle1(String expectedTitle) {
		String actualTitle = page.locator(recordSendRateLegendTitle1).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateRecordSendRateGraphLegendTitle2(String expectedTitle) {	 
		String actualTitle = page.locator(recordSendRateLegendTitle2).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateRecordSendRateGraphLegendTitle3(String expectedTitle) {	 
		String actualTitle = page.locator(recordSendRateLegendTitle3).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateRecordSendRateToolTipTitle() {	 
		util.validateWidgetToolTips(page, recordSendRateXaxisLine, recordSendRateToolTipTitle);
	}

	public void validateRecordSendRateDragAndDrop() {
		util.graphZoomInByDragAndDrop(page, recordSendRateXaxisLine, recordSendRateZoomOut, recordSendRateXaxisValues);
	}
	public void validateRecordSendRateExpandViewXAxisTitle() { 
		util.validateExpandViewTexts(page, recordSendRateXaxis, recordSendRateExpand, expandViewCloseBtn, expandViewXaxisTitle);
	}

	public void validateRecordSendRateExpandViewYAxisTitle() {
		util.validateExpandViewTexts(page, recordSendRateYaxis, recordSendRateExpand, expandViewCloseBtn, expandViewYaxisTitle);
	}

	public void validateRecordSendRateExpandViewWidgetTitle() {
		util.validateExpandViewTexts(page, recordSendRateGraphTitle, recordSendRateExpand, expandViewCloseBtn, expandViewWidgetTitle);
	}

	public void validateRecordSendRateExpandViewLegendHeader1() {	 
		util.validateExpandViewTexts(page, recordSendRateLegendTitle1, recordSendRateExpand, expandViewCloseBtn, expandViewLegendColumn1HeaderTitle);
	}

	public void validateRecordSendRateExpandViewLegendHeader2() {	 
		util.validateExpandViewTexts(page, recordSendRateLegendTitle2 ,recordSendRateExpand, expandViewCloseBtn, expandViewLegendColumn2HeaderTitle);
	}

	public void validateRecordSendRateExpandViewLegendHeader3() {	 
		util.validateExpandViewTexts(page, recordSendRateLegendTitle3 ,recordSendRateExpand, expandViewCloseBtn, expandViewLegendColumn3HeaderTitle);
	}

	public void validateRecordSendRateExpandViewZoomIn() {
		util.ExpandViewZoomInBtn(page, expandViewZoomInBtn, recordSendRateExpand, expandViewCloseBtn, expandViewXaxisValues);
	}

	public void validateRecordSendRateExpandViewZoomOut() {
		util.ExpandViewZoomOutBtn(page, expandViewZoomInBtn, recordSendRateExpand, expandViewCloseBtn, expandViewZoomOutBtn, expandViewXaxisValues);
	}

	public void validateRecordSendRateExpandViewWidgetDragDrop() {
		util.ExpandViewWidgetDragDrop(page, recordSendRateExpand, expandViewCloseBtn, expandViewXaxisLines, expandViewZoomOutBtn, expandViewXaxisValues);
	}
	
/*
 * Record Send Total Graph
 */

	public void validateRecordSendTotalGraphTitle(String expectedTitle) {		  
		String actualTitle = page.locator(recordSendTotalGraphTitle).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateRecordSendTotalZoomInBtn() {		  
		util.graphZoomIn(page, recordSendTotalZoomIn, recordSendTotalXaxisValues);
	}

	public void validateRecordSendTotalZoomOutBtn() {
		util.graphZoomOut(page, recordSendTotalZoomIn, recordSendTotalZoomOut, recordSendTotalXaxisValues);
	}

	public void validateRecordSendTotalGraphXaxisTitle(String expectedTitle) {	 
		String actualTitle = page.locator(recordSendTotalXaxis).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateRecordSendTotalGraphYaxisTitle(String expectedTitle) {	 
		String actualTitle = page.locator(recordSendTotalYaxis).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateRecordSendTotalGraphLegendTitle1(String expectedTitle) {
		String actualTitle = page.locator(recordSendTotalLegendTitle1).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateRecordSendTotalGraphLegendTitle2(String expectedTitle) {	 
		String actualTitle = page.locator(recordSendTotalLegendTitle2).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateRecordSendTotalGraphLegendTitle3(String expectedTitle) {	 
		String actualTitle = page.locator(recordSendTotalLegendTitle3).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateRecordSendTotalToolTipTitle() {	 
		util.validateWidgetToolTips(page, recordSendTotalXaxisLine, recordSendTotalToolTipTitle);
	}

	public void validateRecordSendTotalDragAndDrop() {
		util.graphZoomInByDragAndDrop(page, recordSendTotalXaxisLine, recordSendTotalZoomOut, recordSendTotalXaxisValues);
	}
	public void validateRecordSendTotalExpandViewXAxisTitle() { 
		util.validateExpandViewTexts(page, recordSendTotalXaxis, recordSendTotalExpand, expandViewCloseBtn, expandViewXaxisTitle);
	}

	public void validateRecordSendTotalExpandViewYAxisTitle() {
		util.validateExpandViewTexts(page, recordSendTotalYaxis, recordSendTotalExpand, expandViewCloseBtn, expandViewYaxisTitle);
	}

	public void validateRecordSendTotalExpandViewWidgetTitle() {
		util.validateExpandViewTexts(page, recordSendTotalGraphTitle, recordSendTotalExpand, expandViewCloseBtn, expandViewWidgetTitle);
	}

	public void validateRecordSendTotalExpandViewLegendHeader1() {	 
		util.validateExpandViewTexts(page, recordSendTotalLegendTitle1, recordSendTotalExpand, expandViewCloseBtn, expandViewLegendColumn1HeaderTitle);
	}

	public void validateRecordSendTotalExpandViewLegendHeader2() {	 
		util.validateExpandViewTexts(page, recordSendTotalLegendTitle2 ,recordSendTotalExpand, expandViewCloseBtn, expandViewLegendColumn2HeaderTitle);
	}

	public void validateRecordSendTotalExpandViewLegendHeader3() {	 
		util.validateExpandViewTexts(page, recordSendTotalLegendTitle3 ,recordSendTotalExpand, expandViewCloseBtn, expandViewLegendColumn3HeaderTitle);
	}

	public void validateRecordSendTotalExpandViewZoomIn() {
		util.ExpandViewZoomInBtn(page, expandViewZoomInBtn, recordSendTotalExpand, expandViewCloseBtn, expandViewXaxisValues);
	}

	public void validateRecordSendTotalExpandViewZoomOut() {
		util.ExpandViewZoomOutBtn(page, expandViewZoomInBtn, recordSendTotalExpand, expandViewCloseBtn, expandViewZoomOutBtn, expandViewXaxisValues);
	}

	public void validateRecordSendTotalExpandViewWidgetDragDrop() {
		util.ExpandViewWidgetDragDrop(page, recordSendTotalExpand, expandViewCloseBtn, expandViewXaxisLines, expandViewZoomOutBtn, expandViewXaxisValues);
	}
	
	
/*
 * Record Error Rate Graph
 */

	public void validateRecordErrorRateGraphTitle(String expectedTitle) {		  
		String actualTitle = page.locator(recordErrorRateGraphTitle).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateRecordErrorRateZoomInBtn() {		  
		util.graphZoomIn(page, recordErrorRateZoomIn, recordErrorRateXaxisValues);
	}

	public void validateRecordErrorRateZoomOutBtn() {
		util.graphZoomOut(page, recordErrorRateZoomIn, recordErrorRateZoomOut, recordErrorRateXaxisValues);
	}

	public void validateRecordErrorRateGraphXaxisTitle(String expectedTitle) {	 
		String actualTitle = page.locator(recordErrorRateXaxis).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateRecordErrorRateGraphYaxisTitle(String expectedTitle) {	 
		String actualTitle = page.locator(recordErrorRateYaxis).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateRecordErrorRateGraphLegendTitle1(String expectedTitle) {
		String actualTitle = page.locator(recordErrorRateLegendTitle1).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateRecordErrorRateGraphLegendTitle2(String expectedTitle) {	 
		String actualTitle = page.locator(recordErrorRateLegendTitle2).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateRecordErrorRateGraphLegendTitle3(String expectedTitle) {	 
		String actualTitle = page.locator(recordErrorRateLegendTitle3).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateRecordErrorRateToolTipTitle() {	 
		util.validateWidgetToolTips(page, recordErrorRateXaxisLine, recordErrorRateToolTipTitle);
	}

	public void validateRecordErrorRateDragAndDrop() {
		util.graphZoomInByDragAndDrop(page, recordErrorRateXaxisLine, recordErrorRateZoomOut, recordErrorRateXaxisValues);
	}
	public void validateRecordErrorRateExpandViewXAxisTitle() { 
		util.validateExpandViewTexts(page, recordErrorRateXaxis, recordErrorRateExpand, expandViewCloseBtn, expandViewXaxisTitle);
	}

	public void validateRecordErrorRateExpandViewYAxisTitle() {
		page.waitForTimeout(2000);
		util.validateExpandViewTexts(page, recordErrorRateYaxis, recordErrorRateExpand, expandViewCloseBtn, expandViewYaxisTitle);
	}

	public void validateRecordErrorRateExpandViewWidgetTitle() {
		util.validateExpandViewTexts(page, recordErrorRateGraphTitle, recordErrorRateExpand, expandViewCloseBtn, expandViewWidgetTitle);
	}

	public void validateRecordErrorRateExpandViewLegendHeader1() {	 
		util.validateExpandViewTexts(page, recordErrorRateLegendTitle1, recordErrorRateExpand, expandViewCloseBtn, expandViewLegendColumn1HeaderTitle);
	}

	public void validateRecordErrorRateExpandViewLegendHeader2() {	 
		util.validateExpandViewTexts(page, recordErrorRateLegendTitle2 ,recordErrorRateExpand, expandViewCloseBtn, expandViewLegendColumn2HeaderTitle);
	}

	public void validateRecordErrorRateExpandViewLegendHeader3() {	 
		util.validateExpandViewTexts(page, recordErrorRateLegendTitle3 ,recordErrorRateExpand, expandViewCloseBtn, expandViewLegendColumn3HeaderTitle);
	}

	public void validateRecordErrorRateExpandViewZoomIn() {
		util.ExpandViewZoomInBtn(page, expandViewZoomInBtn, recordErrorRateExpand, expandViewCloseBtn, expandViewXaxisValues);
	}

	public void validateRecordErrorRateExpandViewZoomOut() {
		util.ExpandViewZoomOutBtn(page, expandViewZoomInBtn, recordErrorRateExpand, expandViewCloseBtn, expandViewZoomOutBtn, expandViewXaxisValues);
	}

	public void validateRecordErrorRateExpandViewWidgetDragDrop() {
		util.ExpandViewWidgetDragDrop(page, recordErrorRateExpand, expandViewCloseBtn, expandViewXaxisLines, expandViewZoomOutBtn, expandViewXaxisValues);
	}
	
	
/*
 * Record Error Total Graph
 */

	public void validateRecordErrorTotalGraphTitle(String expectedTitle) {		  
		String actualTitle = page.locator(recordErrorTotalGraphTitle).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateRecordErrorTotalZoomInBtn() {		  
		util.graphZoomIn(page, recordErrorTotalZoomIn, recordErrorTotalXaxisValues);
	}

	public void validateRecordErrorTotalZoomOutBtn() {
		util.graphZoomOut(page, recordErrorTotalZoomIn, recordErrorTotalZoomOut, recordErrorTotalXaxisValues);
	}

	public void validateRecordErrorTotalGraphXaxisTitle(String expectedTitle) {	 
		String actualTitle = page.locator(recordErrorTotalXaxis).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateRecordErrorTotalGraphYaxisTitle(String expectedTitle) {	 
		String actualTitle = page.locator(recordErrorTotalYaxis).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateRecordErrorTotalGraphLegendTitle1(String expectedTitle) {
		String actualTitle = page.locator(recordErrorTotalLegendTitle1).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateRecordErrorTotalGraphLegendTitle2(String expectedTitle) {	 
		String actualTitle = page.locator(recordErrorTotalLegendTitle2).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateRecordErrorTotalGraphLegendTitle3(String expectedTitle) {	 
		String actualTitle = page.locator(recordErrorTotalLegendTitle3).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateRecordErrorTotalToolTipTitle() {	 
		util.validateWidgetToolTips(page, recordErrorTotalXaxisLine, recordErrorTotalToolTipTitle);
	}

	public void validateRecordErrorTotalDragAndDrop() {
		util.graphZoomInByDragAndDrop(page, recordErrorTotalXaxisLine, recordErrorTotalZoomOut, recordErrorTotalXaxisValues);
	}
	public void validateRecordErrorTotalExpandViewXAxisTitle() { 
		util.validateExpandViewTexts(page, recordErrorTotalXaxis, recordErrorTotalExpand, expandViewCloseBtn, expandViewXaxisTitle);
	}

	public void validateRecordErrorTotalExpandViewYAxisTitle() {
		util.validateExpandViewTexts(page, recordErrorTotalYaxis, recordErrorTotalExpand, expandViewCloseBtn, expandViewYaxisTitle);
	}

	public void validateRecordErrorTotalExpandViewWidgetTitle() {
		util.validateExpandViewTexts(page, recordErrorTotalGraphTitle, recordErrorTotalExpand, expandViewCloseBtn, expandViewWidgetTitle);
	}

	public void validateRecordErrorTotalExpandViewLegendHeader1() {	 
		util.validateExpandViewTexts(page, recordErrorTotalLegendTitle1, recordErrorTotalExpand, expandViewCloseBtn, expandViewLegendColumn1HeaderTitle);
	}

	public void validateRecordErrorTotalExpandViewLegendHeader2() {	 
		util.validateExpandViewTexts(page, recordErrorTotalLegendTitle2 ,recordErrorTotalExpand, expandViewCloseBtn, expandViewLegendColumn2HeaderTitle);
	}

	public void validateRecordErrorTotalExpandViewLegendHeader3() {	 
		util.validateExpandViewTexts(page, recordErrorTotalLegendTitle3 ,recordErrorTotalExpand, expandViewCloseBtn, expandViewLegendColumn3HeaderTitle);
	}

	public void validateRecordErrorTotalExpandViewZoomIn() {
		util.ExpandViewZoomInBtn(page, expandViewZoomInBtn, recordErrorTotalExpand, expandViewCloseBtn, expandViewXaxisValues);
	}

	public void validateRecordErrorTotalExpandViewZoomOut() {
		util.ExpandViewZoomOutBtn(page, expandViewZoomInBtn, recordErrorTotalExpand, expandViewCloseBtn, expandViewZoomOutBtn, expandViewXaxisValues);
	}

	public void validateRecordErrorTotalExpandViewWidgetDragDrop() {
		util.ExpandViewWidgetDragDrop(page, recordErrorTotalExpand, expandViewCloseBtn, expandViewXaxisLines, expandViewZoomOutBtn, expandViewXaxisValues);
	}
	
	
/*
 * Calendar
 */
		
	public void validateTheCustomTimeLine(String period) {
		util.validateCustomTimeLine(page, recordSendRateXaxisValues, period, WidgetXValues(period));
	}
		
	public void validateXaxisValuesForKafkaProducerTopicPage() {
		util.validateTheGraphdisplayingTheDataAsPerGivenTimeLines(page, recordSendRateXaxisValues, calenderView, allWidgetXValues());
	}
	
	public List<String> allWidgetXValues() {
		ArrayList<String> xValue = new ArrayList<String>();
		xValue.add(recordSendRateXaxisValues);
		xValue.add(recordSendTotalXaxisValues);
		xValue.add(recordErrorRateXaxisValues);
		xValue.add(recordErrorTotalXaxisValues);
		return xValue;
	}
}
