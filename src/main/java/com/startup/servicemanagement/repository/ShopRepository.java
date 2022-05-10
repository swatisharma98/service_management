package com.startup.servicemanagement.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.startup.servicemanagement.model.Shop;

public interface ShopRepository extends MongoRepository<Shop, String>{

	
	@Query("{ $text: { $search: ?0 }}")
	List<Shop> findAllShop(String data);

}
