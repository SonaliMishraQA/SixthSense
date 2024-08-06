package objectRepository.DBM;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;

import com.microsoft.playwright.Page;

import genericUtilities.ExcelUtility;
import genericUtilities.GenericMethods;
import genericUtilities.IPathConstant;

public class DBMCouchbaseBucketPage {
	Page page;
	GenericMethods util = new GenericMethods();
	ExcelUtility excel = new ExcelUtility();

    private String bucketTab = "xpath = //div[@class='item']/child::div[contains(@class,'router') and contains(text(),'Bucket')]";
    private String bucketNameText  = "xpath = //div[@class='dropdown']/descendant::div[@class='heading']";
    private String bucketNameDropDown = "#btn-arrow-down-bucket-select";
    private String bucketDropdownTextField = "#input-search-sel-bucket-select";
    private String searchedBucket = "#bucket-select-0-single" ;

    private String bucketOpsWidgetTitle = "xpath = //div[@class='wrapper']/descendant::div[@class='line-title'][position()=1]";
    private String bucketOpsZoomOutBtn = "#Bucket-ops-zoom-out";
    private String bucketOpsZoomInBtn = "#Bucket-ops-zoom-in";
    private String bucketOpsResetBtn= "#Bucket-ops-zoom-reset" ;
    private String bucketOpsXaxisLines = "xpath = //div[@id='apexchartsvuechart-line-0']/ancestor::div[@class='chart-line']/descendant::*[name()='line' and @class='apexcharts-xaxis-tick']";
    private String bucketOpsXaxisValues = "xpath = //div[@id='apexchartsvuechart-line-0']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-label apexcharts-xaxis-label']/child::*[name()='tspan' and contains(text(),'-')]";
    private String bucketOpsXaxisTitle = "xpath = //div[@id='apexchartsvuechart-line-0']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-title-text chart-lables']";
    private String bucketOpsYaxisTitle = "xpath = //div[@id='apexchartsvuechart-line-0']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-yaxis-title-text chart-lables']";
    private String bucketOpsToolTipTitle = "xpath = //div[@id='apexchartsvuechart-line-0']/ancestor::div[@class='chart-box']/descendant::div[@class='apexcharts-tooltip-title']";
    private String bucketOpsTooltipValue = "xpath = //div[@id='apexchartsvuechart-line-0']/ancestor::div[@class='chart-box']/descendant::div[@class='apexcharts-tooltip-text']";

    private String DiskUsedWidgetTitle = "xpath = //div[@class='wrapper']/descendant::div[@class='line-title'][position()=2]";
    private String DiskUsedZoomOutBtn = "#Disk-used-zoom-out";
    private String DiskUsedZoomInBtn = "#Disk-used-zoom-in";
    private String DiskUsedResetBtn = "#Disk-used-zoom-reset";
    private String DiskUsedXaxisLines = "xpath = //div[@id='apexchartsvuechart-line-1']/ancestor::div[@class='chart-line']/descendant::*[name()='line' and @class='apexcharts-xaxis-tick']";
    private String DiskUsedXaxisValues = "xpath = //div[@id='apexchartsvuechart-line-1']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-label apexcharts-xaxis-label']/child::*[name()='tspan' and contains(text(),'-')]";
    private String DiskUsedXaxisTitle = "xpath = //div[@id='apexchartsvuechart-line-1']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-title-text chart-lables']";
    private String DiskUsedYaxisTitle = "xpath = //div[@id='apexchartsvuechart-line-1']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-yaxis-title-text chart-lables']";
    private String DiskUsedToolTipTitle = "xpath = //div[@id='apexchartsvuechart-line-1']/ancestor::div[@class='chart-box']/descendant::div[@class='apexcharts-tooltip-title']";
    private String DiskUsedTooltipValue = "xpath = //div[@id='apexchartsvuechart-line-1']/ancestor::div[@class='chart-box']/descendant::div[@class='apexcharts-tooltip-text']";


    private String memUsedWidgetTitle = "xpath = //div[@class='wrapper']/descendant::div[@class='line-title'][position()=3]";
    private String memUsedZoomOutBtn = "#Mem-used-zoom-out";
    private String memUsedZoomInBtn = "#Mem-used-zoom-in";
    private String memUsedResetBtn = "#Mem-used-zoom-reset";
    private String memUsedXaxisLines = "xpath = //div[@id='apexchartsvuechart-line-2']/ancestor::div[@class='chart-line']/descendant::*[name()='line' and @class='apexcharts-xaxis-tick']";
    private String memUsedXaxisValues = "xpath = //div[@id='apexchartsvuechart-line-2']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-label apexcharts-xaxis-label']/child::*[name()='tspan' and contains(text(),'-')]";
    private String memUsedXaxisTitle = "xpath = //div[@id='apexchartsvuechart-line-2']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-title-text chart-lables']";
    private String memUsedYaxisTitle = "xpath = //div[@id='apexchartsvuechart-line-2']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-yaxis-title-text chart-lables']";
    private String memUsedToolTipTitle = "xpath = //div[@id='apexchartsvuechart-line-2']/ancestor::div[@class='chart-box']/descendant::div[@class='apexcharts-tooltip-title']";
    private String memUsedTooltipValue = "xpath = //div[@id='apexchartsvuechart-line-2']/ancestor::div[@class='chart-box']/descendant::div[@class='apexcharts-tooltip-text']";


    private String currentItemsWidgetTitle = "xpath = //div[@class='wrapper']/descendant::div[@class='line-title'][position()=4]";
    private String currentItemsZoomOutBtn = "#Current-items-zoom-out";
    private String currentItemsZoomInBtn = "#Current-items-zoom-in";
    private String currentItemsResetBtn = "#Current-items-zoom-reset";
    private String currentItemsXaxisLines = "xpath = //div[@id='apexchartsvuechart-line-3']/ancestor::div[@class='chart-line']/descendant::*[name()='line' and @class='apexcharts-xaxis-tick']";
    private String currentItemsXaxisValues = "xpath = //div[@id='apexchartsvuechart-line-3']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-label apexcharts-xaxis-label']/child::*[name()='tspan' and contains(text(),'-')]";
    private String currentItemsXaxisTitle = "xpath = //div[@id='apexchartsvuechart-line-3']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-title-text chart-lables']";
    private String currentItemsYaxisTitle = "xpath = //div[@id='apexchartsvuechart-line-3']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-yaxis-title-text chart-lables']";
    private String currentItemsToolTipTitle = "xpath = //div[@id='apexchartsvuechart-line-3']/ancestor::div[@class='chart-box']/descendant::div[@class='apexcharts-tooltip-title']";
    private String currentItemsTooltipValue = "xpath = //div[@id='apexchartsvuechart-line-3']/ancestor::div[@class='chart-box']/descendant::div[@class='apexcharts-tooltip-text']";


    private String calendarValue = "xpath = //div[@class='selected-text ellipsis bg-text']";
    
    public DBMCouchbaseBucketPage(Page page)
    {
        this.page = page;
    }

    public List<String> allWidgetXPoints(){
    	ArrayList<String> xPoint = new ArrayList<String>();
    	xPoint.add(bucketOpsXaxisLines);
    	xPoint.add(DiskUsedXaxisLines);
    	xPoint.add(memUsedXaxisLines);
    	xPoint.add(currentItemsXaxisLines);
    	return xPoint;
    }
    
    public List<String> allWidgetXValues(){
    	ArrayList<String> xValue = new ArrayList<String>();
    	xValue.add(bucketOpsXaxisValues);
    	xValue.add(DiskUsedXaxisValues);
    	xValue.add(memUsedXaxisValues);
    	xValue.add(currentItemsXaxisValues);
    	return xValue;
    }

    public void navigateToBucketPage() {
        page.waitForSelector(bucketTab);
        page.click(bucketTab);
        page.waitForSelector(bucketNameDropDown);
        Assert.assertTrue(page.locator(bucketNameDropDown).isVisible());
    }
    
    public void validateBucketPageTitle(String expectedTitle) {
    	String actualTitle = page.locator(bucketTab).textContent().trim();
    	util.ValidateTheTitle(actualTitle, expectedTitle);
    }


    public void selectBucketFromDropdown() throws EncryptedDocumentException, IOException {
        String bucket = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.DBMExcelPath, IPathConstant.couchBaseSheet, "Bucket_SelectBucket");
        util.selectTheOptionFromDropDownBySearch(page, bucketNameDropDown, bucketDropdownTextField, bucket, searchedBucket);
    }


    public void validateSelectBucketNameTextField(String expectedTitle) {
        String actualTitle = page.locator(bucketNameText).textContent().trim();
        util.ValidateTheTitle(actualTitle, expectedTitle);
    }

    public void validateBucketOpswidgetTitle(String expectedTitle) {
    	String actualTitle = page.locator(bucketOpsWidgetTitle).textContent().trim();
        util.ValidateTheTitle(actualTitle, expectedTitle);
    }

    public void validateBucketOpsZoomInBtn() {
        util.graphZoomIn(page, bucketOpsZoomInBtn, bucketOpsResetBtn, allWidgetXPoints());
    }

    public void validateBucketOpsZoomOutBtn() {
        util.graphZoomOut(page, bucketOpsZoomInBtn, bucketOpsZoomOutBtn, bucketOpsResetBtn, allWidgetXPoints());
    }

    public void validateBucketOpsResetBtn() {
        util.graphZoomReset(page, bucketOpsZoomInBtn, bucketOpsResetBtn, allWidgetXPoints());
    }

    
    public void validateBucketOpsGraphDragDrop() {
    	util.graphZoomInByDragAndDrop(page, bucketOpsXaxisLines, bucketOpsResetBtn, allWidgetXPoints());
    }
    
    public void validateBucketOpsXaxisValues() {
        util.validateTheGraphdisplayingTheDataAsPerGivenTimeLines(page, bucketOpsXaxisValues, calendarValue, allWidgetXValues());
    }

    public void validateBucketOpsXaxisTitle(String expectedTitle) {
    	String actualTitle = page.locator(bucketOpsXaxisTitle).textContent().trim();
        util.ValidateTheTitle(actualTitle, expectedTitle);
    }

    public void validateBucketOpsYaxisTitle(String expectedTitle) {
    	String actualTitle = page.locator(bucketOpsYaxisTitle).textContent().trim();
        util.ValidateTheTitle(actualTitle, expectedTitle);
    }

    public void validateBucketOpsToolTipTitle() {
    	page.locator(bucketOpsWidgetTitle).scrollIntoViewIfNeeded();
        util.validateWidgetToolTips(page, bucketOpsXaxisLines, bucketOpsToolTipTitle);
    }
    
    public void validateDiskUsedwidgetTitle(String expectedTitle) {
    	String actualTitle = page.locator(DiskUsedWidgetTitle).textContent().trim();
        util.ValidateTheTitle(actualTitle, expectedTitle);
    }

    public void validateDiskUsedZoomInBtn() {
        util.graphZoomIn(page, DiskUsedZoomInBtn, DiskUsedResetBtn, allWidgetXPoints());
    }

    public void validateDiskUsedZoomOutBtn() {
        util.graphZoomOut(page, DiskUsedZoomInBtn, DiskUsedZoomOutBtn, DiskUsedResetBtn, allWidgetXPoints());
    }

    public void validateDiskUsedResetBtn() {
        util.graphZoomReset(page, DiskUsedZoomInBtn, DiskUsedResetBtn, allWidgetXPoints());
    }

    
    public void validateDiskUsedGraphDragDrop() {
    	util.graphZoomInByDragAndDrop(page, DiskUsedXaxisLines, DiskUsedResetBtn, allWidgetXPoints());
    }
    
    public void validateDiskUsedXaxisValues() {
        util.validateTheGraphdisplayingTheDataAsPerGivenTimeLines(page, DiskUsedXaxisLines, calendarValue, allWidgetXValues());
    }

    public void validateDiskUsedXaxisTitle(String expectedTitle) {
    	String actualTitle = page.locator(DiskUsedXaxisTitle).textContent().trim();
        util.ValidateTheTitle(actualTitle, expectedTitle);
    }

    public void validateDiskUsedYaxisTitle(String expectedTitle) {
    	String actualTitle = page.locator(DiskUsedYaxisTitle).textContent().trim();
        util.ValidateTheTitle(actualTitle, expectedTitle);
    }

    public void validateDiskUsedToolTipTitle() {
    	page.locator(DiskUsedWidgetTitle).scrollIntoViewIfNeeded();
        util.validateWidgetToolTips(page, DiskUsedXaxisLines, DiskUsedToolTipTitle);
    }
    
    public void validateMemUsedwidgetTitle(String expectedTitle) {
    	String actualTitle = page.locator(memUsedWidgetTitle).textContent().trim();
        util.ValidateTheTitle(actualTitle, expectedTitle);
    }

    public void validateMemUsedZoomInBtn() {
        util.graphZoomIn(page, memUsedZoomInBtn, memUsedResetBtn, allWidgetXPoints());
    }

    public void validateMemUsedZoomOutBtn() {
        util.graphZoomOut(page, memUsedZoomInBtn, memUsedZoomOutBtn, memUsedResetBtn, allWidgetXPoints());
    }

    public void validateMemUsedResetBtn() {
        util.graphZoomReset(page, memUsedZoomInBtn, memUsedResetBtn, allWidgetXPoints());
    }

    
    public void validateMemUsedGraphDragDrop() {
    	page.locator(DiskUsedWidgetTitle).scrollIntoViewIfNeeded();
    	util.graphZoomInByDragAndDrop(page, memUsedXaxisLines, memUsedResetBtn, allWidgetXPoints());
    }
    
    public void validateMemUsedXaxisValues() {
        util.validateTheGraphdisplayingTheDataAsPerGivenTimeLines(page, memUsedXaxisValues, calendarValue, allWidgetXValues());
    }

    public void validateMemUsedXaxisTitle(String expectedTitle) {
    	String actualTitle = page.locator(memUsedXaxisTitle).textContent().trim();
        util.ValidateTheTitle(actualTitle, expectedTitle);
    }

    public void validateMemUsedYaxisTitle(String expectedTitle) {
    	String actualTitle = page.locator(memUsedYaxisTitle).textContent().trim();
        util.ValidateTheTitle(actualTitle, expectedTitle);
    }

    public void validateMemUsedToolTipTitle() {
        util.validateWidgetToolTips(page, memUsedXaxisLines, memUsedToolTipTitle);
    }
    
    public void validateCurrentItemswidgetTitle(String expectedTitle) {
    	String actualTitle = page.locator(currentItemsWidgetTitle).textContent().trim();
        util.ValidateTheTitle(actualTitle, expectedTitle);
    }

    public void validateCurrentItemsZoomInBtn() {
        util.graphZoomIn(page, currentItemsZoomInBtn, currentItemsResetBtn, allWidgetXPoints());
    }

    public void validateCurrentItemsZoomOutBtn() {
        util.graphZoomOut(page, currentItemsZoomInBtn, currentItemsZoomOutBtn, currentItemsResetBtn, allWidgetXPoints());
    }

    public void validateCurrentItemsResetBtn() {
        util.graphZoomReset(page, currentItemsZoomInBtn, currentItemsResetBtn, allWidgetXPoints());
    }

    
    public void validateCurrentItemsGraphDragDrop() {
    	util.graphZoomInByDragAndDrop(page, currentItemsXaxisLines, currentItemsResetBtn, allWidgetXPoints());
    }
    
    public void validateCurrentItemsXaxisValues() {
        util.validateTheGraphdisplayingTheDataAsPerGivenTimeLines(page, currentItemsXaxisValues, calendarValue, allWidgetXValues());
    }

    public void validateCurrentItemsXaxisTitle(String expectedTitle) {
    	String actualTitle = page.locator(currentItemsXaxisTitle).textContent().trim();
        util.ValidateTheTitle(actualTitle, expectedTitle);
    }

    public void validateCurrentItemsYaxisTitle(String expectedTitle) {
    	String actualTitle = page.locator(currentItemsYaxisTitle).textContent().trim();
        util.ValidateTheTitle(actualTitle, expectedTitle);
    }

    public void validateCurrentItemsToolTipTitle() {
    	page.locator(currentItemsWidgetTitle).scrollIntoViewIfNeeded();
        util.validateWidgetToolTips(page, currentItemsXaxisLines, currentItemsToolTipTitle);
    }
    
    public void validateTheCustomTimeLine(String period)
	{
		util.validateCustomTimeLine(page,bucketOpsXaxisValues,period,allWidgetXValues());
	}
    

}   