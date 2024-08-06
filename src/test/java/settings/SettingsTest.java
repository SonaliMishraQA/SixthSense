package settings;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import genericUtilities.ExcelUtility;
import genericUtilities.IPathConstant;
import objectRepository.SettingsPage;
import playWrightFactory.BaseClass;

public class SettingsTest extends BaseClass{
	SettingsPage setPage;
	ExcelUtility  eutil=new ExcelUtility();
	@BeforeMethod
	public void preRequest()
	{
		 setPage=new SettingsPage(page);
	}
	
	@Test
	public void TC_01_validate_Settings_SideNav_Tab()
	{
		//click on the setting side nav btn and validate the URL
		commPage.navigateToSettings();
		
		setPage.validateTheSettingsPage();
	}
	
	@Test
	public void TC_02_validate_The_General_Tab_is_Displaying_Default_Tab_Or_Not() throws EncryptedDocumentException, IOException
	{
		//click on the setting side nav btn and validate the URL
		commPage.navigateToSettings();
		
		setPage.validateTheGeneralTabIsDisplayingDefault(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.settingsExcelPath,IPathConstant.settingsSheet ,"AccessTokenTabSubHeaderText"));
	}
	
	@Test
	public void TC_03_validate_Setting_Page_Title_And_Icon() throws EncryptedDocumentException, IOException
	{
		//click on the setting side nav btn and validate the URL
		commPage.navigateToSettings();
		
		setPage.validateTheSettingsPageTitle(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.settingsExcelPath,IPathConstant.settingsSheet ,"PageTitle"));
	}
	
	@Test
	public void TC_04_validate_General_Tab()
	{
		//click on the setting side nav btn and validate the URL
		commPage.navigateToSettings();
		setPage.navigateToGeneralTab();
	}
	
	@Test
	public void TC_05_validate_Copy_Access_Token_Tab()
	{
		//click on the setting side nav btn and validate the URL
		commPage.navigateToSettings();
		
		//navigate the general tab
		setPage.navigateToGeneralTab();
		
		//validate the copy button
		setPage.validateCopyBtn();
	}

	
	@Test
	public void TC_06_validate_Show_Access_Token_Tab() throws EncryptedDocumentException, IOException
	{
		//click on the setting side nav btn and validate the URL
		commPage.navigateToSettings();
		
		//navigate the general tab
		setPage.navigateToGeneralTab();

		//validate the show access btn
		setPage.validateShowAccessBtn(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.settingsExcelPath,IPathConstant.settingsSheet ,"AccessToken"));
	}
	
	@Test
	public void TC_07_validate_Hide_Access_Token_Tab() throws EncryptedDocumentException, IOException
	{
		//click on the setting side nav btn and validate the URL
		commPage.navigateToSettings();
		
		setPage.navigateToApplicationTab();
		
		//navigate the general tab
		setPage.navigateToGeneralTab();
		
		//validate hide access token btn
		setPage.validateHideAccessTokenBtn(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.settingsExcelPath,IPathConstant.settingsSheet ,"hideAccessBtnText"));
	}
	
	@Test
	public void TC_08_validate_Accounts_Tab()
	{
		//click on the setting side nav btn and validate the URL
		commPage.navigateToSettings();
		
		//validate general tab
		setPage.validateAccountsTab();
	}
	
	@Test
	public void TC_09_validate_Labels_In_Account_Tab() throws EncryptedDocumentException, IOException
	{
		//click on the setting side nav btn and validate the URL
		commPage.navigateToSettings();
		
		//validate general tab
		setPage.validateAccountsTab();
		
		setPage.validateAccountsPage(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.settingsExcelPath,IPathConstant.settingsSheet ,"accountPageLabel"));
	}
	
	@Test
	public void TC_10_validate_Save_Button_Disabled_Or_Not_Without_Any_Data()
	{
		//click on the setting side nav btn and validate the URL
		commPage.navigateToSettings();
		
		//validate general tab
		setPage.validateAccountsTab();
		
		setPage.validateSaveBtn();
	}
	
	@Test
	public void TC_11_validate_Change_Password_Without_Special_Character() throws EncryptedDocumentException, IOException
	{
		//click on the setting side nav btn and validate the URL
		commPage.navigateToSettings();
		
		//validate general tab
		setPage.validateAccountsTab();
		
		setPage.validateChangePassword(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.settingsExcelPath,IPathConstant.settingsSheet ,"changePasswordWithoutSpecialCharacters"));
	}
	
	@Test
	public void TC_12_validate_Change_Password_Without_Capital_Letter()throws EncryptedDocumentException, IOException
	{
		//click on the setting side nav btn and validate the URL
		commPage.navigateToSettings();
		
		//validate general tab
		setPage.validateAccountsTab();
		
		setPage.validateChangePassword(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.settingsExcelPath,IPathConstant.settingsSheet ,"changePasswordWithoutCapitalLetter"));
	}
	
	@Test
	public void TC_13_validate_Change_Password_Without_Small_Letter()throws EncryptedDocumentException, IOException
	{
		//click on the setting side nav btn and validate the URL
		commPage.navigateToSettings();
		
		//validate general tab
		setPage.validateAccountsTab();
		
		setPage.validateChangePassword(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.settingsExcelPath,IPathConstant.settingsSheet ,"changePasswordWithoutSamllLetter"));
	}
	
	@Test
	public void TC_14_validate_Change_Password_Without_NUmeric_Character()throws EncryptedDocumentException, IOException
	{
		//click on the setting side nav btn and validate the URL
		commPage.navigateToSettings();
		
		//validate general tab
		setPage.validateAccountsTab();
		
		setPage.validateChangePassword(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.settingsExcelPath,IPathConstant.settingsSheet ,"changePasswordWithoutNumber"));
	}
	
	@Test
	public void TC_15_validate_Change_Password_Without_Alphabets()throws EncryptedDocumentException, IOException
	{
		//click on the setting side nav btn and validate the URL
		commPage.navigateToSettings();
		
		//validate general tab
		setPage.validateAccountsTab();
		
		setPage.validateChangePassword(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.settingsExcelPath,IPathConstant.settingsSheet ,"changePasswordWithoutAlphabet"));
	}
	
	@Test
	public void TC_16_validate_Change_Password_Without_Minium_Length()throws EncryptedDocumentException, IOException
	{
		//click on the setting side nav btn and validate the URL
		commPage.navigateToSettings();
		
		//validate general tab
		setPage.validateAccountsTab();
		
		setPage.validateChangePassword(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.settingsExcelPath,IPathConstant.settingsSheet ,"changePasswordWithoutminiumLenght"));
	}

	@Test
	public void TC_17_validate_Change_Password_By_Giving_Wrong_Old_Password() throws EncryptedDocumentException, IOException
	{
		//click on the setting side nav btn and validate the URL
		commPage.navigateToSettings();
		
		//validate general tab
		setPage.validateAccountsTab();
		
		setPage.validateChangePasswordWithWrongOldPassword(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.settingsExcelPath,IPathConstant.settingsSheet ,"ErrorMessageForWrongPassword"));
	}
	

	@Test
	public void TC_18_validate_Change_Password_By_Giving_Different_Enter_And_ReEnter_Passwords()
	{
		//click on the setting side nav btn and validate the URL
		commPage.navigateToSettings();
		
		//validate general tab
		setPage.validateAccountsTab();
		
		setPage.validateChangePasswordWithDifferentReEnterPassword();
	}
	
	@Test
	public void TC_19_validate_TimeZone_Tab()
	{
		//click on the setting side nav btn and validate the URL
		commPage.navigateToSettings();
		
		setPage.validateTimeZoneTab();
	}
	
	@Test
	public void TC_20_validate_Choose_Time_Zone_Dropdown_Values() throws EncryptedDocumentException, IOException
	{
		//click on the setting side nav btn and validate the URL
		commPage.navigateToSettings();
		
		setPage.validateTimeZoneTab();
		
		setPage.validateTimeZoneOptions(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.settingsExcelPath,IPathConstant.settingsSheet ,"TimeZoneOptions"));
	}
	
	@Test
	public void TC_21_validate_Time_Zone_By_Selecting_Any_Zone() throws EncryptedDocumentException, IOException
	{
		//click on the setting side nav btn and validate the URL
		commPage.navigateToSettings();
		
		setPage.validateTimeZoneTab();
		
		setPage.validateTimeZoneForMumbai(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.settingsExcelPath,IPathConstant.settingsSheet ,"mumbaiTimeZone"),
				eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.settingsExcelPath,IPathConstant.settingsSheet ,"SuccessMessageForTimeZone"));
	}
	

	@Test
	public void TC_22_validate_Application_Tab()
	{
		//click on the setting side nav btn and validate the URL
		commPage.navigateToSettings();
		
		setPage.navigateToApplicationTab();
	}
	
	@Test
	public void TC_23_validate_Apdex_Configuration_Tab() throws EncryptedDocumentException, IOException
	{
		//click on the setting side nav btn and validate the URL
		commPage.navigateToSettings();
		
		setPage.navigateToApplicationTab();
		
		setPage.validateApdexConfigurationPage();
	}
	

	@Test
	public void TC_24_validate_Threshold_Response_Conformation_Popup() throws EncryptedDocumentException, IOException
	{
		//navigate to setting capability
		commPage.navigateToSettings();
		
		//navigate to the application  page		
		setPage.navigateToApplicationPage();
		
		setPage.setTheApdexConfigurationWithGivenResponseTime(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.apmApplicationSheet, "APMResponseTime"),
															eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.apmApplicationSheet, "application"),
															eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath, IPathConstant.messageSheet, "Settings_ResponseTimeThresholdValue"),IPathConstant.alertsAPMCapability);

	}
	
	@Test
	public void TC_25_validate_DataRetention_Policy_Page_Elements()
	{
		//navigate to setting capability
		commPage.navigateToSettings();
		
		//navigate to the application  page		
		setPage.navigateToApplicationPage();
		
		setPage.validateDataRetentionPolicyPage();
	}
	
	@Test
	public void TC_26_validate_Trace_Retention_Configuration_Tab_Display_By_Default()
	{
		//navigate to setting capability
		commPage.navigateToSettings();
		
		//navigate to the application  page		
		setPage.navigateToApplicationPage();
		
		setPage.validateTraceRetentionTab();
	}
	
	@Test
	public void TC_27_validate_Min_Trace_Latency_Confirmation_Popup() throws EncryptedDocumentException, IOException
	{
		//navigate to setting capability
		commPage.navigateToSettings();
				
		//navigate to the application  page		
		setPage.navigateToApplicationPage();
		
		//set the trace latency 
		setPage.setTraceLatency(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.apmApplicationSheet, "miniumTracelatency"),
				eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.apmApplicationSheet, "maximumSpans"),
				eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath, IPathConstant.messageSheet, "Settings-Teace Retention message"),
				eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.apmApplicationSheet, "application"));

	}
	
	@Test
	public void TC_28_validate_Max_Spans_Per_trace_Confirmation_Popup() throws EncryptedDocumentException, IOException	
	{
		//navigate to setting capability
		commPage.navigateToSettings();
				
		//navigate to the application  page		
		setPage.navigateToApplicationPage();
		
		//set the trace latency 
		setPage.setMaximumSpans(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.apmApplicationSheet, "miniumTracelatency"),
				eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.apmApplicationSheet, "maximumSpans"),
				eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath, IPathConstant.messageSheet, "Settings-Teace Retention message"),
				eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.apmApplicationSheet, "application"));

	}
	
	@Test
	public void TC_29_validate_Retain_All_Error_Traces_Slider()
	{
		//navigate to setting capability
		commPage.navigateToSettings();
		
		//navigate to the application  page		
		setPage.navigateToApplicationPage();
		
		setPage.validateDataRetentionPolicyPage();
		
		
		setPage.validateRetainAllErrorCheckBox();
	}
	
	@Test
	public void TC_30_validate_DB_Query_Configuration_Tab() throws EncryptedDocumentException, IOException
	{
		//navigate to setting capability
		commPage.navigateToSettings();
		
		//navigate to the application  page		
		setPage.navigateToApplicationPage();
		
		setPage.validateDataRetentionPolicyPage();
		
		setPage.validateTheDBQueryConfigurationPage();
	}
	
	
	@Test
	public void TC_31_validate_Minimum_DB_Query_Latency_In_DB_Query_Config() throws EncryptedDocumentException, IOException
	{
		//navigate to setting capability
		commPage.navigateToSettings();
						
		//navigate to the application  page		
		setPage.navigateToApplicationPage();
		
		//set the trace latency 
		setPage.setDBQueryLatency(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.apmApplicationSheet, "miniumTracelatency"),
						eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath, IPathConstant.messageSheet, "Settings-Teace Retention message"),
						eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.apmApplicationSheet, "application"));

	}
	
	@Test
	public void TC_32_validate_Brand_Name_In_Footer()
	{
		//navigate to setting capability
		commPage.navigateToSettings();
		
		setPage.validateTheFooter();
		
	}
	
	@Test
	public void TC_33_validate_Change_Password_With_Valid_Data() throws EncryptedDocumentException, IOException
	{

		setPage.loginToTheDemoUserAccount();
		
		//click on the setting side nav btn and validate the URL
		commPage.navigateToSettings();
		
		//validate general tab
		setPage.navigateToAccountsPage();
		
		setPage.changePassword();
		
		//click on the setting side nav btn and validate the URL
		commPage.navigateToSettings();
	}
	
	

	
	


	
	
	

}
