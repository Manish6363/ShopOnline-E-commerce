package com.onlineshop.E_Commerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onlineshop.E_Commerce.model.User;

public interface UserRepo extends JpaRepository<User, Integer> {

	public User findByEmail(String email);

}
