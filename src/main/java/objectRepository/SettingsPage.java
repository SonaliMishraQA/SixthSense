package objectRepository;

import java.io.IOException;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;

import com.microsoft.playwright.Page;

import genericUtilities.ExcelUtility;
import genericUtilities.GenericMethods;
import genericUtilities.IPathConstant;
import genericUtilities.JavaUtility;

public class SettingsPage {
	
	Page page;
	GenericMethods util=new GenericMethods();
	JavaUtility jutil=new JavaUtility();
	
	private String applicationTab = "#nav-tab-serviceSettings";
	private String apdexConfiguration = "xpath =//li[@id='list-box-apdexConfig']" ;
	private String apdexconfigurationHeaderText = "xpath = //div[@class='header' and text()='Apdex configuration']";
	private String apdexconfigurationSubHeaderText = "xpath = //div[@class='header' and text()='Apdex configuration']//following-sibling::div";
	private String apdexResponsetime = "#input-apdex" ;
	private String saveBtn = "#btn-save-apdex" ;
	private String successMessage = "xpath = //div[@class='ant-notification-notice-description']";
	private String closeSuccessMessage = "xpath  = //span[@class='anticon anticon-close ant-notification-close-icon']";
	
	private String selectApplicationDropdown = "#btn-arrow-down-search-select-application" ;
	private String searchApplicationBox = "#input-search-sel-search-select-application";
	private String searchedApplicationList = "xpath = //span[@class='option-icon']/child::span[contains(@id,'search-select-application')]";
	
	private String dataRetentionPolicyTab = "#list-box-dataRetentionConfig" ;
	private String dataRetentionPolicySubHeader1 = "xpath = //div[@class='sub-header' and .='Minimum trace latency (ms)']";
	private String dataRetentionPolicySubHeader2 = "xpath = //div[@class='sub-header' and .='Maximum spans per trace']";
	
	private String traceRetentionConfiguration = "xpath = //a[@href='/settings/serviceSettings/dataRetentionConfig']/child::span[.='Trace retention configuration']";
	private String traceRetentionTabActive = "xpath = //span[.='Trace retention configuration']/parent::a[@href='/settings/serviceSettings/dataRetentionConfig']";
	private String minTraceLatencyTextField = "#trace-latency" ;
	private String latencysaveBtn = "#btn-save-trace-config" ;
	private String maximumSpansTextField = "#max-spans";
	private String retainAllErrorTracesRadioButton = "#rex-toggle-curvey";
	private String retainAllErrorTraceCheckBox = "xpath = //label[@class='switch']";
	
	
	private String dBQueryConfiguration = "xpath = //a[@href='/settings/serviceSettings/dataRetentionConfig']/child::span[.='DB query configuration']";
	private String dBQueryConfigurationActive = "xpath = //span[.='DB query configuration']//parent::a[@href='/settings/serviceSettings/dataRetentionConfig']";
	private String dBQuerySubHeader = "xpath = //div[@class='sub-header' and .='Minimum db query latency (ms)']";
	private String minDBQueryLatencyTextField = "#query-latency";
	private String queryLatencySaveBtn = "#btn-save-query-config";
	
	private String settingsTitle = "#title-text-settings";
	private String settingsIcon = "#title-icon-settings";
	private String generalTab = "#nav-tab-general";
	private String userAdministrationTab = "#nav-tab-userAdmin"; 
	private String accessTokenHeaderText = "xpath = //div[@class='tabs-wrapper']/descendant::div[@class='header' and .='Access token']";
	private String accessTokenSubHeaderText = "xpath = //div[@class='tabs-wrapper']/descendant::div[@class='header' and .='Access token']/following-sibling::div";
	private String copyButton = "#btn-copy-token";
	private String confirmationMsg = "xpath = //div[@class='ant-notification-notice-description']";
	private String confirmationMsgCloseBtn = "xpath =//span[@class='anticon anticon-close ant-notification-close-icon']" ;
	private String displayToken = "xpath =//div[@class='token-box']";
    private String accessToken = "#list-box-token";
    
    private String account = "#list-box-account";
    private String showAccessTokenBtn = "#btn-show-token";
    private String accountHeaderText = "xpath = //div[@class='tabs-wrapper']/descendant::div[@class='header' and .='Account']";
    private String accountSubHeader1Text = "xpath = //div[@class='tabs-wrapper']/descendant::div[@class='sub-header']/child::span[contains(.,'.com')]";
    private String accountSubHeader2Text = "xpath = //div[@class='tabs-wrapper']/descendant::div[@class='sub-header']/child::label[text()= 'Change password']";
    private String accountPageLabelInfo = "xpath =//div[@class='label-info']";
    private String accountPageSaveBtn = "#btn-update-pwd";
    private String oldPassword = "#input-old-pwd";
    private String enterNewPassword = "#input-pwd-1";
    private String reEnterNewPasword = "#input-pwd-2";
    
    private String timeZone = "#list-box-timezone";
    private String timeZoneHeaderText = "xpath = //div[@class='tabs-wrapper']/descendant::div[@class='header' and .='Timezone']";
    private String timeZoneSubHeader1Text = "xpath = //div[@class='tabs-wrapper']/descendant::div[@class='sub-header' and .='Choose timezone']";
    private String timeZoneDropDown = "#btn-arrow-down-search-select-timezone";
    private String timeZoneList = "xpath = //span[@class='selected-item-text']";
    private String searchBarInTimezone = "#input-search-sel-search-select-timezone";
    private String firstTimeZone = "#search-select-timezone-0-single";
    private String selectedTimezone = "#search-select-timezone";
    private String timeZoneSaveButton = "#btn-save-timezone";
   
	private String softRefresh = "#btn-refresh" ;
	private String footerName = "xpath =//div[@class='footer' and .=' © Rakuten India ']";
	
	private String selectCapabilityDropdown = "#btn-arrow-down-search-select-capablity" ;

   

    public SettingsPage(Page page)
    {
    	this.page=page;
    }
    CommonPage commPage;
    LoginPage loginPage;
    ExcelUtility excel = new ExcelUtility();
    public void validateTheFooter()
    {
    	Assert.assertTrue(page.locator(footerName).isVisible());
    }
    
    public void navigateToApplicationTab()
    {
    	page.click(applicationTab);
    	//validate whether application page opened or not
    	page.waitForLoadState();
		String expectedUrl="**/settings/serviceSettings";
		page.waitForURL(expectedUrl);
		Assert.assertEquals(page.url().contains("/settings/serviceSettings"),true);
    }
    
    public void validateTimeZoneForMumbai(String timeZone,String expectedMessage)
    {
    	page.locator(timeZoneDropDown).click();
    	
    	page.waitForSelector(timeZoneList);
    	page.locator(searchBarInTimezone).fill(timeZone);
    	page.locator(firstTimeZone).click();
    	
    	//validate desired time zone selected or not 
    	Assert.assertEquals(page.locator(selectedTimezone).textContent().trim(), timeZone);
    	
    	page.locator(timeZoneSaveButton).click();
     	page.waitForSelector(confirmationMsg);
    	String actualText = page.locator(confirmationMsg).textContent().trim();
    	page.click(confirmationMsgCloseBtn);
    	Assert.assertEquals(actualText,expectedMessage);
    }
    
    
    public void validateTimeZoneOptions(String timeZones)
    {
    	String[] ExpectedTimeZone=timeZones.split("_");
    	page.locator(timeZoneDropDown).click();
    	
    	page.waitForSelector(timeZoneList);
    	
    	int num=page.locator(timeZoneList).count();
   
    	for(int i=0;i<num;i++)
    	{
    		Assert.assertEquals(page.locator(timeZoneList).nth(i).textContent().trim(),ExpectedTimeZone[i]);
    	}
    }
    public void validateTimeZoneTab()
    {
    	page.locator(timeZone).click();
    	
    	page.waitForSelector(timeZoneHeaderText);
    	//validate the text on time zone page
    	Assert.assertTrue(page.locator(timeZoneHeaderText).isVisible());
    	Assert.assertTrue(page.locator(timeZoneSubHeader1Text).isVisible());
    	
    }
    
    public void changePassword() throws EncryptedDocumentException, IOException
    {
    	commPage=new CommonPage(page);
    	
    			
    	String UpdatedPassword;
    	String OLDPassword;
    	String userName;
    	String value;
    	//fetch the old password
    	if(page.url().startsWith("https://qa"))
    	{
    		OLDPassword = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.settingsExcelPath,IPathConstant.settingsSheet ,"QA_updatedPassword");
    	}
    	else if(page.url().startsWith("https://stg"))
    	{
    		OLDPassword = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.settingsExcelPath,IPathConstant.settingsSheet ,"STG_updatedPassword");
    	}else
    	{
    		OLDPassword = "";
    	}
    	System.out.println("oldPassword :"+OLDPassword);
    	String newPassword="";
    	// Rakuten@123
    	int count = OLDPassword.length();
    	for(int i=0;i<count;i++)
    	{	if(!Character.isDigit(OLDPassword.charAt(i)))
    		{
    		 newPassword= newPassword + OLDPassword.charAt(i);
    		}
    	}
    	Random r=new Random();
        int num=r.nextInt(999);
    	newPassword=newPassword+num;
    	//update the excel old password with new password
    	
    	
    	if(page.url().startsWith("https://qa"))
    	{	
    		excel.wrightDataToExcelByUsingKeyProperty(IPathConstant.settingsExcelPath,IPathConstant.settingsSheet ,"QA_updatedPassword",newPassword);
    		UpdatedPassword = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.settingsExcelPath,IPathConstant.settingsSheet ,"QA_updatedPassword");
    		userName=excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.settingsExcelPath,IPathConstant.settingsSheet ,"QA_DemoUserName");
    	}
    	else if(page.url().startsWith("https://stg"))
    	{
    		excel.wrightDataToExcelByUsingKeyProperty(IPathConstant.settingsExcelPath,IPathConstant.settingsSheet ,"STG_updatedPassword",newPassword);
    		UpdatedPassword = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.settingsExcelPath,IPathConstant.settingsSheet ,"STG_updatedPassword");
    		userName=excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.settingsExcelPath,IPathConstant.settingsSheet ,"STG_DemoUserName");
    	}else
    	{
    		UpdatedPassword = "";
    		 userName ="";
    	}
    	
    	//change the old password with updated password
    	
    	
    	page.locator(oldPassword).fill(OLDPassword);
    	
    	page.locator(enterNewPassword).fill(UpdatedPassword);
    	page.locator(reEnterNewPasword).fill(UpdatedPassword);
    	
    	System.out.println("OLDPassword : "+ OLDPassword+"    UpdatedPassword :" + UpdatedPassword );
    	Assert.assertNotEquals(oldPassword,UpdatedPassword );
    	page.locator(accountPageSaveBtn).click();
    	
    	//logout from the application
    	commPage.logoutFromApplication();
    	
    	//validate the demo login working or not with updated password
    	loginPage.loginToApplication(userName, UpdatedPassword);
    	
    }
    public void loginToTheDemoUserAccount() throws EncryptedDocumentException, IOException
    {
    	
    	commPage=new CommonPage(page);
    	loginPage=new LoginPage(page);
    			
    	commPage.logoutFromApplication();
    	String userName;
    	String password;
    	if(page.url().startsWith("https://qa"))
    	{
    		userName=excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.settingsExcelPath,IPathConstant.settingsSheet ,"QA_DemoUserName");
    		password = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.settingsExcelPath,IPathConstant.settingsSheet ,"QA_updatedPassword");
    	}
    	else if(page.url().startsWith("https://stg"))
    	{
    		userName=excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.settingsExcelPath,IPathConstant.settingsSheet ,"STG_DemoUserName");
    		password = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.settingsExcelPath,IPathConstant.settingsSheet ,"STG_updatedPassword");
    	}
    	else
    	{
    		userName="";
    		password="";
    	}
    	
    	
    	//login to the application with demo credentials
    	loginPage.loginToApplication(userName, password);
    	
    }
    public void validateChangePasswordWithDifferentReEnterPassword()
    {
    	//String password=System.getenv("Password");
    	 String password = "R@kuten@12345"; 
    	 
    	 page.locator(oldPassword).fill(password);
    	 
    	 String changePassword= password+"$";
    	 String changePassword1= password+"*";
     	
     	page.locator(enterNewPassword).fill(changePassword);
     	page.locator(reEnterNewPasword).fill(changePassword1);
     	
     	Assert.assertTrue(page.locator(accountPageSaveBtn).getAttribute("class").contains("disabled"));
     	
    }
    
    public void validateChangePasswordWithWrongOldPassword(String expectedMessage) throws EncryptedDocumentException, IOException
    {
    	//String password = System.getenv("Password");
    
		   String password = "R@kuten@12345"; 	
    	
    	password=password+"*";
    	String changePassword= password+"$";
    	page.locator(oldPassword).fill(password);
    	
    	page.locator(enterNewPassword).fill(changePassword);
    	page.locator(reEnterNewPasword).fill(changePassword);
    	
    	page.locator(accountPageSaveBtn).click();
     	page.waitForSelector(confirmationMsg);
    	String actualText = page.locator(confirmationMsg).textContent().trim();
    	page.click(confirmationMsgCloseBtn);
    	Assert.assertEquals(actualText,expectedMessage);
    }
    
    public void validateChangePassword(String changePassword) throws EncryptedDocumentException, IOException
    {
    	//String password = System.getenv("Password");
    	String password;
    	if(page.url().startsWith("https://qa"))
    	{
    		
    		password = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.settingsExcelPath,IPathConstant.settingsSheet ,"QA_updatedPassword");
    	}
    	else if(page.url().startsWith("https://stg"))
    	{
    		
    		password = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.settingsExcelPath,IPathConstant.settingsSheet ,"STG_updatedPassword");
    	}
    	else
    	{
    		password="";
    	}
    	
    	page.locator(oldPassword).fill(password);
    	
    	page.locator(enterNewPassword).fill(changePassword);
    	page.locator(reEnterNewPasword).fill(changePassword);
    	
    	Assert.assertTrue(page.locator(accountPageSaveBtn).getAttribute("class").contains("disabled"));
    	
    	
    	
    }
    
    public void validateSaveBtn()
    {
    	Assert.assertTrue(page.locator(accountPageSaveBtn).getAttribute("class").contains("disabled"));
    }
    
    public void validateHideAccessTokenBtn(String expectedText)
    {
    
    	page.locator(showAccessTokenBtn).click();
    	Assert.assertTrue(page.locator(displayToken).isVisible());  	
    	Assert.assertEquals(page.locator(showAccessTokenBtn).textContent().trim(),expectedText);
    	page.locator(showAccessTokenBtn).click();
    	page.waitForTimeout(500);
    	boolean flag;
    	if(page.locator(displayToken).isVisible())
    	{
    		flag=false;
    	}
    	else
    	{
    		flag=true;
    	}
    	Assert.assertTrue(flag);	
    }
    
    public void validateShowAccessBtn(String expectedAccessToken)
    {
    	page.locator(showAccessTokenBtn).click();
    	Assert.assertTrue(page.locator(displayToken).isVisible());
    	Assert.assertEquals(page.locator(displayToken).textContent().trim(), expectedAccessToken);
    	
    }
    
    public void validateCopyBtn()
    {
    	page.locator(copyButton).click();
    	page.waitForSelector(confirmationMsg);
    	String actualText = page.locator(confirmationMsg).textContent().trim();
    	page.click(confirmationMsgCloseBtn);
    	Assert.assertEquals(actualText,"Copied");
    	
    }
    
    public void validateAccountsPage(String expectedText)
    {
    	Assert.assertEquals(page.locator(accountPageLabelInfo).textContent().trim(), expectedText);
    }
    
    public void navigateToAccountsPage()
    {
    	page.locator(account).click();
    	
    	//validate the Account page
    	Assert.assertTrue(page.locator(accountHeaderText).isVisible());
    	
    
    }
    
    public void validateAccountsTab()
    {
    	page.locator(account).click();
    	
    	//validate the Account page
    	Assert.assertTrue(page.locator(accountHeaderText).isVisible());
    	//String userID = System.getenv("UserName");
    	String userID = "rubina.shaiq@rakuten.com";
    	Assert.assertTrue(page.locator(accountSubHeader1Text).textContent().trim().contains(userID));
    	Assert.assertTrue(page.locator(accountSubHeader2Text).isVisible());
    }
    
    public void navigateToGeneralTab()
    {
    	page.locator(generalTab).click();
    	
    	//validate general tab page
    	Assert.assertTrue(page.locator(generalTab).getAttribute("class").trim().contains("activeRouter"));
    	Assert.assertTrue(page.locator(accessToken).isVisible());
    	Assert.assertTrue(page.locator(timeZone).isVisible());
    	Assert.assertTrue(page.locator(account).isVisible());
    	Assert.assertTrue(page.locator(accessTokenHeaderText).isVisible());
    }
    
    
    public void validateTheGeneralTabIsDisplayingDefault(String expectedText)
    {
    	Assert.assertTrue(page.locator(generalTab).getAttribute("class").trim().contains("activeRouter"));
    	Assert.assertTrue(page.locator(accessTokenHeaderText).isVisible());
    	Assert.assertEquals(page.locator(accessTokenSubHeaderText).textContent().trim(),expectedText );
    }
    
    
    public void validateTheSettingsPage()
    {
    	Assert.assertTrue(page.locator(applicationTab).isVisible());
    	Assert.assertTrue(page.locator(generalTab).isVisible());
    	Assert.assertTrue(page.locator(userAdministrationTab).isVisible());
    }
    
    public void validateTheSettingsPageTitle(String ExpectedTitle)
    {	
    	Assert.assertEquals(page.locator(settingsTitle).textContent().trim(), ExpectedTitle);
    	Assert.assertTrue(page.locator(settingsIcon).isVisible());
    }
    
    
    public void navigateToApplicationPage()
    {
    	//click on the application tab
    	page.locator(applicationTab).click();
    	
    	//validate whether the application tab opened or not
    	String expectedUrl="**/serviceSettings";
		page.waitForURL(expectedUrl);
		Assert.assertEquals(page.url().contains("/serviceSettings"),true);
		
		//validate the application page
		Assert.assertTrue(page.locator(apdexConfiguration).isVisible());
    }
    
    public void validateTraceRetentionTab()
    {
    	//click on the data retention policy tab
    	page.locator(dataRetentionPolicyTab).click();
    	
    	Assert.assertTrue(page.locator(traceRetentionTabActive).getAttribute("class").contains("activeTab"));
    	
    }
    
    public void validateDataRetentionPolicyPage()
    {
    	//click on the data retention policy tab
    	page.locator(dataRetentionPolicyTab).click();
    	
    	
    	Assert.assertTrue(page.locator(dataRetentionPolicySubHeader1).isVisible()); 	
    	Assert.assertTrue(page.locator(dataRetentionPolicySubHeader2).isVisible());
    	Assert.assertTrue(page.locator(selectApplicationDropdown).isVisible());
    	
    	//validate whether the trace latency section displayed or not by defalut
    	Assert.assertTrue(page.locator(traceRetentionConfiguration).isVisible());
    	Assert.assertTrue(page.locator(dBQueryConfiguration).isVisible());
    	
    }
    
    public void validateApdexConfigurationPage()
    {
    	// click on the apdex configuration tab
    	page.locator(apdexConfiguration).click();
    	
    	//validate whether the apdex configuration section dispalyed or not
    	Assert.assertTrue(page.locator(apdexconfigurationHeaderText).isVisible()); 	
    	Assert.assertTrue(page.locator(apdexconfigurationSubHeaderText).isVisible());
    	Assert.assertTrue(page.locator(selectApplicationDropdown).isVisible());
    	
    }
    
    public void setTheApdexConfigurationWithGivenResponseTime(String responseTime,String application,String expectedText, String capability)
    {
    	
       	util.selectTheOptionFromDropDown(page, selectCapabilityDropdown, capability);
       	
    	//select the application
    	util.selectTheOptionFromDropDownBySearch(page, selectApplicationDropdown, searchApplicationBox, application, searchedApplicationList);
    	
    	// click on the apdex configuration tab
    	page.locator(apdexConfiguration).click();
    	
    	//validate whether the apdex configuration section dispalyed or not
    	Assert.assertTrue(page.locator(apdexconfigurationHeaderText).isVisible());
    	
    	//set the Response time threshold 
    	page.locator(apdexResponsetime).click();
    	page.locator(apdexResponsetime).clear();
    	page.locator(apdexResponsetime).fill(responseTime);
    	page.locator(saveBtn).click();
    	
    	//validate the confirmation message
    	String actualText= page.locator(successMessage).innerHTML().trim();
    	Assert.assertEquals(actualText, expectedText);
    	
    	//close the pop up
    	page.locator(closeSuccessMessage).click();
    	
    }
    
    public void validateRetainAllErrorCheckBox()
    {
    	boolean flag =page.locator(retainAllErrorTracesRadioButton).isChecked();
    	page.click(retainAllErrorTraceCheckBox);
    	page.waitForTimeout(500);
    	Assert.assertNotEquals(page.locator(retainAllErrorTracesRadioButton).isChecked(),flag);
    }
    
    public void setMaximumSpans(String tracelatency,String maxSpans,String expectedText,String application)
    {
    	//select the application
    	util.selectTheOptionFromDropDownBySearch(page, selectApplicationDropdown, searchApplicationBox, application, searchedApplicationList);
    	
    	
    	//click on the data retention policy tab
    	page.locator(dataRetentionPolicyTab).click();
    	
    	//validate whether the trace latency section displayed or not
    	Assert.assertTrue(page.locator(traceRetentionConfiguration).isVisible());
    	
    	//click on the trace retention configuration tab
    	page.locator(traceRetentionConfiguration).click();
    	
    	//set the minimum trace latency
    	page.locator(minTraceLatencyTextField).click();
    	page.locator(minTraceLatencyTextField).clear();
    	page.locator(minTraceLatencyTextField).fill(tracelatency);
    	
    	//set the minimum trace latency
    	page.locator(maximumSpansTextField).click();
    	page.locator(maximumSpansTextField).clear();
    	page.locator(maximumSpansTextField).fill(maxSpans);
    	page.locator(latencysaveBtn).click();
    	
    	//validate the confirmation pop up 
    	String actualText= page.locator(successMessage).innerHTML().trim();
    	Assert.assertEquals(actualText, expectedText);
    	
    	//close the pop up
    	page.locator(closeSuccessMessage).click();

    }
    
    public void setTraceLatency(String tracelatency,String maxSpans,String expectedText,String application)
    {
    	
    	//select the application
    	util.selectTheOptionFromDropDownBySearch(page, selectApplicationDropdown, searchApplicationBox, application, searchedApplicationList);
    	
    	
    	//click on the data retention policy tab
    	page.locator(dataRetentionPolicyTab).click();
    	
    	//validate whether the trace latency section displayed or not
    	Assert.assertTrue(page.locator(traceRetentionConfiguration).isVisible());
    	
    	//click on the trace retention configuration tab
    	page.locator(traceRetentionConfiguration).click();
    	
    	//set the minimum trace latency
    	page.locator(minTraceLatencyTextField).click();
    	page.locator(minTraceLatencyTextField).clear();
    	page.locator(minTraceLatencyTextField).fill(tracelatency);
    	
    	
    	//set the minimum trace latency
    	page.locator(maximumSpansTextField).click();
    	page.locator(maximumSpansTextField).clear();
    	page.locator(maximumSpansTextField).fill(maxSpans);
    	
    	page.locator(latencysaveBtn).click();
    	
    	
    	
    	//validate the confirmation pop up 
    	String actualText= page.locator(successMessage).innerHTML().trim();
    	Assert.assertEquals(actualText, expectedText);
    	
    	//close the pop up
    	page.locator(closeSuccessMessage).click();

    	
    }
    
    public void validateTheDBQueryConfigurationPage()
    {
    	//click on the data retention policy tab
    	page.locator(dataRetentionPolicyTab).click();
    	
    	//validate whether the trace latency section displayed or not
    	Assert.assertTrue(page.locator(dBQueryConfiguration).isVisible());
    	
    	//click on the DB Query configuration tab
    	page.locator(dBQueryConfiguration).click();
    	
    	Assert.assertTrue(page.locator(dBQueryConfigurationActive).getAttribute("class").contains("activeTab"));
    	Assert.assertTrue(page.locator(dBQuerySubHeader).isVisible());
    	
    }
    
    public void setDBQueryLatency(String Querylatency,String expectedText,String application)
    {
    	
    	//select the application
    	util.selectTheOptionFromDropDownBySearch(page, selectApplicationDropdown, searchApplicationBox, application, searchedApplicationList);
    	
    	
    	//click on the data retention policy tab
    	page.locator(dataRetentionPolicyTab).click();
    	
    	//validate whether the trace latency section displayed or not
    	Assert.assertTrue(page.locator(dBQueryConfiguration).isVisible());
    	
    	//click on the DB Query configuration tab
    	page.locator(dBQueryConfiguration).click();
    	
    	//set the minimum trace latency
    	page.locator(minDBQueryLatencyTextField).click();
    	page.locator(minDBQueryLatencyTextField).clear();
    	page.locator(minDBQueryLatencyTextField).fill(Querylatency);
    	page.locator(queryLatencySaveBtn).click();
    	
    	//validate the confirmation pop up 
    	String actualText= page.locator(successMessage).innerHTML().trim();
    	Assert.assertEquals(actualText, expectedText);
    	
    	//close the pop up
    	page.locator(closeSuccessMessage).click();

    	
    }
    


}
