package com.onlineshop.E_Commerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onlineshop.E_Commerce.model.Address;

public interface AddressRepo extends JpaRepository<Address, Integer> {
	
}
