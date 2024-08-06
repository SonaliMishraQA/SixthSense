package objectRepository.DBM;

import java.io.IOException;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Locator.HoverOptions;
import com.microsoft.playwright.Page;

import genericUtilities.ExcelUtility;
import genericUtilities.GenericMethods;
import genericUtilities.IPathConstant;

public class CouchbaseClusterOverviewPage{
	Page page;
	GenericMethods util = new GenericMethods();
	ExcelUtility excel = new ExcelUtility();
	
	private String DBMPageTitle = "#title-text-database";
	private String selectDatabaseTypeText = "xpath = //div[@class=\"dropdown-dashboard\"]/child::div[@class = 'full']/child::div[@class=\"heading\"]";
	private String selectClusterText = "xpath = //div[@class=\"dropdown-dashboard ml-4\"]/child::div[@class = 'full']/child::div[@class=\"heading\"]";
	
	private String selectDatabaseDropdown = "#btn-arrow-down-search-select-database-type";
	private String DatabaseSearchboxInputField = "#input-search-sel-search-select-database-type";
	private String DatabaseSearchResults = "#search-select-database-type-0-single";
	private String selectClusterDropdown = "#btn-arrow-down-search-select-database-service";
	private String ClusterSearchboxInputField = "#input-search-sel-search-select-database-service";
	private String ClusterSearchResults = "#search-select-database-service-0-single";
	
	private String clusterTab = "xpath = //div[@class='navtab']/div[@class='item' and position()=1]/child::div";
	private String nodeTab = "xpath = //div[@class='navtab']/div[@class='item' and position()=2]/child::div";
	private String queriesTab = "xpath = //div[@class='navtab']/div[@class='item' and position()=3]/child::div";
	private String bucketTab = "xpath = //div[@class='navtab']/div[@class='item' and position()=4]/child::div";
	
	
	private String clusterTabTitle = "xpath=//div[@class='router activeRouter']";
    private String clusterName = "xpath = //div[@class='card-body']/child::div[@class='cards' and position()=1]/descendant::div[@class='textLabel']";
    private String couchbaseVersion = "xpath = //div[@class='card-body']/child::div[@class='cards' and position()=2]/descendant::div[@class='textLabel']" ;
    private String statusCard = "xpath = //div[@class='card-body']/child::div[@class='cards' and position()=3]/descendant::div[@class='textLabel']"  ;
    private String numberOfNodes = "xpath = //div[@class='card-body']/child::div[@class='cards' and position()=4]/descendant::div[@class='textLabel']"  ;
    private String numberOfBuckets = "xpath = //div[@class='card-body']/child::div[@class='cards' and position()=5]/descendant::div[@class='textLabel']"  ;

    private String clusterNameValue = "xpath = //div[@class='card-body']/child::div[@class='cards' and position()=1]/descendant::div[@class='textVal fair']"   ;
    private String couchbaseVersionValue = "xpath = //div[@class='card-body']/child::div[@class='cards' and position()=2]/descendant::div[@class='textVal fair']"  ;
    private String statusCardValue = "xpath = //div[@class='card-body']/child::div[@class='cards' and position()=3]/descendant::div[contains(@class,'textVal')]"  ;
    private String numberOfNodesValue = "xpath = //div[@class='card-body']/child::div[@class='cards' and position()=4]/descendant::div[@class='textVal fair']"  ;
    private String numberOfBucketsValue = "xpath = //div[@class='card-body']/child::div[@class='cards' and position()=5]/descendant::div[@class='textVal fair']"  ;
    
    private String usedText = "xpath = //div[@class='card-color-info']/descendant::div[@class='circle primary' ]/following-sibling::div"  ;
    private String availableText = "xpath = //div[@class='card-color-info']/descendant::div[@class='circle secondary' ]/following-sibling::div"  ;
    private String usedIcon = "xpath = //div[@class='card-color-info']/descendant::div[@class='circle primary' ]"  ;
    private String availableIcon = "xpath = //div[@class='card-color-info']/descendant::div[@class='circle secondary' ]"  ;
    private String diskUsageValueList = "xpath = //div[@class='progress-body']";

  

    private String clusterCpuUsageWidgetTitle = "xpath = //div[@class='wrapper']/descendant::div[@class='line-title'][position()=1]"  ;
    private String clusterCpuUsageZoomOutBtn = "#Cluster-CPU-usage-zoom-out"  ;
    private String clusterCpuUsageZoomInBtn = "#Cluster-CPU-usage-zoom-in" ;
    private String clusterCpuUsageResetBtn = "#Cluster-CPU-usage-zoom-reset" ;
    private String clusterCpuUsageXaxisLines = "xpath = //div[@id='apexchartsvuechart-line-0']/ancestor::div[@class='chart-line']/descendant::*[name()='line' and @class='apexcharts-xaxis-tick']";
    private String clusterCpuUsageXaxisValues = "xpath = //div[@id='apexchartsvuechart-line-0']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-label apexcharts-xaxis-label']/child::*[name()='tspan' and contains(text(),'-')]";
    private String clusterCpuUsageXaxisTitle = "xpath = //div[@id='apexchartsvuechart-line-0']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-title-text chart-lables']";
    private String clusterCpuUsageYaxisTitle = "xpath = //div[@id='apexchartsvuechart-line-0']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-yaxis-title-text chart-lables']";
    private String clusterCpuUsageToolTipTitle = "xpath = //div[@id='apexchartsvuechart-line-0']/ancestor::div[@class='chart-box']/descendant::div[@class='apexcharts-tooltip-title']";
    private String clusterCpuUsageTooltipValue = "xpath = //div[@id='apexchartsvuechart-line-0']/ancestor::div[@class='chart-box']/descendant::div[@class='apexcharts-tooltip-text']";

    private String clusterRamUsageWidgetTitle = "xpath = //div[@class='wrapper']/descendant::div[@class='line-title'][position()=2]" ;
    private String clusterRamUsageZoomOutBtn = "#Cluster-RAM-usage-zoom-out" ;
    private String clusterRamUsageZoomInBtn = "#Cluster-RAM-usage-zoom-in"  ;
    private String clusterRamUsageResetBtn = "#Cluster-RAM-usage-zoom-reset"  ;
    private String clusterRamUsageXaxisLines = "xpath = //div[@id='apexchartsvuechart-line-1']/ancestor::div[@class='chart-line']/descendant::*[name()='line' and @class='apexcharts-xaxis-tick']" ;
    private String clusterRamUsageXaxisValues = "xpath = //div[@id='apexchartsvuechart-line-1']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-label apexcharts-xaxis-label']/child::*[name()='tspan' and contains(text(),'-')]" ;
    private String clusterRamUsageXaxisTitle = "xpath = //div[@id='apexchartsvuechart-line-1']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-title-text chart-lables']" ;
    private String clusterRamUsageYaxisTitle = "xpath = //div[@id='apexchartsvuechart-line-1']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-yaxis-title-text chart-lables']";
    private String clusterRamUsageToolTipTitle = "xpath = //div[@id='apexchartsvuechart-line-1']/ancestor::div[@class='chart-box']/descendant::div[@class='apexcharts-tooltip-title']";
    private String clusterRamUsageTooltipValue = "xpath = //div[@id='apexchartsvuechart-line-1']/ancestor::div[@class='chart-box']/descendant::div[@class='apexcharts-tooltip-text']";


    private String diskUsageCardTitle = "xpath = //div[@class='card-header']"  ;
    private String diskUsageCardNodataText = "xpath = //div[@class='no-data-icon']/descendant::div[@class='inner-text']"  ;
    private String diskUsageApplicationText = "xpath = //div[@class='progress-header-content-identifier']"  ;
    private String totalMemoryText = "xpath = //div[@class='total-color']";
    private String totalMemoryValue = "xpath = //div[@class='card-body']/descendant::div[@class='progress-body'][position()=1]/descendant::div[@class = 'total-value-color' ][position()=1]";
    private String usedMemoryValue = "xpath = //div[@class='card-body']/descendant::div[@class='progress-body'][position()=1]/descendant::div[@class = 'progress-tail-content-identifier-value' ][position()=1]"  ;
    private String usedMemoryValueArea = "xpath = //div[@class='card-body']/descendant::div[@class='progress-body'][position()=1]/descendant::div[@class = 'rex-progress-inner' ]";
    private String usedMemoryText = "xpath = //div[@class='progress-tail']/child::div[position()=1]/child::div[@class='progress-tail-content-identifier']" ;
    private String availableMemoryText = "xpath = //div[@class='progress-tail']/child::div[position()=2]/child::div[@class='progress-tail-content-identifier']" ;
    private String availableMemoryValue = "xpath = //div[@class='card-body']/descendant::div[@class='progress-body'][position()=1]/descendant::div[@class = 'progress-tail-content-identifier-value' ][position()=2]"  ;

    //Calendar Value
    private String calendarValue = "xpath = //div[@class='selected-text ellipsis bg-text']";
    private String softRefresh = "#btn-refresh";
    
    
    public CouchbaseClusterOverviewPage(Page page) {
    	this.page=page;
	}
    
    
    public List<String> allWidgetXPoints()
    {
    	ArrayList<String> xPoint = new ArrayList<String>();
    	xPoint.add(clusterCpuUsageXaxisLines);
    	xPoint.add(clusterRamUsageXaxisLines);
    	return xPoint;
    }
    
    
    public List<String> allWidgetXValues(){
    	ArrayList<String> xValue = new ArrayList<String>();
    	xValue.add(clusterCpuUsageXaxisValues);
    	xValue.add(clusterRamUsageXaxisValues);
    	return xValue;
    	
    }
    
    public void validateTheDiskUsageTotalMemory(String expectedTotalMemory)
    {
      	double expectedTotalMemoryInGB = ((Double.parseDouble(expectedTotalMemory) /1024.0)/1024.0)/1024.0;
    	DecimalFormat df = new DecimalFormat("#.##");
    	df.setRoundingMode(RoundingMode.HALF_UP);
    	System.out.println(df.format(expectedTotalMemoryInGB));
    	
    	String actualTotalMemory = page.locator(totalMemoryValue).textContent().trim();
    	
    	Assert.assertTrue(actualTotalMemory.contains(df.format(expectedTotalMemoryInGB)));
    }
    
    public void validateDiskUsageAvailableMemory(String expectedDiskUsage,String expectedTotalMemory)
    {
    	double availableMemory = Double.parseDouble(expectedTotalMemory)-Double.parseDouble(expectedDiskUsage);
    	
    	double expectedAvailableMemory = (((availableMemory /1024.0)/1024.0)/1024.0);
    	
    	System.out.println(expectedAvailableMemory);
    	
    	DecimalFormat df = new DecimalFormat("#.##");
    	df.setRoundingMode(RoundingMode.UP);
    	System.out.println(df.format(expectedAvailableMemory));
    	
    	String actualAvailableMemory = page.locator(availableMemoryValue).textContent().trim();
    	
    	Assert.assertTrue(actualAvailableMemory.contains(df.format(expectedAvailableMemory)));
    }
    
    public void validateTheDiskUsageUsedMemory(String expectedDiskUsage,String expectedTotalMemory ) throws EncryptedDocumentException, IOException
    {
    	
    	double expectedTotalMemoryInGB = ((Double.parseDouble(expectedTotalMemory) /1024.0)/1024.0)/1024.0;
    	
    	double expectedUsedMemoryInGB = ((Double.parseDouble(expectedDiskUsage) /1024.0)/1024.0)/1024.0;
    	DecimalFormat df = new DecimalFormat("#.##");
    	df.setRoundingMode(RoundingMode.UP);
    	System.out.println(df.format(expectedUsedMemoryInGB));
    	
    	String actualUsedMemory = page.locator(usedMemoryValue).textContent().trim();
    	Assert.assertTrue(actualUsedMemory.contains(df.format(expectedUsedMemoryInGB)));
    	String usedArea = page.locator(usedMemoryValueArea).getAttribute("style");
    	
    	System.out.println("usedArea :" + usedArea);
    	String expectedUsedArea = "";
    	for( int i=0;i<usedArea.length();i++)
    	{
    		if(Character.isDigit(usedArea.charAt(i)) || usedArea.charAt(i) =='.')
    		{
    			expectedUsedArea=expectedUsedArea+usedArea.charAt(i);
    		}
    	}
    	
    	System.out.println("expectedUsedArea :"+ expectedUsedArea);
    	
    	double actualUsedArea = (expectedTotalMemoryInGB)/100.0 * Double.parseDouble(expectedUsedArea);
    	
    	Assert.assertEquals(df.format(expectedUsedMemoryInGB),df.format(actualUsedArea));
    	System.out.println(actualUsedArea);
    	
     	String actualColor = (String) page.locator(usedMemoryValueArea).evaluate("element => getComputedStyle(element).background");
     	String expectedColor = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.couchBaseSheet, "DiskUsedColor");
    	Assert.assertTrue(expectedColor.contains(actualColor));
    	
    }
    public void validateDiskUsageCardText(String text)
    {
    	String[] expectedText = text.split(",");
    	Assert.assertEquals(page.locator(totalMemoryText).nth(0).textContent().trim(), expectedText[0]);
    	Assert.assertEquals(page.locator(usedMemoryText).nth(0).textContent().trim(), expectedText[1]);
    	Assert.assertEquals(page.locator(availableMemoryText).nth(0).textContent().trim(), expectedText[2]);
    	
    }
    
    public void validateTheClusterRamUsageWidgetValue(String expectedClusterRAMUsage)
    {
    	
    	page.click(softRefresh);
    	 page.waitForTimeout(5000);
    	 HoverOptions option =new HoverOptions();
		  option.setForce(true);
		  option.setPosition(0,-15);
		  page.locator(clusterRamUsageXaxisLines).last().hover(option);
		  page.waitForTimeout(500);
		  page.waitForSelector(clusterRamUsageTooltipValue);
		  String tooltipValue= page.locator(clusterRamUsageTooltipValue).textContent().trim();
		  System.out.println("tooltipValue :"+ tooltipValue);
		  double expectedRam = Double.parseDouble(tooltipValue);
		  DecimalFormat df =new DecimalFormat("#");
		 System.out.println(df.format(expectedRam));
		 double ramInMB = (Double.parseDouble(expectedClusterRAMUsage))/ 1024.0 / 1024.0  ; 
		 System.out.println("ramInMB : "+ df.format(ramInMB));
		 Assert.assertEquals(df.format(expectedRam),df.format(ramInMB) );
		 
		
		
    }
    
    public void validateTheClusterCpuWidgetValue(String expectedClusterCpuUsage)
    {
    	page.waitForSelector(clusterCpuUsageWidgetTitle);
		System.out.println(expectedClusterCpuUsage);
		//converting the decimal values to nearest integer value
		  DecimalFormat df=new DecimalFormat("#.#");
		  df.setRoundingMode(RoundingMode.UP);
		  String Value = df.format(Double.parseDouble(expectedClusterCpuUsage));
		  double value = Double.parseDouble(Value);
		  
		  DecimalFormat formater = new DecimalFormat("#");
		  formater.setRoundingMode(RoundingMode.UP);
		  String Value1 = formater.format(value);
		  Double expectedValue =  Double.parseDouble(Value1);
		  System.out.println(expectedValue);
		  
		  //hover on to Cluster cpu useg widget to fetch the latest tool tip value 
		  HoverOptions option =new HoverOptions();
		  option.setForce(true);
		  option.setPosition(0,-15);
		  page.locator(clusterCpuUsageXaxisLines).last().hover(option);
		  page.waitForTimeout(500);
		  page.waitForSelector(clusterCpuUsageTooltipValue);
		  String tooltipValue= page.locator(clusterCpuUsageTooltipValue).textContent().trim();
		  System.out.println("tooltipValue :"+ tooltipValue);
		  //validate the widget value with expected value
		  Assert.assertEquals(Double.parseDouble(tooltipValue), expectedValue);
    }
    
    public void validateTheDiskCarsValuesList(int expectedValue)
    {
    	int actualValueList = page.locator(diskUsageValueList).count();
    	Assert.assertEquals(actualValueList, expectedValue);
    }
    public void validateTheDiskAvailableColor(String expectedColor)
    {
       	String actualColor = (String) page.locator(availableIcon).evaluate("element => getComputedStyle(element).color");
    	Assert.assertTrue(actualColor.contains(expectedColor));
    }

    public void validateTheDiskUsageColor(String expectedColor)
    {
    	String actualColor = (String) page.locator(usedIcon).evaluate("element => getComputedStyle(element).color");
    	Assert.assertTrue(actualColor.contains(expectedColor));
    }
    public void validateStatusValueColour() throws EncryptedDocumentException, IOException
    {
    	String text = page.locator(statusCardValue).textContent().trim();
    	String actualColor = (String)page.locator(statusCardValue).evaluate("element => getComputedStyle(element).color");
    	if(text.equalsIgnoreCase("Active"))
    	{
    		String expectedColor  = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.couchBaseSheet, "ActiveStatusColor");
    		Assert.assertTrue(actualColor.contains(expectedColor));
    	} else if (text.equalsIgnoreCase("Inactive"))
    	{
    		String expectedColor  = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.couchBaseSheet, "InactiveStatusColor");
    		Assert.assertTrue(actualColor.contains(expectedColor));
    	}
    	else
    	{
    		String expectedColor  = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.couchBaseSheet, "NodataStatusColor");
    		Assert.assertTrue(actualColor.contains(expectedColor));
    	}
    }
   
    
    public void validateTheOverviewPageWidgets()
    {
    	Assert.assertTrue(page.locator(clusterCpuUsageWidgetTitle).isVisible());
    	Assert.assertTrue(page.locator(clusterRamUsageWidgetTitle).isVisible());
    	Assert.assertTrue(page.locator(diskUsageCardTitle).isVisible());
    }
    
    public void validateTheTheCouchBasePageTabs()
    {
    	Assert.assertTrue(page.locator(clusterTab).isVisible());
    	Assert.assertTrue(page.locator(nodeTab).isVisible());
    	Assert.assertTrue(page.locator(queriesTab).isVisible());
    	Assert.assertTrue(page.locator(bucketTab).isVisible());
    }
    
    public void validateSelectClusterDropdown(String expectedCluster)
    {
		page.locator(selectClusterDropdown).click();
		page.locator(ClusterSearchboxInputField).clear();
		page.locator(ClusterSearchboxInputField).fill(expectedCluster);
		page.waitForSelector(ClusterSearchResults);
		Locator actualsearchedApplications=page.locator(ClusterSearchResults);	
		boolean flag  = false;
		for(int i=0;i<actualsearchedApplications.count();i++)
		{ 
			if(actualsearchedApplications.nth(i).textContent().trim().equalsIgnoreCase(expectedCluster))
			{
				actualsearchedApplications.nth(i).click();
				flag= true;
				break;
			}
		}
		Assert.assertTrue(flag);
    }
    public void validateTheCouchBaseOptionInDataBaseDropDown() throws EncryptedDocumentException, IOException
    {
    	String database = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.couchBaseSheet, "Database"); 
    	//select the application from drop down
		page.locator(selectDatabaseDropdown).click();
		page.locator(DatabaseSearchboxInputField).clear();
		page.locator(DatabaseSearchboxInputField).fill(database);
		page.waitForSelector(DatabaseSearchResults);
		Locator actualsearchedApplications=page.locator(DatabaseSearchResults);	
		boolean flag  = false;
		for(int i=0;i<actualsearchedApplications.count();i++)
		{ 
			if(actualsearchedApplications.nth(i).textContent().trim().equalsIgnoreCase(database))
			{
				actualsearchedApplications.nth(i).click();
				flag= true;
				break;
			}
		}
		Assert.assertTrue(flag);
    }
    
    public void validateDbmPageTitle(String expectedTitle) {
    	String actualTitle = page.locator(DBMPageTitle).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
    
    public void navigateToCouchbase() throws EncryptedDocumentException, IOException {
    	String database = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.couchBaseSheet, "Database"); 
    	util.selectTheOptionFromDropDownBySearch(page, selectDatabaseDropdown, DatabaseSearchboxInputField, database, DatabaseSearchResults);
    }
    
    public void selectClusterFromDropdown() throws EncryptedDocumentException, IOException {
    	String cluster = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.couchBaseSheet, "SelectCluster");
    	util.selectTheOptionFromDropDownBySearch(page, selectClusterDropdown, ClusterSearchboxInputField, cluster, ClusterSearchResults);
    }
    
    public void navigateToClusterOverviewTab() {
    	page.locator(clusterTabTitle).click();
    	page.waitForSelector(clusterName);
    	Assert.assertTrue(page.locator(clusterName).isVisible());
    }
    
    public void validateClusterOverviewTabTitle(String expectedTitle) {
    	String actualTitle = page.locator(clusterTabTitle).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }
    
    public void validateClusterNameCardIsVisible() {
    	Assert.assertTrue(page.locator(clusterName).isVisible());
    }

    public void validateClusterNameCard(String expectedTitle) {
    	String actualTitle = page.locator(clusterName).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
       
    }

    public void validateCouchbaseVersionCard(String expectedTitle) {
    	String actualTitle = page.locator(couchbaseVersion).textContent().trim();
        util.ValidateTheTitle(actualTitle, expectedTitle);
    }

    public void validateStatusCard(String expectedTitle) {
    	String actualTitle = page.locator(statusCard).textContent().trim();
        util.ValidateTheTitle(actualTitle, expectedTitle);
    }

    public void validateNumberOfNodesCard(String expectedTitle) {
    	String actualTitle = page.locator(numberOfNodes).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }

    public void validateNumberOfBucketsCard(String expectedTitle) {
    	String actualTitle = page.locator(numberOfBuckets).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);;
    }

    public void validateClusterNameValue(String expectedTitle) {
    	String actualTitle = page.locator(clusterNameValue).textContent().trim();
        util.ValidateTheTitle(actualTitle, expectedTitle); 
    }

    public void validateCouchbaseVersionValue(String expectedTitle) {
    	String actualTitle = page.locator(couchbaseVersionValue).textContent().trim();
        util.ValidateTheTitle(actualTitle, expectedTitle);
    }

    public void validateStatusCardValue(String expectedTitle) {
    	String actualTitle = page.locator(statusCardValue).textContent().trim();
        util.ValidateTheTitle(actualTitle, expectedTitle);
    }

    public void validateNumberOfNodesValue(String expectedTitle) {
    	String actualTitle = page.locator(numberOfNodesValue).textContent().trim();
        util.ValidateTheTitle(actualTitle, expectedTitle);
    }

    public void validateNumberOfBucketsValue(String expectedTitle) {
    	String actualTitle = page.locator(numberOfBucketsValue).textContent().trim();
        util.ValidateTheTitle(actualTitle, expectedTitle);
    }

    public void validateUsedText(String expectedTitle) {
    	String actualTitle = page.locator(usedText).textContent().trim();
        util.ValidateTheTitle(actualTitle, expectedTitle);
    }

    public void validateAvailableText(String expectedTitle) {
    	String actualTitle = page.locator(availableText).textContent().trim();
        util.ValidateTheTitle(actualTitle, expectedTitle);;
    }

    public void validateUsedIcon(String expectedColor) {
        validateTheLegendsColor(page, usedIcon, expectedColor);
    }

    public void validateAvailableIcon(String expectedColor) {
        validateTheLegendsColor(page, availableIcon, expectedColor);
    }

    public void validateClusterCpuUsageWidvalidateTitle(String expectedTitle) {
    	String actualTitle = page.locator(clusterCpuUsageWidgetTitle).textContent().trim();
        util.ValidateTheTitle(actualTitle, expectedTitle);
    }

    public void validateClusterCpuUsageZoomOutBtn() {
        util.graphZoomOut(page, clusterCpuUsageZoomInBtn, clusterCpuUsageZoomOutBtn, clusterCpuUsageResetBtn, allWidgetXPoints());
    }

    public void validateClusterCpuUsageZoomInBtn() {
        util.graphZoomIn(page, clusterCpuUsageZoomInBtn, clusterCpuUsageResetBtn, allWidgetXPoints());
    }

    public void validateClusterCpuUsageResetBtn() {
        util.graphZoomReset(page, clusterCpuUsageZoomInBtn, clusterCpuUsageResetBtn, allWidgetXPoints());
    }
    
    public void validateClusterCpuUsageDragDrop() {
    	util.graphZoomInByDragAndDrop(page, clusterCpuUsageXaxisLines, clusterCpuUsageResetBtn, allWidgetXPoints());
    }
    
    
//    public void validateClusterCpuUsageXaxisLines() {
//        return clusterCpuUsageXaxisLines;
//    }

    public void validateClusterCpuUsageXaxisValues() {
        util.validateTheGraphdisplayingTheDataAsPerGivenTimeLines(page, clusterCpuUsageXaxisValues, calendarValue, allWidgetXValues());
    }

    public void validateClusterCpuUsageXaxisTitle(String expectedTitle) {
    	String actualTitle = page.locator(clusterCpuUsageXaxisTitle).textContent().trim();
        util.ValidateTheTitle(actualTitle, expectedTitle);
    }

    public void validateClusterCpuUsageYaxisTitle(String expectedTitle) {
    	String actualTitle = page.locator(clusterCpuUsageYaxisTitle).textContent().trim();
        util.ValidateTheTitle(actualTitle, expectedTitle);
    }

    public void validateClusterCpuUsagetoolTipTitle(){
        util.validateWidgetToolTips(page, clusterCpuUsageXaxisLines, clusterCpuUsageToolTipTitle);
    }
//
//    public String validateClusterCpuUsavalidateooltipValue() {
//        return clusterCpuUsageTooltipValue;
//    }

    public void validateClusterRamUsageWidvalidateTitle(String expectedTitle) {
    	String actualTitle = page.locator(clusterRamUsageWidgetTitle).textContent().trim();
        util.ValidateTheTitle(actualTitle, expectedTitle);
    }

    public void validateClusterRamUsageZoomOutBtn() {
        util.graphZoomOut(page, clusterRamUsageZoomInBtn, clusterRamUsageZoomOutBtn, clusterRamUsageResetBtn, allWidgetXPoints());
    }

    public void validateClusterRamUsageZoomInBtn() {
    	page.locator(clusterRamUsageWidgetTitle).first().scrollIntoViewIfNeeded();
        util.graphZoomIn(page, clusterRamUsageZoomInBtn, clusterRamUsageResetBtn, allWidgetXPoints());
    }

    public void validateClusterRamUsageResetBtn() {
        util.graphZoomReset(page, clusterRamUsageZoomInBtn, clusterRamUsageResetBtn, allWidgetXPoints());
    }

//    public void validateClusterRamUsageXaxisLines() {
//        return clusterRamUsageXaxisLines;
//    }

    public void validateClusterRamUsageXaxisTitle(String expectedTitle) {
    	String actualTitle = page.locator(clusterRamUsageXaxisTitle).textContent().trim();
        util.ValidateTheTitle(actualTitle, expectedTitle);
    }

    public void validateClusterRamUsageYaxisTitle(String expectedTitle) {
    	String actualTitle = page.locator(clusterRamUsageYaxisTitle).textContent().trim();
        util.ValidateTheTitle(actualTitle, expectedTitle);;
    }

    public void validateClusterRamUsagetoolTipTitle() {
    	//page.locator(clusterRamUsageWidgetTitle).scrollIntoViewIfNeeded();
        util.validateWidgetToolTips(page, clusterRamUsageXaxisLines, clusterRamUsageToolTipTitle);
    }
    
    public void validateClusterRAMUsageDragDrop() {
    	util.graphZoomInByDragAndDrop(page, clusterRamUsageXaxisLines, clusterRamUsageResetBtn, allWidgetXPoints());
    }
    
    public void validateClusterRAMUsageXaxisValues() {
        util.validateTheGraphdisplayingTheDataAsPerGivenTimeLines(page, clusterRamUsageXaxisValues, calendarValue, allWidgetXValues());
    }

    public void validateDiskUsageCardTitle(String expectedTitle) {
    	String actualTitle = page.locator(diskUsageCardTitle).textContent().trim();
    	Assert.assertEquals(actualTitle.contains(expectedTitle),true);
    }

    public void validateDiskUsageCardNodataText(String expectedTitle) {
    	String actualTitle = page.locator(diskUsageCardNodataText).textContent().trim();
        util.ValidateTheTitle(actualTitle, expectedTitle);
    }

    public void validateDiskUsageApplicationText(String expectedTitle) {
    	String actualTitle = page.locator(diskUsageApplicationText).textContent().trim();
    	Assert.assertEquals(actualTitle.contains(expectedTitle), true);
    }

    
    public void validateTheCustomTimeLine(String period)
	{
		util.validateCustomTimeLine(page,clusterCpuUsageXaxisValues,period,allWidgetXValues());
	}
    
    public void validateTheLegendsColor(Page page, String element ,String expectedColor)
    {
    	String actualColor =  (String) page.locator(element).evaluate("element => getComputedStyle(element).color");
    	//actualColor = actualColor.replace(")", "");
    	Assert.assertEquals(actualColor.contains(expectedColor),true);
    }


	public void validateSelectDatabaseTypeTxt(String expectedTitle) {
		String actualTitle = page.locator(selectDatabaseTypeText).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}
	
	public void validateSelectClusterTxt(String expectedTitle) {
		String actualTitle = page.locator(selectClusterText).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}
    
     
}








