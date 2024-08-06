package objectRepository;

import java.io.IOException;


import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;

import genericUtilities.ExcelUtility;
import genericUtilities.GenericMethods;
import genericUtilities.IPathConstant;
import genericUtilities.JavaUtility;

public class CommonPage {
	
	 Page page;
	 JavaUtility jutil=new JavaUtility();
	 ExcelUtility eutil = new ExcelUtility();
	 GenericMethods util = new GenericMethods();
	
	private String month="xpath = //div[@class='items']/child::div[10]";
	private String logoutBtn="xpath = //div[@id='btn-logout-user']";
	private String mobileMonitoringsideNavBtn = "xpath = //div[@id='side-nav-mobile']";
	private String apmSideNavBtn="xpath = //div[@id='side-nav-apm']";
	private String homeSideNavBtn= "#side-nav-home";
	private String alertsSideNavBtn= "#side-nav-alertsV2";
	private String notificationsSideNavBtn = "#side-nav-notification";
	private String bmSideNaveBtn = "#side-nav-browser";
	private String smSideNavBtn = "#side-nav-sm";
	private String dataBaseSideNavBtn = "#side-nav-database";
	private String settingSideNavBtn = "#side-nav-settings";
	private String capabilityTitle = "xpath = //span[@class='tab-name']";
	private String MQMonitoringNavbtn = "#side-nav-mq";
	
	//**************************************** Calendar elements ****************************
	
	private String calanderValue = "xpath = //div[@class='selected-text ellipsis bg-text']";
	private String calenderIcon = "xpath = //div[@class='date-box']/descendant::span[contains(@class,'selected-icon')]";
	private String startDate = "xpath = //input[@placeholder='Start date']";
	private String endDate = "xpath = //input[@placeholder='End date']";
	private String customApplyBtn = "#custom-apply-btn";
	private String customBackBtn = "#custom-back-btn";
	private String okBtn = "xpath = //span[text()='Ok']";
	private String customPageCalenderICon = "xpath = //div[@class='input-body']";
	
	//**************************************** Pagination elements ****************************
	
	private String paginationDropdown = "xpath = //span[@class='ant-select-selection-item']";
	private String selectedPagination = "xpath = //span[@class='ant-select-selection-item']";
	
	//**************************************** Refresh page elements ****************************
	private String refreshBtn = "xpath = //div[@class='toolbar']/descendant::div[contains(@class,'rex-select')]";
	private String refreshDropdown = "#ref-dropdown";
	private String refreshOptions = "xpath = //div[@class='items']/child::div[contains(@class,'-text')]";
	private String selectedRefreshOption = "xpath = //div[@class='items selectHide']/child::div[@class='selected-text']";
	
		
		
	
	public CommonPage(Page page)
	{
		this.page=page;
	}
	
	/**
	 *this method is used for selecting the time line from the calendar like 5 mins, 15 mins etc
	 * @param period
	 */
	
	public void selectTheTimeLineFromCalender(String period)
	{
		page.locator(calenderIcon).click();
		page.waitForLoadState();
		page.locator("xpath = //div[@class='options item-text']/child::div[text()='"+period+"']").click();
		page.waitForLoadState();
	}
	
	
	/**
	 * this method is used to select the custom time rage for minutes, hours, days etc
	 * @param period
	 * @param toDateTime
	 * @param fromDateTime
	 */
	public void selectTheCustomeTimeLine(String period,String range)
	{
		try {
			page.locator(calenderIcon).click();
			page.locator("xpath = //div[@class='options item-text']/child::div[text()='"+period+"']").click();
			String endTime=jutil.getTheSystemDateAndTime("dd LLL, hh:mm ")+jutil.getTheSystemDateAndTime("a").toUpperCase();
			
			String time="";
			
			for(int i=0;i<range.length();i++)
			{
				if(Character.isDigit(range.charAt(i)))
						{
							time=time+range.charAt(i);
						}
			}
			int num=Integer.parseInt(time);
			StringBuilder startTime= new StringBuilder();
			if(range.toLowerCase().contains("min"))
			{
				startTime = new StringBuilder(jutil.getTheCustomeTimeAndDateBasedOnTheCurrentSystemTime("dd LLL, hh:mm ", num, 0, 0, 0, 0, 0, 0)+jutil.getTheCustomeTimeAndDateBasedOnTheCurrentSystemTime("a", num, 0, 0, 0, 0, 0, 0).toUpperCase());
				System.out.println(startTime.charAt(8));	
				if(startTime.charAt(8) == '0')
				{
					startTime=startTime.deleteCharAt(8);
				}
				if(startTime.charAt(0)== '0')
				{
					startTime=startTime.deleteCharAt(0);
				}
			
			} else if (range.toLowerCase().contains("hour"))
			{
				startTime = new StringBuilder(jutil.getTheCustomeTimeAndDateBasedOnTheCurrentSystemTime("dd LLL, hh:mm ", 0, num, 0, 0, 0, 0, 0)+jutil.getTheCustomeTimeAndDateBasedOnTheCurrentSystemTime("a", 0, num, 0, 0, 0, 0, 0).toUpperCase());
				System.out.println(startTime.charAt(8));
				if(startTime.charAt(8) == '0')
				{
					startTime=startTime.deleteCharAt(8);
				}
				if(startTime.charAt(0)== '0')
				{
					startTime=startTime.deleteCharAt(0);
				}
			}
			else if (range.toLowerCase().contains("day"))
			{
				startTime = new StringBuilder(jutil.getTheCustomeTimeAndDateBasedOnTheCurrentSystemTime("dd LLL, hh:mm ", 0, 0, num, 0, 0, 0, 0)+jutil.getTheCustomeTimeAndDateBasedOnTheCurrentSystemTime("a", 0, 0, num, 0, 0, 0, 0).toUpperCase());
				System.out.println(startTime.charAt(8));
				if(startTime.charAt(8) == '0')
				{
					startTime=startTime.deleteCharAt(8);
				}
				if(startTime.charAt(0)== '0')
				{
					startTime=startTime.deleteCharAt(0);
				}
			
			}
			Locator startdate=page.locator(startDate);
			startdate.click();
			startdate.clear();
			startdate.fill(startTime.toString());
			
			Locator enddate=page.locator(endDate);
			enddate.click();
			enddate.clear();
			enddate.fill(endTime);
			System.out.println(endTime);
			
			page.locator(okBtn).click();
			//page.locator(okBtn).click();
			
			page.locator(customApplyBtn).click();
		} catch (Exception e) {
			page.locator(customBackBtn).click();
		}finally {
			if(page.locator(customBackBtn).isVisible())
			{
				page.locator(customBackBtn).click();
			}
		}
		
	}
	
	/**
	 * This method is used to validate the future date
	 */
	
	public void validateTheFutureTimeLine()
	{
		page.locator(calenderIcon).click();
		page.locator("//div[@class='options item-text']/child::div[text()='Custom']").click();
		String date=jutil.getTheCustomeTimeAndDateBasedOnTheCurrentSystemTime("yyyy-MM-dd", 0, 0, 0, 0, 0, 0, 1);
		page.locator(customPageCalenderICon).click();
		String futureDate = "xpath = //table[@class='ant-picker-content']//tbody/descendant::td[@title='"+date+"']";
		Assert.assertTrue((page.getAttribute(futureDate, "class").contains("disabled")));
	}
	
	/**
	 * this method is used for logout the application
	 */
	
	public void logoutFromApplication()
	{
		page.click(logoutBtn);
	}
	
	
	/**
	 * this method is used for navigate to mobile monitoring capability
	 */
	
	public void navigateToMobileMonitoring()
	{
		page.click(mobileMonitoringsideNavBtn);
		page.waitForLoadState();
		String expectedUrl="**/mobile/mblDashboard";
		page.waitForURL(expectedUrl);
		Assert.assertTrue(page.url().endsWith("/mobile/mblDashboard"));
	}
	
	
	/**
	 * this method is used for navigate to APM capability
	 */
	
	public void navigateToApm()
	{
		page.click(apmSideNavBtn);
		page.waitForLoadState();
		String expectedUrl="**/apm/dashboard/service";
		page.waitForURL(expectedUrl);
		Assert.assertTrue(page.url().endsWith("/apm/dashboard/service"));
		Assert.assertTrue(page.textContent(capabilityTitle).trim().equals("APM"));
	}
	
	
	/**
	 * this method is used for navigate to Alerts capability
	 */
	
	public void navigateToAlerts()
	{
		page.click(alertsSideNavBtn);
		page.waitForLoadState();
		String expectedUrl="**/alertsV2/generatedV2";
		page.waitForURL(expectedUrl);

		Assert.assertEquals(page.url().contains("/alertsV2/generatedV2"),true);
		
	}
	
	/**
	 * this method is used for navigate to Home page
	 */
	
	public void navigateToHomePage()
	{
		page.click(homeSideNavBtn);
		page.waitForLoadState();
		String expectedUrl="**/home";
		page.waitForURL(expectedUrl);
		Assert.assertEquals(page.url().contains("/home"),true);
	}
	
	/**
	 * this method is used for navigate to Notification channel
	 */
	
	public void navigateToNotificationChannel()
	{
		page.click(notificationsSideNavBtn);
		page.waitForLoadState();
		String expectedUrl="**/notification/channel";
		page.waitForURL(expectedUrl);
		Assert.assertEquals(page.url().contains("/notification/channel"),true);
	}
	
	/**
	 * This Method is used to navigate to MQ Monitoring Channel
	 */
	public void navigateToMQM() {
		
		page.click(MQMonitoringNavbtn);
		page.waitForLoadState(LoadState.NETWORKIDLE);
		String expectedUrl="**/mq";
		page.waitForURL(expectedUrl);
		Assert.assertEquals(page.url().contains("/mq"), true);
		System.out.println(page.url());
		Assert.assertEquals(page.textContent(capabilityTitle).trim().equals("MQ monitoring"), true);
		System.out.println(page.textContent(capabilityTitle));
		
		
	}
	/**
	 * this method is used for navigate to Browser monitoring capability
	 */
	
	public void navigateToBrowserMonitoring()
	{
		page.click(bmSideNaveBtn);
		page.waitForLoadState();
		String expectedUrl="**/browser/application";
		page.waitForURL(expectedUrl);
		Assert.assertEquals(page.url().contains("/browser/application"),true);
		Assert.assertTrue(page.textContent(capabilityTitle).trim().equals("Browser monitoring"));
	}
	
	/**
	 * this method is used for navigate to Synthetic monitoring capability
	 */
	
	public void navigateToSynteticMonitoring()
	{
		page.click(smSideNavBtn);
		page.waitForLoadState();
		String expectedUrl="**/sm/smEndpoints/smAvailability/all-groups/";
		page.waitForURL(expectedUrl);
		Assert.assertEquals(page.url().contains("/sm/smEndpoints/smAvailability/all-groups/"),true);
	}
	
	
	/**
	 * this method is used for navigate to Database monitoring capability
	 */
	public void navigateToDBM()
	{
		page.click(dataBaseSideNavBtn);
		page.waitForLoadState();
		String expectedUrl="**/database";
		page.waitForURL(expectedUrl);
		Assert.assertEquals(page.url().contains("/database"),true);
	}
	
	
	/**
	 * this method is used for navigate to settings monitoring capability
	 */
	public void navigateToSettings()
	{
		page.click(settingSideNavBtn);
		page.waitForLoadState();
		String expectedUrl="**/settings/general";
		page.waitForURL(expectedUrl);
		Assert.assertEquals(page.url().contains("/settings/general"),true);
	}

	/**
	 * This method selects the specified pagination and validates the number of data per page
	 */
	public void selectPaginationAndValidate(Page page, int num, String elements) {
		String number = ""+num+" / page";
		
		try {
			page.click(paginationDropdown);
			String option = "xpath = //div[text()='"+number+"']";		
			try{
				page.click(option);
				Assert.assertTrue(page.textContent(selectedPagination).equalsIgnoreCase(number));
				Thread.sleep(300);
				Locator dataList = page.locator(elements);
				//System.out.println(dataList.count());
				Assert.assertTrue(dataList.count()<=num);
			}
			catch(Exception e) {
				System.out.println("Please select a valid pagination");
			}
		}
		catch(Exception e) {
			System.out.println("There is no sufficient data to select pagination");
		}
	}
	
	public void validateRefreshOptionsForAvailabilityAndSelection() throws EncryptedDocumentException, IOException {
		String opt = eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath, IPathConstant.refreshOptionsSheet, "refreshOptions");
		String[] options = opt.split(",");
		
		if(!page.locator(refreshBtn).getAttribute("class").contains("disabled")) {
		for (String rOption : options) {
			//System.out.println(rOption);
			page.click(refreshDropdown);
			page.waitForSelector(refreshOptions);
			Locator time = page.locator(refreshOptions);
			for(int i=0; i<time.count(); i++) {
				if(time.nth(i).textContent().trim().equals(rOption)) {
					time.nth(i).click();
					break;
				}
			}
			//System.out.println(page.textContent(selectedRefreshOption).trim());
			Assert.assertTrue(page.textContent(selectedRefreshOption).trim().equalsIgnoreCase(rOption));
		}
		}
		else {
			System.out.println("Soft refresh option is disabled");
		}
	}

}
