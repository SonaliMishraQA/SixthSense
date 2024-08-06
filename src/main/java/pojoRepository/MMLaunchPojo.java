package pojoRepository;

public class MMLaunchPojo {
	
	
	//launch
	private long startTime;
	private String name;
	private String device;
	private String service;
	private String serviceVersion;
	private String country;
	private String platform;
	private String userId;
	private String os;
	private String sessionId;
	
	public MMLaunchPojo(long startTime,String name,String device,String service,String serviceVersion,String country,String platform,String userId,String os,String sessionId)
	{
		this.startTime=startTime;
		this.name=name;
		this.device=device;
		this.service=service;
		this.serviceVersion=serviceVersion;
		this.country=country;
		this.platform=platform;
		this.userId=userId;
		this.os=os;
		this.sessionId=sessionId;
	}

	public long getStartTime() {
		return startTime;
	}

	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDevice() {
		return device;
	}

	public void setDevice(String device) {
		this.device = device;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public String getServiceVersion() {
		return serviceVersion;
	}

	public void setServiceVersion(String serviceVersion) {
		this.serviceVersion = serviceVersion;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	
	

}
