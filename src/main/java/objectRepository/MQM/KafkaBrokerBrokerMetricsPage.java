package objectRepository.MQM;

import java.util.ArrayList;
import java.util.List;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;

import genericUtilities.ExcelUtility;
import genericUtilities.GenericMethods;

public class KafkaBrokerBrokerMetricsPage 
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
	private String brokerMetricsTab = "xpath = //div[@class='brokerTabSelector']/child::div[@class][position()=2]";
	private String brokerTitle = "xpath = //div[@class='kafkaBrokerDropdown']/descendant::div[@class='heading']";
	private String selectNameDropDown = "#btn-arrow-down-mq-select-participant";
	private String activeTickMark = "xpath = //input[@id='input-search-sel-mq-select-participant']/parent::div/following-sibling::div/child::div[@class='option']/span/span";
	private String nameSearchResults = "xpath = //input[@id='input-search-sel-mq-select-participant']/parent::div/following-sibling::div/child::div[@class='option'][1]";
	
//JVM CPU Graph
	private String jVMCPUGraphTitle = "xpath = //div[@class='brokerTabSelector']/child::div[@class='kafkaTabItem kafkaActiveTab']/child::span[.='Broker metrics']/ancestor::div[@class='kafkaBrokerActions']/following-sibling::div//div[.='JVM CPU ']";
	private String jVMCPUXaxis = "xpath = //div[.='JVM CPU ']/following-sibling::div/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-title-text chart-lables']";
	private String jVMCPUYaxis = "xpath = //div[.='JVM CPU ']/following-sibling::div/descendant::*[name()='text' and @class='apexcharts-text apexcharts-yaxis-title-text chart-lables']";
	private String jVMCPUXaxisLine = "xpath = //div[.='JVM CPU ']/following-sibling::div/descendant::*[name()='line' and @class='apexcharts-xaxis-tick']";
	private String jVMCPUXaxisValues = "xpath =//div[@id='apexchartschart-kafka_broker_topic_bytes_in_per_sec']/descendant::*[name()='tspan' and contains(.,'-')]";
	private String jVMCPUZoomOut = "xpath = (//div[.='JVM CPU ']/descendant::span[@class='icon-class'])[position()=1]";
	private String jVMCPUZoomIn = "xpath = (//div[.='JVM CPU ']/descendant::span[@class='icon-class'])[position()=2]";
	private String jVMCPULegendTitle1 = "xpath = (//div[.='JVM CPU ']/following-sibling::div/descendant::div[@class='header-heading'])[position()=1]";
	private String jVMCPULegendTitle2 = "xpath = (//div[.='JVM CPU ']/following-sibling::div/descendant::div[@class='header-heading'])[position()=2]";
	private String jVMCPULegendTitle3 = "xpath = (//div[.='JVM CPU ']/following-sibling::div/descendant::div[@class='header-heading'])[position()=3]";
	private String jVMCPUToolTipTitle = "xpath = //div[.='JVM CPU ']/following-sibling::div/descendant::div[@class='apexcharts-tooltip-title']";

//JVM Memory Graph
	private String jVMMemoryGraphTitle = "xpath = //div[@class='brokerTabSelector']/child::div[@class='kafkaTabItem kafkaActiveTab']/child::span[.='Broker metrics']/ancestor::div[@class='kafkaBrokerActions']/following-sibling::div//div[.='JVM memory ']";
	private String jVMMemoryXaxis = "xpath = //div[.='JVM memory ']/following-sibling::div/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-title-text chart-lables']";
	private String jVMMemoryYaxis = "xpath = //div[.='JVM memory ']/following-sibling::div/descendant::*[name()='text' and @class='apexcharts-text apexcharts-yaxis-title-text chart-lables']";
	private String jVMMemoryXaxisLine = "xpath = //div[.='JVM memory ']/following-sibling::div/descendant::*[name()='line' and @class='apexcharts-xaxis-tick']";
	private String jVMMemoryXaxisValues = "xpath = //div[@id='apexchartschart-kafka_broker_jvm_memory_heapxkafka_broker_jvm_memory_non_heap']/descendant::*[name()='tspan' and contains(.,'-')]";
	private String jVMMemoryZoomOut = "xpath = (//div[.='JVM memory ']/descendant::span[@class='icon-class'])[position()=1]";
	private String jVMMemoryZoomIn = "xpath = (//div[.='JVM memory ']/descendant::span[@class='icon-class'])[position()=2]";
	private String jVMMemoryLegendTitle1 = "xpath = (//div[.='JVM memory ']/following-sibling::div/descendant::div[@class='header-heading'])[position()=1]";
	private String jVMMemoryLegendTitle2 = "xpath = (//div[.='JVM memory ']/following-sibling::div/descendant::div[@class='header-heading'])[position()=2]";
	private String jVMMemoryLegendTitle3 = "xpath = (//div[.='JVM memory ']/following-sibling::div/descendant::div[@class='header-heading'])[position()=3]";
	private String jVMMemoryToolTipTitle = "xpath = //div[.='JVM memory ']/following-sibling::div/descendant::div[@class='apexcharts-tooltip-title']";

//GC Time Graph
	private String gCTimeGraphTitle = "xpath = //div[@class='brokerTabSelector']/child::div[@class='kafkaTabItem kafkaActiveTab']/child::span[.='Broker metrics']/ancestor::div[@class='kafkaBrokerActions']/following-sibling::div//div[.='GC time ']";
	private String gCTimeXaxis = "xpath = //div[.='GC time ']/following-sibling::div/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-title-text chart-lables']";
	private String gCTimeYaxis = "xpath = //div[.='GC time ']/following-sibling::div/descendant::*[name()='text' and @class='apexcharts-text apexcharts-yaxis-title-text chart-lables']";
	private String gCTimeXaxisLine = "xpath = //div[.='GC time ']/following-sibling::div/descendant::*[name()='line' and @class='apexcharts-xaxis-tick']";
	private String gCTimeXaxisValues = "xpath =//div[@id='apexchartschart-kafka_jvm_young_gc_timexkafka_jvm_old_gc_time']/descendant::*[name()='tspan' and contains(.,'-')]";
	private String gCTimeZoomOut = "xpath = (//div[.='GC time ']/descendant::span[@class='icon-class'])[position()=1]";
	private String gCTimeZoomIn = "xpath = (//div[.='GC time ']/descendant::span[@class='icon-class'])[position()=2]";
	private String gCTimeLegendTitle1 = "xpath = (//div[.='GC time ']/following-sibling::div/descendant::div[@class='header-heading'])[position()=1]";
	private String gCTimeLegendTitle2 = "xpath = (//div[.='GC time ']/following-sibling::div/descendant::div[@class='header-heading'])[position()=2]";
	private String gCTimeLegendTitle3 = "xpath = (//div[.='GC time ']/following-sibling::div/descendant::div[@class='header-heading'])[position()=3]";
	private String gCTimeToolTipTitle = "xpath = //div[.='GC time ']/following-sibling::div/descendant::div[@class='apexcharts-tooltip-title']";
	
//GC Count Graph
	private String gCCountGraphTitle = "xpath = //div[@class='brokerTabSelector']/child::div[@class='kafkaTabItem kafkaActiveTab']/child::span[.='Broker metrics']/ancestor::div[@class='kafkaBrokerActions']/following-sibling::div//div[.='GC count ']";
	private String gCCountXaxis = "xpath = //div[.='GC count ']/following-sibling::div/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-title-text chart-lables']";
	private String gCCountYaxis = "xpath = //div[.='GC count ']/following-sibling::div/descendant::*[name()='text' and @class='apexcharts-text apexcharts-yaxis-title-text chart-lables']";
	private String gCCountXaxisLine = "xpath = //div[.='GC count ']/following-sibling::div/descendant::*[name()='line' and @class='apexcharts-xaxis-tick']";
	private String gCCountXaxisValues = "xpath =//div[@id='apexchartschart-kafka_jvm_young_gc_countxkafka_jvm_old_gc_count']/descendant::*[name()='tspan' and contains(.,'-')]";
	private String gCCountZoomOut = "xpath = (//div[.='GC count ']/descendant::span[@class='icon-class'])[position()=1]";
	private String gCCountZoomIn = "xpath = (//div[.='GC count ']/descendant::span[@class='icon-class'])[position()=2]";
	private String gCCountLegendTitle1 = "xpath = (//div[.='GC count ']/following-sibling::div/descendant::div[@class='header-heading'])[position()=1]";
	private String gCCountLegendTitle2 = "xpath = (//div[.='GC count ']/following-sibling::div/descendant::div[@class='header-heading'])[position()=2]";
	private String gCCountLegendTitle3 = "xpath = (//div[.='GC count ']/following-sibling::div/descendant::div[@class='header-heading'])[position()=3]";
	private String gCCountToolTipTitle = "xpath = //div[.='GC count ']/following-sibling::div/descendant::div[@class='apexcharts-tooltip-title']";
	
//Thread Count Graph
	private String threadCountGraphTitle = "xpath = //div[@class='brokerTabSelector']/child::div[@class='kafkaTabItem kafkaActiveTab']/child::span[.='Broker metrics']/ancestor::div[@class='kafkaBrokerActions']/following-sibling::div//div[.='Thread count ']";
	private String threadCountXaxis = "xpath = //div[.='Thread count ']/following-sibling::div/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-title-text chart-lables']";
	private String threadCountYaxis = "xpath = //div[.='Thread count ']/following-sibling::div/descendant::*[name()='text' and @class='apexcharts-text apexcharts-yaxis-title-text chart-lables']";
	private String threadCountXaxisLine = "xpath = //div[.='Thread count ']/following-sibling::div/descendant::*[name()='line' and @class='apexcharts-xaxis-tick']";
	private String threadCountXaxisValues = "xpath =//div[@id='apexchartschart-kafka_messages_in_per_sec_count_topic']/descendant::*[name()='tspan' and contains(.,'-')]";
	private String threadCountZoomOut = "xpath = (//div[.='Thread count ']/descendant::span[@class='icon-class'])[position()=1]";
	private String threadCountZoomIn = "xpath = (//div[.='Thread count ']/descendant::span[@class='icon-class'])[position()=2]";
	private String threadCountLegendTitle1 = "xpath = (//div[.='Thread count ']/following-sibling::div/descendant::div[@class='header-heading'])[position()=1]";
	private String threadCountLegendTitle2 = "xpath = (//div[.='Thread count ']/following-sibling::div/descendant::div[@class='header-heading'])[position()=2]";
	private String threadCountLegendTitle3 = "xpath = (//div[.='Thread count ']/following-sibling::div/descendant::div[@class='header-heading'])[position()=3]";
	private String threadCountToolTipTitle = "xpath = //div[.='Thread count ']/following-sibling::div/descendant::div[@class='apexcharts-tooltip-title']";
	
//Message Count Graph
	private String messageCountGraphTitle = "xpath = //div[@class='brokerTabSelector']/child::div[@class='kafkaTabItem kafkaActiveTab']/child::span[.='Broker metrics']/ancestor::div[@class='kafkaBrokerActions']/following-sibling::div//div[.='Message count ']";
	private String messageCountXaxis = "xpath = //div[.='Message count ']/following-sibling::div/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-title-text chart-lables']";
	private String messageCountYaxis = "xpath = //div[.='Message count ']/following-sibling::div/descendant::*[name()='text' and @class='apexcharts-text apexcharts-yaxis-title-text chart-lables']";
	private String messageCountXaxisLine = "xpath = //div[.='Message count ']/following-sibling::div/descendant::*[name()='line' and @class='apexcharts-xaxis-tick']";
	private String messageCountXaxisValues = "xpath = //div[@id='apexchartschart-kafka_broker_messages_in_per_sec_count']/descendant::*[name()='tspan' and contains(.,'-')]";
	private String messageCountZoomOut = "xpath = (//div[.='Message count ']/descendant::span[@class='icon-class'])[position()=1]";
	private String messageCountZoomIn = "xpath = (//div[.='Message count ']/descendant::span[@class='icon-class'])[position()=2]";
	private String messageCountLegendTitle1 = "xpath = (//div[.='Message count ']/following-sibling::div/descendant::div[@class='header-heading'])[position()=1]";
	private String messageCountLegendTitle2 = "xpath = (//div[.='Message count ']/following-sibling::div/descendant::div[@class='header-heading'])[position()=2]";
	private String messageCountLegendTitle3 = "xpath = (//div[.='Message count ']/following-sibling::div/descendant::div[@class='header-heading'])[position()=3]";
	private String messageCountToolTipTitle = "xpath = //div[.='Message count ']/following-sibling::div/descendant::div[@class='apexcharts-tooltip-title']";
	
	
//Expand Button
	private String jVMCPUExpand = "xpath = (//div[.='JVM CPU ']/descendant::span[@class='icon-class'])[position()=3]";
	private String jVMMemoryExpand = "xpath = (//div[.='JVM memory ']/descendant::span[@class='icon-class'])[position()=3]";	
	private String gCTimeExpand = "xpath = (//div[.='GC time ']/descendant::span[@class='icon-class'])[position()=3]";	
	private String gCCountExpand = "xpath = (//div[.='GC count ']/descendant::span[@class='icon-class'])[position()=3]";	
	private String threadCountExpand = "xpath = (//div[.='Thread count ']/descendant::span[@class='icon-class'])[position()=3]";	
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
	
	public KafkaBrokerBrokerMetricsPage(Page page) {
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
	
	public void validateBrokerSelectTitle(String expectedTitle) {
		String actualTitle = page.locator(brokerTitle).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}
	
	public void validateBrokerSelectDropDown() {
		util.SelectTheMulitpleOptionFromDropDown(page, selectNameDropDown, activeTickMark, listOfNames()); 
		page.waitForLoadState(LoadState.NETWORKIDLE); 
	}
	
/*
 * Broker Metrics Tab
 */

	public void validateBrokerMetricsTabTitle(String expectedTitle) {
		String actualTitle = page.locator(brokerMetricsTab).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void clickOnBrokerMetricsTab() {
			page.locator(brokerMetricsTab).click();
			page.waitForLoadState(LoadState.NETWORKIDLE);
	}
	
/*
 * JVM CPU Graph
 */

	public void validateJVMCPUGraphTitle(String expectedTitle) {		  
		String actualTitle = page.locator(jVMCPUGraphTitle).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateJVMCPUZoomInBtn() {		  
		util.graphZoomIn(page, jVMCPUZoomIn, jVMCPUXaxisValues);
	}

	public void validateJVMCPUZoomOutBtn() {
		util.graphZoomOut(page, jVMCPUZoomIn, jVMCPUZoomOut, jVMCPUXaxisValues);
	}

	public void validateJVMCPUGraphXaxisTitle(String expectedTitle) {	 
		String actualTitle = page.locator(jVMCPUXaxis).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateJVMCPUGraphYaxisTitle(String expectedTitle) {	 
		String actualTitle = page.locator(jVMCPUYaxis).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateJVMCPUGraphLegendTitle1(String expectedTitle) {
		String actualTitle = page.locator(jVMCPULegendTitle1).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateJVMCPUGraphLegendTitle2(String expectedTitle) {	 
		String actualTitle = page.locator(jVMCPULegendTitle2).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateJVMCPUGraphLegendTitle3(String expectedTitle) {	 
		String actualTitle = page.locator(jVMCPULegendTitle3).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateJVMCPUToolTipTitle() {	 
		util.validateWidgetToolTips(page, jVMCPUXaxisLine, jVMCPUToolTipTitle);
	}

	public void validateJVMCPUDragAndDrop() {
		util.graphZoomInByDragAndDrop(page, jVMCPUXaxisLine, jVMCPUZoomOut, jVMCPUXaxisValues);
	}
	public void validateJVMCPUExpandViewXAxisTitle() { 
		util.validateExpandViewTexts(page, jVMCPUXaxis, jVMCPUExpand, expandViewCloseBtn, expandViewXaxisTitle);
	}

	public void validateJVMCPUExpandViewYAxisTitle() {
		util.validateExpandViewTexts(page, jVMCPUYaxis, jVMCPUExpand, expandViewCloseBtn, expandViewYaxisTitle);
	}

	public void validateJVMCPUExpandViewWidgetTitle() {
		util.validateExpandViewTexts(page, jVMCPUGraphTitle, jVMCPUExpand, expandViewCloseBtn, expandViewWidgetTitle);
	}

	public void validateJVMCPUExpandViewLegendHeader1() {	 
		util.validateExpandViewTexts(page, jVMCPULegendTitle1, jVMCPUExpand, expandViewCloseBtn, expandViewLegendColumn1HeaderTitle);
	}

	public void validateJVMCPUExpandViewLegendHeader2() {	 
		util.validateExpandViewTexts(page, jVMCPULegendTitle2 ,jVMCPUExpand, expandViewCloseBtn, expandViewLegendColumn2HeaderTitle);
	}

	public void validateJVMCPUExpandViewLegendHeader3() {	 
		util.validateExpandViewTexts(page, jVMCPULegendTitle3 ,jVMCPUExpand, expandViewCloseBtn, expandViewLegendColumn3HeaderTitle);
	}

	public void validateJVMCPUExpandViewZoomIn() {
		util.ExpandViewZoomInBtn(page, expandViewZoomInBtn, jVMCPUExpand, expandViewCloseBtn, expandViewXaxisValues);
	}

	public void validateJVMCPUExpandViewZoomOut() {
		util.ExpandViewZoomOutBtn(page, expandViewZoomInBtn, jVMCPUExpand, expandViewCloseBtn, expandViewZoomOutBtn, expandViewXaxisValues);
	}

	public void validateJVMCPUExpandViewWidgetDragDrop() {
		util.ExpandViewWidgetDragDrop(page, jVMCPUExpand, expandViewCloseBtn, expandViewXaxisLines, expandViewZoomOutBtn, expandViewXaxisValues);
	}
		
	
		
/*
 * JVM Memory Graph
 */

	public void validateJVMMemoryGraphTitle(String expectedTitle) {		  
		String actualTitle = page.locator(jVMMemoryGraphTitle).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateJVMMemoryZoomInBtn() {		  
		util.graphZoomIn(page, jVMMemoryZoomIn, jVMMemoryXaxisValues);
	}

	public void validateJVMMemoryZoomOutBtn() {
		util.graphZoomOut(page, jVMMemoryZoomIn, jVMMemoryZoomOut, jVMMemoryXaxisValues);
	}

	public void validateJVMMemoryGraphXaxisTitle(String expectedTitle) {	 
		String actualTitle = page.locator(jVMMemoryXaxis).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateJVMMemoryGraphYaxisTitle(String expectedTitle) {	 
		String actualTitle = page.locator(jVMMemoryYaxis).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateJVMMemoryGraphLegendTitle1(String expectedTitle) {
		String actualTitle = page.locator(jVMMemoryLegendTitle1).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateJVMMemoryGraphLegendTitle2(String expectedTitle) {	 
		String actualTitle = page.locator(jVMMemoryLegendTitle2).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateJVMMemoryGraphLegendTitle3(String expectedTitle) {	 
		String actualTitle = page.locator(jVMMemoryLegendTitle3).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateJVMMemoryToolTipTitle() {	 
		util.validateWidgetToolTips(page, jVMMemoryXaxisLine, jVMMemoryToolTipTitle);
	}

	public void validateJVMMemoryDragAndDrop() {
		util.graphZoomInByDragAndDrop(page, jVMMemoryXaxisLine, jVMMemoryZoomOut, jVMMemoryXaxisValues);
	}
	public void validateJVMMemoryExpandViewXAxisTitle() { 
		util.validateExpandViewTexts(page, jVMMemoryXaxis, jVMMemoryExpand, expandViewCloseBtn, expandViewXaxisTitle);
	}

	public void validateJVMMemoryExpandViewYAxisTitle() {
		util.validateExpandViewTexts(page, jVMMemoryYaxis, jVMMemoryExpand, expandViewCloseBtn, expandViewYaxisTitle);
	}

	public void validateJVMMemoryExpandViewWidgetTitle() {
		util.validateExpandViewTexts(page, jVMMemoryGraphTitle, jVMMemoryExpand, expandViewCloseBtn, expandViewWidgetTitle);
	}

	public void validateJVMMemoryExpandViewLegendHeader1() {	 
		util.validateExpandViewTexts(page, jVMMemoryLegendTitle1, jVMMemoryExpand, expandViewCloseBtn, expandViewLegendColumn1HeaderTitle);
	}

	public void validateJVMMemoryExpandViewLegendHeader2() {	 
		util.validateExpandViewTexts(page, jVMMemoryLegendTitle2 ,jVMMemoryExpand, expandViewCloseBtn, expandViewLegendColumn2HeaderTitle);
	}

	public void validateJVMMemoryExpandViewLegendHeader3() {	 
		util.validateExpandViewTexts(page, jVMMemoryLegendTitle3 ,jVMMemoryExpand, expandViewCloseBtn, expandViewLegendColumn3HeaderTitle);
	}

	public void validateJVMMemoryExpandViewZoomIn() {
		util.ExpandViewZoomInBtn(page, expandViewZoomInBtn, jVMMemoryExpand, expandViewCloseBtn, expandViewXaxisValues);
	}

	public void validateJVMMemoryExpandViewZoomOut() {
		util.ExpandViewZoomOutBtn(page, expandViewZoomInBtn, jVMMemoryExpand, expandViewCloseBtn, expandViewZoomOutBtn, expandViewXaxisValues);
	}

	public void validateJVMMemoryExpandViewWidgetDragDrop() {
		util.ExpandViewWidgetDragDrop(page, jVMMemoryExpand, expandViewCloseBtn, expandViewXaxisLines, expandViewZoomOutBtn, expandViewXaxisValues);
	}
		
		
/*
 * GC time Graph
 */

	public void validateGCTimeGraphTitle(String expectedTitle) {		  
		String actualTitle = page.locator(gCTimeGraphTitle).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateGCTimeZoomInBtn() {		  
		util.graphZoomIn(page, gCTimeZoomIn, gCTimeXaxisValues);
	}

	public void validateGCTimeZoomOutBtn() {
		util.graphZoomOut(page, gCTimeZoomIn, gCTimeZoomOut, gCTimeXaxisValues);
	}

	public void validateGCTimeGraphXaxisTitle(String expectedTitle) {	 
		String actualTitle = page.locator(gCTimeXaxis).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateGCTimeGraphYaxisTitle(String expectedTitle) {	 
		String actualTitle = page.locator(gCTimeYaxis).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateGCTimeGraphLegendTitle1(String expectedTitle) {
		String actualTitle = page.locator(gCTimeLegendTitle1).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateGCTimeGraphLegendTitle2(String expectedTitle) {	 
		String actualTitle = page.locator(gCTimeLegendTitle2).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateGCTimeGraphLegendTitle3(String expectedTitle) {	 
		String actualTitle = page.locator(gCTimeLegendTitle3).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateGCTimeToolTipTitle() {	 
		util.validateWidgetToolTips(page, gCTimeXaxisLine, gCTimeToolTipTitle);
	}

	public void validateGCTimeDragAndDrop() {
		util.graphZoomInByDragAndDrop(page, gCTimeXaxisLine, gCTimeZoomOut, gCTimeXaxisValues);
	}
	public void validateGCTimeExpandViewXAxisTitle() { 
		util.validateExpandViewTexts(page, gCTimeXaxis, gCTimeExpand, expandViewCloseBtn, expandViewXaxisTitle);
	}

	public void validateGCTimeExpandViewYAxisTitle() {
		util.validateExpandViewTexts(page, gCTimeYaxis, gCTimeExpand, expandViewCloseBtn, expandViewYaxisTitle);
	}

	public void validateGCTimeExpandViewWidgetTitle() {
		util.validateExpandViewTexts(page, gCTimeGraphTitle, gCTimeExpand, expandViewCloseBtn, expandViewWidgetTitle);
	}

	public void validateGCTimeExpandViewLegendHeader1() {	 
		util.validateExpandViewTexts(page, gCTimeLegendTitle1, gCTimeExpand, expandViewCloseBtn, expandViewLegendColumn1HeaderTitle);
	}

	public void validateGCTimeExpandViewLegendHeader2() {	 
		util.validateExpandViewTexts(page, gCTimeLegendTitle2 ,gCTimeExpand, expandViewCloseBtn, expandViewLegendColumn2HeaderTitle);
	}

	public void validateGCTimeExpandViewLegendHeader3() {	 
		util.validateExpandViewTexts(page, gCTimeLegendTitle3 ,gCTimeExpand, expandViewCloseBtn, expandViewLegendColumn3HeaderTitle);
	}

	public void validateGCTimeExpandViewZoomIn() {
		util.ExpandViewZoomInBtn(page, expandViewZoomInBtn, gCTimeExpand, expandViewCloseBtn, expandViewXaxisValues);
	}

	public void validateGCTimeExpandViewZoomOut() {
		util.ExpandViewZoomOutBtn(page, expandViewZoomInBtn, gCTimeExpand, expandViewCloseBtn, expandViewZoomOutBtn, expandViewXaxisValues);
	}

	public void validateGCTimeExpandViewWidgetDragDrop() {
		util.ExpandViewWidgetDragDrop(page, gCTimeExpand, expandViewCloseBtn, expandViewXaxisLines, expandViewZoomOutBtn, expandViewXaxisValues);
	}
	
	
/*
 * GC Count Graph
 */

	public void validateGCCountGraphTitle(String expectedTitle) {		  
		String actualTitle = page.locator(gCCountGraphTitle).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateGCCountZoomInBtn() {		  
		util.graphZoomIn(page, gCCountZoomIn, gCCountXaxisValues);
	}

	public void validateGCCountZoomOutBtn() {
		util.graphZoomOut(page, gCCountZoomIn, gCCountZoomOut, gCCountXaxisValues);
	}

	public void validateGCCountGraphXaxisTitle(String expectedTitle) {	 
		String actualTitle = page.locator(gCCountXaxis).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateGCCountGraphYaxisTitle(String expectedTitle) {	 
		String actualTitle = page.locator(gCCountYaxis).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateGCCountGraphLegendTitle1(String expectedTitle) {
		String actualTitle = page.locator(gCCountLegendTitle1).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateGCCountGraphLegendTitle2(String expectedTitle) {	 
		String actualTitle = page.locator(gCCountLegendTitle2).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateGCCountGraphLegendTitle3(String expectedTitle) {	 
		String actualTitle = page.locator(gCCountLegendTitle3).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateGCCountToolTipTitle() {	 
		util.validateWidgetToolTips(page, gCCountXaxisLine, gCCountToolTipTitle);
	}

	public void validateGCCountDragAndDrop() {
		util.graphZoomInByDragAndDrop(page, gCCountXaxisLine, gCCountZoomOut, gCCountXaxisValues);
	}
	public void validateGCCountExpandViewXAxisTitle() { 
		util.validateExpandViewTexts(page, gCCountXaxis, gCCountExpand, expandViewCloseBtn, expandViewXaxisTitle);
	}

	public void validateGCCountExpandViewYAxisTitle() {
		util.validateExpandViewTexts(page, gCCountYaxis, gCCountExpand, expandViewCloseBtn, expandViewYaxisTitle);
	}

	public void validateGCCountExpandViewWidgetTitle() {
		util.validateExpandViewTexts(page, gCCountGraphTitle, gCCountExpand, expandViewCloseBtn, expandViewWidgetTitle);
	}

	public void validateGCCountExpandViewLegendHeader1() {	 
		util.validateExpandViewTexts(page, gCCountLegendTitle1, gCCountExpand, expandViewCloseBtn, expandViewLegendColumn1HeaderTitle);
	}

	public void validateGCCountExpandViewLegendHeader2() {	 
		util.validateExpandViewTexts(page, gCCountLegendTitle2 ,gCCountExpand, expandViewCloseBtn, expandViewLegendColumn2HeaderTitle);
	}

	public void validateGCCountExpandViewLegendHeader3() {	 
		util.validateExpandViewTexts(page, gCCountLegendTitle3 ,gCCountExpand, expandViewCloseBtn, expandViewLegendColumn3HeaderTitle);
	}

	public void validateGCCountExpandViewZoomIn() {
		util.ExpandViewZoomInBtn(page, expandViewZoomInBtn, gCCountExpand, expandViewCloseBtn, expandViewXaxisValues);
	}

	public void validateGCCountExpandViewZoomOut() {
		util.ExpandViewZoomOutBtn(page, expandViewZoomInBtn, gCCountExpand, expandViewCloseBtn, expandViewZoomOutBtn, expandViewXaxisValues);
	}

	public void validateGCCountExpandViewWidgetDragDrop() {
		util.ExpandViewWidgetDragDrop(page, gCCountExpand, expandViewCloseBtn, expandViewXaxisLines, expandViewZoomOutBtn, expandViewXaxisValues);
	}
		
/*
 * Thread Count Graph
 */

	public void validateThreadCountGraphTitle(String expectedTitle) {		  
		String actualTitle = page.locator(threadCountGraphTitle).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateThreadCountZoomInBtn() {		  
		util.graphZoomIn(page, threadCountZoomIn, threadCountXaxisValues);
	}

	public void validateThreadCountZoomOutBtn() {
		util.graphZoomOut(page, threadCountZoomIn, threadCountZoomOut, threadCountXaxisValues);
	}

	public void validateThreadCountGraphXaxisTitle(String expectedTitle) {	 
		String actualTitle = page.locator(threadCountXaxis).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateThreadCountGraphYaxisTitle(String expectedTitle) {	 
		String actualTitle = page.locator(threadCountYaxis).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateThreadCountGraphLegendTitle1(String expectedTitle) {
		String actualTitle = page.locator(threadCountLegendTitle1).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateThreadCountGraphLegendTitle2(String expectedTitle) {	 
		String actualTitle = page.locator(threadCountLegendTitle2).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateThreadCountGraphLegendTitle3(String expectedTitle) {	 
		String actualTitle = page.locator(threadCountLegendTitle3).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateThreadCountToolTipTitle() {	 
		util.validateWidgetToolTips(page, threadCountXaxisLine, threadCountToolTipTitle);
	}

	public void validateThreadCountDragAndDrop() {
		util.graphZoomInByDragAndDrop(page, threadCountXaxisLine, threadCountZoomOut, threadCountXaxisValues);
	}
	public void validateThreadCountExpandViewXAxisTitle() { 
		util.validateExpandViewTexts(page, threadCountXaxis, threadCountExpand, expandViewCloseBtn, expandViewXaxisTitle);
	}

	public void validateThreadCountExpandViewYAxisTitle() {
		util.validateExpandViewTexts(page, threadCountYaxis, threadCountExpand, expandViewCloseBtn, expandViewYaxisTitle);
	}

	public void validateThreadCountExpandViewWidgetTitle() {
		util.validateExpandViewTexts(page, threadCountGraphTitle, threadCountExpand, expandViewCloseBtn, expandViewWidgetTitle);
	}

	public void validateThreadCountExpandViewLegendHeader1() {	 
		util.validateExpandViewTexts(page, threadCountLegendTitle1, threadCountExpand, expandViewCloseBtn, expandViewLegendColumn1HeaderTitle);
	}

	public void validateThreadCountExpandViewLegendHeader2() {	 
		util.validateExpandViewTexts(page, threadCountLegendTitle2 ,threadCountExpand, expandViewCloseBtn, expandViewLegendColumn2HeaderTitle);
	}

	public void validateThreadCountExpandViewLegendHeader3() {	 
		util.validateExpandViewTexts(page, threadCountLegendTitle3 ,threadCountExpand, expandViewCloseBtn, expandViewLegendColumn3HeaderTitle);
	}

	public void validateThreadCountExpandViewZoomIn() {
		util.ExpandViewZoomInBtn(page, expandViewZoomInBtn, threadCountExpand, expandViewCloseBtn, expandViewXaxisValues);
	}

	public void validateThreadCountExpandViewZoomOut() {
		util.ExpandViewZoomOutBtn(page, expandViewZoomInBtn, threadCountExpand, expandViewCloseBtn, expandViewZoomOutBtn, expandViewXaxisValues);
	}

	public void validateThreadCountExpandViewWidgetDragDrop() {
		util.ExpandViewWidgetDragDrop(page, threadCountExpand, expandViewCloseBtn, expandViewXaxisLines, expandViewZoomOutBtn, expandViewXaxisValues);
	}
		
/*
 * Message Count Graph
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
		util.validateCustomTimeLine(page, jVMCPUXaxisValues, period, WidgetXValues(period));
	}
		
	public void validateXaxisValuesForKafkaBrokerBrokerMetricsPage() {
		util.validateTheGraphdisplayingTheDataAsPerGivenTimeLines(page, jVMCPUXaxisValues, calenderView, allWidgetXValues());
	}
	
	public List<String> allWidgetXValues() {
		ArrayList<String> xValue = new ArrayList<String>();
		xValue.add(jVMCPUXaxisValues);
		xValue.add(jVMMemoryXaxisValues);
		xValue.add(gCTimeXaxisValues);
		xValue.add(gCCountXaxisValues);
		xValue.add(threadCountXaxisValues);
		xValue.add(messageCountXaxisValues);
		return xValue;
	}
}