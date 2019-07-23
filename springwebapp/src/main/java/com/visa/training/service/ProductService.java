package com.visa.training.service;

import java.util.List;

import com.visa.training.domain.Product;

public interface ProductService {
	
	public int addNewProduct(Product p);
	public Product findById(int id);
	public List<Product> findAll();
	public void deleteProduct(int id);

}
