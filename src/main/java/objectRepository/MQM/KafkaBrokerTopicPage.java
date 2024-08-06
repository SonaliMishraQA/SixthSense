package objectRepository.MQM;

import java.util.ArrayList;
import java.util.List;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;

import genericUtilities.ExcelUtility;
import genericUtilities.GenericMethods;

public class KafkaBrokerTopicPage 
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
	private String brokerTab = "xpath = //div[@class='navtab']/div[@class='item' and position()=4]/child::div";
	private String topicTab = "xpath = //div[@class='brokerTabSelector']/child::div[@class][position()=1]";
	private String brokerTitle = "xpath = //div[@class='kafkaDropdownSelector']/descendant::div[@class='heading'][position()=2]";
	private String selectBrokerDropDown = "#btn-arrow-down-kafka-select-producer";
	private String selectOptionBroker = "#kafka-select-producer-0-single";
	private String activeTickMark = "xpath = //input[@id='input-search-sel-mq-select-participant']/parent::div/following-sibling::div/child::div[@class='option']/span/span";
	private String nameSearchResults = "xpath = //input[@id='input-search-sel-mq-select-participant']/parent::div/following-sibling::div/child::div[@class='option'][1]";
	private String topicTitle = "xpath = //div[@class='kafkaDropdownSelector']/descendant::div[@class='heading'][position()=1]";
	private String selectTopicDropDown = "#btn-arrow-down-mq-select-participant";
	
	
//Bytes in per second Graph
	private String bytesInPerSecondGraphTitle = "xpath = //div[@class='brokerTabSelector']/child::div[@class='kafkaTabItem kafkaActiveTab']/child::span[.='Topic']/ancestor::div[@class='kafkaBrokerActions']/following-sibling::div//div[.='Bytes in per second ']";
	private String bytesInPerSecondXaxis = "xpath = //div[.='Bytes in per second ']/following-sibling::div/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-title-text chart-lables']";
	private String bytesInPerSecondYaxis = "xpath = //div[.='Bytes in per second ']/following-sibling::div/descendant::*[name()='text' and @class='apexcharts-text apexcharts-yaxis-title-text chart-lables']";
	private String bytesInPerSecondXaxisLine = "xpath = //div[.='Bytes in per second ']/following-sibling::div/descendant::*[name()='line' and @class='apexcharts-xaxis-tick']";
	private String bytesInPerSecondXaxisValues = "xpath = //div[@id='apexchartschart-kafka_broker_topic_bytes_in_per_sec']/descendant::*[name()='tspan' and contains(.,'-')]";
	private String bytesInPerSecondZoomOut = "xpath = (//div[.='Bytes in per second ']/descendant::span[@class='icon-class'])[position()=1]";
	private String bytesInPerSecondZoomIn = "xpath = (//div[.='Bytes in per second ']/descendant::span[@class='icon-class'])[position()=2]";
	private String bytesInPerSecondLegendTitle1 = "xpath = (//div[.='Bytes in per second ']/following-sibling::div/descendant::div[@class='header-heading'])[position()=1]";
	private String bytesInPerSecondLegendTitle2 = "xpath = (//div[.='Bytes in per second ']/following-sibling::div/descendant::div[@class='header-heading'])[position()=2]";
	private String bytesInPerSecondLegendTitle3 = "xpath = (//div[.='Bytes in per second ']/following-sibling::div/descendant::div[@class='header-heading'])[position()=3]";
	private String bytesInPerSecondToolTipTitle = "xpath = //div[.='Bytes in per second ']/following-sibling::div/descendant::div[@class='apexcharts-tooltip-title']";

//Bytes in per second mean value Graph
	private String bytesInPerSecondMeanValueGraphTitle = "xpath = //div[@class='brokerTabSelector']/child::div[@class='kafkaTabItem kafkaActiveTab']/child::span[.='Topic']/ancestor::div[@class='kafkaBrokerActions']/following-sibling::div//div[.='Bytes in per second mean value ']";
	private String bytesInPerSecondMeanValueXaxis = "xpath = //div[.='Bytes in per second mean value ']/following-sibling::div/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-title-text chart-lables']";
	private String bytesInPerSecondMeanValueYaxis = "xpath = //div[.='Bytes in per second mean value ']/following-sibling::div/descendant::*[name()='text' and @class='apexcharts-text apexcharts-yaxis-title-text chart-lables']";
	private String bytesInPerSecondMeanValueXaxisLine = "xpath = //div[.='Bytes in per second mean value ']/following-sibling::div/descendant::*[name()='line' and @class='apexcharts-xaxis-tick']";
	private String bytesInPerSecondMeanValueXaxisValues = "xpath = //div[@id='apexchartschart-kafka_broker_topic_bytes_in_per_sec_mean_rate']/descendant::*[name()='tspan' and contains(.,'-')]";
	private String bytesInPerSecondMeanValueZoomOut = "xpath = (//div[.='Bytes in per second mean value ']/descendant::span[@class='icon-class'])[position()=1]";
	private String bytesInPerSecondMeanValueZoomIn = "xpath = (//div[.='Bytes in per second mean value ']/descendant::span[@class='icon-class'])[position()=2]";
	private String bytesInPerSecondMeanValueLegendTitle1 = "xpath = (//div[.='Bytes in per second mean value ']/following-sibling::div/descendant::div[@class='header-heading'])[position()=1]";
	private String bytesInPerSecondMeanValueLegendTitle2 = "xpath = (//div[.='Bytes in per second mean value ']/following-sibling::div/descendant::div[@class='header-heading'])[position()=2]";
	private String bytesInPerSecondMeanValueLegendTitle3 = "xpath = (//div[.='Bytes in per second mean value ']/following-sibling::div/descendant::div[@class='header-heading'])[position()=3]";
	private String bytesInPerSecondMeanValueToolTipTitle = "xpath = //div[.='Bytes in per second mean value ']/following-sibling::div/descendant::div[@class='apexcharts-tooltip-title']";

//Bytes out per second Graph
	private String bytesOutPerSecondGraphTitle = "xpath = //div[@class='brokerTabSelector']/child::div[@class='kafkaTabItem kafkaActiveTab']/child::span[.='Topic']/ancestor::div[@class='kafkaBrokerActions']/following-sibling::div//div[.='Bytes out per second ']";
	private String bytesOutPerSecondXaxis = "xpath = //div[.='Bytes out per second ']/following-sibling::div/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-title-text chart-lables']";
	private String bytesOutPerSecondYaxis = "xpath = //div[.='Bytes out per second ']/following-sibling::div/descendant::*[name()='text' and @class='apexcharts-text apexcharts-yaxis-title-text chart-lables']";
	private String bytesOutPerSecondXaxisLine = "xpath = //div[.='Bytes out per second ']/following-sibling::div/descendant::*[name()='line' and @class='apexcharts-xaxis-tick']";
	private String bytesOutPerSecondXaxisValues = "xpath = //div[@id='apexchartschart-kafka_broker_topic_bytes_out_per_sec']/descendant::*[name()='tspan' and contains(.,'-')]";
	private String bytesOutPerSecondZoomOut = "xpath = (//div[.='Bytes out per second ']/descendant::span[@class='icon-class'])[position()=1]";
	private String bytesOutPerSecondZoomIn = "xpath = (//div[.='Bytes out per second ']/descendant::span[@class='icon-class'])[position()=2]";
	private String bytesOutPerSecondLegendTitle1 = "xpath = (//div[.='Bytes out per second ']/following-sibling::div/descendant::div[@class='header-heading'])[position()=1]";
	private String bytesOutPerSecondLegendTitle2 = "xpath = (//div[.='Bytes out per second ']/following-sibling::div/descendant::div[@class='header-heading'])[position()=2]";
	private String bytesOutPerSecondLegendTitle3 = "xpath = (//div[.='Bytes out per second ']/following-sibling::div/descendant::div[@class='header-heading'])[position()=3]";
	private String bytesOutPerSecondToolTipTitle = "xpath = //div[.='Bytes out per second ']/following-sibling::div/descendant::div[@class='apexcharts-tooltip-title']";
	
//Bytes out per second mean value Graph
	private String bytesOutPerSecondMeanValueGraphTitle = "xpath = //div[@class='brokerTabSelector']/child::div[@class='kafkaTabItem kafkaActiveTab']/child::span[.='Topic']/ancestor::div[@class='kafkaBrokerActions']/following-sibling::div//div[.='Bytes out per second mean value ']";
	private String bytesOutPerSecondMeanValueXaxis = "xpath = //div[.='Bytes out per second mean value ']/following-sibling::div/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-title-text chart-lables']";
	private String bytesOutPerSecondMeanValueYaxis = "xpath = //div[.='Bytes out per second mean value ']/following-sibling::div/descendant::*[name()='text' and @class='apexcharts-text apexcharts-yaxis-title-text chart-lables']";
	private String bytesOutPerSecondMeanValueXaxisLine = "xpath = //div[.='Bytes out per second mean value ']/following-sibling::div/descendant::*[name()='line' and @class='apexcharts-xaxis-tick']";
	private String bytesOutPerSecondMeanValueXaxisValues = "xpath = //div[@id='apexchartschart-kafka_broker_topic_bytes_out_per_sec_mean_rate']/descendant::*[name()='tspan' and contains(.,'-')]";
	private String bytesOutPerSecondMeanValueZoomOut = "xpath = (//div[.='Bytes out per second mean value ']/descendant::span[@class='icon-class'])[position()=1]";
	private String bytesOutPerSecondMeanValueZoomIn = "xpath = (//div[.='Bytes out per second mean value ']/descendant::span[@class='icon-class'])[position()=2]";
	private String bytesOutPerSecondMeanValueLegendTitle1 = "xpath = (//div[.='Bytes out per second mean value ']/following-sibling::div/descendant::div[@class='header-heading'])[position()=1]";
	private String bytesOutPerSecondMeanValueLegendTitle2 = "xpath = (//div[.='Bytes out per second mean value ']/following-sibling::div/descendant::div[@class='header-heading'])[position()=2]";
	private String bytesOutPerSecondMeanValueLegendTitle3 = "xpath = (//div[.='Bytes out per second mean value ']/following-sibling::div/descendant::div[@class='header-heading'])[position()=3]";
	private String bytesOutPerSecondMeanValueToolTipTitle = "xpath = //div[.='Bytes out per second mean value ']/following-sibling::div/descendant::div[@class='apexcharts-tooltip-title']";
	
//Message count Graph
	private String messageCountGraphTitle = "xpath = //div[@class='brokerTabSelector']/child::div[@class='kafkaTabItem kafkaActiveTab']/child::span[.='Topic']/ancestor::div[@class='kafkaBrokerActions']/following-sibling::div//div[.='Message count ']";
	private String messageCountXaxis = "xpath = //div[.='Message count ']/following-sibling::div/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-title-text chart-lables']";
	private String messageCountYaxis = "xpath = //div[.='Message count ']/following-sibling::div/descendant::*[name()='text' and @class='apexcharts-text apexcharts-yaxis-title-text chart-lables']";
	private String messageCountXaxisLine = "xpath = //div[.='Message count ']/following-sibling::div/descendant::*[name()='line' and @class='apexcharts-xaxis-tick']";
	private String messageCountXaxisValues = "xpath =//div[@id='apexchartschart-kafka_messages_in_per_sec_count_topic']/descendant::*[name()='tspan' and contains(.,'-')]";
	private String messageCountZoomOut = "xpath = (//div[.='Message count ']/descendant::span[@class='icon-class'])[position()=1]";
	private String messageCountZoomIn = "xpath = (//div[.='Message count ']/descendant::span[@class='icon-class'])[position()=2]";
	private String messageCountLegendTitle1 = "xpath = (//div[.='Message count ']/following-sibling::div/descendant::div[@class='header-heading'])[position()=1]";
	private String messageCountLegendTitle2 = "xpath = (//div[.='Message count ']/following-sibling::div/descendant::div[@class='header-heading'])[position()=2]";
	private String messageCountLegendTitle3 = "xpath = (//div[.='Message count ']/following-sibling::div/descendant::div[@class='header-heading'])[position()=3]";
	private String messageCountToolTipTitle = "xpath = //div[.='Message count ']/following-sibling::div/descendant::div[@class='apexcharts-tooltip-title']";
	
//Expand Button
	private String bytesInPerSecondExpand = "xpath = (//div[.='Bytes in per second ']/descendant::span[@class='icon-class'])[position()=3]";
	private String bytesInPerSecondMeanValueExpand = "xpath = (//div[.='Bytes in per second mean value ']/descendant::span[@class='icon-class'])[position()=3]";	
	private String bytesOutPerSecondExpand = "xpath = (//div[.='Bytes out per second ']/descendant::span[@class='icon-class'])[position()=3]";	
	private String bytesOutPerSecondMeanValueExpand = "xpath = (//div[.='Bytes out per second mean value ']/descendant::span[@class='icon-class'])[position()=3]";	
	private String messageCountExpand = "xpath = (//div[.='Message count ']/descendant::span[@class='icon-class'])[position()=3]";	

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
	
	public KafkaBrokerTopicPage(Page page) {
		this.page = page;
	}

	public void navigateToKafka(String messageQueue) {
		util.selectTheOptionFromDropDownBySearch(page, selectMessageQueueDropdown, selectSearchFieldMQDropdown, messageQueue, selectMQDropdown);
		page.waitForLoadState(LoadState.NETWORKIDLE);
	}

	public void selectServiceName(String application) {
		 util.selectTheOptionFromDropDownBySearch(page, selectServiceNameDropdown, selectSearchFieldServiceNameDropdown, application, searchedApplication); 
		 page.waitForLoadState(LoadState.NETWORKIDLE); }
	 

	public void navigateToBrokerTab() {
		page.locator(brokerTab).click();
		page.waitForLoadState(LoadState.NETWORKIDLE);
	}

	public void validateBrokerTitle(String expectedTitle) {
		String actualTitle = page.locator(brokerTab).textContent().trim();
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
	
	public void validateBrokerSelectTitle(String expectedTitle) {
		String actualTitle = page.locator(brokerTitle).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}
	
	public void validateBrokerSelectDropDown() {
		util.selectTheOptionFromDropDown(page, selectBrokerDropDown, selectOptionBroker);
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
 * Bytes in per second Graph
 */

	public void validateBytesInPerSecondGraphTitle(String expectedTitle) {		  
		String actualTitle = page.locator(bytesInPerSecondGraphTitle).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateBytesInPerSecondZoomInBtn() {		  
		util.graphZoomIn(page, bytesInPerSecondZoomIn, bytesInPerSecondXaxisValues);
	}

	public void validateBytesInPerSecondZoomOutBtn() {
		util.graphZoomOut(page, bytesInPerSecondZoomIn, bytesInPerSecondZoomOut, bytesInPerSecondXaxisValues);
	}

	public void validateBytesInPerSecondGraphXaxisTitle(String expectedTitle) {	 
		String actualTitle = page.locator(bytesInPerSecondXaxis).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateBytesInPerSecondGraphYaxisTitle(String expectedTitle) {	 
		String actualTitle = page.locator(bytesInPerSecondYaxis).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateBytesInPerSecondGraphLegendTitle1(String expectedTitle) {
		String actualTitle = page.locator(bytesInPerSecondLegendTitle1).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateBytesInPerSecondGraphLegendTitle2(String expectedTitle) {	 
		String actualTitle = page.locator(bytesInPerSecondLegendTitle2).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateBytesInPerSecondGraphLegendTitle3(String expectedTitle) {	 
		String actualTitle = page.locator(bytesInPerSecondLegendTitle3).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateBytesInPerSecondToolTipTitle() {
		page.waitForTimeout(2000);
		util.validateWidgetToolTips(page, bytesInPerSecondXaxisLine, bytesInPerSecondToolTipTitle);
	}

	public void validateBytesInPerSecondDragAndDrop() {
		page.waitForTimeout(2000);
		util.graphZoomInByDragAndDrop(page, bytesInPerSecondXaxisLine, bytesInPerSecondZoomOut, bytesInPerSecondXaxisValues);
	}
	public void validateBytesInPerSecondExpandViewXAxisTitle() { 
		util.validateExpandViewTexts(page, bytesInPerSecondXaxis, bytesInPerSecondExpand, expandViewCloseBtn, expandViewXaxisTitle);
	}

	public void validateBytesInPerSecondExpandViewYAxisTitle() {
		util.validateExpandViewTexts(page, bytesInPerSecondYaxis, bytesInPerSecondExpand, expandViewCloseBtn, expandViewYaxisTitle);
	}

	public void validateBytesInPerSecondExpandViewWidgetTitle() {
		util.validateExpandViewTexts(page, bytesInPerSecondGraphTitle, bytesInPerSecondExpand, expandViewCloseBtn, expandViewWidgetTitle);
	}

	public void validateBytesInPerSecondExpandViewLegendHeader1() {	 
		util.validateExpandViewTexts(page, bytesInPerSecondLegendTitle1, bytesInPerSecondExpand, expandViewCloseBtn, expandViewLegendColumn1HeaderTitle);
	}

	public void validateBytesInPerSecondExpandViewLegendHeader2() {	 
		util.validateExpandViewTexts(page, bytesInPerSecondLegendTitle2 ,bytesInPerSecondExpand, expandViewCloseBtn, expandViewLegendColumn2HeaderTitle);
	}

	public void validateBytesInPerSecondExpandViewLegendHeader3() {	 
		util.validateExpandViewTexts(page, bytesInPerSecondLegendTitle3 ,bytesInPerSecondExpand, expandViewCloseBtn, expandViewLegendColumn3HeaderTitle);
	}

	public void validateBytesInPerSecondExpandViewZoomIn() {
		util.ExpandViewZoomInBtn(page, expandViewZoomInBtn, bytesInPerSecondExpand, expandViewCloseBtn, expandViewXaxisValues);
	}

	public void validateBytesInPerSecondExpandViewZoomOut() {
		util.ExpandViewZoomOutBtn(page, expandViewZoomInBtn, bytesInPerSecondExpand, expandViewCloseBtn, expandViewZoomOutBtn, expandViewXaxisValues);
	}

	public void validateBytesInPerSecondExpandViewWidgetDragDrop() {
		util.ExpandViewWidgetDragDrop(page, bytesInPerSecondExpand, expandViewCloseBtn, expandViewXaxisLines, expandViewZoomOutBtn, expandViewXaxisValues);
	}
		
/*
 * Bytes in per second mean value Graph
 */

	public void validateBytesInPerSecondMeanValueGraphTitle(String expectedTitle) {		  
		String actualTitle = page.locator(bytesInPerSecondMeanValueGraphTitle).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateBytesInPerSecondMeanValueZoomInBtn() {	
		page.waitForTimeout(2000);
		util.graphZoomIn(page, bytesInPerSecondMeanValueZoomIn, bytesInPerSecondMeanValueXaxisValues);
	}

	public void validateBytesInPerSecondMeanValueZoomOutBtn() {
		util.graphZoomOut(page, bytesInPerSecondMeanValueZoomIn, bytesInPerSecondMeanValueZoomOut, bytesInPerSecondMeanValueXaxisValues);
	}

	public void validateBytesInPerSecondMeanValueGraphXaxisTitle(String expectedTitle) {	 
		String actualTitle = page.locator(bytesInPerSecondMeanValueXaxis).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateBytesInPerSecondMeanValueGraphYaxisTitle(String expectedTitle) {	 
		String actualTitle = page.locator(bytesInPerSecondMeanValueYaxis).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateBytesInPerSecondMeanValueGraphLegendTitle1(String expectedTitle) {
		String actualTitle = page.locator(bytesInPerSecondMeanValueLegendTitle1).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateBytesInPerSecondMeanValueGraphLegendTitle2(String expectedTitle) {	 
		String actualTitle = page.locator(bytesInPerSecondMeanValueLegendTitle2).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateBytesInPerSecondMeanValueGraphLegendTitle3(String expectedTitle) {	 
		String actualTitle = page.locator(bytesInPerSecondMeanValueLegendTitle3).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateBytesInPerSecondMeanValueToolTipTitle() {	 
		util.validateWidgetToolTips(page, bytesInPerSecondMeanValueXaxisLine, bytesInPerSecondMeanValueToolTipTitle);
	}

	public void validateBytesInPerSecondMeanValueDragAndDrop() {
		util.graphZoomInByDragAndDrop(page, bytesInPerSecondMeanValueXaxisLine, bytesInPerSecondMeanValueZoomOut, bytesInPerSecondMeanValueXaxisValues);
	}
	public void validateBytesInPerSecondMeanValueExpandViewXAxisTitle() { 
		page.waitForTimeout(2000);
		util.validateExpandViewTexts(page, bytesInPerSecondMeanValueXaxis, bytesInPerSecondMeanValueExpand, expandViewCloseBtn, expandViewXaxisTitle);
	}

	public void validateBytesInPerSecondMeanValueExpandViewYAxisTitle() {
		page.waitForTimeout(2000);
		util.validateExpandViewTexts(page, bytesInPerSecondMeanValueYaxis, bytesInPerSecondMeanValueExpand, expandViewCloseBtn, expandViewYaxisTitle);
	}

	public void validateBytesInPerSecondMeanValueExpandViewWidgetTitle() {
		util.validateExpandViewTexts(page, bytesInPerSecondMeanValueGraphTitle, bytesInPerSecondMeanValueExpand, expandViewCloseBtn, expandViewWidgetTitle);
	}

	public void validateBytesInPerSecondMeanValueExpandViewLegendHeader1() {	 
		util.validateExpandViewTexts(page, bytesInPerSecondMeanValueLegendTitle1, bytesInPerSecondMeanValueExpand, expandViewCloseBtn, expandViewLegendColumn1HeaderTitle);
	}

	public void validateBytesInPerSecondMeanValueExpandViewLegendHeader2() {	 
		util.validateExpandViewTexts(page, bytesInPerSecondMeanValueLegendTitle2 ,bytesInPerSecondMeanValueExpand, expandViewCloseBtn, expandViewLegendColumn2HeaderTitle);
	}

	public void validateBytesInPerSecondMeanValueExpandViewLegendHeader3() {	 
		util.validateExpandViewTexts(page, bytesInPerSecondMeanValueLegendTitle3 ,bytesInPerSecondMeanValueExpand, expandViewCloseBtn, expandViewLegendColumn3HeaderTitle);
	}

	public void validateBytesInPerSecondMeanValueExpandViewZoomIn() {
		util.ExpandViewZoomInBtn(page, expandViewZoomInBtn, bytesInPerSecondMeanValueExpand, expandViewCloseBtn, expandViewXaxisValues);
	}

	public void validateBytesInPerSecondMeanValueExpandViewZoomOut() {
		util.ExpandViewZoomOutBtn(page, expandViewZoomInBtn, bytesInPerSecondMeanValueExpand, expandViewCloseBtn, expandViewZoomOutBtn, expandViewXaxisValues);
	}

	public void validateBytesInPerSecondMeanValueExpandViewWidgetDragDrop() {
		util.ExpandViewWidgetDragDrop(page, bytesInPerSecondMeanValueExpand, expandViewCloseBtn, expandViewXaxisLines, expandViewZoomOutBtn, expandViewXaxisValues);
	}
	
/*
 * Bytes out per second Graph
 */

	public void validateBytesOutPerSecondGraphTitle(String expectedTitle) {		  
		String actualTitle = page.locator(bytesOutPerSecondGraphTitle).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateBytesOutPerSecondZoomInBtn() {		  
		util.graphZoomIn(page, bytesOutPerSecondZoomIn, bytesOutPerSecondXaxisValues);
	}

	public void validateBytesOutPerSecondZoomOutBtn() {
		util.graphZoomOut(page, bytesOutPerSecondZoomIn, bytesOutPerSecondZoomOut, bytesOutPerSecondXaxisValues);
	}

	public void validateBytesOutPerSecondGraphXaxisTitle(String expectedTitle) {	 
		String actualTitle = page.locator(bytesOutPerSecondXaxis).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateBytesOutPerSecondGraphYaxisTitle(String expectedTitle) {	 
		String actualTitle = page.locator(bytesOutPerSecondYaxis).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateBytesOutPerSecondGraphLegendTitle1(String expectedTitle) {
		String actualTitle = page.locator(bytesOutPerSecondLegendTitle1).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateBytesOutPerSecondGraphLegendTitle2(String expectedTitle) {	 
		String actualTitle = page.locator(bytesOutPerSecondLegendTitle2).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateBytesOutPerSecondGraphLegendTitle3(String expectedTitle) {	 
		String actualTitle = page.locator(bytesOutPerSecondLegendTitle3).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateBytesOutPerSecondToolTipTitle() {	 
		util.validateWidgetToolTips(page, bytesOutPerSecondXaxisLine, bytesOutPerSecondToolTipTitle);
	}

	public void validateBytesOutPerSecondDragAndDrop() {
		util.graphZoomInByDragAndDrop(page, bytesOutPerSecondXaxisLine, bytesOutPerSecondZoomOut, bytesOutPerSecondXaxisValues);
	}
	public void validateBytesOutPerSecondExpandViewXAxisTitle() { 
		util.validateExpandViewTexts(page, bytesOutPerSecondXaxis, bytesOutPerSecondExpand, expandViewCloseBtn, expandViewXaxisTitle);
	}

	public void validateBytesOutPerSecondExpandViewYAxisTitle() {
		util.validateExpandViewTexts(page, bytesOutPerSecondYaxis, bytesOutPerSecondExpand, expandViewCloseBtn, expandViewYaxisTitle);
	}

	public void validateBytesOutPerSecondExpandViewWidgetTitle() {
		util.validateExpandViewTexts(page, bytesOutPerSecondGraphTitle, bytesOutPerSecondExpand, expandViewCloseBtn, expandViewWidgetTitle);
	}

	public void validateBytesOutPerSecondExpandViewLegendHeader1() {	 
		util.validateExpandViewTexts(page, bytesOutPerSecondLegendTitle1, bytesOutPerSecondExpand, expandViewCloseBtn, expandViewLegendColumn1HeaderTitle);
	}

	public void validateBytesOutPerSecondExpandViewLegendHeader2() {	 
		util.validateExpandViewTexts(page, bytesOutPerSecondLegendTitle2 ,bytesOutPerSecondExpand, expandViewCloseBtn, expandViewLegendColumn2HeaderTitle);
	}

	public void validateBytesOutPerSecondExpandViewLegendHeader3() {	 
		util.validateExpandViewTexts(page, bytesOutPerSecondLegendTitle3 ,bytesOutPerSecondExpand, expandViewCloseBtn, expandViewLegendColumn3HeaderTitle);
	}

	public void validateBytesOutPerSecondExpandViewZoomIn() {
		util.ExpandViewZoomInBtn(page, expandViewZoomInBtn, bytesOutPerSecondExpand, expandViewCloseBtn, expandViewXaxisValues);
	}

	public void validateBytesOutPerSecondExpandViewZoomOut() {
		util.ExpandViewZoomOutBtn(page, expandViewZoomInBtn, bytesOutPerSecondExpand, expandViewCloseBtn, expandViewZoomOutBtn, expandViewXaxisValues);
	}

	public void validateBytesOutPerSecondExpandViewWidgetDragDrop() {
		util.ExpandViewWidgetDragDrop(page, bytesOutPerSecondExpand, expandViewCloseBtn, expandViewXaxisLines, expandViewZoomOutBtn, expandViewXaxisValues);
	}
		
/*
 * Bytes out per second mean value Graph
 */

	public void validateBytesOutPerSecondMeanValueGraphTitle(String expectedTitle) {		  
		String actualTitle = page.locator(bytesOutPerSecondMeanValueGraphTitle).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateBytesOutPerSecondMeanValueZoomInBtn() {		  
		util.graphZoomIn(page, bytesOutPerSecondMeanValueZoomIn, bytesOutPerSecondMeanValueXaxisValues);
	}

	public void validateBytesOutPerSecondMeanValueZoomOutBtn() {
		util.graphZoomOut(page, bytesOutPerSecondMeanValueZoomIn, bytesOutPerSecondMeanValueZoomOut, bytesOutPerSecondMeanValueXaxisValues);
	}

	public void validateBytesOutPerSecondMeanValueGraphXaxisTitle(String expectedTitle) {	 
		String actualTitle = page.locator(bytesOutPerSecondMeanValueXaxis).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateBytesOutPerSecondMeanValueGraphYaxisTitle(String expectedTitle) {	 
		String actualTitle = page.locator(bytesOutPerSecondMeanValueYaxis).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateBytesOutPerSecondMeanValueGraphLegendTitle1(String expectedTitle) {
		String actualTitle = page.locator(bytesOutPerSecondMeanValueLegendTitle1).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateBytesOutPerSecondMeanValueGraphLegendTitle2(String expectedTitle) {	 
		String actualTitle = page.locator(bytesOutPerSecondMeanValueLegendTitle2).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateBytesOutPerSecondMeanValueGraphLegendTitle3(String expectedTitle) {	 
		String actualTitle = page.locator(bytesOutPerSecondMeanValueLegendTitle3).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateBytesOutPerSecondMeanValueToolTipTitle() {	 
		util.validateWidgetToolTips(page, bytesOutPerSecondMeanValueXaxisLine, bytesOutPerSecondMeanValueToolTipTitle);
	}

	public void validateBytesOutPerSecondMeanValueDragAndDrop() {
		util.graphZoomInByDragAndDrop(page, bytesOutPerSecondMeanValueXaxisLine, bytesOutPerSecondMeanValueZoomOut, bytesOutPerSecondMeanValueXaxisValues);
	}
	public void validateBytesOutPerSecondMeanValueExpandViewXAxisTitle() { 
		util.validateExpandViewTexts(page, bytesOutPerSecondMeanValueXaxis, bytesOutPerSecondMeanValueExpand, expandViewCloseBtn, expandViewXaxisTitle);
	}

	public void validateBytesOutPerSecondMeanValueExpandViewYAxisTitle() {
		util.validateExpandViewTexts(page, bytesOutPerSecondMeanValueYaxis, bytesOutPerSecondMeanValueExpand, expandViewCloseBtn, expandViewYaxisTitle);
	}

	public void validateBytesOutPerSecondMeanValueExpandViewWidgetTitle() {
		util.validateExpandViewTexts(page, bytesOutPerSecondMeanValueGraphTitle, bytesOutPerSecondMeanValueExpand, expandViewCloseBtn, expandViewWidgetTitle);
	}

	public void validateBytesOutPerSecondMeanValueExpandViewLegendHeader1() {	 
		util.validateExpandViewTexts(page, bytesOutPerSecondMeanValueLegendTitle1, bytesOutPerSecondMeanValueExpand, expandViewCloseBtn, expandViewLegendColumn1HeaderTitle);
	}

	public void validateBytesOutPerSecondMeanValueExpandViewLegendHeader2() {	 
		util.validateExpandViewTexts(page, bytesOutPerSecondMeanValueLegendTitle2 ,bytesOutPerSecondMeanValueExpand, expandViewCloseBtn, expandViewLegendColumn2HeaderTitle);
	}

	public void validateBytesOutPerSecondMeanValueExpandViewLegendHeader3() {	 
		util.validateExpandViewTexts(page, bytesOutPerSecondMeanValueLegendTitle3 ,bytesOutPerSecondMeanValueExpand, expandViewCloseBtn, expandViewLegendColumn3HeaderTitle);
	}

	public void validateBytesOutPerSecondMeanValueExpandViewZoomIn() {
		util.ExpandViewZoomInBtn(page, expandViewZoomInBtn, bytesOutPerSecondMeanValueExpand, expandViewCloseBtn, expandViewXaxisValues);
	}

	public void validateBytesOutPerSecondMeanValueExpandViewZoomOut() {
		util.ExpandViewZoomOutBtn(page, expandViewZoomInBtn, bytesOutPerSecondMeanValueExpand, expandViewCloseBtn, expandViewZoomOutBtn, expandViewXaxisValues);
	}

	public void validateBytesOutPerSecondMeanValueExpandViewWidgetDragDrop() {
		util.ExpandViewWidgetDragDrop(page, bytesOutPerSecondMeanValueExpand, expandViewCloseBtn, expandViewXaxisLines, expandViewZoomOutBtn, expandViewXaxisValues);
	}
	
/*
 * Message count Graph
 */

	public void validateMessageCountGraphTitle(String expectedTitle) {		  
		String actualTitle = page.locator(messageCountGraphTitle).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateMessageCountZoomInBtn() {		  
		util.graphZoomIn(page, messageCountZoomIn, messageCountXaxisValues);
	}

	public void validateMessageCountZoomOutBtn() {
		util.graphZoomOut(page, messageCountZoomIn, messageCountZoomOut, messageCountXaxisValues);
	}

	public void validateMessageCountGraphXaxisTitle(String expectedTitle) {	 
		String actualTitle = page.locator(messageCountXaxis).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateMessageCountGraphYaxisTitle(String expectedTitle) {	 
		String actualTitle = page.locator(messageCountYaxis).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateMessageCountGraphLegendTitle1(String expectedTitle) {
		String actualTitle = page.locator(messageCountLegendTitle1).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateMessageCountGraphLegendTitle2(String expectedTitle) {	 
		String actualTitle = page.locator(messageCountLegendTitle2).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateMessageCountGraphLegendTitle3(String expectedTitle) {	 
		String actualTitle = page.locator(messageCountLegendTitle3).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateMessageCountToolTipTitle() {	 
		util.validateWidgetToolTips(page, messageCountXaxisLine, messageCountToolTipTitle);
	}

	public void validateMessageCountDragAndDrop() {
		util.graphZoomInByDragAndDrop(page, messageCountXaxisLine, messageCountZoomOut, messageCountXaxisValues);
	}
	public void validateMessageCountExpandViewXAxisTitle() { 
		util.validateExpandViewTexts(page, messageCountXaxis, messageCountExpand, expandViewCloseBtn, expandViewXaxisTitle);
	}

	public void validateMessageCountExpandViewYAxisTitle() {
		util.validateExpandViewTexts(page, messageCountYaxis, messageCountExpand, expandViewCloseBtn, expandViewYaxisTitle);
	}

	public void validateMessageCountExpandViewWidgetTitle() {
		util.validateExpandViewTexts(page, messageCountGraphTitle, messageCountExpand, expandViewCloseBtn, expandViewWidgetTitle);
	}

	public void validateMessageCountExpandViewLegendHeader1() {	 
		util.validateExpandViewTexts(page, messageCountLegendTitle1, messageCountExpand, expandViewCloseBtn, expandViewLegendColumn1HeaderTitle);
	}

	public void validateMessageCountExpandViewLegendHeader2() {	 
		util.validateExpandViewTexts(page, messageCountLegendTitle2 ,messageCountExpand, expandViewCloseBtn, expandViewLegendColumn2HeaderTitle);
	}

	public void validateMessageCountExpandViewLegendHeader3() {	 
		util.validateExpandViewTexts(page, messageCountLegendTitle3 ,messageCountExpand, expandViewCloseBtn, expandViewLegendColumn3HeaderTitle);
	}

	public void validateMessageCountExpandViewZoomIn() {
		util.ExpandViewZoomInBtn(page, expandViewZoomInBtn, messageCountExpand, expandViewCloseBtn, expandViewXaxisValues);
	}

	public void validateMessageCountExpandViewZoomOut() {
		util.ExpandViewZoomOutBtn(page, expandViewZoomInBtn, messageCountExpand, expandViewCloseBtn, expandViewZoomOutBtn, expandViewXaxisValues);
	}

	public void validateMessageCountExpandViewWidgetDragDrop() {
		util.ExpandViewWidgetDragDrop(page, messageCountExpand, expandViewCloseBtn, expandViewXaxisLines, expandViewZoomOutBtn, expandViewXaxisValues);
	}
	
		
/*
 * Calendar
 */
		
	public void validateTheCustomTimeLine(String period) {
		util.validateCustomTimeLine(page, bytesInPerSecondXaxisValues, period, WidgetXValues(period));
	}
		
	public void validateXaxisValuesForKafkaBrokerTopicPage() {
		util.validateTheGraphdisplayingTheDataAsPerGivenTimeLines(page, bytesInPerSecondXaxisValues, calenderView, allWidgetXValues());
	}
	
	public List<String> allWidgetXValues() {
		ArrayList<String> xValue = new ArrayList<String>();
		xValue.add(bytesInPerSecondXaxisValues);
		xValue.add(bytesInPerSecondMeanValueXaxisValues);
		xValue.add(bytesOutPerSecondXaxisValues);
		xValue.add(bytesOutPerSecondMeanValueXaxisValues);
		xValue.add(messageCountXaxisValues);
		return xValue;
	}
	
}
