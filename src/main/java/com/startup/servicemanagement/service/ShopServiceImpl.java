package com.startup.servicemanagement.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.startup.servicemanagement.model.Shop;
import com.startup.servicemanagement.repository.ShopRepository;


@Service
public class ShopServiceImpl implements ShopService{

	@Autowired
	ShopRepository shopRepo;
	
	@Override
	public Shop createShop(Shop shop) {
		shop.setId(UUID.randomUUID().toString());
		shopRepo.save(shop);
	    return shop;
		
	}

}
