
package playWrightFactory;

import java.util.Properties;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import objectRepository.LoginPage;
import objectRepository.CommonPage;



@Listeners (listeners.ExtentReportListener.class)

public class BaseClass {
	
	
	PlaywrightFactory pf;
	 protected LoginPage loginPage;
	 protected CommonPage commPage ;
	 String userName;
	 String password;
	 protected Properties prop;
	 
	Playwright playwright;
	Browser browser;
	BrowserContext browserContext;
	public static Page page;
			
	@BeforeTest
	public void launchBrowser()
	{
		pf=new PlaywrightFactory();
//		String browserName  = System.getenv("Browser");
		String browserName="chrome";
		page = pf.initBrowser(browserName);
//		String url =System.getenv("Url");
		String url = "https://stg-observability.sixthsense.rakuten.com/";
		page.navigate(url);
		page.waitForTimeout(5000);
	}
	@BeforeClass 
	public void loginToTheApplication() throws InterruptedException
	{
		commPage=new CommonPage(page);
		System.out.println(page.title());
		loginPage=new LoginPage(page);
//		 userName= System.getenv("UserName");
//		 password= System.getenv("Password");
		 userName = "rubina.shaiq@rakuten.com";
		 password = "R@kuten@12345";
//		userName = "yasmeen.taj@rakuten.com";
//		password = "Rakuten@1234";
		loginPage.loginToApplication(userName, password);
		System.out.println("*********login to the Application successfully****************");
	}
	@AfterClass 
	public void logoutFromApplication()
	{
		commPage.logoutFromApplication();
		System.out.println("*********logout from the Application successfully****************");
		page.waitForTimeout(500);
	}
	
	@AfterTest
	public void closeBrowser()
	{
		page.context().browser().close();
	}
}