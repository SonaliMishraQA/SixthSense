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
import objectRepository.MQM.KafkaZookeeperPage;

public class KafkaZookeeperTest extends BaseClass
{
	GenericMethods util = new GenericMethods();
	CommonPage commonPage;
	KafkaZookeeperPage KafkaZookeeperPage;
	ExcelUtility excel = new ExcelUtility();	

	@BeforeMethod
	public void Zookeeper() throws EncryptedDocumentException, IOException 
	{
		commonPage = new CommonPage(page);
		KafkaZookeeperPage = new  KafkaZookeeperPage(page);
		excel = new ExcelUtility();
	}	
	
/*
 * Zoo keeper Disconnect Graph	
 */

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_001_validate_Zookeeper_ZookeeperDisconnectGraph_Title() throws EncryptedDocumentException, IOException {
		commonPage.navigateToMQM();	
		String messageQueue = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Load, "MessageQueue");
		KafkaZookeeperPage.navigateToKafka(messageQueue);
		page.waitForLoadState(LoadState.NETWORKIDLE);
		page.waitForTimeout(3000);
		String application = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Load, "Application");
		KafkaZookeeperPage.selectServiceName(application);
		commonPage.selectTheTimeLineFromCalender(IPathConstant.oneMonthTimeRange);
		KafkaZookeeperPage.navigateToZookeeperTab();
		KafkaZookeeperPage.validateZookeeperDisconnectGraphTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Zookeeper, "Zookeeper_Disconnect_Graph_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_002_validate_Broker_Title() throws EncryptedDocumentException, IOException {
		KafkaZookeeperPage.validateBrokerSelectTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Zookeeper, "Zookeeper_BrokerSelect_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_003_validate_Broker_DropDown() throws EncryptedDocumentException, IOException {
		KafkaZookeeperPage.validateBrokerSelectDropDown();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_004_validate_Zookeeper_ZookeeperDisconnectGraph_ZoomIn() throws EncryptedDocumentException, IOException {	
		KafkaZookeeperPage.validateZookeeperDisconnectZoomInBtn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_005_validate_Zookeeper_ZookeeperDisconnectGraph_ZoomOut() throws EncryptedDocumentException, IOException {
		KafkaZookeeperPage.validateZookeeperDisconnectZoomOutBtn();
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_006_validate_Zookeeper_ZookeeperDisconnectGraph_DragAndDrop() throws EncryptedDocumentException, IOException {
		KafkaZookeeperPage.validateZookeeperDisconnectDragAndDrop();
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_007_validate_Zookeeper_ZookeeperDisconnectGraph_XaxisTitle() throws EncryptedDocumentException, IOException {
		KafkaZookeeperPage.validateZookeeperDisconnectGraphXaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Zookeeper, "Zookeeper_Disconnect_Xaxis_Title"));
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_008_validate_Zookeeper_ZookeeperDisconnectGraph_YaxisTitle() throws EncryptedDocumentException, IOException {
		KafkaZookeeperPage.validateZookeeperDisconnectGraphYaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Zookeeper, "Zookeeper_Disconnect_Yaxis_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_009_validate_Zookeeper_ZookeeperDisconnectGraph_LegendTitle1() throws EncryptedDocumentException, IOException {
		KafkaZookeeperPage.validateZookeeperDisconnectGraphLegendTitle1(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Zookeeper, "Zookeeper_Disconnect_Broker_Header_Title"));
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_010_validate_Zookeeper_ZookeeperDisconnectGraph_LegendTitle2() throws EncryptedDocumentException, IOException {
		KafkaZookeeperPage.validateZookeeperDisconnectGraphLegendTitle2(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Zookeeper, "Zookeeper_Disconnect_Avg_Header_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_011_validate_Zookeeper_ZookeeperDisconnectGraph_LegendTitle3() throws EncryptedDocumentException, IOException {
		KafkaZookeeperPage.validateZookeeperDisconnectGraphLegendTitle3(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Zookeeper, "Zookeeper_Disconnect_Max_Header_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_012_validate_Zookeeper_ZookeeperDisconnectGraph_ToolTip() throws EncryptedDocumentException, IOException {
		KafkaZookeeperPage.validateZookeeperDisconnectToolTipTitle();
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_013_validate_Zookeeper_ZookeeperDisconnectGraph_ExpandViewXAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaZookeeperPage.validateZookeeperDisconnectExpandViewXAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_014_validate_Zookeeper_ZookeeperDisconnectGraph_ExpandViewYAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaZookeeperPage.validateZookeeperDisconnectExpandViewYAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_015_validate_Zookeeper_ZookeeperDisconnectGraph_ExpandViewWidgetTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaZookeeperPage.validateZookeeperDisconnectExpandViewWidgetTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_016_validate_Zookeeper_ZookeeperDisconnectGraph_ExpandViewLegendHeader1() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaZookeeperPage.validateZookeeperDisconnectExpandViewLegendHeader1();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_017_validate_Zookeeper_ZookeeperDisconnectGraph_ExpandViewLegendHeader2() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaZookeeperPage.validateZookeeperDisconnectExpandViewLegendHeader2();
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_018_validate_Zookeeper_ZookeeperDisconnectGraph_ExpandViewLegendHeader3() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaZookeeperPage.validateZookeeperDisconnectExpandViewLegendHeader3();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_019_validate_Zookeeper_ZookeeperDisconnectGraph_ExpandViewZoomInBtn() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaZookeeperPage.validateZookeeperDisconnectExpandViewZoomIn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_020_validate_Zookeeper_ZookeeperDisconnectGraph_ExpandViewZoomOutBtn() throws EncryptedDocumentException, IOException, InterruptedException {	 
		KafkaZookeeperPage.validateZookeeperDisconnectExpandViewZoomOut();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_021_validate_Zookeeper_ZookeeperDisconnectGraph_ExpandViewWidgetDragDrop() throws EncryptedDocumentException, IOException, InterruptedException {		 
		KafkaZookeeperPage.validateZookeeperDisconnectExpandViewWidgetDragDrop();
	}	

/*
 * Zookeeper Connect Graph	
 */

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_022_validate_Zookeeper_ZookeeperConnectGraph_Title() throws EncryptedDocumentException, IOException {
		KafkaZookeeperPage.validateZookeeperConnectGraphTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Zookeeper, "Zookeeper_Connect_Graph_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_023_validate_Zookeeper_ZookeeperConnectGraph_ZoomIn() throws EncryptedDocumentException, IOException {	
		KafkaZookeeperPage.validateZookeeperConnectZoomInBtn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_024_validate_Zookeeper_ZookeeperConnectGraph_ZoomOut() throws EncryptedDocumentException, IOException {
		KafkaZookeeperPage.validateZookeeperConnectZoomOutBtn();
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_025_validate_Zookeeper_ZookeeperConnectGraph_DragAndDrop() throws EncryptedDocumentException, IOException {
		KafkaZookeeperPage.validateZookeeperConnectDragAndDrop();
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_026_validate_Zookeeper_ZookeeperConnectGraph_XaxisTitle() throws EncryptedDocumentException, IOException {
		KafkaZookeeperPage.validateZookeeperConnectGraphXaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Zookeeper, "Zookeeper_Connect_Xaxis_Title"));
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_027_validate_Zookeeper_ZookeeperConnectGraph_YaxisTitle() throws EncryptedDocumentException, IOException {
		KafkaZookeeperPage.validateZookeeperConnectGraphYaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Zookeeper, "Zookeeper_Connect_Yaxis_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_028_validate_Zookeeper_ZookeeperConnectGraph_LegendTitle1() throws EncryptedDocumentException, IOException {
		KafkaZookeeperPage.validateZookeeperConnectGraphLegendTitle1(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Zookeeper, "Zookeeper_Connect_Broker_Header_Title"));
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_029_validate_Zookeeper_ZookeeperConnectGraph_LegendTitle2() throws EncryptedDocumentException, IOException {
		KafkaZookeeperPage.validateZookeeperConnectGraphLegendTitle2(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Zookeeper, "Zookeeper_Connect_Avg_Header_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_030_validate_Zookeeper_ZookeeperConnectGraph_LegendTitle3() throws EncryptedDocumentException, IOException {
		KafkaZookeeperPage.validateZookeeperConnectGraphLegendTitle3(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Zookeeper, "Zookeeper_Connect_Max_Header_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_031_validate_Zookeeper_ZookeeperConnectGraph_ToolTip() throws EncryptedDocumentException, IOException {
		KafkaZookeeperPage.validateZookeeperConnectToolTipTitle();
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_032_validate_Zookeeper_ZookeeperConnectGraph_ExpandViewXAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaZookeeperPage.validateZookeeperConnectExpandViewXAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_033_validate_Zookeeper_ZookeeperConnectGraph_ExpandViewYAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaZookeeperPage.validateZookeeperConnectExpandViewYAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_034_validate_Zookeeper_ZookeeperConnectGraph_ExpandViewWidgetTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaZookeeperPage.validateZookeeperConnectExpandViewWidgetTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_035_validate_Zookeeper_ZookeeperConnectGraph_ExpandViewLegendHeader1() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaZookeeperPage.validateZookeeperConnectExpandViewLegendHeader1();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_036_validate_Zookeeper_ZookeeperConnectGraph_ExpandViewLegendHeader2() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaZookeeperPage.validateZookeeperConnectExpandViewLegendHeader2();
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_037_validate_Zookeeper_ZookeeperConnectGraph_ExpandViewLegendHeader3() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaZookeeperPage.validateZookeeperConnectExpandViewLegendHeader3();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_038_validate_Zookeeper_ZookeeperConnectGraph_ExpandViewZoomInBtn() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaZookeeperPage.validateZookeeperConnectExpandViewZoomIn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_039_validate_Zookeeper_ZookeeperConnectGraph_ExpandViewZoomOutBtn() throws EncryptedDocumentException, IOException, InterruptedException {	 
		KafkaZookeeperPage.validateZookeeperConnectExpandViewZoomOut();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_040_validate_Zookeeper_ZookeeperConnectGraph_ExpandViewWidgetDragDrop() throws EncryptedDocumentException, IOException, InterruptedException {		 
		KafkaZookeeperPage.validateZookeeperConnectExpandViewWidgetDragDrop();
	}	
	
	
/*
 * Zookeeper expire/second Graph	
 */

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_041_validate_Zookeeper_ZookeeperExpirePerSecondGraph_Title() throws EncryptedDocumentException, IOException {
		KafkaZookeeperPage.validateZookeeperExpirePerSecondGraphTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Zookeeper, "Zookeeper_ExpirePerSecond_Graph_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_042_validate_Zookeeper_ZookeeperExpirePerSecondGraph_ZoomIn() throws EncryptedDocumentException, IOException {	
		KafkaZookeeperPage.validateZookeeperExpirePerSecondZoomInBtn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_043_validate_Zookeeper_ZookeeperExpirePerSecondGraph_ZoomOut() throws EncryptedDocumentException, IOException {
		KafkaZookeeperPage.validateZookeeperExpirePerSecondZoomOutBtn();
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_044_validate_Zookeeper_ZookeeperExpirePerSecondGraph_DragAndDrop() throws EncryptedDocumentException, IOException {
		KafkaZookeeperPage.validateZookeeperExpirePerSecondDragAndDrop();
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_045_validate_Zookeeper_ZookeeperExpirePerSecondGraph_XaxisTitle() throws EncryptedDocumentException, IOException {
		KafkaZookeeperPage.validateZookeeperExpirePerSecondGraphXaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Zookeeper, "Zookeeper_ExpirePerSecond_Xaxis_Title"));
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_046_validate_Zookeeper_ZookeeperExpirePerSecondGraph_YaxisTitle() throws EncryptedDocumentException, IOException {
		KafkaZookeeperPage.validateZookeeperExpirePerSecondGraphYaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Zookeeper, "Zookeeper_ExpirePerSecond_Yaxis_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_047_validate_Zookeeper_ZookeeperExpirePerSecondGraph_LegendTitle1() throws EncryptedDocumentException, IOException {
		KafkaZookeeperPage.validateZookeeperExpirePerSecondGraphLegendTitle1(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Zookeeper, "Zookeeper_ExpirePerSecond_Broker_Header_Title"));
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_048_validate_Zookeeper_ZookeeperExpirePerSecondGraph_LegendTitle2() throws EncryptedDocumentException, IOException {
		KafkaZookeeperPage.validateZookeeperExpirePerSecondGraphLegendTitle2(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Zookeeper, "Zookeeper_ExpirePerSecond_Avg_Header_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_049_validate_Zookeeper_ZookeeperExpirePerSecondGraph_LegendTitle3() throws EncryptedDocumentException, IOException {
		KafkaZookeeperPage.validateZookeeperExpirePerSecondGraphLegendTitle3(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Zookeeper, "Zookeeper_ExpirePerSecond_Max_Header_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_050_validate_Zookeeper_ZookeeperExpirePerSecondGraph_ToolTip() throws EncryptedDocumentException, IOException {
		KafkaZookeeperPage.validateZookeeperExpirePerSecondToolTipTitle();
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_051_validate_Zookeeper_ZookeeperExpirePerSecondGraph_ExpandViewXAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaZookeeperPage.validateZookeeperExpirePerSecondExpandViewXAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_052_validate_Zookeeper_ZookeeperExpirePerSecondGraph_ExpandViewYAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaZookeeperPage.validateZookeeperExpirePerSecondExpandViewYAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_053_validate_Zookeeper_ZookeeperExpirePerSecondGraph_ExpandViewWidgetTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaZookeeperPage.validateZookeeperExpirePerSecondExpandViewWidgetTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_054_validate_Zookeeper_ZookeeperExpirePerSecondGraph_ExpandViewLegendHeader1() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaZookeeperPage.validateZookeeperExpirePerSecondExpandViewLegendHeader1();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_055_validate_Zookeeper_ZookeeperExpirePerSecondGraph_ExpandViewLegendHeader2() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaZookeeperPage.validateZookeeperExpirePerSecondExpandViewLegendHeader2();
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_056_validate_Zookeeper_ZookeeperExpirePerSecondGraph_ExpandViewLegendHeader3() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaZookeeperPage.validateZookeeperExpirePerSecondExpandViewLegendHeader3();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_057_validate_Zookeeper_ZookeeperExpirePerSecondGraph_ExpandViewZoomInBtn() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaZookeeperPage.validateZookeeperExpirePerSecondExpandViewZoomIn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_058_validate_Zookeeper_ZookeeperExpirePerSecondGraph_ExpandViewZoomOutBtn() throws EncryptedDocumentException, IOException, InterruptedException {	 
		KafkaZookeeperPage.validateZookeeperExpirePerSecondExpandViewZoomOut();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_059_validate_Zookeeper_ZookeeperExpirePerSecondGraph_ExpandViewWidgetDragDrop() throws EncryptedDocumentException, IOException, InterruptedException {		 
		KafkaZookeeperPage.validateZookeeperExpirePerSecondExpandViewWidgetDragDrop();
	}	
	
/*
 * Zookeeper Auth Failure Graph	
 */

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_060_validate_Zookeeper_ZookeeperAuthFailureGraph_Title() throws EncryptedDocumentException, IOException {
		KafkaZookeeperPage.validateZookeeperAuthFailureGraphTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Zookeeper, "Zookeeper_AuthFailure_Graph_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_061_validate_Zookeeper_ZookeeperAuthFailureGraph_ZoomIn() throws EncryptedDocumentException, IOException {	
		KafkaZookeeperPage.validateZookeeperAuthFailureZoomInBtn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_062_validate_Zookeeper_ZookeeperAuthFailureGraph_ZoomOut() throws EncryptedDocumentException, IOException {
		KafkaZookeeperPage.validateZookeeperAuthFailureZoomOutBtn();
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_063_validate_Zookeeper_ZookeeperAuthFailureGraph_DragAndDrop() throws EncryptedDocumentException, IOException {
		KafkaZookeeperPage.validateZookeeperAuthFailureDragAndDrop();
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_064_validate_Zookeeper_ZookeeperAuthFailureGraph_XaxisTitle() throws EncryptedDocumentException, IOException {
		KafkaZookeeperPage.validateZookeeperAuthFailureGraphXaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Zookeeper, "Zookeeper_AuthFailure_Xaxis_Title"));
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_065_validate_Zookeeper_ZookeeperAuthFailureGraph_YaxisTitle() throws EncryptedDocumentException, IOException {
		KafkaZookeeperPage.validateZookeeperAuthFailureGraphYaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Zookeeper, "Zookeeper_AuthFailure_Yaxis_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_067_validate_Zookeeper_ZookeeperAuthFailureGraph_LegendTitle1() throws EncryptedDocumentException, IOException {
		KafkaZookeeperPage.validateZookeeperAuthFailureGraphLegendTitle1(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Zookeeper, "Zookeeper_AuthFailure_Broker_Header_Title"));
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_068_validate_Zookeeper_ZookeeperAuthFailureGraph_LegendTitle2() throws EncryptedDocumentException, IOException {
		KafkaZookeeperPage.validateZookeeperAuthFailureGraphLegendTitle2(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Zookeeper, "Zookeeper_AuthFailure_Avg_Header_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_069_validate_Zookeeper_ZookeeperAuthFailureGraph_LegendTitle3() throws EncryptedDocumentException, IOException {
		KafkaZookeeperPage.validateZookeeperAuthFailureGraphLegendTitle3(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Zookeeper, "Zookeeper_AuthFailure_Max_Header_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_070_validate_Zookeeper_ZookeeperAuthFailureGraph_ToolTip() throws EncryptedDocumentException, IOException {
		KafkaZookeeperPage.validateZookeeperAuthFailureToolTipTitle();
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_071_validate_Zookeeper_ZookeeperAuthFailureGraph_ExpandViewXAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaZookeeperPage.validateZookeeperAuthFailureExpandViewXAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_072_validate_Zookeeper_ZookeeperAuthFailureGraph_ExpandViewYAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaZookeeperPage.validateZookeeperAuthFailureExpandViewYAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_073_validate_Zookeeper_ZookeeperAuthFailureGraph_ExpandViewWidgetTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaZookeeperPage.validateZookeeperAuthFailureExpandViewWidgetTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_074_validate_Zookeeper_ZookeeperAuthFailureGraph_ExpandViewLegendHeader1() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaZookeeperPage.validateZookeeperAuthFailureExpandViewLegendHeader1();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_075_validate_Zookeeper_ZookeeperAuthFailureGraph_ExpandViewLegendHeader2() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaZookeeperPage.validateZookeeperAuthFailureExpandViewLegendHeader2();
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_076_validate_Zookeeper_ZookeeperAuthFailureGraph_ExpandViewLegendHeader3() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaZookeeperPage.validateZookeeperAuthFailureExpandViewLegendHeader3();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_077_validate_Zookeeper_ZookeeperAuthFailureGraph_ExpandViewZoomInBtn() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaZookeeperPage.validateZookeeperAuthFailureExpandViewZoomIn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_078_validate_Zookeeper_ZookeeperAuthFailureGraph_ExpandViewZoomOutBtn() throws EncryptedDocumentException, IOException, InterruptedException {	 
		KafkaZookeeperPage.validateZookeeperAuthFailureExpandViewZoomOut();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_079_validate_Zookeeper_ZookeeperAuthFailureGraph_ExpandViewWidgetDragDrop() throws EncryptedDocumentException, IOException, InterruptedException {		 
		KafkaZookeeperPage.validateZookeeperAuthFailureExpandViewWidgetDragDrop();
	}	
	
/*
 * Zookeeper read only connect Graph	
 */

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_080_validate_Zookeeper_ZookeeperReadOnlyConnectGraph_Title() throws EncryptedDocumentException, IOException {
		KafkaZookeeperPage.validateZookeeperReadOnlyConnectGraphTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Zookeeper, "Zookeeper_ReadOnlyConnect_Graph_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_081_validate_Zookeeper_ZookeeperReadOnlyConnectGraph_ZoomIn() throws EncryptedDocumentException, IOException {	
		KafkaZookeeperPage.validateZookeeperReadOnlyConnectZoomInBtn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_082_validate_Zookeeper_ZookeeperReadOnlyConnectGraph_ZoomOut() throws EncryptedDocumentException, IOException {
		KafkaZookeeperPage.validateZookeeperReadOnlyConnectZoomOutBtn();
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_083_validate_Zookeeper_ZookeeperReadOnlyConnectGraph_DragAndDrop() throws EncryptedDocumentException, IOException {
		KafkaZookeeperPage.validateZookeeperReadOnlyConnectDragAndDrop();
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_084_validate_Zookeeper_ZookeeperReadOnlyConnectGraph_XaxisTitle() throws EncryptedDocumentException, IOException {
		KafkaZookeeperPage.validateZookeeperReadOnlyConnectGraphXaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Zookeeper, "Zookeeper_ReadOnlyConnect_Xaxis_Title"));
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_085_validate_Zookeeper_ZookeeperReadOnlyConnectGraph_YaxisTitle() throws EncryptedDocumentException, IOException {
		KafkaZookeeperPage.validateZookeeperReadOnlyConnectGraphYaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Zookeeper, "Zookeeper_ReadOnlyConnect_Yaxis_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_086_validate_Zookeeper_ZookeeperReadOnlyConnectGraph_LegendTitle1() throws EncryptedDocumentException, IOException {
		KafkaZookeeperPage.validateZookeeperReadOnlyConnectGraphLegendTitle1(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Zookeeper, "Zookeeper_ReadOnlyConnect_Broker_Header_Title"));
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_087_validate_Zookeeper_ZookeeperReadOnlyConnectGraph_LegendTitle2() throws EncryptedDocumentException, IOException {
		KafkaZookeeperPage.validateZookeeperReadOnlyConnectGraphLegendTitle2(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Zookeeper, "Zookeeper_ReadOnlyConnect_Avg_Header_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_088_validate_Zookeeper_ZookeeperReadOnlyConnectGraph_LegendTitle3() throws EncryptedDocumentException, IOException {
		KafkaZookeeperPage.validateZookeeperReadOnlyConnectGraphLegendTitle3(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Zookeeper, "Zookeeper_ReadOnlyConnect_Max_Header_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_089_validate_Zookeeper_ZookeeperReadOnlyConnectGraph_ToolTip() throws EncryptedDocumentException, IOException {
		KafkaZookeeperPage.validateZookeeperReadOnlyConnectToolTipTitle();
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_090_validate_Zookeeper_ZookeeperReadOnlyConnectGraph_ExpandViewXAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaZookeeperPage.validateZookeeperReadOnlyConnectExpandViewXAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_091_validate_Zookeeper_ZookeeperReadOnlyConnectGraph_ExpandViewYAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaZookeeperPage.validateZookeeperReadOnlyConnectExpandViewYAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_092_validate_Zookeeper_ZookeeperReadOnlyConnectGraph_ExpandViewWidgetTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaZookeeperPage.validateZookeeperReadOnlyConnectExpandViewWidgetTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_093_validate_Zookeeper_ZookeeperReadOnlyConnectGraph_ExpandViewLegendHeader1() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaZookeeperPage.validateZookeeperReadOnlyConnectExpandViewLegendHeader1();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_094_validate_Zookeeper_ZookeeperReadOnlyConnectGraph_ExpandViewLegendHeader2() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaZookeeperPage.validateZookeeperReadOnlyConnectExpandViewLegendHeader2();
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_095_validate_Zookeeper_ZookeeperReadOnlyConnectGraph_ExpandViewLegendHeader3() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaZookeeperPage.validateZookeeperReadOnlyConnectExpandViewLegendHeader3();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_096_validate_Zookeeper_ZookeeperReadOnlyConnectGraph_ExpandViewZoomInBtn() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaZookeeperPage.validateZookeeperReadOnlyConnectExpandViewZoomIn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_097_validate_Zookeeper_ZookeeperReadOnlyConnectGraph_ExpandViewZoomOutBtn() throws EncryptedDocumentException, IOException, InterruptedException {	 
		KafkaZookeeperPage.validateZookeeperReadOnlyConnectExpandViewZoomOut();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_098_validate_Zookeeper_ZookeeperReadOnlyConnectGraph_ExpandViewWidgetDragDrop() throws EncryptedDocumentException, IOException, InterruptedException {		 
		KafkaZookeeperPage.validateZookeeperReadOnlyConnectExpandViewWidgetDragDrop();
	}	
	
/*
 * Zookeeper SASL Authentication Graph	
 */

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_099_validate_Zookeeper_ZookeeperSASLAuthenticationGraph_Title() throws EncryptedDocumentException, IOException {
		KafkaZookeeperPage.validateZookeeperSASLAuthenticationGraphTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Zookeeper, "Zookeeper_SASLAuthentication_Graph_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_100_validate_Zookeeper_ZookeeperSASLAuthenticationGraph_ZoomIn() throws EncryptedDocumentException, IOException {	
		KafkaZookeeperPage.validateZookeeperSASLAuthenticationZoomInBtn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_101_validate_Zookeeper_ZookeeperSASLAuthenticationGraph_ZoomOut() throws EncryptedDocumentException, IOException {
		KafkaZookeeperPage.validateZookeeperSASLAuthenticationZoomOutBtn();
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_102_validate_Zookeeper_ZookeeperSASLAuthenticationGraph_DragAndDrop() throws EncryptedDocumentException, IOException {
		KafkaZookeeperPage.validateZookeeperSASLAuthenticationDragAndDrop();
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_103_validate_Zookeeper_ZookeeperSASLAuthenticationGraph_XaxisTitle() throws EncryptedDocumentException, IOException {
		KafkaZookeeperPage.validateZookeeperSASLAuthenticationGraphXaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Zookeeper, "Zookeeper_SASLAuthentication_Xaxis_Title"));
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_104_validate_Zookeeper_ZookeeperSASLAuthenticationGraph_YaxisTitle() throws EncryptedDocumentException, IOException {
		KafkaZookeeperPage.validateZookeeperSASLAuthenticationGraphYaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Zookeeper, "Zookeeper_SASLAuthentication_Yaxis_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_105_validate_Zookeeper_ZookeeperSASLAuthenticationGraph_LegendTitle1() throws EncryptedDocumentException, IOException {
		KafkaZookeeperPage.validateZookeeperSASLAuthenticationGraphLegendTitle1(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Zookeeper, "Zookeeper_SASLAuthentication_Broker_Header_Title"));
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_106_validate_Zookeeper_ZookeeperSASLAuthenticationGraph_LegendTitle2() throws EncryptedDocumentException, IOException {
		KafkaZookeeperPage.validateZookeeperSASLAuthenticationGraphLegendTitle2(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Zookeeper, "Zookeeper_SASLAuthentication_Avg_Header_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_107_validate_Zookeeper_ZookeeperSASLAuthenticationGraph_LegendTitle3() throws EncryptedDocumentException, IOException {
		KafkaZookeeperPage.validateZookeeperSASLAuthenticationGraphLegendTitle3(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Zookeeper, "Zookeeper_SASLAuthentication_Max_Header_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_108_validate_Zookeeper_ZookeeperSASLAuthenticationGraph_ToolTip() throws EncryptedDocumentException, IOException {
		KafkaZookeeperPage.validateZookeeperSASLAuthenticationToolTipTitle();
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_109_validate_Zookeeper_ZookeeperSASLAuthenticationGraph_ExpandViewXAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaZookeeperPage.validateZookeeperSASLAuthenticationExpandViewXAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_110_validate_Zookeeper_ZookeeperSASLAuthenticationGraph_ExpandViewYAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaZookeeperPage.validateZookeeperSASLAuthenticationExpandViewYAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_111_validate_Zookeeper_ZookeeperSASLAuthenticationGraph_ExpandViewWidgetTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaZookeeperPage.validateZookeeperSASLAuthenticationExpandViewWidgetTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_112_validate_Zookeeper_ZookeeperSASLAuthenticationGraph_ExpandViewLegendHeader1() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaZookeeperPage.validateZookeeperSASLAuthenticationExpandViewLegendHeader1();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_113_validate_Zookeeper_ZookeeperSASLAuthenticationGraph_ExpandViewLegendHeader2() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaZookeeperPage.validateZookeeperSASLAuthenticationExpandViewLegendHeader2();
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_114_validate_Zookeeper_ZookeeperSASLAuthenticationGraph_ExpandViewLegendHeader3() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaZookeeperPage.validateZookeeperSASLAuthenticationExpandViewLegendHeader3();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_115_validate_Zookeeper_ZookeeperSASLAuthenticationGraph_ExpandViewZoomInBtn() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaZookeeperPage.validateZookeeperSASLAuthenticationExpandViewZoomIn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_116_validate_Zookeeper_ZookeeperSASLAuthenticationGraph_ExpandViewZoomOutBtn() throws EncryptedDocumentException, IOException, InterruptedException {	 
		KafkaZookeeperPage.validateZookeeperSASLAuthenticationExpandViewZoomOut();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_117_validate_Zookeeper_ZookeeperSASLAuthenticationGraph_ExpandViewWidgetDragDrop() throws EncryptedDocumentException, IOException, InterruptedException {		 
		KafkaZookeeperPage.validateZookeeperSASLAuthenticationExpandViewWidgetDragDrop();
	}	
	
	
	
	@Test(groups= {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_118_validate_ConsumerTab_when_TimeRangeisChangedTo_5min() {
		commonPage.selectTheTimeLineFromCalender(IPathConstant.fiveMinutesTimeRange);
		KafkaZookeeperPage.validateXaxisValuesForKafkaZookeeperPage();
	}
	@Test(groups= {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_119_validate_ConsumerTab_when_TimeRangeisChangedTo_15min() {
		commonPage.selectTheTimeLineFromCalender(IPathConstant.fifteenMinutesTimeRange);
		KafkaZookeeperPage.validateXaxisValuesForKafkaZookeeperPage();
	}
	@Test(groups= {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_120_validate_ConsumerTab_when_TimeRangeisChangedTo_30min() {
		commonPage.selectTheTimeLineFromCalender(IPathConstant.thirtyMinutesTimeRange);
		KafkaZookeeperPage.validateXaxisValuesForKafkaZookeeperPage();
	}
	@Test(groups= {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_121_validate_ConsumerTab_when_TimeRangeisChangedTo_60min() {
		commonPage.selectTheTimeLineFromCalender(IPathConstant.sixtyMinutesTimeRange);
		KafkaZookeeperPage.validateXaxisValuesForKafkaZookeeperPage();
	}
	@Test(groups= {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_122_validate_ConsumerTab_when_TimeRangeisChangedTo_3hour() {
		commonPage.selectTheTimeLineFromCalender(IPathConstant.threeHoursTimeRange);
		KafkaZookeeperPage.validateXaxisValuesForKafkaZookeeperPage();
	}
	@Test(groups= {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_123_validate_ConsumerTab_when_TimeRangeisChangedTo_6hour() {
		commonPage.selectTheTimeLineFromCalender(IPathConstant.sixHoursTimeRange);
		KafkaZookeeperPage.validateXaxisValuesForKafkaZookeeperPage();
	}
	@Test(groups= {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_124_validate_ConsumerTab_when_TimeRangeisChangedTo_1Day() {
		commonPage.selectTheTimeLineFromCalender(IPathConstant.oneDayTimeRange);
		KafkaZookeeperPage.validateXaxisValuesForKafkaZookeeperPage();
	}
	@Test(groups= {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_125_validate_ConsumerTab_when_TimeRangeisChangedTo_1Week() {
		commonPage.selectTheTimeLineFromCalender(IPathConstant.oneWeekTimeRange);
		KafkaZookeeperPage.validateXaxisValuesForKafkaZookeeperPage();
	}
	@Test(groups= {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_126_validate_ConsumerTab_when_TimeRangeisChangedTo_1Month() {
		commonPage.selectTheTimeLineFromCalender(IPathConstant.oneMonthTimeRange);
		KafkaZookeeperPage.validateXaxisValuesForKafkaZookeeperPage();
	}
	@Test(groups= {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_127_validate_ConsumerTab_when_TimeRangeisChangedTo_4hour() throws EncryptedDocumentException, IOException {
		commonPage.selectTheCustomeTimeLine(IPathConstant.customTimeRange, excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath, IPathConstant.calenderSheet, "customHoursRange"));
		KafkaZookeeperPage.validateTheCustomTimeLine(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath, IPathConstant.calenderSheet, "customHoursRange"));
	}
	
	@Test(groups = {"MQM","UI","Regression"})
	public void TC_128_validate_The_All_Widgets_By_selecting_custom_Time_For_Minutes_Range() throws EncryptedDocumentException, IOException
	{	
		//select the time line from calendar
		commonPage.selectTheCustomeTimeLine(IPathConstant.customTimeRange, excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customMinutesRange") );
				
		//Validate whether the widgets are displaying the proper time line or not
		KafkaZookeeperPage.validateTheCustomTimeLine(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customMinutesRange"));
	}
	@Test(groups = {"MQM","UI","Regression"})
	public void TC_129_validate_The_All_Widgets_By_selecting_custom_Time_For_Hours_Range() throws EncryptedDocumentException, IOException
	{	
		//select the time line from calendar
		commonPage.selectTheCustomeTimeLine(IPathConstant.customTimeRange, excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customHoursRange"));

		//Validate whether the widgets are displaying the proper time line or not
		KafkaZookeeperPage.validateTheCustomTimeLine(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customHoursRange"));
	}
	@Test(groups = {"MQM","UI","Regression"})
	public void TC_130_validate_The_All_Widgets_By_selecting_custom_Time_For_Days_Range() throws EncryptedDocumentException, IOException
	{
		//select the time line from calendar
		commonPage.selectTheCustomeTimeLine(IPathConstant.customTimeRange, excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customDaysRange"));
		
		//Validate whether the widgets are displaying the proper time line or not
		KafkaZookeeperPage.validateTheCustomTimeLine(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customDaysRange"));
	}
	
	@Test(groups = {"MQM","UI","Regression"})
	public void TC_131_validate_The_All_Widgets_By_selecting_custom_Time_For_Future_date()
	{
		//select the time line from calendar
		commonPage.selectTheTimeLineFromCalender(IPathConstant.fiveMinutesTimeRange);
		
		//select the future time line from calendar
		commonPage.validateTheFutureTimeLine();
	}

	
}
