package mQMonitoring;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import genericUtilities.ExcelUtility;
import genericUtilities.GenericMethods;
import genericUtilities.IPathConstant;
import objectRepository.CommonPage;
import objectRepository.MQM.MQKafka_Producer_Page;
import playWrightFactory.BaseClass;

public class MQKafka_Producer_Test extends BaseClass 
{
	GenericMethods util = new GenericMethods();
	CommonPage commonPage;
	MQKafka_Producer_Page producerPage;
	ExcelUtility excel = new ExcelUtility();
	
	@BeforeMethod
	public void producer() throws EncryptedDocumentException, IOException {
		commonPage = new CommonPage(page);
		producerPage = new  MQKafka_Producer_Page(page);
		excel = new ExcelUtility();
		commonPage.navigateToMQM();
		producerPage.navigateToKafka();
		commonPage.selectTheTimeLineFromCalender(IPathConstant.oneMonthTimeRange);
		String application = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Load, "Application");
		producerPage.selectServiceName(application);
		producerPage.navigateToProducerTab();
		producerPage.clickOnBrokerTab();
		//page.reload();
		//page.waitForTimeout(1000);
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_001_validate_Producer_Title() throws EncryptedDocumentException, IOException  {

		producerPage.validateProducerTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Producer, "Producer_Tab_Title"));
	}
	
/**
 * Broker Tab
 * @throws EncryptedDocumentException
 * @throws IOException
 */
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_002_validate_Broker_Tab_Title() throws EncryptedDocumentException, IOException {
		producerPage.validateBrokerTabTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Producer, "Broker_Tab_Title"));
	}
	
/********************************************************* Incoming Bytes Graph ******************************************************************/
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_003_validate_Broker_IncomingBytesGraph_Title() throws EncryptedDocumentException, IOException {
		producerPage.validateBrokerIncomingBytesGraphTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Producer, "Broker_IncomingBytes_Graph_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_004_validate_Broker_IncomingBytesGraph_ZoomIn() throws EncryptedDocumentException, IOException {
		producerPage.validateIncomingBytesZoomInBtn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_005_validate_Broker_IncomingBytesGraph_ZoomOut() throws EncryptedDocumentException, IOException {
		producerPage.validateIncomingBytesZoomOutBtn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_006_validate_Broker_IncomingBytesGraph_XaxisValue() throws EncryptedDocumentException, IOException {
		//page.reload();
		producerPage.validateBrokerIncomingBytesXaxisValues();
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_007_validate_Broker_IncomingBytesGraph_XaxisTitle() throws EncryptedDocumentException, IOException {
		producerPage.validateBrokerIncomingBytesGraphXaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Producer, "Broker_IncomingBytes_Xaxis_Title"));
	}	
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_008_validate_Broker_IncomingBytesGraph_YaxisTitle() throws EncryptedDocumentException, IOException {
		producerPage.validateBrokerIncomingBytesGraphYaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Producer, "Broker_IncomingBytes_Yaxis_Title"));
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_009_validate_Broker_IncomingBytesGraph_BrokerHeaderTitle() throws EncryptedDocumentException, IOException {
		producerPage.validateBrokerIncomingBytesGraphBrokerHeaderTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Producer, "Broker_IncomingBytes_Producer_Header_Title"));
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_010_validate_Broker_IncomingBytesGraph_AvgHeaderTitle() throws EncryptedDocumentException, IOException {
		page.waitForTimeout(2000);
		producerPage.validateBrokerIncomingBytesGraphAvgHeaderTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Producer, "Broker_IncomingBytes_Avg_Header_Title"));
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_011_validate_Broker_IncomingBytesGraph_MaxHeaderTitle() throws EncryptedDocumentException, IOException {
		producerPage.validateBrokerIncomingBytesGraphMaxHeaderTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Producer, "Broker_IncomingBytes_Max_Header_Title"));
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_012_validate_Broker_IncomingBytesGraph_RowColor1() throws EncryptedDocumentException, IOException {
		producerPage.validateBrokerIncomingBytesGraphRowColor1(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Producer, "rgb(255, 123, 123)"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_013_validate_Broker_IncomingBytesGraph_ToolTip() throws EncryptedDocumentException, IOException {
		producerPage.validateBrokerIncomingBytesToolTipTitle();
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_014_validate_Broker_IncomingBytesGraph_ExpandViewXAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		producerPage.validateBrokerIncomingBytesExpandViewXAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_015_validate_Broker_IncomingBytesGraph_ExpandViewYAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		producerPage.validateBrokerIncomingBytesExpandViewYAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_016_validate_Broker_IncomingBytesGraph_ExpandViewWidgetTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		producerPage.validateBrokerIncomingBytesExpandViewWidgetTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_017_validate_Broker_IncomingBytesGraph_ExpandViewLegendHeader1() throws EncryptedDocumentException, IOException, InterruptedException {
		producerPage.validateBrokerIncomingBytesExpandViewLegendHeader1();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_018_validate_Broker_IncomingBytesGraph_ExpandViewLegendHeader2() throws EncryptedDocumentException, IOException, InterruptedException {
		producerPage.validateBrokerIncomingBytesExpandViewLegendHeader2();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_019_validate_Broker_IncomingBytesGraph_ExpandViewLegendHeader3() throws EncryptedDocumentException, IOException, InterruptedException {
		producerPage.validateBrokerIncomingBytesExpandViewLegendHeader3();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_020_validate_Broker_IncomingBytesGraph_ExpandViewZoomInBtn() throws EncryptedDocumentException, IOException, InterruptedException {
		producerPage.validateBrokerIncomingBytesExpandViewZoomIn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_021_validate_Broker_IncomingBytesGraph_ExpandViewZoomOutBtn() throws EncryptedDocumentException, IOException, InterruptedException {
		producerPage.validateBrokerIncomingBytesExpandViewZoomOut();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_022_validate_Broker_IncomingBytesGraph_ExpandViewWidgetDragDrop() throws EncryptedDocumentException, IOException, InterruptedException {
		producerPage.validateBrokerIncomingBytesExpandViewWidgetDragDrop();
	}	
	
/********************************************************* Outgoing Bytes Graph ******************************************************************/
	
//	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
//	public void TC_023_validate_Broker_OutgoingBytesGraph_Title() throws EncryptedDocumentException, IOException {
//		producerPage.validateBrokerOutgoingBytesGraphTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Producer, "Broker_OutgoingBytes_Graph_Title"));
//	}
//	
//	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
//	public void TC_024_validate_Broker_OutgoingBytesGraph_ZoomIn() throws EncryptedDocumentException, IOException {
//		producerPage.validateOutgoingBytesZoomInBtn();
//	}
//	
//	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
//	public void TC_025_validate_Broker_OutgoingBytesGraph_ZoomOut() throws EncryptedDocumentException, IOException {
//		producerPage.validateOutgoingBytesZoomOutBtn();
//	}
//	
//	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
//	public void TC_026_validate_Broker_OutgoingBytesGraph_XaxisValue() throws EncryptedDocumentException, IOException {
//		producerPage.validateBrokerOutgoingBytesXaxisValues();
//	}
//		
//	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
//	public void TC_027_validate_Broker_OutgoingBytesGraph_XaxisTitle() throws EncryptedDocumentException, IOException {
//		producerPage.validateBrokerOutgoingBytesGraphXaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Producer, "Broker_OutgoingBytes_Xaxis_Title"));
//	}
//		
//	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
//	public void TC_028_validate_Broker_OutgoingBytesGraph_YaxisTitle() throws EncryptedDocumentException, IOException {
//		producerPage.validateBrokerOutgoingBytesGraphYaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Producer, "Broker_OutgoingBytes_Yaxis_Title"));
//	}
//	
//	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
//	public void TC_029_validate_Broker_OutgoingBytesGraph_BrokerHeaderTitle() throws EncryptedDocumentException, IOException {
//		producerPage.validateBrokerOutgoingBytesGraphBrokerHeaderTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Producer, "Broker_OutgoingBytes_Producer_Header_Title"));
//	}
//	
//	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
//	public void TC_030_validate_Broker_OutgoingBytesGraph_AvgHeaderTitle() throws EncryptedDocumentException, IOException {
//		producerPage.validateBrokerOutgoingBytesGraphAvgHeaderTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Producer, "Broker_OutgoingBytes_Avg_Header_Title"));
//	}
//	
//	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
//	public void TC_031_validate_Broker_OutgoingBytesGraph_MaxHeaderTitle() throws EncryptedDocumentException, IOException {
//		producerPage.validateBrokerOutgoingBytesGraphMaxHeaderTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Producer, "Broker_OutgoingBytes_Max_Header_Title"));
//	}
//	
//	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
//	public void TC_032_validate_Broker_OutgoingBytesGraph_RowColor1() throws EncryptedDocumentException, IOException {
//		producerPage.validateBrokerOutgoingBytesGraphRowColor1(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Producer, "rgb(255, 123, 123)"));
//	}
//	
//	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
//	public void TC_033_validate_Broker_OutgoingBytesGraph_ToolTip() throws EncryptedDocumentException, IOException {
//		producerPage.validateBrokerOutgoingBytesToolTipTitle();
//	}
//	
//	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
//	public void TC_034_validate_Broker_OutgoingBytesGraph_ExpandViewXAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
//		producerPage.validateBrokerOutgoingBytesExpandViewXAxisTitle();
//	}
//	
//	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
//	public void TC_035_validate_Broker_OutgoingBytesGraph_ExpandViewYAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
//		producerPage.validateBrokerOutgoingBytesExpandViewYAxisTitle();
//	}
//	
//	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
//	public void TC_036_validate_Broker_OutgoingBytesGraph_ExpandViewWidgetTitle() throws EncryptedDocumentException, IOException, InterruptedException {
//		page.waitForTimeout(2000);
//		producerPage.validateBrokerOutgoingBytesExpandViewWidgetTitle();
//	}
//	
//	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
//	public void TC_037_validate_Broker_OutgoingBytesGraph_ExpandViewLegendHeader1() throws EncryptedDocumentException, IOException, InterruptedException {
//		producerPage.validateBrokerOutgoingBytesExpandViewLegendHeader1();
//	}
//	
//	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
//	public void TC_038_validate_Broker_OutgoingBytesGraph_ExpandViewLegendHeader2() throws EncryptedDocumentException, IOException, InterruptedException {
//		producerPage.validateBrokerOutgoingBytesExpandViewLegendHeader2();
//	}
//	
//	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
//	public void TC_039_validate_Broker_OutgoingBytesGraph_ExpandViewLegendHeader3() throws EncryptedDocumentException, IOException, InterruptedException {
//		producerPage.validateBrokerOutgoingBytesExpandViewLegendHeader3();
//	}
//	
//	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
//	public void TC_040_validate_Broker_OutgoingBytesGraph_ExpandViewZoomInBtn() throws EncryptedDocumentException, IOException, InterruptedException {
//		producerPage.validateBrokerOutgoingBytesExpandViewZoomIn();
//	}
//	
//	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
//	public void TC_041_validate_Broker_OutgoingBytesGraph_ExpandViewZoomOutBtn() throws EncryptedDocumentException, IOException, InterruptedException {
//		producerPage.validateBrokerOutgoingBytesExpandViewZoomOut();
//	}
//	
//	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
//	public void TC_042_validate_Broker_OutgoingBytesGraph_ExpandViewWidgetDragDrop() throws EncryptedDocumentException, IOException, InterruptedException {
//		producerPage.validateBrokerOutgoingBytesExpandViewWidgetDragDrop();
//	}	
//	
///********************************************************* Request Size Graph ******************************************************************/
//	
//	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
//	public void TC_043_validate_Broker_RequestSizeGraph_Title() throws EncryptedDocumentException, IOException {
//		producerPage.validateBrokerRequestSizeGraphTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Producer, "Broker_RequestSize_Graph_Title"));
//	}
//	
//	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
//	public void TC_044_validate_Broker_RequestSizeGraph_ZoomIn() throws EncryptedDocumentException, IOException {
//		producerPage.validateBrokerRequestSizeZoomInBtn();
//	}
//	
//	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
//	public void TC_045_validate_Broker_RequestSizeGraph_ZoomOut() throws EncryptedDocumentException, IOException {
//		producerPage.validateBrokerRequestSizeZoomOutBtn();
//	}
//
//	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
//	public void TC_046_validate_Broker_RequestSizeGraph_XaxisValue() throws EncryptedDocumentException, IOException {
//		producerPage.validateBrokerRequestSizeXaxisValues();
//	}
//		
//	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
//	public void TC_047_validate_Broker_RequestSizeGraph_XaxisTitle() throws EncryptedDocumentException, IOException {
//		producerPage.validateBrokerRequestSizeGraphXaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Producer, "Broker_RequestSize_Xaxis_Title"));
//	}
//		
//	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
//	public void TC_048_validate_Broker_RequestSizeGraph_YaxisTitle() throws EncryptedDocumentException, IOException {
//		producerPage.validateBrokerRequestSizeGraphYaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Producer, "Broker_RequestSize_Yaxis_Title"));
//	}
//	
//	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
//	public void TC_049_validate_Broker_RequestSizeGraph_BrokerHeaderTitle() throws EncryptedDocumentException, IOException {
//		producerPage.validateBrokerRequestSizeGraphBrokerHeaderTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Producer, "Broker_RequestSize_Producer_Header_Title"));
//	}
//		
//	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
//	public void TC_050_validate_Broker_RequestSizeGraph_AvgHeaderTitle() throws EncryptedDocumentException, IOException {
//		producerPage.validateBrokerRequestSizeGraphAvgHeaderTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Producer, "Broker_RequestSize_Avg_Header_Title"));
//	}
//		
//	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
//	public void TC_051_validate_Broker_RequestSizeGraph_MaxHeaderTitle() throws EncryptedDocumentException, IOException {
//		producerPage.validateBrokerRequestSizeGraphMaxHeaderTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Producer, "Broker_RequestSize_Max_Header_Title"));
//	}
//	
//	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
//	public void TC_052_validate_Broker_RequestSizeGraph_RowColor1() throws EncryptedDocumentException, IOException {
//		producerPage.validateBrokerRequestSizeGraphRowColor1(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Producer, "rgb(255, 123, 123)"));
//	}	
//		
//	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
//	public void TC_053_validate_Broker_RequestSizeGraph_ToolTip() throws EncryptedDocumentException, IOException {
//		producerPage.validateBrokerRequestSizeToolTipTitle();
//	}
//	
//	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
//	public void TC_054_validate_Broker_RequestSizeGraph_ExpandViewXAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
//		producerPage.validateBrokerRequestSizeExpandViewXAxisTitle();
//	}
//	
//	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
//	public void TC_055_validate_Broker_RequestSizeGraph_ExpandViewYAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
//		producerPage.validateBrokerRequestSizeExpandViewYAxisTitle();
//	}
//	
//	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
//	public void TC_056_validate_Broker_RequestSizeGraph_ExpandViewWidgetTitle() throws EncryptedDocumentException, IOException, InterruptedException {
//		producerPage.validateBrokerRequestSizeExpandViewWidgetTitle();
//	}
//	
//	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
//	public void TC_057_validate_Broker_RequestSizeGraph_ExpandViewLegendHeader1() throws EncryptedDocumentException, IOException, InterruptedException {
//		producerPage.validateBrokerRequestSizeExpandViewLegendHeader1();
//	}
//	
//	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
//	public void TC_058_validate_Broker_RequestSizeGraph_ExpandViewLegendHeader2() throws EncryptedDocumentException, IOException, InterruptedException {
//		producerPage.validateBrokerRequestSizeExpandViewLegendHeader2();
//	}
//	
//	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
//	public void TC_059_validate_Broker_RequestSizeGraph_ExpandViewLegendHeader3() throws EncryptedDocumentException, IOException, InterruptedException {
//		producerPage.validateBrokerRequestSizeExpandViewLegendHeader3();
//	}
//	
//	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
//	public void TC_060_validate_Broker_RequestSizeGraph_ExpandViewZoomInBtn() throws EncryptedDocumentException, IOException, InterruptedException {
//		producerPage.validateBrokerRequestSizeExpandViewZoomIn();
//	}
//	
//	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
//	public void TC_061_validate_Broker_RequestSizeGraph_ExpandViewZoomOutBtn() throws EncryptedDocumentException, IOException, InterruptedException {
//		producerPage.validateBrokerRequestSizeExpandViewZoomOut();
//	}
//	
//	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
//	public void TC_062_validate_Broker_RequestSizeGraph_ExpandViewWidgetDragDrop() throws EncryptedDocumentException, IOException, InterruptedException {
//		producerPage.validateBrokerRequestSizeExpandViewWidgetDragDrop();
//	}	
//	
///********************************************************* Response Rate Graph ******************************************************************/
//	
//	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
//	public void TC_063_validate_Broker_ResponseRateGraph_Title() throws EncryptedDocumentException, IOException {
//		producerPage.validateBrokerResponseRateGraphTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Producer, "Broker_ResponseRate_Graph_Title"));
//	}
//		
//	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
//	public void TC_064_validate_Broker_ResponseSizeGraph_ZoomIn() throws EncryptedDocumentException, IOException {
//		producerPage.validateBrokerResponseSizeZoomInBtn();
//	}
//	
//	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
//	public void TC_065_validate_Broker_ResponseSizeGraph_ZoomOut() throws EncryptedDocumentException, IOException {
//		producerPage.validateBrokerResponseSizeZoomOutBtn();
//	}
//	
//	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
//	public void TC_066_validate_Broker_ResponseRateGraph_XaxisValue() throws EncryptedDocumentException, IOException {
//		producerPage.validateBrokerResponseRateXaxisValues();
//	}
//		
//	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
//	public void TC_067_validate_Broker_ResponseRateGraph_XaxisTitle() throws EncryptedDocumentException, IOException {
//		producerPage.validateBrokerResponseRateGraphXaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Producer, "Broker_ResponseRate_Xaxis_Title"));
//	}	
//	
//	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
//	public void TC_068_validate_Broker_ResponseRateGraph_YaxisTitle() throws EncryptedDocumentException, IOException {
//		producerPage.validateBrokerResponseRateGraphYaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Producer, "Broker_ResponseRate_Yaxis_Title"));
//	}
//	
//	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
//	public void TC_069_validate_Broker_ResponseRateGraph_BrokerHeaderTitle() throws EncryptedDocumentException, IOException {
//		producerPage.validateBrokerResponseRateGraphBrokerHeaderTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Producer, "Broker_ResponseRate_Producer_Header_Title"));
//	}	
//
//	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
//	public void TC_070_validate_Broker_ResponseRateGraph_AvgHeaderTitle() throws EncryptedDocumentException, IOException {
//		producerPage.validateBrokerResponseRateGraphAvgHeaderTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Producer, "Broker_ResponseRate_Avg_Header_Title"));
//	}
//		
//	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
//	public void TC_071_validate_Broker_ResponseRateGraph_MaxHeaderTitle() throws EncryptedDocumentException, IOException {
//		producerPage.validateBrokerResponseRateGraphMaxHeaderTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Producer, "Broker_ResponseRate_Max_Header_Title"));
//	}
//	
//	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
//	public void TC_072_validate_Broker_ResponseRateGraph_RowColor1() throws EncryptedDocumentException, IOException {
//		producerPage.validateBrokerResponseRateGraphRowColor1(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Producer, "rgb(255, 123, 123)"));
//	}	
//	
//	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
//	public void TC_073_validate_Broker_ResponseRateGraph_ToolTip() throws EncryptedDocumentException, IOException {
//		producerPage.validateBrokerResponseRateToolTipTitle();
//	}
//	
//	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
//	public void TC_074_validate_Broker_ResponseRateGraph_ExpandViewXAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
//		producerPage.validateBrokerResponseRateExpandViewXAxisTitle();
//	}
//	
//	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
//	public void TC_075_validate_Broker_ResponseRateGraph_ExpandViewYAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
//		producerPage.validateBrokerResponseRateExpandViewYAxisTitle();
//	}
//	
//	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
//	public void TC_076_validate_Broker_ResponseRateGraph_ExpandViewWidgetTitle() throws EncryptedDocumentException, IOException, InterruptedException {
//		producerPage.validateBrokerResponseRateExpandViewWidgetTitle();
//	}
//	
//	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
//	public void TC_077_validate_Broker_ResponseRateGraph_ExpandViewLegendHeader1() throws EncryptedDocumentException, IOException, InterruptedException {
//		producerPage.validateBrokerResponseRateExpandViewLegendHeader1();
//	}
//	
//	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
//	public void TC_078_validate_Broker_ResponseRateGraph_ExpandViewLegendHeader2() throws EncryptedDocumentException, IOException, InterruptedException {
//		producerPage.validateBrokerResponseRateExpandViewLegendHeader2();
//	}
//	
//	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
//	public void TC_079_validate_Broker_ResponseRateGraph_ExpandViewLegendHeader3() throws EncryptedDocumentException, IOException, InterruptedException {
//		producerPage.validateBrokerResponseRateExpandViewLegendHeader3();
//	}
//	
//	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
//	public void TC_080_validate_Broker_ResponseRateGraph_ExpandViewZoomInBtn() throws EncryptedDocumentException, IOException, InterruptedException {
//		producerPage.validateBrokerResponseRateExpandViewZoomIn();
//	}
//	
//	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
//	public void TC_081_validate_Broker_ResponseRateGraph_ExpandViewZoomOutBtn() throws EncryptedDocumentException, IOException, InterruptedException {
//		producerPage.validateBrokerResponseRateExpandViewZoomOut();
//	}
//	
//	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
//	public void TC_082_validate_Broker_ResponseRateGraph_ExpandViewWidgetDragDrop() throws EncryptedDocumentException, IOException, InterruptedException {
//		producerPage.validateBrokerResponseRateExpandViewWidgetDragDrop();
//	}	
/**
 * Topic Tab
 * @throws EncryptedDocumentException
 * @throws IOException
 */
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_083_validate_Topic_Tab_Title() throws EncryptedDocumentException, IOException {
		producerPage.validateTopicTabTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Producer, "Topic_Tab_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_084_click_on_Topic_Tab() throws EncryptedDocumentException, IOException {
		producerPage.clickOnTopicTab();
	}
		
  /******************************************** Record Send Rate Graph ******************************************************************/
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_085_validate_Topic_RecordSendRateGraph_Title() throws EncryptedDocumentException, IOException {
		//page.reload();
		//page.pause();
		//page.waitForTimeout(2000);
		producerPage.clickOnTopicTab();
		producerPage.validateTopicRecordSendRateGraphTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Producer, "Topic_RecordSendRate_Graph_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_086_validate_Topic_RecordSendRateGraph_ZoomIn() throws EncryptedDocumentException, IOException {
		//page.reload();
		producerPage.clickOnTopicTab();
		producerPage.validateTopicRecordSendRateGraphZoomInBtn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_087_validate_Topic_RecordSendRateGraph_ZoomOut() throws EncryptedDocumentException, IOException {
		//page.reload();
		producerPage.clickOnTopicTab();
		producerPage.validateTopicRecordSendRateGraphZoomOutBtn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_088_validate_Topic_RecordSendRateGraph_XaxisValue() throws EncryptedDocumentException, IOException {
		//page.reload();
		producerPage.clickOnTopicTab();
		producerPage.validateTopicRecordSendRateXaxisValues();
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_089_validate_Topic_RecordSendRateGraph_XaxisTitle() throws EncryptedDocumentException, IOException {
		//page.reload();
		producerPage.clickOnTopicTab();
		producerPage.validateTopicRecordSendRateGraphXaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Producer, "Topic_RecordSendRate_Xaxis_Title"));
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_090_validate_Topic_RecordSendRateGraph_YaxisTitle() throws EncryptedDocumentException, IOException {
		//page.reload();
		producerPage.clickOnTopicTab();
		producerPage.validateTopicRecordSendRateGraphYaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Producer, "Topic_RecordSendRate_Yaxis_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_091_validate_Topic_RecordSendRateGraph_TopicHeaderTitle() throws EncryptedDocumentException, IOException {
		//page.reload();
		producerPage.clickOnTopicTab();
		producerPage.validateTopicRecordSendRateGraphTopicHeaderTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Producer, "Topic_RecordSendRate_Topic_Header_Title"));
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_092_validate_Topic_RecordSendRateGraph_AvgHeaderTitle() throws EncryptedDocumentException, IOException {
		//page.reload();
		producerPage.clickOnTopicTab();
		producerPage.validateTopicRecordSendRateGraphAvgHeaderTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Producer, "Topic_RecordSendRate_Avg_Header_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_093_validate_Topic_RecordSendRateGraph_MaxHeaderTitle() throws EncryptedDocumentException, IOException {
		producerPage.clickOnTopicTab();
		//page.reload();
		producerPage.validateTopicRecordSendRateGraphMaxHeaderTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Producer, "Topic_RecordSendRate_Max_Header_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_094_validate_Topic_RecordSendRateGraph_RowColor1() throws EncryptedDocumentException, IOException {
		//page.reload();
		producerPage.clickOnTopicTab();
		producerPage.validateTopicRecordSendRateGraphRowColor1(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Producer, "rgb(255, 123, 123)"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_095_validate_Topic_RecordSendRateGraph_ToolTip() throws EncryptedDocumentException, IOException {	
		//page.reload();
		producerPage.clickOnTopicTab();
		producerPage.validateTopicRecordSendRateToolTipTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_096_validate_Topic_RecordSendRateGraph_ExpandViewXAxisTitle() throws EncryptedDocumentException, IOException {
		//page.reload();
		producerPage.clickOnTopicTab();
		producerPage.validateTopicRecordSendRateExpandViewXAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_097_validate_Topic_RecordSendRateGraph_ExpandViewYAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		//page.reload();
		producerPage.clickOnTopicTab();
		producerPage.validateTopicRecordSendRateExpandViewYAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_098_validate_Topic_RecordSendRateGraph_ExpandViewWidgetTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		//page.reload();
		//page.waitForTimeout(5000);
		producerPage.clickOnTopicTab();
		producerPage.validateTopicRecordSendRateExpandViewWidgetTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_099_validate_Topic_RecordSendRateGraph_ExpandViewLegendHeader1() throws EncryptedDocumentException, IOException, InterruptedException {
		//page.reload();
		producerPage.clickOnTopicTab();
		producerPage.validateTopicRecordSendRateExpandViewLegendHeader1();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_100_validate_Topic_RecordSendRateGraph_ExpandViewLegendHeader2() throws EncryptedDocumentException, IOException, InterruptedException {
		//page.reload();
		producerPage.clickOnTopicTab();
		producerPage.validateTopicRecordSendRateExpandViewLegendHeader2();
	}	
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_101_validate_Topic_RecordSendRateGraph_ExpandViewLegendHeader3() throws EncryptedDocumentException, IOException, InterruptedException {
		//page.pause();
		//page.reload();
		producerPage.clickOnTopicTab();
		producerPage.validateTopicRecordSendRateExpandViewLegendHeader3();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_102_validate_Topic_RecordSendRateGraph_ExpandViewZoomInBtn() throws EncryptedDocumentException, IOException, InterruptedException {
		//page.reload();
		producerPage.clickOnTopicTab();
		producerPage.validateTopicRecordSendRateExpandViewZoomIn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_103_validate_Topic_RecordSendRateGraph_ExpandViewZoomOutBtn() throws EncryptedDocumentException, IOException, InterruptedException {
		//page.reload();
		producerPage.clickOnTopicTab();
		producerPage.validateTopicRecordSendRateExpandViewZoomOut();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_104_validate_Topic_RecordSendRateGraph_ExpandViewWidgetDragDrop() throws EncryptedDocumentException, IOException, InterruptedException {
		//page.reload();
		producerPage.clickOnTopicTab();
		producerPage.validateTopicRecordSendRateExpandViewWidgetDragDrop();
	}	
/********************************************************* Record Send Total Graph ******************************************************************/
	
//	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity","RecordSendTotalGraph"}) 
//	public void TC_105_validate_Topic_RecordSendTotalGraph_Title() throws EncryptedDocumentException, IOException {
//		//page.reload();
//		producerPage.clickOnTopicTab();
//		producerPage.validateTopicRecordSendTotalGraphTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Producer, "Topic_RecordSendTotal_Graph_Title"));
//	}
//	
//	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity","RecordSendTotalGraph"})
//	public void TC_106_validate_Topic_RecordSendTotalGraph_ZoomIn() throws EncryptedDocumentException, IOException {
//		//page.reload();
//		producerPage.clickOnTopicTab();
//		producerPage.validateTopicRecordSendTotalGraphZoomInBtn();
//	}
//	
//	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity","RecordSendTotalGraph"})
//	public void TC_107_validate_Topic_RecordSendTotalGraph_ZoomOut() throws EncryptedDocumentException, IOException {
//		//page.reload();
//		producerPage.clickOnTopicTab();
//		producerPage.validateTopicRecordSendTotalGraphZoomOutBtn();
//	}
//	
//	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity","RecordSendTotalGraph"})
//	public void TC_108_validate_Topic_RecordSendTotalGraph_XaxisValue() throws EncryptedDocumentException, IOException {
//		//page.reload();
//		producerPage.clickOnTopicTab();
//		producerPage.validateTopicRecordSendTotalXaxisValues();
//	}
//		
//	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity","RecordSendTotalGraph"})
//	public void TC_109_validate_Topic_RecordSendTotalGraph_XaxisTitle() throws EncryptedDocumentException, IOException {
//		//page.reload();
//		producerPage.clickOnTopicTab();
//		producerPage.validateTopicRecordSendTotalGraphXaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Producer, "Topic_RecordSendTotal_Xaxis_Title"));
//	}
//		
//	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity","RecordSendTotalGraph"})
//	public void TC_110_validate_Topic_RecordSendTotalGraph_YaxisTitle() throws EncryptedDocumentException, IOException {
//		//page.reload();
//		producerPage.clickOnTopicTab();
//		producerPage.validateTopicRecordSendTotalGraphYaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Producer, "Topic_RecordSendTotal_Yaxis_Title"));
//	}
//	
//	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity","RecordSendTotalGraph"})
//	public void TC_111_validate_Topic_RecordSendTotalGraph_TopicHeaderTitle() throws EncryptedDocumentException, IOException {
//		//page.reload();
//		producerPage.clickOnTopicTab();
//		producerPage.validateTopicRecordSendTotalGraphTopicHeaderTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Producer, "Topic_RecordSendTotal_Topic_Header_Title"));
//	}	
//		
//	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity","RecordSendTotalGraph"})
//	public void TC_112_validate_Topic_RecordSendTotalGraph_AvgHeaderTitle() throws EncryptedDocumentException, IOException {
//		//page.reload();
//		producerPage.clickOnTopicTab();
//		producerPage.validateTopicRecordSendTotalGraphAvgHeaderTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Producer, "Topic_RecordSendTotal_Avg_Header_Title"));
//	}
//	
//	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity","RecordSendTotalGraph"})
//	public void TC_113_validate_Topic_RecordSendTotalGraph_MaxHeaderTitle() throws EncryptedDocumentException, IOException {
//		//page.reload();
//		producerPage.clickOnTopicTab();
//		producerPage.validateTopicRecordSendTotalGraphMaxHeaderTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Producer, "Topic_RecordSendTotal_Max_Header_Title"));
//	}
//	
//	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity","RecordSendTotalGraph"})
//	public void TC_114_validate_Topic_RecordSendTotalGraph_RowColor1() throws EncryptedDocumentException, IOException {
//		//page.reload();
//		producerPage.clickOnTopicTab();
//		producerPage.validateTopicRecordSendTotalGraphRowColor1(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Producer, "rgb(255, 123, 123)"));
//	}
//	
//	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity","RecordSendTotalGraph"})
//	public void TC_115_validate_Topic_RecordSendTotalGraph_ToolTip() throws EncryptedDocumentException, IOException {
//		//page.reload();
//		//page.pause();
//		producerPage.clickOnTopicTab();
//		producerPage.validateTopicRecordSendTotalToolTipTitle();
//	}
//	
//	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity","RecordSendTotalGraph"})
//	public void TC_116_validate_Topic_RecordSendTotalGraph_ExpandViewXAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
//		//page.reload();
//		producerPage.clickOnTopicTab();
//		producerPage.validateTopicRecordSendTotalExpandViewXAxisTitle();
//	}
//	
//	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity","RecordSendTotalGraph"})
//	public void TC_117_validate_Topic_RecordSendTotalGraph_ExpandViewYAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
//		//page.reload();
//		producerPage.clickOnTopicTab();
//		producerPage.validateTopicRecordSendTotalExpandViewYAxisTitle();
//	}
//	
//	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity","RecordSendTotalGraph"})
//	public void TC_118_validate_Topic_RecordSendTotalGraph_ExpandViewWidgetTitle() throws EncryptedDocumentException, IOException, InterruptedException {
//		//page.reload();
//		producerPage.clickOnTopicTab();
//		producerPage.validateTopicRecordSendTotalExpandViewWidgetTitle();
//	}
//	
//	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity","RecordSendTotalGraph"})
//	public void TC_119_validate_Topic_RecordSendTotalGraph_ExpandViewLegendHeader1() throws EncryptedDocumentException, IOException, InterruptedException {
//		//page.reload();
//		producerPage.clickOnTopicTab();
//		producerPage.validateTopicRecordSendTotalExpandViewLegendHeader1();
//	}
//	
//	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity","RecordSendTotalGraph"})
//	public void TC_120_validate_Topic_RecordSendTotalGraph_ExpandViewLegendHeader2() throws EncryptedDocumentException, IOException, InterruptedException {
//		//page.reload();
//		producerPage.clickOnTopicTab();
//		producerPage.validateTopicRecordSendTotalExpandViewLegendHeader2();
//	}	
//	
//	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
//	public void TC_121_validate_Topic_RecordSendTotalGraph_ExpandViewLegendHeader3() throws EncryptedDocumentException, IOException, InterruptedException {
//		//page.reload();
//		producerPage.clickOnTopicTab();
//		producerPage.validateTopicRecordSendTotalExpandViewLegendHeader3();
//	}
//	
//	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
//	public void TC_122_validate_Topic_RecordSendTotalGraph_ExpandViewZoomInBtn() throws EncryptedDocumentException, IOException, InterruptedException {
//		//page.reload();
//		producerPage.clickOnTopicTab();
//		producerPage.validateTopicRecordSendTotalExpandViewZoomIn();
//	}
//	
//	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
//	public void TC_123_validate_Topic_RecordSendTotalGraph_ExpandViewZoomOutBtn() throws EncryptedDocumentException, IOException, InterruptedException {
//		//page.reload();
//		producerPage.clickOnTopicTab();
//		producerPage.validateTopicRecordSendTotalExpandViewZoomOut();
//	}
//	
//	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
//	public void TC_124_validate_Topic_RecordSendTotalGraph_ExpandViewWidgetDragDrop() throws EncryptedDocumentException, IOException, InterruptedException {
//		//page.reload();
//		producerPage.clickOnTopicTab();
//		producerPage.validateTopicRecordSendTotalExpandViewWidgetDragDrop();
//	}	
///********************************************************* Record Error Rate Graph ******************************************************************/
//	
//	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
//	public void TC_125_validate_Topic_RecordErrorRateGraph_Title() throws EncryptedDocumentException, IOException {
//		//page.reload();
//		producerPage.clickOnTopicTab();
//		producerPage.validateTopicRecordErrorRateGraphTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Producer, "Topic_RecordErrorRate_Graph_Title"));
//	}
//	
//	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
//	public void TC_126_validate_Topic_RecordErrorRateGraph_ZoomIn() throws EncryptedDocumentException, IOException {
//		//page.reload();
//		producerPage.clickOnTopicTab();
//		producerPage.validateTopicRecordErrorRateGraphZoomInBtn();
//	}
//	
//	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
//	public void TC_127_validate_Topic_RecordErrorRateGraph_ZoomOut() throws EncryptedDocumentException, IOException {
//		//page.reload();
//		producerPage.clickOnTopicTab();
//		producerPage.validateTopicRecordErrorRateGraphZoomOutBtn();
//	}
//	
//	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
//	public void TC_128_validate_Topic_RecordErrorRateGraph_XaxisValue() throws EncryptedDocumentException, IOException {
//		//page.reload();
//		producerPage.clickOnTopicTab();
//		producerPage.validateTopicRecordErrorRateXaxisValues();
//	}
//		
//	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
//	public void TC_129_validate_Topic_RecordErrorRateGraph_XaxisTitle() throws EncryptedDocumentException, IOException {	
//		//page.reload();
//		producerPage.clickOnTopicTab();
//		producerPage.validateTopicRecordErrorRateGraphXaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Producer, "Topic_RecordErrorRate_Xaxis_Title"));
//	}
//		
//	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
//	public void TC_130_validate_Topic_RecordErrorRateGraph_YaxisTitle() throws EncryptedDocumentException, IOException {
//		//page.reload();
//		producerPage.clickOnTopicTab();
//		producerPage.validateTopicRecordErrorRateGraphYaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Producer, "Topic_RecordErrorRate_Yaxis_Title"));
//	}
//	
//	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
//	public void TC_131_validate_Topic_RecordErrorRateGraph_TopicHeaderTitle() throws EncryptedDocumentException, IOException {
//		//page.reload();
//		producerPage.clickOnTopicTab();
//		producerPage.validateTopicRecordErrorRateGraphHeaderTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Producer, "Topic_RecordErrorRate_Topic_Header_Title"));
//	}
//		
//	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
//	public void TC_132_validate_Topic_RecordErrorRateGraph_AvgHeaderTitle() throws EncryptedDocumentException, IOException {
//		//page.reload();
//		producerPage.clickOnTopicTab();
//		producerPage.validateTopicRecordErrorRateGraphAvgHeaderTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Producer, "Topic_RecordErrorRate_Avg_Header_Title"));
//	}
//
//	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
//	public void TC_133_validate_Topic_RecordErrorRateGraph_MaxHeaderTitle() throws EncryptedDocumentException, IOException {
//		//page.reload();
//		producerPage.clickOnTopicTab();
//		producerPage.validateTopicRecordErrorRateGraphMaxHeaderTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Producer, "Topic_RecordErrorRate_Max_Header_Title"));
//	}
//	
//	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
//	public void TC_134_validate_Topic_RecordErrorRateGraph_RowColor1() throws EncryptedDocumentException, IOException {
//		//page.reload();
//		producerPage.clickOnTopicTab();
//		producerPage.validateTopicRecordErrorRateGraphRowColor1(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Producer, "rgb(255, 123, 123)"));
//	}
//	
//	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
//	public void TC_135_validate_Topic_RecordErrorRateGraph_ToolTip() throws EncryptedDocumentException, IOException {
//		//page.reload();
//		producerPage.clickOnTopicTab();
//		producerPage.validateTopicRecordErrorRateToolTipTitle();
//	}
//	
//	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
//	public void TC_136_validate_Topic_RecordErrorRateGraph_ExpandViewXAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
//		//page.reload();
//		producerPage.clickOnTopicTab();
//		producerPage.validateTopicRecordErrorRateExpandViewXAxisTitle();
//	}
//	
//	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
//	public void TC_137_validate_Topic_RecordErrorRateGraph_ExpandViewYAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
//		//page.reload();
//		producerPage.clickOnTopicTab();
//		producerPage.validateTopicRecordErrorRateExpandViewYAxisTitle();
//	}
//	
//	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
//	public void TC_138_validate_Topic_RecordErrorRateGraph_ExpandViewWidgetTitle() throws EncryptedDocumentException, IOException, InterruptedException {
//		//page.reload();
//		producerPage.clickOnTopicTab();
//		producerPage.validateTopicRecordErrorRateExpandViewWidgetTitle();
//	}
//	
//	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
//	public void TC_139_validate_Topic_RecordErrorRateGraph_ExpandViewLegendHeader1() throws EncryptedDocumentException, IOException, InterruptedException {
//		//page.reload();
//		producerPage.clickOnTopicTab();
//		producerPage.validateTopicRecordErrorRateExpandViewLegendHeader1();
//	}
//	
//	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
//	public void TC_140_validate_Topic_RecordErrorRateGraph_ExpandViewLegendHeader2() throws EncryptedDocumentException, IOException, InterruptedException {
//		//page.reload();
//		producerPage.clickOnTopicTab();
//		producerPage.validateTopicRecordErrorRateExpandViewLegendHeader2();
//	}	
//	
//	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
//	public void TC_141_validate_Topic_RecordErrorRateGraph_ExpandViewLegendHeader3() throws EncryptedDocumentException, IOException, InterruptedException {
//		//page.reload();
//		producerPage.clickOnTopicTab();
//		producerPage.validateTopicRecordErrorRateExpandViewLegendHeader3();
//	}
//	
//	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
//	public void TC_142_validate_Topic_RecordErrorRateGraph_ExpandViewZoomInBtn() throws EncryptedDocumentException, IOException, InterruptedException {
//		//page.reload();
//		producerPage.clickOnTopicTab();
//		producerPage.validateTopicRecordErrorRateExpandViewZoomIn();
//	}
//	
//	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
//	public void TC_143_validate_Topic_RecordErrorRateGraph_ExpandViewZoomOutBtn() throws EncryptedDocumentException, IOException, InterruptedException {
//		//page.reload();
//		producerPage.clickOnTopicTab();
//		producerPage.validateTopicRecordErrorRateExpandViewZoomOut();
//	}
//	
//	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
//	public void TC_144_validate_Topic_RecordErrorRateGraph_ExpandViewWidgetDragDrop() throws EncryptedDocumentException, IOException, InterruptedException {
//		//page.reload();
//		producerPage.clickOnTopicTab();
//		producerPage.validateTopicRecordErrorRateExpandViewWidgetDragDrop();
//	}	
///********************************************************* Record Error Total Graph ******************************************************************/
//	
//	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
//	public void TC_145_validate_Topic_RecordErrorTotalGraph_Title() throws EncryptedDocumentException, IOException {
//		//page.reload();
//		producerPage.clickOnTopicTab();
//		producerPage.validateTopicRecordErrorTotalGraphTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Producer, "Topic_RecordErrorTotal_Graph_Title"));
//	}
//	
//	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
//	public void TC_146_validate_Topic_RecordErrorTotalGraph_ZoomIn() throws EncryptedDocumentException, IOException {
//		//page.reload();
//		producerPage.clickOnTopicTab();
//		producerPage.validateTopicRecordErrorTotalGraphZoomInBtn();
//	}
//	
//	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
//	public void TC_147_validate_Topic_RecordErrorTotalGraph_ZoomOut() throws EncryptedDocumentException, IOException {
//		//page.reload();
//		producerPage.clickOnTopicTab();
//		producerPage.validateTopicRecordErrorTotalGraphZoomOutBtn();
//	}
//	
//	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
//	public void TC_148_validate_Topic_RecordErrorTotalGraph_XaxisValue() throws EncryptedDocumentException, IOException {
//		//page.reload();
//		producerPage.clickOnTopicTab();
//		producerPage.validateTopicRecordErrorTotalXaxisValues();
//	}
//	
//	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
//	public void TC_149_validate_Topic_RecordErrorTotalGraph_XaxisTitle() throws EncryptedDocumentException, IOException {
//		//page.reload();
//		producerPage.clickOnTopicTab();
//		producerPage.validateTopicRecordErrorTotalGraphXaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Producer, "Topic_RecordErrorTotal_Xaxis_Title"));
//	}
//	
//	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
//	public void TC_150_validate_Topic_RecordErrorTotalGraph_YaxisTitle() throws EncryptedDocumentException, IOException {
//		//page.reload();
//		producerPage.clickOnTopicTab();
//		producerPage.validateTopicRecordErrorTotalGraphYaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Producer, "Topic_RecordErrorTotal_Yaxis_Title"));
//	}
//	
//	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
//	public void TC_151_validate_Topic_RecordErrorTotalGraph_TopicHeaderTitle() throws EncryptedDocumentException, IOException {
//		//page.reload();
//		producerPage.clickOnTopicTab();
//		producerPage.validateTopicRecordErrorRateGraphHeaderTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Producer, "Topic_RecordErrorTotal_Topic_Header_Title"));
//	}
//	
//	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
//	public void TC_152_validate_Topic_RecordErrorTotalGraph_AvgHeaderTitle() throws EncryptedDocumentException, IOException {
//		//page.reload();
//		producerPage.clickOnTopicTab();
//		producerPage.validateTopicRecordErrorTotalGraphAvgHeaderTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Producer, "Topic_RecordErrorTotal_Avg_Header_Title"));
//	}
//	
//	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
//	public void TC_153_validate_Topic_RecordErrorTotalGraph_MaxHeaderTitle() throws EncryptedDocumentException, IOException {
//		//page.reload();
//		producerPage.clickOnTopicTab();
//		producerPage.validateTopicRecordErrorTotalGraphMaxHeaderTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Producer, "Topic_RecordErrorTotal_Max_Header_Title"));
//	}
//	
//	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
//	public void TC_154_validate_Topic_RecordErrorTotalGraph_RowColor1() throws EncryptedDocumentException, IOException {
//		//page.reload();
//		producerPage.clickOnTopicTab();
//		producerPage.validateTopicRecordErrorTotalGraphRowColor1(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Producer, "rgb(255, 123, 123)"));
//	}	
//	
//	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
//	public void TC_155_validate_Topic_RecordErrorTotalGraph_ToolTip() throws EncryptedDocumentException, IOException {
//		//page.reload();
//		producerPage.clickOnTopicTab();
//		producerPage.validateTopicRecordErrorTotalToolTipTitle();
//	}
//	
//	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
//	public void TC_156_validate_Topic_RecordErrorTotalGraph_ExpandViewXAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
//		//page.reload();
//		producerPage.clickOnTopicTab();
//		producerPage.validateTopicRecordErrorTotalExpandViewXAxisTitle();
//	}
//	
//	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
//	public void TC_157_validate_Topic_RecordErrorTotalGraph_ExpandViewYAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
//		//page.reload();
//		producerPage.clickOnTopicTab();
//		producerPage.validateTopicRecordErrorTotalExpandViewYAxisTitle();
//	}
//	
//	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
//	public void TC_158_validate_Topic_RecordErrorTotalGraph_ExpandViewWidgetTitle() throws EncryptedDocumentException, IOException, InterruptedException {
//		//page.reload();
//		producerPage.clickOnTopicTab();
//		producerPage.validateTopicRecordErrorTotalExpandViewWidgetTitle();
//	}
//	
//	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
//	public void TC_159_validate_Topic_RecordErrorTotalGraph_ExpandViewLegendHeader1() throws EncryptedDocumentException, IOException, InterruptedException {
//		//page.reload();
//		producerPage.clickOnTopicTab();
//		producerPage.validateTopicRecordErrorTotalExpandViewLegendHeader1();
//	}
//	
//	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
//	public void TC_160_validate_Topic_RecordErrorTotalGraph_ExpandViewLegendHeader2() throws EncryptedDocumentException, IOException, InterruptedException {
//		//page.reload();
//		producerPage.clickOnTopicTab();
//		producerPage.validateTopicRecordErrorTotalExpandViewLegendHeader2();
//	}
//	
//	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
//	public void TC_161_validate_Topic_RecordErrorTotalGraph_ExpandViewLegendHeader3() throws EncryptedDocumentException, IOException, InterruptedException {
//		//page.reload();
//		page.waitForTimeout(2000);
//		producerPage.clickOnTopicTab();
//		producerPage.validateTopicRecordErrorTotalExpandViewLegendHeader3();
//	}
//	
//	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
//	public void TC_162_validate_Topic_RecordErrorTotalGraph_ExpandViewZoomInBtn() throws EncryptedDocumentException, IOException, InterruptedException {
//		//page.reload();
//		producerPage.clickOnTopicTab();
//		producerPage.validateTopicRecordErrorTotalExpandViewZoomIn();
//	}
//	
//	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
//	public void TC_163_validate_Topic_RecordErrorTotalGraph_ExpandViewZoomOutBtn() throws EncryptedDocumentException, IOException, InterruptedException {
//		//page.reload();
//		page.waitForTimeout(2000);
//		producerPage.clickOnTopicTab();
//		producerPage.validateTopicRecordErrorTotalExpandViewZoomOut();
//	}
//	
//	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
//	public void TC_164_validate_Topic_RecordErrorTotalGraph_ExpandViewWidgetDragDrop() throws EncryptedDocumentException, IOException, InterruptedException {
//		//page.reload();
//		producerPage.clickOnTopicTab();
//		producerPage.validateTopicRecordErrorTotalExpandViewWidgetDragDrop();
//	}

}