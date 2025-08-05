package com.onlineshop.E_Commerce.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.onlineshop.E_Commerce.model.Admin;
import com.onlineshop.E_Commerce.repository.AdminRepo;

@Repository
public class AdminDao {
	@Autowired
	private AdminRepo adminRepo;

	public Admin insertRegistrationData(Admin admin) {
		return adminRepo.save(admin);
	}

	public Admin getAdminByEmail(String email) {
		return adminRepo.findByEmail(email);
	}
}
