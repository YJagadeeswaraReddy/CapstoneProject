package com.wipro.sfh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.sfh.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	
	
}
