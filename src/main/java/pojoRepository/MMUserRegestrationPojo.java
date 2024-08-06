package pojoRepository;

public class MMUserRegestrationPojo {
	
	
	//user registration
	private String serviceVersion;
	private String userId;
	private String platform;
	private String device;
	private long registrationTime;
	private String os;
	private String service;
	private String country;
	
	public MMUserRegestrationPojo(String serviceVersion,String userId,String platform,String device,long registrationTime,String os,String service,String country )
	{
		this.serviceVersion=serviceVersion;
		this.userId=userId;
		this.platform=platform;
		this.device=device;
		this.registrationTime=registrationTime;
		this.os=os;
		this.service=service;
		this.country=country;
	}
	

	public String getServiceVersion() {
		return serviceVersion;
	}

	public void setServiceVersion(String serviceVersion) {
		this.serviceVersion = serviceVersion;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public String getDevice() {
		return device;
	}

	public void setDevice(String device) {
		this.device = device;
	}

	public long getRegistrationTime() {
		return registrationTime;
	}

	public void setRegistrationTime(long registrationTime) {
		this.registrationTime = registrationTime;
	}

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
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
	
	
	

	


	

}
