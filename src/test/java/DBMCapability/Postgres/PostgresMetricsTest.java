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
import objectRepository.DBM.PostgresMetrics;

public class PostgresMetricsTest extends BaseClass{
	
	HomePage homePage;
	ExcelUtility eutil;
	OracleQueryperformance qpPage;
	PostgresHardware hardwarePage;
	CommonPage comPage;
	PostgresMetrics metPage;

	
	@BeforeMethod
	public void preRequest() throws EncryptedDocumentException, IOException, InterruptedException
	{
		eutil=new ExcelUtility();
		homePage=new HomePage(page);
		qpPage=new OracleQueryperformance(page);
		hardwarePage = new PostgresHardware(page);
		metPage = new PostgresMetrics(page);
		Thread.sleep(5000);
		
		//Navigate to DBM capability
		commPage.navigateToDBM();
		
		//select the DBM type
		hardwarePage.selectDBMtype(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.postgresGreeshma, "DBMtype"));
		
		//select the service 
		hardwarePage.selectDbservice(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.postgresGreeshma, "DBMService"));
		
		// selecting the database option
		//metPage.selectdatabse();
		
		//navigating to the metrics tab
		metPage.validatingNavigationToMetricsTab();
		
	}
	
	@Test(groups = {"DBM","UI","Regression","Postgres"})
	public void TC_01_validateMetricsTabPresence() {
		metPage.validateMetricsTabPresence();
	}
	
	@Test(groups = {"DBM","UI","Regression","Postgres"})
	public void TC_02_navigationToMetricsTab() {
		metPage.validatingNavigationToMetricsTab();
	}
	
	@Test(groups = {"DBM","UI","Regression","Postgres"})
	public void TC_03_bulkOperationsWidgetTitle() throws EncryptedDocumentException, IOException {
		metPage.validateBulkOperationsWidgetTitle(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.postgresGreeshma, "Metrics_Graph1"));
	}
	
	@Test(groups = {"DBM","UI","Regression","Postgres"})
	public void TC_04_bulkOperationsGraphZoomOut() {
		metPage.validateBulkOperationsZoomOut();
	}
	
	@Test(groups = {"DBM","UI","Regression","Postgres"})
	public void TC_05_bulkOperationsGraphZoomIn() {
		metPage.validateBulkOperationsZoomIn();
	}
	
	@Test(groups = {"DBM","UI","Regression","Postgres"})
	public void TC_06_bulkOperationsGraphReset() {
		metPage.validateBulkOperationsReset();
	}
	
	@Test(groups = {"DBM","UI","Regression","Postgres"})
	public void TC_07_bulkOperationsGraphDragDrop() throws InterruptedException {
		Thread.sleep(5000);
		metPage.validateBulkOperationsXaxisDragDrop();
	}
	
	@Test(groups = {"DBM","UI","Regression","Postgres"})
	public void TC_08_bulkOperationsXaxisTitle() throws EncryptedDocumentException, IOException {
		metPage.validateBulkOperationsXaxisTitle(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.postgresGreeshma, "Metrics_GraphXaxis"));
	}
	
	@Test(groups = {"DBM","UI","Regression","Postgres"})
	public void TC_09_bulkOperationsYaxisTitle() throws EncryptedDocumentException, IOException {
		metPage.validateBulkOperationsYaxisTitle(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.postgresGreeshma, "Metrics_GraphYaxis"));
	}
	
	@Test(groups = {"DBM","UI","Regression","Postgres"})
	public void TC_10_BulkOperationsXaxisToolTipOnHover() {
		metPage.validateBulkOperationsXaxisTitleToolTip();
	}
	
	@Test(groups = {"DBM","UI","Regression","Postgres"})
	public void TC_11_BulkOperationsLegendsText() throws EncryptedDocumentException, IOException {
		metPage.validateBulkOperationsWidgetLegendsList(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.postgresGreeshma, "Metrics_BulkGraphLegend"));
	}
	
	@Test(groups = {"DBM","UI","Regression","Postgres"})
	public void TC_12_BulkOperationsLegendsFunctionality () {
		metPage.validateBulkOperationsWidgetLegendsFunctionality();
	}
	
	@Test(groups = {"DBM","UI","Regression","Postgres"})
	public void TC_13_confisOperationsWidgetTitle() throws EncryptedDocumentException, IOException {
		metPage.validateConfisOperationsWidgetTitle(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.postgresGreeshma, "Metrics_Graph2"));
	}
	
	@Test(groups = {"DBM","UI","Regression","Postgres"})
	public void TC_14_confisOperationsGraphZoomOut() {
		metPage.validateConfisOperationsZoomOut();
	}
	
	@Test(groups = {"DBM","UI","Regression","Postgres"})
	public void TC_15_confisOperationsGraphZoomIn() {
		metPage.validateConfisOperationsZoomIn();
	}
	
	@Test(groups = {"DBM","UI","Regression","Postgres"})
	public void TC_16_confisOperationsGraphReset() {
		metPage.validateConfisOperationsReset();
	}
	
	@Test(groups = {"DBM","UI","Regression","Postgres"})
	public void TC_17_confisOperationsGraphDragDrop() {
		metPage.validateConfisOperationsXaxisDragDrop();
	}
	
	@Test(groups = {"DBM","UI","Regression","Postgres"})
	public void TC_18_confisOperationsXaxisTitle() throws EncryptedDocumentException, IOException {
		metPage.validateConfisOperationsXaxisTitle(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.postgresGreeshma, "Metrics_GraphXaxis"));
	}
	
	@Test(groups = {"DBM","UI","Regression","Postgres"})
	public void TC_19_confisOperationsYaxisTitle() throws EncryptedDocumentException, IOException {
		metPage.validateConfisOperationsYaxisTitle(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.postgresGreeshma, "Metrics_GraphYaxis"));
	}
	
	@Test(groups = {"DBM","UI","Regression","Postgres"})
	public void TC_20_ConfisOperationsXaxisToolTipOnHover() {
		metPage.validateConfisOperationsToolTipTitleHover();
	}
	
	@Test(groups = {"DBM","UI","Regression","Postgres"})
	public void TC_21_ConfisOperationsLegendsText() throws EncryptedDocumentException, IOException {
		metPage.validateConfisOperationsWidgetLegendsList(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.postgresGreeshma, "Metrics_ConfisGraphLegends"));
	}
	
	@Test(groups = {"DBM","UI","Regression","Postgres"})
	public void TC_22_ConfisOperationsLegendsFunctionality () {
		metPage.validateConfisOperationsWidgetActiveLegendsFunctionality();
	}
	
	
	@Test(groups = {"DBM","UI","Regression","Postgres"})
	public void TC_23_tupOperationsWidgetTitle() throws EncryptedDocumentException, IOException {
		metPage.validateTupOperationsWidgetTitle(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.postgresGreeshma, "Metrics_Graph3"));
	}
	
	@Test(groups = {"DBM","UI","Regression","Postgres"})
	public void TC_24_tupOperationsGraphZoomOut() {
		metPage.validateTupOperationsZoomOut();
	}
	
	@Test(groups = {"DBM","UI","Regression","Postgres"})
	public void TC_25_tupOperationsGraphZoomIn() {
		metPage.validateTupOperationsZoomIn();
	}
	
	@Test(groups = {"DBM","UI","Regression","Postgres"})
	public void TC_26_tupOperationsGraphReset() {
		metPage.validateTupOperationsReset();
	}
	
	@Test(groups = {"DBM","UI","Regression","Postgres"})
	public void TC_27_tupOperationsGraphDragDrop() {
		metPage.validateTupOperationsXaxisDragDrop();
	}
	
	@Test(groups = {"DBM","UI","Regression","Postgres"})
	public void TC_28_tupOperationsXaxisTitle() throws EncryptedDocumentException, IOException {
		metPage.validateTupOperationsXaxisTitle(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.postgresGreeshma, "Metrics_GraphXaxis"));
	}
	
	@Test(groups = {"DBM","UI","Regression","Postgres"})
	public void TC_29_tupOperationsYaxisTitle() throws EncryptedDocumentException, IOException {
		metPage.validateTupOperationsYaxisTitle(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.postgresGreeshma, "Metrics_GraphYaxis"));
	}
	
	@Test(groups = {"DBM","UI","Regression","Postgres"})
	public void TC_30_tupOperationsXaxisToolTipOnHover() {
		metPage.validateTupOperationsToolTipTitleHover();
	}
	
	@Test(groups = {"DBM","UI","Regression","Postgres"})
	public void TC_31_tupOperationsLegendsText() throws EncryptedDocumentException, IOException {
		metPage.validateTupOperationsWidgetLegendsList(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.postgresGreeshma, "Metrics_TupGraphLegend"));
	}
	
	@Test(groups = {"DBM","UI","Regression","Postgres"})
	public void TC_32_tupOperationsLegendsFunctionality () {
		metPage.validateTupOperationsWidgetActiveLegendsListFuncationality();
	}
	
	@Test(groups = {"DBM","UI","Regression","Postgres"})
	public void TC_33_xactOperationsWidgetTitle() throws EncryptedDocumentException, IOException {
		metPage.validateXactOperationsWidgetTitle(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.postgresGreeshma, "Metrics_Graph4"));
	}
	
	@Test(groups = {"DBM","UI","Regression","Postgres"})
	public void TC_34_xactOperationsGraphZoomOut() {
		metPage.validateXactOperationsZoomOut();
	}
	
	@Test(groups = {"DBM","UI","Regression","Postgres"})
	public void TC_35_xactOperationsGraphZoomIn() {
		metPage.validateXactOperationsZoomIn();
	}
	
	@Test(groups = {"DBM","UI","Regression","Postgres"})
	public void TC_36_xactOperationsGraphReset() {
		metPage.validateXactOperationsReset();
	}
	
	@Test(groups = {"DBM","UI","Regression","Postgres"})
	public void TC_37_xactOperationsGraphDragDrop() {
		metPage.validateXactOperationsXaxisDragDrop();
	}
	
	@Test(groups = {"DBM","UI","Regression","Postgres"})
	public void TC_38_xactOperationsXaxisTitle() throws EncryptedDocumentException, IOException {
		metPage.validateXactOperationsXaxisTitle(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.postgresGreeshma, "Metrics_GraphXaxis"));
	}
	
	@Test(groups = {"DBM","UI","Regression","Postgres"})
	public void TC_39_xactOperationsYaxisTitle() throws EncryptedDocumentException, IOException {
		metPage.validateXactOperationsYaxisTitle(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.postgresGreeshma, "Metrics_GraphYaxis"));
	}
	
	@Test(groups = {"DBM","UI","Regression","Postgres"})
	public void TC_40_xactOperationsXaxisToolTipOnHover() {
		metPage.validateXactOperationsToolTipTitleHover();
	}
	
	@Test(groups = {"DBM","UI","Regression","Postgres"})
	public void TC_41_xactOperationsLegendsText() throws EncryptedDocumentException, IOException {
		metPage.validateXactOperationsWidgetLegendsList(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.postgresGreeshma, "Metrics_XactGraphLegend"));
	}
	
	@Test(groups = {"DBM","UI","Regression","Postgres"})
	public void TC_42_xactOperationsLegendsFunctionality () {
		metPage.validateXactOperationsWidgetActiveLegendsFunctionality();
	}
	
	@Test(groups = {"DBM","UI","Regression","Postgres"})
	public void TC_43_validate_The_All_Widget_Data_By_Selecting_5Mins_TimeLine()
	{
		//select the time line from calendar
		commPage.selectTheTimeLineFromCalender(IPathConstant.fiveMinutesTimeRange);

		//Validate whether the widgets are displaying the proper time line or not
		metPage.validateTheGivenTimeLine();
		
		
	}
	@Test(groups = {"DBM","UI","Regression","Postgres"})
	public void TC_44_validate_The_All_Widgets_Data_By_Selecting_15Mins_TimeLine()
	{
		//select the time line from calendar
		commPage.selectTheTimeLineFromCalender(IPathConstant.fifteenMinutesTimeRange);

		//Validate whether the widgets are displaying the proper time line or not
		metPage.validateTheGivenTimeLine();
		
		
	}
	
	@Test(groups = {"DBM","UI","Regression","Postgres"})
	public void TC_45_validate_The_All_Widgets_Data_By_Selecting_30Mins_TimeLine()
	{
		//select the time line from calendar
		commPage.selectTheTimeLineFromCalender(IPathConstant.thirtyMinutesTimeRange);

		//Validate whether the widgets are displaying the proper time line or not
		metPage.validateTheGivenTimeLine();
	
		
	}
	
	@Test(groups = {"DBM","UI","Regression","Postgres"})
	public void TC_46_validate_The_All_Widgets_Data_By_Selecting_60Mins_TimeLine()
	{
		//select the time line from calendar
		commPage.selectTheTimeLineFromCalender(IPathConstant.sixtyMinutesTimeRange);

		//Validate whether the widgets are displaying the proper time line or not
		metPage.validateTheGivenTimeLine();
		
		
	}
	
	@Test(groups = {"DBM","UI","Regression","Postgres"})
	public void TC_47_validate_The_All_Widgets_Data_By_Selecting_3hours_TimeLine()
	{
		//select the time line from calendar
		commPage.selectTheTimeLineFromCalender(IPathConstant.threeHoursTimeRange);

		//Validate whether the widgets are displaying the proper time line or not
		metPage.validateTheGivenTimeLine();
		
		
	}
	
	@Test(groups = {"DBM","UI","Regression","Postgres"})
	public void TC_48_validate_The_All_Widgets_Data_By_Selecting_6hours_TimeLine()
	{
		//select the time line from calendar
		commPage.selectTheTimeLineFromCalender(IPathConstant.sixHoursTimeRange);

		//Validate whether the widgets are displaying the proper time line or not
		metPage.validateTheGivenTimeLine();
		
	}
	
	@Test(groups = {"DBM","UI","Regression","Postgres"})
	public void TC_49_validate_The_All_Widgets_Data_By_Selecting_12hours_TimeLine()
	{
		//select the time line from calendar
		commPage.selectTheTimeLineFromCalender(IPathConstant.twelveHoursTimeRange);

		//Validate whether the widgets are displaying the proper time line or not
		metPage.validateTheGivenTimeLine();
		
	}
	
	@Test(groups = {"DBM","UI","Regression","Postgres"})
	public void TC_50_validate_The_All_Widgets_Data_By_Selecting_1day_TimeLine()
	{
		//select the time line from calendar
		commPage.selectTheTimeLineFromCalender(IPathConstant.oneDayTimeRange);

		//Validate whether the widgets are displaying the proper time line or not
		metPage.validateTheGivenTimeLine();
		
	}
	
	@Test(groups = {"DBM","UI","Regression","Postgres"})
	public void TC_51_validate_The_All_Widgets_Data_By_Selecting_1week_TimeLine()
	{
		//select the time line from calendar
		commPage.selectTheTimeLineFromCalender(IPathConstant.oneWeekTimeRange);

		//Validate whether the widgets are displaying the proper time line or not
		metPage.validateTheGivenTimeLine();
		
	}
	
	@Test(groups = {"DBM","UI","Regression","Postgres"})
	public void TC_52_validate_The_All_Widgets_Data_By_Selecting_1month_TimeLine()
	{
		//select the time line from calendar
		commPage.selectTheTimeLineFromCalender(IPathConstant.oneMonthTimeRange);

		//Validate whether the widgets are displaying the proper time line or not
		metPage.validateTheGivenTimeLine();
		
	}
	
	@Test(groups = {"DBM","UI","Regression","Postgres"})
	public void TC_53_validate_The_All_Widgets_By_selecting_custom_Time_For_Minutes_Range() throws EncryptedDocumentException, IOException
	{
		//select the time line from calendar
		commPage.selectTheCustomeTimeLine(IPathConstant.customTimeRange, eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customMinutesRange") );
		
		//Validate whether the widgets are displaying the proper time line or not
		metPage.validateTheCustomTimeLine(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customMinutesRange"));
		
		
	}
	
	
	@Test(groups = {"DBM","UI","Regression","Postgres"})
	public void TC_54_validate_The_All_Widgets_By_selecting_custom_Time_For_Hours_Range() throws EncryptedDocumentException, IOException
	{
		//select the time line from calendar
		commPage.selectTheCustomeTimeLine(IPathConstant.customTimeRange, eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customHoursRange"));
		
		//Validate whether the widgets are displaying the proper time line or not
		metPage.validateTheCustomTimeLine(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customMinutesRange"));
				
		
		
	}
	
	@Test(groups = {"DBM","UI","Regression","Postgres"})
	public void TC_55_validate_The_All_Widgets_By_selecting_custom_Time_For_Days_Range() throws EncryptedDocumentException, IOException
	{
		//select the time line from calendar
		commPage.selectTheCustomeTimeLine(IPathConstant.customTimeRange, eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customDaysRange"));
		
		//Validate whether the widgets are displaying the proper time line or not
		metPage.validateTheCustomTimeLine(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customMinutesRange"));
				
		
		
	}
	
	@Test(groups = {"DBM","UI","Regression","Postgres"})
	public void TC_56_validate_The_All_Widgets_By_selecting_custom_Time_For_Future_date()
	{
		//select the future time line from calendar
		commPage.validateTheFutureTimeLine();
	}
	
	
}