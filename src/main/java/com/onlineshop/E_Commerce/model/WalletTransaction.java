package com.onlineshop.E_Commerce.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
public class WalletTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private LocalDateTime transactionDate;
    private String description;
    private double amount;

    @Enumerated(EnumType.STRING)
    private TransactionType type; // CREDIT or DEBIT

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @PrePersist
    public void onCreate() {
        transactionDate = LocalDateTime.now();
    }
}
