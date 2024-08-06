package alerts;

import org.testng.annotations.Test;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.BeforeMethod;

import genericUtilities.ExcelUtility;
import genericUtilities.GenericMethods;
import genericUtilities.IPathConstant;
import objectRepository.CommonPage;
import objectRepository.Alerts.AlertsTagGroupingPage;
import playWrightFactory.BaseClass;

public class AlertsTagGroupingTest extends BaseClass 
{
	GenericMethods util = new GenericMethods();
	CommonPage commonPage;
	AlertsTagGroupingPage alertsTagGroupingPage;
	ExcelUtility excel = new ExcelUtility();	

	@BeforeMethod
	public void TagGrouping() throws EncryptedDocumentException, IOException 
	{
		commonPage = new CommonPage(page);
		alertsTagGroupingPage = new  AlertsTagGroupingPage(page);
		excel = new ExcelUtility();
		commonPage.navigateToAlerts();
		alertsTagGroupingPage.navigateToTagGroupingTab();
	}	
		
	@Test (groups = {"AlertsalertsTagGroupingPage", "UI", "Regression"})
	public void TC_001_validate_Whether_The_Tag_Grouping_Tab_Is_Present() throws EncryptedDocumentException, IOException  {
		alertsTagGroupingPage.validateTagGroupingPageTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.alertsExcelPath, IPathConstant.alertsTagGrouping, "TagGroupingTabTitle"));
	}
		
	@Test (groups = {"AlertsalertsTagGroupingPage", "UI", "Regression"})
	public void TC_002_verify_Add_Tag_Group_Button_Is_Present_In_The_Tag_Grouping_Tab() throws EncryptedDocumentException, IOException  {
		alertsTagGroupingPage.verifyAddTagGroupButtonIsPresentInTheTagGroupingTab(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.alertsExcelPath, IPathConstant.alertsTagGrouping, "AddTagGroup"));
	}
		
	@Test (groups = {"AlertsalertsTagGroupingPage", "UI", "Regression"})
	public void TC_003_verify_Soft_Refresh_Button_In_The_Tag_Grouping_Tab() throws EncryptedDocumentException, IOException  {
		alertsTagGroupingPage.clickSoftRefreshButtonInTheTagGroupingTab();
	}
		
	@Test (groups = {"AlertsalertsTagGroupingPage", "UI", "Regression"})
	public void TC_004_verify_Add_Alert_Is_Displayed_In_Tag_Grouping_Tab() throws EncryptedDocumentException, IOException  {
		alertsTagGroupingPage.verifyAddAlertButtonIsDisplayedInTagGroupingTab(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.alertsExcelPath, IPathConstant.alertsTagGrouping, "AddAlert"));
	}
	
	@Test (groups = {"AlertsalertsTagGroupingPage", "UI", "Regression"})
	public void TC_005_verify_Alert_Name_Is_Displayed_In_Add_Alert() throws EncryptedDocumentException, IOException  {
		alertsTagGroupingPage.navigateToAddAlertPopup(); 
		alertsTagGroupingPage.verifyAlertNameIsDisplayedInAddAlert(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.alertsExcelPath, IPathConstant.alertsTagGrouping, "AlertName"));
		alertsTagGroupingPage.closeAddAlert();
	}
	
	@Test (groups = {"AlertsalertsTagGroupingPage", "UI", "Regression"})
	public void TC_006_verify_Saved_Search_Is_Displayed_In_Add_Alert() throws EncryptedDocumentException, IOException  {	
		alertsTagGroupingPage.navigateToAddAlertPopup();
		alertsTagGroupingPage.verifyServiceIsDisplayedInAddAlert(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.alertsExcelPath, IPathConstant.alertsTagGrouping, "Saved Search"));
		alertsTagGroupingPage.closeAddAlert();
	}
	
	@Test (groups = {"AlertsalertsTagGroupingPage", "UI", "Regression"})
	public void TC_007_verify_Metric_Is_Displayed_In_Add_Alert() throws EncryptedDocumentException, IOException  {
		alertsTagGroupingPage.navigateToAddAlertPopup();
		alertsTagGroupingPage.verifyMetricIsDisplayedInAddAlert(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.alertsExcelPath, IPathConstant.alertsTagGrouping, "Metric"));
		alertsTagGroupingPage.closeAddAlert();
	}
	
	@Test (groups = {"AlertsalertsTagGroupingPage", "UI", "Regression"})
	public void TC_008_verify_Aggregation_Type_Is_Displayed_In_Add_Alert() throws EncryptedDocumentException, IOException  {
		alertsTagGroupingPage.navigateToAddAlertPopup();
		alertsTagGroupingPage.verifyAggregationTypeIsDisplayedInAddAlert(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.alertsExcelPath, IPathConstant.alertsTagGrouping, "AggregationType"));
		alertsTagGroupingPage.closeAddAlert();
	}
	
	@Test (groups = {"AlertsalertsTagGroupingPage", "UI", "Regression"})
	public void TC_009_verify_Operator_Is_Displayed_In_Add_Alert() throws EncryptedDocumentException, IOException  {
		alertsTagGroupingPage.navigateToAddAlertPopup();
		alertsTagGroupingPage.verifyOperatorIsDisplayedInAddAlert(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.alertsExcelPath, IPathConstant.alertsTagGrouping, "Operator"));
		alertsTagGroupingPage.closeAddAlert();
	}
	
	@Test (groups = {"AlertsalertsTagGroupingPage", "UI", "Regression"})
	public void TC_010_verify_Threshold_Value_Is_Displayed_In_Add_Alert() throws EncryptedDocumentException, IOException  {
		alertsTagGroupingPage.navigateToAddAlertPopup();
		alertsTagGroupingPage.verifyThresholdValueIsDisplayedInAddAlert(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.alertsExcelPath, IPathConstant.alertsTagGrouping, "ThresholdValue"));
		alertsTagGroupingPage.closeAddAlert();
	}
	
	@Test (groups = {"AlertsalertsTagGroupingPage", "UI", "Regression"})
	public void TC_011_verify_Time_Period_Is_Displayed_In_Add_Alert() throws EncryptedDocumentException, IOException  {
		alertsTagGroupingPage.navigateToAddAlertPopup();
		alertsTagGroupingPage.verifyTimePeriodIsDisplayedInAddAlert(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.alertsExcelPath, IPathConstant.alertsTagGrouping, "TimePeriod"));
		alertsTagGroupingPage.closeAddAlert();
	}
	
	@Test (groups = {"AlertsalertsTagGroupingPage", "UI", "Regression"})
	public void TC_012_verify_Recovery_Period_Is_Displayed_In_Add_Alert() throws EncryptedDocumentException, IOException  {
		alertsTagGroupingPage.navigateToAddAlertPopup();
		alertsTagGroupingPage.verifyRecoveryPeriodIsDisplayedInAddAlert(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.alertsExcelPath, IPathConstant.alertsTagGrouping, "RecoveryPeriod"));
		alertsTagGroupingPage.closeAddAlert();
	}
	
	@Test (groups = {"AlertsalertsTagGroupingPage", "UI", "Regression"})
	public void TC_013_verify_SilencePeriod_Is_Displayed_In_Add_Alert() throws EncryptedDocumentException, IOException  {
		alertsTagGroupingPage.navigateToAddAlertPopup();
		alertsTagGroupingPage.verifySilencePeriodIsDisplayedInAddAlert(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.alertsExcelPath, IPathConstant.alertsTagGrouping, "SilencePeriod"));
		alertsTagGroupingPage.closeAddAlert();
	}
	
	@Test (groups = {"AlertsalertsTagGroupingPage", "UI", "Regression"})
	public void TC_014_verify_NotificationChannels_Is_Displayed_In_Add_Alert() throws EncryptedDocumentException, IOException  {
		alertsTagGroupingPage.navigateToAddAlertPopup();
		alertsTagGroupingPage.verifyNotificationChannelsIsDisplayedInAddAlert(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.alertsExcelPath, IPathConstant.alertsTagGrouping, "NotificationChannels"));
		alertsTagGroupingPage.closeAddAlert();
	}
	
	@Test (groups = {"AlertsalertsTagGroupingPage", "UI", "Regression"})
	public void TC_015_verify_AlertTags_Is_Displayed_In_Add_Alert() throws EncryptedDocumentException, IOException  {
		alertsTagGroupingPage.navigateToAddAlertPopup();
		alertsTagGroupingPage.verifyAlertTagsIsDisplayedInAddAlert(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.alertsExcelPath, IPathConstant.alertsTagGrouping, "AlertTags"));
		alertsTagGroupingPage.closeAddAlert();
	}
	
	@Test (groups = {"AlertsalertsTagGroupingPage", "UI", "Regression"})
	public void TC_016_verify_MetricValueOption_Is_Displayed_In_Add_Alert(	) throws EncryptedDocumentException, IOException  {
		alertsTagGroupingPage.navigateToAddAlertPopup();
		String metricOptions = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.alertsExcelPath, IPathConstant.alertsTagGrouping, "MetricOption");
		alertsTagGroupingPage.verifyMetricValueOptionIsDisplayedInAddAlert(metricOptions);
		alertsTagGroupingPage.closeAddAlert();
	}
	
	@Test (groups = {"AlertsalertsTagGroupingPage", "UI", "Regression"})
	public void TC_017_verify_AggregationTypeSumOption_Is_Displayed_In_Add_Alert() throws EncryptedDocumentException, IOException  {
		alertsTagGroupingPage.navigateToAddAlertPopup();
		alertsTagGroupingPage.verifyAggregationTypeSumOptionIsDisplayedInAddAlert(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.alertsExcelPath, IPathConstant.alertsTagGrouping, "AggregationTypeSumOption"));
		alertsTagGroupingPage.closeAddAlert();
	}
	
	@Test (groups = {"AlertsalertsTagGroupingPage", "UI", "Regression"})
	public void TC_018_verify_AggregationTypeAverageOption_Is_Displayed_In_Add_Alert() throws EncryptedDocumentException, IOException  {
		alertsTagGroupingPage.navigateToAddAlertPopup();
		alertsTagGroupingPage.verifyAggregationTypeAverageOptionIsDisplayedInAddAlert(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.alertsExcelPath, IPathConstant.alertsTagGrouping, "AggregationTypeAverageOption"));
		alertsTagGroupingPage.closeAddAlert();
	}
	
	@Test (groups = {"AlertsalertsTagGroupingPage", "UI", "Regression"})
	public void TC_019_verify_AggregationTypeCountOption_Is_Displayed_In_Add_Alert() throws EncryptedDocumentException, IOException  {
		alertsTagGroupingPage.navigateToAddAlertPopup();
		alertsTagGroupingPage.verifyAggregationTypeCountOptionIsDisplayedInAddAlert(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.alertsExcelPath, IPathConstant.alertsTagGrouping, "AggregationTypeCountOption"));
		alertsTagGroupingPage.closeAddAlert();
	}
	
	@Test (groups = {"AlertsalertsTagGroupingPage", "UI", "Regression"})
	public void TC_020_verify_AggregationTypeDynamicOption_Is_Displayed_In_Add_Alert() throws EncryptedDocumentException, IOException  {
		alertsTagGroupingPage.navigateToAddAlertPopup();
		alertsTagGroupingPage.verifyAggregationTypeDynamicOptionIsDisplayedInAddAlert(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.alertsExcelPath, IPathConstant.alertsTagGrouping, "AggregationTypeDynamicOption"));
		alertsTagGroupingPage.closeAddAlert();
	}
	
	@Test (groups = {"AlertsalertsTagGroupingPage", "UI", "Regression"})
	public void TC_021_verify_OperatorGreaterThanOption_Is_Displayed_In_Add_Alert() throws EncryptedDocumentException, IOException  {
		alertsTagGroupingPage.navigateToAddAlertPopup();
		alertsTagGroupingPage.verifyOperatorGreaterThanOptionIsDisplayedInAddAlert(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.alertsExcelPath, IPathConstant.alertsTagGrouping, "OperatorGreaterThanOption"));
		alertsTagGroupingPage.closeAddAlert();
	}
	
	@Test (groups = {"AlertsalertsTagGroupingPage", "UI", "Regression"})
	public void TC_022_verify_OperatorLesserThanOption_Is_Displayed_In_Add_Alert() throws EncryptedDocumentException, IOException  {
		alertsTagGroupingPage.navigateToAddAlertPopup();
		alertsTagGroupingPage.verifyOperatorLesserThanOptionIsDisplayedInAddAlert(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.alertsExcelPath, IPathConstant.alertsTagGrouping, "OperatorLesserThanOption"));
		alertsTagGroupingPage.closeAddAlert();
	}
	
	@Test (groups = {"AlertsalertsTagGroupingPage", "UI", "Regression"})
	public void TC_023_verify_OperatorGreaterThanOrEqualToOption_Is_Displayed_In_Add_Alert() throws EncryptedDocumentException, IOException  {
		alertsTagGroupingPage.navigateToAddAlertPopup();
		alertsTagGroupingPage.verifyOperatorGreaterThanOrEqualToOptionIsDisplayedInAddAlert(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.alertsExcelPath, IPathConstant.alertsTagGrouping, "OperatorGreaterThanOrEqualToOption"));
		alertsTagGroupingPage.closeAddAlert();
	}
	
	@Test (groups = {"AlertsalertsTagGroupingPage", "UI", "Regression"})
	public void TC_024_verify_OperatorLesserThanOrEqualToOption_Is_Displayed_In_Add_Alert() throws EncryptedDocumentException, IOException  {
		alertsTagGroupingPage.navigateToAddAlertPopup();
		alertsTagGroupingPage.verifyOperatorLesserThanOrEqualToOptionIsDisplayedInAddAlert(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.alertsExcelPath, IPathConstant.alertsTagGrouping, "OperatorLesserThanOrEqualToOption"));
		alertsTagGroupingPage.closeAddAlert();
	}
	
	@Test (groups = {"AlertsalertsTagGroupingPage", "UI", "Regression"})
	public void TC_025_verify_TimePeriodMinOption_Is_Displayed_In_Add_Alert() throws EncryptedDocumentException, IOException  {
		alertsTagGroupingPage.navigateToAddAlertPopup();
		alertsTagGroupingPage.verifyTimePeriodMinIsDisplayedInAddAlert(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.alertsExcelPath, IPathConstant.alertsTagGrouping, "TimePeriodMinOption"));
		alertsTagGroupingPage.closeAddAlert();
	}
	
	@Test (groups = {"AlertsalertsTagGroupingPage", "UI", "Regression"})
	public void TC_026_verify_RecoveryPeriodMinOption_Is_Displayed_In_Add_Alert() throws EncryptedDocumentException, IOException  {
		alertsTagGroupingPage.navigateToAddAlertPopup();
		alertsTagGroupingPage.verifyRecoveryPeriodMinIsDisplayedInAddAlert(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.alertsExcelPath, IPathConstant.alertsTagGrouping, "RecoveryPeriodMinOption"));
		alertsTagGroupingPage.closeAddAlert();
	}
	
	@Test (groups = {"AlertsalertsTagGroupingPage", "UI", "Regression"})
	public void TC_027_verify_SilencePeriodMinOption_Is_Displayed_In_Add_Alert() throws EncryptedDocumentException, IOException  {
		alertsTagGroupingPage.navigateToAddAlertPopup();
		alertsTagGroupingPage.verifySilencePeriodMinIsDisplayedInAddAlert(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.alertsExcelPath, IPathConstant.alertsTagGrouping, "SilencePeriodMinOption"));
		alertsTagGroupingPage.closeAddAlert();
	}
	
	@Test (groups = {"AlertsalertsTagGroupingPage", "UI", "Regression"})
	public void TC_028_verify_NotificationChannelsSelectChannel_Is_Displayed_In_Add_Alert() throws EncryptedDocumentException, IOException  {
		alertsTagGroupingPage.navigateToAddAlertPopup();
		alertsTagGroupingPage.verifyNotificationChannelsSelectChannelIsDisplayedInAddAlert(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.alertsExcelPath, IPathConstant.alertsTagGrouping, "NotificationChannelsSelectChannel"));
		alertsTagGroupingPage.closeAddAlert();
	}
	
	@Test (groups = {"AlertsalertsTagGroupingPage", "UI", "Regression"})
	public void TC_028_verify_AlertTags_Is_Displayed_In_Add_Alert() throws EncryptedDocumentException, IOException  {
		alertsTagGroupingPage.navigateToAddAlertPopup();
		alertsTagGroupingPage.verifyAlertTagsIsDisplayedInAddAlert(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.alertsExcelPath, IPathConstant.alertsTagGrouping, "AlertTags"));
		alertsTagGroupingPage.closeAddAlert();
	}
	
	@Test (groups = {"AlertsalertsTagGroupingPage", "UI", "Regression"})
	public void TC_028_verify_AlertTags__EnterKey_Is_Displayed_In_Add_Alert() throws EncryptedDocumentException, IOException  {
		alertsTagGroupingPage.navigateToAddAlertPopup();
		alertsTagGroupingPage.verifyAlertTagsEnterKeyIsDisplayedInAddAlert(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.alertsExcelPath, IPathConstant.alertsTagGrouping, "EnterKey"));
		alertsTagGroupingPage.closeAddAlert();
	}
	
	@Test (groups = {"AlertsalertsTagGroupingPage", "UI", "Regression"})
	public void TC_028_verify_AlertTags__EnterValue_Is_Displayed_In_Add_Alert() throws EncryptedDocumentException, IOException  {
		alertsTagGroupingPage.navigateToAddAlertPopup();
		alertsTagGroupingPage.verifyAlertTagsEnterValueIsDisplayedInAddAlert(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.alertsExcelPath, IPathConstant.alertsTagGrouping, "EnterValue"));
		alertsTagGroupingPage.closeAddAlert();
	}
	
	
	@Test (groups = {"AlertsalertsTagGroupingPage", "UI", "Regression"})
	public void TC_028_verfiyAlertTagsEnterKeyCharactersAcceptance() throws EncryptedDocumentException, IOException  {
		alertsTagGroupingPage.navigateToAddAlertPopup();
		alertsTagGroupingPage.verfiyAlertTagsEnterKeyCharactersAcceptance();
		alertsTagGroupingPage.closeAddAlert();
	}
	
	@Test (groups = {"AlertsalertsTagGroupingPage", "UI", "Regression"})
	public void TC_028_verfiyAlertTagsEnterValueCharactersAcceptance() throws EncryptedDocumentException, IOException  {
		alertsTagGroupingPage.navigateToAddAlertPopup();
		alertsTagGroupingPage.verfiyAlertTagsEnterValueCharactersAcceptance();
		alertsTagGroupingPage.closeAddAlert();
	}

	@Test (groups = {"AlertsalertsTagGroupingPage", "UI", "Regression"})
	public void TC_028_verfiyAlertTagsEnterKeyDuplicate() throws EncryptedDocumentException, IOException  {
		page.pause();
		alertsTagGroupingPage.navigateToAddAlertPopup();
		alertsTagGroupingPage.verfiyAlertTagsEnterKeyAndValueDuplicate();
		alertsTagGroupingPage.closeAddAlert();
	}
	
	@Test (groups = {"AlertsalertsTagGroupingPage", "UI", "Regression"})
	public void TC_029_verify_ClearButton_Is_Displayed_In_Add_Alert() throws EncryptedDocumentException, IOException  {
		alertsTagGroupingPage.navigateToAddAlertPopup();
		alertsTagGroupingPage.verifyClearButtonIsDisplayedInAddAlert(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.alertsExcelPath, IPathConstant.alertsTagGrouping, "ClearButton"));
		alertsTagGroupingPage.closeAddAlert();
	}
	
	@Test (groups = {"AlertsalertsTagGroupingPage", "UI", "Regression"})
	public void TC_029_verify_ClearButton_Click() throws EncryptedDocumentException, IOException  {
		alertsTagGroupingPage.navigateToAddAlertPopup();
		alertsTagGroupingPage.verifyClearButtonClick();
		alertsTagGroupingPage.closeAddAlert();
	}
	
	@Test (groups = {"AlertsalertsTagGroupingPage", "UI", "Regression"})
	public void TC_030_verify_AddButton_Is_Displayed_In_Add_Alert() throws EncryptedDocumentException, IOException  {
		alertsTagGroupingPage.navigateToAddAlertPopup();
		alertsTagGroupingPage.verifyAddButtonIsDisplayedInAddAlert(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.alertsExcelPath, IPathConstant.alertsTagGrouping, "AddButton"));
		alertsTagGroupingPage.closeAddAlert();
	}
	
	@Test (groups = {"AlertsalertsTagGroupingPage", "UI", "Regression"})
	public void TC_031_verify_AddAlert_Popup() throws EncryptedDocumentException, IOException  {
		alertsTagGroupingPage.navigateToAddAlertPopup();
		alertsTagGroupingPage.verifyAddAlertPopup();
		alertsTagGroupingPage.closeAddAlert();
	}
	
	// Add Tag Group
	
	@Test (groups = {"AlertsalertsTagGroupingPage", "UI", "Regression"})
	public void TC_032_verify_AddTagGroupTitle_Is_Displayed_In_Add_Tag_Group() throws EncryptedDocumentException, IOException  {
		alertsTagGroupingPage.navigateToAddTagGroupPopup();
		alertsTagGroupingPage.validateAddTagGroupTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.alertsExcelPath, IPathConstant.alertsTagGrouping, "AddTagGroupTitle"));
		alertsTagGroupingPage.clickCloseTagGroupPopup();
	}
	
	@Test (groups = {"AlertsalertsTagGroupingPage", "UI", "Regression"})
	public void TC_033_verify_TagGroupNameTitle_Is_Displayed_In_Add_Tag_Group() throws EncryptedDocumentException, IOException  {
		alertsTagGroupingPage.navigateToAddTagGroupPopup();
		alertsTagGroupingPage.validateTagGroupNameTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.alertsExcelPath, IPathConstant.alertsTagGrouping, "TagGroupNameTitle"));
		alertsTagGroupingPage.clickCloseTagGroupPopup();
	}
	
	@Test (groups = {"AlertsalertsTagGroupingPage", "UI", "Regression"})
	public void TC_034_verify_GroupNameTitle_Is_Displayed_In_Add_Tag_Group() throws EncryptedDocumentException, IOException  {
		alertsTagGroupingPage.navigateToAddTagGroupPopup();
		alertsTagGroupingPage.validateGroupNameTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.alertsExcelPath, IPathConstant.alertsTagGrouping, "GroupNameTitle"));
		alertsTagGroupingPage.clickCloseTagGroupPopup();
	}
	
	@Test (groups = {"AlertsalertsTagGroupingPage", "UI", "Regression"})
	public void TC_034_verify_GroupName_Limit_In_Add_Tag_Group() throws EncryptedDocumentException, IOException  {
		alertsTagGroupingPage.navigateToAddTagGroupPopup();
		alertsTagGroupingPage.validateGroupNameCharLimit();
		alertsTagGroupingPage.clickCloseTagGroupPopup();
	}
	
	
	@Test (groups = {"AlertsalertsTagGroupingPage", "UI", "Regression"})
	public void TC_035_verify_KeyTitle_Is_Displayed_In_Add_Tag_Group() throws EncryptedDocumentException, IOException  {
		alertsTagGroupingPage.navigateToAddTagGroupPopup();
		alertsTagGroupingPage.validateKeyTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.alertsExcelPath, IPathConstant.alertsTagGrouping, "KeyTitle"));
		alertsTagGroupingPage.clickCloseTagGroupPopup();
	}
	
	@Test (groups = {"AlertsalertsTagGroupingPage", "UI", "Regression"})
	public void TC_036_verify_KeyOption_Is_Displayed_In_Add_Tag_Group() throws EncryptedDocumentException, IOException  {
		alertsTagGroupingPage.navigateToAddTagGroupPopup();
		alertsTagGroupingPage.validateKeyOption(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.alertsExcelPath, IPathConstant.alertsTagGrouping, "KeyOption"));
		alertsTagGroupingPage.clickCloseTagGroupPopup();
	}
	
	@Test (groups = {"AlertsalertsTagGroupingPage", "UI", "Regression"})
	public void TC_037_verify_GroupingConditionTitle_Is_Displayed_In_Add_Tag_Group() throws EncryptedDocumentException, IOException  {
		alertsTagGroupingPage.navigateToAddTagGroupPopup();
		alertsTagGroupingPage.validateGroupingConditionTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.alertsExcelPath, IPathConstant.alertsTagGrouping, "GroupingConditionTitle"));
		alertsTagGroupingPage.clickCloseTagGroupPopup();
	}
	
	@Test (groups = {"AlertsalertsTagGroupingPage", "UI", "Regression"})
	public void TC_038_verify_GroupingConditionAllRadioButton_Is_Displayed_In_Add_Tag_Group() throws EncryptedDocumentException, IOException  {
		alertsTagGroupingPage.navigateToAddTagGroupPopup();
		alertsTagGroupingPage.validateGroupingConditionAllRadioButton();
		alertsTagGroupingPage.clickCloseTagGroupPopup();
	}
	
	@Test (groups = {"AlertsalertsTagGroupingPage", "UI", "Regression"})
	public void TC_039_verify_GroupingConditionAllOption_Is_Displayed_In_Add_Tag_Group() throws EncryptedDocumentException, IOException  {
		alertsTagGroupingPage.navigateToAddTagGroupPopup();
		alertsTagGroupingPage.validateGroupingConditionAllOption(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.alertsExcelPath, IPathConstant.alertsTagGrouping, "GroupingConditionAllOption"));
		alertsTagGroupingPage.clickCloseTagGroupPopup();
	}
	
	@Test (groups = {"AlertsalertsTagGroupingPage", "UI", "Regression"})
	public void TC_040_verify_GroupingConditionCustomRadioButton_Is_Displayed_In_Add_Tag_Group() throws EncryptedDocumentException, IOException  {
		alertsTagGroupingPage.navigateToAddTagGroupPopup();
		alertsTagGroupingPage.validateGroupingConditionCustomRadioButton(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.alertsExcelPath, IPathConstant.alertsTagGrouping, "GroupingConditionCustomRadioButton"));
		alertsTagGroupingPage.clickCloseTagGroupPopup();
	}
	
	@Test (groups = {"AlertsalertsTagGroupingPage", "UI", "Regression"})
	public void TC_041_verify_GroupingConditionCustomOption_Is_Displayed_In_Add_Tag_Group() throws EncryptedDocumentException, IOException  {
		alertsTagGroupingPage.navigateToAddTagGroupPopup();
		alertsTagGroupingPage.validateGroupingConditionCustomOption(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.alertsExcelPath, IPathConstant.alertsTagGrouping, "GroupingConditionCustomOption"));
		alertsTagGroupingPage.clickCloseTagGroupPopup();
	}
	
	@Test (groups = {"AlertsalertsTagGroupingPage", "UI", "Regression"})
	public void TC_041_verify_GroupingCondition_CustomOption() throws EncryptedDocumentException, IOException  {
		alertsTagGroupingPage.navigateToAddTagGroupPopup();
		alertsTagGroupingPage.verifyGroupingConditionCustomOption(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.alertsExcelPath, IPathConstant.alertsTagGrouping, "GroupingConditionCustomExpression"));
		alertsTagGroupingPage.clickCloseTagGroupPopup();
	}
	
	////////Value
	
	@Test (groups = {"AlertsalertsTagGroupingPage", "UI", "Regression"})
	public void TC_042_validateValueTitle() throws EncryptedDocumentException, IOException  {
		alertsTagGroupingPage.navigateToAddTagGroupPopup();
		alertsTagGroupingPage.validateValueTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.alertsExcelPath, IPathConstant.alertsTagGrouping, "ValueTitle"));
		alertsTagGroupingPage.clickCloseTagGroupPopup();
	}
	
	@Test (groups = {"AlertsalertsTagGroupingPage", "UI", "Regression"})
	public void TC_043_validateValueGroupATitle() throws EncryptedDocumentException, IOException  {
		alertsTagGroupingPage.navigateToAddTagGroupPopup();
		alertsTagGroupingPage.validateValueGroupATitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.alertsExcelPath, IPathConstant.alertsTagGrouping, "ValueGroupATitle"));
		alertsTagGroupingPage.clickCloseTagGroupPopup();
	}
	
	@Test (groups = {"AlertsalertsTagGroupingPage", "UI", "Regression"})
	public void TC_044_validateValueGroupAOption1Title1() throws EncryptedDocumentException, IOException  {
		alertsTagGroupingPage.navigateToAddTagGroupPopup();
		alertsTagGroupingPage.validateValueGroupAOption1Title1(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.alertsExcelPath, IPathConstant.alertsTagGrouping, "GroupAOption1Title1"));
		alertsTagGroupingPage.clickCloseTagGroupPopup();
	}
	
	@Test (groups = {"AlertsalertsTagGroupingPage", "UI", "Regression"})
	public void TC_045_validateValueGroupAOption1Title2() throws EncryptedDocumentException, IOException  {
		alertsTagGroupingPage.navigateToAddTagGroupPopup();
		alertsTagGroupingPage.validateValueGroupAOption1Title2(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.alertsExcelPath, IPathConstant.alertsTagGrouping, "GroupAOption1Title2"));
		alertsTagGroupingPage.clickCloseTagGroupPopup();
	}
	
	@Test (groups = {"AlertsalertsTagGroupingPage", "UI", "Regression"})
	public void TC_046_validateValueGroupAOption2Title1() throws EncryptedDocumentException, IOException  {
		alertsTagGroupingPage.navigateToAddTagGroupPopup();
		alertsTagGroupingPage.validateValueGroupAOption2Title1(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.alertsExcelPath, IPathConstant.alertsTagGrouping, "GroupAOption2Title1"));
		alertsTagGroupingPage.clickCloseTagGroupPopup();
	}
	
	@Test (groups = {"AlertsalertsTagGroupingPage", "UI", "Regression"})
	public void TC_047_validateValueGroupAOption2Title2() throws EncryptedDocumentException, IOException  {
		alertsTagGroupingPage.navigateToAddTagGroupPopup();
		alertsTagGroupingPage.validateValueGroupAOption2Title2(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.alertsExcelPath, IPathConstant.alertsTagGrouping, "GroupAOption2Title2"));
		alertsTagGroupingPage.clickCloseTagGroupPopup();
	}

	@Test (groups = {"AlertsalertsTagGroupingPage", "UI", "Regression"})
	public void TC_048_validateValueGroupAddButton4Times() throws EncryptedDocumentException, IOException  {
		alertsTagGroupingPage.navigateToAddTagGroupPopup();
		alertsTagGroupingPage.validateValueGroupAddButton4Times();
		alertsTagGroupingPage.clickCloseTagGroupPopup();
	}
	
	@Test (groups = {"AlertsalertsTagGroupingPage", "UI", "Regression"})
	public void TC_049_validateValueClearOptionTitle() throws EncryptedDocumentException, IOException  {
		alertsTagGroupingPage.navigateToAddTagGroupPopup();
		alertsTagGroupingPage.validateValueClearOptionTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.alertsExcelPath, IPathConstant.alertsTagGrouping, "ClearOptionTitle"));
		alertsTagGroupingPage.clickCloseTagGroupPopup();
	}
	
	@Test (groups = {"AlertsalertsTagGroupingPage", "UI", "Regression"})
	public void TC_050_validateValueNextOptionTitle() throws EncryptedDocumentException, IOException  {
		alertsTagGroupingPage.navigateToAddTagGroupPopup();
		alertsTagGroupingPage.validateValueNextOptionTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.alertsExcelPath, IPathConstant.alertsTagGrouping, "NextOptionTitle"));
		alertsTagGroupingPage.clickCloseTagGroupPopup();
	}
	
	//Time Frame
	
	@Test (groups = {"AlertsalertsTagGroupingPage", "UI", "Regression"})
	public void TC_051_validateTimeFrameNameTitle() throws EncryptedDocumentException, IOException  {
		alertsTagGroupingPage.clickDeletePopupDeleteOption();
		alertsTagGroupingPage.navigateFromAddTagGroupToTimeFrame();
		alertsTagGroupingPage.validateTimeFrameNameTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.alertsExcelPath, IPathConstant.alertsTagGrouping, "TimeFrameNameTitle"));
		alertsTagGroupingPage.clickCloseTagGroupPopup();
	}
	
	@Test (groups = {"AlertsalertsTagGroupingPage", "UI", "Regression"})
	public void TC_052_validateTimeFrameGroupAggregationTimeTitle() throws EncryptedDocumentException, IOException  {
		alertsTagGroupingPage.navigateFromAddTagGroupToTimeFrame();
		alertsTagGroupingPage.validateTimeFrameGroupAggregationTimeTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.alertsExcelPath, IPathConstant.alertsTagGrouping, "TimeFrameGroupAggregationTimeTitle"));
		alertsTagGroupingPage.clickCloseTagGroupPopup();
	}
	
	@Test (groups = {"AlertsalertsTagGroupingPage", "UI", "Regression"})
	public void TC_053_validateTimeFrameGroupAggregationTimeOption() throws EncryptedDocumentException, IOException  {
		alertsTagGroupingPage.navigateFromAddTagGroupToTimeFrame();
		alertsTagGroupingPage.validateTimeFrameGroupAggregationTimeOption(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.alertsExcelPath, IPathConstant.alertsTagGrouping, "TimeFrameGroupAggregationTimeOption"));
		alertsTagGroupingPage.clickCloseTagGroupPopup();
	}
	
	@Test (groups = {"AlertsalertsTagGroupingPage", "UI", "Regression"})
	public void TC_054_validateTimeFrameManualNotificationText() throws EncryptedDocumentException, IOException  {
		alertsTagGroupingPage.navigateFromAddTagGroupToTimeFrame();
		alertsTagGroupingPage.validateTimeFrameManualNotificationText(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.alertsExcelPath, IPathConstant.alertsTagGrouping, "TimeFrameManualNotificationText"));
		alertsTagGroupingPage.clickCloseTagGroupPopup();
	}
	
	@Test (groups = {"AlertsalertsTagGroupingPage", "UI", "Regression"})
	public void TC_055_validateTimeFrameManualNotificationTextChar() throws EncryptedDocumentException, IOException  {
		alertsTagGroupingPage.navigateFromAddTagGroupToTimeFrame();
		alertsTagGroupingPage.validateTimeFrameManualNotificationTextChar(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.alertsExcelPath, IPathConstant.alertsTagGrouping, "TimeFrameManualNotificationTextChar"));
		alertsTagGroupingPage.clickCloseTagGroupPopup();
	}

	@Test (groups = {"AlertsalertsTagGroupingPage", "UI", "Regression"})
	public void TC_056_validateTimeFrameManualNotification500Chars() throws EncryptedDocumentException, IOException  {
		alertsTagGroupingPage.navigateFromAddTagGroupToTimeFrame();
		alertsTagGroupingPage.validateTimeFrameManualNotification500Chars();
		alertsTagGroupingPage.clickCloseTagGroupPopup();
	}
	
	
	@Test (groups = {"AlertsalertsTagGroupingPage", "UI", "Regression"})
	public void TC_057_validateTimeFrameClearOptionTitle() throws EncryptedDocumentException, IOException  {
		alertsTagGroupingPage.navigateFromAddTagGroupToTimeFrame();
		alertsTagGroupingPage.validateTimeFrameClearOptionTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.alertsExcelPath, IPathConstant.alertsTagGrouping, "TimeFrameClearOptionTitle"));
		alertsTagGroupingPage.clickCloseTagGroupPopup();
	}
	
	@Test (groups = {"AlertsalertsTagGroupingPage", "UI", "Regression"})
	public void TC_058_validateTimeFrameNextOptionTitle() throws EncryptedDocumentException, IOException  {
		alertsTagGroupingPage.navigateFromAddTagGroupToTimeFrame();
		alertsTagGroupingPage.validateTimeFrameNextOptionTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.alertsExcelPath, IPathConstant.alertsTagGrouping, "TimeFrameNextOptionTitle"));
		alertsTagGroupingPage.clickCloseTagGroupPopup();
	}
	
	// Notification
	
	@Test (groups = {"AlertsalertsTagGroupingPage", "UI", "Regression"})
	public void TC_059_validateNotificationTitle() throws EncryptedDocumentException, IOException  {
		alertsTagGroupingPage.clickDeletePopupDeleteOption();
		alertsTagGroupingPage.navigateFromAddTagGroupToNotification();
		alertsTagGroupingPage.validateNotificationTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.alertsExcelPath, IPathConstant.alertsTagGrouping, "NotificationTitle"));
		alertsTagGroupingPage.clickCloseTagGroupPopup();
	}
	
	@Test (groups = {"AlertsalertsTagGroupingPage", "UI", "Regression"})
	public void TC_060_validateNotificationChannelTitle() throws EncryptedDocumentException, IOException  {
		alertsTagGroupingPage.navigateFromAddTagGroupToNotification();
		alertsTagGroupingPage.validateNotificationChannelTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.alertsExcelPath, IPathConstant.alertsTagGrouping, "NotificationChannelTitle"));
		alertsTagGroupingPage.clickCloseTagGroupPopup();
	}
	
	@Test (groups = {"AlertsalertsTagGroupingPage", "UI", "Regression"})
	public void TC_061_validateNotificationSelectChannelTitle() throws EncryptedDocumentException, IOException  {
		alertsTagGroupingPage.navigateFromAddTagGroupToNotification();
		alertsTagGroupingPage.validateNotificationSelectChannelTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.alertsExcelPath, IPathConstant.alertsTagGrouping, "NotificationSelectChannelTitle"));
		alertsTagGroupingPage.clickCloseTagGroupPopup();
	}
	
	@Test (groups = {"AlertsalertsTagGroupingPage", "UI", "Regression"})
	public void TC_062_validateNotificationSetPriorityTitle() throws EncryptedDocumentException, IOException  {
		page.waitForTimeout(2000);
		alertsTagGroupingPage.navigateFromAddTagGroupToNotification();
		alertsTagGroupingPage.validateNotificationSetPriorityTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.alertsExcelPath, IPathConstant.alertsTagGrouping, "NotificationSetPriorityTitle"));
		alertsTagGroupingPage.clickCloseTagGroupPopup();
	}
	
	@Test (groups = {"AlertsalertsTagGroupingPage", "UI", "Regression"})
	public void TC_063_validateNotificationSetPriorityRadio1() throws EncryptedDocumentException, IOException  {
		alertsTagGroupingPage.navigateFromAddTagGroupToNotification();
		alertsTagGroupingPage.validateNotificationSetPriorityRadio1();
		alertsTagGroupingPage.clickCloseTagGroupPopup();
	}
	
	@Test (groups = {"AlertsalertsTagGroupingPage", "UI", "Regression"})
	public void TC_064_validateNotificationSetPriorityRadio2() throws EncryptedDocumentException, IOException  {
		alertsTagGroupingPage.navigateFromAddTagGroupToNotification();
		alertsTagGroupingPage.validateNotificationSetPriorityRadio2();
		alertsTagGroupingPage.clickCloseTagGroupPopup();
	}
	
	@Test (groups = {"AlertsalertsTagGroupingPage", "UI", "Regression"})
	public void TC_065_validateNotificationSetPriorityRadio3() throws EncryptedDocumentException, IOException  {
		alertsTagGroupingPage.navigateFromAddTagGroupToNotification();
		alertsTagGroupingPage.validateNotificationSetPriorityRadio3();
		alertsTagGroupingPage.clickCloseTagGroupPopup();
	}
	
	@Test (groups = {"AlertsalertsTagGroupingPage", "UI", "Regression"})
	public void TC_066_validateNotificationSetPriorityRadio4() throws EncryptedDocumentException, IOException  {
		alertsTagGroupingPage.navigateFromAddTagGroupToNotification();
		alertsTagGroupingPage.validateNotificationSetPriorityRadio4();
		alertsTagGroupingPage.clickCloseTagGroupPopup();
	}
	
	@Test (groups = {"AlertsalertsTagGroupingPage", "UI", "Regression"})
	public void TC_067_validateNotificationSetPriorityOption1() throws EncryptedDocumentException, IOException  {
		page.waitForTimeout(2000);
		alertsTagGroupingPage.navigateFromAddTagGroupToNotification();
		alertsTagGroupingPage.validateNotificationSetPriorityOption1(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.alertsExcelPath, IPathConstant.alertsTagGrouping, "NotificationSetPriorityOption1"));
		alertsTagGroupingPage.clickCloseTagGroupPopup();
	}
	
	@Test (groups = {"AlertsalertsTagGroupingPage", "UI", "Regression"})
	public void TC_068_validateNotificationSetPriorityOption2() throws EncryptedDocumentException, IOException  {
		alertsTagGroupingPage.navigateFromAddTagGroupToNotification();
		alertsTagGroupingPage.validateNotificationSetPriorityOption2(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.alertsExcelPath, IPathConstant.alertsTagGrouping, "NotificationSetPriorityOption2"));
		alertsTagGroupingPage.clickCloseTagGroupPopup();
	}
	
	@Test (groups = {"AlertsalertsTagGroupingPage", "UI", "Regression"})
	public void TC_069_validateNotificationSetPriorityOption3() throws EncryptedDocumentException, IOException  {
		alertsTagGroupingPage.navigateFromAddTagGroupToNotification();
		alertsTagGroupingPage.validateNotificationSetPriorityOption3(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.alertsExcelPath, IPathConstant.alertsTagGrouping, "NotificationSetPriorityOption3"));
		alertsTagGroupingPage.clickCloseTagGroupPopup();
	}
	
	@Test (groups = {"AlertsalertsTagGroupingPage", "UI", "Regression"})
	public void TC_070_validateNotificationSetPriorityOption4() throws EncryptedDocumentException, IOException  {
		alertsTagGroupingPage.navigateFromAddTagGroupToNotification();
		alertsTagGroupingPage.validateNotificationSetPriorityOption4(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.alertsExcelPath, IPathConstant.alertsTagGrouping, "NotificationSetPriorityOption4"));
		alertsTagGroupingPage.clickCloseTagGroupPopup();
	}
	
	@Test (groups = {"AlertsalertsTagGroupingPage", "UI", "Regression"})
	public void TC_071_validateNotificationClearOptionTitle() throws EncryptedDocumentException, IOException  {
		alertsTagGroupingPage.navigateFromAddTagGroupToNotification();
		alertsTagGroupingPage.validateNotificationClearOptionTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.alertsExcelPath, IPathConstant.alertsTagGrouping, "NotificationClearOptionTitle"));
		alertsTagGroupingPage.clickCloseTagGroupPopup();
	}
	
	@Test (groups = {"AlertsalertsTagGroupingPage", "UI", "Regression"})
	public void TC_072_validateNotificationSaveOptionTitle() throws EncryptedDocumentException, IOException  {
		alertsTagGroupingPage.navigateFromAddTagGroupToNotification();
		alertsTagGroupingPage.validateNotificationSaveOptionTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.alertsExcelPath, IPathConstant.alertsTagGrouping, "NotificationSaveOptionTitle"));
		alertsTagGroupingPage.clickCloseTagGroupPopup();
	}
	
	@Test (groups = {"AlertsalertsTagGroupingPage", "UI", "Regression"})
	public void TC_073_addTagGroupAlert1() throws EncryptedDocumentException, IOException  {
		alertsTagGroupingPage.navigateFromAddTagGroupToNotification();
		String channelName = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.alertsExcelPath, IPathConstant.alertsTagGrouping, "ChannelName");
		alertsTagGroupingPage.addTagGroupAlert(channelName);
		alertsTagGroupingPage.validateNotificationSetPriorityRadio1();
		alertsTagGroupingPage.clickSaveTagGroupPopup();
	}
	
	@Test (groups = {"AlertsalertsTagGroupingPage", "UI", "Regression"})
	public void TC_074_addTagGroupAlert2() throws EncryptedDocumentException, IOException  {
		alertsTagGroupingPage.navigateFromAddTagGroupToNotification2();
		String channelName = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.alertsExcelPath, IPathConstant.alertsTagGrouping, "ChannelName");
		alertsTagGroupingPage.addTagGroupAlert(channelName);
		alertsTagGroupingPage.validateNotificationSetPriorityRadio2();
		alertsTagGroupingPage.clickSaveTagGroupPopup();
	}
	
	@Test (groups = {"AlertsalertsTagGroupingPage", "UI", "Regression"})
	public void TC_075_validateHeader1Title() throws EncryptedDocumentException, IOException  {
		alertsTagGroupingPage.validateHeader1Title(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.alertsExcelPath, IPathConstant.alertsTagGrouping, "Header1Title"));
	}
	
	@Test (groups = {"AlertsalertsTagGroupingPage", "UI", "Regression"})
	public void TC_076_validateHeader2Title() throws EncryptedDocumentException, IOException  {
		alertsTagGroupingPage.validateHeader2Title(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.alertsExcelPath, IPathConstant.alertsTagGrouping, "Header2Title"));
	}
	
	@Test (groups = {"AlertsalertsTagGroupingPage", "UI", "Regression"})
	public void TC_077_validateHeader3Title() throws EncryptedDocumentException, IOException  {
		alertsTagGroupingPage.validateHeader3Title(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.alertsExcelPath, IPathConstant.alertsTagGrouping, "Header3Title"));
	}
	
	@Test (groups = {"AlertsalertsTagGroupingPage", "UI", "Regression"})
	public void TC_078_validateHeader4Title() throws EncryptedDocumentException, IOException  {
		alertsTagGroupingPage.validateHeader4Title(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.alertsExcelPath, IPathConstant.alertsTagGrouping, "Header4Title"));
	}
	
	@Test (groups = {"AlertsalertsTagGroupingPage", "UI", "Regression"})
	public void TC_079_validateHeader5Title() throws EncryptedDocumentException, IOException  {
		alertsTagGroupingPage.validateHeader5Title(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.alertsExcelPath, IPathConstant.alertsTagGrouping, "Header5Title"));
	}
	
	@Test (groups = {"AlertsalertsTagGroupingPage", "UI", "Regression"})
	public void TC_080_validateHeader6Title() throws EncryptedDocumentException, IOException  {
		alertsTagGroupingPage.validateHeader6Title(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.alertsExcelPath, IPathConstant.alertsTagGrouping, "Header6Title"));
	}
	
	@Test (groups = {"AlertsalertsTagGroupingPage", "UI", "Regression"})
	public void TC_081_validateEditOption() throws EncryptedDocumentException, IOException  {
		alertsTagGroupingPage.validateEditOption1();
	}
	
	@Test (groups = {"AlertsalertsTagGroupingPage", "UI", "Regression"})
	public void TC_082_validateDeleteOption1() throws EncryptedDocumentException, IOException  {
		alertsTagGroupingPage.validateDeleteOption1();
		alertsTagGroupingPage.clickDeleteCancelButton();
	}
	
	@Test (groups = {"AlertsalertsTagGroupingPage", "UI", "Regression"})
	public void TC_083_validateDeletePopupTitle() throws EncryptedDocumentException, IOException  {
		alertsTagGroupingPage.validateDeleteOption1();
		alertsTagGroupingPage.validateDeletePopupTitle(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.alertsExcelPath, IPathConstant.alertsTagGrouping, "DeletePopupTitle"));
		alertsTagGroupingPage.clickDeleteCancelButton();
	}
	
	@Test (groups = {"AlertsalertsTagGroupingPage", "UI", "Regression"})
	public void TC_084_validateDeletePopupDescription() throws EncryptedDocumentException, IOException  {
		alertsTagGroupingPage.validateDeleteOption1();
		alertsTagGroupingPage.validateDeletePopupDescription(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.alertsExcelPath, IPathConstant.alertsTagGrouping, "DeletePopupDescription"));
		alertsTagGroupingPage.clickDeleteCancelButton();
	}

	@Test (groups = {"AlertsalertsTagGroupingPage", "UI", "Regression"})
	public void TC_085_validateDeletePopupCancelOption() throws EncryptedDocumentException, IOException  {
		alertsTagGroupingPage.validateDeleteOption1();
		alertsTagGroupingPage.validateDeletePopupCancelOption(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.alertsExcelPath, IPathConstant.alertsTagGrouping, "DeletePopupCancelOption"));
		alertsTagGroupingPage.clickDeleteCancelButton();
	}
	
	@Test (groups = {"AlertsalertsTagGroupingPage", "UI", "Regression"})
	public void TC_086_validateDeletePopupDeleteOption() throws EncryptedDocumentException, IOException  {
		alertsTagGroupingPage.validateDeleteOption1();
		alertsTagGroupingPage.validateDeletePopupDeleteOption(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.alertsExcelPath, IPathConstant.alertsTagGrouping, "DeletePopupDeleteOption"));
		alertsTagGroupingPage.clickDeleteCancelButton();
	}
}