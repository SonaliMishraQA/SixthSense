package objectRepository.MQM;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import genericUtilities.ExcelUtility;
import genericUtilities.GenericMethods;

import java.util.ArrayList;
import java.util.List;

import com.microsoft.playwright.options.LoadState;

public class KafkaConsumerPartitionMetricsPage
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
	private String partitionMetricsTab = "xpath = //div[@class='consumerTabSelector']/child::div[@class][position()=1]";
	private String consumerTitle = "xpath = //div[@class='kafkaConsumerDropdown']/descendant::div[@class='heading']";
	private String selectNameDropDown = "#btn-arrow-down-kafka-select-consumer";
	private String activeTickMark = "xpath = //input[@id='input-search-sel-kafka-select-consumer']/parent::div/following-sibling::div/child::div[@class='option']/span/span";
	private String nameSearchResults = "xpath = //input[@id='input-search-sel-kafka-select-consumer']/parent::div/following-sibling::div/child::div[@class='option'][1]";
	
//Lag Graph 
	private String lagGraphTitle = "xpath = //div[@class='consumerTabSelector']/child::div[@class='kafkaTabItem kafkaActiveTab']/child::span[.='Partition metrics']/ancestor::div[@class='kafkaConsumerActions']/following-sibling::div//div[.='Lag ']";
	private String lagXaxis = "xpath = //div[.='Lag ']/following-sibling::div/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-title-text chart-lables']";
	private String lagYaxis = "xpath = //div[.='Lag ']/following-sibling::div/descendant::*[name()='text' and @class='apexcharts-text apexcharts-yaxis-title-text chart-lables']";
	private String lagXaxisLine = "xpath = //div[.='Lag ']/following-sibling::div/descendant::*[name()='line' and @class='apexcharts-xaxis-tick']";
	private String lagXaxisValues = "xpath =//div[@id='apexchartschart-kafka_consumer_records_lag']/descendant::*[name()='tspan' and contains(.,'-')]";
	private String lagZoomOut = "xpath = (//div[.='Lag ']/descendant::span[@class='icon-class'])[position()=1]";
	private String lagZoomIn = "xpath = (//div[.='Lag ']/descendant::span[@class='icon-class'])[position()=2]";
	private String lagLegendTitle1 = "xpath = (//div[.='Lag ']/following-sibling::div/descendant::div[@class='header-heading'])[position()=1]";
	private String lagLegendTitle2 = "xpath = (//div[.='Lag ']/following-sibling::div/descendant::div[@class='header-heading'])[position()=2]";
	private String lagLegendTitle3 = "xpath = (//div[.='Lag ']/following-sibling::div/descendant::div[@class='header-heading'])[position()=3]";
	private String lagToolTipTitle = "xpath = //div[.='Lag ']/following-sibling::div/descendant::div[@class='apexcharts-tooltip-title']";
	

//Lead Graph 
	private String leadGraphTitle = "xpath = //div[@class='consumerTabSelector']/child::div[@class='kafkaTabItem kafkaActiveTab']/child::span[.='Partition metrics']/ancestor::div[@class='kafkaConsumerActions']/following-sibling::div//div[.='Lead ']";
	private String leadXaxis = "xpath = //div[.='Lead ']/following-sibling::div/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-title-text chart-lables']";
	private String leadYaxis = "xpath = //div[.='Lead ']/following-sibling::div/descendant::*[name()='text' and @class='apexcharts-text apexcharts-yaxis-title-text chart-lables']";
	private String leadXaxisLine = "xpath = //div[.='Lead ']/following-sibling::div/descendant::*[name()='line' and @class='apexcharts-xaxis-tick']";
	private String leadXaxisValues = "xpath =//div[@id='apexchartschart-kafka_consumer_records_lead']/descendant::*[name()='tspan' and contains(.,'-')]";
	private String leadZoomOut = "xpath = (//div[.='Lead ']/descendant::span[@class='icon-class'])[position()=1]";
	private String leadZoomIn = "xpath = (//div[.='Lead ']/descendant::span[@class='icon-class'])[position()=2]";
	private String leadLegendTitle1 = "xpath = (//div[.='Lead ']/following-sibling::div/descendant::div[@class='header-heading'])[position()=1]";
	private String leadLegendTitle2 = "xpath = (//div[.='Lead ']/following-sibling::div/descendant::div[@class='header-heading'])[position()=2]";
	private String leadLegendTitle3 = "xpath = (//div[.='Lead ']/following-sibling::div/descendant::div[@class='header-heading'])[position()=3]";
	private String leadToolTipTitle = "xpath = //div[.='Lead ']/following-sibling::div/descendant::div[@class='apexcharts-tooltip-title']";
	
//Expand Button
	private String lagExpand = "xpath = (//div[.='Lag ']/descendant::span[@class='icon-class'])[position()=3]";
	private String leadExpand = "xpath = (//div[.='Lead ']/descendant::span[@class='icon-class'])[position()=3]";	

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
	

	public KafkaConsumerPartitionMetricsPage(Page page) {
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
 * Partition Metrics Tab
 */

	public void validatePartitionMetricsTabTitle(String expectedTitle) {
		String actualTitle = page.locator(partitionMetricsTab).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}
	
/*
 * Lag Graph
 */

	public void validateLagGraphTitle(String expectedTitle) {		  
		String actualTitle = page.locator(lagGraphTitle).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateLagZoomInBtn() {		  
		util.graphZoomIn(page, lagZoomIn, lagXaxisValues);
	}

	public void validateLagZoomOutBtn() {
		util.graphZoomOut(page, lagZoomIn, lagZoomOut, lagXaxisValues);
	}

	public void validateLagGraphXaxisTitle(String expectedTitle) {	 
		String actualTitle = page.locator(lagXaxis).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateLagGraphYaxisTitle(String expectedTitle) {	 
		String actualTitle = page.locator(lagYaxis).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateLagGraphLegendTitle1(String expectedTitle) {
		String actualTitle = page.locator(lagLegendTitle1).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateLagGraphLegendTitle2(String expectedTitle) {	 
		String actualTitle = page.locator(lagLegendTitle2).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateLagGraphLegendTitle3(String expectedTitle) {	 
		String actualTitle = page.locator(lagLegendTitle3).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateLagToolTipTitle() {	 
		util.validateWidgetToolTips(page, lagXaxisLine, lagToolTipTitle);
	}

	public void validateLagDragAndDrop() {
		util.graphZoomInByDragAndDrop(page, lagXaxisLine, lagZoomOut, lagXaxisValues);
	}
	public void validateLagExpandViewXAxisTitle() { 
		util.validateExpandViewTexts(page, lagXaxis, lagExpand, expandViewCloseBtn, expandViewXaxisTitle);
	}

	public void validateLagExpandViewYAxisTitle() {
		util.validateExpandViewTexts(page, lagYaxis, lagExpand, expandViewCloseBtn, expandViewYaxisTitle);
	}

	public void validateLagExpandViewWidgetTitle() {
		util.validateExpandViewTexts(page, lagGraphTitle, lagExpand, expandViewCloseBtn, expandViewWidgetTitle);
	}

	public void validateLagExpandViewLegendHeader1() {	 
		util.validateExpandViewTexts(page, lagLegendTitle1, lagExpand, expandViewCloseBtn, expandViewLegendColumn1HeaderTitle);
	}

	public void validateLagExpandViewLegendHeader2() {	 
		util.validateExpandViewTexts(page, lagLegendTitle2 ,lagExpand, expandViewCloseBtn, expandViewLegendColumn2HeaderTitle);
	}

	public void validateLagExpandViewLegendHeader3() {	 
		util.validateExpandViewTexts(page, lagLegendTitle3 ,lagExpand, expandViewCloseBtn, expandViewLegendColumn3HeaderTitle);
	}

	public void validateLagExpandViewZoomIn() {
		util.ExpandViewZoomInBtn(page, expandViewZoomInBtn, lagExpand, expandViewCloseBtn, expandViewXaxisValues);
	}

	public void validateLagExpandViewZoomOut() {
		util.ExpandViewZoomOutBtn(page, expandViewZoomInBtn, lagExpand, expandViewCloseBtn, expandViewZoomOutBtn, expandViewXaxisValues);
	}

	public void validateLagExpandViewWidgetDragDrop() {
		util.ExpandViewWidgetDragDrop(page, lagExpand, expandViewCloseBtn, expandViewXaxisLines, expandViewZoomOutBtn, expandViewXaxisValues);
	}
	
	
/*
 * Lead Graph
 */

	public void validateLeadGraphTitle(String expectedTitle) {		  
		String actualTitle = page.locator(leadGraphTitle).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateLeadZoomInBtn() {		  
		util.graphZoomIn(page, leadZoomIn, leadXaxisValues);
	}

	public void validateLeadZoomOutBtn() {
		util.graphZoomOut(page, leadZoomIn, leadZoomOut, leadXaxisValues);
	}

	public void validateLeadGraphXaxisTitle(String expectedTitle) {	 
		String actualTitle = page.locator(leadXaxis).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateLeadGraphYaxisTitle(String expectedTitle) {	 
		String actualTitle = page.locator(leadYaxis).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateLeadGraphLegendTitle1(String expectedTitle) {
		String actualTitle = page.locator(leadLegendTitle1).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateLeadGraphLegendTitle2(String expectedTitle) {	 
		String actualTitle = page.locator(leadLegendTitle2).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateLeadGraphLegendTitle3(String expectedTitle) {	 
		String actualTitle = page.locator(leadLegendTitle3).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateLeadToolTipTitle() {	 
		util.validateWidgetToolTips(page, leadXaxisLine, leadToolTipTitle);
	}

	public void validateLeadDragAndDrop() {
		util.graphZoomInByDragAndDrop(page, leadXaxisLine, leadZoomOut, leadXaxisValues);
	}
	public void validateLeadExpandViewXAxisTitle() { 
		util.validateExpandViewTexts(page, leadXaxis, leadExpand, expandViewCloseBtn, expandViewXaxisTitle);
	}

	public void validateLeadExpandViewYAxisTitle() {
		util.validateExpandViewTexts(page, leadYaxis, leadExpand, expandViewCloseBtn, expandViewYaxisTitle);
	}

	public void validateLeadExpandViewWidgetTitle() {
		util.validateExpandViewTexts(page, leadGraphTitle, leadExpand, expandViewCloseBtn, expandViewWidgetTitle);
	}

	public void validateLeadExpandViewLegendHeader1() {	 
		util.validateExpandViewTexts(page, leadLegendTitle1, leadExpand, expandViewCloseBtn, expandViewLegendColumn1HeaderTitle);
	}

	public void validateLeadExpandViewLegendHeader2() {	 
		util.validateExpandViewTexts(page, leadLegendTitle2 ,leadExpand, expandViewCloseBtn, expandViewLegendColumn2HeaderTitle);
	}

	public void validateLeadExpandViewLegendHeader3() {	 
		util.validateExpandViewTexts(page, leadLegendTitle3 ,leadExpand, expandViewCloseBtn, expandViewLegendColumn3HeaderTitle);
	}

	public void validateLeadExpandViewZoomIn() {
		util.ExpandViewZoomInBtn(page, expandViewZoomInBtn, leadExpand, expandViewCloseBtn, expandViewXaxisValues);
	}

	public void validateLeadExpandViewZoomOut() {
		util.ExpandViewZoomOutBtn(page, expandViewZoomInBtn, leadExpand, expandViewCloseBtn, expandViewZoomOutBtn, expandViewXaxisValues);
	}

	public void validateLeadExpandViewWidgetDragDrop() {
		util.ExpandViewWidgetDragDrop(page, leadExpand, expandViewCloseBtn, expandViewXaxisLines, expandViewZoomOutBtn, expandViewXaxisValues);
	}
	
	
/*
 * Calendar
 */
		
	public void validateTheCustomTimeLine(String period) {
		util.validateCustomTimeLine(page, lagXaxisValues, period, WidgetXValues(period));
	}
		
	public void validateXaxisValuesForKafkaConsumerPartitionMetricsPage() {
		util.validateTheGraphdisplayingTheDataAsPerGivenTimeLines(page, lagXaxisValues, calenderView, allWidgetXValues());
	}
	
	public List<String> allWidgetXValues() {
		ArrayList<String> xValue = new ArrayList<String>();
		xValue.add(lagXaxisValues);
		xValue.add(leadXaxisValues);
		return xValue;
	}
}
