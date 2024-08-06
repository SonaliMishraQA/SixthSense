package genericUtilities;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Locator.HoverOptions;

public class GenericMethods {
	
	 JavaUtility jutil=new JavaUtility();
	 ExcelUtility eutil=new ExcelUtility();
	 
	 /**
	 * This method clicks on ZoomIn button of specified graph and checks for the ZoomIn functionality by validating the X axis points of all the graphs in the page.
	 * Along with functionality of ZoomIn button, this method checks for the synchronization of all the graphs in the page.
	 * @param page
	 * @param zoomInBtn
	 * @param zoomResetBtn
	 * @param xPoints : X-axis points of all the graphs in the page in List<String> format
	 * @throws InterruptedException
	 */
	public void graphZoomIn(Page page, String zoomInBtn, String zoomResetBtn, List<String> xPoints) {
	    page.waitForSelector(zoomResetBtn);
	    page.waitForTimeout(2000);
	    List<Integer> count = new ArrayList<>();
	    for (String xPoint : xPoints) {
	    Locator points = (page.locator(xPoint));
	    count.add(points.count());
	    }
	    
	    page.click(zoomInBtn);
	    List<Integer> count1 = new ArrayList<>();
	    for (String xPoint : xPoints) {
	    Locator points = (page.locator(xPoint));
	    count1.add(points.count());
	    }
	   
	    for(int i=0; i<count.size(); i++){
	    Assert.assertTrue(count.get(i)>=count1.get(i));
	    }
	   
	    page.click(zoomInBtn);
	    List<Integer> count2 = new ArrayList<>();
	    for (String xPoint : xPoints) {
	    Locator points = (page.locator(xPoint));
	    count2.add(points.count());
	    }
	   
	    for(int i=0; i<count1.size(); i++){
	    Assert.assertTrue(count1.get(i)>=count2.get(i));
	    }
	   
	    page.click(zoomResetBtn);
	 }
	
	
	
	/**
	 * This method clicks on ZoomOut button of specified graph and checks for the ZoomOut functionality by validating the X axis points of all the graphs in the page.
	 * Along with functionality of ZoomOut button, this method checks for the synchronization of all the graphs in the page.
	 * @param page
	 * @param zoomInBtn
	 * @param zoomOutBtn
	 * @param zoomResetBtn
	 * @param xPoints : X-axis points of all the graphs in the page in List<String> format
	 * @throws InterruptedException
	 */
	public void graphZoomOut(Page page, String zoomInBtn, String zoomOutBtn, String zoomResetBtn, List<String> xPoints) {
		page.waitForSelector(zoomResetBtn);
		page.waitForTimeout(2000);
	    page.click(zoomInBtn);
	    page.click(zoomInBtn);
	    page.click(zoomInBtn);
	   
	    List<Integer> count = new ArrayList<>();
	    for (String xPoint : xPoints) {
	    Locator points = (page.locator(xPoint));
	    count.add(points.count());
	    }
	   
	    page.click(zoomOutBtn);
	   
	    List<Integer> count1 = new ArrayList<>();
	    for (String xPoint : xPoints) {
	    Locator points = (page.locator(xPoint));
	    count1.add(points.count());
	    }
	   
	    for(int i=0; i<count.size(); i++){
	    Assert.assertTrue(count.get(i)<=count1.get(i));
	    }
	   
	    page.click(zoomOutBtn);
	    List<Integer> count2 = new ArrayList<>();
	    for (String xPoint : xPoints) {
	    Locator points = (page.locator(xPoint));
	    count2.add(points.count());
	    }
	   
	    for(int i=0; i<count1.size(); i++){
	    Assert.assertTrue(count1.get(i)<=count2.get(i));
	    }
	   
	    page.click(zoomResetBtn);
	 }
	
	/**
	 * This method clicks on ZoomReset button of specified graph and checks for the ZoomReset functionality by validating the X axis points of all the graphs in the page.
	 * Along with functionality of ZoomReset button, this method checks for the synchronisation of all the graphs in the page.
	 * @param page
	 * @param zoomInBtn
	 * @param zoomResetBtn
	 * @param xPoints : X-axis points of all the graphs in the page in List<String> format
	 * @throws InterruptedException
	 */
	public void graphZoomReset(Page page, String zoomInBtn, String zoomResetBtn, List<String> xPoints) {
		page.waitForSelector(zoomResetBtn);
		 page.waitForTimeout(2000);
	    List<Integer> count = new ArrayList<>();
	    for (String xPoint : xPoints) {
	    Locator points = (page.locator(xPoint));
	    count.add(points.count());
	    }
	    page.click(zoomInBtn);
	    page.click(zoomInBtn);
	   
	    List<Integer> count1 = new ArrayList<>();
	    for (String xPoint : xPoints) {
	    Locator points = (page.locator(xPoint));
	    count1.add(points.count());
	    }
	   
	    for(int i=0; i<count.size(); i++){
	    Assert.assertTrue(count.get(i)>=count1.get(i));
	    }
	   
	    page.click(zoomResetBtn);
	    List<Integer> count2 = new ArrayList<>();
	    for (String xPoint : xPoints) {
	    Locator points = (page.locator(xPoint));
	    count2.add(points.count());
	    }
	   
	    for(int i=0; i<count.size(); i++){
	    Assert.assertTrue(count.get(i)==count2.get(i));
	    }
	 }
	
	/**
	 * This method clicks on ZoomIn button of specified graph and checks for the
	 * ZoomIn functionality by validating the X axis points for single graph in the
	 * page. Along with functionality of ZoomIn button.
	 * 
	 * @param page
	 * @param zoomInBtn
	 * @param xPoint
	 */
	public void graphZoomIn(Page page, String zoomInBtn, String xPoint) {
		page.waitForTimeout(2000);

		Locator point = page.locator(xPoint);
		int stage1 = point.count();
		page.waitForTimeout(2000);
		page.click(zoomInBtn);

		Locator point1 = page.locator(xPoint);
		int stage2 = point1.count();
		page.waitForTimeout(2000);
		Assert.assertTrue(stage1 >= stage2);

		page.click(zoomInBtn);
		Locator point2 = (page.locator(xPoint));
		int stage3 = point2.count();
		Assert.assertTrue(stage2 >= stage3);
		page.waitForTimeout(2000);
	}
	
	
	/**
	 * this method recommends for individual Graph
	 * 
	 * This method clicks on ZoomOut button of specified graph and checks for the
	 * ZoomOut functionality by validating the X axis points for the Single graph in
	 * the page. Along with functionality of ZoomOut button, this method checks for
	 * the synchronization of all the graphs in the page.
	 * @param page
	 * @param zoomInBtn
	 * @param zoomOutBtn
	 * @param xPoint
	 */
	public void graphZoomOut(Page page, String zoomInBtn, String zoomOutBtn, String xPoint) {

		page.waitForTimeout(2000);
		page.click(zoomInBtn);
		page.click(zoomInBtn);
		page.click(zoomInBtn);
		Locator point1 = page.locator(xPoint);
		int stage1 = point1.count();

		page.click(zoomOutBtn);

		Locator point2 = (page.locator(xPoint));
		int stage2 = point2.count();

		Assert.assertTrue(stage1 <= stage2);

		page.click(zoomOutBtn);

		Locator point3 = page.locator(xPoint);
		int stage3 = point3.count();

		Assert.assertTrue(stage2 <= stage3);
	}
	
	
	/**
	 * This method validate the graph functionality for Zoom in by Drag and drop on the x-axis points
	 * This method also checks for the synchronisation of all the graphs in the page for Zoom in by Drag and drop.
	 * @param page
	 * @param xaxis
	 * @param zoomResetBtn
	 * @param xPoints : X-axis points of all the graphs in the page in List<String> format
	 * @throws InterruptedException
	 */
	public void graphZoomInByDragAndDrop(Page page, String xaxis, String zoomResetBtn, List<String> xPoints) {
		
		page.waitForTimeout(2000);
		page.waitForSelector(zoomResetBtn);
		page.click(zoomResetBtn);
		
	    HoverOptions hoverOptions=new HoverOptions();
	    hoverOptions.setForce(true);
	    Locator xpnt = page.locator(xaxis);
	    page.waitForTimeout(2000);
	    for(int i= 0 ;i<3;i++)
	    {
	    xpnt.nth(1).hover(hoverOptions);
	    page.mouse().down();
	    xpnt.nth(3).hover(hoverOptions);
	    page.mouse().up();
	    if(xpnt.count()==3)
	    break;
	    else page.locator(zoomResetBtn).click();
	    }
	   
	    for (String xPoint : xPoints) {
	    Locator points = (page.locator(xPoint));
	    System.out.println(points.count());
	    Assert.assertTrue(points.count()==3);
	    }
	    xpnt.nth(1).hover(hoverOptions);
	    page.mouse().down();
	    xpnt.nth(2).hover(hoverOptions);
	    page.mouse().up();

	    for (String xPoint : xPoints) {
		Locator points = (page.locator(xPoint));
		System.out.println(points.count());
		Assert.assertTrue(points.count()==2);
		}
	    page.click(zoomResetBtn);
	    page.click(zoomResetBtn);
	 }
	
	/**
	 * this method will validate the element's text with actual text whether it is page title, graph title, x-axis or y-axis
	 * @param actualTitle
	 * @param expectedTitle
	 */
	
	public void ValidateTheTitle(String actualTitle,String expectedTitle)
	{
		System.out.println(actualTitle + "----------"+expectedTitle);
		Assert.assertEquals(actualTitle.equalsIgnoreCase(expectedTitle),true);
	}
	
	/**
	 * this method will validate the element's text with actual text whether it is page title, graph title, x-axis or y-axis
	 * @param page
	 * @param actualElement
	 * @param expectedTitle
	 */
	
	public void ValidateTheTitle(Page page, String actualElement,String expectedTitle)
	{
		String actualTitle = page.locator(actualElement).textContent().trim();
		System.out.println(actualTitle + "----------"+expectedTitle);
		Assert.assertEquals(actualTitle.equalsIgnoreCase(expectedTitle),true);
	}
	
	public void validateNavigatingToTab(Page page, String actualElement, String expectedTitle)
	{
		String actualTitle = page.locator(actualElement).textContent().trim();
		System.out.println(actualTitle + "----------"+expectedTitle);
	}

	
	/**
	 * this method will validate the widget tool tip titles displaying or not when mouse hover
	 * @param page
	 * @param xAxisLines
	 * @param toolTip
	 * @throws InterruptedException
	 */
	
	public void validateWidgetToolTips(Page page,String xAxisLine, String toolTip)
	{
		Locator xAxisLines = page.locator(xAxisLine);
		page.waitForTimeout(2000);
		HoverOptions hoverOptions=new HoverOptions();
	    hoverOptions.setPosition(2,-15);
	    hoverOptions.setForce(true);
	    page.waitForTimeout(1200);
	    int num=xAxisLines.count();
	    System.out.println(num);
	    for(int i=0;i<num;i++)
		{
	    	xAxisLines.nth(i).hover(hoverOptions);
	    	System.out.println(page.locator(toolTip).textContent());
	    	Assert.assertTrue(!page.locator(toolTip).textContent().isEmpty());
	    }	 
	}
	/**
	 * this method is used to add all the tool tip values and returns integer 
	 * @param page
	 * @param xAxisLines
	 * @param toolTipValue
	 * @return
	 */
	
	public int getTheSummationFromTheWidgetTooltip(Page page,String xAxisLines,String toolTipValue )
	{
		page.waitForLoadState(LoadState.NETWORKIDLE);
		page.waitForTimeout(1500);
	    int num=page.locator(xAxisLines).count();
	    HoverOptions hoverOptions=new HoverOptions();
	    hoverOptions.setForce(true);
	    System.out.println(num);
	    int value=0;int count = 0;
	       for(int i=0;i<num;i++)
			 {
	    	  
	    	   if(count==num-1)
	    	   {
	    	       hoverOptions.setPosition(0,-10);
	    		   page.locator( xAxisLines).nth(i).hover(hoverOptions); 
	    		   System.out.println("last hover done");
	    	   }else
	    	   {
	    	    hoverOptions.setPosition(2,-10);
	    		page.locator( xAxisLines).nth(i).hover(hoverOptions);  
	    	   }
	    	   count++;
	    		page.waitForTimeout(200);
	    		String tooltip= page.locator(toolTipValue).textContent().trim();
		    	try {
					value= value+Integer.parseInt(tooltip);
				} catch (NumberFormatException e) {
					value= value+(int)Double.parseDouble(tooltip);
				}
		    	
	    	 }
	    	 return value;
	}
	
	/**
	 * this method will select an Option from the drop down by searching the option like select application, service, database etc
	 * @param page
	 * @param drop down
	 * @param searchField
	 * @param application
	 * @param searchedApplications
	 */
	
	public void selectTheOptionFromDropDownBySearch(Page page,String dropdown, String searchField,String application,String searchedApplications)
	{
		//select the application from drop down
				page.locator(dropdown).click();
				page.locator(searchField).clear();
				page.locator(searchField).fill(application);
				page.waitForSelector(searchedApplications);
				Locator actualsearchedApplications=page.locator(searchedApplications);				
				for(int i=0;i<actualsearchedApplications.count();i++)
				{ 
					if(actualsearchedApplications.nth(i).textContent().trim().equalsIgnoreCase(application))
					{
						actualsearchedApplications.nth(i).click();
						//page.waitForTimeout(2000);
						break;
					}
				}
	}
	
	/**
	 * this method will select an Option from the drop down by given options
	 * @param page
	 * @param dropdown
	 * @param option
	 */
	
	public void selectTheOptionFromDropDown(Page page,String dropdown, String option)
	{
		//select the option from drop down
		page.locator(dropdown).click();
		System.out.println("click successfully");
		Locator value=page.locator("xpath = //div[@class='option']/descendant::span[text()='"+option+"']");
		value.click();
	}
	
	public void SelectTheMulitpleOptionFromDropDown(Page page, String dropdown, String activeNameMark, List<String> options){
		page.locator(dropdown).click();
		System.out.println("click SuccessFully");
		int count = 1;
		page.waitForTimeout(2000);
		for (int i = 0; i < options.size(); i++) {
			String option = options.get(i);
			System.out.println("//div[@class='option' and text()='" + option + "']");
			Locator value = page.locator("//div[@class='option' and text()='" + option + "']");
			String tickMarkData = " ";
			tickMarkData = tickMarkData + page.locator(activeNameMark).nth(i).getAttribute("style");
			System.out.println("tickMarkData :" + tickMarkData);
			if (tickMarkData.contains("margin")) {
				value.click();
				count++;
				System.out.println("clicked");
			}
			if (count == 4) {
				break;
			}

		}
		page.locator(dropdown).click();
	}
	
	/**
	 * This method is used to validate the search functionality of a page with valid data
	 * @param page
	 * @param firstElement
	 * @param searchTextField
	 * @param searchBtn
	 * @param searchResult
	 */
	public void validateSearchFunctionalityWithValidData(Page page, String firstElement, String searchTextField, String searchBtn, String searchResult) {
		// Pick the first element name from the page table
		String searchData="";
		try{
			searchData = page.textContent(firstElement).trim();
		}
		catch(Exception e) {
			searchData = firstElement;
		}
		System.out.println(searchData);
		// Enter the picked element name in the Search text field and click on Search button
		page.fill(searchTextField, searchData);
		page.click(searchBtn);
		page.waitForTimeout(500);
		page.waitForSelector(searchResult);
		// Validate the search result
		Locator instances = page.locator(searchResult);
		for(int i=0; i<instances.count(); i++ ) {
			String text = instances.nth(i).textContent().trim();
			System.out.println(text);
			Assert.assertTrue(text.contains(searchData));
		}
	}
	
	/**
	 * This method is used to validate the search functionality of a page with invalid data
	 * @param page
	 * @param searchTextField
	 * @param searchBtn
	 * @param noDataIcon
	 */
	public void validateSearchFunctionalityWithInvalidData(Page page, String searchTextField, String searchBtn, String noDataIcon) {
		
		// Enter an invalid data in the Search text field and click on Search button

		page.fill(searchTextField, "a1b2c3d4");
		page.click(searchBtn);
		page.waitForLoadState(LoadState.NETWORKIDLE);
		page.waitForSelector(noDataIcon);
		
		// Validate the search result to be No-Data-Icon
		ElementHandle ele = page.querySelector(noDataIcon);
		Assert.assertTrue(ele.isVisible());
	}
	

	
	/**
	 * This method will validate the selected custom time line is displaying in the widget or not.
	 * This method will validate whether the X-axis labels of all the graphs in the page are same. 
	 * @param page
	 * @param widgetXaxisvalues
	 * @param timePeriod
	 */
	public void validateCustomTimeLine(Page page,String widgetXaxisvalues,String timePeriod,List<String> xValues)
	{
		//fetch the x axis lines and values
		page.waitForSelector(widgetXaxisvalues);
		Locator dateTimeValues = page.locator(widgetXaxisvalues);
		System.out.println(dateTimeValues.count());
		ArrayList<String> list=new ArrayList<String>();
		// format the text to single line if the text in the DOM has multiple lines
		for(int i=0;i<dateTimeValues.count();i++)
		{
			if(timePeriod.contains("min"))
			{	
				try {
						String text=dateTimeValues.nth(i).innerHTML().replace("\n", " ");
						System.out.println(text);
						list.add(text);
				} catch (Exception e) {
			
						list.add(dateTimeValues.nth(i).innerHTML());
				}
			} else{ list.add(dateTimeValues.nth(i).innerHTML()); }	
		}
		
		//get the integer time range from the String parameter
		
		String time="";
		for(int i=0;i<timePeriod.length();i++)
		{
			if(Character.isDigit(timePeriod.charAt(i)))
			{
				time=time+timePeriod.charAt(i);
			}
			
		}
		int num = Integer.parseInt(time);
		String expectedTime1="";
		boolean flag =false;
		
		//validate the time range with widget values for mins , hours and days
		for(int i=0;i<=num;i++)
		{
		if(timePeriod.contains("min"))
		{
			expectedTime1=jutil.getTheCustomeTimeAndDateBasedOnTheCurrentSystemTime("HH:mm MM-dd", i, 0, 0, 0, 0, 0, 0);
		}else if (timePeriod.contains("hour"))
		{
			expectedTime1=jutil.getTheCustomeTimeAndDateBasedOnTheCurrentSystemTime("MM-dd HH", 0, i, 0, 0, 0, 0, 0);
			
		} else if (timePeriod.contains("days"))
		{
			expectedTime1=jutil.getTheCustomeTimeAndDateBasedOnTheCurrentSystemTime("MM-dd", 0, 0, i, 0, 0, 0, 0);
			
		}
		//validate the last time value with current system time
		
			System.out.println("systemTime : "+expectedTime1 + "-------"+list.get(list.size()-1));
			if(list.get(list.size()-1).equalsIgnoreCase(expectedTime1))
			{
				flag=true;
				break;
			}
		}
		Assert.assertEquals(flag, true);
		
		String expectedTime2="";
		//validate the first time value by minus the given time range from the current system time
		if(timePeriod.contains("min"))
		{
			expectedTime2=jutil.getTheCustomeTimeAndDateBasedOnTheCurrentSystemTime("HH:mm MM-dd", num, 0, 0, 0, 0, 0, 0);
			if(list.get(0).equalsIgnoreCase(expectedTime2))
			{
				Assert.assertEquals(list.get(0), expectedTime2);
			}
			else
			{
				Assert.assertEquals(list.get(0), jutil.getTheCustomeTimeAndDateBasedOnTheCurrentSystemTime("HH:mm MM-dd", num+1, 0, 0, 0, 0, 0, 0));
			}
		}else if (timePeriod.contains("hour"))
		{
			expectedTime2=jutil.getTheCustomeTimeAndDateBasedOnTheCurrentSystemTime("MM-dd HH", 0, num, 0, 0, 0, 0, 0);
			if(list.get(0).equalsIgnoreCase(expectedTime2))
			{
				Assert.assertEquals(list.get(0), expectedTime2);
			}
			else
			{
				Assert.assertEquals(list.get(0), jutil.getTheCustomeTimeAndDateBasedOnTheCurrentSystemTime("MM-dd HH", 0, num+1, 0, 0, 0, 0, 0));
			}
			
		} else if (timePeriod.contains("days"))
		{
			expectedTime2=jutil.getTheCustomeTimeAndDateBasedOnTheCurrentSystemTime("MM-dd", 0, 0, num, 0, 0, 0, 0);
			Assert.assertEquals(list.get(0), expectedTime2);	
		}
		
		//validate all the graphs x axis values
				page.waitForSelector(xValues.get(0));
				Locator num1 = page.locator(xValues.get(0));
				System.out.println("Count : "+num1.count());
				for(int i=0; i<num1.count(); i++)
				{
					String text = num1.nth(i).innerHTML();
					System.out.println(text);
					for(String lab : xValues) {
						System.out.println(page.locator(lab).nth(i).innerHTML());
						Assert.assertTrue(page.locator(lab).nth(i).innerHTML().equalsIgnoreCase(text));
					}
				}
	}
	
	/**
	 * This method is used to validate the widget first and last time, with the system time for given time line
	 *  This method will validate whether the X-axis labels of all the graphs in the page are same. 
	 * @param widgetXaxisvalues
	 * @param minutes
	 * @param hours
	 * @param days
	 * @param format
	 */
	
	public void validateTheTimeLine(Page page,String widgetXaxisvalues,int minutes,int hours,int days,String format,String calanderValue,List<String> xValues)
	{
		
		page.waitForSelector(widgetXaxisvalues);
		Locator dateTimeValues = page.locator(widgetXaxisvalues);
		System.out.println(dateTimeValues.count());
		ArrayList<String> list=new ArrayList<String>();
		for(int i=0;i<dateTimeValues.count();i++)
		{
			if(calanderValue.contains("min"))
			{	
				try {
						String text=dateTimeValues.nth(i).innerHTML().replace("\n", " ");
						System.out.println(text);
						list.add(text);
				} catch (Exception e) {
			
						list.add(dateTimeValues.nth(i).innerHTML());
				}
			} else{ list.add(dateTimeValues.nth(i).innerHTML()); }
	}
		
		Boolean flag =false;
		int num=0;
		if(minutes!=0)
		{
			num=minutes;
		}else if (hours!=0)
		{
			num=hours;
		}else if (days !=0)
		{
			num=days;
		}
		String expectedTime1="";
		for(int i=0;i<=num;i++)
		{
			if(minutes!=0)
			{
				 expectedTime1=jutil.getTheCustomeTimeAndDateBasedOnTheCurrentSystemTime(format, i, 0, 0, 0, 0, 0, 0);
			}else if (hours!=0)
			{
				 expectedTime1=jutil.getTheCustomeTimeAndDateBasedOnTheCurrentSystemTime(format, 0, i, 0, 0, 0, 0, 0);
			}else if (days !=0)
			{
				 expectedTime1=jutil.getTheCustomeTimeAndDateBasedOnTheCurrentSystemTime(format, 0, 0, i, 0, 0, 0, 0);
			}
			System.out.println("systemTime : "+expectedTime1 + "-------"+list.get(list.size()-1));
			if(list.get(list.size()-1).equalsIgnoreCase(expectedTime1))
			{
				flag=true;
				break;
			}
		}
		Assert.assertEquals(flag, true);
		String expectedTime2=jutil.getTheCustomeTimeAndDateBasedOnTheCurrentSystemTime(format, minutes, hours, days, 0, 0, 0, 0);
		if(list.get(0).equalsIgnoreCase(expectedTime2))
		{
			Assert.assertEquals(list.get(0), expectedTime2);
		}
		else
		{
			if(minutes!=0) {
			Assert.assertEquals(list.get(0), jutil.getTheCustomeTimeAndDateBasedOnTheCurrentSystemTime(format, minutes+1, hours, days, 0, 0, 0, 0));
			}
			else if(hours != 0 )
			{
				Assert.assertEquals(list.get(0), jutil.getTheCustomeTimeAndDateBasedOnTheCurrentSystemTime(format, minutes, hours+1, days, 0, 0, 0, 0));
			}
			else 
			{
				Assert.assertEquals(list.get(0), expectedTime2);
			}
		}
		
		//validate all the graphs x axis values
		page.waitForSelector(xValues.get(0));
		Locator num1 = page.locator(xValues.get(0));
		System.out.println("Count : "+num1.count());
		for(int i=0; i<num1.count(); i++)
		{
			String text = num1.nth(i).innerHTML();
			System.out.println(text);
			for(String lab : xValues) {
				System.out.println(page.locator(lab).nth(i).innerHTML());
				Assert.assertTrue(page.locator(lab).nth(i).innerHTML().equalsIgnoreCase(text));
			}
		}
		
	}
	
	/**
	 * this method is used to validate the different time lines like 5 minutes, 3 hrs, 1week etc
	 * @param widgetXaxisvalues
	 */
	
	public void validateTheGraphdisplayingTheDataAsPerGivenTimeLines(Page page,String widgetXaxisvalues,String calanderValue,List<String> xValues)
	{

		String calenValue=page.locator(calanderValue).textContent().trim();

		
		if(calenValue.equalsIgnoreCase("5 mins"))
		{
			validateTheTimeLine(page,widgetXaxisvalues,5,0,0,"HH:mm MM-dd",calenValue,xValues);
		}
		else if (calenValue.equalsIgnoreCase("15 mins"))
		{
			validateTheTimeLine(page,widgetXaxisvalues,15,0,0,"HH:mm MM-dd",calenValue,xValues);
			
		}else if(calenValue.equalsIgnoreCase("30 mins"))
		{
			validateTheTimeLine(page,widgetXaxisvalues,30,0,0,"HH:mm MM-dd",calenValue,xValues);
			
		}else if(calenValue.equalsIgnoreCase("60 mins"))
		{
			validateTheTimeLine(page,widgetXaxisvalues,60,0,0,"HH:mm MM-dd",calenValue,xValues);
			
		}else if(calenValue.equalsIgnoreCase("3 hours"))
		{
			validateTheTimeLine(page,widgetXaxisvalues,0,3,0,"MM-dd HH",calenValue,xValues);
			
		}else if(calenValue.equalsIgnoreCase("6 hours"))
		{
			validateTheTimeLine(page,widgetXaxisvalues,0,6,0,"MM-dd HH",calenValue,xValues);
			
		}else if(calenValue.equalsIgnoreCase("12 hours"))
		{
			validateTheTimeLine(page,widgetXaxisvalues,0,12,0,"MM-dd HH",calenValue,xValues);
			
		}else if (calenValue.equalsIgnoreCase("1 day"))
		{
			validateTheTimeLine(page,widgetXaxisvalues,0,24,0,"MM-dd HH",calenValue,xValues);
			
		}else if (calenValue.equalsIgnoreCase("1 week"))
		{
			validateTheTimeLine(page,widgetXaxisvalues,0,0,7,"MM-dd",calenValue,xValues);
			
		}else if (calenValue.equalsIgnoreCase("1 month"))
		{
			validateTheTimeLine(page,widgetXaxisvalues,0,0,30,"MM-dd",calenValue,xValues);
			
		}
	}
	
	public String getvalueFromexcel(String fileName,String sheetName,String key) throws EncryptedDocumentException, IOException
	{
		String data=eutil.ReadDataFromExcelByUsingKeyProperty(fileName,sheetName, key);
		return data;
	}
	
	
	
	public void validateWidgetLegendsText(Page page,String actualLegends, String expectedLegends)
	{
		String[] legends=expectedLegends.split(",");
		for(int i=0;i<page.locator(actualLegends).count();i++)
		{
			System.out.println(page.locator(actualLegends).nth(i).textContent() +"\t"+legends[i]);
			Assert.assertTrue(page.locator(actualLegends).nth(i).textContent().contains(legends[i]));
		}
	}
	
	/**
	 * this method is used to validate the legends and their respective tool tips text and colours of widget 
	 * @param page
	 * @param legendsList
	 * @param legendsColorList
	 * @param LegendLine
	 * @param widgetToolTipColorList
	 * @param xAxisLines
	 * @param activeToolTipText
	 * @throws InterruptedException
	 */
	public void validateWidgetLegends(Page page,String legendsList,String legendsColorList, String LegendLine,String widgetToolTipColorList,String xAxisLines,String activeToolTipText)
	{
		//fetch the legend elements
		Locator legends=page.locator(legendsList);
		System.out.println(legends.count());
		//fetch the xaxis line of widget
		Locator xAxisPoints = page.locator( xAxisLines);
		page.waitForTimeout(1000);
		//set the hover settings
		HoverOptions hoverOptions=new HoverOptions();
	    hoverOptions.setPosition(2,-15);
	    hoverOptions.setForce(true);
	    
	    //disable all the legends
		for(int i=0;i<legends.count();i++)
		{
			//fetch the legend text
			 String legendText=legends.nth(i).textContent();
			 //mouse over to the widget to get tool tip
			 xAxisPoints.first().hover(hoverOptions);
			 page.waitForTimeout(200);
			 //fetch the tool tip text
			 String expectedText = page.locator(activeToolTipText).nth(i).innerHTML();
			 //Validate the tool tip text with legends text
			 System.out.println(legendText+"\t"+expectedText);
			 Assert.assertTrue(legendText.equalsIgnoreCase(expectedText));
			 //click on the legend to disable the from the graph
			 legends.nth(i).click();
		}
		
		//enable one by one legends
		for(int i=0;i<legends.count();i++)
		{
			//enable the legends by clicking it
			 legends.nth(i).click();
		    // mouse over to the widget to get tool tip colour
		     xAxisPoints.first().hover(hoverOptions);
		     //fetch the legends colour
		     String expectedcolor = (String) page.locator(legendsColorList).nth(i).evaluate("element => getComputedStyle(element).color");
		     expectedcolor = expectedcolor.substring(expectedcolor.indexOf('(')+1,expectedcolor.indexOf(')'));
		     //fetch the tool tip colour
		  	 String actualColor = (String) page.locator(widgetToolTipColorList).nth(i).evaluate("element => getComputedStyle(element).background");
		  	 //fetch the widget x axis line colour 
		  	 String lineColor = (String) page.locator(LegendLine).evaluate("element => getComputedStyle(element).stroke");
		  
			 System.out.println("expectedcolor: "+ expectedcolor+"------- actualColor: "+actualColor+ "------------ line color :"+lineColor);
			 //Validate whether all 3 colours are same or not
			 Assert.assertTrue(actualColor.contains(expectedcolor));
			 Assert.assertTrue(lineColor.contains(expectedcolor));
			 //disable the graph
			 legends.nth(i).click();
		}
		
	}
	
	public void validateWidgetLegends(Page page,String legendsList,String legendsColorList, String LegendLine,String widgetToolTipColorList,String xAxisLines,String activeToolTipText,String[] actualText) throws InterruptedException
	{
		page.waitForSelector(legendsList);
		Locator legends=page.locator(legendsList);
		System.out.println(legends.count());
		Locator xAxisPoints = page.locator( xAxisLines);
		page.waitForTimeout(1000);
		HoverOptions hoverOptions=new HoverOptions();
		hoverOptions.setPosition(2,-15);
	    hoverOptions.setForce(true);
		for(int i=0;i<legends.count();i++)
		{
			xAxisPoints.first().hover(hoverOptions);
			String expectedText = page.locator(activeToolTipText).nth(i).innerHTML();
			Assert.assertTrue(expectedText.contains(actualText[i]));
			legends.nth(i).click();
		}
		
		//enable one by one legends
		for(int i=0;i<legends.count();i++)
		{
			//enable the legends by clicking it
			legends.nth(i).click();
			// mouse over to the widget to get tool tip colour
			xAxisPoints.first().hover(hoverOptions);
			//fetch the legends colour
			String expectedcolor = (String) page.locator(legendsColorList).nth(i).evaluate("element => getComputedStyle(element).color");
			//fetch the tool tip colour
			String actualColor = (String) page.locator(widgetToolTipColorList).nth(i).evaluate("element => getComputedStyle(element).background");
			//fetch the widget x axis line colour 
			String lineColor = (String) page.locator(LegendLine).evaluate("element => getComputedStyle(element).stroke");
				  
			System.out.println("expectedcolor: "+ expectedcolor+"------- actualColor: "+actualColor+ "------------ line color :"+lineColor);
			//Validate whether all 3 colours are same or not
			Assert.assertTrue(actualColor.contains(expectedcolor));
			Assert.assertTrue(lineColor.contains(expectedcolor));
			//disable the graph
			legends.nth(i).click();
		}
	}
		
	/**
	 * This method sorts the column in ascending order and validate the column data.
	 * This method validates only the columns with numeric data
	 * @param page
	 * @param ascending
	 * @param columnData
	 */
	public void sortTheColumnInAscendingOrderAndValidateTheColumnData(Page page, String ascending, String columnData) {

		page.click(ascending);
		page.waitForTimeout(1000);
		page.waitForSelector(columnData);
		Locator data = page.locator(columnData);
		page.waitForTimeout(500);
		int firstLoad;
		int secondLoad;
		for(int i=0; i<data.count()-1; i++)
		{
			String load = data.nth(i).textContent();
			String load1 = data.nth(i+1).textContent();
			
			if(load.contains("k"))
			{
				load = data.nth(i).textContent().replace("k", "");
				String[] num = load.split("\\.");
				if(Integer.parseInt(num[1])>=10)
				firstLoad = Integer.parseInt(num[0]+"000")+Integer.parseInt(num[1]+"0");
				else
				firstLoad = Integer.parseInt(num[0]+"000")+Integer.parseInt(num[1]+"00");
			}
			else if(load.contains("m"))
			{
				load = data.nth(i).textContent().replace("m", "");
				String[] num = load.split("\\.");
				if(Integer.parseInt(num[1])>=10)
				firstLoad = Integer.parseInt(num[0]+"000000")+Integer.parseInt(num[1]+"0000");
				else
				firstLoad = Integer.parseInt(num[0]+"000000")+Integer.parseInt(num[1]+"00000");
			}
			else {
				firstLoad = Integer.parseInt(load);
			}
			
			if(load1.contains("k"))
			{
				load1 = data.nth(i).textContent().replace("k", "");
				String[] num1 = load1.split("\\.");
				if(Integer.parseInt(num1[1])>=10)
				secondLoad = Integer.parseInt(num1[0]+"000")+Integer.parseInt(num1[1]+"0");
				else
				secondLoad = Integer.parseInt(num1[0]+"000")+Integer.parseInt(num1[1]+"00");
			}
			else if(load1.contains("m"))
			{
				load = data.nth(i).textContent().replace("m", "");
				String[] num1 = load.split("\\.");
				if(Integer.parseInt(num1[1])>=10)
				secondLoad = Integer.parseInt(num1[0]+"000000")+Integer.parseInt(num1[1]+"0000");
				else
				secondLoad = Integer.parseInt(num1[0]+"000000")+Integer.parseInt(num1[1]+"00000");
			}
			else {
				secondLoad = Integer.parseInt(load1);
			}
			Assert.assertTrue(firstLoad <= secondLoad);
		}
	}
	
	/**
	 * This method sorts the column in descending order and validate the column data.
	 * This method validates only the columns with numeric data
	 * @param page
	 * @param descending
	 * @param columnData
	 */
	public void sortTheColumnInDescendingOrderAndValidateTheColumnData(Page page, String descending, String columnData) {
		page.click(descending);
		page.waitForSelector(columnData);
		page.waitForTimeout(300);
		Locator data = page.locator(columnData);
		int firstLoad;
		int secondLoad;
		for(int i=0; i<data.count()-1; i++)
		{
			String load = data.nth(i).textContent();
			String load1 = data.nth(i+1).textContent();
			
			if(load.contains("k"))
			{
				load = data.nth(i).textContent().replace("k", "");
				String[] num = load.split("\\.");
				if(Integer.parseInt(num[1])>=10)
				firstLoad = Integer.parseInt(num[0]+"000")+Integer.parseInt(num[1]+"0");
				else
				firstLoad = Integer.parseInt(num[0]+"000")+Integer.parseInt(num[1]+"00");
			}
			else if(load.contains("m"))
			{
				load = data.nth(i).textContent().replace("m", "");
				String[] num = load.split("\\.");
				if(Integer.parseInt(num[1])>=10)
				firstLoad = Integer.parseInt(num[0]+"000000")+Integer.parseInt(num[1]+"0000");
				else
				firstLoad = Integer.parseInt(num[0]+"000000")+Integer.parseInt(num[1]+"00000");
			}
			else {
				firstLoad = Integer.parseInt(load);
			}
			
			if(load1.contains("k"))
			{
				load1 = data.nth(i).textContent().replace("k", "");
				String[] num1 = load1.split("\\.");
				if(Integer.parseInt(num1[1])>=10)
				secondLoad = Integer.parseInt(num1[0]+"000")+Integer.parseInt(num1[1]+"0");
				else
				secondLoad = Integer.parseInt(num1[0]+"000")+Integer.parseInt(num1[1]+"00");
			}
			else if(load1.contains("m"))
			{
				load = data.nth(i).textContent().replace("m", "");
				String[] num1 = load.split("\\.");
				if(Integer.parseInt(num1[1])>=10)
				secondLoad = Integer.parseInt(num1[0]+"000000")+Integer.parseInt(num1[1]+"0000");
				else
				secondLoad = Integer.parseInt(num1[0]+"000000")+Integer.parseInt(num1[1]+"00000");
				}
			else {
				secondLoad = Integer.parseInt(load1);
			}
			Assert.assertTrue(firstLoad >= secondLoad);
		}
	}
	
	/**
	 * This methods returns the Average Response time capturing the tool tips from Response time graph and Load graph and 
	 * @param page
	 * @param respTimeGraphXaxisPoints
	 * @param respTimeGraphTooltip
	 * @param loadGraphTooltip
	 * @return
	 */
	public int getAverageResponseTimeFromGraphTooltip(Page page, String respTimeGraphXaxisPoints, String respTimeGraphTooltip, String loadGraphTooltip) {
		HoverOptions hoverOptions=new HoverOptions();
	    hoverOptions.setPosition(2,-10);
	    hoverOptions.setForce(true);
	    Locator xaxis = page.locator(respTimeGraphXaxisPoints);
	    int load = 0;
	    int sum = 0;
	    for(int i=0;i<xaxis.count();i++)
		{
	    	xaxis.nth(i).hover(hoverOptions);  
	    	page.waitForTimeout(100);
	    	String tooltip= page.locator(respTimeGraphTooltip).textContent().trim();
	    	sum= sum+Integer.parseInt(tooltip);
	    	
	    	int loadTooltip;
			try {
				loadTooltip = Integer.parseInt(page.locator(loadGraphTooltip).textContent().trim());
			} catch (NumberFormatException e) {
				loadTooltip = (int)Double.parseDouble(page.locator(loadGraphTooltip).textContent().trim());
			}
	    	
	    	if(loadTooltip > 0) {
	    		load = load+1;
	    	}
		}
	    
	    return sum/load;
	}
	
	
	
	
	
	

	/**
	 * This method is used to validate the text Functions for the expanded View like
	 * Xaxis title,Yaxis Title,WidgetTitles,legendHeaders
	 * 
	 * @param expectedTitle
	 */
	public void validateExpandViewTexts(Page page, String expectedTextLocator, String expandViewBtn, String expandViewCloseBtn, String expandViewLocator) 
	{
		page.waitForTimeout(1000);
		String expectedTitle = page.locator(expectedTextLocator).textContent().trim();
		page.locator(expandViewBtn).click();
		page.waitForTimeout(1000);
		Locator titles = page.locator(expandViewLocator);
		if (titles.count() == 2)
		{
			for (int i = 0; i < titles.count(); i++)
			{
				String actualTitle = titles.nth(i).textContent().trim();
				System.out.println(actualTitle + "<--->" + expectedTitle);
				Assert.assertEquals(actualTitle, expectedTitle, "Failed in " + i + "th iteration");
			}
		} else {
			String actualTitle = titles.textContent().trim();
			System.out.println(actualTitle + "<--->" + expectedTitle);
			Assert.assertEquals(actualTitle, expectedTitle);
		}
		page.locator(expandViewCloseBtn).click();
	}

	public void ExpandViewZoomInBtn(Page page, String expandZoomInBtn, String expandViewBtn, String expandViewCloseBtn, String Xpoint) 
	{
		page.locator(expandViewBtn).click();
		GenericMethods util = new GenericMethods();
		util.graphZoomIn(page, expandZoomInBtn, Xpoint);
		page.locator(expandViewCloseBtn).click();
	}

	public void ExpandViewZoomOutBtn(Page page,String expandZoomInBtn, String expandViewBtn, String expandViewCloseBtn, String expandZoomOutbtn, String Xpoint) 
	{
		page.locator(expandViewBtn).click();
		GenericMethods util = new GenericMethods();
		util.graphZoomOut(page, expandZoomInBtn, expandZoomOutbtn, Xpoint);
		page.locator(expandViewCloseBtn).click();
	}
	public void ExpandViewWidgetDragDrop(Page page,String expandBtn,String ExpandViewCloseBtn,String XaxisLines,String ZoomOutBtn,String XPoint)
	{
		page.locator(expandBtn).click();
		GenericMethods util = new GenericMethods();
		util.graphZoomInByDragAndDrop(page, XaxisLines, ZoomOutBtn, XPoint);
		page.locator(ExpandViewCloseBtn).click();
	}

	
	
	/**
	 * This method validates the graph functionality for Zoom in by Drag and drop on
	 * the x-axis points 
	 * This method Checks Only for the Particular Graph
	 * 
	 * @param page
	 * @param xaxis
	 * @param ZoomOutBtn
	 * @param xPoint
	 */
	public void graphZoomInByDragAndDrop(Page page, String xaxis, String ZoomOutBtn, String xPoint) 
	{
		page.waitForTimeout(2000);

		HoverOptions hoverOptions = new HoverOptions();
		hoverOptions.setForce(true);
		Locator xpnt = page.locator(xaxis);
		page.waitForTimeout(2000);
		for (int i = 0; i < 3; i++) {
			xpnt.nth(1).hover(hoverOptions);
			page.mouse().down();
			xpnt.nth(3).hover(hoverOptions);
			page.mouse().up();
			if (xpnt.count() == 3) {
				break;
			} else {
				System.out.println("Retrying ");
			}
		}

		Locator points = page.locator(xaxis);
		System.out.println(points.count());
		Assert.assertTrue(points.count() == 3);
		page.waitForTimeout(3000);
		xpnt.nth(1).hover(hoverOptions);
		page.mouse().down();
		xpnt.nth(2).hover(hoverOptions);
		page.mouse().up();
		page.waitForTimeout(3000);
		Locator points1 = (page.locator(xaxis));
		System.out.println(points1.count());
		Assert.assertTrue(points1.count() == 2);
		page.locator(ZoomOutBtn).click();
		page.locator(ZoomOutBtn).click();
	}
	
	
	
	
	
	
	
	
	
	
	
	

	
	public void widgetLegendNameSort(Page page,String widgetLegendSortIcon,String WidgetLegendCountLocator) throws InterruptedException 
	{
		List<String> beforeSort = legendNamesList(page,WidgetLegendCountLocator);
		page.locator(widgetLegendSortIcon).click();
		page.waitForTimeout(2000);
		List<String> afterSort = legendNamesList(page,WidgetLegendCountLocator);
		TreeSet<String> alphaOrder = new TreeSet<String>(afterSort);
		if (beforeSort.size() == afterSort.size()) {
			for (int i = 0; i < beforeSort.size(); i++) {
				System.out.println(beforeSort.get(i) + "-------" + afterSort.get(i));
				if (beforeSort.get(i).equals(afterSort.get(i))) {
					Assert.fail("comparision Failed for sorting");
				}
			}
		}
		int i = 0;
		for (String order : alphaOrder) {
			if (!(order.equals(afterSort.get(i++)))) {
				Assert.fail("alphabetical Order Failed");
			}
		}
	}
	
	
	public List<String> legendNamesList(Page page,String WidgetLegendCountLocator) {
		ArrayList<String> list = new ArrayList<String>();
		Locator names = page.locator(WidgetLegendCountLocator);
		for (int i = 0; i < names.count(); i++) {
			list.add(names.nth(i).textContent().trim());
		}
		return list;
	}
	
	
	
	
	
	
	
}