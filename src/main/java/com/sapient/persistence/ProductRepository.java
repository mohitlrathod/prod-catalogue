package com.sapient.persistence;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.sapient.pojo.Product;

@Repository
public class ProductRepository {

	@PersistenceContext
	 private EntityManager entityManager;

	 
	 public void create(Product product) {
	 entityManager.persist(product);
	 }

	 
	 public void update(Product product) {
	 entityManager.merge(product);
	 }

	 
	 public Product getProductById(long id) {
	 return entityManager.find(Product.class, id);
	 }

	 
	 public void delete(long id) {
	 Product product = getProductById(id);
	 if (product != null) {
	 entityManager.remove(product);
	 }
	 }
}
