package com.startup.servicemanagement.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.google.common.base.Strings;
import com.startup.servicemanagement.model.ImageInfo;
import com.startup.servicemanagement.model.Shop;
import com.startup.servicemanagement.model.UploadImagePojo;
import com.startup.servicemanagement.repository.ShopRepository;


@Service
public class ShopServiceImpl implements ShopService{
	
	private static final String BUCKET_NAME = "barber/";
	private static final String fileUploadUrl = "http://localhost:8000/upload/";
	private static final Logger LOGGER = LoggerFactory.getLogger(ShopServiceImpl.class);

	@Autowired
	ShopRepository shopRepo;
	
	@Autowired
	private RestTemplate restTemplate;
	
	
	
	
	@Override
	@Transactional
	public Shop createShop(Shop shop, MultipartFile[] file) {
	 LOGGER.info("Inside create Shop=>",shop);
		
	 shop.setId(UUID.randomUUID().toString());
		
		try {
			
			LOGGER.info("Inside Try Block =>",shop);
			List<UploadImagePojo> list = new ArrayList<>();
			List<ImageInfo> imageInfo = new ArrayList<>();
			
			
			for(MultipartFile fl:file) {
				
			ImageInfo imgInfo = new ImageInfo();
			
			String id = UUID.randomUUID().toString();
		
			UploadImagePojo bean = saveThumbNailImage(id,fl);
			
			imgInfo.setFileName(bean.getFileName());
			imgInfo.setId(bean.getId());
			imgInfo.setFilePath(bean.getPath());
			
			list.add(bean);
			imageInfo.add(imgInfo);
			
			}
			
			shop.setImageInfo(imageInfo);
			LOGGER.info("Inserting in Shop =>",shop);
			shopRepo.save(shop);
			
			
			LOGGER.info("Added Successfully : [{}}",shop);
			
			return shop;
		   
		}catch(Exception e) {
			LOGGER.info("Exception Caught : [{}}");
		}
		
		 return null;
	}
	
	public UploadImagePojo saveThumbNailImage(String id, MultipartFile uploadimage) {
		LOGGER.info("Inside Save Image:file name =>",uploadimage.getOriginalFilename());
		UploadImagePojo bean = new UploadImagePojo();
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.MULTIPART_FORM_DATA);

		MultiValueMap<String, String> fileMap = new LinkedMultiValueMap<>();

		ContentDisposition contentDisposition = ContentDisposition.builder("form-data").name("file")
				.filename(uploadimage.getOriginalFilename()).build();

		fileMap.add(HttpHeaders.CONTENT_DISPOSITION, contentDisposition.toString());
		HttpEntity<byte[]> fileEntity = null;
		try {
			fileEntity = new HttpEntity<>(uploadimage.getBytes(), fileMap);
		} catch (IOException e1) {
			System.out.println("IO Exception");
		}

		MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
		body.add("file", fileEntity);

		HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers);
		LOGGER.info("Calling Minio Service:fileUploadUrl =>",fileUploadUrl);
		ResponseEntity<UploadImagePojo> uip = restTemplate.exchange(fileUploadUrl + BUCKET_NAME + id,
				HttpMethod.POST, requestEntity, UploadImagePojo.class);
		bean.setFileName(uip.getBody().getFileName());
		bean.setId(uip.getBody().getId());
		bean.setPath(uip.getBody().getPath());
		return bean;
	}

	@Override
	public Shop updateShop(Shop shop) {
		if(shop.getId() == null) {
			System.out.println("Id not found");
		}
		shopRepo.save(shop);
		return shop;
	}

	@Override
	public List<Shop> findShop(String data) {
		
		if(data.trim().length() > 0 || data != null) {
			return shopRepo.findAllShop(data);
			
		}
		
		return shopRepo.findAll();
		 
	}

	@Override
	public String deleteShop(String id) {
		shopRepo.deleteById(id);
		return "success";
	}

	

}
