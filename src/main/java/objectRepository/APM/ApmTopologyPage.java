package objectRepository.APM;

import java.io.IOException;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Locator.ClickOptions;
import com.microsoft.playwright.Locator.HoverOptions;
import com.microsoft.playwright.Page;
import genericUtilities.ExcelUtility;
import genericUtilities.GenericMethods;
import genericUtilities.IPathConstant;
import objectRepository.CommonPage;

public class ApmTopologyPage {

	Page page;
	GenericMethods util = new GenericMethods();
	CommonPage common;
	ExcelUtility excel = new ExcelUtility();
	ApmApplicationPage dashboard;
		
    private String topologyNav = "#nav-tab-topology";
    private String addGroup = "#btn-add-group";
    private String addGroupPopUpTitle = "xpath = //div[@class='rex-modal-header-box']/div";
    private String errorMsgForGroupName = "xpath = (//p[@class='validation']//span)[2]";
    private String errorMsgForApplication = "xpath = (//p[@class='validation']//span)[2]";
    private String errorMsgsInAddGrpPopup = "xpath = //p[@class='validation']//span";
    private String chooseAppDropDown =  "#btn-arrow-down-search-select-add-grp-application";
    private String addApp = "#input-search-sel-search-select-add-grp-application";
    private String addAppSearchResult = "xpath = //div[@class='option' and contains(@id,'search-select-add-grp-application')]";
    private String addGroupPopupcloseButton = "xpath = //div[@class='ant-modal-content']/button[@class='ant-modal-close']";
    private String groupName = "#input-group-name";
    private String clearButton = "#btn-clr-add-grp";
    private String addButton = "#btn-submit-add-grp";
    private String grpDropdown = "#btn-arrow-down-search-select-choose-grp";
    private String searchGrp = "#input-search-sel-search-select-choose-grp";
    private String groupSearchresult = "xpath = //span[@class='selected-item-text' and contains(@id,'search-select-choose-grp-')]";
    private String selectedGroup = "xpath = //div[@id='search-select-choose-grp']/descendant::div[@class='selected-item-text']";
    private String select2ndGrp = "#search-select-choose-grp-1-single";

    private String mapView = "xpath = //span[.=' Map view']";
    private String tableView = "xpath = //span[.=' Table view']";
    private String topologyBlock = "xpath = //*[name()='text' and @class='topo-text-current']";
    private String topologyServerName = "xpath = //*[name()='text' and @class='topo-text-current']/preceding-sibling::*[name()='text']";
    private String topologyBlockImg = "xpath = //*[name()='text' and @class='topo-text-current']/preceding-sibling::*[name()='image']";
    private String endpointNav = "xpath = (//*[name()='path' and @class='tool-hexagon'])[1]";
    private String infrastructureNav = "xpath = (//*[name()='path' and @class='tool-hexagon'])[2]";
    private String instanceNav = "xpath = (//*[name()='path' and @class='tool-hexagon'])[3]";
    private String traceNav = "xpath = (//*[name()='path' and @class='tool-hexagon'])[4]";
    private String alertNav = "xpath = (//*[name()='path' and @class='tool-hexagon'])[5]";
    private String apmNav = "xpath = (//*[name()='path' and @class='tool-hexagon'])[6]";
    private String selectedServiceForAPMAlert = "xpath = //div[@id='search-select-application']/div[@class='selected-item-text']";
    private String tokenPath = "xpath = //div[@class='chip-text ellipsis']";
    private String confirmationMessage = "xpath = //div[@class='ant-notification-notice-with-icon']";
    private String messageCloseBtn = "xpath = //*[name()='svg' and @data-icon='close']";
    private String editGroupIcon = "#edit_filled";
    private String deleteGroupIcon = "#delete_filled";
    private String deleteBtn = "xpath = //div[@class='ant-modal-content']/descendant::button[contains(@class,'ant-btn ant-btn-primary')]";
    private String deleteGroupHeader = "xpath = //div[@class='rex-modal-header-box']";
    private String tableHeader = "xpath = //div[@class='top-container']";
    private String firstColInTableView = "xpath = (//div[@class='test'])[1]";
    private String secondColInTableView = "xpath = (//div[@class='test'])[2]";
    private String thirdColInTableView = "xpath = (//div[@class='test'])[3]";
    private String fourthColInTableView = "xpath = (//div[@class='test'])[4]";
    private String fifthColInTableView = "xpath = (//div[@class='test'])[5]";
    private String sixthColInTableView = "xpath = (//div[@class='test'])[6]";

    private String sourcesOnTable = "xpath = //div[@class='main-row']/div[1]";
    private String destinationsOnTable = "xpath = //div[@class='main-row']/div[2]";
    private String cpmOnTable = "xpath = //div[@class='main-row']/div[3]";
    private String responseTimesOnTable = "xpath = //div[@class='main-row']/div[4]";
    private String detectPointsOnTable = "xpath = //div[@class='main-row']/div[5]";

    private String closeToken = "xpath = //div[@class='chip-icon']//*[name()='svg']";
    private String topologyBlocks = "xpath = //*[name()='text' and contains(@class,'topo-text')]";

    private String apdexGraph = "xpath = (//div[@class='topo-chart-title'])[1]/div[@class='title-text']";
    private String apdexGraphXaxisTitle = "xpath = //div[@id='apexchartsApdex']//*[name()='g' and @class='apexcharts-xaxis-title']";
    private String apdexGraphYaxisTitle = "xpath = //div[@id='apexchartsApdex']//*[name()='g' and @class='apexcharts-yaxis-title']";
    private String apdexGraphZoomOutBtn = "xpath = (//div[.=' Apdex']/following-sibling::div[@class='line-icon']//span[@class='icon-class'])[1]";
    private String apdexGraphZoomInBtn = "xpath = (//div[.=' Apdex']/following-sibling::div[@class='line-icon']//span[@class='icon-class'])[2]";
    private String apdexGraphZoomResetBtn = "xpath = //div[.=' Apdex']/following-sibling::div[@class='line-icon']//span[@class='icon-class reset']";
    private String apdexGraphXaxisPoints = "xpath = //div[@id='apexchartsApdex']//*[name()='line' and @class='apexcharts-xaxis-tick']";
    private String apdexGraphTooltipTitle = "xpath = //div[@id='apexchartsApdex']//div[@class='apexcharts-tooltip-title']";
    private String apdexGraphTooltip = "xpath = //div[@id='apexchartsApdex']//div[@class='apexcharts-tooltip-series-group apexcharts-active']";
    private String apdexGraphXaxisLabels = "xpath = //div[@id='apexchartsApdex']//*[name()='g' and @class='apexcharts-xaxis-texts-g']//*[name()='tspan' and contains(text(),'-')]";

    private String responseGraph = "xpath = (//div[@class='topo-chart-title'])[2]/div[@class='title-text']";
    private String respTimeGraphXaxisTitle = "xpath = //div[@id='apexchartsResponsextime']//*[name()='g' and @class='apexcharts-xaxis-title']";
    private String respTimeGraphYaxisTitle = "xpath = //div[@id='apexchartsResponsextime']//*[name()='g' and @class='apexcharts-yaxis-title']";
    private String respTimeGraphZoomOutBtn = "xpath = (//div[.=' Response time']/following-sibling::div[@class='line-icon']//span[@class='icon-class'])[1]";
    private String respTimeGraphZoomInBtn = "xpath = (//div[.=' Response time']/following-sibling::div[@class='line-icon']//span[@class='icon-class'])[2]";
    private String respTimeGraphZoomResetBtn = "xpath = //div[.=' Response time']/following-sibling::div[@class='line-icon']//span[@class='icon-class reset']";
    private String respTimeGraphXaxisPoints = "xpath = //div[@id='apexchartsResponsextime']//*[name()='line' and @class='apexcharts-xaxis-tick']";
    private String respTimeGraphTooltipTitle = "xpath = //div[@id='apexchartsResponsextime']//div[@class='apexcharts-tooltip-title']";
    private String respTimeGraphTooltip = "xpath = //div[@id='apexchartsResponsextime']//div[@class='apexcharts-tooltip-series-group apexcharts-active']";
    private String respTimeGraphXaxisLabels = "xpath = //div[@id='apexchartsResponsextime']//*[name()='g' and @class='apexcharts-xaxis-texts-g']//*[name()='tspan' and contains(text(),'-')]";
    
    private String errorGraph = "xpath = (//div[@class='topo-chart-title'])[3]/div[@class='title-text']";
    private String errorGraphXaxisTitle = "xpath = //div[@id='apexchartsError']//*[name()='g' and @class='apexcharts-xaxis-title']";
    private String errorGraphYaxisTitle = "xpath = //div[@id='apexchartsError']//*[name()='g' and @class='apexcharts-yaxis-title']";
    private String errorGraphZoomOutBtn = "xpath = (//div[.=' Error']/following-sibling::div[@class='line-icon']//span[@class='icon-class'])[1]";
    private String errorGraphZoomInBtn = "xpath = (//div[.=' Error']/following-sibling::div[@class='line-icon']//span[@class='icon-class'])[2]";
    private String errorGraphZoomResetBtn = "xpath = //div[.=' Error']/following-sibling::div[@class='line-icon']//span[@class='icon-class reset']";
    private String errorGraphXaxisPoints = "xpath = //div[@id='apexchartsError']//*[name()='line' and @class='apexcharts-xaxis-tick']";
    private String errorGraphTooltipTitle = "xpath = //div[@id='apexchartsError']//div[@class='apexcharts-tooltip-title']";
    private String errorGraphTooltip = "xpath = //div[@id='apexchartsError']//div[@class='apexcharts-tooltip-series-group apexcharts-active']";
    private String errorGraphXaxisLabels = "xpath = //div[@id='apexchartsError']//*[name()='g' and @class='apexcharts-xaxis-texts-g']//*[name()='tspan' and contains(text(),'-')]";
    
    private String apdexScore = "xpath = (//div[@class='topo-chart-title'])[1]//div[@class='line-content']";
    private String responseTime = "xpath = (//div[@class='topo-chart-title'])[2]//div[@class='line-content']";
    private String errorPercentage = "xpath = (//div[@class='topo-chart-title'])[3]//span[@class='line-error-percentage']";
    private String errorValue = "xpath = (//div[@class='topo-chart-title'])[3]//span[@class='line-errors']";
    private String epmValue = "xpath = (//div[@class='topo-chart-title'])[3]//span[@class='line-errors']/following-sibling::span";
    private String applicationNameinGraph = "xpath = (//div[@class='topo-content'])[1]";
    private String serverNameinGraph = "xpath = (//div[@class='topo-content'])[2]";
    private String applicationNameinGraph1 = "xpath = (//div[@class='topo-content'])[3]";
    private String serverNameinGraph1 = "xpath = (//div[@class='topo-content'])[4]";

    private String apdexGraphCloseBtn = "xpath = //div[@class='close-btn']/span";
    private String errorGraphCloseBtn = "xpath = //div[@class='closbtn']";
    private String healthBar = "xpath = //div[@class='health-toolbar']";
    private String healthBarGoodText = "xpath = //div[@class='text good']";
    private String healthBarGoodIcon = "xpath = //div[@class='circle good']";
    private String healthBarFairText = "xpath = //div[@class='text fair']";
    private String healthBarFairIcon = "xpath = //div[@class='circle fair']";
    private String healthBarPoorText = "xpath = //div[@class='text poor']";
    private String healthBarPoorIcon = "xpath = //div[@class='circle poor']";
    private String healthInfoIcon = "xpath = //div[@class='info-icon']";
    private String healthTooltip = "xpath = //*[@class='healthTip']";
    private String healthTooltipValues = "xpath = //div[@class='healthinfo']/div[@class='indicate']";
    private String closeButton = "#btn-close-btn";
    private String softRefresgBtn = "#btn-refresh";
    private String detectPoint = "xpath = //*[name()='circle' and @class='topo-line-anchor' and @style='false']";
    private String detectPonitTooltip = "xpath = //div[@class='line-tooltip']";
    private String detectPointTooltip1stLine = "xpath = (//div[@class='d3-tip n' and contains(@style,'pointer-events: all')]//div[@class='text-bottom'])[1]";
    private String detectPointTooltip2ndLine = "xpath = (//div[@class='d3-tip n' and contains(@style,'pointer-events: all')]//div[@class='text-bottom'])[2]";
    private String detectPointTooltip3rdLine = "xpath = (//div[@class='d3-tip n' and contains(@style,'pointer-events: all')]//div[@class='text-bottom'])[3]";

    private String detectPointChartPanel = "xpath = //span[@class='topo-aside-header-text']";
    private String detectPointChartinfo = "xpath = //span[@class='active link-topo-aside-box-btn']";
    private String detPntResponseTimeGraph = "xpath = //div[@id='apexchartsResponsextime']/ancestor::div[@class='topo-charts']/preceding-sibling::div[@class='topo-chart-title']/child::div[@class='title-text']";
    private String detPntRespTimeXaxisTitle = "xpath = //div[@id='apexchartsResponsextime']//*[name()='g' and @class='apexcharts-xaxis-title']";
    private String detPntRespTimeYaxisTitle = "xpath = //div[@id='apexchartsResponsextime']//*[name()='g' and @class='apexcharts-yaxis-title']";
    private String detPntRespTimeZoomOutBtn = "xpath = (//div[.=' Response time']/following-sibling::div[@class='line-icon']//span[@class='icon-class'])[1]";
    private String detPntRespTimeZoomInBtn = "xpath = (//div[.=' Response time']/following-sibling::div[@class='line-icon']//span[@class='icon-class'])[2]";
    private String detPntRespTimeZoomResetBtn = "xpath = //div[.=' Response time']/following-sibling::div[@class='line-icon']//span[@class='icon-class reset']";
    private String detPntRespTimeXaxisPoints = "xpath = //div[@id='apexchartsResponsextime']//*[name()='line' and @class='apexcharts-xaxis-tick']";
    private String detPntRespTimeTooltipTitle = "xpath = //div[@id='apexchartsResponsextime']//div[@class='apexcharts-tooltip-title']";
    private String detPntRespTimeTooltipValue = "xpath = //div[@id='apexchartsResponsextime']//div[@class='apexcharts-tooltip-series-group apexcharts-active']";
    private String detPntRespTimeTooltipLabel = "xpath = //div[@id='apexchartsResponsextime']//div[@class='apexcharts-tooltip-series-group apexcharts-active']//span[@class='apexcharts-tooltip-text-y-label']";
    private String detPntRespTimeXaxisLabels = "xpath = //div[@id='apexchartsResponsextime']//*[name()='g' and @class='apexcharts-xaxis-texts-g']//*[name()='tspan' and contains(text(),'-')]";
    
    private String detPntPercentileResponsetimeGraph = "xpath = //div[@id='apexchartsPercentilexresponsextime']/ancestor::div[@class='topo-charts']/preceding-sibling::div[@class='topo-chart-title']/child::div[@class='title-text']";
    private String detPntPercentileRespTimeXaxisTitle = "xpath = //div[@id='apexchartsPercentilexresponsextime']//*[name()='g' and @class='apexcharts-xaxis-title']";
    private String detPntPercentileRespTimeYaxisTitle = "xpath = //div[@id='apexchartsPercentilexresponsextime']//*[name()='g' and @class='apexcharts-yaxis-title']";
    private String detPntPercentileRespTimeZoomOutBtn = "xpath = (//div[.=' Percentile response time']/following-sibling::div[@class='line-icon']//span[@class='icon-class'])[1]";
    private String detPntPercentileRespTimeZoomInBtn = "xpath = (//div[.=' Percentile response time']/following-sibling::div[@class='line-icon']//span[@class='icon-class'])[2]";
    private String detPntPercentileRespTimeZoomResetBtn = "xpath = (//div[.=' Percentile response time']/following-sibling::div[@class='line-icon']//span[@class='icon-class'])[3]";
    private String detPntPercentileRespTimeXaxisPoints = "xpath = //div[@id='apexchartsPercentilexresponsextime']//*[name()='line' and @class='apexcharts-xaxis-tick']";
    private String detPntPercentileRespTimeTooltipTitle = "xpath = //div[@id='apexchartsPercentilexresponsextime']//div[@class='apexcharts-tooltip-title']";
    private String detPntPercentileRespTimeTooltipLabel = "xpath = //div[@id='apexchartsPercentilexresponsextime']//div[@class='apexcharts-tooltip-series-group apexcharts-active']//span[@class='apexcharts-tooltip-text-y-label']";
    private String detPntPercentileRespTimeTooltipValue = "xpath = //div[@id='apexchartsPercentilexresponsextime']//div[@class='apexcharts-tooltip-series-group apexcharts-active']//span[@class='apexcharts-tooltip-text-y-value']";
    private String detPntPercentileRespTimeXaxisLabels = "xpath = //div[@id='apexchartsPercentilexresponsextime']//*[name()='g' and @class='apexcharts-xaxis-texts-g']//*[name()='tspan' and contains(text(),'-')]";
    private String detPntPercentileRespTimeLegendNames = "xpath = //div[@id='apexchartsPercentilexresponsextime']/descendant::span[contains(@class,'apexcharts-legend-text')]";
    private String detPntPercentileRespTimeTooltipColorMarker = "xpath = //div[@id='apexchartsPercentilexresponsextime']/descendant::span[@class='apexcharts-tooltip-marker']";
    private String detPntPercentileRespTimeTooltiplegendLine = "xpath = //div[@id='apexchartsPercentilexresponsextime']/descendant::*[name()='g' and @class='apexcharts-series']/child::*[name()='path' and @fill='none']";
    private String detPntPercentileRespTimeLegendColorMarkers = "xpath = //div[@id='apexchartsPercentilexresponsextime']/descendant::span[contains(@class,'apexcharts-legend-marker')]";
    
    private String detPntLoadGraph = "xpath = //div[@id='apexchartsLoad']/ancestor::div[@class='topo-charts']/preceding-sibling::div[@class='topo-chart-title']/child::div[@class='title-text']";
    private String detPntLoadXaxisTitle = "xpath = //div[@id='apexchartsLoad']//*[name()='g' and @class='apexcharts-xaxis-title']";
    private String detPntLoadYaxisTitle = "xpath = //div[@id='apexchartsLoad']//*[name()='g' and @class='apexcharts-yaxis-title']";
    private String detPntLoadZoomOutBtn = "xpath = (//div[.=' Load']/following-sibling::div[@class='line-icon']//span[@class='icon-class'])[1]";
    private String detPntLoadZoomInBtn = "xpath = (//div[.=' Load']/following-sibling::div[@class='line-icon']//span[@class='icon-class'])[2]";
    private String detPntLoadZoomResetBtn = "xpath = //div[.=' Load']/following-sibling::div[@class='line-icon']//span[@class='icon-class reset']";
    private String detPntLoadXaxisPoints = "xpath = //div[@id='apexchartsLoad']//*[name()='line' and @class='apexcharts-xaxis-tick']";
    private String detPntLoadTooltipTitle = "xpath = //div[@id='apexchartsLoad']//div[@class='apexcharts-tooltip-title']";
    private String detPntLoadTooltipValue = "xpath = //div[@id='apexchartsLoad']//div[@class='apexcharts-tooltip-series-group apexcharts-active']";
    private String detPntLoadXaxisLabels = "xpath = //div[@id='apexchartsLoad']//*[name()='g' and @class='apexcharts-xaxis-texts-g']//*[name()='tspan' and contains(text(),'-')]";
    
    private String detPntErrorGraph = "xpath = //div[@id='apexchartsError']/ancestor::div[@class='topo-charts']/preceding-sibling::div[@class='topo-chart-title']/child::div[@class='title-text']";
    private String detPntErrorXaxisTitle = "xpath = //div[@id='apexchartsError']//*[name()='g' and @class='apexcharts-xaxis-title']";
    private String detPntErrorYaxisTitle = "xpath = //div[@id='apexchartsError']//*[name()='g' and @class='apexcharts-yaxis-title']";
    private String detPntErrorZoomOutBtn = "xpath = (//div[.=' Error']/following-sibling::div[@class='line-icon']//span[@class='icon-class'])[1]";
    private String detPntErrorZoomInBtn = "xpath = (//div[.=' Error']/following-sibling::div[@class='line-icon']//span[@class='icon-class'])[2]";
    private String detPntErrorZoomResetBtn = "xpath = //div[.=' Error']/following-sibling::div[@class='line-icon']//span[@class='icon-class reset']";
    private String detPntErrorXaxisPoints = "xpath = //div[@id='apexchartsError']//*[name()='line' and @class='apexcharts-xaxis-tick']";
    private String detPntErrorTooltipTitle = "xpath = //div[@id='apexchartsError']//div[@class='apexcharts-tooltip-title']";
    private String detPntErrorTooltipValue = "xpath = //div[@id='apexchartsError']//div[@class='apexcharts-tooltip-series-group apexcharts-active']";
    private String detPntErrorXaxisLabels = "xpath = //div[@id='apexchartsError']//*[name()='g' and @class='apexcharts-xaxis-texts-g']//*[name()='tspan' and contains(text(),'-')]";
    
    private String detPntResponseTime = "xpath = //div[@id='apexchartsResponsextime']/ancestor::div[@class='topo-charts']/preceding-sibling::div[@class='topo-chart-title']/descendant::div[@class='line-content']";
    private String callsOnDetPntLoadGraph = "xpath = (//div[@class='topo-chart-title'])[3]//span[@class='line-content-calls']";
    private String cpmOnDetPntLoadGraph = "xpath = //div[@id='apexchartsLoad']/ancestor::div[@class='topo-charts']/preceding-sibling::div[@class='topo-chart-title']//div[@class='line-content']/span[@class='line-content-calls']/following-sibling::span";
    private String errorPercentageOnDetPntErrorGraph = "xpath = (//div[@class='topo-chart-title'])[4]//span[@class='line-error-percentage']";
    private String errorsOnDetPntErrorGraph = "xpath = (//div[@class='topo-chart-title'])[4]//span[@class='line-errors']";
    private String epmOnDetPntErrorGraph = "xpath = (//div[@class='topo-chart-title'])[4]//span[@class='line-errors']/following-sibling::span";
    private String instanceDepedencyBtn = "xpath = //div[@class='show-dependency']";
    private String instanceDepedencyMainTitle = "xpath = //div[@class='rex-sidebox-title']/span[@class='rex-main-title']";
    private String instanceDepedencySubTitle = "xpath = //div[@class='rex-sidebox-title']/span[@class='title']";
    private String instanceDepedencyCloseBtn = "xpath = //div[@class='closbtnleft']";

    private String userIndicatorOnTable = "xpath = //span[.='User']/../preceding-sibling::div[@class='indicator-body']//div[@class='indicate']";
    private String tabHeader = "xpath = //span[@class='tab-name']";
    private String endpointTab = "#dasboard-tab-endpoint";
    private String instanceTab = "#dasboard-tab-instance";
    private String traceTab = "#nav-tab-trace";
    private String applicationTab = "#dasboard-tab-service";
    private String infrastructureTab = "#dasboard-tab-infra";
    private String selectedTimeline = "xpath = //div[@class='selected-text ellipsis bg-text']";
     
    List<String> xPoints = new ArrayList<String>();
	{
		xPoints.add(apdexGraphXaxisPoints);
		xPoints.add(respTimeGraphXaxisPoints);
		xPoints.add(errorGraphXaxisPoints);
	}
	
	List<String> xPoints1 = new ArrayList<String>();
	{
		xPoints1.add(detPntRespTimeXaxisPoints);
		xPoints1.add(detPntPercentileRespTimeXaxisPoints);
		xPoints1.add(detPntLoadXaxisPoints);
		xPoints1.add(detPntErrorXaxisPoints);
	}
	
	List<String> xAxisLabels = new ArrayList<String>();
	{
		xAxisLabels.add(apdexGraphXaxisLabels);
		xAxisLabels.add(respTimeGraphXaxisLabels);
		xAxisLabels.add(errorGraphXaxisLabels);
	}
	
	List<String> xAxisLabels1 = new ArrayList<String>();
	{
		xAxisLabels1.add(detPntRespTimeXaxisLabels);
		xAxisLabels1.add(detPntPercentileRespTimeXaxisLabels);
		xAxisLabels1.add(detPntLoadXaxisLabels);
		xAxisLabels1.add(detPntErrorXaxisLabels);
	}

    public ApmTopologyPage(Page page) {
		this.page = page;
	}
    
    public void navigateToTopologyPage() {
    	page.click(topologyNav);
		page.waitForURL("**/topology");
		Assert.assertTrue(page.isVisible(addGroup));
    }
    
    public void validateAddGroupButton() throws EncryptedDocumentException, IOException {
    	String title = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.topologyPageSheet, "addGroupBtnTitle");
    	util.ValidateTheTitle(page.textContent(addGroup).trim(), title);
    	page.click(addGroup);
    	String title1 = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.topologyPageSheet, "addGroupPopupTitle");
    	util.ValidateTheTitle(page.textContent(addGroupPopUpTitle).trim(), title1);
    	page.click(addGroupPopupcloseButton);
    }
    
    public void validateGroupnameFieldOfAddGroupPopupWithNoData() throws EncryptedDocumentException, IOException {
    	page.click(addGroup);
    	//page.waitForSelector(addGroupPopUpTitle);
    	page.locator(groupName).click();
    	page.locator(groupName).fill(" ");
    	page.waitForSelector(errorMsgForGroupName);
    	String expectedMsg = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath, IPathConstant.messageSheet, "TopologyPage_ErrorMsgForEmptyGroupName");
    	String actualMsg = page.textContent(errorMsgForGroupName).trim();
    	Assert.assertTrue(actualMsg.equalsIgnoreCase(expectedMsg));
    	page.locator(addGroupPopupcloseButton).click();
    }
    
    public void validateGroupnameFieldOfAddGroupPopupWithDuplicateData() throws EncryptedDocumentException, IOException {
    	page.click(grpDropdown);
    	String existingGroup = page.textContent(select2ndGrp).trim();
    	page.click(addGroup);
    	page.waitForSelector(addGroupPopUpTitle);
    	page.locator(groupName).clear();
    	page.locator(groupName).fill(existingGroup);
    	page.waitForSelector(errorMsgForGroupName);
    	String expectedMsg = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath, IPathConstant.messageSheet, "TopologyPage_ErrorMsgForDuplicateGroupName");
    	String actualMsg = page.textContent(errorMsgForGroupName).trim();
    	Assert.assertTrue(actualMsg.equalsIgnoreCase(expectedMsg));
    	page.locator(addGroupPopupcloseButton).click();
    }
    
    public void validateApplicationsOptionInAddGroupPopupWithNoData() throws EncryptedDocumentException, IOException {
    	String grpName = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.topologyPageSheet, "groupNameForAddingGroup");
    	try{
    		validateWhetherAGroupCanBeDeleted(grpName);
    	} catch(Exception e) {}
    	page.click(addGroup);
    	page.waitForTimeout(200);
    	//page.waitForSelector(addGroupPopUpTitle);
    	page.locator(groupName).click();
    	page.locator(groupName).fill(grpName);
    	page.click(addButton);
    	page.waitForSelector(errorMsgForApplication);
    	String expectedMsg = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath, IPathConstant.messageSheet, "TopologyPage_ErrorMsgForEmptyApplicationName");
    	String actualMsg = page.textContent(errorMsgForApplication).trim();
    	Assert.assertTrue(actualMsg.equalsIgnoreCase(expectedMsg));
    	page.locator(addGroupPopupcloseButton).click();
    }
    
    public void validateClearButtonFunctionalityInAddGroupPopup() throws EncryptedDocumentException, IOException {
    	String grpName = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.topologyPageSheet, "groupNameForAddingGroup");
    	try{
    		validateWhetherAGroupCanBeDeleted(grpName);
    	} catch(Exception e) {}
    	page.waitForTimeout(1000);
    	page.click(addGroup);
    	page.waitForSelector(groupName);
    	page.locator(groupName).click();
    	page.locator(groupName).fill(grpName);
    	page.click(clearButton);
    	Locator errors = page.locator(errorMsgsInAddGrpPopup);
    	int count = 0;
    	String expectedMsg = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath, IPathConstant.messageSheet, "TopologyPage_ErrorMsgForEmptyGroupName");
    	String expectedMsg1 = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath, IPathConstant.messageSheet, "TopologyPage_ErrorMsgForEmptyApplicationName");
    	for(int i=0; i<errors.count(); i++) {
    		String msg = errors.nth(i).textContent().trim();
    		if(msg.equalsIgnoreCase(expectedMsg) || msg.equalsIgnoreCase(expectedMsg1))
    		{
    			count++;
    		}
    	}
    	Assert.assertTrue(count == 2);
    	page.locator(addGroupPopupcloseButton).click();
    }
    
    public void validateAddingApplicationInAddGroupPopup() throws EncryptedDocumentException, IOException {
    	String grpName = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.topologyPageSheet, "groupNameForAddingGroup");
    	String application = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.applicationNameSheet, "APM");
    	page.click(addGroup);
    	page.waitForSelector(addGroupPopUpTitle);
    	page.locator(groupName).clear();
    	page.locator(groupName).fill(grpName);
    	util.selectTheOptionFromDropDownBySearch(page, chooseAppDropDown, addApp, application, addAppSearchResult);
    	page.click(chooseAppDropDown);
    	Locator tokens = page.locator(tokenPath);
    	boolean flag = false;
    	for(int i=0; i<tokens.count(); i++) {
    		if(tokens.nth(i).textContent().trim().equals(application)) {
    			flag = true;
    			break;
    		}
    	}
    	Assert.assertTrue(flag);
    	page.locator(addGroupPopupcloseButton).click();
    }
    
    public void validateWhetherSelectedApplicationIsDisplayingAsAnIndividualToken() throws EncryptedDocumentException, IOException {
    	String grpName = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.topologyPageSheet, "groupNameForAddingGroup");
    	String application = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.applicationNameSheet, "APM");
    	page.click(addGroup);
    	page.waitForSelector(addGroupPopUpTitle);
    	page.locator(groupName).clear();
    	page.locator(groupName).fill(grpName);
    	util.selectTheOptionFromDropDownBySearch(page, chooseAppDropDown, addApp, application, addAppSearchResult);
    	page.click(chooseAppDropDown);
    	Locator tokens = page.locator(tokenPath);
    	Assert.assertTrue(tokens.count() == 1);
    	Assert.assertTrue(tokens.first().textContent().trim().equals(application));
    	page.click(closeToken);
    	Assert.assertTrue(tokens.count() == 0);
    	page.locator(addGroupPopupcloseButton).click();
    }
    
    public void validateWhetherNewGroupwithSingleApplicationCanBeAdded() throws EncryptedDocumentException, IOException {
    	String grpName = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.topologyPageSheet, "groupNameForAddingGroup");
    	try {
    		validateWhetherAGroupCanBeDeleted(grpName);
    	}
    	catch(Exception e) {}
    	String application = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.applicationNameSheet, "APM");
    	page.click(addGroup);
    	page.waitForSelector(addGroupPopUpTitle);
    	page.locator(groupName).clear();
    	page.locator(groupName).fill(grpName);
    	util.selectTheOptionFromDropDownBySearch(page, chooseAppDropDown, addApp, application, addAppSearchResult);
    	page.click(chooseAppDropDown);
    	page.click(addButton);
    	String messsage1 = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.messageSheet, "TopologyPage_CreateGroupConfirmationMsg");
    	Assert.assertTrue(page.textContent(confirmationMessage).trim().contains(messsage1));
    	page.click(messageCloseBtn);
    	util.selectTheOptionFromDropDownBySearch(page, grpDropdown, searchGrp, grpName, groupSearchresult);
    	Assert.assertTrue(page.textContent(selectedGroup).trim().equalsIgnoreCase(grpName));
    }
    
    public void validateWhetherAGroupCanBeEdited() throws EncryptedDocumentException, IOException {
    	String grpName = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.topologyPageSheet, "groupNameForAddingGroup");
    	String title1 = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.topologyPageSheet, "editGroupPopupTitle");
    	String editName = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.topologyPageSheet, "groupNameForEditingGroup");
    	try{
    		validateWhetherAGroupCanBeDeleted(editName);
    	} catch(Exception e) {}
    	String messsage = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.messageSheet, "TopologyPage_UpdateGroupConfirmationMsg");
    	page.locator(grpDropdown).click();
    	page.locator(grpDropdown).click();
    	page.locator(searchGrp).fill(grpName);
    	page.waitForSelector(groupSearchresult);
    	Locator groups = page.locator(groupSearchresult);
    	Locator editGrp = page.locator(editGroupIcon);
    	for(int i=0; i<groups.count(); i++) {
    		if(groups.nth(i).textContent().trim().equalsIgnoreCase(grpName))
    		{
    			editGrp.nth(i).click();
    			break;
    		}
    	}
    	Assert.assertTrue(page.textContent(addGroupPopUpTitle).trim().equalsIgnoreCase(title1));
    	System.out.println(editName);
    	page.locator(groupName).click();
    	page.locator(groupName).fill(editName);
    	page.click(addButton);
    	Assert.assertTrue(page.textContent(confirmationMessage).trim().contains(messsage));
    	page.click(messageCloseBtn);
    	util.selectTheOptionFromDropDownBySearch(page, grpDropdown, searchGrp, editName, groupSearchresult);
    	Assert.assertTrue(page.textContent(selectedGroup).trim().equalsIgnoreCase(editName));
    }
    
    public void validateWhetherAGroupCanBeDeleted(String grpName) throws EncryptedDocumentException, IOException {
    	String messsage = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.messageSheet, "TopologyPage_DeleteGroupConfirmationMsg");
    	String title = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.topologyPageSheet, "deleteGroupPopupTitle");
    	page.click(grpDropdown);
    	page.locator(searchGrp).fill(grpName);
    	page.waitForSelector(groupSearchresult);
    	Locator groups = page.locator(groupSearchresult);
    	Locator deleteGrp = page.locator(deleteGroupIcon);
    	for(int i=0; i<groups.count(); i++) {
    		if(groups.nth(i).textContent().trim().equalsIgnoreCase(grpName))
    		{
    			deleteGrp.nth(i).click();
    			break;
    		}
    	}
    	Assert.assertTrue(page.textContent(addGroupPopUpTitle).trim().equalsIgnoreCase(title));
    	page.click(deleteBtn);
    	Assert.assertTrue(page.textContent(confirmationMessage).trim().contains(messsage));
    	page.click(messageCloseBtn);
    	page.click(grpDropdown);
    	page.fill(searchGrp, grpName);
    	Assert.assertTrue(page.locator(groupSearchresult).count() == 0);
    	page.waitForTimeout(500);
    	page.click(grpDropdown);
    }
    
    public void validateWhetherNewGroupwithMultipleApplicationsCanBeAdded() throws EncryptedDocumentException, IOException {
    	String appNames = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.topologyPageSheet, "multipleApplicationsForGroup");
    	String grpName = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.topologyPageSheet, "groupNameForAddingGroup");
    	String messsage = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.messageSheet, "TopologyPage_CreateGroupConfirmationMsg");
    	String title = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.topologyPageSheet, "deleteGroupPopupTitle");
    	String[] apps = appNames.split(",");
    	page.click(addGroup);
    	page.waitForSelector(addGroupPopUpTitle);
    	page.fill(groupName, grpName);
    	for (int i = 0; i < apps.length; i++) {
    		util.selectTheOptionFromDropDownBySearch(page, chooseAppDropDown, addApp, apps[i], addAppSearchResult);
        	page.click(chooseAppDropDown);
		}
    	Assert.assertTrue(page.locator(tokenPath).count() == 3);
    	page.click(addButton);
    	Assert.assertTrue(page.textContent(confirmationMessage).trim().contains(messsage));
    	util.selectTheOptionFromDropDownBySearch(page, grpDropdown, searchGrp, grpName, groupSearchresult);
    	Assert.assertTrue(page.textContent(selectedGroup).trim().equalsIgnoreCase(grpName));
    	page.click(grpDropdown);
    	page.locator(searchGrp).fill(grpName);
    	page.waitForSelector(groupSearchresult);
    	Locator groups = page.locator(groupSearchresult);
    	Locator deleteGrp = page.locator(deleteGroupIcon);
    	for(int i=0; i<groups.count(); i++) {
    		if(groups.nth(i).textContent().trim().equalsIgnoreCase(grpName))
    		{
    			deleteGrp.nth(i).click();
    			break;
    		}
    	}
    	Assert.assertTrue(page.textContent(addGroupPopUpTitle).trim().equalsIgnoreCase(title));
    	page.click(deleteBtn);
    	Assert.assertTrue(page.textContent(confirmationMessage).trim().contains(messsage));
    	Locator msgClose = page.locator(messageCloseBtn);
    	for(int i=0; i<msgClose.count(); i++) {
    		msgClose.nth(i).click();
    	}
    }
   
    public void validateTheFirstColumnNameInTableView() throws EncryptedDocumentException, IOException {
    	page.click(tableView);
    	String expectedTitle = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.topologyPageSheet, "TableView_FirstColName");
    	String actualTitle = page.textContent(firstColInTableView).trim();
    	System.out.println("expectedTitle : "+expectedTitle+"\tactualTitle : "+actualTitle);
    	Assert.assertTrue(actualTitle.equals(expectedTitle));
    }
    
    public void validateTheSecondColumnNameInTableView() throws EncryptedDocumentException, IOException {
    	page.click(tableView);
    	String expectedTitle = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.topologyPageSheet, "TableView_SecondColName");
    	String actualTitle = page.textContent(secondColInTableView).trim();
    	System.out.println("expectedTitle : "+expectedTitle+"\tactualTitle : "+actualTitle);
    	Assert.assertTrue(actualTitle.equals(expectedTitle));
    }
    
    public void validateTheThirdColumnNameInTableView() throws EncryptedDocumentException, IOException {
    	page.click(tableView);
    	String expectedTitle = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.topologyPageSheet, "TableView_ThirdColName");
    	String actualTitle = page.textContent(thirdColInTableView).trim();
    	System.out.println("expectedTitle : "+expectedTitle+"\tactualTitle : "+actualTitle);
    	Assert.assertTrue(actualTitle.equals(expectedTitle));
    }
    
    public void validateTheFourthColumnNameInTableView() throws EncryptedDocumentException, IOException {
    	page.click(tableView);
    	String expectedTitle = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.topologyPageSheet, "TableView_FourthColName");
    	String actualTitle = page.textContent(fourthColInTableView).trim();
    	System.out.println("expectedTitle : "+expectedTitle+"\tactualTitle : "+actualTitle);
    	Assert.assertTrue(actualTitle.equals(expectedTitle));
    }
    
    public void validateTheFifthColumnNameInTableView() throws EncryptedDocumentException, IOException {
    	page.click(tableView);
    	String expectedTitle = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.topologyPageSheet, "TableView_FifthColName");
    	String actualTitle = page.textContent(fifthColInTableView).trim();
    	System.out.println("expectedTitle : "+expectedTitle+"\tactualTitle : "+actualTitle);
    	Assert.assertTrue(actualTitle.equals(expectedTitle));
    }
    
    public void validateTheSixthColumnNameInTableView() throws EncryptedDocumentException, IOException {
    	page.click(tableView);
    	String expectedTitle = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.topologyPageSheet, "TableView_SixthColName");
    	String actualTitle = page.textContent(sixthColInTableView).trim();
    	System.out.println("expectedTitle : "+expectedTitle+"\tactualTitle : "+actualTitle);
    	Assert.assertTrue(actualTitle.equals(expectedTitle));
    }
    
    public void validateNaviagtionToAlertsPageFromTopologyPage() {
    	ClickOptions clickOpt = new ClickOptions();
    	clickOpt.setForce(true);
    	page.click(mapView);
    	page.click(topologyBlock);
    	page.locator(alertNav).click(clickOpt);
    	page.waitForURL("**/alertsV2/generatedV2");
    	Assert.assertTrue(page.textContent(tabHeader).trim().equals("Alerts"));
    }
    
    public void validateNaviagtionToEndpointPageFromTopologyPage() {
    	ClickOptions clickOpt = new ClickOptions();
    	clickOpt.setForce(true);
    	page.click(mapView);
    	page.click(topologyBlock);
    	page.locator(endpointNav).click(clickOpt);
    	page.waitForURL("**/endpoint/endpoint-table");
    	String text = page.locator(endpointTab).getAttribute("class");
    	Assert.assertTrue(text.contains("activeTab"));
    }
    
    public void validateNaviagtionToInstancePageFromTopologyPage() {
    	ClickOptions clickOpt = new ClickOptions();
    	clickOpt.setForce(true);
    	page.click(mapView);
    	page.click(topologyBlock);
    	page.locator(instanceNav).click(clickOpt);
    	page.waitForURL("**/instance/instance-table");
    	String text = page.locator(instanceTab).getAttribute("class");
    	Assert.assertTrue(text.contains("activeTab"));
    }
    
    public void validateNaviagtionToTracePageFromTopologyPage() {
    	ClickOptions clickOpt = new ClickOptions();
    	clickOpt.setForce(true);
    	page.click(mapView);
    	page.click(topologyBlock);
    	page.locator(traceNav).click(clickOpt);
    	page.waitForURL("**/apm/trace");
    	String text = page.locator(traceTab).getAttribute("class");
    	Assert.assertTrue(text.contains("activeRouter"));
    }
    
    public void validateNaviagtionToApmPageFromTopologyPage() {
    	ClickOptions clickOpt = new ClickOptions();
    	clickOpt.setForce(true);
    	page.click(mapView);
    	page.click(topologyBlock);
    	page.locator(apmNav).click(clickOpt);
    	page.waitForURL("**/apm/dashboard/service");
    	String text = page.locator(applicationTab).getAttribute("class");
    	Assert.assertTrue(text.contains("activeTab"));
    }
    
    public void validateNaviagtionToInfrastructurePageFromTopologyPage() {
    	ClickOptions clickOpt = new ClickOptions();
    	clickOpt.setForce(true);
    	page.click(mapView);
    	page.click(topologyBlock);
    	page.locator(infrastructureNav).click(clickOpt);
    	page.waitForURL("**/infra/instances");
    	String text = page.locator(infrastructureTab).getAttribute("class");
    	Assert.assertTrue(text.contains("activeTab"));
    }
    
    public void validateTheTitleOfApdexGraph() throws EncryptedDocumentException, IOException {
    	String expectedTitle = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.topologyPageSheet, "apdexGraphTitle");
    	navigateToTopologyPage();
		selectApplicationGroupAndMapViewForDataValidation();
    	navigateToApplicationOverviewGraph();
    	String actualTitle = page.textContent(apdexGraph).trim();
    	System.out.println("expectedTitle : "+expectedTitle+"\t actualTitle :"+actualTitle);
    	Assert.assertTrue(actualTitle.equals(expectedTitle));
    }
    
    public void validateTheXaxisTitleOfApdexGraph() throws EncryptedDocumentException, IOException {
    	String expectedTitle = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.topologyPageSheet, "xAxisTitle");
    	navigateToTopologyPage();
		selectApplicationGroupAndMapViewForDataValidation();
    	navigateToApplicationOverviewGraph();
    	String actualTitle = page.textContent(apdexGraphXaxisTitle).trim();
    	System.out.println("expectedTitle : "+expectedTitle+"\t actualTitle :"+actualTitle);
    	Assert.assertTrue(actualTitle.equals(expectedTitle));
    }
    
    public void validateTheYaxisTitleOfApdexGraph() throws EncryptedDocumentException, IOException {
    	String expectedTitle = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.topologyPageSheet, "apdexGraphYaxisTitle");
    	navigateToTopologyPage();
		selectApplicationGroupAndMapViewForDataValidation();
    	navigateToApplicationOverviewGraph();
    	String actualTitle = page.textContent(apdexGraphYaxisTitle).trim();
    	System.out.println("expectedTitle : "+expectedTitle+"\t actualTitle :"+actualTitle);
    	Assert.assertTrue(actualTitle.equals(expectedTitle));
    }
    
    public void validateTheFunctionalityOfApdexGraphZoomInButton () throws EncryptedDocumentException, IOException {
    	navigateToTopologyPage();
		selectApplicationGroupAndMapViewForDataValidation();
    	navigateToApplicationOverviewGraph();
		util.graphZoomIn(page, apdexGraphZoomInBtn, apdexGraphZoomResetBtn, xPoints);
	}
    
    public void validateTheFunctionalityOfApdexGraphZoomOutButton () throws EncryptedDocumentException, IOException {
    	navigateToTopologyPage();
		selectApplicationGroupAndMapViewForDataValidation();
    	navigateToApplicationOverviewGraph();
		util.graphZoomOut(page, apdexGraphZoomInBtn, apdexGraphZoomOutBtn, apdexGraphZoomResetBtn, xPoints);
	}
    
    public void validateTheFunctionalityOfApdexGraphZoomResetButton () throws EncryptedDocumentException, IOException {
    	navigateToTopologyPage();
		selectApplicationGroupAndMapViewForDataValidation();
    	navigateToApplicationOverviewGraph();
		util.graphZoomReset(page, apdexGraphZoomInBtn, apdexGraphZoomResetBtn, xPoints);
	}
    
    public void validateZoomInByDragAndDropForApdexGraph() throws EncryptedDocumentException, IOException {
    	navigateToTopologyPage();
		selectApplicationGroupAndMapViewForDataValidation();
    	navigateToApplicationOverviewGraph();
    	page.waitForSelector(apdexGraphZoomResetBtn);
	    HoverOptions hoverOptions=new HoverOptions();
	    hoverOptions.setForce(true);
	    Locator xpnt = page.locator(apdexGraphXaxisPoints);
	    
	    xpnt.nth(1).hover(hoverOptions);
	    page.mouse().down();
	    xpnt.nth(3).hover(hoverOptions);
	    page.mouse().up();
	    for (String xPoint : xPoints) {
	    	Locator points = (page.locator(xPoint));
	    	System.out.println(points.count());
	    	Assert.assertTrue(points.count()==3);
	    }
    }
    
    public void validateTheTitleOfResponseTimeGraph() throws EncryptedDocumentException, IOException {
    	String expectedTitle = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.topologyPageSheet, "responseTimeGraphTitle");
    	navigateToTopologyPage();
		selectApplicationGroupAndMapViewForDataValidation();
    	navigateToApplicationOverviewGraph();
    	page.waitForSelector(responseGraph);
    	String actualTitle = page.textContent(responseGraph).trim();
    	System.out.println("expectedTitle : "+expectedTitle+"\t actualTitle :"+actualTitle);
    	Assert.assertTrue(actualTitle.equals(expectedTitle));
    }
    
    public void validateTheXaxisTitleOfResponseTimeGraph() throws EncryptedDocumentException, IOException {
    	String expectedTitle = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.topologyPageSheet, "xAxisTitle");
    	navigateToTopologyPage();
		selectApplicationGroupAndMapViewForDataValidation();
    	navigateToApplicationOverviewGraph();
    	page.waitForSelector(responseGraph);
    	String actualTitle = page.textContent(respTimeGraphXaxisTitle).trim();
    	System.out.println("expectedTitle : "+expectedTitle+"\t actualTitle :"+actualTitle);
    	Assert.assertTrue(actualTitle.equals(expectedTitle));
    }
    
    public void validateTheYaxisTitleOfResponseTimeGraph() throws EncryptedDocumentException, IOException {
    	String expectedTitle = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.topologyPageSheet, "responseTimeGraphYaxisTitle");
    	navigateToTopologyPage();
		selectApplicationGroupAndMapViewForDataValidation();
    	navigateToApplicationOverviewGraph();
    	page.waitForSelector(responseGraph);
    	String actualTitle = page.textContent(respTimeGraphYaxisTitle).trim();
    	System.out.println("expectedTitle : "+expectedTitle+"\t actualTitle :"+actualTitle);
    	Assert.assertTrue(actualTitle.equals(expectedTitle));
    }
    
    public void validateTheFunctionalityOfResponseTimeGraphZoomInButton () throws EncryptedDocumentException, IOException {
    	navigateToTopologyPage();
		selectApplicationGroupAndMapViewForDataValidation();
    	navigateToApplicationOverviewGraph();
		util.graphZoomIn(page, respTimeGraphZoomInBtn, respTimeGraphZoomResetBtn, xPoints);
	}
    
    public void validateTheFunctionalityOfResponseTimeGraphZoomOutButton () throws EncryptedDocumentException, IOException {
    	navigateToTopologyPage();
		selectApplicationGroupAndMapViewForDataValidation();
    	navigateToApplicationOverviewGraph();
    	page.waitForSelector(responseGraph);
		util.graphZoomOut(page, respTimeGraphZoomInBtn, respTimeGraphZoomOutBtn, respTimeGraphZoomResetBtn, xPoints);
	}
    
    public void validateTheFunctionalityOfResponseTimeGraphZoomResetButton () throws EncryptedDocumentException, IOException {
    	navigateToTopologyPage();
		selectApplicationGroupAndMapViewForDataValidation();
    	navigateToApplicationOverviewGraph();
		util.graphZoomReset(page, respTimeGraphZoomInBtn, respTimeGraphZoomResetBtn, xPoints);
	}
    
    public void validateZoomInByDragAndDropForResponseTimeGraph() throws EncryptedDocumentException, IOException {
    	navigateToTopologyPage();
		selectApplicationGroupAndMapViewForDataValidation();
    	navigateToApplicationOverviewGraph();
    	page.waitForSelector(respTimeGraphZoomResetBtn);
	    HoverOptions hoverOptions=new HoverOptions();
	    hoverOptions.setForce(true);
	    Locator xpnt = page.locator(respTimeGraphXaxisPoints);
	    
	    xpnt.nth(1).hover(hoverOptions);
	    page.mouse().down();
	    xpnt.nth(3).hover(hoverOptions);
	    page.mouse().up();
	    for (String xPoint : xPoints) {
	    Locator points = (page.locator(xPoint));
	    System.out.println(points.count());
	    Assert.assertTrue(points.count()==3);
	    }
    }
    
    public void validateTheTitleOfErrorGraph() throws EncryptedDocumentException, IOException {
    	String expectedTitle = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.topologyPageSheet, "errorGraphTitle");
    	navigateToTopologyPage();
		selectApplicationGroupAndMapViewForDataValidation();
    	navigateToApplicationOverviewGraph();
    	page.waitForSelector(errorGraph);
    	String actualTitle = page.textContent(errorGraph).trim();
    	System.out.println("expectedTitle : "+expectedTitle+"\t actualTitle :"+actualTitle);
    	Assert.assertTrue(actualTitle.equals(expectedTitle));
    }
    
    public void validateTheXaxisTitleOfErrorGraph() throws EncryptedDocumentException, IOException {
    	String expectedTitle = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.topologyPageSheet, "xAxisTitle");
    	navigateToTopologyPage();
		selectApplicationGroupAndMapViewForDataValidation();
    	navigateToApplicationOverviewGraph();
    	page.waitForSelector(errorGraph);
    	String actualTitle = page.textContent(errorGraphXaxisTitle).trim();
    	System.out.println("expectedTitle : "+expectedTitle+"\t actualTitle :"+actualTitle);
    	Assert.assertTrue(actualTitle.equals(expectedTitle));
    }
    
    public void validateTheYaxisTitleOfErrorGraph() throws EncryptedDocumentException, IOException {
    	String expectedTitle = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.topologyPageSheet, "errorGraphYaxisTitle");
    	navigateToTopologyPage();
		selectApplicationGroupAndMapViewForDataValidation();
    	navigateToApplicationOverviewGraph();
    	page.waitForSelector(errorGraph);
    	String actualTitle = page.textContent(errorGraphYaxisTitle).trim();
    	System.out.println("expectedTitle : "+expectedTitle+"\t actualTitle :"+actualTitle);
    	Assert.assertTrue(actualTitle.equals(expectedTitle));
    }
    
    public void validateTheFunctionalityOfErrorGraphZoomInButton () throws EncryptedDocumentException, IOException {
    	navigateToTopologyPage();
		selectApplicationGroupAndMapViewForDataValidation();
    	navigateToApplicationOverviewGraph();
    	page.waitForSelector(errorGraph);
		util.graphZoomIn(page, errorGraphZoomInBtn, errorGraphZoomResetBtn, xPoints);
	}
    
    public void validateTheFunctionalityOfErrorGraphZoomOutButton () throws EncryptedDocumentException, IOException {
    	navigateToTopologyPage();
		selectApplicationGroupAndMapViewForDataValidation();
    	navigateToApplicationOverviewGraph();
    	page.waitForSelector(errorGraph);
		util.graphZoomOut(page, errorGraphZoomInBtn, errorGraphZoomOutBtn, errorGraphZoomResetBtn, xPoints);
	}
    
    public void validateTheFunctionalityOfErrorGraphZoomResetButton () throws EncryptedDocumentException, IOException {
    	navigateToTopologyPage();
		selectApplicationGroupAndMapViewForDataValidation();
    	navigateToApplicationOverviewGraph();
    	page.waitForSelector(errorGraph);
		util.graphZoomReset(page, errorGraphZoomInBtn, errorGraphZoomResetBtn, xPoints);
	}
    
    public void validateZoomInByDragAndDropForErrorGraph() throws EncryptedDocumentException, IOException {
    	navigateToTopologyPage();
		selectApplicationGroupAndMapViewForDataValidation();
    	navigateToApplicationOverviewGraph();
    	page.waitForSelector(errorGraph);
    	util.graphZoomInByDragAndDrop(page, errorGraphXaxisPoints, errorGraphZoomResetBtn, xPoints);
    }
    
    public void validateWhetherErrorGraphIsDisplayedWhenClickedOnTopologyBlock() {
    	navigateToApplicationOverviewGraph();
    	page.waitForSelector(errorGraph);
    	Assert.assertTrue(page.locator(errorGraph).isVisible());
    }
    
    public void validateWhetherApdexValueIsDisplayedInApdexGraphHeader() {
    	navigateToApplicationOverviewGraph();
    	Assert.assertTrue(page.isVisible(apdexScore));
    }
    
    public void validateWhetherResponseTimeValueIsDisplayedInResponseTimeGraphHeader() {
    	navigateToApplicationOverviewGraph();
    	page.waitForSelector(responseGraph);
    	Assert.assertTrue(page.isVisible(responseTime));
    }
    
    public void validateWhetherErrorValueIsDisplayedInErrorGraphHeader() {
    	navigateToApplicationOverviewGraph();
    	page.waitForSelector(errorGraph);
    	Assert.assertTrue(page.isVisible(errorValue));
    }
    
    public void validateWhetherErrorPercentageValueIsDisplayedInErrorGraphHeader() {
    	navigateToApplicationOverviewGraph();
    	page.waitForSelector(errorGraph);
    	Assert.assertTrue(page.isVisible(errorPercentage));
    }
    
    public void validateWhetherErrorsPerMinValueIsDisplayedInErrorGraphHeader() {
    	navigateToApplicationOverviewGraph();
    	page.waitForSelector(errorGraph);
    	Assert.assertTrue(page.isVisible(epmValue));
    }
    
    public void validateTheFunctionalityOfLeftApplicationOverviewPanelCloseButton() {
    	navigateToApplicationOverviewGraph();
    	page.click(apdexGraphCloseBtn);
    	Assert.assertTrue(page.textContent(apdexGraph).trim().equals("Error"));
    }
    
    public void validateTheFunctionalityOfRightApplicationOverviewPanelCloseButton() {
    	navigateToApplicationOverviewGraph();
    	page.click(errorGraphCloseBtn);
    	Assert.assertTrue(page.isHidden(errorGraph));
    }
    
    public void validateWhetherHealthToolbarIsDisplayed() {
    	Assert.assertTrue(page.isVisible(healthBar));
    }
    
    public void validateWhetherHealthTooltipIsDisplayed() {
    	page.locator(healthInfoIcon).hover();
    	Assert.assertTrue(page.isVisible(healthTooltip));
    }
    
    public void validateTheGoodHealthIndicatorInHealthBar() throws EncryptedDocumentException, IOException {
    	String expectedColor = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.topologyPageSheet, "healthIndicator_Good");
    	String actualColor =(String) page.locator(healthBarGoodIcon).evaluate("element => window.getComputedStyle(element).getPropertyValue('background-color')");
		Assert.assertTrue(actualColor.contains(expectedColor));
		String actualColor1 =(String) page.locator(healthBarGoodText).evaluate("element => window.getComputedStyle(element).getPropertyValue('color')");
		Assert.assertTrue(actualColor1.contains(expectedColor));
    }
    
    public void validateTheFairHealthIndicatorInHealthBar() throws EncryptedDocumentException, IOException {
    	String expectedColor = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.topologyPageSheet, "healthIndicator_Fair");
    	String actualColor =(String) page.locator(healthBarFairIcon).evaluate("element => window.getComputedStyle(element).getPropertyValue('background-color')");
		Assert.assertTrue(actualColor.contains(expectedColor));
		String actualColor1 =(String) page.locator(healthBarFairText).evaluate("element => window.getComputedStyle(element).getPropertyValue('color')");
		Assert.assertTrue(actualColor1.contains(expectedColor));
    }
    
    public void validateThePoorHealthIndicatorInHealthBar() throws EncryptedDocumentException, IOException {
    	String expectedColor = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.topologyPageSheet, "healthIndicator_Poor");
    	String actualColor =(String) page.locator(healthBarPoorIcon).evaluate("element => window.getComputedStyle(element).getPropertyValue('background-color')");
		Assert.assertTrue(actualColor.contains(expectedColor));
		String actualColor1 =(String) page.locator(healthBarPoorText).evaluate("element => window.getComputedStyle(element).getPropertyValue('color')");
		Assert.assertTrue(actualColor1.contains(expectedColor));
    }
    
    public void validateGoodHealthIndicatorValueInTheHealthTooltip() throws EncryptedDocumentException, IOException {
    	page.locator(healthInfoIcon).hover();
    	String expectedValue = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.topologyPageSheet, "healthTooltip_Good");
    	Locator values = page.locator(healthTooltipValues);
    	for(int i=0; i<values.count(); i++) {
    		if(values.nth(i).textContent().trim().contains("Good")){
    			System.out.println(values.nth(i).textContent().trim());
    			Assert.assertTrue(values.nth(i).textContent().trim().contains(expectedValue));
    			break;
    		}
    	}
    }
    
    public void validateFairHealthIndicatorValueInTheHealthTooltip() throws EncryptedDocumentException, IOException {
    	page.locator(healthInfoIcon).hover();
    	String expectedValue = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.topologyPageSheet, "healthTooltip_Fair");
    	Locator values = page.locator(healthTooltipValues);
    	for(int i=0; i<values.count(); i++) {
    		if(values.nth(i).textContent().trim().contains("Fair")){
    			System.out.println(values.nth(i).textContent().trim());
    			Assert.assertTrue(values.nth(i).textContent().trim().contains(expectedValue));
    			break;
    		}
    	}
    }
    
    public void validatePoorHealthIndicatorValueInTheHealthTooltip() throws EncryptedDocumentException, IOException {
    	page.locator(healthInfoIcon).hover();
    	String expectedValue = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.topologyPageSheet, "healthTooltip_Poor");
    	Locator values = page.locator(healthTooltipValues);
    	for(int i=0; i<values.count(); i++) {
    		if(values.nth(i).textContent().trim().contains("Poor")){
    			System.out.println(values.nth(i).textContent().trim());
    			Assert.assertTrue(values.nth(i).textContent().trim().contains(expectedValue));
    			break;
    		}
    	}
    }
    
    public void validateTheXaxisLabelsAreAsPerSelectedTimeLineForApplicationOverviewGraphs() {    	
    	page.waitForSelector(apdexGraph);
		util.validateTheGraphdisplayingTheDataAsPerGivenTimeLines(page, apdexGraphXaxisLabels, selectedTimeline, xAxisLabels);
	}
    
    public void selectApplicationGroupAndTableViewForDataValidation() throws EncryptedDocumentException, IOException {
    	String grpName = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.topologyPageSheet, "groupNameForAddingGroup");
    	util.selectTheOptionFromDropDownBySearch(page, grpDropdown, searchGrp, grpName, groupSearchresult);
    	page.click(tableView);
    	page.waitForSelector(tableHeader);
    }
    
    public void selectApplicationGroupAndMapViewForDataValidation() throws EncryptedDocumentException, IOException {
    	String grpName = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.topologyPageSheet, "groupNameForAddingGroup");
    	util.selectTheOptionFromDropDownBySearch(page, grpDropdown, searchGrp, grpName, groupSearchresult);
    	page.click(mapView);
    	page.waitForSelector(topologyBlock);
    }
    
    public void validateTheUserInTheSourceColumnOfTheTable() {
    	page.waitForSelector(sourcesOnTable);
    	boolean flag = false;
    	Locator source = page.locator(sourcesOnTable);
    	for(int i=0; i<source.count(); i++) {
    		if(source.nth(i).textContent().trim().equalsIgnoreCase("User")) {
    			flag = true;
    			break;
    		}
    	}
    	Assert.assertTrue(flag);
    }
    
    public void validateTheUserIndicatorInTheSourceColumnOfTheTable() throws EncryptedDocumentException, IOException {
    	String expectedColor = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.topologyPageSheet, "userIndicatorColor");
    	String actualColor =(String) page.locator(userIndicatorOnTable).evaluate("element => window.getComputedStyle(element).getPropertyValue('color')");
    	System.out.println("expectedColor :"+expectedColor+"\t actualColor :"+actualColor);
    	Assert.assertTrue(actualColor.contains(expectedColor));
    }
    
    public void validateTheApplicationNameInTheDestinationColumnOfTheTable() throws EncryptedDocumentException, IOException {
    	String application = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.applicationNameSheet, "APM");
    	page.waitForSelector(destinationsOnTable);
    	boolean flag = false;
    	Locator source = page.locator(destinationsOnTable);
    	for(int i=0; i<source.count(); i++) {
    		if(source.nth(i).textContent().trim().equalsIgnoreCase(application)) {
    			flag = true;
    			break;
    		}
    	}
    	Assert.assertTrue(flag);
    }
    
    public void validateWhetherTheApplicationIndicatorIsAccordingToTheApdex(String apdexColor) throws EncryptedDocumentException, IOException {
    	String application = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.applicationNameSheet, "APM");
    	System.out.println(apdexColor);
    	String indicator = "//span[.='"+application+"']/parent::div/preceding-sibling::div[@class='indicator-body']//div[@class='indicate']";
    	page.waitForSelector(indicator);
    	Locator icons = page.locator(indicator);
    	for(int i=0; i<icons.count(); i++) {
    		String indicatorColor =(String) icons.nth(i).evaluate("element => window.getComputedStyle(element).getPropertyValue('background-color')");
    		System.out.println(indicatorColor);
    		Assert.assertTrue(apdexColor.equalsIgnoreCase(indicatorColor));
    	}
    }
    
    public void validateTheApplicationNameInTheMapView() throws EncryptedDocumentException, IOException {
    	String application = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.applicationNameSheet, "APM");
    	Assert.assertTrue(page.textContent(topologyBlock).trim().equalsIgnoreCase(application));
    }
    
    public void validateWhetherTheServerDetectPointIsPDisplayed() throws EncryptedDocumentException, IOException {
    	String point = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.topologyPageSheet, "serverDetectPoint");
    	Locator detectpoints = page.locator(detectPoint);
    	int count = 0;
    	for(int i=0; i<detectpoints.count(); i++) {
    		detectpoints.nth(i).hover();
    		page.waitForSelector(detectPointTooltip3rdLine);
    		if(page.textContent(detectPointTooltip3rdLine).trim().contains(point)) {
    			count++;
    		}
    	}
    	Assert.assertTrue(count == 1);
    }
    
    public void validateWhetherTheDetectPointGraphForServerIsPDisplayed() throws EncryptedDocumentException, IOException {
    	String point = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.topologyPageSheet, "serverDetectPoint");
    	Locator detectpoints = page.locator(detectPoint);
    	int count = 0;
    	for(int i=0; i<detectpoints.count(); i++) {
    		detectpoints.nth(i).hover();
    		page.waitForSelector(detectPointTooltip3rdLine);
    		if(page.textContent(detectPointTooltip3rdLine).trim().contains(point)) {
    			detectpoints.nth(i).click();
    			page.waitForSelector(detectPointChartinfo);
    		}
    	}
    	Assert.assertTrue(page.textContent(detectPointChartinfo).trim().equalsIgnoreCase(point));
    }
    
    public void validateTheFunctionalityOfDetectPointGraphCloseButton() throws EncryptedDocumentException, IOException {
    	validateWhetherTheDetectPointGraphForServerIsPDisplayed();
    	page.click(errorGraphCloseBtn);
    	page.isHidden(detectPointChartPanel);
    }
    
    public void validateWhetherTheTooltipIsDisplayingForApdexGraph() throws EncryptedDocumentException, IOException {
    	navigateToTopologyPage();
		selectApplicationGroupAndMapViewForDataValidation();
    	navigateToApplicationOverviewGraph();
    	util.validateWidgetToolTips(page, apdexGraphXaxisPoints, apdexGraphTooltipTitle);
    }
    
    public void validateWhetherTheTooltipIsDisplayingForResponseTimeGraph() throws EncryptedDocumentException, IOException {
    	navigateToTopologyPage();
		selectApplicationGroupAndMapViewForDataValidation();
    	navigateToApplicationOverviewGraph();
    	page.waitForSelector(responseGraph);
    	util.validateWidgetToolTips(page, respTimeGraphXaxisPoints, respTimeGraphTooltipTitle);
    }
    
    public void validateWhetherTheTooltipIsDisplayingForErrorGraph() throws EncryptedDocumentException, IOException {
    	navigateToTopologyPage();
		selectApplicationGroupAndMapViewForDataValidation();
    	navigateToApplicationOverviewGraph();
    	page.waitForSelector(errorGraph);
    	util.validateWidgetToolTips(page, errorGraphXaxisPoints, errorGraphTooltipTitle);
    }
    
    public void navigateToApplicationOverviewGraph() {
    	page.click(mapView);
    	page.click(topologyBlock);
    	page.waitForSelector(apdexGraph);
    }
    
    public void validateTheCustomTimeLine(String period)
	{
		util.validateCustomTimeLine(page,apdexGraphXaxisLabels,period,xAxisLabels);
	}
    
    public void validateTheTitleOfDetectPointResponseTimeGraph() throws EncryptedDocumentException, IOException {
    	String expectedTitle = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.topologyPageSheet, "detectPointResponseTimeGraphTitle");
    	util.ValidateTheTitle(page, detPntResponseTimeGraph, expectedTitle);
    }
    
    public void validateTheXaxisTitleOfDetectPointResponseTimeGraph() throws EncryptedDocumentException, IOException {
    	String expectedTitle = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.topologyPageSheet, "xAxisTitle");
    	util.ValidateTheTitle(page, detPntRespTimeXaxisTitle, expectedTitle);
    }
    
    public void validateTheYaxisTitleOfDetectPointResponseTimeGraph() throws EncryptedDocumentException, IOException {
    	String expectedTitle = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.topologyPageSheet, "detectPointResponseTimeGraphYaxisTitle");
    	util.ValidateTheTitle(page, detPntRespTimeYaxisTitle, expectedTitle);
    }
    
    public void validateTheFunctionalityOfDetectPointResponseTimeGraphZoomInButton() throws EncryptedDocumentException, IOException {
		util.graphZoomIn(page, detPntRespTimeZoomInBtn, detPntRespTimeZoomResetBtn, xPoints1);
	}
    
    public void validateTheFunctionalityOfDetectPointResponseTimeGraphZoomOutButton() throws EncryptedDocumentException, IOException {
		util.graphZoomOut(page, detPntRespTimeZoomInBtn, detPntRespTimeZoomOutBtn, detPntRespTimeZoomResetBtn, xPoints1);
	}
    
    public void validateTheFunctionalityOfDetectPointResponseTimeGraphZoomResetButton() throws EncryptedDocumentException, IOException {
    	util.graphZoomReset(page, detPntRespTimeZoomInBtn, detPntRespTimeZoomResetBtn, xPoints1);
	}
    
    public void validateZoomInByDragAndDropForDetectPointResponseTimeGraph() throws EncryptedDocumentException, IOException {
    	util.graphZoomInByDragAndDrop(page, detPntRespTimeXaxisPoints, detPntRespTimeZoomResetBtn, xPoints1);
	}
    
    public void validateWhetherTheTooltipIsDisplayingForDetectPointResponseTimeGraph() throws EncryptedDocumentException, IOException {
    	util.validateWidgetToolTips(page, detPntRespTimeXaxisPoints, detPntRespTimeTooltipTitle);
    }
    
    public void validateTheTitleOfDetectPointPercentileResponseTimeGraph() throws EncryptedDocumentException, IOException {
    	String expectedTitle = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.topologyPageSheet, "detectPointPercentileResponseTimeGraphTitle");
    	util.ValidateTheTitle(page, detPntPercentileResponsetimeGraph, expectedTitle);
    }
    
    public void validateTheXaxisTitleOfDetectPointPercentileResponseTimeGraph() throws EncryptedDocumentException, IOException {
    	String expectedTitle = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.topologyPageSheet, "xAxisTitle");
    	util.ValidateTheTitle(page, detPntPercentileRespTimeXaxisTitle, expectedTitle);
    }
    
    public void validateTheYaxisTitleOfDetectPointPercentileResponseTimeGraph() throws EncryptedDocumentException, IOException {
    	String expectedTitle = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.topologyPageSheet, "detectPointPercentileResponseTimeGraphYaxisTitle");
    	util.ValidateTheTitle(page, detPntPercentileRespTimeYaxisTitle, expectedTitle);
    }
    
    public void validateTheFunctionalityOfDetectPointPercentileResponseTimeGraphZoomInButton() throws EncryptedDocumentException, IOException {
		util.graphZoomIn(page, detPntPercentileRespTimeZoomInBtn, detPntPercentileRespTimeZoomResetBtn, xPoints1);
	}
    
    public void validateTheFunctionalityOfDetectPointPercentileResponseTimeGraphZoomOutButton() throws EncryptedDocumentException, IOException {
		util.graphZoomOut(page, detPntPercentileRespTimeZoomInBtn, detPntPercentileRespTimeZoomOutBtn, detPntPercentileRespTimeZoomResetBtn, xPoints1);
	}
    
    public void validateTheFunctionalityOfDetectPointPercentileResponseTimeGraphZoomResetButton() throws EncryptedDocumentException, IOException {
		util.graphZoomReset(page, detPntPercentileRespTimeZoomInBtn, detPntPercentileRespTimeZoomResetBtn, xPoints1);
	}
    
    public void validateZoomInByDragAndDropForDetectPointPercentileResponseTimeGraph() throws EncryptedDocumentException, IOException {
		util.graphZoomInByDragAndDrop(page, detPntPercentileRespTimeXaxisPoints, detPntPercentileRespTimeZoomResetBtn, xPoints1);
	}
    
    public void validateWhetherTheTooltipIsDisplayingForDetectPointPercentileResponseTimeGraph() throws EncryptedDocumentException, IOException {
    	util.validateWidgetToolTips(page, detPntPercentileRespTimeXaxisPoints, detPntPercentileRespTimeTooltipTitle);
    }
    
    public void validateTheLegendsLabelInDetectPointPercentileResponseTimeGraph(String legend) throws EncryptedDocumentException, IOException {
    	util.validateWidgetLegendsText(page, detPntPercentileRespTimeLegendNames, legend);
    }
    
    public void validateTheLegendsColorInDetectPointPercentileResponseTimeGraph() throws EncryptedDocumentException, IOException {
    	util.validateWidgetLegends(page, detPntPercentileRespTimeLegendNames, detPntPercentileRespTimeLegendColorMarkers, detPntPercentileRespTimeTooltiplegendLine, detPntPercentileRespTimeTooltipColorMarker, detPntPercentileRespTimeXaxisPoints, detPntPercentileRespTimeTooltipLabel);
    }
    
    public void validateTheTitleOfDetectPointLoadGraph() throws EncryptedDocumentException, IOException {
    	String expectedTitle = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.topologyPageSheet, "detectPointLoadGraphTitle");
    	util.ValidateTheTitle(page, detPntLoadGraph, expectedTitle);
    }
    
    public void validateTheXaxisTitleOfDetectPointLoadGraph() throws EncryptedDocumentException, IOException {
    	String expectedTitle = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.topologyPageSheet, "xAxisTitle");
    	util.ValidateTheTitle(page, detPntLoadXaxisTitle, expectedTitle);
    }
    
    public void validateTheYaxisTitleOfDetectPointLoadGraph() throws EncryptedDocumentException, IOException {
    	String expectedTitle = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.topologyPageSheet, "detectPointLoadGraphYaxisTitle");
    	util.ValidateTheTitle(page, detPntLoadYaxisTitle, expectedTitle);
    }
    
    public void validateTheFunctionalityOfDetectPointLoadGraphZoomInButton() throws EncryptedDocumentException, IOException {
		util.graphZoomIn(page, detPntLoadZoomInBtn, detPntLoadZoomResetBtn, xPoints1);
	}
    
    public void validateTheFunctionalityOfDetectPointLoadGraphZoomOutButton() throws EncryptedDocumentException, IOException {
		util.graphZoomOut(page, detPntLoadZoomInBtn, detPntLoadZoomOutBtn, detPntLoadZoomResetBtn, xPoints1);
	}
    
    public void validateTheFunctionalityOfDetectPointLoadGraphZoomResetButton() throws EncryptedDocumentException, IOException {
		util.graphZoomReset(page, detPntLoadZoomInBtn, detPntLoadZoomResetBtn, xPoints1);
	}
    
    public void validateZoomInByDragAndDropForDetectPointLoadGraph() throws EncryptedDocumentException, IOException {
		util.graphZoomInByDragAndDrop(page, detPntLoadXaxisPoints, detPntLoadZoomResetBtn, xPoints1);
	}
    
    public void validateWhetherTheTooltipIsDisplayingForDetectPointLoadGraph() throws EncryptedDocumentException, IOException {
    	util.validateWidgetToolTips(page, detPntLoadXaxisPoints, detPntLoadTooltipTitle);
    }
    
    public void validateTheTitleOfDetectPointErrorGraph() throws EncryptedDocumentException, IOException {
    	String expectedTitle = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.topologyPageSheet, "detectPointErrorGraphTitle");
    	util.ValidateTheTitle(page, detPntErrorGraph, expectedTitle);
    }
    
    public void validateTheXaxisTitleOfDetectPointErrorGraph() throws EncryptedDocumentException, IOException {
    	String expectedTitle = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.topologyPageSheet, "xAxisTitle");
    	util.ValidateTheTitle(page, detPntErrorXaxisTitle, expectedTitle);
    }
    
    public void validateTheYaxisTitleOfDetectPointErrorGraph() throws EncryptedDocumentException, IOException {
    	String expectedTitle = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.topologyPageSheet, "detectPointErrorGraphYaxisTitle");
    	util.ValidateTheTitle(page, detPntErrorYaxisTitle, expectedTitle);
    }
    
    public void validateTheFunctionalityOfDetectPointErrorGraphZoomInButton() throws EncryptedDocumentException, IOException {
		util.graphZoomIn(page, detPntErrorZoomInBtn, detPntErrorZoomResetBtn, xPoints1);
	}
    
    public void validateTheFunctionalityOfDetectPointErrorGraphZoomOutButton() throws EncryptedDocumentException, IOException {
		util.graphZoomOut(page, detPntErrorZoomInBtn, detPntErrorZoomOutBtn, detPntErrorZoomResetBtn, xPoints1);
	}
    
    public void validateTheFunctionalityOfDetectPointErrorGraphZoomResetButton() throws EncryptedDocumentException, IOException {
		util.graphZoomReset(page, detPntErrorZoomInBtn, detPntErrorZoomResetBtn, xPoints1);
	}
    
    public void validateZoomInByDragAndDropForDetectPointErrorGraph() throws EncryptedDocumentException, IOException {
		util.graphZoomInByDragAndDrop(page, detPntErrorXaxisPoints, detPntErrorZoomResetBtn, xPoints1);
	}
    
    public void validateWhetherTheTooltipIsDisplayingForDetectPointErrorGraph() throws EncryptedDocumentException, IOException {
    	util.validateWidgetToolTips(page, detPntErrorXaxisPoints, detPntErrorTooltipTitle);
    }
    
    public void ValidateTheXaxisLablesAccordingToTheSelectedTimeline() throws EncryptedDocumentException, IOException {
    	page.waitForSelector(detPntRespTimeXaxisLabels);
    	System.out.println(page.textContent(selectedTimeline));
    	util.validateTheGraphdisplayingTheDataAsPerGivenTimeLines(page, detPntRespTimeXaxisLabels, selectedTimeline, xAxisLabels1);
    }
    
    public void validateTheCustomTimeLineForDetectPointGraphs(String period){
		page.waitForSelector(detPntRespTimeXaxisLabels);
		util.validateCustomTimeLine(page,detPntRespTimeXaxisLabels,period,xAxisLabels1);
	}
    
    public void navigateToServerDetectPointGraph() throws EncryptedDocumentException, IOException {
    	navigateToTopologyPage();
		selectApplicationGroupAndMapViewForDataValidation();
		validateWhetherTheDetectPointGraphForServerIsPDisplayed();
    }
    
    public void navigateToClientDetectPointGraph() throws EncryptedDocumentException, IOException {
    	navigateToTopologyPage();
		selectApplicationGroupAndMapViewForDataValidation();
		validateWhetherTheDetectPointGraphForClientIsPDisplayed();
    }
    
    public void fetchResponseTimeFromServerDetectPointTooltipAnValidateInTheResponseTimeGraph() throws EncryptedDocumentException, IOException {
    	String point = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.topologyPageSheet, "serverDetectPoint");
    	String expectedRespTime = "";
    	Locator detectpoints = page.locator(detectPoint);
    	for(int i=0; i<detectpoints.count(); i++) {
    		detectpoints.nth(i).hover();
    		page.waitForSelector(detectPointTooltip3rdLine);
    		if(page.textContent(detectPointTooltip3rdLine).trim().contains(point)) {
    			expectedRespTime = page.textContent(detectPointTooltip2ndLine).trim().replace("Response time: ", "");
    			expectedRespTime = expectedRespTime.replace(" ms", "");
    			break;
    		}
    	}
    	String actualRespTime = page.textContent(detPntResponseTime).trim().replace(" ms", "");
    	System.out.println("ResponseTime in Tooltip : "+expectedRespTime+"\t ResponseTime in Graph : "+actualRespTime);
    	Assert.assertTrue(actualRespTime.equalsIgnoreCase(expectedRespTime));
    }
    
    public void fetchCallsPerMinuteFromServerDetectPointTooltipAnValidateInTheLoadGraph() throws EncryptedDocumentException, IOException {
    	String point = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.topologyPageSheet, "serverDetectPoint");
    	String expectedCpm = "";
    	Locator detectpoints = page.locator(detectPoint);
    	for(int i=0; i<detectpoints.count(); i++) {
    		detectpoints.nth(i).hover();
    		page.waitForSelector(detectPointTooltip3rdLine);
    		if(page.textContent(detectPointTooltip3rdLine).trim().contains(point)) {
    			expectedCpm = page.textContent(detectPointTooltip1stLine).trim().replace("CPM: ", "");
    			break;
    		}
    	}
    	String actualCpm = page.textContent(cpmOnDetPntLoadGraph).trim().replace(" calls/min", "");
    	System.out.println("CPM in Tooltip : "+expectedCpm+"\t CPM in Graph : "+actualCpm);
    	Assert.assertTrue(actualCpm.equalsIgnoreCase(expectedCpm));
    }
    
    public void fetchTheApplicationNameFromTopoBlockAndValidateInApplicationOverviewGraphPanels() {
    	String appNameInTopoBlock = page.textContent(topologyBlock).trim();
    	String appNameOnGraphPanel1 =  page.textContent(applicationNameinGraph).trim().replace("Name : ", "");
    	System.out.println("appNameOnGraphPanel1 : "+appNameOnGraphPanel1+"\t appNameInTopoBlock : "+appNameInTopoBlock);
    	Assert.assertTrue(appNameOnGraphPanel1.equalsIgnoreCase(appNameInTopoBlock));
    	String appNameOnGraphPanel2 =  page.textContent(applicationNameinGraph1).trim().replace("Name : ", "");
    	System.out.println("appNameOnGraphPanel2 : "+appNameOnGraphPanel2+"\t appNameInTopoBlock : "+appNameInTopoBlock);
    	Assert.assertTrue(appNameOnGraphPanel1.equalsIgnoreCase(appNameInTopoBlock));
    }
    
    public void fetchTheApplicationServerNameFromTopoBlockAndValidateInApplicationOverviewGraphPanels() {
    	String serverNameInTopoBlock = page.textContent(topologyServerName).trim();
    	String serverNameOnGraphPanel1 =  page.textContent(serverNameinGraph).trim().replace("Type : ", "");
    	System.out.println("serverNameOnGraphPanel1 : "+serverNameOnGraphPanel1+"\t serverNameInTopoBlock : "+serverNameInTopoBlock);
    	Assert.assertTrue(serverNameOnGraphPanel1.equalsIgnoreCase(serverNameInTopoBlock));
    	String serverNameOnGraphPanel2 =  page.textContent(serverNameinGraph1).trim().replace("Type : ", "");
    	System.out.println("serverNameOnGraphPanel2 : "+serverNameOnGraphPanel2+"\t serverNameInTopoBlock : "+serverNameInTopoBlock);
    	Assert.assertTrue(serverNameOnGraphPanel1.equalsIgnoreCase(serverNameInTopoBlock));
    }
    
    public void validateWhetherTheApdexValueInApplicationOverviewGraphHeaderIsAccordingToTheApdexOnDashboardPage(String apdexOnDashboard) throws EncryptedDocumentException, IOException {
    	navigateToTopologyPage();
    	selectApplicationGroupAndMapViewForDataValidation();
    	navigateToApplicationOverviewGraph();
    	String apdexOnGraphHeader = page.textContent(apdexScore).trim().replace(" average", "");
    	System.out.println("apdexOnDashboard : "+apdexOnDashboard+"\t apdexOnGraphHeader : "+apdexOnGraphHeader);
    	Assert.assertTrue(apdexOnGraphHeader.equalsIgnoreCase(apdexOnDashboard));
    }
    
    public void validateWhetherTheServerDetectPointIsDisplayedInTableView() throws EncryptedDocumentException, IOException {
    	String point = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.topologyPageSheet, "serverDetectPoint");
    	Locator detectpoints = page.locator(detectPointsOnTable);
    	boolean flag = false;
    	for(int i=0; i<detectpoints.count(); i++) {
    		if(detectpoints.nth(i).textContent().trim().equalsIgnoreCase(point)) {
    			flag = true;
    			break;
    		}
    	}
    	Assert.assertTrue(flag);
    }
    
    public void validateTheSourceNameOfTheServerDetectPointInTableView() throws EncryptedDocumentException, IOException {
    	String point = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.topologyPageSheet, "serverDetectPoint");
    	page.waitForSelector(sourcesOnTable);
    	Locator detectpoints = page.locator(detectPointsOnTable);
    	Locator source = page.locator(sourcesOnTable);
    	for(int i=0; i<detectpoints.count(); i++) {
    		if(detectpoints.nth(i).textContent().trim().equalsIgnoreCase(point)) {
    			System.out.println(source.nth(i).textContent().trim());
    			Assert.assertTrue(source.nth(i).textContent().trim().equalsIgnoreCase("User"));
    			break;
    		}
    	}
    }
    
    public void validateTheDestinationNameOfTheServerDetectPointInTableView() throws EncryptedDocumentException, IOException {
    	String point = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.topologyPageSheet, "serverDetectPoint");
    	String application = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.applicationNameSheet, "APM");
    	page.waitForSelector(destinationsOnTable);
    	Locator detectpoints = page.locator(detectPointsOnTable);
    	Locator destination = page.locator(destinationsOnTable);
    	for(int i=0; i<detectpoints.count(); i++) {
    		if(detectpoints.nth(i).textContent().trim().equalsIgnoreCase(point)) {
    			System.out.println(destination.nth(i).textContent().trim());
    			Assert.assertTrue(destination.nth(i).textContent().trim().equalsIgnoreCase(application));
    			break;
    		}
    	}
    }
    
    public void validateTheCallsPerMinuteOfTheServerDetectPointInTableView() throws EncryptedDocumentException, IOException {
    	String point = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.topologyPageSheet, "serverDetectPoint");
    	String expectedCpm = "";
    	Locator detectpoints = page.locator(detectPoint);
    	for(int i=0; i<detectpoints.count(); i++) {
    		detectpoints.nth(i).hover();
    		page.waitForSelector(detectPointTooltip3rdLine);
    		if(page.textContent(detectPointTooltip3rdLine).trim().contains(point)) {
    			expectedCpm = page.textContent(detectPointTooltip1stLine).trim().replace("CPM: ", "");
    			System.out.println("CPM on tooltip : "+expectedCpm);
    			break;
    		}
    	}
    	page.click(tableView);
    	page.waitForSelector(cpmOnTable);
    	Locator detPnts = page.locator(detectPointsOnTable);
    	Locator cpm = page.locator(cpmOnTable);
    	for(int i=0; i<detPnts.count(); i++) {
    		if(detPnts.nth(i).textContent().trim().equalsIgnoreCase(point)) {
    		System.out.println("CPM on table : "+cpm.nth(i).textContent().trim());	
    		Assert.assertTrue(cpm.nth(i).textContent().trim().equalsIgnoreCase(expectedCpm));
    			break;
    		}
    	}
    }
    
    public void validateTheResponseTimeOfTheServerDetectPointInTableView() throws EncryptedDocumentException, IOException {
    	String point = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.topologyPageSheet, "serverDetectPoint");
    	String expectedRespTime = "";
    	Locator detectpoints = page.locator(detectPoint);
    	for(int i=0; i<detectpoints.count(); i++) {
    		detectpoints.nth(i).hover();
    		page.waitForSelector(detectPointTooltip2ndLine);
    		if(page.textContent(detectPointTooltip3rdLine).trim().contains(point)) {
    			String detectTooltip = page.textContent(detectPointTooltip2ndLine).trim(); 
    			expectedRespTime = detectTooltip.substring(detectTooltip.indexOf(':')+2).replace(" ms", "");
    			System.out.println("ResponseTime on tooltip : "+expectedRespTime);
    			break;
    		}
    	}
    	page.click(tableView);
    	page.waitForSelector(responseTimesOnTable);
    	Locator detPnts = page.locator(detectPointsOnTable);
    	Locator respTime = page.locator(responseTimesOnTable);
    	for(int i=0; i<detPnts.count(); i++) {
    		if(detPnts.nth(i).textContent().trim().equalsIgnoreCase(point)) {
    		System.out.println("respTime on table : "+respTime.nth(i).textContent().trim());	
    		Assert.assertTrue(respTime.nth(i).textContent().trim().equalsIgnoreCase(expectedRespTime));
    			break;
    		}
    	}
    }
    
    public void validateTheAverageResponseTimeFromDashboardInTopologyServerDetectPointGraph(String expectedRespTime) throws EncryptedDocumentException, IOException {
    	navigateToServerDetectPointGraph();
    	String actualRespTime = page.textContent(detPntResponseTime).trim().replace(" ms", "");
    	System.out.println("expectedRespTime : "+expectedRespTime+"\t actualRespTime : "+actualRespTime);
    	Assert.assertTrue(actualRespTime.equalsIgnoreCase(expectedRespTime));
    }
    
    public void validateTheAverageResponseTimeFromDashboardInTopologyApplicationOverviewGraph(String expectedRespTime) throws EncryptedDocumentException, IOException {
    	navigateToApplicationOverviewGraph();
    	String actualRespTime = page.textContent(responseTime).trim().replace(" ms", "");
    	System.out.println("expectedRespTime : "+expectedRespTime+"\t actualRespTime : "+actualRespTime);
    	Assert.assertTrue(actualRespTime.equalsIgnoreCase(expectedRespTime));
    }
    
    public void validateTheAverageResponseTimeFromDashboardInTopologyServerDetectPointTooltip(String expectedRespTime) throws EncryptedDocumentException, IOException {
    	String point = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.topologyPageSheet, "serverDetectPoint");
    	String actualRespTime = "";
    	Locator detectpoints = page.locator(detectPoint);
    	for(int i=0; i<detectpoints.count(); i++) {
    		detectpoints.nth(i).hover();
    		page.waitForSelector(detectPointTooltip2ndLine);
    		if(page.textContent(detectPointTooltip3rdLine).trim().contains(point)) {
    			String detectTooltip = page.textContent(detectPointTooltip2ndLine); 
    			actualRespTime = detectTooltip.substring(detectTooltip.indexOf(':')+2).replace(" ms", "");
    			break;
    		}
    	} 
    	System.out.println("expectedRespTime : "+expectedRespTime+"\t actualRespTime : "+actualRespTime);
    	Assert.assertTrue(actualRespTime.equalsIgnoreCase(expectedRespTime));
    }
    
    public void validateTheNumberOfErrorsFromDashboardInTopologyApplicationOverviewGraphHeader(int expectedErrors) throws EncryptedDocumentException, IOException {
    	navigateToApplicationOverviewGraph();
    	int actualErrors = Integer.parseInt(page.textContent(errorValue).trim().replace(" errors", ""));
    	System.out.println("expectedErrors : "+expectedErrors+"\t actualErrors : "+actualErrors);
    	Assert.assertTrue(actualErrors == expectedErrors);
    }
    
    public void validateTheNumberOfErrorsFromDashboardInTopologyApplicationOverviewGraph(int expectedErrors) throws EncryptedDocumentException, IOException {
    	navigateToApplicationOverviewGraph();
    	int actualErrors = util.getTheSummationFromTheWidgetTooltip(page, errorGraphXaxisPoints, errorGraphTooltip);
    	System.out.println("expectedErrors : "+expectedErrors+"\t actualErrors : "+actualErrors);
    	Assert.assertTrue(actualErrors == expectedErrors);
    }
    
    public void validateTheNumberOfErrorsFromDashboardInTopologyServerDetectPointGraphHeader(int expectedErrors) throws EncryptedDocumentException, IOException {
		navigateToServerDetectPointGraph();
    	int actualErrors = Integer.parseInt(page.textContent(errorsOnDetPntErrorGraph).trim().replace(" errors", ""));
    	System.out.println("expectedErrors : "+expectedErrors+"\t actualErrors : "+actualErrors);
    	Assert.assertTrue(actualErrors == expectedErrors);
    }
    
    public void validateTheNumberOfErrorsFromDashboardInTopologyServerDetectPointGraph(int expectedErrors) throws EncryptedDocumentException, IOException {
		navigateToServerDetectPointGraph();
    	int actualErrors = util.getTheSummationFromTheWidgetTooltip(page, detPntErrorXaxisPoints, detPntErrorTooltipValue);
    	System.out.println("expectedErrors : "+expectedErrors+"\t actualErrors : "+actualErrors);
    	Assert.assertTrue(actualErrors == expectedErrors);
    }
    
    public void validateTheErrorsPerMinuteFromDashboardInTopologyApplicationOverviewGraphHeader(String expectedEpm) throws EncryptedDocumentException, IOException {
    	navigateToApplicationOverviewGraph();
    	String actualEpm = page.textContent(epmValue).trim().replace(" errors/min", "");
    	System.out.println("expectedEpm : "+expectedEpm+"\t actualEpm : "+actualEpm);
    	Assert.assertTrue(actualEpm.equalsIgnoreCase(expectedEpm));
    }
    
    public void validateTheErrorsPerMinuteFromDashboardInTopologyServerDetectPointGraphHeader(String expetedEpm) throws EncryptedDocumentException, IOException {
		navigateToServerDetectPointGraph();
    	String actualEpm = page.textContent(epmOnDetPntErrorGraph).trim().replace(" errors/min", "");
    	System.out.println("expetedEpm : "+expetedEpm+"\t actualEpm : "+actualEpm);
    	Assert.assertTrue(actualEpm.equalsIgnoreCase(expetedEpm));
    }
    
    public void validateTheErrorsPercentageInTopologyApplicationOverviewGraphHeader(double calls, double errors) throws EncryptedDocumentException, IOException {
    	navigateToApplicationOverviewGraph();
    	DecimalFormat df=new DecimalFormat("#.##");
		df.setRoundingMode(RoundingMode.DOWN);
		double expectedErrorPercent = (errors*100)/calls;
		String errorPercent = page.textContent(errorPercentage).trim().replace("%", "");
		double actualErrorPercent = Double.parseDouble(errorPercent);
		System.out.println("actualErrorPercent : "+actualErrorPercent+"\t expectedErrorPercent : "+Double.parseDouble(df.format(expectedErrorPercent)));
		Assert.assertTrue(actualErrorPercent == (Double.parseDouble(df.format(expectedErrorPercent))));
	}
    
    public void validateTheErrorsPercentageInTopologyServerDetectPointGraphHeader(double calls, double errors) throws EncryptedDocumentException, IOException {
    	navigateToServerDetectPointGraph();
    	DecimalFormat df=new DecimalFormat("#.##");
		df.setRoundingMode(RoundingMode.DOWN);
		double expectedErrorPercent = (errors*100)/calls;
		String errorPercent = page.textContent(errorPercentageOnDetPntErrorGraph).trim().replace("%", "");
		double actualErrorPercent = Double.parseDouble(errorPercent);
		System.out.println("actualErrorPercent : "+actualErrorPercent+"\t expectedErrorPercent : "+Double.parseDouble(df.format(expectedErrorPercent)));
		Assert.assertTrue(actualErrorPercent == (Double.parseDouble(df.format(expectedErrorPercent))));
	}
    
    public void validateTheNumberOfCallsFromDashboardInTopologyServerDetectPointGraphHeader(int expectedCalls) throws EncryptedDocumentException, IOException {
    	navigateToServerDetectPointGraph();
    	int actualCalls = Integer.parseInt(page.textContent(callsOnDetPntLoadGraph).trim().replace(" calls", ""));
    	System.out.println("expectedCalls : "+expectedCalls+"\t actualCalls : "+actualCalls);
    	Assert.assertTrue(actualCalls == expectedCalls);
    }
    
    public void validateTheNumberOfCallsFromDashboardInTopologyServerDetectPointGraph(int expectedCalls) throws EncryptedDocumentException, IOException {
    	navigateToServerDetectPointGraph();
    	int actualCalls = util.getTheSummationFromTheWidgetTooltip(page,(detPntLoadXaxisPoints), detPntLoadTooltipValue);
    	System.out.println("expectedCalls : "+expectedCalls+"\t actualCalls : "+actualCalls);
    	Assert.assertTrue(actualCalls == expectedCalls);
    }
    
    public void validateTheCallsPerMinuteFromDashboardInTopologyServerDetectPointGraphHeader(String expectedCpm) throws EncryptedDocumentException, IOException {
    	navigateToServerDetectPointGraph();
    	String actualCpm = page.textContent(cpmOnDetPntLoadGraph).trim().replace(" calls/min", "");
    	System.out.println("expectedCpm : "+expectedCpm+"\t actualCpm : "+actualCpm);
    	Assert.assertTrue(actualCpm.equalsIgnoreCase(expectedCpm));
    }
    
    public void validateTheCallsPerMinuteFromDashboardInTopologyServerDetectPointTooltip(String expectedCpm) throws EncryptedDocumentException, IOException {
    	String point = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.topologyPageSheet, "serverDetectPoint");
    	String actualCpm = "";
    	Locator detectpoints = page.locator(detectPoint);
    	for(int i=0; i<detectpoints.count(); i++) {
    		detectpoints.nth(i).hover();
    		page.waitForSelector(detectPointTooltip3rdLine);
    		if(page.textContent(detectPointTooltip3rdLine).trim().contains(point)) {
    			actualCpm = page.textContent(detectPointTooltip1stLine).trim().replace("CPM: ", "");
    			break;
    		}
    	}
    	System.out.println("expectedCpm : "+expectedCpm+"\t actualCpm : "+actualCpm);
    	Assert.assertTrue(actualCpm.equalsIgnoreCase(expectedCpm));
    }
    
    public void validateWhetherTheDetectPointGraphForClientIsPDisplayed() throws EncryptedDocumentException, IOException {
    	String point = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.topologyPageSheet, "clientDetectPoint");
    	Locator detectpoints = page.locator(detectPoint);
    	int count = 0;
    	for(int i=0; i<detectpoints.count(); i++) {
    		detectpoints.nth(i).hover();
    		page.waitForSelector(detectPointTooltip3rdLine);
    		if(page.textContent(detectPointTooltip3rdLine).trim().contains(point)) {
    			detectpoints.nth(i).click();
    			page.waitForSelector(detectPointChartinfo);
    		}
    	}
    	Assert.assertTrue(page.textContent(detectPointChartinfo).trim().equalsIgnoreCase(point));
    }
    
    public void validateWhetherTheClientDetectPointIsDisplayedInTableView() throws EncryptedDocumentException, IOException {
    	page.waitForSelector(detectPointsOnTable);
    	String point = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.topologyPageSheet, "clientDetectPoint");
    	Locator detectpoints = page.locator(detectPointsOnTable);
    	boolean flag = false;
    	for(int i=0; i<detectpoints.count(); i++) {
    		if(detectpoints.nth(i).textContent().trim().equalsIgnoreCase(point)) {
    			flag = true;
    			break;
    		}
    	}
    	Assert.assertTrue(flag);
    }
    
    public void validateTheSourceNameOfTheClientDetectPointInTableView() throws EncryptedDocumentException, IOException {
    	String point = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.topologyPageSheet, "clientDetectPoint");
    	String application = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.applicationNameSheet, "APM");
    	page.waitForSelector(sourcesOnTable);
    	Locator detectpoints = page.locator(detectPointsOnTable);
    	Locator source = page.locator(sourcesOnTable);
    	for(int i=0; i<detectpoints.count(); i++) {
    		if(detectpoints.nth(i).textContent().trim().equalsIgnoreCase(point)) {
    			System.out.println(source.nth(i).textContent().trim());
    			Assert.assertTrue(source.nth(i).textContent().trim().equalsIgnoreCase(application));
    			break;
    		}
    	}
    }
    
    public void validateTheDestinationNameOfTheClientDetectPointInTableView() throws EncryptedDocumentException, IOException {
    	String point = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.topologyPageSheet, "clientDetectPoint");
    	String dbName = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath,IPathConstant.apmDataValidationSheet, "databaseName");
    	page.waitForSelector(destinationsOnTable);
    	Locator detectpoints = page.locator(detectPointsOnTable);
    	Locator destination = page.locator(destinationsOnTable);
    	for(int i=0; i<detectpoints.count(); i++) {
    		if(detectpoints.nth(i).textContent().trim().equalsIgnoreCase(point)) {
    			System.out.println(destination.nth(i).textContent().trim());
    			Assert.assertTrue(destination.nth(i).textContent().trim().equalsIgnoreCase(dbName));
    			break;
    		}
    	}
    }
    
    public void validateTheCallsPerMinuteOfTheClientDetectPointInTableView() throws EncryptedDocumentException, IOException {
    	String point = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.topologyPageSheet, "clientDetectPoint");
    	String expectedCpm = "";
    	Locator detectpoints = page.locator(detectPoint);
    	for(int i=0; i<detectpoints.count(); i++) {
    		detectpoints.nth(i).hover();
    		page.waitForSelector(detectPointTooltip3rdLine);
    		if(page.textContent(detectPointTooltip3rdLine).trim().contains(point)) {
    			expectedCpm = page.textContent(detectPointTooltip1stLine).trim().replace("CPM: ", "");
    			System.out.println("CPM on tooltip : "+expectedCpm);
    			break;
    		}
    	}
    	page.click(tableView);
    	page.waitForSelector(cpmOnTable);
    	Locator detPnts = page.locator(detectPointsOnTable);
    	Locator cpm = page.locator(cpmOnTable);
    	for(int i=0; i<detPnts.count(); i++) {
    		if(detPnts.nth(i).textContent().trim().equalsIgnoreCase(point)) {
    		System.out.println("CPM on table : "+cpm.nth(i).textContent().trim());	
    		Assert.assertTrue(cpm.nth(i).textContent().trim().equalsIgnoreCase(expectedCpm));
    			break;
    		}
    	}
    }
    
    public void validateTheResponseTimeOfTheClientDetectPointInTableView() throws EncryptedDocumentException, IOException {
    	String point = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.topologyPageSheet, "clientDetectPoint");
    	String expectedRespTime = "";
    	Locator detectpoints = page.locator(detectPoint);
    	for(int i=0; i<detectpoints.count(); i++) {
    		detectpoints.nth(i).hover();
    		page.waitForSelector(detectPointTooltip2ndLine);
    		if(page.textContent(detectPointTooltip3rdLine).trim().contains(point)) {
    			String detectTooltip = page.textContent(detectPointTooltip2ndLine).trim(); 
    			expectedRespTime = detectTooltip.substring(detectTooltip.indexOf(':')+2).replace(" ms", "");
    			System.out.println("ResponseTime on tooltip : "+expectedRespTime);
    			break;
    		}
    	}
    	page.click(tableView);
    	page.waitForSelector(responseTimesOnTable);
    	Locator detPnts = page.locator(detectPointsOnTable);
    	Locator respTime = page.locator(responseTimesOnTable);
    	for(int i=0; i<detPnts.count(); i++) {
    		if(detPnts.nth(i).textContent().trim().equalsIgnoreCase(point)) {
    		System.out.println("respTime on table : "+respTime.nth(i).textContent().trim());	
    		Assert.assertTrue(respTime.nth(i).textContent().trim().equalsIgnoreCase(expectedRespTime));
    			break;
    		}
    	}
    }
    
    public void validateTheAverageResponseTimeFromDatabasePageInTopologyClientDetectPointGraph(String expectedRespTime) throws EncryptedDocumentException, IOException {
    	navigateToClientDetectPointGraph();
    	String actualRespTime = page.textContent(detPntResponseTime).trim().replace(" ms", "");
    	System.out.println("expectedRespTime : "+expectedRespTime+"\t actualRespTime : "+actualRespTime);
    	Assert.assertTrue(actualRespTime.equalsIgnoreCase(expectedRespTime));
    }
    
    public void validateTheAverageResponseTimeFromDatabasePageInTopologyClientDetectPointTooltip(String expectedRespTime) throws EncryptedDocumentException, IOException {
    	String point = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.topologyPageSheet, "clientDetectPoint");
    	String actualRespTime = "";
    	Locator detectpoints = page.locator(detectPoint);
    	for(int i=0; i<detectpoints.count(); i++) {
    		detectpoints.nth(i).hover();
    		page.waitForSelector(detectPointTooltip2ndLine);
    		if(page.textContent(detectPointTooltip3rdLine).trim().contains(point)) {
    			String detectTooltip = page.textContent(detectPointTooltip2ndLine); 
    			actualRespTime = detectTooltip.substring(detectTooltip.indexOf(':')+2).replace(" ms", "");
    			break;
    		}
    	} 
    	System.out.println("expectedRespTime : "+expectedRespTime+"\t actualRespTime : "+actualRespTime);
    	Assert.assertTrue(actualRespTime.equalsIgnoreCase(expectedRespTime));
    }
    
    public void validateTheNumberOfCallsFromDatabasePageInTopologyClientDetectPointGraphHeader(String expectedCalls) throws EncryptedDocumentException, IOException {
    	navigateToClientDetectPointGraph();
    	String actualCalls = page.textContent(callsOnDetPntLoadGraph).trim().replace(" calls", "");
    	System.out.println("expectedCalls : "+expectedCalls+"\t actualCalls : "+actualCalls);
    	Assert.assertTrue(actualCalls.equalsIgnoreCase(expectedCalls));
    }
    
    public void validateTheNumberOfCallsFromDatabasePageInTopologyClientDetectPointGraph(String calls) throws EncryptedDocumentException, IOException {
    	navigateToClientDetectPointGraph();
    	int expectedCalls = Integer.parseInt(calls);
    	int actualCalls = util.getTheSummationFromTheWidgetTooltip(page, detPntLoadXaxisPoints, detPntLoadTooltipValue);
    	System.out.println("expectedCalls : "+expectedCalls+"\t actualCalls : "+actualCalls);
    	Assert.assertTrue(actualCalls == expectedCalls);
    }
    
    public void validateTheCallsPerMinuteFromDatabasePageInTopologyClientDetectPointGraphHeader(String expectedCpm) throws EncryptedDocumentException, IOException {
    	navigateToClientDetectPointGraph();
    	String actualCpm = page.textContent(cpmOnDetPntLoadGraph).trim().replace(" calls/min", "");
    	System.out.println("expectedCpm : "+expectedCpm+"\t actualCpm : "+actualCpm);
    	Assert.assertTrue(actualCpm.equalsIgnoreCase(expectedCpm));
    }
    
    public void validateTheCallsPerMinuteFromDatabasePageInTopologyClientDetectPointTooltip(String expectedCpm) throws EncryptedDocumentException, IOException {
    	String point = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.topologyPageSheet, "clientDetectPoint");
    	String actualCpm = "";
    	Locator detectpoints = page.locator(detectPoint);
    	for(int i=0; i<detectpoints.count(); i++) {
    		detectpoints.nth(i).hover();
    		page.waitForSelector(detectPointTooltip3rdLine);
    		if(page.textContent(detectPointTooltip3rdLine).trim().contains(point)) {
    			actualCpm = page.textContent(detectPointTooltip1stLine).trim().replace("CPM: ", "");
    			break;
    		}
    	}
    	System.out.println("expectedCpm : "+expectedCpm+"\t actualCpm : "+actualCpm);
    	Assert.assertTrue(actualCpm.equalsIgnoreCase(expectedCpm));
    }
    
    public void validateTheNumberOfErrorsFromDatabasePageInTopologyClientDetectPointGraphHeader(String expectedErrors) throws EncryptedDocumentException, IOException {
    	navigateToClientDetectPointGraph();
    	String actualErrors = page.textContent(errorsOnDetPntErrorGraph).trim().replace(" errors", "");
    	System.out.println("expectedErrors : "+expectedErrors+"\t actualErrors : "+actualErrors);
    	Assert.assertTrue(actualErrors.equalsIgnoreCase(expectedErrors));
    }
    
    public void validateTheNumberOfErrorsFromDatabasePageInTopologyClientDetectPointGraph(String errors) throws EncryptedDocumentException, IOException {
    	navigateToClientDetectPointGraph();
    	int expectedErrors = Integer.parseInt(errors);
    	int actualErrors = util.getTheSummationFromTheWidgetTooltip(page, detPntErrorXaxisPoints, detPntErrorTooltipValue);
    	System.out.println("expectedErrors : "+expectedErrors+"\t actualErrors : "+actualErrors);
    	Assert.assertTrue(actualErrors == expectedErrors);
    }
    
    public void validateTheErrorsPerMinuteFromDatabasePageInTopologyClientDetectPointGraphHeader(String expectedEpm) throws EncryptedDocumentException, IOException {
    	navigateToClientDetectPointGraph();
    	String actualEpm = page.textContent(epmOnDetPntErrorGraph).trim().replace(" errors/min", "");
    	System.out.println("expectedEpm : "+expectedEpm+"\t actualEpm : "+actualEpm);
    	Assert.assertTrue(actualEpm.equalsIgnoreCase(expectedEpm));
    }
    
    public void validateTheErrorsPercentageFromDatabasePageInTopologyClientDetectPointGraphHeader(String expectedErroePercent) throws EncryptedDocumentException, IOException {
    	navigateToClientDetectPointGraph();
    	String actualErroePercent = page.textContent(errorPercentageOnDetPntErrorGraph).trim().replace("%", "");
    	System.out.println("expectedErroePercent : "+expectedErroePercent+"\t actualErroePercent : "+actualErroePercent);
    	Assert.assertTrue(actualErroePercent.equalsIgnoreCase(expectedErroePercent));
    }
    
    public void validateThePercentileResponseTimeValueFromDatabasePageInDetectPointGraph(List<Object> expectedPercentileRespTimeValues) throws EncryptedDocumentException, IOException {
    	List<Object> actualPercentile = new ArrayList<Object>();
		HoverOptions hoverOpt = new HoverOptions();
		hoverOpt.setForce(true);
		Locator data = page.locator(detPntPercentileRespTimeXaxisPoints);
		for (int i=0; i<data.count(); i++) {
			if(i==data.count()-1) 
				hoverOpt.setPosition(0, -10);
			else
				hoverOpt.setPosition(2, -10);
			
			data.nth(i).hover(hoverOpt);
			page.waitForSelector(detPntPercentileRespTimeTooltipLabel);
			Locator label = page.locator(detPntPercentileRespTimeTooltipLabel);
			Locator value = page.locator(detPntPercentileRespTimeTooltipValue);
				HashMap<String, String> percentileValues = new HashMap<String,String>();
				int sum=0;
				for(int j=0; j<label.count(); j++) {
					page.waitForTimeout(50);
					percentileValues.put(label.nth(j).textContent().trim().toUpperCase(), value.nth(j).textContent().trim().toUpperCase());
					sum = sum + (Integer.parseInt(value.nth(j).textContent().trim()));
				}
				if(sum!=0)
					actualPercentile.add(percentileValues);
		}
		System.out.println(actualPercentile);
		Assert.assertTrue(actualPercentile.equals(expectedPercentileRespTimeValues));
    }
    
    public void validateWhetherTheShowInstanceDependancyButtonIsPresentWithClientDetectpointGraphPanel() throws EncryptedDocumentException, IOException {
    	String expectedText = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.topologyPageSheet, "showInstanceDependencyBtn");
    	Assert.assertTrue(page.isVisible(instanceDepedencyBtn));
    	util.ValidateTheTitle(page, instanceDepedencyBtn, expectedText);	
    }
    
    public void validateTheFunctionalityOfShowInstanceDependancyButtonInClientDetectpointGraphPanel() throws EncryptedDocumentException, IOException {
    	validateWhetherTheShowInstanceDependancyButtonIsPresentWithClientDetectpointGraphPanel();
    	page.click(instanceDepedencyBtn);
    	String expectedButtonName = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.topologyPageSheet, "hideInstanceDependencyBtn");
    	util.ValidateTheTitle(page, instanceDepedencyBtn, expectedButtonName);
    	
    	String expectedMainTitle = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.topologyPageSheet, "instanceDependencyWindowMainTitle");
    	util.ValidateTheTitle(page, instanceDepedencyMainTitle, expectedMainTitle);
    	
    	String application = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.applicationNameSheet, "APM");
    	String dbName = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath,IPathConstant.apmDataValidationSheet, "databaseName");
    	util.ValidateTheTitle(page, instanceDepedencySubTitle, application+" -> "+dbName);
    	Assert.assertTrue(page.isVisible(instanceDepedencyCloseBtn));
    }
    
    public void validateTheFunctionalityOfHideInstanceDependancyButtonInClientDetectpointGraphPanel() throws EncryptedDocumentException, IOException {
    	validateTheFunctionalityOfShowInstanceDependancyButtonInClientDetectpointGraphPanel();
    	page.click(instanceDepedencyBtn);
    	Assert.assertTrue(page.isHidden(instanceDepedencyMainTitle));
    	Assert.assertTrue(page.isHidden(instanceDepedencyCloseBtn));
    	String expectedText = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.topologyPageSheet, "showInstanceDependencyBtn");
    	util.ValidateTheTitle(page, instanceDepedencyBtn, expectedText);
    }
    
    public void validateTheFunctionalityOfInstanceDependancyCloseButtonInClientDetectpointGraphPanel() throws EncryptedDocumentException, IOException {
    	validateTheFunctionalityOfShowInstanceDependancyButtonInClientDetectpointGraphPanel();
    	page.click(instanceDepedencyCloseBtn);
    	Assert.assertTrue(page.isHidden(instanceDepedencyMainTitle));
    	String expectedText = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.topologyPageSheet, "showInstanceDependencyBtn");
    	util.ValidateTheTitle(page, instanceDepedencyBtn, expectedText);
    }
    
    public void closeThePopup() {
    	Locator close = page.locator(addGroupPopupcloseButton);
    	if(close.count() == 0)
    		return;
    	else
    		for(int i=0; i<close.count(); i++) {
    			if(close.nth(i).isVisible()) {
    			close.nth(i).click();
    			page.waitForTimeout(200); }
    		}
    }
}
