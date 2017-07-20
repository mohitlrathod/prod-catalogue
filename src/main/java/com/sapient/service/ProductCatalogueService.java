package com.sapient.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sapient.persistence.IProductRepository;
import com.sapient.pojo.Product;

@Service
public class ProductCatalogueService implements IProductCatalogueService {

	@Autowired
	private IProductRepository productRepository;

	@Override
	public Product createProduct(Product product) {
		return productRepository.save(product);
	}

	@Override
	public Product searchProduct(Long id) {
		return productRepository.getOne(id);
	}

	@Override
	public void deleteProduct(Long id) throws Exception {
		if (!productRepository.exists(id)) {
			throw new Exception(id + " is not present in DB");
		}
		productRepository.delete(id);
	}
}
