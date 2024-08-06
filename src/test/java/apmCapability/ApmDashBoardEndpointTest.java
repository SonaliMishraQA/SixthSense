package apmCapability;

import org.testng.annotations.Test;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import genericUtilities.ExcelUtility;
import genericUtilities.GenericMethods;
import genericUtilities.IPathConstant;
import objectRepository.CommonPage;
import objectRepository.HomePage;
import objectRepository.APM.ApmApplicationPage;
import objectRepository.APM.ApmEndpointPage;
import playWrightFactory.BaseClass;

public class ApmDashBoardEndpointTest extends BaseClass{
	
	GenericMethods util;
	ApmEndpointPage endPage;
	ExcelUtility eutil;
	ApmApplicationPage appPage;
	
	@BeforeMethod
	public void preRequest() throws EncryptedDocumentException, IOException
	{
		eutil=new ExcelUtility();
		endPage = new ApmEndpointPage(page);
		commPage = new CommonPage(page);
		appPage=new ApmApplicationPage(page);
		
		//Navigate to APM capability
		commPage.navigateToApm();
		
		//navigate to dashboard page
		appPage.navigateToDashBoardTab();
		
		//navigate to endPage page
		endPage.navigateToEndpointPage();
	
		//select the Time line 
		commPage.selectTheTimeLineFromCalender(IPathConstant.oneMonthTimeRange);
		
		//select the Application
		appPage.selectTheApplicationForAPM(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.apmApplicationSheet, "application"));
		
	}
	
	@Test(groups = {"APM","UI","Regression"})
	public void TC_01_validate_The_Endpoint_Page_Displayed_Or_Not()
	{
		//Navigate to APM capability
		commPage.navigateToApm();

		//navigate to dashboard page
		appPage.navigateToDashBoardTab();

		//navigate to endPage page
		endPage.navigateToEndpointPage();

		//validate the endpoint page
		endPage.validateEndPointPage();
		
	}
	
	
	
	@Test(groups = {"APM","UI","Regression"})
	public void TC_02_validate_The_EndPoint_Page_Table_Header_Culumn1() throws EncryptedDocumentException, IOException
	{

		endPage.validateTheNameTabHeader(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.apmEndpointSheet, "endpointPageTableHeaderCulumn1"));
	}
	
	@Test(groups = {"APM","UI","Regression"})
	public void TC_03_validate_The_EndPoint_Page_Table_Header_Culumn2() throws EncryptedDocumentException, IOException
	{

		endPage.validateTheErrorPercentageCulumnHeader(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.apmEndpointSheet, "endpointPageTableHeaderCulumn2"));
	}
	
	@Test(groups = {"APM","UI","Regression"})
	public void TC_04_validate_The_EndPoint_Page_Table_Header_Culumn3() throws EncryptedDocumentException, IOException
	{
		endPage.validateTheErrorsCulumnHeader(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.apmEndpointSheet, "endpointPageTableHeaderCulumn3"));
	}
	
	@Test(groups = {"APM","UI","Regression"})
	public void TC_05_validate_The_EndPoint_Page_Table_Header_Culumn4() throws EncryptedDocumentException, IOException
	{
		endPage.validateTheErrorsPerMinCulumnHeader(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.apmEndpointSheet, "endpointPageTableHeaderCulumn4"));
	}
	
	@Test(groups = {"APM","UI","Regression"})
	public void TC_06_validate_The_EndPoint_Page_Table_Header_Culumn5() throws EncryptedDocumentException, IOException
	{
		endPage.validateTheResponseTimeCulumnHeader(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.apmEndpointSheet, "endpointPageTableHeaderCulumn5"));
	}
	
	@Test(groups = {"APM","UI","Regression"})
	public void TC_07_validate_The_EndPoint_Page_Table_Header_Culumn6() throws EncryptedDocumentException, IOException
	{
		endPage.validateTheCallsCulumnHeader(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.apmEndpointSheet, "endpointPageTableHeaderCulumn6"));
	}
	
	@Test(groups = {"APM","UI","Regression"})
	public void TC_08_validate_The_EndPoint_Page_Table_Header_Culumn7() throws EncryptedDocumentException, IOException
	{
		endPage.validateTheCallsPerMinCulumnHeader(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.apmEndpointSheet, "endpointPageTableHeaderCulumn7"));
	}
	
	@Test(groups = {"APM","UI","Regression"})
	public void TC_09_validate_Names_Of_EndPoint_Present_Or_Not()
	{
		endPage.validateNameColumnList();
	}
	
	@Test(groups = {"APM","UI","Regression"})
	public void TC_10_validate_The_Error_Percentage_Ascending_Order_Icon()
	{
		endPage.sortErrorPercentageColumnInAscendingOrderAndValidate();
	}
	
	@Test(groups = {"APM","UI","Regression"})
	public void TC_11_validate_The_Error_Percentage_Descending_Order_Icon()
	{
		endPage.sortErrorPercentageColumnInDescendingOrderAndValidate();
	}
	
	@Test(groups = {"APM","UI","Regression"})
	public void TC_12_validate_The_Errors_Ascending_Order_Icon()
	{
		endPage.sortErrorsColumnInAscendingOrderAndValidate();
	}
	
	@Test(groups = {"APM","UI","Regression"})
	public void TC_13_validate_The_Errors_Descending_Order_Icon()
	{
		endPage.sortErrorsColumnInDescendingOrderAndValidate();
	}
	
	@Test(groups = {"APM","UI","Regression"})
	public void TC_14_validate_The_Errors_Per_Min_Ascending_Order_Icon()
	{
		endPage.sortErrorsPerMinColumnInAscendingOrderAndValidate();
	}
	
	@Test(groups = {"APM","UI","Regression"})
	public void TC_15_validate_The_Errors_Per_Min_Descending_Order_Icon()
	{
		endPage.sortErrorsPerMinColumnInDescendingOrderAndValidate();
	}
	
	@Test(groups = {"APM","UI","Regression"})
	public void TC_16_validate_The_Response_Time_Ascending_Order_Icon()
	{
		endPage.sortResponseTimeColumnInAscendingOrderAndValidate();
	}
	
	@Test(groups = {"APM","UI","Regression"})
	public void TC_17_validate_The_Response_Time_Descending_Order_Icon()
	{
		endPage.sortResponseTimeColumnInDescendingOrderAndValidate();
	}
	
	
	@Test(groups = {"APM","UI","Regression"})
	public void TC_18_sort_Calls_Column_In_Ascending_Order_And_Validate() 
	{
		endPage.sortCallsColumnInAscendingOrderAndValidate();
	}
	
	@Test(groups = {"APM","UI","Regression"})
	public void TC_19_sort_Calls_Column_In_Descending_Order_And_Validate() 
	{
		endPage.sortCallsColumnInDescendingOrderAndValidate();
	}
	
	@Test(groups = {"APM","UI","Regression"})
	public void TC_20_sort_Calls_Per_Min_Column_In_Ascending_Order_And_Validate() 
	{
		endPage.sortCallsPerMinColumnInAscendingOrderAndValidate();
	}
	
	@Test(groups = {"APM","UI","Regression"})
	public void TC_21_sort_Calls_Per_Min_Column_In_Descending_Order_And_Validate() 
	{
		endPage.sortCallsPerMinColumnInDescendingOrderAndValidate();
	}
	
	@Test(groups = {"APM","UI","Regression"})
	public void TC_22_validate_The_Search_Bar_With_Valid_Data()
	{
		endPage.validateSearchBarWithValidData();
	}
	
	
	@Test(groups = {"APM","UI","Regression"})
	public void TC_23_validate_The_Search_Bar_With_InValid_Data()
	{
		endPage.validateSearchBarWithInValidData();
	}
	

	@Test (dataProvider = "pagination", groups = {"APM","UI","Regression"})
	public void TC_24_validate_Pagination(String num) {
		endPage.validatePagination(Integer.parseInt(num));
	}
	
	@DataProvider 
	public Object[][] pagination() throws Exception, Exception {
		return eutil.fetchAllTheDataFromExcelSheet(IPathConstant.commExcelPath, IPathConstant.commonPaginationSheet);
	}
	
	@Test(groups = {"APM","UI","Regression"})
	public void TC_24_validate_The_Names_Of_Endpoint_Page_Synchronised_With_Endpoint_Graph_Page()
	{
		endPage.validateIntegrationOfNameData();
	}
	
	@Test(groups = {"APM","UI","Regression"})
	public void TC_25_validate_The_Error_Percentage_Of_Endpoint_Page_Synchronised_With_Endpoint_Graph_Page()
	{
		endPage.validateIntegrationOfErrorPercentagedata();
	}
	
	@Test(groups = {"APM","UI","Regression"})
	public void TC_26_validate_The_Errors_Of_Endpoint_Page_Synchronised_With_Endpoint_Graph_Page()
	{
		endPage.validateIntegrationOfErrorsdata();
	}
	
	@Test(groups = {"APM","UI","Regression"})
	public void TC_27_validate_The_Error_Per_Min_Of_Endpoint_Page_Synchronised_With_Endpoint_Graph_Page()
	{
		endPage.validateIntegrationOfErrorsPerMindata();
	}
	
	@Test(groups = {"APM","UI","Regression"})
	public void TC_28_validate_The_Response_Time_Of_Endpoint_Page_Synchronised_With_Endpoint_Graph_Page()
	{
		endPage.validateIntegrationOfResponseTime();
	}
	
	@Test(groups = {"APM","UI","Regression"})
	public void TC_29_validate_The_Calls_Of_Endpoint_Page_Synchronised_With_Endpoint_Graph_Page()
	{
		endPage.validateIntegrationOfCallsdata();
	}
	
	@Test(groups = {"APM","UI","Regression"})
	public void TC_30_validate_The_Calls_Per_Min_Of_Endpoint_Page_Synchronised_With_Endpoint_Graph_Page()
	{
		endPage.validateIntegrationOfCallsPerMindata();
	}
	
	@Test(groups = {"APM","UI","Regression"})
	public void TC_31_validate_The_Load_Graph_Title() throws EncryptedDocumentException, IOException
	{
		
		endPage.navigateToEndpointWidgetPageByClickOnTheFirstEndPoint();
		
		endPage.validateLoadTitle(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.apmApplicationSheet, "LoadWidgetTitle"));
	}
	
	@Test(groups = {"APM","UI","Regression"})
	public void TC_32_validate_The_Load_Graph_Xaxis_Title() throws EncryptedDocumentException, IOException
	{
		
		endPage.navigateToEndpointWidgetPageByClickOnTheFirstEndPoint();
		
		endPage.validateLoadXaxisTitle(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.apmApplicationSheet, "LoadWidgetXaxisTitle"));
	}
	

	@Test(groups = {"APM","UI","Regression"})
	public void TC_33_validate_The_Load_Graph_Yaxis_Title() throws EncryptedDocumentException, IOException
	{
		
		endPage.navigateToEndpointWidgetPageByClickOnTheFirstEndPoint();
		endPage.validateLoadYaxisTitle(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.apmApplicationSheet, "LoadWidgetYaxisTitle"));
	}
	
	

	@Test(groups = {"APM","UI","Regression"})
	public void TC_34_validate_The_Load_Graph_ZoomIn_Btn()
	{
		endPage.navigateToEndpointWidgetPageByClickOnTheFirstEndPoint();
		
		endPage.validateLoadZoomIn();
	}
	

	@Test(groups = {"APM","UI","Regression"})
	public void TC_35_validate_The_Load_Graph_ZoomOut_Btn()
	{
		endPage.navigateToEndpointWidgetPageByClickOnTheFirstEndPoint();
		
		endPage.validateLoadZoomOut();
	}
	

	@Test(groups = {"APM","UI","Regression"})
	public void TC_36_validate_The_Load_Graph_Reset_Btn()
	{
		endPage.navigateToEndpointWidgetPageByClickOnTheFirstEndPoint();
		
		endPage.validateLoadZoomReset();
	}
	

	@Test(groups = {"APM","UI","Regression"})
	public void TC_37_validate_The_Load_Graph_Xaxis_Drag_And_Drop()
	{
		endPage.navigateToEndpointWidgetPageByClickOnTheFirstEndPoint();
		
		endPage.validateLoadDragDrop();
	}

	@Test(groups = {"APM","UI","Regression"})
	public void TC_38_validate_The_Load_Graph_Tooltip_By_Hover() throws InterruptedException
	{
		endPage.navigateToEndpointWidgetPageByClickOnTheFirstEndPoint();
		
		endPage.validateLoadTooltipTitle();
	}
	
	@Test(groups = {"APM","UI","Regression"})
	public void TC_39_validate_The_Error_Graph_Title() throws EncryptedDocumentException, IOException
	{
		endPage.navigateToEndpointWidgetPageByClickOnTheFirstEndPoint();
		
		endPage.validateErrorTitle(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.apmApplicationSheet, "ErrorWidgetTitle"));
	}
	
	@Test(groups = {"APM","UI","Regression"})
	public void TC_40_validate_The_Error_Graph_Xaxis_Title() throws EncryptedDocumentException, IOException
	{
		endPage.navigateToEndpointWidgetPageByClickOnTheFirstEndPoint();
		
		endPage.validateErrorXaxisTitle(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.apmApplicationSheet, "ErrorWidgetXaxisTitle"));
	}
	

	@Test(groups = {"APM","UI","Regression"})
	public void TC_41_validate_The_Error_Graph_Yaxis_Title() throws EncryptedDocumentException, IOException
	{
		endPage.navigateToEndpointWidgetPageByClickOnTheFirstEndPoint();

		endPage.validateErrorYaxisTitle(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.apmEndpointSheet, "ErrorWidgetYaxisTitle"));
	}
	
	

	@Test(groups = {"APM","UI","Regression"})
	public void TC_42_validate_The_Error_Graph_ZoomIn_Btn()
	{
		endPage.navigateToEndpointWidgetPageByClickOnTheFirstEndPoint();

		endPage.validateErrorZoomOut();
	
	}
	

	@Test(groups = {"APM","UI","Regression"})
	public void TC_43_validate_The_Error_Graph_ZoomOut_Btn()
	{
		endPage.navigateToEndpointWidgetPageByClickOnTheFirstEndPoint();
		
		endPage.validateErrorZoomOut();
	}
	

	@Test(groups = {"APM","UI","Regression"})
	public void TC_44_validate_The_Error_Graph_Reset_Btn()
	{
		endPage.navigateToEndpointWidgetPageByClickOnTheFirstEndPoint();
		
		endPage.validateErrorZoomReset();
	}
	

	@Test(groups = {"APM","UI","Regression"})
	public void TC_45_validate_The_Error_Graph_Xaxis_Drag_And_Drop()
	{
		endPage.navigateToEndpointWidgetPageByClickOnTheFirstEndPoint();
		
		endPage.validatErrorDragDrop();
	}

	@Test(groups = {"APM","UI","Regression"})
	public void TC_46_validate_The_Error_Graph_Tooltip_By_Hover() throws InterruptedException
	{
		endPage.navigateToEndpointWidgetPageByClickOnTheFirstEndPoint();
		
		endPage.validateErrorTooltipTitle();
	}
	@Test(groups = {"APM","UI","Regression"})
	public void TC_47_validate_The_Error_Graph_Legends_Text() throws EncryptedDocumentException, IOException
	{
		endPage.navigateToEndpointWidgetPageByClickOnTheFirstEndPoint();

		endPage.validateErrorLegendsText(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.apmApplicationSheet, "ErrorGraphLegendsText"));
	}
	
	@Test(groups = {"APM","UI","Regression"})
	public void TC_48_validate_The_Response_Time_Graph_Title() throws EncryptedDocumentException, IOException
	{
		endPage.navigateToEndpointWidgetPageByClickOnTheFirstEndPoint();
		
		endPage.validateResposeTimeTitle(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.apmApplicationSheet, "ResponseTimeWidgetTitle"));
	}
	
	@Test(groups = {"APM","UI","Regression"})
	public void TC_49_validate_The_Response_Time_Graph_Xaxis_Title() throws EncryptedDocumentException, IOException
	{
		endPage.navigateToEndpointWidgetPageByClickOnTheFirstEndPoint();
		
		endPage.validateResposeTimeXaxisTitle(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.apmApplicationSheet, "ResponseTimeWidgetXaxisTitle"));
	}

	@Test(groups = {"APM","UI","Regression"})
	public void TC_50_validate_The_Response_Time_Graph_Yaxis_Title() throws EncryptedDocumentException, IOException
	{
		endPage.navigateToEndpointWidgetPageByClickOnTheFirstEndPoint();
		
		endPage.validateResposeTimeYaxisTitle(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.apmApplicationSheet, "ResponseTimeWidgetYaxisTitle"));
	}
	

	@Test(groups = {"APM","UI","Regression"})
	public void TC_51_validate_The_Response_Time_Graph_ZoomIn_Btn()
	{
		endPage.navigateToEndpointWidgetPageByClickOnTheFirstEndPoint();
		
		endPage.validateResposeTimeZoomIn();
	}
	

	@Test(groups = {"APM","UI","Regression"})
	public void TC_52_validate_The_Response_Time_Graph_ZoomOut_Btn()
	{
		endPage.navigateToEndpointWidgetPageByClickOnTheFirstEndPoint();
		
		endPage.validateResposeTimeZoomOut();
	}
	

	@Test(groups = {"APM","UI","Regression"})
	public void TC_53_validate_The_Response_Time_Graph_Reset_Btn()
	{
		endPage.navigateToEndpointWidgetPageByClickOnTheFirstEndPoint();
		
		endPage.validateResposeTimeZoomReset();
	}
	

	@Test(groups = {"APM","UI","Regression"})
	public void TC_54_validate_The_Response_Time_Graph_Xaxis_Drag_And_Drop()
	{
		endPage.navigateToEndpointWidgetPageByClickOnTheFirstEndPoint();
		
		endPage.validateResposeTimeDragDrop();
	}

	@Test(groups = {"APM","UI","Regression"})
	public void TC_55_validate_The_Response_Time_Graph_Tooltip_By_Hover() throws InterruptedException
	{
		endPage.navigateToEndpointWidgetPageByClickOnTheFirstEndPoint();
		
		endPage.validateResposeTimeTooltipTitle();
	}
	

	@Test(groups = {"APM","UI","Regression"})
	public void TC_56_validate_The_Percentaile_Respose_Time_Graph_Title() throws EncryptedDocumentException, IOException
	{
		endPage.navigateToEndpointWidgetPageByClickOnTheFirstEndPoint();
		
		endPage.validatePercentileResponseTimeTitle(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.apmApplicationSheet, "PercentileResponseTimeWidgetTitle"));
	}
	
	@Test(groups = {"APM","UI","Regression"})
	public void TC_57_validate_The_Percentaile_Respose_Time_Graph_Xaxis_Title() throws EncryptedDocumentException, IOException
	{

		endPage.navigateToEndpointWidgetPageByClickOnTheFirstEndPoint();
		
		endPage.validatePercentileResponseTimeXaxisTitle(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.apmApplicationSheet, "PercentileResponseTimeWidgetXaxisTitle"));
	}
	

	@Test(groups = {"APM","UI","Regression"})
	public void TC_58_validate_The_Percentaile_Respose_Time_Graph_Yaxis_Title() throws EncryptedDocumentException, IOException
	{
		endPage.navigateToEndpointWidgetPageByClickOnTheFirstEndPoint();
		
		endPage.validatePercentileResponseTimeYaxisTitle(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.apmApplicationSheet, "PercentileResponseTimeWidgetYaxisTitle"));
	}
	

	@Test(groups = {"APM","UI","Regression"})
	public void TC_59_validate_The_Percentaile_Respose_Time_Graph_ZoomIn_Btn()
	{
		endPage.navigateToEndpointWidgetPageByClickOnTheFirstEndPoint();
		
		endPage.validatePercentileResponseTimeZoomIn();
	}
	

	@Test(groups = {"APM","UI","Regression"})
	public void TC_60_validate_The_Percentaile_Respose_Time_Graph_ZoomOut_Btn()
	{
		endPage.navigateToEndpointWidgetPageByClickOnTheFirstEndPoint();
		
		endPage.validatePercentileResponseTimeZoomOut();
	}
	

	@Test(groups = {"APM","UI","Regression"})
	public void TC_61_validate_The_Percentaile_Respose_Time_Graph_Reset_Btn()
	{
		endPage.navigateToEndpointWidgetPageByClickOnTheFirstEndPoint();
		
		endPage.validatePercentileResponseTimeZoomReset();
	}
	

	@Test(groups = {"APM","UI","Regression"})
	public void TC_62_validate_The_Percentaile_Respose_Time_Graph_Xaxis_Drag_And_Drop()
	{
		endPage.navigateToEndpointWidgetPageByClickOnTheFirstEndPoint();
		
		endPage.validatePercentileResponseTimeDragDrop();
	}

	@Test(groups = {"APM","UI","Regression"})
	public void TC_63_validate_The_Percentaile_Respose_Time_Graph_Tool_tip_By_Hover() throws InterruptedException
	{
		endPage.navigateToEndpointWidgetPageByClickOnTheFirstEndPoint();
		
		endPage.validatePercentileResponseTimeTooltipTitle();

	}
	
	@Test(groups = {"APM","UI","Regression"})
	public void TC_64_validate_The_Percentail_Respose_Time_Graph_Legends_Text() throws EncryptedDocumentException, IOException
	{
		endPage.navigateToEndpointWidgetPageByClickOnTheFirstEndPoint();
		
		endPage.validateWidgetLegendsForPercentailResposeTimeGraph(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.apmExcelPath, IPathConstant.apmApplicationSheet, "PercentileResponseTimeWidgetLegendsText"));
	}
	
	@Test(groups = {"APM","UI","Regression"})
	public void TC_65_validate_The_Percentaile_Respose_Time_Graph_Legends() throws InterruptedException
	{	
		endPage.navigateToEndpointWidgetPageByClickOnTheFirstEndPoint();
		
		endPage.validatepercentileResponseTimewidgetLegends();
	}
	
	@Test(groups = {"APM","UI","Regression"})
	public void TC_66_validate_The_All_Widget_Data_By_Selecting_5Mins_TimeLine()
	{
		endPage.navigateToEndpointWidgetPageByClickOnTheFirstEndPoint();
		
		//select the time line from calendar
		commPage.selectTheTimeLineFromCalender(IPathConstant.fiveMinutesTimeRange);

		//Validate whether the widgets are displaying the proper time line or not
		endPage.validateTheGivenTimeLine();
	}
	
	@Test(groups = {"APM","UI","Regression"})
	public void TC_67_validate_The_All_Widgets_Data_By_Selecting_15Mins_TimeLine()
	{
		endPage.navigateToEndpointWidgetPageByClickOnTheFirstEndPoint();
		
		//select the time line from calendar
		commPage.selectTheTimeLineFromCalender(IPathConstant.fifteenMinutesTimeRange);

		//Validate whether the widgets are displaying the proper time line or not
		endPage.validateTheGivenTimeLine();
	}
	
	@Test(groups = {"APM","UI","Regression"})
	public void TC_68_validate_The_All_Widgets_Data_By_Selecting_30Mins_TimeLine()
	{
		endPage.navigateToEndpointWidgetPageByClickOnTheFirstEndPoint();
		
		//select the time line from calendar
		commPage.selectTheTimeLineFromCalender(IPathConstant.thirtyMinutesTimeRange);

		//Validate whether the widgets are displaying the proper time line or not
		endPage.validateTheGivenTimeLine();
	
		
	}
	
	@Test(groups = {"APM","UI","Regression"})
	public void TC_69_validate_The_All_Widgets_Data_By_Selecting_60Mins_TimeLine()
	{
		endPage.navigateToEndpointWidgetPageByClickOnTheFirstEndPoint();
		
		//select the time line from calendar
		commPage.selectTheTimeLineFromCalender(IPathConstant.sixtyMinutesTimeRange);

		//Validate whether the widgets are displaying the proper time line or not
		endPage.validateTheGivenTimeLine();
		
	}
	
	@Test(groups = {"APM","UI","Regression"})
	public void TC_70_validate_The_All_Widgets_Data_By_Selecting_3hours_TimeLine()
	{
		endPage.navigateToEndpointWidgetPageByClickOnTheFirstEndPoint();
		
		//select the time line from calendar
		commPage.selectTheTimeLineFromCalender(IPathConstant.threeHoursTimeRange);

		//Validate whether the widgets are displaying the proper time line or not
		endPage.validateTheGivenTimeLine();
		
		
	}
	
	@Test(groups = {"APM","UI","Regression"})
	public void TC_71_validate_The_All_Widgets_Data_By_Selecting_6hours_TimeLine()
	{
		endPage.navigateToEndpointWidgetPageByClickOnTheFirstEndPoint();
		
		//select the time line from calendar
		commPage.selectTheTimeLineFromCalender(IPathConstant.sixHoursTimeRange);

		//Validate whether the widgets are displaying the proper time line or not
		endPage.validateTheGivenTimeLine();
		
	}
	
	@Test(groups = {"APM","UI","Regression"})
	public void TC_72_validate_The_All_Widgets_Data_By_Selecting_12hours_TimeLine()
	{
		endPage.navigateToEndpointWidgetPageByClickOnTheFirstEndPoint();
		
		//select the time line from calendar
		commPage.selectTheTimeLineFromCalender(IPathConstant.twelveHoursTimeRange);

		//Validate whether the widgets are displaying the proper time line or not
		endPage.validateTheGivenTimeLine();
		
	}
	
	@Test(groups = {"APM","UI","Regression"})
	public void TC_73_validate_The_All_Widgets_Data_By_Selecting_1day_TimeLine()
	{
		endPage.navigateToEndpointWidgetPageByClickOnTheFirstEndPoint();
		
		//select the time line from calendar
		commPage.selectTheTimeLineFromCalender(IPathConstant.oneDayTimeRange);

		//Validate whether the widgets are displaying the proper time line or not
		endPage.validateTheGivenTimeLine();
		
	}
	
	@Test(groups = {"APM","UI","Regression"})
	public void TC_74_validate_The_All_Widgets_Data_By_Selecting_1week_TimeLine()
	{
		endPage.navigateToEndpointWidgetPageByClickOnTheFirstEndPoint();
		
		//select the time line from calendar
		commPage.selectTheTimeLineFromCalender(IPathConstant.oneWeekTimeRange);

		//Validate whether the widgets are displaying the proper time line or not
		endPage.validateTheGivenTimeLine();
		
	}
	
	@Test(groups = {"APM","UI","Regression"})
	public void TC_75_validate_The_All_Widgets_Data_By_Selecting_1month_TimeLine()
	{
		endPage.navigateToEndpointWidgetPageByClickOnTheFirstEndPoint();
		
		//select the time line from calendar
		commPage.selectTheTimeLineFromCalender(IPathConstant.oneMonthTimeRange);
		
		//Validate whether the widgets are displaying the proper time line or not
		endPage.validateTheGivenTimeLine();
		
	}
	
	@Test(groups = {"APM","UI","Regression"})
	public void TC_76_validate_The_All_Widgets_By_selecting_custom_Time_For_Minutes_Range() throws EncryptedDocumentException, IOException
	{
		page.pause();
		endPage.navigateToEndpointWidgetPageByClickOnTheFirstEndPoint();
		
		//select the time line from calendar
		commPage.selectTheCustomeTimeLine(IPathConstant.customTimeRange, eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customMinutesRange") );
		
		//Validate whether the widgets are displaying the proper time line or not
		endPage.validateTheCustomTimeLine(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customMinutesRange"));
		
		
	}
	
	
	@Test(groups = {"APM","UI","Regression"})
	public void TC_77_validate_The_All_Widgets_By_selecting_custom_Time_For_Hours_Range() throws EncryptedDocumentException, IOException
	{
		endPage.navigateToEndpointWidgetPageByClickOnTheFirstEndPoint();
		
		//select the time line from calendar
		commPage.selectTheCustomeTimeLine(IPathConstant.customTimeRange, eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customHoursRange"));
		
		//Validate whether the widgets are displaying the proper time line or not
		endPage.validateTheCustomTimeLine(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customHoursRange"));
				
		
		
	}
	
	@Test(groups = {"APM","UI","Regression"})
	public void TC_78_validate_The_All_Widgets_By_selecting_custom_Time_For_Days_Range() throws EncryptedDocumentException, IOException
	{
		endPage.navigateToEndpointWidgetPageByClickOnTheFirstEndPoint();
		
		//select the time line from calendar
		commPage.selectTheCustomeTimeLine(IPathConstant.customTimeRange, eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customDaysRange"));
		
		//Validate whether the widgets are displaying the proper time line or not
		endPage.validateTheCustomTimeLine(eutil.ReadDataFromExcelByUsingKeyProperty(IPathConstant.commExcelPath,IPathConstant.calenderSheet, "customDaysRange"));
	}
	
	@Test(groups = {"APM","UI","Regression"})
	public void TC_79_validate_The_All_Widgets_By_selecting_custom_Time_For_Future_date()
	{
		endPage.navigateToEndpointWidgetPageByClickOnTheFirstEndPoint();
		
		//select the future time line from calendar
		commPage.validateTheFutureTimeLine();
		
	}
	
	
	

}
