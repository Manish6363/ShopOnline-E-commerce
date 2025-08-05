package com.onlineshop.E_Commerce.service;

public interface MailSenderService {

	public Integer generateRegOTPCode(String email, String subject);

	public Integer generateOtpCodeForgetPass(String email, String subject);

	public void generateSuccessMail(String name, String email, String password, String subject);

	public void generateSellerRegistrationMail(String name, String email, String subject);

	public void generateSellerApprovalMail(String name, String email, String password, String subject);
}
