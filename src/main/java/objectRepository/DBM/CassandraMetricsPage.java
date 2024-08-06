package objectRepository.DBM;

import com.microsoft.playwright.Page;
import genericUtilities.GenericMethods;
import objectRepository.CommonPage;

import java.util.ArrayList;
import java.util.List;

public class CassandraMetricsPage {
    Page page;
    GenericMethods util=new GenericMethods();
    CommonPage comPage = new CommonPage(page);

    private String loadGraphTitle="xpath =//div[@id='apexchartsvuechart-area-0']/ancestor::div[@class='chart-body']/preceding-sibling::div[@class='line-header']/div[@class='line-title']" ;
        private String loadGraphYaxisTitle="xpath =//div[@id='apexchartsvuechart-area-0']/descendant::*[name()='g' and @class='apexcharts-yaxis-title']" ;
        private String loadGraphXaxisTitle="xpath =//div[@id='apexchartsvuechart-area-0']/descendant::*[name()='g' and @class='apexcharts-xaxis-title']" ;
        private String loadGraphZoomOutBtn="id =Load-zoom-out" ;
        private String loadGraphZoomInBtn="id =Load-zoom-in" ;
        private String loadGraphZoomResetBtn="id =Load-zoom-reset" ;
        private String loadGraphXaxisPoints="xpath =//div[@id='apexchartsvuechart-area-0']/descendant::*[name()='line' and @class='apexcharts-xaxis-tick']" ;
        private String loadGraphTooltipTitle="xpath =//div[@id='apexchartsvuechart-area-0']/descendant::div[@class='apexcharts-tooltip-title']" ;
        private String loadGraphTooltipValue="xpath =//div[@id='apexchartsvuechart-area-0']/descendant::span[@class='apexcharts-tooltip-text-y-value']" ;
        private String loadXaxisValues="xpath =//div[@id='apexchartsvuechart-area-0']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-label apexcharts-xaxis-label']/child::*[name()='tspan' and contains(.,'-')]" ;
        private String databaseSizeXaxisValues="xpath =//div[@id='apexchartsvuechart-area-1']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-label apexcharts-xaxis-label']/child::*[name()='tspan' and contains(.,'-')]";

        private String SSTablePendingHintsXaxisValues ="xpath =//div[@id='apexchartsvuechart-area-2']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-label apexcharts-xaxis-label']/child::*[name()='tspan' and contains(.,'-')]";

        private String latencyXaxisValues ="xpath =//div[@id='apexchartsvuechart-area-3']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-label apexcharts-xaxis-label']/child::*[name()='tspan' and contains(.,'-')]";
        private String keyspaceCountXaxisValues ="xpath =//div[@id='apexchartsvuechart-area-4']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-label apexcharts-xaxis-label']/child::*[name()='tspan' and contains(.,'-')]";

        private String preparedStatementsXaxisValues ="xpath =//div[@id='apexchartsvuechart-area-5']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-label apexcharts-xaxis-label']/child::*[name()='tspan' and contains(.,'-')]";

        private String taskXaxisValues ="xpath =//div[@id='apexchartsvuechart-area-6']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-label apexcharts-xaxis-label']/child::*[name()='tspan' and contains(.,'-')]";

        private String cacheXaxisValues ="xpath =//div[@id='apexchartsvuechart-area-7']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-label apexcharts-xaxis-label']/child::*[name()='tspan' and contains(.,'-')]";

        private String localReadScanWriteXaxisValues ="xpath =//div[@id='apexchartsvuechart-area-8']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-label apexcharts-xaxis-label']/child::*[name()='tspan' and contains(.,'-')]";

        private String compactionXaxisValues ="xpath =//div[@id='apexchartsvuechart-area-9']/descendant::*[name()='text' and @class='apexcharts-text apexcharts-xaxis-label apexcharts-xaxis-label']/child::*[name()='tspan' and contains(.,'-')]";

        private String localReadScanWriteGraphTitle ="xpath =//div[@id='apexchartsvuechart-area-7']/ancestor::div[@class='chart-body']/preceding-sibling::div[@class='line-header']/div[@class='line-title']";

        private String databaseSizeGraphTitle="xpath =//div[@id='apexchartsvuechart-area-1']/ancestor::div[@class='chart-body']/preceding-sibling::div[@class='line-header']/div[@class='line-title']" ;
        private String databaseSizeGraphYaxisTitle="xpath =//div[@id='apexchartsvuechart-area-1']/descendant::*[name()='g' and @class='apexcharts-yaxis-title']" ;
        private String databaseSizeGraphXaxisTitle="xpath =//div[@id='apexchartsvuechart-area-1']/descendant::*[name()='g' and @class='apexcharts-xaxis-title']" ;
        private String databaseSizeGraphZoomOutBtn="id =Database-Size-zoom-out" ;
        private String databaseSizeGraphZoomInBtn="id =Database-Size-zoom-in" ;
        private String databaseSizeGraphZoomResetBtn="id =Database-Size-zoom-reset" ;
        private String databaseSizeGraphXaxisPoints="xpath =//div[@id='apexchartsvuechart-area-1']/descendant::*[name()='line' and @class='apexcharts-xaxis-tick']" ;
        private String databaseSizeGraphTooltipTitle="xpath =//div[@id='apexchartsvuechart-area-1']/descendant::div[@class='apexcharts-tooltip-title']" ;
        private String databaseSizeGraphTooltipValue="xpath =//div[@id='apexchartsvuechart-area-1']/descendant::span[@class='apexcharts-tooltip-text-y-value']" ;

        private String ssTablePendingHintsGraphTitle="xpath =//div[@id='apexchartsvuechart-area-2']/ancestor::div[@class='chart-body']/preceding-sibling::div[@class='line-header']/div[@class='line-title']" ;
        private String ssTablePendingHintsGraphYaxisTitle="xpath =//div[@id='apexchartsvuechart-area-2']/descendant::*[name()='g' and @class='apexcharts-yaxis-title']" ;
        private String ssTablePendingHintsGraphXaxisTitle="xpath =//div[@id='apexchartsvuechart-area-2']/descendant::*[name()='g' and @class='apexcharts-xaxis-title']" ;
        private String ssTablePendingHintsGraphZoomOutBtn="id =SS-Table-&-Pending-Hints-zoom-out" ;
        private String ssTablePendingHintsGraphZoomInBtn="id =SS-Table-&-Pending-Hints-zoom-in" ;
        private String ssTablePendingHintsGraphZoomResetBtn="id =SS-Table-&-Pending-Hints-zoom-reset" ;
        private String ssTablePendingHintsGraphXaxisPoints="xpath =//div[@id='apexchartsvuechart-area-2']/descendant::*[name()='line' and @class='apexcharts-xaxis-tick']" ;
        private String ssTablePendingHintsGraphTooltipTitle="xpath =//div[@id='apexchartsvuechart-area-2']/descendant::div[@class='apexcharts-tooltip-title']" ;
        private String ssTablePendingHintsGraphTooltipLabel="xpath =//div[@id='apexchartsvuechart-area-2']/descendant::span[@class='apexcharts-tooltip-text-y-label']" ;
        private String ssTablePendingHintsGraphTooltipValue="xpath =//div[@id='apexchartsvuechart-area-2']/descendant::span[@class='apexcharts-tooltip-text-y-value']" ;
        private String ssTablePendingHintsGraphLegends="xpath =//div[@id='apexchartsvuechart-area-2']//span[@class='apexcharts-legend-text']" ;
        private String ssTablePendingHintsGraphActiveLegend="xpath =//div[@id='apexchartsvuechart-area-2']//span[@class='apexcharts-legend-marker']" ;
        private String ssTablePendingHintsGraphActiveLegendLine="xpath =//div[@id='apexchartsvuechart-area-2']//*[name()='g' and @class='apexcharts-series']//*[name()='circle']" ;

        private String latencyGraphTitle="xpath =//div[@id='apexchartsvuechart-area-3']/ancestor::div[@class='chart-body']/preceding-sibling::div[@class='line-header']/div[@class='line-title']" ;
        private String latencyGraphYaxisTitle="xpath =//div[@id='apexchartsvuechart-area-3']/descendant::*[name()='g' and @class='apexcharts-yaxis-title']" ;
        private String latencyGraphXaxisTitle="xpath =//div[@id='apexchartsvuechart-area-3']/descendant::*[name()='g' and @class='apexcharts-xaxis-title']" ;
        private String latencyGraphZoomOutBtn="id =SS-Table-&-Pending-Hints-zoom-out" ;
        private String latencyGraphZoomInBtn="id =SS-Table-&-Pending-Hints-zoom-in" ;
        private String latencyGraphZoomResetBtn="id =SS-Table-&-Pending-Hints-zoom-reset" ;
        private String latencyGraphXaxisPoints="xpath =//div[@id='apexchartsvuechart-area-3']/descendant::*[name()='line' and @class='apexcharts-xaxis-tick']" ;
        private String latencyGraphTooltipTitle="xpath =//div[@id='apexchartsvuechart-area-3']/descendant::div[@class='apexcharts-tooltip-title']" ;
        private String latencyGraphTooltipLabel="xpath =//div[@id='apexchartsvuechart-area-3']/descendant::span[@class='apexcharts-tooltip-text-y-label']" ;
        private String latencyGraphTooltipValue="xpath =//div[@id='apexchartsvuechart-area-3']/descendant::span[@class='apexcharts-tooltip-text-y-value']" ;
        private String latencyGraphLegends="xpath =//div[@id='apexchartsvuechart-area-3']//span[@class='apexcharts-legend-text']" ;
        private String latencyGraphActiveLegend="xpath =//div[@id='apexchartsvuechart-area-3']//span[@class='apexcharts-legend-marker']" ;
        private String latencyGraphActiveLegendLine="xpath =//div[@id='apexchartsvuechart-area-3']//*[name()='g' and @class='apexcharts-series']//*[name()='circle']" ;

        private String keyspaceCountGraphTitle="xpath =//div[@id='apexchartsvuechart-area-4']/ancestor::div[@class='chart-body']/preceding-sibling::div[@class='line-header']/div[@class='line-title']" ;
        private String keyspaceCountGraphYaxisTitle="xpath =//div[@id='apexchartsvuechart-area-4']/descendant::*[name()='g' and @class='apexcharts-yaxis-title']" ;
        private String keyspaceCountGraphXaxisTitle="xpath =//div[@id='apexchartsvuechart-area-4']/descendant::*[name()='g' and @class='apexcharts-xaxis-title']" ;
        private String keyspaceCountGraphZoomOutBtn="id =Keyspace-Count-zoom-out" ;
        private String keyspaceCountGraphZoomInBtn="id =Keyspace-Count-zoom-in" ;
        private String keyspaceCountGraphZoomResetBtn="id =Keyspace-Count-zoom-reset" ;
        private String keyspaceCountGraphXaxisPoints="xpath =//div[@id='apexchartsvuechart-area-4']/descendant::*[name()='line' and @class='apexcharts-xaxis-tick']" ;
        private String keyspaceCountGraphTooltipTitle="xpath =//div[@id='apexchartsvuechart-area-4']/descendant::div[@class='apexcharts-tooltip-title']" ;
        private String keyspaceCountGraphTooltipValue="xpath =//div[@id='apexchartsvuechart-area-4']/descendant::span[@class='apexcharts-tooltip-text-y-value']" ;

        private String preparedStatementsGraphTitle="xpath =//div[@id='apexchartsvuechart-area-5']/ancestor::div[@class='chart-body']/preceding-sibling::div[@class='line-header']/div[@class='line-title']" ;
        private String preparedStatementsGraphYaxisTitle="xpath =//div[@id='apexchartsvuechart-area-5']/descendant::*[name()='g' and @class='apexcharts-yaxis-title']" ;
        private String preparedStatementsGraphXaxisTitle="xpath =//div[@id='apexchartsvuechart-area-5']/descendant::*[name()='g' and @class='apexcharts-xaxis-title']" ;
        private String preparedStatementsGraphZoomOutBtn="id =SS-Table-&-Pending-Hints-zoom-out" ;
        private String preparedStatementsGraphZoomInBtn="id =SS-Table-&-Pending-Hints-zoom-in" ;
        private String preparedStatementsGraphZoomResetBtn="id =SS-Table-&-Pending-Hints-zoom-reset" ;
        private String preparedStatementsGraphTooltipTitle="xpath =//div[@id='apexchartsvuechart-area-5']/descendant::div[@class='apexcharts-tooltip-title']" ;
        private String preparedStatementsGraphTooltipLabel="xpath =//div[@id='apexchartsvuechart-area-5']/descendant::span[@class='apexcharts-tooltip-text-y-label']" ;
        private String preparedStatementsGraphTooltipValue="xpath =//div[@id='apexchartsvuechart-area-5']/descendant::span[@class='apexcharts-tooltip-text-y-value']" ;
        private String preparedStatementsGraphLegends="xpath =//div[@id='apexchartsvuechart-area-5']//span[@class='apexcharts-legend-text']" ;
        private String preparedStatementsGraphActiveLegend="xpath =//div[@id='apexchartsvuechart-area-5']//span[@class='apexcharts-legend-marker']" ;
        private String preparedStatementsGraphActiveLegendLine="xpath =//div[@id='apexchartsvuechart-area-5']//*[name()='g' and @class='apexcharts-series']//*[name()='circle']" ;

        private String taskGraphTitle="xpath =//div[@id='apexchartsvuechart-area-6']/ancestor::div[@class='chart-body']/preceding-sibling::div[@class='line-header']/div[@class='line-title']" ;
        private String taskGraphYaxisTitle="xpath =//div[@id='apexchartsvuechart-area-6']/descendant::*[name()='g' and @class='apexcharts-yaxis-title']" ;
        private String taskGraphXaxisTitle="xpath =//div[@id='apexchartsvuechart-area-6']/descendant::*[name()='g' and @class='apexcharts-xaxis-title']" ;
        private String taskGraphZoomOutBtn="id =Task-zoom-out" ;
        private String taskGraphZoomInBtn="id =Task-zoom-in" ;
        private String taskGraphZoomResetBtn="id =Task-zoom-reset" ;
        private String taskGraphXaxisPoints="xpath =//div[@id='apexchartsvuechart-area-6']/descendant::*[name()='line' and @class='apexcharts-xaxis-tick']" ;
        private String taskGraphTooltipTitle="xpath =//div[@id='apexchartsvuechart-area-6']/descendant::div[@class='apexcharts-tooltip-title']" ;
        private String taskGraphTooltipLabel="xpath =//div[@id='apexchartsvuechart-area-6']/descendant::span[@class='apexcharts-tooltip-text-y-label']" ;
        private String taskGraphTooltipValue="xpath =//div[@id='apexchartsvuechart-area-6']/descendant::span[@class='apexcharts-tooltip-text-y-value']" ;
        private String taskGraphLegends="xpath =//div[@id='apexchartsvuechart-area-6']//span[@class='apexcharts-legend-text']" ;
        private String taskGraphActiveLegend="xpath =//div[@id='apexchartsvuechart-area-6']//span[@class='apexcharts-legend-marker']" ;
        private String taskGraphActiveLegendLine="xpath =//div[@id='apexchartsvuechart-area-6']//*[name()='g' and @class='apexcharts-series']//*[name()='circle']" ;

        private String ScanWriteGraphTitle="xpath =//div[@id='apexchartsvuechart-area-7']/ancestor::div[@class='chart-body']/preceding-sibling::div[@class='line-header']/div[@class='line-title']" ;
        private String localReadScanWriteGraphYaxisTitle="xpath =//div[@id='apexchartsvuechart-area-7']/descendant::*[name()='g' and @class='apexcharts-yaxis-title']" ;
        private String localReadScanWriteGraphXaxisTitle="xpath =//div[@id='apexchartsvuechart-area-7']/descendant::*[name()='g' and @class='apexcharts-xaxis-title']" ;
        private String localReadScanWriteGraphZoomOutBtn="id =Local-Read,-Scan,-Write-zoom-out" ;
        private String localReadScanWriteGraphZoomInBtn="id =Local-Read,-Scan,-Write-zoom-in" ;
        private String localReadScanWriteGraphZoomResetBtn="id =Local-Read,-Scan,-Write-zoom-reset" ;
        private String localReadScanWriteGraphXaxisPoints="xpath =//div[@id='apexchartsvuechart-area-7']/descendant::*[name()='line' and @class='apexcharts-xaxis-tick']" ;
        private String localReadScanWriteGraphTooltipTitle="xpath =//div[@id='apexchartsvuechart-area-7']/descendant::div[@class='apexcharts-tooltip-title']" ;
        private String localReadScanWriteGraphTooltipLabel="xpath =//div[@id='apexchartsvuechart-area-7']/descendant::span[@class='apexcharts-tooltip-text-y-label']" ;
        private String localReadScanWriteGraphTooltipValue="xpath =//div[@id='apexchartsvuechart-area-7']/descendant::span[@class='apexcharts-tooltip-text-y-value']" ;
        private String localReadScanWriteGraphLegends="xpath =//div[@id='apexchartsvuechart-area-7']//span[@class='apexcharts-legend-text']" ;
        private String localReadScanWriteGraphActiveLegend="xpath =//div[@id='apexchartsvuechart-area-7']//span[@class='apexcharts-legend-marker']" ;
        private String localReadScanWriteGraphActiveLegendLine="xpath =//div[@id='apexchartsvuechart-area-7']//*[name()='g' and @class='apexcharts-series']//*[name()='circle']" ;

        private String cacheGraphTitle="xpath =//div[@id='apexchartsvuechart-area-8']/ancestor::div[@class='chart-body']/preceding-sibling::div[@class='line-header']/div[@class='line-title']" ;
        private String cacheGraphYaxisTitle="xpath =//div[@id='apexchartsvuechart-area-8']/descendant::*[name()='g' and @class='apexcharts-yaxis-title']" ;
        private String cacheGraphXaxisTitle="xpath =//div[@id='apexchartsvuechart-area-8']/descendant::*[name()='g' and @class='apexcharts-xaxis-title']" ;
        private String cacheGraphZoomOutBtn="id =Cache-zoom-out" ;
        private String cacheGraphZoomInBtn="id =Cache-zoom-in" ;
        private String cacheGraphZoomResetBtn="id =Cache-zoom-reset" ;
        private String cacheGraphXaxisPoints="xpath =//div[@id='apexchartsvuechart-area-8']/descendant::*[name()='line' and @class='apexcharts-xaxis-tick']" ;
        private String cacheGraphTooltipTitle="xpath =//div[@id='apexchartsvuechart-area-8']/descendant::div[@class='apexcharts-tooltip-title']" ;
        private String cacheGraphTooltipLabel="xpath =//div[@id='apexchartsvuechart-area-8']/descendant::span[@class='apexcharts-tooltip-text-y-label']" ;
        private String cacheGraphTooltipValue="xpath =//div[@id='apexchartsvuechart-area-8']/descendant::span[@class='apexcharts-tooltip-text-y-value']" ;
        private String cacheGraphLegends="xpath =//div[@id='apexchartsvuechart-area-8']//span[@class='apexcharts-legend-text']" ;
        private String cacheGraphActiveLegend="xpath =//div[@id='apexchartsvuechart-area-8']//span[@class='apexcharts-legend-marker']" ;
        private String cacheGraphActiveLegendLine="xpath =//div[@id='apexchartsvuechart-area-8']//*[name()='g' and @class='apexcharts-series']//*[name()='circle']" ;

        private String compactionGraphTitle="xpath =//div[@id='apexchartsvuechart-area-9']/ancestor::div[@class='chart-body']/preceding-sibling::div[@class='line-header']/div[@class='line-title']" ;
        private String compactionGraphYaxisTitle="xpath =//div[@id='apexchartsvuechart-area-9']/descendant::*[name()='g' and @class='apexcharts-yaxis-title']" ;
        private String compactionGraphXaxisTitle="xpath =//div[@id='apexchartsvuechart-area-9']/descendant::*[name()='g' and @class='apexcharts-xaxis-title']" ;
        private String compactionGraphZoomOutBtn="id =Compaction-zoom-out" ;
        private String compactionGraphZoomInBtn="id =Compaction-zoom-in" ;
        private String compactionGraphZoomResetBtn="id =Compaction-zoom-reset" ;
        private String compactionGraphTooltipTitle="xpath =//div[@id='apexchartsvuechart-area-9']/descendant::div[@class='apexcharts-tooltip-title']" ;
        private String compactionGraphTooltipLabel="xpath =//div[@id='apexchartsvuechart-area-9']/descendant::span[@class='apexcharts-tooltip-text-y-label']" ;
        private String compactionGraphTooltipValue="xpath =//div[@id='apexchartsvuechart-area-9']/descendant::span[@class='apexcharts-tooltip-text-y-value']" ;
        private String compactionGraphLegends="xpath =//div[@id='apexchartsvuechart-area-9']//span[@class='apexcharts-legend-text']" ;
        private String compactionGraphActiveLegend="xpath =//div[@id='apexchartsvuechart-area-9']//span[@class='apexcharts-legend-marker']" ;
        private String compactionGraphActiveLegendLine="xpath =//div[@id='apexchartsvuechart-area-9']//*[name()='g' and @class='apexcharts-series']//*[name()='circle']" ;
        private String selectDatabaseTypeDropDown= "id =btn-arrow-down-search-select-database-type";
        private String metricsTab="xpath =//div[@class='item' and .='Metrics ']";
        private String calanderValue = "xpath = //div[@class='selected-text ellipsis bg-text']";

        private String latencyGraphLines = "xpath = //div[@id='apexchartsvuechart-area-3']//*[name()='g' and @class='apexcharts-series']//*[name()='path' and @fill='none']";

        private String SSTablePendingHintsGraphLines = "xpath = //div[@id='apexchartsvuechart-area-2']//*[name()='g' and @class='apexcharts-series']//*[name()='path' and @fill='none']";

        private String preparedStatementsGraphLines = "xpath = //div[@id='apexchartsvuechart-area-5']//*[name()='g' and @class='apexcharts-series']//*[name()='path' and @fill='none']";

        private String taskGraphLines = "xpath = //div[@id='apexchartsvuechart-area-6']//*[name()='g' and @class='apexcharts-series']//*[name()='path' and @fill='none']";

        private String localReadScanWriteGraphLines = "xpath = //div[@id='apexchartsvuechart-area-7']//*[name()='g' and @class='apexcharts-series']//*[name()='path' and @fill='none']";

        private String cacheGraphLines = "xpath = //div[@id='apexchartsvuechart-area-8']//*[name()='g' and @class='apexcharts-series']//*[name()='path' and @fill='none']";

        private String compactionGraphLines = "xpath = //div[@id='apexchartsvuechart-area-9']//*[name()='g' and @class='apexcharts-series']//*[name()='path' and @fill='none']";



    private String ssTablePendingHintsGraphToolTipLabels = "xpath = //div[@id='apexchartsvuechart-area-2']/descendant::div[@class='apexcharts-tooltip-text']/descendant::span[@class='apexcharts-tooltip-text-y-label']";

    private String latencyGraphToolTipLabels = "xpath = //div[@id='apexchartsvuechart-area-3']/descendant::div[@class='apexcharts-tooltip-text']/descendant::span[@class='apexcharts-tooltip-text-y-label']";
    private String preparedStatementsGraphToolTipLabels = "xpath = //div[@id='apexchartsvuechart-area-5']/descendant::div[@class='apexcharts-tooltip-text']/descendant::span[@class='apexcharts-tooltip-text-y-label']";

    private String taskGraphToolTipLabels = "xpath = //div[@id='apexchartsvuechart-area-6']/descendant::div[@class='apexcharts-tooltip-text']/descendant::span[@class='apexcharts-tooltip-text-y-label']";

    private String localReadScanWriteGraphToolTipLabels = "xpath = //div[@id='apexchartsvuechart-area-7']/descendant::div[@class='apexcharts-tooltip-text']/descendant::span[@class='apexcharts-tooltip-text-y-label']";

    private String cacheGraphToolTipLabels = "xpath = //div[@id='apexchartsvuechart-area-8']/descendant::div[@class='apexcharts-tooltip-text']/descendant::span[@class='apexcharts-tooltip-text-y-label']";

    private String compactionGraphToolTipLabels = "xpath = //div[@id='apexchartsvuechart-area-9']/descendant::div[@class='apexcharts-tooltip-text']/descendant::span[@class='apexcharts-tooltip-text-y-label']";

    private String latencyGraphToolTipWidgetColour = "xpath = //div[@id='apexchartsvuechart-area-3']//span[@class='apexcharts-tooltip-marker']";

    private String SSTablePendingHintsGraphToolTipWidgetColour = "xpath = //div[@id='apexchartsvuechart-area-2']//span[@class='apexcharts-tooltip-marker']";

    private String preparedStatementsGraphToolTipWidgetColour = "xpath = //div[@id='apexchartsvuechart-area-5']//span[@class='apexcharts-tooltip-marker']";

    private String taskGraphToolTipWidgetColour = "xpath = //div[@id='apexchartsvuechart-area-6']//span[@class='apexcharts-tooltip-marker']";

    private String localReadScanWriteGraphToolTipWidgetColour = "xpath = //div[@id='apexchartsvuechart-area-7']//span[@class='apexcharts-tooltip-marker']";

    private String cacheGraphToolTipWidgetColour = "xpath = //div[@id='apexchartsvuechart-area-8']//span[@class='apexcharts-tooltip-marker']";

    private String compactionGraphToolTipWidgetColour = "xpath = //div[@id='apexchartsvuechart-area-9']//span[@class='apexcharts-tooltip-marker']";

    private String preparedStatementsXaxisPoints="xpath= //div[@id='apexchartsvuechart-area-5']/descendant::*[name()='line' and @class='apexcharts-xaxis-tick']";

    private String compactionXaxisPoints="xpath= //div[@id='apexchartsvuechart-area-9']/descendant::*[name()='line' and @class='apexcharts-xaxis-tick']";

    private String latencyGraphLegendsColourlist = "xpath = //div[@id='apexchartsvuechart-area-3']//span[@class='apexcharts-legend-marker']";

    private String ssTablePendingHintsGraphLegendsColourList="xpath = //div[@id='apexchartsvuechart-area-2']//span[@class='apexcharts-legend-marker']" ;

    private String preparedStatementsGraphLegendsColourList = "xpath = //div[@id='apexchartsvuechart-area-5']//span[@class='apexcharts-legend-marker']";

    private String taskGraphLegendsColourList = "xpath = //div[@id='apexchartsvuechart-area-6']//span[@class='apexcharts-legend-marker']";

    private String localReadScanWriteGraphLegendsColourList = "xpath = //div[@id='apexchartsvuechart-area-7']//span[@class='apexcharts-legend-marker']";

    private String cacheGraphLegendsColourList = "xpath = //div[@id='apexchartsvuechart-area-8']//span[@class='apexcharts-legend-marker']";

    private String compactionGraphLegendsColourList = "xpath = //div[@id='apexchartsvuechart-area-9']//span[@class='apexcharts-legend-marker']";

    private String selectServiceDropDown= "id =btn-arrow-down-search-select-database-service";
    private String firstServiceTypeFromDropDownValue="xpath=//span[@id='search-select-database-type-0-single']/parent::span/parent::div";
    private String selectDataInstanceDropDown= "id =btn-arrow-down-search-select-database-instance";
    private String firstDataInstanceDropDownValue= "id =search-select-database-instance-0-single" ;


    public void selectDataBaseType(String dataBaseName) {
        page.locator(selectDatabaseTypeDropDown).click();
        page.locator("//span[@class='selected-item-text' and text()='" + dataBaseName + "']").click();
    }

    public void selectServiceType() {
        page.locator(selectServiceDropDown).click();
        page.locator(firstServiceTypeFromDropDownValue).click();
    }

    public void selectDataInstanceTypeDropdown() {
        page.locator(selectDataInstanceDropDown).click();
        page.locator(firstDataInstanceDropDownValue).click();
    }

    public void clickOnMetricsTab() {
        page.locator(metricsTab).click();
    }


    public CassandraMetricsPage(Page page) {
        this.page=page;
    }

    public List<String> allWidgetXPoints()
    {
        ArrayList<String> xPoint = new ArrayList<String>();
        xPoint.add(loadGraphXaxisPoints);
        xPoint.add(cacheGraphXaxisPoints);
        xPoint.add(databaseSizeGraphXaxisPoints);
        xPoint.add(keyspaceCountGraphXaxisPoints);
        xPoint.add(taskGraphXaxisPoints);
        xPoint.add(localReadScanWriteGraphXaxisPoints);
        xPoint.add(latencyGraphXaxisPoints);
        xPoint.add(ssTablePendingHintsGraphXaxisPoints);
        xPoint.add(preparedStatementsXaxisPoints);
        xPoint.add(compactionXaxisPoints);

        return xPoint;
    }

    public List<String> allWidgetXValues()
    {
        ArrayList<String> xValue = new ArrayList<String>();
        xValue.add(loadXaxisValues);
        xValue.add(cacheXaxisValues);
        xValue.add(taskXaxisValues);
        xValue.add(latencyXaxisValues);
        xValue.add(keyspaceCountXaxisValues);
        xValue.add(databaseSizeXaxisValues);
        xValue.add(SSTablePendingHintsXaxisValues);
        xValue.add(localReadScanWriteXaxisValues);
        xValue.add(preparedStatementsXaxisValues);
        xValue.add(compactionXaxisValues);

        return xValue;
    }



    public void validateTheLoadGraphTitleTextUnderMetricsTab(String expectedTitle) {
        util.ValidateTheTitle(page, loadGraphTitle, expectedTitle);
    }

    public void validateTheLoadGraphXaxisTitleTextUnderMetricsTab(String expectedTitle) {
        util.ValidateTheTitle(page, loadGraphXaxisTitle, expectedTitle);
    }

    public void validateTheLoadGraphYaxisTitleTextUnderMetricsTab(String expectedTitle) {
        util.ValidateTheTitle(page, loadGraphYaxisTitle, expectedTitle);
    }

    public void validateLoadGraphZoomIn()
    {
        util.graphZoomIn(page, loadGraphZoomInBtn, loadGraphZoomResetBtn, allWidgetXPoints());
    }

    public void validateLoadGraphZoomOut()
    {
        util.graphZoomOut(page,loadGraphZoomInBtn,loadGraphZoomOutBtn,loadGraphZoomResetBtn, allWidgetXPoints());
    }

    public void validateLoadGraphZoomReset()
    {
        util.graphZoomReset(page, loadGraphZoomInBtn,loadGraphZoomResetBtn, allWidgetXPoints());
    }

    public void validateLoadGraphDragDrop()
    {
        util.graphZoomInByDragAndDrop(page,loadGraphXaxisPoints,loadGraphZoomResetBtn, allWidgetXPoints());
    }


    public void validateTheDatabaseSizeGraphTitleTextUnderMetricsTab(String expectedTitle) {
        util.ValidateTheTitle(page, databaseSizeGraphTitle, expectedTitle);
    }

    public void validateTheDatabaseSizeGraphXaxisTitleTextUnderMetricsTab(String expectedTitle) {
        util.ValidateTheTitle(page, databaseSizeGraphXaxisTitle, expectedTitle);
    }

    public void validateTheDatabaseSizeGraphYaxisTitleTextUnderMetricsTab(String expectedTitle) {
        util.ValidateTheTitle(page, databaseSizeGraphYaxisTitle, expectedTitle);
    }

    public void validateDataBaseSizeGraphZoomIn()
    {
        util.graphZoomIn(page, databaseSizeGraphZoomInBtn, databaseSizeGraphZoomResetBtn, allWidgetXPoints());
    }

    public void validateDataBaseSizeGraphZoomOut()
    {
        util.graphZoomOut(page,databaseSizeGraphZoomInBtn,databaseSizeGraphZoomOutBtn,databaseSizeGraphZoomResetBtn, allWidgetXPoints());
    }

    public void validateDataBaseSizeGraphZoomReset()
    {
        util.graphZoomReset(page, databaseSizeGraphZoomInBtn,databaseSizeGraphZoomResetBtn, allWidgetXPoints());
    }

    public void validateDataBaseSizeGraphDragDrop()
    {
        util.graphZoomInByDragAndDrop(page,databaseSizeGraphXaxisPoints,databaseSizeGraphZoomResetBtn, allWidgetXPoints());
    }

    public void validateTheSSTablePendingHintsGraphTitleTextUnderMetricsTab(String expectedTitle) {
        util.ValidateTheTitle(page, ssTablePendingHintsGraphTitle, expectedTitle);
    }

    public void validateTheSSTablePendingHintsGraphXaxisTitleTextUnderMetricsTab(String expectedTitle) {
        util.ValidateTheTitle(page, ssTablePendingHintsGraphXaxisTitle, expectedTitle);
    }

    public void validateTheSSTablePendingHintsGraphYaxisTitleTextUnderMetricsTab(String expectedTitle) {
        util.ValidateTheTitle(page, ssTablePendingHintsGraphYaxisTitle, expectedTitle);
    }

    public void validateSSTablePendingHintsGraphZoomIn()
    {
        util.graphZoomIn(page, ssTablePendingHintsGraphZoomInBtn, ssTablePendingHintsGraphZoomResetBtn, allWidgetXPoints());
    }

    public void validateSSTablePendingHintsGraphZoomOut()
    {
        util.graphZoomOut(page,ssTablePendingHintsGraphZoomInBtn,ssTablePendingHintsGraphZoomOutBtn,ssTablePendingHintsGraphZoomResetBtn, allWidgetXPoints());
    }

    public void validateSSTablePendingHintsGraphZoomReset()
    {
        util.graphZoomReset(page, ssTablePendingHintsGraphZoomInBtn,ssTablePendingHintsGraphZoomResetBtn, allWidgetXPoints());
    }

    public void validateSSTablePendingHintsGraphDragDrop()

    {
        page.waitForTimeout(1000);
        util.graphZoomInByDragAndDrop(page,ssTablePendingHintsGraphXaxisPoints,ssTablePendingHintsGraphZoomResetBtn, allWidgetXPoints());
    }

    public void validateThekeyspaceCountGraphTitleTextUnderMetricsTab(String expectedTitle) {
        util.ValidateTheTitle(page, keyspaceCountGraphTitle, expectedTitle);
    }

    public void validateThekeyspaceCountGraphXaxisTitleTextUnderMetricsTab(String expectedTitle) {
        util.ValidateTheTitle(page, keyspaceCountGraphXaxisTitle, expectedTitle);
    }

    public void validateThekeyspaceCountGraphYaxisTitleTextUnderMetricsTab(String expectedTitle) {
        util.ValidateTheTitle(page, keyspaceCountGraphYaxisTitle, expectedTitle);
    }

    public void validatekeyspaceCountGraphZoomIn()
    {
        util.graphZoomIn(page, ssTablePendingHintsGraphZoomInBtn, ssTablePendingHintsGraphZoomResetBtn, allWidgetXPoints());
    }

    public void validatekeyspaceCountGraphZoomOut()
    {
        util.graphZoomOut(page,ssTablePendingHintsGraphZoomInBtn,ssTablePendingHintsGraphZoomOutBtn,ssTablePendingHintsGraphZoomResetBtn, allWidgetXPoints());
    }

    public void validatekeyspaceCountGraphZoomReset()
    {
        util.graphZoomReset(page, ssTablePendingHintsGraphZoomInBtn,ssTablePendingHintsGraphZoomResetBtn, allWidgetXPoints());
    }

    public void validatekeyspaceCountGraphDragDrop()
    {
        util.graphZoomInByDragAndDrop(page,keyspaceCountGraphXaxisPoints,keyspaceCountGraphZoomResetBtn, allWidgetXPoints());
    }


    public void validateTheLocalReadScanWriteGraphTitleTextUnderMetricsTab(String expectedTitle) {
        util.ValidateTheTitle(page, localReadScanWriteGraphTitle, expectedTitle);
    }

    public void validateTheLocalReadScanWriteGraphXaxisTitleTextUnderMetricsTab(String expectedTitle) {
        util.ValidateTheTitle(page, localReadScanWriteGraphXaxisTitle, expectedTitle);
    }

    public void validateThelocalReadScanWriteGraphYaxisTitleTextUnderMetricsTab(String expectedTitle) {
        util.ValidateTheTitle(page, localReadScanWriteGraphYaxisTitle, expectedTitle);
    }

    public void validateLocalReadScanWriteGraphZoomIn()
    {
        util.graphZoomIn(page, localReadScanWriteGraphZoomInBtn, localReadScanWriteGraphZoomResetBtn, allWidgetXPoints());
    }

    public void validateLocalReadScanWriteGraphZoomOut()
    {
        util.graphZoomOut(page,localReadScanWriteGraphZoomInBtn,localReadScanWriteGraphZoomOutBtn,localReadScanWriteGraphZoomResetBtn, allWidgetXPoints());
    }

    public void validateLocalReadScanWriteGraphZoomReset()
    {
        util.graphZoomReset(page, localReadScanWriteGraphZoomInBtn,localReadScanWriteGraphZoomResetBtn, allWidgetXPoints());
    }

    public void validateLocalReadScanWriteGraphDragDrop()
    {
        util.graphZoomInByDragAndDrop(page,localReadScanWriteGraphXaxisPoints,localReadScanWriteGraphZoomResetBtn, allWidgetXPoints());
    }


    public void validateTheCacheGraphTitleTextUnderMetricsTab(String expectedTitle) {
        util.ValidateTheTitle(page, cacheGraphTitle, expectedTitle);
    }

    public void validateTheCacheGraphXaxisTitleTextUnderMetricsTab(String expectedTitle) {
        util.ValidateTheTitle(page, cacheGraphXaxisTitle, expectedTitle);
    }

    public void validateTheCacheGraphYaxisTitleTextUnderMetricsTab(String expectedTitle) {
        util.ValidateTheTitle(page, cacheGraphYaxisTitle, expectedTitle);
    }

    public void validateCacheGraphZoomIn()
    {
        util.graphZoomIn(page, cacheGraphZoomInBtn, cacheGraphZoomResetBtn, allWidgetXPoints());
    }

    public void validateCacheGraphZoomOut()
    {
        util.graphZoomOut(page,cacheGraphZoomInBtn,cacheGraphZoomOutBtn,cacheGraphZoomResetBtn, allWidgetXPoints());
    }

    public void validateCacheGraphZoomReset()
    {
        util.graphZoomReset(page, cacheGraphZoomInBtn,cacheGraphZoomResetBtn, allWidgetXPoints());
    }

    public void validateCacheGraphDragDrop()
    {
        util.graphZoomInByDragAndDrop(page,cacheGraphXaxisPoints,cacheGraphZoomResetBtn, allWidgetXPoints());
    }

    public void validateTheCompactionGraphTitleTextUnderMetricsTab(String expectedTitle) {
        util.ValidateTheTitle(page, compactionGraphTitle, expectedTitle);
    }

    public void validateTheCompactionGraphXaxisTitleTextUnderMetricsTab(String expectedTitle) {
        util.ValidateTheTitle(page, compactionGraphXaxisTitle, expectedTitle);
    }

    public void validateTheCompactionGraphYaxisTitleTextUnderMetricsTab(String expectedTitle) {
        util.ValidateTheTitle(page, compactionGraphYaxisTitle, expectedTitle);
    }

    public void validateCompactionGraphZoomIn()
    {
        util.graphZoomIn(page,compactionGraphZoomInBtn , compactionGraphZoomResetBtn, allWidgetXPoints());
    }

    public void validateCompactionGraphZoomOut()
    {
        util.graphZoomOut(page,compactionGraphZoomInBtn,compactionGraphZoomOutBtn,compactionGraphZoomResetBtn, allWidgetXPoints());
    }

    public void validateCompactionGraphZoomReset()
    {
        util.graphZoomReset(page, compactionGraphZoomInBtn,compactionGraphZoomResetBtn, allWidgetXPoints());
    }

    public void validateThePreparedStatementsGraphTitleTextUnderMetricsTab(String expectedTitle) {
        util.ValidateTheTitle(page, preparedStatementsGraphTitle, expectedTitle);
    }

    public void validateThePreparedStatementsGraphXaxisTitleTextUnderMetricsTab(String expectedTitle) {
        util.ValidateTheTitle(page, preparedStatementsGraphXaxisTitle, expectedTitle);
    }

    public void validateThePreparedStatementsGraphYaxisTitleTextUnderMetricsTab(String expectedTitle) {
        util.ValidateTheTitle(page, preparedStatementsGraphYaxisTitle, expectedTitle);
    }

    public void validatePreparedStatementsGraphZoomIn()
    {
        util.graphZoomIn(page, preparedStatementsGraphZoomInBtn, preparedStatementsGraphZoomResetBtn, allWidgetXPoints());
    }

    public void validatePreparedStatementsGraphZoomOut()
    {
        util.graphZoomOut(page,preparedStatementsGraphZoomInBtn,preparedStatementsGraphZoomOutBtn,preparedStatementsGraphZoomResetBtn, allWidgetXPoints());
    }

    public void validatePreparedStatementsGraphZoomReset()
    {
        util.graphZoomReset(page, preparedStatementsGraphZoomInBtn,preparedStatementsGraphZoomResetBtn, allWidgetXPoints());
    }

    public void validatePreparedStatementsGraphDragDrop()
    {
        util.graphZoomInByDragAndDrop(page,preparedStatementsXaxisPoints,preparedStatementsGraphZoomResetBtn, allWidgetXPoints());
    }

    public void validateTheTaskGraphTitleTextUnderMetricsTab(String expectedTitle) {
        util.ValidateTheTitle(page, taskGraphTitle, expectedTitle);
    }


    public void validateTheTaskGraphXaxisTitleTextUnderMetricsTab(String expectedTitle) {
        util.ValidateTheTitle(page, taskGraphXaxisTitle, expectedTitle);
    }

    public void validateTheTaskGraphYaxisTitleTextUnderMetricsTab(String expectedTitle) {
        util.ValidateTheTitle(page, taskGraphYaxisTitle, expectedTitle);
    }

    public void validateTaskGraphZoomIn()
    {
        util.graphZoomIn(page, taskGraphZoomInBtn, taskGraphZoomResetBtn, allWidgetXPoints());
    }

    public void validateTaskGraphZoomOut()
    {
        util.graphZoomOut(page,taskGraphZoomInBtn,taskGraphZoomOutBtn,taskGraphZoomResetBtn, allWidgetXPoints());
    }

    public void validateTaskGraphZoomReset()
    {
        util.graphZoomReset(page, taskGraphZoomInBtn,taskGraphZoomResetBtn, allWidgetXPoints());
    }

    public void validateTaskGraphDragDrop()
    {
        util.graphZoomInByDragAndDrop(page,taskGraphXaxisPoints,taskGraphZoomResetBtn, allWidgetXPoints());
    }

    public void validateTheLatencyGraphTitleTextUnderMetricsTab(String expectedTitle) {
        util.ValidateTheTitle(page, latencyGraphTitle, expectedTitle);
    }


    public void validateTheLatencyGraphXaxisTitleTextUnderMetricsTab(String expectedTitle) {
        util.ValidateTheTitle(page, latencyGraphXaxisTitle, expectedTitle);
    }

    public void validateTheLatencyGraphYaxisTitleTextUnderMetricsTab(String expectedTitle) {
        util.ValidateTheTitle(page, latencyGraphYaxisTitle, expectedTitle);
    }

    public void validateLatencyGraphZoomIn()
    {
        util.graphZoomIn(page, latencyGraphZoomInBtn, latencyGraphZoomResetBtn, allWidgetXPoints());
    }

    public void validateLatencyGraphZoomOut()
    {
        util.graphZoomOut(page,latencyGraphZoomInBtn,latencyGraphZoomOutBtn,latencyGraphZoomResetBtn, allWidgetXPoints());
    }

    public void validateLatencyGraphZoomReset()
    {
        util.graphZoomReset(page,latencyGraphZoomInBtn,latencyGraphZoomResetBtn, allWidgetXPoints());
    }

    public void validateLatencyGraphDragDrop()
    {
        util.graphZoomInByDragAndDrop(page,latencyGraphXaxisPoints,latencyGraphZoomResetBtn, allWidgetXPoints());
    }

    public void validateTheGivenTimeLine()
    {
        util.validateTheGraphdisplayingTheDataAsPerGivenTimeLines(page,loadXaxisValues,calanderValue,allWidgetXValues());
    }


    public void validateTheCustomTimeLine(String period)
    {
        util.validateCustomTimeLine(page,loadXaxisValues,period,allWidgetXValues());
    }

    public void validatessTablePendingHintsGraphLegendsText(String expectedLegends)
    {
        util.validateWidgetLegendsText(page,ssTablePendingHintsGraphLegends,expectedLegends);
    }

    public void validatelatencyGraphLegendsText(String expectedLegends)
    {
        util.validateWidgetLegendsText(page,latencyGraphLegends,expectedLegends);
    }

    public void validatepreparedStatementsGraphLegendsText(String expectedLegends)
    {
        util.validateWidgetLegendsText(page,preparedStatementsGraphLegends,expectedLegends);
    }

    public void validatetaskGraphLegendsText(String expectedLegends)
    {
        util.validateWidgetLegendsText(page,taskGraphLegends,expectedLegends);
    }

    public void validatelocalReadScanWriteGraphLegendsText(String expectedLegends)
    {
        util.validateWidgetLegendsText(page,localReadScanWriteGraphLegends,expectedLegends);
    }

    public void validatecacheGraphLegendsText(String expectedLegends)
    {
        util.validateWidgetLegendsText(page,cacheGraphLegends,expectedLegends);
    }

    public void validatecompactionGraphLegendsText(String expectedLegends)
    {
        util.validateWidgetLegendsText(page,compactionGraphLegends,expectedLegends);
    }

    public void validateTheLegendsLatencyGraph()
      {
               util.validateWidgetLegends(page,latencyGraphLegends,latencyGraphLegendsColourlist,latencyGraphLines,latencyGraphToolTipWidgetColour,latencyGraphXaxisPoints,latencyGraphToolTipLabels);
       }

    public void validateTheLegendsSSPendingHintsGraph()
    {
        util.validateWidgetLegends(page,ssTablePendingHintsGraphLegends,ssTablePendingHintsGraphLegendsColourList,SSTablePendingHintsGraphLines,ssTablePendingHintsGraphLegendsColourList,latencyGraphXaxisPoints,latencyGraphToolTipLabels);
    }


    public void validateTheLegendsPreparedStatementsGraph()
    {
        util.validateWidgetLegends(page,preparedStatementsGraphLegends,preparedStatementsGraphLegendsColourList,preparedStatementsGraphLines,preparedStatementsGraphToolTipWidgetColour,preparedStatementsXaxisPoints,preparedStatementsGraphToolTipLabels);

    }

    public void validateTheLegendsTaskGraph()
    {
        util.validateWidgetLegends(page,taskGraphLegends,taskGraphLegendsColourList,taskGraphLines,taskGraphToolTipWidgetColour,taskGraphXaxisPoints,taskGraphToolTipLabels);
    }

    public void validateTheLegendslocalReadScanWriteGraph()
    {
        util.validateWidgetLegends(page,localReadScanWriteGraphLegends,taskGraphLegendsColourList,localReadScanWriteGraphLines,taskGraphToolTipWidgetColour,localReadScanWriteGraphXaxisPoints,localReadScanWriteGraphToolTipLabels);
    }

    public void validateTheLegendsCacheGraphLegends()
    {
        util.validateWidgetLegends(page,cacheGraphLegends,cacheGraphLegendsColourList,cacheGraphLines,cacheGraphToolTipWidgetColour,cacheGraphXaxisPoints,cacheGraphToolTipLabels);
    }

    public void validateTheLegendsCompactionGraphLegends()
    {
        util.validateWidgetLegends(page,compactionGraphLegends,compactionGraphLegendsColourList,compactionGraphLines,compactionGraphToolTipWidgetColour,compactionXaxisPoints,compactionGraphToolTipLabels);
    }




}


