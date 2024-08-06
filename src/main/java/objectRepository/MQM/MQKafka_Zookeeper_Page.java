package objectRepository.MQM;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;

import genericUtilities.ExcelUtility;
import genericUtilities.GenericMethods;
import java.util.ArrayList;
import java.util.List;

public class MQKafka_Zookeeper_Page 
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
	private String ZookeeperTab = "xpath = //div[@class='navtab']/div[@class='item' and position()=5]/child::div";	
	
	//Zoo-keeper > Topic Metrics
	private String ZookeeperDisconnectID = "apexchartschart-kafka_zookeeper_disconnects_per_sec";
	private String ZookeeperConnectID = "apexchartschart-kafka_zookeeper_sync_connects_per_sec";
	private String ZookeeperExpirePerSecondID = "apexchartschart-kafka_zookeeper_expires_per_sec";
	private String ZookeeperAuthFailureID = "apexchartschart-kafka_zookeeper_auth_failures_per_sec";
	private String ZookeeperReadOnlyConnectID = "apexchartschart-kafka_zookeeper_readonly_connects_per_sec";
	private String ZookeeperSASLAuthenticationID = "apexchartschart-kafka_zookeeper_sasl_authentications_per_sec";
	
	public List<String> WidgetXValues(String XValue){
    	ArrayList<String> xValue = new ArrayList<String>();
    	xValue.add(XValue);
    	return xValue;
	}
	
	public MQKafka_Zookeeper_Page(Page page) {
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
					 page.waitForLoadState(LoadState.NETWORKIDLE); 
	}
	
	public void navigateToZookeeperTab() {
		page.locator(ZookeeperTab).click();
		page.waitForLoadState(LoadState.NETWORKIDLE);
	}
	
	public void validateZookeeperTitle(String expectedTitle) {
    	String actualTitle = page.locator(ZookeeperTab).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    	page.waitForLoadState(LoadState.NETWORKIDLE);
    }
	
	
// Zoo keeper > Zoo keeper Disconnect Graph
	
	public void validateZookeeperDisconnectGraphTitle(String expectedTitle) {
    	String actualTitle = page.locator(getWidgetTitle(ZookeeperDisconnectID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
	
	public void validateZookeeperDisconnectGraphZoomInBtn() {
		page.reload();
		util.graphZoomIn(page,ZoomOut(ZookeeperDisconnectID),ZookeeperDisconnectID);
	}
	
	public void validateZookeeperDisconnectGraphZoomOutBtn() {
		page.reload();
		util.graphZoomOut(page,ZoomIn(ZookeeperDisconnectID),ZoomOut(ZookeeperDisconnectID), ZookeeperDisconnectID);
	}
	
	public void validateZookeeperDisconnectXaxisValues() {
		page.reload();
		util.validateTheGraphdisplayingTheDataAsPerGivenTimeLines(page, XaxisValues(ZookeeperDisconnectID), calenderView, WidgetXValues(XaxisValues(ZookeeperDisconnectID)));
	}
	
	public void validateZookeeperDisconnectGraphXaxisTitle(String expectedTitle) {
    	String actualTitle = page.locator(XaxisTitle(ZookeeperDisconnectID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
	
	public void validateZookeeperDisconnectGraphYaxisTitle(String expectedTitle) {
    	String actualTitle = page.locator(YaxisTitle(ZookeeperDisconnectID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
	
	public void validateZookeeperDisconnectGraphTopicHeaderTitle(String expectedTitle) {
    	String actualTitle = page.locator(HeaderTitle(ZookeeperDisconnectID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
	
	public void validateZookeeperDisconnectGraphAvgHeaderTitle(String expectedTitle) {
    	String actualTitle = page.locator(AvgHeader(ZookeeperDisconnectID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
	
	public void validateZookeeperDisconnectGraphMaxHeaderTitle(String expectedTitle) {
    	String actualTitle = page.locator(MaxHeader(ZookeeperDisconnectID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
	
	public void validateZookeeperDisconnectGraphRowColor(String expectedTitle) {
    	String actualTitle = page.locator(RowColor(ZookeeperDisconnectID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
	
	public void validateZookeeperDisconnectToolTipTitle() {
        util.validateWidgetToolTips(page, XaxisLines(ZookeeperDisconnectID), ToolTipTitle(ZookeeperDisconnectID));
    }

	public void validateZookeeperDisconnectExpandViewXAxisTitle() {
		util.validateExpandViewTexts(page, XaxisTitle(ZookeeperDisconnectID), Expand(ZookeeperDisconnectID), expandViewCloseBtn, expandViewXaxisTitle);
	}

	public void validateZookeeperDisconnectExpandViewYAxisTitle() {
		util.validateExpandViewTexts(page, YaxisTitle(ZookeeperDisconnectID), Expand(ZookeeperDisconnectID), expandViewCloseBtn, expandViewYaxisTitle);
	}
	
	public void validateZookeeperDisconnectExpandViewWidgetTitle() {
		util.validateExpandViewTexts(page, getWidgetTitle(ZookeeperDisconnectID), Expand(ZookeeperDisconnectID), expandViewCloseBtn, expandViewWidgetTitle);
	}
	
	public void validateZookeeperDisconnectExpandViewLegendHeader1() {
		util.validateExpandViewTexts(page, LegendColumn1Title(ZookeeperDisconnectID), Expand(ZookeeperDisconnectID), expandViewCloseBtn, expandViewLegendColumn1HeaderTitle);
	}
	
	public void validateZookeeperDisconnectExpandViewLegendHeader2() {
		util.validateExpandViewTexts(page, LegendColumn2Title(ZookeeperDisconnectID), Expand(ZookeeperDisconnectID), expandViewCloseBtn, expandViewLegendColumn2HeaderTitle);
	}
	
	public void validateZookeeperDisconnectExpandViewLegendHeader3() {
		util.validateExpandViewTexts(page, LegendColumn3Title(ZookeeperDisconnectID), Expand(ZookeeperDisconnectID), expandViewCloseBtn, expandViewLegendColumn3HeaderTitle);
	}
	
	public void validateZookeeperDisconnectExpandViewLegendHeader2InforMessage() {
		util.validateExpandViewTexts(page, LegendColumn2Title(ZookeeperDisconnectID), Expand(ZookeeperDisconnectID), expandViewCloseBtn, expandViewLegendColumnHeader2infoMessage);
	}
	
	public void validateZookeeperDisconnectExpandViewLegendHeader3InforMessage() {
		util.validateExpandViewTexts(page, LegendColumn3Title(ZookeeperDisconnectID), Expand(ZookeeperDisconnectID), expandViewCloseBtn, expandViewLegendColumnHeader3infoMessage);
	}
	
	public void validateZookeeperDisconnectExpandViewZoomIn() {
		util.ExpandViewZoomInBtn(page, expandViewZoomInBtn, Expand(ZookeeperDisconnectID), expandViewCloseBtn, expandViewXaxisValues);
	}
	
	public void validateZookeeperDisconnectExpandViewZoomOut() {
		util.ExpandViewZoomOutBtn(page, expandViewZoomInBtn, Expand(ZookeeperDisconnectID), expandViewCloseBtn, expandViewZoomOutBtn, expandViewXaxisValues);
	}
	
	public void validateZookeeperDisconnectExpandViewWidgetDragDrop() {
		util.ExpandViewWidgetDragDrop(page, Expand(ZookeeperDisconnectID), expandViewCloseBtn, expandViewXaxisLines, expandViewZoomOutBtn, expandViewXaxisValues);
	}

	
	// Zoo keeper > Zoo keeper Connect Graph
	
	public void validateZookeeperConnectGraphTitle(String expectedTitle) {
    	String actualTitle = page.locator(getWidgetTitle(ZookeeperConnectID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
	
	public void validateZookeeperConnectGraphZoomInBtn() {
		page.reload();
		util.graphZoomIn(page,ZoomOut(ZookeeperConnectID),ZookeeperConnectID);
	}
	
	public void validateZookeeperConnectGraphZoomOutBtn() {
		page.reload();
		util.graphZoomOut(page,ZoomIn(ZookeeperConnectID),ZoomOut(ZookeeperConnectID), ZookeeperConnectID);
	}
	
	
	public void validateZookeeperConnectXaxisValues() {
		page.reload();
		util.validateTheGraphdisplayingTheDataAsPerGivenTimeLines(page, XaxisValues(ZookeeperConnectID), calenderView, WidgetXValues(XaxisValues(ZookeeperConnectID)));
	}
	
	public void validateZookeeperConnectGraphXaxisTitle(String expectedTitle) {
    	String actualTitle = page.locator(XaxisTitle(ZookeeperConnectID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
	
	public void validateZookeeperConnectGraphYaxisTitle(String expectedTitle) {
    	String actualTitle = page.locator(YaxisTitle(ZookeeperConnectID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
	
	public void validateZookeeperConnectGraphTopicHeaderTitle(String expectedTitle) {
    	String actualTitle = page.locator(HeaderTitle(ZookeeperConnectID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
	
	public void validateZookeeperConnectGraphAvgHeaderTitle(String expectedTitle) {
    	String actualTitle = page.locator(AvgHeader(ZookeeperConnectID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
	
	public void validateZookeeperConnectGraphMaxHeaderTitle(String expectedTitle) {
    	String actualTitle = page.locator(MaxHeader(ZookeeperConnectID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
	
	public void validateZookeeperConnectGraphRowColor(String expectedTitle) {
    	String actualTitle = page.locator(RowColor(ZookeeperConnectID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
	
	public void validateZookeeperConnectToolTipTitle() {
        util.validateWidgetToolTips(page, XaxisLines(ZookeeperConnectID), ToolTipTitle(ZookeeperConnectID));
    }
	
	public void validateZookeeperConnectExpandViewXAxisTitle() {
		util.validateExpandViewTexts(page, XaxisTitle(ZookeeperConnectID), Expand(ZookeeperConnectID), expandViewCloseBtn, expandViewXaxisTitle);
	}

	public void validateZookeeperConnectExpandViewYAxisTitle() {
		util.validateExpandViewTexts(page, YaxisTitle(ZookeeperConnectID), Expand(ZookeeperConnectID), expandViewCloseBtn, expandViewYaxisTitle);
	}
	
	public void validateZookeeperConnectExpandViewWidgetTitle() {
		util.validateExpandViewTexts(page, getWidgetTitle(ZookeeperConnectID), Expand(ZookeeperConnectID), expandViewCloseBtn, expandViewWidgetTitle);
	}
	
	public void validateZookeeperConnectExpandViewLegendHeader1() {
		util.validateExpandViewTexts(page, LegendColumn1Title(ZookeeperConnectID), Expand(ZookeeperConnectID), expandViewCloseBtn, expandViewLegendColumn1HeaderTitle);
	}
	
	public void validateZookeeperConnectExpandViewLegendHeader2() {
		util.validateExpandViewTexts(page, LegendColumn2Title(ZookeeperConnectID), Expand(ZookeeperConnectID), expandViewCloseBtn, expandViewLegendColumn2HeaderTitle);
	}
	
	public void validateZookeeperConnectExpandViewLegendHeader3() {
		util.validateExpandViewTexts(page, LegendColumn3Title(ZookeeperConnectID), Expand(ZookeeperConnectID), expandViewCloseBtn, expandViewLegendColumn3HeaderTitle);
	}
	
	public void validateZookeeperConnectExpandViewLegendHeader2InforMessage() {
		util.validateExpandViewTexts(page, LegendColumn2Title(ZookeeperConnectID), Expand(ZookeeperConnectID), expandViewCloseBtn, expandViewLegendColumnHeader2infoMessage);
	}
	
	public void validateZookeeperConnectExpandViewLegendHeader3InforMessage() {
		util.validateExpandViewTexts(page, LegendColumn3Title(ZookeeperConnectID), Expand(ZookeeperConnectID), expandViewCloseBtn, expandViewLegendColumnHeader3infoMessage);
	}
	
	public void validateZookeeperConnectExpandViewZoomIn() {
		util.ExpandViewZoomInBtn(page, expandViewZoomInBtn, Expand(ZookeeperConnectID), expandViewCloseBtn, expandViewXaxisValues);
	}
	
	public void validateZookeeperConnectExpandViewZoomOut() {
		util.ExpandViewZoomOutBtn(page, expandViewZoomInBtn, Expand(ZookeeperConnectID), expandViewCloseBtn, expandViewZoomOutBtn, expandViewXaxisValues);
	}
	
	public void validateZookeeperConnectExpandViewWidgetDragDrop() {
		util.ExpandViewWidgetDragDrop(page, Expand(ZookeeperConnectID), expandViewCloseBtn, expandViewXaxisLines, expandViewZoomOutBtn, expandViewXaxisValues);
	}

	
	// Zoo keeper > Zoo keeper Expire Per Second Graph
	
	public void validateZookeeperExpirePerSecondGraphTitle(String expectedTitle) {
    	String actualTitle = page.locator(getWidgetTitle(ZookeeperExpirePerSecondID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
	
	public void validateZookeeperExpirePerSecondGraphZoomInBtn() {
		page.reload();
		util.graphZoomIn(page,ZoomOut(ZookeeperExpirePerSecondID),ZookeeperExpirePerSecondID);
	}
	
	public void validateZookeeperExpirePerSecondGraphZoomOutBtn() {
		page.reload();
		util.graphZoomOut(page,ZoomIn(ZookeeperExpirePerSecondID),ZoomOut(ZookeeperExpirePerSecondID), ZookeeperExpirePerSecondID);
	}
		
	public void validateZookeeperExpirePerSecondXaxisValues() {
		page.reload();
		util.validateTheGraphdisplayingTheDataAsPerGivenTimeLines(page, XaxisValues(ZookeeperExpirePerSecondID), calenderView, WidgetXValues(XaxisValues(ZookeeperExpirePerSecondID)));
	}
	
	public void validateZookeeperExpirePerSecondGraphXaxisTitle(String expectedTitle) {
    	String actualTitle = page.locator(XaxisTitle(ZookeeperExpirePerSecondID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
	
	public void validateZookeeperExpirePerSecondGraphYaxisTitle(String expectedTitle) {
    	String actualTitle = page.locator(YaxisTitle(ZookeeperExpirePerSecondID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
	
	public void validateZookeeperExpirePerSecondGraphTopicHeaderTitle(String expectedTitle) {
    	String actualTitle = page.locator(HeaderTitle(ZookeeperExpirePerSecondID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
	
	public void validateZookeeperExpirePerSecondGraphAvgHeaderTitle(String expectedTitle) {
    	String actualTitle = page.locator(AvgHeader(ZookeeperExpirePerSecondID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
	
	public void validateZookeeperExpirePerSecondGraphMaxHeaderTitle(String expectedTitle) {
    	String actualTitle = page.locator(MaxHeader(ZookeeperExpirePerSecondID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
	
	public void validateZookeeperExpirePerSecondGraphRowColor(String expectedTitle) {
    	String actualTitle = page.locator(RowColor(ZookeeperExpirePerSecondID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
	
	public void validateZookeeperExpirePerSecondToolTipTitle() {
        util.validateWidgetToolTips(page, XaxisLines(ZookeeperExpirePerSecondID), ToolTipTitle(ZookeeperExpirePerSecondID));
    }
  
	public void validateZookeeperExpirePerSecondExpandViewXAxisTitle() {
		util.validateExpandViewTexts(page, XaxisTitle(ZookeeperExpirePerSecondID), Expand(ZookeeperExpirePerSecondID), expandViewCloseBtn, expandViewXaxisTitle);
	}

	public void validateZookeeperExpirePerSecondExpandViewYAxisTitle() {
		util.validateExpandViewTexts(page, YaxisTitle(ZookeeperExpirePerSecondID), Expand(ZookeeperExpirePerSecondID), expandViewCloseBtn, expandViewYaxisTitle);
	}
	
	public void validateZookeeperExpirePerSecondExpandViewWidgetTitle() {
		util.validateExpandViewTexts(page, getWidgetTitle(ZookeeperExpirePerSecondID), Expand(ZookeeperExpirePerSecondID), expandViewCloseBtn, expandViewWidgetTitle);
	}
	
	public void validateZookeeperExpirePerSecondExpandViewLegendHeader1() {
		util.validateExpandViewTexts(page, LegendColumn1Title(ZookeeperExpirePerSecondID), Expand(ZookeeperExpirePerSecondID), expandViewCloseBtn, expandViewLegendColumn1HeaderTitle);
	}
	
	public void validateZookeeperExpirePerSecondExpandViewLegendHeader2() {
		util.validateExpandViewTexts(page, LegendColumn2Title(ZookeeperExpirePerSecondID), Expand(ZookeeperExpirePerSecondID), expandViewCloseBtn, expandViewLegendColumn2HeaderTitle);
	}
	
	public void validateZookeeperExpirePerSecondExpandViewLegendHeader3() {
		util.validateExpandViewTexts(page, LegendColumn3Title(ZookeeperExpirePerSecondID), Expand(ZookeeperExpirePerSecondID), expandViewCloseBtn, expandViewLegendColumn3HeaderTitle);
	}
	
	public void validateZookeeperExpirePerSecondExpandViewLegendHeader2InforMessage() {
		util.validateExpandViewTexts(page, LegendColumn2Title(ZookeeperExpirePerSecondID), Expand(ZookeeperExpirePerSecondID), expandViewCloseBtn, expandViewLegendColumnHeader2infoMessage);
	}
	
	public void validateZookeeperExpirePerSecondExpandViewLegendHeader3InforMessage() {
		util.validateExpandViewTexts(page, LegendColumn3Title(ZookeeperExpirePerSecondID), Expand(ZookeeperExpirePerSecondID), expandViewCloseBtn, expandViewLegendColumnHeader3infoMessage);
	}
	
	public void validateZookeeperExpirePerSecondExpandViewZoomIn() {
		util.ExpandViewZoomInBtn(page, expandViewZoomInBtn, Expand(ZookeeperExpirePerSecondID), expandViewCloseBtn, expandViewXaxisValues);
	}
	
	public void validateZookeeperExpirePerSecondExpandViewZoomOut() {
		util.ExpandViewZoomOutBtn(page, expandViewZoomInBtn, Expand(ZookeeperExpirePerSecondID), expandViewCloseBtn, expandViewZoomOutBtn, expandViewXaxisValues);
	}
	
	public void validateZookeeperExpirePerSecondExpandViewWidgetDragDrop() {
		util.ExpandViewWidgetDragDrop(page, Expand(ZookeeperExpirePerSecondID), expandViewCloseBtn, expandViewXaxisLines, expandViewZoomOutBtn, expandViewXaxisValues);
	}

	
	// Zoo keeper > Zoo keeper AuthFailure Graph
	
	public void validateZookeeperAuthFailureGraphTitle(String expectedTitle) {
    	String actualTitle = page.locator(getWidgetTitle(ZookeeperAuthFailureID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
	
	public void validateZookeeperAuthFailureGraphZoomInBtn() {
		page.reload();
		util.graphZoomIn(page,ZoomOut(ZookeeperAuthFailureID),ZookeeperAuthFailureID);
	}
	
	public void validateZookeeperAuthFailureGraphZoomOutBtn() {
		page.reload();
		util.graphZoomOut(page,ZoomIn(ZookeeperAuthFailureID),ZoomOut(ZookeeperAuthFailureID), ZookeeperAuthFailureID);
	}	
	
	public void validateZookeeperAuthFailureXaxisValues() {
		page.reload();
		util.validateTheGraphdisplayingTheDataAsPerGivenTimeLines(page, XaxisValues(ZookeeperAuthFailureID), calenderView, WidgetXValues(XaxisValues(ZookeeperAuthFailureID)));
	}
	
	public void validateZookeeperAuthFailureGraphXaxisTitle(String expectedTitle) {
    	String actualTitle = page.locator(XaxisTitle(ZookeeperAuthFailureID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
	
	public void validateZookeeperAuthFailureGraphYaxisTitle(String expectedTitle) {
    	String actualTitle = page.locator(YaxisTitle(ZookeeperAuthFailureID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
	
	public void validateZookeeperAuthFailureGraphTopicHeaderTitle(String expectedTitle) {
    	String actualTitle = page.locator(HeaderTitle(ZookeeperAuthFailureID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
	public void validateZookeeperAuthFailureGraphAvgHeaderTitle(String expectedTitle) {
    	String actualTitle = page.locator(AvgHeader(ZookeeperAuthFailureID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
	
	public void validateZookeeperAuthFailureGraphMaxHeaderTitle(String expectedTitle) {
    	String actualTitle = page.locator(MaxHeader(ZookeeperAuthFailureID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
	
	public void validateZookeeperAuthFailureGraphRowColor(String expectedTitle) {
    	String actualTitle = page.locator(RowColor(ZookeeperAuthFailureID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
	
	public void validateZookeeperAuthFailureToolTipTitle() {
        util.validateWidgetToolTips(page, XaxisLines(ZookeeperAuthFailureID), ToolTipTitle(ZookeeperAuthFailureID));
    }
  
	public void validateZookeeperAuthFailureExpandViewXAxisTitle() {
		util.validateExpandViewTexts(page, XaxisTitle(ZookeeperAuthFailureID), Expand(ZookeeperAuthFailureID), expandViewCloseBtn, expandViewXaxisTitle);
	}

	public void validateZookeeperAuthFailureExpandViewYAxisTitle() {
		util.validateExpandViewTexts(page, YaxisTitle(ZookeeperAuthFailureID), Expand(ZookeeperAuthFailureID), expandViewCloseBtn, expandViewYaxisTitle);
	}
	
	public void validateZookeeperAuthFailureExpandViewWidgetTitle() {
		util.validateExpandViewTexts(page, getWidgetTitle(ZookeeperAuthFailureID), Expand(ZookeeperAuthFailureID), expandViewCloseBtn, expandViewWidgetTitle);
	}
	
	public void validateZookeeperAuthFailureExpandViewLegendHeader1() {
		util.validateExpandViewTexts(page, LegendColumn1Title(ZookeeperAuthFailureID), Expand(ZookeeperAuthFailureID), expandViewCloseBtn, expandViewLegendColumn1HeaderTitle);
	}
	
	public void validateZookeeperAuthFailureExpandViewLegendHeader2() {
		util.validateExpandViewTexts(page, LegendColumn2Title(ZookeeperAuthFailureID), Expand(ZookeeperAuthFailureID), expandViewCloseBtn, expandViewLegendColumn2HeaderTitle);
	}
	
	public void validateZookeeperAuthFailureExpandViewLegendHeader3() {
		util.validateExpandViewTexts(page, LegendColumn3Title(ZookeeperAuthFailureID), Expand(ZookeeperAuthFailureID), expandViewCloseBtn, expandViewLegendColumn3HeaderTitle);
	}
	
	public void validateZookeeperAuthFailureExpandViewLegendHeader2InforMessage() {
		util.validateExpandViewTexts(page, LegendColumn2Title(ZookeeperAuthFailureID), Expand(ZookeeperAuthFailureID), expandViewCloseBtn, expandViewLegendColumnHeader2infoMessage);
	}
	
	public void validateZookeeperAuthFailureExpandViewLegendHeader3InforMessage() {
		util.validateExpandViewTexts(page, LegendColumn3Title(ZookeeperAuthFailureID), Expand(ZookeeperAuthFailureID), expandViewCloseBtn, expandViewLegendColumnHeader3infoMessage);
	}
	
	public void validateZookeeperAuthFailureExpandViewZoomIn() {
		util.ExpandViewZoomInBtn(page, expandViewZoomInBtn, Expand(ZookeeperAuthFailureID), expandViewCloseBtn, expandViewXaxisValues);
	}
	
	public void validateZookeeperAuthFailureExpandViewZoomOut() {
		util.ExpandViewZoomOutBtn(page, expandViewZoomInBtn, Expand(ZookeeperAuthFailureID), expandViewCloseBtn, expandViewZoomOutBtn, expandViewXaxisValues);
	}
	
	public void validateZookeeperAuthFailureExpandViewWidgetDragDrop() {
		util.ExpandViewWidgetDragDrop(page, Expand(ZookeeperAuthFailureID), expandViewCloseBtn, expandViewXaxisLines, expandViewZoomOutBtn, expandViewXaxisValues);
	}

	
	
	
// Zoo keeper > Zoo keeper Read only Connect Graph
	
	public void validateZookeeperReadOnlyConnectGraphTitle(String expectedTitle) {
    	String actualTitle = page.locator(getWidgetTitle(ZookeeperReadOnlyConnectID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
	
	public void validateZookeeperReadOnlyConnectGraphZoomInBtn() {
		page.reload();
		util.graphZoomIn(page,ZoomOut(ZookeeperReadOnlyConnectID),ZookeeperReadOnlyConnectID);
	}
	
	public void validateZookeeperReadOnlyConnectGraphZoomOutBtn() {
		page.reload();
		util.graphZoomOut(page,ZoomIn(ZookeeperReadOnlyConnectID),ZoomOut(ZookeeperReadOnlyConnectID), ZookeeperReadOnlyConnectID);
	}
	
	public void validateZookeeperReadOnlyConnectXaxisValues() {
		page.reload();
		util.validateTheGraphdisplayingTheDataAsPerGivenTimeLines(page, XaxisValues(ZookeeperReadOnlyConnectID), calenderView, WidgetXValues(XaxisValues(ZookeeperReadOnlyConnectID)));
	}
	
	public void validateZookeeperReadOnlyConnectGraphXaxisTitle(String expectedTitle) {
    	String actualTitle = page.locator(XaxisTitle(ZookeeperReadOnlyConnectID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
	
	public void validateZookeeperReadOnlyConnectGraphYaxisTitle(String expectedTitle) {
    	String actualTitle = page.locator(YaxisTitle(ZookeeperReadOnlyConnectID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
	
	public void validateZookeeperReadOnlyConnectGraphTopicHeaderTitle(String expectedTitle) {
    	String actualTitle = page.locator(HeaderTitle(ZookeeperReadOnlyConnectID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
	
	public void validateZookeeperReadOnlyConnectGraphAvgHeaderTitle(String expectedTitle) {
    	String actualTitle = page.locator(AvgHeader(ZookeeperReadOnlyConnectID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
	
	public void validateZookeeperReadOnlyConnectGraphMaxHeaderTitle(String expectedTitle) {
    	String actualTitle = page.locator(MaxHeader(ZookeeperReadOnlyConnectID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
	
	public void validateZookeeperReadOnlyConnectGraphRowColor(String expectedTitle) {
    	String actualTitle = page.locator(RowColor(ZookeeperReadOnlyConnectID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
	
	public void validateZookeeperReadOnlyConnectToolTipTitle() {
        util.validateWidgetToolTips(page, XaxisLines(ZookeeperReadOnlyConnectID), ToolTipTitle(ZookeeperReadOnlyConnectID));
    }
  
	public void validateZookeeperReadOnlyConnectExpandViewXAxisTitle() {
		util.validateExpandViewTexts(page, XaxisTitle(ZookeeperReadOnlyConnectID), Expand(ZookeeperReadOnlyConnectID), expandViewCloseBtn, expandViewXaxisTitle);
	}

	public void validateZookeeperReadOnlyConnectExpandViewYAxisTitle() {
		util.validateExpandViewTexts(page, YaxisTitle(ZookeeperReadOnlyConnectID), Expand(ZookeeperReadOnlyConnectID), expandViewCloseBtn, expandViewYaxisTitle);
	}
	
	public void validateZookeeperReadOnlyConnectExpandViewWidgetTitle() {
		util.validateExpandViewTexts(page, getWidgetTitle(ZookeeperReadOnlyConnectID), Expand(ZookeeperReadOnlyConnectID), expandViewCloseBtn, expandViewWidgetTitle);
	}
	
	public void validateZookeeperReadOnlyConnectExpandViewLegendHeader1() {
		util.validateExpandViewTexts(page, LegendColumn1Title(ZookeeperReadOnlyConnectID), Expand(ZookeeperReadOnlyConnectID), expandViewCloseBtn, expandViewLegendColumn1HeaderTitle);
	}
	
	public void validateZookeeperReadOnlyConnectExpandViewLegendHeader2() {
		util.validateExpandViewTexts(page, LegendColumn2Title(ZookeeperReadOnlyConnectID), Expand(ZookeeperReadOnlyConnectID), expandViewCloseBtn, expandViewLegendColumn2HeaderTitle);
	}
	
	public void validateZookeeperReadOnlyConnectExpandViewLegendHeader3() {
		util.validateExpandViewTexts(page, LegendColumn3Title(ZookeeperReadOnlyConnectID), Expand(ZookeeperReadOnlyConnectID), expandViewCloseBtn, expandViewLegendColumn3HeaderTitle);
	}
	
	public void validateZookeeperReadOnlyConnectExpandViewLegendHeader2InforMessage() {
		util.validateExpandViewTexts(page, LegendColumn2Title(ZookeeperReadOnlyConnectID), Expand(ZookeeperReadOnlyConnectID), expandViewCloseBtn, expandViewLegendColumnHeader2infoMessage);
	}
	
	public void validateZookeeperReadOnlyConnectExpandViewLegendHeader3InforMessage() {
		util.validateExpandViewTexts(page, LegendColumn3Title(ZookeeperReadOnlyConnectID), Expand(ZookeeperReadOnlyConnectID), expandViewCloseBtn, expandViewLegendColumnHeader3infoMessage);
	}
	
	public void validateZookeeperReadOnlyConnectExpandViewZoomIn() {
		util.ExpandViewZoomInBtn(page, expandViewZoomInBtn, Expand(ZookeeperReadOnlyConnectID), expandViewCloseBtn, expandViewXaxisValues);
	}
	
	public void validateZookeeperReadOnlyConnectExpandViewZoomOut() {
		util.ExpandViewZoomOutBtn(page, expandViewZoomInBtn, Expand(ZookeeperReadOnlyConnectID), expandViewCloseBtn, expandViewZoomOutBtn, expandViewXaxisValues);
	}
	
	public void validateZookeeperReadOnlyConnectExpandViewWidgetDragDrop() {
		util.ExpandViewWidgetDragDrop(page, Expand(ZookeeperReadOnlyConnectID), expandViewCloseBtn, expandViewXaxisLines, expandViewZoomOutBtn, expandViewXaxisValues);
	}

	
// Zoo keeper > Zoo keeper SASL Authentication Graph
	
	public void validateZookeeperSASLAuthenticationGraphTitle(String expectedTitle) {
    	String actualTitle = page.locator(getWidgetTitle(ZookeeperSASLAuthenticationID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
	
	public void validateZookeeperSASLAuthenticationGraphZoomInBtn() {
		page.reload();
		util.graphZoomIn(page,ZoomOut(ZookeeperSASLAuthenticationID),ZookeeperSASLAuthenticationID);
	}
	
	public void validateZookeeperSASLAuthenticationGraphZoomOutBtn() {
		page.reload();
		util.graphZoomOut(page,ZoomIn(ZookeeperSASLAuthenticationID),ZoomOut(ZookeeperSASLAuthenticationID), ZookeeperSASLAuthenticationID);
	}

	public void validateZookeeperSASLAuthenticationXaxisValues() {
		page.reload();
		util.validateTheGraphdisplayingTheDataAsPerGivenTimeLines(page, XaxisValues(ZookeeperSASLAuthenticationID), calenderView, WidgetXValues(XaxisValues(ZookeeperSASLAuthenticationID)));
	}
	
	public void validateZookeeperSASLAuthenticationGraphXaxisTitle(String expectedTitle) {
    	String actualTitle = page.locator(XaxisTitle(ZookeeperSASLAuthenticationID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
	
	public void validateZookeeperSASLAuthenticationGraphYaxisTitle(String expectedTitle) {
    	String actualTitle = page.locator(YaxisTitle(ZookeeperSASLAuthenticationID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
	
	public void validateZookeeperSASLAuthenticationGraphTopicHeaderTitle(String expectedTitle) {
    	String actualTitle = page.locator(HeaderTitle(ZookeeperSASLAuthenticationID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
	
	public void validateZookeeperSASLAuthenticationGraphAvgHeaderTitle(String expectedTitle) {
    	String actualTitle = page.locator(AvgHeader(ZookeeperSASLAuthenticationID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
	
	public void validateZookeeperSASLAuthenticationGraphMaxHeaderTitle(String expectedTitle) {
    	String actualTitle = page.locator(MaxHeader(ZookeeperSASLAuthenticationID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
	
	public void validateZookeeperSASLAuthenticationGraphRowColor(String expectedTitle) {
    	String actualTitle = page.locator(RowColor(ZookeeperSASLAuthenticationID)).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
	
	public void validateZookeeperSASLAuthenticationToolTipTitle() {
        util.validateWidgetToolTips(page, XaxisLines(ZookeeperSASLAuthenticationID), ToolTipTitle(ZookeeperSASLAuthenticationID));
    }
  
	public void validateZookeeperSASLAuthenticationExpandViewXAxisTitle() {
		util.validateExpandViewTexts(page, XaxisTitle(ZookeeperSASLAuthenticationID), Expand(ZookeeperSASLAuthenticationID), expandViewCloseBtn, expandViewXaxisTitle);
	}

	public void validateZookeeperSASLAuthenticationExpandViewYAxisTitle() {
		util.validateExpandViewTexts(page, YaxisTitle(ZookeeperSASLAuthenticationID), Expand(ZookeeperSASLAuthenticationID), expandViewCloseBtn, expandViewYaxisTitle);
	}
	
	public void validateZookeeperSASLAuthenticationExpandViewWidgetTitle() {
		util.validateExpandViewTexts(page, getWidgetTitle(ZookeeperSASLAuthenticationID), Expand(ZookeeperSASLAuthenticationID), expandViewCloseBtn, expandViewWidgetTitle);
	}
	
	public void validateZookeeperSASLAuthenticationExpandViewLegendHeader1() {
		util.validateExpandViewTexts(page, LegendColumn1Title(ZookeeperSASLAuthenticationID), Expand(ZookeeperSASLAuthenticationID), expandViewCloseBtn, expandViewLegendColumn1HeaderTitle);
	}
	
	public void validateZookeeperSASLAuthenticationExpandViewLegendHeader2() {
		util.validateExpandViewTexts(page, LegendColumn2Title(ZookeeperSASLAuthenticationID), Expand(ZookeeperSASLAuthenticationID), expandViewCloseBtn, expandViewLegendColumn2HeaderTitle);
	}
	
	public void validateZookeeperSASLAuthenticationExpandViewLegendHeader3() {
		util.validateExpandViewTexts(page, LegendColumn3Title(ZookeeperSASLAuthenticationID), Expand(ZookeeperSASLAuthenticationID), expandViewCloseBtn, expandViewLegendColumn3HeaderTitle);
	}
	
	public void validateZookeeperSASLAuthenticationExpandViewLegendHeader2InforMessage() {
		util.validateExpandViewTexts(page, LegendColumn2Title(ZookeeperSASLAuthenticationID), Expand(ZookeeperSASLAuthenticationID), expandViewCloseBtn, expandViewLegendColumnHeader2infoMessage);
	}
	
	public void validateZookeeperSASLAuthenticationExpandViewLegendHeader3InforMessage() {
		util.validateExpandViewTexts(page, LegendColumn3Title(ZookeeperSASLAuthenticationID), Expand(ZookeeperSASLAuthenticationID), expandViewCloseBtn, expandViewLegendColumnHeader3infoMessage);
	}
	
	public void validateZookeeperSASLAuthenticationExpandViewZoomIn() {
		util.ExpandViewZoomInBtn(page, expandViewZoomInBtn, Expand(ZookeeperSASLAuthenticationID), expandViewCloseBtn, expandViewXaxisValues);
	}
	
	public void validateZookeeperSASLAuthenticationExpandViewZoomOut() {
		util.ExpandViewZoomOutBtn(page, expandViewZoomInBtn, Expand(ZookeeperSASLAuthenticationID), expandViewCloseBtn, expandViewZoomOutBtn, expandViewXaxisValues);
	}
	
	public void validateZookeeperSASLAuthenticationExpandViewWidgetDragDrop() {
		util.ExpandViewWidgetDragDrop(page, Expand(ZookeeperSASLAuthenticationID), expandViewCloseBtn, expandViewXaxisLines, expandViewZoomOutBtn, expandViewXaxisValues);
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

    private String XaxisValues(String id) {
    	return "xpath = //div[@id='"+id+"']/descendant::*[@class='apexcharts-text apexcharts-xaxis-label apexcharts-xaxis-label']/child::*[name()='tspan' and contains(text(),'-')]";
    }
	    
    private String XaxisLines(String id) {
		return "xpath = //div[@id='"+id+"']/descendant::*[@class='apexcharts-xaxis-tick']";
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