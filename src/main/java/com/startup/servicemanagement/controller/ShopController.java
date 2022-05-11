package com.startup.servicemanagement.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.startup.servicemanagement.model.Shop;
import com.startup.servicemanagement.service.ShopService;


@RestController
@RequestMapping("/api")
public class ShopController {
	
	@Autowired
	ShopService shopService;
	
	
	
	@PostMapping(value = "/shop", consumes = { MediaType.APPLICATION_JSON_VALUE,MediaType.MULTIPART_FORM_DATA_VALUE })
	public Shop createShop(@RequestPart("Form") String documents,@RequestPart(value = "file") MultipartFile[] file) throws JsonMappingException, JsonProcessingException {
		Shop shop = new ObjectMapper().readValue(documents, Shop.class);
		return shopService.createShop(shop,file);
	}
	
	@PutMapping("/shop")
	public Shop updateShop(@RequestBody Shop shop) {
		return shopService.updateShop(shop);
	}
	
	
	@GetMapping("/shop")
	public List<Shop> findAllShop(@RequestParam(value="filter",required = false) String data){
		return shopService.findShop(data);
	}
	  
	@GetMapping("/shop/{id}")
	public Shop findShopById(@PathVariable(value="id") String id){
		return shopService.findShopById(id);
	}

	@DeleteMapping("/shop")
	public String deleteShop(@RequestParam("id") String id) {
		return shopService.deleteShop(id);
	}

}
