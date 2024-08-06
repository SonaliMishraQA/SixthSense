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

public class Alerts_APM_Python_Gateway_PhpTest extends BaseClass {
	
	ExcelUtility eutil=new ExcelUtility();
	AlertsPage alertsPage;
	HomePage homePage;
	
	
	@BeforeMethod
	public void preRequest()
	{
		homePage=new HomePage(page);
		alertsPage=new AlertsPage(page);	
	}
	@AfterMethod
	public void postRequest()
	{
		alertsPage.closeTheAlertPopUp();
	}
	
	
	@Test(priority = -6,groups = {"Alerts", "Regression"})
	public void TC_03_pre_Request_For_Alerts_Configuration()
	{
		//navigate to the alerts capability
		commPage.navigateToAlerts();
				
		//navigate to config alerts tab
		alertsPage.NavigateToConfiguredAlertsTab();
				
		//select the capability
		alertsPage.selectCapabilityFromDropDown(IPathConstant.alertsAPMCapability);
		
		//select the application
		String application=System.getenv("APMPythonApplication");
		alertsPage.selectApplicationfromDropdown(application);
		
		//alertsPage.selectApplicationfromDropdown("Alerts_Python");
		
		alertsPage.deleteAlerts();
	}

	
	@Test(priority = -5,dataProvider = "getDataFromDataProvider",groups = {"Alerts", "Regression"})
	public void TC_04_configure_Alerts_For_Apm_Python_Appication(String name,String metric,String aggregator,String operator,String thresholdValue,String timePeriod,String silencePeriod,String recoveryPeriod,String notificationChannel,String errorCode) throws EncryptedDocumentException, IOException
	{	
		name="Python "+name; 
		// add alerts to the APM Python Application
		alertsPage.addAlerts( name, metric, errorCode, aggregator, operator, thresholdValue, timePeriod, silencePeriod, recoveryPeriod, notificationChannel,
							eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath, IPathConstant.messageSheet, "AlertsAddedMessage"));
	}
	
	@Test(priority = -4,groups = {"Alerts", "Regression"})
	public void TC_05_pre_Request_For_Alerts_Configuration()
	{
		//navigate to the alerts capability
		commPage.navigateToAlerts();
				
		//navigate to config alerts tab
		alertsPage.NavigateToConfiguredAlertsTab();
				
		//select the capability
		alertsPage.selectCapabilityFromDropDown(IPathConstant.alertsAPMCapability);
		
		//select the application
		
		String application=System.getenv("APMGateWayApplication");
		alertsPage.selectApplicationfromDropdown(application);
		
		//alertsPage.selectApplicationfromDropdown("Alerts_gateway-go");
		
		alertsPage.deleteAlerts();
	}
	
	
	@Test(priority = -3,dataProvider = "getDataFromDataProvider",groups = {"Alerts", "Regression"})
	public void TC_06_configure_Alerts_For_Apm_Gateway_Go_Appication(String name,String metric,String aggregator,String operator,String thresholdValue,String timePeriod,String silencePeriod,String recoveryPeriod,String notificationChannel,String errorCode) throws EncryptedDocumentException, IOException
	{	
		name="GatewayGo "+name; 
		// add alerts to the APM gateway(GO) Application
		alertsPage.addAlerts( name, metric, errorCode, aggregator, operator, thresholdValue, timePeriod, silencePeriod, recoveryPeriod, notificationChannel,
									eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath, IPathConstant.messageSheet, "AlertsAddedMessage"));

		
	}
	
	@Test(priority = -2,groups = {"Alerts", "Regression"})
	public void TC_07_pre_Request_For_Alerts_Configuration()
	{
		//navigate to the alerts capability
		commPage.navigateToAlerts();
				
		//navigate to config alerts tab
		alertsPage.NavigateToConfiguredAlertsTab();
				
		//select the capability
		alertsPage.selectCapabilityFromDropDown(IPathConstant.alertsAPMCapability);
		
		//select the application
		
		String application=System.getenv("APMPhpApplication");
		alertsPage.selectApplicationfromDropdown(application);
		
		//alertsPage.selectApplicationfromDropdown("Alerts_php-centos");
		
		alertsPage.deleteAlerts();
	}
	
	@Test(priority = -1,dataProvider = "getDataFromDataProvider",groups = {"Alerts", "Regression"})
	public void TC_08_configure_Alerts_For_Apm_Php_Appication(String name,String metric,String aggregator,String operator,String thresholdValue,String timePeriod,String silencePeriod,String recoveryPeriod,String notificationChannel,String errorCode) throws EncryptedDocumentException, IOException
	{	
		name="PHP "+name; 
		// add alerts to the APM PHP Application
		alertsPage.addAlerts( name, metric, errorCode, aggregator, operator, thresholdValue, timePeriod, silencePeriod, recoveryPeriod, notificationChannel,
									eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath, IPathConstant.messageSheet, "AlertsAddedMessage"));

		
	}
	
	
	@DataProvider
	public Object[][] getDataFromDataProvider() throws EncryptedDocumentException, IOException
	{
		return eutil.fetchAllTheDataFromExcelSheet(IPathConstant.alertsExcelPath,IPathConstant.alertsPythonGatePhpSheet);
	}

}





