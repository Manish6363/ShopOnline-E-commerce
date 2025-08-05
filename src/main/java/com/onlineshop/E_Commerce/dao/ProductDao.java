package com.onlineshop.E_Commerce.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.onlineshop.E_Commerce.model.Product;
import com.onlineshop.E_Commerce.repository.ProductRepo;

@Repository
public class ProductDao {
	@Autowired
	private ProductRepo repo;

	public Product save(Product product) {
		return repo.save(product);
	}

	public List<Product> getAllProduct() {
		return repo.findAll();
	}

	public Product findById(int id) {
		return repo.getById(id);
	}

}
