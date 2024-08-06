package DBMCapability.Couchbase;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.microsoft.playwright.Page;

import genericUtilities.ExcelUtility;
import genericUtilities.IPathConstant;
import objectRepository.CommonPage;
import objectRepository.DBM.CouchbaseClusterOverviewPage;
import objectRepository.DBM.DBMCouchbaseBucketPage;
import objectRepository.DBM.DBMCouchbaseNodePage;
import playWrightFactory.BaseClass;

public class DBMCouchbaseBucketTest extends BaseClass{
	CommonPage commonPage;
	CouchbaseClusterOverviewPage clusterPage;
	DBMCouchbaseNodePage nodePage;
	DBMCouchbaseBucketPage bucketPage;
	ExcelUtility excel = new ExcelUtility();
	
	@BeforeMethod
	public void bucketPreRequest() throws EncryptedDocumentException, IOException {
		commonPage = new CommonPage(page);
		clusterPage = new CouchbaseClusterOverviewPage(page);
		nodePage = new DBMCouchbaseNodePage(page);
		bucketPage = new DBMCouchbaseBucketPage(page);
		excel = new ExcelUtility();
				
		commonPage.navigateToDBM();
		clusterPage.navigateToCouchbase();
		clusterPage.selectClusterFromDropdown();
		commonPage.selectTheTimeLineFromCalender(IPathConstant.oneMonthTimeRange);
		bucketPage.navigateToBucketPage();
		nodePage.selectNodeFromDropDown();
		bucketPage.selectBucketFromDropdown();
		
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase","Sanity"})
	public void TC_01_validate_bucketPageTitle() throws EncryptedDocumentException, IOException {
		bucketPage.validateBucketPageTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.couchBaseSheet, "Bucket_BucketTabTitle"));
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase","Sanity"})
	public void TC_02_validate_slectBucketNameText() throws EncryptedDocumentException, IOException {
		bucketPage.validateSelectBucketNameTextField(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.couchBaseSheet, "Bucket_SelectBucketNameText"));
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase","Sanity"})
	public void TC_03_validate_Bucket_BucketOpsWidgetTitle() throws EncryptedDocumentException, IOException {
		bucketPage.validateBucketOpswidgetTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.couchBaseSheet, "Bucket_BucketOpsWidgetTitle"));
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase","Sanity"})
	public void TC_04_validate_Bucket_BucketOpsWidget_XaxisTitle() throws EncryptedDocumentException, IOException {
		bucketPage.validateBucketOpsXaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.couchBaseSheet, "Bucket_BucketOpsXaxisTitle"));
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase","Sanity"})
	public void TC_05_validate_Bucket_BucketOpsWidget_YaxisTitle() throws EncryptedDocumentException, IOException {
		bucketPage.validateBucketOpsYaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.couchBaseSheet, "Bucket_BucketOpsYaxisTitle"));
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase","Sanity"})
	public void TC_06_validate_Bucket_BucketOps_ZoomInButton() {
		bucketPage.validateBucketOpsZoomInBtn();
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase","Sanity"})
	public void TC_07_validate_Bucket_BucketOps_ZoomOutButton() {
		bucketPage.validateBucketOpsZoomOutBtn();
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase","Sanity"})
	public void TC_08_validate_Bucket_BucketOps_ResetButton() {
		bucketPage.validateBucketOpsResetBtn();
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase"})
	public void TC_09_validate_Bucket_BucketOps_DragDrop() {
		bucketPage.validateBucketOpsGraphDragDrop();
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase"})
	public void TC_10_validate_Bucket_BucketOpsWidget_ToolTipTitle() throws InterruptedException{
		bucketPage.validateBucketOpsToolTipTitle();
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase"})
	public void TC_11_validate_Bucket_BucketOpsXaxisValues_asPer_SelectedTimeline() throws InterruptedException, EncryptedDocumentException, IOException {
		bucketPage.validateBucketOpsXaxisValues();
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase","Sanity"})
	public void TC_12_validate_Bucket_DiskUsedWidgetTitle() throws EncryptedDocumentException, IOException {
		bucketPage.validateDiskUsedwidgetTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.couchBaseSheet, "Bucket_DiskUsedWidgetTitle"));
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase","Sanity"})
	public void TC_13_validate_Bucket_DiskUsedWidget_XaxisTitle() throws EncryptedDocumentException, IOException {
		bucketPage.validateDiskUsedXaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.couchBaseSheet, "Bucket_DiskUsedXaxisTitle"));
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase","Sanity"})
	public void TC_14_validate_Bucket_DiskUsedWidget_YaxisTitle() throws EncryptedDocumentException, IOException {
		bucketPage.validateDiskUsedYaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.couchBaseSheet, "Bucket_DiskUsedYaxisTitle"));
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase","Sanity"})
	public void TC_15_validate_Bucket_DiskUsed_ZoomInButton() {
		bucketPage.validateDiskUsedZoomInBtn();
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase","Sanity"})
	public void TC_16_validate_Bucket_DiskUsed_ZoomOutButton() {
		bucketPage.validateDiskUsedZoomOutBtn();
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase","Sanity"})
	public void TC_17_validate_Bucket_DiskUsed_ResetButton() {
		bucketPage.validateDiskUsedResetBtn();
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase"})
	public void TC_18_validate_Bucket_DiskUsed_DragDrop() {
		bucketPage.validateDiskUsedGraphDragDrop();
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase"})
	public void TC_19_validate_Bucket_DiskUsedWidget_ToolTipTitle() throws InterruptedException{
		bucketPage.validateDiskUsedToolTipTitle();
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase"})
	public void TC_20_validate_Bucket_DiskUsedXaxisValues_asPer_SelectedTimeline() throws InterruptedException, EncryptedDocumentException, IOException {
		bucketPage.validateDiskUsedXaxisValues();
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase","Sanity"})
	public void TC_21_validate_Bucket_MemUsedWidgetTitle() throws EncryptedDocumentException, IOException {
		bucketPage.validateMemUsedwidgetTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.couchBaseSheet, "Bucket_MemUsedWidgetTitle"));
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase","Sanity"})
	public void TC_22_validate_Bucket_MemUsedWidget_XaxisTitle() throws EncryptedDocumentException, IOException {
		bucketPage.validateMemUsedXaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.couchBaseSheet, "Bucket_MemUsedXaxisTitle"));
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase","Sanity"})
	public void TC_23_validate_Bucket_MemUsedWidget_YaxisTitle() throws EncryptedDocumentException, IOException {
		bucketPage.validateMemUsedYaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.couchBaseSheet, "Bucket_MemUsedYaxisTitle"));
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase","Sanity"})
	public void TC_24_validate_Bucket_MemUsed_ZoomInButton() {
		bucketPage.validateMemUsedZoomInBtn();
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase","Sanity"})
	public void TC_25_validate_Bucket_MemUsed_ZoomOutButton() {
		bucketPage.validateMemUsedZoomOutBtn();
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase","Sanity"})
	public void TC_26_validate_Bucket_MemUsed_ResetButton() {
		bucketPage.validateMemUsedResetBtn();
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase"})
	public void TC_27_validate_Bucket_MemUsed_DragDrop() {
		bucketPage.validateMemUsedGraphDragDrop();
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase"})
	public void TC_28_validate_Bucket_MemUsedWidget_ToolTipTitle() throws InterruptedException{
		bucketPage.validateMemUsedToolTipTitle();
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase"})
	public void TC_29_validate_Bucket_MemUsedXaxisValues_asPer_SelectedTimeline() throws InterruptedException, EncryptedDocumentException, IOException {
		bucketPage.validateMemUsedXaxisValues();
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase","Sanity"})
	public void TC_30_validate_Bucket_CurrentItemsWidgetTitle() throws EncryptedDocumentException, IOException {
		bucketPage.validateCurrentItemswidgetTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.couchBaseSheet, "Bucket_CurrentItemsWidgetTitle"));
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase","Sanity"})
	public void TC_31_validate_Bucket_CurrentItemsWidget_XaxisTitle() throws EncryptedDocumentException, IOException {
		bucketPage.validateCurrentItemsXaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.couchBaseSheet, "Bucket_CurrentItemsXaxisTitle"));
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase","Sanity"})
	public void TC_32_validate_Bucket_CurrentItemsWidget_YaxisTitle() throws EncryptedDocumentException, IOException {
		bucketPage.validateCurrentItemsYaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.couchBaseSheet, "Bucket_CurrentItemsYaxisTitle"));
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase","Sanity"})
	public void TC_33_validate_Bucket_CurrentItems_ZoomInButton() {
		bucketPage.validateCurrentItemsZoomInBtn();
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase","Sanity"})
	public void TC_34_validate_Bucket_CurrentItems_ZoomOutButton() {
		bucketPage.validateCurrentItemsZoomOutBtn();
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase","Sanity"})
	public void TC_35_validate_Bucket_CurrentItems_ResetButton() {
		bucketPage.validateCurrentItemsResetBtn();
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase"})
	public void TC_36_validate_Bucket_CurrentItems_DragDrop() {
		bucketPage.validateCurrentItemsGraphDragDrop();
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase"})
	public void TC_37_validate_Bucket_CurrentItemsWidget_ToolTipTitle() throws InterruptedException{
		bucketPage.validateCurrentItemsToolTipTitle();
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase"})
	public void TC_38_validate_Bucket_CurrentItemsXaxisValues_asPer_SelectedTimeline() throws InterruptedException, EncryptedDocumentException, IOException {
		bucketPage.validateCurrentItemsXaxisValues();
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase"})
	public void TC_39_validate_the_BucketPage_when_timeRangeIsChangedTo_5min() throws InterruptedException, EncryptedDocumentException, IOException {
		commonPage.selectTheTimeLineFromCalender(IPathConstant.fiveMinutesTimeRange);
		bucketPage.validateBucketOpsXaxisValues();
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase"})
	public void TC_40_validate_the_BucketPage_when_timeRangeIsChangedTo_15min() throws InterruptedException, EncryptedDocumentException, IOException {
		commonPage.selectTheTimeLineFromCalender(IPathConstant.fiveMinutesTimeRange);
		bucketPage.validateBucketOpsXaxisValues();
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase"})
	public void TC_41_validate_the_BucketPage_when_timeRangeIsChangedTo_1month() throws InterruptedException, EncryptedDocumentException, IOException {
		commonPage.selectTheTimeLineFromCalender(IPathConstant.oneMonthTimeRange);
		bucketPage.validateBucketOpsXaxisValues();
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase"})
	public void TC_42_validate_the_BucketPage_when_timeRangeIsChangedTo_30min() throws InterruptedException, EncryptedDocumentException, IOException {
		commonPage.selectTheTimeLineFromCalender(IPathConstant.thirtyMinutesTimeRange);
		bucketPage.validateBucketOpsXaxisValues();
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase"})
	public void TC_43_validate_the_BucketPage_when_timeRangeIsChangedTo_60min() throws InterruptedException, EncryptedDocumentException, IOException {
		commonPage.selectTheTimeLineFromCalender(IPathConstant.sixtyMinutesTimeRange);
		bucketPage.validateBucketOpsXaxisValues();
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase"})
	public void TC_44_validate_the_BucketPage_when_timeRangeIsChangedTo_3Hours() throws InterruptedException, EncryptedDocumentException, IOException {
		commonPage.selectTheTimeLineFromCalender(IPathConstant.threeHoursTimeRange);
		bucketPage.validateBucketOpsXaxisValues();
	}
	
	
	@Test (groups = {"DBM","UI","Regression","Couchbase"})
	public void TC_45_validate_the_BucketPage_when_timeRangeIsChangedTo_6Hours() throws InterruptedException, EncryptedDocumentException, IOException {
		commonPage.selectTheTimeLineFromCalender(IPathConstant.sixHoursTimeRange);
		bucketPage.validateBucketOpsXaxisValues();
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase"})
	public void TC_46_validate_the_BucketPage_when_timeRangeIsChangedTo_12Hours() throws InterruptedException, EncryptedDocumentException, IOException {
		commonPage.selectTheTimeLineFromCalender(IPathConstant.twelveHoursTimeRange);
		bucketPage.validateBucketOpsXaxisValues();
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase"})
	public void TC_47_validate_the_BucketPage_when_timeRangeIsChangedTo_1Day() throws InterruptedException, EncryptedDocumentException, IOException {
		commonPage.selectTheTimeLineFromCalender(IPathConstant.oneDayTimeRange);
		bucketPage.validateBucketOpsXaxisValues();
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase"})
	public void TC_48_validate_the_BucketPage_when_timeRangeIsChangedTo_1Week() throws InterruptedException, EncryptedDocumentException, IOException {
		commonPage.selectTheTimeLineFromCalender(IPathConstant.oneWeekTimeRange);
		bucketPage.validateBucketOpsXaxisValues();
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase"})
	public void TC_49_validate_the_BucketPage_when_timeRangeIsChangedTo_Custom_24mins_Range() throws InterruptedException, EncryptedDocumentException, IOException {
		commonPage.selectTheCustomeTimeLine(IPathConstant.customTimeRange, excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath, IPathConstant.calenderSheet, "customMinutesRange"));
		bucketPage.validateTheCustomTimeLine(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath, IPathConstant.calenderSheet, "customMinutesRange"));
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase"})
	public void TC_50_validate_the_BucketPage_when_timeRangeIsChangedTo_Custom_4hrs_Range() throws InterruptedException, EncryptedDocumentException, IOException {
		commonPage.selectTheCustomeTimeLine(IPathConstant.customTimeRange, excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath, IPathConstant.calenderSheet, "customHoursRange"));
		bucketPage.validateTheCustomTimeLine(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath, IPathConstant.calenderSheet, "customHoursRange"));
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase"})
	public void TC_51_validate_the_BucketPage_when_timeRangeIsChangedTo_Custom_10daysRange() throws InterruptedException, EncryptedDocumentException, IOException {
		commonPage.selectTheCustomeTimeLine(IPathConstant.customTimeRange, excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath, IPathConstant.calenderSheet, "customDaysRange"));
		bucketPage.validateTheCustomTimeLine(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath, IPathConstant.calenderSheet, "customDaysRange"));
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase"})
	public void TC_52_validate_the_BucketPage_when_timeRangeIsChangedTo_Custom_90daysRange() throws InterruptedException, EncryptedDocumentException, IOException {
		commonPage.selectTheCustomeTimeLine(IPathConstant.customTimeRange, excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath, IPathConstant.calenderSheet, "custom3monthsRange"));
		bucketPage.validateTheCustomTimeLine(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath, IPathConstant.calenderSheet, "custom3monthsRange"));
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase"})
	public void TC_53_validate_the_BucketPage_futureTimeLine_fromCustom() throws InterruptedException, EncryptedDocumentException, IOException {
    commonPage.validateTheFutureTimeLine();
	}
	
}
