package mQMonitoring;

import org.testng.annotations.Test;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.BeforeMethod;

import genericUtilities.ExcelUtility;
import genericUtilities.GenericMethods;
import genericUtilities.IPathConstant;
import objectRepository.CommonPage;
import objectRepository.MQM.MQKafka_Consumer_Page;
import playWrightFactory.BaseClass;

public class MQKafka_Consumer_Test extends BaseClass
{
	GenericMethods util = new GenericMethods();
	CommonPage commonPage;
	MQKafka_Consumer_Page consumerPage;
	ExcelUtility excel = new ExcelUtility();
	
	@BeforeMethod
	public void Consumer() throws EncryptedDocumentException, IOException {
		commonPage = new CommonPage(page);
		consumerPage = new  MQKafka_Consumer_Page(page);
		excel = new ExcelUtility();
		
		commonPage.navigateToMQM();
		consumerPage.navigateToKafka();
		commonPage.selectTheTimeLineFromCalender(IPathConstant.oneMonthTimeRange);
		String application =excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Load, "Application");
		consumerPage.selectServiceName(application);
		consumerPage.navigateToConsumerTab();
		
		//page.reload();
		//page.waitForTimeout(1000);
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_001_validate_Consumer_Title() throws EncryptedDocumentException, IOException  {
		consumerPage.validateConsumerTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Consumer, "Consumer_Tab_Title"));
	}
	
/**
 * Partition Metrics Tab
 * @throws EncryptedDocumentException
 * @throws IOException
 */
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_002_validate_PartitionMetrics_Tab_Title() throws EncryptedDocumentException, IOException {
		consumerPage.validatePartitionMetricsTabTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Consumer, "PartitionMetrics_Tab_Title"));
	}
	
/********************************************************* Lag Graph ******************************************************************/
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_003_validate_PartitionMetrics_LagGraph_Title() throws EncryptedDocumentException, IOException {
		consumerPage.validatePartitionMetricsLagGraphTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Consumer, "PartitionMetrics_Lag_Graph_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_004_validate_PartitionMetrics_LagGraph_ZoomIn() throws EncryptedDocumentException, IOException {
		consumerPage.validatePartitionMetricsLagZoomInBtn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_005_validate_PartitionMetrics_LagGraph_ZoomOut() throws EncryptedDocumentException, IOException {
		consumerPage.validatePartitionMetricsLagZoomOutBtn();
	}

/*	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_006_validate_PartitionMetrics_LagGraph_XaxisValue() throws EncryptedDocumentException, IOException {
		page.waitForTimeout(2000);
		consumerPage.validatePartitionMetricsLagXaxisValues();
	}
*/		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_007_validate_PartitionMetrics_LagGraph_XaxisTitle() throws EncryptedDocumentException, IOException {
		consumerPage.validatePartitionMetricsLagGraphXaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Consumer, "PartitionMetrics_Lag_Xaxis_Title"));
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_008_validate_PartitionMetrics_LagGraph_YaxisTitle() throws EncryptedDocumentException, IOException {
		consumerPage.validatePartitionMetricsLagGraphYaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Consumer, "PartitionMetrics_Lag_Yaxis_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_009_validate_PartitionMetrics_LagGraph_PartitionMetricsHeaderTitle() throws EncryptedDocumentException, IOException {
		consumerPage.validatePartitionMetricsLagGraphPartitionMetricsHeaderTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Consumer, "PartitionMetrics_Lag_Consumer_Header_Title"));
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_010_validate_PartitionMetrics_LagGraph_AvgHeaderTitle() throws EncryptedDocumentException, IOException {
		consumerPage.validatePartitionMetricsLagGraphAvgHeaderTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Consumer, "PartitionMetrics_Lag_Avg_Header_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_011_validate_PartitionMetrics_LagGraph_MaxHeaderTitle() throws EncryptedDocumentException, IOException {
		consumerPage.validatePartitionMetricsLagGraphMaxHeaderTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Consumer, "PartitionMetrics_Lag_Max_Header_Title"));
	}
		
/*	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_012_validate_PartitionMetrics_LagGraph_RowColor1() throws EncryptedDocumentException, IOException {
		consumerPage.validatePartitionMetricsLagGraphRowColor1(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Consumer, "rgb(255, 123, 123)"));
	}
*/	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_014_validate_PartitionMetrics_LagGraph_ToolTip() throws EncryptedDocumentException, IOException {
		 
		page.waitForTimeout(2000);
		consumerPage.validatePartitionMetricsLagToolTipTitle();
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_015_validate_PartitionMetrics_LagGraph_ExpandViewXAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		consumerPage.validatePartitionMetricsLagExpandViewXAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_016_validate_PartitionMetrics_LagGraph_ExpandViewYAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		consumerPage.validatePartitionMetricsLagExpandViewYAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_017_validate_PartitionMetrics_LagGraph_ExpandViewWidgetTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		consumerPage.validatePartitionMetricsLagExpandViewWidgetTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_018_validate_PartitionMetrics_LagGraph_ExpandViewLegendHeader1() throws EncryptedDocumentException, IOException, InterruptedException {
		consumerPage.validatePartitionMetricsLagExpandViewLegendHeader1();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_019_validate_PartitionMetrics_LagGraph_ExpandViewLegendHeader2() throws EncryptedDocumentException, IOException, InterruptedException {
		consumerPage.validatePartitionMetricsLagExpandViewLegendHeader2();
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_020_validate_PartitionMetrics_LagGraph_ExpandViewLegendHeader3() throws EncryptedDocumentException, IOException, InterruptedException {
		consumerPage.validatePartitionMetricsLagExpandViewLegendHeader3();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_021_validate_PartitionMetrics_LagGraph_ExpandViewZoomInBtn() throws EncryptedDocumentException, IOException, InterruptedException {
		consumerPage.validatePartitionMetricsLagExpandViewZoomIn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_022_validate_PartitionMetrics_LagGraph_ExpandViewZoomOutBtn() throws EncryptedDocumentException, IOException, InterruptedException {
		consumerPage.validatePartitionMetricsLagExpandViewZoomOut();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_023_validate_PartitionMetrics_LagGraph_ExpandViewWidgetDragDrop() throws EncryptedDocumentException, IOException, InterruptedException {
		consumerPage.validatePartitionMetricsLagExpandViewWidgetDragDrop();
	}	
/********************************************************* Lead Graph ******************************************************************/
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_024_validate_PartitionMetrics_LeadGraph_Title() throws EncryptedDocumentException, IOException {
		consumerPage.validatePartitionMetricsLeadGraphTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Consumer, "PartitionMetrics_Lead_Graph_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_025_validate_PartitionMetrics_LeadGraph_ZoomIn() throws EncryptedDocumentException, IOException {
		consumerPage.validatePartitionMetricsLeadZoomInBtn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_026_validate_PartitionMetrics_LeadGraph_ZoomOut() throws EncryptedDocumentException, IOException {
		consumerPage.validatePartitionMetricsLeadZoomOutBtn();
	}
		
/*	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_027_validate_PartitionMetrics_LeadGraph_XaxisValue() throws EncryptedDocumentException, IOException {
		consumerPage.validatePartitionMetricsLeadXaxisValues();
	}
		*/
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_028_validate_PartitionMetrics_LeadGraph_XaxisTitle() throws EncryptedDocumentException, IOException {
		consumerPage.validatePartitionMetricsLeadGraphXaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Consumer, "PartitionMetrics_Lead_Xaxis_Title"));
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_029_validate_PartitionMetrics_LeadGraph_YaxisTitle() throws EncryptedDocumentException, IOException {
		consumerPage.validatePartitionMetricsLeadGraphYaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Consumer, "PartitionMetrics_Lead_Yaxis_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_030_validate_PartitionMetrics_LeadGraph_PartitionMetricsHeaderTitle() throws EncryptedDocumentException, IOException {
		consumerPage.validatePartitionMetricsLeadGraphPartitionMetricsHeaderTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Consumer, "PartitionMetrics_Lead_Consumer_Header_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_031_validate_PartitionMetrics_LeadGraph_AvgHeaderTitle() throws EncryptedDocumentException, IOException {
		consumerPage.validatePartitionMetricsLeadGraphAvgHeaderTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Consumer, "PartitionMetrics_Lead_Avg_Header_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_032_validate_PartitionMetrics_LeadGraph_MaxHeaderTitle() throws EncryptedDocumentException, IOException {
		consumerPage.validatePartitionMetricsLeadGraphMaxHeaderTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Consumer, "PartitionMetrics_Lead_Max_Header_Title"));
	}
		
/*	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_033_validate_PartitionMetrics_LeadGraph_RowColor1() throws EncryptedDocumentException, IOException {
		consumerPage.validatePartitionMetricsLeadGraphRowColor1(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Consumer, "rgb(255, 123, 123)"));
	}
	*/
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_034_validate_PartitionMetrics_LeadGraph_ToolTip() throws EncryptedDocumentException, IOException {
		consumerPage.validatePartitionMetricsLeadToolTipTitle();
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_035_validate_PartitionMetrics_LeadGraph_ExpandViewXAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		consumerPage.validatePartitionMetricsLeadExpandViewXAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_036_validate_PartitionMetrics_LeadGraph_ExpandViewYAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		consumerPage.validatePartitionMetricsLeadExpandViewYAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_037_validate_PartitionMetrics_LeadGraph_ExpandViewWidgetTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		consumerPage.validatePartitionMetricsLeadExpandViewWidgetTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_038_validate_PartitionMetrics_LeadGraph_ExpandViewLegendHeader1() throws EncryptedDocumentException, IOException, InterruptedException {
		consumerPage.validatePartitionMetricsLeadExpandViewLegendHeader1();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_039_validate_PartitionMetrics_LeadGraph_ExpandViewLegendHeader2() throws EncryptedDocumentException, IOException, InterruptedException {
		consumerPage.validatePartitionMetricsLeadExpandViewLegendHeader2();
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_040_validate_PartitionMetrics_LeadGraph_ExpandViewLegendHeader3() throws EncryptedDocumentException, IOException, InterruptedException {
		consumerPage.validatePartitionMetricsLeadExpandViewLegendHeader3();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_041_validate_PartitionMetrics_LeadGraph_ExpandViewZoomInBtn() throws EncryptedDocumentException, IOException, InterruptedException {
		consumerPage.validatePartitionMetricsLeadExpandViewZoomIn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_042_validate_PartitionMetrics_LeadGraph_ExpandViewZoomOutBtn() throws EncryptedDocumentException, IOException, InterruptedException {
		consumerPage.validatePartitionMetricsLeadExpandViewZoomOut();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_043_validate_PartitionMetrics_LeadGraph_ExpandViewWidgetDragDrop() throws EncryptedDocumentException, IOException, InterruptedException {
		consumerPage.validatePartitionMetricsLeadExpandViewWidgetDragDrop();
	}	
	
/**
 * Request Metrics Tab
 * @throws EncryptedDocumentException
 * @throws IOException
 */
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_044_validate_RequestMetrics_Tab_Title() throws EncryptedDocumentException, IOException {
		consumerPage.validateRequestMetricsTabTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Consumer, "RequestMetrics_Tab_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_045_click_on_RequestMetrics_Tab() throws EncryptedDocumentException, IOException {
		consumerPage.clickOnRequestMetricsTab();
		
	}
	
/********************************************************* Incoming Bytes Graph ******************************************************************/
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_046_validate_RequestMetrics_IncomingBytesGraph_Title() throws EncryptedDocumentException, IOException {
		 
		consumerPage.clickOnRequestMetricsTab();
		consumerPage.validateRequestMetricsIncomingBytesGraphTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Consumer, "RequestMetrics_IncomingBytes_Graph_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_047_validate_RequestMetrics_IncomingBytesGraph_ZoomIn() throws EncryptedDocumentException, IOException {
		 
		consumerPage.clickOnRequestMetricsTab();
		consumerPage.validateRequestMetricsIncomingBytesZoomInBtn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_048_validate_RequestMetrics_IncomingBytesGraph_ZoomOut() throws EncryptedDocumentException, IOException {
		 
		consumerPage.clickOnRequestMetricsTab();
		consumerPage.validateRequestMetricsIncomingBytesZoomOutBtn();
	}

/*	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_049_validate_RequestMetrics_IncomingBytesGraph_XaxisValue() throws EncryptedDocumentException, IOException {
		 
		consumerPage.clickOnRequestMetricsTab();
		consumerPage.validateRequestMetricsIncomingBytesXaxisValues();
	}
		*/
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_050_validate_RequestMetrics_IncomingBytesGraph_XaxisTitle() throws EncryptedDocumentException, IOException {
		 
		consumerPage.clickOnRequestMetricsTab();
		consumerPage.validateRequestMetricsIncomingBytesGraphXaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Consumer, "RequestMetrics_IncomingBytes_Xaxis_Title"));
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_051_validate_RequestMetrics_IncomingBytesGraph_YaxisTitle() throws EncryptedDocumentException, IOException {
		consumerPage.clickOnRequestMetricsTab();
		consumerPage.validateRequestMetricsIncomingBytesGraphYaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Consumer, "RequestMetrics_IncomingBytes_Yaxis_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_052_validate_RequestMetrics_IncomingBytesGraph_RequestMetricsHeaderTitle() throws EncryptedDocumentException, IOException {
		 
		consumerPage.clickOnRequestMetricsTab();
		consumerPage.validateRequestMetricsIncomingBytesGraphRequestMetricsHeaderTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Consumer, "RequestMetrics_IncomingBytes_Consumer_Header_Title"));
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_053_validate_RequestMetrics_IncomingBytesGraph_AvgHeaderTitle() throws EncryptedDocumentException, IOException {
		 
		consumerPage.clickOnRequestMetricsTab();
		consumerPage.validateRequestMetricsIncomingBytesGraphAvgHeaderTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Consumer, "RequestMetrics_IncomingBytes_Avg_Header_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_054_validate_RequestMetrics_IncomingBytesGraph_MaxHeaderTitle() throws EncryptedDocumentException, IOException {
		 
		consumerPage.clickOnRequestMetricsTab();
		consumerPage.validateRequestMetricsIncomingBytesGraphMaxHeaderTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Consumer, "RequestMetrics_IncomingBytes_Max_Header_Title"));
	}
/*		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_055_validate_RequestMetrics_IncomingBytesGraph_RowColor1() throws EncryptedDocumentException, IOException {
		 
		consumerPage.clickOnRequestMetricsTab();
		consumerPage.validateRequestMetricsIncomingBytesGraphRowColor1(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Consumer, "rgb(255, 123, 123)"));
	}*/
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_056_validate_RequestMetrics_IncomingBytesGraph_ToolTip() throws EncryptedDocumentException, IOException {
		 
		consumerPage.clickOnRequestMetricsTab();
		consumerPage.validateRequestMetricsIncomingBytesToolTipTitle();
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_057_validate_RequestMetrics_IncomingBytesGraph_ExpandViewXAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		 
		//page.pause();
		consumerPage.clickOnRequestMetricsTab();
		consumerPage.validateRequestMetricsIncomingBytesExpandViewXAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_058_validate_RequestMetrics_IncomingBytesGraph_ExpandViewYAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		consumerPage.clickOnRequestMetricsTab();		
		consumerPage.validateRequestMetricsIncomingBytesExpandViewYAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_060_validate_RequestMetrics_IncomingBytesGraph_ExpandViewWidgetTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		 
		consumerPage.clickOnRequestMetricsTab();
		consumerPage.validateRequestMetricsIncomingBytesExpandViewWidgetTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_061_validate_RequestMetrics_IncomingBytesGraph_ExpandViewLegendHeader1() throws EncryptedDocumentException, IOException, InterruptedException {
		 
		consumerPage.clickOnRequestMetricsTab();
		consumerPage.validateRequestMetricsIncomingBytesExpandViewLegendHeader1();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_062_validate_RequestMetrics_IncomingBytesGraph_ExpandViewLegendHeader2() throws EncryptedDocumentException, IOException, InterruptedException {
		 
		page.waitForTimeout(2000);
		consumerPage.clickOnRequestMetricsTab();
		consumerPage.validateRequestMetricsIncomingBytesExpandViewLegendHeader2();
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_063_validate_RequestMetrics_IncomingBytesGraph_ExpandViewLegendHeader3() throws EncryptedDocumentException, IOException, InterruptedException {
		 
		consumerPage.clickOnRequestMetricsTab();
		consumerPage.validateRequestMetricsIncomingBytesExpandViewLegendHeader3();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_064_validate_RequestMetrics_IncomingBytesGraph_ExpandViewZoomInBtn() throws EncryptedDocumentException, IOException, InterruptedException {
		 
		consumerPage.clickOnRequestMetricsTab();
		consumerPage.validateRequestMetricsIncomingBytesExpandViewZoomIn();
	}
//	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_065_validate_RequestMetrics_IncomingBytesGraph_ExpandViewZoomOutBtn() throws EncryptedDocumentException, IOException, InterruptedException {
		 
		consumerPage.clickOnRequestMetricsTab();
		consumerPage.validateRequestMetricsIncomingBytesExpandViewZoomOut();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_066_validate_RequestMetrics_IncomingBytesGraph_ExpandViewWidgetDragDrop() throws EncryptedDocumentException, IOException, InterruptedException {		 
		consumerPage.clickOnRequestMetricsTab();
		consumerPage.validateRequestMetricsIncomingBytesExpandViewWidgetDragDrop();
	}	
	
/********************************************************* Outgoing Bytes Graph ******************************************************************/
	
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_067_validate_RequestMetrics_OutgoingBytesGraph_Title() throws EncryptedDocumentException, IOException {
		 
		consumerPage.clickOnRequestMetricsTab();
		consumerPage.validateRequestMetricsOutgoingBytesGraphTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Consumer, "RequestMetrics_OutgoingBytes_Graph_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_068_validate_RequestMetrics_OutgoingBytesGraph_ZoomIn() throws EncryptedDocumentException, IOException {
		 
		consumerPage.clickOnRequestMetricsTab();
		consumerPage.validateRequestMetricsOutgoingBytesZoomInBtn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_069_validate_RequestMetrics_OutgoingBytesGraph_ZoomOut() throws EncryptedDocumentException, IOException {
		 
		consumerPage.clickOnRequestMetricsTab();
		consumerPage.validateRequestMetricsOutgoingBytesZoomOutBtn();
	}

/*	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_070_validate_RequestMetrics_OutgoingBytesGraph_XaxisValue() throws EncryptedDocumentException, IOException {
		 
		consumerPage.clickOnRequestMetricsTab();
		consumerPage.validateRequestMetricsOutgoingBytesXaxisValues();
	}*/
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_071_validate_RequestMetrics_OutgoingBytesGraph_XaxisTitle() throws EncryptedDocumentException, IOException {
		 
		consumerPage.clickOnRequestMetricsTab();
		consumerPage.validateRequestMetricsOutgoingBytesGraphXaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Consumer, "RequestMetrics_OutgoingBytes_Xaxis_Title"));
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_072_validate_RequestMetrics_OutgoingBytesGraph_YaxisTitle() throws EncryptedDocumentException, IOException {
		 
		//page.waitForTimeout(5000);
		consumerPage.clickOnRequestMetricsTab();
		consumerPage.validateRequestMetricsOutgoingBytesGraphYaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Consumer, "RequestMetrics_OutgoingBytes_Yaxis_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_073_validate_RequestMetrics_OutgoingBytesGraph_RequestMetricsHeaderTitle() throws EncryptedDocumentException, IOException {
		 
		consumerPage.clickOnRequestMetricsTab();
		consumerPage.validateRequestMetricsOutgoingBytesGraphRequestMetricsHeaderTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Consumer, "RequestMetrics_OutgoingBytes_Consumer_Header_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_074_validate_RequestMetrics_OutgoingBytesGraph_AvgHeaderTitle() throws EncryptedDocumentException, IOException {
		 
		consumerPage.clickOnRequestMetricsTab();
		consumerPage.validateRequestMetricsOutgoingBytesGraphAvgHeaderTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Consumer, "RequestMetrics_OutgoingBytes_Avg_Header_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_075_validate_RequestMetrics_OutgoingBytesGraph_MaxHeaderTitle() throws EncryptedDocumentException, IOException {
		 
		consumerPage.clickOnRequestMetricsTab();
		consumerPage.validateRequestMetricsOutgoingBytesGraphMaxHeaderTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Consumer, "RequestMetrics_OutgoingBytes_Max_Header_Title"));
	}	
	
/*	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_076_validate_RequestMetrics_OutgoingBytesGraph_RowColor1() throws EncryptedDocumentException, IOException {
		 
		consumerPage.clickOnRequestMetricsTab();
		consumerPage.validateRequestMetricsOutgoingBytesGraphRowColor1(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Consumer, "rgb(255, 123, 123)"));
	}*/
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_077_validate_RequestMetrics_OutgoingBytesGraph_ToolTip() throws EncryptedDocumentException, IOException {
		 
		consumerPage.clickOnRequestMetricsTab();
		consumerPage.validateRequestMetricsOutgoingBytesToolTipTitle();
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_078_validate_RequestMetrics_OutgoingBytesGraph_ExpandViewXAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		 
		consumerPage.clickOnRequestMetricsTab();
		consumerPage.validateRequestMetricsOutgoingBytesExpandViewXAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_079_validate_RequestMetrics_OutgoingBytesGraph_ExpandViewYAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		 
		consumerPage.clickOnRequestMetricsTab();
		consumerPage.validateRequestMetricsOutgoingBytesExpandViewYAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_080_validate_RequestMetrics_OutgoingBytesGraph_ExpandViewWidgetTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		 
		consumerPage.clickOnRequestMetricsTab();
		consumerPage.validateRequestMetricsOutgoingBytesExpandViewWidgetTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_081_validate_RequestMetrics_OutgoingBytesGraph_ExpandViewLegendHeader1() throws EncryptedDocumentException, IOException, InterruptedException {
		 
		consumerPage.clickOnRequestMetricsTab();
		consumerPage.validateRequestMetricsOutgoingBytesExpandViewLegendHeader1();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_082_validate_RequestMetrics_OutgoingBytesGraph_ExpandViewLegendHeader2() throws EncryptedDocumentException, IOException, InterruptedException {
		 
		consumerPage.clickOnRequestMetricsTab();
		consumerPage.validateRequestMetricsOutgoingBytesExpandViewLegendHeader2();
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_083_validate_RequestMetrics_OutgoingBytesGraph_ExpandViewLegendHeader3() throws EncryptedDocumentException, IOException, InterruptedException {
		 
		consumerPage.clickOnRequestMetricsTab();
		consumerPage.validateRequestMetricsOutgoingBytesExpandViewLegendHeader3();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_084_validate_RequestMetrics_OutgoingBytesGraph_ExpandViewZoomInBtn() throws EncryptedDocumentException, IOException, InterruptedException {
		 
		consumerPage.clickOnRequestMetricsTab();
		consumerPage.validateRequestMetricsOutgoingBytesExpandViewZoomIn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_085_validate_RequestMetrics_OutgoingBytesGraph_ExpandViewZoomOutBtn() throws EncryptedDocumentException, IOException, InterruptedException {
		 
		consumerPage.clickOnRequestMetricsTab();
		consumerPage.validateRequestMetricsOutgoingBytesExpandViewZoomOut();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_086_validate_RequestMetrics_OutgoingBytesGraph_ExpandViewWidgetDragDrop() throws EncryptedDocumentException, IOException, InterruptedException {
		 
		consumerPage.clickOnRequestMetricsTab();
		consumerPage.validateRequestMetricsOutgoingBytesExpandViewWidgetDragDrop();
	}
	
	/********************************** Average Fetch Latency Graph ******************************************************************/
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_087_validate_RequestMetrics_AverageFetchLatencyGraph_Title() throws EncryptedDocumentException, IOException {
		 
		consumerPage.clickOnRequestMetricsTab();
		consumerPage.validateRequestMetricsAverageFetchLatencyGraphTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Consumer, "RequestMetrics_AverageFetchLatency_Graph_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_088_validate_RequestMetrics_AverageFetchLatencyGraph_ZoomIn() throws EncryptedDocumentException, IOException {
		 
		consumerPage.clickOnRequestMetricsTab();
		consumerPage.validateRequestMetricsAverageFetchLatencyZoomInBtn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_089_validate_RequestMetrics_AverageFetchLatencyGraph_ZoomOut() throws EncryptedDocumentException, IOException {
		 
		consumerPage.clickOnRequestMetricsTab();
		consumerPage.validateRequestMetricsAverageFetchLatencyZoomOutBtn();
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_090_validate_RequestMetrics_AverageFetchLatencyGraph_XaxisValue() throws EncryptedDocumentException, IOException {
		 
		consumerPage.clickOnRequestMetricsTab();
		consumerPage.validateRequestMetricsAverageFetchLatencyXaxisValues();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_091_validate_RequestMetrics_AverageFetchLatencyGraph_XaxisTitle() throws EncryptedDocumentException, IOException {
		 
		consumerPage.clickOnRequestMetricsTab();
		consumerPage.validateRequestMetricsAverageFetchLatencyGraphXaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Consumer, "RequestMetrics_AverageFetchLatency_Xaxis_Title"));
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_092_validate_RequestMetrics_AverageFetchLatencyGraph_YaxisTitle() throws EncryptedDocumentException, IOException {
		 
		consumerPage.clickOnRequestMetricsTab();
		consumerPage.validateRequestMetricsAverageFetchLatencyGraphYaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Consumer, "RequestMetrics_AverageFetchLatency_Yaxis_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_093_validate_RequestMetrics_AverageFetchLatencyGraph_RequestMetricsHeaderTitle() throws EncryptedDocumentException, IOException {
		 
		consumerPage.clickOnRequestMetricsTab();
		consumerPage.validateRequestMetricsAverageFetchLatencyGraphRequestMetricsHeaderTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Consumer, "RequestMetrics_AverageFetchLatency_Consumer_Header_Title"));
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_094_validate_RequestMetrics_AverageFetchLatencyGraph_AvgHeaderTitle() throws EncryptedDocumentException, IOException {
		 
		consumerPage.clickOnRequestMetricsTab();
		consumerPage.validateRequestMetricsAverageFetchLatencyGraphAvgHeaderTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Consumer, "RequestMetrics_AverageFetchLatency_Avg_Header_Title"));
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_095_validate_RequestMetrics_AverageFetchLatencyGraph_MaxHeaderTitle() throws EncryptedDocumentException, IOException {
		 
		consumerPage.clickOnRequestMetricsTab();
		consumerPage.validateRequestMetricsAverageFetchLatencyGraphMaxHeaderTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Consumer, "RequestMetrics_AverageFetchLatency_Max_Header_Title"));
	}
		
/*	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_096_validate_RequestMetrics_AverageFetchLatencyGraph_RowColor1() throws EncryptedDocumentException, IOException {
		 
		consumerPage.clickOnRequestMetricsTab();
		consumerPage.validateRequestMetricsAverageFetchLatencyGraphRowColor1(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Consumer, "rgb(255, 123, 123)"));
	}*/
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_097_validate_RequestMetrics_AverageFetchLatencyGraph_ToolTip() throws EncryptedDocumentException, IOException {
		 
		consumerPage.clickOnRequestMetricsTab();
		consumerPage.validateRequestMetricsAverageFetchLatencyToolTipTitle();
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_098_validate_RequestMetrics_AverageFetchLatencyGraph_ExpandViewXAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		 
		consumerPage.clickOnRequestMetricsTab();
		consumerPage.validateRequestMetricsAverageFetchLatencyExpandViewXAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_099_validate_RequestMetrics_AverageFetchLatencyGraph_ExpandViewYAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		 
		consumerPage.clickOnRequestMetricsTab();
		consumerPage.validateRequestMetricsAverageFetchLatencyExpandViewYAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_100_validate_RequestMetrics_AverageFetchLatencyGraph_ExpandViewWidgetTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		 
		consumerPage.clickOnRequestMetricsTab();
		consumerPage.validateRequestMetricsAverageFetchLatencyExpandViewWidgetTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_101_validate_RequestMetrics_AverageFetchLatencyGraph_ExpandViewLegendHeader1() throws EncryptedDocumentException, IOException, InterruptedException {
		 
		consumerPage.clickOnRequestMetricsTab();
		consumerPage.validateRequestMetricsAverageFetchLatencyExpandViewLegendHeader1();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_102_validate_RequestMetrics_AverageFetchLatencyGraph_ExpandViewLegendHeader2() throws EncryptedDocumentException, IOException, InterruptedException {
		 
		consumerPage.clickOnRequestMetricsTab();
		consumerPage.validateRequestMetricsAverageFetchLatencyExpandViewLegendHeader2();
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_103_validate_RequestMetrics_AverageFetchLatencyGraph_ExpandViewLegendHeader3() throws EncryptedDocumentException, IOException, InterruptedException {
		 
		consumerPage.clickOnRequestMetricsTab();
		consumerPage.validateRequestMetricsAverageFetchLatencyExpandViewLegendHeader3();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_104_validate_RequestMetrics_AverageFetchLatencyGraph_ExpandViewZoomInBtn() throws EncryptedDocumentException, IOException, InterruptedException {
		 
		consumerPage.clickOnRequestMetricsTab();
		consumerPage.validateRequestMetricsAverageFetchLatencyExpandViewZoomIn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_105_validate_RequestMetrics_AverageFetchLatencyGraph_ExpandViewZoomOutBtn() throws EncryptedDocumentException, IOException, InterruptedException {
		 
		consumerPage.clickOnRequestMetricsTab();
		consumerPage.validateRequestMetricsAverageFetchLatencyExpandViewZoomOut();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_106_validate_RequestMetrics_AverageFetchLatencyGraph_ExpandViewWidgetDragDrop() throws EncryptedDocumentException, IOException, InterruptedException {
		 
		consumerPage.clickOnRequestMetricsTab();
		consumerPage.validateRequestMetricsAverageFetchLatencyExpandViewWidgetDragDrop();
	}
	
/********************************************************* Maximum Fetch Latency Graph ******************************************************************/
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_107_validate_RequestMetrics_MaximumFetchLatencyGraph_Title() throws EncryptedDocumentException, IOException {
		 
		consumerPage.clickOnRequestMetricsTab();
		consumerPage.validateRequestMetricsMaximumFetchLatencyGraphTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Consumer, "RequestMetrics_MaximumFetchLatency_Graph_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_108_validate_RequestMetrics_MaximumFetchLatencyGraph_ZoomIn() throws EncryptedDocumentException, IOException {
		 
		consumerPage.clickOnRequestMetricsTab();
		consumerPage.validateRequestMetricsMaximumFetchLatencyZoomInBtn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_109_validate_RequestMetrics_MaximumFetchLatencyGraph_ZoomOut() throws EncryptedDocumentException, IOException {
		 
		consumerPage.clickOnRequestMetricsTab();
		consumerPage.validateRequestMetricsMaximumFetchLatencyZoomOutBtn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_110_validate_RequestMetrics_MaximumFetchLatencyGraph_XaxisValue() throws EncryptedDocumentException, IOException {
		 
		consumerPage.clickOnRequestMetricsTab();
		consumerPage.validateRequestMetricsMaximumFetchLatencyXaxisValues();
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_111_validate_RequestMetrics_MaximumFetchLatencyGraph_XaxisTitle() throws EncryptedDocumentException, IOException {
		 
		consumerPage.clickOnRequestMetricsTab();
		consumerPage.validateRequestMetricsMaximumFetchLatencyGraphXaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Consumer, "RequestMetrics_MaximumFetchLatency_Xaxis_Title"));
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_112_validate_RequestMetrics_MaximumFetchLatencyGraph_YaxisTitle() throws EncryptedDocumentException, IOException {
		 
		consumerPage.clickOnRequestMetricsTab();
		consumerPage.validateRequestMetricsMaximumFetchLatencyGraphYaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Consumer, "RequestMetrics_MaximumFetchLatency_Yaxis_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_113_validate_RequestMetrics_MaximumFetchLatencyGraph_RequestMetricsHeaderTitle() throws EncryptedDocumentException, IOException {
		 
		consumerPage.clickOnRequestMetricsTab();
		consumerPage.validateRequestMetricsMaximumFetchLatencyGraphRequestMetricsHeaderTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Consumer, "RequestMetrics_MaximumFetchLatency_Consumer_Header_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_114_validate_RequestMetrics_MaximumFetchLatencyGraph_AvgHeaderTitle() throws EncryptedDocumentException, IOException {
		 
		consumerPage.clickOnRequestMetricsTab();
		consumerPage.validateRequestMetricsMaximumFetchLatencyGraphAvgHeaderTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Consumer, "RequestMetrics_MaximumFetchLatency_Avg_Header_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_115_validate_RequestMetrics_MaximumFetchLatencyGraph_MaxHeaderTitle() throws EncryptedDocumentException, IOException {
		 
		consumerPage.clickOnRequestMetricsTab();
		consumerPage.validateRequestMetricsMaximumFetchLatencyGraphMaxHeaderTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Consumer, "RequestMetrics_MaximumFetchLatency_Max_Header_Title"));
	}
	
//	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
//	public void TC_116_validate_RequestMetrics_MaximumFetchLatencyGraph_RowColor1() throws EncryptedDocumentException, IOException {
//		 
//		consumerPage.clickOnRequestMetricsTab();
//		consumerPage.validateRequestMetricsMaximumFetchLatencyGraphRowColor1(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Consumer, "rgb(255, 123, 123)"));
//	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_117_validate_RequestMetrics_MaximumFetchLatencyGraph_ToolTip() throws EncryptedDocumentException, IOException {
		 
		consumerPage.clickOnRequestMetricsTab();
		consumerPage.validateRequestMetricsMaximumFetchLatencyToolTipTitle();
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_118_validate_RequestMetrics_MaximumFetchLatencyGraph_ExpandViewXAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		 
		consumerPage.clickOnRequestMetricsTab();
		consumerPage.validateRequestMetricsMaximumFetchLatencyExpandViewXAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_119_validate_RequestMetrics_MaximumFetchLatencyGraph_ExpandViewYAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		 
		consumerPage.clickOnRequestMetricsTab();
		consumerPage.validateRequestMetricsMaximumFetchLatencyExpandViewYAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_120_validate_RequestMetrics_MaximumFetchLatencyGraph_ExpandViewWidgetTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		 
		consumerPage.clickOnRequestMetricsTab();
		consumerPage.validateRequestMetricsMaximumFetchLatencyExpandViewWidgetTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_121_validate_RequestMetrics_MaximumFetchLatencyGraph_ExpandViewLegendHeader1() throws EncryptedDocumentException, IOException, InterruptedException {
		 
		consumerPage.clickOnRequestMetricsTab();
		consumerPage.validateRequestMetricsMaximumFetchLatencyExpandViewLegendHeader1();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_122_validate_RequestMetrics_MaximumFetchLatencyGraph_ExpandViewLegendHeader2() throws EncryptedDocumentException, IOException, InterruptedException {
		 
		consumerPage.clickOnRequestMetricsTab();
		consumerPage.validateRequestMetricsMaximumFetchLatencyExpandViewLegendHeader2();
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_123_validate_RequestMetrics_MaximumFetchLatencyGraph_ExpandViewLegendHeader3() throws EncryptedDocumentException, IOException, InterruptedException {
		 
		consumerPage.clickOnRequestMetricsTab();
		consumerPage.validateRequestMetricsMaximumFetchLatencyExpandViewLegendHeader3();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_124_validate_RequestMetrics_MaximumFetchLatencyGraph_ExpandViewZoomInBtn() throws EncryptedDocumentException, IOException, InterruptedException {
		 
		consumerPage.clickOnRequestMetricsTab();
		consumerPage.validateRequestMetricsMaximumFetchLatencyExpandViewZoomIn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_125_validate_RequestMetrics_MaximumFetchLatencyGraph_ExpandViewZoomOutBtn() throws EncryptedDocumentException, IOException, InterruptedException {
		 
		consumerPage.clickOnRequestMetricsTab();
		consumerPage.validateRequestMetricsMaximumFetchLatencyExpandViewZoomOut();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_126_validate_RequestMetrics_MaximumFetchLatencyGraph_ExpandViewWidgetDragDrop() throws EncryptedDocumentException, IOException, InterruptedException {
		 
		consumerPage.clickOnRequestMetricsTab();
		consumerPage.validateRequestMetricsMaximumFetchLatencyExpandViewWidgetDragDrop();
	}
/**
 * Connection Metrics Tab
 * @throws EncryptedDocumentException
 * @throws IOException
 */
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_127_validate_ConnectionMetrics_Tab_Title() throws EncryptedDocumentException, IOException {
		consumerPage.validateConnectionMetricsTabTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Consumer, "ConnectionMetrics_Tab_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_128_click_on_ConnectionMetrics_Tab() throws EncryptedDocumentException, IOException {
		consumerPage.clickOnConnectionMetricsTab();
	}
	
/********************************************************* Connection Creation Rate Graph ******************************************************************/

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_129_validate_ConnectionMetrics_ConnectionCreationRateGraph_Title() throws EncryptedDocumentException, IOException {
		 
		consumerPage.clickOnConnectionMetricsTab();
		consumerPage.validateConnectionMetricsConnectionCreationRateGraphTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Consumer, "ConnectionMetrics_ConnectionCreationRate_Graph_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_130_validate_ConnectionMetrics_ConnectionCreationRateGraph_ZoomIn() throws EncryptedDocumentException, IOException {
		 
		consumerPage.clickOnConnectionMetricsTab();
		consumerPage.validateConnectionMetricsConnectionCloseRateZoomInBtn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_131_validate_ConnectionMetrics_ConnectionCreationRateGraph_ZoomOut() throws EncryptedDocumentException, IOException {
		 
		consumerPage.clickOnConnectionMetricsTab();
		consumerPage.validateConnectionMetricsConnectionCloseRateZoomOutBtn();
	}
	
//	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
//	public void TC_132_validate_ConnectionMetrics_ConnectionCreationRateGraph_XaxisValue() throws EncryptedDocumentException, IOException {
//		 
//		consumerPage.clickOnConnectionMetricsTab();
//		consumerPage.validateConnectionMetricsConnectionCreationRateXaxisValues();
//	}
//		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_133_validate_ConnectionMetrics_ConnectionCreationRateGraph_XaxisTitle() throws EncryptedDocumentException, IOException {
		 
		consumerPage.clickOnConnectionMetricsTab();
		consumerPage.validateConnectionMetricsConnectionCreationRateGraphXaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Consumer, "ConnectionMetrics_ConnectionCreationRate_Xaxis_Title"));
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_134_validate_ConnectionMetrics_ConnectionCreationRateGraph_YaxisTitle() throws EncryptedDocumentException, IOException {
		 
		consumerPage.clickOnConnectionMetricsTab();
		consumerPage.validateConnectionMetricsConnectionCreationRateGraphYaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Consumer, "ConnectionMetrics_ConnectionCreationRate_Yaxis_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_135_validate_ConnectionMetrics_ConnectionCreationRateGraph_ConnectionMetricsHeaderTitle() throws EncryptedDocumentException, IOException {
		 
		consumerPage.clickOnConnectionMetricsTab();
		consumerPage.validateConnectionMetricsConnectionCreationRateGraphConnectionMetricsHeaderTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Consumer, "ConnectionMetrics_ConnectionCreationRate_Consumer_Header_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_136_validate_ConnectionMetrics_ConnectionCreationRateGraph_AvgHeaderTitle() throws EncryptedDocumentException, IOException {
		 
		consumerPage.clickOnConnectionMetricsTab();
		consumerPage.validateConnectionMetricsConnectionCreationRateGraphAvgHeaderTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Consumer, "ConnectionMetrics_ConnectionCreationRate_Avg_Header_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_137_validate_ConnectionMetrics_ConnectionCreationRateGraph_MaxHeaderTitle() throws EncryptedDocumentException, IOException {
		 
		consumerPage.clickOnConnectionMetricsTab();
		consumerPage.validateConnectionMetricsConnectionCreationRateGraphMaxHeaderTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Consumer, "ConnectionMetrics_ConnectionCreationRate_Max_Header_Title"));
	}
		
//	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
//	public void TC_138_validate_ConnectionMetrics_ConnectionCreationRateGraph_RowColor1() throws EncryptedDocumentException, IOException {
//		 
//		consumerPage.clickOnConnectionMetricsTab();
//		consumerPage.validateConnectionMetricsConnectionCreationRateGraphRowColor1(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Consumer, "rgb(255, 123, 123)"));
//	}
//	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_140_validate_ConnectionMetrics_ConnectionCreationRateGraph_ToolTip() throws EncryptedDocumentException, IOException {
		 
		consumerPage.clickOnConnectionMetricsTab();
		consumerPage.validateConnectionMetricsConnectionCreationRateToolTipTitle();
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_141_validate_ConnectionMetrics_ConnectionCreationRateGraph_ExpandViewXAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		 
		consumerPage.clickOnConnectionMetricsTab();
		consumerPage.validateConnectionMetricsConnectionCreationRateExpandViewXAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_142_validate_ConnectionMetrics_ConnectionCreationRateGraph_ExpandViewYAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		 
		consumerPage.clickOnConnectionMetricsTab();
		consumerPage.validateConnectionMetricsConnectionCreationRateExpandViewYAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_143_validate_ConnectionMetrics_ConnectionCreationRateGraph_ExpandViewWidgetTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		 
		consumerPage.clickOnConnectionMetricsTab();
		consumerPage.validateConnectionMetricsConnectionCreationRateExpandViewWidgetTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_144_validate_ConnectionMetrics_ConnectionCreationRateGraph_ExpandViewLegendHeader1() throws EncryptedDocumentException, IOException, InterruptedException {
		 
		consumerPage.clickOnConnectionMetricsTab();
		consumerPage.validateConnectionMetricsConnectionCreationRateExpandViewLegendHeader1();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_145_validate_ConnectionMetrics_ConnectionCreationRateGraph_ExpandViewLegendHeader2() throws EncryptedDocumentException, IOException, InterruptedException {
		 
		consumerPage.clickOnConnectionMetricsTab();
		consumerPage.validateConnectionMetricsConnectionCreationRateExpandViewLegendHeader2();
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_146_validate_ConnectionMetrics_ConnectionCreationRateGraph_ExpandViewLegendHeader3() throws EncryptedDocumentException, IOException, InterruptedException {
		 
		consumerPage.clickOnConnectionMetricsTab();
		consumerPage.validateConnectionMetricsConnectionCreationRateExpandViewLegendHeader3();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_147_validate_ConnectionMetrics_ConnectionCreationRateGraph_ExpandViewZoomInBtn() throws EncryptedDocumentException, IOException, InterruptedException {
		 
		consumerPage.clickOnConnectionMetricsTab();
		consumerPage.validateConnectionMetricsConnectionCreationRateExpandViewZoomIn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_148_validate_ConnectionMetrics_ConnectionCreationRateGraph_ExpandViewZoomOutBtn() throws EncryptedDocumentException, IOException, InterruptedException {
		 
		consumerPage.clickOnConnectionMetricsTab();
		consumerPage.validateConnectionMetricsConnectionCreationRateExpandViewZoomOut();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_149_validate_ConnectionMetrics_ConnectionCreationRateGraph_ExpandViewWidgetDragDrop() throws EncryptedDocumentException, IOException, InterruptedException {
		 
		consumerPage.clickOnConnectionMetricsTab();
		consumerPage.validateConnectionMetricsConnectionCreationRateExpandViewWidgetDragDrop();
	}
/********************************************************* Connection Close Rate Graph ******************************************************************/
	
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_150_validate_ConnectionMetrics_ConnectionCloseRateGraph_Title() throws EncryptedDocumentException, IOException {
		 
		consumerPage.clickOnConnectionMetricsTab();
		consumerPage.validateConnectionMetricsConnectionCloseRateGraphTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Consumer, "ConnectionMetrics_ConnectionCloseRate_Graph_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_151_validate_ConnectionMetrics_ConnectionCreationRateGraph_ZoomIn() throws EncryptedDocumentException, IOException {
		 
		consumerPage.clickOnConnectionMetricsTab();
		consumerPage.validateConnectionMetricsConnectionCloseRateZoomInBtn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_152_validate_ConnectionMetrics_ConnectionCreationRateGraph_ZoomOut() throws EncryptedDocumentException, IOException {
		 
		consumerPage.clickOnConnectionMetricsTab();
		consumerPage.validateConnectionMetricsConnectionCloseRateZoomOutBtn();
	}
	
//	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
//	public void TC_153_validate_ConnectionMetrics_ConnectionCloseRateGraph_XaxisValue() throws EncryptedDocumentException, IOException {
//		 
//		consumerPage.clickOnConnectionMetricsTab();
//		consumerPage.validateConnectionMetricsConnectionCloseRateXaxisValues();
//	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_154_validate_ConnectionMetrics_ConnectionCloseRateGraph_XaxisTitle() throws EncryptedDocumentException, IOException {
		 
		//page.pause();
		consumerPage.clickOnConnectionMetricsTab();
		consumerPage.validateConnectionMetricsConnectionCloseRateGraphXaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Consumer, "ConnectionMetrics_ConnectionCloseRate_Xaxis_Title"));
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_155_validate_ConnectionMetrics_ConnectionCloseRateGraph_YaxisTitle() throws EncryptedDocumentException, IOException {
		 
		consumerPage.clickOnConnectionMetricsTab();
		consumerPage.validateConnectionMetricsConnectionCloseRateGraphYaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Consumer, "ConnectionMetrics_ConnectionCloseRate_Yaxis_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_156_validate_ConnectionMetrics_ConnectionCloseRateGraph_ConnectionMetricsHeaderTitle() throws EncryptedDocumentException, IOException {
		 
		consumerPage.clickOnConnectionMetricsTab();
		consumerPage.validateConnectionMetricsConnectionCloseRateGraphConnectionMetricsHeaderTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Consumer, "ConnectionMetrics_ConnectionCloseRate_Consumer_Header_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_157_validate_ConnectionMetrics_ConnectionCloseRateGraph_AvgHeaderTitle() throws EncryptedDocumentException, IOException {
		 
		consumerPage.clickOnConnectionMetricsTab();
		consumerPage.validateConnectionMetricsConnectionCloseRateGraphAvgHeaderTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Consumer, "ConnectionMetrics_ConnectionCloseRate_Avg_Header_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_158_validate_ConnectionMetrics_ConnectionCloseRateGraph_MaxHeaderTitle() throws EncryptedDocumentException, IOException {
		 
		consumerPage.clickOnConnectionMetricsTab();
		consumerPage.validateConnectionMetricsConnectionCloseRateGraphMaxHeaderTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Consumer, "ConnectionMetrics_ConnectionCloseRate_Max_Header_Title"));
	}
		
//	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
//	public void TC_159_validate_ConnectionMetrics_ConnectionCloseRateGraph_RowColor1() throws EncryptedDocumentException, IOException {
//		 
//		consumerPage.clickOnConnectionMetricsTab();
//		consumerPage.validateConnectionMetricsConnectionCloseRateGraphRowColor1(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Consumer, "rgb(255, 123, 123)"));
//	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_160_validate_ConnectionMetrics_ConnectionCloseRateGraph_ToolTip() throws EncryptedDocumentException, IOException {
		 
		consumerPage.clickOnConnectionMetricsTab();
		consumerPage.validateConnectionMetricsConnectionCloseRateToolTipTitle();
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_161_validate_ConnectionMetrics_ConnectionCloseRateGraph_ExpandViewXAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		 
		consumerPage.clickOnConnectionMetricsTab();
		consumerPage.validateConnectionMetricsConnectionCloseRateExpandViewXAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_161_validate_ConnectionMetrics_ConnectionCloseRateGraph_ExpandViewYAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		 
		consumerPage.clickOnConnectionMetricsTab();
		consumerPage.validateConnectionMetricsConnectionCloseRateExpandViewYAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_162_validate_ConnectionMetrics_ConnectionCloseRateGraph_ExpandViewWidgetTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		 
		consumerPage.clickOnConnectionMetricsTab();
		consumerPage.validateConnectionMetricsConnectionCloseRateExpandViewWidgetTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_163_validate_ConnectionMetrics_ConnectionCloseRateGraph_ExpandViewLegendHeader1() throws EncryptedDocumentException, IOException, InterruptedException {
		 
		consumerPage.clickOnConnectionMetricsTab();
		consumerPage.validateConnectionMetricsConnectionCloseRateExpandViewLegendHeader1();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_164_validate_ConnectionMetrics_ConnectionCloseRateGraph_ExpandViewLegendHeader2() throws EncryptedDocumentException, IOException, InterruptedException {
		 
		consumerPage.clickOnConnectionMetricsTab();
		consumerPage.validateConnectionMetricsConnectionCloseRateExpandViewLegendHeader2();
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_165_validate_ConnectionMetrics_ConnectionCloseRateGraph_ExpandViewLegendHeader3() throws EncryptedDocumentException, IOException, InterruptedException {
		 
		consumerPage.clickOnConnectionMetricsTab();
		consumerPage.validateConnectionMetricsConnectionCloseRateExpandViewLegendHeader3();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_166_validate_ConnectionMetrics_ConnectionCloseRateGraph_ExpandViewZoomInBtn() throws EncryptedDocumentException, IOException, InterruptedException {
		 
		consumerPage.clickOnConnectionMetricsTab();
		consumerPage.validateConnectionMetricsConnectionCloseRateExpandViewZoomIn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_167_validate_ConnectionMetrics_ConnectionCloseRateGraph_ExpandViewZoomOutBtn() throws EncryptedDocumentException, IOException, InterruptedException {
		 
		consumerPage.clickOnConnectionMetricsTab();
		consumerPage.validateConnectionMetricsConnectionCloseRateExpandViewZoomOut();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_168_validate_ConnectionMetrics_ConnectionCloseRateGraph_ExpandViewWidgetDragDrop() throws EncryptedDocumentException, IOException, InterruptedException {
		 
		consumerPage.clickOnConnectionMetricsTab();
		consumerPage.validateConnectionMetricsConnectionCloseRateExpandViewWidgetDragDrop();
	}
	
	/********************************************************* I/O Wait Ratio Graph ******************************************************************/
	
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_169_validate_ConnectionMetrics_IOWaitRatioGraph_Title() throws EncryptedDocumentException, IOException {
		 
		consumerPage.clickOnConnectionMetricsTab();
		consumerPage.validateConnectionMetricsIOWaitRatioGraphTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Consumer, "ConnectionMetrics_IOWaitRatio_Graph_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_170_validate_ConnectionMetrics_IOWaitRatioGraph_ZoomIn() throws EncryptedDocumentException, IOException {
		 
		consumerPage.clickOnConnectionMetricsTab();
		consumerPage.validateConnectionMetricsConnectionCloseRateZoomInBtn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_171_validate_ConnectionMetrics_IOWaitRatioGraph_ZoomOut() throws EncryptedDocumentException, IOException {
		 
		consumerPage.clickOnConnectionMetricsTab();
		consumerPage.validateConnectionMetricsConnectionCloseRateZoomOutBtn();
	}
	
//	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
//	public void TC_172_validate_ConnectionMetrics_IOWaitRatioGraph_XaxisValue() throws EncryptedDocumentException, IOException {
//		 
//		consumerPage.clickOnConnectionMetricsTab();
//		consumerPage.validateConnectionMetricsIOWaitRatioXaxisValues();
//	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_173_validate_ConnectionMetrics_IOWaitRatioGraph_XaxisTitle() throws EncryptedDocumentException, IOException {
		 
		consumerPage.clickOnConnectionMetricsTab();
		consumerPage.validateConnectionMetricsIOWaitRatioGraphXaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Consumer, "ConnectionMetrics_IOWaitRatio_Xaxis_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_174_validate_ConnectionMetrics_IOWaitRatioGraph_YaxisTitle() throws EncryptedDocumentException, IOException {
		 
		consumerPage.clickOnConnectionMetricsTab();
		consumerPage.validateConnectionMetricsIOWaitRatioGraphYaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Consumer, "ConnectionMetrics_IOWaitRatio_Yaxis_Title"));
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_175_validate_ConnectionMetrics_IOWaitRatioGraph_ConnectionMetricsHeaderTitle() throws EncryptedDocumentException, IOException {
		 
		//page.pause();
		consumerPage.clickOnConnectionMetricsTab();
		consumerPage.validateConnectionMetricsIOWaitRatioGraphConnectionMetricsHeaderTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Consumer, "ConnectionMetrics_IOWaitRatio_Consumer_Header_Title"));
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_176_validate_ConnectionMetrics_IOWaitRatioGraph_AvgHeaderTitle() throws EncryptedDocumentException, IOException {
		 
		consumerPage.clickOnConnectionMetricsTab();
		consumerPage.validateConnectionMetricsIOWaitRatioGraphAvgHeaderTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Consumer, "ConnectionMetrics_IOWaitRatio_Avg_Header_Title"));
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_177_validate_ConnectionMetrics_IOWaitRatioGraph_MaxHeaderTitle() throws EncryptedDocumentException, IOException {
		 
		consumerPage.clickOnConnectionMetricsTab();
		consumerPage.validateConnectionMetricsIOWaitRatioGraphMaxHeaderTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Consumer, "ConnectionMetrics_IOWaitRatio_Max_Header_Title"));
	}
		
//	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
//	public void TC_178_validate_ConnectionMetrics_IOWaitRatioGraph_RowColor1() throws EncryptedDocumentException, IOException {
//		 
//		consumerPage.clickOnConnectionMetricsTab();
//		consumerPage.validateConnectionMetricsIOWaitRatioGraphRowColor1(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Consumer, "rgb(255, 123, 123)"));
//	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_179_validate_ConnectionMetrics_IOWaitRatioGraph_ToolTip() throws EncryptedDocumentException, IOException {
		 
		consumerPage.clickOnConnectionMetricsTab();
		consumerPage.validateConnectionMetricsIOWaitRatioToolTipTitle();
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_180_validate_ConnectionMetrics_IOWaitRatioGraph_ExpandViewXAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		 
		consumerPage.clickOnConnectionMetricsTab();
		consumerPage.validateConnectionMetricsIOWaitRatioExpandViewXAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_181_validate_ConnectionMetrics_IOWaitRatioGraph_ExpandViewYAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		 
		consumerPage.clickOnConnectionMetricsTab();
		consumerPage.validateConnectionMetricsIOWaitRatioExpandViewYAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_182_validate_ConnectionMetrics_IOWaitRatioGraph_ExpandViewWidgetTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		 
		consumerPage.clickOnConnectionMetricsTab();
		consumerPage.validateConnectionMetricsIOWaitRatioExpandViewWidgetTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_183_validate_ConnectionMetrics_IOWaitRatioGraph_ExpandViewLegendHeader1() throws EncryptedDocumentException, IOException, InterruptedException {
		 
		consumerPage.clickOnConnectionMetricsTab();
		consumerPage.validateConnectionMetricsIOWaitRatioExpandViewLegendHeader1();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_184_validate_ConnectionMetrics_IOWaitRatioGraph_ExpandViewLegendHeader2() throws EncryptedDocumentException, IOException, InterruptedException {
		 
		consumerPage.clickOnConnectionMetricsTab();
		consumerPage.validateConnectionMetricsIOWaitRatioExpandViewLegendHeader2();
	}
			
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_185_validate_ConnectionMetrics_IOWaitRatioGraph_ExpandViewLegendHeader3() throws EncryptedDocumentException, IOException, InterruptedException {
		 
		consumerPage.clickOnConnectionMetricsTab();
		consumerPage.validateConnectionMetricsIOWaitRatioExpandViewLegendHeader3();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_186_validate_ConnectionMetrics_IOWaitRatioGraph_ExpandViewZoomInBtn() throws EncryptedDocumentException, IOException, InterruptedException {
		 
		consumerPage.clickOnConnectionMetricsTab();
		consumerPage.validateConnectionMetricsIOWaitRatioExpandViewZoomIn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_187_validate_ConnectionMetrics_IOWaitRatioGraph_ExpandViewZoomOutBtn() throws EncryptedDocumentException, IOException, InterruptedException {
		 
		consumerPage.clickOnConnectionMetricsTab();
		consumerPage.validateConnectionMetricsIOWaitRatioExpandViewZoomOut();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_188_validate_ConnectionMetrics_IOWaitRatioGraph_ExpandViewWidgetDragDrop() throws EncryptedDocumentException, IOException, InterruptedException {
		 
		consumerPage.clickOnConnectionMetricsTab();
		consumerPage.validateConnectionMetricsIOWaitRatioExpandViewWidgetDragDrop();
	}
/********************************************************* I/O Wait Time Average Graph ******************************************************************/
	
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_189_validate_ConnectionMetrics_IOWaitTimeAverageGraph_Title() throws EncryptedDocumentException, IOException {
		 
		consumerPage.clickOnConnectionMetricsTab();
		consumerPage.validateConnectionMetricsIOWaitTimeAverageGraphTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Consumer, "ConnectionMetrics_IOWaitTimeAverage_Graph_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_190_validate_ConnectionMetrics_IOWaitTimeAverageGraph_ZoomIn() throws EncryptedDocumentException, IOException {
		 
		consumerPage.clickOnConnectionMetricsTab();
		consumerPage.validateConnectionMetricsConnectionCloseRateZoomInBtn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_191_validate_ConnectionMetrics_IOWaitTimeAverageGraph_ZoomOut() throws EncryptedDocumentException, IOException {
		 
		consumerPage.clickOnConnectionMetricsTab();
		consumerPage.validateConnectionMetricsConnectionCloseRateZoomOutBtn();
	}
	
//	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
//	public void TC_192_validate_ConnectionMetrics_IOWaitTimeAverageGraph_XaxisValue() throws EncryptedDocumentException, IOException {
//		 
//		consumerPage.clickOnConnectionMetricsTab();
//		consumerPage.validateConnectionMetricsIOWaitTimeAverageXaxisValues();
//	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_193_validate_ConnectionMetrics_IOWaitTimeAverageGraph_XaxisTitle() throws EncryptedDocumentException, IOException {
		 
		consumerPage.clickOnConnectionMetricsTab();
		consumerPage.validateConnectionMetricsIOWaitTimeAverageGraphXaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Consumer, "ConnectionMetrics_IOWaitTimeAverage_Xaxis_Title"));
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_194_validate_ConnectionMetrics_IOWaitTimeAverageGraph_YaxisTitle() throws EncryptedDocumentException, IOException {
		 
		consumerPage.clickOnConnectionMetricsTab();
		consumerPage.validateConnectionMetricsIOWaitTimeAverageGraphYaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Consumer, "ConnectionMetrics_IOWaitTimeAverage_Yaxis_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_195_validate_ConnectionMetrics_IOWaitTimeAverageGraph_ConnectionMetricsHeaderTitle() throws EncryptedDocumentException, IOException {
		 
		consumerPage.clickOnConnectionMetricsTab();
		consumerPage.validateConnectionMetricsIOWaitTimeAverageGraphConnectionMetricsHeaderTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Consumer, "ConnectionMetrics_IOWaitTimeAverage_Consumer_Header_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_196_validate_ConnectionMetrics_IOWaitTimeAverageGraph_AvgHeaderTitle() throws EncryptedDocumentException, IOException {
		 
		consumerPage.clickOnConnectionMetricsTab();
		consumerPage.validateConnectionMetricsIOWaitTimeAverageGraphAvgHeaderTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Consumer, "ConnectionMetrics_IOWaitTimeAverage_Avg_Header_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_197_validate_ConnectionMetrics_IOWaitTimeAverageGraph_MaxHeaderTitle() throws EncryptedDocumentException, IOException {
		 
		consumerPage.clickOnConnectionMetricsTab();
		consumerPage.validateConnectionMetricsIOWaitTimeAverageGraphMaxHeaderTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Consumer, "ConnectionMetrics_IOWaitTimeAverage_Max_Header_Title"));
	}
	
//	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
//	public void TC_198_validate_ConnectionMetrics_IOWaitTimeAverageGraph_RowColor1() throws EncryptedDocumentException, IOException {
//		 
//		consumerPage.clickOnConnectionMetricsTab();
//		consumerPage.validateConnectionMetricsIOWaitTimeAverageGraphRowColor1(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Consumer, "rgb(255, 123, 123)"));
//	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_199_validate_ConnectionMetrics_IOWaitTimeAverageGraph_ToolTip() throws EncryptedDocumentException, IOException {
		 
		consumerPage.clickOnConnectionMetricsTab();
		consumerPage.validateConnectionMetricsIOWaitTimeAverageToolTipTitle();
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_200_validate_ConnectionMetrics_IOWaitTimeAverageGraph_ExpandViewXAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		 
		consumerPage.clickOnConnectionMetricsTab();
		consumerPage.validateConnectionMetricsIOWaitTimeAverageExpandViewXAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_201_validate_ConnectionMetrics_IOWaitTimeAverageGraph_ExpandViewYAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		 
		consumerPage.clickOnConnectionMetricsTab();
		consumerPage.validateConnectionMetricsIOWaitTimeAverageExpandViewYAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_202_validate_ConnectionMetrics_IOWaitTimeAverageGraph_ExpandViewWidgetTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		 
		consumerPage.clickOnConnectionMetricsTab();
		consumerPage.validateConnectionMetricsIOWaitTimeAverageExpandViewWidgetTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_203_validate_ConnectionMetrics_IOWaitTimeAverageGraph_ExpandViewLegendHeader1() throws EncryptedDocumentException, IOException, InterruptedException {
		 
		consumerPage.clickOnConnectionMetricsTab();
		consumerPage.validateConnectionMetricsIOWaitTimeAverageExpandViewLegendHeader1();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_204_validate_ConnectionMetrics_IOWaitTimeAverageGraph_ExpandViewLegendHeader2() throws EncryptedDocumentException, IOException, InterruptedException {
		 
		consumerPage.clickOnConnectionMetricsTab();
		consumerPage.validateConnectionMetricsIOWaitTimeAverageExpandViewLegendHeader2();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_205_validate_ConnectionMetrics_IOWaitTimeAverageGraph_ExpandViewLegendHeader3() throws EncryptedDocumentException, IOException, InterruptedException {
		 
		consumerPage.clickOnConnectionMetricsTab();
		consumerPage.validateConnectionMetricsIOWaitTimeAverageExpandViewLegendHeader3();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_206_validate_ConnectionMetrics_IOWaitTimeAverageGraph_ExpandViewZoomInBtn() throws EncryptedDocumentException, IOException, InterruptedException {
		 
		consumerPage.clickOnConnectionMetricsTab();
		consumerPage.validateConnectionMetricsIOWaitTimeAverageExpandViewZoomIn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_207_validate_ConnectionMetrics_IOWaitTimeAverageGraph_ExpandViewZoomOutBtn() throws EncryptedDocumentException, IOException, InterruptedException {
		 
		consumerPage.clickOnConnectionMetricsTab();
		consumerPage.validateConnectionMetricsIOWaitTimeAverageExpandViewZoomOut();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_208_validate_ConnectionMetrics_IOWaitTimeAverageGraph_ExpandViewWidgetDragDrop() throws EncryptedDocumentException, IOException, InterruptedException {
		 
		consumerPage.clickOnConnectionMetricsTab();
		consumerPage.validateConnectionMetricsIOWaitTimeAverageExpandViewWidgetDragDrop();
	}
}
