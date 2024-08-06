package objectRepository.DBM;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import genericUtilities.GenericMethods;
import objectRepository.CommonPage;

public class MysqlHardwarePage {
    Page page;
    GenericMethods util=new GenericMethods();
    CommonPage comPage = new CommonPage(page);

    private String hardwareInfoText = "xpath = //div[@class='router activeRouter']";
    private String clusterInfoText = "xpath = //div[@class='wrapper-card-elements border-container cluster-info']";
    private String typeOfOs = "xpath = //div[@class='wrapper-card-elements border-container']/descendant::div[@class='card-element'][position()=1]/descendant::div[@class='textLabel']";
    private String Architecture = "xpath = //div[@class='wrapper-card-elements border-container']/descendant::div[@class='card-element'][position()=2]/descendant::div[@class='textLabel']";
    private String hostName = "xpath = //div[@class='wrapper-card-elements border-container']/descendant::div[@class='card-element'][position()=3]/descendant::div[@class='textLabel']";
    private String availability="xpath =//div[@class='wrapper-card-elements border-container']/descendant::div[@class='card-element'][position()=4]/descendant::div[@class='textLabel']";
    private String averageCpuUsage="xpath=//div[@class='wrapper-card-elements border-container']/descendant::div[@class='card-element'][position()=5]/descendant::div[@class='textLabel']";
    private String averageMemoryUsage ="xpath=//div[@class='wrapper-card-elements border-container']/descendant::div[@class='card-element'][position()=6]/descendant::div[@class='textLabel']";

    private String typeOfOsValue="xpath=//div[@class='wrapper-card-elements border-container']/descendant::div[@class='card-element'][position()=1]/descendant::div[@class='textLabel']/preceding-sibling::div[@class='textVal fair']";
    private String ArchitectureValue="xpath=//div[@class='wrapper-card-elements border-container']/descendant::div[@class='card-element'][position()=2]/descendant::div[@class='textLabel']/preceding-sibling::div[@class='textVal fair']";
    private String hostNameValue="xpath=//div[@class='wrapper-card-elements border-container']/descendant::div[@class='card-element'][position()=3]/descendant::div[@class='textLabel']/preceding-sibling::div[@class='textVal fair']";
    private String availabilityValue="xpath=//div[@class='wrapper-card-elements border-container']/descendant::div[@class='card-element'][position()=4]/descendant::div[@class='textLabel']/preceding-sibling::div[@class='textVal good']";
    private String averageCpuUsageValue="xpath=//div[@class='wrapper-card-elements border-container']/descendant::div[@class='card-element'][position()=5]/descendant::div[@class='textLabel']/preceding-sibling::div[@class='textVal fair']";

    private String loadAverage="xpath=//div[@class='wrapper-card-elements border-container cluster-info']/descendant::div[@class='card-element'][position()=1]/descendant::div[@class='textLabel']";
    private String host="xpath=//div[@class='wrapper-card-elements border-container cluster-info']/descendant::div[@class='card-element'][position()=2]/descendant::div[@class='textLabel']";
    private String port="xpath=//div[@class='wrapper-card-elements border-container cluster-info']/descendant::div[@class='card-element'][position()=3]/descendant::div[@class='textLabel']";
    private String role="xpath=//div[@class='wrapper-card-elements border-container cluster-info']/descendant::div[@class='card-element'][position()=4]/descendant::div[@class='textLabel']";
    private String status="xpath=//div[@class='wrapper-card-elements border-container cluster-info']/descendant::div[@class='card-element'][position()=5]/descendant::div[@class='textLabel']";

    private String loadAverageValue="xpath=//div[@class='wrapper-card-elements border-container cluster-info']/descendant::div[@class='card-element'][position()=1]/descendant::div[@class='textLabel']/preceding-sibling::div";
    private String hostValue="xpath=//div[@class='wrapper-card-elements border-container cluster-info']/descendant::div[@class='card-element'][position()=2]/descendant::div[@class='textLabel']/preceding-sibling::div";
    private String portValue="xpath=//div[@class='wrapper-card-elements border-container cluster-info']/descendant::div[@class='card-element'][position()=3]/descendant::div[@class='textLabel']/preceding-sibling::div";
    private String roleValue="xpath=//div[@class='wrapper-card-elements border-container cluster-info']/descendant::div[@class='card-element'][position()=4]/descendant::div[@class='textLabel']/preceding-sibling::div";
    private String statusValue="xpath=//div[@class='wrapper-card-elements border-container cluster-info']/descendant::div[@class='card-element'][position()=5]/descendant::div[@class='textLabel']/preceding-sibling::div";

    private String hostDiskUsage="xpath=//div[@class='card-header']";
    private String noDataText="xpath=//div[@class='inner-text']";
    private String endpoint="xpath=//div[@class='progress-header-content-identifier']";
    private String storagedUsed="xpath=//div[@class='progress-header-content']/descendant::div[@class='progress-info-content-identifier'][position()=1]";
    private String storagedUsedValue="xpath=//div[@class='progress-header-content']/descendant::div[@class='progress-info-content-identifier'][position()=1]/preceding-sibling::div";
    private String storageAvailable="xpath=//div[@class='progress-header-content']/descendant::div[@class='progress-info-content-identifier'][position()=2]";
    private String storageAvailableValue="xpath=//div[@class='progress-header-content']/descendant::div[@class='progress-info-content-identifier'][position()=2]/preceding-sibling::div";


    private String cpuUsageWidvalidateTitle="xpath=//div[@class='wrapper']/descendant::div[@class='line-title'][position()=1]";
    private String cpuUsageZoomOutBtn="#CPU-usage-zoom-out";
    private String cpuUsageZoomInBtn= "#CPU-usage-zoom-in";
    private String cpuUsageResetBtn="#CPU-usage-zoom-reset";
    private String cpuUsageXaxisLines ="xpath=//div[@id='apexchartsvuechart-line-0']/ancestor::div[@class='chart-line']/descendant::*[name()='line' and @class='apexcharts-xaxis-tick']";
    private String cpuUsageXaxisValues="xpath=//div[@id='apexchartsvuechart-line-0']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-label apexcharts-xaxis-label']/child::*[name()='tspan' and contains(text(),'-')]";

    private String cpuUsageXaxisTitle="xpath=//div[@id='apexchartsvuechart-line-0']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-title-text chart-lables']";
    private String cpuUsageYaxisTitle="xpath=//div[@id='apexchartsvuechart-line-0']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-yaxis-title-text chart-lables']";
    private String cpuUsavalidateoolTipTitle ="xpath=//div[@id='apexchartsvuechart-line-0']/ancestor::div[@class='chart-box']/descendant::div[@class='apexcharts-tooltip-title']";
    private String cpuUsavalidateooltipValue="xpath=//div[@id='apexchartsvuechart-line-0']/ancestor::div[@class='chart-box']/descendant::div[@class='apexcharts-tooltip-text']";


    private String memoryUsageWidvalidateTitle="xpath=//div[@class='wrapper']/descendant::div[@class='line-title'][position()=2]";
    private String memoryUsageZoomOutBtn= "#Memory-usage-zoom-out";
    private String memoryUsageZoomInBtn="#Memory-usage-zoom-in";
    private String memoryUsageResetBtn= "#Memory-usage-zoom-reset";
    private String memoryUsageXaxisLines="xpath=//div[@id='apexchartsvuechart-line-1']/ancestor::div[@class='chart-line']/descendant::*[name()='line' and @class='apexcharts-xaxis-tick']";
    private String memoryUsageXaxisValues="xpath=//div[@id='apexchartsvuechart-line-1']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-label apexcharts-xaxis-label']/child::*[name()='tspan' and contains(text(),'-')]";
    private String memoryUsageXaxisTitle="xpath=//div[@id='apexchartsvuechart-line-1']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-title-text chart-lables']";
    private String memoryUsageYaxisTitle="xpath=//div[@id='apexchartsvuechart-line-1']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-yaxis-title-text chart-lables']";
    private String memoryUsageToolTipTitle="xpath=//div[@id='apexchartsvuechart-line-1']/ancestor::div[@class='chart-box']/descendant::div[@class='apexcharts-tooltip-title']";
    private String memoryUsavalidateooltipValue="xpath=//div[@id='apexchartsvuechart-line-1']/ancestor::div[@class='chart-box']/descendant::div[@class='apexcharts-tooltip-text']";

    private String networkIOWidvalidateTitle="xpath=//div[@class='wrapper']/descendant::div[@class='line-title'][position()=3]";
    private String networkIOZoomOut="//span[@id='Network-I/O-zoom-out']";
    private String networkIOZoomIn = "//span[@id='Network-I/O-zoom-in']";
    private String networkIOReset = "//span[@id='Network-I/O-zoom-reset']";
    private String networkIOXaxisLines ="xpath=//div[@id='apexchartsvuechart-line-2']/ancestor::div[@class='chart-line']/descendant::*[name()='line' and @class='apexcharts-xaxis-tick']";
    private String networkIOXaxisValues="xpath=//div[@id='apexchartsvuechart-line-2']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-label apexcharts-xaxis-label']/child::*[name()='tspan' and contains(text(),'-')]";
    private String networkIOXaxisTitle="xpath=//div[@id='apexchartsvuechart-line-2']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-title-text chart-lables']";
    private String networkIOYaxisTitle="xpath=//div[@id='apexchartsvuechart-line-2']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-yaxis-title-text chart-lables']";
    private String networkIOToolTipTitle="xpath=//div[@id='apexchartsvuechart-line-2']/ancestor::div[@class='chart-box']/descendant::div[@class='apexcharts-tooltip-title']";
    private String networkIOToolTipLabelList="xpath=//div[@id='apexchartsvuechart-line-0']/ancestor::div[@class='chart-box']/descendant::span[@class='apexcharts-tooltip-marker' and not(contains(@style,'none;'))]/parent::div[@class='apexcharts-tooltip-series-group apexcharts-active' and not(contains(@style,'none;'))]/descendant::span[@class='apexcharts-tooltip-text-y-label']";
    private String networkIOApexVisibleSeries="xpath=//div[@id='apexchartsvuechart-line-2']/ancestor::div[@class='chart-box']/descendant::*[name()='g' and @class='apexcharts-series']/descendant::*[name()='circle'][position()=1]";
    private String networkIOApexSeries="xpath=//div[@id='apexchartsvuechart-line-2']/ancestor::div[@class='chart-box']/descendant::*[name()='g' and @class='apexcharts-series-markers-wrap apexcharts-hidden-element-shown']/descendant::*[name()='circle'][position()=1]";

    private String networkIOToolTipValueList ="xpath=//div[@id='apexchartsvuechart-line-2']/ancestor::div[@class='chart-box']/descendant::span[@class='apexcharts-tooltip-marker' and not(contains(@style,'none;'))]/parent::div[@class='apexcharts-tooltip-series-group apexcharts-active' and not(contains(@style,'none;'))]/descendant::span[@class='apexcharts-tooltip-text-y-value']";
    private String networkIOWidvalidateLegendsList="xpath=//div[@id='apexchartsvuechart-line-2']/ancestor::div[@class='chart-line']/descendant::span[@class='apexcharts-legend-text']";
    private String networkIOWidvalidateLegendsColorList="xpath=//div[@id='apexchartsvuechart-line-2']/ancestor::div[@class='chart-line']/descendant::span[contains(@class,'apexcharts-legend-marker')]";
    private String networkIOWidvalidateActiveLegendsList="xpath=//div[@id='apexchartsvuechart-line-2']/ancestor::div[@class='chart-line']/descendant::div[@class='apexcharts-legend-series']/child::span[@class='apexcharts-legend-text']";
    private String netwrokIOWidgetLegendsLineList = "xpath = //div[@id='apexchartsvuechart-line-2']//*[name()='g' and @class='apexcharts-series']/*[name()='path']";
    private String networkIOWidgetsLegendsToolTipColorList = "xpath = //div[@id='apexchartsvuechart-line-2']/descendant::div[@class='apexcharts-tooltip apexcharts-theme-dark apexcharts-active']/descendant::span[@class='apexcharts-tooltip-marker']";
    private String networkIOWidvalidateActiveLegendsColorList="xpath=//div[@id='apexchartsvuechart-line-2']/ancestor::div[@class='chart-line']/descendant::div[@class='apexcharts-legend-series']/child::span[@class='apexcharts-legend-marker']";
    private String networkIOwidgetLegendsActiveToolTipText = "xpath = //div[@id='apexchartsvuechart-line-2']/descendant::div[@class='apexcharts-tooltip-series-group apexcharts-active' and contains(@style,'display: flex') ]/descendant::div[@class='apexcharts-tooltip-y-group']/descendant::span[@class='apexcharts-tooltip-text-y-label']";
    
    private String totalReadAndWriteWidvalidateTitle="xpath=//div[@class='wrapper']/descendant::div[@class='line-title'][position()=4]";
    private String totalReadAndWriteZoomOut= "//span[@id='Total-read-&-write-zoom-out']";
    private String totalReadAndWriteZoomIn ="//span[@id='Total-read-&-write-zoom-in']";
    private String totalReadAndWriteReset ="//span[@id='Total-read-&-write-zoom-reset']";
    private String totalReadAndWriteXaxisLines="xpath=//div[@id='apexchartsvuechart-line-3']/ancestor::div[@class='chart-line']/descendant::*[name()='line' and @class='apexcharts-xaxis-tick']";

    private String totalReadAndWriteXaxisValues="xpath=//div[@id='apexchartsvuechart-line-3']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-label apexcharts-xaxis-label']/child::*[name()='tspan' and contains(text(),'-')]";
    private String totalReadAndWriteXaxisTitle="xpath=//div[@id='apexchartsvuechart-line-3']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-title-text chart-lables']";
    private String totalReadAndWriteYaxisTitle="xpath=//div[@id='apexchartsvuechart-line-3']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-yaxis-title-text chart-lables']";
    private String totalReadAndWriteToolTipTitle="xpath=//div[@id='apexchartsvuechart-line-3']/ancestor::div[@class='chart-box']/descendant::div[@class='apexcharts-tooltip-title']";
    private String totalReadAndWriteToolTipLabelList="xpath=//div[@id='apexchartsvuechart-line-3']/ancestor::div[@class='chart-box']/descendant::span[@class='apexcharts-tooltip-marker' and not(contains(@style,'none;'))]/parent::div[@class='apexcharts-tooltip-series-group apexcharts-active' and not(contains(@style,'none;'))]/descendant::span[@class='apexcharts-tooltip-text-y-label']";
    private String totalReadAndWriteApexVisibleSeries="xpath=//div[@id='apexchartsvuechart-line-3']/ancestor::div[@class='chart-box']/descendant::*[name()='g' and @class='apexcharts-series']/descendant::*[name()='circle'][position()=1]";
    private String totalReadAndWriteApexSeries="xpath=//div[@id='apexchartsvuechart-line-3']/ancestor::div[@class='chart-box']/descendant::*[name()='g' and @class='apexcharts-series-markers-wrap apexcharts-hidden-element-shown']/descendant::*[name()='circle'][position()=1]";
    private String totalReadAndWriteToolTipValueList="xpath=//div[@id='apexchartsvuechart-line-3']/ancestor::div[@class='chart-box']/descendant::span[@class='apexcharts-tooltip-marker' and not(contains(@style,'none;'))]/parent::div[@class='apexcharts-tooltip-series-group apexcharts-active' and not(contains(@style,'none;'))]/descendant::span[@class='apexcharts-tooltip-text-y-value']";
    private String totalReadAndWriteWidvalidateLegendsList="xpath=//div[@id='apexchartsvuechart-line-3']/ancestor::div[@class='chart-line']/descendant::span[@class='apexcharts-legend-text']";
    private String totalReadAndWriteWidvalidateLegendsColorList="xpath=//div[@id='apexchartsvuechart-line-3']/ancestor::div[@class='chart-line']/descendant::span[contains(@class,'apexcharts-legend-marker')]";
    private String totalReadAndWriteWidgetLegendsLineList = "xpath = //div[@id='apexchartsvuechart-line-3']//*[name()='g' and @class='apexcharts-series']/*[name()='path']";
    private String totalReadAndWriteWidgetsLegendsToolTipColorList = "xpath = //div[@id='apexchartsvuechart-line-3']/descendant::div[@class='apexcharts-tooltip apexcharts-theme-dark apexcharts-active']/descendant::span[@class='apexcharts-tooltip-marker']";
    private String totalReadAndWriteWidvalidateActiveLegendsColorList="xpath=//div[@id='apexchartsvuechart-line-3']/ancestor::div[@class='chart-line']/descendant::div[@class='apexcharts-legend-series']/child::span[@class='apexcharts-legend-marker']";
    private String totalReadAndWritewidgetLegendsActiveToolTipText = "xpath =  //div[@id='apexchartsvuechart-line-3']/descendant::div[@class='apexcharts-tooltip-series-group apexcharts-active' and contains(@style,'display: flex') ]/descendant::div[@class='apexcharts-tooltip-y-group']/descendant::span[@class='apexcharts-tooltip-text-y-label' and contains(text(),'meter_io_total_reads')]";
    
    private String totalBytesWrittenAndReadWidvalidateTitle="xpath=//div[@class='wrapper']/descendant::div[@class='line-title'][position()=5]";
    private String totalBytesWrittenAndReadZoomOut = "//span[@id='Total-bytes-written-&-read-zoom-out']";
    private String totalBytesWrittenAndReadZoomIn= "//span[@id='Total-bytes-written-&-read-zoom-in']";
    private String totalBytesWrittenAndReadReset= "//span[@id='Total-bytes-written-&-read-zoom-reset']";
    private String totalBytesWrittenAndReadXaxisLines="xpath=//div[@id='apexchartsvuechart-line-4']/ancestor::div[@class='chart-line']/descendant::*[name()='line' and @class='apexcharts-xaxis-tick']";
    private String totalBytesWrittenAndReadXaxisValues="xpath=//div[@id='apexchartsvuechart-line-4']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-label apexcharts-xaxis-label']/child::*[name()='tspan' and contains(text(),'-')]";
    private String totalBytesWrittenAndReadXaxisTitle="xpath=//div[@id='apexchartsvuechart-line-4']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-title-text chart-lables']";
    private String totalBytesWrittenAndReadYaxisTitle="xpath=//div[@id='apexchartsvuechart-line-4']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-yaxis-title-text chart-lables']";
    private String totalBytesWrittenAndReadToolTipTitle="xpath=//div[@id='apexchartsvuechart-line-4']/ancestor::div[@class='chart-box']/descendant::div[@class='apexcharts-tooltip-title']";
    private String totalBytesWrittenAndReadToolTipLabelList="xpath=//div[@id='apexchartsvuechart-line-4']/ancestor::div[@class='chart-box']/descendant::span[@class='apexcharts-tooltip-marker' and not(contains(@style,'none;'))]/parent::div[@class='apexcharts-tooltip-series-group apexcharts-active' and not(contains(@style,'none;'))]/descendant::span[@class='apexcharts-tooltip-text-y-label']";
    private String totalBytesWrittenAndReadApexVisibleSeries="xpath=//div[@id='apexchartsvuechart-line-4']/ancestor::div[@class='chart-box']/descendant::*[name()='g' and @class='apexcharts-series']/descendant::*[name()='circle'][position()=1]";
    private String totalBytesWrittenAndReadApexSeries="xpath=//div[@id='apexchartsvuechart-line-4']/ancestor::div[@class='chart-box']/descendant::*[name()='g' and @class='apexcharts-series-markers-wrap apexcharts-hidden-element-shown']/descendant::*[name()='circle'][position()=1]";
    private String totalBytesWrittenAndReadToolTipValueList="xpath=//div[@id='apexchartsvuechart-line-4']/ancestor::div[@class='chart-box']/descendant::span[@class='apexcharts-tooltip-marker' and not(contains(@style,'none;'))]/parent::div[@class='apexcharts-tooltip-series-group apexcharts-active' and not(contains(@style,'none;'))]/descendant::span[@class='apexcharts-tooltip-text-y-value']";
    private String totalBytesWrittenAndReadWidvalidateLegendsList="xpath=//div[@id='apexchartsvuechart-line-4']/ancestor::div[@class='chart-line']/descendant::span[@class='apexcharts-legend-text']";
    private String totalBytesWrittenAndReadWidvalidateLegendsColorList="xpath=//div[@id='apexchartsvuechart-line-4']/ancestor::div[@class='chart-line']/descendant::span[contains(@class,'apexcharts-legend-marker')]";
    private String totalBytesWrittenAndReadWidvalidateActiveLegendsList="xpath=//div[@id='apexchartsvuechart-line-4']/ancestor::div[@class='chart-line']/descendant::div[@class='apexcharts-legend-series']/child::span[@class='apexcharts-legend-text']";
    private String totalBytesWrittenAndReadWidvalidateActiveLegendsColorList="xpath=//div[@id='apexchartsvuechart-line-4']/ancestor::div[@class='chart-line']/descendant::div[@class='apexcharts-legend-series']/child::span[@class='apexcharts-legend-marker']";
    private String totalBytesWrittenAndReadWidgetLegendsLineList = "xpath = //div[@id='apexchartsvuechart-line-4']//*[name()='g' and @class='apexcharts-series']/*[name()='path']";
    private String totalBytesWrittenAndReadWidgetsLegendsToolTipColorList = "xpath = //div[@id='apexchartsvuechart-line-4']/descendant::div[@class='apexcharts-tooltip apexcharts-theme-dark apexcharts-active']/descendant::span[@class='apexcharts-tooltip-marker']";
    private String totalBytesWrittenAndReadwidgetLegendsActiveToolTipText = "xpath = //div[@id='apexchartsvuechart-line-4']/descendant::div[@class='apexcharts-tooltip-series-group apexcharts-active' and contains(@style,'display: flex') ]/descendant::div[@class='apexcharts-tooltip-y-group']/descendant::span[@class='apexcharts-tooltip-text-y-label']";
    
    private String calanderValue = "xpath = //div[@class='selected-text ellipsis bg-text']";
    private String averageMemoryUsageValue = "xpath = //div[@class='wrapper-card-elements border-container']/descendant::div[@class='card-element'][position()=6]/descendant::div[@class='textLabel']/preceding-sibling::div[@class='textVal fair']" ;
    
    
    public MysqlHardwarePage(Page page)
    {
        this.page= page;
    }
    
    public List<String> allWidvalidateXPoints()
    {
    	 ArrayList<String> xPoint = new ArrayList<String>();
    	 xPoint.add(networkIOXaxisLines);
    	 xPoint.add(memoryUsageXaxisLines);
    	 xPoint.add(cpuUsageXaxisLines);
    	 xPoint.add(totalReadAndWriteXaxisLines);
    	 xPoint.add(totalBytesWrittenAndReadXaxisLines);
    	 return xPoint;
    }

    public List<String> allWidvalidateXValues()
    {
    	 ArrayList<String> xValue = new ArrayList<String>();
    	 xValue.add(cpuUsageXaxisValues);
    	 xValue.add(memoryUsageXaxisValues);
    	 xValue.add(networkIOXaxisValues);
    	 xValue.add(totalBytesWrittenAndReadXaxisValues);
    	 xValue.add(totalReadAndWriteXaxisValues);
    	 return xValue;
    }

  //validating the Hardware tab
    public void validateHardWareTabIsSelectedByDefault() {
    	
    	page.waitForSelector(hardwareInfoText);
    	Locator title= page.locator(hardwareInfoText);
    	Assert.assertTrue(title.isVisible());
    }
    
    
    
    public void validateTypeOfOsLegend(String expectedText) {
    	page.waitForSelector(typeOfOs);
    	Locator legend= page.locator(typeOfOs);
    	Assert.assertTrue(legend.isVisible());
        String text = page.locator(typeOfOs).textContent().trim();
        Assert.assertEquals(text, expectedText);
        
    }

    public void validateHostNameLegend(String expectedText) {
    	page.waitForSelector(hostName);
    	Locator legend= page.locator(hostName);
    	Assert.assertTrue(legend.isVisible());
        String text = page.locator(hostName).textContent().trim();
    	Assert.assertEquals(text, expectedText);
    }

    public void validateArchitecture(String expectedText) {
    	page.waitForSelector(Architecture);
    	Locator legend= page.locator(Architecture);
    	Assert.assertTrue(legend.isVisible());
    	String text = page.locator(Architecture).textContent().trim();
    	Assert.assertEquals(text, expectedText);
    	
    }

    public void validateAvailabilityLegend(String expectedText) {
    	page.waitForSelector(availability);
    	Locator legend= page.locator(availability);
    	Assert.assertTrue(legend.isVisible());
    	String text = page.locator(availability).textContent().trim();
    	Assert.assertEquals(text, expectedText);
    	
    	
    }

    public void validateAverageCpuUsageLegend(String expectedText) {
    	page.waitForSelector(averageCpuUsage);
    	Locator legend= page.locator(averageCpuUsage);
    	Assert.assertTrue(legend.isVisible());
    	String text = page.locator(averageCpuUsage).textContent().trim();
    	Assert.assertEquals(text, expectedText);
    	
    }

    public void validateAverageMemoryUsageLegend(String expectedText) {
    	page.waitForSelector(averageMemoryUsage);
    	Locator legend= page.locator(averageMemoryUsage);
    	Assert.assertTrue(legend.isVisible());
    	String text = page.locator(averageMemoryUsage).textContent().trim();
    	Assert.assertEquals(text, expectedText);
    	
    }

    public void validatingOSTypeWhenNoData(String expectedValue) {
    	String value = page.locator(typeOfOsValue).textContent().trim();
    	Assert.assertEquals(value, expectedValue);
    }


    public void validatingArchitectureValueWhenNoData(String expectedValue) {
    	String value = page.locator(ArchitectureValue).textContent().trim();
    	Assert.assertEquals(value, expectedValue);
    }

    public void validatingHostnameValueWhenNoData(String expectedValue) {
        String value = page.locator(hostNameValue).textContent().trim();
    	Assert.assertEquals(value, expectedValue);
    }

    public void validatingAvailabilityValueWhenNoData(String expectedValue) {
    	String value = page.locator(availabilityValue).textContent().trim();
    	Assert.assertEquals(value, expectedValue);
    }

    public void validatingAverageCpuUsageValueWhenNoData(String expectedValue) {
        String value = page.locator(averageCpuUsageValue).textContent().trim();
    	Assert.assertEquals(value, expectedValue);
    }

    public void validatingAverageMemoryUsageValueWhenNoData(String expectedValue) {
        String value = page.locator(averageMemoryUsageValue).textContent().trim();
    	Assert.assertEquals(value, expectedValue);
    }

    public void validateTheInactiveAvailabilityStatus(String expectedStatus) {
    	String actualStatus = page.locator(availabilityValue).textContent().trim();
    	Assert.assertEquals(actualStatus, expectedStatus);
    }

    public void validateTheActiveAvailabilityStatus(String expectedStatus) {
    	String actualStatus = page.locator(availabilityValue).textContent().trim();
    	Assert.assertEquals(actualStatus, expectedStatus);
    	
    }

    public void validateLoadAverage(String expectedText) {
    	page.waitForSelector(loadAverage);
    	Locator legend= page.locator(loadAverage);
    	Assert.assertTrue(legend.isVisible());
    	String text = page.locator(loadAverage).textContent().trim();
    	Assert.assertEquals(text, expectedText);
    	
    }
    
    public void validateHost(String expectedText) {
    	page.waitForSelector(host);
    	Locator legend= page.locator(host);
    	Assert.assertTrue(legend.isVisible());
    	String text = page.locator(host).textContent().trim();
    	Assert.assertEquals(text, expectedText);
    	
    }
    
    public void validatePort(String expectedText) {
    	page.waitForSelector(port);
    	Locator legend= page.locator(port);
    	Assert.assertTrue(legend.isVisible());
    	String text = page.locator(port).textContent().trim();
    	Assert.assertEquals(text, expectedText);
    	
    }
    
    public void validateRole(String expectedText) {
    	page.waitForSelector(role);
    	Locator legend= page.locator(role);
    	Assert.assertTrue(legend.isVisible());
    	String text = page.locator(role).textContent().trim();
    	Assert.assertEquals(text, expectedText);
    	
    }
    
    public void validateStatus(String expectedText) {
    	page.waitForSelector(status);
    	Locator legend= page.locator(status);
    	Assert.assertTrue(legend.isVisible());
    	String text = page.locator(status).textContent().trim();
    	Assert.assertEquals(text, expectedText);
    	
    }
    
    public void validateHostValue(String expectedStatus) {
    	String actualStatus = page.locator(hostValue).textContent().trim();
    	Assert.assertEquals(actualStatus, expectedStatus);
    	
    }
    public void validatePortValue(String expectedStatus) {
    	String actualStatus = page.locator(portValue).textContent().trim();
    	Assert.assertEquals(actualStatus, expectedStatus);
    	
    }
    public void validateRoleValue(String expectedStatus) {
    	String actualStatus = page.locator(roleValue).textContent().trim();
    	Assert.assertEquals(actualStatus, expectedStatus);
    	
    }
    public void validateStatusValue(String expectedStatus) {
    	String actualStatus = page.locator(statusValue).textContent().trim();
    	Assert.assertEquals(actualStatus, expectedStatus);
    	
    }
    public void validateLoadAverageValue(String expectedStatus) {
    	String actualStatus = page.locator(loadAverageValue).textContent().trim();
    	Assert.assertEquals(actualStatus, expectedStatus);
    	
    }

    public void validateHostDiskUsageCardTitle(String expectedText) {
        page.waitForSelector(hostDiskUsage);
    	Locator legend= page.locator(hostDiskUsage);
    	Assert.assertTrue(legend.isVisible());
    	String text = page.locator(hostDiskUsage).textContent().trim();
    	Assert.assertEquals(text, expectedText);
    }

    public void validateDiskUsageCardNodataText(String expectedValue) {
        String actualStatus = page.locator(noDataText).innerText().trim();
    	Assert.assertEquals(actualStatus, expectedValue);
    }
    
    public void validateCpuUsageWidvalidateTitle(String expectedText) {
        page.waitForSelector(cpuUsageWidvalidateTitle);
    	Locator legend= page.locator(cpuUsageWidvalidateTitle);
    	Assert.assertTrue(legend.isVisible());
    	String text = page.locator(cpuUsageWidvalidateTitle).textContent().trim();
    	Assert.assertEquals(text, expectedText);
    }

    public void validateCpuUsageZoomOutBtn() {
       util.graphZoomOut(page, cpuUsageZoomInBtn, cpuUsageZoomOutBtn, cpuUsageResetBtn,allWidvalidateXPoints());
    }

    public void validateCpuUsageZoomInBtn() {
        util.graphZoomIn(page, cpuUsageZoomInBtn, cpuUsageResetBtn, allWidvalidateXPoints());
    }

    public void validateCpuUsageResetBtn() {
        util.graphZoomReset(page, cpuUsageZoomInBtn, cpuUsageResetBtn, allWidvalidateXPoints());
    }
    public void validateCpuUsageDragdrop() {
    	util.graphZoomInByDragAndDrop(page, cpuUsageXaxisLines, cpuUsageResetBtn, allWidvalidateXPoints());
    }

    public void validateCpuUsageXaxisTitle(String expectedTitle) {
        util.ValidateTheTitle( page.locator(cpuUsageXaxisTitle).textContent().trim(), expectedTitle);
    }

    public void validateCpuUsageYaxisTitle(String expectedTitle) {
    	util.ValidateTheTitle(page.locator(cpuUsageYaxisTitle).textContent().trim(), expectedTitle);
    }

    public void validateCpuUsavalidateoolTipTitle() {
       util.validateWidgetToolTips(page, cpuUsageXaxisLines, cpuUsavalidateoolTipTitle);
    }
    
    public void validateMemoryUsageWidgetTitle(String expectedText) {
        page.waitForSelector(memoryUsageWidvalidateTitle);
    	Locator legend= page.locator(memoryUsageWidvalidateTitle);
    	Assert.assertTrue(legend.isVisible());
    	String text = page.locator(memoryUsageWidvalidateTitle).textContent().trim();
    	Assert.assertEquals(text, expectedText);
    }

    public void validateMemoryUsageZoomOutBtn() {
        util.graphZoomOut(page, memoryUsageZoomInBtn, memoryUsageZoomOutBtn, memoryUsageResetBtn, allWidvalidateXPoints());
    }

    public void validatetMemoryUsageZoomInBtn() {
        util.graphZoomIn(page, memoryUsageZoomInBtn, memoryUsageResetBtn,allWidvalidateXPoints());
    }

    public void validateMemoryUsageResetBtn() {
        util.graphZoomReset(page, memoryUsageZoomInBtn, memoryUsageResetBtn, allWidvalidateXPoints());
    }

    public void validateMemoryUsageXaxisTitle(String expectedTitle) {
       util.ValidateTheTitle(page.locator(memoryUsageXaxisTitle).textContent(), expectedTitle);
    }

    public void validateMemoryUsageYaxisTitle(String expectedTitle) {
       util.ValidateTheTitle(page.locator(memoryUsageYaxisTitle).textContent(), expectedTitle); 
    }

    public void validateMemoryUsageToolTipTitle() {
        util.validateWidgetToolTips(page, memoryUsageXaxisLines, memoryUsageToolTipTitle);
    }

    public void validateMemoryUsageDragdrop() {
    	util.graphZoomInByDragAndDrop(page, memoryUsageXaxisLines, memoryUsageResetBtn, allWidvalidateXPoints());
    }
    public void validateNetworkIOWidgetTitle(String expectedText) {
        page.waitForSelector(networkIOWidvalidateTitle);
    	Locator legend= page.locator(networkIOWidvalidateTitle);
    	Assert.assertTrue(legend.isVisible());
    	String text = page.locator(networkIOWidvalidateTitle).textContent().trim();
    	Assert.assertEquals(text, expectedText);
    }

    public void validateNetworkIOZoomOut() {
        util.graphZoomOut(page, networkIOZoomIn, networkIOZoomOut, networkIOReset,allWidvalidateXPoints());
    }

    public void validateNetworkIOZoomIn() {
       util.graphZoomIn(page, networkIOZoomIn, networkIOReset, allWidvalidateXPoints()); ;
    }

    public void validateNetworkIOReset() {
       util.graphZoomReset(page, networkIOZoomIn, networkIOReset,allWidvalidateXPoints());
    }

    public void validateNetworkIOXaxisTitle(String expectedTitle) {
        util.ValidateTheTitle(page.locator(networkIOXaxisTitle).textContent(), expectedTitle);
    }

    public void validateNetworkIOYaxisTitle(String expectedTitle) {
        util.ValidateTheTitle(page.locator(networkIOYaxisTitle).textContent(), expectedTitle);
    }

    public void validateNetworkIOToolTipTitle() {
        util.validateWidgetToolTips(page, networkIOXaxisLines, networkIOToolTipTitle);
    }

    public void validateNetworkIODragAndDrop() {
    	util.graphZoomInByDragAndDrop(page, networkIOXaxisLines, networkIOReset, allWidvalidateXPoints());
    }

    public void validateNetworkIOLegendsfunctionality() {
    	util.validateWidgetLegends(page, networkIOWidvalidateLegendsList, networkIOWidvalidateLegendsColorList, netwrokIOWidgetLegendsLineList ,networkIOWidgetsLegendsToolTipColorList ,networkIOXaxisLines,networkIOwidgetLegendsActiveToolTipText);
    	
    }
    public void validateNetWorkIOWidgetLegendstext(String expectedLegendsList) {
        util.validateWidgetLegendsText(page,networkIOWidvalidateLegendsList,expectedLegendsList);
    }
    public void validateTotalReadWriteTitle(String expectedText) {
        page.waitForSelector(totalReadAndWriteWidvalidateTitle);
    	Locator legend= page.locator(totalReadAndWriteWidvalidateTitle);
    	Assert.assertTrue(legend.isVisible());
    	String text = page.locator(totalReadAndWriteWidvalidateTitle).textContent().trim();
    	Assert.assertEquals(text, expectedText);
    }

    public void validateTotalReadWriteZoomOut() {
        util.graphZoomOut(page, totalReadAndWriteZoomIn, totalReadAndWriteZoomOut, totalReadAndWriteReset,allWidvalidateXPoints());
    }

    public void validateTotalReadWriteZoomIn() {
       util.graphZoomIn(page, totalReadAndWriteZoomIn, totalReadAndWriteReset, allWidvalidateXPoints()); ;
    }

    public void validateTotalReadWriteReset() {
       util.graphZoomReset(page, totalReadAndWriteZoomIn, totalReadAndWriteReset,allWidvalidateXPoints());
    }

    public void validateTotalReadWriteXaxisTitle(String expectedTitle) {
        util.ValidateTheTitle(page.locator(totalReadAndWriteXaxisTitle).textContent(), expectedTitle);
    }

    public void validateTotalReadWriteYaxisTitle(String expectedTitle) {
        util.ValidateTheTitle(page.locator(totalReadAndWriteYaxisTitle).textContent(), expectedTitle);
    }

    public void validateTotalReadWriteToolTipTitle() {
        util.validateWidgetToolTips(page, totalReadAndWriteXaxisLines, totalReadAndWriteToolTipTitle);
    }

    public void validateTotalReadWriteDragAndDrop() {
    	util.graphZoomInByDragAndDrop(page, totalReadAndWriteXaxisLines, totalReadAndWriteReset, allWidvalidateXPoints());
    }

    public void validateTotalReadWriteLegendsfunctionality() {
    	util.validateWidgetLegends(page, totalReadAndWriteWidvalidateLegendsList, totalReadAndWriteWidvalidateLegendsColorList, totalReadAndWriteWidgetLegendsLineList ,totalReadAndWriteWidgetsLegendsToolTipColorList ,totalReadAndWriteXaxisLines,totalReadAndWritewidgetLegendsActiveToolTipText);
    	
    }
    public void validateTotalReadWriteWidgetLegendstext(String expectedLegendsList) {
        util.validateWidgetLegendsText(page,totalReadAndWriteWidvalidateLegendsList,expectedLegendsList);
    }
    public void validateTotalBytesReadWriteTitle(String expectedText) {
        page.waitForSelector(totalBytesWrittenAndReadWidvalidateTitle);
    	Locator legend= page.locator(totalBytesWrittenAndReadWidvalidateTitle);
    	Assert.assertTrue(legend.isVisible());
    	String text = page.locator(totalBytesWrittenAndReadWidvalidateTitle).textContent().trim();
        System.out.println(text);
        System.out.println(expectedText);
    	Assert.assertEquals(text, expectedText);
    }

    public void validateTotalBytesReadWriteZoomOut() {
        util.graphZoomOut(page, totalBytesWrittenAndReadZoomIn, totalBytesWrittenAndReadZoomOut, totalBytesWrittenAndReadReset,allWidvalidateXPoints());
    }

    public void validateTotalBytesReadWriteZoomIn() {
       util.graphZoomIn(page, totalBytesWrittenAndReadZoomIn, totalBytesWrittenAndReadReset, allWidvalidateXPoints()); ;
    }

    public void validateTotalBytesReadWriteReset() {
       util.graphZoomReset(page, totalBytesWrittenAndReadZoomIn, totalBytesWrittenAndReadReset,allWidvalidateXPoints());
    }

    public void validateTotalBytesReadWriteXaxisTitle(String expectedTitle) {
        util.ValidateTheTitle(page.locator(totalBytesWrittenAndReadXaxisTitle).textContent(), expectedTitle);
    }

    public void validateTotalBytesReadWriteYaxisTitle(String expectedTitle) {
        util.ValidateTheTitle(page.locator(totalBytesWrittenAndReadYaxisTitle).textContent(), expectedTitle);
    }

    public void validateTotalBytesReadWriteToolTipTitle() {
        util.validateWidgetToolTips(page, totalBytesWrittenAndReadXaxisLines, totalBytesWrittenAndReadToolTipTitle);
    }

    public void validateTotalBytesReadWriteDragAndDrop() {
    	util.graphZoomInByDragAndDrop(page, totalBytesWrittenAndReadXaxisLines, totalBytesWrittenAndReadReset, allWidvalidateXPoints());
    }

    public void validateTotalBytesReadWriteLegendsfunctionality() {
    	util.validateWidgetLegends(page, totalBytesWrittenAndReadWidvalidateLegendsList, totalBytesWrittenAndReadWidvalidateLegendsColorList, totalBytesWrittenAndReadWidgetLegendsLineList ,totalBytesWrittenAndReadWidgetsLegendsToolTipColorList ,totalBytesWrittenAndReadXaxisLines,totalBytesWrittenAndReadwidgetLegendsActiveToolTipText);
    	
    }
    public void validateTotalBytesReadWriteWidgetLegendstext(String expectedLegendsList) {
        util.validateWidgetLegendsText(page,totalBytesWrittenAndReadWidvalidateLegendsList,expectedLegendsList);
    }
    
    public void validateTheGivenTimeLine()
    {
    	util.validateTheGraphdisplayingTheDataAsPerGivenTimeLines(page,cpuUsageXaxisValues,calanderValue,allWidvalidateXValues());
    }


    public void validateTheCustomTimeLine(String period)
    {
    	util.validateCustomTimeLine(page,cpuUsageXaxisValues,period,allWidvalidateXValues());
    }


}