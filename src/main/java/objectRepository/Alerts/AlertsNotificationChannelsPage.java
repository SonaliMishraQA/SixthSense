package objectRepository.Alerts;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Locale;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import genericUtilities.ExcelUtility;
import genericUtilities.GenericMethods;
import genericUtilities.IPathConstant;
import objectRepository.CommonPage;
import objectRepository.HomePage;

public class AlertsNotificationChannelsPage {
	Page page;

	ExcelUtility excel = new ExcelUtility();
	GenericMethods util = new GenericMethods();
	CommonPage common;
	AlertsPage alerts;
	
    private String notificationChannelsTitle = "#title-text-notification";
    private String addChannelButton = "#btn-add-channel\\;";
    private String informationMessageNotificationChannel = "xpath = //div[@class='channelTop']/*[@class='left']";
    private String popupWindowTitle = "xpath = //div[@class='rex-modal-header-box']";
    private String popupWindowCloseBtn = "xpath = //button[@class='ant-modal-close']";
    private String saveBtn = "#btn-submit-channel";
    private String emailInfoMessage = "xpath = //div[@class='noti-add-channel-info']";
    private String clearBtn = "#btn-clr-channel";
    private String channelNameTextField= "#input-channel-name";
    private String channelNameErrorMessage = "xpath = //div[@class='sm mb-2']/following-sibling::span";
    private String channelTypeDropdown = "xpath = //div[@id='search-select-add-list-channel']/div[@class='selected-item-text']";
    private String channelTypeDropdownOptions = "xpath = //div[@class='option']";
    private String emailAddressTextField = "#input-widget-url";
    private String plusButton = "#btn-add-channel-path";
    private String emailErrorMessage = "xpath = //div[@class='noti-add-channel-type-err-msg']";
    private String searchTextfield = "xpath = //input[@class='search-box']";
    private String searchIcon = "#btn-search";
    private String clearSearchBtn = "#btn-clear-search";
    private String addDashboardBtn = "#btn-add-dashboard";
    private String popupWindowFieldsTitles = "xpath = //label[@class='cus-mod-label']";
    private String addedEmailAddresses = "xpath = //div[@class='ellipsis-redirect']";
    private String emailAddressDeleteBtns = "xpath = //div[@class='ellipsis-redirect']/../following-sibling::div//button[@class='action-btn']";
    private String confirmationMessage = "//div[@class='ant-notification-notice-with-icon']";
    private String messageCloseBtn = "xpath = //span[@class='ant-notification-close-x']";
    private String firstColumn = "xpath = (//div[@class='data-table']//div[@class='test'])[1]";
    private String secondColumn = "xpath = (//div[@class='data-table']//div[@class='test'])[2]";
    private String thirdColumn = "xpath = (//div[@class='data-table']//div[@class='test'])[3]";
    private String fourthColumn = "xpath = (//div[@class='data-table']//div[@class='test'])[4]";
    private String fifthColumn = "xpath = (//div[@class='data-table']//div[@class='test'])[5]";
    private String firstChannelName = "#redirect-0-0";
    private String channelNamesColumnData = "xpath = //div[@Class='table-row']//div[contains(@id,'-0') and not(contains(@id,'0-')) or @id='redirect-0-0']";
    private String channelTypesColumnData = "xpath = //div[@Class='table-row']//div[contains(@id,'-1') and not(contains(@id,'1-')) or @id='redirect-1-1']";
    private String lastModifiedColumnData = "xpath = //div[@Class='table-row']//div[contains(@id,'-2') and not(contains(@id,'2-')) or @id='redirect-2-2']";
    private String createdOnColumnData = "xpath = //div[@Class='table-row']//div[contains(@id,'-3') and not(contains(@id,'3-')) or @id='redirect-3-3']";
    private String editBtns = "#edit_filled";
    private String deleteBtns = "#delete_filled";
    private String lastModifiedAsc = "#sort-lastUpdatedAt-asc";
    private String lastModifiedDes = "#sort-lastUpdatedAt-des";
    private String createdOnAsc = "#sort-createdAt-asc";
    private String createdOnDes = "#sort-createdAt-des";
    private String deleteChannelPopupMessge = "xpath = //div[@class='noti-delete-info-label']";
    private String alertInfoInDeleteChannelPopup = "xpath = //div[@class='alert-v2-delete-channel-info-label']";
    private String viewTaggedAlertsLink = "xpath = //div[@class='view-tagged-alert']";
    private String taggedAlerts = "xpath = //span[@class='noti-rules-table-header-total']";
    private String dataInfoMessage = "xpath = //div[@class='json-data-info-text']";
    private String dataHeaderText = "xpath = //div[@class='data-header-text']";
    private String dataKeys = "xpath = //div[@class='cm-line']/span[1]";
    private String dataValues = "xpath = //div[@class='cm-line']/span[2]";
    private String dataTextArea = "xpath = //*[name()='textarea' and @class='ace_text-input']";
    private String taggingCheckbox = "#rex-toggle-curvey";
    private String taggingBtn = "xpath = //span[@class='slider round']";
    private String webhookVariablesHeader = "xpath = //div[@class='header-slot-default']";
    private String webhookVariables = "xpath = //div[@class='row-box']//tr[@class='body-tr body-tr-secondary']/td[1]";
    private String webhookVariableDescriptions = "xpath = //div[@class='row-box']//tr[@class='body-tr body-tr-secondary']/td[2]";
    private String leftParanthesis = "xpath = //span[@class='ace_paren ace_lparen']";
    private String rightParanthesis = "xpath = //span[@class='ace_paren ace_rparen']";
    private String dataFieldElements = "xpath = //div[@class='cm-line']";
    private String dataErrorMark = "xpath = //div[@class='ace_gutter-cell  ace_error']";
    private String noDataIcon = "xpath = //div[@class='inner-text']";
    private String invalidJsonMsg = "xpath = //div[@class='data-field-box']//p";

    public AlertsNotificationChannelsPage(Page page) {
    	this.page = page;
    	common = new CommonPage(this.page);
    	alerts = new AlertsPage(this.page);
    }
    
    public void validate_Navigation_To_Notification_Chnnels_Page() throws EncryptedDocumentException, IOException {
    	page.isVisible(addChannelButton);
    	String title = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.notificationChannelsExcelPath, IPathConstant.notificationChannelsSheet, "NotificationChannelPageTitle");
    	util.ValidateTheTitle(page, notificationChannelsTitle, title);
    }
    
    public void validateWhetherTheInformationMessageIsDisplayed() throws EncryptedDocumentException, IOException {
    	String expectedMsg = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath, IPathConstant.messageSheet, "NotificationCahnnel_InformationMessgae");
		util.ValidateTheTitle(page, informationMessageNotificationChannel, expectedMsg);
    }
    
    public void validateWhetherTheAddChannelButtonIsDisplayed() throws EncryptedDocumentException, IOException {
    	page.isVisible(addChannelButton);
    	String expectedMsg = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.notificationChannelsExcelPath, IPathConstant.notificationChannelsSheet, "AddChannelBtnTitle");
		util.ValidateTheTitle(page, addChannelButton, expectedMsg);
    }
    
    public void validateWhetherTheAddChannelButtonIsWorking() throws EncryptedDocumentException, IOException {
    	navigateToAddChannelPopupWindow();
    	String expectedMsg = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.notificationChannelsExcelPath, IPathConstant.notificationChannelsSheet, "AddChannelPopupWindowTitle");
		util.ValidateTheTitle(page, popupWindowTitle, expectedMsg);
		page.click(popupWindowCloseBtn);
    }
    
    public void validateWhetherTheCloseButtonInTheAddChannelPopupWindowIsWorking() throws EncryptedDocumentException, IOException {
    	navigateToAddChannelPopupWindow();
    	String expectedMsg = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.notificationChannelsExcelPath, IPathConstant.notificationChannelsSheet, "AddChannelPopupWindowTitle");
		util.ValidateTheTitle(page, popupWindowTitle, expectedMsg);
		page.click(popupWindowCloseBtn);
		validateWhetherTheAddChannelButtonIsDisplayed();
    }
    
    public void validateTheFirstColumnNameOfNotificationChannelsTable() throws EncryptedDocumentException, IOException {
    	String title = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.notificationChannelsExcelPath, IPathConstant.notificationChannelsSheet, "firstColumnName");
    	util.ValidateTheTitle(page, firstColumn, title);
    }
    
    public void validateTheSecondColumnNameOfNotificationChannelsTable() throws EncryptedDocumentException, IOException {
    	String title = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.notificationChannelsExcelPath, IPathConstant.notificationChannelsSheet, "secondColumnName");
    	util.ValidateTheTitle(page, secondColumn, title);
    }
    
    public void validateTheThirdColumnNameOfNotificationChannelsTable() throws EncryptedDocumentException, IOException {
    	String title = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.notificationChannelsExcelPath, IPathConstant.notificationChannelsSheet, "thirdColumnName");
    	util.ValidateTheTitle(page, thirdColumn, title);
    }
    
    public void validateTheFourthColumnNameOfNotificationChannelsTable() throws EncryptedDocumentException, IOException {
    	String title = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.notificationChannelsExcelPath, IPathConstant.notificationChannelsSheet, "fourthColumnName");
    	util.ValidateTheTitle(page, fourthColumn, title);
    }
    
    public void validateTheFifthColumnNameOfNotificationChannelsTable() throws EncryptedDocumentException, IOException {
    	String title = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.notificationChannelsExcelPath, IPathConstant.notificationChannelsSheet, "fifthColumnName");
    	util.ValidateTheTitle(page, fifthColumn, title);
    }
    
    public void validataTheAscendingFunctionalityOfLastModifiedColumnIntheTable() {
    	page.click(lastModifiedAsc);
    	page.waitForTimeout(1000);
    	DateTimeFormatter formatter = new DateTimeFormatterBuilder().parseCaseInsensitive().appendPattern("MMM dd, yyyy").toFormatter(Locale.ENGLISH);
        DateTimeFormatter formatter1 = new DateTimeFormatterBuilder().parseCaseInsensitive().appendPattern("dd/MM/yyyy").toFormatter(Locale.ENGLISH);
            boolean flag = false;
            Locator lastModifiedDates = page.locator(lastModifiedColumnData);
    		if(lastModifiedDates.count() != 0)
            {
                int count = lastModifiedDates.count()-1;
                for(int i=0; i<lastModifiedDates.count()-1; i++)
                {
                    String text1 = lastModifiedDates.nth(i).textContent().trim().substring(0, lastModifiedDates.nth(i).textContent().trim().indexOf("By")-2);
                    String date1 = formatter1.format(formatter.parse(text1));
                    //System.out.println(date1);
                    String[] time1 = date1.split("/");
                    String text2 = lastModifiedDates.nth(i+1).textContent().trim().substring(0, lastModifiedDates.nth(i+1).textContent().trim().indexOf("By")-2);
                    String date2 = formatter1.format(formatter.parse(text2));
                    //System.out.println(date2);
                    String[] time2 = date2.split("/");

                    for(int j=2; j>=0; j--) {
                        if(Integer.parseInt(time1[j]) < Integer.parseInt(time2[j])) {
                            flag = true;
                            break;
                        }else if(Integer.parseInt(time1[j]) > Integer.parseInt(time2[j])) {
                            flag = false;
                            break;
                        } else {
                            flag = true;
                            continue;}
                    }
                    if(flag==true)
                    count--;
                }
                //System.out.println(count);
                Assert.assertTrue(count == 0);
            }
    }
    
    public void validataTheDescendingFunctionalityOfLastModifiedColumnIntheTable() {
    	page.click(lastModifiedDes);
    	page.waitForTimeout(1000);
    	DateTimeFormatter formatter = new DateTimeFormatterBuilder().parseCaseInsensitive().appendPattern("MMM dd, yyyy").toFormatter(Locale.ENGLISH);
        DateTimeFormatter formatter1 = new DateTimeFormatterBuilder().parseCaseInsensitive().appendPattern("dd/MM/yyyy").toFormatter(Locale.ENGLISH);
            boolean flag = false;
            Locator lastModifiedDates = page.locator(lastModifiedColumnData);
    		if(lastModifiedDates.count() != 0)
            {
                int count = lastModifiedDates.count()-1;
                for(int i=0; i<lastModifiedDates.count()-1; i++)
                {
                    String text1 = lastModifiedDates.nth(i).textContent().trim().substring(0, lastModifiedDates.nth(i).textContent().trim().indexOf("By")-2);
                    String date1 = formatter1.format(formatter.parse(text1));
                    //System.out.println(date1);
                    String[] time1 = date1.split("/");
                    String text2 = lastModifiedDates.nth(i+1).textContent().trim().substring(0, lastModifiedDates.nth(i+1).textContent().trim().indexOf("By")-2);
                    String date2 = formatter1.format(formatter.parse(text2));
                    //System.out.println(date2);
                    String[] time2 = date2.split("/");

                    for(int j=2; j>=0; j--) {
                        if(Integer.parseInt(time1[j]) > Integer.parseInt(time2[j])) {
                            flag = true;
                            break;
                        }else if(Integer.parseInt(time1[j]) < Integer.parseInt(time2[j])) {
                            flag = false;
                            break;
                        } else {
                            flag = true;
                            continue;}
                    }
                    if(flag==true)
                    count--;
                }
                //System.out.println(count);
                Assert.assertTrue(count == 0);
            }
    }
    
    public void validataTheAscendingFunctionalityOfCreatedOnColumnIntheTable() {
    	page.locator(fourthColumn).hover();
    	page.click(createdOnAsc);
    	page.waitForTimeout(1000);
    	DateTimeFormatter formatter = new DateTimeFormatterBuilder().parseCaseInsensitive().appendPattern("MMM dd, yyyy").toFormatter(Locale.ENGLISH);
        DateTimeFormatter formatter1 = new DateTimeFormatterBuilder().parseCaseInsensitive().appendPattern("dd/MM/yyyy").toFormatter(Locale.ENGLISH);
            boolean flag = false;
            Locator createdOnDates = page.locator(createdOnColumnData);
    		if(createdOnDates.count() != 0)
            {
                int count = createdOnDates.count()-1;
                for(int i=0; i<createdOnDates.count()-1; i++)
                {
                    String text1 = createdOnDates.nth(i).textContent().trim();
                    String date1 = formatter1.format(formatter.parse(text1));
                    //System.out.println(date1);
                    String[] time1 = date1.split("/");
                    String text2 = createdOnDates.nth(i+1).textContent().trim();
                    String date2 = formatter1.format(formatter.parse(text2));
                    //System.out.println(date2);
                    String[] time2 = date2.split("/");

                    for(int j=2; j>=0; j--) {
                        if(Integer.parseInt(time1[j]) < Integer.parseInt(time2[j])) {
                            flag = true;
                            break;
                        }else if(Integer.parseInt(time1[j]) > Integer.parseInt(time2[j])) {
                            flag = false;
                            break;
                        } else {
                            flag = true;
                            continue;}
                    }
                    if(flag==true)
                    count--;
                }
                //System.out.println(count);
                Assert.assertTrue(count == 0);
            }
    }
    
    public void validataTheDescendingFunctionalityOfCreatedOnColumnIntheTable() {
    	page.locator(fourthColumn).hover();
    	page.click(createdOnDes);
    	page.waitForTimeout(1000);
    	DateTimeFormatter formatter = new DateTimeFormatterBuilder().parseCaseInsensitive().appendPattern("MMM dd, yyyy").toFormatter(Locale.ENGLISH);
        DateTimeFormatter formatter1 = new DateTimeFormatterBuilder().parseCaseInsensitive().appendPattern("dd/MM/yyyy").toFormatter(Locale.ENGLISH);
            boolean flag = false;
            Locator createdOnDates = page.locator(createdOnColumnData);
    		if(createdOnDates.count() != 0)
            {
                int count = createdOnDates.count()-1;
                for(int i=0; i<createdOnDates.count()-1; i++)
                {
                    String text1 = createdOnDates.nth(i).textContent().trim();
                    String date1 = formatter1.format(formatter.parse(text1));
                    //System.out.println(date1);
                    String[] time1 = date1.split("/");
                    String text2 = createdOnDates.nth(i+1).textContent().trim();
                    String date2 = formatter1.format(formatter.parse(text2));
                    //System.out.println(date2);
                    String[] time2 = date2.split("/");

                    for(int j=2; j>=0; j--) {
                        if(Integer.parseInt(time1[j]) > Integer.parseInt(time2[j])) {
                            flag = true;
                            break;
                        }else if(Integer.parseInt(time1[j]) < Integer.parseInt(time2[j])) {
                            flag = false;
                            break;
                        } else {
                            flag = true;
                            continue;}
                    }
                    if(flag==true)
                    count--;
                }
                //System.out.println(count);
                Assert.assertTrue(count == 0);
            }
    }
    
    public void validateWhetherTheSearchChannelsTextFieldIsPresent() throws EncryptedDocumentException, IOException {
    	String expectedText = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.notificationChannelsExcelPath, IPathConstant.notificationChannelsSheet, "searchChannelTextfieldPlaceholderText");
    	String actualText = page.getAttribute(searchTextfield, "placeholder");
    	util.ValidateTheTitle(actualText, expectedText);
    }
    
    public void validateTheFunctionalityOfSearchChannelsForValidData() {
    	util.validateSearchFunctionalityWithValidData(page, channelNamesColumnData, searchTextfield, searchIcon, channelNamesColumnData);
    }
    
    public void validateTheFunctionalityOfSearchChannelsForInvalidData() {
    	util.validateSearchFunctionalityWithInvalidData(page, searchTextfield, searchIcon, noDataIcon);
    }
    
    public void validateTheFunctionalityOfClearSearchButton() throws EncryptedDocumentException, IOException {
    	page.fill(searchTextfield, excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.notificationChannelsExcelPath, IPathConstant.notificationChannelsSheet, "channelNameToUpadte"));
    	page.click(searchIcon);
    	page.click(clearSearchBtn);
    	validateWhetherTheSearchChannelsTextFieldIsPresent();
    }
    
    public void validateTheFieldsInAddChannelPopupWindowForEmail() throws EncryptedDocumentException, IOException {
    	navigateToAddChannelPopupWindow();
    	String[] titles = { excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.notificationChannelsExcelPath, IPathConstant.notificationChannelsSheet, "channelNameFieldtitle"),
    						excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.notificationChannelsExcelPath, IPathConstant.notificationChannelsSheet, "channelTypeFieldtitle"),
    						excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.notificationChannelsExcelPath, IPathConstant.notificationChannelsSheet, "supportedWebhookVariablesFieldtitle"),
    						excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.notificationChannelsExcelPath, IPathConstant.notificationChannelsSheet, "enterEmailAddressFieldtitle")};
    	Locator fieldTitles = page.locator(popupWindowFieldsTitles);
    	for (String title : titles) {
			boolean flag = false;
			for(int i=0; i<fieldTitles.count(); i++) {
				if(fieldTitles.nth(i).textContent().trim().equalsIgnoreCase(title)) {
					flag = true;
					break;
				}
			}
			Assert.assertTrue(flag);
		}
    	String actualPlaceholder = page.getAttribute(emailAddressTextField, "placeholder");
    	String expectedPlaceholder = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.notificationChannelsExcelPath, IPathConstant.notificationChannelsSheet, "enterEmailAddressPlaceholder");
    	Assert.assertTrue(actualPlaceholder.equalsIgnoreCase(expectedPlaceholder));
    	page.click(popupWindowCloseBtn);
    }
    
    public void validateTheFieldsInAddChannelPopupWindowForSlack() throws EncryptedDocumentException, IOException {
    	String[] titles = { excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.notificationChannelsExcelPath, IPathConstant.notificationChannelsSheet, "channelNameFieldtitle"),
    						excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.notificationChannelsExcelPath, IPathConstant.notificationChannelsSheet, "channelTypeFieldtitle"),
    						excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.notificationChannelsExcelPath, IPathConstant.notificationChannelsSheet, "supportedWebhookVariablesFieldtitle"),
    						excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.notificationChannelsExcelPath, IPathConstant.notificationChannelsSheet, "enterSlackUrlFieldtitle")};
    	Locator fieldTitles = page.locator(popupWindowFieldsTitles);
    	for (String title : titles) {
			boolean flag = false;
			for(int i=0; i<fieldTitles.count(); i++) {
				if(fieldTitles.nth(i).textContent().trim().equalsIgnoreCase(title)) {
					flag = true;
					break;
				}
			}
			Assert.assertTrue(flag);
		}
    	String actualPlaceholder = page.getAttribute(emailAddressTextField, "placeholder");
    	String expectedPlaceholder = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.notificationChannelsExcelPath, IPathConstant.notificationChannelsSheet, "enterSlackUrlPlaceholder");
    	Assert.assertTrue(actualPlaceholder.equalsIgnoreCase(expectedPlaceholder));
    }
    
    public void validateTheFieldsInAddChannelPopupWindowForWebhook() throws EncryptedDocumentException, IOException {
    	String[] titles = { excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.notificationChannelsExcelPath, IPathConstant.notificationChannelsSheet, "channelNameFieldtitle"),
    						excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.notificationChannelsExcelPath, IPathConstant.notificationChannelsSheet, "channelTypeFieldtitle"),
    						excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.notificationChannelsExcelPath, IPathConstant.notificationChannelsSheet, "supportedWebhookVariablesFieldtitle"),
    						excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.notificationChannelsExcelPath, IPathConstant.notificationChannelsSheet, "enterWebhookUrlFieldtitle"),
    						excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.notificationChannelsExcelPath, IPathConstant.notificationChannelsSheet, "dataFieldtitle")};
    	Locator fieldTitles = page.locator(popupWindowFieldsTitles);
    	for (String title : titles) {
			boolean flag = false;
			for(int i=0; i<fieldTitles.count(); i++) {
				if(fieldTitles.nth(i).textContent().trim().equalsIgnoreCase(title)) {
					flag = true;
					break;
				}
			}
			Assert.assertTrue(flag);
		}
    	String actualPlaceholder = page.getAttribute(emailAddressTextField, "placeholder");
    	String expectedPlaceholder = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.notificationChannelsExcelPath, IPathConstant.notificationChannelsSheet, "enterWebhookUrlPlaceholder");
    	Assert.assertTrue(actualPlaceholder.equalsIgnoreCase(expectedPlaceholder));
    }
    
    public void validateThatDefaultChannelTypeIsEmailInAddChannelPopupWindow() throws EncryptedDocumentException, IOException {
    	navigateToAddChannelPopupWindow();
    	String expectedType = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.notificationChannelsExcelPath, IPathConstant.notificationChannelsSheet, "channelType_default");
    	util.ValidateTheTitle(page, channelTypeDropdown, expectedType);
    	page.click(popupWindowCloseBtn);
    }
    
    public void validateWhetherTheSaveButtonIsDisabledUntilMandatoryFieldsAreFilledInAddChannelPopupWindow() {
    	navigateToAddChannelPopupWindow();
    	Assert.assertTrue(page.isDisabled(saveBtn));
    	page.click(popupWindowCloseBtn);
    }
    
    public void validateWhetherTheSaveButtonIsEnabledOnFillingTheMandatoryFieldsInAddChannelPopupWindow() throws EncryptedDocumentException, IOException {
    	String[] data = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.notificationChannelsExcelPath, IPathConstant.notificationChannelsSheet, "addChannel_ForEmail").split(",");
    	navigateToAddChannelPopupWindow();
    	page.fill(channelNameTextField, data[0]);
    	page.fill(emailAddressTextField, data[1]);
    	page.click(plusButton);
    	Assert.assertTrue(page.isEnabled(saveBtn));
    	page.click(popupWindowCloseBtn);
    }
    
    public void validateWhetherTheClearButtonIsEnabledInAddChannelPopupWindow() {
    	navigateToAddChannelPopupWindow();
    	System.out.println(page.isEnabled(clearBtn));
    	Assert.assertTrue(page.isEnabled(clearBtn));
    	page.click(popupWindowCloseBtn);
    }
    
    public void validateTheFunctionalityOfClearButtonForEmailAddressInAddChannelPopupWindow() throws EncryptedDocumentException, IOException {
    	String[] data = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.notificationChannelsExcelPath, IPathConstant.notificationChannelsSheet, "addChannel_ForEmail").split(",");
    	navigateToAddChannelPopupWindow();
    	page.fill(channelNameTextField, data[0]);
    	page.fill(emailAddressTextField, data[1]);
    	page.click(plusButton);
    	Assert.assertTrue(page.locator(addedEmailAddresses).nth(0).textContent().trim().equals(data[1]));
    	page.click(clearBtn);
    	Assert.assertTrue(page.locator(addedEmailAddresses).count() == 0);
    	page.click(popupWindowCloseBtn);
    }
    
    public void validateTheFunctionalityOfClearButtonForSlackUrlInAddChannelPopupWindow() throws EncryptedDocumentException, IOException {
    	String[] data = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.notificationChannelsExcelPath, IPathConstant.notificationChannelsSheet, "addChannel_ForSlack").split(",");
    	navigateToAddChannelPopupWindow();
    	page.fill(channelNameTextField, data[0]);
       	util.selectTheOptionFromDropDown(page, channelTypeDropdown, excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.notificationChannelsExcelPath, IPathConstant.notificationChannelsSheet, "channelType_slack"));
       	page.fill(emailAddressTextField, data[1]);
    	page.click(plusButton);
    	Assert.assertTrue(page.locator(addedEmailAddresses).nth(0).textContent().trim().equals(data[1]));
    	page.click(clearBtn);
    	Assert.assertTrue(page.locator(addedEmailAddresses).count() == 0);
    	page.click(popupWindowCloseBtn);
    }
    
    public void validateTheFunctionalityOfClearButtonForWebhookUrlInAddChannelPopupWindow() throws EncryptedDocumentException, IOException {
    	String[] data = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.notificationChannelsExcelPath, IPathConstant.notificationChannelsSheet, "addChannel_ForWebhook").split(",");
    	navigateToAddChannelPopupWindow();
    	page.fill(channelNameTextField, data[0]);
       	util.selectTheOptionFromDropDown(page, channelTypeDropdown, excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.notificationChannelsExcelPath, IPathConstant.notificationChannelsSheet, "channelType_webhook"));
       	page.fill(emailAddressTextField, data[1]);
    	page.click(plusButton);
    	Assert.assertTrue(page.locator(addedEmailAddresses).nth(0).textContent().trim().equals(data[1]));
    	page.click(clearBtn);
    	Assert.assertTrue(page.locator(addedEmailAddresses).count() == 0);
    	page.click(popupWindowCloseBtn);
    }
    
    public void validateTheWarningMessageShownWhenTheChannelNameIsLeftEmptyInAddChannelPopupWindow() throws EncryptedDocumentException, IOException {
    	String message = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath, IPathConstant.messageSheet, "NotificationCahnnel_incorrectChannelNameWarningMsg");
    	navigateToAddChannelPopupWindow();
    	page.fill(channelNameTextField, " ");
    	page.click(emailAddressTextField);
    	Assert.assertTrue(page.textContent(channelNameErrorMessage).trim().equalsIgnoreCase(message));  
    	page.click(popupWindowCloseBtn);
    }
    
    public void validateTheWarningMessageShownWhenTheChannelNameHasASpecialCharacterInAddChannelPopupWindow() throws EncryptedDocumentException, IOException {
    	String message = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath, IPathConstant.messageSheet, "NotificationCahnnel_incorrectChannelNameWarningMsg");
    	navigateToAddChannelPopupWindow();
    	page.fill(channelNameTextField, excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.notificationChannelsExcelPath, IPathConstant.notificationChannelsSheet, "channelNameWithSpecialCharacter"));
    	page.click(emailAddressTextField);
    	Assert.assertTrue(page.textContent(channelNameErrorMessage).trim().equalsIgnoreCase(message));  
    	page.click(popupWindowCloseBtn);
    }
    
    public void validateTheWarningMessageShownWhenTheChannelNameHasMoreThan50CharacterInAddChannelPopupWindow() throws EncryptedDocumentException, IOException {
    	String message = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath, IPathConstant.messageSheet, "NotificationCahnnel_incorrectChannelNameWarningMsg");
    	navigateToAddChannelPopupWindow();
    	page.fill(channelNameTextField, excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.notificationChannelsExcelPath, IPathConstant.notificationChannelsSheet, "channelNameMoreThan50Characters"));
    	page.click(emailAddressTextField);
    	Assert.assertTrue(page.textContent(channelNameErrorMessage).trim().equalsIgnoreCase(message));  
    	page.click(popupWindowCloseBtn);
    }
    
    public void validateTheWarningMessageShownWhenTheDuplicateChannelNameIsEnteredInAddChannelPopupWindow() throws EncryptedDocumentException, IOException {
    	String message = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath, IPathConstant.messageSheet, "NotificationCahnnel_duplicateChannelNameWarningMsg");
    	String name = page.locator(channelNamesColumnData).first().textContent().trim();
    	navigateToAddChannelPopupWindow();
    	page.fill(channelNameTextField, name);
    	page.click(emailAddressTextField);
    	Assert.assertTrue(page.textContent(channelNameErrorMessage).trim().equalsIgnoreCase(message));  
    	page.click(popupWindowCloseBtn);
    }
    
    public void validateTheOptionsUnderChannelTypeDropdown() throws EncryptedDocumentException, IOException {
    	String[] options = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.notificationChannelsExcelPath, IPathConstant.notificationChannelsSheet, "channelType_options").split(",");
    	navigateToAddChannelPopupWindow();
    	page.click(channelTypeDropdown);
    	Locator types = page.locator(channelTypeDropdownOptions);
    	for (String option : options) {
    		boolean flag = false;
    		for(int i=0; i<types.count(); i++) {
    			if(types.nth(i).textContent().trim().equalsIgnoreCase(option)) {
    				flag = true;
    				break;
    			}
    		}
    		Assert.assertTrue(flag);
		}
    	page.click(popupWindowCloseBtn);
    }
    
    public void validateTheEmailAddressInformationMessageInAddChannelPopupWindow() throws EncryptedDocumentException, IOException {
    	String message = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath, IPathConstant.messageSheet, "NotificationCahnnel_enterEmailAddressInfoMsg");
    	navigateToAddChannelPopupWindow();
       	util.selectTheOptionFromDropDown(page, channelTypeDropdown, excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.notificationChannelsExcelPath, IPathConstant.notificationChannelsSheet, "channelType_default"));
    	Assert.assertTrue(page.textContent(emailInfoMessage).trim().equals(message));
    	page.click(popupWindowCloseBtn);
    }
    
    public void validateTheSlackUrlInformationMessageInAddChannelPopupWindow() throws EncryptedDocumentException, IOException {
    	String message = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath, IPathConstant.messageSheet, "NotificationCahnnel_enterStackUrlInfoMsg");
    	Assert.assertTrue(page.textContent(emailInfoMessage).trim().equals(message));
    }
    
    public void validateTheWebhookUrlInformationMessageInAddChannelPopupWindow() throws EncryptedDocumentException, IOException {
    	String message = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath, IPathConstant.messageSheet, "NotificationCahnnel_enterWebhookUrlInfoMsg");
    	Assert.assertTrue(page.textContent(emailInfoMessage).trim().equals(message));
    }
    
    public void validateWhetherAnEmailAddressCanBeAddedThroughTheEmailAddressTextfield() throws EncryptedDocumentException, IOException {
    	String[] data = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.notificationChannelsExcelPath, IPathConstant.notificationChannelsSheet, "addChannel_ForEmail").split(",");
    	navigateToAddChannelPopupWindow();
    	page.fill(channelNameTextField, data[0]);
    	page.fill(emailAddressTextField, data[1]);
    	page.click(plusButton);
    	Assert.assertTrue(page.locator(addedEmailAddresses).nth(0).textContent().trim().equals(data[1]));
    	page.click(popupWindowCloseBtn);
    }
    
    public void validateTheErrorMessageByAddingAnEmptyEmailAddressInAddChannelPopupWindow() throws EncryptedDocumentException, IOException {
    	String message = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath, IPathConstant.messageSheet, "NotificationCahnnel_InvalidEmailAddressWarningMsg");
    	navigateToAddChannelPopupWindow();
    	util.ValidateTheTitle(page, channelTypeDropdown, excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.notificationChannelsExcelPath, IPathConstant.notificationChannelsSheet, "channelType_default"));
    	page.click(plusButton);
    	Assert.assertTrue(page.textContent(emailErrorMessage).trim().equalsIgnoreCase(message));
    	page.click(popupWindowCloseBtn);
    }
    
    public void validateTheErrorMessageByEnteringAnInvalidEmailAddressForFirstMailIdInAddChannelPopupWindow() throws EncryptedDocumentException, IOException {
    	String message = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath, IPathConstant.messageSheet, "NotificationCahnnel_InvalidEmailAddressWarningMsg");
    	navigateToAddChannelPopupWindow();
    	util.ValidateTheTitle(page, channelTypeDropdown, excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.notificationChannelsExcelPath, IPathConstant.notificationChannelsSheet, "channelType_default"));
    	String[] data = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.notificationChannelsExcelPath, IPathConstant.notificationChannelsSheet, "addChannel_ForEmail").split(",");
    	page.fill(emailAddressTextField, data[1].replace("@", ""));
    	page.click(plusButton);
    	Assert.assertTrue(page.textContent(emailErrorMessage).trim().equalsIgnoreCase(message));
    	page.click(popupWindowCloseBtn);
    }
    
    public void validateTheErrorMessageByEnteringAnInvalidEmailAddressForOtherThanFirstMailIdInAddChannelPopupWindow() throws EncryptedDocumentException, IOException {
    	String message = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath, IPathConstant.messageSheet, "NotificationCahnnel_InvalidEmailAddressForSecondTimeWarningMsg");
    	navigateToAddChannelPopupWindow();
    	util.ValidateTheTitle(page, channelTypeDropdown, excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.notificationChannelsExcelPath, IPathConstant.notificationChannelsSheet, "channelType_default"));
    	String[] data = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.notificationChannelsExcelPath, IPathConstant.notificationChannelsSheet, "addChannel_ForEmail").split(",");
    	page.fill(emailAddressTextField, data[1]);
    	page.click(plusButton);
    	page.fill(emailAddressTextField, data[1].replace("@", ""));
    	page.click(plusButton);
    	Assert.assertTrue(page.textContent(emailErrorMessage).trim().equalsIgnoreCase(message));
    	page.click(popupWindowCloseBtn);
    }
    
    public void validateTheErrorMessageByEnteringDuplicateEmailAddressInAddChannelPopupWindow() throws EncryptedDocumentException, IOException {
    	String message = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath, IPathConstant.messageSheet, "NotificationCahnnel_DuplicateEmailAddressWarningMsg");
    	navigateToAddChannelPopupWindow();
    	util.ValidateTheTitle(page, channelTypeDropdown, excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.notificationChannelsExcelPath, IPathConstant.notificationChannelsSheet, "channelType_default"));
    	String[] data = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.notificationChannelsExcelPath, IPathConstant.notificationChannelsSheet, "addChannel_ForEmail").split(",");
    	page.fill(emailAddressTextField, data[1]);
    	page.click(plusButton);
    	page.fill(emailAddressTextField, data[1]);
    	page.click(plusButton);
    	Assert.assertTrue(page.textContent(emailErrorMessage).trim().equalsIgnoreCase(message));
    	page.click(popupWindowCloseBtn);
    }
    
    public void validateTheDeletionOfEmailAddressInAddChannelPopupWindow() throws EncryptedDocumentException, IOException {
    	navigateToAddChannelPopupWindow();
    	util.ValidateTheTitle(page, channelTypeDropdown, excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.notificationChannelsExcelPath, IPathConstant.notificationChannelsSheet, "channelType_default"));
    	String[] data = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.notificationChannelsExcelPath, IPathConstant.notificationChannelsSheet, "addChannel_ForEmail").split(",");
    	page.fill(emailAddressTextField, data[1]);
    	page.click(plusButton);
    	page.fill(emailAddressTextField, "abc"+data[1]);
    	page.click(plusButton);
    	Locator mailid = page.locator(addedEmailAddresses);
    	Locator deleteBtn = page.locator(emailAddressDeleteBtns);
    	Assert.assertTrue(mailid.count() == 2);
    	for(int i=0; i<mailid.count(); i++) {
    		if(mailid.nth(i).textContent().trim().equalsIgnoreCase("abc"+data[1])) {
    			deleteBtn.nth(i).click();
    			break;
    		}
    	}
    	Assert.assertTrue(mailid.count() == 1);
    	Assert.assertTrue(mailid.first().textContent().trim().equalsIgnoreCase(data[1]));
    	page.click(popupWindowCloseBtn);
    }
    	
    public void validateThatTheMaximumNumberOfEmailAddressesThatCanBeAddedForAChannelIs50() throws EncryptedDocumentException, IOException {
    	String message = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath, IPathConstant.messageSheet, "NotificationCahnnel_MaximumEntriesWarningMsg");
    	navigateToAddChannelPopupWindow();
    	String[] data = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.notificationChannelsExcelPath, IPathConstant.notificationChannelsSheet, "addChannel_ForEmail").split(",");
    	for (int i=0; i<=51; i++) {
    		page.fill(emailAddressTextField, i+data[1]);
        	page.click(plusButton);
    	}
    	Assert.assertTrue(page.textContent(emailErrorMessage).trim().equalsIgnoreCase(message));
    	page.click(popupWindowCloseBtn);
    }
    
    public void validateCreationOfNotificationChannelForEmail() throws EncryptedDocumentException, IOException {
    	DateTimeFormatter formatter = new DateTimeFormatterBuilder().parseCaseInsensitive().appendPattern("MMM dd, yyyy").toFormatter(Locale.ENGLISH);
    	String message = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath, IPathConstant.messageSheet, "NotificationCahnnel_channelCreationConfirmationMsg");
    	String[] data = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.notificationChannelsExcelPath, IPathConstant.notificationChannelsSheet, "addChannel_ForEmail").split(",");
    	checkForTheNotificationChannelAndDelete(data[0]);
    	navigateToAddChannelPopupWindow();
    	page.fill(channelNameTextField, data[0]);
    	util.ValidateTheTitle(page, channelTypeDropdown, excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.notificationChannelsExcelPath, IPathConstant.notificationChannelsSheet, "channelType_default"));
    	page.fill(emailAddressTextField, data[1]);
    	page.click(plusButton);
    	page.click(saveBtn);
    	String currentDate = formatter.format(LocalDateTime.now());
    	page.waitForSelector(confirmationMessage);
    	Assert.assertTrue(page.textContent(confirmationMessage).trim().contains(message));
    	page.click(messageCloseBtn);
    	util.validateSearchFunctionalityWithValidData(page, data[0], searchTextfield, searchIcon, channelNamesColumnData);
    	Locator channelNames = page.locator(channelNamesColumnData);
    	for(int i=0; i<channelNames.count(); i++) {
    		if(channelNames.nth(i).textContent().trim().equals(data[0])){
    			System.out.println(page.locator(channelTypesColumnData).nth(i).textContent().trim()+"--------"+excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.notificationChannelsExcelPath, IPathConstant.notificationChannelsSheet, "channelType_default"));
    			Assert.assertTrue(page.locator(channelTypesColumnData).nth(i).textContent().trim().equals(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.notificationChannelsExcelPath, IPathConstant.notificationChannelsSheet, "channelType_default")));
    			System.out.println(page.locator(createdOnColumnData).nth(i).textContent().trim()+"--------"+currentDate);
    			Assert.assertTrue(page.locator(createdOnColumnData).nth(i).textContent().trim().equals(currentDate));
    			break;
    		}
    	}
    }
    public void validateWhetherCreatedNotificationCahnnelForEmailIsReflectingInAlertCreation() throws EncryptedDocumentException, IOException {
    	String[] data = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.notificationChannelsExcelPath, IPathConstant.notificationChannelsSheet, "addChannel_ForEmail").split(",");
    	alerts.validateWhetherTheNotificationChannelIsReflectingInAlertCreation(data[0]);
    }
    
    public void selectSlackAsCahnnelTypeAndValidate() throws EncryptedDocumentException, IOException {
    	navigateToAddChannelPopupWindow();
    	String expectedType = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.notificationChannelsExcelPath, IPathConstant.notificationChannelsSheet, "channelType_slack");
    	util.selectTheOptionFromDropDown(page, channelTypeDropdown, expectedType);
    	util.ValidateTheTitle(page, channelTypeDropdown, expectedType);
    	validateTheFieldsInAddChannelPopupWindowForSlack();
    	validateTheSlackUrlInformationMessageInAddChannelPopupWindow();
    	page.click(popupWindowCloseBtn);
    }
    
    public void validateWhetherSlackUrlCanBeAddedThroughTheSlackUrlTextfield() throws EncryptedDocumentException, IOException {
    	String[] data = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.notificationChannelsExcelPath, IPathConstant.notificationChannelsSheet, "addChannel_ForSlack").split(",");
    	navigateToAddChannelPopupWindow();
    	util.selectTheOptionFromDropDown(page, channelTypeDropdown, excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.notificationChannelsExcelPath, IPathConstant.notificationChannelsSheet, "channelType_slack"));
    	page.fill(channelNameTextField, data[0]);
    	page.fill(emailAddressTextField, data[1]);
    	page.click(plusButton);
    	Assert.assertTrue(page.locator(addedEmailAddresses).nth(0).textContent().trim().equals(data[1]));
    	page.click(popupWindowCloseBtn);
    }
    
    public void validateTheErrorMessageByAddingAnEmptySlackUrlInAddChannelPopupWindow() throws EncryptedDocumentException, IOException {
    	String message = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath, IPathConstant.messageSheet, "NotificationCahnnel_InvalidSlackUrlWarningMsg");
    	navigateToAddChannelPopupWindow();
    	util.selectTheOptionFromDropDown(page, channelTypeDropdown, excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.notificationChannelsExcelPath, IPathConstant.notificationChannelsSheet, "channelType_slack"));
    	page.click(plusButton);
    	Assert.assertTrue(page.textContent(emailErrorMessage).trim().equalsIgnoreCase(message));
    	page.click(popupWindowCloseBtn);
    }
    
    public void validateTheErrorMessageByEnteringAnInvalidSlackUrlForFirstUrlInAddChannelPopupWindow() throws EncryptedDocumentException, IOException {
    	String message = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath, IPathConstant.messageSheet, "NotificationCahnnel_InvalidSlackUrlWarningMsg");
    	navigateToAddChannelPopupWindow();
    	util.selectTheOptionFromDropDown(page, channelTypeDropdown, excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.notificationChannelsExcelPath, IPathConstant.notificationChannelsSheet, "channelType_slack"));
    	String[] data = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.notificationChannelsExcelPath, IPathConstant.notificationChannelsSheet, "addChannel_ForSlack").split(",");
    	page.fill(emailAddressTextField, data[1].replace("slack.com/", ""));
    	page.click(plusButton);
    	Assert.assertTrue(page.textContent(emailErrorMessage).trim().equalsIgnoreCase(message));
    	page.click(popupWindowCloseBtn);
    }
    
    public void validateTheErrorMessageByEnteringAnInvalidSlackUrlForOtherThanFirstUrlInAddChannelPopupWindow() throws EncryptedDocumentException, IOException {
    	String message = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath, IPathConstant.messageSheet, "NotificationCahnnel_InvalidSlackUrlForSecondTimeWarningMsg");
    	navigateToAddChannelPopupWindow();
    	util.selectTheOptionFromDropDown(page, channelTypeDropdown, excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.notificationChannelsExcelPath, IPathConstant.notificationChannelsSheet, "channelType_slack"));
    	String[] data = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.notificationChannelsExcelPath, IPathConstant.notificationChannelsSheet, "addChannel_ForSlack").split(",");
    	page.fill(emailAddressTextField, data[1]);
    	page.click(plusButton);
    	page.fill(emailAddressTextField, data[1].replace("slack.com/", ""));
    	page.click(plusButton);
    	Assert.assertTrue(page.textContent(emailErrorMessage).trim().equalsIgnoreCase(message));
    	page.click(popupWindowCloseBtn);
    }
    
    public void validateTheErrorMessageByEnteringDuplicateSlackUrlInAddChannelPopupWindow() throws EncryptedDocumentException, IOException {
    	String message = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath, IPathConstant.messageSheet, "NotificationCahnnel_DuplicateSlackUrlWarningMsg");
    	navigateToAddChannelPopupWindow();
    	util.selectTheOptionFromDropDown(page, channelTypeDropdown, excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.notificationChannelsExcelPath, IPathConstant.notificationChannelsSheet, "channelType_slack"));
    	String[] data = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.notificationChannelsExcelPath, IPathConstant.notificationChannelsSheet, "addChannel_ForSlack").split(",");
    	page.fill(emailAddressTextField, data[1]);
    	page.click(plusButton);
    	page.fill(emailAddressTextField, data[1]);
    	page.click(plusButton);
    	Assert.assertTrue(page.textContent(emailErrorMessage).trim().equalsIgnoreCase(message));
    	page.click(popupWindowCloseBtn);
    }
    
    public void validateTheDeletionOfSlackUrlInAddChannelPopupWindow() throws EncryptedDocumentException, IOException {
    	navigateToAddChannelPopupWindow();
    	util.selectTheOptionFromDropDown(page, channelTypeDropdown, excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.notificationChannelsExcelPath, IPathConstant.notificationChannelsSheet, "channelType_slack"));
    	String[] data = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.notificationChannelsExcelPath, IPathConstant.notificationChannelsSheet, "addChannel_ForSlack").split(",");
    	page.fill(emailAddressTextField, data[1]);
    	page.click(plusButton);
    	page.fill(emailAddressTextField, data[1]+"abc");
    	page.click(plusButton);
    	Locator mailid = page.locator(addedEmailAddresses);
    	Locator deleteBtn = page.locator(emailAddressDeleteBtns);
    	Assert.assertTrue(mailid.count() == 2);
    	for(int i=0; i<mailid.count(); i++) {
    		if(mailid.nth(i).textContent().trim().equalsIgnoreCase(data[1]+"abc")) {
    			deleteBtn.nth(i).click();
    			break;
    		}
    	}
    	Assert.assertTrue(mailid.count() == 1);
    	Assert.assertTrue(mailid.first().textContent().trim().equalsIgnoreCase(data[1]));
    	page.click(popupWindowCloseBtn);
    }
    
    public void validateThatTheMaximumNumberOfSlackUrlsThatCanBeAddedForAChannelIs50() throws EncryptedDocumentException, IOException {
    	String message = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath, IPathConstant.messageSheet, "NotificationCahnnel_MaximumEntriesWarningMsg");
    	navigateToAddChannelPopupWindow();
    	util.selectTheOptionFromDropDown(page, channelTypeDropdown, excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.notificationChannelsExcelPath, IPathConstant.notificationChannelsSheet, "channelType_slack"));
    	String[] data = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.notificationChannelsExcelPath, IPathConstant.notificationChannelsSheet, "addChannel_ForSlack").split(",");
    	for (int i=0; i<=51; i++) {
    		page.fill(emailAddressTextField, data[1]+i);
        	page.click(plusButton);
    	}
    	Assert.assertTrue(page.textContent(emailErrorMessage).trim().equalsIgnoreCase(message));
    	page.click(popupWindowCloseBtn);
    }
    
    public void validateCreationOfNotificationChannelForSlack() throws EncryptedDocumentException, IOException {
    	DateTimeFormatter formatter = new DateTimeFormatterBuilder().parseCaseInsensitive().appendPattern("MMM dd, yyyy").toFormatter(Locale.ENGLISH);
    	String message = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath, IPathConstant.messageSheet, "NotificationCahnnel_channelCreationConfirmationMsg");
    	String[] data = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.notificationChannelsExcelPath, IPathConstant.notificationChannelsSheet, "addChannel_ForSlack").split(",");
    	checkForTheNotificationChannelAndDelete(data[0]);
    	navigateToAddChannelPopupWindow();
    	page.fill(channelNameTextField, data[0]);
    	util.selectTheOptionFromDropDown(page, channelTypeDropdown, excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.notificationChannelsExcelPath, IPathConstant.notificationChannelsSheet, "channelType_slack"));
    	page.fill(emailAddressTextField, data[1]);
    	page.click(plusButton);
    	util.ValidateTheTitle(page, channelTypeDropdown, excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.notificationChannelsExcelPath, IPathConstant.notificationChannelsSheet, "channelType_slack"));
    	page.click(saveBtn);
    	String currentDate = formatter.format(LocalDateTime.now());
    	Assert.assertTrue(page.textContent(confirmationMessage).trim().contains(message));
    	page.click(messageCloseBtn);
    	util.validateSearchFunctionalityWithValidData(page, data[0], searchTextfield, searchIcon, channelNamesColumnData);
    	Locator channelNames = page.locator(channelNamesColumnData);
    	for(int i=0; i<channelNames.count(); i++) {
    		if(channelNames.nth(i).textContent().trim().equals(data[0])){
    			System.out.println(page.locator(channelTypesColumnData).nth(i).textContent().trim()+"--------"+excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.notificationChannelsExcelPath, IPathConstant.notificationChannelsSheet, "channelType_slack"));
    			Assert.assertTrue(page.locator(channelTypesColumnData).nth(i).textContent().trim().equals(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.notificationChannelsExcelPath, IPathConstant.notificationChannelsSheet, "channelType_slack")));
    			System.out.println(page.locator(createdOnColumnData).nth(i).textContent().trim()+"--------"+currentDate);
    			Assert.assertTrue(page.locator(createdOnColumnData).nth(i).textContent().trim().equals(currentDate));
    			break;
    		}
    	}
    }
    
    public void validateCreationOfNotificationChannelForWebhook() throws EncryptedDocumentException, IOException {
    	DateTimeFormatter formatter = new DateTimeFormatterBuilder().parseCaseInsensitive().appendPattern("MMM dd, yyyy").toFormatter(Locale.ENGLISH);
    	String message = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath, IPathConstant.messageSheet, "NotificationCahnnel_channelCreationConfirmationMsg");
    	String[] data = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.notificationChannelsExcelPath, IPathConstant.notificationChannelsSheet, "addChannel_ForWebhook").split(",");
    	checkForTheNotificationChannelAndDelete(data[0]);
    	navigateToAddChannelPopupWindow();
    	page.fill(channelNameTextField, data[0]);
    	util.selectTheOptionFromDropDown(page, channelTypeDropdown, excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.notificationChannelsExcelPath, IPathConstant.notificationChannelsSheet, "channelType_webhook"));
    	page.fill(emailAddressTextField, data[1]);
    	page.click(plusButton);
    	util.ValidateTheTitle(page, channelTypeDropdown, excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.notificationChannelsExcelPath, IPathConstant.notificationChannelsSheet, "channelType_webhook"));
    	page.click(saveBtn);
    	String currentDate = formatter.format(LocalDateTime.now());
    	Assert.assertTrue(page.textContent(confirmationMessage).trim().contains(message));
    	page.click(messageCloseBtn);
    	util.validateSearchFunctionalityWithValidData(page, data[0], searchTextfield, searchIcon, channelNamesColumnData);
    	Locator channelNames = page.locator(channelNamesColumnData);
    	for(int i=0; i<channelNames.count(); i++) {
    		if(channelNames.nth(i).textContent().trim().equals(data[0])){
    			System.out.println(page.locator(channelTypesColumnData).nth(i).textContent().trim()+"--------"+excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.notificationChannelsExcelPath, IPathConstant.notificationChannelsSheet, "channelType_webhook"));
    			Assert.assertTrue(page.locator(channelTypesColumnData).nth(i).textContent().trim().equals(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.notificationChannelsExcelPath, IPathConstant.notificationChannelsSheet, "channelType_webhook")));
    			System.out.println(page.locator(createdOnColumnData).nth(i).textContent().trim()+"--------"+currentDate);
    			Assert.assertTrue(page.locator(createdOnColumnData).nth(i).textContent().trim().equals(currentDate));
    			break;
    		}
    	}
    }
    	
    public void validateWhetherCreatedNotificationCahnnelForSlackIsReflectingInAlertCreation() throws EncryptedDocumentException, IOException {
    	String[] data = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.notificationChannelsExcelPath, IPathConstant.notificationChannelsSheet, "addChannel_ForSlack").split(",");
    	alerts.validateWhetherTheNotificationChannelIsReflectingInAlertCreation(data[0]);
    }
    
    public void validateWhetherCreatedNotificationCahnnelForWebhookIsReflectingInAlertCreation() throws EncryptedDocumentException, IOException {
    	String[] data = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.notificationChannelsExcelPath, IPathConstant.notificationChannelsSheet, "addChannel_ForWebhook").split(",");
    	alerts.validateWhetherTheNotificationChannelIsReflectingInAlertCreation(data[0]);
    }
    
    public void selectWebhookAsCahnnelTypeAndValidate() throws EncryptedDocumentException, IOException {
    	navigateToAddChannelPopupWindow();
    	String expectedType = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.notificationChannelsExcelPath, IPathConstant.notificationChannelsSheet, "channelType_webhook");
    	util.selectTheOptionFromDropDown(page, channelTypeDropdown, expectedType);
    	util.ValidateTheTitle(page, channelTypeDropdown, expectedType);
    	validateTheFieldsInAddChannelPopupWindowForWebhook();
    	validateTheWebhookUrlInformationMessageInAddChannelPopupWindow();
    	page.click(popupWindowCloseBtn);
    }
    
    public void validateTheDataInformationMessageForWebhhookInAddChannelPopupWindow() throws EncryptedDocumentException, IOException {
    	String message = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath, IPathConstant.messageSheet, "NotificationCahnnel_webhookDataInfoMsg");
    	navigateToAddChannelPopupWindow();
    	util.selectTheOptionFromDropDown(page, channelTypeDropdown, excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.notificationChannelsExcelPath, IPathConstant.notificationChannelsSheet, "channelType_webhook"));
    	util.ValidateTheTitle(page, dataInfoMessage, message);
    	page.click(popupWindowCloseBtn);
    }
    
    public void validateWhetherWebhookUrlCanBeAddedThroughTheWebhookUrlTextfield() throws EncryptedDocumentException, IOException {
    	String[] data = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.notificationChannelsExcelPath, IPathConstant.notificationChannelsSheet, "addChannel_ForWebhook").split(",");
    	navigateToAddChannelPopupWindow();
    	util.selectTheOptionFromDropDown(page, channelTypeDropdown, excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.notificationChannelsExcelPath, IPathConstant.notificationChannelsSheet, "channelType_webhook"));
    	page.fill(channelNameTextField, data[0]);
    	page.fill(emailAddressTextField, data[1]);
    	page.click(plusButton);
    	Assert.assertTrue(page.locator(addedEmailAddresses).nth(0).textContent().trim().equals(data[1]));
    	page.click(popupWindowCloseBtn);
    }
    
    public void validateTheErrorMessageByAddingAnEmptyWebhookUrlInAddChannelPopupWindow() throws EncryptedDocumentException, IOException {
    	String message = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath, IPathConstant.messageSheet, "NotificationCahnnel_InvalidWebhookUrlWarningMsg");
    	navigateToAddChannelPopupWindow();
    	util.selectTheOptionFromDropDown(page, channelTypeDropdown, excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.notificationChannelsExcelPath, IPathConstant.notificationChannelsSheet, "channelType_webhook"));
    	page.click(plusButton);
    	Assert.assertTrue(page.textContent(emailErrorMessage).trim().equalsIgnoreCase(message));
    	page.click(popupWindowCloseBtn);
    }
    
    public void validateTheErrorMessageByEnteringAnInvalidWebhookUrlForFirstUrlInAddChannelPopupWindow() throws EncryptedDocumentException, IOException {
    	String message = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath, IPathConstant.messageSheet, "NotificationCahnnel_InvalidWebhookUrlWarningMsg");
    	navigateToAddChannelPopupWindow();
    	util.selectTheOptionFromDropDown(page, channelTypeDropdown, excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.notificationChannelsExcelPath, IPathConstant.notificationChannelsSheet, "channelType_webhook"));
    	String[] data = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.notificationChannelsExcelPath, IPathConstant.notificationChannelsSheet, "addChannel_ForWebhook").split(",");
    	page.fill(emailAddressTextField, data[1].replace("https://webhook.site/", ""));
    	page.click(plusButton);
    	Assert.assertTrue(page.textContent(emailErrorMessage).trim().equalsIgnoreCase(message));
    	page.click(popupWindowCloseBtn);
    }
    
    public void validateTheErrorMessageByEnteringAnInvalidWebhookUrlForOtherThanFirstUrlInAddChannelPopupWindow() throws EncryptedDocumentException, IOException {
    	String message = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath, IPathConstant.messageSheet, "NotificationCahnnel_InvalidWebhookUrlForSecondTimeWarningMsg");
    	navigateToAddChannelPopupWindow();
    	util.selectTheOptionFromDropDown(page, channelTypeDropdown, excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.notificationChannelsExcelPath, IPathConstant.notificationChannelsSheet, "channelType_webhook"));
    	String[] data = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.notificationChannelsExcelPath, IPathConstant.notificationChannelsSheet, "addChannel_ForWebhook").split(",");
    	page.fill(emailAddressTextField, data[1]);
    	page.click(plusButton);
    	page.fill(emailAddressTextField, data[1].replace("https://webhook.site/", ""));
    	page.click(plusButton);
    	Assert.assertTrue(page.textContent(emailErrorMessage).trim().equalsIgnoreCase(message));
    	page.click(popupWindowCloseBtn);
    }
    
    public void validateTheErrorMessageByEnteringDuplicateWebhookUrlInAddChannelPopupWindow() throws EncryptedDocumentException, IOException {
    	String message = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath, IPathConstant.messageSheet, "NotificationCahnnel_DuplicateWebhookUrlWarningMsg");
    	navigateToAddChannelPopupWindow();
    	util.selectTheOptionFromDropDown(page, channelTypeDropdown, excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.notificationChannelsExcelPath, IPathConstant.notificationChannelsSheet, "channelType_webhook"));
    	String[] data = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.notificationChannelsExcelPath, IPathConstant.notificationChannelsSheet, "addChannel_ForWebhook").split(",");
    	page.fill(emailAddressTextField, data[1]);
    	page.click(plusButton);
    	page.fill(emailAddressTextField, data[1]);
    	page.click(plusButton);
    	System.out.println(page.textContent(emailErrorMessage).trim());
    	System.out.println(message);
    	Assert.assertTrue(page.textContent(emailErrorMessage).trim().equalsIgnoreCase(message));
    	page.click(popupWindowCloseBtn);
    }
    
    public void validateTheDeletionOfWebhookUrlInAddChannelPopupWindow() throws EncryptedDocumentException, IOException {
    	navigateToAddChannelPopupWindow();
    	util.selectTheOptionFromDropDown(page, channelTypeDropdown, excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.notificationChannelsExcelPath, IPathConstant.notificationChannelsSheet, "channelType_webhook"));
    	String[] data = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.notificationChannelsExcelPath, IPathConstant.notificationChannelsSheet, "addChannel_ForWebhook").split(",");
    	page.fill(emailAddressTextField, data[1]);
    	page.click(plusButton);
    	page.fill(emailAddressTextField, data[1]+"abc");
    	page.click(plusButton);
    	Locator mailid = page.locator(addedEmailAddresses);
    	Locator deleteBtn = page.locator(emailAddressDeleteBtns);
    	Assert.assertTrue(mailid.count() == 2);
    	for(int i=0; i<mailid.count(); i++) {
    		if(mailid.nth(i).textContent().trim().equalsIgnoreCase(data[1]+"abc")) {
    			deleteBtn.nth(i).click();
    			break;
    		}
    	}
    	Assert.assertTrue(mailid.count() == 1);
    	Assert.assertTrue(mailid.first().textContent().trim().equalsIgnoreCase(data[1]));
    	page.click(popupWindowCloseBtn);
    }
    
    public void validateThatTheMaximumNumberOfWebhookUrlsThatCanBeAddedForAChannelIs50() throws EncryptedDocumentException, IOException {
    	String message = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath, IPathConstant.messageSheet, "NotificationCahnnel_MaximumEntriesWarningMsg");
    	navigateToAddChannelPopupWindow();
    	util.selectTheOptionFromDropDown(page, channelTypeDropdown, excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.notificationChannelsExcelPath, IPathConstant.notificationChannelsSheet, "channelType_webhook"));
    	String[] data = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.notificationChannelsExcelPath, IPathConstant.notificationChannelsSheet, "addChannel_ForWebhook").split(",");
    	for (int i=0; i<=51; i++) {
    		page.fill(emailAddressTextField, data[1]+i);
        	page.click(plusButton);
    	}
    	Assert.assertTrue(page.textContent(emailErrorMessage).trim().equalsIgnoreCase(message));
    	page.click(popupWindowCloseBtn);
    }
    
    public void navigateToAddChannelPopupWindow() {
    	page.click(addChannelButton);
    	page.waitForSelector(popupWindowTitle);
    }
    
    public void checkForTheNotificationChannelAndDelete(String name) throws EncryptedDocumentException, IOException {
    	page.fill(searchTextfield, name);
    	page.click(searchIcon);
    	try {
    	page.waitForSelector(channelNamesColumnData);
    	Locator channels = page.locator(channelNamesColumnData);
    	for(int i=0; i<channels.count(); i++) {
    		if(channels.nth(i).textContent().trim().equals(name)) {
    			page.locator(deleteBtns).nth(i).click();
    			page.waitForSelector(popupWindowTitle);
    			Assert.assertTrue(page.textContent(popupWindowTitle).equals(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.notificationChannelsExcelPath, IPathConstant.notificationChannelsSheet, "deleteChannelPopupTitle")));
    			String popupMsg = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.notificationChannelsExcelPath, IPathConstant.notificationChannelsSheet, "deleteChannelPopupMsg");
    			popupMsg = popupMsg.replace("''", "'"+name+"'");
    			Assert.assertTrue(page.textContent(deleteChannelPopupMessge).equals(popupMsg));
    			page.click(saveBtn);
    			page.waitForSelector(confirmationMessage);
    			Assert.assertTrue(page.textContent(confirmationMessage).trim().contains(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath, IPathConstant.messageSheet, "NotificationCahnnel_channelDeletionConfirmationMsg")));
    			page.click(messageCloseBtn);
    		}
    	}} catch(Exception e) {
    		Assert.assertTrue(page.isVisible(noDataIcon));
    	}
    }
    
    public void validateTheDataHeaderTextForWebhookInAddChannelPopupWindow() throws EncryptedDocumentException, IOException {
    	String text = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.notificationChannelsExcelPath, IPathConstant.notificationChannelsSheet, "dataField_HeaderText");
    	navigateToAddChannelPopupWindow();
    	util.selectTheOptionFromDropDown(page, channelTypeDropdown, excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.notificationChannelsExcelPath, IPathConstant.notificationChannelsSheet, "channelType_webhook"));
    	util.ValidateTheTitle(page, dataHeaderText, text);
    }
    
    public void validateTheColorOfDataKeys() throws EncryptedDocumentException, IOException {
    	String expectedColor = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.notificationChannelsExcelPath, IPathConstant.notificationChannelsSheet, "dataField_KeyColor");
    	navigateToAddChannelPopupWindow();
    	util.selectTheOptionFromDropDown(page, channelTypeDropdown, excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.notificationChannelsExcelPath, IPathConstant.notificationChannelsSheet, "channelType_webhook"));
    	Locator keys = page.locator(dataKeys);
    	for(int i=0; i<keys.count();i++) {
    		String actualColor = (String)keys.nth(i).evaluate("element => window.getComputedStyle(element).getPropertyValue('color')");
    		System.out.println(actualColor+"-------"+expectedColor);
    		Assert.assertTrue(actualColor.contains(expectedColor));
    	}
    }
    
    public void validateTheColorOfDataValues() throws EncryptedDocumentException, IOException {
    	String expectedColor = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.notificationChannelsExcelPath, IPathConstant.notificationChannelsSheet, "dataField_ValueColor");
    	navigateToAddChannelPopupWindow();
    	util.selectTheOptionFromDropDown(page, channelTypeDropdown, excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.notificationChannelsExcelPath, IPathConstant.notificationChannelsSheet, "channelType_webhook"));
    	Locator keys = page.locator(dataValues);
    	for(int i=0; i<keys.count();i++) {
    		String actualColor = (String)keys.nth(i).evaluate("element => window.getComputedStyle(element).getPropertyValue('color')");
    		System.out.println(actualColor+"-------"+expectedColor);
    		Assert.assertTrue(actualColor.contains(expectedColor));
    	}
    }
    
    public void validateTheSelectionOfTaggingCheckbox() throws EncryptedDocumentException, IOException {
    	navigateToAddChannelPopupWindow();
    	util.selectTheOptionFromDropDown(page, channelTypeDropdown, excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.notificationChannelsExcelPath, IPathConstant.notificationChannelsSheet, "channelType_webhook"));
    	Assert.assertFalse(page.isChecked(taggingCheckbox));
    	page.click(taggingBtn);
    	Assert.assertTrue(page.isChecked(taggingCheckbox));
    	page.click(popupWindowCloseBtn);
    }
    
    public void validateTheHeadersOfSupportedWebhookValiablesFieldHeaderText() throws EncryptedDocumentException, IOException {
    	String[] texts = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.notificationChannelsExcelPath, IPathConstant.notificationChannelsSheet, "supportedWebhookVariable_Headers").split(",");
    	navigateToAddChannelPopupWindow();
    	util.selectTheOptionFromDropDown(page, channelTypeDropdown, excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.notificationChannelsExcelPath, IPathConstant.notificationChannelsSheet, "channelType_webhook"));
    	Locator headers = page.locator(webhookVariablesHeader);
    	for (String text : texts) {
    		boolean flag = false;
    		for(int i=0; i<headers.count(); i++ ) {
        		if(headers.nth(i).textContent().trim().equalsIgnoreCase(text)) {
        			System.out.println(headers.nth(i).textContent().trim()+"--------"+text);
        			flag = true;
        			break;
        		}
        	}
    		Assert.assertTrue(flag);
		}
    	page.click(popupWindowCloseBtn);
    }
    
    public void validateTheSupportedWebhookVariablesList() throws EncryptedDocumentException, IOException {
    	navigateToAddChannelPopupWindow();
    	util.selectTheOptionFromDropDown(page, channelTypeDropdown, excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.notificationChannelsExcelPath, IPathConstant.notificationChannelsSheet, "channelType_webhook"));
    	validateWebhookVariables(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.notificationChannelsExcelPath, IPathConstant.notificationChannelsSheet, "supportedWebhookVariable_row1").split(":"));
    	validateWebhookVariables(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.notificationChannelsExcelPath, IPathConstant.notificationChannelsSheet, "supportedWebhookVariable_row2").split(":"));
    	validateWebhookVariables(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.notificationChannelsExcelPath, IPathConstant.notificationChannelsSheet, "supportedWebhookVariable_row3").split(":"));
    	validateWebhookVariables(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.notificationChannelsExcelPath, IPathConstant.notificationChannelsSheet, "supportedWebhookVariable_row4").split(":"));
    	validateWebhookVariables(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.notificationChannelsExcelPath, IPathConstant.notificationChannelsSheet, "supportedWebhookVariable_row5").split(":"));
    	validateWebhookVariables(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.notificationChannelsExcelPath, IPathConstant.notificationChannelsSheet, "supportedWebhookVariable_row6").split(":"));
    	validateWebhookVariables(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.notificationChannelsExcelPath, IPathConstant.notificationChannelsSheet, "supportedWebhookVariable_row7").split(":"));
    	validateWebhookVariables(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.notificationChannelsExcelPath, IPathConstant.notificationChannelsSheet, "supportedWebhookVariable_row8").split(":"));
    	validateWebhookVariables(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.notificationChannelsExcelPath, IPathConstant.notificationChannelsSheet, "supportedWebhookVariable_row9").split(":"));
    	validateWebhookVariables(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.notificationChannelsExcelPath, IPathConstant.notificationChannelsSheet, "supportedWebhookVariable_row10").split(":"));
    	validateWebhookVariables(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.notificationChannelsExcelPath, IPathConstant.notificationChannelsSheet, "supportedWebhookVariable_row11").split(":"));
    	validateWebhookVariables(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.notificationChannelsExcelPath, IPathConstant.notificationChannelsSheet, "supportedWebhookVariable_row12").split(":"));
    	validateWebhookVariables(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.notificationChannelsExcelPath, IPathConstant.notificationChannelsSheet, "supportedWebhookVariable_row13").split(":"));
    	page.click(popupWindowCloseBtn);
    }
    
    public void validateTheSupportedWebhookVariablesListWithTaggingSelected() throws EncryptedDocumentException, IOException {
    	navigateToAddChannelPopupWindow();
    	util.selectTheOptionFromDropDown(page, channelTypeDropdown, excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.notificationChannelsExcelPath, IPathConstant.notificationChannelsSheet, "channelType_webhook"));
    	page.click(taggingBtn);
    	Assert.assertTrue(page.isChecked(taggingCheckbox));
    	validateWebhookVariables(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.notificationChannelsExcelPath, IPathConstant.notificationChannelsSheet, "supportedWebhookVariable_taggingRow1").split(":"));
    	validateWebhookVariables(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.notificationChannelsExcelPath, IPathConstant.notificationChannelsSheet, "supportedWebhookVariable_taggingRow2").split(":"));
    	validateWebhookVariables(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.notificationChannelsExcelPath, IPathConstant.notificationChannelsSheet, "supportedWebhookVariable_taggingRow3").split(":"));
    	validateWebhookVariables(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.notificationChannelsExcelPath, IPathConstant.notificationChannelsSheet, "supportedWebhookVariable_taggingRow4").split(":"));
    	validateWebhookVariables(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.notificationChannelsExcelPath, IPathConstant.notificationChannelsSheet, "supportedWebhookVariable_taggingRow5").split(":"));
    	validateWebhookVariables(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.notificationChannelsExcelPath, IPathConstant.notificationChannelsSheet, "supportedWebhookVariable_taggingRow6").split(":"));
    	validateWebhookVariables(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.notificationChannelsExcelPath, IPathConstant.notificationChannelsSheet, "supportedWebhookVariable_taggingRow7").split(":"));
    	validateWebhookVariables(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.notificationChannelsExcelPath, IPathConstant.notificationChannelsSheet, "supportedWebhookVariable_taggingRow8").split(":"));
    	validateWebhookVariables(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.notificationChannelsExcelPath, IPathConstant.notificationChannelsSheet, "supportedWebhookVariable_taggingRow9").split(":"));
    	validateWebhookVariables(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.notificationChannelsExcelPath, IPathConstant.notificationChannelsSheet, "supportedWebhookVariable_taggingRow10").split(":"));
    	validateWebhookVariables(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.notificationChannelsExcelPath, IPathConstant.notificationChannelsSheet, "supportedWebhookVariable_taggingRow11").split(":"));
    	validateWebhookVariables(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.notificationChannelsExcelPath, IPathConstant.notificationChannelsSheet, "supportedWebhookVariable_taggingRow12").split(":"));
    	validateWebhookVariables(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.notificationChannelsExcelPath, IPathConstant.notificationChannelsSheet, "supportedWebhookVariable_taggingRow13").split(":"));
    	page.click(popupWindowCloseBtn);
    }
    
    public void validateWebhookVariables(String[] variables) {
    	Locator keys = page.locator(webhookVariables);
    	Locator values = page.locator(webhookVariableDescriptions);
    	int count=0;
    	for(int i=0; i<keys.count(); i++) {
    		if(keys.nth(i).textContent().trim().equalsIgnoreCase(variables[0])) {
    			count++;
    			System.out.println(keys.nth(i).textContent().trim()+"-----------"+values.nth(i).textContent().trim());
    			System.out.println(variables[0]+"-----------"+variables[1]);
    			Assert.assertTrue(values.nth(i).textContent().trim().equalsIgnoreCase(variables[1]));
    			break;
    		}
    	}
    	Assert.assertTrue(count == 1);
    }
    
    public void closeThePopupIfPresent() {
    	if(page.isVisible(popupWindowCloseBtn))
    		page.click(popupWindowCloseBtn);
    }
    
    public void validateTheFunctionalityOfEditButtonUnderActionColumn() throws EncryptedDocumentException, IOException {
    	String[] data = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.notificationChannelsExcelPath, IPathConstant.notificationChannelsSheet, "addChannel_ForEmail").split(",");
    	String title = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.notificationChannelsExcelPath, IPathConstant.notificationChannelsSheet, "editChannelPopupTitle");
    	page.fill(searchTextfield, data[0]);
    	page.click(searchIcon);
    	page.waitForSelector(channelNamesColumnData);
    	Locator channels = page.locator(channelNamesColumnData);
    	Locator editBts = page.locator(editBtns);
    	for(int i=0; i<channels.count(); i++) {
    		if(channels.nth(i).textContent().trim().equals(data[0])) {
    			editBts.nth(i).click();
    			break;
    		}
    	}
    	Assert.assertTrue(page.textContent(popupWindowTitle).equalsIgnoreCase(title));
    	Assert.assertTrue(page.textContent(saveBtn).equalsIgnoreCase("Update"));
    	page.click(popupWindowCloseBtn);
    }
    
    public void validateTheFunctionalityOfDeleteButtonUnderActionColumn() throws EncryptedDocumentException, IOException {
    	String[] data = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.notificationChannelsExcelPath, IPathConstant.notificationChannelsSheet, "addChannel_ForSlack").split(",");
    	String title = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.notificationChannelsExcelPath, IPathConstant.notificationChannelsSheet, "deleteChannelPopupTitle");
    	page.fill(searchTextfield, data[0]);
    	page.click(searchIcon);
    	page.waitForSelector(channelNamesColumnData);
    	Locator channels = page.locator(channelNamesColumnData);
    	for(int i=0; i<channels.count(); i++) {
    		if(channels.nth(i).textContent().trim().equals(data[0])) {
    			page.locator(deleteBtns).nth(i).click();
    			page.waitForSelector(popupWindowTitle);
    			Assert.assertTrue(page.textContent(popupWindowTitle).equals(title));
    			String popupMsg = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.notificationChannelsExcelPath, IPathConstant.notificationChannelsSheet, "deleteChannelPopupMsg");
    			popupMsg = popupMsg.replace("''", "'"+data[0]+"'");
    			Assert.assertTrue(page.textContent(deleteChannelPopupMessge).equals(popupMsg));
    			break;
    		}
    	}
    		page.click(popupWindowCloseBtn);
    }
    
    public void validateTheFunctionalityOfUpdateButtonInEditChannelPopupWindow() throws EncryptedDocumentException, IOException {
    	String[] data = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.notificationChannelsExcelPath, IPathConstant.notificationChannelsSheet, "addChannel_ForEmail").split(",");
    	String title = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.notificationChannelsExcelPath, IPathConstant.notificationChannelsSheet, "editChannelPopupTitle");
    	String channelName = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.notificationChannelsExcelPath, IPathConstant.notificationChannelsSheet, "channelNameToUpadte");
    	String message = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath, IPathConstant.messageSheet, "NotificationCahnnel_channelUpdationConfirmationMsg");
    	checkForTheNotificationChannelAndDelete(channelName);
    	page.fill(searchTextfield, data[0]);
    	page.click(searchIcon);
    	page.waitForSelector(channelNamesColumnData);
    	Locator channels = page.locator(channelNamesColumnData);
    	Locator editBts = page.locator(editBtns);
    	for(int i=0; i<channels.count(); i++) {
    		if(channels.nth(i).textContent().trim().equals(data[0])) {
    			editBts.nth(i).click();
    			break;
    		}
    	}
    	Assert.assertTrue(page.textContent(popupWindowTitle).equalsIgnoreCase(title));
    	page.locator(channelNameTextField).clear();
    	page.fill(channelNameTextField, channelName);
    	page.click(saveBtn);
    	page.waitForTimeout(500);
    	//page.click(popupWindowCloseBtn);
    	page.waitForSelector(confirmationMessage);
    	Assert.assertTrue(page.textContent(confirmationMessage).contains(message));
    	page.click(messageCloseBtn);
    	page.waitForSelector(channelNamesColumnData);
    	util.validateSearchFunctionalityWithValidData(page, channelName, searchTextfield, searchIcon, channelNamesColumnData);
    }
    
    public void validateTheWarningMessageWhileDeletingNotificationChannelAssociatedWithAlerts() throws EncryptedDocumentException, IOException {
    	String[] data = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.notificationChannelsExcelPath, IPathConstant.notificationChannelsSheet, "addChannel_ForSlack").split(",");
    	String[] alertData = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.notificationChannelsExcelPath, IPathConstant.notificationChannelsSheet, "dataForSampleAlertCreation").split(",");
    	String title = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.notificationChannelsExcelPath, IPathConstant.notificationChannelsSheet, "deleteChannelPopupTitle");
    	String message = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath, IPathConstant.messageSheet, "NotificationCahnnel_WarningMsgWhileDeletingAChannelAssociatedWithAlert");
    	alerts.createAnAlertToValidateNotificationChannelDeletion(alertData, data[0]);
		new CommonPage(page).navigateToNotificationChannel();
		page.click(messageCloseBtn);
		page.fill(searchTextfield, data[0]);
    	page.click(searchIcon);
    	page.waitForSelector(channelNamesColumnData);
    	Locator channels = page.locator(channelNamesColumnData);
    	for(int i=0; i<channels.count(); i++) {
    		if(channels.nth(i).textContent().trim().equals(data[0])) {
    			page.locator(deleteBtns).nth(i).click();
    			page.waitForSelector(popupWindowTitle);
    			Assert.assertTrue(page.textContent(popupWindowTitle).equals(title));
    			String popupMsg = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.notificationChannelsExcelPath, IPathConstant.notificationChannelsSheet, "deleteChannelPopupMsg");
    			popupMsg = popupMsg.replace("''", "'"+data[0]+"'");
    			page.textContent(alertInfoInDeleteChannelPopup).trim().contains(message);
    			page.click(viewTaggedAlertsLink);
    			int sum = 0;
    			Locator alert = page.locator(taggedAlerts);
    			for(int j=0; j<alert.count(); j++) {
    				sum = sum + Integer.parseInt(alert.nth(j).textContent().trim());
    			}
                Assert.assertTrue(sum > 0);
    		}
    	}
    	page.click(popupWindowCloseBtn);
    }
    
    public void validateTheDeletionOfNotificationChannels() throws EncryptedDocumentException, IOException {
    	String[] data = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.notificationChannelsExcelPath, IPathConstant.notificationChannelsSheet, "addChannel_ForSlack").split(",");
    	checkForTheNotificationChannelAndDelete(data[0]);
    	data = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.notificationChannelsExcelPath, IPathConstant.notificationChannelsSheet, "addChannel_ForWebhook").split(",");
    	checkForTheNotificationChannelAndDelete(data[0]);
    	data = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.notificationChannelsExcelPath, IPathConstant.notificationChannelsSheet, "channelNameToUpadte").split(",");
    	checkForTheNotificationChannelAndDelete(data[0]);
    }
    
    public void clearDataSectionInAddChannelPopupWindowAndValidate() throws EncryptedDocumentException, IOException {
    	String[] data = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.notificationChannelsExcelPath, IPathConstant.notificationChannelsSheet, "addChannel_ForWebhook").split(",");
    	String message = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath, IPathConstant.messageSheet, "NotificationCahnnel_InvalidJsonMsg");
    	//page.pause();
    	navigateToAddChannelPopupWindow();
    	util.selectTheOptionFromDropDown(page, channelTypeDropdown, excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.notificationChannelsExcelPath, IPathConstant.notificationChannelsSheet, "channelType_webhook"));
    	page.fill(channelNameTextField, data[0]);
    	page.fill(emailAddressTextField, data[1]);
    	page.click(plusButton);
    	Locator elements = page.locator(dataFieldElements);
    	for(int i=0; i<elements.count(); i++) {
    		elements.nth(i).fill("");
    		page.waitForTimeout(100);
    	}
    	page.click(saveBtn);
    	Assert.assertTrue(page.textContent(invalidJsonMsg).trim().equalsIgnoreCase(message));
    	page.click(popupWindowCloseBtn);
    }
    
    public void createWebhookNotificationChannelWithEditedJsonAndValidate() throws EncryptedDocumentException, IOException {
    	String[] data = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.notificationChannelsExcelPath, IPathConstant.notificationChannelsSheet, "addChannel_ForWebhook").split(",");
    	String message = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath, IPathConstant.messageSheet, "NotificationCahnnel_channelCreationConfirmationMsg");
    	navigateToAddChannelPopupWindow();
    	util.selectTheOptionFromDropDown(page, channelTypeDropdown, excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.notificationChannelsExcelPath, IPathConstant.notificationChannelsSheet, "channelType_webhook"));
    	page.fill(channelNameTextField, data[0]);
    	page.fill(emailAddressTextField, data[1]);
    	page.click(plusButton);
    	Locator elements = page.locator(dataFieldElements);
    	for(int i=0; i<3; i++) {
    		elements.nth(i).fill("");
    		page.waitForTimeout(100);
    	}
    	page.click(saveBtn);
    	page.waitForSelector(confirmationMessage);
    	Assert.assertTrue(page.textContent(confirmationMessage).trim().contains(message));
    	page.click(messageCloseBtn);
    }
    
    public void validatePagination(int num) {
		common.selectPaginationAndValidate(page, num, channelNamesColumnData);
	}
	
}
