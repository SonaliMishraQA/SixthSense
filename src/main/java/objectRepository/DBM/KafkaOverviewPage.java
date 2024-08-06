package objectRepository.DBM;

import com.microsoft.playwright.Page;

import genericUtilities.ExcelUtility;
import genericUtilities.GenericMethods;

public class KafkaOverviewPage 
{
	Page page;
	GenericMethods util = new GenericMethods();
	ExcelUtility excel = new ExcelUtility();
	
	public KafkaOverviewPage(Page page) {
		this.page = page;
	}


	private String MQMonitoring_Page_Title = "#title-text-mq";
	private String SelectMessageQueueTypeText = "xpath = //div[@class='mqHeader-container']/child::div[1][@class='mqHeader-dropdown']/child::div[@class = 'full']/child::div[@class='heading']";
	private String SelectServiceNameText = "xpath = //div[@class='mqHeader-container']/descendant::div[@class='heading'][position()=2]";
	
	private String SelectMessageQueueDropdown = "#btn-arrow-down-mq-select-message-queue";
	private String MessageQueueSearchboxInputField = "#input-search-sel-mq-select-message-queue";
	private String MessageQueueSearchResults = "#mq-select-message-queue-1-single";
	private String SelectServiceNameDropdown = "#btn-arrow-down-mq-select-service-name";
	private String ServiceNameSearchboxInputField = "#input-search-sel-mq-select-service-name";
	private String ServiceNameSearchResults = "#mq-select-service-name-0-single";
	
	private String OverviewTab = "xpath = //div[@class='navtab']/div[@class='item' and position()=1]/child::div";
	private String ProducerTab = "xpath = //div[@class='navtab']/div[@class='item' and position()=2]/child::div";
	private String ConsumerTab = "xpath = //div[@class='navtab']/div[@class='item' and position()=3]/child::div";
	private String OverviewBrokerTab = "xpath = //div[@class='navtab']/div[@class='item' and position()=4]/child::div";
	private String ZookeeperTab = "xpath = //div[@class='navtab']/div[@class='item' and position()=5]/child::div";
	
	private String OverviewTabTitle = "xpath = //div[@class='router activeRouter']";
    private String NumberOfBrokers = "xpath = //div[@class='card-body']/descendant::div[@class='textLabel'][position()=1]";
    private String NumberOfTopics = "xpath = //div[@class='card-body']/descendant::div[@class='textLabel'][position()=2]" ;
    private String NumberOfPartitions = "xpath = //div[@class='card-body']/descendant::div[@class='textLabel'][position()=3]";
    private String NumberOfProducers = "xpath = //div[@class='card-body']/descendant::div[@class='textLabel'][position()=4]";
    private String NumberOfConsumers = "xpath = //div[@class='card-body']/descendant::div[@class='textLabel'][position()=5]";

	private String BrokerTab = "xpath = //div[@class='overviewTabSelector']/child::div[@class='kafkaTabItem kafkaActiveTab']";
	private String OverviewProducerTab = "xpath = //div[@class='overviewTabSelector']/child::div[@class='kafkaTabItem'][position()=1]";
	private String OverviewConsumerTab = "xpath = //div[@class='overviewTabSelector']/child::div[@class='kafkaTabItem'][position()=2]";
	
	
	//Broker - Bytes In 
	private String BrokerBytesInGraphWidgetTitle = "xpath = //div[@class='graphs-container']/descendant::div[@class='card-header'][position()=1]";
    private String BrokerBytesInGraphZoomOutBtn = "xpath = //div[@id='apexchartschart-kafka_broker_bytes_in_per_sec']/ancestor::div[@class='card-body']/preceding-sibling::div/descendant::span[@class='icon-class'][position()=1]"  ;
    private String BrokerBytesInGraphZoomInBtn = "xpath = //div[@id='apexchartschart-kafka_broker_bytes_in_per_sec']/ancestor::div[@class='card-body']/preceding-sibling::div/descendant::span[@class='icon-class'][position()=2]" ;
    private String BrokerBytesInGraphResetBtn = "xpath = //div[@id='apexchartschart-kafka_broker_bytes_in_per_sec']/ancestor::div[@class='card-body']/preceding-sibling::div/descendant::span[@class='icon-class'][position()=3]" ;
    private String BrokerBytesInGraphXaxisLines = "xpath = //div[@id='apexchartschart-kafka_broker_bytes_in_per_sec']/descendant::*[name()='line' and @class='apexcharts-xaxis-tick']";
    private String BrokerBytesInGraphXaxisValues = "xpath = //div[@id='apexchartschart-kafka_broker_bytes_in_per_sec']/descendant::*[@class='apexcharts-text apexcharts-xaxis-label apexcharts-xaxis-label']/child::*[name()='tspan' and contains(text(),'-')]";
    private String BrokerBytesInGraphXaxisTitle = "xpath = //div[@id='apexchartschart-kafka_broker_bytes_in_per_sec']/descendant::*[@class='apexcharts-text apexcharts-xaxis-title-text chart-lables']";
    private String BrokerBytesInGraphYaxisTitle = "xpath = //div[@id='apexchartschart-kafka_broker_bytes_in_per_sec']/descendant::*[@class='apexcharts-text apexcharts-yaxis-title-text chart-lables']";
    private String BrokerBytesInGraphToolTipTitle = "xpath = //div[@id='apexchartsvuechart-line-0']/ancestor::div[@class='chart-box']/descendant::div[@class='apexcharts-tooltip-title']";
    private String BrokerBytesInGraphTooltipValue = "xpath = //div[@id='apexchartsvuechart-line-0']/ancestor::div[@class='chart-box']/descendant::div[@class='apexcharts-tooltip-text']";
    
    	//BytesIn - Conclusion - Heading
    private String BrokerBytesInGraphBrokerHeader = "xpath = //div[@id='apexchartschart-kafka_broker_bytes_in_per_sec']/ancestor::div[@class='card-body']/descendant::div[@class='header-heading'][position()=1]";
    private String BrokerBytesInGraphBrokerHeaderArrow = "xpath = //div[@id='apexchartschart-kafka_broker_bytes_in_per_sec']/ancestor::div[@class='card-body']/descendant::div[@class='header-heading'][position()=1]/descendant::span[@class='base-icon sort-asc']";
    private String BrokerBytesInGraphAvgHeader = "xpath = //div[@id='apexchartschart-kafka_broker_bytes_in_per_sec']/ancestor::div[@class='card-body']/descendant::div[@class='header-heading'][position()=2]";
    private String BrokerBytesInGraphAvgHeaderArrow = "xpath = //div[@id='apexchartschart-kafka_broker_bytes_in_per_sec']/ancestor::div[@class='card-body']/descendant::div[@class='header-heading'][position()=2]/descendant::span[@class='base-icon sort-asc']";
    private String BrokerBytesInGraphMaxHeader = "xpath = //div[@id='apexchartschart-kafka_broker_bytes_in_per_sec']/ancestor::div[@class='card-body']/descendant::div[@class='header-heading'][position()=3]";
    private String BrokerBytesInGraphMaxHeaderArrow = "xpath = //div[@id='apexchartschart-kafka_broker_bytes_in_per_sec']/ancestor::div[@class='card-body']/descendant::div[@class='header-heading'][position()=3]/descendant::span[@class='base-icon sort-asc']";
    
    		//BytesIn - Conclusion - Reading
    private String BrokerBytesInGraphBrokerRowColor1 = "xpath = //div[@id='apexchartschart-kafka_broker_bytes_in_per_sec']/ancestor::div[@class='graph']/descendant::div[@class='table-body']/descendant::span[@class='dot'][position()=1]";
    private String BrokerBytesInGraphBrokerRowColor2 = "xpath = //div[@id='apexchartschart-kafka_broker_bytes_in_per_sec']/ancestor::div[@class='graph']/descendant::div[@class='table-body']/descendant::span[@class='dot'][position()=2]";
    private String BrokerBytesInGraphBrokerRowColor3 = "xpath = //div[@id='apexchartschart-kafka_broker_bytes_in_per_sec']/ancestor::div[@class='graph']/descendant::div[@class='table-body']/descendant::span[@class='dot'][position()=3]";
    private String BrokerBytesInGraphBrokerRowColor4 = "xpath = //div[@id='apexchartschart-kafka_broker_bytes_in_per_sec']/ancestor::div[@class='graph']/descendant::div[@class='table-body']/descendant::span[@class='dot'][position()=4]";
    private String BrokerBytesInGraphBrokerRowColor5 = "xpath = //div[@id='apexchartschart-kafka_broker_bytes_in_per_sec']/ancestor::div[@class='graph']/descendant::div[@class='table-body']/descendant::span[@class='dot'][position()=5]";
    private String BrokerBytesInGraphBrokerRowColor6 = "xpath = //div[@id='apexchartschart-kafka_broker_bytes_in_per_sec']/ancestor::div[@class='graph']/descendant::div[@class='table-body']/descendant::span[@class='dot'][position()=6]";
    
    
    
    //Broker - Bytes Out
    private String BrokerBytesOutGraphWidgetTitle = "xpath = //div[@class='graphs-container']/descendant::div[@class='card-header'][position()=2]";
    private String BrokerBytesOutGraphZoomOutBtn = "xpath = //div[@id='apexchartschart-kafka_broker_bytes_out_per_sec']/ancestor::div[@class='card-body']/preceding-sibling::div/descendant::span[@class='icon-class'][position()=1]"  ;
    private String BrokerBytesOutGraphZoomInBtn = "xpath = //div[@id='apexchartschart-kafka_broker_bytes_out_per_sec']/ancestor::div[@class='card-body']/preceding-sibling::div/descendant::span[@class='icon-class'][position()=2]" ;
    private String BrokerBytesOutGraphResetBtn = "xpath = //div[@id='apexchartschart-kafka_broker_bytes_out_per_sec']/ancestor::div[@class='card-body']/preceding-sibling::div/descendant::span[@class='icon-class'][position()=3]" ;
    private String BrokerBytesOutGraphXaxisLines = "xpath = //div[@id='apexchartschart-kafka_broker_bytes_out_per_sec']/descendant::*[name()='line' and @class='apexcharts-xaxis-tick']";
    private String BrokerBytesOutGraphXaxisValues = "xpath = //div[@id='apexchartschart-kafka_broker_bytes_out_per_sec']/descendant::*[@class='apexcharts-text apexcharts-xaxis-label apexcharts-xaxis-label']/child::*[name()='tspan' and contains(text(),'-')]";
    private String BrokerBytesOutGraphXaxisTitle = "xpath = //div[@id='apexchartschart-kafka_broker_bytes_out_per_sec']/descendant::*[@class='apexcharts-text apexcharts-xaxis-title-text chart-lables']";
    private String BrokerBytesOutGraphYaxisTitle = "xpath = //div[@id='apexchartschart-kafka_broker_bytes_out_per_sec']/descendant::*[@class='apexcharts-text apexcharts-yaxis-title-text chart-lables']";
    private String BrokerBytesOutGraphToolTipTitle = "xpath = //div[@id='apexchartsvuechart-line-1']/ancestor::div[@class='chart-box']/descendant::div[@class='apexcharts-tooltip-title']";
    private String BrokerBytesOutGraphTooltipValue = "xpath = //div[@id='apexchartsvuechart-line-1']/ancestor::div[@class='chart-box']/descendant::div[@class='apexcharts-tooltip-text']";
    
    	//Bytes Out - Conclusion - Heading
    private String BrokerBytesOutGraphBrokerHeader = "xpath = //div[@id='apexchartschart-kafka_broker_bytes_out_per_sec']/ancestor::div[@class='card-body']/descendant::div[@class='header-heading'][position()=1]";
    private String BrokerBytesOutGraphBrokerHeaderArrow = "xpath = //div[@id='apexchartschart-kafka_broker_bytes_out_per_sec']/ancestor::div[@class='card-body']/descendant::div[@class='header-heading'][position()=1]/descendant::span[@class='base-icon sort-asc']";
    private String BrokerBytesOutGraphAvgHeader = "xpath = //div[@id='apexchartschart-kafka_broker_bytes_out_per_sec']/ancestor::div[@class='card-body']/descendant::div[@class='header-heading'][position()=2]";
    private String BrokerBytesOutGraphAvgHeaderArrow = "xpath = //div[@id='apexchartschart-kafka_broker_bytes_out_per_sec']/ancestor::div[@class='card-body']/descendant::div[@class='header-heading'][position()=2]/descendant::span[@class='base-icon sort-asc']";
    private String BrokerBytesOutGraphMaxHeader = "xpath = //div[@id='apexchartschart-kafka_broker_bytes_out_per_sec']/ancestor::div[@class='card-body']/descendant::div[@class='header-heading'][position()=3]";
    private String BrokerBytesOutGraphMaxHeaderArrow = "xpath = //div[@id='apexchartschart-kafka_broker_bytes_out_per_sec']/ancestor::div[@class='card-body']/descendant::div[@class='header-heading'][position()=3]/descendant::span[@class='base-icon sort-asc']";
    
        	//Bytes Out - Conclusion - Reading
    private String BrokerBytesOutGraphBrokerRowColor1 = "xpath = //div[@id='apexchartschart-kafka_broker_bytes_out_per_sec']/ancestor::div[@class='graph']/descendant::div[@class='table-body']/descendant::span[@class='dot'][position()=1]";
    private String BrokerBytesOutGraphBrokerRowColor2 = "xpath = //div[@id='apexchartschart-kafka_broker_bytes_out_per_sec']/ancestor::div[@class='graph']/descendant::div[@class='table-body']/descendant::span[@class='dot'][position()=2]";
    private String BrokerBytesOutGraphBrokerRowColor3 = "xpath = //div[@id='apexchartschart-kafka_broker_bytes_out_per_sec']/ancestor::div[@class='graph']/descendant::div[@class='table-body']/descendant::span[@class='dot'][position()=3]";
    private String BrokerBytesOutGraphBrokerRowColor4 = "xpath = //div[@id='apexchartschart-kafka_broker_bytes_out_per_sec']/ancestor::div[@class='graph']/descendant::div[@class='table-body']/descendant::span[@class='dot'][position()=4]";
    private String BrokerBytesOutGraphBrokerRowColor5 = "xpath = //div[@id='apexchartschart-kafka_broker_bytes_out_per_sec']/ancestor::div[@class='graph']/descendant::div[@class='table-body']/descendant::span[@class='dot'][position()=5]";
    private String BrokerBytesOutGraphBrokerRowColor6 = "xpath = //div[@id='apexchartschart-kafka_broker_bytes_out_per_sec']/ancestor::div[@class='graph']/descendant::div[@class='table-body']/descendant::span[@class='dot'][position()=6]";
    
    
    //Broker - Total Produced Request Rate
    private String BrokerTotalProducedReqRateGraphWidgetTitle = "xpath = //div[@class='graphs-container']/descendant::div[@class='card-header'][position()=3]";
    private String BrokerTotalProducedReqRateGraphZoomOutBtn = "xpath = //div[@id='apexchartschart-kafka_broker_total_produce_requests_per_sec']/ancestor::div[@class='card-body']/preceding-sibling::div/descendant::span[@class='icon-class'][position()=1]"  ;
    private String BrokerTotalProducedReqRateGraphZoomInBtn = "xpath = //div[@id='apexchartschart-kafka_broker_total_produce_requests_per_sec']/ancestor::div[@class='card-body']/preceding-sibling::div/descendant::span[@class='icon-class'][position()=2]" ;
    private String BrokerTotalProducedReqRateGraphResetBtn = "xpath = //div[@id='apexchartschart-kafka_broker_total_produce_requests_per_sec']/ancestor::div[@class='card-body']/preceding-sibling::div/descendant::span[@class='icon-class'][position()=3]" ;
    private String BrokerTotalProducedReqRateGraphXaxisLines = "xpath = //div[@id='apexchartschart-kafka_broker_total_produce_requests_per_sec']/descendant::*[name()='line' and @class='apexcharts-xaxis-tick']";
    private String BrokerTotalProducedReqRateGraphXaxisValues = "xpath = //div[@id='apexchartschart-kafka_broker_total_produce_requests_per_sec']/descendant::*[@class='apexcharts-text apexcharts-xaxis-label apexcharts-xaxis-label']/child::*[name()='tspan' and contains(text(),'-')]";
    private String BrokerTotalProducedReqRateGraphXaxisTitle = "xpath = //div[@id='apexchartschart-kafka_broker_total_produce_requests_per_sec']/descendant::*[@class='apexcharts-text apexcharts-xaxis-title-text chart-lables']";
    private String BrokerTotalProducedReqRateGraphYaxisTitle = "xpath = //div[@id='apexchartschart-kafka_broker_total_produce_requests_per_sec']/descendant::*[@class='apexcharts-text apexcharts-yaxis-title-text chart-lables']";
    private String BrokerTotalProducedReqRateGraphToolTipTitle = "xpath = //div[@id='apexchartsvuechart-line-1']/ancestor::div[@class='chart-box']/descendant::div[@class='apexcharts-tooltip-title']";
    private String BrokerTotalProducedReqRateGraphTooltipValue = "xpath = //div[@id='apexchartsvuechart-line-1']/ancestor::div[@class='chart-box']/descendant::div[@class='apexcharts-tooltip-text']";
    
		//Total Produced Request Rate - Conclusion - Heading
    private String BrokerTotalProducedReqRateGraphBrokerHeader = "xpath = //div[@id='apexchartschart-kafka_broker_total_produce_requests_per_sec']/ancestor::div[@class='card-body']/descendant::div[@class='header-heading'][position()=1]";
    private String BrokerTotalProducedReqRateGraphBrokerHeaderArrow = "xpath = //div[@id='apexchartschart-kafka_broker_total_produce_requests_per_sec']/ancestor::div[@class='card-body']/descendant::div[@class='header-heading'][position()=1]/descendant::span[@class='base-icon sort-asc']";
    private String BrokerTotalProducedReqRateGraphAvgHeader = "xpath = //div[@id='apexchartschart-kafka_broker_total_produce_requests_per_sec']/ancestor::div[@class='card-body']/descendant::div[@class='header-heading'][position()=2]";
    private String BrokerTotalProducedReqRateGraphAvgHeaderArrow = "xpath = //div[@id='apexchartschart-kafka_broker_total_produce_requests_per_sec']/ancestor::div[@class='card-body']/descendant::div[@class='header-heading'][position()=2]/descendant::span[@class='base-icon sort-asc']";
    private String BrokerTotalProducedReqRateGraphMaxHeader = "xpath = //div[@id='apexchartschart-kafka_broker_total_produce_requests_per_sec']/ancestor::div[@class='card-body']/descendant::div[@class='header-heading'][position()=3]";
    private String BrokerTotalProducedReqRateGraphMaxHeaderArrow = "xpath = //div[@id='apexchartschart-kafka_broker_total_produce_requests_per_sec']/ancestor::div[@class='card-body']/descendant::div[@class='header-heading'][position()=3]/descendant::span[@class='base-icon sort-asc']";
    
        	//Total Produced Request Rate - Conclusion - Reading
    private String BrokerTotalProducedReqRateGraphBrokerRowColor1 = "xpath = //div[@id='apexchartschart-kafka_broker_total_produce_requests_per_sec']/ancestor::div[@class='graph']/descendant::div[@class='table-body']/descendant::span[@class='dot'][position()=1]";
    private String BrokerTotalProducedReqRateGraphBrokerRowColor2 = "xpath = //div[@id='apexchartschart-kafka_broker_total_produce_requests_per_sec']/ancestor::div[@class='graph']/descendant::div[@class='table-body']/descendant::span[@class='dot'][position()=2]";
    private String BrokerTotalProducedReqRateGraphBrokerRowColor3 = "xpath = //div[@id='apexchartschart-kafka_broker_total_produce_requests_per_sec']/ancestor::div[@class='graph']/descendant::div[@class='table-body']/descendant::span[@class='dot'][position()=3]";
    private String BrokerTotalProducedReqRateGraphBrokerRowColor4 = "xpath = //div[@id='apexchartschart-kafka_broker_total_produce_requests_per_sec']/ancestor::div[@class='graph']/descendant::div[@class='table-body']/descendant::span[@class='dot'][position()=4]";
    private String BrokerTotalProducedReqRateGraphBrokerRowColor5 = "xpath = //div[@id='apexchartschart-kafka_broker_total_produce_requests_per_sec']/ancestor::div[@class='graph']/descendant::div[@class='table-body']/descendant::span[@class='dot'][position()=5]";
    private String BrokerTotalProducedReqRateGraphBrokerRowColor6 = "xpath = //div[@id='apexchartschart-kafka_broker_total_produce_requests_per_sec']/ancestor::div[@class='graph']/descendant::div[@class='table-body']/descendant::span[@class='dot'][position()=6]";
    
    //Broker - Total Fetch Request Rate
    private String BrokerTotalFetchReqRateGraphWidgetTitle = "xpath = //div[@class='graphs-container']/descendant::div[@class='card-header'][position()=4]";
    private String BrokerTotalFetchReqRateGraphZoomOutBtn = "xpath = //div[@id='apexchartschart-kafka_broker_total_fetch_requests_per_sec']/ancestor::div[@class='card-body']/preceding-sibling::div/descendant::span[@class='icon-class'][position()=1]"  ;
    private String BrokerTotalFetchReqRateGraphZoomInBtn = "xpath = //div[@id='apexchartschart-kafka_broker_total_fetch_requests_per_sec']/ancestor::div[@class='card-body']/preceding-sibling::div/descendant::span[@class='icon-class'][position()=2]" ;
    private String BrokerTotalFetchReqRateGraphResetBtn = "xpath = //div[@id='apexchartschart-kafka_broker_total_fetch_requests_per_sec']/ancestor::div[@class='card-body']/preceding-sibling::div/descendant::span[@class='icon-class'][position()=3]" ;
    private String BrokerTotalFetchReqRateGraphXaxisLines = "xpath = //div[@id='apexchartschart-kafka_broker_total_fetch_requests_per_sec']/descendant::*[name()='line' and @class='apexcharts-xaxis-tick']";
    private String BrokerTotalFetchReqRateGraphXaxisValues = "xpath = //div[@id='apexchartschart-kafka_broker_total_fetch_requests_per_sec']/descendant::*[@class='apexcharts-text apexcharts-xaxis-label apexcharts-xaxis-label']/child::*[name()='tspan' and contains(text(),'-')]";
    private String BrokerTotalFetchReqRateGraphXaxisTitle = "xpath = //div[@id='apexchartschart-kafka_broker_total_fetch_requests_per_sec']/descendant::*[@class='apexcharts-text apexcharts-xaxis-title-text chart-lables']";
    private String BrokerTotalFetchReqRateGraphYaxisTitle = "xpath = //div[@id='apexchartschart-kafka_broker_total_fetch_requests_per_sec']/descendant::*[@class='apexcharts-text apexcharts-yaxis-title-text chart-lables']";
    private String BrokerTotalFetchReqRateGraphToolTipTitle = "xpath = //div[@id='apexchartsvuechart-line-1']/ancestor::div[@class='chart-box']/descendant::div[@class='apexcharts-tooltip-title']";
    private String BrokerTotalFetchReqRateGraphTooltipValue = "xpath = //div[@id='apexchartsvuechart-line-1']/ancestor::div[@class='chart-box']/descendant::div[@class='apexcharts-tooltip-text']";
    
    	//Total Fetch Request Rate - Conclusion - Heading
    private String BrokerTotalFetchReqRateGraphBrokerHeader = "xpath = //div[@id='apexchartschart-kafka_broker_total_fetch_requests_per_sec']/ancestor::div[@class='card-body']/descendant::div[@class='header-heading'][position()=1]";
    private String BrokerTotalFetchReqRateGraphBrokerHeaderArrow = "xpath = //div[@id='apexchartschart-kafka_broker_total_fetch_requests_per_sec']/ancestor::div[@class='card-body']/descendant::div[@class='header-heading'][position()=1]/descendant::span[@class='base-icon sort-asc']";
    private String BrokerTotalFetchReqRateGraphAvgHeader = "xpath = //div[@id='apexchartschart-kafka_broker_total_fetch_requests_per_sec']/ancestor::div[@class='card-body']/descendant::div[@class='header-heading'][position()=2]";
    private String BrokerTotalFetchReqRateGraphAvgHeaderArrow = "xpath = //div[@id='apexchartschart-kafka_broker_total_fetch_requests_per_sec']/ancestor::div[@class='card-body']/descendant::div[@class='header-heading'][position()=2]/descendant::span[@class='base-icon sort-asc']";
    private String BrokerTotalFetchReqRateGraphMaxHeader = "xpath = //div[@id='apexchartschart-kafka_broker_total_fetch_requests_per_sec']/ancestor::div[@class='card-body']/descendant::div[@class='header-heading'][position()=3]";
    private String BrokerTotalFetchReqRateGraphMaxHeaderArrow = "xpath = //div[@id='apexchartschart-kafka_broker_total_fetch_requests_per_sec']/ancestor::div[@class='card-body']/descendant::div[@class='header-heading'][position()=3]/descendant::span[@class='base-icon sort-asc']";
    
        	//Total Fetch Request Rate - Conclusion - Reading
    private String BrokerTotalFetchReqRateGraphBrokerRowColor1 = "xpath = //div[@id='apexchartschart-kafka_broker_total_fetch_requests_per_sec']/ancestor::div[@class='graph']/descendant::div[@class='table-body']/descendant::span[@class='dot'][position()=1]";
    private String BrokerTotalFetchReqRateGraphBrokerRowColor2 = "xpath = //div[@id='apexchartschart-kafka_broker_total_fetch_requests_per_sec']/ancestor::div[@class='graph']/descendant::div[@class='table-body']/descendant::span[@class='dot'][position()=2]";
    private String BrokerTotalFetchReqRateGraphBrokerRowColor3 = "xpath = //div[@id='apexchartschart-kafka_broker_total_fetch_requests_per_sec']/ancestor::div[@class='graph']/descendant::div[@class='table-body']/descendant::span[@class='dot'][position()=3]";
    private String BrokerTotalFetchReqRateGraphBrokerRowColor4 = "xpath = //div[@id='apexchartschart-kafka_broker_total_fetch_requests_per_sec']/ancestor::div[@class='graph']/descendant::div[@class='table-body']/descendant::span[@class='dot'][position()=4]";
    private String BrokerTotalFetchReqRateGraphBrokerRowColor5 = "xpath = //div[@id='apexchartschart-kafka_broker_total_fetch_requests_per_sec']/ancestor::div[@class='graph']/descendant::div[@class='table-body']/descendant::span[@class='dot'][position()=5]";
    private String BrokerTotalFetchReqRateGraphBrokerRowColor6 = "xpath = //div[@id='apexchartschart-kafka_broker_total_fetch_requests_per_sec']/ancestor::div[@class='graph']/descendant::div[@class='table-body']/descendant::span[@class='dot'][position()=6]";
    
	//Broker - MessagesIn
    private String BrokerMessagesInWidgetTitle = "xpath = //div[@class='graphs-container']/descendant::div[@class='card-header'][position()=5]";
    private String BrokerMessagesInZoomOutBtn = "xpath = //div[@id='apexchartschart-kafka_broker_messages_in_per_sec']/ancestor::div[@class='card-body']/preceding-sibling::div/descendant::span[@class='icon-class'][position()=1]"  ;
    private String BrokerMessagesInZoomInBtn = "xpath = //div[@id='apexchartschart-kafka_broker_messages_in_per_sec']/ancestor::div[@class='card-body']/preceding-sibling::div/descendant::span[@class='icon-class'][position()=2]" ;
    private String BrokerMessagesInResetBtn = "xpath = //div[@id='apexchartschart-kafka_broker_messages_in_per_sec']/ancestor::div[@class='card-body']/preceding-sibling::div/descendant::span[@class='icon-class'][position()=3]" ;
    private String BrokerMessagesInXaxisLines = "xpath = //div[@id='apexchartschart-kafka_broker_messages_in_per_sec']/descendant::*[name()='line' and @class='apexcharts-xaxis-tick']";
    private String BrokerMessagesInXaxisValues = "xpath = //div[@id='apexchartschart-kafka_broker_messages_in_per_sec']/descendant::*[@class='apexcharts-text apexcharts-xaxis-label apexcharts-xaxis-label']/child::*[name()='tspan' and contains(text(),'-')]";
    private String BrokerMessagesInXaxisTitle = "xpath = //div[@id='apexchartschart-kafka_broker_messages_in_per_sec']/descendant::*[@class='apexcharts-text apexcharts-xaxis-title-text chart-lables']";
    private String BrokerMessagesInYaxisTitle = "xpath = //div[@id='apexchartschart-kafka_broker_messages_in_per_sec']/descendant::*[@class='apexcharts-text apexcharts-yaxis-title-text chart-lables']";
    private String BrokerMessagesInToolTipTitle = "xpath = //div[@id='apexchartsvuechart-line-1']/ancestor::div[@class='chart-box']/descendant::div[@class='apexcharts-tooltip-title']";
    private String BrokerMessagesInTooltipValue = "xpath = //div[@id='apexchartsvuechart-line-1']/ancestor::div[@class='chart-box']/descendant::div[@class='apexcharts-tooltip-text']";
    
    	//MessagesIn - Conclusion - Heading
    private String BrokerMessagesInGraphBrokerHeader = "xpath = //div[@id='apexchartschart-kafka_broker_messages_in_per_sec']/ancestor::div[@class='card-body']/descendant::div[@class='header-heading'][position()=1]";
    private String BrokerMessagesInGraphBrokerHeaderArrow = "xpath = //div[@id='apexchartschart-kafka_broker_messages_in_per_sec']/ancestor::div[@class='card-body']/descendant::div[@class='header-heading'][position()=1]/descendant::span[@class='base-icon sort-asc']";
    private String BrokerMessagesInGraphAvgHeader = "xpath = //div[@id='apexchartschart-kafka_broker_messages_in_per_sec']/ancestor::div[@class='card-body']/descendant::div[@class='header-heading'][position()=2]";
    private String BrokerMessagesInGraphAvgHeaderArrow = "xpath = //div[@id='apexchartschart-kafka_broker_messages_in_per_sec']/ancestor::div[@class='card-body']/descendant::div[@class='header-heading'][position()=2]/descendant::span[@class='base-icon sort-asc']";
    private String BrokerMessagesInGraphMaxHeader = "xpath = //div[@id='apexchartschart-kafka_broker_messages_in_per_sec']/ancestor::div[@class='card-body']/descendant::div[@class='header-heading'][position()=3]";
    private String BrokerMessagesInGraphMaxHeaderArrow = "xpath = //div[@id='apexchartschart-kafka_broker_messages_in_per_sec']/ancestor::div[@class='card-body']/descendant::div[@class='header-heading'][position()=3]/descendant::span[@class='base-icon sort-asc']";
    
        	//MessagesIn - Conclusion - Reading
    private String BrokerMessagesInGraphBrokerRowColor1 = "xpath = //div[@id='apexchartschart-kafka_broker_messages_in_per_sec']/ancestor::div[@class='graph']/descendant::div[@class='table-body']/descendant::span[@class='dot'][position()=1]";
    private String BrokerMessagesInGraphBrokerRowColor2 = "xpath = //div[@id='apexchartschart-kafka_broker_messages_in_per_sec']/ancestor::div[@class='graph']/descendant::div[@class='table-body']/descendant::span[@class='dot'][position()=2]";
    private String BrokerMessagesInGraphBrokerRowColor3 = "xpath = //div[@id='apexchartschart-kafka_broker_messages_in_per_sec']/ancestor::div[@class='graph']/descendant::div[@class='table-body']/descendant::span[@class='dot'][position()=3]";
    private String BrokerMessagesInGraphBrokerRowColor4 = "xpath = //div[@id='apexchartschart-kafka_broker_messages_in_per_sec']/ancestor::div[@class='graph']/descendant::div[@class='table-body']/descendant::span[@class='dot'][position()=4]";
    private String BrokerMessagesInGraphBrokerRowColor5 = "xpath = //div[@id='apexchartschart-kafka_broker_messages_in_per_sec']/ancestor::div[@class='graph']/descendant::div[@class='table-body']/descendant::span[@class='dot'][position()=5]";
    private String BrokerMessagesInGraphBrokerRowColor6 = "xpath = //div[@id='apexchartschart-kafka_broker_messages_in_per_sec']/ancestor::div[@class='graph']/descendant::div[@class='table-body']/descendant::span[@class='dot'][position()=6]";
    
    //Broker - Leader Election Rate 
    private String BrokerLeaderElectionRateWidgetTitle = "xpath = //div[@class='graphs-container']/descendant::div[@class='card-header'][position()=6]";
    private String BrokerLeaderElectionRateZoomOutBtn = "xpath = //div[@id='apexchartschart-kafka_broker_leader_election_rate_and_timems']/ancestor::div[@class='card-body']/preceding-sibling::div/descendant::span[@class='icon-class'][position()=1]"  ;
    private String BrokerLeaderElectionRateZoomInBtn = "xpath = //div[@id='apexchartschart-kafka_broker_leader_election_rate_and_timems']/ancestor::div[@class='card-body']/preceding-sibling::div/descendant::span[@class='icon-class'][position()=2]" ;
    private String BrokerLeaderElectionRateResetBtn = "xpath = //div[@id='apexchartschart-kafka_broker_leader_election_rate_and_timems']/ancestor::div[@class='card-body']/preceding-sibling::div/descendant::span[@class='icon-class'][position()=3]" ;
    private String BrokerLeaderElectionRateXaxisLines = "xpath = //div[@id='apexchartschart-kafka_broker_leader_election_rate_and_timems']/descendant::*[name()='line' and @class='apexcharts-xaxis-tick']";
    private String BrokerLeaderElectionRateXaxisValues = "xpath = //div[@id='apexchartschart-kafka_broker_leader_election_rate_and_timems']/descendant::*[@class='apexcharts-text apexcharts-xaxis-label apexcharts-xaxis-label']/child::*[name()='tspan' and contains(text(),'-')]";
    private String BrokerLeaderElectionRateXaxisTitle = "xpath = //div[@id='apexchartschart-kafka_broker_leader_election_rate_and_timems']/descendant::*[@class='apexcharts-text apexcharts-xaxis-title-text chart-lables']";
    private String BrokerLeaderElectionRateYaxisTitle = "xpath = //div[@id='apexchartschart-kafka_broker_leader_election_rate_and_timems']/descendant::*[@class='apexcharts-text apexcharts-yaxis-title-text chart-lables']";
    private String BrokerLeaderElectionRateToolTipTitle = "xpath = //div[@id='apexchartsvuechart-line-1']/ancestor::div[@class='chart-box']/descendant::div[@class='apexcharts-tooltip-title']";
    private String BrokerLeaderElectionRateTooltipValue = "xpath = //div[@id='apexchartsvuechart-line-1']/ancestor::div[@class='chart-box']/descendant::div[@class='apexcharts-tooltip-text']";
    
 		//Leader Election Rate - Conclusion - Heading
    private String BrokerLeaderElectionRateGraphBrokerHeader = "xpath = //div[@id='apexchartschart-kafka_broker_leader_election_rate_and_timems']/ancestor::div[@class='card-body']/descendant::div[@class='header-heading'][position()=1]";
    private String BrokerLeaderElectionRateGraphBrokerHeaderArrow = "xpath = //div[@id='apexchartschart-kafka_broker_leader_election_rate_and_timems']/ancestor::div[@class='card-body']/descendant::div[@class='header-heading'][position()=1]/descendant::span[@class='base-icon sort-asc']";
    private String BrokerLeaderElectionRateGraphAvgHeader = "xpath = //div[@id='apexchartschart-kafka_broker_leader_election_rate_and_timems']/ancestor::div[@class='card-body']/descendant::div[@class='header-heading'][position()=2]";
    private String BrokerLeaderElectionRateGraphAvgHeaderArrow = "xpath = //div[@id='apexchartschart-kafka_broker_leader_election_rate_and_timems']/ancestor::div[@class='card-body']/descendant::div[@class='header-heading'][position()=2]/descendant::span[@class='base-icon sort-asc']";
    private String BrokerLeaderElectionRateGraphMaxHeader = "xpath = //div[@id='apexchartschart-kafka_broker_leader_election_rate_and_timems']/ancestor::div[@class='card-body']/descendant::div[@class='header-heading'][position()=3]";
    private String BrokerLeaderElectionRateGraphMaxHeaderArrow = "xpath = //div[@id='apexchartschart-kafka_broker_leader_election_rate_and_timems']/ancestor::div[@class='card-body']/descendant::div[@class='header-heading'][position()=3]/descendant::span[@class='base-icon sort-asc']";
    
        	//Leader Election Rate - Conclusion - Reading
    private String BrokerLeaderElectionRateGraphBrokerRowColor1 = "xpath = //div[@id='apexchartschart-kafka_broker_leader_election_rate_and_timems']/ancestor::div[@class='graph']/descendant::div[@class='table-body']/descendant::span[@class='dot'][position()=1]";
    private String BrokerLeaderElectionRateGraphBrokerRowColor2 = "xpath = //div[@id='apexchartschart-kafka_broker_leader_election_rate_and_timems']/ancestor::div[@class='graph']/descendant::div[@class='table-body']/descendant::span[@class='dot'][position()=2]";
    private String BrokerLeaderElectionRateGraphBrokerRowColor3 = "xpath = //div[@id='apexchartschart-kafka_broker_leader_election_rate_and_timems']/ancestor::div[@class='graph']/descendant::div[@class='table-body']/descendant::span[@class='dot'][position()=3]";
    private String BrokerLeaderElectionRateGraphBrokerRowColor4 = "xpath = //div[@id='apexchartschart-kafka_broker_leader_election_rate_and_timems']/ancestor::div[@class='graph']/descendant::div[@class='table-body']/descendant::span[@class='dot'][position()=4]";
    private String BrokerLeaderElectionRateGraphBrokerRowColor5 = "xpath = //div[@id='apexchartschart-kafka_broker_leader_election_rate_and_timems']/ancestor::div[@class='graph']/descendant::div[@class='table-body']/descendant::span[@class='dot'][position()=5]";
    private String BrokerLeaderElectionRateGraphBrokerRowColor6 = "xpath = //div[@id='apexchartschart-kafka_broker_leader_election_rate_and_timems']/ancestor::div[@class='graph']/descendant::div[@class='table-body']/descendant::span[@class='dot'][position()=6]";
    
    //Broker - Uncleaned Election Leader
    private String BrokerUncleanedElectionLeaderPerSecWidgetTitle = "xpath = //div[@class='graphs-container']/descendant::div[@class='card-header'][position()=7]";
    private String BrokerUncleanedElectionLeaderPerSecZoomOutBtn = "xpath = //div[@id='apexchartschart-kafka_broker_unclean_leader_elections_per_sec']/ancestor::div[@class='card-body']/preceding-sibling::div/descendant::span[@class='icon-class'][position()=1]"  ;
    private String BrokerUncleanedElectionLeaderPerSecZoomInBtn = "xpath = //div[@id='apexchartschart-kafka_broker_unclean_leader_elections_per_sec']/ancestor::div[@class='card-body']/preceding-sibling::div/descendant::span[@class='icon-class'][position()=2]" ;
    private String BrokerUncleanedElectionLeaderPerSecResetBtn = "xpath = //div[@id='apexchartschart-kafka_broker_unclean_leader_elections_per_sec']/ancestor::div[@class='card-body']/preceding-sibling::div/descendant::span[@class='icon-class'][position()=3]" ;
    private String BrokerUncleanedElectionLeaderPerSecXaxisLines = "xpath = //div[@id='apexchartschart-kafka_broker_unclean_leader_elections_per_sec']/descendant::*[name()='line' and @class='apexcharts-xaxis-tick']";
    private String BrokerUncleanedElectionLeaderPerSecXaxisValues = "xpath = //div[@id='apexchartschart-kafka_broker_unclean_leader_elections_per_sec']/descendant::*[@class='apexcharts-text apexcharts-xaxis-label apexcharts-xaxis-label']/child::*[name()='tspan' and contains(text(),'-')]";
    private String BrokerUncleanedElectionLeaderPerSecXaxisTitle = "xpath = //div[@id='apexchartschart-kafka_broker_unclean_leader_elections_per_sec']/descendant::*[@class='apexcharts-text apexcharts-xaxis-title-text chart-lables']";
    private String BrokerUncleanedElectionLeaderPerSecYaxisTitle = "xpath = //div[@id='apexchartschart-kafka_broker_unclean_leader_elections_per_sec']/descendant::*[@class='apexcharts-text apexcharts-yaxis-title-text chart-lables']";
    private String BrokerUncleanedElectionLeaderPerSecToolTipTitle = "xpath = //div[@id='apexchartsvuechart-line-1']/ancestor::div[@class='chart-box']/descendant::div[@class='apexcharts-tooltip-title']";
    private String BrokerUncleanedElectionLeaderPerSecTooltipValue = "xpath = //div[@id='apexchartsvuechart-line-1']/ancestor::div[@class='chart-box']/descendant::div[@class='apexcharts-tooltip-text']";
    
    	//Uncleaned Election Leader - Conclusion - Heading
    private String BrokerUncleanedElectionLeaderBrokerHeader = "xpath = //div[@id='apexchartschart-kafka_broker_unclean_leader_elections_per_sec']/ancestor::div[@class='card-body']/descendant::div[@class='header-heading'][position()=1]";
    private String BrokerUncleanedElectionLeaderBrokerHeaderArrow = "xpath = //div[@id='apexchartschart-kafka_broker_unclean_leader_elections_per_sec']/ancestor::div[@class='card-body']/descendant::div[@class='header-heading'][position()=1]/descendant::span[@class='base-icon sort-asc']";
    private String BrokerUncleanedElectionLeaderAvgHeader = "xpath = //div[@id='apexchartschart-kafka_broker_unclean_leader_elections_per_sec']/ancestor::div[@class='card-body']/descendant::div[@class='header-heading'][position()=2]";
    private String BrokerUncleanedElectionLeaderAvgHeaderArrow = "xpath = //div[@id='apexchartschart-kafka_broker_unclean_leader_elections_per_sec']/ancestor::div[@class='card-body']/descendant::div[@class='header-heading'][position()=2]/descendant::span[@class='base-icon sort-asc']";
    private String BrokerUncleanedElectionLeaderMaxHeader = "xpath = //div[@id='apexchartschart-kafka_broker_unclean_leader_elections_per_sec']/ancestor::div[@class='card-body']/descendant::div[@class='header-heading'][position()=3]";
    private String BrokerUncleanedElectionLeaderMaxHeaderArrow = "xpath = //div[@id='apexchartschart-kafka_broker_unclean_leader_elections_per_sec']/ancestor::div[@class='card-body']/descendant::div[@class='header-heading'][position()=3]/descendant::span[@class='base-icon sort-asc']";
    
        	//Uncleaned Election Leader - Conclusion - Reading
    private String BrokerUncleanedElectionLeaderBrokerRowColor1 = "xpath = //div[@id='apexchartschart-kafka_broker_unclean_leader_elections_per_sec']/ancestor::div[@class='graph']/descendant::div[@class='table-body']/descendant::span[@class='dot'][position()=1]";
    private String BrokerUncleanedElectionLeaderBrokerRowColor2 = "xpath = //div[@id='apexchartschart-kafka_broker_unclean_leader_elections_per_sec']/ancestor::div[@class='graph']/descendant::div[@class='table-body']/descendant::span[@class='dot'][position()=2]";
    private String BrokerUncleanedElectionLeaderBrokerRowColor3 = "xpath = //div[@id='apexchartschart-kafka_broker_unclean_leader_elections_per_sec']/ancestor::div[@class='graph']/descendant::div[@class='table-body']/descendant::span[@class='dot'][position()=3]";
    private String BrokerUncleanedElectionLeaderBrokerRowColor4 = "xpath = //div[@id='apexchartschart-kafka_broker_unclean_leader_elections_per_sec']/ancestor::div[@class='graph']/descendant::div[@class='table-body']/descendant::span[@class='dot'][position()=4]";
    private String BrokerUncleanedElectionLeaderBrokerRowColor5 = "xpath = //div[@id='apexchartschart-kafka_broker_unclean_leader_elections_per_sec']/ancestor::div[@class='graph']/descendant::div[@class='table-body']/descendant::span[@class='dot'][position()=5]";
    private String BrokerUncleanedElectionLeaderBrokerRowColor6 = "xpath = //div[@id='apexchartschart-kafka_broker_unclean_leader_elections_per_sec']/ancestor::div[@class='graph']/descendant::div[@class='table-body']/descendant::span[@class='dot'][position()=6]";
   
    
    //Broker - Number of Brokers
    private String BrokerNumberOfBrokersWidgetTitle = "xpath = //div[@class='graphs-container']/descendant::div[@class='card-header'][position()=8]";
    private String BrokerNumberOfBrokersZoomOutBtn = "xpath = //div[@id='apexchartsvuechart-line-0']/ancestor::div[@class='chart-body']/preceding-sibling::div/descendant::span[@class='icon-class'][position()=1]"  ;
    private String BrokerNumberOfBrokersZoomInBtn = "xpath = //div[@id='apexchartsvuechart-line-0']/ancestor::div[@class='chart-body']/preceding-sibling::div/descendant::span[@class='icon-class'][position()=2]" ;
    private String BrokerNumberOfBrokersResetBtn = "xpath = //div[@id='apexchartsvuechart-line-0']/ancestor::div[@class='chart-body']/preceding-sibling::div/descendant::span[@class='icon-class'][position()=3]" ;
    private String BrokerNumberOfBrokersXaxisLines = "xpath = //div[@id='apexchartsvuechart-line-0']/descendant::*[name()='line' and @class='apexcharts-xaxis-tick']";
    private String BrokerNumberOfBrokersXaxisValues = "xpath = //div[@id='apexchartsvuechart-line-0']/descendant::*[@class='apexcharts-text apexcharts-xaxis-label apexcharts-xaxis-label']/child::*[name()='tspan' and contains(text(),'-')]";
    private String BrokerNumberOfBrokersXaxisTitle = "xpath = //div[@id='apexchartsvuechart-line-0']/descendant::*[@class='apexcharts-text apexcharts-xaxis-title-text chart-lables']";
    private String BrokerNumberOfBrokersnYaxisTitle = "xpath = //div[@id='apexchartsvuechart-line-0']/descendant::*[@class='apexcharts-text apexcharts-yaxis-title-text chart-lables']";
    private String BrokerNumberOfBrokersToolTipTitle = "xpath = //div[@id='apexchartsvuechart-line-0']/ancestor::div[@class='chart-box']/descendant::div[@class='apexcharts-tooltip-title']";
    private String BrokerNumberOfBrokersTooltipValue = "xpath = //div[@id='apexchartsvuechart-line-0']/ancestor::div[@class='chart-box']/descendant::div[@class='apexcharts-tooltip-text']";
    
    	//Number of Brokers - Conclusion - Heading
    private String BrokerNumberOfBrokersBrokerHeader = "xpath = //div[@id='apexchartsvuechart-line-0']/ancestor::div[@class='card-body']/descendant::div[@class='header-heading'][position()=1]";
    private String BrokerNumberOfBrokersBrokerHeaderArrow = "xpath = //div[@id='apexchartsvuechart-line-0']/ancestor::div[@class='card-body']/descendant::div[@class='header-heading'][position()=1]/descendant::span[@class='base-icon sort-asc']";
    private String BrokerNumberOfBrokersAvgHeader = "xpath = //div[@id='apexchartsvuechart-line-0']/ancestor::div[@class='card-body']/descendant::div[@class='header-heading'][position()=2]";
    private String BrokerNumberOfBrokersAvgHeaderArrow = "xpath = //div[@id='apexchartsvuechart-line-0']/ancestor::div[@class='card-body']/descendant::div[@class='header-heading'][position()=2]/descendant::span[@class='base-icon sort-asc']";
    private String BrokerNumberOfBrokersMaxHeader = "xpath = //div[@id='apexchartsvuechart-line-0']/ancestor::div[@class='card-body']/descendant::div[@class='header-heading'][position()=3]";
    private String BrokerNumberOfBrokersMaxHeaderArrow = "xpath = //div[@id='apexchartsvuechart-line-0']/ancestor::div[@class='card-body']/descendant::div[@class='header-heading'][position()=3]/descendant::span[@class='base-icon sort-asc']";
    
        	//Number of Brokers - Conclusion - Reading
    private String BrokerNumberOfBrokersBrokerRowColor1 = "xpath = //div[@id='apexchartsvuechart-line-0']/ancestor::div[@class='graph']/descendant::div[@class='table-body']/descendant::span[@class='dot'][position()=1]";
    private String BrokerNumberOfBrokersBrokerRowColor2 = "xpath = //div[@id='apexchartsvuechart-line-0']/ancestor::div[@class='graph']/descendant::div[@class='table-body']/descendant::span[@class='dot'][position()=2]";
    private String BrokerNumberOfBrokersBrokerRowColor3 = "xpath = //div[@id='apexchartsvuechart-line-0']/ancestor::div[@class='graph']/descendant::div[@class='table-body']/descendant::span[@class='dot'][position()=3]";
    private String BrokerNumberOfBrokersBrokerRowColor4 = "xpath = //div[@id='apexchartsvuechart-line-0']/ancestor::div[@class='graph']/descendant::div[@class='table-body']/descendant::span[@class='dot'][position()=4]";
    private String BrokerNumberOfBrokersBrokerRowColor5 = "xpath = //div[@id='apexchartsvuechart-line-0']/ancestor::div[@class='graph']/descendant::div[@class='table-body']/descendant::span[@class='dot'][position()=5]";
    private String BrokerNumberOfBrokersBrokerRowColor6 = "xpath = //div[@id='apexchartsvuechart-line-0']/ancestor::div[@class='graph']/descendant::div[@class='table-body']/descendant::span[@class='dot'][position()=6]";
   
    String BrokerBytesInnGraph="apexchartschart-kafka_broker_bytes_in_per_sec";
    /**
     * id refers widget locator id
     * @param id
     * @return 
     */
    private static String XaxisTitle(String id) {
//    	return "xpath = //div[@id='"+id+"']/ancestor::div[@class='chart-body' or @class='card-body']/preceding-sibling::div/descendant::span[@class='icon-class'][position()=1]"  ;
		return "xpath = //div[@id='"+id+"']/descendant::*[@class='apexcharts-text apexcharts-xaxis-title-text chart-lables']";
	}
    
    private String ExpandWidget(String id) {
		return "xpath = //div[@id='"+id+"']/ancestor::div[@class='card-body']/preceding-sibling::div/descendant::span[@class='icon-class'][position()=3]";
	}
	
	public void validateXaxisTitleforBytesIn() {
		System.out.println(page.locator(XaxisTitle(BrokerBytesInnGraph)).textContent());
	}
	public void SelectMessageQueue() {
		page.waitForLoadState();
		page.locator(SelectMessageQueueDropdown).click();
		page.locator(MessageQueueSearchboxInputField).fill("Kafka");
		page.locator("#mq-select-message-queue-0-single").click();
		page.locator("#btn-refresh").click();
	}
	public void selectServiceName() {
		new GenericMethods().selectTheOptionFromDropDown(page, SelectServiceNameDropdown, "KafkaV410");
	}
	
	
	
	public void BytesInExpandView() {
		page.locator(ExpandWidget(BrokerBytesInnGraph)).click();
	}
	
	//Producer
	
	//Producer - Request Rate
	private String ProducerRequestRateGraphWidgetTitle = "xpath = //div[@class='graphs-container']/descendant::div[@class='card-header'][position()=1]";
	private String ProducerRequestRateGraphZoomOutBtn = "xpath = //div[@id='apexchartschart-kafka_producer_request_rate']/ancestor::div[@class='card-body']/preceding-sibling::div/descendant::span[@class='icon-class'][position()=1]"  ;
    private String ProducerRequestRateGraphZoomInBtn = "xpath = //div[@id='apexchartschart-kafka_producer_request_rate']/ancestor::div[@class='card-body']/preceding-sibling::div/descendant::span[@class='icon-class'][position()=2]" ;	    private String ProducerRequestRateGraphResetBtn = "xpath = //div[@id='apexchartschart-kafka_producer_request_rate']/ancestor::div[@class='card-body']/preceding-sibling::div/descendant::span[@class='icon-class'][position()=3]" ;
    private String ProducerRequestRateGraphXaxisLines = "xpath = //div[@id='apexchartschart-kafka_producer_request_rate']/descendant::*[name()='line' and @class='apexcharts-xaxis-tick']";
    private String ProducerRequestRateGraphXaxisValues = "xpath = //div[@id='apexchartschart-kafka_producer_request_rate']/descendant::*[@class='apexcharts-text apexcharts-xaxis-label apexcharts-xaxis-label']/child::*[name()='tspan' and contains(text(),'-')]";
    private String ProducerRequestRateGraphXaxisTitle = "xpath = //div[@id='apexchartschart-kafka_producer_request_rate']/descendant::*[@class='apexcharts-text apexcharts-xaxis-title-text chart-lables']";
    private String ProducerRequestRateGraphYaxisTitle = "xpath = //div[@id='apexchartschart-kafka_producer_request_rate']/descendant::*[@class='apexcharts-text apexcharts-yaxis-title-text chart-lables']";
    private String ProducerRequestRateGraphToolTipTitle = "xpath = //div[@id='apexchartsvuechart-line-0']/ancestor::div[@class='chart-box']/descendant::div[@class='apexcharts-tooltip-title']";
    private String ProducerRequestRateGraphTooltipValue = "xpath = //div[@id='apexchartsvuechart-line-0']/ancestor::div[@class='chart-box']/descendant::div[@class='apexcharts-tooltip-text']";
	    
	    	//Request Rate - Conclusion - Heading
    private String ProducerRequestRateGraphProducerHeader = "xpath = //div[@id='apexchartschart-kafka_producer_request_rate']/ancestor::div[@class='card-body']/descendant::div[@class='header-heading'][position()=1]";
    private String ProducerRequestRateGraphProducerHeaderArrow = "xpath = //div[@id='apexchartschart-kafka_producer_request_rate']/ancestor::div[@class='card-body']/descendant::div[@class='header-heading'][position()=1]/descendant::span[@class='base-icon sort-asc']";
	    private String ProducerRequestRateGraphAvgHeader = "xpath = //div[@id='apexchartschart-kafka_producer_request_rate]/ancestor::div[@class='card-body']/descendant::div[@class='header-heading'][position()=2]";
	    private String ProducerRequestRateGraphAvgHeaderArrow = "xpath = //div[@id='apexchartschart-kafka_producer_request_rate']/ancestor::div[@class='card-body']/descendant::div[@class='header-heading'][position()=2]/descendant::span[@class='base-icon sort-asc']";
	    private String ProducerRequestRateGraphMaxHeader = "xpath = //div[@id='apexchartschart-kafka_producer_request_rate']/ancestor::div[@class='card-body']/descendant::div[@class='header-heading'][position()=3]";
	    private String ProducerRequestRateGraphMaxHeaderArrow = "xpath = //div[@id='apexchartschart-kafka_producer_request_rate']/ancestor::div[@class='card-body']/descendant::div[@class='header-heading'][position()=3]/descendant::span[@class='base-icon sort-asc']";
	    
	    		//Request Rate - Conclusion - Reading
	    private String ProducerRequestRateGraphProducerRowColor1 = "xpath = //div[@id='apexchartschart-kafka_producer_request_rate']/ancestor::div[@class='graph']/descendant::div[@class='table-body']/descendant::span[@class='dot'][position()=1]";
	    private String ProducerRequestRateGraphProducerRowColor2 = "xpath = //div[@id='apexchartschart-kafka_producer_request_rate']/ancestor::div[@class='graph']/descendant::div[@class='table-body']/descendant::span[@class='dot'][position()=2]";
	    private String ProducerRequestRateGraphProducerRowColor3 = "xpath = //div[@id='apexchartschart-kafka_producer_request_rate']/ancestor::div[@class='graph']/descendant::div[@class='table-body']/descendant::span[@class='dot'][position()=3]";
	    private String ProducerRequestRateGraphProducerRowColor4 = "xpath = //div[@id='apexchartschart-kafka_producer_request_rate']/ancestor::div[@class='graph']/descendant::div[@class='table-body']/descendant::span[@class='dot'][position()=4]";
	    private String ProducerRequestRateGraphProducerRowColor5 = "xpath = //div[@id='apexchartschart-kafka_producer_request_rate']/ancestor::div[@class='graph']/descendant::div[@class='table-body']/descendant::span[@class='dot'][position()=5]";
	    private String ProducerRequestRateGraphProducerRowColor6 = "xpath = //div[@id='apexchartschart-kafka_producer_request_rate']/ancestor::div[@class='graph']/descendant::div[@class='table-body']/descendant::span[@class='dot'][position()=6]";
	    
	
	
	
}
