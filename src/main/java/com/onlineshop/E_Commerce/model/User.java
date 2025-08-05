package com.onlineshop.E_Commerce.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(nullable = false, length = 45)
	private String name;

	@Column(unique = true, length = 50, nullable = false)
	private String email;

	@Column(unique = true, length = 10, nullable = false)
	private String phone;

	@Column(length = 12)
	private String gender;

	@Column(length = 10)
	private String dob;

	private double walletBalance = 0.0;

	@Column(length = 30, nullable = false)
	private String password;

	private boolean isBlocked = false;

	private boolean unblockRequested = false;

	@Column(length = 255)
	private String unblockMessage;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Address> address;

	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	private Image userImage;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Order> orders;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<WalletTransaction> transactions;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<CartItem> cartItems;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<ProductReview> productReviews;

	// Getter for isBlocked
	public boolean getIsBlocked() {
		return this.isBlocked;
	}

	// Setter for isBlocked
	public void setIsBlocked(boolean isBlocked) {
		this.isBlocked = isBlocked;
	}

	// Getter for unblockRequested
	public boolean getUnblockRequested() {
		return this.unblockRequested;
	}

	// Setter for unblockRequested
	public void setUnblockRequested(boolean unblockRequested) {
		this.unblockRequested = unblockRequested;
	}

}
