package DBMCapability.OracleDB;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import genericUtilities.ExcelUtility;
import genericUtilities.GenericMethods;
import genericUtilities.IPathConstant;
import objectRepository.CommonPage;
import objectRepository.DBM.DBMOracleConnectionPage;
import objectRepository.DBM.DBMOracleHardwarePage;
import objectRepository.DBM.DBMOracleMetricsPage;
import objectRepository.DBM.OracleQueryperformance;
import playWrightFactory.BaseClass;

public class OracleDataValidationTest extends BaseClass{
	ExcelUtility excel = new ExcelUtility();
	GenericMethods util = new GenericMethods();
	CommonPage common;
	DBMOracleHardwarePage hardware;
	DBMOracleConnectionPage connect;
	OracleQueryperformance query;
	DBMOracleMetricsPage metrics;
	
	@BeforeMethod
	public void bmConfig() throws EncryptedDocumentException, IOException {
		common = new CommonPage(page);
		hardware = new DBMOracleHardwarePage(page);
		metrics = new DBMOracleMetricsPage(page);
		connect = new DBMOracleConnectionPage(page);
		common.navigateToDBM();
		hardware.selectDatabase(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.TypesOfDBs, "Oracle_DB"));
		hardware.selectService(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.oracleSheet, "serviceName"));
	}
	
	@Test
	public void TC01_validate_The_Type_Of_OS() throws EncryptedDocumentException, IOException, SQLException {
		hardware.validateTheTypeOfOsInCard();
	}
	
	@Test
	public void TC02_validate_The_Architecture() throws EncryptedDocumentException, IOException, SQLException {
		hardware.validateTheArchitecture();
	}
	
	@Test
	public void TC03_validate_The_Host_Name() throws EncryptedDocumentException, IOException, SQLException {
		hardware.validateTheHostName();
	}
	
	@Test
	public void TC04_validate_CPU_Usage_Percentage_Value_In_Card() throws EncryptedDocumentException, IOException, SQLException {
		hardware.validateCpuUsagePercentageValueInCard();
	}
	
	@Test
	public void TC05_validate_The_Average_Memory_Usage_In_Card() throws EncryptedDocumentException, IOException, SQLException {
		hardware.validateTheAverageMemoryUsageInCard() ;
	}
	
	@Test
	public void TC06_validate_CPU_Usage_Percentage_Value_In_Graph() throws EncryptedDocumentException, IOException, SQLException {
		hardware.validateCpuUsagePercentageValueInGraph();
	}
	
	@Test
	public void TC07_validate_The_Average_Memory_Usage_In_Graph() throws EncryptedDocumentException, IOException, SQLException {
		hardware.validateTheAverageMemoryUsageInGraph() ;
	}
	
	@Test
	public void TC08_validate_Network_IO_Disk_Usage_Value_In_Graph() throws EncryptedDocumentException, IOException, SQLException {
		hardware.validateNetworkIoDiskUsageValueInGraph();
	}
	
	@Test
	public void TC09_validate_Network_IO_Disk_Request_Value_In_Graph() throws EncryptedDocumentException, IOException, SQLException {
		hardware.validateNetworkIoDiskRequestValueInGraph();
	}
	
	@Test
	public void TC10_Validate_The_Number_Of_Active_Connections_In_Connections_Page() throws EncryptedDocumentException, IOException, SQLException {
		connect.validateTheNumberOfActiveConnectionsInConnectionsPage();
	}
	
	@Test
	public void TC11_Validate_The_Number_Of_Inactive_Connections_In_Connections_Page() throws EncryptedDocumentException, IOException, SQLException {
		connect.validateTheNumberOfInactiveConnectionsInConnectionsPage();
	}
	
	@Test
	public void TC12_Validate_The_Number_Of_Active_Sessions_In_Connections_Page() throws EncryptedDocumentException, IOException, SQLException {
		connect.validateTheNumberOfActiveSessionsInConnectionsPage();
	}
	
	@Test
	public void TC13_Validate_The_Number_Of_Abandoned_Sessions_In_Connections_Page() throws EncryptedDocumentException, IOException, SQLException {
		connect.validateTheNumberOfAbandonedSessionsInConnectionsPage();
	}
	
	@Test
	public void TC14_Validate_Host_CPU_Utilization_Percentage_Value_In_Metrics_Page() throws EncryptedDocumentException, IOException, SQLException {
		metrics.validateHostCpuUtilizationValueInMetricsPage();
	}
	
	@Test
	public void TC15_Validate_Disk_Read_Per_Second_Value_In_Metrics_Page() throws EncryptedDocumentException, IOException, SQLException {
		metrics.validateDiskReadPerSecondValueInMetricsPage();
	}
	
	@Test
	public void TC16_Validate_Disk_Write_Per_Second_Value_In_Metrics_Page() throws EncryptedDocumentException, IOException, SQLException {
		metrics.validateDiskWritePerSecondValueInMetricsPage();
	}
	
	@Test
	public void TC17_validate_User_Transaction_Value_In_Metrics_Page() throws EncryptedDocumentException, IOException, SQLException {
		metrics.validateUserTransactionValueInMetricsPage();
	}
	
	@AfterMethod
	public void amConfig() {
		hardware.closeDbConnection();
	}
}
