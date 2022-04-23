package com.startup.servicemanagement.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.startup.servicemanagement.model.Shop;
import com.startup.servicemanagement.service.ShopService;


@RestController
@RequestMapping("/api")
public class ShopController {
	
	
	
	@Autowired
	ShopService shopService;
	
	
	
	@PostMapping("/shop")
	public Shop createShop(@RequestBody Shop shop) {
		return shopService.createShop(shop);
	}
	
	@PutMapping("/shop")
	public Shop updateShop(@RequestBody Shop shop) {
		return shopService.updateShop(shop);
	}
	
	
	

	

}
