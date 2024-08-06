package alerts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import genericUtilities.ExcelUtility;
import genericUtilities.IPathConstant;
import objectRepository.HomePage;
import objectRepository.Alerts.AlertsPage;
import playWrightFactory.BaseClass;

public class ConfiguredAlertsTableTest extends BaseClass {
	
	ExcelUtility eutil=new ExcelUtility();
	AlertsPage alertsPage;
	HomePage homePage;
	
	
	@BeforeMethod
	public void preRequest() throws EncryptedDocumentException, IOException
	{
		homePage=new HomePage(page);
		alertsPage=new AlertsPage(page);
		
		//navigate to the alerts capability
		commPage.navigateToAlerts();
						
		//navigate to config alerts tab
		alertsPage.NavigateToConfiguredAlertsTab();
						
		//select the capability
		alertsPage.selectCapabilityFromDropDown(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.alertsExcelPath, IPathConstant.alertsSheet, "capability"));
						
		//select the application
		alertsPage.selectApplicationfromDropdown(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.alertsExcelPath, IPathConstant.alertsSheet, "application"));
		
		alertsPage.deleteAlerts();
				
	}
	
	@Test(groups = {"Alerts", "Regression"})
	public void TC_01_validate_The_Alerts_page()
	{
		//navigate to the alerts capability
		commPage.navigateToAlerts();
		
		//validate The alerts page
		alertsPage.validateTheAlertsPage();
	}
	
	
	@Test(groups = {"Alerts", "Regression"})
	public void TC_02_validate_The_Configured_Alerts_Tab()
	{
		//navigate to the alerts capability
		commPage.navigateToAlerts();
		
		//navigate to config alerts tab
		alertsPage.NavigateToConfiguredAlertsTab();
		
		//validate the config alerts tab
		alertsPage.ValidateTheConfiguredAlertsPage();
	}
	
	@Test(groups = {"Alerts", "Regression"})
	public void TC_03_validate_The_Message_When_No_Alerts_Are_Configured() throws EncryptedDocumentException, IOException
	{
		
		
		//delete the alerts
		alertsPage.deleteAlertsFromConfiguredAlertsPage(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath, IPathConstant.messageSheet, "AlertsDeletedMessage"));
		
		//navigate to config alerts tab
		alertsPage.NavigateToConfiguredAlertsTab();
		
		
		//validate the message
		alertsPage.validatemessageWhenNoAlerts(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath, IPathConstant.messageSheet, "MessageWhenNoAlerts"));

	}
	
	@Test(groups = {"Alerts", "Regression"})
	public void TC_04_validate_The_Close_Btn_Of_AddAlert_Popup()
	{
		//click on the addAlert btn
		alertsPage.clickOnAddAlertBtn();
		
		//validate the close btn
		alertsPage.validateTheCloseBtnOfAddAlertPopup();
	}
	
	@Test(groups = {"Alerts", "Regression"})
	public void TC_05_validate_The_Clear_Button_Of_AddAlert_PopUp() throws EncryptedDocumentException, IOException
	{
		
		//click on the addAlert btn
		alertsPage.clickOnAddAlertBtn();
		
		//validate the clear btn
		alertsPage.validateTheClearBtnOfAddAlertPopup(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.alertsExcelPath, IPathConstant.alertsSheet, "alertName"),eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.alertsExcelPath, IPathConstant.alertsSheet, "metricName"));
		
		//close the add alert pop up
		alertsPage.closeTheAddAlertPopup();
	}
	
	@Test(groups = {"Alerts", "Regression"})
	public void TC_06_validate_The_Error_Message_Of_Alert_Name_Text_Field_For_More_200_Characters() throws EncryptedDocumentException, IOException
	{
		
		//click on the addAlert btn
		alertsPage.clickOnAddAlertBtn();
		
		//validate the error message when we enter more the 200 characters
		alertsPage.validateTheErrorMessagewhenThereIsWrongData(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.alertsExcelPath, IPathConstant.alertsSheet, "maximumLengthName"),
						eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath, IPathConstant.messageSheet, "MessageWhenMaximumLenghtBreached"));
		
		//close the add alert pop up
		alertsPage.closeTheAddAlertPopup();
	}
	
	@Test(groups = {"Alerts", "Regression"})
	public void TC_07_validate_The_Error_Message_Of_Alert_Name_Text_Field_For_Special_Charactes() throws EncryptedDocumentException, IOException
	{
		//click on the addAlert btn
		alertsPage.clickOnAddAlertBtn();
				
		//validate the error message when we enter special characters
		alertsPage.validateTheErrorMessagewhenThereIsWrongData(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.alertsExcelPath, IPathConstant.alertsSheet, "alertNameWithSpecialCharacters"),
								eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath, IPathConstant.messageSheet, "MessageForSpecialCharacters"));
		
		//close the add alert pop up
		alertsPage.closeTheAddAlertPopup();

	}
	
	@Test(groups = {"Alerts", "Regression"})
	public void TC_08_validate_The_Error_Message_Of_Alert_Name_Text_Field_For_Blank() throws EncryptedDocumentException, IOException
	{
		//click on the addAlert btn
		alertsPage.clickOnAddAlertBtn();
						
		//validate the error message when we leave alertname blank
		alertsPage.validateTheErrorMessagewhenThereIsWrongData(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.alertsExcelPath, IPathConstant.alertsSheet, ""),
										eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath, IPathConstant.messageSheet, "MessageForBlank"));
		
		//close the add alert pop up
		alertsPage.closeTheAddAlertPopup();

	}
	
	@Test(groups = {"Alerts", "Regression"})
	public void TC_09_validate_The_Error_Message_Of_Alert_Name_Text_Field_For_Duplicate_Name() throws EncryptedDocumentException, IOException
	{
		//click on the addAlert btn
		alertsPage.clickOnAddAlertBtn();
		
		//validate the error message
		alertsPage.validateTheErrorMessagewhenThereIsWrongData("",eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath, IPathConstant.messageSheet, "MessageForBlank"));
		
		//close the add alert pop up
		alertsPage.closeTheAddAlertPopup();

		
	}
	
	@Test(groups = {"Alerts", "Regression"})
	public void TC_10_validate_The_Info_Icon_Of_Metrics_Label() throws EncryptedDocumentException, IOException
	{
		//click on the addAlert btn
		alertsPage.clickOnAddAlertBtn();
		
		//validate Info Icon
		alertsPage.validateMetricInfo(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath, IPathConstant.messageSheet, "metricInfoText"));
		
		//close the add alert pop up
		alertsPage.closeTheAddAlertPopup();
	}
	

	@Test(groups = {"Alerts", "Regression"})
	public void TC_11_validate_The_Info_Icon_Of_Instance_Label() throws EncryptedDocumentException, IOException
	{
		//click on  add alert
		alertsPage.clickOnAddAlertBtn();
		
		//select the metric
		alertsPage.selectTheMetricFromDropDown(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.alertsExcelPath, IPathConstant.alertsSheet, "Instancemetric"));
		
		//validate Info Icon
		alertsPage.validateInstanceInfo(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath, IPathConstant.messageSheet, "instaceInfoText"));
		
		//close the add alert pop up
		alertsPage.closeTheAddAlertPopup();
	
	}
	

	@Test(groups = {"Alerts", "Regression"})
	public void TC_12_validate_The_Info_Icon_Of_Error_Code_Label()throws EncryptedDocumentException, IOException
	{
		//click on  add alert
		alertsPage.clickOnAddAlertBtn();
		
		//select the metric
		alertsPage.selectTheMetricFromDropDown(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.alertsExcelPath, IPathConstant.alertsSheet, "InstanceMetric"));
		
		//validate Info Icon
		alertsPage.validateErrorCodeInfoIcon(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath, IPathConstant.messageSheet, "errorCodeInfoText"));
		
		//close the add alert pop up
		alertsPage.closeTheAddAlertPopup();
	
	}
	

	@Test(groups = {"Alerts", "Regression"})
	public void TC_13_validate_The_Info_Icon_Of_Endpoint_Label()throws EncryptedDocumentException, IOException
	{
		//click on  add alert
		alertsPage.clickOnAddAlertBtn();
		
		//select the metric
		alertsPage.selectTheMetricFromDropDown(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.alertsExcelPath, IPathConstant.alertsSheet, "EndpointMetric"));
		
		//validate Info Icon
		alertsPage.validateEndpointInfo(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath, IPathConstant.messageSheet, "endPointInfoText"));
		
		//close the add alert pop up
		alertsPage.closeTheAddAlertPopup();
	
	}
	

	@Test(groups = {"Alerts", "Regression"})
	public void TC_14_validate_The_Info_Icon_Of_Time_Period_Label() throws EncryptedDocumentException, IOException
	{

		//click on  add alert
		alertsPage.clickOnAddAlertBtn();
		
		//validate Info Icon
		alertsPage.validateTimePeriodInfo(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath, IPathConstant.messageSheet, "timePeriodInfoText"));
		
		//close the add alert pop up
		alertsPage.closeTheAddAlertPopup();

	}
	
	@Test(groups = {"Alerts", "Regression"})
	public void TC_15_validate_The_Info_Icon_Of_Recovery_Period_Label() throws EncryptedDocumentException, IOException
	{
		//click on  add alert
		alertsPage.clickOnAddAlertBtn();
						
		//validate Info Icon
		alertsPage.validateRecoveryPeriodInfo(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath, IPathConstant.messageSheet, "recoveryPeriodInfoText"));
		
		//close the add alert pop up
		alertsPage.closeTheAddAlertPopup();

	}
	
	@Test(groups = {"Alerts", "Regression"})
	public void TC_16_validate_The_Info_Icon_Of_Silence_Period_Label() throws EncryptedDocumentException, IOException
	{
		//click on  add alert
		alertsPage.clickOnAddAlertBtn();
								
						
		//validate Info Icon
		alertsPage.validateSilencePeriodInfo(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath, IPathConstant.messageSheet, "silencePeriodInfoText"));
		
		//close the add alert pop up
		alertsPage.closeTheAddAlertPopup();

	}
	
	@Test(groups = {"Alerts", "Regression"})
	public void TC_17_validate_The_Info_Icon_Of_Threshold_Value_Label() throws EncryptedDocumentException, IOException
	{
		//click on  add alert
		alertsPage.clickOnAddAlertBtn();
										
								
		//validate Info Icon
		alertsPage.validateThresholdInfo(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath, IPathConstant.messageSheet, "ThresholdValueInfoText"));
		
		//close the add alert pop up
		alertsPage.closeTheAddAlertPopup();

	}
	
	@Test(groups = {"Alerts", "Regression"})
	public void TC_18_validate_The_Time_Period_Column_Error_Message() throws EncryptedDocumentException, IOException
	{
		//click on  add alert
		alertsPage.clickOnAddAlertBtn();
		
		alertsPage.validateTimePeriodErrorMessage("0",eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath, IPathConstant.messageSheet, "timePeriodErrorMessage"));
		
		//close the add alert pop up
		alertsPage.closeTheAddAlertPopup();
	}
	
	@Test(groups = {"Alerts", "Regression"})
	public void TC_19_validate_The_Time_Period_Column_Error_Message_Greater_Than_1440() throws EncryptedDocumentException, IOException
	{
		//click on  add alert
		alertsPage.clickOnAddAlertBtn();
				
		alertsPage.validateTimePeriodErrorMessage("1441",eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath, IPathConstant.messageSheet, "timePeriodErrorMessage"));
		
		//close the add alert pop up
		alertsPage.closeTheAddAlertPopup();

	}
	
	@Test(groups = {"Alerts", "Regression"})
	public void TC_20_validate_The_Silence_Period_Column_Error_Message() throws EncryptedDocumentException, IOException
	{
		//click on  add alert
		alertsPage.clickOnAddAlertBtn();
		
		alertsPage.validateSilencePeriodErrorMessage("0",eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath, IPathConstant.messageSheet, "silencePeriodErrorMessage"));
		
		//close the add alert pop up
		alertsPage.closeTheAddAlertPopup();
		
		
	}
	
	@Test(groups = {"Alerts", "Regression"})
	public void TC_21_validate_The_Recovery_Period_Column_Error_Message() throws EncryptedDocumentException, IOException
	{
		//click on  add alert
		alertsPage.clickOnAddAlertBtn();
		
		alertsPage.validateRecoveryPeriodErrorMessage("0",eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath, IPathConstant.messageSheet, "recoveryPeriodErrorMessage"));
		
		//close the add alert pop up
		alertsPage.closeTheAddAlertPopup();
	}
	
	@Test(groups = {"Alerts", "Regression"})
	public void TC_22_validate_The_Silence_Period_Column_Error_Message_For_Greater_Than_1440() throws EncryptedDocumentException, IOException
	{

		//click on  add alert
		alertsPage.clickOnAddAlertBtn();
		
		alertsPage.validateSilencePeriodErrorMessage("1441", eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath, IPathConstant.messageSheet, "silencePeriodErrorMessage"));
		
		//close the add alert pop up
		alertsPage.closeTheAddAlertPopup();
		
	}
	
	@Test(groups = {"Alerts", "Regression"})
	public void TC_23_validate_The_Recovery_Period_Column_Error_Message_Greater_Than_1440() throws EncryptedDocumentException, IOException
	{
		//click on  add alert
		alertsPage.clickOnAddAlertBtn();
				
		alertsPage.validateRecoveryPeriodErrorMessage("1441", eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath, IPathConstant.messageSheet, "recoveryPeriodErrorMessage"));
		
		//close the add alert pop up
		alertsPage.closeTheAddAlertPopup();
			
	}
	
	@Test(groups = {"Alerts", "Regression"})
	public void TC_24_validate_The_Submit_Button_Is_Disabled_Or_Not_When_Name_Is_Blank()
	{
		//click on  add alert
		alertsPage.clickOnAddAlertBtn();
		
		alertsPage.validateTheSubmitBtn();
		
		//close the add alert pop up
		alertsPage.closeTheAddAlertPopup();
	}
	
	@Test(groups = {"Alerts", "Regression"})
	public void TC_25_validate_The_Threshould_Value_DropDown_Options() throws EncryptedDocumentException, IOException
	{
		//click on  add alert
		alertsPage.clickOnAddAlertBtn();
		
		//select the metric
		alertsPage.selectTheMetricFromDropDown(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.alertsExcelPath, IPathConstant.alertsSheet, "metricName"));
		
		//validate the ThresholdDropDown
		alertsPage.validateTheThresholdDropDown(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.alertsExcelPath, IPathConstant.alertsSheet, "ThresholdDropdownValues"));
		
		//close the add alert pop up
		alertsPage.closeTheAddAlertPopup();
		
		
	}
	
	@Test(groups = {"Alerts", "Regression"})
	public void TC_26_validate_The_Threshould_Value_DropDown_For_Ms() throws EncryptedDocumentException, IOException
	{
		System.out.println("started");
		try {
			alertsPage.addAnAlert(
					eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.alertsExcelPath, IPathConstant.alertsSheet,"alertName"),
					eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.alertsExcelPath, IPathConstant.alertsSheet,"metricName"),
					eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.alertsExcelPath, IPathConstant.alertsSheet,"ThresholdValue"),IPathConstant.thresholdMilliSecValue);
		} finally {
			//delete the created alert
			alertsPage.deleteAnAlert();
		}
		
	}
	
	@Test(groups = {"Alerts", "Regression"})
	public void TC_27_validate_The_Threshould_Value_DropDown_For_Sec()throws EncryptedDocumentException, IOException
	{
		try
		{
		alertsPage.addAnAlert(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.alertsExcelPath, IPathConstant.alertsSheet, "alertName"),
				eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.alertsExcelPath, IPathConstant.alertsSheet, "metricName"),
				eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.alertsExcelPath, IPathConstant.alertsSheet, "ThresholdValue"),IPathConstant.thresholdSecValue);
		}
		finally {
		//delete the created alert
		alertsPage.deleteAnAlert();
		}
	}
	
	@Test(groups = {"Alerts", "Regression"})
	public void TC_28_validate_The_Threshould_Value_DropDown_For_Min()throws EncryptedDocumentException, IOException
	{
		try {
		alertsPage.addAnAlert(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.alertsExcelPath, IPathConstant.alertsSheet, "alertName"),
				eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.alertsExcelPath, IPathConstant.alertsSheet, "metricName"),
				eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.alertsExcelPath, IPathConstant.alertsSheet, "ThresholdValue"),IPathConstant.thresholdMinValue);
		} finally {
		//delete the created alert
		alertsPage.deleteAnAlert();
		}

	}
	
	@Test(groups = {"Alerts", "Regression"})
	public void TC_29_validate_The_Threshould_Value_DropDown_For_Hours()throws EncryptedDocumentException, IOException
	{
		try {
		alertsPage.addAnAlert(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.alertsExcelPath, IPathConstant.alertsSheet, "alertName"),
				eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.alertsExcelPath, IPathConstant.alertsSheet, "metricName"),
				eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.alertsExcelPath, IPathConstant.alertsSheet, "ThresholdValue"),IPathConstant.thresholdHourValue);
		}finally {
		//delete the created alert
		alertsPage.deleteAnAlert();
		}

	}
	
	@Test(groups = {"Alerts", "Regression"})
	public void TC_30_validate_The_Time_Period_DropDown() throws EncryptedDocumentException, IOException
	{
		//click on  add alert
		alertsPage.clickOnAddAlertBtn();
				
		//select the metric
		alertsPage.selectTheMetricFromDropDown(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.alertsExcelPath, IPathConstant.alertsSheet, "metricName"));
				
		alertsPage.validateTheTimePeriodDropDown(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.alertsExcelPath, IPathConstant.alertsSheet, "TimePerioDropdownValue"));
		
		//close the add alert pop up
		alertsPage.closeTheAddAlertPopup();
	}
	
	@Test(groups = {"Alerts", "Regression"})
	public void TC_31_validate_The_Recovery_Period_DropDown()throws EncryptedDocumentException, IOException
	{
		//click on  add alert
		alertsPage.clickOnAddAlertBtn();
						
		//select the metric
		alertsPage.selectTheMetricFromDropDown(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.alertsExcelPath, IPathConstant.alertsSheet, "metricName"));
						
		alertsPage.validateTheRecoveryPeriodDropDown(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.alertsExcelPath, IPathConstant.alertsSheet, "RecoveryPeriodDropdownValues"));
		
		//close the add alert pop up
		alertsPage.closeTheAddAlertPopup();

	}
	
	@Test(groups = {"Alerts", "Regression"})
	public void TC_32_validate_The_Silence_Period_DropDown()throws EncryptedDocumentException, IOException
	{
		//click on  add alert
		alertsPage.clickOnAddAlertBtn();
								
		//select the metric
		alertsPage.selectTheMetricFromDropDown(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.alertsExcelPath, IPathConstant.alertsSheet, "metricName"));
								
		alertsPage.validateTheSilencePeriodDropDown(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.alertsExcelPath, IPathConstant.alertsSheet, "SilencePeriodDropdownValues"));
		
		//close the add alert pop up
		alertsPage.closeTheAddAlertPopup();

	}

	@Test(groups = {"Alerts", "Regression"})
	public void TC_33_validate_The_Alert_Tag_Text_Fileds() throws EncryptedDocumentException, IOException
	{
		//click on  add alert
		alertsPage.clickOnAddAlertBtn();
		
		alertsPage.validateAlertTags(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.alertsExcelPath, IPathConstant.alertsSheet, "AlertTags"));
		
		//close the add alert pop up
		alertsPage.closeTheAddAlertPopup();
	}
	
	@Test(groups = {"Alerts", "Regression"})
	public void TC_34_validate_The_AddAlert_Window_Column_Names() throws EncryptedDocumentException, IOException
	{
		//click on  add alert
		alertsPage.clickOnAddAlertBtn();
		
		//select the metric
		alertsPage.selectTheMetricFromDropDown(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.alertsExcelPath, IPathConstant.alertsSheet, "metricName"));
			
				
		alertsPage.validateThecolumnText(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.alertsExcelPath, IPathConstant.alertsSheet, "ColumnNames"));
		
		//close the add alert pop up
		alertsPage.closeTheAddAlertPopup();
	}
	
	@Test(groups = {"Alerts", "Regression"})
	public void TC_35_validate_The_AddAlert_Window_Column_Names_With_Error_Code_Metric() throws EncryptedDocumentException, IOException
	{
		//click on add alert
		alertsPage.clickOnAddAlertBtn();
		
		//select the metric
		alertsPage.selectTheMetricFromDropDown(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.alertsExcelPath, IPathConstant.alertsSheet, "ErrorMetric"));
				
		alertsPage.validateThecolumnText(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.alertsExcelPath, IPathConstant.alertsSheet, "CloumnNameForErrorCodeMetric"));

		//close the add alert pop up
		alertsPage.closeTheAddAlertPopup();
	}
	
	@Test(groups = {"Alerts", "Regression"})
	public void TC_36_validate_The_AddAlert_Window_column_Names_With_Endpoint_Metric() throws EncryptedDocumentException, IOException
	{
		//click on add alert
		alertsPage.clickOnAddAlertBtn();
		
		//select the metric
		alertsPage.selectTheMetricFromDropDown(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.alertsExcelPath, IPathConstant.alertsSheet, "EndpointMetric"));
		
				
		alertsPage.validateThecolumnText(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.alertsExcelPath, IPathConstant.alertsSheet, "CloumnNameForEndpointMetric"));
		
		//close the add alert pop up
		alertsPage.closeTheAddAlertPopup();
	}
	
	@Test(groups = {"Alerts", "Regression"})
	public void TC_37_validate_The_Add_Alert_Window_column_Names_With_Instance_Metric() throws EncryptedDocumentException, IOException
	{
		//click on add alert
		alertsPage.clickOnAddAlertBtn();
		
		//select the metric
		alertsPage.selectTheMetricFromDropDown(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.alertsExcelPath, IPathConstant.alertsSheet, "InstanceMetric"));
				
		alertsPage.validateThecolumnText(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.alertsExcelPath, IPathConstant.alertsSheet, "CloumnNameForInstanceMetric"));
		
		//close the add alert pop up
		alertsPage.closeTheAddAlertPopup();
	}
	
	@Test(groups = {"Alerts", "Regression"})
	public void TC_38_validate_The_Expand_Btn_Of_Configured_Alert() throws EncryptedDocumentException, IOException
	{	try {
		//add an alert
		alertsPage.addAnAlert(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.alertsExcelPath, IPathConstant.alertsSheet, "alertName"));
		
		//validate the expand button of configured alert
		alertsPage.validateExpandBtn();
	}finally {
		
		//delete the created alert
		alertsPage.deleteAnAlert();
	}

	}
	
	@Test(groups = {"Alerts", "Regression"})
	public void TC_39_validate_The_Expanded_Titles() throws EncryptedDocumentException, IOException
	{		
		try {
		//add an alert
		alertsPage.addAnAlert(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.alertsExcelPath, IPathConstant.alertsSheet, "alertName"));
		
		//validate the expanded title
		alertsPage.validateExpandTitles(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.alertsExcelPath, IPathConstant.alertsSheet, "expandedTitles"));
		}finally {
		//delete the created alert
		alertsPage.deleteAnAlert();
		}
				
		
	}
	
	@Test(groups = {"Alerts", "Regression"})
	public void TC_40_validate_The_Status_Toggle_Buttons()throws EncryptedDocumentException, IOException
	{
		try {
		//add an alert
		alertsPage.addAnAlert(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.alertsExcelPath, IPathConstant.alertsSheet, "alertName"));
		
		alertsPage.validateToggleBtns(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.alertsExcelPath, IPathConstant.alertsSheet, "toggleButtonsText"));
		
		}finally {
		//delete the created alert
		alertsPage.deleteAnAlert();
		}
				
	}
	
	@Test(groups = {"Alerts", "Regression"})
	public void TC_41_validate_The_Default_Status_Of_Toggle_Btn_Should_Be_Active() throws EncryptedDocumentException, IOException
	{
		try {
		//add an alert
		alertsPage.addAnAlert(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.alertsExcelPath, IPathConstant.alertsSheet, "alertName"));
		
		//validate default toggle btn
		alertsPage.validateDefaultToggleBtn();
		}finally {
		
		//delete the created alert
		alertsPage.deleteAnAlert();
		}
	}
	
	@Test(groups = {"Alerts", "Regression"})
	public void TC_42_validate_The_Active_Status_Toggle_Buttons()throws EncryptedDocumentException, IOException
	{
		
		try {
		//add an alert
		alertsPage.addAnAlert(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.alertsExcelPath, IPathConstant.alertsSheet, "alertName"));
		
		//validate Active toggle btn
		alertsPage.validateActiveToggleBtn(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath, IPathConstant.messageSheet, "AlertActivatedMessage"));
	}finally {
		//delete the created alert
		alertsPage.deleteAnAlert();
	}
	}
	
	@Test(groups = {"Alerts", "Regression"})
	public void TC_43_validate_The_Inactive_Status_Toggle_Buttons()throws EncryptedDocumentException, IOException
	{
		try {
		//add an alert
		alertsPage.addAnAlert(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.alertsExcelPath, IPathConstant.alertsSheet, "alertName"));
			
		//validate Active toggle btn
		alertsPage.validateInactiveToggleBtn(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath, IPathConstant.messageSheet, "AlertInactivatedMessage"));
		}finally {
		//delete the created alert
		alertsPage.deleteAnAlert();
		}

	}
	
	@Test(groups = {"Alerts", "Regression"})
	public void TC_44_validate_The_Text_Of_Active_Status_Popup()throws EncryptedDocumentException, IOException
	{
		try {
		//add an alert
		alertsPage.addAnAlert(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.alertsExcelPath, IPathConstant.alertsSheet, "alertName"));

		//validate Active toggle btn
		alertsPage.validateActiveStatusPopUp(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath, IPathConstant.messageSheet, "ActiveAlertPopUpText"));
		
		}
		finally {
		//delete the created alert
		alertsPage.deleteAnAlert();
		}

	}
	
	@Test(groups = {"Alerts", "Regression"})
	public void TC_45_validate_the_Text_Of_InActive_Status_Popup()throws EncryptedDocumentException, IOException
	{
		try {
		//add an alert
		alertsPage.addAnAlert(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.alertsExcelPath, IPathConstant.alertsSheet, "alertName"));
						
		//validate Active toggle btn
		alertsPage.validateInactiveStatusPopUp(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath, IPathConstant.messageSheet, "InactiveAlertPopUpText"));
		
		}finally {
		//delete the created alert
		alertsPage.deleteAnAlert();
		}

	}
	
	@Test(groups = {"Alerts", "Regression"})
	public void TC_46_validate_The_Cancel_Button_Of_Active_Status()throws EncryptedDocumentException, IOException
	{
		try {
		//add an alert
		alertsPage.addAnAlert(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.alertsExcelPath, IPathConstant.alertsSheet, "alertName"));
						
		//validate Active toggle btn
		alertsPage.validateActiveStatusCancelBtn();
		}finally {
		
		//delete the created alert
		alertsPage.deleteAnAlert();
		}

	}
	
	@Test(groups = {"Alerts", "Regression"})
	public void TC_47_validate_The_Cancel_Button_Of_InActive_Status()throws EncryptedDocumentException, IOException
	{
		try {
		//add an alert
		alertsPage.addAnAlert(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.alertsExcelPath, IPathConstant.alertsSheet, "alertName"));
		
		//validate Active toggle btn
		alertsPage.validateInactiveStatusCancelBtn();
		}finally {
		
		//delete the created alert
		alertsPage.deleteAnAlert();
		}
		
	}
	@Test(groups = {"Alerts", "Regression"})
	public void TC_48_validate_The_Action_Buttons()throws EncryptedDocumentException, IOException
	{
		try {
		//add an alert
		alertsPage.addAnAlert(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.alertsExcelPath, IPathConstant.alertsSheet, "alertName"));
	
		//validate the action Icons
		alertsPage.validateActionIcons();
		}finally {
		
		//delete the created alert
		alertsPage.deleteAnAlert();
		}
	}
	
	@Test(groups = {"Alerts", "Regression"})
	public void TC_49_validate_The_EditIcon()throws EncryptedDocumentException, IOException
	{
		try {
		//add an alert
		alertsPage.addAnAlert(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.alertsExcelPath, IPathConstant.alertsSheet, "alertName"));
		alertsPage.validateEditIcon(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.alertsExcelPath, IPathConstant.alertsSheet, "editedName"),
									eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath, IPathConstant.messageSheet, "AlertsEditedMessage"));
		
		}finally {
		//delete the created alert
		alertsPage.deleteAnAlert();
		}
	}
	
	@Test
	public void TC_50_validate_The_Edit_Alert_Popup()throws EncryptedDocumentException, IOException
	{
		try {
		//add an alert
		alertsPage.addAnAlert(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.alertsExcelPath, IPathConstant.alertsSheet, "alertName"));
		
		//validate edit Alert pop up
		alertsPage.validateEditAlertPopUp();
		}finally {
		
		//delete the created alert
		alertsPage.deleteAnAlert();
		}
			
	}
	@Test(groups = {"Alerts", "Regression"})
	public void TC_51_validate_The_Delete_Icon()throws EncryptedDocumentException, IOException
	{
		try {
		//add an alert
		alertsPage.addAnAlert(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.alertsExcelPath, IPathConstant.alertsSheet, "alertName"));
		
		//add an alert
		alertsPage.addAnAlert(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.alertsExcelPath, IPathConstant.alertsSheet, "editedName"));
				
		alertsPage.validateDeleteIcon(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath, IPathConstant.messageSheet, "AlertsDeletedMessage"),
										eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.alertsExcelPath, IPathConstant.alertsSheet, "editedName"));
		}finally {
		//delete the created alert
		alertsPage.deleteAnAlert();
		}

	}
	
	@Test(groups = {"Alerts", "Regression"})
	public void TC_52_validate_The_Delete_Alert_Popup()throws EncryptedDocumentException, IOException
	{
		
		//add an alert
		alertsPage.addAnAlert(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.alertsExcelPath, IPathConstant.alertsSheet, "alertName"));
		
		//validate the delete alert pou up 
		alertsPage.validateDeleteAlertpopUp(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath, IPathConstant.messageSheet, "deleteAlertPopUpText"));
	}
	
	@Test(groups = {"Alerts", "Regression"})
	public void TC_53_validate_The_Delet_Alert_Cancel_Button()throws EncryptedDocumentException, IOException
	{
		try {
		//add an alert
		alertsPage.addAnAlert(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.alertsExcelPath, IPathConstant.alertsSheet, "alertName"));
		
		//validate the delete alert pop up 
		alertsPage.validateDeleteAlertpopUpCancelBtn(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.alertsExcelPath, IPathConstant.alertsSheet, "alertName"));
		}finally {
		//delete the created alert
		alertsPage.deleteAnAlert();
		}
				
	}
	
	@Test(groups = {"Alerts", "Regression"})
	public void TC_54_validate_The_Delete_Alert_Mark_Inactive_Instead_Link()throws EncryptedDocumentException, IOException
	{
		
		try {
		//add an alert
		alertsPage.addAnAlert(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.alertsExcelPath, IPathConstant.alertsSheet, "alertName"));

		alertsPage.validateTheMarkInactiveLink(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.alertsExcelPath, IPathConstant.alertsSheet, "markInactiveText"),
				eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath, IPathConstant.messageSheet, "InactiveAlertPopUpText"));
		}finally {
		//delete the created alert
		alertsPage.deleteAnAlert();
		}
	}
	
	@Test(groups = {"Alerts", "Regression"})
	public void TC_55_validate_The_Delete_Alert_Mark_Inactive_Instead_Link_When_Alert_Inactive()throws EncryptedDocumentException, IOException
	{
		try {
		//add an alert
		alertsPage.addAnAlert(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.alertsExcelPath, IPathConstant.alertsSheet, "alertName"));

		//validate Inactive toggle btn
		alertsPage.validateInactiveToggleBtn(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath, IPathConstant.messageSheet, "AlertInactivatedMessage"));

		//validate mark inactive text
		alertsPage.validateTheMarkInactiveLinkIsvisibleOrNot();
		
		}finally {
		//delete the created alert
		alertsPage.deleteAnAlert();
		}
	}
	
	
	@Test(groups = {"Alerts", "Regression"})
	public void TC_56_validate_The_CreatedOn_Date()throws EncryptedDocumentException, IOException
	{
		try {
		//add an alert
		alertsPage.addAnAlertAndValidateTheCreatedDate(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.alertsExcelPath, IPathConstant.alertsSheet, "alertName"));
		
		}finally {
		//delete the created alert
		alertsPage.deleteAnAlert();
		}
				
	}
	
	@Test(groups = {"Alerts", "Regression"})
	public void TC_57_validate_The_Notification_Channel_Count()throws EncryptedDocumentException, IOException
	{
		try {
		//add an alert
		alertsPage.addAnAlertABySelectingNotificationChannel(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.alertsExcelPath, IPathConstant.alertsSheet, "alertName"),
						eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.alertsExcelPath, IPathConstant.alertsSheet, "notificationChannelName"));
		}finally {
		//delete the created alert
		alertsPage.deleteAnAlert();
		}
				
	}
	
	@Test(groups = {"Alerts", "Regression"})
	public void TC_58_validate_The_Search_Bar_With_Valid_Data()throws EncryptedDocumentException, IOException
	{
		try {
		//add an alert
		alertsPage.addAnAlert(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.alertsExcelPath, IPathConstant.alertsSheet, "alertName"));
				
		//add an alert
		alertsPage.addAnAlert(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.alertsExcelPath, IPathConstant.alertsSheet, "editedName"));
										
				
		alertsPage.validateSearchBarWithValidData();
		}finally {
		
		//delete the created alert
		alertsPage.deleteAnAlert();
		//delete the created alert
		alertsPage.deleteAnAlert();
		}
		
	}
	
	@Test(groups = {"Alerts", "Regression"})
	public void TC_59_validate_The_Search_Bar_With_InActive_Data()throws EncryptedDocumentException, IOException
	{
		try {
		//add an alert
		alertsPage.addAnAlert(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.alertsExcelPath, IPathConstant.alertsSheet, "alertName"));
				
		alertsPage.validateSearchBarWithInValidData();
		
		}finally {
		//delete the created alert
		alertsPage.deleteAnAlert();
		}
	}
	
	@Test (dataProvider = "pagination",groups = {"Alerts", "Regression"})
	public void TC_60_validate_Pagination(String num) throws EncryptedDocumentException, IOException {
		try {
		//add an alert
		alertsPage.addAnAlert(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.alertsExcelPath, IPathConstant.alertsSheet, "alertName"));
						
		//add an alert
		alertsPage.addAnAlert(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.alertsExcelPath, IPathConstant.alertsSheet, "editedName"));
		
		alertsPage.validatePagination(Integer.parseInt(num));
		}finally {
		//delete the created alert
		alertsPage.deleteAnAlert();
		//delete the created alert
		alertsPage.deleteAnAlert();
		}
	}
	
	@DataProvider 
	public Object[][] pagination() throws Exception, Exception {
		return eutil.fetchAllTheDataFromExcelSheet(IPathConstant.commExcelPath, IPathConstant.commonPaginationSheet);
	}
	
	@AfterMethod
	public void postRequest() throws EncryptedDocumentException, IOException
	{
		alertsPage.closeTheAlertPopUp();
	}


}





