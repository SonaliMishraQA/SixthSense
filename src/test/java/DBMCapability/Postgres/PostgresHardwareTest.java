package DBMCapability.Postgres;


import org.testng.annotations.Test;

import org.testng.annotations.BeforeMethod;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;
import genericUtilities.ExcelUtility;
import genericUtilities.IPathConstant;
import objectRepository.CommonPage;
import objectRepository.HomePage;
import objectRepository.DBM.PostgresHardware;
import playWrightFactory.BaseClass;

public class PostgresHardwareTest extends BaseClass{
	
	HomePage homePage;
	ExcelUtility eutil;
	PostgresHardware appPage;
	CommonPage comPage;
	
	@BeforeMethod
	public void preRequest() throws EncryptedDocumentException, IOException, InterruptedException
	{
		eutil=new ExcelUtility();
		homePage=new HomePage(page);
		appPage=new PostgresHardware(page);
		Thread.sleep(5000);
		
		//Navigate to DBM capability
		commPage.navigateToDBM();
		commPage.selectTheTimeLineFromCalender(IPathConstant.oneMonthTimeRange);
		
		//select the DBM type
		appPage.selectDBMtype(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.postgresGreeshma, "DBMtype"));
		
		//select the service 
		appPage.selectDbservice(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.postgresGreeshma, "DBMservice"));
		
		// selecting the database option
		//appPage.selectdatabse();
	}
	
	
	@Test(groups = {"DBM","UI","Regression","Postgres"})
	public void TC_01_validateDBMNavigation() {
		
		//Navigate to DBM capability
		commPage.navigateToDBM();
		
		//validate the title
		appPage.validateDBMPagetitle("Database Monitoring");
	}
	
	@Test(groups = {"DBM","UI","Regression","Postgres"})
	public void TC_02_validateSelectedDBMtype() throws EncryptedDocumentException, IOException {
		//select the DBM type
		appPage.selectDBMtype(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.postgresGreeshma, "DBMtype"));
		
		//validate if the Postgres database is selected or not
		
		appPage.validatingtheselectedDBMtype(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath,IPathConstant.postgresGreeshma, "DBMtype"));
	}
	
	@Test(groups = {"DBM","UI","Regression","Postgres"})
	public void TC_O3_selectingAndValidationgTheService() throws EncryptedDocumentException, IOException {
		//select the DB service
		appPage.selectDbservice(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.postgresGreeshma, "DBMservice"));
		
		//validating if the required DB service is selected
		appPage.validateselectedDbservice(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.postgresGreeshma, "DBMservice"));
	}
	
	/*@Test(groups = {"DBM","UI","Regression","Postgres"})
	public void TC_04_selectingAndValidatingDatabase() throws EncryptedDocumentException, IOException{
		// selecting the database option
		appPage.selectdatabse();
		
		//validating the selected database option
		appPage.validateselecteddatabse(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.postgresGreeshma, "DatabaseName"));
		
		
	}*/
	
	@Test(groups = {"DBM","UI","Regression","Postgres"})
	
	public void TC_04_validatingHardwareTabisDisplayedbydefault() throws EncryptedDocumentException, IOException  {
		
			//validate if the Hardware tab is selected by default
		appPage.validateHardWareTabIsSelectedByDefault();	}
	
	
	

@Test(groups = {"DBM","UI","Regression","Postgres"})
public void TC_05_validatingtheCardTypeofOS()throws EncryptedDocumentException, IOException  {
	 //validate if the TypeofOS tab
	//eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.postgresGreeshma, "Hardware_OSType");
	appPage.getTypeOfOsLegend(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.postgresGreeshma, "Hardware_OSType"));
}

@Test(groups = {"DBM","UI","Regression","Postgres"})

public void TC_06_validatingTheCardHostname()throws EncryptedDocumentException, IOException{
	   		
	   //validate if the TypeofOS tab
		appPage.getHostNameLegend(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.postgresGreeshma, "Hardware_HostName"));

}

@Test(groups = {"DBM","UI","Regression","Postgres"})
public void TC_07_validatingTheCardArchitecture()throws EncryptedDocumentException, IOException{
	   //validate if the TypeofOS tab
		appPage.getArchitectureLegend(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.postgresGreeshma, "Hardware_Architecture"));

}

@Test(groups = {"DBM","UI","Regression","Postgres"})

public void TC_08_validatingTheCardAvailability()throws EncryptedDocumentException, IOException{
	   //validate if the TypeofOS tab
		appPage.getAvailabilityLegend(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.postgresGreeshma, "Hardware_Availability"));

}

@Test(groups = {"DBM","UI","Regression","Postgres"})
public void TC_09_validatingTheCardCpuUsage()throws EncryptedDocumentException, IOException{
	    //validate if the TypeofOS tab
		appPage.getAverageCpuUsageLegend(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.postgresGreeshma, "Hardware_CPUusage"));

}

@Test(groups = {"DBM","UI","Regression","Postgres"})
public void TC_10_validatingTheCardMemoryUsage()throws EncryptedDocumentException, IOException{
	    //validate if the TypeofOS tab
		appPage.getAverageMemoryUsageLegend(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.postgresGreeshma, "Hardware_MemoryUsage"));

}

//validating the Type of OS card when no data
@Test(groups = {"DBM","UI","Regression","Postgres"})
public void TC_11_validatingtheOsTypeNoData()throws EncryptedDocumentException, IOException{
	commPage.selectTheTimeLineFromCalender(IPathConstant.fiveMinutesTimeRange);
	// validating the No data value when no data is present for the Type of OS card
	appPage.validatingOSTypeWhenNoData(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.postgresGreeshma , "Hardware_nodata_value"));
	
}


//validating the Architecture card value when No data available
@Test(groups = {"DBM","UI","Regression","Postgres"})
public void TC_12_validateArchitectureNoData()throws EncryptedDocumentException, IOException{
	commPage.selectTheTimeLineFromCalender(IPathConstant.fiveMinutesTimeRange);
	appPage.validatingArchitectureValueWhenNoData(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.postgresGreeshma , "Hardware_nodata_value"));
		
}

//validating the HostName card value when No data available
@Test(groups = {"DBM","UI","Regression","Postgres"})
public void TC_13_validateHostNameNoData()throws EncryptedDocumentException, IOException{
	commPage.selectTheTimeLineFromCalender(IPathConstant.fiveMinutesTimeRange);
	appPage.validatingHostnameValueWhenNoData(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.postgresGreeshma , "Hardware_nodata_value"));
}

//validating the Average CPU usage card when no data available
@Test(groups = {"DBM","UI","Regression","Postgres"})
public void TC_14_validatingAverageCpuUsageValueWhenNoData()throws EncryptedDocumentException, IOException, InterruptedException{
	commPage.selectTheTimeLineFromCalender(IPathConstant.fiveMinutesTimeRange);
	Thread.sleep(2000);
	appPage.validatingAverageCpuUsageValueWhenNoData(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.postgresGreeshma , "Hardware_CPU_Memory_Nodata"));
		
}

//validating the Availability card when no data is present
@Test(groups = {"DBM","UI","Regression","Postgres"})
public void TC_15_validatingAvailabilityNoData()throws EncryptedDocumentException, IOException{
	commPage.selectTheTimeLineFromCalender(IPathConstant.fiveMinutesTimeRange);
	appPage.validatingAvailabilityValueWhenNoData(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.postgresGreeshma , "Hardware_nodata_value"));
		
}

//validating the Average Memory usage card value when no data
@Test
(groups = {"DBM","UI","Regression","Postgres"})
public void TC_16_validatingAverageMemoryUsageNoData()throws EncryptedDocumentException, IOException{
	commPage.selectTheTimeLineFromCalender(IPathConstant.fiveMinutesTimeRange);
	appPage.validatingAverageMemoryUsageValueWhenNoData(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.postgresGreeshma , "Hardware_CPU_Memory_Nodata"));
		
}

/*@Test(groups = {"DBM","UI","Regression","Postgres"})
public void TC_17_validatingInactiveValueOfAvailability()throws EncryptedDocumentException, IOException{
	
	appPage.validateTheInactiveAvailabilityStatus(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.postgresGreeshma , "Hardware_AvailabilityInactive"));
		
}
*/
@Test(groups = {"DBM","UI","Regression","Postgres"})
public void TC_17_validatingActiveValueOfAvailability()throws EncryptedDocumentException, IOException, InterruptedException{
	Thread.sleep(2000);
	appPage.validateTheActiveAvailabilityStatus(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.postgresGreeshma , "Hardware_AvailabilityActive"));
		
}

@Test(groups = {"DBM","UI","Regression","Postgres"})
public void TC_18_diskUsageWidget() throws EncryptedDocumentException, IOException {
	appPage.getDiskUsageCardTitle(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.postgresGreeshma, "Hardware_DsikusageWidget"));
	
}

@Test(groups = {"DBM","UI","Regression","Postgres"})
public void TC_19_validatingNoDataInDiskusageWidget()throws EncryptedDocumentException, IOException {
	commPage.selectTheTimeLineFromCalender(IPathConstant.fiveMinutesTimeRange);
	appPage.getDiskUsageCardNodataText(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.postgresGreeshma, "Hardware_nodata_value"));
	
}

@Test(groups = {"DBM","UI","Regression","Postgres"})
public void TC_20_cpuUsageGraph() throws EncryptedDocumentException, IOException {
	appPage.getCpuUsageWidgetTitle(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.postgresGreeshma, "Hardware_CPUusageGraph"));
	
}

@Test(groups = {"DBM","UI","Regression","Postgres"})
public void TC_21_memoryUsageGraph() throws EncryptedDocumentException, IOException {
	appPage.getMemoryUsageWidgetTitle(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.postgresGreeshma, "Hardware_MemoryusageGraph"));
	
}

@Test(groups = {"DBM","UI","Regression","Postgres"})
public void TC_22_networkIoGraph() throws EncryptedDocumentException, IOException {
	appPage.getNetworkIOWidgetTitle(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.postgresGreeshma, "Hardware_NetworkIOGraph"));
	
}

@Test(groups = {"DBM","UI","Regression","Postgres"})
public void TC_23_connectionsAndSessionGraph()throws EncryptedDocumentException, IOException {
	appPage.getConnectionsAndSessionWidgetTitle(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.postgresGreeshma, "Harware_Conn&SessionGraph"));
	
}

@Test(groups = {"DBM","UI","Regression","Postgres"})
public void TC_24_validatingTheNetworkIoLegendsText() throws EncryptedDocumentException, IOException {
	appPage.validateNetWorkIOWidgetLegendstext(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.postgresGreeshma, "Hardware_NetIOLegends"));
}

@Test(groups = {"DBM","UI","Regression","Postgres"})
public void TC_25_validatingtheConnectionAndSessionLegendsText() throws EncryptedDocumentException, IOException {
	appPage.getConnectionsAndSessionWidgetLegendsList(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.postgresGreeshma, "Hardware_Conn&SessLegends"));
}

@Test(groups = {"DBM","UI","Regression","Postgres"})
public void TC_26_validatingCpuUsageXaxisTitle() throws EncryptedDocumentException, IOException {
	appPage.validateCpuUsageXaxisTitle(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.postgresGreeshma, "Hardware_Graph_xaxis"));
}

@Test(groups = {"DBM","UI","Regression","Postgres"})
public void TC_27_validatingCpuUsageYaxisTitle()throws EncryptedDocumentException, IOException {
	appPage.validateCpuUsageYaxisTitle(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.postgresGreeshma, "Hardware_CPUusageGraph_yaxis"));
}

@Test(groups = {"DBM","UI","Regression","Postgres"})
public void TC_28_validatingCpuUsageToolTipByHover() {
	appPage.validateCpuUsageToolTipTitle();
}

@Test(groups = {"DBM","UI","Regression","Postgres"})
public void TC_29_validatingCpuUsageGraphZoomOut() {
	appPage.validateCpuUsageZoomOutBtn();
}

@Test(groups = {"DBM","UI","Regression","Postgres"})
public void TC_30_validatingCpuUsageGraphoomIn() {
	appPage.validateCpuUsageZoomInBtn();
}

@Test(groups = {"DBM","UI","Regression","Postgres"})
public void TC_31_validatingCpuUsageGraphZoomRest() {
	appPage.validateCpuUsageResetBtn();
}

@Test(groups = {"DBM","UI","Regression","Postgres"})
public void TC_32_validatingCpuUsageXaxisDragAndDrop() {
	appPage.validateCpuUsageDragdrop();
}

@Test(groups = {"DBM","UI","Regression","Postgres"})
public void TC_33_validatingMemoryUsageXaxisTitle() throws EncryptedDocumentException, IOException {
	appPage.validateMemoryUsageXaxisTitle(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath,IPathConstant.postgresGreeshma, "Hardware_Graph_xaxis"));
}

@Test(groups = {"DBM","UI","Regression","Postgres"})
public void TC_34_validatingMemoryUsageYaxisTitle()throws EncryptedDocumentException, IOException{
	appPage.validateMemoryUsageYaxisTitle(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath,IPathConstant.postgresGreeshma, "Hardware_Graph_yaxis"));

}

@Test(groups = {"DBM","UI","Regression","Postgres"})

public void TC_35_validatingMemoryUsageZoomOut() {
	appPage.validateMemoryUsageZoomOutBtn();
}

@Test(groups = {"DBM","UI","Regression","Postgres"})
public void TC_36_validatingMemoryUsageZoomIn() {
	
	appPage.validatetMemoryUsageZoomInBtn();
}

@Test(groups = {"DBM","UI","Regression","Postgres"})
public void TC_37_validatingMemoryUsageZoomReset() {
	appPage.validateMemoryUsageResetBtn();
}

@Test(groups = {"DBM","UI","Regression","Postgres"})
public void TC_38_validatingMemoryUsageToolTipByHover() {
	appPage.validateMemoryUsageToolTipTitle();
}

@Test(groups = {"DBM","UI","Regression","Postgres"})
public void TC_39_validatingMemoryUsageXaxisDragAndDrop() {
	appPage.validateMemoryUsageDragdrop();
}

@Test(groups = {"DBM","UI","Regression","Postgres"})
public void TC_40_validatingNetworkIOXaxisTitle() throws EncryptedDocumentException, IOException {
	appPage.validateNetworkIOXaxisTitle(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.postgresGreeshma, "Hardware_Graph_xaxis"));
}

@Test(groups = {"DBM","UI","Regression","Postgres"})
public void TC_41_validatingNetworkIOYaxisTitle()throws EncryptedDocumentException, IOException {
	appPage.validateNetworkIOYaxisTitle(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.postgresGreeshma, "Hardware_Graph_yaxis"));
}

@Test(groups = {"DBM","UI","Regression","Postgres"})
public void TC_42_validatingNetworkIOZoomOut() {
	appPage.validateNetworkIOZoomOut();
}

@Test(groups = {"DBM","UI","Regression","Postgres"})
public void TC_43_validatingNetworkIOZoomIn() {
	appPage.validateNetworkIOZoomIn();
}

@Test(groups = {"DBM","UI","Regression","Postgres"})
public void TC_44_validatingNetwrokIOZoomReset()
{
	appPage.validateNetworkIOReset();
}

@Test(groups = {"DBM","UI","Regression","Postgres"})
public void TC_45_validateNetworkIOToolTipByHover()
{
	appPage.validateNetworkIOToolTipTitle();
}

@Test(groups = {"DBM","UI","Regression","Postgres"})
public void TC_46_validateNetworkIOXaxisDragAndDrop() {
	appPage.validateNetworkIODragAndDrop();
}

@Test(groups = {"DBM","UI","Regression","Postgres"})
public void TC_47_validateConnectionsAndSessionXaxisTitle()throws EncryptedDocumentException, IOException {
	appPage.validateConnectionsAndSessionXaxisTitle(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.postgresGreeshma,"Hardware_Graph_xaxis"));
}

@Test(groups = {"DBM","UI","Regression","Postgres"})
public void TC_48_validatingConnectionsAndSessionYaxisTitle()throws EncryptedDocumentException, IOException {
	appPage.validateConnectionsAndSessionYaxisTitle(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.postgresGreeshma,"Hardware_conn&SessGraph_yaxis"));
}

@Test(groups = {"DBM","UI","Regression","Postgres"})
public void TC_49_validatingConnectionsAndSessionZoomOut() {
	appPage.validateConnectionsAndSessionZoomOut();
}

@Test(groups = {"DBM","UI","Regression","Postgres"})
public void TC_50_validatingConnectionsAndSessionZoomIn() {
	appPage.validateConnectionsAndSessionZoomIn();
}

@Test(groups = {"DBM","UI","Regression","Postgres"})
public void TC_51_validatingConnectionsAndSessionZoomReset() {
	appPage.validateConnectionsAndSessionReset();
}

@Test(groups = {"DBM","UI","Regression","Postgres"})
public void TC_52_validatingConnectionsAndSessionXaxisDragAndDrop() {
	appPage.validateConnectionsAndSessionsDragAndDrop();
}

@Test(groups = {"DBM","UI","Regression","Postgres"})
public void TC_53_validatingConnectionsAndSessionToolTipByHover() {
	appPage.validateConnectionsAndSessionToolTipTitle();
}

@Test(groups = {"DBM","UI","Regression","Postgres"})
public void TC_54_validatingNetworkIOLegendsFunctionality() {
	appPage.validateNetworkIOLegendsfunctionality();
}

@Test(groups = {"DBM","UI","Regression","Postgres"})
public void TC_55_validateConnectionAndSessionLegendsFunctionality() throws InterruptedException {
	Thread.sleep(2000);
	appPage.validateConnectionAndSessionLegendsFunctionality();
}

@Test(groups = {"DBM","UI","Regression","Postgres"})
public void TC_56_validate_The_All_Widget_Data_By_Selecting_5Mins_TimeLine()
{
	//select the time line from calendar
	commPage.selectTheTimeLineFromCalender(IPathConstant.fiveMinutesTimeRange);

	//Validate whether the widgets are displaying the proper time line or not
	appPage.validateTheGivenTimeLine();
	
	
}
@Test(groups = {"DBM","UI","Regression","Postgres"})
public void TC_57_validate_The_All_Widgets_Data_By_Selecting_15Mins_TimeLine()
{
	//select the time line from calendar
	commPage.selectTheTimeLineFromCalender(IPathConstant.fifteenMinutesTimeRange);

	//Validate whether the widgets are displaying the proper time line or not
	appPage.validateTheGivenTimeLine();
	
	
}

@Test(groups = {"DBM","UI","Regression","Postgres"})
public void TC_58_validate_The_All_Widgets_Data_By_Selecting_30Mins_TimeLine()
{
	//select the time line from calendar
	commPage.selectTheTimeLineFromCalender(IPathConstant.thirtyMinutesTimeRange);

	//Validate whether the widgets are displaying the proper time line or not
	appPage.validateTheGivenTimeLine();

	
}

@Test(groups = {"DBM","UI","Regression","Postgres"})
public void TC_59_validate_The_All_Widgets_Data_By_Selecting_60Mins_TimeLine()
{
	//select the time line from calendar
	commPage.selectTheTimeLineFromCalender(IPathConstant.sixtyMinutesTimeRange);

	//Validate whether the widgets are displaying the proper time line or not
	appPage.validateTheGivenTimeLine();
	
	
}

@Test(groups = {"DBM","UI","Regression","Postgres"})
public void TC_60_validate_The_All_Widgets_Data_By_Selecting_3hours_TimeLine()
{
	//select the time line from calendar
	commPage.selectTheTimeLineFromCalender(IPathConstant.threeHoursTimeRange);

	//Validate whether the widgets are displaying the proper time line or not
	appPage.validateTheGivenTimeLine();
	
	
}

@Test(groups = {"DBM","UI","Regression","Postgres"})
public void TC_61_validate_The_All_Widgets_Data_By_Selecting_6hours_TimeLine()
{
	//select the time line from calendar
	commPage.selectTheTimeLineFromCalender(IPathConstant.sixHoursTimeRange);

	//Validate whether the widgets are displaying the proper time line or not
	appPage.validateTheGivenTimeLine();
	
}

@Test(groups = {"DBM","UI","Regression","Postgres"})
public void TC_62_validate_The_All_Widgets_Data_By_Selecting_12hours_TimeLine()
{
	//select the time line from calendar
	commPage.selectTheTimeLineFromCalender(IPathConstant.twelveHoursTimeRange);

	//Validate whether the widgets are displaying the proper time line or not
	appPage.validateTheGivenTimeLine();
	
}

@Test(groups = {"DBM","UI","Regression","Postgres"})
public void TC_63_validate_The_All_Widgets_Data_By_Selecting_1day_TimeLine()
{
	//select the time line from calendar
	commPage.selectTheTimeLineFromCalender(IPathConstant.oneDayTimeRange);

	//Validate whether the widgets are displaying the proper time line or not
	appPage.validateTheGivenTimeLine();
	
}

@Test(groups = {"DBM","UI","Regression","Postgres"})
public void TC_64_validate_The_All_Widgets_Data_By_Selecting_1week_TimeLine()
{
	//select the time line from calendar
	commPage.selectTheTimeLineFromCalender(IPathConstant.oneWeekTimeRange);

	//Validate whether the widgets are displaying the proper time line or not
	appPage.validateTheGivenTimeLine();
	
}

@Test(groups = {"DBM","UI","Regression","Postgres"})
public void TC_65_validate_The_All_Widgets_Data_By_Selecting_1month_TimeLine()
{
	//select the time line from calendar
	commPage.selectTheTimeLineFromCalender(IPathConstant.oneMonthTimeRange);

	//Validate whether the widgets are displaying the proper time line or not
	appPage.validateTheGivenTimeLine();
	
}

@Test(groups = {"DBM","UI","Regression","Postgres"})
public void TC_66_validate_The_All_Widgets_By_selecting_custom_Time_For_Minutes_Range() throws EncryptedDocumentException, IOException
{
	//select the time line from calendar
	commPage.selectTheCustomeTimeLine(IPathConstant.customTimeRange, eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customMinutesRange") );
	
	//Validate whether the widgets are displaying the proper time line or not
	appPage.validateTheCustomTimeLine(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customMinutesRange"));
	
	
}


@Test(groups = {"DBM","UI","Regression","Postgres"})
public void TC_67_validate_The_All_Widgets_By_selecting_custom_Time_For_Hours_Range() throws EncryptedDocumentException, IOException
{
	//select the time line from calendar
	commPage.selectTheCustomeTimeLine(IPathConstant.customTimeRange, eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customHoursRange"));
	
	//Validate whether the widgets are displaying the proper time line or not
	appPage.validateTheCustomTimeLine(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customMinutesRange"));
			
	
	
}

@Test(groups = {"DBM","UI","Regression","Postgres"})
public void TC_68_validate_The_All_Widgets_By_selecting_custom_Time_For_Days_Range() throws EncryptedDocumentException, IOException
{
	//select the time line from calendar
	commPage.selectTheCustomeTimeLine(IPathConstant.customTimeRange, eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customDaysRange"));
	
	//Validate whether the widgets are displaying the proper time line or not
	appPage.validateTheCustomTimeLine(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customMinutesRange"));
			
	
	
}

@Test(groups = {"DBM","UI","Regression","Postgres"})
public void TC_69_validate_The_All_Widgets_By_selecting_custom_Time_For_Future_date()
{
	//select the future time line from calendar
	commPage.validateTheFutureTimeLine();
}











}
