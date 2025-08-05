package com.onlineshop.E_Commerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.onlineshop.E_Commerce.model.CartItem;

public interface CartItemRepo extends JpaRepository<CartItem, Integer> {

}
