package objectRepository.DBM;

import java.util.ArrayList;
import java.util.List;
import com.microsoft.playwright.Page;
import genericUtilities.GenericMethods;
import objectRepository.CommonPage;
import org.testng.Assert;

public class MysqlMetricsPage {

    Page page;
	GenericMethods util=new GenericMethods();
    CommonPage comPage = new CommonPage(page);


private String selectNodeDropDown = "xpath =//div[@class='dashboardTop']/descendant::div[@id='search-select-database-instance']";
private String selectNodeTextField="id =input-search-sel-search-select-database-instance";
private String selectFirstNode="id =search-select-database-instance-0-single";
//private String calenderIcon = "xpath = //div[@class='date-box']/descendant::span[contains(@class,'selected-icon')]";
private String metricsTab="//div[contains(@class,'router') and .='Metrics ']";
private String innoDBBufferPoolPagesDataWidvalidateTitle="//div[@class='wrapper']/descendant::div[@class='line-title'][position()=1]";
private String innoDBBufferPoolPagesDataZoomOutBtn="xpath =//span[@id='Inno-DB-buffer-pool-pages-data-zoom-out']";
private String innoDBBufferPoolPagesDataZoomInBtn="xpath =//span[@id='Inno-DB-buffer-pool-pages-data-zoom-in']";
private String innoDBBufferPoolPagesDataResetBtn="xpath =//span[@id='Inno-DB-buffer-pool-pages-data-zoom-reset']";
private String innoDBBufferPoolPagesDataXaxisLines="xpath =//div[@id='apexchartsvuechart-line-0']/ancestor::div[@class='chart-line']/descendant::*[name()='line' and @class='apexcharts-xaxis-tick']";
private String innoDBBufferPoolPagesDataXaxisValues="xpath =//div[@id='apexchartsvuechart-line-0']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-label apexcharts-xaxis-label']/child::*[name()='tspan' and contains(text(),'-')]";
private String innoDBBufferPoolPagesDataXaxisTitle="xpath =//div[@id='apexchartsvuechart-line-0']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-title-text chart-lables']";
private String innoDBBufferPoolPagesDataYaxisTitle="xpath =//div[@id='apexchartsvuechart-line-0']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-yaxis-title-text chart-lables']";
private String innoDBBufferPoolPagesDataToolTipTitle="xpath =//div[@id='apexchartsvuechart-line-0']/ancestor::div[@class='chart-box']/descendant::div[@class='apexcharts-tooltip-title']";
private String innoDBBufferPoolPagesDataTooltipValue="xpath =//div[@id='apexchartsvuechart-line-0']/ancestor::div[@class='chart-box']/descendant::div[@class='apexcharts-tooltip-text']";
private String InnoDBBufferPoolPagesFreeWidvalidateTitle="xpath =//div[@class='wrapper']/descendant::div[@class='line-title'][position()=2]" ;
private String InnoDBBufferPoolPagesFreeZoomOutBtn="xpath =//span[@id='Inno-DB-buffer-pool-pages-free-zoom-out']";
private String InnoDBBufferPoolPagesFreeZoomInBtn="xpath =//span[@id='Inno-DB-buffer-pool-pages-free-zoom-in']";
private String InnoDBBufferPoolPagesFreeResetBtn="xpath =//span[@id='Inno-DB-buffer-pool-pages-free-zoom-reset']";
private String InnoDBBufferPoolPagesFreeXaxisLines="xpath =//div[@id='apexchartsvuechart-line-1']/ancestor::div[@class='chart-line']/descendant::*[name()='line' and @class='apexcharts-xaxis-tick']";
private String InnoDBBufferPoolPagesFreeXaxisValues="xpath =//div[@id='apexchartsvuechart-line-1']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-label apexcharts-xaxis-label']/child::*[name()='tspan' and contains(text(),'-')]";
private String InnoDBBufferPoolPagesFreeXaxisTitle="xpath =//div[@id='apexchartsvuechart-line-1']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-title-text chart-lables']";
private String InnoDBBufferPoolPagesFreeYaxisTitle="xpath =//div[@id='apexchartsvuechart-line-1']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-yaxis-title-text chart-lables']";
private String InnoDBBufferPoolPagesFreeToolTipTitle="xpath =//div[@id='apexchartsvuechart-line-1']/ancestor::div[@class='chart-box']/descendant::div[@class='apexcharts-tooltip-title']";
private String InnoDBBufferPoolPagesFreeTooltipValue="xpath =//div[@id='apexchartsvuechart-line-1']/ancestor::div[@class='chart-box']/descendant::div[@class='apexcharts-tooltip-text']";
private String InnoDBRowLockCurrentWaitsWidvalidateTitle="xpath =//div[@class='wrapper']/descendant::div[@class='line-title'][position()=3]" ;
private String InnoDBRowLockCurrentWaitsZoomOutBtn="xpath =//span[@id='Inno-DB-row-lock-current-waits-zoom-out']";
private String InnoDBRowLockCurrentWaitsZoomInBtn="xpath =//span[@id='Inno-DB-row-lock-current-waits-zoom-in']";
private String InnoDBRowLockCurrentWaitsResetBtn="xpath =//span[@id='Inno-DB-row-lock-current-waits-zoom-reset']";
private String InnoDBRowLockCurrentWaitsXaxisLines="xpath =//div[@id='apexchartsvuechart-line-2']/ancestor::div[@class='chart-line']/descendant::*[name()='line' and @class='apexcharts-xaxis-tick']";
private String InnoDBRowLockCurrentWaitsXaxisValues="xpath =//div[@id='apexchartsvuechart-line-2']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-label apexcharts-xaxis-label']/child::*[name()='tspan' and contains(text(),'-')]";
private String InnoDBRowLockCurrentWaitsXaxisTitle="xpath =//div[@id='apexchartsvuechart-line-2']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-title-text chart-lables']";
private String InnoDBRowLockCurrentWaitsYaxisTitle="xpath =//div[@id='apexchartsvuechart-line-2']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-yaxis-title-text chart-lables']";
private String InnoDBRowLockCurrentWaitsToolTipTitle="xpath =//div[@id='apexchartsvuechart-line-2']/ancestor::div[@class='chart-box']/descendant::div[@class='apexcharts-tooltip-title']";
private String InnoDBRowLockCurrentWaitsTooltipValue="xpath =//div[@id='apexchartsvuechart-line-2']/ancestor::div[@class='chart-box']/descendant::div[@class='apexcharts-tooltip-text']";
private String InnoDBRowLockTimeAverageWidvalidateTitle="xpath =//div[@class='wrapper']/descendant::div[@class='line-title'][position()=4]" ;
private String InnoDBRowLockTimeAverageZoomOutBtn="xpath =//span[@id='Inno-DB-row-lock-time-average-zoom-out']";
private String InnoDBRowLockTimeAverageZoomInBtn="xpath =//span[@id='Inno-DB-row-lock-time-average-zoom-in']";
private String InnoDBRowLockTimeAverageResetBtn="xpath =//span[@id='Inno-DB-row-lock-time-average-zoom-reset']";
private String InnoDBRowLockTimeAverageXaxisLines="xpath =//div[@id='apexchartsvuechart-line-3']/ancestor::div[@class='chart-line']/descendant::*[name()='line' and @class='apexcharts-xaxis-tick']";
private String InnoDBRowLockTimeAverageXaxisValues="xpath =//div[@id='apexchartsvuechart-line-3']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-label apexcharts-xaxis-label']/child::*[name()='tspan' and contains(text(),'-')]";
private String InnoDBRowLockTimeAverageXaxisTitle="xpath =//div[@id='apexchartsvuechart-line-3']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-title-text chart-lables']";
private String InnoDBRowLockTimeAverageYaxisTitle="xpath =//div[@id='apexchartsvuechart-line-3']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-yaxis-title-text chart-lables']";
private String InnoDBRowLockTimeAveravalidateoolTipTitle="xpath =//div[@id='apexchartsvuechart-line-3']/ancestor::div[@class='chart-box']/descendant::div[@class='apexcharts-tooltip-title']";
private String InnoDBRowLockTimeAveravalidateooltipValue="xpath =//div[@id='apexchartsvuechart-line-3']/ancestor::div[@class='chart-box']/descendant::div[@class='apexcharts-tooltip-text']";
private String InnoDBRowLockWaitsPerSecondWidvalidateTitle="xpath =//div[@class='wrapper']/descendant::div[@class='line-title'][position()=5]" ;
private String InnoDBRowLockWaitsPerSecondZoomOutBtn="xpath =//span[@id='Inno-DB-row-lock-waits-per-second-zoom-out']";
private String InnoDBRowLockWaitsPerSecondZoomInBtn="xpath =//span[@id='Inno-DB-row-lock-waits-per-second-zoom-in']";
private String InnoDBRowLockWaitsPerSecondResetBtn="xpath =//span[@id='Inno-DB-row-lock-waits-per-second-zoom-reset']";
private String InnoDBRowLockWaitsPerSecondXaxisLines="xpath =//div[@id='apexchartsvuechart-line-4']/ancestor::div[@class='chart-line']/descendant::*[name()='line' and @class='apexcharts-xaxis-tick']";
private String InnoDBRowLockWaitsPerSecondXaxisValues="xpath =//div[@id='apexchartsvuechart-line-4']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-label apexcharts-xaxis-label']/child::*[name()='tspan' and contains(text(),'-')]";
private String InnoDBRowLockWaitsPerSecondXaxisTitle="xpath =//div[@id='apexchartsvuechart-line-4']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-title-text chart-lables']";
private String InnoDBRowLockWaitsPerSecondYaxisTitle="xpath =//div[@id='apexchartsvuechart-line-4']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-yaxis-title-text chart-lables']";
private String InnoDBRowLockWaitsPerSecondToolTipTitle="xpath =//div[@id='apexchartsvuechart-line-4']/ancestor::div[@class='chart-box']/descendant::div[@class='apexcharts-tooltip-title']";
private String InnoDBRowLockWaitsPerSecondTooltipValue="xpath =//div[@id='apexchartsvuechart-line-4']/ancestor::div[@class='chart-box']/descendant::div[@class='apexcharts-tooltip-text']";
private String InnoDBRowLockWaitsWidvalidateTitle="xpath =//div[@class='wrapper']/descendant::div[@class='line-title'][position()=6]" ;
private String InnoDBRowLockWaitsZoomOutBtn="xpath =//span[@id='Inno-DB-row-lock-waits-zoom-out']";
private String InnoDBRowLockWaitsZoomInBtn="xpath =//span[@id='Inno-DB-row-lock-waits-zoom-in']";
private String InnoDBRowLockWaitsResetBtn="xpath =//span[@id='Inno-DB-row-lock-waits-zoom-reset']";
private String InnoDBRowLockWaitsXaxisLines="xpath =//div[@id='apexchartsvuechart-line-5']/ancestor::div[@class='chart-line']/descendant::*[name()='line' and @class='apexcharts-xaxis-tick']";
private String InnoDBRowLockWaitsXaxisValues="xpath =//div[@id='apexchartsvuechart-line-5']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-label apexcharts-xaxis-label']/child::*[name()='tspan' and contains(text(),'-')]";
private String InnoDBRowLockWaitsXaxisTitle="xpath =//div[@id='apexchartsvuechart-line-5']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-title-text chart-lables']";
private String InnoDBRowLockWaitsYaxisTitle="xpath =//div[@id='apexchartsvuechart-line-5']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-yaxis-title-text chart-lables']";
private String InnoDBRowLockWaitsoolTipTitle="xpath =//div[@id='apexchartsvuechart-line-5']/ancestor::div[@class='chart-box']/descendant::div[@class='apexcharts-tooltip-title']";
private String InnoDBRowLockWaitsTooltipValue="xpath =//div[@id='apexchartsvuechart-line-5']/ancestor::div[@class='chart-box']/descendant::div[@class='apexcharts-tooltip-text']";
private String totalOpenFilesWidvalidateTitle="xpath =//div[@class='wrapper']/descendant::div[@class='line-title'][position()=7]" ;
private String totalOpenFilesZoomOutBtn="xpath =//span[@id='Total-open-files-zoom-out']";
private String totalOpenFilesZoomInBtn="xpath =//span[@id='Total-open-files-zoom-in']";
private String totalOpenFilesResetBtn="xpath =//span[@id='Total-open-files-zoom-reset']";
private String totalOpenFilesXaxisLines="xpath =//div[@id='apexchartsvuechart-line-6']/ancestor::div[@class='chart-line']/descendant::*[name()='line' and @class='apexcharts-xaxis-tick']";
private String totalOpenFilesXaxisValues="xpath =//div[@id='apexchartsvuechart-line-6']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-label apexcharts-xaxis-label']/child::*[name()='tspan' and contains(text(),'-')]";
private String totalOpenFilesXaxisTitle="xpath =//div[@id='apexchartsvuechart-line-6']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-title-text chart-lables']";
private String totalOpenFilesYaxisTitle="xpath =//div[@id='apexchartsvuechart-line-6']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-yaxis-title-text chart-lables']";
private String totalOpenFilesToolTipTitle="xpath =//div[@id='apexchartsvuechart-line-6']/ancestor::div[@class='chart-box']/descendant::div[@class='apexcharts-tooltip-title']";
private String totalOpenFilesTooltipValue="xpath =//div[@id='apexchartsvuechart-line-6']/ancestor::div[@class='chart-box']/descendant::div[@class='apexcharts-tooltip-text']";
private String totalOpenTablesWidvalidateTitle="xpath =//div[@class='wrapper']/descendant::div[@class='line-title'][position()=8]";
private String totalOpenTablesZoomOutBtn="xpath =//span[@id='Total-open-tables-zoom-out']";
private String totalOpenTablesZoomInBtn="xpath =//span[@id='Total-open-tables-zoom-in']";
private String totalOpenTablesResetBtn="xpath =//span[@id='Total-open-tables-zoom-reset']";
private String totalOpenTablesXaxisLines="xpath =//div[@id='apexchartsvuechart-line-7']/ancestor::div[@class='chart-line']/descendant::*[name()='line' and @class='apexcharts-xaxis-tick']";
private String totalOpenTablesXaxisValues="xpath =//div[@id='apexchartsvuechart-line-7']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-label apexcharts-xaxis-label']/child::*[name()='tspan' and contains(text(),'-')]";
private String totalOpenTablesXaxisTitle="xpath =//div[@id='apexchartsvuechart-line-7']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-title-text chart-lables']";
private String totalOpenTablesYaxisTitle="xpath =//div[@id='apexchartsvuechart-line-7']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-yaxis-title-text chart-lables']";
private String totalOpenTablesToolTipTitle="xpath =//div[@id='apexchartsvuechart-line-7']/ancestor::div[@class='chart-box']/descendant::div[@class='apexcharts-tooltip-title']";
private String totalOpenTablesTooltipValue="xpath =//div[@id='apexchartsvuechart-line-7']/ancestor::div[@class='chart-box']/descendant::div[@class='apexcharts-tooltip-text']";
private String maxUsedConnectionsWidvalidateTitle="xpath =//div[@class='wrapper']/descendant::div[@class='line-title'][position()=9]";
private String maxUsedConnectionsZoomOutBtn="xpath =//span[@id='Max-used-connections-zoom-out']";
private String maxUsedConnectionsZoomInBtn="xpath =//span[@id='Max-used-connections-zoom-in']";
private String maxUsedConnectionsResetBtn="xpath =//span[@id='Max-used-connections-zoom-reset']";
private String maxUsedConnectionsXaxisLines="xpath =//div[@id='apexchartsvuechart-line-8']/ancestor::div[@class='chart-line']/descendant::*[name()='line' and @class='apexcharts-xaxis-tick']";
private String maxUsedConnectionsXaxisValues="xpath =//div[@id='apexchartsvuechart-line-8']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-label apexcharts-xaxis-label']/child::*[name()='tspan' and contains(text(),'-')]";
private String maxUsedConnectionsXaxisTitle="xpath =//div[@id='apexchartsvuechart-line-8']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-title-text chart-lables']";
private String maxUsedConnectionsYaxisTitle="xpath =//div[@id='apexchartsvuechart-line-8']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-yaxis-title-text chart-lables']";
private String maxUsedConnectionsToolTipTitle="xpath =//div[@id='apexchartsvuechart-line-8']/ancestor::div[@class='chart-box']/descendant::div[@class='apexcharts-tooltip-title']";
private String maxUsedConnectionsTooltipValue="xpath =//div[@id='apexchartsvuechart-line-8']/ancestor::div[@class='chart-box']/descendant::div[@class='apexcharts-tooltip-text']";
private String netConnectionErrorsPerSecondWidvalidateTitle="xpath =//div[@class='wrapper']/descendant::div[@class='line-title'][position()=10]";
private String netConnectionErrorsPerSecondZoomOutBtn="xpath =//span[@id='Net-connection-errors-per-second-zoom-out']";
private String netConnectionErrorsPerSecondZoomInBtn="xpath =//span[@id='Net-connection-errors-per-second-zoom-in']";
private String netConnectionErrorsPerSecondResetBtn="xpath =//span[@id='Net-connection-errors-per-second-zoom-reset']";
private String netConnectionErrorsPerSecondXaxisLines="xpath =//div[@id='apexchartsvuechart-line-9']/ancestor::div[@class='chart-line']/descendant::*[name()='line' and @class='apexcharts-xaxis-tick']";
private String netConnectionErrorsPerSecondXaxisValues="xpath =//div[@id='apexchartsvuechart-line-9']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-label apexcharts-xaxis-label']/child::*[name()='tspan' and contains(text(),'-')]";
private String netConnectionErrorsPerSecondXaxisTitle="xpath =//div[@id='apexchartsvuechart-line-9']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-title-text chart-lables']";
private String netConnectionErrorsPerSecondYaxisTitle="xpath =//div[@id='apexchartsvuechart-line-9']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-yaxis-title-text chart-lables']";
private String netConnectionErrorsPerSecondToolTipTitle="xpath =//div[@id='apexchartsvuechart-line-9']/ancestor::div[@class='chart-box']/descendant::div[@class='apexcharts-tooltip-title']";
private String netConnectionErrorsPerSecondTooltipValue="xpath =//div[@id='apexchartsvuechart-line-9']/ancestor::div[@class='chart-box']/descendant::div[@class='apexcharts-tooltip-text']";
private String netConnectionErrorsWidvalidateTitle="xpath =//div[@class='wrapper']/descendant::div[@class='line-title'][position()=11]";
private String netConnectionErrorsZoomOutBtn="xpath =//span[@id='Net-connection-errors-zoom-out']";
private String netConnectionErrorsZoomInBtn="xpath =//span[@id='Net-connection-errors-zoom-in']";
private String netConnectionErrorsResetBtn="xpath =//span[@id='Net-connection-errors-zoom-reset']";
private String netConnectionErrorsXaxisLines="xpath =//div[@id='apexchartsvuechart-line-10']/ancestor::div[@class='chart-line']/descendant::*[name()='line' and @class='apexcharts-xaxis-tick']";
private String netConnectionErrorsXaxisValues="xpath =//div[@id='apexchartsvuechart-line-10']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-label apexcharts-xaxis-label']/child::*[name()='tspan' and contains(text(),'-')]";
private String netConnectionErrorsXaxisTitle="xpath =//div[@id='apexchartsvuechart-line-10']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-title-text chart-lables']";
private String netConnectionErrorsYaxisTitle="xpath =//div[@id='apexchartsvuechart-line-10']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-yaxis-title-text chart-lables']";
private String netConnectionErrorsToolTipTitle="xpath =//div[@id='apexchartsvuechart-line-10']/ancestor::div[@class='chart-box']/descendant::div[@class='apexcharts-tooltip-title']";
private String netConnectionErrorsTooltipValue="xpath =//div[@id='apexchartsvuechart-line-10']/ancestor::div[@class='chart-box']/descendant::div[@class='apexcharts-tooltip-text']";
private String selectQueriesCountWidvalidateTitle="xpath =//div[@class='wrapper']/descendant::div[@class='line-title'][position()=12]" ;
private String selectQueriesCountZoomOutBtn="xpath =//span[@id='Select-queries-count-zoom-out']";
private String selectQueriesCountZoomInBtn="xpath =//span[@id='Select-queries-count-zoom-in']";
private String selectQueriesCountResetBtn="xpath =//span[@id='Select-queries-count-zoom-reset']";
private String selectQueriesCountXaxisLines="xpath =//div[@id='apexchartsvuechart-line-11']/ancestor::div[@class='chart-line']/descendant::*[name()='line' and @class='apexcharts-xaxis-tick']";
private String selectQueriesCountXaxisValues="xpath =//div[@id='apexchartsvuechart-line-11']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-label apexcharts-xaxis-label']/child::*[name()='tspan' and contains(text(),'-')]";
private String selectQueriesCountXaxisTitle="xpath =//div[@id='apexchartsvuechart-line-11']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-title-text chart-lables']";
private String selectQueriesCountYaxisTitle="xpath =//div[@id='apexchartsvuechart-line-11']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-yaxis-title-text chart-lables']";
private String selectQueriesCountToolTipTitle="xpath =//div[@id='apexchartsvuechart-line-11']/ancestor::div[@class='chart-box']/descendant::div[@class='apexcharts-tooltip-title']";
private String selectQueriesCountTooltipValue="xpath =//div[@id='apexchartsvuechart-line-11']/ancestor::div[@class='chart-box']/descendant::div[@class='apexcharts-tooltip-text']";
private String insertQueriesCountWidvalidateTitle="xpath =//div[@class='wrapper']/descendant::div[@class='line-title'][position()=13]" ;
private String insertQueriesCountZoomOutBtn="xpath =//span[@id='Insert-queries-count-zoom-out']";
private String insertQueriesCountZoomInBtn="xpath =//span[@id='Insert-queries-count-zoom-in']";
private String insertQueriesCountResetBtn="xpath =//span[@id='Insert-queries-count-zoom-reset']";
private String insertQueriesCountXaxisLines="xpath =//div[@id='apexchartsvuechart-line-12']/ancestor::div[@class='chart-line']/descendant::*[name()='line' and @class='apexcharts-xaxis-tick']";
private String insertQueriesCountXaxisValues="xpath =//div[@id='apexchartsvuechart-line-12']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-label apexcharts-xaxis-label']/child::*[name()='tspan' and contains(text(),'-')]";
private String insertQueriesCountXaxisTitle="xpath =//div[@id='apexchartsvuechart-line-12']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-title-text chart-lables']";
private String insertQueriesCountYaxisTitle="xpath =//div[@id='apexchartsvuechart-line-12']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-yaxis-title-text chart-lables']";
private String insertQueriesCountToolTipTitle="xpath =//div[@id='apexchartsvuechart-line-12']/ancestor::div[@class='chart-box']/descendant::div[@class='apexcharts-tooltip-title']";
private String insertQueriesCountTooltipValue="xpath =//div[@id='apexchartsvuechart-line-12']/ancestor::div[@class='chart-box']/descendant::div[@class='apexcharts-tooltip-text']";
private String selectQueriesPerSecondWidvalidateTitle="xpath =//div[@class='wrapper']/descendant::div[@class='line-title'][position()=14]" ;
private String selectQueriesPerSecondZoomOutBtn="xpath =//span[@id='Select-queries-per-second-zoom-out']";
private String selectQueriesPerSecondZoomInBtn="xpath =//span[@id='Select-queries-per-second-zoom-in']";
private String selectQueriesPerSecondResetBtn="xpath =//span[@id='Select-queries-per-second-zoom-reset']";
private String selectQueriesPerSecondXaxisLines="xpath =//div[@id='apexchartsvuechart-line-13']/ancestor::div[@class='chart-line']/descendant::*[name()='line' and @class='apexcharts-xaxis-tick']";
private String selectQueriesPerSecondXaxisValues="xpath =//div[@id='apexchartsvuechart-line-13']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-label apexcharts-xaxis-label']/child::*[name()='tspan' and contains(text(),'-')]";
private String selectQueriesPerSecondXaxisTitle="xpath =//div[@id='apexchartsvuechart-line-13']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-title-text chart-lables']";
private String selectQueriesPerSecondYaxisTitle="xpath =//div[@id='apexchartsvuechart-line-13']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-yaxis-title-text chart-lables']";
private String selectQueriesPerSecondToolTipTitle="xpath =//div[@id='apexchartsvuechart-line-13']/ancestor::div[@class='chart-box']/descendant::div[@class='apexcharts-tooltip-title']";
private String selectQueriesPerSecondTooltipValue="xpath =//div[@id='apexchartsvuechart-line-13']/ancestor::div[@class='chart-box']/descendant::div[@class='apexcharts-tooltip-text']";
private String insertQueriesPerSecondWidvalidateTitle="xpath =//div[@class='wrapper']/descendant::div[@class='line-title'][position()=15]" ;
private String insertQueriesPerSecondZoomOutBtn="xpath =//span[@id='Insert-queries-per-second-zoom-out']";
private String insertQueriesPerSecondZoomInBtn="xpath =//span[@id='Insert-queries-per-second-zoom-in']";
private String insertQueriesPerSecondResetBtn="xpath =//span[@id='Insert-queries-per-second-zoom-reset']";
private String insertQueriesPerSecondXaxisLines="xpath =//div[@id='apexchartsvuechart-line-14']/ancestor::div[@class='chart-line']/descendant::*[name()='line' and @class='apexcharts-xaxis-tick']";
private String insertQueriesPerSecondXaxisValues="xpath =//div[@id='apexchartsvuechart-line-14']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-label apexcharts-xaxis-label']/child::*[name()='tspan' and contains(text(),'-')]";
private String insertQueriesPerSecondXaxisTitle="xpath =//div[@id='apexchartsvuechart-line-14']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-title-text chart-lables']";
private String insertQueriesPerSecondYaxisTitle="xpath =//div[@id='apexchartsvuechart-line-14']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-yaxis-title-text chart-lables']";
private String insertQueriesPerSecondToolTipTitle="xpath =//div[@id='apexchartsvuechart-line-14']/ancestor::div[@class='chart-box']/descendant::div[@class='apexcharts-tooltip-title']";
private String insertQueriesPerSecondTooltipValue="xpath =//div[@id='apexchartsvuechart-line-14']/ancestor::div[@class='chart-box']/descendant::div[@class='apexcharts-tooltip-text']";
private String slowQueriesPerSecondWidvalidateTitle="xpath =//div[@class='wrapper']/descendant::div[@class='line-title'][position()=16]" ;
private String slowQueriesPerSecondZoomOutBtn="xpath =//span[@id='Slow-queries-per-second-zoom-out']";
private String slowQueriesPerSecondZoomInBtn="xpath =//span[@id='Slow-queries-per-second-zoom-in']";
private String slowQueriesPerSecondResetBtn="xpath =//span[@id='Slow-queries-per-second-zoom-reset']";
private String slowQueriesPerSecondXaxisLines="xpath =//div[@id='apexchartsvuechart-line-15']/ancestor::div[@class='chart-line']/descendant::*[name()='line' and @class='apexcharts-xaxis-tick']";
private String slowQueriesPerSecondXaxisValues="xpath =//div[@id='apexchartsvuechart-line-15']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-label apexcharts-xaxis-label']/child::*[name()='tspan' and contains(text(),'-')]";
private String slowQueriesPerSecondXaxisTitle="xpath =//div[@id='apexchartsvuechart-line-15']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-title-text chart-lables']";
private String slowQueriesPerSecondYaxisTitle="xpath =//div[@id='apexchartsvuechart-line-15']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-yaxis-title-text chart-lables']";
private String slowQueriesPerSecondToolTipTitle="xpath =//div[@id='apexchartsvuechart-line-15']/ancestor::div[@class='chart-box']/descendant::div[@class='apexcharts-tooltip-title']";
private String slowQueriesPerSecondTooltipValue="xpath =//div[@id='apexchartsvuechart-line-15']/ancestor::div[@class='chart-box']/descendant::div[@class='apexcharts-tooltip-text']";
private String slowQueriesCountWidvalidateTitle="xpath =//div[@class='wrapper']/descendant::div[@class='line-title'][position()=17]" ;
private String slowQueriesCountZoomOutBtn="xpath =//span[@id='Slow-queries-count-zoom-out']";
private String slowQueriesCountZoomInBtn="xpath =//span[@id='Slow-queries-count-zoom-in']";
private String slowQueriesCountResetBtn="xpath =//span[@id='Slow-queries-count-zoom-reset']";
private String slowQueriesCountXaxisLines="xpath =//div[@id='apexchartsvuechart-line-16']/ancestor::div[@class='chart-line']/descendant::*[name()='line' and @class='apexcharts-xaxis-tick']";
private String slowQueriesCountXaxisValues="xpath =//div[@id='apexchartsvuechart-line-16']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-label apexcharts-xaxis-label']/child::*[name()='tspan' and contains(text(),'-')]";
private String slowQueriesCountXaxisTitle="xpath =//div[@id='apexchartsvuechart-line-16']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-title-text chart-lables']";
private String slowQueriesCountYaxisTitle="xpath =//div[@id='apexchartsvuechart-line-16']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-yaxis-title-text chart-lables']";
private String slowQueriesCountToolTipTitle="xpath =//div[@id='apexchartsvuechart-line-16']/ancestor::div[@class='chart-box']/descendant::div[@class='apexcharts-tooltip-title']";
private String slowQueriesCountTooltipValue="xpath =//div[@id='apexchartsvuechart-line-16']/ancestor::div[@class='chart-box']/descendant::div[@class='apexcharts-tooltip-text']";
private String queriesCountWidvalidateTitle="xpath =//div[@class='wrapper']/descendant::div[@class='line-title'][position()=18]";
private String queriesCountZoomOutBtn="xpath =//span[@id='Queries-count-zoom-out']";
private String queriesCountZoomInBtn="xpath =//span[@id='Queries-count-zoom-in']";
private String queriesCountResetBtn="xpath =//span[@id='Queries-count-zoom-reset']";
private String queriesCountXaxisLines="xpath =//div[@id='apexchartsvuechart-line-17']/ancestor::div[@class='chart-line']/descendant::*[name()='line' and @class='apexcharts-xaxis-tick']";
private String queriesCountXaxisValues="xpath =//div[@id='apexchartsvuechart-line-17']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-label apexcharts-xaxis-label']/child::*[name()='tspan' and contains(text(),'-')]";
private String queriesCountXaxisTitle="xpath =//div[@id='apexchartsvuechart-line-17']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-title-text chart-lables']";
private String queriesCountYaxisTitle="xpath =//div[@id='apexchartsvuechart-line-17']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-yaxis-title-text chart-lables']";
private String queriesCountToolTipTitle="xpath =//div[@id='apexchartsvuechart-line-17']/ancestor::div[@class='chart-box']/descendant::div[@class='apexcharts-tooltip-title']";
private String queriesCountTooltipValue="xpath =//div[@id='apexchartsvuechart-line-17']/ancestor::div[@class='chart-box']/descendant::div[@class='apexcharts-tooltip-text']";
private String queriesPerSecondWidvalidateTitle="xpath =//div[@class='wrapper']/descendant::div[@class='line-title'][position()=19]";
private String queriesPerSecondZoomOutBtn="xpath =//span[@id='Queries-per-second-zoom-out']";
private String queriesPerSecondZoomInBtn="xpath =//span[@id='Queries-per-second-zoom-in']";
private String queriesPerSecondResetBtn="xpath =//span[@id='Queries-per-second-zoom-reset']";
private String queriesPerSecondXaxisLines="xpath =//div[@id='apexchartsvuechart-line-18']/ancestor::div[@class='chart-line']/descendant::*[name()='line' and @class='apexcharts-xaxis-tick']";
private String queriesPerSecondXaxisValues="xpath =//div[@id='apexchartsvuechart-line-18']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-label apexcharts-xaxis-label']/child::*[name()='tspan' and contains(text(),'-')]";
private String queriesPerSecondXaxisTitle="xpath =//div[@id='apexchartsvuechart-line-18']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-title-text chart-lables']";
private String queriesPerSecondYaxisTitle="xpath =//div[@id='apexchartsvuechart-line-18']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-yaxis-title-text chart-lables']";
private String queriesPerSecondToolTipTitle="xpath =//div[@id='apexchartsvuechart-line-18']/ancestor::div[@class='chart-box']/descendant::div[@class='apexcharts-tooltip-title']";
private String queriesPerSecondTooltipValue="xpath =//div[@id='apexchartsvuechart-line-18']/ancestor::div[@class='chart-box']/descendant::div[@class='apexcharts-tooltip-text']";
private String deadlockCountWidvalidateTitle="xpath =//div[@class='wrapper']/descendant::div[@class='line-title'][position()=20]" ;
private String deadlockCountZoomOutBtn="xpath =//span[@id='Deadlock-count-zoom-out']";
private String deadlockCountZoomInBtn="xpath =//span[@id='Deadlock-count-zoom-in']";
private String deadlockCountResetBtn="xpath =//span[@id='Deadlock-count-zoom-reset']";
private String deadlockCountXaxisLines="xpath =//div[@id='apexchartsvuechart-line-19']/ancestor::div[@class='chart-line']/descendant::*[name()='line' and @class='apexcharts-xaxis-tick']";
private String deadlockCountXaxisValues="xpath =//div[@id='apexchartsvuechart-line-19']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-label apexcharts-xaxis-label']/child::*[name()='tspan' and contains(text(),'-')]";
private String deadlockCountXaxisTitle="xpath =//div[@id='apexchartsvuechart-line-19']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-title-text chart-lables']";
private String deadlockCountYaxisTitle="xpath =//div[@id='apexchartsvuechart-line-19']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-yaxis-title-text chart-lables']";
private String deadlockCountToolTipTitle="xpath =//div[@id='apexchartsvuechart-line-19']/ancestor::div[@class='chart-box']/descendant::div[@class='apexcharts-tooltip-title']";
private String deadlockCountTooltipValue="xpath =//div[@id='apexchartsvuechart-line-19']/ancestor::div[@class='chart-box']/descendant::div[@class='apexcharts-tooltip-text']";
private String preparedStatementsPerSecondWidvalidateTitle="xpath =//div[@class='wrapper']/descendant::div[@class='line-title'][position()=21]" ;
private String preparedStatementsPerSecondZoomOutBtn="xpath =//span[@id='Prepared-statements-per-second-zoom-out']";
private String preparedStatementsPerSecondZoomInBtn="xpath =//span[@id='Prepared-statements-per-second-zoom-in']";
private String preparedStatementsPerSecondResetBtn="xpath =//span[@id='Prepared-statements-per-second-zoom-reset']";
private String preparedStatementsPerSecondXaxisLines="xpath =//div[@id='apexchartsvuechart-line-20']/ancestor::div[@class='chart-line']/descendant::*[name()='line' and @class='apexcharts-xaxis-tick']";
private String preparedStatementsPerSecondXaxisValues="xpath =//div[@id='apexchartsvuechart-line-20']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-label apexcharts-xaxis-label']/child::*[name()='tspan' and contains(text(),'-')]";
private String preparedStatementsPerSecondXaxisTitle="xpath =//div[@id='apexchartsvuechart-line-20']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-title-text chart-lables']";
private String preparedStatementsPerSecondYaxisTitle="xpath =//div[@id='apexchartsvuechart-line-20']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-yaxis-title-text chart-lables']";
private String preparedStatementsPerSecondToolTipTitle="xpath =//div[@id='apexchartsvuechart-line-20']/ancestor::div[@class='chart-box']/descendant::div[@class='apexcharts-tooltip-title']";
private String preparedStatementsPerSecondTooltipValue="xpath =//div[@id='apexchartsvuechart-line-20']/ancestor::div[@class='chart-box']/descendant::div[@class='apexcharts-tooltip-text']";
private String preparedStatementsWidvalidateTitle="xpath =//div[@class='wrapper']/descendant::div[@class='line-title'][position()=22]" ;
private String preparedStatementsZoomOutBtn="xpath =//span[@id='Prepared-statements-zoom-out']";
private String preparedStatementsZoomInBtn="xpath =//span[@id='Prepared-statements-zoom-in']";
private String preparedStatementsResetBtn="xpath =//span[@id='Prepared-statements-zoom-reset']";
private String preparedStatementsXaxisLines="xpath =//div[@id='apexchartsvuechart-line-21']/ancestor::div[@class='chart-line']/descendant::*[name()='line' and @class='apexcharts-xaxis-tick']";
private String preparedStatementsXaxisValues="xpath =//div[@id='apexchartsvuechart-line-21']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-label apexcharts-xaxis-label']/child::*[name()='tspan' and contains(text(),'-')]";
private String preparedStatementsXaxisTitle="xpath =//div[@id='apexchartsvuechart-line-21']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-title-text chart-lables']";
private String preparedStatementsYaxisTitle="xpath =//div[@id='apexchartsvuechart-line-21']/ancestor::div[@class='chart-line']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-yaxis-title-text chart-lables']";
private String preparedStatementsToolTipTitle="xpath =//div[@id='apexchartsvuechart-line-21']/ancestor::div[@class='chart-box']/descendant::div[@class='apexcharts-tooltip-title']";
private String preparedStatementsTooltipValue="xpath =//div[@id='apexchartsvuechart-line-21']/ancestor::div[@class='chart-box']/descendant::div[@class='apexcharts-tooltip-text']";
private String selectAppDropDown="#btn-arrow-down-search-select-database-service" ;
private String searchAppTextField ="#input-search-sel-search-select-database-service" ;
private String searchedApp ="xpath =//span[@id='search-select-database-service-0-single']" ;
private String searchNodeTextField = "#input-search-sel-search-select-database-instance";
private String searchedNode ="#search-select-database-instance-0-single";
private String refreshButton ="#btn-refresh";
private String calendarValue = "xpath = //div[@class='selected-text ellipsis bg-text']";

List<String> xvalues = new ArrayList<>();
{
    xvalues.add(preparedStatementsPerSecondXaxisValues);
    xvalues.add(InnoDBBufferPoolPagesFreeXaxisValues);
    xvalues.add(InnoDBRowLockCurrentWaitsXaxisValues);
    xvalues.add(InnoDBRowLockTimeAverageXaxisValues);
    xvalues.add(InnoDBRowLockWaitsPerSecondXaxisValues);
    xvalues.add(InnoDBRowLockWaitsXaxisValues);
    xvalues.add(totalOpenFilesXaxisValues);
    xvalues.add(preparedStatementsXaxisValues);
    xvalues.add(deadlockCountXaxisValues);
    xvalues.add(queriesPerSecondXaxisValues);
    xvalues.add(queriesCountXaxisValues);
    xvalues.add(slowQueriesCountXaxisValues);
    xvalues.add(slowQueriesPerSecondXaxisValues);
    xvalues.add(insertQueriesPerSecondXaxisValues);
    xvalues.add(selectQueriesPerSecondXaxisValues);
    xvalues.add(insertQueriesCountXaxisValues);
    xvalues.add(selectQueriesCountXaxisValues);
    xvalues.add(netConnectionErrorsXaxisValues);
    xvalues.add(netConnectionErrorsPerSecondXaxisValues);
    xvalues.add(maxUsedConnectionsXaxisValues);
    xvalues.add(totalOpenTablesXaxisValues);
    xvalues.add(innoDBBufferPoolPagesDataXaxisValues);
}

public MysqlMetricsPage(Page page)
	{
		this.page= page;
	}
    public void selectTheApplicationForAPM(String application)
	{
		util.selectTheOptionFromDropDownBySearch(page, selectAppDropDown, searchAppTextField, application, searchedApp);
	}
public void validateSelectNodeDropDown(String node) {
    util.selectTheOptionFromDropDownBySearch(page, selectNodeDropDown, searchNodeTextField, node, searchedNode);
}

public String validateSelectNodeTextField(String actual) {
    return selectNodeTextField;
}
public void validateMetricsTab() {
    page.click(metricsTab);
		page.waitForLoadState();
		String expectedUrl="**/database";
		page.waitForURL(expectedUrl);
		Assert.assertEquals(page.url().contains("/database"),true);
	}
//Validates the title of all the charts
public void getInnoDBBufferPoolPagesDataWidvalidateTitle(String expectedTitle) {
    page.waitForSelector(innoDBBufferPoolPagesDataWidvalidateTitle);
     //System.out.println("Actual title : " + page.locator(innoDBBufferPoolPagesDataWidvalidateTitle).textContent().trim());
     //System.out.println("expected title : " + expectedTitle);
    util.ValidateTheTitle(page, innoDBBufferPoolPagesDataWidvalidateTitle, expectedTitle);
}
public void getInnoDBBufferPoolPagesDataXaxisTitle(String readDataFromExcelByUsingKeyProperty) {
    util.ValidateTheTitle(page, innoDBBufferPoolPagesDataXaxisTitle, readDataFromExcelByUsingKeyProperty);
}

public void getInnoDBBufferPoolPagesDataYaxisTitle(String readDataFromExcelByUsingKeyProperty) {
    util.ValidateTheTitle(page, innoDBBufferPoolPagesDataYaxisTitle, readDataFromExcelByUsingKeyProperty);
}
public void getInnoDBBufferPoolPagesDataZoomInBtn() {
    
    util.graphZoomIn(page, innoDBBufferPoolPagesDataZoomInBtn, innoDBBufferPoolPagesDataResetBtn, xvalues);
}
public void getInnoDBBufferPoolPagesDataZoomOutBtn() {
    util.graphZoomOut(page, innoDBBufferPoolPagesDataZoomInBtn, innoDBBufferPoolPagesDataZoomOutBtn, innoDBBufferPoolPagesDataResetBtn, xvalues);
}
public void getInnoDBBufferPoolPagesDataResetBtn() {
    util.graphZoomReset(page, innoDBBufferPoolPagesDataZoomInBtn, innoDBBufferPoolPagesDataResetBtn, xvalues);
}
public void getInnoDBBufferPoolPagesFreeTitle(String readDataFromExcelByUsingKeyProperty) {
    util.ValidateTheTitle(page, InnoDBBufferPoolPagesFreeWidvalidateTitle, readDataFromExcelByUsingKeyProperty);
}
public void getInnoDBBufferPoolPageFreeChartXaxisTitle(String readDataFromExcelByUsingKeyProperty) {
    util.ValidateTheTitle(page, InnoDBBufferPoolPagesFreeXaxisTitle, readDataFromExcelByUsingKeyProperty);
}
public void getInnoDBBufferPoolPageFreeChartYaxisTitle(String readDataFromExcelByUsingKeyProperty) {
    util.ValidateTheTitle(page, InnoDBBufferPoolPagesFreeYaxisTitle, readDataFromExcelByUsingKeyProperty);
}
public void getInnoDBBufferPoolPageFreeChartZoomInButton() {
    util.graphZoomIn(page, InnoDBBufferPoolPagesFreeZoomInBtn, InnoDBBufferPoolPagesFreeResetBtn, xvalues);
}
public void getInnoDBBufferPoolPageFreeChartZoomOutButton() {
    util.graphZoomOut(page, InnoDBBufferPoolPagesFreeZoomInBtn, InnoDBBufferPoolPagesFreeZoomOutBtn, InnoDBBufferPoolPagesFreeResetBtn, xvalues);
}
public void getInnoDBBufferPoolPageFreeChartZoomResetButton() {
    util.graphZoomReset(page, InnoDBBufferPoolPagesFreeZoomInBtn, InnoDBBufferPoolPagesFreeResetBtn, xvalues);
}
public void getInnoDBRowLockCurrentWaitsChartTitle(String readDataFromExcelByUsingKeyProperty) {
    util.ValidateTheTitle(page, InnoDBRowLockCurrentWaitsWidvalidateTitle, readDataFromExcelByUsingKeyProperty);
}
public void getInnoDBRowLockCurrentWaitsChartXaxisTitle(String readDataFromExcelByUsingKeyProperty) {
    util.ValidateTheTitle(page, InnoDBRowLockCurrentWaitsXaxisTitle, readDataFromExcelByUsingKeyProperty);
}
public void getInnoDBRowLockCurrentWaitsChartYaxisTitle(String readDataFromExcelByUsingKeyProperty) {
    util.ValidateTheTitle(page, InnoDBRowLockCurrentWaitsYaxisTitle, readDataFromExcelByUsingKeyProperty);
}
public void getInnoDBRowLockCurrentWaitsChartZoomInButton() {
    util.graphZoomIn(page, InnoDBRowLockCurrentWaitsZoomInBtn, InnoDBRowLockCurrentWaitsResetBtn, xvalues);
}
public void getInnoDBRowLockCurrentWaitsChartZoomOutButton() {
    util.graphZoomOut(page, InnoDBRowLockCurrentWaitsZoomInBtn, InnoDBRowLockCurrentWaitsZoomOutBtn, InnoDBRowLockCurrentWaitsResetBtn, xvalues);
}
public void getInnoDBRowLockCurrentWaitsChartZoomResetButton() {
    util.graphZoomReset(page, InnoDBRowLockCurrentWaitsZoomInBtn, InnoDBRowLockCurrentWaitsResetBtn, xvalues);
}
public void getInnoDBRowLockTimeAverageChartTitle(String readDataFromExcelByUsingKeyProperty) {
    util.ValidateTheTitle(page, InnoDBRowLockTimeAverageWidvalidateTitle, readDataFromExcelByUsingKeyProperty);
}
public void getInnoDBRowLockTimeAverageChartXaxis(String readDataFromExcelByUsingKeyProperty) {
    util.ValidateTheTitle(page, InnoDBRowLockTimeAverageXaxisTitle, readDataFromExcelByUsingKeyProperty);
}
public void getInnoDBRowLockTimeAverageChartYaxis(String readDataFromExcelByUsingKeyProperty) {
    util.ValidateTheTitle(page, InnoDBRowLockTimeAverageYaxisTitle, readDataFromExcelByUsingKeyProperty);
}
public void getInnoDBRowLockTimeAverageChartZoomInButton() {
    util.graphZoomIn(page, InnoDBRowLockTimeAverageZoomInBtn, InnoDBRowLockTimeAverageResetBtn, xvalues);
}
public void getInnoDBRowLockTimeAverageChartZoomOutButton() {
    util.graphZoomOut(page, InnoDBRowLockTimeAverageZoomInBtn, InnoDBRowLockTimeAverageZoomOutBtn, InnoDBRowLockTimeAverageResetBtn, xvalues);
}
public void getInnoDBRowLockTimeAverageChartZoomResetButton() {
    util.graphZoomReset(page, InnoDBRowLockTimeAverageZoomInBtn, InnoDBRowLockTimeAverageResetBtn, xvalues);
}
public void getInnoDBRowLockWaitsPerSecChartTitle(String readDataFromExcelByUsingKeyProperty) {
    System.out.println(page.locator(InnoDBRowLockWaitsPerSecondWidvalidateTitle).textContent().trim());
    System.out.println(readDataFromExcelByUsingKeyProperty);
    util.ValidateTheTitle(page, InnoDBRowLockWaitsPerSecondWidvalidateTitle, readDataFromExcelByUsingKeyProperty);
}
public void getInnoDBRowLockWaitsPerSecChartXaxis(String readDataFromExcelByUsingKeyProperty) {
    util.ValidateTheTitle(page, InnoDBRowLockWaitsPerSecondXaxisTitle, readDataFromExcelByUsingKeyProperty);
}
public void getInnoDBRowLockWaitsPerSecChartYaxis(String readDataFromExcelByUsingKeyProperty) {
    util.ValidateTheTitle(page, InnoDBRowLockWaitsPerSecondYaxisTitle, readDataFromExcelByUsingKeyProperty);
}
public void getInnoDBRowLockWaitsPerSecChartZoomInButton() {
    util.graphZoomIn(page, InnoDBRowLockWaitsPerSecondZoomInBtn, InnoDBRowLockWaitsPerSecondResetBtn, xvalues);
}
public void getInnoDBRowLockWaitsPerSecChartZoomOutButton() {
    util.graphZoomOut(page, InnoDBRowLockWaitsPerSecondZoomInBtn, InnoDBRowLockWaitsPerSecondZoomOutBtn, InnoDBRowLockWaitsPerSecondResetBtn, xvalues);
}
public void getInnoDBRowLockWaitsPerSecChartZoomResetButton() {
    util.graphZoomReset(page, InnoDBRowLockWaitsPerSecondZoomInBtn, InnoDBRowLockWaitsPerSecondResetBtn, xvalues);
}

public void getInnoDBRowLockWaitsChartTitle(String readDataFromExcelByUsingKeyProperty) {
    util.ValidateTheTitle(page, InnoDBRowLockWaitsWidvalidateTitle, readDataFromExcelByUsingKeyProperty);
}
public void getInnoDBRowLockWaitsChartXaxisTitle(String readDataFromExcelByUsingKeyProperty) {
    util.ValidateTheTitle(page, InnoDBRowLockWaitsXaxisTitle, readDataFromExcelByUsingKeyProperty);
}
public void InnoDBRowLockWaitsChartYaxis(String readDataFromExcelByUsingKeyProperty) {
    util.ValidateTheTitle(page, InnoDBRowLockWaitsYaxisTitle, readDataFromExcelByUsingKeyProperty);
}
public void InnoDBRowLockWaitsChartZoomInButton() {
    util.graphZoomIn(page, InnoDBRowLockWaitsZoomInBtn, InnoDBRowLockWaitsResetBtn, xvalues);
}
public void InnoDBRowLockWaitsChartZoomOutButton() {
    util.graphZoomOut(page, InnoDBRowLockWaitsZoomInBtn, InnoDBRowLockWaitsZoomOutBtn, InnoDBRowLockWaitsResetBtn, xvalues);
}
public void InnoDBRowLockWaitsChartZoomResetButton() {
    util.graphZoomReset(page, InnoDBRowLockWaitsZoomInBtn, InnoDBRowLockWaitsResetBtn, xvalues);
}
public void getTotalOpenFilesChartTitle(String readDataFromExcelByUsingKeyProperty) {
    util.ValidateTheTitle(page, totalOpenFilesWidvalidateTitle, readDataFromExcelByUsingKeyProperty);
}
public void getTotalOpenFilesChartXaxisTitle(String readDataFromExcelByUsingKeyProperty) {
    util.ValidateTheTitle(page, totalOpenFilesXaxisTitle, readDataFromExcelByUsingKeyProperty);
}
public void getTotalOpenFilesChartYaxisTitle(String readDataFromExcelByUsingKeyProperty) {
    util.ValidateTheTitle(page, totalOpenFilesYaxisTitle, readDataFromExcelByUsingKeyProperty);
}
public void getTotalOpenFilesChartZoomInButton() {
    util.graphZoomIn(page, totalOpenFilesZoomInBtn, totalOpenFilesResetBtn, xvalues);
}
public void getTotalOpenFilesChartZoomOutButton() {
    util.graphZoomOut(page, totalOpenFilesZoomInBtn, totalOpenFilesZoomOutBtn, totalOpenFilesResetBtn, xvalues);
}
public void getTotalOpenFilesChartZoomResetButton() {
    util.graphZoomReset(page, totalOpenFilesZoomInBtn, totalOpenFilesResetBtn, xvalues);
}
public void getTotalOpenTablesChartTitle(String readDataFromExcelByUsingKeyProperty) {
    util.ValidateTheTitle(page, totalOpenTablesWidvalidateTitle, readDataFromExcelByUsingKeyProperty);
}
public void getTotalOpenTablesChartXaxis(String readDataFromExcelByUsingKeyProperty) {
    util.ValidateTheTitle(page, totalOpenTablesXaxisTitle, readDataFromExcelByUsingKeyProperty);
}
public void getTotalOpenTablesChartYaxis(String readDataFromExcelByUsingKeyProperty) {
    util.ValidateTheTitle(page, totalOpenTablesYaxisTitle, readDataFromExcelByUsingKeyProperty);
}
public void getTotalOpenTablesChartZoomInButton() {
    util.graphZoomIn(page, totalOpenTablesZoomInBtn, totalOpenTablesResetBtn, xvalues);
}
public void getTotalOpenTablesChartZoomOutButton() {
    util.graphZoomOut(page, totalOpenTablesZoomInBtn, totalOpenTablesZoomOutBtn, totalOpenTablesResetBtn, xvalues);
}
public void getTotalOpenTablesChartZoomResetButton() {
    util.graphZoomReset(page, totalOpenTablesZoomInBtn, totalOpenTablesResetBtn, xvalues);
}
public void getMaxUsedConnectionsChartTitle(String readDataFromExcelByUsingKeyProperty) {
    util.ValidateTheTitle(page, maxUsedConnectionsWidvalidateTitle, readDataFromExcelByUsingKeyProperty);
}
public void getMaxUsedConnectionsChartXaxisTitle(String readDataFromExcelByUsingKeyProperty) {
    util.ValidateTheTitle(page, maxUsedConnectionsXaxisTitle, readDataFromExcelByUsingKeyProperty);
}
public void getMaxUsedConnectionsChartYaxisTitle(String readDataFromExcelByUsingKeyProperty) {
    util.ValidateTheTitle(page, maxUsedConnectionsYaxisTitle, readDataFromExcelByUsingKeyProperty);
}
public void getMaxUsedConnectionsChartZoomInButton() {
    util.graphZoomIn(page, maxUsedConnectionsZoomInBtn, maxUsedConnectionsResetBtn, xvalues);
}
public void getMaxUsedConnectionsChartZoomOutButton() {
    util.graphZoomOut(page, maxUsedConnectionsZoomInBtn, maxUsedConnectionsZoomOutBtn, maxUsedConnectionsResetBtn, xvalues);
}
public void getMaxUsedConnectionsChartZoomResetButton() {
    util.graphZoomReset(page, maxUsedConnectionsZoomInBtn, maxUsedConnectionsResetBtn, xvalues);
}
public void getNetConnectionErrorPerSecChartTitle(String readDataFromExcelByUsingKeyProperty) {
    util.ValidateTheTitle(page, netConnectionErrorsPerSecondWidvalidateTitle, readDataFromExcelByUsingKeyProperty);
}
public void getNetConnectionErrorPerSecChartXaxisTitle(String readDataFromExcelByUsingKeyProperty) {
    util.ValidateTheTitle(page, netConnectionErrorsPerSecondXaxisTitle, readDataFromExcelByUsingKeyProperty);
}
public void getNetConnectionErrorPerSecChartYaxisTitle(String readDataFromExcelByUsingKeyProperty) {
    util.ValidateTheTitle(page, netConnectionErrorsPerSecondYaxisTitle, readDataFromExcelByUsingKeyProperty);
}
public void getNetConnectionErrorPerSecChartZoomInButton() {
    util.graphZoomIn(page, netConnectionErrorsPerSecondZoomInBtn, netConnectionErrorsPerSecondResetBtn, xvalues);
}
public void getNetConnectionErrorPerSecChartZoomButton() {
    util.graphZoomOut(page, netConnectionErrorsPerSecondZoomInBtn, netConnectionErrorsPerSecondZoomOutBtn, netConnectionErrorsPerSecondResetBtn, xvalues);
}
public void getNetConnectionErrorPerSecChartZoomResetButton() {
    util.graphZoomReset(page, netConnectionErrorsPerSecondZoomInBtn, netConnectionErrorsPerSecondResetBtn, xvalues);
}
public void getNetConnectionErrorsChartTitle(String readDataFromExcelByUsingKeyProperty) {
    util.ValidateTheTitle(page, netConnectionErrorsWidvalidateTitle, readDataFromExcelByUsingKeyProperty);
}
public void getNetConnectionErrorsChartXaxis(String readDataFromExcelByUsingKeyProperty) {
    util.ValidateTheTitle(page, netConnectionErrorsXaxisTitle, readDataFromExcelByUsingKeyProperty);
}
public void getNetConnectionErrorsChartYaxisTitle(String readDataFromExcelByUsingKeyProperty) {
    util.ValidateTheTitle(page, netConnectionErrorsYaxisTitle, readDataFromExcelByUsingKeyProperty);
}
public void getNetConnectionErrorsChartZoomInButton() {
    util.graphZoomIn(page, netConnectionErrorsZoomInBtn, netConnectionErrorsResetBtn, xvalues);
}
public void getNetConnectionErrorsChartZoomOutButton() {
    util.graphZoomOut(page, netConnectionErrorsZoomInBtn, netConnectionErrorsZoomOutBtn, netConnectionErrorsResetBtn, xvalues);
}
public void getNetConnectionErrorsChartZoomResetButton() {
    util.graphZoomReset(page, netConnectionErrorsZoomInBtn, netConnectionErrorsResetBtn, xvalues);
}
public void getSelectQueriesCountChartTitle(String readDataFromExcelByUsingKeyProperty) {
    util.ValidateTheTitle(page, selectQueriesCountWidvalidateTitle, readDataFromExcelByUsingKeyProperty);
}
public void getSelectQueriesCountChartXaxis(String readDataFromExcelByUsingKeyProperty) {
    util.ValidateTheTitle(page, selectQueriesCountXaxisTitle, readDataFromExcelByUsingKeyProperty);
}
public void getSelectQueriesCountChartYaxisTitle(String readDataFromExcelByUsingKeyProperty) {
    util.ValidateTheTitle(page, selectQueriesCountYaxisTitle, readDataFromExcelByUsingKeyProperty);
}
public void getSelectQueriesCountChartZoomInButton() {
    util.graphZoomIn(page, selectQueriesCountZoomInBtn, selectQueriesCountResetBtn, xvalues);
}
public void getSelectQueriesCountChartZoomOutButton() {
    util.graphZoomOut(page, selectQueriesCountZoomInBtn, selectQueriesCountZoomOutBtn, selectQueriesCountResetBtn, xvalues);
}
public void getSelectQueriesCountChartZoomResetButton() {
    util.graphZoomReset(page, selectQueriesCountZoomInBtn, selectQueriesCountResetBtn, xvalues);
}
public void getInsertQueriesCountChartTitle(String readDataFromExcelByUsingKeyProperty) {
    util.ValidateTheTitle(page, insertQueriesCountWidvalidateTitle, readDataFromExcelByUsingKeyProperty);
}
public void getInsertQueriesCountChartXaxisTitle(String readDataFromExcelByUsingKeyProperty) {
    util.ValidateTheTitle(page, insertQueriesCountXaxisTitle, readDataFromExcelByUsingKeyProperty);
}
public void getInsertQueriesCountChartYaxisTitle(String readDataFromExcelByUsingKeyProperty) {
    util.ValidateTheTitle(page, insertQueriesCountYaxisTitle, readDataFromExcelByUsingKeyProperty);
}
public void getInsertQueriesCountChartZoomInButton() {
    util.graphZoomIn(page, insertQueriesCountZoomInBtn, insertQueriesCountResetBtn, xvalues);
}
public void getInsertQueriesCountChartZoomOutButton() {
    util.graphZoomOut(page, insertQueriesCountZoomInBtn, insertQueriesCountZoomOutBtn, insertQueriesCountResetBtn, xvalues);
}
public void getInsertQueriesCountChartZoomResetButton() {
    util.graphZoomReset(page, insertQueriesCountZoomInBtn, insertQueriesCountResetBtn, xvalues);
}
public void getSelectQueriesPerSecChartTitle(String readDataFromExcelByUsingKeyProperty) {
    util.ValidateTheTitle(page, selectQueriesPerSecondWidvalidateTitle, readDataFromExcelByUsingKeyProperty);
}
public void getSelectQueriesPerSecChartXaxisTitle(String readDataFromExcelByUsingKeyProperty) {
    util.ValidateTheTitle(page, selectQueriesPerSecondXaxisTitle, readDataFromExcelByUsingKeyProperty);
}
public void getSelectQueriesPerSecChartYaxisTitle(String readDataFromExcelByUsingKeyProperty) {
    util.ValidateTheTitle(page, selectQueriesPerSecondYaxisTitle, readDataFromExcelByUsingKeyProperty);
}
public void getSelectQueriesPerSecChartZoomInButton() {
    util.graphZoomIn(page, selectQueriesPerSecondZoomInBtn, selectQueriesPerSecondResetBtn, xvalues);
}
public void getSelectQueriesPerSecChartZoomOutButton() {
    util.graphZoomOut(page, selectQueriesPerSecondZoomInBtn, selectQueriesPerSecondZoomOutBtn, selectQueriesPerSecondResetBtn, xvalues);
}
public void getSelectQueriesPerSecChartZoomResetButton() {
    util.graphZoomReset(page, selectQueriesPerSecondZoomInBtn, selectQueriesPerSecondResetBtn, xvalues);
}
public void getInsertQueriesPerSecChartTitle(String readDataFromExcelByUsingKeyProperty) {
    util.ValidateTheTitle(page, insertQueriesPerSecondWidvalidateTitle, readDataFromExcelByUsingKeyProperty);
}
public void getInsertQueriesPerSecChartXaxisTitle(String readDataFromExcelByUsingKeyProperty) {
    util.ValidateTheTitle(page, insertQueriesPerSecondXaxisTitle, readDataFromExcelByUsingKeyProperty);
}
public void getInsertQueriesPerSecChartYaxisTitle(String readDataFromExcelByUsingKeyProperty) {
    util.ValidateTheTitle(page, insertQueriesPerSecondYaxisTitle, readDataFromExcelByUsingKeyProperty);
}
public void getInsertQueriesPerSecChartZoomInButton() {
    util.graphZoomIn(page, insertQueriesPerSecondZoomInBtn, insertQueriesPerSecondResetBtn, xvalues);
}
public void getInsertQueriesPerSecChartZoomOutButton() {
    util.graphZoomOut(page, insertQueriesPerSecondZoomInBtn, insertQueriesPerSecondZoomOutBtn, insertQueriesPerSecondResetBtn, xvalues);
}
public void getInsertQueriesPerSecChartZoomResetButton() {
    util.graphZoomReset(page, insertQueriesPerSecondZoomInBtn, insertQueriesPerSecondResetBtn, xvalues);
}
public void getSlowQueriesPerSecChartTitle(String readDataFromExcelByUsingKeyProperty) {
    util.ValidateTheTitle(page, slowQueriesPerSecondWidvalidateTitle, readDataFromExcelByUsingKeyProperty);
}
public void getSlowQueriesPerSecChartXaxisTitle(String readDataFromExcelByUsingKeyProperty) {
    util.ValidateTheTitle(page, slowQueriesPerSecondXaxisTitle, readDataFromExcelByUsingKeyProperty);
}
public void getSlowQueriesPerSecChartYaxisTitle(String readDataFromExcelByUsingKeyProperty) {
    util.ValidateTheTitle(page, slowQueriesPerSecondYaxisTitle, readDataFromExcelByUsingKeyProperty);
}
public void getSlowQueriesPerSecChartZoomInButton() {
    util.graphZoomIn(page, slowQueriesPerSecondZoomInBtn, slowQueriesPerSecondResetBtn, xvalues);
}
public void getSlowQueriesPerSecChartZoomOutButton() {
    util.graphZoomOut(page, slowQueriesPerSecondZoomInBtn, slowQueriesPerSecondZoomOutBtn, slowQueriesPerSecondResetBtn, xvalues);
}
public void getSlowQueriesPerSecChartZoomResetButton() {
    util.graphZoomReset(page, slowQueriesPerSecondZoomInBtn, slowQueriesPerSecondResetBtn, xvalues);
}
public void getSLowQueriesCountTitle(String readDataFromExcelByUsingKeyProperty) {
    util.ValidateTheTitle(page, slowQueriesCountWidvalidateTitle, readDataFromExcelByUsingKeyProperty);
}
public void getSLowQueriesCountXaxisTitle(String readDataFromExcelByUsingKeyProperty) {
    util.ValidateTheTitle(page, slowQueriesCountXaxisTitle, readDataFromExcelByUsingKeyProperty);
}
public void getSLowQueriesCountYaxisTitle(String readDataFromExcelByUsingKeyProperty) {
    util.ValidateTheTitle(page, slowQueriesCountYaxisTitle, readDataFromExcelByUsingKeyProperty);
}
public void getSLowQueriesCountZoomInButton() {
    util.graphZoomIn(page, slowQueriesCountZoomInBtn, slowQueriesCountResetBtn, xvalues);
}
public void getSLowQueriesCountZoomOutButton() {
    util.graphZoomOut(page, slowQueriesCountZoomInBtn, slowQueriesCountZoomOutBtn, slowQueriesCountResetBtn, xvalues);
}
public void getSLowQueriesCountZoomResetButton() {
    util.graphZoomReset(page, slowQueriesCountZoomInBtn, slowQueriesCountResetBtn, xvalues);
}
public void getQueriesCountChartTitle(String readDataFromExcelByUsingKeyProperty) {
    util.ValidateTheTitle(page, queriesCountWidvalidateTitle, readDataFromExcelByUsingKeyProperty);
}
public void getQueriesCountChartXaxisTitle(String readDataFromExcelByUsingKeyProperty) {
    util.ValidateTheTitle(page, queriesCountXaxisTitle, readDataFromExcelByUsingKeyProperty);
}
public void getQueriesCountChartYaxisTitle(String readDataFromExcelByUsingKeyProperty) {
    util.ValidateTheTitle(page, queriesCountYaxisTitle, readDataFromExcelByUsingKeyProperty);
}
public void getQueriesCountChartZoomInButton() {
    util.graphZoomIn(page, queriesCountZoomInBtn, queriesCountResetBtn, xvalues);
}
public void getQueriesCountChartZoomOutButton() {
    util.graphZoomOut(page, queriesCountZoomInBtn, queriesCountZoomOutBtn, queriesCountResetBtn, xvalues);
}
public void getQueriesCountChartZoomResetButton() {
    util.graphZoomReset(page, queriesCountZoomInBtn, queriesCountResetBtn, xvalues);
}
public void getQueriesPerSecChartTitle(String readDataFromExcelByUsingKeyProperty) {
    util.ValidateTheTitle(page, queriesPerSecondWidvalidateTitle, readDataFromExcelByUsingKeyProperty);
}
public void getQueriesPerSecChartXaxisTitle(String readDataFromExcelByUsingKeyProperty) {
    util.ValidateTheTitle(page, queriesPerSecondXaxisTitle, readDataFromExcelByUsingKeyProperty);
}
public void getQueriesPerSecChartYaxisTitle(String readDataFromExcelByUsingKeyProperty) {
    util.ValidateTheTitle(page, queriesPerSecondYaxisTitle, readDataFromExcelByUsingKeyProperty);
}
public void getQueriesPerSecChartZoomInButton() {
    util.graphZoomIn(page, queriesPerSecondZoomInBtn, queriesPerSecondResetBtn, xvalues);
}
public void getQueriesPerSecChartZoomOutButton() {
    util.graphZoomOut(page, queriesPerSecondZoomInBtn, queriesPerSecondZoomOutBtn, queriesPerSecondResetBtn, xvalues);
}
public void getQueriesPerSecChartZoomResetButton() {
    util.graphZoomReset(page, queriesPerSecondZoomInBtn, queriesPerSecondResetBtn, xvalues);
}
public void getDeadLockCountChartTitle(String readDataFromExcelByUsingKeyProperty) {
    util.ValidateTheTitle(page, deadlockCountWidvalidateTitle, readDataFromExcelByUsingKeyProperty);
}
public void getDeadLockCountChartXaxisTitle(String readDataFromExcelByUsingKeyProperty) {
    util.ValidateTheTitle(page, deadlockCountXaxisTitle, readDataFromExcelByUsingKeyProperty);
}
public void getDeadLockCountChartYaxisTitle(String readDataFromExcelByUsingKeyProperty) {
    util.ValidateTheTitle(page, deadlockCountYaxisTitle, readDataFromExcelByUsingKeyProperty);
}
public void getDeadLockCountChartZoomInButton() {
    util.graphZoomIn(page, deadlockCountZoomInBtn, deadlockCountResetBtn, xvalues);
}
public void getDeadLockCountChartZoomOutButton() {
    util.graphZoomOut(page, deadlockCountZoomInBtn, deadlockCountZoomOutBtn, deadlockCountResetBtn, xvalues);
}
public void getDeadLockCountChartZoomResetButton() {
    util.graphZoomReset(page, deadlockCountZoomInBtn, deadlockCountResetBtn, xvalues);
}
public void getPreparedStatementPerSecChartTitle(String readDataFromExcelByUsingKeyProperty) {
    util.ValidateTheTitle(page, preparedStatementsPerSecondWidvalidateTitle, readDataFromExcelByUsingKeyProperty);
}
public void getPreparedStatementPerSecChartXaxisTitle(String readDataFromExcelByUsingKeyProperty) {
    util.ValidateTheTitle(page, preparedStatementsPerSecondXaxisTitle, readDataFromExcelByUsingKeyProperty);
}
public void getPreparedStatementPerSecChartYaxisTitle(String readDataFromExcelByUsingKeyProperty) {
    util.ValidateTheTitle(page, preparedStatementsPerSecondYaxisTitle, readDataFromExcelByUsingKeyProperty);

}
public void getPreparedStatementPerSecChartZoomInButton() {
    util.graphZoomIn(page, preparedStatementsPerSecondZoomInBtn, preparedStatementsPerSecondResetBtn, xvalues);
}
public void getPreparedStatementPerSecChartZoomOutButton() {
    util.graphZoomOut(page, preparedStatementsPerSecondZoomInBtn, preparedStatementsPerSecondZoomOutBtn, preparedStatementsPerSecondResetBtn, xvalues);
}
public void getPreparedStatementPerSecChartZoomResetButton() {
    util.graphZoomReset(page, preparedStatementsPerSecondZoomInBtn, preparedStatementsPerSecondResetBtn, xvalues);
}
public void validatePreparedStatementsChartTitle(String readDataFromExcelByUsingKeyProperty) {
    util.ValidateTheTitle(page, preparedStatementsWidvalidateTitle, readDataFromExcelByUsingKeyProperty);
}
public void validatePreparedStatementsChartXaxisTitle(String readDataFromExcelByUsingKeyProperty) {
    util.ValidateTheTitle(page, preparedStatementsXaxisTitle, readDataFromExcelByUsingKeyProperty);
}
public void validatePreparedStatementsChartYaxisTitle(String readDataFromExcelByUsingKeyProperty) {
    util.ValidateTheTitle(page, preparedStatementsYaxisTitle, readDataFromExcelByUsingKeyProperty);
}
public void validatePreparedStatementsChartZoomInButton() {
    util.graphZoomIn(page, preparedStatementsZoomInBtn, preparedStatementsResetBtn, xvalues);
}
public void validatePreparedStatementsChartZoomOutButton() {
    util.graphZoomOut(page, preparedStatementsZoomInBtn, preparedStatementsZoomOutBtn, preparedStatementsResetBtn, xvalues);
}
public void validatePreparedStatementsChartZoomResetButton() {
    util.graphZoomReset(page, preparedStatementsZoomInBtn, preparedStatementsResetBtn, xvalues);
}
public void getInnoDBBufferPoolPagesDataToolTip() {
    util.validateWidgetToolTips(page, innoDBBufferPoolPagesDataXaxisLines, innoDBBufferPoolPagesDataToolTipTitle);
}
public void getInnoDBBufferPoolPagesFreeToolTip() {
    util.validateWidgetToolTips(page, InnoDBBufferPoolPagesFreeXaxisLines, InnoDBBufferPoolPagesFreeToolTipTitle);
}
public void getInnoDBRowLockCurrentWaitsToolTip() {
    util.validateWidgetToolTips(page, InnoDBRowLockCurrentWaitsXaxisLines, InnoDBRowLockCurrentWaitsToolTipTitle);
}
public void getInnoDBRowLockTimeAverageToolTip() {
    util.validateWidgetToolTips(page, InnoDBRowLockTimeAverageXaxisLines, InnoDBRowLockTimeAveravalidateoolTipTitle);
}
public void getInnoDBRowLockWaitsPerSecToolTip() {
    util.validateWidgetToolTips(page, InnoDBRowLockWaitsPerSecondXaxisLines, InnoDBRowLockWaitsPerSecondToolTipTitle);
}
public void getQueryInnoDBRowLockWaitsToolTip() {
    util.validateWidgetToolTips(page, InnoDBRowLockWaitsXaxisLines, InnoDBRowLockWaitsoolTipTitle);
}
public void getTotalOpenFilesToolTip() {
    util.validateWidgetToolTips(page, totalOpenFilesXaxisLines, totalOpenFilesToolTipTitle);
}
public void getTotalOpenTablesToolTip() {
    util.validateWidgetToolTips(page, totalOpenTablesXaxisLines, totalOpenTablesToolTipTitle);
}
public void getMaxUsedConnectionsToolTip() {
    util.validateWidgetToolTips(page, maxUsedConnectionsXaxisLines, maxUsedConnectionsToolTipTitle);
}
public void getNetConnectionErrorsPerSecToolTip() {
    util.validateWidgetToolTips(page, netConnectionErrorsPerSecondXaxisLines, netConnectionErrorsPerSecondToolTipTitle);
}
public void getNetConnectionErrorsToolTip() {
    util.validateWidgetToolTips(page, netConnectionErrorsXaxisLines, netConnectionErrorsToolTipTitle);
}
public void getSelectQueriesCountToolTip() {
    util.validateWidgetToolTips(page, selectQueriesCountXaxisLines, selectQueriesCountToolTipTitle);
}
public void getInsertQueriesCountToolTip() {
    util.validateWidgetToolTips(page, insertQueriesCountXaxisLines, insertQueriesCountToolTipTitle);
}
public void getSelectQueriesPerSecToolTip() {
    util.validateWidgetToolTips(page, selectQueriesPerSecondXaxisLines, selectQueriesPerSecondToolTipTitle);
}
public void getInsertQueriesPerSecToolTip() {
    util.validateWidgetToolTips(page, insertQueriesPerSecondXaxisLines, insertQueriesPerSecondToolTipTitle);
}
public void getSlowQueriesPerSecToolTip() {
    util.validateWidgetToolTips(page, slowQueriesPerSecondXaxisLines, slowQueriesPerSecondToolTipTitle);
}
public void getSlowQueriesCountToolTip() {
    util.validateWidgetToolTips(page, slowQueriesCountXaxisLines, slowQueriesCountToolTipTitle);
}
public void getQueriesCountToolTip() {
    util.validateWidgetToolTips(page, queriesCountXaxisLines, queriesCountToolTipTitle);
}
public void getQueriesPerSecToolTip() {
    util.validateWidgetToolTips(page, queriesPerSecondXaxisLines, queriesPerSecondToolTipTitle);
}
public void getDeadlockCountToolTip() {
    util.validateWidgetToolTips(page, deadlockCountXaxisLines, deadlockCountToolTipTitle);
}
public void getPreparedStatementsPerSecToolTip() {
    util.validateWidgetToolTips(page, preparedStatementsPerSecondXaxisLines, preparedStatementsPerSecondToolTipTitle);
}
public void getPreparedStatementsToolTip() {
    util.validateWidgetToolTips(page, preparedStatementsXaxisLines, preparedStatementsToolTipTitle);
}
public void validateTheGivenTimeLine()
{
	util.validateTheGraphdisplayingTheDataAsPerGivenTimeLines(page,innoDBBufferPoolPagesDataXaxisValues,calendarValue, xvalues );
}
public void validateTheCustomTimeLine(String period)
{
	util.validateCustomTimeLine(page,innoDBBufferPoolPagesDataXaxisValues,period,xvalues);
}
public void clickOnRefreshButton() {
   page.click(refreshButton);
}

public void InnoDBBufferPoolPageDataExpandTimelineChart() {
    util.graphZoomInByDragAndDrop(page, innoDBBufferPoolPagesDataXaxisLines, innoDBBufferPoolPagesDataResetBtn, xvalues);
}
public void getInnoDBBufferPoolPageFreeExpandTimelineChart() {
    util.graphZoomInByDragAndDrop(page, InnoDBBufferPoolPagesFreeXaxisLines, InnoDBBufferPoolPagesFreeResetBtn, xvalues);
}
public void getInnoDBRowLockCurrentWaitsExpandTimelineChart() {
    util.graphZoomInByDragAndDrop(page, InnoDBRowLockCurrentWaitsXaxisLines, InnoDBRowLockCurrentWaitsResetBtn, xvalues);
}
public void getInnoDBRowLockWaitsPerSecExpandTimeLineChart() {
    util.graphZoomInByDragAndDrop(page, InnoDBRowLockWaitsPerSecondXaxisLines, InnoDBRowLockWaitsPerSecondResetBtn, xvalues);
}
public void getInnoDBRowLockWaitsExpandTimeLineChart() {
    util.graphZoomInByDragAndDrop(page, InnoDBRowLockWaitsXaxisLines, InnoDBRowLockCurrentWaitsResetBtn, xvalues);
}
public void getInnoDBRowLockTimeAverageExpandTimelineChart() {
    util.graphZoomInByDragAndDrop(page, InnoDBRowLockTimeAverageXaxisLines, InnoDBRowLockTimeAverageResetBtn, xvalues);
}
public void getTotalOpenFilesExpandTimeLineChart() {
    util.graphZoomInByDragAndDrop(page, totalOpenFilesXaxisLines, totalOpenFilesResetBtn, xvalues);
}
public void getTotalOpenTablesExpandTimeLineChart() {
    util.graphZoomInByDragAndDrop(page, totalOpenTablesXaxisLines, totalOpenTablesResetBtn, xvalues);
}
public void getMaxUsedConnectionsExpandTimeLineChart() {
    util.graphZoomInByDragAndDrop(page, maxUsedConnectionsXaxisLines, maxUsedConnectionsResetBtn, xvalues);
}
public void getNetConnectionErrorPerSecExpandTimeLineChart() {
    util.graphZoomInByDragAndDrop(page, netConnectionErrorsPerSecondXaxisLines, netConnectionErrorsPerSecondResetBtn, xvalues);
}
public void getNetConnectionErrorsExpandTimeLineChart() {
    util.graphZoomInByDragAndDrop(page, netConnectionErrorsXaxisLines, netConnectionErrorsResetBtn, xvalues);
}
public void getSelectQueriesCountExpandTimeLineChart() {
    util.graphZoomInByDragAndDrop(page, selectQueriesCountXaxisLines, selectQueriesCountResetBtn, xvalues);
}
public void getInsertQueriesCountExpandTimeLineChart() {
    util.graphZoomInByDragAndDrop(page, insertQueriesCountXaxisLines, insertQueriesCountResetBtn, xvalues);
}
public void getSelectQueriesPerSecExpandTimeLineChart() {
    util.graphZoomInByDragAndDrop(page, selectQueriesPerSecondXaxisLines, selectQueriesPerSecondResetBtn, xvalues);
}
public void getInsertQueriesPerSecExpandTimeLineChart() {
    util.graphZoomInByDragAndDrop(page, insertQueriesPerSecondXaxisLines, insertQueriesPerSecondResetBtn, xvalues);
}
public void getSlowQueriesPerSecExpandTimeLineChart() {
    util.graphZoomInByDragAndDrop(page, slowQueriesPerSecondXaxisLines, slowQueriesPerSecondResetBtn, xvalues);
}
public void getSlowQueriesCountExpandTimeLineChart() {
    util.graphZoomInByDragAndDrop(page, slowQueriesCountXaxisLines, slowQueriesCountResetBtn, xvalues);
}
public void getQueriesCountExpandTimeLineChart() {
    util.graphZoomInByDragAndDrop(page, queriesCountXaxisLines, queriesCountResetBtn, xvalues);
}
public void getQueriesPerSecExpandTimeLineChart() {
    util.graphZoomInByDragAndDrop(page, queriesPerSecondXaxisLines, queriesPerSecondResetBtn, xvalues);
}
public void getDeadLockCountExpandTimeLineChart() {
    util.graphZoomInByDragAndDrop(page, deadlockCountXaxisLines, deadlockCountResetBtn, xvalues);
}
public void getPreparedStatementPerSecExpandTimeLineChart() {
    util.graphZoomInByDragAndDrop(page, preparedStatementsPerSecondXaxisLines, preparedStatementsPerSecondResetBtn, xvalues);
}
public void getPreparedStatementsExpandTimeLineChart() {
    util.graphZoomInByDragAndDrop(page, preparedStatementsXaxisLines, preparedStatementsResetBtn, xvalues);
}


}
