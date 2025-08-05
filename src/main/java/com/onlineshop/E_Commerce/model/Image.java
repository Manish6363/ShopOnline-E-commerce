package com.onlineshop.E_Commerce.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Image {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;

	@Lob
	@Column(columnDefinition = "LONGBLOB")
	private byte[] image;

	@OneToOne
	@JoinColumn(name = "user_id")
	private User user;

	@OneToOne
	@JoinColumn(name = "seller_id")
	private Seller seller;
	
	@OneToOne
	@JoinColumn(name = "admin_id")
	private Admin admin;

	@OneToOne
	@JoinColumn(name = "product_id")
	private Product product;
}
