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

public class DeleteAlerts extends BaseClass {
	
	ExcelUtility eutil=new ExcelUtility();
	AlertsPage alertsPage;
	HomePage homePage;
	
	
	@BeforeMethod
	public void preRequest()
	{
		homePage=new HomePage(page);
		alertsPage=new AlertsPage(page);
		
		
		//navigate to the alerts capability
		commPage.navigateToAlerts();
		
		//navigate to config alerts tab
		alertsPage.NavigateToConfiguredAlertsTab();
		
	}

	
	@Test
	public void TC_01_deleteAlertsForApmEndpointAppication() throws EncryptedDocumentException, IOException
	{
		//select the capability
		alertsPage.selectCapabilityFromDropDown("APM");
				
		//select the application
		String application=System.getenv("APMEndpointApplication");
		alertsPage.selectApplicationfromDropdown(application);
		
		//alertsPage.selectApplicationfromDropdown("Alerts_endpoint_java");
		
		//delete the alerts
		alertsPage.deleteAlertsFromConfiguredAlertsPage(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath, IPathConstant.messageSheet, "AlertsDeletedMessage"));
	}
	
	@Test
	public void TC_02_deleteAlertsForApmInstanceAppication() throws EncryptedDocumentException, IOException
	{
		//select the capability
		alertsPage.selectCapabilityFromDropDown("APM");
				
		//select the application
		String application=System.getenv("APMInstanceApplication");
		alertsPage.selectApplicationfromDropdown(application);
		
		//alertsPage.selectApplicationfromDropdown("Alerts_instance_java");
		
		//delete the alerts
		alertsPage.deleteAlertsFromConfiguredAlertsPage(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath, IPathConstant.messageSheet, "AlertsDeletedMessage"));
	}
	

	@Test
	public void TC_03_deleteAlertsForApmPythonAppication() throws EncryptedDocumentException, IOException
	{
		//select the capability
		alertsPage.selectCapabilityFromDropDown("APM");
				
		//select the application
		String application=System.getenv("APMPythonApplication");
		alertsPage.selectApplicationfromDropdown(application);
		
		//alertsPage.selectApplicationfromDropdown("Alerts_Python");
		
		//delete the alerts
		alertsPage.deleteAlertsFromConfiguredAlertsPage(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath, IPathConstant.messageSheet, "AlertsDeletedMessage"));
	}
	
	@Test
	public void TC_04_deleteAlertsForApmGatewayGoAppication() throws EncryptedDocumentException, IOException
	{
		//select the capability
		alertsPage.selectCapabilityFromDropDown("APM");
				
		//select the application
		
		String application=System.getenv("APMGateWayApplication");
		alertsPage.selectApplicationfromDropdown(application);
		
		//alertsPage.selectApplicationfromDropdown("Alerts_gateway-go");
		
		//delete the alerts
		alertsPage.deleteAlertsFromConfiguredAlertsPage(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath, IPathConstant.messageSheet, "AlertsDeletedMessage"));
	}
	
	@Test
	public void TC_05_deleteAlertsForApmPhpAppication() throws EncryptedDocumentException, IOException
	{
		
		//select the capability
		alertsPage.selectCapabilityFromDropDown("APM");
				
		//select the application
		String application=System.getenv("APMPhpApplication");
		alertsPage.selectApplicationfromDropdown(application);
		
		//alertsPage.selectApplicationfromDropdown("Alerts_php-centos");
		
		//delete the alerts
		alertsPage.deleteAlertsFromConfiguredAlertsPage(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath, IPathConstant.messageSheet, "AlertsDeletedMessage"));
	}

	
	@Test
	public void TC_06_deleteAlertsForApmJavaAppication() throws EncryptedDocumentException, IOException
	{
		//select the capability
		alertsPage.selectCapabilityFromDropDown("APM");
				
		//select the application
		
		String application=System.getenv("APMJavaApplication");
		alertsPage.selectApplicationfromDropdown(application);
		
		//alertsPage.selectApplicationfromDropdown("Alerts_java");
		
		//delete the alerts
		alertsPage.deleteAlertsFromConfiguredAlertsPage(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath, IPathConstant.messageSheet, "AlertsDeletedMessage"));
	}
	
	@Test
	public void TC_07_deleteAlertsForApmNodeAppication() throws EncryptedDocumentException, IOException
	{
		//select the capability
		alertsPage.selectCapabilityFromDropDown("APM");
				
		//select the application
		
		String application=System.getenv("APMNodeApplication");
		alertsPage.selectApplicationfromDropdown(application);
		
		//alertsPage.selectApplicationfromDropdown("Alerts_Node");
		
		//delete the alerts
		alertsPage.deleteAlertsFromConfiguredAlertsPage(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath, IPathConstant.messageSheet, "AlertsDeletedMessage"));
	}
	
	@Test
	public void TC_08_deleteAlertsForApmDotNetAppication() throws EncryptedDocumentException, IOException
	{
		//select the capability
		alertsPage.selectCapabilityFromDropDown("APM");
				
		//select the application
		
		String application=System.getenv("APMDotNetApplication");
		alertsPage.selectApplicationfromDropdown(application);
		
		//alertsPage.selectApplicationfromDropdown("Alerts_Dotnet");
		
		//delete the alerts
		alertsPage.deleteAlertsFromConfiguredAlertsPage(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath, IPathConstant.messageSheet, "AlertsDeletedMessage"));
	}
	
	@Test
	public void TC_09_deleteAlertsForApmInsEndpointAppication() throws EncryptedDocumentException, IOException
	{
		//select the capability
		alertsPage.selectCapabilityFromDropDown("APM");
				
		//select the application
		
		String application=System.getenv("APMInstanceEndpointApplication");
		alertsPage.selectApplicationfromDropdown(application);
		
		//alertsPage.selectApplicationfromDropdown("Alerts_Ins_End_java");
		
		//delete the alerts
		alertsPage.deleteAlertsFromConfiguredAlertsPage(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath, IPathConstant.messageSheet, "AlertsDeletedMessage"));
	}
	
	//*****************************Browser Monitoring****************************
	
	@Test
	public void TC_10_deleteAlertsForBmAngularAppication() throws EncryptedDocumentException, IOException
	{
		//select the capability
		alertsPage.selectCapabilityFromDropDown("Browser monitoring");
				
		//select the application

		String application=System.getenv("BMAngularApplication");
		alertsPage.selectApplicationfromDropdown(application);
		
		//alertsPage.selectApplicationfromDropdown("Alets_Angular");
		
		//delete the alerts
		alertsPage.deleteAlertsFromConfiguredAlertsPage(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath, IPathConstant.messageSheet, "AlertsDeletedMessage"));
	}
	
	@Test
	public void TC_11_deleteAlertsForBmReactAppication() throws EncryptedDocumentException, IOException
	{
		//select the capability
		alertsPage.selectCapabilityFromDropDown("Browser monitoring");
				
		//select the application
		
		String application=System.getenv("BMReactApplication");
		alertsPage.selectApplicationfromDropdown(application);
		
		//alertsPage.selectApplicationfromDropdown("Alets_React");
		
		//delete the alerts
		alertsPage.deleteAlertsFromConfiguredAlertsPage(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath, IPathConstant.messageSheet, "AlertsDeletedMessage"));
	}
	
	//*****************************DBM**********************************
	
	@Test
	public void TC_12_deleteAlertsForDBMMysqlAppication() throws EncryptedDocumentException, IOException
	{
		//select the capability
		alertsPage.selectCapabilityFromDropDown("Database monitoring");
				
		//select the application
		String application=System.getenv("DBMMysqlApplication");
		alertsPage.selectApplicationfromDropdown(application);
		
		
		//alertsPage.selectApplicationfromDropdown("MySQL > Alerts_Mysql");
		
		//delete the alerts
		alertsPage.deleteAlertsFromConfiguredAlertsPage(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath, IPathConstant.messageSheet, "AlertsDeletedMessage"));
	}
	
	@Test
	public void TC_13_deleteAlertsForDbmMssqlAppication() throws EncryptedDocumentException, IOException
	{
		//select the capability
		alertsPage.selectCapabilityFromDropDown("Database monitoring");
				
		//select the application
		String application=System.getenv("DBMMssqlApplication");
		alertsPage.selectApplicationfromDropdown(application);
		
		
//		alertsPage.selectApplicationfromDropdown("MsSQL > mmssql-408-412-build2");
		
		//delete the alerts
		alertsPage.deleteAlertsFromConfiguredAlertsPage(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath, IPathConstant.messageSheet, "AlertsDeletedMessage"));
	}
	
	@Test
	public void TC_14_deleteAlertsForDbmOracleAppication() throws EncryptedDocumentException, IOException
	{
		//select the capability
		alertsPage.selectCapabilityFromDropDown("Database monitoring");
				
		//select the application
		String application=System.getenv("DBMOracleApplication");
		alertsPage.selectApplicationfromDropdown(application);
//		alertsPage.selectApplicationfromDropdown("Oracle > oracle_V4.1.3_Patch");
		
		//delete the alerts
		alertsPage.deleteAlertsFromConfiguredAlertsPage(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath, IPathConstant.messageSheet, "AlertsDeletedMessage"));
	}
	
	@Test
	public void TC_15_deleteAlertsForDbmPostgresAppication() throws EncryptedDocumentException, IOException
	{
		//select the capability
		alertsPage.selectCapabilityFromDropDown("Database monitoring");
				
		//select the application
		String application=System.getenv("DBMPostgresApplication");
		alertsPage.selectApplicationfromDropdown(application);
		
		//alertsPage.selectApplicationfromDropdown("Postgres > Alerts_Postgres");
		
		//delete the alerts
		alertsPage.deleteAlertsFromConfiguredAlertsPage(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath, IPathConstant.messageSheet, "AlertsDeletedMessage"));
	}
	
	//*****************************Mobile Monitoring****************************
	
	@Test
	public void TC_16_deleteAlertsForMMAndroidAppication() throws EncryptedDocumentException, IOException
	{
		//select the capability
		alertsPage.selectCapabilityFromDropDown("Mobile monitoring");
				
		//select the application
		String application=System.getenv("MMAndroidApplication");
		alertsPage.selectApplicationfromDropdown(application);
		
		//alertsPage.selectApplicationfromDropdown("Alerts_Android");
		
		//delete the alerts
		alertsPage.deleteAlertsFromConfiguredAlertsPage(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath, IPathConstant.messageSheet, "AlertsDeletedMessage"));
	}
	
	@Test
	public void TC_17_deleteAlertsForMMIosAppication() throws EncryptedDocumentException, IOException
	{
		//select the capability
		alertsPage.selectCapabilityFromDropDown("Mobile monitoring");
				
		//select the application
		String application=System.getenv("MMIosApplication");
		alertsPage.selectApplicationfromDropdown(application);
		
	//	alertsPage.selectApplicationfromDropdown("Alerts_IOS");
		
		//delete the alerts
		alertsPage.deleteAlertsFromConfiguredAlertsPage(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath, IPathConstant.messageSheet, "AlertsDeletedMessage"));
	}
	
	//*****************************Synthetic Monitoring****************************
	
	@Test
	public void TC_18_deleteAlertsForSmEndpointAppication() throws EncryptedDocumentException, IOException
	{
		//select the capability
		alertsPage.selectCapabilityFromDropDown("Synthetic monitoring");
				
		//select the application
		String application=System.getenv("SMEndpointApplication");
		alertsPage.selectApplicationfromDropdown(application);
		
		//alertsPage.selectApplicationfromDropdown("Group > Automation");
		
		//delete the alerts
		alertsPage.deleteAlertsFromConfiguredAlertsPage(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath, IPathConstant.messageSheet, "AlertsDeletedMessage"));
	}
	
	//*****************************VM Monitoring****************************
	
	@Test
	public void TC_19_deleteAlertsForVmLunixAppication() throws EncryptedDocumentException, IOException
	{
		//select the capability
		alertsPage.selectCapabilityFromDropDown("VM monitoring");
				
		//select the application
		
		String application=System.getenv("VMApplication");
		alertsPage.selectApplicationfromDropdown(application);
		
	//	alertsPage.selectApplicationfromDropdown("Alerts_LinuxVM");
		
		//delete the alerts
		alertsPage.deleteAlertsFromConfiguredAlertsPage(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath, IPathConstant.messageSheet, "AlertsDeletedMessage"));
	}
	

}





