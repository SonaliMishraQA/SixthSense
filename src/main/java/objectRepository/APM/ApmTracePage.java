package objectRepository.APM;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Color;
import org.testng.Assert;

import com.microsoft.playwright.Download;
import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Locator.ClickOptions;
import com.microsoft.playwright.Locator.HoverOptions;
import com.microsoft.playwright.Page;

import genericUtilities.ExcelUtility;
import genericUtilities.GenericMethods;
import genericUtilities.IPathConstant;
import genericUtilities.JavaUtility;
import objectRepository.CommonPage;

public class ApmTracePage {
	Page page;
	GenericMethods util = new GenericMethods();
	CommonPage common = new CommonPage(page);
	ExcelUtility excel = new ExcelUtility();
	JavaUtility javaUtil = new JavaUtility(); 
	
	private String traceTab = "#nav-tab-trace";
	private String instancesDropdown = "#btn-arrow-down-search-select-instances";
	private String searchInstanceTextField = "#input-search-sel-search-select-instances";
	private String instanceSearchResult = "xpath = //span[contains(@id,'search-select-instances')]" ;
	private String selectedInstance = "xpath = //div[@id='search-select-instances']/child::div[@class='selected-item-text']";
	private String firstInstanceSearchResult = "#search-select-instances-0-single";
	private String searchCloseBtn = "#btn-close-btn";
	private String statusDropdown = "#btn-arrow-down-search-select-status";
	private String selectedStatus = "xpath = //div[@id='search-select-status']/child::div[@class='selected-item-text']";
	private String allStatus = "#search-select-status-0-single";
	private String successStatus = "#search-select-status-1-single";
	private String errorStatus = "#search-select-status-2-single";
	private String endpointsDropdown = "#btn-arrow-down-search-select-endpoint";
	private String searchEndpointTextField = "#input-search-sel-search-select-endpoint";
	private String endpointSearchResult = "xpath = //span[contains(@id,'search-select-endpoint')]" ;
	private String selectedEndpoint = "xpath = //div[@id='search-select-endpoint']/child::div[@class='selected-item-text']";
	private String firstEndpointSearchResult = "#search-select-endpoint-0-single";
	private String searchByTraceIdTextField = "xpath = //input[@class='form-controlTrace']";
	private String searchByTraceIdClearBtn = "#btn-form-search-clr";
	private String searchFromMillisecTextField = "#input-form-search-from";
	private String searchToMillisecTextField = "#input-form-search-to";
	private String searchBtn = "xpath = //button[@class='search-icon']";
	private String sortbyDropdown = "#trace-table-dropdown-id";
	private String sortbyStartTime = "#BY_START_TIME";
	private String sortbyDuration = "#BY_DURATION";
	private String traceIdCopyBtn = "xpath = //button[@class='icon']";
	private String confirmationMessage = "xpath = //div[@class='ant-notification-notice-with-icon']";
	private String traces = "xpath = //tr[@class='rk-trace-tr']/descendant::span[@class='tb-endpoint']";
	private String endpointsInTraces = "xpath = //span[@class='tb-endpoint']";
	private String respTimeInTraces = "xpath = //div[@class='rk-tag mr-10 sm']";
	private String startTimeInTraces ="xpath = //div[@class='dt-info']";
	private String traceId = "xpath = //div[@class='rk-trace-detail-id-val']";
	private String listTab = "xpath = //a[contains(@class,'optionTrace') and .=' List']";
	private String treeTab = "xpath = //a[contains(@class,'optionTrace') and .=' Tree']";
	private String tableTab = "xpath = //a[contains(@class,'optionTrace') and .=' Table']";
	private String traceTableHeader = "xpath = //div[@class='trace-detail-chart-table']//div[@class='trace-header']";
	private String downloadReportBtn = "xpath = //div[@class='trace-title-and-download-box']//button[@id='rex-pdf-download']";
	private String firstCol = "xpath = //div[@class='trace-detail-chart-table']//div[@class='trace-header']//div[contains(@class,'method')]";
	private String secondCol = "xpath = //div[@class='trace-detail-chart-table']//div[@class='trace-header']//div[@class='start-time']";
	private String thirdCol = "xpath = //div[@class='trace-detail-chart-table']//div[@class='trace-header']//div[@class='exec-ms']";
	private String fourthCol = "xpath = //div[@class='trace-detail-chart-table']//div[@class='trace-header']//div[@class='exec-percent']";
	private String fifthCol = "xpath = //div[@class='trace-detail-chart-table']//div[@class='trace-header']//div[@class='self']";
	private String sixthCol = "xpath = //div[@class='trace-detail-chart-table']//div[@class='trace-header']//div[@class='api']";
	private String seventhCol = "xpath = //div[@class='trace-detail-chart-table']//div[@class='trace-header']//div[@class='application']";
	private String endpointInTable = "xpath = //div[@class='trace-detail-chart-table']//div[@class='trace-item-first method level0']/span";
	private String starttimeInTable = "xpath = (//div[@class='trace-detail-chart-table']//div[@class='start-time'])[2]";
	private String executiontimeInTable = "xpath = (//div[@class='trace-detail-chart-table']//div[@class='exec-ms'])[2]";
	private String applicationNameInTable = "xpath = //div[@class='trace-detail-chart-table']//div[@class='service']";
	private String apiInTable = "xpath = (//div[@class='trace-detail-chart-table']//div[@class='api'])[2]";
	private String applicationSelected = "xpath = //div[@id='search-select-application']/div[@class='selected-item-text']";
	private String startTimeInTableHeader = "xpath = (//span[@class='smValue'])[1]";
	private String durationInTableHeader = "xpath = (//span[@class='smValue'])[2]";
	private String spansInTableHeader = "xpath = (//span[@class='smValue'])[3]";
	private String spanInfoPageHeader = "xpath = //span[@class='title']";
	private String spanInfoCloseBtn = "xpath = //div[@class='action1 rk-sidebox-close']";
	private String spanInfoPageFirstCol = "xpath = (//div[@class='trace-details-parent']//div[@class='equal sub-header'])[1]";
	private String spanInfoPageSecondCol = "xpath = (//div[@class='trace-details-parent']//div[@class='equal sub-header'])[2]";
	private String spanInfoApplicationValue = "xpath = (//div[.='Application:']/following-sibling::div[@class='equal detail-value'])[1]";
	private String spanInfoEndpointValue = "xpath = (//div[.='Endpoint:']/following-sibling::div[@class='equal detail-value'])[1]";
	private String spanInfoComponentValue = "xpath = (//div[.='Component:']/following-sibling::div[@class='equal detail-value'])[1]";
	private String spanInfoErrorValue = "xpath = (//div[.='Error:']/following-sibling::div[@class='equal detail-value'])[1]";
	private String spanInfoUrlValue = "xpath = (//div[.='url:']/following-sibling::div[@class='equal detail-value'])[1]";
	private String spanInfoEndpointCopyBtn = "xpath = //div[.='Endpoint:']/following-sibling::div[@class='equal detail-value']/button[@class='copy-btn']";
	private String spanInfoUrlCopyBtn = "xpath = //div[.='url:']/following-sibling::div[@class='equal detail-value']/button[@class='copy-btn']";
	private String spanInfoDownloadReportBtn = "xpath = //div[@class='span-info-pdf-download']/button[@id='rex-pdf-download']";
	private String applicationNameInListTab = "xpath = //span[@class='service-bullet']";
	private String endpointInListTab = "xpath = (//*[@class='node-text'])[3]";
	private String componentInListTab = "xpath = (//*[@class='node-text'])[4]";
	private String tooltipEndpointInListTab = "xpath = //div[@class='d3-tip n']/div[@class='mb-1']";
	private String tooltipDurationInListTab = "xpath = (//div[@class='d3-tip n']/div[@class='sm'])[2]";
	private String downloadImageIcon = "xpath = //div[@class='listHeader']/div[@class='icon']";
	private String traceIdInTreeTab = "xpath = (//*[name()='g' and @class='node']/*[name()='text'])[1]";
	private String endpointInTreeTab = "xpath = (//*[name()='g' and @class='node']/*[name()='text'])[3]";
	private String durationInTraceRootListTab = "xpath = //*[name()='g' and @class='tick'][last()]";
	private String noDataIcon = "xpath = //div[@class='inner-text']";
	private String servicesInTable = "xpath = //div[@class='service']";
	private String elementHoverTooltip = "xpath = //div[@class='rk-tooltip-content']";
	private String messgaeCloseBtn = "xpath = //*[name()='svg' and @data-icon='close']";
	private String apmNav = "#side-nav-apm";
	private String endpointInDetailTile = "xpath = //h5[@class='detailTile']";
	private String endpointFrameInListTab = "xpath = (//*[name()='text' and @class='node-text'])[3]/preceding-sibling::*[name()='rect']";
	private String nextPageIcon = "xpath = //li[contains(@class,'ant-pagination-next')]/button";
	private String previousPageIcon = "xpath = //li[contains(@class,'ant-pagination-prev')]/button";
	
    public ApmTracePage(Page page) {
		this.page = page;
	}
    
    public void navigateToTracePage() {
		page.click(traceTab);
		page.waitForURL("**/trace");
		Assert.assertTrue(page.isVisible(sortbyDropdown));
	}
    
    public void navigateToTraceTableView() {
    	page.click(tableTab);
    	page.waitForSelector(traces);
    	page.locator(traces).nth(0).click();
        page.waitForSelector(endpointInTable);
    }
    
    public void selectAllInstanceFromDropdown () throws EncryptedDocumentException, IOException {
    	String expectedText = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.tracePageSheet, "instances");
    	util.selectTheOptionFromDropDownBySearch(page, instancesDropdown, searchInstanceTextField, expectedText, instanceSearchResult);
    	page.waitForSelector(selectedInstance);
    	Assert.assertTrue(page.textContent(selectedInstance).trim().equalsIgnoreCase(expectedText));
    	page.waitForSelector(traces);
    	Locator trace = page.locator(traces);
    	System.out.println("count = "+trace.count());
		Assert.assertTrue(trace.count()>0);
    }
    
    public void selectAllStatusFromDropdown() throws EncryptedDocumentException, IOException {
    	String expectedText = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.tracePageSheet, "allStatus");
    	util.selectTheOptionFromDropDown(page, statusDropdown, expectedText);
    	page.waitForSelector(selectedStatus);
    	Assert.assertTrue(page.textContent(selectedStatus).trim().equalsIgnoreCase(expectedText));
    	page.waitForTimeout(200);
    	page.waitForSelector(traces);
    	Locator trace = page.locator(traces);
    	System.out.println("count = "+trace.count());
		Assert.assertTrue(trace.count()>0);
    }
    
    public void selectSuccessStatusFromDropdown() throws EncryptedDocumentException, IOException {
    	String expectedText = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.tracePageSheet, "successStatus");
    	util.selectTheOptionFromDropDown(page, statusDropdown, expectedText);
    	String expectedColor = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.tracePageSheet, "successEndpointColor");
    	page.waitForSelector(selectedStatus);
    	Assert.assertTrue(page.textContent(selectedStatus).trim().equalsIgnoreCase(expectedText));
    	page.waitForTimeout(200);
    	page.waitForSelector(traces);
    	Locator trace = page.locator(traces);
    	System.out.println("count = "+trace.count());
		Assert.assertTrue(trace.count()>0);
		for(int i=0; i<trace.count(); i++) {
			String actualColor =(String) trace.nth(i).evaluate("element => window.getComputedStyle(element).getPropertyValue('color')");
			Assert.assertTrue(actualColor.contains(expectedColor));
		}
    }
    
    public void selectErrorStatusFromDropdown() throws EncryptedDocumentException, IOException {
    	String expectedText = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.tracePageSheet, "errorStatus");
    	util.selectTheOptionFromDropDown(page, statusDropdown, expectedText);
    	String expectedColor = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.tracePageSheet, "errorEndpointColor");
    	page.waitForSelector(selectedStatus);
    	Assert.assertTrue(page.textContent(selectedStatus).trim().equalsIgnoreCase(expectedText));
    	page.waitForTimeout(200);
    	page.waitForSelector(traces);
    	Locator trace = page.locator(traces);
    	System.out.println("count = "+trace.count());
		Assert.assertTrue(trace.count()>0);
		for(int i=0; i<trace.count(); i++) {
			String actualColor =(String) trace.nth(i).evaluate("element => window.getComputedStyle(element).getPropertyValue('color')");
			System.out.println("expectedColor :"+expectedColor+"\tactualColor : "+actualColor);
			Assert.assertTrue(actualColor.contains(expectedColor));
		}
    }
    
    public void selectAllEndpointsFromDropdown() throws EncryptedDocumentException, IOException {
    	String expectedText = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.tracePageSheet, "endpoints");
    	util.selectTheOptionFromDropDownBySearch(page, endpointsDropdown, searchEndpointTextField, expectedText, endpointSearchResult);
    	page.waitForSelector(selectedEndpoint);
    	Assert.assertTrue(page.textContent(selectedEndpoint).trim().equalsIgnoreCase(expectedText));
    	page.waitForSelector(traces);
    	Locator trace = page.locator(traces);
    	System.out.println("count = "+trace.count());
		Assert.assertTrue(trace.count()>0);
    }
    
    public void selectParticularEndpointFromDropdown() throws EncryptedDocumentException, IOException {
    	String expectedText = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.tracePageSheet, "particularEndpoint");
    	util.selectTheOptionFromDropDownBySearch(page, endpointsDropdown, searchEndpointTextField, expectedText, endpointSearchResult);
    	page.waitForSelector(traces);
    	String selectedText = page.textContent(selectedEndpoint);
    	Assert.assertTrue(selectedText.equalsIgnoreCase(expectedText));
    	Locator trace = page.locator(traces);
    	for(int i=0; i<trace.count(); i++) {
    		String actualText = trace.nth(i).textContent().trim();
			Assert.assertTrue(actualText.contains(expectedText));
		}
    }
	
    public void clickOnTraceidCopyBtnAndValidate() throws EncryptedDocumentException, IOException {
    	String message = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath, IPathConstant.messageSheet, "CopyConfirmationMessgae");
    	page.click(traceIdCopyBtn);
    	String actualMessage = page.textContent(confirmationMessage);
    	System.out.println(actualMessage +"\t"+message);
    	Assert.assertTrue(actualMessage.contains(message));
    	page.click(messgaeCloseBtn);
    }
    
    public void searchAndValidateEndpointForTheTraceId() {
    	String Id = page.textContent(traceId).trim();
    	page.locator(searchByTraceIdTextField).clear();
    	page.locator(searchByTraceIdTextField).fill(Id);
    	page.click(searchBtn);
    	page.waitForSelector(traces);
    	Assert.assertTrue(page.textContent(traceId).trim().equals(Id));
    	page.click(searchByTraceIdClearBtn);
    }
    
    public void validateSearchTracesByResponseTimeForLessThanOrEqualToSpecifiedTime() throws NumberFormatException, EncryptedDocumentException, IOException {
    	String time = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.tracePageSheet, "searchByRepTime_ToValue");
    	int expectedTime = Integer.parseInt(time);
    	page.locator(searchToMillisecTextField).fill(time);
    	page.click(searchBtn);
    	page.waitForSelector(traces);
    	Locator respTime = page.locator(respTimeInTraces);
    	for(int i=0; i<respTime.count(); i++)
    	{
    		int actualTime = (Integer.parseInt(respTime.nth(i).textContent().trim().replace("ms", "")));
    		//System.out.println(actualTime);
    		Assert.assertTrue(actualTime <= expectedTime);
    	}
    	page.click(searchByTraceIdClearBtn);
    }
    
    public void validateSearchTracesByResponseTimeForGreaterThanOrEqualToSpecifiedTime() throws NumberFormatException, EncryptedDocumentException, IOException {
    	String time = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.tracePageSheet, "searchByRepTime_FromValue");
    	int expectedTime = Integer.parseInt(time);
    	page.locator(searchFromMillisecTextField).fill(time);
    	page.click(searchBtn);
    	page.waitForSelector(traces);
    	Locator respTime = page.locator(respTimeInTraces);
    	for(int i=0; i<respTime.count(); i++)
    	{
    		int actualTime = (Integer.parseInt(respTime.nth(i).textContent().trim().replace("ms", "")));
    		//System.out.println(actualTime);
    		Assert.assertTrue(actualTime >= expectedTime);
    	}
    	page.click(searchByTraceIdClearBtn);
    }
    
    public void validateSearchTracesByResponseTimeIsBetweenTheSpecifiedTime() throws NumberFormatException, EncryptedDocumentException, IOException {
    	String time = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.tracePageSheet, "searchByRepTime_FromValue");
    	int fromTime = Integer.parseInt(time);
    	page.locator(searchFromMillisecTextField).fill(time);
    	String time1 = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.tracePageSheet, "searchByRepTime_ToValue");
    	int toTime = Integer.parseInt(time1);
    	page.locator(searchToMillisecTextField).fill(time1);
    	page.click(searchBtn);
    	page.waitForSelector(traces);
    	Locator respTime = page.locator(respTimeInTraces);
    	for(int i=0; i<respTime.count(); i++)
    	{
    		int actualTime = (Integer.parseInt(respTime.nth(i).textContent().trim().replace("ms", "")));
    		//System.out.println(actualTime);
    		Assert.assertTrue(actualTime >= fromTime && actualTime <= toTime);
    	}
    	page.click(searchByTraceIdClearBtn);
    }
    
    public void sortTracesByExecutionStartingTimeAndValidate() {
    	page.click(sortbyDropdown);
    	page.click(sortbyStartTime);
    	page.waitForSelector(traces);
    	boolean flag = false;
    	int max = page.locator(traces).count();
    	if(max!=0)
        {
            int count = max-1;
            Locator times = page.locator(startTimeInTraces);
            for(int i=0; i<max-1; i++)
            {
                String text1 = times.nth(i).textContent().trim().replace("-"," ");
                text1 = text1.replaceAll(":", " ");
                String[] time1 = text1.split(" ");
                String text2 = times.nth(i+1).textContent().trim().replaceAll("-"," ");
                text2 = text2.replaceAll(":", " ");
                System.out.println(text2);
                String[] time2 = text2.split(" ");
                for(int j=0; j<time1.length; j++)
                {
                    if(Integer.parseInt(time1[j]) >= Integer.parseInt(time2[j]))
                    {
                        flag = true;
                        break;
                    }
                }
                if(flag == true)
                count--;
            }
            System.out.println(count);
            Assert.assertTrue(count == 0);
        }
    }
    
    public void sortTracesByExecutionDurationAndValidate() {
    	page.click(sortbyDropdown);
    	page.click(sortbyDuration);
    	page.waitForSelector(traces);
    	
    	Locator duration = page.locator(respTimeInTraces);
    	int count = duration.count()-1;
    	for(int i=0; i<duration.count()-1; i++) {
    		String time1 = duration.nth(i).textContent().trim().replaceAll("ms","");
            String time2 = duration.nth(i+1).textContent().trim().replaceAll("ms","");
            if(Integer.parseInt(time1) >= Integer.parseInt(time2))
                count--;  
    	}
    	System.out.println(count);
        Assert.assertTrue(count == 0);
    }
    
    public void validateTheFirstColumnNameOfTraceTable() throws EncryptedDocumentException, IOException {
    	String expectedTitle = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.tracePageSheet, "firstColumnName");
    	page.click(tableTab);
    	page.waitForSelector(traces);
    	util.ValidateTheTitle(page.textContent(firstCol).trim(), expectedTitle);
    }
    
    public void validateTheSecondColumnNameOfTraceTable() throws EncryptedDocumentException, IOException {
    	String expectedTitle = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.tracePageSheet, "secondColumnName");
    	page.click(tableTab);
    	page.waitForSelector(traces);
    	util.ValidateTheTitle(page.textContent(secondCol).trim(), expectedTitle);
    }
    
    public void validateTheThirdColumnNameOfTraceTable() throws EncryptedDocumentException, IOException {
    	String expectedTitle = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.tracePageSheet, "thirdColumnName");
    	page.click(tableTab);
    	page.waitForSelector(traces);
    	util.ValidateTheTitle(page.textContent(thirdCol).trim(), expectedTitle);
    }
    
    public void validateTheFourthColumnNameOfTraceTable() throws EncryptedDocumentException, IOException {
    	String expectedTitle = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.tracePageSheet, "fourthColumnName");
    	page.click(tableTab);
    	page.waitForSelector(traces);
    	util.ValidateTheTitle(page.textContent(fourthCol).trim(), expectedTitle);
    }
    
    public void validateTheFifthColumnNameOfTraceTable() throws EncryptedDocumentException, IOException {
    	String expectedTitle = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.tracePageSheet, "fifthColumnName");
    	page.click(tableTab);
    	page.waitForSelector(traces);
    	util.ValidateTheTitle(page.textContent(fifthCol).trim(), expectedTitle);
    }
    
    public void validateTheSixthColumnNameOfTraceTable() throws EncryptedDocumentException, IOException {
    	String expectedTitle = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.tracePageSheet, "sixthColumnName");
    	page.click(tableTab);
    	page.waitForSelector(traces);
    	util.ValidateTheTitle(page.textContent(sixthCol).trim(), expectedTitle);
    }
    
    public void validateTheSeventhColumnNameOfTraceTable() throws EncryptedDocumentException, IOException {
    	String expectedTitle = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.tracePageSheet, "seventhColumnName");
    	page.click(tableTab);
    	page.waitForSelector(traces);
    	util.ValidateTheTitle(page.textContent(seventhCol).trim(), expectedTitle);
    }
    
    public void validateTheTraceEndpointInTheTraceTable(){
    	navigateToTraceTableView();
        String expectedEndpoint = page.locator(endpointsInTraces).nth(0).textContent().trim();
        String actualEndpoint = page.textContent(endpointInTable).trim();
        System.out.println(actualEndpoint);
        System.out.println(expectedEndpoint);
        Assert.assertTrue(actualEndpoint.equals(expectedEndpoint));
	}
    
    public void validateTheTraceEndpointInTheTraceTableHeader(){
    	navigateToTraceTableView();
        String expectedEndpoint = page.locator(endpointsInTraces).nth(0).textContent().trim();
        String actualEndpoint = page.textContent(endpointInDetailTile).trim();
        System.out.println(actualEndpoint);
        System.out.println(expectedEndpoint);
        Assert.assertTrue(actualEndpoint.equals(expectedEndpoint));
	}
    
    public void validateTheTraceStartTimeInTheTraceTable(){
    	navigateToTraceTableView();
        String expectedStartTime = page.locator(startTimeInTraces).nth(0).textContent().trim();
        String actualStartTime = page.textContent(starttimeInTable).trim();
        System.out.println(actualStartTime);
        System.out.println(expectedStartTime);
        Assert.assertTrue(actualStartTime.equals(expectedStartTime));
	}
    
    public void validateTheTraceResponseTimeInTheTraceTable(){
    	navigateToTraceTableView();
        String expectedResponseTime = page.locator(respTimeInTraces).nth(0).textContent().trim().replace("ms", "");
        String actualResponseTime = page.textContent(executiontimeInTable).trim();
        System.out.println(actualResponseTime);
        System.out.println(expectedResponseTime);
        Assert.assertTrue(actualResponseTime.equals(expectedResponseTime));
    }
    
    public void validateTheTraceApplicationNameInTheTraceTable(){
    	navigateToTraceTableView();
        String expectedApplication = page.textContent(applicationSelected).trim();
        String actualApplication = page.textContent(applicationNameInTable).trim();
        System.out.println(actualApplication);
        System.out.println(expectedApplication);
        Assert.assertTrue(actualApplication.equals(expectedApplication));
	}
    
    public void validateTheTraceStartTimeInTheTraceTableHeader(){
    	navigateToTraceTableView();
        String expectedStartTime = page.textContent(starttimeInTable).trim();
        String actualStartTime = page.textContent(startTimeInTableHeader).trim();
        System.out.println(actualStartTime);
        System.out.println(expectedStartTime);
        Assert.assertTrue(actualStartTime.equals(expectedStartTime));
	}
    
    public void validateTheTraceDurationInTheTraceTableHeader(){
    	navigateToTraceTableView();
        String expectedDuration = page.textContent(executiontimeInTable).trim();
        String actualDuration = page.textContent(durationInTableHeader).trim().replace(" ms", "");
        System.out.println(actualDuration);
        System.out.println(expectedDuration);
        Assert.assertTrue(actualDuration.equals(expectedDuration));
	}
    
    public void validateTheNumberOfSpansInTheTraceTableHeader(){
    	navigateToTraceTableView();
    	page.waitForSelector(servicesInTable);
        int expectedDuration = page.locator(servicesInTable).count();
        int actualDuration = Integer.parseInt(page.textContent(spansInTableHeader).trim());
        System.out.println(actualDuration);
        System.out.println(expectedDuration);
        Assert.assertTrue(actualDuration == expectedDuration);
	}
    
    public void validateWhetherTheSpanInfoPageIsDisplayed() throws EncryptedDocumentException, IOException{
    	String expectedTitle = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.tracePageSheet, "spanInfoPageHeader");
    	navigateToTraceTableView();
        page.click(endpointInTable);
        page.waitForSelector(spanInfoPageHeader);
        String actualTitle = page.textContent(spanInfoPageHeader).trim();
        Assert.assertTrue(actualTitle.equalsIgnoreCase(expectedTitle));
        page.locator(spanInfoCloseBtn).click();
    }
    
    public void validateTheApplicationNameInSpanInfoPage(){
    	navigateToTraceTableView();
        String expectedApplication = page.textContent(applicationNameInTable).trim();
        page.click(endpointInTable);
        page.waitForSelector(spanInfoPageHeader);
        String actualApplication = page.textContent(spanInfoApplicationValue).trim();
        System.out.println(actualApplication);
        System.out.println(expectedApplication);
        Assert.assertTrue(actualApplication.equalsIgnoreCase(expectedApplication));
        page.locator(spanInfoCloseBtn).click();
	}
    
    public void validateTheTraceEndpointInSpanInfoPage(){
    	navigateToTraceTableView();
        String expectedEndpoint = page.textContent(endpointInTable).trim();
        page.click(endpointInTable);
        page.waitForSelector(spanInfoPageHeader);
        String actualEndpoint = page.textContent(spanInfoEndpointValue).trim();
        System.out.println(actualEndpoint);
        System.out.println(expectedEndpoint);
        Assert.assertTrue(actualEndpoint.equalsIgnoreCase(expectedEndpoint));
        page.locator(spanInfoCloseBtn).click();
	}
    
    public void validateFunctionalityOfEndpointCopyInSpanInfoPage() throws EncryptedDocumentException, IOException {
    	navigateToTraceTableView();
        page.click(endpointInTable);
        page.waitForSelector(spanInfoPageHeader);
        page.hover(spanInfoEndpointCopyBtn);
        String expectedTooltip = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.tracePageSheet, "spanInfoCopyTooltipText");
        System.out.println(expectedTooltip);
        System.out.println(page.textContent(elementHoverTooltip).trim());
        Assert.assertTrue(page.textContent(elementHoverTooltip).trim().equals(expectedTooltip));
        String expectedMessage = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath, IPathConstant.messageSheet, "CopyConfirmationMessgae");
        page.click(spanInfoEndpointCopyBtn);
        page.waitForSelector(confirmationMessage);
        Assert.assertTrue(page.textContent(confirmationMessage).trim().contains(expectedMessage));
        page.click(messgaeCloseBtn);
        page.locator(spanInfoCloseBtn).click();
	}
    
    public void validateTheTraceComponentInTheSpanInfoPage(){
    	navigateToTraceTableView();
    	String expectedComponent = page.textContent(apiInTable).trim();
        page.click(endpointInTable);
        page.waitForSelector(spanInfoPageHeader);
        String actualComponent = page.textContent(spanInfoComponentValue).trim();
        System.out.println(actualComponent);
        System.out.println(expectedComponent);
        Assert.assertTrue(actualComponent.equalsIgnoreCase(expectedComponent));
        page.locator(spanInfoCloseBtn).click();
	}
    
    public void validateTheTraceUrlInTheSpanInfoPage(){
    	navigateToTraceTableView();
        String expectedEndpoint = page.textContent(endpointInTable).trim();
        page.click(endpointInTable);
        page.waitForSelector(spanInfoPageHeader);
        String actualUrl = page.textContent(spanInfoUrlValue).trim();
        System.out.println(actualUrl);
        System.out.println(expectedEndpoint);
        Assert.assertTrue(actualUrl.equalsIgnoreCase(expectedEndpoint));
        page.locator(spanInfoCloseBtn).click();
	}
    
    public void validateFunctionalityOfUrlCopyInSpanInfoPage() throws InterruptedException, EncryptedDocumentException, IOException{
    	navigateToTraceTableView();
        page.click(endpointInTable);
        page.waitForSelector(spanInfoPageHeader);
        page.hover(spanInfoUrlCopyBtn);
        String expectedTooltip = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.tracePageSheet, "spanInfoCopyTooltipText");
        System.out.println(expectedTooltip);
        System.out.println(page.textContent(elementHoverTooltip).trim());
        Assert.assertTrue(page.textContent(elementHoverTooltip).trim().equals(expectedTooltip));
        String expectedMessage = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath, IPathConstant.messageSheet, "CopyConfirmationMessgae");
        page.click(spanInfoUrlCopyBtn);
        page.waitForSelector(confirmationMessage);
        Assert.assertTrue(page.textContent(confirmationMessage).trim().contains(expectedMessage));
        page.click(messgaeCloseBtn);
        page.locator(spanInfoCloseBtn).click();
	}
    
    public void validateTheErrorInTheSpanInfoPage() throws EncryptedDocumentException, IOException{
    	navigateToTraceTableView();
        String endpointColor = (String) page.locator(traces).nth(0).evaluate("element => window.getComputedStyle(element).getPropertyValue('color')");
        String errorColor = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.tracePageSheet, "errorEndpointColor");
        String successColor = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.tracePageSheet, "successEndpointColor");
        String expectedError = "false";
        if(endpointColor.contains(errorColor))
            expectedError = "true";
        else if(endpointColor.contains(successColor))
            expectedError = "false";
        page.click(endpointInTable);
        page.waitForSelector(spanInfoPageHeader);
        String actualError = page.textContent(spanInfoErrorValue).trim();
        System.out.println("expectedError "+ expectedError);
        System.out.println("actualError  "+actualError);
        Assert.assertTrue(actualError.equalsIgnoreCase(expectedError));
        page.locator(spanInfoCloseBtn).click();
	}
    
    public void validateTheTraceEndpointUnderTheListTab(){
    	page.locator(traces).nth(0).click();
        page.click(listTab);
        page.waitForSelector(endpointInListTab);
        String expectedEndpoint = page.locator(endpointsInTraces).nth(0).textContent().trim();
        String actualEndpoint = page.textContent(endpointInListTab).trim();
        System.out.println(actualEndpoint);
        System.out.println(expectedEndpoint);
        Assert.assertTrue(actualEndpoint.equals(expectedEndpoint));
	}
    
    public void validateTheTraceEndpointUnderTheListTabTooltip(){
    	page.locator(traces).nth(0).click();
        page.click(listTab);
        page.waitForTimeout(300);
        page.waitForSelector(endpointInListTab);
        String expectedEndpoint = page.locator(endpointsInTraces).nth(0).textContent().trim();
        page.click(listTab);
        page.waitForSelector(endpointInListTab);
        page.locator(endpointFrameInListTab).hover();
        page.waitForSelector(tooltipEndpointInListTab);
        String actualEndpoint = page.textContent(tooltipEndpointInListTab).trim();
        System.out.println(actualEndpoint);
        System.out.println(expectedEndpoint);
        Assert.assertTrue(actualEndpoint.equals(expectedEndpoint));
	}
    
    public void validateTheTraceResponseTimeUnderTheListTab() {
    	page.locator(traces).nth(0).click();
    	page.waitForSelector(endpointInTable);
    	String expectedResponseTime = page.locator(respTimeInTraces).nth(0).textContent().trim().replace("ms", "");
        page.click(listTab);
        page.waitForSelector(endpointInListTab);
        page.locator(endpointFrameInListTab).hover();
        page.waitForSelector(tooltipDurationInListTab);
        String respTime = page.textContent(tooltipDurationInListTab).trim();
        String actualResponseTime = respTime.substring(respTime.indexOf(":")+2).replaceAll("ms", "");
        System.out.println(actualResponseTime);
        System.out.println(expectedResponseTime);
        Assert.assertTrue(actualResponseTime.equals(expectedResponseTime));
	}
    
    public void validateTheTraceResponseTimeInTraceRootUnderTheListTab(){
    	page.locator(traces).nth(0).click();
    	page.waitForSelector(endpointInTable);
    	String expectedResponseTime = page.locator(respTimeInTraces).nth(0).textContent().trim().replace("ms", "");
        page.click(listTab);
        page.waitForSelector(endpointInListTab);
        String actualResponseTime = page.textContent(durationInTraceRootListTab).trim();
        System.out.println(actualResponseTime);
        System.out.println(expectedResponseTime);
        Assert.assertTrue(actualResponseTime.equals(expectedResponseTime));
	}
    
    public void validateTheTraceApplicationNameUnderListTab(){
    	page.locator(traces).nth(0).click();
    	page.waitForSelector(endpointInTable);
        String expectedApplication = page.textContent(applicationSelected).trim();
        page.click(listTab);
        String actualApplication = page.textContent(applicationNameInListTab).trim();
        System.out.println(actualApplication);
        System.out.println(expectedApplication);
        Assert.assertTrue(actualApplication.equals(expectedApplication));
	}
    
    public void validateWhetherTheSpanInfoPageIsDisplayedFromListTab() throws EncryptedDocumentException, IOException{
    	page.locator(traces).nth(0).click();
    	page.waitForSelector(endpointInTable);
        page.click(listTab);
        page.waitForSelector(endpointInListTab);
        page.locator(endpointFrameInListTab).click();
        page.waitForSelector(spanInfoPageHeader);
        String expectedTitle = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.tracePageSheet, "spanInfoPageHeader");
        String actualTitle = page.textContent(spanInfoPageHeader).trim();
        System.out.println(actualTitle);
        System.out.println(expectedTitle);
        Assert.assertTrue(actualTitle.equalsIgnoreCase(expectedTitle));
        page.locator(spanInfoCloseBtn).click();
	}
    
    public void validateTheTraceEndpointUnderTheTreeTab(){
    	page.locator(traces).nth(0).click();
    	page.waitForSelector(endpointInTable);
    	String expectedEndpoint = page.locator(endpointsInTraces).nth(0).textContent().trim();
        page.click(treeTab);
        page.waitForSelector(endpointInTreeTab);
        String actualEndpoint = page.textContent(endpointInTreeTab).trim();
        System.out.println(actualEndpoint);
        System.out.println(expectedEndpoint);
        Assert.assertTrue(actualEndpoint.contains(expectedEndpoint));
	}
    
    public void validateTheTraceIdUnderTheTreeTab(){
    	page.locator(traces).nth(0).click();
    	page.waitForSelector(endpointInTable);
        page.click(treeTab);
        page.waitForSelector(endpointInTreeTab);
        String expectedTraceId = page.textContent(traceId).trim();
        String actualTraceId = page.textContent(traceIdInTreeTab).trim().replace("...","");
        System.out.println(expectedTraceId);
        System.out.println(actualTraceId);
        Assert.assertTrue(expectedTraceId.contains(actualTraceId));
	}
    
    public void validateWhetherTheSpanInfoPageIsDisplayedFromTreeTab() throws EncryptedDocumentException, IOException{
    	page.locator(traces).nth(0).click();
    	page.waitForSelector(endpointInTable);
        page.click(treeTab);
        page.waitForSelector(endpointInTreeTab);
        page.locator(endpointInTreeTab).hover();
        page.waitForSelector(spanInfoPageHeader);
        String expectedTitle = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.tracePageSheet, "spanInfoPageHeader");
        String actualTitle = page.textContent(spanInfoPageHeader).trim();
        System.out.println(actualTitle);
        System.out.println(expectedTitle);
        Assert.assertTrue(actualTitle.equalsIgnoreCase(expectedTitle));
        //page.locator(spanInfoCloseBtn).click();
	}
    
    public void validateTheFirstColumnNameOfSpanInfoPage() throws EncryptedDocumentException, IOException {
    	String expectedTitle = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.tracePageSheet, "spanInfoPageFirstColName");
    	page.locator(traces).nth(0).click();
    	page.waitForSelector(endpointInTable);
    	page.click(endpointInTable);
    	util.ValidateTheTitle(page.textContent(spanInfoPageFirstCol).trim(), expectedTitle);
    	page.click(spanInfoCloseBtn);
    }
    
    public void validateTheSecondColumnNameOfSpanInfoPage() throws EncryptedDocumentException, IOException {
    	String expectedTitle = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.tracePageSheet, "spanInfoPageSecondColName");
    	page.locator(traces).nth(0).click();
    	page.waitForSelector(endpointInTable);
    	page.click(endpointInTable);
    	util.ValidateTheTitle(page.textContent(spanInfoPageSecondCol).trim(), expectedTitle);
    	page.click(spanInfoCloseBtn);
    }
    
    public void validateWhetherTheDownloadReportButtonIsActive(){
    	page.waitForSelector(downloadReportBtn);
		Assert.assertTrue(!page.getAttribute(downloadReportBtn, "class").contains("disabled"));
	}
    
    public void validateFunctionalityOfDownloadReportInTracePage() throws EncryptedDocumentException, IOException {
    	String message = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath, IPathConstant.messageSheet, "TracePage_downloadReportConfirmationMessage");
    	Download download = page.waitForDownload(() -> {page.locator(downloadReportBtn).click();});
    	Assert.assertTrue(page.textContent(confirmationMessage).trim().contains(message));	
    	System.out.println("Message validated");
    	page.click(messgaeCloseBtn);
    	String filePath = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.tracePageSheet, "downloadReportFilePath");
    	String fileName = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.tracePageSheet, "tracePageDownloadReportFileName");
    	download.saveAs(Paths.get(filePath, fileName));
    	System.out.println("File downloaded");
    	String fName = javaUtil.getLatestFilefromDir(filePath).getName();
    	System.out.println(fName +"\t"+fileName);
    	Assert.assertTrue(fName.equalsIgnoreCase(fileName));
    	javaUtil.deleteFile(filePath, fileName);
    }
    
    public void validateWhetherTheDownloadReportButtonIsActiveInSpanInfoPage(){
    	page.locator(traces).nth(0).click();
    	page.waitForSelector(endpointInTable);
    	page.click(endpointInTable);
		Assert.assertTrue(page.locator(spanInfoDownloadReportBtn).isEnabled());
		page.click(spanInfoCloseBtn);
	}
    
    public void validateFunctionalityOfDownloadReportInSpanInfoPage() throws EncryptedDocumentException, IOException {
    	page.locator(traces).nth(0).click();
    	page.waitForSelector(endpointInTable);
    	page.click(endpointInTable);
    	String message = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath, IPathConstant.messageSheet, "TracePage_downloadReportConfirmationMessage");
    	Download download = page.waitForDownload(() -> { page.locator(spanInfoDownloadReportBtn).click();});
    	Assert.assertTrue(page.textContent(confirmationMessage).trim().contains(message));	
    	System.out.println("Message validated");
    	page.click(messgaeCloseBtn);
    	String filePath = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.tracePageSheet, "downloadReportFilePath");
    	String fileName = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.tracePageSheet, "spanInfoPageDownloadReportFileName");
    	download.saveAs(Paths.get(filePath, fileName));
    	System.out.println("File downloaded");
    	String fName = javaUtil.getLatestFilefromDir(filePath).getName();
    	System.out.println(fName +"\t"+fileName);
    	Assert.assertTrue(fName.equalsIgnoreCase(fileName));
    	javaUtil.deleteFile(filePath, fileName);
    	System.out.println("File deleted");
    }
    
    public void validateWhetherTheDownloadImageIconIsActive() throws EncryptedDocumentException, IOException{
    	page.click(listTab);
		Assert.assertTrue(page.locator(downloadImageIcon).isEnabled());
		page.hover(downloadImageIcon);
		page.waitForSelector(elementHoverTooltip);
		String expectedTooltip = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.tracePageSheet, "downloadImageTooltip");
        System.out.println(expectedTooltip);
        System.out.println(page.textContent(elementHoverTooltip).trim());
        Assert.assertTrue(page.textContent(elementHoverTooltip).trim().equals(expectedTooltip));
	}
    
    public void validateTheFunctionalityOfDownloadImageIcon() throws EncryptedDocumentException, IOException {
    	page.locator(traces).nth(0).click();
    	page.waitForSelector(endpointInTable);
        page.click(listTab);
    	page.waitForSelector(downloadImageIcon);
    	Download dl = page.waitForDownload(() -> {page.locator(downloadImageIcon).click();});
    	String filePath = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.tracePageSheet, "downloadReportFilePath");
    	String fileName = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.tracePageSheet, "downloadImageFileName");
    	dl.saveAs(Paths.get(filePath, fileName));
    	System.out.println("File downloaded");
    	String fName = javaUtil.getLatestFilefromDir(filePath).getName();
    	System.out.println(fName +"\t"+fileName);
    	Assert.assertTrue(fName.equalsIgnoreCase(fileName));
    	javaUtil.deleteFile(filePath, fileName);
    	System.out.println("File deleted");
    }
    
    public void validateEndpointsNamesUnderAllStatus() throws EncryptedDocumentException, IOException {
    	String endpts = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.apmDataValidationSheet, "endPoints");
    	String[] endpoints = endpts.split(",");
    	page.waitForSelector(traces);
    	Locator trace = page.locator(traces);
    	int count = 0;
    	for (String endpoint : endpoints) {
			for(int i=0; i<trace.count(); i++) {
				if(trace.nth(i).textContent().trim().equalsIgnoreCase(endpoint)) {
					count ++;
					break;
				}
			}
		}
    	Assert.assertTrue(count == 6);
    }
    
    public void validateEndpointsNamesUnderSuccessStatus() throws EncryptedDocumentException, IOException {
    	String endpts = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.apmDataValidationSheet, "successEndPoints");
    	String status = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.tracePageSheet, "successStatus");
    	String[] endpoints = endpts.split(",");
    	page.waitForSelector(statusDropdown);
    	util.selectTheOptionFromDropDown(page,statusDropdown, status);
    	page.waitForSelector(traces);
    	Locator trace = page.locator(traces);
    	boolean flag = false;
    	for(int i=0; i<trace.count(); i++) {
    		String text = trace.nth(i).textContent().trim();
    		if(text.equalsIgnoreCase(endpoints[0]) || text.equalsIgnoreCase(endpoints[1]) || text.equalsIgnoreCase(endpoints[2]) || text.equalsIgnoreCase(endpoints[1])) {
    			flag = true;
    		}
    		Assert.assertTrue(flag);
    	}			
    }
    
    public void validateEndpointsNamesUnderErrorStatus() throws EncryptedDocumentException, IOException {
    	String endpts = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.apmDataValidationSheet, "errorEndPoints");
    	String status = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.tracePageSheet, "errorStatus");
    	String[] endpoints = endpts.split(",");
    	page.waitForSelector(statusDropdown);
    	Locator trace = page.locator(traces);
    	util.selectTheOptionFromDropDown(page,statusDropdown, status);
    	page.waitForSelector(traces);
    	boolean flag = false;
    	for(int i=0; i<trace.count(); i++) {
    		String text = trace.nth(i).textContent().trim();
    		if(text.equalsIgnoreCase(endpoints[0]) || text.equalsIgnoreCase(endpoints[1])) {
    			flag = true;
    		}
    		Assert.assertTrue(flag);
    	}			
    }
    
    public void validateEndpointsSearchResultsForTheEndpointNames() throws EncryptedDocumentException, IOException {
    	String endpts = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.apmDataValidationSheet, "endPoints");
    	String[] endpoints = endpts.split(",");
    	for (String endpoint : endpoints) {
    		util.selectTheOptionFromDropDownBySearch(page, endpointsDropdown, searchEndpointTextField, endpoint, endpointSearchResult);
    		page.waitForSelector(traces);
    		Locator trace = page.locator(traces);
    		boolean flag = false;
        	for(int i=0; i<trace.count(); i++) {
        		String text = trace.nth(i).textContent().trim();
        		if(text.equalsIgnoreCase(endpoint)) {
        			flag = true;
        		}
        		Assert.assertTrue(flag);
        	}			
        }
    }
    
    public void validateTheNumberOfTracesPerEndpoint() throws EncryptedDocumentException, IOException {
    	String[] endpoints = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.apmDataValidationSheet, "endpoints").split(",");
    	String instance = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.tracePageSheet, "instances");
    	String status = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.tracePageSheet, "allStatus");
    	int num = Integer.parseInt(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.apmDataValidationSheet, "NumberOfTracesPerEndpoint"));
    	navigateToTracePage();
    	page.waitForTimeout(1000);
    	util.ValidateTheTitle(page, selectedInstance, instance);
    	util.ValidateTheTitle(page, selectedStatus, status);
    	for (String endpoint : endpoints) {
    		int count = 0;
    		util.selectTheOptionFromDropDownBySearch(page, endpointsDropdown, searchEndpointTextField, endpoint, endpointSearchResult);
    		page.waitForTimeout(200);
    		page.waitForSelector(traces);
    		for( ; ;) {
    			count += page.locator(traces).count();
    			if(page.isEnabled(nextPageIcon)) {
    				page.click(nextPageIcon);
    				page.waitForTimeout(300);
    				continue;
    			}
    			else
    				break;
    		}
    		System.out.println(endpoint+" : "+count);
    		Assert.assertTrue(count == num);
		}
    	
    	
    }
    
    public void closeSpanInfoWindow() {
    	try{
    		page.click(apmNav);
    	}
    	catch(Exception e){
    	{
    		try {
    			page.locator(spanInfoCloseBtn).click();
    		}
    		catch(Exception e1) {}
    		}
    	}
    }
}
