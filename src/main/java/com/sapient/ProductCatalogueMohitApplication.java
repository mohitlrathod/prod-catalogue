package com.sapient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sapient.controller.ProductCatalogueController;

@SpringBootApplication
public class ProductCatalogueMohitApplication {

	private static final Logger logger = LoggerFactory.getLogger(ProductCatalogueMohitApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(ProductCatalogueMohitApplication.class, args);
	}
}
