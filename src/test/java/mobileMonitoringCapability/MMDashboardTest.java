package mobileMonitoringCapability;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import genericUtilities.ExcelUtility;
import genericUtilities.GenericMethods;
import genericUtilities.IPathConstant;
import objectRepository.MM.MMCrashesPage;
import objectRepository.MM.MMDashBoardPage;
import objectRepository.MM.MMUsagePage;
import playWrightFactory.BaseClass;

public class MMDashboardTest extends BaseClass {
	
	
	MMUsagePage usagePage;
	GenericMethods util;
	ExcelUtility eutil;
	MMCrashesPage crashPage;
	MMDashBoardPage dashPage;
	
	@BeforeMethod
	public void preRequests() throws EncryptedDocumentException, IOException, InterruptedException
	{
		util=new GenericMethods();
		usagePage=new MMUsagePage(page);
		eutil=new ExcelUtility();
		crashPage=new MMCrashesPage(page);
		dashPage = new MMDashBoardPage(page);
		
		//Navigate to mobileMonitoring capability
		commPage.navigateToMobileMonitoring();
									
		//select the Time line 
		commPage.selectTheTimeLineFromCalender(IPathConstant.sixHoursTimeRange);
						
		//select the Application
		crashPage.selectTheApplicationForMM(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmCrashesSheet, "application"));
						
		//select the OS
		crashPage.selectOS(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "AllOS"));
						
		//select the app version
		crashPage.selectAppVersion(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "AllAppversions"));
		
	}	
	
	@Test
	public void TC_001_Validate_DashBoard_Page_Displaying_By_Default() throws EncryptedDocumentException, IOException
	{
		
		dashPage.validateDashBoardPage(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath, IPathConstant.mmDashBoardSheet, "AppUsageKpisHeader"));
	}
	
	@Test
	public void TC_002_validate_The_New_User_Icon_And_Label() throws EncryptedDocumentException, IOException
	{
		dashPage.validateNewUsersIconAndLabel(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "newUserLabel"),
				eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "IconOutLineColor"));
	}
	
	@Test
	public void TC_003_validate_The_New_User_Tool_Tip_By_Hover() throws EncryptedDocumentException, IOException
	{
		dashPage.validateNewUsersTooltip(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "newUserTooltip"));
	}
	
	@Test
	public void TC_004_validate_The_New_User_Per_Min_Label() throws EncryptedDocumentException, IOException
	{
		dashPage.validateNewUsersPerMinLabel(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "NewUserPerMinLabel"));
	}
	
	@Test
	public void TC_005_validate_The_Sessions_Icon_And_Label() throws EncryptedDocumentException, IOException
	{
		dashPage.validateSessionsIconAndLabel(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "Sessionslabel"),
				eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "IconOutLineColor"));
	}
	
	
	@Test
	public void TC_006_validate_The_Session_Per_Min_Label() throws EncryptedDocumentException, IOException
	{
		dashPage.validateSessionsPerMinLabel(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "SessioinsPerMinLabel"));
	}
	
	@Test
	public void TC_007_validate_The_App_Launches_Icon_And_Label() throws EncryptedDocumentException, IOException
	{
		dashPage.validateAppLaunchesIconAndLabel(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "AppLaunchesLabel"),
				eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "IconOutLineColor"));
	}
	
	
	@Test
	public void TC_008_validate_The_App_Launches_Per_Min_Label() throws EncryptedDocumentException, IOException
	{
		dashPage.validateAppLaunchesPerMinLabel(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "LaunchesPerMinLabel"));
	}
	
	@Test
	public void TC_009_validate_Crashes_KPIs_Header() throws EncryptedDocumentException, IOException
	{
		dashPage.validateCrashesHeader(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "CrashesHeader"));
	}
	
	@Test
	public void TC_010_validate_The_Crashes_Label() throws EncryptedDocumentException, IOException
	{
		dashPage.validateCrashesLabel(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "CrashesLabel"));
	}
	
	
	@Test
	public void TC_011_validate_The_Crash_Per_Min_Label() throws EncryptedDocumentException, IOException
	{
		dashPage.validateCrashesPerMinLabel(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "CrashesPerMinLabel"));
	}
	
	@Test
	public void TC_012_validate_The_Crash_Free_Users_Label() throws EncryptedDocumentException, IOException
	{
		dashPage.validateCrashFreeUsersLabel(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "CrasheFreeUserLabel"));
	}
	
	@Test
	public void TC_013_validate_The_Crashes_By_OS_Header() throws EncryptedDocumentException, IOException
	{
		dashPage.validateCrashesByOSHeader(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "CrasheByOsHeader"));
		
	}
	
	@Test
	public void TC_014_validate_The_Android_Crash_Percentage_Label() throws EncryptedDocumentException, IOException
	{
		dashPage.validateAndroidCrashPercentageLabel(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "AndroidCrashPercentageLabel"));
	}
	
	@Test
	public void TC_015_validate_The_IOS_Crash_Percentage_Label() throws EncryptedDocumentException, IOException
	{
		dashPage.validateIosCrashPercentageLabel(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "IosCrashPercentageLabel"));
	}
	

	@Test
	public void TC_016_validate_The_Android_Crash_Percentage_Color() throws EncryptedDocumentException, IOException
	{
		dashPage.validateAndroidCrashPercentageColor(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "AndroidCrashPercentageColor"));
	}
	
	@Test
	public void TC_017_validate_The_IOS_Crash_Percentage_Color() throws EncryptedDocumentException, IOException
	{
		dashPage.validateIosCrashPercentageColor(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "IosCrashPercentageColor"));
	}
	
	@Test
	public void TC_018_validate_The_Crash_By_os_Image() throws EncryptedDocumentException, IOException
	{
		dashPage.validateCrashByOSImage(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "AndroidCrashPercentageColor"),
											eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "IosCrashPercentageColor"));
	}
	
	@Test
	public void TC_019_validate_Performance_KPIs_Header() throws EncryptedDocumentException, IOException
	{
		dashPage.validatePerformanceKPIHeader(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "PerformanceKPIHeader"));
	}
	
	
	@Test
	public void TC_020_validate_Web_Request_Icon_And_Label() throws EncryptedDocumentException, IOException
	{
		dashPage.validateWebRequestIconAndLabel(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "WebRequestLabel"),
				eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "IconOutLineColor"));
	}
	
	
	@Test
	public void TC_021_validate_The_Response_Time_Icon_And_Label() throws EncryptedDocumentException, IOException
	{
		dashPage.validateResponseTimeIconAndLabel(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "ResponseLabel"),
				eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "IconOutLineColor"));
	}
	
	
	@Test
	public void TC_022_validate_The_Error_Percentage_Icon_And_Label() throws EncryptedDocumentException, IOException
	{
		dashPage.validateErrorRateIconAndLabel(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "ErrorPercentageLabel"),
				eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "IconOutLineColor"));
	}
	
	@Test
	public void TC_023_validate_The_App_Usage_Header_And_Sub_Headers() throws EncryptedDocumentException, IOException
	{
		dashPage.validateAppUsageSection(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "AppUsageHeader"),
				eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "APpUsageSubHeaders"));
	}
	
	@Test
	public void TC_024_validate_The_Total_Installs_Android_And_Ios_Icons()
	{
		dashPage.validateTotalInstallSectionIcons();
	}
	
	@Test
	public void TC_025_validate_The_Total_Installs_Android_And_Ios_labels() throws EncryptedDocumentException, IOException
	{
		dashPage.validateTotalInstallSectionLabels(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "AndroidCrashPercentageLabel"),
				eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "IosCrashPercentageLabel"));
	}
	
	@Test
	public void TC_026_validate_The_Top_Versions_Android_And_Ios_labels() throws EncryptedDocumentException, IOException
	{
		dashPage.validateTopVersionsSectionLabels(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "AndroidCrashPercentageLabel"),
				eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "IosCrashPercentageLabel"));
	}
	
	@Test
	public void TC_027_validate_New_Users_Count_For_All() throws EncryptedDocumentException, IOException
	{
		//select the OS
		crashPage.selectOS(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "AllOS"));
		
		//select the app version
		crashPage.selectAppVersion(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "AllAppversions"));
		
		//validate the new user count for All
		dashPage.validateNewUserCount(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "androidNewUserCount"),
										eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "IosNewUserCount"));
	}
	
	@Test
	public void TC_028_validate_New_Users_Count_For_Android()throws EncryptedDocumentException, IOException
	{
		
		//select the OS
		crashPage.selectOS(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "androidOS"));
		
		//select the app version
		crashPage.selectAppVersion(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "AllAppversions"));
		
		//validate the new user count for Android
		dashPage.validateNewUserCount(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "androidNewUserCount"));

	}
	
	@Test
	public void TC_029_validate_New_Users_Count_For_Android_With_Specific_AppVersion()throws EncryptedDocumentException, IOException
	{
		
		//select the OS
		crashPage.selectOS(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "androidOS"));
		
		//select the app version
		crashPage.selectAppVersion(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "androidAppVersion"));

		//validate the new user count for Android
		dashPage.validateNewUserCount(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "NewUserForEachAppVersion"));

	}
	
	@Test
	public void TC_030_validate_New_Users_Count_For_Ios()throws EncryptedDocumentException, IOException
	{
		//select the OS
		crashPage.selectOS(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "IosOS"));
		
		//select the app version
		crashPage.selectAppVersion(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "AllAppversions"));
		
		//validate the new user count for Android
		dashPage.validateNewUserCount(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "IosNewUserCount"));
	}
	
	
	@Test
	public void TC_031_validate_New_Users_Count_For_Ios_With_Specific_AppVersion()throws EncryptedDocumentException, IOException
	{
		//select the OS
		crashPage.selectOS(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "IosOS"));
		
		//select the app version
		crashPage.selectAppVersion(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "IosAppVersion"));
		
		//validate the new user count for Android
		dashPage.validateNewUserCount(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "NewUserForEachAppVersion"));

	}
	

	@Test
	public void TC_032_validate_New_Users_Per_Min_Count_For_All()throws EncryptedDocumentException, IOException
	{
		
		//select the OS
		crashPage.selectOS(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "AllOS"));
				
		//select the app version
		crashPage.selectAppVersion(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "AllAppversions"));
		
		dashPage.validateUserPerMinCount(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "androidNewUserCount"),
				eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "IosNewUserCount"));
	}
	
	@Test
	public void TC_033_validate_New_Users_Per_Min_Count_For_Android()throws EncryptedDocumentException, IOException
	{
		
		//select the OS
		crashPage.selectOS(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "androidOS"));
		
		//select the app version
		crashPage.selectAppVersion(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "AllAppversions"));
		
		dashPage.validateUserPerMinCount(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "androidNewUserCount"));

	}
	
	@Test
	public void TC_034_validate_New_Users_Per_Min_Count_For_Android_With_Specific_AppVersion()throws EncryptedDocumentException, IOException
	{
		
		//select the OS
		crashPage.selectOS(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "androidOS"));
		
		//select the app version
		crashPage.selectAppVersion(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "androidAppVersion"));
		
		dashPage.validateUserPerMinCount(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "NewUserForEachAppVersion"));
	}
	
	@Test
	public void TC_035_validate_New_Users_Per_Min_Count_For_Ios()throws EncryptedDocumentException, IOException
	{
		//select the OS
		crashPage.selectOS(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "IosOS"));
		
		//select the app version
		crashPage.selectAppVersion(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "AllAppversions"));
		
		dashPage.validateUserPerMinCount(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "IosNewUserCount"));

	}
	
	@Test
	public void TC_036_validate_New_Users_Per_Min_Count_For_Ios_With_Specific_AppVersion()throws EncryptedDocumentException, IOException
	{
		//select the OS
		crashPage.selectOS(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "IosOS"));
		
		//select the app version
		crashPage.selectAppVersion(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "IosAppVersion"));
		
		dashPage.validateUserPerMinCount(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "NewUserForEachAppVersion"));
	}
	
	@Test
	public void TC_037_validate_Sessions_Count_For_All()throws EncryptedDocumentException, IOException
	{
		//select the OS
		crashPage.selectOS(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "AllOS"));
				
		//select the app version
		crashPage.selectAppVersion(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "AllAppversions"));
		
		dashPage.validateSessionsCount(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "totalSessions"));
	}
	
	@Test
	public void TC_038_validate_Sessions_Count_For_Android()throws EncryptedDocumentException, IOException
	{
		
		//select the OS
		crashPage.selectOS(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "androidOS"));
		
		//select the app version
		crashPage.selectAppVersion(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "AllAppversions"));
		
		//validate session count
		dashPage.validateSessionsCount(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "AndroidSessions"));
	}
	
	@Test
	public void TC_039_validate_Sessions_Count_For_Android_With_Specific_AppVersion()throws EncryptedDocumentException, IOException
	{
		
		//select the OS
		crashPage.selectOS(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "androidOS"));
		
		//select the app version
		crashPage.selectAppVersion(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "androidAppVersion"));
		
		//validate session count
		dashPage.validateSessionsCount(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "sessionsForAndroidAppVersion"));
	}
	
	@Test
	public void TC_040_validate_Sessions_Count_For_Ios()throws EncryptedDocumentException, IOException
	{
		//select the OS
		crashPage.selectOS(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "IosOS"));
		
		//select the app version
		crashPage.selectAppVersion(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "AllAppversions"));
		
		dashPage.validateSessionsCount(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "IosSessions"));
	}
	
	@Test
	public void TC_041_validate_Sessions_Count_For_Ios_With_Specific_AppVersion()throws EncryptedDocumentException, IOException
	{
		crashPage.selectOS(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "IosOS"));
		
		//select the app version
		crashPage.selectAppVersion(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "IosAppVersion"));
		
		//validate session count
		dashPage.validateSessionsCount(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "sessionsForIosAppVersion"));

	}
	

	@Test
	public void TC_042_validate_Sessions_Per_Min_Count_For_All()throws EncryptedDocumentException, IOException
	{
		//select the OS
		crashPage.selectOS(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "AllOS"));
				
		//select the app version
		crashPage.selectAppVersion(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "AllAppversions"));
		
		dashPage.validateSessionsPerMinCount(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "totalSessions"));
	}
	

	@Test
	public void TC_043_validate_Sessions_Per_Min_Count_For_Android()throws EncryptedDocumentException, IOException
	{
		
		//select the OS
		crashPage.selectOS(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "androidOS"));
		
		//select the app version
		crashPage.selectAppVersion(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "AllAppversions"));
		
		//validate session count
		dashPage.validateSessionsPerMinCount(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "AndroidSessions"));

	}
	
	@Test
	public void TC_044_validate_Sessions_Per_Min_Count_For_Android_With_Specific_AppVersion()throws EncryptedDocumentException, IOException
	{
		
		//select the OS
		crashPage.selectOS(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "androidOS"));
		
		//select the app version
		crashPage.selectAppVersion(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "androidAppVersion"));
		
		//validate session count
		dashPage.validateSessionsPerMinCount(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "sessionsForAndroidAppVersion"));

	}
	

	@Test
	public void TC_045_validate_Sessions_Per_Min_Count_For_Ios()throws EncryptedDocumentException, IOException
	{
		//select the OS
		crashPage.selectOS(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "IosOS"));
		
		//select the app version
		crashPage.selectAppVersion(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "AllAppversions"));
		
		dashPage.validateSessionsPerMinCount(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "IosSessions"));
	}
	
	@Test
	public void TC_046_validate_Sessions_Per_Min_Count_For_Ios_With_Specific_AppVersion()throws EncryptedDocumentException, IOException
	{
		//select the OS
		crashPage.selectOS(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "IosOS"));
		
		//select the app version
		crashPage.selectAppVersion(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "IosAppVersion"));
		
		//validate session count
		dashPage.validateSessionsPerMinCount(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "sessionsForIosAppVersion"));

	}
	
	@Test
	public void TC_047_validate_App_Launches_Count_For_All()throws EncryptedDocumentException, IOException
	{
		//select the OS
		crashPage.selectOS(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "AllOS"));
				
		//select the app version
		crashPage.selectAppVersion(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "AllAppversions"));

		dashPage.validateAppLaunchCount(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "AndroidAppLaunchCount"),
				eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "IosAppLaunchCount"));
	}
	
	@Test
	public void TC_048_validate_App_Launches_Count_For_Android()throws EncryptedDocumentException, IOException
	{
		
		//select the OS
		crashPage.selectOS(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "androidOS"));
		
		//select the app version
		crashPage.selectAppVersion(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "AllAppversions"));
		
		dashPage.validateAppLaunchCount(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "AndroidAppLaunchCount"));
	}
	
	@Test
	public void TC_049_validate_App_Launches_Count_For_Android_With_Specific_AppVersion()throws EncryptedDocumentException, IOException
	{
		
		//select the OS
		crashPage.selectOS(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "androidOS"));
		
		//select the app version
		crashPage.selectAppVersion(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "androidAppVersion"));
		
		dashPage.validateAppLaunchCount(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "NewUserForEachAppVersion"));
	}
	
	@Test
	public void TC_050_validate_App_Launches_Count_For_Ios()throws EncryptedDocumentException, IOException
	{
		//select the OS
		crashPage.selectOS(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "IosOS"));
		
		//select the app version
		crashPage.selectAppVersion(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "AllAppversions"));
		
		dashPage.validateAppLaunchCount(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "IosAppLaunchCount"));
	}
	
	@Test
	public void TC_051_validate_App_Launches_Count_For_Ios_With_Specific_AppVersion()throws EncryptedDocumentException, IOException
	{
		//select the OS
		crashPage.selectOS(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "IosOS"));
		
		//select the app version
		crashPage.selectAppVersion(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "IosAppVersion"));
		
		dashPage.validateAppLaunchCount(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "NewUserForEachAppVersion"));
	}
	

	@Test
	public void TC_052_validate_App_Launches_Per_Min_Count_For_All()throws EncryptedDocumentException, IOException
	{
		//select the OS
		crashPage.selectOS(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "AllOS"));
				
		//select the app version
		crashPage.selectAppVersion(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "AllAppversions"));
		
		dashPage.validateAppLaunchPerMinCount(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "AndroidAppLaunchCount"),
				eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "IosAppLaunchCount"));
	}
	
	@Test
	public void TC_053_validate_App_Launches_Per_Min_Count_For_Android()throws EncryptedDocumentException, IOException
	{
		
		//select the OS
		crashPage.selectOS(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "androidOS"));
		
		//select the app version
		crashPage.selectAppVersion(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "AllAppversions"));
		
		dashPage.validateAppLaunchPerMinCount(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "AndroidAppLaunchCount"));
	}
	
	@Test
	public void TC_054_validate_App_Launches_Per_Min_Count_For_Android_With_Specific_AppVersion()throws EncryptedDocumentException, IOException
	{
		
		//select the OS
		crashPage.selectOS(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "androidOS"));
		
		//select the app version
		crashPage.selectAppVersion(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "androidAppVersion"));
		
		dashPage.validateAppLaunchPerMinCount(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "NewUserForEachAppVersion"));
	}
	
	@Test
	public void TC_055_validate_App_Launches_Per_Min_Count_For_Ios()throws EncryptedDocumentException, IOException
	{
		//select the OS
		crashPage.selectOS(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "IosOS"));
		
		//select the app version
		crashPage.selectAppVersion(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "AllAppversions"));
		
		dashPage.validateAppLaunchPerMinCount(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "IosAppLaunchCount"));
	}
	
	@Test
	public void TC_056_validate_App_Launches_Per_Min_Count_For_Ios_With_Specific_AppVersion()throws EncryptedDocumentException, IOException
	{
		//select the OS
		crashPage.selectOS(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "IosOS"));
		
		//select the app version
		crashPage.selectAppVersion(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "IosAppVersion"));
		
		dashPage.validateAppLaunchPerMinCount(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "NewUserForEachAppVersion"));
	}
	
	@Test
	public void TC_057_validate_Crashes_Count_For_All()throws EncryptedDocumentException, IOException
	{
		//select the OS
		crashPage.selectOS(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "AllOS"));
				
		//select the app version
		crashPage.selectAppVersion(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "AllAppversions"));
		
		dashPage.validateCrashesCount(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "crashesForAndroid"),
				eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "crashesForIos"));
	}
	
	@Test
	public void TC_058_validate_Crashes_Count_For_Android()throws EncryptedDocumentException, IOException
	{
		
		//select the OS
		crashPage.selectOS(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "androidOS"));
		
		//select the app version
		crashPage.selectAppVersion(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "AllAppversions"));
		
		dashPage.validateCrashesCount(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "crashesForAndroid"));
	}
	
	@Test
	public void TC_059_validate_Crashes_Count_For_Android_With_Specific_AppVersion()throws EncryptedDocumentException, IOException
	{
		
		//select the OS
		crashPage.selectOS(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "androidOS"));
		
		//select the app version
		crashPage.selectAppVersion(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "androidAppVersion"));
		
		dashPage.validateCrashesCountForSpecificAppVersion(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "crashesForAndroidAppVersion"));
	}
	
	@Test
	public void TC_060_validate_Crashes_Count_For_Ios()throws EncryptedDocumentException, IOException
	{
		//select the OS
		crashPage.selectOS(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "IosOS"));
		
		//select the app version
		crashPage.selectAppVersion(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "AllAppversions"));
		
		dashPage.validateCrashesCount(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "crashesForIos"));
	}
	
	@Test
	public void TC_061_validate_Crashes_Count_For_Ios_With_Specific_AppVersion()throws EncryptedDocumentException, IOException
	{
		//select the OS
		crashPage.selectOS(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "IosOS"));
		
		//select the app version
		crashPage.selectAppVersion(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "IosAppVersion"));
		
		dashPage.validateCrashesCountForSpecificAppVersion(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "crashesForIosAppVersion"));
	}

	@Test
	public void TC_062_validate_Crashes_Per_Min_Count_For_All()throws EncryptedDocumentException, IOException
	{
		//select the OS
		crashPage.selectOS(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "AllOS"));
				
		//select the app version
		crashPage.selectAppVersion(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "AllAppversions"));
		
		dashPage.validateCrashesPerMinCount(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "crashesForAndroid"),
				eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "crashesForIos"));

	}
	
	@Test
	public void TC_063_validate_Crashes_Per_Min_Count_For_Android()throws EncryptedDocumentException, IOException
	{
		
		//select the OS
		crashPage.selectOS(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "androidOS"));
		
		//select the app version
		crashPage.selectAppVersion(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "AllAppversions"));
		
		dashPage.validateCrashesPerMinCount(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "crashesForAndroid"));
	}
	
	@Test
	public void TC_064_validate_Crashes_Per_Min_Count_For_Android_With_Specific_AppVersion()throws EncryptedDocumentException, IOException
	{
		
		//select the OS
		crashPage.selectOS(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "androidOS"));
		
		//select the app version
		crashPage.selectAppVersion(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "androidAppVersion"));
		
		dashPage.validateCrashesPerMinCount(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "crashesForAndroidAppVersion"));
	}
	
	@Test
	public void TC_065_validate_Crashes_Per_Min_Count_For_Ios()throws EncryptedDocumentException, IOException
	{
		//select the OS
		crashPage.selectOS(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "IosOS"));
		
		//select the app version
		crashPage.selectAppVersion(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "AllAppversions"));
		
		dashPage.validateCrashesPerMinCount(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "crashesForIos"));
	}
	
	@Test
	public void TC_066_validate_Crashes_Per_Min_Count_For_Ios_With_Specific_AppVersion()throws EncryptedDocumentException, IOException
	{
		//select the OS
		crashPage.selectOS(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "IosOS"));
		
		//select the app version
		crashPage.selectAppVersion(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "IosAppVersion"));
		
		dashPage.validateCrashesPerMinCount(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "crashesForIosAppVersion"));
	}
	
	@Test
	public void TC_067_validate_Crashes_Free_User_Percentage_For_All()throws EncryptedDocumentException, IOException
	{
		//select the OS
		crashPage.selectOS(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "AllOS"));
				
		//select the app version
		crashPage.selectAppVersion(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "AllAppversions"));
		
		dashPage.validateCrashFreeUserCount(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "AndroidCrasheFreeUsers"),
				eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "IosCrashFreeUsers"),
				eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "androidNewUserCount"),
				eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "IosNewUserCount"));

	}
	
	@Test
	public void TC_068_validate_Crashes_Free_User_Percentage_For_Android()throws EncryptedDocumentException, IOException
	{
		
		//select the OS
		crashPage.selectOS(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "androidOS"));
		
		//select the app version
		crashPage.selectAppVersion(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "AllAppversions"));
		
		dashPage.validateCrashFreeUserCount(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "AndroidCrasheFreeUsers"),
				eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "androidNewUserCount"));
	}
	
	@Test
	public void TC_069_validate_Crashes_Free_User_Percentage_For_Android_With_Specific_AppVersion()throws EncryptedDocumentException, IOException
	{
		
		//select the OS
		crashPage.selectOS(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "androidOS"));
		
		//select the app version
		crashPage.selectAppVersion(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "androidAppVersion"));
		
		dashPage.validateCrashFreeUserCount(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "crashesFreeUsersForAndroidAppVersion"),
				eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "NewUserForEachAppVersion"));

	}
	
	@Test
	public void TC_070_validate_Crashes_Free_User_Percentage_For_Ios()throws EncryptedDocumentException, IOException
	{
		//select the OS
		crashPage.selectOS(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "IosOS"));
		
		//select the app version
		crashPage.selectAppVersion(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "AllAppversions"));
		
		
		dashPage.validateCrashFreeUserCount(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "IosCrashFreeUsers"),
				eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "IosNewUserCount"));
	}
	
	@Test
	public void TC_071_validate_Crashes_Free_User_Percentage_For_Ios_With_Specific_AppVersion()throws EncryptedDocumentException, IOException
	{
		//select the OS
		crashPage.selectOS(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "IosOS"));
		
		//select the app version
		crashPage.selectAppVersion(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "IosAppVersion"));
		
		dashPage.validateCrashFreeUserCount(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "crashesFreeUsersForIosAppVersion"),
				eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "NewUserForEachAppVersion"));

	}
	
	@Test
	public void TC_072_validate_Crashes_By_Os_Percentage_For_All()throws EncryptedDocumentException, IOException
	{
		//select the OS
		crashPage.selectOS(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "AllOS"));
				
		//select the app version
		crashPage.selectAppVersion(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "AllAppversions"));
		
		
		int androidCrashes = eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "crashesForAndroid").split(",").length;
		int iosCrashes = eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "crashesForIos").split(",").length;
		
		dashPage.validateCrashByOsPercentage(androidCrashes,iosCrashes);
		
	}
	
	@Test
	public void TC_073_validate_Crashes_By_Os_Percentage_For_Android()throws EncryptedDocumentException, IOException
	{
		
		//select the OS
		crashPage.selectOS(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "androidOS"));
		
		//select the app version
		crashPage.selectAppVersion(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "AllAppversions"));
		
		int androidCrashes = eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "crashesForAndroid").split(",").length;
		
		dashPage.validateCrashByOsPercentageForAndroid(androidCrashes);
	}
	
	@Test
	public void TC_074_validate_Crashes_By_Os_Percentage_For_Android_With_Specific_AppVersion()throws EncryptedDocumentException, IOException
	{
		
		//select the OS
		crashPage.selectOS(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "androidOS"));
		
		//select the app version
		crashPage.selectAppVersion(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "androidAppVersion"));
		
		int androidCrashes = eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "crashesForAndroidAppVersion").split(",").length;
		
		dashPage.validateCrashByOsPercentageForAndroid(androidCrashes);
	}
	
	@Test
	public void TC_075_validate_Crashes_By_Os_Percentage_For_Ios()throws EncryptedDocumentException, IOException
	{
		//select the OS
		crashPage.selectOS(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "IosOS"));
		
		//select the app version
		crashPage.selectAppVersion(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "AllAppversions"));
		
	
		int iosCrashes = eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "crashesForIos").split(",").length;
		
		dashPage.validateCrashByOsPercentageForIos(iosCrashes);
	}
	
	@Test
	public void TC_076_validate_Crashes_By_Os_Percentage_For_Ios_With_Specific_AppVersion()throws EncryptedDocumentException, IOException
	{
		//select the OS
		crashPage.selectOS(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "IosOS"));
		
		//select the app version
		crashPage.selectAppVersion(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "IosAppVersion"));
		
		int iosCrashes = eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "crashesForIosAppVersion").split(",").length;
		
		dashPage.validateCrashByOsPercentageForIos(iosCrashes);
	}
	
	
	
	@Test
	public void TC_077_validate_Android_Total_Installs_For_All()throws EncryptedDocumentException, IOException
	{
		//select the OS
		crashPage.selectOS(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "AllOS"));
				
		//select the app version
		crashPage.selectAppVersion(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "AllAppversions"));
		
		dashPage.validateTotalInstallsForAndroid(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "androidNewUserCount"));
	}
	
	@Test
	public void TC_078_validate_Android_Total_Installs_For_Android()throws EncryptedDocumentException, IOException
	{
		
		//select the OS
		crashPage.selectOS(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "androidOS"));
		
		//select the app version
		crashPage.selectAppVersion(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "AllAppversions"));
		
		dashPage.validateTotalInstallsForAndroid(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "androidNewUserCount"));
	}
	
	@Test
	public void TC_079_validate_Android_Total_Installs_For_Android_With_Specific_AppVersion()throws EncryptedDocumentException, IOException
	{
		
		//select the OS
		crashPage.selectOS(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "androidOS"));
		
		//select the app version
		crashPage.selectAppVersion(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "androidAppVersion"));
		
		dashPage.validateTotalInstallsForAndroid(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "NewUserForEachAppVersion"));
	}
	
	@Test
	public void TC_080_validate_Android_Total_Installs_For_Ios()throws EncryptedDocumentException, IOException
	{
		//select the OS
		crashPage.selectOS(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "IosOS"));
		
		//select the app version
		crashPage.selectAppVersion(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "AllAppversions"));
		
		dashPage.validateTotalInstallsForAndroid("0");
	}
	
	@Test
	public void TC_081_validate_Android_Total_Installs_For_Ios_With_Specific_AppVersion()throws EncryptedDocumentException, IOException
	{
		//select the OS
		crashPage.selectOS(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "IosOS"));
		
		//select the app version
		crashPage.selectAppVersion(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "IosAppVersion"));
		
		dashPage.validateTotalInstallsForAndroid("0");
	}
	
	@Test
	public void TC_082_validate_Ios_Total_Installs_For_All()throws EncryptedDocumentException, IOException
	{
		//select the OS
		crashPage.selectOS(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "AllOS"));
				
		//select the app version
		crashPage.selectAppVersion(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "AllAppversions"));
		
		dashPage.validateTotalInstallsForIos(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "IosNewUserCount"));
	}
	
	@Test
	public void TC_083_validate_Ios_Total_Installs_For_Android()throws EncryptedDocumentException, IOException
	{
		
		//select the OS
		crashPage.selectOS(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "androidOS"));
		
		//select the app version
		crashPage.selectAppVersion(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "AllAppversions"));
		
		dashPage.validateTotalInstallsForIos("0");
	}
	
	
	@Test
	public void TC_084_validate_Ios_Total_Installs_For_Android_With_Specific_AppVersion()throws EncryptedDocumentException, IOException
	{
		
		//select the OS
		crashPage.selectOS(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "androidOS"));
		
		//select the app version
		crashPage.selectAppVersion(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "androidAppVersion"));
		
		dashPage.validateTotalInstallsForIos("0");
	}
	
	@Test
	public void TC_085_validate_Ios_Total_Installs_For_Ios()throws EncryptedDocumentException, IOException
	{
		//select the OS
		crashPage.selectOS(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "IosOS"));
		
		//select the app version
		crashPage.selectAppVersion(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "AllAppversions"));
		
		dashPage.validateTotalInstallsForIos(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "IosNewUserCount"));
	}
	
	@Test
	public void TC_086_validate_Ios_Total_Installs_For_Ios_With_Specific_AppVersion()throws EncryptedDocumentException, IOException
	{
		//select the OS
		crashPage.selectOS(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "IosOS"));
		
		//select the app version
		crashPage.selectAppVersion(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "IosAppVersion"));
		
		dashPage.validateTotalInstallsForIos(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "NewUserForEachAppVersion"));
	}

	
	@Test
	public void TC_087_validate_Top_Devices_Installs_List_For_All()throws EncryptedDocumentException, IOException
	{
		//select the OS
		crashPage.selectOS(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "AllOS"));
				
		//select the app version
		crashPage.selectAppVersion(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "AllAppversions"));

		dashPage.validateTheTopDeviceInstalls(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "devicesForAndroid"),
								eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "devicesForIos"));
	}
	
	
	@Test
	public void TC_088_validate_Top_Devices_Installs_List_For_Android()throws EncryptedDocumentException, IOException
	{
		
		//select the OS
		crashPage.selectOS(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "androidOS"));
		
		//select the app version
		crashPage.selectAppVersion(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "AllAppversions"));
		
		dashPage.validateTheTopDeviceInstalls(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "devicesForAndroid"));
	}
	
	@Test
	public void TC_089_validate_Top_Devices_Installs_List_For_Android_With_Specific_AppVersion()throws EncryptedDocumentException, IOException
	{
		
		//select the OS
		crashPage.selectOS(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "androidOS"));
		
		//select the app version
		crashPage.selectAppVersion(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "androidAppVersion"));
		
		dashPage.validateTheTopDeviceInstalls(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "topDevicesForAndroidAppVersion"));
	}
	
	
	@Test
	public void TC_090_validate_Top_Devices_Installs_List_For_Ios()throws EncryptedDocumentException, IOException
	{
		//select the OS
		crashPage.selectOS(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "IosOS"));
		
		//select the app version
		crashPage.selectAppVersion(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "AllAppversions"));
		
		dashPage.validateTheTopDeviceInstalls(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "devicesForIos"));
	}
	
	@Test
	public void TC_091_validate_Top_Devices_Installs_List_For_Ios_With_Specific_AppVersion()throws EncryptedDocumentException, IOException
	{
		//select the OS
		crashPage.selectOS(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "IosOS"));
		
		//select the app version
		crashPage.selectAppVersion(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "IosAppVersion"));
		
		dashPage.validateTheTopDeviceInstalls(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "tipDevicesForIosAppVersion"));
	}
	
	@Test
	public void TC_092_validate_Ios_Top_Versions_Installs_List_For_All()throws EncryptedDocumentException, IOException
	{
		//select the OS
		crashPage.selectOS(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "AllOS"));
				
		//select the app version
		crashPage.selectAppVersion(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "AllAppversions"));
		
		dashPage.validateTopVersionsInstallsForIos(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "appVersionsForIos"));
	}
	
	@Test
	public void TC_093_validate_Ios_Top_Versions_Installs_List_For_Android()throws EncryptedDocumentException, IOException
	{
		
		//select the OS
		crashPage.selectOS(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "androidOS"));
		
		//select the app version
		crashPage.selectAppVersion(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "AllAppversions"));
		
		dashPage.validateTopVersionsInstallsForIosWhenAndroidOsSelected();
	}
	
	@Test
	public void TC_094_validate_Ios_Top_Versions_Installs_List_For_Android_With_Specific_AppVersion()throws EncryptedDocumentException, IOException
	{
		
		//select the OS
		crashPage.selectOS(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "androidOS"));
		
		//select the app version
		crashPage.selectAppVersion(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "androidAppVersion"));
		
		dashPage.validateTopVersionsInstallsForIosWhenAndroidOsSelected();
	}
	
	@Test
	public void TC_095_validate_Ios_Top_Versions_Installs_List_For_Ios()throws EncryptedDocumentException, IOException
	{
		//select the OS
		crashPage.selectOS(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "IosOS"));
		
		//select the app version
		crashPage.selectAppVersion(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "AllAppversions"));
		
		dashPage.validateTopVersionsInstallsForIos(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "appVersionsForIos"));
	}
	
	@Test
	public void TC_096_validate_Ios_Top_Versions_Installs_List_For_Ios_With_Specific_AppVersion()throws EncryptedDocumentException, IOException
	{
		//select the OS
		crashPage.selectOS(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "IosOS"));
		
		//select the app version
		crashPage.selectAppVersion(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "IosAppVersion"));
		
		dashPage.validateTopVersionsInstallsForIos(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "IosAppVersion"));
	}
	
	@Test
	public void TC_097_validate_Android_Top_Versions_Installs_List_For_All()throws EncryptedDocumentException, IOException
	{
		//select the OS
		crashPage.selectOS(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "AllOS"));
				
		//select the app version
		crashPage.selectAppVersion(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "AllAppversions"));
		
		dashPage.validateTopVersionsInstallsForAndroid(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "appVersionsForAndroid"));
	}
	
	@Test
	public void TC_098_validate_Android_Top_Versions_Installs_List_For_Android()throws EncryptedDocumentException, IOException
	{
		
		//select the OS
		crashPage.selectOS(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "androidOS"));
		
		//select the app version
		crashPage.selectAppVersion(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "AllAppversions"));
		
		dashPage.validateTopVersionsInstallsForAndroid(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "appVersionsForAndroid"));
	}
	
	@Test
	public void TC_099_validate_Android_Top_Versions_Installs_List_For_Android_With_Specific_AppVersion()throws EncryptedDocumentException, IOException
	{
		
		//select the OS
		crashPage.selectOS(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "androidOS"));
		
		//select the app version
		crashPage.selectAppVersion(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "androidAppVersion"));
		
		dashPage.validateTopVersionsInstallsForAndroid(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "androidAppVersion"));
	}
	
	@Test
	public void TC_100_validate_Android_Top_Versions_Installs_List_For_Ios()throws EncryptedDocumentException, IOException
	{
		//select the OS
		crashPage.selectOS(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "IosOS"));
		
		//select the app version
		crashPage.selectAppVersion(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "AllAppversions"));
		
		dashPage.validateTopVersionsInstallsForAndroidWhenIosOsSelected();
	}
	
	@Test
	public void TC_101_validate_Android_Top_Versions_Installs_List_For_Ios_With_Specific_AppVersion()throws EncryptedDocumentException, IOException
	{
		//select the OS
		crashPage.selectOS(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "IosOS"));
		
		//select the app version
		crashPage.selectAppVersion(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "IosAppVersion"));
		
		dashPage.validateTopVersionsInstallsForAndroidWhenIosOsSelected();	
	}
	
	@Test
	public void TC_102_validate_WebRequest_Count_For_All()throws EncryptedDocumentException, IOException
	{
		//select the OS
		crashPage.selectOS(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "AllOS"));
				
		//select the app version
		crashPage.selectAppVersion(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "AllAppversions"));
		
		dashPage.validateWebRequestCount(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "WebRequestCountForAll"));
	}
	
	@Test
	public void TC_103_validate_WebRequest_Count_For_Android()throws EncryptedDocumentException, IOException
	{
		
		//select the OS
		crashPage.selectOS(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "androidOS"));
		
		//select the app version
		crashPage.selectAppVersion(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "AllAppversions"));
		
		dashPage.validateWebRequestCount(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "WebRequestCountForAndroid"));
	}
	
	@Test
	public void TC_104_validate_WebRequest_Count_For_Android_With_Specific_AppVersion()throws EncryptedDocumentException, IOException
	{
		
		//select the OS
		crashPage.selectOS(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "androidOS"));
		
		//select the app version
		crashPage.selectAppVersion(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "androidAppVersion"));
		
		dashPage.validateWebRequestCount(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "WebRequestCountForAndroidAppVeriosn"));
	}
	
	@Test
	public void TC_105_validate_WebRequest_Count_For_Ios()throws EncryptedDocumentException, IOException
	{
		//select the OS
		crashPage.selectOS(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "IosOS"));
		
		//select the app version
		crashPage.selectAppVersion(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "AllAppversions"));
		
		dashPage.validateWebRequestCount(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "WebRequestCountForIos"));
	}
	
	@Test
	public void TC_106_validate_WebRequest_Count_For_Ios_With_Specific_AppVersion()throws EncryptedDocumentException, IOException
	{
		//select the OS
		crashPage.selectOS(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "IosOS"));
		
		//select the app version
		crashPage.selectAppVersion(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "IosAppVersion"));
		
		dashPage.validateWebRequestCount(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "WebRequestCountForIosAppVersion"));
	}
	
	@Test
	public void TC_107_validate_Http_Response_Time_For_All()throws EncryptedDocumentException, IOException
	{
		//select the OS
		crashPage.selectOS(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "AllOS"));
				
		//select the app version
		crashPage.selectAppVersion(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "AllAppversions"));
		
		dashPage.validateHttpResponseTime();
	}
	
	@Test
	public void TC_108_validate_Http_Response_Time_For_Android()throws EncryptedDocumentException, IOException
	{
		//select the OS
		crashPage.selectOS(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "androidOS"));
				
		//select the app version
		crashPage.selectAppVersion(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "AllAppversions"));
		
		dashPage.validateHttpResponseTime();
	}
	
	@Test
	public void TC_109_validate_Http_Response_Time_For_Ios()throws EncryptedDocumentException, IOException
	{
		//select the OS
		crashPage.selectOS(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "IosOS"));
				
		//select the app version
		crashPage.selectAppVersion(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "AllAppversions"));
		
		dashPage.validateHttpResponseTime();
	}
	
	@Test
	public void TC_110_validate_Error_Percentage_For_All()throws EncryptedDocumentException, IOException
	{
		//select the OS
		crashPage.selectOS(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "AllOS"));
				
		//select the app version
		crashPage.selectAppVersion(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "AllAppversions"));
		
		dashPage.validateErrorPercentage(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "errorRequestForAll"),
									eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "WebRequestCountForAll"));
	}
	
	
	
	@Test
	public void TC_111_validate_Error_Percentage_For_Android()throws EncryptedDocumentException, IOException
	{
		
		//select the OS
		crashPage.selectOS(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "androidOS"));
		
		//select the app version
		crashPage.selectAppVersion(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "AllAppversions"));
		
		dashPage.validateErrorPercentage(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "errorRequestForAndroid"),
				eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "WebRequestCountForAndroid"));
	}
	
	@Test
	public void TC_112_validate_Error_Percentage_For_Android_With_Specific_AppVersion()throws EncryptedDocumentException, IOException
	{
		
		//select the OS
		crashPage.selectOS(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "androidOS"));
		
		//select the app version
		crashPage.selectAppVersion(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "androidAppVersion"));
		
		dashPage.validateErrorPercentage(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "errorRequestForAndroidAppVersion"),
				eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "WebRequestCountForAndroidAppVeriosn"));
	}
	
	@Test
	public void TC_113_validate_Error_Percentage_For_Ios()throws EncryptedDocumentException, IOException
	{
		//select the OS
		crashPage.selectOS(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "IosOS"));
		
		//select the app version
		crashPage.selectAppVersion(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "AllAppversions"));
		
		dashPage.validateErrorPercentage(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "errorRequestForIos"),
				eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "WebRequestCountForIos"));
	}
	
	@Test
	public void TC_114_validate_Error_Percentage_For_Ios_With_Specific_AppVersion()throws EncryptedDocumentException, IOException
	{
		//select the OS
		crashPage.selectOS(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "IosOS"));
		
		//select the app version
		crashPage.selectAppVersion(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "IosAppVersion"));
		
		dashPage.validateErrorPercentage(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "WebRequestCountForIosAppVersion"),
				eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmLoadSheet, "errorRequestForIosAppversion"));
	}
	
	@Test
	public void TC_115_validate_The_Integration_Between_DashBraod_Crashes_With_Crashes_Page() throws EncryptedDocumentException, IOException
	{
		//select the OS
		crashPage.selectOS(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "AllOS"));
				
		//select the app version
		crashPage.selectAppVersion(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "AllAppversions"));
		
		dashPage.validateCrashesIntegration();
		
	}
	

	@Test
	public void TC_116_validate_The_Integration_Between_DashBraod_Error_Rate_With_Performance_Page()throws EncryptedDocumentException, IOException
	{
		//select the OS
		crashPage.selectOS(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "AllOS"));
				
		//select the app version
		crashPage.selectAppVersion(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath,IPathConstant.mmDashBoardSheet, "AllAppversions"));
		
		dashPage.validateErrorRateIntegration();

	}
	
	

}
