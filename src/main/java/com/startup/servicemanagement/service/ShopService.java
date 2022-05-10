package com.startup.servicemanagement.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.startup.servicemanagement.model.Shop;

public interface ShopService {


	Shop updateShop(Shop shop);

	List<Shop> findShop(String data);

	String deleteShop(String id);

	Shop createShop(Shop shop, MultipartFile[] file);

}
