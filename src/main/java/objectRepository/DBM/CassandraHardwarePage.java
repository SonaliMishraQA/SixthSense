package objectRepository.DBM;

import com.aventstack.extentreports.util.Assert;
import com.microsoft.playwright.Page;
import genericUtilities.GenericMethods;
import objectRepository.CommonPage;

import java.util.ArrayList;
import java.util.List;

public class CassandraHardwarePage {
    
        Page page;
        GenericMethods util=new GenericMethods();
        CommonPage comPage = new CommonPage(page);

        private String hardwareTab ="xpath =//div[@class='item' and .=' Hardware ']";
        private String queryPerformanceTab ="xpath =//div[.=' Query performance 'or  .=' Query Performance ' and @class='item']" ;
        private String connectionsTab ="xpath =//div[@class='item' and .=' Connections ']";
        private String metricsTab ="xpath =//div[@class='item' and .=' Metrics ']";

        private String calendarIcon="xpath =//span[@class='selected-icon']";
        private String selectedTimeLine="xpath =//div[contains(@class,'selected-text ellipsis')]";


        //*********************************************       Hard ware page        ********************************* */
        private String hardwareInfoBorder="xpath =//div[@class='wrapper-card-elements border-container']";
        private String typeOfOsElement="xpath =(//div[@class='wrapper-card-elements border-container']/descendant::div[@class='textLabel'])[1]";
        private String architectureElement="xpath =(//div[@class='wrapper-card-elements border-container']/descendant::div[@class='textLabel'])[2]" ;
        private String hostNameElement="xpath =(//div[@class='wrapper-card-elements border-container']/descendant::div[@class='textLabel'])[3]" ;
        private String availabilityElement="xpath =(//div[@class='wrapper-card-elements border-container']/descendant::div[@class='textLabel'])[4]" ;
        private String averageCpuUsageElement="xpath =(//div[@class='wrapper-card-elements border-container']/descendant::div[@class='textLabel'])[5]" ;
        private String averageMemoryUsageElement ="xpath =(//div[@class='wrapper-card-elements border-container']/descendant::div[@class='textLabel'])[6]" ;
        private String typeOfOsValue ="xpath =//div[@class='wrapper-card-elements border-container']/descendant::div[@class='textLabel'])[1]/preceding-sibling::div" ;
        private String architectureValue="xpath =//div[@class='wrapper-card-elements border-container']/descendant::div[@class='textLabel'])[2]/preceding-sibling::div" ;
        private String hostNameValue ="xpath =//div[@class='wrapper-card-elements border-container']/descendant::div[@class='textLabel'])[3]/preceding-sibling::div" ;
        private String availabilityValue ="xpath =//div[@class='wrapper-card-elements border-container']/descendant::div[@class='textLabel'])[4]/preceding-sibling::div";
        private String averageCpuUsageValue="xpath =//div[@class='wrapper-card-elements border-container']/descendant::div[@class='textLabel'])[5]/preceding-sibling::div";
        private String averageMemoryUsageValue="xpath =//div[@class='wrapper-card-elements border-container']/descendant::div[@class='textLabel'])[6]/preceding-sibling::div";

        private String clusterInfoBorder="xpath =//div[@class='wrapper-card-elements border-container cluster-info']" ;
        private String clusterNameElement="xpath =(//div[@class='wrapper-card-elements border-container cluster-info']/descendant::div[@class='textLabel'])[1]" ;
        private String keyspaceNameElement="xpath =(//div[@class='wrapper-card-elements border-container cluster-info']/descendant::div[@class='textLabel'])[2]" ;
        private String dataCenterElement="xpath =(//div[@class='wrapper-card-elements border-container cluster-info']/descendant::div[@class='textLabel'])[3]" ;
        private String cqlVersionElement="xpath =(//div[@class='wrapper-card-elements border-container cluster-info']/descendant::div[@class='textLabel'])[4]" ;
        private String rackElement="xpath =(//div[@class='wrapper-card-elements border-container cluster-info']/descendant::div[@class='textLabel'])[5]" ;
        private String clusterNamevalue="xpath =//div[@class='wrapper-card-elements border-container cluster-info']/descendant::div[@class='textLabel'])[1]/preceding-sibling::div" ;
        private String keyspaceNameValue="xpath =//div[@class='wrapper-card-elements border-container cluster-info']/descendant::div[@class='textLabel'])[2]/preceding-sibling::div";
        private String dataCenterValue="xpath =//div[@class='wrapper-card-elements border-container cluster-info']/descendant::div[@class='textLabel'])[3]/preceding-sibling::div" ;
        private String cqlVersionValue="xpath =//div[@class='wrapper-card-elements border-container cluster-info']/descendant::div[@class='textLabel'])[4]/preceding-sibling::div" ;
        private String rackValue="xpath =//div[@class='wrapper-card-elements border-container cluster-info']/descendant::div[@class='textLabel'])[5]/preceding-sibling::div" ;

        private String diskUsageCardTitle="xpath =//div[@class='card-header']";
        private String diskUsageCardNodataText="xpath =//div[@class='progress-card']//div[@class='inner-text']" ;

        private String cpuUsageGraphTitle="xpath =//div[@id='apexchartsvuechart-area-0']/ancestor::div[@class='chart-body']/preceding-sibling::div[@class='line-header']/div[@class='line-title']" ;
        private String cpuUsageGraphYaxisTitle="xpath =//div[@id='apexchartsvuechart-area-0']/descendant::*[name()='g' and @class='apexcharts-yaxis-title']" ;
        private String cpuUsageGraphXaxisTitle="xpath =//div[@id='apexchartsvuechart-area-0']/descendant::*[name()='g' and @class='apexcharts-xaxis-title']"  ;
        private String cpuUsageGraphZoomOutBtn ="id=CPU-usage-zoom-out" ;
        private String cpuUsageGraphZoomInBtn="id=CPU-usage-zoom-in"  ;
        private String cpuUsageGraphZoomResetBtn="id=CPU-usage-zoom-reset"  ;
        private String cpuUsageGraphXaxisPoints="xpath =//div[@id='apexchartsvuechart-area-0']/descendant::*[name()='line' and @class='apexcharts-xaxis-tick']" ;
        private String cpuUsageGraphTooltipTitle="xpath =//div[@id='apexchartsvuechart-area-0']/descendant::div[@class='apexcharts-tooltip-title']"  ;
        private String cpuUsageGraphTooltipValue="xpath =//div[@id='apexchartsvuechart-area-0']/descendant::span[@class='apexcharts-tooltip-text-y-value']"  ;
        private String cpuUsageGraphxAxisLabels="xpath =//div[@id='apexchartsvuechart-area-0']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-label apexcharts-xaxis-label' and contains(.,'-')]";

        private String memoryUsageGraphTitle="xpath =//div[@id='apexchartsvuechart-area-1']/ancestor::div[@class='chart-body']/preceding-sibling::div[@class='line-header']/div[@class='line-title']"  ;
        private String memoryUsageGraphYaxisTitle="xpath =//div[@id='apexchartsvuechart-area-1']/descendant::*[name()='g' and @class='apexcharts-yaxis-title']"  ;
        private String memoryUsageGraphXaxisTitle="xpath =//div[@id='apexchartsvuechart-area-1']/descendant::*[name()='g' and @class='apexcharts-xaxis-title']"  ;
        private String memoryUsageGraphZoomOutBtn="id=Memory-usage-zoom-out"  ;
        private String memoryUsageGraphZoomInBtn="id=Memory-usage-zoom-in"  ;
        private String memoryUsageGraphZoomResetBtn="id=Memory-usage-zoom-reset"  ;
        private String memoryUsageGraphXaxisPoints="xpath =//div[@id='apexchartsvuechart-area-1']/descendant::*[name()='line' and @class='apexcharts-xaxis-tick']" ;
        private String memoryUsageGraphTooltipTitle="xpath =//div[@id='apexchartsvuechart-area-1']/descendant::div[@class='apexcharts-tooltip-title']"  ;
        private String memoryUsageGraphTooltipValue="xpath =//div[@id='apexchartsvuechart-area-1']/descendant::span[@class='apexcharts-tooltip-text-y-value']"  ;

        private String networkIOGraphTitle="xpath =//div[@id='apexchartsvuechart-area-2']/ancestor::div[@class='chart-body']/preceding-sibling::div[@class='line-header']/div[@class='line-title']"  ;
        private String networkIOGraphYaxisTitle="xpath =//div[@id='apexchartsvuechart-area-2']/descendant::*[name()='g' and @class='apexcharts-yaxis-title']"  ;
        private String networkIOGraphXaxisTitle="xpath =//div[@id='apexchartsvuechart-area-2']/descendant::*[name()='g' and @class='apexcharts-xaxis-title']"  ;
        private String networkIOGraphZoomOutBtn="id =Network-I/O-zoom-out"  ;
        private String networkIOGraphZoomInBtn="id=Network-I/O-zoom-in"  ;
        private String networkIOGraphZoomResetBtn="id=Network-I/O-zoom-reset"  ;
        private String networkIOGraphXaxisPoints="xpath =//div[@id='apexchartsvuechart-area-2']/descendant::*[name()='line' and @class='apexcharts-xaxis-tick']"  ;
        private String networkIOGraphTooltipTitle="xpath =//div[@id='apexchartsvuechart-area-2']/descendant::div[@class='apexcharts-tooltip-title']"  ;
        private String networkIOGraphTooltipValue="xpath =//div[@id='apexchartsvuechart-area-2']/descendant::span[@class='apexcharts-tooltip-text-y-value']"  ;
        private String networkIOGraphLegendNames="xpath =//div[@id='apexchartsvuechart-area-2']/descendant::span[@class='apexcharts-legend-text']" ;
        private String activeLegendMarker="xpath =//div[@id='apexchartsvuechart-area-2']/descendant::span[@class='apexcharts-legend-marker']"  ;
        private String networkIOGraphActiveLegendMarker="xpath =//div[@id='apexchartsvuechart-area-2']/descendant::span[@class='apexcharts-legend-marker']"  ;

        private String legendActiveLine="xpath =//div[@id='apexchartsvuechart-area-2']//*[name()='g' and @class='apexcharts-series']//*[name()='circle']"  ;

        private String eventDetailsTableTitle="xpath =//table[@class='table-container']/caption[@class='title']"  ;
        private String firstColumn="xpath =(//table[@class='table-container']//td[@class='header-td'])[1]"  ;
        private String secondColumn="xpath =(//table[@class='table-container']//td[@class='header-td'])[2]"  ;
        private String thirdColumn="xpath =(//table[@class='table-container']//td[@class='header-td'])[3]"  ;
        private String eventDetailsTableNoDataText="xpath =//tbody[@class='body-container']/descendant::div[@class='inner-text']"  ;


        private String calenderIcon="xpath =//div[@class='rex-service-sel']/child::div[contains(@class,'selected')]"  ;
        private String fromCalenderIcon="xpath =//label[text()=' From: ']/ancestor::div[@class='col-md-6']/descendant::button[@class='btn btn-secondary dropdown-toggle dropdown-toggle-no-caret']"
         ;
        private String toCalenderIcon="xpath =//label[text()=' To: ']/ancestor::div[@class='col-md-6']/descendant::button[@class='btn btn-secondary dropdown-toggle dropdown-toggle-no-caret']"
         ;
        private String customeClose="xpath =//span[@class='custom-close-icon']"  ;
        private String custmoBackBtn="xpath =//button[@id='custom-back-btn']"  ;
        private String fromClockIcon="xpath =//label[text()=' From: ']/ancestor::div[@class='col-md-6']/descendant::button[@class='clear-btn pb-1']"  ;
        private String firstTimeLine="xpath =//div[@class='items']/child::div[position()=1]"  ;
        private String toClockIcon="xpath =//label[text()=' To: ']/ancestor::div[@class='col-md-6']/descendant::button[@class='clear-btn pb-1']"  ;
        private String currentTimeLine="xpath =//label[text()=' To: ']/ancestor::div[@class='col-md-6']/descendant::div[text()=' Now ']"  ;
        private String customApplyBtn="xpath =//button[.=' Apply ']"  ;
        private String customFromHoursTextField="xpath =//label[text()=' From: ']/ancestor::div[@class='col-md-6']/descendant::input[@placeholder='hh']"  ;
        private String customeFromMinutesTextField="xpath =//label[text()=' From: ']/ancestor::div[@class='col-md-6']/descendant::input[@placeholder='mm']"  ;
        private String customAMorPMPeriod="xpath =//label[text()=' From: ']/ancestor::div[@class='col-md-6']/descendant::input[@id='period']"  ;
        private String customToHoursTextField="xpath =//label[text()=' To: ']/ancestor::div[@class='col-md-6']/descendant::input[@placeholder='hh']"  ;
        private String customeToMinutesTextField="xpath =//label[text()=' To: ']/ancestor::div[@class='col-md-6']/descendant::input[@placeholder='mm']"  ;
        private String customToAMorPMPeriod="xpath =//label[text()=' To: ']/ancestor::div[@class='col-md-6']/descendant::input[@id='period']"  ;
        private String monthfromCustomCalenter="xpath =//div[@class='b-calendar-grid-caption text-center font-weight-bold']" ;
        private String nextMonthButton="xpath =//button[@title='Next month']"  ;
        private String refreshBtn="id=btn-refresh"  ;

        private String closeBtn="xpath =//button[@class='dialogCloseButton']"  ;
        private String selectDatabaseTypeDropDown= "id =btn-arrow-down-search-select-database-type";

        private String selectServiceDropDown= "id =btn-arrow-down-search-select-database-service";

        private String selectDataInstanceDropDown= "id =btn-arrow-down-search-select-database-instance";

        private String firstDataInstanceDropDownValue= "id =search-select-database-instance-0-single";

        private String selectDatabaseTypeTextField="id =input-search-sel-search-select-database-type";
        private String firstDbTypeFromDropDown ="xpath = //span[@id='search-select-database-type-0-single']";
        private String firstServiceTypeFromDropDownValue="#search-select-database-service-0-single";

        private String firstFromDropDown="xpath = //span[@id='search-select-database-type-0-single']";



        private String calanderValue = "xpath = //div[@class='selected-text ellipsis bg-text']";

        private String cpuUsageXaxisValues="xpath =//div[@id='apexchartsvuechart-area-0']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-label apexcharts-xaxis-label']/child::*[name()='tspan' and contains(.,'-')]" ;
        private String memoryUsageXaxisValues="xpath =//div[@id='apexchartsvuechart-area-1']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-label apexcharts-xaxis-label']/child::*[name()='tspan' and contains(.,'-')]" ;

        private String networkIOXaxisValues="xpath =//div[@id='apexchartsvuechart-area-2']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-label apexcharts-xaxis-label']/child::*[name()='tspan' and contains(.,'-')]" ;

        public void selectDataBaseType(String dataBaseName) {
                page.locator(selectDatabaseTypeDropDown).click();
                page.locator("//span[@class='selected-item-text' and text()='" + dataBaseName + "']").click();
        }

        public void selectServiceType() {
                page.locator(selectServiceDropDown).click();
                page.locator(firstServiceTypeFromDropDownValue).click();
        }

        public void selectDataInstanceTypeDropdown() {
                page.locator(selectDataInstanceDropDown).click();
                page.locator(firstDataInstanceDropDownValue).click();
        }


        public CassandraHardwarePage(Page page) {
                this.page=page;
        }

        public List<String> allWidgetXValues()
        {
                ArrayList<String> xValue = new ArrayList<String>();
                xValue.add(cpuUsageXaxisValues);
                xValue.add(memoryUsageXaxisValues);
                xValue.add(networkIOXaxisValues);

                return xValue;
        }

        public void validateBorderHeadingHardwareInfoWrapperCard(String expectedTitle)
        {
                String hardwareInfoText=(String) page.locator(hardwareInfoBorder).evaluate("element => getComputedStyle(element,':after').getPropertyValue('content')");
                System.out.println(hardwareInfoText);
                util.ValidateTheTitle(hardwareInfoText, expectedTitle);
        }

        public void validateTheTitleTypeOfOsElementOfHardwareInfoWrapperCard(String expectedTitle)
        {
                util.ValidateTheTitle(page, typeOfOsElement, expectedTitle);
        }

        public void validateTheTitleArchitectureElementOfHardwareInfoWrapperCard(String expectedTitle)
        {
                util.ValidateTheTitle(page, architectureElement, expectedTitle);
        }

        public void validateTheTitleHostNameElementOfHardwareInfoWrapperCard(String expectedTitle)
        {
                util.ValidateTheTitle(page, hostNameElement, expectedTitle);
        }

        public void validateTheTitleAvailabilityElementOfHardwareInfoWrapperCard(String expectedTitle) {
                util.ValidateTheTitle(page, availabilityElement, expectedTitle);
        }

        public void validateTheTitleAverageCpuUsageElementOfHardwareInfoWrapperCard(String expectedTitle) {
                util.ValidateTheTitle(page, averageCpuUsageElement, expectedTitle);
        }

        public void validateTheTitleAverageMemoryUsageElementOfHardwareInfoWrapperCard(String expectedTitle) {
                util.ValidateTheTitle(page, averageMemoryUsageElement, expectedTitle);
        }

        public void validateTheTitleClusterInfoBorderElementOfClusterInfoWrapperCard(String expectedTitle) {
                String clusterInfoText=(String) page.locator(clusterInfoBorder).evaluate("element => getComputedStyle(element,':after').getPropertyValue('content')");
                System.out.println(clusterInfoText);
                util.ValidateTheTitle(clusterInfoText, expectedTitle);
        }

        public void validateTheTitleClusterNameElementOfClusterInfoWrapperCard(String expectedTitle) {
                System.out.println(page.locator(clusterNameElement).textContent().trim());

                util.ValidateTheTitle(page, clusterNameElement, expectedTitle);
        }

        public void validateTheTitlekeyspaceNameElementOfClusterInfoWrapperCard(String expectedTitle) {
                util.ValidateTheTitle(page, keyspaceNameElement, expectedTitle);
        }

        public void validateTheTitleDataCenterElementOfClusterInfoWrapperCard(String expectedTitle) {
                util.ValidateTheTitle(page, dataCenterElement, expectedTitle);
        }


        public void validateTheTitleCqlVersionElementOfClusterInfoWrapperCard(String expectedTitle) {
                util.ValidateTheTitle(page, cqlVersionElement, expectedTitle);
        }

        public void validateTheTitleRackElementOfClusterInfoWrapperCard(String expectedTitle) {
                util.ValidateTheTitle(page, rackElement, expectedTitle);
        }

        public void validateTheDiscUsageCardTitleUnderHardwareTab(String expectedTitle) {
                util.ValidateTheTitle(page, diskUsageCardTitle, expectedTitle);
        }

        public void validateTheDiscUsageCardNoTextUnderHardwareTab(String expectedTitle) {
                util.ValidateTheTitle(page, diskUsageCardNodataText, expectedTitle);
        }

        public void validateTheCpuUsageGraphTitleTextUnderHardwareTab(String expectedTitle) {
                util.ValidateTheTitle(page, cpuUsageGraphTitle, expectedTitle);
        }

        public void validateTheCpuUsageGraphXaxisTitleTextUnderHardwareTab(String expectedTitle) {
                util.ValidateTheTitle(page, cpuUsageGraphXaxisTitle, expectedTitle);
        }

        public void validateTheCpuUsageGraphYaxisTitleTextUnderHardwareTab(String expectedTitle) {
                util.ValidateTheTitle(page, cpuUsageGraphYaxisTitle, expectedTitle);
        }
        public List<String> allWidgetXPoints()
        {
                ArrayList<String> xPoint = new ArrayList<String>();
                xPoint.add(cpuUsageGraphXaxisPoints);
                xPoint.add(memoryUsageGraphXaxisPoints);
                xPoint.add(networkIOGraphXaxisPoints);
                return xPoint;
        }

        public void validateCpuUsageZoomIn()
        {
                util.graphZoomIn(page, cpuUsageGraphZoomInBtn, cpuUsageGraphZoomResetBtn, allWidgetXPoints());
        }

        public void validateCpuUsageZoomOut()
        {
                util.graphZoomOut(page,cpuUsageGraphZoomInBtn,cpuUsageGraphZoomOutBtn,cpuUsageGraphZoomResetBtn, allWidgetXPoints());
        }

        public void validateCpuUsageZoomReset()
        {
                util.graphZoomReset(page, cpuUsageGraphZoomInBtn,cpuUsageGraphZoomResetBtn, allWidgetXPoints());
        }

        public void validateTheMemoryUsageGraphTitleTextUnderHardwareTab(String expectedTitle) {
                util.ValidateTheTitle(page, memoryUsageGraphTitle, expectedTitle);
        }

        public void validateTheMemoryUsageGraphXaxisTitleTextUnderHardwareTab(String expectedTitle) {
                util.ValidateTheTitle(page, memoryUsageGraphXaxisTitle, expectedTitle);
        }

        public void validateTheMemoryUsageGraphYaxisTitleTextUnderHardwareTab(String expectedTitle) {
                util.ValidateTheTitle(page, memoryUsageGraphYaxisTitle, expectedTitle);
        }

        public void validateMemoryUsageZoomIn()
        {
                util.graphZoomIn(page, memoryUsageGraphZoomInBtn, memoryUsageGraphZoomResetBtn, allWidgetXPoints());
        }

        public void validateMemoryUsageZoomOut()
        {
                util.graphZoomOut(page,memoryUsageGraphZoomInBtn,memoryUsageGraphZoomOutBtn,memoryUsageGraphZoomResetBtn, allWidgetXPoints());
        }

        public void validateMemoryCpuUsageZoomReset()
        {
                util.graphZoomReset(page, memoryUsageGraphZoomInBtn,memoryUsageGraphZoomResetBtn, allWidgetXPoints());
        }

        public void validateTheNetworkIOGraphTitleTextUnderHardwareTab(String expectedTitle) {
                util.ValidateTheTitle(page, networkIOGraphTitle, expectedTitle);
        }

        public void validateTheNetworkIOGraphXaxisTitleTextUnderHardwareTab(String expectedTitle) {
                util.ValidateTheTitle(page, networkIOGraphXaxisTitle, expectedTitle);
        }

        public void validateTheNetworkIOGraphYaxisTitleTextUnderHardwareTab(String expectedTitle) {
                util.ValidateTheTitle(page, networkIOGraphYaxisTitle, expectedTitle);
        }

        public void validateNetworkIOZoomIn()
        {
                util.graphZoomIn(page, networkIOGraphZoomInBtn, networkIOGraphZoomResetBtn, allWidgetXPoints());
        }

        public void validateNetworkIOZoomOut()
        {
                util.graphZoomOut(page,networkIOGraphZoomInBtn,networkIOGraphZoomOutBtn,networkIOGraphZoomResetBtn, allWidgetXPoints());
        }

        public void validateNetworkIOZoomReset()
        {
                util.graphZoomReset(page, networkIOGraphZoomInBtn,networkIOGraphZoomResetBtn, allWidgetXPoints());
        }

        public void validateCpuUsageDragDrop()
        {
                util.graphZoomInByDragAndDrop(page,cpuUsageGraphXaxisPoints,cpuUsageGraphZoomResetBtn, allWidgetXPoints());
        }

        public void validateMemoryUsageDragDrop()
        {
                util.graphZoomInByDragAndDrop(page,memoryUsageGraphXaxisPoints,memoryUsageGraphZoomResetBtn, allWidgetXPoints());
        }

        public void validateNetworkIOUsageDragDrop()
        {
                util.graphZoomInByDragAndDrop(page,networkIOGraphXaxisPoints,networkIOGraphZoomResetBtn, allWidgetXPoints());
        }

        public void validateNetworkIOLegendsText(String expectedLegends)
        {
                util.validateWidgetLegendsText(page,networkIOGraphLegendNames,expectedLegends);
        }

        public void validateTheEventDetailsTitleTextUnderHardwareTab(String expectedTitle) {
                util.ValidateTheTitle(page, eventDetailsTableTitle, expectedTitle);
        }

        public void validateTheEventDetailsFirstColumnTitleTextUnderHardwareTab(String expectedTitle) {
                util.ValidateTheTitle(page, firstColumn, expectedTitle);
        }

        public void validateTheEventDetailsSecondColumnTitleTextUnderHardwareTab(String expectedTitle) {
                util.ValidateTheTitle(page, secondColumn, expectedTitle);
        }

        public void validateTheEventDetailsThirdColumnTitleTextUnderHardwareTab(String expectedTitle) {
                util.ValidateTheTitle(page, thirdColumn, expectedTitle);
        }

        public void validateTheEventDetailsNoDataTextUnderHardwareTab(String expectedTitle) {
                util.ValidateTheTitle(page, eventDetailsTableNoDataText, expectedTitle);
        }

        public void validateTheLegendSelectInNetworkIO(String expectedTitle) {
                util.ValidateTheTitle(page, eventDetailsTableNoDataText, expectedTitle);
        }

        public void validateTheGivenTimeLine()
        {
                util.validateTheGraphdisplayingTheDataAsPerGivenTimeLines(page,cpuUsageXaxisValues,calanderValue,allWidgetXValues());
        }


        public void validateTheCustomTimeLine(String period)
        {
                util.validateCustomTimeLine(page,cpuUsageXaxisValues,period,allWidgetXValues());
        }


//        public void validateTheLegendsNetworkIOGraph()
//        {
//                util.validateWidgetLegends(page,networkIOGraphLegendNames,networkIOGraphActiveLegendMarker)
//        }



// private String="xpath =//div[@class='progress-header-content-identifier']"  diskUsageApplicationText;
// private String="xpath =//div[@class='progress-info']/child::div[position()=1]/child::div[@class='progress-info-content-identifier-value']"  storageUsageValue;
// private String="xpath =//div[@class='progress-info']/child::div[position()=1]/child::div[@class='progress-info-content-identifier']" storageUsageElement;
// private String="xpath =//div[@class='progress-info']/child::div[position()=2]/child::div[@class='progress-info-content-identifier']" storageAvailableElement;
// private String="xpath =//div[@class='progress-info']/child::div[position()=2]/child::div[@class='green-color-text']"  storageAvailableValue;


    }

