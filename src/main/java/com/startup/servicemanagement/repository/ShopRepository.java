package com.startup.servicemanagement.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.startup.servicemanagement.model.Shop;

public interface ShopRepository extends MongoRepository<Shop, String>{

}
