package com.sapient.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sapient.pojo.Product;

public interface IProductRepository extends JpaRepository<Product, Long> {

}
