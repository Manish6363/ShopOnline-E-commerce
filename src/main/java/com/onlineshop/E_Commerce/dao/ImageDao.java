package com.onlineshop.E_Commerce.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.onlineshop.E_Commerce.model.Image;
import com.onlineshop.E_Commerce.repository.ImageRepo;

@Repository
public class ImageDao {
	@Autowired
	private ImageRepo repo;

	public Image saveImage(Image image) {
		return repo.save(image);
	}
}
