package pojoRepository;

public class MMPerformancePojo {
	
	//performance
	private String status;
	private long requestTime;
	private String endpointName;
	private String platform;
	private String responseTime;
	private String device;
	private String statusCode;
	private String os;
	private String host;
	private String requestPayloadSize;
	private String service;
	private String country;
	private String serviceVersion;
	private String responsePayloadSize;
	private String userId;
	
	public MMPerformancePojo(String status,long requestTime,String endpointName,String platform,String responseTime,String device,String statusCode,String os,String host,String requestPayloadSize,String service,String country,String serviceVersion,String responsePayloadSize,String userId)
	{
		this.status=status;
		this.requestTime=requestTime;
		this.endpointName=endpointName;
		this.platform=platform;
		this.responseTime=responseTime;
		this.device=device;
		this.statusCode=statusCode;
		this.os=os;
		this.host=host;
		this.requestPayloadSize=requestPayloadSize;
		this.service=service;
		this.country=country;
		this.serviceVersion=serviceVersion;
		this.responsePayloadSize=responsePayloadSize;
		this.userId=userId;
		
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public long getRequestTime() {
		return requestTime;
	}

	public void setRequestTime(long requestTime) {
		this.requestTime = requestTime;
	}

	public String getEndpointName() {
		return endpointName;
	}

	public void setEndpointName(String endpointName) {
		this.endpointName = endpointName;
	}

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public String getResponseTime() {
		return responseTime;
	}

	public void setResponseTime(String responseTime) {
		this.responseTime = responseTime;
	}

	public String getDevice() {
		return device;
	}

	public void setDevice(String device) {
		this.device = device;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getRequestPayloadSize() {
		return requestPayloadSize;
	}

	public void setRequestPayloadSize(String requestPayloadSize) {
		this.requestPayloadSize = requestPayloadSize;
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

	public String getServiceVersion() {
		return serviceVersion;
	}

	public void setServiceVersion(String serviceVersion) {
		this.serviceVersion = serviceVersion;
	}

	public String getResponsePayloadSize() {
		return responsePayloadSize;
	}

	public void setResponsePayloadSize(String responsePayloadSize) {
		this.responsePayloadSize = responsePayloadSize;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	

}
