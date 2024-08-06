package mobileMonitoringCapability;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import genericUtilities.ExcelUtility;
import genericUtilities.GenericMethods;
import genericUtilities.IPathConstant;
import objectRepository.MM.MMCrashesPage;
import objectRepository.MM.MMUsagePage;
import playWrightFactory.BaseClass;

public class MMUsageTest extends BaseClass {
	
	MMUsagePage usagePage;
	GenericMethods util;
	ExcelUtility eutil;
	MMCrashesPage crashPage;
	
	@BeforeMethod
	public void preRequests() throws EncryptedDocumentException, IOException, InterruptedException
	{
		util=new GenericMethods();
		usagePage=new MMUsagePage(page);
		eutil=new ExcelUtility();
		crashPage=new MMCrashesPage(page);
		
		//Navigate to mobileMonitoring capability
		commPage.navigateToMobileMonitoring();
					
		//select the Time line 
		commPage.selectTheTimeLineFromCalender(IPathConstant.sixHoursTimeRange);
		
		//select the Application
		crashPage.selectTheApplicationForMM(util.getvalueFromexcel(IPathConstant.MMexcelPath,IPathConstant.mmCrashesSheet, "application"));
		
		//select the OS
		crashPage.selectOS("All");
		
		//select the app version
		crashPage.selectAppVersion("All");
		
		//navigate to usage page
		usagePage.validateTheUsagePage();
		
		
	}	
	
	@Test
	public void TC_01_validate_Usage_Page_Displaying_By_Default_Or_Not()
	{
		//Navigate to mobileMonitoring capability
		commPage.navigateToMobileMonitoring();
		
		usagePage.validateTheUsagePage();
		
	}
	
	@Test
	public void TC_02_validate_The_Active_Sessions_Widget_Title() throws EncryptedDocumentException, IOException
	{
		usagePage.validateActiveSessionTitle(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath, IPathConstant.mmUsageSheet, "ActiveSessionGraphTitle"));
	}
	
	@Test
	public void TC_03_validate_The_Active_Sessions_Widget_Xaxis_Title() throws EncryptedDocumentException, IOException
	{
		usagePage.validateActiveSessionXaxisTitle(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath, IPathConstant.mmUsageSheet, "WidgetXaxisTitle"));
	}
	
	@Test
	public void TC_04_validate_The_Active_Sessions_Widget_Yaxis_Title() throws EncryptedDocumentException, IOException
	{
		usagePage.validateActiveSessionYaxisTitle(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath, IPathConstant.mmUsageSheet, "ActiveSessionGraphYaxisTitle"));
	}
	
	@Test
	public void TC_05_validate_The_Active_Sessions_Widget_ZoomIn_Button()
	{
	
		usagePage.validateActiveSessionsZoomIn();
	}
	
	@Test
	public void TC_06_validate_The_Active_Sessions_Widget_Zoomout_Button()
	{
		usagePage.validateActiveSessionsZoomout();
	}
	
	@Test
	public void TC_07_validate_The_Active_Sessions_Widget_ZoommReset_Button()
	{
		usagePage.validateActiveSessionsZoomReset();
	}
	
	@Test
	public void TC_08_validate_The_Active_Sessions_Widget_Drag_And_Drop_Xaxis()
	{
		usagePage.validateActiveSessionsDragAndDrop();
	}
	
	@Test
	public void TC_09_validate_The_Active_Sessions_Widget_ToolTip_Title_By_Hover() throws InterruptedException
	{
		usagePage.validateActiveSessionWidgetToolTip();
	}
	
	@Test
	public void TC_10_validate_The_App_Launches_Widget_Title() throws EncryptedDocumentException, IOException
	{
		usagePage.validateAppLaunchesTitle(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath, IPathConstant.mmUsageSheet, "AppLaunchesGrapghTitle"));
	}
	
	@Test
	public void TC_11_validate_The_App_Launches_Widget_Xaxis_Title() throws EncryptedDocumentException, IOException
	{
		usagePage.validateAppLaunchesXaxisTitle(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath, IPathConstant.mmUsageSheet, "WidgetXaxisTitle"));
	}
	
	@Test
	public void TC_12_validate_The_App_Launches_Widget_Yaxis_Title() throws EncryptedDocumentException, IOException
	{
		usagePage.validateAppLaunchesYaxisTitle(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath, IPathConstant.mmUsageSheet, "AppLaunchesGrapghYaxisTitle"));
	}
	
	@Test
	public void TC_13_validate_The_App_Launches_Widget_ZoomIn_Button()
	{
		usagePage.validateAppLaunchesZoomIn();
	}
	
	@Test
	public void TC_14_validate_The_App_Launches_Widget_Zoomout_Button()
	{
		usagePage.validateAppLaunchesZoomout();
	}
	
	@Test
	public void TC_15_validate_The_App_Launches_Widget_ZoommReset_Button()
	{
		usagePage.validateAppLaunchesZoomReset();
	}
	
	@Test
	public void TC_16_validate_The_App_Launches_Widget_Drag_And_Drop_Xaxis()
	{
		usagePage.validateAppLaunchesDragAndDrop();
	}
	
	@Test
	public void TC_17_validate_The_App_Launches_Widget_ToolTip_Title_By_Hover() throws InterruptedException
	{
		usagePage.validateAppLaunchesWidgetToolTip();
	}
	
	@Test
	public void TC_18_validate_The_New_Users_Widget_Title() throws EncryptedDocumentException, IOException
	{
		usagePage.validateNewUsersTitle(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath, IPathConstant.mmUsageSheet, "NewUsersGraphTitle"));
	}
	
	@Test
	public void TC_19_validate_The_New_Users_Widget_Xaxis_Title() throws EncryptedDocumentException, IOException
	{
		usagePage.validateNewUsersXaxisTitle(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath, IPathConstant.mmUsageSheet, "WidgetXaxisTitle"));
	}
	
	@Test
	public void TC_20_validate_The_New_Users_Widget_Yaxis_Title() throws EncryptedDocumentException, IOException
	{
		usagePage.validateNewUsersYaxisTitle(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath, IPathConstant.mmUsageSheet, "NewUsersGraphYaxisTitle"));
	}
	
	@Test
	public void TC_21_validate_The_New_Users_Widget_ZoomIn_Button()
	{
		usagePage.validateNewUsersZoomIn();
	}
	
	@Test
	public void TC_22_validate_The_New_Users_Widget_Zoomout_Button()
	{
		usagePage.validateNewUsersZoomout();
	}
	
	@Test
	public void TC_23_validate_The_New_Users_Widget_ZoommReset_Button()
	{
		usagePage.validateNewUsersZoomReset();
	}
	
	@Test
	public void TC_24_validate_The_New_Users_Widget_Drag_And_Drop_Xaxis()
	{
		usagePage.validateNewUsersDragAndDrop();
	}
	
	@Test
	public void TC_25_validate_The_New_Users_Widget_ToolTip_Title_By_Hover() throws InterruptedException
	{
		usagePage.validateNewUsersWidgetToolTip();
	}
	
	
	@Test
	public void TC_26_validate_The_App_Version_Distribution_Top4_Widget_Title() throws EncryptedDocumentException, IOException
	{
		usagePage.validateAppVersionsTitle(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath, IPathConstant.mmUsageSheet, "AppVersionGraphTitle"));
	}
	
	@Test
	public void TC_27_validate_The_App_Version_Distribution_Top4_Widget_Xaxis_Title() throws EncryptedDocumentException, IOException
	{
		usagePage.validateAppVersionsXaxisTitle(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath, IPathConstant.mmUsageSheet, "WidgetXaxisTitle"));
	}
	
	@Test
	public void TC_28_validate_The_App_Version_Distribution_Top4_Widget_Yaxis_Title() throws EncryptedDocumentException, IOException
	{
		usagePage.validateAppVersionsYaxisTitle(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath, IPathConstant.mmUsageSheet, "AppVersionGraphYaxisTitle"));
	}
	
	@Test
	public void TC_29_validate_The_App_Version_Distribution_Top4_Widget_ZoomIn_Button()
	{
		usagePage.validateAppVersionsZoomIn();
	}
	
	@Test
	public void TC_30_validate_The_App_Version_Distribution_Top4_Widget_Zoomout_Button()
	{
		usagePage.validateAppVersionsZoomout();
	}
	
	@Test
	public void TC_31_validate_The_App_Version_Distribution_Top4_Widget_ZoommReset_Button()
	{
		usagePage.validateAppVersionsZoomReset();
	}
	
	@Test
	public void TC_32_validate_The_App_Version_Distribution_Top4_Widget_Drag_And_Drop_Xaxis()
	{
		usagePage.validateAppVersionsDragAndDrop();
	}
	
	@Test
	public void TC_33_validate_The_App_Version_Distribution_Top4_Widget_ToolTip_Title_By_Hover() throws InterruptedException
	{
		usagePage.validateAppVersionsWidgetToolTip();
	}
	
	@Test
	public void TC_34_validate_The_App_Version_Distribution_Top4_Widget_Legends_Text() throws EncryptedDocumentException, IOException
	{
		usagePage.validateWidgetLegendsTextForAppVersionDistributionGraph(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath, IPathConstant.mmUsageSheet, "AppVersionGraphLegendsList"));
	}
	
	@Test
	public void TC_35_validate_The_App_Version_Distribution_Top4_Widget_Legends()
	{
		usagePage.validateAppVersionDistributionwidgetLegends();
	}

	@Test
	public void TC_36_validate_The_Usage_By_Os_Widget_Title() throws EncryptedDocumentException, IOException
	{
		usagePage.validateUsageByOsTitle(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath, IPathConstant.mmUsageSheet, "UsageBYOsGraphTitle"));
	}
	
	@Test
	public void TC_37_validate_The_Usage_By_Os_Widget_Xaxis_Title() throws EncryptedDocumentException, IOException
	{
		usagePage.validateUsageByOsXaxisTitle(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath, IPathConstant.mmUsageSheet, "WidgetXaxisTitle"));
	}
	
	@Test
	public void TC_38_validate_The_Usage_By_Os_Widget_Yaxis_Title() throws EncryptedDocumentException, IOException
	{
		usagePage.validateUsageByOsYaxisTitle(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath, IPathConstant.mmUsageSheet, "UsageBYOsGraphYaxisTitle"));
	}
	
	@Test
	public void TC_39_validate_The_Usage_By_Os_Widget_ZoomIn_Button()
	{
		usagePage.validateUsageByOsZoomIn();
	}
	
	@Test
	public void TC_40_validate_The_Usage_By_Os_Widget_Zoomout_Button()
	{
		usagePage.validateUsageByOsZoomout();
	}
	
	@Test
	public void TC_41_validate_The_Usage_By_Os_Widget_ZoommReset_Button()
	{
		usagePage.validateUsageByOsZoomReset();
	}
	
	@Test
	public void TC_42_validate_The_Usage_By_Os_Widget_Drag_And_Drop_Xaxis()
	{
		usagePage.validateUsageByOsDragAndDrop();
	}
	
	@Test
	public void TC_43_validate_The_Usage_By_Os_Widget_ToolTip_Title_By_Hover() throws InterruptedException
	{
		usagePage.validateUsageByOsWidgetToolTip();
	}

	@Test
	public void TC_44_validate_The_Usage_By_Os_Widget_Widget_Legends_Text() throws EncryptedDocumentException, IOException
	{
		usagePage.validateWidgetLegendsTextForUsageByOSGraph(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath, IPathConstant.mmUsageSheet, "UsageByOsLegendsList"));
	}
	
	@Test
	public void TC_45_validate_The_Usage_By_Os_Widget_Widget_Legends() throws EncryptedDocumentException, IOException
	{
		usagePage.validateUsageByOswidgetLegends();
	}

	@Test
	public void TC_46_validate_The_Usage_By_Device_Widget_Title() throws EncryptedDocumentException, IOException
	{
		usagePage.validateUsageByDeviceTitle(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath, IPathConstant.mmUsageSheet, "UsageBYDeviceGraphTitle"));
	}
	
	@Test
	public void TC_47_validate_The_Usage_By_Device_Widget_Xaxis_Title() throws EncryptedDocumentException, IOException
	{
		usagePage.validateUsageByDeviceXaxisTitle(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath, IPathConstant.mmUsageSheet, "WidgetXaxisTitle"));
	}
	
	@Test
	public void TC_48_validate_The_Usage_By_Device_Widget_Yaxis_Title() throws EncryptedDocumentException, IOException
	{
		usagePage.validateUsageByDeviceYaxisTitle(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath, IPathConstant.mmUsageSheet, "UsageBYDeviceGraphYaxisTitle"));
	}
	
	@Test
	public void TC_49_validate_The_Usage_By_Device_Widget_ZoomIn_Button()
	{
		usagePage.validateUsageByDeviceZoomIn();
	}
	
	@Test
	public void TC_50_validate_The_Usage_By_Device_Widget_Zoomout_Button()
	{
		usagePage.validateUsageByDeviceZoomout();
	}
	
	@Test
	public void TC_51_validate_The_Usage_By_Device_Widget_ZoommReset_Button()
	{
		usagePage.validateUsageByDeviceZoomReset();
	}
	
	@Test
	public void TC_52_validate_The_Usage_By_Device_Widget_Drag_And_Drop_Xaxis()
	{
		usagePage.validateUsageByDeviceDragAndDrop();
	}
	
	@Test
	public void TC_53_validate_The_Usage_By_Device_Widget_ToolTip_Title_By_Hover() throws InterruptedException
	{
		usagePage.validateUsageByDeviceWidgetToolTip();
	}
	

	@Test
	public void TC_54_validate_The_Usage_By_Device_Widget_Widget_Legends_Text() throws EncryptedDocumentException, IOException
	{
		usagePage.validateWidgetLegendsTextForUsageByDeviceGraph(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath, IPathConstant.mmUsageSheet, "UsageByDeviceLegendsList"));
	}
	
	@Test
	public void TC_55_validate_The_Usage_By_Device_Widget_Widget_Legends()
	{
		usagePage.validateUsageByDevicewidgetLegends();
	}
	

	@Test
	public void TC_56_validate_The_Crashes_Widget_Data_By_Selecting_5Mins_TimeLine()
	{
		//select the time line from calander
		commPage.selectTheTimeLineFromCalender(IPathConstant.fiveMinutesTimeRange);

		//Validate whether the widgets are displaying the proper time line or not
		usagePage.validateTheGivenTimeLine();
		
	}
	@Test
	public void TC_57_validate_The_Crashes_Widget_Data_By_Selecting_15Mins_TimeLine()
	{
		//select the time line from calander
		commPage.selectTheTimeLineFromCalender(IPathConstant.fifteenMinutesTimeRange);

		//Validate whether the widgets are displaying the proper time line or not
		usagePage.validateTheGivenTimeLine();
		
	}
	
	@Test
	public void TC_58_validate_The_Crashes_Widget_Data_By_Selecting_30Mins_TimeLine()
	{
		//select the time line from calander
		commPage.selectTheTimeLineFromCalender(IPathConstant.thirtyMinutesTimeRange);

		//Validate whether the widgets are displaying the proper time line or not
		usagePage.validateTheGivenTimeLine();
		
	}
	
	@Test
	public void TC_59_validate_The_Crashes_Widget_Data_By_Selecting_60Mins_TimeLine()
	{
		//select the time line from calander
		commPage.selectTheTimeLineFromCalender(IPathConstant.sixtyMinutesTimeRange);

		//Validate whether the widgets are displaying the proper time line or not
		usagePage.validateTheGivenTimeLine();
		
	}
	
	@Test
	public void TC_60_validate_The_Crashes_Widget_Data_By_Selecting_3hours_TimeLine()
	{
		//select the time line from calander
		commPage.selectTheTimeLineFromCalender(IPathConstant.threeHoursTimeRange);

		//Validate whether the widgets are displaying the proper time line or not
		usagePage.validateTheGivenTimeLine();
		
	}
	
	@Test
	public void TC_61_validate_The_Crashes_Widget_Data_By_Selecting_6hours_TimeLine()
	{
		//select the time line from calander
		commPage.selectTheTimeLineFromCalender(IPathConstant.sixHoursTimeRange);

		//Validate whether the widgets are displaying the proper time line or not
		usagePage.validateTheGivenTimeLine();
	}
	
	@Test
	public void TC_62_validate_The_Crashes_Widget_Data_By_Selecting_12hours_TimeLine()
	{
		//select the time line from calander
		commPage.selectTheTimeLineFromCalender(IPathConstant.twelveHoursTimeRange);

		//Validate whether the widgets are displaying the proper time line or not
		usagePage.validateTheGivenTimeLine();
	}
	
	@Test
	public void TC_63_validate_The_Crashes_Widget_Data_By_Selecting_1day_TimeLine()
	{
		//select the time line from calander
		commPage.selectTheTimeLineFromCalender(IPathConstant.oneDayTimeRange);

		//Validate whether the widgets are displaying the proper time line or not
		usagePage.validateTheGivenTimeLine();
	}
	
	@Test
	public void TC_64_validate_The_Crashes_Widget_Data_By_Selecting_1week_TimeLine()
	{
		//select the time line from calander
		commPage.selectTheTimeLineFromCalender(IPathConstant.oneWeekTimeRange);

		//Validate whether the widgets are displaying the proper time line or not
		usagePage.validateTheGivenTimeLine();
	}
	
	@Test
	public void TC_65_validate_The_Crashes_Widget_Data_By_Selecting_1month_TimeLine()
	{
		//select the time line from calander
		commPage.selectTheTimeLineFromCalender(IPathConstant.oneMonthTimeRange);

		//Validate whether the widgets are displaying the proper time line or not
		usagePage.validateTheGivenTimeLine();
	}
	
	@Test
	public void TC_66_validate_The_Crashes_Widget_By_selecting_custom_Time_For_Minutes_Range() throws EncryptedDocumentException, IOException
	{
		//select the time line from calander
		commPage.selectTheCustomeTimeLine(IPathConstant.customTimeRange, eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customMinutesRange") );
		
		usagePage.validateTheCustomTimeLine(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customMinutesRange"));
		
	}
	
	
	@Test
	public void TC_67_validate_The_Crashes_Widget_By_selecting_custom_Time_For_Hours_Range() throws EncryptedDocumentException, IOException
	{
		//select the time line from calander
		commPage.selectTheCustomeTimeLine(IPathConstant.customTimeRange, eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customHoursRange"));
		
		usagePage.validateTheCustomTimeLine(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customHoursRange"));
		
	}
	
	@Test
	public void TC_68_validate_The_Crashes_Widget_By_selecting_custom_Time_For_Days_Range() throws EncryptedDocumentException, IOException
	{
		//select the time line from calander
		commPage.selectTheCustomeTimeLine(IPathConstant.customTimeRange, eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customDaysRange"));
		
		usagePage.validateTheCustomTimeLine(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customDaysRange"));
		
	}
	
	@Test
	public void TC_69_validate_The_Crashes_Widget_By_selecting_custom_Time_For_Future_date()
	{
		//select the future time line from calander
		commPage.validateTheFutureTimeLine();
		
	}
	
	
	
	
	
	

}
