package com.onlineshop.E_Commerce.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;
	private double actualPrice;
	private int quantity;
	private String category;
	private String description;
	private double discountPercentage; // example: 10 for 10%

	@ManyToOne
	@JoinColumn(name = "seller_id")
	private Seller seller;

	@OneToOne(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
	private Image productImage;

	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<ProductReview> reviews;

	public double getFinalPrice() {
		return actualPrice - (actualPrice * discountPercentage / 100);
	}
}
