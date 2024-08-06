package pojoRepository.BM;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;

import genericUtilities.ExcelUtility;
import genericUtilities.IPathConstant;

public class BMAngularErrorPojo {
	
	ExcelUtility excel = new ExcelUtility();
	
	private String uniqueId;
	private String service;
	private String serviceVersion;
	private String pagePath;
	private String category;
	private String grade;
	private String errorUrl;
	private String message;
	private String stack;
	private long timeStamp;
	private String environment;
	private String level;
	private String exception;
	private String userId;
	private String countryCode;
	private String breadcrumbs;
	private String os;
	private String device;
	private String browser;
	private boolean syntheticUser;
	private String traceId;
	
	public BMAngularErrorPojo(String uniqueId, String service, String pagePath, String category, long timeStamp, String userId) throws EncryptedDocumentException, IOException {
		String userAgent = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmDataValidationSheet, "angularError_userAgent");
		String sdkName = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmDataValidationSheet, "angularError_sdkName");
		String sdkVersion = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmDataValidationSheet, "angularError_sdkVersion");

		this.uniqueId = uniqueId;
		this.service = service;
		serviceVersion = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmDataValidationSheet, "angularError_serviceVersion");
		this.pagePath = pagePath;
		this.category = category;
		grade = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmDataValidationSheet, "angularError_grade");
		this.errorUrl = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmDataValidationSheet, "angularError_errorUrl");
		message = "\"error category:"+category+"\r\nError: XMLHttpRequest method:GET, url: http://localhost:8080/user, status: 404\r\n\"";
		stack = "\"loadend:Error\n    at XMLHttpRequest.xhrEvent (http://10.196.141.10:8083/vendor.js:58922:51)\n    at XMLHttpRequest.wrapped (http://10.196.141.10:8083/vendor.js:61850:21)\n    at _ZoneDelegate.invokeTask (http://10.196.141.10:8083/polyfills.js:415:31)\n    at Object.onInvokeTask (http://10.196.141.10:8083/vendor.js:37195:33)\n    at _ZoneDelegate.invokeTask (http://10.196.141.10:8083/polyfills.js:414:60)\n    at Zone.runTask (http://10.196.141.10:8083/polyfills.js:187:47)\n    at ZoneTask.invokeTask [as invoke] (http://10.196.141.10:8083/polyfills.js:496:34)\n    at invokeTask (http://10.196.141.10:8083/polyfills.js:1670:18)\n    at globalCallback (http://10.196.141.10:8083/polyfills.js:1701:29)\n    at XMLHttpRequest.globalZoneAwareCallback (http://10.196.141.10:8083/polyfills.js:1734:16)\"";
		this.timeStamp = timeStamp;
		this.environment = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmDataValidationSheet, "angularError_environment");
		this.level = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmDataValidationSheet, "angularError_level");
		this.exception = "{\"type\":\"Error: XMLHttpRequest\",\"value\":\"method:GET, url: http://localhost:8080/user,\n      status: 404\",\"module\":\"\",\"thread_id\":0,\"stacktrace\":{\"frames\":[]}},\n\"\n"
				+ " \"errorName\":\"Error: XMLHttpRequest method:GET, url: http://localhost:8080/user, status: 404\",\"userAgent\":\""+userAgent+"\",\"sdk\":{\"name\":\""+sdkName+"\",\"version\":\""+sdkVersion+"\"},\n\"";
		this.userId = userId;
		this.countryCode = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmDataValidationSheet, "angularError_countryCode");
		this.breadcrumbs = "[{\"timestamp\":"+timeStamp+",\"type\":\"Debug\",\"message\":\"Angular is running in development mode. Call enableProdMode() to enable production mode.\",\"level\":\"Info\",\"category\":\"console\"},\n\"\n"
				+ "    + \"                 {\"timestamp\":"+timeStamp+",\"type\":\"Navigation\",\"category\":\"navigation\",\"data\":[{\"key\":\"to\",\"value\":\"/\"},{\"key\":\"from\",\"value\":\"/\"}],\"level\":\"Info\"},\n\"\n"
				+ "    + \"                 {\"timestamp\":"+timeStamp+",\"type\":\"HTTP\",\"category\":\"xhr\",\"data\":[{\"key\":\"method\",\"value\":\"GET\"},{\"key\":\"url\",\"value\":\"http://10.196.141.10:8083/sockjs-node/info?t=1693813114441\"},\n\"\n"
				+ "    + \"                 {\"key\":\"status_code\",\"value\":200}],\n\"\n"
				+ "    + \" \"level\":\"Info\"},\n\"\n"
				+ "    + \" {\"timestamp\":"+timeStamp+",\n\"\n"
				+ "    + \" \"type\":\"HTTP\",\"category\":\"xhr\",\"data\":[{\"key\":\"method\",\"value\":\"GET\"},\n\"\n"
				+ "    + \" {\"key\":\"url\",\"value\":\"http://localhost:8080/user\"},\n\"\n"
				+ "    + \" {\"key\":\"status_code\",\"value\":404}],\n\"\n"
				+ "    + \" \"level\":\"Info\"},\n\"\n"
				+ "    + \" {\"timestamp\":"+timeStamp+",\"type\":\"Debug\",\"message\":\"oops [object Object]\",\"level\":\"Info\",\"category\":\"console\"},\n\"\n"
				+ "    + \" {\"type\":\"Error\",\"category\":\"exception\",\"level\":\"Error\",\"message\":\"Error: XMLHttpRequest method:GET<br/> url: http://localhost:8080/user<br/> status: 404\",\"timestamp\":"+timeStamp+"}]\"";
		this.os = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmDataValidationSheet, "angularLoad_os");
		this.device = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmDataValidationSheet, "angularLoad_device");
		this.browser = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmDataValidationSheet, "angularLoad_browser");
		this.syntheticUser = Boolean.parseBoolean(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmDataValidationSheet, "angularLoad_syntheticUser"));
		this.traceId = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmDataValidationSheet, "angularError_traceId");
	}
	
	

}
	
	
	/*
	 * String Body = "{\n"
	 
		    + " \"uniqueId\":\""+eventId+"\",\n"
		    + " \"service\":\"{'name':'BM_eComm-Angular-1','teamID':'"+teamid+"','type':'B'}\",\n"
		    + " \"serviceVersion\":\"1.2.1\",\n"
		    + " \"pagePath\":\""+path+"\",\n"
		    + " \"category\":\""+category+"\",\n"
		    + " \"grade\":\"Error\",\n"
		    + " \"errorUrl\":\"http://localhost:8080/user\",\n"
		    + " \"message\":\"error category:"+category+"\r\nError: XMLHttpRequest method:GET, url: http://localhost:8080/user, status: 404\r\n\",\n"
		    + " \"stack\":\"loadend:Error\n    at XMLHttpRequest.xhrEvent (http://10.196.141.10:8083/vendor.js:58922:51)\n    at XMLHttpRequest.wrapped (http://10.196.141.10:8083/vendor.js:61850:21)\n    at _ZoneDelegate.invokeTask (http://10.196.141.10:8083/polyfills.js:415:31)\n    at Object.onInvokeTask (http://10.196.141.10:8083/vendor.js:37195:33)\n    at _ZoneDelegate.invokeTask (http://10.196.141.10:8083/polyfills.js:414:60)\n    at Zone.runTask (http://10.196.141.10:8083/polyfills.js:187:47)\n    at ZoneTask.invokeTask [as invoke] (http://10.196.141.10:8083/polyfills.js:496:34)\n    at invokeTask (http://10.196.141.10:8083/polyfills.js:1670:18)\n    at globalCallback (http://10.196.141.10:8083/polyfills.js:1701:29)\n    at XMLHttpRequest.globalZoneAwareCallback (http://10.196.141.10:8083/polyfills.js:1734:16)\",\n"
		    + " \"timestamp\":"+timeStamp+",\n"
		    + " \"environment\":\"prod\",\n" 
		    + " \"level\":\"error\",\n"
		    + " \"exception\":{\"type\":\"Error: XMLHttpRequest\",\"value\":\"method:GET, url: http://localhost:8080/user,\n      status: 404\",\"module\":\"\",\"thread_id\":0,\"stacktrace\":{\"frames\":[]}},\n"
		    + " \"errorName\":\"Error: XMLHttpRequest method:GET, url: http://localhost:8080/user, status: 404\",\"userAgent\":\"Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/116.0.0.0 Safari/537.36\",\"sdk\":{\"name\":\"@sixthsense/sixthsense-javascript-agent\",\"version\":\"3.7.3\"},\n"
		    + " \"userId\":\""+userId+"\",\n"
		    + " \"countryCode\":\"IN\",\n"
		    + " \"breadcrumbs\":[{\"timestamp\":"+timeStamp+",\"type\":\"Debug\",\"message\":\"Angular is running in development mode. Call enableProdMode() to enable production mode.\",\"level\":\"Info\",\"category\":\"console\"},\n"
		    + "                 {\"timestamp\":"+timeStamp+",\"type\":\"Navigation\",\"category\":\"navigation\",\"data\":[{\"key\":\"to\",\"value\":\"/\"},{\"key\":\"from\",\"value\":\"/\"}],\"level\":\"Info\"},\n"
		    + "                 {\"timestamp\":"+timeStamp+",\"type\":\"HTTP\",\"category\":\"xhr\",\"data\":[{\"key\":\"method\",\"value\":\"GET\"},{\"key\":\"url\",\"value\":\"http://10.196.141.10:8083/sockjs-node/info?t=1693813114441\"},\n"
		    + "                 {\"key\":\"status_code\",\"value\":200}],\n"
		    + " \"level\":\"Info\"},\n"
		    + " {\"timestamp\":"+timeStamp+",\n"
		    + " \"type\":\"HTTP\",\"category\":\"xhr\",\"data\":[{\"key\":\"method\",\"value\":\"GET\"},\n"
		    + " {\"key\":\"url\",\"value\":\"http://localhost:8080/user\"},\n"
		    + " {\"key\":\"status_code\",\"value\":404}],\n"
		    + " \"level\":\"Info\"},\n"
		    + " {\"timestamp\":"+timeStamp+",\"type\":\"Debug\",\"message\":\"oops [object Object]\",\"level\":\"Info\",\"category\":\"console\"},\n"
		    + " {\"type\":\"Error\",\"category\":\"exception\",\"level\":\"Error\",\"message\":\"Error: XMLHttpRequest method:GET<br/> url: http://localhost:8080/user<br/> status: 404\",\"timestamp\":"+timeStamp+"}],\n"
		    + " \"os\":\"macOS 10.15.7\",\"device\":\"desktop\",\"browser\":\"Chrome 116.0.0.0\",\"syntheticUser\":false,\"traceId\":\"95ad52a9-13b2-4fa5-a735-8999d360b0c2\"}";
	*/