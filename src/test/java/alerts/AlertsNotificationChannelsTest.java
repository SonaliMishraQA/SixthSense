package alerts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import genericUtilities.ExcelUtility;
import genericUtilities.GenericMethods;
import genericUtilities.IPathConstant;
import objectRepository.Alerts.AlertsNotificationChannelsPage;
import playWrightFactory.BaseClass;

public class AlertsNotificationChannelsTest extends BaseClass{

	GenericMethods util = new GenericMethods();
	ExcelUtility excel = new ExcelUtility();
	AlertsNotificationChannelsPage notification;
	
	@BeforeMethod
	public void bmConfig() throws EncryptedDocumentException, IOException {
		notification = new AlertsNotificationChannelsPage(page);
		commPage.navigateToNotificationChannel();
		notification.validate_Navigation_To_Notification_Chnnels_Page();
	}
	
	@Test (groups = {"NotificationChannels", "UI", "Regression"})
	public void TC01_validate_Whether_The_Information_Message_Is_Displayed() throws EncryptedDocumentException, IOException  {
		notification.validateWhetherTheInformationMessageIsDisplayed();
	}
	
	@Test (groups = {"NotificationChannels", "UI", "Regression"})
	public void TC02_validate_Whether_The_Add_Channel_Button_Is_Displayed() throws EncryptedDocumentException, IOException  {
		notification.validateWhetherTheAddChannelButtonIsDisplayed();
	}
	
	@Test (groups = {"NotificationChannels", "UI", "Regression"})
	public void TC03_validate_Whether_The_Add_Channel_Button_Is_Working() throws EncryptedDocumentException, IOException  {
		notification.validateWhetherTheAddChannelButtonIsWorking();
	}
	
	@Test (groups = {"NotificationChannels", "UI", "Regression"})
	public void TC04_validate_Whether_The_Close_Button_In_The_Add_Channel_Popup_Window_Is_Working() throws EncryptedDocumentException, IOException  {
		notification.validateWhetherTheCloseButtonInTheAddChannelPopupWindowIsWorking();
	}
	
	@Test (groups = {"NotificationChannels", "UI", "Regression"})
	public void TC05_validate_The_First_Column_Name_Of_Notification_Channels_Table() throws EncryptedDocumentException, IOException  {
		notification.validateTheFirstColumnNameOfNotificationChannelsTable();
	}
	
	@Test (groups = {"NotificationChannels", "UI", "Regression"})
	public void TC06_validate_The_Second_Column_Name_Of_Notification_Channels_Table() throws EncryptedDocumentException, IOException  {
		notification.validateTheSecondColumnNameOfNotificationChannelsTable();
	}
	
	@Test (groups = {"NotificationChannels", "UI", "Regression"})
	public void TC07_validate_The_Third_Column_Name_Of_Notification_Channels_Table() throws EncryptedDocumentException, IOException  {
		notification.validateTheThirdColumnNameOfNotificationChannelsTable();
	}
	
	@Test (groups = {"NotificationChannels", "UI", "Regression"})
	public void TC08_validate_The_Fourth_Column_Name_Of_Notification_Channels_Table() throws EncryptedDocumentException, IOException  {
		notification.validateTheFourthColumnNameOfNotificationChannelsTable();
	}
	
	@Test (groups = {"NotificationChannels", "UI", "Regression"})
	public void TC09_validate_The_Fifth_Column_Name_Of_Notification_Channels_Table() throws EncryptedDocumentException, IOException  {
		notification.validateTheFifthColumnNameOfNotificationChannelsTable();
	}
	
	@Test (groups = {"NotificationChannels", "UI", "Regression"})
	public void TC10_validate_The_Ascending_Functionality_Of_Last_modified_Column_In_The_Notification_Channels_Table() {
		notification.validataTheAscendingFunctionalityOfLastModifiedColumnIntheTable();
	}
	
	@Test (groups = {"NotificationChannels", "UI", "Regression"})
	public void TC11_validate_The_Descending_Functionality_Of_Last_modified_Column_In_The_Notification_Channels_Table() {
		notification.validataTheDescendingFunctionalityOfLastModifiedColumnIntheTable();
	}

	@Test (groups = {"NotificationChannels", "UI", "Regression"})
	public void TC12_validate_The_Ascending_Functionality_Of_Created_On_Column_In_The_Notification_Channels_Table() {
		notification.validataTheAscendingFunctionalityOfCreatedOnColumnIntheTable();
	}
	
	@Test (groups = {"NotificationChannels", "UI", "Regression"})
	public void TC13_validate_The_Descending_Functionality_Of_Created_On_Column_In_The_Notification_Channels_Table() {
		notification.validataTheDescendingFunctionalityOfCreatedOnColumnIntheTable();
	}
	
	@Test (groups = {"NotificationChannels", "UI", "Regression"})
	public void TC14_validate_Whether_Search_Channels_TextField_Is_Displayed() throws EncryptedDocumentException, IOException {
		notification.validateWhetherTheSearchChannelsTextFieldIsPresent();
	}
	
	@Test (groups = {"NotificationChannels", "UI", "Regression"})
	public void TC15_validate_The_Functionality_Of_Search_Channels_For_Valid_Data() throws EncryptedDocumentException, IOException {
		notification.validateTheFunctionalityOfSearchChannelsForValidData();
	}
	
	@Test (groups = {"NotificationChannels", "UI", "Regression"})
	public void TC16_validate_The_Functionality_Of_Search_Channels_For_Invalid_Data() throws EncryptedDocumentException, IOException {
		notification.validateTheFunctionalityOfSearchChannelsForInvalidData();
	}
	
	@Test (groups = {"NotificationChannels", "UI", "Regression"})
	public void TC17_validate_The_Functionality_Of_Clear_Search_Button() throws EncryptedDocumentException, IOException {
		notification.validateTheFunctionalityOfClearSearchButton();
	}
	
	@Test (groups = {"NotificationChannels", "UI", "Regression"})
	public void TC18_validate_The_fields_In_Add_Channel_Popup_Window_For_Email() throws EncryptedDocumentException, IOException {
		notification.validateTheFieldsInAddChannelPopupWindowForEmail();
	}
	
	@Test (groups = {"NotificationChannels", "UI", "Regression"})
	public void TC19_validate_That_Default_Channel_Type_Is_Email_In_Add_Channel_Popup_Window() throws EncryptedDocumentException, IOException {
		notification.validateThatDefaultChannelTypeIsEmailInAddChannelPopupWindow();
	}
	
	@Test (groups = {"NotificationChannels", "UI", "Regression"})
	public void TC20_validate_Whether_The_Save_Button_Is_Disabled_Until_Mandatory_Fields_Are_Filled_In_Add_Channel_Popup_Window() throws EncryptedDocumentException, IOException {
		notification.validateWhetherTheSaveButtonIsDisabledUntilMandatoryFieldsAreFilledInAddChannelPopupWindow();
	}
	
	@Test (groups = {"NotificationChannels", "UI", "Regression"})
	public void TC21_validate_Whether_The_Save_Button_Is_Enabled_On_Filling_The_Mandatory_Fields_In_Add_Channel_Popup_Window() throws EncryptedDocumentException, IOException {
		notification.validateWhetherTheSaveButtonIsEnabledOnFillingTheMandatoryFieldsInAddChannelPopupWindow();
	}
	
	@Test (groups = {"NotificationChannels", "UI", "Regression"})
	public void TC22_validate_Whether_The_Clear_Button_Is_Enabled_In_Add_Channel_Popup_Window() throws EncryptedDocumentException, IOException {
		notification.validateWhetherTheClearButtonIsEnabledInAddChannelPopupWindow();
	}
	
	@Test (groups = {"NotificationChannels", "UI", "Regression"})
	public void TC23_validate_The_Functionality_Of_Clear_Button_For_Email_Address_In_Add_Channel_Popup_Window() throws EncryptedDocumentException, IOException {
		notification.validateTheFunctionalityOfClearButtonForEmailAddressInAddChannelPopupWindow();
	}
	
	@Test (groups = {"NotificationChannels", "UI", "Regression"})
	public void TC24_validate_The_Warning_Message_Shown_When_The_Channel_Name_Is_Left_Empty_In_Add_Channel_Popup_Window() throws EncryptedDocumentException, IOException {
		notification.validateTheWarningMessageShownWhenTheChannelNameIsLeftEmptyInAddChannelPopupWindow();
	}
	
	@Test (groups = {"NotificationChannels", "UI", "Regression"})
	public void TC25_validate_The_Warning_Message_Shown_When_The_Channel_Name_Has_A_Special_Character_In_Add_Channel_Popup_Window() throws EncryptedDocumentException, IOException {
		notification.validateTheWarningMessageShownWhenTheChannelNameHasASpecialCharacterInAddChannelPopupWindow();
	}
	
	@Test (groups = {"NotificationChannels", "UI", "Regression"})
	public void TC26_validate_The_Warning_Message_Shown_When_The_Channel_Name_Has_More_Than_50_Character_In_Add_Channel_Popup_Window() throws EncryptedDocumentException, IOException {
		notification.validateTheWarningMessageShownWhenTheChannelNameHasMoreThan50CharacterInAddChannelPopupWindow();
	}
	
	@Test (groups = {"NotificationChannels", "UI", "Regression"})
	public void TC27_validate_The_Warning_Message_Shown_When_Duplicate_Channel_Name_Is_Entered_In_Add_Channel_Popup_Window() throws EncryptedDocumentException, IOException {
		notification.validateTheWarningMessageShownWhenTheDuplicateChannelNameIsEnteredInAddChannelPopupWindow();
	}
	
	@Test (groups = {"NotificationChannels", "UI", "Regression"})
	public void TC28_validate_The_Options_Under_Channel_Type_Dropdown() throws EncryptedDocumentException, IOException {
		notification.validateTheOptionsUnderChannelTypeDropdown();
	}
	
	@Test (groups = {"NotificationChannels", "UI", "Regression"})
	public void TC29_validate_The_Email_Address_Information_Message_In_Add_Channel_Popup_Window() throws EncryptedDocumentException, IOException {
		notification.validateTheEmailAddressInformationMessageInAddChannelPopupWindow();
	}
	
	@Test (groups = {"NotificationChannels", "UI", "Regression"})
	public void TC30_validate_Whether_An_Email_Address_Can_Be_Added_Through_The_Email_Address_Textfield() throws EncryptedDocumentException, IOException {
		notification.validateWhetherAnEmailAddressCanBeAddedThroughTheEmailAddressTextfield();
	}
	
	@Test (groups = {"NotificationChannels", "UI", "Regression"})
	public void TC31_validate_The_Error_Message_By_Adding_An_Empty_Email_Address_In_Add_Channel_Popup_Window() throws EncryptedDocumentException, IOException {
		notification.validateTheErrorMessageByAddingAnEmptyEmailAddressInAddChannelPopupWindow();
	}
	
	@Test (groups = {"NotificationChannels", "UI", "Regression"})
	public void TC32_validate_The_Error_Message_By_Entering_An_Invalid_Email_Address_For_First_Mail_Id_In_Add_Channel_Popup_Window() throws EncryptedDocumentException, IOException {
		notification.validateTheErrorMessageByEnteringAnInvalidEmailAddressForFirstMailIdInAddChannelPopupWindow();
	}
	
	@Test (groups = {"NotificationChannels", "UI", "Regression"})
	public void TC33_validate_The_Error_Message_By_Entering_An_Invalid_Email_Address_For_Other_Than_First_Mail_Id_In_Add_Channel_Popup_Window() throws EncryptedDocumentException, IOException {
		notification.validateTheErrorMessageByEnteringAnInvalidEmailAddressForOtherThanFirstMailIdInAddChannelPopupWindow();
	}
	
	@Test (groups = {"NotificationChannels", "UI", "Regression"})
	public void TC34_validate_The_Error_Message_By_Entering_Duplicate_Email_Address_In_Add_Channel_Popup_Window() throws EncryptedDocumentException, IOException {
		notification.validateTheErrorMessageByEnteringDuplicateEmailAddressInAddChannelPopupWindow();
	}
	
	@Test (groups = {"NotificationChannels", "UI", "Regression"})
	public void TC35_validate_The_Deletion_Of_Email_Address_In_Add_Channel_Popup_Window() throws EncryptedDocumentException, IOException {
		notification.validateTheDeletionOfEmailAddressInAddChannelPopupWindow();
	}
	
	@Test (groups = {"NotificationChannels", "UI", "Regression"})
	public void TC36_validate_That_The_Maximum_Number_Of_Email_Addresses_That_Can_Be_Added_For_A_Channel_Is_50() throws EncryptedDocumentException, IOException {
		notification.validateThatTheMaximumNumberOfEmailAddressesThatCanBeAddedForAChannelIs50();
	}
	
	@Test (groups = {"NotificationChannels", "UI", "Regression"})
	public void TC37_validate_Creation_Of_Notification_Channel_For_Email() throws EncryptedDocumentException, IOException {
		notification.validateCreationOfNotificationChannelForEmail();
	}

	@Test (groups = {"NotificationChannels", "UI", "Regression"})
	public void TC38_validate_Whether_Created_Notification_Cahnnel_For_Email_Is_Reflecting_In_Alert_Creation() throws EncryptedDocumentException, IOException {
		notification.validateWhetherCreatedNotificationCahnnelForEmailIsReflectingInAlertCreation();
	}
	
	@Test (groups = {"NotificationChannels", "UI", "Regression"})
	public void TC39_validate_Selecting_Slack_As_Channel_Type() throws EncryptedDocumentException, IOException {
		notification.selectSlackAsCahnnelTypeAndValidate();
	}
	
	@Test (groups = {"NotificationChannels", "UI", "Regression"})
	public void TC40_validate_Whether_Slack_URL_Can_Be_Added_Through_The_Slack_URL_Textfield() throws EncryptedDocumentException, IOException {
		notification.validateWhetherSlackUrlCanBeAddedThroughTheSlackUrlTextfield();
	}
	
	@Test (groups = {"NotificationChannels", "UI", "Regression"})
	public void TC41_validate_The_Error_Message_By_Adding_An_Empty_Slack_URL_In_Add_Channel_Popup_Window() throws EncryptedDocumentException, IOException {
		notification.validateTheErrorMessageByAddingAnEmptySlackUrlInAddChannelPopupWindow();
	}
	
	@Test (groups = {"NotificationChannels", "UI", "Regression"})
	public void TC42_validate_The_Error_Message_By_Entering_An_Invalid_Slack_URL_For_First_URL_In_Add_Channel_Popup_Window() throws EncryptedDocumentException, IOException {
		notification.validateTheErrorMessageByEnteringAnInvalidSlackUrlForFirstUrlInAddChannelPopupWindow();
	}
	
	@Test (groups = {"NotificationChannels", "UI", "Regression"})
	public void TC43_validate_The_Error_Message_By_Entering_An_Invalid_Slack_URL_For_Other_Than_First_URL_In_Add_Channel_Popup_Window() throws EncryptedDocumentException, IOException {
		notification.validateTheErrorMessageByEnteringAnInvalidSlackUrlForOtherThanFirstUrlInAddChannelPopupWindow();
	}
	
	@Test (groups = {"NotificationChannels", "UI", "Regression"})
	public void TC44_validate_The_Error_Message_By_Entering_Duplicate_Slack_URL_In_Add_Channel_Popup_Window() throws EncryptedDocumentException, IOException {
		notification.validateTheErrorMessageByEnteringDuplicateSlackUrlInAddChannelPopupWindow();
	}
	
	@Test (groups = {"NotificationChannels", "UI", "Regression"})
	public void TC45_validate_The_Deletion_Of_Slack_URL_In_Add_Channel_Popup_Window() throws EncryptedDocumentException, IOException {
		notification.validateTheDeletionOfSlackUrlInAddChannelPopupWindow();
	}
	
	@Test (groups = {"NotificationChannels", "UI", "Regression"})
	public void TC46_validate_That_The_Maximum_Number_Of_Slack_URLs_That_Can_Be_Added_For_A_Channel_Is_50() throws EncryptedDocumentException, IOException {
		notification.validateThatTheMaximumNumberOfSlackUrlsThatCanBeAddedForAChannelIs50();
	}

	@Test (groups = {"NotificationChannels", "UI", "Regression"})
	public void TC47_validate_The_Functionality_Of_Clear_Button_For_Slack_URL_In_Add_Channel_Popup_Window() throws EncryptedDocumentException, IOException {
		notification.validateTheFunctionalityOfClearButtonForSlackUrlInAddChannelPopupWindow();
	}
	
	@Test (groups = {"NotificationChannels", "UI", "Regression"})
	public void TC48_validate_Creation_Of_Notification_Channel_For_Slack() throws EncryptedDocumentException, IOException {
		notification.validateCreationOfNotificationChannelForSlack();
	}
	
	@Test (groups = {"NotificationChannels", "UI", "Regression"})
	public void TC49_validate_Whether_Created_Notification_Cahnnel_For_Slack_Is_Reflecting_In_Alert_Creation() throws EncryptedDocumentException, IOException {
		notification.validateWhetherCreatedNotificationCahnnelForSlackIsReflectingInAlertCreation();
	}
	
	@Test (groups = {"NotificationChannels", "UI", "Regression"})
	public void TC50_validate_Selecting_Webhook_As_Channel_Type() throws EncryptedDocumentException, IOException {
		notification.selectWebhookAsCahnnelTypeAndValidate();
	}
	
	@Test (groups = {"NotificationChannels", "UI", "Regression"})
	public void TC51_validate_The_Data_Information_Message_For_Webhhook_In_Add_Channel_Popup_Window() throws EncryptedDocumentException, IOException {
		notification.validateTheDataInformationMessageForWebhhookInAddChannelPopupWindow();
	}
	
	@Test (groups = {"NotificationChannels", "UI", "Regression"})
	public void TC52_validate_Whether_Webhook_URL_Can_Be_Added_Through_The_Webhook_URL_Textfield() throws EncryptedDocumentException, IOException {
		notification.validateWhetherWebhookUrlCanBeAddedThroughTheWebhookUrlTextfield();
	}
	
	@Test (groups = {"NotificationChannels", "UI", "Regression"})
	public void TC53_validate_The_Error_Message_By_Adding_An_Empty_Webhook_URL_In_Add_Channel_Popup_Window() throws EncryptedDocumentException, IOException {
		notification.validateTheErrorMessageByAddingAnEmptyWebhookUrlInAddChannelPopupWindow();
	}
	
	@Test (groups = {"NotificationChannels", "UI", "Regression"})
	public void TC54_validate_The_Error_Message_By_Entering_An_Invalid_Webhook_URL_For_First_URL_In_Add_Channel_Popup_Window() throws EncryptedDocumentException, IOException {
		notification.validateTheErrorMessageByEnteringAnInvalidWebhookUrlForFirstUrlInAddChannelPopupWindow();
	}
	
	@Test (groups = {"NotificationChannels", "UI", "Regression"})
	public void TC55_validate_The_Error_Message_By_Entering_An_Invalid_Webhook_URL_For_Other_Than_First_URL_In_Add_Channel_Popup_Window() throws EncryptedDocumentException, IOException {
		notification.validateTheErrorMessageByEnteringAnInvalidWebhookUrlForOtherThanFirstUrlInAddChannelPopupWindow();
	}
	
	@Test (groups = {"NotificationChannels", "UI", "Regression"})
	public void TC56_validate_The_Error_Message_By_Entering_Duplicate_Webhook_URL_In_Add_Channel_Popup_Window() throws EncryptedDocumentException, IOException {
		notification.validateTheErrorMessageByEnteringDuplicateWebhookUrlInAddChannelPopupWindow();
	}
	
	@Test (groups = {"NotificationChannels", "UI", "Regression"})
	public void TC57_validate_The_Deletion_Of_Webhook_URL_In_Add_Channel_Popup_Window() throws EncryptedDocumentException, IOException {
		notification.validateTheDeletionOfWebhookUrlInAddChannelPopupWindow();
	}
	
	@Test (groups = {"NotificationChannels", "UI", "Regression"})
	public void TC58_validate_The_Functionality_Of_Clear_Button_For_Webhook_URL_In_Add_Channel_Popup_Window() throws EncryptedDocumentException, IOException {
		notification.validateTheFunctionalityOfClearButtonForWebhookUrlInAddChannelPopupWindow();
	}
	
	@Test (groups = {"NotificationChannels", "UI", "Regression"})
	public void TC59_validate_That_The_Maximum_Number_Of_Webhook_URLs_That_Can_Be_Added_For_A_Channel_Is_50() throws EncryptedDocumentException, IOException {
		notification.validateThatTheMaximumNumberOfWebhookUrlsThatCanBeAddedForAChannelIs50();
	}

	@Test (groups = {"NotificationChannels", "UI", "Regression"})
	public void TC60_validate_The_Data_Header_Text_For_Webhook_In_Add_Channel_Popup_Window() throws EncryptedDocumentException, IOException {
		notification.validateTheDataHeaderTextForWebhookInAddChannelPopupWindow();
	}
	
	@Test (groups = {"NotificationChannels", "UI", "Regression"})
	public void TC61_validate_The_Color_Of_Data_Keys_For_Webhook_In_Add_Channel_Popup_Window() throws EncryptedDocumentException, IOException {
		notification.validateTheColorOfDataKeys();
	}
	
	@Test (groups = {"NotificationChannels", "UI", "Regression"})
	public void TC62_validate_The_Color_Of_Data_Values_For_Webhook_In_Add_Channel_Popup_Window() throws EncryptedDocumentException, IOException {
		notification.validateTheColorOfDataValues();
	}
	
	@Test (groups = {"NotificationChannels", "UI", "Regression"})
	public void TC63_validate_The_Selection_Of_Tagging_Checkbox() throws EncryptedDocumentException, IOException {
		notification.validateTheSelectionOfTaggingCheckbox();
	}
	
	@Test (groups = {"NotificationChannels", "UI", "Regression"})
	public void TC64_validate_The_Headers_Of_Supported_Webhook_Valiables_Field_Header_Text() throws EncryptedDocumentException, IOException {
		notification.validateTheHeadersOfSupportedWebhookValiablesFieldHeaderText();
	}
	
	@Test (groups = {"NotificationChannels", "UI", "Regression"})
	public void TC65_validate_The_Supported_Webhook_Variables_List() throws EncryptedDocumentException, IOException {
		notification.validateTheSupportedWebhookVariablesList();
	}
	
	@Test (groups = {"NotificationChannels", "UI", "Regression"})
	public void TC66_validate_The_Supported_Webhook_Variables_List_With_Tagging_Selected() throws EncryptedDocumentException, IOException {
		notification.validateTheSupportedWebhookVariablesListWithTaggingSelected();
	}
	
	@Test (groups = {"NotificationChannels", "UI", "Regression"})
	public void TC67_validate_Creation_Of_Notification_Channel_For_Webhook() throws EncryptedDocumentException, IOException {
		notification.validateCreationOfNotificationChannelForWebhook();
	}
	
	@Test (groups = {"NotificationChannels", "UI", "Regression"})
	public void TC68_validate_Whether_Created_Notification_Cahnnel_For_Webhook_Is_Reflecting_In_Alert_Creation() throws EncryptedDocumentException, IOException {
		notification.validateWhetherCreatedNotificationCahnnelForWebhookIsReflectingInAlertCreation();
	}
	
	@Test (groups = {"NotificationChannels", "UI", "Regression"})
	public void TC69_validate_The_Functionality_Of_Edit_Button_Under_Action_Column_In_The_Notification_Channel_Table() throws EncryptedDocumentException, IOException {
		notification.validateTheFunctionalityOfEditButtonUnderActionColumn();
	}
	
	@Test (groups = {"NotificationChannels", "UI", "Regression"})
	public void TC70_validate_The_Functionality_Of_Update_Button_In_Edit_Channel_Popup_Window() throws EncryptedDocumentException, IOException {
		notification.validateTheFunctionalityOfUpdateButtonInEditChannelPopupWindow();
	}
	
	@Test (groups = {"NotificationChannels", "UI", "Regression"})
	public void TC71_validate_The_Functionality_Of_Delete_Button_Under_Action_Column_In_The_Notification_Channel_Table() throws EncryptedDocumentException, IOException {
		notification.validateTheFunctionalityOfDeleteButtonUnderActionColumn();
	}
	
	@Test (groups = {"NotificationChannels", "UI", "Regression"})
	public void TC72_validate_The_Warning_Message_While_Deleting_A_Notification_Channel_Associated_With_Alerts() throws EncryptedDocumentException, IOException {
		notification.validateTheWarningMessageWhileDeletingNotificationChannelAssociatedWithAlerts();
	}
	
	@Test (groups = {"NotificationChannels", "UI", "Regression"})
	public void TC73_validate_The_Deletion_Of_Notification_Channels() throws EncryptedDocumentException, IOException {
		notification.validateTheDeletionOfNotificationChannels();
	}
	
	@Test (groups = {"NotificationChannels", "UI", "Regression"})
	public void TC74_validate_the_Error_Message_On_Keeping_Data_Empty_For_Webhook_In_Add_Channel_Popup_Window() throws EncryptedDocumentException, IOException {
		notification.clearDataSectionInAddChannelPopupWindowAndValidate();
	}
	
	@Test (groups = {"NotificationChannels", "UI", "Regression"})
	public void TC75_validate_the_Creation_Of_Notification_Channel_For_Webhook_With_Edited_Json_Body() throws EncryptedDocumentException, IOException {
		notification.createWebhookNotificationChannelWithEditedJsonAndValidate();
	}
	
	@Test (dataProvider = "pagination", groups = {"APM","UI","Regression"})
	public void TC76_validate_Pagination(String num) {
		notification.validatePagination(Integer.parseInt(num));
	}
	
	@DataProvider 
	public Object[][] pagination() throws Exception, Exception {
		return excel.fetchAllTheDataFromExcelSheet(IPathConstant.commExcelPath, IPathConstant.commonPaginationSheet);
	}
	
	@AfterMethod
	public void amConfig() {
		notification.closeThePopupIfPresent();
	}
}
