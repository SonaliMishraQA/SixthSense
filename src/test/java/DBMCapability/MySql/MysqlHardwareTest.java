package DBMCapability.MySql;


import org.testng.annotations.Test;

import org.testng.annotations.BeforeMethod;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;
import genericUtilities.ExcelUtility;
import genericUtilities.IPathConstant;
import objectRepository.CommonPage;
import objectRepository.HomePage;
import objectRepository.DBM.MysqlHardwarePage;
import objectRepository.DBM.MysqlQueryPerformancePage;
import playWrightFactory.BaseClass;

public class MysqlHardwareTest extends BaseClass{
	
	HomePage homePage;
	ExcelUtility eutil;
	MysqlHardwarePage appPage;
	MysqlQueryPerformancePage qpPage;
	CommonPage comPage;
	
	@BeforeMethod
	public void preRequest() throws EncryptedDocumentException, IOException, InterruptedException
	{
		eutil=new ExcelUtility();
		homePage=new HomePage(page);
		appPage=new MysqlHardwarePage(page);
		qpPage = new MysqlQueryPerformancePage(page);
		Thread.sleep(5000);
		
		//Navigate to DBM capability
		commPage.navigateToDBM();
		
		//select the DBM type
		qpPage.selectDBMtype(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.mySqlNeelesh, "DBMtype"));
		
		//select the service 
		qpPage.selectDbservice(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.mySqlNeelesh, "DBMService"));
		 //Select the specific node to validate data
		 qpPage.validateSelectNodeDropDown(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.mySqlSheet,"Hostname"));
		// selecting the database option
		//qpPage.selectdatabse();
	}
	
	 @Test (groups = {"DBM","UI","Regression","MySQL"})
	public void TC_01_validateDBMNavigation() {
		
		//Navigate to DBM capability
		commPage.navigateToDBM();
		
		//validate the title
		qpPage.validateDBMPagetitle("Database Monitoring");
	}
	
	 @Test (groups = {"DBM","UI","Regression","MySQL"})
	public void TC_02_validateSelectedDBMtype() throws EncryptedDocumentException, IOException {
		//select the DBM type
		qpPage.selectDBMtype(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.mySqlNeelesh, "DBMtype"));
		
		//validate if the mysql database is selected or not
		
		qpPage.validatingtheselectedDBMtype(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath,IPathConstant.mySqlNeelesh, "DBMtype"));
	}
	
	 @Test (groups = {"DBM","UI","Regression","MySQL"})
	public void TC_O3_selectingAndValidationgTheService() throws EncryptedDocumentException, IOException {
		//select the DB service
		//qpPage.selectDbservice(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.mySqlNeelesh, "DBMService"));
		
		//validating if the required DB service is selected
		qpPage.validateselectedDbservice(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.mySqlNeelesh, "DBMService"));
	}
	
	 @Test (groups = {"DBM","UI","Regression","MySQL"})
	public void TC_04_selectingAndValidatingDatabase() throws EncryptedDocumentException, IOException{
		// selecting the database option
		//qpPage.selectdatabse();
		qpPage.selectDBMtype(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.mySqlNeelesh, "DBMtype"));
		//validating the selected database option
		qpPage.validateselecteddatabse(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.mySqlNeelesh, "DBMService"));
		
		
	}
	
	 @Test (groups = {"DBM","UI","Regression","MySQL"})
	
	public void TC_05_validatingHardwareTabisDisplayedbydefault() throws EncryptedDocumentException, IOException  {
		
		
		//validate if the Hardware tab is selected by default
		appPage.validateHardWareTabIsSelectedByDefault();	}
	
	
	

 @Test (groups = {"DBM","UI","Regression","MySQL"})
public void TC_06_validatingtheCardTypeofOS()throws EncryptedDocumentException, IOException  {
				
   //validate if the TypeofOS tab
	appPage.validateTypeOfOsLegend(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.mySqlNeelesh, "Hardware_OS_Type"));
}

 @Test (groups = {"DBM","UI","Regression","MySQL"})

public void TC_07_validatingTheCardHostname()throws EncryptedDocumentException, IOException{
	   		
	   //validate if the TypeofOS tab
		appPage.validateHostNameLegend(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.mySqlNeelesh, "Hardware_HostName"));

}

 @Test (groups = {"DBM","UI","Regression","MySQL"})
public void TC_08_validatingTheCardArchitecture()throws EncryptedDocumentException, IOException{
	  	
	   //validate if the TypeofOS tab
		appPage.validateArchitecture(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.mySqlNeelesh, "Hardware_Architecture"));

}

 @Test (groups = {"DBM","UI","Regression","MySQL"})

public void TC_09_validatingTheCardAvailability()throws EncryptedDocumentException, IOException{
	   	
	   //validate if the TypeofOS tab
		appPage.validateAvailabilityLegend(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.mySqlNeelesh, "Hardware_Availability"));

}

 @Test (groups = {"DBM","UI","Regression","MySQL"})
public void TC_10_validatingTheCardCpuUsage()throws EncryptedDocumentException, IOException{
	  	
	   //validate if the TypeofOS tab
		appPage.validateAverageCpuUsageLegend(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.mySqlNeelesh, "Hardware_CPUusage"));

}

 @Test (groups = {"DBM","UI","Regression","MySQL"})
public void TC_10_validatingTheCardMemoryUsage()throws EncryptedDocumentException, IOException{
	   
	   //validate if the TypeofOS tab
		appPage.validateAverageMemoryUsageLegend(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.mySqlNeelesh, "Hardware_MemoryUsage"));

}

//validating the Type of OS card when no data
 @Test (groups = {"DBM","UI","Regression","MySQL"})
public void TC_11_validatingtheOsTypeNoData()throws EncryptedDocumentException, IOException{
	
	// validating the No data value when no data is present for the Type of OS card
	appPage.validatingOSTypeWhenNoData(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.mySqlNeelesh , "Hardware_OS_Type_Value"));
	
}


//validating the Architecture card value when No data available
 @Test (groups = {"DBM","UI","Regression","MySQL"})
public void TC_12_validateArchitectureNoData()throws EncryptedDocumentException, IOException{
	
	appPage.validatingArchitectureValueWhenNoData(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.mySqlNeelesh , "Hardware_Architecture_Value"));
		
}

//validating the HostName card value when No data available
 @Test (groups = {"DBM","UI","Regression","MySQL"})
public void TC_13_validateHostNameNoData()throws EncryptedDocumentException, IOException{
	
	appPage.validatingHostnameValueWhenNoData(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.mySqlNeelesh , "Hardware_HostName_Value"));
}

//validating the Average CPU usage card when no data available
 @Test (groups = {"DBM","UI","Regression","MySQL"})
public void TC_14_validatingAverageCpuUsageValueWhenNoData()throws EncryptedDocumentException, IOException{
	
	appPage.validatingAverageCpuUsageValueWhenNoData(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.mySqlNeelesh , "Hardware_CPU_Memory_Nodata"));
		
}

//validating the Availability card when no data is present
 @Test (groups = {"DBM","UI","Regression","MySQL"})
public void TC_15_validatingAvailabilityNoData()throws EncryptedDocumentException, IOException{
	
	appPage.validatingAvailabilityValueWhenNoData(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.mySqlNeelesh , "Hardware_AvailabilityActive"));
		
}

//validating the Average Memory usage card value when no data
 @Test (groups = {"DBM","UI","Regression","MySQL"})

public void TC_16_validatingAverageMemoryUsageNoData()throws EncryptedDocumentException, IOException{
	
	appPage.validatingAverageMemoryUsageValueWhenNoData(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.mySqlNeelesh , "Hardware_CPU_Memory_Nodata"));
		
}

 @Test (groups = {"DBM","UI","Regression","MySQL"})
public void TC_17_validatingInactiveValueOfAvailability()throws EncryptedDocumentException, IOException{
	
	appPage.validateTheInactiveAvailabilityStatus(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.mySqlNeelesh , "Hardware_AvailabilityActive"));
		
}

 @Test (groups = {"DBM","UI","Regression","MySQL"})
public void TC_18_validatingActiveValueOfAvailability()throws EncryptedDocumentException, IOException{
	
	appPage.validateTheActiveAvailabilityStatus(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.mySqlNeelesh , "Hardware_AvailabilityActive"));
		
}

 @Test (groups = {"DBM","UI","Regression","MySQL"})
public void TC_19_validatingLoadAverage()throws EncryptedDocumentException, IOException{
	
	appPage.validateLoadAverage(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.mySqlNeelesh , "Hardware_clusterCard1"));
		
}

 @Test (groups = {"DBM","UI","Regression","MySQL"})
public void TC_20_validatingPort()throws EncryptedDocumentException, IOException{
	
	appPage.validatePort(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.mySqlNeelesh , "Hardware_clusterCard3"));
		
}

 @Test (groups = {"DBM","UI","Regression","MySQL"})
public void TC_21_validatingHost()throws EncryptedDocumentException, IOException{
	
	appPage.validateHost(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.mySqlNeelesh , "Hardware_clusterCard2"));
		
}

 @Test (groups = {"DBM","UI","Regression","MySQL"})
public void TC_22_validatingStatus()throws EncryptedDocumentException, IOException{
	
	appPage.validateStatus(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.mySqlNeelesh , "Hardware_clusterCard5"));
		
}

 @Test (groups = {"DBM","UI","Regression","MySQL"})
public void TC_23_validatingRole()throws EncryptedDocumentException, IOException{
	
	appPage.validateRole(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.mySqlNeelesh , "Hardware_clusterCard4"));
		
}

 @Test (groups = {"DBM","UI","Regression","MySQL"})
public void TC_24_diskUsageWidget() throws EncryptedDocumentException, IOException {
	appPage.validateHostDiskUsageCardTitle(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.mySqlNeelesh, "Hardware_DsikusageWidget"));
	
}

 @Test (groups = {"DBM","UI","Regression","MySQL"})
public void TC_25_validatingNoDataInDiskusageWidget()throws EncryptedDocumentException, IOException {
	
	appPage.validateDiskUsageCardNodataText(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.mySqlNeelesh, "Hardware_nodata_value"));
	
}

 @Test (groups = {"DBM","UI","Regression","MySQL"})
public void TC_26_cpuUsageGraph() throws EncryptedDocumentException, IOException {
	appPage.validateCpuUsageWidvalidateTitle(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.mySqlNeelesh, "Hardware_CPUusageGraph"));
	
}

 @Test (groups = {"DBM","UI","Regression","MySQL"})
public void TC_27_memoryUsageGraph() throws EncryptedDocumentException, IOException {
	appPage.validateMemoryUsageWidgetTitle(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.mySqlNeelesh, "Hardware_MemoryusageGraph"));
	
}

 @Test (groups = {"DBM","UI","Regression","MySQL"})
public void TC_28_networkIoGraph() throws EncryptedDocumentException, IOException {
	appPage.validateNetworkIOWidgetTitle(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.mySqlNeelesh, "Hardware_NetworkIOGraph"));
	
}

 @Test (groups = {"DBM","UI","Regression","MySQL"})
public void TC_29_totalReadWriteGraph()throws EncryptedDocumentException, IOException {
	appPage.validateTotalReadWriteTitle(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.mySqlNeelesh, "Harware_TotalReadWrite"));
	
}

 @Test (groups = {"DBM","UI","Regression","MySQL"})
public void TC_30_validatingTheNetworkIoLegendsText() throws EncryptedDocumentException, IOException {
	appPage.validateNetWorkIOWidgetLegendstext(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.mySqlNeelesh, "Hardware_NetIOLegends"));
}

 @Test (groups = {"DBM","UI","Regression","MySQL"})
public void TC_31_validatingtheTotalReadWriteLegendsText() throws EncryptedDocumentException, IOException {
	appPage.validateTotalReadWriteWidgetLegendstext(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.mySqlNeelesh, "Hardware_ReadWriteLegends"));
}

 @Test (groups = {"DBM","UI","Regression","MySQL"})
public void TC_32_validatingCpuUsageXaxisTitle() throws EncryptedDocumentException, IOException {
	appPage.validateCpuUsageXaxisTitle(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.mySqlNeelesh, "Hardware_Graph_xaxis"));
}

 @Test (groups = {"DBM","UI","Regression","MySQL"})
public void TC_33_validatingCpuUsageYaxisTitle()throws EncryptedDocumentException, IOException {
	appPage.validateCpuUsageYaxisTitle(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.mySqlNeelesh, "Hardware_CPUusageGraph_yaxis"));
}

 @Test (groups = {"DBM","UI","Regression","MySQL"})
public void TC_34_validatingCpuUsageToolTipByHover() {
	appPage.validateCpuUsavalidateoolTipTitle();
}

 @Test (groups = {"DBM","UI","Regression","MySQL"})
public void TC_35_validatingCpuUsageGraphZoomOut() {
	appPage.validateCpuUsageZoomOutBtn();
}

 @Test (groups = {"DBM","UI","Regression","MySQL"})
public void TC_36_validatingCpuUsageGraphoomIn() {
	appPage.validateCpuUsageZoomInBtn();
}

 @Test (groups = {"DBM","UI","Regression","MySQL"})
public void TC_37_validatingCpuUsageGraphZoomRest() {
	appPage.validateCpuUsageResetBtn();
}

 @Test (groups = {"DBM","UI","Regression","MySQL"})
public void TC_38_validatingCpuUsageXaxisDragAndDrop() {
	appPage.validateCpuUsageDragdrop();
}

 @Test (groups = {"DBM","UI","Regression","MySQL"})
public void TC_39_validatingMemoryUsageXaxisTitle() throws EncryptedDocumentException, IOException {
	appPage.validateMemoryUsageXaxisTitle(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath,IPathConstant.mySqlNeelesh, "Hardware_Graph_xaxis"));
}

 @Test (groups = {"DBM","UI","Regression","MySQL"})
public void TC_40_validatingMemoryUsageYaxisTitle()throws EncryptedDocumentException, IOException{
	appPage.validateMemoryUsageYaxisTitle(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath,IPathConstant.mySqlNeelesh, "Hardware_Graph_yaxis"));

}

 @Test (groups = {"DBM","UI","Regression","MySQL"})

public void TC_41_validatingMemoryUsageZoomOut() {
	appPage.validateMemoryUsageZoomOutBtn();
}

 @Test (groups = {"DBM","UI","Regression","MySQL"})
public void TC_42_validatingMemoryUsageZoomIn() {
	appPage.validatetMemoryUsageZoomInBtn();
}

 @Test (groups = {"DBM","UI","Regression","MySQL"})
public void TC_43_validatingMemoryUsageZoomReset() {
	appPage.validateMemoryUsageResetBtn();
}

 @Test (groups = {"DBM","UI","Regression","MySQL"})
public void TC_44_validatingMemoryUsageToolTipByHover() {
	appPage.validateMemoryUsageToolTipTitle();
}

 @Test (groups = {"DBM","UI","Regression","MySQL"})
public void TC_45_validatingMemoryUsageXaxisDragAndDrop() {
	appPage.validateMemoryUsageDragdrop();
}

 @Test (groups = {"DBM","UI","Regression","MySQL"})
public void TC_46_validatingNetworkIOXaxisTitle() throws EncryptedDocumentException, IOException {
	appPage.validateNetworkIOXaxisTitle(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.mySqlNeelesh, "Hardware_Graph_xaxis"));
}

 @Test (groups = {"DBM","UI","Regression","MySQL"})
public void TC_47_validatingNetworkIOYaxisTitle()throws EncryptedDocumentException, IOException {
	appPage.validateNetworkIOYaxisTitle(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.mySqlNeelesh, "Hardware_Graph_yaxis"));
}

 @Test (groups = {"DBM","UI","Regression","MySQL"})
public void TC_48_validatingNetworkIOZoomOut() {
	appPage.validateNetworkIOZoomOut();
}

 @Test (groups = {"DBM","UI","Regression","MySQL"})
public void TC_49_validatingNetworkIOZoomIn() {
	appPage.validateNetworkIOZoomIn();
}

 @Test (groups = {"DBM","UI","Regression","MySQL"})
public void TC_50_validatingNetwrokIOZoomReset()
{
	appPage.validateNetworkIOReset();
}

 @Test (groups = {"DBM","UI","Regression","MySQL"})
public void TC_51_validateNetworkIOToolTipByHover()
{
	appPage.validateNetworkIOToolTipTitle();
}

 @Test (groups = {"DBM","UI","Regression","MySQL"})
public void TC_52_validateNetworkIOXaxisDragAndDrop() {
	appPage.validateNetworkIODragAndDrop();
}

 @Test (groups = {"DBM","UI","Regression","MySQL"})
public void TC_53_validateTotalReadWriteXaxisTitle()throws EncryptedDocumentException, IOException {
	appPage.validateTotalReadWriteXaxisTitle(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.mySqlNeelesh,"Hardware_Graph_xaxis"));
}

 @Test (groups = {"DBM","UI","Regression","MySQL"})
public void TC_54_validatingTotalReadWriteYaxisTitle()throws EncryptedDocumentException, IOException {
	appPage.validateTotalReadWriteYaxisTitle(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.mySqlNeelesh,"Hardware_ReadWriteYaxis"));
}

 @Test (groups = {"DBM","UI","Regression","MySQL"})
public void TC_55_validatingTotalReadWriteZoomOut() {
	appPage.validateTotalReadWriteZoomOut();
}

 @Test (groups = {"DBM","UI","Regression","MySQL"})
public void TC_56_validatingTotalReadWriteZoomIn() {
	appPage.validateTotalReadWriteZoomIn();
}

 @Test (groups = {"DBM","UI","Regression","MySQL"})
public void TC_57_validatingTotalReadWriteZoomReset() {
	appPage.validateTotalReadWriteReset();
}

 @Test (groups = {"DBM","UI","Regression","MySQL"})
public void TC_58_validatingTotalReadWriteXaxisDragAndDrop() {
	appPage.validateTotalReadWriteDragAndDrop();
}

 @Test (groups = {"DBM","UI","Regression","MySQL"})
public void TC_59_validatingTotalReadWriteToolTipByHover() {
	appPage.validateTotalReadWriteToolTipTitle();
}

 @Test (groups = {"DBM","UI","Regression","MySQL"})
public void TC_60_validatingNetworkIOLegendsFunctionality() {
	appPage.validateNetworkIOLegendsfunctionality();
}

 @Test (groups = {"DBM","UI","Regression","MySQL"})
public void TC_61_validateTotalReadWriteLegendsFunctionality() {
	appPage.validateTotalReadWriteLegendsfunctionality();
}

 @Test (groups = {"DBM","UI","Regression","MySQL"})
public void TC_62_validateTotalBytesReadWriteXaxisTitle()throws EncryptedDocumentException, IOException {
	appPage.validateTotalBytesReadWriteXaxisTitle(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.mySqlNeelesh,"Hardware_Graph_xaxis"));
}

 @Test (groups = {"DBM","UI","Regression","MySQL"})
public void TC_63_validatingTotalBytesReadWriteYaxisTitle()throws EncryptedDocumentException, IOException {
	appPage.validateTotalBytesReadWriteYaxisTitle(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.mySqlNeelesh,"Hardware_Graph_yaxis"));
}

 @Test (groups = {"DBM","UI","Regression","MySQL"})
public void TC_64_validatingTotalBytesReadWriteZoomOut() {
	appPage.validateTotalBytesReadWriteZoomOut();
}

 @Test (groups = {"DBM","UI","Regression","MySQL"})
public void TC_65_validatingTotalBytesReadWriteZoomIn() {
	appPage.validateTotalBytesReadWriteZoomIn();
}

 @Test (groups = {"DBM","UI","Regression","MySQL"})
public void TC_66_validatingTotalBytesReadWriteZoomReset() {
	appPage.validateTotalBytesReadWriteReset();
}

 @Test (groups = {"DBM","UI","Regression","MySQL"})
public void TC_67_validatingTotalBytesReadWriteXaxisDragAndDrop() {
	appPage.validateTotalBytesReadWriteDragAndDrop();
}

 @Test (groups = {"DBM","UI","Regression","MySQL"})
public void TC_68_validatingTotalBytesReadWriteToolTipByHover() {
	appPage.validateTotalBytesReadWriteToolTipTitle();
}

 @Test (groups = {"DBM","UI","Regression","MySQL"})
public void TC_69_validatingTotalBytesReadWriteLegendsFunctionality() {
	appPage.validateTotalBytesReadWriteLegendsfunctionality();
}

 @Test (groups = {"DBM","UI","Regression","MySQL"})
public void TC_70_totalBytesReadWriteGraph()throws EncryptedDocumentException, IOException {
	appPage.validateTotalBytesReadWriteTitle(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.mySqlNeelesh, "Hardware_TotalBytesWrandRead"));
	
}

 @Test (groups = {"DBM","UI","Regression","MySQL"})
public void TC_71_validate_The_All_Widget_Data_By_Selecting_5Mins_TimeLine()
{
	//select the time line from calendar
	commPage.selectTheTimeLineFromCalender(IPathConstant.fiveMinutesTimeRange);

	//Validate whether the widgets are displaying the proper time line or not
	appPage.validateTheGivenTimeLine();
	
	
}
 @Test (groups = {"DBM","UI","Regression","MySQL"})
public void TC_72_validate_The_All_Widgets_Data_By_Selecting_15Mins_TimeLine()
{
	//select the time line from calendar
	commPage.selectTheTimeLineFromCalender(IPathConstant.fifteenMinutesTimeRange);

	//Validate whether the widgets are displaying the proper time line or not
	appPage.validateTheGivenTimeLine();
	
	
}

 @Test (groups = {"DBM","UI","Regression","MySQL"})
public void TC_73_validate_The_All_Widgets_Data_By_Selecting_30Mins_TimeLine()
{
	//select the time line from calendar
	commPage.selectTheTimeLineFromCalender(IPathConstant.thirtyMinutesTimeRange);

	//Validate whether the widgets are displaying the proper time line or not
	appPage.validateTheGivenTimeLine();

	
}

 @Test (groups = {"DBM","UI","Regression","MySQL"})
public void TC_74_validate_The_All_Widgets_Data_By_Selecting_60Mins_TimeLine()
{
	//select the time line from calendar
	commPage.selectTheTimeLineFromCalender(IPathConstant.sixtyMinutesTimeRange);

	//Validate whether the widgets are displaying the proper time line or not
	appPage.validateTheGivenTimeLine();
	
	
}

 @Test (groups = {"DBM","UI","Regression","MySQL"})
public void TC_75_validate_The_All_Widgets_Data_By_Selecting_3hours_TimeLine()
{
	//select the time line from calendar
	commPage.selectTheTimeLineFromCalender(IPathConstant.threeHoursTimeRange);

	//Validate whether the widgets are displaying the proper time line or not
	appPage.validateTheGivenTimeLine();
	
	
}

 @Test (groups = {"DBM","UI","Regression","MySQL"})
public void TC_76_validate_The_All_Widgets_Data_By_Selecting_6hours_TimeLine()
{
	//select the time line from calendar
	commPage.selectTheTimeLineFromCalender(IPathConstant.sixHoursTimeRange);

	//Validate whether the widgets are displaying the proper time line or not
	appPage.validateTheGivenTimeLine();
	
}

 @Test (groups = {"DBM","UI","Regression","MySQL"})
public void TC_77_validate_The_All_Widgets_Data_By_Selecting_12hours_TimeLine()
{
	//select the time line from calendar
	commPage.selectTheTimeLineFromCalender(IPathConstant.twelveHoursTimeRange);

	//Validate whether the widgets are displaying the proper time line or not
	appPage.validateTheGivenTimeLine();
	
}

 @Test (groups = {"DBM","UI","Regression","MySQL"})
public void TC_78_validate_The_All_Widgets_Data_By_Selecting_1day_TimeLine()
{
	//select the time line from calendar
	commPage.selectTheTimeLineFromCalender(IPathConstant.oneDayTimeRange);

	//Validate whether the widgets are displaying the proper time line or not
	appPage.validateTheGivenTimeLine();
	
}

 @Test (groups = {"DBM","UI","Regression","MySQL"})
public void TC_79_validate_The_All_Widgets_Data_By_Selecting_1week_TimeLine()
{
	//select the time line from calendar
	commPage.selectTheTimeLineFromCalender(IPathConstant.oneWeekTimeRange);

	//Validate whether the widgets are displaying the proper time line or not
	appPage.validateTheGivenTimeLine();
	
}

 @Test (groups = {"DBM","UI","Regression","MySQL"})
public void TC_80_validate_The_All_Widgets_Data_By_Selecting_1month_TimeLine()
{
	//select the time line from calendar
	commPage.selectTheTimeLineFromCalender(IPathConstant.oneMonthTimeRange);

	//Validate whether the widgets are displaying the proper time line or not
	appPage.validateTheGivenTimeLine();
	
}

 @Test (groups = {"DBM","UI","Regression","MySQL"})
public void TC_81_validate_The_All_Widgets_By_selecting_custom_Time_For_Minutes_Range() throws EncryptedDocumentException, IOException
{
	//select the time line from calendar
	commPage.selectTheCustomeTimeLine(IPathConstant.customTimeRange, eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customMinutesRange") );
	
	//Validate whether the widgets are displaying the proper time line or not
	appPage.validateTheCustomTimeLine(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customMinutesRange"));
	
	
}


 @Test (groups = {"DBM","UI","Regression","MySQL"})
public void TC_82_validate_The_All_Widgets_By_selecting_custom_Time_For_Hours_Range() throws EncryptedDocumentException, IOException
{
	//select the time line from calendar
	commPage.selectTheCustomeTimeLine(IPathConstant.customTimeRange, eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customHoursRange"));
	
	//Validate whether the widgets are displaying the proper time line or not
	appPage.validateTheCustomTimeLine(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customMinutesRange"));
			
	
	
}

 @Test (groups = {"DBM","UI","Regression","MySQL"})
public void TC_83_validate_The_All_Widgets_By_selecting_custom_Time_For_Days_Range() throws EncryptedDocumentException, IOException
{
	//select the time line from calendar
	commPage.selectTheCustomeTimeLine(IPathConstant.customTimeRange, eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customDaysRange"));
	
	//Validate whether the widgets are displaying the proper time line or not
	appPage.validateTheCustomTimeLine(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customMinutesRange"));
			
	
	
}

 @Test (groups = {"DBM","UI","Regression","MySQL"})
public void TC_84_validate_The_All_Widgets_By_selecting_custom_Time_For_Future_date()
{
	//select the future time line from calendar
	commPage.validateTheFutureTimeLine();
}

 @Test (groups = {"DBM","UI","Regression","MySQL"})
public void TC_85_validatingtheTotalBytesReadWriteLegendsText() throws EncryptedDocumentException, IOException {
	appPage.validateTotalBytesReadWriteWidgetLegendstext(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.mySqlNeelesh, "Hardware_BytesWritnReadLegends"));
}

}