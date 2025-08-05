package com.onlineshop.E_Commerce.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.onlineshop.E_Commerce.model.User;
import com.onlineshop.E_Commerce.repository.UserRepo;

@Repository
public class UserDao {
	@Autowired
	private UserRepo userRepo;

	public User insertRegistrationData(User user) {
		return userRepo.save(user);
	}

	public User getUserByEmail(String email) {
		return userRepo.findByEmail(email);
	}

	public List<User> getAllUser() {
		return userRepo.findAll();
	}

}
