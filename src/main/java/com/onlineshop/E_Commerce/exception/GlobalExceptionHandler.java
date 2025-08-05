package com.onlineshop.E_Commerce.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(InvalidUserDataException.class)
	public String handleInvalidUserDataException(InvalidUserDataException ex, Model model) {
		model.addAttribute("errorMessage", ex.getMessage());
		return "errorPage"; // errorPage.jsp
	}

	@ExceptionHandler(UserAlreadyExistsException.class)
	public String handleInvalidUserDataException(UserAlreadyExistsException ex, Model model) {
		model.addAttribute("errorMessage", ex.getMessage());
		return "errorPage"; // errorPage.jsp
	}
	@ExceptionHandler(UserNotExistsException.class)
	public String handleUserNotExistsException(UserNotExistsException ex, Model model) {
		model.addAttribute("errorMessage", ex.getMessage());
		return "errorPage"; // errorPage.jsp
	}
}
