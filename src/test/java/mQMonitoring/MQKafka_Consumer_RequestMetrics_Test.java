package mQMonitoring;

import org.testng.annotations.Test;

import com.microsoft.playwright.Page;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.BeforeMethod;

import genericUtilities.ExcelUtility;
import genericUtilities.GenericMethods;
import genericUtilities.IPathConstant;
import objectRepository.CommonPage;
import objectRepository.MQM.MQKafka_Consumer_Page;
import playWrightFactory.BaseClass;


public class MQKafka_Consumer_RequestMetrics_Test extends BaseClass
{
	GenericMethods util = new GenericMethods();
	CommonPage commonPage;
	MQKafka_Consumer_RequestMetrics_Page consumerPageRM;
	ExcelUtility excel = new ExcelUtility();
	

	@BeforeMethod
	public void Consumer() throws EncryptedDocumentException, IOException {
		
		excel = new ExcelUtility();
		
	}
	
		
/**
 * Request Metrics Tab
 * @throws EncryptedDocumentException
 * @throws IOException
 */
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_044_validate_RequestMetrics_Tab_Title() throws EncryptedDocumentException, IOException {
		page.pause();
		commonPage = new CommonPage(page);
		consumerPageRM = new  MQKafka_Consumer_RequestMetrics_Page(page);
		commonPage.navigateToMQM();
		commonPage.selectTheTimeLineFromCalender(IPathConstant.oneMonthTimeRange);
		consumerPageRM.navigateToKafka();
		String application =excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Load, "Application");
		consumerPageRM.selectServiceName(application);
		page.reload();
		consumerPageRM.navigateToConsumerTab();
	
		consumerPageRM.validateRequestMetricsTabTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Consumer, "RequestMetrics_Tab_Title"));
		
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_045_click_on_RequestMetrics_Tab() throws EncryptedDocumentException, IOException {
		consumerPageRM.clickOnRequestMetricsTab();
		String application =excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Load, "Application");
		consumerPageRM.selectServiceName(application);	
		System.out.println("clicked on the metrics tab");
	}
	
/********************************************************* Incoming Bytes Graph ******************************************************************/
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_046_validate_RequestMetrics_IncomingBytesGraph_Title() throws EncryptedDocumentException, IOException {
		//consumerPageRM.clickOnRequestMetricsTab();
		consumerPageRM.validateRequestMetricsIncomingBytesGraphTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Consumer, "RequestMetrics_IncomingBytes_Graph_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_047_validate_RequestMetrics_IncomingBytesGraph_ZoomIn() throws EncryptedDocumentException, IOException {
		 
		//consumerPageRM.clickOnRequestMetricsTab();
		consumerPageRM.validateRequestMetricsIncomingBytesZoomInBtn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_048_validate_RequestMetrics_IncomingBytesGraph_ZoomOut() throws EncryptedDocumentException, IOException {
		 
		//consumerPageRM.clickOnRequestMetricsTab();
		consumerPageRM.validateRequestMetricsIncomingBytesZoomOutBtn();
	}

/*	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_049_validate_RequestMetrics_IncomingBytesGraph_XaxisValue() throws EncryptedDocumentException, IOException {
		 
		//consumerPageRM.clickOnRequestMetricsTab();
		consumerPageRM.validateRequestMetricsIncomingBytesXaxisValues();
	}
		*/
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_050_validate_RequestMetrics_IncomingBytesGraph_XaxisTitle() throws EncryptedDocumentException, IOException {
		 
		//consumerPageRM.clickOnRequestMetricsTab();
		consumerPageRM.validateRequestMetricsIncomingBytesGraphXaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Consumer, "RequestMetrics_IncomingBytes_Xaxis_Title"));
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_051_validate_RequestMetrics_IncomingBytesGraph_YaxisTitle() throws EncryptedDocumentException, IOException {
		//consumerPageRM.clickOnRequestMetricsTab();
		consumerPageRM.validateRequestMetricsIncomingBytesGraphYaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Consumer, "RequestMetrics_IncomingBytes_Yaxis_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_052_validate_RequestMetrics_IncomingBytesGraph_RequestMetricsHeaderTitle() throws EncryptedDocumentException, IOException {
		 
		//consumerPageRM.clickOnRequestMetricsTab();
		consumerPageRM.validateRequestMetricsIncomingBytesGraphRequestMetricsHeaderTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Consumer, "RequestMetrics_IncomingBytes_Consumer_Header_Title"));
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_053_validate_RequestMetrics_IncomingBytesGraph_AvgHeaderTitle() throws EncryptedDocumentException, IOException {
		 
		//consumerPageRM.clickOnRequestMetricsTab();
		consumerPageRM.validateRequestMetricsIncomingBytesGraphAvgHeaderTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Consumer, "RequestMetrics_IncomingBytes_Avg_Header_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_054_validate_RequestMetrics_IncomingBytesGraph_MaxHeaderTitle() throws EncryptedDocumentException, IOException {
		 
		//consumerPageRM.clickOnRequestMetricsTab();
		consumerPageRM.validateRequestMetricsIncomingBytesGraphMaxHeaderTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Consumer, "RequestMetrics_IncomingBytes_Max_Header_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_056_validate_RequestMetrics_IncomingBytesGraph_ToolTip() throws EncryptedDocumentException, IOException {
		 
		//consumerPageRM.clickOnRequestMetricsTab();
		consumerPageRM.validateRequestMetricsIncomingBytesToolTipTitle();
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_057_validate_RequestMetrics_IncomingBytesGraph_ExpandViewXAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		 
		//page.pause();
		//consumerPageRM.clickOnRequestMetricsTab();
		consumerPageRM.validateRequestMetricsIncomingBytesExpandViewXAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_058_validate_RequestMetrics_IncomingBytesGraph_ExpandViewYAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		//consumerPageRM.clickOnRequestMetricsTab();		
		consumerPageRM.validateRequestMetricsIncomingBytesExpandViewYAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_060_validate_RequestMetrics_IncomingBytesGraph_ExpandViewWidgetTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		 
		//consumerPageRM.clickOnRequestMetricsTab();
		consumerPageRM.validateRequestMetricsIncomingBytesExpandViewWidgetTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_061_validate_RequestMetrics_IncomingBytesGraph_ExpandViewLegendHeader1() throws EncryptedDocumentException, IOException, InterruptedException {
		 
		//consumerPageRM.clickOnRequestMetricsTab();
		consumerPageRM.validateRequestMetricsIncomingBytesExpandViewLegendHeader1();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_062_validate_RequestMetrics_IncomingBytesGraph_ExpandViewLegendHeader2() throws EncryptedDocumentException, IOException, InterruptedException {
		 
		page.waitForTimeout(2000);
		//consumerPageRM.clickOnRequestMetricsTab();
		consumerPageRM.validateRequestMetricsIncomingBytesExpandViewLegendHeader2();
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_063_validate_RequestMetrics_IncomingBytesGraph_ExpandViewLegendHeader3() throws EncryptedDocumentException, IOException, InterruptedException {
		 
		//consumerPageRM.clickOnRequestMetricsTab();
		consumerPageRM.validateRequestMetricsIncomingBytesExpandViewLegendHeader3();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_064_validate_RequestMetrics_IncomingBytesGraph_ExpandViewZoomInBtn() throws EncryptedDocumentException, IOException, InterruptedException {
		 
		//consumerPageRM.clickOnRequestMetricsTab();
		consumerPageRM.validateRequestMetricsIncomingBytesExpandViewZoomIn();
	}
//	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_065_validate_RequestMetrics_IncomingBytesGraph_ExpandViewZoomOutBtn() throws EncryptedDocumentException, IOException, InterruptedException {
		 
		//consumerPageRM.clickOnRequestMetricsTab();
		consumerPageRM.validateRequestMetricsIncomingBytesExpandViewZoomOut();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_066_validate_RequestMetrics_IncomingBytesGraph_ExpandViewWidgetDragDrop() throws EncryptedDocumentException, IOException, InterruptedException {		 
		//consumerPageRM.clickOnRequestMetricsTab();
		consumerPageRM.validateRequestMetricsIncomingBytesExpandViewWidgetDragDrop();
	}	
	
/********************************************************* Outgoing Bytes Graph ******************************************************************/
	
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_067_validate_RequestMetrics_OutgoingBytesGraph_Title() throws EncryptedDocumentException, IOException {
		 
		//consumerPageRM.clickOnRequestMetricsTab();
		consumerPageRM.validateRequestMetricsOutgoingBytesGraphTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Consumer, "RequestMetrics_OutgoingBytes_Graph_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_068_validate_RequestMetrics_OutgoingBytesGraph_ZoomIn() throws EncryptedDocumentException, IOException {
		 
		//consumerPageRM.clickOnRequestMetricsTab();
		consumerPageRM.validateRequestMetricsOutgoingBytesZoomInBtn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_069_validate_RequestMetrics_OutgoingBytesGraph_ZoomOut() throws EncryptedDocumentException, IOException {
		 
		//consumerPageRM.clickOnRequestMetricsTab();
		consumerPageRM.validateRequestMetricsOutgoingBytesZoomOutBtn();
	}

/*	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_070_validate_RequestMetrics_OutgoingBytesGraph_XaxisValue() throws EncryptedDocumentException, IOException {
		 
		//consumerPageRM.clickOnRequestMetricsTab();
		consumerPageRM.validateRequestMetricsOutgoingBytesXaxisValues();
	}*/
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_071_validate_RequestMetrics_OutgoingBytesGraph_XaxisTitle() throws EncryptedDocumentException, IOException {
		 
		//consumerPageRM.clickOnRequestMetricsTab();
		consumerPageRM.validateRequestMetricsOutgoingBytesGraphXaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Consumer, "RequestMetrics_OutgoingBytes_Xaxis_Title"));
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_072_validate_RequestMetrics_OutgoingBytesGraph_YaxisTitle() throws EncryptedDocumentException, IOException {
		//consumerPageRM.clickOnRequestMetricsTab();
		consumerPageRM.validateRequestMetricsOutgoingBytesGraphYaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Consumer, "RequestMetrics_OutgoingBytes_Yaxis_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_073_validate_RequestMetrics_OutgoingBytesGraph_RequestMetricsHeaderTitle() throws EncryptedDocumentException, IOException {
		 
		//consumerPageRM.clickOnRequestMetricsTab();
		consumerPageRM.validateRequestMetricsOutgoingBytesGraphRequestMetricsHeaderTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Consumer, "RequestMetrics_OutgoingBytes_Consumer_Header_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_074_validate_RequestMetrics_OutgoingBytesGraph_AvgHeaderTitle() throws EncryptedDocumentException, IOException {
		 
		//consumerPageRM.clickOnRequestMetricsTab();
		consumerPageRM.validateRequestMetricsOutgoingBytesGraphAvgHeaderTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Consumer, "RequestMetrics_OutgoingBytes_Avg_Header_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_075_validate_RequestMetrics_OutgoingBytesGraph_MaxHeaderTitle() throws EncryptedDocumentException, IOException {
		 
		//consumerPageRM.clickOnRequestMetricsTab();
		consumerPageRM.validateRequestMetricsOutgoingBytesGraphMaxHeaderTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Consumer, "RequestMetrics_OutgoingBytes_Max_Header_Title"));
	}	

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_077_validate_RequestMetrics_OutgoingBytesGraph_ToolTip() throws EncryptedDocumentException, IOException {
		 
		//consumerPageRM.clickOnRequestMetricsTab();
		consumerPageRM.validateRequestMetricsOutgoingBytesToolTipTitle();
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_078_validate_RequestMetrics_OutgoingBytesGraph_ExpandViewXAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		 
		//consumerPageRM.clickOnRequestMetricsTab();
		consumerPageRM.validateRequestMetricsOutgoingBytesExpandViewXAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_079_validate_RequestMetrics_OutgoingBytesGraph_ExpandViewYAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		 
		//consumerPageRM.clickOnRequestMetricsTab();
		consumerPageRM.validateRequestMetricsOutgoingBytesExpandViewYAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_080_validate_RequestMetrics_OutgoingBytesGraph_ExpandViewWidgetTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		 
		//consumerPageRM.clickOnRequestMetricsTab();
		consumerPageRM.validateRequestMetricsOutgoingBytesExpandViewWidgetTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_081_validate_RequestMetrics_OutgoingBytesGraph_ExpandViewLegendHeader1() throws EncryptedDocumentException, IOException, InterruptedException {
		 
		//consumerPageRM.clickOnRequestMetricsTab();
		consumerPageRM.validateRequestMetricsOutgoingBytesExpandViewLegendHeader1();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_082_validate_RequestMetrics_OutgoingBytesGraph_ExpandViewLegendHeader2() throws EncryptedDocumentException, IOException, InterruptedException {
		 
		//consumerPageRM.clickOnRequestMetricsTab();
		consumerPageRM.validateRequestMetricsOutgoingBytesExpandViewLegendHeader2();
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_083_validate_RequestMetrics_OutgoingBytesGraph_ExpandViewLegendHeader3() throws EncryptedDocumentException, IOException, InterruptedException {
		 
		//consumerPageRM.clickOnRequestMetricsTab();
		consumerPageRM.validateRequestMetricsOutgoingBytesExpandViewLegendHeader3();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_084_validate_RequestMetrics_OutgoingBytesGraph_ExpandViewZoomInBtn() throws EncryptedDocumentException, IOException, InterruptedException {
		 
		//consumerPageRM.clickOnRequestMetricsTab();
		consumerPageRM.validateRequestMetricsOutgoingBytesExpandViewZoomIn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_085_validate_RequestMetrics_OutgoingBytesGraph_ExpandViewZoomOutBtn() throws EncryptedDocumentException, IOException, InterruptedException {
		 
		//consumerPageRM.clickOnRequestMetricsTab();
		consumerPageRM.validateRequestMetricsOutgoingBytesExpandViewZoomOut();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_086_validate_RequestMetrics_OutgoingBytesGraph_ExpandViewWidgetDragDrop() throws EncryptedDocumentException, IOException, InterruptedException {
		 
		//consumerPageRM.clickOnRequestMetricsTab();
		consumerPageRM.validateRequestMetricsOutgoingBytesExpandViewWidgetDragDrop();
	}
	
	/********************************** Average Fetch Latency Graph ******************************************************************/
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_087_validate_RequestMetrics_AverageFetchLatencyGraph_Title() throws EncryptedDocumentException, IOException {
		 
		//consumerPageRM.clickOnRequestMetricsTab();
		consumerPageRM.validateRequestMetricsAverageFetchLatencyGraphTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Consumer, "RequestMetrics_AverageFetchLatency_Graph_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_088_validate_RequestMetrics_AverageFetchLatencyGraph_ZoomIn() throws EncryptedDocumentException, IOException {
		 
		//consumerPageRM.clickOnRequestMetricsTab();
		consumerPageRM.validateRequestMetricsAverageFetchLatencyZoomInBtn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_089_validate_RequestMetrics_AverageFetchLatencyGraph_ZoomOut() throws EncryptedDocumentException, IOException {
		 
		//consumerPageRM.clickOnRequestMetricsTab();
		consumerPageRM.validateRequestMetricsAverageFetchLatencyZoomOutBtn();
	}

//	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
//	public void TC_090_validate_RequestMetrics_AverageFetchLatencyGraph_XaxisValue() throws EncryptedDocumentException, IOException {
//		 
//		//consumerPageRM.clickOnRequestMetricsTab();
//		consumerPageRM.validateRequestMetricsAverageFetchLatencyXaxisValues();
//	}
//	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_091_validate_RequestMetrics_AverageFetchLatencyGraph_XaxisTitle() throws EncryptedDocumentException, IOException {
		 
		//consumerPageRM.clickOnRequestMetricsTab();
		consumerPageRM.validateRequestMetricsAverageFetchLatencyGraphXaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Consumer, "RequestMetrics_AverageFetchLatency_Xaxis_Title"));
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_092_validate_RequestMetrics_AverageFetchLatencyGraph_YaxisTitle() throws EncryptedDocumentException, IOException {
		 
		//consumerPageRM.clickOnRequestMetricsTab();
		consumerPageRM.validateRequestMetricsAverageFetchLatencyGraphYaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Consumer, "RequestMetrics_AverageFetchLatency_Yaxis_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_093_validate_RequestMetrics_AverageFetchLatencyGraph_RequestMetricsHeaderTitle() throws EncryptedDocumentException, IOException {
		 
		//consumerPageRM.clickOnRequestMetricsTab();
		consumerPageRM.validateRequestMetricsAverageFetchLatencyGraphRequestMetricsHeaderTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Consumer, "RequestMetrics_AverageFetchLatency_Consumer_Header_Title"));
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_094_validate_RequestMetrics_AverageFetchLatencyGraph_AvgHeaderTitle() throws EncryptedDocumentException, IOException {
		 
		//consumerPageRM.clickOnRequestMetricsTab();
		consumerPageRM.validateRequestMetricsAverageFetchLatencyGraphAvgHeaderTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Consumer, "RequestMetrics_AverageFetchLatency_Avg_Header_Title"));
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_095_validate_RequestMetrics_AverageFetchLatencyGraph_MaxHeaderTitle() throws EncryptedDocumentException, IOException {
		 
		//consumerPageRM.clickOnRequestMetricsTab();
		consumerPageRM.validateRequestMetricsAverageFetchLatencyGraphMaxHeaderTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Consumer, "RequestMetrics_AverageFetchLatency_Max_Header_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_097_validate_RequestMetrics_AverageFetchLatencyGraph_ToolTip() throws EncryptedDocumentException, IOException {
		 
		//consumerPageRM.clickOnRequestMetricsTab();
		consumerPageRM.validateRequestMetricsAverageFetchLatencyToolTipTitle();
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_098_validate_RequestMetrics_AverageFetchLatencyGraph_ExpandViewXAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		 
		//consumerPageRM.clickOnRequestMetricsTab();
		consumerPageRM.validateRequestMetricsAverageFetchLatencyExpandViewXAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_099_validate_RequestMetrics_AverageFetchLatencyGraph_ExpandViewYAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		 
		//consumerPageRM.clickOnRequestMetricsTab();
		consumerPageRM.validateRequestMetricsAverageFetchLatencyExpandViewYAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_100_validate_RequestMetrics_AverageFetchLatencyGraph_ExpandViewWidgetTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		 
		//consumerPageRM.clickOnRequestMetricsTab();
		consumerPageRM.validateRequestMetricsAverageFetchLatencyExpandViewWidgetTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_101_validate_RequestMetrics_AverageFetchLatencyGraph_ExpandViewLegendHeader1() throws EncryptedDocumentException, IOException, InterruptedException {
		 
		//consumerPageRM.clickOnRequestMetricsTab();
		consumerPageRM.validateRequestMetricsAverageFetchLatencyExpandViewLegendHeader1();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_102_validate_RequestMetrics_AverageFetchLatencyGraph_ExpandViewLegendHeader2() throws EncryptedDocumentException, IOException, InterruptedException {
		 
		//consumerPageRM.clickOnRequestMetricsTab();
		consumerPageRM.validateRequestMetricsAverageFetchLatencyExpandViewLegendHeader2();
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_103_validate_RequestMetrics_AverageFetchLatencyGraph_ExpandViewLegendHeader3() throws EncryptedDocumentException, IOException, InterruptedException {
		 
		//consumerPageRM.clickOnRequestMetricsTab();
		consumerPageRM.validateRequestMetricsAverageFetchLatencyExpandViewLegendHeader3();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_104_validate_RequestMetrics_AverageFetchLatencyGraph_ExpandViewZoomInBtn() throws EncryptedDocumentException, IOException, InterruptedException {
		 
		//consumerPageRM.clickOnRequestMetricsTab();
		consumerPageRM.validateRequestMetricsAverageFetchLatencyExpandViewZoomIn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_105_validate_RequestMetrics_AverageFetchLatencyGraph_ExpandViewZoomOutBtn() throws EncryptedDocumentException, IOException, InterruptedException {
		 
		//consumerPageRM.clickOnRequestMetricsTab();
		consumerPageRM.validateRequestMetricsAverageFetchLatencyExpandViewZoomOut();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_106_validate_RequestMetrics_AverageFetchLatencyGraph_ExpandViewWidgetDragDrop() throws EncryptedDocumentException, IOException, InterruptedException {
		 
		//consumerPageRM.clickOnRequestMetricsTab();
		consumerPageRM.validateRequestMetricsAverageFetchLatencyExpandViewWidgetDragDrop();
	}
	
/********************************************************* Maximum Fetch Latency Graph ******************************************************************/
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_107_validate_RequestMetrics_MaximumFetchLatencyGraph_Title() throws EncryptedDocumentException, IOException {
		 
		//consumerPageRM.clickOnRequestMetricsTab();
		consumerPageRM.validateRequestMetricsMaximumFetchLatencyGraphTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Consumer, "RequestMetrics_MaximumFetchLatency_Graph_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_108_validate_RequestMetrics_MaximumFetchLatencyGraph_ZoomIn() throws EncryptedDocumentException, IOException {
		 
		//consumerPageRM.clickOnRequestMetricsTab();
		consumerPageRM.validateRequestMetricsMaximumFetchLatencyZoomInBtn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_109_validate_RequestMetrics_MaximumFetchLatencyGraph_ZoomOut() throws EncryptedDocumentException, IOException {
		 
		//consumerPageRM.clickOnRequestMetricsTab();
		consumerPageRM.validateRequestMetricsMaximumFetchLatencyZoomOutBtn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_110_validate_RequestMetrics_MaximumFetchLatencyGraph_XaxisValue() throws EncryptedDocumentException, IOException {
		 
		//consumerPageRM.clickOnRequestMetricsTab();
		consumerPageRM.validateRequestMetricsMaximumFetchLatencyXaxisValues();
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_111_validate_RequestMetrics_MaximumFetchLatencyGraph_XaxisTitle() throws EncryptedDocumentException, IOException {
		 
		//consumerPageRM.clickOnRequestMetricsTab();
		consumerPageRM.validateRequestMetricsMaximumFetchLatencyGraphXaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Consumer, "RequestMetrics_MaximumFetchLatency_Xaxis_Title"));
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_112_validate_RequestMetrics_MaximumFetchLatencyGraph_YaxisTitle() throws EncryptedDocumentException, IOException {
		 
		//consumerPageRM.clickOnRequestMetricsTab();
		consumerPageRM.validateRequestMetricsMaximumFetchLatencyGraphYaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Consumer, "RequestMetrics_MaximumFetchLatency_Yaxis_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_113_validate_RequestMetrics_MaximumFetchLatencyGraph_RequestMetricsHeaderTitle() throws EncryptedDocumentException, IOException {
		 
		//consumerPageRM.clickOnRequestMetricsTab();
		consumerPageRM.validateRequestMetricsMaximumFetchLatencyGraphRequestMetricsHeaderTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Consumer, "RequestMetrics_MaximumFetchLatency_Consumer_Header_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_114_validate_RequestMetrics_MaximumFetchLatencyGraph_AvgHeaderTitle() throws EncryptedDocumentException, IOException {
		 
		//consumerPageRM.clickOnRequestMetricsTab();
		consumerPageRM.validateRequestMetricsMaximumFetchLatencyGraphAvgHeaderTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Consumer, "RequestMetrics_MaximumFetchLatency_Avg_Header_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_115_validate_RequestMetrics_MaximumFetchLatencyGraph_MaxHeaderTitle() throws EncryptedDocumentException, IOException {
		 
		//consumerPageRM.clickOnRequestMetricsTab();
		consumerPageRM.validateRequestMetricsMaximumFetchLatencyGraphMaxHeaderTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Consumer, "RequestMetrics_MaximumFetchLatency_Max_Header_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_117_validate_RequestMetrics_MaximumFetchLatencyGraph_ToolTip() throws EncryptedDocumentException, IOException {
		 
		//consumerPageRM.clickOnRequestMetricsTab();
		consumerPageRM.validateRequestMetricsMaximumFetchLatencyToolTipTitle();
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_118_validate_RequestMetrics_MaximumFetchLatencyGraph_ExpandViewXAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		 
		//consumerPageRM.clickOnRequestMetricsTab();
		consumerPageRM.validateRequestMetricsMaximumFetchLatencyExpandViewXAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_119_validate_RequestMetrics_MaximumFetchLatencyGraph_ExpandViewYAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		 
		//consumerPageRM.clickOnRequestMetricsTab();
		consumerPageRM.validateRequestMetricsMaximumFetchLatencyExpandViewYAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_120_validate_RequestMetrics_MaximumFetchLatencyGraph_ExpandViewWidgetTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		 
		//consumerPageRM.clickOnRequestMetricsTab();
		consumerPageRM.validateRequestMetricsMaximumFetchLatencyExpandViewWidgetTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_121_validate_RequestMetrics_MaximumFetchLatencyGraph_ExpandViewLegendHeader1() throws EncryptedDocumentException, IOException, InterruptedException {
		 
		//consumerPageRM.clickOnRequestMetricsTab();
		consumerPageRM.validateRequestMetricsMaximumFetchLatencyExpandViewLegendHeader1();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_122_validate_RequestMetrics_MaximumFetchLatencyGraph_ExpandViewLegendHeader2() throws EncryptedDocumentException, IOException, InterruptedException {
		 
		//consumerPageRM.clickOnRequestMetricsTab();
		consumerPageRM.validateRequestMetricsMaximumFetchLatencyExpandViewLegendHeader2();
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_123_validate_RequestMetrics_MaximumFetchLatencyGraph_ExpandViewLegendHeader3() throws EncryptedDocumentException, IOException, InterruptedException {
		 
		//consumerPageRM.clickOnRequestMetricsTab();
		consumerPageRM.validateRequestMetricsMaximumFetchLatencyExpandViewLegendHeader3();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_124_validate_RequestMetrics_MaximumFetchLatencyGraph_ExpandViewZoomInBtn() throws EncryptedDocumentException, IOException, InterruptedException {
		 
		//consumerPageRM.clickOnRequestMetricsTab();
		consumerPageRM.validateRequestMetricsMaximumFetchLatencyExpandViewZoomIn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_125_validate_RequestMetrics_MaximumFetchLatencyGraph_ExpandViewZoomOutBtn() throws EncryptedDocumentException, IOException, InterruptedException {
		 
		//consumerPageRM.clickOnRequestMetricsTab();
		consumerPageRM.validateRequestMetricsMaximumFetchLatencyExpandViewZoomOut();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_126_validate_RequestMetrics_MaximumFetchLatencyGraph_ExpandViewWidgetDragDrop() throws EncryptedDocumentException, IOException, InterruptedException {
		 
		//consumerPageRM.clickOnRequestMetricsTab();
		consumerPageRM.validateRequestMetricsMaximumFetchLatencyExpandViewWidgetDragDrop();
	}
	
	
	
	
	
}
