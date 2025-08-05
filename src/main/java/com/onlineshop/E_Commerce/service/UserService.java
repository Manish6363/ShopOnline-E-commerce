package com.onlineshop.E_Commerce.service;

import java.util.List;

import com.onlineshop.E_Commerce.model.User;

public interface UserService {
	public User fetchUserByEmail(String email);

	public User saveUserData(User user);

	public List<User> fetchAllUser();
}
