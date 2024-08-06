package pojoRepository.BM;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;

import genericUtilities.ExcelUtility;
import genericUtilities.IPathConstant;

public class BmReactErrorPojo {
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
	private String errorName;
	private String userAgent;
	private String sdk;
	private String userId;
	private String countryCode;
	private String breadcrumbs;
	private String os;
	private String device;
	private String browser;
	private boolean syntheticUser;
	private String traceId;
		
	public BmReactErrorPojo(String uniqueId, String service, String pagePath, String category, long timeStamp, String userId) throws EncryptedDocumentException, IOException {		
		this.uniqueId = uniqueId;
		this.service = service;
		this.serviceVersion = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmDataValidationSheet, "reactError_serviceVersion");
		this.pagePath = pagePath;
		this.category = category;
		this.grade = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmDataValidationSheet, "reactError_grade");
		this.errorUrl = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmDataValidationSheet, "reactError_errorUrl");
		this.message = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmDataValidationSheet, "reactError_message");
		this.stack = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmDataValidationSheet, "reactError_stack");
		this.timeStamp = timeStamp;
		this.environment = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmDataValidationSheet, "reactError_environment");
		this.level = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmDataValidationSheet, "reactError_level");
		this.exception = "{\\\"type\\\":\\\"Error\\\",\\\"value\\\":\\\"\\\\\\\"UncaughtTypeError:Cannotreadpropertiesofnull(reading'check')\\\\\\\"\\\", \\n\"\n"
				+ "    + \" \\\"module\\\":\\\"\\\",\\\"thread_id\\\":0, \\n\"\n"
				+ "    + \" \\\"stacktrace\\\":{\\\"frames\\\":[]}},\\\"errorName\\\":\\\"Error\\\\\\\"UncaughtTypeError:Cannotreadpropertiesofnull(reading'check')\\\\\\\"\\\", \\n\"";
		this.userAgent = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmDataValidationSheet, "reactError_userAgent");
		this.sdk = "{\"name\":\""+excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmDataValidationSheet, "reactError_sdkName")+"\",\"version\":\""+excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmDataValidationSheet, "reactError_sdkVersion")+"\"}";
		this.userId = userId;
		this.countryCode = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmDataValidationSheet, "reactError_countryCode");
		this.breadcrumbs = "[{\"timestamp\":1701689608691,\"type\":\"Debug\",\"message\":\"Warning: Invalid DOM property `%s`. Did you mean `%s`?%s class className \\n    at div\\n    at nav\\n    at Navbar\\n    at App (http://localhost:3000/static/js/bundle.js:47:82)\\n    at Router (http://localhost:3000/static/js/bundle.js:51963:15)\\n    at BrowserRouter (http://localhost:3000/static/js/bundle.js:50019:5)\",\"level\":\"Error\",\"category\":\"console\"},{\"timestamp\":1701689608692,\"type\":\"Debug\",\"message\":\"Warning: validateDOMNesting(...): %s cannot appear as a descendant of <%s>.%s <a> a \\n    at a\\n    at li\\n    at a\\n    at LinkWithRef (http://localhost:3000/static/js/bundle.js:50131:7)\\n    at NavLinkWithRef (http://localhost:3000/static/js/bundle.js:50205:23)\\n    at ul\\n    at nav\\n    at Navbar\\n    at App (http://localhost:3000/static/js/bundle.js:47:82)\\n    at Router (http://localhost:3000/static/js/bundle.js:51963:15)\\n    at BrowserRouter (http://localhost:3000/static/js/bundle.js:50019:5)\",\"level\":\"Error\",\"category\":\"console\"},{\"timestamp\":1701689608695,\"type\":\"Debug\",\"message\":\"Warning: Invalid DOM property `%s`. Did you mean `%s`?%s fill-rule fillRule \\n    at path\\n    at svg\\n    at a\\n    at div\\n    at div\\n    at div\\n    at section\\n    at Home (http://localhost:3000/static/js/bundle.js:1544:51)\\n    at RenderedRoute (http://localhost:3000/static/js/bundle.js:51403:5)\\n    at Routes (http://localhost:3000/static/js/bundle.js:52025:5)\\n    at App (http://localhost:3000/static/js/bundle.js:47:82)\\n    at Router (http://localhost:3000/static/js/bundle.js:51963:15)\\n    at BrowserRouter (http://localhost:3000/static/js/bundle.js:50019:5)\",\"level\":\"Error\",\"category\":\"console\"},{\"timestamp\":1701689608695,\"type\":\"Debug\",\"message\":\"Warning: Invalid DOM property `%s`. Did you mean `%s`?%s clip-rule clipRule \\n    at path\\n    at svg\\n    at a\\n    at div\\n    at div\\n    at div\\n    at section\\n    at Home (http://localhost:3000/static/js/bundle.js:1544:51)\\n    at RenderedRoute (http://localhost:3000/static/js/bundle.js:51403:5)\\n    at Routes (http://localhost:3000/static/js/bundle.js:52025:5)\\n    at App (http://localhost:3000/static/js/bundle.js:47:82)\\n    at Router (http://localhost:3000/static/js/bundle.js:51963:15)\\n    at BrowserRouter (http://localhost:3000/static/js/bundle.js:50019:5)\",\"level\":\"Error\",\"category\":\"console\"},{\"timestamp\":1701689608695,\"type\":\"Debug\",\"message\":\"Warning: Invalid DOM property `%s`. Did you mean `%s`?%s stroke-linecap strokeLinecap \\n    at path\\n    at svg\\n    at a\\n    at div\\n    at div\\n    at div\\n    at section\\n    at Home (http://localhost:3000/static/js/bundle.js:1544:51)\\n    at RenderedRoute (http://localhost:3000/static/js/bundle.js:51403:5)\\n    at Routes (http://localhost:3000/static/js/bundle.js:52025:5)\\n    at App (http://localhost:3000/static/js/bundle.js:47:82)\\n    at Router (http://localhost:3000/static/js/bundle.js:51963:15)\\n    at BrowserRouter (http://localhost:3000/static/js/bundle.js:50019:5)\",\"level\":\"Error\",\"category\":\"console\"},{\"timestamp\":1701689608695,\"type\":\"Debug\",\"message\":\"Warning: Invalid DOM property `%s`. Did you mean `%s`?%s stroke-linejoin strokeLinejoin \\n    at path\\n    at svg\\n    at a\\n    at div\\n    at div\\n    at div\\n    at section\\n    at Home (http://localhost:3000/static/js/bundle.js:1544:51)\\n    at RenderedRoute (http://localhost:3000/static/js/bundle.js:51403:5)\\n    at Routes (http://localhost:3000/static/js/bundle.js:52025:5)\\n    at App (http://localhost:3000/static/js/bundle.js:47:82)\\n    at Router (http://localhost:3000/static/js/bundle.js:51963:15)\\n    at BrowserRouter (http://localhost:3000/static/js/bundle.js:50019:5)\",\"level\":\"Error\",\"category\":\"console\"},{\"timestamp\":1701689608695,\"type\":\"Debug\",\"message\":\"Warning: Invalid DOM property `%s`. Did you mean `%s`?%s stroke-width strokeWidth \\n    at path\\n    at svg\\n    at a\\n    at div\\n    at div\\n    at div\\n    at section\\n    at Home (http://localhost:3000/static/js/bundle.js:1544:51)\\n    at RenderedRoute (http://localhost:3000/static/js/bundle.js:51403:5)\\n    at Routes (http://localhost:3000/static/js/bundle.js:52025:5)\\n    at App (http://localhost:3000/static/js/bundle.js:47:82)\\n    at Router (http://localhost:3000/static/js/bundle.js:51963:15)\\n    at BrowserRouter (http://localhost:3000/static/js/bundle.js:50019:5)\",\"level\":\"Error\",\"category\":\"console\"},{\"timestamp\":1701689608726,\"type\":\"HTTP\",\"category\":\"xhr\",\"data\":[{\"key\":\"method\",\"value\":\"GET\"},{\"key\":\"url\",\"value\":\"http://localhost:8084/user1234\"},{\"key\":\"status_code\",\"value\":0}],\"level\":\"Info\"},{\"type\":\"Error\",\"category\":\"exception\",\"level\":\"Error\",\"message\":\"Error: XMLHttpRequest method:GET<br/> url: http://localhost:8084/user1234<br/> status: 0\",\"timestamp\":1701689608726}]";
		this.os = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmDataValidationSheet, "reactError_os");
		this.device = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmDataValidationSheet, "reactError_device");
		this.browser = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmDataValidationSheet, "reactError_browser");
		this.syntheticUser = false;
		this.traceId = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmDataValidationSheet, "reactError_traceId");
	}

	@Override
	public String toString() {
		return "BM React Error API Pojo File [uniqueId :"+uniqueId+"service : "+service+"serviceVersion : "+serviceVersion+"pagePath : "+pagePath+
				"category : "+category+"grade : "+grade+"errorUrl : "+errorUrl+"message : "+message+"errorName : "+errorName+
				"userAgent : "+userAgent+"sdk : "+sdk+"userId : "+userId+"countryCode : "+countryCode+"breadcrumbs : "+breadcrumbs+
				"os : "+os+"device : "+device+"browser : "+browser+"syntheticUser : "+syntheticUser+"traceId : "+traceId+"]";
	}
}