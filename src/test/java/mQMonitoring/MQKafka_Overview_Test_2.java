package mQMonitoring;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.BeforeMethod;


import genericUtilities.ExcelUtility;
import genericUtilities.GenericMethods;
import genericUtilities.IPathConstant;
import objectRepository.CommonPage;
import objectRepository.MQM.MQKafka_Overview_Page;
import playWrightFactory.BaseClass;

public class MQKafka_Overview_Test_2 extends BaseClass
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
//		page.reload();
//		page.waitForTimeout(1000);		
	}
	
/**
 * Producer Tab
 * @throws EncryptedDocumentException
 * @throws IOException
 */
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_207_validate_Producer_Tab_Title() throws EncryptedDocumentException, IOException {
		overviewPage.validateProducerTabTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Producer_Tab_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_208_click_on_Producer_Tab() throws EncryptedDocumentException, IOException {
		overviewPage.clickOnProducerTab();
	}
	
/********************************************************* Request Rate Graph ******************************************************************/
	
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_209_validate_Producer_RequestRateGraph_Title() throws EncryptedDocumentException, IOException {
		 
		overviewPage.clickOnProducerTab();
		overviewPage.validateProducerRequestRateGraphTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Producer_RequestRate_Graph_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_210_validate_Producer_RequestRateGraph_ZoomIn() throws EncryptedDocumentException, IOException {
		 
		overviewPage.clickOnProducerTab();
		overviewPage.validateProducerRequestRateGraphZoomInBtn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_211_validate_Producer_RequestRateGraph_ZoomOut() throws EncryptedDocumentException, IOException {
		 
		overviewPage.clickOnProducerTab();
		overviewPage.validateProducerRequestRateGraphZoomOutBtn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_212_validate_Producer_RequestRateGraph_XaxisValue() throws EncryptedDocumentException, IOException {
	//	page.reload();
		overviewPage.clickOnProducerTab();
		overviewPage.validateProducerRequestRateXaxisValues();
	}	
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_213_validate_Producer_RequestRateGraph_XaxisTitle() throws EncryptedDocumentException, IOException {
		 
		overviewPage.clickOnProducerTab();
		overviewPage.validateProducerRequestRateGraphXaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Producer_RequestRate_Xaxis_Title"));
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_214_validate_Producer_RequestRateGraph_YaxisTitle() throws EncryptedDocumentException, IOException {
		 
		overviewPage.clickOnProducerTab();
		overviewPage.validateProducerRequestRateGraphYaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Producer_RequestRate_Yaxis_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_215_validate_Producer_RequestRateGraph_BrokerHeaderTitle() throws EncryptedDocumentException, IOException {
		 
		overviewPage.clickOnProducerTab();
		overviewPage.validateProducerRequestRateGraphBrokerHeaderTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Producer_RequestRate_Producer_Header_Title"));
	}
		
	/*@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_216_validate_Producer_RequestRateGraph_BrokerHeader_Arrow() throws EncryptedDocumentException, IOException {
		overviewPage.clickOnProducerTab();
		overviewPage.validateProducerRequestRateGraphBrokerHeaderArrow(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Producer_RequestRate_Producer_Header_Title"));
	}*/
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_217_validate_Producer_RequestRateGraph_AvgHeaderTitle() throws EncryptedDocumentException, IOException {
		 
		overviewPage.clickOnProducerTab();
		overviewPage.validateProducerRequestRateGraphAvgHeaderTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Producer_RequestRate_Avg_Header_Title"));
	}
	
	/*@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_218_validate_Producer_RequestRateGraph_AvgHeader_Arrow() throws EncryptedDocumentException, IOException {
		overviewPage.clickOnProducerTab();
		overviewPage.validateProducerRequestRateGraphAvgHeaderArrow(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Producer_RequestRate_Producer_Header_Title"));
	}*/
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_219_validate_Producer_RequestRateGraph_MaxHeaderTitle() throws EncryptedDocumentException, IOException {
		 
		overviewPage.clickOnProducerTab();
		overviewPage.validateProducerRequestRateGraphMaxHeaderTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Producer_RequestRate_Max_Header_Title"));
	}
	
	/*@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_220_validate_Producer_RequestRateGraph_AvgHeader_Arrow() throws EncryptedDocumentException, IOException {
		overviewPage.clickOnProducerTab();
		overviewPage.validateProducerRequestRateGraphAvgHeaderArrow(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Producer_RequestRate_Producer_Header_Title"));
	}*/
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_221_validate_Producer_RequestRateGraph_RowColor1() throws EncryptedDocumentException, IOException {
		 
		overviewPage.clickOnProducerTab();
		overviewPage.validateProducerRequestRateGraphRowColor1(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "rgb(255, 123, 123)"));
	}

	/*@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_222_validate_Producer_RequestRateGraph_WidgetLegend1NameSort() throws EncryptedDocumentException, IOException, InterruptedException {
		 
		overviewPage.clickOnProducerTab();
		overviewPage.validateProducerRequestRateWidgetLegendColumn1();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_223_validate_Producer_RequestRateGraph_WidgetLegend2NameSort() throws EncryptedDocumentException, IOException, InterruptedException {
		 
		overviewPage.clickOnProducerTab();
		overviewPage.validateProducerRequestRateWidgetLegendColumn2();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_224_validate_Producer_RequestRateGraph_WidgetLegend3NameSort() throws EncryptedDocumentException, IOException, InterruptedException {
		 
		overviewPage.clickOnProducerTab();
		overviewPage.validateProducerRequestRateWidgetLegendColumn3();
	}*/
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_225_validate_Producer_RequestRateGraph_ExpandViewXAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		 
		overviewPage.clickOnProducerTab();
		overviewPage.validateProducerRequestRateExpandViewXAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_226_validate_Producer_RequestRateGraph_ExpandViewYAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		 
		overviewPage.clickOnProducerTab();
		overviewPage.validateProducerRequestRateExpandViewYAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_227_validate_Producer_RequestRateGraph_ExpandViewWidgetTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		 
		overviewPage.clickOnProducerTab();
		overviewPage.validateProducerRequestRateExpandViewWidgetTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_228_validate_Producer_RequestRateGraph_ExpandViewLegendHeader1() throws EncryptedDocumentException, IOException, InterruptedException {
		 
		overviewPage.clickOnProducerTab();
		overviewPage.validateProducerRequestRateExpandViewLegendHeader1();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_229_validate_Producer_RequestRateGraph_ExpandViewLegendHeader2() throws EncryptedDocumentException, IOException, InterruptedException {
		 
		overviewPage.clickOnProducerTab();
		overviewPage.validateProducerRequestRateExpandViewLegendHeader2();
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_230_validate_Producer_RequestRateGraph_ExpandViewLegendHeader3() throws EncryptedDocumentException, IOException, InterruptedException {
		 
		overviewPage.clickOnProducerTab();
		overviewPage.validateProducerRequestRateExpandViewLegendHeader3();
	}
	
/*	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_231_validate_Producer_RequestRateGraph_ExpandViewHeader2InfoMessage() throws EncryptedDocumentException, IOException, InterruptedException {
		 
		overviewPage.clickOnProducerTab();
		overviewPage.validateProducerRequestRateExpandViewLegendHeader2InforMessage();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_232_validate_Producer_RequestRateGraph_ExpandViewHeader3InfoMessage() throws EncryptedDocumentException, IOException, InterruptedException {
		 
		overviewPage.clickOnProducerTab();
		overviewPage.validateProducerRequestRateExpandViewLegendHeader3InforMessage();
	}*/
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_233_validate_Producer_RequestRateGraph_ExpandViewZoomInBtn() throws EncryptedDocumentException, IOException, InterruptedException {
		 
		overviewPage.clickOnProducerTab();
		overviewPage.validateProducerRequestRateExpandViewZoomIn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_234_validate_Producer_RequestRateGraph_ExpandViewZoomOutBtn() throws EncryptedDocumentException, IOException, InterruptedException {
		 
		overviewPage.clickOnProducerTab();
		overviewPage.validateProducerRequestRateExpandViewZoomOut();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_235_validate_Producer_RequestRateGraph_ExpandViewWidgetDragDrop() throws EncryptedDocumentException, IOException, InterruptedException {
		 
		overviewPage.clickOnProducerTab();
		overviewPage.validateProducerRequestRateExpandViewWidgetDragDrop();
	}	
	
/*********************************************************Response Rate Graph******************************************************************/	

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_236_validate_Producer_ResponseRateGraph_Title() throws EncryptedDocumentException, IOException {
		 
		overviewPage.clickOnProducerTab();
		overviewPage.validateProducerResponseRateGraphTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Producer_ResponseRate_Graph_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_237_validate_Producer_ResponseRateGraph_ZoomIn() throws EncryptedDocumentException, IOException {
		 
		overviewPage.clickOnProducerTab();
		overviewPage.validateProducerResponseRateGraphZoomInBtn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_238_validate_Producer_ResponseRateGraph_ZoomOut() throws EncryptedDocumentException, IOException {
		 
		overviewPage.clickOnProducerTab();
		overviewPage.validateProducerResponseRateGraphZoomOutBtn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_239_validate_Producer_ResponseRateGraph_XaxisValue() throws EncryptedDocumentException, IOException {
		 
		overviewPage.clickOnProducerTab();
		overviewPage.validateProducerResponseRateXaxisValues();
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_240_validate_Producer_ResponseRateGraph_XaxisTitle() throws EncryptedDocumentException, IOException {
		 
		overviewPage.clickOnProducerTab();
		overviewPage.validateProducerResponseRateGraphXaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Producer_ResponseRate_Xaxis_Title"));
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_241_validate_Producer_ResponseRateGraph_YaxisTitle() throws EncryptedDocumentException, IOException {
		 
		overviewPage.clickOnProducerTab();
		overviewPage.validateProducerResponseRateGraphYaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Producer_ResponseRate_Yaxis_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_242_validate_Producer_ResponseRateGraph_BrokerHeaderTitle() throws EncryptedDocumentException, IOException {
		 
		overviewPage.clickOnProducerTab();
		overviewPage.validateProducerResponseRateGraphBrokerHeaderTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Producer_ResponseRate_Producer_Header_Title"));
	}	
	
	/*@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_243_validate_Producer_ResponseRateGraph_BrokerHeader_Arrow() throws EncryptedDocumentException, IOException {
		overviewPage.clickOnProducerTab();
		overviewPage.validateProducerResponseRateGraphBrokerHeaderArrow(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Producer_ResponseRate_Producer_Header_Title"));
	}*/
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_244_validate_Producer_ResponseRateGraph_AvgHeaderTitle() throws EncryptedDocumentException, IOException {
		 
		overviewPage.clickOnProducerTab();
		overviewPage.validateProducerResponseRateGraphAvgHeaderTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Producer_ResponseRate_Avg_Header_Title"));
	}	
	
	/*@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_245_validate_Producer_ResponseRateGraph_AvgHeader_Arrow() throws EncryptedDocumentException, IOException {
		overviewPage.clickOnProducerTab();
		overviewPage.validateProducerResponseRateGraphAvgHeaderArrow(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Producer_ResponseRate_Producer_Header_Title"));
	}*/	
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_246_validate_Producer_ResponseRateGraph_MaxHeaderTitle() throws EncryptedDocumentException, IOException {
		 
		overviewPage.clickOnProducerTab();
		overviewPage.validateProducerResponseRateGraphMaxHeaderTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Producer_ResponseRate_Max_Header_Title"));
	}
	
	/*@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_247_validate_Producer_ResponseRateGraph_AvgHeader_Arrow() throws EncryptedDocumentException, IOException {
		overviewPage.clickOnProducerTab();
		overviewPage.validateProducerResponseRateGraphAvgHeaderArrow(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Producer_ResponseRate_Producer_Header_Title"));
	}*/	
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_248_validate_Producer_ResponseRateGraph_RowColor1() throws EncryptedDocumentException, IOException {
		 
		overviewPage.clickOnProducerTab();
		overviewPage.validateProducerResponseRateGraphRowColor1(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "rgb(255, 123, 123)"));
	}
	
	/*@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_249_validate_Producer_ResponseRateGraph_WidgetLegend1NameSort() throws EncryptedDocumentException, IOException, InterruptedException {
		 
		overviewPage.clickOnProducerTab();
		overviewPage.validateProducerResponseRateWidgetLegendColumn1();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_250_validate_Producer_ResponseRateGraph_WidgetLegend2NameSort() throws EncryptedDocumentException, IOException, InterruptedException {
		 
		overviewPage.clickOnProducerTab();
		overviewPage.validateProducerResponseRateWidgetLegendColumn2();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_251_validate_Producer_ResponseRateGraph_WidgetLegend3NameSort() throws EncryptedDocumentException, IOException, InterruptedException {
		 
		overviewPage.clickOnProducerTab();
		overviewPage.validateProducerResponseRateWidgetLegendColumn3();
	}*/
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_252_validate_Producer_ResponseRateGraph_ExpandViewXAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		 
		overviewPage.clickOnProducerTab();
		overviewPage.validateProducerResponseRateExpandViewXAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_253_validate_Producer_ResponseRateGraph_ExpandViewYAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		 
		overviewPage.clickOnProducerTab();
		overviewPage.validateProducerResponseRateExpandViewYAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_254_validate_Producer_ResponseRateGraph_ExpandViewWidgetTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		 
		overviewPage.clickOnProducerTab();
		overviewPage.validateProducerResponseRateExpandViewWidgetTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_255_validate_Producer_ResponseRateGraph_ExpandViewLegendHeader1() throws EncryptedDocumentException, IOException, InterruptedException {
		 
		overviewPage.clickOnProducerTab();
		overviewPage.validateProducerResponseRateExpandViewLegendHeader1();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_256_validate_Producer_ResponseRateGraph_ExpandViewLegendHeader2() throws EncryptedDocumentException, IOException, InterruptedException {
		 
		overviewPage.clickOnProducerTab();
		overviewPage.validateProducerResponseRateExpandViewLegendHeader2();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_257_validate_Producer_ResponseRateGraph_ExpandViewLegendHeader3() throws EncryptedDocumentException, IOException, InterruptedException {
		 
		overviewPage.clickOnProducerTab();
		overviewPage.validateProducerResponseRateExpandViewLegendHeader3();
	}
	
/*	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_258_validate_Producer_ResponseRateGraph_ExpandViewHeader2InfoMessage() throws EncryptedDocumentException, IOException, InterruptedException {
		 
		overviewPage.clickOnProducerTab();
		overviewPage.validateProducerResponseRateExpandViewLegendHeader2InforMessage();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_259_validate_Producer_ResponseRateGraph_ExpandViewHeader3InfoMessage() throws EncryptedDocumentException, IOException, InterruptedException {
		 
		overviewPage.clickOnProducerTab();
		overviewPage.validateProducerResponseRateExpandViewLegendHeader3InforMessage();
	}
	*/
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_260_validate_Producer_ResponseRateGraph_ExpandViewZoomInBtn() throws EncryptedDocumentException, IOException, InterruptedException {
		 
		overviewPage.clickOnProducerTab();
		overviewPage.validateProducerResponseRateExpandViewZoomIn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_261_validate_Producer_ResponseRateGraph_ExpandViewZoomOutBtn() throws EncryptedDocumentException, IOException, InterruptedException {
		 
		overviewPage.clickOnProducerTab();
		overviewPage.validateProducerResponseRateExpandViewZoomOut();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_262_validate_Producer_ResponseRateGraph_ExpandViewWidgetDragDrop() throws EncryptedDocumentException, IOException, InterruptedException {
		 
		overviewPage.clickOnProducerTab();
		overviewPage.validateProducerResponseRateExpandViewWidgetDragDrop();
	}	
	
	
/********************************************************* Error Rate Graph ******************************************************************/
	
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_263_validate_Producer_ErrorRateGraph_Title() throws EncryptedDocumentException, IOException {
		 
		overviewPage.clickOnProducerTab();
		overviewPage.validateProducerErrorRateGraphTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Producer_ErrorRate_Graph_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_264_validate_Producer_ErrorRateGraph_ZoomIn() throws EncryptedDocumentException, IOException {
		 
		overviewPage.clickOnProducerTab();
		overviewPage.validateProducerErrorRateGraphZoomInBtn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_265_validate_Producer_ErrorRateGraph_ZoomOut() throws EncryptedDocumentException, IOException {
		 
		overviewPage.clickOnProducerTab();
		overviewPage.validateProducerErrorRateGraphZoomOutBtn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_266_validate_Producer_ErrorRateGraph_XaxisValue() throws EncryptedDocumentException, IOException {
		 
		overviewPage.clickOnProducerTab();
		overviewPage.validateProducerErrorRateXaxisValues();
	}	
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_267_validate_Producer_ErrorRateGraph_XaxisTitle() throws EncryptedDocumentException, IOException {
		 
		overviewPage.clickOnProducerTab();
		overviewPage.validateProducerErrorRateGraphXaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Producer_ErrorRate_Xaxis_Title"));
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_268_validate_Producer_ErrorRateGraph_YaxisTitle() throws EncryptedDocumentException, IOException {
		 
		overviewPage.clickOnProducerTab();
		overviewPage.validateProducerErrorRateGraphYaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Producer_ErrorRate_Yaxis_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_269_validate_Producer_ErrorRateGraph_BrokerHeaderTitle() throws EncryptedDocumentException, IOException {
		 
		overviewPage.clickOnProducerTab();
		overviewPage.validateProducerErrorRateGraphBrokerHeaderTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Producer_ErrorRate_Producer_Header_Title"));
	}
		
	/*@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_270_validate_Producer_ErrorRateGraph_BrokerHeader_Arrow() throws EncryptedDocumentException, IOException {
		overviewPage.clickOnProducerTab();
		overviewPage.validateProducerErrorRateGraphBrokerHeaderArrow(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Producer_ErrorRate_Producer_Header_Title"));
	}*/
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_271_validate_Producer_ErrorRateGraph_AvgHeaderTitle() throws EncryptedDocumentException, IOException {
		 
		overviewPage.clickOnProducerTab();
		overviewPage.validateProducerErrorRateGraphAvgHeaderTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Producer_ErrorRate_Avg_Header_Title"));
	}	
	
	/*@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_272_validate_Producer_ErrorRateGraph_AvgHeader_Arrow() throws EncryptedDocumentException, IOException {
		overviewPage.clickOnProducerTab();
		overviewPage.validateProducerErrorRateGraphAvgHeaderArrow(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Producer_ErrorRate_Producer_Header_Title"));
	}*/	
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_273_validate_Producer_ErrorRateGraph_MaxHeaderTitle() throws EncryptedDocumentException, IOException {
		 
		overviewPage.clickOnProducerTab();
		overviewPage.validateProducerErrorRateGraphMaxHeaderTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Producer_ErrorRate_Max_Header_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_274_validate_Producer_ErrorRateGraph_RowColor1() throws EncryptedDocumentException, IOException {
		 
		overviewPage.clickOnProducerTab();
		overviewPage.validateProducerErrorRateGraphRowColor1(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "rgb(255, 123, 123)"));
	}
	
	/*@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_275_validate_Producer_ErrorRateGraph_WidgetLegend1NameSort() throws EncryptedDocumentException, IOException, InterruptedException {
		 
		overviewPage.clickOnProducerTab();
		overviewPage.validateProducerErrorRateWidgetLegendColumn1();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_276_validate_Producer_ErrorRateGraph_WidgetLegend2NameSort() throws EncryptedDocumentException, IOException, InterruptedException {
		 
		overviewPage.clickOnProducerTab();
		overviewPage.validateProducerErrorRateWidgetLegendColumn2();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_277_validate_Producer_ErrorRateGraph_WidgetLegend3NameSort() throws EncryptedDocumentException, IOException, InterruptedException {
		 
		overviewPage.clickOnProducerTab();
		overviewPage.validateProducerErrorRateWidgetLegendColumn3();
	}*/
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_278_validate_Producer_ErrorRateGraph_ExpandViewXAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		 
		overviewPage.clickOnProducerTab();
		overviewPage.validateProducerErrorRateExpandViewXAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_279_validate_Producer_ErrorRateGraph_ExpandViewYAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		 
		overviewPage.clickOnProducerTab();
		overviewPage.validateProducerErrorRateExpandViewYAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_280_validate_Producer_ErrorRateGraph_ExpandViewWidgetTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		 
		overviewPage.clickOnProducerTab();
		overviewPage.validateProducerErrorRateExpandViewWidgetTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_281_validate_Producer_ErrorRateGraph_ExpandViewLegendHeader1() throws EncryptedDocumentException, IOException, InterruptedException {
		 
		overviewPage.clickOnProducerTab();
		overviewPage.validateProducerErrorRateExpandViewLegendHeader1();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_282_validate_Producer_ErrorRateGraph_ExpandViewLegendHeader2() throws EncryptedDocumentException, IOException, InterruptedException {
		 
		overviewPage.clickOnProducerTab();
		overviewPage.validateProducerErrorRateExpandViewLegendHeader2();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_283_validate_Producer_ErrorRateGraph_ExpandViewLegendHeader3() throws EncryptedDocumentException, IOException, InterruptedException {
		 
		overviewPage.clickOnProducerTab();
		overviewPage.validateProducerErrorRateExpandViewLegendHeader3();
	}
	
/*	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_284_validate_Producer_ErrorRateGraph_ExpandViewHeader2InfoMessage() throws EncryptedDocumentException, IOException, InterruptedException {
		 
		overviewPage.clickOnProducerTab();
		overviewPage.validateProducerErrorRateExpandViewLegendHeader2InforMessage();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_285_validate_Producer_ErrorRateGraph_ExpandViewHeader3InfoMessage() throws EncryptedDocumentException, IOException, InterruptedException {
		 
		overviewPage.clickOnProducerTab();
		overviewPage.validateProducerErrorRateExpandViewLegendHeader3InforMessage();
	}*/
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_286_validate_Producer_ErrorRateGraph_ExpandViewZoomInBtn() throws EncryptedDocumentException, IOException, InterruptedException {
		 
		overviewPage.clickOnProducerTab();
		overviewPage.validateProducerErrorRateExpandViewZoomIn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_287_validate_Producer_ErrorRateGraph_ExpandViewZoomOutBtn() throws EncryptedDocumentException, IOException, InterruptedException {
		 
		overviewPage.clickOnProducerTab();
		overviewPage.validateProducerErrorRateExpandViewZoomOut();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_288_validate_Producer_ErrorRateGraph_ExpandViewWidgetDragDrop() throws EncryptedDocumentException, IOException, InterruptedException {
		 
		overviewPage.clickOnProducerTab();
		overviewPage.validateProducerErrorRateExpandViewWidgetDragDrop();
	}	
	
	
/******************************************************** Request Avg Latency Graph ******************************************************************/
	
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_289_validate_Producer_RequestAvgLatencyGraph_Title() throws EncryptedDocumentException, IOException {
		 
		overviewPage.clickOnProducerTab();
		overviewPage.validateProducerRequestAvgLatencyGraphTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Producer_RequestAvgLatency_Graph_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_290_validate_Producer_RequestAvgLatencyGraph_ZoomIn() throws EncryptedDocumentException, IOException {
		 
		overviewPage.clickOnProducerTab();
		overviewPage.validateProducerRequestAvgLatencyGraphZoomInBtn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_291_validate_Producer_RequestAvgLatencyGraph_ZoomOut() throws EncryptedDocumentException, IOException {
		 
		overviewPage.clickOnProducerTab();
		overviewPage.validateProducerRequestAvgLatencyGraphZoomOutBtn();
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_292_validate_Producer_RequestAvgLatencyGraph_XaxisValue() throws EncryptedDocumentException, IOException {
		 
		overviewPage.clickOnProducerTab();
		overviewPage.validateProducerRequestAvgLatencyXaxisValues();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_293_validate_Producer_RequestAvgLatencyGraph_XaxisTitle() throws EncryptedDocumentException, IOException {
		 
		overviewPage.clickOnProducerTab();
		overviewPage.validateProducerRequestAvgLatencyGraphXaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Producer_RequestAvgLatency_Xaxis_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_294_validate_Producer_RequestAvgLatencyGraph_YaxisTitle() throws EncryptedDocumentException, IOException {
		 
		overviewPage.clickOnProducerTab();
		overviewPage.validateProducerRequestAvgLatencyGraphYaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Producer_RequestAvgLatency_Yaxis_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_295_validate_Producer_RequestAvgLatencyGraph_BrokerHeaderTitle() throws EncryptedDocumentException, IOException {
		 
		overviewPage.clickOnProducerTab();
		overviewPage.validateProducerRequestAvgLatencyGraphBrokerHeaderTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Producer_RequestAvgLatency_Producer_Header_Title"));
	}
		
	/*@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_296_validate_Producer_RequestAvgLatencyGraph_BrokerHeader_Arrow() throws EncryptedDocumentException, IOException {
		overviewPage.clickOnProducerTab();
		overviewPage.validateProducerRequestAvgLatencyGraphBrokerHeaderArrow(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Producer_RequestAvgLatency_Producer_Header_Title"));
	}*/
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_297_validate_Producer_RequestAvgLatencyGraph_AvgHeaderTitle() throws EncryptedDocumentException, IOException {
		 
		overviewPage.clickOnProducerTab();
		overviewPage.validateProducerRequestAvgLatencyGraphAvgHeaderTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Producer_RequestAvgLatency_Avg_Header_Title"));
	}
	
	/*@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_298_validate_Producer_RequestAvgLatencyGraph_AvgHeader_Arrow() throws EncryptedDocumentException, IOException {
		overviewPage.clickOnProducerTab();
		overviewPage.validateProducerRequestAvgLatencyGraphAvgHeaderArrow(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Producer_RequestAvgLatency_Producer_Header_Title"));
	}*/
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_299_validate_Producer_RequestAvgLatencyGraph_MaxHeaderTitle() throws EncryptedDocumentException, IOException {
		 
		overviewPage.clickOnProducerTab();
		overviewPage.validateProducerRequestAvgLatencyGraphMaxHeaderTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Producer_RequestAvgLatency_Max_Header_Title"));
	}
	
	/*@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_300_validate_Producer_RequestAvgLatencyGraph_AvgHeader_Arrow() throws EncryptedDocumentException, IOException {
		overviewPage.clickOnProducerTab();
		overviewPage.validateProducerRequestAvgLatencyGraphAvgHeaderArrow(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Producer_RequestAvgLatency_Producer_Header_Title"));
	}*/
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_301_validate_Producer_RequestAvgLatencyGraph_RowColor1() throws EncryptedDocumentException, IOException {
		 
		overviewPage.clickOnProducerTab();
		overviewPage.validateProducerRequestAvgLatencyGraphRowColor1(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "rgb(255, 123, 123)"));
	}
	
	/*@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_302_validate_Producer_RequestAvgLatencyGraph_WidgetLegend1NameSort() throws EncryptedDocumentException, IOException, InterruptedException {
		 
		overviewPage.clickOnProducerTab();
		overviewPage.validateProducerRequestAvgLatencyWidgetLegendColumn1();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_303_validate_Producer_RequestAvgLatencyGraph_WidgetLegend2NameSort() throws EncryptedDocumentException, IOException, InterruptedException {
		 
		overviewPage.clickOnProducerTab();
		overviewPage.validateProducerRequestAvgLatencyWidgetLegendColumn2();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_304_validate_Producer_RequestAvgLatencyGraph_WidgetLegend3NameSort() throws EncryptedDocumentException, IOException, InterruptedException {
		 
		overviewPage.clickOnProducerTab();
		overviewPage.validateProducerRequestAvgLatencyWidgetLegendColumn3();
	}*/
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_305_validate_Producer_RequestAvgLatencyGraph_ExpandViewXAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		 
		overviewPage.clickOnProducerTab();
		overviewPage.validateProducerRequestAvgLatencyExpandViewXAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_306_validate_Producer_RequestAvgLatencyGraph_ExpandViewYAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		 
		overviewPage.clickOnProducerTab();
		overviewPage.validateProducerRequestAvgLatencyExpandViewYAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_307_validate_Producer_RequestAvgLatencyGraph_ExpandViewWidgetTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		 
		overviewPage.clickOnProducerTab();
		overviewPage.validateProducerRequestAvgLatencyExpandViewWidgetTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_308_validate_Producer_RequestAvgLatencyGraph_ExpandViewLegendHeader1() throws EncryptedDocumentException, IOException, InterruptedException {
		 
		overviewPage.clickOnProducerTab();
		overviewPage.validateProducerRequestAvgLatencyExpandViewLegendHeader1();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_309_validate_Producer_RequestAvgLatencyGraph_ExpandViewLegendHeader2() throws EncryptedDocumentException, IOException, InterruptedException {
		 
		overviewPage.clickOnProducerTab();
		overviewPage.validateProducerRequestAvgLatencyExpandViewLegendHeader2();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_310_validate_Producer_RequestAvgLatencyGraph_ExpandViewLegendHeader3() throws EncryptedDocumentException, IOException, InterruptedException {
		 
		overviewPage.clickOnProducerTab();
		overviewPage.validateProducerRequestAvgLatencyExpandViewLegendHeader3();
	}
	
/*	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_311_validate_Producer_RequestAvgLatencyGraph_ExpandViewHeader2InfoMessage() throws EncryptedDocumentException, IOException, InterruptedException {
		 
		overviewPage.clickOnProducerTab();
		overviewPage.validateProducerRequestAvgLatencyExpandViewLegendHeader2InforMessage();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_312_validate_Producer_RequestAvgLatencyGraph_ExpandViewHeader3InfoMessage() throws EncryptedDocumentException, IOException, InterruptedException {
		overviewPage.clickOnProducerTab();
		overviewPage.validateProducerRequestAvgLatencyExpandViewLegendHeader3InforMessage();
	}*/
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_313_validate_Producer_RequestAvgLatencyGraph_ExpandViewZoomInBtn() throws EncryptedDocumentException, IOException, InterruptedException {
		overviewPage.clickOnProducerTab();
		overviewPage.validateProducerRequestAvgLatencyExpandViewZoomIn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_314_validate_Producer_RequestAvgLatencyGraph_ExpandViewZoomOutBtn() throws EncryptedDocumentException, IOException, InterruptedException {
		overviewPage.clickOnProducerTab();
		overviewPage.validateProducerRequestAvgLatencyExpandViewZoomOut();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_315_validate_Producer_RequestAvgLatencyGraph_ExpandViewWidgetDragDrop() throws EncryptedDocumentException, IOException, InterruptedException {
		overviewPage.clickOnProducerTab();
		overviewPage.validateProducerRequestAvgLatencyExpandViewWidgetDragDrop();
	}	
	
 /****************************************** Number Of Producers Graph ********************************************************/

//Producer - Number Of Producers Graph
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_316_validate_Producer_NumberOfProducersGraph_Title() throws EncryptedDocumentException, IOException {
		overviewPage.clickOnProducerTab();
		overviewPage.validateProducerNumberOfProducersGraphTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Producer_NumberOfProducers_Graph_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_317_validate_Producer_NumberOfProducersGraph_ZoomIn() throws EncryptedDocumentException, IOException {
		overviewPage.clickOnProducerTab();
		overviewPage.validateProducerNumberOfProducersGraphZoomInBtn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_318_validate_Producer_NumberOfProducersGraph_ZoomOut() throws EncryptedDocumentException, IOException {
		overviewPage.clickOnProducerTab();
		overviewPage.validateProducerNumberOfProducersGraphZoomOutBtn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_319_validate_Producer_NumberOfProducersGraph_XaxisValue() throws EncryptedDocumentException, IOException {
		overviewPage.clickOnProducerTab();
		overviewPage.validateProducerNumberOfProducersXaxisValues();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_320_validate_Producer_NumberOfProducersGraph_XaxisTitle() throws EncryptedDocumentException, IOException {
		overviewPage.clickOnProducerTab();
		overviewPage.validateProducerNumberOfProducersGraphXaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Producer_NumberOfProducers_Xaxis_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_321_validate_Producer_NumberOfProducers_Graph_YaxisTitle() throws EncryptedDocumentException, IOException {
		overviewPage.clickOnProducerTab();
		overviewPage.validateProducerNumberOfProducersGraphYaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Producer_NumberOfProducers_Yaxis_Title"));
	}

	
/**
 * Consumer Tab
 * @throws EncryptedDocumentException
 * @throws IOException
 */
	
/********************************************************* Average fetch Size Graph ******************************************************************/
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_392_validate_Consumer_Tab_Title() throws EncryptedDocumentException, IOException {
		overviewPage.validateConsumerTabTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Consumer_Tab_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_393_click_on_Consumer_Tab() throws EncryptedDocumentException, IOException {
		overviewPage.clickOnConsumerTab();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_394_validate_Consumer_AverageFetchSizeGraph_Title() throws EncryptedDocumentException, IOException {
		overviewPage.clickOnConsumerTab();
		overviewPage.validateConsumerAverageFetchSizeGraphTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Consumer_AverageFetchSize_Graph_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_395_validate_Consumer_RequestRateGraph_ZoomIn() throws EncryptedDocumentException, IOException {
		overviewPage.clickOnConsumerTab();
		overviewPage.validateConsumerAverageFetchSizeGraphZoomInBtn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_396_validate_Consumer_RequestRateGraph_ZoomOut() throws EncryptedDocumentException, IOException {
		overviewPage.clickOnConsumerTab();
		overviewPage.validateConsumerAverageFetchSizeGraphZoomOutBtn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_397_validate_Consumer_AverageFetchSizeGraph_XaxisValue() throws EncryptedDocumentException, IOException {
		overviewPage.clickOnConsumerTab();
		overviewPage.validateConsumerAverageFetchSizeXaxisValues();
	}	
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_398_validate_Consumer_AverageFetchSizeGraph_XaxisTitle() throws EncryptedDocumentException, IOException {
		overviewPage.clickOnConsumerTab();
		overviewPage.validateConsumerAverageFetchSizeGraphXaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Consumer_AverageFetchSize_Xaxis_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_399_validate_Consumer_AverageFetchSizeGraph_YaxisTitle() throws EncryptedDocumentException, IOException {
		overviewPage.clickOnConsumerTab();
		overviewPage.validateConsumerAverageFetchSizeGraphYaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Consumer_AverageFetchSize_Yaxis_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_400_validate_Consumer_AverageFetchSizeGraph_BrokerHeaderTitle() throws EncryptedDocumentException, IOException {
		overviewPage.clickOnConsumerTab();
		overviewPage.validateConsumerAverageFetchSizeGraphBrokerHeaderTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Consumer_AverageFetchSize_Consumer_Header_Title"));
	}	
	
	/*@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_401_validate_Consumer_AverageFetchSizeGraph_BrokerHeader_Arrow() throws EncryptedDocumentException, IOException {
		overviewPage.clickOnConsumerTab();
		overviewPage.validateConsumerAverageFetchSizeGraphBrokerHeaderArrow(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Consumer_AverageFetchSize_Consumer_Header_Title"));
	}*/
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_402_validate_Consumer_AverageFetchSizeGraph_AvgHeaderTitle() throws EncryptedDocumentException, IOException {
		overviewPage.clickOnConsumerTab();
		overviewPage.validateConsumerAverageFetchSizeGraphAvgHeaderTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Consumer_AverageFetchSize_Avg_Header_Title"));
	}	
	
	/*@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_403_validate_Consumer_AverageFetchSizeGraph_AvgHeader_Arrow() throws EncryptedDocumentException, IOException {
		overviewPage.clickOnConsumerTab();
		overviewPage.validateConsumerAverageFetchSizeGraphAvgHeaderArrow(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Consumer_AverageFetchSize_Consumer_Header_Title"));
	}*/
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_404_validate_Consumer_AverageFetchSizeGraph_MaxHeaderTitle() throws EncryptedDocumentException, IOException {
		overviewPage.clickOnConsumerTab();
		overviewPage.validateConsumerAverageFetchSizeGraphMaxHeaderTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Consumer_AverageFetchSize_Max_Header_Title"));
	}
	
	/*@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_405_validate_Consumer_AverageFetchSizeGraph_AvgHeader_Arrow() throws EncryptedDocumentException, IOException {
		overviewPage.clickOnConsumerTab();
		overviewPage.validateConsumerAverageFetchSizeGraphAvgHeaderArrow(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Consumer_AverageFetchSize_Consumer_Header_Title"));
	}*/
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_406_validate_Consumer_AverageFetchSizeGraph_RowColor1() throws EncryptedDocumentException, IOException {
		overviewPage.clickOnConsumerTab();
		overviewPage.validateConsumerAverageFetchSizeGraphRowColor1(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "rgb(255, 123, 123)"));
	}
	
	/*@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_407_validate_Consumer_AverageFetchSizeGraph_WidgetLegend1NameSort() throws EncryptedDocumentException, IOException, InterruptedException {
		overviewPage.clickOnConsumerTab();
		overviewPage.validateConsumerAverageFetchSizeWidgetLegendColumn1();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_408_validate_Consumer_AverageFetchSizeGraph_WidgetLegend2NameSort() throws EncryptedDocumentException, IOException, InterruptedException {
		overviewPage.clickOnConsumerTab();
		overviewPage.validateConsumerAverageFetchSizeWidgetLegendColumn2();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_409_validate_Consumer_AverageFetchSizeGraph_WidgetLegend3NameSort() throws EncryptedDocumentException, IOException, InterruptedException {
		overviewPage.clickOnConsumerTab();
		overviewPage.validateConsumerAverageFetchSizeWidgetLegendColumn3();
	}*/
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_410_validate_Consumer_AverageFetchSizeGraph_ExpandViewXAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		overviewPage.clickOnConsumerTab();
		overviewPage.validateConsumerAverageFetchSizeExpandViewXAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_411_validate_Consumer_AverageFetchSizeGraph_ExpandViewYAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		overviewPage.clickOnConsumerTab();
		overviewPage.validateConsumerAverageFetchSizeExpandViewYAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_412_validate_Consumer_AverageFetchSizeGraph_ExpandViewWidgetTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		overviewPage.clickOnConsumerTab();
		overviewPage.validateConsumerAverageFetchSizeExpandViewWidgetTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_413_validate_Consumer_AverageFetchSizeGraph_ExpandViewLegendHeader1() throws EncryptedDocumentException, IOException, InterruptedException {
		overviewPage.clickOnConsumerTab();
		overviewPage.validateConsumerAverageFetchSizeExpandViewLegendHeader1();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_414_validate_Consumer_AverageFetchSizeGraph_ExpandViewLegendHeader2() throws EncryptedDocumentException, IOException, InterruptedException {
		overviewPage.clickOnConsumerTab();
		overviewPage.validateConsumerAverageFetchSizeExpandViewLegendHeader2();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_415_validate_Consumer_AverageFetchSizeGraph_ExpandViewLegendHeader3() throws EncryptedDocumentException, IOException, InterruptedException {
		overviewPage.clickOnConsumerTab();
		overviewPage.validateConsumerAverageFetchSizeExpandViewLegendHeader3();
	}
	
	/*@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_416_validate_Consumer_AverageFetchSizeGraph_ExpandViewHeader2InfoMessage() throws EncryptedDocumentException, IOException, InterruptedException {
		overviewPage.clickOnConsumerTab();
		overviewPage.validateConsumerAverageFetchSizeExpandViewLegendHeader2InforMessage();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_417_validate_Consumer_AverageFetchSizeGraph_ExpandViewHeader3InfoMessage() throws EncryptedDocumentException, IOException, InterruptedException {
		overviewPage.clickOnConsumerTab();
		overviewPage.validateConsumerAverageFetchSizeExpandViewLegendHeader3InforMessage();
	}*/
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_418_validate_Consumer_AverageFetchSizeGraph_ExpandViewZoomInBtn() throws EncryptedDocumentException, IOException, InterruptedException {
		overviewPage.clickOnConsumerTab();
		overviewPage.validateConsumerAverageFetchSizeExpandViewZoomIn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_419_validate_Consumer_AverageFetchSizeGraph_ExpandViewZoomOutBtn() throws EncryptedDocumentException, IOException, InterruptedException {
		overviewPage.clickOnConsumerTab();
		overviewPage.validateConsumerAverageFetchSizeExpandViewZoomOut();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_420_validate_Consumer_AverageFetchSizeGraph_ExpandViewWidgetDragDrop() throws EncryptedDocumentException, IOException, InterruptedException {
		overviewPage.clickOnConsumerTab();
		overviewPage.validateConsumerAverageFetchSizeExpandViewWidgetDragDrop();
	}	
	
	
/*********************************************************Response Rate Graph******************************************************************/
	
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_421_validate_Consumer_ResponseRateGraph_Title() throws EncryptedDocumentException, IOException {
		overviewPage.clickOnConsumerTab();
		overviewPage.validateConsumerResponseRateGraphTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Consumer_ResponseRate_Graph_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_422_validate_Consumer_ResponseRateGraph_ZoomIn() throws EncryptedDocumentException, IOException {
		overviewPage.clickOnConsumerTab();
		overviewPage.validateConsumerResponseRateGraphZoomInBtn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_423_validate_Consumer_ResponseRateGraph_ZoomOut() throws EncryptedDocumentException, IOException {
		overviewPage.clickOnConsumerTab();
		overviewPage.validateConsumerResponseRateGraphZoomOutBtn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_424_validate_Consumer_ResponseRateGraph_XaxisValue() throws EncryptedDocumentException, IOException {
		overviewPage.clickOnConsumerTab();
		overviewPage.validateConsumerResponseRateXaxisValues();
	}	
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_425_validate_Consumer_ResponseRateGraph_XaxisTitle() throws EncryptedDocumentException, IOException {
		overviewPage.clickOnConsumerTab();
		overviewPage.validateConsumerResponseRateGraphXaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Consumer_ResponseRate_Xaxis_Title"));
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_426_validate_Consumer_ResponseRateGraph_YaxisTitle() throws EncryptedDocumentException, IOException {
		overviewPage.clickOnConsumerTab();
		overviewPage.validateConsumerResponseRateGraphYaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Consumer_ResponseRate_Yaxis_Title"));
	}

	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_427_validate_Consumer_ResponseRateGraph_BrokerHeaderTitle() throws EncryptedDocumentException, IOException {
		overviewPage.clickOnConsumerTab();
		overviewPage.validateConsumerResponseRateGraphBrokerHeaderTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Consumer_ResponseRate_Consumer_Header_Title"));
	}
		
	/*@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_428_validate_Consumer_ResponseRateGraph_BrokerHeader_Arrow() throws EncryptedDocumentException, IOException {
		overviewPage.clickOnConsumerTab();
		overviewPage.validateConsumerResponseRateGraphBrokerHeaderArrow(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Consumer_ResponseRate_Consumer_Header_Title"));
	}*/
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_429_validate_Consumer_ResponseRateGraph_AvgHeaderTitle() throws EncryptedDocumentException, IOException {
		overviewPage.clickOnConsumerTab();
		overviewPage.validateConsumerResponseRateGraphAvgHeaderTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Consumer_ResponseRate_Avg_Header_Title"));
	}
	
	/*@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_430_validate_Consumer_ResponseRateGraph_AvgHeader_Arrow() throws EncryptedDocumentException, IOException {
		overviewPage.clickOnConsumerTab();
		overviewPage.validateConsumerResponseRateGraphAvgHeaderArrow(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Consumer_ResponseRate_Consumer_Header_Title"));
	}*/
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_431_validate_Consumer_ResponseRateGraph_MaxHeaderTitle() throws EncryptedDocumentException, IOException {
		overviewPage.clickOnConsumerTab();
		overviewPage.validateConsumerResponseRateGraphMaxHeaderTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Consumer_ResponseRate_Max_Header_Title"));
	}
	
	/*@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_432_validate_Consumer_ResponseRateGraph_AvgHeader_Arrow() throws EncryptedDocumentException, IOException {
		overviewPage.clickOnConsumerTab();
		overviewPage.validateConsumerResponseRateGraphAvgHeaderArrow(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Consumer_ResponseRate_Consumer_Header_Title"));
	}*/
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_433_validate_Consumer_ResponseRateGraph_RowColor1() throws EncryptedDocumentException, IOException {
		overviewPage.clickOnConsumerTab();
		overviewPage.validateConsumerResponseRateGraphRowColor1(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "rgb(255, 123, 123)"));
	}
	
	/*@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_434_validate_Consumer_ResponseRateGraph_WidgetLegend1NameSort() throws EncryptedDocumentException, IOException, InterruptedException {
		overviewPage.clickOnConsumerTab();
		overviewPage.validateConsumerResponseRateWidgetLegendColumn1();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_435_validate_Consumer_ResponseRateGraph_WidgetLegend2NameSort() throws EncryptedDocumentException, IOException, InterruptedException {
		overviewPage.clickOnConsumerTab();
		overviewPage.validateConsumerResponseRateWidgetLegendColumn2();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_436_validate_Consumer_ResponseRateGraph_WidgetLegend3NameSort() throws EncryptedDocumentException, IOException, InterruptedException {
		overviewPage.clickOnConsumerTab();
		overviewPage.validateConsumerResponseRateWidgetLegendColumn3();
	}*/
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_437_validate_Consumer_ResponseRateGraph_ExpandViewXAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		overviewPage.clickOnConsumerTab();
		overviewPage.validateConsumerResponseRateExpandViewXAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_438_validate_Consumer_ResponseRateGraph_ExpandViewYAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		overviewPage.clickOnConsumerTab();
		overviewPage.validateConsumerResponseRateExpandViewYAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_439_validate_Consumer_ResponseRateGraph_ExpandViewWidgetTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		overviewPage.clickOnConsumerTab();
		overviewPage.validateConsumerResponseRateExpandViewWidgetTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_440_validate_Consumer_ResponseRateGraph_ExpandViewLegendHeader1() throws EncryptedDocumentException, IOException, InterruptedException {
		overviewPage.clickOnConsumerTab();
		overviewPage.validateConsumerResponseRateExpandViewLegendHeader1();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_441_validate_Consumer_ResponseRateGraph_ExpandViewLegendHeader2() throws EncryptedDocumentException, IOException, InterruptedException {
		overviewPage.clickOnConsumerTab();
		overviewPage.validateConsumerResponseRateExpandViewLegendHeader2();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_442_validate_Consumer_ResponseRateGraph_ExpandViewLegendHeader3() throws EncryptedDocumentException, IOException, InterruptedException {
		overviewPage.clickOnConsumerTab();
		overviewPage.validateConsumerResponseRateExpandViewLegendHeader3();
	}
	
	/*@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_443_validate_Consumer_ResponseRateGraph_ExpandViewHeader2InfoMessage() throws EncryptedDocumentException, IOException, InterruptedException {
		overviewPage.clickOnConsumerTab();
		overviewPage.validateConsumerResponseRateExpandViewLegendHeader2InforMessage();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_444_validate_Consumer_ResponseRateGraph_ExpandViewHeader3InfoMessage() throws EncryptedDocumentException, IOException, InterruptedException {
		overviewPage.clickOnConsumerTab();
		overviewPage.validateConsumerResponseRateExpandViewLegendHeader3InforMessage();
	}*/
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_445_validate_Consumer_ResponseRateGraph_ExpandViewZoomInBtn() throws EncryptedDocumentException, IOException, InterruptedException {
		overviewPage.clickOnConsumerTab();
		overviewPage.validateConsumerResponseRateExpandViewZoomIn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_446_validate_Consumer_ResponseRateGraph_ExpandViewZoomOutBtn() throws EncryptedDocumentException, IOException, InterruptedException {
		overviewPage.clickOnConsumerTab();
		overviewPage.validateConsumerResponseRateExpandViewZoomOut();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_447_validate_Consumer_ResponseRateGraph_ExpandViewWidgetDragDrop() throws EncryptedDocumentException, IOException, InterruptedException {
		overviewPage.clickOnConsumerTab();
		overviewPage.validateConsumerResponseRateExpandViewWidgetDragDrop();
	}	
	
	
/********************************************************* Consumer Lag Graph ******************************************************************/
	
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_448_validate_Consumer_ConsumerLagGraph_Title() throws EncryptedDocumentException, IOException {
		overviewPage.clickOnConsumerTab();
		overviewPage.validateConsumerConsumerLagGraphTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Consumer_ConsumerLag_Graph_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_449_validate_Consumer_ConsumerLagGraph_ZoomIn() throws EncryptedDocumentException, IOException {
		overviewPage.clickOnConsumerTab();
		overviewPage.validateConsumerConsumerLagGraphZoomInBtn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_450_validate_Consumer_ConsumerLagGraph_ZoomOut() throws EncryptedDocumentException, IOException {
		overviewPage.clickOnConsumerTab();
		overviewPage.validateConsumerConsumerLagGraphZoomOutBtn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_451_validate_Consumer_ConsumerLagGraph_XaxisValue() throws EncryptedDocumentException, IOException {
		overviewPage.clickOnConsumerTab();
		overviewPage.validateConsumerConsumerLagXaxisValues();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_452_validate_Consumer_ConsumerLagGraph_XaxisTitle() throws EncryptedDocumentException, IOException {
		overviewPage.clickOnConsumerTab();
		overviewPage.validateConsumerConsumerLagGraphXaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Consumer_ConsumerLag_Xaxis_Title"));
	}	
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_453_validate_Consumer_ConsumerLagGraph_YaxisTitle() throws EncryptedDocumentException, IOException {
		overviewPage.clickOnConsumerTab();
		overviewPage.validateConsumerConsumerLagGraphYaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Consumer_ConsumerLag_Yaxis_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_454_validate_Consumer_ConsumerLagGraph_BrokerHeaderTitle() throws EncryptedDocumentException, IOException {
		overviewPage.clickOnConsumerTab();
		overviewPage.validateConsumerConsumerLagGraphBrokerHeaderTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Consumer_ConsumerLag_Consumer_Header_Title"));
	}
		
	/*@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_456_validate_Consumer_ConsumerLagGraph_BrokerHeader_Arrow() throws EncryptedDocumentException, IOException {
		overviewPage.clickOnConsumerTab();
		overviewPage.validateConsumerConsumerLagGraphBrokerHeaderArrow(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Consumer_ConsumerLag_Consumer_Header_Title"));
	}*/
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_457_validate_Consumer_ConsumerLagGraph_AvgHeaderTitle() throws EncryptedDocumentException, IOException {
		overviewPage.clickOnConsumerTab();
		overviewPage.validateConsumerConsumerLagGraphAvgHeaderTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Consumer_ConsumerLag_Avg_Header_Title"));
	}
		
	/*@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_458_validate_Consumer_ConsumerLagGraph_AvgHeader_Arrow() throws EncryptedDocumentException, IOException {
		overviewPage.clickOnConsumerTab();
		overviewPage.validateConsumerConsumerLagGraphAvgHeaderArrow(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Consumer_ConsumerLag_Consumer_Header_Title"));
	}*/
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_459_validate_Consumer_ConsumerLagGraph_MaxHeaderTitle() throws EncryptedDocumentException, IOException {
		overviewPage.clickOnConsumerTab();
		overviewPage.validateConsumerConsumerLagGraphMaxHeaderTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Consumer_ConsumerLag_Max_Header_Title"));
	}
	
	/*@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_500_validate_Consumer_ConsumerLagGraph_AvgHeader_Arrow() throws EncryptedDocumentException, IOException {
		overviewPage.clickOnConsumerTab();
		overviewPage.validateConsumerConsumerLagGraphAvgHeaderArrow(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Consumer_ConsumerLag_Consumer_Header_Title"));
	}*/
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_501_validate_Consumer_ConsumerLagGraph_RowColor1() throws EncryptedDocumentException, IOException {
		overviewPage.clickOnConsumerTab();
		overviewPage.validateConsumerConsumerLagGraphRowColor1(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "rgb(255, 123, 123)"));
	}
	
	/*@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_502_validate_Consumer_ConsumerLagGraph_WidgetLegend1NameSort() throws EncryptedDocumentException, IOException, InterruptedException {
		overviewPage.clickOnConsumerTab();
		overviewPage.validateConsumerConsumerLagWidgetLegendColumn1();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_503_validate_Consumer_ConsumerLagGraph_WidgetLegend2NameSort() throws EncryptedDocumentException, IOException, InterruptedException {
		overviewPage.clickOnConsumerTab();
		overviewPage.validateConsumerConsumerLagWidgetLegendColumn2();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_504_validate_Consumer_ConsumerLagGraph_WidgetLegend3NameSort() throws EncryptedDocumentException, IOException, InterruptedException {
		overviewPage.clickOnConsumerTab();
		overviewPage.validateConsumerConsumerLagWidgetLegendColumn3();
	}*/
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_505_validate_Consumer_ConsumerLagGraph_ExpandViewXAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		overviewPage.clickOnConsumerTab();
		overviewPage.validateConsumerConsumerLagExpandViewXAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_506_validate_Consumer_ConsumerLagGraph_ExpandViewYAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		overviewPage.clickOnConsumerTab();
		overviewPage.validateConsumerConsumerLagExpandViewYAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_507_validate_Consumer_ConsumerLagGraph_ExpandViewWidgetTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		overviewPage.clickOnConsumerTab();
		overviewPage.validateConsumerConsumerLagExpandViewWidgetTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_508_validate_Consumer_ConsumerLagGraph_ExpandViewLegendHeader1() throws EncryptedDocumentException, IOException, InterruptedException {
		overviewPage.clickOnConsumerTab();
		overviewPage.validateConsumerConsumerLagExpandViewLegendHeader1();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_509_validate_Consumer_ConsumerLagGraph_ExpandViewLegendHeader2() throws EncryptedDocumentException, IOException, InterruptedException {
		overviewPage.clickOnConsumerTab();
		overviewPage.validateConsumerConsumerLagExpandViewLegendHeader2();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_510_validate_Consumer_ConsumerLagGraph_ExpandViewLegendHeader3() throws EncryptedDocumentException, IOException, InterruptedException {
		overviewPage.clickOnConsumerTab();
		overviewPage.validateConsumerConsumerLagExpandViewLegendHeader3();
	}
	
/*	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_511_validate_Consumer_ConsumerLagGraph_ExpandViewHeader2InfoMessage() throws EncryptedDocumentException, IOException, InterruptedException {
		overviewPage.clickOnConsumerTab();
		overviewPage.validateConsumerConsumerLagExpandViewLegendHeader2InforMessage();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_512_validate_Consumer_ConsumerLagGraph_ExpandViewHeader3InfoMessage() throws EncryptedDocumentException, IOException, InterruptedException {
		overviewPage.clickOnConsumerTab();
		overviewPage.validateConsumerConsumerLagExpandViewLegendHeader3InforMessage();
	}*/
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_513_validate_Consumer_ConsumerLagGraph_ExpandViewZoomInBtn() throws EncryptedDocumentException, IOException, InterruptedException {
		overviewPage.clickOnConsumerTab();
		overviewPage.validateConsumerConsumerLagExpandViewZoomIn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_514_validate_Consumer_ConsumerLagGraph_ExpandViewZoomOutBtn() throws EncryptedDocumentException, IOException, InterruptedException {
		overviewPage.clickOnConsumerTab();
		overviewPage.validateConsumerConsumerLagExpandViewZoomOut();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_515_validate_Consumer_ConsumerLagGraph_ExpandViewWidgetDragDrop() throws EncryptedDocumentException, IOException, InterruptedException {
		overviewPage.clickOnConsumerTab();
		overviewPage.validateConsumerConsumerLagExpandViewWidgetDragDrop();
	}	
/********************************************************* Message Consumed Graph******************************************************************/
	
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_516_validate_Consumer_MessageConsumedGraph_Title() throws EncryptedDocumentException, IOException {
		overviewPage.clickOnConsumerTab();
		overviewPage.validateConsumerMessageConsumedGraphTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Consumer_MessageConsumed_Graph_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_517_validate_Consumer_MessageConsumedGraph_ZoomIn() throws EncryptedDocumentException, IOException {
		overviewPage.clickOnConsumerTab();
		overviewPage.validateConsumerMessageConsumedGraphZoomInBtn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_518_validate_Consumer_MessageConsumedGraph_ZoomOut() throws EncryptedDocumentException, IOException {
		overviewPage.clickOnConsumerTab();
		overviewPage.validateConsumerMessageConsumedGraphZoomOutBtn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_519_validate_Consumer_MessageConsumedGraph_XaxisValue() throws EncryptedDocumentException, IOException {
		overviewPage.clickOnConsumerTab();
		overviewPage.validateConsumerMessageConsumedXaxisValues();
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_520_validate_Consumer_MessageConsumedGraph_XaxisTitle() throws EncryptedDocumentException, IOException {
		overviewPage.clickOnConsumerTab();
		overviewPage.validateConsumerMessageConsumedGraphXaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Consumer_MessageConsumed_Xaxis_Title"));
	}	
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_521_validate_Consumer_MessageConsumedGraph_YaxisTitle() throws EncryptedDocumentException, IOException {
		overviewPage.clickOnConsumerTab();
		overviewPage.validateConsumerMessageConsumedGraphYaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Consumer_MessageConsumed_Yaxis_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_522_validate_Consumer_MessageConsumedGraph_BrokerHeaderTitle() throws EncryptedDocumentException, IOException {
		overviewPage.clickOnConsumerTab();
		overviewPage.validateConsumerMessageConsumedGraphBrokerHeaderTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Consumer_MessageConsumed_Consumer_Header_Title"));
	}
	
	/*@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_523_validate_Consumer_MessageConsumedGraph_BrokerHeader_Arrow() throws EncryptedDocumentException, IOException {
		overviewPage.clickOnConsumerTab();
		overviewPage.validateConsumerMessageConsumedGraphBrokerHeaderArrow(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Consumer_MessageConsumed_Consumer_Header_Title"));
	}*/
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_525_validate_Consumer_MessageConsumedGraph_AvgHeaderTitle() throws EncryptedDocumentException, IOException {
		overviewPage.clickOnConsumerTab();
		overviewPage.validateConsumerMessageConsumedGraphAvgHeaderTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Consumer_MessageConsumed_Avg_Header_Title"));
	}
	
	/*@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_526_validate_Consumer_MessageConsumedGraph_AvgHeader_Arrow() throws EncryptedDocumentException, IOException {
		overviewPage.clickOnConsumerTab();
		overviewPage.validateConsumerMessageConsumedGraphAvgHeaderArrow(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Consumer_MessageConsumed_Consumer_Header_Title"));
	}*/
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_527_validate_Consumer_MessageConsumedGraph_MaxHeaderTitle() throws EncryptedDocumentException, IOException {
		overviewPage.clickOnConsumerTab();
		overviewPage.validateConsumerMessageConsumedGraphMaxHeaderTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Consumer_MessageConsumed_Max_Header_Title"));
	}
	
	/*@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_528_validate_Consumer_MessageConsumedGraph_AvgHeader_Arrow() throws EncryptedDocumentException, IOException {
		overviewPage.clickOnConsumerTab();
		overviewPage.validateConsumerMessageConsumedGraphAvgHeaderArrow(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Consumer_MessageConsumed_Consumer_Header_Title"));
	}*/
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_529_validate_Consumer_MessageConsumedGraph_RowColor1() throws EncryptedDocumentException, IOException {
		overviewPage.clickOnConsumerTab();
		overviewPage.validateConsumerMessageConsumedGraphRowColor1(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "rgb(255, 123, 123)"));
	}
	
	/*@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_530_validate_Consumer_MessageConsumedGraph_WidgetLegend1NameSort() throws EncryptedDocumentException, IOException, InterruptedException {
		overviewPage.clickOnConsumerTab();
		overviewPage.validateConsumerMessageConsumedWidgetLegendColumn1();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_531_validate_Consumer_MessageConsumedGraph_WidgetLegend2NameSort() throws EncryptedDocumentException, IOException, InterruptedException {
		overviewPage.clickOnConsumerTab();
		overviewPage.validateConsumerMessageConsumedWidgetLegendColumn2();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_532_validate_Consumer_MessageConsumedGraph_WidgetLegend3NameSort() throws EncryptedDocumentException, IOException, InterruptedException {
		overviewPage.clickOnConsumerTab();
		overviewPage.validateConsumerMessageConsumedWidgetLegendColumn3();
	}*/
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_534_validate_Consumer_MessageConsumedGraph_ExpandViewXAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		overviewPage.clickOnConsumerTab();
		overviewPage.validateConsumerMessageConsumedExpandViewXAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_535_validate_Consumer_MessageConsumedGraph_ExpandViewYAxisTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		overviewPage.clickOnConsumerTab();
		overviewPage.validateConsumerMessageConsumedExpandViewYAxisTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_536_validate_Consumer_MessageConsumedGraph_ExpandViewWidgetTitle() throws EncryptedDocumentException, IOException, InterruptedException {
		overviewPage.clickOnConsumerTab();
		overviewPage.validateConsumerMessageConsumedExpandViewWidgetTitle();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_537_validate_Consumer_MessageConsumedGraph_ExpandViewLegendHeader1() throws EncryptedDocumentException, IOException, InterruptedException {
		overviewPage.clickOnConsumerTab();
		overviewPage.validateConsumerMessageConsumedExpandViewLegendHeader1();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_538_validate_Consumer_MessageConsumedGraph_ExpandViewLegendHeader2() throws EncryptedDocumentException, IOException, InterruptedException {
		overviewPage.clickOnConsumerTab();
		overviewPage.validateConsumerMessageConsumedExpandViewLegendHeader2();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_539_validate_Consumer_MessageConsumedGraph_ExpandViewLegendHeader3() throws EncryptedDocumentException, IOException, InterruptedException {
		overviewPage.clickOnConsumerTab();
		overviewPage.validateConsumerMessageConsumedExpandViewLegendHeader3();
	}
	
/*	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_540_validate_Consumer_MessageConsumedGraph_ExpandViewHeader2InfoMessage() throws EncryptedDocumentException, IOException, InterruptedException {
		overviewPage.clickOnConsumerTab();
		overviewPage.validateConsumerMessageConsumedExpandViewLegendHeader2InforMessage();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_541_validate_Consumer_MessageConsumedGraph_ExpandViewHeader3InfoMessage() throws EncryptedDocumentException, IOException, InterruptedException {
		overviewPage.clickOnConsumerTab();
		overviewPage.validateConsumerMessageConsumedExpandViewLegendHeader3InforMessage();
	}*/
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_542_validate_Consumer_MessageConsumedGraph_ExpandViewZoomInBtn() throws EncryptedDocumentException, IOException, InterruptedException {
		overviewPage.clickOnConsumerTab();
		overviewPage.validateConsumerMessageConsumedExpandViewZoomIn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_543_validate_Consumer_MessageConsumedGraph_ExpandViewZoomOutBtn() throws EncryptedDocumentException, IOException, InterruptedException {
		overviewPage.clickOnConsumerTab();
		overviewPage.validateConsumerMessageConsumedExpandViewZoomOut();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_544_validate_Consumer_MessageConsumedGraph_ExpandViewWidgetDragDrop() throws EncryptedDocumentException, IOException, InterruptedException {
		overviewPage.clickOnConsumerTab();
		overviewPage.validateConsumerMessageConsumedExpandViewWidgetDragDrop();
	}	
	
		/************************************* Number Of Consumers Graph     *****************************************************/

//Consumer - Number Of Consumers Graph
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_545_validate_Consumer_NumberOfConsumersGraph_Title() throws EncryptedDocumentException, IOException {
		overviewPage.clickOnConsumerTab();
		overviewPage.validateConsumerNumberOfConsumersGraphTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Consumer_NumberOfConsumers_Graph_Title"));
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_546_validate_Consumer_NumberOfConsumersGraph_ZoomIn() throws EncryptedDocumentException, IOException {
		overviewPage.clickOnConsumerTab();
		overviewPage.validateConsumerNumberOfConsumersGraphZoomInBtn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_547_validate_Consumer_NumberOfConsumersGraph_ZoomOut() throws EncryptedDocumentException, IOException {
		overviewPage.clickOnConsumerTab();
		overviewPage.validateConsumerNumberOfConsumersGraphZoomOutBtn();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_548_validate_Consumer_NumberOfConsumersGraph_XaxisValue() throws EncryptedDocumentException, IOException {
		overviewPage.clickOnConsumerTab();
		overviewPage.validateConsumerNumberOfConsumersXaxisValues();
	}
	
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_549_validate_Consumer_NumberOfConsumersGraph_XaxisTitle() throws EncryptedDocumentException, IOException {
		overviewPage.clickOnConsumerTab();
		overviewPage.validateConsumerNumberOfConsumersGraphXaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Consumer_NumberOfConsumers_Xaxis_Title"));
	}
		
	@Test (groups = {"MQM","UI","Regression","Kafka","Sanity"})
	public void TC_550_validate_Consumer_NumberOfConsumers_Graph_YaxisTitle() throws EncryptedDocumentException, IOException {
		overviewPage.clickOnConsumerTab();
		overviewPage.validateConsumerNumberOfConsumersGraphYaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MQMExcelPath, IPathConstant.kafkaSheet_Overview, "Consumer_NumberOfConsumers_Yaxis_Title"));
	}
}
