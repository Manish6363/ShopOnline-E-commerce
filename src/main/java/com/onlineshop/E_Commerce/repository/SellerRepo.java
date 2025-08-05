package com.onlineshop.E_Commerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onlineshop.E_Commerce.model.Seller;

public interface SellerRepo extends JpaRepository<Seller, Integer> {

	public Seller findByEmail(String email);

	public List<Seller> findAllByOrderByIsApprovedAsc();

}
