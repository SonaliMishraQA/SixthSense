package objectRepository.DBM;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import genericUtilities.GenericMethods;
import objectRepository.CommonPage;




public class MysqlQueryPerformancePage {

    Page page;
    GenericMethods util=new GenericMethods();
    CommonPage comPage = new CommonPage(page);
    
    
    private String dataBasePageTitle = "#title-text-database";
    private String dataBaseTypeDropDown = "#btn-arrow-down-search-select-database-type";
    private String dataBaseTypeTextField = "#input-search-sel-search-select-database-type";
    private String firstDbTypeFromDropDown = "xpath = //span[@id='search-select-database-type-0-single']";
    private String selectedDbType = "xpath =//*[@id='search-select-database-type']/div";
    private String serviceDropDown = "#btn-arrow-down-search-select-database-service";
    private String serviceTextField = "#input-search-sel-search-select-database-service";
    private String firstServiceFromDropDown = "xpath = //span[@id='search-select-database-service-0-single']";
    private String selectedDbService = "xpath = //*[@id='search-select-database-service']/div";
    private String dataBaseDropDown = "#btn-arrow-down-search-select-database-instance";
    private String dataBaseTextField = "#input-search-sel-search-select-database-instance";
    private String databseInOption = "xpath = //*[@id='search-select-database-instance-0-single']";
    private String selecteddatabase = "xpath = //div[@id='search-select-database-service']/div";
    private String firstDbFromDropDown = "xpath = //span[@id='search-select-database-instance-0-single']";
    
    									// Query Performance Tab //
    
    private String queryPerformanceTab = "xpath = //div[@class='item']/child::div[contains(@class,'router') and contains(text(),'Query')]";   
    private String queryThresholdTitle = "xpath = //div[@class='heading' and contains(text(),'Query threshold')]";
    private String selectedQueryThreshold = "xpath = //div[@class='selected-item-text']";
    private String queryThresholdDropdownBtn = "#btn-arrow-down-query-threshold-select";
    private String queryThresholdList = "xpath = //div[@class='query-threshold-action']/descendant::div[@class='option']/descendant::span[@class='selected-item-text']";
    private String defaultQueryThreshold = "xpath = //div[@class='selected-item-text']";
    private String downloadReportBtn = "#rex-pdf-download";
    private String confirmationMsg = "xpath = //div[@class='ant-notification-notice-with-icon']";
    private String queryColumnTitle = "xpath = //table[@class='table-container']//div[@class='header-slot-default' and text()='Query']";
    private String totalExeTimeColumnTitle = "xpath = //table[@class='table-container']//div[@class='header-slot-default' and text()='Average execution time']";
    private String timestampColumnTitle = "xpath = //table[@class='table-container']//div[@class='header-slot-default' and text()='Timestamp']";
    private String executionTimeColumnTitle = "xpath = //table[@class='table-container']//div[@class='header-slot-default' and text()='Execution time(s)']"; 
    private String queryColumnData = "xpath = //tr[@class='body-tr body-tr-secondary']/td[1]";
    private String avgExeTimeColumnData = "xpath = //tr[@class='body-tr body-tr-secondary']/td[2]";
    private String timestampColumnData = "xpath = //tr[@class='body-tr body-tr-secondary']/td[3]";
    private String paginationDropdown = "xpath = //div[@class='ant-select-selector']";
    private String selectedPagination = "xpath = //span[@class='ant-select-selection-item']";
    private String gotoPreviousPageBtn = "xpath = //button[@aria-label='Go to previous page']";
    private String gotoNextPageBtn = "xpath = //button[@aria-label='Go to next page']";
    private String tableNodataValue ="xpath = //div[@class='inner-text']";
    private String thresholdDropdown ="xpath =//button[@id='btn-arrow-down-query-threshold-select']";
    private String elementList ="xpath =//table/descendant::tr[@class='body-tr body-tr-secondary']/descendant::td[position()=1";
    private String selectNodeDropDown = "xpath =//div[@class='dashboardTop']/descendant::div[@id='search-select-database-instance']";
    private String selectNodeTextField="id =input-search-sel-search-select-database-instance";
    private String searchNodeTextField = "#input-search-sel-search-select-database-instance";
    private String searchedNode ="#search-select-database-instance-0-single";

  public MysqlQueryPerformancePage(Page page)
  {
      this.page= page;
  }

//validating the page title
public void validateDBMPagetitle(String expectedTitle )
	{
		//String actualTitle = page.locator(dataBasePageTitle).textContent().trim();
        
		util.ValidateTheTitle(page, dataBasePageTitle, expectedTitle);
	}
//selecting the DBM type
public void selectDBMtype(String DBMtype ) {
	util.selectTheOptionFromDropDownBySearch(page, dataBaseTypeDropDown, dataBaseTypeTextField, DBMtype, firstDbTypeFromDropDown);
	
}
//validating the selected DBM type
public void validatingtheselectedDBMtype(String expectedDBMtype) {
	String actualDBMtype = page.locator(selectedDbType).textContent().trim();
	Assert.assertEquals(actualDBMtype, expectedDBMtype);
}
//selecting the service
public void selectDbservice(String DBservice) {
	util.selectTheOptionFromDropDownBySearch(page, serviceDropDown, serviceTextField, DBservice, firstServiceFromDropDown);
}
public void validateSelectNodeDropDown(String node) {
    util.selectTheOptionFromDropDownBySearch(page, selectNodeDropDown, searchNodeTextField, node, searchedNode);
}
//validating the selected service
public void validateselectedDbservice(String expectedservice) {
	String actualDBMservice = page.locator(selectedDbService).textContent().trim();
	Assert.assertEquals(actualDBMservice, expectedservice);
}
//selecting the database
public void selectdatabse() {
	util.selectTheOptionFromDropDown(page, dataBaseDropDown, databseInOption);
}
//validating the selected database
public void validateselecteddatabse(String expecteddatabse) {
	String actualdatabse = page.locator(selecteddatabase).textContent().trim();
	Assert.assertEquals(actualdatabse, expecteddatabse);
}
public void validateQueryPerformanceTab() {
	page.waitForSelector(queryPerformanceTab);
 	Locator title= page.locator(queryPerformanceTab);
 	Assert.assertTrue(title.isVisible());
}
public void validateQueryPerformanceNavigation() {
	page.waitForSelector(queryPerformanceTab);
	page.locator(queryPerformanceTab).click();
	page.waitForSelector(queryThresholdTitle);
	Locator title = page.locator(queryThresholdTitle);
	Assert.assertTrue(title.isVisible());
}
public void validatingQueryThresholdTitle(String expectedTitle) {
    util.ValidateTheTitle(page.locator(queryThresholdTitle).textContent().trim(), expectedTitle);
}


public String getQueryThresholdDropdownBtn() {
    return queryThresholdDropdownBtn;
}
public void validateDownloadReportBtnPresence() {
    page.waitForSelector(downloadReportBtn);
    Locator button = page.locator(downloadReportBtn);
    Assert.assertTrue(button.isVisible());    
}

//validating if the Download report button is disabled when there is no data in query performance table
public void validateDownloadreportButtonDisabled() {
	page.waitForSelector(downloadReportBtn);
    Locator button = page.locator(downloadReportBtn);
    boolean isDisabled = (boolean) button.evaluate("element => element.disabled");
    Assert.assertTrue(button.isDisabled());
	
}
public void validateQueryColumnTitle(String expectedColumn) {
   String actualColumn = page.locator(queryColumnTitle).textContent().trim();
   Assert.assertEquals(actualColumn, expectedColumn);
		  
}
public void validateTotalExeTimeColumnTitle(String expectedColumn) {
	String actualColumn = page.locator(totalExeTimeColumnTitle).textContent().trim();
	Assert.assertEquals(actualColumn, expectedColumn);
}
public void validateTimestampColumnTitle(String expectedColumn) {
	String actualColumn = page.locator(timestampColumnTitle).textContent().trim();
    Assert.assertEquals(actualColumn, expectedColumn);
}
public void validateExecutionTimeColumnTitle(String expectedColumn) {
	String actualColumn = page.locator(executionTimeColumnTitle).textContent().trim();
    Assert.assertEquals(actualColumn, expectedColumn);
}
public void validateQueryColumnDataNodata(String expectedValue) {
   String actualValue = page.locator(tableNodataValue).textContent().trim() ;
   Assert.assertEquals(actualValue, expectedValue);
}
public void validateTotalExeTimeColumnNoData(String expectedValue) {
	String actualValue = page.locator(tableNodataValue).textContent().trim() ;
    Assert.assertEquals(actualValue, expectedValue);
}
public void validateTimestampColumnNoData(String expectedValue) {
	String actualValue = page.locator(tableNodataValue).textContent().trim() ;
    Assert.assertEquals(actualValue, expectedValue);
}
public void validateExecutionTimeColumnNoData(String expectedValue) {
	String actualValue = page.locator(tableNodataValue).textContent().trim() ;
    Assert.assertEquals(actualValue, expectedValue);
}
public void selectAndValidatePaginationOptions(String paginationOption) {
	util.selectTheOptionFromDropDown(page, queryThresholdDropdownBtn, paginationOption);
	String selectedPaginationValue = page.locator(selectedPagination).textContent().trim();
	Assert.assertEquals(selectedPaginationValue, paginationOption);
}
public void validateDefaultSelectedPagination(String expectedPagination) {
    String actualPagination = page.locator(selectedPagination).textContent().trim();
    Assert.assertEquals(actualPagination, expectedPagination);
}
/*public String getGotoPreviousPageBtn() {
    return gotoPreviousPageBtn;
}
public String getGotoNextPageBtn() {
    return gotoNextPageBtn;
}

public String getConfirmationMsg() {
    return confirmationMsg;
}*/

public void validateDefaultQueryThresholdValue(String expectedValue) {
	String defaultQueryThresholdValue = page.locator(defaultQueryThreshold).textContent().trim();
	Assert.assertEquals(defaultQueryThresholdValue, expectedValue);
	
}

public void selectAndvalidateQueryThresholdValue(String queryThresholdOption) {
	util.selectTheOptionFromDropDown(page, thresholdDropdown, queryThresholdOption);
	//String selectedQueryThresholdValue = page.locator(selectedQueryThreshold).textContent().trim();
	//Assert.assertEquals(selectedQueryThresholdValue, queryThresholdOption);
	
}
public void selectPaginationAndValidate(Integer num) {
    comPage.selectPaginationAndValidate(page, num, elementList);
}


}
