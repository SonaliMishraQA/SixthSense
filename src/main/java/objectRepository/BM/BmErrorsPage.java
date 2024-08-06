package objectRepository.BM;

import java.io.IOException;
import java.nio.file.Paths;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.List;
import java.util.Locale;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;

import com.microsoft.playwright.Download;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;

import genericUtilities.ExcelUtility;
import genericUtilities.GenericMethods;
import genericUtilities.IPathConstant;
import genericUtilities.JavaUtility;
import objectRepository.CommonPage;

public class BmErrorsPage {
	Page page;
	GenericMethods util = new GenericMethods();
	ExcelUtility excel = new ExcelUtility();
	CommonPage common = new CommonPage(page);
	JavaUtility javaUtil = new JavaUtility();
	
	private String errorsTab = "#nav-tab-errors";
	private String downloadReportBtn = "#rex-pdf-download";
    private String searchTextField = "xpath = //input[@class = 'search-box']";
    private String searchIcon = "#btn-search";
    private String clearSearchBtn = "#btn-clear-search";
    
	//************** Errors and Errors Events page elements *******************************
    
    private String firstColumn = "xpath = (//div[@class='test'])[1]";
    private String secondColumn = "xpath = (//div[@class='test'])[2]";
    private String thirdColumn = "xpath = (//div[@class='test'])[3]";
    private String fourthColumn = "xpath = (//div[@class='test'])[4]";
    private String fifthColumn = "xpath = (//div[@class='test'])[5]";
    private String sixthColumn = "xpath = (//div[@class='test'])[6]";
    private String lastOccurredAscBtn = "#sort-lastOccurrence-asc";
    private String lastOccurredDescBtn = "#sort-lastOccurrence-des";
    private String dateTimeAscBtn = "#sort-time-asc";
    private String dateTimeDescBtn = "#sort-time-des";
    private String errorsSearchResult = "xpath = //div[@class='main-row']/div[1]";
    private String errorNameColumnData = "xpath = //div[@class='main-row']/div[1]";
    private String lastOccurredColumnData = "xpath = //div[@class='main-row']/div[4]";
    private String eventsCountIcon = "#browsing_history_filled";
    private String eventsCountValue = "xpath = //span[@class='cls-col-txt']";
    private String usersColumnData = "xpath = //div[@class='main-row']/div[3]";
    private String backBtn = "xpath = //button[@class='icon-class']";
	private String eventsCountOnErrorsEventsPage = "xpath = //span[@class='icon-label']";
	private String selectFilter = "#btn-arrow-down-search-select-filters";
	private String selectedFilter = "xpath = //div[@class='select-filter']/descendant::div[@class='selected-item-text']";
	private String clearFilterLink= "xpath = //div[@class='clear-filter']";
	private String eventIdColumnData = "xpath = //span[@class='cls-col-txt cursor-pointer']";
	private String userIdColumnData = "xpath = //div[@class='main-row']/div[2]//span";
	private String browserVersionColumnData = "xpath = //div[@class='main-row']/div[3]//span";
	private String deviceColumnData = "xpath = //div[@class='main-row']/div[4]//span";
	private String osColumnData = "xpath = //div[@class='main-row']/div[5]//span";
	private String dateTimeColumnData = "xpath = //div[@class='main-row']/div[6]//span";
	private String confirmationMessage = "xpath = //div[@class='ant-notification-notice-with-icon']";
	private String messgaeCloseBtn = "xpath = //*[name()='svg' and @data-icon='close']";
    private String searchChipTexts = "xpath = //div[@class='chip-text ellipsis']";
    private String searchChipCloseBtn = "xpath = //div[@class='chip-icon']";
	private String eventIdOnEventsDetailsPage = "xpath = //span[@class='icon-label']";
    private String pageNextBtn = "xpath = //li[contains(@class,'ant-pagination-next')]/button[@class='ant-pagination-item-link']";
    private String noDataIcon = "xpath = //div[@class='inner-text']";

   	public BmErrorsPage(Page page) {
		this.page = page;
	}
	
   	public void navigateToErrorsTab() {
   		page.waitForTimeout(300);
		page.click(errorsTab);
   		page.waitForTimeout(200);
   		page.waitForURL("**/browser/errors");
		Assert.assertTrue(page.isVisible(searchTextField));
	}
   	
   	public void validateWhetherTheSearchErrorsTextFieldIsPresent() throws EncryptedDocumentException, IOException {
		String expectedText = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmErrorsSheet, "searchErrorsTextFieldPlaceHolder");
		String actualText = page.getAttribute(searchTextField, "placeholder");
		util.ValidateTheTitle(actualText, expectedText);
	}
   	
   	public void validateTheFunctionalityOfSearchErrorsForValidData() {
		util.validateSearchFunctionalityWithValidData(page,  errorNameColumnData, searchTextField, searchIcon, errorNameColumnData);
	}
   	
   	public void validateTheFunctionalityOfSearchErrorsForInvalidData() {
   		page.waitForSelector(errorNameColumnData);
		util.validateSearchFunctionalityWithInvalidData(page, searchTextField, searchIcon, noDataIcon);
	}
   	
   	public void validateTheFirstColumnTitlteInTheErrorsTable() throws EncryptedDocumentException, IOException {
		String title = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmErrorsSheet, "errorsTableFirstColumnName");
		util.ValidateTheTitle(page, firstColumn, title);
	}
   	
   	public void validateTheSecondColumnTitlteInTheErrorsTable() throws EncryptedDocumentException, IOException {
		String title = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmErrorsSheet, "errorsTableSecondColumnName");
		util.ValidateTheTitle(page, secondColumn, title);
	}
	
	public void validateTheThirdColumnTitlteInTheErrorsTable() throws EncryptedDocumentException, IOException {
		String title = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmErrorsSheet, "errorsTableThirdColumnName");
		util.ValidateTheTitle(page, thirdColumn, title);
	}
	
	public void validateTheFourthColumnTitlteInTheErrorsTable() throws EncryptedDocumentException, IOException {
		String title = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmErrorsSheet, "errorsTableFourthColumnName");
		util.ValidateTheTitle(page, fourthColumn, title);
	}
	
	public void validateTheAscendingFunctionalityOfLastOccurredColumn() {
		page.waitForSelector(lastOccurredColumnData);
		page.click(lastOccurredAscBtn);
		page.waitForTimeout(1000);
		DateTimeFormatter formatter = new DateTimeFormatterBuilder().parseCaseInsensitive().appendPattern("dd/MM/yyyy HH:mm:ss").toFormatter(Locale.ENGLISH);
        DateTimeFormatter formatter1 = new DateTimeFormatterBuilder().parseCaseInsensitive().appendPattern("yyyy/MM/dd HH:mm:ss").toFormatter(Locale.ENGLISH);
        Locator dates = page.locator(lastOccurredColumnData);
        boolean flag = false;
		if(dates.count()!=0)
        {
            int count = dates.count()-1;
            for(int i=0; i<dates.count()-1; i++)
            {
                String text1 = dates.nth(i).textContent().trim();
                String date1 = formatter1.format(formatter.parse(text1)).replace("/", " ").replace(":", " ");
                String[] time1 = date1.split(" ");
                //System.out.println(date1);
                
                String text2 = dates.nth(i+1).textContent().trim();
                String date2 = formatter1.format(formatter.parse(text2)).replace("/", " ").replace(":", " ");
                String[] time2 = date2.split(" ");
                //System.out.println(date2);

                for(int j=0; j<time1.length; j++) {
                    if(Integer.parseInt(time1[j]) <= Integer.parseInt(time2[j])) {
                        flag = true;
                        break;
                    }else if(Integer.parseInt(time1[j]) > Integer.parseInt(time2[j]))
                    {
                        flag = false;
                        break;
                    } else {
                        flag = true;
                        continue;}
                }
                if(flag==true)
                count--;
            }
            System.out.println(count);
            Assert.assertTrue(count == 0);
        }
    }
	
	public void validateTheDescendingFunctionalityOfLastOccurredColumn() {
		page.waitForSelector(lastOccurredColumnData);
		page.click(lastOccurredDescBtn);
		page.waitForTimeout(1000);
		DateTimeFormatter formatter = new DateTimeFormatterBuilder().parseCaseInsensitive().appendPattern("dd/MM/yyyy HH:mm:ss").toFormatter(Locale.ENGLISH);
        DateTimeFormatter formatter1 = new DateTimeFormatterBuilder().parseCaseInsensitive().appendPattern("yyyy/MM/dd HH:mm:ss").toFormatter(Locale.ENGLISH);
        Locator dates = page.locator(lastOccurredColumnData);
        boolean flag = false;
		if(dates.count()!=0)
        {
            int count = dates.count()-1;
            for(int i=0; i<dates.count()-1; i++)
            {
                String text1 = dates.nth(i).textContent().trim();
                String date1 = formatter1.format(formatter.parse(text1)).replace("/", " ").replace(":", " ");
                String[] time1 = date1.split(" ");
                //System.out.println(date1);
                
                String text2 = dates.nth(i+1).textContent().trim();
                String date2 = formatter1.format(formatter.parse(text2)).replace("/", " ").replace(":", " ");
                String[] time2 = date2.split(" ");
                //System.out.println(date2);

                for(int j=0; j<time1.length; j++) {
                    if(Integer.parseInt(time1[j]) >= Integer.parseInt(time2[j])) {
                        flag = true;
                        break;
                    }else if(Integer.parseInt(time1[j]) < Integer.parseInt(time2[j]))
                    {
                        flag = false;
                        break;
                    } else {
                        flag = true;
                        continue;}
                }
                if(flag==true)
                count--;
            }
            System.out.println(count);
            Assert.assertTrue(count == 0);
        }
    }
	
   	public int getEventsTotalFromTable() {
   		page.waitForSelector(eventsCountValue);
   		int sum = 0;
   		Locator events = page.locator(eventsCountValue);
   		for(int i=0; i<events.count(); i++) {
   			sum = sum + Integer.parseInt(events.nth(i).textContent().trim());
   		}
   		return sum;
   	}
   	
   	public void validatePagination(int num) {
		common.selectPaginationAndValidate(page, num, errorNameColumnData);
	}
	
   	public void validateWhetherTheDownloadReportButtonIsActive(){
   		page.waitForTimeout(1000);
		Assert.assertTrue(!page.getAttribute(downloadReportBtn, "class").contains("disabled"));
	}
   	
   	public void validateFunctionalityOfDownloadReportInErrorsPage() throws EncryptedDocumentException, IOException {
    	String message = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath, IPathConstant.messageSheet, "BmErrorsPage_downloadReportConfirmationMessage");
    	Download download = page.waitForDownload(() -> {page.locator(downloadReportBtn).click();});
    	Assert.assertTrue(page.textContent(confirmationMessage).trim().contains(message));	
    	System.out.println("Message validated");
    	page.click(messgaeCloseBtn);
    	String filePath = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmErrorsSheet, "downloadReportFilePath");
    	String fileName = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmErrorsSheet, "BmEventsDetailsPageDownloadReportFileName");
    	download.saveAs(Paths.get(filePath, fileName));
    	System.out.println("File downloaded");
    	String fName = javaUtil.getLatestFilefromDir(filePath).getName();
    	System.out.println(fName +"\t"+fileName);
    	Assert.assertTrue(fName.equalsIgnoreCase(fileName));
    	javaUtil.deleteFile(filePath, fileName);
    }
   	
   	public void navigateToErrorsEventsPage() {
   		page.locator(eventsCountIcon).first().click();
   		page.waitForSelector(eventIdColumnData);
   		Assert.assertTrue(page.url().contains("/browser/errors/events")); 
   		Assert.assertTrue(page.isVisible(selectFilter));
   	}
   	
   	public void validateTheNumberOfEventsInErrorsEventsPageHeader() {
   		String eventCount = page.locator(eventsCountValue).first().textContent().trim();
   		navigateToErrorsEventsPage();
   		page.waitForSelector(eventIdColumnData);
   		String expectedEventsCount = "Events ( " + eventCount+ " )";
   		String actualEventsCount = page.textContent(eventsCountOnErrorsEventsPage).trim();
   		util.ValidateTheTitle(actualEventsCount, expectedEventsCount);
   	}
   	
   	public void validateTheNumberOfEventsInErrorsEventsPageTable() {
   		String eventCount = page.locator(eventsCountValue).first().textContent().trim();
   		navigateToErrorsEventsPage();
   		page.waitForSelector(eventIdColumnData);
   		int expectedEventsCount = Integer.parseInt(eventCount);
   		int actualEventsCount = 0;
   		for( ; ; ) {
   			System.out.println(page.locator(eventIdColumnData).count());
   			actualEventsCount = actualEventsCount + page.locator(eventIdColumnData).count();
   			if(page.isDisabled(pageNextBtn)) {
   				break;
   			}
   			else {
   				page.click(pageNextBtn);
   				page.waitForTimeout(1500);
   		   		page.waitForSelector(eventIdColumnData);
   			}
   		}
   		System.out.println("expectedEventsCount : "+expectedEventsCount+"\tactualEventsCount : "+actualEventsCount);
   		Assert.assertTrue(actualEventsCount == expectedEventsCount);
   	}
   	
   	public void validateFunctionalityOfDownloadReportInErrorsEventsPage() throws EncryptedDocumentException, IOException {
    	String message = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath, IPathConstant.messageSheet, "BmErrorsPage_downloadReportConfirmationMessage");
    	Download download = page.waitForDownload(() -> {page.locator(downloadReportBtn).click();});
    	Assert.assertTrue(page.textContent(confirmationMessage).trim().contains(message));	
    	System.out.println("Message validated");
    	page.click(messgaeCloseBtn);
    	String filePath = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmErrorsSheet, "downloadReportFilePath");
    	String fileName = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmErrorsSheet, "BmErrorsEventsPageDownloadReportFileName");
    	download.saveAs(Paths.get(filePath, fileName));
    	System.out.println("File downloaded");
    	String fName = javaUtil.getLatestFilefromDir(filePath).getName();
    	System.out.println(fName +"\t"+fileName);
    	Assert.assertTrue(fName.equalsIgnoreCase(fileName));
    	javaUtil.deleteFile(filePath, fileName);
    }
   	
   	public void validateTheFirstColumnTitlteInTheErrorsEventsTable() throws EncryptedDocumentException, IOException {
   		navigateToErrorsEventsPage();
   		String title = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmErrorsSheet, "errorsEventsTableFirstColumnName");
		util.ValidateTheTitle(page, firstColumn, title);
	}
   	
   	public void validateTheSecondColumnTitlteInTheErrorsEventsTable() throws EncryptedDocumentException, IOException {
   		navigateToErrorsEventsPage();
   		String title = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmErrorsSheet, "errorsEventsTableSecondColumnName");
		util.ValidateTheTitle(page, secondColumn, title);
	}
   	
   	public void validateTheThirdColumnTitlteInTheErrorsEventsTable() throws EncryptedDocumentException, IOException {
   		navigateToErrorsEventsPage();
   		String title = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmErrorsSheet, "errorsEventsTableThirdColumnName");
		util.ValidateTheTitle(page, thirdColumn, title);
	}
   	
   	public void validateTheFourthColumnTitlteInTheErrorsEventsTable() throws EncryptedDocumentException, IOException {
   		navigateToErrorsEventsPage();
   		String title = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmErrorsSheet, "errorsEventsTableFourthColumnName");
		util.ValidateTheTitle(page, fourthColumn, title);
	}
   	
   	public void validateTheFifthColumnTitlteInTheErrorsEventsTable() throws EncryptedDocumentException, IOException {
   		navigateToErrorsEventsPage();
   		String title = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmErrorsSheet, "errorsEventsTableFifthColumnName");
		util.ValidateTheTitle(page, fifthColumn, title);
	}
   	
   	public void validateTheSixthColumnTitlteInTheErrorsEventsTable() throws EncryptedDocumentException, IOException {
   		navigateToErrorsEventsPage();
   		String title = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmErrorsSheet, "errorsEventsTableSixthColumnName");
		util.ValidateTheTitle(page, sixthColumn, title);
	}
   	
   	public void validateTheAscendingFunctionalityOfDateAndTimeColumn() {
		page.waitForSelector(dateTimeColumnData);
		page.click(dateTimeAscBtn);
		page.waitForTimeout(1000);
		DateTimeFormatter formatter = new DateTimeFormatterBuilder().parseCaseInsensitive().appendPattern("dd/MM/yyyy HH:mm:ss").toFormatter(Locale.ENGLISH);
        DateTimeFormatter formatter1 = new DateTimeFormatterBuilder().parseCaseInsensitive().appendPattern("yyyy/MM/dd HH:mm:ss").toFormatter(Locale.ENGLISH);
        Locator dates = page.locator(dateTimeColumnData);
        boolean flag = false;
		if(dates.count()!=0)
        {
            int count = dates.count()-1;
            for(int i=0; i<dates.count()-1; i++)
            {
                String text1 = dates.nth(i).textContent().trim();
                String date1 = formatter1.format(formatter.parse(text1)).replace("/", " ").replace(":", " ");
                String[] time1 = date1.split(" ");
                System.out.println(date1);
                
                String text2 = dates.nth(i+1).textContent().trim();
                String date2 = formatter1.format(formatter.parse(text2)).replace("/", " ").replace(":", " ");
                String[] time2 = date2.split(" ");
                System.out.println(date2);

                for(int j=0; j<time1.length; j++) {
                    if(Integer.parseInt(time1[j]) <= Integer.parseInt(time2[j])) {
                        flag = true;
                        break;
                    }else if(Integer.parseInt(time1[j]) > Integer.parseInt(time2[j]))
                    {
                        flag = false;
                        break;
                    } else {
                        flag = true;
                        continue;}
                }
                if(flag==true)
                count--;
            }
            System.out.println(count);
            Assert.assertTrue(count == 0);
        }
    }
   	
   	public void validateTheDescendingFunctionalityOfDateAndTimeColumn() {
		page.waitForSelector(dateTimeColumnData);
		page.click(dateTimeDescBtn);
		page.waitForTimeout(1000);
		DateTimeFormatter formatter = new DateTimeFormatterBuilder().parseCaseInsensitive().appendPattern("dd/MM/yyyy HH:mm:ss").toFormatter(Locale.ENGLISH);
        DateTimeFormatter formatter1 = new DateTimeFormatterBuilder().parseCaseInsensitive().appendPattern("yyyy/MM/dd HH:mm:ss").toFormatter(Locale.ENGLISH);
        Locator dates = page.locator(dateTimeColumnData);
        boolean flag = false;
		if(dates.count()!=0)
        {
            int count = dates.count()-1;
            for(int i=0; i<dates.count()-1; i++)
            {
                String text1 = dates.nth(i).textContent().trim();
                String date1 = formatter1.format(formatter.parse(text1)).replace("/", " ").replace(":", " ");
                String[] time1 = date1.split(" ");
                System.out.println(date1);
                
                String text2 = dates.nth(i+1).textContent().trim();
                String date2 = formatter1.format(formatter.parse(text2)).replace("/", " ").replace(":", " ");
                String[] time2 = date2.split(" ");
                System.out.println(date2);

                for(int j=0; j<time1.length; j++) {
                    if(Integer.parseInt(time1[j]) >= Integer.parseInt(time2[j])) {
                        flag = true;
                        break;
                    }else if(Integer.parseInt(time1[j]) < Integer.parseInt(time2[j]))
                    {
                        flag = false;
                        break;
                    } else {
                        flag = true;
                        continue;}
                }
                if(flag==true)
                count--;
            }
            System.out.println(count);
            Assert.assertTrue(count == 0);
        }
    }
   	
   	public void validateTheDefaultTextOnSelectFilterDropdown() throws EncryptedDocumentException, IOException {
   		String expectedText = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmErrorsSheet, "selectFilterDropdownDefaultText");
		String actualText = page.textContent(selectedFilter).trim();
		util.ValidateTheTitle(actualText, expectedText);
   	}
   	
   	public void validateWhetherSearchFeatureIsDisabledWhenFilterIsNotSelected() {
   		Assert.assertTrue(page.getAttribute(searchIcon, "class").contains("disabled"));
   	}
   	
   	public void validateSearchByEventIdForValidData() throws EncryptedDocumentException, IOException {
   		String option = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmErrorsSheet, "errorsEventsTableFirstColumnName");
   		util.selectTheOptionFromDropDown(page, selectFilter, option);
   		util.validateSearchFunctionalityWithValidData(page, eventIdColumnData, searchTextField, searchIcon, eventIdColumnData);
   		String chipText = option.replace(" ", "")+" | "+page.locator(eventIdColumnData).nth(0).textContent().trim();
   		System.out.println(chipText +"\t"+page.textContent(searchChipTexts).trim());
   		Assert.assertTrue(page.textContent(searchChipTexts).trim().equalsIgnoreCase(chipText));
   	}
   	
   	public void validateSearchByEventIdForInvalidData() throws EncryptedDocumentException, IOException {
   		String option = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmErrorsSheet, "errorsEventsTableFirstColumnName");
   		util.selectTheOptionFromDropDown(page, selectFilter, option);
   		util.validateSearchFunctionalityWithInvalidData(page, searchTextField, searchIcon, eventIdColumnData);
   	}
   	
   	public void validateSearchByUserIdForValidData() throws EncryptedDocumentException, IOException {
   		String option = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmErrorsSheet, "errorsEventsTableSecondColumnName");
   		util.selectTheOptionFromDropDown(page, selectFilter, option);
   		util.validateSearchFunctionalityWithValidData(page, userIdColumnData, searchTextField, searchIcon, userIdColumnData);
   		String chipText = option.replace(" ", "")+" | "+page.locator(userIdColumnData).nth(0).textContent().trim();
   		System.out.println(chipText +"\t"+page.textContent(searchChipTexts).trim());
   		Assert.assertTrue(page.textContent(searchChipTexts).trim().equalsIgnoreCase(chipText));
   	}
   	
   	public void validateSearchByUserIdForInvalidData() throws EncryptedDocumentException, IOException {
   		String option = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmErrorsSheet, "errorsEventsTableSecondColumnName");
   		util.selectTheOptionFromDropDown(page, selectFilter, option);
   		util.validateSearchFunctionalityWithInvalidData(page, searchTextField, searchIcon, userIdColumnData);
   	}
   	
   	public void validateSearchByBrowserAndVersionForValidData() throws EncryptedDocumentException, IOException {
   		String option = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmErrorsSheet, "errorsEventsTableThirdColumnName");
   		util.selectTheOptionFromDropDown(page, selectFilter, option);
   		util.validateSearchFunctionalityWithValidData(page, browserVersionColumnData, searchTextField, searchIcon, browserVersionColumnData);
   		String chipText = option.replace(" & version", "")+" | "+page.locator(browserVersionColumnData).nth(0).textContent().trim();
   		System.out.println(chipText +"\t"+page.textContent(searchChipTexts).trim());
   		Assert.assertTrue(page.textContent(searchChipTexts).trim().equalsIgnoreCase(chipText));
   	}
   	
   	public void validateSearchByBrowserAndVersionForInvalidData() throws EncryptedDocumentException, IOException {
   		String option = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmErrorsSheet, "errorsEventsTableThirdColumnName");
   		util.selectTheOptionFromDropDown(page, selectFilter, option);
   		util.validateSearchFunctionalityWithInvalidData(page, searchTextField, searchIcon, browserVersionColumnData);
   	}
   	
   	public void validateSearchByDeviceForValidData() throws EncryptedDocumentException, IOException {
   		String option = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmErrorsSheet, "errorsEventsTableFourthColumnName");
   		util.selectTheOptionFromDropDown(page, selectFilter, option);
   		util.validateSearchFunctionalityWithValidData(page, deviceColumnData, searchTextField, searchIcon, deviceColumnData);
   		String chipText = option.replace(" ", "")+" | "+page.locator(deviceColumnData).nth(0).textContent().trim();
   		System.out.println(chipText +"\t"+page.textContent(searchChipTexts).trim());
   		Assert.assertTrue(page.textContent(searchChipTexts).trim().equalsIgnoreCase(chipText));
   	}   	
   	
   	public void validateSearchByDeviceForInvalidData() throws EncryptedDocumentException, IOException {
   		String option = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmErrorsSheet, "errorsEventsTableFourthColumnName");
   		util.selectTheOptionFromDropDown(page, selectFilter, option);
   		util.validateSearchFunctionalityWithInvalidData(page, searchTextField, searchIcon, deviceColumnData);
   	}
   	
   	public void validateSearchByOsForValidData() throws EncryptedDocumentException, IOException {
   		String option = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmErrorsSheet, "errorsEventsTableFifthColumnName");
   		util.selectTheOptionFromDropDown(page, selectFilter, option);
   		util.validateSearchFunctionalityWithValidData(page, osColumnData, searchTextField, searchIcon, osColumnData);
   		String chipText = option.replace(" ", "")+" | "+page.locator(osColumnData).nth(0).textContent().trim();
   		System.out.println(chipText +"\t"+page.textContent(searchChipTexts).trim());
   		Assert.assertTrue(page.textContent(searchChipTexts).trim().equalsIgnoreCase(chipText));
   	}  
   	
   	public void validateSearchByOsForInvalidData() throws EncryptedDocumentException, IOException {
   		String option = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmErrorsSheet, "errorsEventsTableFifthColumnName");
   		util.selectTheOptionFromDropDown(page, selectFilter, option);
   		util.validateSearchFunctionalityWithInvalidData(page, searchTextField, searchIcon, osColumnData);
   	}  
   	
   	public void validateSearchChipForMultipleSearches() throws EncryptedDocumentException, IOException {
   		String option = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmErrorsSheet, "errorsEventsTableFirstColumnName");
   		util.selectTheOptionFromDropDown(page, selectFilter, option);
   		util.validateSearchFunctionalityWithValidData(page, eventIdColumnData, searchTextField, searchIcon, eventIdColumnData);
   		String option1 = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmErrorsSheet, "errorsEventsTableSecondColumnName");
   		util.selectTheOptionFromDropDown(page, selectFilter, option1);
   		util.validateSearchFunctionalityWithValidData(page, userIdColumnData, searchTextField, searchIcon, userIdColumnData);
   		String option2 = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmErrorsSheet, "errorsEventsTableFourthColumnName");
   		util.selectTheOptionFromDropDown(page, selectFilter, option2);
   		util.validateSearchFunctionalityWithValidData(page, deviceColumnData, searchTextField, searchIcon, deviceColumnData);
   		Locator chips = page.locator(searchChipTexts);
   		Assert.assertTrue(chips.count() == 3);
   		int count = 0;
   		for(int i=0; i<chips.count(); i++) {
   			if(chips.nth(i).textContent().trim().contains(option.replace(" ", "").toUpperCase()) || 
   				chips.nth(i).textContent().trim().contains(option1.replace(" ", "").toUpperCase()) || 
   				chips.nth(i).textContent().trim().contains(option2.toUpperCase())) {
   				count++;
   			}	
   		}
   		Assert.assertTrue(count == 3);
   	}
   	
   	public void validateTheFunctionalityOfSearchChipCloseButton() throws EncryptedDocumentException, IOException {
   		String option = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmErrorsSheet, "errorsEventsTableFirstColumnName");
   		util.selectTheOptionFromDropDown(page, selectFilter, option);
   		util.validateSearchFunctionalityWithValidData(page, eventIdColumnData, searchTextField, searchIcon, eventIdColumnData);
   		String option1 = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmErrorsSheet, "errorsEventsTableSecondColumnName");
   		util.selectTheOptionFromDropDown(page, selectFilter, option1);
   		util.validateSearchFunctionalityWithValidData(page, userIdColumnData, searchTextField, searchIcon, userIdColumnData);
   		String option2 = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmErrorsSheet, "errorsEventsTableFourthColumnName");
   		util.selectTheOptionFromDropDown(page, selectFilter, option2);
   		util.validateSearchFunctionalityWithValidData(page, deviceColumnData, searchTextField, searchIcon, deviceColumnData);
   		Locator chips = page.locator(searchChipTexts);
   		Assert.assertTrue(chips.count() == 3);
   		Assert.assertTrue(page.isVisible(clearFilterLink));
   		page.locator(searchChipCloseBtn).nth(0).click();
   		Assert.assertTrue(chips.count() == 2);
   		page.locator(searchChipCloseBtn).nth(0).click();
   		Assert.assertTrue(chips.count() == 1);
   		page.locator(searchChipCloseBtn).nth(0).click();
   		Assert.assertTrue(chips.count() == 0);
   	}
   	
   	public void validateTheFunctionalityOfClearFilterButton() throws EncryptedDocumentException, IOException {
   		String option = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmErrorsSheet, "errorsEventsTableFirstColumnName");
   		util.selectTheOptionFromDropDown(page, selectFilter, option);
   		util.validateSearchFunctionalityWithValidData(page, eventIdColumnData, searchTextField, searchIcon, eventIdColumnData);
   		String option1 = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmErrorsSheet, "errorsEventsTableSecondColumnName");
   		util.selectTheOptionFromDropDown(page, selectFilter, option1);
   		util.validateSearchFunctionalityWithValidData(page, userIdColumnData, searchTextField, searchIcon, userIdColumnData);
   		String option2 = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmErrorsSheet, "errorsEventsTableFourthColumnName");
   		util.selectTheOptionFromDropDown(page, selectFilter, option2);
   		util.validateSearchFunctionalityWithValidData(page, deviceColumnData, searchTextField, searchIcon, deviceColumnData);
   		Locator chips = page.locator(searchChipTexts);
   		Assert.assertTrue(chips.count() == 3);
   		Assert.assertTrue(page.isVisible(clearFilterLink));
   		page.click(clearFilterLink);
   		Assert.assertTrue(chips.count() == 0);
   		validateTheDefaultTextOnSelectFilterDropdown();
   	}
   	
   	public void validateTheFunctionalityOfBackButtonInErrorsEventsPage() throws EncryptedDocumentException, IOException {
   		page.click(backBtn);
   		page.waitForURL("**/browser/errors");
   		validateWhetherTheSearchErrorsTextFieldIsPresent();
   	}
   	
   	public void validateNavigationToEventsDetsilsPageByClickingOnEventId() {
   		String eventId = page.locator(eventIdColumnData).first().textContent().trim();
   		page.locator(eventIdColumnData).first().click();
   		page.waitForURL("**/errors/events/details");
   		page.waitForSelector(eventIdOnEventsDetailsPage);
   		Assert.assertTrue(page.textContent(eventIdOnEventsDetailsPage).trim().equalsIgnoreCase(eventId));
   	}
   	
   	public void validateNavigationToEventsDetsilsPageByClickingOnUserId() {
   		String eventId = page.locator(eventIdColumnData).first().textContent().trim();
   		page.locator(userIdColumnData).first().click();
   		page.waitForSelector(eventIdOnEventsDetailsPage);
   		Assert.assertTrue(page.textContent(eventIdOnEventsDetailsPage).trim().equalsIgnoreCase(eventId));
   	}
   	
   	public void validateNavigationToEventsDetsilsPageByClickingOnBrowserAndVersion() {
   		String eventId = page.locator(eventIdColumnData).first().textContent().trim();
   		page.locator(browserVersionColumnData).first().click();
   		page.waitForSelector(eventIdOnEventsDetailsPage);
   		Assert.assertTrue(page.textContent(eventIdOnEventsDetailsPage).trim().equalsIgnoreCase(eventId));
   	}
   	
   	public void validateNavigationToEventsDetsilsPageByClickingOnDevice() {
   		String eventId = page.locator(eventIdColumnData).first().textContent().trim();
   		page.locator(deviceColumnData).first().click();
   		page.waitForSelector(eventIdOnEventsDetailsPage);
   		Assert.assertTrue(page.textContent(eventIdOnEventsDetailsPage).trim().equalsIgnoreCase(eventId));
   	}
   	
   	public void validateNavigationToEventsDetsilsPageByClickingOnOs() {
   		String eventId = page.locator(eventIdColumnData).first().textContent().trim();
   		page.locator(osColumnData).first().click();
   		page.waitForSelector(eventIdOnEventsDetailsPage);
   		Assert.assertTrue(page.textContent(eventIdOnEventsDetailsPage).trim().equalsIgnoreCase(eventId));
   	}
   	
   	public void validateNavigationToEventsDetsilsPageByClickingOnDateAndTime() {
   		String eventId = page.locator(eventIdColumnData).first().textContent().trim();
   		page.locator(dateTimeColumnData).first().click();
   		page.waitForSelector(eventIdOnEventsDetailsPage);
   		Assert.assertTrue(page.textContent(eventIdOnEventsDetailsPage).trim().equalsIgnoreCase(eventId));
   	}
   	
   	public String fetchFirstDateAndTimeFromErrorsEventsPage() {
		return page.locator(dateTimeColumnData).nth(0).textContent().trim();
	}
   	
   	public void validateUserIdAndEventId(List<String> eventList, List<String> userList) throws EncryptedDocumentException, IOException {
   		String application = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmDataValidationSheet, "reactApplicationName");
		new CommonPage(page).selectTheTimeLineFromCalender(IPathConstant.fiveMinutesTimeRange);
		new BmApplicationPage(page).selectApplication(application);
		page.waitForLoadState(LoadState.NETWORKIDLE);
		page.waitForTimeout(2000);
   		navigateToErrorsTab();
   		navigateToErrorsEventsPage();
   		new CommonPage(page).selectTheTimeLineFromCalender(IPathConstant.fiveMinutesTimeRange);
   		page.waitForSelector(userIdColumnData);
   		Locator userIds = page.locator(userIdColumnData);
   		for (String uid : userList) {
			boolean flag = false;
			for(int i=0; i<userIds.count(); i++) {
				if(userIds.nth(i).textContent().trim().equalsIgnoreCase(uid)) {
					flag = true;
					break;
				}
			}
			Assert.assertTrue(flag);
		}
   		Locator eventIds = page.locator(eventIdColumnData);
   		for (String eid : eventList) {
			boolean flag = false;
			for(int i=0; i<eventIds.count(); i++) {
				if(eventIds.nth(i).textContent().trim().equalsIgnoreCase(eid)) {
					flag = true;
					break;
				}
			}
			Assert.assertTrue(flag);
		}
   	}
}
