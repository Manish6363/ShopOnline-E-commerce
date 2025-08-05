package com.onlineshop.E_Commerce.model;

import org.springframework.stereotype.Component;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Component
public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;
	
	@Column(nullable = false, unique = true, length = 45)
	private String email;

	@Column(nullable = false, length = 30)
	private String password;
	
	@OneToOne(mappedBy = "admin", cascade = CascadeType.ALL, orphanRemoval = true)
	private Image adminImage;
}
