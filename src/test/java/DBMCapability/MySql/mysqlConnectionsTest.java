package DBMCapability.MySql;

import com.microsoft.playwright.Page;
import genericUtilities.ExcelUtility;
import genericUtilities.IPathConstant;
import objectRepository.CommonPage;
import objectRepository.DBM.MysqlConnectionsPage;
import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import playWrightFactory.BaseClass;

import java.io.IOException;

public class mysqlConnectionsTest extends BaseClass {
    CommonPage commonPage;
    MysqlConnectionsPage connectionsPage;
    ExcelUtility excel = new ExcelUtility();

    @BeforeMethod
    public void connectionsPreRequest() throws EncryptedDocumentException, IOException {
        commonPage = new CommonPage(page);
        connectionsPage = new MysqlConnectionsPage(page);
        excel = new ExcelUtility();

        commonPage.navigateToDBM();
        connectionsPage.navigateToMysqlDatabase();
        commonPage.selectTheTimeLineFromCalender(IPathConstant.oneMonthTimeRange);
        connectionsPage.navigateToConnectionsTab();
        connectionsPage.selectServiceFromDropDown();
        connectionsPage.selectNodeFromDropDown();
        
    }

    @Test(groups = {"DBM", "UI", "Regression", "MySQL", "Sanity"})
    public void TC_01_validate_ConnectionsPageTitle() throws EncryptedDocumentException, IOException {
        connectionsPage.validateConnectionsTabTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.mySqlSheet, "Connections_ConnectionTabTitle"));
    }

    @Test(groups = {"DBM", "UI", "Regression", "MySQL", "Sanity"})
    public void TC_02_validate_Connections_TotalThreadsConnectedWidgetTitle() throws EncryptedDocumentException, IOException {
        connectionsPage.validateTotalThreadsConnectedWidvalidateTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.mySqlSheet, "Connections_TotalThreadsConnectedWidTitle"));
    }

    @Test(groups = {"DBM", "UI", "Regression", "MySQL", "Sanity"})
    public void TC_03_validate_Connections_TotalThreadsConnectedWidget_XaxisTitle() throws EncryptedDocumentException, IOException {
        connectionsPage.validateTotalThreadsConnectedXaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.mySqlSheet, "Connections_TotalThreadsConnectedXaxisTitle"));
    }

    @Test(groups = {"DBM", "UI", "Regression", "MySQL", "Sanity"})
    public void TC_04_validate_Connections_TotalThreadsConnectedWidget_YaxisTitle() throws EncryptedDocumentException, IOException {
        connectionsPage.validateTotalThreadsConnectedYaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.mySqlSheet, "Connections_TotalThreadsConnectedYaxisTitle"));
    }

    @Test(groups = {"DBM", "UI", "Regression", "MySQL", "Sanity"})
    public void TC_05_validate_Connections_TotalThreadsConnected_ZoomInButton() {
        connectionsPage.validateTotalThreadsConnectedZoomInBtn();
    }

    @Test(groups = {"DBM", "UI", "Regression", "MySQL", "Sanity"})
    public void TC_06_validate_Connections_TotalThreadsConnected_ZoomOutButton() {
        connectionsPage.validateTotalThreadsConnectedZoomOutBtn();
    }

    @Test(groups = {"DBM", "UI", "Regression", "MySQL", "Sanity"})
    public void TC_07_validate_Connections_TotalThreadsConnected_ResetButton() {
        connectionsPage.validateTotalThreadsConnectedResetBtn();
    }

    @Test(groups = {"DBM", "UI", "Regression", "MySQL"})
    public void TC_08_validate_Connections_TotalThreadsConnected_DragDrop() {
        connectionsPage.validateTotalThreadsConnectedDragDrop();
    }

    @Test(groups = {"DBM", "UI", "Regression", "MySQL"})
    public void TC_09_validate_Connections_TotalThreadsConnectedWidget_ToolTipTitle() throws InterruptedException {
        connectionsPage.validateTotalThreadsConnectedtoolTipTitle();
    }

    @Test(groups = {"DBM", "UI", "Regression", "MySQL"})
    public void TC_10_validate_Connections_TotalThreadsConnectedXaxisValues_asPer_SelectedTimeline() throws InterruptedException, EncryptedDocumentException, IOException {
        connectionsPage.validateTotalThreadsConnectedXaxisValues();
    }

    @Test(groups = {"DBM", "UI", "Regression", "MySQL", "Sanity"})
    public void TC_11_validate_Connections_TotalThreadsRunningWidgetTitle() throws EncryptedDocumentException, IOException {
        connectionsPage.validateTotalThreadsRunningWidvalidateTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.mySqlSheet, "Connections_TotalThreadsRunningWidTitle"));
    }

    @Test(groups = {"DBM", "UI", "Regression", "MySQL"})
    public void TC_12_validate_Connections_TotalThreadsRunningWidget_XaxisTitle() throws EncryptedDocumentException, IOException {
        connectionsPage.validateTotalThreadsRunningXaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.mySqlSheet, "Connections_TotalThreadsRunningXaxisTitle"));
    }

    @Test(groups = {"DBM", "UI", "Regression", "MySQL", "Sanity"})
    public void TC_13_validate_Connections_TotalThreadsRunningWidget_YaxisTitle() throws EncryptedDocumentException, IOException {
        connectionsPage.validateTotalThreadsRunningYaxisTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.mySqlSheet, "Connections_TotalThreadsRunningYaxisTitle"));
    }

    @Test(groups = {"DBM", "UI", "Regression", "MySQL"})
    public void TC_14_validate_Connections_TotalThreadsRunning_ZoomInButton() {
        connectionsPage.validateTotalThreadsRunningZoomInBtn();
    }

    @Test(groups = {"DBM", "UI", "Regression", "MySQL", "Sanity"})
    public void TC_15_validate_Connections_TotalThreadsRunning_ZoomOutButton() {
        connectionsPage.validateTotalThreadsRunningZoomOutBtn();
    }

    @Test(groups = {"DBM", "UI", "Regression", "MySQL"})
    public void TC_16_validate_Connections_TotalThreadsRunning_ResetButton() {
        connectionsPage.validateTotalThreadsRunningResetBtn();
    }

    @Test(groups = {"DBM", "UI", "Regression", "MySQL"})
    public void TC_17_validate_Connections_TotalThreadsRunning_DragDrop() {
        connectionsPage.validateTotalThreadsRunningDragDrop();
    }

    @Test(groups = {"DBM", "UI", "Regression", "MySQL"})
    public void TC_18_validate_Connections_TotalThreadsRunningWidget_ToolTipTitle() throws InterruptedException {
        connectionsPage.validateTotalThreadsRunningtoolTipTitle();
    }

    @Test(groups = {"DBM", "UI", "Regression", "MySQL", "Sanity"})
    public void TC_19_validate_Connections_TotalThreadsRunningXaxisValues_asPer_SelectedTimeline() throws InterruptedException, EncryptedDocumentException, IOException {
    	connectionsPage.validateTotalThreadsRunningXaxisValues();
    }

    @Test(groups = {"DBM", "UI", "Regression", "MySQL", "Sanity"})
    public void TC_20_validate_SessionDetailsTable_Title() throws EncryptedDocumentException, IOException {
        connectionsPage.validateSessionDetailsTableTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.mySqlSheet, "Connections_SessionDetailsTableTitle"));
    }

    @Test(groups = {"DBM", "UI", "Regression", "MySQL", "Sanity"})
    public void TC_21_validate_SessionDetailsTable_UserNameHeaderTitle() throws EncryptedDocumentException, IOException {
        connectionsPage.validateSessionDetailsTableUserNameTitleHeaderTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.mySqlSheet, "Connections_UserNameHeaderTitle"));
    }

    @Test(groups = {"DBM", "UI", "Regression", "MySQL", "Sanity"})
    public void TC_22_validate_SessionDetailsTable_QueriesExecutedHeaderTitle() throws EncryptedDocumentException, IOException {
        connectionsPage.valiatetSessionDetailsTableQueryExecutedHeaderTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.mySqlSheet, "Connections_QueriesExecutedHeaderTitle"));
    }

    @Test(groups = {"DBM", "UI", "Regression", "MySQL", "Sanity"})
    public void TC_23_validate_SessionDetailsTable_TimeStampHeaderTitle() throws EncryptedDocumentException, IOException {
        connectionsPage.validateSessiondetailsTableTimeStampHeaderTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.mySqlSheet, "Connections_TimeStampHeaderTitle"));
    }

    @Test(groups = {"DBM", "UI", "Regression", "MySQL", "Sanity"})
    public void TC_24_validate_SessionDetailsTable_DeadlockHeaderTitle() throws EncryptedDocumentException, IOException {
        connectionsPage.validateSessiondetailsTableDeadLockHeaderTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.mySqlSheet, "Connections_DeadlockHeaderTitle"));
    }

    @Test(groups = {"DBM", "UI", "Regression", "MySQL"})
    public void TC_25_validate_the_ConnectionsPage_when_timeRangeIsChangedTo_12Hours() throws InterruptedException, EncryptedDocumentException, IOException {
        commonPage.selectTheTimeLineFromCalender(IPathConstant.twelveHoursTimeRange);
        connectionsPage.validateTotalThreadsRunningXaxisValues();
    }

    @Test(groups = {"DBM", "UI", "Regression", "MySQL"})
    public void TC_26_validate_the_ConnectionsPage_when_timeRangeIsChangedTo_5min() throws InterruptedException, EncryptedDocumentException, IOException {
        commonPage.selectTheTimeLineFromCalender(IPathConstant.fiveMinutesTimeRange);
        connectionsPage.validateTotalThreadsRunningXaxisValues();
    }

    @Test(groups = {"DBM", "UI", "Regression", "MySQL"})
    public void TC_27_validate_the_ConnectionsPage_when_timeRangeIsChangedTo_15min() throws InterruptedException, EncryptedDocumentException, IOException {
        commonPage.selectTheTimeLineFromCalender(IPathConstant.fifteenMinutesTimeRange);
        connectionsPage.validateTotalThreadsRunningXaxisValues();
    }

    @Test(groups = {"DBM", "UI", "Regression", "MySQL"})
    public void TC_28_validate_the_ConnectionsPage_when_timeRangeIsChangedTo_1month() throws InterruptedException, EncryptedDocumentException, IOException {
        commonPage.selectTheTimeLineFromCalender(IPathConstant.oneMonthTimeRange);
        connectionsPage.validateTotalThreadsRunningXaxisValues();
    }

    @Test(groups = {"DBM", "UI", "Regression", "MySQL"})
    public void TC_29_validate_the_ConnectionsPage_when_timeRangeIsChangedTo_30min() throws InterruptedException, EncryptedDocumentException, IOException {
        commonPage.selectTheTimeLineFromCalender(IPathConstant.thirtyMinutesTimeRange);
        connectionsPage.validateTotalThreadsRunningXaxisValues();
    }

    @Test(groups = {"DBM", "UI", "Regression", "MySQL"})
    public void TC_30_validate_the_ConnectionsPage_when_timeRangeIsChangedTo_60min() throws InterruptedException, EncryptedDocumentException, IOException {
        commonPage.selectTheTimeLineFromCalender(IPathConstant.sixtyMinutesTimeRange);
        connectionsPage.validateTotalThreadsRunningXaxisValues();
    }

    @Test(groups = {"DBM", "UI", "Regression", "MySQL"})
    public void TC_31_validate_the_ConnectionsPage_when_timeRangeIsChangedTo_3Hours() throws InterruptedException, EncryptedDocumentException, IOException {
        commonPage.selectTheTimeLineFromCalender(IPathConstant.threeHoursTimeRange);
        connectionsPage.validateTotalThreadsRunningXaxisValues();
    }


    @Test(groups = {"DBM", "UI", "Regression", "MySQL"})
    public void TC_32_validate_the_ConnectionsPage_when_timeRangeIsChangedTo_6Hours() throws InterruptedException, EncryptedDocumentException, IOException {
        commonPage.selectTheTimeLineFromCalender(IPathConstant.sixHoursTimeRange);
        connectionsPage.validateTotalThreadsRunningXaxisValues();
    }

    @Test(groups = {"DBM", "UI", "Regression", "MySQL"})
    public void TC_33_validate_the_ConnectionsPage_when_timeRangeIsChangedTo_1Day() throws InterruptedException, EncryptedDocumentException, IOException {
        commonPage.selectTheTimeLineFromCalender(IPathConstant.oneDayTimeRange);
        connectionsPage.validateTotalThreadsRunningXaxisValues();
    }

    @Test(groups = {"DBM", "UI", "Regression", "MySQL"})
    public void TC_34_validate_the_ConnectionsPage_when_timeRangeIsChangedTo_1Week() throws InterruptedException, EncryptedDocumentException, IOException {
        commonPage.selectTheTimeLineFromCalender(IPathConstant.oneWeekTimeRange);
        connectionsPage.validateTotalThreadsRunningXaxisValues();
    }

    @Test(groups = {"DBM", "UI", "Regression", "MySQL"})
    public void TC_35_validate_the_ConnectionsPage_when_timeRangeIsChangedTo_Custom_24mins_Range() throws InterruptedException, EncryptedDocumentException, IOException {
        commonPage.selectTheCustomeTimeLine(IPathConstant.customTimeRange, excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath, IPathConstant.calenderSheet, "customMinutesRange"));
        connectionsPage.validateTheCustomTimeLine(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath, IPathConstant.calenderSheet, "customMinutesRange"));
    }

    @Test(groups = {"DBM", "UI", "Regression", "MySQL"})
    public void TC_36_validate_the_ConnectionsPage_when_timeRangeIsChangedTo_Custom_4hrs_Range() throws InterruptedException, EncryptedDocumentException, IOException {
        commonPage.selectTheCustomeTimeLine(IPathConstant.customTimeRange, excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath, IPathConstant.calenderSheet, "customHoursRange"));
        connectionsPage.validateTheCustomTimeLine(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath, IPathConstant.calenderSheet, "customHoursRange"));
    }

    @Test(groups = {"DBM", "UI", "Regression", "MySQL"})
    public void TC_37_validate_the_ConnectionsPage_when_timeRangeIsChangedTo_Custom_10daysRange() throws InterruptedException, EncryptedDocumentException, IOException {
        commonPage.selectTheCustomeTimeLine(IPathConstant.customTimeRange, excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath, IPathConstant.calenderSheet, "customDaysRange"));
        connectionsPage.validateTheCustomTimeLine(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath, IPathConstant.calenderSheet, "customDaysRange"));
    }

    @Test(groups = {"DBM", "UI", "Regression", "MySQL"})
    public void TC_38_validate_the_ConnectionsPage_when_timeRangeIsChangedTo_Custom_90daysRange() throws InterruptedException, EncryptedDocumentException, IOException {
        commonPage.selectTheCustomeTimeLine(IPathConstant.customTimeRange, excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath, IPathConstant.calenderSheet, "custom3monthsRange"));
        connectionsPage.validateTheCustomTimeLine(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath, IPathConstant.calenderSheet, "custom3monthsRange"));
    }

    @Test(groups = {"DBM", "UI", "Regression", "MySQL"})
    public void TC_39_validate_the_ConnectionsPage_futureTimeLine_fromCustom() throws InterruptedException, EncryptedDocumentException, IOException {
        commonPage.validateTheFutureTimeLine();
    }
}