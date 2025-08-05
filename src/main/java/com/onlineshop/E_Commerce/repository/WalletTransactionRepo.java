package com.onlineshop.E_Commerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onlineshop.E_Commerce.model.WalletTransaction;

public interface WalletTransactionRepo extends JpaRepository<WalletTransaction, Integer> {

}
