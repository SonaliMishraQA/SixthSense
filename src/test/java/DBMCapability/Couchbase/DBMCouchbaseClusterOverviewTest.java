package DBMCapability.Couchbase;

import org.testng.annotations.Test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import genericUtilities.ExcelUtility;
import genericUtilities.GenericMethods;
import genericUtilities.IPathConstant;
import objectRepository.CommonPage;
import objectRepository.DBM.CouchbaseClusterOverviewPage;
import playWrightFactory.BaseClass;


public class DBMCouchbaseClusterOverviewTest extends BaseClass{
	CommonPage commonPage;
	CouchbaseClusterOverviewPage clusterPage;
	ExcelUtility excel = new ExcelUtility();
	
    @BeforeMethod
    public void request() throws EncryptedDocumentException, IOException 
    {
    	commonPage = new CommonPage(page);
    	clusterPage = new CouchbaseClusterOverviewPage(page);
    	excel = new ExcelUtility();
    	
    	commonPage.navigateToDBM();
    	clusterPage.navigateToCouchbase();
    	clusterPage.navigateToClusterOverviewTab();
    	clusterPage.selectClusterFromDropdown();
    	commonPage.selectTheTimeLineFromCalender(IPathConstant.oneMonthTimeRange);
    }
	
    
	@Test (groups = {"DBM","UI","Regression","Couchbase","Sanity"})
	public void TC_01_validate_The_DBM_Capability_Title_in_CouchBasePage() throws EncryptedDocumentException, IOException {
		clusterPage.validateDbmPageTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.couchBaseSheet, "DBMPageTitle"));
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase","Sanity"})
	public void TC_02_validate_if_clusterOverviewTab_isdisplayed_asDefault() throws EncryptedDocumentException, IOException {
		clusterPage.validateClusterNameCardIsVisible();
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase","Sanity"})
	public void TC_03_validate_clusterOverviewTab_Title() throws EncryptedDocumentException, IOException {
		clusterPage.validateClusterOverviewTabTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.couchBaseSheet, "ClusterOverviewTabTitle"));
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase","Sanity"})
	public void TC_04_validate_ClusterNameCard() throws EncryptedDocumentException, IOException {
		clusterPage.navigateToClusterOverviewTab();
		clusterPage.validateClusterNameCard(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.couchBaseSheet, "Cluster_ClusterNameCard"));
	}
	
	
	@Test (groups = {"DBM","UI","Regression","Couchbase","Sanity"})
	public void TC_05_validate_CouchbaseVersionCard() throws EncryptedDocumentException, IOException {
		clusterPage.validateCouchbaseVersionCard(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.couchBaseSheet, "Cluster_CouchbaseVersionCard"));
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase","Sanity"})
	public void TC_06_validate_StatusCard() throws EncryptedDocumentException, IOException {
		clusterPage.validateStatusCard(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.couchBaseSheet, "Cluster_StatusCard"));
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase","Sanity"})
	public void TC_07_validate_selectDatabaseTypeText() throws EncryptedDocumentException, IOException {
		clusterPage.validateSelectDatabaseTypeTxt(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.couchBaseSheet, "Couchbase_selectDatbaseTypeText"));
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase","Sanity"})
	public void TC_08_validate_NumberOfNodesCard() throws EncryptedDocumentException, IOException {
		clusterPage.validateNumberOfNodesCard(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.couchBaseSheet, "Cluster_NumberofNodesCard"));
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase","Sanity"})
	public void TC_09_validate_NumberOfBucketsCard() throws EncryptedDocumentException, IOException {
		clusterPage.validateNumberOfBucketsCard(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.couchBaseSheet, "Cluster_NumberOfBukcetsCard"));
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase","Sanity"})
	public void TC_10_validate_selectClusterText() throws EncryptedDocumentException, IOException {
		clusterPage.validateSelectClusterTxt(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.couchBaseSheet, "Couchbase_selectClusterText"));
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase","Sanity"})
	public void TC_11_validate_DiskUsageCard() throws EncryptedDocumentException, IOException {
		clusterPage.validateDiskUsageCardTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.couchBaseSheet, "Cluster_DiskUsageCard"));
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase","Sanity"})
	public void TC_12_validate_UsedText_on_DiskUsagecard() throws EncryptedDocumentException, IOException {
		clusterPage.validateUsedText(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.couchBaseSheet, "Cluster_UsedText"));
	}
	
	
	@Test (groups = {"DBM","UI","Regression","Couchbase","Sanity"})
	public void TC_13_validate_AvailableText_on_DiskUsagecard() throws EncryptedDocumentException, IOException {
		clusterPage.validateAvailableText(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.couchBaseSheet, "Cluster_AvailableText"));
	}
	
	
	@Test (groups = {"DBM","UI","Regression","Couchbase","Sanity"})
	public void TC_014_validate_Cluster_cpuUsageWidgetTitle() throws EncryptedDocumentException, IOException {
		clusterPage.validateClusterCpuUsageWidvalidateTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.couchBaseSheet, "ClusterCPUUsageWidgetTitle"));
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase","Sanity"})
	public void TC_15_validate_Cluster_cpuUsageWidget_XaxisTitle() throws EncryptedDocumentException, IOException {
		clusterPage.validateClusterCpuUsageXaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.couchBaseSheet, "ClusterCPUUsageWidgetXaxisTitle"));
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase","Sanity"})
	public void TC_16_validate_Cluster_cpuUsageWidget_YaxisTitle() throws EncryptedDocumentException, IOException {
		clusterPage.validateClusterCpuUsageYaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.couchBaseSheet, "ClusterCPUUsageWidgetYaxisTitle"));
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase","Sanity"})
	public void TC_17_validate_Cluster_cpuUsage_ZoomInButton() {
		clusterPage.validateClusterCpuUsageZoomInBtn();
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase","Sanity"})
	public void TC_18_validate_Cluster_cpuUsage_ZoomOutButton() {
		clusterPage.validateClusterCpuUsageZoomOutBtn();
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase","Sanity"})
	public void TC_19_validate_Cluster_cpuUsage_ResetButton() {
		clusterPage.validateClusterCpuUsageResetBtn();
	}
	
	
	@Test (groups = {"DBM","UI","Regression","Couchbase","Sanity"})
	public void TC_20_validate_Cluster_RAMUsageWidgetTitle() throws EncryptedDocumentException, IOException {
		clusterPage.validateClusterRamUsageWidvalidateTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.couchBaseSheet, "ClusterRAMUsageWidgetTitle"));
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase","Sanity"})
	public void TC_21_validate_Cluster_RAMUsageWidget_XaxisTitle() throws EncryptedDocumentException, IOException {
		clusterPage.validateClusterRamUsageXaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.couchBaseSheet, "ClusterRAMUsageXaxisTitle"));
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase","Sanity"})
	public void TC_22_validate_Cluster_RAMUsageWidget_YaxisTitle() throws EncryptedDocumentException, IOException {
		clusterPage.validateClusterRamUsageYaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.couchBaseSheet, "ClusterRAMUsageYaxisTitle"));
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase"})
	public void TC_23_validate_Cluster_RAMUsage_ZoomInButton() {
		clusterPage.validateClusterRamUsageZoomInBtn();
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase"})
	public void TC_24_validate_Cluster_RAMUsage_ZoomOutButton() {
		clusterPage.validateClusterRamUsageZoomOutBtn();
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase"})
	public void TC_25_validate_Cluster_RAMUsage_ResetButton() {
		clusterPage.validateClusterRamUsageResetBtn();
	}
	

	@Test (groups = {"DBM","UI","Regression","Couchbase"})
	public void TC_26_validate_Cluster_CpuUsage_DragDrop() {
		clusterPage.validateClusterCpuUsageDragDrop();
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase"})
	public void TC_27_validate_Cluster_RAMUsage_DragDrop() {
		clusterPage.validateClusterRAMUsageDragDrop();
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase"})
	public void TC_28_validate_Cluster_CpuUsageWidget_ToolTipTitle() throws InterruptedException{
		clusterPage.validateClusterCpuUsagetoolTipTitle();
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase"})
	public void TC_29_validate_Cluster_RAMUsageWidget_ToolTipTitle() throws InterruptedException {
		clusterPage.validateClusterRamUsagetoolTipTitle();
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase"})
	public void TC_30_validate_Cluster_DiskUsageCard_is_displaying_NoDataText_WhenThereIsNoData() throws InterruptedException, EncryptedDocumentException, IOException {
		clusterPage.validateDiskUsageCardNodataText(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.couchBaseSheet, "Cluster_diskUsageCardNodataText"));
	}
	
	
	@Test (groups = {"DBM","UI","Regression","Couchbase"})
	public void TC_31_validate_Cluster_CpuUsageXaxisValues_asPer_SelectedTimeline() throws InterruptedException, EncryptedDocumentException, IOException {
		clusterPage.validateClusterCpuUsageXaxisValues();
	}
	

	@Test (groups = {"DBM","UI","Regression","Couchbase"})
	public void TC_32_validate_Cluster_RAMUsageXaxisValues_asPer_SelectedTimeline() throws InterruptedException, EncryptedDocumentException, IOException {
		clusterPage.validateClusterRAMUsageXaxisValues();
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase"})
	public void TC_33_validate_the_ClusterPage_when_timeRangeIsChangedTo_5min() throws InterruptedException, EncryptedDocumentException, IOException {
		commonPage.selectTheTimeLineFromCalender(IPathConstant.fiveMinutesTimeRange);
		clusterPage.validateClusterCpuUsageXaxisValues();
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase"})
	public void TC_34_validate_the_ClusterPage_when_timeRangeIsChangedTo_15min() throws InterruptedException, EncryptedDocumentException, IOException {
		commonPage.selectTheTimeLineFromCalender(IPathConstant.fiveMinutesTimeRange);
		clusterPage.validateClusterCpuUsageXaxisValues();
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase"})
	public void TC_35_validate_the_ClusterPage_when_timeRangeIsChangedTo_1month() throws InterruptedException, EncryptedDocumentException, IOException {
		commonPage.selectTheTimeLineFromCalender(IPathConstant.oneMonthTimeRange);
		clusterPage.validateClusterCpuUsageXaxisValues();
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase"})
	public void TC_36_validate_the_ClusterPage_when_timeRangeIsChangedTo_30min() throws InterruptedException, EncryptedDocumentException, IOException {
		commonPage.selectTheTimeLineFromCalender(IPathConstant.thirtyMinutesTimeRange);
		clusterPage.validateClusterCpuUsageXaxisValues();
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase"})
	public void TC_37_validate_the_ClusterPage_when_timeRangeIsChangedTo_60min() throws InterruptedException, EncryptedDocumentException, IOException {
		commonPage.selectTheTimeLineFromCalender(IPathConstant.sixtyMinutesTimeRange);
		clusterPage.validateClusterCpuUsageXaxisValues();
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase"})
	public void TC_38_validate_the_ClusterPage_when_timeRangeIsChangedTo_3Hours() throws InterruptedException, EncryptedDocumentException, IOException {
		commonPage.selectTheTimeLineFromCalender(IPathConstant.threeHoursTimeRange);
		clusterPage.validateClusterCpuUsageXaxisValues();
	}
	
	
	@Test (groups = {"DBM","UI","Regression","Couchbase"})
	public void TC_39_validate_the_ClusterPage_when_timeRangeIsChangedTo_6Hours() throws InterruptedException, EncryptedDocumentException, IOException {
		commonPage.selectTheTimeLineFromCalender(IPathConstant.sixHoursTimeRange);
		clusterPage.validateClusterCpuUsageXaxisValues();
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase"})
	public void TC_40_validate_the_ClusterPage_when_timeRangeIsChangedTo_12Hours() throws InterruptedException, EncryptedDocumentException, IOException {
		commonPage.selectTheTimeLineFromCalender(IPathConstant.twelveHoursTimeRange);
		clusterPage.validateClusterCpuUsageXaxisValues();
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase"})
	public void TC_41_validate_the_ClusterPage_when_timeRangeIsChangedTo_1Day() throws InterruptedException, EncryptedDocumentException, IOException {
		commonPage.selectTheTimeLineFromCalender(IPathConstant.oneDayTimeRange);
		clusterPage.validateClusterCpuUsageXaxisValues();
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase"})
	public void TC_42_validate_the_ClusterPage_when_timeRangeIsChangedTo_1Week() throws InterruptedException, EncryptedDocumentException, IOException {
		commonPage.selectTheTimeLineFromCalender(IPathConstant.oneWeekTimeRange);
		clusterPage.validateClusterCpuUsageXaxisValues();
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase"})
	public void TC_43_validate_the_ClusterPage_when_timeRangeIsChangedTo_Custom_24mins_Range() throws InterruptedException, EncryptedDocumentException, IOException {
		commonPage.selectTheCustomeTimeLine(IPathConstant.customTimeRange, excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath, IPathConstant.calenderSheet, "customMinutesRange"));
		clusterPage.validateTheCustomTimeLine(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath, IPathConstant.calenderSheet, "customMinutesRange"));
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase"})
	public void TC_44_validate_the_ClusterPage_when_timeRangeIsChangedTo_Custom_4hrs_Range() throws InterruptedException, EncryptedDocumentException, IOException {
		commonPage.selectTheCustomeTimeLine(IPathConstant.customTimeRange, excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath, IPathConstant.calenderSheet, "customHoursRange"));
		clusterPage.validateTheCustomTimeLine(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath, IPathConstant.calenderSheet, "customHoursRange"));
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase"})
	public void TC_45_validate_the_ClusterPage_when_timeRangeIsChangedTo_Custom_10daysRange() throws InterruptedException, EncryptedDocumentException, IOException {
		commonPage.selectTheCustomeTimeLine(IPathConstant.customTimeRange, excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath, IPathConstant.calenderSheet, "customDaysRange"));
		clusterPage.validateTheCustomTimeLine(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath, IPathConstant.calenderSheet, "customDaysRange"));
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase"})
	public void TC_46_validate_the_ClusterPage_when_timeRangeIsChangedTo_Custom_90daysRange() throws InterruptedException, EncryptedDocumentException, IOException {
		commonPage.selectTheCustomeTimeLine(IPathConstant.customTimeRange, excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath, IPathConstant.calenderSheet, "custom3monthsRange"));
		clusterPage.validateTheCustomTimeLine(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath, IPathConstant.calenderSheet, "custom3monthsRange"));
	}
	
	
	@Test (groups = {"DBM","UI","Regression","Couchbase"})
	public void TC_47_validate_the_ClusterPage_DiskUsageCard_Used_LegendColor() throws InterruptedException, EncryptedDocumentException, IOException {
		clusterPage.validateUsedIcon(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.couchBaseSheet, "Cluster_UsedIcon"));
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase"})
	public void TC_48_validate_the_ClusterPage_DiskUsageCard_Available_LegendColor() throws InterruptedException, EncryptedDocumentException, IOException {
		clusterPage.validateAvailableIcon(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.couchBaseSheet, "Cluster_AvailableIcon"));
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase"})
	public void TC_49_validate_the_ClusterPage_futureTimeLine_fromCustom() throws InterruptedException, EncryptedDocumentException, IOException {
    commonPage.validateTheFutureTimeLine();
	}
	
}