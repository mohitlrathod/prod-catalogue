package com.sapient.controller;


import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.sapient.common.MockTestUtil;
import com.sapient.pojo.Product;
import com.sapient.service.IProductCatalogueService;

@RunWith(SpringRunner.class)
public class ProductCatalogueControllerTest {

	private MockMvc mockMvc;
	
	@InjectMocks
	private ProductCatalogueController productCatalogueController;
	
	@Mock
	private IProductCatalogueService iProductCatalogueService;
	
	@Before
	public void init()
	{
		mockMvc = MockMvcBuilders.standaloneSetup(productCatalogueController).build();
	}
	
	@Test
	public void shouldAddProduct() throws Exception 
	{
		Product product = buildProduct();
		mockMvc.perform(post("/product").content(MockTestUtil.convertToJsonFormat(product))
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isCreated());
		
		verify(iProductCatalogueService,times(1)).createProduct(product);	
	}
	
	@Test
	public void shouldGetProduct() throws Exception 
	{
		String productID = "0";
		Product product = buildProduct();
		
		when(iProductCatalogueService.searchProduct(Long.parseLong(productID))).thenReturn(product);
		
		
		mockMvc.perform(get("/product/"+productID).content(productID)
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
		
		verify(iProductCatalogueService,times(1)).searchProduct(Long.parseLong(productID));	
	}	
	
	@Test
	public void shouldDeleteProduct() throws Exception 
	{
		String productID = "0";
		
		
		doNothing().when(iProductCatalogueService).deleteProduct(Long.parseLong(productID));
		mockMvc.perform(delete("/product/"+productID).content(productID)
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
		
		verify(iProductCatalogueService,times(1)).deleteProduct(Long.parseLong(productID));	
	}
	

	
	
	public Product buildProduct()
	{
		Product product = new Product();
		product.setProductID(0);
		product.setBrand("Apple");
		product.setOs("IOS");
		product.setProductName("Iphone");
		product.setRam("3");
		product.setProductDescription("dew");
		
		return product;
	}
	
}
