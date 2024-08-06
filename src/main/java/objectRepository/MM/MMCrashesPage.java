package objectRepository.MM;

import java.io.IOException;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;

import com.microsoft.playwright.Download;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Locator.HoverOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;

import genericUtilities.ExcelUtility;
import genericUtilities.GenericMethods;
import genericUtilities.IPathConstant;
import genericUtilities.JavaUtility;
import io.reactivex.rxjava3.internal.util.AppendOnlyLinkedArrayList.NonThrowingPredicate;
import objectRepository.CommonPage;

public class MMCrashesPage {
	
	 Page page;
	
	GenericMethods util=new GenericMethods();
	ExcelUtility eutil=new ExcelUtility();
	JavaUtility javaUtil =new JavaUtility();

	private String mobileMonitoringPageTitle = "#title-text-mobile";
	private String kpisTab="xpath = //div[@class='routeLinkBox' and .='KPIs ']";
	private String usageTab = "xpath = //a[@href='/mobile/kpis/usage']";
	private String crashesTab = "xpath =//a[@href='/mobile/kpis/crashes']";
	private String performanceTab = "xpath = //a[@href='/mobile/kpis/performance']";
	private String crashesWidgetxAxisLine= "xpath = //div[.=' Crashes']/ancestor::div[@class='chart-line']/descendant::div[@id='apexchartsvuechart-line-0']/descendant::*[name()='g' and @class='apexcharts-inner apexcharts-graphical']/child::*[name()='line' and @class='apexcharts-xaxis-tick']";
	private String applicationDropDown= "#select-search-mobile-service";
	private String searchField = "xpath = //input[@id='input-search-sel-select-search-mobile-service']";
	private String searchedApplications = "xpath = //div[@id='select-search-mobile-service']/following-sibling::div/descendant::span[@class='option-icon']/child::span";
	private String selectOsDropdownBtn= "xpath = //div[@class='select-os']/descendant::div[@id='select-search-mobile-os']";
	private String selectOsForAll = " xpath = //span[@id='select-search-mobile-os-0-single' and text()='All']" ;
    private String selectOSForiOS = " xpath = //span[@id='select-search-mobile-os-1-single' and text()='iOS']" ;
    private String selectOsForAndriod = " xpath = //span[@id='select-search-mobile-os-2-single' and text()='Android']" ; 
	private String selectAppVersionDropdownBtn = "xpath = //div[@class='select-version']/descendant::div[@id='select-search-mobile-version']";
	private String selectAppVerTextField = " xpath = //input[@id='input-search-sel-select-search-mobile-version']" ;
	private String searchedAppVer = " xpath = //span[@id='select-search-mobile-version-0-single']" ;
	
	//******************************Crashes Widget*************************** */
	private String crashesGraphTitle = "xpath = //div[@id='apexchartsvuechart-line-0']/ancestor::div[@class='chart-body']/preceding-sibling::div/div[@class='line-title']";
	private String CrashesZoomOut= "xpath = //span[@id='Crashes-zoom-out']";
	private String CrashesZoomIn ="xpath = //span[@id='Crashes-zoom-in']";
	private String CrashesResetBtn = "xpath = //span[@id='Crashes-zoom-reset']";
	private String crashesYaxisTitle= "xpath = //div[@id='apexchartsvuechart-line-0']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-yaxis-title-text chart-lables']";
	private String crashesXaxisTitle = "xpath = //div[@id='apexchartsvuechart-line-0']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-title-text chart-lables']";
	private String crashesXaxisLines =  "xpath = //div[.=' Crashes']/ancestor::div[@class='chart-line']/descendant::div[@id='apexchartsvuechart-line-0']/descendant::*[name()='g' and @class='apexcharts-inner apexcharts-graphical']/child::*[name()='line' and @class='apexcharts-xaxis-tick']";
	private String crashesGraphToolTip =  "xpath = //div[.=' Crashes']/ancestor::div[@class='chart-line']/descendant::div[@id='apexchartsvuechart-line-0']/descendant::div[@class='apexcharts-tooltip apexcharts-theme-dark apexcharts-active']";
	private String crashesGraphToolTipValue= " xpath = //div[.=' Crashes']/ancestor::div[@class='chart-line']/descendant::div[@id='apexchartsvuechart-line-0']/descendant::div[@class='apexcharts-tooltip apexcharts-theme-dark apexcharts-active']/descendant::span[@class='apexcharts-tooltip-text-y-value']";
	private String crashGraphXaxisValues = "xpath = //div[text()=' Crashes']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-label apexcharts-xaxis-label']/child::*[name()='tspan' and contains(normalize-space(text()),'-')]";
	
	//******************************Crashes Affected user widget*************************** */
	  private String CrashesAffectedUsersGraphTitle = "xpath = //div[@id='apexchartsvuechart-line-1']/ancestor::div[@class='chart-body']/preceding-sibling::div/div[@class='line-title']" ;
	  private String CrashesAffectedUsersZoomOut = " xpath = //span[@id='Crash-affected-users-zoom-out']" ;
	  private String CrashesAffectedUsersZoomIn = "xpath = //span[@id='Crash-affected-users-zoom-in']" ;
	  private String CrashesAffectedUsersResetBtn = "xpath = //span[@id='Crash-affected-users-zoom-reset']" ;
	  private String CrashesAffectedUsersYaxisTitle = "xpath = //div[@id='apexchartsvuechart-line-1']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-yaxis-title-text chart-lables']" ;
	  private String CrashesAffectedUsersXaxisTitle = "xpath = //div[@id='apexchartsvuechart-line-1']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-title-text chart-lables']" ;
	  private String CrashesAffectedUsersXaxisLines = "xpath = //div[.=' Crash affected users']/ancestor::div[@class='chart-line']/descendant::div[@id='apexchartsvuechart-line-1']/descendant::*[name()='g' and @class='apexcharts-inner apexcharts-graphical']/child::*[name()='line' and @class='apexcharts-xaxis-tick']";
	  private String CrashesAffectedUsersGraphToolTip = "xpath = //div[.=' Crash affected users']/ancestor::div[@class='chart-line']/descendant::div[@id='apexchartsvuechart-line-1']/descendant::div[@class='apexcharts-tooltip apexcharts-theme-dark apexcharts-active']";
	  private String crashesAffectedUsersToolTipValue = "xpath = //div[.=' Crash affected users']/ancestor::div[@class='chart-line']/descendant::div[@id='apexchartsvuechart-line-1']/descendant::div[@class='apexcharts-tooltip apexcharts-theme-dark apexcharts-active']/descendant::span[@class='apexcharts-tooltip-text-y-value']";
	  private String crashesAffectedXaxisValues = "xpath = //div[text()=' Crash affected users']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-label apexcharts-xaxis-label']/child::*[name()='tspan' and contains(normalize-space(text()),'-')]";

	  //******************************Crashes By OS Widget*************************** */
	  private String CrashesByOSGraphTitle = "xpath = //span[@id='Crashes-by-OS-zoom-out']/ancestor::div[@class='chart-line']/descendant::div/div[@class='line-title']	" ;
	  private String CrashesByOSZoomOut = "xpath = //span[@id='Crashes-by-OS-zoom-out']" ;
	  private String CrashesByOSZoomIn = "xpath = //span[@id='Crashes-by-OS-zoom-in']" ;
	  private String CrashesByOSResetBtn = "xpath = //span[@id='Crashes-by-OS-zoom-reset']" ;
	  private String CrashesByOSYaxisTitle = " xpath = //div[.=' Crashes by OS']/ancestor::div[@class='chart-line']/descendant::div[@id='apexchartsvuechart-area-0']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-yaxis-title-text chart-lables']";
	  private String CrashesByOSXaxisTitle = "xpath = //div[.=' Crashes by OS']/ancestor::div[@class='chart-line']/descendant::div[@id='apexchartsvuechart-area-0']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-title-text chart-lables']";
	  private String CrashesByOSXaxisLines = " xpath = //div[.=' Crashes by OS']/ancestor::div[@class='chart-line']/descendant::div[@id='apexchartsvuechart-area-0']/descendant::*[name()='g' and @class='apexcharts-inner apexcharts-graphical']/child::*[name()='line' and @class='apexcharts-xaxis-tick']";
	  private String CrashesByOSGraphToolTip = "xpath = //div[.=' Crashes by OS']/ancestor::div[@class='chart-line']/descendant::div[@id='apexchartsvuechart-area-0']/descendant::div[@class='apexcharts-tooltip apexcharts-theme-dark apexcharts-active']";
	  private String CrashesByOSLegendsList = "xpath = //div[text()=' Crashes by OS']/ancestor::div[@class='chart-line']/descendant::span[@class='apexcharts-legend-text']";
	  private String CrashesByOSLegendsColorList = "xpath = //div[.=' Crashes by OS']/ancestor::div[@class='chart-line']/descendant::span[contains(@class,'apexcharts-legend-marker')]";
	  private String CrashesByOSlegendsLineList = "xpath = //div[.=' Crashes by OS']/ancestor::div[@class='chart-line']/descendant::*[name()='g' and @class='apexcharts-series']/child::*[name()='path' and @fill='none']";
	  private String CrashesByOSToolTipColorList = "xpath = //div[.=' Crashes by OS']/ancestor::div[@class='chart-line']/descendant::div[@class='apexcharts-tooltip apexcharts-theme-dark apexcharts-active']/descendant::span[@class='apexcharts-tooltip-marker']";
	  private String CrashesByOSToolTipText = "xpath = //div[.=' Crashes by OS']/ancestor::div[@class='chart-line']/descendant::div[@class='apexcharts-tooltip-series-group apexcharts-active']/descendant::span[@class='apexcharts-tooltip-text-y-label']";
	  private String crashesByOSXaxisValues = "xpath = //div[text()=' Crashes by OS']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-label apexcharts-xaxis-label']/child::*[name()='tspan' and contains(normalize-space(text()),'-')]";
	  private String crashesByOSToolTipValue = "xpath = //div[.=' Crashes by OS']/ancestor::div[@class='chart-line']/descendant::div[@class='apexcharts-tooltip-series-group apexcharts-active']/descendant::span[@class='apexcharts-tooltip-text-y-value']";
	
	  
	  //******************************Crashes BY App Widget*************************** */
	  private String CrashesByAPPGraphTitle = "xpath = //span[@id='Crashes-by-app-versions-zoom-out']/ancestor::div[@class='chart-line']/descendant::div/div[@class='line-title']" ;
	  private String CrashesByAPPZoomOut = "xpath = //span[@id='Crashes-by-app-versions-zoom-out']" ;
	  private String CrashesByAPPZoomIn  = "xpath = //span[@id='Crashes-by-app-versions-zoom-in']" ;
	  private String CrashesByAPPResetBtn = "xpath = //span[@id='Crashes-by-app-versions-zoom-reset']" ;
	  private String CrashesByAPPYaxisTitle = "xpath = //div[.=' Crashes by app versions']/ancestor::div[@class='chart-line']/descendant::div[@id='apexchartsvuechart-area-0']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-yaxis-title-text chart-lables']";
	  private String CrashesByAPPXaxisTitle = "xpath = //div[.=' Crashes by app versions']/ancestor::div[@class='chart-line']/descendant::div[@id='apexchartsvuechart-area-0']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-title-text chart-lables']";
	  private String CrashesByAPPXaxisLines = "xpath = //div[.=' Crashes by app versions']/ancestor::div[@class='chart-line']/descendant::div[@id='apexchartsvuechart-area-0']/descendant::*[name()='g' and @class='apexcharts-inner apexcharts-graphical']/child::*[name()='line' and @class='apexcharts-xaxis-tick']";
	  private String CrashesByAPPToolTip = "xpath = //div[.=' Crashes by app versions']/ancestor::div[@class='chart-line']/descendant::div[@id='apexchartsvuechart-area-0']/descendant::div[@class='apexcharts-tooltip apexcharts-theme-dark apexcharts-active']";
	  private String CrashesByAPPToolTipValuesList = "xpath = //div[.=' Crashes by app versions']/ancestor::div[@class='chart-line']/descendant::div[@id='apexchartsvuechart-area-0']/descendant::div[@class='apexcharts-tooltip apexcharts-theme-dark apexcharts-active']/descendant::span[@class='apexcharts-tooltip-text-y-value']";
	  private String CrashesByAPPLegendsList = "xpath = //div[text()=' Crashes by app versions']/ancestor::div[@class='chart-line']/descendant::span[@class='apexcharts-legend-text']";
	  private String CrashesByAPPLegendsColorList = "xpath = //div[.=' Crashes by app versions']/ancestor::div[@class='chart-line']/descendant::span[contains(@class,'apexcharts-legend-marker')]";
	  private String CrashesByAPPlegendsLineList = "xpath = //div[.=' Crashes by app versions']/ancestor::div[@class='chart-line']/descendant::*[name()='g' and @class='apexcharts-series']/child::*[name()='path' and @fill='none']";
	  private String CrashesByAPPToolTipColorList = "xpath = //div[.=' Crashes by app versions']/ancestor::div[@class='chart-line']/descendant::div[@class='apexcharts-tooltip apexcharts-theme-dark apexcharts-active']/descendant::span[@class='apexcharts-tooltip-marker']";
	  private String CrashesByAPPToolTipText = "xpath = //div[.=' Crashes by app versions']/ancestor::div[@class='chart-line']/descendant::div[@class='apexcharts-tooltip-series-group apexcharts-active']/descendant::span[@class='apexcharts-tooltip-text-y-label']";
	  private String crashesByAPPXaxisValues = "xpath = //div[text()=' Crashes by app versions']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-label apexcharts-xaxis-label']/child::*[name()='tspan' and contains(normalize-space(text()),'-')]";
	 
	  //******************************Crashes By Device Widget*************************** */
	  private String CrashesByDeviceGraphTitle = " xpath = //span[@id='Crashes-by-device-(-Top-5-)-zoom-out']/ancestor::div[@class='cards-container']/descendant::div/div[@class='line-title']" ;
	  private String CrashesByDeviceZoomOut = "xpath = //span[@id='Crashes-by-device-(-Top-5-)-zoom-out']" ;
	  private String CrashesByDeviceZoomIn = "xpath = //span[@id='Crashes-by-device-(-Top-5-)-zoom-in']" ;
	  private String CrashesByDeviceResetBtn ="xpath = //span[@id='Crashes-by-device-(-Top-5-)-zoom-reset']" ;
	  private String CrashesByDeviceYaxisTitle = " xpath = //div[.=' Crashes by device ( Top 5 )']/ancestor::div[@class='chart-line']/descendant::div[@id='apexchartsvuechart-area-0']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-yaxis-title-text chart-lables']";
	  private String CrashesByDeviceXaxisTitle = "xpath = //div[.=' Crashes by device ( Top 5 )']/ancestor::div[@class='chart-line']/descendant::div[@id='apexchartsvuechart-area-0']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-title-text chart-lables']";
	  private String CrashesByDeviceXaxisLines = "xpath = //div[.=' Crashes by device ( Top 5 )']/ancestor::div[@class='chart-line']/descendant::div[@id='apexchartsvuechart-area-0']/descendant::*[name()='g' and @class='apexcharts-inner apexcharts-graphical']/child::*[name()='line' and @class='apexcharts-xaxis-tick']";
	  private String CrashesByDeviceToolTip = "xpath = //div[.=' Crashes by device ( Top 5 )']/ancestor::div[@class='chart-line']/descendant::div[@id='apexchartsvuechart-area-0']/descendant::div[@class='apexcharts-tooltip apexcharts-theme-dark apexcharts-active']";
	  private String CrashesByDeviceToolTipValuesList = "xpath = //div[.=' Crashes by device ( Top 5 )']/ancestor::div[@class='chart-line']/descendant::div[@id='apexchartsvuechart-area-0']/descendant::div[@class='apexcharts-tooltip apexcharts-theme-dark apexcharts-active']/descendant::span[@class='apexcharts-tooltip-text-y-value']";
	  private String crashesByDeviceLegendsList = "xpath = //div[text()=' Crashes by device ( Top 5 )']/ancestor::div[@class='chart-line']/descendant::span[@class='apexcharts-legend-text']";
	  private String crashesByDeviceLegendsColorList = "xpath = //div[.=' Crashes by device ( Top 5 )']/ancestor::div[@class='chart-line']/descendant::span[contains(@class,'apexcharts-legend-marker')]";
	  private String crashesByDevicelegendsLineList = "xpath = //div[.=' Crashes by device ( Top 5 )']/ancestor::div[@class='chart-line']/descendant::*[name()='g' and @class='apexcharts-series']/child::*[name()='path' and @fill='none']";
	  private String crashesByDeviceToolTipColorList = "xpath = //div[.=' Crashes by device ( Top 5 )']/ancestor::div[@class='chart-line']/descendant::div[@class='apexcharts-tooltip apexcharts-theme-dark apexcharts-active']/descendant::span[@class='apexcharts-tooltip-marker']";
	  private String crashesByDeviceToolTipText = "xpath = //div[.=' Crashes by device ( Top 5 )']/ancestor::div[@class='chart-line']/descendant::div[@class='apexcharts-tooltip-series-group apexcharts-active']/descendant::span[@class='apexcharts-tooltip-text-y-label']";
	  private String crashesByDeviceXaxisValues = "xpath = //div[text()=' Crashes by device ( Top 5 )']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-label apexcharts-xaxis-label']/child::*[name()='tspan' and contains(normalize-space(text()),'-')]";
	 

	//******************************Crash info table*************************** */
	  private String crashInfoTableTitle= "xpath = //div[@class='card-header' and text()='Crash information ']" ;
	  private String viewAllBtn = "xpath = //div[text()='Crash information ']/descendant::button[@id='btn-view-all']/child::div" ;
	  private String CrashInfoTableHeader = "xpath = //div[text()='Crash information ']/following-sibling::div/descendant::div[@class='top-container']/child::div";
	  private String crashInfoTableCrashNamesList = "xpath = //div[text()='Crash information ']/ancestor::div[@class='crash-info']/descendant::div[@class='main-row']/child::div[@class='table-td no-border-right'  and position()=1]/descendant::span";
	  private String crashInfoTableViewCrashesIcon = "xpath = //div[text()='Crash information ']/ancestor::div[@class='crash-info']/descendant::div[@class='main-row']/child::div[@class='table-td no-border-right'  and position()=2]/descendant::span[position()=1]";
	  private String crashInfoTablecrashEventsList = "xpath = //div[text()='Crash information ']/ancestor::div[@class='crash-info']/descendant::div[@class='main-row']/child::div[@class='table-td no-border-right'  and position()=2]/descendant::span[position()=3]";
	  private String crashInfoTableNoOfUsersEffectedList = "xpath =  //div[text()='Crash information ']/ancestor::div[@class='crash-info']/descendant::div[@class='main-row']/child::div[@class='table-td no-border-right'  and position()=3]/descendant::span";
	  private String crashInfoTableLastOccurredList = "xpath = //div[text()='Crash information ']/ancestor::div[@class='crash-info']/descendant::div[@class='main-row']/child::div[@class='table-td no-border-right'  and position()=4]/descendant::span";
	  private String downloadReportBtn = "xpath = //span[text()='Download report']" ;
	  private String crashNameTooltip = "xpath = //div[@class='rk-tooltip-inner']";
	  
	  //******************************Crash info Page*************************** */
	  private String crashInfoPageTitle = "xpath = //p[@class='pt-1  mb-0 info-label' and text()='Crash Information ']" ;
	  private String crashInfoPageculumnsText = "xpath = //div[@class='top-container']/child::div[@class='test']/child::div";
	  private String searchTextField = "xpath = //input[@class='search-box']" ;
	  private String searchBtn ="xpath = //button[@id='btn-search']" ;
	  private String clearSearchField ="xpath = //button[@class='clear-btn pb-1']" ;
	  private String crashInfoPageData= "xpath = //div[@class='main-row']/descendant::span[text()!='']"; 
	  private String firstCrashName = "xpath = //div[@class='main-row']/descendant::div[@id='redirect-0-0']";
	  private String crashNameData ="xpath = //div[@class='main-row']/descendant::span[text()!='' and position()=1]"; 
	  private String lastOccuredData ="xpath = //div[@class='main-row']/descendant::span[text()!='' and position()=2]"; 
	  private String crashEventData = "xpath = //div[@class='main-row']/descendant::span[text()!='' and position()=5]"; 
	  private String affectedUserData ="xpath = //div[@class='main-row']/descendant::span[text()!='' and position()=6]"; 
	  private String viewEventImage= "xpath = //div[@class='main-row']/descendant::span[@class='ptr-cursor']"; 
	  private String lastOccurredAscBtn = "#sort-lastOccurred-asc";
	  private String lastOccurredDescBtn = "#sort-lastOccurred-des";

	  //******************************Crash event page*************************** */
	  private String crashEventPageTitle= "xpath = //p[contains(.,'Crash Events')]" ;
	  private String crashEventPageHeaders = "xpath = //div[@class='top-container']/child::div[@class='test']/child::div"; 
	  private String crasEventCrashIds = "xpath = //div[@class='main-row']/child::div[@class='table-td border-right' and position()=1]/descendant::span"; 
	  private String crashEventUserIdList = "xpath = //div[@class='main-row']/child::div[@class='table-td border-right' and position()=2]/descendant::span"; 
	  private String deviceList ="xpath = //div[@class='main-row']/child::div[@class='table-td border-right' and position()=3]/descendant::span"; 
	  private String osVersionList ="xpath = //div[@class='main-row']/child::div[@class='table-td border-right' and position()=4]/descendant::span"; 
	  private String appVersionList = "xpath = //div[@class='main-row']/child::div[@class='table-td border-right' and position()=5]/descendant::span"; 
	  private String dateAndTimeList = "xpath = //div[@class='main-row']/child::div[@class='table-td no-border-right' and position()=6]/descendant::span"; 
	  private String firstCrashID = "xpath = //div[@id='redirect-0-0']"; 


	   //****************************** event details page*************************** */
	  private String eventDetailsPageTitle = "xpath = //span[@class='icon-label']/child::p";
	  private String EventdetailsText ="xpath = //span[.='Event details']" ;
	  private String application = "xpath = //div[.='Application:']/following-sibling::span" ;
	  private String message = "xpath = //div[.='Message:']/following-sibling::span" ;
	  private String appVersion = "xpath = //div[.='App version:']/following-sibling::span" ;
	  private String occurenceTime = "xpath = //div[.='Occurence timeframe:']/following-sibling::span" ;
	  private String memoryUsage = "xpath = //div[.='Memory usage:']/following-sibling::span" ;
	  private String stackTraceTitle = "xpath = //div[@class='stack-header']/child::span[@class='title']";
	  private String stackTrace = "xpath = //div[@class='cls-stack-trace-text']" ;
	  private String downloadTraceBtn = "xpath = //button[@id='download-stack-trace-btn']" ;
	  private String copyTraceButton = "xpath = //button[@id='copy-stack-trace-btn']" ;
	  private String copiedMessage = "xpath = //div[@class='ant-notification-notice-description']" ;
	  private String eventDetailsPageKeys = "xpath = //div[@class='key']";
	  
	 //******************************TOP location table*************************** */
	  private String topLocationTableTitle = "xpath = //div[@class='card-header' and text()='Top locations ']" ;
	  private String toplocationViewAllbtn = "xpath = //div[contains(.,'Top locations')]/ancestor::div[@class='crash-info']/descendant::button[@id='top-location-view-all-btn']";
	  private String toplocationTableHeaders ="xpath = //div[contains(.,'Top locations ')]/ancestor::div[@class='crash-info']/descendant::div[@class='no-border-right header-container left-align']";
	  private String topLocationTableCountriesList = "xpath = //div[text()='Top locations ']/ancestor::div[@class='crash-info']/descendant::div[@class='main-row']/child::div[@class='table-td no-border-right'  and position()=1]/descendant::span";
	  private String topLocationsTableNoOfCrashes = "xpath = //div[text()='Top locations ']/ancestor::div[@class='crash-info']/descendant::div[@class='main-row']/child::div[@class='table-td no-border-right'  and position()=2]/descendant::span";
	  private String topLocationTableNoOfEffectedUsers = "xpath = //div[text()='Top locations ']/ancestor::div[@class='crash-info']/descendant::div[@class='main-row']/child::div[@class='table-td no-border-right'  and position()=3]/descendant::span";

	  
	   //******************************TOP location page*************************** */
	  private String topLocationPageTitle = "xpath = //div[@class='header' and text()='Top locations']" ;
	  private String topLocationPageCulumnsText ="xpath = //div[@class='top-container']/child::div[@class='test']/child::div"; 
	  private String topLocationPageCountriesList = "xpath = //div[@class='main-row']/child::div[@class='table-td border-right' and position()=1]/child::div";
	  private String topLocationPageNoOfCrashesList = "xpath = //div[@class='main-row']/child::div[@class='table-td border-right' and position()=2]/child::div";
	  private String topLocationPageNoOfEffectedUsersList = "xpath = //div[@class='main-row']/child::div[@class='table-td no-border-right' and position()=3]/child::div";
	  private String noOfCrashesAscendingOrderBtn = "xpath = //i[@id='sort-noOfCrashes-asc']";
	  private String noOfCrashesDescendingOrderBtn = "xpath = //i[@id='sort-noOfCrashes-des']";
	  
	  //******************************TOP location/country page*************************** */
	  private String topLocationsPercountry = "xpath = //p[@class='pt-1  mb-0 info-label']"  ;
	  
	  private String countryPageCountryName = "xpath = //div[@class='country-name']" ;
	  private String countyrPageLegends = "xpath = //div[@class='partition-view-key' and contains(.,':')]";
	  private String countryPageNoOfCrashes=  "xpath = //div[.='Total number of crashes:']/following-sibling::span" ;
	  private String countryPageOS = "xpath = //div[.='Most crashed OS:']/following-sibling::span" ;
	  private String countryPageCrashFreeUsers = "xpath = //div[.='% crash free users:']/following-sibling::span" ;
	  private String countryPageCrashedDevice = "xpath = //div[.='Most crashed device:']/following-sibling::span" ;
	  private String countryPageCrashedAppVersion = "xpath = //div[.='Most crashed app version:']/following-sibling::span" ;
	  private String countryPageNumberOfRequests = "xpath = //div[.='Number of requests:']/following-sibling::span";
	  private String countryPageHttpResponseTime = "xpath = //div[.='HTTP response time:']/following-sibling::span";
	  private String countryPageErrorRate = "xpath = //div[.='% Error rate:']/following-sibling::span";


	  private String crashInfoBackButton = "xpath = //button[@id='btn-crashes']" ;
	  private String eventDetailsBackBtn = "xpath = //button[@class='icon-class']" ;
	  private String crashEventsBackBtn = "xpath = //button[@id='btn-crash-back']" ;
	  private String topLocationBackBtn = "xpath = //button[@class='icon-class']" ;
	  private String downloadSuccessMsg ="xpath = //div[@class='ant-notification-notice-with-icon']" ;
	  private String closeSuccessMsg = "xpath = //span[@class='anticon anticon-close ant-notification-close-icon']" ;
	  private String refreshButton = "xpath = //div[@id='btn-refresh']" ;
	  private String calanderValue = "xpath = //div[@class='selected-text ellipsis bg-text']";
	  private String noDataIcon ="xpath =//div[@class='no-data-icon']";
	  
	  private String mapCountriesList = "xpath = //div[@class='vue-world-map g-sm-6']//*[name()='svg']//*[name()='path' ]";
	  private String mapToolTip ="xpath = //div[@class='vue-map-legend-content']/span";
	
	

	public MMCrashesPage(Page page)
	{
		this.page=page;
	}
	
	public List<String> allWidgetXPoints()
	{
		 ArrayList<String> xPoint = new ArrayList<String>();
		 xPoint.add(crashesXaxisLines);
		 xPoint.add(CrashesAffectedUsersXaxisLines);
		 xPoint.add(CrashesByOSXaxisLines);
		 xPoint.add(CrashesByAPPXaxisLines);
		 xPoint.add(CrashesByDeviceXaxisLines);
		 return xPoint;
	}
	
	public List<String> allWidgetXValues()
	{
		 ArrayList<String> xValues = new ArrayList<String>();
		 xValues.add(crashGraphXaxisValues);
		 xValues.add(crashesAffectedXaxisValues);
		 xValues.add(crashesByOSXaxisValues);
		 xValues.add(crashesByAPPXaxisValues);
		 xValues.add(crashesByDeviceXaxisValues);
		 return xValues;
	}
	
	
	public int getSummationOfMultipleToolTipValues(String xAxisLine,String toolTipList)
	{
		//page.locator(xAxisLines).nth(3).scrollIntoViewIfNeeded();
		Locator xAxisLines=page.locator(xAxisLine);
	    int num=xAxisLines.count();
	    HoverOptions hoverOptions=new HoverOptions();
	    hoverOptions.setForce(true);
	    int actualCrashes=0;int count = 0;
	   
	       for(int i=0;i<num;i++)
			 {
	    	   if(count==num-1)
	    	   {
	    	       hoverOptions.setPosition(0,-10);
	    	       xAxisLines.nth(i).hover(hoverOptions); 
	    	   }else
	    	   {
	    	    hoverOptions.setPosition(2,-10);
	    	    xAxisLines.nth(i).hover(hoverOptions);  
	    	   }
	    	   count++;
	    		page.waitForTimeout(200);
	    		 int tipValue = 0;
	    		Locator tooltip = page.locator(toolTipList);
	    		for(int j=0; j<tooltip.count(); j++) {
	    			try {
	    				tipValue = tipValue + Integer.parseInt(tooltip.nth(j).textContent().trim());
					} catch (NumberFormatException e) {
						tipValue = tipValue + (int)Double.parseDouble(tooltip.nth(j).textContent().trim());
					}
	    		}
	    		actualCrashes = actualCrashes + tipValue;
	    	 }
	       
	       return actualCrashes;
	}
	
	public void validateTheCrashesOnMap(String countries,String expectedCrashes,String defaultColor)
	{
		String[] crashes = expectedCrashes.split(",");
		String[] expectedCountries = countries.split(",");
		Locator coutiresList = page.locator(mapCountriesList);
		int actualCrashes = 0;
		HoverOptions options=new HoverOptions();
		options.setPosition(130,130);
		
		for(int i=0;i<coutiresList.count();i++)
		{
			
			
			for(int j=0;j<expectedCountries.length;j++)
			{
				
				if(coutiresList.nth(i).getAttribute("id").equalsIgnoreCase(expectedCountries[j]))
				{
					System.out.println(coutiresList.nth(i).getAttribute("id")+"--------"+expectedCountries[j]);
					if (i==167) {
						coutiresList.nth(i).hover(options);
					}
					else
					{
						coutiresList.nth(i).hover();
					}
					String actualColour = (String) coutiresList.nth(i).evaluate("element =>getComputedStyle(element).fill");
					Assert.assertNotEquals(actualColour, defaultColor);
					actualCrashes=actualCrashes+Integer.parseInt(page.locator(mapToolTip).textContent().trim());
					System.out.println(actualCrashes);
				}
			}
		}
		
		Assert.assertEquals(crashes.length,actualCrashes);
	}
	
	public void validateBackBtnOfTopLocationPage()
	{
		page.locator(topLocationBackBtn).click();
		
		page.waitForSelector(crashesGraphTitle);
		//validate the load widget is displaying properly or not
		Assert.assertTrue(page.locator(crashesGraphTitle).isVisible());
	}
	
	public void validateBackBtnOfTopLocationByCountryPage()
	{
		
		page.locator(topLocationBackBtn).click();
		
		//validate the URL
		String expectedUrl= "**/mobile/kpis/crashes/crashes-top";
		page.waitForURL(expectedUrl);
		Assert.assertTrue(page.url().contains("/mobile/kpis/crashes/crashes-top"));
		
		
		//validate the page title
		Assert.assertTrue(page.locator(topLocationPageTitle).isVisible());

	}
	public void validatePerformanceInfoData(String noOfRequestFromCountry,String errorCallsFromCountry)
	{	
		Assert.assertTrue(page.locator(countryPageNumberOfRequests).textContent().trim().contains(noOfRequestFromCountry));
		Assert.assertTrue(page.locator(countryPageHttpResponseTime).isVisible());
			
		DecimalFormat df= new DecimalFormat("0.00");
		double expectedErrorRate = (Double.parseDouble(errorCallsFromCountry)/Double.parseDouble(noOfRequestFromCountry))*100;
		Assert.assertTrue(page.locator(countryPageErrorRate).textContent().trim().contains(df.format(expectedErrorRate)));
		
	}
	
	public void validateExceptionInfoData(String crashFreeUsersFromCountry,String totalUsersFromCountry,String noOfCrashesFromCountry,String crashesDeviceFromCountry,String crashesOsFromCountry,String crashesAppVersionFromCountry)
	{
		Assert.assertTrue(page.locator(countryPageNoOfCrashes).textContent().trim().equalsIgnoreCase(noOfCrashesFromCountry));
		Assert.assertTrue(page.locator(countryPageOS).textContent().trim().contains(crashesOsFromCountry));
		Assert.assertTrue(page.locator(countryPageCrashedAppVersion).textContent().trim().contains(crashesAppVersionFromCountry.split(",")[0]));
		Assert.assertTrue(page.locator(countryPageCrashedDevice).textContent().trim().contains(crashesDeviceFromCountry.split(",")[0]));
		
		DecimalFormat df= new DecimalFormat("0.00");
		double expectedCrashFreeUserPercentage = (Double.parseDouble(crashFreeUsersFromCountry)/Double.parseDouble(totalUsersFromCountry))*100;
		Assert.assertTrue(page.locator(countryPageCrashFreeUsers).textContent().trim().contains(df.format(expectedCrashFreeUserPercentage)));
		
		
		
		
	}
	
	public void validateTopLocationByCountryText(String extectedText)
	{
		String[] legends = extectedText.split(",");
		
		for(int i=0;i<legends.length;i++)
		{
			Assert.assertEquals(page.locator(countyrPageLegends).nth(i).textContent().trim(), legends[i]);
		}
		
		
	}
	
	public void validateAscendingOrderIcon()
	{
		page.locator(topLocationPageCulumnsText).nth(1).hover();
		util.sortTheColumnInAscendingOrderAndValidateTheColumnData(page,noOfCrashesAscendingOrderBtn ,topLocationPageNoOfCrashesList );
	}
	
	public void validateDescendingOrderIcon()
	{
		page.locator(topLocationPageCulumnsText).nth(1).hover();
		util.sortTheColumnInDescendingOrderAndValidateTheColumnData(page,noOfCrashesDescendingOrderBtn ,topLocationPageNoOfCrashesList );
	}
	
	public void clickOnTopLocationPageCountry()
	{
		page.locator(topLocationPageCountriesList).first().click();
	}
	
	public void clickOnTopLocationPageCrashes()
	{
		page.locator(topLocationPageNoOfCrashesList).first().click();
	}
	public void clickOnTopLocationPageEffectedUsers()
	{
		page.locator(topLocationPageNoOfEffectedUsersList).first().click();
	}
	
	
	public void clickOnTopLocationCountry()
	{
		page.locator(topLocationTableCountriesList).first().click();
	}
	
	public void clickOnTopLocationCrashes()
	{
		page.locator(topLocationsTableNoOfCrashes).first().click();
	}
	public void clickOnTopLocationEffectedUsers()
	{
		page.locator(topLocationTableNoOfEffectedUsers).first().click();
	}
	public void validateTopLocationByCountryPage()
	{

		//validate the URL
		String expectedUrl= "**/kpis/crashes/crashes-top/summary";
		page.waitForURL(expectedUrl);
		System.out.println(page.url()+"--------"+expectedUrl);
		Assert.assertTrue(page.url().contains("/kpis/crashes/crashes-top/summary"));
		
		
		//validate the page title
		Assert.assertTrue(page.locator(topLocationsPercountry).isVisible());
		
		String actualCountry = page.locator(countryPageCountryName).textContent().trim();
		
		page.locator(topLocationBackBtn).click();
		
		String expectedCountry = page.locator(topLocationPageCountriesList).first().textContent().trim();
		
		Assert.assertEquals(actualCountry, expectedCountry);
		
		
	}
	
	public void validateTopLocationPageData(String countries,String noOfCrashes,String efectedUseres)
	{
		page.waitForTimeout(500);
		page.waitForSelector(topLocationPageCountriesList);
		String[] country = countries.split(",");
		
		for(int i=0;i<country.length;i++)
		{
			Assert.assertEquals(page.locator(topLocationPageCountriesList).nth(i).textContent().trim(), country[i]);
			Assert.assertEquals(page.locator(topLocationPageNoOfCrashesList).nth(i).textContent().trim(), noOfCrashes);
			Assert.assertEquals(page.locator(topLocationPageNoOfEffectedUsersList).nth(i).textContent().trim(), efectedUseres);
		}
	}
	public void validateIntegrationBetweenTopLocationTableAndTopLocationPage()
	{
		page.waitForSelector(topLocationTableCountriesList);
		ArrayList<String> expectedCountries = new ArrayList<String>();
		ArrayList<String> expectedNoOfCrashes = new ArrayList<String>();
		ArrayList<String> expectedNoOfcrashEffectedUsers = new ArrayList<String>();
		
		Locator countryNames = page.locator(topLocationTableCountriesList);
		int num = countryNames.count();
		for(int i=0;i<countryNames.count();i++)
		{
			expectedCountries.add(countryNames.nth(i).textContent().trim());
			expectedNoOfCrashes.add(page.locator(topLocationsTableNoOfCrashes).nth(i).textContent().trim());
			expectedNoOfcrashEffectedUsers.add(page.locator(topLocationTableNoOfEffectedUsers).nth(i).textContent().trim());
			
		}
		page.click(toplocationViewAllbtn);
		page.waitForLoadState(LoadState.NETWORKIDLE);
		page.waitForSelector(topLocationPageTitle);
		page.waitForSelector(topLocationPageCountriesList);
		
		ArrayList<String> actualCountries = new ArrayList<String>();
		ArrayList<String> actualNoOfCrashes = new ArrayList<String>();
		ArrayList<String> actualNoOfcrashEffectedUsers = new ArrayList<String>();
		
		for(int i=0;i<num;i++)
		{
			actualCountries.add(page.locator(topLocationPageCountriesList).nth(i).textContent());
			actualNoOfCrashes.add(page.locator(topLocationPageNoOfCrashesList).nth(i).textContent().trim());
			actualNoOfcrashEffectedUsers.add(page.locator(topLocationPageNoOfEffectedUsersList).nth(i).textContent().trim());
		}
		System.out.println(expectedCountries);
		System.out.println(actualCountries);
		Assert.assertTrue(expectedCountries.equals(actualCountries));
		
		Assert.assertTrue(expectedNoOfCrashes.equals(actualNoOfCrashes));
		
		Assert.assertTrue(expectedNoOfcrashEffectedUsers.equals(actualNoOfcrashEffectedUsers));	
	}
	
	public void validateTopLocationsTable(String countries,String noOfCrashes,String efectedUseres)
	{
		page.waitForSelector(topLocationTableCountriesList);
		String[] country = countries.split(",");
		
		for(int i=0;i<country.length;i++)
		{
			Assert.assertEquals(page.locator(topLocationTableCountriesList).nth(i).textContent().trim(), country[i]);
			Assert.assertEquals(page.locator(topLocationsTableNoOfCrashes).nth(i).textContent().trim(), noOfCrashes);
			Assert.assertEquals(page.locator(topLocationTableNoOfEffectedUsers).nth(i).textContent().trim(), efectedUseres);
		}
	}
	
	public void validateTheBackBtnOfCrashInfoPage()
	{
		page.locator(crashInfoBackButton).click();
		
		page.waitForSelector(crashesGraphTitle);
		//validate the load widget is displaying properly or not
		Assert.assertTrue(page.locator(crashesGraphTitle).isVisible());
	}
	
	public void validateBackBtnOfCrashEventsPage()
	{
		page.locator(crashEventsBackBtn).click();
		
		
		//validate the URL
		String expectedUrl= "**/kpis/crashes/crashes-overview";
		page.waitForURL(expectedUrl);
		System.out.println(page.url()+"--------"+expectedUrl);
		Assert.assertTrue(page.url().contains("/kpis/crashes/crashes-overview"));
		
		
		//validate the page title
		Assert.assertTrue(page.locator(crashInfoPageTitle).isVisible());
		
	}
	
	public void validateBackBtnOfEventDatailsPage()
	{
		page.locator(eventDetailsBackBtn).click();
		
		//validate the url
		String expectdUrl = "**/mobile/kpis/crashes/crashes-overview/events";
		page.waitForURL(expectdUrl);
		Assert.assertTrue(page.url().contains("/mobile/kpis/crashes/crashes-overview/events"));
		
		//validate the title
		Assert.assertTrue(page.locator(crashEventPageTitle).isVisible());
		
	}
	public void validateTheCopyBtn(String expectedText)
	{
		//click on the copy icon
		page.locator(copyTraceButton).click();
		
		//validate the copy message
		Assert.assertEquals(page.locator(copiedMessage).last().textContent().trim(), expectedText);
	}
		
		
	
	public void validateDownloadTraceBtn() throws EncryptedDocumentException, IOException
	{
    	Download download = page.waitForDownload(() -> {page.locator(downloadReportBtn).click();});
    	String filePath = eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath, IPathConstant.mmCrashesSheet, "downloadReportFilePath");
    	String fileName = eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath, IPathConstant.mmCrashesSheet, "DownloadReportFileName");
    	download.saveAs(Paths.get(filePath, fileName));
    	System.out.println("File downloaded");
    	String fName = javaUtil.getLatestFilefromDir(filePath).getName();
    	System.out.println(fName +"\t"+fileName);
    	Assert.assertTrue(fName.equalsIgnoreCase(fileName));
    	javaUtil.deleteFile(filePath, fileName);
	}
	
	public void validateEventDetailsPageStackTrace(String StackTrace)
	{
		Assert.assertTrue(page.locator(stackTraceTitle).isVisible());
		Assert.assertEquals(page.locator(stackTrace).textContent().trim(), StackTrace);
	}
	
	public void validateEventDetails(String Application,String crashName,String AppVersion,String occurance,String MemoryUsage) throws EncryptedDocumentException, IOException
	{
		Assert.assertEquals(page.locator(application).textContent().trim(), Application);
		String expectdMessage = crashName.split(",")[5];
		Assert.assertTrue(page.locator(message).textContent().trim().contains(expectdMessage));
		String expectdAppVersion = AppVersion.split(",")[2];
		Assert.assertTrue(page.locator(appVersion).textContent().trim().contains(expectdAppVersion));
		
		boolean flag1=false;
		try {
			if(page.locator(occurenceTime).textContent().trim().contains(occurance));
			flag1=true;
		} catch (Exception e) {
			
			if(page.locator(occurenceTime).textContent().trim().contains(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath, IPathConstant.mmLoadSheet, "LastOccurred1")));
			flag1=true;
		}
		Assert.assertTrue(flag1);
		
		Assert.assertTrue(page.locator(memoryUsage).textContent().trim().contains(MemoryUsage) );
	}
	
	public void validateEventDetailsPageKeys(String keys)
	{
		String[] expectedText = keys.split(",");
		int num = page.locator(eventDetailsPageKeys).count();
		
		for(int i=0;i<num;i++)
		{
			Assert.assertEquals(page.locator(eventDetailsPageKeys).nth(i).textContent().trim(), expectedText[0]);
		}
	}
	
	public void clickOnTheCrashID()
	{
		page.locator(crasEventCrashIds).click();
	}
	
	public void clickOnTheUserID()
	{
		page.locator(crashEventUserIdList).click();
	}
	
	public void clickOnTheDevice()
	{
		page.locator(deviceList).click();
	}
	
	public void clickOnTheOsVersion()
	{
		page.locator(osVersionList).click();
	}
	
	public void clickOnTheAppVersion()
	{
		page.locator(appVersionList).click();
	}
	
	public void clickOnTheDateAndTime()
	{
		page.locator(dateAndTimeList).click();
	}
	
	public void validateEventsDetailsPage()
	{
		//validate the url
		String expectedUrl = "**/kpis/crashes/crashes-overview/events/summary";
		page.waitForURL(expectedUrl);
		Assert.assertTrue(page.url().contains("/kpis/crashes/crashes-overview/events/summary"));
		
		//validate the page title
		String pageTitle = page.locator(eventDetailsPageTitle).textContent().trim();
		Assert.assertTrue(page.locator(EventdetailsText).isVisible());
		page.click(eventDetailsBackBtn);
		page.waitForSelector(crashEventPageHeaders);
		//validate the crash ID on event details pages
		String expectedTitle = page.locator(crasEventCrashIds).textContent().trim();
		Assert.assertEquals(pageTitle, expectedTitle);
		
	}
	
	public void validateTheCrashEventsPageDataWhenNoData()
	{
		page.waitForSelector(noDataIcon);
		Assert.assertTrue(page.locator(noDataIcon).first().isVisible());
	}
	
	public void validateTheCrashEventsPageData(String userId,String device,String osVersion,String appversion) throws EncryptedDocumentException, IOException
	{
		String expectedUserID = userId.split(",")[0];
		String expectedAppVersion = appversion.split(",")[2];
		String dateTime = eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath, IPathConstant.mmLoadSheet, "LastOccurred");
		String dateTime1 = eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath, IPathConstant.mmLoadSheet, "LastOccurred1");
	//	Assert.assertEquals(page.locator(crashEventUserIdList).first().textContent().trim(), expectedUserID);
		Assert.assertEquals(page.locator(deviceList).textContent().trim(), device.split(",")[2]);
		Assert.assertEquals(page.locator(osVersionList).textContent().trim(), osVersion);
		Assert.assertTrue(page.locator(appVersionList).textContent().trim().contains(expectedAppVersion));
		System.out.println(page.locator(dateAndTimeList).textContent().trim()+"--------"+dateTime);
				if(page.locator(dateAndTimeList).textContent().trim().contains(dateTime))
				{
					Assert.assertTrue(page.locator(dateAndTimeList).textContent().trim().contains(dateTime));
				}
				else
				{
					Assert.assertTrue(page.locator(dateAndTimeList).textContent().trim().contains(dateTime1));
				}
		
		
	}
	
	public void validateCrashEventsPageHeaders(String headers)
	{
		String[] expectedHeaders = headers.split(",");
		
		for(int i=0;i<expectedHeaders.length;i++)
		{
			Assert.assertEquals(page.locator(crashEventPageHeaders).nth(i).textContent().trim(), expectedHeaders[i]);
		}
	}
	
	public void validateCrashInfoPageViewCrashesTooltip()
	{
		Locator crashEventsIconList = page.locator(viewEventImage);
		
		for(int i=0;i<crashEventsIconList.count();i++)
		{
			crashEventsIconList.nth(i).hover();
			Assert.assertEquals(page.locator(crashNameTooltip).textContent().trim(),"View crashes");
			page.waitForTimeout(200);	
		}
	}
	
	public void validateCrashInfoPageCrashNameToolTip()
	{
		Locator crashNameList = page.locator(crashNameData);
		
		for(int i=0;i<crashNameList.count();i++)
		{
			crashNameList.nth(i).hover();
			Assert.assertEquals(page.locator(crashNameTooltip).textContent().trim(),crashNameList.nth(i).textContent().trim() );
			page.waitForTimeout(200);	
		}
	}
	
	
	public void validateTheDescendingOrderOfLastOccurredColumn()
	{
			page.waitForSelector(lastOccuredData);
			page.locator(crashInfoPageculumnsText).nth(1).hover();
			page.click(lastOccurredDescBtn);
			page.waitForTimeout(1000);
			DateTimeFormatter formatter = new DateTimeFormatterBuilder().parseCaseInsensitive().appendPattern("dd/MM/yyyy HH:mm:ss").toFormatter(Locale.ENGLISH);
	        DateTimeFormatter formatter1 = new DateTimeFormatterBuilder().parseCaseInsensitive().appendPattern("yyyy/MM/dd HH:mm:ss").toFormatter(Locale.ENGLISH);
	        Locator dates = page.locator(lastOccuredData);
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
	
	public void validateTheAscendingOrderOfLastOccurredColumn()
	{
			page.waitForSelector(lastOccuredData);
			page.locator(crashInfoPageculumnsText).nth(1).hover();
			page.click(lastOccurredAscBtn);
			page.waitForTimeout(1000);
			DateTimeFormatter formatter = new DateTimeFormatterBuilder().parseCaseInsensitive().appendPattern("dd/MM/yyyy HH:mm:ss").toFormatter(Locale.ENGLISH);
	        DateTimeFormatter formatter1 = new DateTimeFormatterBuilder().parseCaseInsensitive().appendPattern("yyyy/MM/dd HH:mm:ss").toFormatter(Locale.ENGLISH);
	        Locator dates = page.locator(lastOccuredData);
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
	
	
	public void validateTheCrashNameOfCrashInfoPage(String crashnameList)
	{
		String[] expectedCrashNames = crashnameList.split(",");
		for(int i=0;i<page.locator(crashInfoTableCrashNamesList).count();i++)
		{	
			boolean flag=false;
			for(int j=0;i<expectedCrashNames.length;j++)
			{
				if(page.locator(crashNameData).nth(i).textContent().trim().contains(expectedCrashNames[j]))
				{
					flag=true;
				}
			}
			Assert.assertTrue(flag);
		}
	}
	
	public void crashInfoPageDataWithTable()
	{
		
		page.waitForSelector(crashInfoTableCrashNamesList);
		ArrayList<String> expectedCrashNames = new ArrayList<String>();
		ArrayList<String> expectedLastOccurred = new ArrayList<String>();
		ArrayList<String> expectedCrashEvents = new ArrayList<String>();
		ArrayList<String> expectedNoOFEffectedUsers = new ArrayList<String>();
		Locator crashNames = page.locator(crashInfoTableCrashNamesList);
		
		for(int i=0;i<crashNames.count();i++)
		{
			expectedCrashNames.add(crashNames.nth(i).textContent().trim());
			expectedLastOccurred.add(page.locator(crashInfoTableLastOccurredList).nth(i).textContent().trim());
			expectedCrashEvents.add(page.locator(crashInfoTablecrashEventsList).nth(i).textContent().trim());
			expectedNoOFEffectedUsers.add(page.locator(crashInfoTableNoOfUsersEffectedList).nth(i).textContent().trim());
		}
		page.click(viewAllBtn);
		page.waitForTimeout(1000);
		page.waitForSelector(crashInfoPageTitle);
		page.waitForSelector(crashNameData);
		
		
		ArrayList<String> actualCrashNames = new ArrayList<String>();
		ArrayList<String> actualLastOccurred = new ArrayList<String>();
		ArrayList<String> actualCrashEvents = new ArrayList<String>();
		ArrayList<String> actualNoOFEffectedUsers = new ArrayList<String>();
		Locator crashData = page.locator(crashNameData);
		for(int i=0;i<crashData.count();i++)
		{
			actualCrashNames.add(page.locator(crashNameData).nth(i).textContent());
			actualLastOccurred.add(page.locator(lastOccuredData).nth(i).textContent().trim());
			actualCrashEvents.add(page.locator(crashEventData).nth(i).textContent().trim());
			actualNoOFEffectedUsers.add(page.locator(affectedUserData).nth(i).textContent().trim());
		}

		Assert.assertTrue(expectedCrashNames.equals(actualCrashNames));
		
		Assert.assertTrue(expectedLastOccurred.equals(actualLastOccurred));
		
		Assert.assertTrue(expectedCrashEvents.equals(actualCrashEvents));
		
		Assert.assertTrue(expectedNoOFEffectedUsers.equals(actualNoOFEffectedUsers));	
		
		
	}
	public void clickOnNoOfEffectedusersIcon()
	{
		page.locator(crashInfoTableNoOfUsersEffectedList).first().click();
	}
	public void clickOnCrashEventIcon()
	{
		page.locator(crashInfoTableViewCrashesIcon).first().click();
	}
	
	public void clickOnLastOccurred()
	{
		page.locator(crashInfoTableLastOccurredList).first().click();
	}
	
	public void clickOnCrashName()
	{
		page.locator(crashInfoTableCrashNamesList).first().click();
	}
	
	public void clickOnCrashNameOfCrashInfoPage()
	{
		page.locator(crashNameData).first().click();
	}
	
	public void clickOnLastOccurredOfCrashInfoPage()
	{
		page.locator(lastOccuredData).first().click();
	}
	
	public void clickOnCrashEventIconOfCrashInfoPage()
	{
		page.locator(viewEventImage).first().click();
	}
	public void clickOnNoOfEffectedusersIconOfCrashInfoPage()
	{
		page.locator(affectedUserData).first().click();
	}
	
	public void validateCrashEventsPage()
	{
		//validate the url
		String expectdUrl = "**/mobile/kpis/crashes/crashes-overview/events";
		page.waitForURL(expectdUrl);
		Assert.assertTrue(page.url().contains("/mobile/kpis/crashes/crashes-overview/events"));
		
		//validate the title
		Assert.assertTrue(page.locator(crashEventPageTitle).isVisible());
				
		
	}
	
	public void validateViewCrashesTooltip()
	{
		Locator crashEventsIconList = page.locator(crashInfoTableViewCrashesIcon);
		
		for(int i=0;i<crashEventsIconList.count();i++)
		{
			crashEventsIconList.nth(i).hover();
			Assert.assertEquals(page.locator(crashNameTooltip).textContent().trim(),"View crashes");
			page.waitForTimeout(200);	
		}
	}
	
	public void validateCrashNameToolTip()
	{
		Locator crashNameList = page.locator(crashInfoTableCrashNamesList);
		
		for(int i=0;i<crashNameList.count();i++)
		{
			crashNameList.nth(i).hover();
			Assert.assertEquals(page.locator(crashNameTooltip).textContent().trim(),crashNameList.nth(i).textContent().trim() );
			page.waitForTimeout(200);	
		}
	}
	
	public void validateTopLocationTableDataWithOutData()
	{
		page.waitForTimeout(500);
		page.waitForSelector(noDataIcon);
		Assert.assertTrue(page.locator(noDataIcon).first().isVisible());
	}
	
	public void validateCrashInfoTableDataWithOutData()
	{
		page.waitForTimeout(500);
		page.waitForSelector(noDataIcon);
		Assert.assertTrue(page.locator(noDataIcon).first().isVisible());
	}
	
	public void validateCrashInfoTableData(String crashNames,String crashEvents,String noOfUsersEffected,String lastoccurred) throws EncryptedDocumentException, IOException
	{
		page.waitForSelector(topLocationTableCountriesList);
		page.waitForTimeout(500);
		Assert.assertTrue(page.locator(crashInfoTableCrashNamesList).count()<= 10);
		
		String[] expectedCrashNames = crashNames.split(",");
		for(int i=0;i<page.locator(crashInfoTableCrashNamesList).count();i++)
		{	
			boolean flag=false;
			for(int j=0;j<expectedCrashNames.length;j++)
			{
				System.out.println(page.locator(crashInfoTableCrashNamesList).nth(i).textContent().trim()+"--------"+expectedCrashNames[j]);
				if(page.locator(crashInfoTableCrashNamesList).nth(i).textContent().trim().contains(expectedCrashNames[j]))
				{
					flag=true;
				}
			}
			Assert.assertTrue(flag);
		Assert.assertTrue(page.locator(crashInfoTableViewCrashesIcon).nth(i).isVisible());
		Assert.assertEquals(page.locator(crashInfoTablecrashEventsList).nth(i).textContent().trim(), crashEvents);
		Assert.assertEquals(page.locator(crashInfoTableNoOfUsersEffectedList).nth(i).textContent().trim(), noOfUsersEffected);
		System.out.println("lastoccurred :"+lastoccurred);
		boolean flag1=false;
		try {
			if(page.locator(crashInfoTableLastOccurredList).nth(i).textContent().trim().contains(lastoccurred));
			flag1=true;
		} catch (Exception e) {
			if(page.locator(crashInfoTableLastOccurredList).nth(i).textContent().trim().contains(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath, IPathConstant.mmLoadSheet, "LastOccurred1")));
			flag1=true;
		}
		Assert.assertTrue(flag1);
		}
	}
	
	public void validateCrashesByAppVersionGraphValue(int expectedCrashes)
	{		
		try {
			page.waitForSelector(crashInfoTableCrashNamesList);
			page.waitForTimeout(500);
		} catch (Exception e) {
		
		}
		 int actualCrashes = getSummationOfMultipleToolTipValues(CrashesByAPPXaxisLines, CrashesByAPPToolTipValuesList);
			System.out.println("expectedCrashes : "+expectedCrashes+"\t actualCrashes : "+actualCrashes);
			Assert.assertTrue(actualCrashes == expectedCrashes);
	}
	
	
	public void validateCrashesByDeviceGraphValue(int expectedCrashes)
	{
		try {
			page.waitForSelector(crashInfoTableCrashNamesList);
			page.waitForTimeout(500);
		} catch (Exception e) {
		
		}
		
		 int	actualCrashes = getSummationOfMultipleToolTipValues(CrashesByDeviceXaxisLines, CrashesByDeviceToolTipValuesList);
			System.out.println("expectedCrashes : "+expectedCrashes+"\t actualCrashes : "+actualCrashes);
			Assert.assertTrue(actualCrashes == expectedCrashes);
	}
	public void validateCrashByOsGraphValue(int expectedCrashes) {
		
		try {
			page.waitForSelector(crashInfoTableCrashNamesList);
			page.waitForTimeout(500);
		} catch (Exception e) {
		
		}
		
	    int	actualCrashes = getSummationOfMultipleToolTipValues(CrashesByOSXaxisLines, crashesByOSToolTipValue);
		System.out.println("expectedErrors : "+expectedCrashes+"\t actualErrors : "+actualCrashes);
		Assert.assertTrue(actualCrashes == expectedCrashes);
	}
	
	public void validateCrashEffectedUsersGraphValue(int expectedCrashes)
	{
		try {
			page.waitForSelector(crashInfoTableCrashNamesList);
			page.waitForTimeout(500);
		} catch (Exception e) {
		
		}
		
		int actualValue = getSummationOfMultipleToolTipValues( CrashesAffectedUsersXaxisLines, crashesAffectedUsersToolTipValue);
		
		Assert.assertEquals(actualValue,expectedCrashes);
		
	}
	
	public void validateCrashesGraphValue(int expectedCrashes)
	{
		try {
			page.waitForSelector(crashInfoTableCrashNamesList);
			page.waitForTimeout(500);
		} catch (Exception e) {
		
		}
		
		int actualValue = getSummationOfMultipleToolTipValues( crashesXaxisLines, crashesGraphToolTipValue);
		
		Assert.assertEquals(actualValue,expectedCrashes);
		
	}
	
	public void validateTopLocationPageHeaders(String headers)
	{
		String[] expectedHeaders = headers.split(",");
		for(int i=0;i<expectedHeaders.length;i++)
		{
			Assert.assertEquals(page.locator(topLocationPageCulumnsText).nth(i).textContent().trim(), expectedHeaders[i]);
		}
	}
	
	public void validateViewAllBtnOfTopLocationTable()
	{
		page.waitForSelector(toplocationViewAllbtn);
		page.locator(toplocationViewAllbtn).click();
		
		//validate the URL
		String expectedUrl= "**/mobile/kpis/crashes/crashes-top";
		page.waitForURL(expectedUrl);
		Assert.assertTrue(page.url().contains("/mobile/kpis/crashes/crashes-top"));
		
		page.waitForSelector(topLocationPageTitle);
		//validate the page title
		Assert.assertTrue(page.locator(topLocationPageTitle).isVisible());
	}
	
	public void validateTopLocationTableHeaders(String headers)
	{
		String[] expectedHeaders = headers.split(",");
	for(int i=0;i<expectedHeaders.length;i++)
	{
		Assert.assertEquals(page.locator(toplocationTableHeaders).nth(i).textContent().trim(), expectedHeaders[i]);
	}
	}
	
	public void validateTopLocationTableTitle(String ExpectedTitle)
	{
		Assert.assertTrue(page.locator(topLocationTableTitle).textContent().trim().contains(ExpectedTitle));
	}
	
	
	public void validatePagination(int num) {
		CommonPage commPage=new CommonPage(page);
		commPage.selectPaginationAndValidate(page, num, crashNameData);
	}
	
	public void validateCrashEventsPageSearchWithValidData()
	{
		util.validateSearchFunctionalityWithValidData(page, firstCrashID, searchTextField, searchBtn, crasEventCrashIds);
	}
	
	public void validateCrashEventsPageSearchWithInValidData()
	{
		util.validateSearchFunctionalityWithInvalidData(page, searchTextField, searchBtn, noDataIcon);
	}
	
	public void validateCrashInfoPageSearchWithValidData()
	{
		util.validateSearchFunctionalityWithValidData(page, firstCrashName, searchTextField, searchBtn, crashNameData);
	}
	
	public void validateCrashInfoPageSearchWithInValidData()
	{
		util.validateSearchFunctionalityWithInvalidData(page, searchTextField, searchBtn, noDataIcon);
	}
	
	public void validateTheCrashInfoPageHeaders(String header)
	{
		String[] expectedHeaders=header.split(",");
		for(int i=0;i<expectedHeaders.length;i++)
		{
			Assert.assertEquals(page.locator(crashInfoPageculumnsText).nth(i).textContent().trim(), expectedHeaders[i]);
		}
	}
	
	public void validateCrashInfoViewAllBtn()
	{
		page.waitForSelector(viewAllBtn);
		page.locator(viewAllBtn).click();
		
		//validate the URL
		String expectedUrl= "**/kpis/crashes/crashes-overview";
		page.waitForURL(expectedUrl);
		System.out.println(page.url()+"--------"+expectedUrl);
		Assert.assertTrue(page.url().contains("/kpis/crashes/crashes-overview"));
		
		
		//validate the page title
		Assert.assertTrue(page.locator(crashInfoPageTitle).isVisible());
		
	}
	
	public void validateWhetherTheDownloadReportButtonIsActive()
	{
		Assert.assertTrue(page.locator(downloadReportBtn).isEnabled());
	}
	
	public void validateDownloadReportButton() throws EncryptedDocumentException, IOException
	{
		String message = eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath, IPathConstant.messageSheet, "TracePage_downloadReportConfirmationMessage");
    	Download download = page.waitForDownload(() -> {page.locator(downloadReportBtn).click();});
    	Assert.assertTrue(page.textContent(downloadSuccessMsg).trim().contains(message));	
    	System.out.println("Message validated");
    	page.click(closeSuccessMsg);
    	String filePath = eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath, IPathConstant.mmCrashesSheet, "downloadReportFilePath");
    	String fileName = eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.MMexcelPath, IPathConstant.mmCrashesSheet, "DownloadReportFileName");
    	download.saveAs(Paths.get(filePath, fileName));
    	System.out.println("File downloaded");
    	String fName = javaUtil.getLatestFilefromDir(filePath).getName();
    	System.out.println(fName +"\t"+fileName);
    	Assert.assertTrue(fName.equalsIgnoreCase(fileName));
    	javaUtil.deleteFile(filePath, fileName);
	}
	
	public void validateCrashInfoTableHeader(String headers)
	{
		String[] expectedHeaders = headers.split(",");
		for(int i=0;i<expectedHeaders.length;i++)
		{
			Assert.assertEquals(page.locator(CrashInfoTableHeader).nth(i).textContent().trim(), expectedHeaders[i]);
		}
	}
	
	public void validateTheCrashInfoTitle(String expectedTitle)
	{
		Assert.assertTrue(page.locator(crashInfoTableTitle).textContent().trim().contains(expectedTitle));
	}
	
	public void validateCrashesByAppLegendsText(String androidLegends,String iosLegends)
	{
		String legends = androidLegends+","+iosLegends;
		String[] expectedLegends = legends.split(",");
		Locator actualLegends = page.locator(CrashesByAPPLegendsList);
		
		for(int i=0;i<actualLegends.count();i++)
		{	boolean flag =false;
			for(int j=0;j<expectedLegends.length;j++)
			{
				if(actualLegends.nth(i).textContent().trim().equalsIgnoreCase(expectedLegends[j]));
				{
					flag=true;
				}
			}
			Assert.assertTrue(flag);
		}
	}
	
	public void validateCrashesByAppLegendsText(String legends)
	{
		String[] expectedLegends = legends.split(",");
		Locator actualLegends = page.locator(CrashesByAPPLegendsList);
		
		for(int i=0;i<actualLegends.count();i++)
		{	boolean flag =false;
			for(int j=0;j<expectedLegends.length;j++)
			{
				if(actualLegends.nth(i).textContent().trim().equalsIgnoreCase(expectedLegends[j]));
				{
					flag=true;
				}
			}
			Assert.assertTrue(flag);
		}
	}
	
	public void validateCrashByOsLegendsTextForAllOs(String legends)
	{
		String[] expectedLegends=legends.split(",");
		Locator actualLegends = page.locator(CrashesByOSLegendsList);
		Assert.assertEquals(actualLegends.nth(0).textContent().trim(), expectedLegends[0]);
		Assert.assertEquals(actualLegends.nth(1).textContent().trim(), expectedLegends[1]);
		
	}
	
	public void validateCrashByOsLegendsTextForIos(String legends)
	{
		page.waitForSelector(CrashesByOSLegendsList);
		page.waitForTimeout(500);
		String[] expectedLegends=legends.split(",");
		Locator actualLegends = page.locator(CrashesByOSLegendsList);
		Assert.assertEquals(actualLegends.nth(0).textContent().trim(), expectedLegends[1]);
		
	}
	
	public void validateCrashByOsLegendsTextForAndroid(String legends)
	{
		page.waitForSelector(CrashesByOSLegendsList);
		page.waitForTimeout(500);
		String[] expectedLegends=legends.split(",");
		Locator actualLegends = page.locator(CrashesByOSLegendsList);
		Assert.assertEquals(actualLegends.nth(0).textContent().trim(), expectedLegends[0]);
		
	}
	
	public void validateCrashByOsLegendsTextForAppVersion(String legends)
	{
		page.waitForSelector(CrashesByOSLegendsList);
		page.waitForTimeout(1000);
		Locator actualLegends = page.locator(CrashesByOSLegendsList);
		Assert.assertEquals(actualLegends.nth(0).textContent().trim(), legends);
	}
	
	public void validateCrashByDeviceLegendsText(String androidLegends,String iosLegends)
	{
		String legends = androidLegends+","+iosLegends;
		String[] expectedLegends = legends.split(",");
		Locator actualLegends = page.locator(crashesByDeviceLegendsList);
		
		for(int i=0;i<actualLegends.count();i++)
		{	boolean flag =false;
			for(int j=0;j<expectedLegends.length;j++)
			{
				if(actualLegends.nth(i).textContent().trim().equalsIgnoreCase(expectedLegends[j]));
				{
					flag=true;
				}
			}
			Assert.assertTrue(flag);
		}
		
	}
	
	public void validateCrashByDeviceLegendsText(String legends)
	{
		page.waitForSelector(crashesByDeviceLegendsList);
		page.waitForTimeout(1000);
		String[] expectedLegends = legends.split(",");
		Locator actualLegends = page.locator(crashesByDeviceLegendsList);
		
		for(int i=0;i<actualLegends.count();i++)
		{	boolean flag =false;
			for(int j=0;j<expectedLegends.length;j++)
			{
				if(actualLegends.nth(i).textContent().trim().equalsIgnoreCase(expectedLegends[j]));
				{
					flag=true;
				}
			}
			Assert.assertTrue(flag);
		}
		
	}
	
	
	public void validateTheMMPageTitle(String expectedTitle)
	{
		util.ValidateTheTitle( page.locator(mobileMonitoringPageTitle).textContent().trim(), expectedTitle);
	}
	
	//*******Crashes*****************************************
	
	public void validatecrashesWidgetTitle(String expectedTitle)
	{
		page.waitForSelector(crashesGraphTitle);
		util.ValidateTheTitle( page.locator(crashesGraphTitle).textContent().trim(), expectedTitle);
	}
	
	public void validatecrashesXaxisTitle(String title)
	{
		util.ValidateTheTitle( page.locator(crashesXaxisTitle).textContent().trim(), title);
	}
	
	public void validatecrashesYaxisTitle(String title)
	{
		util.ValidateTheTitle( page.locator(crashesYaxisTitle).textContent().trim(), title);
	}
	
	public void validateTheCrasheswidgetZoomIn( )
	{
		page.waitForURL("**/mobile/kpis/crashes");
		util.graphZoomIn(page, CrashesZoomIn, CrashesResetBtn, allWidgetXPoints());
	}
	
	public void validateTheCrasheswidgetZoomOut( )
	{
		page.waitForURL("**/mobile/kpis/crashes");
		util.graphZoomOut(page, CrashesZoomIn,CrashesZoomOut, CrashesResetBtn, allWidgetXPoints());
	}
	
	public void validateTheCrasheswidgetZoomReset( )
	{
		page.waitForURL("**/mobile/kpis/crashes");
		util.graphZoomReset(page, CrashesZoomIn, CrashesResetBtn, allWidgetXPoints());
	}
	
	public void validateCrashesWidgetToolTip() throws InterruptedException
	{
		page.waitForURL("**/mobile/kpis/crashes");
		util.validateWidgetToolTips(page, crashesWidgetxAxisLine, crashesGraphToolTip);
	}
	
	public void validateTheCrasheswidgetDragAndDrop( )
	{	page.waitForURL("**/mobile/kpis/crashes");
		util.graphZoomInByDragAndDrop(page,crashesXaxisLines , CrashesResetBtn, allWidgetXPoints());
	}
	
	//****************CrashesAffectedUsers**********************
	
	public void validateCrashesAffectedUsersWidgetTitle(String expectedTitle)
	{
		util.ValidateTheTitle( page.locator(CrashesAffectedUsersGraphTitle).textContent().trim(), expectedTitle);
	}
	
	public void validateCrashesAffectedUsersXaxisTitle(String title)
	{
		util.ValidateTheTitle( page.locator(CrashesAffectedUsersXaxisTitle).textContent().trim(), title);
	}
	
	public void validateCrashesAffectedUsersYaxisTitle(String title)
	{
		util.ValidateTheTitle( page.locator(CrashesAffectedUsersYaxisTitle).textContent().trim(), title);
	}
	
	public void validateTheCrashesAffectedUserswidgetZoomIn( )
	{
		page.waitForURL("**/mobile/kpis/crashes");
		util.graphZoomIn(page, CrashesAffectedUsersZoomIn, CrashesAffectedUsersResetBtn, allWidgetXPoints());
	}
	
	public void validateTheCrashesAffectedUserswidgetZoomOut( )
	{
		page.waitForURL("**/mobile/kpis/crashes");
		util.graphZoomOut(page, CrashesAffectedUsersZoomIn,CrashesAffectedUsersZoomOut, CrashesAffectedUsersResetBtn, allWidgetXPoints());
	}
	
	public void validateTheCrashesAffectedUserswidgetZoomReset( )
	{
		page.waitForURL("**/mobile/kpis/crashes");
		util.graphZoomReset(page, CrashesAffectedUsersZoomIn, CrashesAffectedUsersResetBtn, allWidgetXPoints());
	}
	
	public void validateCrashesAffectedUsersWidgetToolTip() throws InterruptedException
	{
		page.waitForURL("**/mobile/kpis/crashes");
		util.validateWidgetToolTips(page, CrashesAffectedUsersXaxisLines, CrashesAffectedUsersGraphToolTip);
	}
	
	public void validateTheCrashesAffectedUserswidgetDragAndDrop( )
	{
		page.waitForURL("**/mobile/kpis/crashes");
		util.graphZoomInByDragAndDrop(page,CrashesAffectedUsersXaxisLines , CrashesAffectedUsersResetBtn, allWidgetXPoints());
	}
	
	//***********************CrashesByOS*****************************
	
	public void validateCrashesByOSWidgetTitle(String expectedTitle)
	{
		util.ValidateTheTitle( page.locator(CrashesByOSGraphTitle).textContent().trim(), expectedTitle);
	}
	
	public void validateCrashesByOSXaxisTitle(String title)
	{
		util.ValidateTheTitle( page.locator(CrashesByOSXaxisTitle).textContent().trim(), title);
	}
	
	public void validateCrashesByOSYaxisTitle(String title)
	{
		util.ValidateTheTitle( page.locator(CrashesByOSYaxisTitle).textContent().trim(), title);
	}
	
	public void validateTheCrashesByOSwidgetZoomIn( )
	{
		page.waitForURL("**/mobile/kpis/crashes");
		util.graphZoomIn(page, CrashesByOSZoomIn, CrashesByOSResetBtn, allWidgetXPoints());
	}
	
	public void validateTheCrashesByOSwidgetZoomOut( )
	{
		page.waitForURL("**/mobile/kpis/crashes");
		util.graphZoomOut(page, CrashesByOSZoomIn,CrashesByOSZoomOut, CrashesByOSResetBtn, allWidgetXPoints());
	}
	
	public void validateTheCrashesByOSwidgetZoomReset( )
	{
		page.waitForURL("**/mobile/kpis/crashes");
		util.graphZoomReset(page, CrashesByOSZoomIn, CrashesByOSResetBtn, allWidgetXPoints());
	}
	
	public void validateCrashesByOSWidgetToolTip() throws InterruptedException
	{
		page.waitForURL("**/mobile/kpis/crashes");
		util.validateWidgetToolTips(page, CrashesByOSXaxisLines, CrashesByOSGraphToolTip);
	}
	
	public void validateTheCrashesByOSwidgetDragAndDrop( )
	{
		page.waitForURL("**/mobile/kpis/crashes");
		util.graphZoomInByDragAndDrop(page,CrashesByOSXaxisLines , CrashesByOSResetBtn, allWidgetXPoints());
	}
	
	public void validateCrashesByOswidgetLegends()
	{
		page.waitForURL("**/mobile/kpis/crashes");
		util.validateWidgetLegends(page, CrashesByOSLegendsList,CrashesByOSLegendsColorList,CrashesByOSlegendsLineList ,CrashesByOSToolTipColorList ,CrashesByOSXaxisLines,CrashesByOSToolTipText);
	}

	//******************************CrashesByAPP*******************
	
	public void validateCrashesByAPPWidgetTitle(String expectedTitle)
	{
		util.ValidateTheTitle( page.locator(CrashesByAPPGraphTitle).textContent().trim(), expectedTitle);
	}
	
	public void validateCrashesByAPPXaxisTitle(String title)
	{
		util.ValidateTheTitle( page.locator(CrashesByAPPXaxisTitle).textContent().trim(), title);
	}
	
	public void validateCrashesByAPPYaxisTitle(String title)
	{
		util.ValidateTheTitle( page.locator(CrashesByAPPYaxisTitle).textContent().trim(), title);
	}
	
	public void validateTheCrashesByAPPwidgetZoomIn( )
	{
		page.waitForURL("**/mobile/kpis/crashes");
		util.graphZoomIn(page, CrashesByAPPZoomIn, CrashesByAPPResetBtn, allWidgetXPoints());
	}
	
	public void validateTheCrashesByAPPwidgetZoomOut( )
	{
		page.waitForURL("**/mobile/kpis/crashes");
		util.graphZoomOut(page, CrashesByAPPZoomIn,CrashesByAPPZoomOut, CrashesByAPPResetBtn, allWidgetXPoints());
	}
	
	public void validateTheCrashesByAPPwidgetZoomReset( )
	{
		page.waitForURL("**/mobile/kpis/crashes");
		util.graphZoomReset(page, CrashesByAPPZoomIn, CrashesByAPPResetBtn, allWidgetXPoints());
	}
	
	public void validateCrashesByAPPWidgetToolTip() throws InterruptedException
	{
		page.waitForURL("**/mobile/kpis/crashes");
		util.validateWidgetToolTips(page, CrashesByAPPXaxisLines, CrashesByAPPToolTip);
	}
	
	public void validateTheCrashesByAPPwidgetDragAndDrop( )
	{
		page.waitForURL("**/mobile/kpis/crashes");
		util.graphZoomInByDragAndDrop(page,CrashesByAPPXaxisLines , CrashesByAPPResetBtn, allWidgetXPoints());
	}
	
	public void validateCrashesByAppwidgetLegends()
	{
		page.waitForURL("**/mobile/kpis/crashes");
		util.validateWidgetLegends(page, CrashesByAPPLegendsList,CrashesByAPPLegendsColorList,CrashesByAPPlegendsLineList ,CrashesByAPPToolTipColorList ,CrashesByAPPXaxisLines,CrashesByAPPToolTipText);
	}
	
	//*********************************CrashesByDevice******************************
	
	public void validateCrashesByDeviceWidgetTitle(String expectedTitle)
	{
		util.ValidateTheTitle( page.locator(CrashesByDeviceGraphTitle).textContent().trim(), expectedTitle);
	}
	
	public void validateCrashesByDeviceXaxisTitle(String title)
	{
		util.ValidateTheTitle( page.locator(CrashesByDeviceXaxisTitle).textContent().trim(), title);
	}
	
	public void validateCrashesByDeviceYaxisTitle(String title)
	{
		util.ValidateTheTitle( page.locator(CrashesByDeviceYaxisTitle).textContent().trim(), title);
	}
	
	public void validateTheCrashesByDevicewidgetZoomIn( )
	{
		page.waitForURL("**/mobile/kpis/crashes");
		util.graphZoomIn(page, CrashesByDeviceZoomIn, CrashesByDeviceResetBtn, allWidgetXPoints());
	}
	
	public void validateTheCrashesByDevicewidgetZoomOut( )
	{
		page.waitForURL("**/mobile/kpis/crashes");
		util.graphZoomOut(page, CrashesByDeviceZoomIn,CrashesByDeviceZoomOut, CrashesByDeviceResetBtn, allWidgetXPoints());
	}
	
	public void validateTheCrashesByDevicewidgetZoomReset( )
	{
		page.waitForURL("**/mobile/kpis/crashes");
		util.graphZoomReset(page, CrashesByDeviceZoomIn, CrashesByDeviceResetBtn, allWidgetXPoints());
	}
	
	public void validateCrashesByDeviceWidgetToolTip() throws InterruptedException
	{
		page.waitForURL("**/mobile/kpis/crashes");
		util.validateWidgetToolTips(page, CrashesByDeviceXaxisLines, CrashesByDeviceToolTip);
	}
	
	public void validateTheCrashesByDevicewidgetDragAndDrop( )
	{
		page.waitForURL("**/mobile/kpis/crashes");
		util.graphZoomInByDragAndDrop(page,CrashesByDeviceXaxisLines , CrashesByDeviceResetBtn, allWidgetXPoints());
	}
	
	public void validateCrashesByDeviceswidgetLegends()
	{
		page.waitForURL("**/mobile/kpis/crashes");
		util.validateWidgetLegends(page, crashesByDeviceLegendsList,crashesByDeviceLegendsColorList,crashesByDevicelegendsLineList ,crashesByDeviceToolTipColorList ,CrashesByDeviceXaxisLines,crashesByDeviceToolTipText);
	}
	
	//************************************************************************
	
	public void navigateToCrashesPage()
	{
		page.click(kpisTab);
		page.click(crashesTab);
	}
	
	public void selectTheApplicationForMM(String application)
	{
		util.selectTheOptionFromDropDownBySearch(page, applicationDropDown, searchField, application, searchedApplications);
	}
	
	public void selectOS(String os)
	{
		//select the option from drop down
		page.locator(selectOsDropdownBtn).click();

		if(os.equalsIgnoreCase("All"))
		{
		page.locator(selectOsForAll).click();
		}
		else if(os.equalsIgnoreCase("iOS"))
		{
			page.locator(selectOSForiOS).click();
		}
		else if(os.equalsIgnoreCase("Android"))
		{
			page.locator(selectOsForAndriod).click();
		}
		page.waitForLoadState(LoadState.NETWORKIDLE);
	}
	
	public void selectAppVersion(String appversion)
	{
		//select the application from drop down
		page.locator(selectAppVersionDropdownBtn).click();
		page.locator(selectAppVerTextField).clear();
		page.locator(selectAppVerTextField).fill(appversion);
		page.waitForSelector(searchedAppVer);
		Locator actualsearchedApplications=page.locator(searchedAppVer);				
		for(int i=0;i<actualsearchedApplications.count();i++)
		{ 
			if(actualsearchedApplications.nth(i).textContent().trim().contains(appversion))
			{
				actualsearchedApplications.nth(i).click();
				break;
			}
		}
		page.waitForLoadState(LoadState.NETWORKIDLE);
		page.waitForTimeout(800);
	}
	
	public void validateTheGivenTimeLine()
	{	page.waitForTimeout(1000);
		page.waitForURL("**/mobile/kpis/crashes");
		page.waitForSelector(crashGraphXaxisValues);
		util.validateTheGraphdisplayingTheDataAsPerGivenTimeLines(page,crashGraphXaxisValues,calanderValue,allWidgetXValues());
	}
	
	public void validateTheCustomTimeLine(String period)
	{
		page.waitForTimeout(1000);
		page.waitForURL("**/mobile/kpis/crashes");
		page.waitForSelector(crashGraphXaxisValues);
		util.validateCustomTimeLine(page,crashGraphXaxisValues,period,allWidgetXValues());
	}
	
	public void validateTheKPIsTab()
	{
		//validate the KPI's tab is displayed or not
		Locator kpiTab=page.locator(kpisTab);
		Assert.assertTrue(kpiTab.isVisible());
		
		//click on the KPI's tab
		kpiTab.click();
		
		//Validate the usage, crashes and performance tabs are displaying or not
		Assert.assertTrue(page.locator(usageTab).isVisible());
		Assert.assertTrue(page.locator(crashesTab).isVisible());
		Assert.assertTrue(page.locator(performanceTab).isVisible());
		
	}
	
	public void validateTheCrashespage()
	{
		//click on the crashes tab
		page.locator(crashesTab).click();
		
		page.waitForSelector(crashesGraphTitle);
		
		//validate the load widget is displaying properly or not
		Assert.assertTrue(page.locator(crashesGraphTitle).isVisible());
	}
	
	
	
}
