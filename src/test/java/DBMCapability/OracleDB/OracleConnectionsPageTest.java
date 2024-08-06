package DBMCapability.OracleDB;

import genericUtilities.ExcelUtility;
import genericUtilities.IPathConstant;
import objectRepository.CommonPage;
import objectRepository.DBM.DBMOracleConnectionPage;
import objectRepository.HomePage;
import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import playWrightFactory.BaseClass;

import java.io.IOException;

public class OracleConnectionsPageTest  extends BaseClass {
    HomePage homePage;
    ExcelUtility eutil;
    objectRepository.DBM.DBMOracleConnectionPage DBMOracleConnectionPage;
    CommonPage comPage;


    @BeforeMethod
    public void preRequest() throws EncryptedDocumentException, IOException {
        eutil = new ExcelUtility();
        homePage = new HomePage(page);
        DBMOracleConnectionPage = new DBMOracleConnectionPage(page);
        commPage.navigateToDBM();
        commPage.selectTheTimeLineFromCalender(" 1 month ");
        DBMOracleConnectionPage.selectDatabase(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.TypesOfDBs, "Oracle_DB"));
        DBMOracleConnectionPage.selectservice(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.TypesOfDBs, "Oracle_DB"));
        DBMOracleConnectionPage.selectDatabase1(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.TypesOfDBs, "Oracle_DB"));
        DBMOracleConnectionPage.NavigateToConnectionSection();
    }


    @Test
    public void TC_01_validate_title_of_Number_of_connections_graph() throws IOException {
     DBMOracleConnectionPage.verify_the_Title_Of_Number_of_connections_Graph(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.oracleSheet, "Connection_no_of_connection"));
    }


    @Test
    public void TC_02_validate_Xaxis_title_of_Number_of_connections_graph() throws IOException {
     DBMOracleConnectionPage.verify_the_Xaxis_Title_Of_Number_of_connections_Graph(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.oracleSheet, "Metrics_all_graphs_xaxis_tilte"));
    }

    @Test
    public void TC_03_validate_Yaxis_title_of_Number_of_connections_graph() throws IOException {
     DBMOracleConnectionPage.verify_the_Yaxis_Title_Of_Number_of_connections_Graph(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.oracleSheet, "connection_no_of_connection_y_axis_title"));
    }


    @Test
    public void TC_04_validate_functionality_of_Number_of_connections_graph_zoomIn_btn(){
     DBMOracleConnectionPage.validate_Number_of_connections_graph_zoomin();
    }


    @Test
    public void TC_05_validate_functionality_of_Number_of_connections_graph_zoomOut_btn(){
     DBMOracleConnectionPage.validate_Number_of_connections_graph_zoomOut();
    }


    @Test
    public void TC_06_validate_functionality_of_Number_of_connections_graph_zoomReset_btn(){
     DBMOracleConnectionPage.validate_Number_of_connections_graph_zoomReset();
    }


    @Test
    public void TC_07_validate_functionality_of_Number_of_connections_graph_zoomDragnDrop_btn(){
     DBMOracleConnectionPage.validate_Number_of_connections_graph_zoomDragnDrop();
    }


    @Test
    public void TC_08_validate_one_of_the_legend_name_in_Number_of_connections_graph() throws IOException {
        DBMOracleConnectionPage.validate_the_one_legend_name_in_Number_of_connections(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.oracleSheet, "Connection_no_of_connection_graph_legend1"));
    }

    @Test
    public void TC_09_validate_color_of_the_legend_and_graph_representation_Number_of_connections_graph(){
        DBMOracleConnectionPage.validateNumberofconnectionsgraphlegend();
    }


    @Test
    public void TC_10_validate_one_of_the_legend_name_in_Number_of_connections_graph() throws IOException {
        DBMOracleConnectionPage.validate_the_one_legend_name_in_Number_of_connections(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.oracleSheet, "Connection_no_of_connection_graph_legend2"));
    }

    @Test
    public void TC_11_validate_color_of_the_legend_and_graph_representation_Number_of_connections_graph(){
        DBMOracleConnectionPage.validateNumberofconnectionsgraphlegend();
      //* Select the legend "meter_oracle_inactive_connections" in Number of connections graph and validate the color of the graph representation
    }



    @Test
    public void TC_12_validate_title_of_Number_of_sessions_graph() throws IOException {
        DBMOracleConnectionPage.verify_the_Title_Of_Number_of_sessions_Graph(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.oracleSheet, "connection_no_of_sessions"));
    }

    @Test
    public void TC_13_validate_Xaxis_title_of_Number_of_sessions_graph() throws IOException {
        DBMOracleConnectionPage.verify_the_Xaxis_Title_Of_Number_of_sessions_Graph(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.oracleSheet, "Metrics_all_graphs_xaxis_tilte"));
    }

    @Test
    public void TC_14_validate_Yaxis_title_of_Number_of_sessions_graph() throws IOException {
        DBMOracleConnectionPage.verify_the_Yaxis_Title_Of_Number_of_sessions_Graph(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.oracleSheet, "connection_no_session_graph_yaxis"));
    }


    @Test
    public void TC_15_validate_functionality_of_Number_of_sessions_graph_zoomIn_btn(){
        DBMOracleConnectionPage.validate_Number_of_sessions_graph_zoomin();
    }


    @Test
    public void TC_16_validate_functionality_of_Number_of_sessions_graph_zoomOut_btn(){
        DBMOracleConnectionPage.validate_Number_of_sessions_graph_zoomOut();
    }




    @Test
    public void TC_17_validate_functionality_of_Number_of_sessions_graph_zoomReset_btn(){
        DBMOracleConnectionPage.validate_Number_of_sessions_graph_zoomReset();
    }


    @Test
    public void TC_18_validate_functionality_of_Number_of_sessions_graph_zoomDragnDrop_btn(){
        DBMOracleConnectionPage.validate_Number_of_sessions_graph_zoomDragnDrop();
    }



    @Test
    public void TC_19_validate_one_of_the_legend_name_in_Number_of_session_graph() throws IOException {
        DBMOracleConnectionPage.validateNumberOfSessionsWidgetLegendsList(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.oracleSheet, "Connection_no_of_sessions_graph_legend1"));
    }



    @Test
    public void TC_20_validate_one_of_the_legend_name_in_Number_of_session_graph() throws IOException {
        DBMOracleConnectionPage.validateNumberOfSessionsWidgetLegendsList(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.oracleSheet, "Connection_no_of_sessions_graph_legend1"));

    }

    @Test
    public void TC_21_validate_one_of_the_legend_name_in_Number_of_session_graph() throws IOException {
        DBMOracleConnectionPage.validateNumberOfSessionsWidgetLegendsList(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.oracleSheet, "Connection_no_of_sessions_graph_legend2"));
    }

    @Test
    public void TC_22_validate_color_of_the_legend_and_graph_representaion_in_Number_of_session_graph(){
        DBMOracleConnectionPage.validateNumberofconnectionsgraphlegend();
    }

    @Test
    public void TC_23_validate_title_of_session_details_section() throws IOException {
        DBMOracleConnectionPage.verify_the_Title_Of_Number_of_session_details_section(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.oracleSheet, ""));
    }

    @Test
    public void TC_24_validate_the_first_column_name_of_Session_details_table() throws IOException {
        DBMOracleConnectionPage.verify_the_first_column_Of_session_details_table(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.oracleSheet, ""));
    }


    @Test
    public void TC_25_validate_the_second_column_name_of_Session_details_table() throws IOException {
        DBMOracleConnectionPage.verify_the_second_column_Of_session_details_table(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.oracleSheet, ""));
    }

    @Test
    public void TC_26_validate_the_third_column_name_of_Session_details_table() throws IOException {
        DBMOracleConnectionPage.verify_the_third_column_Of_session_details_table(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.oracleSheet, ""));
    }

    @Test
    public void TC_27_validate_Xaxis_labels_are_according_to_the_selected_timeline_5_mins(){
        commPage.selectTheTimeLineFromCalender(IPathConstant.fiveMinutesTimeRange);
        DBMOracleConnectionPage.validateTheGivenTimeLine();
    }


    @Test
    public void TC_28_validate_Xaxis_labels_are_according_to_the_selected_timeline_15_mins(){
        commPage.selectTheTimeLineFromCalender(IPathConstant.fifteenMinutesTimeRange);
        DBMOracleConnectionPage.validateTheGivenTimeLine();
    }

    @Test
    public void TC_29_validate_Xaxis_labels_are_according_to_the_selected_timeline_30_mins(){
        commPage.selectTheTimeLineFromCalender(IPathConstant.thirtyMinutesTimeRange);
        DBMOracleConnectionPage.validateTheGivenTimeLine();
    }

    @Test
    public void TC_30_validate_Xaxis_labels_are_according_to_the_selected_timeline_60_mins(){
        commPage.selectTheTimeLineFromCalender(IPathConstant.sixtyMinutesTimeRange);
        DBMOracleConnectionPage.validateTheGivenTimeLine();
    }




    @Test
    public void TC_31_validate_Xaxis_labels_are_according_to_the_selected_timeline_3_hours(){
        commPage.selectTheTimeLineFromCalender(IPathConstant.threeHoursTimeRange);
        DBMOracleConnectionPage.validateTheGivenTimeLine();
    }

    @Test
    public void TC_32_validate_Xaxis_labels_are_according_to_the_selected_timeline_6_hours(){
        commPage.selectTheTimeLineFromCalender(IPathConstant.sixHoursTimeRange);
        DBMOracleConnectionPage.validateTheGivenTimeLine();
    }


    @Test
    public void TC_33_validate_Xaxis_labels_are_according_to_the_selected_timeline_12_hours(){
        commPage.selectTheTimeLineFromCalender(IPathConstant.twelveHoursTimeRange);
        DBMOracleConnectionPage.validateTheGivenTimeLine();
    }

    @Test
    public void TC_34_validate_Xaxis_labels_are_according_to_the_selected_timeline_one_day(){
        commPage.selectTheTimeLineFromCalender(IPathConstant.oneDayTimeRange);
        DBMOracleConnectionPage.validateTheGivenTimeLine();
    }


    @Test
    public void TC_35_validate_Xaxis_labels_are_according_to_the_selected_timeline_one_week(){
        commPage.selectTheTimeLineFromCalender(IPathConstant.oneWeekTimeRange);
        DBMOracleConnectionPage.validateTheGivenTimeLine();
    }


    @Test
    public void TC_36_validate_Xaxis_labels_are_according_to_the_selected_timeline_one_month(){
        commPage.selectTheTimeLineFromCalender(IPathConstant.oneMonthTimeRange);
        DBMOracleConnectionPage.validateTheGivenTimeLine();
    }



    @Test
    public void TC_37_validate_Xaxis_labels_are_according_to_the_selected_custom_timeline() throws IOException {
        commPage.selectTheCustomeTimeLine(IPathConstant.customTimeRange, eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customHoursRange"));
        DBMOracleConnectionPage.validateTheCustomTimeLine(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customMinutesRange"));
    }

    @Test
    public void TC_38_validate_Xaxis_labels_are_according_to_the_selected_custom_timeline_current_day() throws IOException {
        commPage.selectTheCustomeTimeLine(IPathConstant.customTimeRange, eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customDaysRange"));
        DBMOracleConnectionPage.validateTheCustomTimeLine(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customMinutesRange"));
    }


    @Test
    public void TC_39_validate_Xaxis_labels_are_according_to_the_selected_custom_timeline_past_date() throws IOException {
        commPage.selectTheCustomeTimeLine(IPathConstant.customTimeRange, eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customDaysRange"));
        DBMOracleConnectionPage.validateTheCustomTimeLine(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customMinutesRange"));
    }

    @Test
    public void TC_40_validate_Xaxis_labels_are_according_to_the_selected_custom_timeline_future_date() throws IOException {
        commPage.selectTheCustomeTimeLine(IPathConstant.customTimeRange, eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customDaysRange"));
        DBMOracleConnectionPage.validateTheCustomTimeLine(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customMinutesRange"));
    }

}

