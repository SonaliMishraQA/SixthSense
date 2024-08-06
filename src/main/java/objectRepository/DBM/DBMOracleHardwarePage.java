package objectRepository.DBM;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Locator.HoverOptions;
import com.microsoft.playwright.Page;
import genericUtilities.GenericMethods;
import genericUtilities.IPathConstant;
import objectRepository.CommonPage;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import genericUtilities.ExcelUtility;

import java.io.IOException;
import java.math.RoundingMode;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class DBMOracleHardwarePage {
    Page page;
    CommonPage common;
    ExcelUtility eutil = new ExcelUtility();
    GenericMethods util=new GenericMethods();
    static Connection connection = null;
    static Statement statement = null;

    private String databaseNavigationBtn= "#side-nav-database";
    private String databasePageTitle = "#title-text-database";
    private String selectDatabaseTypeDropDown= "#btn-arrow-down-search-select-database-type";
    private String selectDatabaseTypeTextField = "#input-search-sel-search-select-database-type";
    private String firstDbTypeFromDropDown ="xpath =//span[@id='search-select-database-type-0-single']";
    private String dataBaseTypeSearchResult ="xpath = //span[contains(@id,'search-select-database-type')]" ;
    private String selectedDatabaseType ="xpath = //div[@id='search-select-database-type']/div[@class='selected-item-text semiBold']";
    private String selectServiceDropDown = "#btn-arrow-down-search-select-database-service";
    private String selectServiceTextField = "#input-search-sel-search-select-database-service" ;
    private String firstServiceFromDropDown = "#search-select-database-service-0-single";
    private String serviceSearchResult ="xpath =//span[contains(@id,'search-select-database-service')]";
    private String selectedService ="xpath = //div[@id='search-select-database-service']/descendant::div[@class='selected-item-text semiBold']" ;
    private String selectNodeDropDown = "#btn-arrow-down-search-select-database-instance";
    private String selectNOdeTextField = "#input-search-sel-search-select-database-instance" ;
    private String firstDbFromDropDown = "#search-select-database-instance-0-single";
    private String nodeSearchResult= "//span[contains(@id,'search-select-database-instance')]" ;
    private String selectedDatabase ="xpath = //div[@id='search-select-database-instance']/descendant::div[@class='selected-item-text semiBold']";
    private String activeTab="xpath = //div[@class='router activeRouter']";
    private String hardwareTab ="xpath = //div[@class='item' and .=' Hardware ']";
    private String queryPerformanceTab="xpath = //div[@class='item' and .=' Query performance ' or @class='item' and .=' Query Performance ']";
    private String  connectionsTab ="xpath = //div[@class='item' and .=' Connections ']";
    private String metricsTab="xpath = //div[@class='item' and .=' Metrics ']" ;

    private String calendarIcon ="xpath = //span[@class='selected-icon']";
    private String selectedTimeLine ="xpath = //div[contains(@class,'selected-text ellipsis')]";


    //*********************************************       Hard ware page        ********************************* */
    private String typeOfOsElement="xpath = (//div[@class='wrapper-card-elements']/descendant::div[@class='textLabel'])[1]";
    private String architectureElement="xpath = (//div[@class='wrapper-card-elements']/descendant::div[@class='textLabel'])[2]";
    private String hostNameElement ="xpath = (//div[@class='wrapper-card-elements']/descendant::div[@class='textLabel'])[3]";
    private String availabilityElement ="xpath = (//div[@class='wrapper-card-elements']/descendant::div[@class='textLabel'])[4]";
    private String averageCpuUsageElement ="xpath = (//div[@class='wrapper-card-elements']/descendant::div[@class='textLabel'])[5]" ;
    private String averageMemoryUsageElement ="xpath = (//div[@class='wrapper-card-elements']/descendant::div[@class='textLabel'])[6]" ;
    private String typeOfOsValue="xpath = (//div[@class='wrapper-card-elements']/descendant::div[@class='textLabel'])[1]/preceding-sibling::div[@class='textVal fair']";
    private String architectureValue ="xpath = (//div[@class='wrapper-card-elements']/descendant::div[@class='textLabel'])[2]/preceding-sibling::div[@class='textVal fair']";
    private String hostNameValue ="xpath = (//div[@class='wrapper-card-elements']/descendant::div[@class='textLabel'])[3]/preceding-sibling::div[@class='textVal fair']";
    private String availabilityValue="xpath = (//div[@class='wrapper-card-elements']/descendant::div[@class='textLabel'])[4]/preceding-sibling::div";
    private String averageCpuUsageValue ="xpath = (//div[@class='wrapper-card-elements']/descendant::div[@class='textLabel'])[5]/preceding-sibling::div[@class='textVal fair']";
    private String averageMemoryUsageValue ="xpath = (//div[@class='wrapper-card-elements']/descendant::div[@class='textLabel'])[6]/preceding-sibling::div[@class='textVal fair']";
    private String diskUsageCardTitle ="xpath = //div[@class='card-header']";
    private String nodataText ="xpath = //div[@class='inner-text']";

    private String cpuUsageGraphTitle ="xpath = //div[@id='apexchartsvuechart-line-0']/ancestor::div[@class='chart-body']/preceding-sibling::div[@class='line-header']/div[@class='line-title']";
    private String cpuUsageGraphYaxisTitle ="xpath = //div[@id='apexchartsvuechart-line-0']/descendant::*[name()='g' and @class='apexcharts-yaxis-title']";
    private String cpuUsageGraphXaxisTitle ="xpath = //div[@id='apexchartsvuechart-line-0']/descendant::*[name()='g' and @class='apexcharts-xaxis-title']";
    private String cpuUsageGraphZoomOutBtn = "#CPU-usage-zoom-out";
    private String cpuUsageGraphZoomInBtn= "#CPU-usage-zoom-in";
    private String cpuUsageGraphZoomResetBtn = "#CPU-usage-zoom-reset";
    private String cpuUsageGraphXaxisPoints ="xpath = //div[@id='apexchartsvuechart-line-0']/descendant::*[name()='line' and @class='apexcharts-xaxis-tick']";
    private String cpuUsageGraphTooltipTitle = "xpath = //div[@id='apexchartsvuechart-line-0']/descendant::div[@class='apexcharts-tooltip-title']";
    private String cpuUsageGraphTooltipValue ="xpath = //div[@id='apexchartsvuechart-line-0']/descendant::span[@class='apexcharts-tooltip-text-y-value']";
    private String xAxisLabels ="xpath = //div[@id='apexchartsvuechart-line-0']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-label apexcharts-xaxis-label' and contains(.,'-')]";

    private String memoryUsageGraphTitle ="xpath = //div[@id='apexchartsvuechart-line-1']/ancestor::div[@class='chart-body']/preceding-sibling::div[@class='line-header']/div[@class='line-title']";
    private String memoryUsageGraphYaxisTitle ="xpath = //div[@id='apexchartsvuechart-line-1']/descendant::*[name()='g' and @class='apexcharts-yaxis-title']";
    private String memoryUsageGraphXaxisTitle ="xpath = //div[@id='apexchartsvuechart-line-1']/descendant::*[name()='g' and @class='apexcharts-xaxis-title']";
    private String memoryUsageGraphZoomOutBtn  = "#Memory-usage-zoom-out";
    private String memoryUsageGraphZoomInBtn = "#Memory-usage-zoom-in";
    private String memoryUsageGraphZoomResetBtn  = "#Memory-usage-zoom-reset";
    private String memoryUsageGraphXaxisPoints ="xpath = //div[@id='apexchartsvuechart-line-1']/descendant::*[name()='line' and @class='apexcharts-xaxis-tick']";
    private String memoryUsageGraphTooltipTitle ="xpath = //div[@id='apexchartsvuechart-line-1']/descendant::div[@class='apexcharts-tooltip-title']";
    private String memoryUsageGraphTooltipValue ="xpath = //div[@id='apexchartsvuechart-line-1']/descendant::span[@class='apexcharts-tooltip-text-y-value']";

    private String networkIODiskUsageGraphTitle="xpath = //div[@id='apexchartsvuechart-line-2']/ancestor::div[@class='chart-body']/preceding-sibling::div[@class='line-header']/div[@class='line-title']";
    private String networkIODiskUsageGraphYaxisTitle ="xpath = //div[@id='apexchartsvuechart-line-2']/descendant::*[name()='g' and @class='apexcharts-yaxis-title']";
    private String networkIODiskUsageGraphXaxisTitle="xpath = //div[@id='apexchartsvuechart-line-2']/descendant::*[name()='g' and @class='apexcharts-xaxis-title']";
    private String networkIODiskUsageGraphZoomOutBtn = "#Network-I/O-disk-usage-zoom-out";
    private String networkIODiskUsageGraphZoomInBtn= "#Network-I/O-disk-usage-zoom-in";
    private String networkIODiskUsageGraphZoomResetBtn = "#Network-I/O-disk-usage-zoom-reset";
    private String networkIODiskUsageGraphXaxisPoints ="xpath = //div[@id='apexchartsvuechart-line-2']/descendant::*[name()='line' and @class='apexcharts-xaxis-tick']";
    private String networkIODiskUsageGraphTooltipTitle ="xpath = //div[@id='apexchartsvuechart-line-2']/descendant::div[@class='apexcharts-tooltip-title']";
    private String networkIODiskUsageGraphTooltipValue ="xpath = //div[@id='apexchartsvuechart-line-2']/descendant::span[@class='apexcharts-tooltip-text-y-value']";

    private String networkIODiskRequestGraphTitle ="xpath = //div[@id='apexchartsvuechart-line-3']/ancestor::div[@class='chart-body']/preceding-sibling::div[@class='line-header']/div[@class='line-title']";
    private String networkIODiskRequestGraphYaxisTitle="xpath = //div[@id='apexchartsvuechart-line-3']/descendant::*[name()='g' and @class='apexcharts-yaxis-title']";
    private String networkIODiskRequestGraphXaxisTitle="xpath = //div[@id='apexchartsvuechart-line-3']/descendant::*[name()='g' and @class='apexcharts-xaxis-title']";
    private String networkIODiskRequestGraphZoomOutBtn = "#Network-I/O-disk-request-zoom-out";
    private String networkIODiskRequestGraphZoomInBtn = "#Network-I/O-disk-request-zoom-in";
    private String networkIODiskRequestGraphZoomResetBtn = "#Network-I/O-disk-request-zoom-reset";
    private String networkIODiskRequestGraphXaxisPoints="xpath = //div[@id='apexchartsvuechart-line-3']/descendant::*[name()='line' and @class='apexcharts-xaxis-tick']";
    private String networkIODiskRequestGraphTooltipTitle ="xpath = //div[@id='apexchartsvuechart-line-3']/descendant::div[@class='apexcharts-tooltip-title']";
    private String networkIODiskRequestGraphTooltipValue="xpath = //div[@id='apexchartsvuechart-line-3']/descendant::span[@class='apexcharts-tooltip-text-y-value']";

    private String calenderIcon = "xpath = //div[@class='rex-service-sel']/child::div[contains(@class,'selected')]";
    private String  fromCalenderIcon = "xpath = //label[text()=' From: ']/ancestor::div[@class='col-md-6']/descendant::button[@class='btn btn-secondary dropdown-toggle dropdown-toggle-no-caret']";
    private String toCalenderIcon ="xpath = //label[text()=' To: ']/ancestor::div[@class='col-md-6']/descendant::button[@class='btn btn-secondary dropdown-toggle dropdown-toggle-no-caret']";
    private String customeClose ="xpath = //span[@class='custom-close-icon']";
    private String custmoBackBtn="xpath = //button[@id='custom-back-btn']" ;
    private String fromClockIcon ="xpath = //label[text()=' From: ']/ancestor::div[@class='col-md-6']/descendant::button[@class='clear-btn pb-1']";
    private String firstTimeLine ="xpath = //div[@class='items']/child::div[position()=1]";
    private String toClockIcon ="xpath = //label[text()=' To: ']/ancestor::div[@class='col-md-6']/descendant::button[@class='clear-btn pb-1']";
    private String currentTimeLine ="xpath = //label[text()=' To: ']/ancestor::div[@class='col-md-6']/descendant::div[text()=' Now ']";
    private String customApplyBtn="xpath = //button[.=' Apply ']";
    private String customFromHoursTextField ="xpath = //label[text()=' From: ']/ancestor::div[@class='col-md-6']/descendant::input[@placeholder='hh']";
    private String customeFromMinutesTextField ="xpath = //label[text()=' From: ']/ancestor::div[@class='col-md-6']/descendant::input[@placeholder='mm']" ;
    private String customAMorPMPeriod ="xpath = //label[text()=' From: ']/ancestor::div[@class='col-md-6']/descendant::input[@id='period']";
    private String customToHoursTextField ="xpath = //label[text()=' To: ']/ancestor::div[@class='col-md-6']/descendant::input[@placeholder='hh']";
   private String customeToMinutesTextField="xpath = //label[text()=' To: ']/ancestor::div[@class='col-md-6']/descendant::input[@placeholder='mm']";
    private String customToAMorPMPeriod ="xpath = //label[text()=' To: ']/ancestor::div[@class='col-md-6']/descendant::input[@id='period']";
    private String  monthfromCustomCalenter ="xpath = div[@class='b-calendar-grid-caption text-center font-weight-bold']" ;
    private String  nextMonthButton ="xpath = //button[@title='Next month']" ;
    private String  refreshBtn = "#btn-refresh" ;

    private String closeBtn =" xpath = //button[@class='dialogCloseButton']";

    private String CPUUsageAxisLabels= "xpath = //div[@id='apexchartsvuechart-line-0']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-label apexcharts-xaxis-label' and contains(.,'-')]" ;
    private String MemoryUsagexAxisLabels= "xpath = //div[@id='apexchartsvuechart-line-1']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-label apexcharts-xaxis-label' and contains(.,'-')]" ;
    private String NetworkIODiskUsagexAxisLabels= "xpath = //div[@id='apexchartsvuechart-line-2']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-label apexcharts-xaxis-label' and contains(.,'-')]" ;
    private String NetworkIODiskRequestxAxisLabels= "xpath = //div[@id='apexchartsvuechart-line-3']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-label apexcharts-xaxis-label' and contains(.,'-')]" ;
    private String calanderValue = "xpath = //div[@class='selected-text ellipsis bg-text']";


    public DBMOracleHardwarePage(Page page) {
        this.page=page;
        common = new CommonPage(this.page);
    }


    public List<String> allWidgetXPoints()
    {
        ArrayList<String> xPoint = new ArrayList<String>();
        xPoint.add(cpuUsageGraphXaxisPoints);
        xPoint.add(memoryUsageGraphXaxisPoints);
        xPoint.add(networkIODiskRequestGraphXaxisPoints);
        xPoint.add(networkIODiskRequestGraphXaxisPoints);
        return xPoint;
    }

    public List<String> allWidgetXaxisLabels()
    {
        ArrayList<String> xPoint = new ArrayList<String>();
        xPoint.add(CPUUsageAxisLabels);
        xPoint.add(MemoryUsagexAxisLabels);
        xPoint.add(NetworkIODiskUsagexAxisLabels);
        xPoint.add(NetworkIODiskRequestxAxisLabels);
        return xPoint;
    }


    public void selectDatabase(String DatabaseType){
        util.selectTheOptionFromDropDownBySearch(page, selectDatabaseTypeDropDown, selectDatabaseTypeTextField, DatabaseType, dataBaseTypeSearchResult);
    }
    
    public void selectService(String serviceName){
        util.selectTheOptionFromDropDownBySearch(page, selectServiceDropDown, selectServiceTextField, serviceName, serviceSearchResult);
    }
    
    public void selectNode(String node){
    }

    public void validateDBMPagetitle(String expectedTitle )
    {
        String actualTitle = page.locator(databasePageTitle).innerHTML();
        util.ValidateTheTitle(actualTitle, expectedTitle);
    }


    public void validateHardwareTab(String ExpectedValue){
        Assert.assertTrue(page.locator(hardwareTab).isVisible());
        Assert.assertEquals(ExpectedValue,page.locator(hardwareTab).innerText());
    }


    public void validateTypeOfOSText() throws IOException {
        Assert.assertTrue(page.locator(typeOfOsElement).isVisible());
        Assert.assertEquals(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.oracleSheet, "Hardware_TypeofOS"),page.locator(typeOfOsElement).innerText());
    }


    public void validateArchitectureText() throws IOException {
        Assert.assertTrue(page.locator(architectureElement).isVisible());
        Assert.assertEquals(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.oracleSheet, "Hardware_Architecture"),page.locator(architectureElement).innerText());
    }

    public void validateHostNameText() throws IOException{
        Assert.assertTrue(page.locator(hostNameElement).isVisible());
        Assert.assertEquals(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.oracleSheet, "Hardware_hostname"),page.locator(hostNameElement).innerText());
    }

    public void validateAvailabilityText() throws IOException{
        Assert.assertTrue(page.locator(availabilityElement).isVisible());
        Assert.assertEquals(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.oracleSheet, "Hardware_Availability"),page.locator(availabilityElement).innerText());
    }

    public void validateAvgCPUUsageText() throws IOException{
        Assert.assertTrue(page.locator(availabilityElement).isVisible());
        Assert.assertEquals(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.oracleSheet, "Hardware_Average_CPU_Usage"),page.locator(averageCpuUsageElement).innerText());
    }

    public void validateAvgMemoryUsageText() throws IOException{
        Assert.assertTrue(page.locator(availabilityElement).isVisible());
        Assert.assertEquals(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.oracleSheet, "Hardware_Average_Memory_Usage"),page.locator(averageMemoryUsageElement).innerText());
    }

    public void validateDiskUsageText() throws IOException{
        Assert.assertTrue(page.locator(diskUsageCardTitle).isVisible());
        Assert.assertEquals(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.oracleSheet, "Hardware_Disk_usage_text_lable"),page.locator(diskUsageCardTitle).innerText());
    }


    public void validateCPUUsageText() throws IOException{
        Assert.assertTrue(page.locator(cpuUsageGraphTitle).isVisible());
        Assert.assertEquals(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.oracleSheet, "Hardware_CPU_usage_text_lable"),page.locator(cpuUsageGraphTitle).innerText());
    }


    public void validateMemoryUsageText() throws IOException{
        Assert.assertTrue(page.locator(memoryUsageGraphTitle).isVisible());
        Assert.assertEquals(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.oracleSheet, "Hardware_memory_usage_text_lable"),page.locator(memoryUsageGraphTitle).innerText());
    }

    public void validateNetworkIODiskUsageText() throws IOException{
        Assert.assertTrue(page.locator(networkIODiskUsageGraphTitle).isVisible());
        Assert.assertEquals(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.oracleSheet, "Hardware_NetworkIO_Disk_usage_text_lable"),page.locator(networkIODiskUsageGraphTitle).innerText());
    }
    public void validateNetworkIODiskRequestText() throws IOException{
        Assert.assertTrue(page.locator(networkIODiskRequestGraphTitle).isVisible());
        Assert.assertEquals(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.oracleSheet, "Hardware_NetworkIO_Disk_request_text_lable"),page.locator(networkIODiskRequestGraphTitle).innerText());
    }




    public void validateNoDataMessageInDiskUsage() throws IOException{
        Assert.assertTrue(page.locator(nodataText).isVisible());
        Assert.assertEquals("No data",page.locator(nodataText).innerText());
    }


    public void validateX_axis_of_CPU_usage_graph() {
        Assert.assertTrue(page.locator(cpuUsageGraphXaxisTitle).isVisible());
        Assert.assertEquals("Time",page.locator(cpuUsageGraphXaxisTitle).innerText());
    }


    public void validate_Y_axis_of_CPU_usage_graph() {
        Assert.assertTrue(page.locator(cpuUsageGraphYaxisTitle).isVisible());
        Assert.assertEquals("Percentage",page.locator(cpuUsageGraphYaxisTitle).innerText());
    }


    public void validate_X_axis_of_Memory_usage_graph() {
        Assert.assertTrue(page.locator(memoryUsageGraphXaxisTitle).isVisible());
        Assert.assertEquals("Time",page.locator(memoryUsageGraphXaxisTitle).innerText());
    }

    public void validate_Y_axis_of_Memory_usage_graph() {
        Assert.assertTrue(page.locator(memoryUsageGraphYaxisTitle).isVisible());
        Assert.assertEquals("MB",page.locator(memoryUsageGraphYaxisTitle).innerText());
    }


    public void validate_X_axis_of_NetworkIO_Disk_usage_graph() {
        Assert.assertTrue(page.locator(networkIODiskUsageGraphXaxisTitle).isVisible());
        Assert.assertEquals("MB",page.locator(networkIODiskUsageGraphXaxisTitle).innerText());
    }

    public void validate_Y_axis_of_NetworkIO_Disk_usage_graph() {
        Assert.assertTrue(page.locator(networkIODiskUsageGraphYaxisTitle).isVisible());
        Assert.assertEquals("MB",page.locator(networkIODiskUsageGraphYaxisTitle).innerText());
    }

    public void validate_X_axis_of_NetworkIO_Disk_Request_graph() {
        Assert.assertTrue(page.locator(networkIODiskRequestGraphXaxisTitle).isVisible());
        Assert.assertEquals("MB",page.locator(networkIODiskRequestGraphXaxisTitle).innerText());
    }

    public void validate_Y_axis_of_NetworkIO_Disk_Request_graph() {
        Assert.assertTrue(page.locator(networkIODiskRequestGraphYaxisTitle).isVisible());
        Assert.assertEquals("MB",page.locator(networkIODiskRequestGraphYaxisTitle).innerText());
    }


    public void validate_cpu_usage_graph_button_zoom_in_functionality(){
        util.graphZoomIn(page, cpuUsageGraphZoomInBtn, cpuUsageGraphZoomResetBtn, allWidgetXPoints());
    }


    public void validate_cpu_usage_graph_button_zoom_out_functionality(){
        util.graphZoomOut(page, cpuUsageGraphZoomInBtn,cpuUsageGraphZoomOutBtn, cpuUsageGraphZoomResetBtn, allWidgetXPoints());
    }


    public void validate_cpu_usage_graph_button_zoom_reset_functionality(){
        util.graphZoomReset(page, cpuUsageGraphZoomInBtn, cpuUsageGraphZoomResetBtn, allWidgetXPoints());
    }



    public void validate_memory_usage_graph_button_zoom_in_functionality(){
        util.graphZoomIn(page, memoryUsageGraphZoomInBtn, memoryUsageGraphZoomResetBtn, allWidgetXPoints());
    }


    public void validate_memory_usage_graph_button_zoom_out_functionality(){
        util.graphZoomOut(page,  memoryUsageGraphZoomInBtn,memoryUsageGraphZoomOutBtn, memoryUsageGraphZoomResetBtn, allWidgetXPoints());
    }


    public void validate_memory_usage_graph_button_zoom_reset_functionality(){
        util.graphZoomReset(page,  memoryUsageGraphZoomInBtn, memoryUsageGraphZoomResetBtn, allWidgetXPoints());
    }




    public void validate_network_IO_Disk_usage_graph_button_zoom_in_functionality(){
        util.graphZoomIn(page, networkIODiskUsageGraphZoomInBtn, networkIODiskUsageGraphZoomOutBtn, allWidgetXPoints());
    }


    public void validate_network_IO_disk_usage_graph_button_zoom_out_functionality(){
        util.graphZoomOut(page, networkIODiskUsageGraphZoomInBtn, networkIODiskUsageGraphZoomOutBtn,networkIODiskUsageGraphZoomResetBtn, allWidgetXPoints());
    }


    public void validate_network_IO_Disk_usage_graph_button_zoom_reset_functionality(){
        util.graphZoomReset(page,  networkIODiskUsageGraphZoomInBtn, networkIODiskUsageGraphZoomResetBtn, allWidgetXPoints());
    }




    public void validate_network_IO_Disk_request_graph_button_zoom_in_functionality(){
        util.graphZoomIn(page, networkIODiskRequestGraphZoomInBtn, networkIODiskRequestGraphZoomResetBtn, allWidgetXPoints());
    }


    public void validate_network_IO_Disk_request_graph_button_zoom_out_functionality(){
        util.graphZoomOut(page,  networkIODiskRequestGraphZoomInBtn,networkIODiskRequestGraphZoomOutBtn, networkIODiskRequestGraphZoomResetBtn, allWidgetXPoints());
    }


    public void validate_network_IO_Disk_request_graph_button_zoom_reset_functionality(){
        util.graphZoomReset(page,  networkIODiskRequestGraphZoomInBtn, networkIODiskRequestGraphZoomResetBtn, allWidgetXPoints());
    }



    public void validate_networkIO_Request_Disk_ZoomIn_Drag_Drop_functionality() {
        util.graphZoomInByDragAndDrop(page,networkIODiskRequestGraphXaxisPoints,networkIODiskRequestGraphZoomResetBtn,allWidgetXPoints());
    }


    public void validateTheGivenTimeLine()
    {
        util.validateTheGraphdisplayingTheDataAsPerGivenTimeLines(page,CPUUsageAxisLabels,calanderValue,allWidgetXaxisLabels());
    }
    
    public ResultSet connectToJdbcAndExecuteTheQuery(String query) throws EncryptedDocumentException, IOException, SQLException {
        String jdbcUrl = eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.oracleSheet, "dataValidation_jdbcURL");
        String dbUsername = eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.oracleSheet, "dataValidation_dbUsername");
        String dbPassword = eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.oracleSheet, "dataValidation_dbPassword");
      //Class.forName("oracle.jdbc.driver.OracleDriver");
        
      //Connect to the Database
        connection = DriverManager.getConnection(jdbcUrl, dbUsername, dbPassword);
        System.out.println("Connected to the database.");
        statement = connection.createStatement();
      //Send query and return result
    	return statement.executeQuery(query); 	
    }
    
    public void validateTheTypeOfOsInCard() throws EncryptedDocumentException, IOException, SQLException {
        //Send query and get result
        ResultSet resultSet = connectToJdbcAndExecuteTheQuery(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.oracleSheet, "dataValidation_query2"));
        String dbOsName = "";
    	while (resultSet.next()) {
        // Retrieve data from each row
            String os = resultSet.getString("OS_NAME");
            dbOsName = os.substring(0, os.indexOf(" "));
            System.out.println(dbOsName);
        }
		common.selectTheTimeLineFromCalender(IPathConstant.fiveMinutesTimeRange);
        String uiOsName = page.textContent(typeOfOsValue).trim();
        System.out.println(uiOsName);
        Assert.assertTrue(dbOsName.equalsIgnoreCase(uiOsName));
    }
    
    public void validateTheAverageMemoryUsageInCard() throws EncryptedDocumentException, IOException, SQLException {
    	//Send query and get result
        ResultSet resultSet = connectToJdbcAndExecuteTheQuery(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.oracleSheet, "dataValidation_query3"));
        long dbMemoryUsage = 0;
		while (resultSet.next()) {
            // Retrieve data from each row
                dbMemoryUsage = Math.round(resultSet.getLong("MEMORY_USAGE_BYTES")/1024.0/1024.0/1024.0);
                System.out.println(dbMemoryUsage);
        }
        long uiMemoryUsage = Long.parseLong(page.textContent(averageMemoryUsageValue).trim());
        System.out.println(uiMemoryUsage);
        Assert.assertTrue(dbMemoryUsage == uiMemoryUsage);
	}
    
    public void validateTheArchitecture() throws EncryptedDocumentException, IOException, SQLException {
        //Send query and get result
        ResultSet resultSet = connectToJdbcAndExecuteTheQuery(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.oracleSheet, "dataValidation_query2"));
        String dbArchitecture = "";
    	while (resultSet.next()) {
        // Retrieve data from each row
            String os = resultSet.getString("OS_NAME");
            dbArchitecture = os.substring(os.indexOf(" ")+1);
            System.out.println(dbArchitecture);
        }
		common.selectTheTimeLineFromCalender(IPathConstant.fiveMinutesTimeRange);
        String uiArchitecture = page.textContent(architectureValue).trim();
        System.out.println(uiArchitecture);
        Assert.assertTrue(dbArchitecture.equalsIgnoreCase(uiArchitecture));
    }
    
    public void validateTheHostName() throws EncryptedDocumentException, IOException, SQLException {
        //Send query and get result
        ResultSet resultSet = connectToJdbcAndExecuteTheQuery(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.oracleSheet, "dataValidation_query2"));
        String dbHost = "";
    	while (resultSet.next()) {
        // Retrieve data from each row
    		dbHost = resultSet.getString("HOST_NAME");
            System.out.println(dbHost);
        }
		common.selectTheTimeLineFromCalender(IPathConstant.fiveMinutesTimeRange);
        String uiHost = page.textContent(hostNameValue).trim();
        System.out.println(uiHost);
        Assert.assertTrue(dbHost.equalsIgnoreCase(uiHost));
    }
    
    public void validateCpuUsagePercentageValueInCard() throws EncryptedDocumentException, IOException, SQLException {
    	//Send query and get result
    	ResultSet resultSet = connectToJdbcAndExecuteTheQuery(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.oracleSheet, "dataValidation_query1"));
    	double value = 0.0;
        int dbValue = 0;
        int uiValue = 0;
		while (resultSet.next()) {
            // Retrieve data from each row
            if(resultSet.getString(2).equalsIgnoreCase("CPU Usage Per Sec")){
                value = resultSet.getDouble(3);
                break;
            }
        }
        System.out.println("Actual DB value: "+ value);
        DecimalFormat df=new DecimalFormat("#");
		common.selectTheTimeLineFromCalender(IPathConstant.fiveMinutesTimeRange);
		df.setRoundingMode(RoundingMode.UP);
        dbValue = (Integer.parseInt(df.format(value)));
        System.out.println("dbvalue: "+ dbValue);
        uiValue = Integer.parseInt(page.textContent(averageCpuUsageValue).trim());
        System.out.println("uivalue: "+ uiValue);
        Assert.assertTrue(dbValue == uiValue);
        resultSet.close();
    }
    
    public void validateCpuUsagePercentageValueInGraph() throws EncryptedDocumentException, IOException, SQLException {
    	ResultSet resultSet = connectToJdbcAndExecuteTheQuery(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.oracleSheet, "dataValidation_query1"));
    	double dbValue = 0.0, uiValue = 0.0;
		while (resultSet.next()) {
            if(resultSet.getString(2).equalsIgnoreCase("CPU Usage Per Sec"))
            {
                dbValue = resultSet.getDouble(3);
                break;
            }
        }
		//page.pause();
        System.out.println("Actual DB value: "+ dbValue);
        DecimalFormat df=new DecimalFormat("#");
		common.selectTheTimeLineFromCalender(IPathConstant.fiveMinutesTimeRange);
		df.setRoundingMode(RoundingMode.UP);
        dbValue = (Double.parseDouble(df.format(dbValue)));
        System.out.println("dbvalue: "+ dbValue);
        Locator xpoint = page.locator(cpuUsageGraphXaxisPoints);
        HoverOptions hoverOpt = new HoverOptions();
        hoverOpt.setForce(true);
        hoverOpt.setPosition(0, -10);
        xpoint.last().hover(hoverOpt);
        page.waitForSelector(cpuUsageGraphTooltipValue);
        uiValue = Double.parseDouble(page.textContent(cpuUsageGraphTooltipValue).trim());
        System.out.println("uivalue: "+ uiValue);
        if(dbValue == uiValue)
        	Assert.assertTrue(dbValue == uiValue);
        else {
        	hoverOpt.setPosition(2, -10);
            xpoint.nth(xpoint.count()-2).hover(hoverOpt);
            page.waitForSelector(cpuUsageGraphTooltipValue);
            uiValue = Double.parseDouble(page.textContent(cpuUsageGraphTooltipValue).trim());
            Assert.assertTrue(dbValue == uiValue);
        }
        resultSet.close();
    }
    
    public void validateNetworkIoDiskUsageValueInGraph() throws EncryptedDocumentException, IOException, SQLException {
    	ResultSet resultSet = connectToJdbcAndExecuteTheQuery(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.oracleSheet, "dataValidation_query1"));
    	double dbValue = 0.0, uiValue = 0.0;
		while (resultSet.next()) {
            if(resultSet.getString(2).equalsIgnoreCase("I/O Megabytes per Second"))
            {
                dbValue = resultSet.getDouble(3);
                break;
            }
        }
		//page.pause();
        System.out.println("Actual DB value: "+ dbValue);
        DecimalFormat df=new DecimalFormat("#.##");
		//df.setRoundingMode(RoundingMode.UP);
        dbValue = (Double.parseDouble(df.format(dbValue)));
        System.out.println("dbvalue: "+ dbValue);
		common.selectTheTimeLineFromCalender(IPathConstant.fiveMinutesTimeRange);
        page.waitForTimeout(300);
        Locator xpoint = page.locator(networkIODiskUsageGraphXaxisPoints);
        HoverOptions hoverOpt = new HoverOptions();
        hoverOpt.setForce(true);
        hoverOpt.setPosition(0, -10);
        xpoint.last().hover(hoverOpt);
        page.waitForSelector(networkIODiskUsageGraphTooltipValue);
        uiValue = Double.parseDouble(page.textContent(networkIODiskUsageGraphTooltipValue).trim());
        if(dbValue == uiValue) {
            System.out.println("uivalue: "+ uiValue);
            Assert.assertTrue(dbValue == uiValue);
        }
        else {
        	page.waitForTimeout(300);
        	hoverOpt.setPosition(2, -10);
            xpoint.nth(xpoint.count()-2).hover(hoverOpt);
            page.waitForSelector(networkIODiskUsageGraphTooltipValue);
            uiValue = Double.parseDouble(page.textContent(networkIODiskUsageGraphTooltipValue).trim());
            System.out.println("uivalue: "+ uiValue);
            Assert.assertTrue(dbValue == uiValue);
        }
        resultSet.close();
    }
    
    public void validateNetworkIoDiskRequestValueInGraph() throws EncryptedDocumentException, IOException, SQLException {
    	ResultSet resultSet = connectToJdbcAndExecuteTheQuery(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.oracleSheet, "dataValidation_query1"));
    	double value = 0.0;
    	int dbValue = 0, uiValue = 0;
		while (resultSet.next()) {
            if(resultSet.getString(2).equalsIgnoreCase("I/O Requests per Second"))
            {
                value = resultSet.getDouble(3);
                break;
            }
        }
        System.out.println("Actual DB value: "+ value);
//        DecimalFormat df=new DecimalFormat("#");
//		df.setRoundingMode(RoundingMode.UP);
//        dbValue = (Integer.parseInt(df.format(value)));
        page.waitForTimeout(500);
		common.selectTheTimeLineFromCalender(IPathConstant.fiveMinutesTimeRange);
        dbValue = (int)Math.round(value);
        System.out.println("dbvalue: "+ dbValue);
        Locator xpoint = page.locator(networkIODiskRequestGraphXaxisPoints);
        HoverOptions hoverOpt = new HoverOptions();
        hoverOpt.setForce(true);
        hoverOpt.setPosition(0, -10);
        xpoint.last().hover(hoverOpt);
        page.waitForSelector(networkIODiskRequestGraphTooltipValue);
        uiValue = Integer.parseInt(page.textContent(networkIODiskRequestGraphTooltipValue).trim());
        if(dbValue == uiValue) {
            System.out.println("uivalue: "+ uiValue);
            Assert.assertTrue(dbValue == uiValue);
        }
        else {
        	hoverOpt.setPosition(2, -10);
            xpoint.nth(xpoint.count()-2).hover(hoverOpt);
            page.waitForSelector(networkIODiskRequestGraphTooltipValue);
            uiValue = Integer.parseInt(page.textContent(networkIODiskRequestGraphTooltipValue).trim());
            System.out.println("uivalue: "+ uiValue);
            Assert.assertTrue(dbValue == uiValue);
        }
        resultSet.close();
    }
    
    public void validateTheAverageMemoryUsageInGraph() throws EncryptedDocumentException, IOException, SQLException {
    	//Send query and get result
        ResultSet resultSet = connectToJdbcAndExecuteTheQuery(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.oracleSheet, "dataValidation_query3"));
        long dbMemoryUsage = 0, uiMemoryUsage = 0;
		while (resultSet.next()) {
            // Retrieve data from each row
                dbMemoryUsage = Math.round(resultSet.getLong("MEMORY_USAGE_BYTES")/1024.0/1024.0/1024.0);
                System.out.println("dbMemoryUsage: "+dbMemoryUsage);
        }
		common.selectTheTimeLineFromCalender(IPathConstant.fiveMinutesTimeRange);
		Locator xpoint = page.locator(memoryUsageGraphXaxisPoints);
        HoverOptions hoverOpt = new HoverOptions();
        hoverOpt.setForce(true);
        hoverOpt.setPosition(0, -10);
        xpoint.last().hover(hoverOpt);
        page.waitForSelector(memoryUsageGraphTooltipValue);
        uiMemoryUsage = Long.parseLong(page.textContent(memoryUsageGraphTooltipValue).trim());
        System.out.println("uiMemoryUsage: "+ uiMemoryUsage);
        if(dbMemoryUsage == uiMemoryUsage)
        	Assert.assertTrue(dbMemoryUsage == uiMemoryUsage);
        else {
        	hoverOpt.setPosition(2, -10);
            xpoint.nth(xpoint.count()-2).hover(hoverOpt);
            page.waitForSelector(memoryUsageGraphTooltipValue);
            uiMemoryUsage = Long.parseLong(page.textContent(memoryUsageGraphTooltipValue).trim());
            Assert.assertTrue(dbMemoryUsage == uiMemoryUsage);
        }
        resultSet.close();
    }
    
    public void closeDbConnection() {
    	try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
            }catch (Exception e) {}
    }
}


