package pojoRepository.BM;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;

import genericUtilities.ExcelUtility;
import genericUtilities.IPathConstant;

public class BmReactLoadPojo {
	ExcelUtility excel = new ExcelUtility();

	private int redirectTime;
	private int dnsTime;
	private int ttfbTime;
	private int tcpTime;
	private int transTime;
	private int domAnalysisTime;
	private int fptTime;
	private int domReadyTime;
	private int loadPageTime;
	private int resTime;
	private int ttlTime;
	private int firstPackTime;
	private int fmpTime;
	private String pagePath;
	private String domain;
	private String serviceVersion;
	private String service;
	private String os;
	private String device;
	private String browser;
	private String countryCode;
	private Boolean syntheticUser;
	
	public BmReactLoadPojo(String pagePath, String service) throws NumberFormatException, EncryptedDocumentException, IOException {
		this.redirectTime = Integer.parseInt(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmDataValidationSheet, "reactLoad_redirectTime"));
		this.dnsTime = Integer.parseInt(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmDataValidationSheet, "reactLoad_dnsTime"));
		this.ttfbTime = Integer.parseInt(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmDataValidationSheet, "reactLoad_ttfbTime"));
		this.tcpTime = Integer.parseInt(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmDataValidationSheet, "reactLoad_tcpTime"));
		this.transTime = Integer.parseInt(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmDataValidationSheet, "reactLoad_transTime"));
		this.domAnalysisTime = Integer.parseInt(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmDataValidationSheet, "reactLoad_domAnalysisTime"));
		this.fptTime = Integer.parseInt(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmDataValidationSheet, "reactLoad_fptTime"));
		this.domReadyTime = Integer.parseInt(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmDataValidationSheet, "reactLoad_domReadyTime"));
		this.loadPageTime = Integer.parseInt(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmDataValidationSheet, "reactLoad_loadPageTime"));
		this.resTime = Integer.parseInt(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmDataValidationSheet, "reactLoad_resTime"));
		this.ttlTime = Integer.parseInt(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmDataValidationSheet, "reactLoad_ttlTime"));
		this.firstPackTime = Integer.parseInt(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmDataValidationSheet, "reactLoad_firstPackTime"));
		this.fmpTime = Integer.parseInt(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmDataValidationSheet, "reactLoad_fmpTime"));
		this.pagePath = pagePath;
		this.domain = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmDataValidationSheet, "reactLoad_domain");
		this.serviceVersion = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmDataValidationSheet, "reactLoad_serviceVersion");
		this.service = service;
		this.os = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmDataValidationSheet, "reactLoad_os");
		this.device = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmDataValidationSheet, "reactLoad_device");
		this.browser = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmDataValidationSheet, "reactLoad_browser");
		this.countryCode = excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmDataValidationSheet, "reactLoad_countryCode");
		this.syntheticUser = Boolean.parseBoolean(excel.ReadDataFromExcelByUsingKeyProperty(IPathConstant.bmExcelPath, IPathConstant.bmDataValidationSheet, "reactLoad_syntheticUser"));
	}
	
	@Override
	public String toString() {
		return "BM Angular Load API Pojo File [redirectTime=" + redirectTime + ", dnsTime=" + dnsTime + ", ttfbTime=" + ttfbTime
				+ ", tcpTime=" + tcpTime + ", transTime=" + transTime + ", domAnalysisTime=" + domAnalysisTime
				+ ", fptTime=" + fptTime + ", domReadyTime=" + domReadyTime + ", loadPageTime=" + loadPageTime
				+ ", resTime=" + resTime + ", ttlTime=" + ttlTime + ", firstPackTime=" + firstPackTime + ", fmpTime="
				+ fmpTime + ", pagePath=" + pagePath + ", domain=" + domain + ", serviceVersion=" + serviceVersion
				+ ", service=" + service + ", os=" + os + ", device=" + device + ", browser=" + browser
				+ ", countryCode=" + countryCode + ", syntheticUser=" + syntheticUser + "]";
	}
}

