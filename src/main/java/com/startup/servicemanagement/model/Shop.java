package com.startup.servicemanagement.model;

import java.util.List;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "shop")
public class Shop {
	
	@Id
    private String id;
	private String shopName;
	private Address address;
	private List<ShopTime> shopTime;
	private List<Service> service;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public List<Service> getService() {
		return service;
	}
	public void setService(List<Service> service) {
		this.service = service;
	}
	public List<ShopTime> getShopTime() {
		return shopTime;
	}
	public void setShopTime(List<ShopTime> shopTime) {
		this.shopTime = shopTime;
	}
	
	
	
	

}
