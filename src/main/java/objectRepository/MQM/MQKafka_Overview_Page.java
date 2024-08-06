package objectRepository.MQM;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;


import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;

import genericUtilities.ExcelUtility;
import genericUtilities.GenericMethods;

public class MQKafka_Overview_Page {
	Page page;
	GenericMethods util = new GenericMethods();
	ExcelUtility excel = new ExcelUtility();

	private String SelectMessageQueueDropdown = "#btn-arrow-down-mq-select-message-queue";
	private String SelectSearchFieldMQDropdown = "#input-search-sel-mq-select-message-queue";
	private String SelectMQDropdown = "#mq-select-message-queue-0-single";
	private String SelectServiceNameDropdown = "#btn-arrow-down-mq-select-service-name";
	private String SelectSearchFieldServiceNameDropdown = "#input-search-sel-mq-select-service-name";
	private String SearchedApplication = "xpath = //span[@id='mq-select-service-name-0-single']";

	private String OverviewTabTitle = "xpath = //div[@class='navtab']/div[@class='item' and position()=1]/child::div";

	private String MetricsLegendTitle = "xpath = //div[@class='metrics-wrapper']/descendant::div[@class='card-header']";
	private String MetricsNoOfBrokers = "xpath = //div[@class='card-body']/descendant::div[@class='textLabel'][position()=1]";
	private String MetricsNoOfTopics = "xpath = //div[@class='card-body']/descendant::div[@class='textLabel'][position()=2]";
	private String MetricsNoOfPartitions = "xpath = //div[@class='card-body']/descendant::div[@class='textLabel'][position()=3]";
	private String MetricsNoOfProducers = "xpath = //div[@class='card-body']/descendant::div[@class='textLabel'][position()=4]";
	private String MetricsNoOfConsumers = "xpath = //div[@class='card-body']/descendant::div[@class='textLabel'][position()=5]";

	private String BrokerTabTitle = "xpath = //div[@class='overviewTabSelector']/child::div[@class='kafkaTabItem kafkaActiveTab']";
	private String ProducerTabTitle = "xpath = //div[@class='overviewTabSelector']/child::div[@class='kafkaTabItem'][position()=1]";
	private String ConsumerTabTitle = "xpath = //div[@class='overviewTabSelector']/child::div[@class='kafkaTabItem'][position()=2]";

	private String calenderView = "xpath = //div[@class='selected-text ellipsis bg-text']";

	// Overview > Broker
	private String BrokerBytesInID = "apexchartschart-kafka_broker_bytes_in_per_sec";
	private String BrokerBytesOutID = "apexchartschart-kafka_broker_bytes_out_per_sec";
	private String BrokerTotalProducedRequestRateID = "apexchartschart-kafka_broker_total_produce_requests_per_sec";
	private String BrokerTotalFetchRequestRateID = "apexchartschart-kafka_broker_total_fetch_requests_per_sec";
	private String BrokerMessagesInID = "apexchartschart-kafka_broker_messages_in_per_sec";
	private String BrokerLeaderElectionRateID = "apexchartschart-kafka_broker_leader_election_rate_and_timems";
	private String BrokerUncleanedElectionLeaderID = "apexchartschart-kafka_broker_unclean_leader_elections_per_sec";
	private String BrokerNumberOfBrokersID = "apexchartsvuechart-line-0";

	// Overview > Producer
	private String ProducerRequestRateID = "apexchartschart-kafka_broker_bytes_in_per_sec";
	private String ProducerResponseRateID = "apexchartschart-kafka_broker_bytes_out_per_sec";
	private String ProducerErrorRateID = "apexchartschart-kafka_broker_total_produce_requests_per_sec";
	private String ProducerRequestAvgLatencyID = "apexchartschart-kafka_broker_total_fetch_requests_per_sec";
	private String ProducerNumberOfProducersID = "apexchartsvuechart-line-0";

	// Overview > Consumer
	private String ConsumerAverageFetchSizeID = "apexchartschart-kafka_broker_bytes_in_per_sec";
	private String ConsumerResponseRateID = "apexchartschart-kafka_broker_bytes_out_per_sec";
	private String ConsumerConsumerLagID = "apexchartschart-kafka_broker_total_produce_requests_per_sec";
	private String ConsumerMessageConsumedID = "apexchartschart-kafka_broker_total_fetch_requests_per_sec";
	private String ConsumerNumberOfConsumersID = "apexchartsvuechart-line-0";

	public List<String> WidgetXValues(String XValue) {
		ArrayList<String> xValue = new ArrayList<String>();
		xValue.add(XValue);
		return xValue;
	}

	public MQKafka_Overview_Page(Page page) {
		this.page = page;
	}

	public void navigateToKafka() {
		util.selectTheOptionFromDropDownBySearch(page, SelectMessageQueueDropdown, SelectSearchFieldMQDropdown, "Kafka",  SelectMQDropdown);
		page.waitForLoadState(LoadState.NETWORKIDLE);	}

	public void selectServiceName(String application) {
		util.selectTheOptionFromDropDownBySearch(page, SelectServiceNameDropdown,
				  SelectSearchFieldServiceNameDropdown, application,
				  SearchedApplication); 
					 page.waitForLoadState(LoadState.NETWORKIDLE); 
	}
				
	public void validateOverviewTitle(String expectedTitle) {
		String actualTitle = page.locator(OverviewTabTitle).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
		page.waitForLoadState(LoadState.NETWORKIDLE);
	}

	public void validateOverviewBrokerTitle(String expectedTitle) {
		String actualTitle = page.locator(BrokerTabTitle).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
		page.waitForLoadState(LoadState.NETWORKIDLE);
	}

	public void validateMetricsLegendTitle(String expectedTitle) {
		String actualTitle = page.locator(MetricsLegendTitle).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
		page.waitForLoadState(LoadState.NETWORKIDLE);
	}

	public void validateMetricsNoOfBrokers(String expectedTitle) {
		String actualTitle = page.locator(MetricsNoOfBrokers).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
		page.waitForLoadState(LoadState.NETWORKIDLE);
	}

	public void validateMetricsNoOfTopics(String expectedTitle) {
		String actualTitle = page.locator(MetricsNoOfTopics).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
		page.waitForLoadState(LoadState.NETWORKIDLE);
	}

	public void validateMetricsNoOfPartitions(String expectedTitle) {
		String actualTitle = page.locator(MetricsNoOfPartitions).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
		page.waitForLoadState(LoadState.NETWORKIDLE);
	}

	public void validateMetricsNoOfProducers(String expectedTitle) {
		String actualTitle = page.locator(MetricsNoOfProducers).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
		page.waitForLoadState(LoadState.NETWORKIDLE);
	}

	public void validateMetricsNoOfConsumers(String expectedTitle) {
		String actualTitle = page.locator(MetricsNoOfConsumers).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
		page.waitForLoadState(LoadState.NETWORKIDLE);
	}

	/**
	 * Broker tab
	 * 
	 */

	public void validateBrokerTabTitle(String expectedTitle) {
		String actualTitle = page.locator(BrokerTabTitle).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

//Broker > Bytes In Graph

	public void validateBrokerBytesInGraphTitle(String expectedTitle) {
		String actualTitle = page.locator(getWidgetTitle(BrokerBytesInID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateBytesInZoomInBtn() {
		page.waitForTimeout(1000); 
		util.graphZoomIn(page, ZoomIn(BrokerBytesInID), BrokerBytesInID);
	}

	public void validateBytesInZoomOutBtn() {
		page.waitForTimeout(1000); 
		util.graphZoomOut(page, ZoomIn(BrokerBytesInID), ZoomOut(BrokerBytesInID), BrokerBytesInID);
	}

	public void validateBrokerBytesInXaxisValues() {
		page.waitForTimeout(1000);
		util.validateTheGraphdisplayingTheDataAsPerGivenTimeLines(page, XaxisValues(BrokerBytesInID), calenderView,
				WidgetXValues(XaxisValues(BrokerBytesInID)));
	}

	public void validateBrokerBytesInGraphXaxisTitle(String expectedTitle) {
		String actualTitle = page.locator(XaxisTitle(BrokerBytesInID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateBrokerBytesInGraphYaxisTitle(String expectedTitle) {
		String actualTitle = page.locator(YaxisTitle(BrokerBytesInID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateBrokerBytesInGraphBrokerHeaderTitle(String expectedTitle) {
		String actualTitle = page.locator(LegendColumn1Title(BrokerBytesInID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateBrokerBytesInGraphAvgHeaderTitle(String expectedTitle) {
		String actualTitle = page.locator(LegendColumn2Title(BrokerBytesInID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateBrokerBytesInGraphMaxHeaderTitle(String expectedTitle) {
		String actualTitle = page.locator(LegendColumn3Title(BrokerBytesInID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateBrokerBytesInGraphRowColor1(String expectedTitle) {
		String actualTitle = page.locator(RowColor1(BrokerBytesInID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateBrokerBytesInToolTipTitle() {
		page.waitForTimeout(1000);
		util.validateWidgetToolTips(page, XaxisLines(BrokerBytesInID), ToolTipTitle(BrokerBytesInID));
	}
	
////////////////////////////////////////////////////////
	
	public void validateBytesInWidgetLegendColumn1() throws InterruptedException {
		util.widgetLegendNameSort(page, LegendColumn1Sort(BrokerBytesInID), LegendColumnNameCountLocator(BrokerBytesInID));
	}
	
	public void validateBytesInWidgetLegendColumn2() throws InterruptedException {
		util.widgetLegendNameSort(page, LegendColumn2Sort(BrokerBytesInID), LegendColumnNameCountLocator(BrokerBytesInID));
	}
	
	public void validateBytesInWidgetLegendColumn3() throws InterruptedException {
		util.widgetLegendNameSort(page, LegendColumn3Sort(BrokerBytesInID), LegendColumnNameCountLocator(BrokerBytesInID));
	}

	public void validateBytesInExpandViewXAxisTitle() {
		util.validateExpandViewTexts(page, XaxisTitle(BrokerBytesInID), Expand(BrokerBytesInID), expandViewCloseBtn, expandViewXaxisTitle);
	}

	public void validateBytesInExpandViewYAxisTitle() {
		util.validateExpandViewTexts(page, YaxisTitle(BrokerBytesInID), Expand(BrokerBytesInID), expandViewCloseBtn, expandViewYaxisTitle);
	}
	
	public void validateBytesInExpandViewWidgetTitle() {
		util.validateExpandViewTexts(page, getWidgetTitle(BrokerBytesInID), Expand(BrokerBytesInID), expandViewCloseBtn, expandViewWidgetTitle);
	}
	
	public void validateBytesInExpandViewLegendHeader1() {
		util.validateExpandViewTexts(page, LegendColumn1Title(BrokerBytesInID), Expand(BrokerBytesInID), expandViewCloseBtn, expandViewLegendColumn1HeaderTitle);
	}
	
	public void validateBytesInExpandViewLegendHeader2() {
		util.validateExpandViewTexts(page, LegendColumn2Title(BrokerBytesInID), Expand(BrokerBytesInID), expandViewCloseBtn, expandViewLegendColumn2HeaderTitle);
	}
	
	public void validateBytesInExpandViewLegendHeader3() {
		util.validateExpandViewTexts(page, LegendColumn3Title(BrokerBytesInID), Expand(BrokerBytesInID), expandViewCloseBtn, expandViewLegendColumn3HeaderTitle);
	}
	
	public void validateBytesInExpandViewLegendHeader2InforMessage() {
		util.validateExpandViewTexts(page, LegendColumn2Title(BrokerBytesInID), Expand(BrokerBytesInID), expandViewCloseBtn, expandViewLegendColumnHeader2infoMessage);
	}
	
	public void validateBytesInExpandViewLegendHeader3InforMessage() {
		util.validateExpandViewTexts(page, LegendColumn3Title(BrokerBytesInID), Expand(BrokerBytesInID), expandViewCloseBtn, expandViewLegendColumnHeader3infoMessage);
	}
	
	public void validateBytesInExpandViewZoomIn() {
		page.waitForTimeout(1000);
		util.ExpandViewZoomInBtn(page, expandViewZoomInBtn, Expand(BrokerBytesInID), expandViewCloseBtn, expandViewXaxisValues);
	}
	
	public void validateBytesInExpandViewZoomOut() {
		page.waitForTimeout(1000);
		util.ExpandViewZoomOutBtn(page, expandViewZoomInBtn, Expand(BrokerBytesInID), expandViewCloseBtn, expandViewZoomOutBtn, expandViewXaxisValues);
	}
	
	public void validateBytesInExpandViewWidgetDragDrop() {
		page.waitForTimeout(1000);
		util.ExpandViewWidgetDragDrop(page, Expand(BrokerBytesInID), expandViewCloseBtn, expandViewXaxisLines, expandViewZoomOutBtn, expandViewXaxisValues);
	}
	
//////////////////////////////////////////////
//Broker - Bytes Out  Graph

	public void validateBrokerBytesOutGraphTitle(String expectedTitle) {
		String actualTitle = page.locator(getWidgetTitle(BrokerBytesOutID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateBytesOutZoomInBtn() {
		page.waitForTimeout(1000); 
		util.graphZoomIn(page, ZoomIn(BrokerBytesOutID), BrokerBytesOutID);
	}

	public void validateBytesOutZoomOutBtn() {
		page.waitForTimeout(1000); 
		util.graphZoomOut(page, ZoomIn(BrokerBytesOutID), ZoomOut(BrokerBytesOutID), BrokerBytesOutID);
	}

	public void validateBrokerBytesOutXaxisValues() {
		page.waitForTimeout(1000); 
		util.validateTheGraphdisplayingTheDataAsPerGivenTimeLines(page, XaxisValues(BrokerBytesOutID), calenderView,
				WidgetXValues(XaxisValues(BrokerBytesOutID)));
	}

	public void validateBrokerBytesOutGraphXaxisTitle(String expectedTitle) {
		String actualTitle = page.locator(XaxisTitle(BrokerBytesOutID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateBrokerBytesOutGraphYaxisTitle(String expectedTitle) {
		String actualTitle = page.locator(YaxisTitle(BrokerBytesOutID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateBrokerBytesOutGraphBrokerHeaderTitle(String expectedTitle) {
		String actualTitle = page.locator(LegendColumn1Title(BrokerBytesOutID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateBrokerBytesOutGraphAvgHeaderTitle(String expectedTitle) {
		String actualTitle = page.locator(LegendColumn2Title(BrokerBytesOutID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateBrokerBytesOutGraphMaxHeaderTitle(String expectedTitle) {
		String actualTitle = page.locator(LegendColumn3Title(BrokerBytesOutID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateBrokerBytesOutGraphRowColor1(String expectedTitle) {
		String actualTitle = page.locator(RowColor1(BrokerBytesOutID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateBrokerBytesOutToolTipTitle() {
		page.waitForTimeout(1000);
		util.validateWidgetToolTips(page, XaxisLines(BrokerBytesOutID), ToolTipTitle(BrokerBytesOutID));
	}

	public void validateBytesOutWidgetLegendColumn1() throws InterruptedException {
		util.widgetLegendNameSort(page, LegendColumn1Sort(BrokerBytesOutID), LegendColumnNameCountLocator(BrokerBytesOutID));
	}
	
	public void validateBytesOutWidgetLegendColumn2() throws InterruptedException {
		util.widgetLegendNameSort(page, LegendColumn2Sort(BrokerBytesOutID), LegendColumnNameCountLocator(BrokerBytesOutID));
	}
	
	public void validateBytesOutWidgetLegendColumn3() throws InterruptedException {
		util.widgetLegendNameSort(page, LegendColumn3Sort(BrokerBytesOutID), LegendColumnNameCountLocator(BrokerBytesOutID));
	}

	public void validateBytesOutExpandViewXAxisTitle() {
		util.validateExpandViewTexts(page, XaxisTitle(BrokerBytesOutID), Expand(BrokerBytesOutID), expandViewCloseBtn, expandViewXaxisTitle);
	}

	public void validateBytesOutExpandViewYAxisTitle() {
		util.validateExpandViewTexts(page, YaxisTitle(BrokerBytesOutID), Expand(BrokerBytesOutID), expandViewCloseBtn, expandViewYaxisTitle);
	}
	
	public void validateBytesOutExpandViewWidgetTitle() {
		util.validateExpandViewTexts(page, getWidgetTitle(BrokerBytesOutID), Expand(BrokerBytesOutID), expandViewCloseBtn, expandViewWidgetTitle);
	}
	
	public void validateBytesOutExpandViewLegendHeader1() {
		util.validateExpandViewTexts(page, LegendColumn1Title(BrokerBytesOutID), Expand(BrokerBytesOutID), expandViewCloseBtn, expandViewLegendColumn1HeaderTitle);
	}
	
	public void validateBytesOutExpandViewLegendHeader2() {
		util.validateExpandViewTexts(page, LegendColumn2Title(BrokerBytesOutID), Expand(BrokerBytesOutID), expandViewCloseBtn, expandViewLegendColumn2HeaderTitle);
	}
	
	public void validateBytesOutExpandViewLegendHeader3() {
		util.validateExpandViewTexts(page, LegendColumn3Title(BrokerBytesOutID), Expand(BrokerBytesOutID), expandViewCloseBtn, expandViewLegendColumn3HeaderTitle);
	}
	
	public void validateBytesOutExpandViewLegendHeader2InforMessage() {
		util.validateExpandViewTexts(page, LegendColumn2Title(BrokerBytesOutID), Expand(BrokerBytesOutID), expandViewCloseBtn, expandViewLegendColumnHeader2infoMessage);
	}
	
	public void validateBytesOutExpandViewLegendHeader3InforMessage() {
		util.validateExpandViewTexts(page, LegendColumn3Title(BrokerBytesOutID), Expand(BrokerBytesOutID), expandViewCloseBtn, expandViewLegendColumnHeader3infoMessage);
	}
	
	public void validateBytesOutExpandViewZoomIn() {
		page.waitForTimeout(1000);
		util.ExpandViewZoomInBtn(page, expandViewZoomInBtn, Expand(BrokerBytesOutID), expandViewCloseBtn, expandViewXaxisValues);
	}
	
	public void validateBytesOutExpandViewZoomOut() {
		page.waitForTimeout(1000);
		util.ExpandViewZoomOutBtn(page, expandViewZoomInBtn, Expand(BrokerBytesOutID), expandViewCloseBtn, expandViewZoomOutBtn, expandViewXaxisValues);
	}
	
	public void validateBytesOutExpandViewWidgetDragDrop() {
		page.waitForTimeout(1000);
		util.ExpandViewWidgetDragDrop(page, Expand(BrokerBytesOutID), expandViewCloseBtn, expandViewXaxisLines, expandViewZoomOutBtn, expandViewXaxisValues);
	}
	
	
//Broker - Total Produced Request Rate  Graph

	public void validateBrokerTotalProducedRequestRateGraphTitle(String expectedTitle) {
		String actualTitle = page.locator(getWidgetTitle(BrokerTotalProducedRequestRateID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateBrokerTotalProducedRequestRateZoomInBtn() {
		page.waitForTimeout(1000); 
		util.graphZoomIn(page, ZoomIn(BrokerTotalProducedRequestRateID), BrokerTotalProducedRequestRateID);
	}

	public void validateBrokerTotalProducedRequestRateZoomOutBtn() {
		page.waitForTimeout(1000); 
		util.graphZoomOut(page, ZoomIn(BrokerTotalProducedRequestRateID), ZoomOut(BrokerTotalProducedRequestRateID),
				BrokerTotalProducedRequestRateID);
	}

	public void validateBrokerTotalProducedRequestRateXaxisValues() {		 
		//Thread.sleep(10000);
		util.validateTheGraphdisplayingTheDataAsPerGivenTimeLines(page, XaxisValues(BrokerTotalProducedRequestRateID),
				calenderView, WidgetXValues(XaxisValues(BrokerTotalProducedRequestRateID)));
	}

	public void validateBrokerTotalProducedRequestRateGraphXaxisTitle(String expectedTitle) {
		String actualTitle = page.locator(XaxisTitle(BrokerTotalProducedRequestRateID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateBrokerTotalProducedRequestRateGraphYaxisTitle(String expectedTitle) {
		String actualTitle = page.locator(YaxisTitle(BrokerTotalProducedRequestRateID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateBrokerTotalProducedRequestRateGraphBrokerHeaderTitle(String expectedTitle) {
		String actualTitle = page.locator(LegendColumn1Title(BrokerTotalProducedRequestRateID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateBrokerTotalProducedRequestRateGraphAvgHeaderTitle(String expectedTitle) {
		String actualTitle = page.locator(LegendColumn2Title(BrokerTotalProducedRequestRateID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateBrokerTotalProducedRequestRateGraphMaxHeaderTitle(String expectedTitle) {
		String actualTitle = page.locator(LegendColumn3Title(BrokerTotalProducedRequestRateID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateBrokerTotalProducedRequestRateGraphRowColor1(String expectedTitle) {
		String actualTitle = page.locator(RowColor1(BrokerTotalProducedRequestRateID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateBrokerTotalProducedRequestRateToolTipTitle() {
		util.validateWidgetToolTips(page, XaxisLines(BrokerTotalProducedRequestRateID),ToolTipTitle(BrokerTotalProducedRequestRateID));
	}

	public void validateTotalProducedRequestRateWidgetLegendColumn1() throws InterruptedException {
		util.widgetLegendNameSort(page, LegendColumn1Sort(BrokerTotalProducedRequestRateID), LegendColumnNameCountLocator(BrokerTotalProducedRequestRateID));
	}
	
	public void validateTotalProducedRequestRateWidgetLegendColumn2() throws InterruptedException {
		util.widgetLegendNameSort(page, LegendColumn2Sort(BrokerTotalProducedRequestRateID), LegendColumnNameCountLocator(BrokerTotalProducedRequestRateID));
	}
	
	public void validateTotalProducedRequestRateWidgetLegendColumn3() throws InterruptedException {
		util.widgetLegendNameSort(page, LegendColumn3Sort(BrokerTotalProducedRequestRateID), LegendColumnNameCountLocator(BrokerTotalProducedRequestRateID));
	}

	public void validateTotalProducedRequestRateExpandViewXAxisTitle() {
		util.validateExpandViewTexts(page, XaxisTitle(BrokerTotalProducedRequestRateID), Expand(BrokerTotalProducedRequestRateID), expandViewCloseBtn, expandViewXaxisTitle);
	}

	public void validateTotalProducedRequestRateExpandViewYAxisTitle() {
		util.validateExpandViewTexts(page, YaxisTitle(BrokerTotalProducedRequestRateID), Expand(BrokerTotalProducedRequestRateID), expandViewCloseBtn, expandViewYaxisTitle);
	}
	
	public void validateTotalProducedRequestRateExpandViewWidgetTitle() {
		util.validateExpandViewTexts(page, getWidgetTitle(BrokerTotalProducedRequestRateID), Expand(BrokerTotalProducedRequestRateID), expandViewCloseBtn, expandViewWidgetTitle);
	}
	
	public void validateTotalProducedRequestRateExpandViewLegendHeader1() {
		util.validateExpandViewTexts(page, LegendColumn1Title(BrokerTotalProducedRequestRateID), Expand(BrokerTotalProducedRequestRateID), expandViewCloseBtn, expandViewLegendColumn1HeaderTitle);
	}
	
	public void validateTotalProducedRequestRateExpandViewLegendHeader2() {
		util.validateExpandViewTexts(page, LegendColumn2Title(BrokerTotalProducedRequestRateID), Expand(BrokerTotalProducedRequestRateID), expandViewCloseBtn, expandViewLegendColumn2HeaderTitle);
	}
	
	public void validateTotalProducedRequestRateExpandViewLegendHeader3() {
		util.validateExpandViewTexts(page, LegendColumn3Title(BrokerTotalProducedRequestRateID), Expand(BrokerTotalProducedRequestRateID), expandViewCloseBtn, expandViewLegendColumn3HeaderTitle);
	}
	
	public void validateTotalProducedRequestRateExpandViewLegendHeader2InforMessage() {
		util.validateExpandViewTexts(page, LegendColumn2Title(BrokerTotalProducedRequestRateID), Expand(BrokerTotalProducedRequestRateID), expandViewCloseBtn, expandViewLegendColumnHeader2infoMessage);
	}
	
	public void validateTotalProducedRequestRateExpandViewLegendHeader3InforMessage() {
		util.validateExpandViewTexts(page, LegendColumn3Title(BrokerTotalProducedRequestRateID), Expand(BrokerTotalProducedRequestRateID), expandViewCloseBtn, expandViewLegendColumnHeader3infoMessage);
	}
	
	public void validateTotalProducedRequestRateExpandViewZoomIn() {
		page.waitForTimeout(1000);
		util.ExpandViewZoomInBtn(page, expandViewZoomInBtn, Expand(BrokerTotalProducedRequestRateID), expandViewCloseBtn, expandViewXaxisValues);
	}
	
	public void validateTotalProducedRequestRateExpandViewZoomOut() {
		page.waitForTimeout(1000);
		util.ExpandViewZoomOutBtn(page, expandViewZoomInBtn, Expand(BrokerTotalProducedRequestRateID), expandViewCloseBtn, expandViewZoomOutBtn, expandViewXaxisValues);
	}
	
	public void validateTotalProducedRequestRateExpandViewWidgetDragDrop() {
		page.waitForTimeout(1000);
		util.ExpandViewWidgetDragDrop(page, Expand(BrokerTotalProducedRequestRateID), expandViewCloseBtn, expandViewXaxisLines, expandViewZoomOutBtn, expandViewXaxisValues);
	}
	
	
	
//Broker - Total Fetch Request rate  Graph

	public void validateBrokerTotalFetchRequestRateGraphTitle(String expectedTitle) {
		String actualTitle = page.locator(getWidgetTitle(BrokerTotalFetchRequestRateID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateTotalFetchRequestRateZoomInBtn() {
		page.waitForTimeout(1000); 
		util.graphZoomIn(page, ZoomIn(BrokerTotalFetchRequestRateID), BrokerTotalFetchRequestRateID);
	}

	public void validateTotalFetchRequestRateZoomOutBtn() {
		page.waitForTimeout(1000); 
		util.graphZoomOut(page, ZoomIn(BrokerTotalFetchRequestRateID), ZoomOut(BrokerTotalFetchRequestRateID),
				BrokerTotalFetchRequestRateID);
	}

	public void validateBrokerTotalFetchRequestRateXaxisValues() {
		page.waitForTimeout(1000); 
		util.validateTheGraphdisplayingTheDataAsPerGivenTimeLines(page, XaxisValues(BrokerTotalFetchRequestRateID),
				calenderView, WidgetXValues(XaxisValues(BrokerTotalFetchRequestRateID)));
	}

	public void validateBrokerTotalFetchRequestRateGraphXaxisTitle(String expectedTitle) {
		String actualTitle = page.locator(XaxisTitle(BrokerTotalFetchRequestRateID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateBrokerTotalFetchRequestRateGraphYaxisTitle(String expectedTitle) {
		String actualTitle = page.locator(YaxisTitle(BrokerTotalFetchRequestRateID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}
	
	public void validateBrokerTotalFetchRequestRateGraphBrokerHeaderTitle(String expectedTitle) {
		String actualTitle = page.locator(LegendColumn1Title(BrokerTotalFetchRequestRateID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateBrokerTotalFetchRequestRateGraphAvgHeaderTitle(String expectedTitle) {
		String actualTitle = page.locator(LegendColumn2Title(BrokerTotalFetchRequestRateID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateBrokerTotalFetchRequestRateGraphMaxHeaderTitle(String expectedTitle) {
		String actualTitle = page.locator(LegendColumn3Title(BrokerTotalFetchRequestRateID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateBrokerTotalFetchRequestRateGraphRowColor1(String expectedTitle) {
		String actualTitle = page.locator(RowColor1(BrokerTotalFetchRequestRateID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateBrokerTotalFetchRequestRateToolTipTitle() {
		page.waitForTimeout(1000);
		util.validateWidgetToolTips(page, XaxisLines(BrokerTotalFetchRequestRateID),
				ToolTipTitle(BrokerTotalFetchRequestRateID));
	}

	public void validateTotalFetchRequestRateWidgetLegendColumn1() throws InterruptedException {
		util.widgetLegendNameSort(page, LegendColumn1Sort(BrokerTotalFetchRequestRateID), LegendColumnNameCountLocator(BrokerTotalFetchRequestRateID));
	}
	
	public void validateTotalFetchRequestRateWidgetLegendColumn2() throws InterruptedException {
		util.widgetLegendNameSort(page, LegendColumn2Sort(BrokerTotalFetchRequestRateID), LegendColumnNameCountLocator(BrokerTotalFetchRequestRateID));
	}
	
	public void validateTotalFetchRequestRateWidgetLegendColumn3() throws InterruptedException {
		util.widgetLegendNameSort(page, LegendColumn3Sort(BrokerTotalFetchRequestRateID), LegendColumnNameCountLocator(BrokerTotalFetchRequestRateID));
	}

	public void validateTotalFetchRequestRateExpandViewXAxisTitle() {
		util.validateExpandViewTexts(page, XaxisTitle(BrokerTotalFetchRequestRateID), Expand(BrokerTotalFetchRequestRateID), expandViewCloseBtn, expandViewXaxisTitle);
	}

	public void validateTotalFetchRequestRateExpandViewYAxisTitle() {
		util.validateExpandViewTexts(page, YaxisTitle(BrokerTotalFetchRequestRateID), Expand(BrokerTotalFetchRequestRateID), expandViewCloseBtn, expandViewYaxisTitle);
	}
	
	public void validateTotalFetchRequestRateExpandViewWidgetTitle() {
		util.validateExpandViewTexts(page, getWidgetTitle(BrokerTotalFetchRequestRateID), Expand(BrokerTotalFetchRequestRateID), expandViewCloseBtn, expandViewWidgetTitle);
	}
	
	public void validateTotalFetchRequestRateExpandViewLegendHeader1() {
		util.validateExpandViewTexts(page, LegendColumn1Title(BrokerTotalFetchRequestRateID), Expand(BrokerTotalFetchRequestRateID), expandViewCloseBtn, expandViewLegendColumn1HeaderTitle);
	}
	
	public void validateTotalFetchRequestRateExpandViewLegendHeader2() {
		util.validateExpandViewTexts(page, LegendColumn2Title(BrokerTotalFetchRequestRateID), Expand(BrokerTotalFetchRequestRateID), expandViewCloseBtn, expandViewLegendColumn2HeaderTitle);
	}
	
	public void validateTotalFetchRequestRateExpandViewLegendHeader3() {
		util.validateExpandViewTexts(page, LegendColumn3Title(BrokerTotalFetchRequestRateID), Expand(BrokerTotalFetchRequestRateID), expandViewCloseBtn, expandViewLegendColumn3HeaderTitle);
	}
	
	public void validateTotalFetchRequestRateExpandViewLegendHeader2InforMessage() {
		util.validateExpandViewTexts(page, LegendColumn2Title(BrokerTotalFetchRequestRateID), Expand(BrokerTotalFetchRequestRateID), expandViewCloseBtn, expandViewLegendColumnHeader2infoMessage);
	}
	
	public void validateTotalFetchRequestRateExpandViewLegendHeader3InforMessage() {
		util.validateExpandViewTexts(page, LegendColumn3Title(BrokerTotalFetchRequestRateID), Expand(BrokerTotalFetchRequestRateID), expandViewCloseBtn, expandViewLegendColumnHeader3infoMessage);
	}
	
	public void validateTotalFetchRequestRateExpandViewZoomIn() {
		page.waitForTimeout(1000);
		util.ExpandViewZoomInBtn(page, expandViewZoomInBtn, Expand(BrokerTotalFetchRequestRateID), expandViewCloseBtn, expandViewXaxisValues);
	}
	
	public void validateTotalFetchRequestRateExpandViewZoomOut() {
		page.waitForTimeout(1000);
		util.ExpandViewZoomOutBtn(page, expandViewZoomInBtn, Expand(BrokerTotalFetchRequestRateID), expandViewCloseBtn, expandViewZoomOutBtn, expandViewXaxisValues);
	}
	
	public void validateTotalFetchRequestRateExpandViewWidgetDragDrop() {
		page.waitForTimeout(1000);
		util.ExpandViewWidgetDragDrop(page, Expand(BrokerTotalFetchRequestRateID), expandViewCloseBtn, expandViewXaxisLines, expandViewZoomOutBtn, expandViewXaxisValues);
	}
	
	
//Broker - MessagesIn  Graph

	public void validateBrokerMessagesInGraphTitle(String expectedTitle) {
		String actualTitle = page.locator(getWidgetTitle(BrokerMessagesInID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateMessagesInZoomInBtn() {
		page.waitForTimeout(1000); 
		util.graphZoomIn(page, ZoomIn(BrokerMessagesInID), BrokerMessagesInID);
	}

	public void validateMessagesInZoomOutBtn() {
		page.waitForTimeout(1000); 
		util.graphZoomOut(page, ZoomIn(BrokerMessagesInID), ZoomOut(BrokerMessagesInID), BrokerMessagesInID);
	}

	public void validateBrokerMessagesInXaxisValues() {
		page.waitForTimeout(1000);
		util.validateTheGraphdisplayingTheDataAsPerGivenTimeLines(page, XaxisValues(BrokerMessagesInID), calenderView,
				WidgetXValues(XaxisValues(BrokerMessagesInID)));
	}

	public void validateBrokerMessagesInGraphXaxisTitle(String expectedTitle) {
		String actualTitle = page.locator(XaxisTitle(BrokerMessagesInID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateBrokerMessagesInGraphYaxisTitle(String expectedTitle) {
		String actualTitle = page.locator(YaxisTitle(BrokerMessagesInID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}
	
	public void validateBrokerMessagesInGraphBrokerHeaderTitle(String expectedTitle) {
		String actualTitle = page.locator(LegendColumn1Title(BrokerMessagesInID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateBrokerMessagesInGraphAvgHeaderTitle(String expectedTitle) {
		String actualTitle = page.locator(LegendColumn2Title(BrokerMessagesInID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateBrokerMessagesInGraphMaxHeaderTitle(String expectedTitle) {
		String actualTitle = page.locator(LegendColumn3Title(BrokerMessagesInID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateBrokerMessagesInGraphRowColor1(String expectedTitle) {
		String actualTitle = page.locator(RowColor1(BrokerMessagesInID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateBrokerMessagesInToolTipTitle() {
		util.validateWidgetToolTips(page, XaxisLines(BrokerMessagesInID), ToolTipTitle(BrokerMessagesInID));
	}

	public void validateMessagesInWidgetLegendColumn1() throws InterruptedException {
		util.widgetLegendNameSort(page, LegendColumn1Sort(BrokerMessagesInID), LegendColumnNameCountLocator(BrokerMessagesInID));
	}
	
	public void validateMessagesInWidgetLegendColumn2() throws InterruptedException {
		util.widgetLegendNameSort(page, LegendColumn2Sort(BrokerMessagesInID), LegendColumnNameCountLocator(BrokerMessagesInID));
	}
	
	public void validateMessagesInWidgetLegendColumn3() throws InterruptedException {
		util.widgetLegendNameSort(page, LegendColumn3Sort(BrokerMessagesInID), LegendColumnNameCountLocator(BrokerMessagesInID));
	}

	public void validateMessagesInExpandViewXAxisTitle() {
		util.validateExpandViewTexts(page, XaxisTitle(BrokerMessagesInID), Expand(BrokerMessagesInID), expandViewCloseBtn, expandViewXaxisTitle);
	}

	public void validateMessagesInExpandViewYAxisTitle() {
		util.validateExpandViewTexts(page, YaxisTitle(BrokerMessagesInID), Expand(BrokerMessagesInID), expandViewCloseBtn, expandViewYaxisTitle);
	}
	
	public void validateMessagesInExpandViewWidgetTitle() {
		util.validateExpandViewTexts(page, getWidgetTitle(BrokerMessagesInID), Expand(BrokerMessagesInID), expandViewCloseBtn, expandViewWidgetTitle);
	}
	
	public void validateMessagesInExpandViewLegendHeader1() {
		util.validateExpandViewTexts(page, LegendColumn1Title(BrokerMessagesInID), Expand(BrokerMessagesInID), expandViewCloseBtn, expandViewLegendColumn1HeaderTitle);
	}
	
	public void validateMessagesInExpandViewLegendHeader2() {
		util.validateExpandViewTexts(page, LegendColumn2Title(BrokerMessagesInID), Expand(BrokerMessagesInID), expandViewCloseBtn, expandViewLegendColumn2HeaderTitle);
	}
	
	public void validateMessagesInExpandViewLegendHeader3() {
		util.validateExpandViewTexts(page, LegendColumn3Title(BrokerMessagesInID), Expand(BrokerMessagesInID), expandViewCloseBtn, expandViewLegendColumn3HeaderTitle);
	}
	
	public void validateMessagesInExpandViewLegendHeader2InforMessage() {
		util.validateExpandViewTexts(page, LegendColumn2Title(BrokerMessagesInID), Expand(BrokerMessagesInID), expandViewCloseBtn, expandViewLegendColumnHeader2infoMessage);
	}
	
	public void validateMessagesInExpandViewLegendHeader3InforMessage() {
		util.validateExpandViewTexts(page, LegendColumn3Title(BrokerMessagesInID), Expand(BrokerMessagesInID), expandViewCloseBtn, expandViewLegendColumnHeader3infoMessage);
	}
	
	public void validateMessagesInExpandViewZoomIn() {
		page.waitForTimeout(1000);
		util.ExpandViewZoomInBtn(page, expandViewZoomInBtn, Expand(BrokerMessagesInID), expandViewCloseBtn, expandViewXaxisValues);
	}
	
	public void validateMessagesInExpandViewZoomOut() {
		page.waitForTimeout(1000);
		util.ExpandViewZoomOutBtn(page, expandViewZoomInBtn, Expand(BrokerMessagesInID), expandViewCloseBtn, expandViewZoomOutBtn, expandViewXaxisValues);
	}
	
	public void validateMessagesInExpandViewWidgetDragDrop() {
		page.waitForTimeout(1000);
		util.ExpandViewWidgetDragDrop(page, Expand(BrokerMessagesInID), expandViewCloseBtn, expandViewXaxisLines, expandViewZoomOutBtn, expandViewXaxisValues);
	}
	
	
//Broker - Leader Election Rate  Graph

	public void validateBrokerLeaderElectionRateGraphTitle(String expectedTitle) {
		String actualTitle = page.locator(getWidgetTitle(BrokerLeaderElectionRateID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateLeaderElectionRateZoomInBtn() {
		page.waitForTimeout(1000); 
		util.graphZoomIn(page, ZoomIn(BrokerLeaderElectionRateID), BrokerLeaderElectionRateID);
	}

	public void validateLeaderElectionRateZoomOutBtn() {
		page.waitForTimeout(1000); 
		util.graphZoomOut(page, ZoomIn(BrokerLeaderElectionRateID), ZoomOut(BrokerLeaderElectionRateID),
				BrokerLeaderElectionRateID);
	}

	public void validateBrokerLeaderElectionRateXaxisValues() {
		page.waitForTimeout(1000); 
		util.validateTheGraphdisplayingTheDataAsPerGivenTimeLines(page, XaxisValues(BrokerLeaderElectionRateID),
				calenderView, WidgetXValues(XaxisValues(BrokerLeaderElectionRateID)));
	}

	public void validateBrokerLeaderElectionRateGraphXaxisTitle(String expectedTitle) {
		String actualTitle = page.locator(XaxisTitle(BrokerLeaderElectionRateID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateBrokerLeaderElectionRateGraphYaxisTitle(String expectedTitle) {
		String actualTitle = page.locator(YaxisTitle(BrokerLeaderElectionRateID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateBrokerLeaderElectionRateGraphBrokerHeaderTitle(String expectedTitle) {
		String actualTitle = page.locator(LegendColumn1Title(BrokerLeaderElectionRateID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateBrokerLeaderElectionRateGraphAvgHeaderTitle(String expectedTitle) {
		String actualTitle = page.locator(LegendColumn2Title(BrokerLeaderElectionRateID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateBrokerLeaderElectionRateGraphMaxHeaderTitle(String expectedTitle) {
		String actualTitle = page.locator(LegendColumn3Title(BrokerLeaderElectionRateID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateBrokerLeaderElectionRateGraphRowColor1(String expectedTitle) {
		String actualTitle = page.locator(RowColor1(BrokerLeaderElectionRateID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateBrokerLeaderElectionRateToolTipTitle() {
		page.waitForTimeout(1000);
		util.validateWidgetToolTips(page, XaxisLines(BrokerLeaderElectionRateID),
				ToolTipTitle(BrokerLeaderElectionRateID));
	}

	public void validateLeaderElectionRateWidgetLegendColumn1() throws InterruptedException {
		util.widgetLegendNameSort(page, LegendColumn1Sort(BrokerLeaderElectionRateID), LegendColumnNameCountLocator(BrokerLeaderElectionRateID));
	}
	
	public void validateLeaderElectionRateWidgetLegendColumn2() throws InterruptedException {
		util.widgetLegendNameSort(page, LegendColumn2Sort(BrokerLeaderElectionRateID), LegendColumnNameCountLocator(BrokerLeaderElectionRateID));
	}
	
	public void validateLeaderElectionRateWidgetLegendColumn3() throws InterruptedException {
		util.widgetLegendNameSort(page, LegendColumn3Sort(BrokerLeaderElectionRateID), LegendColumnNameCountLocator(BrokerLeaderElectionRateID));
	}

	public void validateLeaderElectionRateExpandViewXAxisTitle() {
		util.validateExpandViewTexts(page, XaxisTitle(BrokerLeaderElectionRateID), Expand(BrokerLeaderElectionRateID), expandViewCloseBtn, expandViewXaxisTitle);
	}

	public void validateLeaderElectionRateExpandViewYAxisTitle() {
		page.waitForTimeout(1000);
		util.validateExpandViewTexts(page, YaxisTitle(BrokerLeaderElectionRateID), Expand(BrokerLeaderElectionRateID), expandViewCloseBtn, expandViewYaxisTitle);
	}
	
	public void validateLeaderElectionRateExpandViewWidgetTitle() {
		util.validateExpandViewTexts(page, getWidgetTitle(BrokerLeaderElectionRateID), Expand(BrokerLeaderElectionRateID), expandViewCloseBtn, expandViewWidgetTitle);
	}
	
	public void validateLeaderElectionRateExpandViewLegendHeader1() {
		util.validateExpandViewTexts(page, LegendColumn1Title(BrokerLeaderElectionRateID), Expand(BrokerLeaderElectionRateID), expandViewCloseBtn, expandViewLegendColumn1HeaderTitle);
	}
	
	public void validateLeaderElectionRateExpandViewLegendHeader2() {
		util.validateExpandViewTexts(page, LegendColumn2Title(BrokerLeaderElectionRateID), Expand(BrokerLeaderElectionRateID), expandViewCloseBtn, expandViewLegendColumn2HeaderTitle);
	}
	
	public void validateLeaderElectionRateExpandViewLegendHeader3() {
		util.validateExpandViewTexts(page, LegendColumn3Title(BrokerLeaderElectionRateID), Expand(BrokerLeaderElectionRateID), expandViewCloseBtn, expandViewLegendColumn3HeaderTitle);
	}
	
	public void validateLeaderElectionRateExpandViewLegendHeader2InforMessage() {
		util.validateExpandViewTexts(page, LegendColumn2Title(BrokerLeaderElectionRateID), Expand(BrokerLeaderElectionRateID), expandViewCloseBtn, expandViewLegendColumnHeader2infoMessage);
	}
	
	public void validateLeaderElectionRateExpandViewLegendHeader3InforMessage() {
		util.validateExpandViewTexts(page, LegendColumn3Title(BrokerLeaderElectionRateID), Expand(BrokerLeaderElectionRateID), expandViewCloseBtn, expandViewLegendColumnHeader3infoMessage);
	}
	
	public void validateLeaderElectionRateExpandViewZoomIn() {
		page.waitForTimeout(1000);
		util.ExpandViewZoomInBtn(page, expandViewZoomInBtn, Expand(BrokerLeaderElectionRateID), expandViewCloseBtn, expandViewXaxisValues);
	}
	
	public void validateLeaderElectionRateExpandViewZoomOut() {
		page.waitForTimeout(1000);
		util.ExpandViewZoomOutBtn(page, expandViewZoomInBtn, Expand(BrokerLeaderElectionRateID), expandViewCloseBtn, expandViewZoomOutBtn, expandViewXaxisValues);
	}
	
	public void validateLeaderElectionRateExpandViewWidgetDragDrop() {
		page.waitForTimeout(1000);
		util.ExpandViewWidgetDragDrop(page, Expand(BrokerLeaderElectionRateID), expandViewCloseBtn, expandViewXaxisLines, expandViewZoomOutBtn, expandViewXaxisValues);
	}
	
	
	
//Broker - Un-cleaned Election Leader  Graph

	public void validateBrokerUncleanedElectionLeaderGraphTitle(String expectedTitle) {
		String actualTitle = page.locator(getWidgetTitle(BrokerUncleanedElectionLeaderID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateUncleanedElectionLeaderZoomInBtn() {
		page.waitForTimeout(1000); 
		util.graphZoomIn(page, ZoomIn(BrokerUncleanedElectionLeaderID), BrokerUncleanedElectionLeaderID);
	}

	public void validateUncleanedElectionLeaderZoomOutBtn() {
		page.waitForTimeout(1000); 
		util.graphZoomOut(page, ZoomIn(BrokerUncleanedElectionLeaderID), ZoomOut(BrokerUncleanedElectionLeaderID),
				BrokerUncleanedElectionLeaderID);
	}

	public void validateBrokerUncleanedElectionLeaderXaxisValues() {
		page.waitForTimeout(1000); 
		util.validateTheGraphdisplayingTheDataAsPerGivenTimeLines(page, XaxisValues(BrokerUncleanedElectionLeaderID),
				calenderView, WidgetXValues(XaxisValues(BrokerUncleanedElectionLeaderID)));
	}

	public void validateBrokerUncleanedElectionLeaderGraphXaxisTitle(String expectedTitle) {
		String actualTitle = page.locator(XaxisTitle(BrokerUncleanedElectionLeaderID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateBrokerUncleanedElectionLeaderGraphYaxisTitle(String expectedTitle) {
		String actualTitle = page.locator(YaxisTitle(BrokerUncleanedElectionLeaderID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateBrokerUncleanedElectionLeaderGraphBrokerHeaderTitle(String expectedTitle) {
		String actualTitle = page.locator(LegendColumn1Title(BrokerUncleanedElectionLeaderID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateBrokerUncleanedElectionLeaderGraphAvgHeaderTitle(String expectedTitle) {
		String actualTitle = page.locator(LegendColumn2Title(BrokerUncleanedElectionLeaderID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateBrokerUncleanedElectionLeaderGraphMaxHeaderTitle(String expectedTitle) {
		String actualTitle = page.locator(LegendColumn3Title(BrokerUncleanedElectionLeaderID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateBrokerUncleanedElectionLeaderGraphRowColor1(String expectedTitle) {
		String actualTitle = page.locator(RowColor1(BrokerUncleanedElectionLeaderID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateBrokerUncleanedElectionLeaderToolTipTitle() {
		page.waitForTimeout(1000);
		util.validateWidgetToolTips(page, XaxisLines(BrokerUncleanedElectionLeaderID),
				ToolTipTitle(BrokerUncleanedElectionLeaderID));
	}

	public void validateUncleanedElectionLeaderWidgetLegendColumn1() throws InterruptedException {
		util.widgetLegendNameSort(page, LegendColumn1Sort(BrokerUncleanedElectionLeaderID), LegendColumnNameCountLocator(BrokerUncleanedElectionLeaderID));
	}
	
	public void validateUncleanedElectionLeaderWidgetLegendColumn2() throws InterruptedException {
		util.widgetLegendNameSort(page, LegendColumn2Sort(BrokerUncleanedElectionLeaderID), LegendColumnNameCountLocator(BrokerUncleanedElectionLeaderID));
	}
	
	public void validateUncleanedElectionLeaderWidgetLegendColumn3() throws InterruptedException {
		util.widgetLegendNameSort(page, LegendColumn3Sort(BrokerUncleanedElectionLeaderID), LegendColumnNameCountLocator(BrokerUncleanedElectionLeaderID));
	}

	public void validateUncleanedElectionLeaderExpandViewXAxisTitle() {
		util.validateExpandViewTexts(page, XaxisTitle(BrokerUncleanedElectionLeaderID), Expand(BrokerUncleanedElectionLeaderID), expandViewCloseBtn, expandViewXaxisTitle);
	}

	public void validateUncleanedElectionLeaderExpandViewYAxisTitle() {
		util.validateExpandViewTexts(page, YaxisTitle(BrokerUncleanedElectionLeaderID), Expand(BrokerUncleanedElectionLeaderID), expandViewCloseBtn, expandViewYaxisTitle);
	}
	
	public void validateUncleanedElectionLeaderExpandViewWidgetTitle() {
		page.waitForTimeout(1000);
		util.validateExpandViewTexts(page, getWidgetTitle(BrokerUncleanedElectionLeaderID), Expand(BrokerUncleanedElectionLeaderID), expandViewCloseBtn, expandViewWidgetTitle);
	}
	
	public void validateUncleanedElectionLeaderExpandViewLegendHeader1() {
		util.validateExpandViewTexts(page, LegendColumn1Title(BrokerUncleanedElectionLeaderID), Expand(BrokerUncleanedElectionLeaderID), expandViewCloseBtn, expandViewLegendColumn1HeaderTitle);
	}
	
	public void validateUncleanedElectionLeaderExpandViewLegendHeader2() {
		util.validateExpandViewTexts(page, LegendColumn2Title(BrokerUncleanedElectionLeaderID), Expand(BrokerUncleanedElectionLeaderID), expandViewCloseBtn, expandViewLegendColumn2HeaderTitle);
	}
	
	public void validateUncleanedElectionLeaderExpandViewLegendHeader3() {
		util.validateExpandViewTexts(page, LegendColumn3Title(BrokerUncleanedElectionLeaderID), Expand(BrokerUncleanedElectionLeaderID), expandViewCloseBtn, expandViewLegendColumn3HeaderTitle);
	}
	
	public void validateUncleanedElectionLeaderExpandViewLegendHeader2InforMessage() {
		util.validateExpandViewTexts(page, LegendColumn2Title(BrokerUncleanedElectionLeaderID), Expand(BrokerUncleanedElectionLeaderID), expandViewCloseBtn, expandViewLegendColumnHeader2infoMessage);
	}
	
	public void validateUncleanedElectionLeaderExpandViewLegendHeader3InforMessage() {
		util.validateExpandViewTexts(page, LegendColumn3Title(BrokerUncleanedElectionLeaderID), Expand(BrokerUncleanedElectionLeaderID), expandViewCloseBtn, expandViewLegendColumnHeader3infoMessage);
	}
	
	public void validateUncleanedElectionLeaderExpandViewZoomIn() {
		page.waitForTimeout(1000);
		util.ExpandViewZoomInBtn(page, expandViewZoomInBtn, Expand(BrokerUncleanedElectionLeaderID), expandViewCloseBtn, expandViewXaxisValues);
	}
	
	public void validateUncleanedElectionLeaderExpandViewZoomOut() {
		page.waitForTimeout(1000);
		util.ExpandViewZoomOutBtn(page, expandViewZoomInBtn, Expand(BrokerUncleanedElectionLeaderID), expandViewCloseBtn, expandViewZoomOutBtn, expandViewXaxisValues);
	}
	
	public void validateUncleanedElectionLeaderExpandViewWidgetDragDrop() {
		page.waitForTimeout(1000);
		util.ExpandViewWidgetDragDrop(page, Expand(BrokerUncleanedElectionLeaderID), expandViewCloseBtn, expandViewXaxisLines, expandViewZoomOutBtn, expandViewXaxisValues);
	}
	
	
//Broker - Number of Brokers  Graph

	public void validateBrokerNumberOfBrokersGraphTitle(String expectedTitle) {
		String actualTitle = page.locator(getWidgetTitle(BrokerNumberOfBrokersID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	
	public void validateNumberOfBrokersZoomInBtn() {
		page.waitForTimeout(1000); 
		util.graphZoomIn(page, ZoomIn(BrokerNumberOfBrokersID), BrokerNumberOfBrokersID);
	}

	public void validateNumberOfBrokersZoomOutBtn() {
		page.waitForTimeout(1000);
		util.graphZoomOut(page, ZoomIn(BrokerNumberOfBrokersID), ZoomOut(BrokerNumberOfBrokersID),
				BrokerNumberOfBrokersID);
	}

	public void validateNumberOfBrokersResetBtn() {
		util.graphZoomReset(page, expandViewZoomInBtn, BrokerBytesInID, null);;
	}
	
	public void validateBrokerNumberOfBrokersXaxisValues() {
		page.waitForTimeout(1000); 
		util.validateTheGraphdisplayingTheDataAsPerGivenTimeLines(page, XaxisValues(BrokerNumberOfBrokersID),
				calenderView, WidgetXValues(XaxisValues(BrokerNumberOfBrokersID)));
	}

	public void validateBrokerNumberOfBrokersGraphXaxisTitle(String expectedTitle) {
		page.waitForTimeout(1000);
		String actualTitle = page.locator(XaxisTitle(BrokerNumberOfBrokersID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateBrokerNumberOfBrokersGraphYaxisTitle(String expectedTitle) {
		page.waitForTimeout(1000);
		String actualTitle = page.locator(YaxisTitle(BrokerNumberOfBrokersID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateBrokerNumberOfBrokersGraphToolTip(String expectedTitle) {
		page.waitForTimeout(1000);
		String actualTitle = page.locator(BrokerNumberOfBrokersID).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	
	
	/**
	 * Producer Tab
	 */

	public void validateProducerTabTitle(String expectedTitle) {
		
		String actualTitle = page.locator(ProducerTabTitle).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void clickOnProducerTab() {
		page.locator(ProducerTabTitle).click();
		String actualTitle = page
				.locator("//div[@class='overviewTabSelector']/child::div[@class='kafkaTabItem kafkaActiveTab']")
				.textContent().trim();
		Assert.assertEquals(actualTitle.equalsIgnoreCase("Producer"), true);

	}

//Producer < Request Rate Graph

	public void validateProducerRequestRateGraphTitle(String expectedTitle) {
		page.waitForTimeout(1000);
		String actualTitle = page.locator(getWidgetTitle(ProducerRequestRateID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateProducerRequestRateGraphZoomInBtn() {
		page.waitForTimeout(1000); 
		util.graphZoomIn(page, ZoomIn(ProducerRequestRateID), ProducerRequestRateID);
	}

	public void validateProducerRequestRateGraphZoomOutBtn() {
		page.waitForTimeout(1000); 
		util.graphZoomOut(page, ZoomIn(ProducerRequestRateID), ZoomOut(ProducerRequestRateID), ProducerRequestRateID);
	}

	public void validateProducerRequestRateXaxisValues() {
		page.waitForTimeout(1000);
		util.validateTheGraphdisplayingTheDataAsPerGivenTimeLines(page, XaxisValues(ProducerRequestRateID),
				calenderView, WidgetXValues(XaxisValues(ProducerRequestRateID)));
	}

	public void validateProducerRequestRateGraphXaxisTitle(String expectedTitle) {
		String actualTitle = page.locator(XaxisTitle(ProducerRequestRateID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateProducerRequestRateGraphYaxisTitle(String expectedTitle) {
		page.waitForTimeout(1000);
		String actualTitle = page.locator(YaxisTitle(ProducerRequestRateID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateProducerRequestRateGraphBrokerHeaderTitle(String expectedTitle) {
		page.waitForTimeout(1000);
		String actualTitle = page.locator(LegendColumn1Title(ProducerRequestRateID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateProducerRequestRateGraphAvgHeaderTitle(String expectedTitle) {
		page.waitForTimeout(1000); 
		String actualTitle = page.locator(LegendColumn2Title(ProducerRequestRateID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateProducerRequestRateGraphMaxHeaderTitle(String expectedTitle) {
		page.waitForTimeout(1000); 
		String actualTitle = page.locator(LegendColumn3Title(ProducerRequestRateID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateProducerRequestRateGraphRowColor1(String expectedTitle) {
		page.waitForTimeout(1000); 
		String actualTitle = page.locator(RowColor1(ProducerRequestRateID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateProducerRequestRateToolTipTitle() {
		page.waitForTimeout(1000); 
		util.validateWidgetToolTips(page, XaxisLines(ProducerRequestRateID), ToolTipTitle(ProducerRequestRateID));
	}

	public void validateProducerRequestRateWidgetLegendColumn1() throws InterruptedException {
		page.waitForTimeout(1000); 
		util.widgetLegendNameSort(page, LegendColumn1Sort(ProducerRequestRateID), LegendColumnNameCountLocator(ProducerRequestRateID));
	}
	
	public void validateProducerRequestRateWidgetLegendColumn2() throws InterruptedException {
		page.waitForTimeout(1000); 
		util.widgetLegendNameSort(page, LegendColumn2Sort(ProducerRequestRateID), LegendColumnNameCountLocator(ProducerRequestRateID));
	}
	
	public void validateProducerRequestRateWidgetLegendColumn3() throws InterruptedException {
		page.waitForTimeout(1000); 
		util.widgetLegendNameSort(page, LegendColumn3Sort(ProducerRequestRateID), LegendColumnNameCountLocator(ProducerRequestRateID));
	}

	public void validateProducerRequestRateExpandViewXAxisTitle() {
		page.waitForTimeout(1000); 
		util.validateExpandViewTexts(page, XaxisTitle(ProducerRequestRateID), Expand(ProducerRequestRateID), expandViewCloseBtn, expandViewXaxisTitle);
	}

	public void validateProducerRequestRateExpandViewYAxisTitle() {
		page.waitForTimeout(1000); 
		util.validateExpandViewTexts(page, YaxisTitle(ProducerRequestRateID), Expand(ProducerRequestRateID), expandViewCloseBtn, expandViewYaxisTitle);
	}
	
	public void validateProducerRequestRateExpandViewWidgetTitle() {
		page.waitForTimeout(1000); 
		util.validateExpandViewTexts(page, getWidgetTitle(ProducerRequestRateID), Expand(ProducerRequestRateID), expandViewCloseBtn, expandViewWidgetTitle);
	}
	
	public void validateProducerRequestRateExpandViewLegendHeader1() {
		page.waitForTimeout(1000); 
		util.validateExpandViewTexts(page, LegendColumn1Title(ProducerRequestRateID), Expand(ProducerRequestRateID), expandViewCloseBtn, expandViewLegendColumn1HeaderTitle);
	}
	
	public void validateProducerRequestRateExpandViewLegendHeader2() {
		page.waitForTimeout(1000); 
		util.validateExpandViewTexts(page, LegendColumn2Title(ProducerRequestRateID), Expand(ProducerRequestRateID), expandViewCloseBtn, expandViewLegendColumn2HeaderTitle);
	}
	
	public void validateProducerRequestRateExpandViewLegendHeader3() {
		page.waitForTimeout(1000); 
		util.validateExpandViewTexts(page, LegendColumn3Title(ProducerRequestRateID), Expand(ProducerRequestRateID), expandViewCloseBtn, expandViewLegendColumn3HeaderTitle);
	}
	
	public void validateProducerRequestRateExpandViewLegendHeader2InforMessage() {
		util.validateExpandViewTexts(page, LegendColumn2Title(ProducerRequestRateID), Expand(ProducerRequestRateID), expandViewCloseBtn, expandViewLegendColumnHeader2infoMessage);
	}
	
	public void validateProducerRequestRateExpandViewLegendHeader3InforMessage() {
		util.validateExpandViewTexts(page, LegendColumn3Title(ProducerRequestRateID), Expand(ProducerRequestRateID), expandViewCloseBtn, expandViewLegendColumnHeader3infoMessage);
	}
	
	public void validateProducerRequestRateExpandViewZoomIn() {
		page.waitForTimeout(1000); 
		util.ExpandViewZoomInBtn(page, expandViewZoomInBtn, Expand(ProducerRequestRateID), expandViewCloseBtn, expandViewXaxisValues);
	}
	
	public void validateProducerRequestRateExpandViewZoomOut() {
		page.waitForTimeout(1000); 
		util.ExpandViewZoomOutBtn(page, expandViewZoomInBtn, Expand(ProducerRequestRateID), expandViewCloseBtn, expandViewZoomOutBtn, expandViewXaxisValues);
	}
	
	public void validateProducerRequestRateExpandViewWidgetDragDrop() {
		page.waitForTimeout(1000);
		util.ExpandViewWidgetDragDrop(page, Expand(ProducerRequestRateID), expandViewCloseBtn, expandViewXaxisLines, expandViewZoomOutBtn, expandViewXaxisValues);
	}
	
	
//Producer < Response Rate Graph

	public void validateProducerResponseRateGraphTitle(String expectedTitle) {
		page.waitForTimeout(1000);
		String actualTitle = page.locator(getWidgetTitle(ProducerResponseRateID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateProducerResponseRateGraphZoomInBtn() {
		page.waitForTimeout(1000); 
		util.graphZoomIn(page, ZoomIn(ProducerResponseRateID), ProducerResponseRateID);
	}

	public void validateProducerResponseRateGraphZoomOutBtn() {
		page.waitForTimeout(1000); 
		util.graphZoomOut(page, ZoomIn(ProducerResponseRateID), ZoomOut(ProducerResponseRateID),
				ProducerResponseRateID);
	}

	public void validateProducerResponseRateXaxisValues() {
		page.waitForTimeout(1000);
		util.validateTheGraphdisplayingTheDataAsPerGivenTimeLines(page, XaxisValues(ProducerResponseRateID),
				calenderView, WidgetXValues(XaxisValues(ProducerResponseRateID)));
	}

	public void validateProducerResponseRateGraphXaxisTitle(String expectedTitle) {
		page.waitForTimeout(1000);
		String actualTitle = page.locator(XaxisTitle(ProducerResponseRateID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateProducerResponseRateGraphYaxisTitle(String expectedTitle) {
		page.waitForTimeout(1000);
		String actualTitle = page.locator(YaxisTitle(ProducerResponseRateID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateProducerResponseRateGraphBrokerHeaderTitle(String expectedTitle) {
		page.waitForTimeout(1000);
		String actualTitle = page.locator(LegendColumn1Title(ProducerResponseRateID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateProducerResponseRateGraphAvgHeaderTitle(String expectedTitle) {
		page.waitForTimeout(1000);
		String actualTitle = page.locator(LegendColumn2Title(ProducerResponseRateID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateProducerResponseRateGraphMaxHeaderTitle(String expectedTitle) {
		page.waitForTimeout(1000);
		String actualTitle = page.locator(LegendColumn3Title(ProducerResponseRateID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateProducerResponseRateGraphRowColor1(String expectedTitle) {
		page.waitForTimeout(1000);
		String actualTitle = page.locator(RowColor1(ProducerResponseRateID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateProducerResponseRateToolTipTitle() {
		page.waitForTimeout(1000);
		util.validateWidgetToolTips(page, XaxisLines(ProducerResponseRateID), ToolTipTitle(ProducerResponseRateID));
	}

	public void validateProducerResponseRateWidgetLegendColumn1() throws InterruptedException {
		page.waitForTimeout(1000);
		util.widgetLegendNameSort(page, LegendColumn1Sort(ProducerResponseRateID), LegendColumnNameCountLocator(ProducerResponseRateID));
	}
	
	public void validateProducerResponseRateWidgetLegendColumn2() throws InterruptedException {
		page.waitForTimeout(1000);
		util.widgetLegendNameSort(page, LegendColumn2Sort(ProducerResponseRateID), LegendColumnNameCountLocator(ProducerResponseRateID));
	}
	
	public void validateProducerResponseRateWidgetLegendColumn3() throws InterruptedException {
		page.waitForTimeout(1000);
		util.widgetLegendNameSort(page, LegendColumn3Sort(ProducerResponseRateID), LegendColumnNameCountLocator(ProducerResponseRateID));
	}

	public void validateProducerResponseRateExpandViewXAxisTitle() {
		page.waitForTimeout(1000);
		util.validateExpandViewTexts(page, XaxisTitle(ProducerResponseRateID), Expand(ProducerResponseRateID), expandViewCloseBtn, expandViewXaxisTitle);
	}

	public void validateProducerResponseRateExpandViewYAxisTitle() {
		page.waitForTimeout(1000);
		util.validateExpandViewTexts(page, YaxisTitle(ProducerResponseRateID), Expand(ProducerResponseRateID), expandViewCloseBtn, expandViewYaxisTitle);
	}
	
	public void validateProducerResponseRateExpandViewWidgetTitle() {
		page.waitForTimeout(1000);
		util.validateExpandViewTexts(page, getWidgetTitle(ProducerResponseRateID), Expand(ProducerResponseRateID), expandViewCloseBtn, expandViewWidgetTitle);
	}
	
	public void validateProducerResponseRateExpandViewLegendHeader1() {
		page.waitForTimeout(1000); 
		util.validateExpandViewTexts(page, LegendColumn1Title(ProducerResponseRateID), Expand(ProducerResponseRateID), expandViewCloseBtn, expandViewLegendColumn1HeaderTitle);
	}
	
	public void validateProducerResponseRateExpandViewLegendHeader2() {
		page.waitForTimeout(1000); 
		util.validateExpandViewTexts(page, LegendColumn2Title(ProducerResponseRateID), Expand(ProducerResponseRateID), expandViewCloseBtn, expandViewLegendColumn2HeaderTitle);
	}
	
	public void validateProducerResponseRateExpandViewLegendHeader3() {
		page.waitForTimeout(1000); 
		util.validateExpandViewTexts(page, LegendColumn3Title(ProducerResponseRateID), Expand(ProducerResponseRateID), expandViewCloseBtn, expandViewLegendColumn3HeaderTitle);
	}
	
	public void validateProducerResponseRateExpandViewLegendHeader2InforMessage() {
		util.validateExpandViewTexts(page, LegendColumn2Title(ProducerResponseRateID), Expand(ProducerResponseRateID), expandViewCloseBtn, expandViewLegendColumnHeader2infoMessage);
	}
	
	public void validateProducerResponseRateExpandViewLegendHeader3InforMessage() {
		util.validateExpandViewTexts(page, LegendColumn3Title(ProducerResponseRateID), Expand(ProducerResponseRateID), expandViewCloseBtn, expandViewLegendColumnHeader3infoMessage);
	}
	
	public void validateProducerResponseRateExpandViewZoomIn() {
		page.waitForTimeout(1000); 
		util.ExpandViewZoomInBtn(page, expandViewZoomInBtn, Expand(ProducerResponseRateID), expandViewCloseBtn, expandViewXaxisValues);
	}
	
	public void validateProducerResponseRateExpandViewZoomOut() {
		page.waitForTimeout(1000); 
		util.ExpandViewZoomOutBtn(page, expandViewZoomInBtn, Expand(ProducerResponseRateID), expandViewCloseBtn, expandViewZoomOutBtn, expandViewXaxisValues);
	}
	
	public void validateProducerResponseRateExpandViewWidgetDragDrop() {
		page.waitForTimeout(1000); 
		util.ExpandViewWidgetDragDrop(page, Expand(ProducerResponseRateID), expandViewCloseBtn, expandViewXaxisLines, expandViewZoomOutBtn, expandViewXaxisValues);
	}
	
	
	
//Producer < Error Rate Graph

	public void validateProducerErrorRateGraphTitle(String expectedTitle) {
		String actualTitle = page.locator(getWidgetTitle(ProducerErrorRateID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateProducerErrorRateGraphZoomInBtn() {
		page.waitForTimeout(1000); 
		util.graphZoomIn(page, ZoomIn(ProducerErrorRateID), ProducerErrorRateID);
	}

	public void validateProducerErrorRateGraphZoomOutBtn() {
		page.waitForTimeout(1000);  
		util.graphZoomOut(page, ZoomIn(ProducerErrorRateID), ZoomOut(ProducerErrorRateID), ProducerErrorRateID);
	}

	public void validateProducerErrorRateXaxisValues() {
		page.waitForTimeout(1000);  
		util.validateTheGraphdisplayingTheDataAsPerGivenTimeLines(page, XaxisValues(ProducerErrorRateID), calenderView,
				WidgetXValues(XaxisValues(ProducerErrorRateID)));
	}

	public void validateProducerErrorRateGraphXaxisTitle(String expectedTitle) {
		page.waitForTimeout(1000); 
		String actualTitle = page.locator(XaxisTitle(ProducerErrorRateID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateProducerErrorRateGraphYaxisTitle(String expectedTitle) {
		page.waitForTimeout(1000); 
		String actualTitle = page.locator(YaxisTitle(ProducerErrorRateID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateProducerErrorRateGraphBrokerHeaderTitle(String expectedTitle) {
		page.waitForTimeout(1000); 
		String actualTitle = page.locator(LegendColumn1Title(ProducerErrorRateID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateProducerErrorRateGraphAvgHeaderTitle(String expectedTitle) {
		page.waitForTimeout(1000); 
		String actualTitle = page.locator(LegendColumn2Title(ProducerErrorRateID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateProducerErrorRateGraphMaxHeaderTitle(String expectedTitle) {
		page.waitForTimeout(1000); 
		String actualTitle = page.locator(LegendColumn3Title(ProducerErrorRateID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateProducerErrorRateGraphRowColor1(String expectedTitle) {
		page.waitForTimeout(1000); 
		String actualTitle = page.locator(RowColor1(ProducerErrorRateID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateProducerErrorRateToolTipTitle() {
		page.waitForTimeout(1000); 
		util.validateWidgetToolTips(page, XaxisLines(ProducerErrorRateID), ToolTipTitle(ProducerErrorRateID));
	}

	public void validateProducerErrorRateWidgetLegendColumn1() throws InterruptedException {
		page.waitForTimeout(1000); 
		util.widgetLegendNameSort(page, LegendColumn1Sort(ProducerErrorRateID), LegendColumnNameCountLocator(ProducerErrorRateID));
	}
	
	public void validateProducerErrorRateWidgetLegendColumn2() throws InterruptedException {
		page.waitForTimeout(1000); 
		util.widgetLegendNameSort(page, LegendColumn2Sort(ProducerErrorRateID), LegendColumnNameCountLocator(ProducerErrorRateID));
	}
	
	public void validateProducerErrorRateWidgetLegendColumn3() throws InterruptedException {
		page.waitForTimeout(1000); 
		util.widgetLegendNameSort(page, LegendColumn3Sort(ProducerErrorRateID), LegendColumnNameCountLocator(ProducerErrorRateID));
	}

	public void validateProducerErrorRateExpandViewXAxisTitle() {
		page.waitForTimeout(1000); 
		util.validateExpandViewTexts(page, XaxisTitle(ProducerErrorRateID), Expand(ProducerErrorRateID), expandViewCloseBtn, expandViewXaxisTitle);
	}

	public void validateProducerErrorRateExpandViewYAxisTitle() {
		page.waitForTimeout(1000); 
		util.validateExpandViewTexts(page, YaxisTitle(ProducerErrorRateID), Expand(ProducerErrorRateID), expandViewCloseBtn, expandViewYaxisTitle);
	}
	
	public void validateProducerErrorRateExpandViewWidgetTitle() {
		page.waitForTimeout(1000); 
		util.validateExpandViewTexts(page, getWidgetTitle(ProducerErrorRateID), Expand(ProducerErrorRateID), expandViewCloseBtn, expandViewWidgetTitle);
	}
	
	public void validateProducerErrorRateExpandViewLegendHeader1() {
		page.waitForTimeout(1000); 
		util.validateExpandViewTexts(page, LegendColumn1Title(ProducerErrorRateID), Expand(ProducerErrorRateID), expandViewCloseBtn, expandViewLegendColumn1HeaderTitle);
	}
	
	public void validateProducerErrorRateExpandViewLegendHeader2() {
		page.waitForTimeout(1000); 
		util.validateExpandViewTexts(page, LegendColumn2Title(ProducerErrorRateID), Expand(ProducerErrorRateID), expandViewCloseBtn, expandViewLegendColumn2HeaderTitle);
	}
	
	public void validateProducerErrorRateExpandViewLegendHeader3() {
		page.waitForTimeout(1000); 
		util.validateExpandViewTexts(page, LegendColumn3Title(ProducerErrorRateID), Expand(ProducerErrorRateID), expandViewCloseBtn, expandViewLegendColumn3HeaderTitle);
	}
	
	public void validateProducerErrorRateExpandViewLegendHeader2InforMessage() {
		util.validateExpandViewTexts(page, LegendColumn2Title(ProducerErrorRateID), Expand(ProducerErrorRateID), expandViewCloseBtn, expandViewLegendColumnHeader2infoMessage);
	}
	
	public void validateProducerErrorRateExpandViewLegendHeader3InforMessage() {
		util.validateExpandViewTexts(page, LegendColumn3Title(ProducerErrorRateID), Expand(ProducerErrorRateID), expandViewCloseBtn, expandViewLegendColumnHeader3infoMessage);
	}
	
	public void validateProducerErrorRateExpandViewZoomIn() {
		page.waitForTimeout(1000); 
		util.ExpandViewZoomInBtn(page, expandViewZoomInBtn, Expand(ProducerErrorRateID), expandViewCloseBtn, expandViewXaxisValues);
	}
	
	public void validateProducerErrorRateExpandViewZoomOut() {
		page.waitForTimeout(1000); 
		util.ExpandViewZoomOutBtn(page, expandViewZoomInBtn, Expand(ProducerErrorRateID), expandViewCloseBtn, expandViewZoomOutBtn, expandViewXaxisValues);
	}
	
	public void validateProducerErrorRateExpandViewWidgetDragDrop() {
		page.waitForTimeout(1000); 
		util.ExpandViewWidgetDragDrop(page, Expand(ProducerErrorRateID), expandViewCloseBtn, expandViewXaxisLines, expandViewZoomOutBtn, expandViewXaxisValues);
	}
	
	
	
//Producer < Request Avg Latency Graph

	public void validateProducerRequestAvgLatencyGraphTitle(String expectedTitle) {
		String actualTitle = page.locator(getWidgetTitle(ProducerRequestAvgLatencyID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateProducerRequestAvgLatencyGraphZoomInBtn() {
		page.waitForTimeout(1000);  
		util.graphZoomIn(page, ZoomIn(ProducerRequestAvgLatencyID), ProducerRequestAvgLatencyID);
	}

	public void validateProducerRequestAvgLatencyGraphZoomOutBtn() {
		page.waitForTimeout(1000);  
		util.graphZoomOut(page, ZoomIn(ProducerRequestAvgLatencyID), ZoomOut(ProducerRequestAvgLatencyID),
				ProducerRequestAvgLatencyID);
	}

	public void validateProducerRequestAvgLatencyXaxisValues() {
		page.waitForTimeout(1000); 
		util.validateTheGraphdisplayingTheDataAsPerGivenTimeLines(page, XaxisValues(ProducerRequestAvgLatencyID),
				calenderView, WidgetXValues(XaxisValues(ProducerRequestAvgLatencyID)));
	}

	public void validateProducerRequestAvgLatencyGraphXaxisTitle(String expectedTitle) {
		page.waitForTimeout(1000); 
		String actualTitle = page.locator(XaxisTitle(ProducerRequestAvgLatencyID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateProducerRequestAvgLatencyGraphYaxisTitle(String expectedTitle) {
		page.waitForTimeout(1000); 
		String actualTitle = page.locator(YaxisTitle(ProducerRequestAvgLatencyID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateProducerRequestAvgLatencyGraphBrokerHeaderTitle(String expectedTitle) {
		page.waitForTimeout(1000); 
		String actualTitle = page.locator(LegendColumn1Title(ProducerRequestAvgLatencyID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateProducerRequestAvgLatencyGraphAvgHeaderTitle(String expectedTitle) {
		page.waitForTimeout(1000); 
		String actualTitle = page.locator(LegendColumn2Title(ProducerRequestAvgLatencyID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateProducerRequestAvgLatencyGraphMaxHeaderTitle(String expectedTitle) {
		page.waitForTimeout(1000); 
		String actualTitle = page.locator(LegendColumn3Title(ProducerRequestAvgLatencyID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateProducerRequestAvgLatencyGraphRowColor1(String expectedTitle) {
		page.waitForTimeout(1000); 
		String actualTitle = page.locator(RowColor1(ProducerRequestAvgLatencyID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateProducerRequestAvgLatencyToolTipTitle() {
		page.waitForTimeout(1000); 
		util.validateWidgetToolTips(page, XaxisLines(ProducerRequestAvgLatencyID),
				ToolTipTitle(ProducerRequestAvgLatencyID));
	}
	
	public void validateProducerRequestAvgLatencyWidgetLegendColumn1() throws InterruptedException {
		page.waitForTimeout(1000); 
		util.widgetLegendNameSort(page, LegendColumn1Sort(ProducerRequestAvgLatencyID), LegendColumnNameCountLocator(ProducerRequestAvgLatencyID));
	}
	
	public void validateProducerRequestAvgLatencyWidgetLegendColumn2() throws InterruptedException {
		page.waitForTimeout(1000); 
		util.widgetLegendNameSort(page, LegendColumn2Sort(ProducerRequestAvgLatencyID), LegendColumnNameCountLocator(ProducerRequestAvgLatencyID));
	}
	
	public void validateProducerRequestAvgLatencyWidgetLegendColumn3() throws InterruptedException {
		page.waitForTimeout(1000); 
		util.widgetLegendNameSort(page, LegendColumn3Sort(ProducerRequestAvgLatencyID), LegendColumnNameCountLocator(ProducerRequestAvgLatencyID));
	}

	public void validateProducerRequestAvgLatencyExpandViewXAxisTitle() {
		page.waitForTimeout(1000); 
		util.validateExpandViewTexts(page, XaxisTitle(ProducerRequestAvgLatencyID), Expand(ProducerRequestAvgLatencyID), expandViewCloseBtn, expandViewXaxisTitle);
	}

	public void validateProducerRequestAvgLatencyExpandViewYAxisTitle() {
		page.waitForTimeout(1000);
		util.validateExpandViewTexts(page, YaxisTitle(ProducerRequestAvgLatencyID), Expand(ProducerRequestAvgLatencyID), expandViewCloseBtn, expandViewYaxisTitle);
	}
	
	public void validateProducerRequestAvgLatencyExpandViewWidgetTitle() {
		page.waitForTimeout(1000);
		util.validateExpandViewTexts(page, getWidgetTitle(ProducerRequestAvgLatencyID), Expand(ProducerRequestAvgLatencyID), expandViewCloseBtn, expandViewWidgetTitle);
	}
	
	public void validateProducerRequestAvgLatencyExpandViewLegendHeader1() {
		page.waitForTimeout(1000);
		util.validateExpandViewTexts(page, LegendColumn1Title(ProducerRequestAvgLatencyID), Expand(ProducerRequestAvgLatencyID), expandViewCloseBtn, expandViewLegendColumn1HeaderTitle);
	}
	
	public void validateProducerRequestAvgLatencyExpandViewLegendHeader2() {
		page.waitForTimeout(1000);
		util.validateExpandViewTexts(page, LegendColumn2Title(ProducerRequestAvgLatencyID), Expand(ProducerRequestAvgLatencyID), expandViewCloseBtn, expandViewLegendColumn2HeaderTitle);
	}
	
	public void validateProducerRequestAvgLatencyExpandViewLegendHeader3() {
		page.waitForTimeout(1000);
		util.validateExpandViewTexts(page, LegendColumn3Title(ProducerRequestAvgLatencyID), Expand(ProducerRequestAvgLatencyID), expandViewCloseBtn, expandViewLegendColumn3HeaderTitle);
	}
	
	public void validateProducerRequestAvgLatencyExpandViewLegendHeader2InforMessage() {
		util.validateExpandViewTexts(page, LegendColumn2Title(ProducerRequestAvgLatencyID), Expand(ProducerRequestAvgLatencyID), expandViewCloseBtn, expandViewLegendColumnHeader2infoMessage);
	}
	
	public void validateProducerRequestAvgLatencyExpandViewLegendHeader3InforMessage() {
		util.validateExpandViewTexts(page, LegendColumn3Title(ProducerRequestAvgLatencyID), Expand(ProducerRequestAvgLatencyID), expandViewCloseBtn, expandViewLegendColumnHeader3infoMessage);
	}
	
	public void validateProducerRequestAvgLatencyExpandViewZoomIn() {
		page.waitForTimeout(1000);
		util.ExpandViewZoomInBtn(page, expandViewZoomInBtn, Expand(ProducerRequestAvgLatencyID), expandViewCloseBtn, expandViewXaxisValues);
	}
	
	public void validateProducerRequestAvgLatencyExpandViewZoomOut() {
		page.waitForTimeout(1000);
		util.ExpandViewZoomOutBtn(page, expandViewZoomInBtn, Expand(ProducerRequestAvgLatencyID), expandViewCloseBtn, expandViewZoomOutBtn, expandViewXaxisValues);
	}
	
	public void validateProducerRequestAvgLatencyExpandViewWidgetDragDrop() {
		page.waitForTimeout(1000);
		util.ExpandViewWidgetDragDrop(page, Expand(ProducerRequestAvgLatencyID), expandViewCloseBtn, expandViewXaxisLines, expandViewZoomOutBtn, expandViewXaxisValues);
	}
	
	
//Producer - Number of Producers  Graph

	public void validateProducerNumberOfProducersGraphTitle(String expectedTitle) {
		page.waitForTimeout(1000); 
		String actualTitle = page.locator(getWidgetTitle(ProducerNumberOfProducersID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateProducerNumberOfProducersGraphZoomInBtn() {
		page.waitForTimeout(1000); 
		util.graphZoomIn(page, ZoomIn(ProducerNumberOfProducersID), ProducerNumberOfProducersID);
	}

	public void validateProducerNumberOfProducersGraphZoomOutBtn() {
		page.waitForTimeout(1000); 
		util.graphZoomOut(page, ZoomIn(ProducerNumberOfProducersID), ZoomOut(ProducerNumberOfProducersID),
				ProducerNumberOfProducersID);
	}

	public void validateProducerNumberOfProducersXaxisValues() {
		page.waitForTimeout(1000); 
		util.validateTheGraphdisplayingTheDataAsPerGivenTimeLines(page, XaxisValues(ProducerNumberOfProducersID),
				calenderView, WidgetXValues(XaxisValues(ProducerNumberOfProducersID)));
	}

	public void validateProducerNumberOfProducersGraphXaxisTitle(String expectedTitle) {
		page.waitForTimeout(1000); 
		String actualTitle = page.locator(XaxisTitle(ProducerNumberOfProducersID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateProducerNumberOfProducersGraphYaxisTitle(String expectedTitle) {
		page.waitForTimeout(1000); 
		String actualTitle = page.locator(YaxisTitle(ProducerNumberOfProducersID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateProducerNumberOfProducersGraphToolTip(String expectedTitle) {
		page.waitForTimeout(1000);
		String actualTitle = page.locator(ProducerNumberOfProducersID).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	/**
	 * Consumer Tab
	 */

	public void validateConsumerTabTitle(String expectedTitle) {
		String actualTitle = page.locator(ConsumerTabTitle).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void clickOnConsumerTab() {
		page.locator(ConsumerTabTitle).click();
		String actualTitle = page
				.locator("//div[@class='overviewTabSelector']/child::div[@class='kafkaTabItem kafkaActiveTab']")
				.textContent().trim();
		Assert.assertEquals(actualTitle.equalsIgnoreCase("Consumer"), true);
	}

//Consumer < Average Fetch Size Graph

	public void validateConsumerAverageFetchSizeGraphTitle(String expectedTitle) {
		page.waitForTimeout(1000); 
		String actualTitle = page.locator(getWidgetTitle(ConsumerAverageFetchSizeID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateConsumerAverageFetchSizeGraphZoomInBtn() {
		page.waitForTimeout(1000); 
		util.graphZoomIn(page, ZoomIn(ConsumerAverageFetchSizeID), ConsumerAverageFetchSizeID);
	}

	public void validateConsumerAverageFetchSizeGraphZoomOutBtn() {
		page.waitForTimeout(1000); 
		util.graphZoomOut(page, ZoomIn(ConsumerAverageFetchSizeID), ZoomOut(ConsumerAverageFetchSizeID),
				ConsumerAverageFetchSizeID);
	}

	public void validateConsumerAverageFetchSizeXaxisValues() {
		page.waitForTimeout(1000); 
		util.validateTheGraphdisplayingTheDataAsPerGivenTimeLines(page, XaxisValues(ConsumerAverageFetchSizeID),
				calenderView, WidgetXValues(XaxisValues(ConsumerAverageFetchSizeID)));
	}

	public void validateConsumerAverageFetchSizeGraphXaxisTitle(String expectedTitle) {
		page.waitForTimeout(1000);
		String actualTitle = page.locator(XaxisTitle(ConsumerAverageFetchSizeID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateConsumerAverageFetchSizeGraphYaxisTitle(String expectedTitle) {
		page.waitForTimeout(1000);
		String actualTitle = page.locator(YaxisTitle(ConsumerAverageFetchSizeID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateConsumerAverageFetchSizeGraphBrokerHeaderTitle(String expectedTitle) {
		page.waitForTimeout(1000);
		String actualTitle = page.locator(LegendColumn1Title(ConsumerAverageFetchSizeID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateConsumerAverageFetchSizeGraphAvgHeaderTitle(String expectedTitle) {
		page.waitForTimeout(1000);
		String actualTitle = page.locator(LegendColumn2Title(ConsumerAverageFetchSizeID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateConsumerAverageFetchSizeGraphMaxHeaderTitle(String expectedTitle) {
		page.waitForTimeout(1000); 
		String actualTitle = page.locator(LegendColumn3Title(ConsumerAverageFetchSizeID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateConsumerAverageFetchSizeGraphRowColor1(String expectedTitle) {
		page.waitForTimeout(1000); 
		String actualTitle = page.locator(RowColor1(ConsumerAverageFetchSizeID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateConsumerAverageFetchSizeToolTipTitle() {
		page.waitForTimeout(1000); 
		util.validateWidgetToolTips(page, XaxisLines(ConsumerAverageFetchSizeID),
				ToolTipTitle(ConsumerAverageFetchSizeID));
	}

	public void validateConsumerAverageFetchSizeWidgetLegendColumn1() throws InterruptedException {
		page.waitForTimeout(1000); 
		util.widgetLegendNameSort(page, LegendColumn1Sort(ConsumerAverageFetchSizeID), LegendColumnNameCountLocator(ConsumerAverageFetchSizeID));
	}
	
	public void validateConsumerAverageFetchSizeWidgetLegendColumn2() throws InterruptedException {
		page.waitForTimeout(1000); 
		util.widgetLegendNameSort(page, LegendColumn2Sort(ConsumerAverageFetchSizeID), LegendColumnNameCountLocator(ConsumerAverageFetchSizeID));
	}
	
	public void validateConsumerAverageFetchSizeWidgetLegendColumn3() throws InterruptedException {
		page.waitForTimeout(1000); 
		util.widgetLegendNameSort(page, LegendColumn3Sort(ConsumerAverageFetchSizeID), LegendColumnNameCountLocator(ConsumerAverageFetchSizeID));
	}

	public void validateConsumerAverageFetchSizeExpandViewXAxisTitle() {
		page.waitForTimeout(1000); 
		util.validateExpandViewTexts(page, XaxisTitle(ConsumerAverageFetchSizeID), Expand(ConsumerAverageFetchSizeID), expandViewCloseBtn, expandViewXaxisTitle);
	}

	public void validateConsumerAverageFetchSizeExpandViewYAxisTitle() {
		page.waitForTimeout(1000); 
		util.validateExpandViewTexts(page, YaxisTitle(ConsumerAverageFetchSizeID), Expand(ConsumerAverageFetchSizeID), expandViewCloseBtn, expandViewYaxisTitle);
	}
	
	public void validateConsumerAverageFetchSizeExpandViewWidgetTitle() {
		page.waitForTimeout(1000); 
		util.validateExpandViewTexts(page, getWidgetTitle(ConsumerAverageFetchSizeID), Expand(ConsumerAverageFetchSizeID), expandViewCloseBtn, expandViewWidgetTitle);
	}
	
	public void validateConsumerAverageFetchSizeExpandViewLegendHeader1() {
		page.waitForTimeout(1000); 
		util.validateExpandViewTexts(page, LegendColumn1Title(ConsumerAverageFetchSizeID), Expand(ConsumerAverageFetchSizeID), expandViewCloseBtn, expandViewLegendColumn1HeaderTitle);
	}
	
	public void validateConsumerAverageFetchSizeExpandViewLegendHeader2() {
		page.waitForTimeout(1000); 
		util.validateExpandViewTexts(page, LegendColumn2Title(ConsumerAverageFetchSizeID), Expand(ConsumerAverageFetchSizeID), expandViewCloseBtn, expandViewLegendColumn2HeaderTitle);
	}
	
	public void validateConsumerAverageFetchSizeExpandViewLegendHeader3() {
		page.waitForTimeout(1000); 
		util.validateExpandViewTexts(page, LegendColumn3Title(ConsumerAverageFetchSizeID), Expand(ConsumerAverageFetchSizeID), expandViewCloseBtn, expandViewLegendColumn3HeaderTitle);
	}
	
	public void validateConsumerAverageFetchSizeExpandViewLegendHeader2InforMessage() {
		util.validateExpandViewTexts(page, LegendColumn2Title(ConsumerAverageFetchSizeID), Expand(ConsumerAverageFetchSizeID), expandViewCloseBtn, expandViewLegendColumnHeader2infoMessage);
	}
	
	public void validateConsumerAverageFetchSizeExpandViewLegendHeader3InforMessage() {
		util.validateExpandViewTexts(page, LegendColumn3Title(ConsumerAverageFetchSizeID), Expand(ConsumerAverageFetchSizeID), expandViewCloseBtn, expandViewLegendColumnHeader3infoMessage);
	}
	
	public void validateConsumerAverageFetchSizeExpandViewZoomIn() {
		page.waitForTimeout(1000); 
		util.ExpandViewZoomInBtn(page, expandViewZoomInBtn, Expand(ConsumerAverageFetchSizeID), expandViewCloseBtn, expandViewXaxisValues);
	}
	
	public void validateConsumerAverageFetchSizeExpandViewZoomOut() {
		page.waitForTimeout(1000); 
		util.ExpandViewZoomOutBtn(page, expandViewZoomInBtn, Expand(ConsumerAverageFetchSizeID), expandViewCloseBtn, expandViewZoomOutBtn, expandViewXaxisValues);
	}
	
	public void validateConsumerAverageFetchSizeExpandViewWidgetDragDrop() {
		page.waitForTimeout(1000); 
		util.ExpandViewWidgetDragDrop(page, Expand(ConsumerAverageFetchSizeID), expandViewCloseBtn, expandViewXaxisLines, expandViewZoomOutBtn, expandViewXaxisValues);
	}
		
//Consumer < Response Rate Graph

	public void validateConsumerResponseRateGraphTitle(String expectedTitle) {
		String actualTitle = page.locator(getWidgetTitle(ConsumerResponseRateID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateConsumerResponseRateGraphZoomInBtn() {
		page.waitForTimeout(1000);  
		util.graphZoomIn(page, ZoomIn(ConsumerResponseRateID), ConsumerResponseRateID);
	}

	public void validateConsumerResponseRateGraphZoomOutBtn() {
		page.waitForTimeout(1000);  
		util.graphZoomOut(page, ZoomIn(ConsumerResponseRateID), ZoomOut(ConsumerResponseRateID),
				ConsumerResponseRateID);
	}

	public void validateConsumerResponseRateXaxisValues() {
		page.waitForTimeout(1000);
		util.validateTheGraphdisplayingTheDataAsPerGivenTimeLines(page, XaxisValues(ConsumerResponseRateID),
				calenderView, WidgetXValues(XaxisValues(ConsumerResponseRateID)));
	}

	public void validateConsumerResponseRateGraphXaxisTitle(String expectedTitle) {		
		page.waitForTimeout(1000); 
		String actualTitle = page.locator(XaxisTitle(ConsumerResponseRateID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateConsumerResponseRateGraphYaxisTitle(String expectedTitle) {
		page.waitForTimeout(1000); 
		String actualTitle = page.locator(YaxisTitle(ConsumerResponseRateID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateConsumerResponseRateGraphBrokerHeaderTitle(String expectedTitle) {
		page.waitForTimeout(1000); 
		String actualTitle = page.locator(LegendColumn1Title(ConsumerResponseRateID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateConsumerResponseRateGraphAvgHeaderTitle(String expectedTitle) {
		page.waitForTimeout(1000); 
		String actualTitle = page.locator(LegendColumn2Title(ConsumerResponseRateID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateConsumerResponseRateGraphMaxHeaderTitle(String expectedTitle) {
		page.waitForTimeout(1000); 
		String actualTitle = page.locator(LegendColumn3Title(ConsumerResponseRateID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateConsumerResponseRateGraphRowColor1(String expectedTitle) {
		page.waitForTimeout(1000); 
		String actualTitle = page.locator(RowColor1(ConsumerResponseRateID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateConsumerResponseRateToolTipTitle() {
		page.waitForTimeout(1000); 
		util.validateWidgetToolTips(page, XaxisLines(ConsumerResponseRateID), ToolTipTitle(ConsumerResponseRateID));
	}

	public void validateConsumerResponseRateWidgetLegendColumn1() throws InterruptedException {
		util.widgetLegendNameSort(page, LegendColumn1Sort(ConsumerResponseRateID), LegendColumnNameCountLocator(ConsumerResponseRateID));
	}
	
	public void validateConsumerResponseRateWidgetLegendColumn2() throws InterruptedException {
		util.widgetLegendNameSort(page, LegendColumn2Sort(ConsumerResponseRateID), LegendColumnNameCountLocator(ConsumerResponseRateID));
	}
	
	public void validateConsumerResponseRateWidgetLegendColumn3() throws InterruptedException {
		util.widgetLegendNameSort(page, LegendColumn3Sort(ConsumerResponseRateID), LegendColumnNameCountLocator(ConsumerResponseRateID));
	}

	public void validateConsumerResponseRateExpandViewXAxisTitle() {
		page.waitForTimeout(1000);
		util.validateExpandViewTexts(page, XaxisTitle(ConsumerResponseRateID), Expand(ConsumerResponseRateID), expandViewCloseBtn, expandViewXaxisTitle);
	}

	public void validateConsumerResponseRateExpandViewYAxisTitle() {
		page.waitForTimeout(1000);
		util.validateExpandViewTexts(page, YaxisTitle(ConsumerResponseRateID), Expand(ConsumerResponseRateID), expandViewCloseBtn, expandViewYaxisTitle);
	}
	
	public void validateConsumerResponseRateExpandViewWidgetTitle() {
		page.waitForTimeout(1000);
		util.validateExpandViewTexts(page, getWidgetTitle(ConsumerResponseRateID), Expand(ConsumerResponseRateID), expandViewCloseBtn, expandViewWidgetTitle);
	}
	
	public void validateConsumerResponseRateExpandViewLegendHeader1() {
		util.validateExpandViewTexts(page, LegendColumn1Title(ConsumerResponseRateID), Expand(ConsumerResponseRateID), expandViewCloseBtn, expandViewLegendColumn1HeaderTitle);
	}
	
	public void validateConsumerResponseRateExpandViewLegendHeader2() {
		util.validateExpandViewTexts(page, LegendColumn2Title(ConsumerResponseRateID), Expand(ConsumerResponseRateID), expandViewCloseBtn, expandViewLegendColumn2HeaderTitle);
	}
	
	public void validateConsumerResponseRateExpandViewLegendHeader3() {
		util.validateExpandViewTexts(page, LegendColumn3Title(ConsumerResponseRateID), Expand(ConsumerResponseRateID), expandViewCloseBtn, expandViewLegendColumn3HeaderTitle);
	}
	
	public void validateConsumerResponseRateExpandViewLegendHeader2InforMessage() {
		util.validateExpandViewTexts(page, LegendColumn2Title(ConsumerResponseRateID), Expand(ConsumerResponseRateID), expandViewCloseBtn, expandViewLegendColumnHeader2infoMessage);
	}
	
	public void validateConsumerResponseRateExpandViewLegendHeader3InforMessage() {
		util.validateExpandViewTexts(page, LegendColumn3Title(ConsumerResponseRateID), Expand(ConsumerResponseRateID), expandViewCloseBtn, expandViewLegendColumnHeader3infoMessage);
	}
	
	public void validateConsumerResponseRateExpandViewZoomIn() {
		page.waitForTimeout(1000);
		util.ExpandViewZoomInBtn(page, expandViewZoomInBtn, Expand(ConsumerResponseRateID), expandViewCloseBtn, expandViewXaxisValues);
	}
	
	public void validateConsumerResponseRateExpandViewZoomOut() {
		page.waitForTimeout(1000);
		util.ExpandViewZoomOutBtn(page, expandViewZoomInBtn, Expand(ConsumerResponseRateID), expandViewCloseBtn, expandViewZoomOutBtn, expandViewXaxisValues);
	}
	
	public void validateConsumerResponseRateExpandViewWidgetDragDrop() {
		page.waitForTimeout(1000);
		util.ExpandViewWidgetDragDrop(page, Expand(ConsumerResponseRateID), expandViewCloseBtn, expandViewXaxisLines, expandViewZoomOutBtn, expandViewXaxisValues);
	}
	
	
	
//Consumer < Consumer Lag Graph

	public void validateConsumerConsumerLagGraphTitle(String expectedTitle) {
		page.waitForTimeout(1000);
		String actualTitle = page.locator(getWidgetTitle(ConsumerConsumerLagID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateConsumerConsumerLagGraphZoomInBtn() {
		page.waitForTimeout(1000); 
		util.graphZoomIn(page, ZoomIn(ConsumerConsumerLagID), ConsumerConsumerLagID);
	}

	public void validateConsumerConsumerLagGraphZoomOutBtn() {
		page.waitForTimeout(1000); 
		util.graphZoomOut(page, ZoomIn(ConsumerConsumerLagID), ZoomOut(ConsumerConsumerLagID), ConsumerConsumerLagID);
	}

	public void validateConsumerConsumerLagXaxisValues() {
		page.waitForTimeout(2000); 
		util.validateTheGraphdisplayingTheDataAsPerGivenTimeLines(page, XaxisValues(ConsumerConsumerLagID),
				calenderView, WidgetXValues(XaxisValues(ConsumerConsumerLagID)));
	}

	public void validateConsumerConsumerLagGraphXaxisTitle(String expectedTitle) {
		page.waitForTimeout(1000);
		String actualTitle = page.locator(XaxisTitle(ConsumerConsumerLagID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateConsumerConsumerLagGraphYaxisTitle(String expectedTitle) {
		page.waitForTimeout(1000);
		String actualTitle = page.locator(YaxisTitle(ConsumerConsumerLagID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateConsumerConsumerLagGraphBrokerHeaderTitle(String expectedTitle) {
		page.waitForTimeout(1000);
		String actualTitle = page.locator(LegendColumn1Title(ConsumerConsumerLagID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateConsumerConsumerLagGraphAvgHeaderTitle(String expectedTitle) {
		page.waitForTimeout(1000);
		String actualTitle = page.locator(LegendColumn2Title(ConsumerConsumerLagID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateConsumerConsumerLagGraphMaxHeaderTitle(String expectedTitle) {
		page.waitForTimeout(1000);
		String actualTitle = page.locator(LegendColumn3Title(ConsumerConsumerLagID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateConsumerConsumerLagGraphRowColor1(String expectedTitle) {
		page.waitForTimeout(1000);
		String actualTitle = page.locator(RowColor1(ConsumerConsumerLagID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateConsumerConsumerLagToolTipTitle() {
		page.waitForTimeout(1000);
		util.validateWidgetToolTips(page, XaxisLines(ConsumerConsumerLagID), ToolTipTitle(ConsumerConsumerLagID));
	}

	public void validateConsumerConsumerLagWidgetLegendColumn1() throws InterruptedException {
		util.widgetLegendNameSort(page, LegendColumn1Sort(ConsumerConsumerLagID), LegendColumnNameCountLocator(ConsumerConsumerLagID));
	}
	
	public void validateConsumerConsumerLagWidgetLegendColumn2() throws InterruptedException {
		util.widgetLegendNameSort(page, LegendColumn2Sort(ConsumerConsumerLagID), LegendColumnNameCountLocator(ConsumerConsumerLagID));
	}
	
	public void validateConsumerConsumerLagWidgetLegendColumn3() throws InterruptedException {
		util.widgetLegendNameSort(page, LegendColumn3Sort(ConsumerConsumerLagID), LegendColumnNameCountLocator(ConsumerConsumerLagID));
	}

	public void validateConsumerConsumerLagExpandViewXAxisTitle() {
		page.waitForTimeout(1000);
		util.validateExpandViewTexts(page, XaxisTitle(ConsumerConsumerLagID), Expand(ConsumerConsumerLagID), expandViewCloseBtn, expandViewXaxisTitle);
	}

	public void validateConsumerConsumerLagExpandViewYAxisTitle() {
		page.waitForTimeout(1000);
		util.validateExpandViewTexts(page, YaxisTitle(ConsumerConsumerLagID), Expand(ConsumerConsumerLagID), expandViewCloseBtn, expandViewYaxisTitle);
	}
	
	public void validateConsumerConsumerLagExpandViewWidgetTitle() {
		page.waitForTimeout(1000);
		util.validateExpandViewTexts(page, getWidgetTitle(ConsumerConsumerLagID), Expand(ConsumerConsumerLagID), expandViewCloseBtn, expandViewWidgetTitle);
	}
	
	public void validateConsumerConsumerLagExpandViewLegendHeader1() {
		page.waitForTimeout(1000);
		util.validateExpandViewTexts(page, LegendColumn1Title(ConsumerConsumerLagID), Expand(ConsumerConsumerLagID), expandViewCloseBtn, expandViewLegendColumn1HeaderTitle);
	}
	
	public void validateConsumerConsumerLagExpandViewLegendHeader2() {
		util.validateExpandViewTexts(page, LegendColumn2Title(ConsumerConsumerLagID), Expand(ConsumerConsumerLagID), expandViewCloseBtn, expandViewLegendColumn2HeaderTitle);
	}
	
	public void validateConsumerConsumerLagExpandViewLegendHeader3() {
		util.validateExpandViewTexts(page, LegendColumn3Title(ConsumerConsumerLagID), Expand(ConsumerConsumerLagID), expandViewCloseBtn, expandViewLegendColumn3HeaderTitle);
	}
	
	public void validateConsumerConsumerLagExpandViewLegendHeader2InforMessage() {
		util.validateExpandViewTexts(page, LegendColumn2Title(ConsumerConsumerLagID), Expand(ConsumerConsumerLagID), expandViewCloseBtn, expandViewLegendColumnHeader2infoMessage);
	}
	
	public void validateConsumerConsumerLagExpandViewLegendHeader3InforMessage() {
		util.validateExpandViewTexts(page, LegendColumn3Title(ConsumerConsumerLagID), Expand(ConsumerConsumerLagID), expandViewCloseBtn, expandViewLegendColumnHeader3infoMessage);
	}
	
	public void validateConsumerConsumerLagExpandViewZoomIn() {
		page.waitForTimeout(1000);
		util.ExpandViewZoomInBtn(page, expandViewZoomInBtn, Expand(ConsumerConsumerLagID), expandViewCloseBtn, expandViewXaxisValues);
	}
	
	public void validateConsumerConsumerLagExpandViewZoomOut() {
		page.waitForTimeout(1000);
		util.ExpandViewZoomOutBtn(page, expandViewZoomInBtn, Expand(ConsumerConsumerLagID), expandViewCloseBtn, expandViewZoomOutBtn, expandViewXaxisValues);
	}
	
	public void validateConsumerConsumerLagExpandViewWidgetDragDrop() {
		page.waitForTimeout(2000);
		util.ExpandViewWidgetDragDrop(page, Expand(ConsumerConsumerLagID), expandViewCloseBtn, expandViewXaxisLines, expandViewZoomOutBtn, expandViewXaxisValues);
	}
	
	
//Consumer < Message Consumed Graph

	public void validateConsumerMessageConsumedGraphTitle(String expectedTitle) {
		String actualTitle = page.locator(getWidgetTitle(ConsumerMessageConsumedID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateConsumerMessageConsumedGraphZoomInBtn() {
		page.waitForTimeout(1000); 
		util.graphZoomIn(page, ZoomIn(ConsumerMessageConsumedID), ConsumerMessageConsumedID);
	}

	public void validateConsumerMessageConsumedGraphZoomOutBtn() {
		page.waitForTimeout(1000); 
		util.graphZoomOut(page, ZoomIn(ConsumerMessageConsumedID), ZoomOut(ConsumerMessageConsumedID),
				ConsumerMessageConsumedID);
	}

	public void validateConsumerMessageConsumedXaxisValues() {
		page.waitForTimeout(1000); 
		util.validateTheGraphdisplayingTheDataAsPerGivenTimeLines(page, XaxisValues(ConsumerMessageConsumedID),
				calenderView, WidgetXValues(XaxisValues(ConsumerMessageConsumedID)));
	}

	public void validateConsumerMessageConsumedGraphXaxisTitle(String expectedTitle) {
		page.waitForTimeout(1000);
		String actualTitle = page.locator(XaxisTitle(ConsumerMessageConsumedID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateConsumerMessageConsumedGraphYaxisTitle(String expectedTitle) {
		page.waitForTimeout(1000);
		String actualTitle = page.locator(YaxisTitle(ConsumerMessageConsumedID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateConsumerMessageConsumedGraphBrokerHeaderTitle(String expectedTitle) {
		page.waitForTimeout(1000);
		String actualTitle = page.locator(LegendColumn1Title(ConsumerMessageConsumedID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateConsumerMessageConsumedGraphAvgHeaderTitle(String expectedTitle) {
		page.waitForTimeout(1000);
		String actualTitle = page.locator(LegendColumn2Title(ConsumerMessageConsumedID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateConsumerMessageConsumedGraphMaxHeaderTitle(String expectedTitle) {
		page.waitForTimeout(1000);
		String actualTitle = page.locator(LegendColumn3Title(ConsumerMessageConsumedID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateConsumerMessageConsumedGraphRowColor1(String expectedTitle) {
		page.waitForTimeout(1000);
		String actualTitle = page.locator(RowColor1(ConsumerMessageConsumedID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateConsumerMessageConsumedToolTipTitle() {
		page.waitForTimeout(1000);
		util.validateWidgetToolTips(page, XaxisLines(ConsumerMessageConsumedID),
				ToolTipTitle(ConsumerMessageConsumedID));
	}

	public void validateConsumerMessageConsumedWidgetLegendColumn1() throws InterruptedException {
		util.widgetLegendNameSort(page, LegendColumn1Sort(ConsumerMessageConsumedID), LegendColumnNameCountLocator(ConsumerMessageConsumedID));
	}
	
	public void validateConsumerMessageConsumedWidgetLegendColumn2() throws InterruptedException {
		util.widgetLegendNameSort(page, LegendColumn2Sort(ConsumerMessageConsumedID), LegendColumnNameCountLocator(ConsumerMessageConsumedID));
	}
	
	public void validateConsumerMessageConsumedWidgetLegendColumn3() throws InterruptedException {
		util.widgetLegendNameSort(page, LegendColumn3Sort(ConsumerMessageConsumedID), LegendColumnNameCountLocator(ConsumerMessageConsumedID));
	}

	public void validateConsumerMessageConsumedExpandViewXAxisTitle() {
		page.waitForTimeout(1000);
		util.validateExpandViewTexts(page, XaxisTitle(ConsumerMessageConsumedID), Expand(ConsumerMessageConsumedID), expandViewCloseBtn, expandViewXaxisTitle);
	}

	public void validateConsumerMessageConsumedExpandViewYAxisTitle() {
		page.waitForTimeout(1000);
		util.validateExpandViewTexts(page, YaxisTitle(ConsumerMessageConsumedID), Expand(ConsumerMessageConsumedID), expandViewCloseBtn, expandViewYaxisTitle);
	}
	
	public void validateConsumerMessageConsumedExpandViewWidgetTitle() {
		page.waitForTimeout(1000);
		util.validateExpandViewTexts(page, getWidgetTitle(ConsumerMessageConsumedID), Expand(ConsumerMessageConsumedID), expandViewCloseBtn, expandViewWidgetTitle);
	}
	
	public void validateConsumerMessageConsumedExpandViewLegendHeader1() {
		util.validateExpandViewTexts(page, LegendColumn1Title(ConsumerMessageConsumedID), Expand(ConsumerMessageConsumedID), expandViewCloseBtn, expandViewLegendColumn1HeaderTitle);
	}
	
	public void validateConsumerMessageConsumedExpandViewLegendHeader2() {
		util.validateExpandViewTexts(page, LegendColumn2Title(ConsumerMessageConsumedID), Expand(ConsumerMessageConsumedID), expandViewCloseBtn, expandViewLegendColumn2HeaderTitle);
	}
	
	public void validateConsumerMessageConsumedExpandViewLegendHeader3() {
		util.validateExpandViewTexts(page, LegendColumn3Title(ConsumerMessageConsumedID), Expand(ConsumerMessageConsumedID), expandViewCloseBtn, expandViewLegendColumn3HeaderTitle);
	}
	
	public void validateConsumerMessageConsumedExpandViewLegendHeader2InforMessage() {
		util.validateExpandViewTexts(page, LegendColumn2Title(ConsumerMessageConsumedID), Expand(ConsumerMessageConsumedID), expandViewCloseBtn, expandViewLegendColumnHeader2infoMessage);
	}
	
	public void validateConsumerMessageConsumedExpandViewLegendHeader3InforMessage() {
		util.validateExpandViewTexts(page, LegendColumn3Title(ConsumerMessageConsumedID), Expand(ConsumerMessageConsumedID), expandViewCloseBtn, expandViewLegendColumnHeader3infoMessage);
	}
	
	public void validateConsumerMessageConsumedExpandViewZoomIn() {
		page.waitForTimeout(1000);
		util.ExpandViewZoomInBtn(page, expandViewZoomInBtn, Expand(ConsumerMessageConsumedID), expandViewCloseBtn, expandViewXaxisValues);
	}
	
	public void validateConsumerMessageConsumedExpandViewZoomOut() {
		page.waitForTimeout(1000);
		util.ExpandViewZoomOutBtn(page, expandViewZoomInBtn, Expand(ConsumerMessageConsumedID), expandViewCloseBtn, expandViewZoomOutBtn, expandViewXaxisValues);
	}
	
	public void validateConsumerMessageConsumedExpandViewWidgetDragDrop() {
		page.waitForTimeout(1000);
		util.ExpandViewWidgetDragDrop(page, Expand(ConsumerMessageConsumedID), expandViewCloseBtn, expandViewXaxisLines, expandViewZoomOutBtn, expandViewXaxisValues);
	}
	
	
	
//Consumer - Number of Consumers  Graph

	public void validateConsumerNumberOfConsumersGraphTitle(String expectedTitle) {
		page.waitForTimeout(1000);
		String actualTitle = page.locator(getWidgetTitle(ConsumerNumberOfConsumersID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateConsumerNumberOfConsumersGraphZoomInBtn() {
		page.waitForTimeout(1000); 
		util.graphZoomIn(page, ZoomIn(ConsumerNumberOfConsumersID), ConsumerNumberOfConsumersID);
	}

	public void validateConsumerNumberOfConsumersGraphZoomOutBtn() {
		page.waitForTimeout(1000);
		util.graphZoomOut(page, ZoomIn(ConsumerNumberOfConsumersID), ZoomOut(ConsumerNumberOfConsumersID),
				ConsumerNumberOfConsumersID);
	}

	public void validateConsumerNumberOfConsumersXaxisValues() {
		page.waitForTimeout(1000); 
		util.validateTheGraphdisplayingTheDataAsPerGivenTimeLines(page, XaxisValues(ConsumerNumberOfConsumersID),
				calenderView, WidgetXValues(XaxisValues(ConsumerNumberOfConsumersID)));
	}

	public void validateConsumerNumberOfConsumersGraphXaxisTitle(String expectedTitle) {
		page.waitForTimeout(1000);
		String actualTitle = page.locator(XaxisTitle(ConsumerNumberOfConsumersID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateConsumerNumberOfConsumersGraphYaxisTitle(String expectedTitle) {
		page.waitForTimeout(1000);
		String actualTitle = page.locator(YaxisTitle(ConsumerNumberOfConsumersID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateConsumerNumberOfConsumersGraphToolTip(String expectedTitle) {
		page.waitForTimeout(1000);
		String actualTitle = page.locator(ConsumerNumberOfConsumersID).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	/**
	 * id refers widget locator id
	 * 
	 * @param id
	 * @return
	 */

	private String getWidgetTitle(String id) {
		return "xpath = //div[@id='"+id+"']/ancestor::div[@class='card-body' or @class='chart-body']/preceding-sibling::div[@class='card-header' or @class='line-header']";
	}

	private String ZoomOut(String id) {
		return "xpath = //div[@id='"+id+"']/ancestor::div[@class='card-body' or @class='chart-body']/preceding-sibling::div/descendant::span[@class='icon-class'][position()=1]";
	}

	private String ZoomIn(String id) {
		return "xpath = //div[@id='"+id+"']/ancestor::div[@class='card-body' or @class='chart-body']/preceding-sibling::div/descendant::span[@class='icon-class'][position()=2]";
	}

	private String XaxisLines(String id) {
		return "xpath = //div[@id='"+id+"']/descendant::*[@class='apexcharts-xaxis-tick']";
	}
	
	private String XaxisValues(String id) {
		return "xpath = //div[@id='"+id+"']/descendant::*[@class='apexcharts-text apexcharts-xaxis-label apexcharts-xaxis-label']/child::*[name()='tspan' and contains(text(),'-')]";
	}

	private String XaxisTitle(String id) {
		return "xpath = //div[@id='"+id+"']/descendant::*[@class='apexcharts-text apexcharts-xaxis-title-text chart-lables']";
	}

	private String YaxisTitle(String id) {
		return "xpath = //div[@id='"+id+"']/descendant::*[@class='apexcharts-text apexcharts-yaxis-title-text chart-lables']";
	}

	private String ToolTipTitle(String id) {
		return "xpath = //div[@id='"+id+"']/descendant::div[@class='apexcharts-tooltip-title']";
	}

	// Headers
	
	private String LegendColumn1Title(String id) {
		return "xpath = //div[@id='" + id
				+ "']/ancestor::div[@class='card-body']/descendant::div[@class='header-heading'][position()=1]";
	}

	private String LegendColumn1Sort(String id) {
		return "xpath = //div[@id='" + id
				+ "']/ancestor::div[@class='card-body']/descendant::div[@class='header-heading'][position()=1]/descendant::span[@class='base-icon sort-asc']";
	}

	private String LegendColumnNameCountLocator(String id) {
		return "xpath = //div[@id='"+id+"']/ancestor::div[@class='card-body']/descendant::div[@class='table-row']";
	}
	
	private String LegendColumn2Title(String id) {
		return "xpath = //div[@id='" + id
				+ "']/ancestor::div[@class='card-body']/descendant::div[@class='header-heading'][position()=2]";
	}

	private String LegendColumn2Sort(String id) {
		return "xpath = //div[@id='" + id
				+ "']/ancestor::div[@class='card-body']/descendant::div[@class='header-heading'][position()=2]/descendant::span[@class='base-icon sort-asc']";
	}
	
	private String LegendColumn3Title(String id) {
		return "xpath = //div[@id='" + id
				+ "']/ancestor::div[@class='card-body']/descendant::div[@class='header-heading'][position()=3]";
	}

	private String LegendColumn3Sort(String id) {
		return "xpath = //div[@id='" + id
				+ "']/ancestor::div[@class='card-body']/descendant::div[@class='header-heading'][position()=3]/descendant::span[@class='base-icon sort-asc']";
	}
	
	
	// ********************** Expand View Widget Validation ********************************************
	
	private String Expand(String id) {
		return "xpath = //div[@id='"+id+"']/ancestor::div[@class='card-body']/preceding-sibling::div/descendant::span[@class='icon-class'][position()=3]";
	}

	private String expandViewWidgetTitle = "xpath = //div[@class='ant-modal-content']//descendant::div[@class='card crd']/child::div[@class='card-header']";
	private String expandViewZoomOutBtn = "xpath =(//div[@class='ant-modal-content']//descendant::div[@class='card crd']/child::div[@class='card-header']/descendant::span[@class='icon-class'])[position()=1]";
	private String expandViewZoomInBtn = "xpath =(//div[@class='ant-modal-content']//descendant::div[@class='card crd']/child::div[@class='card-header']/descendant::span[@class='icon-class'])[position()=2]";
	//private String expandViewCloseIcon = "xpath =(//div[@class='ant-modal-content']//descendant::div[@class='card crd']/child::div[@class='card-header']/descendant::span[@class='icon-class'])[position()=3]";
	private String expandViewCloseBtn = "xpath = //div[@class='ant-modal-content']/child::div[@class='ant-modal-footer']/child::button[contains(.,'Close')]";
	private String expandViewXaxisTitle = "xpath = //div[@class='ant-modal-content']//descendant::div[@class='card crd']/child::div[@class='card-body']//descendant::*[name()='g' and @class='apexcharts-xaxis-title']";
	private String expandViewYaxisTitle = "xpath = //div[@class='ant-modal-content']//descendant::div[@class='card crd']/child::div[@class='card-body']//descendant::*[name()='g' and @class='apexcharts-yaxis-title']";
	private String expandViewXaxisLines = "xpath = //div[@class='ant-modal-content']//descendant::div[@class='card crd']/child::div[@class='card-body']/descendant::*[name()='line' and @class='apexcharts-xaxis-tick']";
	private String expandViewXaxisValues = "xpath = //div[@class='ant-modal-content']//descendant::div[@class='card crd']/child::div[@class='card-body']/descendant::*[name()='text' and contains(.,'-')]";
	private String expandViewLegendColumn1HeaderTitle = "xpath =(//div[@class='ant-modal-content']//descendant::div[@class='card crd']/descendant::div[@class='legend']/descendant::div[@class='header-heading'])[position()=1]";
	private String expandViewLegendColumn2HeaderTitle = "xpath =(//div[@class='ant-modal-content']//descendant::div[@class='card crd']/descendant::div[@class='legend']/descendant::div[@class='header-heading'])[position()=2]";
	private String expandViewLegendColumn3HeaderTitle = "xpath =(//div[@class='ant-modal-content']//descendant::div[@class='card crd']/descendant::div[@class='legend']/descendant::div[@class='header-heading'])[position()=3]";
	private String expandViewLegendColumnHeader2infoMessage = "xpath = (//div[@class='ant-modal-content']/descendant::div[@class='card crd']/descendant::div[@class='legend']/descendant::div[@class='table-row'])[1]";
	private String expandViewLegendColumnHeader3infoMessage = "xpath = (//div[@class='ant-modal-content']/descendant::div[@class='card crd']/descendant::div[@class='legend']/descendant::div[@class='table-row'])[2]";

	// Colors Reading
	private String RowColorList(String id) {
		return "xpath = //div[@id='" + id
				+ "']/ancestor::div[@class='graph']/descendant::div[@class='table-body']/descendant::span[@class='dot']";
	}

	private String RowColor1(String id) {
		return "xpath = //div[@id='" + id
				+ "']/ancestor::div[@class='graph']/descendant::div[@class='table-body']/descendant::span[@class='dot'][position()=1]";
	}

	private String RowColor2(String id) {
		return "xpath = //div[@id='" + id
				+ "']/ancestor::div[@class='graph']/descendant::div[@class='table-body']/descendant::span[@class='dot'][position()=2]";
	}

	private String RowColor3(String id) {
		return "xpath = //div[@id='" + id
				+ "']/ancestor::div[@class='graph']/descendant::div[@class='table-body']/descendant::span[@class='dot'][position()=3]";
	}

	private String RowColor4(String id) {
		return "xpath = //div[@id='" + id
				+ "']/ancestor::div[@class='graph']/descendant::div[@class='table-body']/descendant::span[@class='dot'][position()=4]";
	}

	private String RowColor5(String id) {
		return "xpath = //div[@id='" + id
				+ "']/ancestor::div[@class='graph']/descendant::div[@class='table-body']/descendant::span[@class='dot'][position()=5]";
	}

	private String RowColor6(String id) {
		return "xpath = //div[@id='" + id
				+ "']/ancestor::div[@class='graph']/descendant::div[@class='table-body']/descendant::span[@class='dot'][position()=6]";
	}
}
