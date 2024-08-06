package objectRepository.MQM;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;

import genericUtilities.ExcelUtility;
import genericUtilities.GenericMethods;

public class MQKafka_Producer_Page 
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
	
	private String ProducerTab = "xpath = //div[@class='navtab']/div[@class='item' and position()=2]/child::div";	
	private String BrokerTab = "xpath = //div[@class='kafkaProducerTabSelector']/descendant::div[contains(@class,'kafkaTabItem') and position()=1]";
	private String TopicTab = "xpath = //div[@class='kafkaProducerTabSelector']/descendant::div[contains(@class,'kafkaTabItem') and position()=2]";
	
    //Producer > Broker
	private String BrokerIncomingBytesID = "apexchartschart-kafka_producer_incoming_byte_rate";
	private String BrokerOutgoingBytesID = "apexchartschart-kafka_producer_outgoing_byte_rate";
	private String BrokerRequestSizeID = "apexchartschart-kafka_producer_request_size_avg";
	private String BrokerResponseRateID = "apexchartschart-kafka_producer_response_rate";
  	
  	//Producer > Topic
	private String TopicRecordSendRateID = "apexchartschart-kafka_producer_incoming_byte_rate";
	private String TopicRecordSendTotalID = "apexchartschart-kafka_producer_outgoing_byte_rate";
	private String TopicRecordErrorRateID = "apexchartschart-kafka_producer_request_size_avg";
	private String TopicRecordErrorTotalID = "apexchartschart-kafka_producer_response_rate";
	
	public List<String> WidgetXValues(String XValue){
    	ArrayList<String> xValue = new ArrayList<String>();
    	xValue.add(XValue);
    	return xValue;
	}
	
	public MQKafka_Producer_Page(Page page) {
		this.page = page;
	}

	public void navigateToKafka() {
		util.selectTheOptionFromDropDownBySearch(page, SelectMessageQueueDropdown, SelectSearchFieldMQDropdown, "Kafka",  SelectMQDropdown);
		page.waitForLoadState(LoadState.NETWORKIDLE);
	}	
	
	public void selectServiceName(String application) {
		 util.selectTheOptionFromDropDownBySearch(page, SelectServiceNameDropdown,
	  SelectSearchFieldServiceNameDropdown, application,
	  SearchedApplication); 
		 page.waitForLoadState(LoadState.NETWORKIDLE); }
	 
	public void navigateToProducerTab() {
		page.locator(ProducerTab).click();
		page.waitForLoadState(LoadState.NETWORKIDLE);
	}
	
	public void validateProducerTitle(String expectedTitle) {
    	String actualTitle = page.locator(ProducerTab).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    	page.waitForLoadState(LoadState.NETWORKIDLE);
    }
	
	
	public void validateBrokerTabTitle(String expectedTitle) {
    	String actualTitle = page.locator(BrokerTab).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    	page.waitForLoadState(LoadState.NETWORKIDLE);
    }
	
//Broker > Incoming Bytes Graph
	
	public void validateBrokerIncomingBytesGraphTitle(String expectedTitle) {
    	String actualTitle = page.locator(getWidgetTitle(BrokerIncomingBytesID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
	
	public void validateIncomingBytesZoomInBtn() {
		  
		util.graphZoomIn(page,ZoomIn(BrokerIncomingBytesID), BrokerIncomingBytesID);
	}
	
	public void validateIncomingBytesZoomOutBtn() {
		  
		util.graphZoomOut(page,ZoomIn(BrokerIncomingBytesID),ZoomOut(BrokerIncomingBytesID), BrokerIncomingBytesID);
	}
		
	public void validateBrokerIncomingBytesXaxisValues() {
		  
		util.validateTheGraphdisplayingTheDataAsPerGivenTimeLines(page, XaxisValues(BrokerIncomingBytesID), calenderView, WidgetXValues(XaxisValues(BrokerIncomingBytesID)));
	}
	
	public void validateBrokerIncomingBytesGraphXaxisTitle(String expectedTitle) {
    	String actualTitle = page.locator(XaxisTitle(BrokerIncomingBytesID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
	
	public void validateBrokerIncomingBytesGraphYaxisTitle(String expectedTitle) {
    	String actualTitle = page.locator(YaxisTitle(BrokerIncomingBytesID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
	
	public void validateBrokerIncomingBytesGraphBrokerHeaderTitle(String expectedTitle) {
    	String actualTitle = page.locator(HeaderTitle(BrokerIncomingBytesID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
	
	public void validateBrokerIncomingBytesGraphAvgHeaderTitle(String expectedTitle) {
    	String actualTitle = page.locator(AvgHeader(BrokerIncomingBytesID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
	
	public void validateBrokerIncomingBytesGraphMaxHeaderTitle(String expectedTitle) {
    	String actualTitle = page.locator(MaxHeader(BrokerIncomingBytesID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
	
	public void validateBrokerIncomingBytesGraphRowColor1(String expectedTitle) {
    	String actualTitle = page.locator(RowColor1(BrokerIncomingBytesID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
	
	public void validateBrokerIncomingBytesToolTipTitle() {
        util.validateWidgetToolTips(page, XaxisLines(BrokerIncomingBytesID), ToolTipTitle(BrokerIncomingBytesID));
    }
 
	public void validateBrokerIncomingBytesExpandViewXAxisTitle() {
		util.validateExpandViewTexts(page, XaxisTitle(BrokerIncomingBytesID), Expand(BrokerIncomingBytesID), expandViewCloseBtn, expandViewXaxisTitle);
	}

	public void validateBrokerIncomingBytesExpandViewYAxisTitle() {
		util.validateExpandViewTexts(page, YaxisTitle(BrokerIncomingBytesID), Expand(BrokerIncomingBytesID), expandViewCloseBtn, expandViewYaxisTitle);
	}
	
	public void validateBrokerIncomingBytesExpandViewWidgetTitle() {
		util.validateExpandViewTexts(page, getWidgetTitle(BrokerIncomingBytesID), Expand(BrokerIncomingBytesID), expandViewCloseBtn, expandViewWidgetTitle);
	}
	
	public void validateBrokerIncomingBytesExpandViewLegendHeader1() {
		util.validateExpandViewTexts(page, LegendColumn1Title(BrokerIncomingBytesID), Expand(BrokerIncomingBytesID), expandViewCloseBtn, expandViewLegendColumn1HeaderTitle);
	}
	
	public void validateBrokerIncomingBytesExpandViewLegendHeader2() {
		util.validateExpandViewTexts(page, LegendColumn2Title(BrokerIncomingBytesID), Expand(BrokerIncomingBytesID), expandViewCloseBtn, expandViewLegendColumn2HeaderTitle);
	}
	
	public void validateBrokerIncomingBytesExpandViewLegendHeader3() {
		util.validateExpandViewTexts(page, LegendColumn3Title(BrokerIncomingBytesID), Expand(BrokerIncomingBytesID), expandViewCloseBtn, expandViewLegendColumn3HeaderTitle);
	}
	
	public void validateBrokerIncomingBytesExpandViewLegendHeader2InforMessage() {
		util.validateExpandViewTexts(page, LegendColumn2Title(BrokerIncomingBytesID), Expand(BrokerIncomingBytesID), expandViewCloseBtn, expandViewLegendColumnHeader2infoMessage);
	}
	
	public void validateBrokerIncomingBytesExpandViewLegendHeader3InforMessage() {
		util.validateExpandViewTexts(page, LegendColumn3Title(BrokerIncomingBytesID), Expand(BrokerIncomingBytesID), expandViewCloseBtn, expandViewLegendColumnHeader3infoMessage);
	}
	
	public void validateBrokerIncomingBytesExpandViewZoomIn() {
		util.ExpandViewZoomInBtn(page, expandViewZoomInBtn, Expand(BrokerIncomingBytesID), expandViewCloseBtn, expandViewXaxisValues);
	}
	
	public void validateBrokerIncomingBytesExpandViewZoomOut() {
		util.ExpandViewZoomOutBtn(page, expandViewZoomInBtn, Expand(BrokerIncomingBytesID), expandViewCloseBtn, expandViewZoomOutBtn, expandViewXaxisValues);
	}
	
	public void validateBrokerIncomingBytesExpandViewWidgetDragDrop() {
		util.ExpandViewWidgetDragDrop(page, Expand(BrokerIncomingBytesID), expandViewCloseBtn, expandViewXaxisLines, expandViewZoomOutBtn, expandViewXaxisValues);
	}
	
	
	
//Broker > Outgoing Bytes Graph
	
	public void validateBrokerOutgoingBytesGraphTitle(String expectedTitle) {
    	String actualTitle = page.locator(getWidgetTitle(BrokerOutgoingBytesID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
	
	public void validateOutgoingBytesZoomInBtn() {
		  
		util.graphZoomIn(page,ZoomOut(BrokerOutgoingBytesID), BrokerOutgoingBytesID);
	}
	
	public void validateOutgoingBytesZoomOutBtn() {
		  
		util.graphZoomOut(page,ZoomIn(BrokerOutgoingBytesID),ZoomOut(BrokerOutgoingBytesID), BrokerOutgoingBytesID);
	}
	
	
	public void validateBrokerOutgoingBytesXaxisValues() {
		  
		util.validateTheGraphdisplayingTheDataAsPerGivenTimeLines(page, XaxisValues(BrokerOutgoingBytesID), calenderView, WidgetXValues(XaxisValues(BrokerOutgoingBytesID)));
	}
	
	public void validateBrokerOutgoingBytesGraphXaxisTitle(String expectedTitle) {
    	String actualTitle = page.locator(XaxisTitle(BrokerOutgoingBytesID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
	
	public void validateBrokerOutgoingBytesGraphYaxisTitle(String expectedTitle) {
    	String actualTitle = page.locator(YaxisTitle(BrokerOutgoingBytesID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
	
	public void validateBrokerOutgoingBytesGraphBrokerHeaderTitle(String expectedTitle) {
    	String actualTitle = page.locator(HeaderTitle(BrokerOutgoingBytesID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
	
	public void validateBrokerOutgoingBytesGraphAvgHeaderTitle(String expectedTitle) {
    	String actualTitle = page.locator(AvgHeader(BrokerOutgoingBytesID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
	
	public void validateBrokerOutgoingBytesGraphMaxHeaderTitle(String expectedTitle) {
    	String actualTitle = page.locator(MaxHeader(BrokerOutgoingBytesID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
	
	public void validateBrokerOutgoingBytesGraphRowColor1(String expectedTitle) {
    	String actualTitle = page.locator(RowColor1(BrokerOutgoingBytesID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
	
	public void validateBrokerOutgoingBytesToolTipTitle() {
        util.validateWidgetToolTips(page, XaxisLines(BrokerOutgoingBytesID), ToolTipTitle(BrokerOutgoingBytesID));
    }
	
	public void validateBrokerOutgoingBytesExpandViewXAxisTitle() {
		util.validateExpandViewTexts(page, XaxisTitle(BrokerOutgoingBytesID), Expand(BrokerOutgoingBytesID), expandViewCloseBtn, expandViewXaxisTitle);
	}

	public void validateBrokerOutgoingBytesExpandViewYAxisTitle() {
		util.validateExpandViewTexts(page, YaxisTitle(BrokerOutgoingBytesID), Expand(BrokerOutgoingBytesID), expandViewCloseBtn, expandViewYaxisTitle);
	}
	
	public void validateBrokerOutgoingBytesExpandViewWidgetTitle() {
		util.validateExpandViewTexts(page, getWidgetTitle(BrokerOutgoingBytesID), Expand(BrokerOutgoingBytesID), expandViewCloseBtn, expandViewWidgetTitle);
	}
	
	public void validateBrokerOutgoingBytesExpandViewLegendHeader1() {
		util.validateExpandViewTexts(page, LegendColumn1Title(BrokerOutgoingBytesID), Expand(BrokerOutgoingBytesID), expandViewCloseBtn, expandViewLegendColumn1HeaderTitle);
	}
	
	public void validateBrokerOutgoingBytesExpandViewLegendHeader2() {
		util.validateExpandViewTexts(page, LegendColumn2Title(BrokerOutgoingBytesID), Expand(BrokerOutgoingBytesID), expandViewCloseBtn, expandViewLegendColumn2HeaderTitle);
	}
	
	public void validateBrokerOutgoingBytesExpandViewLegendHeader3() {
		util.validateExpandViewTexts(page, LegendColumn3Title(BrokerOutgoingBytesID), Expand(BrokerOutgoingBytesID), expandViewCloseBtn, expandViewLegendColumn3HeaderTitle);
	}
	
	public void validateBrokerOutgoingBytesExpandViewLegendHeader2InforMessage() {
		util.validateExpandViewTexts(page, LegendColumn2Title(BrokerOutgoingBytesID), Expand(BrokerOutgoingBytesID), expandViewCloseBtn, expandViewLegendColumnHeader2infoMessage);
	}
	
	public void validateBrokerOutgoingBytesExpandViewLegendHeader3InforMessage() {
		util.validateExpandViewTexts(page, LegendColumn3Title(BrokerOutgoingBytesID), Expand(BrokerOutgoingBytesID), expandViewCloseBtn, expandViewLegendColumnHeader3infoMessage);
	}
	
	public void validateBrokerOutgoingBytesExpandViewZoomIn() {
		util.ExpandViewZoomInBtn(page, expandViewZoomInBtn, Expand(BrokerOutgoingBytesID), expandViewCloseBtn, expandViewXaxisValues);
	}
	
	public void validateBrokerOutgoingBytesExpandViewZoomOut() {
		util.ExpandViewZoomOutBtn(page, expandViewZoomInBtn, Expand(BrokerOutgoingBytesID), expandViewCloseBtn, expandViewZoomOutBtn, expandViewXaxisValues);
	}
	
	public void validateBrokerOutgoingBytesExpandViewWidgetDragDrop() {
		util.ExpandViewWidgetDragDrop(page, Expand(BrokerOutgoingBytesID), expandViewCloseBtn, expandViewXaxisLines, expandViewZoomOutBtn, expandViewXaxisValues);
	}
	
	
  
//Broker > Request SizeGraph
	
	public void validateBrokerRequestSizeGraphTitle(String expectedTitle) {
    	String actualTitle = page.locator(getWidgetTitle(BrokerRequestSizeID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
	
	public void validateBrokerRequestSizeZoomInBtn() {
		  
		util.graphZoomIn(page,ZoomOut(BrokerRequestSizeID),BrokerRequestSizeID);
	}
	
	public void validateBrokerRequestSizeZoomOutBtn() {
		  
		util.graphZoomOut(page,ZoomIn(BrokerRequestSizeID),ZoomOut(BrokerRequestSizeID), BrokerRequestSizeID);
	}
	
	public void validateBrokerRequestSizeXaxisValues() {
		  
		util.validateTheGraphdisplayingTheDataAsPerGivenTimeLines(page, XaxisValues(BrokerRequestSizeID), calenderView, WidgetXValues(XaxisValues(BrokerRequestSizeID)));
	}
	
	public void validateBrokerRequestSizeGraphXaxisTitle(String expectedTitle) {
    	String actualTitle = page.locator(XaxisTitle(BrokerRequestSizeID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
	
	public void validateBrokerRequestSizeGraphYaxisTitle(String expectedTitle) {
    	String actualTitle = page.locator(YaxisTitle(BrokerRequestSizeID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }

	public void validateBrokerRequestSizeGraphBrokerHeaderTitle(String expectedTitle) {
    	String actualTitle = page.locator(HeaderTitle(BrokerRequestSizeID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
	
	public void validateBrokerRequestSizeGraphAvgHeaderTitle(String expectedTitle) {
    	String actualTitle = page.locator(AvgHeader(BrokerRequestSizeID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
	
	public void validateBrokerRequestSizeGraphMaxHeaderTitle(String expectedTitle) {
    	String actualTitle = page.locator(MaxHeader(BrokerRequestSizeID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
	
	public void validateBrokerRequestSizeGraphRowColor1(String expectedTitle) {
    	String actualTitle = page.locator(RowColor1(BrokerRequestSizeID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
	
	public void validateBrokerRequestSizeToolTipTitle() {
        util.validateWidgetToolTips(page, XaxisLines(BrokerRequestSizeID), ToolTipTitle(BrokerRequestSizeID));
    }
 
	public void validateBrokerRequestSizeExpandViewXAxisTitle() {
		util.validateExpandViewTexts(page, XaxisTitle(BrokerRequestSizeID), Expand(BrokerRequestSizeID), expandViewCloseBtn, expandViewXaxisTitle);
	}

	public void validateBrokerRequestSizeExpandViewYAxisTitle() {
		util.validateExpandViewTexts(page, YaxisTitle(BrokerRequestSizeID), Expand(BrokerRequestSizeID), expandViewCloseBtn, expandViewYaxisTitle);
	}
	
	public void validateBrokerRequestSizeExpandViewWidgetTitle() {
		util.validateExpandViewTexts(page, getWidgetTitle(BrokerRequestSizeID), Expand(BrokerRequestSizeID), expandViewCloseBtn, expandViewWidgetTitle);
	}
	
	public void validateBrokerRequestSizeExpandViewLegendHeader1() {
		util.validateExpandViewTexts(page, LegendColumn1Title(BrokerRequestSizeID), Expand(BrokerRequestSizeID), expandViewCloseBtn, expandViewLegendColumn1HeaderTitle);
	}
	
	public void validateBrokerRequestSizeExpandViewLegendHeader2() {
		util.validateExpandViewTexts(page, LegendColumn2Title(BrokerRequestSizeID), Expand(BrokerRequestSizeID), expandViewCloseBtn, expandViewLegendColumn2HeaderTitle);
	}
	
	public void validateBrokerRequestSizeExpandViewLegendHeader3() {
		util.validateExpandViewTexts(page, LegendColumn3Title(BrokerRequestSizeID), Expand(BrokerRequestSizeID), expandViewCloseBtn, expandViewLegendColumn3HeaderTitle);
	}
	
	public void validateBrokerRequestSizeExpandViewLegendHeader2InforMessage() {
		util.validateExpandViewTexts(page, LegendColumn2Title(BrokerRequestSizeID), Expand(BrokerRequestSizeID), expandViewCloseBtn, expandViewLegendColumnHeader2infoMessage);
	}
	
	public void validateBrokerRequestSizeExpandViewLegendHeader3InforMessage() {
		util.validateExpandViewTexts(page, LegendColumn3Title(BrokerRequestSizeID), Expand(BrokerRequestSizeID), expandViewCloseBtn, expandViewLegendColumnHeader3infoMessage);
	}
	
	public void validateBrokerRequestSizeExpandViewZoomIn() {
		util.ExpandViewZoomInBtn(page, expandViewZoomInBtn, Expand(BrokerRequestSizeID), expandViewCloseBtn, expandViewXaxisValues);
	}
	
	public void validateBrokerRequestSizeExpandViewZoomOut() {
		util.ExpandViewZoomOutBtn(page, expandViewZoomInBtn, Expand(BrokerRequestSizeID), expandViewCloseBtn, expandViewZoomOutBtn, expandViewXaxisValues);
	}
	
	public void validateBrokerRequestSizeExpandViewWidgetDragDrop() {
		util.ExpandViewWidgetDragDrop(page, Expand(BrokerRequestSizeID), expandViewCloseBtn, expandViewXaxisLines, expandViewZoomOutBtn, expandViewXaxisValues);
	}
	
	
	
//Broker > Response Rate Graph
	
	public void validateBrokerResponseRateGraphTitle(String expectedTitle) {
    	String actualTitle = page.locator(getWidgetTitle(BrokerResponseRateID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
	
	public void validateBrokerResponseSizeZoomInBtn() {
		  
		util.graphZoomIn(page,ZoomOut(BrokerResponseRateID),BrokerResponseRateID);
	}
	
	public void validateBrokerResponseSizeZoomOutBtn() {
		  
		util.graphZoomOut(page,ZoomIn(BrokerResponseRateID),ZoomOut(BrokerResponseRateID), BrokerResponseRateID);
	}
	
	public void validateBrokerResponseRateXaxisValues() {
		  
		util.validateTheGraphdisplayingTheDataAsPerGivenTimeLines(page, XaxisValues(BrokerResponseRateID), calenderView, WidgetXValues(XaxisValues(BrokerResponseRateID)));
	}
	
	public void validateBrokerResponseRateGraphXaxisTitle(String expectedTitle) {
    	String actualTitle = page.locator(XaxisTitle(BrokerResponseRateID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
	
	public void validateBrokerResponseRateGraphYaxisTitle(String expectedTitle) {
    	String actualTitle = page.locator(YaxisTitle(BrokerResponseRateID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
	
	public void validateBrokerResponseRateGraphBrokerHeaderTitle(String expectedTitle) {
    	String actualTitle = page.locator(HeaderTitle(BrokerResponseRateID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
	
	public void validateBrokerResponseRateGraphAvgHeaderTitle(String expectedTitle) {
    	String actualTitle = page.locator(AvgHeader(BrokerResponseRateID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
	
	public void validateBrokerResponseRateGraphMaxHeaderTitle(String expectedTitle) {
    	String actualTitle = page.locator(MaxHeader(BrokerResponseRateID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
	
	public void validateBrokerResponseRateGraphRowColor1(String expectedTitle) {
    	String actualTitle = page.locator(RowColor1(BrokerResponseRateID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
	
	public void validateBrokerResponseRateToolTipTitle() {
        util.validateWidgetToolTips(page, XaxisLines(BrokerResponseRateID), ToolTipTitle(BrokerResponseRateID));
    }
  
	public void validateBrokerResponseRateExpandViewXAxisTitle() {
		util.validateExpandViewTexts(page, XaxisTitle(BrokerResponseRateID), Expand(BrokerResponseRateID), expandViewCloseBtn, expandViewXaxisTitle);
	}

	public void validateBrokerResponseRateExpandViewYAxisTitle() {
		util.validateExpandViewTexts(page, YaxisTitle(BrokerResponseRateID), Expand(BrokerResponseRateID), expandViewCloseBtn, expandViewYaxisTitle);
	}
	
	public void validateBrokerResponseRateExpandViewWidgetTitle() {
		util.validateExpandViewTexts(page, getWidgetTitle(BrokerResponseRateID), Expand(BrokerResponseRateID), expandViewCloseBtn, expandViewWidgetTitle);
	}
	
	public void validateBrokerResponseRateExpandViewLegendHeader1() {
		util.validateExpandViewTexts(page, LegendColumn1Title(BrokerResponseRateID), Expand(BrokerResponseRateID), expandViewCloseBtn, expandViewLegendColumn1HeaderTitle);
	}
	
	public void validateBrokerResponseRateExpandViewLegendHeader2() {
		util.validateExpandViewTexts(page, LegendColumn2Title(BrokerResponseRateID), Expand(BrokerResponseRateID), expandViewCloseBtn, expandViewLegendColumn2HeaderTitle);
	}
	
	public void validateBrokerResponseRateExpandViewLegendHeader3() {
		util.validateExpandViewTexts(page, LegendColumn3Title(BrokerResponseRateID), Expand(BrokerResponseRateID), expandViewCloseBtn, expandViewLegendColumn3HeaderTitle);
	}
	
	public void validateBrokerResponseRateExpandViewLegendHeader2InforMessage() {
		util.validateExpandViewTexts(page, LegendColumn2Title(BrokerResponseRateID), Expand(BrokerResponseRateID), expandViewCloseBtn, expandViewLegendColumnHeader2infoMessage);
	}
	
	public void validateBrokerResponseRateExpandViewLegendHeader3InforMessage() {
		util.validateExpandViewTexts(page, LegendColumn3Title(BrokerResponseRateID), Expand(BrokerResponseRateID), expandViewCloseBtn, expandViewLegendColumnHeader3infoMessage);
	}
	
	public void validateBrokerResponseRateExpandViewZoomIn() {
		util.ExpandViewZoomInBtn(page, expandViewZoomInBtn, Expand(BrokerResponseRateID), expandViewCloseBtn, expandViewXaxisValues);
	}
	
	public void validateBrokerResponseRateExpandViewZoomOut() {
		util.ExpandViewZoomOutBtn(page, expandViewZoomInBtn, Expand(BrokerResponseRateID), expandViewCloseBtn, expandViewZoomOutBtn, expandViewXaxisValues);
	}
	
	public void validateBrokerResponseRateExpandViewWidgetDragDrop() {
		util.ExpandViewWidgetDragDrop(page, Expand(BrokerResponseRateID), expandViewCloseBtn, expandViewXaxisLines, expandViewZoomOutBtn, expandViewXaxisValues);
	}
	
	
	
//Topic	
	
	
	public void validateTopicTabTitle(String expectedTitle) {
    	String actualTitle = page.locator(TopicTab).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
	
	public void clickOnBrokerTab() {
		String desiredTab = page.getAttribute(BrokerTab,"class");
		if(!desiredTab.contains("Active")){
			page.locator(BrokerTab).click();
			//page.waitForSelector(getWidgetTitle(TopicRecordSendRateID));
		}
			//page.locator(BrokerTab).click();
	}
	
	public void clickOnTopicTab() {	
		String desiredTab = page.getAttribute(TopicTab,"class");
		if(!desiredTab.contains("Active")){
			page.locator(TopicTab).click();
			//page.waitForSelector("xpath = //div[@id='"+TopicRecordSendRateID+"']/ancestor::div[@class='card-body']/preceding-sibling::div[@class='card-header']");
		}
	}
	
//Topic > Record Send Rate Graph
	
	public void validateTopicRecordSendRateGraphTitle(String expectedTitle) {
		String actualTitle = page.locator(getWidgetTitle(TopicRecordSendRateID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);    	
    }
	
	public void validateTopicRecordSendRateGraphZoomInBtn() {
		util.graphZoomIn(page,ZoomOut(TopicRecordSendRateID),TopicRecordSendRateID);	
	}
	
	public void validateTopicRecordSendRateGraphZoomOutBtn() {
		util.graphZoomOut(page,ZoomIn(TopicRecordSendRateID),ZoomOut(TopicRecordSendRateID), TopicRecordSendRateID);		
	}
	
	public void validateTopicRecordSendRateXaxisValues() {
		util.validateTheGraphdisplayingTheDataAsPerGivenTimeLines(page, XaxisValues(TopicRecordSendRateID), calenderView, WidgetXValues(XaxisValues(TopicRecordSendRateID)));		
	}
	
	public void validateTopicRecordSendRateGraphXaxisTitle(String expectedTitle) {
		String actualTitle = page.locator(XaxisTitle(TopicRecordSendRateID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);   	
	}
	
	public void validateTopicRecordSendRateGraphYaxisTitle(String expectedTitle) {
    	String actualTitle = page.locator(YaxisTitle(TopicRecordSendRateID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
	}
	
	public void validateTopicRecordSendRateGraphTopicHeaderTitle(String expectedTitle) {
    	String actualTitle = page.locator(HeaderTitle(TopicRecordSendRateID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
	}
	
	public void validateTopicRecordSendRateGraphAvgHeaderTitle(String expectedTitle) {
    	String actualTitle = page.locator(AvgHeader(TopicRecordSendRateID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
	
	public void validateTopicRecordSendRateGraphMaxHeaderTitle(String expectedTitle) {
    	String actualTitle = page.locator(MaxHeader(TopicRecordSendRateID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
	
	public void validateTopicRecordSendRateGraphRowColor1(String expectedTitle) {
    	String actualTitle = page.locator(RowColor1(TopicRecordSendRateID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
	
	public void validateTopicRecordSendRateToolTipTitle() {
        util.validateWidgetToolTips(page, XaxisLines(TopicRecordSendRateID), ToolTipTitle(TopicRecordSendRateID));
    }
  
	public void validateTopicRecordSendRateExpandViewXAxisTitle() {
		util.validateExpandViewTexts(page, XaxisTitle(TopicRecordSendRateID), Expand(TopicRecordSendRateID), expandViewCloseBtn, expandViewXaxisTitle);
	}

	public void validateTopicRecordSendRateExpandViewYAxisTitle() {
		util.validateExpandViewTexts(page, YaxisTitle(TopicRecordSendRateID), Expand(TopicRecordSendRateID), expandViewCloseBtn, expandViewYaxisTitle);
	}
	
	public void validateTopicRecordSendRateExpandViewWidgetTitle() {
		util.validateExpandViewTexts(page, getWidgetTitle(TopicRecordSendRateID), Expand(TopicRecordSendRateID), expandViewCloseBtn, expandViewWidgetTitle);
	}
	
	public void validateTopicRecordSendRateExpandViewLegendHeader1() {
		util.validateExpandViewTexts(page, LegendColumn1Title(TopicRecordSendRateID), Expand(TopicRecordSendRateID), expandViewCloseBtn, expandViewLegendColumn1HeaderTitle);
	}
	
	public void validateTopicRecordSendRateExpandViewLegendHeader2() {
		util.validateExpandViewTexts(page, LegendColumn2Title(TopicRecordSendRateID), Expand(TopicRecordSendRateID), expandViewCloseBtn, expandViewLegendColumn2HeaderTitle);
	}
	
	public void validateTopicRecordSendRateExpandViewLegendHeader3() {
		util.validateExpandViewTexts(page, LegendColumn3Title(TopicRecordSendRateID), Expand(TopicRecordSendRateID), expandViewCloseBtn, expandViewLegendColumn3HeaderTitle);
	}
	
	public void validateTopicRecordSendRateExpandViewLegendHeader2InforMessage() {
		util.validateExpandViewTexts(page, LegendColumn2Title(TopicRecordSendRateID), Expand(TopicRecordSendRateID), expandViewCloseBtn, expandViewLegendColumnHeader2infoMessage);
	}
	
	public void validateTopicRecordSendRateExpandViewLegendHeader3InforMessage() {
		util.validateExpandViewTexts(page, LegendColumn3Title(TopicRecordSendRateID), Expand(TopicRecordSendRateID), expandViewCloseBtn, expandViewLegendColumnHeader3infoMessage);
	}
	
	public void validateTopicRecordSendRateExpandViewZoomIn() {
		util.ExpandViewZoomInBtn(page, expandViewZoomInBtn, Expand(TopicRecordSendRateID), expandViewCloseBtn, expandViewXaxisValues);
	}
	
	public void validateTopicRecordSendRateExpandViewZoomOut() {
		page.waitForTimeout(5000);
		util.ExpandViewZoomOutBtn(page, expandViewZoomInBtn, Expand(TopicRecordSendRateID), expandViewCloseBtn, expandViewZoomOutBtn, expandViewXaxisValues);
	}
	
	public void validateTopicRecordSendRateExpandViewWidgetDragDrop() {
		util.ExpandViewWidgetDragDrop(page, Expand(TopicRecordSendRateID), expandViewCloseBtn, expandViewXaxisLines, expandViewZoomOutBtn, expandViewXaxisValues);
	}
	
	
	
//Topic > Record Send Total Graph
	
	public void validateTopicRecordSendTotalGraphTitle(String expectedTitle) {
		page.waitForTimeout(5000);
    	String actualTitle = page.locator(getWidgetTitle(TopicRecordSendTotalID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
	
	public void validateTopicRecordSendTotalGraphZoomInBtn() {
		 
		util.graphZoomIn(page,ZoomOut(TopicRecordSendTotalID),TopicRecordSendTotalID);
	}
	
	public void validateTopicRecordSendTotalGraphZoomOutBtn() {
		 
		util.graphZoomOut(page,ZoomIn(TopicRecordSendTotalID),ZoomOut(TopicRecordSendTotalID), TopicRecordSendTotalID);
	}
	
	public void validateTopicRecordSendTotalXaxisValues() {
		 
		util.validateTheGraphdisplayingTheDataAsPerGivenTimeLines(page, XaxisValues(TopicRecordSendTotalID), calenderView, WidgetXValues(XaxisValues(TopicRecordSendTotalID)));
	}
	
	public void validateTopicRecordSendTotalGraphXaxisTitle(String expectedTitle) {
    	String actualTitle = page.locator(XaxisTitle(TopicRecordSendTotalID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
	
	public void validateTopicRecordSendTotalGraphYaxisTitle(String expectedTitle) {
		page.waitForTimeout(5000);
    	String actualTitle = page.locator(YaxisTitle(TopicRecordSendTotalID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
	
	public void validateTopicRecordSendTotalGraphTopicHeaderTitle(String expectedTitle) {
    	String actualTitle = page.locator(HeaderTitle(TopicRecordSendTotalID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
	
	public void validateTopicRecordSendTotalGraphAvgHeaderTitle(String expectedTitle) {
    	String actualTitle = page.locator(AvgHeader(TopicRecordSendTotalID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
	
	public void validateTopicRecordSendTotalGraphMaxHeaderTitle(String expectedTitle) {
    	String actualTitle = page.locator(MaxHeader(TopicRecordSendTotalID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
	
	public void validateTopicRecordSendTotalGraphRowColor1(String expectedTitle) {
    	String actualTitle = page.locator(RowColor1(TopicRecordSendTotalID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
	
	public void validateTopicRecordSendTotalToolTipTitle() {
        util.validateWidgetToolTips(page, XaxisLines(TopicRecordSendTotalID), ToolTipTitle(TopicRecordSendTotalID));
    }

	public void validateTopicRecordSendTotalExpandViewXAxisTitle() {
		util.validateExpandViewTexts(page, XaxisTitle(TopicRecordSendTotalID), Expand(TopicRecordSendTotalID), expandViewCloseBtn, expandViewXaxisTitle);
	}

	public void validateTopicRecordSendTotalExpandViewYAxisTitle() {
		util.validateExpandViewTexts(page, YaxisTitle(TopicRecordSendTotalID), Expand(TopicRecordSendTotalID), expandViewCloseBtn, expandViewYaxisTitle);
	}
	
	public void validateTopicRecordSendTotalExpandViewWidgetTitle() {
		util.validateExpandViewTexts(page, getWidgetTitle(TopicRecordSendTotalID), Expand(TopicRecordSendTotalID), expandViewCloseBtn, expandViewWidgetTitle);
	}
	
	public void validateTopicRecordSendTotalExpandViewLegendHeader1() {
		util.validateExpandViewTexts(page, LegendColumn1Title(TopicRecordSendTotalID), Expand(TopicRecordSendTotalID), expandViewCloseBtn, expandViewLegendColumn1HeaderTitle);
	}
	
	public void validateTopicRecordSendTotalExpandViewLegendHeader2() {
		util.validateExpandViewTexts(page, LegendColumn2Title(TopicRecordSendTotalID), Expand(TopicRecordSendTotalID), expandViewCloseBtn, expandViewLegendColumn2HeaderTitle);
	}
	
	public void validateTopicRecordSendTotalExpandViewLegendHeader3() {
		util.validateExpandViewTexts(page, LegendColumn3Title(TopicRecordSendTotalID), Expand(TopicRecordSendTotalID), expandViewCloseBtn, expandViewLegendColumn3HeaderTitle);
	}
	
	public void validateTopicRecordSendTotalExpandViewLegendHeader2InforMessage() {
		util.validateExpandViewTexts(page, LegendColumn2Title(TopicRecordSendTotalID), Expand(TopicRecordSendTotalID), expandViewCloseBtn, expandViewLegendColumnHeader2infoMessage);
	}
	
	public void validateTopicRecordSendTotalExpandViewLegendHeader3InforMessage() {
		util.validateExpandViewTexts(page, LegendColumn3Title(TopicRecordSendTotalID), Expand(TopicRecordSendTotalID), expandViewCloseBtn, expandViewLegendColumnHeader3infoMessage);
	}
	
	public void validateTopicRecordSendTotalExpandViewZoomIn() {
		util.ExpandViewZoomInBtn(page, expandViewZoomInBtn, Expand(TopicRecordSendTotalID), expandViewCloseBtn, expandViewXaxisValues);
	}
	
	public void validateTopicRecordSendTotalExpandViewZoomOut() {
		util.ExpandViewZoomOutBtn(page, expandViewZoomInBtn, Expand(TopicRecordSendTotalID), expandViewCloseBtn, expandViewZoomOutBtn, expandViewXaxisValues);
	}
	
	public void validateTopicRecordSendTotalExpandViewWidgetDragDrop() {
		page.waitForTimeout(2000);
		util.ExpandViewWidgetDragDrop(page, Expand(TopicRecordSendTotalID), expandViewCloseBtn, expandViewXaxisLines, expandViewZoomOutBtn, expandViewXaxisValues);
	}
	
	
//Topic > Record Error Rate Graph
	
	public void validateTopicRecordErrorRateGraphTitle(String expectedTitle) {
    	String actualTitle = page.locator(getWidgetTitle(TopicRecordErrorRateID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    	page.waitForLoadState(LoadState.NETWORKIDLE);
    }
	
	public void validateTopicRecordErrorRateGraphZoomInBtn() {
		  
		util.graphZoomIn(page,ZoomOut(TopicRecordErrorRateID),TopicRecordErrorRateID);
		page.waitForLoadState(LoadState.NETWORKIDLE);
	}
	
	public void validateTopicRecordErrorRateGraphZoomOutBtn() {
		  
		util.graphZoomOut(page,ZoomIn(TopicRecordErrorRateID),ZoomOut(TopicRecordErrorRateID), TopicRecordErrorRateID);
		page.waitForLoadState(LoadState.NETWORKIDLE);
	}	
	
	public void validateTopicRecordErrorRateXaxisValues() {
		page.waitForTimeout(2000);  
		util.validateTheGraphdisplayingTheDataAsPerGivenTimeLines(page, XaxisValues(TopicRecordErrorRateID), calenderView, WidgetXValues(XaxisValues(TopicRecordErrorRateID)));
		page.waitForLoadState(LoadState.NETWORKIDLE);
	}
	
	public void validateTopicRecordErrorRateGraphXaxisTitle(String expectedTitle) {
    	String actualTitle = page.locator(XaxisTitle(TopicRecordErrorRateID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    	page.waitForLoadState(LoadState.NETWORKIDLE);
    }
	
	public void validateTopicRecordErrorRateGraphYaxisTitle(String expectedTitle) {
    	String actualTitle = page.locator(YaxisTitle(TopicRecordErrorRateID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    	page.waitForLoadState(LoadState.NETWORKIDLE);
    }
	
	public void validateTopicRecordErrorRateGraphHeaderTitle(String expectedTitle) {
    	String actualTitle = page.locator(HeaderTitle(TopicRecordErrorRateID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    	page.waitForLoadState(LoadState.NETWORKIDLE);
    }

	public void validateTopicRecordErrorRateGraphAvgHeaderTitle(String expectedTitle) {
    	String actualTitle = page.locator(AvgHeader(TopicRecordErrorRateID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    	page.waitForLoadState(LoadState.NETWORKIDLE);
    }
	
	public void validateTopicRecordErrorRateGraphMaxHeaderTitle(String expectedTitle) {
    	String actualTitle = page.locator(MaxHeader(TopicRecordErrorRateID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    	page.waitForLoadState(LoadState.NETWORKIDLE);
    }
	
	public void validateTopicRecordErrorRateGraphRowColor1(String expectedTitle) {
    	String actualTitle = page.locator(RowColor1(TopicRecordErrorRateID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    	page.waitForLoadState(LoadState.NETWORKIDLE);
    }
	
	public void validateTopicRecordErrorRateToolTipTitle() {
        util.validateWidgetToolTips(page, XaxisLines(TopicRecordErrorRateID), ToolTipTitle(TopicRecordErrorRateID));
    }
  
	public void validateTopicRecordErrorRateExpandViewXAxisTitle() {
		util.validateExpandViewTexts(page, XaxisTitle(TopicRecordErrorRateID), Expand(TopicRecordErrorRateID), expandViewCloseBtn, expandViewXaxisTitle);
	}

	public void validateTopicRecordErrorRateExpandViewYAxisTitle() {
		util.validateExpandViewTexts(page, YaxisTitle(TopicRecordErrorRateID), Expand(TopicRecordErrorRateID), expandViewCloseBtn, expandViewYaxisTitle);
		page.waitForLoadState(LoadState.NETWORKIDLE);
	}
	
	public void validateTopicRecordErrorRateExpandViewWidgetTitle() {
		util.validateExpandViewTexts(page, getWidgetTitle(TopicRecordErrorRateID), Expand(TopicRecordErrorRateID), expandViewCloseBtn, expandViewWidgetTitle);
	}
	
	public void validateTopicRecordErrorRateExpandViewLegendHeader1() {
		util.validateExpandViewTexts(page, LegendColumn1Title(TopicRecordErrorRateID), Expand(TopicRecordErrorRateID), expandViewCloseBtn, expandViewLegendColumn1HeaderTitle);
	}
	
	public void validateTopicRecordErrorRateExpandViewLegendHeader2() {
		util.validateExpandViewTexts(page, LegendColumn2Title(TopicRecordErrorRateID), Expand(TopicRecordErrorRateID), expandViewCloseBtn, expandViewLegendColumn2HeaderTitle);
	}
	
	public void validateTopicRecordErrorRateExpandViewLegendHeader3() {
		util.validateExpandViewTexts(page, LegendColumn3Title(TopicRecordErrorRateID), Expand(TopicRecordErrorRateID), expandViewCloseBtn, expandViewLegendColumn3HeaderTitle);
	}
	
	public void validateTopicRecordErrorRateExpandViewLegendHeader2InforMessage() {
		util.validateExpandViewTexts(page, LegendColumn2Title(TopicRecordErrorRateID), Expand(TopicRecordErrorRateID), expandViewCloseBtn, expandViewLegendColumnHeader2infoMessage);
	}
	
	public void validateTopicRecordErrorRateExpandViewLegendHeader3InforMessage() {
		util.validateExpandViewTexts(page, LegendColumn3Title(TopicRecordErrorRateID), Expand(TopicRecordErrorRateID), expandViewCloseBtn, expandViewLegendColumnHeader3infoMessage);
	}
	
	public void validateTopicRecordErrorRateExpandViewZoomIn() {
		util.ExpandViewZoomInBtn(page, expandViewZoomInBtn, Expand(TopicRecordErrorRateID), expandViewCloseBtn, expandViewXaxisValues);
	}
	
	public void validateTopicRecordErrorRateExpandViewZoomOut() {
		util.ExpandViewZoomOutBtn(page, expandViewZoomInBtn, Expand(TopicRecordErrorRateID), expandViewCloseBtn, expandViewZoomOutBtn, expandViewXaxisValues);
	}
	
	public void validateTopicRecordErrorRateExpandViewWidgetDragDrop() {
		util.ExpandViewWidgetDragDrop(page, Expand(TopicRecordErrorRateID), expandViewCloseBtn, expandViewXaxisLines, expandViewZoomOutBtn, expandViewXaxisValues);
	}
	
	
	
//Topic > Record Error Total Graph
	
	public void validateTopicRecordErrorTotalGraphTitle(String expectedTitle) {
    	String actualTitle = page.locator(getWidgetTitle(TopicRecordErrorTotalID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
	
	public void validateTopicRecordErrorTotalGraphZoomInBtn() {
		page.waitForTimeout(2000);  
		util.graphZoomIn(page,ZoomOut(TopicRecordErrorTotalID),TopicRecordErrorTotalID);
	}
	
	public void validateTopicRecordErrorTotalGraphZoomOutBtn() {
		page.waitForTimeout(2000);  
		util.graphZoomOut(page,ZoomIn(TopicRecordErrorTotalID),ZoomOut(TopicRecordErrorTotalID), TopicRecordErrorTotalID);
	}
	
	public void validateTopicRecordErrorTotalXaxisValues() {
		page.waitForTimeout(2000);  
		util.validateTheGraphdisplayingTheDataAsPerGivenTimeLines(page, XaxisValues(TopicRecordErrorTotalID), calenderView, WidgetXValues(XaxisValues(TopicRecordErrorTotalID)));
	}
	
	public void validateTopicRecordErrorTotalGraphXaxisTitle(String expectedTitle) {
    	String actualTitle = page.locator(XaxisTitle(TopicRecordErrorTotalID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
	
	public void validateTopicRecordErrorTotalGraphYaxisTitle(String expectedTitle) {
    	String actualTitle = page.locator(YaxisTitle(TopicRecordErrorTotalID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }

	public void validateTopicRecordErrorTotalGraphTopicHeaderTitle(String expectedTitle) {
    	String actualTitle = page.locator(HeaderTitle(TopicRecordErrorTotalID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
	
	public void validateTopicRecordErrorTotalGraphAvgHeaderTitle(String expectedTitle) {
    	String actualTitle = page.locator(AvgHeader(TopicRecordErrorTotalID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
	
	public void validateTopicRecordErrorTotalGraphMaxHeaderTitle(String expectedTitle) {
    	String actualTitle = page.locator(MaxHeader(TopicRecordErrorTotalID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
	
	public void validateTopicRecordErrorTotalGraphRowColor1(String expectedTitle) {
		page.waitForTimeout(2000);  
    	String actualTitle = page.locator(RowColor1(TopicRecordErrorTotalID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
	
	public void validateTopicRecordErrorTotalToolTipTitle() {
        util.validateWidgetToolTips(page, XaxisLines(TopicRecordErrorTotalID), ToolTipTitle(TopicRecordErrorTotalID));
    }
 
	public void validateTopicRecordErrorTotalExpandViewXAxisTitle() {
		util.validateExpandViewTexts(page, XaxisTitle(TopicRecordErrorTotalID), Expand(TopicRecordErrorTotalID), expandViewCloseBtn, expandViewXaxisTitle);
	}

	public void validateTopicRecordErrorTotalExpandViewYAxisTitle() {
		util.validateExpandViewTexts(page, YaxisTitle(TopicRecordErrorTotalID), Expand(TopicRecordErrorTotalID), expandViewCloseBtn, expandViewYaxisTitle);
	}
	
	public void validateTopicRecordErrorTotalExpandViewWidgetTitle() {
		page.waitForTimeout(2000);
		util.validateExpandViewTexts(page, getWidgetTitle(TopicRecordErrorTotalID), Expand(TopicRecordErrorTotalID), expandViewCloseBtn, expandViewWidgetTitle);
	}
	
	public void validateTopicRecordErrorTotalExpandViewLegendHeader1() {
		util.validateExpandViewTexts(page, LegendColumn1Title(TopicRecordErrorTotalID), Expand(TopicRecordErrorTotalID), expandViewCloseBtn, expandViewLegendColumn1HeaderTitle);
	}
	
	public void validateTopicRecordErrorTotalExpandViewLegendHeader2() {
		util.validateExpandViewTexts(page, LegendColumn2Title(TopicRecordErrorTotalID), Expand(TopicRecordErrorTotalID), expandViewCloseBtn, expandViewLegendColumn2HeaderTitle);
	}
	
	public void validateTopicRecordErrorTotalExpandViewLegendHeader3() {
		util.validateExpandViewTexts(page, LegendColumn3Title(TopicRecordErrorTotalID), Expand(TopicRecordErrorTotalID), expandViewCloseBtn, expandViewLegendColumn3HeaderTitle);
	}
	
	public void validateTopicRecordErrorTotalExpandViewLegendHeader2InforMessage() {
		util.validateExpandViewTexts(page, LegendColumn2Title(TopicRecordErrorTotalID), Expand(TopicRecordErrorTotalID), expandViewCloseBtn, expandViewLegendColumnHeader2infoMessage);
	}
	
	public void validateTopicRecordErrorTotalExpandViewLegendHeader3InforMessage() {
		util.validateExpandViewTexts(page, LegendColumn3Title(TopicRecordErrorTotalID), Expand(TopicRecordErrorTotalID), expandViewCloseBtn, expandViewLegendColumnHeader3infoMessage);
	}
	
	public void validateTopicRecordErrorTotalExpandViewZoomIn() {
		page.waitForTimeout(2000);
		util.ExpandViewZoomInBtn(page, expandViewZoomInBtn, Expand(TopicRecordErrorTotalID), expandViewCloseBtn, expandViewXaxisValues);
	}
	
	public void validateTopicRecordErrorTotalExpandViewZoomOut() {
		page.waitForTimeout(2000);
		util.ExpandViewZoomOutBtn(page, expandViewZoomInBtn, Expand(TopicRecordErrorTotalID), expandViewCloseBtn, expandViewZoomOutBtn, expandViewXaxisValues);
	}
	
	public void validateTopicRecordErrorTotalExpandViewWidgetDragDrop() {
		page.waitForTimeout(2000);
		util.ExpandViewWidgetDragDrop(page, Expand(TopicRecordErrorTotalID), expandViewCloseBtn, expandViewXaxisLines, expandViewZoomOutBtn, expandViewXaxisValues);
	}

	
  	/**
     * id refers widget locator id
     * @param id
     * @return 
     */
	
	private String getWidgetTitle(String id) {
		//return "xpath = //div[@id='"+id+"']/ancestor::div[@class='card-body']/preceding-sibling::div[@class='card-header']";
		return "xpath = //div[@class='kafkaTabItem kafkaActiveTab']/ancestor::div[@class='kafkaProducerActions']/following-sibling::div/descendant::div[@id='"+id+"']/ancestor::div[@class='card-body']/preceding-sibling::div[@class='card-header']";
	}
	
	private String ZoomOut(String id) {
		return "xpath = //div[@id='"+id+"']/ancestor::div[@class='card-body']/preceding-sibling::div/descendant::span[@class='icon-class'][position()=1]";
	}
	
	private String ZoomIn(String id) {
		return "xpath = //div[@id='"+id+"']/ancestor::div[@class='card-body']/preceding-sibling::div/descendant::span[@class='icon-class'][position()=2]"  ;
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
	    
    //Headers
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
 		return "xpath = //div[@id='"+id+"']/ancestor::div[@class='card-body']/descendant::div[@class='header-heading'][position()=1]";
 	}

 	private String LegendColumn2Title(String id) {
 		return "xpath = //div[@id='"+id+"']/ancestor::div[@class='card-body']/descendant::div[@class='header-heading'][position()=2]";
 	}

 	private String LegendColumn3Title(String id) {
 		return "xpath = //div[@id='"+id+"']/ancestor::div[@class='card-body']/descendant::div[@class='header-heading'][position()=3]";
 	}
 	
 	// ********************** Expand View Widget Validation ********************************************
 	
 	private String Expand(String id) {
 		return "xpath = //div[@id='"+id+"']/ancestor::div[@class='card-body']/preceding-sibling::div/descendant::span[@class='icon-class'][position()=3]";
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
  
	//Colors Reading    
    
    private String RowColor1(String id) {
    	return "xpath = //div[@id='"+id+"']/ancestor::div[@class='graph']/descendant::div[@class='table-body']/descendant::span[@class='dot'][position()=1]";
    }
   
}