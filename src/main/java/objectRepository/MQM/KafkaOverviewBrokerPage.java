package objectRepository.MQM;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;

import genericUtilities.ExcelUtility;
import genericUtilities.GenericMethods;
import java.util.ArrayList;
import java.util.List;

public class KafkaOverviewBrokerPage 
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
	private String brokerTab = "xpath = //div[@class='overviewTabSelector']/child::div[@class][position()=1]";
		
	private String MetricsLegendTitle = "xpath = //div[@class='metrics-wrapper']/descendant::div[@class='card-header']";
	private String MetricsNoOfBrokers = "xpath = //div[@class='card-body']/descendant::div[@class='textLabel'][position()=1]";
	private String MetricsNoOfTopics = "xpath = //div[@class='card-body']/descendant::div[@class='textLabel'][position()=2]";
	private String MetricsNoOfPartitions = "xpath = //div[@class='card-body']/descendant::div[@class='textLabel'][position()=3]";
	private String MetricsNoOfProducers = "xpath = //div[@class='card-body']/descendant::div[@class='textLabel'][position()=4]";
	private String MetricsNoOfConsumers = "xpath = //div[@class='card-body']/descendant::div[@class='textLabel'][position()=5]";

//Bytes In Graph 
	private String bytesInGraphTitle = "xpath = //div[@class='overviewTabSelector']/child::div[@class='kafkaTabItem kafkaActiveTab']/child::span[.='Broker']/ancestor::div[@class='overviewTabSelector']/following-sibling::div//div[.='Bytes in ']";
	private String bytesInXaxis = "xpath = //div[.='Bytes in ']/following-sibling::div/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-title-text chart-lables']";
	private String bytesInYaxis = "xpath = //div[.='Bytes in ']/following-sibling::div/descendant::*[name()='text' and @class='apexcharts-text apexcharts-yaxis-title-text chart-lables']";
	private String bytesInXaxisLine = "xpath = //div[.='Bytes in ']/following-sibling::div/descendant::*[name()='line' and @class='apexcharts-xaxis-tick']";
	private String bytesInXaxisValues = "xpath =//div[@id='apexchartschart-kafka_broker_bytes_in_per_sec']/descendant::*[name()='tspan' and contains(.,'-')]";
	private String bytesInZoomOut = "xpath = (//div[.='Bytes in ']/descendant::span[@class='icon-class'])[position()=1]";
	private String bytesInZoomIn = "xpath = (//div[.='Bytes in ']/descendant::span[@class='icon-class'])[position()=2]";
	private String bytesInLegendTitle1 = "xpath = (//div[.='Bytes in ']/following-sibling::div/descendant::div[@class='header-heading'])[position()=1]";
	private String bytesInLegendTitle2 = "xpath = (//div[.='Bytes in ']/following-sibling::div/descendant::div[@class='header-heading'])[position()=2]";
	private String bytesInLegendTitle3 = "xpath = (//div[.='Bytes in ']/following-sibling::div/descendant::div[@class='header-heading'])[position()=3]";
	private String bytesInToolTipTitle = "xpath = //div[.='Bytes in ']/following-sibling::div/descendant::div[@class='apexcharts-tooltip-title']";
	
//Bytes Out Graph 
	private String bytesOutGraphTitle = "xpath = //div[@class='overviewTabSelector']/child::div[@class='kafkaTabItem kafkaActiveTab']/child::span[.='Broker']/ancestor::div[@class='overviewTabSelector']/following-sibling::div//div[.='Bytes out ']";
	private String bytesOutXaxis = "xpath = //div[.='Bytes out ']/following-sibling::div/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-title-text chart-lables']";
	private String bytesOutYaxis = "xpath = //div[.='Bytes out ']/following-sibling::div/descendant::*[name()='text' and @class='apexcharts-text apexcharts-yaxis-title-text chart-lables']";
	private String bytesOutXaxisLine = "xpath = //div[.='Bytes out ']/following-sibling::div/descendant::*[name()='line' and @class='apexcharts-xaxis-tick']";
	private String bytesOutXaxisValues = "xpath =//div[@id='apexchartschart-kafka_broker_bytes_out_per_sec']/descendant::*[name()='tspan' and contains(.,'-')]";
	private String bytesOutZoomOut = "xpath = (//div[.='Bytes out ']/descendant::span[@class='icon-class'])[position()=1]";
	private String bytesOutZoomIn = "xpath = (//div[.='Bytes out ']/descendant::span[@class='icon-class'])[position()=2]";
	private String bytesOutLegendTitle1 = "xpath = (//div[.='Bytes out ']/following-sibling::div/descendant::div[@class='header-heading'])[position()=1]";
	private String bytesOutLegendTitle2 = "xpath = (//div[.='Bytes out ']/following-sibling::div/descendant::div[@class='header-heading'])[position()=2]";
	private String bytesOutLegendTitle3 = "xpath = (//div[.='Bytes out ']/following-sibling::div/descendant::div[@class='header-heading'])[position()=3]";
	private String bytesOutToolTipTitle = "xpath = //div[.='Bytes out ']/following-sibling::div/descendant::div[@class='apexcharts-tooltip-title']";
	
//Total produced request rate Graph 
	private String totalProducedRequestRateGraphTitle = "xpath = //div[@class='overviewTabSelector']/child::div[@class='kafkaTabItem kafkaActiveTab']/child::span[.='Broker']/ancestor::div[@class='overviewTabSelector']/following-sibling::div//div[.='Total produced request rate ']";
	private String totalProducedRequestRateXaxis = "xpath = //div[.='Total produced request rate ']/following-sibling::div/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-title-text chart-lables']";
	private String totalProducedRequestRateYaxis = "xpath = //div[.='Total produced request rate ']/following-sibling::div/descendant::*[name()='text' and @class='apexcharts-text apexcharts-yaxis-title-text chart-lables']";
	private String totalProducedRequestRateXaxisLine = "xpath = //div[.='Total produced request rate ']/following-sibling::div/descendant::*[name()='line' and @class='apexcharts-xaxis-tick']";
	private String totalProducedRequestRateXaxisValues = "xpath =//div[@id='apexchartschart-kafka_broker_total_produce_requests_per_sec']/descendant::*[name()='tspan' and contains(.,'-')]";
	private String totalProducedRequestRateZoomOut = "xpath = (//div[.='Total produced request rate ']/descendant::span[@class='icon-class'])[position()=1]";
	private String totalProducedRequestRateZoomIn = "xpath = (//div[.='Total produced request rate ']/descendant::span[@class='icon-class'])[position()=2]";
	private String totalProducedRequestRateLegendTitle1 = "xpath = (//div[.='Total produced request rate ']/following-sibling::div/descendant::div[@class='header-heading'])[position()=1]";
	private String totalProducedRequestRateLegendTitle2 = "xpath = (//div[.='Total produced request rate ']/following-sibling::div/descendant::div[@class='header-heading'])[position()=2]";
	private String totalProducedRequestRateLegendTitle3 = "xpath = (//div[.='Total produced request rate ']/following-sibling::div/descendant::div[@class='header-heading'])[position()=3]";
	private String totalProducedRequestRateToolTipTitle = "xpath = //div[.='Total produced request rate ']/following-sibling::div/descendant::div[@class='apexcharts-tooltip-title']";
	
//Total fetch request rate Graph 
	private String totalFetchRequestRateGraphTitle = "xpath = //div[@class='overviewTabSelector']/child::div[@class='kafkaTabItem kafkaActiveTab']/child::span[.='Broker']/ancestor::div[@class='overviewTabSelector']/following-sibling::div//div[.='Total fetch request rate ']";
	private String totalFetchRequestRateXaxis = "xpath = //div[.='Total fetch request rate ']/following-sibling::div/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-title-text chart-lables']";
	private String totalFetchRequestRateYaxis = "xpath = //div[.='Total fetch request rate ']/following-sibling::div/descendant::*[name()='text' and @class='apexcharts-text apexcharts-yaxis-title-text chart-lables']";
	private String totalFetchRequestRateXaxisLine = "xpath = //div[.='Total fetch request rate ']/following-sibling::div/descendant::*[name()='line' and @class='apexcharts-xaxis-tick']";
	private String totalFetchRequestRateXaxisValues = "xpath =//div[@id='apexchartschart-kafka_broker_total_fetch_requests_per_sec']/descendant::*[name()='tspan' and contains(.,'-')]";
	private String totalFetchRequestRateZoomOut = "xpath = (//div[.='Total fetch request rate ']/descendant::span[@class='icon-class'])[position()=1]";
	private String totalFetchRequestRateZoomIn = "xpath = (//div[.='Total fetch request rate ']/descendant::span[@class='icon-class'])[position()=2]";
	private String totalFetchRequestRateLegendTitle1 = "xpath = (//div[.='Total fetch request rate ']/following-sibling::div/descendant::div[@class='header-heading'])[position()=1]";
	private String totalFetchRequestRateLegendTitle2 = "xpath = (//div[.='Total fetch request rate ']/following-sibling::div/descendant::div[@class='header-heading'])[position()=2]";
	private String totalFetchRequestRateLegendTitle3 = "xpath = (//div[.='Total fetch request rate ']/following-sibling::div/descendant::div[@class='header-heading'])[position()=3]";
	private String totalFetchRequestRateToolTipTitle = "xpath = //div[.='Total fetch request rate ']/following-sibling::div/descendant::div[@class='apexcharts-tooltip-title']";
	
//Messages in Graph 
	private String messagesInGraphTitle = "xpath = //div[@class='overviewTabSelector']/child::div[@class='kafkaTabItem kafkaActiveTab']/child::span[.='Broker']/ancestor::div[@class='overviewTabSelector']/following-sibling::div//div[.='Messages in ']";
	private String messagesInXaxis = "xpath = //div[.='Messages in ']/following-sibling::div/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-title-text chart-lables']";
	private String messagesInYaxis = "xpath = //div[.='Messages in ']/following-sibling::div/descendant::*[name()='text' and @class='apexcharts-text apexcharts-yaxis-title-text chart-lables']";
	private String messagesInXaxisLine = "xpath = //div[.='Messages in ']/following-sibling::div/descendant::*[name()='line' and @class='apexcharts-xaxis-tick']";
	private String messagesInXaxisValues = "xpath =//div[@id='apexchartschart-kafka_broker_messages_in_per_sec']/descendant::*[name()='tspan' and contains(.,'-')]";
	private String messagesInZoomOut = "xpath = (//div[.='Messages in ']/descendant::span[@class='icon-class'])[position()=1]";
	private String messagesInZoomIn = "xpath = (//div[.='Messages in ']/descendant::span[@class='icon-class'])[position()=2]";
	private String messagesInLegendTitle1 = "xpath = (//div[.='Messages in ']/following-sibling::div/descendant::div[@class='header-heading'])[position()=1]";
	private String messagesInLegendTitle2 = "xpath = (//div[.='Messages in ']/following-sibling::div/descendant::div[@class='header-heading'])[position()=2]";
	private String messagesInLegendTitle3 = "xpath = (//div[.='Messages in ']/following-sibling::div/descendant::div[@class='header-heading'])[position()=3]";
	private String messagesInToolTipTitle = "xpath = //div[.='Messages in ']/following-sibling::div/descendant::div[@class='apexcharts-tooltip-title']";

//Leader election rate Graph 
	private String leaderElectionRateGraphTitle = "xpath = //div[@class='overviewTabSelector']/child::div[@class='kafkaTabItem kafkaActiveTab']/child::span[.='Broker']/ancestor::div[@class='overviewTabSelector']/following-sibling::div//div[.='Leader election rate ']";
	private String leaderElectionRateXaxis = "xpath = //div[.='Leader election rate ']/following-sibling::div/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-title-text chart-lables']";
	private String leaderElectionRateYaxis = "xpath = //div[.='Leader election rate ']/following-sibling::div/descendant::*[name()='text' and @class='apexcharts-text apexcharts-yaxis-title-text chart-lables']";
	private String leaderElectionRateXaxisLine = "xpath = //div[.='Leader election rate ']/following-sibling::div/descendant::*[name()='line' and @class='apexcharts-xaxis-tick']";
	private String leaderElectionRateXaxisValues = "xpath =//div[@id='apexchartschart-kafka_broker_leader_election_rate_and_timems']/descendant::*[name()='tspan' and contains(.,'-')]";
	private String leaderElectionRateZoomOut = "xpath = (//div[.='Leader election rate ']/descendant::span[@class='icon-class'])[position()=1]";
	private String leaderElectionRateZoomIn = "xpath = (//div[.='Leader election rate ']/descendant::span[@class='icon-class'])[position()=2]";
	private String leaderElectionRateLegendTitle1 = "xpath = (//div[.='Leader election rate ']/following-sibling::div/descendant::div[@class='header-heading'])[position()=1]";
	private String leaderElectionRateLegendTitle2 = "xpath = (//div[.='Leader election rate ']/following-sibling::div/descendant::div[@class='header-heading'])[position()=2]";
	private String leaderElectionRateLegendTitle3 = "xpath = (//div[.='Leader election rate ']/following-sibling::div/descendant::div[@class='header-heading'])[position()=3]";
	private String leaderElectionRateToolTipTitle = "xpath = //div[.='Leader election rate ']/following-sibling::div/descendant::div[@class='apexcharts-tooltip-title']";
	
//Uncleaned election leader per second Graph 
	private String uncleanedElectionLeaderPerSecondGraphTitle = "xpath = //div[@class='overviewTabSelector']/child::div[@class='kafkaTabItem kafkaActiveTab']/child::span[.='Broker']/ancestor::div[@class='overviewTabSelector']/following-sibling::div//div[.='Uncleaned election leader per second ']";
	private String uncleanedElectionLeaderPerSecondXaxis = "xpath = //div[.='Uncleaned election leader per second ']/following-sibling::div/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-title-text chart-lables']";
	private String uncleanedElectionLeaderPerSecondYaxis = "xpath = //div[.='Uncleaned election leader per second ']/following-sibling::div/descendant::*[name()='text' and @class='apexcharts-text apexcharts-yaxis-title-text chart-lables']";
	private String uncleanedElectionLeaderPerSecondXaxisLine = "xpath = //div[.='Uncleaned election leader per second ']/following-sibling::div/descendant::*[name()='line' and @class='apexcharts-xaxis-tick']";
	private String uncleanedElectionLeaderPerSecondXaxisValues = "xpath =//div[@id='apexchartschart-kafka_broker_unclean_leader_elections_per_sec']/descendant::*[name()='tspan' and contains(.,'-')]";
	private String uncleanedElectionLeaderPerSecondZoomOut = "xpath = (//div[.='Uncleaned election leader per second ']/descendant::span[@class='icon-class'])[position()=1]";
	private String uncleanedElectionLeaderPerSecondZoomIn = "xpath = (//div[.='Uncleaned election leader per second ']/descendant::span[@class='icon-class'])[position()=2]";
	private String uncleanedElectionLeaderPerSecondLegendTitle1 = "xpath = (//div[.='Uncleaned election leader per second ']/following-sibling::div/descendant::div[@class='header-heading'])[position()=1]";
	private String uncleanedElectionLeaderPerSecondLegendTitle2 = "xpath = (//div[.='Uncleaned election leader per second ']/following-sibling::div/descendant::div[@class='header-heading'])[position()=2]";
	private String uncleanedElectionLeaderPerSecondLegendTitle3 = "xpath = (//div[.='Uncleaned election leader per second ']/following-sibling::div/descendant::div[@class='header-heading'])[position()=3]";
	private String uncleanedElectionLeaderPerSecondToolTipTitle = "xpath = //div[.='Uncleaned election leader per second ']/following-sibling::div/descendant::div[@class='apexcharts-tooltip-title']";
	
//No. of brokers Graph 
	private String noOfBrokersGraphTitle = "xpath = (//div[@class='overviewTabSelector']/child::div[@class='kafkaTabItem kafkaActiveTab']/child::span[.='Broker']/ancestor::div[@class='overviewTabSelector']/following-sibling::div//div[.=' No. of brokers'])[position()=1]";
	private String noOfBrokersXaxis = "xpath = //div[.=' No. of brokers']/following-sibling::div/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-title-text chart-lables']";
	private String noOfBrokersYaxis = "xpath = //div[.=' No. of brokers']/following-sibling::div/descendant::*[name()='text' and @class='apexcharts-text apexcharts-yaxis-title-text chart-lables']";
	private String noOfBrokersXaxisLine = "xpath = //div[.=' No. of brokers']/following-sibling::div/descendant::*[name()='line' and @class='apexcharts-xaxis-tick']";
	private String noOfBrokersXaxisValues = "xpath = //div[@id='apexchartsvuechart-line-0']/descendant::*[name()='tspan' and contains(.,'-')]";
	private String noOfBrokersZoomOut = "xpath = (//div[.=' No. of brokers']/descendant::span[@class='icon-class'])[position()=1]";
	private String noOfBrokersZoomIn = "xpath = (//div[.=' No. of brokers']/descendant::span[@class='icon-class'])[position()=2]";
	private String noOfBrokersZoomReset = "xpath = (//div[.=' No. of brokers']/descendant::span[@class='icon-class'])[position()=3]";
	private String noOfBrokersToolTipTitle = "xpath = //div[.=' No. of brokers']/following-sibling::div/descendant::div[@class='apexcharts-tooltip-title']";
	
//Expand Button
	private String bytesInExpand = "xpath = (//div[.='Bytes in ']/descendant::span[@class='icon-class'])[position()=3]";
	private String bytesOutExpand = "xpath = (//div[.='Bytes out ']/descendant::span[@class='icon-class'])[position()=3]";	
	private String totalProducedRequestRateExpand = "xpath = (//div[.='Total produced request rate ']/descendant::span[@class='icon-class'])[position()=3]";	
	private String totalFetchRequestRateExpand = "xpath = (//div[.='Total fetch request rate ']/descendant::span[@class='icon-class'])[position()=3]";	
	private String messagesInExpand = "xpath = (//div[.='Messages in ']/descendant::span[@class='icon-class'])[position()=3]";	
	private String leaderElectionRateExpand = "xpath = (//div[.='Leader election rate ']/descendant::span[@class='icon-class'])[position()=3]";
	private String uncleanedElectionLeaderPerSecondExpand = "xpath = (//div[.='Uncleaned election leader per second ']/descendant::span[@class='icon-class'])[position()=3]";

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

	public KafkaOverviewBrokerPage(Page page) {
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
	
/*
 * Broker Tab
 */

	public void validateBrokerTabTitle(String expectedTitle) {
		String actualTitle = page.locator(brokerTab).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}
	
/*
 * Bytes In Graph
 */

	public void validateBytesInGraphTitle(String expectedTitle) {		  
		String actualTitle = page.locator(bytesInGraphTitle).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateBytesInZoomInBtn() {		  
		util.graphZoomIn(page, bytesInZoomIn, bytesInXaxisValues);
	}

	public void validateBytesInZoomOutBtn() {
		util.graphZoomOut(page, bytesInZoomIn, bytesInZoomOut, bytesInXaxisValues);
	}

	public void validateBytesInGraphXaxisTitle(String expectedTitle) {	 
		String actualTitle = page.locator(bytesInXaxis).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateBytesInGraphYaxisTitle(String expectedTitle) {	 
		String actualTitle = page.locator(bytesInYaxis).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateBytesInGraphLegendTitle1(String expectedTitle) {
		String actualTitle = page.locator(bytesInLegendTitle1).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateBytesInGraphLegendTitle2(String expectedTitle) {	 
		String actualTitle = page.locator(bytesInLegendTitle2).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateBytesInGraphLegendTitle3(String expectedTitle) {	 
		String actualTitle = page.locator(bytesInLegendTitle3).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateBytesInToolTipTitle() {	 
		util.validateWidgetToolTips(page, bytesInXaxisLine, bytesInToolTipTitle);
	}

	public void validateBytesInDragAndDrop() {
		util.graphZoomInByDragAndDrop(page, bytesInXaxisLine, bytesInZoomOut, bytesInXaxisValues);
	}
	public void validateBytesInExpandViewXAxisTitle() { 
		util.validateExpandViewTexts(page, bytesInXaxis, bytesInExpand, expandViewCloseBtn, expandViewXaxisTitle);
	}

	public void validateBytesInExpandViewYAxisTitle() {
		util.validateExpandViewTexts(page, bytesInYaxis, bytesInExpand, expandViewCloseBtn, expandViewYaxisTitle);
	}

	public void validateBytesInExpandViewWidgetTitle() {
		util.validateExpandViewTexts(page, bytesInGraphTitle, bytesInExpand, expandViewCloseBtn, expandViewWidgetTitle);
	}

	public void validateBytesInExpandViewLegendHeader1() {	 
		util.validateExpandViewTexts(page, bytesInLegendTitle1, bytesInExpand, expandViewCloseBtn, expandViewLegendColumn1HeaderTitle);
	}

	public void validateBytesInExpandViewLegendHeader2() {	 
		util.validateExpandViewTexts(page, bytesInLegendTitle2 ,bytesInExpand, expandViewCloseBtn, expandViewLegendColumn2HeaderTitle);
	}

	public void validateBytesInExpandViewLegendHeader3() {	 
		util.validateExpandViewTexts(page, bytesInLegendTitle3 ,bytesInExpand, expandViewCloseBtn, expandViewLegendColumn3HeaderTitle);
	}

	public void validateBytesInExpandViewZoomIn() {
		util.ExpandViewZoomInBtn(page, expandViewZoomInBtn, bytesInExpand, expandViewCloseBtn, expandViewXaxisValues);
	}

	public void validateBytesInExpandViewZoomOut() {
		util.ExpandViewZoomOutBtn(page, expandViewZoomInBtn, bytesInExpand, expandViewCloseBtn, expandViewZoomOutBtn, expandViewXaxisValues);
	}

	public void validateBytesInExpandViewWidgetDragDrop() {
		util.ExpandViewWidgetDragDrop(page, bytesInExpand, expandViewCloseBtn, expandViewXaxisLines, expandViewZoomOutBtn, expandViewXaxisValues);
	}
	
/*
 * Bytes Out Graph
 */

	public void validateBytesOutGraphTitle(String expectedTitle) {		  
		String actualTitle = page.locator(bytesOutGraphTitle).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateBytesOutZoomInBtn() {		  
		util.graphZoomIn(page, bytesOutZoomIn, bytesOutXaxisValues);
	}

	public void validateBytesOutZoomOutBtn() {
		util.graphZoomOut(page, bytesOutZoomIn, bytesOutZoomOut, bytesOutXaxisValues);
	}

	public void validateBytesOutGraphXaxisTitle(String expectedTitle) {	 
		String actualTitle = page.locator(bytesOutXaxis).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateBytesOutGraphYaxisTitle(String expectedTitle) {	 
		String actualTitle = page.locator(bytesOutYaxis).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateBytesOutGraphLegendTitle1(String expectedTitle) {
		String actualTitle = page.locator(bytesOutLegendTitle1).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateBytesOutGraphLegendTitle2(String expectedTitle) {	 
		String actualTitle = page.locator(bytesOutLegendTitle2).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateBytesOutGraphLegendTitle3(String expectedTitle) {	 
		String actualTitle = page.locator(bytesOutLegendTitle3).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateBytesOutToolTipTitle() {	 
		util.validateWidgetToolTips(page, bytesOutXaxisLine, bytesOutToolTipTitle);
	}

	public void validateBytesOutDragAndDrop() {
		util.graphZoomInByDragAndDrop(page, bytesOutXaxisLine, bytesOutZoomOut, bytesOutXaxisValues);
	}
	public void validateBytesOutExpandViewXAxisTitle() { 
		util.validateExpandViewTexts(page, bytesOutXaxis, bytesOutExpand, expandViewCloseBtn, expandViewXaxisTitle);
	}

	public void validateBytesOutExpandViewYAxisTitle() {
		util.validateExpandViewTexts(page, bytesOutYaxis, bytesOutExpand, expandViewCloseBtn, expandViewYaxisTitle);
	}

	public void validateBytesOutExpandViewWidgetTitle() {
		util.validateExpandViewTexts(page, bytesOutGraphTitle, bytesOutExpand, expandViewCloseBtn, expandViewWidgetTitle);
	}

	public void validateBytesOutExpandViewLegendHeader1() {	 
		util.validateExpandViewTexts(page, bytesOutLegendTitle1, bytesOutExpand, expandViewCloseBtn, expandViewLegendColumn1HeaderTitle);
	}

	public void validateBytesOutExpandViewLegendHeader2() {	 
		util.validateExpandViewTexts(page, bytesOutLegendTitle2 ,bytesOutExpand, expandViewCloseBtn, expandViewLegendColumn2HeaderTitle);
	}

	public void validateBytesOutExpandViewLegendHeader3() {	 
		util.validateExpandViewTexts(page, bytesOutLegendTitle3 ,bytesOutExpand, expandViewCloseBtn, expandViewLegendColumn3HeaderTitle);
	}

	public void validateBytesOutExpandViewZoomIn() {
		util.ExpandViewZoomInBtn(page, expandViewZoomInBtn, bytesOutExpand, expandViewCloseBtn, expandViewXaxisValues);
	}

	public void validateBytesOutExpandViewZoomOut() {
		util.ExpandViewZoomOutBtn(page, expandViewZoomInBtn, bytesOutExpand, expandViewCloseBtn, expandViewZoomOutBtn, expandViewXaxisValues);
	}

	public void validateBytesOutExpandViewWidgetDragDrop() {
		util.ExpandViewWidgetDragDrop(page, bytesOutExpand, expandViewCloseBtn, expandViewXaxisLines, expandViewZoomOutBtn, expandViewXaxisValues);
	}
	
/*
 * Total Produced Request Rate Graph
 */

	public void validateTotalProducedRequestRateGraphTitle(String expectedTitle) {		  
		String actualTitle = page.locator(totalProducedRequestRateGraphTitle).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateTotalProducedRequestRateZoomInBtn() {		  
		util.graphZoomIn(page, totalProducedRequestRateZoomIn, totalProducedRequestRateXaxisValues);
	}

	public void validateTotalProducedRequestRateZoomOutBtn() {
		util.graphZoomOut(page, totalProducedRequestRateZoomIn, totalProducedRequestRateZoomOut, totalProducedRequestRateXaxisValues);
	}

	public void validateTotalProducedRequestRateGraphXaxisTitle(String expectedTitle) {	 
		String actualTitle = page.locator(totalProducedRequestRateXaxis).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateTotalProducedRequestRateGraphYaxisTitle(String expectedTitle) {	 
		String actualTitle = page.locator(totalProducedRequestRateYaxis).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateTotalProducedRequestRateGraphLegendTitle1(String expectedTitle) {
		String actualTitle = page.locator(totalProducedRequestRateLegendTitle1).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateTotalProducedRequestRateGraphLegendTitle2(String expectedTitle) {	 
		String actualTitle = page.locator(totalProducedRequestRateLegendTitle2).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateTotalProducedRequestRateGraphLegendTitle3(String expectedTitle) {	 
		String actualTitle = page.locator(totalProducedRequestRateLegendTitle3).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateTotalProducedRequestRateToolTipTitle() {	 
		util.validateWidgetToolTips(page, totalProducedRequestRateXaxisLine, totalProducedRequestRateToolTipTitle);
	}

	public void validateTotalProducedRequestRateDragAndDrop() {
		util.graphZoomInByDragAndDrop(page, totalProducedRequestRateXaxisLine, totalProducedRequestRateZoomOut, totalProducedRequestRateXaxisValues);
	}
	public void validateTotalProducedRequestRateExpandViewXAxisTitle() { 
		util.validateExpandViewTexts(page, totalProducedRequestRateXaxis, totalProducedRequestRateExpand, expandViewCloseBtn, expandViewXaxisTitle);
	}

	public void validateTotalProducedRequestRateExpandViewYAxisTitle() {
		util.validateExpandViewTexts(page, totalProducedRequestRateYaxis, totalProducedRequestRateExpand, expandViewCloseBtn, expandViewYaxisTitle);
	}

	public void validateTotalProducedRequestRateExpandViewWidgetTitle() {
		util.validateExpandViewTexts(page, totalProducedRequestRateGraphTitle, totalProducedRequestRateExpand, expandViewCloseBtn, expandViewWidgetTitle);
	}

	public void validateTotalProducedRequestRateExpandViewLegendHeader1() {	 
		util.validateExpandViewTexts(page, totalProducedRequestRateLegendTitle1, totalProducedRequestRateExpand, expandViewCloseBtn, expandViewLegendColumn1HeaderTitle);
	}

	public void validateTotalProducedRequestRateExpandViewLegendHeader2() {	 
		util.validateExpandViewTexts(page, totalProducedRequestRateLegendTitle2 ,totalProducedRequestRateExpand, expandViewCloseBtn, expandViewLegendColumn2HeaderTitle);
	}

	public void validateTotalProducedRequestRateExpandViewLegendHeader3() {	 
		util.validateExpandViewTexts(page, totalProducedRequestRateLegendTitle3 ,totalProducedRequestRateExpand, expandViewCloseBtn, expandViewLegendColumn3HeaderTitle);
	}

	public void validateTotalProducedRequestRateExpandViewZoomIn() {
		util.ExpandViewZoomInBtn(page, expandViewZoomInBtn, totalProducedRequestRateExpand, expandViewCloseBtn, expandViewXaxisValues);
	}

	public void validateTotalProducedRequestRateExpandViewZoomOut() {
		util.ExpandViewZoomOutBtn(page, expandViewZoomInBtn, totalProducedRequestRateExpand, expandViewCloseBtn, expandViewZoomOutBtn, expandViewXaxisValues);
	}

	public void validateTotalProducedRequestRateExpandViewWidgetDragDrop() {
		util.ExpandViewWidgetDragDrop(page, totalProducedRequestRateExpand, expandViewCloseBtn, expandViewXaxisLines, expandViewZoomOutBtn, expandViewXaxisValues);
	}
	
/*
 * Total Fetch Request Rate Graph
 */

	public void validateTotalFetchRequestRateGraphTitle(String expectedTitle) {		  
		String actualTitle = page.locator(totalFetchRequestRateGraphTitle).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateTotalFetchRequestRateZoomInBtn() {		  
		util.graphZoomIn(page, totalFetchRequestRateZoomIn, totalFetchRequestRateXaxisValues);
	}

	public void validateTotalFetchRequestRateZoomOutBtn() {
		util.graphZoomOut(page, totalFetchRequestRateZoomIn, totalFetchRequestRateZoomOut, totalFetchRequestRateXaxisValues);
	}

	public void validateTotalFetchRequestRateGraphXaxisTitle(String expectedTitle) {	 
		String actualTitle = page.locator(totalFetchRequestRateXaxis).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateTotalFetchRequestRateGraphYaxisTitle(String expectedTitle) {	 
		String actualTitle = page.locator(totalFetchRequestRateYaxis).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateTotalFetchRequestRateGraphLegendTitle1(String expectedTitle) {
		String actualTitle = page.locator(totalFetchRequestRateLegendTitle1).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateTotalFetchRequestRateGraphLegendTitle2(String expectedTitle) {	 
		String actualTitle = page.locator(totalFetchRequestRateLegendTitle2).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateTotalFetchRequestRateGraphLegendTitle3(String expectedTitle) {	 
		String actualTitle = page.locator(totalFetchRequestRateLegendTitle3).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateTotalFetchRequestRateToolTipTitle() {	 
		util.validateWidgetToolTips(page, totalFetchRequestRateXaxisLine, totalFetchRequestRateToolTipTitle);
	}

	public void validateTotalFetchRequestRateDragAndDrop() {
		util.graphZoomInByDragAndDrop(page, totalFetchRequestRateXaxisLine, totalFetchRequestRateZoomOut, totalFetchRequestRateXaxisValues);
	}
	public void validateTotalFetchRequestRateExpandViewXAxisTitle() { 
		util.validateExpandViewTexts(page, totalFetchRequestRateXaxis, totalFetchRequestRateExpand, expandViewCloseBtn, expandViewXaxisTitle);
	}

	public void validateTotalFetchRequestRateExpandViewYAxisTitle() {
		util.validateExpandViewTexts(page, totalFetchRequestRateYaxis, totalFetchRequestRateExpand, expandViewCloseBtn, expandViewYaxisTitle);
	}

	public void validateTotalFetchRequestRateExpandViewWidgetTitle() {
		util.validateExpandViewTexts(page, totalFetchRequestRateGraphTitle, totalFetchRequestRateExpand, expandViewCloseBtn, expandViewWidgetTitle);
	}

	public void validateTotalFetchRequestRateExpandViewLegendHeader1() {	 
		util.validateExpandViewTexts(page, totalFetchRequestRateLegendTitle1, totalFetchRequestRateExpand, expandViewCloseBtn, expandViewLegendColumn1HeaderTitle);
	}

	public void validateTotalFetchRequestRateExpandViewLegendHeader2() {	 
		util.validateExpandViewTexts(page, totalFetchRequestRateLegendTitle2 ,totalFetchRequestRateExpand, expandViewCloseBtn, expandViewLegendColumn2HeaderTitle);
	}

	public void validateTotalFetchRequestRateExpandViewLegendHeader3() {	 
		util.validateExpandViewTexts(page, totalFetchRequestRateLegendTitle3 ,totalFetchRequestRateExpand, expandViewCloseBtn, expandViewLegendColumn3HeaderTitle);
	}

	public void validateTotalFetchRequestRateExpandViewZoomIn() {
		util.ExpandViewZoomInBtn(page, expandViewZoomInBtn, totalFetchRequestRateExpand, expandViewCloseBtn, expandViewXaxisValues);
	}

	public void validateTotalFetchRequestRateExpandViewZoomOut() {
		util.ExpandViewZoomOutBtn(page, expandViewZoomInBtn, totalFetchRequestRateExpand, expandViewCloseBtn, expandViewZoomOutBtn, expandViewXaxisValues);
	}

	public void validateTotalFetchRequestRateExpandViewWidgetDragDrop() {
		util.ExpandViewWidgetDragDrop(page, totalFetchRequestRateExpand, expandViewCloseBtn, expandViewXaxisLines, expandViewZoomOutBtn, expandViewXaxisValues);
	}
	
/*
 * Messages In Graph
 */

	public void validateMessagesInGraphTitle(String expectedTitle) {		  
		String actualTitle = page.locator(messagesInGraphTitle).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateMessagesInZoomInBtn() {		  
		util.graphZoomIn(page, messagesInZoomIn, messagesInXaxisValues);
	}

	public void validateMessagesInZoomOutBtn() {
		util.graphZoomOut(page, messagesInZoomIn, messagesInZoomOut, messagesInXaxisValues);
	}

	public void validateMessagesInGraphXaxisTitle(String expectedTitle) {	 
		String actualTitle = page.locator(messagesInXaxis).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateMessagesInGraphYaxisTitle(String expectedTitle) {	 
		String actualTitle = page.locator(messagesInYaxis).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateMessagesInGraphLegendTitle1(String expectedTitle) {
		String actualTitle = page.locator(messagesInLegendTitle1).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateMessagesInGraphLegendTitle2(String expectedTitle) {	 
		String actualTitle = page.locator(messagesInLegendTitle2).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateMessagesInGraphLegendTitle3(String expectedTitle) {	 
		String actualTitle = page.locator(messagesInLegendTitle3).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateMessagesInToolTipTitle() {	 
		util.validateWidgetToolTips(page, messagesInXaxisLine, messagesInToolTipTitle);
	}

	public void validateMessagesInDragAndDrop() {
		util.graphZoomInByDragAndDrop(page, messagesInXaxisLine, messagesInZoomOut, messagesInXaxisValues);
	}
	public void validateMessagesInExpandViewXAxisTitle() { 
		util.validateExpandViewTexts(page, messagesInXaxis, messagesInExpand, expandViewCloseBtn, expandViewXaxisTitle);
	}

	public void validateMessagesInExpandViewYAxisTitle() {
		util.validateExpandViewTexts(page, messagesInYaxis, messagesInExpand, expandViewCloseBtn, expandViewYaxisTitle);
	}

	public void validateMessagesInExpandViewWidgetTitle() {
		util.validateExpandViewTexts(page, messagesInGraphTitle, messagesInExpand, expandViewCloseBtn, expandViewWidgetTitle);
	}

	public void validateMessagesInExpandViewLegendHeader1() {	 
		util.validateExpandViewTexts(page, messagesInLegendTitle1, messagesInExpand, expandViewCloseBtn, expandViewLegendColumn1HeaderTitle);
	}

	public void validateMessagesInExpandViewLegendHeader2() {	 
		util.validateExpandViewTexts(page, messagesInLegendTitle2 ,messagesInExpand, expandViewCloseBtn, expandViewLegendColumn2HeaderTitle);
	}

	public void validateMessagesInExpandViewLegendHeader3() {	 
		util.validateExpandViewTexts(page, messagesInLegendTitle3 ,messagesInExpand, expandViewCloseBtn, expandViewLegendColumn3HeaderTitle);
	}

	public void validateMessagesInExpandViewZoomIn() {
		util.ExpandViewZoomInBtn(page, expandViewZoomInBtn, messagesInExpand, expandViewCloseBtn, expandViewXaxisValues);
	}

	public void validateMessagesInExpandViewZoomOut() {
		util.ExpandViewZoomOutBtn(page, expandViewZoomInBtn, messagesInExpand, expandViewCloseBtn, expandViewZoomOutBtn, expandViewXaxisValues);
	}

	public void validateMessagesInExpandViewWidgetDragDrop() {
		util.ExpandViewWidgetDragDrop(page, messagesInExpand, expandViewCloseBtn, expandViewXaxisLines, expandViewZoomOutBtn, expandViewXaxisValues);
	}

/*
 * Leader election rate Graph
 */

	public void validateLeaderElectionRateGraphTitle(String expectedTitle) {		  
		String actualTitle = page.locator(leaderElectionRateGraphTitle).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateLeaderElectionRateZoomInBtn() {		  
		util.graphZoomIn(page, leaderElectionRateZoomIn, leaderElectionRateXaxisValues);
	}

	public void validateLeaderElectionRateZoomOutBtn() {
		util.graphZoomOut(page, leaderElectionRateZoomIn, leaderElectionRateZoomOut, leaderElectionRateXaxisValues);
	}

	public void validateLeaderElectionRateGraphXaxisTitle(String expectedTitle) {	 
		String actualTitle = page.locator(leaderElectionRateXaxis).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateLeaderElectionRateGraphYaxisTitle(String expectedTitle) {	 
		String actualTitle = page.locator(leaderElectionRateYaxis).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateLeaderElectionRateGraphLegendTitle1(String expectedTitle) {
		String actualTitle = page.locator(leaderElectionRateLegendTitle1).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateLeaderElectionRateGraphLegendTitle2(String expectedTitle) {	 
		String actualTitle = page.locator(leaderElectionRateLegendTitle2).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateLeaderElectionRateGraphLegendTitle3(String expectedTitle) {	 
		String actualTitle = page.locator(leaderElectionRateLegendTitle3).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateLeaderElectionRateToolTipTitle() {	 
		util.validateWidgetToolTips(page, leaderElectionRateXaxisLine, leaderElectionRateToolTipTitle);
	}

	public void validateLeaderElectionRateDragAndDrop() {
		util.graphZoomInByDragAndDrop(page, leaderElectionRateXaxisLine, leaderElectionRateZoomOut, leaderElectionRateXaxisValues);
	}
	public void validateLeaderElectionRateExpandViewXAxisTitle() { 
		util.validateExpandViewTexts(page, leaderElectionRateXaxis, leaderElectionRateExpand, expandViewCloseBtn, expandViewXaxisTitle);
	}

	public void validateLeaderElectionRateExpandViewYAxisTitle() {
		util.validateExpandViewTexts(page, leaderElectionRateYaxis, leaderElectionRateExpand, expandViewCloseBtn, expandViewYaxisTitle);
	}

	public void validateLeaderElectionRateExpandViewWidgetTitle() {
		util.validateExpandViewTexts(page, leaderElectionRateGraphTitle, leaderElectionRateExpand, expandViewCloseBtn, expandViewWidgetTitle);
	}

	public void validateLeaderElectionRateExpandViewLegendHeader1() {	 
		util.validateExpandViewTexts(page, leaderElectionRateLegendTitle1, leaderElectionRateExpand, expandViewCloseBtn, expandViewLegendColumn1HeaderTitle);
	}

	public void validateLeaderElectionRateExpandViewLegendHeader2() {	 
		util.validateExpandViewTexts(page, leaderElectionRateLegendTitle2 ,leaderElectionRateExpand, expandViewCloseBtn, expandViewLegendColumn2HeaderTitle);
	}

	public void validateLeaderElectionRateExpandViewLegendHeader3() {	 
		util.validateExpandViewTexts(page, leaderElectionRateLegendTitle3 ,leaderElectionRateExpand, expandViewCloseBtn, expandViewLegendColumn3HeaderTitle);
	}

	public void validateLeaderElectionRateExpandViewZoomIn() {
		util.ExpandViewZoomInBtn(page, expandViewZoomInBtn, leaderElectionRateExpand, expandViewCloseBtn, expandViewXaxisValues);
	}

	public void validateLeaderElectionRateExpandViewZoomOut() {
		util.ExpandViewZoomOutBtn(page, expandViewZoomInBtn, leaderElectionRateExpand, expandViewCloseBtn, expandViewZoomOutBtn, expandViewXaxisValues);
	}

	public void validateLeaderElectionRateExpandViewWidgetDragDrop() {
		util.ExpandViewWidgetDragDrop(page, leaderElectionRateExpand, expandViewCloseBtn, expandViewXaxisLines, expandViewZoomOutBtn, expandViewXaxisValues);
	}
	
/*
 * Uncleaned election leader per second Graph
 */

	public void validateUncleanedElectionLeaderPerSecondGraphTitle(String expectedTitle) {		  
		String actualTitle = page.locator(uncleanedElectionLeaderPerSecondGraphTitle).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateUncleanedElectionLeaderPerSecondZoomInBtn() {		  
		util.graphZoomIn(page, uncleanedElectionLeaderPerSecondZoomIn, uncleanedElectionLeaderPerSecondXaxisValues);
	}

	public void validateUncleanedElectionLeaderPerSecondZoomOutBtn() {
		util.graphZoomOut(page, uncleanedElectionLeaderPerSecondZoomIn, uncleanedElectionLeaderPerSecondZoomOut, uncleanedElectionLeaderPerSecondXaxisValues);
	}

	public void validateUncleanedElectionLeaderPerSecondGraphXaxisTitle(String expectedTitle) {	 
		String actualTitle = page.locator(uncleanedElectionLeaderPerSecondXaxis).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateUncleanedElectionLeaderPerSecondGraphYaxisTitle(String expectedTitle) {	 
		String actualTitle = page.locator(uncleanedElectionLeaderPerSecondYaxis).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateUncleanedElectionLeaderPerSecondGraphLegendTitle1(String expectedTitle) {
		String actualTitle = page.locator(uncleanedElectionLeaderPerSecondLegendTitle1).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateUncleanedElectionLeaderPerSecondGraphLegendTitle2(String expectedTitle) {	 
		String actualTitle = page.locator(uncleanedElectionLeaderPerSecondLegendTitle2).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateUncleanedElectionLeaderPerSecondGraphLegendTitle3(String expectedTitle) {	 
		String actualTitle = page.locator(uncleanedElectionLeaderPerSecondLegendTitle3).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateUncleanedElectionLeaderPerSecondToolTipTitle() {	 
		util.validateWidgetToolTips(page, uncleanedElectionLeaderPerSecondXaxisLine, uncleanedElectionLeaderPerSecondToolTipTitle);
	}

	public void validateUncleanedElectionLeaderPerSecondDragAndDrop() {
		util.graphZoomInByDragAndDrop(page, uncleanedElectionLeaderPerSecondXaxisLine, uncleanedElectionLeaderPerSecondZoomOut, uncleanedElectionLeaderPerSecondXaxisValues);
	}
	public void validateUncleanedElectionLeaderPerSecondExpandViewXAxisTitle() { 
		util.validateExpandViewTexts(page, uncleanedElectionLeaderPerSecondXaxis, uncleanedElectionLeaderPerSecondExpand, expandViewCloseBtn, expandViewXaxisTitle);
	}

	public void validateUncleanedElectionLeaderPerSecondExpandViewYAxisTitle() {
		util.validateExpandViewTexts(page, uncleanedElectionLeaderPerSecondYaxis, uncleanedElectionLeaderPerSecondExpand, expandViewCloseBtn, expandViewYaxisTitle);
	}

	public void validateUncleanedElectionLeaderPerSecondExpandViewWidgetTitle() {
		util.validateExpandViewTexts(page, uncleanedElectionLeaderPerSecondGraphTitle, uncleanedElectionLeaderPerSecondExpand, expandViewCloseBtn, expandViewWidgetTitle);
	}

	public void validateUncleanedElectionLeaderPerSecondExpandViewLegendHeader1() {	 
		util.validateExpandViewTexts(page, uncleanedElectionLeaderPerSecondLegendTitle1, uncleanedElectionLeaderPerSecondExpand, expandViewCloseBtn, expandViewLegendColumn1HeaderTitle);
	}

	public void validateUncleanedElectionLeaderPerSecondExpandViewLegendHeader2() {	 
		util.validateExpandViewTexts(page, uncleanedElectionLeaderPerSecondLegendTitle2 ,uncleanedElectionLeaderPerSecondExpand, expandViewCloseBtn, expandViewLegendColumn2HeaderTitle);
	}

	public void validateUncleanedElectionLeaderPerSecondExpandViewLegendHeader3() {	 
		util.validateExpandViewTexts(page, uncleanedElectionLeaderPerSecondLegendTitle3 ,uncleanedElectionLeaderPerSecondExpand, expandViewCloseBtn, expandViewLegendColumn3HeaderTitle);
	}

	public void validateUncleanedElectionLeaderPerSecondExpandViewZoomIn() {
		util.ExpandViewZoomInBtn(page, expandViewZoomInBtn, uncleanedElectionLeaderPerSecondExpand, expandViewCloseBtn, expandViewXaxisValues);
	}

	public void validateUncleanedElectionLeaderPerSecondExpandViewZoomOut() {
		util.ExpandViewZoomOutBtn(page, expandViewZoomInBtn, uncleanedElectionLeaderPerSecondExpand, expandViewCloseBtn, expandViewZoomOutBtn, expandViewXaxisValues);
	}

	public void validateUncleanedElectionLeaderPerSecondExpandViewWidgetDragDrop() {
		util.ExpandViewWidgetDragDrop(page, uncleanedElectionLeaderPerSecondExpand, expandViewCloseBtn, expandViewXaxisLines, expandViewZoomOutBtn, expandViewXaxisValues);
	}
	
/*
 * No. of brokers Graph
 */

	public void validateNoOfBrokersGraphTitle(String expectedTitle) {		  
		String actualTitle = page.locator(noOfBrokersGraphTitle).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateNoOfBrokersZoomInBtn( ){
		util.graphZoomIn(page, noOfBrokersZoomIn, noOfBrokersZoomReset, allWidgetXValues());
	}
	
	public void validateNoOfBrokersZoomOutBtn( ){
		util.graphZoomOut(page, noOfBrokersZoomIn, noOfBrokersZoomOut, noOfBrokersZoomReset, allWidgetXValues());
	}
	
	public void validateNoOfBrokersZoomResetBtn( ){
		util.graphZoomReset(page, noOfBrokersZoomIn, noOfBrokersZoomReset, allWidgetXValues());
	}
	
	public void validateNoOfBrokersGraphXaxisTitle(String expectedTitle) {	 
		String actualTitle = page.locator(noOfBrokersXaxis).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateNoOfBrokersGraphYaxisTitle(String expectedTitle) {	 
		String actualTitle = page.locator(noOfBrokersYaxis).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateNoOfBrokersToolTipTitle() {	 
		util.validateWidgetToolTips(page, noOfBrokersXaxisLine, noOfBrokersToolTipTitle);
	}

	public void validateNoOfBrokersDragAndDrop() {
		util.graphZoomInByDragAndDrop(page, noOfBrokersXaxisLine, noOfBrokersZoomOut, noOfBrokersXaxisValues);
	}
	
	
/*
 * Calendar
 */
		
	public void validateTheCustomTimeLine(String period) {
		util.validateCustomTimeLine(page, bytesInXaxisValues, period, WidgetXValues(period));
	}
		
	public void validateXaxisValuesForKafkaOverviewBrokerPage() {
		util.validateTheGraphdisplayingTheDataAsPerGivenTimeLines(page, bytesInXaxisValues, calenderView, allWidgetXValues());
	}
	
	public List<String> allWidgetXValues() {
		ArrayList<String> xValue = new ArrayList<String>();
		xValue.add(bytesInXaxisValues);
		xValue.add(bytesOutXaxisValues);
		xValue.add(totalProducedRequestRateXaxisValues);
		xValue.add(totalFetchRequestRateXaxisValues);
		xValue.add(messagesInXaxisValues);
		xValue.add(noOfBrokersXaxisValues);
		return xValue;
	}
}
