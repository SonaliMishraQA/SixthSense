package objectRepository.MQM;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;

import genericUtilities.ExcelUtility;
import genericUtilities.GenericMethods;

public class MQKafka_Broker_Page 
{
	Page page;
	GenericMethods util = new GenericMethods();
	ExcelUtility excel = new ExcelUtility();
	
	
	private String SelectMessageQueueDropdown = "#btn-arrow-down-mq-select-message-queue";
	private String SelectSearchFieldMQDropdown = "#input-search-sel-mq-select-message-queue";
	private String SelectMQDropdown = "#mq-select-message-queue-0-single";
	private String SelectServiceNameDropdown = "#btn-arrow-down-mq-select-service-name";
//	private String SelectSearchFieldServiceNameDropdown = "#input-search-sel-mq-select-service-name";
//	private String SelectApplicationDropdown = "#mq-select-service-name-1-single";
//	
	private String calenderView = "xpath = //div[@class='selected-text ellipsis bg-text']";
	private String BrokerTab = "xpath = //div[@class='navtab']/div[@class='item' and position()=4]/child::div";	
	private String TopicTab = "xpath = //div[@class='kafkaTabItem kafkaActiveTab']";
	private String BrokerMetricsTab = "xpath = //div[@class='kafkaTabItem'][position()=1]";
	 
    //Broker > Topic Metrics
	private String TopicBytesInPerSecondID = "apexchartschart-kafka_broker_topic_bytes_in_per_sec";
	private String TopicBytesInPerSecondMeanValueID = "apexchartschart-kafka_broker_topic_bytes_in_per_sec_mean_rate";
	private String TopicBytesOutPerSecondID = "apexchartschart-kafka_broker_topic_bytes_out_per_sec";
	private String TopicBytesOutPerSecondMeanValueID = "apexchartschart-kafka_broker_topic_bytes_out_per_sec_mean_rate";
	private String TopicMessageCountID = "apexchartschart-kafka_messages_in_per_sec_count_topic";
	
  	//Broker > Broker Metrics
	private String BrokerMetricsJVMCPUID = "apexchartschart-kafka_broker_topic_bytes_in_per_sec";
	private String BrokerMetricsJVMMemoryID = "apexchartschart-kafka_broker_jvm_memory_heapxkafka_broker_jvm_memory_non_heap";
	private String BrokerMetricsGCTimeID = "apexchartschart-kafka_jvm_young_gc_timexkafka_jvm_old_gc_time";
	private String BrokerMetricsGCCountID = "apexchartschart-kafka_jvm_young_gc_countxkafka_jvm_old_gc_count";
	private String BrokerMetricsThreadCountID = "apexchartschart-kafka_messages_in_per_sec_count_topic";
	private String BrokerMetricsMessageCountID = "apexchartschart-kafka_broker_messages_in_per_sec_count";
	
	public List<String> WidgetXValues(String XValue){
    	ArrayList<String> xValue = new ArrayList<String>();
    	xValue.add(XValue);
    	return xValue;
	}
	
	public MQKafka_Broker_Page(Page page) {
		this.page = page;
	}

	public void navigateToKafka() {
		util.selectTheOptionFromDropDownBySearch(page, SelectMessageQueueDropdown, SelectSearchFieldMQDropdown, "Kafka",  SelectMQDropdown);
		page.waitForLoadState(LoadState.NETWORKIDLE);
		//util.selectTheOptionFromDropDown(page, SelectMessageQueueDropdown, "Kafka");
	}	
	
	public void selectServiceName() {
		util.selectTheOptionFromDropDown(page, SelectServiceNameDropdown, "dev-sanity");
		page.waitForLoadState(LoadState.NETWORKIDLE);
	}	
	/*public void selectServiceName() {
	util.selectTheOptionFromDropDownBySearch(page, SelectServiceNameDropdown, SelectSearchFieldServiceNameDropdown, "KafkaV410", SelectApplicationDropdown);
	page.waitForLoadState(LoadState.NETWORKIDLE);
}	*/
	
	public void navigateToBrokerTab() {
		page.locator(BrokerTab).click();
		page.waitForLoadState(LoadState.NETWORKIDLE);
	}
	
	public void validateBrokerTitle(String expectedTitle) {
    	String actualTitle = page.locator(BrokerTab).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    	page.waitForLoadState(LoadState.NETWORKIDLE);
    }
	
	
//Topic > Bytes In Per Second Graph
	
	public void validateTopicTabTitle(String expectedTitle) {
    	String actualTitle = page.locator(TopicTab).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
	
	public void validateTopicBytesInPerSecondGraphTitle(String expectedTitle) {
    	String actualTitle = page.locator(getWidgetTitle(TopicBytesInPerSecondID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
	
	public void validateTopicBytesInPerSecondGraphZoomInBtn() {
		 
		util.graphZoomIn(page,ZoomIn(TopicBytesInPerSecondID), TopicBytesInPerSecondID);
	}
	
	public void validateTopicBytesInPerSecondGraphZoomOutBtn() {
		 
		util.graphZoomOut(page,ZoomIn(TopicBytesInPerSecondID),ZoomOut(TopicBytesInPerSecondID), TopicBytesInPerSecondID);
	}
	
	public void validateTopicBytesInPerSecondXaxisValues() {
		 
		util.validateTheGraphdisplayingTheDataAsPerGivenTimeLines(page, XaxisValues(TopicBytesInPerSecondID), calenderView, WidgetXValues(XaxisValues(TopicBytesInPerSecondID)));
	}
	
	public void validateTopicBytesInPerSecondGraphXaxisTitle(String expectedTitle) {
    	String actualTitle = page.locator(XaxisTitle(TopicBytesInPerSecondID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
	
	public void validateTopicBytesInPerSecondGraphYaxisTitle(String expectedTitle) {
    	String actualTitle = page.locator(YaxisTitle(TopicBytesInPerSecondID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
	
	public void validateTopicBytesInPerSecondGraphTopicHeaderTitle(String expectedTitle) {
    	String actualTitle = page.locator(HeaderTitle(TopicBytesInPerSecondID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
	
	public void validateTopicBytesInPerSecondGraphAvgHeaderTitle(String expectedTitle) {
    	String actualTitle = page.locator(AvgHeader(TopicBytesInPerSecondID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
	
	public void validateTopicBytesInPerSecondGraphMaxHeaderTitle(String expectedTitle) {
    	String actualTitle = page.locator(MaxHeader(TopicBytesInPerSecondID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
	
	public void validateTopicBytesInPerSecondGraphRowColor(String expectedTitle) {
    	String actualTitle = page.locator(RowColor(TopicBytesInPerSecondID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
	
	public void validateTopicBytesInPerSecondToolTipTitle() {
        util.validateWidgetToolTips(page, XaxisLines(TopicBytesInPerSecondID), ToolTipTitle(TopicBytesInPerSecondID));
    }
  
	public void validateTopicBytesInPerSecondExpandViewXAxisTitle() {
		util.validateExpandViewTexts(page, XaxisTitle(TopicBytesInPerSecondID), Expand(TopicBytesInPerSecondID), expandViewCloseBtn, expandViewXaxisTitle);
	}

	public void validateTopicBytesInPerSecondExpandViewYAxisTitle() {
		util.validateExpandViewTexts(page, YaxisTitle(TopicBytesInPerSecondID), Expand(TopicBytesInPerSecondID), expandViewCloseBtn, expandViewYaxisTitle);
	}
	
	public void validateTopicBytesInPerSecondExpandViewWidgetTitle() {
		util.validateExpandViewTexts(page, getWidgetTitle(TopicBytesInPerSecondID), Expand(TopicBytesInPerSecondID), expandViewCloseBtn, expandViewWidgetTitle);
	}
	
	public void validateTopicBytesInPerSecondExpandViewLegendHeader1() {
		util.validateExpandViewTexts(page, LegendColumn1Title(TopicBytesInPerSecondID), Expand(TopicBytesInPerSecondID), expandViewCloseBtn, expandViewLegendColumn1HeaderTitle);
	}
	
	public void validateTopicBytesInPerSecondExpandViewLegendHeader2() {
		util.validateExpandViewTexts(page, LegendColumn2Title(TopicBytesInPerSecondID), Expand(TopicBytesInPerSecondID), expandViewCloseBtn, expandViewLegendColumn2HeaderTitle);
	}
	
	public void validateTopicBytesInPerSecondExpandViewLegendHeader3() {
		util.validateExpandViewTexts(page, LegendColumn3Title(TopicBytesInPerSecondID), Expand(TopicBytesInPerSecondID), expandViewCloseBtn, expandViewLegendColumn3HeaderTitle);
	}
	
	public void validateTopicBytesInPerSecondExpandViewLegendHeader2InforMessage() {
		util.validateExpandViewTexts(page, LegendColumn2Title(TopicBytesInPerSecondID), Expand(TopicBytesInPerSecondID), expandViewCloseBtn, expandViewLegendColumnHeader2infoMessage);
	}
	
	public void validateTopicBytesInPerSecondExpandViewLegendHeader3InforMessage() {
		util.validateExpandViewTexts(page, LegendColumn3Title(TopicBytesInPerSecondID), Expand(TopicBytesInPerSecondID), expandViewCloseBtn, expandViewLegendColumnHeader3infoMessage);
	}
	
	public void validateTopicBytesInPerSecondExpandViewZoomIn() {
		util.ExpandViewZoomInBtn(page, expandViewZoomInBtn, Expand(TopicBytesInPerSecondID), expandViewCloseBtn, expandViewXaxisValues);
	}
	
	public void validateTopicBytesInPerSecondExpandViewZoomOut() {
		util.ExpandViewZoomOutBtn(page, expandViewZoomInBtn, Expand(TopicBytesInPerSecondID), expandViewCloseBtn, expandViewZoomOutBtn, expandViewXaxisValues);
	}
	
	public void validateTopicBytesInPerSecondExpandViewWidgetDragDrop() {
		util.ExpandViewWidgetDragDrop(page, Expand(TopicBytesInPerSecondID), expandViewCloseBtn, expandViewXaxisLines, expandViewZoomOutBtn, expandViewXaxisValues);
	}

	
//Topic > Bytes In Per Second Mean Value Graph
	
	public void validateTopicBytesInPerSecondMeanValueGraphTitle(String expectedTitle) {
    	String actualTitle = page.locator(getWidgetTitle(TopicBytesInPerSecondMeanValueID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
	
	public void validateTopicBytesInPerSecondMeanValueGraphZoomInBtn() {
		 
		util.graphZoomIn(page,ZoomIn(TopicBytesInPerSecondMeanValueID), TopicBytesInPerSecondMeanValueID);
	}
	
	public void validateTopicBytesInPerSecondMeanValueGraphZoomOutBtn() {
		 
		util.graphZoomOut(page,ZoomIn(TopicBytesInPerSecondMeanValueID),ZoomOut(TopicBytesInPerSecondMeanValueID), TopicBytesInPerSecondMeanValueID);
	}
	
	public void validateTopicBytesInPerSecondMeanValueXaxisValues() {
		 
		util.validateTheGraphdisplayingTheDataAsPerGivenTimeLines(page, XaxisValues(TopicBytesInPerSecondMeanValueID), calenderView, WidgetXValues(XaxisValues(TopicBytesInPerSecondMeanValueID)));
	}
	
	public void validateTopicBytesInPerSecondMeanValueGraphXaxisTitle(String expectedTitle) {
    	String actualTitle = page.locator(XaxisTitle(TopicBytesInPerSecondMeanValueID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
	
	public void validateTopicBytesInPerSecondMeanValueGraphYaxisTitle(String expectedTitle) {
    	String actualTitle = page.locator(YaxisTitle(TopicBytesInPerSecondMeanValueID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
	
	public void validateTopicBytesInPerSecondMeanValueGraphTopicHeaderTitle(String expectedTitle) {
    	String actualTitle = page.locator(HeaderTitle(TopicBytesInPerSecondMeanValueID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
	
	public void validateTopicBytesInPerSecondMeanValueGraphAvgHeaderTitle(String expectedTitle) {
    	String actualTitle = page.locator(AvgHeader(TopicBytesInPerSecondMeanValueID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
	
	public void validateTopicBytesInPerSecondMeanValueGraphMaxHeaderTitle(String expectedTitle) {
    	String actualTitle = page.locator(MaxHeader(TopicBytesInPerSecondMeanValueID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
	
	public void validateTopicBytesInPerSecondMeanValueGraphRowColor(String expectedTitle) {
    	String actualTitle = page.locator(RowColor(TopicBytesInPerSecondMeanValueID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
	
	public void validateTopicBytesInPerSecondMeanValueToolTipTitle() {
        util.validateWidgetToolTips(page, XaxisLines(TopicBytesInPerSecondMeanValueID), ToolTipTitle(TopicBytesInPerSecondMeanValueID));
    }
  
	public void validateTopicBytesInPerSecondMeanValueExpandViewXAxisTitle() {
		util.validateExpandViewTexts(page, XaxisTitle(TopicBytesInPerSecondMeanValueID), Expand(TopicBytesInPerSecondMeanValueID), expandViewCloseBtn, expandViewXaxisTitle);
	}

	public void validateTopicBytesInPerSecondMeanValueExpandViewYAxisTitle() {
		util.validateExpandViewTexts(page, YaxisTitle(TopicBytesInPerSecondMeanValueID), Expand(TopicBytesInPerSecondMeanValueID), expandViewCloseBtn, expandViewYaxisTitle);
	}
	
	public void validateTopicBytesInPerSecondMeanValueExpandViewWidgetTitle() {
		util.validateExpandViewTexts(page, getWidgetTitle(TopicBytesInPerSecondMeanValueID), Expand(TopicBytesInPerSecondMeanValueID), expandViewCloseBtn, expandViewWidgetTitle);
	}
	
	public void validateTopicBytesInPerSecondMeanValueExpandViewLegendHeader1() {
		util.validateExpandViewTexts(page, LegendColumn1Title(TopicBytesInPerSecondMeanValueID), Expand(TopicBytesInPerSecondMeanValueID), expandViewCloseBtn, expandViewLegendColumn1HeaderTitle);
	}
	
	public void validateTopicBytesInPerSecondMeanValueExpandViewLegendHeader2() {
		util.validateExpandViewTexts(page, LegendColumn2Title(TopicBytesInPerSecondMeanValueID), Expand(TopicBytesInPerSecondMeanValueID), expandViewCloseBtn, expandViewLegendColumn2HeaderTitle);
	}
	
	public void validateTopicBytesInPerSecondMeanValueExpandViewLegendHeader3() {
		util.validateExpandViewTexts(page, LegendColumn3Title(TopicBytesInPerSecondMeanValueID), Expand(TopicBytesInPerSecondMeanValueID), expandViewCloseBtn, expandViewLegendColumn3HeaderTitle);
	}
	
	public void validateTopicBytesInPerSecondMeanValueExpandViewLegendHeader2InforMessage() {
		util.validateExpandViewTexts(page, LegendColumn2Title(TopicBytesInPerSecondMeanValueID), Expand(TopicBytesInPerSecondMeanValueID), expandViewCloseBtn, expandViewLegendColumnHeader2infoMessage);
	}
	
	public void validateTopicBytesInPerSecondMeanValueExpandViewLegendHeader3InforMessage() {
		util.validateExpandViewTexts(page, LegendColumn3Title(TopicBytesInPerSecondMeanValueID), Expand(TopicBytesInPerSecondMeanValueID), expandViewCloseBtn, expandViewLegendColumnHeader3infoMessage);
	}
	
	public void validateTopicBytesInPerSecondMeanValueExpandViewZoomIn() {
		util.ExpandViewZoomInBtn(page, expandViewZoomInBtn, Expand(TopicBytesInPerSecondMeanValueID), expandViewCloseBtn, expandViewXaxisValues);
	}
	
	public void validateTopicBytesInPerSecondMeanValueExpandViewZoomOut() {
		util.ExpandViewZoomOutBtn(page, expandViewZoomInBtn, Expand(TopicBytesInPerSecondMeanValueID), expandViewCloseBtn, expandViewZoomOutBtn, expandViewXaxisValues);
	}
	
	public void validateTopicBytesInPerSecondMeanValueExpandViewWidgetDragDrop() {
		util.ExpandViewWidgetDragDrop(page, Expand(TopicBytesInPerSecondMeanValueID), expandViewCloseBtn, expandViewXaxisLines, expandViewZoomOutBtn, expandViewXaxisValues);
	}

//Topic > Bytes Out Per Second Graph
	
	public void validateTopicBytesOutPerSecondGraphTitle(String expectedTitle) {
    	String actualTitle = page.locator(getWidgetTitle(TopicBytesOutPerSecondID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
	
	public void validateTopicBytesOutPerSecondGraphZoomInBtn() {
		 
		util.graphZoomIn(page,ZoomIn(TopicBytesOutPerSecondID), TopicBytesOutPerSecondID);
	}
	
	public void validateTopicBytesOutPerSecondGraphZoomOutBtn() {
		 
		util.graphZoomOut(page,ZoomIn(TopicBytesOutPerSecondID),ZoomOut(TopicBytesOutPerSecondID), TopicBytesOutPerSecondID);
	}
	
	
	public void validateTopicBytesOutPerSecondXaxisValues() {
		 
		util.validateTheGraphdisplayingTheDataAsPerGivenTimeLines(page, XaxisValues(TopicBytesOutPerSecondID), calenderView, WidgetXValues(XaxisValues(TopicBytesOutPerSecondID)));
	}
	
	public void validateTopicBytesOutPerSecondGraphXaxisTitle(String expectedTitle) {
    	String actualTitle = page.locator(XaxisTitle(TopicBytesOutPerSecondID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
	
	public void validateTopicBytesOutPerSecondGraphYaxisTitle(String expectedTitle) {
    	String actualTitle = page.locator(YaxisTitle(TopicBytesOutPerSecondID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
	
	public void validateTopicBytesOutPerSecondGraphTopicHeaderTitle(String expectedTitle) {
    	String actualTitle = page.locator(HeaderTitle(TopicBytesOutPerSecondID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
	
	public void validateTopicBytesOutPerSecondGraphAvgHeaderTitle(String expectedTitle) {
    	String actualTitle = page.locator(AvgHeader(TopicBytesOutPerSecondID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
	
	public void validateTopicBytesOutPerSecondGraphMaxHeaderTitle(String expectedTitle) {
    	String actualTitle = page.locator(MaxHeader(TopicBytesOutPerSecondID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
	
	public void validateTopicBytesOutPerSecondGraphRowColor(String expectedTitle) {
    	String actualTitle = page.locator(RowColor(TopicBytesOutPerSecondID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
	
	public void validateTopicBytesOutPerSecondToolTipTitle() {
        util.validateWidgetToolTips(page, XaxisLines(TopicBytesOutPerSecondID), ToolTipTitle(TopicBytesOutPerSecondID));
    }
  
	public void validateTopicBytesOutPerSecondExpandViewXAxisTitle() {
		util.validateExpandViewTexts(page, XaxisTitle(TopicBytesOutPerSecondID), Expand(TopicBytesOutPerSecondID), expandViewCloseBtn, expandViewXaxisTitle);
	}

	public void validateTopicBytesOutPerSecondExpandViewYAxisTitle() {
		util.validateExpandViewTexts(page, YaxisTitle(TopicBytesOutPerSecondID), Expand(TopicBytesOutPerSecondID), expandViewCloseBtn, expandViewYaxisTitle);
	}
	
	public void validateTopicBytesOutPerSecondExpandViewWidgetTitle() {
		util.validateExpandViewTexts(page, getWidgetTitle(TopicBytesOutPerSecondID), Expand(TopicBytesOutPerSecondID), expandViewCloseBtn, expandViewWidgetTitle);
	}
	
	public void validateTopicBytesOutPerSecondExpandViewLegendHeader1() {
		util.validateExpandViewTexts(page, LegendColumn1Title(TopicBytesOutPerSecondID), Expand(TopicBytesOutPerSecondID), expandViewCloseBtn, expandViewLegendColumn1HeaderTitle);
	}
	
	public void validateTopicBytesOutPerSecondExpandViewLegendHeader2() {
		util.validateExpandViewTexts(page, LegendColumn2Title(TopicBytesOutPerSecondID), Expand(TopicBytesOutPerSecondID), expandViewCloseBtn, expandViewLegendColumn2HeaderTitle);
	}
	
	public void validateTopicBytesOutPerSecondExpandViewLegendHeader3() {
		util.validateExpandViewTexts(page, LegendColumn3Title(TopicBytesOutPerSecondID), Expand(TopicBytesOutPerSecondID), expandViewCloseBtn, expandViewLegendColumn3HeaderTitle);
	}
	
	public void validateTopicBytesOutPerSecondExpandViewLegendHeader2InforMessage() {
		util.validateExpandViewTexts(page, LegendColumn2Title(TopicBytesOutPerSecondID), Expand(TopicBytesOutPerSecondID), expandViewCloseBtn, expandViewLegendColumnHeader2infoMessage);
	}
	
	public void validateTopicBytesOutPerSecondExpandViewLegendHeader3InforMessage() {
		util.validateExpandViewTexts(page, LegendColumn3Title(TopicBytesOutPerSecondID), Expand(TopicBytesOutPerSecondID), expandViewCloseBtn, expandViewLegendColumnHeader3infoMessage);
	}
	
	public void validateTopicBytesOutPerSecondExpandViewZoomIn() {
		util.ExpandViewZoomInBtn(page, expandViewZoomInBtn, Expand(TopicBytesOutPerSecondID), expandViewCloseBtn, expandViewXaxisValues);
	}
	
	public void validateTopicBytesOutPerSecondExpandViewZoomOut() {
		util.ExpandViewZoomOutBtn(page, expandViewZoomInBtn, Expand(TopicBytesOutPerSecondID), expandViewCloseBtn, expandViewZoomOutBtn, expandViewXaxisValues);
	}
	
	public void validateTopicBytesOutPerSecondExpandViewWidgetDragDrop() {
		util.ExpandViewWidgetDragDrop(page, Expand(TopicBytesOutPerSecondID), expandViewCloseBtn, expandViewXaxisLines, expandViewZoomOutBtn, expandViewXaxisValues);
	}

//Topic > Bytes Out Per Second Mean Value Graph
	
	public void validateTopicBytesOutPerSecondMeanValueGraphTitle(String expectedTitle) {
    	String actualTitle = page.locator(getWidgetTitle(TopicBytesOutPerSecondMeanValueID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
	
	public void validateTopicBytesOutPerSecondMeanValueGraphZoomInBtn() {
		 
		util.graphZoomIn(page,ZoomIn(TopicBytesOutPerSecondMeanValueID), TopicBytesOutPerSecondMeanValueID);
	}
	
	public void validateTopicBytesOutPerSecondMeanValueGraphZoomOutBtn() {
		 
		util.graphZoomOut(page,ZoomIn(TopicBytesOutPerSecondMeanValueID),ZoomOut(TopicBytesOutPerSecondMeanValueID), TopicBytesOutPerSecondMeanValueID);
	}
	
	public void validateTopicBytesOutPerSecondMeanValueXaxisValues() {
		 
		util.validateTheGraphdisplayingTheDataAsPerGivenTimeLines(page, XaxisValues(TopicBytesOutPerSecondMeanValueID), calenderView, WidgetXValues(XaxisValues(TopicBytesOutPerSecondMeanValueID)));
	}
	
	public void validateTopicBytesOutPerSecondMeanValueGraphXaxisTitle(String expectedTitle) {
    	String actualTitle = page.locator(XaxisTitle(TopicBytesOutPerSecondMeanValueID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
	
	public void validateTopicBytesOutPerSecondMeanValueGraphYaxisTitle(String expectedTitle) {
    	String actualTitle = page.locator(YaxisTitle(TopicBytesOutPerSecondMeanValueID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
	
	public void validateTopicBytesOutPerSecondMeanValueGraphTopicHeaderTitle(String expectedTitle) {
    	String actualTitle = page.locator(HeaderTitle(TopicBytesOutPerSecondMeanValueID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
	
	public void validateTopicBytesOutPerSecondMeanValueGraphAvgHeaderTitle(String expectedTitle) {
    	String actualTitle = page.locator(AvgHeader(TopicBytesOutPerSecondMeanValueID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
	
	public void validateTopicBytesOutPerSecondMeanValueGraphMaxHeaderTitle(String expectedTitle) {
    	String actualTitle = page.locator(MaxHeader(TopicBytesOutPerSecondMeanValueID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
	
	public void validateTopicBytesOutPerSecondMeanValueGraphRowColor(String expectedTitle) {
    	String actualTitle = page.locator(RowColor(TopicBytesOutPerSecondMeanValueID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
	
	public void validateTopicBytesOutPerSecondMeanValueToolTipTitle() {
        util.validateWidgetToolTips(page, XaxisLines(TopicBytesOutPerSecondMeanValueID), ToolTipTitle(TopicBytesOutPerSecondMeanValueID));
    }
  
	public void validateTopicBytesOutPerSecondMeanValueExpandViewXAxisTitle() {
		util.validateExpandViewTexts(page, XaxisTitle(TopicBytesOutPerSecondMeanValueID), Expand(TopicBytesOutPerSecondMeanValueID), expandViewCloseBtn, expandViewXaxisTitle);
	}

	public void validateTopicBytesOutPerSecondMeanValueExpandViewYAxisTitle() {
		util.validateExpandViewTexts(page, YaxisTitle(TopicBytesOutPerSecondMeanValueID), Expand(TopicBytesOutPerSecondMeanValueID), expandViewCloseBtn, expandViewYaxisTitle);
	}
	
	public void validateTopicBytesOutPerSecondMeanValueExpandViewWidgetTitle() {
		util.validateExpandViewTexts(page, getWidgetTitle(TopicBytesOutPerSecondMeanValueID), Expand(TopicBytesOutPerSecondMeanValueID), expandViewCloseBtn, expandViewWidgetTitle);
	}
	
	public void validateTopicBytesOutPerSecondMeanValueExpandViewLegendHeader1() {
		util.validateExpandViewTexts(page, LegendColumn1Title(TopicBytesOutPerSecondMeanValueID), Expand(TopicBytesOutPerSecondMeanValueID), expandViewCloseBtn, expandViewLegendColumn1HeaderTitle);
	}
	
	public void validateTopicBytesOutPerSecondMeanValueExpandViewLegendHeader2() {
		util.validateExpandViewTexts(page, LegendColumn2Title(TopicBytesOutPerSecondMeanValueID), Expand(TopicBytesOutPerSecondMeanValueID), expandViewCloseBtn, expandViewLegendColumn2HeaderTitle);
	}
	
	public void validateTopicBytesOutPerSecondMeanValueExpandViewLegendHeader3() {
		util.validateExpandViewTexts(page, LegendColumn3Title(TopicBytesOutPerSecondMeanValueID), Expand(TopicBytesOutPerSecondMeanValueID), expandViewCloseBtn, expandViewLegendColumn3HeaderTitle);
	}
	
	public void validateTopicBytesOutPerSecondMeanValueExpandViewLegendHeader2InforMessage() {
		util.validateExpandViewTexts(page, LegendColumn2Title(TopicBytesOutPerSecondMeanValueID), Expand(TopicBytesOutPerSecondMeanValueID), expandViewCloseBtn, expandViewLegendColumnHeader2infoMessage);
	}
	
	public void validateTopicBytesOutPerSecondMeanValueExpandViewLegendHeader3InforMessage() {
		util.validateExpandViewTexts(page, LegendColumn3Title(TopicBytesOutPerSecondMeanValueID), Expand(TopicBytesOutPerSecondMeanValueID), expandViewCloseBtn, expandViewLegendColumnHeader3infoMessage);
	}
	
	public void validateTopicBytesOutPerSecondMeanValueExpandViewZoomIn() {
		util.ExpandViewZoomInBtn(page, expandViewZoomInBtn, Expand(TopicBytesOutPerSecondMeanValueID), expandViewCloseBtn, expandViewXaxisValues);
	}
	
	public void validateTopicBytesOutPerSecondMeanValueExpandViewZoomOut() {
		util.ExpandViewZoomOutBtn(page, expandViewZoomInBtn, Expand(TopicBytesOutPerSecondMeanValueID), expandViewCloseBtn, expandViewZoomOutBtn, expandViewXaxisValues);
	}
	
	public void validateTopicBytesOutPerSecondMeanValueExpandViewWidgetDragDrop() {
		util.ExpandViewWidgetDragDrop(page, Expand(TopicBytesOutPerSecondMeanValueID), expandViewCloseBtn, expandViewXaxisLines, expandViewZoomOutBtn, expandViewXaxisValues);
	}

//Topic > Message Count Graph
	
	public void validateTopicMessageCountGraphTitle(String expectedTitle) {
    	String actualTitle = page.locator(getWidgetTitle(TopicMessageCountID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
	
	public void validateTopicMessageCountGraphZoomInBtn() {
		 
		util.graphZoomIn(page,ZoomIn(TopicMessageCountID), TopicMessageCountID);
	}
	
	public void validateTopicMessageCountGraphZoomOutBtn() {
		 
		util.graphZoomOut(page,ZoomIn(TopicMessageCountID),ZoomOut(TopicMessageCountID), TopicMessageCountID);
	}
	
	public void validateTopicMessageCountXaxisValues() {
		 
		util.validateTheGraphdisplayingTheDataAsPerGivenTimeLines(page, XaxisValues(TopicMessageCountID), calenderView, WidgetXValues(XaxisValues(TopicMessageCountID)));
	}
	
	public void validateTopicMessageCountGraphXaxisTitle(String expectedTitle) {
    	String actualTitle = page.locator(XaxisTitle(TopicMessageCountID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
	
	public void validateTopicMessageCountGraphYaxisTitle(String expectedTitle) {
    	String actualTitle = page.locator(YaxisTitle(TopicMessageCountID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
	
	public void validateTopicMessageCountGraphTopicHeaderTitle(String expectedTitle) {
    	String actualTitle = page.locator(HeaderTitle(TopicMessageCountID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
	
	public void validateTopicMessageCountGraphAvgHeaderTitle(String expectedTitle) {
    	String actualTitle = page.locator(AvgHeader(TopicMessageCountID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
	
	public void validateTopicMessageCountGraphMaxHeaderTitle(String expectedTitle) {
    	String actualTitle = page.locator(MaxHeader(TopicMessageCountID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
	
	public void validateTopicMessageCountGraphRowColor(String expectedTitle) {
    	String actualTitle = page.locator(RowColor(TopicMessageCountID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
	
	public void validateTopicMessageCountToolTipTitle() {
        util.validateWidgetToolTips(page, XaxisLines(TopicMessageCountID), ToolTipTitle(TopicMessageCountID));
    }
  
	public void validateTopicMessageCountExpandViewXAxisTitle() {
		util.validateExpandViewTexts(page, XaxisTitle(TopicMessageCountID), Expand(TopicMessageCountID), expandViewCloseBtn, expandViewXaxisTitle);
	}

	public void validateTopicMessageCountExpandViewYAxisTitle() {
		util.validateExpandViewTexts(page, YaxisTitle(TopicMessageCountID), Expand(TopicMessageCountID), expandViewCloseBtn, expandViewYaxisTitle);
	}
	
	public void validateTopicMessageCountExpandViewWidgetTitle() {
		util.validateExpandViewTexts(page, getWidgetTitle(TopicMessageCountID), Expand(TopicMessageCountID), expandViewCloseBtn, expandViewWidgetTitle);
	}
	
	public void validateTopicMessageCountExpandViewLegendHeader1() {
		util.validateExpandViewTexts(page, LegendColumn1Title(TopicMessageCountID), Expand(TopicMessageCountID), expandViewCloseBtn, expandViewLegendColumn1HeaderTitle);
	}
	
	public void validateTopicMessageCountExpandViewLegendHeader2() {
		util.validateExpandViewTexts(page, LegendColumn2Title(TopicMessageCountID), Expand(TopicMessageCountID), expandViewCloseBtn, expandViewLegendColumn2HeaderTitle);
	}
	
	public void validateTopicMessageCountExpandViewLegendHeader3() {
		util.validateExpandViewTexts(page, LegendColumn3Title(TopicMessageCountID), Expand(TopicMessageCountID), expandViewCloseBtn, expandViewLegendColumn3HeaderTitle);
	}
	
	public void validateTopicMessageCountExpandViewLegendHeader2InforMessage() {
		util.validateExpandViewTexts(page, LegendColumn2Title(TopicMessageCountID), Expand(TopicMessageCountID), expandViewCloseBtn, expandViewLegendColumnHeader2infoMessage);
	}
	
	public void validateTopicMessageCountExpandViewLegendHeader3InforMessage() {
		util.validateExpandViewTexts(page, LegendColumn3Title(TopicMessageCountID), Expand(TopicMessageCountID), expandViewCloseBtn, expandViewLegendColumnHeader3infoMessage);
	}
	
	public void validateTopicMessageCountExpandViewZoomIn() {
		util.ExpandViewZoomInBtn(page, expandViewZoomInBtn, Expand(TopicMessageCountID), expandViewCloseBtn, expandViewXaxisValues);
	}
	
	public void validateTopicMessageCountExpandViewZoomOut() {
		util.ExpandViewZoomOutBtn(page, expandViewZoomInBtn, Expand(TopicMessageCountID), expandViewCloseBtn, expandViewZoomOutBtn, expandViewXaxisValues);
	}
	
	public void validateTopicMessageCountExpandViewWidgetDragDrop() {
		util.ExpandViewWidgetDragDrop(page, Expand(TopicMessageCountID), expandViewCloseBtn, expandViewXaxisLines, expandViewZoomOutBtn, expandViewXaxisValues);
	}

	
//Broker Metrics  > JVM CPU Graph
	
	public void validateBrokerMetricsTabTitle(String expectedTitle) {
    	String actualTitle = page.locator(BrokerMetricsTab).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
	
	public void clickOnBrokerMetricsTab() {
		page.locator(BrokerMetricsTab).click();
		String actualTitle = page.locator("//div[@class='kafkaTabItem kafkaActiveTab']").textContent().trim();
		Assert.assertEquals(actualTitle.equalsIgnoreCase("Broker metrics"),true);	
	}
	
	public void validateBrokerMetricsJVMCPUGraphTitle(String expectedTitle) {
    	String actualTitle = page.locator(getWidgetTitle(BrokerMetricsJVMCPUID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
	
	public void validateBrokerMetricsJVMCPUGraphZoomInBtn() {
		 
		util.graphZoomIn(page,ZoomIn(BrokerMetricsJVMCPUID), BrokerMetricsJVMCPUID);
	}
	
	public void validateBrokerMetricsJVMCPUGraphZoomOutBtn() {
		 
		util.graphZoomOut(page,ZoomIn(BrokerMetricsJVMCPUID),ZoomOut(BrokerMetricsJVMCPUID), BrokerMetricsJVMCPUID);
	}
	
	public void validateBrokerMetricsJVMCPUXaxisValues() {
		page.waitForTimeout(2000); 
		util.validateTheGraphdisplayingTheDataAsPerGivenTimeLines(page, XaxisValues(BrokerMetricsJVMCPUID), calenderView, WidgetXValues(XaxisValues(BrokerMetricsJVMCPUID)));
	}
	
	public void validateBrokerMetricsJVMCPUGraphXaxisTitle(String expectedTitle) {
    	String actualTitle = page.locator(XaxisTitle(BrokerMetricsJVMCPUID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
	
	public void validateBrokerMetricsJVMCPUGraphYaxisTitle(String expectedTitle) {
    	String actualTitle = page.locator(YaxisTitle(BrokerMetricsJVMCPUID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
	
	public void validateBrokerMetricsJVMCPUGraphBrokerMetricsHeaderTitle(String expectedTitle) {
    	String actualTitle = page.locator(HeaderTitle(BrokerMetricsJVMCPUID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
	
	public void validateBrokerMetricsJVMCPUGraphAvgHeaderTitle(String expectedTitle) {
    	String actualTitle = page.locator(AvgHeader(BrokerMetricsJVMCPUID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
	
	public void validateBrokerMetricsJVMCPUGraphMaxHeaderTitle(String expectedTitle) {
		page.waitForTimeout(1000);
    	String actualTitle = page.locator(MaxHeader(BrokerMetricsJVMCPUID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
	
	public void validateBrokerMetricsJVMCPUGraphRowColor(String expectedTitle) {
		page.waitForTimeout(1000);
    	String actualTitle = page.locator(RowColor(BrokerMetricsJVMCPUID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
	
	public void validateBrokerMetricsJVMCPUToolTipTitle() {
		page.waitForTimeout(1000);
        util.validateWidgetToolTips(page, XaxisLines(BrokerMetricsJVMCPUID), ToolTipTitle(BrokerMetricsJVMCPUID));
    }
  
	public void validateBrokerMetricsJVMCPUExpandViewXAxisTitle() {
		util.validateExpandViewTexts(page, XaxisTitle(BrokerMetricsJVMCPUID), Expand(BrokerMetricsJVMCPUID), expandViewCloseBtn, expandViewXaxisTitle);
	}

	public void validateBrokerMetricsJVMCPUExpandViewYAxisTitle() {
		util.validateExpandViewTexts(page, YaxisTitle(BrokerMetricsJVMCPUID), Expand(BrokerMetricsJVMCPUID), expandViewCloseBtn, expandViewYaxisTitle);
	}
	
	public void validateBrokerMetricsJVMCPUExpandViewWidgetTitle() {
		util.validateExpandViewTexts(page, getWidgetTitle(BrokerMetricsJVMCPUID), Expand(BrokerMetricsJVMCPUID), expandViewCloseBtn, expandViewWidgetTitle);
	}
	
	public void validateBrokerMetricsJVMCPUExpandViewLegendHeader1() {
		util.validateExpandViewTexts(page, LegendColumn1Title(BrokerMetricsJVMCPUID), Expand(BrokerMetricsJVMCPUID), expandViewCloseBtn, expandViewLegendColumn1HeaderTitle);
	}
	
	public void validateBrokerMetricsJVMCPUExpandViewLegendHeader2() {
		util.validateExpandViewTexts(page, LegendColumn2Title(BrokerMetricsJVMCPUID), Expand(BrokerMetricsJVMCPUID), expandViewCloseBtn, expandViewLegendColumn2HeaderTitle);
	}
	
	public void validateBrokerMetricsJVMCPUExpandViewLegendHeader3() {
		util.validateExpandViewTexts(page, LegendColumn3Title(BrokerMetricsJVMCPUID), Expand(BrokerMetricsJVMCPUID), expandViewCloseBtn, expandViewLegendColumn3HeaderTitle);
	}
	
	public void validateBrokerMetricsJVMCPUExpandViewLegendHeader2InforMessage() {
		util.validateExpandViewTexts(page, LegendColumn2Title(BrokerMetricsJVMCPUID), Expand(BrokerMetricsJVMCPUID), expandViewCloseBtn, expandViewLegendColumnHeader2infoMessage);
	}
	
	public void validateBrokerMetricsJVMCPUExpandViewLegendHeader3InforMessage() {
		util.validateExpandViewTexts(page, LegendColumn3Title(BrokerMetricsJVMCPUID), Expand(BrokerMetricsJVMCPUID), expandViewCloseBtn, expandViewLegendColumnHeader3infoMessage);
	}
	
	public void validateBrokerMetricsJVMCPUExpandViewZoomIn() {
		util.ExpandViewZoomInBtn(page, expandViewZoomInBtn, Expand(BrokerMetricsJVMCPUID), expandViewCloseBtn, expandViewXaxisValues);
	}
	
	public void validateBrokerMetricsJVMCPUExpandViewZoomOut() {
		util.ExpandViewZoomOutBtn(page, expandViewZoomInBtn, Expand(BrokerMetricsJVMCPUID), expandViewCloseBtn, expandViewZoomOutBtn, expandViewXaxisValues);
	}
	
	public void validateBrokerMetricsJVMCPUExpandViewWidgetDragDrop() {
		page.waitForTimeout(1000);
		util.ExpandViewWidgetDragDrop(page, Expand(BrokerMetricsJVMCPUID), expandViewCloseBtn, expandViewXaxisLines, expandViewZoomOutBtn, expandViewXaxisValues);
	}

//Broker Metrics > JVM Memory Graph
	
	public void validateBrokerMetricsJVMMemoryGraphTitle(String expectedTitle) {
    	String actualTitle = page.locator(getWidgetTitle(BrokerMetricsJVMMemoryID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
	
	public void validateBrokerMetricsJVMMemoryGraphZoomInBtn() {
		 
		util.graphZoomIn(page,ZoomIn(BrokerMetricsJVMMemoryID), BrokerMetricsJVMMemoryID);
	}
	
	public void validateBrokerMetricsJVMMemoryGraphZoomOutBtn() {
		 
		util.graphZoomOut(page,ZoomIn(BrokerMetricsJVMMemoryID),ZoomOut(BrokerMetricsJVMMemoryID), BrokerMetricsJVMMemoryID);
	}
	
	public void validateBrokerMetricsJVMMemoryXaxisValues() {
		 
		util.validateTheGraphdisplayingTheDataAsPerGivenTimeLines(page, XaxisValues(BrokerMetricsJVMMemoryID), calenderView, WidgetXValues(XaxisValues(BrokerMetricsJVMMemoryID)));
	}
	
	public void validateBrokerMetricsJVMMemoryGraphXaxisTitle(String expectedTitle) {
    	String actualTitle = page.locator(XaxisTitle(BrokerMetricsJVMMemoryID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
	
	public void validateBrokerMetricsJVMMemoryGraphYaxisTitle(String expectedTitle) {
    	String actualTitle = page.locator(YaxisTitle(BrokerMetricsJVMMemoryID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
	
	public void validateBrokerMetricsJVMMemoryGraphBrokerMetricsHeaderTitle(String expectedTitle) {
    	String actualTitle = page.locator(HeaderTitle(BrokerMetricsJVMMemoryID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
	
	public void validateBrokerMetricsJVMMemoryGraphAvgHeaderTitle(String expectedTitle) {
    	String actualTitle = page.locator(AvgHeader(BrokerMetricsJVMMemoryID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
	
	public void validateBrokerMetricsJVMMemoryGraphMaxHeaderTitle(String expectedTitle) {
    	String actualTitle = page.locator(MaxHeader(BrokerMetricsJVMMemoryID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
	
	public void validateBrokerMetricsJVMMemoryGraphRowColor(String expectedTitle) {
    	String actualTitle = page.locator(RowColor(BrokerMetricsJVMMemoryID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
	
	public void validateBrokerMetricsJVMMemoryToolTipTitle() {
        util.validateWidgetToolTips(page, XaxisLines(BrokerMetricsJVMMemoryID), ToolTipTitle(BrokerMetricsJVMMemoryID));
    }
  
	public void validateBrokerMetricsJVMMemoryExpandViewXAxisTitle() {
		util.validateExpandViewTexts(page, XaxisTitle(BrokerMetricsJVMMemoryID), Expand(BrokerMetricsJVMMemoryID), expandViewCloseBtn, expandViewXaxisTitle);
	}

	public void validateBrokerMetricsJVMMemoryExpandViewYAxisTitle() {
		util.validateExpandViewTexts(page, YaxisTitle(BrokerMetricsJVMMemoryID), Expand(BrokerMetricsJVMMemoryID), expandViewCloseBtn, expandViewYaxisTitle);
	}
	
	public void validateBrokerMetricsJVMMemoryExpandViewWidgetTitle() {
		util.validateExpandViewTexts(page, getWidgetTitle(BrokerMetricsJVMMemoryID), Expand(BrokerMetricsJVMMemoryID), expandViewCloseBtn, expandViewWidgetTitle);
	}
	
	public void validateBrokerMetricsJVMMemoryExpandViewLegendHeader1() {
		util.validateExpandViewTexts(page, LegendColumn1Title(BrokerMetricsJVMMemoryID), Expand(BrokerMetricsJVMMemoryID), expandViewCloseBtn, expandViewLegendColumn1HeaderTitle);
	}
	
	public void validateBrokerMetricsJVMMemoryExpandViewLegendHeader2() {
		util.validateExpandViewTexts(page, LegendColumn2Title(BrokerMetricsJVMMemoryID), Expand(BrokerMetricsJVMMemoryID), expandViewCloseBtn, expandViewLegendColumn2HeaderTitle);
	}
	
	public void validateBrokerMetricsJVMMemoryExpandViewLegendHeader3() {
		util.validateExpandViewTexts(page, LegendColumn3Title(BrokerMetricsJVMMemoryID), Expand(BrokerMetricsJVMMemoryID), expandViewCloseBtn, expandViewLegendColumn3HeaderTitle);
	}
	
	public void validateBrokerMetricsJVMMemoryExpandViewLegendHeader2InforMessage() {
		util.validateExpandViewTexts(page, LegendColumn2Title(BrokerMetricsJVMMemoryID), Expand(BrokerMetricsJVMMemoryID), expandViewCloseBtn, expandViewLegendColumnHeader2infoMessage);
	}
	
	public void validateBrokerMetricsJVMMemoryExpandViewLegendHeader3InforMessage() {
		util.validateExpandViewTexts(page, LegendColumn3Title(BrokerMetricsJVMMemoryID), Expand(BrokerMetricsJVMMemoryID), expandViewCloseBtn, expandViewLegendColumnHeader3infoMessage);
	}
	
	public void validateBrokerMetricsJVMMemoryExpandViewZoomIn() {
		page.waitForTimeout(1000);
		util.ExpandViewZoomInBtn(page, expandViewZoomInBtn, Expand(BrokerMetricsJVMMemoryID), expandViewCloseBtn, expandViewXaxisValues);
	}
	
	public void validateBrokerMetricsJVMMemoryExpandViewZoomOut() {
		util.ExpandViewZoomOutBtn(page, expandViewZoomInBtn, Expand(BrokerMetricsJVMMemoryID), expandViewCloseBtn, expandViewZoomOutBtn, expandViewXaxisValues);
	}
	
	public void validateBrokerMetricsJVMMemoryExpandViewWidgetDragDrop() {
		util.ExpandViewWidgetDragDrop(page, Expand(BrokerMetricsJVMMemoryID), expandViewCloseBtn, expandViewXaxisLines, expandViewZoomOutBtn, expandViewXaxisValues);
	}

//Broker Metrics > GC Time Graph
	
	public void validateBrokerMetricsGCTimeGraphTitle(String expectedTitle) {
    	String actualTitle = page.locator(getWidgetTitle(BrokerMetricsGCTimeID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
	
	public void validateBrokerMetricsGCTimeGraphZoomInBtn() {
		 
		util.graphZoomIn(page,ZoomIn(BrokerMetricsGCTimeID), BrokerMetricsGCTimeID);
	}
	
	public void validateBrokerMetricsGCTimeGraphZoomOutBtn() {
		 
		util.graphZoomOut(page,ZoomIn(BrokerMetricsGCTimeID),ZoomOut(BrokerMetricsGCTimeID), BrokerMetricsGCTimeID);
	}
	
	public void validateBrokerMetricsGCTimeXaxisValues() {
		 
		util.validateTheGraphdisplayingTheDataAsPerGivenTimeLines(page, XaxisValues(BrokerMetricsGCTimeID), calenderView, WidgetXValues(XaxisValues(BrokerMetricsGCTimeID)));
	}
	
	public void validateBrokerMetricsGCTimeGraphXaxisTitle(String expectedTitle) {
    	String actualTitle = page.locator(XaxisTitle(BrokerMetricsGCTimeID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
	
	public void validateBrokerMetricsGCTimeGraphYaxisTitle(String expectedTitle) {
    	String actualTitle = page.locator(YaxisTitle(BrokerMetricsGCTimeID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
	
	public void validateBrokerMetricsGCTimeGraphBrokerMetricsHeaderTitle(String expectedTitle) {
    	String actualTitle = page.locator(HeaderTitle(BrokerMetricsGCTimeID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
	
	public void validateBrokerMetricsGCTimeGraphAvgHeaderTitle(String expectedTitle) {
    	String actualTitle = page.locator(AvgHeader(BrokerMetricsGCTimeID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
	
	public void validateBrokerMetricsGCTimeGraphMaxHeaderTitle(String expectedTitle) {
    	String actualTitle = page.locator(MaxHeader(BrokerMetricsGCTimeID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
	
	public void validateBrokerMetricsGCTimeGraphRowColor(String expectedTitle) {
    	String actualTitle = page.locator(RowColor(BrokerMetricsGCTimeID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
	
	public void validateBrokerMetricsGCTimeToolTipTitle() {
        util.validateWidgetToolTips(page, XaxisLines(BrokerMetricsGCTimeID), ToolTipTitle(BrokerMetricsGCTimeID));
    }
  
	public void validateBrokerMetricsGCTimeExpandViewXAxisTitle() {
		util.validateExpandViewTexts(page, XaxisTitle(BrokerMetricsGCTimeID), Expand(BrokerMetricsGCTimeID), expandViewCloseBtn, expandViewXaxisTitle);
	}

	public void validateBrokerMetricsGCTimeExpandViewYAxisTitle() {
		util.validateExpandViewTexts(page, YaxisTitle(BrokerMetricsGCTimeID), Expand(BrokerMetricsGCTimeID), expandViewCloseBtn, expandViewYaxisTitle);
	}
	
	public void validateBrokerMetricsGCTimeExpandViewWidgetTitle() {
		util.validateExpandViewTexts(page, getWidgetTitle(BrokerMetricsGCTimeID), Expand(BrokerMetricsGCTimeID), expandViewCloseBtn, expandViewWidgetTitle);
	}
	
	public void validateBrokerMetricsGCTimeExpandViewLegendHeader1() {
		util.validateExpandViewTexts(page, LegendColumn1Title(BrokerMetricsGCTimeID), Expand(BrokerMetricsGCTimeID), expandViewCloseBtn, expandViewLegendColumn1HeaderTitle);
	}
	
	public void validateBrokerMetricsGCTimeExpandViewLegendHeader2() {
		util.validateExpandViewTexts(page, LegendColumn2Title(BrokerMetricsGCTimeID), Expand(BrokerMetricsGCTimeID), expandViewCloseBtn, expandViewLegendColumn2HeaderTitle);
	}
	
	public void validateBrokerMetricsGCTimeExpandViewLegendHeader3() {
		util.validateExpandViewTexts(page, LegendColumn3Title(BrokerMetricsGCTimeID), Expand(BrokerMetricsGCTimeID), expandViewCloseBtn, expandViewLegendColumn3HeaderTitle);
	}
	
	public void validateBrokerMetricsGCTimeExpandViewLegendHeader2InforMessage() {
		util.validateExpandViewTexts(page, LegendColumn2Title(BrokerMetricsGCTimeID), Expand(BrokerMetricsGCTimeID), expandViewCloseBtn, expandViewLegendColumnHeader2infoMessage);
	}
	
	public void validateBrokerMetricsGCTimeExpandViewLegendHeader3InforMessage() {
		util.validateExpandViewTexts(page, LegendColumn3Title(BrokerMetricsGCTimeID), Expand(BrokerMetricsGCTimeID), expandViewCloseBtn, expandViewLegendColumnHeader3infoMessage);
	}
	
	public void validateBrokerMetricsGCTimeExpandViewZoomIn() {
		util.ExpandViewZoomInBtn(page, expandViewZoomInBtn, Expand(BrokerMetricsGCTimeID), expandViewCloseBtn, expandViewXaxisValues);
	}
	
	public void validateBrokerMetricsGCTimeExpandViewZoomOut() {
		util.ExpandViewZoomOutBtn(page, expandViewZoomInBtn, Expand(BrokerMetricsGCTimeID), expandViewCloseBtn, expandViewZoomOutBtn, expandViewXaxisValues);
	}
	
	public void validateBrokerMetricsGCTimeExpandViewWidgetDragDrop() {
		util.ExpandViewWidgetDragDrop(page, Expand(BrokerMetricsGCTimeID), expandViewCloseBtn, expandViewXaxisLines, expandViewZoomOutBtn, expandViewXaxisValues);
	}

	
//Broker Metrics > GC Count Graph
	
	public void validateBrokerMetricsGCCountGraphTitle(String expectedTitle) {
		page.waitForTimeout(1000); 
    	String actualTitle = page.locator(getWidgetTitle(BrokerMetricsGCCountID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
	
	public void validateBrokerMetricsGCCountGraphZoomInBtn() {
		page.waitForTimeout(1000); 
		util.graphZoomIn(page,ZoomIn(BrokerMetricsGCCountID), BrokerMetricsGCCountID);
	}
	
	public void validateBrokerMetricsGCCountGraphZoomOutBtn() {
		page.waitForTimeout(1000); 
		util.graphZoomOut(page,ZoomIn(BrokerMetricsGCCountID),ZoomOut(BrokerMetricsGCCountID), BrokerMetricsGCCountID);
	}
	
	public void validateBrokerMetricsGCCountXaxisValues() {
		page.waitForTimeout(1000);  
		util.validateTheGraphdisplayingTheDataAsPerGivenTimeLines(page, XaxisValues(BrokerMetricsGCCountID), calenderView, WidgetXValues(XaxisValues(BrokerMetricsGCCountID)));
	}
	
	public void validateBrokerMetricsGCCountGraphXaxisTitle(String expectedTitle) {
		page.waitForTimeout(1000); 
    	String actualTitle = page.locator(XaxisTitle(BrokerMetricsGCCountID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
	
	public void validateBrokerMetricsGCCountGraphYaxisTitle(String expectedTitle) {
		page.waitForTimeout(1000); 
    	String actualTitle = page.locator(YaxisTitle(BrokerMetricsGCCountID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
	
	public void validateBrokerMetricsGCCountGraphBrokerMetricsHeaderTitle(String expectedTitle) {
		page.waitForTimeout(1000); 
    	String actualTitle = page.locator(HeaderTitle(BrokerMetricsGCCountID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
	
	public void validateBrokerMetricsGCCountGraphAvgHeaderTitle(String expectedTitle) {
		page.waitForTimeout(1000); 
    	String actualTitle = page.locator(AvgHeader(BrokerMetricsGCCountID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
	
	public void validateBrokerMetricsGCCountGraphMaxHeaderTitle(String expectedTitle) {
		page.waitForTimeout(1000); 
    	String actualTitle = page.locator(MaxHeader(BrokerMetricsGCCountID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
	
	public void validateBrokerMetricsGCCountGraphRowColor(String expectedTitle) {
		page.waitForTimeout(1000); 
    	String actualTitle = page.locator(RowColor(BrokerMetricsGCCountID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
	
	public void validateBrokerMetricsGCCountToolTipTitle() {
		page.waitForTimeout(1000); 
        util.validateWidgetToolTips(page, XaxisLines(BrokerMetricsGCCountID), ToolTipTitle(BrokerMetricsGCCountID));
    }
  
	public void validateBrokerMetricsGCCountExpandViewXAxisTitle() {
		page.waitForTimeout(1000); 
		util.validateExpandViewTexts(page, XaxisTitle(BrokerMetricsGCCountID), Expand(BrokerMetricsGCCountID), expandViewCloseBtn, expandViewXaxisTitle);
	}

	public void validateBrokerMetricsGCCountExpandViewYAxisTitle() {
		page.waitForTimeout(1000); 
		util.validateExpandViewTexts(page, YaxisTitle(BrokerMetricsGCCountID), Expand(BrokerMetricsGCCountID), expandViewCloseBtn, expandViewYaxisTitle);
	}
	
	public void validateBrokerMetricsGCCountExpandViewWidgetTitle() {
		page.waitForTimeout(1000); 
		util.validateExpandViewTexts(page, getWidgetTitle(BrokerMetricsGCCountID), Expand(BrokerMetricsGCCountID), expandViewCloseBtn, expandViewWidgetTitle);
	}
	
	public void validateBrokerMetricsGCCountExpandViewLegendHeader1() {
		page.waitForTimeout(1000); 
		util.validateExpandViewTexts(page, LegendColumn1Title(BrokerMetricsGCCountID), Expand(BrokerMetricsGCCountID), expandViewCloseBtn, expandViewLegendColumn1HeaderTitle);
	}
	
	public void validateBrokerMetricsGCCountExpandViewLegendHeader2() {
		page.waitForTimeout(1000); 
		util.validateExpandViewTexts(page, LegendColumn2Title(BrokerMetricsGCCountID), Expand(BrokerMetricsGCCountID), expandViewCloseBtn, expandViewLegendColumn2HeaderTitle);
	}
	
	public void validateBrokerMetricsGCCountExpandViewLegendHeader3() {
		page.waitForTimeout(1000); 
		util.validateExpandViewTexts(page, LegendColumn3Title(BrokerMetricsGCCountID), Expand(BrokerMetricsGCCountID), expandViewCloseBtn, expandViewLegendColumn3HeaderTitle);
	}
	
	public void validateBrokerMetricsGCCountExpandViewLegendHeader2InforMessage() {
		util.validateExpandViewTexts(page, LegendColumn2Title(BrokerMetricsGCCountID), Expand(BrokerMetricsGCCountID), expandViewCloseBtn, expandViewLegendColumnHeader2infoMessage);
	}
	
	public void validateBrokerMetricsGCCountExpandViewLegendHeader3InforMessage() {
		util.validateExpandViewTexts(page, LegendColumn3Title(BrokerMetricsGCCountID), Expand(BrokerMetricsGCCountID), expandViewCloseBtn, expandViewLegendColumnHeader3infoMessage);
	}
	
	public void validateBrokerMetricsGCCountExpandViewZoomIn() {
		page.waitForTimeout(1000); 
		util.ExpandViewZoomInBtn(page, expandViewZoomInBtn, Expand(BrokerMetricsGCCountID), expandViewCloseBtn, expandViewXaxisValues);
	}
	
	public void validateBrokerMetricsGCCountExpandViewZoomOut() {
		page.waitForTimeout(1000); 
		util.ExpandViewZoomOutBtn(page, expandViewZoomInBtn, Expand(BrokerMetricsGCCountID), expandViewCloseBtn, expandViewZoomOutBtn, expandViewXaxisValues);
	}
	
	public void validateBrokerMetricsGCCountExpandViewWidgetDragDrop() {
		page.waitForTimeout(1000); 
		util.ExpandViewWidgetDragDrop(page, Expand(BrokerMetricsGCCountID), expandViewCloseBtn, expandViewXaxisLines, expandViewZoomOutBtn, expandViewXaxisValues);
	}

//Broker Metrics > Thread Count Graph
	
	public void validateBrokerMetricsThreadCountGraphTitle(String expectedTitle) {
    	String actualTitle = page.locator(getWidgetTitle(BrokerMetricsThreadCountID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
	
	public void validateBrokerMetricsThreadCountGraphZoomInBtn() {
		page.waitForTimeout(1000); 
		util.graphZoomIn(page,ZoomIn(BrokerMetricsThreadCountID), BrokerMetricsThreadCountID);
	}
	
	public void validateBrokerMetricsThreadCountGraphZoomOutBtn() {
		page.waitForTimeout(1000);  
		util.graphZoomOut(page,ZoomIn(BrokerMetricsThreadCountID),ZoomOut(BrokerMetricsThreadCountID), BrokerMetricsThreadCountID);
	}
	
	public void validateBrokerMetricsThreadCountXaxisValues() {
		page.waitForTimeout(1000); 
		util.validateTheGraphdisplayingTheDataAsPerGivenTimeLines(page, XaxisValues(BrokerMetricsThreadCountID), calenderView, WidgetXValues(XaxisValues(BrokerMetricsThreadCountID)));
	}
	
	public void validateBrokerMetricsThreadCountGraphXaxisTitle(String expectedTitle) {
		page.waitForTimeout(1000); 
    	String actualTitle = page.locator(XaxisTitle(BrokerMetricsThreadCountID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
	
	public void validateBrokerMetricsThreadCountGraphYaxisTitle(String expectedTitle) {
		page.waitForTimeout(1000); 
    	String actualTitle = page.locator(YaxisTitle(BrokerMetricsThreadCountID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
	
	public void validateBrokerMetricsThreadCountGraphBrokerMetricsHeaderTitle(String expectedTitle) {
		page.waitForTimeout(1000); 
    	String actualTitle = page.locator(HeaderTitle(BrokerMetricsThreadCountID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
	
	public void validateBrokerMetricsThreadCountGraphAvgHeaderTitle(String expectedTitle) {
		page.waitForTimeout(1000); 
    	String actualTitle = page.locator(AvgHeader(BrokerMetricsThreadCountID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
	
	public void validateBrokerMetricsThreadCountGraphMaxHeaderTitle(String expectedTitle) {
		page.waitForTimeout(1000); 
    	String actualTitle = page.locator(MaxHeader(BrokerMetricsThreadCountID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
	
	public void validateBrokerMetricsThreadCountGraphRowColor(String expectedTitle) {
		page.waitForTimeout(1000); 
    	String actualTitle = page.locator(RowColor(BrokerMetricsThreadCountID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
	
	public void validateBrokerMetricsThreadCountToolTipTitle() {
		page.waitForTimeout(1000); 
        util.validateWidgetToolTips(page, XaxisLines(BrokerMetricsThreadCountID), ToolTipTitle(BrokerMetricsThreadCountID));
    }
  
	public void validateBrokerMetricsThreadCountExpandViewXAxisTitle() {
		util.validateExpandViewTexts(page, XaxisTitle(BrokerMetricsThreadCountID), Expand(BrokerMetricsThreadCountID), expandViewCloseBtn, expandViewXaxisTitle);
	}

	public void validateBrokerMetricsThreadCountExpandViewYAxisTitle() {
		util.validateExpandViewTexts(page, YaxisTitle(BrokerMetricsThreadCountID), Expand(BrokerMetricsThreadCountID), expandViewCloseBtn, expandViewYaxisTitle);
	}
	
	public void validateBrokerMetricsThreadCountExpandViewWidgetTitle() {
		page.waitForTimeout(1000); 
		util.validateExpandViewTexts(page, getWidgetTitle(BrokerMetricsThreadCountID), Expand(BrokerMetricsThreadCountID), expandViewCloseBtn, expandViewWidgetTitle);
	}
	
	public void validateBrokerMetricsThreadCountExpandViewLegendHeader1() {
		page.waitForTimeout(1000); 
		util.validateExpandViewTexts(page, LegendColumn1Title(BrokerMetricsThreadCountID), Expand(BrokerMetricsThreadCountID), expandViewCloseBtn, expandViewLegendColumn1HeaderTitle);
	}
	
	public void validateBrokerMetricsThreadCountExpandViewLegendHeader2() {
		page.waitForTimeout(1000); 
		util.validateExpandViewTexts(page, LegendColumn2Title(BrokerMetricsThreadCountID), Expand(BrokerMetricsThreadCountID), expandViewCloseBtn, expandViewLegendColumn2HeaderTitle);
	}
	
	public void validateBrokerMetricsThreadCountExpandViewLegendHeader3() {
		page.waitForTimeout(1000); 
		util.validateExpandViewTexts(page, LegendColumn3Title(BrokerMetricsThreadCountID), Expand(BrokerMetricsThreadCountID), expandViewCloseBtn, expandViewLegendColumn3HeaderTitle);
	}
	
	public void validateBrokerMetricsThreadCountExpandViewLegendHeader2InforMessage() {
		util.validateExpandViewTexts(page, LegendColumn2Title(BrokerMetricsThreadCountID), Expand(BrokerMetricsThreadCountID), expandViewCloseBtn, expandViewLegendColumnHeader2infoMessage);
	}
	
	public void validateBrokerMetricsThreadCountExpandViewLegendHeader3InforMessage() {
		util.validateExpandViewTexts(page, LegendColumn3Title(BrokerMetricsThreadCountID), Expand(BrokerMetricsThreadCountID), expandViewCloseBtn, expandViewLegendColumnHeader3infoMessage);
	}
	
	public void validateBrokerMetricsThreadCountExpandViewZoomIn() {
		page.waitForTimeout(1000); 
		util.ExpandViewZoomInBtn(page, expandViewZoomInBtn, Expand(BrokerMetricsThreadCountID), expandViewCloseBtn, expandViewXaxisValues);
	}
	
	public void validateBrokerMetricsThreadCountExpandViewZoomOut() {
		page.waitForTimeout(1000); 
		util.ExpandViewZoomOutBtn(page, expandViewZoomInBtn, Expand(BrokerMetricsThreadCountID), expandViewCloseBtn, expandViewZoomOutBtn, expandViewXaxisValues);
	}
	
	public void validateBrokerMetricsThreadCountExpandViewWidgetDragDrop() {
		page.waitForTimeout(1000); 
		util.ExpandViewWidgetDragDrop(page, Expand(BrokerMetricsThreadCountID), expandViewCloseBtn, expandViewXaxisLines, expandViewZoomOutBtn, expandViewXaxisValues);
	}

//Broker Metrics > Message Count Graph
	
	public void validateBrokerMetricsMessageCountGraphTitle(String expectedTitle) {
    	String actualTitle = page.locator(getWidgetTitle(BrokerMetricsMessageCountID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
	
	public void validateBrokerMetricsMessageCountGraphZoomInBtn() {
		page.waitForTimeout(1000); 
		util.graphZoomIn(page,ZoomIn(BrokerMetricsMessageCountID), BrokerMetricsMessageCountID);
	}
	
	public void validateBrokerMetricsMessageCountGraphZoomOutBtn() {
		page.waitForTimeout(1000);  
		util.graphZoomOut(page,ZoomIn(BrokerMetricsMessageCountID),ZoomOut(BrokerMetricsMessageCountID), BrokerMetricsMessageCountID);
	}
	
	public void validateBrokerMetricsMessageCountXaxisValues() {
		page.waitForTimeout(1000);  
		util.validateTheGraphdisplayingTheDataAsPerGivenTimeLines(page, XaxisValues(BrokerMetricsMessageCountID), calenderView, WidgetXValues(XaxisValues(BrokerMetricsMessageCountID)));
	}
	
	public void validateBrokerMetricsMessageCountGraphXaxisTitle(String expectedTitle) {
		page.waitForTimeout(1000); 
    	String actualTitle = page.locator(XaxisTitle(BrokerMetricsMessageCountID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
	
	public void validateBrokerMetricsMessageCountGraphYaxisTitle(String expectedTitle) {
		page.waitForTimeout(1000); 
    	String actualTitle = page.locator(YaxisTitle(BrokerMetricsMessageCountID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
	
	public void validateBrokerMetricsMessageCountGraphBrokerMetricsHeaderTitle(String expectedTitle) {
		page.waitForTimeout(1000); 
    	String actualTitle = page.locator(HeaderTitle(BrokerMetricsMessageCountID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
	
	public void validateBrokerMetricsMessageCountGraphAvgHeaderTitle(String expectedTitle) {
		page.waitForTimeout(1000); 
    	String actualTitle = page.locator(AvgHeader(BrokerMetricsMessageCountID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
	
	public void validateBrokerMetricsMessageCountGraphMaxHeaderTitle(String expectedTitle) {
		page.waitForTimeout(1000); 
    	String actualTitle = page.locator(MaxHeader(BrokerMetricsMessageCountID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
	
	public void validateBrokerMetricsMessageCountGraphRowColor(String expectedTitle) {
		page.waitForTimeout(1000); 
    	String actualTitle = page.locator(RowColor(BrokerMetricsMessageCountID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
	
	public void validateBrokerMetricsMessageCountToolTipTitle() {
		page.waitForTimeout(1000); 
        util.validateWidgetToolTips(page, XaxisLines(BrokerMetricsMessageCountID), ToolTipTitle(BrokerMetricsMessageCountID));
    }
  
	public void validateBrokerMetricsMessageCountExpandViewXAxisTitle() {
		page.waitForTimeout(1000); 
		util.validateExpandViewTexts(page, XaxisTitle(BrokerMetricsMessageCountID), Expand(BrokerMetricsMessageCountID), expandViewCloseBtn, expandViewXaxisTitle);
	}

	public void validateBrokerMetricsMessageCountExpandViewYAxisTitle() {
		page.waitForTimeout(1000); 
		util.validateExpandViewTexts(page, YaxisTitle(BrokerMetricsMessageCountID), Expand(BrokerMetricsMessageCountID), expandViewCloseBtn, expandViewYaxisTitle);
	}
	
	public void validateBrokerMetricsMessageCountExpandViewWidgetTitle() {
		page.waitForTimeout(1000); 
		util.validateExpandViewTexts(page, getWidgetTitle(BrokerMetricsMessageCountID), Expand(BrokerMetricsMessageCountID), expandViewCloseBtn, expandViewWidgetTitle);
	}
	
	public void validateBrokerMetricsMessageCountExpandViewLegendHeader1() {
		page.waitForTimeout(1000); 
		util.validateExpandViewTexts(page, LegendColumn1Title(BrokerMetricsMessageCountID), Expand(BrokerMetricsMessageCountID), expandViewCloseBtn, expandViewLegendColumn1HeaderTitle);
	}
	
	public void validateBrokerMetricsMessageCountExpandViewLegendHeader2() {
		page.waitForTimeout(1000); 
		util.validateExpandViewTexts(page, LegendColumn2Title(BrokerMetricsMessageCountID), Expand(BrokerMetricsMessageCountID), expandViewCloseBtn, expandViewLegendColumn2HeaderTitle);
	}
	
	public void validateBrokerMetricsMessageCountExpandViewLegendHeader3() {
		page.waitForTimeout(1000); 
		util.validateExpandViewTexts(page, LegendColumn3Title(BrokerMetricsMessageCountID), Expand(BrokerMetricsMessageCountID), expandViewCloseBtn, expandViewLegendColumn3HeaderTitle);
	}
	
	public void validateBrokerMetricsMessageCountExpandViewLegendHeader2InforMessage() {
		util.validateExpandViewTexts(page, LegendColumn2Title(BrokerMetricsMessageCountID), Expand(BrokerMetricsMessageCountID), expandViewCloseBtn, expandViewLegendColumnHeader2infoMessage);
	}
	
	public void validateBrokerMetricsMessageCountExpandViewLegendHeader3InforMessage() {
		util.validateExpandViewTexts(page, LegendColumn3Title(BrokerMetricsMessageCountID), Expand(BrokerMetricsMessageCountID), expandViewCloseBtn, expandViewLegendColumnHeader3infoMessage);
	}
	
	public void validateBrokerMetricsMessageCountExpandViewZoomIn() {
		page.waitForTimeout(1000); 
		util.ExpandViewZoomInBtn(page, expandViewZoomInBtn, Expand(BrokerMetricsMessageCountID), expandViewCloseBtn, expandViewXaxisValues);
	}
	
	public void validateBrokerMetricsMessageCountExpandViewZoomOut() {
		page.waitForTimeout(1000); 
		util.ExpandViewZoomOutBtn(page, expandViewZoomInBtn, Expand(BrokerMetricsMessageCountID), expandViewCloseBtn, expandViewZoomOutBtn, expandViewXaxisValues);
	}
	
	public void validateBrokerMetricsMessageCountExpandViewWidgetDragDrop() {
		page.waitForTimeout(1000); 
		util.ExpandViewWidgetDragDrop(page, Expand(BrokerMetricsMessageCountID), expandViewCloseBtn, expandViewXaxisLines, expandViewZoomOutBtn, expandViewXaxisValues);
	}

	
  	/**
     * id refers widget locator id
     * @param id
     * @return 
     */
	
	private String getWidgetTitle(String id) {
		return "xpath = //div[@id='"+id+"']/ancestor::div[@class='card-body' or @class='chart-body']/preceding-sibling::div[@class='card-header']";
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
    
    private String RowColor(String id) {
    	return "xpath = //div[@id='"+id+"']/ancestor::div[@class='graph']/descendant::div[@class='table-body']/descendant::span[@class='dot'][position()=1]";
    }


}
