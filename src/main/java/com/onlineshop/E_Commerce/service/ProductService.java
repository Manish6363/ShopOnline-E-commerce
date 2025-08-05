package com.onlineshop.E_Commerce.service;

import java.util.List;

import com.onlineshop.E_Commerce.model.Product;

public interface ProductService {

	public Product saveProduct(Product product);
	
	public List<Product> findAllProduct();

	public Product getById(int id);

}
