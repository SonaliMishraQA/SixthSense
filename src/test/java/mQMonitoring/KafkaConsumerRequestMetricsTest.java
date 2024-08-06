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
import objectRepository.MQM.KafkaConsumerRequestMetricsPage;

public class KafkaConsumerRequestMetricsTest extends BaseClass 
{
	GenericMethods util = new GenericMethods();
	CommonPage commonPage;
	KafkaConsumerRequestMetricsPage KafkaConsumerRequestMetricsPage;
	ExcelUtility excel = new ExcelUtility();	

	@BeforeMethod
	public void Consumer() throws EncryptedDocumentException, IOException 
	{
		commonPage = new CommonPage(page);
		KafkaConsumerRequestMetricsPage = new KafkaConsumerRequestMetricsPage(page);
		excel = new ExcelUtility();
	}
	
/**
 * Request Metrics Tab
 * @throws EncryptedDocumentException
 * @throws IOException
 */
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_001_validate_RequestMetrics_Tab_Title() throws EncryptedDocumentException, IOException {
		commonPage.navigateToMQM();	
		String messageQueue = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Load, "MessageQueue");
		KafkaConsumerRequestMetricsPage.navigateToKafka(messageQueue);
		page.waitForLoadState(LoadState.NETWORKIDLE);
		page.waitForTimeout(3000);
		String application = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Load, "Application");		
		KafkaConsumerRequestMetricsPage.selectServiceName(application);	
		commonPage.selectTheTimeLineFromCalender(IPathConstant.oneMonthTimeRange);
		KafkaConsumerRequestMetricsPage.navigateToConsumerTab();
		KafkaConsumerRequestMetricsPage.clickOnRequestMetricsTab();	
		KafkaConsumerRequestMetricsPage.validateRequestMetricsTabTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Consumer, "RequestMetrics_Tab_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_002_validate_Consumer_Title() throws EncryptedDocumentException, IOException {
		KafkaConsumerRequestMetricsPage.validateConsumerSelectTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Consumer, "RequestMetrics_ConsumerSelect_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_003_validate_Consumer_DropDown() throws EncryptedDocumentException, IOException {
		KafkaConsumerRequestMetricsPage.validateConsumerSelectDropDown();
	}
/*
 * Incoming Bytes Graph	
 */

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_004_validate_RequestMetrics_IncomingBytesGraph_Title() throws EncryptedDocumentException, IOException {
		KafkaConsumerRequestMetricsPage.validateIncomingBytesGraphTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Consumer, "RequestMetrics_IncomingBytes_Graph_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_005_validate_RequestMetrics_IncomingBytesGraph_ZoomIn() throws EncryptedDocumentException, IOException {
		KafkaConsumerRequestMetricsPage.validateIncomingBytesZoomInBtn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_006_validate_RequestMetrics_IncomingBytesGraph_ZoomOut() throws EncryptedDocumentException, IOException {
		KafkaConsumerRequestMetricsPage.validateIncomingBytesZoomOutBtn();
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_007_validate_RequestMetrics_IncomingBytesGraph_DragAndDrop() throws EncryptedDocumentException, IOException {
		KafkaConsumerRequestMetricsPage.validateIncomingBytesDragAndDrop();
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_008_validate_RequestMetrics_IncomingBytesGraph_XaxisTitle() throws EncryptedDocumentException, IOException {
		KafkaConsumerRequestMetricsPage.validateIncomingBytesGraphXaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Consumer, "RequestMetrics_IncomingBytes_Xaxis_Title"));
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_009_validate_RequestMetrics_IncomingBytesGraph_YaxisTitle() throws EncryptedDocumentException, IOException {
		KafkaConsumerRequestMetricsPage.validateIncomingBytesGraphYaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Consumer, "RequestMetrics_IncomingBytes_Yaxis_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_010_validate_RequestMetrics_IncomingBytesGraph_LegendTitle1() throws EncryptedDocumentException, IOException {
		KafkaConsumerRequestMetricsPage.validateIncomingBytesGraphLegendTitle1(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Consumer, "RequestMetrics_IncomingBytes_Consumer_Header_Title"));
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_011_validate_RequestMetrics_IncomingBytesGraph_LegendTitle2() throws EncryptedDocumentException, IOException {
		KafkaConsumerRequestMetricsPage.validateIncomingBytesGraphLegendTitle2(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Consumer, "RequestMetrics_IncomingBytes_Avg_Header_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_012_validate_RequestMetrics_IncomingBytesGraph_LegendTitle3() throws EncryptedDocumentException, IOException {
		KafkaConsumerRequestMetricsPage.validateIncomingBytesGraphLegendTitle3(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Consumer, "RequestMetrics_IncomingBytes_Max_Header_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_013_validate_RequestMetrics_IncomingBytesGraph_ToolTip() throws EncryptedDocumentException, IOException {
		KafkaConsumerRequestMetricsPage.validateIncomingBytesToolTipTitle();
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_014_validate_RequestMetrics_IncomingBytesGraph_ExpandViewXAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaConsumerRequestMetricsPage.validateIncomingBytesExpandViewXAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_015_validate_RequestMetrics_IncomingBytesGraph_ExpandViewYAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaConsumerRequestMetricsPage.validateIncomingBytesExpandViewYAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_016_validate_RequestMetrics_IncomingBytesGraph_ExpandViewWidgetTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaConsumerRequestMetricsPage.validateIncomingBytesExpandViewWidgetTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_017_validate_RequestMetrics_IncomingBytesGraph_ExpandViewLegendHeader1() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaConsumerRequestMetricsPage.validateIncomingBytesExpandViewLegendHeader1();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_018_validate_RequestMetrics_IncomingBytesGraph_ExpandViewLegendHeader2() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaConsumerRequestMetricsPage.validateIncomingBytesExpandViewLegendHeader2();
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_019_validate_RequestMetrics_IncomingBytesGraph_ExpandViewLegendHeader3() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaConsumerRequestMetricsPage.validateIncomingBytesExpandViewLegendHeader3();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_020_validate_RequestMetrics_IncomingBytesGraph_ExpandViewZoomInBtn() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaConsumerRequestMetricsPage.validateIncomingBytesExpandViewZoomIn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_021_validate_RequestMetrics_IncomingBytesGraph_ExpandViewZoomOutBtn() throws EncryptedDocumentException, IOException, InterruptedException {	 
		KafkaConsumerRequestMetricsPage.validateIncomingBytesExpandViewZoomOut();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_022_validate_RequestMetrics_IncomingBytesGraph_ExpandViewWidgetDragDrop() throws EncryptedDocumentException, IOException, InterruptedException {		 
		KafkaConsumerRequestMetricsPage.validateIncomingBytesExpandViewWidgetDragDrop();
	}	

/*
 *  Outgoing Bytes Graph	
 */
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_023_validate_RequestMetrics_OutgoingBytesGraph_Title() throws EncryptedDocumentException, IOException {
		KafkaConsumerRequestMetricsPage.validateOutgoingBytesGraphTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Consumer, "RequestMetrics_OutgoingBytes_Graph_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_024_validate_RequestMetrics_OutgoingBytesGraph_ZoomIn() throws EncryptedDocumentException, IOException {
		KafkaConsumerRequestMetricsPage.validateOutgoingBytesZoomInBtn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_025_validate_RequestMetrics_OutgoingBytesGraph_ZoomOut() throws EncryptedDocumentException, IOException {
		KafkaConsumerRequestMetricsPage.validateOutgoingBytesZoomOutBtn();
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_026_validate_RequestMetrics_OutgoingBytesGraph_DragAndDrop() throws EncryptedDocumentException, IOException {
		KafkaConsumerRequestMetricsPage.validateOutgoingBytesDragAndDrop();
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_027_validate_RequestMetrics_OutgoingBytesGraph_XaxisTitle() throws EncryptedDocumentException, IOException {
		KafkaConsumerRequestMetricsPage.validateOutgoingBytesGraphXaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Consumer, "RequestMetrics_OutgoingBytes_Xaxis_Title"));
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_028_validate_RequestMetrics_OutgoingBytesGraph_YaxisTitle() throws EncryptedDocumentException, IOException {
		KafkaConsumerRequestMetricsPage.validateOutgoingBytesGraphYaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Consumer, "RequestMetrics_OutgoingBytes_Yaxis_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_029_validate_RequestMetrics_OutgoingBytesGraph_LegendTitle1() throws EncryptedDocumentException, IOException {
		KafkaConsumerRequestMetricsPage.validateOutgoingBytesGraphLegendTitle1(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Consumer, "RequestMetrics_OutgoingBytes_Consumer_Header_Title"));
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_030_validate_RequestMetrics_OutgoingBytesGraph_LegendTitle2() throws EncryptedDocumentException, IOException {
		KafkaConsumerRequestMetricsPage.validateOutgoingBytesGraphLegendTitle2(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Consumer, "RequestMetrics_OutgoingBytes_Avg_Header_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_031_validate_RequestMetrics_OutgoingBytesGraph_LegendTitle3() throws EncryptedDocumentException, IOException {
		KafkaConsumerRequestMetricsPage.validateOutgoingBytesGraphLegendTitle3(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Consumer, "RequestMetrics_OutgoingBytes_Max_Header_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_032_validate_RequestMetrics_OutgoingBytesGraph_ToolTip() throws EncryptedDocumentException, IOException {
		KafkaConsumerRequestMetricsPage.validateOutgoingBytesToolTipTitle();
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_033_validate_RequestMetrics_OutgoingBytesGraph_ExpandViewXAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaConsumerRequestMetricsPage.validateOutgoingBytesExpandViewXAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_034_validate_RequestMetrics_OutgoingBytesGraph_ExpandViewYAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaConsumerRequestMetricsPage.validateOutgoingBytesExpandViewYAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_035_validate_RequestMetrics_OutgoingBytesGraph_ExpandViewWidgetTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaConsumerRequestMetricsPage.validateOutgoingBytesExpandViewWidgetTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_036_validate_RequestMetrics_OutgoingBytesGraph_ExpandViewLegendHeader1() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaConsumerRequestMetricsPage.validateOutgoingBytesExpandViewLegendHeader1();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_037_validate_RequestMetrics_OutgoingBytesGraph_ExpandViewLegendHeader2() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaConsumerRequestMetricsPage.validateOutgoingBytesExpandViewLegendHeader2();
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_038_validate_RequestMetrics_OutgoingBytesGraph_ExpandViewLegendHeader3() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaConsumerRequestMetricsPage.validateOutgoingBytesExpandViewLegendHeader3();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_039_validate_RequestMetrics_OutgoingBytesGraph_ExpandViewZoomInBtn() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaConsumerRequestMetricsPage.validateOutgoingBytesExpandViewZoomIn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_040_validate_RequestMetrics_OutgoingBytesGraph_ExpandViewZoomOutBtn() throws EncryptedDocumentException, IOException, InterruptedException {	 
		KafkaConsumerRequestMetricsPage.validateOutgoingBytesExpandViewZoomOut();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_041_validate_RequestMetrics_OutgoingBytesGraph_ExpandViewWidgetDragDrop() throws EncryptedDocumentException, IOException, InterruptedException {		 
		KafkaConsumerRequestMetricsPage.validateOutgoingBytesExpandViewWidgetDragDrop();
	}	
	
/*
 *  Average fetch latency Graph	
 */
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_042_validate_RequestMetrics_AverageFetchLatencyGraph_Title() throws EncryptedDocumentException, IOException {
		KafkaConsumerRequestMetricsPage.validateAverageFetchLatencyGraphTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Consumer, "RequestMetrics_AverageFetchLatency_Graph_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_043_validate_RequestMetrics_AverageFetchLatencyGraph_ZoomIn() throws EncryptedDocumentException, IOException {
		KafkaConsumerRequestMetricsPage.validateAverageFetchLatencyZoomInBtn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_044_validate_RequestMetrics_AverageFetchLatencyGraph_ZoomOut() throws EncryptedDocumentException, IOException {
		KafkaConsumerRequestMetricsPage.validateAverageFetchLatencyZoomOutBtn();
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_045_validate_RequestMetrics_AverageFetchLatencyGraph_DragAndDrop() throws EncryptedDocumentException, IOException {
		KafkaConsumerRequestMetricsPage.validateAverageFetchLatencyDragAndDrop();
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_046_validate_RequestMetrics_AverageFetchLatencyGraph_XaxisTitle() throws EncryptedDocumentException, IOException {
		KafkaConsumerRequestMetricsPage.validateAverageFetchLatencyGraphXaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Consumer, "RequestMetrics_AverageFetchLatency_Xaxis_Title"));
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_047_validate_RequestMetrics_AverageFetchLatencyGraph_YaxisTitle() throws EncryptedDocumentException, IOException {
		KafkaConsumerRequestMetricsPage.validateAverageFetchLatencyGraphYaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Consumer, "RequestMetrics_AverageFetchLatency_Yaxis_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_048_validate_RequestMetrics_AverageFetchLatencyGraph_LegendTitle1() throws EncryptedDocumentException, IOException {
		KafkaConsumerRequestMetricsPage.validateAverageFetchLatencyGraphLegendTitle1(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Consumer, "RequestMetrics_AverageFetchLatency_Consumer_Header_Title"));
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_049_validate_RequestMetrics_AverageFetchLatencyGraph_LegendTitle2() throws EncryptedDocumentException, IOException {
		KafkaConsumerRequestMetricsPage.validateAverageFetchLatencyGraphLegendTitle2(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Consumer, "RequestMetrics_AverageFetchLatency_Avg_Header_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_050_validate_RequestMetrics_AverageFetchLatencyGraph_LegendTitle3() throws EncryptedDocumentException, IOException {
		KafkaConsumerRequestMetricsPage.validateAverageFetchLatencyGraphLegendTitle3(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Consumer, "RequestMetrics_AverageFetchLatency_Max_Header_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_051_validate_RequestMetrics_AverageFetchLatencyGraph_ToolTip() throws EncryptedDocumentException, IOException {
		KafkaConsumerRequestMetricsPage.validateAverageFetchLatencyToolTipTitle();
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_052_validate_RequestMetrics_AverageFetchLatencyGraph_ExpandViewXAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaConsumerRequestMetricsPage.validateAverageFetchLatencyExpandViewXAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_053_validate_RequestMetrics_AverageFetchLatencyGraph_ExpandViewYAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaConsumerRequestMetricsPage.validateAverageFetchLatencyExpandViewYAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_054_validate_RequestMetrics_AverageFetchLatencyGraph_ExpandViewWidgetTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaConsumerRequestMetricsPage.validateAverageFetchLatencyExpandViewWidgetTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_055_validate_RequestMetrics_AverageFetchLatencyGraph_ExpandViewLegendHeader1() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaConsumerRequestMetricsPage.validateAverageFetchLatencyExpandViewLegendHeader1();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_056_validate_RequestMetrics_AverageFetchLatencyGraph_ExpandViewLegendHeader2() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaConsumerRequestMetricsPage.validateAverageFetchLatencyExpandViewLegendHeader2();
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_057_validate_RequestMetrics_AverageFetchLatencyGraph_ExpandViewLegendHeader3() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaConsumerRequestMetricsPage.validateAverageFetchLatencyExpandViewLegendHeader3();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_058_validate_RequestMetrics_AverageFetchLatencyGraph_ExpandViewZoomInBtn() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaConsumerRequestMetricsPage.validateAverageFetchLatencyExpandViewZoomIn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_059_validate_RequestMetrics_AverageFetchLatencyGraph_ExpandViewZoomOutBtn() throws EncryptedDocumentException, IOException, InterruptedException {	 
		KafkaConsumerRequestMetricsPage.validateAverageFetchLatencyExpandViewZoomOut();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_060_validate_RequestMetrics_AverageFetchLatencyGraph_ExpandViewWidgetDragDrop() throws EncryptedDocumentException, IOException, InterruptedException {		 
		KafkaConsumerRequestMetricsPage.validateAverageFetchLatencyExpandViewWidgetDragDrop();
	}	
	
	
/*
 *  Maximum fetch latency Graph	
 */
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_061_validate_RequestMetrics_MaximumFetchLatencyGraph_Title() throws EncryptedDocumentException, IOException {
		KafkaConsumerRequestMetricsPage.validateMaximumFetchLatencyGraphTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Consumer, "RequestMetrics_MaximumFetchLatency_Graph_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_062_validate_RequestMetrics_MaximumFetchLatencyGraph_ZoomIn() throws EncryptedDocumentException, IOException {
		KafkaConsumerRequestMetricsPage.validateMaximumFetchLatencyZoomInBtn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_063_validate_RequestMetrics_MaximumFetchLatencyGraph_ZoomOut() throws EncryptedDocumentException, IOException {
		KafkaConsumerRequestMetricsPage.validateMaximumFetchLatencyZoomOutBtn();
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_064_validate_RequestMetrics_MaximumFetchLatencyGraph_DragAndDrop() throws EncryptedDocumentException, IOException {
		KafkaConsumerRequestMetricsPage.validateMaximumFetchLatencyDragAndDrop();
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_065_validate_RequestMetrics_MaximumFetchLatencyGraph_XaxisTitle() throws EncryptedDocumentException, IOException {
		KafkaConsumerRequestMetricsPage.validateMaximumFetchLatencyGraphXaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Consumer, "RequestMetrics_MaximumFetchLatency_Xaxis_Title"));
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_066_validate_RequestMetrics_MaximumFetchLatencyGraph_YaxisTitle() throws EncryptedDocumentException, IOException {
		KafkaConsumerRequestMetricsPage.validateMaximumFetchLatencyGraphYaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Consumer, "RequestMetrics_MaximumFetchLatency_Yaxis_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_067_validate_RequestMetrics_MaximumFetchLatencyGraph_LegendTitle1() throws EncryptedDocumentException, IOException {
		KafkaConsumerRequestMetricsPage.validateMaximumFetchLatencyGraphLegendTitle1(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Consumer, "RequestMetrics_MaximumFetchLatency_Consumer_Header_Title"));
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_068_validate_RequestMetrics_MaximumFetchLatencyGraph_LegendTitle2() throws EncryptedDocumentException, IOException {
		KafkaConsumerRequestMetricsPage.validateMaximumFetchLatencyGraphLegendTitle2(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Consumer, "RequestMetrics_MaximumFetchLatency_Avg_Header_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_069_validate_RequestMetrics_MaximumFetchLatencyGraph_LegendTitle3() throws EncryptedDocumentException, IOException {
		KafkaConsumerRequestMetricsPage.validateMaximumFetchLatencyGraphLegendTitle3(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Consumer, "RequestMetrics_MaximumFetchLatency_Max_Header_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_070_validate_RequestMetrics_MaximumFetchLatencyGraph_ToolTip() throws EncryptedDocumentException, IOException {
		KafkaConsumerRequestMetricsPage.validateMaximumFetchLatencyToolTipTitle();
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_071_validate_RequestMetrics_MaximumFetchLatencyGraph_ExpandViewXAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaConsumerRequestMetricsPage.validateMaximumFetchLatencyExpandViewXAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_072_validate_RequestMetrics_MaximumFetchLatencyGraph_ExpandViewYAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaConsumerRequestMetricsPage.validateMaximumFetchLatencyExpandViewYAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_073_validate_RequestMetrics_MaximumFetchLatencyGraph_ExpandViewWidgetTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaConsumerRequestMetricsPage.validateMaximumFetchLatencyExpandViewWidgetTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_074_validate_RequestMetrics_MaximumFetchLatencyGraph_ExpandViewLegendHeader1() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaConsumerRequestMetricsPage.validateMaximumFetchLatencyExpandViewLegendHeader1();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_075_validate_RequestMetrics_MaximumFetchLatencyGraph_ExpandViewLegendHeader2() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaConsumerRequestMetricsPage.validateMaximumFetchLatencyExpandViewLegendHeader2();
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_076_validate_RequestMetrics_MaximumFetchLatencyGraph_ExpandViewLegendHeader3() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaConsumerRequestMetricsPage.validateMaximumFetchLatencyExpandViewLegendHeader3();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_077_validate_RequestMetrics_MaximumFetchLatencyGraph_ExpandViewZoomInBtn() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaConsumerRequestMetricsPage.validateMaximumFetchLatencyExpandViewZoomIn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_078_validate_RequestMetrics_MaximumFetchLatencyGraph_ExpandViewZoomOutBtn() throws EncryptedDocumentException, IOException, InterruptedException {	 
		KafkaConsumerRequestMetricsPage.validateMaximumFetchLatencyExpandViewZoomOut();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_079_validate_RequestMetrics_MaximumFetchLatencyGraph_ExpandViewWidgetDragDrop() throws EncryptedDocumentException, IOException, InterruptedException {		 
		KafkaConsumerRequestMetricsPage.validateMaximumFetchLatencyExpandViewWidgetDragDrop();
	}	

	
	
	@Test(groups= {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_080_validate_ConsumerTab_when_TimeRangeisChangedTo_5min() {
		commonPage.selectTheTimeLineFromCalender(IPathConstant.fiveMinutesTimeRange);
		KafkaConsumerRequestMetricsPage.validateXaxisValuesForKafkaConsumerRequestMetricsPage();
	}
	
	@Test(groups= {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_081_validate_ConsumerTab_when_TimeRangeisChangedTo_15min() {
		commonPage.selectTheTimeLineFromCalender(IPathConstant.fifteenMinutesTimeRange);
		KafkaConsumerRequestMetricsPage.validateXaxisValuesForKafkaConsumerRequestMetricsPage();
	}
	
	@Test(groups= {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_082_validate_ConsumerTab_when_TimeRangeisChangedTo_30min() {
		commonPage.selectTheTimeLineFromCalender(IPathConstant.thirtyMinutesTimeRange);
		KafkaConsumerRequestMetricsPage.validateXaxisValuesForKafkaConsumerRequestMetricsPage();
	}
	
	@Test(groups= {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_083_validate_ConsumerTab_when_TimeRangeisChangedTo_60min() {
		commonPage.selectTheTimeLineFromCalender(IPathConstant.sixtyMinutesTimeRange);
		KafkaConsumerRequestMetricsPage.validateXaxisValuesForKafkaConsumerRequestMetricsPage();
	}
	
	@Test(groups= {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_084_validate_ConsumerTab_when_TimeRangeisChangedTo_3hour() {
		commonPage.selectTheTimeLineFromCalender(IPathConstant.threeHoursTimeRange);
		KafkaConsumerRequestMetricsPage.validateXaxisValuesForKafkaConsumerRequestMetricsPage();
	}
	
	@Test(groups= {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_085_validate_ConsumerTab_when_TimeRangeisChangedTo_6hour() {
		commonPage.selectTheTimeLineFromCalender(IPathConstant.sixHoursTimeRange);
		KafkaConsumerRequestMetricsPage.validateXaxisValuesForKafkaConsumerRequestMetricsPage();
	}
	
	@Test(groups= {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_086_validate_ConsumerTab_when_TimeRangeisChangedTo_1Day() {
		commonPage.selectTheTimeLineFromCalender(IPathConstant.oneDayTimeRange);
		KafkaConsumerRequestMetricsPage.validateXaxisValuesForKafkaConsumerRequestMetricsPage();
	}
	
	@Test(groups= {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_087_validate_ConsumerTab_when_TimeRangeisChangedTo_1Week() {
		commonPage.selectTheTimeLineFromCalender(IPathConstant.oneWeekTimeRange);
		KafkaConsumerRequestMetricsPage.validateXaxisValuesForKafkaConsumerRequestMetricsPage();
	}
	
	@Test(groups= {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_088_validate_ConsumerTab_when_TimeRangeisChangedTo_1Month() throws EncryptedDocumentException, IOException {
		commonPage.selectTheTimeLineFromCalender(IPathConstant.oneMonthTimeRange);
		KafkaConsumerRequestMetricsPage.validateXaxisValuesForKafkaConsumerRequestMetricsPage();
	}
	
	@Test(groups= {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_089_validate_ConsumerTab_when_TimeRangeisChangedTo_4hour() throws EncryptedDocumentException, IOException {
		commonPage.selectTheCustomeTimeLine(IPathConstant.customTimeRange, excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath, IPathConstant.calenderSheet, "customHoursRange"));
		KafkaConsumerRequestMetricsPage.validateTheCustomTimeLine(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath, IPathConstant.calenderSheet, "customHoursRange"));
	}
	
	@Test(groups = {"MQM","UI","Regression"})
	public void TC_090_validate_The_All_Widgets_By_selecting_custom_Time_For_Minutes_Range() throws EncryptedDocumentException, IOException
	{	
		//select the time line from calendar
		commonPage.selectTheCustomeTimeLine(IPathConstant.customTimeRange, excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customMinutesRange") );
				
		//Validate whether the widgets are displaying the proper time line or not
		KafkaConsumerRequestMetricsPage.validateTheCustomTimeLine(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customMinutesRange"));
	}
	
	@Test(groups = {"MQM","UI","Regression"})
	public void TC_091_validate_The_All_Widgets_By_selecting_custom_Time_For_Hours_Range() throws EncryptedDocumentException, IOException
	{	
		//select the time line from calendar
		commonPage.selectTheCustomeTimeLine(IPathConstant.customTimeRange, excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customHoursRange"));

		//Validate whether the widgets are displaying the proper time line or not
		KafkaConsumerRequestMetricsPage.validateTheCustomTimeLine(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customHoursRange"));
	}
	
	@Test(groups = {"MQM","UI","Regression"})
	public void TC_092_validate_The_All_Widgets_By_selecting_custom_Time_For_Days_Range() throws EncryptedDocumentException, IOException
	{
		//select the time line from calendar
		commonPage.selectTheCustomeTimeLine(IPathConstant.customTimeRange, excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customDaysRange"));
		
		//Validate whether the widgets are displaying the proper time line or not
		KafkaConsumerRequestMetricsPage.validateTheCustomTimeLine(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customDaysRange"));
	}
		
	@Test(groups = {"MQM","UI","Regression"})
	public void TC_093_validate_The_All_Widgets_By_selecting_custom_Time_For_Future_date()
	{
		//select the time line from calendar
		commonPage.selectTheTimeLineFromCalender(IPathConstant.fiveMinutesTimeRange);
		
		//select the future time line from calendar
		commonPage.validateTheFutureTimeLine();
	}
}
