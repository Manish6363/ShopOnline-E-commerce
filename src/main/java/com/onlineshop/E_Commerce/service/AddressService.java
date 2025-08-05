package com.onlineshop.E_Commerce.service;

import com.onlineshop.E_Commerce.model.Address;

public interface AddressService {
	public Address saveAddress(Address add);

	public void deleteAddressById(int id);
}
