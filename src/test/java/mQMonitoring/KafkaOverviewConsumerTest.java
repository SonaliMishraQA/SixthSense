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
import objectRepository.MQM.KafkaOverviewConsumerPage;

public class KafkaOverviewConsumerTest extends BaseClass
{
	GenericMethods util = new GenericMethods();
	CommonPage commonPage;
	KafkaOverviewConsumerPage KafkaOverviewConsumerPage;
	ExcelUtility excel = new ExcelUtility();	

	@BeforeMethod
	public void Overview() throws EncryptedDocumentException, IOException 
	{
		commonPage = new CommonPage(page);
		KafkaOverviewConsumerPage = new  KafkaOverviewConsumerPage(page);
		excel = new ExcelUtility();
	}	
/**
 * Consumer Tab
 * @throws EncryptedDocumentException
 * @throws IOException
 */
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_001_validate_Consumer_Tab_Title() throws EncryptedDocumentException, IOException {
		commonPage.navigateToMQM();	
		String messageQueue = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Load, "MessageQueue");
		KafkaOverviewConsumerPage.navigateToKafka(messageQueue);
		page.waitForLoadState(LoadState.NETWORKIDLE);
		page.waitForTimeout(3000);
		String application =excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Load, "Application");
		KafkaOverviewConsumerPage.selectServiceName(application);
		commonPage.selectTheTimeLineFromCalender(IPathConstant.oneMonthTimeRange);
		page.reload();
		KafkaOverviewConsumerPage.clickOnConsumerTab();
		KafkaOverviewConsumerPage.validateConsumerTabTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Consumer_Tab_Title"));
	}
	
	
/*
 * Average Fetch Size Graph	
 */

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_002_validate_Consumer_AverageFetchSizeGraph_Title() throws EncryptedDocumentException, IOException {
		KafkaOverviewConsumerPage.validateAverageFetchSizeGraphTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Consumer_AverageFetchSize_Graph_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_003_validate_Consumer_AverageFetchSizeGraph_ZoomIn() throws EncryptedDocumentException, IOException {	
		KafkaOverviewConsumerPage.validateAverageFetchSizeZoomInBtn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_004_validate_Consumer_AverageFetchSizeGraph_ZoomOut() throws EncryptedDocumentException, IOException {
		KafkaOverviewConsumerPage.validateAverageFetchSizeZoomOutBtn();
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_005_validate_Consumer_AverageFetchSizeGraph_DragAndDrop() throws EncryptedDocumentException, IOException {
		KafkaOverviewConsumerPage.validateAverageFetchSizeDragAndDrop();
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_006_validate_Consumer_AverageFetchSizeGraph_XaxisTitle() throws EncryptedDocumentException, IOException {
		KafkaOverviewConsumerPage.validateAverageFetchSizeGraphXaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Consumer_AverageFetchSize_Xaxis_Title"));
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_007_validate_Consumer_AverageFetchSizeGraph_YaxisTitle() throws EncryptedDocumentException, IOException {
		KafkaOverviewConsumerPage.validateAverageFetchSizeGraphYaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Consumer_AverageFetchSize_Yaxis_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_008_validate_Consumer_AverageFetchSizeGraph_LegendTitle1() throws EncryptedDocumentException, IOException {
		KafkaOverviewConsumerPage.validateAverageFetchSizeGraphLegendTitle1(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Consumer_AverageFetchSize_Consumer_Header_Title"));
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_009_validate_Consumer_AverageFetchSizeGraph_LegendTitle2() throws EncryptedDocumentException, IOException {
		KafkaOverviewConsumerPage.validateAverageFetchSizeGraphLegendTitle2(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Consumer_AverageFetchSize_Avg_Header_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_010_validate_Consumer_AverageFetchSizeGraph_LegendTitle3() throws EncryptedDocumentException, IOException {
		KafkaOverviewConsumerPage.validateAverageFetchSizeGraphLegendTitle3(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Consumer_AverageFetchSize_Max_Header_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_011_validate_Consumer_AverageFetchSizeGraph_ToolTip() throws EncryptedDocumentException, IOException {
		KafkaOverviewConsumerPage.validateAverageFetchSizeToolTipTitle();
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_012_validate_Consumer_AverageFetchSizeGraph_ExpandViewXAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaOverviewConsumerPage.validateAverageFetchSizeExpandViewXAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_013_validate_Consumer_AverageFetchSizeGraph_ExpandViewYAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaOverviewConsumerPage.validateAverageFetchSizeExpandViewYAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_014_validate_Consumer_AverageFetchSizeGraph_ExpandViewWidgetTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaOverviewConsumerPage.validateAverageFetchSizeExpandViewWidgetTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_015_validate_Consumer_AverageFetchSizeGraph_ExpandViewLegendHeader1() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaOverviewConsumerPage.validateAverageFetchSizeExpandViewLegendHeader1();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_016_validate_Consumer_AverageFetchSizeGraph_ExpandViewLegendHeader2() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaOverviewConsumerPage.validateAverageFetchSizeExpandViewLegendHeader2();
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_017_validate_Consumer_AverageFetchSizeGraph_ExpandViewLegendHeader3() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaOverviewConsumerPage.validateAverageFetchSizeExpandViewLegendHeader3();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_018_validate_Consumer_AverageFetchSizeGraph_ExpandViewZoomInBtn() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaOverviewConsumerPage.validateAverageFetchSizeExpandViewZoomIn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_019_validate_Consumer_AverageFetchSizeGraph_ExpandViewZoomOutBtn() throws EncryptedDocumentException, IOException, InterruptedException {	 
		KafkaOverviewConsumerPage.validateAverageFetchSizeExpandViewZoomOut();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_020_validate_Consumer_AverageFetchSizeGraph_ExpandViewWidgetDragDrop() throws EncryptedDocumentException, IOException, InterruptedException {		 
		KafkaOverviewConsumerPage.validateAverageFetchSizeExpandViewWidgetDragDrop();
	}	

/*
 * Response rate Graph	
 */

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_021_validate_Consumer_ResponseRateGraph_Title() throws EncryptedDocumentException, IOException {
		KafkaOverviewConsumerPage.validateResponseRateGraphTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Consumer_ResponseRate_Graph_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_022_validate_Consumer_ResponseRateGraph_ZoomIn() throws EncryptedDocumentException, IOException {	
		page.waitForTimeout(2000);
		KafkaOverviewConsumerPage.validateResponseRateZoomInBtn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_023_validate_Consumer_ResponseRateGraph_ZoomOut() throws EncryptedDocumentException, IOException {
		KafkaOverviewConsumerPage.validateResponseRateZoomOutBtn();
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_024_validate_Consumer_ResponseRateGraph_DragAndDrop() throws EncryptedDocumentException, IOException {
		KafkaOverviewConsumerPage.validateResponseRateDragAndDrop();
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_025_validate_Consumer_ResponseRateGraph_XaxisTitle() throws EncryptedDocumentException, IOException {
		KafkaOverviewConsumerPage.validateResponseRateGraphXaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Consumer_ResponseRate_Xaxis_Title"));
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_026_validate_Consumer_ResponseRateGraph_YaxisTitle() throws EncryptedDocumentException, IOException {
		KafkaOverviewConsumerPage.validateResponseRateGraphYaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Consumer_ResponseRate_Yaxis_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_027_validate_Consumer_ResponseRateGraph_LegendTitle1() throws EncryptedDocumentException, IOException {
		KafkaOverviewConsumerPage.validateResponseRateGraphLegendTitle1(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Consumer_ResponseRate_Consumer_Header_Title"));
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_028_validate_Consumer_ResponseRateGraph_LegendTitle2() throws EncryptedDocumentException, IOException {
		KafkaOverviewConsumerPage.validateResponseRateGraphLegendTitle2(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Consumer_ResponseRate_Avg_Header_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_029_validate_Consumer_ResponseRateGraph_LegendTitle3() throws EncryptedDocumentException, IOException {
		KafkaOverviewConsumerPage.validateResponseRateGraphLegendTitle3(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Consumer_ResponseRate_Max_Header_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_030_validate_Consumer_ResponseRateGraph_ToolTip() throws EncryptedDocumentException, IOException {
		KafkaOverviewConsumerPage.validateResponseRateToolTipTitle();
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_031_validate_Consumer_ResponseRateGraph_ExpandViewXAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaOverviewConsumerPage.validateResponseRateExpandViewXAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_032_validate_Consumer_ResponseRateGraph_ExpandViewYAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaOverviewConsumerPage.validateResponseRateExpandViewYAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_033_validate_Consumer_ResponseRateGraph_ExpandViewWidgetTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaOverviewConsumerPage.validateResponseRateExpandViewWidgetTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_034_validate_Consumer_ResponseRateGraph_ExpandViewLegendHeader1() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaOverviewConsumerPage.validateResponseRateExpandViewLegendHeader1();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_035_validate_Consumer_ResponseRateGraph_ExpandViewLegendHeader2() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaOverviewConsumerPage.validateResponseRateExpandViewLegendHeader2();
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_036_validate_Consumer_ResponseRateGraph_ExpandViewLegendHeader3() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaOverviewConsumerPage.validateResponseRateExpandViewLegendHeader3();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_037_validate_Consumer_ResponseRateGraph_ExpandViewZoomInBtn() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaOverviewConsumerPage.validateResponseRateExpandViewZoomIn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_038_validate_Consumer_ResponseRateGraph_ExpandViewZoomOutBtn() throws EncryptedDocumentException, IOException, InterruptedException {	 
		KafkaOverviewConsumerPage.validateResponseRateExpandViewZoomOut();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_039_validate_Consumer_ResponseRateGraph_ExpandViewWidgetDragDrop() throws EncryptedDocumentException, IOException, InterruptedException {		 
		KafkaOverviewConsumerPage.validateResponseRateExpandViewWidgetDragDrop();
	}	
	
/*
 * Consumer Lag Graph	
 */

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_040_validate_Consumer_ConsumerLagGraph_Title() throws EncryptedDocumentException, IOException {
		KafkaOverviewConsumerPage.validateConsumerLagGraphTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Consumer_ConsumerLag_Graph_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_041_validate_Consumer_ConsumerLagGraph_ZoomIn() throws EncryptedDocumentException, IOException {	
		KafkaOverviewConsumerPage.validateConsumerLagZoomInBtn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_042_validate_Consumer_ConsumerLagGraph_ZoomOut() throws EncryptedDocumentException, IOException {
		KafkaOverviewConsumerPage.validateConsumerLagZoomOutBtn();
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_043_validate_Consumer_ConsumerLagGraph_DragAndDrop() throws EncryptedDocumentException, IOException {
		KafkaOverviewConsumerPage.validateConsumerLagDragAndDrop();
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_044_validate_Consumer_ConsumerLagGraph_XaxisTitle() throws EncryptedDocumentException, IOException {
		KafkaOverviewConsumerPage.validateConsumerLagGraphXaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Consumer_ConsumerLag_Xaxis_Title"));
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_045_validate_Consumer_ConsumerLagGraph_YaxisTitle() throws EncryptedDocumentException, IOException {
		KafkaOverviewConsumerPage.validateConsumerLagGraphYaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Consumer_ConsumerLag_Yaxis_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_046_validate_Consumer_ConsumerLagGraph_LegendTitle1() throws EncryptedDocumentException, IOException {
		KafkaOverviewConsumerPage.validateConsumerLagGraphLegendTitle1(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Consumer_ConsumerLag_Consumer_Header_Title"));
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_047_validate_Consumer_ConsumerLagGraph_LegendTitle2() throws EncryptedDocumentException, IOException {
		KafkaOverviewConsumerPage.validateConsumerLagGraphLegendTitle2(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Consumer_ConsumerLag_Avg_Header_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_048_validate_Consumer_ConsumerLagGraph_LegendTitle3() throws EncryptedDocumentException, IOException {
		KafkaOverviewConsumerPage.validateConsumerLagGraphLegendTitle3(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Consumer_ConsumerLag_Max_Header_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_049_validate_Consumer_ConsumerLagGraph_ToolTip() throws EncryptedDocumentException, IOException {
		KafkaOverviewConsumerPage.validateConsumerLagToolTipTitle();
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_050_validate_Consumer_ConsumerLagGraph_ExpandViewXAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaOverviewConsumerPage.validateConsumerLagExpandViewXAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_051_validate_Consumer_ConsumerLagGraph_ExpandViewYAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaOverviewConsumerPage.validateConsumerLagExpandViewYAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_052_validate_Consumer_ConsumerLagGraph_ExpandViewWidgetTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaOverviewConsumerPage.validateConsumerLagExpandViewWidgetTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_053_validate_Consumer_ConsumerLagGraph_ExpandViewLegendHeader1() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaOverviewConsumerPage.validateConsumerLagExpandViewLegendHeader1();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_054_validate_Consumer_ConsumerLagGraph_ExpandViewLegendHeader2() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaOverviewConsumerPage.validateConsumerLagExpandViewLegendHeader2();
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_055_validate_Consumer_ConsumerLagGraph_ExpandViewLegendHeader3() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaOverviewConsumerPage.validateConsumerLagExpandViewLegendHeader3();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_056_validate_Consumer_ConsumerLagGraph_ExpandViewZoomInBtn() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaOverviewConsumerPage.validateConsumerLagExpandViewZoomIn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_057_validate_Consumer_ConsumerLagGraph_ExpandViewZoomOutBtn() throws EncryptedDocumentException, IOException, InterruptedException {	 
		KafkaOverviewConsumerPage.validateConsumerLagExpandViewZoomOut();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_058_validate_Consumer_ConsumerLagGraph_ExpandViewWidgetDragDrop() throws EncryptedDocumentException, IOException, InterruptedException {		 
		KafkaOverviewConsumerPage.validateConsumerLagExpandViewWidgetDragDrop();
	}	
	
/*
 * Message consumed Graph	
 */

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_059_validate_Consumer_MessageConsumedGraph_Title() throws EncryptedDocumentException, IOException {
		KafkaOverviewConsumerPage.validateMessageConsumedGraphTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Consumer_MessageConsumed_Graph_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_060_validate_Consumer_MessageConsumedGraph_ZoomIn() throws EncryptedDocumentException, IOException {	
		KafkaOverviewConsumerPage.validateMessageConsumedZoomInBtn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_061_validate_Consumer_MessageConsumedGraph_ZoomOut() throws EncryptedDocumentException, IOException {
		KafkaOverviewConsumerPage.validateMessageConsumedZoomOutBtn();
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_062_validate_Consumer_MessageConsumedGraph_DragAndDrop() throws EncryptedDocumentException, IOException {
		KafkaOverviewConsumerPage.validateMessageConsumedDragAndDrop();
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_063_validate_Consumer_MessageConsumedGraph_XaxisTitle() throws EncryptedDocumentException, IOException {
		KafkaOverviewConsumerPage.validateMessageConsumedGraphXaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Consumer_MessageConsumed_Xaxis_Title"));
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_064_validate_Consumer_MessageConsumedGraph_YaxisTitle() throws EncryptedDocumentException, IOException {
		KafkaOverviewConsumerPage.validateMessageConsumedGraphYaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Consumer_MessageConsumed_Yaxis_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_065_validate_Consumer_MessageConsumedGraph_LegendTitle1() throws EncryptedDocumentException, IOException {
		KafkaOverviewConsumerPage.validateMessageConsumedGraphLegendTitle1(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Consumer_MessageConsumed_Consumer_Header_Title"));
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_066_validate_Consumer_MessageConsumedGraph_LegendTitle2() throws EncryptedDocumentException, IOException {
		KafkaOverviewConsumerPage.validateMessageConsumedGraphLegendTitle2(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Consumer_MessageConsumed_Avg_Header_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_067_validate_Consumer_MessageConsumedGraph_LegendTitle3() throws EncryptedDocumentException, IOException {
		KafkaOverviewConsumerPage.validateMessageConsumedGraphLegendTitle3(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Consumer_MessageConsumed_Max_Header_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_068_validate_Consumer_MessageConsumedGraph_ToolTip() throws EncryptedDocumentException, IOException {
		KafkaOverviewConsumerPage.validateMessageConsumedToolTipTitle();
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_069_validate_Consumer_MessageConsumedGraph_ExpandViewXAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaOverviewConsumerPage.validateMessageConsumedExpandViewXAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_070_validate_Consumer_MessageConsumedGraph_ExpandViewYAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaOverviewConsumerPage.validateMessageConsumedExpandViewYAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_071_validate_Consumer_MessageConsumedGraph_ExpandViewWidgetTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaOverviewConsumerPage.validateMessageConsumedExpandViewWidgetTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_072_validate_Consumer_MessageConsumedGraph_ExpandViewLegendHeader1() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaOverviewConsumerPage.validateMessageConsumedExpandViewLegendHeader1();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_073_validate_Consumer_MessageConsumedGraph_ExpandViewLegendHeader2() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaOverviewConsumerPage.validateMessageConsumedExpandViewLegendHeader2();
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_074_validate_Consumer_MessageConsumedGraph_ExpandViewLegendHeader3() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaOverviewConsumerPage.validateMessageConsumedExpandViewLegendHeader3();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_075_validate_Consumer_MessageConsumedGraph_ExpandViewZoomInBtn() throws EncryptedDocumentException, IOException, InterruptedException {
		KafkaOverviewConsumerPage.validateMessageConsumedExpandViewZoomIn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_076_validate_Consumer_MessageConsumedGraph_ExpandViewZoomOutBtn() throws EncryptedDocumentException, IOException, InterruptedException {	 
		KafkaOverviewConsumerPage.validateMessageConsumedExpandViewZoomOut();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_077_validate_Consumer_MessageConsumedGraph_ExpandViewWidgetDragDrop() throws EncryptedDocumentException, IOException, InterruptedException {		 
		KafkaOverviewConsumerPage.validateMessageConsumedExpandViewWidgetDragDrop();
	}	
	
/*
 * No. Of Consumers Graph	
 */

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_078_validate_Consumer_NoOfConsumersGraph_Title() throws EncryptedDocumentException, IOException {
		KafkaOverviewConsumerPage.validateNoOfConsumersGraphTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Consumer_NoOfConsumers_Graph_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_079_validate_Consumer_NoOfConsumersGraph_ZoomIn() throws EncryptedDocumentException, IOException {	
		KafkaOverviewConsumerPage.validateNoOfConsumersZoomInBtn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_080_validate_Consumer_NoOfConsumersGraph_ZoomOut() throws EncryptedDocumentException, IOException {
		KafkaOverviewConsumerPage.validateNoOfConsumersZoomOutBtn();
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_080_validate_Consumer_NoOfConsumersGraph_ZoomReset() throws EncryptedDocumentException, IOException {
		KafkaOverviewConsumerPage.validateNoOfConsumersZoomResetBtn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_081_validate_Consumer_NoOfConsumersGraph_DragAndDrop() throws EncryptedDocumentException, IOException {
		KafkaOverviewConsumerPage.validateNoOfConsumersDragAndDrop();
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_082_validate_Consumer_NoOfConsumersGraph_XaxisTitle() throws EncryptedDocumentException, IOException {
		KafkaOverviewConsumerPage.validateNoOfConsumersGraphXaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Consumer_NoOfConsumers_Xaxis_Title"));
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_083_validate_Consumer_NoOfConsumersGraph_YaxisTitle() throws EncryptedDocumentException, IOException {
		KafkaOverviewConsumerPage.validateNoOfConsumersGraphYaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Consumer_NoOfConsumers_Yaxis_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_084_validate_Consumer_NoOfConsumersGraph_ToolTip() throws EncryptedDocumentException, IOException {
		KafkaOverviewConsumerPage.validateNoOfConsumersToolTipTitle();
	}

	@Test(groups= {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_085_validate_ConsumerTab_when_TimeRangeisChangedTo_5min() {
		commonPage.selectTheTimeLineFromCalender(IPathConstant.fiveMinutesTimeRange);
		KafkaOverviewConsumerPage.validateXaxisValuesForKafkaOverviewConsumerPage();
	}
	@Test(groups= {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_086_validate_ConsumerTab_when_TimeRangeisChangedTo_15min() {
		commonPage.selectTheTimeLineFromCalender(IPathConstant.fifteenMinutesTimeRange);
		KafkaOverviewConsumerPage.validateXaxisValuesForKafkaOverviewConsumerPage();
	}
	@Test(groups= {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_087_validate_ConsumerTab_when_TimeRangeisChangedTo_30min() {
		commonPage.selectTheTimeLineFromCalender(IPathConstant.thirtyMinutesTimeRange);
		KafkaOverviewConsumerPage.validateXaxisValuesForKafkaOverviewConsumerPage();
	}
	@Test(groups= {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_088_validate_ConsumerTab_when_TimeRangeisChangedTo_60min() {
		commonPage.selectTheTimeLineFromCalender(IPathConstant.sixtyMinutesTimeRange);
		KafkaOverviewConsumerPage.validateXaxisValuesForKafkaOverviewConsumerPage();
	}
	@Test(groups= {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_089_validate_ConsumerTab_when_TimeRangeisChangedTo_3hour() {
		commonPage.selectTheTimeLineFromCalender(IPathConstant.threeHoursTimeRange);
		KafkaOverviewConsumerPage.validateXaxisValuesForKafkaOverviewConsumerPage();
	}
	@Test(groups= {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_090_validate_ConsumerTab_when_TimeRangeisChangedTo_6hour() {
		commonPage.selectTheTimeLineFromCalender(IPathConstant.sixHoursTimeRange);
		KafkaOverviewConsumerPage.validateXaxisValuesForKafkaOverviewConsumerPage();
	}
	@Test(groups= {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_091_validate_ConsumerTab_when_TimeRangeisChangedTo_1Day() {
		commonPage.selectTheTimeLineFromCalender(IPathConstant.oneDayTimeRange);
		KafkaOverviewConsumerPage.validateXaxisValuesForKafkaOverviewConsumerPage();
	}
	@Test(groups= {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_092_validate_ConsumerTab_when_TimeRangeisChangedTo_1Week() {
		commonPage.selectTheTimeLineFromCalender(IPathConstant.oneWeekTimeRange);
		KafkaOverviewConsumerPage.validateXaxisValuesForKafkaOverviewConsumerPage();
	}
	@Test(groups= {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_093_validate_ConsumerTab_when_TimeRangeisChangedTo_1Month() {
		commonPage.selectTheTimeLineFromCalender(IPathConstant.oneMonthTimeRange);
		KafkaOverviewConsumerPage.validateXaxisValuesForKafkaOverviewConsumerPage();
	}
	@Test(groups= {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_094_validate_ConsumerTab_when_TimeRangeisChangedTo_4hour() throws EncryptedDocumentException, IOException {
		commonPage.selectTheCustomeTimeLine(IPathConstant.customTimeRange, excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath, IPathConstant.calenderSheet, "customHoursRange"));
		KafkaOverviewConsumerPage.validateTheCustomTimeLine(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath, IPathConstant.calenderSheet, "customHoursRange"));
	}
	
	@Test(groups = {"MQM","UI","Regression"})
	public void TC_095_validate_The_All_Widgets_By_selecting_custom_Time_For_Minutes_Range() throws EncryptedDocumentException, IOException
	{	
		//select the time line from calendar
		commonPage.selectTheCustomeTimeLine(IPathConstant.customTimeRange, excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customMinutesRange") );
				
		//Validate whether the widgets are displaying the proper time line or not
		KafkaOverviewConsumerPage.validateTheCustomTimeLine(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customMinutesRange"));
	}
	@Test(groups = {"MQM","UI","Regression"})
	public void TC_096_validate_The_All_Widgets_By_selecting_custom_Time_For_Hours_Range() throws EncryptedDocumentException, IOException
	{	
		//select the time line from calendar
		commonPage.selectTheCustomeTimeLine(IPathConstant.customTimeRange, excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customHoursRange"));

		//Validate whether the widgets are displaying the proper time line or not
		KafkaOverviewConsumerPage.validateTheCustomTimeLine(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customHoursRange"));
	}
	@Test(groups = {"MQM","UI","Regression"})
	public void TC_097_validate_The_All_Widgets_By_selecting_custom_Time_For_Days_Range() throws EncryptedDocumentException, IOException
	{
		//select the time line from calendar
		commonPage.selectTheCustomeTimeLine(IPathConstant.customTimeRange, excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customDaysRange"));
		
		//Validate whether the widgets are displaying the proper time line or not
		KafkaOverviewConsumerPage.validateTheCustomTimeLine(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customDaysRange"));
	}
	
	
	@Test(groups = {"MQM","UI","Regression"})
	public void TC_098_validate_The_All_Widgets_By_selecting_custom_Time_For_Future_date()
	{
		//select the time line from calendar
		commonPage.selectTheTimeLineFromCalender(IPathConstant.fiveMinutesTimeRange);
		
		//select the future time line from calendar
		commonPage.validateTheFutureTimeLine();
	}
		
}
