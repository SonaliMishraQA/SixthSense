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
import objectRepository.MQM.KafkaOverviewBrokerPage;

public class KafkaOverviewBrokerTest extends BaseClass
{
	GenericMethods util = new GenericMethods();
	CommonPage commonPage;
	KafkaOverviewBrokerPage KafkaOverviewBrokerPage;
	ExcelUtility excel = new ExcelUtility();	

	@BeforeMethod
	public void Overview() throws EncryptedDocumentException, IOException 
	{
		commonPage = new CommonPage(page);
		KafkaOverviewBrokerPage = new  KafkaOverviewBrokerPage(page);
		excel = new ExcelUtility();
	}	
/**
 * Broker Tab
 * @throws EncryptedDocumentException
 * @throws IOException
 */
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_001_validate_Broker_Tab_Title() throws EncryptedDocumentException, IOException {
		commonPage.navigateToMQM();	
		String messageQueue = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Load, "MessageQueue");
		KafkaOverviewBrokerPage.navigateToKafka(messageQueue);
		page.waitForLoadState(LoadState.NETWORKIDLE);
		page.waitForTimeout(3000);
		String application =excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Load, "Application");
		KafkaOverviewBrokerPage.selectServiceName(application);	
		commonPage.selectTheTimeLineFromCalender(IPathConstant.oneMonthTimeRange);
		page.reload();
		KafkaOverviewBrokerPage.validateBrokerTabTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Broker_Tab_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_002_validate_Overview_Metrics_Legend_Title() throws EncryptedDocumentException, IOException {
		KafkaOverviewBrokerPage.validateMetricsLegendTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "MetricsLegendTitle"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_003_validate_Overview_Metrics_NoOfBrokers() throws EncryptedDocumentException, IOException {
		KafkaOverviewBrokerPage.validateMetricsNoOfBrokers(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "MetricsBrokersNos"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_004_validate_Overview_Metrics_NoOfTopics() throws EncryptedDocumentException, IOException {
		KafkaOverviewBrokerPage.validateMetricsNoOfTopics(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "MetricsTopicsNos"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_005_validate_Overview_Metrics_NoOfPartitions() throws EncryptedDocumentException, IOException {
		KafkaOverviewBrokerPage.validateMetricsNoOfPartitions(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "MetricsPartitionsNos"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_006_validate_Overview_Metrics_NoOfProducers() throws EncryptedDocumentException, IOException {
		KafkaOverviewBrokerPage.validateMetricsNoOfProducers(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "MetricsProducersNos"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_007_validate_Overview_Metrics_NoOfConsumers() throws EncryptedDocumentException, IOException {
		KafkaOverviewBrokerPage.validateMetricsNoOfConsumers(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "MetricsConsumersNos"));
	}
		
/*
 * Bytes In Graph	
 */

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_008_validate_Broker_BytesInGraph_Title() throws EncryptedDocumentException, IOException {
		KafkaOverviewBrokerPage.validateBytesInGraphTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Broker_BytesIn_Graph_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_009_validate_Broker_BytesInGraph_ZoomIn() throws EncryptedDocumentException, IOException {	
		page.waitForTimeout(2000);;
		KafkaOverviewBrokerPage.validateBytesInZoomInBtn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_010_validate_Broker_BytesInGraph_ZoomOut() throws EncryptedDocumentException, IOException {
		KafkaOverviewBrokerPage.validateBytesInZoomOutBtn();
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_011_validate_Broker_BytesInGraph_DragAndDrop() throws EncryptedDocumentException, IOException {
		KafkaOverviewBrokerPage.validateBytesInDragAndDrop();
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_012_validate_Broker_BytesInGraph_XaxisTitle() throws EncryptedDocumentException, IOException {
		KafkaOverviewBrokerPage.validateBytesInGraphXaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Broker_BytesIn_Xaxis_Title"));
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_013_validate_Broker_BytesInGraph_YaxisTitle() throws EncryptedDocumentException, IOException {
		KafkaOverviewBrokerPage.validateBytesInGraphYaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Broker_BytesIn_Yaxis_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_014_validate_Broker_BytesInGraph_LegendTitle1() throws EncryptedDocumentException, IOException {
		KafkaOverviewBrokerPage.validateBytesInGraphLegendTitle1(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Broker_BytesIn_Broker_Header_Title"));
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_015_validate_Broker_BytesInGraph_LegendTitle2() throws EncryptedDocumentException, IOException {
		KafkaOverviewBrokerPage.validateBytesInGraphLegendTitle2(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Broker_BytesIn_Avg_Header_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_016_validate_Broker_BytesInGraph_LegendTitle3() throws EncryptedDocumentException, IOException {
		KafkaOverviewBrokerPage.validateBytesInGraphLegendTitle3(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Broker_BytesIn_Max_Header_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_017_validate_Broker_BytesInGraph_ToolTip() throws EncryptedDocumentException, IOException {
		KafkaOverviewBrokerPage.validateBytesInToolTipTitle();
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_018_validate_Broker_BytesInGraph_ExpandViewXAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaOverviewBrokerPage.validateBytesInExpandViewXAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_019_validate_Broker_BytesInGraph_ExpandViewYAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaOverviewBrokerPage.validateBytesInExpandViewYAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_020_validate_Broker_BytesInGraph_ExpandViewWidgetTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaOverviewBrokerPage.validateBytesInExpandViewWidgetTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_021_validate_Broker_BytesInGraph_ExpandViewLegendHeader1() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaOverviewBrokerPage.validateBytesInExpandViewLegendHeader1();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_022_validate_Broker_BytesInGraph_ExpandViewLegendHeader2() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaOverviewBrokerPage.validateBytesInExpandViewLegendHeader2();
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_023_validate_Broker_BytesInGraph_ExpandViewLegendHeader3() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaOverviewBrokerPage.validateBytesInExpandViewLegendHeader3();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_024_validate_Broker_BytesInGraph_ExpandViewZoomInBtn() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaOverviewBrokerPage.validateBytesInExpandViewZoomIn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_025_validate_Broker_BytesInGraph_ExpandViewZoomOutBtn() throws EncryptedDocumentException, IOException, InterruptedException {	 
		KafkaOverviewBrokerPage.validateBytesInExpandViewZoomOut();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_026_validate_Broker_BytesInGraph_ExpandViewWidgetDragDrop() throws EncryptedDocumentException, IOException, InterruptedException {		 
		KafkaOverviewBrokerPage.validateBytesInExpandViewWidgetDragDrop();
	}	

/*
 * Bytes Out Graph	
 */

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_027_validate_Broker_BytesOutGraph_Title() throws EncryptedDocumentException, IOException {
		KafkaOverviewBrokerPage.validateBytesOutGraphTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Broker_BytesOut_Graph_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_028_validate_Broker_BytesOutGraph_ZoomIn() throws EncryptedDocumentException, IOException {	
		KafkaOverviewBrokerPage.validateBytesOutZoomInBtn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_029_validate_Broker_BytesOutGraph_ZoomOut() throws EncryptedDocumentException, IOException {
		KafkaOverviewBrokerPage.validateBytesOutZoomOutBtn();
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_030_validate_Broker_BytesOutGraph_DragAndDrop() throws EncryptedDocumentException, IOException {
		KafkaOverviewBrokerPage.validateBytesOutDragAndDrop();
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_031_validate_Broker_BytesOutGraph_XaxisTitle() throws EncryptedDocumentException, IOException {
		KafkaOverviewBrokerPage.validateBytesOutGraphXaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Broker_BytesOut_Xaxis_Title"));
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_032_validate_Broker_BytesOutGraph_YaxisTitle() throws EncryptedDocumentException, IOException {
		KafkaOverviewBrokerPage.validateBytesOutGraphYaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Broker_BytesOut_Yaxis_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_033_validate_Broker_BytesOutGraph_LegendTitle1() throws EncryptedDocumentException, IOException {
		KafkaOverviewBrokerPage.validateBytesOutGraphLegendTitle1(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Broker_BytesOut_Broker_Header_Title"));
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_034_validate_Broker_BytesOutGraph_LegendTitle2() throws EncryptedDocumentException, IOException {
		KafkaOverviewBrokerPage.validateBytesOutGraphLegendTitle2(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Broker_BytesOut_Avg_Header_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_035_validate_Broker_BytesOutGraph_LegendTitle3() throws EncryptedDocumentException, IOException {
		KafkaOverviewBrokerPage.validateBytesOutGraphLegendTitle3(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Broker_BytesOut_Max_Header_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_036_validate_Broker_BytesOutGraph_ToolTip() throws EncryptedDocumentException, IOException {
		KafkaOverviewBrokerPage.validateBytesOutToolTipTitle();
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_037_validate_Broker_BytesOutGraph_ExpandViewXAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaOverviewBrokerPage.validateBytesOutExpandViewXAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_038_validate_Broker_BytesOutGraph_ExpandViewYAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaOverviewBrokerPage.validateBytesOutExpandViewYAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_039_validate_Broker_BytesOutGraph_ExpandViewWidgetTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaOverviewBrokerPage.validateBytesOutExpandViewWidgetTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_040_validate_Broker_BytesOutGraph_ExpandViewLegendHeader1() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaOverviewBrokerPage.validateBytesOutExpandViewLegendHeader1();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_041_validate_Broker_BytesOutGraph_ExpandViewLegendHeader2() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaOverviewBrokerPage.validateBytesOutExpandViewLegendHeader2();
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_042_validate_Broker_BytesOutGraph_ExpandViewLegendHeader3() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaOverviewBrokerPage.validateBytesOutExpandViewLegendHeader3();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_043_validate_Broker_BytesOutGraph_ExpandViewZoomInBtn() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaOverviewBrokerPage.validateBytesOutExpandViewZoomIn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_044_validate_Broker_BytesOutGraph_ExpandViewZoomOutBtn() throws EncryptedDocumentException, IOException, InterruptedException {	 
		KafkaOverviewBrokerPage.validateBytesOutExpandViewZoomOut();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_045_validate_Broker_BytesOutGraph_ExpandViewWidgetDragDrop() throws EncryptedDocumentException, IOException, InterruptedException {		 
		KafkaOverviewBrokerPage.validateBytesOutExpandViewWidgetDragDrop();
	}	
	
/*
 * Total produced request rate Graph	
 */

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_046_validate_Broker_TotalProducedRequestRateGraph_Title() throws EncryptedDocumentException, IOException {
		KafkaOverviewBrokerPage.validateTotalProducedRequestRateGraphTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Broker_TotalProducedRequestRate_Graph_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_047_validate_Broker_TotalProducedRequestRateGraph_ZoomIn() throws EncryptedDocumentException, IOException {	
		KafkaOverviewBrokerPage.validateTotalProducedRequestRateZoomInBtn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_048_validate_Broker_TotalProducedRequestRateGraph_ZoomOut() throws EncryptedDocumentException, IOException {
		KafkaOverviewBrokerPage.validateTotalProducedRequestRateZoomOutBtn();
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_049_validate_Broker_TotalProducedRequestRateGraph_DragAndDrop() throws EncryptedDocumentException, IOException {
		KafkaOverviewBrokerPage.validateTotalProducedRequestRateDragAndDrop();
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_050_validate_Broker_TotalProducedRequestRateGraph_XaxisTitle() throws EncryptedDocumentException, IOException {
		KafkaOverviewBrokerPage.validateTotalProducedRequestRateGraphXaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Broker_TotalProducedRequestRate_Xaxis_Title"));
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_051_validate_Broker_TotalProducedRequestRateGraph_YaxisTitle() throws EncryptedDocumentException, IOException {
		KafkaOverviewBrokerPage.validateTotalProducedRequestRateGraphYaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Broker_TotalProducedRequestRate_Yaxis_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_052_validate_Broker_TotalProducedRequestRateGraph_LegendTitle1() throws EncryptedDocumentException, IOException {
		KafkaOverviewBrokerPage.validateTotalProducedRequestRateGraphLegendTitle1(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Broker_TotalProducedRequestRate_Broker_Header_Title"));
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_053_validate_Broker_TotalProducedRequestRateGraph_LegendTitle2() throws EncryptedDocumentException, IOException {
		KafkaOverviewBrokerPage.validateTotalProducedRequestRateGraphLegendTitle2(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Broker_TotalProducedRequestRate_Avg_Header_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_054_validate_Broker_TotalProducedRequestRateGraph_LegendTitle3() throws EncryptedDocumentException, IOException {
		KafkaOverviewBrokerPage.validateTotalProducedRequestRateGraphLegendTitle3(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Broker_TotalProducedRequestRate_Max_Header_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_060_validate_Broker_TotalProducedRequestRateGraph_ToolTip() throws EncryptedDocumentException, IOException {
		KafkaOverviewBrokerPage.validateTotalProducedRequestRateToolTipTitle();
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_061_validate_Broker_TotalProducedRequestRateGraph_ExpandViewXAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaOverviewBrokerPage.validateTotalProducedRequestRateExpandViewXAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_062_validate_Broker_TotalProducedRequestRateGraph_ExpandViewYAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaOverviewBrokerPage.validateTotalProducedRequestRateExpandViewYAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_063_validate_Broker_TotalProducedRequestRateGraph_ExpandViewWidgetTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaOverviewBrokerPage.validateTotalProducedRequestRateExpandViewWidgetTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_064_validate_Broker_TotalProducedRequestRateGraph_ExpandViewLegendHeader1() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaOverviewBrokerPage.validateTotalProducedRequestRateExpandViewLegendHeader1();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_065_validate_Broker_TotalProducedRequestRateGraph_ExpandViewLegendHeader2() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaOverviewBrokerPage.validateTotalProducedRequestRateExpandViewLegendHeader2();
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_066_validate_Broker_TotalProducedRequestRateGraph_ExpandViewLegendHeader3() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaOverviewBrokerPage.validateTotalProducedRequestRateExpandViewLegendHeader3();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_067_validate_Broker_TotalProducedRequestRateGraph_ExpandViewZoomInBtn() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaOverviewBrokerPage.validateTotalProducedRequestRateExpandViewZoomIn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_068_validate_Broker_TotalProducedRequestRateGraph_ExpandViewZoomOutBtn() throws EncryptedDocumentException, IOException, InterruptedException {	 
		KafkaOverviewBrokerPage.validateTotalProducedRequestRateExpandViewZoomOut();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_069_validate_Broker_TotalProducedRequestRateGraph_ExpandViewWidgetDragDrop() throws EncryptedDocumentException, IOException, InterruptedException {		 
		KafkaOverviewBrokerPage.validateTotalProducedRequestRateExpandViewWidgetDragDrop();
	}	
	
/*
 * Total Fetch Request Rate Graph	
 */

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_070_validate_Broker_TotalFetchRequestRateGraph_Title() throws EncryptedDocumentException, IOException {
		KafkaOverviewBrokerPage.validateTotalFetchRequestRateGraphTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Broker_TotalFetchRequestRate_Graph_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_071_validate_Broker_TotalFetchRequestRateGraph_ZoomIn() throws EncryptedDocumentException, IOException {	
		KafkaOverviewBrokerPage.validateTotalFetchRequestRateZoomInBtn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_072_validate_Broker_TotalFetchRequestRateGraph_ZoomOut() throws EncryptedDocumentException, IOException {
		KafkaOverviewBrokerPage.validateTotalFetchRequestRateZoomOutBtn();
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_073_validate_Broker_TotalFetchRequestRateGraph_DragAndDrop() throws EncryptedDocumentException, IOException {
		KafkaOverviewBrokerPage.validateTotalFetchRequestRateDragAndDrop();
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_074_validate_Broker_TotalFetchRequestRateGraph_XaxisTitle() throws EncryptedDocumentException, IOException {
		KafkaOverviewBrokerPage.validateTotalFetchRequestRateGraphXaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Broker_TotalFetchRequestRate_Xaxis_Title"));
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_075_validate_Broker_TotalFetchRequestRateGraph_YaxisTitle() throws EncryptedDocumentException, IOException {
		KafkaOverviewBrokerPage.validateTotalFetchRequestRateGraphYaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Broker_TotalFetchRequestRate_Yaxis_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_076_validate_Broker_TotalFetchRequestRateGraph_LegendTitle1() throws EncryptedDocumentException, IOException {
		KafkaOverviewBrokerPage.validateTotalFetchRequestRateGraphLegendTitle1(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Broker_TotalFetchRequestRate_Broker_Header_Title"));
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_077_validate_Broker_TotalFetchRequestRateGraph_LegendTitle2() throws EncryptedDocumentException, IOException {
		KafkaOverviewBrokerPage.validateTotalFetchRequestRateGraphLegendTitle2(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Broker_TotalFetchRequestRate_Avg_Header_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_078_validate_Broker_TotalFetchRequestRateGraph_LegendTitle3() throws EncryptedDocumentException, IOException {
		KafkaOverviewBrokerPage.validateTotalFetchRequestRateGraphLegendTitle3(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Broker_TotalFetchRequestRate_Max_Header_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_079_validate_Broker_TotalFetchRequestRateGraph_ToolTip() throws EncryptedDocumentException, IOException {
		KafkaOverviewBrokerPage.validateTotalFetchRequestRateToolTipTitle();
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_080_validate_Broker_TotalFetchRequestRateGraph_ExpandViewXAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaOverviewBrokerPage.validateTotalFetchRequestRateExpandViewXAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_081_validate_Broker_TotalFetchRequestRateGraph_ExpandViewYAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaOverviewBrokerPage.validateTotalFetchRequestRateExpandViewYAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_082_validate_Broker_TotalFetchRequestRateGraph_ExpandViewWidgetTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaOverviewBrokerPage.validateTotalFetchRequestRateExpandViewWidgetTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_083_validate_Broker_TotalFetchRequestRateGraph_ExpandViewLegendHeader1() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaOverviewBrokerPage.validateTotalFetchRequestRateExpandViewLegendHeader1();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_084_validate_Broker_TotalFetchRequestRateGraph_ExpandViewLegendHeader2() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaOverviewBrokerPage.validateTotalFetchRequestRateExpandViewLegendHeader2();
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_085_validate_Broker_TotalFetchRequestRateGraph_ExpandViewLegendHeader3() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaOverviewBrokerPage.validateTotalFetchRequestRateExpandViewLegendHeader3();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_086_validate_Broker_TotalFetchRequestRateGraph_ExpandViewZoomInBtn() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaOverviewBrokerPage.validateTotalFetchRequestRateExpandViewZoomIn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_087_validate_Broker_TotalFetchRequestRateGraph_ExpandViewZoomOutBtn() throws EncryptedDocumentException, IOException, InterruptedException {	 
		KafkaOverviewBrokerPage.validateTotalFetchRequestRateExpandViewZoomOut();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_088_validate_Broker_TotalFetchRequestRateGraph_ExpandViewWidgetDragDrop() throws EncryptedDocumentException, IOException, InterruptedException {		 
		KafkaOverviewBrokerPage.validateTotalFetchRequestRateExpandViewWidgetDragDrop();
	}	
	
/*
 * Messages In Graph	
 */

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_089_validate_Broker_MessagesInGraph_Title() throws EncryptedDocumentException, IOException {
		KafkaOverviewBrokerPage.validateMessagesInGraphTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Broker_MessagesIn_Graph_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_090_validate_Broker_MessagesInGraph_ZoomIn() throws EncryptedDocumentException, IOException {	
		KafkaOverviewBrokerPage.validateMessagesInZoomInBtn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_091_validate_Broker_MessagesInGraph_ZoomOut() throws EncryptedDocumentException, IOException {
		KafkaOverviewBrokerPage.validateMessagesInZoomOutBtn();
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_092_validate_Broker_MessagesInGraph_DragAndDrop() throws EncryptedDocumentException, IOException {
		KafkaOverviewBrokerPage.validateMessagesInDragAndDrop();
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_093_validate_Broker_MessagesInGraph_XaxisTitle() throws EncryptedDocumentException, IOException {
		KafkaOverviewBrokerPage.validateMessagesInGraphXaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Broker_MessagesIn_Xaxis_Title"));
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_094_validate_Broker_MessagesInGraph_YaxisTitle() throws EncryptedDocumentException, IOException {
		KafkaOverviewBrokerPage.validateMessagesInGraphYaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Broker_MessagesIn_Yaxis_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_095_validate_Broker_MessagesInGraph_LegendTitle1() throws EncryptedDocumentException, IOException {
		KafkaOverviewBrokerPage.validateMessagesInGraphLegendTitle1(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Broker_MessagesIn_Broker_Header_Title"));
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_096_validate_Broker_MessagesInGraph_LegendTitle2() throws EncryptedDocumentException, IOException {
		KafkaOverviewBrokerPage.validateMessagesInGraphLegendTitle2(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Broker_MessagesIn_Avg_Header_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_097_validate_Broker_MessagesInGraph_LegendTitle3() throws EncryptedDocumentException, IOException {
		KafkaOverviewBrokerPage.validateMessagesInGraphLegendTitle3(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Broker_MessagesIn_Max_Header_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_098_validate_Broker_MessagesInGraph_ToolTip() throws EncryptedDocumentException, IOException {
		KafkaOverviewBrokerPage.validateMessagesInToolTipTitle();
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_099_validate_Broker_MessagesInGraph_ExpandViewXAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaOverviewBrokerPage.validateMessagesInExpandViewXAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_100_validate_Broker_MessagesInGraph_ExpandViewYAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaOverviewBrokerPage.validateMessagesInExpandViewYAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_101_validate_Broker_MessagesInGraph_ExpandViewWidgetTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaOverviewBrokerPage.validateMessagesInExpandViewWidgetTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_102_validate_Broker_MessagesInGraph_ExpandViewLegendHeader1() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaOverviewBrokerPage.validateMessagesInExpandViewLegendHeader1();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_103_validate_Broker_MessagesInGraph_ExpandViewLegendHeader2() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaOverviewBrokerPage.validateMessagesInExpandViewLegendHeader2();
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_104_validate_Broker_MessagesInGraph_ExpandViewLegendHeader3() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaOverviewBrokerPage.validateMessagesInExpandViewLegendHeader3();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_105_validate_Broker_MessagesInGraph_ExpandViewZoomInBtn() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaOverviewBrokerPage.validateMessagesInExpandViewZoomIn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_106_validate_Broker_MessagesInGraph_ExpandViewZoomOutBtn() throws EncryptedDocumentException, IOException, InterruptedException {	 
		KafkaOverviewBrokerPage.validateMessagesInExpandViewZoomOut();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_107_validate_Broker_MessagesInGraph_ExpandViewWidgetDragDrop() throws EncryptedDocumentException, IOException, InterruptedException {		 
		KafkaOverviewBrokerPage.validateMessagesInExpandViewWidgetDragDrop();
	}	
	
/*
 * Leader Election Rate Graph	
 */

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_108_validate_Broker_LeaderElectionRateGraph_Title() throws EncryptedDocumentException, IOException {
		KafkaOverviewBrokerPage.validateLeaderElectionRateGraphTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Broker_LeaderElectionRate_Graph_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_109_validate_Broker_LeaderElectionRateGraph_ZoomIn() throws EncryptedDocumentException, IOException {	
		KafkaOverviewBrokerPage.validateLeaderElectionRateZoomInBtn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_110_validate_Broker_LeaderElectionRateGraph_ZoomOut() throws EncryptedDocumentException, IOException {
		KafkaOverviewBrokerPage.validateLeaderElectionRateZoomOutBtn();
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_111_validate_Broker_LeaderElectionRateGraph_DragAndDrop() throws EncryptedDocumentException, IOException {
		KafkaOverviewBrokerPage.validateLeaderElectionRateDragAndDrop();
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_112_validate_Broker_LeaderElectionRateGraph_XaxisTitle() throws EncryptedDocumentException, IOException {
		KafkaOverviewBrokerPage.validateLeaderElectionRateGraphXaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Broker_LeaderElectionRate_Xaxis_Title"));
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_113_validate_Broker_LeaderElectionRateGraph_YaxisTitle() throws EncryptedDocumentException, IOException {
		KafkaOverviewBrokerPage.validateLeaderElectionRateGraphYaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Broker_LeaderElectionRate_Yaxis_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_114_validate_Broker_LeaderElectionRateGraph_LegendTitle1() throws EncryptedDocumentException, IOException {
		KafkaOverviewBrokerPage.validateLeaderElectionRateGraphLegendTitle1(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Broker_LeaderElectionRate_Broker_Header_Title"));
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_115_validate_Broker_LeaderElectionRateGraph_LegendTitle2() throws EncryptedDocumentException, IOException {
		KafkaOverviewBrokerPage.validateLeaderElectionRateGraphLegendTitle2(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Broker_LeaderElectionRate_Avg_Header_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_116_validate_Broker_LeaderElectionRateGraph_LegendTitle3() throws EncryptedDocumentException, IOException {
		KafkaOverviewBrokerPage.validateLeaderElectionRateGraphLegendTitle3(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Broker_LeaderElectionRate_Max_Header_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_117_validate_Broker_LeaderElectionRateGraph_ToolTip() throws EncryptedDocumentException, IOException {
		KafkaOverviewBrokerPage.validateLeaderElectionRateToolTipTitle();
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_118_validate_Broker_LeaderElectionRateGraph_ExpandViewXAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaOverviewBrokerPage.validateLeaderElectionRateExpandViewXAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_119_validate_Broker_LeaderElectionRateGraph_ExpandViewYAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaOverviewBrokerPage.validateLeaderElectionRateExpandViewYAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_120_validate_Broker_LeaderElectionRateGraph_ExpandViewWidgetTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaOverviewBrokerPage.validateLeaderElectionRateExpandViewWidgetTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_121_validate_Broker_LeaderElectionRateGraph_ExpandViewLegendHeader1() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaOverviewBrokerPage.validateLeaderElectionRateExpandViewLegendHeader1();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_122_validate_Broker_LeaderElectionRateGraph_ExpandViewLegendHeader2() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaOverviewBrokerPage.validateLeaderElectionRateExpandViewLegendHeader2();
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_123_validate_Broker_LeaderElectionRateGraph_ExpandViewLegendHeader3() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaOverviewBrokerPage.validateLeaderElectionRateExpandViewLegendHeader3();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_124_validate_Broker_LeaderElectionRateGraph_ExpandViewZoomInBtn() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaOverviewBrokerPage.validateLeaderElectionRateExpandViewZoomIn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_125_validate_Broker_LeaderElectionRateGraph_ExpandViewZoomOutBtn() throws EncryptedDocumentException, IOException, InterruptedException {	 
		KafkaOverviewBrokerPage.validateLeaderElectionRateExpandViewZoomOut();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_126_validate_Broker_LeaderElectionRateGraph_ExpandViewWidgetDragDrop() throws EncryptedDocumentException, IOException, InterruptedException {		 
		KafkaOverviewBrokerPage.validateLeaderElectionRateExpandViewWidgetDragDrop();
	}	
	
/*
 * Uncleaned Election leader per second Graph	
 */

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_127_validate_Broker_UncleanedElectionLeaderPerSecondGraph_Title() throws EncryptedDocumentException, IOException {
		KafkaOverviewBrokerPage.validateUncleanedElectionLeaderPerSecondGraphTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Broker_UncleanedElectionLeaderPerSecond_Graph_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_128_validate_Broker_UncleanedElectionLeaderPerSecondGraph_ZoomIn() throws EncryptedDocumentException, IOException {	
		KafkaOverviewBrokerPage.validateUncleanedElectionLeaderPerSecondZoomInBtn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_129_validate_Broker_UncleanedElectionLeaderPerSecondGraph_ZoomOut() throws EncryptedDocumentException, IOException {
		KafkaOverviewBrokerPage.validateUncleanedElectionLeaderPerSecondZoomOutBtn();
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_130_validate_Broker_UncleanedElectionLeaderPerSecondGraph_DragAndDrop() throws EncryptedDocumentException, IOException {
		KafkaOverviewBrokerPage.validateUncleanedElectionLeaderPerSecondDragAndDrop();
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_131_validate_Broker_UncleanedElectionLeaderPerSecondGraph_XaxisTitle() throws EncryptedDocumentException, IOException {
		KafkaOverviewBrokerPage.validateUncleanedElectionLeaderPerSecondGraphXaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Broker_UncleanedElectionLeaderPerSecond_Xaxis_Title"));
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_132_validate_Broker_UncleanedElectionLeaderPerSecondGraph_YaxisTitle() throws EncryptedDocumentException, IOException {
		KafkaOverviewBrokerPage.validateUncleanedElectionLeaderPerSecondGraphYaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Broker_UncleanedElectionLeaderPerSecond_Yaxis_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_133_validate_Broker_UncleanedElectionLeaderPerSecondGraph_LegendTitle1() throws EncryptedDocumentException, IOException {
		KafkaOverviewBrokerPage.validateUncleanedElectionLeaderPerSecondGraphLegendTitle1(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Broker_UncleanedElectionLeaderPerSecond_Broker_Header_Title"));
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_134_validate_Broker_UncleanedElectionLeaderPerSecondGraph_LegendTitle2() throws EncryptedDocumentException, IOException {
		KafkaOverviewBrokerPage.validateUncleanedElectionLeaderPerSecondGraphLegendTitle2(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Broker_UncleanedElectionLeaderPerSecond_Avg_Header_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_135_validate_Broker_UncleanedElectionLeaderPerSecondGraph_LegendTitle3() throws EncryptedDocumentException, IOException {
		KafkaOverviewBrokerPage.validateUncleanedElectionLeaderPerSecondGraphLegendTitle3(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Broker_UncleanedElectionLeaderPerSecond_Max_Header_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_136_validate_Broker_UncleanedElectionLeaderPerSecondGraph_ToolTip() throws EncryptedDocumentException, IOException {
		KafkaOverviewBrokerPage.validateUncleanedElectionLeaderPerSecondToolTipTitle();
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_137_validate_Broker_UncleanedElectionLeaderPerSecondGraph_ExpandViewXAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaOverviewBrokerPage.validateUncleanedElectionLeaderPerSecondExpandViewXAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_138_validate_Broker_UncleanedElectionLeaderPerSecondGraph_ExpandViewYAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaOverviewBrokerPage.validateUncleanedElectionLeaderPerSecondExpandViewYAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_139_validate_Broker_UncleanedElectionLeaderPerSecondGraph_ExpandViewWidgetTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaOverviewBrokerPage.validateUncleanedElectionLeaderPerSecondExpandViewWidgetTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_140_validate_Broker_UncleanedElectionLeaderPerSecondGraph_ExpandViewLegendHeader1() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaOverviewBrokerPage.validateUncleanedElectionLeaderPerSecondExpandViewLegendHeader1();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_141_validate_Broker_UncleanedElectionLeaderPerSecondGraph_ExpandViewLegendHeader2() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaOverviewBrokerPage.validateUncleanedElectionLeaderPerSecondExpandViewLegendHeader2();
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_142_validate_Broker_UncleanedElectionLeaderPerSecondGraph_ExpandViewLegendHeader3() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaOverviewBrokerPage.validateUncleanedElectionLeaderPerSecondExpandViewLegendHeader3();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_143_validate_Broker_UncleanedElectionLeaderPerSecondGraph_ExpandViewZoomInBtn() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaOverviewBrokerPage.validateUncleanedElectionLeaderPerSecondExpandViewZoomIn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_144_validate_Broker_UncleanedElectionLeaderPerSecondGraph_ExpandViewZoomOutBtn() throws EncryptedDocumentException, IOException, InterruptedException {	 
		KafkaOverviewBrokerPage.validateUncleanedElectionLeaderPerSecondExpandViewZoomOut();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_145_validate_Broker_UncleanedElectionLeaderPerSecondGraph_ExpandViewWidgetDragDrop() throws EncryptedDocumentException, IOException, InterruptedException {		 
		KafkaOverviewBrokerPage.validateUncleanedElectionLeaderPerSecondExpandViewWidgetDragDrop();
	}	
	
/*
 * No. Of Brokers Graph	
 */

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_146_validate_Broker_NoOfBrokersGraph_Title() throws EncryptedDocumentException, IOException {
		KafkaOverviewBrokerPage.validateNoOfBrokersGraphTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Broker_NoOfBrokers_Graph_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_147_validate_Broker_NoOfBrokersGraph_ZoomIn() throws EncryptedDocumentException, IOException {	
		KafkaOverviewBrokerPage.validateNoOfBrokersZoomInBtn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_148_validate_Broker_NoOfBrokersGraph_ZoomOut() throws EncryptedDocumentException, IOException {
		KafkaOverviewBrokerPage.validateNoOfBrokersZoomOutBtn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_149_validate_Broker_NoOfBrokersGraph_ZoomReset() throws EncryptedDocumentException, IOException {
		KafkaOverviewBrokerPage.validateNoOfBrokersZoomResetBtn();
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_150_validate_Broker_NoOfBrokersGraph_DragAndDrop() throws EncryptedDocumentException, IOException {
		KafkaOverviewBrokerPage.validateNoOfBrokersDragAndDrop();
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_151_validate_Broker_NoOfBrokersGraph_XaxisTitle() throws EncryptedDocumentException, IOException {
		KafkaOverviewBrokerPage.validateNoOfBrokersGraphXaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Broker_NoOfBrokers_Xaxis_Title"));
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_152_validate_Broker_NoOfBrokersGraph_YaxisTitle() throws EncryptedDocumentException, IOException {
		KafkaOverviewBrokerPage.validateNoOfBrokersGraphYaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Broker_NoOfBrokers_Yaxis_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_153_validate_Broker_NoOfBrokersGraph_ToolTip() throws EncryptedDocumentException, IOException {
		KafkaOverviewBrokerPage.validateNoOfBrokersToolTipTitle();
	}

	@Test(groups= {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_154_validate_ConsumerTab_when_TimeRangeisChangedTo_5min() {
		commonPage.selectTheTimeLineFromCalender(IPathConstant.fiveMinutesTimeRange);
		KafkaOverviewBrokerPage.validateXaxisValuesForKafkaOverviewBrokerPage();
	}
	@Test(groups= {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_155_validate_ConsumerTab_when_TimeRangeisChangedTo_15min() {
		commonPage.selectTheTimeLineFromCalender(IPathConstant.fifteenMinutesTimeRange);
		KafkaOverviewBrokerPage.validateXaxisValuesForKafkaOverviewBrokerPage();
	}
	@Test(groups= {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_156_validate_ConsumerTab_when_TimeRangeisChangedTo_30min() {
		commonPage.selectTheTimeLineFromCalender(IPathConstant.thirtyMinutesTimeRange);
		KafkaOverviewBrokerPage.validateXaxisValuesForKafkaOverviewBrokerPage();
	}
	@Test(groups= {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_157_validate_ConsumerTab_when_TimeRangeisChangedTo_60min() {
		commonPage.selectTheTimeLineFromCalender(IPathConstant.sixtyMinutesTimeRange);
		KafkaOverviewBrokerPage.validateXaxisValuesForKafkaOverviewBrokerPage();
	}
	@Test(groups= {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_158_validate_ConsumerTab_when_TimeRangeisChangedTo_3hour() {
		commonPage.selectTheTimeLineFromCalender(IPathConstant.threeHoursTimeRange);
		KafkaOverviewBrokerPage.validateXaxisValuesForKafkaOverviewBrokerPage();
	}
	@Test(groups= {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_159_validate_ConsumerTab_when_TimeRangeisChangedTo_6hour() {
		commonPage.selectTheTimeLineFromCalender(IPathConstant.sixHoursTimeRange);
		KafkaOverviewBrokerPage.validateXaxisValuesForKafkaOverviewBrokerPage();
	}
	@Test(groups= {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_160_validate_ConsumerTab_when_TimeRangeisChangedTo_1Day() {
		commonPage.selectTheTimeLineFromCalender(IPathConstant.oneDayTimeRange);
		KafkaOverviewBrokerPage.validateXaxisValuesForKafkaOverviewBrokerPage();
	}
	@Test(groups= {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_161_validate_ConsumerTab_when_TimeRangeisChangedTo_1Week() {
		commonPage.selectTheTimeLineFromCalender(IPathConstant.oneWeekTimeRange);
		KafkaOverviewBrokerPage.validateXaxisValuesForKafkaOverviewBrokerPage();
	}
	@Test(groups= {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_162_validate_ConsumerTab_when_TimeRangeisChangedTo_1Month() {
		commonPage.selectTheTimeLineFromCalender(IPathConstant.oneMonthTimeRange);
		KafkaOverviewBrokerPage.validateXaxisValuesForKafkaOverviewBrokerPage();
	}
	@Test(groups= {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_163_validate_ConsumerTab_when_TimeRangeisChangedTo_4hour() throws EncryptedDocumentException, IOException {
		commonPage.selectTheCustomeTimeLine(IPathConstant.customTimeRange, excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath, IPathConstant.calenderSheet, "customHoursRange"));
		KafkaOverviewBrokerPage.validateTheCustomTimeLine(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath, IPathConstant.calenderSheet, "customHoursRange"));
	}
	
	@Test(groups = {"MQM","UI","Regression"})
	public void TC_164_validate_The_All_Widgets_By_selecting_custom_Time_For_Minutes_Range() throws EncryptedDocumentException, IOException
	{	
		//select the time line from calendar
		commonPage.selectTheCustomeTimeLine(IPathConstant.customTimeRange, excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customMinutesRange") );
				
		//Validate whether the widgets are displaying the proper time line or not
		KafkaOverviewBrokerPage.validateTheCustomTimeLine(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customMinutesRange"));
	}
	@Test(groups = {"MQM","UI","Regression"})
	public void TC_165_validate_The_All_Widgets_By_selecting_custom_Time_For_Hours_Range() throws EncryptedDocumentException, IOException
	{	
		//select the time line from calendar
		commonPage.selectTheCustomeTimeLine(IPathConstant.customTimeRange, excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customHoursRange"));

		//Validate whether the widgets are displaying the proper time line or not
		KafkaOverviewBrokerPage.validateTheCustomTimeLine(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customHoursRange"));
	}
	@Test(groups = {"MQM","UI","Regression"})
	public void TC_166_validate_The_All_Widgets_By_selecting_custom_Time_For_Days_Range() throws EncryptedDocumentException, IOException
	{
		//select the time line from calendar
		commonPage.selectTheCustomeTimeLine(IPathConstant.customTimeRange, excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customDaysRange"));
		
		//Validate whether the widgets are displaying the proper time line or not
		KafkaOverviewBrokerPage.validateTheCustomTimeLine(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customDaysRange"));
	}
	
	
	@Test(groups = {"MQM","UI","Regression"})
	public void TC_167_validate_The_All_Widgets_By_selecting_custom_Time_For_Future_date()
	{
		//select the time line from calendar
		commonPage.selectTheTimeLineFromCalender(IPathConstant.fiveMinutesTimeRange);
		
		//select the future time line from calendar
		commonPage.validateTheFutureTimeLine();
	}
}
