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
import objectRepository.MQM.KafkaProducerTopicPage;

public class KafkaProducerTopicTest extends BaseClass
{
	GenericMethods util = new GenericMethods();
	CommonPage commonPage;
	KafkaProducerTopicPage KafkaProducerTopicPage;
	ExcelUtility excel = new ExcelUtility();	

	@BeforeMethod
	public void Producer() throws EncryptedDocumentException, IOException 
	{
		commonPage = new CommonPage(page);
		KafkaProducerTopicPage = new KafkaProducerTopicPage(page);
		excel = new ExcelUtility();
	}
	
/**
 * Topic Tab
 * @throws EncryptedDocumentException
 * @throws IOException
 */
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_001_validate_Topic_Tab_Title() throws EncryptedDocumentException, IOException {
		commonPage.navigateToMQM();	
		String messageQueue = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Load, "MessageQueue");
		KafkaProducerTopicPage.navigateToKafka(messageQueue);
		page.waitForLoadState(LoadState.NETWORKIDLE);
		page.waitForTimeout(3000);
		String application = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Load, "Application");
		KafkaProducerTopicPage.selectServiceName(application);
		commonPage.selectTheTimeLineFromCalender(IPathConstant.oneMonthTimeRange);
		KafkaProducerTopicPage.navigateToProducerTab();
		KafkaProducerTopicPage.clickOnTopicTab();
		KafkaProducerTopicPage.validateTopicTabTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Producer, "Topic_Tab_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_002_validate_Topic_TopicSelect_Title() throws EncryptedDocumentException, IOException {
		KafkaProducerTopicPage.validateTopicSelectTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Producer, "Topic_TopicSelect_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_003_validate_Topic_TopicSelect_DropDown() throws EncryptedDocumentException, IOException {
		KafkaProducerTopicPage.validateTopicSelectDropDown();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_004_validate_Topic_ProducerSelect_Title() throws EncryptedDocumentException, IOException {
		KafkaProducerTopicPage.validateProducerSelectTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Producer, "Topic_ProducerSelect_Title"));
	}
	
	
/*
 * Record send rate Graph	
 */

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_006_validate_Topic_RecordSendRateGraph_Title() throws EncryptedDocumentException, IOException {
		KafkaProducerTopicPage.validateRecordSendRateGraphTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Producer, "Topic_RecordSendRate_Graph_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_007_validate_Topic_RecordSendRateGraph_ZoomIn() throws EncryptedDocumentException, IOException {
		KafkaProducerTopicPage.validateRecordSendRateZoomInBtn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_008_validate_Topic_RecordSendRateGraph_ZoomOut() throws EncryptedDocumentException, IOException {
		KafkaProducerTopicPage.validateRecordSendRateZoomOutBtn();
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_009_validate_Topic_RecordSendRateGraph_DragAndDrop() throws EncryptedDocumentException, IOException {
		KafkaProducerTopicPage.validateRecordSendRateDragAndDrop();
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_010_validate_Topic_RecordSendRateGraph_XaxisTitle() throws EncryptedDocumentException, IOException {
		KafkaProducerTopicPage.validateRecordSendRateGraphXaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Producer, "Topic_RecordSendRate_Xaxis_Title"));
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_011_validate_Topic_RecordSendRateGraph_YaxisTitle() throws EncryptedDocumentException, IOException {
		KafkaProducerTopicPage.validateRecordSendRateGraphYaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Producer, "Topic_RecordSendRate_Yaxis_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_012_validate_Topic_RecordSendRateGraph_LegendTitle1() throws EncryptedDocumentException, IOException {
		KafkaProducerTopicPage.validateRecordSendRateGraphLegendTitle1(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Producer, "Topic_RecordSendRate_Topic_Header_Title"));
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_013_validate_Topic_RecordSendRateGraph_LegendTitle2() throws EncryptedDocumentException, IOException {
		KafkaProducerTopicPage.validateRecordSendRateGraphLegendTitle2(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Producer, "Topic_RecordSendRate_Avg_Header_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_014_validate_Topic_RecordSendRateGraph_LegendTitle3() throws EncryptedDocumentException, IOException {
		KafkaProducerTopicPage.validateRecordSendRateGraphLegendTitle3(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Producer, "Topic_RecordSendRate_Max_Header_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_015_validate_Topic_RecordSendRateGraph_ToolTip() throws EncryptedDocumentException, IOException {
		KafkaProducerTopicPage.validateRecordSendRateToolTipTitle();
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_016_validate_Topic_RecordSendRateGraph_ExpandViewXAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaProducerTopicPage.validateRecordSendRateExpandViewXAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_017_validate_Topic_RecordSendRateGraph_ExpandViewYAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaProducerTopicPage.validateRecordSendRateExpandViewYAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_018_validate_Topic_RecordSendRateGraph_ExpandViewWidgetTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaProducerTopicPage.validateRecordSendRateExpandViewWidgetTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_019_validate_Topic_RecordSendRateGraph_ExpandViewLegendHeader1() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaProducerTopicPage.validateRecordSendRateExpandViewLegendHeader1();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_020_validate_Topic_RecordSendRateGraph_ExpandViewLegendHeader2() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaProducerTopicPage.validateRecordSendRateExpandViewLegendHeader2();
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_021_validate_Topic_RecordSendRateGraph_ExpandViewLegendHeader3() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaProducerTopicPage.validateRecordSendRateExpandViewLegendHeader3();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_022_validate_Topic_RecordSendRateGraph_ExpandViewZoomInBtn() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaProducerTopicPage.validateRecordSendRateExpandViewZoomIn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_023_validate_Topic_RecordSendRateGraph_ExpandViewZoomOutBtn() throws EncryptedDocumentException, IOException, InterruptedException {	 
		KafkaProducerTopicPage.validateRecordSendRateExpandViewZoomOut();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_024_validate_Topic_RecordSendRateGraph_ExpandViewWidgetDragDrop() throws EncryptedDocumentException, IOException, InterruptedException {		 
		KafkaProducerTopicPage.validateRecordSendRateExpandViewWidgetDragDrop();
	}	

/*
 *  Record send total Graph	
 */
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_025_validate_Topic_RecordSendTotalGraph_Title() throws EncryptedDocumentException, IOException {
		KafkaProducerTopicPage.validateRecordSendTotalGraphTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Producer, "Topic_RecordSendTotal_Graph_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_026_validate_Topic_RecordSendTotalGraph_ZoomIn() throws EncryptedDocumentException, IOException {
		KafkaProducerTopicPage.validateRecordSendTotalZoomInBtn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_027_validate_Topic_RecordSendTotalGraph_ZoomOut() throws EncryptedDocumentException, IOException {
		KafkaProducerTopicPage.validateRecordSendTotalZoomOutBtn();
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_028_validate_Topic_RecordSendTotalGraph_DragAndDrop() throws EncryptedDocumentException, IOException {
		KafkaProducerTopicPage.validateRecordSendTotalDragAndDrop();
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_029_validate_Topic_RecordSendTotalGraph_XaxisTitle() throws EncryptedDocumentException, IOException {
		KafkaProducerTopicPage.validateRecordSendTotalGraphXaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Producer, "Topic_RecordSendTotal_Xaxis_Title"));
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_030_validate_Topic_RecordSendTotalGraph_YaxisTitle() throws EncryptedDocumentException, IOException {
		KafkaProducerTopicPage.validateRecordSendTotalGraphYaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Producer, "Topic_RecordSendTotal_Yaxis_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_031_validate_Topic_RecordSendTotalGraph_LegendTitle1() throws EncryptedDocumentException, IOException {
		KafkaProducerTopicPage.validateRecordSendTotalGraphLegendTitle1(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Producer, "Topic_RecordSendTotal_Topic_Header_Title"));
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_032_validate_Topic_RecordSendTotalGraph_LegendTitle2() throws EncryptedDocumentException, IOException {
		KafkaProducerTopicPage.validateRecordSendTotalGraphLegendTitle2(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Producer, "Topic_RecordSendTotal_Avg_Header_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_033_validate_Topic_RecordSendTotalGraph_LegendTitle3() throws EncryptedDocumentException, IOException {
		KafkaProducerTopicPage.validateRecordSendTotalGraphLegendTitle3(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Producer, "Topic_RecordSendTotal_Max_Header_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_034_validate_Topic_RecordSendTotalGraph_ToolTip() throws EncryptedDocumentException, IOException {
		KafkaProducerTopicPage.validateRecordSendTotalToolTipTitle();
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_035_validate_Topic_RecordSendTotalGraph_ExpandViewXAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaProducerTopicPage.validateRecordSendTotalExpandViewXAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_036_validate_Topic_RecordSendTotalGraph_ExpandViewYAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		page.reload();
		KafkaProducerTopicPage.clickOnTopicTab();
		KafkaProducerTopicPage.validateRecordSendTotalExpandViewYAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_037_validate_Topic_RecordSendTotalGraph_ExpandViewWidgetTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaProducerTopicPage.validateRecordSendTotalExpandViewWidgetTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_038_validate_Topic_RecordSendTotalGraph_ExpandViewLegendHeader1() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaProducerTopicPage.validateRecordSendTotalExpandViewLegendHeader1();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_039_validate_Topic_RecordSendTotalGraph_ExpandViewLegendHeader2() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaProducerTopicPage.validateRecordSendTotalExpandViewLegendHeader2();
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_040_validate_Topic_RecordSendTotalGraph_ExpandViewLegendHeader3() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaProducerTopicPage.validateRecordSendTotalExpandViewLegendHeader3();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_041_validate_Topic_RecordSendTotalGraph_ExpandViewZoomInBtn() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaProducerTopicPage.validateRecordSendTotalExpandViewZoomIn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_042_validate_Topic_RecordSendTotalGraph_ExpandViewZoomOutBtn() throws EncryptedDocumentException, IOException, InterruptedException {	 
		KafkaProducerTopicPage.validateRecordSendTotalExpandViewZoomOut();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_043_validate_Topic_RecordSendTotalGraph_ExpandViewWidgetDragDrop() throws EncryptedDocumentException, IOException, InterruptedException {		 
		KafkaProducerTopicPage.validateRecordSendTotalExpandViewWidgetDragDrop();
	}	
	
/*
 *  Record Error Rate Graph	
 */
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_044_validate_Topic_RecordErrorRateGraph_Title() throws EncryptedDocumentException, IOException {
		KafkaProducerTopicPage.validateRecordErrorRateGraphTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Producer, "Topic_RecordErrorRate_Graph_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_045_validate_Topic_RecordErrorRateGraph_ZoomIn() throws EncryptedDocumentException, IOException {
		KafkaProducerTopicPage.validateRecordErrorRateZoomInBtn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_046_validate_Topic_RecordErrorRateGraph_ZoomOut() throws EncryptedDocumentException, IOException {
		KafkaProducerTopicPage.validateRecordErrorRateZoomOutBtn();
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_047_validate_Topic_RecordErrorRateGraph_DragAndDrop() throws EncryptedDocumentException, IOException {
		KafkaProducerTopicPage.validateRecordErrorRateDragAndDrop();
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_048_validate_Topic_RecordErrorRateGraph_XaxisTitle() throws EncryptedDocumentException, IOException {
		KafkaProducerTopicPage.validateRecordErrorRateGraphXaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Producer, "Topic_RecordErrorRate_Xaxis_Title"));
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_049_validate_Topic_RecordErrorRateGraph_YaxisTitle() throws EncryptedDocumentException, IOException {
		KafkaProducerTopicPage.validateRecordErrorRateGraphYaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Producer, "Topic_RecordErrorRate_Yaxis_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_050_validate_Topic_RecordErrorRateGraph_LegendTitle1() throws EncryptedDocumentException, IOException {
		KafkaProducerTopicPage.validateRecordErrorRateGraphLegendTitle1(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Producer, "Topic_RecordErrorRate_Topic_Header_Title"));
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_051_validate_Topic_RecordErrorRateGraph_LegendTitle2() throws EncryptedDocumentException, IOException {
		KafkaProducerTopicPage.validateRecordErrorRateGraphLegendTitle2(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Producer, "Topic_RecordErrorRate_Avg_Header_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_052_validate_Topic_RecordErrorRateGraph_LegendTitle3() throws EncryptedDocumentException, IOException {
		KafkaProducerTopicPage.validateRecordErrorRateGraphLegendTitle3(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Producer, "Topic_RecordErrorRate_Max_Header_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_053_validate_Topic_RecordErrorRateGraph_ToolTip() throws EncryptedDocumentException, IOException {
		KafkaProducerTopicPage.validateRecordErrorRateToolTipTitle();
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_054_validate_Topic_RecordErrorRateGraph_ExpandViewXAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaProducerTopicPage.validateRecordErrorRateExpandViewXAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_055_validate_Topic_RecordErrorRateGraph_ExpandViewYAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		page.reload();
		KafkaProducerTopicPage.clickOnTopicTab();
		KafkaProducerTopicPage.validateRecordErrorRateExpandViewYAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_056_validate_Topic_RecordErrorRateGraph_ExpandViewWidgetTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaProducerTopicPage.validateRecordErrorRateExpandViewWidgetTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_057_validate_Topic_RecordErrorRateGraph_ExpandViewLegendHeader1() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaProducerTopicPage.validateRecordErrorRateExpandViewLegendHeader1();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_058_validate_Topic_RecordErrorRateGraph_ExpandViewLegendHeader2() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaProducerTopicPage.validateRecordErrorRateExpandViewLegendHeader2();
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_059_validate_Topic_RecordErrorRateGraph_ExpandViewLegendHeader3() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaProducerTopicPage.validateRecordErrorRateExpandViewLegendHeader3();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_060_validate_Topic_RecordErrorRateGraph_ExpandViewZoomInBtn() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaProducerTopicPage.validateRecordErrorRateExpandViewZoomIn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_061_validate_Topic_RecordErrorRateGraph_ExpandViewZoomOutBtn() throws EncryptedDocumentException, IOException, InterruptedException {	 
		KafkaProducerTopicPage.validateRecordErrorRateExpandViewZoomOut();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_062_validate_Topic_RecordErrorRateGraph_ExpandViewWidgetDragDrop() throws EncryptedDocumentException, IOException, InterruptedException {		 
		KafkaProducerTopicPage.validateRecordErrorRateExpandViewWidgetDragDrop();
	}	
	
	
/*
 *  Record Error Total Graph	
 */
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_063_validate_Topic_RecordErrorTotalGraph_Title() throws EncryptedDocumentException, IOException {
		KafkaProducerTopicPage.validateRecordErrorTotalGraphTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Producer, "Topic_RecordErrorTotal_Graph_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_064_validate_Topic_RecordErrorTotalGraph_ZoomIn() throws EncryptedDocumentException, IOException {
		KafkaProducerTopicPage.validateRecordErrorTotalZoomInBtn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_065_validate_Topic_RecordErrorTotalGraph_ZoomOut() throws EncryptedDocumentException, IOException {
		KafkaProducerTopicPage.validateRecordErrorTotalZoomOutBtn();
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_066_validate_Topic_RecordErrorTotalGraph_DragAndDrop() throws EncryptedDocumentException, IOException {
		KafkaProducerTopicPage.validateRecordErrorTotalDragAndDrop();
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_067_validate_Topic_RecordErrorTotalGraph_XaxisTitle() throws EncryptedDocumentException, IOException {
		KafkaProducerTopicPage.validateRecordErrorTotalGraphXaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Producer, "Topic_RecordErrorTotal_Xaxis_Title"));
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_068_validate_Topic_RecordErrorTotalGraph_YaxisTitle() throws EncryptedDocumentException, IOException {
		KafkaProducerTopicPage.validateRecordErrorTotalGraphYaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Producer, "Topic_RecordErrorTotal_Yaxis_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_069_validate_Topic_RecordErrorTotalGraph_LegendTitle1() throws EncryptedDocumentException, IOException {
		KafkaProducerTopicPage.validateRecordErrorTotalGraphLegendTitle1(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Producer, "Topic_RecordErrorTotal_Topic_Header_Title"));
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_070_validate_Topic_RecordErrorTotalGraph_LegendTitle2() throws EncryptedDocumentException, IOException {
		KafkaProducerTopicPage.validateRecordErrorTotalGraphLegendTitle2(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Producer, "Topic_RecordErrorTotal_Avg_Header_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_071_validate_Topic_RecordErrorTotalGraph_LegendTitle3() throws EncryptedDocumentException, IOException {
		KafkaProducerTopicPage.validateRecordErrorTotalGraphLegendTitle3(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Producer, "Topic_RecordErrorTotal_Max_Header_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_072_validate_Topic_RecordErrorTotalGraph_ToolTip() throws EncryptedDocumentException, IOException {
		KafkaProducerTopicPage.validateRecordErrorTotalToolTipTitle();
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_073_validate_Topic_RecordErrorTotalGraph_ExpandViewXAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaProducerTopicPage.validateRecordErrorTotalExpandViewXAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_074_validate_Topic_RecordErrorTotalGraph_ExpandViewYAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		page.reload();
		KafkaProducerTopicPage.clickOnTopicTab();
		KafkaProducerTopicPage.validateRecordErrorTotalExpandViewYAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_075_validate_Topic_RecordErrorTotalGraph_ExpandViewWidgetTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaProducerTopicPage.validateRecordErrorTotalExpandViewWidgetTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_076_validate_Topic_RecordErrorTotalGraph_ExpandViewLegendHeader1() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaProducerTopicPage.validateRecordErrorTotalExpandViewLegendHeader1();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_077_validate_Topic_RecordErrorTotalGraph_ExpandViewLegendHeader2() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaProducerTopicPage.validateRecordErrorTotalExpandViewLegendHeader2();
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_078_validate_Topic_RecordErrorTotalGraph_ExpandViewLegendHeader3() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaProducerTopicPage.validateRecordErrorTotalExpandViewLegendHeader3();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_079_validate_Topic_RecordErrorTotalGraph_ExpandViewZoomInBtn() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaProducerTopicPage.validateRecordErrorTotalExpandViewZoomIn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_080_validate_Topic_RecordErrorTotalGraph_ExpandViewZoomOutBtn() throws EncryptedDocumentException, IOException, InterruptedException {	 
		KafkaProducerTopicPage.validateRecordErrorTotalExpandViewZoomOut();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_081_validate_Topic_RecordErrorTotalGraph_ExpandViewWidgetDragDrop() throws EncryptedDocumentException, IOException, InterruptedException {		 
		KafkaProducerTopicPage.validateRecordErrorTotalExpandViewWidgetDragDrop();
	}	
	
	
	@Test(groups= {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_082_validate_ProducerTab_when_TimeRangeisChangedTo_5min() {
		commonPage.selectTheTimeLineFromCalender(IPathConstant.fiveMinutesTimeRange);
		KafkaProducerTopicPage.validateXaxisValuesForKafkaProducerTopicPage();
	}
	
	@Test(groups= {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_083_validate_ProducerTab_when_TimeRangeisChangedTo_15min() {
		commonPage.selectTheTimeLineFromCalender(IPathConstant.fifteenMinutesTimeRange);
		KafkaProducerTopicPage.validateXaxisValuesForKafkaProducerTopicPage();
	}
	
	@Test(groups= {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_084_validate_ProducerTab_when_TimeRangeisChangedTo_30min() {
		commonPage.selectTheTimeLineFromCalender(IPathConstant.thirtyMinutesTimeRange);
		KafkaProducerTopicPage.validateXaxisValuesForKafkaProducerTopicPage();
	}
	
	@Test(groups= {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_085_validate_ProducerTab_when_TimeRangeisChangedTo_60min() {
		commonPage.selectTheTimeLineFromCalender(IPathConstant.sixtyMinutesTimeRange);
		KafkaProducerTopicPage.validateXaxisValuesForKafkaProducerTopicPage();
	}
	
	@Test(groups= {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_086_validate_ProducerTab_when_TimeRangeisChangedTo_3hour() {
		commonPage.selectTheTimeLineFromCalender(IPathConstant.threeHoursTimeRange);
		KafkaProducerTopicPage.validateXaxisValuesForKafkaProducerTopicPage();
	}
	
	@Test(groups= {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_087_validate_ProducerTab_when_TimeRangeisChangedTo_6hour() {
		commonPage.selectTheTimeLineFromCalender(IPathConstant.sixHoursTimeRange);
		KafkaProducerTopicPage.validateXaxisValuesForKafkaProducerTopicPage();
	}
	
	@Test(groups= {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_088_validate_ProducerTab_when_TimeRangeisChangedTo_1Day() {
		commonPage.selectTheTimeLineFromCalender(IPathConstant.oneDayTimeRange);
		KafkaProducerTopicPage.validateXaxisValuesForKafkaProducerTopicPage();
	}
	
	@Test(groups= {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_089_validate_ProducerTab_when_TimeRangeisChangedTo_1Week() {
		commonPage.selectTheTimeLineFromCalender(IPathConstant.oneWeekTimeRange);
		KafkaProducerTopicPage.validateXaxisValuesForKafkaProducerTopicPage();
	}
	
	@Test(groups= {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_090_validate_ProducerTab_when_TimeRangeisChangedTo_1Month() {
		commonPage.selectTheTimeLineFromCalender(IPathConstant.oneMonthTimeRange);
		KafkaProducerTopicPage.validateXaxisValuesForKafkaProducerTopicPage();
	}
	
	@Test(groups= {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_091_validate_ProducerTab_when_TimeRangeisChangedTo_4hour() throws EncryptedDocumentException, IOException {
		commonPage.selectTheCustomeTimeLine(IPathConstant.customTimeRange, excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath, IPathConstant.calenderSheet, "customHoursRange"));
		KafkaProducerTopicPage.validateTheCustomTimeLine(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath, IPathConstant.calenderSheet, "customHoursRange"));
	}
	
	@Test(groups = {"MQM","UI","Regression"})
	public void TC_092_validate_The_All_Widgets_By_selecting_custom_Time_For_Minutes_Range() throws EncryptedDocumentException, IOException
	{	
		//select the time line from calendar
		commonPage.selectTheCustomeTimeLine(IPathConstant.customTimeRange, excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customMinutesRange") );
				
		//Validate whether the widgets are displaying the proper time line or not
		KafkaProducerTopicPage.validateTheCustomTimeLine(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customMinutesRange"));
	}
	
	@Test(groups = {"MQM","UI","Regression"})
	public void TC_093_validate_The_All_Widgets_By_selecting_custom_Time_For_Hours_Range() throws EncryptedDocumentException, IOException
	{	
		//select the time line from calendar
		commonPage.selectTheCustomeTimeLine(IPathConstant.customTimeRange, excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customHoursRange"));

		//Validate whether the widgets are displaying the proper time line or not
		KafkaProducerTopicPage.validateTheCustomTimeLine(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customHoursRange"));
	}
	
	@Test(groups = {"MQM","UI","Regression"})
	public void TC_094_validate_The_All_Widgets_By_selecting_custom_Time_For_Days_Range() throws EncryptedDocumentException, IOException
	{
		//select the time line from calendar
		commonPage.selectTheCustomeTimeLine(IPathConstant.customTimeRange, excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customDaysRange"));
		
		//Validate whether the widgets are displaying the proper time line or not
		KafkaProducerTopicPage.validateTheCustomTimeLine(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customDaysRange"));
	}
		
	@Test(groups = {"MQM","UI","Regression"})
	public void TC_095_validate_The_All_Widgets_By_selecting_custom_Time_For_Future_date()
	{
		//select the time line from calendar
		commonPage.selectTheTimeLineFromCalender(IPathConstant.fiveMinutesTimeRange);
		
		//select the future time line from calendar
		commonPage.validateTheFutureTimeLine();
	}
	
	
}
