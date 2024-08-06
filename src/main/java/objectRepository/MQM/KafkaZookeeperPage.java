package objectRepository.MQM;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import genericUtilities.ExcelUtility;
import genericUtilities.GenericMethods;

import java.util.ArrayList;
import java.util.List;

import com.microsoft.playwright.options.LoadState;

public class KafkaZookeeperPage 
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
	private String zookeeperTab = "xpath = //div[@class='navtab']/div[@class='item' and position()=5]/child::div";
	private String brokerTitle = "xpath = //div[@class='kafkaZookeeperDropdown']/descendant::div[@class='heading']";
	private String selectNameDropDown = "#btn-arrow-down-kafka-select-zookeeper";
	private String activeTickMark = "xpath = //input[@id='input-search-sel-kafka-select-zookeeper']/parent::div/following-sibling::div/child::div[@class='option']/span/span";
	private String nameSearchResults = "xpath = //input[@id='input-search-sel-kafka-select-zookeeper']/parent::div/following-sibling::div/child::div[@class='option'][1]";
	
		
//Zookeeper disconnect Graph 
	private String zookeeperDisconnectGraphTitle = "xpath = //div[@class='kafkaZookeeperActions']/following-sibling::div//div[.='Zookeeper disconnect ']";
	private String zookeeperDisconnectXaxis = "xpath = //div[.='Zookeeper disconnect ']/following-sibling::div/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-title-text chart-lables']";
	private String zookeeperDisconnectYaxis = "xpath = //div[.='Zookeeper disconnect ']/following-sibling::div/descendant::*[name()='text' and @class='apexcharts-text apexcharts-yaxis-title-text chart-lables']";
	private String zookeeperDisconnectXaxisLine = "xpath = //div[.='Zookeeper disconnect ']/following-sibling::div/descendant::*[name()='line' and @class='apexcharts-xaxis-tick']";
	private String zookeeperDisconnectXaxisValues = "xpath = //div[@id='apexchartschart-kafka_zookeeper_disconnects_per_sec']/descendant::*[name()='tspan' and contains(.,'-')]";
	private String zookeeperDisconnectZoomOut = "xpath = (//div[.='Zookeeper disconnect ']/descendant::span[@class='icon-class'])[position()=1]";
	private String zookeeperDisconnectZoomIn = "xpath = (//div[.='Zookeeper disconnect ']/descendant::span[@class='icon-class'])[position()=2]";
	private String zookeeperDisconnectLegendTitle1 = "xpath = (//div[.='Zookeeper disconnect ']/following-sibling::div/descendant::div[@class='header-heading'])[position()=1]";
	private String zookeeperDisconnectLegendTitle2 = "xpath = (//div[.='Zookeeper disconnect ']/following-sibling::div/descendant::div[@class='header-heading'])[position()=2]";
	private String zookeeperDisconnectLegendTitle3 = "xpath = (//div[.='Zookeeper disconnect ']/following-sibling::div/descendant::div[@class='header-heading'])[position()=3]";
	private String zookeeperDisconnectToolTipTitle = "xpath = //div[.='Zookeeper disconnect ']/following-sibling::div/descendant::div[@class='apexcharts-tooltip-title']";	
			
//Zookeeper connect Graph 
	private String zookeeperConnectGraphTitle = "xpath = //div[@class='kafkaZookeeperActions']/following-sibling::div//div[.='Zookeeper connect ']";
	private String zookeeperConnectXaxis = "xpath = //div[.='Zookeeper connect ']/following-sibling::div/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-title-text chart-lables']";
	private String zookeeperConnectYaxis = "xpath = //div[.='Zookeeper connect ']/following-sibling::div/descendant::*[name()='text' and @class='apexcharts-text apexcharts-yaxis-title-text chart-lables']";
	private String zookeeperConnectXaxisLine = "xpath = //div[.='Zookeeper connect ']/following-sibling::div/descendant::*[name()='line' and @class='apexcharts-xaxis-tick']";
	private String zookeeperConnectXaxisValues = "xpath = //div[@id='apexchartschart-kafka_zookeeper_sync_connects_per_sec']/descendant::*[name()='tspan' and contains(.,'-')]";
	private String zookeeperConnectZoomOut = "xpath = (//div[.='Zookeeper connect ']/descendant::span[@class='icon-class'])[position()=1]";
	private String zookeeperConnectZoomIn = "xpath = (//div[.='Zookeeper connect ']/descendant::span[@class='icon-class'])[position()=2]";
	private String zookeeperConnectLegendTitle1 = "xpath = (//div[.='Zookeeper connect ']/following-sibling::div/descendant::div[@class='header-heading'])[position()=1]";
	private String zookeeperConnectLegendTitle2 = "xpath = (//div[.='Zookeeper connect ']/following-sibling::div/descendant::div[@class='header-heading'])[position()=2]";
	private String zookeeperConnectLegendTitle3 = "xpath = (//div[.='Zookeeper connect ']/following-sibling::div/descendant::div[@class='header-heading'])[position()=3]";
	private String zookeeperConnectToolTipTitle = "xpath = //div[.='Zookeeper connect ']/following-sibling::div/descendant::div[@class='apexcharts-tooltip-title']";	
		
//Zookeeper expire/second Graph 
	private String zookeeperExpirePerSecondGraphTitle = "xpath = //div[@class='kafkaZookeeperActions']/following-sibling::div//div[.='Zookeeper expire/second ']";
	private String zookeeperExpirePerSecondXaxis = "xpath = //div[.='Zookeeper expire/second ']/following-sibling::div/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-title-text chart-lables']";
	private String zookeeperExpirePerSecondYaxis = "xpath = //div[.='Zookeeper expire/second ']/following-sibling::div/descendant::*[name()='text' and @class='apexcharts-text apexcharts-yaxis-title-text chart-lables']";
	private String zookeeperExpirePerSecondXaxisLine = "xpath = //div[.='Zookeeper expire/second ']/following-sibling::div/descendant::*[name()='line' and @class='apexcharts-xaxis-tick']";
	private String zookeeperExpirePerSecondXaxisValues = "xpath = //div[@id='apexchartschart-kafka_zookeeper_expires_per_sec']/descendant::*[name()='tspan' and contains(.,'-')]";
	private String zookeeperExpirePerSecondZoomOut = "xpath = (//div[.='Zookeeper expire/second ']/descendant::span[@class='icon-class'])[position()=1]";
	private String zookeeperExpirePerSecondZoomIn = "xpath = (//div[.='Zookeeper expire/second ']/descendant::span[@class='icon-class'])[position()=2]";
	private String zookeeperExpirePerSecondLegendTitle1 = "xpath = (//div[.='Zookeeper expire/second ']/following-sibling::div/descendant::div[@class='header-heading'])[position()=1]";
	private String zookeeperExpirePerSecondLegendTitle2 = "xpath = (//div[.='Zookeeper expire/second ']/following-sibling::div/descendant::div[@class='header-heading'])[position()=2]";
	private String zookeeperExpirePerSecondLegendTitle3 = "xpath = (//div[.='Zookeeper expire/second ']/following-sibling::div/descendant::div[@class='header-heading'])[position()=3]";
	private String zookeeperExpirePerSecondToolTipTitle = "xpath = //div[.='Zookeeper expire/second ']/following-sibling::div/descendant::div[@class='apexcharts-tooltip-title']";
		
//Zookeeper auth failure Graph 
	private String zookeeperAuthFailureGraphTitle = "xpath = //div[@class='kafkaZookeeperActions']/following-sibling::div//div[.='Zookeeper auth failure ']";
	private String zookeeperAuthFailureXaxis = "xpath = //div[.='Zookeeper auth failure ']/following-sibling::div/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-title-text chart-lables']";
	private String zookeeperAuthFailureYaxis = "xpath = //div[.='Zookeeper auth failure ']/following-sibling::div/descendant::*[name()='text' and @class='apexcharts-text apexcharts-yaxis-title-text chart-lables']";
	private String zookeeperAuthFailureXaxisLine = "xpath = //div[.='Zookeeper auth failure ']/following-sibling::div/descendant::*[name()='line' and @class='apexcharts-xaxis-tick']";
	private String zookeeperAuthFailureXaxisValues = "xpath = //div[@id='apexchartschart-kafka_zookeeper_auth_failures_per_sec']/descendant::*[name()='tspan' and contains(.,'-')]";
	private String zookeeperAuthFailureZoomOut = "xpath = (//div[.='Zookeeper auth failure ']/descendant::span[@class='icon-class'])[position()=1]";
	private String zookeeperAuthFailureZoomIn = "xpath = (//div[.='Zookeeper auth failure ']/descendant::span[@class='icon-class'])[position()=2]";
	private String zookeeperAuthFailureLegendTitle1 = "xpath = (//div[.='Zookeeper auth failure ']/following-sibling::div/descendant::div[@class='header-heading'])[position()=1]";
	private String zookeeperAuthFailureLegendTitle2 = "xpath = (//div[.='Zookeeper auth failure ']/following-sibling::div/descendant::div[@class='header-heading'])[position()=2]";
	private String zookeeperAuthFailureLegendTitle3 = "xpath = (//div[.='Zookeeper auth failure ']/following-sibling::div/descendant::div[@class='header-heading'])[position()=3]";
	private String zookeeperAuthFailureToolTipTitle = "xpath = //div[.='Zookeeper auth failure ']/following-sibling::div/descendant::div[@class='apexcharts-tooltip-title']";
		
//Zookeeper read only connect Graph 
	private String zookeeperReadOnlyConnectGraphTitle = "xpath = //div[@class='kafkaZookeeperActions']/following-sibling::div//div[.='Zookeeper read only connect ']";
	private String zookeeperReadOnlyConnectXaxis = "xpath = //div[.='Zookeeper read only connect ']/following-sibling::div/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-title-text chart-lables']";
	private String zookeeperReadOnlyConnectYaxis = "xpath = //div[.='Zookeeper read only connect ']/following-sibling::div/descendant::*[name()='text' and @class='apexcharts-text apexcharts-yaxis-title-text chart-lables']";
	private String zookeeperReadOnlyConnectXaxisLine = "xpath = //div[.='Zookeeper read only connect ']/following-sibling::div/descendant::*[name()='line' and @class='apexcharts-xaxis-tick']";
	private String zookeeperReadOnlyConnectXaxisValues = "xpath = //div[@id='apexchartschart-kafka_zookeeper_readonly_connects_per_sec']/descendant::*[name()='tspan' and contains(.,'-')]";
	private String zookeeperReadOnlyConnectZoomOut = "xpath = (//div[.='Zookeeper read only connect ']/descendant::span[@class='icon-class'])[position()=1]";
	private String zookeeperReadOnlyConnectZoomIn = "xpath = (//div[.='Zookeeper read only connect ']/descendant::span[@class='icon-class'])[position()=2]";
	private String zookeeperReadOnlyConnectLegendTitle1 = "xpath = (//div[.='Zookeeper read only connect ']/following-sibling::div/descendant::div[@class='header-heading'])[position()=1]";
	private String zookeeperReadOnlyConnectLegendTitle2 = "xpath = (//div[.='Zookeeper read only connect ']/following-sibling::div/descendant::div[@class='header-heading'])[position()=2]";
	private String zookeeperReadOnlyConnectLegendTitle3 = "xpath = (//div[.='Zookeeper read only connect ']/following-sibling::div/descendant::div[@class='header-heading'])[position()=3]";
	private String zookeeperReadOnlyConnectToolTipTitle = "xpath = //div[.='Zookeeper read only connect ']/following-sibling::div/descendant::div[@class='apexcharts-tooltip-title']";
		
//Zookeeper SASL authentication Graph 
	private String zookeeperSASLAuthenticationGraphTitle = "xpath = //div[@class='kafkaZookeeperActions']/following-sibling::div//div[.='Zookeeper SASL authentication ']";
	private String zookeeperSASLAuthenticationXaxis = "xpath = //div[.='Zookeeper SASL authentication ']/following-sibling::div/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-title-text chart-lables']";
	private String zookeeperSASLAuthenticationYaxis = "xpath = //div[.='Zookeeper SASL authentication ']/following-sibling::div/descendant::*[name()='text' and @class='apexcharts-text apexcharts-yaxis-title-text chart-lables']";
	private String zookeeperSASLAuthenticationXaxisLine = "xpath = //div[.='Zookeeper SASL authentication ']/following-sibling::div/descendant::*[name()='line' and @class='apexcharts-xaxis-tick']";
	private String zookeeperSASLAuthenticationXaxisValues = "xpath = //div[@id='apexchartschart-kafka_zookeeper_sasl_authentications_per_sec']/descendant::*[name()='tspan' and contains(.,'-')]";
	private String zookeeperSASLAuthenticationZoomOut = "xpath = (//div[.='Zookeeper SASL authentication ']/descendant::span[@class='icon-class'])[position()=1]";
	private String zookeeperSASLAuthenticationZoomIn = "xpath = (//div[.='Zookeeper SASL authentication ']/descendant::span[@class='icon-class'])[position()=2]";
	private String zookeeperSASLAuthenticationLegendTitle1 = "xpath = (//div[.='Zookeeper SASL authentication ']/following-sibling::div/descendant::div[@class='header-heading'])[position()=1]";
	private String zookeeperSASLAuthenticationLegendTitle2 = "xpath = (//div[.='Zookeeper SASL authentication ']/following-sibling::div/descendant::div[@class='header-heading'])[position()=2]";
	private String zookeeperSASLAuthenticationLegendTitle3 = "xpath = (//div[.='Zookeeper SASL authentication ']/following-sibling::div/descendant::div[@class='header-heading'])[position()=3]";
	private String zookeeperSASLAuthenticationToolTipTitle = "xpath = //div[.='Zookeeper SASL authentication ']/following-sibling::div/descendant::div[@class='apexcharts-tooltip-title']";
		
//Expand Button
	private String zookeeperDisconnectExpand = "xpath = (//div[.='Zookeeper disconnect ']/descendant::span[@class='icon-class'])[position()=3]";
	private String zookeeperConnectExpand = "xpath = (//div[.='Zookeeper connect ']/descendant::span[@class='icon-class'])[position()=3]";	
	private String zookeeperExpirePerSecondExpand = "xpath = (//div[.='Zookeeper expire/second ']/descendant::span[@class='icon-class'])[position()=3]";
	private String zookeeperAuthFailureExpand = "xpath = (//div[.='Zookeeper auth failure ']/descendant::span[@class='icon-class'])[position()=3]";
	private String zookeeperReadOnlyConnectExpand = "xpath = (//div[.='Zookeeper read only connect ']/descendant::span[@class='icon-class'])[position()=3]";
	private String zookeeperSASLAuthenticationExpand = "xpath = (//div[.='Zookeeper SASL authentication ']/descendant::span[@class='icon-class'])[position()=3]";

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
	
	public KafkaZookeeperPage(Page page) {
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
	 
	public void navigateToZookeeperTab() {
		page.locator(zookeeperTab).click();
		page.waitForLoadState(LoadState.NETWORKIDLE);
	}

	public void validateZookeeperTitle(String expectedTitle) {
		String actualTitle = page.locator(zookeeperTab).textContent().trim();
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
 * Zookeeper Disconnect Graph
 */

	public void validateZookeeperDisconnectGraphTitle(String expectedTitle) {		  
		String actualTitle = page.locator(zookeeperDisconnectGraphTitle).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateZookeeperDisconnectZoomInBtn() {		  
		util.graphZoomIn(page, zookeeperDisconnectZoomIn, zookeeperDisconnectXaxisValues);
	}

	public void validateZookeeperDisconnectZoomOutBtn() {
		util.graphZoomOut(page, zookeeperDisconnectZoomIn, zookeeperDisconnectZoomOut, zookeeperDisconnectXaxisValues);
	}

	public void validateZookeeperDisconnectGraphXaxisTitle(String expectedTitle) {	 
		String actualTitle = page.locator(zookeeperDisconnectXaxis).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateZookeeperDisconnectGraphYaxisTitle(String expectedTitle) {	 
		String actualTitle = page.locator(zookeeperDisconnectYaxis).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateZookeeperDisconnectGraphLegendTitle1(String expectedTitle) {
		String actualTitle = page.locator(zookeeperDisconnectLegendTitle1).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateZookeeperDisconnectGraphLegendTitle2(String expectedTitle) {	 
		String actualTitle = page.locator(zookeeperDisconnectLegendTitle2).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateZookeeperDisconnectGraphLegendTitle3(String expectedTitle) {	 
		String actualTitle = page.locator(zookeeperDisconnectLegendTitle3).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateZookeeperDisconnectToolTipTitle() {	 
		util.validateWidgetToolTips(page, zookeeperDisconnectXaxisLine, zookeeperDisconnectToolTipTitle);
	}

	public void validateZookeeperDisconnectDragAndDrop() {
		util.graphZoomInByDragAndDrop(page, zookeeperDisconnectXaxisLine, zookeeperDisconnectZoomOut, zookeeperDisconnectXaxisValues);
	}
	public void validateZookeeperDisconnectExpandViewXAxisTitle() { 
		util.validateExpandViewTexts(page, zookeeperDisconnectXaxis, zookeeperDisconnectExpand, expandViewCloseBtn, expandViewXaxisTitle);
	}

	public void validateZookeeperDisconnectExpandViewYAxisTitle() {
		util.validateExpandViewTexts(page, zookeeperDisconnectYaxis, zookeeperDisconnectExpand, expandViewCloseBtn, expandViewYaxisTitle);
	}

	public void validateZookeeperDisconnectExpandViewWidgetTitle() {
		util.validateExpandViewTexts(page, zookeeperDisconnectGraphTitle, zookeeperDisconnectExpand, expandViewCloseBtn, expandViewWidgetTitle);
	}

	public void validateZookeeperDisconnectExpandViewLegendHeader1() {	 
		util.validateExpandViewTexts(page, zookeeperDisconnectLegendTitle1, zookeeperDisconnectExpand, expandViewCloseBtn, expandViewLegendColumn1HeaderTitle);
	}

	public void validateZookeeperDisconnectExpandViewLegendHeader2() {	 
		util.validateExpandViewTexts(page, zookeeperDisconnectLegendTitle2 ,zookeeperDisconnectExpand, expandViewCloseBtn, expandViewLegendColumn2HeaderTitle);
	}

	public void validateZookeeperDisconnectExpandViewLegendHeader3() {	 
		util.validateExpandViewTexts(page, zookeeperDisconnectLegendTitle3 ,zookeeperDisconnectExpand, expandViewCloseBtn, expandViewLegendColumn3HeaderTitle);
	}

	public void validateZookeeperDisconnectExpandViewZoomIn() {
		util.ExpandViewZoomInBtn(page, expandViewZoomInBtn, zookeeperDisconnectExpand, expandViewCloseBtn, expandViewXaxisValues);
	}

	public void validateZookeeperDisconnectExpandViewZoomOut() {
		util.ExpandViewZoomOutBtn(page, expandViewZoomInBtn, zookeeperDisconnectExpand, expandViewCloseBtn, expandViewZoomOutBtn, expandViewXaxisValues);
	}

	public void validateZookeeperDisconnectExpandViewWidgetDragDrop() {
		util.ExpandViewWidgetDragDrop(page, zookeeperDisconnectExpand, expandViewCloseBtn, expandViewXaxisLines, expandViewZoomOutBtn, expandViewXaxisValues);
	}
	
	/*
 * Zookeeper Connect Graph
 */

	public void validateZookeeperConnectGraphTitle(String expectedTitle) {		  
		String actualTitle = page.locator(zookeeperConnectGraphTitle).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateZookeeperConnectZoomInBtn() {		  
		util.graphZoomIn(page, zookeeperConnectZoomIn, zookeeperConnectXaxisValues);
	}

	public void validateZookeeperConnectZoomOutBtn() {
		util.graphZoomOut(page, zookeeperConnectZoomIn, zookeeperConnectZoomOut, zookeeperConnectXaxisValues);
	}

	public void validateZookeeperConnectGraphXaxisTitle(String expectedTitle) {	 
		String actualTitle = page.locator(zookeeperConnectXaxis).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateZookeeperConnectGraphYaxisTitle(String expectedTitle) {	 
		String actualTitle = page.locator(zookeeperConnectYaxis).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateZookeeperConnectGraphLegendTitle1(String expectedTitle) {
		String actualTitle = page.locator(zookeeperConnectLegendTitle1).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateZookeeperConnectGraphLegendTitle2(String expectedTitle) {	 
		String actualTitle = page.locator(zookeeperConnectLegendTitle2).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateZookeeperConnectGraphLegendTitle3(String expectedTitle) {	 
		String actualTitle = page.locator(zookeeperConnectLegendTitle3).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateZookeeperConnectToolTipTitle() {	 
		util.validateWidgetToolTips(page, zookeeperConnectXaxisLine, zookeeperConnectToolTipTitle);
	}

	public void validateZookeeperConnectDragAndDrop() {
		util.graphZoomInByDragAndDrop(page, zookeeperConnectXaxisLine, zookeeperConnectZoomOut, zookeeperConnectXaxisValues);
	}
	public void validateZookeeperConnectExpandViewXAxisTitle() { 
		util.validateExpandViewTexts(page, zookeeperConnectXaxis, zookeeperConnectExpand, expandViewCloseBtn, expandViewXaxisTitle);
	}

	public void validateZookeeperConnectExpandViewYAxisTitle() {
		util.validateExpandViewTexts(page, zookeeperConnectYaxis, zookeeperConnectExpand, expandViewCloseBtn, expandViewYaxisTitle);
	}

	public void validateZookeeperConnectExpandViewWidgetTitle() {
		util.validateExpandViewTexts(page, zookeeperConnectGraphTitle, zookeeperConnectExpand, expandViewCloseBtn, expandViewWidgetTitle);
	}

	public void validateZookeeperConnectExpandViewLegendHeader1() {	 
		util.validateExpandViewTexts(page, zookeeperConnectLegendTitle1, zookeeperConnectExpand, expandViewCloseBtn, expandViewLegendColumn1HeaderTitle);
	}

	public void validateZookeeperConnectExpandViewLegendHeader2() {	 
		util.validateExpandViewTexts(page, zookeeperConnectLegendTitle2 ,zookeeperConnectExpand, expandViewCloseBtn, expandViewLegendColumn2HeaderTitle);
	}

	public void validateZookeeperConnectExpandViewLegendHeader3() {	 
		util.validateExpandViewTexts(page, zookeeperConnectLegendTitle3 ,zookeeperConnectExpand, expandViewCloseBtn, expandViewLegendColumn3HeaderTitle);
	}

	public void validateZookeeperConnectExpandViewZoomIn() {
		util.ExpandViewZoomInBtn(page, expandViewZoomInBtn, zookeeperConnectExpand, expandViewCloseBtn, expandViewXaxisValues);
	}

	public void validateZookeeperConnectExpandViewZoomOut() {
		util.ExpandViewZoomOutBtn(page, expandViewZoomInBtn, zookeeperConnectExpand, expandViewCloseBtn, expandViewZoomOutBtn, expandViewXaxisValues);
	}

	public void validateZookeeperConnectExpandViewWidgetDragDrop() {
		util.ExpandViewWidgetDragDrop(page, zookeeperConnectExpand, expandViewCloseBtn, expandViewXaxisLines, expandViewZoomOutBtn, expandViewXaxisValues);
	}
	
/*
 * Zookeeper ExpirePerSecond Graph
 */

	public void validateZookeeperExpirePerSecondGraphTitle(String expectedTitle) {		  
		String actualTitle = page.locator(zookeeperExpirePerSecondGraphTitle).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateZookeeperExpirePerSecondZoomInBtn() {		  
		util.graphZoomIn(page, zookeeperExpirePerSecondZoomIn, zookeeperExpirePerSecondXaxisValues);
	}

	public void validateZookeeperExpirePerSecondZoomOutBtn() {
		util.graphZoomOut(page, zookeeperExpirePerSecondZoomIn, zookeeperExpirePerSecondZoomOut, zookeeperExpirePerSecondXaxisValues);
	}

	public void validateZookeeperExpirePerSecondGraphXaxisTitle(String expectedTitle) {	 
		String actualTitle = page.locator(zookeeperExpirePerSecondXaxis).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateZookeeperExpirePerSecondGraphYaxisTitle(String expectedTitle) {	 
		String actualTitle = page.locator(zookeeperExpirePerSecondYaxis).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateZookeeperExpirePerSecondGraphLegendTitle1(String expectedTitle) {
		String actualTitle = page.locator(zookeeperExpirePerSecondLegendTitle1).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateZookeeperExpirePerSecondGraphLegendTitle2(String expectedTitle) {	 
		String actualTitle = page.locator(zookeeperExpirePerSecondLegendTitle2).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateZookeeperExpirePerSecondGraphLegendTitle3(String expectedTitle) {	 
		String actualTitle = page.locator(zookeeperExpirePerSecondLegendTitle3).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateZookeeperExpirePerSecondToolTipTitle() {	 
		util.validateWidgetToolTips(page, zookeeperExpirePerSecondXaxisLine, zookeeperExpirePerSecondToolTipTitle);
	}

	public void validateZookeeperExpirePerSecondDragAndDrop() {
		util.graphZoomInByDragAndDrop(page, zookeeperExpirePerSecondXaxisLine, zookeeperExpirePerSecondZoomOut, zookeeperExpirePerSecondXaxisValues);
	}
	public void validateZookeeperExpirePerSecondExpandViewXAxisTitle() { 
		util.validateExpandViewTexts(page, zookeeperExpirePerSecondXaxis, zookeeperExpirePerSecondExpand, expandViewCloseBtn, expandViewXaxisTitle);
	}

	public void validateZookeeperExpirePerSecondExpandViewYAxisTitle() {
		util.validateExpandViewTexts(page, zookeeperExpirePerSecondYaxis, zookeeperExpirePerSecondExpand, expandViewCloseBtn, expandViewYaxisTitle);
	}

	public void validateZookeeperExpirePerSecondExpandViewWidgetTitle() {
		util.validateExpandViewTexts(page, zookeeperExpirePerSecondGraphTitle, zookeeperExpirePerSecondExpand, expandViewCloseBtn, expandViewWidgetTitle);
	}

	public void validateZookeeperExpirePerSecondExpandViewLegendHeader1() {	 
		util.validateExpandViewTexts(page, zookeeperExpirePerSecondLegendTitle1, zookeeperExpirePerSecondExpand, expandViewCloseBtn, expandViewLegendColumn1HeaderTitle);
	}

	public void validateZookeeperExpirePerSecondExpandViewLegendHeader2() {	 
		util.validateExpandViewTexts(page, zookeeperExpirePerSecondLegendTitle2 ,zookeeperExpirePerSecondExpand, expandViewCloseBtn, expandViewLegendColumn2HeaderTitle);
	}

	public void validateZookeeperExpirePerSecondExpandViewLegendHeader3() {	 
		util.validateExpandViewTexts(page, zookeeperExpirePerSecondLegendTitle3 ,zookeeperExpirePerSecondExpand, expandViewCloseBtn, expandViewLegendColumn3HeaderTitle);
	}

	public void validateZookeeperExpirePerSecondExpandViewZoomIn() {
		util.ExpandViewZoomInBtn(page, expandViewZoomInBtn, zookeeperExpirePerSecondExpand, expandViewCloseBtn, expandViewXaxisValues);
	}

	public void validateZookeeperExpirePerSecondExpandViewZoomOut() {
		util.ExpandViewZoomOutBtn(page, expandViewZoomInBtn, zookeeperExpirePerSecondExpand, expandViewCloseBtn, expandViewZoomOutBtn, expandViewXaxisValues);
	}

	public void validateZookeeperExpirePerSecondExpandViewWidgetDragDrop() {
		util.ExpandViewWidgetDragDrop(page, zookeeperExpirePerSecondExpand, expandViewCloseBtn, expandViewXaxisLines, expandViewZoomOutBtn, expandViewXaxisValues);
	}
	
	
/*
 * Zookeeper Auth Failure Graph
 */

	public void validateZookeeperAuthFailureGraphTitle(String expectedTitle) {		  
		String actualTitle = page.locator(zookeeperAuthFailureGraphTitle).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateZookeeperAuthFailureZoomInBtn() {		  
		util.graphZoomIn(page, zookeeperAuthFailureZoomIn, zookeeperAuthFailureXaxisValues);
	}

	public void validateZookeeperAuthFailureZoomOutBtn() {
		util.graphZoomOut(page, zookeeperAuthFailureZoomIn, zookeeperAuthFailureZoomOut, zookeeperAuthFailureXaxisValues);
	}

	public void validateZookeeperAuthFailureGraphXaxisTitle(String expectedTitle) {	 
		String actualTitle = page.locator(zookeeperAuthFailureXaxis).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateZookeeperAuthFailureGraphYaxisTitle(String expectedTitle) {	 
		String actualTitle = page.locator(zookeeperAuthFailureYaxis).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateZookeeperAuthFailureGraphLegendTitle1(String expectedTitle) {
		String actualTitle = page.locator(zookeeperAuthFailureLegendTitle1).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateZookeeperAuthFailureGraphLegendTitle2(String expectedTitle) {	 
		String actualTitle = page.locator(zookeeperAuthFailureLegendTitle2).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateZookeeperAuthFailureGraphLegendTitle3(String expectedTitle) {	 
		String actualTitle = page.locator(zookeeperAuthFailureLegendTitle3).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateZookeeperAuthFailureToolTipTitle() {	 
		util.validateWidgetToolTips(page, zookeeperAuthFailureXaxisLine, zookeeperAuthFailureToolTipTitle);
	}

	public void validateZookeeperAuthFailureDragAndDrop() {
		util.graphZoomInByDragAndDrop(page, zookeeperAuthFailureXaxisLine, zookeeperAuthFailureZoomOut, zookeeperAuthFailureXaxisValues);
	}
	public void validateZookeeperAuthFailureExpandViewXAxisTitle() { 
		util.validateExpandViewTexts(page, zookeeperAuthFailureXaxis, zookeeperAuthFailureExpand, expandViewCloseBtn, expandViewXaxisTitle);
	}

	public void validateZookeeperAuthFailureExpandViewYAxisTitle() {
		util.validateExpandViewTexts(page, zookeeperAuthFailureYaxis, zookeeperAuthFailureExpand, expandViewCloseBtn, expandViewYaxisTitle);
	}

	public void validateZookeeperAuthFailureExpandViewWidgetTitle() {
		util.validateExpandViewTexts(page, zookeeperAuthFailureGraphTitle, zookeeperAuthFailureExpand, expandViewCloseBtn, expandViewWidgetTitle);
	}

	public void validateZookeeperAuthFailureExpandViewLegendHeader1() {	 
		util.validateExpandViewTexts(page, zookeeperAuthFailureLegendTitle1, zookeeperAuthFailureExpand, expandViewCloseBtn, expandViewLegendColumn1HeaderTitle);
	}

	public void validateZookeeperAuthFailureExpandViewLegendHeader2() {	 
		util.validateExpandViewTexts(page, zookeeperAuthFailureLegendTitle2 ,zookeeperAuthFailureExpand, expandViewCloseBtn, expandViewLegendColumn2HeaderTitle);
	}

	public void validateZookeeperAuthFailureExpandViewLegendHeader3() {	 
		util.validateExpandViewTexts(page, zookeeperAuthFailureLegendTitle3 ,zookeeperAuthFailureExpand, expandViewCloseBtn, expandViewLegendColumn3HeaderTitle);
	}

	public void validateZookeeperAuthFailureExpandViewZoomIn() {
		util.ExpandViewZoomInBtn(page, expandViewZoomInBtn, zookeeperAuthFailureExpand, expandViewCloseBtn, expandViewXaxisValues);
	}

	public void validateZookeeperAuthFailureExpandViewZoomOut() {
		util.ExpandViewZoomOutBtn(page, expandViewZoomInBtn, zookeeperAuthFailureExpand, expandViewCloseBtn, expandViewZoomOutBtn, expandViewXaxisValues);
	}

	public void validateZookeeperAuthFailureExpandViewWidgetDragDrop() {
		util.ExpandViewWidgetDragDrop(page, zookeeperAuthFailureExpand, expandViewCloseBtn, expandViewXaxisLines, expandViewZoomOutBtn, expandViewXaxisValues);
	}
	
/*
 * Zookeeper Read Only Connect Graph
 */

	public void validateZookeeperReadOnlyConnectGraphTitle(String expectedTitle) {		  
		String actualTitle = page.locator(zookeeperReadOnlyConnectGraphTitle).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateZookeeperReadOnlyConnectZoomInBtn() {		  
		util.graphZoomIn(page, zookeeperReadOnlyConnectZoomIn, zookeeperReadOnlyConnectXaxisValues);
	}

	public void validateZookeeperReadOnlyConnectZoomOutBtn() {
		util.graphZoomOut(page, zookeeperReadOnlyConnectZoomIn, zookeeperReadOnlyConnectZoomOut, zookeeperReadOnlyConnectXaxisValues);
	}

	public void validateZookeeperReadOnlyConnectGraphXaxisTitle(String expectedTitle) {	 
		String actualTitle = page.locator(zookeeperReadOnlyConnectXaxis).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateZookeeperReadOnlyConnectGraphYaxisTitle(String expectedTitle) {	 
		String actualTitle = page.locator(zookeeperReadOnlyConnectYaxis).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateZookeeperReadOnlyConnectGraphLegendTitle1(String expectedTitle) {
		String actualTitle = page.locator(zookeeperReadOnlyConnectLegendTitle1).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateZookeeperReadOnlyConnectGraphLegendTitle2(String expectedTitle) {	 
		String actualTitle = page.locator(zookeeperReadOnlyConnectLegendTitle2).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateZookeeperReadOnlyConnectGraphLegendTitle3(String expectedTitle) {	 
		String actualTitle = page.locator(zookeeperReadOnlyConnectLegendTitle3).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateZookeeperReadOnlyConnectToolTipTitle() {	 
		util.validateWidgetToolTips(page, zookeeperReadOnlyConnectXaxisLine, zookeeperReadOnlyConnectToolTipTitle);
	}

	public void validateZookeeperReadOnlyConnectDragAndDrop() {
		util.graphZoomInByDragAndDrop(page, zookeeperReadOnlyConnectXaxisLine, zookeeperReadOnlyConnectZoomOut, zookeeperReadOnlyConnectXaxisValues);
	}
	public void validateZookeeperReadOnlyConnectExpandViewXAxisTitle() { 
		util.validateExpandViewTexts(page, zookeeperReadOnlyConnectXaxis, zookeeperReadOnlyConnectExpand, expandViewCloseBtn, expandViewXaxisTitle);
	}

	public void validateZookeeperReadOnlyConnectExpandViewYAxisTitle() {
		util.validateExpandViewTexts(page, zookeeperReadOnlyConnectYaxis, zookeeperReadOnlyConnectExpand, expandViewCloseBtn, expandViewYaxisTitle);
	}

	public void validateZookeeperReadOnlyConnectExpandViewWidgetTitle() {
		util.validateExpandViewTexts(page, zookeeperReadOnlyConnectGraphTitle, zookeeperReadOnlyConnectExpand, expandViewCloseBtn, expandViewWidgetTitle);
	}

	public void validateZookeeperReadOnlyConnectExpandViewLegendHeader1() {	 
		util.validateExpandViewTexts(page, zookeeperReadOnlyConnectLegendTitle1, zookeeperReadOnlyConnectExpand, expandViewCloseBtn, expandViewLegendColumn1HeaderTitle);
	}

	public void validateZookeeperReadOnlyConnectExpandViewLegendHeader2() {	 
		util.validateExpandViewTexts(page, zookeeperReadOnlyConnectLegendTitle2 ,zookeeperReadOnlyConnectExpand, expandViewCloseBtn, expandViewLegendColumn2HeaderTitle);
	}

	public void validateZookeeperReadOnlyConnectExpandViewLegendHeader3() {	 
		util.validateExpandViewTexts(page, zookeeperReadOnlyConnectLegendTitle3 ,zookeeperReadOnlyConnectExpand, expandViewCloseBtn, expandViewLegendColumn3HeaderTitle);
	}

	public void validateZookeeperReadOnlyConnectExpandViewZoomIn() {
		util.ExpandViewZoomInBtn(page, expandViewZoomInBtn, zookeeperReadOnlyConnectExpand, expandViewCloseBtn, expandViewXaxisValues);
	}

	public void validateZookeeperReadOnlyConnectExpandViewZoomOut() {
		util.ExpandViewZoomOutBtn(page, expandViewZoomInBtn, zookeeperReadOnlyConnectExpand, expandViewCloseBtn, expandViewZoomOutBtn, expandViewXaxisValues);
	}

	public void validateZookeeperReadOnlyConnectExpandViewWidgetDragDrop() {
		util.ExpandViewWidgetDragDrop(page, zookeeperReadOnlyConnectExpand, expandViewCloseBtn, expandViewXaxisLines, expandViewZoomOutBtn, expandViewXaxisValues);
	}
	
/*
 * Zookeeper SASL Authentication Graph
 */

	public void validateZookeeperSASLAuthenticationGraphTitle(String expectedTitle) {		  
		String actualTitle = page.locator(zookeeperSASLAuthenticationGraphTitle).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateZookeeperSASLAuthenticationZoomInBtn() {		  
		util.graphZoomIn(page, zookeeperSASLAuthenticationZoomIn, zookeeperSASLAuthenticationXaxisValues);
	}

	public void validateZookeeperSASLAuthenticationZoomOutBtn() {
		util.graphZoomOut(page, zookeeperSASLAuthenticationZoomIn, zookeeperSASLAuthenticationZoomOut, zookeeperSASLAuthenticationXaxisValues);
	}

	public void validateZookeeperSASLAuthenticationGraphXaxisTitle(String expectedTitle) {	 
		String actualTitle = page.locator(zookeeperSASLAuthenticationXaxis).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateZookeeperSASLAuthenticationGraphYaxisTitle(String expectedTitle) {	 
		String actualTitle = page.locator(zookeeperSASLAuthenticationYaxis).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateZookeeperSASLAuthenticationGraphLegendTitle1(String expectedTitle) {
		String actualTitle = page.locator(zookeeperSASLAuthenticationLegendTitle1).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateZookeeperSASLAuthenticationGraphLegendTitle2(String expectedTitle) {	 
		String actualTitle = page.locator(zookeeperSASLAuthenticationLegendTitle2).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateZookeeperSASLAuthenticationGraphLegendTitle3(String expectedTitle) {	 
		String actualTitle = page.locator(zookeeperSASLAuthenticationLegendTitle3).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void validateZookeeperSASLAuthenticationToolTipTitle() {	 
		util.validateWidgetToolTips(page, zookeeperSASLAuthenticationXaxisLine, zookeeperSASLAuthenticationToolTipTitle);
	}

	public void validateZookeeperSASLAuthenticationDragAndDrop() {
		util.graphZoomInByDragAndDrop(page, zookeeperSASLAuthenticationXaxisLine, zookeeperSASLAuthenticationZoomOut, zookeeperSASLAuthenticationXaxisValues);
	}
	public void validateZookeeperSASLAuthenticationExpandViewXAxisTitle() { 
		util.validateExpandViewTexts(page, zookeeperSASLAuthenticationXaxis, zookeeperSASLAuthenticationExpand, expandViewCloseBtn, expandViewXaxisTitle);
	}

	public void validateZookeeperSASLAuthenticationExpandViewYAxisTitle() {
		util.validateExpandViewTexts(page, zookeeperSASLAuthenticationYaxis, zookeeperSASLAuthenticationExpand, expandViewCloseBtn, expandViewYaxisTitle);
	}

	public void validateZookeeperSASLAuthenticationExpandViewWidgetTitle() {
		util.validateExpandViewTexts(page, zookeeperSASLAuthenticationGraphTitle, zookeeperSASLAuthenticationExpand, expandViewCloseBtn, expandViewWidgetTitle);
	}

	public void validateZookeeperSASLAuthenticationExpandViewLegendHeader1() {	 
		util.validateExpandViewTexts(page, zookeeperSASLAuthenticationLegendTitle1, zookeeperSASLAuthenticationExpand, expandViewCloseBtn, expandViewLegendColumn1HeaderTitle);
	}

	public void validateZookeeperSASLAuthenticationExpandViewLegendHeader2() {	 
		util.validateExpandViewTexts(page, zookeeperSASLAuthenticationLegendTitle2 ,zookeeperSASLAuthenticationExpand, expandViewCloseBtn, expandViewLegendColumn2HeaderTitle);
	}

	public void validateZookeeperSASLAuthenticationExpandViewLegendHeader3() {	 
		util.validateExpandViewTexts(page, zookeeperSASLAuthenticationLegendTitle3 ,zookeeperSASLAuthenticationExpand, expandViewCloseBtn, expandViewLegendColumn3HeaderTitle);
	}

	public void validateZookeeperSASLAuthenticationExpandViewZoomIn() {
		util.ExpandViewZoomInBtn(page, expandViewZoomInBtn, zookeeperSASLAuthenticationExpand, expandViewCloseBtn, expandViewXaxisValues);
	}

	public void validateZookeeperSASLAuthenticationExpandViewZoomOut() {
		util.ExpandViewZoomOutBtn(page, expandViewZoomInBtn, zookeeperSASLAuthenticationExpand, expandViewCloseBtn, expandViewZoomOutBtn, expandViewXaxisValues);
	}

	public void validateZookeeperSASLAuthenticationExpandViewWidgetDragDrop() {
		util.ExpandViewWidgetDragDrop(page, zookeeperSASLAuthenticationExpand, expandViewCloseBtn, expandViewXaxisLines, expandViewZoomOutBtn, expandViewXaxisValues);
	}
	
/*
 * Calendar
 */
		
	public void validateTheCustomTimeLine(String period) {
		util.validateCustomTimeLine(page, zookeeperDisconnectXaxisValues, period, WidgetXValues(period));
	}
		
	public void validateXaxisValuesForKafkaZookeeperPage() {
		util.validateTheGraphdisplayingTheDataAsPerGivenTimeLines(page, zookeeperDisconnectXaxisValues, calenderView, allWidgetXValues());
	}
	
	public List<String> allWidgetXValues() {
		ArrayList<String> xValue = new ArrayList<String>();
		xValue.add(zookeeperDisconnectXaxisValues);
		xValue.add(zookeeperConnectXaxisValues);
		xValue.add(zookeeperExpirePerSecondXaxisValues);
		xValue.add(zookeeperAuthFailureXaxisValues);
		xValue.add(zookeeperReadOnlyConnectXaxisValues);
		xValue.add(zookeeperSASLAuthenticationXaxisValues);
		return xValue;
	}
}
