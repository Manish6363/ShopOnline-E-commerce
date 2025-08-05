package com.onlineshop.E_Commerce.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineshop.E_Commerce.dao.AdminDao;
import com.onlineshop.E_Commerce.model.Admin;
import com.onlineshop.E_Commerce.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminDao adminDao;

	public Admin fetchAdminByEmail(String email) {
		return adminDao.getAdminByEmail(email);
	}

	public Admin saveAdminData(Admin admin) {
		return adminDao.insertRegistrationData(admin);
	}

}
