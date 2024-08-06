package mobileMonitoringCapability;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.microsoft.playwright.Locator;

import api.MMAPIRequests;
import genericUtilities.ExcelUtility;
import genericUtilities.GenericMethods;
import genericUtilities.IPathConstant;
import objectRepository.MM.MMCrashesPage;
import playWrightFactory.BaseClass;

public class MMCrashesTest extends BaseClass{
 
	MMCrashesPage crashesPage;
	GenericMethods util;
	ExcelUtility eutil;

	
	@BeforeMethod
	public void preRequests() throws EncryptedDocumentException, IOException, InterruptedException
	{
		util=new GenericMethods();
		crashesPage=new MMCrashesPage(page);
		eutil=new ExcelUtility();
		//Navigate to mobileMonitoring capability
		commPage.navigateToMobileMonitoring();
				
		//navigate to crashes page
		crashesPage.navigateToCrashesPage();
				
		//select the Time line 
		commPage.selectTheTimeLineFromCalender(IPathConstant.sixHoursTimeRange);
						
		//select the Application
		crashesPage.selectTheApplicationForMM(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmCrashesSheet, "application"));
						
		//select the OS
		crashesPage.selectOS(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "AllOS"));
						
		//select the app version
		crashesPage.selectAppVersion(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "AllAppversions"));
	}
	
	
	@Test
	public void TC_001_validateMobileMonitoringSideNavBtn() throws InterruptedException
	{
		
		//Navigate to mobile monitoring page
		commPage.navigateToMobileMonitoring();
		
		//Validate whether mobile monitoring page displayed or not
		crashesPage.validateTheMMPageTitle("Mobile monitoring");
		
	}
	
	@Test
	public void TC_002_validateTheKPIsTab() throws InterruptedException
	{
		//Navigate to mobile monitoring page
		commPage.navigateToMobileMonitoring();
		
		//Validate whether KIP's tab is displaying or not
		crashesPage.validateTheKPIsTab();
	}
	
	@Test
	public void TC_003_validateTheCrashesPage() throws InterruptedException
	{
		//Navigate to mobile monitoring page
		commPage.navigateToMobileMonitoring();
		
		//Validate whether KIP's tab is displaying or not
		crashesPage.validateTheKPIsTab();
				
		//click on the crashes tab and validate whether it is displaying the crashes page
		crashesPage.validateTheCrashespage();
	}
	
	@Test
	public void TC_004_validateTheCrashesWidgetTitle() throws EncryptedDocumentException, IOException
	{
		//validate the crashes widget title
		crashesPage.validatecrashesWidgetTitle(util.getvalueFromexcel(IPathConstant.MMexcelPath,IPathConstant.mmCrashesSheet, "crashesWidgetTitle"));
	}
	
	@Test
	public void TC_005_validateTheCrashesWidgetXaxisTitle() throws EncryptedDocumentException, IOException
	{
		crashesPage.validatecrashesXaxisTitle(util.getvalueFromexcel(IPathConstant.MMexcelPath,IPathConstant.mmCrashesSheet, "crashesWidgetXaxisTitle"));
	}
	
	@Test
	public void TC_006_validateTheCrashesWidgetYaxisTitle() throws EncryptedDocumentException, IOException
	{
		crashesPage.validatecrashesYaxisTitle(util.getvalueFromexcel(IPathConstant.MMexcelPath,IPathConstant.mmCrashesSheet, "crashesWidgetYaxisTitle"));
	}
	
	@Test
	public void TC_007_validateTheCrashesWidgetZoomIn()
	{
		//Validate the crashes widget zoom in button
		crashesPage.validateTheCrasheswidgetZoomIn();
	}
	
	@Test
	public void TC_008_validateTheCrashesWidgetZoomOut()
	{
		crashesPage.validateTheCrasheswidgetZoomOut();
	}
	
	@Test
	public void TC_009_validateTheCrashesWidgetZoomReset()
	{
		crashesPage.validateTheCrasheswidgetZoomReset();
	}
	
	@Test
	public void TC_010_Validate_Crashes_widget_ToolTip_By_Hover() throws InterruptedException
	
	{
		//validate the toolTip of given widget
		crashesPage.validateCrashesWidgetToolTip();
	}
	@Test
	public void TC_011_validateTheCrashesWidgetDragAndDropOption()
	{
		crashesPage.validateTheCrasheswidgetDragAndDrop();
	}
	
	@Test
	public void TC_012_validateTheCrashAffectedUsersWidgetTitle() throws EncryptedDocumentException, IOException
	{
		crashesPage.validateCrashesAffectedUsersWidgetTitle(util.getvalueFromexcel(IPathConstant.MMexcelPath,IPathConstant.mmCrashesSheet, "crashAffectedUsersWidgetTitle"));
	}
	
	@Test
	public void TC_013_validateTheCrashAffectedUsersWidgetXaxisTitle() throws EncryptedDocumentException, IOException
	{
		crashesPage.validateCrashesAffectedUsersXaxisTitle(util.getvalueFromexcel(IPathConstant.MMexcelPath,IPathConstant.mmCrashesSheet, "crashAffectedUsersWidgetXAxisTitle"));
	}
	
	@Test
	public void TC_014_validateTheCrashAffectedUsersWidgetYaxisTitle() throws EncryptedDocumentException, IOException
	{
		crashesPage.validateCrashesAffectedUsersYaxisTitle(util.getvalueFromexcel(IPathConstant.MMexcelPath,IPathConstant.mmCrashesSheet, "crashAffectedUsersWidgetYAxisTitle"));
	}
	
	@Test
	public void TC_015_validateTheCrashAffectedUsersWidgetZoomIn()
	{
		crashesPage.validateTheCrashesAffectedUserswidgetZoomIn();
	}
	
	@Test
	public void TC_016_validateTheCrashAffectedUsersWidgetZoomOut()
	{
		crashesPage.validateTheCrashesAffectedUserswidgetZoomOut();
	}
	
	@Test
	public void TC_017_validateTheCrashAffectedUsersWidgetZoomReset()
	{
		crashesPage.validateTheCrashesAffectedUserswidgetZoomReset();
	}
	
	@Test
	public void TC_018_Validate_CrashAffectedUsers_widget_ToolTip_By_Hover() throws InterruptedException
	{
		crashesPage.validateCrashesAffectedUsersWidgetToolTip();
	}
	
	@Test
	public void TC_019_validateTheCrashAffectedUsersWidgetDragAndDropXaxis()
	{
		crashesPage.validateTheCrashesAffectedUserswidgetDragAndDrop();
	}
	
	@Test
	public void TC_020_validateTheCrashesByDeviceWidgetTitle() throws EncryptedDocumentException, IOException
	{
		crashesPage.validateCrashesByDeviceWidgetTitle(util.getvalueFromexcel(IPathConstant.MMexcelPath,IPathConstant.mmCrashesSheet, "crashByDeviceWidgetTitle"));
	}
	
	@Test
	public void TC_021_validateTheCrashesByDeviceWidgetXaxisTitle() throws EncryptedDocumentException, IOException
	{
		crashesPage.validateCrashesByDeviceXaxisTitle(util.getvalueFromexcel(IPathConstant.MMexcelPath,IPathConstant.mmCrashesSheet, "crashByDeviceWidgetXAxisTitle"));
	}
	
	@Test
	public void TC_022_validateTheCrashesByDeviceWidgetYaxisTitle() throws EncryptedDocumentException, IOException
	{
		crashesPage.validateCrashesByDeviceYaxisTitle(util.getvalueFromexcel(IPathConstant.MMexcelPath,IPathConstant.mmCrashesSheet, "crashByDeviceWidgetYAxisTitle"));
	}
	
	@Test
	public void TC_023_validateTheCrashesByDeviceWidgetZoomIn()
	{
		crashesPage.validateTheCrashesByDevicewidgetZoomIn();
	}
	
	@Test
	public void TC_024_validateTheCrashesByDeviceWidgetZoomOut()
	{
		crashesPage.validateTheCrashesByDevicewidgetZoomOut();
	}
	
	@Test
	public void TC_025_validateTheCrashesByDeviceWidgetZoomReset()
	{
		crashesPage.validateTheCrashesByDevicewidgetZoomReset();
	}
	
	@Test
	public void TC_026_Validate_CrashesByDevice_widget_ToolTip_By_Hover() throws InterruptedException
	{
		crashesPage.validateCrashesByDeviceWidgetToolTip();
	}
	
	@Test
	public void TC_027_validate_The_Crashes_By_Device_Widget_Drag_And_Drop_Xaxis()
	{
		crashesPage.validateTheCrashesByDevicewidgetDragAndDrop();
	}
	
	@Test
	public void TC_028_validate_The_Crashes_By_Device_Widget_Legends_Text_For_All_OS() throws EncryptedDocumentException, IOException
	{
		//select the OS
		crashesPage.selectOS(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "AllOS"));
		
		//select the app version
		crashesPage.selectAppVersion(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "AllAppversions"));
		
		crashesPage.validateCrashByDeviceLegendsText(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath, IPathConstant.mmLoadSheet, "devicesForAndroid"),
				eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath, IPathConstant.mmLoadSheet, "devicesForIos"));
	}
	
	@Test
	public void TC_029_validate_The_Crashes_By_Device_Widget_Legends_Text_For_Android_OS()throws EncryptedDocumentException, IOException
	{
		//select the OS
		crashesPage.selectOS(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "androidOS"));
		
		//select the app version
		crashesPage.selectAppVersion(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "AllAppversions"));
		
		crashesPage.validateCrashByDeviceLegendsText(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath, IPathConstant.mmLoadSheet, "devicesForAndroid"));
	}
	
	@Test
	public void TC_030_validate_The_Crashes_By_Device_Widget_Legends_Text_For_Android_With_Specific_App_Version()throws EncryptedDocumentException, IOException
	{
		//select the OS
		crashesPage.selectOS(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "androidOS"));
		
		//select the app version
		crashesPage.selectAppVersion(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "androidAppVersion"));
		
		crashesPage.validateCrashByDeviceLegendsText(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath, IPathConstant.mmLoadSheet, "DeviceForAndroidAppversion"));
	}
	
	
	@Test
	public void TC_031_validate_The_Crashes_By_Device_Widget_Legends_Text_For_Ios_OS()throws EncryptedDocumentException, IOException
	{
		//select the OS
		crashesPage.selectOS(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "IosOS"));
		
		//select the app version
		crashesPage.selectAppVersion(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "AllAppversions"));
		
		crashesPage.validateCrashByDeviceLegendsText(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath, IPathConstant.mmLoadSheet, "devicesForIos"));
	}
	
	@Test
	public void TC_032_validate_The_Crashes_By_Device_Widget_Legends_Text_For_Ios_With_Specific_App_Version()throws EncryptedDocumentException, IOException
	{
		//select the OS
		crashesPage.selectOS(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "IosOS"));
		
		//select the app version
		crashesPage.selectAppVersion(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "IosAppVersion"));
		
		crashesPage.validateCrashByDeviceLegendsText(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath, IPathConstant.mmLoadSheet, "DeviceForIosAppVersion"));
	}
	
	@Test
	public void TC_033_validate_The_Crashes_By_Device_Widget_Legends()throws EncryptedDocumentException, IOException
	{
		crashesPage.validateCrashesByDeviceswidgetLegends();
	}
	

	@Test
	public void TC_034_validateTheCrashesByOsWidgetTitle() throws EncryptedDocumentException, IOException
	{
		crashesPage.validateCrashesByOSWidgetTitle(util.getvalueFromexcel(IPathConstant.MMexcelPath,IPathConstant.mmCrashesSheet, "crashByOsWidgetTitle"));
	}
	
	@Test
	public void TC_035_validateTheCrashesByOsWidgetXaxisTitle() throws EncryptedDocumentException, IOException
	{
		crashesPage.validateCrashesByOSXaxisTitle(util.getvalueFromexcel(IPathConstant.MMexcelPath,IPathConstant.mmCrashesSheet, "crashByOsWidgetXAxisTitle"));
	}
	
	@Test
	public void TC_036_validateTheCrashesByOsWidgetYaxisTitle() throws EncryptedDocumentException, IOException
	{
		crashesPage.validateCrashesByOSYaxisTitle(util.getvalueFromexcel(IPathConstant.MMexcelPath,IPathConstant.mmCrashesSheet, "crashByOsWidgetYAxisTitle"));
	}
	
	@Test
	public void TC_037_validateTheCrashesByOsWidgetZoomIn()
	{
		crashesPage.validateTheCrashesByOSwidgetZoomIn();
	}
	
	@Test
	public void TC_038_validateTheCrashesByOsWidgetZoomOut()
	{
		crashesPage.validateTheCrashesByOSwidgetZoomOut();
	}
	
	@Test
	public void TC_039_validateTheCrashesByOsWidgetZoomReset()
	{
		crashesPage.validateTheCrashesByOSwidgetZoomReset();
	}
	
	@Test
	public void TC_040_Validate_CrashesByOs_widget_ToolTip_By_Hover() throws InterruptedException
	{
		crashesPage.validateCrashesByOSWidgetToolTip();
	}
	
	@Test
	public void TC_041_validateTheCrashesByOsWidgetDragAndDropXaxis()
	{
		crashesPage.validateTheCrashesByOSwidgetDragAndDrop();
	}
	
	@Test
	public void TC_042_validate_The_Crashes_By_Os_Widget_Legends_Text_For_All_OS()throws EncryptedDocumentException, IOException
	{
		//select the OS
		crashesPage.selectOS(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "AllOS"));
		
		//select the app version
		crashesPage.selectAppVersion(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "AllAppversions"));
		
		crashesPage.validateCrashByOsLegendsTextForAllOs(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath, IPathConstant.mmLoadSheet, "osType"));
	}
	
	@Test
	public void TC_043_validate_The_Crashes_By_Os_Widget_Legends_Text_For_Android_OS()throws EncryptedDocumentException, IOException
	{
		//select the OS
		crashesPage.selectOS(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "androidOS"));
		
		//select the app version
		crashesPage.selectAppVersion(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "AllAppversions"));
		
		crashesPage.validateCrashByOsLegendsTextForAndroid(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath, IPathConstant.mmLoadSheet, "osType"));
	}
	
	@Test
	public void TC_044_validate_The_Crashes_By_Os_Widget_Legends_Text_For_Android_With_Specifi_App_Version()throws EncryptedDocumentException, IOException
	{
		//select the OS
		crashesPage.selectOS(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "androidOS"));
		
		//select the app version
		crashesPage.selectAppVersion(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "androidAppVersion"));
		
		crashesPage.validateCrashByOsLegendsTextForAppVersion(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath, IPathConstant.mmLoadSheet, "osForAndroidAppVersion"));
	}
	
	@Test
	public void TC_045_validate_The_Crashes_By_Os_Widget_Legends_Text_For_Ios_OS()throws EncryptedDocumentException, IOException
	{
		//select the OS
		crashesPage.selectOS(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "IosOS"));
		
		//select the app version
		crashesPage.selectAppVersion(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "AllAppversions"));
		
		crashesPage.validateCrashByOsLegendsTextForIos(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath, IPathConstant.mmLoadSheet, "osType"));
	}
	
	@Test
	public void TC_046_validate_The_Crashes_By_Os_Widget_Legends_Text_For_Ios_With_Specifi_App_Version()throws EncryptedDocumentException, IOException
	{
		//select the OS
		crashesPage.selectOS(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "IosOS"));
		
		//select the app version
		crashesPage.selectAppVersion(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "IosAppVersion"));
		
		crashesPage.validateCrashByOsLegendsTextForAppVersion(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath, IPathConstant.mmLoadSheet, "osForIosAppVersion"));
		
		
	}
	
	@Test
	public void TC_047_validate_The_Crashes_By_Os_Widget_Legends()
	{
		crashesPage.validateCrashesByOswidgetLegends();
	}
	

	@Test
	public void TC_048_validateTheCrashesByAppVersionsWidgetTitle() throws EncryptedDocumentException, IOException
	{
		crashesPage.validateCrashesByAPPWidgetTitle(util.getvalueFromexcel(IPathConstant.MMexcelPath,IPathConstant.mmCrashesSheet, "crashByAppVersionWidgetTitle"));
	}
	
	@Test
	public void TC_049_validateTheCrashesByAppVersionsWidgetXaxisTitle() throws EncryptedDocumentException, IOException
	{
		crashesPage.validateCrashesByAPPXaxisTitle(util.getvalueFromexcel(IPathConstant.MMexcelPath,IPathConstant.mmCrashesSheet, "crashByAppVersionWidgetXAxisTitle"));
	}
	
	@Test
	public void TC_050_validateTheCrashesByAppVersionsWidgetYaxisTitle() throws EncryptedDocumentException, IOException
	{
		crashesPage.validateCrashesByAPPYaxisTitle(util.getvalueFromexcel(IPathConstant.MMexcelPath,IPathConstant.mmCrashesSheet, "crashByAppVersionWidgetYAxisTitle"));
	}
	
	@Test
	public void TC_051_validateTheCrashesByAppVersionsWidgetZoomIn()
	{
		crashesPage.validateTheCrashesByAPPwidgetZoomIn();
	}
	
	@Test
	public void TC_052_validateTheCrashesByAppVersionsWidgetZoomOut()
	{
		crashesPage.validateTheCrashesByAPPwidgetZoomOut();
	}
	
	@Test
	public void TC_053_validateTheCrashesByAppVersionsWidgetZoomReset()
	{
		crashesPage.validateTheCrashesByAPPwidgetZoomReset();
	}
	
	@Test
	public void TC_054_Validate_CrashesByAppVersions_widget_ToolTip_By_Hover() throws InterruptedException
	{
		crashesPage.validateCrashesByAPPWidgetToolTip();
	}
	
	@Test
	public void TC_055_validateTheCrashesByAppVersionsWidgetDragAndDropXaxis()
	{
		crashesPage.validateTheCrashesByAPPwidgetDragAndDrop();
	}
	
	@Test
	public void TC_056_validate_The_Crashes_By_App_Versions_Widget_Legends_Text_For_All_Os()throws EncryptedDocumentException, IOException
	{
		//select the OS
		crashesPage.selectOS(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "AllOS"));
		
		//select the app version
		crashesPage.selectAppVersion(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "AllAppversions"));
		
		crashesPage.validateCrashesByAppLegendsText(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath, IPathConstant.mmLoadSheet, "appVersionsForAndroid"),
											eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath, IPathConstant.mmLoadSheet, "appVersionsForIos"));
	}
	
	@Test
	public void TC_057_validate_The_Crashes_By_App_Versions_Widget_Legends_Text_For_Android_Os()throws EncryptedDocumentException, IOException
	{
		//select the OS
		crashesPage.selectOS(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "androidOS"));
		
		//select the app version
		crashesPage.selectAppVersion(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "AllAppversions"));
		
		crashesPage.validateCrashesByAppLegendsText(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath, IPathConstant.mmLoadSheet, "appVersionsForAndroid"));
	}
	
	
	@Test
	public void TC_058_validate_The_Crashes_By_App_Versions_Widget_Legends_Text_For_Android_With_Specific_App_Version()throws EncryptedDocumentException, IOException
	{
		//select the OS
		crashesPage.selectOS(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "androidOS"));
		
		//select the app version
		crashesPage.selectAppVersion(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "androidAppVersion"));
		
		crashesPage.validateCrashesByAppLegendsText(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath, IPathConstant.mmLoadSheet, "versionForAndroidAppVersion"));
	}
	
	@Test
	public void TC_059_validate_The_Crashes_By_App_Versions_Widget_Legends_Text_For_Ios_Os()throws EncryptedDocumentException, IOException
	{
		//select the OS
		crashesPage.selectOS(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "IosOS"));
		
		//select the app version
		crashesPage.selectAppVersion(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "AllAppversions"));
		
		crashesPage.validateCrashesByAppLegendsText(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath, IPathConstant.mmLoadSheet, "appVersionsForIos"));
	}
	
	@Test
	public void TC_060_validate_The_Crashes_By_App_Versions_Widget_Legends_Text_For_Ios_Os_With_Specific_App_Version()throws EncryptedDocumentException, IOException
	{
		//select the OS
		crashesPage.selectOS(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "IosOS"));
		
		//select the app version
		crashesPage.selectAppVersion(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "IosAppVersion"));
		
		crashesPage.validateCrashesByAppLegendsText(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath, IPathConstant.mmLoadSheet, "versionForIosAppVersion"));
	}
	
	@Test
	public void TC_061_validate_The_Crashes_By_App_Versions_Widget_Legends()
	{
		crashesPage.validateCrashesByAppwidgetLegends();
	}
	
	@Test
	public void TC_062_validate_The_Crashes_Widget_Data_By_Selecting_5Mins_TimeLine()
	{
		//select the time line from calander
		commPage.selectTheTimeLineFromCalender(IPathConstant.fiveMinutesTimeRange);

		//Validate whether the widgets are displaying the proper time line or not
		crashesPage.validateTheGivenTimeLine();
		
	}
	@Test
	public void TC_063_validate_The_Crashes_Widget_Data_By_Selecting_15Mins_TimeLine()
	{
		//select the time line from calander
		commPage.selectTheTimeLineFromCalender(IPathConstant.fifteenMinutesTimeRange);

		//Validate whether the widgets are displaying the proper time line or not
		crashesPage.validateTheGivenTimeLine();
		
	}
	
	@Test
	public void TC_064_validate_The_Crashes_Widget_Data_By_Selecting_30Mins_TimeLine()
	{
		//select the time line from calander
		commPage.selectTheTimeLineFromCalender(IPathConstant.thirtyMinutesTimeRange);
		
		//Validate whether the widgets are displaying the proper time line or not
		crashesPage.validateTheGivenTimeLine();
		
	}
	
	@Test
	public void TC_065_validate_The_Crashes_Widget_Data_By_Selecting_60Mins_TimeLine()
	{
		//select the time line from calander
		commPage.selectTheTimeLineFromCalender(IPathConstant.sixtyMinutesTimeRange);

		//Validate whether the widgets are displaying the proper time line or not
		crashesPage.validateTheGivenTimeLine();
		
	}
	
	@Test
	public void TC_066_validate_The_Crashes_Widget_Data_By_Selecting_3hours_TimeLine()
	{
		//select the time line from calander
		commPage.selectTheTimeLineFromCalender(IPathConstant.threeHoursTimeRange);

		//Validate whether the widgets are displaying the proper time line or not
		crashesPage.validateTheGivenTimeLine();
		
	}
	
	@Test
	public void TC_067_validate_The_Crashes_Widget_Data_By_Selecting_6hours_TimeLine()
	{
		//select the time line from calander
		commPage.selectTheTimeLineFromCalender(IPathConstant.sixHoursTimeRange);

		//Validate whether the widgets are displaying the proper time line or not
		crashesPage.validateTheGivenTimeLine();
	}
	
	@Test
	public void TC_068_validate_The_Crashes_Widget_Data_By_Selecting_12hours_TimeLine()
	{
		//select the time line from calander
		commPage.selectTheTimeLineFromCalender(IPathConstant.twelveHoursTimeRange);

		//Validate whether the widgets are displaying the proper time line or not
		crashesPage.validateTheGivenTimeLine();
	}
	
	@Test
	public void TC_069_validate_The_Crashes_Widget_Data_By_Selecting_1day_TimeLine()
	{
		//select the time line from calander
		commPage.selectTheTimeLineFromCalender(IPathConstant.oneDayTimeRange);

		//Validate whether the widgets are displaying the proper time line or not
		crashesPage.validateTheGivenTimeLine();
	}
	
	@Test
	public void TC_070_validate_The_Crashes_Widget_Data_By_Selecting_1week_TimeLine()
	{
		//select the time line from calander
		commPage.selectTheTimeLineFromCalender(IPathConstant.oneWeekTimeRange);

		//Validate whether the widgets are displaying the proper time line or not
		crashesPage.validateTheGivenTimeLine();
	}
	
	@Test
	public void TC_071_validate_The_Crashes_Widget_Data_By_Selecting_1month_TimeLine()
	{
		//select the time line from calander
		commPage.selectTheTimeLineFromCalender(IPathConstant.oneMonthTimeRange);

		//Validate whether the widgets are displaying the proper time line or not
		crashesPage.validateTheGivenTimeLine();
	}
	
	@Test
	public void TC_072_validate_The_Crashes_Widget_By_selecting_custom_Time_For_Minutes_Range() throws EncryptedDocumentException, IOException
	{
		//select the time line from calander
		commPage.selectTheCustomeTimeLine(IPathConstant.customTimeRange, eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customMinutesRange") );
		
		crashesPage.validateTheCustomTimeLine(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customMinutesRange"));
		
	}
	
	
	@Test
	public void TC_073_validate_The_Crashes_Widget_By_selecting_custom_Time_For_Hours_Range() throws EncryptedDocumentException, IOException
	{
		//select the time line from calander
		commPage.selectTheCustomeTimeLine(IPathConstant.customTimeRange, eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customHoursRange"));
		
		crashesPage.validateTheCustomTimeLine(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customHoursRange"));
		
	}
	
	@Test
	public void TC_074_validate_The_Crashes_Widget_By_selecting_custom_Time_For_Days_Range() throws EncryptedDocumentException, IOException
	{

		//select the time line from calander
		commPage.selectTheCustomeTimeLine(IPathConstant.customTimeRange, eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customDaysRange"));
		
		crashesPage.validateTheCustomTimeLine(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customDaysRange"));
		
	}
	
	@Test
	public void TC_075_validate_The_Crashes_Widget_By_selecting_custom_Time_For_Future_date()
	{
		//select the future time line from calander
		commPage.validateTheFutureTimeLine();
		
	}
	
	@Test
	public void TC_076_validate_The_Crash_Information_Table_Title()throws EncryptedDocumentException, IOException
	{
		crashesPage.validateTheCrashInfoTitle(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath, IPathConstant.mmCrashesSheet, "crashInformationTableTitle"));
	}
	
	@Test
	public void TC_077_validate_The_Crash_Information_Table_Header()throws EncryptedDocumentException, IOException
	{
		crashesPage.validateCrashInfoTableHeader(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath, IPathConstant.mmCrashesSheet, "crashInformationTableHeaderValues"));
	}
	
	@Test
	public void TC_078_validate_Crash_Info_Table_DownLoad_Report_Button_Active()
	{
		crashesPage.validateWhetherTheDownloadReportButtonIsActive();
	}
	
	@Test
	public void TC_079_validate_The_Crash_Information_Table_Download_Report_Button() throws EncryptedDocumentException, IOException
	{
		crashesPage.validateDownloadReportButton();
	}
	
	@Test
	public void TC_080_validate_The_Crash_Information_Table_View_All_Button()
	{
		crashesPage.validateCrashInfoViewAllBtn();
	}
	
	@Test
	public void TC_081_validate_The_Crash_Information_Page_column_Headers() throws EncryptedDocumentException, IOException
	{
		crashesPage.validateCrashInfoViewAllBtn();
		
		crashesPage.validateTheCrashInfoPageHeaders(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath, IPathConstant.mmCrashesSheet, "crashInformationPageHeaderValues"));
	}
	
	@Test
	public void TC_082_validate_Crash_Info_Page_DownLoad_Report_Button_Active()
	{
		crashesPage.validateCrashInfoViewAllBtn();
		
		crashesPage.validateWhetherTheDownloadReportButtonIsActive();
	}
	
	@Test
	public void TC_083_validate_The_Crash_Information_Page_Download_Report_Button() throws EncryptedDocumentException, IOException
	{
		crashesPage.validateCrashInfoViewAllBtn();
		
		crashesPage.validateDownloadReportButton();
	}
	
	@Test
	public void TC_084_validate_The_Crash_Information_Page_Search_Function_With_Valid_Data()
	{
		crashesPage.validateCrashInfoViewAllBtn();
		
		crashesPage.validateCrashInfoPageSearchWithValidData();
	}
	
	
	@Test
	public void TC_085_validate_The_Crash_Information_Page_Search_Function_With_InValid_Data()
	{
		crashesPage.validateCrashInfoViewAllBtn();
		
		crashesPage.validateCrashInfoPageSearchWithInValidData();
	}
	
	@Test (dataProvider = "pagination", groups = {"MM","UI","Regression"})
	public void TC_086_validate_The_Crash_Information_Page_Paginations(String num) {
		crashesPage.validateCrashInfoViewAllBtn();
		
		crashesPage.validatePagination(Integer.parseInt(num));
	}
	
	@Test
	public void TC_087_validate_The_Top_Locations_Table_Title() throws EncryptedDocumentException, IOException
	{
		crashesPage.validateTopLocationTableTitle(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath, IPathConstant.mmCrashesSheet, "TopLocationTableTitle"));
	}
	
	@Test
	public void TC_088_validate_The_Top_Locations_Table_Headers() throws EncryptedDocumentException, IOException
	{
		crashesPage.validateTopLocationTableHeaders(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath, IPathConstant.mmCrashesSheet, "topLocationsTableHeaderValues"));
	}
	
	@Test
	public void TC_089_validate_The_Top_Locations_Table_ViewAll_Button()
	{
		crashesPage.validateViewAllBtnOfTopLocationTable();
	}
	
	
	@Test
	public void TC_090_validate_The_Top_Locations_Page_Column_Headers() throws EncryptedDocumentException, IOException
	{
		crashesPage.validateViewAllBtnOfTopLocationTable();
		
		crashesPage.validateTopLocationPageHeaders(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath, IPathConstant.mmCrashesSheet, "topLocationPageHeaerValues"));
	}
	
	@Test (dataProvider = "pagination", groups = {"MM","UI","Regression"})
	public void TC_091_validate_The_Top_Locations_Page_Paginations(String num) {
		crashesPage.validateViewAllBtnOfTopLocationTable();
		
		crashesPage.validatePagination(Integer.parseInt(num));
	}
	
	@Test
	public void TC_092_validate_The_Crashes_Graph_For_All_OS() throws EncryptedDocumentException, IOException 
	{
		String expectedCrashes = eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "crashesForAndroid")+","+eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "crashesForIos");
		crashesPage.validateCrashesGraphValue(expectedCrashes.split(",").length);
	}
	
	@Test
	public void TC_093_validate_The_Crashes_Graph_For_Android_OS() throws EncryptedDocumentException, IOException 
	{
		//select the OS
		crashesPage.selectOS(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "androidOS"));
		
		//select the app version
		crashesPage.selectAppVersion(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "AllAppversions"));
		
		String expectedCrashes = eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "crashesForAndroid");
		crashesPage.validateCrashesGraphValue(expectedCrashes.split(",").length);
	}
	
	@Test
	public void TC_094_validate_The_Crashes_Graph_For_Android_With_Specific_App_versions() throws EncryptedDocumentException, IOException 
	{
		//select the OS
		crashesPage.selectOS(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "androidOS"));
		
		//select the app version
		crashesPage.selectAppVersion(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "androidAppVersion"));
		

		String expectedCrashes = eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "crashesForAndroidAppVersion");
		crashesPage.validateCrashesGraphValue(Integer.parseInt(expectedCrashes));
	}
	
	@Test
	public void TC_095_validate_The_Crashes_Graph_For_Ios_OS() throws EncryptedDocumentException, IOException 
	{
		//select the OS
		crashesPage.selectOS(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "IosOS"));
		
		//select the app version
		crashesPage.selectAppVersion(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "AllAppversions"));
		
		String expectedCrashes = eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "crashesForIos");
		crashesPage.validateCrashesGraphValue(expectedCrashes.split(",").length);
	}
	
	@Test
	public void TC_096_validate_The_Crashes_Graph_For_Ios_With_Specific_App_versions() throws EncryptedDocumentException, IOException 
	{
		//select the OS
		crashesPage.selectOS(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "IosOS"));
		
		//select the app version
		crashesPage.selectAppVersion(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "IosAppVersion"));
		
		String expectedCrashes = eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "crashesForIosAppVersion");
		crashesPage.validateCrashesGraphValue(Integer.parseInt(expectedCrashes));
	}
	
	@Test
	public void TC_097_validate_The_Crash_Affected_Users_Graph_For_All_OS() throws EncryptedDocumentException, IOException 
	{
		int expectedCrashes = Integer.parseInt(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "crashEffectedUsersForAndroid"))+Integer.parseInt(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "crashEffectedUsersForIos"));
		crashesPage.validateCrashEffectedUsersGraphValue(expectedCrashes);
	}
	
	@Test
	public void TC_098_validate_The_Crash_Affected_Users_Graph_For_Android_OS() throws EncryptedDocumentException, IOException 
	{
		//select the OS
		crashesPage.selectOS(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "androidOS"));
		
		//select the app version
		crashesPage.selectAppVersion(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "AllAppversions"));
		
		int expectedCrashes = Integer.parseInt(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "crashEffectedUsersForAndroid"));
		crashesPage.validateCrashEffectedUsersGraphValue(expectedCrashes);
	}
	
	@Test
	public void TC_099_validate_The_Crash_Affected_Users_Graph_For_Android_With_Specific_App_versions() throws EncryptedDocumentException, IOException 
	{
		//select the OS
		crashesPage.selectOS(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "androidOS"));
		
		//select the app version
		crashesPage.selectAppVersion(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "androidAppVersion"));
		
		int expectedCrashes = Integer.parseInt(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "crasheEffectedUsersForAndroidAppVersion"));
		crashesPage.validateCrashEffectedUsersGraphValue(expectedCrashes);
	}
	
	@Test
	public void TC_100_validate_The_Crash_Affected_Users_Graph_For_Ios_OS() throws EncryptedDocumentException, IOException 
	{
		//select the OS
		crashesPage.selectOS(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "IosOS"));
		
		//select the app version
		crashesPage.selectAppVersion(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "AllAppversions"));
		
		int expectedCrashes = Integer.parseInt(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "crashEffectedUsersForIos"));
		crashesPage.validateCrashEffectedUsersGraphValue(expectedCrashes);
	}
	
	@Test
	public void TC_101_validate_The_Crash_Affected_Users_Graph_For_Ios_With_Specific_App_versions() throws EncryptedDocumentException, IOException 
	{
		//select the OS
		crashesPage.selectOS(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "IosOS"));
		
		//select the app version
		crashesPage.selectAppVersion(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "IosAppVersion"));
		
		String expectedCrashes = eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "crasheEffectedUsersForIosAppVersion");
		crashesPage.validateCrashEffectedUsersGraphValue(Integer.parseInt(expectedCrashes));
	}
	
	@Test
	public void TC_102_validate_The_Crashes_By_OS_Graph_For_All_OS() throws EncryptedDocumentException, IOException 
	{
		String expectedCrashes = eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "crashesForAndroid")+","+eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "crashesForIos");
		crashesPage.validateCrashByOsGraphValue(expectedCrashes.split(",").length);
	}
	
	@Test
	public void TC_103_validate_The_Crashes_By_OS_Graph_For_Android_OS() throws EncryptedDocumentException, IOException 
	{
		//select the OS
		crashesPage.selectOS(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "androidOS"));
		
		//select the app version
		crashesPage.selectAppVersion(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "AllAppversions"));
		
		String expectedCrashes = eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "crashesForAndroid");
		crashesPage.validateCrashByOsGraphValue(expectedCrashes.split(",").length);
	}
	
	@Test
	public void TC_104_validate_The_Crashes_By_OS_Graph_For_Android_With_Specific_App_versions() throws EncryptedDocumentException, IOException 
	{
		//select the OS
		crashesPage.selectOS(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "androidOS"));
		
		//select the app version
		crashesPage.selectAppVersion(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "androidAppVersion"));
		
		String expectedCrashes = eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "crashesForAndroidAppVersion");
		crashesPage.validateCrashByOsGraphValue(Integer.parseInt(expectedCrashes));
	}
	
	@Test
	public void TC_105_validate_The_Crashes_By_OS_Graph_For_Ios_OS() throws EncryptedDocumentException, IOException 
	{
		//select the OS
		crashesPage.selectOS(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "IosOS"));
		
		//select the app version
		crashesPage.selectAppVersion(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "AllAppversions"));
		
		String expectedCrashes = eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "crashesForIos");
		crashesPage.validateCrashByOsGraphValue(expectedCrashes.split(",").length);
	}
	
	@Test
	public void TC_106_validate_The_Crashes_By_OS_Graph_For_Ios_With_Specific_App_versions() throws EncryptedDocumentException, IOException 
	{
		//select the OS
		crashesPage.selectOS(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "IosOS"));
		
		//select the app version
		crashesPage.selectAppVersion(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "IosAppVersion"));
		
		String expectedCrashes = eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "crashesForIosAppVersion");
		crashesPage.validateCrashByOsGraphValue(Integer.parseInt(expectedCrashes));
	}
	
	@Test
	public void TC_107_validate_The_Crashes_By_Device_Graph_For_All_OS() throws EncryptedDocumentException, IOException 
	{
		String expectedCrashes = eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "crashesForAndroid")+","+eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "crashesForIos");
		crashesPage.validateCrashesByDeviceGraphValue(expectedCrashes.split(",").length-2);	
	}
	
	@Test
	public void TC_108_validate_The_Crashes_By_Device_Graph_For_Android_OS() throws EncryptedDocumentException, IOException 
	{
		//select the OS
		crashesPage.selectOS(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "androidOS"));
		
		//select the app version
		crashesPage.selectAppVersion(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "AllAppversions"));
		
		String expectedCrashes = eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "crashesForAndroid");
		crashesPage.validateCrashesByDeviceGraphValue(expectedCrashes.split(",").length);	
	}
	
	@Test
	public void TC_109_validate_The_Crashes_By_Device_Graph_For_Android_With_Specific_App_versions() throws EncryptedDocumentException, IOException 
	{
		//select the OS
		crashesPage.selectOS(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "androidOS"));
		
		//select the app version
		crashesPage.selectAppVersion(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "androidAppVersion"));
		
		String expectedCrashes = eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "crashesForAndroidAppVersion");
		crashesPage.validateCrashesByDeviceGraphValue(Integer.parseInt(expectedCrashes));
	}
	
	@Test
	public void TC_110_validate_The_Crashes_By_Device_Graph_For_Ios_OS() throws EncryptedDocumentException, IOException 
	{
		//select the OS
		crashesPage.selectOS(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "IosOS"));
		
		//select the app version
		crashesPage.selectAppVersion(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "AllAppversions"));
		
		String expectedCrashes = eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "crashesForIos");
		crashesPage.validateCrashesByDeviceGraphValue(expectedCrashes.split(",").length);	
	}
	
	@Test
	public void TC_111_validate_The_Crashes_By_Device_Graph_For_Ios_With_Specific_App_versions() throws EncryptedDocumentException, IOException 
	{
		//select the OS
		crashesPage.selectOS(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "IosOS"));
		
		//select the app version
		crashesPage.selectAppVersion(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "IosAppVersion"));
		
		String expectedCrashes = eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "crashesForIosAppVersion");
		crashesPage.validateCrashesByDeviceGraphValue(Integer.parseInt(expectedCrashes));
	}
	
	@Test
	public void TC_112_validate_The_Crashes_By_App_versions_Graph_For_All_OS() throws EncryptedDocumentException, IOException 
	{

		String expectedCrashes = eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "crashesForAndroid")+","+eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "crashesForIos");
		crashesPage.validateCrashesByAppVersionGraphValue(expectedCrashes.split(",").length-2);
	}
	
	@Test
	public void TC_113_validate_The_Crashes_By_App_versions_Graph_For_Android_OS() throws EncryptedDocumentException, IOException 
	{
		//select the OS
		crashesPage.selectOS(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "androidOS"));
		
		//select the app version
		crashesPage.selectAppVersion(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "AllAppversions"));
		
		String expectedCrashes = eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "crashesForAndroid");
		crashesPage.validateCrashesByAppVersionGraphValue(expectedCrashes.split(",").length);
	}
	
	@Test
	public void TC_114_validate_The_Crashes_By_App_versions_Graph_For_Android_With_Specific_App_versions() throws EncryptedDocumentException, IOException 
	{
		//select the OS
		crashesPage.selectOS(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "androidOS"));
		
		//select the app version
		crashesPage.selectAppVersion(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "androidAppVersion"));
		
		String expectedCrashes = eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "crashesForAndroidAppVersion");
		crashesPage.validateCrashesByAppVersionGraphValue(Integer.parseInt(expectedCrashes));
	}
	
	@Test
	public void TC_115_validate_The_Crashes_By_App_versions_Graph_For_Ios_OS() throws EncryptedDocumentException, IOException 
	{
		//select the OS
		crashesPage.selectOS(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "IosOS"));
		
		//select the app version
		crashesPage.selectAppVersion(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "AllAppversions"));
		
		String expectedCrashes = eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "crashesForIos");
		crashesPage.validateCrashesByAppVersionGraphValue(expectedCrashes.split(",").length);
	}
	
	@Test
	public void TC_116_validate_The_Crashes_By_App_versions_Graph_For_Ios_With_Specific_App_versions() throws EncryptedDocumentException, IOException 
	{
		//select the OS
		crashesPage.selectOS(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "IosOS"));
		
		//select the app version
		crashesPage.selectAppVersion(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "IosAppVersion"));
		
		String expectedCrashes = eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "crashesForIosAppVersion");
		crashesPage.validateCrashesByAppVersionGraphValue(Integer.parseInt(expectedCrashes));
	}
	
	@Test
	public void TC_117_validate_The_Crash_Information_Table_For_All_OS() throws EncryptedDocumentException, IOException
	{
		String expectedCrashes = eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "crashesForAndroid")+","+eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "crashesForIos");
		String lastOccurred = eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "LastOccurred");
		String noOfEffectedUsers = eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "crashInfoTableNo.ofEffectedUsers");
		String crashEvents = eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "crasheEvents");
		crashesPage.validateCrashInfoTableData(expectedCrashes,crashEvents,noOfEffectedUsers,lastOccurred);
	}
	
	@Test
	public void TC_118_validate_The_Crash_Information_Table_For_Android_OS() throws EncryptedDocumentException, IOException
	{
		//select the OS
		crashesPage.selectOS(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "androidOS"));
		
		//select the app version
		crashesPage.selectAppVersion(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "AllAppversions"));
		
		String expectedCrashes = eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "crashesForAndroid");
		String lastOccurred = eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "LastOccurred");
		String noOfEffectedUsers = eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "crashInfoTableNo.ofEffectedUsers");
		String crashEvents = eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "crasheEvents");
		crashesPage.validateCrashInfoTableData(expectedCrashes,crashEvents,noOfEffectedUsers,lastOccurred);
	}
	
	@Test
	public void TC_119_validate_The_Crash_Information_Table_For_Android_With_Specific_App_Version() throws EncryptedDocumentException, IOException
	{
		//select the OS
		crashesPage.selectOS(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "androidOS"));
		
		//select the app version
		crashesPage.selectAppVersion(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "androidAppVersion"));
		
		String expectedCrashes = eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "crashNameForAndroidAppVersion");
		String lastOccurred = eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "LastOccurred");
		String noOfEffectedUsers = eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "crashInfoTableNo.ofEffectedUsers");
		String crashEvents = eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "crasheEvents");
		crashesPage.validateCrashInfoTableData(expectedCrashes,crashEvents,noOfEffectedUsers,lastOccurred);
	}
	
	@Test
	public void TC_120_validate_The_Crash_Information_Table_For_Ios_OS() throws EncryptedDocumentException, IOException
	{
		//select the OS
		crashesPage.selectOS(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "IosOS"));
		
		//select the app version
		crashesPage.selectAppVersion(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "AllAppversions"));
		
		String expectedCrashes = eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "crashesForIos");
		String lastOccurred = eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "LastOccurred");
		String noOfEffectedUsers = eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "crashInfoTableNo.ofEffectedUsers");
		String crashEvents = eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "crasheEvents");
		crashesPage.validateCrashInfoTableData(expectedCrashes,crashEvents,noOfEffectedUsers,lastOccurred);
	}
	
	
	@Test
	public void TC_121_validate_The_Crash_Information_Table_For_Ios_With_Specific_App_Version() throws EncryptedDocumentException, IOException
	{
		//select the OS
		crashesPage.selectOS(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "IosOS"));
		
		//select the app version
		crashesPage.selectAppVersion(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "IosAppVersion"));
		

		crashesPage.validateCrashInfoTableDataWithOutData();
	}
	
	@Test
	public void TC_122_validate_The_Crash_Info_Table_Crash_Name_Tooltip_By_Hover_On_Crash_Name()
	{
		crashesPage.validateCrashNameToolTip();
	}
	
	@Test
	public void TC_123_validate_The_Crash_Info_Table_View_Crashes_Tooltip_By_Hover_On_Icon()	
	{
		crashesPage.validateViewCrashesTooltip();
	}
	
	@Test
	public void TC_124_Validate_The_Crash_Events_Page_By_Clicking_Crash_Name_on_Crash_Info_Table()
	{
		crashesPage.clickOnCrashName();
		
		crashesPage.validateCrashEventsPage();
	}
	
	@Test
	public void TC_125_validate_The_Crash_Events_Page_By_Clicking_Last_Occurred_on_Crash_Info_Table()
	{
		crashesPage.clickOnLastOccurred();
		
		crashesPage.validateCrashEventsPage();
	}
	
	@Test
	public void TC_126_validate_The_Crash_Events_Page_By_Clicking_Crash_Events_Icon_on_Crash_Info_Table()
	{
		crashesPage.clickOnCrashEventIcon();
		
		crashesPage.validateCrashEventsPage();
	}
	
	@Test
	public void TC_127_validate_The_Crash_Events_Page_By_Clicking_No_of_Effected_Users_on_Crash_Info_Table()
	{
		crashesPage.clickOnNoOfEffectedusersIcon();
		
		crashesPage.validateCrashEventsPage();
	}
	
	@Test
	public void TC_128_Validate_The_Crash_Info_Page_Contains_Crash_Info_Table_Data()
	{
		crashesPage.crashInfoPageDataWithTable();
		
	}
	
	@Test
	public void TC_129_validate_The_Crash_Names_Of_Crash_Info_page_For_All_OS() throws EncryptedDocumentException, IOException
	{
		
		crashesPage.validateCrashInfoViewAllBtn();
		
		//select the OS
		crashesPage.selectOS(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "AllOS"));
		
		//select the app version
		crashesPage.selectAppVersion(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "AllAppversions"));
		
		String expectedCrashes = eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "crashesForAndroid")+","+eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "crashesForIos");
		crashesPage.validateTheCrashNameOfCrashInfoPage(expectedCrashes);
	}
	
	@Test
	public void TC_130_validate_The_Crash_Names_Of_Crash_Info_page_For_Android_OS() throws EncryptedDocumentException, IOException
	{
		
		crashesPage.validateCrashInfoViewAllBtn();
		
		//select the OS
		crashesPage.selectOS(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "androidOS"));
		
		//select the app version
		crashesPage.selectAppVersion(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "AllAppversions"));
		
		String expectedCrashes = eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "crashesForAndroid");
		crashesPage.validateTheCrashNameOfCrashInfoPage(expectedCrashes);
	}
	
	@Test
	public void TC_131_validate_The_Crash_Names_Of_Crash_Info_page_For_Android_With_Specific_AppVersion() throws EncryptedDocumentException, IOException
	{
		
		crashesPage.validateCrashInfoViewAllBtn();
		
		//select the OS
		crashesPage.selectOS(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "androidOS"));
		
		//select the app version
		crashesPage.selectAppVersion(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "androidAppVersion"));
		
		String expectedCrashes = eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "crashNameForAndroidAppVersion");

		crashesPage.validateTheCrashNameOfCrashInfoPage(expectedCrashes);
	}
	
	@Test
	public void TC_132_validate_The_Crash_Names_Of_Crash_Info_page_For_Ios_OS() throws EncryptedDocumentException, IOException
	{
		
		crashesPage.validateCrashInfoViewAllBtn();
		
		//select the OS
		crashesPage.selectOS(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "IosOS"));
		
		//select the app version
		crashesPage.selectAppVersion(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "AllAppversions"));
		
		String expectedCrashes = eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "crashesForIos");
		crashesPage.validateTheCrashNameOfCrashInfoPage(expectedCrashes);
	}
	
	@Test
	public void TC_133_validate_The_Crash_Names_Of_Crash_Info_page_For_Ios_With_Specific_AppVerion() throws EncryptedDocumentException, IOException
	{
		
		crashesPage.validateCrashInfoViewAllBtn();
		
		//select the OS
		crashesPage.selectOS(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "IosOS"));
		
		//select the app version
		crashesPage.selectAppVersion(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "IosAppVersion"));
		

		crashesPage.validateCrashInfoTableDataWithOutData();
	}
	
	@Test
	public void TC_134_validate_Crash_Info_Page_Last_Occured_Column_Asending_Order_Icon()
	{
		
		crashesPage.validateCrashInfoViewAllBtn();

		crashesPage.validateTheAscendingOrderOfLastOccurredColumn();
	}
	
	@Test
	public void TC_135_validate_Crash_Info_Page_Last_Occured_Column_descending_Order_Icon()
	{
		crashesPage.validateCrashInfoViewAllBtn();
		
		crashesPage.validateTheDescendingOrderOfLastOccurredColumn();
	}
	
	@Test
	public void TC_136_validate_The_Crash_Info_Page_Crash_Name_Tooltip_By_Hover_On_Crash_Name()
	{
		crashesPage.validateCrashInfoViewAllBtn();
		
		crashesPage.validateCrashInfoPageCrashNameToolTip();
	}
	
	@Test
	public void TC_137_validate_The_Crash_Info_Page_View_Crashes_Tooltip_By_Hover_On_Icon()
	{
		crashesPage.validateCrashInfoViewAllBtn();
		
		crashesPage.validateCrashInfoPageViewCrashesTooltip();
	}
	
	@Test
	public void TC_138_Validate_The_Crash_Events_Page_By_Clicking_Crash_Name_on_Crash_Info_page()
	{
		crashesPage.validateCrashInfoViewAllBtn();
		
		crashesPage.clickOnCrashNameOfCrashInfoPage();
		
		crashesPage.validateCrashEventsPage();
	}
	
	@Test
	public void TC_139_validate_The_Crash_Events_Page_By_Clicking_Last_Occurred_on_Crash_Info_page()
	{
		crashesPage.validateCrashInfoViewAllBtn();
		
		crashesPage.clickOnLastOccurredOfCrashInfoPage();
		
		crashesPage.validateCrashEventsPage();
	}
	
	@Test
	public void TC_140_validate_The_Crash_Events_Page_By_Clicking_Crash_Events_Icon_on_Crash_Info_page()
	{
		crashesPage.validateCrashInfoViewAllBtn();
		
		crashesPage.clickOnCrashEventIconOfCrashInfoPage();
		
		crashesPage.validateCrashEventsPage();
	}
	
	@Test
	public void TC_141_validate_The_Crash_Events_Page_By_Clicking_No_of_Effected_Users_on_Crash_Info_page()
	{
		crashesPage.validateCrashInfoViewAllBtn();
		
		crashesPage.clickOnNoOfEffectedusersIconOfCrashInfoPage();
		
		crashesPage.validateCrashEventsPage();
	}
	
	@Test
	public void TC_142_validate_The_Crash_Events_page_Download_Report_Button() throws EncryptedDocumentException, IOException
	{
		crashesPage.clickOnCrashName();
		
		crashesPage.validateDownloadReportButton();
		
	}
	
	@Test
	public void TC_143_validate_The_Crash_Events_Page_Search_Functionality_With_Valid_Data()
	{
		crashesPage.clickOnCrashName();
		
		crashesPage.validateCrashEventsPageSearchWithValidData();
	}
	
	@Test
	public void TC_144_validate_The_Crash_Events_Page_Search_Functionality_With_InValid_Data()
	{
		crashesPage.clickOnCrashName();
		
		crashesPage.validateCrashEventsPageSearchWithInValidData();
	}
	
	@Test
	public void TC_145_Validate_The_Crash_Events_Page_Table_Headers() throws EncryptedDocumentException, IOException
	{
		crashesPage.clickOnCrashName();
		
		crashesPage.validateCrashEventsPageHeaders(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmCrashesSheet, "crashEventsPageHeaderValues"));
		
	}
	
	@Test (dataProvider = "pagination", groups = {"MM","UI","Regression"})
	public void TC_146_validate_The_Crash_Events_Page_paginations(String num) {
		
		crashesPage.clickOnCrashName();
		
		crashesPage.validatePagination(Integer.parseInt(num));
	}
	
	@Test
	public void TC_147_validate_The_Crash_Events_Page_Data_For_All_OS() throws EncryptedDocumentException, IOException
	{
		
		
		crashesPage.clickOnCrashName();
		String userId = eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "IOSUserId2");
		String device = eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "devicesForIos");
		String osVersion = eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "IOSPlatform");
		String appversion =  eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "appVersionsForIos");
		crashesPage.validateTheCrashEventsPageData(userId,device,osVersion,appversion);
		
	}
	
	@Test
	public void TC_148_validate_The_Crash_Events_Page_Data_For_Android_OS() throws EncryptedDocumentException, IOException
	{
		crashesPage.clickOnCrashName();
		
		//select the OS
		crashesPage.selectOS(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "androidOS"));
		
		//select the app version
		crashesPage.selectAppVersion(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "AllAppversions"));

		crashesPage.validateTheCrashEventsPageDataWhenNoData();
	}
	
	@Test
	public void TC_149_validate_The_Crash_Events_Page_Data_For_Android_With_Specific_App_Version() throws EncryptedDocumentException, IOException
	{
		crashesPage.clickOnCrashName();
		
		//select the OS
		crashesPage.selectOS(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "androidOS"));
		
		//select the app version
		crashesPage.selectAppVersion(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "androidAppVersion"));
		
		crashesPage.validateTheCrashEventsPageDataWhenNoData();
	}
	
	@Test
	public void TC_150_validate_The_Crash_Events_Page_Data_For_Ios_OS() throws EncryptedDocumentException, IOException
	{
		
		crashesPage.clickOnCrashName();
		
		//select the OS
		crashesPage.selectOS(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "IosOS"));
		
		//select the app version
		crashesPage.selectAppVersion(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "AllAppversions"));
		
		
		String userId = eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "IOSUserId2");
		String device = eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "devicesForIos");
		String osVersion = eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "IOSPlatform");
		String appversion =  eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "appVersionsForIos");
		crashesPage.validateTheCrashEventsPageData(userId,device,osVersion,appversion);
	}
	
	@Test
	public void TC_151_validate_The_Crash_Events_Page_Data_For_Ios_With_Specific_App_Version() throws EncryptedDocumentException, IOException
	{
		
		crashesPage.clickOnCrashName();
		
		//select the OS
		crashesPage.selectOS(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "IosOS"));
		
		//select the app version
		crashesPage.selectAppVersion(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "IosAppVersion"));
		
		crashesPage.validateTheCrashEventsPageDataWhenNoData();
	}
	
	@Test
	public void TC_152_validate_The_Events_Details_Page_By_Clicking_On_The_Crash_ID()
	{
		
		crashesPage.clickOnCrashName();
		
		crashesPage.clickOnTheCrashID();
		
		crashesPage.validateEventsDetailsPage();
	}
	
	@Test
	public void TC_153_validate_The_Events_Details_Page_By_Clicking_On_The_User_ID()
	{
		
		crashesPage.clickOnCrashName();
		
		crashesPage.clickOnTheUserID();
		
		crashesPage.validateEventsDetailsPage();
	}
	

	@Test
	public void TC_154_validate_The_Events_Details_Page_By_Clicking_On_The_Device()
	{
		
		crashesPage.clickOnCrashName();
		
		crashesPage.clickOnTheDevice();
		
		crashesPage.validateEventsDetailsPage();
	}
	

	@Test
	public void TC_155_validate_The_Events_Details_Page_By_Clicking_On_The_Os_veriosn()
	{
		
		crashesPage.clickOnCrashName();
		
		crashesPage.clickOnTheOsVersion();
		
		crashesPage.validateEventsDetailsPage();
	}
	

	@Test
	public void TC_156_validate_The_Events_Details_Page_By_Clicking_On_The_AppVeriosn()
	{
		
		crashesPage.clickOnCrashName();
		
		crashesPage.clickOnTheAppVersion();
		
		crashesPage.validateEventsDetailsPage();
	}
	
	@Test
	public void TC_157_validate_The_Event_Details_Page_By_Clicking_On_The_Date_Time()
	{
		
		crashesPage.clickOnCrashName();
		
		crashesPage.clickOnTheDateAndTime();
		
		crashesPage.validateEventsDetailsPage();
	}
	
	@Test
	public void TC_158_validate_The_Event_Details_Page_Text() throws EncryptedDocumentException, IOException
	{
		
		crashesPage.clickOnCrashName();
		
		crashesPage.clickOnTheCrashID();
		
		crashesPage.validateEventDetailsPageKeys(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmCrashesSheet, "eventDetailsPageValues"));
	}
	
	@Test
	public void TC_159_validate_The_Event_Details_Page_Data() throws EncryptedDocumentException, IOException
	{
		
		
		crashesPage.clickOnCrashName();
		
		crashesPage.clickOnTheCrashID();
		
		String application = eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmCrashesSheet, "application");
		String message = eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "crashesForIos");
		String appversion = eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "appVersionsForIos");
		String occuranceTime =  eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "LastOccurred");
		String memoryUsage = eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "memoryUsageforIos");
		
		crashesPage.validateEventDetails(application,message,appversion,occuranceTime,memoryUsage);
	}
	
	@Test
	public void TC_160_validate_The_Event_Details_Page_StackTrace() throws EncryptedDocumentException, IOException
	{
		
		
		crashesPage.clickOnCrashName();
		
		crashesPage.clickOnTheCrashID();
		
		String stackTrace = eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "stackTrace");
		
		crashesPage.validateEventDetailsPageStackTrace(stackTrace);
	}
	
	@Test
	public void TC_161_validate_The_Event_Details_Page_Download_Report_Button() throws EncryptedDocumentException, IOException
	{
		crashesPage.clickOnCrashName();
		
		crashesPage.clickOnTheCrashID();
		
		crashesPage.validateDownloadReportButton();
	}
	
	@Test
	public void TC_162_validate_The_Event_Details_Page_Download_Trace_Button() throws EncryptedDocumentException, IOException
	{
		
		crashesPage.clickOnCrashName();
		
		crashesPage.clickOnTheCrashID();
		
		crashesPage.validateDownloadTraceBtn();
	}
	
	@Test
	public void TC_163_validate_The_Event_Details_Page_Copy_Trace_Button() throws EncryptedDocumentException, IOException
	{
		
		crashesPage.clickOnCrashName();
		
		crashesPage.clickOnTheCrashID();
		
		//validate the copy icon
		crashesPage.validateTheCopyBtn(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath, IPathConstant.messageSheet, "CopyConfirmationMessgae"));

	}
	
	@Test
	public void TC_164_validate_The_Back_Button_Of_Event_Details_Page()
	{
		crashesPage.clickOnCrashName();
		
		crashesPage.clickOnTheCrashID();
		
		crashesPage.validateBackBtnOfEventDatailsPage();
	}
	
	@Test
	public void TC_165_validate_The_Back_Button_Of_Crash_Events_Page()
	{
		crashesPage.clickOnCrashName();
		
		crashesPage.validateBackBtnOfCrashEventsPage();
	}
	
	@Test
	public void TC_166_validate_The_Back_Button_Of_Crash_Info_Page()
	{
		crashesPage.validateCrashInfoViewAllBtn();
		
		crashesPage.validateTheBackBtnOfCrashInfoPage();
	}
	
	@Test
	public void TC_167_validate_The_Top_Location_Table_Data_By_Selecting_All_OS() throws EncryptedDocumentException, IOException
	{
		String countriesList = eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "TopLocationsForAll");
		String noOfCrashes = eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "No.ofCrashesForTopLocationTable");
		String noOfEffectedUsers = eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "crashInfoTableNo.ofEffectedUsers");
		crashesPage.validateTopLocationsTable(countriesList,noOfCrashes,noOfEffectedUsers);
	}
	
	
	@Test
	public void TC_168_validate_The_Top_Location_Table_Data_By_Selecting_Android_OS() throws EncryptedDocumentException, IOException
	{
		
		//select the OS
		crashesPage.selectOS(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "androidOS"));
		
		//select the app version
		crashesPage.selectAppVersion(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "AllAppversions"));
		
		String countriesList = eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "TopLocationsForAndroid");
		String noOfCrashes = eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "No.ofCrashesForTopLocationTable");
		String noOfEffectedUsers = eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "crashInfoTableNo.ofEffectedUsers");
		crashesPage.validateTopLocationsTable(countriesList,noOfCrashes,noOfEffectedUsers);
	}
	
	
	@Test
	public void TC_169_validate_The_Top_Location_Table_Data_By_Selecting_Android_OS_With_Specific_App_version() throws EncryptedDocumentException, IOException
	{
		//select the OS
		crashesPage.selectOS(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "androidOS"));
		
		//select the app version
		crashesPage.selectAppVersion(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "androidAppVersion"));
		
		String countriesList = eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "CountryForAndroidAppVersion");
		String noOfCrashes = eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "No.ofCrashesForTopLocationTable");
		String noOfEffectedUsers = eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "crashInfoTableNo.ofEffectedUsers");
		crashesPage.validateTopLocationsTable(countriesList,noOfCrashes,noOfEffectedUsers);
	}
	
	
	@Test
	public void TC_170_validate_The_Top_Location_Table_Data_By_Selecting_Ios_OS() throws EncryptedDocumentException, IOException
	{
		//select the OS
		crashesPage.selectOS(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "IosOS"));
		
		//select the app version
		crashesPage.selectAppVersion(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "AllAppversions"));
		
		String countriesList = eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "TopLocationsForIos");
		String noOfCrashes = eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "No.ofCrashesForTopLocationTable");
		String noOfEffectedUsers = eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "crashInfoTableNo.ofEffectedUsers");
		crashesPage.validateTopLocationsTable(countriesList,noOfCrashes,noOfEffectedUsers);
	}
	
	@Test
	public void TC_171_validate_The_Top_Location_Table_Data_By_Selecting_Ios_OS_With_Specific_App_version() throws EncryptedDocumentException, IOException
	{
		//select the OS
		crashesPage.selectOS(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "IosOS"));
		
		//select the app version
		crashesPage.selectAppVersion(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "IosAppVersion"));
	
		crashesPage.validateCrashInfoTableDataWithOutData();
	}
	
	@Test
	public void TC_172_validate_The_Top_Locations_Table_Data_With_Top_Locations_Page_Data()
	{

		crashesPage.validateIntegrationBetweenTopLocationTableAndTopLocationPage();
	}
	
	@Test
	public void TC_173_validate_The_Top_Location_Page_Data_With_All_OS() throws EncryptedDocumentException, IOException
	{
		crashesPage.validateViewAllBtnOfTopLocationTable();
		
		String countriesList = eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "topLocationsPageCountriesForAll");
		String noOfCrashes = eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "No.ofCrashesForTopLocationTable");
		String noOfEffectedUsers = eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "crashInfoTableNo.ofEffectedUsers");
		crashesPage.validateTopLocationPageData(countriesList,noOfCrashes,noOfEffectedUsers);
	}
	
	@Test
	public void TC_174_validate_The_Top_Location_Page_Data_With_Android_OS() throws EncryptedDocumentException, IOException
	{
		crashesPage.validateViewAllBtnOfTopLocationTable();
		
		//select the OS
		crashesPage.selectOS(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "androidOS"));
		
		//select the app version
		crashesPage.selectAppVersion(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "AllAppversions"));
		
		String countriesList = eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "TopLocationsForAndroid");
		String noOfCrashes = eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "No.ofCrashesForTopLocationTable");
		String noOfEffectedUsers = eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "crashInfoTableNo.ofEffectedUsers");
		
		crashesPage.validateTopLocationPageData(countriesList,noOfCrashes,noOfEffectedUsers);
	}
	
	@Test
	public void TC_175_validate_The_Top_Location_Page_Data_With_Android_OS_With_Specifi_App_version() throws EncryptedDocumentException, IOException
	{
		crashesPage.validateViewAllBtnOfTopLocationTable();
		
		//select the OS
		crashesPage.selectOS(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "androidOS"));
		
		//select the app version
		crashesPage.selectAppVersion(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "androidAppVersion"));
		
		String countriesList = eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "CountryForAndroidAppVersion");
		String noOfCrashes = eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "No.ofCrashesForTopLocationTable");
		String noOfEffectedUsers = eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "crashInfoTableNo.ofEffectedUsers");
		
		crashesPage.validateTopLocationPageData(countriesList,noOfCrashes,noOfEffectedUsers);
	}
	
	@Test
	public void TC_176_validate_The_Top_Location_Page_Data_With_Ios_OS() throws EncryptedDocumentException, IOException
	{
		crashesPage.validateViewAllBtnOfTopLocationTable();
		
		//select the OS
		crashesPage.selectOS(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "IosOS"));
		
		//select the app version
		crashesPage.selectAppVersion(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "AllAppversions"));
		
		String countriesList = eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "TopLocationsForIos");
		String noOfCrashes = eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "No.ofCrashesForTopLocationTable");
		String noOfEffectedUsers = eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "crashInfoTableNo.ofEffectedUsers");
		
		crashesPage.validateTopLocationPageData(countriesList,noOfCrashes,noOfEffectedUsers);
	}
	
	@Test
	public void TC_177_validate_The_Top_Location_Page_Data_With_Ios_OS_With_Specific_App_Veriosn() throws EncryptedDocumentException, IOException
	{
		crashesPage.validateViewAllBtnOfTopLocationTable();
		
		//select the OS
		crashesPage.selectOS(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "IosOS"));
		
		//select the app version
		crashesPage.selectAppVersion(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "IosAppVersion"));
		
		crashesPage.validateCrashInfoTableDataWithOutData();
	}
	
	@Test
	public void TC_178_validate_The_Top_Locations_Country_Page_By_Clicking_Country_On_Top_Locations_Table()
	{
		crashesPage.clickOnTopLocationCountry();
		
		crashesPage.validateTopLocationByCountryPage();
	}
	
	
	@Test
	public void TC_179_validate_The_Top_Locations_Country_Page_By_Clicking_No_Of_Crashes_On_Top_Locations_Table()
	{
		crashesPage.clickOnTopLocationCrashes();
		
		crashesPage.validateTopLocationByCountryPage();
	}
	
	@Test
	public void TC_180_validate_The_Top_Locations_Country_Page_By_Clicking_No_Of_Effected_Users_On_Top_Locations_Table()
	{
		crashesPage.clickOnTopLocationEffectedUsers();
		
		crashesPage.validateTopLocationByCountryPage();
	}
	
	@Test
	public void TC_181_validate_The_Ascending_Order_Icon_Of_Number_Of_Crashes_In_Top_Locations_page()
	{
		crashesPage.validateViewAllBtnOfTopLocationTable();
		
		crashesPage.validateAscendingOrderIcon();
	}
	
	@Test
	public void TC_182_validate_The_descending_Order_Icon_Of_Number_Of_Crashes_In_Top_Locations_page()
	{
		crashesPage.validateViewAllBtnOfTopLocationTable();
		
		crashesPage.validateDescendingOrderIcon();
	}
	
	@Test
	public void TC_183_validate_The_Top_Locations_Country_Page_By_Clicking_Country_On_Top_Locations_Page()
	{
		crashesPage.validateViewAllBtnOfTopLocationTable();
		
		crashesPage.clickOnTopLocationPageCountry();
		
		crashesPage.validateTopLocationByCountryPage();
	}
	
	
	@Test
	public void TC_184_validate_The_Top_Locations_Country_Page_By_Clicking_No_Of_Crashes_On_Top_Locations_Page()
	{
		crashesPage.validateViewAllBtnOfTopLocationTable();
		
		crashesPage.clickOnTopLocationPageCrashes();
		
		crashesPage.validateTopLocationByCountryPage();
	}
	
	@Test
	public void TC_185_validate_The_Top_Locations_Country_Page_By_Clicking_No_Of_Effected_Users_On_Top_Locations_Page()
	{
		crashesPage.validateViewAllBtnOfTopLocationTable();
		
		crashesPage.clickOnTopLocationPageEffectedUsers();
		
		crashesPage.validateTopLocationByCountryPage();
	}
	
	@Test
	public void TC_186_validate_Crash_Or_Exception_Information_Section_Of_Top_Locations_Country_Page() throws EncryptedDocumentException, IOException
	{
		crashesPage.clickOnTopLocationCountry();
		
		String expectedText = eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmCrashesSheet, "TopLocations/countryValues");
		crashesPage.validateTopLocationByCountryText(expectedText);
	}
	
	@Test
	public void TC_187_validate_Crash_Or_Exception_Information_Section_Data_Of_Top_Locations_Country_Page() throws EncryptedDocumentException, IOException
	{
		crashesPage.clickOnTopLocationCountry();
		String crashFreeUsersFromCountry = eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "crashFreeUsersFromCountry");
		String totalUsersFromCountry =  eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "totalUsersFromCountry");
		String noOfCrashesFromCountry = eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "No.ofCrashesForTopLocationTable");
		String crashesDeviceFromCountry = eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "devicesForAndroid");
		String crashesOsFromCountry = eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "osForAndroidAppVersion");
		String crashesAppVersionFromCountry = eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "appVersionsForAndroid");
			
		crashesPage.validateExceptionInfoData(crashFreeUsersFromCountry,totalUsersFromCountry,noOfCrashesFromCountry,crashesDeviceFromCountry,crashesOsFromCountry,crashesAppVersionFromCountry);
	}
	
	
	@Test
	public void TC_188_validate_Performance_Information_Section_Data_Of_Top_Locations_Country_Page() throws EncryptedDocumentException, IOException
	{
		crashesPage.clickOnTopLocationCountry();
		
		String noOfRequestFromCountry = eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "noOfRequestFromCountry");
		String errorCallsFromCountry = eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "errorCallsFromCountry");
		
		crashesPage.validatePerformanceInfoData(noOfRequestFromCountry,errorCallsFromCountry);
	}
	

	
	@Test
	public void TC_189_validate_The_back_button_Of_Top_Locations_Country_Page()
	{
		crashesPage.clickOnTopLocationCountry();
		
		crashesPage.validateBackBtnOfTopLocationByCountryPage();
	}
	
	@Test
	public void TC_190_validate_The_back_button_Of_Top_Locations_Page()
	{
		crashesPage.validateViewAllBtnOfTopLocationTable();
		
		crashesPage.validateBackBtnOfTopLocationPage();
	}
	
	@Test
	public void TC_191_validate_The_Geographic_Distribution_Map_Is_Displaying_The_Crashes_And_Crash_Affected_Areas() throws EncryptedDocumentException, IOException
	{
		String totalCrashes = eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "crashesForAndroid")+","+eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "crashesForIos");
		String countries = eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "countryWithCrashes");
		String Defaultcolor = eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "defaultCountryColorInMap");
		crashesPage.validateTheCrashesOnMap(countries,totalCrashes,Defaultcolor);
	}

	
	
	@DataProvider 
	public Object[][] pagination() throws Exception, Exception {
		return eutil.fetchAllTheDataFromExcelSheet(IPathConstant.commExcelPath, IPathConstant.commonPaginationSheet);
	}
	
	
	
	
	
	


}
