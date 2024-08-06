package objectRepository.MQM;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;

import genericUtilities.ExcelUtility;
import genericUtilities.GenericMethods;
import java.util.ArrayList;
import java.util.List;

public class KafkaOverviewConsumerPage 
{
	Page page;
	GenericMethods util = new GenericMethods();
	ExcelUtility excel = new ExcelUtility();
	
	private String selectMessageQueueDropdown = "#btn-arrow-down-mq-select-message-queue";
	private String selectSearchFieldMQDropdown = "#input-search-sel-mq-select-message-queue";
	private String selectMQDropdown = "#mq-select-message-queue-0-single";
	private String selectServiceNameDropdown = "#btn-arrow-down-mq-select-service-name";
	private String selectSearchFieldServiceNameDropdown = "#input-search-sel-mq-select-service-name";
	//private String selectSearchFieldServiceNameDropdown = "#mq-select-service-name-1-single";
	private String searchedApplication = "xpath = //span[@id='mq-select-service-name-0-single']";
	//private String searchedApplication = "xpath = //span[@id='mq-select-service-name-10-single']";
	private String calenderView = "xpath = //div[@class='selected-text ellipsis bg-text']";
	private String overviewTab = "xpath = //div[@class='navtab']/div[@class='item' and position()=1]/child::div";
	private String consumerTab = "xpath = //div[@class='overviewTabSelector']/child::div[@class][position()=3]";
		
//Average fetch size Graph 
	private String averageFetchSizeGraphTitle = "xpath = //div[@class='overviewTabSelector']/child::div[@class='kafkaTabItem kafkaActiveTab']/child::span[.='Consumer']/ancestor::div[@class='overviewTabSelector']/following-sibling::div//div[.='Average fetch size ']";
	private String averageFetchSizeXaxis = "xpath = //div[.='Average fetch size ']/following-sibling::div/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-title-text chart-lables']";
	private String averageFetchSizeYaxis = "xpath = //div[.='Average fetch size ']/following-sibling::div/descendant::*[name()='text' and @class='apexcharts-text apexcharts-yaxis-title-text chart-lables']";
	private String averageFetchSizeXaxisLine = "xpath = //div[.='Average fetch size ']/following-sibling::div/descendant::*[name()='line' and @class='apexcharts-xaxis-tick']";
	private String averageFetchSizeXaxisValues = "xpath = //div[@id='apexchartschart-kafka_broker_bytes_in_per_sec']/descendant::*[name()='tspan' and contains(.,'-')]";
	private String averageFetchSizeZoomOut = "xpath = (//div[.='Average fetch size ']/descendant::span[@class='icon-class'])[position()=1]";
	private String averageFetchSizeZoomIn = "xpath = (//div[.='Average fetch size ']/descendant::span[@class='icon-class'])[position()=2]";
	private String averageFetchSizeLegendTitle1 = "xpath = (//div[.='Average fetch size ']/following-sibling::div/descendant::div[@class='header-heading'])[position()=1]";
	private String averageFetchSizeLegendTitle2 = "xpath = (//div[.='Average fetch size ']/following-sibling::div/descendant::div[@class='header-heading'])[position()=2]";
	private String averageFetchSizeLegendTitle3 = "xpath = (//div[.='Average fetch size ']/following-sibling::div/descendant::div[@class='header-heading'])[position()=3]";
	private String averageFetchSizeToolTipTitle = "xpath = //div[.='Average fetch size ']/following-sibling::div/descendant::div[@class='apexcharts-tooltip-title']";
	
//Response rate Graph 
	private String responseRateGraphTitle = "xpath = //div[@class='overviewTabSelector']/child::div[@class='kafkaTabItem kafkaActiveTab']/child::span[.='Consumer']/ancestor::div[@class='overviewTabSelector']/following-sibling::div//div[.='Response rate ']";
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

//Consumer lag Graph 
	private String consumerLagGraphTitle = "xpath = //div[@class='overviewTabSelector']/child::div[@class='kafkaTabItem kafkaActiveTab']/child::span[.='Consumer']/ancestor::div[@class='overviewTabSelector']/following-sibling::div//div[.='Consumer lag ']";
	private String consumerLagXaxis = "xpath = //div[.='Consumer lag ']/following-sibling::div/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-title-text chart-lables']";
	private String consumerLagYaxis = "xpath = //div[.='Consumer lag ']/following-sibling::div/descendant::*[name()='text' and @class='apexcharts-text apexcharts-yaxis-title-text chart-lables']";
	private String consumerLagXaxisLine = "xpath = //div[.='Consumer lag ']/following-sibling::div/descendant::*[name()='line' and @class='apexcharts-xaxis-tick']";
	private String consumerLagXaxisValues = "xpath = //div[@id='apexchartschart-kafka_broker_total_produce_requests_per_sec']/descendant::*[name()='tspan' and contains(.,'-')]";
	private String consumerLagZoomOut = "xpath = (//div[.='Consumer lag ']/descendant::span[@class='icon-class'])[position()=1]";
	private String consumerLagZoomIn = "xpath = (//div[.='Consumer lag ']/descendant::span[@class='icon-class'])[position()=2]";
	private String consumerLagLegendTitle1 = "xpath = (//div[.='Consumer lag ']/following-sibling::div/descendant::div[@class='header-heading'])[position()=1]";
	private String consumerLagLegendTitle2 = "xpath = (//div[.='Consumer lag ']/following-sibling::div/descendant::div[@class='header-heading'])[position()=2]";
	private String consumerLagLegendTitle3 = "xpath = (//div[.='Consumer lag ']/following-sibling::div/descendant::div[@class='header-heading'])[position()=3]";
	private String consumerLagToolTipTitle = "xpath = //div[.='Consumer lag ']/following-sibling::div/descendant::div[@class='apexcharts-tooltip-title']";

//Message Consumed Graph 
	private String messageConsumedGraphTitle = "xpath = //div[@class='overviewTabSelector']/child::div[@class='kafkaTabItem kafkaActiveTab']/child::span[.='Consumer']/ancestor::div[@class='overviewTabSelector']/following-sibling::div//div[.='Message consumed ']";
	private String messageConsumedXaxis = "xpath = //div[.='Message consumed ']/following-sibling::div/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-title-text chart-lables']";
	private String messageConsumedYaxis = "xpath = //div[.='Message consumed ']/following-sibling::div/descendant::*[name()='text' and @class='apexcharts-text apexcharts-yaxis-title-text chart-lables']";
	private String messageConsumedXaxisLine = "xpath = //div[.='Message consumed ']/following-sibling::div/descendant::*[name()='line' and @class='apexcharts-xaxis-tick']";
	private String messageConsumedXaxisValues = "xpath = //div[@id='apexchartschart-kafka_broker_total_fetch_requests_per_sec']/descendant::*[name()='tspan' and contains(.,'-')]";
	private String messageConsumedZoomOut = "xpath = (//div[.='Message consumed ']/descendant::span[@class='icon-class'])[position()=1]";
	private String messageConsumedZoomIn = "xpath = (//div[.='Message consumed ']/descendant::span[@class='icon-class'])[position()=2]";
	private String messageConsumedLegendTitle1 = "xpath = (//div[.='Message consumed ']/following-sibling::div/descendant::div[@class='header-heading'])[position()=1]";
	private String messageConsumedLegendTitle2 = "xpath = (//div[.='Message consumed ']/following-sibling::div/descendant::div[@class='header-heading'])[position()=2]";
	private String messageConsumedLegendTitle3 = "xpath = (//div[.='Message consumed ']/following-sibling::div/descendant::div[@class='header-heading'])[position()=3]";
	private String messageConsumedToolTipTitle = "xpath = //div[.='Message consumed ']/following-sibling::div/descendant::div[@class='apexcharts-tooltip-title']";


//No. of consumers Graph 
	private String noOfConsumersGraphTitle = "xpath = (//div[@class='overviewTabSelector']/child::div[@class='kafkaTabItem kafkaActiveTab']/child::span[.='Consumer']/ancestor::div[@class='overviewTabSelector']/following-sibling::div//div[.=' No. of consumers'])[position()=1]";
	private String noOfConsumersXaxis = "xpath = //div[.=' No. of consumers']/following-sibling::div/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-title-text chart-lables']";
	private String noOfConsumersYaxis = "xpath = //div[.=' No. of consumers']/following-sibling::div/descendant::*[name()='text' and @class='apexcharts-text apexcharts-yaxis-title-text chart-lables']";
	private String noOfConsumersXaxisLine = "xpath = //div[.=' No. of consumers']/following-sibling::div/descendant::*[name()='line' and @class='apexcharts-xaxis-tick']";
	private String noOfConsumersXaxisValues = "xpath = //div[@id='apexchartsvuechart-line-0']/descendant::*[name()='tspan' and contains(.,'-')]";
	private String noOfConsumersZoomOut = "xpath = (//div[.=' No. of consumers']/descendant::span[@class='icon-class'])[position()=1]";
	private String noOfConsumersZoomIn = "xpath = (//div[.=' No. of consumers']/descendant::span[@class='icon-class'])[position()=2]";
	private String noOfConsumersZoomReset = "xpath = (//div[.=' No. of consumers']/descendant::span[@class='icon-class'])[position()=3]";
	private String noOfConsumersToolTipTitle = "xpath = //div[.=' No. of consumers']/following-sibling::div/descendant::div[@class='apexcharts-tooltip-title']";
	
//Expand Button
	private String averageFetchSizeExpand = "xpath = (//div[.='Average fetch size ']/descendant::span[@class='icon-class'])[position()=3]";
	private String responseRateExpand = "xpath = (//div[.='Response rate ']/descendant::span[@class='icon-class'])[position()=3]";	
	private String consumerLagExpand = "xpath = (//div[.='Consumer lag ']/descendant::span[@class='icon-class'])[position()=3]";	
	private String messageConsumedExpand = "xpath = (//div[.='Message consumed ']/descendant::span[@class='icon-class'])[position()=3]";	
	
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

	public KafkaOverviewConsumerPage(Page page) {
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
 * Consumer Tab
 */

	public void validateConsumerTabTitle(String expectedTitle) {
		String actualTitle = page.locator(consumerTab).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}
	
	public void clickOnConsumerTab() {
		page.locator(consumerTab).click();
		page.waitForLoadState(LoadState.NETWORKIDLE);
	}

/*
 * averageFetchSize Graph
 */

	public void validateAverageFetchSizeGraphTitle(String expectedTitle) {		  
		String actualTitle = page.locator(averageFetchSizeGraphTitle).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateAverageFetchSizeZoomInBtn() {		  
		util.graphZoomIn(page, averageFetchSizeZoomIn, averageFetchSizeXaxisValues);
	}

	public void validateAverageFetchSizeZoomOutBtn() {
		util.graphZoomOut(page, averageFetchSizeZoomIn, averageFetchSizeZoomOut, averageFetchSizeXaxisValues);
	}

	public void validateAverageFetchSizeGraphXaxisTitle(String expectedTitle) {	 
		String actualTitle = page.locator(averageFetchSizeXaxis).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateAverageFetchSizeGraphYaxisTitle(String expectedTitle) {	 
		String actualTitle = page.locator(averageFetchSizeYaxis).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateAverageFetchSizeGraphLegendTitle1(String expectedTitle) {
		String actualTitle = page.locator(averageFetchSizeLegendTitle1).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateAverageFetchSizeGraphLegendTitle2(String expectedTitle) {	 
		String actualTitle = page.locator(averageFetchSizeLegendTitle2).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateAverageFetchSizeGraphLegendTitle3(String expectedTitle) {	 
		String actualTitle = page.locator(averageFetchSizeLegendTitle3).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateAverageFetchSizeToolTipTitle() {	
		page.waitForTimeout(2000);
		util.validateWidgetToolTips(page, averageFetchSizeXaxisLine, averageFetchSizeToolTipTitle);
	}

	public void validateAverageFetchSizeDragAndDrop() {
		page.waitForTimeout(2000);
		util.graphZoomInByDragAndDrop(page, averageFetchSizeXaxisLine, averageFetchSizeZoomOut, averageFetchSizeXaxisValues);
	}
	public void validateAverageFetchSizeExpandViewXAxisTitle() { 
		util.validateExpandViewTexts(page, averageFetchSizeXaxis, averageFetchSizeExpand, expandViewCloseBtn, expandViewXaxisTitle);
	}

	public void validateAverageFetchSizeExpandViewYAxisTitle() {
		util.validateExpandViewTexts(page, averageFetchSizeYaxis, averageFetchSizeExpand, expandViewCloseBtn, expandViewYaxisTitle);
	}

	public void validateAverageFetchSizeExpandViewWidgetTitle() {
		util.validateExpandViewTexts(page, averageFetchSizeGraphTitle, averageFetchSizeExpand, expandViewCloseBtn, expandViewWidgetTitle);
	}

	public void validateAverageFetchSizeExpandViewLegendHeader1() {	 
		util.validateExpandViewTexts(page, averageFetchSizeLegendTitle1, averageFetchSizeExpand, expandViewCloseBtn, expandViewLegendColumn1HeaderTitle);
	}

	public void validateAverageFetchSizeExpandViewLegendHeader2() {	 
		util.validateExpandViewTexts(page, averageFetchSizeLegendTitle2 ,averageFetchSizeExpand, expandViewCloseBtn, expandViewLegendColumn2HeaderTitle);
	}

	public void validateAverageFetchSizeExpandViewLegendHeader3() {	 
		util.validateExpandViewTexts(page, averageFetchSizeLegendTitle3 ,averageFetchSizeExpand, expandViewCloseBtn, expandViewLegendColumn3HeaderTitle);
	}

	public void validateAverageFetchSizeExpandViewZoomIn() {
		util.ExpandViewZoomInBtn(page, expandViewZoomInBtn, averageFetchSizeExpand, expandViewCloseBtn, expandViewXaxisValues);
	}

	public void validateAverageFetchSizeExpandViewZoomOut() {
		util.ExpandViewZoomOutBtn(page, expandViewZoomInBtn, averageFetchSizeExpand, expandViewCloseBtn, expandViewZoomOutBtn, expandViewXaxisValues);
	}

	public void validateAverageFetchSizeExpandViewWidgetDragDrop() {
		page.waitForTimeout(2000);
		util.ExpandViewWidgetDragDrop(page, averageFetchSizeExpand, expandViewCloseBtn, expandViewXaxisLines, expandViewZoomOutBtn, expandViewXaxisValues);
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
		page.waitForTimeout(2000);
		util.validateExpandViewTexts(page, responseRateXaxis, responseRateExpand, expandViewCloseBtn, expandViewXaxisTitle);
	}

	public void validateResponseRateExpandViewYAxisTitle() {
		page.waitForTimeout(2000);
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
 * Consumer lag Graph
 */

	public void validateConsumerLagGraphTitle(String expectedTitle) {		  
		String actualTitle = page.locator(consumerLagGraphTitle).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateConsumerLagZoomInBtn() {		  
		util.graphZoomIn(page, consumerLagZoomIn, consumerLagXaxisValues);
	}

	public void validateConsumerLagZoomOutBtn() {
		util.graphZoomOut(page, consumerLagZoomIn, consumerLagZoomOut, consumerLagXaxisValues);
	}

	public void validateConsumerLagGraphXaxisTitle(String expectedTitle) {	 
		String actualTitle = page.locator(consumerLagXaxis).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateConsumerLagGraphYaxisTitle(String expectedTitle) {	 
		String actualTitle = page.locator(consumerLagYaxis).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateConsumerLagGraphLegendTitle1(String expectedTitle) {
		String actualTitle = page.locator(consumerLagLegendTitle1).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateConsumerLagGraphLegendTitle2(String expectedTitle) {	 
		String actualTitle = page.locator(consumerLagLegendTitle2).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateConsumerLagGraphLegendTitle3(String expectedTitle) {	 
		String actualTitle = page.locator(consumerLagLegendTitle3).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateConsumerLagToolTipTitle() {	 
		util.validateWidgetToolTips(page, consumerLagXaxisLine, consumerLagToolTipTitle);
	}

	public void validateConsumerLagDragAndDrop() {
		util.graphZoomInByDragAndDrop(page, consumerLagXaxisLine, consumerLagZoomOut, consumerLagXaxisValues);
	}
	public void validateConsumerLagExpandViewXAxisTitle() { 
		util.validateExpandViewTexts(page, consumerLagXaxis, consumerLagExpand, expandViewCloseBtn, expandViewXaxisTitle);
	}

	public void validateConsumerLagExpandViewYAxisTitle() {
		util.validateExpandViewTexts(page, consumerLagYaxis, consumerLagExpand, expandViewCloseBtn, expandViewYaxisTitle);
	}

	public void validateConsumerLagExpandViewWidgetTitle() {
		util.validateExpandViewTexts(page, consumerLagGraphTitle, consumerLagExpand, expandViewCloseBtn, expandViewWidgetTitle);
	}

	public void validateConsumerLagExpandViewLegendHeader1() {	 
		util.validateExpandViewTexts(page, consumerLagLegendTitle1, consumerLagExpand, expandViewCloseBtn, expandViewLegendColumn1HeaderTitle);
	}

	public void validateConsumerLagExpandViewLegendHeader2() {	 
		util.validateExpandViewTexts(page, consumerLagLegendTitle2 ,consumerLagExpand, expandViewCloseBtn, expandViewLegendColumn2HeaderTitle);
	}

	public void validateConsumerLagExpandViewLegendHeader3() {	 
		util.validateExpandViewTexts(page, consumerLagLegendTitle3 ,consumerLagExpand, expandViewCloseBtn, expandViewLegendColumn3HeaderTitle);
	}

	public void validateConsumerLagExpandViewZoomIn() {
		util.ExpandViewZoomInBtn(page, expandViewZoomInBtn, consumerLagExpand, expandViewCloseBtn, expandViewXaxisValues);
	}

	public void validateConsumerLagExpandViewZoomOut() {
		util.ExpandViewZoomOutBtn(page, expandViewZoomInBtn, consumerLagExpand, expandViewCloseBtn, expandViewZoomOutBtn, expandViewXaxisValues);
	}

	public void validateConsumerLagExpandViewWidgetDragDrop() {
		util.ExpandViewWidgetDragDrop(page, consumerLagExpand, expandViewCloseBtn, expandViewXaxisLines, expandViewZoomOutBtn, expandViewXaxisValues);
	}
	
/*
 * Message consumed Graph
 */

	public void validateMessageConsumedGraphTitle(String expectedTitle) {		  
		String actualTitle = page.locator(messageConsumedGraphTitle).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateMessageConsumedZoomInBtn() {		  
		util.graphZoomIn(page, messageConsumedZoomIn, messageConsumedXaxisValues);
	}

	public void validateMessageConsumedZoomOutBtn() {
		util.graphZoomOut(page, messageConsumedZoomIn, messageConsumedZoomOut, messageConsumedXaxisValues);
	}

	public void validateMessageConsumedGraphXaxisTitle(String expectedTitle) {	 
		String actualTitle = page.locator(messageConsumedXaxis).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateMessageConsumedGraphYaxisTitle(String expectedTitle) {	 
		String actualTitle = page.locator(messageConsumedYaxis).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateMessageConsumedGraphLegendTitle1(String expectedTitle) {
		String actualTitle = page.locator(messageConsumedLegendTitle1).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateMessageConsumedGraphLegendTitle2(String expectedTitle) {	 
		String actualTitle = page.locator(messageConsumedLegendTitle2).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateMessageConsumedGraphLegendTitle3(String expectedTitle) {	 
		String actualTitle = page.locator(messageConsumedLegendTitle3).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateMessageConsumedToolTipTitle() {	 
		util.validateWidgetToolTips(page, messageConsumedXaxisLine, messageConsumedToolTipTitle);
	}

	public void validateMessageConsumedDragAndDrop() {
		util.graphZoomInByDragAndDrop(page, messageConsumedXaxisLine, messageConsumedZoomOut, messageConsumedXaxisValues);
	}
	public void validateMessageConsumedExpandViewXAxisTitle() { 
		util.validateExpandViewTexts(page, messageConsumedXaxis, messageConsumedExpand, expandViewCloseBtn, expandViewXaxisTitle);
	}

	public void validateMessageConsumedExpandViewYAxisTitle() {
		util.validateExpandViewTexts(page, messageConsumedYaxis, messageConsumedExpand, expandViewCloseBtn, expandViewYaxisTitle);
	}

	public void validateMessageConsumedExpandViewWidgetTitle() {
		util.validateExpandViewTexts(page, messageConsumedGraphTitle, messageConsumedExpand, expandViewCloseBtn, expandViewWidgetTitle);
	}

	public void validateMessageConsumedExpandViewLegendHeader1() {	 
		util.validateExpandViewTexts(page, messageConsumedLegendTitle1, messageConsumedExpand, expandViewCloseBtn, expandViewLegendColumn1HeaderTitle);
	}

	public void validateMessageConsumedExpandViewLegendHeader2() {	 
		util.validateExpandViewTexts(page, messageConsumedLegendTitle2 ,messageConsumedExpand, expandViewCloseBtn, expandViewLegendColumn2HeaderTitle);
	}

	public void validateMessageConsumedExpandViewLegendHeader3() {	 
		util.validateExpandViewTexts(page, messageConsumedLegendTitle3 ,messageConsumedExpand, expandViewCloseBtn, expandViewLegendColumn3HeaderTitle);
	}

	public void validateMessageConsumedExpandViewZoomIn() {
		util.ExpandViewZoomInBtn(page, expandViewZoomInBtn, messageConsumedExpand, expandViewCloseBtn, expandViewXaxisValues);
	}

	public void validateMessageConsumedExpandViewZoomOut() {
		util.ExpandViewZoomOutBtn(page, expandViewZoomInBtn, messageConsumedExpand, expandViewCloseBtn, expandViewZoomOutBtn, expandViewXaxisValues);
	}

	public void validateMessageConsumedExpandViewWidgetDragDrop() {
		util.ExpandViewWidgetDragDrop(page, messageConsumedExpand, expandViewCloseBtn, expandViewXaxisLines, expandViewZoomOutBtn, expandViewXaxisValues);
	}
	
/*
 * No. of Consumers Graph
 */

	public void validateNoOfConsumersGraphTitle(String expectedTitle) {		  
		String actualTitle = page.locator(noOfConsumersGraphTitle).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateNoOfConsumersZoomInBtn( ){
		util.graphZoomIn(page, noOfConsumersZoomIn, noOfConsumersZoomReset, allWidgetXValues());
	}
	
	public void validateNoOfConsumersZoomOutBtn( ){
		util.graphZoomOut(page, noOfConsumersZoomIn, noOfConsumersZoomOut, noOfConsumersZoomReset, allWidgetXValues());
	}
	
	public void validateNoOfConsumersZoomResetBtn( ){
		util.graphZoomReset(page, noOfConsumersZoomIn, noOfConsumersZoomReset, allWidgetXValues());
	}

	public void validateNoOfConsumersGraphXaxisTitle(String expectedTitle) {	 
		String actualTitle = page.locator(noOfConsumersXaxis).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateNoOfConsumersGraphYaxisTitle(String expectedTitle) {	 
		String actualTitle = page.locator(noOfConsumersYaxis).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateNoOfConsumersToolTipTitle() {	 
		util.validateWidgetToolTips(page, noOfConsumersXaxisLine, noOfConsumersToolTipTitle);
	}

	public void validateNoOfConsumersDragAndDrop() {
		util.graphZoomInByDragAndDrop(page, noOfConsumersXaxisLine, noOfConsumersZoomOut, noOfConsumersXaxisValues);
	}
	
/*
 * Calendar
 */
		
	public void validateTheCustomTimeLine(String period) {
		util.validateCustomTimeLine(page, averageFetchSizeXaxisValues, period, WidgetXValues(period));
	}
		
	public void validateXaxisValuesForKafkaOverviewConsumerPage() {
		util.validateTheGraphdisplayingTheDataAsPerGivenTimeLines(page, averageFetchSizeXaxisValues, calenderView, allWidgetXValues());
	}
	
	public List<String> allWidgetXValues() {
		ArrayList<String> xValue = new ArrayList<String>();
		xValue.add(averageFetchSizeXaxisValues);
		xValue.add(responseRateXaxisValues);
		xValue.add(consumerLagXaxisValues);
		xValue.add(messageConsumedXaxisValues);
		xValue.add(noOfConsumersXaxisValues);
		return xValue;
	}
	
}
