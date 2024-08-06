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
import objectRepository.MQM.MQKafka_Broker_Page;
import playWrightFactory.BaseClass;

public class MQKafka_Broker_Test extends BaseClass
{
	GenericMethods util = new GenericMethods();
	CommonPage commonPage;
	MQKafka_Broker_Page brokerPage;
	ExcelUtility excel = new ExcelUtility();
	
	@BeforeMethod
	public void Broker() {
		commonPage = new CommonPage(page);
		brokerPage = new  MQKafka_Broker_Page(page);
		excel = new ExcelUtility();
		
		commonPage.navigateToMQM();
		brokerPage.navigateToKafka();
		commonPage.selectTheTimeLineFromCalender(IPathConstant.oneMonthTimeRange);
		brokerPage.selectServiceName();
		brokerPage.navigateToBrokerTab();
//		page.reload();
//		page.waitForTimeout(1000);
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_001_validate_Broker_Title() throws EncryptedDocumentException, IOException  {
		brokerPage.validateBrokerTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Broker, "Broker_Tab_Title"));
	}
	
/**
 * Topic Tab
 * @throws EncryptedDocumentException
 * @throws IOException
 */
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_002_validate_Topic_Tab_Title() throws EncryptedDocumentException, IOException {
		brokerPage.validateTopicTabTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Broker, "Topic_Tab_Title"));
	}
	
/********************************************************* Bytes In Per Second Graph ******************************************************************/
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_003_validate_Topic_BytesInPerSecondGraph_Title() throws EncryptedDocumentException, IOException {
		brokerPage.validateTopicBytesInPerSecondGraphTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Broker, "Topic_BytesInPerSecond_Graph_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_004_validate_Topic_BytesInPerSecondGraph_ZoomIn() throws EncryptedDocumentException, IOException {
		brokerPage.validateTopicBytesInPerSecondGraphZoomInBtn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_005_validate_Topic_BytesInPerSecondGraph_ZoomOut() throws EncryptedDocumentException, IOException {
		brokerPage.validateTopicBytesInPerSecondGraphZoomOutBtn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_006_validate_Topic_BytesInPerSecondGraph_XaxisValue() throws EncryptedDocumentException, IOException {
		//page.reload();
		page.waitForTimeout(5000);
		brokerPage.validateTopicBytesInPerSecondXaxisValues();
	}	
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_007_validate_Topic_BytesInPerSecondGraph_XaxisTitle() throws EncryptedDocumentException, IOException {
		brokerPage.validateTopicBytesInPerSecondGraphXaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Broker, "Topic_BytesInPerSecond_Xaxis_Title"));
	}	
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_008_validate_Topic_BytesInPerSecondGraph_YaxisTitle() throws EncryptedDocumentException, IOException {
		brokerPage.validateTopicBytesInPerSecondGraphYaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Broker, "Topic_BytesInPerSecond_Yaxis_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_009_validate_Topic_BytesInPerSecondGraph_BrokerHeaderTitle() throws EncryptedDocumentException, IOException {
		brokerPage.validateTopicBytesInPerSecondGraphTopicHeaderTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Broker, "Topic_BytesInPerSecond_Broker_Header_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_010_validate_Topic_BytesInPerSecondGraph_AvgHeaderTitle() throws EncryptedDocumentException, IOException {
		brokerPage.validateTopicBytesInPerSecondGraphAvgHeaderTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Broker, "Topic_BytesInPerSecond_Avg_Header_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_011_validate_Topic_BytesInPerSecondGraph_MaxHeaderTitle() throws EncryptedDocumentException, IOException {
		brokerPage.validateTopicBytesInPerSecondGraphMaxHeaderTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Broker, "Topic_BytesInPerSecond_Max_Header_Title"));
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_012_validate_Topic_BytesInPerSecondGraph_RowColor() throws EncryptedDocumentException, IOException {
		//page.reload();
		brokerPage.validateTopicBytesInPerSecondGraphRowColor(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Broker, "rgb(255, 123, 123)"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_013_validate_Topic_BytesInPerSecondGraph_ToolTip() throws EncryptedDocumentException, IOException {
		brokerPage.validateTopicBytesInPerSecondToolTipTitle();
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_014_validate_Topic_BytesInPerSecondGraph_ExpandViewXAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		brokerPage.validateTopicBytesInPerSecondExpandViewXAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_015_validate_Topic_BytesInPerSecondGraph_ExpandViewYAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		brokerPage.validateTopicBytesInPerSecondExpandViewYAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_016_validate_Topic_BytesInPerSecondGraph_ExpandViewWidgetTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		brokerPage.validateTopicBytesInPerSecondExpandViewWidgetTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_017_validate_Topic_BytesInPerSecondGraph_ExpandViewLegendHeader1() throws EncryptedDocumentException, IOException, InterruptedException {
		brokerPage.validateTopicBytesInPerSecondExpandViewLegendHeader1();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_018_validate_Topic_BytesInPerSecondGraph_ExpandViewLegendHeader2() throws EncryptedDocumentException, IOException, InterruptedException {
		brokerPage.validateTopicBytesInPerSecondExpandViewLegendHeader2();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_019_validate_Topic_BytesInPerSecondGraph_ExpandViewLegendHeader3() throws EncryptedDocumentException, IOException, InterruptedException {
		brokerPage.validateTopicBytesInPerSecondExpandViewLegendHeader3();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_020_validate_Topic_BytesInPerSecondGraph_ExpandViewZoomInBtn() throws EncryptedDocumentException, IOException, InterruptedException {
		brokerPage.validateTopicBytesInPerSecondExpandViewZoomIn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_021_validate_Topic_BytesInPerSecondGraph_ExpandViewZoomOutBtn() throws EncryptedDocumentException, IOException, InterruptedException {
		brokerPage.validateTopicBytesInPerSecondExpandViewZoomOut();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_022_validate_Topic_BytesInPerSecondGraph_ExpandViewWidgetDragDrop() throws EncryptedDocumentException, IOException, InterruptedException {
		//page.reload();
		page.waitForLoadState();
		//page.pause();
		//page.waitForTimeout(2000);
		
		brokerPage.validateTopicBytesInPerSecondExpandViewWidgetDragDrop();
		//page.reload();
	}	
		
/********************************************************* Bytes In Per Second Mean Value Graph ******************************************************************/
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_023_validate_Topic_BytesInPerSecondMeanValueGraph_Title() throws EncryptedDocumentException, IOException {
		brokerPage.validateTopicBytesInPerSecondMeanValueGraphTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Broker, "Topic_BytesInPerSecondMeanValue_Graph_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_024_validate_Topic_BytesOutPerSecondMeanValueGraph_ZoomIn() throws EncryptedDocumentException, IOException {
		brokerPage.validateTopicBytesOutPerSecondMeanValueGraphZoomInBtn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_025_validate_Topic_BytesOutPerSecondMeanValueGraph_ZoomOut() throws EncryptedDocumentException, IOException {
		brokerPage.validateTopicBytesOutPerSecondMeanValueGraphZoomOutBtn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_026_validate_Topic_BytesInPerSecondMeanValueGraph_XaxisValue() throws EncryptedDocumentException, IOException {
		page.waitForTimeout(5000);
		brokerPage.validateTopicBytesInPerSecondMeanValueXaxisValues();
	}	
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_027_validate_Topic_BytesInPerSecondMeanValueGraph_XaxisTitle() throws EncryptedDocumentException, IOException {
		brokerPage.validateTopicBytesInPerSecondMeanValueGraphXaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Broker, "Topic_BytesInPerSecondMeanValue_Xaxis_Title"));
	}	
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_028_validate_Topic_BytesInPerSecondMeanValueGraph_YaxisTitle() throws EncryptedDocumentException, IOException {
		brokerPage.validateTopicBytesInPerSecondMeanValueGraphYaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Broker, "Topic_BytesInPerSecondMeanValue_Yaxis_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_029_validate_Topic_BytesInPerSecondMeanValueGraph_TopicHeaderTitle() throws EncryptedDocumentException, IOException {
		brokerPage.validateTopicBytesInPerSecondMeanValueGraphTopicHeaderTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Broker, "Topic_BytesInPerSecondMeanValue_Broker_Header_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_030_validate_Topic_BytesInPerSecondMeanValueGraph_AvgHeaderTitle() throws EncryptedDocumentException, IOException {
		brokerPage.validateTopicBytesInPerSecondMeanValueGraphAvgHeaderTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Broker, "Topic_BytesInPerSecondMeanValue_Avg_Header_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_031_validate_Topic_BytesInPerSecondMeanValueGraph_MaxHeaderTitle() throws EncryptedDocumentException, IOException {
		brokerPage.validateTopicBytesInPerSecondMeanValueGraphMaxHeaderTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Broker, "Topic_BytesInPerSecondMeanValue_Max_Header_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_032_validate_Topic_BytesInPerSecondMeanValueGraph_RowColor() throws EncryptedDocumentException, IOException {
		brokerPage.validateTopicBytesInPerSecondMeanValueGraphRowColor(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Broker, "rgb(255, 123, 123)"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_033_validate_Topic_BytesInPerSecondMeanValueGraph_ToolTip() throws EncryptedDocumentException, IOException {
		brokerPage.validateTopicBytesInPerSecondMeanValueToolTipTitle();
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_034_validate_Topic_BytesInPerSecondMeanValueGraph_ExpandViewXAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		brokerPage.validateTopicBytesInPerSecondMeanValueExpandViewXAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_035_validate_Topic_BytesInPerSecondMeanValueGraph_ExpandViewYAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		brokerPage.validateTopicBytesInPerSecondMeanValueExpandViewYAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_036_validate_Topic_BytesInPerSecondMeanValueGraph_ExpandViewWidgetTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		brokerPage.validateTopicBytesInPerSecondMeanValueExpandViewWidgetTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_037_validate_Topic_BytesInPerSecondMeanValueGraph_ExpandViewLegendHeader1() throws EncryptedDocumentException, IOException, InterruptedException {
		brokerPage.validateTopicBytesInPerSecondMeanValueExpandViewLegendHeader1();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_038_validate_Topic_BytesInPerSecondMeanValueGraph_ExpandViewLegendHeader2() throws EncryptedDocumentException, IOException, InterruptedException {
		brokerPage.validateTopicBytesInPerSecondMeanValueExpandViewLegendHeader2();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_039_validate_Topic_BytesInPerSecondMeanValueGraph_ExpandViewLegendHeader3() throws EncryptedDocumentException, IOException, InterruptedException {
		brokerPage.validateTopicBytesInPerSecondMeanValueExpandViewLegendHeader3();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_040_validate_Topic_BytesInPerSecondMeanValueGraph_ExpandViewZoomInBtn() throws EncryptedDocumentException, IOException, InterruptedException {
		brokerPage.validateTopicBytesInPerSecondMeanValueExpandViewZoomIn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_041_validate_Topic_BytesInPerSecondMeanValueGraph_ExpandViewZoomOutBtn() throws EncryptedDocumentException, IOException, InterruptedException {
		brokerPage.validateTopicBytesInPerSecondMeanValueExpandViewZoomOut();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_042_validate_Topic_BytesInPerSecondMeanValueGraph_ExpandViewWidgetDragDrop() throws EncryptedDocumentException, IOException, InterruptedException {
		brokerPage.validateTopicBytesInPerSecondMeanValueExpandViewWidgetDragDrop();
	}	
	
	/********************************************************* Bytes Out Per Second Graph ******************************************************************/
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_043_validate_Topic_BytesOutPerSecondGraph_Title() throws EncryptedDocumentException, IOException {
		brokerPage.validateTopicBytesOutPerSecondGraphTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Broker, "Topic_BytesOutPerSecond_Graph_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_044_validate_Topic_BytesOutPerSecondGraph_ZoomIn() throws EncryptedDocumentException, IOException {
		brokerPage.validateTopicBytesOutPerSecondGraphZoomInBtn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_045_validate_Topic_BytesOutPerSecondGraph_ZoomOut() throws EncryptedDocumentException, IOException {
//page.reload();
		brokerPage.validateTopicBytesOutPerSecondGraphZoomOutBtn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_046_validate_Topic_BytesOutPerSecondGraph_XaxisValue() throws EncryptedDocumentException, IOException {
		page.waitForTimeout(5000);
		brokerPage.validateTopicBytesOutPerSecondXaxisValues();
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_047_validate_Topic_BytesOutPerSecondGraph_XaxisTitle() throws EncryptedDocumentException, IOException {
		brokerPage.validateTopicBytesOutPerSecondGraphXaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Broker, "Topic_BytesOutPerSecond_Xaxis_Title"));
	}	
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_048_validate_Topic_BytesOutPerSecondGraph_YaxisTitle() throws EncryptedDocumentException, IOException {
		brokerPage.validateTopicBytesOutPerSecondGraphYaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Broker, "Topic_BytesOutPerSecond_Yaxis_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_049_validate_Topic_BytesOutPerSecondGraph_BrokerHeaderTitle() throws EncryptedDocumentException, IOException {
		brokerPage.validateTopicBytesOutPerSecondGraphTopicHeaderTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Broker, "Topic_BytesOutPerSecond_Broker_Header_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_050_validate_Topic_BytesOutPerSecondGraph_AvgHeaderTitle() throws EncryptedDocumentException, IOException {
		brokerPage.validateTopicBytesOutPerSecondGraphAvgHeaderTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Broker, "Topic_BytesOutPerSecond_Avg_Header_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_051_validate_Topic_BytesOutPerSecondGraph_MaxHeaderTitle() throws EncryptedDocumentException, IOException {
		brokerPage.validateTopicBytesOutPerSecondGraphMaxHeaderTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Broker, "Topic_BytesOutPerSecond_Max_Header_Title"));
	}	
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_052_validate_Topic_BytesOutPerSecondGraph_RowColor() throws EncryptedDocumentException, IOException {
		brokerPage.validateTopicBytesOutPerSecondGraphRowColor(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Broker, "rgb(255, 123, 123)"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_053_validate_Topic_BytesOutPerSecondGraph_ToolTip() throws EncryptedDocumentException, IOException {
		brokerPage.validateTopicBytesOutPerSecondToolTipTitle();
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_054_validate_Topic_BytesOutPerSecondGraph_ExpandViewXAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		brokerPage.validateTopicBytesOutPerSecondExpandViewXAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_055_validate_Topic_BytesOutPerSecondGraph_ExpandViewYAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		brokerPage.validateTopicBytesOutPerSecondExpandViewYAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_056_validate_Topic_BytesOutPerSecondGraph_ExpandViewWidgetTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		brokerPage.validateTopicBytesOutPerSecondExpandViewWidgetTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_057_validate_Topic_BytesOutPerSecondGraph_ExpandViewLegendHeader1() throws EncryptedDocumentException, IOException, InterruptedException {
		brokerPage.validateTopicBytesOutPerSecondExpandViewLegendHeader1();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_058_validate_Topic_BytesOutPerSecondGraph_ExpandViewLegendHeader2() throws EncryptedDocumentException, IOException, InterruptedException {
		brokerPage.validateTopicBytesOutPerSecondExpandViewLegendHeader2();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_059_validate_Topic_BytesOutPerSecondGraph_ExpandViewLegendHeader3() throws EncryptedDocumentException, IOException, InterruptedException {
		brokerPage.validateTopicBytesOutPerSecondExpandViewLegendHeader3();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_060_validate_Topic_BytesOutPerSecondGraph_ExpandViewZoomInBtn() throws EncryptedDocumentException, IOException, InterruptedException {
		brokerPage.validateTopicBytesOutPerSecondExpandViewZoomIn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_061_validate_Topic_BytesOutPerSecondGraph_ExpandViewZoomOutBtn() throws EncryptedDocumentException, IOException, InterruptedException {
		brokerPage.validateTopicBytesOutPerSecondExpandViewZoomOut();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_062_validate_Topic_BytesOutPerSecondGraph_ExpandViewWidgetDragDrop() throws EncryptedDocumentException, IOException, InterruptedException {
		brokerPage.validateTopicBytesOutPerSecondExpandViewWidgetDragDrop();
	}		
/********************************************************* Bytes Out Per Second Mean Value Graph ******************************************************************/
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_063_validate_Topic_BytesOutPerSecondMeanValueGraph_Title() throws EncryptedDocumentException, IOException {
		page.waitForTimeout(5000);
		brokerPage.validateTopicBytesOutPerSecondMeanValueGraphTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Broker, "Topic_BytesOutPerSecondMeanValue_Graph_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_064_validate_Topic_BytesOutPerSecondMeanValueGraph_ZoomIn() throws EncryptedDocumentException, IOException {
		brokerPage.validateTopicBytesOutPerSecondMeanValueGraphZoomInBtn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_065_validate_Topic_BytesOutPerSecondMeanValueGraph_ZoomOut() throws EncryptedDocumentException, IOException {
		brokerPage.validateTopicBytesOutPerSecondMeanValueGraphZoomOutBtn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_066_validate_Topic_BytesOutPerSecondMeanValueGraph_XaxisValue() throws EncryptedDocumentException, IOException {
		page.waitForTimeout(5000);
		brokerPage.validateTopicBytesOutPerSecondMeanValueXaxisValues();
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_067_validate_Topic_BytesOutPerSecondMeanValueGraph_XaxisTitle() throws EncryptedDocumentException, IOException {
		brokerPage.validateTopicBytesOutPerSecondMeanValueGraphXaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Broker, "Topic_BytesOutPerSecondMeanValue_Xaxis_Title"));
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_068_validate_Topic_BytesOutPerSecondMeanValueGraph_YaxisTitle() throws EncryptedDocumentException, IOException {
		brokerPage.validateTopicBytesOutPerSecondMeanValueGraphYaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Broker, "Topic_BytesOutPerSecondMeanValue_Yaxis_Title"));
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_069_validate_Topic_BytesOutPerSecondMeanValueGraph_TopicHeaderTitle() throws EncryptedDocumentException, IOException {
		brokerPage.validateTopicBytesOutPerSecondMeanValueGraphTopicHeaderTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Broker, "Topic_BytesOutPerSecondMeanValue_Broker_Header_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_070_validate_Topic_BytesOutPerSecondMeanValueGraph_AvgHeaderTitle() throws EncryptedDocumentException, IOException {
		brokerPage.validateTopicBytesOutPerSecondMeanValueGraphAvgHeaderTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Broker, "Topic_BytesOutPerSecondMeanValue_Avg_Header_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_071_validate_Topic_BytesOutPerSecondMeanValueGraph_MaxHeaderTitle() throws EncryptedDocumentException, IOException {
		brokerPage.validateTopicBytesOutPerSecondMeanValueGraphMaxHeaderTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Broker, "Topic_BytesOutPerSecondMeanValue_Max_Header_Title"));
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_072_validate_Topic_BytesOutPerSecondMeanValueGraph_RowColor() throws EncryptedDocumentException, IOException {
		brokerPage.validateTopicBytesOutPerSecondMeanValueGraphRowColor(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Broker, "rgb(255, 123, 123)"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_073_validate_Topic_BytesOutPerSecondMeanValueGraph_ToolTip() throws EncryptedDocumentException, IOException {
		brokerPage.validateTopicBytesOutPerSecondMeanValueToolTipTitle();
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_074_validate_Topic_BytesOutPerSecondMeanValueGraph_ExpandViewXAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		brokerPage.validateTopicBytesOutPerSecondMeanValueExpandViewXAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_075_validate_Topic_BytesOutPerSecondMeanValueGraph_ExpandViewYAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		brokerPage.validateTopicBytesOutPerSecondMeanValueExpandViewYAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_076_validate_Topic_BytesOutPerSecondMeanValueGraph_ExpandViewWidgetTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		brokerPage.validateTopicBytesOutPerSecondMeanValueExpandViewWidgetTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_077_validate_Topic_BytesOutPerSecondMeanValueGraph_ExpandViewLegendHeader1() throws EncryptedDocumentException, IOException, InterruptedException {
		brokerPage.validateTopicBytesOutPerSecondMeanValueExpandViewLegendHeader1();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_078_validate_Topic_BytesOutPerSecondMeanValueGraph_ExpandViewLegendHeader2() throws EncryptedDocumentException, IOException, InterruptedException {
		brokerPage.validateTopicBytesOutPerSecondMeanValueExpandViewLegendHeader2();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_079_validate_Topic_BytesOutPerSecondMeanValueGraph_ExpandViewLegendHeader3() throws EncryptedDocumentException, IOException, InterruptedException {
		brokerPage.validateTopicBytesOutPerSecondMeanValueExpandViewLegendHeader3();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_080_validate_Topic_BytesOutPerSecondMeanValueGraph_ExpandViewZoomInBtn() throws EncryptedDocumentException, IOException, InterruptedException {
		brokerPage.validateTopicBytesOutPerSecondMeanValueExpandViewZoomIn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_081_validate_Topic_BytesOutPerSecondMeanValueGraph_ExpandViewZoomOutBtn() throws EncryptedDocumentException, IOException, InterruptedException {
		brokerPage.validateTopicBytesOutPerSecondMeanValueExpandViewZoomOut();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_082_validate_Topic_BytesOutPerSecondMeanValueGraph_ExpandViewWidgetDragDrop() throws EncryptedDocumentException, IOException, InterruptedException {
		brokerPage.validateTopicBytesOutPerSecondMeanValueExpandViewWidgetDragDrop();
	}	
	/********************************************************* Message Count Graph ******************************************************************/
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_083_validate_Topic_MessageCountGraph_Title() throws EncryptedDocumentException, IOException {
		brokerPage.validateTopicMessageCountGraphTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Broker, "Topic_MessageCount_Graph_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_084_validate_Topic_MessageCountGraph_ZoomIn() throws EncryptedDocumentException, IOException {
		brokerPage.validateTopicMessageCountGraphZoomInBtn();;
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_085_validate_Topic_MessageCountGraph_ZoomOut() throws EncryptedDocumentException, IOException {
		brokerPage.validateTopicMessageCountGraphZoomOutBtn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_086_validate_Topic_MessageCountGraph_XaxisValue() throws EncryptedDocumentException, IOException {
		page.waitForTimeout(5000);
		brokerPage.validateTopicMessageCountXaxisValues();
	}	
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_087_validate_Topic_MessageCountGraph_XaxisTitle() throws EncryptedDocumentException, IOException {
		brokerPage.validateTopicMessageCountGraphXaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Broker, "Topic_MessageCount_Xaxis_Title"));
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_088_validate_Topic_MessageCountGraph_YaxisTitle() throws EncryptedDocumentException, IOException {
		brokerPage.validateTopicMessageCountGraphYaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Broker, "Topic_MessageCount_Yaxis_Title"));
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_089_validate_Topic_MessageCountGraph_TopicHeaderTitle() throws EncryptedDocumentException, IOException {
		brokerPage.validateTopicMessageCountGraphTopicHeaderTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Broker, "Topic_MessageCount_Broker_Header_Title"));
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_090_validate_Topic_MessageCountGraph_AvgHeaderTitle() throws EncryptedDocumentException, IOException {
		brokerPage.validateTopicMessageCountGraphAvgHeaderTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Broker, "Topic_MessageCount_Avg_Header_Title"));
	}	
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_091_validate_Topic_MessageCountGraph_MaxHeaderTitle() throws EncryptedDocumentException, IOException {
		brokerPage.validateTopicMessageCountGraphMaxHeaderTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Broker, "Topic_MessageCount_Max_Header_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_092_validate_Topic_MessageCountGraph_RowColor() throws EncryptedDocumentException, IOException {
		brokerPage.validateTopicMessageCountGraphRowColor(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Broker, "rgb(255, 123, 123)"));
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_093_validate_Topic_MessageCountGraph_ToolTip() throws EncryptedDocumentException, IOException {
		brokerPage.validateTopicMessageCountToolTipTitle();
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_094_validate_Topic_MessageCountGraph_ExpandViewXAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		brokerPage.validateTopicMessageCountExpandViewXAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_095_validate_Topic_MessageCountGraph_ExpandViewYAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		brokerPage.validateTopicMessageCountExpandViewYAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_096_validate_Topic_MessageCountGraph_ExpandViewWidgetTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		brokerPage.validateTopicMessageCountExpandViewWidgetTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_097_validate_Topic_MessageCountGraph_ExpandViewLegendHeader1() throws EncryptedDocumentException, IOException, InterruptedException {
		brokerPage.validateTopicMessageCountExpandViewLegendHeader1();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_098_validate_Topic_MessageCountGraph_ExpandViewLegendHeader2() throws EncryptedDocumentException, IOException, InterruptedException {
		brokerPage.validateTopicMessageCountExpandViewLegendHeader2();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_099_validate_Topic_MessageCountGraph_ExpandViewLegendHeader3() throws EncryptedDocumentException, IOException, InterruptedException {
		brokerPage.validateTopicMessageCountExpandViewLegendHeader3();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_100_validate_Topic_MessageCountGraph_ExpandViewZoomInBtn() throws EncryptedDocumentException, IOException, InterruptedException {
		brokerPage.validateTopicMessageCountExpandViewZoomIn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_101_validate_Topic_MessageCountGraph_ExpandViewZoomOutBtn() throws EncryptedDocumentException, IOException, InterruptedException {
		brokerPage.validateTopicMessageCountExpandViewZoomOut();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_102_validate_Topic_MessageCountGraph_ExpandViewWidgetDragDrop() throws EncryptedDocumentException, IOException, InterruptedException {
		brokerPage.validateTopicMessageCountExpandViewWidgetDragDrop();
	}	
	
/**
 * Broker Metrics Tab
 * @throws EncryptedDocumentException
 * @throws IOException
 */
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_103_validate_BrokerMetrics_Tab_Title() throws EncryptedDocumentException, IOException {
		brokerPage.validateBrokerMetricsTabTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Broker, "BrokerMetrics_Tab_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_104_click_on_BrokerMetrics_Tab() throws EncryptedDocumentException, IOException {
		brokerPage.clickOnBrokerMetricsTab();
	}
/********************************************************* JVM CPU Graph ******************************************************************/
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_105_validate_BrokerMetrics_JVMCPUGraph_Title() throws EncryptedDocumentException, IOException {
		//page.reload();
		brokerPage.clickOnBrokerMetricsTab();
		brokerPage.validateBrokerMetricsJVMCPUGraphTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Broker, "BrokerMetrics_JVMCPU_Graph_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_106_validate_BrokerMetrics_JVMCPUGraph_ZoomIn() throws EncryptedDocumentException, IOException {
		//page.reload();
		brokerPage.clickOnBrokerMetricsTab();
		brokerPage.validateBrokerMetricsJVMCPUGraphZoomInBtn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_107_validate_BrokerMetrics_JVMCPUGraph_ZoomOut() throws EncryptedDocumentException, IOException {
		//page.reload();
		brokerPage.clickOnBrokerMetricsTab();
		brokerPage.validateBrokerMetricsJVMCPUGraphZoomOutBtn();
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_108_validate_BrokerMetrics_JVMCPUGraph_XaxisValue() throws EncryptedDocumentException, IOException {
		//page.reload();
		brokerPage.clickOnBrokerMetricsTab();
		brokerPage.validateBrokerMetricsJVMCPUXaxisValues();
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_109_validate_BrokerMetrics_JVMCPUGraph_XaxisTitle() throws EncryptedDocumentException, IOException {
		//page.reload();
		brokerPage.clickOnBrokerMetricsTab();
		brokerPage.validateBrokerMetricsJVMCPUGraphXaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Broker, "BrokerMetrics_JVMCPU_Xaxis_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_110_validate_BrokerMetrics_JVMCPUGraph_YaxisTitle() throws EncryptedDocumentException, IOException {
		//page.reload();
		brokerPage.clickOnBrokerMetricsTab();
		brokerPage.validateBrokerMetricsJVMCPUGraphYaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Broker, "BrokerMetrics_JVMCPU_Yaxis_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_111_validate_BrokerMetrics_JVMCPUGraph_BrokerHeaderTitle() throws EncryptedDocumentException, IOException {
		//page.reload();
		brokerPage.clickOnBrokerMetricsTab();
		brokerPage.validateBrokerMetricsJVMCPUGraphBrokerMetricsHeaderTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Broker, "BrokerMetrics_JVMCPU_Broker_Header_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_112_validate_BrokerMetrics_JVMCPUGraph_AvgHeaderTitle() throws EncryptedDocumentException, IOException {
		//page.reload();
		brokerPage.clickOnBrokerMetricsTab();
		brokerPage.validateBrokerMetricsJVMCPUGraphAvgHeaderTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Broker, "BrokerMetrics_JVMCPU_Avg_Header_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_113_validate_BrokerMetrics_JVMCPUGraph_MaxHeaderTitle() throws EncryptedDocumentException, IOException {
		//page.reload();
		brokerPage.clickOnBrokerMetricsTab();
		brokerPage.validateBrokerMetricsJVMCPUGraphMaxHeaderTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Broker, "BrokerMetrics_JVMCPU_Max_Header_Title"));
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_114_validate_BrokerMetrics_JVMCPUGraph_RowColor() throws EncryptedDocumentException, IOException {
		//page.reload();
		brokerPage.clickOnBrokerMetricsTab();
		brokerPage.validateBrokerMetricsJVMCPUGraphRowColor(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Broker, "rgb(255, 123, 123)"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_115_validate_BrokerMetrics_JVMCPUGraph_ToolTip() throws EncryptedDocumentException, IOException {
		//page.reload();
		brokerPage.clickOnBrokerMetricsTab();
		brokerPage.validateBrokerMetricsJVMCPUToolTipTitle();
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_116_validate_BrokerMetrics_JVMCPUGraph_ExpandViewXAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		//page.reload();
		brokerPage.clickOnBrokerMetricsTab();
		brokerPage.validateBrokerMetricsJVMCPUExpandViewXAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_117_validate_BrokerMetrics_JVMCPUGraph_ExpandViewYAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		//page.reload();
		brokerPage.clickOnBrokerMetricsTab();
		brokerPage.validateBrokerMetricsJVMCPUExpandViewYAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_118_validate_BrokerMetrics_JVMCPUGraph_ExpandViewWidgetTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		//page.reload();
		brokerPage.clickOnBrokerMetricsTab();
		brokerPage.validateBrokerMetricsJVMCPUExpandViewWidgetTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_119_validate_BrokerMetrics_JVMCPUGraph_ExpandViewLegendHeader1() throws EncryptedDocumentException, IOException, InterruptedException {
		//page.reload();
		brokerPage.clickOnBrokerMetricsTab();
		brokerPage.validateBrokerMetricsJVMCPUExpandViewLegendHeader1();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_120_validate_BrokerMetrics_JVMCPUGraph_ExpandViewLegendHeader2() throws EncryptedDocumentException, IOException, InterruptedException {
		//page.reload();
		brokerPage.clickOnBrokerMetricsTab();
		brokerPage.validateBrokerMetricsJVMCPUExpandViewLegendHeader2();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_121_validate_BrokerMetrics_JVMCPUGraph_ExpandViewLegendHeader3() throws EncryptedDocumentException, IOException, InterruptedException {
		//page.reload();
		brokerPage.clickOnBrokerMetricsTab();
		brokerPage.validateBrokerMetricsJVMCPUExpandViewLegendHeader3();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_122_validate_BrokerMetrics_JVMCPUGraph_ExpandViewZoomInBtn() throws EncryptedDocumentException, IOException, InterruptedException {
		//page.reload();
		brokerPage.clickOnBrokerMetricsTab();
		brokerPage.validateBrokerMetricsJVMCPUExpandViewZoomIn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_123_validate_BrokerMetrics_JVMCPUGraph_ExpandViewZoomOutBtn() throws EncryptedDocumentException, IOException, InterruptedException {
		//page.reload();
		brokerPage.clickOnBrokerMetricsTab();
		brokerPage.validateBrokerMetricsJVMCPUExpandViewZoomOut();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_124_validate_BrokerMetrics_JVMCPUGraph_ExpandViewWidgetDragDrop() throws EncryptedDocumentException, IOException, InterruptedException {
		//page.reload();
		brokerPage.clickOnBrokerMetricsTab();
		brokerPage.validateBrokerMetricsJVMCPUExpandViewWidgetDragDrop();
	}		
/********************************************************* JVM Memory Graph ******************************************************************/
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_125_validate_BrokerMetrics_JVMMemoryGraph_Title() throws EncryptedDocumentException, IOException {
		//page.reload();
		brokerPage.clickOnBrokerMetricsTab();
		brokerPage.validateBrokerMetricsJVMMemoryGraphTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Broker, "BrokerMetrics_JVMMemory_Graph_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_126_validate_BrokerMetrics_JVMMemoryGraph_ZoomIn() throws EncryptedDocumentException, IOException {
		//page.reload();
		//page.pause();
		brokerPage.clickOnBrokerMetricsTab();
		brokerPage.validateBrokerMetricsJVMMemoryGraphZoomInBtn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_127_validate_BrokerMetrics_JVMMemoryGraph_ZoomOut() throws EncryptedDocumentException, IOException {
		//page.reload();
		brokerPage.clickOnBrokerMetricsTab();
		brokerPage.validateBrokerMetricsJVMMemoryGraphZoomOutBtn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_128_validate_BrokerMetrics_JVMMemoryGraph_XaxisValue() throws EncryptedDocumentException, IOException {
		//page.reload();
		brokerPage.clickOnBrokerMetricsTab();
		brokerPage.validateBrokerMetricsJVMMemoryXaxisValues();
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_129_validate_BrokerMetrics_JVMMemoryGraph_XaxisTitle() throws EncryptedDocumentException, IOException {
		//page.reload();
		brokerPage.clickOnBrokerMetricsTab();
		brokerPage.validateBrokerMetricsJVMMemoryGraphXaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Broker, "BrokerMetrics_JVMMemory_Xaxis_Title"));
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_130_validate_BrokerMetrics_JVMMemoryGraph_YaxisTitle() throws EncryptedDocumentException, IOException {
		//page.reload();
		brokerPage.clickOnBrokerMetricsTab();
		brokerPage.validateBrokerMetricsJVMMemoryGraphYaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Broker, "BrokerMetrics_JVMMemory_Yaxis_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_131_validate_BrokerMetrics_JVMMemoryGraph_BrokerMetricsHeaderTitle() throws EncryptedDocumentException, IOException {
		//page.reload();
		brokerPage.clickOnBrokerMetricsTab();
		brokerPage.validateBrokerMetricsJVMMemoryGraphBrokerMetricsHeaderTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Broker, "BrokerMetrics_JVMMemory_Broker_Header_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_132_validate_BrokerMetrics_JVMMemoryGraph_AvgHeaderTitle() throws EncryptedDocumentException, IOException {
		//page.reload();
		brokerPage.clickOnBrokerMetricsTab();
		brokerPage.validateBrokerMetricsJVMMemoryGraphAvgHeaderTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Broker, "BrokerMetrics_JVMMemory_Avg_Header_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_133_validate_BrokerMetrics_JVMMemoryGraph_MaxHeaderTitle() throws EncryptedDocumentException, IOException {
		//page.reload();
		brokerPage.clickOnBrokerMetricsTab();
		brokerPage.validateBrokerMetricsJVMMemoryGraphMaxHeaderTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Broker, "BrokerMetrics_JVMMemory_Max_Header_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_134_validate_BrokerMetrics_JVMMemoryGraph_RowColor() throws EncryptedDocumentException, IOException {
		//page.reload();
		brokerPage.clickOnBrokerMetricsTab();
		brokerPage.validateBrokerMetricsJVMMemoryGraphRowColor(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Broker, "rgb(255, 123, 123)"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_135_validate_BrokerMetrics_JVMMemoryGraph_ToolTip() throws EncryptedDocumentException, IOException {
		//page.reload();
		brokerPage.clickOnBrokerMetricsTab();
		brokerPage.validateBrokerMetricsJVMMemoryToolTipTitle();
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_136_validate_BrokerMetrics_JVMMemoryGraph_ExpandViewXAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		//page.reload();
		brokerPage.clickOnBrokerMetricsTab();
		brokerPage.validateBrokerMetricsJVMMemoryExpandViewXAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_137_validate_BrokerMetrics_JVMMemoryGraph_ExpandViewYAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		//page.reload();
		brokerPage.clickOnBrokerMetricsTab();
		brokerPage.validateBrokerMetricsJVMMemoryExpandViewYAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_138_validate_BrokerMetrics_JVMMemoryGraph_ExpandViewWidgetTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		//page.reload();
		brokerPage.clickOnBrokerMetricsTab();
		brokerPage.validateBrokerMetricsJVMMemoryExpandViewWidgetTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_139_validate_BrokerMetrics_JVMMemoryGraph_ExpandViewLegendHeader1() throws EncryptedDocumentException, IOException, InterruptedException {
		//page.reload();
		brokerPage.clickOnBrokerMetricsTab();
		brokerPage.validateBrokerMetricsJVMMemoryExpandViewLegendHeader1();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_140_validate_BrokerMetrics_JVMMemoryGraph_ExpandViewLegendHeader2() throws EncryptedDocumentException, IOException, InterruptedException {
		//page.reload();
		brokerPage.clickOnBrokerMetricsTab();
		brokerPage.validateBrokerMetricsJVMMemoryExpandViewLegendHeader2();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_141_validate_BrokerMetrics_JVMMemoryGraph_ExpandViewLegendHeader3() throws EncryptedDocumentException, IOException, InterruptedException {
		//page.reload();
		brokerPage.clickOnBrokerMetricsTab();
		brokerPage.validateBrokerMetricsJVMMemoryExpandViewLegendHeader3();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_142_validate_BrokerMetrics_JVMMemoryGraph_ExpandViewZoomInBtn() throws EncryptedDocumentException, IOException, InterruptedException {
		//page.reload();
		brokerPage.clickOnBrokerMetricsTab();
		brokerPage.validateBrokerMetricsJVMMemoryExpandViewZoomIn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_143_validate_BrokerMetrics_JVMMemoryGraph_ExpandViewZoomOutBtn() throws EncryptedDocumentException, IOException, InterruptedException {
		//page.reload();
		brokerPage.clickOnBrokerMetricsTab();
		brokerPage.validateBrokerMetricsJVMMemoryExpandViewZoomOut();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_144_validate_BrokerMetrics_JVMMemoryGraph_ExpandViewWidgetDragDrop() throws EncryptedDocumentException, IOException, InterruptedException {
		//page.reload();
		brokerPage.clickOnBrokerMetricsTab();
		brokerPage.validateBrokerMetricsJVMMemoryExpandViewWidgetDragDrop();
	}		
	
	/********************************************************* GC Time Graph ******************************************************************/
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_145_validate_BrokerMetrics_GCTimeGraph_Title() throws EncryptedDocumentException, IOException {
		//page.reload();
		brokerPage.clickOnBrokerMetricsTab();
		brokerPage.validateBrokerMetricsGCTimeGraphTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Broker, "BrokerMetrics_GCTime_Graph_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_146_validate_BrokerMetrics_GCTimeGraph_ZoomIn() throws EncryptedDocumentException, IOException {
		//page.reload();
		brokerPage.clickOnBrokerMetricsTab();
		brokerPage.validateBrokerMetricsGCTimeGraphZoomInBtn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_147_validate_BrokerMetrics_GCTimeGraph_ZoomOut() throws EncryptedDocumentException, IOException {
		//page.reload();
		brokerPage.clickOnBrokerMetricsTab();
		brokerPage.validateBrokerMetricsGCTimeGraphZoomOutBtn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_148_validate_BrokerMetrics_GCTimeGraph_XaxisValue() throws EncryptedDocumentException, IOException {
		//page.reload();
		brokerPage.clickOnBrokerMetricsTab();
		brokerPage.validateBrokerMetricsGCTimeXaxisValues();
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_149_validate_BrokerMetrics_GCTimeGraph_XaxisTitle() throws EncryptedDocumentException, IOException {
		//page.reload();
		brokerPage.clickOnBrokerMetricsTab();
		brokerPage.validateBrokerMetricsGCTimeGraphXaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Broker, "BrokerMetrics_GCTime_Xaxis_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_150_validate_BrokerMetrics_GCTimeGraph_YaxisTitle() throws EncryptedDocumentException, IOException {
		//page.reload();
		brokerPage.clickOnBrokerMetricsTab();
		brokerPage.validateBrokerMetricsGCTimeGraphYaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Broker, "BrokerMetrics_GCTime_Yaxis_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_151_validate_BrokerMetrics_GCTimeGraph_BrokerHeaderTitle() throws EncryptedDocumentException, IOException {
		//page.reload();
		brokerPage.clickOnBrokerMetricsTab();
		brokerPage.validateBrokerMetricsGCTimeGraphBrokerMetricsHeaderTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Broker, "BrokerMetrics_GCTime_Broker_Header_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_152_validate_BrokerMetrics_GCTimeGraph_AvgHeaderTitle() throws EncryptedDocumentException, IOException {
		//page.reload();
		brokerPage.clickOnBrokerMetricsTab();
		brokerPage.validateBrokerMetricsGCTimeGraphAvgHeaderTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Broker, "BrokerMetrics_GCTime_Avg_Header_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_153_validate_BrokerMetrics_GCTimeGraph_MaxHeaderTitle() throws EncryptedDocumentException, IOException {
		//page.reload();
		brokerPage.clickOnBrokerMetricsTab();
		brokerPage.validateBrokerMetricsGCTimeGraphMaxHeaderTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Broker, "BrokerMetrics_GCTime_Max_Header_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_154_validate_BrokerMetrics_GCTimeGraph_RowColor() throws EncryptedDocumentException, IOException {
		//page.reload();
		brokerPage.clickOnBrokerMetricsTab();
		brokerPage.validateBrokerMetricsGCTimeGraphRowColor(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Broker, "rgb(255, 123, 123)"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_155_validate_BrokerMetrics_GCTimeGraph_ToolTip() throws EncryptedDocumentException, IOException {
		//page.reload();
		brokerPage.clickOnBrokerMetricsTab();
		brokerPage.validateBrokerMetricsGCTimeToolTipTitle();
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_156_validate_BrokerMetrics_GCTimeGraph_ExpandViewXAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		//page.reload();
		brokerPage.clickOnBrokerMetricsTab();
		brokerPage.validateBrokerMetricsGCTimeExpandViewXAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_157_validate_BrokerMetrics_GCTimeGraph_ExpandViewYAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		//page.reload();
		brokerPage.clickOnBrokerMetricsTab();
		brokerPage.validateBrokerMetricsGCTimeExpandViewYAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_158_validate_BrokerMetrics_GCTimeGraph_ExpandViewWidgetTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		//page.reload();
		brokerPage.clickOnBrokerMetricsTab();
		brokerPage.validateBrokerMetricsGCTimeExpandViewWidgetTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_159_validate_BrokerMetrics_GCTimeGraph_ExpandViewLegendHeader1() throws EncryptedDocumentException, IOException, InterruptedException {
		//page.reload();
		brokerPage.clickOnBrokerMetricsTab();
		brokerPage.validateBrokerMetricsGCTimeExpandViewLegendHeader1();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_160_validate_BrokerMetrics_GCTimeGraph_ExpandViewLegendHeader2() throws EncryptedDocumentException, IOException, InterruptedException {
		//page.reload();
		brokerPage.clickOnBrokerMetricsTab();
		brokerPage.validateBrokerMetricsGCTimeExpandViewLegendHeader2();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_161_validate_BrokerMetrics_GCTimeGraph_ExpandViewLegendHeader3() throws EncryptedDocumentException, IOException, InterruptedException {
		//page.reload();
		brokerPage.clickOnBrokerMetricsTab();
		brokerPage.validateBrokerMetricsGCTimeExpandViewLegendHeader3();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_162_validate_BrokerMetrics_GCTimeGraph_ExpandViewZoomInBtn() throws EncryptedDocumentException, IOException, InterruptedException {
		//page.reload();
		brokerPage.clickOnBrokerMetricsTab();
		brokerPage.validateBrokerMetricsGCTimeExpandViewZoomIn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_163_validate_BrokerMetrics_GCTimeGraph_ExpandViewZoomOutBtn() throws EncryptedDocumentException, IOException, InterruptedException {
		//page.reload();
		brokerPage.clickOnBrokerMetricsTab();
		brokerPage.validateBrokerMetricsGCTimeExpandViewZoomOut();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_164_validate_BrokerMetrics_GCTimeGraph_ExpandViewWidgetDragDrop() throws EncryptedDocumentException, IOException, InterruptedException {
		//page.reload();
		brokerPage.clickOnBrokerMetricsTab();
		brokerPage.validateBrokerMetricsGCTimeExpandViewWidgetDragDrop();
	}			
/********************************************************* GC Count Graph ******************************************************************/
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_165_validate_BrokerMetrics_GCCountGraph_Title() throws EncryptedDocumentException, IOException {
		//page.reload();
		brokerPage.clickOnBrokerMetricsTab();
		brokerPage.validateBrokerMetricsGCCountGraphTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Broker, "BrokerMetrics_GCCount_Graph_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_166_validate_BrokerMetrics_GCCountGraph_ZoomIn() throws EncryptedDocumentException, IOException {
		//page.reload();
		brokerPage.clickOnBrokerMetricsTab();
		brokerPage.validateBrokerMetricsGCCountGraphZoomInBtn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_167_validate_BrokerMetrics_GCCountGraph_ZoomOut() throws EncryptedDocumentException, IOException {
		//page.reload();
		brokerPage.clickOnBrokerMetricsTab();
		brokerPage.validateBrokerMetricsGCCountGraphZoomOutBtn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_168_validate_BrokerMetrics_GCCountGraph_XaxisValue() throws EncryptedDocumentException, IOException {
		//page.reload();
		brokerPage.clickOnBrokerMetricsTab();
		brokerPage.validateBrokerMetricsGCCountXaxisValues();
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_169_validate_BrokerMetrics_GCCountGraph_XaxisTitle() throws EncryptedDocumentException, IOException {
		//page.reload();
		brokerPage.clickOnBrokerMetricsTab();
		brokerPage.validateBrokerMetricsGCCountGraphXaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Broker, "BrokerMetrics_GCCount_Xaxis_Title"));
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_170_validate_BrokerMetrics_GCCountGraph_YaxisTitle() throws EncryptedDocumentException, IOException {
		//page.reload();
		brokerPage.clickOnBrokerMetricsTab();
		brokerPage.validateBrokerMetricsGCCountGraphYaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Broker, "BrokerMetrics_GCCount_Yaxis_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_171_validate_BrokerMetrics_GCCountGraph_BrokerMetricsHeaderTitle() throws EncryptedDocumentException, IOException {
		//page.reload();
		brokerPage.clickOnBrokerMetricsTab();
		brokerPage.validateBrokerMetricsGCCountGraphBrokerMetricsHeaderTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Broker, "BrokerMetrics_GCCount_Broker_Header_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_172_validate_BrokerMetrics_GCCountGraph_AvgHeaderTitle() throws EncryptedDocumentException, IOException {
		//page.reload();
		brokerPage.clickOnBrokerMetricsTab();
		brokerPage.validateBrokerMetricsGCCountGraphAvgHeaderTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Broker, "BrokerMetrics_GCCount_Avg_Header_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_173_validate_BrokerMetrics_GCCountGraph_MaxHeaderTitle() throws EncryptedDocumentException, IOException {
		//page.reload();
		brokerPage.clickOnBrokerMetricsTab();
		brokerPage.validateBrokerMetricsGCCountGraphMaxHeaderTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Broker, "BrokerMetrics_GCCount_Max_Header_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_174_validate_BrokerMetrics_GCCountGraph_RowColor() throws EncryptedDocumentException, IOException {
		//page.reload();
		brokerPage.clickOnBrokerMetricsTab();
		brokerPage.validateBrokerMetricsGCCountGraphRowColor(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Broker, "rgb(255, 123, 123)"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_175_validate_BrokerMetrics_GCCountGraph_ToolTip() throws EncryptedDocumentException, IOException {
		//page.reload();
		brokerPage.clickOnBrokerMetricsTab();
		brokerPage.validateBrokerMetricsGCCountToolTipTitle();
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_176_validate_BrokerMetrics_GCCountGraph_ExpandViewXAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		//page.reload();
		brokerPage.clickOnBrokerMetricsTab();
		brokerPage.validateBrokerMetricsGCCountExpandViewXAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_177_validate_BrokerMetrics_GCCountGraph_ExpandViewYAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		//page.reload();
		brokerPage.clickOnBrokerMetricsTab();
		brokerPage.validateBrokerMetricsGCCountExpandViewYAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_178_validate_BrokerMetrics_GCCountGraph_ExpandViewWidgetTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		//page.reload();
		brokerPage.clickOnBrokerMetricsTab();
		brokerPage.validateBrokerMetricsGCCountExpandViewWidgetTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_179_validate_BrokerMetrics_GCCountGraph_ExpandViewLegendHeader1() throws EncryptedDocumentException, IOException, InterruptedException {
		//page.reload();
		brokerPage.clickOnBrokerMetricsTab();
		brokerPage.validateBrokerMetricsGCCountExpandViewLegendHeader1();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_180_validate_BrokerMetrics_GCCountGraph_ExpandViewLegendHeader2() throws EncryptedDocumentException, IOException, InterruptedException {
		//page.reload();
		brokerPage.clickOnBrokerMetricsTab();
		brokerPage.validateBrokerMetricsGCCountExpandViewLegendHeader2();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_181_validate_BrokerMetrics_GCCountGraph_ExpandViewLegendHeader3() throws EncryptedDocumentException, IOException, InterruptedException {
		//page.reload();
		brokerPage.clickOnBrokerMetricsTab();
		brokerPage.validateBrokerMetricsGCCountExpandViewLegendHeader3();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_182_validate_BrokerMetrics_GCCountGraph_ExpandViewZoomInBtn() throws EncryptedDocumentException, IOException, InterruptedException {
		//page.reload();
		brokerPage.clickOnBrokerMetricsTab();
		brokerPage.validateBrokerMetricsGCCountExpandViewZoomIn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_183_validate_BrokerMetrics_GCCountGraph_ExpandViewZoomOutBtn() throws EncryptedDocumentException, IOException, InterruptedException {
		brokerPage.clickOnBrokerMetricsTab();
		brokerPage.validateBrokerMetricsGCCountExpandViewZoomOut();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_184_validate_BrokerMetrics_GCCountGraph_ExpandViewWidgetDragDrop() throws EncryptedDocumentException, IOException, InterruptedException {
		//page.reload();
		brokerPage.clickOnBrokerMetricsTab();
		brokerPage.validateBrokerMetricsGCCountExpandViewWidgetDragDrop();
	}			
	/********************************************************* Thread Count Graph ******************************************************************/
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_185_validate_BrokerMetrics_ThreadCountGraph_Title() throws EncryptedDocumentException, IOException {
		//page.reload();
		brokerPage.clickOnBrokerMetricsTab();
		brokerPage.validateBrokerMetricsThreadCountGraphTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Broker, "BrokerMetrics_ThreadCount_Graph_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_186_validate_BrokerMetrics_ThreadCountGraph_ZoomIn() throws EncryptedDocumentException, IOException {
		//page.reload();
		brokerPage.clickOnBrokerMetricsTab();
		brokerPage.validateBrokerMetricsThreadCountGraphZoomInBtn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_187_validate_BrokerMetrics_ThreadCountGraph_ZoomOut() throws EncryptedDocumentException, IOException {
		//page.reload();
		brokerPage.clickOnBrokerMetricsTab();
		brokerPage.validateBrokerMetricsThreadCountGraphZoomOutBtn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_188_validate_BrokerMetrics_ThreadCountGraph_XaxisValue() throws EncryptedDocumentException, IOException {
		//page.reload();
		brokerPage.clickOnBrokerMetricsTab();
		brokerPage.validateBrokerMetricsThreadCountXaxisValues();
	}	
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_189_validate_BrokerMetrics_ThreadCountGraph_XaxisTitle() throws EncryptedDocumentException, IOException {
		//page.reload();
		brokerPage.clickOnBrokerMetricsTab();
		brokerPage.validateBrokerMetricsThreadCountGraphXaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Broker, "BrokerMetrics_ThreadCount_Xaxis_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_190_validate_BrokerMetrics_ThreadCountGraph_YaxisTitle() throws EncryptedDocumentException, IOException {
		//page.reload();
		brokerPage.clickOnBrokerMetricsTab();
		brokerPage.validateBrokerMetricsThreadCountGraphYaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Broker, "BrokerMetrics_ThreadCount_Yaxis_Title"));
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_191_validate_BrokerMetrics_ThreadCountGraph_BrokerMetricsHeaderTitle() throws EncryptedDocumentException, IOException {
		//page.reload();
		brokerPage.clickOnBrokerMetricsTab();
		brokerPage.validateBrokerMetricsThreadCountGraphBrokerMetricsHeaderTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Broker, "BrokerMetrics_ThreadCount_Broker_Header_Title"));
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_192_validate_BrokerMetrics_ThreadCountGraph_AvgHeaderTitle() throws EncryptedDocumentException, IOException {
		//page.reload();
		brokerPage.clickOnBrokerMetricsTab();
		brokerPage.validateBrokerMetricsThreadCountGraphAvgHeaderTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Broker, "BrokerMetrics_ThreadCount_Avg_Header_Title"));
	}	
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_193_validate_BrokerMetrics_ThreadCountGraph_MaxHeaderTitle() throws EncryptedDocumentException, IOException {
		//page.reload();
		brokerPage.clickOnBrokerMetricsTab();
		brokerPage.validateBrokerMetricsThreadCountGraphMaxHeaderTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Broker, "BrokerMetrics_ThreadCount_Max_Header_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_194_validate_BrokerMetrics_ThreadCountGraph_RowColor() throws EncryptedDocumentException, IOException {
		//page.reload();
		brokerPage.clickOnBrokerMetricsTab();
		brokerPage.validateBrokerMetricsThreadCountGraphRowColor(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Broker, "rgb(255, 123, 123)"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_195_validate_BrokerMetrics_ThreadCountGraph_ToolTip() throws EncryptedDocumentException, IOException {
		//page.reload();
		brokerPage.clickOnBrokerMetricsTab();
		brokerPage.validateBrokerMetricsThreadCountToolTipTitle();
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_196_validate_BrokerMetrics_ThreadCountGraph_ExpandViewXAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		//page.reload();
		brokerPage.clickOnBrokerMetricsTab();
		brokerPage.validateBrokerMetricsThreadCountExpandViewXAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_197_validate_BrokerMetrics_ThreadCountGraph_ExpandViewYAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		//page.reload();
		brokerPage.clickOnBrokerMetricsTab();
		brokerPage.validateBrokerMetricsThreadCountExpandViewYAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_198_validate_BrokerMetrics_ThreadCountGraph_ExpandViewWidgetTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		//page.reload();
		brokerPage.clickOnBrokerMetricsTab();
		brokerPage.validateBrokerMetricsThreadCountExpandViewWidgetTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_199_validate_BrokerMetrics_ThreadCountGraph_ExpandViewLegendHeader1() throws EncryptedDocumentException, IOException, InterruptedException {
		//page.reload();
		brokerPage.clickOnBrokerMetricsTab();
		brokerPage.validateBrokerMetricsThreadCountExpandViewLegendHeader1();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_200_validate_BrokerMetrics_ThreadCountGraph_ExpandViewLegendHeader2() throws EncryptedDocumentException, IOException, InterruptedException {
		//page.reload();
		brokerPage.clickOnBrokerMetricsTab();
		brokerPage.validateBrokerMetricsThreadCountExpandViewLegendHeader2();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_201_validate_BrokerMetrics_ThreadCountGraph_ExpandViewLegendHeader3() throws EncryptedDocumentException, IOException, InterruptedException {
		//page.reload();
		brokerPage.clickOnBrokerMetricsTab();
		brokerPage.validateBrokerMetricsThreadCountExpandViewLegendHeader3();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_202_validate_BrokerMetrics_ThreadCountGraph_ExpandViewZoomInBtn() throws EncryptedDocumentException, IOException, InterruptedException {
		//page.reload();
		brokerPage.clickOnBrokerMetricsTab();
		brokerPage.validateBrokerMetricsThreadCountExpandViewZoomIn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_203_validate_BrokerMetrics_ThreadCountGraph_ExpandViewZoomOutBtn() throws EncryptedDocumentException, IOException, InterruptedException {
		//page.reload();
		brokerPage.clickOnBrokerMetricsTab();
		brokerPage.validateBrokerMetricsThreadCountExpandViewZoomOut();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_204_validate_BrokerMetrics_ThreadCountGraph_ExpandViewWidgetDragDrop() throws EncryptedDocumentException, IOException, InterruptedException {
		//page.reload();
		brokerPage.clickOnBrokerMetricsTab();
		brokerPage.validateBrokerMetricsThreadCountExpandViewWidgetDragDrop();
	}			
	
	/********************************************************* Message Count Graph ******************************************************************/
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_205_validate_BrokerMetrics_MessageCountGraph_Title() throws EncryptedDocumentException, IOException {
		//page.reload();
		brokerPage.clickOnBrokerMetricsTab();
		brokerPage.validateBrokerMetricsMessageCountGraphTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Broker, "BrokerMetrics_MessageCount_Graph_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_206_validate_BrokerMetrics_MessageCountGraph_ZoomIn() throws EncryptedDocumentException, IOException {
		//page.reload();
		brokerPage.clickOnBrokerMetricsTab();
		brokerPage.validateBrokerMetricsMessageCountGraphZoomInBtn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_207_validate_BrokerMetrics_MessageCountGraph_ZoomOut() throws EncryptedDocumentException, IOException {
		//page.reload();
		brokerPage.clickOnBrokerMetricsTab();
		brokerPage.validateBrokerMetricsMessageCountGraphZoomOutBtn();
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_208_validate_BrokerMetrics_MessageCountGraph_XaxisValue() throws EncryptedDocumentException, IOException {
		//page.reload();
		brokerPage.clickOnBrokerMetricsTab();
		brokerPage.validateBrokerMetricsMessageCountXaxisValues();
	}	
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_209_validate_BrokerMetrics_MessageCountGraph_XaxisTitle() throws EncryptedDocumentException, IOException {
		//page.reload();
		brokerPage.clickOnBrokerMetricsTab();
		brokerPage.validateBrokerMetricsMessageCountGraphXaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Broker, "BrokerMetrics_MessageCount_Xaxis_Title"));
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_210_validate_BrokerMetrics_MessageCountGraph_YaxisTitle() throws EncryptedDocumentException, IOException {
		//page.reload();
		brokerPage.clickOnBrokerMetricsTab();
		brokerPage.validateBrokerMetricsMessageCountGraphYaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Broker, "BrokerMetrics_MessageCount_Yaxis_Title"));
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_211_validate_BrokerMetrics_MessageCountGraph_BrokerMetricsHeaderTitle() throws EncryptedDocumentException, IOException {
		//page.reload();
		brokerPage.clickOnBrokerMetricsTab();
		brokerPage.validateBrokerMetricsMessageCountGraphBrokerMetricsHeaderTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Broker, "BrokerMetrics_MessageCount_Broker_Header_Title"));
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_212_validate_BrokerMetrics_MessageCountGraph_AvgHeaderTitle() throws EncryptedDocumentException, IOException {
		//page.reload();
		brokerPage.clickOnBrokerMetricsTab();
		brokerPage.validateBrokerMetricsMessageCountGraphAvgHeaderTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Broker, "BrokerMetrics_MessageCount_Avg_Header_Title"));
	}	
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_213_validate_BrokerMetrics_MessageCountGraph_MaxHeaderTitle() throws EncryptedDocumentException, IOException {
		//page.reload();
		brokerPage.clickOnBrokerMetricsTab();
		brokerPage.validateBrokerMetricsMessageCountGraphMaxHeaderTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Broker, "BrokerMetrics_MessageCount_Max_Header_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_214_validate_BrokerMetrics_MessageCountGraph_RowColor() throws EncryptedDocumentException, IOException {
		//page.reload();
		brokerPage.clickOnBrokerMetricsTab();
		brokerPage.validateBrokerMetricsMessageCountGraphRowColor(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Broker, "rgb(255, 123, 123)"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_215_validate_BrokerMetrics_MessageCountGraph_ToolTip() throws EncryptedDocumentException, IOException {
		//page.reload();
		brokerPage.clickOnBrokerMetricsTab();
		brokerPage.validateBrokerMetricsMessageCountToolTipTitle();
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_216_validate_BrokerMetrics_MessageCountGraph_ExpandViewXAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		//page.reload();
		brokerPage.clickOnBrokerMetricsTab();
		brokerPage.validateBrokerMetricsMessageCountExpandViewXAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_217_validate_BrokerMetrics_MessageCountGraph_ExpandViewYAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		//page.reload();
		brokerPage.clickOnBrokerMetricsTab();
		brokerPage.validateBrokerMetricsMessageCountExpandViewYAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_218_validate_BrokerMetrics_MessageCountGraph_ExpandViewWidgetTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		//page.reload();
		brokerPage.clickOnBrokerMetricsTab();
		brokerPage.validateBrokerMetricsMessageCountExpandViewWidgetTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_219_validate_BrokerMetrics_MessageCountGraph_ExpandViewLegendHeader1() throws EncryptedDocumentException, IOException, InterruptedException {
		//page.reload();
		brokerPage.clickOnBrokerMetricsTab();
		brokerPage.validateBrokerMetricsMessageCountExpandViewLegendHeader1();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_220_validate_BrokerMetrics_MessageCountGraph_ExpandViewLegendHeader2() throws EncryptedDocumentException, IOException, InterruptedException {
		//page.reload();
		brokerPage.clickOnBrokerMetricsTab();
		brokerPage.validateBrokerMetricsMessageCountExpandViewLegendHeader2();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_221_validate_BrokerMetrics_MessageCountGraph_ExpandViewLegendHeader3() throws EncryptedDocumentException, IOException, InterruptedException {
		//page.reload();
		brokerPage.clickOnBrokerMetricsTab();
		brokerPage.validateBrokerMetricsMessageCountExpandViewLegendHeader3();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_222_validate_BrokerMetrics_MessageCountGraph_ExpandViewZoomInBtn() throws EncryptedDocumentException, IOException, InterruptedException {
		//page.reload();
		brokerPage.clickOnBrokerMetricsTab();
		brokerPage.validateBrokerMetricsMessageCountExpandViewZoomIn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_223_validate_BrokerMetrics_MessageCountGraph_ExpandViewZoomOutBtn() throws EncryptedDocumentException, IOException, InterruptedException {
		//page.reload();
		brokerPage.clickOnBrokerMetricsTab();
		brokerPage.validateBrokerMetricsMessageCountExpandViewZoomOut();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_224_validate_BrokerMetrics_MessageCountGraph_ExpandViewWidgetDragDrop() throws EncryptedDocumentException, IOException, InterruptedException {
		//page.reload();
		brokerPage.clickOnBrokerMetricsTab();
		brokerPage.validateBrokerMetricsMessageCountExpandViewWidgetDragDrop();
	}		
}
