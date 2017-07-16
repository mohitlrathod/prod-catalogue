package com.sapient.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.pojo.Product;
import com.sapient.service.IProductCatalogueService;

@RestController
@RequestMapping("/product")
@EnableAutoConfiguration

public class ProductCatalogueController {

	private static final Logger logger = LoggerFactory.getLogger(ProductCatalogueController.class);

	
	
	@Autowired
	private IProductCatalogueService iProductCatalogueService;
	
	@PostMapping
	public ResponseEntity<String> createNewProduct(@RequestBody Product product) {
		
		logger.debug("Create Porduct called with paramter "+ product);
		
		iProductCatalogueService.createProduct(product);
		
		return new ResponseEntity<>(product.getProductName() + " Client has been created successfully.",
				HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<String> getProduct(@PathVariable String id){
		
		logger.debug("Get Porduct called to search with ID "+ id);
		Product product = iProductCatalogueService.searchProduct(Long.parseLong(id));
		return new ResponseEntity<>(product.getProductName(), HttpStatus.OK);
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable String id) throws Exception{
		
		logger.debug("Delete Porduct called  ID:{} ", id);
		iProductCatalogueService.deleteProduct(Long.parseLong(id));
		return new ResponseEntity<>("Product with ID "+id +"is deleted successfully", HttpStatus.OK);
	}
	
	
	
}
