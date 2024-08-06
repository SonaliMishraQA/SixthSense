package DBMCapability.Postgres;


import org.testng.annotations.Test;

import org.testng.annotations.BeforeMethod;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;
import genericUtilities.ExcelUtility;
import genericUtilities.IPathConstant;
import objectRepository.CommonPage;
import objectRepository.HomePage;
import objectRepository.DBM.OracleQueryperformance;
import objectRepository.DBM.PostgresHardware;
import playWrightFactory.BaseClass;
import objectRepository.DBM.PostgresConnections;

public class PostgresConnectionTest extends BaseClass{
	
	HomePage homePage;
	ExcelUtility eutil;
	OracleQueryperformance qpPage;
	PostgresHardware hardwarePage;
	CommonPage comPage;
	PostgresConnections conPage;
	
	@BeforeMethod
	public void preRequest() throws EncryptedDocumentException, IOException, InterruptedException
	{
		eutil=new ExcelUtility();
		homePage=new HomePage(page);
		qpPage=new OracleQueryperformance(page);
		hardwarePage = new PostgresHardware(page);
		conPage = new PostgresConnections(page);
		Thread.sleep(5000);
		
		//Navigate to DBM capability
		commPage.navigateToDBM();
		
		commPage.selectTheTimeLineFromCalender(IPathConstant.oneMonthTimeRange);
		//select the DBM type
		hardwarePage.selectDBMtype(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.postgresGreeshma, "DBMtype"));
		
		//select the service 
		hardwarePage.selectDbservice(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.postgresGreeshma, "DBMservice"));
		
		// selecting the database option
		//hardwarePage.selectdatabse();
		
		//navigating to the Connection tab
		conPage.validatingNavigationToConnectionsTab();
		
	}
	@Test(groups = {"DBM","UI","Regression","Postgres"})
	public void TC_01_validateConnectionTabPresence() {
		conPage.validateConnectionsTabPresence();
	}
	
	@Test(groups = {"DBM","UI","Regression","Postgres"})
	public void TC_02_navigationToConnectionTab() {
		conPage.validatingNavigationToConnectionsTab();
	}
	
	@Test(groups = {"DBM","UI","Regression","Postgres"})
	public void TC_03_sessionDetailsTableTitle() throws EncryptedDocumentException, IOException {
		conPage.validateSessionDetailsTableTitle(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.postgresGreeshma, "Connections_TableHeader"));
	}
	
	@Test(groups = {"DBM","UI","Regression","Postgres"})
	public void TC_04_sessionDetailColumn1() throws EncryptedDocumentException, IOException {
		conPage.validateSessionDetailsTableHeadreDetailColumns(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.postgresGreeshma, "Connections_SessiontableColumn1"));
	}
	
	@Test(groups = {"DBM","UI","Regression","Postgres"})
	public void TC_05_sessionDetailColumn2() throws EncryptedDocumentException, IOException {
		conPage.validateSessionDetailsTableHeadreDetailColumns(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.postgresGreeshma, "Connections_SessiontableColumn2"));
	}
	@Test(groups = {"DBM","UI","Regression","Postgres"})
	public void TC_05_sessionDetailColumn3() throws EncryptedDocumentException, IOException {
		conPage.validateSessionDetailsTableHeadreDetailColumns(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.postgresGreeshma, "Connections_SessiontableColumn3"));
	}
	
	@Test(groups = {"DBM","UI","Regression","Postgres"})
	public void TC_06_sessionDetailsTableWhenNoData() throws EncryptedDocumentException, IOException{
		conPage.validateSessionDetailsNoDataText(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.postgresGreeshma, "Hardware_nodata_value"));
	}
	
	@Test(groups = {"DBM","UI","Regression","Postgres"})
	public void TC_07_numberOfConnectionTitle() throws EncryptedDocumentException, IOException{
		conPage.validateNumberOfConnectionsWidgetTitle(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.postgresGreeshma, "Connections_Graph1"));
	}
	
	@Test(groups = {"DBM","UI","Regression","Postgres"})
	public void TC_08_numberOfSessionsTitle() throws EncryptedDocumentException, IOException{
		conPage.validateNumberOfSessionsWidgetTitle(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.postgresGreeshma, "Connections_Graph2"));
	}
	
	@Test(groups = {"DBM","UI","Regression","Postgres"})
	public void TC_09_numberOfConnectionGraphZoomOut() {
		conPage.validateNumberOfConnectionsZoomOut();
	}
	
	@Test(groups = {"DBM","UI","Regression","Postgres"})
	public void TC_10_numberofConnectionGraphZoomIn() {
		conPage.validateNumberOfConnectionsZoomIn();
	}
	
	@Test(groups = {"DBM","UI","Regression","Postgres"})
	public void TC_11_numberOfConnectionGraphReset() {
		conPage.validateNumberOfConnectionsReset();
	}
	
	@Test(groups = {"DBM","UI","Regression","Postgres"})
	public void TC_12_numberOfConnectionGraphDragDrop() {
		conPage.validateNumberOfConnectionsDragaDrop();
	}
	
	@Test(groups = {"DBM","UI","Regression","Postgres"})
	public void TC_13_numberOfConnectionXaxisTitle() throws EncryptedDocumentException, IOException {
		conPage.validateNumberOfConnectionsXaxisTitle(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.postgresGreeshma, "Connections_GraphXaxis"));
	}
	
	@Test(groups = {"DBM","UI","Regression","Postgres"})
	public void TC_14_numberOfConnectionYaxisTitle() throws EncryptedDocumentException, IOException {
		conPage.validateNumberOfConnectionsYaxisTitle(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.postgresGreeshma, "Connections_ConnectionsGraphYais"));
	}
	
	@Test(groups = {"DBM","UI","Regression","Postgres"})
	public void TC_15_numberOfConnectionsXaxisToolTipOnHover() {
		conPage.validateNumberOfConnectionsToolTipTitle();
	}
	
	@Test(groups = {"DBM","UI","Regression","Postgres"})
	public void TC_16_numberOfConnectionsLegendsText() throws EncryptedDocumentException, IOException {
		conPage.validateNumberOfConnectionsWidgetLegendsList(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.postgresGreeshma, "Connections_No.ConnectionsGraphLegend"));
	}
	
	@Test(groups = {"DBM","UI","Regression","Postgres"})
	public void TC_17_numberOfConnectionsLegendsFunctionality () {
		conPage.validateNumberOfConnectionsWidgetLegendsFunctionality();
	}
	
	@Test(groups = {"DBM","UI","Regression","Postgres"})
	public void TC_18_numberOfSessionsZoomOut() {
		conPage.validateNumberOfSessionsZoomOut();
	}
	
	@Test(groups = {"DBM","UI","Regression","Postgres"})
	public void TC_19_numberOfSessionsZoomIn() {
		conPage.validateNumberOfSessionsZoomIn();
	}
	
	@Test(groups = {"DBM","UI","Regression","Postgres"})
	public void TC_20_numberOfSessionsZoomReset() {
		conPage.validateNumberOfSessionsReset();
	}
	
	@Test(groups = {"DBM","UI","Regression","Postgres"})
	public void TC_21_numberOfSessionsXaxisDragandDrop() {
		page.pause();
		conPage.validateNumberOfSessionsXaxisDragDrop();
	}
	
	@Test(groups = {"DBM","UI","Regression","Postgres"})
	public void TC_22_numberOfSessionsXaxisTitle() throws EncryptedDocumentException, IOException {
		conPage.validateNumberOfSessionsXaxisTitle(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.postgresGreeshma, "Connections_GraphXaxis"));
	}
	
	@Test(groups = {"DBM","UI","Regression","Postgres"})
	public void TC_23_numberOfSessionsYaxisTitle()throws EncryptedDocumentException, IOException {
		conPage.validateNumberOfSessionsYaxisTitle(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.postgresGreeshma, "Connections_SessionsGraphYaxis"));
	}
	
	@Test(groups = {"DBM","UI","Regression","Postgres"})
	public void TC_24_numberOfSessionsLegendsText() throws EncryptedDocumentException, IOException {
		conPage.validateNumberOfSessionsWidgetLegendsList(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.postgresGreeshma, "Connections_No.SessionsGraphLegend"));
	}
	
	@Test(groups = {"DBM","UI","Regression","Postgres"})
	public void TC_25_numberOfSessionsLegendsFunctionality() {
		conPage.validateNumberOfSessionsWidgetLegendsFunctionality();
	}
	
	@Test(groups = {"DBM","UI","Regression","Postgres"})
	public void TC_26_numberOfSessionsXaxisToolTipHover() {
		conPage.validateNumberOfSessionsToolTipTitle();
	}
	
	@Test(groups = {"DBM","UI","Regression","Postgres"})
	public void TC_27_validate_The_All_Widget_Data_By_Selecting_5Mins_TimeLine()
	{
		//select the time line from calendar
		commPage.selectTheTimeLineFromCalender(IPathConstant.fiveMinutesTimeRange);

		//Validate whether the widgets are displaying the proper time line or not
		conPage.validateTheGivenTimeLine();
		
		
	}
	@Test(groups = {"DBM","UI","Regression","Postgres"})
	public void TC_28_validate_The_All_Widgets_Data_By_Selecting_15Mins_TimeLine()
	{
		//select the time line from calendar
		commPage.selectTheTimeLineFromCalender(IPathConstant.fifteenMinutesTimeRange);

		//Validate whether the widgets are displaying the proper time line or not
		conPage.validateTheGivenTimeLine();
		
		
	}
	
	@Test(groups = {"DBM","UI","Regression","Postgres"})
	public void TC_29_validate_The_All_Widgets_Data_By_Selecting_30Mins_TimeLine()
	{
		//select the time line from calendar
		commPage.selectTheTimeLineFromCalender(IPathConstant.thirtyMinutesTimeRange);

		//Validate whether the widgets are displaying the proper time line or not
		conPage.validateTheGivenTimeLine();
	
		
	}
	
	@Test(groups = {"DBM","UI","Regression","Postgres"})
	public void TC_30_validate_The_All_Widgets_Data_By_Selecting_60Mins_TimeLine()
	{
		//select the time line from calendar
		commPage.selectTheTimeLineFromCalender(IPathConstant.sixtyMinutesTimeRange);

		//Validate whether the widgets are displaying the proper time line or not
		conPage.validateTheGivenTimeLine();
		
		
	}
	
	@Test(groups = {"DBM","UI","Regression","Postgres"})
	public void TC_31_validate_The_All_Widgets_Data_By_Selecting_3hours_TimeLine()
	{
		//select the time line from calendar
		commPage.selectTheTimeLineFromCalender(IPathConstant.threeHoursTimeRange);

		//Validate whether the widgets are displaying the proper time line or not
		conPage.validateTheGivenTimeLine();
		
		
	}
	
	@Test(groups = {"DBM","UI","Regression","Postgres"})
	public void TC_32_validate_The_All_Widgets_Data_By_Selecting_6hours_TimeLine()
	{
		//select the time line from calendar
		commPage.selectTheTimeLineFromCalender(IPathConstant.sixHoursTimeRange);

		//Validate whether the widgets are displaying the proper time line or not
		conPage.validateTheGivenTimeLine();
		
	}
	
	@Test(groups = {"DBM","UI","Regression","Postgres"})
	public void TC_33_validate_The_All_Widgets_Data_By_Selecting_12hours_TimeLine()
	{
		//select the time line from calendar
		commPage.selectTheTimeLineFromCalender(IPathConstant.twelveHoursTimeRange);

		//Validate whether the widgets are displaying the proper time line or not
		conPage.validateTheGivenTimeLine();
		
	}
	
	@Test(groups = {"DBM","UI","Regression","Postgres"})
	public void TC_34_validate_The_All_Widgets_Data_By_Selecting_1day_TimeLine()
	{
		//select the time line from calendar
		commPage.selectTheTimeLineFromCalender(IPathConstant.oneDayTimeRange);

		//Validate whether the widgets are displaying the proper time line or not
		conPage.validateTheGivenTimeLine();
		
	}
	
	@Test(groups = {"DBM","UI","Regression","Postgres"})
	public void TC_35_validate_The_All_Widgets_Data_By_Selecting_1week_TimeLine()
	{
		//select the time line from calendar
		commPage.selectTheTimeLineFromCalender(IPathConstant.oneWeekTimeRange);

		//Validate whether the widgets are displaying the proper time line or not
		conPage.validateTheGivenTimeLine();
		
	}
	
	@Test(groups = {"DBM","UI","Regression","Postgres"})
	public void TC_36_validate_The_All_Widgets_Data_By_Selecting_1month_TimeLine()
	{
		//select the time line from calendar
		commPage.selectTheTimeLineFromCalender(IPathConstant.oneMonthTimeRange);

		//Validate whether the widgets are displaying the proper time line or not
		conPage.validateTheGivenTimeLine();
		
	}
	
	@Test(groups = {"DBM","UI","Regression","Postgres"})
	public void TC_37_validate_The_All_Widgets_By_selecting_custom_Time_For_Minutes_Range() throws EncryptedDocumentException, IOException
	{
		//select the time line from calendar
		commPage.selectTheCustomeTimeLine(IPathConstant.customTimeRange, eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customMinutesRange") );
		
		//Validate whether the widgets are displaying the proper time line or not
		conPage.validateTheCustomTimeLine(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customMinutesRange"));
		
		
	}
	
	
	@Test(groups = {"DBM","UI","Regression","Postgres"})
	public void TC_38_validate_The_All_Widgets_By_selecting_custom_Time_For_Hours_Range() throws EncryptedDocumentException, IOException
	{
		//select the time line from calendar
		commPage.selectTheCustomeTimeLine(IPathConstant.customTimeRange, eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customHoursRange"));
		
		//Validate whether the widgets are displaying the proper time line or not
		conPage.validateTheCustomTimeLine(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customMinutesRange"));
				
		
		
	}
	
	@Test(groups = {"DBM","UI","Regression","Postgres"})
	public void TC_39_validate_The_All_Widgets_By_selecting_custom_Time_For_Days_Range() throws EncryptedDocumentException, IOException
	{
		//select the time line from calendar
		commPage.selectTheCustomeTimeLine(IPathConstant.customTimeRange, eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customDaysRange"));
		
		//Validate whether the widgets are displaying the proper time line or not
		conPage.validateTheCustomTimeLine(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customMinutesRange"));
				
		
		
	}
	
	@Test(groups = {"DBM","UI","Regression","Postgres"})
	public void TC_40_validate_The_All_Widgets_By_selecting_custom_Time_For_Future_date()
	{
		//select the future time line from calendar
		commPage.validateTheFutureTimeLine();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}