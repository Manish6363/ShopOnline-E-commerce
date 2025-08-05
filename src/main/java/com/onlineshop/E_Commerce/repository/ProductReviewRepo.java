package com.onlineshop.E_Commerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onlineshop.E_Commerce.model.ProductReview;

public interface ProductReviewRepo extends JpaRepository<ProductReview, Integer> {

}
