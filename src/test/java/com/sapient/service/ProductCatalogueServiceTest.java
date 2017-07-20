package com.sapient.service;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import com.sapient.persistence.IProductRepository;
import com.sapient.pojo.Product;

@RunWith(SpringRunner.class)
public class ProductCatalogueServiceTest {

	@InjectMocks
	ProductCatalogueService productCatalogueService;

	@Mock
	IProductRepository productRepository;

	@Test
	public void shouldCreateClient() {
		Product product = new Product();
		when(productRepository.save(any(Product.class))).thenReturn(product);
		productCatalogueService.createProduct(product);
		verify(productRepository, times(1)).save(any(Product.class));
	}

	@Test
	public void shouldSearchProduct() {
		Product product = new Product();
		when(productRepository.getOne(any(Long.class))).thenReturn(product);
		productCatalogueService.searchProduct(new Long(1L));
		verify(productRepository, times(1)).getOne(any(Long.class));
	}
	
	@Test
	public void shouldDeleteProductIfExists() throws Exception {
		when(productRepository.exists(any(Long.class))).thenReturn(true);
		productCatalogueService.deleteProduct(new Long(1L));
		verify(productRepository, times(1)).delete(any(Long.class));
	}
	
	@Test(expected=Exception.class)
	public void shouldThrowExceptionIfeProductNotExists() throws Exception {
		when(productRepository.exists(any(Long.class))).thenReturn(false);
		productCatalogueService.deleteProduct(new Long(1L));
		verify(productRepository, times(0)).delete(any(Long.class));
	}

}
