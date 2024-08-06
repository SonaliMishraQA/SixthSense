package objectRepository.APM;

import java.io.IOException;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;
import com.microsoft.playwright.Locator.HoverOptions;

import genericUtilities.ExcelUtility;
import genericUtilities.GenericMethods;
import genericUtilities.IPathConstant;
import objectRepository.CommonPage;

public class ApmEndpointPage {
	
	Page page;
	GenericMethods util = new GenericMethods();
	ExcelUtility excel = new ExcelUtility();

	private String APMsideNavBtn = "#side-nav-apm";
	private String endpointTab = "#dasboard-tab-endpoint";
	private String selectApplicationDropdown = "#btn-arrow-down-search-select-application";
	private String selectAppSearchBox = "#input-search-sel-search-select-application";
	private String selectAppSearchResult = ".selected-item-text";
	private String noDataIcon = "//div[@class='no-data-icon']/descendant::div";
	
    private String searchBar = " xpath = //input[@placeholder='Search endpoints']" ;
    private String searchBtn = " xpath = //button[@id='btn-search']" ;
    private String nameTab = " xpath = //div[@class='test' and .='Name ']" ;
    private String endPointsColumnData = " xpath = //div[@class='main-row']/descendant::div[@class='table-td border-right' and position()=1]/descendant::span[@class='td-span']";
    private String firstEndpoint = "xpath = //div[@class='main-row']/descendant::div[@class='table-td border-right' and position()=1]/descendant::div[@id='redirect-0-0']";
    private String endPointPageTitle = " xpath = //span[@class='icon-label']/child::p" ;
    private String backBtn = "xpath = //button[@class='icon-class']";

    private String errorPercentText = " xpath = //div[@class='test' and .='Error (%) ']/child::div" ;
    private String errorPercentAscendIcon ="#sort-errorPercent-asc" ;
    private String errorPercentDescendIcon = "#sort-errorPercent-des" ;
    private String errorPercentColumnData = " xpath = //div[@class='main-row']/descendant::div[@class='table-td border-right' and position()=3]/descendant::span[@class='td-span']";
    private String errorPercentGraphValue = " xpath = //span[@class='line-error-percentage']/descendant::span" ;

    private String errorsText = " xpath = //div[@class='test' and .='Errors ']/child::div"  ;
    private String errorsAscendIcon = "#sort-errors-asc" ;
    private String errorsDescendIcon = "#sort-errors-des" ;
    private String errorsColumnData = " xpath = //div[@class='main-row']/descendant::div[@class='table-td border-right' and position()=5]/descendant::span[@class='td-span']";
    private String errorsGraphValue = " xpath = //span[@class='line-error-percentage']/following-sibling::span[@class='line-errors']";

    private String errorsPerMinText = " xpath = //div[@class='test' and .='Errors/min ']/child::div"  ;
    private String errorsPerMinAscendIcon = "#sort-epm-asc" ;
    private String errorsPerMinDescendIcon = "#sort-epm-des" ;
    private String errorsPerMinColumnData = " xpath = //div[@class='main-row']/descendant::div[@class='table-td border-right' and position()=7]/descendant::span[@class='td-span']";
    private String errorsPerMinGraphValue = " xpath = //span[@class='line-error-percentage']/following-sibling::span[position()=2]" ;

    private String responseTimeText = " xpath = //div[@class='test' and .='Response time (ms) ']/child::div" ;
    private String responseTimeAscendIcon = "#sort-respTime-asc" ;
    private String responseTimeDescendIcon = "#sort-respTime-des" ;
    private String responseTimeColumnData = " xpath = //div[@class='main-row']/descendant::div[@class='table-td border-right' and position()=9]/descendant::span[@class='td-span']";
    private String responseTimeGraphValue = " xpath = //div[.=' Response time']/following-sibling::div[@class='line-content']" ;

    private String callsText = " xpath = //div[@class='test' and .='Calls ']/child::div" ;
    private String callsSortAsc = "#sort-calls-asc";
	private String callsSortDes = "#sort-calls-des";
    private String callsColumnData = " xpath = //div[@class='main-row']/descendant::div[@class='table-td border-right' and position()=11]/descendant::span[@class='td-span']";
    private String callsGraphValue = " xpath = //span[@class='line-content-calls']" ;

    private String callsPerMinText = " xpath = //div[@class='test' and .='Calls/min ']" ;
    private String callsPerMinAscendIcon = "#sort-cpm-asc" ;
    private String callsPerMinDescendIcon = "#sort-cpm-des" ;
    private String callsPerMinColumnData = " xpath = //div[@class='main-row']/descendant::div[@class='table-td no-border-right' and position()=13]/descendant::span[@class='td-span']";
    private String callsPerMinGraphValue = " xpath = //span[@class='line-content-calls']/following-sibling::span" ;
    
    private String loadGraphTitle = " xpath = //div[@class='line-title' and text()=' Load']";
    private String loadGraphYaxisTitle = " xpath = //div[text()=' Load']/ancestor::div[@class='chart-line']/descendant::*[name()='g' and @class='apexcharts-yaxis-title' ]/child::*[name()='text']";
    private String loadGraphXaxisTitle = " xpath = //div[text()=' Load']/ancestor::div[@class='chart-line']/descendant::*[name()='g' and @class='apexcharts-xaxis-title' ]/child::*[name()='text']";
    private String loadGraphZoomIn = "#Load-zoom-in" ;
    private String loadGraphZoomOut = "#Load-zoom-out" ;
    private String loadGraphReset = "#Load-zoom-reset" ;
    private String loadXaxisValues = " xpath = //div[text()=' Load']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-label apexcharts-xaxis-label']/child::*[name()='tspan' and contains(normalize-space(text()),'-')]";
    private String loadGraphXaxisLines = " xpath = //div[@id='apexchartsvuechart-line-0']/descendant::*[name()='g' and @class='apexcharts-inner apexcharts-graphical']/child::*[name()='line' and @class='apexcharts-xaxis-tick'] ";
    private String loadGraphToolTip = " xpath = //div[@id='apexchartsvuechart-line-0']/descendant::div[@class='apexcharts-tooltip apexcharts-theme-dark apexcharts-active']";
    private String toolTipcalls = " xpath = //div[@id='apexchartsvuechart-line-0']/descendant::div[@class='apexcharts-tooltip apexcharts-theme-dark apexcharts-active']/descendant::span[@class='apexcharts-tooltip-text-y-value']";

    private String errorGraphTitle = " xpath = //div[@class='line-title' and text()=' Error']";
    private String errorGraphYaxisTitle = " xpath = //div[text()=' Error']/ancestor::div[@class='chart-line']/descendant::*[name()='g' and @class='apexcharts-yaxis-title' ]/child::*[name()='text']";
    private String errorGraphXaxisTitle = " xpath = //div[text()=' Error']/ancestor::div[@class='chart-line']/descendant::*[name()='g' and @class='apexcharts-xaxis-title' ]/child::*[name()='text']";
    private String errorGraphZoomIn = "#Error-zoom-in" ;
    private String errorGraphZoomOut = "#Error-zoom-out" ;
    private String errorGraphReset = "#Error-zoom-reset" ;
    private String errorGraphXaxisLines = " xpath = //div[@id='apexchartsvuechart-line-1']/descendant::*[name()='g' and @class='apexcharts-inner apexcharts-graphical']/child::*[name()='line' and @class='apexcharts-xaxis-tick'] ";
    private String errorGraphXaxisValues = "xpath = //div[text()=' Error']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-label apexcharts-xaxis-label']/child::*[name()='tspan' and contains(normalize-space(text()),'-')]";
    private String errorGraphLegendsList = "xpath = //div[@id='apexchartsvuechart-area-2']/descendant::span[@class='apexcharts-legend-text']";
    private String errorGraphToolTip = " xpath = //div[@id='apexchartsvuechart-line-1']/descendant::div[@class='apexcharts-tooltip apexcharts-theme-dark apexcharts-active']";
    private String errorTracesBtn = " xpath = //div[@class='custom-button' and .='Error traces']";
    private String toolTipErrors = " xpath = //div[@id='apexchartsvuechart-line-1']/descendant::div[@class='apexcharts-tooltip apexcharts-theme-dark apexcharts-active']/descendant::span[@class='apexcharts-tooltip-text-y-value']";

    private String responseTimeGraphTitle = " xpath = //div[@class='line-title' and text()=' Response time']";
    private String responseTimeGraphYaxisTitle = " xpath = //div[text()=' Response time']/ancestor::div[@class='chart-line']/descendant::*[name()='g' and @class='apexcharts-yaxis-title' ]/child::*[name()='text']";
    private String responseTimeGraphXaxisTitle = " xpath = //div[text()=' Response time']/ancestor::div[@class='chart-line']/descendant::*[name()='g' and @class='apexcharts-xaxis-title' ]/child::*[name()='text']";
    private String responseTimeGraphZoomIn = "#Response-time-zoom-in" ;
    private String responseTimeGraphZoomOut = "#Response-time-zoom-out" ;
    private String responseTimeGraphReset = "#Response-time-zoom-reset" ;
    private String responseTimeGraphXaxixLines = " xpath = //div[@id='apexchartsvuechart-line-2']/descendant::*[name()='g' and @class='apexcharts-inner apexcharts-graphical']/child::*[name()='line' and @class='apexcharts-xaxis-tick'] ";
    private String responseTimeGraphXaxisValues = "xpath =  //div[text()=' Response time']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-label apexcharts-xaxis-label']/child::*[name()='tspan' and contains(normalize-space(text()),'-')]";
    private String responseTimeGraphToolTip = " xpath = //div[@id='apexchartsvuechart-line-2']/descendant::div[@class='apexcharts-tooltip apexcharts-theme-dark apexcharts-active']";
    private String slowTracesBtn = " xpath = //div[@class='custom-button' and .='Slow traces']";
    private String toolTipResponseTime = " xpath = //div[@id='apexchartsvuechart-line-2']/descendant::div[@class='apexcharts-tooltip apexcharts-theme-dark apexcharts-active']/descendant::span[@class='apexcharts-tooltip-text-y-value']";

    private String percentileResponseTimeGraphTitle = " xpath = //div[@class='line-title' and text()=' Percentile response time']";
    private String percentileResponseTimeGraphYaxisTitle = " xpath = //div[text()=' Percentile response time']/ancestor::div[@class='chart-line']/descendant::*[name()='g' and @class='apexcharts-yaxis-title' ]/child::*[name()='text']";
    private String percentileResponseTimeGraphXaxisTitle = " xpath = //div[text()=' Percentile response time']/ancestor::div[@class='chart-line']/descendant::*[name()='g' and @class='apexcharts-xaxis-title' ]/child::*[name()='text']";
    private String percentileResponseTimeGraphZoomIn = "#Percentile-response-time-zoom-in" ;
    private String percentileResponseTimeGraphZoomOut = "#Percentile-response-time-zoom-out" ;
    private String percentileResponseTimeGraphReset = "#Percentile-response-time-zoom-reset" ;
    private String percentileResponseTimeGraphXaxisLines = " xpath = //div[@id='apexchartsvuechart-area-3']/descendant::*[name()='g' and @class='apexcharts-inner apexcharts-graphical']/child::*[name()='line' and @class='apexcharts-xaxis-tick'] ";
    private String percentileResponseTimeGraphXaxisValues = "xpath = //div[text()=' Percentile response time']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-label apexcharts-xaxis-label']/child::*[name()='tspan' and contains(normalize-space(text()),'-')]";
    private String percentileResponseTimeGraphToolTip = " xpath = //div[@id='apexchartsvuechart-area-3']/descendant::div[@class='apexcharts-tooltip apexcharts-theme-dark apexcharts-active']";
    private String percentileResponseTimeGraphLegendsList= "xpath = //div[@id='apexchartsvuechart-area-0']/descendant::span[@class='apexcharts-legend-text']";
    private String percentileResponseTimeGraphLegendsColorList = "xpath = //div[@id='apexchartsvuechart-area-0']/descendant::span[@class='apexcharts-legend-marker']";
    private String percentileResponseTimeGraphlegendsLineList = "xpath = //div[@id='apexchartsvuechart-area-0']/descendant::*[name()='g' and @class='apexcharts-series']/child::*[name()='path' and @fill='none']";
    private String percentileResponseTimeGraphToolTipColorList = "xpath = //div[@id='apexchartsvuechart-area-0']/descendant::div[@class='apexcharts-tooltip apexcharts-theme-dark apexcharts-active']/descendant::span[@class='apexcharts-tooltip-marker']";
    private String percentileResponseTimeGraphActiveToolTipText = "xpath = //div[@id='apexchartsvuechart-area-0']/descendant::div[@class='apexcharts-tooltip-series-group apexcharts-active' and contains(@style,'display: flex') ]/descendant::span[@class='apexcharts-tooltip-text-y-label']";
    
    private String percentailWidgetP50TooltipValue = "xpath = //div[@id='apexchartsvuechart-area-0']/descendant::div[@class='apexcharts-tooltip apexcharts-theme-dark apexcharts-active']/child::div[position()=2]/descendant::div[@class='apexcharts-tooltip-y-group']" ;
    private String percentailWidgetP75TooltipValue = "xpath = //div[@id='apexchartsvuechart-area-0']/descendant::div[@class='apexcharts-tooltip apexcharts-theme-dark apexcharts-active']/child::div[position()=3]/descendant::div[@class='apexcharts-tooltip-y-group']" ;
    private String percentailWidgetP90TooltipValue = "xpath = //div[@id='apexchartsvuechart-area-0']/descendant::div[@class='apexcharts-tooltip apexcharts-theme-dark apexcharts-active']/child::div[position()=4]/descendant::div[@class='apexcharts-tooltip-y-group']" ;
    private String percentailWidgetP95TooltipValue = "xpath = //div[@id='apexchartsvuechart-area-0']/descendant::div[@class='apexcharts-tooltip apexcharts-theme-dark apexcharts-active']/child::div[position()=5]/descendant::div[@class='apexcharts-tooltip-y-group']" ;
    private String percentailWidgetP99TooltipValue = "xpath = //div[@id='apexchartsvuechart-area-0']/descendant::div[@class='apexcharts-tooltip apexcharts-theme-dark apexcharts-active']/child::div[position()=6]/descendant::div[@class='apexcharts-tooltip-y-group']";
   
  
    private String calanderValue = "xpath = //div[@class='selected-text ellipsis bg-text']";
    //----------------------Trace Page--------------------------------
    
    private String methodeText = " xpath = //div[@class='method leftmost-heading']" ;
    private String tracePageEndPointTitle = " xpath = //h5[@class='detailTile']" ;
    private String tracePageSortByDropDown = " xpath = //div[@class='selected-text ellipsis']" ;
    private String traceStartTime = " xpath = //div[@class='mainDivItem']/descendant::div[contains(@class,'trace-item')]/descendant::div[@class='start-time' ]" ;
    private String spanInfoPageTitle = " xpath = //span[@class='title']" ;
    private String httpStatusCode = " xpath = //div[text()='status_code:']/parent::div/child::div[@class='equal detail-value']";
    private String spanInfoCloseBtn = " xpath = //div[@class='action1 rk-sidebox-close']" ;

	
	public ApmEndpointPage(Page page) {
		super();
		this.page = page;
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
	
	public void closeSpanInfoWindow() {
    	try{
    		page.click(APMsideNavBtn);
    	}
    	catch(Exception e){
    	{
    		try {
    			page.locator(spanInfoCloseBtn).click();
    		}
    		catch(Exception e1) {}
    		}
    	}
    }
	
	
	public void validateErrorTraceBtn()
	{
		//fetch the first end point text and errors text
		String expectedEndpoint = page.locator(endPointsColumnData).first().textContent().trim().trim();
	
		
		//click on the first end point
		page.locator(endPointsColumnData).first().click();
				
		//click on the slow trace button on the response time widget
		page.locator(errorTracesBtn).click();
		page.waitForLoadState(LoadState.DOMCONTENTLOADED);
		page.waitForTimeout(1000);
		page.waitForSelector(methodeText);
		//validate whether the trace page displayed or not
		Assert.assertTrue(page.locator(methodeText).isVisible());
				
		//validate the trace page displaying the the particular endpoint details or not 
		Assert.assertEquals(page.locator(tracePageEndPointTitle).textContent().trim().trim(), expectedEndpoint);
		
		Assert.assertEquals(page.locator(tracePageSortByDropDown).textContent().trim().trim(),"Start time");
		
	}
	
	public void validateSlowTraceBtn()
	{
		//fetch the first end point text
		String expectedEndpoint = page.locator(endPointsColumnData).first().textContent().trim().trim();
		
		//click on the first end point
		page.locator(endPointsColumnData).first().click();
		
		//click on the slow trace button on the response time widget
		page.locator(slowTracesBtn).click();
		page.waitForLoadState(LoadState.DOMCONTENTLOADED);
		page.waitForTimeout(1000);
		page.waitForSelector(methodeText);
		//validate whether the trace page displayed or not
		Assert.assertTrue(page.locator(methodeText).isVisible());
		
		//validate the trace page displaying the the particular endpoint details or not 
		Assert.assertEquals(page.locator(tracePageEndPointTitle).textContent().trim().trim(), expectedEndpoint);
		
		Assert.assertEquals(page.locator(tracePageSortByDropDown).textContent().trim().trim(),"Duration");
	}
	
	public void validateTheStatusCode(String endpointName,String expectedStatusCode)
	{
		page.waitForSelector(endPointsColumnData);
		//fetch all end point from end point page
		Locator endpoints=page.locator(endPointsColumnData);
		//validate the triggered end point with all end points and click on the triggered end point
		for(int i=0;i<endpoints.count();i++)
		{
			System.out.println(endpoints.nth(i).textContent().trim()+"----------"+endpointName);
			if(endpoints.nth(i).textContent().trim().equalsIgnoreCase(endpointName))
				{
					endpoints.nth(i).click();	
					break;
				}
		}
		page.waitForSelector(slowTracesBtn);
		//click on the slow trace button on the response time widget
		page.locator(slowTracesBtn).click();
		page.waitForLoadState(LoadState.DOMCONTENTLOADED);
		page.waitForTimeout(1000);
		page.waitForSelector(methodeText);
		//validate whether the trace page displayed or not
		Assert.assertTrue(page.locator(methodeText).isVisible());
		
		//click on the start time on the trace page
		page.locator(traceStartTime).first().click();
		
		//validate the span info page displayed or not 
		Assert.assertTrue(page.locator(spanInfoPageTitle).isVisible());
		
		//validate the status code
		Assert.assertTrue(page.locator(httpStatusCode).textContent().trim().trim().equalsIgnoreCase(expectedStatusCode));
		
		//close the span info page
		page.locator(spanInfoCloseBtn).click();
	}
	
	public void validatePercentailWidgetYaxisValues()
	{
		Locator actualEndpoints = page.locator(endPointsColumnData);
		for(int i = 0;i<actualEndpoints.count();i++)
		{
		
			//calculate the percentile response of P50,P75,P90,P95,P99
			String[] responseTime=page.locator(responseTimeColumnData).nth(i).textContent().trim().trim().split(",");
			page.locator(responseTimeColumnData).nth(i).click();
			System.out.println(responseTime.length);
			DecimalFormat df=new DecimalFormat("#");
			df.setRoundingMode(RoundingMode.UP);
			String expectedP50= df.format((50.0/100.0)*responseTime.length);
			String expectedP75= df.format((75.0/100.0)*responseTime.length);
			String expectedP90= df.format((90.0/100.0)*responseTime.length);
			String expectedP95= df.format((95.0/100.0)*responseTime.length);
			String expectedP99= df.format((99.0/100.0)*responseTime.length);
		
			HoverOptions hoverOptions=new HoverOptions();
			hoverOptions.setPosition(2,-10);
			hoverOptions.setForce(true);
			int num=page.locator(percentileResponseTimeGraphXaxisLines).count();
	   
			System.out.println(num);
	    
			for(int j=0;j<num;j++)
			{
				page.locator(percentileResponseTimeGraphXaxisLines).nth(j).hover(hoverOptions);  
	   
				if(Integer.parseInt(page.locator(percentailWidgetP50TooltipValue).textContent().trim().trim())>0)
					{
						String actualP50=page.locator(percentailWidgetP50TooltipValue).textContent().trim().trim();
						String actualP75=page.locator(percentailWidgetP75TooltipValue).textContent().trim().trim();
						String actualP90=page.locator(percentailWidgetP90TooltipValue).textContent().trim().trim();
						String actualP95=page.locator(percentailWidgetP95TooltipValue).textContent().trim().trim();
						String actualP99=page.locator(percentailWidgetP99TooltipValue).textContent().trim().trim();
						Assert.assertEquals(actualP50,"P50"+responseTime[Integer.parseInt(expectedP50)-1]);
						Assert.assertEquals(actualP75,"P75"+responseTime[Integer.parseInt(expectedP75)-1]);
						Assert.assertEquals(actualP90,"P90"+responseTime[Integer.parseInt(expectedP90)-1]);
						Assert.assertEquals(actualP95,"P95"+responseTime[Integer.parseInt(expectedP95)-1]);
						Assert.assertEquals(actualP99,"P99"+responseTime[Integer.parseInt(expectedP99)-1]);
					}
				}
			}
		}
	
	public void validateResponseTimeGraphAverageresponseTime()
	{
		page.waitForURL("**/endpoint/endpoint-table");
		page.waitForSelector(endPointsColumnData);
		page.waitForTimeout(500);
		Locator actualEndpoints = page.locator(endPointsColumnData);
		for(int i = 0;i<actualEndpoints.count();i++)
		{
			
			String endpointPageResponseTime = page.locator(responseTimeColumnData).nth(i).textContent().trim().trim();
			page.locator(responseTimeColumnData).nth(i).click();
			page.waitForTimeout(2000);
			HoverOptions hoverOptions=new HoverOptions();
			hoverOptions.setForce(true);
			page.locator(responseTimeGraphXaxixLines).last().scrollIntoViewIfNeeded();
			int num=page.locator(responseTimeGraphXaxixLines).count();
			int responseTime = 0,totalResponseTime = 0;int count = 0;
			System.out.println(num);
			int totalCalls =0;
			//mouse hover to the response time graph and get the tool tips of response time and call
			for(int j=0;j<num;j++)
			{
				if(count==num-1)
				{
					hoverOptions.setPosition(1,-10);
					page.locator( responseTimeGraphXaxixLines).nth(j).hover(hoverOptions); 
				}
				else
				{
					hoverOptions.setPosition(2,-10);
					page.locator( responseTimeGraphXaxixLines).nth(j).hover(hoverOptions); 
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
			System.out.println(totalResponseTime+"--------"+totalCalls);
			int expectedAverageResponseTime=totalResponseTime/totalCalls;
	    
			//fetch the average response time graph value
			String responseTimeText = page.locator(responseTimeGraphValue).textContent().trim().trim();
			String actualAverageResponseTime = "";
			for (int j=0;j<responseTimeText.length();j++)
			{
				if(Character.isDigit(responseTimeText.charAt(j)))
				{
					actualAverageResponseTime=actualAverageResponseTime+responseTimeText.charAt(j);
				}
			}
			//validate the fetched value with calculated value
			System.out.println(actualAverageResponseTime+"----"+expectedAverageResponseTime);
			Assert.assertEquals(Integer.parseInt(actualAverageResponseTime),(expectedAverageResponseTime));
			Assert.assertEquals(endpointPageResponseTime, String.valueOf(expectedAverageResponseTime));
		}
	}
	
	public void validateErrorGraphYaxisValues()
	{
		Locator actualEndpoints = page.locator(endPointsColumnData);
		for(int i = 0;i<actualEndpoints.count();i++)
		{
			String expectedErrors = page.locator(errorsColumnData).nth(i).textContent().trim().trim();
			page.locator(errorsColumnData).nth(i).click();
			int actualErrors = util.getTheSummationFromTheWidgetTooltip(page, errorGraphXaxisLines, toolTipErrors);
			Assert.assertEquals(actualErrors, Integer.parseInt(expectedErrors));
			page.locator(backBtn).click();
			page.waitForLoadState();
			
		}
	}
	
	public void validateLoadGraphYaxisValues()
	{
		Locator actualEndpoints = page.locator(endPointsColumnData);
		for(int i = 0;i<actualEndpoints.count();i++)
		{
			String expectedCalls = page.locator(callsColumnData).nth(i).textContent().trim().trim();
			page.locator(callsColumnData).nth(i).click();
			int actualCalls = util.getTheSummationFromTheWidgetTooltip(page, loadGraphXaxisLines, toolTipcalls);
			Assert.assertEquals(actualCalls, Integer.parseInt(expectedCalls));
			page.locator(backBtn).click();
			page.waitForLoadState();
			
		}
	}
	
	public void validateCallsPerMinList(String callsList)
	{

		Locator callsPerMinList = page.locator(callsPerMinColumnData);
		String[] expectedCalls = callsList.split(",");
		for(int i =0 ;i<callsPerMinList.count();i++)
		{
		String callsPerMin="";
		//fetch the calls text from the load graph
		String text = callsPerMinList.nth(i).textContent().trim().trim();
		
		//separate the number from the text
			for (int j=0;j<text.length();j++)
			{
				if(Character.isDigit(text.charAt(j)) || text.charAt(j)=='.')
				{
					callsPerMin=callsPerMin+text.charAt(j);
				}
			}
			
		int actualCallsPerMin= Integer.parseInt(callsPerMin);
		if (text.contains("k "))
		{
			actualCallsPerMin= actualCallsPerMin*1000;
		} else  if (text.contains("m "))
		{
			actualCallsPerMin= actualCallsPerMin*1000000;
		}
		
		//fetch the calendar text from the calendar icon
		String calenderValue=page.locator(calanderValue).textContent().trim().trim();
		String num = "";
		int timeInMins = 0;
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
		DecimalFormat df=new DecimalFormat("#");
		df.setRoundingMode(RoundingMode.FLOOR);
		String expectedCallsPerMin = df.format(Float.parseFloat(expectedCalls[i])/timeInMins);
		Assert.assertEquals(String.valueOf(actualCallsPerMin), expectedCallsPerMin);
		}
	}
	
	public void validateCallsList(String callsList)
	{
		String[] expectedCalls = callsList.split(",");
		Locator actualCalls= page.locator(callsColumnData);
		for(int i = 0;i<actualCalls.count();i++)
		{
			Assert.assertEquals(actualCalls.nth(i).textContent().trim().trim(), expectedCalls[i]);
		}
	}
	
	public void validateResponseTimeList(String responseTimeList)
	{
		String[] expectedResponseTimeList = responseTimeList.split(",");
		Locator actualexpectedResponseTimeList = page.locator(responseTimeColumnData);
		for(int i = 0;i<actualexpectedResponseTimeList.count();i++)
		{
			Assert.assertEquals(actualexpectedResponseTimeList.nth(i).textContent().trim().trim(), expectedResponseTimeList[i]);
		}
	}
	
	public void validateErrorsPerMinList(String errorsList)
	{
		
		Locator errorsPerMinList = page.locator(errorsPerMinColumnData);
		String[] expectedErrors = errorsList.split(",");
		for(int i =0 ;i<errorsPerMinList.count();i++)
		{
		String errorPerMin="";
		//fetch the calls text from the load graph
		String text = errorsPerMinList.nth(i).textContent().trim().trim();
		
		//separate the number from the text
			for (int j=0;j<text.length();j++)
			{
				if(Character.isDigit(text.charAt(j)) || text.charAt(j)=='.')
				{
					errorPerMin=errorPerMin+text.charAt(j);
				}
			}
			
		float actualErrorPerMinCalls= Float.parseFloat(errorPerMin);
		if (text.contains("k "))
		{
			actualErrorPerMinCalls= actualErrorPerMinCalls*1000;
		} else  if (text.contains("m "))
		{
			actualErrorPerMinCalls= actualErrorPerMinCalls*1000000;
		}
		
		//fetch the calendar text from the calendar icon
		String calenderValue=page.locator(calanderValue).textContent().trim().trim();
		String num = "";
		int timeInMins = 0;
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
		
		Assert.assertEquals(actualErrorPerMinCalls,(Integer.parseInt(expectedErrors[i])/timeInMins) );
		}
	}
	
	public void validateErrorPercentageList(String errorPercentageList)
	{
		String[] expectedErrorPercentages = errorPercentageList.split(",");
		Locator actualErrorPercentages = page.locator(errorPercentColumnData);
		for(int i = 0;i<actualErrorPercentages.count();i++)
		{
			Assert.assertEquals(actualErrorPercentages.nth(i).textContent().trim().trim(), expectedErrorPercentages[i]);
		}
	}
	
	public void validateErrorsList(String errorsList)
	{
		String[] expectedErrorsList = errorsList.split(",");
		Locator actualErrors = page.locator(errorsColumnData);
		for(int i = 0;i<actualErrors.count();i++)
		{
			Assert.assertEquals(actualErrors.nth(i).textContent().trim().trim(), expectedErrorsList[i]);
		}
	}
	
	public void validateEndpointList(String expectedEndpointsList)
	{
		String[] expectedEndpoints = expectedEndpointsList.split(",");
		Locator actualEndpoints = page.locator(endPointsColumnData);
		for(int i = 0;i<actualEndpoints.count();i++)
		{
			Assert.assertEquals(actualEndpoints.nth(i).textContent().trim().trim(), expectedEndpoints[i]);
		}
	}
	
	
	public void validateIntegrationOfNameData()
	{
		page.waitForSelector(endPointsColumnData);
		int num = page.locator(endPointsColumnData).count();
		
		for(int i=0; i<num;i++)
		{
			String text = page.locator(endPointsColumnData).nth(i).textContent().trim().trim();
			page.locator(endPointsColumnData).nth(i).click();
			String expectedText = page.locator(endPointPageTitle).textContent().trim().trim();
			Assert.assertEquals(text, expectedText);
			page.locator(backBtn).click();
			page.waitForLoadState();
		}
		
	}
	
	public void validateIntegrationOfErrorPercentagedata()
	{
		page.waitForSelector(errorPercentColumnData);
		int num = page.locator(errorPercentColumnData).count();
		
		for(int i=0; i<num;i++)
		{
			String text = page.locator(errorPercentColumnData).nth(i).textContent().trim().trim();
			page.locator(errorPercentColumnData).nth(i).click();
			page.waitForTimeout(500);
			page.waitForSelector(errorPercentGraphValue);
			String expectedText = page.locator(errorPercentGraphValue).textContent().trim().trim();
			System.out.println(expectedText+"----------"+text);
			Assert.assertTrue(expectedText.contains(text));
			page.locator(backBtn).click();
			page.waitForLoadState();
		}
	}
	
	public void validateIntegrationOfErrorsdata()
	{
		page.waitForSelector(errorsColumnData);
		int num = page.locator(errorsColumnData).count();
		
		for(int i=0; i<num;i++)
		{
			String text = page.locator(errorsColumnData).nth(i).textContent().trim().trim();
			String expectedText="";
			double expectedErrors=0.0;
			for(int j=0;j<text.length();j++)
			{
				if(Character.isDigit(text.charAt(j))||text.charAt(i) == '.')
				{
					expectedText=expectedText+text.charAt(j);
				}
			}
			if(text.contains("k"))
			{
				 expectedErrors=Double.parseDouble(expectedText)*1000;
			}else if(text.contains("m"))
			{
				expectedErrors=Double.parseDouble(expectedText)*1000000;
			} else 
			{
				expectedErrors=Double.parseDouble(expectedText);
			}
			
			page.locator(errorsColumnData).nth(i).click();
			String text1 = page.locator(errorsGraphValue).textContent().trim().trim();
			String actualText="";
			double actualErrors=0.0;
			for(int j=0;j<text1.length();j++)
			{
				if(Character.isDigit(text1.charAt(j))||text1.charAt(j) == '.')
				{
					actualText=actualText+text1.charAt(j);
				}
			}
			if(text1.contains("k"))
			{
				actualErrors=Double.parseDouble(actualText)*1000;
			}else if(text1.contains("m"))
			{
				actualErrors=Double.parseDouble(actualText)*1000000;
			}else 
			{
				actualErrors=Double.parseDouble(actualText);
			}
			Assert.assertTrue(expectedErrors>=actualErrors);
			page.locator(backBtn).click();
			page.waitForLoadState();
			
		}
	}
	
	public void validateIntegrationOfErrorsPerMindata()
	{
		page.waitForSelector(errorsPerMinColumnData);
		int num = page.locator(errorsPerMinColumnData).count();
		
		for(int i=0; i<num;i++)
		{
			String text = page.locator(errorsPerMinColumnData).nth(i).textContent().trim().trim();
			String expectedText="";
			double expectedErrors=0.0;
			for(int j=0;j<text.length();j++)
			{
				if(Character.isDigit(text.charAt(j))||text.charAt(j) == '.')
				{
					expectedText=expectedText+text.charAt(j);
				}
			}
			if(text.contains("k"))
			{
				 expectedErrors=Double.parseDouble(expectedText)*1000;
			}else if(text.contains("m"))
			{
				expectedErrors=Double.parseDouble(expectedText)*1000000;
			} else 
			{
				expectedErrors=Double.parseDouble(expectedText);
			}
			
			page.locator(errorsPerMinColumnData).nth(i).click();
			String text1 = page.locator(errorsPerMinGraphValue).textContent().trim().trim();
			String actualText="";
			double actualErrors=0.0;
			for(int j=0;j<text1.length();j++)
			{
				if(Character.isDigit(text1.charAt(j))||text1.charAt(j) == '.')
				{
					actualText=actualText+text1.charAt(j);
				}
			}
			if(text1.contains("k"))
			{
				actualErrors=Double.parseDouble(actualText)*1000;
			}else if(text1.contains("m"))
			{
				actualErrors=Double.parseDouble(actualText)*1000000;
			}else 
			{
				actualErrors=Double.parseDouble(actualText);
			}
			Assert.assertTrue(expectedErrors>=actualErrors);
			page.locator(backBtn).click();
			page.waitForLoadState();
			
		}
	}
	
	public void validateIntegrationOfCallsdata()
	{
		page.waitForSelector(callsColumnData);
		int num = page.locator(callsColumnData).count();
		
		for(int i=0; i<num;i++)
		{
			String text = page.locator(callsColumnData).nth(i).textContent().trim().trim();
			String expectedText="";
			double expectedCalls=0.0;
			for(int j=0;j<text.length();j++)
			{
				if(Character.isDigit(text.charAt(j))||text.charAt(j) == '.')
				{
					expectedText=expectedText+text.charAt(j);
				}
			}
			if(text.contains("k"))
			{
				 expectedCalls=Double.parseDouble(expectedText)*1000;
			}else if(text.contains("m"))
			{
				expectedCalls=Double.parseDouble(expectedText)*1000000;
			} else 
			{
				expectedCalls=Double.parseDouble(expectedText);
			}
			
			page.locator(callsColumnData).nth(i).click();
			String text1 = page.locator(callsGraphValue).textContent().trim().trim();
			String actualText="";
			double actualCalls=0.0;
			for(int j=0;j<text1.length();j++)
			{
				if(Character.isDigit(text1.charAt(j))||text1.charAt(j) == '.')
				{
					actualText=actualText+text1.charAt(j);
				}
			}
			if(text1.contains("k"))
			{
				actualCalls=Double.parseDouble(actualText)*1000;
			}else if(text1.contains("m"))
			{
				actualCalls=Double.parseDouble(actualText)*1000000;
			}else 
			{
				actualCalls=Double.parseDouble(actualText);
			}
			Assert.assertTrue(expectedCalls>=actualCalls);
			page.locator(backBtn).click();
			page.waitForLoadState();
			
		}
	}
	
	public void validateIntegrationOfCallsPerMindata()
	{
		page.waitForSelector(callsPerMinColumnData);
		int num = page.locator(callsPerMinColumnData).count();
		
		for(int i=0; i<num;i++)
		{
			String text = page.locator(callsPerMinColumnData).nth(i).textContent().trim().trim();
			String expectedText="";
			double expectedCalls=0.0;
			for(int j=0;j<text.length();j++)
			{
				if(Character.isDigit(text.charAt(j))||text.charAt(j) == '.')
				{
					expectedText=expectedText+text.charAt(j);
				}
			}
			if(text.contains("k"))
			{
				 expectedCalls=Double.parseDouble(expectedText)*1000;
			}else if(text.contains("m"))
			{
				expectedCalls=Double.parseDouble(expectedText)*1000000;
			} else 
			{
				expectedCalls=Double.parseDouble(expectedText);
			}
			
			page.locator(callsPerMinColumnData).nth(i).click();
			String text1 = page.locator(callsPerMinGraphValue).textContent().trim().trim();
			String actualText="";
			double actualCalls=0.0;
			for(int j=0;j<text1.length();j++)
			{
				if(Character.isDigit(text1.charAt(j))||text1.charAt(j) == '.')
				{
					actualText=actualText+text1.charAt(j);
				}
			}
			if(text1.contains("k"))
			{
				actualCalls=Double.parseDouble(actualText)*1000;
			}else if(text1.contains("m"))
			{
				actualCalls=Double.parseDouble(actualText)*1000000;
			}else 
			{
				actualCalls=Double.parseDouble(actualText);
			}
			Assert.assertTrue(expectedCalls>=actualCalls);
			page.locator(backBtn).click();
			page.waitForLoadState();
			
		}
	}
	
	public void validateIntegrationOfResponseTime()
	{
		page.waitForSelector(responseTimeColumnData);
		int num = page.locator(responseTimeColumnData).count();
		
		for(int i=0; i<num;i++)
		{
			String text = page.locator(responseTimeColumnData).nth(i).textContent().trim().trim();
			page.locator(responseTimeColumnData).nth(i).click();
			String expectedText = page.locator(responseTimeGraphValue).textContent().trim().trim();
			Assert.assertTrue(expectedText.contains(text));
			page.locator(backBtn).click();
			page.waitForLoadState();
		}
		
	}
	
	public void validatePagination(int num) {
		CommonPage commPage=new CommonPage(page);
		commPage.selectPaginationAndValidate(page, num, endPointsColumnData);
	}
	
	public void validateSearchBarWithValidData()
	{
		page.waitForSelector(firstEndpoint);
		String firstelement = page.locator(firstEndpoint).textContent().trim();
		util.validateSearchFunctionalityWithValidData(page, firstelement, searchBar, searchBtn, endPointsColumnData);
	}
	
	public void validateSearchBarWithInValidData()
	{
		util.validateSearchFunctionalityWithInvalidData(page, searchBar, searchBtn, noDataIcon);
	}
	
	public void validateNameColumnList()
	{
		Assert.assertTrue(page.locator(endPointsColumnData).count()>0);
	}
	
	public void sortErrorPercentageColumnInAscendingOrderAndValidate() {
		page.hover(errorPercentText);
		page.locator(errorPercentText).scrollIntoViewIfNeeded();
		util.sortTheColumnInAscendingOrderAndValidateTheColumnData(page, errorPercentAscendIcon, errorPercentColumnData);
	}
	
	public void sortErrorPercentageColumnInDescendingOrderAndValidate() {
		page.hover(errorPercentText);
		page.locator(errorPercentText).scrollIntoViewIfNeeded();
		util.sortTheColumnInDescendingOrderAndValidateTheColumnData(page, errorPercentDescendIcon, errorPercentColumnData);
	}
	
	public void sortErrorsColumnInAscendingOrderAndValidate() {
		page.hover(errorsText);
		page.locator(errorsText).scrollIntoViewIfNeeded();
		util.sortTheColumnInAscendingOrderAndValidateTheColumnData(page, errorsAscendIcon, errorsColumnData);
	}
	
	public void sortErrorsColumnInDescendingOrderAndValidate() {
		page.hover(errorsText);
		page.locator(errorsText).scrollIntoViewIfNeeded();
		util.sortTheColumnInDescendingOrderAndValidateTheColumnData(page, errorsDescendIcon, errorsColumnData);
	}
	
	public void sortErrorsPerMinColumnInAscendingOrderAndValidate() {
		page.hover(errorsPerMinText);
		page.locator(errorsPerMinText).scrollIntoViewIfNeeded();
		util.sortTheColumnInAscendingOrderAndValidateTheColumnData(page, errorsPerMinAscendIcon, errorsPerMinColumnData);
	}
	
	public void sortErrorsPerMinColumnInDescendingOrderAndValidate() {
		page.hover(errorsPerMinText);
		page.locator(errorsPerMinText).scrollIntoViewIfNeeded();
		util.sortTheColumnInDescendingOrderAndValidateTheColumnData(page, errorsPerMinDescendIcon, errorsPerMinColumnData);
	}
	
	public void sortResponseTimeColumnInAscendingOrderAndValidate() {
		page.hover(responseTimeText);
		page.locator(responseTimeText).scrollIntoViewIfNeeded();
		util.sortTheColumnInAscendingOrderAndValidateTheColumnData(page, responseTimeAscendIcon, responseTimeColumnData);
	}
	
	public void sortResponseTimeColumnInDescendingOrderAndValidate() {
		page.hover(responseTimeText);
		page.locator(responseTimeText).scrollIntoViewIfNeeded();
		util.sortTheColumnInDescendingOrderAndValidateTheColumnData(page, responseTimeDescendIcon, responseTimeColumnData);
	}
	
	public void sortCallsColumnInAscendingOrderAndValidate() {
		page.hover(callsText);
		page.locator(callsText).scrollIntoViewIfNeeded();
		util.sortTheColumnInAscendingOrderAndValidateTheColumnData(page, callsSortAsc, callsColumnData);
	}
	
	public void sortCallsColumnInDescendingOrderAndValidate() {
		page.hover(callsText);
		page.locator(callsText).scrollIntoViewIfNeeded();
		util.sortTheColumnInDescendingOrderAndValidateTheColumnData(page, callsSortDes, callsColumnData);
	}
	
	public void sortCallsPerMinColumnInAscendingOrderAndValidate() {
		page.hover(callsPerMinText);
		page.locator(callsPerMinText).scrollIntoViewIfNeeded();
		util.sortTheColumnInAscendingOrderAndValidateTheColumnData(page, callsPerMinAscendIcon, callsPerMinColumnData);
	}
	
	public void sortCallsPerMinColumnInDescendingOrderAndValidate() {
		page.hover(callsPerMinText);
		page.locator(callsPerMinText).scrollIntoViewIfNeeded();
		util.sortTheColumnInDescendingOrderAndValidateTheColumnData(page, callsPerMinDescendIcon, callsPerMinColumnData);
	}
	
	
	public void validateEndPointPage()
	{
		String expectedUrl="**/apm/dashboard/endpoint/endpoint-table";
		page.waitForURL(expectedUrl);
		Assert.assertTrue(page.url().endsWith("/apm/dashboard/endpoint/endpoint-table"));
		Assert.assertTrue(page.locator(nameTab).isVisible());
	}
	
	public void validateTheNameTabHeader(String headerValue)
	{
		Locator actualvalue = page.locator(nameTab);
		Assert.assertEquals(actualvalue.textContent().trim().trim(), headerValue);	
	}
	

	public void validateTheErrorPercentageCulumnHeader(String headerValue)
	{
		Locator actualvalue = page.locator(errorPercentText);
		Assert.assertEquals(actualvalue.textContent().trim().trim(), headerValue);	
	}
	
	public void validateTheErrorsCulumnHeader(String headerValue)
	{
		Locator actualvalue = page.locator(errorsText);
		Assert.assertEquals(actualvalue.textContent().trim().trim(), headerValue);	
	}
	
	public void validateTheErrorsPerMinCulumnHeader(String headerValue)
	{
		Locator actualvalue = page.locator(errorsPerMinText);
		Assert.assertEquals(actualvalue.textContent().trim().trim(), headerValue);	
	}
	
	public void validateTheResponseTimeCulumnHeader(String headerValue)
	{
		Locator actualvalue = page.locator(responseTimeText);
		Assert.assertEquals(actualvalue.textContent().trim().trim(), headerValue);	
	}
	
	public void validateTheCallsCulumnHeader(String headerValue)
	{
		Locator actualvalue = page.locator(callsText);
		Assert.assertEquals(actualvalue.textContent().trim().trim(), headerValue);	
	}
	
	public void validateTheCallsPerMinCulumnHeader(String headerValue)
	{
		Locator actualvalue = page.locator(callsPerMinText);
		Assert.assertEquals(actualvalue.textContent().trim().trim(), headerValue);	
	}
	
	public void validateTheGivenTimeLine()
	{
		page.waitForTimeout(1000);
		page.waitForURL("**/apm/dashboard/endpoint/endpoint-graph");
		util.validateTheGraphdisplayingTheDataAsPerGivenTimeLines(page,loadXaxisValues,calanderValue,allWidgetXValues());
	}
	

	public void validateTheCustomTimeLine(String period)
	{
		page.waitForTimeout(1000);
		page.waitForURL("**/apm/dashboard/endpoint/endpoint-graph");
		util.validateCustomTimeLine(page,loadXaxisValues,period,allWidgetXValues());
	}
	
	public void navigateToEndpointWidgetPageByClickOnTheFirstEndPoint()
	{
		String expectedTitle = page.locator(endPointsColumnData).first().textContent().trim();
		page.locator(endPointsColumnData).first().click();
		
		//validate the URL
		String expectedUrl="**/apm/dashboard/endpoint/endpoint-graph";
		page.waitForURL(expectedUrl);
		Assert.assertTrue(page.url().endsWith("/apm/dashboard/endpoint/endpoint-graph"));
		
		//validate the title
		page.waitForSelector(endPointPageTitle);
		System.out.println(expectedTitle +"---------"+page.locator(endPointPageTitle).textContent().trim());
		Assert.assertTrue(expectedTitle.equalsIgnoreCase(page.locator(endPointPageTitle).textContent().trim()));
		
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
		String expectedUrl="**/apm/dashboard/endpoint/endpoint-graph";
		util.graphZoomIn(page, loadGraphZoomIn, loadGraphReset, allWidgetXPoints());
	}
	
	public void validateLoadZoomOut()
	{
		String expectedUrl="**/apm/dashboard/endpoint/endpoint-graph";
		util.graphZoomOut(page, loadGraphZoomIn,loadGraphZoomOut, loadGraphReset, allWidgetXPoints());
	}
	
	public void validateLoadZoomReset()
	{
		String expectedUrl="**/apm/dashboard/endpoint/endpoint-graph";
		util.graphZoomReset(page, loadGraphZoomIn, loadGraphReset, allWidgetXPoints());
	}
	
	public void validateLoadDragDrop()
	{
		String expectedUrl="**/apm/dashboard/endpoint/endpoint-graph";
		util.graphZoomInByDragAndDrop(page, loadGraphXaxisLines, loadGraphReset, allWidgetXPoints());
	}
	
	public void validateLoadTooltipTitle() throws InterruptedException
	{
		String expectedUrl="**/apm/dashboard/endpoint/endpoint-graph";
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
		String expectedUrl="**/apm/dashboard/endpoint/endpoint-graph";
		util.graphZoomIn(page, errorGraphZoomIn, errorGraphReset, allWidgetXPoints());
	}
	
	public void validateErrorZoomOut()
	{
		String expectedUrl="**/apm/dashboard/endpoint/endpoint-graph";
		util.graphZoomOut(page, errorGraphZoomIn,errorGraphZoomOut, errorGraphReset, allWidgetXPoints());
	}
	
	public void validateErrorZoomReset()
	{
		String expectedUrl="**/apm/dashboard/endpoint/endpoint-graph";
		util.graphZoomReset(page, errorGraphZoomIn, errorGraphReset, allWidgetXPoints());
	}
	
	public void validatErrorDragDrop()
	{
		String expectedUrl="**/apm/dashboard/endpoint/endpoint-graph";
		util.graphZoomInByDragAndDrop(page, errorGraphXaxisLines, errorGraphReset, allWidgetXPoints());
	}
	
	public void validateErrorTooltipTitle() throws InterruptedException
	{
		String expectedUrl="**/apm/dashboard/endpoint/endpoint-graph";
		util.validateWidgetToolTips(page, errorGraphXaxisLines, errorGraphToolTip);
	}
	
	public void validateErrorLegendsText(String expectedLegends)
	{
		String expectedUrl="**/apm/dashboard/endpoint/endpoint-graph";
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
		String expectedUrl="**/apm/dashboard/endpoint/endpoint-graph";
		util.graphZoomIn(page, responseTimeGraphZoomIn, responseTimeGraphReset, allWidgetXPoints());
	}
	
	public void validateResposeTimeZoomOut()
	{
		String expectedUrl="**/apm/dashboard/endpoint/endpoint-graph";
		util.graphZoomOut(page, responseTimeGraphZoomIn,responseTimeGraphZoomOut, responseTimeGraphReset, allWidgetXPoints());
	}
	
	public void validateResposeTimeZoomReset()
	{
		String expectedUrl="**/apm/dashboard/endpoint/endpoint-graph";
		util.graphZoomReset(page, responseTimeGraphZoomIn, responseTimeGraphReset, allWidgetXPoints());
	}
	
	public void validateResposeTimeDragDrop()
	{
		String expectedUrl="**/apm/dashboard/endpoint/endpoint-graph";
		util.graphZoomInByDragAndDrop(page, responseTimeGraphXaxixLines, responseTimeGraphReset, allWidgetXPoints());
	}
	
	public void validateResposeTimeTooltipTitle() throws InterruptedException
	{
		String expectedUrl="**/apm/dashboard/endpoint/endpoint-graph";
		util.validateWidgetToolTips(page, responseTimeGraphXaxixLines, responseTimeGraphToolTip);
	}
	
	public void validatePercentileResponseTimeTitle(String expectedTitle)
	{
		util.ValidateTheTitle(page.locator(percentileResponseTimeGraphTitle).textContent().trim(), expectedTitle);
	}
	
	public void validatePercentileResponseTimeXaxisTitle(String expectedTitle)
	{
		String expectedUrl="**/apm/dashboard/endpoint/endpoint-graph";
		util.ValidateTheTitle(page.locator(percentileResponseTimeGraphXaxisTitle).textContent().trim(), expectedTitle);
	}
	
	public void validatePercentileResponseTimeYaxisTitle(String expectedTitle)
	{
		String expectedUrl="**/apm/dashboard/endpoint/endpoint-graph";
		util.ValidateTheTitle(page.locator(percentileResponseTimeGraphYaxisTitle).textContent().trim(), expectedTitle);
	}
	
	public void validatePercentileResponseTimeZoomIn()
	{
		String expectedUrl="**/apm/dashboard/endpoint/endpoint-graph";
		util.graphZoomIn(page, percentileResponseTimeGraphZoomIn, percentileResponseTimeGraphReset, allWidgetXPoints());
	}
	
	public void validatePercentileResponseTimeZoomOut()
	{
		String expectedUrl="**/apm/dashboard/endpoint/endpoint-graph";
		util.graphZoomOut(page, percentileResponseTimeGraphZoomIn,percentileResponseTimeGraphZoomOut, percentileResponseTimeGraphReset, allWidgetXPoints());
	}
	
	public void validatePercentileResponseTimeZoomReset()
	{
		String expectedUrl="**/apm/dashboard/endpoint/endpoint-graph";
		util.graphZoomReset(page, percentileResponseTimeGraphZoomIn, percentileResponseTimeGraphReset, allWidgetXPoints());
	}
	
	public void validatePercentileResponseTimeDragDrop()
	{
		String expectedUrl="**/apm/dashboard/endpoint/endpoint-graph";
		util.graphZoomInByDragAndDrop(page, percentileResponseTimeGraphXaxisLines, percentileResponseTimeGraphReset, allWidgetXPoints());
	}
	
	public void validatePercentileResponseTimeTooltipTitle() throws InterruptedException
	{
		String expectedUrl="**/apm/dashboard/endpoint/endpoint-graph";
		util.validateWidgetToolTips(page,percentileResponseTimeGraphXaxisLines, percentileResponseTimeGraphToolTip);
	}
	
	public void validateWidgetLegendsForPercentailResposeTimeGraph(String expectedLegends)
	{
		String expectedUrl="**/apm/dashboard/endpoint/endpoint-graph";
		util.validateWidgetLegendsText(page,percentileResponseTimeGraphLegendsList,expectedLegends );
	}
	
	public void validatepercentileResponseTimewidgetLegends()
	{
		String expectedUrl="**/apm/dashboard/endpoint/endpoint-graph";
		util.validateWidgetLegends(page, percentileResponseTimeGraphLegendsList, percentileResponseTimeGraphLegendsColorList,percentileResponseTimeGraphlegendsLineList ,percentileResponseTimeGraphToolTipColorList ,percentileResponseTimeGraphXaxisLines,percentileResponseTimeGraphActiveToolTipText);
	}
	


	public void selectApplication() throws EncryptedDocumentException, IOException
	{
		String application = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.apmApplicationSheet, "application");
		util.selectTheOptionFromDropDownBySearch(page, selectApplicationDropdown, selectAppSearchBox, application, selectAppSearchResult);
		//System.out.println(application);
	}
	
	public void navigateToEndpointPage()
	{
		page.click(endpointTab);
		page.mouse().wheel(0, 0);
	}
	
	
}