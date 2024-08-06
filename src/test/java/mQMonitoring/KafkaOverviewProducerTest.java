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
import objectRepository.MQM.KafkaOverviewProducerPage;

public class KafkaOverviewProducerTest extends BaseClass
{
	GenericMethods util = new GenericMethods();
	CommonPage commonPage;
	KafkaOverviewProducerPage KafkaOverviewProducerPage;
	ExcelUtility excel = new ExcelUtility();	

	@BeforeMethod
	public void Overview() throws EncryptedDocumentException, IOException 
	{
		commonPage = new CommonPage(page);
		KafkaOverviewProducerPage = new  KafkaOverviewProducerPage(page);
		excel = new ExcelUtility();
	}	
/**
 * Producer Tab
 * @throws EncryptedDocumentException
 * @throws IOException
 */
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_001_validate_Producer_Tab_Title() throws EncryptedDocumentException, IOException {
		commonPage.navigateToMQM();	
		String messageQueue = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Load, "MessageQueue");
		KafkaOverviewProducerPage.navigateToKafka(messageQueue);
		page.waitForLoadState(LoadState.NETWORKIDLE);
		page.waitForTimeout(3000);
		String application =excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Load, "Application");
		KafkaOverviewProducerPage.selectServiceName(application);
		commonPage.selectTheTimeLineFromCalender(IPathConstant.oneMonthTimeRange);
		page.reload();
		KafkaOverviewProducerPage.clickOnProducerTab();
		KafkaOverviewProducerPage.validateProducerTabTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Producer_Tab_Title"));
	}
	
	
/*
 * Request Rate Graph	
 */

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_002_validate_Producer_RequestRateGraph_Title() throws EncryptedDocumentException, IOException {
		KafkaOverviewProducerPage.validateRequestRateGraphTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Producer_RequestRate_Graph_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_003_validate_Producer_RequestRateGraph_ZoomIn() throws EncryptedDocumentException, IOException {	
		KafkaOverviewProducerPage.validateRequestRateZoomInBtn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_004_validate_Producer_RequestRateGraph_ZoomOut() throws EncryptedDocumentException, IOException {
		KafkaOverviewProducerPage.validateRequestRateZoomOutBtn();
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_005_validate_Producer_RequestRateGraph_DragAndDrop() throws EncryptedDocumentException, IOException {
		KafkaOverviewProducerPage.validateRequestRateDragAndDrop();
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_006_validate_Producer_RequestRateGraph_XaxisTitle() throws EncryptedDocumentException, IOException {
		KafkaOverviewProducerPage.validateRequestRateGraphXaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Producer_RequestRate_Xaxis_Title"));
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_007_validate_Producer_RequestRateGraph_YaxisTitle() throws EncryptedDocumentException, IOException {
		KafkaOverviewProducerPage.validateRequestRateGraphYaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Producer_RequestRate_Yaxis_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_008_validate_Producer_RequestRateGraph_LegendTitle1() throws EncryptedDocumentException, IOException {
		KafkaOverviewProducerPage.validateRequestRateGraphLegendTitle1(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Producer_RequestRate_Producer_Header_Title"));
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_009_validate_Producer_RequestRateGraph_LegendTitle2() throws EncryptedDocumentException, IOException {
		KafkaOverviewProducerPage.validateRequestRateGraphLegendTitle2(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Producer_RequestRate_Avg_Header_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_010_validate_Producer_RequestRateGraph_LegendTitle3() throws EncryptedDocumentException, IOException {
		KafkaOverviewProducerPage.validateRequestRateGraphLegendTitle3(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Producer_RequestRate_Max_Header_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_011_validate_Producer_RequestRateGraph_ToolTip() throws EncryptedDocumentException, IOException {
		KafkaOverviewProducerPage.validateRequestRateToolTipTitle();
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_012_validate_Producer_RequestRateGraph_ExpandViewXAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaOverviewProducerPage.validateRequestRateExpandViewXAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_013_validate_Producer_RequestRateGraph_ExpandViewYAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaOverviewProducerPage.validateRequestRateExpandViewYAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_014_validate_Producer_RequestRateGraph_ExpandViewWidgetTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaOverviewProducerPage.validateRequestRateExpandViewWidgetTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_015_validate_Producer_RequestRateGraph_ExpandViewLegendHeader1() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaOverviewProducerPage.validateRequestRateExpandViewLegendHeader1();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_016_validate_Producer_RequestRateGraph_ExpandViewLegendHeader2() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaOverviewProducerPage.validateRequestRateExpandViewLegendHeader2();
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_017_validate_Producer_RequestRateGraph_ExpandViewLegendHeader3() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaOverviewProducerPage.validateRequestRateExpandViewLegendHeader3();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_018_validate_Producer_RequestRateGraph_ExpandViewZoomInBtn() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaOverviewProducerPage.validateRequestRateExpandViewZoomIn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_019_validate_Producer_RequestRateGraph_ExpandViewZoomOutBtn() throws EncryptedDocumentException, IOException, InterruptedException {	 
		KafkaOverviewProducerPage.validateRequestRateExpandViewZoomOut();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_020_validate_Producer_RequestRateGraph_ExpandViewWidgetDragDrop() throws EncryptedDocumentException, IOException, InterruptedException {		 
		KafkaOverviewProducerPage.validateRequestRateExpandViewWidgetDragDrop();
	}	

/*
 * Response rate Graph	
 */

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_021_validate_Producer_ResponseRateGraph_Title() throws EncryptedDocumentException, IOException {
		KafkaOverviewProducerPage.validateResponseRateGraphTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Producer_ResponseRate_Graph_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_022_validate_Producer_ResponseRateGraph_ZoomIn() throws EncryptedDocumentException, IOException {	
		KafkaOverviewProducerPage.validateResponseRateZoomInBtn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_023_validate_Producer_ResponseRateGraph_ZoomOut() throws EncryptedDocumentException, IOException {
		KafkaOverviewProducerPage.validateResponseRateZoomOutBtn();
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_024_validate_Producer_ResponseRateGraph_DragAndDrop() throws EncryptedDocumentException, IOException {
		KafkaOverviewProducerPage.validateResponseRateDragAndDrop();
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_025_validate_Producer_ResponseRateGraph_XaxisTitle() throws EncryptedDocumentException, IOException {
		KafkaOverviewProducerPage.validateResponseRateGraphXaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Producer_ResponseRate_Xaxis_Title"));
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_026_validate_Producer_ResponseRateGraph_YaxisTitle() throws EncryptedDocumentException, IOException {
		KafkaOverviewProducerPage.validateResponseRateGraphYaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Producer_ResponseRate_Yaxis_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_027_validate_Producer_ResponseRateGraph_LegendTitle1() throws EncryptedDocumentException, IOException {
		KafkaOverviewProducerPage.validateResponseRateGraphLegendTitle1(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Producer_ResponseRate_Producer_Header_Title"));
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_028_validate_Producer_ResponseRateGraph_LegendTitle2() throws EncryptedDocumentException, IOException {
		KafkaOverviewProducerPage.validateResponseRateGraphLegendTitle2(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Producer_ResponseRate_Avg_Header_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_029_validate_Producer_ResponseRateGraph_LegendTitle3() throws EncryptedDocumentException, IOException {
		KafkaOverviewProducerPage.validateResponseRateGraphLegendTitle3(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Producer_ResponseRate_Max_Header_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_030_validate_Producer_ResponseRateGraph_ToolTip() throws EncryptedDocumentException, IOException {
		KafkaOverviewProducerPage.validateResponseRateToolTipTitle();
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_031_validate_Producer_ResponseRateGraph_ExpandViewXAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaOverviewProducerPage.validateResponseRateExpandViewXAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_032_validate_Producer_ResponseRateGraph_ExpandViewYAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaOverviewProducerPage.validateResponseRateExpandViewYAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_033_validate_Producer_ResponseRateGraph_ExpandViewWidgetTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaOverviewProducerPage.validateResponseRateExpandViewWidgetTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_034_validate_Producer_ResponseRateGraph_ExpandViewLegendHeader1() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaOverviewProducerPage.validateResponseRateExpandViewLegendHeader1();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_035_validate_Producer_ResponseRateGraph_ExpandViewLegendHeader2() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaOverviewProducerPage.validateResponseRateExpandViewLegendHeader2();
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_036_validate_Producer_ResponseRateGraph_ExpandViewLegendHeader3() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaOverviewProducerPage.validateResponseRateExpandViewLegendHeader3();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_037_validate_Producer_ResponseRateGraph_ExpandViewZoomInBtn() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaOverviewProducerPage.validateResponseRateExpandViewZoomIn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_038_validate_Producer_ResponseRateGraph_ExpandViewZoomOutBtn() throws EncryptedDocumentException, IOException, InterruptedException {	 
		KafkaOverviewProducerPage.validateResponseRateExpandViewZoomOut();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_039_validate_Producer_ResponseRateGraph_ExpandViewWidgetDragDrop() throws EncryptedDocumentException, IOException, InterruptedException {		 
		KafkaOverviewProducerPage.validateResponseRateExpandViewWidgetDragDrop();
	}	
	
/*
 * Error Rate Graph	
 */

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_040_validate_Producer_ErrorRateGraph_Title() throws EncryptedDocumentException, IOException {
		KafkaOverviewProducerPage.validateErrorRateGraphTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Producer_ErrorRate_Graph_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_041_validate_Producer_ErrorRateGraph_ZoomIn() throws EncryptedDocumentException, IOException {	
		KafkaOverviewProducerPage.validateErrorRateZoomInBtn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_042_validate_Producer_ErrorRateGraph_ZoomOut() throws EncryptedDocumentException, IOException {
		KafkaOverviewProducerPage.validateErrorRateZoomOutBtn();
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_043_validate_Producer_ErrorRateGraph_DragAndDrop() throws EncryptedDocumentException, IOException {
		KafkaOverviewProducerPage.validateErrorRateDragAndDrop();
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_044_validate_Producer_ErrorRateGraph_XaxisTitle() throws EncryptedDocumentException, IOException {
		KafkaOverviewProducerPage.validateErrorRateGraphXaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Producer_ErrorRate_Xaxis_Title"));
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_045_validate_Producer_ErrorRateGraph_YaxisTitle() throws EncryptedDocumentException, IOException {
		KafkaOverviewProducerPage.validateErrorRateGraphYaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Producer_ErrorRate_Yaxis_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_046_validate_Producer_ErrorRateGraph_LegendTitle1() throws EncryptedDocumentException, IOException {
		KafkaOverviewProducerPage.validateErrorRateGraphLegendTitle1(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Producer_ErrorRate_Producer_Header_Title"));
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_047_validate_Producer_ErrorRateGraph_LegendTitle2() throws EncryptedDocumentException, IOException {
		KafkaOverviewProducerPage.validateErrorRateGraphLegendTitle2(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Producer_ErrorRate_Avg_Header_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_048_validate_Producer_ErrorRateGraph_LegendTitle3() throws EncryptedDocumentException, IOException {
		KafkaOverviewProducerPage.validateErrorRateGraphLegendTitle3(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Producer_ErrorRate_Max_Header_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_049_validate_Producer_ErrorRateGraph_ToolTip() throws EncryptedDocumentException, IOException {
		KafkaOverviewProducerPage.validateErrorRateToolTipTitle();
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_050_validate_Producer_ErrorRateGraph_ExpandViewXAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaOverviewProducerPage.validateErrorRateExpandViewXAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_051_validate_Producer_ErrorRateGraph_ExpandViewYAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaOverviewProducerPage.validateErrorRateExpandViewYAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_052_validate_Producer_ErrorRateGraph_ExpandViewWidgetTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaOverviewProducerPage.validateErrorRateExpandViewWidgetTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_053_validate_Producer_ErrorRateGraph_ExpandViewLegendHeader1() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaOverviewProducerPage.validateErrorRateExpandViewLegendHeader1();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_054_validate_Producer_ErrorRateGraph_ExpandViewLegendHeader2() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaOverviewProducerPage.validateErrorRateExpandViewLegendHeader2();
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_055_validate_Producer_ErrorRateGraph_ExpandViewLegendHeader3() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaOverviewProducerPage.validateErrorRateExpandViewLegendHeader3();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_056_validate_Producer_ErrorRateGraph_ExpandViewZoomInBtn() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaOverviewProducerPage.validateErrorRateExpandViewZoomIn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_057_validate_Producer_ErrorRateGraph_ExpandViewZoomOutBtn() throws EncryptedDocumentException, IOException, InterruptedException {	 
		KafkaOverviewProducerPage.validateErrorRateExpandViewZoomOut();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_058_validate_Producer_ErrorRateGraph_ExpandViewWidgetDragDrop() throws EncryptedDocumentException, IOException, InterruptedException {		 
		KafkaOverviewProducerPage.validateErrorRateExpandViewWidgetDragDrop();
	}	
	
/*
 * Request avg latency Graph	
 */

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_059_validate_Producer_RequestAvgLatencyGraph_Title() throws EncryptedDocumentException, IOException {
		KafkaOverviewProducerPage.validateRequestAvgLatencyGraphTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Producer_RequestAvgLatency_Graph_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_060_validate_Producer_RequestAvgLatencyGraph_ZoomIn() throws EncryptedDocumentException, IOException {	
		KafkaOverviewProducerPage.validateRequestAvgLatencyZoomInBtn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_061_validate_Producer_RequestAvgLatencyGraph_ZoomOut() throws EncryptedDocumentException, IOException {
		KafkaOverviewProducerPage.validateRequestAvgLatencyZoomOutBtn();
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_062_validate_Producer_RequestAvgLatencyGraph_DragAndDrop() throws EncryptedDocumentException, IOException {
		KafkaOverviewProducerPage.validateRequestAvgLatencyDragAndDrop();
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_063_validate_Producer_RequestAvgLatencyGraph_XaxisTitle() throws EncryptedDocumentException, IOException {
		KafkaOverviewProducerPage.validateRequestAvgLatencyGraphXaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Producer_RequestAvgLatency_Xaxis_Title"));
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_064_validate_Producer_RequestAvgLatencyGraph_YaxisTitle() throws EncryptedDocumentException, IOException {
		KafkaOverviewProducerPage.validateRequestAvgLatencyGraphYaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Producer_RequestAvgLatency_Yaxis_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_065_validate_Producer_RequestAvgLatencyGraph_LegendTitle1() throws EncryptedDocumentException, IOException {
		KafkaOverviewProducerPage.validateRequestAvgLatencyGraphLegendTitle1(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Producer_RequestAvgLatency_Producer_Header_Title"));
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_066_validate_Producer_RequestAvgLatencyGraph_LegendTitle2() throws EncryptedDocumentException, IOException {
		KafkaOverviewProducerPage.validateRequestAvgLatencyGraphLegendTitle2(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Producer_RequestAvgLatency_Avg_Header_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_067_validate_Producer_RequestAvgLatencyGraph_LegendTitle3() throws EncryptedDocumentException, IOException {
		KafkaOverviewProducerPage.validateRequestAvgLatencyGraphLegendTitle3(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Producer_RequestAvgLatency_Max_Header_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_068_validate_Producer_RequestAvgLatencyGraph_ToolTip() throws EncryptedDocumentException, IOException {
		KafkaOverviewProducerPage.validateRequestAvgLatencyToolTipTitle();
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_069_validate_Producer_RequestAvgLatencyGraph_ExpandViewXAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaOverviewProducerPage.validateRequestAvgLatencyExpandViewXAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_070_validate_Producer_RequestAvgLatencyGraph_ExpandViewYAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		page.reload();
		KafkaOverviewProducerPage.clickOnProducerTab();
		KafkaOverviewProducerPage.validateRequestAvgLatencyExpandViewYAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_071_validate_Producer_RequestAvgLatencyGraph_ExpandViewWidgetTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaOverviewProducerPage.validateRequestAvgLatencyExpandViewWidgetTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_072_validate_Producer_RequestAvgLatencyGraph_ExpandViewLegendHeader1() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaOverviewProducerPage.validateRequestAvgLatencyExpandViewLegendHeader1();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_073_validate_Producer_RequestAvgLatencyGraph_ExpandViewLegendHeader2() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaOverviewProducerPage.validateRequestAvgLatencyExpandViewLegendHeader2();
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_074_validate_Producer_RequestAvgLatencyGraph_ExpandViewLegendHeader3() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaOverviewProducerPage.validateRequestAvgLatencyExpandViewLegendHeader3();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_075_validate_Producer_RequestAvgLatencyGraph_ExpandViewZoomInBtn() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaOverviewProducerPage.validateRequestAvgLatencyExpandViewZoomIn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_076_validate_Producer_RequestAvgLatencyGraph_ExpandViewZoomOutBtn() throws EncryptedDocumentException, IOException, InterruptedException {	 
		KafkaOverviewProducerPage.validateRequestAvgLatencyExpandViewZoomOut();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_077_validate_Producer_RequestAvgLatencyGraph_ExpandViewWidgetDragDrop() throws EncryptedDocumentException, IOException, InterruptedException {		 
		KafkaOverviewProducerPage.validateRequestAvgLatencyExpandViewWidgetDragDrop();
	}	
	
/*
 * No. Of Producers Graph	
 */

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_078_validate_Producer_NoOfProducersGraph_Title() throws EncryptedDocumentException, IOException {
		KafkaOverviewProducerPage.validateNoOfProducersGraphTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Producer_NoOfProducers_Graph_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_079_validate_Producer_NoOfProducersGraph_ZoomIn() throws EncryptedDocumentException, IOException {	
		KafkaOverviewProducerPage.validateNoOfProducersZoomInBtn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_080_validate_Producer_NoOfProducersGraph_ZoomOut() throws EncryptedDocumentException, IOException {
		KafkaOverviewProducerPage.validateNoOfProducersZoomOutBtn();
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_080_validate_Producer_NoOfProducersGraph_ZoomReset() throws EncryptedDocumentException, IOException {
		KafkaOverviewProducerPage.validateNoOfProducersZoomResetBtn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_081_validate_Producer_NoOfProducersGraph_DragAndDrop() throws EncryptedDocumentException, IOException {
		KafkaOverviewProducerPage.validateNoOfProducersDragAndDrop();
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_082_validate_Producer_NoOfProducersGraph_XaxisTitle() throws EncryptedDocumentException, IOException {
		KafkaOverviewProducerPage.validateNoOfProducersGraphXaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Producer_NoOfProducers_Xaxis_Title"));
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_083_validate_Producer_NoOfProducersGraph_YaxisTitle() throws EncryptedDocumentException, IOException {
		KafkaOverviewProducerPage.validateNoOfProducersGraphYaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Producer_NoOfProducers_Yaxis_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_084_validate_Producer_NoOfProducersGraph_ToolTip() throws EncryptedDocumentException, IOException {
		KafkaOverviewProducerPage.validateNoOfProducersToolTipTitle();
	}

	@Test(groups= {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_085_validate_ConsumerTab_when_TimeRangeisChangedTo_5min() {
		commonPage.selectTheTimeLineFromCalender(IPathConstant.fiveMinutesTimeRange);
		KafkaOverviewProducerPage.validateXaxisValuesForKafkaOverviewProducerPage();
	}
	@Test(groups= {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_096_validate_ConsumerTab_when_TimeRangeisChangedTo_15min() {
		commonPage.selectTheTimeLineFromCalender(IPathConstant.fifteenMinutesTimeRange);
		KafkaOverviewProducerPage.validateXaxisValuesForKafkaOverviewProducerPage();
	}
	@Test(groups= {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_087_validate_ConsumerTab_when_TimeRangeisChangedTo_30min() {
		commonPage.selectTheTimeLineFromCalender(IPathConstant.thirtyMinutesTimeRange);
		KafkaOverviewProducerPage.validateXaxisValuesForKafkaOverviewProducerPage();
	}
	@Test(groups= {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_088_validate_ConsumerTab_when_TimeRangeisChangedTo_60min() {
		commonPage.selectTheTimeLineFromCalender(IPathConstant.sixtyMinutesTimeRange);
		KafkaOverviewProducerPage.validateXaxisValuesForKafkaOverviewProducerPage();
	}
	@Test(groups= {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_089_validate_ConsumerTab_when_TimeRangeisChangedTo_3hour() {
		commonPage.selectTheTimeLineFromCalender(IPathConstant.threeHoursTimeRange);
		KafkaOverviewProducerPage.validateXaxisValuesForKafkaOverviewProducerPage();
	}
	@Test(groups= {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_090_validate_ConsumerTab_when_TimeRangeisChangedTo_6hour() {
		commonPage.selectTheTimeLineFromCalender(IPathConstant.sixHoursTimeRange);
		KafkaOverviewProducerPage.validateXaxisValuesForKafkaOverviewProducerPage();
	}
	@Test(groups= {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_091_validate_ConsumerTab_when_TimeRangeisChangedTo_1Day() {
		commonPage.selectTheTimeLineFromCalender(IPathConstant.oneDayTimeRange);
		KafkaOverviewProducerPage.validateXaxisValuesForKafkaOverviewProducerPage();
	}
	@Test(groups= {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_092_validate_ConsumerTab_when_TimeRangeisChangedTo_1Week() {
		commonPage.selectTheTimeLineFromCalender(IPathConstant.oneWeekTimeRange);
		KafkaOverviewProducerPage.validateXaxisValuesForKafkaOverviewProducerPage();
	}
	@Test(groups= {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_093_validate_ConsumerTab_when_TimeRangeisChangedTo_1Month() {
		commonPage.selectTheTimeLineFromCalender(IPathConstant.oneMonthTimeRange);
		KafkaOverviewProducerPage.validateXaxisValuesForKafkaOverviewProducerPage();
	}
	@Test(groups= {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_094_validate_ConsumerTab_when_TimeRangeisChangedTo_4hour() throws EncryptedDocumentException, IOException {
		commonPage.selectTheCustomeTimeLine(IPathConstant.customTimeRange, excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath, IPathConstant.calenderSheet, "customHoursRange"));
		KafkaOverviewProducerPage.validateTheCustomTimeLine(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath, IPathConstant.calenderSheet, "customHoursRange"));
	}
	
	@Test(groups = {"MQM","UI","Regression"})
	public void TC_095_validate_The_All_Widgets_By_selecting_custom_Time_For_Minutes_Range() throws EncryptedDocumentException, IOException
	{	
		//select the time line from calendar
		commonPage.selectTheCustomeTimeLine(IPathConstant.customTimeRange, excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customMinutesRange") );
				
		//Validate whether the widgets are displaying the proper time line or not
		KafkaOverviewProducerPage.validateTheCustomTimeLine(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customMinutesRange"));
	}
	@Test(groups = {"MQM","UI","Regression"})
	public void TC_096_validate_The_All_Widgets_By_selecting_custom_Time_For_Hours_Range() throws EncryptedDocumentException, IOException
	{	
		//select the time line from calendar
		commonPage.selectTheCustomeTimeLine(IPathConstant.customTimeRange, excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customHoursRange"));

		//Validate whether the widgets are displaying the proper time line or not
		KafkaOverviewProducerPage.validateTheCustomTimeLine(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customHoursRange"));
	}
	@Test(groups = {"MQM","UI","Regression"})
	public void TC_097_validate_The_All_Widgets_By_selecting_custom_Time_For_Days_Range() throws EncryptedDocumentException, IOException
	{
		//select the time line from calendar
		commonPage.selectTheCustomeTimeLine(IPathConstant.customTimeRange, excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customDaysRange"));
		
		//Validate whether the widgets are displaying the proper time line or not
		KafkaOverviewProducerPage.validateTheCustomTimeLine(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customDaysRange"));
	}
	
	
	@Test(groups = {"MQM","UI","Regression"})
	public void TC_098_validate_The_All_Widgets_By_selecting_custom_Time_For_Future_date()
	{
		//select the time line from calendar
		commonPage.selectTheTimeLineFromCalender(IPathConstant.fiveMinutesTimeRange);
		
		//select the future time line from calendar
		commonPage.validateTheFutureTimeLine();
	}
}
