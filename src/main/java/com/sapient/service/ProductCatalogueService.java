package com.sapient.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sapient.exception.EmptyResultDataAccessException;
import com.sapient.persistence.IProductRepository;
import com.sapient.persistence.ProductRepository;
import com.sapient.pojo.Product;

@Service
@Transactional

public class ProductCatalogueService implements IProductCatalogueService {

	
	@Autowired
	 private IProductRepository productRepository;

	@Override
	public Product createProduct(Product product) {
		productRepository.save(product);
		return product;
	}

	@Override
	public Product searchProduct(Long id) {
		Product product =	productRepository.getOne(id);
		return product;
	}

	@Override
	public void deleteProduct(Long id) throws Exception {
		//Product product= productRepository.getOne(id);
		boolean test = productRepository.exists(id);
		if(!test){
			String message = id+" is not present in DB"; // this has to override
			
			throw new Exception(message);
		}
		productRepository.delete(id);
	}

	
	
}
