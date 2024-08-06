package objectRepository.MQM;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;

import genericUtilities.ExcelUtility;
import genericUtilities.GenericMethods;

public class MQKafka_Consumer_Page {
	Page page;
	GenericMethods util = new GenericMethods();
	ExcelUtility excel = new ExcelUtility();

	private String SelectMessageQueueDropdown = "#btn-arrow-down-mq-select-message-queue";
	private String SelectSearchFieldMQDropdown = "#input-search-sel-mq-select-message-queue";
	private String SelectMQDropdown = "#mq-select-message-queue-0-single";
	private String SelectServiceNameDropdown = "#btn-arrow-down-mq-select-service-name";
	private String SelectSearchFieldServiceNameDropdown = "#input-search-sel-mq-select-service-name";
	private String SearchedApplication = "xpath = //span[@id='mq-select-service-name-0-single']";
	private String calenderView = "xpath = //div[@class='selected-text ellipsis bg-text']";
	private String ConsumerTab = "xpath = //div[@class='navtab']/div[@class='item' and position()=3]/child::div";

	private String PartitionMetricsTab = "xpath = //div[@class='consumerTabSelector']/child::div[@class][position()=1]";
	private String RequestMetricsTab = "xpath = //div[@class='consumerTabSelector']/child::div[@class][position()=2]";
	private String ConnectionMetricsTab = "xpath = //div[@class='consumerTabSelector']/child::div[@class][position()=3]";

	// Consumer > Partition Metrics
	private String PartitionMetricsLagID = "apexchartschart-kafka_consumer_records_lag";
	private String PartitionMetricsLeadID = "apexchartschart-kafka_consumer_records_lead";

	// Consumer > Request Metrics
	//private String RequestMetricsFirstGraphTitle = "xpath =//div[.='Incoming bytes ']";
	private String RequestMetricsIncomingBytesID = "apexchartschart-kafka_consumer_records_lag";
	private String RequestMetricsOutgoingBytesID = "apexchartschart-kafka_consumer_records_lead";
	private String RequestMetricsAverageFetchLatencyID = "apexchartschart-kafka_consumer_fetch_latency_avg";
	private String RequestMetricsMaximumFetchLatencyID = "apexchartschart-kafka_consumer_fetch_latency_max";

	// Consumer > Connection Metrics
	private String ConnectionMetricsConnectionCreationRateID = "apexchartschart-kafka_consumer_records_lag";
	private String ConnectionMetricsConnectionCloseRateID = "apexchartschart-kafka_consumer_records_lead";
	//private String ConnectionMetricsIOWaitRatioID = "apexchartschart-kafka_consumer_fetch_latency_avg";
	//private String ConnectionMetricsIOWaitTimeAverageID = "apexchartschart-kafka_consumer_fetch_latency_max";
	private String ConnectionMetricsIOWaitRatioID  = "apexchartschart-kafka_consumer_io_wait_ratio";
	private String ConnectionMetricsIOWaitTimeAverageID = "apexchartschart-kafka_consumer_io_wait_time_ns_avg";
	
	public List<String> WidgetXValues(String XValue) {
		ArrayList<String> xValue = new ArrayList<String>();
		xValue.add(XValue);
		return xValue;
	}

	public MQKafka_Consumer_Page(Page page) {
		this.page = page;
	}

	public void navigateToKafka() {
		util.selectTheOptionFromDropDownBySearch(page, SelectMessageQueueDropdown, SelectSearchFieldMQDropdown, "Kafka",
				SelectMQDropdown);
		page.waitForLoadState(LoadState.NETWORKIDLE);
	}

	public void selectServiceName(String application) {
		 util.selectTheOptionFromDropDownBySearch(page, SelectServiceNameDropdown,
	  SelectSearchFieldServiceNameDropdown, application,
	  SearchedApplication); 
		 page.waitForLoadState(LoadState.NETWORKIDLE); }
	 

	public void navigateToConsumerTab() {
		page.locator(ConsumerTab).click();
		page.waitForLoadState(LoadState.NETWORKIDLE);
	}

	public void validateConsumerTitle(String expectedTitle) {
		String actualTitle = page.locator(ConsumerTab).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
		page.waitForLoadState(LoadState.NETWORKIDLE);
	}

	/*
	 * Partition Metrics Tab
	 */
	public void validatePartitionMetricsTabTitle(String expectedTitle) {
		String actualTitle = page.locator(PartitionMetricsTab).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void clickOnPartitionMetricsTab() {
		page.locator(PartitionMetricsTab).click();
		String actualTitle = page.locator("//div[@class='kafkaTabItem kafkaActiveTab']").textContent().trim();
		Assert.assertEquals(actualTitle.equalsIgnoreCase("Partition metrics"), true);
	}

//Partition Metrics > Lag Graph

	public void validatePartitionMetricsLagGraphTitle(String expectedTitle) {
		String actualTitle = page.locator(getWidgetTitle(PartitionMetricsLagID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validatePartitionMetricsLagZoomInBtn() {
		 
		util.graphZoomIn(page, ZoomIn(PartitionMetricsLagID), XaxisValues(PartitionMetricsLagID));
	}

	public void validatePartitionMetricsLagZoomOutBtn() {
		 
		util.graphZoomOut(page, ZoomIn(PartitionMetricsLagID), ZoomOut(PartitionMetricsLagID), XaxisValues(PartitionMetricsLagID));
	}

	public void validatePartitionMetricsLagXaxisValues() {
		//page.waitForTimeout(2000);
		util.validateTheGraphdisplayingTheDataAsPerGivenTimeLines(page, XaxisValues(PartitionMetricsLagID),
				calenderView, WidgetXValues(XaxisValues(PartitionMetricsLagID)));
	}

	public void validatePartitionMetricsLagGraphXaxisTitle(String expectedTitle) {
		String actualTitle = page.locator(XaxisTitle(PartitionMetricsLagID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validatePartitionMetricsLagGraphYaxisTitle(String expectedTitle) {
		String actualTitle = page.locator(YaxisTitle(PartitionMetricsLagID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validatePartitionMetricsLagGraphPartitionMetricsHeaderTitle(String expectedTitle) {
		String actualTitle = page.locator(HeaderTitle(PartitionMetricsLagID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validatePartitionMetricsLagGraphAvgHeaderTitle(String expectedTitle) {
		String actualTitle = page.locator(AvgHeader(PartitionMetricsLagID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validatePartitionMetricsLagGraphMaxHeaderTitle(String expectedTitle) {
		String actualTitle = page.locator(MaxHeader(PartitionMetricsLagID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validatePartitionMetricsLagGraphRowColor1(String expectedTitle) {
		//page.waitForTimeout(2000);
		String actualTitle = page.locator(RowColor1(PartitionMetricsLagID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validatePartitionMetricsLagToolTipTitle() {
		util.validateWidgetToolTips(page, XaxisLines(PartitionMetricsLagID), ToolTipTitle(PartitionMetricsLagID));
	}

	public void validatePartitionMetricsLagExpandViewXAxisTitle() {
		util.validateExpandViewTexts(page, XaxisTitle(PartitionMetricsLagID), Expand(PartitionMetricsLagID),
				expandViewCloseBtn, expandViewXaxisTitle);
	}

	public void validatePartitionMetricsLagExpandViewYAxisTitle() {
		util.validateExpandViewTexts(page, YaxisTitle(PartitionMetricsLagID), Expand(PartitionMetricsLagID),
				expandViewCloseBtn, expandViewYaxisTitle);
	}

	public void validatePartitionMetricsLagExpandViewWidgetTitle() {
		util.validateExpandViewTexts(page, getWidgetTitle(PartitionMetricsLagID), Expand(PartitionMetricsLagID),
				expandViewCloseBtn, expandViewWidgetTitle);
	}

	public void validatePartitionMetricsLagExpandViewLegendHeader1() {
		util.validateExpandViewTexts(page, LegendColumn1Title(PartitionMetricsLagID), Expand(PartitionMetricsLagID),
				expandViewCloseBtn, expandViewLegendColumn1HeaderTitle);
	}

	public void validatePartitionMetricsLagExpandViewLegendHeader2() {
		util.validateExpandViewTexts(page, LegendColumn2Title(PartitionMetricsLagID), Expand(PartitionMetricsLagID),
				expandViewCloseBtn, expandViewLegendColumn2HeaderTitle);
	}

	public void validatePartitionMetricsLagExpandViewLegendHeader3() {
		util.validateExpandViewTexts(page, LegendColumn3Title(PartitionMetricsLagID), Expand(PartitionMetricsLagID),
				expandViewCloseBtn, expandViewLegendColumn3HeaderTitle);
	}

	public void validatePartitionMetricsLagExpandViewLegendHeader2InforMessage() {
		util.validateExpandViewTexts(page, LegendColumn2Title(PartitionMetricsLagID), Expand(PartitionMetricsLagID),
				expandViewCloseBtn, expandViewLegendColumnHeader2infoMessage);
	}

	public void validatePartitionMetricsLagExpandViewLegendHeader3InforMessage() {
		util.validateExpandViewTexts(page, LegendColumn3Title(PartitionMetricsLagID), Expand(PartitionMetricsLagID),
				expandViewCloseBtn, expandViewLegendColumnHeader3infoMessage);
	}

	public void validatePartitionMetricsLagExpandViewZoomIn() {
		util.ExpandViewZoomInBtn(page, expandViewZoomInBtn, Expand(PartitionMetricsLagID), expandViewCloseBtn,
				expandViewXaxisValues);
	}

	public void validatePartitionMetricsLagExpandViewZoomOut() {
		util.ExpandViewZoomOutBtn(page, expandViewZoomInBtn, Expand(PartitionMetricsLagID), expandViewCloseBtn,
				expandViewZoomOutBtn, expandViewXaxisValues);
	}

	public void validatePartitionMetricsLagExpandViewWidgetDragDrop() {
		util.ExpandViewWidgetDragDrop(page, Expand(PartitionMetricsLagID), expandViewCloseBtn, expandViewXaxisLines,
				expandViewZoomOutBtn, expandViewXaxisValues);
	}

//Partition Metrics > Lead Graph

	public void validatePartitionMetricsLeadGraphTitle(String expectedTitle) {
		String actualTitle = page.locator(getWidgetTitle(PartitionMetricsLeadID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validatePartitionMetricsLeadZoomInBtn() {
		 
		util.graphZoomIn(page, ZoomIn(PartitionMetricsLeadID), XaxisValues(PartitionMetricsLeadID));
	}

	public void validatePartitionMetricsLeadZoomOutBtn() {
		  
		util.graphZoomOut(page, ZoomIn(PartitionMetricsLeadID), ZoomOut(PartitionMetricsLeadID),
				XaxisValues(PartitionMetricsLeadID));
	}

	public void validatePartitionMetricsLeadXaxisValues() {
		//page.waitForTimeout(5000);
		util.validateTheGraphdisplayingTheDataAsPerGivenTimeLines(page, XaxisValues(PartitionMetricsLeadID),
				calenderView, WidgetXValues(XaxisValues(PartitionMetricsLeadID)));
	}

	public void validatePartitionMetricsLeadGraphXaxisTitle(String expectedTitle) {
		String actualTitle = page.locator(XaxisTitle(PartitionMetricsLeadID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validatePartitionMetricsLeadGraphYaxisTitle(String expectedTitle) {
		String actualTitle = page.locator(YaxisTitle(PartitionMetricsLeadID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validatePartitionMetricsLeadGraphPartitionMetricsHeaderTitle(String expectedTitle) {
		String actualTitle = page.locator(HeaderTitle(PartitionMetricsLeadID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validatePartitionMetricsLeadGraphAvgHeaderTitle(String expectedTitle) {
		String actualTitle = page.locator(AvgHeader(PartitionMetricsLeadID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validatePartitionMetricsLeadGraphMaxHeaderTitle(String expectedTitle) {
		String actualTitle = page.locator(MaxHeader(PartitionMetricsLeadID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validatePartitionMetricsLeadGraphRowColor1(String expectedTitle) {
		//page.waitForTimeout(5000);
		String actualTitle = page.locator(RowColor1(PartitionMetricsLeadID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validatePartitionMetricsLeadToolTipTitle() {
		util.validateWidgetToolTips(page, XaxisLines(PartitionMetricsLeadID), ToolTipTitle(PartitionMetricsLeadID));
	}

	public void validatePartitionMetricsLeadExpandViewXAxisTitle() {
		util.validateExpandViewTexts(page, XaxisTitle(PartitionMetricsLeadID), Expand(PartitionMetricsLeadID),
				expandViewCloseBtn, expandViewXaxisTitle);
	}

	public void validatePartitionMetricsLeadExpandViewYAxisTitle() {
		util.validateExpandViewTexts(page, YaxisTitle(PartitionMetricsLeadID), Expand(PartitionMetricsLeadID),
				expandViewCloseBtn, expandViewYaxisTitle);
	}

	public void validatePartitionMetricsLeadExpandViewWidgetTitle() {
		util.validateExpandViewTexts(page, getWidgetTitle(PartitionMetricsLeadID), Expand(PartitionMetricsLeadID),
				expandViewCloseBtn, expandViewWidgetTitle);
	}

	public void validatePartitionMetricsLeadExpandViewLegendHeader1() {
		util.validateExpandViewTexts(page, LegendColumn1Title(PartitionMetricsLeadID), Expand(PartitionMetricsLeadID),
				expandViewCloseBtn, expandViewLegendColumn1HeaderTitle);
	}

	public void validatePartitionMetricsLeadExpandViewLegendHeader2() {
		util.validateExpandViewTexts(page, LegendColumn2Title(PartitionMetricsLeadID), Expand(PartitionMetricsLeadID),
				expandViewCloseBtn, expandViewLegendColumn2HeaderTitle);
	}

	public void validatePartitionMetricsLeadExpandViewLegendHeader3() {
		util.validateExpandViewTexts(page, LegendColumn3Title(PartitionMetricsLeadID), Expand(PartitionMetricsLeadID),
				expandViewCloseBtn, expandViewLegendColumn3HeaderTitle);
	}

	public void validatePartitionMetricsLeadExpandViewLegendHeader2InforMessage() {
		util.validateExpandViewTexts(page, LegendColumn2Title(PartitionMetricsLeadID), Expand(PartitionMetricsLeadID),
				expandViewCloseBtn, expandViewLegendColumnHeader2infoMessage);
	}

	public void validatePartitionMetricsLeadExpandViewLegendHeader3InforMessage() {
		util.validateExpandViewTexts(page, LegendColumn3Title(PartitionMetricsLeadID), Expand(PartitionMetricsLeadID),
				expandViewCloseBtn, expandViewLegendColumnHeader3infoMessage);
	}

	public void validatePartitionMetricsLeadExpandViewZoomIn() {
		util.ExpandViewZoomInBtn(page, expandViewZoomInBtn, Expand(PartitionMetricsLeadID), expandViewCloseBtn,
				expandViewXaxisValues);
	}

	public void validatePartitionMetricsLeadExpandViewZoomOut() {
		util.ExpandViewZoomOutBtn(page, expandViewZoomInBtn, Expand(PartitionMetricsLeadID), expandViewCloseBtn,
				expandViewZoomOutBtn, expandViewXaxisValues);
	}

	public void validatePartitionMetricsLeadExpandViewWidgetDragDrop() {
		//page.waitForTimeout(5000);
		util.ExpandViewWidgetDragDrop(page, Expand(PartitionMetricsLeadID), expandViewCloseBtn, expandViewXaxisLines,
				expandViewZoomOutBtn, expandViewXaxisValues);
	}

	/*
	 * Request Metrics Tab
	 */

	public void validateRequestMetricsTabTitle(String expectedTitle) {
		String actualTitle = page.locator(RequestMetricsTab).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void clickOnRequestMetricsTab() {
		page.reload();
		page.waitForLoadState(LoadState.NETWORKIDLE);
			page.locator(RequestMetricsTab).click();
			page.waitForLoadState(LoadState.NETWORKIDLE);
	
		
//		String actualTitle = page.locator("xpath = //div[@class='consumerTabSelector']/child::div[@class][position()=2]").textContent().trim();
//		Assert.assertEquals(actualTitle.equalsIgnoreCase("Request metrics"), true);
	}

//Request Metrics > Incoming Bytes Graph

	public void validateRequestMetricsIncomingBytesGraphTitle(String expectedTitle) {
		  
		String actualTitle = page.locator(getWidgetTitle(RequestMetricsIncomingBytesID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateRequestMetricsIncomingBytesZoomInBtn() {
		  
		util.graphZoomIn(page, ZoomIn(RequestMetricsIncomingBytesID), XaxisValues(RequestMetricsIncomingBytesID));

	}

	public void validateRequestMetricsIncomingBytesZoomOutBtn() {
		//page.waitForTimeout(2000);
		util.graphZoomOut(page, ZoomIn(RequestMetricsIncomingBytesID), ZoomOut(RequestMetricsIncomingBytesID),
				XaxisValues(RequestMetricsIncomingBytesID));
	}

	public void validateRequestMetricsIncomingBytesXaxisValues() {
		   
		util.validateTheGraphdisplayingTheDataAsPerGivenTimeLines(page, XaxisValues(RequestMetricsIncomingBytesID),
				calenderView, WidgetXValues(XaxisValues(RequestMetricsIncomingBytesID)));
	}

	public void validateRequestMetricsIncomingBytesGraphXaxisTitle(String expectedTitle) {
		 
		String actualTitle = page.locator(XaxisTitle(RequestMetricsIncomingBytesID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateRequestMetricsIncomingBytesGraphYaxisTitle(String expectedTitle) {
		 
		String actualTitle = page.locator(YaxisTitle(RequestMetricsIncomingBytesID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateRequestMetricsIncomingBytesGraphRequestMetricsHeaderTitle(String expectedTitle) {
		 
		String actualTitle = page.locator(HeaderTitle(RequestMetricsIncomingBytesID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateRequestMetricsIncomingBytesGraphAvgHeaderTitle(String expectedTitle) {
		 
		String actualTitle = page.locator(AvgHeader(RequestMetricsIncomingBytesID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateRequestMetricsIncomingBytesGraphMaxHeaderTitle(String expectedTitle) {
		 
		String actualTitle = page.locator(MaxHeader(RequestMetricsIncomingBytesID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateRequestMetricsIncomingBytesGraphRowColor1(String expectedTitle) {
		 
		String actualTitle = page.locator(RowColor1(RequestMetricsIncomingBytesID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateRequestMetricsIncomingBytesToolTipTitle() {
		 
		util.validateWidgetToolTips(page, XaxisLines(RequestMetricsIncomingBytesID),
				ToolTipTitle(RequestMetricsIncomingBytesID));
	}

	public void validateRequestMetricsIncomingBytesExpandViewXAxisTitle() {
		 
		util.validateExpandViewTexts(page, XaxisTitle(RequestMetricsIncomingBytesID),
				Expand(RequestMetricsIncomingBytesID), expandViewCloseBtn, expandViewXaxisTitle);
	}

	public void validateRequestMetricsIncomingBytesExpandViewYAxisTitle() throws InterruptedException {
		 
		//page.waitForSelector(Expand(RequestMetricsIncomingBytesID));
		util.validateExpandViewTexts(page, YaxisTitle(RequestMetricsIncomingBytesID),
				Expand(RequestMetricsIncomingBytesID), expandViewCloseBtn, expandViewYaxisTitle);
	}

	public void validateRequestMetricsIncomingBytesExpandViewWidgetTitle() {
		 
		util.validateExpandViewTexts(page, getWidgetTitle(RequestMetricsIncomingBytesID),
				Expand(RequestMetricsIncomingBytesID), expandViewCloseBtn, expandViewWidgetTitle);
	}

	public void validateRequestMetricsIncomingBytesExpandViewLegendHeader1() {
		 
		util.validateExpandViewTexts(page, LegendColumn1Title(RequestMetricsIncomingBytesID),
				Expand(RequestMetricsIncomingBytesID), expandViewCloseBtn, expandViewLegendColumn1HeaderTitle);
	}

	public void validateRequestMetricsIncomingBytesExpandViewLegendHeader2() {
		 
		util.validateExpandViewTexts(page, LegendColumn2Title(RequestMetricsIncomingBytesID),
				Expand(RequestMetricsIncomingBytesID), expandViewCloseBtn, expandViewLegendColumn2HeaderTitle);
	}

	public void validateRequestMetricsIncomingBytesExpandViewLegendHeader3() {
		 
		util.validateExpandViewTexts(page, LegendColumn3Title(RequestMetricsIncomingBytesID),
				Expand(RequestMetricsIncomingBytesID), expandViewCloseBtn, expandViewLegendColumn3HeaderTitle);
	}

	public void validateRequestMetricsIncomingBytesExpandViewLegendHeader2InforMessage() {
		util.validateExpandViewTexts(page, LegendColumn2Title(RequestMetricsIncomingBytesID),
				Expand(RequestMetricsIncomingBytesID), expandViewCloseBtn, expandViewLegendColumnHeader2infoMessage);
	}

	public void validateRequestMetricsIncomingBytesExpandViewLegendHeader3InforMessage() {
		util.validateExpandViewTexts(page, LegendColumn3Title(RequestMetricsIncomingBytesID),
				Expand(RequestMetricsIncomingBytesID), expandViewCloseBtn, expandViewLegendColumnHeader3infoMessage);
	}

	public void validateRequestMetricsIncomingBytesExpandViewZoomIn() {
		//page.waitForTimeout(2000);
		util.ExpandViewZoomInBtn(page, expandViewZoomInBtn, Expand(RequestMetricsIncomingBytesID), expandViewCloseBtn,
				expandViewXaxisValues);
	}

	public void validateRequestMetricsIncomingBytesExpandViewZoomOut() {
		 
		util.ExpandViewZoomOutBtn(page, expandViewZoomInBtn, Expand(RequestMetricsIncomingBytesID), expandViewCloseBtn,
				expandViewZoomOutBtn, expandViewXaxisValues);
	}

	public void validateRequestMetricsIncomingBytesExpandViewWidgetDragDrop() {
		 
		util.ExpandViewWidgetDragDrop(page, Expand(RequestMetricsIncomingBytesID), expandViewCloseBtn,
				expandViewXaxisLines, expandViewZoomOutBtn, expandViewXaxisValues);
	}

//Request Metrics > Outgoing Bytes Graph

	public void validateRequestMetricsOutgoingBytesGraphTitle(String expectedTitle) {
		 
		String actualTitle = page.locator(getWidgetTitle(RequestMetricsOutgoingBytesID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateRequestMetricsOutgoingBytesZoomInBtn() {
		 
		util.graphZoomIn(page, ZoomIn(RequestMetricsOutgoingBytesID), XaxisValues(RequestMetricsOutgoingBytesID));
	}

	public void validateRequestMetricsOutgoingBytesZoomOutBtn() {
		  
		util.graphZoomOut(page, ZoomIn(RequestMetricsOutgoingBytesID), ZoomOut(RequestMetricsOutgoingBytesID),
				XaxisValues(RequestMetricsOutgoingBytesID));
	}

	public void validateRequestMetricsOutgoingBytesXaxisValues() {
		  
		util.validateTheGraphdisplayingTheDataAsPerGivenTimeLines(page, XaxisValues(RequestMetricsOutgoingBytesID),
				calenderView, WidgetXValues(XaxisValues(RequestMetricsOutgoingBytesID)));
	}

	public void validateRequestMetricsOutgoingBytesGraphXaxisTitle(String expectedTitle) {
		  
		String actualTitle = page.locator(XaxisTitle(RequestMetricsOutgoingBytesID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateRequestMetricsOutgoingBytesGraphYaxisTitle(String expectedTitle) {
		 
		String actualTitle = page.locator(YaxisTitle(RequestMetricsOutgoingBytesID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateRequestMetricsOutgoingBytesGraphRequestMetricsHeaderTitle(String expectedTitle) {
		 
		String actualTitle = page.locator(HeaderTitle(RequestMetricsOutgoingBytesID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateRequestMetricsOutgoingBytesGraphAvgHeaderTitle(String expectedTitle) {
		 
		String actualTitle = page.locator(AvgHeader(RequestMetricsOutgoingBytesID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateRequestMetricsOutgoingBytesGraphMaxHeaderTitle(String expectedTitle) {
		 
		String actualTitle = page.locator(MaxHeader(RequestMetricsOutgoingBytesID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateRequestMetricsOutgoingBytesGraphRowColor1(String expectedTitle) {
		 
		String actualTitle = page.locator(RowColor1(RequestMetricsOutgoingBytesID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateRequestMetricsOutgoingBytesToolTipTitle() {
		 
		util.validateWidgetToolTips(page, XaxisLines(RequestMetricsOutgoingBytesID),
				ToolTipTitle(RequestMetricsOutgoingBytesID));
	}

	public void validateRequestMetricsOutgoingBytesExpandViewXAxisTitle() {
		 
		util.validateExpandViewTexts(page, XaxisTitle(RequestMetricsOutgoingBytesID),
				Expand(RequestMetricsOutgoingBytesID), expandViewCloseBtn, expandViewXaxisTitle);
	}

	public void validateRequestMetricsOutgoingBytesExpandViewYAxisTitle() {
		 
		util.validateExpandViewTexts(page, YaxisTitle(RequestMetricsOutgoingBytesID),
				Expand(RequestMetricsOutgoingBytesID), expandViewCloseBtn, expandViewYaxisTitle);
	}

	public void validateRequestMetricsOutgoingBytesExpandViewWidgetTitle() {
		 
		util.validateExpandViewTexts(page, getWidgetTitle(RequestMetricsOutgoingBytesID),
				Expand(RequestMetricsOutgoingBytesID), expandViewCloseBtn, expandViewWidgetTitle);
	}

	public void validateRequestMetricsOutgoingBytesExpandViewLegendHeader1() {
		 
		util.validateExpandViewTexts(page, LegendColumn1Title(RequestMetricsOutgoingBytesID),
				Expand(RequestMetricsOutgoingBytesID), expandViewCloseBtn, expandViewLegendColumn1HeaderTitle);
	}

	public void validateRequestMetricsOutgoingBytesExpandViewLegendHeader2() {
		//page.waitForTimeout(2000);
		util.validateExpandViewTexts(page, LegendColumn2Title(RequestMetricsOutgoingBytesID),
				Expand(RequestMetricsOutgoingBytesID), expandViewCloseBtn, expandViewLegendColumn2HeaderTitle);
	}

	public void validateRequestMetricsOutgoingBytesExpandViewLegendHeader3() {
		 
		util.validateExpandViewTexts(page, LegendColumn3Title(RequestMetricsOutgoingBytesID),
				Expand(RequestMetricsOutgoingBytesID), expandViewCloseBtn, expandViewLegendColumn3HeaderTitle);
	}

	public void validateRequestMetricsOutgoingBytesExpandViewLegendHeader2InforMessage() {
		util.validateExpandViewTexts(page, LegendColumn2Title(RequestMetricsOutgoingBytesID),
				Expand(RequestMetricsOutgoingBytesID), expandViewCloseBtn, expandViewLegendColumnHeader2infoMessage);
	}

	public void validateRequestMetricsOutgoingBytesExpandViewLegendHeader3InforMessage() {
		util.validateExpandViewTexts(page, LegendColumn3Title(RequestMetricsOutgoingBytesID),
				Expand(RequestMetricsOutgoingBytesID), expandViewCloseBtn, expandViewLegendColumnHeader3infoMessage);
	}

	public void validateRequestMetricsOutgoingBytesExpandViewZoomIn() {
		 
		util.ExpandViewZoomInBtn(page, expandViewZoomInBtn, Expand(RequestMetricsOutgoingBytesID), expandViewCloseBtn,
				expandViewXaxisValues);
	}

	public void validateRequestMetricsOutgoingBytesExpandViewZoomOut() {
		 
		util.ExpandViewZoomOutBtn(page, expandViewZoomInBtn, Expand(RequestMetricsOutgoingBytesID), expandViewCloseBtn,
				expandViewZoomOutBtn, expandViewXaxisValues);
	}

	public void validateRequestMetricsOutgoingBytesExpandViewWidgetDragDrop() {
		//page.waitForTimeout(2000);
		util.ExpandViewWidgetDragDrop(page, Expand(RequestMetricsOutgoingBytesID), expandViewCloseBtn,
				expandViewXaxisLines, expandViewZoomOutBtn, expandViewXaxisValues);
	}

//Request Metrics > Average Fetch Latency Graph

	public void validateRequestMetricsAverageFetchLatencyGraphTitle(String expectedTitle) {
		String actualTitle = page.locator(getWidgetTitle(RequestMetricsAverageFetchLatencyID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateRequestMetricsAverageFetchLatencyZoomInBtn() {
		  
		util.graphZoomIn(page, ZoomIn(RequestMetricsAverageFetchLatencyID), XaxisValues(RequestMetricsAverageFetchLatencyID));
	}

	public void validateRequestMetricsAverageFetchLatencyZoomOutBtn() {
		  
		util.graphZoomOut(page, ZoomIn(RequestMetricsAverageFetchLatencyID),
				ZoomOut(RequestMetricsAverageFetchLatencyID), XaxisValues(RequestMetricsAverageFetchLatencyID));
	}

	public void validateRequestMetricsAverageFetchLatencyXaxisValues() {
		  
		util.validateTheGraphdisplayingTheDataAsPerGivenTimeLines(page,
				XaxisValues(RequestMetricsAverageFetchLatencyID), calenderView,
				WidgetXValues(XaxisValues(RequestMetricsAverageFetchLatencyID)));
	}

	public void validateRequestMetricsAverageFetchLatencyGraphXaxisTitle(String expectedTitle) {
		 
		String actualTitle = page.locator(XaxisTitle(RequestMetricsAverageFetchLatencyID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateRequestMetricsAverageFetchLatencyGraphYaxisTitle(String expectedTitle) {
		 
		String actualTitle = page.locator(YaxisTitle(RequestMetricsAverageFetchLatencyID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateRequestMetricsAverageFetchLatencyGraphRequestMetricsHeaderTitle(String expectedTitle) {
		 
		String actualTitle = page.locator(HeaderTitle(RequestMetricsAverageFetchLatencyID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateRequestMetricsAverageFetchLatencyGraphAvgHeaderTitle(String expectedTitle) {
		 
		String actualTitle = page.locator(AvgHeader(RequestMetricsAverageFetchLatencyID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateRequestMetricsAverageFetchLatencyGraphMaxHeaderTitle(String expectedTitle) {
		 
		String actualTitle = page.locator(MaxHeader(RequestMetricsAverageFetchLatencyID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateRequestMetricsAverageFetchLatencyGraphRowColor1(String expectedTitle) {
		 
		String actualTitle = page.locator(RowColor1(RequestMetricsAverageFetchLatencyID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateRequestMetricsAverageFetchLatencyToolTipTitle() {
		 
		util.validateWidgetToolTips(page, XaxisLines(RequestMetricsAverageFetchLatencyID),
				ToolTipTitle(RequestMetricsAverageFetchLatencyID));
	}

	public void validateRequestMetricsAverageFetchLatencyExpandViewXAxisTitle() {
		 
		util.validateExpandViewTexts(page, XaxisTitle(RequestMetricsAverageFetchLatencyID),
				Expand(RequestMetricsAverageFetchLatencyID), expandViewCloseBtn, expandViewXaxisTitle);
	}

	public void validateRequestMetricsAverageFetchLatencyExpandViewYAxisTitle() {
		 
		util.validateExpandViewTexts(page, YaxisTitle(RequestMetricsAverageFetchLatencyID),
				Expand(RequestMetricsAverageFetchLatencyID), expandViewCloseBtn, expandViewYaxisTitle);
	}

	public void validateRequestMetricsAverageFetchLatencyExpandViewWidgetTitle() {
		 
		util.validateExpandViewTexts(page, getWidgetTitle(RequestMetricsAverageFetchLatencyID),
				Expand(RequestMetricsAverageFetchLatencyID), expandViewCloseBtn, expandViewWidgetTitle);
	}

	public void validateRequestMetricsAverageFetchLatencyExpandViewLegendHeader1() {
		 
		util.validateExpandViewTexts(page, LegendColumn1Title(RequestMetricsAverageFetchLatencyID),
				Expand(RequestMetricsAverageFetchLatencyID), expandViewCloseBtn, expandViewLegendColumn1HeaderTitle);
	}

	public void validateRequestMetricsAverageFetchLatencyExpandViewLegendHeader2() {
		 
		util.validateExpandViewTexts(page, LegendColumn2Title(RequestMetricsAverageFetchLatencyID),
				Expand(RequestMetricsAverageFetchLatencyID), expandViewCloseBtn, expandViewLegendColumn2HeaderTitle);
	}

	public void validateRequestMetricsAverageFetchLatencyExpandViewLegendHeader3() {
		 
		util.validateExpandViewTexts(page, LegendColumn3Title(RequestMetricsAverageFetchLatencyID),
				Expand(RequestMetricsAverageFetchLatencyID), expandViewCloseBtn, expandViewLegendColumn3HeaderTitle);
	}

	public void validateRequestMetricsAverageFetchLatencyExpandViewLegendHeader2InforMessage() {
		util.validateExpandViewTexts(page, LegendColumn2Title(RequestMetricsAverageFetchLatencyID),
				Expand(RequestMetricsAverageFetchLatencyID), expandViewCloseBtn,
				expandViewLegendColumnHeader2infoMessage);
	}

	public void validateRequestMetricsAverageFetchLatencyExpandViewLegendHeader3InforMessage() {
		util.validateExpandViewTexts(page, LegendColumn3Title(RequestMetricsAverageFetchLatencyID),
				Expand(RequestMetricsAverageFetchLatencyID), expandViewCloseBtn,
				expandViewLegendColumnHeader3infoMessage);
	}

	public void validateRequestMetricsAverageFetchLatencyExpandViewZoomIn() {
		 
		util.ExpandViewZoomInBtn(page, expandViewZoomInBtn, Expand(RequestMetricsAverageFetchLatencyID),
				expandViewCloseBtn, expandViewXaxisValues);
	}

	public void validateRequestMetricsAverageFetchLatencyExpandViewZoomOut() {
		 
		util.ExpandViewZoomOutBtn(page, expandViewZoomInBtn, Expand(RequestMetricsAverageFetchLatencyID),
				expandViewCloseBtn, expandViewZoomOutBtn, expandViewXaxisValues);
	}

	public void validateRequestMetricsAverageFetchLatencyExpandViewWidgetDragDrop() {
		 
		util.ExpandViewWidgetDragDrop(page, Expand(RequestMetricsAverageFetchLatencyID), expandViewCloseBtn,
				expandViewXaxisLines, expandViewZoomOutBtn, expandViewXaxisValues);
	}

//Request Metrics > Maximum Fetch Latency Graph

	public void validateRequestMetricsMaximumFetchLatencyGraphTitle(String expectedTitle) {
		 
		String actualTitle = page.locator(getWidgetTitle(RequestMetricsMaximumFetchLatencyID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateRequestMetricsMaximumFetchLatencyZoomInBtn() {
		  
		util.graphZoomIn(page, ZoomIn(RequestMetricsMaximumFetchLatencyID), XaxisValues(RequestMetricsMaximumFetchLatencyID));
	}

	public void validateRequestMetricsMaximumFetchLatencyZoomOutBtn() {
		  
		util.graphZoomOut(page, ZoomIn(RequestMetricsMaximumFetchLatencyID),
				ZoomOut(RequestMetricsMaximumFetchLatencyID), XaxisValues(RequestMetricsMaximumFetchLatencyID));
	}

	public void validateRequestMetricsMaximumFetchLatencyXaxisValues() {
		 
		util.validateTheGraphdisplayingTheDataAsPerGivenTimeLines(page,
				XaxisValues(RequestMetricsMaximumFetchLatencyID), calenderView,
				WidgetXValues(XaxisValues(RequestMetricsMaximumFetchLatencyID)));
	}

	public void validateRequestMetricsMaximumFetchLatencyGraphXaxisTitle(String expectedTitle) {
		 
		String actualTitle = page.locator(XaxisTitle(RequestMetricsMaximumFetchLatencyID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateRequestMetricsMaximumFetchLatencyGraphYaxisTitle(String expectedTitle) {
		 
		String actualTitle = page.locator(YaxisTitle(RequestMetricsMaximumFetchLatencyID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateRequestMetricsMaximumFetchLatencyGraphRequestMetricsHeaderTitle(String expectedTitle) {
		 
		String actualTitle = page.locator(HeaderTitle(RequestMetricsMaximumFetchLatencyID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateRequestMetricsMaximumFetchLatencyGraphAvgHeaderTitle(String expectedTitle) {
		 
		String actualTitle = page.locator(AvgHeader(RequestMetricsMaximumFetchLatencyID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateRequestMetricsMaximumFetchLatencyGraphMaxHeaderTitle(String expectedTitle) {
		 
		String actualTitle = page.locator(MaxHeader(RequestMetricsMaximumFetchLatencyID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateRequestMetricsMaximumFetchLatencyGraphRowColor1(String expectedTitle) {
		 
		String actualTitle = page.locator(RowColor1(RequestMetricsMaximumFetchLatencyID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateRequestMetricsMaximumFetchLatencyToolTipTitle() {
		 
		util.validateWidgetToolTips(page, XaxisLines(RequestMetricsMaximumFetchLatencyID),
				ToolTipTitle(RequestMetricsMaximumFetchLatencyID));
	}

	public void validateRequestMetricsMaximumFetchLatencyExpandViewXAxisTitle() {
		 
		util.validateExpandViewTexts(page, XaxisTitle(RequestMetricsMaximumFetchLatencyID),
				Expand(RequestMetricsMaximumFetchLatencyID), expandViewCloseBtn, expandViewXaxisTitle);
	}

	public void validateRequestMetricsMaximumFetchLatencyExpandViewYAxisTitle() {
		 
		util.validateExpandViewTexts(page, YaxisTitle(RequestMetricsMaximumFetchLatencyID),
				Expand(RequestMetricsMaximumFetchLatencyID), expandViewCloseBtn, expandViewYaxisTitle);
	}

	public void validateRequestMetricsMaximumFetchLatencyExpandViewWidgetTitle() {
		 
		util.validateExpandViewTexts(page, getWidgetTitle(RequestMetricsMaximumFetchLatencyID),
				Expand(RequestMetricsMaximumFetchLatencyID), expandViewCloseBtn, expandViewWidgetTitle);
	}

	public void validateRequestMetricsMaximumFetchLatencyExpandViewLegendHeader1() {
		 
		util.validateExpandViewTexts(page, LegendColumn1Title(RequestMetricsMaximumFetchLatencyID),
				Expand(RequestMetricsMaximumFetchLatencyID), expandViewCloseBtn, expandViewLegendColumn1HeaderTitle);
	}

	public void validateRequestMetricsMaximumFetchLatencyExpandViewLegendHeader2() {
		 
		util.validateExpandViewTexts(page, LegendColumn2Title(RequestMetricsMaximumFetchLatencyID),
				Expand(RequestMetricsMaximumFetchLatencyID), expandViewCloseBtn, expandViewLegendColumn2HeaderTitle);
	}

	public void validateRequestMetricsMaximumFetchLatencyExpandViewLegendHeader3() {
		 
		util.validateExpandViewTexts(page, LegendColumn3Title(RequestMetricsMaximumFetchLatencyID),
				Expand(RequestMetricsMaximumFetchLatencyID), expandViewCloseBtn, expandViewLegendColumn3HeaderTitle);
	}

	public void validateRequestMetricsMaximumFetchLatencyExpandViewLegendHeader2InforMessage() {
		util.validateExpandViewTexts(page, LegendColumn2Title(RequestMetricsMaximumFetchLatencyID),
				Expand(RequestMetricsMaximumFetchLatencyID), expandViewCloseBtn,
				expandViewLegendColumnHeader2infoMessage);
	}

	public void validateRequestMetricsMaximumFetchLatencyExpandViewLegendHeader3InforMessage() {
		util.validateExpandViewTexts(page, LegendColumn3Title(RequestMetricsMaximumFetchLatencyID),
				Expand(RequestMetricsMaximumFetchLatencyID), expandViewCloseBtn,
				expandViewLegendColumnHeader3infoMessage);
	}

	public void validateRequestMetricsMaximumFetchLatencyExpandViewZoomIn() {
		 
		util.ExpandViewZoomInBtn(page, expandViewZoomInBtn, Expand(RequestMetricsMaximumFetchLatencyID),
				expandViewCloseBtn, expandViewXaxisValues);
	}

	public void validateRequestMetricsMaximumFetchLatencyExpandViewZoomOut() {
		 
		util.ExpandViewZoomOutBtn(page, expandViewZoomInBtn, Expand(RequestMetricsMaximumFetchLatencyID),
				expandViewCloseBtn, expandViewZoomOutBtn, expandViewXaxisValues);
	}

	public void validateRequestMetricsMaximumFetchLatencyExpandViewWidgetDragDrop() {
		 
		util.ExpandViewWidgetDragDrop(page, Expand(RequestMetricsMaximumFetchLatencyID), expandViewCloseBtn,
				expandViewXaxisLines, expandViewZoomOutBtn, expandViewXaxisValues);
	}

	/**
	 * Connection Metrics Tab
	 */

	public void validateConnectionMetricsTabTitle(String expectedTitle) {
		String actualTitle = page.locator(ConnectionMetricsTab).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void clickOnConnectionMetricsTab() {
		page.locator(ConnectionMetricsTab).click();
		String actualTitle = page.locator("xpath = //div[@class='consumerTabSelector']/child::div[@class][position()=3]").textContent().trim();
		Assert.assertEquals(actualTitle.equalsIgnoreCase("Connection metrics"), true);
	}

//Connection Metrics > Connection Creation Rate Graph

	public void validateConnectionMetricsConnectionCreationRateGraphTitle(String expectedTitle) {
		String actualTitle = page.locator(getWidgetTitle(ConnectionMetricsConnectionCreationRateID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateConnectionMetricsConnectionCreationRateIDZoomInBtn() {
		  
		util.graphZoomIn(page, ZoomIn(ConnectionMetricsConnectionCreationRateID),
				XaxisValues(ConnectionMetricsConnectionCreationRateID));
	}

	public void validateConnectionMetricsConnectionCreationRateIDZoomOutBtn() {
		  
		util.graphZoomOut(page, ZoomIn(ConnectionMetricsConnectionCreationRateID),
				ZoomOut(ConnectionMetricsConnectionCreationRateID), XaxisValues(ConnectionMetricsConnectionCreationRateID));
	}

	public void validateConnectionMetricsConnectionCreationRateXaxisValues() {
		 
		util.validateTheGraphdisplayingTheDataAsPerGivenTimeLines(page,
				XaxisValues(ConnectionMetricsConnectionCreationRateID), calenderView,
				WidgetXValues(XaxisValues(ConnectionMetricsConnectionCreationRateID)));
	}

	public void validateConnectionMetricsConnectionCreationRateGraphXaxisTitle(String expectedTitle) {
		 
		String actualTitle = page.locator(XaxisTitle(ConnectionMetricsConnectionCreationRateID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateConnectionMetricsConnectionCreationRateGraphYaxisTitle(String expectedTitle) {
		 
		String actualTitle = page.locator(YaxisTitle(ConnectionMetricsConnectionCreationRateID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateConnectionMetricsConnectionCreationRateGraphConnectionMetricsHeaderTitle(String expectedTitle) {
		 
		String actualTitle = page.locator(HeaderTitle(ConnectionMetricsConnectionCreationRateID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateConnectionMetricsConnectionCreationRateGraphAvgHeaderTitle(String expectedTitle) {
		 
		String actualTitle = page.locator(AvgHeader(ConnectionMetricsConnectionCreationRateID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateConnectionMetricsConnectionCreationRateGraphMaxHeaderTitle(String expectedTitle) {
		 
		String actualTitle = page.locator(MaxHeader(ConnectionMetricsConnectionCreationRateID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateConnectionMetricsConnectionCreationRateGraphRowColor1(String expectedTitle) {
		 
		String actualTitle = page.locator(RowColor1(ConnectionMetricsConnectionCreationRateID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateConnectionMetricsConnectionCreationRateToolTipTitle() {
		 
		util.validateWidgetToolTips(page, XaxisLines(ConnectionMetricsConnectionCreationRateID),
				ToolTipTitle(ConnectionMetricsConnectionCreationRateID));
	}

	public void validateConnectionMetricsConnectionCreationRateExpandViewXAxisTitle() {
		 
		util.validateExpandViewTexts(page, XaxisTitle(ConnectionMetricsConnectionCreationRateID),
				Expand(ConnectionMetricsConnectionCreationRateID), expandViewCloseBtn, expandViewXaxisTitle);
	}

	public void validateConnectionMetricsConnectionCreationRateExpandViewYAxisTitle() {
		 
		util.validateExpandViewTexts(page, YaxisTitle(ConnectionMetricsConnectionCreationRateID),
				Expand(ConnectionMetricsConnectionCreationRateID), expandViewCloseBtn, expandViewYaxisTitle);
	}

	public void validateConnectionMetricsConnectionCreationRateExpandViewWidgetTitle() {
		 
		util.validateExpandViewTexts(page, getWidgetTitle(ConnectionMetricsConnectionCreationRateID),
				Expand(ConnectionMetricsConnectionCreationRateID), expandViewCloseBtn, expandViewWidgetTitle);
	}

	public void validateConnectionMetricsConnectionCreationRateExpandViewLegendHeader1() {
		 
		util.validateExpandViewTexts(page, LegendColumn1Title(ConnectionMetricsConnectionCreationRateID),
				Expand(ConnectionMetricsConnectionCreationRateID), expandViewCloseBtn,
				expandViewLegendColumn1HeaderTitle);
	}

	public void validateConnectionMetricsConnectionCreationRateExpandViewLegendHeader2() {
		 
		util.validateExpandViewTexts(page, LegendColumn2Title(ConnectionMetricsConnectionCreationRateID),
				Expand(ConnectionMetricsConnectionCreationRateID), expandViewCloseBtn,
				expandViewLegendColumn2HeaderTitle);
	}

	public void validateConnectionMetricsConnectionCreationRateExpandViewLegendHeader3() {
		 
		util.validateExpandViewTexts(page, LegendColumn3Title(ConnectionMetricsConnectionCreationRateID),
				Expand(ConnectionMetricsConnectionCreationRateID), expandViewCloseBtn,
				expandViewLegendColumn3HeaderTitle);
	}

	public void validateConnectionMetricsConnectionCreationRateExpandViewLegendHeader2InforMessage() {
		util.validateExpandViewTexts(page, LegendColumn2Title(ConnectionMetricsConnectionCreationRateID),
				Expand(ConnectionMetricsConnectionCreationRateID), expandViewCloseBtn,
				expandViewLegendColumnHeader2infoMessage);
	}

	public void validateConnectionMetricsConnectionCreationRateExpandViewLegendHeader3InforMessage() {
		util.validateExpandViewTexts(page, LegendColumn3Title(ConnectionMetricsConnectionCreationRateID),
				Expand(ConnectionMetricsConnectionCreationRateID), expandViewCloseBtn,
				expandViewLegendColumnHeader3infoMessage);
	}

	public void validateConnectionMetricsConnectionCreationRateExpandViewZoomIn() {
		 
		util.ExpandViewZoomInBtn(page, expandViewZoomInBtn, Expand(ConnectionMetricsConnectionCreationRateID),
				expandViewCloseBtn, expandViewXaxisValues);
	}

	public void validateConnectionMetricsConnectionCreationRateExpandViewZoomOut() {
		 
		util.ExpandViewZoomOutBtn(page, expandViewZoomInBtn, Expand(ConnectionMetricsConnectionCreationRateID),
				expandViewCloseBtn, expandViewZoomOutBtn, expandViewXaxisValues);
	}

	public void validateConnectionMetricsConnectionCreationRateExpandViewWidgetDragDrop() {
		 
		util.ExpandViewWidgetDragDrop(page, Expand(ConnectionMetricsConnectionCreationRateID), expandViewCloseBtn,
				expandViewXaxisLines, expandViewZoomOutBtn, expandViewXaxisValues);
	}

//Connection Metrics > Connection Close Rate Graph

	public void validateConnectionMetricsConnectionCloseRateGraphTitle(String expectedTitle) {
		 
		String actualTitle = page.locator(getWidgetTitle(ConnectionMetricsConnectionCloseRateID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateConnectionMetricsConnectionCloseRateZoomInBtn() {
		 
		util.graphZoomIn(page, ZoomIn(ConnectionMetricsConnectionCloseRateID), XaxisValues(ConnectionMetricsConnectionCloseRateID));
	}

	public void validateConnectionMetricsConnectionCloseRateZoomOutBtn() {
		 
		util.graphZoomOut(page, ZoomIn(ConnectionMetricsConnectionCloseRateID),
				ZoomOut(ConnectionMetricsConnectionCloseRateID), XaxisValues(ConnectionMetricsConnectionCloseRateID));
	}

	public void validateConnectionMetricsConnectionCloseRateXaxisValues() {
		  
		util.validateTheGraphdisplayingTheDataAsPerGivenTimeLines(page,
				XaxisValues(ConnectionMetricsConnectionCloseRateID), calenderView,
				WidgetXValues(XaxisValues(ConnectionMetricsConnectionCloseRateID)));
	}

	public void validateConnectionMetricsConnectionCloseRateGraphXaxisTitle(String expectedTitle) {
		 
		String actualTitle = page.locator(XaxisTitle(ConnectionMetricsConnectionCloseRateID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateConnectionMetricsConnectionCloseRateGraphYaxisTitle(String expectedTitle) {
		 
		String actualTitle = page.locator(YaxisTitle(ConnectionMetricsConnectionCloseRateID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateConnectionMetricsConnectionCloseRateGraphConnectionMetricsHeaderTitle(String expectedTitle) {
		 
		String actualTitle = page.locator(HeaderTitle(ConnectionMetricsConnectionCloseRateID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateConnectionMetricsConnectionCloseRateGraphAvgHeaderTitle(String expectedTitle) {
		 
		String actualTitle = page.locator(AvgHeader(ConnectionMetricsConnectionCloseRateID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateConnectionMetricsConnectionCloseRateGraphMaxHeaderTitle(String expectedTitle) {
		 
		String actualTitle = page.locator(MaxHeader(ConnectionMetricsConnectionCloseRateID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateConnectionMetricsConnectionCloseRateGraphRowColor1(String expectedTitle) {
		 
		String actualTitle = page.locator(RowColor1(ConnectionMetricsConnectionCloseRateID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateConnectionMetricsConnectionCloseRateToolTipTitle() {
		 
		util.validateWidgetToolTips(page, XaxisLines(ConnectionMetricsConnectionCloseRateID),
				ToolTipTitle(ConnectionMetricsConnectionCloseRateID));
	}

	public void validateConnectionMetricsConnectionCloseRateExpandViewXAxisTitle() {
		 
		util.validateExpandViewTexts(page, XaxisTitle(ConnectionMetricsConnectionCloseRateID),
				Expand(ConnectionMetricsConnectionCloseRateID), expandViewCloseBtn, expandViewXaxisTitle);
	}

	public void validateConnectionMetricsConnectionCloseRateExpandViewYAxisTitle() {
		 
		util.validateExpandViewTexts(page, YaxisTitle(ConnectionMetricsConnectionCloseRateID),
				Expand(ConnectionMetricsConnectionCloseRateID), expandViewCloseBtn, expandViewYaxisTitle);
	}

	public void validateConnectionMetricsConnectionCloseRateExpandViewWidgetTitle() {
		 
		util.validateExpandViewTexts(page, getWidgetTitle(ConnectionMetricsConnectionCloseRateID),
				Expand(ConnectionMetricsConnectionCloseRateID), expandViewCloseBtn, expandViewWidgetTitle);
	}

	public void validateConnectionMetricsConnectionCloseRateExpandViewLegendHeader1() {
		 
		util.validateExpandViewTexts(page, LegendColumn1Title(ConnectionMetricsConnectionCloseRateID),
				Expand(ConnectionMetricsConnectionCloseRateID), expandViewCloseBtn, expandViewLegendColumn1HeaderTitle);
	}

	public void validateConnectionMetricsConnectionCloseRateExpandViewLegendHeader2() {
		 
		util.validateExpandViewTexts(page, LegendColumn2Title(ConnectionMetricsConnectionCloseRateID),
				Expand(ConnectionMetricsConnectionCloseRateID), expandViewCloseBtn, expandViewLegendColumn2HeaderTitle);
	}

	public void validateConnectionMetricsConnectionCloseRateExpandViewLegendHeader3() {
		 
		util.validateExpandViewTexts(page, LegendColumn3Title(ConnectionMetricsConnectionCloseRateID),
				Expand(ConnectionMetricsConnectionCloseRateID), expandViewCloseBtn, expandViewLegendColumn3HeaderTitle);
	}

	public void validateConnectionMetricsConnectionCloseRateExpandViewLegendHeader2InforMessage() {
		util.validateExpandViewTexts(page, LegendColumn2Title(ConnectionMetricsConnectionCloseRateID),
				Expand(ConnectionMetricsConnectionCloseRateID), expandViewCloseBtn,
				expandViewLegendColumnHeader2infoMessage);
	}

	public void validateConnectionMetricsConnectionCloseRateExpandViewLegendHeader3InforMessage() {
		util.validateExpandViewTexts(page, LegendColumn3Title(ConnectionMetricsConnectionCloseRateID),
				Expand(ConnectionMetricsConnectionCloseRateID), expandViewCloseBtn,
				expandViewLegendColumnHeader3infoMessage);
	}

	public void validateConnectionMetricsConnectionCloseRateExpandViewZoomIn() {
		 
		util.ExpandViewZoomInBtn(page, expandViewZoomInBtn, Expand(ConnectionMetricsConnectionCloseRateID),
				expandViewCloseBtn, expandViewXaxisValues);
	}

	public void validateConnectionMetricsConnectionCloseRateExpandViewZoomOut() {
		 
		util.ExpandViewZoomOutBtn(page, expandViewZoomInBtn, Expand(ConnectionMetricsConnectionCloseRateID),
				expandViewCloseBtn, expandViewZoomOutBtn, expandViewXaxisValues);
	}

	public void validateConnectionMetricsConnectionCloseRateExpandViewWidgetDragDrop() {
		 
		util.ExpandViewWidgetDragDrop(page, Expand(ConnectionMetricsConnectionCloseRateID), expandViewCloseBtn,
				expandViewXaxisLines, expandViewZoomOutBtn, expandViewXaxisValues);
	}

//Connection Metrics > IO Wait Ratio Graph

	public void validateConnectionMetricsIOWaitRatioGraphTitle(String expectedTitle) {
		//page.waitForTimeout(2000);
		String actualTitle = page.locator(getWidgetTitle(ConnectionMetricsIOWaitRatioID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateConnectionMetricsIOWaitRatioIDZoomInBtn() {
		  
		util.graphZoomIn(page, ZoomIn(ConnectionMetricsIOWaitRatioID), XaxisValues(ConnectionMetricsIOWaitRatioID));
	}

	public void validateConnectionMetricsIOWaitRatioIDZoomOutBtn() {
		  
		util.graphZoomOut(page, ZoomIn(ConnectionMetricsIOWaitRatioID), ZoomOut(ConnectionMetricsIOWaitRatioID),
				XaxisValues(ConnectionMetricsIOWaitRatioID));
	}

	public void validateConnectionMetricsIOWaitRatioXaxisValues() {
		 
		util.validateTheGraphdisplayingTheDataAsPerGivenTimeLines(page, XaxisValues(ConnectionMetricsIOWaitRatioID),
				calenderView, WidgetXValues(XaxisValues(ConnectionMetricsIOWaitRatioID)));
	}

	public void validateConnectionMetricsIOWaitRatioGraphXaxisTitle(String expectedTitle) {
		 
		String actualTitle = page.locator(XaxisTitle(ConnectionMetricsIOWaitRatioID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateConnectionMetricsIOWaitRatioGraphYaxisTitle(String expectedTitle) {
		 
		String actualTitle = page.locator(YaxisTitle(ConnectionMetricsIOWaitRatioID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateConnectionMetricsIOWaitRatioGraphConnectionMetricsHeaderTitle(String expectedTitle) {
		 
		String actualTitle = page.locator(HeaderTitle(ConnectionMetricsIOWaitRatioID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateConnectionMetricsIOWaitRatioGraphAvgHeaderTitle(String expectedTitle) {
		 
		String actualTitle = page.locator(AvgHeader(ConnectionMetricsIOWaitRatioID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateConnectionMetricsIOWaitRatioGraphMaxHeaderTitle(String expectedTitle) {
		 
		String actualTitle = page.locator(MaxHeader(ConnectionMetricsIOWaitRatioID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateConnectionMetricsIOWaitRatioGraphRowColor1(String expectedTitle) {
		 
		String actualTitle = page.locator(RowColor1(ConnectionMetricsIOWaitRatioID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateConnectionMetricsIOWaitRatioToolTipTitle() {
		 
		util.validateWidgetToolTips(page, XaxisLines(ConnectionMetricsIOWaitRatioID),
				ToolTipTitle(ConnectionMetricsIOWaitRatioID));
	}

	public void validateConnectionMetricsIOWaitRatioExpandViewXAxisTitle() {
		 
		util.validateExpandViewTexts(page, XaxisTitle(ConnectionMetricsIOWaitRatioID),
				Expand(ConnectionMetricsIOWaitRatioID), expandViewCloseBtn, expandViewXaxisTitle);
	}

	public void validateConnectionMetricsIOWaitRatioExpandViewYAxisTitle() {
		 
		util.validateExpandViewTexts(page, YaxisTitle(ConnectionMetricsIOWaitRatioID),
				Expand(ConnectionMetricsIOWaitRatioID), expandViewCloseBtn, expandViewYaxisTitle);
	}

	public void validateConnectionMetricsIOWaitRatioExpandViewWidgetTitle() {
		 
		util.validateExpandViewTexts(page, getWidgetTitle(ConnectionMetricsIOWaitRatioID),
				Expand(ConnectionMetricsIOWaitRatioID), expandViewCloseBtn, expandViewWidgetTitle);
	}

	public void validateConnectionMetricsIOWaitRatioExpandViewLegendHeader1() {
		 
		util.validateExpandViewTexts(page, LegendColumn1Title(ConnectionMetricsIOWaitRatioID),
				Expand(ConnectionMetricsIOWaitRatioID), expandViewCloseBtn, expandViewLegendColumn1HeaderTitle);
	}

	public void validateConnectionMetricsIOWaitRatioExpandViewLegendHeader2() {
		 
		util.validateExpandViewTexts(page, LegendColumn2Title(ConnectionMetricsIOWaitRatioID),
				Expand(ConnectionMetricsIOWaitRatioID), expandViewCloseBtn, expandViewLegendColumn2HeaderTitle);
	}

	public void validateConnectionMetricsIOWaitRatioExpandViewLegendHeader3() {
		 
		util.validateExpandViewTexts(page, LegendColumn3Title(ConnectionMetricsIOWaitRatioID),
				Expand(ConnectionMetricsIOWaitRatioID), expandViewCloseBtn, expandViewLegendColumn3HeaderTitle);
	}

	public void validateConnectionMetricsIOWaitRatioExpandViewLegendHeader2InforMessage() {
		util.validateExpandViewTexts(page, LegendColumn2Title(ConnectionMetricsIOWaitRatioID),
				Expand(ConnectionMetricsIOWaitRatioID), expandViewCloseBtn, expandViewLegendColumnHeader2infoMessage);
	}

	public void validateConnectionMetricsIOWaitRatioExpandViewLegendHeader3InforMessage() {
		util.validateExpandViewTexts(page, LegendColumn3Title(ConnectionMetricsIOWaitRatioID),
				Expand(ConnectionMetricsIOWaitRatioID), expandViewCloseBtn, expandViewLegendColumnHeader3infoMessage);
	}

	public void validateConnectionMetricsIOWaitRatioExpandViewZoomIn() {
		 
		util.ExpandViewZoomInBtn(page, expandViewZoomInBtn, Expand(ConnectionMetricsIOWaitRatioID), expandViewCloseBtn,
				expandViewXaxisValues);
	}

	public void validateConnectionMetricsIOWaitRatioExpandViewZoomOut() {
		 
		util.ExpandViewZoomOutBtn(page, expandViewZoomInBtn, Expand(ConnectionMetricsIOWaitRatioID), expandViewCloseBtn,
				expandViewZoomOutBtn, expandViewXaxisValues);
	}

	public void validateConnectionMetricsIOWaitRatioExpandViewWidgetDragDrop() {
		 
		util.ExpandViewWidgetDragDrop(page, Expand(ConnectionMetricsIOWaitRatioID), expandViewCloseBtn,
				expandViewXaxisLines, expandViewZoomOutBtn, expandViewXaxisValues);
	}

//Connection Metrics > IO Wait Time Average Graph

	public void validateConnectionMetricsIOWaitTimeAverageGraphTitle(String expectedTitle) {
		 
		String actualTitle = page.locator(getWidgetTitle(ConnectionMetricsIOWaitTimeAverageID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateConnectionMetricsIOWaitTimeAverageIDZoomInBtn() {
		 
		util.graphZoomIn(page, ZoomIn(ConnectionMetricsIOWaitTimeAverageID), XaxisValues(ConnectionMetricsIOWaitTimeAverageID));
	}

	public void validateConnectionMetricsIOWaitTimeAverageIDZoomOutBtn() {
		  
		util.graphZoomOut(page, ZoomIn(ConnectionMetricsIOWaitTimeAverageID),
				ZoomOut(ConnectionMetricsIOWaitTimeAverageID), XaxisValues(ConnectionMetricsIOWaitTimeAverageID));
	}

	public void validateConnectionMetricsIOWaitTimeAverageXaxisValues() {
		  
		util.validateTheGraphdisplayingTheDataAsPerGivenTimeLines(page,
				XaxisValues(ConnectionMetricsIOWaitTimeAverageID), calenderView,
				WidgetXValues(XaxisValues(ConnectionMetricsIOWaitTimeAverageID)));
	}

	public void validateConnectionMetricsIOWaitTimeAverageGraphXaxisTitle(String expectedTitle) {
		 
		String actualTitle = page.locator(XaxisTitle(ConnectionMetricsIOWaitTimeAverageID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateConnectionMetricsIOWaitTimeAverageGraphYaxisTitle(String expectedTitle) {
		 
		String actualTitle = page.locator(YaxisTitle(ConnectionMetricsIOWaitTimeAverageID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateConnectionMetricsIOWaitTimeAverageGraphConnectionMetricsHeaderTitle(String expectedTitle) {
		 
		String actualTitle = page.locator(HeaderTitle(ConnectionMetricsIOWaitTimeAverageID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateConnectionMetricsIOWaitTimeAverageGraphAvgHeaderTitle(String expectedTitle) {
		 
		String actualTitle = page.locator(AvgHeader(ConnectionMetricsIOWaitTimeAverageID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateConnectionMetricsIOWaitTimeAverageGraphMaxHeaderTitle(String expectedTitle) {
		 
		String actualTitle = page.locator(MaxHeader(ConnectionMetricsIOWaitTimeAverageID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateConnectionMetricsIOWaitTimeAverageGraphRowColor1(String expectedTitle) {
		 
		String actualTitle = page.locator(RowColor1(ConnectionMetricsIOWaitTimeAverageID)).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateConnectionMetricsIOWaitTimeAverageToolTipTitle() {
		 
		util.validateWidgetToolTips(page, XaxisLines(ConnectionMetricsIOWaitTimeAverageID),
				ToolTipTitle(ConnectionMetricsIOWaitTimeAverageID));
	}

	public void validateConnectionMetricsIOWaitTimeAverageExpandViewXAxisTitle() {
		 
		util.validateExpandViewTexts(page, XaxisTitle(ConnectionMetricsIOWaitTimeAverageID),
				Expand(ConnectionMetricsIOWaitTimeAverageID), expandViewCloseBtn, expandViewXaxisTitle);
	}

	public void validateConnectionMetricsIOWaitTimeAverageExpandViewYAxisTitle() {
		 
		util.validateExpandViewTexts(page, YaxisTitle(ConnectionMetricsIOWaitTimeAverageID),
				Expand(ConnectionMetricsIOWaitTimeAverageID), expandViewCloseBtn, expandViewYaxisTitle);
	}

	public void validateConnectionMetricsIOWaitTimeAverageExpandViewWidgetTitle() {
		 
		util.validateExpandViewTexts(page, getWidgetTitle(ConnectionMetricsIOWaitTimeAverageID),
				Expand(ConnectionMetricsIOWaitTimeAverageID), expandViewCloseBtn, expandViewWidgetTitle);
	}

	public void validateConnectionMetricsIOWaitTimeAverageExpandViewLegendHeader1() {
		 
		util.validateExpandViewTexts(page, LegendColumn1Title(ConnectionMetricsIOWaitTimeAverageID),
				Expand(ConnectionMetricsIOWaitTimeAverageID), expandViewCloseBtn, expandViewLegendColumn1HeaderTitle);
	}

	public void validateConnectionMetricsIOWaitTimeAverageExpandViewLegendHeader2() {
		 
		util.validateExpandViewTexts(page, LegendColumn2Title(ConnectionMetricsIOWaitTimeAverageID),
				Expand(ConnectionMetricsIOWaitTimeAverageID), expandViewCloseBtn, expandViewLegendColumn2HeaderTitle);
	}

	public void validateConnectionMetricsIOWaitTimeAverageExpandViewLegendHeader3() {
		 
		util.validateExpandViewTexts(page, LegendColumn3Title(ConnectionMetricsIOWaitTimeAverageID),
				Expand(ConnectionMetricsIOWaitTimeAverageID), expandViewCloseBtn, expandViewLegendColumn3HeaderTitle);
	}

	public void validateConnectionMetricsIOWaitTimeAverageExpandViewLegendHeader2InforMessage() {
		 
		util.validateExpandViewTexts(page, LegendColumn2Title(ConnectionMetricsIOWaitTimeAverageID),
				Expand(ConnectionMetricsIOWaitTimeAverageID), expandViewCloseBtn,
				expandViewLegendColumnHeader2infoMessage);
	}

	public void validateConnectionMetricsIOWaitTimeAverageExpandViewLegendHeader3InforMessage() {
		 
		util.validateExpandViewTexts(page, LegendColumn3Title(ConnectionMetricsIOWaitTimeAverageID),
				Expand(ConnectionMetricsIOWaitTimeAverageID), expandViewCloseBtn,
				expandViewLegendColumnHeader3infoMessage);
	}

	public void validateConnectionMetricsIOWaitTimeAverageExpandViewZoomIn() {
		 
		util.ExpandViewZoomInBtn(page, expandViewZoomInBtn, Expand(ConnectionMetricsIOWaitTimeAverageID),
				expandViewCloseBtn, expandViewXaxisValues);
	}

	public void validateConnectionMetricsIOWaitTimeAverageExpandViewZoomOut() {
		 
		util.ExpandViewZoomOutBtn(page, expandViewZoomInBtn, Expand(ConnectionMetricsIOWaitTimeAverageID),
				expandViewCloseBtn, expandViewZoomOutBtn, expandViewXaxisValues);
	}

	public void validateConnectionMetricsIOWaitTimeAverageExpandViewWidgetDragDrop() {
		 
		util.ExpandViewWidgetDragDrop(page, Expand(ConnectionMetricsIOWaitTimeAverageID), expandViewCloseBtn,
				expandViewXaxisLines, expandViewZoomOutBtn, expandViewXaxisValues);
	}

	/**
	 * id refers widget locator id
	 * 
	 * @param id
	 * @return
	 */

	private String getWidgetTitle(String id) {
		return "xpath = //div[@id='" + id + "']/ancestor::div[@class='card-body' or @class='chart-body']/preceding-sibling::div[@class='card-header']";
	}

	private String ZoomOut(String id) {
		return "xpath = //div[@id='" + id
				+ "']/ancestor::div[@class='card-body']/preceding-sibling::div/descendant::span[@class='icon-class'][position()=1]";
	}

	private String ZoomIn(String id) {
		return "xpath = //div[@id='" + id
				+ "']/ancestor::div[@class='card-body']/preceding-sibling::div/descendant::span[@class='icon-class'][position()=2]";
	}

	private String XaxisValues(String id) {
		return "xpath = //div[@id='" + id
				+ "']/descendant::*[@class='apexcharts-text apexcharts-xaxis-label apexcharts-xaxis-label']/child::*[name()='tspan' and contains(text(),'-')]";
	}

	private String XaxisLines(String id) {
		return "xpath = //div[@class='consumerTabSelector']/child::div[contains(@class,'Active') and position()=3]/ancestor::div[@class='kafkaConsumerContainer']/descendant::div[@id='" + id + "']/descendant::*[@class='apexcharts-xaxis-tick']";
	}

	private String XaxisTitle(String id) {
		return "xpath = //div[@id='"+id+"']/descendant::*[@class='apexcharts-text apexcharts-xaxis-title-text chart-lables']";
	}

	private String YaxisTitle(String id) {
		return "xpath = //div[@id='"+id+"']/descendant::*[@class='apexcharts-text apexcharts-yaxis-title-text chart-lables']";
		//return "xpath = //div[@class='kafkaTabItem kafkaActiveTab' and contains(.,'Request metrics')]/ancestor::div[@class='kafkaConsumerContainer']/descendant::div[@id='"+id+"']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-yaxis-title-text chart-lables']";
	// //div[@class='kafkaTabItem kafkaActiveTab']/ancestor::div[@class='kafkaConsumerActions']/following-sibling::div/descendant::div[@id='apexchartschart-kafka_consumer_connection_creation_rate']/descendant::*[@class='apexcharts-text apexcharts-yaxis-title-text chart-lables']
	}

	// Headers
	private String HeaderTitle(String id) {
		return "xpath = //div[@id='"+id+"']/ancestor::div[@class='card-body']/descendant::div[@class='header-heading'][position()=1]";
	}

	private String AvgHeader(String id) {
		return "xpath = //div[@id='"+id+"']/ancestor::div[@class='card-body']/descendant::div[@class='header-heading'][position()=2]";
	}

	private String MaxHeader(String id) {
		return "xpath = //div[@id='"+id+"']/ancestor::div[@class='card-body']/descendant::div[@class='header-heading'][position()=3]";
	}

	private String ToolTipTitle(String id) {
		return "xpath = //div[@id='"+id+"']/descendant::div[@class='apexcharts-tooltip-title']";
	}

	// Headers

	private String LegendColumn1Title(String id) {
		return "xpath = //div[@id='" + id
				+ "']/ancestor::div[@class='card-body']/descendant::div[@class='header-heading'][position()=1]";
	}

	private String LegendColumn2Title(String id) {
		return "xpath = //div[@id='" + id
				+ "']/ancestor::div[@class='card-body']/descendant::div[@class='header-heading'][position()=2]";
	}

	private String LegendColumn3Title(String id) {
		return "xpath = //div[@id='" + id
				+ "']/ancestor::div[@class='card-body']/descendant::div[@class='header-heading'][position()=3]";
	}

	// ********************** Expand View Widget Validation
	// ********************************************

	private String Expand(String id) {
		return "xpath = //div[@id='" + id
				+ "']/ancestor::div[@class='card-body']/preceding-sibling::div/descendant::span[@class='icon-class'][position()=3]";
	}

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
	private String expandViewLegendColumnHeader2infoMessage = "xpath = (//div[@class='ant-modal-content']/descendant::div[@class='card crd']/descendant::div[@class='legend']/descendant::div[@class='table-row'])[1]";
	private String expandViewLegendColumnHeader3infoMessage = "xpath = (//div[@class='ant-modal-content']/descendant::div[@class='card crd']/descendant::div[@class='legend']/descendant::div[@class='table-row'])[2]";

	// Colors Reading

	private String PartitionRowColorList(String id) {
		return "xpath = //div[@class='consumerTabSelector']/child::div[contains(@class,'Active') and position()=3]/ancestor::div[@class='kafkaConsumerContainer']/descendant::/div[@id='" + id
				+ "']/ancestor::div[@class='graph']/descendant::div[@class='table-body']/descendant::span[@class='dot']";
	}

	private String RowColor1(String id) {
		return "xpath = //div[@class='consumerTabSelector']/child::div[contains(@class,'Active') and position()=3]/ancestor::div[@class='kafkaConsumerContainer']/descendant::/div[@id='" + id
				+ "']/ancestor::div[@class='graph']/descendant::div[@class='table-body']/descendant::span[@class='dot'][position()=1]";
	}

	private String RowColor2(String id) {
		return "xpath = //div[@class='consumerTabSelector']/child::div[contains(@class,'Active') and position()=3]/ancestor::div[@class='kafkaConsumerContainer']/descendant::/div[@id='" + id
				+ "']/ancestor::div[@class='graph']/descendant::div[@class='table-body']/descendant::span[@class='dot'][position()=2]";
	}
}
