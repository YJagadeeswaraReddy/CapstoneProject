package com.wipro.sfh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.wipro.sfh.dto.ProductDTO;
import com.wipro.sfh.entity.Product;
import com.wipro.sfh.repository.ProductRepository;
import com.wipro.sfh.service.IProductService;

@Service
public class ProductServiceImpl implements IProductService {

	
	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public Product addProduct(ProductDTO product) {
		Product newProduct = new Product();
		
		newProduct.setId(product.getId());
		newProduct.setProductName(product.getProductName());
		newProduct.setProductPrice(product.getProductPrice());
		newProduct.setProductStock(product.getProductStock());
		newProduct.setProductDescription(product.getProductDescription());
		newProduct.setCategory(product.getCategory());
		
		return productRepository.save(newProduct);

	}

	@Override
	public List<Product> getAllProduct() {
		return productRepository.findAll();
	}

	@Override
	public Page<Product> getProductPage(int page) {
		return productRepository.findAll(PageRequest.of(page, 4));
	}
	
	@Override
	public Product getProductById(long id) {
		return productRepository.findById(id).orElse(new Product());
	}

	@Override
	public Product updateProduct(ProductDTO product) {
		
		Product updateProduct = getProductById(product.getId());
		
		updateProduct.setId(product.getId());
		updateProduct.setProductName(product.getProductName());
		updateProduct.setProductPrice(product.getProductPrice());
		updateProduct.setProductStock(product.getProductStock());
		updateProduct.setProductDescription(product.getProductDescription());
		updateProduct.setCategory(product.getCategory());
		
		return productRepository.save(updateProduct);
		
	}

	@Override
	public void deleteProduct(long id) {
		productRepository.deleteById(id);
	}

	

}
