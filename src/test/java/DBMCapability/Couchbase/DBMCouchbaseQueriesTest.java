package DBMCapability.Couchbase;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import genericUtilities.ExcelUtility;
import genericUtilities.IPathConstant;
import objectRepository.CommonPage;
import objectRepository.DBM.CouchbaseClusterOverviewPage;
import objectRepository.DBM.DBMCouchbaseNodePage;
import objectRepository.DBM.DBMCouchbaseQueriesPage;
import playWrightFactory.BaseClass;

public class DBMCouchbaseQueriesTest extends BaseClass{
	CommonPage commonPage;
	DBMCouchbaseQueriesPage queriesPage;
	CouchbaseClusterOverviewPage clusterPage;
	DBMCouchbaseNodePage nodePage;
	ExcelUtility excel = new ExcelUtility();
    
	@BeforeMethod
	public void queryPreRequest() throws EncryptedDocumentException, IOException {
		commonPage = new CommonPage(page);
		clusterPage = new CouchbaseClusterOverviewPage(page);
		nodePage = new DBMCouchbaseNodePage(page);
		queriesPage = new DBMCouchbaseQueriesPage(page);
		excel = new ExcelUtility();
		
		commonPage.navigateToDBM();
		clusterPage.navigateToCouchbase();
		commonPage.selectTheTimeLineFromCalender(IPathConstant.oneMonthTimeRange);
		queriesPage.navigateToQueriesPage();
		clusterPage.selectClusterFromDropdown();
		nodePage.selectNodeFromDropDown();
	}

	@Test (groups = {"DBM","UI","Regression","Couchbase","Sanity"})
	public void TC_01_validate_queriesPageTitle() throws EncryptedDocumentException, IOException {
		queriesPage.validateQueriesPageTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.couchBaseSheet, "Queries_QueriesTabTitle"));
	}
	
	
	@Test (groups = {"DBM","UI","Regression","Couchbase","Sanity"})
	public void TC_02_validate_RequestsWidgetTitle() throws EncryptedDocumentException, IOException {
		queriesPage.validateRequestsWidgetTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.couchBaseSheet, "Queries_RequestsWidgetTitle"));
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase","Sanity"})
	public void TC_03_validate_RequestsWidget_ZoomInBtnFunctionality() throws EncryptedDocumentException, IOException {
		queriesPage.validateRequestsZoomIn();
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase","Sanity"})
	public void TC_04_validate_RequestsWidget_ZoomOutBtnFunctionality() throws EncryptedDocumentException, IOException {
		queriesPage.validateRequestsZoomOut();
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase","Sanity"})
	public void TC_05_validate_RequestsWidget_ResetBtnFunctionality() throws EncryptedDocumentException, IOException {
		queriesPage.validateRequestsReset();
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase","Sanity"})
	public void TC_06_validate_RequestsWidget_DragAndDropFunctionality() throws EncryptedDocumentException, IOException {
		queriesPage.validateRequestsDragDrop();
	}
	

	@Test (groups = {"DBM","UI","Regression","Couchbase","Sanity"})
	public void TC_07_validate_RequestsWidget_XaxisValues_asPerSelectedTimeLine() throws EncryptedDocumentException, IOException {
		queriesPage.validateRequestsXaxisValues();
	}
	

	@Test (groups = {"DBM","UI","Regression","Couchbase","Sanity"})
	public void TC_08_validate_RequestsWidget_XaxisTitle() throws EncryptedDocumentException, IOException {
		queriesPage.validateRequestsXaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.couchBaseSheet, "Queries_RequestsWidgetXaxisTitle"));
	}
	

	@Test (groups = {"DBM","UI","Regression","Couchbase","Sanity"})
	public void TC_09_validate_RequestsWidget_YaxisTitle() throws EncryptedDocumentException, IOException {
		queriesPage.validateRequestsYaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.couchBaseSheet, "Queries_RequestsWidgetYaxisTitle"));
	}
	

	@Test (groups = {"DBM","UI","Regression","Couchbase","Sanity"})
	public void TC_10_validate_RequestsWidget_ToolTipTitle() throws EncryptedDocumentException, IOException {
		queriesPage.validateRequestsToolTipTitle();
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase","Sanity"})
	public void TC_11_validate_RequestsWidget_LegendsText() throws EncryptedDocumentException, IOException {
		queriesPage.validateRequestsWidgetLegendsText(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.couchBaseSheet, "Queries_RequestsWidgetLegendsText"));
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase","Sanity"})
	public void TC_12_validate_RequestsWidget_LegendsWithRespectiveToolTips() throws EncryptedDocumentException, IOException {
		queriesPage.validateRequestsWidgetLegendsWithRespectiveToolTips();
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase","Sanity"})
	public void TC_13_validate_requestTimeDistributionWidgetTitle() throws EncryptedDocumentException, IOException {
		queriesPage.validateRequestTimeDistributionWidgetTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.couchBaseSheet, "Queries_RequestTimeDistributionWidgetTitle"));
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase","Sanity"})
	public void TC_14_validate_RequestTimeDistributionWidget_ZoomInBtnFunctionality() throws EncryptedDocumentException, IOException {
		queriesPage.validateRequestTimeDistributionZoomIn();
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase","Sanity"})
	public void TC_15_validate_RequestTimeDistributionWidget_ZoomOutBtnFunctionality() throws EncryptedDocumentException, IOException {
		queriesPage.validateRequestTimeDistributionZoomOut();
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase","Sanity"})
	public void TC_16_validate_RequestTimeDistributionWidget_ResetBtnFunctionality() throws EncryptedDocumentException, IOException {
		queriesPage.validateRequestTimeDistributionReset();
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase","Sanity"})
	public void TC_17_validate_RequestTimeDistributionWidget_DragAndDropFunctionality() throws EncryptedDocumentException, IOException {
		queriesPage.validateRequestTimeDistributionDragDrop();
	}
	

	@Test (groups = {"DBM","UI","Regression","Couchbase","Sanity"})
	public void TC_18_validate_RequestTimeDistributionWidget_XaxisValues_asPerSelectedTimeLine() throws EncryptedDocumentException, IOException {
		queriesPage.validateRequestTimeDistributionXaxisValues();
	}
	

	@Test (groups = {"DBM","UI","Regression","Couchbase","Sanity"})
	public void TC_19_validate_RequestTimeDistributionWidget_XaxisTitle() throws EncryptedDocumentException, IOException {
		queriesPage.validateRequestTimeDistributionXaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.couchBaseSheet, "Queries_RequestTimeDistributionWidgetXaxisTitle"));
	}
	

	@Test (groups = {"DBM","UI","Regression","Couchbase","Sanity"})
	public void TC_20_validate_RequestTimeDistributionWidget_YaxisTitle() throws EncryptedDocumentException, IOException {
		queriesPage.validateRequestTimeDistributionYaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.couchBaseSheet, "Queries_RequestTimeDistributionWidgetYaxisTitle"));
	}
	

	@Test (groups = {"DBM","UI","Regression","Couchbase","Sanity"})
	public void TC_21_validate_RequestTimeDistributionWidget_ToolTipTitle() throws EncryptedDocumentException, IOException {
		queriesPage.validateRequestTimeDistributionToolTipTitle();
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase","Sanity"})
	public void TC_22_validate_RequestTimeDistributionWidget_LegendsText() throws EncryptedDocumentException, IOException {
		queriesPage.validateRequestTimeDistributionWidgetLegendsText(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.couchBaseSheet, "Queries_RequestTimeDistributionWidgetLegendsText"));
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase","Sanity"})
	public void TC_23_validate_RequestTimeDistributionWidget_LegendsWithRespectiveToolTips() throws EncryptedDocumentException, IOException {
		queriesPage.validateRequestTimeDistributionWidgetLegendsWithRespectiveToolTips();
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase","Sanity"})
	public void TC_24_validate_RequestThreadCountTitle() throws EncryptedDocumentException, IOException {
		queriesPage.validateRequestThreadCountWidgetTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.couchBaseSheet, "Queries_RequestThreadCountWidgetTitle"));
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase","Sanity"})
	public void TC_25_validate_RequestThreadCount_ZoomInBtnFunctionality() throws EncryptedDocumentException, IOException {
		queriesPage.validateRequestThreadCountZoomIn();
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase","Sanity"})
	public void TC_026_validate_RequestThreadCount_ZoomOutBtnFunctionality() throws EncryptedDocumentException, IOException {
		queriesPage.validateRequestThreadCountZoomOut();
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase","Sanity"})
	public void TC_27_validate_RequestThreadCount_ResetBtnFunctionality() throws EncryptedDocumentException, IOException {
		queriesPage.validateRequestThreadCountReset();
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase","Sanity"})
	public void TC_28_validate_RequestThreadCount_DragAndDropFunctionality() throws EncryptedDocumentException, IOException {
		queriesPage.validateRequestThreadCountDragDrop();
	}
	

	@Test (groups = {"DBM","UI","Regression","Couchbase","Sanity"})
	public void TC_29_validate_RequestThreadCount_XaxisValues_asPerSelectedTimeLine() throws EncryptedDocumentException, IOException {
		queriesPage.validateRequestThreadCountXaxisValues();
	}
	

	@Test (groups = {"DBM","UI","Regression","Couchbase","Sanity"})
	public void TC_30_validate_RequestThreadCount_XaxisTitle() throws EncryptedDocumentException, IOException {
		queriesPage.validateRequestThreadCountXaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.couchBaseSheet, "Queries_RequestThreadCountWidgetXaxisTitle"));
	}
	

	@Test (groups = {"DBM","UI","Regression","Couchbase","Sanity"})
	public void TC_31_validate_RequestThreadCount_YaxisTitle() throws EncryptedDocumentException, IOException {
		queriesPage.validateRequestThreadCountYaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.couchBaseSheet, "Queries_RequestThreadCountWidgetYaxisTitle"));
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase","Sanity"})
	public void TC_32_validate_RequestThreadCount_ToolTipTitle() throws EncryptedDocumentException, IOException {
		queriesPage.validateRequestThreadCountToolTipTitle();
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase","Sanity"})
	public void TC_33_validate_gcCountTitle() throws EncryptedDocumentException, IOException {
		queriesPage.validateGcCountWidgetTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.couchBaseSheet, "Queries_GCCountWidgetTitle"));
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase","Sanity"})
	public void TC_34_validate_gcCount_ZoomInBtnFunctionality() throws EncryptedDocumentException, IOException {
		queriesPage.validateGcCountZoomIn();
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase","Sanity"})
	public void TC_35_validate_gcCount_ZoomOutBtnFunctionality() throws EncryptedDocumentException, IOException {
		queriesPage.validateGcCountZoomOut();
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase","Sanity"})
	public void TC_36_validate_gcCount_ResetBtnFunctionality() throws EncryptedDocumentException, IOException {
		queriesPage.validateGcCountReset();
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase","Sanity"})
	public void TC_37_validate_gcCount_DragAndDropFunctionality() throws EncryptedDocumentException, IOException {
		queriesPage.validateGcCountDragDrop();
	}
	

	@Test (groups = {"DBM","UI","Regression","Couchbase","Sanity"})
	public void TC_38_validate_gcCount_XaxisValues_asPerSelectedTimeLines() throws EncryptedDocumentException, IOException {
		queriesPage.validateGcCountXaxisValues();
	}
	

	@Test (groups = {"DBM","UI","Regression","Couchbase","Sanity"})
	public void TC_39_validate_gcCount_XaxisTitle() throws EncryptedDocumentException, IOException {
		queriesPage.validateGcCountXaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.couchBaseSheet, "Queries_GCCountWidgetXaxisTitle"));
	}
	

	@Test (groups = {"DBM","UI","Regression","Couchbase","Sanity"})
	public void TC_40_validate_gcCount_YaxisTitle() throws EncryptedDocumentException, IOException {
		queriesPage.validateGcCountYaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.couchBaseSheet, "Queries_GCCountWidgetYaxisTitle"));
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase","Sanity"})
	public void TC_41_validate_gcCount_ToolTipTitle() throws EncryptedDocumentException, IOException {
		queriesPage.validateGcCountToolTipTitle();
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase","Sanity"})
	public void TC_42_validate_QueryThreshold_TableTitle() throws EncryptedDocumentException, IOException {
		queriesPage.validateQueryThresholdTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.couchBaseSheet, "Queries_QueryThresholdFieldTitle"));
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase","Sanity"})
	public void TC_43_validate_QueryThreshold_QueryNameHeader() throws EncryptedDocumentException, IOException {
		queriesPage.validateQueryNameHeaderTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.couchBaseSheet, "Queries_QueryNameText"));
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase","Sanity"})
	public void TC_44_validate_QueryThreshold_TotlalExecutionHeader() throws EncryptedDocumentException, IOException {
		queriesPage.validateTotalExecutionHeaderTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.couchBaseSheet, "Queries_TotalExecutionText"));
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase","Sanity"})
	public void TC_45_validate_QueryThreshold_ExecutionTime() throws EncryptedDocumentException, IOException {
		queriesPage.validateExecutionTimeHeaderTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.couchBaseSheet, "Queries_ExecutionTimeText"));
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase","Sanity"})
	public void TC_46_validate_QueryThreshold_TimeStamp() throws EncryptedDocumentException, IOException {
		queriesPage.validateTimeStampHeaderTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.couchBaseSheet, "Queries_TimeStampText"));
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase"})
	public void TC_47_validate_the_queriesPage_when_timeRangeIsChangedTo_5min() throws InterruptedException, EncryptedDocumentException, IOException {
		commonPage.selectTheTimeLineFromCalender(IPathConstant.fiveMinutesTimeRange);
		queriesPage.validateRequestsXaxisValues();
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase"})
	public void TC_48_validate_the_queriesPage_when_timeRangeIsChangedTo_15min() throws InterruptedException, EncryptedDocumentException, IOException {
		commonPage.selectTheTimeLineFromCalender(IPathConstant.fiveMinutesTimeRange);
		queriesPage.validateRequestsXaxisValues();
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase"})
	public void TC_49_validate_the_queriesPage_when_timeRangeIsChangedTo_1month() throws InterruptedException, EncryptedDocumentException, IOException {
		commonPage.selectTheTimeLineFromCalender(IPathConstant.oneMonthTimeRange);
		queriesPage.validateRequestsXaxisValues();
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase"})
	public void TC_50_validate_the_queriesPage_when_timeRangeIsChangedTo_30min() throws InterruptedException, EncryptedDocumentException, IOException {
		commonPage.selectTheTimeLineFromCalender(IPathConstant.thirtyMinutesTimeRange);
		queriesPage.validateRequestsXaxisValues();
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase"})
	public void TC_51_validate_the_queriesPage_when_timeRangeIsChangedTo_60min() throws InterruptedException, EncryptedDocumentException, IOException {
		commonPage.selectTheTimeLineFromCalender(IPathConstant.sixtyMinutesTimeRange);
		queriesPage.validateRequestsXaxisValues();
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase"})
	public void TC_52_validate_the_queriesPage_when_timeRangeIsChangedTo_3Hours() throws InterruptedException, EncryptedDocumentException, IOException {
		commonPage.selectTheTimeLineFromCalender(IPathConstant.threeHoursTimeRange);
		queriesPage.validateRequestsXaxisValues();
	}
	
	
	@Test (groups = {"DBM","UI","Regression","Couchbase"})
	public void TC_53_validate_the_queriesPage_when_timeRangeIsChangedTo_6Hours() throws InterruptedException, EncryptedDocumentException, IOException {
		commonPage.selectTheTimeLineFromCalender(IPathConstant.sixHoursTimeRange);
		queriesPage.validateRequestsXaxisValues();
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase"})
	public void TC_54_validate_the_queriesPage_when_timeRangeIsChangedTo_12Hours() throws InterruptedException, EncryptedDocumentException, IOException {
		commonPage.selectTheTimeLineFromCalender(IPathConstant.twelveHoursTimeRange);
		queriesPage.validateRequestsXaxisValues();
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase"})
	public void TC_55_validate_the_queriesPage_when_timeRangeIsChangedTo_1Day() throws InterruptedException, EncryptedDocumentException, IOException {
		commonPage.selectTheTimeLineFromCalender(IPathConstant.oneDayTimeRange);
		queriesPage.validateRequestsXaxisValues();
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase"})
	public void TC_56_validate_the_queriesPage_when_timeRangeIsChangedTo_1Week() throws InterruptedException, EncryptedDocumentException, IOException {
		commonPage.selectTheTimeLineFromCalender(IPathConstant.oneWeekTimeRange);
		queriesPage.validateRequestsXaxisValues();
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase"})
	public void TC_57_validate_the_queriesPage_when_timeRangeIsChangedTo_Custom_24mins_Range() throws InterruptedException, EncryptedDocumentException, IOException {
		commonPage.selectTheCustomeTimeLine(IPathConstant.customTimeRange, excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath, IPathConstant.calenderSheet, "customMinutesRange"));
		queriesPage.validateTheCustomTimeLine(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath, IPathConstant.calenderSheet, "customMinutesRange"));
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase"})
	public void TC_58_validate_the_queriesPage_when_timeRangeIsChangedTo_Custom_4hrs_Range() throws InterruptedException, EncryptedDocumentException, IOException {
		commonPage.selectTheCustomeTimeLine(IPathConstant.customTimeRange, excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath, IPathConstant.calenderSheet, "customHoursRange"));
		queriesPage.validateTheCustomTimeLine(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath, IPathConstant.calenderSheet, "customHoursRange"));
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase"})
	public void TC_59_validate_the_queriesPage_when_timeRangeIsChangedTo_Custom_10daysRange() throws InterruptedException, EncryptedDocumentException, IOException {
		commonPage.selectTheCustomeTimeLine(IPathConstant.customTimeRange, excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath, IPathConstant.calenderSheet, "customDaysRange"));
		queriesPage.validateTheCustomTimeLine(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath, IPathConstant.calenderSheet, "customDaysRange"));
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase"})
	public void TC_60_validate_the_queriesPage_when_timeRangeIsChangedTo_Custom_90daysRange() throws InterruptedException, EncryptedDocumentException, IOException {
		commonPage.selectTheCustomeTimeLine(IPathConstant.customTimeRange, excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath, IPathConstant.calenderSheet, "custom3monthsRange"));
		queriesPage.validateTheCustomTimeLine(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath, IPathConstant.calenderSheet, "custom3monthsRange"));
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase"})
	public void TC_61_validate_the_queriesPage_QueryThresoldDropdownList() throws InterruptedException, EncryptedDocumentException, IOException {
		queriesPage.validateTheQuerythresholdDropdown(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath,IPathConstant.couchBaseSheet,"Queries_ThresholdDropdownList"));
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase"})
	public void TC_62_validate_the_queriesPage_futureTimeLine_fromCustom() throws InterruptedException, EncryptedDocumentException, IOException {
		commonPage.validateTheFutureTimeLine();
	}
	
}	