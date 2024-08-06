package DBMCapability.OracleDB;

import genericUtilities.ExcelUtility;
import genericUtilities.IPathConstant;
import objectRepository.CommonPage;
import objectRepository.DBM.DBMOracleHardwarePage;
import objectRepository.HomePage;
import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import playWrightFactory.BaseClass;

import java.io.IOException;

public class OracleHardwarePageTest extends BaseClass {

    HomePage homePage;
    ExcelUtility eutil;
    DBMOracleHardwarePage DBMOracleHardwarePage;
    CommonPage comPage;


    @BeforeMethod
    public void preRequest() throws EncryptedDocumentException, IOException {
        eutil = new ExcelUtility();
        homePage = new HomePage(page);
        DBMOracleHardwarePage = new DBMOracleHardwarePage(page);
        commPage.navigateToDBM();
        commPage.selectTheTimeLineFromCalender(" 1 month ");
        DBMOracleHardwarePage.selectDatabase(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.TypesOfDBs, "Oracle_DB"));

    }

    @Test
    public void TC_01_validateTheDBMCapabilitySideNavBtn() {
        DBMOracleHardwarePage.validateDBMPagetitle("DBM");
    }


    @Test
    public void TC_02_validateTheHardwareTab() throws IOException {
        DBMOracleHardwarePage.validateHardwareTab(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.oracleSheet, "Hardware_Metrics_Tab"));

    }


    @Test
    public void TC_03_validateTheFirstcardElementTypeOfOSText() throws IOException{
        DBMOracleHardwarePage.validateTypeOfOSText();
    }

    @Test
    public void TC_04_validatetheSecondCardElementArchitectureText() throws IOException{
        DBMOracleHardwarePage.validateArchitectureText();
    }


    @Test
    public void TC_05_validatethethirdCardElementHostNameText() throws IOException{
        DBMOracleHardwarePage.validateHostNameText();
    }


    @Test
    public  void TC_06_validateAvgCPUUsageText() throws IOException {
        DBMOracleHardwarePage.validateAvgCPUUsageText();
    }

    @Test
    public void TC_07_validateAvgMemoryUsageText() throws IOException {
        DBMOracleHardwarePage.validateAvgMemoryUsageText();
    }

    @Test
    public void TC_08_validateGraph_CPUUsageTitle() throws IOException {
        DBMOracleHardwarePage.validateCPUUsageText();
    }


    @Test
    public void TC_09_validateGraph_DiskUsageTitle() throws IOException {
        DBMOracleHardwarePage.validateDiskUsageText();
    }

    @Test
    public void TC_09_validateGraph_MemoryUsageTitle() throws IOException {
        DBMOracleHardwarePage.validateMemoryUsageText();
    }

    @Test
    public void TC_10_validateGraph_networkIODiskUsage() throws IOException {
        DBMOracleHardwarePage.validateNetworkIODiskUsageText();
    }

    @Test
    public void TC_11_validateGraph_networkIODiskRequest() throws IOException {
        DBMOracleHardwarePage.validateNetworkIODiskRequestText();
    }


    @Test
    public void TC_12_ValidateNoDataMessageInDiskUsage() throws IOException {
        DBMOracleHardwarePage.validateNoDataMessageInDiskUsage();
    }


    @Test
    public void TC_13_validate_X_axis_title_of_CPU_Usage_Graph(){
        DBMOracleHardwarePage.validateX_axis_of_CPU_usage_graph();
    }


    @Test
    public void TC_13_validate_Y_axis_title_of_CPU_Usage_Graph(){
        DBMOracleHardwarePage.validate_Y_axis_of_CPU_usage_graph();
    }

    @Test
    public void TC_14_validate_X_axis_title_of_Memory_Usage_Graph(){
        DBMOracleHardwarePage.validate_X_axis_of_Memory_usage_graph();
    }
    @Test
    public void TC_15_validate_Y_axis_title_of_Memory_Usage_Graph(){
        DBMOracleHardwarePage.validate_Y_axis_of_Memory_usage_graph();
    }


    @Test
    public void TC_16_validate_X_axis_title_of_NetworkIO_Disk_Usage_Graph(){
        DBMOracleHardwarePage.validate_X_axis_of_NetworkIO_Disk_usage_graph();
    }
    @Test
    public void TC_17_validate_Y_axis_title_of_NetworkIO_Disk_Usage_Graph(){
        DBMOracleHardwarePage.validate_Y_axis_of_NetworkIO_Disk_usage_graph();
    }



    @Test
    public void TC_18_validate_X_axis_title_of_NetworkIO_Disk_Request_Graph(){
        DBMOracleHardwarePage.validate_X_axis_of_NetworkIO_Disk_Request_graph();
    }
    @Test
    public void TC_19_validate_Y_axis_title_of_NetworkIO_Disk_Request_Graph(){
        DBMOracleHardwarePage.validate_Y_axis_of_NetworkIO_Disk_Request_graph();
    }

    @Test
    public void TC_20_validate_the_functionality_of_CPU_usage_graph_zoom_In_Button(){
        DBMOracleHardwarePage.validate_cpu_usage_graph_button_zoom_in_functionality();

    }

    @Test
    public void TC_21_validate_the_functionality_of_CPU_usage_graph_zoom_Out_Button(){
        DBMOracleHardwarePage.validate_cpu_usage_graph_button_zoom_out_functionality();
    }

    @Test
    public void TC_22_validate_the_functionality_of_CPU_usage_graph_zoom_Reset_Button(){
        DBMOracleHardwarePage.validate_cpu_usage_graph_button_zoom_reset_functionality();
    }



    @Test
    public void TC_23_validate_the_functionality_of_memory_usage_graph_zoom_In_Button(){
            DBMOracleHardwarePage.validate_memory_usage_graph_button_zoom_in_functionality();
    }

    @Test
    public void TC_24_validate_the_functionality_of_memory_usage_graph_zoom_Out_Button(){
        DBMOracleHardwarePage.validate_memory_usage_graph_button_zoom_out_functionality();
    }

    @Test
    public void TC_25_validate_the_functionality_of_memory_usage_graph_zoom_Reset_Button(){
        DBMOracleHardwarePage.validate_memory_usage_graph_button_zoom_reset_functionality();
    }



    @Test
    public void TC_26_validate_the_functionality_of_network_IO_Disk_usage_graph_zoom_In_Button(){
        DBMOracleHardwarePage.validate_network_IO_Disk_usage_graph_button_zoom_in_functionality();

    }

    @Test
    public void TC_27_validate_the_functionality_of_network_IO_Disk_usage_graph_zoom_Out_Button(){
        DBMOracleHardwarePage.validate_network_IO_disk_usage_graph_button_zoom_out_functionality();
    }

    @Test
    public void TC_28_validate_the_functionality_of_network_IO_Disk_usage_graph_zoom_Reset_Button(){
        DBMOracleHardwarePage.validate_network_IO_Disk_usage_graph_button_zoom_reset_functionality();
    }


    @Test
    public void TC_29_validate_the_functionality_of_network_IO_Disk_request_graph_zoom_In_Button(){
        DBMOracleHardwarePage.validate_network_IO_Disk_request_graph_button_zoom_in_functionality();
    }

    @Test
    public void TC_30_validate_the_functionality_of_network_IO_Disk_request_graph_zoom_Out_Button(){
        DBMOracleHardwarePage.validate_network_IO_Disk_request_graph_button_zoom_out_functionality();
    }

    @Test
    public void TC_31_validate_the_functionality_of_network_IO_Disk_request_graph_zoom_Reset_Button(){
        DBMOracleHardwarePage.validate_network_IO_Disk_request_graph_button_zoom_reset_functionality();
    }


    @Test
    public void TC_32_validate_drag_drop_action_on_Network_IO_disk_request_graph_Zoom_in_the_graphs(){
        DBMOracleHardwarePage.validate_networkIO_Request_Disk_ZoomIn_Drag_Drop_functionality();
    }


    @Test
    public void TC_33_validate_X_axis_labels_are_according_to_the_selected_timeline_5_mins(){
        commPage.selectTheTimeLineFromCalender(IPathConstant.fiveMinutesTimeRange);
        DBMOracleHardwarePage.validateTheGivenTimeLine();
    }
    @Test
    public void TC_34_validate_X_axis_labels_are_according_to_the_selected_timeline_15_mins(){
        commPage.selectTheTimeLineFromCalender(IPathConstant.fifteenMinutesTimeRange);
        DBMOracleHardwarePage.validateTheGivenTimeLine();
    }

    @Test
    public void TC_35_validate_X_axis_labels_are_according_to_the_selected_timeline_30_mins(){
        commPage.selectTheTimeLineFromCalender(IPathConstant.thirtyMinutesTimeRange);
        DBMOracleHardwarePage.validateTheGivenTimeLine();
    }

    @Test
    public void TC_36_validate_X_axis_labels_are_according_to_the_selected_timeline_60_mins(){
        commPage.selectTheTimeLineFromCalender(IPathConstant.sixtyMinutesTimeRange);
        DBMOracleHardwarePage.validateTheGivenTimeLine();

    }


    @Test
    public void TC_37_validate_X_axis_labels_are_according_to_the_selected_timeline_3_hours(){
        commPage.selectTheTimeLineFromCalender(IPathConstant.threeHoursTimeRange);
        DBMOracleHardwarePage.validateTheGivenTimeLine();
    }


    @Test
    public void TC_38_validate_X_axis_labels_are_according_to_the_selected_timeline_6_hours(){
        commPage.selectTheTimeLineFromCalender(IPathConstant.sixHoursTimeRange);
        DBMOracleHardwarePage.validateTheGivenTimeLine();
    }


    @Test
    public void TC_39_validate_X_axis_labels_are_according_to_the_selected_timeline_12_hours(){
        commPage.selectTheTimeLineFromCalender(IPathConstant.twelveHoursTimeRange);
        DBMOracleHardwarePage.validateTheGivenTimeLine();
    }

    @Test
    public void TC_40_validate_X_axis_labels_are_according_to_the_selected_timeline_1_day(){
        commPage.selectTheTimeLineFromCalender(IPathConstant.oneDayTimeRange);
        DBMOracleHardwarePage.validateTheGivenTimeLine();
    }


    @Test
    public void TC_41_validate_X_axis_labels_are_according_to_the_selected_timeline_1_week(){
        commPage.selectTheTimeLineFromCalender(IPathConstant.oneWeekTimeRange);
        DBMOracleHardwarePage.validateTheGivenTimeLine();
    }

    @Test
    public void TC_42_validate_X_axis_labels_are_according_to_the_selected_timeline_1_month(){
        commPage.selectTheTimeLineFromCalender(IPathConstant.oneMonthTimeRange);
        DBMOracleHardwarePage.validateTheGivenTimeLine();
    }

    @Test
    public void TC_43_validate_X_axis_labels_are_according_to_the_selected_custom_timeline(){
        commPage.selectTheTimeLineFromCalender(IPathConstant.customTimeRange);
        DBMOracleHardwarePage.validateTheGivenTimeLine();
    }


    @Test
    public void TC_44_validate_X_axis_labels_are_according_to_the_selected_custom_timeline_currentday(){
        commPage.selectTheTimeLineFromCalender(IPathConstant.customTimeRange);
        DBMOracleHardwarePage.validateTheGivenTimeLine();
    }


    @Test
    public void TC_45_validate_X_axis_labels_are_according_to_the_selected_custom_timeline_pastday(){
        commPage.selectTheTimeLineFromCalender(IPathConstant.customTimeRange);
        DBMOracleHardwarePage.validateTheGivenTimeLine();
    }






}
