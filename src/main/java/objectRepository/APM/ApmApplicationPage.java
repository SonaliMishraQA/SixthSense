package objectRepository.APM;

import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.ss.formula.functions.Delta;
import org.testng.Assert;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;
import com.microsoft.playwright.Locator.HoverOptions;

import genericUtilities.GenericMethods;

public class ApmApplicationPage {
	
	 Page page;
	 GenericMethods util=new GenericMethods();
	
	private String healthIndicatorRangeForGood = "xpath = //div[@class='apdex-status-value-text apdex-color-good']";
	private String healthIndicatorRangeForFair = "xpath = //div[@class='apdex-status-value-text apdex-color-fair']";
	private String healthIndicatorRangeForPoor = "xpath = //div[@class='apdex-status-value-text apdex-color-poor']";
	private String apdexGoodText = "xpath = //div[@class='apdex-status-label-text apdex-color-good']";
	private String apdexFairText= "xpath = //div[@class='apdex-status-label-text apdex-color-fair']";
	private String apdexPoorText = "xpath = //div[@class='apdex-status-label-text apdex-color-poor']";
	private String apdexImage = "xpath = //*[name()='g' and @class='apexcharts-series apexcharts-radial-series']/*[name()='path']";
	private String apdexScore = "xpath = //*[name()='text' and @class='apexcharts-text apexcharts-datalabel-value']";
	private String apdexScoreColour = "xpath = //*[name()='g' and @class='apexcharts-series apexcharts-radial-series']/child::*[name()='path']";
	private String colourOfGoodHealthIndicator = "xpath = //div[@class='apdex-label-status']/child::div[contains(@class, 'good')]";
	private String colourOfFairHealthIndicator = "xpath = //div[@class='apdex-label-status']/child::div[contains(@class, 'fair')]";
	private String colourOfPoorHealthIndicator = "xpath = //div[@class='apdex-label-status']/child::div[contains(@class, 'poor')]";	
	
    private String APMpageTitle = "//span[@id='title-text-apm']/child::span" ;
    private String selectAppDropDown="#search-select-application" ;
    private String searchAppTextField ="#input-search-sel-search-select-application" ;
    private String searchedApp ="xpath = //div[@class='search-sel']/descendant::span[contains(@id,'search-select-application')]" ;
    private String selectedApp = "xpath = //div[@class='selected-item-text']";
    private String dashBoardTab ="#nav-tab-dashboard" ;
    private String applicationTab ="#dasboard-tab-service" ;
    private String endPointtab = "#dasboard-tab-endpoint";
    private String instanceTab = "#dasboard-tab-instance";
    private String dataBaseTab = "#dasboard-tab-appdb";
    private String infrastructureTab = "#dasboard-tab-infra";
    private String apdexTitle = "xpath = //div[@class='gauge-semi-chart-title']";
   
    private String loadGraphImage = "xpath = //div[@id='apexchartsvuechart-line-1']/descendant::*[name()='g' and @class='apexcharts-inner apexcharts-graphical']";
    private String loadGraphTitle ="xpath = //div[@class='line-title' and text()=' Load']" ;
    private String loadGraphYaxisTitle ="xpath =//div[text()=' Load']/ancestor::div[@class='chart-line']/descendant::*[name()='g' and @class='apexcharts-yaxis-title' ]/child::*[name()='text']";
    private String loadGraphXaxisTitle = "xpath =//div[text()=' Load']/ancestor::div[@class='chart-line']/descendant::*[name()='g' and @class='apexcharts-xaxis-title' ]/child::*[name()='text']";
    private String loadGraphZoomIn = "#Load-zoom-in" ;
    private String loadGraphZoomOut = "#Load-zoom-out" ;
    private String loadGraphReset = "#Load-zoom-reset" ;
    private String loadXaxisValues = "xpath = //div[text()=' Load']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-label apexcharts-xaxis-label']/child::*[name()='tspan' and contains(normalize-space(text()),'-')]";
    private String loadGraphXaxisLines = "xpath = //div[@id='apexchartsvuechart-line-1']/descendant::*[name()='g' and @class='apexcharts-inner apexcharts-graphical']/child::*[name()='line' and @class='apexcharts-xaxis-tick']";
    private String loadGraphToolTip ="xpath =//div[@id='apexchartsvuechart-line-1']/descendant::div[@class='apexcharts-tooltip apexcharts-theme-dark apexcharts-active']";
    private String callsPerMinGraphValue = "xpath =//span[@class='line-content-calls']/following-sibling::span" ;
    private String callsGraphValue ="xpath =//span[@class='line-content-calls']" ;
    private String toolTipcalls = "xpath =//div[@id='apexchartsvuechart-line-1']/descendant::div[@class='apexcharts-tooltip apexcharts-theme-dark apexcharts-active']/descendant::span[@class='apexcharts-tooltip-text-y-value']";

    private String errorGraphTitle = "xpath =//div[@class='line-title' and text()=' Error']";
    private String errorGraphYaxisTitle = "xpath =//div[text()=' Error']/ancestor::div[@class='chart-line']/descendant::*[name()='g' and @class='apexcharts-yaxis-title' ]/child::*[name()='text']";
    private String errorGraphXaxisTitle = "xpath =//div[text()=' Error']/ancestor::div[@class='chart-line']/descendant::*[name()='g' and @class='apexcharts-xaxis-title' ]/child::*[name()='text']";
    private String errorGraphZoomIn ="#Error-zoom-in" ;
    private String errorGraphZoomOut = "#Error-zoom-out" ;
    private String errorGraphReset ="#Error-zoom-reset" ;
    private String errorGraphXaxisLines = "xpath = //div[text()=' Error']/ancestor::div[@class='chart-line']/descendant::*[name()='g' and @class='apexcharts-inner apexcharts-graphical']/child::*[name()='line' and @class='apexcharts-xaxis-tick']";
    private String errorGraphXaxisValues = "xpath = //div[text()=' Error']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-label apexcharts-xaxis-label']/child::*[name()='tspan' and contains(normalize-space(text()),'-')]";
    private String errorGraphToolTip = "xpath = //div[text()=' Error']/ancestor::div[@class='chart-line']/descendant::div[@class='apexcharts-tooltip-title']";
    private String errorGraphValue = "xpath =//div[@class='line-content-error']/child::span[@class='line-errors']" ;
    private String errorPerMinGraphValue = "xpath =//div[@class='line-content-error']/child::span[@class='line-errors']/following-sibling::span" ;
    private String toolTip4xxErrorPercentage = "xpath = //div[@id='apexchartsvuechart-area-2']/descendant::div[@class='apexcharts-tooltip apexcharts-theme-dark apexcharts-active']/descendant::span[.='service_error_code__4xx_percent']/following-sibling::span[@class='apexcharts-tooltip-text-y-value']";
    private String toolTip5xxErrorPercentage = "xpath =//div[@id='apexchartsvuechart-area-2']/descendant::div[@class='apexcharts-tooltip apexcharts-theme-dark apexcharts-active']/descendant::span[.='service_error_code__5xx_percent']/following-sibling::span[@class='apexcharts-tooltip-text-y-value']";
    private String fourSerErrorPercentage ="xpath =//span[@class='apexcharts-legend-text' and text()='4XX :  ']/child::span[position()=1]" ;
    private String fiveSerErrorPercentage = "xpath =//span[@class='apexcharts-legend-text' and text()='5XX :  ']/child::span[position()=1]" ;
    private String errorGraphLegendsList = "xpath = //div[@id='apexchartsvuechart-area-2']/descendant::span[@class='apexcharts-legend-text']";
    private String errorGraphLegendsColorList = "xpath = //div[@id='apexchartsvuechart-area-2']/descendant::span[contains(@class,'apexcharts-legend-marker')]";
    private String errorGraphlegendsLineList = "xpath = //div[@id='apexchartsvuechart-area-2']/descendant::*[name()='g' and @class='apexcharts-series']/child::*[name()='path' and @fill='none']";
    private String errorGraphToolTipColorList = "xpath = //div[@id='apexchartsvuechart-area-2']/descendant::div[@class='apexcharts-tooltip apexcharts-theme-dark apexcharts-active']/descendant::span[@class='apexcharts-tooltip-marker']";
    private String errorGraphToolTipText = "xpath = //div[@id='apexchartsvuechart-area-2']/descendant::div[@class='apexcharts-tooltip-series-group apexcharts-active']/descendant::span[@class='apexcharts-tooltip-text-y-label']";

    private String responseTimeGraphTitle = "xpath =//div[@class='line-title' and text()=' Response time']" ;
    private String responseTimeGraphYaxisTitle = "xpath =//div[text()=' Response time']/ancestor::div[@class='chart-line']/descendant::*[name()='g' and @class='apexcharts-yaxis-title' ]/child::*[name()='text']";
    private String responseTimeGraphXaxisTitle = "xpath =//div[text()=' Response time']/ancestor::div[@class='chart-line']/descendant::*[name()='g' and @class='apexcharts-xaxis-title' ]/child::*[name()='text']";
    private String responseTimeGraphZoomIn = "#Response-time-zoom-in" ;
    private String responseTimeGraphZoomOut = "#Response-time-zoom-out" ;
    private String responseTimeGraphReset = "#Response-time-zoom-reset" ;
    private String responseTimeGraphXaxixLines ="xpath =//div[@id='apexchartsvuechart-line-3']/descendant::*[name()='g' and @class='apexcharts-inner apexcharts-graphical']/child::*[name()='line' and @class='apexcharts-xaxis-tick']";
    private String responseTimeGraphXaxisValues = "xpath =  //div[text()=' Response time']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-label apexcharts-xaxis-label']/child::*[name()='tspan' and contains(normalize-space(text()),'-')]";
    private String responseTimeGraphToolTip = "xpath =//div[@id='apexchartsvuechart-line-3']/descendant::div[@class='apexcharts-tooltip apexcharts-theme-dark apexcharts-active']";
    private String toolTipResponseTime = "xpath =//div[@id='apexchartsvuechart-line-3']/descendant::div[@class='apexcharts-tooltip apexcharts-theme-dark apexcharts-active']/descendant::span[@class='apexcharts-tooltip-text-y-value']";
    private String responseTimeGraphValue = "xpath =//div[.=' Response time']/following-sibling::div[@class='line-content']" ;

    private String percentileResponseTimeGraphTitle = "xpath =//div[@class='line-title' and text()=' Percentile response time']" ;
    private String percentileResponseTimeGraphYaxisTitle = "xpath =//div[text()=' Percentile response time']/ancestor::div[@class='chart-line']/descendant::*[name()='g' and @class='apexcharts-yaxis-title' ]/child::*[name()='text']";
    private String percentileResponseTimeGraphXaxisTitle = "xpath =//div[text()=' Percentile response time']/ancestor::div[@class='chart-line']/descendant::*[name()='g' and @class='apexcharts-xaxis-title' ]/child::*[name()='text']";
    private String percentileResponseTimeGraphZoomIn = "#Percentile-response-time-zoom-in" ;
    private String percentileResponseTimeGraphZoomOut = "#Percentile-response-time-zoom-out" ;
    private String percentileResponseTimeGraphReset = "#Percentile-response-time-zoom-reset" ;
    private String percentileResponseTimeGraphXaxisLines = "xpath =//div[@id='apexchartsvuechart-area-0']/descendant::*[name()='g' and @class='apexcharts-inner apexcharts-graphical']/child::*[name()='line' and @class='apexcharts-xaxis-tick']";
    private String percentileResponseTimeGraphXaxisValues = "xpath = //div[text()=' Percentile response time']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-label apexcharts-xaxis-label']/child::*[name()='tspan' and contains(normalize-space(text()),'-')]";
    private String percentileResponseTimeGraphToolTip = "xpath =//div[@id='apexchartsvuechart-area-0']/descendant::div[@class='apexcharts-tooltip apexcharts-theme-dark apexcharts-active']";
    private String percentileResponseTimeGraphLegendsList= "xpath = //div[@id='apexchartsvuechart-area-0']/descendant::span[contains(@class,'apexcharts-legend-text')]";
    private String percentileResponseTimeGraphLegendsColorList = "xpath = //div[@id='apexchartsvuechart-area-0']/descendant::span[contains(@class,'apexcharts-legend-marker')]";
    private String percentileResponseTimeGraphlegendsLineList = "xpath = //div[@id='apexchartsvuechart-area-0']/descendant::*[name()='g' and @class='apexcharts-series']/child::*[name()='path' and @fill='none']";
    private String percentileResponseTimeGraphToolTipColorList = "xpath = //div[@id='apexchartsvuechart-area-0']/descendant::div[@class='apexcharts-tooltip apexcharts-theme-dark apexcharts-active']/descendant::span[@class='apexcharts-tooltip-marker']";
    private String percentileResponseTimeGraphToolTipText = "xpath = //div[@id='apexchartsvuechart-area-0']/descendant::div[@class='apexcharts-tooltip-series-group apexcharts-active']/descendant::span[@class='apexcharts-tooltip-text-y-label']";
    private String percentileResponseTimeGraphToolTipValue = "xpath = //div[@id='apexchartsvuechart-area-0']/descendant::div[@class='apexcharts-tooltip-series-group apexcharts-active']/descendant::span[@class='apexcharts-tooltip-text-y-value']";
    private String percentailWidgetP50TooltipValue = "xpath = //div[@id='apexchartsvuechart-area-0']/descendant::div[@class='apexcharts-tooltip apexcharts-theme-dark apexcharts-active']/child::div[position()=2]/descendant::span[@class='apexcharts-tooltip-text-y-value']" ;
    private String percentailWidgetP75TooltipValue = "xpath = //div[@id='apexchartsvuechart-area-0']/descendant::div[@class='apexcharts-tooltip apexcharts-theme-dark apexcharts-active']/child::div[position()=3]/descendant::span[@class='apexcharts-tooltip-text-y-value']" ;
    private String percentailWidgetP90TooltipValue = "xpath = //div[@id='apexchartsvuechart-area-0']/descendant::div[@class='apexcharts-tooltip apexcharts-theme-dark apexcharts-active']/child::div[position()=4]/descendant::span[@class='apexcharts-tooltip-text-y-value']" ;
    private String percentailWidgetP95TooltipValue = "xpath = //div[@id='apexchartsvuechart-area-0']/descendant::div[@class='apexcharts-tooltip apexcharts-theme-dark apexcharts-active']/child::div[position()=5]/descendant::span[@class='apexcharts-tooltip-text-y-value']" ;
    private String percentailWidgetP99TooltipValue = "xpath = //div[@id='apexchartsvuechart-area-0']/descendant::div[@class='apexcharts-tooltip apexcharts-theme-dark apexcharts-active']/child::div[position()=6]/descendant::span[@class='apexcharts-tooltip-text-y-value']";
   
    private String endpointByErrorTab = "#multi-header-card-slow-trace-0" ;
    private String descendingValues = "xpath =//div[@class='slow-body']/child::div/descendant::span[position()=1]" ;
    private String valuesList = "xpath =//div[@class='slow-body']/child::div[@class='rex-chart-slow-i']/child::div[@class='cp link-hover ellipsis']" ;
    private String instancesByErrorTab = "#multi-header-card-slow-trace-1" ;
    private String endpointsByResponseTimeTab = "#multi-header-card-slow-trace-2" ;
    private String instancesByResponseTimeTab = "#multi-header-card-slow-trace-3" ; 
    private String copyIcon = "xpath = //div[contains(@id,'copy-icon')]/child::span";
    private String copyArrow = "xpath = //div[@class='rk-tooltip-inner']";
    private String copiedMessage ="xpath = //div[@class='ant-notification-notice-with-icon']/descendant::div[@class='ant-notification-notice-description']" ;
    private String messageCloseBtn = "xpath = //a[@class='ant-notification-notice-close']";
    private String calanderValue = "xpath = //div[@class='selected-text ellipsis bg-text']";
    
    //------------------------- end point page and instance page ----------------
    private String navigatedPageTitle = "xpath =//span[@class='icon-label']/child::p";
    private String errorPercentage = "xpath = //span[@class='line-error-percentage']";
    private String responseTime = "xpath = //div[.=' Response time']/ancestor::div[@class='line-header']/descendant::div[@class = 'line-content']";
    private String instancePageLoadWidget = "xpath =//div[.=' Load']" ;
    private String instancePageErrorWidget = "xpath =//div[.=' Error']" ;
    private String instancePageResponseTimeWidget = "xpath =//div[.=' Response time']";
    private String instancePageJVMCPUWidget = "xpath =//div[.=' JVM CPU (%) ' and @class='line-title']" ;
    private String instancePageJVMmemoryWidget = "xpath =//div[.=' JVM memory (MB) ' and @class='line-title']" ;
    private String instancePageGCtimeWidget = "xpath =//div[.=' GC time (ms) ' and @class='line-title']" ;
    private String instancePageGCcountWidget = "xpath =//div[.=' GC count ' and @class='line-title']" ;
    private String instancePageThreadCountWidget = "xpath =//div[.=' Thread count ' and @class='line-title']" ;
    private String backBtn = "xpath = //button[@class='icon-class']";
	
	public ApmApplicationPage(Page page)
	{
		this.page=page;
	}
	
	public List<String> allWidgetXPoints()
	{
		 ArrayList<String> xPoint = new ArrayList<String>();
		 xPoint.add(loadGraphXaxisLines);
		 xPoint.add(errorGraphXaxisLines);
		 xPoint.add(responseTimeGraphXaxixLines);
		 xPoint.add(percentileResponseTimeGraphXaxisLines);
		 return xPoint;
	}
	
	public List<String> allWidgetXValues()
	{
		 ArrayList<String> xValue = new ArrayList<String>();
		 xValue.add(loadXaxisValues);
		 xValue.add(errorGraphXaxisValues);
		 xValue.add(responseTimeGraphXaxisValues);
		 xValue.add(percentileResponseTimeGraphXaxisValues);
		 return xValue;
	}
	
	public void validatePercentageOfErrorsOnYaxis()
	{
		page.waitForURL("**/apm/dashboard/service");
		Locator xAxisLines = page.locator(errorGraphXaxisLines);
		page.waitForLoadState(LoadState.DOMCONTENTLOADED);
		page.waitForTimeout(2500);
		page.locator(errorGraphTitle).scrollIntoViewIfNeeded();
		page.mouse().wheel(0, 0);
		HoverOptions hoverOptions=new HoverOptions();
	    hoverOptions.setPosition(0,-30);
	    hoverOptions.setForce(true);
	    
		HoverOptions hoverOptions1=new HoverOptions();
	    hoverOptions1.setPosition(2,-15);
	    hoverOptions1.setForce(true);
	    int num = page.locator(errorGraphXaxisLines).count();
	    System.out.println(num);
	    int count = 0;
	    double expected5xxToolTipValue=0.0;
	    double expected4xxToolTipValue=0.0;
	    int value =0;
	    for(int i=0;i<num;i++)
	    {
	    	if(value==num-1)
	    	{
	    		hoverOptions.setPosition(0,-10);
	    		xAxisLines.nth(i).hover(hoverOptions);
	    	}
	    	else
	    	{
		    	xAxisLines.nth(i).hover(hoverOptions);
		    	xAxisLines.nth(i).hover(hoverOptions1);
	    		page.locator(errorGraphXaxisLines).nth(i).hover(hoverOptions);
	    	}
	    	value++;
	    	page.waitForTimeout(200);
	    	 expected4xxToolTipValue = expected4xxToolTipValue+Double.parseDouble(page.locator(toolTip4xxErrorPercentage).textContent().trim());
	    	 expected5xxToolTipValue = expected5xxToolTipValue+Double.parseDouble(page.locator(toolTip5xxErrorPercentage).textContent().trim());
	    	if (Integer.parseInt(page.locator(toolTip4xxErrorPercentage).textContent().trim()) > 0 || Integer.parseInt(page.locator(toolTip5xxErrorPercentage).textContent().trim() )>0)
	    	{
	    		count++;
	    	}
	    }
	    
	    double actual4xxErrorPercentage =Double.parseDouble(page.locator(fourSerErrorPercentage).textContent().trim());
	    double actual5xxErrorPercentage = Double.parseDouble(page.locator(fiveSerErrorPercentage).textContent().trim());
	    
	    Assert.assertEquals(expected4xxToolTipValue/count, actual4xxErrorPercentage);
	    Assert.assertEquals(expected5xxToolTipValue/count, actual5xxErrorPercentage);
	}
	
	public void validateColourOfTheHealthIndicatorGoodIconLabelAndValue (String goodApdexColor)
	{
		
		int count = page.locator(colourOfGoodHealthIndicator).count();
		String expectedColor="";
		for(int i=0;i<count;i++)
		{
			if(i==0)
			{
				expectedColor = (String) page.locator(colourOfGoodHealthIndicator).nth(i).evaluate("element => getComputedStyle(element).background");
			}
			else
			{
				expectedColor = (String) page.locator(colourOfGoodHealthIndicator).nth(i).evaluate("element => getComputedStyle(element).color");
			}
			System.out.println(expectedColor+" ============= "+goodApdexColor);
			Assert.assertTrue(expectedColor.contains(goodApdexColor));
		}
	}
	
	public void validateColourOfTheHealthIndicatorFairIconLabelAndValue (String fairApdexColor)
	{
		int count = page.locator(colourOfFairHealthIndicator).count();
		String expectedColor="";
		for(int i=0;i<count;i++)
		{
			if(i==0)
			{
				expectedColor = (String) page.locator(colourOfFairHealthIndicator).nth(i).evaluate("element => getComputedStyle(element).background");
			}
			else
			{
				expectedColor = (String) page.locator(colourOfFairHealthIndicator).nth(i).evaluate("element => getComputedStyle(element).color");
			}
			Assert.assertTrue(expectedColor.contains(fairApdexColor));
		}
	}
	
	
	public void validateColourOfTheHealthIndicatorPoorIconLabelAndValue (String poorApdexColor)
	{
		int count = page.locator(colourOfPoorHealthIndicator).count();
		String expectedColor="";
		for(int i=0;i<count;i++)
		{
			if(i==0)
			{
				expectedColor = (String) page.locator(colourOfPoorHealthIndicator).nth(i).evaluate("element => getComputedStyle(element).background");
			}
			else
			{
				expectedColor = (String) page.locator(colourOfPoorHealthIndicator).nth(i).evaluate("element => getComputedStyle(element).color");
			}
			Assert.assertTrue(expectedColor.contains(poorApdexColor));
		}
	}
	
	
	public void validateApdexScoreIndicatorColour(String goodApdexColor,String fairApdexColor,String poorApdexColor)
	{
		double score = Double.parseDouble(page.locator(apdexScore).textContent().trim());
		page.waitForSelector(apdexScoreColour);
		String actualColour = (String) page.locator(apdexScoreColour).evaluate("element => getComputedStyle(element).stroke");
		
		if(score >= 0.00 && score <= 0.68)
		{
			System.out.println(actualColour+"---------"+poorApdexColor);
			Assert.assertTrue(actualColour.contains(poorApdexColor));	
		}else if(score >= 0.69 && score <= 0.83)
		{
			System.out.println(actualColour+"---------"+goodApdexColor);
			Assert.assertTrue(actualColour.contains(fairApdexColor));
		}
		else if(score >= 0.84 && score <= 1.00)
		{
			System.out.println(actualColour+"---------"+goodApdexColor);
			Assert.assertTrue(actualColour.contains(goodApdexColor));
		}
		else 
		{
			Assert.assertTrue(false);
		}
		
	}
	
	public void validateErrorPercentageOfErrorGraphLegends(String fourxxErrors,String fivexxErrors )
	{
		page.waitForSelector(fiveSerErrorPercentage);
		page.locator(errorGraphTitle).scrollIntoViewIfNeeded();
	DecimalFormat df=new DecimalFormat("#.##");
	df.setRoundingMode(RoundingMode.DOWN);
	String fourSerPercentage=page.locator(fourSerErrorPercentage).textContent().trim();
	String fiveSerPercentage=page.locator(fiveSerErrorPercentage).textContent().trim();
	Double totalErrors=Double.parseDouble(fourxxErrors)+Double.parseDouble(fivexxErrors);
	Double intFourxxErrors=Double.parseDouble(fourxxErrors);
	Double actualfourxxErrors=(intFourxxErrors/totalErrors)*100;
	Double actualfivexxErrors=(Double.parseDouble(fivexxErrors)/totalErrors)*100;
	Assert.assertTrue((actualfourxxErrors+actualfivexxErrors)==100.00);
	Assert.assertEquals(df.format(actualfourxxErrors),fourSerPercentage);
	Assert.assertEquals(df.format(actualfivexxErrors),fiveSerPercentage);
		
	}
	
	public void validateEndpointByErrorValues(String endpoints)
	{
		//click on the end point by error tab
		page.locator(endpointByErrorTab).click();
		page.waitForCondition(() -> page.locator(valuesList).count() > 0);
		//validate the end points list should displaying top five or not
		int num = page.locator(valuesList).count();
		Assert.assertTrue(num >0 && num<=5);
		
		//validate the endpoint names as expected or not
		String[] expectedText = endpoints.split(",");
		for(int i=0;i<num;i++)
		{
			String actualEndpoint = page.locator(valuesList).nth(i).textContent().trim();
			Assert.assertEquals(actualEndpoint, expectedText[i]);
		}
	}
	
	public void validateInstanceByErrorValues(String instances)
	{
		page.waitForLoadState(LoadState.DOMCONTENTLOADED);
		//click on the end point by error tab
		page.locator(instancesByErrorTab).click();
		
		page.waitForSelector(valuesList);
		page.locator(valuesList).last().scrollIntoViewIfNeeded();
		if(page.locator(valuesList).first().textContent().trim().equalsIgnoreCase("/LostCities"))
		{
			page.waitForTimeout(1000);
		}
		
		//validate the end points list
		int num = page.locator(valuesList).count();
		Assert.assertTrue(num >0 && num<=5);
		
		//validate the instances names as expected or not
		String[] expectedText = instances.split(",");
		for(int i=0;i<num;i++)
		{
			String actualInstances = page.locator(valuesList).nth(i).textContent().trim();
			System.out.println(actualInstances+"----------"+expectedText[i]);
			Assert.assertEquals(actualInstances, expectedText[i]);
		}
	}
	
	public void validateEndpointByResponseTimeValues(String endpoints)
	{
		//click on the end point by error tab
		page.locator(endpointsByResponseTimeTab).click();
		
		//validate the end points list
		int num = page.locator(valuesList).count();
		Assert.assertTrue(num >0 && num<=5);
		
		String[] expectedText = endpoints.split(",");
		
		//validate the endpoint names as expected or not
		for(int i=0;i<num;i++)
		{
			String actualEndpoint = page.locator(valuesList).nth(i).textContent().trim();
			Assert.assertEquals(actualEndpoint, expectedText[i]);
		}
	}
	
	public void validateInstanceByResponseTimeValues(String instances)
	{
		page.waitForLoadState(LoadState.DOMCONTENTLOADED);
		//click on the end point by error tab
		page.locator(instancesByResponseTimeTab).click();
		
		page.waitForSelector(valuesList);
		page.locator(valuesList).last().scrollIntoViewIfNeeded();
		if(page.locator(valuesList).first().textContent().trim().equalsIgnoreCase("/LostCities"))
		{
			page.waitForTimeout(1000);
		}
		//validate the end points list
		int num = page.locator(valuesList).count();
		Assert.assertTrue(num >0 && num<=5);
		
		//validate the instances names as expected or not
		String[] expectedText = instances.split(",");
		for(int i=0;i<num;i++)
		{
			String actualInstances = page.locator(valuesList).nth(i).textContent().trim();
			Assert.assertEquals(actualInstances, expectedText[i]);
		}
	}
	
	public void clickOnTheEndPointByErrorTab()
	{
		//click on the end point by error tab
		page.locator(endpointByErrorTab).click();
				
		page.waitForSelector(valuesList);
	}
	
	public void clickOnTheInstanceByErrorTab()
	{
		//click on the end point by error tab
		page.locator(instancesByErrorTab).click();
				
		page.waitForSelector(valuesList);
	}
	
	public void clickOnTheEndPointByResponseTimeTab()
	{
		//click on the end point by error tab
		page.locator(endpointsByResponseTimeTab).click();
				
		page.waitForSelector(valuesList);
	}
	
	public void clickOnTheInstanceByResponseTimeTab()
	{
		//click on the end point by error tab
		page.locator(instancesByResponseTimeTab).click();
				
		page.waitForSelector(valuesList);
	}
	
	public void validateTheCopyBtn(String expectedText)
	{
		
		Locator copyIcons = page.locator(copyIcon);
		for(int i=0 ;i<copyIcons.count();i++)
		{
		//mouse over to the copy icon
		copyIcons.nth(i).hover();
		
		//validate the copy Arrow
		Assert.assertTrue(page.locator(copyArrow).isVisible());
		
		//click on the copy icon
		page.locator(copyIcon).nth(i).click();
		
		//validate the copy message
		Assert.assertEquals(page.locator(copiedMessage).last().textContent().trim(), expectedText);
		page.locator(messageCloseBtn).first().click();
		
		}
		
	}
	public void sortTheColumnInDescendingOrderAndValidateTheColumnData(Page page, String descending, String columnData) {
		page.click(descending);
		page.waitForTimeout(1000);
		page.waitForSelector(columnData);
		Locator data = page.locator(columnData);
		float firstLoad;
		float secondLoad;
		for(int i=0; i<data.count()-1; i++)
		{
			String load = data.nth(i).textContent().trim();
			String load1 = data.nth(i+1).textContent().trim();
			
				firstLoad = Float.parseFloat(load);
				secondLoad = Float.parseFloat(load1);
			
			Assert.assertTrue(firstLoad >= secondLoad);
		}

	}

	
	public void validateValuesAreInDescendingOrderForEndpointByErrorTab()
	{
		sortTheColumnInDescendingOrderAndValidateTheColumnData(page,endpointByErrorTab,descendingValues);
	}
	
	public void validateValuesAreInDescendingOrderForInstanceByErrorTab()
	{
		sortTheColumnInDescendingOrderAndValidateTheColumnData(page,endpointByErrorTab,descendingValues);
	}
	
	public void validateValuesAreInDescendingOrderForEndpointByResponseTimeTab()
	{
		sortTheColumnInDescendingOrderAndValidateTheColumnData(page,endpointByErrorTab,descendingValues);
	}
	
	public void validateValuesAreInDescendingOrderForInstanceByResponseTimeTab()
	{
		sortTheColumnInDescendingOrderAndValidateTheColumnData(page,endpointByErrorTab,descendingValues);
	}
	
	public void validateTheEndpointByErrorTabIntegrationWithEndpointPage()
	{
		String[] graphTitles= {loadGraphTitle,errorGraphTitle,responseTimeGraphTitle,percentileResponseTimeGraphTitle};
		validateTheIntegration(graphTitles,errorPercentage);
	}
	
	public void validateTheInstanceByErrorTabIntegrationWithEndpointPage()
	{
		String[] graphTitles = {instancePageLoadWidget,instancePageErrorWidget,instancePageResponseTimeWidget};
		validateTheIntegration(graphTitles,errorPercentage);
	   
	}
	
	public void validateTheEndpointByResponseTimeTabIntegrationWithEndpointPage()
	{
		String[] graphTitles= {loadGraphTitle,errorGraphTitle,responseTimeGraphTitle,percentileResponseTimeGraphTitle};
		validateTheIntegrationOfEndpointByResponseTimeTab(graphTitles,responseTime);
	}
	
	public void validateTheInstanceByResponseTimeTabIntegrationWithEndpointPage()
	{
		String[] graphTitles = {instancePageLoadWidget,instancePageErrorWidget,instancePageResponseTimeWidget};
		validateTheIntegrationOfInstanceByResponseTimeTab(graphTitles,responseTime);
	   
	}
	public void validateTheIntegrationOfInstanceByResponseTimeTab(String[] graphTitles,String actualValue)
	{
		int num = page.locator(valuesList).count();
		for (int i=0;i<num;i++)
		{
			//click on the end point by error tab
			page.locator(instancesByResponseTimeTab).click();
					
			page.waitForSelector(valuesList);
			page.waitForTimeout(500);
			
			String expectedValue = page.locator(descendingValues).nth(i).textContent().replace(".00", "");
			//fetch the value 
			String expectedText = page.locator(valuesList).nth(i).textContent().trim();
			
			// click on the value
			page.locator(valuesList).nth(i).click();
			
			page.waitForTimeout(1500);
			 // validate the navigated page
			 String actualText = page.locator(navigatedPageTitle).textContent();
			 Assert.assertEquals(expectedText, actualText);
			 //validate whether all the respective graphs are displaying or not on the navigated page
			 for(int j=0;j<graphTitles.length;j++)
			 {
				 page.waitForSelector(graphTitles[j]);
			 Assert.assertTrue(page.locator(graphTitles[j]).isVisible());
			 }
			 
			 //validate the navigated page values
			 System.out.println(page.locator(actualValue).textContent().trim()+"-------"+expectedValue);
			 Assert.assertTrue(page.locator(actualValue).textContent().trim().contains(expectedValue));
			 page.locator(backBtn).click();
			 page.waitForLoadState();
		}
	}
	public void validateTheIntegrationOfEndpointByResponseTimeTab(String[] graphTitles,String actualValue)
	{
		int num = page.locator(valuesList).count();
		for (int i=0;i<num;i++)
		{
			//click on the end point by error tab
			page.locator(endpointsByResponseTimeTab).click();
					
			page.waitForSelector(valuesList);
			page.waitForTimeout(500);
			
			String expectedValue = page.locator(descendingValues).nth(i).textContent().replace(".00", "");
			//fetch the value 
			String expectedText = page.locator(valuesList).nth(i).textContent().trim();
			
			// click on the value
			page.locator(valuesList).nth(i).click();
			
			page.waitForTimeout(1500);
			 // validate the navigated page
			 String actualText = page.locator(navigatedPageTitle).textContent();
			 Assert.assertEquals(expectedText, actualText);
			 //validate whether all the respective graphs are displaying or not on the navigated page
			 for(int j=0;j<graphTitles.length;j++)
			 {
				 page.waitForSelector(graphTitles[j]);
			 Assert.assertTrue(page.locator(graphTitles[j]).isVisible());
			 }
			 
			 //validate the navigated page values
			 page.waitForSelector(actualValue);
			 page.locator(actualValue).scrollIntoViewIfNeeded();
			 System.out.println(page.locator(actualValue).textContent().trim()+"-------"+expectedValue);
			 Assert.assertTrue(page.locator(actualValue).textContent().trim().contains(expectedValue));
			 page.locator(backBtn).click();
			 page.waitForLoadState();
		}
	}
	
	public void validateTheIntegration(String[] graphTitles,String actualValue)
	{
		int num = page.locator(valuesList).count();
		for (int i=0;i<num;i++)
		{
			String expectedValue = page.locator(descendingValues).nth(i).textContent().replace(".00", "");
			//fetch the value 
			String expectedText = page.locator(valuesList).nth(i).textContent().trim();
			
			// click on the value
			page.locator(valuesList).nth(i).click();
			page.waitForTimeout(2000);
			 // validate the navigated page
			 String actualText = page.locator(navigatedPageTitle).textContent();
			 Assert.assertEquals(expectedText, actualText);
			 //validate whether all the respective graphs are displaying or not on the navigated page
			 for(int j=0;j<graphTitles.length;j++)
			 {
				 page.waitForSelector(graphTitles[j]);
			 Assert.assertTrue(page.locator(graphTitles[j]).isVisible());
			 }
			 //validate the navigated page values
			 System.out.println(page.locator(actualValue).textContent().trim()+"-------"+expectedValue);
			 Assert.assertTrue(page.locator(actualValue).textContent().trim().contains(expectedValue));
			 page.locator(backBtn).click();
			 page.waitForLoadState();	 
		}
	}
	
	public void validatePercentileResponse(String ResponseTimes)
	{
		page.waitForLoadState(LoadState.DOMCONTENTLOADED);
		page.locator(percentileResponseTimeGraphXaxisLines).last().scrollIntoViewIfNeeded();
		page.waitForTimeout(2000);
		 //calculate the percentile response of P50,P75,P90,P95,P99
		String [] responseTime=ResponseTimes.split(",");
		System.out.println(responseTime.length);
		DecimalFormat df=new DecimalFormat("#");
		df.setRoundingMode(RoundingMode.UP);
		String expectedP50= df.format((50.0/100.0)*responseTime.length);
		String expectedP75= df.format((75.0/100.0)*responseTime.length);
		String expectedP90= df.format((90.0/100.0)*responseTime.length);
		String expectedP95= df.format((95.0/100.0)*responseTime.length);
		String expectedP99= df.format((99.0/100.0)*responseTime.length);
		
		HoverOptions hoverOptions=new HoverOptions();
	    hoverOptions.setForce(true);
	    int count = 0;
	    page.locator(percentileResponseTimeGraphXaxisLines).nth(3).scrollIntoViewIfNeeded();
	    int num=page.locator(percentileResponseTimeGraphXaxisLines).count();
	    System.out.println(num);
	    
	    for(int i=0;i<num;i++)
		{
	    	if(count == num-1)
	    	{
	    		hoverOptions.setPosition(1,-10);
	    		page.locator(percentileResponseTimeGraphXaxisLines).nth(i).hover(hoverOptions); 
	    	}else
	    	{
	    		hoverOptions.setPosition(2,-10);
	    		page.locator(percentileResponseTimeGraphXaxisLines).nth(i).hover(hoverOptions);
	    	}
	    	 count++;
	   
	    	if(Integer.parseInt(page.locator(percentailWidgetP50TooltipValue).textContent().trim())>0)
	    	{
	    		String actualP50=page.locator(percentailWidgetP50TooltipValue).textContent().trim();
	    		String actualP75=page.locator(percentailWidgetP75TooltipValue).textContent().trim();
	    		String actualP90=page.locator(percentailWidgetP90TooltipValue).textContent().trim();
	    		String actualP95=page.locator(percentailWidgetP95TooltipValue).textContent().trim();
	    		String actualP99=page.locator(percentailWidgetP99TooltipValue).textContent().trim();
	    		
	    		Assert.assertTrue(actualP50.contains(responseTime[Integer.parseInt(expectedP50)-1]));
	    		Assert.assertTrue(actualP75.contains(responseTime[Integer.parseInt(expectedP75)-1]));
	    		Assert.assertTrue(actualP90.contains(responseTime[Integer.parseInt(expectedP90)-1]));
	    		Assert.assertTrue(actualP95.contains(responseTime[Integer.parseInt(expectedP95)-1]));
	    		Assert.assertTrue(actualP99.contains(responseTime[Integer.parseInt(expectedP99)-1]));
	    	}
		
		}
	}
	

	
	public void validateTheAverageResponseTime()
	{
		page.waitForTimeout(2000);
		HoverOptions hoverOptions=new HoverOptions();
		 hoverOptions.setForce(true);
	    int num=page.locator(responseTimeGraphXaxixLines).count();
	    int responseTime = 0,totalResponseTime = 0;int count =0;
	    System.out.println(num);
	    int totalCalls=0;
	    //mouse hover to the response time graph and get the tool tips of response time and call
	    for(int i=0;i<num;i++)
		{
	    	
	    	if(count == num-1)
	    	{
	    	    hoverOptions.setPosition(0,-10);
	    		page.locator( responseTimeGraphXaxixLines).nth(i).hover(hoverOptions); 
	    	}else 
	    	{
	    	    hoverOptions.setPosition(2,-10);
	    		page.locator( responseTimeGraphXaxixLines).nth(i).hover(hoverOptions);
	    	}
	    	count++;
	    	page.waitForTimeout(200);
	    	Assert.assertTrue(page.locator(toolTipResponseTime).isVisible());	
	    	//fetch the total calls from load graph
	    	totalCalls= totalCalls+(int)Float.parseFloat(page.locator(toolTipcalls).textContent().trim());
	    	
	    	//multiply response time and calls graphs tool tips and add all the values
	    	responseTime=(int)Float.parseFloat(page.locator(toolTipResponseTime).textContent().trim())*(int)Float.parseFloat(page.locator(toolTipcalls).textContent().trim());
	    	totalResponseTime=totalResponseTime+responseTime;
	    	System.out.println(totalResponseTime);
		}
	    
	  

	    //Divide the total response time with total calls to get average response time
	    int expectedAverageResponseTime=totalResponseTime/totalCalls;
		
	    //fetch the average response time graph value
	    String responseTimeText = page.locator(responseTimeGraphValue).textContent().trim();
	    String actualAverageResponseTime = "";
	   	for (int i=0;i<responseTimeText.length();i++)
		{
			if(Character.isDigit(responseTimeText.charAt(i)))
			{
				actualAverageResponseTime=actualAverageResponseTime+responseTimeText.charAt(i);
			}
		}
	   	//validate the fetched value with calculated value
	   	System.out.println(actualAverageResponseTime+"----"+expectedAverageResponseTime);
		Assert.assertEquals(Integer.parseInt(actualAverageResponseTime),(expectedAverageResponseTime));
	}
	
	public void validateTheLoadWidgetSummationOfyAxisValues(String expectedCalls)
	{
		int actualCalls = util.getTheSummationFromTheWidgetTooltip(page, loadGraphXaxisLines,toolTipcalls );
		System.out.println(actualCalls +"--------"+expectedCalls);
		Assert.assertEquals(actualCalls, Integer.parseInt(expectedCalls));
	}
	
	public void validateApdexValue(String satisfiedCalls,String tolaratedCalls,String frustatedCalls)
	{
		page.waitForTimeout(1500);
		page.waitForLoadState(LoadState.DOMCONTENTLOADED);
		//fetch the apdex score from the application
		String actualApdexScore = page.locator(apdexScore).textContent().trim();
		
		//calculate the apdex score with actual load
		float expectedApdexScore  = (Float.parseFloat(satisfiedCalls)+Float.parseFloat(tolaratedCalls)/2)/
				(Float.parseFloat(satisfiedCalls)+Float.parseFloat(tolaratedCalls)+Float.parseFloat(frustatedCalls));
		DecimalFormat df=new DecimalFormat("#.##");
		df.setRoundingMode(RoundingMode.CEILING);
		//validate both values
		if(df.format(expectedApdexScore).equalsIgnoreCase(actualApdexScore))
		{
			System.out.println("expectedApdexScore :"+df.format(expectedApdexScore) +"--------"+"actualApdexScore: "+actualApdexScore);
			
			Assert.assertEquals(df.format(expectedApdexScore), actualApdexScore);
		}else
		{
			DecimalFormat df1=new DecimalFormat("#.#");
			df1.setRoundingMode(RoundingMode.CEILING);
			System.out.println("expectedApdexScore :"+df1.format(expectedApdexScore) +"--------"+"actualApdexScore: "+actualApdexScore);
			Assert.assertEquals(df.format(expectedApdexScore), actualApdexScore);
		}
		
		
	}
	
	public void validateTotalCallsOnLoadWidget(String expectedCalls)
	{
		page.waitForSelector(callsGraphValue);
		page.waitForTimeout(1500);
		page.locator(callsGraphValue).scrollIntoViewIfNeeded();
		String calls="";
		//fetch the calls text from the load graph
		String text = page.locator(callsGraphValue).textContent().trim();
		
		//separate the number from the text
			for (int i=0;i<text.length();i++)
			{
				if(Character.isDigit(text.charAt(i)) || text.charAt(i)=='.')
				{
					calls=calls+text.charAt(i);
				}
			}
		float actualCalls= Float.parseFloat(calls);
		if (text.contains("k"))
		{
			calls=calls+"000";
			actualCalls= actualCalls*1000;
		} else  if (text.contains("m"))
		{
			actualCalls= actualCalls*1000000;
		}
		//validate the fetched number with expected load
		Assert.assertEquals(Integer.parseInt(calls), Integer.parseInt(expectedCalls));
	}
	
	public void validateTotalCallsPerMinOnLoadWidget()
	{
		String calls="";
		//fetch the calls text from the load graph
		String text = page.locator(callsGraphValue).textContent().trim();
		
		//separate the number from the text
			for (int i=0;i<text.length();i++)
			{
				if(Character.isDigit(text.charAt(i)) || text.charAt(i)=='.')
				{
					calls=calls+text.charAt(i);
				}
			}
			
		float actualCalls= Float.parseFloat(calls);
		
		
		//fetch the calender text from the calender icon
		String calenderValue=page.locator(calanderValue).textContent().trim();
		String num = "";
		double timeInMins = 0;
		//calculate the minutes from the given time range
		for (int i=0;i<calenderValue.length();i++)
		{
			if(Character.isDigit(calenderValue.charAt(i)))
			{
				num=num+calenderValue.charAt(i);
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
		//fetch the call/min text from the load graph 
		String CallsPerMinText = page.locator(callsPerMinGraphValue).textContent().trim();
		String actualCallsPerMin = "";
		//separate the actual call per minutes from the text
		for (int i=0;i<CallsPerMinText.length();i++)
		{
			if(Character.isDigit(CallsPerMinText.charAt(i)))
			{
				actualCallsPerMin=actualCallsPerMin+CallsPerMinText.charAt(i);
			}
		}
		DecimalFormat df=new DecimalFormat("#");
		df.setRoundingMode(RoundingMode.FLOOR);
		String expectedCallsPerMin = df.format(actualCalls/timeInMins);
		Assert.assertEquals(actualCallsPerMin, expectedCallsPerMin);
		
	}
	
	public void validateTotalErrorCallsOnErrorWidget(String expectedErrorCalls)
	{
		page.waitForSelector(errorGraphValue);
		page.locator(errorGraphValue).scrollIntoViewIfNeeded();
		String errorCalls="";
		page.locator(errorGraphValue).scrollIntoViewIfNeeded();
		if(page.locator(errorGraphValue).textContent().trim().equalsIgnoreCase("0 errors"))
		{	System.out.println("if loop executed");
			page.waitForTimeout(2000);}
		//fetch the calls text from the load graph
		String text = page.locator(errorGraphValue).textContent().trim();
		//separate the number from the text
			for (int i=0;i<text.length();i++)
			{
				if(Character.isDigit(text.charAt(i)))
				{
					errorCalls=errorCalls+text.charAt(i);
				}
			}
		int actualErrorCalls=Integer.parseInt(errorCalls);
		//validate the fetched number with expected load
		Assert.assertEquals(actualErrorCalls, Integer.parseInt(expectedErrorCalls));
	}
	
	public void validateTotalErrorCallsPerMinOnErrorWidget()
	{
		String errorCalls="";
		page.waitForSelector(errorGraphValue);
		//fetch the calls text from the load graph
		String text = page.locator(errorGraphValue).textContent().trim();
		
		//separate the number from the text
			for (int i=0;i<text.length();i++)
			{
				if(Character.isDigit(text.charAt(i)))
				{
					errorCalls=errorCalls+text.charAt(i);
				}
			}
			
		float actualErrorCalls= Float.parseFloat(errorCalls);
		System.out.println("actualErrorCalls : "+actualErrorCalls);
		
		//fetch the calendar text from the calendar icon
		String calenderValue=page.locator(calanderValue).textContent().trim();
		String num = "";
		double timeInMins = 0;
		//calculate the minutes from the given time range
		for (int i=0;i<calenderValue.length();i++)
		{
			if(Character.isDigit(calenderValue.charAt(i)))
			{
				num=num+calenderValue.charAt(i);
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
		//fetch the call/min text from the load graph 
		String errorPerMinText = page.locator(errorPerMinGraphValue).textContent().trim();
		String actualErrorCallsPerMin = "";
		//separate the actual call per minutes from the text
		for (int i=0;i<errorPerMinText.length();i++)
		{
			if(Character.isDigit(errorPerMinText.charAt(i)))
			{
				actualErrorCallsPerMin=actualErrorCallsPerMin+errorPerMinText.charAt(i);
			}
		}
		DecimalFormat df=new DecimalFormat("#");
		df.setRoundingMode(RoundingMode.FLOOR);
		String expectedErrorCallsPerMin = df.format(actualErrorCalls/timeInMins);
		System.out.println(expectedErrorCallsPerMin);
		Assert.assertEquals(actualErrorCallsPerMin,expectedErrorCallsPerMin);
		
	}
	
	public void validateEndpointByErrorTab()
	{
		Assert.assertTrue(page.locator(endpointByErrorTab).isVisible());
	}
	
	public void validateInstanceByErrorTab()
	{
		Assert.assertTrue(page.locator(instancesByErrorTab).isVisible());
	}
	
	public void validateEndpointByResponseTimeTab()
	{
		Assert.assertTrue(page.locator(endpointsByResponseTimeTab).isVisible());
	}
	
	public void validateInstanceByResponseTimeTab()
	{
		Assert.assertTrue(page.locator(instancesByResponseTimeTab).isVisible());
	}
	
	public void navigateToDashBoardTab()
	{
		page.locator(dashBoardTab).click();
		Assert.assertTrue(page.locator(applicationTab).isVisible());	
	}
	public void validateAPMPagetitle(String expectedTitle )
	{
		String actualTitle = page.locator(APMpageTitle).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}
	
	public void validateTheSelectApplicationDropDown(String expecteApplications)
	{
		String actualApplication=page.locator(selectedApp).innerHTML().trim();
		Assert.assertEquals(actualApplication, expecteApplications);
	}
	
	public void validateApdexScoreTitle(String expectedTitle)
	{
		String actualTitle = page.locator(apdexTitle).textContent().trim();
		util.ValidateTheTitle(actualTitle, expectedTitle);
	}
	
	public void validateLoadTitle(String expectedTitle)
	{
		util.ValidateTheTitle(page.locator(loadGraphTitle).textContent().trim(), expectedTitle);
	}
	
	public void validateLoadXaxisTitle(String expectedTitle)
	{
		util.ValidateTheTitle(page.locator(loadGraphXaxisTitle).textContent().trim(), expectedTitle);
	}
	
	public void validateLoadYaxisTitle(String expectedTitle)
	{
		util.ValidateTheTitle(page.locator(loadGraphYaxisTitle).textContent().trim(), expectedTitle);
	}
	
	public void validateLoadZoomIn()
	{
		page.waitForURL("**/apm/dashboard/service");
		util.graphZoomIn(page, loadGraphZoomIn, loadGraphReset, allWidgetXPoints());
	}
	
	public void validateLoadZoomOut()
	{
		page.waitForURL("**/apm/dashboard/service");
		util.graphZoomOut(page, loadGraphZoomIn,loadGraphZoomOut, loadGraphReset, allWidgetXPoints());
	}
	
	public void validateLoadZoomReset()
	{
		page.waitForURL("**/apm/dashboard/service");
		util.graphZoomReset(page, loadGraphZoomIn, loadGraphReset, allWidgetXPoints());
	}
	
	public void validateLoadDragDrop()
	{
		page.waitForURL("**/apm/dashboard/service");
		util.graphZoomInByDragAndDrop(page, loadGraphXaxisLines, loadGraphReset, allWidgetXPoints());
	}
	
	public void validateLoadTooltipTitle() throws InterruptedException
	{
		util.validateWidgetToolTips(page,loadGraphXaxisLines, loadGraphToolTip);
	}
	

	public void validateErrorTitle(String expectedTitle)
	{
		util.ValidateTheTitle(page.locator(errorGraphTitle).textContent().trim(), expectedTitle);
	}
	
	public void validateErrorXaxisTitle(String expectedTitle)
	{
		util.ValidateTheTitle(page.locator(errorGraphXaxisTitle).textContent().trim(), expectedTitle);
	}
	
	public void validateErrorYaxisTitle(String expectedTitle)
	{
		util.ValidateTheTitle(page.locator(errorGraphYaxisTitle).textContent().trim(), expectedTitle);
	}
	
	public void validateErrorZoomIn()
	{
		page.waitForURL("**/apm/dashboard/service");
		util.graphZoomIn(page, errorGraphZoomIn, errorGraphReset, allWidgetXPoints());
	}
	
	public void validateErrorZoomOut()
	{
		page.waitForURL("**/apm/dashboard/service");
		util.graphZoomOut(page, errorGraphZoomIn,errorGraphZoomOut, errorGraphReset, allWidgetXPoints());
	}
	
	public void validateErrorZoomReset()
	{
		page.waitForURL("**/apm/dashboard/service");
		util.graphZoomReset(page, errorGraphZoomIn, errorGraphReset, allWidgetXPoints());
	}
	
	public void validatErrorDragDrop()
	{
		page.waitForURL("**/apm/dashboard/service");
		util.graphZoomInByDragAndDrop(page, errorGraphXaxisLines, errorGraphReset, allWidgetXPoints());
	}
	
	public void validateErrorTooltipTitle() throws InterruptedException
	{
		page.waitForURL("**/apm/dashboard/service");
		Locator xAxisLines = page.locator(errorGraphXaxisLines);
		page.waitForTimeout(1000);
		HoverOptions hoverOptions=new HoverOptions();
	    hoverOptions.setPosition(0,-30);
	    hoverOptions.setForce(true);
	    
		HoverOptions hoverOptions1=new HoverOptions();
	    hoverOptions1.setPosition(2,-15);
	    hoverOptions1.setForce(true);
	    
	    page.waitForTimeout(1200);
	    int num=xAxisLines.count();
	    System.out.println(num);
	    for(int i=0;i<num;i++)
		{
	    	xAxisLines.nth(i).hover(hoverOptions);
	    	xAxisLines.nth(i).hover(hoverOptions1);
	    	page.waitForTimeout(200);
	    	System.out.println(page.locator(errorGraphToolTip).textContent());
	    	Assert.assertTrue(!page.locator(errorGraphToolTip).textContent().isEmpty());
	    }
	}
	
	public void validateErrorLegendsText(String expectedLegends)
	{
		util.validateWidgetLegendsText(page,errorGraphLegendsList,expectedLegends );
	}
	
	public void validateResposeTimeTitle(String expectedTitle)
	{
		util.ValidateTheTitle(page.locator(responseTimeGraphTitle).textContent().trim(), expectedTitle);
	}
	
	public void validateResposeTimeXaxisTitle(String expectedTitle)
	{
		util.ValidateTheTitle(page.locator(responseTimeGraphXaxisTitle).textContent().trim(), expectedTitle);
	}
	
	public void validateResposeTimeYaxisTitle(String expectedTitle)
	{
		util.ValidateTheTitle(page.locator(responseTimeGraphYaxisTitle).textContent().trim(), expectedTitle);
	}
	
	public void validateResposeTimeZoomIn()
	{
		page.waitForURL("**/apm/dashboard/service");
		util.graphZoomIn(page, responseTimeGraphZoomIn, responseTimeGraphReset, allWidgetXPoints());
	}
	
	public void validateResposeTimeZoomOut()
	{
		page.waitForURL("**/apm/dashboard/service");
		util.graphZoomOut(page, responseTimeGraphZoomIn,responseTimeGraphZoomOut, responseTimeGraphReset, allWidgetXPoints());
	}
	
	public void validateResposeTimeZoomReset()
	{
		page.waitForURL("**/apm/dashboard/service");
		util.graphZoomReset(page, responseTimeGraphZoomIn, responseTimeGraphReset, allWidgetXPoints());
	}
	
	public void validateResposeTimeDragDrop()
	{
		page.waitForURL("**/apm/dashboard/service");
		util.graphZoomInByDragAndDrop(page, responseTimeGraphXaxixLines, responseTimeGraphReset, allWidgetXPoints());
	}
	
	public void validateResposeTimeTooltipTitle() throws InterruptedException
	{
		page.waitForURL("**/apm/dashboard/service");
		util.validateWidgetToolTips(page, responseTimeGraphXaxixLines, responseTimeGraphToolTip);
	}
	
	public void validatePercentileResponseTimeTitle(String expectedTitle)
	{
		util.ValidateTheTitle(page.locator(percentileResponseTimeGraphTitle).textContent().trim(), expectedTitle);
	}
	
	public void validatePercentileResponseTimeXaxisTitle(String expectedTitle)
	{
		util.ValidateTheTitle(page.locator(percentileResponseTimeGraphXaxisTitle).textContent().trim(), expectedTitle);
	}
	
	public void validatePercentileResponseTimeYaxisTitle(String expectedTitle)
	{
		util.ValidateTheTitle(page.locator(percentileResponseTimeGraphYaxisTitle).textContent().trim(), expectedTitle);
	}
	
	public void validatePercentileResponseTimeZoomIn()
	{
		page.waitForURL("**/apm/dashboard/service");
		util.graphZoomIn(page, percentileResponseTimeGraphZoomIn, percentileResponseTimeGraphReset, allWidgetXPoints());
	}
	
	public void validatePercentileResponseTimeZoomOut()
	{
		page.waitForURL("**/apm/dashboard/service");
		util.graphZoomOut(page, percentileResponseTimeGraphZoomIn,percentileResponseTimeGraphZoomOut, percentileResponseTimeGraphReset, allWidgetXPoints());
	}
	
	public void validatePercentileResponseTimeZoomReset()
	{
		page.waitForURL("**/apm/dashboard/service");
		util.graphZoomReset(page, percentileResponseTimeGraphZoomIn, percentileResponseTimeGraphReset, allWidgetXPoints());
	}
	
	public void validatePercentileResponseTimeDragDrop()
	{
		page.waitForURL("**/apm/dashboard/service");
		util.graphZoomInByDragAndDrop(page, percentileResponseTimeGraphXaxisLines, percentileResponseTimeGraphReset, allWidgetXPoints());
	}
	
	public void validatePercentileResponseTimeTooltipTitle() throws InterruptedException
	{
		page.waitForURL("**/apm/dashboard/service");
		util.validateWidgetToolTips(page,percentileResponseTimeGraphXaxisLines, percentileResponseTimeGraphToolTip);
	}
	
	public void validateWidgetLegendsForPercentailResposeTimeGraph(String expectedLegends)
	{
		util.validateWidgetLegendsText(page,percentileResponseTimeGraphLegendsList,expectedLegends );
	}
	
	public void validatepercentileResponseTimewidgetLegends()
	{
		util.validateWidgetLegends(page, percentileResponseTimeGraphLegendsList, percentileResponseTimeGraphLegendsColorList,percentileResponseTimeGraphlegendsLineList ,percentileResponseTimeGraphToolTipColorList ,percentileResponseTimeGraphXaxisLines,percentileResponseTimeGraphToolTipText);
	}
	
	
	public void validateDashBoardPage()
	{
		Assert.assertTrue(page.locator(applicationTab).isVisible());
		Assert.assertTrue(page.locator(endPointtab).isVisible());
		Assert.assertTrue(page.locator(instanceTab).isVisible());
		Assert.assertTrue(page.locator(dataBaseTab).isVisible());
		Assert.assertTrue(page.locator(infrastructureTab).isVisible());
	}
	
	public void validateApplicationPageDispalyingByDeafultOrNot()
	{
		page.waitForSelector(loadGraphTitle);
		Locator title= page.locator(loadGraphTitle);
		Assert.assertTrue(title.isVisible());
	}
	
	public void navigateToApplicationPage()
	{
		page.locator(applicationTab).click();
		page.waitForSelector(loadGraphTitle);
		Locator title= page.locator(loadGraphTitle);
		Assert.assertTrue(title.isVisible());
	}
	
	public void selectTheApplicationForAPM(String application)
	{
		util.selectTheOptionFromDropDownBySearch(page, selectAppDropDown, searchAppTextField, application, searchedApp);
	}
	
	
	
	public void validatewidgetLegendsForErrorGraph() throws InterruptedException
	{
		page.waitForURL("**/apm/dashboard/service");
		String Actualtext="service_error_code__4xx_percent,service_error_code__5xx_percent";
		util.validateWidgetLegends(page, errorGraphLegendsList, errorGraphLegendsColorList,errorGraphlegendsLineList ,errorGraphToolTipColorList ,errorGraphXaxisLines,errorGraphToolTipText ,Actualtext.split(","));
	}
	
	public void validateTheApdexHealthIndicatorText(String name,String value)
	{
		if(name.equalsIgnoreCase("Good"))
		{	//fetch the data from Health indicator
			String text=page.locator(healthIndicatorRangeForGood).textContent();
			//validate the data 
			Assert.assertTrue(page.locator(apdexGoodText).textContent().contains(name));
			Assert.assertTrue(text.contains(value));
		}
		else if(name.equalsIgnoreCase("Fair"))
		{
			//fetch the data from Health indicator
			String text=page.locator(healthIndicatorRangeForFair).textContent();
			//validate the data 
			Assert.assertTrue(page.locator(apdexFairText).textContent().contains(name));
			Assert.assertTrue(text.contains(value));
		}
		else if(name.equalsIgnoreCase("Poor"))
		{
			//fetch the data from Health indicator
			String text=page.locator(healthIndicatorRangeForPoor).textContent();
			//validate the data 
			Assert.assertTrue(page.locator(apdexPoorText).textContent().contains(name));
			Assert.assertTrue(text.contains(value));
		}
	}
	
	public void validateTheGivenTimeLine()
	{
		page.waitForTimeout(2000);
		page.waitForURL("**/apm/dashboard/service");
		page.waitForSelector(loadXaxisValues);
		util.validateTheGraphdisplayingTheDataAsPerGivenTimeLines(page,loadXaxisValues,calanderValue,allWidgetXValues());
	}
	

	public void validateTheCustomTimeLine(String period)
	{
		page.waitForTimeout(2000);
		page.waitForURL("**/apm/dashboard/service");
		page.waitForSelector(loadXaxisValues);
		util.validateCustomTimeLine(page,loadXaxisValues,period,allWidgetXValues());
	}
	
	public int getNumberOfCallsFromLoadGraphHeader() {
		page.waitForSelector(callsGraphValue);
		page.waitForTimeout(1500);
		int calls = Integer.parseInt(page.textContent(callsGraphValue).trim().replace(" calls",""));
		return calls;
	}
	
	public int getNumberOfErrorsFromErrorGraphHeader() {
		page.waitForSelector(errorGraphValue);
		page.waitForTimeout(1500);
		int errors = Integer.parseInt(page.textContent(errorGraphValue).trim().replace(" errors",""));
		return errors;
	}
	
	public String getApdexImageColor() {
		page.waitForSelector(apdexImage);
    	String apdexColor =(String) page.locator(apdexImage).evaluate("element => window.getComputedStyle(element).getPropertyValue('stroke')");
    	return apdexColor;
	}
	
	public String getApdexScore() {
		page.waitForTimeout(1500);
		page.waitForLoadState(LoadState.DOMCONTENTLOADED);
		String actualApdexScore = page.locator(apdexScore).textContent().trim();
		return actualApdexScore;
	}
	
	public String getAverageResponsetime() {
		page.waitForLoadState(LoadState.DOMCONTENTLOADED);
		page.waitForTimeout(1500);
		String respTime = page.textContent(responseTimeGraphValue).trim().replace(" ms average", "");
		return respTime;
	}
		
	public String getErrorsPerMinute() {
		page.waitForTimeout(3000);
		page.waitForLoadState(LoadState.DOMCONTENTLOADED);
		page.hover(errorPerMinGraphValue);
		String epm = page.textContent(errorPerMinGraphValue).trim().replace(" errors/min", "");
		System.out.println(epm);
		return epm;
	}
	
	public String getCallsPerMinute() {
		page.waitForTimeout(3000);
		page.waitForLoadState(LoadState.DOMCONTENTLOADED);
		page.hover(callsPerMinGraphValue);
		String cpm = page.textContent(callsPerMinGraphValue).trim().replace(" calls/min", "");
		System.out.println(cpm);
		return cpm;
	}
	
	public List<Object> getPercentileResponseTime() {
		page.waitForLoadState(LoadState.DOMCONTENTLOADED);
		page.waitForTimeout(1500);
		List<Object> expectedPercentile = new ArrayList<Object>();
		HoverOptions hoverOpt = new HoverOptions();
		hoverOpt.setForce(true);
		Locator data = page.locator(percentileResponseTimeGraphXaxisLines);
		for (int i=0; i<data.count(); i++) {
			if(i==data.count()-1) 
				hoverOpt.setPosition(0, -10);
			else
				hoverOpt.setPosition(2, -10);

			data.nth(i).hover(hoverOpt);
			page.waitForSelector(percentileResponseTimeGraphToolTip);
			Locator label = page.locator(percentileResponseTimeGraphToolTipText);
			Locator value = page.locator(percentileResponseTimeGraphToolTipValue);
				HashMap<String, String> percentileValues = new HashMap<String,String>();
				int sum=0;
				for(int j=0; j<label.count(); j++) {
					page.waitForTimeout(50);
					percentileValues.put(label.nth(j).textContent().trim().toUpperCase(), value.nth(j).textContent().trim().toUpperCase());
					sum = sum + (Integer.parseInt(value.nth(j).textContent().trim()));
				}
				if(sum!=0)
					expectedPercentile.add(percentileValues);
		}
		System.out.println(expectedPercentile);
		return expectedPercentile;
	}
}
