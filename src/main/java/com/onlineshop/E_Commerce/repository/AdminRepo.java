package com.onlineshop.E_Commerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onlineshop.E_Commerce.model.Admin;

public interface AdminRepo extends JpaRepository<Admin, Integer> {

	public Admin findByEmail(String email);
}
