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
import objectRepository.MQM.KafkaBrokerTopicPage;

public class KafkaBrokerTopicTest extends BaseClass
{
	GenericMethods util = new GenericMethods();
	CommonPage commonPage;
	KafkaBrokerTopicPage KafkaBrokerTopicPage;
	ExcelUtility excel = new ExcelUtility();	

	@BeforeMethod
	public void Broker() throws EncryptedDocumentException, IOException 
	{
		commonPage = new CommonPage(page);
		KafkaBrokerTopicPage = new KafkaBrokerTopicPage(page);
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
		KafkaBrokerTopicPage.navigateToKafka(messageQueue);
		page.waitForLoadState(LoadState.NETWORKIDLE);
		page.waitForTimeout(3000);
		String application = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Load, "Application");
		KafkaBrokerTopicPage.selectServiceName(application);
		commonPage.selectTheTimeLineFromCalender(IPathConstant.oneMonthTimeRange);
		KafkaBrokerTopicPage.navigateToBrokerTab();
		KafkaBrokerTopicPage.validateTopicTabTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Broker, "Topic_Tab_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_002_validate_Topic_TopicSelect_Title() throws EncryptedDocumentException, IOException {
		KafkaBrokerTopicPage.validateTopicSelectTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Broker, "Topic_TopicSelect_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_003_validate_Topic_TopicSelect_DropDown() throws EncryptedDocumentException, IOException {
		KafkaBrokerTopicPage.validateTopicSelectDropDown();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_004_validate_Topic_BrokerSelect_Title() throws EncryptedDocumentException, IOException {
		KafkaBrokerTopicPage.validateBrokerSelectTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Broker, "Topic_BrokerSelect_Title"));
	}
		
/*
 * Bytes in per second Graph	
 */

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_005_validate_Topic_BytesInPerSecondGraph_Title() throws EncryptedDocumentException, IOException {
		KafkaBrokerTopicPage.validateBytesInPerSecondGraphTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Broker, "Topic_BytesInPerSecond_Graph_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_006_validate_Topic_BytesInPerSecondGraph_ZoomIn() throws EncryptedDocumentException, IOException {
		KafkaBrokerTopicPage.validateBytesInPerSecondZoomInBtn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_007_validate_Topic_BytesInPerSecondGraph_ZoomOut() throws EncryptedDocumentException, IOException {
		KafkaBrokerTopicPage.validateBytesInPerSecondZoomOutBtn();
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_008_validate_Topic_BytesInPerSecondGraph_DragAndDrop() throws EncryptedDocumentException, IOException {
		page.waitForTimeout(2000);
		KafkaBrokerTopicPage.validateBytesInPerSecondDragAndDrop();
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_009_validate_Topic_BytesInPerSecondGraph_XaxisTitle() throws EncryptedDocumentException, IOException {
		KafkaBrokerTopicPage.validateBytesInPerSecondGraphXaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Broker, "Topic_BytesInPerSecond_Xaxis_Title"));
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_010_validate_Topic_BytesInPerSecondGraph_YaxisTitle() throws EncryptedDocumentException, IOException {
		KafkaBrokerTopicPage.validateBytesInPerSecondGraphYaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Broker, "Topic_BytesInPerSecond_Yaxis_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_011_validate_Topic_BytesInPerSecondGraph_LegendTitle1() throws EncryptedDocumentException, IOException {
		KafkaBrokerTopicPage.validateBytesInPerSecondGraphLegendTitle1(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Broker, "Topic_BytesInPerSecond_Broker_Header_Title"));
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_012_validate_Topic_BytesInPerSecondGraph_LegendTitle2() throws EncryptedDocumentException, IOException {
		KafkaBrokerTopicPage.validateBytesInPerSecondGraphLegendTitle2(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Broker, "Topic_BytesInPerSecond_Avg_Header_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_013_validate_Topic_BytesInPerSecondGraph_LegendTitle3() throws EncryptedDocumentException, IOException {
		KafkaBrokerTopicPage.validateBytesInPerSecondGraphLegendTitle3(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Broker, "Topic_BytesInPerSecond_Max_Header_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_014_validate_Topic_BytesInPerSecondGraph_ToolTip() throws EncryptedDocumentException, IOException {
		page.waitForTimeout(2000);
		KafkaBrokerTopicPage.validateBytesInPerSecondToolTipTitle();
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_015_validate_Topic_BytesInPerSecondGraph_ExpandViewXAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaBrokerTopicPage.validateBytesInPerSecondExpandViewXAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_016_validate_Topic_BytesInPerSecondGraph_ExpandViewYAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaBrokerTopicPage.validateBytesInPerSecondExpandViewYAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_017_validate_Topic_BytesInPerSecondGraph_ExpandViewWidgetTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaBrokerTopicPage.validateBytesInPerSecondExpandViewWidgetTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_018_validate_Topic_BytesInPerSecondGraph_ExpandViewLegendHeader1() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaBrokerTopicPage.validateBytesInPerSecondExpandViewLegendHeader1();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_019_validate_Topic_BytesInPerSecondGraph_ExpandViewLegendHeader2() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaBrokerTopicPage.validateBytesInPerSecondExpandViewLegendHeader2();
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_020_validate_Topic_BytesInPerSecondGraph_ExpandViewLegendHeader3() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaBrokerTopicPage.validateBytesInPerSecondExpandViewLegendHeader3();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_021_validate_Topic_BytesInPerSecondGraph_ExpandViewZoomInBtn() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaBrokerTopicPage.validateBytesInPerSecondExpandViewZoomIn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_022_validate_Topic_BytesInPerSecondGraph_ExpandViewZoomOutBtn() throws EncryptedDocumentException, IOException, InterruptedException {	 
		KafkaBrokerTopicPage.validateBytesInPerSecondExpandViewZoomOut();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_023_validate_Topic_BytesInPerSecondGraph_ExpandViewWidgetDragDrop() throws EncryptedDocumentException, IOException, InterruptedException {		 
		page.waitForTimeout(2000);
		KafkaBrokerTopicPage.validateBytesInPerSecondExpandViewWidgetDragDrop();
	}	
	
/*
 *  Bytes in per second mean value Graph	
 */
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_024_validate_Topic_BytesInPerSecondMeanValueGraph_Title() throws EncryptedDocumentException, IOException {
		KafkaBrokerTopicPage.validateBytesInPerSecondMeanValueGraphTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Broker, "Topic_BytesInPerSecondMeanValue_Graph_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_025_validate_Topic_BytesInPerSecondMeanValueGraph_ZoomIn() throws EncryptedDocumentException, IOException {
		KafkaBrokerTopicPage.validateBytesInPerSecondMeanValueZoomInBtn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_026_validate_Topic_BytesInPerSecondMeanValueGraph_ZoomOut() throws EncryptedDocumentException, IOException {
		KafkaBrokerTopicPage.validateBytesInPerSecondMeanValueZoomOutBtn();
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_027_validate_Topic_BytesInPerSecondMeanValueGraph_DragAndDrop() throws EncryptedDocumentException, IOException {
		KafkaBrokerTopicPage.validateBytesInPerSecondMeanValueDragAndDrop();
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_028_validate_Topic_BytesInPerSecondMeanValueGraph_XaxisTitle() throws EncryptedDocumentException, IOException {
		KafkaBrokerTopicPage.validateBytesInPerSecondMeanValueGraphXaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Broker, "Topic_BytesInPerSecondMeanValue_Xaxis_Title"));
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_029_validate_Topic_BytesInPerSecondMeanValueGraph_YaxisTitle() throws EncryptedDocumentException, IOException {
		KafkaBrokerTopicPage.validateBytesInPerSecondMeanValueGraphYaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Broker, "Topic_BytesInPerSecondMeanValue_Yaxis_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_030_validate_Topic_BytesInPerSecondMeanValueGraph_LegendTitle1() throws EncryptedDocumentException, IOException {
		KafkaBrokerTopicPage.validateBytesInPerSecondMeanValueGraphLegendTitle1(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Broker, "Topic_BytesInPerSecondMeanValue_Broker_Header_Title"));
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_031_validate_Topic_BytesInPerSecondMeanValueGraph_LegendTitle2() throws EncryptedDocumentException, IOException {
		KafkaBrokerTopicPage.validateBytesInPerSecondMeanValueGraphLegendTitle2(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Broker, "Topic_BytesInPerSecondMeanValue_Avg_Header_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_032_validate_Topic_BytesInPerSecondMeanValueGraph_LegendTitle3() throws EncryptedDocumentException, IOException {
		KafkaBrokerTopicPage.validateBytesInPerSecondMeanValueGraphLegendTitle3(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Broker, "Topic_BytesInPerSecondMeanValue_Max_Header_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_033_validate_Topic_BytesInPerSecondMeanValueGraph_ToolTip() throws EncryptedDocumentException, IOException {
		KafkaBrokerTopicPage.validateBytesInPerSecondMeanValueToolTipTitle();
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_034_validate_Topic_BytesInPerSecondMeanValueGraph_ExpandViewXAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaBrokerTopicPage.validateBytesInPerSecondMeanValueExpandViewXAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_035_validate_Topic_BytesInPerSecondMeanValueGraph_ExpandViewYAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaBrokerTopicPage.validateBytesInPerSecondMeanValueExpandViewYAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_036_validate_Topic_BytesInPerSecondMeanValueGraph_ExpandViewWidgetTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaBrokerTopicPage.validateBytesInPerSecondMeanValueExpandViewWidgetTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_037_validate_Topic_BytesInPerSecondMeanValueGraph_ExpandViewLegendHeader1() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaBrokerTopicPage.validateBytesInPerSecondMeanValueExpandViewLegendHeader1();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_038_validate_Topic_BytesInPerSecondMeanValueGraph_ExpandViewLegendHeader2() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaBrokerTopicPage.validateBytesInPerSecondMeanValueExpandViewLegendHeader2();
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_039_validate_Topic_BytesInPerSecondMeanValueGraph_ExpandViewLegendHeader3() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaBrokerTopicPage.validateBytesInPerSecondMeanValueExpandViewLegendHeader3();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_040_validate_Topic_BytesInPerSecondMeanValueGraph_ExpandViewZoomInBtn() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaBrokerTopicPage.validateBytesInPerSecondMeanValueExpandViewZoomIn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_041_validate_Topic_BytesInPerSecondMeanValueGraph_ExpandViewZoomOutBtn() throws EncryptedDocumentException, IOException, InterruptedException {	 
		KafkaBrokerTopicPage.validateBytesInPerSecondMeanValueExpandViewZoomOut();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_042_validate_Topic_BytesInPerSecondMeanValueGraph_ExpandViewWidgetDragDrop() throws EncryptedDocumentException, IOException, InterruptedException {		 
		KafkaBrokerTopicPage.validateBytesInPerSecondMeanValueExpandViewWidgetDragDrop();
	}	
	
/*
 *  Bytes Out Per Second Graph	
 */
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_043_validate_Topic_BytesOutPerSecondGraph_Title() throws EncryptedDocumentException, IOException {
		KafkaBrokerTopicPage.validateBytesOutPerSecondGraphTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Broker, "Topic_BytesOutPerSecond_Graph_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_044_validate_Topic_BytesOutPerSecondGraph_ZoomIn() throws EncryptedDocumentException, IOException {
		KafkaBrokerTopicPage.validateBytesOutPerSecondZoomInBtn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_045_validate_Topic_BytesOutPerSecondGraph_ZoomOut() throws EncryptedDocumentException, IOException {
		KafkaBrokerTopicPage.validateBytesOutPerSecondZoomOutBtn();
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_046_validate_Topic_BytesOutPerSecondGraph_DragAndDrop() throws EncryptedDocumentException, IOException {
		KafkaBrokerTopicPage.validateBytesOutPerSecondDragAndDrop();
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_047_validate_Topic_BytesOutPerSecondGraph_XaxisTitle() throws EncryptedDocumentException, IOException {
		KafkaBrokerTopicPage.validateBytesOutPerSecondGraphXaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Broker, "Topic_BytesOutPerSecond_Xaxis_Title"));
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_048_validate_Topic_BytesOutPerSecondGraph_YaxisTitle() throws EncryptedDocumentException, IOException {
		KafkaBrokerTopicPage.validateBytesOutPerSecondGraphYaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Broker, "Topic_BytesOutPerSecond_Yaxis_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_049_validate_Topic_BytesOutPerSecondGraph_LegendTitle1() throws EncryptedDocumentException, IOException {
		KafkaBrokerTopicPage.validateBytesOutPerSecondGraphLegendTitle1(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Broker, "Topic_BytesOutPerSecond_Broker_Header_Title"));
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_050_validate_Topic_BytesOutPerSecondGraph_LegendTitle2() throws EncryptedDocumentException, IOException {
		KafkaBrokerTopicPage.validateBytesOutPerSecondGraphLegendTitle2(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Broker, "Topic_BytesOutPerSecond_Avg_Header_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_051_validate_Topic_BytesOutPerSecondGraph_LegendTitle3() throws EncryptedDocumentException, IOException {
		KafkaBrokerTopicPage.validateBytesOutPerSecondGraphLegendTitle3(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Broker, "Topic_BytesOutPerSecond_Max_Header_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_052_validate_Topic_BytesOutPerSecondGraph_ToolTip() throws EncryptedDocumentException, IOException {
		KafkaBrokerTopicPage.validateBytesOutPerSecondToolTipTitle();
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_053_validate_Topic_BytesOutPerSecondGraph_ExpandViewXAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaBrokerTopicPage.validateBytesOutPerSecondExpandViewXAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_054_validate_Topic_BytesOutPerSecondGraph_ExpandViewYAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		page.reload();
		KafkaBrokerTopicPage.validateBytesOutPerSecondExpandViewYAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_055_validate_Topic_BytesOutPerSecondGraph_ExpandViewWidgetTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaBrokerTopicPage.validateBytesOutPerSecondExpandViewWidgetTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_056_validate_Topic_BytesOutPerSecondGraph_ExpandViewLegendHeader1() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaBrokerTopicPage.validateBytesOutPerSecondExpandViewLegendHeader1();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_057_validate_Topic_BytesOutPerSecondGraph_ExpandViewLegendHeader2() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaBrokerTopicPage.validateBytesOutPerSecondExpandViewLegendHeader2();
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_058_validate_Topic_BytesOutPerSecondGraph_ExpandViewLegendHeader3() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaBrokerTopicPage.validateBytesOutPerSecondExpandViewLegendHeader3();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_059_validate_Topic_BytesOutPerSecondGraph_ExpandViewZoomInBtn() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaBrokerTopicPage.validateBytesOutPerSecondExpandViewZoomIn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_060_validate_Topic_BytesOutPerSecondGraph_ExpandViewZoomOutBtn() throws EncryptedDocumentException, IOException, InterruptedException {	 
		KafkaBrokerTopicPage.validateBytesOutPerSecondExpandViewZoomOut();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_061_validate_Topic_BytesOutPerSecondGraph_ExpandViewWidgetDragDrop() throws EncryptedDocumentException, IOException, InterruptedException {		 
		KafkaBrokerTopicPage.validateBytesOutPerSecondExpandViewWidgetDragDrop();
	}	
	
	
/*
 *  Bytes Out Per Second Mean Value Graph	
 */
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_062_validate_Topic_BytesOutPerSecondMeanValueGraph_Title() throws EncryptedDocumentException, IOException {
		KafkaBrokerTopicPage.validateBytesOutPerSecondMeanValueGraphTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Broker, "Topic_BytesOutPerSecondMeanValue_Graph_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_063_validate_Topic_BytesOutPerSecondMeanValueGraph_ZoomIn() throws EncryptedDocumentException, IOException {
		KafkaBrokerTopicPage.validateBytesOutPerSecondMeanValueZoomInBtn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_064_validate_Topic_BytesOutPerSecondMeanValueGraph_ZoomOut() throws EncryptedDocumentException, IOException {
		KafkaBrokerTopicPage.validateBytesOutPerSecondMeanValueZoomOutBtn();
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_065_validate_Topic_BytesOutPerSecondMeanValueGraph_DragAndDrop() throws EncryptedDocumentException, IOException {
		KafkaBrokerTopicPage.validateBytesOutPerSecondMeanValueDragAndDrop();
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_066_validate_Topic_BytesOutPerSecondMeanValueGraph_XaxisTitle() throws EncryptedDocumentException, IOException {
		KafkaBrokerTopicPage.validateBytesOutPerSecondMeanValueGraphXaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Broker, "Topic_BytesOutPerSecondMeanValue_Xaxis_Title"));
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_067_validate_Topic_BytesOutPerSecondMeanValueGraph_YaxisTitle() throws EncryptedDocumentException, IOException {
		KafkaBrokerTopicPage.validateBytesOutPerSecondMeanValueGraphYaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Broker, "Topic_BytesOutPerSecondMeanValue_Yaxis_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_068_validate_Topic_BytesOutPerSecondMeanValueGraph_LegendTitle1() throws EncryptedDocumentException, IOException {
		KafkaBrokerTopicPage.validateBytesOutPerSecondMeanValueGraphLegendTitle1(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Broker, "Topic_BytesOutPerSecondMeanValue_Broker_Header_Title"));
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_069_validate_Topic_BytesOutPerSecondMeanValueGraph_LegendTitle2() throws EncryptedDocumentException, IOException {
		KafkaBrokerTopicPage.validateBytesOutPerSecondMeanValueGraphLegendTitle2(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Broker, "Topic_BytesOutPerSecondMeanValue_Avg_Header_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_070_validate_Topic_BytesOutPerSecondMeanValueGraph_LegendTitle3() throws EncryptedDocumentException, IOException {
		KafkaBrokerTopicPage.validateBytesOutPerSecondMeanValueGraphLegendTitle3(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Broker, "Topic_BytesOutPerSecondMeanValue_Max_Header_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_071_validate_Topic_BytesOutPerSecondMeanValueGraph_ToolTip() throws EncryptedDocumentException, IOException {
		KafkaBrokerTopicPage.validateBytesOutPerSecondMeanValueToolTipTitle();
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_072_validate_Topic_BytesOutPerSecondMeanValueGraph_ExpandViewXAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaBrokerTopicPage.validateBytesOutPerSecondMeanValueExpandViewXAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_073_validate_Topic_BytesOutPerSecondMeanValueGraph_ExpandViewYAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaBrokerTopicPage.validateBytesOutPerSecondMeanValueExpandViewYAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_074_validate_Topic_BytesOutPerSecondMeanValueGraph_ExpandViewWidgetTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaBrokerTopicPage.validateBytesOutPerSecondMeanValueExpandViewWidgetTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_075_validate_Topic_BytesOutPerSecondMeanValueGraph_ExpandViewLegendHeader1() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaBrokerTopicPage.validateBytesOutPerSecondMeanValueExpandViewLegendHeader1();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_076_validate_Topic_BytesOutPerSecondMeanValueGraph_ExpandViewLegendHeader2() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaBrokerTopicPage.validateBytesOutPerSecondMeanValueExpandViewLegendHeader2();
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_077_validate_Topic_BytesOutPerSecondMeanValueGraph_ExpandViewLegendHeader3() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaBrokerTopicPage.validateBytesOutPerSecondMeanValueExpandViewLegendHeader3();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_078_validate_Topic_BytesOutPerSecondMeanValueGraph_ExpandViewZoomInBtn() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaBrokerTopicPage.validateBytesOutPerSecondMeanValueExpandViewZoomIn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_079_validate_Topic_BytesOutPerSecondMeanValueGraph_ExpandViewZoomOutBtn() throws EncryptedDocumentException, IOException, InterruptedException {	 
		KafkaBrokerTopicPage.validateBytesOutPerSecondMeanValueExpandViewZoomOut();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_080_validate_Topic_BytesOutPerSecondMeanValueGraph_ExpandViewWidgetDragDrop() throws EncryptedDocumentException, IOException, InterruptedException {		 
		KafkaBrokerTopicPage.validateBytesOutPerSecondMeanValueExpandViewWidgetDragDrop();
	}	
	
/*
 * Message Count Graph	
 */
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_081_validate_Topic_MessageCountGraph_Title() throws EncryptedDocumentException, IOException {
		KafkaBrokerTopicPage.validateMessageCountGraphTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Broker, "Topic_MessageCount_Graph_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_082_validate_Topic_MessageCountGraph_ZoomIn() throws EncryptedDocumentException, IOException {
		KafkaBrokerTopicPage.validateMessageCountZoomInBtn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_083_validate_Topic_MessageCountGraph_ZoomOut() throws EncryptedDocumentException, IOException {
		KafkaBrokerTopicPage.validateMessageCountZoomOutBtn();
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_084_validate_Topic_MessageCountGraph_DragAndDrop() throws EncryptedDocumentException, IOException {
		KafkaBrokerTopicPage.validateMessageCountDragAndDrop();
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_085_validate_Topic_MessageCountGraph_XaxisTitle() throws EncryptedDocumentException, IOException {
		KafkaBrokerTopicPage.validateMessageCountGraphXaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Broker, "Topic_MessageCount_Xaxis_Title"));
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_086_validate_Topic_MessageCountGraph_YaxisTitle() throws EncryptedDocumentException, IOException {
		KafkaBrokerTopicPage.validateMessageCountGraphYaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Broker, "Topic_MessageCount_Yaxis_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_087_validate_Topic_MessageCountGraph_LegendTitle1() throws EncryptedDocumentException, IOException {
		KafkaBrokerTopicPage.validateMessageCountGraphLegendTitle1(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Broker, "Topic_MessageCount_Broker_Header_Title"));
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_088_validate_Topic_MessageCountGraph_LegendTitle2() throws EncryptedDocumentException, IOException {
		KafkaBrokerTopicPage.validateMessageCountGraphLegendTitle2(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Broker, "Topic_MessageCount_Avg_Header_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_089_validate_Topic_MessageCountGraph_LegendTitle3() throws EncryptedDocumentException, IOException {
		KafkaBrokerTopicPage.validateMessageCountGraphLegendTitle3(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Broker, "Topic_MessageCount_Max_Header_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_090_validate_Topic_MessageCountGraph_ToolTip() throws EncryptedDocumentException, IOException {
		KafkaBrokerTopicPage.validateMessageCountToolTipTitle();
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_091_validate_Topic_MessageCountGraph_ExpandViewXAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaBrokerTopicPage.validateMessageCountExpandViewXAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_092_validate_Topic_MessageCountGraph_ExpandViewYAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		page.reload();
		KafkaBrokerTopicPage.validateMessageCountExpandViewYAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_093_validate_Topic_MessageCountGraph_ExpandViewWidgetTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaBrokerTopicPage.validateMessageCountExpandViewWidgetTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_094_validate_Topic_MessageCountGraph_ExpandViewLegendHeader1() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaBrokerTopicPage.validateMessageCountExpandViewLegendHeader1();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_095_validate_Topic_MessageCountGraph_ExpandViewLegendHeader2() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaBrokerTopicPage.validateMessageCountExpandViewLegendHeader2();
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_096_validate_Topic_MessageCountGraph_ExpandViewLegendHeader3() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaBrokerTopicPage.validateMessageCountExpandViewLegendHeader3();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_097_validate_Topic_MessageCountGraph_ExpandViewZoomInBtn() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaBrokerTopicPage.validateMessageCountExpandViewZoomIn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_098_validate_Topic_MessageCountGraph_ExpandViewZoomOutBtn() throws EncryptedDocumentException, IOException, InterruptedException {	 
		KafkaBrokerTopicPage.validateMessageCountExpandViewZoomOut();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_099_validate_Topic_MessageCountGraph_ExpandViewWidgetDragDrop() throws EncryptedDocumentException, IOException, InterruptedException {		 
		KafkaBrokerTopicPage.validateMessageCountExpandViewWidgetDragDrop();
	}	
	
	
	
	@Test(groups= {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_100_validate_BrokerTab_when_TimeRangeisChangedTo_5min() {
		commonPage.selectTheTimeLineFromCalender(IPathConstant.fiveMinutesTimeRange);
		KafkaBrokerTopicPage.validateXaxisValuesForKafkaBrokerTopicPage();
	}
	@Test(groups= {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_101_validate_BrokerTab_when_TimeRangeisChangedTo_15min() {
		commonPage.selectTheTimeLineFromCalender(IPathConstant.fifteenMinutesTimeRange);
		KafkaBrokerTopicPage.validateXaxisValuesForKafkaBrokerTopicPage();
	}
	@Test(groups= {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_102_validate_BrokerTab_when_TimeRangeisChangedTo_30min() {
		commonPage.selectTheTimeLineFromCalender(IPathConstant.thirtyMinutesTimeRange);
		KafkaBrokerTopicPage.validateXaxisValuesForKafkaBrokerTopicPage();
	}
	@Test(groups= {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_103_validate_BrokerTab_when_TimeRangeisChangedTo_60min() {
		commonPage.selectTheTimeLineFromCalender(IPathConstant.sixtyMinutesTimeRange);
		KafkaBrokerTopicPage.validateXaxisValuesForKafkaBrokerTopicPage();
	}
	@Test(groups= {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_104_validate_BrokerTab_when_TimeRangeisChangedTo_3hour() {
		commonPage.selectTheTimeLineFromCalender(IPathConstant.threeHoursTimeRange);
		KafkaBrokerTopicPage.validateXaxisValuesForKafkaBrokerTopicPage();
	}
	@Test(groups= {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_105_validate_BrokerTab_when_TimeRangeisChangedTo_6hour() {
		commonPage.selectTheTimeLineFromCalender(IPathConstant.sixHoursTimeRange);
		KafkaBrokerTopicPage.validateXaxisValuesForKafkaBrokerTopicPage();
	}
	@Test(groups= {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_106_validate_BrokerTab_when_TimeRangeisChangedTo_1Day() {
		commonPage.selectTheTimeLineFromCalender(IPathConstant.oneDayTimeRange);
		KafkaBrokerTopicPage.validateXaxisValuesForKafkaBrokerTopicPage();
	}
	@Test(groups= {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_107_validate_BrokerTab_when_TimeRangeisChangedTo_1Week() {
		commonPage.selectTheTimeLineFromCalender(IPathConstant.oneWeekTimeRange);
		KafkaBrokerTopicPage.validateXaxisValuesForKafkaBrokerTopicPage();
	}
	@Test(groups= {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_108_validate_BrokerTab_when_TimeRangeisChangedTo_1Month() throws EncryptedDocumentException, IOException {
		commonPage.selectTheTimeLineFromCalender(IPathConstant.oneMonthTimeRange);
		KafkaBrokerTopicPage.validateXaxisValuesForKafkaBrokerTopicPage();
	}
	@Test(groups= {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_109_validate_BrokerTab_when_TimeRangeisChangedTo_4hour() throws EncryptedDocumentException, IOException {
		commonPage.selectTheCustomeTimeLine(IPathConstant.customTimeRange, excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath, IPathConstant.calenderSheet, "customHoursRange"));
		KafkaBrokerTopicPage.validateTheCustomTimeLine(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath, IPathConstant.calenderSheet, "customHoursRange"));
	}
	
	@Test(groups = {"MQM","UI","Regression"})
	public void TC_110_validate_The_All_Widgets_By_selecting_custom_Time_For_Minutes_Range() throws EncryptedDocumentException, IOException
	{	
		//select the time line from calendar
		commonPage.selectTheCustomeTimeLine(IPathConstant.customTimeRange, excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customMinutesRange") );
				
		//Validate whether the widgets are displaying the proper time line or not
		KafkaBrokerTopicPage.validateTheCustomTimeLine(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customMinutesRange"));
	}
	@Test(groups = {"MQM","UI","Regression"})
	public void TC_111_validate_The_All_Widgets_By_selecting_custom_Time_For_Hours_Range() throws EncryptedDocumentException, IOException
	{	
		//select the time line from calendar
		commonPage.selectTheCustomeTimeLine(IPathConstant.customTimeRange, excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customHoursRange"));

		//Validate whether the widgets are displaying the proper time line or not
		KafkaBrokerTopicPage.validateTheCustomTimeLine(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customHoursRange"));
	}
	@Test(groups = {"MQM","UI","Regression"})
	public void TC_112_validate_The_All_Widgets_By_selecting_custom_Time_For_Days_Range() throws EncryptedDocumentException, IOException
	{
		//select the time line from calendar
		commonPage.selectTheCustomeTimeLine(IPathConstant.customTimeRange, excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customDaysRange"));
		
		//Validate whether the widgets are displaying the proper time line or not
		KafkaBrokerTopicPage.validateTheCustomTimeLine(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customDaysRange"));
	}
		
	@Test(groups = {"MQM","UI","Regression"})
	public void TC_113_validate_The_All_Widgets_By_selecting_custom_Time_For_Future_date()
	{
		//select the time line from calendar
		commonPage.selectTheTimeLineFromCalender(IPathConstant.fiveMinutesTimeRange);
		
		//select the future time line from calendar
		commonPage.validateTheFutureTimeLine();
	}
}
