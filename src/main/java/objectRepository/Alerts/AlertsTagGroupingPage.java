package objectRepository.Alerts;

import org.testng.Assert;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;

import genericUtilities.ExcelUtility;
import genericUtilities.GenericMethods;

public class AlertsTagGroupingPage 
{
	Page page;
	ExcelUtility excel = new ExcelUtility();
	GenericMethods util = new GenericMethods();
	
	private String tagGroupingTabTitle = "#nav-tab-tagGroupingV2";
	private String tagGroupingTab = "xpath = (//div[@class='item']/descendant::div[@class='routeLinkBox'])[position()=3]";
	
	private String addAlertButton = "xpath = //button[@id='btn-add-channel']";
	private String addAlertDescription = "xpath = //div[@class='alert-form-subtext']";
	private String softRefresh = "#btn-refresh";
	private String alertName = "xpath = (//div[@class='mb-lg-1 mb-xl-1']/descendant::label[@class='cus-mod-label'])[position()=1]";
	private String service = "xpath = (//div[@class='mb-lg-1 mb-xl-1']/descendant::label[@class='cus-mod-label'])[position()=2]";
	private String metric = "xpath = (//div[@class='mb-lg-1 mb-xl-1']/descendant::label[@class='cus-mod-label'])[position()=3]";
	private String aggregationType = "xpath = (//div[@class='mb-lg-1 mb-xl-1']/descendant::label[@class='cus-mod-label'])[position()=4]";
	private String operator = "xpath = (//div[@class='mb-lg-1 mb-xl-1']/descendant::label[@class='cus-mod-label'])[position()=5]";
	private String thresholdValue = "xpath = (//div[@class='mb-lg-1 mb-xl-1']/descendant::label[@class='cus-mod-label'])[position()=6]";
	private String timePeriod = "xpath = (//div[@class='mb-lg-1 mb-xl-1']/descendant::label[@class='cus-mod-label'])[position()=7]";
	private String recoveryPeriod = "xpath = (//div[@class='mb-lg-1 mb-xl-1']/descendant::label[@class='cus-mod-label'])[position()=8]";
	private String silencePeriod = "xpath = (//div[@class='mb-lg-1 mb-xl-1']/descendant::label[@class='cus-mod-label'])[position()=9]";
	private String notificationChannel = "xpath = (//div[@class='mb-lg-1 mb-xl-1']/descendant::label[@class='cus-mod-label'])[position()=10]";
	private String alertTags = "xpath = (//div[@class='mb-lg-1 mb-xl-1']/descendant::label[@class='cus-mod-label'])[position()=11]";
	private String alertTagsEnterKey = "xpath = //input[@placeholder='Enter key']";
	private String alertTagsEnterKey2 = "xpath = (//input[@placeholder='Enter key'])[position()=2]";
	private String alertTagsEnterValue = "xpath = //input[@placeholder='Enter value']";
	private String plusIcon = "xpath = //span[@class='action-icon']";
	private String errorMessageForKey = "xpath = //p[@class='validation']";
	private String errorMessageForValue = "xpath = //p[@class='validation']";
	private String deleteIcon = "xpath = (//div[@class='alertV2-form-add-tag-icon'])[position()=2]";
	private String groupNameError = "xpath = (//p[@class='validation'])[position()=1]";
	
	private String clickClose = "xpath = //button[@class='ant-modal-close']";
	private String metricDropDown = "xpath = (//button[@id='btn-arrow-down-search-select-metric-type'])[position()=1]";
	private String metricSearch = "xpath = //input[@id='input-search-sel-search-select-metric-type']";
	private String metricSelectOption = "#search-select-metric-type-0-single";	
	private String sumOption = "xpath = (//span[@id='search-select-metric-type-0-single'])[position()=2]";
	private String averageOption = "xpath = (//span[@id='search-select-metric-type-1-single'])[position()=1]";
	private String countOption = "xpath = (//span[@id='search-select-metric-type-2-single'])[position()=1]";
	private String dynamicOption = "xpath = (//span[@id='search-select-metric-type-3-single'])[position()=1]";
	
	private String alertNameText = "#input-alert-name";
	private String enterKeyText = "#tag_key_0";
	private String enterValueText = "#tag_value_0";
	private String enterValueText2 = "#tag_value_1";
	
	private String greaterThanOption = "#search-select-operator-0-single";
	private String lesserThanOption = "#search-select-operator-1-single";
	private String equalToOption = "#search-select-operator-2-single";
	private String greaterThanOrEqualToOption = "#search-select-operator-3-single";
	private String lesserThanOrEqualToOption = "#search-select-operator-4-single";
	
	private String timePeriodMin = "xpath = (//div[@class='input-group-append'])[position()=1]";
	private String recoveryPeriodMin = "xpath = (//div[@class='input-group-append'])[position()=2]";
	private String silencePeriodMin = "xpath = (//div[@class='input-group-append'])[position()=3]";
	
	private String notificationChannelsSelectChannel ="#search-select-notificationChannel";
	private String clearButton = "#btn-alert-modal-clr";
	private String addButton = "#btn-alert-modal-add";
	private String addTagGroupButton = "#tag-grouping-add-open-form";
	private String addTagGroupTitle = "xpath = //div[@class='rk-sidebox-title ml-3 highlighted-title']/descendant::span[@class='title']";
	private String closeAddTagGroup = "xpath = //div[@class='rk-sidebox-title ml-3 highlighted-title']/descendant::div[@class='action1 rk-sidebox-close right-close']";
	private String saveAddTagGroup = "xpath = //button[@id='tag-form-footer-right-next-or-save']";
	private String tagGroupNameTitle = "xpath = (//div[@class='stepper-label highlightText'])[position()=1]";
	private String groupNameTitle = "xpath = //div[@class='tag-group-name-box']/descendant::label[@class='cus-mod-label']";
	private String groupNameText = "#tag-group-name-field";
	private String keyTitle = "xpath = (//label[@class='cus-mod-label'])[position()=2]";
	private String keyOption = "xpath = (//div[@class='selected-text-container selected-pre-icon'])[position()=1]";
	
	private String groupingCondition = "xpath = (//label[@class='cus-mod-label'])[position()=3]";
	private String groupingConditionAllRadioButton = "xpath = //input[@class='tag-radio-grouping-condition']";
	private String groupingConditionAllOption = "xpath = (//label[@class='tag-group-all-cust-radio-label'])[position()=1]";
	private String groupingConditionCustomRadioButton = "#tag-group-condition-radio-custom";
	private String groupingConditionCustomOption = "xpath = (//label[@class='tag-group-all-cust-radio-label'])[position()=2]";
	private String groupingConditionCustomExpression = "xpath = //div[@class='tag-group-custom-exp-box']/descendant::label[@class='cus-mod-label']";
	
	private String value = "xpath = (//label[@class='cus-mod-label'])[position()=4]";
	
	private String groupA = "xpath = (//div[@class='conditon-header-label'])[position()=1]";
	private String groupAOption1Title1 = "xpath = (//div[@id='tag-group-condition-left-0']/descendant::div[@class='item-text ellipsis'])[position()=1]";
	private String groupAOption1Title2 = "xpath = (//div[@id='tag-group-condition-left-0']/descendant::div[@class='item-text ellipsis'])[position()=2]";
	private String groupAOption2Title1 = "xpath = (//div[@id='tag-group-condition-right-0']/descendant::div[@class='item-text ellipsis'])[position()=1]";
	private String groupAOption2Title2 = "xpath = (//div[@id='tag-group-condition-right-0']/descendant::div[@class='item-text ellipsis'])[position()=2]";
	private String groupAANDRadioButton = "#tag-group-condition-AND-0";
	private String groupAORRadioButton = "#tag-group-condition-OR-0";
	private String groupAAND = "xpath = //label[@for='tag-group-condition-AND-0']";
	private String groupAOR = "xpath = //label[@for='tag-group-condition-OR-0']";
	
	private String addOption = "#tag-grouping-condition-add";
	
	private String groupB = "xpath = (//div[@class='conditon-header-label'])[position()=2]";
	private String groupBANDRadioButton = "#tag-group-condition-AND-1";
	private String groupBORRadioButton = "#tag-group-condition-OR-1";
	private String groupBAND = "xpath = //label[@for='tag-group-condition-AND-1']";
	private String groupBOR = "xpath = //label[@for='tag-group-condition-OR-1']";
	private String groupBDeleteBox = "xpath = (//button[@class='button button-secondary conditon-delete-icon-btn'])[position()=2]";
	
	private String groupC = "xpath = (//div[@class='conditon-header-label'])[position()=3]";
	private String groupCANDRadioButton = "#tag-group-condition-AND-2";
	private String groupCORRadioButton = "#tag-group-condition-OR-2";
	private String groupCAND = "xpath = //label[@for='tag-group-condition-AND-2']";
	private String groupCOR = "xpath = //label[@for='tag-group-condition-OR-2']";
	private String groupCDeleteBox = "xpath = (//button[@class='button button-secondary conditon-delete-icon-btn'])[position()=3]";
	
	private String groupD = "xpath = (//div[@class='conditon-header-label'])[position()=4]";
	private String groupDANDRadioButton = "#tag-group-condition-AND-3";
	private String groupDORRadioButton = "#tag-group-condition-OR-3";
	private String groupDAND = "xpath = //label[@for='tag-group-condition-AND-3']";
	private String groupDOR = "xpath = //label[@for='tag-group-condition-OR-3']";
	private String groupDDeleteBox = "xpath = (//button[@class='button button-secondary conditon-delete-icon-btn'])[position()=3]";
	
	private String groupE = "xpath = (//div[@class='conditon-header-label'])[position()=5]";
	private String groupEANDRadioButton = "#tag-group-condition-AND-4";
	private String groupEORRadioButton = "#tag-group-condition-OR-4";
	private String groupEAND = "xpath = //label[@for='tag-group-condition-AND-4']";
	private String groupEOR = "xpath = //label[@for='tag-group-condition-OR-4']";
	private String groupEDeleteBox = "xpath = (//button[@class='button button-secondary conditon-delete-icon-btn'])[position()=2]";
	
	private String clearOption1 = "#tag-form-footer-clear";
	private String nextOption1 = "#tag-form-footer-right-next-or-save";
	private String timeFrameNameTitle = "xpath = (//div[@class='stepper-label highlightText'])[position()=2]";
	private String timeFrameGroupAggregationTime = "xpath = (//div[@class='tag-time-frame-box']/descendant::label[@class='cus-mod-label'])[position()=1]";
	private String timeFrameGroupAggregationTimeOptions = "#tag-group-aggregation-time-field";
	private String timeFrameManualNotificationText = "xpath = (//div[@class='tag-time-frame-box']/descendant::label[@class='cus-mod-label'])[position()=2]";
	private String timeFrameManualNotificationTextSpace = "#tag-form-manual-notification-text";
	private String timeFrameManualNotificationTextChar = "xpath = //div[@class='textarea-char-remaining']";
	private String clearOption2 = "#tag-form-footer-clear";
	private String nextOption2 = "#tag-form-footer-right-next-or-save";
	
	private String notificationTitle = "xpath = (//div[@class='stepper-label highlightText'])[position()=3]";
	private String notificationChannelTitle = "xpath = (//div[@class='tag-notification-page']/descendant::label[@class='cus-mod-label'])[position()=1]";
	private String notificationSelectChannel = "#tag-group-channel-field";
	private String notificationSelectChannelDropDown = "xpath = //button[@id='btn-arrow-down-tag-group-channel-field']";
	private String nameSearchChannel = "xpath = //input[@id='input-search-sel-tag-group-channel-field']";
	private String searchedChannel = "xpath = //div[@id='tag-group-channel-field-Sonali Mishra-multi']";
	private String closeSearch = "xpath = //button[@class='close-btn']";
	
	private String notificationSetPriorityTitle = "xpath = (//div[@class='tag-notification-page']/descendant::label[@class='cus-mod-label'])[position()=2]";
	private String notificationSetPriorityRadio1 = "#tag-group-set-priority-CRITICAL";
	private String notificationSetPriorityRadio2 = "#tag-group-set-priority-WARNING";
	private String notificationSetPriorityRadio3 = "#tag-group-set-priority-DEBUG";
	private String notificationSetPriorityRadio4 = "#tag-group-set-priority-INFO";
	private String notificationSetPriorityOption1 = "xpath = //label[@for='tag-group-set-priority-CRITICAL']";
	private String notificationSetPriorityOption2 = "xpath = //label[@for='tag-group-set-priority-WARNING']";
	private String notificationSetPriorityOption3 = "xpath = //label[@for='tag-group-set-priority-DEBUG']";
	private String notificationSetPriorityOption4 = "xpath = //label[@for='tag-group-set-priority-INFO']";
	private String clearOption3 = "#tag-form-footer-clear";
	private String nextOption3 = "#tag-form-footer-right-next-or-save";
	
	private String header1 = "xpath = (//td[@class='header-td'])[position()=1]";
	private String header2 = "xpath = (//td[@class='header-td'])[position()=2]";
	private String header3 = "xpath = (//td[@class='header-td'])[position()=3]";
	private String header4 = "xpath = (//td[@class='header-td'])[position()=4]";
	private String header5 = "xpath = (//td[@class='header-td'])[position()=5]";
	private String header6 = "xpath = (//td[@class='header-td'])[position()=6]";
	private String editOption1 = "xpath = (//div[@class='alert-tag-edit-icon'])[position()=1]";
	private String deleteOption1 = "xpath = (//div[@class='alert-tag-delete-icon'])[position()=1]";
	private String deletePopupTitle = "xpath = //div[@class='rex-modal-header-box']";
	private String deletePopupDescription = "xpath = //div[@class='ant-modal-body']";
	private String deletePopupCancelOption = "#delete-aler-tag-btn-cancel";
	private String deletePopupDeleteOption = "#delete-alert-tag-btn-submit";
	private String deletePopupClose = "xpath = //button[@class='ant-modal-close']";
	private String deleteOptionActionItem = "xpath = (//div[@class='alert-tag-delete-icon'])[position()=1]";
	
	public AlertsTagGroupingPage(Page page) {
		this.page = page;
	}
		
	public void navigateToTagGroupingTab() {
		page.locator(tagGroupingTab).click();
		page.waitForLoadState(LoadState.NETWORKIDLE);
	}

	public void closeAddAlert() {
		page.locator(clickClose).click();
		page.waitForLoadState(LoadState.NETWORKIDLE);
	}
	
	public void validateTagGroupingPageTitle(String expectedTitle) {		  
		String actualTitle = page.locator(tagGroupingTabTitle).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}

	public void verifyAddTagGroupButtonIsPresentInTheTagGroupingTab(String expectedTitle) {
		String actualTitle = page.locator(addTagGroupButton).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);		
	}

	public void clickSoftRefreshButtonInTheTagGroupingTab() {
		page.locator(softRefresh).click();
		page.waitForLoadState(LoadState.NETWORKIDLE);
	}

	public void verifyAddAlertButtonIsDisplayedInTagGroupingTab(String expectedTitle) {
		String actualTitle = page.locator(addAlertButton).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);		
	}
	
	public void verifyAddAlertDescription(String expectedTitle) {
		String actualTitle = page.locator(addAlertDescription).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);		
	}
	public void navigateToAddAlertPopup() {
		page.locator(addAlertButton).click();
		page.waitForLoadState(LoadState.NETWORKIDLE);
		Assert.assertTrue(page.locator(alertName).isVisible(), "Add Alert Popup is opened.");
	}

	public void verifyAlertNameIsDisplayedInAddAlert(String expectedTitle) {
		page.waitForTimeout(2000);
		String actualTitle = page.locator(alertName).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);		
	}
	
	public void verifyServiceIsDisplayedInAddAlert(String expectedTitle) {
		String actualTitle = page.locator(service).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);		
	}
	
	public void verifyMetricIsDisplayedInAddAlert(String expectedTitle) {
		String actualTitle = page.locator(metric).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);		
	}
	
	public void verifyAggregationTypeIsDisplayedInAddAlert(String expectedTitle) {
		String actualTitle = page.locator(aggregationType).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);		
	}
	
	public void verifyOperatorIsDisplayedInAddAlert(String expectedTitle) {
		String actualTitle = page.locator(operator).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);		
	}
	
	public void verifyThresholdValueIsDisplayedInAddAlert(String expectedTitle) {
		String actualTitle = page.locator(thresholdValue).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);		
	}
	public void verifyTimePeriodIsDisplayedInAddAlert(String expectedTitle) {
		String actualTitle = page.locator(timePeriod).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);		
	}
	
	public void verifyRecoveryPeriodIsDisplayedInAddAlert(String expectedTitle) {
		String actualTitle = page.locator(recoveryPeriod).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);		
	}
	
	public void verifySilencePeriodIsDisplayedInAddAlert(String expectedTitle) {
		String actualTitle = page.locator(silencePeriod).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);		
	}
	
	public void verifyNotificationChannelsIsDisplayedInAddAlert(String expectedTitle) {
		String actualTitle = page.locator(notificationChannel).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);		
	}
	
	public void verifyAlertTagsIsDisplayedInAddAlert(String expectedTitle) {
		String actualTitle = page.locator(alertTags).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);		
	}
	
	public void verifyAlertTagsEnterKeyIsDisplayedInAddAlert(String expectedTitle) {
		String actualTitle = page.locator(alertTagsEnterKey).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);		
	}
	
	public void verifyAlertTagsEnterValueIsDisplayedInAddAlert(String expectedTitle) {
		String actualTitle = page.locator(alertTagsEnterValue).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);		
	}
	
	public void verfiyAlertTagsEnterKeyCharactersAcceptance() {
		
		//Alert Name Text 
		page.fill(alertNameText, "sample1");
		page.waitForLoadState(LoadState.NETWORKIDLE);
		
		//20 chars
		page.fill(alertTagsEnterKey, "AddAlertAlertTagSamp");
		page.waitForLoadState(LoadState.NETWORKIDLE);
		//Enter Value Text
		page.fill(enterValueText, "10");
		page.waitForLoadState(LoadState.NETWORKIDLE);
		page.locator(plusIcon).click();
		
		//More than 20 chars
		page.fill(alertTagsEnterKey, "AddAlertAlertTagSample");
		page.waitForLoadState(LoadState.NETWORKIDLE);
		Assert.assertTrue(page.locator(errorMessageForKey).isVisible(), "Error Message is visible for more than 20 chars in Keys");
		page.locator(deleteIcon).click();
		
		page.locator(addButton).click();
	}
	
	public void verfiyAlertTagsEnterKeyAndValueDuplicate() {

		//Alert Name Text 
		page.fill(alertNameText, "sample2");
		page.waitForLoadState(LoadState.NETWORKIDLE);
		
		page.fill(alertTagsEnterKey, "post");
		page.waitForLoadState(LoadState.NETWORKIDLE);
		//Enter Value Text
		page.fill(enterValueText, "20");
		page.waitForLoadState(LoadState.NETWORKIDLE);
		page.locator(plusIcon).click();
		
		//Duplicate Key
		page.fill(alertTagsEnterKey2, "post");
		page.waitForLoadState(LoadState.NETWORKIDLE);
		Assert.assertTrue(page.locator(errorMessageForKey).isVisible(), "Error Message is visible for Duplicate Keys");
		page.locator(deleteIcon).click();
		
		//Duplicate Value
		page.locator(plusIcon).click();
		page.fill(alertTagsEnterKey, "post 1");
		page.waitForLoadState(LoadState.NETWORKIDLE);
		//Enter Value Text
		page.fill(enterValueText2, "20");
		page.waitForLoadState(LoadState.NETWORKIDLE);
		page.locator(plusIcon).click();
		
		page.locator(addButton).click();
	}
	
	public void verfiyAlertTagsEnterValueCharactersAcceptance() {
		
		//Alert Name Text 
		page.fill(alertNameText, "sample3");
		page.waitForLoadState(LoadState.NETWORKIDLE);
		
		//50 chars
		page.fill(alertTagsEnterKey, "AddAlert");
		page.waitForLoadState(LoadState.NETWORKIDLE);
		//Enter Value Text
		page.fill(enterValueText, "51899987987987987687567865436789654356789654567865");
		page.waitForLoadState(LoadState.NETWORKIDLE);
		page.locator(plusIcon).click();
		
		//More than 50 chars
		page.fill(alertTagsEnterValue, "51899987987987987687567865436789654356789654567865898");
		page.waitForLoadState(LoadState.NETWORKIDLE);
		Assert.assertTrue(page.locator(errorMessageForValue).isVisible(), "Error Message is visible for more than 50 chars in Values");
		page.locator(deleteIcon).click();
		
		page.locator(addButton).click();
	}
	
	
	
	
	
	public void verifyAddAlertPopup() {
	
		//Alert Name Text 
		page.fill(alertNameText, "automation");
		page.waitForLoadState(LoadState.NETWORKIDLE);
	
		page.waitForTimeout(1000);
		//Enter Key Text
		page.fill(enterKeyText, "text");
		page.waitForLoadState(LoadState.NETWORKIDLE);
		
		//Enter Value Text
		page.fill(enterValueText, "10");
		page.waitForLoadState(LoadState.NETWORKIDLE);
		
		page.locator(addButton).click();
	}
	
	
	public void verifyClearButtonClick() {
		
		//Alert Name Text 
		page.fill(alertNameText, "clear");
		page.waitForLoadState(LoadState.NETWORKIDLE);
		page.waitForTimeout(1000);
		//Enter Key Text
		page.fill(enterKeyText, "limit");
		page.waitForLoadState(LoadState.NETWORKIDLE);
		
		//Enter Value Text
		page.fill(enterValueText, "1");
		page.waitForLoadState(LoadState.NETWORKIDLE);
		
		page.locator(clearButton).click();
		page.waitForTimeout(2000);
		
		Assert.assertTrue(page.locator(clearButton).isVisible(), "Error Message is visible after c;licking Clear Button");
	}
	
	/////
	
	public void verifyMetricValueOptionIsDisplayedInAddAlert(String metricOptions) {		
		util.selectTheOptionFromDropDownBySearch(page, metricDropDown, metricSearch, metricOptions, metricSelectOption);
		page.waitForLoadState(LoadState.NETWORKIDLE);
	}
	
	public void verifyAggregationTypeSumOptionIsDisplayedInAddAlert(String expectedTitle) {
		page.waitForTimeout(2000);
		String actualTitle = page.locator(sumOption).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);		
	}
	
	public void verifyAggregationTypeAverageOptionIsDisplayedInAddAlert(String expectedTitle) {
		page.waitForTimeout(2000);
		String actualTitle = page.locator(averageOption).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);		
	}
	
	public void verifyAggregationTypeCountOptionIsDisplayedInAddAlert(String expectedTitle) {
		page.waitForTimeout(2000);
		String actualTitle = page.locator(countOption).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);		
	}
	
	public void verifyAggregationTypeDynamicOptionIsDisplayedInAddAlert(String expectedTitle) {
		page.waitForTimeout(2000);
		String actualTitle = page.locator(dynamicOption).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);		
	}
	
	public void verifyOperatorGreaterThanOptionIsDisplayedInAddAlert(String expectedTitle) {
		page.waitForTimeout(2000);
		String actualTitle = page.locator(greaterThanOption).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);		
	}
	
	public void verifyOperatorLesserThanOptionIsDisplayedInAddAlert(String expectedTitle) {
		page.waitForTimeout(2000);
		String actualTitle = page.locator(lesserThanOption).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);		
	}
	
	public void verifyOperatorEqualToOptionIsDisplayedInAddAlert(String expectedTitle) {
		page.waitForTimeout(2000);
		String actualTitle = page.locator(equalToOption).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);		
	}
	
	public void verifyOperatorGreaterThanOrEqualToOptionIsDisplayedInAddAlert(String expectedTitle) {
		page.waitForTimeout(2000);
		String actualTitle = page.locator(greaterThanOrEqualToOption).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);		
	}
	
	public void verifyOperatorLesserThanOrEqualToOptionIsDisplayedInAddAlert(String expectedTitle) {
		page.waitForTimeout(2000);
		String actualTitle = page.locator(lesserThanOrEqualToOption).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);		
	}
	
	public void verifyTimePeriodMinIsDisplayedInAddAlert(String expectedTitle) {
		page.waitForTimeout(2000);
		String actualTitle = page.locator(timePeriodMin).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);		
	}
		
	public void verifyRecoveryPeriodMinIsDisplayedInAddAlert(String expectedTitle) {
		page.waitForTimeout(2000);
		String actualTitle = page.locator(recoveryPeriodMin).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);		
	}
	
	public void verifySilencePeriodMinIsDisplayedInAddAlert(String expectedTitle) {
		page.waitForTimeout(2000);
		String actualTitle = page.locator(silencePeriodMin).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);		
	}
	
	public void verifyNotificationChannelsSelectChannelIsDisplayedInAddAlert(String expectedTitle) {
		page.waitForTimeout(2000);
		String actualTitle = page.locator(notificationChannelsSelectChannel).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);		
	}
	
	public void verifyClearButtonIsDisplayedInAddAlert(String expectedTitle) {
		page.waitForTimeout(2000);
		String actualTitle = page.locator(clearButton).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);		
	}
	
	public void verifyAddButtonIsDisplayedInAddAlert(String expectedTitle) {
		page.waitForTimeout(2000);
		String actualTitle = page.locator(addButton).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);		
	}
	
	////
	
	public void navigateToAddTagGroupPopup() {
		page.locator(addTagGroupButton).click();
		page.waitForLoadState(LoadState.NETWORKIDLE);
		Assert.assertTrue(page.locator(addTagGroupTitle).isVisible(), "Add Tag Group Popup is opened.");
	}
	
	public void validateAddTagGroupTitle(String expectedTitle) {
		String actualTitle = page.locator(addTagGroupTitle).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);		
	}
	
	public void validateTagGroupNameTitle(String expectedTitle) {
		String actualTitle = page.locator(tagGroupNameTitle).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);		
	}
	
	public void validateGroupNameTitle(String expectedTitle) {
		String actualTitle = page.locator(groupNameTitle).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);		
	}
	
	public void validateGroupNameCharLimit() {
		
		//Group Name Text - 31 chars
		page.fill(groupNameText, "hugjyftfgdhjklfhgjklopjnjnjnjoj");
		page.waitForLoadState(LoadState.NETWORKIDLE);
		page.locator(groupingConditionCustomRadioButton).click();
		Assert.assertTrue(page.locator(groupNameError).isVisible(), "Error Message is visible after having more than 30 chars");
	}
	
	public void validateEnterGroupName() {
		page.fill(groupNameText, "abc");
		page.waitForLoadState(LoadState.NETWORKIDLE);
	}
	
	public void validateKeyTitle(String expectedTitle) {
		String actualTitle = page.locator(keyTitle).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);		
	}
	
	public void validateKeyOption(String expectedTitle) {
		page.waitForTimeout(2000);
		String actualTitle = page.locator(keyOption).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);		
	}
	
	public void validateGroupingConditionTitle(String expectedTitle) {
		String actualTitle = page.locator(groupingCondition).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);		
	}
	
	public void validateGroupingConditionAllRadioButton() {
		page.locator(groupingConditionAllRadioButton).click();
		page.waitForLoadState(LoadState.NETWORKIDLE);
	}
	
	public void validateGroupingConditionAllOption(String expectedTitle) {
		String actualTitle = page.locator(groupingConditionAllOption).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);		
	}
	
	public void validateGroupingConditionCustomRadioButton(String expectedTitle) {
		String actualTitle = page.locator(groupingConditionCustomRadioButton).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);		
	}
	
	public void validateGroupingConditionCustomOption(String expectedTitle) {
		String actualTitle = page.locator(groupingConditionCustomOption).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);		
	}
	
	public void verifyGroupingConditionCustomOption(String expectedTitle) {
		
		page.fill(groupNameText, "deal");
		page.waitForLoadState(LoadState.NETWORKIDLE);
		page.locator(groupingConditionCustomRadioButton).click();
		
		String actualTitle = page.locator(groupingConditionCustomExpression).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);	
	}
	
	public void validateValueTitle(String expectedTitle) {
		String actualTitle = page.locator(value).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);		
	}
	
	public void validateValueGroupATitle(String expectedTitle) {
		String actualTitle = page.locator(groupA).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);		
	}
	
	public void validateValueGroupAOption1Title1(String expectedTitle) {
		String actualTitle = page.locator(groupAOption1Title1).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}
	
	public void validateValueGroupAOption1Title2(String expectedTitle) {
		String actualTitle = page.locator(groupAOption1Title2).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}
	
	public void validateValueGroupAOption2Title1(String expectedTitle) {
		String actualTitle = page.locator(groupAOption2Title1).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}
	
	public void validateValueGroupAOption2Title2(String expectedTitle) {
		String actualTitle = page.locator(groupAOption2Title2).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}
	
	public void navigateFromAddTagGroupToTimeFrame() {
		
		//navigateToAddTagGroupButton
		page.locator(addTagGroupButton).click();
		page.waitForLoadState(LoadState.NETWORKIDLE);
		
		//validateEnterGroupName
		page.fill(groupNameText, "abc");
		page.waitForLoadState(LoadState.NETWORKIDLE);
		
		//selectValueGroupAOption1Title2
		page.click("//div[@class='tag-condition-fields-box']/child::div[@class='rex-service-sel select-metric-field']");
		if(!page.isVisible("//div[text()='Group A ']/following-sibling::div//div[@class='items']/div[@class='item-text ellipsis'][last()]"))
		{
			page.click("//div[@class='tag-condition-fields-box']/child::div[@class='rex-service-sel select-metric-field']");
		}
		page.click("//div[text()='Group A ']/following-sibling::div//div[@class='items']/div[@class='item-text ellipsis'][last()]");
	
		//selectValueGroupAOption2Title1
		page.click("//div[@class='tag-grpup-value-and-delete-box']/child::div[@class='rex-service-sel select-metric-field']");
		if(!page.isVisible("(//div[text()='Group A ']/following-sibling::div//div[@class='items']/div[@class='item-text ellipsis'])[position()=1]"))
		{
			page.click("//div[@class='tag-grpup-value-and-delete-box']/child::div[@class='rex-service-sel select-metric-field']");
		}
		page.click("(//div[text()='Group A ']/following-sibling::div//div[@class='items']/div[@class='item-text ellipsis'])[position()=1]");

		//validateValueNextClick
		page.locator(nextOption1).click();
		page.waitForLoadState(LoadState.NETWORKIDLE);
		
		Assert.assertTrue(page.locator(timeFrameNameTitle).isVisible(), "Navigated from Add Tag Group to Time Frame Popup.");
	}
	
	public void navigateFromAddTagGroupToNotification() {
		
		//navigateToAddTagGroupButton
		page.locator(addTagGroupButton).click();
		page.waitForLoadState(LoadState.NETWORKIDLE);
		
		//validateEnterGroupName
		page.fill(groupNameText, "rak");
		page.waitForLoadState(LoadState.NETWORKIDLE);
		
		//selectValueGroupAOption1Title2
		page.click("//div[@class='tag-condition-fields-box']/child::div[@class='rex-service-sel select-metric-field']");
		if(!page.isVisible("//div[text()='Group A ']/following-sibling::div//div[@class='items']/div[@class='item-text ellipsis'][last()]"))
		{
			page.click("//div[@class='tag-condition-fields-box']/child::div[@class='rex-service-sel select-metric-field']");
		}
		page.click("//div[text()='Group A ']/following-sibling::div//div[@class='items']/div[@class='item-text ellipsis'][last()]");
	
		//selectValueGroupAOption2Title1
		page.click("//div[@class='tag-grpup-value-and-delete-box']/child::div[@class='rex-service-sel select-metric-field']");
		if(!page.isVisible("(//div[text()='Group A ']/following-sibling::div//div[@class='items']/div[@class='item-text ellipsis'])[position()=1]"))
		{
			page.click("//div[@class='tag-grpup-value-and-delete-box']/child::div[@class='rex-service-sel select-metric-field']");
		}
		page.click("(//div[text()='Group A ']/following-sibling::div//div[@class='items']/div[@class='item-text ellipsis'])[position()=1]");

		//validateValueNextClick
		page.locator(nextOption1).click();
		page.waitForLoadState(LoadState.NETWORKIDLE);
		
		//validateTimeFrameNextButton
		page.locator(nextOption2).click();
		page.waitForLoadState(LoadState.NETWORKIDLE);
		
		Assert.assertTrue(page.locator(notificationTitle).isVisible(), "Navigated from Add Tag Group to Notification Popup.");
	}
	
	
	public void navigateFromAddTagGroupToNotification2() {
		
		//navigateToAddTagGroupButton
		page.locator(addTagGroupButton).click();
		page.waitForLoadState(LoadState.NETWORKIDLE);
		
		//validateEnterGroupName
		page.fill(groupNameText, "xyz");
		page.waitForLoadState(LoadState.NETWORKIDLE);
		
		//selectValueGroupAOption1Title2
		page.click("//div[@class='tag-condition-fields-box']/child::div[@class='rex-service-sel select-metric-field']");
		if(!page.isVisible("//div[text()='Group A ']/following-sibling::div//div[@class='items']/div[@class='item-text ellipsis'][last()]"))
		{
			page.click("//div[@class='tag-condition-fields-box']/child::div[@class='rex-service-sel select-metric-field']");
		}
		page.click("//div[text()='Group A ']/following-sibling::div//div[@class='items']/div[@class='item-text ellipsis'][last()]");
	
		//selectValueGroupAOption2Title1
		page.click("//div[@class='tag-grpup-value-and-delete-box']/child::div[@class='rex-service-sel select-metric-field']");
		if(!page.isVisible("(//div[text()='Group A ']/following-sibling::div//div[@class='items']/div[@class='item-text ellipsis'])[position()=1]"))
		{
			page.click("//div[@class='tag-grpup-value-and-delete-box']/child::div[@class='rex-service-sel select-metric-field']");
		}
		page.click("(//div[text()='Group A ']/following-sibling::div//div[@class='items']/div[@class='item-text ellipsis'])[position()=1]");

		//validateValueNextClick
		page.locator(nextOption1).click();
		page.waitForLoadState(LoadState.NETWORKIDLE);
		
		//validateTimeFrameNextButton
		page.locator(nextOption2).click();
		page.waitForLoadState(LoadState.NETWORKIDLE);
	}
	
	
	public void selectValueGroupAOption2Title1() {	
		page.click("//div[@class='tag-grpup-value-and-delete-box']/child::div[@class='rex-service-sel select-metric-field']");
		if(!page.isVisible("(//div[text()='Group A ']/following-sibling::div//div[@class='items']/div[@class='item-text ellipsis'])[position()=1]"))
		{
			page.click("//div[@class='tag-grpup-value-and-delete-box']/child::div[@class='rex-service-sel select-metric-field']");
		}
		page.click("(//div[text()='Group A ']/following-sibling::div//div[@class='items']/div[@class='item-text ellipsis'])[position()=1]");
	}
	
	public void selectValueGroupAOption1Title2() {		
		page.click("//div[@class='tag-condition-fields-box']/child::div[@class='rex-service-sel select-metric-field']");
		if(!page.isVisible("//div[text()='Group A ']/following-sibling::div//div[@class='items']/div[@class='item-text ellipsis'][last()]"))
		{
			page.click("//div[@class='tag-condition-fields-box']/child::div[@class='rex-service-sel select-metric-field']");
		}
		page.click("//div[text()='Group A ']/following-sibling::div//div[@class='items']/div[@class='item-text ellipsis'][last()]");
	}
	

	public void validateValueGroupAddButton4Times() {
		for (int i = 0; i < 4; i++) {
	    	page.locator(addOption).click();
	    }

	    Assert.assertTrue(page.locator(groupA).isVisible(), "Group A is not visible after click ");
        Assert.assertTrue(page.locator(groupB).isVisible(), "Group B is not visible after click ");	            
        Assert.assertTrue(page.locator(groupC).isVisible(), "Group C is not visible after click ");
        Assert.assertTrue(page.locator(groupD).isVisible(), "Group D is not visible after click ");
        page.waitForTimeout(1000);
        page.locator(addOption).click();
        Assert.assertTrue(page.locator(groupE).isVisible(), "Group E is not visible after click ");
        System.out.println("Add Button clicked and 5 Groups were added");
        
        page.waitForTimeout(1000);
        Assert.assertTrue(page.locator(groupAANDRadioButton).isVisible(), "Group A AND Radio Button is not visible after click " );
        Assert.assertTrue(page.locator(groupBANDRadioButton).isVisible(), "Group B AND Radio Button is not visible after click " );
        Assert.assertTrue(page.locator(groupCANDRadioButton).isVisible(), "Group C AND Radio Button is not visible after click " );
        Assert.assertTrue(page.locator(groupDANDRadioButton).isVisible(), "Group D AND Radio Button is not visible after click " );
        Assert.assertTrue(page.locator(groupEANDRadioButton).isVisible(), "Group E AND Radio Button is not visible after click " );
        System.out.println("AND Radio Buttons are visible");
        
        page.waitForTimeout(1000);
        Assert.assertTrue(page.locator(groupAORRadioButton).isVisible(), "Group A OR Radio Button is not visible after click " );
        Assert.assertTrue(page.locator(groupBORRadioButton).isVisible(), "Group B OR Radio Button is not visible after click " );
        Assert.assertTrue(page.locator(groupCORRadioButton).isVisible(), "Group C OR Radio Button is not visible after click " );
        Assert.assertTrue(page.locator(groupDORRadioButton).isVisible(), "Group D OR Radio Button is not visible after click " );
        Assert.assertTrue(page.locator(groupEORRadioButton).isVisible(), "Group E OR Radio Button is not visible after click " );
        System.out.println("OR Radio Buttons are visible");
        
        page.waitForTimeout(1000);
        Assert.assertTrue(page.locator(groupAAND).isVisible(), "Group A AND is not visible after click " );
        Assert.assertTrue(page.locator(groupBAND).isVisible(), "Group B AND is not visible after click " );
        Assert.assertTrue(page.locator(groupCAND).isVisible(), "Group C AND is not visible after click " );
        Assert.assertTrue(page.locator(groupDAND).isVisible(), "Group D AND is not visible after click " );
        Assert.assertTrue(page.locator(groupEAND).isVisible(), "Group E AND is not visible after click " );
        System.out.println("AND is visible");
        
        page.waitForTimeout(1000);
        Assert.assertTrue(page.locator(groupAOR).isVisible(), "Group A OR is not visible after click " );
        Assert.assertTrue(page.locator(groupBOR).isVisible(), "Group B OR is not visible after click " );
        Assert.assertTrue(page.locator(groupCOR).isVisible(), "Group C OR is not visible after click " );
        Assert.assertTrue(page.locator(groupDOR).isVisible(), "Group D OR is not visible after click " );
        Assert.assertTrue(page.locator(groupEOR).isVisible(), "Group E OR is not visible after click " );
        System.out.println("OR is visible");
        
        
        page.waitForTimeout(1000);
        page.locator(groupBDeleteBox).click();
        page.locator(groupCDeleteBox).click();
        page.locator(groupDDeleteBox).click();
        page.locator(groupEDeleteBox).click();
        System.out.println("Delete Box is visible");
        
        System.out.println("Validation completed for Adding 5 groups");
	}
	
	public void validateValueClearOptionTitle(String expectedTitle) {
		String actualTitle = page.locator(clearOption1).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);		
	}
	
	public void validateValueNextOptionTitle(String expectedTitle) {
		String actualTitle = page.locator(nextOption1).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);		
	}
	
	public void validateValueNextClick() {
		page.locator(nextOption1).click();
		page.waitForLoadState(LoadState.NETWORKIDLE);	
	}
	
	//////
	
	public void validateTimeFrameNameTitle(String expectedTitle) {
		page.waitForTimeout(2000);
		String actualTitle = page.locator(timeFrameNameTitle).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);		
	}
	
	public void validateTimeFrameGroupAggregationTimeTitle(String expectedTitle) {page.waitForTimeout(2000);
		String actualTitle = page.locator(timeFrameGroupAggregationTime).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);		
	}
	
	public void validateTimeFrameGroupAggregationTimeOption(String expectedTitle) {
		page.waitForTimeout(2000);
		String actualTitle = page.locator(timeFrameGroupAggregationTimeOptions).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);		
	}
	
	public void validateTimeFrameManualNotificationText(String expectedTitle) {
		page.waitForTimeout(2000);
		String actualTitle = page.locator(timeFrameManualNotificationText).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);		
	}
	
	public void validateTimeFrameManualNotificationTextSpace(String expectedTitle) {
		String actualTitle = page.locator(timeFrameManualNotificationTextSpace).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);		
	}
	
	public void validateTimeFrameManualNotificationTextChar(String expectedTitle) {
		String actualTitle = page.locator(timeFrameManualNotificationTextChar).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);		
	}
	
	public void validateTimeFrameManualNotification500Chars() {
		page.locator(timeFrameManualNotificationTextSpace).fill("In today’s fast-paced world, technology plays an increasingly central role in our lives. From the moment we wake up to the time we go to bed, we are surrounded by gadgets and devices designed to make our lives easier and more efficient. Smartphones, laptops, and smart home systems keep us connected and organized, while advancements in artificial intelligence and automation continue to reshape industries and job markets. As technology evolves, it is crucial to stay informed and adapt to these cha");
		page.waitForLoadState(LoadState.NETWORKIDLE);
	}
	
	public void validateTimeFrameClearOptionTitle(String expectedTitle) {
		String actualTitle = page.locator(clearOption2).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);		
	}
	
	public void validateTimeFrameNextOptionTitle(String expectedTitle) {
		String actualTitle = page.locator(nextOption2).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);		
	}
	
	
	public void validateNotificationTitle(String expectedTitle) {
		String actualTitle = page.locator(notificationTitle).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);		
	}
	
	public void validateNotificationChannelTitle(String expectedTitle) {
		String actualTitle = page.locator(notificationChannelTitle).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);		
	}
	
	public void validateNotificationSelectChannelTitle(String expectedTitle) {
		page.waitForTimeout(2000);
		String actualTitle = page.locator(notificationSelectChannel).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);		
	}
	
	public void validateNotificationSetPriorityTitle(String expectedTitle) {
		String actualTitle = page.locator(notificationSetPriorityTitle).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);		
	}
	
	public void validateNotificationSetPriorityRadio1() {
		page.waitForTimeout(2000);
		page.locator(notificationSetPriorityRadio1).click();
		page.waitForLoadState(LoadState.NETWORKIDLE);
	}
	
	public void validateNotificationSetPriorityRadio2() {
		page.waitForTimeout(2000);
		page.locator(notificationSetPriorityRadio2).click();
		page.waitForLoadState(LoadState.NETWORKIDLE);		
	}
	
	public void validateNotificationSetPriorityRadio3() {
		page.waitForTimeout(2000);
		page.locator(notificationSetPriorityRadio3).click();
		page.waitForLoadState(LoadState.NETWORKIDLE);		
	}
	
	public void validateNotificationSetPriorityRadio4() {
		page.waitForTimeout(2000);
		page.locator(notificationSetPriorityRadio4).click();
		page.waitForLoadState(LoadState.NETWORKIDLE);		
	}
	
	public void validateNotificationSetPriorityOption1(String expectedTitle) {
		page.waitForTimeout(3000);
		String actualTitle = page.locator(notificationSetPriorityOption1).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);		
	}
	
	public void validateNotificationSetPriorityOption2(String expectedTitle) {
		String actualTitle = page.locator(notificationSetPriorityOption2).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);		
	}
	
	public void validateNotificationSetPriorityOption3(String expectedTitle) {
		String actualTitle = page.locator(notificationSetPriorityOption3).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);		
	}
	
	public void validateNotificationSetPriorityOption4(String expectedTitle) {
		String actualTitle = page.locator(notificationSetPriorityOption4).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);		
	}
	
	public void validateNotificationClearOptionTitle(String expectedTitle) {
		page.waitForTimeout(2000);
		String actualTitle = page.locator(clearOption3).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);		
	}
	
	public void validateNotificationSaveOptionTitle(String expectedTitle) {
		String actualTitle = page.locator(nextOption3).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);		
	}

	public void addTagGroupAlert(String channelName) {	
		util.selectTheOptionFromDropDownBySearch(page, notificationSelectChannelDropDown, nameSearchChannel, channelName, searchedChannel);
		page.waitForLoadState(LoadState.NETWORKIDLE);
		page.locator(closeSearch).click();
		
	}

	public void clickCloseTagGroupPopup() {
		page.locator(closeAddTagGroup).click();		
		page.waitForLoadState(LoadState.NETWORKIDLE);
	}
	
	public void clickSaveTagGroupPopup() {
		page.locator(saveAddTagGroup).click();		
		page.waitForLoadState(LoadState.NETWORKIDLE);
	}
	
	public void validateHeader1Title(String expectedTitle) {
		String actualTitle = page.locator(header1).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);		
	}
	
	public void validateHeader2Title(String expectedTitle) {
		String actualTitle = page.locator(header2).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);		
	}
	
	public void validateHeader3Title(String expectedTitle) {
		String actualTitle = page.locator(header3).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);		
	}
	
	public void validateHeader4Title(String expectedTitle) {
		String actualTitle = page.locator(header4).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);		
	}
	
	public void validateHeader5Title(String expectedTitle) {
		String actualTitle = page.locator(header5).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);		
	}
	
	public void validateHeader6Title(String expectedTitle) {
		String actualTitle = page.locator(header6).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);		
	}
	
	public void validateEditOption1() {
		//Click Edit Option
		page.locator(editOption1).click();
		page.waitForLoadState(LoadState.NETWORKIDLE);
		
		page.locator(nextOption1).click();
		page.waitForLoadState(LoadState.NETWORKIDLE);
		
		page.locator(nextOption2).click();
		page.waitForLoadState(LoadState.NETWORKIDLE);
		
		page.locator(nextOption3).click();
		page.waitForLoadState(LoadState.NETWORKIDLE);
	}
	
	public void validateDeleteOption1() {
		page.locator(deleteOption1).click();
		page.waitForLoadState(LoadState.NETWORKIDLE);	
		Assert.assertTrue(page.locator(deletePopupTitle).isVisible(), "Delete Popup is opened.");
	}
	
	public void validateDeletePopupTitle(String expectedTitle) {
		String actualTitle = page.locator(deletePopupTitle).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);		
	}
	
	public void validateDeletePopupDescription(String expectedTitle) {
		String actualTitle = page.locator(deletePopupDescription).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);		
	}
	
	public void clickDeleteCancelButton() {
		page.locator(deletePopupClose).click();
		page.waitForLoadState(LoadState.NETWORKIDLE);
	}
	public void validateDeletePopupCancelOption(String expectedTitle) {
		String actualTitle = page.locator(deletePopupCancelOption).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);		
	}
	
	public void validateDeletePopupDeleteOption(String expectedTitle) {
		String actualTitle = page.locator(deletePopupDeleteOption).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);		
	}
	
	public void clickDeletePopupDeleteOption() {
		page.locator(deleteOptionActionItem).click();
		page.waitForLoadState(LoadState.NETWORKIDLE);
		
		page.locator(deletePopupDeleteOption).click();
		page.waitForLoadState(LoadState.NETWORKIDLE);
		page.waitForTimeout(2000);
	}
}
