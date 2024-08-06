package genericUtilities;

public interface IPathConstant {
	
	String MMexcelPath = "./src/test/resources/testData/mmTestData.xlsx";
	String alertsExcelPath = "./src/test/resources/testData/alertsTestData.xlsx";
	String apmExcelPath = "./src/test/resources/testData/aPMTestData.xlsx";
	String commExcelPath = "./src/test/resources/testData/commonTestData.xlsx";
	String DBMExcelPath = "./src/test/resources/testData/dbmTestData.xlsx";
	String settingsExcelPath = "./src/test/resources/testData/settingsTestData.xlsx";
	String bmExcelPath = "./src/test/resources/testData/bmTestData.xlsx";
	String notificationChannelsExcelPath = "./src/test/resources/testData/notificationChannelTestData.xlsx";
	String notificationChannelsSheet = "NotificationChannels";
	String alertsTagGroupingPath = "";
	String MQMExcelPath = "./src/test/resources/testData/MQMonitoringTestData.xlsx";
	String TypesOfDBs = "DBTypes";
	String refreshOptionsSheet = "RefreshOptions";
	String tracePageSheet = "TracePage";
	String topologyPageSheet = "TopologyPage";
	String apmEndpointSheet = "EndPointPage";
	String apmDatabaseSheet = "DataBasePage";
	String commonPaginationSheet = "Pagination";
	String apmDataValidationSheet = "DataValidation";
	String bmApplicationSheet = "bmApplicationPage";
	String bmPagesSheet = "bmPagesPage";
	String bmErrorsSheet = "bmErrorsPage";
	String bmDataValidationSheet = "bmDataValidation";
	String bmAngularLoadSheet = "AngularLoad";
	String mmCrashesSheet = "MMCrashes";
	String mmUsageSheet = "MMUsage";
	String mmLoadSheet = "Load";
	String mmDashBoardSheet = "MMDashboard";
	String calenderSheet = "Calender";
	String apdexLabelSheet = "Apdex labels";
	String alertsPythonGatePhpSheet = "Alerts_Python_gateway_php";
	String alertsJavaNodeDotNetInsEndSheet = "Alerts_Java_Node_dotNet_InsEnd";
	String alertsEndpointsheet = "Alerts_EndPoint";
	String alertsInstaceSheet = "Alerts_Instance";
	String alertsBMSheet = "Alerts_BM_Angular_React";
	String alertsMysqlSheet = "DBM_Mysql";
	String alertsMssqlSheet = "DBM_Mssql";
	String alertsOracleSheet = "DBM_Oracle";
	String alertsPostgressSheet   = "DBM_Postgress";
	String alertsMMSheet = "MM_IOS_Android";
	String alertsSmSheet = "SM_Endpoint";
	String alertsVmSheet = "VM_Alerts";
	String alertsSheet = "Alerts_testData";
	String settingsSheet = "Settings";
	String alertsTagGrouping = "Alerts_Tag_Grouping";
	
	String kafkaSheet_Overview = "Kafka_Overview";
	String kafkaSheet_Producer = "Kafka_Producer";
	String kafkaSheet_Consumer = "Kafka_Consumer";
	String kafkaSheet_Broker = "Kafka_Broker";
	String kafkaSheet_Zookeeper = "Kafka_Zookeeper";
	String kafkaSheet_Load = "Load";
	
	String messageSheet = "MessagesToValidate";
	String applicationsNameSheet = "ApplicationsNames";
	String instancePageSheet = "InstancePage";
	String applicationNameSheet = "ApplicationsNames";
	String apmApplicationSheet = "ApplicationPage";
	String mySqlSheet = "MySql";
	String mySqlNeelesh = "MySql_Neelesh";
	String postgresSheet = "Postgres";
	String postgresGreeshma = "PostgresGreeshma";
	String cassandraSheet = "Cassandra";
	String oracleSheet = "Oracle";
	String oracleGreeshma = "Oracle_Greeshma";
	String msSqlSheet = "MSsql";
	String couchBaseSheet= "CouchBase";
	
	String fiveMinutesTimeRange = "5 mins";
	String fifteenMinutesTimeRange = "15 mins";
	String thirtyMinutesTimeRange = "30 mins";
	String sixtyMinutesTimeRange = "60 mins";
	String threeHoursTimeRange =  "3 hours";
	String sixHoursTimeRange =  "6 hours";
	String twelveHoursTimeRange = "12 hours";
	String oneDayTimeRange = "1 day";
	String oneWeekTimeRange = "1 week";
	String oneMonthTimeRange = "1 month";
	String customTimeRange = "Custom";
	
	String thresholdMilliSecValue = "ms";
	String thresholdSecValue = "sec";
	String thresholdMinValue = "min";
	String thresholdHourValue = "hour";
	
	String alertsAPMCapability = "APM";
	String alertsBMCapability = "Browser monitoring";
	String alertsDBMCapability = "Database monitoring";
	String alertsMMCapability = "Mobile monitoring";
	String alertsSMCapability = "Synthetic monitoring";
	String alertsVMCapability = "VM monitoring";

	String MOBILE_STG_URI = "https://stg-http-collector-observability.sixthsense.rakuten.com";
	String MOBILE_STG_ACCESSTOKEN = "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ0ZWFtSWQiOiIxOGZhMDJmMS1iNjc1LTQ1MmQtYjllYy0yN2ZhYzdlZWM5MzUiLCJiaWxsaW5nX2lkIjoiYjVjNjVkMDgtMTVhYi00NDkwLTliZDMtM2FiZDc3ODZkN2YxIiwiaWF0IjoxNjIwMzY2NDgyLCJhdWQiOiJvYXAiLCJpc3MiOiJzaXh0aC1zZW5zLWF1dGgifQ.5U4Tlh8Abf25Wa-SJaf4KQHnNz8C-S35hG7ZG5PIHo8";
	String MOBILE_STG_TEAMID = "18fa02f1-b675-452d-b9ec-27fac7eec935";
	
	String MOBILE_QA_URI = "https://qa-http-collector.133.237.79.36.sslip.io";
	String MOBILE_QA_ACCESSTOKEN = "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ0ZWFtSWQiOiJjYTlhMGFhZS03ZTEzLTQ2MTktYjQzMy0xNjEyNGMxODA5M2UiLCJiaWxsaW5nX2lkIjoiNjkwMjA3MjItODI3Yy00Y2YyLWJiMjctZTFkYzIxNzYwZWRkIiwiaWF0IjoxNzA2MTcyMDU2LCJhdWQiOiJvYXAiLCJpc3MiOiJzaXh0aC1zZW5zLWF1dGgifQ.yqAh1I0Zo_343XQn6rDQHt-Qi3UBM1g5DahltThvuNE";
	String MOBILE_QA_TEAMID = "ca9a0aae-7e13-4619-b433-16124c18093e";
	
	String MOBILE_PERF_URI = "https://perf-http-collector-observability.sixthsense.rakuten.com";
	String MOBILE_PERF_ACCESSTOKEN = "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ0ZWFtSWQiOiJhOTkyNTViNS05YmVjLTRiNzQtODM4ZC01MTIxNWM4MmY0NjYiLCJiaWxsaW5nX2lkIjoiYjJkNzcwYTEtOGRkNi00OWVlLTkzNzQtOWJhY2QyM2I1MjJjIiwiaWF0IjoxNjkzMzg3NDQxLCJhdWQiOiJvYXAiLCJpc3MiOiJzaXh0aC1zZW5zLWF1dGgifQ.dq-NYnngTY_hOFb2YANvfeuHAUu39-XBlzLjhchw850";
	String MOBILE_PERF_TEAMID = "a99255b5-9bec-4b74-838d-51215c82f466";
	
	String BM_QA_URI = "https://qa-http-collector.133.237.79.36.sslip.io";
	String BM_QA_BEARERTOKEN = "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ0ZWFtSWQiOiJjYTlhMGFhZS03ZTEzLTQ2MTktYjQzMy0xNjEyNGMxODA5M2UiLCJiaWxsaW5nX2lkIjoiNjkwMjA3MjItODI3Yy00Y2YyLWJiMjctZTFkYzIxNzYwZWRkIiwiaWF0IjoxNzA2MTcyMDU2LCJhdWQiOiJvYXAiLCJpc3MiOiJzaXh0aC1zZW5zLWF1dGgifQ.yqAh1I0Zo_343XQn6rDQHt-Qi3UBM1g5DahltThvuNE";
	String BM_QA_TEAMID = "ca9a0aae-7e13-4619-b433-16124c18093e";

	String BM_STG_URI = "https://stg-http-collector-observability.sixthsense.rakuten.com";
	String BM_STG_BEARERTOKEN = "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ0ZWFtSWQiOiIxOGZhMDJmMS1iNjc1LTQ1MmQtYjllYy0yN2ZhYzdlZWM5MzUiLCJiaWxsaW5nX2lkIjoiYjVjNjVkMDgtMTVhYi00NDkwLTliZDMtM2FiZDc3ODZkN2YxIiwiaWF0IjoxNjIwMzY2NDgyLCJhdWQiOiJvYXAiLCJpc3MiOiJzaXh0aC1zZW5zLWF1dGgifQ.5U4Tlh8Abf25Wa-SJaf4KQHnNz8C-S35hG7ZG5PIHo8";
	String BM_STG_TEAMID = "18fa02f1-b675-452d-b9ec-27fac7eec935";
}
