package com.onlineshop.E_Commerce.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineshop.E_Commerce.dao.SellerDao;
import com.onlineshop.E_Commerce.model.Seller;
import com.onlineshop.E_Commerce.service.SellerService;

@Service
public class SellerServiceImpl implements SellerService {

	@Autowired
	private SellerDao dao;

	@Override
	public Seller fetchSellerByEmail(String email) {
		return dao.getSellerByEmail(email);
	}

	@Override
	public Seller saveSellerData(Seller seller) {
		return dao.insertSellerRegistrationData(seller);
	}
	
	@Override
	public List<Seller> fetchAllSeller() {
		return dao.getAllSeller();
	}

	@Override
	public List<Seller> fetchAllByOrderByIsApprovedAsc() {
		return dao.getAllByOrderByIsApprovedAsc();
	}

}
