package com.onlineshop.E_Commerce.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineshop.E_Commerce.dao.AddressDao;
import com.onlineshop.E_Commerce.model.Address;
import com.onlineshop.E_Commerce.service.AddressService;

@Service
public class AddressServiceImpl implements AddressService {
	@Autowired
	private AddressDao addDao;

	@Override
	public Address saveAddress(Address add) {
		return addDao.setAddress(add);
	}

	@Override
	public void deleteAddressById(int id) {
		addDao.deleteAddress(id);
	}

}
