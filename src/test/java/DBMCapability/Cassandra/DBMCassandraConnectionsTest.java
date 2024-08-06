package DBMCapability.Cassandra;

import genericUtilities.ExcelUtility;
import genericUtilities.IPathConstant;
import objectRepository.CommonPage;
import objectRepository.DBM.DBMCassandraConnectionPage;
import objectRepository.HomePage;
import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import playWrightFactory.BaseClass;

import java.io.IOException;

public class DBMCassandraConnectionsTest extends BaseClass {
    HomePage homePage;
    ExcelUtility eutil;
    objectRepository.DBM.DBMCassandraConnectionPage DBMCassandrConnectPage;
    CommonPage comPage;


    @BeforeMethod
    public void preRequest() throws EncryptedDocumentException, IOException {
        eutil = new ExcelUtility();
        homePage = new HomePage(page);
        DBMCassandrConnectPage = new DBMCassandraConnectionPage(page);
        commPage.navigateToDBM();
        commPage.selectTheTimeLineFromCalender(IPathConstant.oneMonthTimeRange);
        DBMCassandrConnectPage.selectDatabase(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.TypesOfDBs, "Cassandra_DB"));
        DBMCassandrConnectPage.selectservice("Cassandra_patch_413");
        DBMCassandrConnectPage.NavigateToConnectionSection();
    }

    @Test (groups = {"DBM","UI","Regression","Cassandra","Sanity"})
    public void  TC_01_validate_the_title_of_Connections_n_Sessions_graph() throws IOException {
        DBMCassandrConnectPage.validateTitleOfConnectionsnSessionsGraph(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "connection_connection_&_sessions"));
    }


    @Test (groups = {"DBM","UI","Regression","Cassandra","Sanity"})
    public void  TC_02_validate_the_Xaxis_title_of_Connections_n_Sessions_graph() throws IOException {
        DBMCassandrConnectPage.validateXaxisTitleOfConnectionsnSessionsGraph(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "all_connection_graph_X_axix_title"));
    }


    @Test (groups = {"DBM","UI","Regression","Cassandra","Sanity"})
    public void  TC_03_validate_the_Yaxis_title_of_Connections_n_Sessions_graph() throws IOException {
        DBMCassandrConnectPage.validateYaxisTitleOfConnectionsnSessionsGraph(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "all_connection_graph_Y_axix_title"));
    }

    @Test (groups = {"DBM","UI","Regression","Cassandra","Sanity"})
    public void TC_04_validate_functionality_of_Connections_n_Sessions_graph_Zoom_In_button(){
        DBMCassandrConnectPage.validateFunctionalityOfConnectionsnSessionsGraphZoomIn();
    }


    @Test (groups = {"DBM","UI","Regression","Cassandra","Sanity"})
    public void TC_05_validate_functionality_of_Connections_n_Sessions_graph_Zoom_Out_button(){
        DBMCassandrConnectPage.validateFunctionalityOfConnectionsnSessionsGraphZoomOut();
    }


    @Test (groups = {"DBM","UI","Regression","Cassandra","Sanity"})
    public void TC_06_validate_functionality_of_Connections_n_Sessions_graph_Zoom_Reset_button(){
        DBMCassandrConnectPage.validateFunctionalityOfConnectionsnSessionsGraphZoomReset();
    }


    @Test (groups = {"DBM","UI","Regression","Cassandra","Sanity"})
    public void TC_07_validate_drag_n_drop_functionality_of_Connections_n_Sessions_graph_to_Zoom_In(){
        DBMCassandrConnectPage.validateDragnDropOfConnectionsnSessionsGraphZoomIn();
    }


    @Test (groups = {"DBM","UI","Regression","Cassandra","Sanity"})
    public void TC_08_validate_one_of_the_legend_name_in_Connections_n_Sessions_graph_tobe_meter_cassandra_active_connections() throws IOException {
        DBMCassandrConnectPage.validate_the_one_legend_name_in_connections_and_sessions(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "connection_connection_&_sessions_legend1"));
    }


    @Test (groups = {"DBM","UI","Regression","Cassandra","Sanity"})
    public void TC_09_validate_the_functionality_of_connections_n_sessions_graph(){
        DBMCassandrConnectPage.validateNumberofconnectionsgraphlegend();
    }


    @Test (groups = {"DBM","UI","Regression","Cassandra","Sanity"})
    public void TC_10_validate_one_of_the_legend_name_in_Connections_n_Sessions_graph_to_be_meter_cassandra_idle_connections() throws IOException {
        DBMCassandrConnectPage.validate_the_one_legend_name_in_connections_and_sessions(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "connection_connection_&_sessions_legend2"));
    }




    @Test (groups = {"DBM","UI","Regression","Cassandra","Sanity"})
    public void TC_11_validate_one_of_the_legend_name_in_Connections_n_Sessions_graph_to_be_meter_cassandra_sessions() throws IOException {
        DBMCassandrConnectPage.validate_the_one_legend_name_in_connections_and_sessions(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "connection_connection_&_sessions_legend3"));
    }

    @Test (groups = {"DBM","UI","Regression","Cassandra","Sanity"})
    public void TC_12_validate_the_color_of_the_legend_name_in_Connections_n_Sessions_graph_for_meter_cassandra_sessions() {
        DBMCassandrConnectPage.validateNumberofconnectionsgraphlegend();
    }

    @Test (groups = {"DBM","UI","Regression","Cassandra","Sanity"})
    public void TC_13_validate_one_of_the_legend_name_in_Connections_n_Sessions_graph_to_be_meter_cassandra_repair_session_count() throws IOException {
        DBMCassandrConnectPage.validate_the_one_legend_name_in_connections_and_sessions(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "connection_connection_&_sessions_legend4"));
    }



    @Test (groups = {"DBM","UI","Regression","Cassandra","Sanity"})
    public void  TC_14_validate_the_title_of_heartbeat_graph() throws IOException {
        DBMCassandrConnectPage.validateTitleOfhearbeatGraph(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "Heartbeat"));
    }

    @Test (groups = {"DBM","UI","Regression","Cassandra","Sanity"})
    public void  TC_15_validate_the_Xaxis_title_of_heartbeat_graph() throws IOException {
        DBMCassandrConnectPage.validateTitleOfhearbeatGraph(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "all_connection_graph_X_axix_title"));
    }

    @Test (groups = {"DBM","UI","Regression","Cassandra","Sanity"})
    public void  TC_18_validate_the_Yaxis_title_of_heartbeat_graph() throws IOException {
        DBMCassandrConnectPage.validateTitleOfhearbeatGraph(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "all_connection_graph_Y_axix_title"));

    }


    @Test (groups = {"DBM","UI","Regression","Cassandra","Sanity"})
    public void TC_19_validate_functionality_of_Heartbeat_graph_Zoom_In_button(){
        DBMCassandrConnectPage.validateFunctionalityOfHeartGraphZoomIn();
    }

    @Test (groups = {"DBM","UI","Regression","Cassandra","Sanity"})
    public void TC_20_validate_functionality_of_Heartbeat_graph_Zoom_Out_button(){
        DBMCassandrConnectPage.validateFunctionalityOfHeartGraphZoomOut();
    }


    @Test (groups = {"DBM","UI","Regression","Cassandra","Sanity"})
    public void TC_21_validate_functionality_of_Heartbeat_graph_Zoom_Reset_button(){
        DBMCassandrConnectPage.validateFunctionalityOfHeartGraphZoomReset();
    }

    @Test (groups = {"DBM","UI","Regression","Cassandra","Sanity"})
    public void TC_22_validate_Drag_n_Drop_functionality_of_Heartbeat_graph_Zoom_In(){
        DBMCassandrConnectPage.validateDragnDropFunctionalityOfHeartGraphZoomIn();
    }


    @Test (groups = {"DBM","UI","Regression","Cassandra","Sanity"})
    public void TC_23_validate_the_title_of_session_details_section() throws IOException {
        DBMCassandrConnectPage.validateTitleOfSessionDetailsSection(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "connection_session_details"));
    }


    @Test (groups = {"DBM","UI","Regression","Cassandra","Sanity"})
    public void TC_24_validate_the_first_column_of_session_details_table() throws IOException {
        DBMCassandrConnectPage.validateFirstColumnTitleOfSessionDetails(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "connection_username"));
    }

    @Test (groups = {"DBM","UI","Regression","Cassandra","Sanity"})
    public void TC_25_validate_the_second_column_of_session_details_table() throws IOException {
        DBMCassandrConnectPage.validateSecondColumnTitleOfSessionDetails(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "queries_executed"));
    }


    @Test (groups = {"DBM","UI","Regression","Cassandra","Sanity"})
    public void TC_26_validate_the_third_column_of_session_details_table() throws IOException {
        DBMCassandrConnectPage.validateThirdColumnTitleOfSessionDetails(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "timestamp"));
    }


    @Test (groups = {"DBM","UI","Regression","Cassandra","Sanity"})
    public void TC_27_validate_Xaxis_labels_are_according_to_the_selected_timeline_5_mins(){
        commPage.selectTheTimeLineFromCalender(IPathConstant.fiveMinutesTimeRange);
        DBMCassandrConnectPage.validateTheGivenTimeLine();
    }

    @Test (groups = {"DBM","UI","Regression","Cassandra","Sanity"})
    public void TC_28_validate_Xaxis_labels_are_according_to_the_selected_timeline_15_mins() throws IOException {
        commPage.selectTheTimeLineFromCalender(IPathConstant.fifteenMinutesTimeRange);
        DBMCassandrConnectPage.validateTheGivenTimeLine();
    }

    @Test (groups = {"DBM","UI","Regression","Cassandra","Sanity"})
    public void TC_29_validate_Xaxis_labels_are_according_to_the_selected_timeline_30_mins() throws IOException {
        commPage.selectTheTimeLineFromCalender(IPathConstant.thirtyMinutesTimeRange);
        DBMCassandrConnectPage.validateTheGivenTimeLine();
    }

    @Test (groups = {"DBM","UI","Regression","Cassandra","Sanity"})
    public void TC_30_validate_Xaxis_labels_are_according_to_the_selected_timeline_60_mins() throws IOException {
        commPage.selectTheTimeLineFromCalender(IPathConstant.sixtyMinutesTimeRange);
        DBMCassandrConnectPage.validateTheGivenTimeLine();
    }

    @Test (groups = {"DBM","UI","Regression","Cassandra","Sanity"})
    public void TC_31_validate_Xaxis_labels_are_according_to_the_selected_timeline_3_hours(){
        commPage.selectTheTimeLineFromCalender(IPathConstant.threeHoursTimeRange);
        DBMCassandrConnectPage.validateTheGivenTimeLine();
    }

    @Test (groups = {"DBM","UI","Regression","Cassandra","Sanity"})
    public void TC_32_validate_Xaxis_labels_are_according_to_the_selected_timeline_6_hours(){
        commPage.selectTheTimeLineFromCalender(IPathConstant.sixHoursTimeRange);
        DBMCassandrConnectPage.validateTheGivenTimeLine();
    }

    @Test (groups = {"DBM","UI","Regression","Cassandra","Sanity"})
    public void TC_33_validate_Xaxis_labels_are_according_to_the_selected_timeline_12_hours(){
        commPage.selectTheTimeLineFromCalender(IPathConstant.twelveHoursTimeRange);
        DBMCassandrConnectPage.validateTheGivenTimeLine();
    }

    @Test (groups = {"DBM","UI","Regression","Cassandra","Sanity"})
    public void TC_34_validate_Xaxis_labels_are_according_to_the_selected_timeline_1_day(){
        commPage.selectTheTimeLineFromCalender(IPathConstant.oneDayTimeRange);
        DBMCassandrConnectPage.validateTheGivenTimeLine();
    }

    @Test (groups = {"DBM","UI","Regression","Cassandra","Sanity"})
    public void TC_35_validate_Xaxis_labels_are_according_to_the_selected_timeline_1_week(){
        commPage.selectTheTimeLineFromCalender(IPathConstant.oneWeekTimeRange);
        DBMCassandrConnectPage.validateTheGivenTimeLine();
    }

    @Test (groups = {"DBM","UI","Regression","Cassandra","Sanity"})
    public void TC_36_validate_Xaxis_labels_are_according_to_the_selected_timeline_1_month(){
        commPage.selectTheTimeLineFromCalender(IPathConstant.oneMonthTimeRange);
        DBMCassandrConnectPage.validateTheGivenTimeLine();
    }


    @Test (groups = {"DBM","UI","Regression","Cassandra","Sanity"})
    public void TC_37_validate_Xaxis_labels_are_according_to_the_selected_custom_timeline() throws IOException {
        commPage.selectTheCustomeTimeLine(IPathConstant.customTimeRange, eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customHoursRange"));
        DBMCassandrConnectPage.validateTheCustomTimeLine(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customHoursRange"));
    }

    @Test (groups = {"DBM","UI","Regression","Cassandra","Sanity"})
    public void TC_38_validate_Xaxis_labels_are_according_to_the_selected_custom_timeline_current_day() throws IOException {
        commPage.selectTheCustomeTimeLine(IPathConstant.customTimeRange, eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customDaysRange"));
        DBMCassandrConnectPage.validateTheCustomTimeLine(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customDaysRange"));
    }

    @Test (groups = {"DBM","UI","Regression","Cassandra","Sanity"})
    public void TC_39_validate_Xaxis_labels_are_according_to_the_selected_custom_timeline_past_day() throws IOException {
        commPage.selectTheCustomeTimeLine(IPathConstant.customTimeRange, eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customDaysRange"));
        DBMCassandrConnectPage.validateTheCustomTimeLine(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customDaysRange"));
    }

    @Test (groups = {"DBM","UI","Regression","Cassandra","Sanity"})
    public void TC_40_validate_Xaxis_labels_are_according_to_the_selected_custom_timeline_future_day() {
        commPage.validateTheFutureTimeLine();
    }

}
