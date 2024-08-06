package DBMCapability.Cassandra;

import com.microsoft.playwright.Page;
import genericUtilities.ExcelUtility;
import genericUtilities.IPathConstant;
import objectRepository.APM.ApmApplicationPage;
import objectRepository.CommonPage;
import objectRepository.DBM.CassandraHardwarePage;
import objectRepository.HomePage;
import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import playWrightFactory.BaseClass;

import java.io.IOException;

public class CassandraHardwareTest extends BaseClass {


    HomePage homePage;
    ExcelUtility eutil;
    ApmApplicationPage appPage;
    CassandraHardwarePage hardwarePage;



    @BeforeMethod
    public void preRequest() throws EncryptedDocumentException, IOException
    {
        eutil=new ExcelUtility();
        homePage=new HomePage(page);
        hardwarePage=new CassandraHardwarePage(page);

        //Navigate to APM capability
        commPage.navigateToDBM();

        hardwarePage.selectDataBaseType("Cassandra");
      //  hardwarePage.selectServiceType();
       // hardwarePage.selectDataInstanceTypeDropdown();

        //navigate to dashboard page//select the Time line
        commPage.selectTheTimeLineFromCalender("1 month");
    }

    @Test(groups={"DBM","Cassandra","UI","Regression"})

    public void TC_01_validateTheBorderHeadingOfHardwareInfoWrapperCard() throws IOException {
        hardwarePage.validateBorderHeadingHardwareInfoWrapperCard(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "Hardware_HardwareInfo_wrapper card").trim());
    }
    @Test(groups={"DBM","Cassandra","UI","Regression"})

    public void TC_02_validateTheTitleTypeOfOsElementOfHardwareInfoWrapperCard() throws IOException {
        hardwarePage.validateTheTitleTypeOfOsElementOfHardwareInfoWrapperCard(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "Hardware_HardwareInfo_Type of OS label").trim());
    }

    @Test(groups={"DBM","Cassandra","UI","Regression"})

    public void TC_03_validateTheTitleArchitectureElementOfHardwareInfoWrapperCard() throws IOException {
        hardwarePage.validateTheTitleArchitectureElementOfHardwareInfoWrapperCard(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "Hardware_HardwareInfo_Architecture label").trim());
    }

    @Test(groups={"DBM","Cassandra","UI","Regression"})

    public void TC_04_validateTheTitleHostNameElementOfHardwareInfoWrapperCard() throws IOException {
        hardwarePage.validateTheTitleHostNameElementOfHardwareInfoWrapperCard(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "Hardware_HardwareInfo_Host name label").trim());
    }

    @Test(groups={"DBM","Cassandra","UI","Regression"})

    public void TC_05_validateTheTitleavailabilityElementOfHardwareInfoWrapperCard() throws IOException {
        hardwarePage.validateTheTitleAvailabilityElementOfHardwareInfoWrapperCard(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "Hardware_HardwareInfo_Availability label").trim());
    }

    @Test(groups={"DBM","Cassandra","UI","Regression"})

    public void TC_06_validateTheTitleaverageCpuUsageElementOfHardwareInfoWrapperCard() throws IOException {
        hardwarePage.validateTheTitleAverageCpuUsageElementOfHardwareInfoWrapperCard(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "Hardware_HardwareInfo_Average CPU usage(%) label").trim());
    }

    @Test(groups={"DBM","Cassandra","UI","Regression"})

    public void TC_07_validateTheTitleaverageMemoryUsageElementOfHardwareInfoWrapperCard() throws IOException {
        hardwarePage.validateTheTitleAverageMemoryUsageElementOfHardwareInfoWrapperCard(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "Hardware_HardwareInfo_Average memory usage(MB) label").trim());
    }

    @Test(groups={"DBM","Cassandra","UI","Regression"})

    public void TC_08_validateTheTitleClusterInfoBorderElementOfClusterInfoWrapperCard() throws IOException {
        System.out.println(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "Hardware_ClusterInfo_Cluster Info label"));
        hardwarePage.validateTheTitleClusterInfoBorderElementOfClusterInfoWrapperCard(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "Hardware_ClusterInfo_Cluster Info label").trim());
    }

    @Test(groups={"DBM","Cassandra","UI","Regression"})

    public void TC_09_validateTheTitleClusterNameElementOfClusterInfoWrapperCard() throws IOException {
        hardwarePage.validateTheTitleClusterNameElementOfClusterInfoWrapperCard(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "Hardware_ClusterInfo_Cluster name label").trim());
    }

    @Test(groups={"DBM","Cassandra","UI","Regression"})

    public void TC_10_validateTheTitlekeyspaceNameElementOfClusterInfoWrapperCard() throws IOException {
        hardwarePage.validateTheTitlekeyspaceNameElementOfClusterInfoWrapperCard(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "Hardware_ClusterInfo_Keyspace name label").trim());
    }

    @Test(groups={"DBM","Cassandra","UI","Regression"})

    public void TC_11_validateTheTitleDataCenterElementOfClusterInfoWrapperCard() throws IOException {
        hardwarePage.validateTheTitleDataCenterElementOfClusterInfoWrapperCard(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "Hardware_ClusterInfo_Data center label").trim());
    }

    @Test(groups={"DBM","Cassandra","UI","Regression"})

    public void TC_12_validateTheTitleCqlVersionElementOfClusterInfoWrapperCard() throws IOException {
        hardwarePage.validateTheTitleCqlVersionElementOfClusterInfoWrapperCard(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "Hardware_ClusterInfo_Cql version label").trim());
    }

    @Test(groups={"DBM","Cassandra","UI","Regression"})

    public void TC_13_validateTheTitleRackElementOfClusterInfoWrapperCard() throws IOException {
        hardwarePage.validateTheTitleRackElementOfClusterInfoWrapperCard(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "Hardware_ClusterInfo_Rack label").trim());
    }

    @Test(groups={"DBM","Cassandra","UI","Regression"})

    public void TC_14_validateTheDiscUsageCardTitleUnderHardwareTab() throws IOException {
        hardwarePage.validateTheDiscUsageCardTitleUnderHardwareTab(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "Hardware_Disk usage label").trim());
    }

    @Test(groups={"DBM","Cassandra","UI","Regression"})

    public void TC_15_validateTheDiscUsageCardNoTextUnderHardwareTab() throws IOException {
        System.out.print(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "Hardware_Disk Usage Card No dataText label").trim());
        hardwarePage.validateTheDiscUsageCardNoTextUnderHardwareTab(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "Hardware_Disk Usage Card No dataText label").trim());
    }

    /*@Test(groups={"DBM","Cassandra","UI","Regression"})

    public void TC_16_validateTheCpuUsageGraphTitleTextUnderHardwareTab() throws IOException {
       // System.out.print(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "Hardware_Disk Usage Card No dataText label").trim());
        hardwarePage.validateTheCpuUsageGraphTitleTextUnderHardwareTab(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "Hardware_CPU usage label").trim());
    }
*/
    @Test(groups={"DBM","Cassandra","UI","Regression"})

    public void TC_17_validateTheCpuUsageGraphTitleTextUnderHardwareTab() throws IOException {
        // System.out.print(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "Hardware_Disk Usage Card No dataText label").trim());
        hardwarePage.validateTheCpuUsageGraphTitleTextUnderHardwareTab(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "Hardware_CPU usage Widget title").trim());
    }

    @Test(groups={"DBM","Cassandra","UI","Regression"})

    public void TC_18_validateTheCpuUsageGraphXaxisTitleTextUnderHardwareTab() throws IOException {
        // System.out.print(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "Hardware_Disk Usage Card No dataText label").trim());
        hardwarePage.validateTheCpuUsageGraphXaxisTitleTextUnderHardwareTab(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "Hardware_CPU usage_x-axis title").trim());
    }

    @Test(groups={"DBM","Cassandra","UI","Regression"})

    public void TC_19_validateTheCpuUsageGraphYaxisTitleTextUnderHardwareTab() throws IOException {
        // System.out.print(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "Hardware_Disk Usage Card No dataText label").trim());
        hardwarePage.validateTheCpuUsageGraphYaxisTitleTextUnderHardwareTab(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "Hardware_CPU usage_y-axis title").trim());
    }

    @Test(groups={"DBM","Cassandra","UI","Regression"})

    public void TC_20_validateCpuUsageZoomIn() throws IOException {
        // System.out.print(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "Hardware_Disk Usage Card No dataText label").trim());
        hardwarePage.validateCpuUsageZoomIn();
    }

    @Test(groups={"DBM","Cassandra","UI","Regression"})

    public void TC_21_validateCpuUsageZoomOut() throws IOException {
        // System.out.print(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "Hardware_Disk Usage Card No dataText label").trim());
        hardwarePage.validateCpuUsageZoomOut();
    }

    @Test(groups={"DBM","Cassandra","UI","Regression"})

    public void TC_22_validateCpuUsageZoomReset() throws IOException {
        // System.out.print(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "Hardware_Disk Usage Card No dataText label").trim());
        hardwarePage.validateCpuUsageZoomReset();
    }

    @Test(groups={"DBM","Cassandra","UI","Regression"})

    public void TC_23_validateCpuUsageDragDrop() throws IOException {
        // System.out.print(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "Hardware_Disk Usage Card No dataText label").trim());
        page.waitForTimeout(1000);
        hardwarePage.validateCpuUsageDragDrop();
    }


    @Test(groups={"DBM","Cassandra","UI","Regression"})

    public void TC_24_validateTheMemoryUsageGraphTitleTextUnderHardwareTab() throws IOException {
        // System.out.print(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "Hardware_Disk Usage Card No dataText label").trim());
        hardwarePage.validateTheMemoryUsageGraphTitleTextUnderHardwareTab(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "Hardware_Memory usage Widget title").trim());
    }

    @Test(groups={"DBM","Cassandra","UI","Regression"})

    public void TC_25_validateTheMemoryUsageGraphXaxisTitleTextUnderHardwareTab() throws IOException {
        // System.out.print(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "Hardware_Disk Usage Card No dataText label").trim());
        hardwarePage.validateTheMemoryUsageGraphXaxisTitleTextUnderHardwareTab(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "Hardware_Memory usage_x-axis title").trim());
    }

    @Test(groups={"DBM","Cassandra","UI","Regression"})

    public void TC_26_validateTheMemoryUsageGraphYaxisTitleTextUnderHardwareTab() throws IOException {
        // System.out.print(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "Hardware_Disk Usage Card No dataText label").trim());
        hardwarePage.validateTheMemoryUsageGraphYaxisTitleTextUnderHardwareTab(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "Hardware_Memory usage_y-axis title").trim());
    }

    @Test(groups={"DBM","Cassandra","UI","Regression"})

    public void TC_27_validateMemoryUsageZoomIn() throws IOException {
        // System.out.print(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "Hardware_Disk Usage Card No dataText label").trim());
        hardwarePage.validateMemoryUsageZoomIn();
    }

    @Test(groups={"DBM","Cassandra","UI","Regression"})

    public void TC_28_validateMemoryUsageZoomOut() throws IOException {
        // System.out.print(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "Hardware_Disk Usage Card No dataText label").trim());
        hardwarePage.validateMemoryUsageZoomOut();
    }

    @Test(groups={"DBM","Cassandra","UI","Regression"})

    public void TC_29_validateMemoryCpuUsageZoomReset() throws IOException {
        // System.out.print(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "Hardware_Disk Usage Card No dataText label").trim());
        hardwarePage.validateMemoryCpuUsageZoomReset();
    }

    @Test(groups={"DBM","Cassandra","UI","Regression"})

    public void TC_30_validateMemoryUsageDragDrop() throws IOException {
        // System.out.print(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "Hardware_Disk Usage Card No dataText label").trim());
        page.waitForTimeout(1000);
        hardwarePage.validateMemoryUsageDragDrop();
    }


    @Test(groups={"DBM","Cassandra","UI","Regression"})

    public void TC_31_validateTheNetworkIOGraphTitleTextUnderHardwareTab() throws IOException {
        // System.out.print(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "Hardware_Disk Usage Card No dataText label").trim());
        hardwarePage.validateTheNetworkIOGraphTitleTextUnderHardwareTab(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "Hardware_ Network I/O Widget title").trim());
    }

    @Test(groups={"DBM","Cassandra","UI","Regression"})

    public void TC_32_validateTheNetworkIOGraphXaxisTitleTextUnderHardwareTab() throws IOException {
        // System.out.print(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "Hardware_Disk Usage Card No dataText label").trim());
        hardwarePage.validateTheNetworkIOGraphXaxisTitleTextUnderHardwareTab(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "Hardware_ Network I/O_x-axis title").trim());
    }

    @Test(groups={"DBM","Cassandra","UI","Regression"})

    public void TC_33_validateTheNetworkIOGraphYaxisTitleTextUnderHardwareTab() throws IOException {
        // System.out.print(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "Hardware_Disk Usage Card No dataText label").trim());
        hardwarePage.validateTheNetworkIOGraphYaxisTitleTextUnderHardwareTab(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "Hardware_ Network I/O_y-axis title").trim());
    }

    @Test(groups={"DBM","Cassandra","UI","Regression"})

    public void TC_34_validateNetworkIOZoomIn() throws IOException {
        // System.out.print(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "Hardware_Disk Usage Card No dataText label").trim());
        hardwarePage.validateNetworkIOZoomIn();
    }

    @Test(groups={"DBM","Cassandra","UI","Regression"})

    public void TC_35_validateNetworkIOZoomOut() throws IOException {
        // System.out.print(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "Hardware_Disk Usage Card No dataText label").trim());
        hardwarePage.validateNetworkIOZoomOut();
    }

    @Test(groups={"DBM","Cassandra","UI","Regression"})

    public void TC_36_validateNetworkIOZoomReset() throws IOException {
        // System.out.print(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "Hardware_Disk Usage Card No dataText label").trim());
        hardwarePage.validateNetworkIOZoomReset();
    }

    @Test(groups={"DBM","Cassandra","UI","Regression"})

    public void TC_37_validateNetworkIOUsageDragDrop() throws IOException {
        // System.out.print(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "Hardware_Disk Usage Card No dataText label").trim());
        page.waitForTimeout(1000);
        hardwarePage.validateNetworkIOUsageDragDrop();
    }

    @Test(groups={"DBM","Cassandra","UI","Regression"})

    public void TC_38_validateNetworkIOLegendsText() throws IOException {
        // System.out.print(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "Hardware_Disk Usage Card No dataText label").trim());
        hardwarePage.validateNetworkIOLegendsText(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "Hardware_Network IO Legend Names").trim());
    }

    @Test(groups={"DBM","Cassandra","UI","Regression"})

    public void TC_39_validateTheEventDetailsTitleTextUnderHardwareTab() throws IOException {
        // System.out.print(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "Hardware_Disk Usage Card No dataText label").trim());
        hardwarePage.validateTheEventDetailsTitleTextUnderHardwareTab(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "Hardware_Event details Table title").trim());
    }

    @Test(groups={"DBM","Cassandra","UI","Regression"})

    public void TC_40_validateTheEventDetailsFirstColumnTitleTextUnderHardwareTab() throws IOException {
        // System.out.print(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "Hardware_Disk Usage Card No dataText label").trim());
        hardwarePage.validateTheEventDetailsFirstColumnTitleTextUnderHardwareTab(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "Hardware_Event details Table First Column").trim());
    }

    @Test(groups={"DBM","Cassandra","UI","Regression"})

    public void TC_41_validateTheEventDetailsSecondColumnTitleTextUnderHardwareTab() throws IOException {
        // System.out.print(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "Hardware_Disk Usage Card No dataText label").trim());
        hardwarePage.validateTheEventDetailsSecondColumnTitleTextUnderHardwareTab(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "Hardware_Event details Table Second Column").trim());
    }

    @Test(groups={"DBM","Cassandra","UI","Regression"})

    public void TC_42_validateTheEventDetailsThirdColumnTitleTextUnderHardwareTab() throws IOException {
        // System.out.print(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "Hardware_Disk Usage Card No dataText label").trim());
        hardwarePage.validateTheEventDetailsThirdColumnTitleTextUnderHardwareTab(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "Hardware_Event details Table Third Column").trim());
    }

    @Test(groups={"DBM","Cassandra","UI","Regression"})

    public void TC_43_validateTheEventDetailsNoDataTextUnderHardwareTab() throws IOException {
        // System.out.print(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "Hardware_Disk Usage Card No dataText label").trim());
        hardwarePage.validateTheEventDetailsNoDataTextUnderHardwareTab(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.cassandraSheet, "Hardware_Event details Table No Data Text Label").trim());
    }

    @Test(groups={"DBM","Cassandra","UI","Regression"})

    public void TC_44_validate_The_All_Widget_Data_By_Selecting_5Mins_TimeLine()
    {
        //select the time line from calendar
        commPage.selectTheTimeLineFromCalender(IPathConstant.fiveMinutesTimeRange);

        //Validate whether the widgets are displaying the proper time line or not
        hardwarePage.validateTheGivenTimeLine();
    }
    @Test(groups={"DBM","Cassandra","UI","Regression"})

    public void TC_45_validate_The_All_Widgets_Data_By_Selecting_15Mins_TimeLine()
    {
        //select the time line from calendar
        commPage.selectTheTimeLineFromCalender(IPathConstant.fifteenMinutesTimeRange);

        //Validate whether the widgets are displaying the proper time line or not
        hardwarePage.validateTheGivenTimeLine();
    }

    @Test(groups={"DBM","Cassandra","UI","Regression"})

    public void TC_46_validate_The_All_Widgets_Data_By_Selecting_30Mins_TimeLine()
    {
        //select the time line from calendar
        commPage.selectTheTimeLineFromCalender(IPathConstant.thirtyMinutesTimeRange);

        //Validate whether the widgets are displaying the proper time line or not
        hardwarePage.validateTheGivenTimeLine();
    }

    @Test(groups={"DBM","Cassandra","UI","Regression"})

    public void TC_47_validate_The_All_Widgets_Data_By_Selecting_60Mins_TimeLine()
    {
        //select the time line from calendar
        commPage.selectTheTimeLineFromCalender(IPathConstant.sixtyMinutesTimeRange);

        //Validate whether the widgets are displaying the proper time line or not
        hardwarePage.validateTheGivenTimeLine();
    }

    @Test(groups={"DBM","Cassandra","UI","Regression"})

    public void TC_48_validate_The_All_Widgets_Data_By_Selecting_3hours_TimeLine()
    {
        //select the time line from calendar
        commPage.selectTheTimeLineFromCalender(IPathConstant.threeHoursTimeRange);

        //Validate whether the widgets are displaying the proper time line or not
        hardwarePage.validateTheGivenTimeLine();
    }

    @Test(groups={"DBM","Cassandra","UI","Regression"})

    public void TC_49_validate_The_All_Widgets_Data_By_Selecting_6hours_TimeLine()
    {
        //select the time line from calendar
        commPage.selectTheTimeLineFromCalender(IPathConstant.sixHoursTimeRange);

        //Validate whether the widgets are displaying the proper time line or not
        hardwarePage.validateTheGivenTimeLine();
    }

    @Test(groups={"DBM","Cassandra","UI","Regression"})

    public void TC_50_validate_The_All_Widgets_Data_By_Selecting_12hours_TimeLine()
    {
        //select the time line from calendar
        commPage.selectTheTimeLineFromCalender(IPathConstant.twelveHoursTimeRange);
        //Validate whether the widgets are displaying the proper time line or not
        hardwarePage.validateTheGivenTimeLine();
    }

    @Test(groups={"DBM","Cassandra","UI","Regression"})

    public void TC_51_validate_The_All_Widgets_Data_By_Selecting_1day_TimeLine()
    {
        //select the time line from calendar
        commPage.selectTheTimeLineFromCalender(IPathConstant.oneDayTimeRange);

        //Validate whether the widgets are displaying the proper time line or not
        hardwarePage.validateTheGivenTimeLine();
    }

    @Test(groups={"DBM","Cassandra","UI","Regression"})

    public void TC_52_validate_The_All_Widgets_Data_By_Selecting_1week_TimeLine()
    {
        //select the time line from calendar
        commPage.selectTheTimeLineFromCalender(IPathConstant.oneWeekTimeRange);

        //Validate whether the widgets are displaying the proper time line or not
        hardwarePage.validateTheGivenTimeLine();
    }

    @Test(groups={"DBM","Cassandra","UI","Regression"})

    public void TC_53_validate_The_All_Widgets_Data_By_Selecting_1month_TimeLine()
    {
        //select the time line from calendar
        commPage.selectTheTimeLineFromCalender(IPathConstant.oneMonthTimeRange);

        //Validate whether the widgets are displaying the proper time line or not
        hardwarePage.validateTheGivenTimeLine();
    }

    @Test(groups={"DBM","Cassandra","UI","Regression"})

    public void TC_54_validate_The_All_Widgets_By_selecting_custom_Time_For_Minutes_Range() throws EncryptedDocumentException, IOException
    {
        //select the time line from calendar
        commPage.selectTheCustomeTimeLine(IPathConstant.customTimeRange, eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customMinutesRange") );

        //Validate whether the widgets are displaying the proper time line or not
        hardwarePage.validateTheCustomTimeLine(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customMinutesRange"));
    }


    @Test(groups={"DBM","Cassandra","UI","Regression"})

    public void TC_55_validate_The_All_Widgets_By_selecting_custom_Time_For_Hours_Range() throws EncryptedDocumentException, IOException
    {
        //select the time line from calendar
        commPage.selectTheCustomeTimeLine(IPathConstant.customTimeRange, eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customHoursRange"));

        //Validate whether the widgets are displaying the proper time line or not
        hardwarePage.validateTheCustomTimeLine(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customHoursRange"));
    }

    @Test(groups={"DBM","Cassandra","UI","Regression"})

    public void TC_56_validate_The_All_Widgets_By_selecting_custom_Time_For_Days_Range() throws EncryptedDocumentException, IOException
    {

        //select the time line from calendar
        commPage.selectTheCustomeTimeLine(IPathConstant.customTimeRange, eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customDaysRange"));
        //Validate whether the widgets are displaying the proper time line or not
        hardwarePage.validateTheCustomTimeLine(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customDaysRange"));
    }

    @Test(groups={"DBM","Cassandra","UI","Regression"})

    public void TC_57_validate_The_All_Widgets_By_selecting_custom_Time_For_Future_date()
    {

        commPage.selectTheTimeLineFromCalender(IPathConstant.fiveMinutesTimeRange);

        //select the future time line from calendar
        commPage.validateTheFutureTimeLine();
    }


}
