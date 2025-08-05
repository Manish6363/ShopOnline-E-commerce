package com.onlineshop.E_Commerce.service;

import java.util.List;

import com.onlineshop.E_Commerce.model.Seller;

public interface SellerService {

	public Seller fetchSellerByEmail(String email);

	public Seller saveSellerData(Seller seller);
	
	public List<Seller> fetchAllSeller();
	
	public List<Seller> fetchAllByOrderByIsApprovedAsc();
}
