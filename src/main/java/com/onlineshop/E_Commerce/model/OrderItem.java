package com.onlineshop.E_Commerce.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class OrderItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String productName;

	private int quantity;

	private double price;

	@ManyToOne
	@JoinColumn(name = "order_id")
	private Order order;
}
