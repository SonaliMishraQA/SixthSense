package objectRepository.MM;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;

import com.microsoft.playwright.Page;

import genericUtilities.GenericMethods;

public class MMUsagePage {
	
	Page page;
	GenericMethods util=new GenericMethods();

    private String KPIsTab = " xpath = //div[@class='routeLinkBox' and .='KPIs ']" ;
    private String usageTab = " xpath = //div[@class='kpisTab']/descendant::a[@href='/mobile/kpis/usage']";

    private String activeSessionsWidgetTitle = " xpath =  //span[@id='Active-sessions-zoom-out']/ancestor::div[@class='chart-line']/descendant::div/div[@class='line-title']" ;
    private String activeSessionsWidgetYaxisText = " xpath = //div[.=' Active sessions']/ancestor::div[@class='chart-box']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-yaxis-title-text chart-lables']";
    private String activeSessionsWidgetXaxisText = " xpath = //div[.=' Active sessions']/ancestor::div[@class='chart-box']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-title-text chart-lables']";
    private String activeSessionsWidgetZoomOut = " xpath = //div[.=' Active sessions']/ancestor::div[@class='chart-box']/descendant::span[@id='Active-sessions-zoom-out']";
    private String activeSessionsWidgetZoomIn = " xpath = //div[.=' Active sessions']/ancestor::div[@class='chart-box']/descendant::span[@id='Active-sessions-zoom-in']";
    private String activeSessionsWidgetReset = " xpath = //div[.=' Active sessions']/ancestor::div[@class='chart-box']/descendant::span[@id='Active-sessions-zoom-reset']";
    private String activeSessionsWidgetXaxisLines = " xpath = //div[.=' Active sessions']/ancestor::div[@class='chart-line']/descendant::div[@id='apexchartsvuechart-line-0']/descendant::*[name()='g' and @class='apexcharts-inner apexcharts-graphical']/child::*[name()='line' and @class='apexcharts-xaxis-tick']";
    private String activeSessionsWidgetToolTipTitle = " xpath = //div[.=' Active sessions']/ancestor::div[@class='chart-line']/descendant::div[@id='apexchartsvuechart-line-0']/descendant::div[@class='apexcharts-tooltip-title']";
    private String activeSessionsWidgetXaxisValues = " xpath = //div[text()=' Active sessions']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-label apexcharts-xaxis-label']/child::*[name()='tspan' and contains(normalize-space(text()),'-')]";

    private String applaunchesWidgetTitle = " xpath =  //span[@id='App-launches-zoom-out']/ancestor::div[@class='chart-line']/descendant::div/div[@class='line-title']"  ;
    private String applaunchesWidgetYaxisText = " xpath = //div[.=' App launches']/ancestor::div[@class='chart-box']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-yaxis-title-text chart-lables']";
    private String applaunchesWidgetxaxisText = " xpath = //div[.=' App launches']/ancestor::div[@class='chart-box']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-title-text chart-lables']";
    private String applaunchesWidgetZoomOut = " xpath = //div[.=' App launches']/ancestor::div[@class='chart-box']/descendant::span[@id='App-launches-zoom-out']" ;
    private String applaunchesWidgetZoomIn = " xpath = //div[.=' App launches']/ancestor::div[@class='chart-box']/descendant::span[@id='App-launches-zoom-in']" ;
    private String applaunchesWidgetReset =" xpath = //div[.=' App launches']/ancestor::div[@class='chart-box']/descendant::span[@id='App-launches-zoom-reset']" ;
    private String applaunchesWidgetToolTipTitle = " xpath = //div[.=' App launches']/ancestor::div[@class='chart-line']/descendant::div[@id='apexchartsvuechart-line-0']/descendant::div[@class='apexcharts-tooltip-title']";
    private String applaunchesWidgetXaxisValues = " xpath = //div[text()=' App launches']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-label apexcharts-xaxis-label']/child::*[name()='tspan' and contains(normalize-space(text()),'-')]";
    private String applaunchesWidgetXaxisLines = " xpath = //div[.=' App launches']/ancestor::div[@class='chart-line']/descendant::div[@id='apexchartsvuechart-line-0']/descendant::*[name()='g' and @class='apexcharts-inner apexcharts-graphical']/child::*[name()='line' and @class='apexcharts-xaxis-tick']";

    private String newUsersWidgetTitle = " xpath =  //span[@id='New-users-zoom-out']/ancestor::div[@class='chart-line']/descendant::div/div[@class='line-title']";
    private String newUsersWidgetYaxisText = " xpath = //div[.=' New users']/ancestor::div[@class='chart-box']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-yaxis-title-text chart-lables']";
    private String newUsersWidgetXaxisText = " xpath = //div[.=' New users']/ancestor::div[@class='chart-box']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-title-text chart-lables']";
    private String newUsersWidgetZoomOut = " xpath = //div[.=' New users']/ancestor::div[@class='chart-box']/descendant::span[@id='New-users-zoom-out']";
    private String newUsersWidgetZoomIn = " xpath = //div[.=' New users']/ancestor::div[@class='chart-box']/descendant::span[@id='New-users-zoom-in']" ;
    private String newUsersWidgetReset = " xpath = //div[.=' New users']/ancestor::div[@class='chart-box']/descendant::span[@id='New-users-zoom-reset']";
    private String newUsersWidgetXaxisLines = " xpath = //div[.=' New users']/ancestor::div[@class='chart-line']/descendant::div[@id='apexchartsvuechart-line-1']/descendant::*[name()='g' and @class='apexcharts-inner apexcharts-graphical']/child::*[name()='line' and @class='apexcharts-xaxis-tick']";
    private String newUsersWidgetToolTipTitle = " xpath = //div[.=' New users']/ancestor::div[@class='chart-line']/descendant::div[@id='apexchartsvuechart-line-1']/descendant::div[@class='apexcharts-tooltip-title']";
    private String newUsersWidgetXaxisValues = " xpath = //div[text()=' New users']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-label apexcharts-xaxis-label']/child::*[name()='tspan' and contains(normalize-space(text()),'-')]";
   
    private String appVersionDistributionWidgetTitle = " xpath =  //span[@id='App-version-distribution-(Top-4)-zoom-out']/ancestor::div[@class='chart-line']/descendant::div/div[@class='line-title']" ;
    private String appVersionDistributionWidgetYaxisText = " xpath = //div[.=' App version distribution (Top 4)']/ancestor::div[@class='chart-box']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-yaxis-title-text chart-lables']";
    private String appVersionDistributionWidgetXaxisText = " xpath = //div[.=' App version distribution (Top 4)']/ancestor::div[@class='chart-box']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-title-text chart-lables']";
    private String appVersionDistributionWidgetZoomOut = " xpath = //div[.=' App version distribution (Top 4)']/ancestor::div[@class='chart-box']/descendant::span[@id='App-version-distribution-(Top-4)-zoom-out']" ;
    private String appVersionDistributionWidgetZoomIn = " xpath = //div[.=' App version distribution (Top 4)']/ancestor::div[@class='chart-box']/descendant::span[@id='App-version-distribution-(Top-4)-zoom-in']";
    private String appVersionDistributionWidgetReset = " xpath = //div[.=' App version distribution (Top 4)']/ancestor::div[@class='chart-box']/descendant::span[@id='App-version-distribution-(Top-4)-zoom-reset']" ;
    private String appVersionDistributionWidgetXaxisLines = " xpath = //div[.=' App version distribution (Top 4)']/ancestor::div[@class='chart-line']/descendant::div[@id='apexchartsvuechart-area-0']/descendant::*[name()='g' and @class='apexcharts-inner apexcharts-graphical']/child::*[name()='line' and @class='apexcharts-xaxis-tick']";
    private String appVersionDistributionWidgetToolTipTitle = " xpath = //div[.=' App version distribution (Top 4)']/ancestor::div[@class='chart-line']/descendant::div[@id='apexchartsvuechart-area-0']/descendant::div[@class='apexcharts-tooltip-title']";
    private String appVersionDistributionWidgetXaxisValues = " xpath = //div[text()=' App version distribution (Top 4)']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-label apexcharts-xaxis-label']/child::*[name()='tspan' and contains(normalize-space(text()),'-')]";
    private String appVersionDistributionWidgetLegendsList = "xpath = //div[.=' App version distribution (Top 4)']/ancestor::div[@class='chart-line']/descendant::span[contains(@class,'apexcharts-legend-text')]";
    private String appVersionDistributionWidgetLegendsColorList = "xpath = //div[.=' App version distribution (Top 4)']/ancestor::div[@class='chart-line']/descendant::span[contains(@class,'apexcharts-legend-marker')]";
    private String appVersionDistributionWidgetlegendsLineList = "xpath = //div[.=' App version distribution (Top 4)']/ancestor::div[@class='chart-line']/descendant::*[name()='g' and @class='apexcharts-series']/child::*[name()='path' and @fill='none']";
    private String appVersionDistributionWidgetToolTipColorList = "xpath = //div[.=' App version distribution (Top 4)']/ancestor::div[@class='chart-line']/descendant::div[@class='apexcharts-tooltip apexcharts-theme-dark apexcharts-active']/descendant::span[@class='apexcharts-tooltip-marker']";
    private String appVersionDistributionWidgetToolTipText = "xpath =//div[.=' App version distribution (Top 4)']/ancestor::div[@class='chart-line']/descendant::div[@class='apexcharts-tooltip-series-group apexcharts-active']/descendant::span[@class='apexcharts-tooltip-text-y-label']";
    
    
    private String usageByOsWidgetTitle = " xpath =  //span[@id='Usage-by-OS-zoom-out']/ancestor::div[@class='chart-line']/descendant::div/div[@class='line-title']";
    private String usageByOsWidgetYaxisText = " xpath = //div[.=' Usage by OS']/ancestor::div[@class='chart-box']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-yaxis-title-text chart-lables']";
    private String usageByOsWidgetXaxisText = " xpath = //div[.=' Usage by OS']/ancestor::div[@class='chart-box']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-title-text chart-lables']";
    private String usageByOsWidgetZoomOut = " xpath = //div[.=' Usage by OS']/ancestor::div[@class='chart-box']/descendant::span[@id='Usage-by-OS-zoom-out']";
    private String usageByOsWidgetZoomIn = " xpath = //div[.=' Usage by OS']/ancestor::div[@class='chart-box']/descendant::span[@id='Usage-by-OS-zoom-in']";
    private String usageByOsWidgetReset = " xpath = //div[.=' Usage by OS']/ancestor::div[@class='chart-box']/descendant::span[@id='Usage-by-OS-zoom-reset']";
    private String usageByOsWidgetXaxisLines =  " xpath = //div[.=' Usage by OS']/ancestor::div[@class='chart-line']/descendant::div[@id='apexchartsvuechart-area-0']/descendant::*[name()='g' and @class='apexcharts-inner apexcharts-graphical']/child::*[name()='line' and @class='apexcharts-xaxis-tick']";
    private String usageByOsWidgetToolTipTitle = " xpath = //div[.=' Usage by OS']/ancestor::div[@class='chart-line']/descendant::div[@id='apexchartsvuechart-area-0']/descendant::div[@class='apexcharts-tooltip-title']";
    private String usageByOsWidgetXaxisValues = " xpath = //div[text()=' Usage by OS']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-label apexcharts-xaxis-label']/child::*[name()='tspan' and contains(normalize-space(text()),'-')]";
    private String usageByOsWidgetLegendsList = "xpath = //div[.=' Usage by OS']/ancestor::div[@class='chart-line']/descendant::span[contains(@class,'apexcharts-legend-text')]";
    private String usageByOsWidgetLegendsColorList = "xpath = //div[.=' Usage by OS']/ancestor::div[@class='chart-line']/descendant::span[contains(@class,'apexcharts-legend-marker')]";
    private String usageByOsWidgetlegendsLineList = "xpath = //div[.=' Usage by OS']/ancestor::div[@class='chart-line']/descendant::*[name()='g' and @class='apexcharts-series']/child::*[name()='path' and @fill='none']";
    private String usageByOsWidgetToolTipColorList = "xpath = //div[.=' Usage by OS']/ancestor::div[@class='chart-line']/descendant::div[@class='apexcharts-tooltip apexcharts-theme-dark apexcharts-active']/descendant::span[@class='apexcharts-tooltip-marker']";
    private String usageByOsWidgetToolTipText = "xpath = //div[.=' Usage by OS']/ancestor::div[@class='chart-line']/descendant::div[@class='apexcharts-tooltip-series-group apexcharts-active']/descendant::span[@class='apexcharts-tooltip-text-y-label']";
    
    private String usageByDeviceWidgetTitle = " xpath =  //span[@id='Usage-by-device-(Top-5)-zoom-out']/ancestor::div[@class='chart-line']/descendant::div/div[@class='line-title']";
    private String usageByDeviceWidgetYaxisText = " xpath = //div[.=' Usage by device (Top 5)']/ancestor::div[@class='chart-box']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-yaxis-title-text chart-lables']" ;
    private String usageByDeviceWidgetXaxisText = " xpath = //div[.=' Usage by device (Top 5)']/ancestor::div[@class='chart-box']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-title-text chart-lables']";
    private String usageByDeviceWidgetZoomout = " xpath = //div[.=' Usage by device (Top 5)']/ancestor::div[@class='chart-box']/descendant::span[@id='Usage-by-device-(Top-5)-zoom-out']";
    private String usageByDeviceWidgetZoomIn = " xpath = //div[.=' Usage by device (Top 5)']/ancestor::div[@class='chart-box']/descendant::span[@id='Usage-by-device-(Top-5)-zoom-in']";
    private String usageByDeviceWidgetReset = " xpath = //div[.=' Usage by device (Top 5)']/ancestor::div[@class='chart-box']/descendant::span[@id='Usage-by-device-(Top-5)-zoom-reset']";
    private String usageByDeviceWidgetXaxisLines = " xpath = //div[.=' Usage by device (Top 5)']/ancestor::div[@class='chart-line']/descendant::div[@id='apexchartsvuechart-area-1']/descendant::*[name()='g' and @class='apexcharts-inner apexcharts-graphical']/child::*[name()='line' and @class='apexcharts-xaxis-tick']";
    private String usageByDeviceWidgetToolTipTitle = " xpath = //div[.=' Usage by device (Top 5)']/ancestor::div[@class='chart-line']/descendant::div[@id='apexchartsvuechart-area-1']/descendant::div[@class='apexcharts-tooltip-title']";
    private String usageByDeviceWidgetXaxisValues = " xpath = //div[text()=' Usage by device (Top 5)']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-label apexcharts-xaxis-label']/child::*[name()='tspan' and contains(normalize-space(text()),'-')]";
    private String usageByDeviceWidgetLegendsList = "xpath = //div[.=' Usage by device (Top 5)']/ancestor::div[@class='chart-line']/descendant::span[contains(@class,'apexcharts-legend-text')]";
    private String usageByDeviceWidgetLegendsColorList = "xpath = //div[.=' Usage by device (Top 5)']/ancestor::div[@class='chart-line']/descendant::span[contains(@class,'apexcharts-legend-marker')]";
    private String usageByDeviceWidgetlegendsLineList = "xpath = //div[.=' Usage by device (Top 5)']/ancestor::div[@class='chart-line']/descendant::*[name()='g' and @class='apexcharts-series']/child::*[name()='path' and @fill='none']";
    private String usageByDeviceWidgetToolTipColorList = "xpath = //div[.=' Usage by device (Top 5)']/ancestor::div[@class='chart-line']/descendant::div[@class='apexcharts-tooltip apexcharts-theme-dark apexcharts-active']/descendant::span[@class='apexcharts-tooltip-marker']";
    private String usageByDeviceWidgetToolTipText = "xpath = //div[.=' Usage by device (Top 5)']/ancestor::div[@class='chart-line']/descendant::div[@class='apexcharts-tooltip-series-group apexcharts-active']/descendant::span[@class='apexcharts-tooltip-text-y-label'] ";
   
    
    private String calanderValue = "xpath = //div[@class='selected-text ellipsis bg-text']";
    
    public MMUsagePage(Page page)
    {
    		this.page =page;
    }
    
    public List<String> allWidgetXPoints()
	{
		 ArrayList<String> xPoint = new ArrayList<String>();
		 xPoint.add(activeSessionsWidgetXaxisLines);
		 xPoint.add(applaunchesWidgetXaxisLines);
		 xPoint.add(newUsersWidgetXaxisLines);
		 xPoint.add(appVersionDistributionWidgetXaxisLines);
		 xPoint.add(usageByOsWidgetXaxisLines);
		 xPoint.add(usageByDeviceWidgetXaxisLines);
		 return xPoint;
	}
    
    public List<String> allWidgetXValues()
   	{
   		 ArrayList<String> xPoint = new ArrayList<String>();
   		 xPoint.add(activeSessionsWidgetXaxisValues);
   		 xPoint.add(applaunchesWidgetXaxisValues);
   		 xPoint.add(newUsersWidgetXaxisValues);
   		 xPoint.add(appVersionDistributionWidgetXaxisValues);
   		 xPoint.add(usageByOsWidgetXaxisValues);
   		 xPoint.add(usageByDeviceWidgetXaxisValues);
   		 return xPoint;
   	}
    
    public void validateWidgetLegendsTextForUsageByDeviceGraph(String expectedLegends)
  	{
    	page.waitForURL("**/mobile/kpis/usage");
  		util.validateWidgetLegendsText(page,usageByDeviceWidgetLegendsList,expectedLegends );
  	}
    
    public void validateUsageByDevicewidgetLegends()
  	{
    	page.waitForURL("**/mobile/kpis/usage");
  		util.validateWidgetLegends(page, usageByDeviceWidgetLegendsList,usageByDeviceWidgetLegendsColorList,usageByDeviceWidgetlegendsLineList ,usageByDeviceWidgetToolTipColorList ,usageByDeviceWidgetXaxisLines,usageByDeviceWidgetToolTipText);
  	}
    
    public void validateWidgetLegendsTextForUsageByOSGraph(String expectedLegends)
  	{
    	page.waitForURL("**/mobile/kpis/usage");
  		util.validateWidgetLegendsText(page,usageByOsWidgetLegendsList,expectedLegends );
  	}
    
    public void validateUsageByOswidgetLegends()
  	{
    	page.waitForURL("**/mobile/kpis/usage");
  		util.validateWidgetLegends(page, usageByOsWidgetLegendsList,usageByOsWidgetLegendsColorList,usageByOsWidgetlegendsLineList ,usageByOsWidgetToolTipColorList ,usageByOsWidgetXaxisLines,usageByOsWidgetToolTipText);
  	}
    
    
    public void validateWidgetLegendsTextForAppVersionDistributionGraph(String expectedLegends)
  	{
    	page.waitForURL("**/mobile/kpis/usage");
  		util.validateWidgetLegendsText(page,appVersionDistributionWidgetLegendsList,expectedLegends );
  	}
  	
  	public void validateAppVersionDistributionwidgetLegends()
  	{
  		page.waitForURL("**/mobile/kpis/usage");
  		util.validateWidgetLegends(page, appVersionDistributionWidgetLegendsList, appVersionDistributionWidgetLegendsColorList,appVersionDistributionWidgetlegendsLineList ,appVersionDistributionWidgetToolTipColorList ,appVersionDistributionWidgetXaxisLines,appVersionDistributionWidgetToolTipText);
  	}
    
    
    //--------------------active sessions---------------------
    public void validateActiveSessionTitle(String expectedTitle)
    {
    	page.waitForURL("**/mobile/kpis/usage");
    	String actualTitle = page.locator(activeSessionsWidgetTitle).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
    
    public void validateActiveSessionXaxisTitle(String expectedTitle)
    {
    	page.waitForURL("**/mobile/kpis/usage");
    	String actualTitle = page.locator(activeSessionsWidgetXaxisText).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
    
    public void validateActiveSessionYaxisTitle(String expectedTitle)
    {
    	page.waitForURL("**/mobile/kpis/usage");
    	String actualTitle = page.locator(activeSessionsWidgetYaxisText).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
    
    public void validateActiveSessionsZoomIn()
    {
    	page.waitForURL("**/mobile/kpis/usage");
    	util.graphZoomIn(page, activeSessionsWidgetZoomIn, activeSessionsWidgetReset, allWidgetXPoints());
    }
    
    public void validateActiveSessionsZoomout()
    {
    	page.waitForURL("**/mobile/kpis/usage");
    	util.graphZoomOut(page, activeSessionsWidgetZoomIn,activeSessionsWidgetZoomOut, activeSessionsWidgetReset, allWidgetXPoints());
    }
    
    public void validateActiveSessionsZoomReset()
    {
    	page.waitForURL("**/mobile/kpis/usage");
    	util.graphZoomReset(page, activeSessionsWidgetZoomIn, activeSessionsWidgetReset, allWidgetXPoints());
    }
    
    public void validateActiveSessionWidgetToolTip() throws InterruptedException
	{
    	page.waitForURL("**/mobile/kpis/usage");
		util.validateWidgetToolTips(page, activeSessionsWidgetXaxisLines, activeSessionsWidgetToolTipTitle);
	}
    
    public void validateActiveSessionsDragAndDrop()
    {
    	page.waitForURL("**/mobile/kpis/usage");
    	util.graphZoomInByDragAndDrop(page, activeSessionsWidgetXaxisLines, activeSessionsWidgetReset, allWidgetXPoints());
    }
    
    
    //--------------------------------app Launches--------------
    
    public void validateAppLaunchesTitle(String expectedTitle)
    {
    	page.waitForURL("**/mobile/kpis/usage");
    	String actualTitle = page.locator(applaunchesWidgetTitle).textContent().trim();
    	System.out.println("actualTitle   :"+ actualTitle + "expectedTitle : "+expectedTitle );
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
    
    public void validateAppLaunchesXaxisTitle(String expectedTitle)
    {
    	page.waitForURL("**/mobile/kpis/usage");
    	String actualTitle = page.locator(applaunchesWidgetxaxisText).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
    
    public void validateAppLaunchesYaxisTitle(String expectedTitle)
    {
    	page.waitForURL("**/mobile/kpis/usage");
    	String actualTitle = page.locator(applaunchesWidgetYaxisText).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
    
    public void validateAppLaunchesZoomIn()
    {
    	page.waitForURL("**/mobile/kpis/usage");
    	util.graphZoomIn(page, applaunchesWidgetZoomIn, applaunchesWidgetReset, allWidgetXPoints());
    }
    
    public void validateAppLaunchesZoomout()
    {
    	page.waitForURL("**/mobile/kpis/usage");
    	util.graphZoomOut(page, applaunchesWidgetZoomIn,applaunchesWidgetZoomOut, applaunchesWidgetReset, allWidgetXPoints());
    }
    
    public void validateAppLaunchesZoomReset()
    {
    	page.waitForURL("**/mobile/kpis/usage");
    	util.graphZoomReset(page, applaunchesWidgetZoomIn, applaunchesWidgetReset, allWidgetXPoints());
    }
    
    public void validateAppLaunchesWidgetToolTip() throws InterruptedException
	{
    	page.waitForURL("**/mobile/kpis/usage");
		util.validateWidgetToolTips(page, applaunchesWidgetXaxisLines, applaunchesWidgetToolTipTitle);
	}
    
    public void validateAppLaunchesDragAndDrop()
    {
    	page.waitForURL("**/mobile/kpis/usage");
    	util.graphZoomInByDragAndDrop(page, applaunchesWidgetXaxisLines, applaunchesWidgetReset, allWidgetXPoints());
    }
    
  //--------------------------------new users--------------
    
    public void validateNewUsersTitle(String expectedTitle)
    {
    	page.waitForURL("**/mobile/kpis/usage");
    	String actualTitle = page.locator(newUsersWidgetTitle).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
    
    public void validateNewUsersXaxisTitle(String expectedTitle)
    {
    	page.waitForURL("**/mobile/kpis/usage");
    	String actualTitle = page.locator(newUsersWidgetXaxisText).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
    
    public void validateNewUsersYaxisTitle(String expectedTitle)
    {
    	page.waitForURL("**/mobile/kpis/usage");
    	String actualTitle = page.locator(newUsersWidgetYaxisText).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
    
    public void validateNewUsersZoomIn()
    {
    	page.waitForURL("**/mobile/kpis/usage");
    	util.graphZoomIn(page, newUsersWidgetZoomIn, newUsersWidgetReset, allWidgetXPoints());
    }
    
    public void validateNewUsersZoomout()
    {
    	page.waitForURL("**/mobile/kpis/usage");
    	util.graphZoomOut(page, newUsersWidgetZoomIn,newUsersWidgetZoomOut, newUsersWidgetReset, allWidgetXPoints());
    }
    
    public void validateNewUsersZoomReset()
    {
    	page.waitForURL("**/mobile/kpis/usage");
    	util.graphZoomReset(page, newUsersWidgetZoomIn, newUsersWidgetReset, allWidgetXPoints());
    }
    
    public void validateNewUsersWidgetToolTip() throws InterruptedException
	{
    	page.waitForURL("**/mobile/kpis/usage");
		util.validateWidgetToolTips(page, newUsersWidgetXaxisLines, newUsersWidgetToolTipTitle);
	}
    
    public void validateNewUsersDragAndDrop()
    {
    	page.waitForURL("**/mobile/kpis/usage");
    	util.graphZoomInByDragAndDrop(page, newUsersWidgetXaxisLines, newUsersWidgetReset, allWidgetXPoints());
    }
    
    //--------------appVersion -----------------
    
    public void validateAppVersionsTitle(String expectedTitle)
    {
    	page.waitForURL("**/mobile/kpis/usage");
    	String actualTitle = page.locator(appVersionDistributionWidgetTitle).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
    
    public void validateAppVersionsXaxisTitle(String expectedTitle)
    {
    	page.waitForURL("**/mobile/kpis/usage");
    	String actualTitle = page.locator(appVersionDistributionWidgetXaxisText).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
    
    public void validateAppVersionsYaxisTitle(String expectedTitle)
    {
    	page.waitForURL("**/mobile/kpis/usage");
    	String actualTitle = page.locator(appVersionDistributionWidgetYaxisText).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
    
    public void validateAppVersionsZoomIn()
    {
    	page.waitForURL("**/mobile/kpis/usage");
    	util.graphZoomIn(page, appVersionDistributionWidgetZoomIn, appVersionDistributionWidgetReset, allWidgetXPoints());
    }
    
    public void validateAppVersionsZoomout()
    {
    	page.waitForURL("**/mobile/kpis/usage");
    	util.graphZoomOut(page, appVersionDistributionWidgetZoomIn,appVersionDistributionWidgetZoomOut, appVersionDistributionWidgetReset, allWidgetXPoints());
    }
    
    public void validateAppVersionsZoomReset()
    {
    	page.waitForURL("**/mobile/kpis/usage");
    	util.graphZoomReset(page, appVersionDistributionWidgetZoomIn, appVersionDistributionWidgetReset, allWidgetXPoints());
    }
    
    public void validateAppVersionsWidgetToolTip() throws InterruptedException
	{
    	page.waitForURL("**/mobile/kpis/usage");
		util.validateWidgetToolTips(page, appVersionDistributionWidgetXaxisLines, appVersionDistributionWidgetToolTipTitle);
	}
    
    public void validateAppVersionsDragAndDrop()
    {
    	page.waitForURL("**/mobile/kpis/usage");
    	util.graphZoomInByDragAndDrop(page, appVersionDistributionWidgetXaxisLines, appVersionDistributionWidgetReset, allWidgetXPoints());
    }
    
    //-----------------------usage by os ----------------------
    
    
    public void validateUsageByOsTitle(String expectedTitle)
    {
    	page.waitForSelector(usageByOsWidgetTitle);
    	String actualTitle = page.locator(usageByOsWidgetTitle).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
    
    public void validateUsageByOsXaxisTitle(String expectedTitle)
    {
    	page.waitForURL("**/mobile/kpis/usage");
    	String actualTitle = page.locator(usageByOsWidgetXaxisText).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
    
    public void validateUsageByOsYaxisTitle(String expectedTitle)
    {
    	page.waitForURL("**/mobile/kpis/usage");
    	String actualTitle = page.locator(usageByOsWidgetYaxisText).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
    
    public void validateUsageByOsZoomIn()
    {
    	page.waitForURL("**/mobile/kpis/usage");
    	page.waitForURL("**/mobile/kpis/usage");
    	util.graphZoomIn(page, usageByOsWidgetZoomIn, usageByOsWidgetReset, allWidgetXPoints());
    }
    
    public void validateUsageByOsZoomout()
    {
    	page.waitForURL("**/mobile/kpis/usage");
    	util.graphZoomOut(page, usageByOsWidgetZoomIn,usageByOsWidgetZoomOut, usageByOsWidgetReset, allWidgetXPoints());
    }
    
    public void validateUsageByOsZoomReset()
    {
    	page.waitForURL("**/mobile/kpis/usage");
    	util.graphZoomReset(page,usageByOsWidgetZoomIn, usageByOsWidgetReset, allWidgetXPoints());
    }
    
    public void validateUsageByOsWidgetToolTip() throws InterruptedException
	{
    	page.waitForURL("**/mobile/kpis/usage");
		util.validateWidgetToolTips(page, usageByOsWidgetXaxisLines, usageByOsWidgetToolTipTitle);
	}
    
    public void validateUsageByOsDragAndDrop()
    {
    	page.waitForURL("**/mobile/kpis/usage");
    	util.graphZoomInByDragAndDrop(page, usageByOsWidgetXaxisLines, usageByOsWidgetReset, allWidgetXPoints());
    }
    
    //-------------------usage by device ---------------------------
    

    public void validateUsageByDeviceTitle(String expectedTitle)
    {
    	page.waitForURL("**/mobile/kpis/usage");
    	String actualTitle = page.locator(usageByDeviceWidgetTitle).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
    
    public void validateUsageByDeviceXaxisTitle(String expectedTitle)
    {
    	page.waitForURL("**/mobile/kpis/usage");
    	String actualTitle = page.locator(usageByDeviceWidgetXaxisText).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
    
    public void validateUsageByDeviceYaxisTitle(String expectedTitle)
    {
    	page.waitForURL("**/mobile/kpis/usage");
    	String actualTitle = page.locator(usageByDeviceWidgetYaxisText).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
    
    public void validateUsageByDeviceZoomIn()
    {
    	page.waitForURL("**/mobile/kpis/usage");
    	util.graphZoomIn(page, usageByDeviceWidgetZoomIn, usageByDeviceWidgetReset, allWidgetXPoints());
    }
    
    public void validateUsageByDeviceZoomout()
    {
    	page.waitForURL("**/mobile/kpis/usage");
    	util.graphZoomOut(page, usageByDeviceWidgetZoomIn,usageByDeviceWidgetZoomout, usageByDeviceWidgetReset, allWidgetXPoints());
    }
    
    public void validateUsageByDeviceZoomReset()
    {
    	page.waitForURL("**/mobile/kpis/usage");
    	util.graphZoomReset(page,usageByDeviceWidgetZoomIn, usageByDeviceWidgetReset, allWidgetXPoints());
    }
    
    public void validateUsageByDeviceWidgetToolTip() throws InterruptedException
	{
    	page.waitForURL("**/mobile/kpis/usage");
		util.validateWidgetToolTips(page, usageByDeviceWidgetXaxisLines, usageByDeviceWidgetToolTipTitle);
	}
    
    public void validateUsageByDeviceDragAndDrop()
    {
    	page.waitForURL("**/mobile/kpis/usage");
    	util.graphZoomInByDragAndDrop(page, usageByDeviceWidgetXaxisLines, usageByDeviceWidgetReset, allWidgetXPoints());
    }
    
	public void validateTheGivenTimeLine()
	{
		page.waitForURL("**/mobile/kpis/usage");
		util.validateTheGraphdisplayingTheDataAsPerGivenTimeLines(page,activeSessionsWidgetXaxisValues,calanderValue,allWidgetXValues());
	}
	

	public void validateTheCustomTimeLine(String period)
	{
		page.waitForURL("**/mobile/kpis/usage");
		page.waitForSelector(activeSessionsWidgetXaxisValues);
		util.validateCustomTimeLine(page,activeSessionsWidgetXaxisValues,period,allWidgetXValues());
	}
    
    public void validateTheUsagePage()
    {
    	page.locator(KPIsTab).click();
    	Assert.assertTrue(page.locator(usageTab).getAttribute("class").contains("activeTab"));
    	page.waitForSelector(activeSessionsWidgetTitle);
    	Assert.assertTrue(page.locator(activeSessionsWidgetTitle).isVisible());
    }
    	
    public void navigateToUsagePage()
    {
    	page.locator(KPIsTab).click();
    	page.waitForSelector(usageTab);
    	page.click(usageTab);
    	page.waitForURL("**/mobile/kpis/usage");
    	Assert.assertTrue(page.locator(activeSessionsWidgetTitle).isVisible());
    }
    
  
    

}
