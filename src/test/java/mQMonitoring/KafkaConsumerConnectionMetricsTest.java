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
import objectRepository.MQM.KafkaConsumerConnectionMetricsPage;

public class KafkaConsumerConnectionMetricsTest extends BaseClass
{
	GenericMethods util = new GenericMethods();
	CommonPage commonPage;
	KafkaConsumerConnectionMetricsPage KafkaConsumerConnectionMetricsPage;
	ExcelUtility excel = new ExcelUtility();	

	@BeforeMethod
	public void Consumer() throws EncryptedDocumentException, IOException 
	{
		commonPage = new CommonPage(page);
		KafkaConsumerConnectionMetricsPage = new  KafkaConsumerConnectionMetricsPage(page);
		excel = new ExcelUtility();
	}	
	
/**
 * Connection Metrics Tab
 * @throws EncryptedDocumentException
 * @throws IOException
 */
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_001_validate_ConnectionMetrics_Tab_Title() throws EncryptedDocumentException, IOException {
		commonPage.navigateToMQM();	
		String messageQueue = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Load, "MessageQueue");
		KafkaConsumerConnectionMetricsPage.navigateToKafka(messageQueue);
		page.waitForLoadState(LoadState.NETWORKIDLE);
		page.waitForTimeout(3000);
		String application = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Load, "Application");
		KafkaConsumerConnectionMetricsPage.selectServiceName(application);
		commonPage.selectTheTimeLineFromCalender(IPathConstant.oneMonthTimeRange);
		KafkaConsumerConnectionMetricsPage.navigateToConsumerTab();
		KafkaConsumerConnectionMetricsPage.clickOnConnectionMetricsTab();	
		KafkaConsumerConnectionMetricsPage.validateConnectionMetricsTabTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Consumer, "ConnectionMetrics_Tab_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_002_validate_Consumer_Title() throws EncryptedDocumentException, IOException {
		KafkaConsumerConnectionMetricsPage.validateConsumerSelectTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Consumer, "RequestMetrics_ConsumerSelect_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_003_validate_Consumer_DropDown() throws EncryptedDocumentException, IOException {
		KafkaConsumerConnectionMetricsPage.validateConsumerSelectDropDown();
	}
		
/*
 * Connection Creation Rate Graph	
 */

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_004_validate_ConnectionMetrics_ConnectionCreationRateGraph_Title() throws EncryptedDocumentException, IOException {
		KafkaConsumerConnectionMetricsPage.validateConnectionCreationRateGraphTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Consumer, "ConnectionMetrics_ConnectionCreationRate_Graph_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_005_validate_ConnectionMetrics_ConnectionCreationRateGraph_ZoomIn() throws EncryptedDocumentException, IOException {	
		KafkaConsumerConnectionMetricsPage.validateConnectionCreationRateZoomInBtn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_006_validate_ConnectionMetrics_ConnectionCreationRateGraph_ZoomOut() throws EncryptedDocumentException, IOException {
		KafkaConsumerConnectionMetricsPage.validateConnectionCreationRateZoomOutBtn();
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_007_validate_ConnectionMetrics_ConnectionCreationRateGraph_DragAndDrop() throws EncryptedDocumentException, IOException {
		KafkaConsumerConnectionMetricsPage.validateConnectionCreationRateDragAndDrop();
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_008_validate_ConnectionMetrics_ConnectionCreationRateGraph_XaxisTitle() throws EncryptedDocumentException, IOException {
		KafkaConsumerConnectionMetricsPage.validateConnectionCreationRateGraphXaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Consumer, "ConnectionMetrics_ConnectionCreationRate_Xaxis_Title"));
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_009_validate_ConnectionMetrics_ConnectionCreationRateGraph_YaxisTitle() throws EncryptedDocumentException, IOException {
		KafkaConsumerConnectionMetricsPage.validateConnectionCreationRateGraphYaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Consumer, "ConnectionMetrics_ConnectionCreationRate_Yaxis_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_010_validate_ConnectionMetrics_ConnectionCreationRateGraph_LegendTitle1() throws EncryptedDocumentException, IOException {
		KafkaConsumerConnectionMetricsPage.validateConnectionCreationRateGraphLegendTitle1(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Consumer, "ConnectionMetrics_ConnectionCreationRate_Consumer_Header_Title"));
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_011_validate_ConnectionMetrics_ConnectionCreationRateGraph_LegendTitle2() throws EncryptedDocumentException, IOException {
		KafkaConsumerConnectionMetricsPage.validateConnectionCreationRateGraphLegendTitle2(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Consumer, "ConnectionMetrics_ConnectionCreationRate_Avg_Header_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_012_validate_ConnectionMetrics_ConnectionCreationRateGraph_LegendTitle3() throws EncryptedDocumentException, IOException {
		KafkaConsumerConnectionMetricsPage.validateConnectionCreationRateGraphLegendTitle3(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Consumer, "ConnectionMetrics_ConnectionCreationRate_Max_Header_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_013_validate_ConnectionMetrics_ConnectionCreationRateGraph_ToolTip() throws EncryptedDocumentException, IOException {
		KafkaConsumerConnectionMetricsPage.validateConnectionCreationRateToolTipTitle();
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_014_validate_ConnectionMetrics_ConnectionCreationRateGraph_ExpandViewXAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaConsumerConnectionMetricsPage.validateConnectionCreationRateExpandViewXAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_015_validate_ConnectionMetrics_ConnectionCreationRateGraph_ExpandViewYAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaConsumerConnectionMetricsPage.validateConnectionCreationRateExpandViewYAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_016_validate_ConnectionMetrics_ConnectionCreationRateGraph_ExpandViewWidgetTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaConsumerConnectionMetricsPage.validateConnectionCreationRateExpandViewWidgetTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_017_validate_ConnectionMetrics_ConnectionCreationRateGraph_ExpandViewLegendHeader1() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaConsumerConnectionMetricsPage.validateConnectionCreationRateExpandViewLegendHeader1();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_018_validate_ConnectionMetrics_ConnectionCreationRateGraph_ExpandViewLegendHeader2() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaConsumerConnectionMetricsPage.validateConnectionCreationRateExpandViewLegendHeader2();
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_019_validate_ConnectionMetrics_ConnectionCreationRateGraph_ExpandViewLegendHeader3() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaConsumerConnectionMetricsPage.validateConnectionCreationRateExpandViewLegendHeader3();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_020_validate_ConnectionMetrics_ConnectionCreationRateGraph_ExpandViewZoomInBtn() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaConsumerConnectionMetricsPage.validateConnectionCreationRateExpandViewZoomIn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_021_validate_ConnectionMetrics_ConnectionCreationRateGraph_ExpandViewZoomOutBtn() throws EncryptedDocumentException, IOException, InterruptedException {	 
		KafkaConsumerConnectionMetricsPage.validateConnectionCreationRateExpandViewZoomOut();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_022_validate_ConnectionMetrics_ConnectionCreationRateGraph_ExpandViewWidgetDragDrop() throws EncryptedDocumentException, IOException, InterruptedException {		 
		KafkaConsumerConnectionMetricsPage.validateConnectionCreationRateExpandViewWidgetDragDrop();
	}	
	
/*
 * Connection Close Rate Graph	
 */
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_023_validate_ConnectionMetrics_ConnectionCloseRateGraph_Title() throws EncryptedDocumentException, IOException {
		KafkaConsumerConnectionMetricsPage.validateConnectionCloseRateGraphTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Consumer, "ConnectionMetrics_ConnectionCloseRate_Graph_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_024_validate_ConnectionMetrics_ConnectionCloseRateGraph_ZoomIn() throws EncryptedDocumentException, IOException {
		KafkaConsumerConnectionMetricsPage.validateConnectionCloseRateZoomInBtn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_025_validate_ConnectionMetrics_ConnectionCloseRateGraph_ZoomOut() throws EncryptedDocumentException, IOException {
		KafkaConsumerConnectionMetricsPage.validateConnectionCloseRateZoomOutBtn();
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_026_validate_ConnectionMetrics_ConnectionCloseRateGraph_DragAndDrop() throws EncryptedDocumentException, IOException {
		KafkaConsumerConnectionMetricsPage.validateConnectionCloseRateDragAndDrop();
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_027_validate_ConnectionMetrics_ConnectionCloseRateGraph_XaxisTitle() throws EncryptedDocumentException, IOException {
		KafkaConsumerConnectionMetricsPage.validateConnectionCloseRateGraphXaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Consumer, "ConnectionMetrics_ConnectionCloseRate_Xaxis_Title"));
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_028_validate_ConnectionMetrics_ConnectionCloseRateGraph_YaxisTitle() throws EncryptedDocumentException, IOException {
		KafkaConsumerConnectionMetricsPage.validateConnectionCloseRateGraphYaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Consumer, "ConnectionMetrics_ConnectionCloseRate_Yaxis_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_029_validate_ConnectionMetrics_ConnectionCloseRateGraph_LegendTitle1() throws EncryptedDocumentException, IOException {
		KafkaConsumerConnectionMetricsPage.validateConnectionCloseRateGraphLegendTitle1(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Consumer, "ConnectionMetrics_ConnectionCloseRate_Consumer_Header_Title"));
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_030_validate_ConnectionMetrics_ConnectionCloseRateGraph_LegendTitle2() throws EncryptedDocumentException, IOException {
		KafkaConsumerConnectionMetricsPage.validateConnectionCloseRateGraphLegendTitle2(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Consumer, "ConnectionMetrics_ConnectionCloseRate_Avg_Header_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_031_validate_ConnectionMetrics_ConnectionCloseRateGraph_LegendTitle3() throws EncryptedDocumentException, IOException {
		KafkaConsumerConnectionMetricsPage.validateConnectionCloseRateGraphLegendTitle3(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Consumer, "ConnectionMetrics_ConnectionCloseRate_Max_Header_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_032_validate_ConnectionMetrics_ConnectionCloseRateGraph_ToolTip() throws EncryptedDocumentException, IOException {
		KafkaConsumerConnectionMetricsPage.validateConnectionCloseRateToolTipTitle();
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_033_validate_ConnectionMetrics_ConnectionCloseRateGraph_ExpandViewXAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaConsumerConnectionMetricsPage.validateConnectionCloseRateExpandViewXAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_034_validate_ConnectionMetrics_ConnectionCloseRateGraph_ExpandViewYAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaConsumerConnectionMetricsPage.validateConnectionCloseRateExpandViewYAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_035_validate_ConnectionMetrics_ConnectionCloseRateGraph_ExpandViewWidgetTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaConsumerConnectionMetricsPage.validateConnectionCloseRateExpandViewWidgetTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_036_validate_ConnectionMetrics_ConnectionCloseRateGraph_ExpandViewLegendHeader1() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaConsumerConnectionMetricsPage.validateConnectionCloseRateExpandViewLegendHeader1();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_037_validate_ConnectionMetrics_ConnectionCloseRateGraph_ExpandViewLegendHeader2() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaConsumerConnectionMetricsPage.validateConnectionCloseRateExpandViewLegendHeader2();
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_038_validate_ConnectionMetrics_ConnectionCloseRateGraph_ExpandViewLegendHeader3() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaConsumerConnectionMetricsPage.validateConnectionCloseRateExpandViewLegendHeader3();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_039_validate_ConnectionMetrics_ConnectionCloseRateGraph_ExpandViewZoomInBtn() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaConsumerConnectionMetricsPage.validateConnectionCloseRateExpandViewZoomIn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_040_validate_ConnectionMetrics_ConnectionCloseRateGraph_ExpandViewZoomOutBtn() throws EncryptedDocumentException, IOException, InterruptedException {	 
		KafkaConsumerConnectionMetricsPage.validateConnectionCloseRateExpandViewZoomOut();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_041_validate_ConnectionMetrics_ConnectionCloseRateGraph_ExpandViewWidgetDragDrop() throws EncryptedDocumentException, IOException, InterruptedException {		 
		KafkaConsumerConnectionMetricsPage.validateConnectionCloseRateExpandViewWidgetDragDrop();
	}	
	
/*
 *  I/O Wait Ratio Graph	
 */
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_042_validate_ConnectionMetrics_iOWaitRatioGraph_Title() throws EncryptedDocumentException, IOException {
		KafkaConsumerConnectionMetricsPage.validateiOWaitRatioGraphTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Consumer, "ConnectionMetrics_iOWaitRatio_Graph_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_043_validate_ConnectionMetrics_iOWaitRatioGraph_ZoomIn() throws EncryptedDocumentException, IOException {
		KafkaConsumerConnectionMetricsPage.validateiOWaitRatioZoomInBtn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_044_validate_ConnectionMetrics_iOWaitRatioGraph_ZoomOut() throws EncryptedDocumentException, IOException {
		KafkaConsumerConnectionMetricsPage.validateiOWaitRatioZoomOutBtn();
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_045_validate_ConnectionMetrics_iOWaitRatioGraph_DragAndDrop() throws EncryptedDocumentException, IOException {
		KafkaConsumerConnectionMetricsPage.validateiOWaitRatioDragAndDrop();
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_046_validate_ConnectionMetrics_iOWaitRatioGraph_XaxisTitle() throws EncryptedDocumentException, IOException {
		KafkaConsumerConnectionMetricsPage.validateiOWaitRatioGraphXaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Consumer, "ConnectionMetrics_iOWaitRatio_Xaxis_Title"));
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_047_validate_ConnectionMetrics_iOWaitRatioGraph_YaxisTitle() throws EncryptedDocumentException, IOException {
		KafkaConsumerConnectionMetricsPage.validateiOWaitRatioGraphYaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Consumer, "ConnectionMetrics_iOWaitRatio_Yaxis_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_048_validate_ConnectionMetrics_iOWaitRatioGraph_LegendTitle1() throws EncryptedDocumentException, IOException {
		KafkaConsumerConnectionMetricsPage.validateiOWaitRatioGraphLegendTitle1(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Consumer, "ConnectionMetrics_iOWaitRatio_Consumer_Header_Title"));
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_049_validate_ConnectionMetrics_iOWaitRatioGraph_LegendTitle2() throws EncryptedDocumentException, IOException {
		KafkaConsumerConnectionMetricsPage.validateiOWaitRatioGraphLegendTitle2(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Consumer, "ConnectionMetrics_iOWaitRatio_Avg_Header_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_050_validate_ConnectionMetrics_iOWaitRatioGraph_LegendTitle3() throws EncryptedDocumentException, IOException {
		KafkaConsumerConnectionMetricsPage.validateiOWaitRatioGraphLegendTitle3(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Consumer, "ConnectionMetrics_iOWaitRatio_Max_Header_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_051_validate_ConnectionMetrics_iOWaitRatioGraph_ToolTip() throws EncryptedDocumentException, IOException {
		KafkaConsumerConnectionMetricsPage.validateiOWaitRatioToolTipTitle();
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_052_validate_ConnectionMetrics_iOWaitRatioGraph_ExpandViewXAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaConsumerConnectionMetricsPage.validateiOWaitRatioExpandViewXAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_053_validate_ConnectionMetrics_iOWaitRatioGraph_ExpandViewYAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaConsumerConnectionMetricsPage.validateiOWaitRatioExpandViewYAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_054_validate_ConnectionMetrics_iOWaitRatioGraph_ExpandViewWidgetTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaConsumerConnectionMetricsPage.validateiOWaitRatioExpandViewWidgetTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_055_validate_ConnectionMetrics_iOWaitRatioGraph_ExpandViewLegendHeader1() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaConsumerConnectionMetricsPage.validateiOWaitRatioExpandViewLegendHeader1();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_056_validate_ConnectionMetrics_iOWaitRatioGraph_ExpandViewLegendHeader2() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaConsumerConnectionMetricsPage.validateiOWaitRatioExpandViewLegendHeader2();
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_057_validate_ConnectionMetrics_iOWaitRatioGraph_ExpandViewLegendHeader3() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaConsumerConnectionMetricsPage.validateiOWaitRatioExpandViewLegendHeader3();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_058_validate_ConnectionMetrics_iOWaitRatioGraph_ExpandViewZoomInBtn() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaConsumerConnectionMetricsPage.validateiOWaitRatioExpandViewZoomIn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_059_validate_ConnectionMetrics_iOWaitRatioGraph_ExpandViewZoomOutBtn() throws EncryptedDocumentException, IOException, InterruptedException {	 
		KafkaConsumerConnectionMetricsPage.validateiOWaitRatioExpandViewZoomOut();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_060_validate_ConnectionMetrics_iOWaitRatioGraph_ExpandViewWidgetDragDrop() throws EncryptedDocumentException, IOException, InterruptedException {		 
		KafkaConsumerConnectionMetricsPage.validateiOWaitRatioExpandViewWidgetDragDrop();
	}	
	
	
/*
 *  I/O Wait Time Average Graph	
 */
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_061_validate_ConnectionMetrics_iOWaitTimeAverageGraph_Title() throws EncryptedDocumentException, IOException {
		KafkaConsumerConnectionMetricsPage.validateiOWaitTimeAverageGraphTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Consumer, "ConnectionMetrics_iOWaitTimeAverage_Graph_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_062_validate_ConnectionMetrics_iOWaitTimeAverageGraph_ZoomIn() throws EncryptedDocumentException, IOException {
		KafkaConsumerConnectionMetricsPage.validateiOWaitTimeAverageZoomInBtn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_063_validate_ConnectionMetrics_iOWaitTimeAverageGraph_ZoomOut() throws EncryptedDocumentException, IOException {
		KafkaConsumerConnectionMetricsPage.validateiOWaitTimeAverageZoomOutBtn();
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_064_validate_ConnectionMetrics_iOWaitTimeAverageGraph_DragAndDrop() throws EncryptedDocumentException, IOException {
		KafkaConsumerConnectionMetricsPage.validateiOWaitTimeAverageDragAndDrop();
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_065_validate_ConnectionMetrics_iOWaitTimeAverageGraph_XaxisTitle() throws EncryptedDocumentException, IOException {
		KafkaConsumerConnectionMetricsPage.validateiOWaitTimeAverageGraphXaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Consumer, "ConnectionMetrics_iOWaitTimeAverage_Xaxis_Title"));
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_066_validate_ConnectionMetrics_iOWaitTimeAverageGraph_YaxisTitle() throws EncryptedDocumentException, IOException {
		KafkaConsumerConnectionMetricsPage.validateiOWaitTimeAverageGraphYaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Consumer, "ConnectionMetrics_iOWaitTimeAverage_Yaxis_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_067_validate_ConnectionMetrics_iOWaitTimeAverageGraph_LegendTitle1() throws EncryptedDocumentException, IOException {
		KafkaConsumerConnectionMetricsPage.validateiOWaitTimeAverageGraphLegendTitle1(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Consumer, "ConnectionMetrics_iOWaitTimeAverage_Consumer_Header_Title"));
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_068_validate_ConnectionMetrics_iOWaitTimeAverageGraph_LegendTitle2() throws EncryptedDocumentException, IOException {
		KafkaConsumerConnectionMetricsPage.validateiOWaitTimeAverageGraphLegendTitle2(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Consumer, "ConnectionMetrics_iOWaitTimeAverage_Avg_Header_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_069_validate_ConnectionMetrics_iOWaitTimeAverageGraph_LegendTitle3() throws EncryptedDocumentException, IOException {
		KafkaConsumerConnectionMetricsPage.validateiOWaitTimeAverageGraphLegendTitle3(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Consumer, "ConnectionMetrics_iOWaitTimeAverage_Max_Header_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_070_validate_ConnectionMetrics_iOWaitTimeAverageGraph_ToolTip() throws EncryptedDocumentException, IOException {
		KafkaConsumerConnectionMetricsPage.validateiOWaitTimeAverageToolTipTitle();
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_071_validate_ConnectionMetrics_iOWaitTimeAverageGraph_ExpandViewXAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaConsumerConnectionMetricsPage.validateiOWaitTimeAverageExpandViewXAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_072_validate_ConnectionMetrics_iOWaitTimeAverageGraph_ExpandViewYAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaConsumerConnectionMetricsPage.validateiOWaitTimeAverageExpandViewYAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_073_validate_ConnectionMetrics_iOWaitTimeAverageGraph_ExpandViewWidgetTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaConsumerConnectionMetricsPage.validateiOWaitTimeAverageExpandViewWidgetTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_074_validate_ConnectionMetrics_iOWaitTimeAverageGraph_ExpandViewLegendHeader1() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaConsumerConnectionMetricsPage.validateiOWaitTimeAverageExpandViewLegendHeader1();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_075_validate_ConnectionMetrics_iOWaitTimeAverageGraph_ExpandViewLegendHeader2() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaConsumerConnectionMetricsPage.validateiOWaitTimeAverageExpandViewLegendHeader2();
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_076_validate_ConnectionMetrics_iOWaitTimeAverageGraph_ExpandViewLegendHeader3() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaConsumerConnectionMetricsPage.validateiOWaitTimeAverageExpandViewLegendHeader3();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_077_validate_ConnectionMetrics_iOWaitTimeAverageGraph_ExpandViewZoomInBtn() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaConsumerConnectionMetricsPage.validateiOWaitTimeAverageExpandViewZoomIn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_078_validate_ConnectionMetrics_iOWaitTimeAverageGraph_ExpandViewZoomOutBtn() throws EncryptedDocumentException, IOException, InterruptedException {	 
		KafkaConsumerConnectionMetricsPage.validateiOWaitTimeAverageExpandViewZoomOut();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_079_validate_ConnectionMetrics_iOWaitTimeAverageGraph_ExpandViewWidgetDragDrop() throws EncryptedDocumentException, IOException, InterruptedException {		 
		KafkaConsumerConnectionMetricsPage.validateiOWaitTimeAverageExpandViewWidgetDragDrop();
	}	
	
		
	
	@Test(groups= {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_080_validate_ConsumerTab_when_TimeRangeisChangedTo_5min() {
		commonPage.selectTheTimeLineFromCalender(IPathConstant.fiveMinutesTimeRange);
		KafkaConsumerConnectionMetricsPage.validateXaxisValuesForKafkaConsumerConnectionMetricsPage();
	}
	
	@Test(groups= {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_081_validate_ConsumerTab_when_TimeRangeisChangedTo_15min() {
		commonPage.selectTheTimeLineFromCalender(IPathConstant.fifteenMinutesTimeRange);
		KafkaConsumerConnectionMetricsPage.validateXaxisValuesForKafkaConsumerConnectionMetricsPage();
	}
	@Test(groups= {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_082_validate_ConsumerTab_when_TimeRangeisChangedTo_30min() {
		commonPage.selectTheTimeLineFromCalender(IPathConstant.thirtyMinutesTimeRange);
		KafkaConsumerConnectionMetricsPage.validateXaxisValuesForKafkaConsumerConnectionMetricsPage();
	}
	@Test(groups= {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_083_validate_ConsumerTab_when_TimeRangeisChangedTo_60min() {
		commonPage.selectTheTimeLineFromCalender(IPathConstant.sixtyMinutesTimeRange);
		KafkaConsumerConnectionMetricsPage.validateXaxisValuesForKafkaConsumerConnectionMetricsPage();
	}
	@Test(groups= {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_084_validate_ConsumerTab_when_TimeRangeisChangedTo_3hour() {
		commonPage.selectTheTimeLineFromCalender(IPathConstant.threeHoursTimeRange);
		KafkaConsumerConnectionMetricsPage.validateXaxisValuesForKafkaConsumerConnectionMetricsPage();
	}
	@Test(groups= {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_085_validate_ConsumerTab_when_TimeRangeisChangedTo_6hour() {
		commonPage.selectTheTimeLineFromCalender(IPathConstant.sixHoursTimeRange);
		KafkaConsumerConnectionMetricsPage.validateXaxisValuesForKafkaConsumerConnectionMetricsPage();
	}
	@Test(groups= {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_086_validate_ConsumerTab_when_TimeRangeisChangedTo_1Day() {
		commonPage.selectTheTimeLineFromCalender(IPathConstant.oneDayTimeRange);
		KafkaConsumerConnectionMetricsPage.validateXaxisValuesForKafkaConsumerConnectionMetricsPage();
	}
	@Test(groups= {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_087_validate_ConsumerTab_when_TimeRangeisChangedTo_1Week() {
		commonPage.selectTheTimeLineFromCalender(IPathConstant.oneWeekTimeRange);
		KafkaConsumerConnectionMetricsPage.validateXaxisValuesForKafkaConsumerConnectionMetricsPage();
	}
	@Test(groups= {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_088_validate_ConsumerTab_when_TimeRangeisChangedTo_1Month() {
		commonPage.selectTheTimeLineFromCalender(IPathConstant.oneMonthTimeRange);
		KafkaConsumerConnectionMetricsPage.validateXaxisValuesForKafkaConsumerConnectionMetricsPage();
	}
	@Test(groups= {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_089_validate_ConsumerTab_when_TimeRangeisChangedTo_4hour() throws EncryptedDocumentException, IOException {
		commonPage.selectTheCustomeTimeLine(IPathConstant.customTimeRange, excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath, IPathConstant.calenderSheet, "customHoursRange"));
		KafkaConsumerConnectionMetricsPage.validateTheCustomTimeLine(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath, IPathConstant.calenderSheet, "customHoursRange"));
	}
	
	@Test(groups = {"MQM","UI","Regression"})
	public void TC_090_validate_The_All_Widgets_By_selecting_custom_Time_For_Minutes_Range() throws EncryptedDocumentException, IOException
	{	
		//select the time line from calendar
		commonPage.selectTheCustomeTimeLine(IPathConstant.customTimeRange, excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customMinutesRange") );
				
		//Validate whether the widgets are displaying the proper time line or not
		KafkaConsumerConnectionMetricsPage.validateTheCustomTimeLine(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customMinutesRange"));
	}
	@Test(groups = {"MQM","UI","Regression"})
	public void TC_091_validate_The_All_Widgets_By_selecting_custom_Time_For_Hours_Range() throws EncryptedDocumentException, IOException
	{	
		//select the time line from calendar
		commonPage.selectTheCustomeTimeLine(IPathConstant.customTimeRange, excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customHoursRange"));

		//Validate whether the widgets are displaying the proper time line or not
		KafkaConsumerConnectionMetricsPage.validateTheCustomTimeLine(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customHoursRange"));
	}
	@Test(groups = {"MQM","UI","Regression"})
	public void TC_092_validate_The_All_Widgets_By_selecting_custom_Time_For_Days_Range() throws EncryptedDocumentException, IOException
	{
		//select the time line from calendar
		commonPage.selectTheCustomeTimeLine(IPathConstant.customTimeRange, excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customDaysRange"));
		
		//Validate whether the widgets are displaying the proper time line or not
		KafkaConsumerConnectionMetricsPage.validateTheCustomTimeLine(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customDaysRange"));
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
