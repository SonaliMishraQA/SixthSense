package objectRepository.BM;

import java.io.IOException;
import java.nio.file.Paths;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Locale;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;

import com.microsoft.playwright.Download;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import genericUtilities.ExcelUtility;
import genericUtilities.GenericMethods;
import genericUtilities.IPathConstant;
import genericUtilities.JavaUtility;
import objectRepository.CommonPage;

public class BmEventsDetailsPage {
	Page page;
	GenericMethods util = new GenericMethods();
	ExcelUtility excel = new ExcelUtility();
	CommonPage common = new CommonPage(page);
	JavaUtility javaUtil = new JavaUtility();
	BmErrorsPage bmErrors;
	
	private String errorsTab = "#nav-tab-errors";
	private String downloadReportBtn = "#rex-pdf-download";
    private String searchTextField = "xpath = //input[@class = 'search-box']";
    private String searchIcon = "#btn-search";
    private String clearSearchBtn = "#btn-clear-search";
    
	private String selectFilter = "#btn-arrow-down-search-select-filters";
	private String confirmationMessage = "xpath = //div[@class='ant-notification-notice-with-icon']";
	private String messgaeCloseBtn = "xpath = //*[name()='svg' and @data-icon='close']";
    

	//************** Events Details page elements *******************************

	private String eventIdOnEventsDetailsPage = "xpath = //span[@class='icon-label']";
	private String backBtn = "xpath = //button[@class='icon-class']";
	private String copyBtn = "xpath = //button[@class='icon']";
	private String copyBtnTooltip = "xpath = //div[@class='rk-tooltip-inner']";
	private String apmTraceBtn = "#btn-apm-trace";
	
	private String firstColumn = "xpath = (//div[@class='test'])[1]";
    private String secondColumn = "xpath = (//div[@class='test'])[2]";
    private String thirdColumn = "xpath = (//div[@class='test'])[3]";
    private String fourthColumn = "xpath = (//div[@class='test'])[4]";
    private String fifthColumn = "xpath = (//div[@class='test'])[5]";
    
    private String attributeKeys = "xpath = //div[@class='key']";
    private String attributeValues = "xpath = //div[@class='key']/following-sibling::span";
    private String exceptionExpansionBtn = "xpath = //span[.='Exception']/parent::header/descendant::*[name()='svg']";
    private String exceptionData = "xpath = //span[.='Exception']/parent::header/following-sibling::div[@class='data']";
    private String exceptionTitle = "xpath = //*[name()='svg' and contains(@class,'bi bi-chevron-up')]/ancestor::button/preceding-sibling::span[@class='title']";
    private String breadCrumbTitle = "xpath = //div[@class='topbar route-toolbar']/span[@class='breadcrumblbl']";
    private String timeAscBtn = "#sort-timestampEpoc-asc";
    private String timeDescBtn = "#sort-timestampEpoc-des";
    private String selectFilterDropdown = "xpath = //div[contains(@class,'cls-generic-filter-select')]//div[@class='selected-item-text']";
    private String selectFilterOptions = "xpath = //span[@class='filter-item-name']";
    private String noDataIcon = "xpath = //div[@class='inner-text']";
    private String firstElement = "xpath = (//div[@class='main-row']//span)[2]";
    private String timeValues = "xpath = (//span[@class='td-span'])[position() mod 4 = 0]";
    private String categoryValues = "xpath = (//span[@class='td-span'])[position() mod 4 =1]/span";
    private String descriptionValues = "xpath = (//span[@class='td-span'])[position() mod 4 =2]";
    private String levelValues = "xpath = (//span[@class='td-span'])[position() mod 4 =3]/span";
    private String typeIcons = "xpath = //div[@class='main-row']//*[name()='svg']";
    private String searchResultRows = "xpath = //div[@class='main-row']";
    private String levelFilterOptions = "xpath = //span[.='Level']/ancestor::div[@class='filter-level']/following-sibling::div[@class='option']/descendant::span[@class='filter-item-name']";
    private String typeFilterOptions = "xpath = //span[.='Type']/ancestor::div[@class='filter-level']/following-sibling::div[@class='option']/descendant::span[@class='filter-item-name']";
    private String pagePreviousBtn = "xpath = //li[contains(@class,'ant-pagination-prev')]/button[@class='ant-pagination-item-link']";
    private String pageNextBtn = "xpath = //li[contains(@class,'ant-pagination-next')]/button[@class='ant-pagination-item-link']";
    private String typeIconForHttp = "xpath = //div[@class='main-row']//*[name()='svg']//*[name()='circle' and @id='Ellipse_1']";
    private String clearFilterOption = "xpath = //div[@class='clear-filter']";

    public BmEventsDetailsPage(Page page) {
		this.page = page;
	}
	
   	public void validateTheFunctionalityOfBackButtonInEventsDetailsPage() throws EncryptedDocumentException, IOException {
   		page.click(backBtn);
   		page.waitForURL("**/browser/errors/events");
   		Assert.assertTrue(page.isVisible(selectFilter));
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
    	String fileName = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmErrorsSheet, "BmErrorsPageDownloadReportFileName");
    	download.saveAs(Paths.get(filePath, fileName));
    	System.out.println("File downloaded");
    	String fName = javaUtil.getLatestFilefromDir(filePath).getName();
    	System.out.println(fName +"\t"+fileName);
    	Assert.assertTrue(fName.equalsIgnoreCase(fileName));
    	javaUtil.deleteFile(filePath, fileName);
    }
   	
   	public void validateFunctionalityOfEventIdCopyButtonInEnentsDetailsPage() throws EncryptedDocumentException, IOException {
        page.hover(copyBtn);
        String expectedTooltip = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmErrorsSheet, "copyTooltipText");
        System.out.println(expectedTooltip);
        System.out.println(page.textContent(copyBtnTooltip).trim());
        Assert.assertTrue(page.textContent(copyBtnTooltip).trim().equals(expectedTooltip));
        String expectedMessage = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmErrorsSheet, "copyConfirmationMessage");
        page.click(copyBtn);
        page.waitForSelector(confirmationMessage);
        Assert.assertTrue(page.textContent(confirmationMessage).trim().contains(expectedMessage));
        page.click(messgaeCloseBtn);
	}
   	
   	public void validateWhetherTheApplicationKeyIsDisplayedInEnentsDetailsPage() throws EncryptedDocumentException, IOException {
   		validateTheKeyName(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmErrorsSheet, "EventsDetailsPage_ApplicationKey"));
   	}
   	
   	public void validateWhetherTheApplicationVersionKeyIsDisplayedInEnentsDetailsPage() throws EncryptedDocumentException, IOException {
   		validateTheKeyName(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmErrorsSheet, "EventsDetailsPage_ApplicationVersionKey"));
   	}
   	
   	public void validateWhetherTheEnvironmentKeyIsDisplayedInEnentsDetailsPage() throws EncryptedDocumentException, IOException {
   		validateTheKeyName(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmErrorsSheet, "EventsDetailsPage_EnvironmentKey"));
   	}
   	
   	public void validateWhetherTheErrorUrlKeyIsDisplayedInEnentsDetailsPage() throws EncryptedDocumentException, IOException {
   		validateTheKeyName(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmErrorsSheet, "EventsDetailsPage_ErrorUrlKey"));
   	}
   	
   	public void validateWhetherThePagePathKeyIsDisplayedInEnentsDetailsPage() throws EncryptedDocumentException, IOException {
   		validateTheKeyName(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmErrorsSheet, "EventsDetailsPage_PagePathKey"));
   	}
   	
   	public void validateWhetherTheErrorKeyIsDisplayedInEnentsDetailsPage() throws EncryptedDocumentException, IOException {
   		validateTheKeyName(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmErrorsSheet, "EventsDetailsPage_ErrorKey"));
   	}
   	
   	public void validateWhetherTheCategoryKeyIsDisplayedInEnentsDetailsPage() throws EncryptedDocumentException, IOException {
   		validateTheKeyName(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmErrorsSheet, "EventsDetailsPage_CategoryKey"));
   	}
   	
   	public void validateWhetherTheTimeKeyIsDisplayedInEnentsDetailsPage() throws EncryptedDocumentException, IOException {
   		validateTheKeyName(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmErrorsSheet, "EventsDetailsPage_TimeKey"));
   	}
   	
   	public void validateWhetherTheErrorTypeKeyIsDisplayedInEnentsDetailsPage() throws EncryptedDocumentException, IOException {
   		validateTheKeyName(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmErrorsSheet, "EventsDetailsPage_ErrorTypeKey"));
   	}
   	
   	public void validateWhetherTheMessageKeyIsDisplayedInEnentsDetailsPage() throws EncryptedDocumentException, IOException {
   		validateTheKeyName(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmErrorsSheet, "EventsDetailsPage_MessageKey"));
   	}
   	
   	public void validateWhetherTheNameKeyIsDisplayedInEnentsDetailsPage() throws EncryptedDocumentException, IOException {
   		validateTheKeyName(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmErrorsSheet, "EventsDetailsPage_NameKey"));
   	}
   	
   	public void validateWhetherTheVersionKeyIsDisplayedInEnentsDetailsPage() throws EncryptedDocumentException, IOException {
   		validateTheKeyName(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmErrorsSheet, "EventsDetailsPage_VersionKey"));
   	}
   	
   	public void validateWhetherTheUserAgentKeyIsDisplayedInEnentsDetailsPage() throws EncryptedDocumentException, IOException {
   		validateTheKeyName(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmErrorsSheet, "EventsDetailsPage_UserAgentKey"));
   	}
   	
   	public void validateTheKeyName(String expectedKey) throws EncryptedDocumentException, IOException {
   		Locator keys = page.locator(attributeKeys);
   		boolean flag = false;
   		for(int i=0; i<keys.count(); i++) {
   			if(keys.nth(i).textContent().trim().equalsIgnoreCase(expectedKey)) {
   				System.out.println(keys.nth(i).textContent().trim()+"\t"+expectedKey);
   				flag = true;
   				break;
   			}
   		}
   		Assert.assertTrue(flag);
   	}
   	
   	public void validateTheDefaultStateOfExceptionExpansionButtonInEnentsDetailsPage() {
   		Assert.assertTrue(page.getAttribute(exceptionExpansionBtn, "class").contains("up"));
   		Assert.assertTrue(page.isVisible(exceptionData));
   	}
   	
	public void validateTheFunctionalityOfExceptionExpansionButtonInEnentsDetailsPage() {
		page.click(exceptionExpansionBtn);
   		Assert.assertTrue(page.getAttribute(exceptionExpansionBtn, "class").contains("down"));
   		Assert.assertTrue(page.isHidden(exceptionData));
   	}
	
	public void validateTheTitleOfBreadcrumbSectionInEnentsDetailsPage() throws EncryptedDocumentException, IOException {
		util.ValidateTheTitle(page, breadCrumbTitle, excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmErrorsSheet, "breadcrumbSectionTitle"));
	}
	
	public void validateTheTitleOfFirstColumnOfBreadcrumbTableInEnentsDetailsPage () throws EncryptedDocumentException, IOException {
		util.ValidateTheTitle(page, firstColumn, excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmErrorsSheet, "breadcrumbSection_FirstColumnName"));
	}
	
	public void validateTheTitleOfSecondColumnOfBreadcrumbTableInEnentsDetailsPage () throws EncryptedDocumentException, IOException {
		util.ValidateTheTitle(page, secondColumn, excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmErrorsSheet, "breadcrumbSection_SecondColumnName"));
	}
	
	public void validateTheTitleOfThirdColumnOfBreadcrumbTableInEnentsDetailsPage () throws EncryptedDocumentException, IOException {
		util.ValidateTheTitle(page, thirdColumn, excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmErrorsSheet, "breadcrumbSection_ThirdColumnName"));
	}
	
	public void validateTheTitleOfFourthColumnOfBreadcrumbTableInEnentsDetailsPage () throws EncryptedDocumentException, IOException {
		util.ValidateTheTitle(page, fourthColumn, excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmErrorsSheet, "breadcrumbSection_FourthColumnName"));
	}
	
	public void validateTheTitleOfFifthColumnOfBreadcrumbTableInEnentsDetailsPage () throws EncryptedDocumentException, IOException {
		util.ValidateTheTitle(page, fifthColumn, excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmErrorsSheet, "breadcrumbSection_FifthColumnName"));
	}
	
	public void validateTheAscendingFunctionalityOfTimeColumn() {
		page.waitForSelector(timeValues);
		page.hover(fifthColumn);
		page.click(timeAscBtn);
		page.waitForTimeout(1000);
		DateTimeFormatter formatter = new DateTimeFormatterBuilder().parseCaseInsensitive().appendPattern("dd/MM/yyyy HH:mm:ss").toFormatter(Locale.ENGLISH);
        DateTimeFormatter formatter1 = new DateTimeFormatterBuilder().parseCaseInsensitive().appendPattern("yyyy/MM/dd HH:mm:ss").toFormatter(Locale.ENGLISH);
        Locator dates = page.locator(timeValues);
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
	
	public void validateTheDescendingFunctionalityOfTimeColumn() {
		page.waitForSelector(timeValues);
		page.hover(fifthColumn);
		page.click(timeDescBtn);
		page.waitForTimeout(1000);
		DateTimeFormatter formatter = new DateTimeFormatterBuilder().parseCaseInsensitive().appendPattern("dd/MM/yyyy HH:mm:ss").toFormatter(Locale.ENGLISH);
        DateTimeFormatter formatter1 = new DateTimeFormatterBuilder().parseCaseInsensitive().appendPattern("yyyy/MM/dd HH:mm:ss").toFormatter(Locale.ENGLISH);
        Locator dates = page.locator(timeValues);
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
	
	public void validateTheDefaultTextOnSelectFilterDropdown() throws EncryptedDocumentException, IOException {
   		String expectedText = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmErrorsSheet, "selectFilterDropdownDefaultText");
		String actualText = page.textContent(selectFilterDropdown).trim();
		util.ValidateTheTitle(actualText, expectedText);
   	}
	
	public void validateWhetherTheSearchBreadcrumbsTextFieldIsPresent() throws EncryptedDocumentException, IOException {
		String expectedText = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmErrorsSheet, "searchBreadcrumbsTextFieldPlaceHolder");
		String actualText = page.getAttribute(searchTextField, "placeholder");
		util.ValidateTheTitle(actualText, expectedText);
	}
	
	public void validateTheFunctionalityOfSearchBreadcrumbsForValidData() {
		util.validateSearchFunctionalityWithValidData(page,  firstElement, searchTextField, searchIcon, searchResultRows);
	}
	
	public void validateTheFunctionalityOfSearchBreadcrumbsForInvalidData() {
		util.validateSearchFunctionalityWithInvalidData(page,  searchTextField, searchIcon, noDataIcon);
	}
	
	public void validateTheSearchForLevelFilterOptionsThroughSearchBreadcrumbsTextField() throws EncryptedDocumentException, IOException {
		String levels = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmErrorsSheet, "selectFilter_LevelOptions");
		String[] levelOptions = levels.split(",");
		for (String level : levelOptions) {
			System.out.println(level);
			if(level.equalsIgnoreCase("Warning")) {
				try {
						util.validateSearchFunctionalityWithValidData(page, level, searchTextField, searchIcon, descriptionValues);
				}catch (Exception e) {
					Assert.assertTrue(page.isVisible(noDataIcon));
				}
			}
			else
			util.validateSearchFunctionalityWithValidData(page, level, searchTextField, searchIcon, levelValues);	
			
			page.click(clearSearchBtn);
		}
	}
	
	public void validateTheFilterOptionSelectionFunctionality() {
		int n=1;
        page.click(selectFilterDropdown);
        Locator options = page.locator(selectFilterOptions);
		for(int i=0; i<options.count(); i++) {
            options.nth(i).click();
            System.out.println(n+" filters applied");
            Assert.assertTrue(page.textContent(selectFilterDropdown).trim().equalsIgnoreCase(n+" filters applied"));
            n++;
        }
        page.click(selectFilterDropdown);
	}
	
	public void validateTheFilterOptionDeselectionFunctionality() throws EncryptedDocumentException, IOException {
   		String expectedText = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmErrorsSheet, "selectFilterDropdownDefaultText");
		validateTheFilterOptionSelectionFunctionality();
		int n=7;
        page.click(selectFilterDropdown);
        Locator options = page.locator(selectFilterOptions);
		for(int i=0; i<options.count(); i++) {
            options.nth(i).click();
            System.out.println(n+" filters applied");
            if(n!=0)
            Assert.assertTrue(page.textContent(selectFilterDropdown).trim().equalsIgnoreCase(n+" filters applied"));
            else
            Assert.assertTrue(page.textContent(selectFilterDropdown).trim().equalsIgnoreCase(expectedText));
            n--;
        }
        page.click(selectFilterDropdown);
	}
	
	public void validateTheColorOfWarningFilterOptionInSelectFilterDropdown() throws EncryptedDocumentException, IOException {
		String[] levels = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmErrorsSheet, "selectFilter_LevelOptions").split(",");
		validateTheColorOfLevelFilterOptionsInTheDropDown(levels[0],excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmErrorsSheet, "selectFilter_LevelOptions_WarningColor"));
	}
	
	public void validateTheColorOfInfoFilterOptionInSelectFilterDropdown() throws EncryptedDocumentException, IOException {
		String[] levels = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmErrorsSheet, "selectFilter_LevelOptions").split(",");
		validateTheColorOfLevelFilterOptionsInTheDropDown(levels[1],excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmErrorsSheet, "selectFilter_LevelOptions_InfoColor"));
	}
	
	public void validateTheColorOfErrorFilterOptionInSelectFilterDropdown() throws EncryptedDocumentException, IOException {
		String[] levels = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmErrorsSheet, "selectFilter_LevelOptions").split(",");
		validateTheColorOfLevelFilterOptionsInTheDropDown(levels[2],excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmErrorsSheet, "selectFilter_LevelOptions_ErrorColor"));
	}
	
	public void validateTheColorOfLevelFilterOptionsInTheDropDown(String filterOption, String expectedColor) {
		page.click(selectFilterDropdown);
		String actualColor = "";
		Locator options = page.locator(levelFilterOptions);
		for(int i=0; i<options.count(); i++) {
			if(options.nth(i).textContent().trim().equalsIgnoreCase(filterOption)) {
				actualColor = (String)options.nth(i).evaluate("element => window.getComputedStyle(element).getPropertyValue('color')");
				break;
			}
		}
		page.click(selectFilterDropdown);
		System.out.println("actualColor : "+actualColor+"\t expectedColor :"+expectedColor);
		Assert.assertTrue(actualColor.contains(expectedColor));
	}
	
	public void validateTheSelectFilterFunctionalityForDebug() throws EncryptedDocumentException, IOException {
		String[] options = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmErrorsSheet, "selectFilter_TypeOptions").split(",");
		selectAnOptionFromSelectFilterDropdown(options[0], typeFilterOptions);
		String expectedText = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmErrorsSheet, "categoryValueForDebug");
		validateTheTextForSearchResult(expectedText);
		String expectedColor = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmErrorsSheet, "Breadcrumb_DebugIconColor");
		validateTheColorOfTheIconsOnTypeColumn(expectedColor);
	}
	
	
	public void validateTheSelectFilterFunctionalityForNavigation() throws EncryptedDocumentException, IOException {
		String[] options = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmErrorsSheet, "selectFilter_TypeOptions").split(",");
		selectAnOptionFromSelectFilterDropdown(options[1], typeFilterOptions);
		String expectedText = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmErrorsSheet, "categoryValueForNavigation");
		validateTheTextForSearchResult(expectedText);
		String[] navigationText = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmErrorsSheet, "descriptionValueForNavigation").split(",");
		Locator value = page.locator(descriptionValues);
		try{
			for(int i=0; i<value.count(); i++) {
				boolean flag = false;
				if(value.nth(i).textContent().trim().contains(navigationText[0]) && value.nth(i).textContent().trim().contains(navigationText[1])) {
					flag = true;
				}
				Assert.assertTrue(flag);
			}
		}catch (Exception e){
            Assert.assertTrue(page.isVisible(noDataIcon));
        }
		String expectedColor = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmErrorsSheet, "Breadcrumb_NavigationIconColor");
		validateTheColorOfTheIconsOnTypeColumn(expectedColor);
	}
	
	public void validateTheSelectFilterFunctionalityForUserAction() throws EncryptedDocumentException, IOException {
		String[] options = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmErrorsSheet, "selectFilter_TypeOptions").split(",");
		selectAnOptionFromSelectFilterDropdown(options[2], typeFilterOptions);
		String[] navigationText = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmErrorsSheet, "descriptionValueForNavigation").split(",");
		Locator value = page.locator(descriptionValues);
		try{
			for(int i=0; i<value.count(); i++) {
				boolean flag = false;
				if(value.nth(i).textContent().trim().contains(navigationText[0]) && value.nth(i).textContent().trim().contains(navigationText[1])) {
					flag = true;
				}
				Assert.assertTrue(flag);
			}
		}catch (Exception e){
            Assert.assertTrue(page.isVisible(noDataIcon));
        }
		String expectedColor = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmErrorsSheet, "Breadcrumb_UserActionIconColor");
		validateTheColorOfTheIconsOnTypeColumn(expectedColor);
	}
	
	public void validateTheSelectFilterFunctionalityForTypeError() throws EncryptedDocumentException, IOException {
		String[] options = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmErrorsSheet, "selectFilter_TypeOptions").split(",");
		selectAnOptionFromSelectFilterDropdown(options[3], typeFilterOptions);
		String expectedText = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmErrorsSheet, "categoryValueForTypeError");
		validateTheTextForSearchResult(expectedText);
		String levelText = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmErrorsSheet, "levelValueForTypeError");
		Locator value = page.locator(levelValues);
		try{
			for(int i=0; i<value.count(); i++) {
				boolean flag = false;
				if(value.nth(i).textContent().trim().equalsIgnoreCase(levelText)) {
					flag = true;
				}
				Assert.assertTrue(flag);
			}
		}catch (Exception e){
            Assert.assertTrue(page.isVisible(noDataIcon));
        }
		String expectedColor = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmErrorsSheet, "Breadcrumb_ErrorIconColor");
		validateTheColorOfTheIconsOnTypeColumn(expectedColor);
	}
	
	public void validateTheSelectFilterFunctionalityForHttp() throws EncryptedDocumentException, IOException {
		String[] options = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmErrorsSheet, "selectFilter_TypeOptions").split(",");
		selectAnOptionFromSelectFilterDropdown(options[4], typeFilterOptions);
		String expectedText = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmErrorsSheet, "categoryValueForHttp");
		validateTheTextForSearchResult(expectedText);
		String levelText = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmErrorsSheet, "levelValueForHttp");
		Locator value = page.locator(levelValues);
		try{
			for(int i=0; i<value.count(); i++) {
				boolean flag = false;
				if(value.nth(i).textContent().trim().equalsIgnoreCase(levelText)) {
					flag = true;
				}
				Assert.assertTrue(flag);
			}
		}catch (Exception e){
            Assert.assertTrue(page.isVisible(noDataIcon));
        }
		String expectedColor = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmErrorsSheet, "Breadcrumb_HttpIconColor");
		Locator icons = page.locator(typeIconForHttp);
		try{
            for(int i=0; i<icons.count(); i++) {
            	String actualColor = (String)icons.nth(i).evaluate("element => window.getComputedStyle(element).getPropertyValue('fill')");
            	System.out.println(actualColor+"\t"+expectedColor);
            	Assert.assertTrue(actualColor.contains(expectedColor));
            }
        }
        catch (Exception e){
            Assert.assertTrue(page.isVisible(noDataIcon));
        }
	}
	
	public void validateTheSelectFilterFunctionalityForWarning() throws EncryptedDocumentException, IOException {
		String[] options = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmErrorsSheet, "selectFilter_LevelOptions").split(",");
		selectAnOptionFromSelectFilterDropdown(options[0], levelFilterOptions);
		String levelText = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmErrorsSheet, "levelValueForWarning");
		Locator value = page.locator(levelValues);
		try{
			for(int i=0; i<value.count(); i++) {
				boolean flag = false;
				if(value.nth(i).textContent().trim().equalsIgnoreCase(levelText)) {
					flag = true;
				}
				Assert.assertTrue(flag);
			}
		}catch (Exception e){
            Assert.assertTrue(page.isVisible(noDataIcon));
        }
	}
	
	public void validateTheSelectFilterFunctionalityForInfo() throws EncryptedDocumentException, IOException {
		String[] options = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmErrorsSheet, "selectFilter_LevelOptions").split(",");
		selectAnOptionFromSelectFilterDropdown(options[1], levelFilterOptions);
		String levelText = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmErrorsSheet, "levelValueForInfo");
		Locator value = page.locator(levelValues);
		try{
			for(int i=0; i<value.count(); i++) {
				boolean flag = false;
				if(value.nth(i).textContent().trim().equalsIgnoreCase(levelText)) {
					flag = true;
				}
				Assert.assertTrue(flag);
			}
		}catch (Exception e){
            Assert.assertTrue(page.isVisible(noDataIcon));
        }
	}
	
	public void validateTheSelectFilterFunctionalityForLevelError() throws EncryptedDocumentException, IOException {
		String[] options = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmErrorsSheet, "selectFilter_LevelOptions").split(",");
		selectAnOptionFromSelectFilterDropdown(options[2], levelFilterOptions);
		String levelText = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmErrorsSheet, "levelValueForLevelError");
		Locator value = page.locator(levelValues);
		try{
			for(int i=0; i<value.count(); i++) {
				boolean flag = false;
				if(value.nth(i).textContent().trim().equalsIgnoreCase(levelText)) {
					flag = true;
				}
				Assert.assertTrue(flag);
			}
		}catch (Exception e){
            Assert.assertTrue(page.isVisible(noDataIcon));
        }
	}
	
	public void selectAnOptionFromSelectFilterDropdown(String option, String filterOptions) {
		page.click(selectFilterDropdown);
		Locator types = page.locator(filterOptions);
		for(int i=0; i<types.count(); i++) {
			if(types.nth(i).textContent().trim().equalsIgnoreCase(option)) {
				types.nth(i).click();
				page.click(selectFilterDropdown);
				break;
			}
		}
	}
	
	public void validateTheTextForSearchResult(String expectedText) {
		Locator category = page.locator(categoryValues);
		try{
            for(int i=0; i<category.count(); i++) {
            	Assert.assertTrue(category.nth(i).textContent().trim().equalsIgnoreCase(expectedText));
            }
        }
        catch (Exception e){
            Assert.assertTrue(page.isVisible(noDataIcon));
        }
	}
	
	public void validateTheColorOfTheIconsOnTypeColumn(String expectedColor) {
		Locator icons = page.locator(typeIcons);
		try{
            for(int i=0; i<icons.count(); i++) {
            	icons.nth(i).click();
            	String actualColor = (String)icons.nth(i).evaluate("element => window.getComputedStyle(element).getPropertyValue('fill')");
            	System.out.println(actualColor+"\t"+expectedColor);
            	Assert.assertTrue(actualColor.contains(expectedColor));
            }
        }
        catch (Exception e){
            Assert.assertTrue(page.isVisible(noDataIcon));
        }
	}
	
	public void validateWhetherClearFilterOptionIsDisplayingOnSelectingFilter() {
		page.click(selectFilterDropdown);
		page.locator(typeFilterOptions).first().click();
		page.click(selectFilterDropdown);
		Assert.assertTrue(page.isVisible(clearFilterOption));
	}
	
	public void validateTheFunctionalityOfClearFilterOption() throws EncryptedDocumentException, IOException {
		validateWhetherClearFilterOptionIsDisplayingOnSelectingFilter();
		page.click(clearFilterOption);
		validateTheDefaultTextOnSelectFilterDropdown();
	}
	
	public void validateTheColorOfTheCategoryColumnDataInBreadcrumbTable() throws EncryptedDocumentException, IOException {
		String expectedColor = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmErrorsSheet, "categoryColumnTextColor");
		Locator text = page.locator(categoryValues);
		for(int i=0; i<text.count(); i++) {
			String actualColor = (String)text.nth(i).evaluate("element => window.getComputedStyle(element).getPropertyValue('color')");
			System.out.println(actualColor+"\t"+expectedColor);
        	Assert.assertTrue(actualColor.contains(expectedColor));
		}
	}
	
	public void validateTheApplicationKeyAndValueForAngularApplication() throws EncryptedDocumentException, IOException {
		validateTheKeyValueData(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmErrorsSheet, "EventsDetailsPage_ApplicationKey"), excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmDataValidationSheet, "angularApplicationName"));
	}
	
	public void validateTheApplicationVersionKeyAndValueForAngularApplication() throws EncryptedDocumentException, IOException {
		validateTheKeyValueData(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmErrorsSheet, "EventsDetailsPage_ApplicationVersionKey"), excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmDataValidationSheet, "angularError_serviceVersion"));
	}
	
	public void validateTheEnvironmentKeyAndValueForAngularApplication() throws EncryptedDocumentException, IOException {
		validateTheKeyValueData(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmErrorsSheet, "EventsDetailsPage_EnvironmentKey"), excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmDataValidationSheet, "angularError_environment"));
	}
	
	public void validateTheErrorUrlKeyAndValueForAngularApplication() throws EncryptedDocumentException, IOException {
		validateTheKeyValueData(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmErrorsSheet, "EventsDetailsPage_ErrorUrlKey"), excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmDataValidationSheet, "angularError_errorUrl"));
	}
	
	public void validateThePagePathKeyAndValueForAngularApplication() throws EncryptedDocumentException, IOException {
		String key = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmErrorsSheet, "EventsDetailsPage_PagePathKey");
		String[] paths = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmDataValidationSheet, "angularError_pagePaths").split(",");
		Locator keys = page.locator(attributeKeys);
		Locator values = page.locator(attributeValues);
		boolean flag = false;
		for(int i=0; i<keys.count(); i++) {
			if(keys.nth(i).textContent().trim().equalsIgnoreCase(key)) {
				String actualPath = values.nth(i).textContent().trim();
				if(actualPath.equalsIgnoreCase(paths[0]) || actualPath.equalsIgnoreCase(paths[1]) || actualPath.equalsIgnoreCase(paths[2]) || actualPath.equalsIgnoreCase(paths[3])) {
					System.out.println(key + " ------- " + actualPath);
					flag = true;
					break;
				}
			}
		}
		Assert.assertTrue(flag);
	}
	
	public void validateTheErrorKeyAndValueForAngularApplication() throws EncryptedDocumentException, IOException {
		validateTheKeyValueData(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmErrorsSheet, "EventsDetailsPage_ErrorKey"), excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmDataValidationSheet, "angularError_grade"));
	}
	
	public void validateTheCategoryKeyAndValueForAngularApplication() throws EncryptedDocumentException, IOException {
		String key = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmErrorsSheet, "EventsDetailsPage_CategoryKey");
		String[] category = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmDataValidationSheet, "angularError_categories").split(",");
		Locator keys = page.locator(attributeKeys);
		Locator values = page.locator(attributeValues);
		boolean flag = false;
		for(int i=0; i<keys.count(); i++) {
			if(keys.nth(i).textContent().trim().equalsIgnoreCase(key)) {
				String actualPath = values.nth(i).textContent().trim();
				if(actualPath.equalsIgnoreCase(category[0]) || actualPath.equalsIgnoreCase(category[1]) || actualPath.equalsIgnoreCase(category[2]) || actualPath.equalsIgnoreCase(category[3])) {
					System.out.println(key + " ------- " + actualPath);
					flag = true;
					break;
				}
			}
		}
		Assert.assertTrue(flag);
	}
	
	public void validateTheErrorTypeKeyAndValueForAngularApplication() throws EncryptedDocumentException, IOException {
		String key = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmErrorsSheet, "EventsDetailsPage_ErrorTypeKey");
		String[] category = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmDataValidationSheet, "angularError_categories").split(",");
		Locator keys = page.locator(attributeKeys);
		Locator values = page.locator(attributeValues);
		boolean flag = false;
		for(int i=0; i<keys.count(); i++) {
			if(keys.nth(i).textContent().trim().equalsIgnoreCase(key)) {
				String actualPath = values.nth(i).textContent().trim();
				if(actualPath.equalsIgnoreCase(category[0]) || actualPath.equalsIgnoreCase(category[1]) || actualPath.equalsIgnoreCase(category[2]) || actualPath.equalsIgnoreCase(category[3])) {
					System.out.println(key + " ------- " + actualPath);
					flag = true;
					break;
				}
			}
		}
		Assert.assertTrue(flag);
	}
	
	public void validateTheMessageKeyAndValueForAngularApplication() throws EncryptedDocumentException, IOException {
		String key = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmErrorsSheet, "EventsDetailsPage_MessageKey");
		String[] category = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmDataValidationSheet, "angularError_categories").split(",");
		String msg = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmDataValidationSheet, "angularError_message");
		Locator keys = page.locator(attributeKeys);
		Locator values = page.locator(attributeValues);
		boolean flag = false;
		for(int i=0; i<keys.count(); i++) {
			if(keys.nth(i).textContent().trim().equalsIgnoreCase(key)) {
				String actualMsg = values.nth(i).textContent().trim();
				if(actualMsg.equalsIgnoreCase("error category:"+category[0]+msg) || actualMsg.equalsIgnoreCase("error category:"+category[1]+msg) || 
						actualMsg.equalsIgnoreCase("error category:"+category[2]+msg) || actualMsg.equalsIgnoreCase("error category:"+category[3]+msg)) {
					System.out.println(key + " ------- " + actualMsg);
					flag = true;
					break;
				}
			}
		}
		Assert.assertTrue(flag);
	}
	
	public void validateTheTimeKeyAndValueForAngularApplication() throws EncryptedDocumentException, IOException {
		bmErrors = new BmErrorsPage(page);
		String key = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmErrorsSheet, "EventsDetailsPage_TimeKey");
		String value = bmErrors.fetchFirstDateAndTimeFromErrorsEventsPage();
		bmErrors.validateNavigationToEventsDetsilsPageByClickingOnEventId();
		validateTheKeyValueData(key, value);
	}
	
	public void validateTheNameKeyAndValueForAngularApplication() throws EncryptedDocumentException, IOException {
		validateTheKeyValueData(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmErrorsSheet, "EventsDetailsPage_NameKey"), excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmDataValidationSheet, "angularError_sdkName"));
	}
	
	public void validateTheVersionKeyAndValueForAngularApplication() throws EncryptedDocumentException, IOException {
		validateTheKeyValueData(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmErrorsSheet, "EventsDetailsPage_VersionKey"), excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmDataValidationSheet, "angularError_sdkVersion"));
	}
	
	public void validateTheUserAgentKeyAndValueForAngularApplication() throws EncryptedDocumentException, IOException {
		validateTheKeyValueData(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmErrorsSheet, "EventsDetailsPage_UserAgentKey"), excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmDataValidationSheet, "angularError_userAgent"));
	}
	
	public void validateTheApplicationKeyAndValueForReactApplication() throws EncryptedDocumentException, IOException {
		validateTheKeyValueData(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmErrorsSheet, "EventsDetailsPage_ApplicationKey"), excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmDataValidationSheet, "reactApplicationName"));
	}
	
	public void validateTheApplicationVersionKeyAndValueForReactApplication() throws EncryptedDocumentException, IOException {
		validateTheKeyValueData(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmErrorsSheet, "EventsDetailsPage_ApplicationVersionKey"), excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmDataValidationSheet, "reactError_serviceVersion"));
	}
	
	public void validateTheEnvironmentKeyAndValueForReactApplication() throws EncryptedDocumentException, IOException {
		validateTheKeyValueData(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmErrorsSheet, "EventsDetailsPage_EnvironmentKey"), excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmDataValidationSheet, "reactError_environment"));
	}
	
	public void validateTheErrorUrlKeyAndValueForReactApplication() throws EncryptedDocumentException, IOException {
		validateTheKeyValueData(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmErrorsSheet, "EventsDetailsPage_ErrorUrlKey"), excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmDataValidationSheet, "reactError_errorUrl"));
	}
	
	public void validateThePagePathKeyAndValueForReactApplication() throws EncryptedDocumentException, IOException {
		String key = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmErrorsSheet, "EventsDetailsPage_PagePathKey");
		String[] paths = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmDataValidationSheet, "reactError_pagePaths").split(",");
		Locator keys = page.locator(attributeKeys);
		Locator values = page.locator(attributeValues);
		boolean flag = false;
		for(int i=0; i<keys.count(); i++) {
			if(keys.nth(i).textContent().trim().equalsIgnoreCase(key)) {
				String actualPath = values.nth(i).textContent().trim();
				if(actualPath.equalsIgnoreCase(paths[0]) || actualPath.equalsIgnoreCase(paths[1]) || actualPath.equalsIgnoreCase(paths[2])) {
					System.out.println(key + " ------- " + actualPath);
					flag = true;
					break;
				}
			}
		}
		Assert.assertTrue(flag);
	}
	
	public void validateTheErrorKeyAndValueForReactApplication() throws EncryptedDocumentException, IOException {
		validateTheKeyValueData(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmErrorsSheet, "EventsDetailsPage_ErrorKey"), excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmDataValidationSheet, "reactError_grade"));
	}
	
	public void validateTheCategoryKeyAndValueForReactApplication() throws EncryptedDocumentException, IOException {
		String key = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmErrorsSheet, "EventsDetailsPage_CategoryKey");
		String[] category = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmDataValidationSheet, "reactError_categories").split(",");
		Locator keys = page.locator(attributeKeys);
		Locator values = page.locator(attributeValues);
		boolean flag = false;
		for(int i=0; i<keys.count(); i++) {
			if(keys.nth(i).textContent().trim().equalsIgnoreCase(key)) {
				String actualPath = values.nth(i).textContent().trim();
				if(actualPath.equalsIgnoreCase(category[0]) || actualPath.equalsIgnoreCase(category[1]) || actualPath.equalsIgnoreCase(category[2])) {
					System.out.println(key + " ------- " + actualPath);
					flag = true;
					break;
				}
			}
		}
		Assert.assertTrue(flag);
	}
	
	public void validateTheErrorTypeKeyAndValueForReactApplication() throws EncryptedDocumentException, IOException {
		String key = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmErrorsSheet, "EventsDetailsPage_ErrorTypeKey");
		String[] category = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmDataValidationSheet, "reactError_categories").split(",");
		Locator keys = page.locator(attributeKeys);
		Locator values = page.locator(attributeValues);
		boolean flag = false;
		for(int i=0; i<keys.count(); i++) {
			if(keys.nth(i).textContent().trim().equalsIgnoreCase(key)) {
				String actualPath = values.nth(i).textContent().trim();
				if(actualPath.equalsIgnoreCase(category[0]) || actualPath.equalsIgnoreCase(category[1]) || actualPath.equalsIgnoreCase(category[2])) {
					System.out.println(key + " ------- " + actualPath);
					flag = true;
					break;
				}
			}
		}
		Assert.assertTrue(flag);
	}
	
	public void validateTheMessageKeyAndValueForReactApplication() throws EncryptedDocumentException, IOException {
		validateTheKeyValueData(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmErrorsSheet, "EventsDetailsPage_MessageKey"),excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmDataValidationSheet, "reactError_message").trim());
	}
	
	public void validateTheTimeKeyAndValueForReactApplication() throws EncryptedDocumentException, IOException {
		bmErrors = new BmErrorsPage(page);
		String key = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmErrorsSheet, "EventsDetailsPage_TimeKey");
		String value = bmErrors.fetchFirstDateAndTimeFromErrorsEventsPage();
		bmErrors.validateNavigationToEventsDetsilsPageByClickingOnEventId();
		validateTheKeyValueData(key, value);
	}
	
	public void validateTheNameKeyAndValueForReactApplication() throws EncryptedDocumentException, IOException {
		validateTheKeyValueData(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmErrorsSheet, "EventsDetailsPage_NameKey"), excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmDataValidationSheet, "reactError_sdkName"));
	}
	
	public void validateTheVersionKeyAndValueForReactApplication() throws EncryptedDocumentException, IOException {
		validateTheKeyValueData(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmErrorsSheet, "EventsDetailsPage_VersionKey"), excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmDataValidationSheet, "reactError_sdkVersion"));
	}
	
	public void validateTheUserAgentKeyAndValueForReactApplication() throws EncryptedDocumentException, IOException {
		validateTheKeyValueData(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmErrorsSheet, "EventsDetailsPage_UserAgentKey"), excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmDataValidationSheet, "reactError_userAgent"));
	}
	
	public void validateTheKeyValueData(String key, String expectedValue) {
		Locator keys = page.locator(attributeKeys);
		Locator values = page.locator(attributeValues);
		for(int i=0; i<keys.count(); i++) {
			if(keys.nth(i).textContent().trim().equalsIgnoreCase(key)) {
				System.out.println(key+" ------ "+expectedValue+" ------ "+values.nth(i).textContent().trim());
				Assert.assertTrue(values.nth(i).textContent().trim().equalsIgnoreCase(expectedValue));
				break;
			}
		}
	}
}
