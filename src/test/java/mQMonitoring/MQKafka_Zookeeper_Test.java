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
import objectRepository.MQM.MQKafka_Zookeeper_Page;
import playWrightFactory.BaseClass;

public class MQKafka_Zookeeper_Test extends BaseClass
{
	
	GenericMethods util = new GenericMethods();
	CommonPage commonPage;
	MQKafka_Zookeeper_Page zookeeperPage;
	ExcelUtility excel = new ExcelUtility();
	
	@BeforeMethod
	public void Zookeeper() throws EncryptedDocumentException, IOException {
		commonPage = new CommonPage(page);
		zookeeperPage = new  MQKafka_Zookeeper_Page(page);
		excel = new ExcelUtility();
		
		commonPage.navigateToMQM();
		zookeeperPage.navigateToKafka();
		commonPage.selectTheTimeLineFromCalender(IPathConstant.oneMonthTimeRange);
		String application = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Load, "Application");
		zookeeperPage.selectServiceName(application);
		zookeeperPage.navigateToZookeeperTab();
		
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_001_validate_Zookeeper_Title() throws EncryptedDocumentException, IOException  {
		zookeeperPage.validateZookeeperTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Zookeeper, "Zookeeper_Tab_Title"));
	}
	
	/********************************************************* Zoo-keeper Disconnect Graph ******************************************************************/
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_002_validate_Zookeeper_DisconnectGraph_Title() throws EncryptedDocumentException, IOException {
		zookeeperPage.validateZookeeperDisconnectGraphTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Zookeeper, "Zookeeper_Disconnect_Graph_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_003_validate_Broker_DisconnectGraph_ZoomIn() throws EncryptedDocumentException, IOException {
		zookeeperPage.validateZookeeperDisconnectGraphZoomInBtn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_004_validate_Broker_DisconnectGraph_ZoomOut() throws EncryptedDocumentException, IOException {
		zookeeperPage.validateZookeeperDisconnectGraphZoomOutBtn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_005_validate_Zookeeper_DisconnectGraph_XaxisValue() throws EncryptedDocumentException, IOException {
		zookeeperPage.validateZookeeperDisconnectXaxisValues();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_006_validate_Zookeeper_DisconnectGraph_XaxisTitle() throws EncryptedDocumentException, IOException {
		zookeeperPage.validateZookeeperDisconnectGraphXaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Zookeeper, "Zookeeper_Disconnect_Xaxis_Title"));
	}	
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_007_validate_Zookeeper_DisconnectGraph_YaxisTitle() throws EncryptedDocumentException, IOException {
		zookeeperPage.validateZookeeperDisconnectGraphYaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Zookeeper, "Zookeeper_Disconnect_Yaxis_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_008_validate_Zookeeper_DisconnectGraph_ZookeeperHeaderTitle() throws EncryptedDocumentException, IOException {
		zookeeperPage.validateZookeeperDisconnectGraphTopicHeaderTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Zookeeper, "Zookeeper_Disconnect_Broker_Header_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_009_validate_Zookeeper_DisconnectGraph_AvgHeaderTitle() throws EncryptedDocumentException, IOException {
		zookeeperPage.validateZookeeperDisconnectGraphAvgHeaderTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Zookeeper, "Zookeeper_Disconnect_Avg_Header_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_010_validate_Zookeeper_DisconnectGraph_MaxHeaderTitle() throws EncryptedDocumentException, IOException {
		zookeeperPage.validateZookeeperDisconnectGraphMaxHeaderTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Zookeeper, "Zookeeper_Disconnect_Max_Header_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_011_validate_Zookeeper_DisconnectGraph_RowColor() throws EncryptedDocumentException, IOException {
		zookeeperPage.validateZookeeperDisconnectGraphRowColor(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Zookeeper, "rgb(255, 123, 123)"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_012_validate_Zookeeper_DisconnectGraph_ToolTip() throws EncryptedDocumentException, IOException {
		zookeeperPage.validateZookeeperDisconnectToolTipTitle();
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_013_validate_Zookeeper_DisconnectGraph_ExpandViewXAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		zookeeperPage.validateZookeeperDisconnectExpandViewXAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_014_validate_Zookeeper_DisconnectGraph_ExpandViewYAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		zookeeperPage.validateZookeeperDisconnectExpandViewYAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_015_validate_Zookeeper_DisconnectGraph_ExpandViewWidgetTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		zookeeperPage.validateZookeeperDisconnectExpandViewWidgetTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_016_validate_Zookeeper_DisconnectGraph_ExpandViewLegendHeader1() throws EncryptedDocumentException, IOException, InterruptedException {
		zookeeperPage.validateZookeeperDisconnectExpandViewLegendHeader1();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_017_validate_Zookeeper_DisconnectGraph_ExpandViewLegendHeader2() throws EncryptedDocumentException, IOException, InterruptedException {
		zookeeperPage.validateZookeeperDisconnectExpandViewLegendHeader2();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_018_validate_Zookeeper_DisconnectGraph_ExpandViewLegendHeader3() throws EncryptedDocumentException, IOException, InterruptedException {
		zookeeperPage.validateZookeeperDisconnectExpandViewLegendHeader3();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_019_validate_Zookeeper_DisconnectGraph_ExpandViewZoomInBtn() throws EncryptedDocumentException, IOException, InterruptedException {
		zookeeperPage.validateZookeeperDisconnectExpandViewZoomIn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_020_validate_Zookeeper_DisconnectGraph_ExpandViewZoomOutBtn() throws EncryptedDocumentException, IOException, InterruptedException {
		zookeeperPage.validateZookeeperDisconnectExpandViewZoomOut();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_021_validate_Zookeeper_DisconnectGraph_ExpandViewWidgetDragDrop() throws EncryptedDocumentException, IOException, InterruptedException {
		zookeeperPage.validateZookeeperDisconnectExpandViewWidgetDragDrop();
	}	
	
	
	/********************************************************* Zookeeper Connect Graph ******************************************************************/
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_022_validate_Zookeeper_ConnectGraph_Title() throws EncryptedDocumentException, IOException {
		zookeeperPage.validateZookeeperConnectGraphTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Zookeeper, "Zookeeper_Connect_Graph_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_023_validate_Broker_ConnectGraph_ZoomIn() throws EncryptedDocumentException, IOException {
		zookeeperPage.validateZookeeperConnectGraphZoomInBtn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_024_validate_Broker_ConnectGraph_ZoomOut() throws EncryptedDocumentException, IOException {
		zookeeperPage.validateZookeeperConnectGraphZoomOutBtn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_025_validate_Zookeeper_ConnectGraph_XaxisValue() throws EncryptedDocumentException, IOException {
		zookeeperPage.validateZookeeperConnectXaxisValues();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_026_validate_Zookeeper_ConnectGraph_XaxisTitle() throws EncryptedDocumentException, IOException {
		zookeeperPage.validateZookeeperConnectGraphXaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Zookeeper, "Zookeeper_Connect_Xaxis_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_027_validate_Zookeeper_ConnectGraph_YaxisTitle() throws EncryptedDocumentException, IOException {
		zookeeperPage.validateZookeeperConnectGraphYaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Zookeeper, "Zookeeper_Connect_Yaxis_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_028_validate_Zookeeper_ConnectGraph_ZookeeperHeaderTitle() throws EncryptedDocumentException, IOException {
		zookeeperPage.validateZookeeperConnectGraphTopicHeaderTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Zookeeper, "Zookeeper_Connect_Broker_Header_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_029_validate_Zookeeper_ConnectGraph_AvgHeaderTitle() throws EncryptedDocumentException, IOException {
		zookeeperPage.validateZookeeperConnectGraphAvgHeaderTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Zookeeper, "Zookeeper_Connect_Avg_Header_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_030_validate_Zookeeper_ConnectGraph_MaxHeaderTitle() throws EncryptedDocumentException, IOException {
		zookeeperPage.validateZookeeperConnectGraphMaxHeaderTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Zookeeper, "Zookeeper_Connect_Max_Header_Title"));
	}	
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_031_validate_Zookeeper_ConnectGraph_RowColor() throws EncryptedDocumentException, IOException {
		zookeeperPage.validateZookeeperConnectGraphRowColor(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Zookeeper, "rgb(255, 123, 123)"));
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_032_validate_Zookeeper_ConnectGraph_ToolTip() throws EncryptedDocumentException, IOException {
		zookeeperPage.validateZookeeperConnectToolTipTitle();
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_033_validate_Zookeeper_ConnectGraph_ExpandViewXAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		zookeeperPage.validateZookeeperConnectExpandViewXAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_034_validate_Zookeeper_ConnectGraph_ExpandViewYAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		zookeeperPage.validateZookeeperConnectExpandViewYAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_035_validate_Zookeeper_ConnectGraph_ExpandViewWidgetTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		zookeeperPage.validateZookeeperConnectExpandViewWidgetTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_036_validate_Zookeeper_ConnectGraph_ExpandViewLegendHeader1() throws EncryptedDocumentException, IOException, InterruptedException {
		zookeeperPage.validateZookeeperConnectExpandViewLegendHeader1();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_037_validate_Zookeeper_ConnectGraph_ExpandViewLegendHeader2() throws EncryptedDocumentException, IOException, InterruptedException {
		zookeeperPage.validateZookeeperConnectExpandViewLegendHeader2();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_038_validate_Zookeeper_ConnectGraph_ExpandViewLegendHeader3() throws EncryptedDocumentException, IOException, InterruptedException {
		zookeeperPage.validateZookeeperConnectExpandViewLegendHeader3();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_039_validate_Zookeeper_ConnectGraph_ExpandViewZoomInBtn() throws EncryptedDocumentException, IOException, InterruptedException {
		zookeeperPage.validateZookeeperConnectExpandViewZoomIn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_040_validate_Zookeeper_ConnectGraph_ExpandViewZoomOutBtn() throws EncryptedDocumentException, IOException, InterruptedException {
		zookeeperPage.validateZookeeperConnectExpandViewZoomOut();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_041_validate_Zookeeper_ConnectGraph_ExpandViewWidgetDragDrop() throws EncryptedDocumentException, IOException, InterruptedException {
		zookeeperPage.validateZookeeperConnectExpandViewWidgetDragDrop();
	}	
	
/********************************************************* Zoo-keeper Expire Per Second Graph ******************************************************************/
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_042_validate_Zookeeper_ExpirePerSecondGraph_Title() throws EncryptedDocumentException, IOException {
		zookeeperPage.validateZookeeperExpirePerSecondGraphTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Zookeeper, "Zookeeper_ExpirePerSecond_Graph_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_043_validate_Broker_ExpirePerSecondGraph_ZoomIn() throws EncryptedDocumentException, IOException {
		zookeeperPage.validateZookeeperExpirePerSecondGraphZoomInBtn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_044_validate_Broker_ExpirePerSecondGraph_ZoomOut() throws EncryptedDocumentException, IOException {
		zookeeperPage.validateZookeeperExpirePerSecondGraphZoomOutBtn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_045_validate_Zookeeper_ExpirePerSecondGraph_XaxisValue() throws EncryptedDocumentException, IOException {
		zookeeperPage.validateZookeeperExpirePerSecondXaxisValues();
	}	
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_046_validate_Zookeeper_ExpirePerSecondGraph_XaxisTitle() throws EncryptedDocumentException, IOException {
		zookeeperPage.validateZookeeperExpirePerSecondGraphXaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Zookeeper, "Zookeeper_ExpirePerSecond_Xaxis_Title"));
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_047_validate_Zookeeper_ExpirePerSecondGraph_YaxisTitle() throws EncryptedDocumentException, IOException {
		zookeeperPage.validateZookeeperExpirePerSecondGraphYaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Zookeeper, "Zookeeper_ExpirePerSecond_Yaxis_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_048_validate_Zookeeper_ExpirePerSecondGraph_ZookeeperHeaderTitle() throws EncryptedDocumentException, IOException {
		zookeeperPage.validateZookeeperExpirePerSecondGraphTopicHeaderTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Zookeeper, "Zookeeper_ExpirePerSecond_Broker_Header_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_049_validate_Zookeeper_ExpirePerSecondGraph_AvgHeaderTitle() throws EncryptedDocumentException, IOException {
		zookeeperPage.validateZookeeperExpirePerSecondGraphAvgHeaderTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Zookeeper, "Zookeeper_ExpirePerSecond_Avg_Header_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_050_validate_Zookeeper_ExpirePerSecondGraph_MaxHeaderTitle() throws EncryptedDocumentException, IOException {
		zookeeperPage.validateZookeeperExpirePerSecondGraphMaxHeaderTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Zookeeper, "Zookeeper_ExpirePerSecond_Max_Header_Title"));
	}	
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_051_validate_Zookeeper_ExpirePerSecondGraph_RowColor() throws EncryptedDocumentException, IOException {
		zookeeperPage.validateZookeeperExpirePerSecondGraphRowColor(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Zookeeper, "rgb(255, 123, 123)"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_052_validate_Zookeeper_ExpirePerSecondGraph_ToolTip() throws EncryptedDocumentException, IOException {
		zookeeperPage.validateZookeeperExpirePerSecondToolTipTitle();
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_053_validate_Zookeeper_ExpirePerSecondGraph_ExpandViewXAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		zookeeperPage.validateZookeeperExpirePerSecondExpandViewXAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_054_validate_Zookeeper_ExpirePerSecondGraph_ExpandViewYAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		zookeeperPage.validateZookeeperExpirePerSecondExpandViewYAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_055_validate_Zookeeper_ExpirePerSecondGraph_ExpandViewWidgetTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		zookeeperPage.validateZookeeperExpirePerSecondExpandViewWidgetTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_056_validate_Zookeeper_ExpirePerSecondGraph_ExpandViewLegendHeader1() throws EncryptedDocumentException, IOException, InterruptedException {
		zookeeperPage.validateZookeeperExpirePerSecondExpandViewLegendHeader1();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_057_validate_Zookeeper_ExpirePerSecondGraph_ExpandViewLegendHeader2() throws EncryptedDocumentException, IOException, InterruptedException {
		zookeeperPage.validateZookeeperExpirePerSecondExpandViewLegendHeader2();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_058_validate_Zookeeper_ExpirePerSecondGraph_ExpandViewLegendHeader3() throws EncryptedDocumentException, IOException, InterruptedException {
		zookeeperPage.validateZookeeperExpirePerSecondExpandViewLegendHeader3();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_059_validate_Zookeeper_ExpirePerSecondGraph_ExpandViewZoomInBtn() throws EncryptedDocumentException, IOException, InterruptedException {
		zookeeperPage.validateZookeeperExpirePerSecondExpandViewZoomIn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_060_validate_Zookeeper_ExpirePerSecondGraph_ExpandViewZoomOutBtn() throws EncryptedDocumentException, IOException, InterruptedException {
		zookeeperPage.validateZookeeperExpirePerSecondExpandViewZoomOut();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_061_validate_Zookeeper_ExpirePerSecondGraph_ExpandViewWidgetDragDrop() throws EncryptedDocumentException, IOException, InterruptedException {
		zookeeperPage.validateZookeeperExpirePerSecondExpandViewWidgetDragDrop();
	}	
	
/********************************************************* Zoo-keeper Auth Failure Graph ******************************************************************/
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_062_validate_Zookeeper_AuthFailureGraph_Title() throws EncryptedDocumentException, IOException {
		zookeeperPage.validateZookeeperAuthFailureGraphTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Zookeeper, "Zookeeper_AuthFailure_Graph_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_063_validate_Broker_AuthFailureGraph_ZoomIn() throws EncryptedDocumentException, IOException {
		zookeeperPage.validateZookeeperAuthFailureGraphZoomInBtn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_064_validate_Broker_AuthFailureGraph_ZoomOut() throws EncryptedDocumentException, IOException {
		zookeeperPage.validateZookeeperAuthFailureGraphZoomOutBtn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_065_validate_Zookeeper_AuthFailureGraph_XaxisValue() throws EncryptedDocumentException, IOException {
		zookeeperPage.validateZookeeperAuthFailureXaxisValues();
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_066_validate_Zookeeper_AuthFailureGraph_XaxisTitle() throws EncryptedDocumentException, IOException {
		zookeeperPage.validateZookeeperAuthFailureGraphXaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Zookeeper, "Zookeeper_AuthFailure_Xaxis_Title"));
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_067_validate_Zookeeper_AuthFailureGraph_YaxisTitle() throws EncryptedDocumentException, IOException {
		zookeeperPage.validateZookeeperAuthFailureGraphYaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Zookeeper, "Zookeeper_AuthFailure_Yaxis_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_068_validate_Zookeeper_AuthFailureGraph_ZookeeperHeaderTitle() throws EncryptedDocumentException, IOException {
		zookeeperPage.validateZookeeperAuthFailureGraphTopicHeaderTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Zookeeper, "Zookeeper_AuthFailure_Broker_Header_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_069_validate_Zookeeper_AuthFailureGraph_AvgHeaderTitle() throws EncryptedDocumentException, IOException {
		zookeeperPage.validateZookeeperAuthFailureGraphAvgHeaderTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Zookeeper, "Zookeeper_AuthFailure_Avg_Header_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_070_validate_Zookeeper_AuthFailureGraph_MaxHeaderTitle() throws EncryptedDocumentException, IOException {
		zookeeperPage.validateZookeeperAuthFailureGraphMaxHeaderTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Zookeeper, "Zookeeper_AuthFailure_Max_Header_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_071_validate_Zookeeper_AuthFailureGraph_RowColor() throws EncryptedDocumentException, IOException {
		zookeeperPage.validateZookeeperAuthFailureGraphRowColor(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Zookeeper, "rgb(255, 123, 123)"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_072_validate_Zookeeper_AuthFailureGraph_ToolTip() throws EncryptedDocumentException, IOException {
		zookeeperPage.validateZookeeperAuthFailureToolTipTitle();
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_073_validate_Zookeeper_AuthFailureGraph_ExpandViewXAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		zookeeperPage.validateZookeeperAuthFailureExpandViewXAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_074_validate_Zookeeper_AuthFailureGraph_ExpandViewYAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		zookeeperPage.validateZookeeperAuthFailureExpandViewYAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_075_validate_Zookeeper_AuthFailureGraph_ExpandViewWidgetTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		zookeeperPage.validateZookeeperAuthFailureExpandViewWidgetTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_076_validate_Zookeeper_AuthFailureGraph_ExpandViewLegendHeader1() throws EncryptedDocumentException, IOException, InterruptedException {
		zookeeperPage.validateZookeeperAuthFailureExpandViewLegendHeader1();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_077_validate_Zookeeper_AuthFailureGraph_ExpandViewLegendHeader2() throws EncryptedDocumentException, IOException, InterruptedException {
		zookeeperPage.validateZookeeperAuthFailureExpandViewLegendHeader2();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_078_validate_Zookeeper_AuthFailureGraph_ExpandViewLegendHeader3() throws EncryptedDocumentException, IOException, InterruptedException {
		zookeeperPage.validateZookeeperAuthFailureExpandViewLegendHeader3();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_079_validate_Zookeeper_AuthFailureGraph_ExpandViewZoomInBtn() throws EncryptedDocumentException, IOException, InterruptedException {
		zookeeperPage.validateZookeeperAuthFailureExpandViewZoomIn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_080_validate_Zookeeper_AuthFailureGraph_ExpandViewZoomOutBtn() throws EncryptedDocumentException, IOException, InterruptedException {
		zookeeperPage.validateZookeeperAuthFailureExpandViewZoomOut();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_081_validate_Zookeeper_AuthFailureGraph_ExpandViewWidgetDragDrop() throws EncryptedDocumentException, IOException, InterruptedException {
		zookeeperPage.validateZookeeperAuthFailureExpandViewWidgetDragDrop();
	}	
	
/********************************************************* Zookeeper Read Only Connect Graph ******************************************************************/
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_082_validate_Zookeeper_ReadOnlyConnectGraph_Title() throws EncryptedDocumentException, IOException {
		zookeeperPage.validateZookeeperReadOnlyConnectGraphTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Zookeeper, "Zookeeper_ReadOnlyConnect_Graph_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_083_validate_Broker_ReadOnlyConnectGraph_ZoomIn() throws EncryptedDocumentException, IOException {
		zookeeperPage.validateZookeeperReadOnlyConnectGraphZoomInBtn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_084_validate_Broker_ReadOnlyConnectGraph_ZoomOut() throws EncryptedDocumentException, IOException {
		zookeeperPage.validateZookeeperReadOnlyConnectGraphZoomOutBtn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_085_validate_Zookeeper_ReadOnlyConnectGraph_XaxisValue() throws EncryptedDocumentException, IOException {
		zookeeperPage.validateZookeeperReadOnlyConnectXaxisValues();
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_086_validate_Zookeeper_ReadOnlyConnectGraph_XaxisTitle() throws EncryptedDocumentException, IOException {
		zookeeperPage.validateZookeeperReadOnlyConnectGraphXaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Zookeeper, "Zookeeper_ReadOnlyConnect_Xaxis_Title"));
	}	
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_087_validate_Zookeeper_ReadOnlyConnectGraph_YaxisTitle() throws EncryptedDocumentException, IOException {
		zookeeperPage.validateZookeeperReadOnlyConnectGraphYaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Zookeeper, "Zookeeper_ReadOnlyConnect_Yaxis_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_088_validate_Zookeeper_ReadOnlyConnectGraph_ZookeeperHeaderTitle() throws EncryptedDocumentException, IOException {
		zookeeperPage.validateZookeeperReadOnlyConnectGraphTopicHeaderTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Zookeeper, "Zookeeper_ReadOnlyConnect_Broker_Header_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_089_validate_Zookeeper_ReadOnlyConnectGraph_AvgHeaderTitle() throws EncryptedDocumentException, IOException {
		zookeeperPage.validateZookeeperReadOnlyConnectGraphAvgHeaderTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Zookeeper, "Zookeeper_ReadOnlyConnect_Avg_Header_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_090_validate_Zookeeper_ReadOnlyConnectGraph_MaxHeaderTitle() throws EncryptedDocumentException, IOException {
		zookeeperPage.validateZookeeperReadOnlyConnectGraphMaxHeaderTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Zookeeper, "Zookeeper_ReadOnlyConnect_Max_Header_Title"));
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_091_validate_Zookeeper_ReadOnlyConnectGraph_RowColor() throws EncryptedDocumentException, IOException {
		zookeeperPage.validateZookeeperReadOnlyConnectGraphRowColor(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Zookeeper, "rgb(255, 123, 123)"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_092_validate_Zookeeper_ReadOnlyConnectGraph_ToolTip() throws EncryptedDocumentException, IOException {
		zookeeperPage.validateZookeeperReadOnlyConnectToolTipTitle();
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_093_validate_Zookeeper_ReadOnlyConnectGraph_ExpandViewXAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		zookeeperPage.validateZookeeperReadOnlyConnectExpandViewXAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_094_validate_Zookeeper_ReadOnlyConnectGraph_ExpandViewYAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		zookeeperPage.validateZookeeperReadOnlyConnectExpandViewYAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_095_validate_Zookeeper_ReadOnlyConnectGraph_ExpandViewWidgetTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		zookeeperPage.validateZookeeperReadOnlyConnectExpandViewWidgetTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_096_validate_Zookeeper_ReadOnlyConnectGraph_ExpandViewLegendHeader1() throws EncryptedDocumentException, IOException, InterruptedException {
		zookeeperPage.validateZookeeperReadOnlyConnectExpandViewLegendHeader1();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_097_validate_Zookeeper_ReadOnlyConnectGraph_ExpandViewLegendHeader2() throws EncryptedDocumentException, IOException, InterruptedException {
		zookeeperPage.validateZookeeperReadOnlyConnectExpandViewLegendHeader2();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_098_validate_Zookeeper_ReadOnlyConnectGraph_ExpandViewLegendHeader3() throws EncryptedDocumentException, IOException, InterruptedException {
		zookeeperPage.validateZookeeperReadOnlyConnectExpandViewLegendHeader3();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_099_validate_Zookeeper_ReadOnlyConnectGraph_ExpandViewZoomInBtn() throws EncryptedDocumentException, IOException, InterruptedException {
		zookeeperPage.validateZookeeperReadOnlyConnectExpandViewZoomIn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_100_validate_Zookeeper_ReadOnlyConnectGraph_ExpandViewZoomOutBtn() throws EncryptedDocumentException, IOException, InterruptedException {
		zookeeperPage.validateZookeeperReadOnlyConnectExpandViewZoomOut();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_101_validate_Zookeeper_ReadOnlyConnectGraph_ExpandViewWidgetDragDrop() throws EncryptedDocumentException, IOException, InterruptedException {
		zookeeperPage.validateZookeeperReadOnlyConnectExpandViewWidgetDragDrop();
	}	
	
	
/********************************************************* Zoo-keeper SASL Authentication Graph ******************************************************************/
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_102_validate_Zookeeper_SASLAuthenticationGraph_Title() throws EncryptedDocumentException, IOException {
		zookeeperPage.validateZookeeperSASLAuthenticationGraphTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Zookeeper, "Zookeeper_SASLAuthentication_Graph_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_103_validate_Broker_SASLAuthenticationGraph_ZoomIn() throws EncryptedDocumentException, IOException {
		zookeeperPage.validateZookeeperSASLAuthenticationGraphZoomInBtn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_104_validate_Broker_SASLAuthenticationGraph_ZoomOut() throws EncryptedDocumentException, IOException {
		zookeeperPage.validateZookeeperSASLAuthenticationGraphZoomOutBtn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_105_validate_Zookeeper_SASLAuthenticationGraph_XaxisValue() throws EncryptedDocumentException, IOException {
		zookeeperPage.validateZookeeperSASLAuthenticationXaxisValues();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_106_validate_Zookeeper_SASLAuthenticationGraph_XaxisTitle() throws EncryptedDocumentException, IOException {
		zookeeperPage.validateZookeeperSASLAuthenticationGraphXaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Zookeeper, "Zookeeper_SASLAuthentication_Xaxis_Title"));
	}	
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_107_validate_Zookeeper_SASLAuthenticationGraph_YaxisTitle() throws EncryptedDocumentException, IOException {
		zookeeperPage.validateZookeeperSASLAuthenticationGraphYaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Zookeeper, "Zookeeper_SASLAuthentication_Yaxis_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_108_validate_Zookeeper_SASLAuthenticationGraph_ZookeeperHeaderTitle() throws EncryptedDocumentException, IOException {
		zookeeperPage.validateZookeeperSASLAuthenticationGraphTopicHeaderTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Zookeeper, "Zookeeper_SASLAuthentication_Broker_Header_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_109_validate_Zookeeper_SASLAuthenticationGraph_AvgHeaderTitle() throws EncryptedDocumentException, IOException {
		zookeeperPage.validateZookeeperSASLAuthenticationGraphAvgHeaderTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Zookeeper, "Zookeeper_SASLAuthentication_Avg_Header_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_110_validate_Zookeeper_SASLAuthenticationGraph_MaxHeaderTitle() throws EncryptedDocumentException, IOException {
		zookeeperPage.validateZookeeperSASLAuthenticationGraphMaxHeaderTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Zookeeper, "Zookeeper_SASLAuthentication_Max_Header_Title"));
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_111_validate_Zookeeper_SASLAuthenticationGraph_RowColor() throws EncryptedDocumentException, IOException {
		zookeeperPage.validateZookeeperSASLAuthenticationGraphRowColor(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Zookeeper, "rgb(255, 123, 123)"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_112_validate_Zookeeper_SASLAuthenticationGraph_ToolTip() throws EncryptedDocumentException, IOException {
		zookeeperPage.validateZookeeperSASLAuthenticationToolTipTitle();
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_113_validate_Zookeeper_SASLAuthenticationGraph_ExpandViewXAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		zookeeperPage.validateZookeeperSASLAuthenticationExpandViewXAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_114_validate_Zookeeper_SASLAuthenticationGraph_ExpandViewYAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		zookeeperPage.validateZookeeperSASLAuthenticationExpandViewYAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_115_validate_Zookeeper_SASLAuthenticationGraph_ExpandViewWidgetTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		zookeeperPage.validateZookeeperSASLAuthenticationExpandViewWidgetTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_116_validate_Zookeeper_SASLAuthenticationGraph_ExpandViewLegendHeader1() throws EncryptedDocumentException, IOException, InterruptedException {
		zookeeperPage.validateZookeeperSASLAuthenticationExpandViewLegendHeader1();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_117_validate_Zookeeper_SASLAuthenticationGraph_ExpandViewLegendHeader2() throws EncryptedDocumentException, IOException, InterruptedException {
		zookeeperPage.validateZookeeperSASLAuthenticationExpandViewLegendHeader2();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_118_validate_Zookeeper_SASLAuthenticationGraph_ExpandViewLegendHeader3() throws EncryptedDocumentException, IOException, InterruptedException {
		zookeeperPage.validateZookeeperSASLAuthenticationExpandViewLegendHeader3();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_119_validate_Zookeeper_SASLAuthenticationGraph_ExpandViewZoomInBtn() throws EncryptedDocumentException, IOException, InterruptedException {
		zookeeperPage.validateZookeeperSASLAuthenticationExpandViewZoomIn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_120_validate_Zookeeper_SASLAuthenticationGraph_ExpandViewZoomOutBtn() throws EncryptedDocumentException, IOException, InterruptedException {
		zookeeperPage.validateZookeeperSASLAuthenticationExpandViewZoomOut();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_121_validate_Zookeeper_SASLAuthenticationGraph_ExpandViewWidgetDragDrop() throws EncryptedDocumentException, IOException, InterruptedException {
		zookeeperPage.validateZookeeperSASLAuthenticationExpandViewWidgetDragDrop();
	}	
	
}
