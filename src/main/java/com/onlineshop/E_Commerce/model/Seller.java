package com.onlineshop.E_Commerce.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import org.springframework.stereotype.Component;

@Data
@Entity
@NoArgsConstructor
@Component
public class Seller {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(nullable = false, length = 45)
	private String sellerName;

	@Column(unique = true, nullable = false, length = 20)
	private String gstNo;

	@Column(nullable = false, length = 45)
	private String shopName;

	@Column(unique = true, nullable = false, length = 50)
	private String email;

	@Column(nullable = false, length = 10)
	private String phone;

	private boolean isApproved = false;
	private boolean isBlocked = false;

	private boolean unblockRequested = false;

	@Column(length = 255)
	private String unblockMessage;

	@Column(length = 30, nullable = false)
	private String password;

	@OneToOne(mappedBy = "seller", cascade = CascadeType.ALL, orphanRemoval = true)
	private Address shopAddress;

	@OneToMany(mappedBy = "seller", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Product> products;

	@OneToOne(mappedBy = "seller", cascade = CascadeType.ALL, orphanRemoval = true)
	private Image sellerImage;

	// Getter for isBlocked
	public boolean getIsBlocked() {
		return this.isBlocked;
	}

	// Setter for isBlocked
	public void setIsBlocked(boolean isBlocked) {
		this.isBlocked = isBlocked;
	}

	// Getter for isApproved
	public boolean getIsApproved() {
		return this.isApproved;
	}

	// Setter for isApproved
	public void setIsApproved(boolean isApproved) {
		this.isApproved = isApproved;
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
