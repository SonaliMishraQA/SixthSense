package mQMonitoring;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.microsoft.playwright.Page;

import genericUtilities.ExcelUtility;
import genericUtilities.GenericMethods;
import genericUtilities.IPathConstant;
import objectRepository.CommonPage;
import objectRepository.DBM.KafkaOverviewPage;
import objectRepository.MQM.MQKafka_Overview_Page;
import playWrightFactory.BaseClass;

public class MQKafka_Overview_Test_1 extends BaseClass
{
	GenericMethods util = new GenericMethods();
	CommonPage commonPage;
	MQKafka_Overview_Page overviewPage;
	ExcelUtility excel = new ExcelUtility();
	
	@BeforeMethod
	public void Overview() throws EncryptedDocumentException, IOException {
		commonPage = new CommonPage(page);
		overviewPage = new  MQKafka_Overview_Page(page);
		excel = new ExcelUtility();
		
		commonPage.navigateToMQM();
		overviewPage.navigateToKafka();
		commonPage.selectTheTimeLineFromCalender(IPathConstant.oneMonthTimeRange);
		String application = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Load, "Application");
		overviewPage.selectServiceName(application);
		 
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_001_validate_Overview_Title() throws EncryptedDocumentException, IOException {
		overviewPage.validateOverviewTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "OverviewTabTitle"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_002_validate_Overview_Metrics_Legend_Title() throws EncryptedDocumentException, IOException {
		overviewPage.validateMetricsLegendTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "MetricsLegendTitle"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_003_validate_Overview_Metrics_NoOfBrokers() throws EncryptedDocumentException, IOException {
		overviewPage.validateMetricsNoOfBrokers(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "MetricsBrokersNos"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_004_validate_Overview_Metrics_NoOfTopics() throws EncryptedDocumentException, IOException {
		overviewPage.validateMetricsNoOfTopics(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "MetricsTopicsNos"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_005_validate_Overview_Metrics_NoOfPartitions() throws EncryptedDocumentException, IOException {
		overviewPage.validateMetricsNoOfPartitions(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "MetricsPartitionsNos"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_006_validate_Overview_Metrics_NoOfProducers() throws EncryptedDocumentException, IOException {
		overviewPage.validateMetricsNoOfProducers(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "MetricsProducersNos"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_007_validate_Overview_Metrics_NoOfConsumers() throws EncryptedDocumentException, IOException {
		overviewPage.validateMetricsNoOfConsumers(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "MetricsConsumersNos"));
	}
	
/**
 * Broker Tab
 * @throws EncryptedDocumentException
 * @throws IOException
 */
	
/*********************************************************Bytes In Graph******************************************************************/
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_008_validate_Broker_Tab_Title() throws EncryptedDocumentException, IOException {
		overviewPage.validateBrokerTabTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Broker_Tab_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_009_validate_Broker_BytesInGraph_Title() throws EncryptedDocumentException, IOException {
		overviewPage.validateBrokerBytesInGraphTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Broker_BytesIn_Graph_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_010_validate_Broker_BytesInGraph_ZoomIn() throws EncryptedDocumentException, IOException {
		overviewPage.validateBytesInZoomInBtn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_011_validate_Broker_BytesInGraph_ZoomOut() throws EncryptedDocumentException, IOException {
		overviewPage.validateBytesInZoomOutBtn();
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_012_validate_Broker_BytesInGraph_Title() throws EncryptedDocumentException, IOException {
		overviewPage.validateBrokerBytesInGraphYaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Broker_BytesIn_Yaxis_Title"));
	}
	
	//Not required
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_013_validate_Broker_BytesInGraph_DragAndDrop() throws EncryptedDocumentException, IOException {
		overviewPage.validateBytesInExpandViewWidgetDragDrop();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_014_validate_Broker_BytesInGraph_XaxisTitle() throws EncryptedDocumentException, IOException {
		overviewPage.validateBrokerBytesInGraphXaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Broker_BytesIn_Xaxis_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_015_validate_Broker_BytesInGraph_YaxisTitle() throws EncryptedDocumentException, IOException {
		overviewPage.validateBrokerBytesInGraphYaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Broker_BytesIn_Yaxis_Title"));
	}	
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_016_validate_Broker_BytesInGraph_BrokerHeaderTitle() throws EncryptedDocumentException, IOException {
		overviewPage.validateBrokerBytesInGraphBrokerHeaderTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Broker_BytesIn_Broker_Header_Title"));
	}	
	
	/*@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_017_validate_Broker_BytesInGraph_BrokerHeader_Arrow() throws EncryptedDocumentException, IOException {
		overviewPage.validateBrokerBytesInGraphBrokerHeaderArrow(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Broker_BytesIn_Broker_Header_Title"));
	}
	*/
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_018_validate_Broker_BytesInGraph_AvgHeaderTitle() throws EncryptedDocumentException, IOException {
		overviewPage.validateBrokerBytesInGraphAvgHeaderTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Broker_BytesIn_Avg_Header_Title"));
	}	
	
	/*@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_019_validate_Broker_BytesInGraph_AvgHeader_Arrow() throws EncryptedDocumentException, IOException {
		overviewPage.validateBrokerBytesInGraphAvgHeaderArrow(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Broker_BytesIn_Broker_Header_Title"));
	}*/
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_020_validate_Broker_BytesInGraph_MaxHeaderTitle() throws EncryptedDocumentException, IOException {
		overviewPage.validateBrokerBytesInGraphMaxHeaderTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Broker_BytesIn_Max_Header_Title"));
	}
	
	/*@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_021_validate_Broker_BytesInGraph_AvgHeader_Arrow() throws EncryptedDocumentException, IOException {
		overviewPage.validateBrokerBytesInGraphAvgHeaderArrow(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Broker_BytesIn_Broker_Header_Title"));
	}*/
/*	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_022_validate_Broker_BytesInGraph_RowColor1() throws EncryptedDocumentException, IOException {
		overviewPage.validateBrokerBytesInGraphRowColor1(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "rgb(255, 123, 123)"));
	}
	
	// Drag and drop here
	
	 // Expand view pop up appeared and disappeared 
	///////////////////////////////////
	
	/*@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_023_validate_Broker_BytesInGraph_WidgetLegend1NameSort() throws EncryptedDocumentException, IOException, InterruptedException {
		overviewPage.validateBytesInWidgetLegendColumn1();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_024_validate_Broker_BytesInGraph_WidgetLegend2NameSort() throws EncryptedDocumentException, IOException, InterruptedException {
		overviewPage.validateBytesInWidgetLegendColumn2();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_025_validate_Broker_BytesInGraph_WidgetLegend3NameSort() throws EncryptedDocumentException, IOException, InterruptedException {
		overviewPage.validateBytesInWidgetLegendColumn3();
	}*/
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_026_validate_Broker_BytesInGraph_ExpandViewXAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		overviewPage.validateBytesInExpandViewXAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_027_validate_Broker_BytesInGraph_ExpandViewYAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		overviewPage.validateBytesInExpandViewYAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_028_validate_Broker_BytesInGraph_ExpandViewWidgetTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		overviewPage.validateBytesInExpandViewWidgetTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_029_validate_Broker_BytesInGraph_ExpandViewLegendHeader1() throws EncryptedDocumentException, IOException, InterruptedException {
		overviewPage.validateBytesInExpandViewLegendHeader1();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_030_validate_Broker_BytesInGraph_ExpandViewLegendHeader2() throws EncryptedDocumentException, IOException, InterruptedException {
		overviewPage.validateBytesInExpandViewLegendHeader2();
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_031_validate_Broker_BytesInGraph_ExpandViewLegendHeader3() throws EncryptedDocumentException, IOException, InterruptedException {
		overviewPage.validateBytesInExpandViewLegendHeader3();
	}
	
	/*@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_032_validate_Broker_BytesInGraph_ExpandViewHeader2InfoMessage() throws EncryptedDocumentException, IOException, InterruptedException {
		overviewPage.validateBytesInExpandViewLegendHeader2InforMessage();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_033_validate_Broker_BytesInGraph_ExpandViewHeader3InfoMessage() throws EncryptedDocumentException, IOException, InterruptedException {
		overviewPage.validateBytesInExpandViewLegendHeader3InforMessage();
	}*/
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_034_validate_Broker_BytesInGraph_ExpandViewZoomInBtn() throws EncryptedDocumentException, IOException, InterruptedException {
		overviewPage.validateBytesInExpandViewZoomIn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_035_validate_Broker_BytesInGraph_ExpandViewZoomOutBtn() throws EncryptedDocumentException, IOException, InterruptedException {
		overviewPage.validateBytesInExpandViewZoomOut();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_036_validate_Broker_BytesInGraph_ExpandViewWidgetDragDrop() throws EncryptedDocumentException, IOException, InterruptedException {
		overviewPage.validateBytesInExpandViewWidgetDragDrop();
	}	
	
	
	/*********************************************************Bytes Out Graph******************************************************************/

//Bytes Out Graph
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_037_validate_Broker_BytesOutGraph_Title() throws EncryptedDocumentException, IOException {
		overviewPage.validateBrokerBytesOutGraphTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Broker_BytesOut_Graph_Title"));
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_038_validate_Broker_BytesOutGraph_ZoomIn() throws EncryptedDocumentException, IOException {
		overviewPage.validateBytesOutZoomInBtn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_039_validate_Broker_BytesOutGraph_ZoomOut() throws EncryptedDocumentException, IOException {
		overviewPage.validateBytesOutZoomOutBtn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_040_validate_Broker_BytesOutGraph_Title() throws EncryptedDocumentException, IOException {
		overviewPage.validateBrokerBytesOutGraphTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Broker_BytesOut_Graph_Title"));
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_041_validate_Broker_BytesOutGraph_XaxisValue() throws EncryptedDocumentException, IOException {
		overviewPage.validateBrokerBytesOutXaxisValues();
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_042_validate_Broker_BytesOutGraph_XaxisTitle() throws EncryptedDocumentException, IOException {
		overviewPage.validateBrokerBytesOutGraphXaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Broker_BytesOut_Xaxis_Title"));
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_043_validate_Broker_BytesOutGraph_YaxisTitle() throws EncryptedDocumentException, IOException {
		overviewPage.validateBrokerBytesOutGraphYaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Broker_BytesOut_Yaxis_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_044_validate_Broker_BytesOutGraph_BrokerHeaderTitle() throws EncryptedDocumentException, IOException {
		overviewPage.validateBrokerBytesOutGraphBrokerHeaderTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Broker_BytesOut_Broker_Header_Title"));
	}	
	
	/*@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_45_validate_Broker_BytesOutGraph_BrokerHeader_Arrow() throws EncryptedDocumentException, IOException {
		overviewPage.validateBrokerBytesOutGraphBrokerHeaderArrow(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Broker_BytesOut_Broker_Header_Title"));

	}*/
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_046_validate_Broker_BytesOutGraph_AvgHeaderTitle() throws EncryptedDocumentException, IOException {
		overviewPage.validateBrokerBytesOutGraphAvgHeaderTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Broker_BytesOut_Avg_Header_Title"));
	}
	
	/*@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_47_validate_Broker_BytesOutGraph_AvgHeader_Arrow() throws EncryptedDocumentException, IOException {
		overviewPage.validateBrokerBytesOutGraphAvgHeaderArrow(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Broker_BytesOut_Broker_Header_Title"));

	}*/
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_048_validate_Broker_BytesOutGraph_MaxHeaderTitle() throws EncryptedDocumentException, IOException {
		overviewPage.validateBrokerBytesOutGraphMaxHeaderTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Broker_BytesOut_Max_Header_Title"));
	}
	
	/*@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_49_validate_Broker_BytesOutGraph_AvgHeader_Arrow() throws EncryptedDocumentException, IOException {
		overviewPage.validateBrokerBytesOutGraphAvgHeaderArrow(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Broker_BytesOut_Broker_Header_Title"));

	}*/
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_050_validate_Broker_BytesOutGraph_RowColor1() throws EncryptedDocumentException, IOException {
		overviewPage.validateBrokerBytesOutGraphRowColor1(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "rgb(255, 123, 123)"));
	}
	
/*	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_051_validate_Broker_BytesOutGraph_WidgetLegend1NameSort() throws EncryptedDocumentException, IOException, InterruptedException {
		overviewPage.validateBytesOutWidgetLegendColumn1();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_052_validate_Broker_BytesOutGraph_WidgetLegend2NameSort() throws EncryptedDocumentException, IOException, InterruptedException {
		overviewPage.validateBytesOutWidgetLegendColumn2();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_053_validate_Broker_BytesOutGraph_WidgetLegend3NameSort() throws EncryptedDocumentException, IOException, InterruptedException {
		overviewPage.validateBytesOutWidgetLegendColumn3();
	}*/
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_054_validate_Broker_BytesOutGraph_ExpandViewXAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		overviewPage.validateBytesOutExpandViewXAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_055_validate_Broker_BytesOutGraph_ExpandViewYAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		overviewPage.validateBytesOutExpandViewYAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_056_validate_Broker_BytesOutGraph_ExpandViewWidgetTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		overviewPage.validateBytesOutExpandViewWidgetTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_057_validate_Broker_BytesOutGraph_ExpandViewLegendHeader1() throws EncryptedDocumentException, IOException, InterruptedException {
		overviewPage.validateBytesOutExpandViewLegendHeader1();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_058_validate_Broker_BytesOutGraph_ExpandViewLegendHeader2() throws EncryptedDocumentException, IOException, InterruptedException {
		overviewPage.validateBytesOutExpandViewLegendHeader2();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_059_validate_Broker_BytesOutGraph_ExpandViewLegendHeader3() throws EncryptedDocumentException, IOException, InterruptedException {
		overviewPage.validateBytesOutExpandViewLegendHeader3();
	}
	
	/*@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_060_validate_Broker_BytesOutGraph_ExpandViewHeader2InfoMessage() throws EncryptedDocumentException, IOException, InterruptedException {
		overviewPage.validateBytesOutExpandViewLegendHeader2InforMessage();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_061_validate_Broker_BytesOutGraph_ExpandViewHeader3InfoMessage() throws EncryptedDocumentException, IOException, InterruptedException {
		overviewPage.validateBytesOutExpandViewLegendHeader3InforMessage();
	}*/
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_062_validate_Broker_BytesOutGraph_ExpandViewZoomInBtn() throws EncryptedDocumentException, IOException, InterruptedException {
		overviewPage.validateBytesOutExpandViewZoomIn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_063_validate_Broker_BytesOutGraph_ExpandViewZoomOutBtn() throws EncryptedDocumentException, IOException, InterruptedException {
		overviewPage.validateBytesOutExpandViewZoomOut();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_064_validate_Broker_BytesOutGraph_ExpandViewWidgetDragDrop() throws EncryptedDocumentException, IOException, InterruptedException {
		overviewPage.validateBytesOutExpandViewWidgetDragDrop();
	}	
	
	
	
	/*********************************************************Total Produced Request Rate Graph******************************************************************/

//Total Produced Request Rate Graph
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_065_validate_Broker_TotalProducedRequestRateGraph_Title1() throws EncryptedDocumentException, IOException {
		overviewPage.validateBrokerTotalProducedRequestRateGraphTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Broker_TotalProducedRequestRate_Graph_Title"));
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_066_validate_Broker_TotalProducedRequestRateGraph_ZoomIn() throws EncryptedDocumentException, IOException {
		overviewPage.validateBrokerTotalProducedRequestRateZoomInBtn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_067_validate_Broker_TotalProducedRequestRateGraph_ZoomOut() throws EncryptedDocumentException, IOException {
		overviewPage.validateBrokerTotalProducedRequestRateZoomOutBtn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_068_validate_Broker_TotalProducedRequestRateGraph_XaxisValue() throws Throwable {
		overviewPage.validateBrokerTotalProducedRequestRateXaxisValues();
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_069_validate_Broker_TotalProducedRequestRateGraph_XaxisTitle() throws EncryptedDocumentException, IOException {
		overviewPage.validateBrokerTotalProducedRequestRateGraphXaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Broker_TotalProducedRequestRate_Xaxis_Title"));
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_070_validate_Broker_TotalProducedRequestRateGraphGraph_YaxisTitle() throws EncryptedDocumentException, IOException {
		overviewPage.validateBrokerTotalProducedRequestRateGraphYaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Broker_TotalProducedRequestRate_Yaxis_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_071_validate_Broker_TotalProducedRequestRateGraph_BrokerHeaderTitle() throws EncryptedDocumentException, IOException {
		overviewPage.validateBrokerTotalProducedRequestRateGraphBrokerHeaderTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Broker_TotalProducedRequestRate_Broker_Header_Title"));
	}	
	
	/*@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_072_validate_Broker_TotalProducedRequestRateGraph_BrokerHeader_Arrow() throws EncryptedDocumentException, IOException {
		overviewPage.validateBrokerTotalProducedRequestRateGraphBrokerHeaderArrow(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Broker_TotalProducedRequestRate_Broker_Header_Title"));
	}*/
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_073_validate_Broker_TotalProducedRequestRateGraph_AvgHeaderTitle() throws EncryptedDocumentException, IOException {
		overviewPage.validateBrokerTotalProducedRequestRateGraphAvgHeaderTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Broker_TotalProducedRequestRate_Avg_Header_Title"));
	}	
	
	/*@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_074_validate_Broker_TotalProducedRequestRateGraph_AvgHeader_Arrow() throws EncryptedDocumentException, IOException {
		overviewPage.validateBrokerTotalProducedRequestRateGraphAvgHeaderArrow(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Broker_TotalProducedRequestRate_Broker_Header_Title"));
	}*/
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_075_validate_Broker_TotalProducedRequestRateGraph_MaxHeaderTitle() throws EncryptedDocumentException, IOException {
		overviewPage.validateBrokerTotalProducedRequestRateGraphMaxHeaderTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Broker_TotalProducedRequestRate_Max_Header_Title"));
	}
	
	/*@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_076_validate_Broker_TotalProducedRequestRateGraph_AvgHeader_Arrow() throws EncryptedDocumentException, IOException {
		overviewPage.validateBrokerTotalProducedRequestRateGraphAvgHeaderArrow(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Broker_TotalProducedRequestRate_Broker_Header_Title"));
	}*/
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_077_validate_Broker_TotalProducedRequestRateGraph_RowColor1() throws EncryptedDocumentException, IOException {
		overviewPage.validateBrokerTotalProducedRequestRateGraphRowColor1(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "rgb(255, 123, 123)"));
	}
	
	/*@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_078_validate_Broker_TotalProducedRequestRateGraph_WidgetLegend1NameSort() throws EncryptedDocumentException, IOException, InterruptedException {
		overviewPage.validateTotalProducedRequestRateWidgetLegendColumn1();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_079_validate_Broker_TotalProducedRequestRateGraph_WidgetLegend2NameSort() throws EncryptedDocumentException, IOException, InterruptedException {
		overviewPage.validateTotalProducedRequestRateWidgetLegendColumn2();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_080_validate_Broker_TotalProducedRequestRateGraph_WidgetLegend3NameSort() throws EncryptedDocumentException, IOException, InterruptedException {
		overviewPage.validateTotalProducedRequestRateWidgetLegendColumn3();
	}*/
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_081_validate_Broker_TotalProducedRequestRateGraph_ExpandViewXAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		overviewPage.validateTotalProducedRequestRateExpandViewXAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_082_validate_Broker_TotalProducedRequestRateGraph_ExpandViewYAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		overviewPage.validateTotalProducedRequestRateExpandViewYAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_083_validate_Broker_TotalProducedRequestRateGraph_ExpandViewWidgetTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		overviewPage.validateTotalProducedRequestRateExpandViewWidgetTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_084_validate_Broker_TotalProducedRequestRateGraph_ExpandViewLegendHeader1() throws EncryptedDocumentException, IOException, InterruptedException {
		overviewPage.validateTotalProducedRequestRateExpandViewLegendHeader1();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_085_validate_Broker_TotalProducedRequestRateGraph_ExpandViewLegendHeader2() throws EncryptedDocumentException, IOException, InterruptedException {
		overviewPage.validateTotalProducedRequestRateExpandViewLegendHeader2();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_086_validate_Broker_TotalProducedRequestRateGraph_ExpandViewLegendHeader3() throws EncryptedDocumentException, IOException, InterruptedException {
		overviewPage.validateTotalProducedRequestRateExpandViewLegendHeader3();
	}
	
	/*@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_087_validate_Broker_TotalProducedRequestRateGraph_ExpandViewHeader2InfoMessage() throws EncryptedDocumentException, IOException, InterruptedException {
		overviewPage.validateTotalProducedRequestRateExpandViewLegendHeader2InforMessage();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_088_validate_Broker_TotalProducedRequestRateGraph_ExpandViewHeader3InfoMessage() throws EncryptedDocumentException, IOException, InterruptedException {
		overviewPage.validateTotalProducedRequestRateExpandViewLegendHeader3InforMessage();
	}*/
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_089_validate_Broker_TotalProducedRequestRateGraph_ExpandViewZoomInBtn() throws EncryptedDocumentException, IOException, InterruptedException {
		overviewPage.validateTotalProducedRequestRateExpandViewZoomIn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_090_validate_Broker_TotalProducedRequestRateGraph_ExpandViewZoomOutBtn() throws EncryptedDocumentException, IOException, InterruptedException {
		overviewPage.validateTotalProducedRequestRateExpandViewZoomOut();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_091_validate_Broker_TotalProducedRequestRateGraph_ExpandViewWidgetDragDrop() throws EncryptedDocumentException, IOException, InterruptedException {
		overviewPage.validateTotalProducedRequestRateExpandViewWidgetDragDrop();
	}	
	
	
	
	/*********************************************************Total Fetch Request Rate Graph******************************************************************/

//Broker - Total Fetch Request Rate Graph
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_092_validate_Broker_TotalFetchRequestRateGraph_Title() throws EncryptedDocumentException, IOException {
		overviewPage.validateBrokerTotalFetchRequestRateGraphTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Broker_TotalFetchRequestRate_Graph_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_093_validate_Broker_TotalFtechRequestRateGraph_ZoomIn() throws EncryptedDocumentException, IOException {
		overviewPage.validateBrokerTotalProducedRequestRateZoomInBtn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_094_validate_Broker_TotalFtechRequestRateGraph_ZoomOut() throws EncryptedDocumentException, IOException {
		overviewPage.validateBrokerTotalProducedRequestRateZoomOutBtn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_095_validate_Broker_TotalFetchRequestRateGraph_XaxisValue() throws EncryptedDocumentException, IOException {
		overviewPage.validateBrokerTotalFetchRequestRateXaxisValues();
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_096_validate_Broker_TotalFetchRequestRateGraph_XaxisTitle() throws EncryptedDocumentException, IOException {
		overviewPage.validateBrokerTotalFetchRequestRateGraphXaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Broker_TotalFetchRequestRate_Xaxis_Title"));
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_097_validate_Broker_otalFetchRequestRateGraphGraph_YaxisTitle() throws EncryptedDocumentException, IOException {
		overviewPage.validateBrokerTotalFetchRequestRateGraphYaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Broker_TotalFetchRequestRate_Yaxis_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_098_validate_Broker_TotalFetchRequestRateGraph_BrokerHeaderTitle() throws EncryptedDocumentException, IOException {
		overviewPage.validateBrokerTotalFetchRequestRateGraphBrokerHeaderTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Broker_TotalFetchRequestRate_Broker_Header_Title"));
	}
	
	/*@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_99_validate_Broker_TotalFetchRequestRateGraph_AvgHeader_Arrow() throws EncryptedDocumentException, IOException {
		overviewPage.validateBrokerTotalFetchRequestRateGraphAvgHeaderArrow(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Broker_TotalFetchRequestRate_Broker_Header_Title"));
	}*/
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_100_validate_Broker_TotalFetchRequestRateGraph_AvgHeaderTitle() throws EncryptedDocumentException, IOException {
		overviewPage.validateBrokerTotalFetchRequestRateGraphAvgHeaderTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Broker_TotalFetchRequestRate_Avg_Header_Title"));
	}
	
	/*@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_101_validate_Broker_TotalFetchRequestRateGraph_AvgHeader_Arrow() throws EncryptedDocumentException, IOException {
		overviewPage.validateBrokerTotalFetchRequestRateGraphAvgHeaderArrow(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Broker_TotalFetchRequestRate_Broker_Header_Title"));
	}*/
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_102_validate_Broker_TotalFetchRequestRateGraph_MaxHeaderTitle() throws EncryptedDocumentException, IOException {
		overviewPage.validateBrokerTotalFetchRequestRateGraphMaxHeaderTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Broker_TotalFetchRequestRate_Max_Header_Title"));
	}
	
	/*@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_103_validate_Broker_TotalFetchRequestRateGraph_AvgHeader_Arrow() throws EncryptedDocumentException, IOException {
		overviewPage.validateBrokerTotalFetchRequestRateGraphAvgHeaderArrow(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Broker_TotalFetchRequestRate_Broker_Header_Title"));
	}*/
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_104_validate_Broker_TotalFetchRequestRateGraph_RowColor1() throws EncryptedDocumentException, IOException {
		overviewPage.validateBrokerTotalFetchRequestRateGraphRowColor1(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "rgb(255, 123, 123)"));
	}
	
	/*@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_105_validate_Broker_TotalFetchRequestRateGraph_WidgetLegend1NameSort() throws EncryptedDocumentException, IOException, InterruptedException {
		overviewPage.validateTotalFetchRequestRateWidgetLegendColumn1();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_106_validate_Broker_TotalFetchRequestRateGraph_WidgetLegend2NameSort() throws EncryptedDocumentException, IOException, InterruptedException {
		overviewPage.validateTotalFetchRequestRateWidgetLegendColumn2();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_107_validate_Broker_TotalFetchRequestRateGraph_WidgetLegend3NameSort() throws EncryptedDocumentException, IOException, InterruptedException {
		overviewPage.validateTotalFetchRequestRateWidgetLegendColumn3();
	}*/
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_108_validate_Broker_TotalFetchRequestRateGraph_ExpandViewXAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		overviewPage.validateTotalFetchRequestRateExpandViewXAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_109_validate_Broker_TotalFetchRequestRateGraph_ExpandViewYAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		overviewPage.validateTotalFetchRequestRateExpandViewYAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_110_validate_Broker_TotalFetchRequestRateGraph_ExpandViewWidgetTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		overviewPage.validateTotalFetchRequestRateExpandViewWidgetTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_111_validate_Broker_TotalFetchRequestRateGraph_ExpandViewLegendHeader1() throws EncryptedDocumentException, IOException, InterruptedException {
		overviewPage.validateTotalFetchRequestRateExpandViewLegendHeader1();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_112_validate_Broker_TotalFetchRequestRateGraph_ExpandViewLegendHeader2() throws EncryptedDocumentException, IOException, InterruptedException {
		overviewPage.validateTotalFetchRequestRateExpandViewLegendHeader2();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_113_validate_Broker_TotalFetchRequestRateGraph_ExpandViewLegendHeader3() throws EncryptedDocumentException, IOException, InterruptedException {
		overviewPage.validateTotalFetchRequestRateExpandViewLegendHeader3();
	}
	
	/*@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_114_validate_Broker_TotalFetchRequestRateGraph_ExpandViewHeader2InfoMessage() throws EncryptedDocumentException, IOException, InterruptedException {
		overviewPage.validateTotalFetchRequestRateExpandViewLegendHeader2InforMessage();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_115_validate_Broker_TotalFetchRequestRateGraph_ExpandViewHeader3InfoMessage() throws EncryptedDocumentException, IOException, InterruptedException {
		overviewPage.validateTotalFetchRequestRateExpandViewLegendHeader3InforMessage();
	}*/
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_116_validate_Broker_TotalFetchRequestRateGraph_ExpandViewZoomInBtn() throws EncryptedDocumentException, IOException, InterruptedException {
		overviewPage.validateTotalFetchRequestRateExpandViewZoomIn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_117_validate_Broker_TotalFetchRequestRateGraph_ExpandViewZoomOutBtn() throws EncryptedDocumentException, IOException, InterruptedException {
		overviewPage.validateTotalFetchRequestRateExpandViewZoomOut();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_118_validate_Broker_TotalFetchRequestRateGraph_ExpandViewWidgetDragDrop() throws EncryptedDocumentException, IOException, InterruptedException {
		overviewPage.validateTotalFetchRequestRateExpandViewWidgetDragDrop();
	}	
	
	
	/******************************************************** MessagesIn Graph ******************************************************************/
	

//Broker - MessagesIn Graph
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_119_validate_Broker_MessagesInGraph_Title() throws EncryptedDocumentException, IOException {
		overviewPage.validateBrokerMessagesInGraphTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Broker_MessagesIn_Graph_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_120_validate_Broker_MessagesInGraph_ZoomIn() throws EncryptedDocumentException, IOException {
		overviewPage.validateMessagesInZoomInBtn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_121_validate_Broker_MessagesInGraph_ZoomOut() throws EncryptedDocumentException, IOException {
		overviewPage.validateMessagesInZoomOutBtn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_123_validate_Broker_MessagesInGraph_XaxisValue() throws EncryptedDocumentException, IOException {
		overviewPage.validateBrokerMessagesInXaxisValues();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_124_validate_Broker_MessagesInGraph_XaxisTitle() throws EncryptedDocumentException, IOException {
		overviewPage.validateBrokerMessagesInGraphXaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Broker_MessagesIn_Xaxis_Title"));
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_125_validate_Broker_MessagesIn_Graph_YaxisTitle() throws EncryptedDocumentException, IOException {
		overviewPage.validateBrokerMessagesInGraphYaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Broker_MessagesIn_Yaxis_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_126_validate_Broker_MessagesInGraph_BrokerHeaderTitle() throws EncryptedDocumentException, IOException {
		overviewPage.validateBrokerMessagesInGraphBrokerHeaderTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Broker_MessagesIn_Broker_Header_Title"));
	}
		
	/*@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_127_validate_Broker_MessagesInGraph_BrokerHeader_Arrow() throws EncryptedDocumentException, IOException {
		overviewPage.validateBrokerMessagesInGraphBrokerHeaderArrow(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Broker_MessagesIn_Broker_Header_Title"));
	}*/
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_128_validate_Broker_MessagesInGraph_AvgHeaderTitle() throws EncryptedDocumentException, IOException {
		overviewPage.validateBrokerMessagesInGraphAvgHeaderTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Broker_MessagesIn_Avg_Header_Title"));
	}
		
	/*@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_129_validate_Broker_MessagesInGraph_AvgHeader_Arrow() throws EncryptedDocumentException, IOException {
		overviewPage.validateBrokerMessagesInGraphAvgHeaderArrow(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Broker_MessagesIn_Broker_Header_Title"));
	}*/
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_130_validate_Broker_MessagesInGraph_MaxHeaderTitle() throws EncryptedDocumentException, IOException {
		overviewPage.validateBrokerMessagesInGraphMaxHeaderTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Broker_MessagesIn_Max_Header_Title"));
	}
	
	/*@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_131_validate_Broker_MessagesInGraph_AvgHeader_Arrow() throws EncryptedDocumentException, IOException {
		overviewPage.validateBrokerMessagesInGraphAvgHeaderArrow(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Broker_MessagesIn_Broker_Header_Title"));
	}*/
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_132_validate_Broker_MessagesInGraph_RowColor1() throws EncryptedDocumentException, IOException {
		overviewPage.validateBrokerMessagesInGraphRowColor1(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "rgb(255, 123, 123)"));
	}
	
	/*@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_133_validate_Broker_MessagesInGraph_WidgetLegend1NameSort() throws EncryptedDocumentException, IOException, InterruptedException {
		overviewPage.validateMessagesInWidgetLegendColumn1();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_134_validate_Broker_MessagesInGraph_WidgetLegend2NameSort() throws EncryptedDocumentException, IOException, InterruptedException {
		overviewPage.validateMessagesInWidgetLegendColumn2();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_135_validate_Broker_MessagesInGraph_WidgetLegend3NameSort() throws EncryptedDocumentException, IOException, InterruptedException {
		overviewPage.validateMessagesInWidgetLegendColumn3();
	}*/
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_136_validate_Broker_MessagesInGraph_ExpandViewXAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		overviewPage.validateMessagesInExpandViewXAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_137_validate_Broker_MessagesInGraph_ExpandViewYAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		overviewPage.validateMessagesInExpandViewYAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_138_validate_Broker_MessagesInGraph_ExpandViewWidgetTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		overviewPage.validateMessagesInExpandViewWidgetTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_139_validate_Broker_MessagesInGraph_ExpandViewLegendHeader1() throws EncryptedDocumentException, IOException, InterruptedException {
		overviewPage.validateMessagesInExpandViewLegendHeader1();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_140_validate_Broker_MessagesInGraph_ExpandViewLegendHeader2() throws EncryptedDocumentException, IOException, InterruptedException {
		overviewPage.validateMessagesInExpandViewLegendHeader2();
	}	

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_141_validate_Broker_MessagesInGraph_ExpandViewLegendHeader3() throws EncryptedDocumentException, IOException, InterruptedException {
		overviewPage.validateMessagesInExpandViewLegendHeader3();
	}
	
	/*@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_142_validate_Broker_MessagesInGraph_ExpandViewHeader2InfoMessage() throws EncryptedDocumentException, IOException, InterruptedException {
		overviewPage.validateMessagesInExpandViewLegendHeader2InforMessage();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_143_validate_Broker_MessagesInGraph_ExpandViewHeader3InfoMessage() throws EncryptedDocumentException, IOException, InterruptedException {
		overviewPage.validateMessagesInExpandViewLegendHeader3InforMessage();
	}*/
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_144_validate_Broker_MessagesInGraph_ExpandViewZoomInBtn() throws EncryptedDocumentException, IOException, InterruptedException {
		overviewPage.validateMessagesInExpandViewZoomIn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_145_validate_Broker_MessagesInGraph_ExpandViewZoomOutBtn() throws EncryptedDocumentException, IOException, InterruptedException {
		overviewPage.validateMessagesInExpandViewZoomOut();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_146_validate_Broker_MessagesInGraph_ExpandViewWidgetDragDrop() throws EncryptedDocumentException, IOException, InterruptedException {
		overviewPage.validateMessagesInExpandViewWidgetDragDrop();
	}	
	
	
	/******************************************************** Leader Election Rate Graph ******************************************************************/

//Broker - LeaderElectionRate Graph
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_147_validate_Broker_LeaderElectionRateGraph_Title() throws EncryptedDocumentException, IOException {
		overviewPage.validateBrokerLeaderElectionRateGraphTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Broker_LeaderElectionRate_Graph_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_148_validate_Broker_LeaderElectionRateGraph_ZoomIn() throws EncryptedDocumentException, IOException {
		overviewPage.validateLeaderElectionRateZoomInBtn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_149_validate_Broker_LeaderElectionRateGraph_ZoomOut() throws EncryptedDocumentException, IOException {
		overviewPage.validateLeaderElectionRateZoomOutBtn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_150_validate_Broker_LeaderElectionRateGraph_XaxisValue() throws EncryptedDocumentException, IOException {
		overviewPage.validateBrokerLeaderElectionRateXaxisValues();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_151_validate_Broker_LeaderElectionRateGraph_XaxisTitle() throws EncryptedDocumentException, IOException {
		overviewPage.validateBrokerLeaderElectionRateGraphXaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Broker_LeaderElectionRate_Xaxis_Title"));
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_152_validate_Broker_LeaderElectionRate_Graph_YaxisTitle() throws EncryptedDocumentException, IOException {
		overviewPage.validateBrokerLeaderElectionRateGraphYaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Broker_LeaderElectionRate_Yaxis_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_153_validate_Broker_LeaderElectionRateGraph_BrokerHeaderTitle() throws EncryptedDocumentException, IOException {
		overviewPage.validateBrokerLeaderElectionRateGraphBrokerHeaderTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Broker_LeaderElectionRate_Broker_Header_Title"));
	}
		
	/*@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_154_validate_Broker_LeaderElectionRateGraph_BrokerHeader_Arrow() throws EncryptedDocumentException, IOException {
		overviewPage.validateBrokerLeaderElectionRateGraphBrokerHeaderArrow(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Broker_LeaderElectionRate_Broker_Header_Title"));
	}*/
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_155_validate_Broker_LeaderElectionRateGraph_AvgHeaderTitle() throws EncryptedDocumentException, IOException {
		overviewPage.validateBrokerLeaderElectionRateGraphAvgHeaderTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Broker_LeaderElectionRate_Avg_Header_Title"));
	}
		
	/*@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_156_validate_Broker_LeaderElectionRateGraph_AvgHeader_Arrow() throws EncryptedDocumentException, IOException {
		overviewPage.validateBrokerLeaderElectionRateGraphAvgHeaderArrow(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Broker_LeaderElectionRate_Broker_Header_Title"));
	}*/
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_157_validate_Broker_LeaderElectionRateGraph_MaxHeaderTitle() throws EncryptedDocumentException, IOException {
		overviewPage.validateBrokerLeaderElectionRateGraphMaxHeaderTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Broker_LeaderElectionRate_Max_Header_Title"));
	}
	
	/*@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_158_validate_Broker_LeaderElectionRateGraph_AvgHeader_Arrow() throws EncryptedDocumentException, IOException {
		overviewPage.validateBrokerLeaderElectionRateGraphAvgHeaderArrow(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Broker_LeaderElectionRate_Broker_Header_Title"));
	}*/
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_159_validate_Broker_LeaderElectionRateGraph_RowColor1() throws EncryptedDocumentException, IOException {
		overviewPage.validateBrokerLeaderElectionRateGraphRowColor1(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "rgb(255, 123, 123)"));
	}

	/*@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_160_validate_Broker_LeaderElectionRateGraph_WidgetLegend1NameSort() throws EncryptedDocumentException, IOException, InterruptedException {
		overviewPage.validateLeaderElectionRateWidgetLegendColumn1();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_161_validate_Broker_LeaderElectionRateGraph_WidgetLegend2NameSort() throws EncryptedDocumentException, IOException, InterruptedException {
		overviewPage.validateLeaderElectionRateWidgetLegendColumn2();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_162_validate_Broker_LeaderElectionRateGraph_WidgetLegend3NameSort() throws EncryptedDocumentException, IOException, InterruptedException {
		overviewPage.validateLeaderElectionRateWidgetLegendColumn3();
	}*/
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_163_validate_Broker_LeaderElectionRateGraph_ExpandViewXAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		overviewPage.validateLeaderElectionRateExpandViewXAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_164_validate_Broker_LeaderElectionRateGraph_ExpandViewYAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		overviewPage.validateLeaderElectionRateExpandViewYAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_165_validate_Broker_LeaderElectionRateGraph_ExpandViewWidgetTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		overviewPage.validateLeaderElectionRateExpandViewWidgetTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_166_validate_Broker_LeaderElectionRateGraph_ExpandViewLegendHeader1() throws EncryptedDocumentException, IOException, InterruptedException {
		overviewPage.validateLeaderElectionRateExpandViewLegendHeader1();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_167_validate_Broker_LeaderElectionRateGraph_ExpandViewLegendHeader2() throws EncryptedDocumentException, IOException, InterruptedException {
		overviewPage.validateLeaderElectionRateExpandViewLegendHeader2();
	}	

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_168_validate_Broker_LeaderElectionRateGraph_ExpandViewLegendHeader3() throws EncryptedDocumentException, IOException, InterruptedException {
		overviewPage.validateLeaderElectionRateExpandViewLegendHeader3();
	}
	
	/*@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_169_validate_Broker_LeaderElectionRateGraph_ExpandViewHeader2InfoMessage() throws EncryptedDocumentException, IOException, InterruptedException {
		overviewPage.validateLeaderElectionRateExpandViewLegendHeader2InforMessage();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_170_validate_Broker_LeaderElectionRateGraph_ExpandViewHeader3InfoMessage() throws EncryptedDocumentException, IOException, InterruptedException {
		overviewPage.validateLeaderElectionRateExpandViewLegendHeader3InforMessage();
	}*/
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_171_validate_Broker_LeaderElectionRateGraph_ExpandViewZoomInBtn() throws EncryptedDocumentException, IOException, InterruptedException {
		overviewPage.validateLeaderElectionRateExpandViewZoomIn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_172_validate_Broker_LeaderElectionRateGraph_ExpandViewZoomOutBtn() throws EncryptedDocumentException, IOException, InterruptedException {
		overviewPage.validateLeaderElectionRateExpandViewZoomOut();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_173_validate_Broker_LeaderElectionRateGraph_ExpandViewWidgetDragDrop() throws EncryptedDocumentException, IOException, InterruptedException {
		overviewPage.validateLeaderElectionRateExpandViewWidgetDragDrop();
	}	
	
	/******************************************************** Un-cleaned Election Leader Graph******************************************************************/

//Broker - Un-cleaned Election Leader Graph
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_174_validate_Broker_UncleanedElectionLeaderGraph_Title() throws EncryptedDocumentException, IOException {
		overviewPage.validateBrokerUncleanedElectionLeaderGraphTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Broker_UncleanedElectionLeader_Graph_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_175_validate_Broker_UncleanedElectionLeaderGraph_ZoomIn() throws EncryptedDocumentException, IOException {
		overviewPage.validateUncleanedElectionLeaderZoomInBtn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_176_validate_Broker_UncleanedElectionLeaderGraph_ZoomOut() throws EncryptedDocumentException, IOException {
		overviewPage.validateUncleanedElectionLeaderZoomOutBtn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_177_validate_Broker_UncleanedElectionLeaderGraph_XaxisValue() throws EncryptedDocumentException, IOException {
		overviewPage.validateBrokerUncleanedElectionLeaderXaxisValues();
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_178_validate_Broker_UncleanedElectionLeaderGraph_XaxisTitle() throws EncryptedDocumentException, IOException {
		overviewPage.validateBrokerUncleanedElectionLeaderGraphXaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Broker_UncleanedElectionLeader_Xaxis_Title"));
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_179_validate_Broker_UncleanedElectionLeader_Graph_YaxisTitle() throws EncryptedDocumentException, IOException {
		overviewPage.validateBrokerUncleanedElectionLeaderGraphYaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Broker_UncleanedElectionLeader_Yaxis_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_180_validate_Broker_UncleanedElectionLeaderGraph_BrokerHeaderTitle() throws EncryptedDocumentException, IOException {
		overviewPage.validateBrokerUncleanedElectionLeaderGraphBrokerHeaderTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Broker_UncleanedElectionLeader_Broker_Header_Title"));
	}
	
	/*@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_181_validate_Broker_UncleanedElectionLeaderGraph_BrokerHeader_Arrow() throws EncryptedDocumentException, IOException {
		overviewPage.validateBrokerUncleanedElectionLeaderGraphBrokerHeaderArrow(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Broker_UncleanedElectionLeader_Broker_Header_Title"));

	}*/
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_182_validate_Broker_UncleanedElectionLeaderGraph_AvgHeaderTitle() throws EncryptedDocumentException, IOException {
		overviewPage.validateBrokerUncleanedElectionLeaderGraphAvgHeaderTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Broker_UncleanedElectionLeader_Avg_Header_Title"));
	}	
	
	/*@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_183_validate_Broker_UncleanedElectionLeaderGraph_AvgHeader_Arrow() throws EncryptedDocumentException, IOException {
		overviewPage.validateBrokerUncleanedElectionLeaderGraphAvgHeaderArrow(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Broker_UncleanedElectionLeader_Broker_Header_Title"));
	}*/	
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_184_validate_Broker_UncleanedElectionLeaderGraph_MaxHeaderTitle() throws EncryptedDocumentException, IOException {
		overviewPage.validateBrokerUncleanedElectionLeaderGraphMaxHeaderTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Broker_UncleanedElectionLeader_Max_Header_Title"));
	}
	
	/*@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_185_validate_Broker_UncleanedElectionLeaderGraph_AvgHeader_Arrow() throws EncryptedDocumentException, IOException {
		overviewPage.validateBrokerUncleanedElectionLeaderGraphAvgHeaderArrow(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Broker_UncleanedElectionLeader_Broker_Header_Title"));
	}*/
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_186_validate_Broker_UncleanedElectionLeaderGraph_RowColor1() throws EncryptedDocumentException, IOException {
		overviewPage.validateBrokerUncleanedElectionLeaderGraphRowColor1(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "rgb(255, 123, 123)"));
	}

	/*@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_187_validate_Broker_UncleanedElectionLeaderGraph_WidgetLegend1NameSort() throws EncryptedDocumentException, IOException, InterruptedException {
		overviewPage.validateUncleanedElectionLeaderWidgetLegendColumn1();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_188_validate_Broker_UncleanedElectionLeaderGraph_WidgetLegend2NameSort() throws EncryptedDocumentException, IOException, InterruptedException {
		overviewPage.validateUncleanedElectionLeaderWidgetLegendColumn2();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_189_validate_Broker_UncleanedElectionLeaderGraph_WidgetLegend3NameSort() throws EncryptedDocumentException, IOException, InterruptedException {
		overviewPage.validateUncleanedElectionLeaderWidgetLegendColumn3();
	}*/
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_190_validate_Broker_UncleanedElectionLeaderGraph_ExpandViewXAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		overviewPage.validateUncleanedElectionLeaderExpandViewXAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_191_validate_Broker_UncleanedElectionLeaderGraph_ExpandViewYAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		overviewPage.validateUncleanedElectionLeaderExpandViewYAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_192_validate_Broker_UncleanedElectionLeaderGraph_ExpandViewWidgetTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		overviewPage.validateUncleanedElectionLeaderExpandViewWidgetTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_193_validate_Broker_UncleanedElectionLeaderGraph_ExpandViewLegendHeader1() throws EncryptedDocumentException, IOException, InterruptedException {
		overviewPage.validateUncleanedElectionLeaderExpandViewLegendHeader1();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_194_validate_Broker_UncleanedElectionLeaderGraph_ExpandViewLegendHeader2() throws EncryptedDocumentException, IOException, InterruptedException {
		overviewPage.validateUncleanedElectionLeaderExpandViewLegendHeader2();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_195_validate_Broker_UncleanedElectionLeaderGraph_ExpandViewLegendHeader3() throws EncryptedDocumentException, IOException, InterruptedException {
		overviewPage.validateUncleanedElectionLeaderExpandViewLegendHeader3();
	}
	
	/*@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_196_validate_Broker_UncleanedElectionLeaderGraph_ExpandViewHeader2InfoMessage() throws EncryptedDocumentException, IOException, InterruptedException {
		overviewPage.validateUncleanedElectionLeaderExpandViewLegendHeader2InforMessage();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_197_validate_Broker_UncleanedElectionLeaderGraph_ExpandViewHeader3InfoMessage() throws EncryptedDocumentException, IOException, InterruptedException {
		overviewPage.validateUncleanedElectionLeaderExpandViewLegendHeader3InforMessage();
	}
	*/
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_198_validate_Broker_UncleanedElectionLeaderGraph_ExpandViewZoomInBtn() throws EncryptedDocumentException, IOException, InterruptedException {
		overviewPage.validateUncleanedElectionLeaderExpandViewZoomIn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_199_validate_Broker_UncleanedElectionLeaderGraph_ExpandViewZoomOutBtn() throws EncryptedDocumentException, IOException, InterruptedException {
		overviewPage.validateUncleanedElectionLeaderExpandViewZoomOut();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_200_validate_Broker_UncleanedElectionLeaderGraph_ExpandViewWidgetDragDrop() throws EncryptedDocumentException, IOException, InterruptedException {
		overviewPage.validateUncleanedElectionLeaderExpandViewWidgetDragDrop();
	}	
	
	
	/******************************************************** Number Of Brokers Graph ******************************************************************/

//Broker - Number Of Brokers Graph
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_201_validate_Broker_NumberOfBrokersGraph_Title() throws EncryptedDocumentException, IOException {		
		overviewPage.validateBrokerNumberOfBrokersGraphTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Broker_NumberOfBrokers_Graph_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_202_validate_Broker_NumberOfBrokersGraph_ZoomIn() throws EncryptedDocumentException, IOException {
		overviewPage.validateNumberOfBrokersZoomInBtn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_203_validate_Broker_NumberOfBrokersGraph_ZoomOut() throws EncryptedDocumentException, IOException {
		overviewPage.validateNumberOfBrokersZoomOutBtn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_204_validate_Broker_NumberOfBrokersGraph_XaxisValue() throws EncryptedDocumentException, IOException {
		overviewPage.validateBrokerNumberOfBrokersXaxisValues();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_205_validate_Broker_NumberOfBrokersGraph_XaxisTitle() throws EncryptedDocumentException, IOException {
		overviewPage.validateBrokerNumberOfBrokersGraphXaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Broker_NumberOfBrokers_Xaxis_Title"));
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_206_validate_Broker_NumberOfBrokers_Graph_YaxisTitle() throws EncryptedDocumentException, IOException {
		overviewPage.validateBrokerNumberOfBrokersGraphYaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Broker_NumberOfBrokers_Yaxis_Title"));
	}
}