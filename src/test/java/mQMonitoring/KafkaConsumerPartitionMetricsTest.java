package mQMonitoring;

import org.testng.annotations.Test;

import com.microsoft.playwright.options.LoadState;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.BeforeMethod;

import genericUtilities.ExcelUtility;
import genericUtilities.GenericMethods;
import genericUtilities.IPathConstant;
import objectRepository.CommonPage;
import playWrightFactory.BaseClass;
import objectRepository.MQM.KafkaConsumerPartitionMetricsPage;

public class KafkaConsumerPartitionMetricsTest extends BaseClass
{
	GenericMethods util = new GenericMethods();
	CommonPage commonPage;
	KafkaConsumerPartitionMetricsPage KafkaConsumerPartitionMetricsPage;
	ExcelUtility excel = new ExcelUtility();	

	@BeforeMethod
	public void Consumer() throws EncryptedDocumentException, IOException 
	{
		commonPage = new CommonPage(page);
		KafkaConsumerPartitionMetricsPage = new  KafkaConsumerPartitionMetricsPage(page);
		excel = new ExcelUtility();
	}	
/**
 * Partition Metrics Tab
 * @throws EncryptedDocumentException
 * @throws IOException
 */
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_001_validate_PartitionMetrics_Tab_Title() throws EncryptedDocumentException, IOException {
		commonPage.navigateToMQM();	
		String messageQueue = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Load, "MessageQueue");
		KafkaConsumerPartitionMetricsPage.navigateToKafka(messageQueue);
		page.waitForLoadState(LoadState.NETWORKIDLE);
		page.waitForTimeout(3000);
		String application =excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Load, "Application");
		KafkaConsumerPartitionMetricsPage.selectServiceName(application);
		commonPage.selectTheTimeLineFromCalender(IPathConstant.oneMonthTimeRange);
		KafkaConsumerPartitionMetricsPage.navigateToConsumerTab();
		KafkaConsumerPartitionMetricsPage.validatePartitionMetricsTabTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Consumer, "PartitionMetrics_Tab_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_002_validate_Consumer_Title() throws EncryptedDocumentException, IOException {
		KafkaConsumerPartitionMetricsPage.validateConsumerSelectTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Consumer, "PartitionMetrics_ConsumerSelect_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_003_validate_Consumer_DropDown() throws EncryptedDocumentException, IOException {
		KafkaConsumerPartitionMetricsPage.validateConsumerSelectDropDown();
	}
	
		
/*
 * Lag Graph	
 */

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_004_validate_PartitionMetrics_LagGraph_Title() throws EncryptedDocumentException, IOException {
		KafkaConsumerPartitionMetricsPage.validateLagGraphTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Consumer, "PartitionMetrics_Lag_Graph_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_005_validate_PartitionMetrics_LagGraph_ZoomIn() throws EncryptedDocumentException, IOException {	
		KafkaConsumerPartitionMetricsPage.validateLagZoomInBtn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_006_validate_PartitionMetrics_LagGraph_ZoomOut() throws EncryptedDocumentException, IOException {
		KafkaConsumerPartitionMetricsPage.validateLagZoomOutBtn();
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_007_validate_PartitionMetrics_LagGraph_DragAndDrop() throws EncryptedDocumentException, IOException {
		KafkaConsumerPartitionMetricsPage.validateLagDragAndDrop();
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_008_validate_PartitionMetrics_LagGraph_XaxisTitle() throws EncryptedDocumentException, IOException {
		KafkaConsumerPartitionMetricsPage.validateLagGraphXaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Consumer, "PartitionMetrics_Lag_Xaxis_Title"));
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_009_validate_PartitionMetrics_LagGraph_YaxisTitle() throws EncryptedDocumentException, IOException {
		KafkaConsumerPartitionMetricsPage.validateLagGraphYaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Consumer, "PartitionMetrics_Lag_Yaxis_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_010_validate_PartitionMetrics_LagGraph_LegendTitle1() throws EncryptedDocumentException, IOException {
		KafkaConsumerPartitionMetricsPage.validateLagGraphLegendTitle1(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Consumer, "PartitionMetrics_Lag_Consumer_Header_Title"));
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_011_validate_PartitionMetrics_LagGraph_LegendTitle2() throws EncryptedDocumentException, IOException {
		KafkaConsumerPartitionMetricsPage.validateLagGraphLegendTitle2(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Consumer, "PartitionMetrics_Lag_Avg_Header_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_012_validate_PartitionMetrics_LagGraph_LegendTitle3() throws EncryptedDocumentException, IOException {
		KafkaConsumerPartitionMetricsPage.validateLagGraphLegendTitle3(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Consumer, "PartitionMetrics_Lag_Max_Header_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_013_validate_PartitionMetrics_LagGraph_ToolTip() throws EncryptedDocumentException, IOException {
		KafkaConsumerPartitionMetricsPage.validateLagToolTipTitle();
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_014_validate_PartitionMetrics_LagGraph_ExpandViewXAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaConsumerPartitionMetricsPage.validateLagExpandViewXAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_015_validate_PartitionMetrics_LagGraph_ExpandViewYAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaConsumerPartitionMetricsPage.validateLagExpandViewYAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_016_validate_PartitionMetrics_LagGraph_ExpandViewWidgetTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaConsumerPartitionMetricsPage.validateLagExpandViewWidgetTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_017_validate_PartitionMetrics_LagGraph_ExpandViewLegendHeader1() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaConsumerPartitionMetricsPage.validateLagExpandViewLegendHeader1();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_018_validate_PartitionMetrics_LagGraph_ExpandViewLegendHeader2() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaConsumerPartitionMetricsPage.validateLagExpandViewLegendHeader2();
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_019_validate_PartitionMetrics_LagGraph_ExpandViewLegendHeader3() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaConsumerPartitionMetricsPage.validateLagExpandViewLegendHeader3();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_020_validate_PartitionMetrics_LagGraph_ExpandViewZoomInBtn() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaConsumerPartitionMetricsPage.validateLagExpandViewZoomIn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_021_validate_PartitionMetrics_LagGraph_ExpandViewZoomOutBtn() throws EncryptedDocumentException, IOException, InterruptedException {	 
		KafkaConsumerPartitionMetricsPage.validateLagExpandViewZoomOut();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_022_validate_PartitionMetrics_LagGraph_ExpandViewWidgetDragDrop() throws EncryptedDocumentException, IOException, InterruptedException {		 
		KafkaConsumerPartitionMetricsPage.validateLagExpandViewWidgetDragDrop();
	}	

	
/*
 * Lead Graph	
 */
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_023_validate_PartitionMetrics_LeadGraph_Title() throws EncryptedDocumentException, IOException {
		KafkaConsumerPartitionMetricsPage.validateLeadGraphTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Consumer, "PartitionMetrics_Lead_Graph_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_024_validate_PartitionMetrics_LeadGraph_ZoomIn() throws EncryptedDocumentException, IOException {
		KafkaConsumerPartitionMetricsPage.validateLeadZoomInBtn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_025_validate_PartitionMetrics_LeadGraph_ZoomOut() throws EncryptedDocumentException, IOException {
		KafkaConsumerPartitionMetricsPage.validateLeadZoomOutBtn();
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_026_validate_PartitionMetrics_LeadGraph_DragAndDrop() throws EncryptedDocumentException, IOException {
		KafkaConsumerPartitionMetricsPage.validateLeadDragAndDrop();
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_027_validate_PartitionMetrics_LeadGraph_XaxisTitle() throws EncryptedDocumentException, IOException {
		KafkaConsumerPartitionMetricsPage.validateLeadGraphXaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Consumer, "PartitionMetrics_Lead_Xaxis_Title"));
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_028_validate_PartitionMetrics_LeadGraph_YaxisTitle() throws EncryptedDocumentException, IOException {
		KafkaConsumerPartitionMetricsPage.validateLeadGraphYaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Consumer, "PartitionMetrics_Lead_Yaxis_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_029_validate_PartitionMetrics_LeadGraph_LegendTitle1() throws EncryptedDocumentException, IOException {
		KafkaConsumerPartitionMetricsPage.validateLeadGraphLegendTitle1(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Consumer, "PartitionMetrics_Lead_Consumer_Header_Title"));
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_030_validate_PartitionMetrics_LeadGraph_LegendTitle2() throws EncryptedDocumentException, IOException {
		KafkaConsumerPartitionMetricsPage.validateLeadGraphLegendTitle2(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Consumer, "PartitionMetrics_Lead_Avg_Header_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_031_validate_PartitionMetrics_LeadGraph_LegendTitle3() throws EncryptedDocumentException, IOException {
		KafkaConsumerPartitionMetricsPage.validateLeadGraphLegendTitle3(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Consumer, "PartitionMetrics_Lead_Max_Header_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_032_validate_PartitionMetrics_LeadGraph_ToolTip() throws EncryptedDocumentException, IOException {
		KafkaConsumerPartitionMetricsPage.validateLeadToolTipTitle();
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_033_validate_PartitionMetrics_LeadGraph_ExpandViewXAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaConsumerPartitionMetricsPage.validateLeadExpandViewXAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_034_validate_PartitionMetrics_LeadGraph_ExpandViewYAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaConsumerPartitionMetricsPage.validateLeadExpandViewYAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_035_validate_PartitionMetrics_LeadGraph_ExpandViewWidgetTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaConsumerPartitionMetricsPage.validateLeadExpandViewWidgetTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_036_validate_PartitionMetrics_LeadGraph_ExpandViewLegendHeader1() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaConsumerPartitionMetricsPage.validateLeadExpandViewLegendHeader1();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_037_validate_PartitionMetrics_LeadGraph_ExpandViewLegendHeader2() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaConsumerPartitionMetricsPage.validateLeadExpandViewLegendHeader2();
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_038_validate_PartitionMetrics_LeadGraph_ExpandViewLegendHeader3() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaConsumerPartitionMetricsPage.validateLeadExpandViewLegendHeader3();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_039_validate_PartitionMetrics_LeadGraph_ExpandViewZoomInBtn() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaConsumerPartitionMetricsPage.validateLeadExpandViewZoomIn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_040_validate_PartitionMetrics_LeadGraph_ExpandViewZoomOutBtn() throws EncryptedDocumentException, IOException, InterruptedException {	 
		KafkaConsumerPartitionMetricsPage.validateLeadExpandViewZoomOut();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_041_validate_PartitionMetrics_LeadGraph_ExpandViewWidgetDragDrop() throws EncryptedDocumentException, IOException, InterruptedException {		 
		KafkaConsumerPartitionMetricsPage.validateLeadExpandViewWidgetDragDrop();
	}	
	
	@Test(groups= {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_042_validate_ConsumerTab_when_TimeRangeisChangedTo_5min() {
		commonPage.selectTheTimeLineFromCalender(IPathConstant.fiveMinutesTimeRange);
		KafkaConsumerPartitionMetricsPage.validateXaxisValuesForKafkaConsumerPartitionMetricsPage();
	}
	
	@Test(groups= {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_043_validate_ConsumerTab_when_TimeRangeisChangedTo_15min() {
		commonPage.selectTheTimeLineFromCalender(IPathConstant.fifteenMinutesTimeRange);
		KafkaConsumerPartitionMetricsPage.validateXaxisValuesForKafkaConsumerPartitionMetricsPage();
	}
	
	@Test(groups= {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_044_validate_ConsumerTab_when_TimeRangeisChangedTo_30min() {
		commonPage.selectTheTimeLineFromCalender(IPathConstant.thirtyMinutesTimeRange);
		KafkaConsumerPartitionMetricsPage.validateXaxisValuesForKafkaConsumerPartitionMetricsPage();
	}
	
	@Test(groups= {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_045_validate_ConsumerTab_when_TimeRangeisChangedTo_60min() {
		commonPage.selectTheTimeLineFromCalender(IPathConstant.sixtyMinutesTimeRange);
		KafkaConsumerPartitionMetricsPage.validateXaxisValuesForKafkaConsumerPartitionMetricsPage();
	}
	
	@Test(groups= {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_046_validate_ConsumerTab_when_TimeRangeisChangedTo_3hour() {
		commonPage.selectTheTimeLineFromCalender(IPathConstant.threeHoursTimeRange);
		KafkaConsumerPartitionMetricsPage.validateXaxisValuesForKafkaConsumerPartitionMetricsPage();
	}
	
	@Test(groups= {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_047_validate_ConsumerTab_when_TimeRangeisChangedTo_6hour() {
		commonPage.selectTheTimeLineFromCalender(IPathConstant.sixHoursTimeRange);
		KafkaConsumerPartitionMetricsPage.validateXaxisValuesForKafkaConsumerPartitionMetricsPage();
	}
	
	@Test(groups= {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_048_validate_ConsumerTab_when_TimeRangeisChangedTo_1Day() {
		commonPage.selectTheTimeLineFromCalender(IPathConstant.oneDayTimeRange);
		KafkaConsumerPartitionMetricsPage.validateXaxisValuesForKafkaConsumerPartitionMetricsPage();
	}
	
	@Test(groups= {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_049_validate_ConsumerTab_when_TimeRangeisChangedTo_1Week() {
		commonPage.selectTheTimeLineFromCalender(IPathConstant.oneWeekTimeRange);
		KafkaConsumerPartitionMetricsPage.validateXaxisValuesForKafkaConsumerPartitionMetricsPage();
	}
	
	@Test(groups= {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_050_validate_ConsumerTab_when_TimeRangeisChangedTo_1Month() {
		commonPage.selectTheTimeLineFromCalender(IPathConstant.oneMonthTimeRange);
		KafkaConsumerPartitionMetricsPage.validateXaxisValuesForKafkaConsumerPartitionMetricsPage();
	}
	
	@Test(groups= {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_051_validate_ConsumerTab_when_TimeRangeisChangedTo_4hour() throws EncryptedDocumentException, IOException {
		commonPage.selectTheCustomeTimeLine(IPathConstant.customTimeRange, excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath, IPathConstant.calenderSheet, "customHoursRange"));
		KafkaConsumerPartitionMetricsPage.validateTheCustomTimeLine(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath, IPathConstant.calenderSheet, "customHoursRange"));
	}
	
	@Test(groups = {"MQM","UI","Regression"})
	public void TC_052_validate_The_All_Widgets_By_selecting_custom_Time_For_Minutes_Range() throws EncryptedDocumentException, IOException
	{	
		//select the time line from calendar
		commonPage.selectTheCustomeTimeLine(IPathConstant.customTimeRange, excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customMinutesRange") );
				
		//Validate whether the widgets are displaying the proper time line or not
		KafkaConsumerPartitionMetricsPage.validateTheCustomTimeLine(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customMinutesRange"));
	}
	
	@Test(groups = {"MQM","UI","Regression"})
	public void TC_053_validate_The_All_Widgets_By_selecting_custom_Time_For_Hours_Range() throws EncryptedDocumentException, IOException
	{	
		//select the time line from calendar
		commonPage.selectTheCustomeTimeLine(IPathConstant.customTimeRange, excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customHoursRange"));

		//Validate whether the widgets are displaying the proper time line or not
		KafkaConsumerPartitionMetricsPage.validateTheCustomTimeLine(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customHoursRange"));
	}
	
	@Test(groups = {"MQM","UI","Regression"})
	public void TC_054_validate_The_All_Widgets_By_selecting_custom_Time_For_Days_Range() throws EncryptedDocumentException, IOException
	{
		//select the time line from calendar
		commonPage.selectTheCustomeTimeLine(IPathConstant.customTimeRange, excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customDaysRange"));
		
		//Validate whether the widgets are displaying the proper time line or not
		KafkaConsumerPartitionMetricsPage.validateTheCustomTimeLine(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customDaysRange"));
	}
		
	@Test(groups = {"MQM","UI","Regression"})
	public void TC_055_validate_The_All_Widgets_By_selecting_custom_Time_For_Future_date()
	{
		//select the time line from calendar
		commonPage.selectTheTimeLineFromCalender(IPathConstant.fiveMinutesTimeRange);
		
		//select the future time line from calendar
		commonPage.validateTheFutureTimeLine();
	}			
}
