package DBMCapability.OracleDB;

import com.microsoft.playwright.Page;
import genericUtilities.ExcelUtility;
import genericUtilities.GenericMethods;
import genericUtilities.IPathConstant;
import objectRepository.CommonPage;
import objectRepository.DBM.DBMOracleHardwarePage;
import objectRepository.DBM.DBMOracleMetricsPage;
import objectRepository.HomePage;
import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import playWrightFactory.BaseClass;

import java.io.IOException;

public class OracleMetricsPageTest extends BaseClass {

    HomePage homePage;
    ExcelUtility eutil;
    objectRepository.DBM.DBMOracleMetricsPage DBMOracleMetricPage;
    CommonPage comPage;

    @BeforeMethod
    public void preRequest() throws EncryptedDocumentException, IOException {
        eutil = new ExcelUtility();
        homePage = new HomePage(page);
        DBMOracleMetricPage = new DBMOracleMetricsPage(page);
        commPage.navigateToDBM();
        commPage.selectTheTimeLineFromCalender("1 month ");
        DBMOracleMetricPage.selectDatabase(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.TypesOfDBs, "oracle"));
        DBMOracleMetricPage.selectservice(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.TypesOfDBs, "oracle"));
        DBMOracleMetricPage.selectDatabase1(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.TypesOfDBs, "oracle"));
        DBMOracleMetricPage.NavigateToMetricsSection();
    }


    @Test
    public void TC_01_Validate_Title_of_host_CPU_utilization_graph() throws IOException {
        DBMOracleMetricPage.verify_the_Title_Of_Host_CPU_Utilization_Graph(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.oracleSheet, "Metics_host_cpu_utilization"));
    }


    @Test
    public void TC_02_Validate_Xaxis_Title_of_host_CPU_utilization_graph() throws IOException {
        DBMOracleMetricPage.verify_the_Xaxis_Title_Of_Host_CPU_Utilization_Graph(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.oracleSheet, "Metrics_all_graphs_xaxis_tilte"));
    }

    @Test
    public void TC_03_Validate_Yaxis_Title_of_host_CPU_utilization_graph() throws IOException {
        DBMOracleMetricPage.verify_the_Yaxis_Title_Of_Host_CPU_Utilization_Graph(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.oracleSheet, "Metrics_host_cpu_utlization_Yaxis_tilte"));
    }


    @Test
    public void TC_04_Validate_functionality_of_host_CPU_utilization_graph_zoom_in() throws IOException {
        DBMOracleMetricPage.validate_host_CPU_utilization_graph_zoomin();
    }



    @Test
    public void TC_05_Validate_functionality_of_host_CPU_utilization_graph_zoom_out() throws IOException {
       DBMOracleMetricPage.validate_host_CPU_utilization_graph_zoomout();
    }


    @Test
    public void TC_06_Validate_functionality_of_host_CPU_utilization_graph_zoom_reset(){
        DBMOracleMetricPage.validate_host_CPU_utilization_graph_zoomReset();
    }


    @Test
    public void TC_07_Validate_drag_drop_of_host_CPU_utilization_graph_zoom(){
        DBMOracleMetricPage.validate_host_CPU_utilization_graph_zoomDragnDrop();
    }


    @Test
    public void TC_08_Validate_Title_of_disk_read_per_second_graph() throws IOException {
        DBMOracleMetricPage.verify_the_Title_Of_disk_read_per_second_Graph(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.oracleSheet, ""));
    }


    @Test
    public void TC_09_Validate_Xaxis_Title_of_disk_read_per_second_graph() throws IOException {
        DBMOracleMetricPage.verify_th_Xaxis_Title_Of_disk_read_per_second_Graph(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.oracleSheet, ""));
    }

    @Test
    public void TC_10_Validate_Yaxis_Title_of_disk_read_per_second_graph() throws IOException {
        DBMOracleMetricPage.verify_th_Yaxis_Title_Of_disk_read_per_second_Graph(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.oracleSheet, ""));

    }

    @Test
    public void TC_11_Validate_functionality_of_disk_read_per_second_graph_zoom_in(){
        DBMOracleMetricPage.validate_disk_read_per_second_graph_zoomin();
    }



    @Test
    public void TC_12_Validate_functionality_of_disk_read_per_second_graph_zoom_out(){
        DBMOracleMetricPage.validate_disk_read_per_second_graph_zoomout();
    }


    @Test
    public void TC_13_Validate_functionality_of_disk_read_per_second_graph_zoom_reset(){
        DBMOracleMetricPage.validate_disk_read_per_second_graph_zoomReset();
    }


    @Test
    public void TC_14_Validate_drag_drop_of_disk_read_per_second_graph_zoom(){
        DBMOracleMetricPage.validate_disk_read_per_second_graph_zoomDragnDrop();
    }


    @Test
    public void TC_15_Validate_Title_of_disk_write_per_second_graph() throws IOException {
        DBMOracleMetricPage.verify_the_Title_Of_disk_write_per_second_Graph(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.oracleSheet, ""));
    }


    @Test
    public void TC_16_Validate_Xaxis_Title_of_disk_write_per_second_graph() throws IOException {
        DBMOracleMetricPage.verify_the_Xaxis_Title_Of_disk_write_per_second_Graph(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.oracleSheet, ""));
    }

    @Test
    public void TC_17_Validate_Yaxis_Title_of_disk_write_per_second_graph() throws IOException {
        DBMOracleMetricPage.verify_the_Yaxis_Title_Of_disk_write_per_second_Graph(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.oracleSheet, ""));
    }


    @Test
    public void TC_18_Validate_functionality_of_disk_write_per_second_graph_zoom_in(){
        DBMOracleMetricPage.validate_disk_write_per_second_graph_zoomin();

    }



    @Test
    public void TC_19_Validate_functionality_of_disk_write_per_second_graph_zoom_out(){
        DBMOracleMetricPage.validate_disk_write_per_second_graph_zoomout();
    }


    @Test
    public void TC_20_Validate_functionality_of_disk_write_per_second_graph_zoom_reset(){
        DBMOracleMetricPage.validate_disk_write_per_second_graph_zoomReset();
    }


    @Test
    public void TC_21_Validate_drag_drop_of_disk_write_per_second_graph_zoom(){
        DBMOracleMetricPage.validate_disk_write_per_second_graph_zoomDragnDrop();
    }




    @Test
    public void TC_22_Validate_Title_for_no_of_long_running_gt60_queries_graph() throws IOException {
        DBMOracleMetricPage.verify_the_Title_Of_long_running_gt60_queries_Graph(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.oracleSheet, ""));
    }


    @Test
    public void TC_23_Validate_Xaxis_Title_for_no_of_long_running_gt60_queries_graph() throws IOException {
        DBMOracleMetricPage.verify_the_Xaxis_Title_Of_long_running_gt60_queries_Graph(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.oracleSheet, ""));

    }

    @Test
    public void TC_24_Validate_Yaxis_Title_for_no_of_long_running_gt60_queries_graph() throws IOException{
        DBMOracleMetricPage.verify_the_Yaxis_Title_Of_long_running_gt60_queries_Graph(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.oracleSheet, ""));
    }


    @Test
    public void TC_25_Validate_functionality_of_no_of_long_running_gt60_queries_graph_zoom_in(){
        DBMOracleMetricPage.validate_no_of_long_running_gt60_queries_graph_zoomin();
    }



    @Test
    public void TC_26_Validate_functionality_of_no_of_long_running_gt60_queries_graph_zoom_out(){
        DBMOracleMetricPage.validate_no_of_long_running_gt60_queries_graph_zoomOut();
    }


    @Test
    public void TC_27_Validate_functionality_of_no_of_long_running_gt60_queries_graph_zoom_reset(){
        DBMOracleMetricPage.validate_no_of_long_running_gt60_queries_graph_zoomReset();
    }


    @Test
    public void TC_28_Validate_drag_drop_of_no_of_long_running_gt60_queries_graph_zoom(){
        DBMOracleMetricPage.validate_no_of_long_running_gt60_queries_graph_zoomDragnDrop();
    }



    @Test
    public void TC_29_Validate_Title_of_user_transaction_graph() throws IOException {
        DBMOracleMetricPage.verify_the_Title_Of_of_user_transaction_Graph(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.oracleSheet, ""));
    }


    @Test
    public void TC_30_Validate_Xaxis_Title_of_user_transaction_graph() throws IOException {
        DBMOracleMetricPage.verify_the_Xaxis_Title_Of_of_user_transaction_Graph(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.oracleSheet, ""));
    }

    @Test
    public void TC_31_Validate_Yaxis_Title_of_user_transaction_graph() throws IOException {
        DBMOracleMetricPage.verify_the_Yaxis_Title_Of_of_user_transaction_Graph(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.oracleSheet, ""));
    }


    @Test
    public void TC_32_Validate_functionality_of_user_transaction_graph_zoom_in(){
        DBMOracleMetricPage.validate_user_transaction_graph_zoomin();
    }



    @Test
    public void TC_33_Validate_functionality_of_user_transaction_graph_zoom_out(){
        DBMOracleMetricPage.validate_user_transaction_graph_zoomout();
    }


    @Test
    public void TC_34_Validate_functionality_of_user_transaction_graph_zoom_reset(){
        DBMOracleMetricPage.validate_user_transaction_graph_zoomReset();

    }


    @Test
    public void TC_35_Validate_drag_drop_of_user_transaction_graph_zoom(){
        DBMOracleMetricPage.validate_user_transaction_graph_zoomDragnDrop();
    }

    @Test
    public void TC_36_Validate_Title_of_no_of_redo_file_switch_graph() throws IOException {
        DBMOracleMetricPage.verify_the_Title_Of_no_of_redo_file_switch_Graph(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.oracleSheet, ""));
    }


    @Test
    public void TC_37_Validate_Xaxis_Title_of_no_of_redo_file_switch_graph() throws IOException {
        DBMOracleMetricPage.verify_the_Xaxis_Title_Of_no_of_redo_file_switch_Graph(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.oracleSheet, ""));
    }

    @Test
    public void TC_38_Validate_Yaxis_Title_of_no_of_redo_file_switch_graph() throws IOException {
        DBMOracleMetricPage.verify_the_Yaxis_Title_Of_no_of_redo_file_switch_Graph(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.oracleSheet, ""));
    }


    @Test
    public void TC_39_Validate_functionality_of_no_of_redo_file_switch_graph_zoom_in(){
        DBMOracleMetricPage.validate_no_of_redo_file_switch_graph_zoomin();
    }



    @Test
    public void TC_40_Validate_functionality_of_no_of_redo_file_switch_graph_zoom_out(){
        DBMOracleMetricPage.validate_no_of_redo_file_switch_graph_zoomOut();
    }


    @Test
    public void TC_41_Validate_functionality_of_no_of_redo_file_switch_graph_zoom_reset(){
        DBMOracleMetricPage.validate_no_of_redo_file_switch_graph_zoomReset();
    }


    @Test
    public void TC_42_Validate_drag_drop_of_no_of_redo_file_switch_graph_zoom(){
        DBMOracleMetricPage.validate_no_of_redo_file_switch_graph_zoomDragnDrop();
    }



    @Test
    public void TC_43_Validate_Title_of_No_of_redo_log_file_waits_graph() throws IOException {
        DBMOracleMetricPage.verify_the_Title_Of_No_of_redo_log_file_waits_Graph(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.oracleSheet, ""));
    }


    @Test
    public void TC_44_Validate_Xaxis_Title_of_No_of_redo_log_file_waits_graph() throws IOException {
        DBMOracleMetricPage.verify_the_XaxisTitle_Of_No_of_redo_log_file_waits_Graph(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.oracleSheet, ""));
    }

    @Test
    public void TC_45_Validate_Yaxis_Title_of_No_of_redo_log_file_waits_graph() throws IOException {
        DBMOracleMetricPage.verify_the_YaxisTitle_Of_No_of_redo_log_file_waits_Graph(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.oracleSheet, ""));
    }


    @Test
    public void TC_46_Validate_functionality_of_No_of_redo_log_file_waits_graph_zoom_in(){
        DBMOracleMetricPage.validate_no_of_redo_file_waits_graph_zoomIn();
    }



    @Test
    public void TC_47_Validate_functionality_of_No_of_redo_log_file_waits_graph_zoom_out(){
        DBMOracleMetricPage.validate_no_of_redo_file_waits_graph_zoomOut();

    }


    @Test
    public void TC_48_Validate_functionality_of_No_of_redo_log_file_waits_graph_zoom_reset(){
        DBMOracleMetricPage.validate_no_of_redo_file_waits_graph_zoomReset();
    }


    @Test
    public void TC_49_Validate_drag_drop_of_No_of_redo_log_file_waits_graph_zoom(){
        DBMOracleMetricPage.validate_no_of_redo_file_waits_graph_zoomDragnDrop();
    }


    @Test
    public void TC_50_Validate_Title_of_Hit_ratio_for_the_SGA_graph() throws IOException {
        DBMOracleMetricPage.verify_the_Title_Of_Hit_ratio_for_the_SGA_Graph(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.oracleSheet, ""));

    }


    @Test
    public void TC_51_Validate_Xaxis_Title_of_Hit_ratio_for_the_SGA_graph() throws IOException {
        DBMOracleMetricPage.verify_the_Xaxis_Title_Of_Hit_ratio_for_the_SGA_Graph(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.oracleSheet, ""));

    }

    @Test
    public void TC_52_Validate_Yaxis_Title_of_Hit_ratio_for_the_SGA_graph() throws IOException {
        DBMOracleMetricPage.verify_the_Yaxis_Title_Of_Hit_ratio_for_the_SGA_Graph(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.oracleSheet, ""));

    }


    @Test
    public void TC_53_Validate_functionality_of_Hit_ratio_for_the_SGA_graph_zoom_in(){
        DBMOracleMetricPage.validate_Hit_ratio_for_the_SGA_graph_zoomDragIn();
    }



    @Test
    public void TC_54_Validate_functionality_of_No_of_Hit_ratio_for_the_SGA_graph_zoom_out(){
        DBMOracleMetricPage.validate_Hit_ratio_for_the_SGA_graph_zoomOut();
    }


    @Test
    public void TC_55_Validate_functionality_of_No_of_Hit_ratio_for_the_SGA_graph_zoom_reset(){
        DBMOracleMetricPage.validate_Hit_ratio_for_the_SGA_graph_zoomReset();
    }


    @Test
    public void TC_56_Validate_drag_drop_of_No_of_Hit_ratio_for_the_SGA_graph_zoom(){
        DBMOracleMetricPage.validate_Hit_ratio_for_the_SGA_graph_zoomDragnDrop();
    }



    @Test
    public void TC_57_Validate_Title_of_SGA_Cacheable_memory_per_statement_graph() throws IOException {
        DBMOracleMetricPage.verify_the_Title_Of_SGA_Cacheable_memory_per_statement_Graph(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.oracleSheet, ""));
    }


    @Test
    public void TC_58_Validate_Xaxis_Title_of_SGA_Cacheable_memory_per_statement_graph() throws IOException {
        DBMOracleMetricPage.verify_the_Xaxis_Title_Of_SGA_Cacheable_memory_per_statement_Graph(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.oracleSheet, ""));
    }

    @Test
    public void TC_59_Validate_Yaxis_Title_of_SGA_Cacheable_memory_per_statement_graph() throws IOException {
        DBMOracleMetricPage.verify_the_Yaxis_Title_Of_SGA_Cacheable_memory_per_statement_Graph(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.oracleSheet, ""));

    }


    @Test
    public void TC_60_Validate_functionality_of_SGA_Cacheable_memory_per_statement_graph_zoom_in(){
        DBMOracleMetricPage.validate_SGA_Cacheable_memory_per_statement_graph_zoomIn();
    }



    @Test
    public void TC_61_Validate_functionality_of_SGA_Cacheable_memory_per_statement_graph_zoom_out(){
        DBMOracleMetricPage.validate_SGA_Cacheable_memory_per_statement_graph_zoomOut();
    }


    @Test
    public void TC_62_Validate_functionality_of_SGA_Cacheable_memory_per_statement_graph_zoom_reset(){
        DBMOracleMetricPage.validate_SGA_Cacheable_memory_per_statement_graph_zoomReset();
    }


    @Test
    public void TC_63_Validate_drag_drop_ofSGA_Cacheable_memory_per_statement_graph_zoom(){
        DBMOracleMetricPage.validate_SGA_Cacheable_memory_per_statement_graph_zoomDragnDrop();
    }



    @Test
    public void TC_64_Validate_Title_of_SGA_Cacheable_memory_per_user_graph() throws IOException {
        DBMOracleMetricPage.verify_the_Title_Of_SGA_Cacheable_memory_per_user_Graph(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.oracleSheet, ""));

    }


    @Test
    public void TC_65_Validate_Xaxis_Title_of_SGA_Cacheable_memory_per_user_graph() throws IOException {
        DBMOracleMetricPage.verify_the_Xaxis_Title_Of_SGA_Cacheable_memory_per_user_Graph(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.oracleSheet, ""));

    }

    @Test
    public void TC_66_Validate_Yaxis_Title_of_SGA_Cacheable_memory_per_user_graph() throws IOException {
        DBMOracleMetricPage.verify_the_Yaxis_Title_Of_SGA_Cacheable_memory_per_user_Graph(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.oracleSheet, ""));
    }


    @Test
    public void TC_67_Validate_functionality_of_SGA_Cacheable_memory_per_user_graph_zoom_in(){
        DBMOracleMetricPage.validate_SGA_Cacheable_memory_per_user_graph_zoomIn();
    }



    @Test
    public void TC_68_Validate_functionality_of_SGA_Cacheable_memory_per_user_graph_zoom_out(){
        DBMOracleMetricPage.validate_SGA_Cacheable_memory_per_user_graph_zoomOut();
    }


    @Test
    public void TC_69_Validate_functionality_of_SGA_Cacheable_memory_per_user_graph_zoom_reset(){
        DBMOracleMetricPage.validate_SGA_Cacheable_memory_per_user_graph_zoomReset();
    }


    @Test
    public void TC_70_Validate_drag_drop_ofSGA_Cacheable_memory_per_user_graph_zoom(){
        DBMOracleMetricPage.validate_SGA_Cacheable_memory_per_user_graph_zoomDragnDrop();
    }



    @Test
    public void TC_71_validate_Xaxis_labels_are_according_to_the_selected_timeline_5_mins(){
        commPage.selectTheTimeLineFromCalender(IPathConstant.fiveMinutesTimeRange);
        DBMOracleMetricPage.validateTheGivenTimeLine();


    }

    @Test
    public void TC_72_validate_Xaxis_labels_are_according_to_the_selected_timeline_15_mins(){
        commPage.selectTheTimeLineFromCalender(IPathConstant.fifteenMinutesTimeRange);
        DBMOracleMetricPage.validateTheGivenTimeLine();
    }


    @Test
    public void TC_73_validate_Xaxis_labels_are_according_to_the_selected_timeline_30_mins(){
        commPage.selectTheTimeLineFromCalender(IPathConstant.thirtyMinutesTimeRange);
        DBMOracleMetricPage.validateTheGivenTimeLine();
    }


    @Test
    public void TC_74_validate_Xaxis_labels_are_according_to_the_selected_timeline_60_mins(){
        commPage.selectTheTimeLineFromCalender(IPathConstant.sixtyMinutesTimeRange);
        DBMOracleMetricPage.validateTheGivenTimeLine();
    }



    @Test
    public void TC_75_validate_Xaxis_labels_are_according_to_the_selected_timeline_3_hours(){
        commPage.selectTheTimeLineFromCalender(IPathConstant.threeHoursTimeRange);
        DBMOracleMetricPage.validateTheGivenTimeLine();
    }



    @Test
    public void TC_76_validate_Xaxis_labels_are_according_to_the_selected_timeline_6_hours(){
        commPage.selectTheTimeLineFromCalender(IPathConstant.sixHoursTimeRange);
        DBMOracleMetricPage.validateTheGivenTimeLine();
    }


    @Test
    public void TC_77_validate_Xaxis_labels_are_according_to_the_selected_timeline_12_hours(){
        commPage.selectTheTimeLineFromCalender(IPathConstant.twelveHoursTimeRange);
        DBMOracleMetricPage.validateTheGivenTimeLine();
    }


    @Test
    public void TC_78_validate_Xaxis_labels_are_according_to_the_selected_timeline_1_day(){
        commPage.selectTheTimeLineFromCalender(IPathConstant.oneDayTimeRange);
        DBMOracleMetricPage.validateTheGivenTimeLine();
    }


    @Test
    public void TC_79_validate_Xaxis_labels_are_according_to_the_selected_timeline_1_week(){
        commPage.selectTheTimeLineFromCalender(IPathConstant.oneWeekTimeRange);
        DBMOracleMetricPage.validateTheGivenTimeLine();
    }



    @Test
    public void TC_80_validate_Xaxis_lables_are_according_to_the_selected_timeline_1_month(){
        commPage.selectTheTimeLineFromCalender(IPathConstant.oneMonthTimeRange);
        DBMOracleMetricPage.validateTheGivenTimeLine();
    }



    @Test
    public void TC_81_validate_Xaxis_lables_are_according_to_the_selected_custom_timeline() throws IOException {
        commPage.selectTheCustomeTimeLine(IPathConstant.customTimeRange, eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customDaysRange"));
        DBMOracleMetricPage.validateTheGivenTimeLine();
    }


    @Test
    public void TC_81_validate_Xaxis_lables_are_according_to_the_selected_custom_timeline_for_day() throws IOException {
        commPage.selectTheCustomeTimeLine(IPathConstant.customTimeRange, eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customDaysRange"));
        DBMOracleMetricPage.validateTheGivenTimeLine();
    }

    @Test
    public void TC_82_validate_Xaxis_lables_are_according_to_the_selected_custom_timeline_for_current_day() throws IOException {
        commPage.selectTheCustomeTimeLine(IPathConstant.customTimeRange, eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customDaysRange"));
        DBMOracleMetricPage.validateTheGivenTimeLine();
    }


    @Test
    public void TC_83_validate_Xaxis_lables_are_according_to_the_selected_custom_timeline_for_past_date() throws IOException {
        commPage.selectTheCustomeTimeLine(IPathConstant.customTimeRange, eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customDaysRange"));
        DBMOracleMetricPage.validateTheGivenTimeLine();
    }


    @Test
    public void TC_84_validate_Xaxis_lables_are_according_to_the_selected_custom_timeline_for_future_date() throws IOException {
        commPage.selectTheCustomeTimeLine(IPathConstant.customTimeRange, eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customDaysRange"));
        DBMOracleMetricPage.validateTheGivenTimeLine();
    }


}
