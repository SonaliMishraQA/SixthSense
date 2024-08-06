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
import objectRepository.MQM.KafkaProducerBrokerPage;

public class KafkaProducerBrokerTest extends BaseClass
{
	GenericMethods util = new GenericMethods();
	CommonPage commonPage;
	KafkaProducerBrokerPage KafkaProducerBrokerPage;
	ExcelUtility excel = new ExcelUtility();	

	@BeforeMethod
	public void Producer() throws EncryptedDocumentException, IOException 
	{
		commonPage = new CommonPage(page);
		KafkaProducerBrokerPage = new KafkaProducerBrokerPage(page);
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
		KafkaProducerBrokerPage.navigateToKafka(messageQueue);
		page.waitForLoadState(LoadState.NETWORKIDLE);
		page.waitForTimeout(5000);
		String application = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Load, "Application");
		KafkaProducerBrokerPage.selectServiceName(application);
		commonPage.selectTheTimeLineFromCalender(IPathConstant.oneMonthTimeRange);
		KafkaProducerBrokerPage.navigateToProducerTab();
		KafkaProducerBrokerPage.validateBrokerTabTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Producer, "Broker_Tab_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_002_validate_Broker_Producer_Title() throws EncryptedDocumentException, IOException {
		KafkaProducerBrokerPage.validateProducerSelectTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Producer, "Broker_ProducerSelect_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_003_validate_Broker_Producer_DropDown() throws EncryptedDocumentException, IOException {
		KafkaProducerBrokerPage.validateProducerSelectDropDown();
	}
	
/*
 * Incoming Bytes Graph	
 */

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_004_validate_Broker_IncomingBytesGraph_Title() throws EncryptedDocumentException, IOException {
		page.waitForLoadState(LoadState.NETWORKIDLE);
		KafkaProducerBrokerPage.validateIncomingBytesGraphTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Producer, "Broker_IncomingBytes_Graph_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_005_validate_Broker_IncomingBytesGraph_ZoomIn() throws EncryptedDocumentException, IOException {
		KafkaProducerBrokerPage.validateIncomingBytesZoomInBtn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_006_validate_Broker_IncomingBytesGraph_ZoomOut() throws EncryptedDocumentException, IOException {
		KafkaProducerBrokerPage.validateIncomingBytesZoomOutBtn();
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_007_validate_Broker_IncomingBytesGraph_DragAndDrop() throws EncryptedDocumentException, IOException {
		KafkaProducerBrokerPage.validateIncomingBytesDragAndDrop();
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_008_validate_Broker_IncomingBytesGraph_XaxisTitle() throws EncryptedDocumentException, IOException {
		KafkaProducerBrokerPage.validateIncomingBytesGraphXaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Producer, "Broker_IncomingBytes_Xaxis_Title"));
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_009_validate_Broker_IncomingBytesGraph_YaxisTitle() throws EncryptedDocumentException, IOException {
		KafkaProducerBrokerPage.validateIncomingBytesGraphYaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Producer, "Broker_IncomingBytes_Yaxis_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_010_validate_Broker_IncomingBytesGraph_LegendTitle1() throws EncryptedDocumentException, IOException {
		KafkaProducerBrokerPage.validateIncomingBytesGraphLegendTitle1(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Producer, "Broker_IncomingBytes_Producer_Header_Title"));
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_011_validate_Broker_IncomingBytesGraph_LegendTitle2() throws EncryptedDocumentException, IOException {
		KafkaProducerBrokerPage.validateIncomingBytesGraphLegendTitle2(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Producer, "Broker_IncomingBytes_Avg_Header_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_012_validate_Broker_IncomingBytesGraph_LegendTitle3() throws EncryptedDocumentException, IOException {
		KafkaProducerBrokerPage.validateIncomingBytesGraphLegendTitle3(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Producer, "Broker_IncomingBytes_Max_Header_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_013_validate_Broker_IncomingBytesGraph_ToolTip() throws EncryptedDocumentException, IOException {
		KafkaProducerBrokerPage.validateIncomingBytesToolTipTitle();
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_014_validate_Broker_IncomingBytesGraph_ExpandViewXAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaProducerBrokerPage.validateIncomingBytesExpandViewXAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_015_validate_Broker_IncomingBytesGraph_ExpandViewYAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaProducerBrokerPage.validateIncomingBytesExpandViewYAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_016_validate_Broker_IncomingBytesGraph_ExpandViewWidgetTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaProducerBrokerPage.validateIncomingBytesExpandViewWidgetTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_017_validate_Broker_IncomingBytesGraph_ExpandViewLegendHeader1() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaProducerBrokerPage.validateIncomingBytesExpandViewLegendHeader1();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_018_validate_Broker_IncomingBytesGraph_ExpandViewLegendHeader2() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaProducerBrokerPage.validateIncomingBytesExpandViewLegendHeader2();
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_019_validate_Broker_IncomingBytesGraph_ExpandViewLegendHeader3() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaProducerBrokerPage.validateIncomingBytesExpandViewLegendHeader3();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_020_validate_Broker_IncomingBytesGraph_ExpandViewZoomInBtn() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaProducerBrokerPage.validateIncomingBytesExpandViewZoomIn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_021_validate_Broker_IncomingBytesGraph_ExpandViewZoomOutBtn() throws EncryptedDocumentException, IOException, InterruptedException {	 
		KafkaProducerBrokerPage.validateIncomingBytesExpandViewZoomOut();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_022_validate_Broker_IncomingBytesGraph_ExpandViewWidgetDragDrop() throws EncryptedDocumentException, IOException, InterruptedException {		 
		KafkaProducerBrokerPage.validateIncomingBytesExpandViewWidgetDragDrop();
	}	

/*
 *  Outgoing Bytes Graph	
 */
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_023_validate_Broker_OutgoingBytesGraph_Title() throws EncryptedDocumentException, IOException {
		KafkaProducerBrokerPage.validateOutgoingBytesGraphTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Producer, "Broker_OutgoingBytes_Graph_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_024_validate_Broker_OutgoingBytesGraph_ZoomIn() throws EncryptedDocumentException, IOException {
		KafkaProducerBrokerPage.validateOutgoingBytesZoomInBtn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_025_validate_Broker_OutgoingBytesGraph_ZoomOut() throws EncryptedDocumentException, IOException {
		KafkaProducerBrokerPage.validateOutgoingBytesZoomOutBtn();
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_026_validate_Broker_OutgoingBytesGraph_DragAndDrop() throws EncryptedDocumentException, IOException {
		KafkaProducerBrokerPage.validateOutgoingBytesDragAndDrop();
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_027_validate_Broker_OutgoingBytesGraph_XaxisTitle() throws EncryptedDocumentException, IOException {
		KafkaProducerBrokerPage.validateOutgoingBytesGraphXaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Producer, "Broker_OutgoingBytes_Xaxis_Title"));
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_028_validate_Broker_OutgoingBytesGraph_YaxisTitle() throws EncryptedDocumentException, IOException {
		KafkaProducerBrokerPage.validateOutgoingBytesGraphYaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Producer, "Broker_OutgoingBytes_Yaxis_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_029_validate_Broker_OutgoingBytesGraph_LegendTitle1() throws EncryptedDocumentException, IOException {
		KafkaProducerBrokerPage.validateOutgoingBytesGraphLegendTitle1(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Producer, "Broker_OutgoingBytes_Producer_Header_Title"));
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_030_validate_Broker_OutgoingBytesGraph_LegendTitle2() throws EncryptedDocumentException, IOException {
		KafkaProducerBrokerPage.validateOutgoingBytesGraphLegendTitle2(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Producer, "Broker_OutgoingBytes_Avg_Header_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_031_validate_Broker_OutgoingBytesGraph_LegendTitle3() throws EncryptedDocumentException, IOException {
		KafkaProducerBrokerPage.validateOutgoingBytesGraphLegendTitle3(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Producer, "Broker_OutgoingBytes_Max_Header_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_032_validate_Broker_OutgoingBytesGraph_ToolTip() throws EncryptedDocumentException, IOException {
		KafkaProducerBrokerPage.validateOutgoingBytesToolTipTitle();
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_033_validate_Broker_OutgoingBytesGraph_ExpandViewXAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaProducerBrokerPage.validateOutgoingBytesExpandViewXAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_034_validate_Broker_OutgoingBytesGraph_ExpandViewYAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaProducerBrokerPage.validateOutgoingBytesExpandViewYAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_035_validate_Broker_OutgoingBytesGraph_ExpandViewWidgetTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaProducerBrokerPage.validateOutgoingBytesExpandViewWidgetTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_036_validate_Broker_OutgoingBytesGraph_ExpandViewLegendHeader1() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaProducerBrokerPage.validateOutgoingBytesExpandViewLegendHeader1();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_037_validate_Broker_OutgoingBytesGraph_ExpandViewLegendHeader2() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaProducerBrokerPage.validateOutgoingBytesExpandViewLegendHeader2();
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_038_validate_Broker_OutgoingBytesGraph_ExpandViewLegendHeader3() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaProducerBrokerPage.validateOutgoingBytesExpandViewLegendHeader3();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_039_validate_Broker_OutgoingBytesGraph_ExpandViewZoomInBtn() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaProducerBrokerPage.validateOutgoingBytesExpandViewZoomIn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_040_validate_Broker_OutgoingBytesGraph_ExpandViewZoomOutBtn() throws EncryptedDocumentException, IOException, InterruptedException {	 
		KafkaProducerBrokerPage.validateOutgoingBytesExpandViewZoomOut();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_041_validate_Broker_OutgoingBytesGraph_ExpandViewWidgetDragDrop() throws EncryptedDocumentException, IOException, InterruptedException {		 
		KafkaProducerBrokerPage.validateOutgoingBytesExpandViewWidgetDragDrop();
	}	
	
/*
 *  Request size Graph	
 */
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_042_validate_Broker_RequestSizeGraph_Title() throws EncryptedDocumentException, IOException {
		KafkaProducerBrokerPage.validateRequestSizeGraphTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Producer, "Broker_RequestSize_Graph_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_043_validate_Broker_RequestSizeGraph_ZoomIn() throws EncryptedDocumentException, IOException {
		page.reload();
		KafkaProducerBrokerPage.navigateToProducerTab();
		KafkaProducerBrokerPage.validateRequestSizeZoomInBtn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_044_validate_Broker_RequestSizeGraph_ZoomOut() throws EncryptedDocumentException, IOException {
		KafkaProducerBrokerPage.validateRequestSizeZoomOutBtn();
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_045_validate_Broker_RequestSizeGraph_DragAndDrop() throws EncryptedDocumentException, IOException {
		KafkaProducerBrokerPage.validateRequestSizeDragAndDrop();
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_046_validate_Broker_RequestSizeGraph_XaxisTitle() throws EncryptedDocumentException, IOException {
		KafkaProducerBrokerPage.validateRequestSizeGraphXaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Producer, "Broker_RequestSize_Xaxis_Title"));
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_047_validate_Broker_RequestSizeGraph_YaxisTitle() throws EncryptedDocumentException, IOException {
		KafkaProducerBrokerPage.validateRequestSizeGraphYaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Producer, "Broker_RequestSize_Yaxis_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_048_validate_Broker_RequestSizeGraph_LegendTitle1() throws EncryptedDocumentException, IOException {
		KafkaProducerBrokerPage.validateRequestSizeGraphLegendTitle1(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Producer, "Broker_RequestSize_Producer_Header_Title"));
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_049_validate_Broker_RequestSizeGraph_LegendTitle2() throws EncryptedDocumentException, IOException {
		KafkaProducerBrokerPage.validateRequestSizeGraphLegendTitle2(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Producer, "Broker_RequestSize_Avg_Header_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_050_validate_Broker_RequestSizeGraph_LegendTitle3() throws EncryptedDocumentException, IOException {
		KafkaProducerBrokerPage.validateRequestSizeGraphLegendTitle3(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Producer, "Broker_RequestSize_Max_Header_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_051_validate_Broker_RequestSizeGraph_ToolTip() throws EncryptedDocumentException, IOException {
		KafkaProducerBrokerPage.validateRequestSizeToolTipTitle();
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_052_validate_Broker_RequestSizeGraph_ExpandViewXAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaProducerBrokerPage.validateRequestSizeExpandViewXAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_053_validate_Broker_RequestSizeGraph_ExpandViewYAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaProducerBrokerPage.validateRequestSizeExpandViewYAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_054_validate_Broker_RequestSizeGraph_ExpandViewWidgetTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaProducerBrokerPage.validateRequestSizeExpandViewWidgetTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_055_validate_Broker_RequestSizeGraph_ExpandViewLegendHeader1() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaProducerBrokerPage.validateRequestSizeExpandViewLegendHeader1();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_056_validate_Broker_RequestSizeGraph_ExpandViewLegendHeader2() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaProducerBrokerPage.validateRequestSizeExpandViewLegendHeader2();
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_057_validate_Broker_RequestSizeGraph_ExpandViewLegendHeader3() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaProducerBrokerPage.validateRequestSizeExpandViewLegendHeader3();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_058_validate_Broker_RequestSizeGraph_ExpandViewZoomInBtn() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaProducerBrokerPage.validateRequestSizeExpandViewZoomIn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_059_validate_Broker_RequestSizeGraph_ExpandViewZoomOutBtn() throws EncryptedDocumentException, IOException, InterruptedException {	 
		KafkaProducerBrokerPage.validateRequestSizeExpandViewZoomOut();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_060_validate_Broker_RequestSizeGraph_ExpandViewWidgetDragDrop() throws EncryptedDocumentException, IOException, InterruptedException {		 
		KafkaProducerBrokerPage.validateRequestSizeExpandViewWidgetDragDrop();
	}	
	
	
/*
 *  Maximum fetch latency Graph	
 */
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_061_validate_Broker_ResponseRateGraph_Title() throws EncryptedDocumentException, IOException {
		KafkaProducerBrokerPage.validateResponseRateGraphTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Producer, "Broker_ResponseRate_Graph_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_062_validate_Broker_ResponseRateGraph_ZoomIn() throws EncryptedDocumentException, IOException {
		KafkaProducerBrokerPage.validateResponseRateZoomInBtn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_063_validate_Broker_ResponseRateGraph_ZoomOut() throws EncryptedDocumentException, IOException {
		KafkaProducerBrokerPage.validateResponseRateZoomOutBtn();
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_064_validate_Broker_ResponseRateGraph_DragAndDrop() throws EncryptedDocumentException, IOException {
		KafkaProducerBrokerPage.validateResponseRateDragAndDrop();
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_065_validate_Broker_ResponseRateGraph_XaxisTitle() throws EncryptedDocumentException, IOException {
		KafkaProducerBrokerPage.validateResponseRateGraphXaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Producer, "Broker_ResponseRate_Xaxis_Title"));
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_066_validate_Broker_ResponseRateGraph_YaxisTitle() throws EncryptedDocumentException, IOException {
		KafkaProducerBrokerPage.validateResponseRateGraphYaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Producer, "Broker_ResponseRate_Yaxis_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_067_validate_Broker_ResponseRateGraph_LegendTitle1() throws EncryptedDocumentException, IOException {
		KafkaProducerBrokerPage.validateResponseRateGraphLegendTitle1(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Producer, "Broker_ResponseRate_Producer_Header_Title"));
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_068_validate_Broker_ResponseRateGraph_LegendTitle2() throws EncryptedDocumentException, IOException {
		KafkaProducerBrokerPage.validateResponseRateGraphLegendTitle2(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Producer, "Broker_ResponseRate_Avg_Header_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_069_validate_Broker_ResponseRateGraph_LegendTitle3() throws EncryptedDocumentException, IOException {
		KafkaProducerBrokerPage.validateResponseRateGraphLegendTitle3(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Producer, "Broker_ResponseRate_Max_Header_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_070_validate_Broker_ResponseRateGraph_ToolTip() throws EncryptedDocumentException, IOException {
		KafkaProducerBrokerPage.validateResponseRateToolTipTitle();
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_071_validate_Broker_ResponseRateGraph_ExpandViewXAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaProducerBrokerPage.validateResponseRateExpandViewXAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_072_validate_Broker_ResponseRateGraph_ExpandViewYAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaProducerBrokerPage.validateResponseRateExpandViewYAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_073_validate_Broker_ResponseRateGraph_ExpandViewWidgetTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaProducerBrokerPage.validateResponseRateExpandViewWidgetTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_074_validate_Broker_ResponseRateGraph_ExpandViewLegendHeader1() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaProducerBrokerPage.validateResponseRateExpandViewLegendHeader1();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_075_validate_Broker_ResponseRateGraph_ExpandViewLegendHeader2() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaProducerBrokerPage.validateResponseRateExpandViewLegendHeader2();
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_076_validate_Broker_ResponseRateGraph_ExpandViewLegendHeader3() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaProducerBrokerPage.validateResponseRateExpandViewLegendHeader3();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_077_validate_Broker_ResponseRateGraph_ExpandViewZoomInBtn() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaProducerBrokerPage.validateResponseRateExpandViewZoomIn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_078_validate_Broker_ResponseRateGraph_ExpandViewZoomOutBtn() throws EncryptedDocumentException, IOException, InterruptedException {	 
		KafkaProducerBrokerPage.validateResponseRateExpandViewZoomOut();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_079_validate_Broker_ResponseRateGraph_ExpandViewWidgetDragDrop() throws EncryptedDocumentException, IOException, InterruptedException {		 
		KafkaProducerBrokerPage.validateResponseRateExpandViewWidgetDragDrop();
	}	
	
	
	
	@Test(groups= {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_080_validate_ProducerTab_when_TimeRangeisChangedTo_5min() {
		commonPage.selectTheTimeLineFromCalender(IPathConstant.fiveMinutesTimeRange);
		KafkaProducerBrokerPage.validateXaxisValuesForKafkaProducerBrokerPage();
	}
	
	@Test(groups= {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_081_validate_ProducerTab_when_TimeRangeisChangedTo_15min() {
		commonPage.selectTheTimeLineFromCalender(IPathConstant.fifteenMinutesTimeRange);
		KafkaProducerBrokerPage.validateXaxisValuesForKafkaProducerBrokerPage();
	}
	
	@Test(groups= {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_082_validate_ProducerTab_when_TimeRangeisChangedTo_30min() {
		commonPage.selectTheTimeLineFromCalender(IPathConstant.thirtyMinutesTimeRange);
		KafkaProducerBrokerPage.validateXaxisValuesForKafkaProducerBrokerPage();
	}
	
	@Test(groups= {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_083_validate_ProducerTab_when_TimeRangeisChangedTo_60min() {
		commonPage.selectTheTimeLineFromCalender(IPathConstant.sixtyMinutesTimeRange);
		KafkaProducerBrokerPage.validateXaxisValuesForKafkaProducerBrokerPage();
	}
	
	@Test(groups= {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_084_validate_ProducerTab_when_TimeRangeisChangedTo_3hour() {
		commonPage.selectTheTimeLineFromCalender(IPathConstant.threeHoursTimeRange);
		KafkaProducerBrokerPage.validateXaxisValuesForKafkaProducerBrokerPage();
	}
	
	@Test(groups= {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_085_validate_ProducerTab_when_TimeRangeisChangedTo_6hour() {
		commonPage.selectTheTimeLineFromCalender(IPathConstant.sixHoursTimeRange);
		KafkaProducerBrokerPage.validateXaxisValuesForKafkaProducerBrokerPage();
	}
	
	@Test(groups= {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_086_validate_ProducerTab_when_TimeRangeisChangedTo_1Day() {
		commonPage.selectTheTimeLineFromCalender(IPathConstant.oneDayTimeRange);
		KafkaProducerBrokerPage.validateXaxisValuesForKafkaProducerBrokerPage();
	}
	
	@Test(groups= {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_087_validate_ProducerTab_when_TimeRangeisChangedTo_1Week() {
		commonPage.selectTheTimeLineFromCalender(IPathConstant.oneWeekTimeRange);
		KafkaProducerBrokerPage.validateXaxisValuesForKafkaProducerBrokerPage();
	}
	
	@Test(groups= {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_088_validate_ProducerTab_when_TimeRangeisChangedTo_1Month() {
		commonPage.selectTheTimeLineFromCalender(IPathConstant.oneMonthTimeRange);
		KafkaProducerBrokerPage.validateXaxisValuesForKafkaProducerBrokerPage();
	}
	
	@Test(groups= {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_089_validate_ProducerTab_when_TimeRangeisChangedTo_4hour() throws EncryptedDocumentException, IOException {
		commonPage.selectTheCustomeTimeLine(IPathConstant.customTimeRange, excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.calenderSheet, "customHoursRange"));
		KafkaProducerBrokerPage.validateTheCustomTimeLine(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.calenderSheet, "customHoursRange"));
	}
	
	@Test(groups = {"MQM","UI","Regression"})
	public void TC_090_validate_The_All_Widgets_By_selecting_custom_Time_For_Minutes_Range() throws EncryptedDocumentException, IOException
	{	
		//select the time line from calendar
		commonPage.selectTheCustomeTimeLine(IPathConstant.customTimeRange, excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath,IPathConstant.calenderSheet, "customMinutesRange") );
				
		//Validate whether the widgets are displaying the proper time line or not
		KafkaProducerBrokerPage.validateTheCustomTimeLine(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath,IPathConstant.calenderSheet, "customMinutesRange"));
	}
	
	@Test(groups = {"MQM","UI","Regression"})
	public void TC_091_validate_The_All_Widgets_By_selecting_custom_Time_For_Hours_Range() throws EncryptedDocumentException, IOException
	{	
		//select the time line from calendar
		commonPage.selectTheCustomeTimeLine(IPathConstant.customTimeRange, excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath,IPathConstant.calenderSheet, "customHoursRange"));

		//Validate whether the widgets are displaying the proper time line or not
		KafkaProducerBrokerPage.validateTheCustomTimeLine(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath,IPathConstant.calenderSheet, "customHoursRange"));
	}
	
	@Test(groups = {"MQM","UI","Regression"})
	public void TC_092_validate_The_All_Widgets_By_selecting_custom_Time_For_Days_Range() throws EncryptedDocumentException, IOException
	{
		//select the time line from calendar
		commonPage.selectTheCustomeTimeLine(IPathConstant.customTimeRange, excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath,IPathConstant.calenderSheet, "customDaysRange"));
		
		//Validate whether the widgets are displaying the proper time line or not
		KafkaProducerBrokerPage.validateTheCustomTimeLine(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath,IPathConstant.calenderSheet, "customDaysRange"));
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
