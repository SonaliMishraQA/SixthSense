package DBMCapability.Couchbase;

import java.io.IOException;
import java.math.RoundingMode;
import java.text.DecimalFormat;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microsoft.playwright.APIRequest;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.RequestOptions;

import genericUtilities.ExcelUtility;
import genericUtilities.IPathConstant;
import objectRepository.CommonPage;
import objectRepository.DBM.CouchbaseClusterOverviewPage;
import objectRepository.DBM.DBMCouchbaseNodePage;
import objectRepository.DBM.DBMCouchbaseQueriesPage;
import playWrightFactory.BaseClass;

public class DBMCouchbaseDataValidationTest extends BaseClass{
	
	CommonPage commonPage;
	DBMCouchbaseQueriesPage queriesPage;
	CouchbaseClusterOverviewPage clusterPage;
	DBMCouchbaseNodePage nodePage;
	ExcelUtility excel = new ExcelUtility();
	
	  @BeforeMethod
	    public void preRequest() throws EncryptedDocumentException, IOException 
	    {
	    	commonPage = new CommonPage(page);
	    	clusterPage = new CouchbaseClusterOverviewPage(page);
	    	nodePage = new DBMCouchbaseNodePage(page);
	    	queriesPage = new DBMCouchbaseQueriesPage(page);
	    	excel = new ExcelUtility();
	    	
	    	commonPage.navigateToDBM();
	    	clusterPage.navigateToCouchbase();
	    	clusterPage.selectClusterFromDropdown();
	    	commonPage.selectTheTimeLineFromCalender(IPathConstant.fiveMinutesTimeRange);
	    }

	  public JsonNode getResponse(String url) throws IOException
		{
		  Playwright playWright1 = Playwright.create();
			APIRequest request = playWright1.request();
			APIRequestContext requestContext = request.newContext();
			ObjectMapper objMap = new ObjectMapper();
			
			//set header details and payload						
			APIResponse response = requestContext.get(url, 
					RequestOptions.create()
					.setHeader("content-type", "application/json")
					.setHeader("Username", "admin")
					.setHeader("Password", "password")
					.setHeader("Authorization", "Basic YWRtaW46cGFzc3dvcmQ="));
			//print the response status code
			System.out.println("Status code : "+response.status());
			Assert.assertEquals(response.status(), 200);
			JsonNode respBody = objMap.readTree(response.body());
//			System.out.println("----------------------"+respBody.path("bucketNames").get(0).path("bucketName").asText());
//			System.out.println("----------------------"+respBody.path("bucketNames").size());
			
			return respBody;
		}
	  
	  @Test
	  public void TC_01_validate_The_CouchBase_Option_Is_Present_In_Database_Dropdown() throws EncryptedDocumentException, IOException
	  {
		  clusterPage.validateTheCouchBaseOptionInDataBaseDropDown();
	  }
	  
	  @Test
	  public void TC_02_validate_The_Registered_Cluster_From_Select_Cluster_Dropdown() throws EncryptedDocumentException, IOException
	  {
		  clusterPage.validateSelectClusterDropdown(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.couchBaseSheet,"SelectCluster"));
	  }
	  
	
	  @Test
	  public void TC_03_Validate_Overview_Node_Query_Bucket_Tabs_Are_Displaying_Or_Not()
	  {
		  clusterPage.validateTheTheCouchBasePageTabs();
	  }
	  
	  @Test
	  public void TC_04_Validate_ClusterOverView_Page_Widgets()
	  {
		  clusterPage.validateTheOverviewPageWidgets();
	  }
	  
	  
	  
	  @Test 
	  public void TC_05_validate_The_Cluster_Name_On_Cluster_OverView_Page() throws EncryptedDocumentException, IOException
	  {
		  clusterPage.navigateToClusterOverviewTab();
		  String expectedName =String.valueOf(getResponse("http://localhost:8091/pools/default").get("clusterName")).replace('"', ' ').trim();
		  clusterPage.validateClusterNameValue(expectedName);
	  }
	  

	  
	  @Test 
	  public void TC_06_validate_The_Couchbase_Version_On_Cluster_OverView_Page() throws EncryptedDocumentException, IOException
	  {
		  clusterPage.navigateToClusterOverviewTab();	
		  String expectedCouchbaseVersion = String.valueOf(getResponse("http://localhost:8093/admin/vitals").get("version")).replace('"', ' ').trim();
		  clusterPage.validateCouchbaseVersionValue(expectedCouchbaseVersion);
	  }
	  

	  
	  @Test 
	  public void TC_07_validate_The_Status_On_Cluster_OverView_Page() throws EncryptedDocumentException, IOException
	  {
		  clusterPage.navigateToClusterOverviewTab();
		  String expectedStatus = String.valueOf(getResponse("http://localhost:8091/pools/default").path("nodes").get(0).path("clusterMembership")).replace('"', ' ').trim();
		  clusterPage.validateStatusCardValue(expectedStatus);
	  }
	  
	  
	  @Test 
	  public void TC_08_validate_The_Status_Colour_On_Cluster_OverView_Page() throws EncryptedDocumentException, IOException
	  {
		  clusterPage.navigateToClusterOverviewTab();
		  
		  clusterPage.validateStatusValueColour();
	  }
	  
	  @Test 
	  public void TC_09_validate_The_Number_Of_Nodes_On_Cluster_OverView_Page() throws EncryptedDocumentException, IOException
	  {
		  clusterPage.navigateToClusterOverviewTab();
		  int expectednodes = getResponse("http://localhost:8091/pools/default").path("nodes").size();
		  System.out.println(expectednodes);
		  clusterPage.validateNumberOfNodesValue(String.valueOf(expectednodes));
	  }
	  
	  
	  @Test 
	  public void TC_10_validate_The_Number_Of_Buckets_On_Cluster_OverView_Page() throws EncryptedDocumentException, IOException
	  {
		  clusterPage.navigateToClusterOverviewTab();
		  int expectedBuckets = getResponse("http://localhost:8091/pools/default").path("bucketNames").size();
		  System.out.println(expectedBuckets);
		  clusterPage.validateNumberOfBucketsValue(String.valueOf(expectedBuckets));
	  }
	  
	  
	  @Test 
	  public void TC_11_validate_The_Cluster_CPU_Usage_Widget_Value_On_Cluster_OverView_Page() throws IOException
	  {
		  clusterPage.navigateToClusterOverviewTab();
		  
		  String expectedClusterCpuUsage =String.valueOf(getResponse("http://localhost:8093/admin/vitals").path("cpu.sys.percent"));
		  
		  clusterPage.validateTheClusterCpuWidgetValue(expectedClusterCpuUsage);  

	  }
	  
	  @Test 
	  public void TC_12_validate_The_Cluster_RAM_Usage_Widget_Value_On_Cluster_OverView_Page() throws IOException
	  {
		  String expectedClusterRAMUsage =String.valueOf(getResponse("http://localhost:8091/pools/default").path("storageTotals").path("ram").path("used"));
		  System.out.println("expectedClusterRAMUsage :"+expectedClusterRAMUsage);
		  
		  clusterPage.navigateToClusterOverviewTab();
		  page.waitForTimeout(55000);

		  clusterPage.validateTheClusterRamUsageWidgetValue(expectedClusterRAMUsage);
		  
	  }
	  
	  @Test 
	  public void TC_13_validate_The_Disk_Usage_Used_color_On_Cluster_OverView_Page() throws EncryptedDocumentException, IOException
	  {
		  clusterPage.navigateToClusterOverviewTab();
		  String expectedColor = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.couchBaseSheet, "DiskUsedColor");
		  clusterPage.validateTheDiskUsageColor(expectedColor);
	  }
	  
	  @Test 
	  public void TC_14_validate_The_Disk_Usage_Available_color_On_Cluster_OverView_Page() throws EncryptedDocumentException, IOException
	  {
		  clusterPage.navigateToClusterOverviewTab();
		  String expectedColor = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.couchBaseSheet, "DiskAvailable");
		  clusterPage.validateTheDiskAvailableColor(expectedColor);
	  }
	  
	  @Test 
	  public void TC_15_validate_The_Disk_Usage_card_Values_List_On_Cluster_OverView_Page() throws IOException
	  {
		  clusterPage.navigateToClusterOverviewTab();
		  int expectedValues = getResponse("http://localhost:8091/pools/default").path("nodes").size();
		  clusterPage.validateTheDiskCarsValuesList(expectedValues);
	  }
	  
	  @Test 
	  public void TC_16_validate_The_Disk_Usage_card_legends_On_Cluster_OverView_Page() throws EncryptedDocumentException, IOException
	  {
		  clusterPage.navigateToClusterOverviewTab();
		  String expectedText = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.couchBaseSheet, "DiskUsageCardText");
		  clusterPage.validateDiskUsageCardText(expectedText);
	  }
	  
	  @Test 
	  public void TC_17_validate_The_Disk_Usage_card_Memory_Used_Reflection_On_Cluster_OverView_Page() throws IOException
	  {
		  clusterPage.navigateToClusterOverviewTab();
		  String expectedDiskUsage =String.valueOf(getResponse("http://localhost:8091/pools/default").path("storageTotals").path("hdd").path("used"));
		  System.out.println("expectedDiskUsage :"+expectedDiskUsage);
		  
		  String expectedTotalMemory =String.valueOf(getResponse("http://localhost:8091/pools/default").path("storageTotals").path("hdd").path("total"));
		  System.out.println("expectedTotalMemory :"+expectedTotalMemory);
		  
		  clusterPage.validateTheDiskUsageUsedMemory(expectedDiskUsage, expectedTotalMemory);
	  }
	  
	  @Test 
	  public void TC_18_validate_The_Disk_Usage_card_Memory_Available_Reflection_On_Cluster_OverView_Page() throws IOException
	  {
		  clusterPage.navigateToClusterOverviewTab();
		  String expectedDiskUsage =String.valueOf(getResponse("http://localhost:8091/pools/default").path("storageTotals").path("hdd").path("used"));
		  System.out.println("expectedDiskUsage :"+expectedDiskUsage);
		  

		  String expectedTotalMemory =String.valueOf(getResponse("http://localhost:8091/pools/default").path("storageTotals").path("hdd").path("total"));
		  System.out.println("expectedTotalMemory :"+expectedTotalMemory);
		  
		  clusterPage.validateDiskUsageAvailableMemory(expectedDiskUsage,expectedTotalMemory);
		  
		  
	  }
	  
	  @Test 
	  public void TC_19_validate_The_Disk_Usage_card_Total_Memory_Reflection_On_Cluster_OverView_Page() throws IOException
	  {
		  clusterPage.navigateToClusterOverviewTab();
		  
		  String expectedTotalMemory =String.valueOf(getResponse("http://localhost:8091/pools/default").path("storageTotals").path("hdd").path("total"));
		  System.out.println("expectedTotalMemory :"+expectedTotalMemory);
		  
		  clusterPage.validateTheDiskUsageTotalMemory(expectedTotalMemory);
		  
	  }
	  
	  
	  @Test
	  public void TC_20_validate_The_Node_Page_Widgets_By_Clicking_On_Node_Tab()
	  {
		  nodePage.navigateToNodeTab();
		  
		  nodePage.validateNodePageWidgets();
	  }
	  
	  @Test
	  public void TC_21_validate_The_Nodes_From_Node_Dropdown_for_Particular_Cluster() throws EncryptedDocumentException, IOException
	  {
		  nodePage.navigateToNodeTab();
		  nodePage.validateNodesFromDropdown();
		  
	  }
	  
	  @Test 
	  public void TC_22_validate_The_Node_name_On_Node_Page_By_Selecting_particular_Node() throws EncryptedDocumentException, IOException
	  {
		  nodePage.navigateToNodeTab();
		  nodePage.selectNodeFromDropDown();
		  String expectedNode = String.valueOf(getResponse("http://localhost:8091/pools/default").path("nodes").get(0).path("otpNode"));
		  nodePage.validateNodeNameValue(expectedNode);
		 
	  }

	  @Test 
	  public void TC_23_validate_The_Node_Version_On_Node_Page() throws IOException
	  {
		  nodePage.navigateToNodeTab();
		  nodePage.selectNodeFromDropDown();
		  String expectedNodeVersion = String.valueOf(getResponse("http://localhost:8091/pools/default").path("nodes").get(0).path("version")).replace('"', ' ').trim();
		  nodePage.validateNodeVersionValue(expectedNodeVersion);
	  }
	  

	  @Test 
	  public void TC_24_validate_The_Node_Status_On_Node_Page() throws IOException
	  {
		  nodePage.navigateToNodeTab();
		  nodePage.selectNodeFromDropDown();
		  String expectedNodeStatus = String.valueOf(getResponse("http://localhost:8091/pools/default").path("nodes").get(0).path("status")).replace('"', ' ').trim();
		  nodePage.validateNodeStatusValue(expectedNodeStatus);
	  }
	  
	  @Test 
	  public void TC_25_validate_The_Node_Os_On_Node_Page() throws IOException
	  {
		  nodePage.navigateToNodeTab();
		  nodePage.selectNodeFromDropDown();
		  String expectedNodeOS = String.valueOf(getResponse("http://localhost:8091/pools/default").path("nodes").get(0).path("os")).replace('"', ' ').trim();
		  nodePage.validateNodeOsValue(expectedNodeOS);
	  }
	  
	  
	  @Test 
	  public void TC_26_validate_The_Node_Uptime_On_Node_Page() throws IOException
	  {
		  nodePage.navigateToNodeTab();
		  nodePage.selectNodeFromDropDown();
		  String expectedNodeUpTime = String.valueOf(getResponse("http://localhost:8091/pools/default").path("nodes").get(0).path("uptime")).replace('"', ' ').trim();
		  System.out.println("expectedNodeUpTime :" +expectedNodeUpTime);
		  
		  nodePage.validateTheUpTimeOnNodePage(expectedNodeUpTime);
		
	  }
	  
	  
	  @Test 
	  public void TC_27_validate_The_Disk_Usage_Used_Memory_color_On_Node_Page() throws EncryptedDocumentException, IOException
	  {
		  nodePage.navigateToNodeTab();
		  String expectedColor = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.couchBaseSheet, "DiskUsedColor");
		  clusterPage.validateTheDiskUsageColor(expectedColor);
	  }
	  
	  @Test 
	  public void TC_27_validate_The_Disk_Usage_Available_Memory_color_On_Node_Page() throws EncryptedDocumentException, IOException
	  {
		  nodePage.navigateToNodeTab();
		  String expectedColor = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.couchBaseSheet, "DiskAvailable");
		  clusterPage.validateTheDiskAvailableColor(expectedColor);
	  }
	  
	  
	  @Test 
	  public void TC_30_validate_The_Disk_Usage_card_legends_On_Node_Page() throws EncryptedDocumentException, IOException
	  {
		  nodePage.navigateToNodeTab();
		  String expectedText = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.couchBaseSheet, "DiskUsageCardText");
		  clusterPage.validateDiskUsageCardText(expectedText);
	  }
	  
	  @Test 
	  public void TC_31_validate_The_Disk_Usage_card_Memory_Used_Reflection_On_Node_Page()
	  {
		  nodePage.navigateToNodeTab();
	  }
	  
	  @Test 
	  public void TC_32_validate_The_Disk_Usage_card_Memory_Available_Reflection_On_Node_Page()
	  {
		  nodePage.navigateToNodeTab();
	  }
	  
	  @Test 
	  public void TC_33_validate_The_Disk_Usage_card__Total_Memory_Reflection_On_Node_Page()
	  {
		  nodePage.navigateToNodeTab();
	  }
	  
	  @Test 
	  public void TC_34_validate_The_Node_CPU_Usage_Widget_Value_On_Node_Page()
	  {
		  nodePage.navigateToNodeTab();
	  }
	  
	  @Test 
	  public void TC_35_validate_The_Node_RAM_Usage_Widget_Value_On_Node_Page()
	  {
		  nodePage.navigateToNodeTab();
	  }
	  
	  @Test 
	  public void TC_36_validate_The_Swap_Memory_Widget_Value_On_Node_Page()
	  {
		  nodePage.navigateToNodeTab();
	  }
	  
	  @Test 
	  public void TC_37_validate_The_Node_Operations_Widget_Value_On_Node_Page()
	  {
		  nodePage.navigateToNodeTab();
	  }
	  
	  @Test 
	  public void TC_38_validate_The_Current_Items_Widget_Value_On_Node_Page()
	  {
		  nodePage.navigateToNodeTab();
	  }
	  
	  @Test 
	  public void TC_39_validate_The_Node_Replica_Widget_Value_On_Node_Page()
	  {
		  nodePage.navigateToNodeTab();
	  }
	  
	  @Test 
	  public void TC_40_validate_The_Docs_Data_Size_Widget_Value_On_Node_Page()
	  {
		  nodePage.navigateToNodeTab();
	  }
	  
	  @Test 
	  public void TC_41_validate_The_MCD_memory_Widget_Value_On_Node_Page()
	  {
		  nodePage.navigateToNodeTab();
	  }
	  
	  
	  
	  
	  
	  
	  @Test
	  public void TC_42_validate_Queries_Page_Widgets_By_Click_On_Queries_Tab()
	  {
		  queriesPage.navigateToQueriesPage();
		  
		  queriesPage.validateQueriesPageWidgets();
	  }
	  
	  @Test
	  public void TC_43_validate_The_Requests_Widget_Value_On_Queries_Page()
	  {
		  
	  }
	  
	  @Test
	  public void TC_44_validate_The_Request_Time_Distribution_Widget_Value_On_Queries_Page()
	  {
		  
	  }
	  
	  @Test
	  public void TC_45_validate_The_Request_Thread_Count_Widget_Value_On_Queries_Page()
	  {
		  
	  }
	  
	  @Test
	  public void TC_46_validate_The_GC_Count_Widget_Value_On_Queries_Page()
	  {
		  
	  }
	  
	  @Test
	  public void TC_47_validate_The_Download_Report_Button_On_Queries_Page()
	  {
		  
	  }
	  
	  @Test
	  public void TC_48_validate_The_Functionality_Of_Query_Threshold_Dropdown()
	  {
		  
	  }
	  
	  @Test
	  public void TC_49_validate_The_Query_Names_On_Queries_Page()
	  {
		  
	  }
	  
	  @Test
	  public void TC_50_sort_Query_Names__In_Ascending_Order_On_Queries_Page()
	  {
		  
	  }
	  
	  @Test
	  public void TC_51_sort_Query_Names__In_Descending_Order_On_Queries_Page()
	  {
		  
	  }
	  
	  @Test
	  public void TC_52_validate_The_Total_Execution_On_Queries_Page()
	  {
		  
	  }
	  
	  @Test
	  public void TC_53_sort_Total_Execution__In_Ascending_Order_On_Queries_Page()
	  {
		  
	  }
	  
	  @Test
	  public void TC_54_sort_Total_Execution__In_Descending_Order_On_Queries_Page()
	  {
		  
	  }
	  
	  @Test
	  public void TC_55_validate_The_Execution_Time_On_Queries_Page()
	  {
		  
	  }
	  
	  @Test
	  public void TC_56_sort_Execution_Time__In_Ascending_Order_On_Queries_Page()
	  {
		  
	  }
	  
	  @Test
	  public void TC_57_sort_Execution_Time__In_Descending_Order_On_Queries_Page()
	  {
		  
	  }
	  
	  @Test
	  public void TC_58_validate_The_Time_Stamp_On_Queries_Page()
	  {
		  
	  }
	  
	  @Test
	  public void TC_59_sort_Time_Stamp__In_Ascending_Order_On_Queries_Page()
	  {
		  
	  }
	  
	  @Test
	  public void TC_60_sort_Time_Stamp__In_Descending_Order_On_Queries_Page()
	  {
		  
	  }
	  
	  @Test
	  public void TC_61_Validate_The_Buckets_List_From_The_Bucket_Dropdown()
	  {
		  
	  }
	  
	  @Test
	  public void TC_62_Validate_The_Buckets_List_From_The_Bucket_Dropdown_By_Selecting_Different_Node()
	  {
		  
	  }
	  
	  @Test
	  public void TC_63_Validate_The_widget_Info_Belongs_To_Same_Bucket_only()
	  {
		  
	  }
	  
	  
	  @Test
	  public void TC_64_validate_The_Bucket_Ops_Widget_Value_On_Bucket_Page()
	  {
		  
	  }
	  
	  @Test
	  public void TC_65_validate_The_Disk_Used_Widget_Value_On_Bucket_Page()
	  {
		  
	  }
	  
	  @Test
	  public void TC_66_validate_The_Mem_Used_Widget_Value_On_Bucket_Page()
	  {
		  
	  }
	  
	  @Test
	  public void TC_67_validate_The_Current_Items_Widget_Value_On_Bucket_Page()
	  {
		  
	  }
	  
	  
//	  @Test 
//	  public void TC_16_validate_The_Number_Of_Buckets_On_Cluster_OverView_Page_By_Adding_Buckets()
//	  {
//		  clusterPage.navigateToClusterOverviewTab();
//	  }
	  
//	  @Test 
//	  public void TC_14_validate_The_Number_Of_Nodes_On_Cluster_OverView_Page_By_Adding_Node()
//	  {
//		  clusterPage.navigateToClusterOverviewTab();
//	  }
	  
//	  @Test
//	  public void TC_10_Updated_Couchbase_Version__And_Validate_The_Updated_Version()
//	  {
//		  
//	  }
	  
//	  @Test
//	  public void TC_07_Update_Cluster_Name_And_Validate_The_Updated_Name()
//	  {
//		  
//	  }
	  
//	  @Test 
//	  public void TC_26_validate_The_Node_name_On_Node_Page_By_Changing_The_Node_Name()
//	  {
//		  nodePage.navigateToNodeTab();
//	  }
//	  @Test 
//	  public void TC_28_validate_The_Node_Version_On_Node_Page_By_Changing_The_Node_Version()
//	  {
//		  nodePage.navigateToNodeTab();
//	  }
	  
	  

}
