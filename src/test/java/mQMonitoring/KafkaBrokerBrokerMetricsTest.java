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
import objectRepository.MQM.KafkaBrokerBrokerMetricsPage;

public class KafkaBrokerBrokerMetricsTest extends BaseClass
{
	GenericMethods util = new GenericMethods();
	CommonPage commonPage;
	KafkaBrokerBrokerMetricsPage KafkaBrokerBrokerMetricsPage;
	ExcelUtility excel = new ExcelUtility();	

	@BeforeMethod
	public void Broker() throws EncryptedDocumentException, IOException 
	{
		commonPage = new CommonPage(page);
		KafkaBrokerBrokerMetricsPage = new KafkaBrokerBrokerMetricsPage(page);
		excel = new ExcelUtility();
	}
	
/**
 * BrokerMetrics Tab
 * @throws EncryptedDocumentException
 * @throws IOException
 */
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_001_validate_BrokerMetrics_Tab_Title() throws EncryptedDocumentException, IOException {
		commonPage.navigateToMQM();	
		String messageQueue = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Load, "MessageQueue");
		KafkaBrokerBrokerMetricsPage.navigateToKafka(messageQueue);
		page.waitForLoadState(LoadState.NETWORKIDLE);
		page.waitForTimeout(3000);
		String application = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Load, "Application");
		KafkaBrokerBrokerMetricsPage.selectServiceName(application);
		commonPage.selectTheTimeLineFromCalender(IPathConstant.oneMonthTimeRange);
		KafkaBrokerBrokerMetricsPage.navigateToBrokerTab();
		KafkaBrokerBrokerMetricsPage.clickOnBrokerMetricsTab();
		KafkaBrokerBrokerMetricsPage.validateBrokerMetricsTabTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Broker, "BrokerMetrics_Tab_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_002_validate_Broker_Title() throws EncryptedDocumentException, IOException {
		KafkaBrokerBrokerMetricsPage.validateBrokerSelectTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Broker, "Broker_BrokerSelect_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_003_validate_Broker_DropDown() throws EncryptedDocumentException, IOException {
		KafkaBrokerBrokerMetricsPage.validateBrokerSelectDropDown();
	}
	
/*
 * Bytes in per second Graph	
 */

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_004_validate_BrokerMetrics_JVMCPUGraph_Title() throws EncryptedDocumentException, IOException {
		KafkaBrokerBrokerMetricsPage.validateJVMCPUGraphTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Broker, "BrokerMetrics_JVMCPU_Graph_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_005_validate_BrokerMetrics_JVMCPUGraph_ZoomIn() throws EncryptedDocumentException, IOException {
		KafkaBrokerBrokerMetricsPage.validateJVMCPUZoomInBtn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_006_validate_BrokerMetrics_JVMCPUGraph_ZoomOut() throws EncryptedDocumentException, IOException {
		KafkaBrokerBrokerMetricsPage.validateJVMCPUZoomOutBtn();
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_007_validate_BrokerMetrics_JVMCPUGraph_DragAndDrop() throws EncryptedDocumentException, IOException {
		KafkaBrokerBrokerMetricsPage.validateJVMCPUDragAndDrop();
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_008_validate_BrokerMetrics_JVMCPUGraph_XaxisTitle() throws EncryptedDocumentException, IOException {
		KafkaBrokerBrokerMetricsPage.validateJVMCPUGraphXaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Broker, "BrokerMetrics_JVMCPU_Xaxis_Title"));
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_009_validate_BrokerMetrics_JVMCPUGraph_YaxisTitle() throws EncryptedDocumentException, IOException {
		KafkaBrokerBrokerMetricsPage.validateJVMCPUGraphYaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Broker, "BrokerMetrics_JVMCPU_Yaxis_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_010_validate_BrokerMetrics_JVMCPUGraph_LegendTitle1() throws EncryptedDocumentException, IOException {
		KafkaBrokerBrokerMetricsPage.validateJVMCPUGraphLegendTitle1(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Broker, "BrokerMetrics_JVMCPU_Broker_Header_Title"));
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_011_validate_BrokerMetrics_JVMCPUGraph_LegendTitle2() throws EncryptedDocumentException, IOException {
		KafkaBrokerBrokerMetricsPage.validateJVMCPUGraphLegendTitle2(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Broker, "BrokerMetrics_JVMCPU_Avg_Header_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_012_validate_BrokerMetrics_JVMCPUGraph_LegendTitle3() throws EncryptedDocumentException, IOException {
		KafkaBrokerBrokerMetricsPage.validateJVMCPUGraphLegendTitle3(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Broker, "BrokerMetrics_JVMCPU_Max_Header_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_013_validate_BrokerMetrics_JVMCPUGraph_ToolTip() throws EncryptedDocumentException, IOException {
		KafkaBrokerBrokerMetricsPage.validateJVMCPUToolTipTitle();
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_014_validate_BrokerMetrics_JVMCPUGraph_ExpandViewXAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaBrokerBrokerMetricsPage.validateJVMCPUExpandViewXAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_015_validate_BrokerMetrics_JVMCPUGraph_ExpandViewYAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaBrokerBrokerMetricsPage.validateJVMCPUExpandViewYAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_016_validate_BrokerMetrics_JVMCPUGraph_ExpandViewWidgetTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaBrokerBrokerMetricsPage.validateJVMCPUExpandViewWidgetTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_017_validate_BrokerMetrics_JVMCPUGraph_ExpandViewLegendHeader1() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaBrokerBrokerMetricsPage.validateJVMCPUExpandViewLegendHeader1();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_018_validate_BrokerMetrics_JVMCPUGraph_ExpandViewLegendHeader2() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaBrokerBrokerMetricsPage.validateJVMCPUExpandViewLegendHeader2();
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_019_validate_BrokerMetrics_JVMCPUGraph_ExpandViewLegendHeader3() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaBrokerBrokerMetricsPage.validateJVMCPUExpandViewLegendHeader3();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_020_validate_BrokerMetrics_JVMCPUGraph_ExpandViewZoomInBtn() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaBrokerBrokerMetricsPage.validateJVMCPUExpandViewZoomIn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_021_validate_BrokerMetrics_JVMCPUGraph_ExpandViewZoomOutBtn() throws EncryptedDocumentException, IOException, InterruptedException {	 
		KafkaBrokerBrokerMetricsPage.validateJVMCPUExpandViewZoomOut();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_022_validate_BrokerMetrics_JVMCPUGraph_ExpandViewWidgetDragDrop() throws EncryptedDocumentException, IOException, InterruptedException {		 
		KafkaBrokerBrokerMetricsPage.validateJVMCPUExpandViewWidgetDragDrop();
	}	
	
/*
 *  JVM Memory Graph	
 */
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_023_validate_BrokerMetrics_JVMMemoryGraph_Title() throws EncryptedDocumentException, IOException {
		KafkaBrokerBrokerMetricsPage.validateJVMMemoryGraphTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Broker, "BrokerMetrics_JVMMemory_Graph_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_024_validate_BrokerMetrics_JVMMemoryGraph_ZoomIn() throws EncryptedDocumentException, IOException {
		KafkaBrokerBrokerMetricsPage.validateJVMMemoryZoomInBtn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_025_validate_BrokerMetrics_JVMMemoryGraph_ZoomOut() throws EncryptedDocumentException, IOException {
		KafkaBrokerBrokerMetricsPage.validateJVMMemoryZoomOutBtn();
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_026_validate_BrokerMetrics_JVMMemoryGraph_DragAndDrop() throws EncryptedDocumentException, IOException {
		KafkaBrokerBrokerMetricsPage.validateJVMMemoryDragAndDrop();
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_027_validate_BrokerMetrics_JVMMemoryGraph_XaxisTitle() throws EncryptedDocumentException, IOException {
		KafkaBrokerBrokerMetricsPage.validateJVMMemoryGraphXaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Broker, "BrokerMetrics_JVMMemory_Xaxis_Title"));
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_028_validate_BrokerMetrics_JVMMemoryGraph_YaxisTitle() throws EncryptedDocumentException, IOException {
		KafkaBrokerBrokerMetricsPage.validateJVMMemoryGraphYaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Broker, "BrokerMetrics_JVMMemory_Yaxis_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_029_validate_BrokerMetrics_JVMMemoryGraph_LegendTitle1() throws EncryptedDocumentException, IOException {
		KafkaBrokerBrokerMetricsPage.validateJVMMemoryGraphLegendTitle1(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Broker, "BrokerMetrics_JVMMemory_Broker_Header_Title"));
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_030_validate_BrokerMetrics_JVMMemoryGraph_LegendTitle2() throws EncryptedDocumentException, IOException {
		KafkaBrokerBrokerMetricsPage.validateJVMMemoryGraphLegendTitle2(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Broker, "BrokerMetrics_JVMMemory_Avg_Header_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_031_validate_BrokerMetrics_JVMMemoryGraph_LegendTitle3() throws EncryptedDocumentException, IOException {
		KafkaBrokerBrokerMetricsPage.validateJVMMemoryGraphLegendTitle3(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Broker, "BrokerMetrics_JVMMemory_Max_Header_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_032_validate_BrokerMetrics_JVMMemoryGraph_ToolTip() throws EncryptedDocumentException, IOException {
		KafkaBrokerBrokerMetricsPage.validateJVMMemoryToolTipTitle();
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_033_validate_BrokerMetrics_JVMMemoryGraph_ExpandViewXAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaBrokerBrokerMetricsPage.validateJVMMemoryExpandViewXAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_034_validate_BrokerMetrics_JVMMemoryGraph_ExpandViewYAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaBrokerBrokerMetricsPage.validateJVMMemoryExpandViewYAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_035_validate_BrokerMetrics_JVMMemoryGraph_ExpandViewWidgetTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaBrokerBrokerMetricsPage.validateJVMMemoryExpandViewWidgetTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_036_validate_BrokerMetrics_JVMMemoryGraph_ExpandViewLegendHeader1() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaBrokerBrokerMetricsPage.validateJVMMemoryExpandViewLegendHeader1();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_037_validate_BrokerMetrics_JVMMemoryGraph_ExpandViewLegendHeader2() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaBrokerBrokerMetricsPage.validateJVMMemoryExpandViewLegendHeader2();
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_038_validate_BrokerMetrics_JVMMemoryGraph_ExpandViewLegendHeader3() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaBrokerBrokerMetricsPage.validateJVMMemoryExpandViewLegendHeader3();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_039_validate_BrokerMetrics_JVMMemoryGraph_ExpandViewZoomInBtn() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaBrokerBrokerMetricsPage.validateJVMMemoryExpandViewZoomIn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_040_validate_BrokerMetrics_JVMMemoryGraph_ExpandViewZoomOutBtn() throws EncryptedDocumentException, IOException, InterruptedException {	 
		KafkaBrokerBrokerMetricsPage.validateJVMMemoryExpandViewZoomOut();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_041_validate_BrokerMetrics_JVMMemoryGraph_ExpandViewWidgetDragDrop() throws EncryptedDocumentException, IOException, InterruptedException {		 
		KafkaBrokerBrokerMetricsPage.validateJVMMemoryExpandViewWidgetDragDrop();
	}	
	
/*
 * GC time Graph	
 */
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_042_validate_BrokerMetrics_GCTimeGraph_Title() throws EncryptedDocumentException, IOException {
		KafkaBrokerBrokerMetricsPage.validateGCTimeGraphTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Broker, "BrokerMetrics_GCTime_Graph_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_043_validate_BrokerMetrics_GCTimeGraph_ZoomIn() throws EncryptedDocumentException, IOException {
		KafkaBrokerBrokerMetricsPage.validateGCTimeZoomInBtn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_044_validate_BrokerMetrics_GCTimeGraph_ZoomOut() throws EncryptedDocumentException, IOException {
		KafkaBrokerBrokerMetricsPage.validateGCTimeZoomOutBtn();
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_045_validate_BrokerMetrics_GCTimeGraph_DragAndDrop() throws EncryptedDocumentException, IOException {
		KafkaBrokerBrokerMetricsPage.validateGCTimeDragAndDrop();
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_046_validate_BrokerMetrics_GCTimeGraph_XaxisTitle() throws EncryptedDocumentException, IOException {
		KafkaBrokerBrokerMetricsPage.validateGCTimeGraphXaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Broker, "BrokerMetrics_GCTime_Xaxis_Title"));
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_047_validate_BrokerMetrics_GCTimeGraph_YaxisTitle() throws EncryptedDocumentException, IOException {
		KafkaBrokerBrokerMetricsPage.validateGCTimeGraphYaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Broker, "BrokerMetrics_GCTime_Yaxis_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_048_validate_BrokerMetrics_GCTimeGraph_LegendTitle1() throws EncryptedDocumentException, IOException {
		KafkaBrokerBrokerMetricsPage.validateGCTimeGraphLegendTitle1(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Broker, "BrokerMetrics_GCTime_Broker_Header_Title"));
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_049_validate_BrokerMetrics_GCTimeGraph_LegendTitle2() throws EncryptedDocumentException, IOException {
		KafkaBrokerBrokerMetricsPage.validateGCTimeGraphLegendTitle2(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Broker, "BrokerMetrics_GCTime_Avg_Header_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_050_validate_BrokerMetrics_GCTimeGraph_LegendTitle3() throws EncryptedDocumentException, IOException {
		KafkaBrokerBrokerMetricsPage.validateGCTimeGraphLegendTitle3(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Broker, "BrokerMetrics_GCTime_Max_Header_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_051_validate_BrokerMetrics_GCTimeGraph_ToolTip() throws EncryptedDocumentException, IOException {
		KafkaBrokerBrokerMetricsPage.validateGCTimeToolTipTitle();
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_052_validate_BrokerMetrics_GCTimeGraph_ExpandViewXAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaBrokerBrokerMetricsPage.validateGCTimeExpandViewXAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_053_validate_BrokerMetrics_GCTimeGraph_ExpandViewYAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		page.reload();
		KafkaBrokerBrokerMetricsPage.clickOnBrokerMetricsTab();	
		KafkaBrokerBrokerMetricsPage.validateGCTimeExpandViewYAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_054_validate_BrokerMetrics_GCTimeGraph_ExpandViewWidgetTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaBrokerBrokerMetricsPage.validateGCTimeExpandViewWidgetTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_055_validate_BrokerMetrics_GCTimeGraph_ExpandViewLegendHeader1() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaBrokerBrokerMetricsPage.validateGCTimeExpandViewLegendHeader1();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_056_validate_BrokerMetrics_GCTimeGraph_ExpandViewLegendHeader2() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaBrokerBrokerMetricsPage.validateGCTimeExpandViewLegendHeader2();
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_057_validate_BrokerMetrics_GCTimeGraph_ExpandViewLegendHeader3() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaBrokerBrokerMetricsPage.validateGCTimeExpandViewLegendHeader3();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_058_validate_BrokerMetrics_GCTimeGraph_ExpandViewZoomInBtn() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaBrokerBrokerMetricsPage.validateGCTimeExpandViewZoomIn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_059_validate_BrokerMetrics_GCTimeGraph_ExpandViewZoomOutBtn() throws EncryptedDocumentException, IOException, InterruptedException {	 
		KafkaBrokerBrokerMetricsPage.validateGCTimeExpandViewZoomOut();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_060_validate_BrokerMetrics_GCTimeGraph_ExpandViewWidgetDragDrop() throws EncryptedDocumentException, IOException, InterruptedException {		 
		page.reload();
		KafkaBrokerBrokerMetricsPage.clickOnBrokerMetricsTab();
		KafkaBrokerBrokerMetricsPage.validateGCTimeExpandViewWidgetDragDrop();
	}	
	
	
/*
 *  GC Count Graph	
 */
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_061_validate_BrokerMetrics_GCCountGraph_Title() throws EncryptedDocumentException, IOException {
		KafkaBrokerBrokerMetricsPage.validateGCCountGraphTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Broker, "BrokerMetrics_GCCount_Graph_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_062_validate_BrokerMetrics_GCCountGraph_ZoomIn() throws EncryptedDocumentException, IOException {
		page.reload();
		KafkaBrokerBrokerMetricsPage.clickOnBrokerMetricsTab();
		KafkaBrokerBrokerMetricsPage.validateGCCountZoomInBtn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_063_validate_BrokerMetrics_GCCountGraph_ZoomOut() throws EncryptedDocumentException, IOException {
		KafkaBrokerBrokerMetricsPage.validateGCCountZoomOutBtn();
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_064_validate_BrokerMetrics_GCCountGraph_DragAndDrop() throws EncryptedDocumentException, IOException {
		KafkaBrokerBrokerMetricsPage.validateGCCountDragAndDrop();
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_065_validate_BrokerMetrics_GCCountGraph_XaxisTitle() throws EncryptedDocumentException, IOException {
		KafkaBrokerBrokerMetricsPage.validateGCCountGraphXaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Broker, "BrokerMetrics_GCCount_Xaxis_Title"));
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_066_validate_BrokerMetrics_GCCountGraph_YaxisTitle() throws EncryptedDocumentException, IOException {
		KafkaBrokerBrokerMetricsPage.validateGCCountGraphYaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Broker, "BrokerMetrics_GCCount_Yaxis_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_067_validate_BrokerMetrics_GCCountGraph_LegendTitle1() throws EncryptedDocumentException, IOException {
		KafkaBrokerBrokerMetricsPage.validateGCCountGraphLegendTitle1(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Broker, "BrokerMetrics_GCCount_Broker_Header_Title"));
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_068_validate_BrokerMetrics_GCCountGraph_LegendTitle2() throws EncryptedDocumentException, IOException {
		KafkaBrokerBrokerMetricsPage.validateGCCountGraphLegendTitle2(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Broker, "BrokerMetrics_GCCount_Avg_Header_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_069_validate_BrokerMetrics_GCCountGraph_LegendTitle3() throws EncryptedDocumentException, IOException {
		KafkaBrokerBrokerMetricsPage.validateGCCountGraphLegendTitle3(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Broker, "BrokerMetrics_GCCount_Max_Header_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_070_validate_BrokerMetrics_GCCountGraph_ToolTip() throws EncryptedDocumentException, IOException {
		KafkaBrokerBrokerMetricsPage.validateGCCountToolTipTitle();
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_071_validate_BrokerMetrics_GCCountGraph_ExpandViewXAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaBrokerBrokerMetricsPage.validateGCCountExpandViewXAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_072_validate_BrokerMetrics_GCCountGraph_ExpandViewYAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		page.reload();
		KafkaBrokerBrokerMetricsPage.clickOnBrokerMetricsTab();	
		KafkaBrokerBrokerMetricsPage.validateGCCountExpandViewYAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_073_validate_BrokerMetrics_GCCountGraph_ExpandViewWidgetTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaBrokerBrokerMetricsPage.validateGCCountExpandViewWidgetTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_074_validate_BrokerMetrics_GCCountGraph_ExpandViewLegendHeader1() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaBrokerBrokerMetricsPage.validateGCCountExpandViewLegendHeader1();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_075_validate_BrokerMetrics_GCCountGraph_ExpandViewLegendHeader2() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaBrokerBrokerMetricsPage.validateGCCountExpandViewLegendHeader2();
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_076_validate_BrokerMetrics_GCCountGraph_ExpandViewLegendHeader3() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaBrokerBrokerMetricsPage.validateGCCountExpandViewLegendHeader3();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_077_validate_BrokerMetrics_GCCountGraph_ExpandViewZoomInBtn() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaBrokerBrokerMetricsPage.validateGCCountExpandViewZoomIn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_078_validate_BrokerMetrics_GCCountGraph_ExpandViewZoomOutBtn() throws EncryptedDocumentException, IOException, InterruptedException {	 
		KafkaBrokerBrokerMetricsPage.validateGCCountExpandViewZoomOut();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_079_validate_BrokerMetrics_GCCountGraph_ExpandViewWidgetDragDrop() throws EncryptedDocumentException, IOException, InterruptedException {		 
		KafkaBrokerBrokerMetricsPage.validateGCCountExpandViewWidgetDragDrop();
	}	
	
/*
 * Thread Count Graph	
 */
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_080_validate_BrokerMetrics_ThreadCountGraph_Title() throws EncryptedDocumentException, IOException {
		KafkaBrokerBrokerMetricsPage.validateThreadCountGraphTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Broker, "BrokerMetrics_ThreadCount_Graph_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_081_validate_BrokerMetrics_ThreadCountGraph_ZoomIn() throws EncryptedDocumentException, IOException {
		KafkaBrokerBrokerMetricsPage.validateThreadCountZoomInBtn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_082_validate_BrokerMetrics_ThreadCountGraph_ZoomOut() throws EncryptedDocumentException, IOException {
		KafkaBrokerBrokerMetricsPage.validateThreadCountZoomOutBtn();
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_083_validate_BrokerMetrics_ThreadCountGraph_DragAndDrop() throws EncryptedDocumentException, IOException {
		KafkaBrokerBrokerMetricsPage.validateThreadCountDragAndDrop();
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_084_validate_BrokerMetrics_ThreadCountGraph_XaxisTitle() throws EncryptedDocumentException, IOException {
		KafkaBrokerBrokerMetricsPage.validateThreadCountGraphXaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Broker, "BrokerMetrics_ThreadCount_Xaxis_Title"));
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_085_validate_BrokerMetrics_ThreadCountGraph_YaxisTitle() throws EncryptedDocumentException, IOException {
		KafkaBrokerBrokerMetricsPage.validateThreadCountGraphYaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Broker, "BrokerMetrics_ThreadCount_Yaxis_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_086_validate_BrokerMetrics_ThreadCountGraph_LegendTitle1() throws EncryptedDocumentException, IOException {
		KafkaBrokerBrokerMetricsPage.validateThreadCountGraphLegendTitle1(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Broker, "BrokerMetrics_ThreadCount_Broker_Header_Title"));
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_087_validate_BrokerMetrics_ThreadCountGraph_LegendTitle2() throws EncryptedDocumentException, IOException {
		KafkaBrokerBrokerMetricsPage.validateThreadCountGraphLegendTitle2(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Broker, "BrokerMetrics_ThreadCount_Avg_Header_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_088_validate_BrokerMetrics_ThreadCountGraph_LegendTitle3() throws EncryptedDocumentException, IOException {
		KafkaBrokerBrokerMetricsPage.validateThreadCountGraphLegendTitle3(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Broker, "BrokerMetrics_ThreadCount_Max_Header_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_089_validate_BrokerMetrics_ThreadCountGraph_ToolTip() throws EncryptedDocumentException, IOException {
		KafkaBrokerBrokerMetricsPage.validateThreadCountToolTipTitle();
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_090_validate_BrokerMetrics_ThreadCountGraph_ExpandViewXAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaBrokerBrokerMetricsPage.validateThreadCountExpandViewXAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_091_validate_BrokerMetrics_ThreadCountGraph_ExpandViewYAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		page.reload();
		KafkaBrokerBrokerMetricsPage.clickOnBrokerMetricsTab();	
		KafkaBrokerBrokerMetricsPage.validateThreadCountExpandViewYAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_092_validate_BrokerMetrics_ThreadCountGraph_ExpandViewWidgetTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaBrokerBrokerMetricsPage.validateThreadCountExpandViewWidgetTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_093_validate_BrokerMetrics_ThreadCountGraph_ExpandViewLegendHeader1() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaBrokerBrokerMetricsPage.validateThreadCountExpandViewLegendHeader1();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_094_validate_BrokerMetrics_ThreadCountGraph_ExpandViewLegendHeader2() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaBrokerBrokerMetricsPage.validateThreadCountExpandViewLegendHeader2();
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_095_validate_BrokerMetrics_ThreadCountGraph_ExpandViewLegendHeader3() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaBrokerBrokerMetricsPage.validateThreadCountExpandViewLegendHeader3();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_096_validate_BrokerMetrics_ThreadCountGraph_ExpandViewZoomInBtn() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaBrokerBrokerMetricsPage.validateThreadCountExpandViewZoomIn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_097_validate_BrokerMetrics_ThreadCountGraph_ExpandViewZoomOutBtn() throws EncryptedDocumentException, IOException, InterruptedException {	 
		KafkaBrokerBrokerMetricsPage.validateThreadCountExpandViewZoomOut();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_098_validate_BrokerMetrics_ThreadCountGraph_ExpandViewWidgetDragDrop() throws EncryptedDocumentException, IOException, InterruptedException {		 
		KafkaBrokerBrokerMetricsPage.validateThreadCountExpandViewWidgetDragDrop();
	}	
	
	
/*
 * Message Count Graph	
 */
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_099_validate_BrokerMetrics_MessageCountGraph_Title() throws EncryptedDocumentException, IOException {
		KafkaBrokerBrokerMetricsPage.validateMessageCountGraphTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Broker, "BrokerMetrics_MessageCount_Graph_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_100_validate_BrokerMetrics_MessageCountGraph_ZoomIn() throws EncryptedDocumentException, IOException {
		KafkaBrokerBrokerMetricsPage.validateMessageCountZoomInBtn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_101_validate_BrokerMetrics_MessageCountGraph_ZoomOut() throws EncryptedDocumentException, IOException {
		KafkaBrokerBrokerMetricsPage.validateMessageCountZoomOutBtn();
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_102_validate_BrokerMetrics_MessageCountGraph_DragAndDrop() throws EncryptedDocumentException, IOException {
		KafkaBrokerBrokerMetricsPage.validateMessageCountDragAndDrop();
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_103_validate_BrokerMetrics_MessageCountGraph_XaxisTitle() throws EncryptedDocumentException, IOException {
		KafkaBrokerBrokerMetricsPage.validateMessageCountGraphXaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Broker, "BrokerMetrics_MessageCount_Xaxis_Title"));
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_104_validate_BrokerMetrics_MessageCountGraph_YaxisTitle() throws EncryptedDocumentException, IOException {
		KafkaBrokerBrokerMetricsPage.validateMessageCountGraphYaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Broker, "BrokerMetrics_MessageCount_Yaxis_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_105_validate_BrokerMetrics_MessageCountGraph_LegendTitle1() throws EncryptedDocumentException, IOException {
		KafkaBrokerBrokerMetricsPage.validateMessageCountGraphLegendTitle1(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Broker, "BrokerMetrics_MessageCount_Broker_Header_Title"));
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_106_validate_BrokerMetrics_MessageCountGraph_LegendTitle2() throws EncryptedDocumentException, IOException {
		KafkaBrokerBrokerMetricsPage.validateMessageCountGraphLegendTitle2(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Broker, "BrokerMetrics_MessageCount_Avg_Header_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_107_validate_BrokerMetrics_MessageCountGraph_LegendTitle3() throws EncryptedDocumentException, IOException {
		KafkaBrokerBrokerMetricsPage.validateMessageCountGraphLegendTitle3(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Broker, "BrokerMetrics_MessageCount_Max_Header_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_108_validate_BrokerMetrics_MessageCountGraph_ToolTip() throws EncryptedDocumentException, IOException {
		KafkaBrokerBrokerMetricsPage.validateMessageCountToolTipTitle();
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_109_validate_BrokerMetrics_MessageCountGraph_ExpandViewXAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaBrokerBrokerMetricsPage.validateMessageCountExpandViewXAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_110_validate_BrokerMetrics_MessageCountGraph_ExpandViewYAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		page.reload();
		KafkaBrokerBrokerMetricsPage.clickOnBrokerMetricsTab();	
		KafkaBrokerBrokerMetricsPage.validateMessageCountExpandViewYAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_111_validate_BrokerMetrics_MessageCountGraph_ExpandViewWidgetTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaBrokerBrokerMetricsPage.validateMessageCountExpandViewWidgetTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_112_validate_BrokerMetrics_MessageCountGraph_ExpandViewLegendHeader1() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaBrokerBrokerMetricsPage.validateMessageCountExpandViewLegendHeader1();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_113_validate_BrokerMetrics_MessageCountGraph_ExpandViewLegendHeader2() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaBrokerBrokerMetricsPage.validateMessageCountExpandViewLegendHeader2();
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_114_validate_BrokerMetrics_MessageCountGraph_ExpandViewLegendHeader3() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaBrokerBrokerMetricsPage.validateMessageCountExpandViewLegendHeader3();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_115_validate_BrokerMetrics_MessageCountGraph_ExpandViewZoomInBtn() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaBrokerBrokerMetricsPage.validateMessageCountExpandViewZoomIn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_116_validate_BrokerMetrics_MessageCountGraph_ExpandViewZoomOutBtn() throws EncryptedDocumentException, IOException, InterruptedException {	 
		KafkaBrokerBrokerMetricsPage.validateMessageCountExpandViewZoomOut();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_117_validate_BrokerMetrics_MessageCountGraph_ExpandViewWidgetDragDrop() throws EncryptedDocumentException, IOException, InterruptedException {		 
		KafkaBrokerBrokerMetricsPage.validateMessageCountExpandViewWidgetDragDrop();
	}	
	
	
	
	@Test(groups= {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_118_validate_BrokerTab_when_TimeRangeisChangedTo_5min() {
		commonPage.selectTheTimeLineFromCalender(IPathConstant.fiveMinutesTimeRange);
		KafkaBrokerBrokerMetricsPage.validateXaxisValuesForKafkaBrokerBrokerMetricsPage();
	}
	@Test(groups= {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_119_validate_BrokerTab_when_TimeRangeisChangedTo_15min() {
		commonPage.selectTheTimeLineFromCalender(IPathConstant.fifteenMinutesTimeRange);
		KafkaBrokerBrokerMetricsPage.validateXaxisValuesForKafkaBrokerBrokerMetricsPage();
	}
	@Test(groups= {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_120_validate_BrokerTab_when_TimeRangeisChangedTo_30min() {
		commonPage.selectTheTimeLineFromCalender(IPathConstant.thirtyMinutesTimeRange);
		KafkaBrokerBrokerMetricsPage.validateXaxisValuesForKafkaBrokerBrokerMetricsPage();
	}
	@Test(groups= {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_121_validate_BrokerTab_when_TimeRangeisChangedTo_60min() {
		commonPage.selectTheTimeLineFromCalender(IPathConstant.sixtyMinutesTimeRange);
		KafkaBrokerBrokerMetricsPage.validateXaxisValuesForKafkaBrokerBrokerMetricsPage();
	}
	@Test(groups= {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_122_validate_BrokerTab_when_TimeRangeisChangedTo_3hour() {
		commonPage.selectTheTimeLineFromCalender(IPathConstant.threeHoursTimeRange);
		KafkaBrokerBrokerMetricsPage.validateXaxisValuesForKafkaBrokerBrokerMetricsPage();
	}
	@Test(groups= {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_123_validate_BrokerTab_when_TimeRangeisChangedTo_6hour() {
		commonPage.selectTheTimeLineFromCalender(IPathConstant.sixHoursTimeRange);
		KafkaBrokerBrokerMetricsPage.validateXaxisValuesForKafkaBrokerBrokerMetricsPage();
	}
	@Test(groups= {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_124_validate_BrokerTab_when_TimeRangeisChangedTo_1Day() {
		commonPage.selectTheTimeLineFromCalender(IPathConstant.oneDayTimeRange);
		KafkaBrokerBrokerMetricsPage.validateXaxisValuesForKafkaBrokerBrokerMetricsPage();
	}
	@Test(groups= {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_125_validate_BrokerTab_when_TimeRangeisChangedTo_1Week() {
		commonPage.selectTheTimeLineFromCalender(IPathConstant.oneWeekTimeRange);
		KafkaBrokerBrokerMetricsPage.validateXaxisValuesForKafkaBrokerBrokerMetricsPage();
	}
	@Test(groups= {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_126_validate_BrokerTab_when_TimeRangeisChangedTo_1Month() {
		commonPage.selectTheTimeLineFromCalender(IPathConstant.oneMonthTimeRange);
		KafkaBrokerBrokerMetricsPage.validateXaxisValuesForKafkaBrokerBrokerMetricsPage();
	}
	@Test(groups= {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_127_validate_BrokerTab_when_TimeRangeisChangedTo_4hour() throws EncryptedDocumentException, IOException {
		commonPage.selectTheCustomeTimeLine(IPathConstant.customTimeRange, excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath, IPathConstant.calenderSheet, "customHoursRange"));
		KafkaBrokerBrokerMetricsPage.validateTheCustomTimeLine(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath, IPathConstant.calenderSheet, "customHoursRange"));
	}
	
	@Test(groups = {"MQM","UI","Regression"})
	public void TC_128_validate_The_All_Widgets_By_selecting_custom_Time_For_Minutes_Range() throws EncryptedDocumentException, IOException
	{	
		//select the time line from calendar
		commonPage.selectTheCustomeTimeLine(IPathConstant.customTimeRange, excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customMinutesRange") );
				
		//Validate whether the widgets are displaying the proper time line or not
		KafkaBrokerBrokerMetricsPage.validateTheCustomTimeLine(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customMinutesRange"));
	}
	@Test(groups = {"MQM","UI","Regression"})
	public void TC_129_validate_The_All_Widgets_By_selecting_custom_Time_For_Hours_Range() throws EncryptedDocumentException, IOException
	{	
		//select the time line from calendar
		commonPage.selectTheCustomeTimeLine(IPathConstant.customTimeRange, excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customHoursRange"));

		//Validate whether the widgets are displaying the proper time line or not
		KafkaBrokerBrokerMetricsPage.validateTheCustomTimeLine(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customHoursRange"));
	}
	@Test(groups = {"MQM","UI","Regression"})
	public void TC_130_validate_The_All_Widgets_By_selecting_custom_Time_For_Days_Range() throws EncryptedDocumentException, IOException
	{
		//select the time line from calendar
		commonPage.selectTheCustomeTimeLine(IPathConstant.customTimeRange, excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customDaysRange"));
		
		//Validate whether the widgets are displaying the proper time line or not
		KafkaBrokerBrokerMetricsPage.validateTheCustomTimeLine(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customDaysRange"));
	}
	
	
	@Test(groups = {"MQM","UI","Regression"})
	public void TC_131_validate_The_All_Widgets_By_selecting_custom_Time_For_Future_date()
	{
		//select the time line from calendar
		commonPage.selectTheTimeLineFromCalender(IPathConstant.fiveMinutesTimeRange);
		
		//select the future time line from calendar
		commonPage.validateTheFutureTimeLine();
	}
}