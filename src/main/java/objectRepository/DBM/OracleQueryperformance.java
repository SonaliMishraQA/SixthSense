package objectRepository.DBM;

import org.testng.Assert;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import genericUtilities.GenericMethods;
import objectRepository.CommonPage;


public class OracleQueryperformance {
    Page page;
	GenericMethods util=new GenericMethods();
    CommonPage comPage = new CommonPage(page);

private String queryPerformanceTab = "xpath = //div[@class='item']/child::div[contains(@class,'router') and contains(text(),'Query')]";   
private String queryThresholdTitle = "xpath = //div[@class='query-threshold-action']/descendant::div[@class='heading']";
private String selectedQueryThreshold = "xpath = //div[@class='selected-item-text']";
private String queryThresholdDropdownBtn = "#btn-arrow-down-query-threshold-select";
private String queryThresholdList = "xpath = //div[@class='query-threshold-action']/descendant::div[@class='option']/descendant::span[@class='selected-item-text']";
private String defaultQueryThreshold = "xpath = //div[@class='selected-item-text']";
private String downloadReportBtn = "#rex-pdf-download";
private String confirmationMsg = "(xpath = //div[@class='ant-notification-notice-with-icon'])";
private String queryColumnTitle = "xpath = //table[@class='table-container']//div[@class='header-slot-default' and text()='Query']";
private String totalExeTimeColumnTitle = "xpath = //table[@class='table-container']//div[@class='header-slot-default' and text()='Total execution']";
private String timestampColumnTitle = "xpath = //table[@class='table-container']//div[@class='header-slot-default' and text()='Timestamp']";
private String executionTimeColumnTitle = "xpath = //table[@class='table-container']//div[@class='header-slot-default' and text()='Execution time(s)']"; 
private String queryColumnData = "(xpath = '//tr[@class='body-tr body-tr-secondary']/td[1]')";
private String avgExeTimeColumnData = "(xpath = //tr[@class='body-tr body-tr-secondary']/td[2]')";
private String timestampColumnData = "(xpath = //tr[@class='body-tr body-tr-secondary']/td[3]')";
private String paginationDropdown = "xpath = //div[@class='ant-select-selector']";
private String selectedPagination = "xpath = //span[@class='ant-select-selection-item']";
private String gotoPreviousPageBtn = "xpath = //button[@aria-label='Go to previous page']";
private String gotoNextPageBtn = "xpath = //button[@aria-label='Go to next page']";
private String tableNodataValue ="xpath = //div[@class='inner-text']";

private String calanderValue = "xpath = //div[@class='selected-text ellipsis bg-text']";
    

public OracleQueryperformance(Page page)
{
    this.page= page;
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
        util.ValidateTheTitle(page, queryThresholdTitle, expectedTitle);
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
       if(page.locator(tableNodataValue).isVisible()) 
    	   Assert.assertEquals(actualValue, expectedValue);
        else
    	   System.out.println("There is data available");
    }
    
    public void validateTotalExeTimeColumnNoData(String expectedValue) {
    	String actualValue = page.locator(tableNodataValue).textContent().trim() ;
    	if(page.locator(tableNodataValue).isVisible()) 
     	   Assert.assertEquals(actualValue, expectedValue);
         else
     	   System.out.println("There is data available");
    }
    public void validateTimestampColumnNoData(String expectedValue) {
    	String actualValue = page.locator(tableNodataValue).textContent().trim() ;
    	if(page.locator(tableNodataValue).isVisible()) 
     	   Assert.assertEquals(actualValue, expectedValue);
         else
     	   System.out.println("There is data available");
    }
    public void validateExecutionTimeColumnNoData(String expectedValue) {
    	String actualValue = page.locator(tableNodataValue).textContent().trim() ;
    	if(page.locator(tableNodataValue).isVisible()) 
     	   Assert.assertEquals(actualValue, expectedValue);
         else
     	   System.out.println("There is data available");
    }
    public void selectAndValidatePaginationOptions(String paginationOption) {
    	util.selectTheOptionFromDropDown(page, paginationDropdown, paginationOption);
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
    	util.selectTheOptionFromDropDown(page, queryThresholdDropdownBtn, queryThresholdOption);
    	String selectedQueryThresholdValue = page.locator(selectedQueryThreshold).textContent().trim();
    	Assert.assertEquals(selectedQueryThresholdValue, queryThresholdOption);
    	
    }
    
    
    
    
}


