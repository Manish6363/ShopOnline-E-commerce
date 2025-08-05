package com.onlineshop.E_Commerce.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineshop.E_Commerce.dao.ImageDao;
import com.onlineshop.E_Commerce.model.Image;
import com.onlineshop.E_Commerce.service.ImageService;

@Service
public class ImageServiceImpl implements ImageService {

	@Autowired
	private ImageDao dao;
	
	@Override
	public Image setImage(Image image) {
		return dao.saveImage(image);
	}

}
