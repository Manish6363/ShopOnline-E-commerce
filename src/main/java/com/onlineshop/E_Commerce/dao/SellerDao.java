package com.onlineshop.E_Commerce.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.onlineshop.E_Commerce.model.Seller;
import com.onlineshop.E_Commerce.repository.SellerRepo;

@Repository
public class SellerDao {
	@Autowired
	private SellerRepo sellerRepo;

	public Seller insertSellerRegistrationData(Seller seller) {
		return sellerRepo.save(seller);
	}

	public Seller getSellerByEmail(String email) {
		return sellerRepo.findByEmail(email);
	}

	public List<Seller> getAllByOrderByIsApprovedAsc() {
		return sellerRepo.findAllByOrderByIsApprovedAsc();
	}

	public List<Seller> getAllSeller() {
		return sellerRepo.findAll();
	}
}
