package com.onlineshop.E_Commerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onlineshop.E_Commerce.model.Product;

public interface ProductRepo extends JpaRepository<Product, Integer> {

}
