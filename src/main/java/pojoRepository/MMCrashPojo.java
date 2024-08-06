package pojoRepository;

public class MMCrashPojo {
	
	
	//crashes API
	private String uniqueId;
	private String sessionId;
	private long crashTime;
	private String crashReason;
	private String fileName = "MainActivity.kt";
	private String lineNo = "7";
	private String crashStackTrace;
	private String memoryUsage;
	private String os;
	private String platform;
	private String serviceVersion;
	private String service;
	private String country;
	private String deviceInfo;

	public MMCrashPojo(String uniqueId,String sessionId,long crashTime,String crashReason,String crashStackTrace,String memoryUsage,String os,String platform,String serviceVersion,String service,String country,String deviceInfo)
	{
		this.uniqueId=uniqueId;
		this.sessionId=sessionId;
		this.crashTime=crashTime;
		this.crashReason=crashReason;
		this.crashStackTrace=crashStackTrace;
		this.memoryUsage=memoryUsage;
		this.os=os;
		this.platform=platform;
		this.serviceVersion=serviceVersion;
		this.service=service;
		this.country=country;
		this.deviceInfo=deviceInfo;
		
	}

	public String getUniqueId() {
		return uniqueId;
	}

	public void setUniqueId(String uniqueId) {
		this.uniqueId = uniqueId;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public long getCrashTime() {
		return crashTime;
	}

	public void setCrashTime(long crashTime) {
		this.crashTime = crashTime;
	}

	public String getCrashReason() {
		return crashReason;
	}

	public void setCrashReason(String crashReason) {
		this.crashReason = crashReason;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getLineNo() {
		return lineNo;
	}

	public void setLineNo(String lineNo) {
		this.lineNo = lineNo;
	}

	public String getCrashStackTrace() {
		return crashStackTrace;
	}

	public void setCrashStackTrace(String crashStackTrace) {
		this.crashStackTrace = crashStackTrace;
	}

	public String getMemoryUsage() {
		return memoryUsage;
	}

	public void setMemoryUsage(String memoryUsage) {
		this.memoryUsage = memoryUsage;
	}

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public String getServiceVersion() {
		return serviceVersion;
	}

	public void setServiceVersion(String serviceVersion) {
		this.serviceVersion = serviceVersion;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getDeviceInfo() {
		return deviceInfo;
	}

	public void setDeviceInfo(String deviceInfo) {
		this.deviceInfo = deviceInfo;
	}
	
	

}
