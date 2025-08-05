package com.onlineshop.E_Commerce.exception;

public class UserNotExistsException extends RuntimeException {
	public UserNotExistsException(String message) {
		super(message);
	}
}
