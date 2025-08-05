package com.onlineshop.E_Commerce.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineshop.E_Commerce.dao.UserDao;
import com.onlineshop.E_Commerce.model.User;
import com.onlineshop.E_Commerce.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;

	public User fetchUserByEmail(String email) {
		return userDao.getUserByEmail(email);
	}

	public User saveUserData(User user) {
		return userDao.insertRegistrationData(user);
	}

	@Override
	public List<User> fetchAllUser() {
		return userDao.getAllUser();
	}
}
