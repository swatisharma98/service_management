package com.startup.servicemanagement.model;

import java.util.List;

public class Service {
	
	private String serviceName;
	private List<SubService> subService;
	
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	public List<SubService> getSubService() {
		return subService;
	}
	public void setSubService(List<SubService> subService) {
		this.subService = subService;
	}
	
	

}
