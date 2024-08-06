package objectRepository.DBM;

import org.testng.Assert;

import com.microsoft.playwright.Page;
import genericUtilities.GenericMethods;
import objectRepository.CommonPage;

public class PostgresQueryPerformancePage {


    Page page;
	GenericMethods util=new GenericMethods();
    CommonPage comPage = new CommonPage(page);

private String queryPerformanceTab = "xpath=//div[@class='item']/child::div[contains(@class,'router') and contains(text(),'Query')]";
private String queryThresholdTitle = "xpath=//div[@class='query-threshold-action']/descendant::div[@class='heading']";
private String queryThresholdDropdown = "id=btn-arrow-down-query-threshold-select";
private String queryThreshouldList = "xpath=//div[@class='query-threshold-action']/descendant::div[@class='option']/descendant::span[@class='selected-item-text']";
private String queryPerformanceTableHeader = "xpath=//thead[@class='header-container header-secondary']/descendant::td/child::div";
private String queryList =  "xpath=//table[@class='table-container']/descendant::thead[@class='header-container header-secondary']/descendant::td[@class='header-td' and position()=1]";
private String totalExcutionList = "xpath=//table[@class='table-container']/descendant::thead[@class='header-container header-secondary']/descendant::td[@class='header-td' and position()=2]";
private String executionTimeList = "xpath=//table[@class='table-container']/descendant::thead[@class='header-container header-secondary']/descendant::td[@class='header-td' and position()=3]";
private String timeStampList = "xpath=//table[@class='table-container']/descendant::thead[@class='header-container header-secondary']/descendant::td[@class='header-td' and position()=4]";
private String selectNodeDropDown = "xpath=//div[@class='dashboardTop']/descendant::div[@id='search-select-database-instance']";
private String showDropdown = "xpath=//div[@class='selected-text-container']";
private String showDropdowntValue10 ="xpath=//div[@class='items invert']/child::div[text()=' 10 ']";
private String showDropdowntValue20 = "xpath=//div[@class='items invert']/child::div[text()=' 20 ']";
private String showDropdowntValue50 ="xpath=//div[@class='items invert']/child::div[text()=' 50 ']";
private String noDataText ="xpath=//div[@class='inner-text']";
private String searchNodeTextField = "#input-search-sel-search-select-database-instance";
private String downloadReportBtn = "id=rex-pdf-download";
private String downloadSuccessMsg = "xpath=//div[.='The PDF report has been downloaded successfully.']";
private String closeSuccessMsg = "xpath=//i[@class='anticon anticon-close ant-notification-close-icon']";
private String refreshButton = "xpath=//div[@id='btn-refresh']";
private String selectAppDropDown="#btn-arrow-down-search-select-database-service" ;
private String searchAppTextField ="#input-search-sel-search-select-database-service" ;
private String searchedApp ="xpath=//span[@id='search-select-database-service-0-single']" ;
private String searchedNode ="#search-select-database-instance-0-single";
private String dataBaseTypeDropDown = "#btn-arrow-down-search-select-database-type";
private String dataBaseTypeTextField = "#input-search-sel-search-select-database-type";
private String firstDbTypeFromDropDown = "xpath=//span[@id='search-select-database-type-0-single']";
private String serviceDropDown = "#btn-arrow-down-search-select-database-service";
private String serviceTextField = "#input-search-sel-search-select-database-service";
private String firstServiceFromDropDown = "xpath=//span[@id='search-select-database-service-0-single']";
private String elementList ="xpath =//table/descendant::tr[@class='body-tr body-tr-secondary']/descendant::td[position()=1";
public PostgresQueryPerformancePage(Page page)
{
    this.page= page;
}
    public void clickOnQueryPerformanceTab(){
        page.click(queryPerformanceTab);
    }
    public void validateQueryPerformanceTab(String expectedTitle)
    {
        //page.pause();
        String currentURL = "**/database";
        page.waitForURL(currentURL);
        Assert.assertTrue(page.url().endsWith("/database"));
        page.waitForSelector(queryPerformanceTab);
        String actualTitle = page.locator(queryPerformanceTab).textContent().trim();
        //Assert.assertTrue(page.isVisible(totalExcutionList));
        System.out.println(actualTitle);
        System.out.println(expectedTitle+"Expected Title");
        util.ValidateTheTitle(actualTitle, expectedTitle);
    }    
    public void selectTheApplicationForDBM(String application)
	{
		util.selectTheOptionFromDropDownBySearch(page, selectAppDropDown, searchAppTextField, application, searchedApp);
	}
    public void selectDBMtype(String DBMtype ) {
        util.selectTheOptionFromDropDownBySearch(page, dataBaseTypeDropDown, dataBaseTypeTextField, DBMtype, firstDbTypeFromDropDown);
        
    }
    public void selectDbservice(String DBservice) {
        util.selectTheOptionFromDropDownBySearch(page, serviceDropDown, serviceTextField, DBservice, firstServiceFromDropDown);
    }
    public void getDownloadSuccessMsg(String expectedTitle) {
        String actualTitle1 = page.locator(queryPerformanceTab).textContent().trim();
        util.ValidateTheTitle(page, page.locator(downloadSuccessMsg).innerText(), expectedTitle);
    }
    public void getRefreshButton() {
        String actualTitle = page.locator(refreshButton).textContent().trim();
       // util.ValidateTheTitle(page, actualTitle);
    }
    public void getQueryThresholdDropdown(String selectOption) {
        util.selectTheOptionFromDropDown(page, queryThresholdDropdown, selectOption);
    }
    public void getQueryList(String expectedTitle) {
        String actualTitle = page.locator(queryList).textContent().trim();
        System.out.println(actualTitle+"expected2Title");
        System.out.println(expectedTitle+ " expectedTitle");
        util.ValidateTheTitle(actualTitle, expectedTitle);
    }
    public void getTotalExcutionList(String expectedTitle) {
        String actualTitle = page.locator(totalExcutionList).textContent().trim();
        util.ValidateTheTitle(actualTitle, expectedTitle);
    }
    public void getExecutionTimeList(String expectedTitle) {
        String actualTitle = page.locator(executionTimeList).textContent().trim();
        System.out.println(actualTitle);
        System.out.println(expectedTitle);
        util.ValidateTheTitle(actualTitle, expectedTitle);
    }
    public void getTimeStampList(String expectedTitle) {
        String actualTitle = page.locator(timeStampList).textContent().trim();
        util.ValidateTheTitle(actualTitle, expectedTitle);
    }
    public void selectPaginationAndValidate(Integer num) {
        comPage.selectPaginationAndValidate(page, num, elementList);
    }
    public void getDownloadReportBtn(String expectedTitle) {
        String actualTitle = page.locator(downloadReportBtn).textContent().trim();
        util.ValidateTheTitle(page, actualTitle, expectedTitle); ;
    }

    public void getNoDataText(String expectedTitle) {
        //System.out.println(actualTitle);
        //System.out.println(page.locator(noDataText).innerText());
        String actualTitle = page.locator(noDataText).textContent().trim();
        util.ValidateTheTitle(actualTitle, expectedTitle);
    }
    public void validateSelectNodeDropDown(String node) {
            util.selectTheOptionFromDropDownBySearch(page, selectNodeDropDown, searchNodeTextField, node, searchedNode);
        
    }
}
