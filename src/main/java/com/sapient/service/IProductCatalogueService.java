package com.sapient.service;

import com.sapient.pojo.Product;

public interface IProductCatalogueService {

	Product createProduct(Product product);

	Product searchProduct(Long id);

	void deleteProduct(Long id) throws Exception;

}
