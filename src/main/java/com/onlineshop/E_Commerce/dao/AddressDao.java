package com.onlineshop.E_Commerce.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.onlineshop.E_Commerce.model.Address;
import com.onlineshop.E_Commerce.repository.AddressRepo;

@Repository
public class AddressDao {
	@Autowired
	private AddressRepo addRepo;

	public Address setAddress(Address add) {
		return addRepo.save(add);
	}

	public void deleteAddress(int id) {
		addRepo.deleteById(id);
	}
}
