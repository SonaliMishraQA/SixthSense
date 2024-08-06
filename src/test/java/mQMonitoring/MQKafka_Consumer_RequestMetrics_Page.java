package mQMonitoring;


import java.util.ArrayList;
import java.util.List;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;

import genericUtilities.ExcelUtility;
import genericUtilities.GenericMethods;

public class MQKafka_Consumer_RequestMetrics_Page 
{
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

	private String RequestMetricsTab = "xpath = //div[@class='consumerTabSelector']/child::div[@class][position()=2]";

	// Consumer > Request Metrics
	private String RequestMetricsIncomingBytesID = "apexchartschart-kafka_consumer_records_lag";
	private String RequestMetricsOutgoingBytesID = "apexchartschart-kafka_consumer_records_lead";
	private String RequestMetricsAverageFetchLatencyID = "apexchartschart-kafka_consumer_fetch_latency_avg";
	private String RequestMetricsMaximumFetchLatencyID = "apexchartschart-kafka_consumer_fetch_latency_max";
	
	public List<String> WidgetXValues(String XValue) {
		ArrayList<String> xValue = new ArrayList<String>();
		xValue.add(XValue);
		return xValue;
	}

	public MQKafka_Consumer_RequestMetrics_Page(Page page) {
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
	 * Request Metrics Tab
	 */

	public void validateRequestMetricsTabTitle(String expectedTitle) {
		String actualTitle = page.locator(RequestMetricsTab).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void clickOnRequestMetricsTab() {
			page.locator(RequestMetricsTab).click();
			page.waitForLoadState(LoadState.NETWORKIDLE);
			page.waitForTimeout(5000);
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

	
}
