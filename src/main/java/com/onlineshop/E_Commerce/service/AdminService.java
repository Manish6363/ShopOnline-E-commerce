package com.onlineshop.E_Commerce.service;

import com.onlineshop.E_Commerce.model.Admin;

public interface AdminService {
	public Admin fetchAdminByEmail(String email);

	public Admin saveAdminData(Admin user);
}
