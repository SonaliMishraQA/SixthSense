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

public class Alerts_SM_EndpointTest extends BaseClass {
	
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
	@Test(priority = -4,groups = {"Alerts", "Regression"})
	public void TC_01_pre_Request_For_Alerts_Configuration()
	{
		//navigate to the alerts capability
		commPage.navigateToAlerts();
				
		//navigate to configure alerts tab
		alertsPage.NavigateToConfiguredAlertsTab();
				
		//select the capability
		alertsPage.selectCapabilityFromDropDown(IPathConstant.alertsSMCapability);
				
		//select the application
		
		String application=System.getenv("SMEndpointApplication");
		alertsPage.selectApplicationfromDropdown(application);
		
		//alertsPage.selectApplicationfromDropdown("Group > Automation");
		
		alertsPage.deleteAlerts();
				
	}
	
	
	@Test(priority = -3,dataProvider = "getDataFromDataProvider",groups = {"Alerts", "Regression"})
	public void TC_02_configure_Alerts_For_Sm_Endpoint_Appication(String name,String metric,String aggregator,String operator,String thresholdValue,String timePeriod,String silencePeriod,String recoveryPeriod,String notificationChannel) throws EncryptedDocumentException, IOException
	{	
		String alertName="SM "+name; 
		// add alerts to the SM Endpoint Application
		alertsPage.addAlerts( alertName, metric, aggregator, operator, thresholdValue, timePeriod, silencePeriod, recoveryPeriod, notificationChannel,
							eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath, IPathConstant.messageSheet, "AlertsAddedMessage"));
	}
	
	
	@DataProvider
	public Object[][] getDataFromDataProvider() throws EncryptedDocumentException, IOException
	{
		return eutil.fetchAllTheDataFromExcelSheet(IPathConstant.alertsExcelPath,IPathConstant.alertsSmSheet);
	}

}





