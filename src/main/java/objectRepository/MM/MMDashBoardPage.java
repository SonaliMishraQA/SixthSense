package objectRepository.MM;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;

import org.testng.Assert;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Locator.ClickOptions;
import com.microsoft.playwright.Locator.HoverOptions;
import com.microsoft.playwright.Page;

import genericUtilities.GenericMethods;

public class MMDashBoardPage {

	Page page;
	GenericMethods util=new GenericMethods();
		
	private String Appusagetextheader = " xpath = //div[@class='usage-kpis-container']/descendant::div[@class='card-header']" ;
	private String newUsericon = "xpath = //div[@class='usage-kpis-container']//*[name()='svg']//*[name()='g' and @clip-path='#clip0_409_17' ]//*";
	private String newUsersText = " xpath = //div[@class='usage-kpis-container']/descendant::div[@class='textLabel'][position()=1]";
	private String newUserInfoIcon = " xpath = //div[@class='usage-kpis-container']/descendant::*[name()='path' and @data-name='info filled']/parent::*";
	private String NewUserInfoToolTip = " xpath = //div[@class='rk-tooltip-popper append-to-body ']";
	private String UsersPerMinText = "xpath = //div[@class='usage-kpis-container']/descendant::div[@class='textLabel'][position()=2]";
	private String newUsersCount = "xpath = //div[text()='New users ']//parent::div[@class='text-container']/descendant::div[@class='textVal fair']";
	private String usersPerMinCount = "xpath = //div[text()='Users/min ']//parent::div[@class='text-container']/descendant::div[@class='textVal fair']";
	
	private String sessionsIcon = "xpath = //div[@class='usage-kpis-container']//*[name()='svg']//*[name()='g' and @clip-path='#clip0_409_21' ]//*[1]";
	private String SessionText = " xpath = //div[@class='usage-kpis-container']/descendant::div[@class='textLabel'][position()=3]";
	private String sessionPerMinText = " xpath = //div[@class='usage-kpis-container']/descendant::div[@class='textLabel'][position()=4]";
	private String sessionCount = "xpath = //div[text()='Sessions ']//parent::div[@class='text-container']/descendant::div[@class='textVal fair']";
	private String sessionPerMinCount = "xpath = //div[text()='Sessions/min ']//parent::div[@class='text-container']/descendant::div[@class='textVal fair']";
	
	private String appLaunchesIcon = "xpath = //div[@class='usage-kpis-container']//*[name()='svg']//*[name()='path' and @stroke='#fff' ]";
	private String appLaunchesText = "xpath = //div[@class='usage-kpis-container']/descendant::div[@class='textLabel'][position()=5]";
	private String appLaunchesPerMinText = "xpath = //div[@class='usage-kpis-container']/descendant::div[@class='textLabel'][position()=6]";
	private String appLaunchesCount = " xpath = //div[text()='App launches ']//parent::div[@class='text-container']/descendant::div[@class='textVal fair']";
	private String launchesPerMinCount = "xpath = //div[text()='Launches/min ']//parent::div[@class='text-container']/descendant::div[@class='textVal fair']";
	
	private String crashKPSIsHeader = "xpath = //div[@class='crash-kpis-container']/descendant::div[@class='card-header']";
	private String crashestext = "xpath = //div[@class='crash-kpis-container']/descendant::div[@class='textLabel'][position()=1]";
	private String crashesPerMinText = "xpath = //div[@class='crash-kpis-container']/descendant::div[@class='textLabel'][position()=2]";
	private String CrashFreeUsersText = " xpath = //div[@class='crash-kpis-container']/descendant::div[@class='textLabel'][position()=3]";
	
	private String crashesPerMinCount = "xpath = //div[text()='Crashes/min ']//parent::div[@class='text-container']/descendant::div[@class='textVal fair']";
	private String crashFreeUsersCount = " xpath = //div[text()='Crash free users ']//parent::div[@class='text-container']/descendant::div[@class='textVal fair']";
	private String crashesCount = "xpath = //div[text()='Crashes ']//parent::div[@class='text-container']/descendant::div[@class='textVal fair']";
	
	private String crashesByOSHeader = "xpath = //div[@class='crash-kpis-container']/descendant::div[@class='crashes-graph-header']";
	private String androidCrashPercentValue= "xpath = //div[@class='guage-text-label' and contains(text(),'Android')]/following-sibling::div[@class='guage-text-label' and contains(text(),'%')]";
	private String iosCrashPercentValue = "xpath = //div[@class='guage-text-label' and contains(text(),'iOS')]/following-sibling::div[@class='guage-text-label' and contains(text(),'%')]";
	private String androidCrashPercentLabel = "xpath = //div[@class='crashes-graph-container']/descendant::div[@class='guage-text-label'][position()=1]";
	private String iosCrashPercentLabel = "xpath = //div[@class='crashes-graph-container']/descendant::div[@class='guage-text-label'][position()=3]";
	private String androidCrashPercentageColor = "xpath = //div[@class='crashes-graph-container']/descendant::div[@class='guage-label-legend guage-label-color-left']";
	private String iosCrashPercentageColor = "xpath = //div[@class='crashes-graph-container']/descendant::div[@class='guage-label-legend guage-label-color-right']";
	private String androidCrashSection = "xpath = //*[name()='g' and @class='apexcharts-series apexcharts-radial-series']/child::*[name()='path']";
	private String iosCrashSection = "xpath = //*[name()='g' and @class='apexcharts-radialbar-track apexcharts-track']/child::*[name()='path']";
	
	
	private String performanceKPISHeader = " xpath = //div[@class='perfm-kpis-container']/descendant::div[@class='card-header']";
	private String WebRequestIcon = " xpath = //div[.='Number of web requests ']/ancestor::div[@class='container bg-dark-black info-cards']/descendant::*[name()='svg']//*[name()='path'][4]";
	private String errorPerRateIcon = "xpath= //div[.='Error % rate ']/ancestor::div[@class='container bg-dark-black info-cards']/descendant::*[name()='svg']//*[name()='path'][4]";
	private String httpResponseIcon = " xpath = //div[.='HTTP response time ']/ancestor::div[@class='container bg-dark-black info-cards']/descendant::*[name()='svg']//*[name()='circle']";
	private String WebRequestText = " xpath = //div[@class='perfm-kpis-container']/descendant::div[@class='textLabel'][position()=1]";  
	private String errorPerRateText = " xpath = //div[@class='perfm-kpis-container']/descendant::div[@class='textLabel'][position()=3]";  
	private String httpRepsonseTimeText = " xpath = //div[@class='perfm-kpis-container']/descendant::div[@class='textLabel'][position()=2]";
	private String httpRequestCount = "xpath = //div[text()='Number of web requests ']/ancestor::div[@class='container bg-dark-black info-cards']/descendant::div[@class='textVal fair']";
	private String httpresponseTimeValue = "xpath = //div[text()='HTTP response time ']/ancestor::div[@class='container bg-dark-black info-cards']/descendant::div[@class='textVal fair']";
	private String errorRateValue = "xpath = //div[text()='Error % rate ']/ancestor::div[@class='container bg-dark-black info-cards']/descendant::div[@class='textVal fair']";
	
	
	private String appUsgaeHeaderText = "xpath = //div[@class='device-usage-container']/descendant::div[@class='card-header']";
	private String totalInstallSubHeader = "xpath = //div[@class='device-usage-container']/descendant::div[@class='installs']";
	private String topDevicesSubHeader = "xpath = //div[@class='device-usage-container']/descendant::div[@class='top-devices']";
	private String topversionsSubHeader = "xpath = //div[@class='device-usage-container']/descendant::div[@class='top-versions-header']";
	private String totalInstallIosIcon = "xpath = //img[@alt='iOS icon']";
	private String totalInstallAndroidIcon = "xpath = //img[@alt='Android icon'] ";
	private String totalInstallIosLabel = "xpath = //div[@class='installs-devices-container']/descendant::div[@class='textLabel'][position()=1]";
	private String totalInstallAndroidLabel = "xpath = //div[@class='installs-devices-container']/descendant::div[@class='textLabel'][position()=2]";
	private String totalInstallAndroidValue = "xpath = //div[@class='installs-devices-container']/descendant::div[@class='textVal fair'][position()=2]";
	private String totalInstallIosValue = "xpath = //div[@class='installs-devices-container']/descendant::div[@class='textVal fair'][position()=1]";
	
	private String topDevicesInstallList = "xpath = //ol[@class='list-group list-group-flush top-devices-list']/child::li[contains(text(),'.')]";
	
	private String iosTopVersionsInstallList = "xpath = //div[@class='ios-container']/descendant::li";
	private String androidTopVersionsInstallList ="xpath = //div[@class='android-container']/descendant::li";
	private String iosNoData = "xpath = //div[@class='ios-container']/descendant::div[@class='icon-message']";
	private String androidNoData ="xpath = //div[@class='android-container']/descendant::div[@class='icon-message']";
	
	private String topVersionsIosLabel = "xpath = //div[@class='top-versions-container']/descendant::div[@class='ios-header']";
	private String topVersionsAndroidlabel = "xpath = //div[@class='top-versions-container']/descendant::div[@class='android-header']";
	private String calanderValue = "xpath = //div[@class='selected-text ellipsis bg-text']";
	private String refresh = "#btn-refresh";

	

	   
	  
	 
	   public MMDashBoardPage(Page page)
	   {
		   this.page=page;
	   }
	   
	   public void validateCrashesIntegration()
	   {
		   
		page.locator(crashesCount).click();
		String expectedUrl="**/mobile/kpis/crashes";
		page.waitForURL(expectedUrl);
		Assert.assertEquals(page.url().contains("/mobile/kpis/crashes"),true);
			
	   }
	   
	   public void validateErrorRateIntegration()
	   {
		   page.locator(errorRateValue).click();
		   String expectedUrl="**/mobile/kpis/performance/errors";
			page.waitForURL(expectedUrl);
			Assert.assertEquals(page.url().contains("/mobile/kpis/performance/errors"),true);
	   }
	   
	   public double fetchTheCalenderTimeInMinutes()
	   {
		   //fetch the calendar text from the calendar icon
			String calenderValue=page.locator(calanderValue).textContent().trim().trim();
			String num = "";
			double timeInMins = 0;
			//calculate the minutes from the given time range
			for (int j=0;j<calenderValue.length();j++)
			{
				if(Character.isDigit(calenderValue.charAt(j)))
				{
					num=num+calenderValue.charAt(j);
				}
			}
			timeInMins=Integer.parseInt(num);
			if(calenderValue.contains("hours"))
			{
				timeInMins=timeInMins*60;
			}else if (calenderValue.contains("day"))
			{
				timeInMins=timeInMins*60*24;
			}else if (calenderValue.contains("week"))
			{
				timeInMins=timeInMins*60*24*7;
			}else if (calenderValue.contains("month"))
			{
				timeInMins=timeInMins*60*24*7*30;
			}
			return timeInMins;
	   }
	   
	   public void validateErrorPercentage(String errorCalls,String totalRequests)
	   {
		   page.waitForTimeout(1000);
		   page.waitForSelector(errorRateValue);
		   String actualErrorRate = page.locator(errorRateValue).textContent().trim();
		   System.out.println("totalRequests :"+totalRequests);
		   
		   System.out.println("errorCalls :"+errorCalls);
		   
		   
		   double expectedErrorRate = (Double.parseDouble(errorCalls)/Double.parseDouble(totalRequests))*100;
		   
		   DecimalFormat df=new DecimalFormat("0.00");
		   df.setRoundingMode(RoundingMode.DOWN);
		   System.out.println("actualErrorRate : "+ actualErrorRate +"--------expectedErrorRate : "+df.format(expectedErrorRate));
		   Assert.assertTrue(actualErrorRate.contains(df.format(expectedErrorRate)));
	   }
	   
	   public void validateHttpResponseTime()
	   {
		   Assert.assertNotNull(page.locator(httpresponseTimeValue).textContent().trim());
	   }
	   
	   public void validateWebRequestCount(String expectedCount)
	   {
		   page.locator(refresh).click();
		   page.waitForTimeout(1000);
		   page.waitForSelector(httpRequestCount);
		   Assert.assertTrue(page.locator(httpRequestCount).textContent().trim().equalsIgnoreCase(expectedCount));
	   }
	   
	   public void validateTopVersionsInstallsForIosWhenAndroidOsSelected()
	   {
		   page.waitForSelector(iosNoData);
		   Assert.assertTrue(page.locator(iosNoData).isVisible());
	   }
	   
	   public void validateTopVersionsInstallsForAndroidWhenIosOsSelected()
	   {
		   page.waitForSelector(androidNoData);
		   Assert.assertTrue(page.locator(androidNoData).isVisible());
	   }
	   
	   public void validateTopVersionsInstallsForAndroid(String versions)
	   {
		   String[] expectedVersions = versions.split(",");
		   page.waitForTimeout(1000);
		   page.waitForSelector(androidTopVersionsInstallList);
		   Locator actualVersionsList = page.locator(androidTopVersionsInstallList);
		   
		   for(int i=0;i<expectedVersions.length;i++)
		   {
			   System.out.println(actualVersionsList.nth(i).textContent().trim() +"------"+ expectedVersions[i]);
			   Assert.assertTrue(expectedVersions[i].contains(actualVersionsList.nth(i).textContent().trim()));
		   }
	   }
	   
	   
	   
	   public void validateTopVersionsInstallsForIos(String versions)
	   {
		   String[] expectedVersions = versions.split(",");
		   page.waitForTimeout(1000);
		   page.waitForSelector(iosTopVersionsInstallList);
		   Locator actualVersionsList = page.locator(iosTopVersionsInstallList);
		   
		   for(int i=0;i<expectedVersions.length;i++)
		   {
			   System.out.println(actualVersionsList.nth(i).textContent().trim() +"------"+ expectedVersions[i]);
			   Assert.assertTrue(expectedVersions[i].contains(actualVersionsList.nth(i).textContent().trim()));
		   }
	   }
	   
	   public void validateTheTopDeviceInstalls(String devices)
	   {
		   String[] expectedDevices = devices.split(",");
		   Arrays.sort(expectedDevices);
		   page.locator(refresh).click();
		   page.waitForTimeout(1000);
		   page.waitForSelector(topDevicesInstallList);
		   Locator actualDevicesList = page.locator(topDevicesInstallList);
		  
		   
		   for(int i=0;i<actualDevicesList.count();i++)
		   {
			   Assert.assertTrue(actualDevicesList.nth(i).textContent().trim().contains(expectedDevices[i]));
			   System.out.println(actualDevicesList.nth(i).textContent().trim() + "--------"+expectedDevices[i]);
		   } 
	   }
	   
	   public void validateTheTopDeviceInstalls(String androidDevices,String iosDevices)
	   {
		   String devices = androidDevices+","+iosDevices;
		   String[] expectedDevices = devices.split(",");
		   page.locator(refresh).click();
		   Arrays.sort(expectedDevices);
		   page.waitForTimeout(1000);
		   page.waitForSelector(topDevicesInstallList);
		   Locator actualDevicesList = page.locator(topDevicesInstallList);
		   
		   for(int i=0;i<actualDevicesList.count();i++)
		   {
			   Assert.assertTrue(actualDevicesList.nth(i).textContent().trim().contains(expectedDevices[i]));
			   System.out.println(actualDevicesList.nth(i).textContent().trim() + "--------"+expectedDevices[i]);
		   } 
	   }
	   
	   public void validateTotalInstallsForIos(String totalInstalls)
	   {
		   page.waitForTimeout(1000);
		   page.waitForSelector(totalInstallIosValue);
		   String actualTotalInstalls = page.locator(totalInstallIosValue).textContent().trim();
		   Assert.assertEquals(actualTotalInstalls, totalInstalls);
	   }
	   
	   public void validateTotalInstallsForAndroid(String totalInstalls)
	   {
		   page.locator(refresh).click();
		   page.waitForTimeout(1500);
		   page.waitForSelector(totalInstallAndroidValue);
		   String actualTotalInstalls = page.locator(totalInstallAndroidValue).textContent().trim();
		   Assert.assertEquals(actualTotalInstalls, totalInstalls);
	   }
	   
	   public void validateCrashByOsPercentageForAndroid(int Crashes)
	   {	
		   page.waitForTimeout(2000);
		   DecimalFormat df=new DecimalFormat("0.00");
	   DecimalFormat df1 =new DecimalFormat("#");
	   df.setRoundingMode(RoundingMode.DOWN);
	 
		   	double AndroidCrashPercentage = (Double.valueOf(Crashes)/Double.valueOf(Crashes))*100;
		   	page.waitForTimeout(500);
		   	page.waitForSelector(androidCrashPercentValue);
		   	String actualAndroidCrashPercentage = page.locator(androidCrashPercentValue).textContent().trim();
		   	String actualIosCrashPercentage = page.locator(iosCrashPercentValue).textContent().trim();
		   	
		   	if(df.format(AndroidCrashPercentage).contains(".00"))
		   	{
		   		System.out.println("actualAndroidCrashPercentage :"+actualAndroidCrashPercentage + "---------AndroidCrashPercentage :"+AndroidCrashPercentage);
		   		System.out.println("actualIosCrashPercentage :"+actualIosCrashPercentage );
		   		Assert.assertEquals(actualAndroidCrashPercentage, df1.format(AndroidCrashPercentage)+"%");
		   		Assert.assertEquals(actualIosCrashPercentage, "0%");
		   	}
		   	else
		   	{
		   		System.out.println("actualAndroidCrashPercentage :"+actualAndroidCrashPercentage + "---------AndroidCrashPercentage :"+AndroidCrashPercentage);
		   		System.out.println("actualIosCrashPercentage :"+actualIosCrashPercentage );
		   		Assert.assertEquals(actualAndroidCrashPercentage, df.format(AndroidCrashPercentage)+"%");
		   		Assert.assertEquals(actualIosCrashPercentage, "0%");
		   	}
	   }
	   public void validateCrashByOsPercentageForIos(int Crashes)
	   {	DecimalFormat df=new DecimalFormat("0.00");
	   DecimalFormat df1 =new DecimalFormat("#");
	   df.setRoundingMode(RoundingMode.DOWN);
	 
		   	
		   	double iosCrashPercentage = (Double.valueOf(Crashes)/Double.valueOf(Crashes))*100;
		   	page.waitForTimeout(500);
		   	page.waitForSelector(androidCrashPercentValue);
		   	String actualAndroidCrashPercentage = page.locator(androidCrashPercentValue).textContent().trim();
		   	String actualIosCrashPercentage = page.locator(iosCrashPercentValue).textContent().trim();
		   	
		   	if(df.format(iosCrashPercentage).contains(".00"))
		   	{
		   		System.out.println("actualAndroidCrashPercentage :"+actualAndroidCrashPercentage );
		   		System.out.println("actualIosCrashPercentage :"+actualIosCrashPercentage + "---------iosCrashPercentage :"+iosCrashPercentage);
		   		Assert.assertEquals(actualAndroidCrashPercentage, "0%");
		   		Assert.assertEquals(actualIosCrashPercentage, df1.format(iosCrashPercentage)+"%");
		   	}
		   	else
		   	{
		   		System.out.println("actualAndroidCrashPercentage :"+actualAndroidCrashPercentage );
		   		System.out.println("actualIosCrashPercentage :"+actualIosCrashPercentage + "---------iosCrashPercentage :"+iosCrashPercentage);
		   		Assert.assertEquals(actualAndroidCrashPercentage, "0%");
		   		Assert.assertEquals(actualIosCrashPercentage, df.format(iosCrashPercentage)+"%");
		   	}
	   }
	   
	   
	   
	   
	   public void validateCrashByOsPercentage(int androidCrashes,int iosCrahses)
	   {	
		   page.waitForTimeout(2000);
		   DecimalFormat df=new DecimalFormat("0.00");
	   DecimalFormat df1 =new DecimalFormat("#");
	   df.setRoundingMode(RoundingMode.DOWN);
	   int totalCrashes = androidCrashes+iosCrahses;
	   System.out.println("totalCrashes : "+ totalCrashes);
		   	double AndroidCrashPercentage = (Double.valueOf(androidCrashes)/Double.valueOf(totalCrashes))*100;
		   	double iosCrashPercentage = (Double.valueOf(iosCrahses)/Double.valueOf(totalCrashes))*100;
		   	
		   	String actualAndroidCrashPercentage = page.locator(androidCrashPercentValue).textContent().trim();
		   	String actualIosCrashPercentage = page.locator(iosCrashPercentValue).textContent().trim();
		   	
		   	if(df.format(AndroidCrashPercentage).contains(".00"))
		   	{
		   		System.out.println("actualAndroidCrashPercentage :"+actualAndroidCrashPercentage + "---------AndroidCrashPercentage :"+AndroidCrashPercentage);
		   		System.out.println("actualIosCrashPercentage :"+actualIosCrashPercentage + "---------iosCrashPercentage :"+iosCrashPercentage);
		   		Assert.assertEquals(actualAndroidCrashPercentage, df1.format(AndroidCrashPercentage)+"%");
		   		Assert.assertEquals(actualIosCrashPercentage, df1.format(iosCrashPercentage)+"%");
		   	}
		   	else
		   	{
		   		System.out.println("actualAndroidCrashPercentage :"+actualAndroidCrashPercentage + "---------AndroidCrashPercentage :"+AndroidCrashPercentage);
		   		System.out.println("actualIosCrashPercentage :"+actualIosCrashPercentage + "---------iosCrashPercentage :"+iosCrashPercentage);
		   		Assert.assertEquals(actualAndroidCrashPercentage, df.format(AndroidCrashPercentage)+"%");
		   		Assert.assertEquals(actualIosCrashPercentage, df.format(iosCrashPercentage)+"%");
		   	}
	   }
	   
	   public void validateCrashFreeUserCount(String crashFreeUsers,String UsersCount)
	   {
		   page.waitForTimeout(2000);
		   float crashFreeusers = Float.parseFloat(crashFreeUsers);
		   
		   float totalUsers =Float.parseFloat(UsersCount);
		   
		   float crashFreeUserPercentage = (crashFreeusers/totalUsers)*100;
		   DecimalFormat df=new DecimalFormat("0.00");
		   df.setRoundingMode(RoundingMode.DOWN);
		   String actualCrashFreeUserPercentage = page.locator(crashFreeUsersCount).textContent().trim();
		   System.out.println("actualCrashFreeUserPercentage : "+ actualCrashFreeUserPercentage +"--------- crashFreeUserPercentage:"+df.format(crashFreeUserPercentage));
		   Assert.assertEquals(actualCrashFreeUserPercentage, df.format(crashFreeUserPercentage)+"%");
	   }
	   
	   public void validateCrashFreeUserCount(String androidCrashFreeUsers,String IosCrashFreeUsers,String androidUsersCount,String iosUsersCount)
	   {
		   page.waitForTimeout(2000);
		   double crashFreeUsers = Double.parseDouble(androidCrashFreeUsers)+Double.parseDouble(IosCrashFreeUsers);
		   System.out.println("crashFreeUsers :"+crashFreeUsers);
		   double totalUsers = Double.parseDouble(androidUsersCount)+Double.parseDouble(iosUsersCount);
		   
		   double crashFreeUserPercentage = (crashFreeUsers/totalUsers)*100;
		   DecimalFormat df=new DecimalFormat("0.00");
		   df.setRoundingMode(RoundingMode.DOWN);
		   page.waitForTimeout(500);
		   page.waitForSelector(crashFreeUsersCount);
		   String actualCrashFreeUserPercentage = page.locator(crashFreeUsersCount).textContent().trim();
		   
		   System.out.println("actualCrashFreeUserPercentage : "+ actualCrashFreeUserPercentage +"--------- crashFreeUserPercentage:"+crashFreeUserPercentage);
		   Assert.assertEquals(actualCrashFreeUserPercentage, df.format(crashFreeUserPercentage)+"%");
	   }
	   
	   public void validateCrashesPerMinCount(String androidCrashesCount,String iosCrashesCount)
	   {
		   int expectedCount = androidCrashesCount.split(",").length+iosCrashesCount.split(",").length;
		   page.waitForTimeout(1000);
		   String actualCrashesPerMin=page.locator(crashesPerMinCount).textContent().trim();
			System.out.println("actualCrashesPerMin : "+actualCrashesPerMin+"-------- fetchTheCalenderTimeInMinutes :"+ fetchTheCalenderTimeInMinutes());
			
			DecimalFormat df=new DecimalFormat("#");
			Assert.assertEquals(actualCrashesPerMin,(df.format(expectedCount/fetchTheCalenderTimeInMinutes())));
	   }
	   
	   public void validateCrashesPerMinCount(String crashesCount)
	   {
		   int expectedCount = crashesCount.split(",").length;
		   page.waitForTimeout(1000);
		   String actualCrashesPerMin=page.locator(launchesPerMinCount).textContent().trim();
			System.out.println("actualLaunchesPerMin : "+actualCrashesPerMin+"-------- fetchTheCalenderTimeInMinutes :"+ fetchTheCalenderTimeInMinutes());
			
			DecimalFormat df=new DecimalFormat("#");
			Assert.assertEquals(actualCrashesPerMin,(df.format(expectedCount/fetchTheCalenderTimeInMinutes())));
	   }
	   
	   public void validateCrashesCount(String androidCrashesCount,String iosCrashesCount )
	   {
		   int expectedCount = androidCrashesCount.split(",").length+iosCrashesCount.split(",").length;
			
		   String actualCrashesCount = page.locator(crashesCount).textContent().trim();
		   Assert.assertEquals(Integer.parseInt(actualCrashesCount),expectedCount);
	   }
	   
	   public void validateCrashesCountForSpecificAppVersion(String CrashesCount )
	   {
		   page.waitForTimeout(1000);
		   String actualCrashesCount = page.locator(crashesCount).textContent().trim();
		   Assert.assertEquals(actualCrashesCount,CrashesCount);
	   }
	   
	   public void validateCrashesCount(String CrashesCount )
	   {
		   
		   int expectedCount = CrashesCount.split(",").length;
		   page.waitForTimeout(1000);
		   String actualCrashesCount = page.locator(crashesCount).textContent().trim();
		   Assert.assertEquals(Integer.parseInt(actualCrashesCount),expectedCount);
	   }
	   
	   public void validateAppLaunchPerMinCount(String androidAppLaunchount,String iosAppLaunchCount )
	   {
		   int expectedCount = Integer.parseInt(androidAppLaunchount)+Integer.parseInt(iosAppLaunchCount);
		   page.waitForTimeout(1000);
		   String actualLaunchesPerMin=page.locator(launchesPerMinCount).textContent().trim();
			System.out.println("actualLaunchesPerMin : "+actualLaunchesPerMin+"-------- fetchTheCalenderTimeInMinutes :"+ fetchTheCalenderTimeInMinutes());
			
			DecimalFormat df=new DecimalFormat("#");
			Assert.assertEquals(actualLaunchesPerMin,(df.format(expectedCount/fetchTheCalenderTimeInMinutes())));
	   }
	   
	   public void validateAppLaunchPerMinCount(String appLaunchount)
	   {
		   int expectedCount = Integer.parseInt(appLaunchount);
		   page.waitForTimeout(1000);
		   String actualLaunchesPerMin=page.locator(launchesPerMinCount).textContent().trim();
			System.out.println("actualLaunchesPerMin : "+actualLaunchesPerMin+"-------- fetchTheCalenderTimeInMinutes :"+ fetchTheCalenderTimeInMinutes());
			
			DecimalFormat df=new DecimalFormat("#");
			Assert.assertEquals(actualLaunchesPerMin,(df.format(expectedCount/fetchTheCalenderTimeInMinutes())));
	   }
	   
	   public void validateAppLaunchCount(String androidAppLaunchount,String iosAppLaunchCount)
	   {
		   int expectedCount = Integer.parseInt(androidAppLaunchount)+Integer.parseInt(iosAppLaunchCount);
		   page.locator(refresh).click();
		   page.waitForTimeout(1000);
		   String actualAppLauchCount = page.locator(appLaunchesCount).textContent().trim();
		   Assert.assertEquals(Integer.parseInt(actualAppLauchCount),expectedCount);
	   }
	   
	   public void validateAppLaunchCount(String appLaunchount)
	   {
		   page.locator(refresh).click();
		   page.waitForTimeout(1000);
		   page.waitForSelector(appLaunchesCount);
		   int expectedCount = Integer.parseInt(appLaunchount);
		   String actualAppLauchCount = page.locator(appLaunchesCount).textContent().trim();
		   Assert.assertEquals(Integer.parseInt(actualAppLauchCount),expectedCount);
	   }
	   
	   public void validateSessionsCount(String ExpectedSessionsCount)
	   {
		   int expectedCount = Integer.parseInt(ExpectedSessionsCount);
		   page.locator(refresh).click();
		   page.waitForTimeout(1000);
		   page.waitForSelector(sessionCount);
		   int actualCount =Integer.parseInt(page.locator(sessionCount).textContent().trim());
		   
		   Assert.assertEquals(actualCount, expectedCount);
		   
	   }
	   
	   public void validateSessionsPerMinCount(String ExpectedSessionsCount)
	   {
		   int expectedCount = Integer.parseInt(ExpectedSessionsCount);
		   page.waitForTimeout(1000);
		   String actualSessionPerMin = page.locator(sessionPerMinCount).textContent().trim();
		   System.out.println("actualSessionPerMin : "+actualSessionPerMin+"-------- fetchTheCalenderTimeInMinutes :"+ fetchTheCalenderTimeInMinutes());
		   DecimalFormat df=new DecimalFormat("#");
		   Assert.assertEquals(actualSessionPerMin, df.format(expectedCount/fetchTheCalenderTimeInMinutes()));
	   }
	   
	   public void validateUserPerMinCount(String androidNewUserCount,String iosNewUserCount )
	   {
		   int expectedCount = Integer.parseInt(androidNewUserCount)+Integer.parseInt(iosNewUserCount);
		   
		   String actualUserPerMin=page.locator(usersPerMinCount).textContent().trim();
			System.out.println("actualUserPerMin : "+actualUserPerMin+"-------- fetchTheCalenderTimeInMinutes :"+ fetchTheCalenderTimeInMinutes());
			
			DecimalFormat df=new DecimalFormat("#");
			Assert.assertEquals(actualUserPerMin,(df.format(expectedCount/fetchTheCalenderTimeInMinutes())));
	   }
	   
	   public void validateUserPerMinCount(String NewUserCount )
	   {
		   int expectedCount = Integer.parseInt(NewUserCount);
		   page.waitForTimeout(1000);
		   String actualUserPerMin=page.locator(usersPerMinCount).textContent().trim();
		   System.out.println("actualUserPerMin : "+actualUserPerMin+"-------- fetchTheCalenderTimeInMinutes :"+ fetchTheCalenderTimeInMinutes());
		   DecimalFormat df=new DecimalFormat("#");
			Assert.assertEquals(actualUserPerMin,(df.format(expectedCount/fetchTheCalenderTimeInMinutes())));
	   }
	   
	   public void validateNewUserCount(String androidNewUserCount,String iosNewUserCount)
	   {
		   int expectedCount = Integer.parseInt(androidNewUserCount)+Integer.parseInt(iosNewUserCount);
		   String actualNewUserCount = page.locator(newUsersCount).textContent().trim();
		   Assert.assertEquals(expectedCount, Integer.parseInt(actualNewUserCount));
		   
	   }
	   
	   public void validateNewUserCount(String NewUserCount)
	   {
		   int expectedCount = Integer.parseInt(NewUserCount);
		  page.waitForTimeout(1000);
		   String actualNewUserCount = page.locator(newUsersCount).textContent().trim();
		   Assert.assertEquals(Integer.parseInt(actualNewUserCount),expectedCount);
		   
	   }
	   
	   
	   
	   public void validateDashBoardPage(String expectedText)
	   {
		   Assert.assertTrue(page.locator(Appusagetextheader).textContent().trim().equalsIgnoreCase(expectedText));
	   }
	   
	   public void validateIcon(String icon,String elementColor)
	   {
		   Assert.assertEquals((page.locator(icon).evaluate("element => getComputedStyle(element).stroke")),elementColor);
	   }
	   
	   
	   public void validateNewUsersIconAndLabel(String expectedLabel,String elementColor )
	   {
		   validateIcon(newUsericon,elementColor);
		   
		   Assert.assertEquals(page.locator(newUsersText).textContent().trim(), expectedLabel);
	   }
	   
	   public void validateNewUsersTooltip(String expectedToolTip)
	   {
		   page.locator(newUserInfoIcon).hover();
		   Assert.assertEquals(page.locator(NewUserInfoToolTip).textContent().trim(), expectedToolTip);
	   }
	   
	   public void validateNewUsersPerMinLabel(String expectedLabel)
	   {
		   Assert.assertEquals(page.locator(UsersPerMinText).textContent().trim(),expectedLabel );
	   }
	   
	   public void validateSessionsIconAndLabel(String expectedLabel,String elementColor)
	   {
		   validateIcon(sessionsIcon,elementColor);
		   
		   Assert.assertEquals(page.locator(SessionText).textContent().trim(), expectedLabel);
	   }
	   
	   public void validateSessionsPerMinLabel(String expectedLabel)
	   {
		   Assert.assertEquals(page.locator(sessionPerMinText).textContent().trim(),expectedLabel );
	   }
	   
	   public void validateAppLaunchesIconAndLabel(String expectedLabel,String elementColor)
	   {
		   validateIcon(appLaunchesIcon,elementColor);
		   
		   Assert.assertEquals(page.locator(appLaunchesText).textContent().trim(), expectedLabel);
	   }
	   
	   public void validateAppLaunchesPerMinLabel(String expectedLabel)
	   {
		   Assert.assertEquals(page.locator(appLaunchesPerMinText).textContent().trim(),expectedLabel );
	   }
	   
	   public void validateCrashesHeader(String expectedLabel)
	   {
		   Assert.assertEquals(page.locator(crashKPSIsHeader).textContent().trim(),expectedLabel );
	   }
	   
	   public void validateCrashesLabel(String expectedLabel)
	   {
		   Assert.assertEquals(page.locator(crashestext).textContent().trim(),expectedLabel );
	   }
	   
	   public void validateCrashesPerMinLabel(String expectedLabel)
	   {
		   Assert.assertEquals(page.locator(crashesPerMinText).textContent().trim(),expectedLabel );
	   }
	   
	   public void validateCrashFreeUsersLabel(String expectedLabel)
	   {
		   Assert.assertEquals(page.locator(CrashFreeUsersText).textContent().trim(),expectedLabel );
	   }
	   
	   public void validateCrashesByOSHeader(String expectedText)
	   {
		   Assert.assertEquals(page.locator(crashesByOSHeader).textContent().trim(), expectedText);
	   }
	   
	   public void validateAndroidCrashPercentageLabel(String expectedText)
	   {
		   Assert.assertEquals(page.locator(androidCrashPercentLabel).textContent().trim(), expectedText);
	   }
	   
	   public void validateIosCrashPercentageLabel(String expectedText)
	   {
		   Assert.assertEquals(page.locator(iosCrashPercentLabel).textContent().trim(), expectedText);
	   }
	   
	   public void validateAndroidCrashPercentageColor(String expectedText)
	   {
		   Assert.assertTrue(((String) page.locator(androidCrashPercentageColor).evaluate("element => getComputedStyle(element).background")).contains(expectedText));
	   }
	   
	   public void validateIosCrashPercentageColor(String expectedText)
	   {
		   Assert.assertTrue(((String) page.locator(iosCrashPercentageColor).evaluate("element => getComputedStyle(element).background")).contains(expectedText));
	   }
	   
	   public void validateCrashByOSImage(String androidSectionColor,String IosSectionColor)
	   {
		   page.waitForTimeout(1500);
		   Assert.assertEquals(page.locator(androidCrashSection).evaluate("element => getComputedStyle(element).stroke"), androidSectionColor);
		   Assert.assertEquals(page.locator(iosCrashSection).evaluate("element => getComputedStyle(element).stroke"), IosSectionColor);
		   
		   //validate the Android section
		  ClickOptions option1=new ClickOptions();
		   option1.setPosition(120,100);
		   page.locator("xpath = //div[@class='vue-apexcharts']/descendant::*[name()='svg']").click(option1);

		   String selection = page.locator(androidCrashSection).getAttribute("selected");
		   page.locator("xpath = //div[@class='vue-apexcharts']/descendant::*[name()='svg']").click(option1);
		   System.out.println(selection +"--------"+page.locator(androidCrashSection).getAttribute("selected"));
		   Assert.assertNotEquals(page.locator(androidCrashSection).getAttribute("selected"), selection);
		   
		   //validate the percentage og Android error section
		   Assert.assertTrue(page.locator(androidCrashPercentValue).textContent().trim().contains(page.locator(androidCrashSection).getAttribute("data:value")));
		   
	   }
	   
	   public void validatePerformanceKPIHeader(String expectedText)
	   {
		   Assert.assertEquals(page.locator(performanceKPISHeader).textContent().trim(), expectedText);
	   }
	   
	 
	   public void validateWebRequestIconAndLabel(String expectedLabel,String elementColor)
	   {
		   validateIcon(WebRequestIcon,elementColor);
		   
		   Assert.assertEquals(page.locator(WebRequestText).textContent().trim(), expectedLabel);
	   }
	   
	   public void validateResponseTimeIconAndLabel(String expectedLabel,String elementColor)
	   {
		   validateIcon(httpResponseIcon,elementColor);
		   
		   Assert.assertEquals(page.locator(httpRepsonseTimeText).textContent().trim(), expectedLabel);
	   }
	   
	   public void validateErrorRateIconAndLabel(String expectedLabel,String elementColor)
	   {
		   validateIcon(errorPerRateIcon,elementColor);
		   
		   Assert.assertEquals(page.locator(errorPerRateText).textContent().trim(), expectedLabel);
	   }
	   
	   public void validateAppUsageSection(String expectedHeader,String subHeader)
	   {
		   Assert.assertEquals(page.locator(appUsgaeHeaderText).textContent().trim(), expectedHeader);
		   String[] expectedSubHeaders = subHeader.split(",");
		   Assert.assertEquals(page.locator(totalInstallSubHeader).textContent().trim(), expectedSubHeaders[0]);
		   Assert.assertEquals(page.locator(topDevicesSubHeader).textContent().trim(), expectedSubHeaders[1]);
		   Assert.assertEquals(page.locator(topversionsSubHeader).textContent().trim(), expectedSubHeaders[2]);
	   }
	   
	   public void validateTotalInstallSectionIcons()
	   {
		   page.waitForSelector(totalInstallAndroidIcon);
		   page.waitForSelector(totalInstallIosIcon);
		   Assert.assertTrue(page.locator(totalInstallAndroidIcon).isVisible());
		   Assert.assertTrue(page.locator(totalInstallIosIcon).isVisible());
	   }
	   
	   public void validateTotalInstallSectionLabels(String AndroidLabel,String iosLabel)
	   {
		   Assert.assertEquals(page.locator(totalInstallIosLabel).textContent().trim(), iosLabel);
		   Assert.assertEquals(page.locator(totalInstallAndroidLabel).textContent().trim(), AndroidLabel);
	   }
	   
	   public void validateTopVersionsSectionLabels(String AndroidLabel,String iosLabel)
	   {
		   Assert.assertEquals(page.locator(topVersionsIosLabel).textContent().trim(), iosLabel);
		   Assert.assertEquals(page.locator(topVersionsAndroidlabel).textContent().trim(), AndroidLabel);
	   }
	
	   
	   
 
 

}
