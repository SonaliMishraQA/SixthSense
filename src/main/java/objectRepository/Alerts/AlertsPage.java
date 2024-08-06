package objectRepository.Alerts;

import java.util.Random;

import org.testng.Assert;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;

import genericUtilities.GenericMethods;
import genericUtilities.JavaUtility;
import objectRepository.CommonPage;

public class AlertsPage {
	
	Page page;
	
	GenericMethods util=new GenericMethods();
	
	private String alertsPageTitle = "#title-text-alert";
	private String configuredAlerts = "#nav-tab-configuredV2";
	private String addAlertsBtn = "xpath = //button[@class='button button-primary add-channel-btn']";
	private String addAlertsFirstTimeBtn = "xpath = //button[@class='button button-primary inner-inner-btn']";
	private String capabilityDropdown = "xpath = //div[@id='search-select-capablity']";
	private String searchCapability = "#input-search-sel-search-select-capablity";
	private String searchedCapability = "#search-select-capablity-0-single";
	private String selectedCapability = "xpath = //div[@id='search-select-capablity']/descendant::div[@class='selected-item-text']";
	private String applicationDrodpwn = "#btn-arrow-down-search-select-application";
	private String searchApplication = "#input-search-sel-search-select-application";
	private String searchedApplicationList = "xpath = //div[@id='search-select-application']/parent::div/descendant::div[@class='option-wrapper']/descendant::span[@class='selected-item-text']";
	private String selectedApplication = "xpath = //div[@id='search-select-application']/descendant::div[@class='selected-item-text']";
	private String configureAlertsPageText = " xpath = //span[text()='Looks like you haven’t added an alert yet!']";
	private String configuredAlertsText = "xpath = //span[text()='Showing configured alerts ']";
	
	
	//*******************add alert pop up *********************************
	
	private String alertNamelabel = "xpath = //label[@class='cus-mod-label' and text()='Alert name*']";
	private String alertNameTextField = "#input-alert-name";
	private String metricDropdown = "xpath = //label[text()='Metric*']/ancestor::div[@class='d-flex flex-column mt-4 max-width']/descendant::button[@id='btn-arrow-down-search-select-metric-type']";
	private String searchMetric = "xpath = //label[text()='Metric*']/ancestor::div[@class='d-flex flex-column mt-4 max-width']/descendant::input[@id='input-search-sel-search-select-metric-type']";
	private String searchedMetric = "xpath = //label[text()='Metric*']/ancestor::div[@class='d-flex flex-column mt-4 max-width']/descendant::span[contains(@id,'search-select-metric-type')]";
	private String selectedMetric = "xpath = //label[text()='Metric*']/ancestor::div[@class='d-flex flex-column mt-4 max-width']/descendant::div[@class='selected-item-text']";
	
	private String errorCodeDropdown = "xpath = //label[text()='Error code*']/ancestor::div[@class='d-flex flex-column mt-4 max-width']/descendant::button[@id='btn-arrow-down-search-select-metric-type']";
	private String searchErrorCode = "xpath = //label[text()='Error code*']/ancestor::div[@class='d-flex flex-column mt-4 max-width']/descendant::input[@id='input-search-sel-search-select-metric-type']";
	private String searchedErrorCode = "xpath = //label[text()='Error code*']/ancestor::div[@class='d-flex flex-column mt-4 max-width']/descendant::span[@id='search-select-metric-type-0-single']";
	private String selectedErrorCode = "xpath = //label[text()='Error code*']/ancestor::div[@class='d-flex flex-column mt-4 max-width']/descendant::div[@class='selected-item-text']";
	
	private String endpointDropdown = "xpath = //label[text()='Endpoint*']/ancestor::div[@class='d-flex flex-column mt-4 max-width']/descendant::button[@id='btn-arrow-down-search-select-endpoints']";
	private String searchedEndpoint= "xpath = //label[text()='Endpoint*']/ancestor::div[@class='d-flex flex-column mt-4 max-width']/descendant::div[@class='option-wrapper']/child::div[position()=1]";
	private String selectedEndpoint = "xpath = //label[text()='Endpoint*']/ancestor::div[@class='d-flex flex-column mt-4 max-width']/descendant::div[@class='selected-item-text']";
	
	private String instanceDropdown = "xpath = //label[text()='Instance*']/ancestor::div[@class='d-flex flex-column mt-4 max-width']/descendant::button[@id='btn-arrow-down-search-select-instances']";
	private String searchedInstance= "xpath = //label[text()='Instance*']/ancestor::div[@class='d-flex flex-column mt-4 max-width']/descendant::div[@class='option-wrapper']/child::div[position()=1]";
	private String selectedInstance = "xpath = //label[text()='Instance*']/ancestor::div[@class='d-flex flex-column mt-4 max-width']/descendant::div[@class='selected-item-text']";
	
	private String aggregationDropdown= "xpath = //label[text()='Aggregation type*']/ancestor::div[@class='d-flex flex-column mt-4 max-width']/descendant::button[@id='btn-arrow-down-search-select-metric-type']";
	private String selectedAggregation = "xpath = //label[text()='Aggregation type*']/ancestor::div[@class='d-flex flex-column mt-4 max-width']/descendant::div[@class='selected-item-text']";
	
	private String operatorDropdown = "xpath = //label[text()='Operator*']/ancestor::div[@class='d-flex flex-column mt-4 max-width']/descendant::button[@id='btn-arrow-down-search-select-operator']";
	private String selectedOperator = "xpath = //label[text()='Operator*']/ancestor::div[@class='d-flex flex-column mt-4 max-width']/descendant::div[@class='selected-item-text']";
	
	private String thresholdValueDropDown = "xpath = //label[text()='Threshold value*']/ancestor::div[@class='d-flex flex-column mt-4 max-width']/descendant::button[@id='btn-arrow-down-search-select-metric-type']";
	private String thresholdDropdownList = "xpath = //label[text()='Threshold value*']/ancestor::div[@class='d-flex flex-column mt-4 max-width']/descendant::span[@class='selected-item-text']";
	private String thresholdValueTextField = "#input-thresholdVal";
	
	private String timePeriodDropdown = "xpath = //label[text()='Time period*']/ancestor::div[@class='d-flex flex-column mt-4 max-width']/descendant::button[@id='btn-arrow-down-search-select-metric-type']";
	private String timePeriodDropdownList = "xpath = //label[text()='Time period*']/ancestor::div[@class='d-flex flex-column mt-4 max-width']/descendant::span[@class='selected-item-text']";
	private String timePeriodTextField = "#input-timePeriod";
	
	private String recoveryPerioDropDown = "xpath =//label[text()='Recovery period']/ancestor::div[@class='d-flex flex-column mt-4 max-width']/descendant::button[@id='btn-arrow-down-search-select-metric-type']";
	private String recoveryPeriodDropdownList = "xpath = //label[text()='Recovery period']/ancestor::div[@class='d-flex flex-column mt-4 max-width']/descendant::span[@class='selected-item-text']";
	private String recoveryPeriodTextField = "#input-recoveryPeriod";
	
	private String silencePeriodDropDown = "xpath = //label[text()='Silence period*']/ancestor::div[@class='d-flex flex-column mt-4 max-width']/descendant::button[@id='btn-arrow-down-search-select-metric-type']";
	private String silencePeriodDropdownList = "xpath = //label[text()='Silence period*']/ancestor::div[@class='d-flex flex-column mt-4 max-width']/descendant::span[@class='selected-item-text']";
	private String silencePeriodTextField = "#input-silencePeriod";
	
	private String notificationChannelDropdown = "#btn-arrow-down-search-select-notificationChannel";
	private String searchNotificationChannelTextField = "#input-search-sel-search-select-notificationChannel";
	private String selectNotificationChannel = "xpath = //div[@class='option' and contains(@id,'search-select-notificationChannel')]";
	
	private String addAlert = "#btn-alert-modal-add";
	private String addAlertWindowCloseBtn = "xpath = //span[@class='anticon anticon-close ant-modal-close-icon']";
	private String conformationPopup = "xpath = //div[@class='ant-notification-notice-description']";
	private String conforPopupClosebtn = "xpath = //span[@class='anticon anticon-close ant-notification-close-icon']";
	
	private String expandBtns = "xpath = //button[@class='action-btn']";
	private String actionIcons = "xpath = //button[@class='actions']";
	private String editIcon = "xpath =//*[name()='svg' and @id='edit_filled']";
	private String editMetric = "xpath=//label[text()='Metric*']/ancestor::div[@class='d-flex flex-column mt-4 max-width']/descendant::div[@class='selected-item-text disabled']";
	private String editService = "xpath = //label[text()='Service*']/ancestor::div[@class='d-flex flex-column mt-4 max-width']/descendant::div[@class='selected-item-text disabled']";
	private String deleteIcon = "xpath = //*[name()='g' and @id='delete_filled']";
	private String deleteAlertPopup = "xpath = //div[@class='rex-modal-header-box']/child::div";
	private String markInactiveText = "xpath = //div[@class='inner-text_inactive']";
	private String deleteBtn = "xpath = //button[@id='submit']";
	private String addAlertPopupCloseBtn = "xpath = //span[@class='anticon anticon-close ant-modal-close-icon']";
	private String addAlertPopupClearBtn = "#btn-alert-modal-clr";
	private String addedAlert = "xpath = //div[@class='data-container']/descendant::div[@class='table-row' ][position()=1]/descendant::span[contains(@style,'font-weight: ')]";
	private String addedAlertList = "xpath = //div[@class='data-container']/descendant::div[@class='table-row' ]/descendant::span[contains(@style,'font-weight: ')]";
	private String alertNameText = "xpath = //input[@id='input-alert-name']/ancestor::div[@class='sm']";
	
	//**************************Add alert pop up text ******************
	private String addAlertWindowColumnList = "xpath = //label[@class='cus-mod-label']";
	private String expandedArea = "xpath = //div[@class='table-td expanded']";
	private String expandTitles = "xpath = //div[@class='d-flex title']";
	private String errorMessageAlertName = "xpath = //p[@class='validation']/child::span[position()=2]";
	private String infoText = "xpath = //div[@class='rk-tooltip-inner']";
	private String metricInfoIcon = "xpath = //label[text()='Metric*']/ancestor::div[@class='d-flex flex-column mt-4 max-width']/descendant::*[name()='path' and @data-name='info filled']/parent::*";
	private String ThresholdInfoIcon = "xpath = //label[text()='Threshold value*']/ancestor::div[@class='d-flex flex-column mt-4 max-width']/descendant::*[name()='path' and @data-name='info filled']/parent::*";
	private String timePeriodInfoIcon = "xpath = //label[text()='Time period*']/ancestor::div[@class='d-flex flex-column mt-4 max-width']/descendant::*[name()='path' and @data-name='info filled']/parent::*";
	private String silencePeriodInfoIcon = "xpath = //label[text()='Silence period*']/ancestor::div[@class='d-flex flex-column mt-4 max-width']/descendant::*[name()='path' and @data-name='info filled']/parent::*";
	private String recoveryPeriodInfoIcon = "xpath = //label[text()='Recovery period']/ancestor::div[@class='d-flex flex-column mt-4 max-width']/descendant::*[name()='path' and @data-name='info filled']/parent::*";
	private String instanceInfoIcon = "xpath = //label[text()='Instance*']/ancestor::div[@class='d-flex flex-column mt-4 max-width']/descendant::*[name()='path' and @data-name='info filled']/parent::*";
	private String endpointInfoIcon = "xpath = //label[text()='Endpoint*']/ancestor::div[@class='d-flex flex-column mt-4 max-width']/descendant::*[name()='path' and @data-name='info filled']/parent::*";
	private String errorCodeInfoIcon = "xpath = //label[text()='Error code*']/ancestor::div[@class='d-flex flex-column mt-4 max-width']/descendant::*[name()='path' and @data-name='info filled']/parent::*";
	private String alertTagTexts = "xpath = //div[@class='d-flex flex-row mb-2']/descendant::input";
	
	private String StatusToggleBtns= "xpath = //span[contains(@class,'active-class')]";
	private String toggleSubmitBtn = "xpath = //button[@id='submit']";
	private String toggleCancelBtn = "xpath = //button[@id='cancel']";
	private String popUpTitle = "xpath = //div[@class='rex-modal-header-box']/child::div";
	private String popupInfo = "xpath = //p[@class='info-label']/descendant::span[position()=2]";
	private String popUpText = "xpath = //div[@class='alert-v2-modal-body']/descendant::div[position()=2]";
	
	private String creartedOn = "xpath = //div[@id='redirect-0-5']/child::span";
	private String expandedCreatedOnDate = "xpath = //div[.='Created on']/parent::div/descendant::p[@class='d-flex inner-text mr-1']";
	private String expandedCreatedOnTime = "xpath = //div[.='Created on']/parent::div/descendant::span[@class='d-flex']";
	private String notificationChannelCount = "xpath = //div[@class='info w-15']/descendant::span";
	
	private String searchBar = " xpath = //input[@placeholder='Search alerts']" ;
	private String searchBtn = " xpath = //button[@id='btn-search']" ;
	private String noDataIcon = "xpath = //div[@class='no-data-icon']/descendant::div";
	private String softRefresh = "#btn-refresh";
	private String clearSearch = "#btn-clear-search";
	
	
	public AlertsPage(Page page)
	{
		this.page= page;
	}
	
	public void deleteAlerts()
	
	{	boolean flag=false;
		try {
				page.waitForTimeout(1000);
				page.locator(addedAlertList).count();
				flag=true;
		} catch (Exception e) {
			
		}
		if(flag)
		{	int num =page.locator(expandBtns).count();
			for(int i=0;i<num;i++)

			{	page.locator(expandBtns).first().click();
				page.locator(deleteIcon).click();
				page.waitForSelector(deleteAlertPopup);
				Assert.assertTrue(page.locator(deleteAlertPopup).isVisible());
				page.locator(deleteBtn).click();
				page.locator(conforPopupClosebtn).last().click();
				page.waitForLoadState(LoadState.DOMCONTENTLOADED);
			}
		}
			
	}
	
	public void validatePagination(int num) {
		CommonPage commPgae=new CommonPage(page);
		commPgae.selectPaginationAndValidate(page, num, addedAlertList);
	}
	
	public void validateSearchBarWithValidData()
	{
		util.validateSearchFunctionalityWithValidData(page, addedAlert, searchBar, searchBtn, addedAlertList);
		page.locator(clearSearch).click();
	}
	
	public void validateSearchBarWithInValidData()
	{
		util.validateSearchFunctionalityWithInvalidData(page, searchBar, searchBtn, noDataIcon);
		page.locator(clearSearch).click();
	}

	
	public void validateTheMarkInactiveLinkIsvisibleOrNot()
	{
		page.waitForSelector(expandBtns);
		page.locator(expandBtns).first().click();
		page.waitForSelector(deleteIcon);
		
		page.locator(deleteIcon).click();
		page.waitForSelector(deleteAlertPopup);
		boolean flag;
		try {
			page.locator(markInactiveText).click();
			flag =false;
		} catch (Exception e) {
			flag =true;
			page.locator(addAlertPopupCloseBtn).last().click();
			
		}
		
		Assert.assertTrue(flag);
		page.locator(expandBtns).first().click();
	}
	
	public void validateTheMarkInactiveLink(String expectedtext,String Text )
	{
		
		page.waitForSelector(expandBtns);
		page.locator(expandBtns).first().click();
		page.waitForSelector(expandedArea);
		
		String[] inactivePopupText = Text.split(",");
		page.locator(deleteIcon).click();
		page.waitForSelector(deleteAlertPopup);
		
		Assert.assertEquals(page.locator(markInactiveText).textContent().trim(),expectedtext);
		
		page.locator(markInactiveText).click();
		
		page.waitForSelector(toggleSubmitBtn);
		Assert.assertEquals(page.locator(popUpTitle).textContent().trim(),inactivePopupText[0]);
		Assert.assertEquals(page.locator(popUpText).textContent().trim(),inactivePopupText[1]);
		Assert.assertEquals(page.locator(popupInfo).textContent().trim(),inactivePopupText[2]);
		
		page.locator(toggleSubmitBtn).click();
		
		//close the confirmation pup up
		page.waitForSelector(conforPopupClosebtn);
		page.locator(conforPopupClosebtn).click();
		
		page.locator(expandBtns).first().click();
		page.waitForSelector(StatusToggleBtns);
		
		//validate the inactive status
		String actualText = page.locator(StatusToggleBtns).last().getAttribute("class").trim();
		Assert.assertTrue(actualText.contains("active"));
	}
	
	public void validateDeleteAlertpopUpCancelBtn(String alertName)
	{
		page.waitForSelector(expandBtns);
		page.locator(expandBtns).first().click();
		page.waitForSelector(expandedArea);
		
		page.locator(deleteIcon).click();
		page.waitForSelector(deleteAlertPopup);
		
		page.locator(toggleCancelBtn).click();
		Assert.assertEquals(page.locator(addedAlert).textContent().trim(),alertName);
		
		page.locator(expandBtns).first().click();
		
		
	}
	
	public void validateDeleteAlertpopUp(String text)
	{
		page.waitForSelector(expandBtns);
		page.locator(expandBtns).first().click();
		page.waitForSelector(expandedArea);
		
		String[] expectedText = text.split(",");
		
		page.locator(deleteIcon).click();
		page.waitForSelector(deleteAlertPopup);
		
		Assert.assertEquals(page.locator(popUpTitle).textContent().trim(),expectedText[0]);
		Assert.assertEquals(page.locator(popUpText).textContent().trim(),expectedText[1]);
		Assert.assertEquals(page.locator(popupInfo).textContent().trim(),expectedText[2]);
		
		page.locator(deleteBtn).click();
		
		//close the confirmation pup up
		page.waitForSelector(conforPopupClosebtn);
		page.locator(conforPopupClosebtn).click();
	}
	public void deleteAnAlert()
	{
		page.waitForSelector(expandBtns);
		
		try {
			page.locator(expandBtns).first().click();
			page.locator(deleteIcon).click();
		} catch (Exception e) {
			page.locator(expandBtns).first().click();
			page.locator(deleteIcon).click();
		}
		
		page.waitForSelector(deleteAlertPopup);
		Assert.assertTrue(page.locator(deleteAlertPopup).isVisible());
		page.locator(deleteBtn).click();
		page.locator(conforPopupClosebtn).last().click();
		page.waitForLoadState(LoadState.DOMCONTENTLOADED);
		
		
	}
	public void validateDeleteIcon(String successMessage,String alertName)
	{
		
		page.waitForSelector(expandBtns);
		page.locator(expandBtns).first().click();
		page.waitForSelector(expandedArea);
		
		page.locator(deleteIcon).click();
		page.waitForSelector(deleteAlertPopup);
		Assert.assertTrue(page.locator(deleteAlertPopup).isVisible());
		page.locator(deleteBtn).click();
		//validate the alerts confirmation popup
		Assert.assertEquals(page.locator(conformationPopup).textContent().trim(),successMessage );
		page.locator(conforPopupClosebtn).click();
		page.waitForLoadState(LoadState.DOMCONTENTLOADED);
		Assert.assertNotEquals(page.locator(addedAlert).textContent().trim(),alertName);
		
	}
	
	public void validateEditAlertPopUp()
	{
		page.waitForSelector(expandBtns);
		page.locator(expandBtns).first().click();
		page.waitForSelector(expandedArea);
		
		page.locator(editIcon).click();
		page.waitForSelector(alertNamelabel);
		
		//validate the pop up title and btn texts
		Assert.assertEquals(page.locator(popUpTitle).textContent().trim(),"Edit alert");
		Assert.assertEquals(page.locator(addAlert).textContent().trim(), "Edit");
		
		//validate the service and metric drop down disabled or not
		Assert.assertTrue(page.locator(editMetric).getAttribute("class").trim().contains("disabled"));
		Assert.assertTrue(page.locator(editService).getAttribute("class").trim().contains("disabled"));
		
		page.locator(addAlert).click();
		//close the confirmation pup up
		page.locator(conforPopupClosebtn).click();
		
		
	}
	
	public void validateEditIcon(String editedName,String successMessage)
	{
		page.waitForSelector(expandBtns);
		page.locator(expandBtns).first().click();
		page.waitForSelector(expandedArea);
		page.locator(editIcon).click();
		page.waitForSelector(alertNamelabel);
		Assert.assertTrue(page.locator(alertNamelabel).isVisible());
		page.waitForTimeout(2000);
		//enter the alert name
		page.locator(alertNameTextField).fill(editedName);
		page.waitForTimeout(2000);
		page.locator(alertNameTextField).clear();
		page.locator(alertNameTextField).fill(editedName);
		page.locator(addAlert).click();
		//validate the confirmation pup up
		Assert.assertEquals(page.locator(conformationPopup).textContent().trim(),successMessage );
		page.locator(conforPopupClosebtn).click();
		
		page.locator(softRefresh).click();
		
		//validate the alert configured or not
		page.waitForLoadState(LoadState.DOMCONTENTLOADED);
		page.waitForSelector(addedAlert);
		Assert.assertEquals(page.locator(addedAlert).textContent().trim(),editedName);
		
		page.locator(expandBtns).first().click();
	}
	
	public void validateAlertTags(String text)
	{
		String[] expectedText=text.split(",");
		int num = page.locator(alertTagTexts).count();
		for (int i=0;i<num;i++)
		{
			Assert.assertEquals(page.locator(alertTagTexts).nth(i).getAttribute("placeholder"), expectedText[i]);
		}
	}
	
	public void validateTheThresholdDropDown(String Values)
	{
		String[] expectedValues=Values.split(",");
		page.locator(thresholdValueDropDown).click();
		page.waitForSelector(thresholdDropdownList);
		int num = page.locator(thresholdDropdownList).count();
		//validate the count
		Assert.assertEquals(num, expectedValues.length);
		
		//validate the text
		for(int i=0;i<num;i++)
		{
			Assert.assertEquals(page.locator(thresholdDropdownList).nth(i).textContent().trim(), expectedValues[i]);
		}
		
	}
	
	public void validateTheTimePeriodDropDown(String Values)
	{
		String[] expectedValues=Values.split(",");
		page.locator(timePeriodDropdown).click();
		page.waitForSelector(timePeriodDropdownList);
		int num = page.locator(timePeriodDropdownList).count();
		//validate the count
		Assert.assertEquals(num, expectedValues.length);
		
		//validate the text
		for(int i=0;i<num;i++)
		{
			Assert.assertEquals(page.locator(timePeriodDropdownList).nth(i).textContent().trim(), expectedValues[i]);
		}
		
	}
	

	public void validateTheRecoveryPeriodDropDown(String Values)
	{
		String[] expectedValues=Values.split(",");
		page.locator(recoveryPerioDropDown).click();
		page.waitForSelector(recoveryPeriodDropdownList);
		int num = page.locator(recoveryPeriodDropdownList).count();
		//validate the count
		Assert.assertEquals(num, expectedValues.length);
		
		//validate the text
		for(int i=0;i<num;i++)
		{
			Assert.assertEquals(page.locator(recoveryPeriodDropdownList).nth(i).textContent().trim(), expectedValues[i]);
		}
		
	}
	

	public void validateTheSilencePeriodDropDown(String Values)
	{
		String[] expectedValues=Values.split(",");
		page.locator(silencePeriodDropDown).click();
		page.waitForSelector(silencePeriodDropdownList);
		int num = page.locator(silencePeriodDropdownList).count();
		//validate the count
		Assert.assertEquals(num, expectedValues.length);
		
		//validate the text
		for(int i=0;i<num;i++)
		{
			Assert.assertEquals(page.locator(silencePeriodDropdownList).nth(i).textContent().trim(), expectedValues[i]);
		}
		
	}
	
	
	public void validateTheSubmitBtn()
	{
		Assert.assertTrue(page.locator(addAlert).isDisabled());
		page.locator(alertNameTextField).click();
		page.locator(alertNameTextField).clear();
		
		Assert.assertTrue(page.locator(addAlert).isDisabled());
		
		
	}
	
	public void validateTimePeriodErrorMessage(String value,String errorMessage)
	{
		//enter the time period
		Locator timeperiod=page.locator(timePeriodTextField);
		timeperiod.clear();
		timeperiod.fill(value);
		Assert.assertEquals(page.locator(errorMessageAlertName).textContent().trim(), errorMessage);		
				
	}

	public void validateRecoveryPeriodErrorMessage(String value,String errorMessage)
	{
		// enter the recovery period
		Locator recoveryperiod = page.locator(recoveryPeriodTextField);
		recoveryperiod.clear();
		recoveryperiod.fill(value);
		Assert.assertEquals(page.locator(errorMessageAlertName).textContent().trim(), errorMessage);
		
	}
	
	public void validateSilencePeriodErrorMessage(String value,String errorMessage)
	{
		//enter the silence period
		Locator silenceperiod=page.locator(silencePeriodTextField);
		silenceperiod.clear();
		silenceperiod.fill(value);
		Assert.assertEquals(page.locator(errorMessageAlertName).textContent().trim(), errorMessage);
		
	}
	
	public void validateInstanceInfo(String expectedText)
	{
		String actualtext = getTheInfo(instanceInfoIcon);
		
		Assert.assertEquals(actualtext, expectedText);
	}
	
	public void validateEndpointInfo(String expectedText)
	{
		String actualtext = getTheInfo(endpointInfoIcon);
		
		Assert.assertEquals(actualtext, expectedText);
	}
	
	public void validateErrorCodeInfoIcon(String expectedText)
	{
		String actualtext = getTheInfo(errorCodeInfoIcon);
		
		Assert.assertEquals(actualtext, expectedText);
	}
	
	
	
	
	public void validateMetricInfo(String expectedText)
	{
		String actualtext = getTheInfo(metricInfoIcon);
		
		Assert.assertEquals(actualtext, expectedText);
	}
	
	
	public void validateThresholdInfo(String expectedText)
	{
		String actualtext = getTheInfo(ThresholdInfoIcon);
		
		Assert.assertEquals(actualtext, expectedText);
	}
	
	public void validateTimePeriodInfo(String expectedText)
	{
		String actualtext = getTheInfo(timePeriodInfoIcon);
		
		Assert.assertEquals(actualtext, expectedText);
	}
	
	public void validateSilencePeriodInfo(String expectedText)
	{
		String actualtext = getTheInfo(silencePeriodInfoIcon);
		
		Assert.assertEquals(actualtext, expectedText);
	}
	
	public void validateRecoveryPeriodInfo(String expectedText)
	{
		String actualtext = getTheInfo(recoveryPeriodInfoIcon);
		
		Assert.assertEquals(actualtext, expectedText);
	}
	
	
	
	public String getTheInfo(String infoicon)
	{
		page.locator(infoicon).hover();
		page.waitForSelector(infoText);
		return page.locator(infoText).textContent().trim();
	}
	
	public void validateThecolumnText(String names)
	{
		String[] expectedNames = names.split(",");
		int num = page.locator(addAlertWindowColumnList).count();
		for(int i=0;i<num;i++)
		{
			String actualName = page.locator(addAlertWindowColumnList).nth(i).textContent().trim();
			Assert.assertEquals(actualName, expectedNames[i]);
		}
		
	}
	
	public void validateTheErrorMessagewhenThereIsWrongData(String wrongData,String expectedMessage)
	{
		page.locator(alertNameTextField).clear();
		page.locator(alertNameTextField).fill(wrongData);
		page.keyboard().down("Tab");
		page.keyboard().up("Tab");
		Assert.assertEquals(page.locator(errorMessageAlertName).textContent().trim(), expectedMessage);
		
		
	}
	
	public void validateTheClearBtnOfAddAlertPopup(String name,String metric)
	{
		//create alert
		page.locator(alertNameTextField).clear();
		page.locator(alertNameTextField).fill(name);
		
		//selectTheMetric
		selectTheMetricFromDropDown(metric);
		
		//click on clear btn
		page.locator(addAlertPopupClearBtn).click();
		
		String expectedText=page.getAttribute(alertNameText, "value");
		Assert.assertEquals(expectedText, "");
		
		Assert.assertTrue(page.locator(selectedMetric).textContent().trim().equalsIgnoreCase("Error"));
		
		
	}
	
	public void closeTheAddAlertPopup()
	{
		page.waitForSelector(addAlertPopupCloseBtn);
		page.locator(addAlertPopupCloseBtn).click();
	}
	
	public void validateTheCloseBtnOfAddAlertPopup()
	{
		page.waitForSelector(addAlertPopupCloseBtn);
		
		Assert.assertTrue(page.locator(addAlertPopupCloseBtn).isVisible());
		
		page.locator(addAlertPopupCloseBtn).click();
		boolean flag;
		
		try {
			page.locator(addAlertPopupCloseBtn).hover();
			flag =false;
		} catch (Exception e) {
			flag=true;
			
		}
		Assert.assertTrue(flag);
		
	}
	
	public void validateActionIcons()
	{
		page.waitForSelector(expandBtns);
		page.locator(expandBtns).first().click();
		page.waitForSelector(expandedArea);
		
		//validate the count of action icons
		Assert.assertEquals(page.locator(actionIcons).count(), 2);
		
		page.locator(expandBtns).first().click();
	}
	
	public void validateExpandBtn()
	{
		page.waitForSelector(expandBtns);
		page.locator(expandBtns).first().click();
		page.waitForSelector(expandedArea);
		Assert.assertTrue(page.locator(expandedArea).isVisible());
		page.locator(expandBtns).first().click();
		
		
	}
	
	public void validateToggleBtns(String text)
	{ 
		page.waitForSelector(expandBtns);
		page.locator(expandBtns).first().click();
		page.waitForSelector(expandedArea);
		String[] expectedText = text.split(",");
		int num=page.locator(StatusToggleBtns).count();
		for(int i=0;i<num;i++)
		{
			Assert.assertEquals(page.locator(StatusToggleBtns).nth(i).textContent().trim(), expectedText[i]);
		}
				
		page.locator(expandBtns).first().click();
	}
	
	public void validateDefaultToggleBtn()
	{
		page.waitForSelector(expandBtns);
		page.locator(expandBtns).first().click();
		page.waitForSelector(expandedArea);
		String actualText = page.locator(StatusToggleBtns).first().getAttribute("class").trim();
		
		Assert.assertTrue(actualText.contains("active"));
		page.locator(expandBtns).first().click();
	}
	
	public void validateInactiveStatusCancelBtn()
	{
		page.waitForSelector(expandBtns);
		page.locator(expandBtns).first().click();
		page.waitForSelector(expandedArea);
		
		//click on the inactive btn
		page.locator(StatusToggleBtns).last().click();
		
		page.waitForSelector(toggleSubmitBtn);
		page.locator(toggleCancelBtn).click();
		
		//validate the Btn is activated or not
		String actualText = page.locator(StatusToggleBtns).last().getAttribute("class").trim();
		Assert.assertTrue(actualText.contains("inactive"));
		
		page.locator(expandBtns).first().click();
		
	}
	
	public void validateActiveStatusCancelBtn()
	{
		page.waitForSelector(expandBtns);
		page.locator(expandBtns).first().click();
		page.waitForSelector(expandedArea);
		
		if(page.locator(StatusToggleBtns).first().getAttribute("class").trim().contains("active"))
		{
		//click on the inactive btn
		page.locator(StatusToggleBtns).last().click();
		page.waitForSelector(toggleSubmitBtn);
		page.locator(toggleSubmitBtn).click();
		
		//validate the confirmation pup up
		page.waitForSelector(conforPopupClosebtn);
		page.locator(conforPopupClosebtn).click();
		
		//click on the expand btn
		page.locator(expandBtns).first().click();
		page.waitForSelector(StatusToggleBtns);
		}
		
		//click on the active btn
		page.locator(StatusToggleBtns).first().click();
		page.waitForSelector(toggleCancelBtn);
		page.locator(toggleCancelBtn).click();
		
		//validate the Btn is activated or not
		String actualText = page.locator(StatusToggleBtns).first().getAttribute("class").trim();
		Assert.assertTrue(actualText.contains("inactive"));
		
		page.locator(expandBtns).first().click();
		
	}
	
	public void validateActiveStatusPopUp(String text)
	{
		page.waitForSelector(expandBtns);
		page.locator(expandBtns).first().click();
		page.waitForSelector(expandedArea);
		
		String[] expectedText = text.split(",");
		if(page.locator(StatusToggleBtns).first().getAttribute("class").trim().contains("active"))
		{
		//click on the inactive btn
		page.locator(StatusToggleBtns).last().click();
		page.waitForSelector(toggleSubmitBtn);
		page.locator(toggleSubmitBtn).click();
		
		//validate the confirmation pup up
		page.waitForSelector(conforPopupClosebtn);
		page.locator(conforPopupClosebtn).click();
		
		//click on the expand btn
		page.locator(expandBtns).first().click();
		page.waitForSelector(StatusToggleBtns);
		}
		
		//click on the active btn
		page.locator(StatusToggleBtns).first().click();
		page.waitForSelector(toggleSubmitBtn);
		System.out.println(page.locator(popUpTitle).textContent().trim()+"--------"+expectedText[0]);
		System.out.println(page.locator(popUpText).textContent().trim()+"--------"+expectedText[1]);
		Assert.assertEquals(page.locator(popUpTitle).textContent().trim(),expectedText[0]);
		Assert.assertEquals(page.locator(popUpText).textContent().trim(),expectedText[1]);
		Assert.assertEquals(page.locator(popupInfo).textContent().trim(),expectedText[2]);
		
		page.locator(toggleSubmitBtn).click();
		
		//close the confirmation pup up
		page.waitForSelector(conforPopupClosebtn);
		page.locator(conforPopupClosebtn).click();
		
		page.locator(expandBtns).first().click();
	}
	
	public void validateInactiveStatusPopUp(String text)
	{
		page.waitForSelector(expandBtns);
		page.locator(expandBtns).first().click();
		page.waitForSelector(expandedArea);
		
		String[] expectedText = text.split(",");
		
		//click on the inactive btn
		page.locator(StatusToggleBtns).last().click();
		
		page.waitForSelector(toggleSubmitBtn);
		Assert.assertEquals(page.locator(popUpTitle).textContent().trim(),expectedText[0]);
		Assert.assertEquals(page.locator(popUpText).textContent().trim(),expectedText[1]);
		Assert.assertEquals(page.locator(popupInfo).textContent().trim(),expectedText[2]);
		
		page.locator(toggleSubmitBtn).click();
		
		//close the confirmation pup up
		page.waitForSelector(conforPopupClosebtn);
		page.locator(conforPopupClosebtn).click();
		
		page.locator(expandBtns).first().click();
	
	}
	
	public void validateActiveToggleBtn(String successMessage)
	{
		page.waitForSelector(expandBtns);
		page.locator(expandBtns).first().click();
		page.waitForSelector(expandedArea);
		
		if(page.locator(StatusToggleBtns).first().getAttribute("class").trim().contains("active"))
		{
		//click on the inactive btn
		page.locator(StatusToggleBtns).last().click();
		page.waitForSelector(toggleSubmitBtn);
		page.locator(toggleSubmitBtn).click();
		
		//validate the confirmation pup up
		page.waitForSelector(conformationPopup);
		page.locator(conforPopupClosebtn).click();
		
		//click on the expand btn
		page.locator(expandBtns).first().click();
		page.waitForSelector(StatusToggleBtns);
		}
		
		//click on the active btn
		page.locator(StatusToggleBtns).first().click();
		
		page.waitForSelector(toggleSubmitBtn);
		page.locator(toggleSubmitBtn).click();
		
		
		//validate the confirmation pup up
		Assert.assertEquals(page.locator(conformationPopup).textContent().trim(),successMessage );
		page.locator(conforPopupClosebtn).click();
		
		//click on the expand btn
		page.locator(expandBtns).first().click();
		page.waitForSelector(StatusToggleBtns);
		
		//validate the Btn is activated or not
		String actualText = page.locator(StatusToggleBtns).last().getAttribute("class").trim();
		Assert.assertTrue(actualText.contains("active"));
		
		page.locator(expandBtns).first().click();
	}
	

	public void validateInactiveToggleBtn(String successMessage)
	{
		page.waitForSelector(expandBtns);
		page.locator(expandBtns).first().click();
		page.waitForSelector(expandedArea);
		
		//click on the inactive btn
		page.locator(StatusToggleBtns).last().click();
		
		page.waitForSelector(toggleSubmitBtn);
		page.locator(toggleSubmitBtn).click();
		
		//validate the confirmation pup up
		Assert.assertEquals(page.locator(conformationPopup).textContent().trim(), successMessage );
		page.locator(conforPopupClosebtn).click();
		
		//click on the expand btn
		page.locator(expandBtns).first().click();
		page.waitForSelector(StatusToggleBtns);
		
		//validate the Btn is activated or not
		String actualText = page.locator(StatusToggleBtns).last().getAttribute("class").trim();
		Assert.assertTrue(actualText.contains("active"));
		
		page.locator(expandBtns).first().click();
	}
	
	
	public void validateExpandTitles(String titlesList)
	{
		page.waitForSelector(expandBtns);
		page.locator(expandBtns).first().click();
		page.waitForSelector(expandedArea);
		
		String[] expectedTitles=titlesList.split(",");
		int num=page.locator(expandTitles).count();
		for(int i=0;i<num;i++)
		{
			Assert.assertEquals(page.locator(expandTitles).nth(i).textContent().trim(), expectedTitles[i]);
		}
		
		page.locator(expandBtns).first().click();
	}
	
	public void addAnAlert(String name,String metric,String thresholdValue,String thresholdDropdownValue)
	{
		//click on add alert
		try
		{
			page.locator(addAlertsFirstTimeBtn).click();
		}
		catch (Exception e) 
		{
			page.locator(addAlertsBtn).click();		
		}
		
		//create alert
		page.locator(alertNameTextField).clear();
		page.waitForTimeout(300);
		page.locator(alertNameTextField).fill(name);
		
		//select the metric
		selectTheMetricFromDropDown(metric);
		
		//select the threshold
		page.locator(thresholdValueDropDown).click();
		page.waitForSelector(thresholdDropdownList);
		int num = page.locator(thresholdDropdownList).count();
		
		//select the threshold value
		for(int i=0;i<num;i++)
		{
			if(page.locator(thresholdDropdownList).nth(i).textContent().trim().equalsIgnoreCase(thresholdValue))
			{
				page.locator(thresholdDropdownList).nth(i).click();
			}
		}
		
		//enter threshold value
		Locator threshold=page.locator(thresholdValueTextField);
		threshold.clear();
		threshold.fill(thresholdValue);
		
		page.locator(addAlert).click();
		
		//validate the confirmation pup up
		page.waitForSelector(conformationPopup);
		page.locator(conforPopupClosebtn).click();
				
		//validate the alert configured or not
		page.waitForLoadState(LoadState.DOMCONTENTLOADED);
		page.waitForSelector(addedAlert);
		Assert.assertEquals(page.locator(addedAlert).textContent().trim(),name);
		
	}
	public void addAnAlertABySelectingNotificationChannel(String AlertName,String notificationChannel)
	{
		String[] expectedCount =notificationChannel.split(",");
		//click on add alert
		try
		{
			page.locator(addAlertsFirstTimeBtn).click();
		}
		catch (Exception e) 
		{
			page.locator(addAlertsBtn).click();		
		}
						
		//create alert
		page.locator(alertNameTextField).clear();
		page.waitForTimeout(300);
		page.locator(alertNameTextField).fill(AlertName);
		
		//select notification channel
		util.selectTheOptionFromDropDownBySearch(page, notificationChannelDropdown, searchNotificationChannelTextField, notificationChannel,selectNotificationChannel);

		page.locator(notificationChannelDropdown).click();
		
		page.locator(addAlert).click();
		
		//validate the confirmation pup up
		page.waitForSelector(conformationPopup);
		page.locator(conforPopupClosebtn).click();
						
		//validate the alert configured or not
		page.waitForLoadState(LoadState.DOMCONTENTLOADED);
		page.waitForSelector(addedAlert);
		Assert.assertEquals(page.locator(addedAlert).textContent().trim(),AlertName);
		
		page.locator(expandBtns).first().click();
		Assert.assertEquals(page.locator(notificationChannelCount).textContent().trim(),String.valueOf(expectedCount.length));
	}
	
	public void addAnAlertAndValidateTheCreatedDate(String AlertName)
	{
		//click on add alert
		try
		{
			page.locator(addAlertsFirstTimeBtn).click();
		}
		catch (Exception e) 
		{
			page.locator(addAlertsBtn).click();		
		}
				
		//create alert
		page.locator(alertNameTextField).clear();
		page.waitForTimeout(300);
		page.locator(alertNameTextField).fill(AlertName);
		page.locator(addAlert).click();
		//validate the confirmation pup up
		page.waitForSelector(conformationPopup);
		page.locator(conforPopupClosebtn).click();
								
		//validate the alert configured or not
		page.waitForLoadState(LoadState.DOMCONTENTLOADED);
		page.waitForSelector(addedAlert);
		Assert.assertEquals(page.locator(addedAlert).textContent().trim(),AlertName);
		
		//validate createdOn date
		JavaUtility jutil=new JavaUtility();
		String date1 = jutil.getTheSystemDateAndTime("LLL dd, yyyy");
		String date2 = jutil.getTheSystemDateAndTime("hh:mm ");
		String date3 =jutil.getTheSystemDateAndTime("a").toUpperCase();
		
		String expectedCreatedOn = date1+" at "+date2+date3;
		Assert.assertTrue(page.locator(creartedOn).textContent().trim().contains(expectedCreatedOn));
		
		page.locator(expandBtns).first().click();
		page.waitForSelector(StatusToggleBtns);
		Assert.assertEquals(page.locator(expandedCreatedOnDate).textContent().trim(), date1);
		page.waitForTimeout(2000);
		System.out.println(page.locator(expandedCreatedOnTime).textContent().trim()+"--------"+"at "+date2+date3);
		Assert.assertTrue(page.locator(expandedCreatedOnTime).textContent().trim().contains("at  "+date2+date3));
		
		page.locator(expandBtns).first().click();
	}
	
	public void addAnAlert(String name)
	{
		//click on add alert
		try
		{
			page.locator(addAlertsFirstTimeBtn).click();
		}
		catch (Exception e) 
		{
			page.locator(addAlertsBtn).click();
		}
		
		//create alert
		page.locator(alertNameTextField).clear();
		page.waitForTimeout(300);
		page.locator(alertNameTextField).fill(name);
		page.locator(addAlert).click();
		
		//validate the confirmation pup up
		page.waitForSelector(conformationPopup);
		page.locator(conforPopupClosebtn).click();
				
		//validate the alert configured or not
		page.waitForLoadState(LoadState.DOMCONTENTLOADED);
		page.waitForSelector(addedAlert);
		Assert.assertEquals(page.locator(addedAlert).textContent().trim(),name);
		
	}
	
	public void clickOnAddAlertBtn()
	{
		//click on the add alert button
		try
		{
			page.locator(addAlertsFirstTimeBtn).click();
		}
		catch (Exception e) 
		{
			page.locator(addAlertsBtn).click();		
		}	
		//validate the alerts page displayed or not
		page.waitForSelector(alertNamelabel);
		Assert.assertTrue(page.locator(alertNamelabel).isVisible());
				
	}
	
	public void selectTheMetricFromDropDown(String metric)
	{
		//select the metric from the drop down
		page.locator(metricDropdown).click();
		page.locator(searchMetric).clear();
		page.locator(searchMetric).fill(metric);
		page.waitForSelector(searchedMetric);
		Locator actualsearchedApplications=page.locator(searchedMetric);
		System.out.println(actualsearchedApplications.count());
		for(int i=0;i<actualsearchedApplications.count();i++)
		{ 
			if(actualsearchedApplications.nth(i).innerText().trim().equalsIgnoreCase(metric))
				{
					actualsearchedApplications.nth(i).click();
					break;
				}
		}
			Assert.assertTrue(page.locator(selectedMetric).isVisible());
	}
	
	
	public void validateTheAlertsPage()
	{
		page.waitForSelector(alertsPageTitle);
		util.ValidateTheTitle(page.locator(alertsPageTitle).textContent().trim(), "Alerts");
	}
	
	public void NavigateToConfiguredAlertsTab()
	{
		page.locator(configuredAlerts).click();
		String expectedUrl="**/alertsV2/configuredV2";
		page.waitForURL(expectedUrl);
		Assert.assertEquals(page.url().contains("/alertsV2/configuredV2"),true);
	}
	
	public void ValidateTheConfiguredAlertsPage()
	{
		
		try {
			String text = page.locator(configureAlertsPageText).innerText();
			Assert.assertEquals(text, "Looks like you haven’t added an alert yet!");
		} catch (Exception e) {
			String text = page.locator(configuredAlertsText).innerText();
			Assert.assertEquals(text, "Showing configured alerts ");
		}
	}
	
	public void validatemessageWhenNoAlerts(String ExpectedMessage)
	{
		String text = page.locator(configureAlertsPageText).innerText();
		Assert.assertEquals(text, ExpectedMessage);
	}
	
	public void selectCapabilityFromDropDown(String capability)
	{
		//select the capability from drop down
		page.locator(capabilityDropdown).click();
		page.locator(searchCapability).fill(capability);
		page.locator(searchedCapability).click();
		//validate whether the desired capability selected or not
		Assert.assertEquals(page.locator(selectedCapability).innerText(), capability);
	}
	
	public void selectApplicationfromDropdown(String application)
	{
		page.waitForSelector(selectedApplication);
		page.waitForTimeout(2000);
		util.selectTheOptionFromDropDownBySearch(page, applicationDrodpwn, searchApplication, application,searchedApplicationList);
		page.waitForSelector(selectedApplication);
		Assert.assertEquals(page.locator(selectedApplication).textContent().trim(), application);
		System.out.println("application selected successfully");
		page.waitForLoadState(LoadState.DOMCONTENTLOADED);
	}
	
	public void closeTheAlertPopUp()
	{
		try {
			page.locator(configuredAlerts).click();
			
		} catch (Exception e) {
			page.locator(addAlertPopupCloseBtn).click();
		}
	}
	
	public void addAlerts(String name,String metric,String aggregator,String operator,String thresholdValue,String timePeriod,String silencePeriod,String recoveryPeriod,String notificationChannel,String successMessage)
	{
		
		//click on the add alert button
		try
		{
			page.locator(addAlertsBtn).click();
		}
		catch (Exception e) 
		{
			page.locator(addAlertsFirstTimeBtn).click();
			
		}
		
		//validate the alerts page displayed or not
		page.waitForSelector(alertNamelabel);
		Assert.assertTrue(page.locator(alertNamelabel).isVisible());
		//enter the alert name
		page.locator(alertNameTextField).fill(name);
		try {
			page.waitForSelector(addAlert);
		} catch (Exception e) {

			page.locator(alertNameTextField).clear();
			page.locator(alertNameTextField).fill(name);
		}
		
		//select the metric from the drop down
		page.locator(metricDropdown).click();
		page.locator(searchMetric).clear();
		page.locator(searchMetric).fill(metric);
		page.waitForSelector(searchedMetric);
		Locator actualsearchedApplications=page.locator(searchedMetric);
		System.out.println(actualsearchedApplications.count());
		for(int i=0;i<actualsearchedApplications.count();i++)
		{ 
			if(actualsearchedApplications.nth(i).innerText().trim().equalsIgnoreCase(metric))
			{
				actualsearchedApplications.nth(i).click();
				break;
			}
		}
		Assert.assertTrue(page.locator(selectedMetric).isVisible());
		
		if(metric.equalsIgnoreCase("Endpoint response time")|| metric.equalsIgnoreCase("Endpoint error")|| metric.equalsIgnoreCase("Endpoint load")|| metric.equalsIgnoreCase("Endpoint error code")|| metric.equalsIgnoreCase("Endpoint availability"))
		{
			page.locator(endpointDropdown).click();
			page.locator(searchedEndpoint).first().click();
			page.locator(endpointDropdown).click();
			
		} else if(metric.equalsIgnoreCase("Instance response time")|| metric.equalsIgnoreCase("Instance error")|| metric.equalsIgnoreCase("Instance load")|| metric.equalsIgnoreCase("Instance error code") || name.startsWith("MySql") || name.startsWith("Oracle"))
		{
			page.locator(instanceDropdown).click();
			page.locator(searchedInstance).first().click();
			page.locator(instanceDropdown).click();
		}
		
		//select the aggregator
		page.locator(aggregationDropdown).click();
		page.locator( "xpath = //label[text()='Aggregation type*']/ancestor::div[@class='d-flex flex-column mt-4 max-width']/descendant::span[@class='selected-item-text' and text()='"+aggregator+"']").click();
		Assert.assertTrue(page.locator(selectedAggregation).isVisible());
		
		//select the operator
		page.locator(operatorDropdown).click();
		page.locator("xpath = //span[@class='selected-item-text' and text()='"+operator+" ']").click();
		Assert.assertTrue(page.locator(selectedOperator).isVisible());
		
		//enter threshold value
		Locator threshold=page.locator(thresholdValueTextField);
		threshold.clear();
		threshold.fill(thresholdValue);
		
		if(!metric.equalsIgnoreCase("Instance availability"))
		{
		//enter the time period
		Locator timeperiod=page.locator(timePeriodTextField);
		timeperiod.clear();
		timeperiod.fill(timePeriod);
		}
		
		// enter the recovery period
		Locator recoveryperiod = page.locator(recoveryPeriodTextField);
		recoveryperiod.clear();
		recoveryperiod.fill(recoveryPeriod);
		
		//enter the silence period
		Locator silenceperiod=page.locator(silencePeriodTextField);
		silenceperiod.clear();
		silenceperiod.fill(silencePeriod);
		
		//select the notification channel
		util.selectTheOptionFromDropDownBySearch(page, notificationChannelDropdown, searchNotificationChannelTextField, notificationChannel,selectNotificationChannel);
		page.locator(notificationChannelDropdown).click();
		
		//click on the add alerts btn
		System.out.println("addAlert disabled : "+page.locator(addAlert).isDisabled());
		for(int i=0;i<3;i++)
		{
			page.locator(alertNameTextField).clear();
			page.waitForTimeout(300);
			page.locator(alertNameTextField).fill(name);
			try {
				page.locator(addAlert).click();
				System.out.println("try block executed");
				break;
				
			} catch (Exception e) {
				System.out.println("catch block executed");
				continue;
			}
		}
		
		//validate the confirmation pup up
		Assert.assertEquals(page.locator(conformationPopup).textContent().trim(),successMessage );
		page.locator(conforPopupClosebtn).click();
		
		//validate the alert configured or not
		page.waitForLoadState(LoadState.DOMCONTENTLOADED);
		page.waitForSelector(addedAlert);
		Assert.assertEquals(page.locator(addedAlert).textContent().trim(),name);
		
		
	}
	
	public void addAlerts(String name,String metric,String errorCode,String aggregator,String operator,String thresholdValue,String timePeriod,String silencePeriod,String recoveryPeriod,String notificationChannel,String successMessage)
	{
		
		//click on the add alert button
		try
		{
			page.locator(addAlertsBtn).click();
		}
		catch (Exception e) 
		{
			page.locator(addAlertsFirstTimeBtn).click();
			
		}
		
		//validate the alerts page displayed or not
		page.waitForSelector(alertNamelabel);
		Assert.assertTrue(page.locator(alertNamelabel).isVisible());
		//enter the alert name
		page.locator(alertNameTextField).fill(name);
		try {
			page.waitForSelector(addAlert);
		} catch (Exception e) {

			page.locator(alertNameTextField).clear();
			page.locator(alertNameTextField).fill(name);
		}
		
		//select the metric from the drop down
		page.locator(metricDropdown).click();
		page.locator(searchMetric).clear();
		page.locator(searchMetric).fill(metric);
		page.waitForSelector(searchedMetric);
		Locator actualsearchedApplications=page.locator(searchedMetric);
		System.out.println(actualsearchedApplications.count());
		for(int i=0;i<actualsearchedApplications.count();i++)
		{ 
			if(actualsearchedApplications.nth(i).innerText().trim().equalsIgnoreCase(metric))
			{
				actualsearchedApplications.nth(i).click();
				break;
			}
		}
		Assert.assertTrue(page.locator(selectedMetric).isVisible());
		
		if(metric.equalsIgnoreCase("Error code")) 
		{
			page.locator(errorCodeDropdown).click();
			page.locator(searchErrorCode).fill(errorCode);
			page.locator(searchedErrorCode).click();
			Assert.assertTrue(page.locator(selectedErrorCode).isVisible());
		}else if ( metric.contains("error code"))
		{
			page.locator(errorCodeDropdown).click();
			page.locator(searchedErrorCode).click();
			Assert.assertTrue(page.locator(selectedErrorCode).isVisible());
		}
		else if(metric.equalsIgnoreCase("Endpoint response time")|| metric.equalsIgnoreCase("Endpoint error")|| metric.equalsIgnoreCase("Endpoint load")|| metric.equalsIgnoreCase("Endpoint error code"))
		{
			page.locator(endpointDropdown).click();
			page.locator(searchedEndpoint).first().click();
			Assert.assertTrue(page.locator(selectedEndpoint).isVisible());
			
			
		} else if(metric.equalsIgnoreCase("Instance response time")|| metric.equalsIgnoreCase("Instance error")|| metric.equalsIgnoreCase("Instance load")|| metric.equalsIgnoreCase("Instance error code"))
		{
			page.locator(instanceDropdown).click();
			page.locator(searchedInstance).first().click();
			Assert.assertTrue(page.locator(selectedInstance).isVisible());
		}
		
		//select the aggregator
		page.locator(aggregationDropdown).click();
		page.locator( "xpath = //label[text()='Aggregation type*']/ancestor::div[@class='d-flex flex-column mt-4 max-width']/descendant::span[@class='selected-item-text' and text()='"+aggregator+"']").click();
		Assert.assertTrue(page.locator(selectedAggregation).isVisible());
		
		//select the operator
		page.locator(operatorDropdown).click();
		page.locator("xpath = //span[@class='selected-item-text' and text()='"+operator+" ']").click();
		Assert.assertTrue(page.locator(selectedOperator).isVisible());
		
		//enter threshold value
		Locator threshold=page.locator(thresholdValueTextField);
		threshold.clear();
		threshold.fill(thresholdValue);
		
		if(!metric.equalsIgnoreCase("Instance availability"))
		{
		//enter the time period
		Locator timeperiod=page.locator(timePeriodTextField);
		timeperiod.clear();
		timeperiod.fill(timePeriod);
		}
		
		// enter the recovery period
		Locator recoveryperiod = page.locator(recoveryPeriodTextField);
		recoveryperiod.clear();
		recoveryperiod.fill(recoveryPeriod);
		
		//enter the silence period
		Locator silenceperiod=page.locator(silencePeriodTextField);
		silenceperiod.clear();
		silenceperiod.fill(silencePeriod);
		
		//select the notification channel
		
		util.selectTheOptionFromDropDownBySearch(page, notificationChannelDropdown, searchNotificationChannelTextField, notificationChannel,selectNotificationChannel);

		page.locator(notificationChannelDropdown).click();
		
		//click on the add alerts btn
		System.out.println("addAlert disabled : "+page.locator(addAlert).isDisabled());
		for(int i=0;i<3;i++)
		{
			page.locator(alertNameTextField).clear();
			page.waitForTimeout(300);
			page.locator(alertNameTextField).fill(name);
			try {
				page.locator(addAlert).click();
				System.out.println("try block executed");
				break;
				
			} catch (Exception e) {
				System.out.println("catch block executed");
				continue;
			}
		}
		
		Assert.assertEquals(page.locator(conformationPopup).textContent().trim(),successMessage );
		page.locator(conforPopupClosebtn).click();
		
			//validate the confirmation pup up
			Assert.assertEquals(page.locator(conformationPopup).textContent().trim(),successMessage );
			page.locator(conforPopupClosebtn).click();
			//validate the alert configured or not
			page.waitForLoadState(LoadState.DOMCONTENTLOADED);
			page.waitForSelector(addedAlert);
			Assert.assertEquals(page.locator(addedAlert).textContent().trim(),name);

	}
	
	public void validateWhetherTheNotificationChannelIsReflectingInAlertCreation(String channel) {
    	new CommonPage(page).navigateToAlerts();
    	try{ page.click(addAlertsFirstTimeBtn);} catch(Exception e) {page.click(addAlertsBtn);}
    	page.click(notificationChannelDropdown);
    	page.fill(searchNotificationChannelTextField, channel);
    	Locator result = page.locator(selectNotificationChannel);
    	boolean flag = false;
    	for(int i=0; i<result.count(); i++) {
    		if(result.nth(i).textContent().trim().equals(channel)) {
    			flag = true;
    			break;
    		}
    	}
    	Assert.assertTrue(flag);
    	page.click(addAlertWindowCloseBtn);
    }

public void deleteAlertsFromConfiguredAlertsPage(String successMessage)
{
	try {
		page.waitForSelector(expandBtns);
		System.out.println(page.locator(expandBtns).count());

		while (page.locator(expandBtns).count()>=1) {
			
			page.locator(expandBtns).first().click();
			page.locator(deleteIcon).click();
			Assert.assertTrue(page.locator(deleteAlertPopup).isVisible());
			page.locator(deleteBtn).click();
			//validate the alerts confirmation popup
			Assert.assertEquals(page.locator(conformationPopup).textContent().trim(),successMessage );
			page.locator(conforPopupClosebtn).click();
			page.waitForLoadState(LoadState.DOMCONTENTLOADED);
			try {
				page.locator(expandBtns).first().hover();
				
			} catch (Exception e) {
				break;
			}
			
			
		}
	} catch (Exception e) {
		System.out.println("************There are no configured Alerts***********");
	}
		

	
	}
	
	
	public void createAnAlertToValidateNotificationChannelDeletion(String[] data, String channel) {
    	new CommonPage(page).navigateToAlerts();
    	util.selectTheOptionFromDropDown(page, capabilityDropdown, data[0]);
    	util.selectTheOptionFromDropDownBySearch(page, applicationDrodpwn, searchApplication, data[1], searchedApplicationList);
    	try{ page.click(addAlertsFirstTimeBtn);} catch(Exception e) {page.click(addAlertsBtn);}
    	page.fill(alertNameTextField, data[2]+new Random().nextInt(1000));
    	page.fill(thresholdValueTextField, data[3]);
    	page.fill(recoveryPeriodTextField, data[4]);
    	util.selectTheOptionFromDropDownBySearch(page, notificationChannelDropdown, searchNotificationChannelTextField, channel, selectNotificationChannel);
    	page.click(addAlert);
    	page.waitForTimeout(1000);
    	if(page.isVisible(addAlertWindowCloseBtn))
    		page.click(addAlertWindowCloseBtn);
	}

}
