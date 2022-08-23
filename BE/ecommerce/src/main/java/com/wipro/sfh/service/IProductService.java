package com.wipro.sfh.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.wipro.sfh.dto.ProductDTO;
import com.wipro.sfh.entity.Product;



public interface IProductService {
	
	public Product addProduct(ProductDTO productDTO);

	public List<Product> getAllProduct();
	
	Page<Product> getProductPage(int page);

	public Product getProductById(long id);

	public Product updateProduct(ProductDTO productDTO);

	public void deleteProduct(long id);
}
