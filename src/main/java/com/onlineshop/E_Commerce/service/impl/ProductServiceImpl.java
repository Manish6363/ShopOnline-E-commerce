package com.onlineshop.E_Commerce.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineshop.E_Commerce.dao.ProductDao;
import com.onlineshop.E_Commerce.model.Product;
import com.onlineshop.E_Commerce.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductDao dao;

	@Override
	public Product saveProduct(Product product) {
		return dao.save(product);
	}
	
	@Override
	public List<Product> findAllProduct() {
		return dao.getAllProduct();
	}

	@Override
	public Product getById(int id) {
		return dao.findById(id);
	}

}
