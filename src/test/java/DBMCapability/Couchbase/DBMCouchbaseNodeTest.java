package DBMCapability.Couchbase;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import genericUtilities.ExcelUtility;
import genericUtilities.IPathConstant;
import objectRepository.CommonPage;
import objectRepository.DBM.CouchbaseClusterOverviewPage;
import objectRepository.DBM.DBMCouchbaseNodePage;
import playWrightFactory.BaseClass;

public class DBMCouchbaseNodeTest extends BaseClass
{
	CommonPage commonPage;
	DBMCouchbaseNodePage nodePage;
	CouchbaseClusterOverviewPage clusterPage;
	ExcelUtility excel  = new ExcelUtility();
	
	@BeforeMethod
	public void nodePreRequest() throws EncryptedDocumentException, IOException{
		commonPage = new CommonPage(page);
		nodePage = new DBMCouchbaseNodePage(page);
		clusterPage = new CouchbaseClusterOverviewPage(page);
		excel = new ExcelUtility();
		
		
		commonPage.navigateToDBM();
		clusterPage.navigateToCouchbase();
		commonPage.selectTheTimeLineFromCalender(IPathConstant.oneMonthTimeRange);
		nodePage.navigateToNodeTab();
		clusterPage.selectClusterFromDropdown();
		//nodePage.selectNodeFromDropDown();
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase","Sanity"})
	public void TC_01_validate_nodeTab_Title() throws EncryptedDocumentException, IOException {
		nodePage.validateNodePageTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.couchBaseSheet, "Node_NodeTabTitle"));
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase","Sanity"})
	public void TC_02_validate_nodeName() throws EncryptedDocumentException, IOException {
		nodePage.validateNodeName(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.couchBaseSheet, "Node_NodeNameCard"));
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase","Sanity"})
	public void TC_03_validate_nodeVersion() throws EncryptedDocumentException, IOException {
		nodePage.validateNodeVersion(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.couchBaseSheet, "Node_NodeVersionCard"));
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase","Sanity"})
	public void TC_04_validate_nodeStatus() throws EncryptedDocumentException, IOException {
		nodePage.validateNodeStatus(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.couchBaseSheet, "Node_NodeStatusCard"));
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase","Sanity"})
	public void TC_05_validate_nodeOS() throws EncryptedDocumentException, IOException {
		nodePage.validateNodeOs(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.couchBaseSheet, "Node_NodeOSCard"));
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase","Sanity"})
	public void TC_06_validate_nodeUpTime() throws EncryptedDocumentException, IOException {
		nodePage.validateNodeUpTime(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.couchBaseSheet, "Node_NodeUptimeCard"));
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase","Sanity"})
	public void TC_07_validate_nodeDiskUsageCardTitle() throws EncryptedDocumentException, IOException {
		nodePage.validateDiskUsageCardTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.couchBaseSheet, "Node_DiskUsageCard"));
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase","Sanity"})
	public void TC_08_validate_UsedTextTitle_in_DiskUsageCard() throws EncryptedDocumentException, IOException {
		nodePage.validateUsedText(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.couchBaseSheet, "Node_UsedText"));
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase","Sanity"})
	public void TC_09_AvailableTextTitle_in_DiskUsageCard() throws EncryptedDocumentException, IOException {
		nodePage.validateAvailableText(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.couchBaseSheet, "Node_AvailableText"));
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase"})
	public void TC_10_validate_nodeUsedIconColor_presentIn_DiskUsageCard() throws EncryptedDocumentException, IOException {
		nodePage.validateUsedIcon(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.couchBaseSheet, "Node_UsedIcon"));
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase"})
	public void TC_11_validate_nodeAvailableIconColor_presentIn_DiskUsageCard() throws EncryptedDocumentException, IOException {
		nodePage.validateAvailableIcon(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.couchBaseSheet, "Node_AvailableIcon"));
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase"})
	public void TC_12_validate_node_NoDataText_in_DiskUsageCard() throws EncryptedDocumentException, IOException {
		nodePage.validateDiskUsageCardNodataText(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.couchBaseSheet, "Node_NoDataText"));
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase"})
	public void TC_13_validate_node_CpuUsageWidgetTitle() throws EncryptedDocumentException, IOException {
		nodePage.validateCpuUsagewidgetTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.couchBaseSheet, "Node_CPUUsageWidgetTitle"));
	}
	
	
	@Test (groups = {"DBM","UI","Regression","Couchbase"})
	public void TC_14_validate_node_CpuUsageWidget_ZoomInFunctionality() throws EncryptedDocumentException, IOException {
		nodePage.validateCpuUsageZoomInBtn();
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase"})
	public void TC_15_validate_node_CpuUsageWidget_ZoomOutFunctionality() throws EncryptedDocumentException, IOException {
		nodePage.validateCpuUsageZoomOutBtn();
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase"})
	public void TC_16_validate_node_CpuUsageWidget_ResetBtnFunctionality() throws EncryptedDocumentException, IOException {
		nodePage.validateCpuUsageResetBtn();
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase"})
	public void TC_17_validate_node_CpuUsageWidget_XaxisValues() throws EncryptedDocumentException, IOException {
		nodePage.validateCpuUsageXaxisValues();
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase"})
	public void TC_18_validate_node_CpuUsageWidget_XaxisTitle() throws EncryptedDocumentException, IOException {
		nodePage.validateCpuUsageXaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.couchBaseSheet, "Node_CPUUsageWidgetXaxisTitle"));
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase"})
	public void TC_19_validate_node_CpuUsageWidget_YaxisTitle() throws EncryptedDocumentException, IOException {
		nodePage.validateCpuUsageYaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.couchBaseSheet, "Node_CPUUsageWidgetYaxisTitle"));
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase"})
	public void TC_20_validate_node_CpuUsageWidget_ToolTipTitle() throws EncryptedDocumentException, IOException {
		nodePage.validateCpuUsageToolTipTitle();
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase"})
	public void TC_21_validate_node_RamUsageWidgetTitle() throws EncryptedDocumentException, IOException {
		nodePage.validateRamUsagewidgetTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.couchBaseSheet, "Node_RamUsageWidgetTitle"));
	}
	
	
	@Test (groups = {"DBM","UI","Regression","Couchbase"})
	public void TC_22_validate_node_RamUsageWidget_ZoomInFunctionality() throws EncryptedDocumentException, IOException {
		nodePage.validateRamUsageZoomInBtn();
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase"})
	public void TC_23_validate_node_RamUsageWidget_ZoomOutFunctionality() throws EncryptedDocumentException, IOException {
		nodePage.validateRamUsageZoomOutBtn();
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase"})
	public void TC_24_validate_node_RamUsageWidget_ResetBtnFunctionality() throws EncryptedDocumentException, IOException {
		nodePage.validateRamUsageResetBtn();
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase"})
	public void TC_25_validate_node_RamUsageWidget_XaxisValues() throws EncryptedDocumentException, IOException {
		nodePage.validateRamUsageXaxisValues();
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase"})
	public void TC_26_validate_node_RamUsageWidget_XaxisTitle() throws EncryptedDocumentException, IOException {
		nodePage.validateRamUsageXaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.couchBaseSheet, "Node_RamUsageWidgetXaxisTitle"));
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase"})
	public void TC_27_validate_node_RamUsageWidget_YaxisTitle() throws EncryptedDocumentException, IOException {
		nodePage.validateRamUsageYaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.couchBaseSheet, "Node_RamUsageWidgetYaxisTitle"));
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase"})
	public void TC_28_validate_node_RamUsageWidget_ToolTipTitle() throws EncryptedDocumentException, IOException {
		nodePage.validateRamUsageToolTipTitle();
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase"})
	public void TC_29_validate_node_SwapMemoryWidgetTitle() throws EncryptedDocumentException, IOException {
		nodePage.validateSwapMemorywidgetTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.couchBaseSheet, "Node_SwapMemoryWidgetTitle"));
	}
	
	
	@Test (groups = {"DBM","UI","Regression","Couchbase"})
	public void TC_30_validate_node_SwapMemoryWidget_ZoomInFunctionality() throws EncryptedDocumentException, IOException {
		nodePage.validateSwapMemoryZoomInBtn();
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase"})
	public void TC_31_validate_node_SwapMemoryWidget_ZoomOutFunctionality() throws EncryptedDocumentException, IOException {
		nodePage.validateSwapMemoryZoomOutBtn();
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase"})
	public void TC_32_validate_node_SwapMemoryWidget_ResetBtnFunctionality() throws EncryptedDocumentException, IOException {
		nodePage.validateSwapMemoryResetBtn();
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase"})
	public void TC_33_validate_node_SwapMemoryWidget_XaxisValues() throws EncryptedDocumentException, IOException {
		nodePage.validateSwapMemoryXaxisValues();
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase"})
	public void TC_34_validate_node_SwapMemoryWidget_XaxisTitle() throws EncryptedDocumentException, IOException {
		nodePage.validateSwapMemoryXaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.couchBaseSheet, "Node_SwapMemoryWidgetXaxisTitle"));
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase"})
	public void TC_35_validate_node_SwapMemoryWidget_YaxisTitle() throws EncryptedDocumentException, IOException {
		nodePage.validateSwapMemoryYaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.couchBaseSheet, "Node_SwapMemoryWidgetYaxisTitle"));
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase"})
	public void TC_36_validate_node_SwapMemoryWidget_ToolTipTitle() throws EncryptedDocumentException, IOException {
		nodePage.validateSwapMemoryToolTipTitle();
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase"})
	public void TC_37_validate_node_nodeOperationsWidgetTitle() throws EncryptedDocumentException, IOException {
		nodePage.validatenodeOperationswidgetTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.couchBaseSheet, "Node_nodeOperationsWidgetTitle"));
	}
	
	
	@Test (groups = {"DBM","UI","Regression","Couchbase"})
	public void TC_38_validate_node_nodeOperationsWidget_ZoomInFunctionality() throws EncryptedDocumentException, IOException {
		nodePage.validatenodeOperationsZoomInBtn();
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase"})
	public void TC_39_validate_node_nodeOperationsWidget_ZoomOutFunctionality() throws EncryptedDocumentException, IOException {
		nodePage.validatenodeOperationsZoomOutBtn();
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase"})
	public void TC_40_validate_node_nodeOperationsWidget_ResetBtnFunctionality() throws EncryptedDocumentException, IOException {
		nodePage.validatenodeOperationsResetBtn();
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase"})
	public void TC_41_validate_node_nodeOperationsWidget_XaxisValues() throws EncryptedDocumentException, IOException {
		nodePage.validatenodeOperationsXaxisValues();
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase"})
	public void TC_42_validate_node_nodeOperationsWidget_XaxisTitle() throws EncryptedDocumentException, IOException {
		nodePage.validatenodeOperationsXaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.couchBaseSheet, "Node_nodeOperationsWidgetXaxisTitle"));
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase"})
	public void TC_43_validate_node_nodeOperationsWidget_YaxisTitle() throws EncryptedDocumentException, IOException {
		nodePage.validatenodeOperationsYaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.couchBaseSheet, "Node_nodeOperationsWidgetYaxisTitle"));
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase"})
	public void TC_44_validate_node_nodeOperationsWidget_LegendsText() throws EncryptedDocumentException, IOException {
		nodePage.validateNodeOperationsWidgetLegendsText(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.couchBaseSheet, "Node_NodeOperationsWidget_LegendsText"));
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase"})
	public void TC_45_validate_node_nodeOperations_ToolTipTitle() throws EncryptedDocumentException, IOException {
		nodePage.validatenodeOperationsToolTipTitle();
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase"})
	public void TC_46_validate_node_nodeOperationsWidget_Legends_withRespectiveToolTip() throws EncryptedDocumentException, IOException {
		nodePage.validateNodeOperationsLegendsWithRespectiveToolTips();
	}
	
	
	@Test (groups = {"DBM","UI","Regression","Couchbase"})
	public void TC_47_validate_node_CurrentItemsWidgetTitle() throws EncryptedDocumentException, IOException {
		nodePage.validateCurrentItemswidgetTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.couchBaseSheet, "Node_CurrentItemsWidgetTitle"));
	}
	
	
	@Test (groups = {"DBM","UI","Regression","Couchbase"})
	public void TC_48_validate_node_CurrentItemsWidget_ZoomInFunctionality() throws EncryptedDocumentException, IOException {
		nodePage.validateCurrentItemsZoomInBtn();
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase"})
	public void TC_49_validate_node_CurrentItemsWidget_ZoomOutFunctionality() throws EncryptedDocumentException, IOException {
		nodePage.validateCurrentItemsZoomOutBtn();
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase"})
	public void TC_50_validate_node_CurrentItemsWidget_ResetBtnFunctionality() throws EncryptedDocumentException, IOException {
		nodePage.validateCurrentItemsResetBtn();
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase"})
	public void TC_51_validate_node_CurrentItemsWidget_XaxisValues() throws EncryptedDocumentException, IOException {
		nodePage.validateCurrentItemsXaxisValues();
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase"})
	public void TC_52_validate_node_CurrentItemsWidget_XaxisTitle() throws EncryptedDocumentException, IOException {
		nodePage.validateCurrentItemsXaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.couchBaseSheet, "Node_CurrentItemsWidgetXaxisTitle"));
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase"})
	public void TC_53_validate_node_CurrentItemsWidget_YaxisTitle() throws EncryptedDocumentException, IOException {
		nodePage.validateCurrentItemsYaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.couchBaseSheet, "Node_CurrentItemsWidgetYaxisTitle"));
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase"})
	public void TC_54_validate_node_CurrentItemsWidget_ToolTipTitle() throws EncryptedDocumentException, IOException {
		nodePage.validateCurrentItemsToolTipTitle();
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase"})
	public void TC_55_validate_node_nodeReplicaWidgetTitle() throws EncryptedDocumentException, IOException {
		nodePage.validatenodeReplicawidgetTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.couchBaseSheet, "Node_nodeReplicaWidgetTitle"));
	}
	
	
	@Test (groups = {"DBM","UI","Regression","Couchbase"})
	public void TC_56_validate_node_nodeReplicaWidget_ZoomInFunctionality() throws EncryptedDocumentException, IOException {
		nodePage.validatenodeReplicaZoomInBtn();
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase"})
	public void TC_57_validate_node_nodeReplicaWidget_ZoomOutFunctionality() throws EncryptedDocumentException, IOException {
		nodePage.validatenodeReplicaZoomOutBtn();
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase"})
	public void TC_58_validate_node_nodeReplicaWidget_ResetBtnFunctionality() throws EncryptedDocumentException, IOException {
		nodePage.validatenodeReplicaResetBtn();
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase"})
	public void TC_59_validate_node_nodeReplicaWidget_XaxisValues() throws EncryptedDocumentException, IOException {
		nodePage.validatenodeReplicaXaxisValues();
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase"})
	public void TC_60_validate_node_nodeReplicaWidget_XaxisTitle() throws EncryptedDocumentException, IOException {
		nodePage.validatenodeReplicaXaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.couchBaseSheet, "Node_nodeReplicaWidgetXaxisTitle"));
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase"})
	public void TC_61_validate_node_nodeReplicaWidget_YaxisTitle() throws EncryptedDocumentException, IOException {
		nodePage.validatenodeReplicaYaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.couchBaseSheet, "Node_nodeReplicaWidgetYaxisTitle"));
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase"})
	public void TC_62_validate_node_nodeReplicaWidget_ToolTipTitle() throws EncryptedDocumentException, IOException {
		nodePage.validatenodeReplicaToolTipTitle();
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase"})
	public void TC_63_validate_node_DocsDataSizeWidgetTitle() throws EncryptedDocumentException, IOException {
		nodePage.validateDocsDataSizewidgetTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.couchBaseSheet, "Node_DocsDataSizeWidgetTitle"));
	}
	
	
	@Test (groups = {"DBM","UI","Regression","Couchbase"})
	public void TC_64_validate_node_DocsDataSizeWidget_ZoomInFunctionality() throws EncryptedDocumentException, IOException {
		nodePage.validateDocsDataSizeZoomInBtn();
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase"})
	public void TC_65_validate_node_DocsDataSizeWidget_ZoomOutFunctionality() throws EncryptedDocumentException, IOException {
		nodePage.validateDocsDataSizeZoomOutBtn();
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase"})
	public void TC_66_validate_node_DocsDataSizeWidget_ResetBtnFunctionality() throws EncryptedDocumentException, IOException {
		nodePage.validateDocsDataSizeResetBtn();
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase"})
	public void TC_67_validate_node_DocsDataSizeWidget_XaxisValues() throws EncryptedDocumentException, IOException {
		nodePage.validateDocsDataSizeXaxisValues();
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase"})
	public void TC_68_validate_node_DocsDataSizeWidget_XaxisTitle() throws EncryptedDocumentException, IOException {
		nodePage.validateDocsDataSizeXaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.couchBaseSheet, "Node_DocsDataSizeWidgetXaxisTitle"));
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase"})
	public void TC_69_validate_node_DocsDataSizeWidget_YaxisTitle() throws EncryptedDocumentException, IOException {
		nodePage.validateDocsDataSizeYaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.couchBaseSheet, "Node_DocsDataSizeWidgetYaxisTitle"));
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase"})
	public void TC_70_validate_node_DocsDataSizeWidget_ToolTipTitle() throws EncryptedDocumentException, IOException {
		nodePage.validateDocsDataSizeToolTipTitle();
	}
	
	
	@Test (groups = {"DBM","UI","Regression","Couchbase"})
	public void TC_71_validate_node_McdMemoryWidgetTitle() throws EncryptedDocumentException, IOException {
		nodePage.validateMcdMemorywidgetTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.couchBaseSheet, "Node_McdMemoryWidgetTitle"));
	}
	
	
	@Test (groups = {"DBM","UI","Regression","Couchbase"})
	public void TC_72_validate_node_McdMemoryWidget_ZoomInFunctionality() throws EncryptedDocumentException, IOException {
		nodePage.validateMcdMemoryZoomInBtn();
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase"})
	public void TC_73_validate_node_McdMemoryWidget_ZoomOutFunctionality() throws EncryptedDocumentException, IOException {
		nodePage.validateMcdMemoryZoomOutBtn();
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase"})
	public void TC_74_validate_node_McdMemoryWidget_ResetBtnFunctionality() throws EncryptedDocumentException, IOException {
		nodePage.validateMcdMemoryResetBtn();
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase"})
	public void TC_75_validate_node_McdMemoryWidget_XaxisValues() throws EncryptedDocumentException, IOException {
		nodePage.validateMcdMemoryXaxisValues();
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase"})
	public void TC_76_validate_node_McdMemoryWidget_XaxisTitle() throws EncryptedDocumentException, IOException {
		nodePage.validateMcdMemoryXaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.couchBaseSheet, "Node_McdMemoryWidgetXaxisTitle"));
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase"})
	public void TC_77_validate_node_McdMemoryWidget_YaxisTitle() throws EncryptedDocumentException, IOException {
		nodePage.validateMcdMemoryYaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.couchBaseSheet, "Node_McdMemoryWidgetYaxisTitle"));
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase"})
	public void TC_78_validate_node_McdMemoryWidget_ToolTipTitle() throws EncryptedDocumentException, IOException {
		nodePage.validateMcdMemoryToolTipTitle();
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase"})
	public void TC_79_validate_the_nodePage_when_timeRangeIsChangedTo_15min() throws InterruptedException, EncryptedDocumentException, IOException {
		commonPage.selectTheTimeLineFromCalender(IPathConstant.fifteenMinutesTimeRange);
		nodePage.validateCpuUsageXaxisValues();
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase"})
	public void TC_80_validate_the_nodePage_when_timeRangeIsChangedTo_5min() throws InterruptedException, EncryptedDocumentException, IOException {
		commonPage.selectTheTimeLineFromCalender(IPathConstant.fiveMinutesTimeRange);
		nodePage.validateCpuUsageXaxisValues();
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase"})
	public void TC_81_validate_the_nodePage_when_timeRangeIsChangedTo_1month() throws InterruptedException, EncryptedDocumentException, IOException {
		commonPage.selectTheTimeLineFromCalender(IPathConstant.oneMonthTimeRange);
		nodePage.validateCpuUsageXaxisValues();
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase"})
	public void TC_82_validate_the_nodePage_when_timeRangeIsChangedTo_30min() throws InterruptedException, EncryptedDocumentException, IOException {
		commonPage.selectTheTimeLineFromCalender(IPathConstant.thirtyMinutesTimeRange);
		nodePage.validateCpuUsageXaxisValues();
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase"})
	public void TC_81_validate_the_nodePage_when_timeRangeIsChangedTo_60min() throws InterruptedException, EncryptedDocumentException, IOException {
		commonPage.selectTheTimeLineFromCalender(IPathConstant.sixtyMinutesTimeRange);
		nodePage.validateCpuUsageXaxisValues();
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase"})
	public void TC_83_validate_the_nodePage_when_timeRangeIsChangedTo_3Hours() throws InterruptedException, EncryptedDocumentException, IOException {
		commonPage.selectTheTimeLineFromCalender(IPathConstant.threeHoursTimeRange);
		nodePage.validateCpuUsageXaxisValues();
	}
	
	
	@Test (groups = {"DBM","UI","Regression","Couchbase"})
	public void TC_84_validate_the_nodePage_when_timeRangeIsChangedTo_6Hours() throws InterruptedException, EncryptedDocumentException, IOException {
		commonPage.selectTheTimeLineFromCalender(IPathConstant.sixHoursTimeRange);
		nodePage.validateCpuUsageXaxisValues();
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase"})
	public void TC_85_validate_the_nodePage_when_timeRangeIsChangedTo_12Hours() throws InterruptedException, EncryptedDocumentException, IOException {
		commonPage.selectTheTimeLineFromCalender(IPathConstant.twelveHoursTimeRange);
		nodePage.validateCpuUsageXaxisValues();
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase"})
	public void TC_86_validate_the_nodePage_when_timeRangeIsChangedTo_1Day() throws InterruptedException, EncryptedDocumentException, IOException {
		commonPage.selectTheTimeLineFromCalender(IPathConstant.oneDayTimeRange);
		nodePage.validateCpuUsageXaxisValues();
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase"})
	public void TC_87_validate_the_nodePage_when_timeRangeIsChangedTo_1Week() throws InterruptedException, EncryptedDocumentException, IOException {
		commonPage.selectTheTimeLineFromCalender(IPathConstant.oneWeekTimeRange);
		nodePage.validateCpuUsageXaxisValues();
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase"})
	public void TC_88_validate_the_nodePage_when_timeRangeIsChangedTo_Custom_24mins_Range() throws InterruptedException, EncryptedDocumentException, IOException {
		commonPage.selectTheCustomeTimeLine(IPathConstant.customTimeRange, excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath, IPathConstant.calenderSheet, "customMinutesRange"));
		nodePage.validateTheCustomTimeLine(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath, IPathConstant.calenderSheet, "customMinutesRange"));
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase"})
	public void TC_89_validate_the_nodePage_when_timeRangeIsChangedTo_Custom_4hrs_Range() throws InterruptedException, EncryptedDocumentException, IOException {
		commonPage.selectTheCustomeTimeLine(IPathConstant.customTimeRange, excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath, IPathConstant.calenderSheet, "customHoursRange"));
		nodePage.validateTheCustomTimeLine(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath, IPathConstant.calenderSheet, "customHoursRange"));
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase"})
	public void TC_90_validate_the_nodePage_when_timeRangeIsChangedTo_Custom_10daysRange() throws InterruptedException, EncryptedDocumentException, IOException {
		commonPage.selectTheCustomeTimeLine(IPathConstant.customTimeRange, excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath, IPathConstant.calenderSheet, "customDaysRange"));
		nodePage.validateTheCustomTimeLine(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath, IPathConstant.calenderSheet, "customDaysRange"));
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase"})
	public void TC_91_validate_the_nodePage_when_timeRangeIsChangedTo_Custom_90daysRange() throws InterruptedException, EncryptedDocumentException, IOException {
		commonPage.selectTheCustomeTimeLine(IPathConstant.customTimeRange, excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath, IPathConstant.calenderSheet, "custom3monthsRange"));
		nodePage.validateTheCustomTimeLine(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath, IPathConstant.calenderSheet, "custom3monthsRange"));
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase"})
	public void TC_92_validate_nodeMcdMemoryGraph_DragAndDropFunctionality() throws InterruptedException, EncryptedDocumentException, IOException {
		nodePage.validateMcdMemoryGraphDragDrop();
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase"})
	public void TC_93_validate_nodeCpuUsageGraph_DragAndDropFunctionality() throws InterruptedException, EncryptedDocumentException, IOException {
		nodePage.validateCpuUsageGraphDragDrop();
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase"})
	public void TC_94_validate_nodeRamUsageGraphDragAndDropFunctionality() throws InterruptedException, EncryptedDocumentException, IOException {
		nodePage.validateRAMUsageGraphDragDrop();
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase"})
	public void TC_95_validate_nodeSwapMemoryGraph_DragAndDropFunctionality() throws InterruptedException, EncryptedDocumentException, IOException {
		nodePage.validateSwapMemoryGraphDragDrop();
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase"})
	public void TC_96_validate_nodeOperationsGraph_DragAndDropFunctionality() throws InterruptedException, EncryptedDocumentException, IOException {
		nodePage.validateNodeOperationsGraphDragDrop();
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase"})
	public void TC_97_validate_nodeCurrentItemsGraph_DragAndDropFunctionality() throws InterruptedException, EncryptedDocumentException, IOException {
		nodePage.validateCurrentItemsGraphDragDrop();
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase"})
	public void TC_98_validate_nodeReplicaGraph_DragAndDropFunctionality() throws InterruptedException, EncryptedDocumentException, IOException {
		nodePage.validateNodeReplicaGraphDragDrop();
	}
	
	@Test (groups = {"DBM","UI","Regression","Couchbase"})
	public void TC_99_validate_nodeDocsDataSizeGraph_DragAndDropFunctionality() throws InterruptedException, EncryptedDocumentException, IOException {
		nodePage.validateDocsDataSizeGraphDragDrop();
	}
	
	
	@Test (groups = {"DBM","UI","Regression","Couchbase"})
	public void TC_100_validate_the_nodePage_futureTimeLine_fromCustom() throws InterruptedException, EncryptedDocumentException, IOException {
		commonPage.validateTheFutureTimeLine();
	}
	
	
}