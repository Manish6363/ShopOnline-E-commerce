package com.onlineshop.E_Commerce.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.onlineshop.E_Commerce.service.MailSenderService;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

@Service
public class MailSenderServiceImpl implements MailSenderService {
	@Autowired
	private JavaMailSender sender;

	public Integer generateRegOTPCode(String email, String subject) {
		int otp = (int) (Math.random() * 1000000); // Generates a number from 0 to 999999
		String otpCode = String.format("%06d", otp); // Pads with leading zeros if necessary
		MimeMessage message = sender.createMimeMessage();
		try {
			message.setFrom(new InternetAddress("mk84661@gmail.com"));
			message.setRecipients(MimeMessage.RecipientType.TO, email);
			message.setSubject("OTP Verification - " + subject);

			String htmlContent = "<div style='font-family: Arial, sans-serif; background-color: #f4f4f4; padding: 20px;'>"
					+ "<div style='max-width: 600px; margin: auto; background-color: #ffffff; border-radius: 8px; box-shadow: 0 0 10px rgba(0,0,0,0.1); padding: 20px;'>"
					+ "<div style='display: flex; align-items: center; gap: 10px; margin-bottom: 20px;'>"
					+ "<span style='font-size: 28px; color: #7cfc00;'>🚚</span>" + "<div>"
					+ "<div style='font-size: 24px; font-weight: bold; color: #7cfc00;'>ShopOnline</div>"
					+ "<div style='font-size: 14px; font-style: italic; color: orange;'>EXPLORE MORE</div>"
					+ "</div></div>" + "<h2 style='color: #0d47a1;'>Welcome to ShopOnline!</h2>"
					+ "<p style='color: #212121;'>Thank you for registering with us. To complete your registration, please use the following One-Time Password (OTP):</p>"
					+ "<div style='text-align: center; margin: 30px 0;'>"
					+ "<span style='display: inline-block; font-size: 32px; font-weight: bold; background-color: #e0f7fa; color: #0d47a1; padding: 10px 20px; border-radius: 6px;'>"
					+ otpCode + "</span></div>"
					+ "<p style='color: #555;'>This OTP is valid for 10 minutes. Please do not share it with anyone.</p>"
					+ "<p style='margin-top: 30px; color: #999;'>If you did not initiate this request, please ignore this email.</p>"
					+ "<div style='margin-top: 20px; font-size: 12px; color: #aaa;'>© 2025 ShopOnline. All rights reserved.</div>"
					+ "</div></div>";

			message.setContent(htmlContent, "text/html; charset=utf-8");
			sender.send(message);
			return Integer.parseInt(otpCode);
		} catch (MessagingException e) {
			e.printStackTrace();
			return 0;
		}
	}

	public void generateSuccessMail(String name, String email, String password, String subject) {
		MimeMessage message = sender.createMimeMessage();
		try {
			message.setFrom(new InternetAddress("mk84661@gmail.com"));
			message.setRecipients(MimeMessage.RecipientType.TO, email);
			message.setSubject(subject + " - Registration Successful");

			String htmlContent = "<div style='font-family: Arial, sans-serif; background-color: #f4f4f4; padding: 20px;'>"
					+ "<div style='max-width: 600px; margin: auto; background-color: #ffffff; border-radius: 8px; box-shadow: 0 0 10px rgba(0,0,0,0.1); padding: 20px;'>"
					+ "<div style='display: flex; align-items: center; gap: 10px; margin-bottom: 20px;'>"
					+ "<span style='font-size: 28px; color: #7cfc00;'>🚚</span>" + "<div>"
					+ "<div style='font-size: 24px; font-weight: bold; color: #7cfc00;'>ShopOnline</div>"
					+ "<div style='font-size: 14px; font-style: italic; color: orange;'>EXPLORE MORE</div>"
					+ "</div></div>" + "<h2 style='color: #0d47a1;'>Registration Successful!</h2>"
					+ "<p style='color: #212121;'>Hello <strong>" + name + "</strong>,</p>"
					+ "<p style='color: #212121;'>Your account has been successfully created with ShopOnline.</p>"
					+ "<div style='margin: 20px 0; padding: 15px; background-color: #e0f7fa; border-radius: 6px;'>"
					+ "<p style='margin: 5px 0;'><strong>Email:</strong> " + email + "</p>"
					+ "<p style='margin: 5px 0;'><strong>Password:</strong> " + password + "</p>" + "</div>"
					+ "<p style='color: #555;'>You can now log in and enjoy shopping with us!</p>"
					+ "<p style='margin-top: 30px; color: #999;'>If you have any issues, please contact our support team.</p>"
					+ "<div style='margin-top: 20px; font-size: 12px; color: #aaa;'>© 2025 ShopOnline. All rights reserved.</div>"
					+ "</div></div>";

			message.setContent(htmlContent, "text/html; charset=utf-8");
			sender.send(message);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Integer generateOtpCodeForgetPass(String email, String subject) {
		int otp = (int) (Math.random() * 1000000); // Generates a number from 0 to 999999
		String otpCode = String.format("%06d", otp); // Pads with leading zeros if necessary
		MimeMessage message = sender.createMimeMessage();

		try {
			message.setFrom(new InternetAddress("mk84661@gmail.com"));
			message.setRecipients(MimeMessage.RecipientType.TO, email);
			message.setSubject("OTP Verification - Forgot Password");

			String htmlContent = "<div style='font-family: Arial, sans-serif; background-color: #f4f4f4; padding: 20px;'>"
					+ "<div style='max-width: 600px; margin: auto; background-color: #ffffff; border-radius: 8px; box-shadow: 0 0 10px rgba(0,0,0,0.1); padding: 20px;'>"
					+ "<div style='display: flex; align-items: center; gap: 10px; margin-bottom: 20px;'>"
					+ "<span style='font-size: 28px; color: #7cfc00;'>🚚</span>"
					+ "<div><div style='font-size: 24px; font-weight: bold; color: #7cfc00;'>ShopOnline</div>"
					+ "<div style='font-size: 14px; font-style: italic; color: orange;'>EXPLORE MORE</div></div></div>"
					+ "<h2 style='color: #0d47a1;'>Password Reset Request</h2>"
					+ "<p style='color: #212121;'>You requested to reset your password. Please use the following One-Time Password (OTP) to proceed:</p>"
					+ "<div style='text-align: center; margin: 30px 0;'>"
					+ "<span style='display: inline-block; font-size: 32px; font-weight: bold; background-color: #e0f7fa; color: #0d47a1; padding: 10px 20px; border-radius: 6px;'>"
					+ otpCode + "</span></div>"
					+ "<p style='color: #555;'>This OTP is valid for 10 minutes. Do not share it with anyone.</p>"
					+ "<p style='margin-top: 30px; color: #999;'>If you did not initiate this request, please ignore this email.</p>"
					+ "<div style='margin-top: 20px; font-size: 12px; color: #aaa;'>© 2025 ShopOnline. All rights reserved.</div>"
					+ "</div></div>";

			message.setContent(htmlContent, "text/html; charset=utf-8");
			sender.send(message);
			return Integer.parseInt(otpCode);
		} catch (MessagingException e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public void generateSellerRegistrationMail(String name, String email, String subject) {
		MimeMessage message = sender.createMimeMessage();
		try {
			message.setFrom(new InternetAddress("mk84661@gmail.com"));
			message.setRecipients(MimeMessage.RecipientType.TO, email);
			message.setSubject(subject + " - Registration Received");

			String htmlContent = "<div style='font-family: Arial, sans-serif; background-color: #f9f9f9; padding: 20px;'>"
					+ "<div style='max-width: 600px; margin: auto; background-color: #ffffff; border-radius: 8px; "
					+ "box-shadow: 0 0 10px rgba(0,0,0,0.1); padding: 20px;'>"

					+ "<div style='display: flex; align-items: center; gap: 10px; margin-bottom: 20px;'>"
					+ "<span style='font-size: 28px; color: #7cfc00;'>🚚</span>" + "<div>"
					+ "<div style='font-size: 24px; font-weight: bold; color: #7cfc00;'>ShopOnline</div>"
					+ "<div style='font-size: 14px; font-style: italic; color: orange;'>EXPLORE MORE</div>"
					+ "</div></div>"

					+ "<h2 style='color: #0d47a1;'>Registration Submitted Successfully</h2>"
					+ "<p style='color: #212121;'>Hello <strong>" + name + "</strong>,</p>"
					+ "<p style='color: #212121;'>Thank you for registering as a shopkeeper on <strong>ShopOnline</strong>.</p>"
					+ "<p style='color: #212121;'>Your registration is currently under review by our admin team. "
					+ "You will be notified once your shop is approved.</p>"

					+ "<div style='margin: 20px 0; padding: 15px; background-color: #fff3cd; border-radius: 6px;'>"
					+ "<p style='margin: 5px 0; color: #856404;'><strong>Next Steps:</strong></p>"
					+ "<ul style='margin: 0; padding-left: 20px; color: #856404;'>"
					+ "<li>Admin will verify your shop details.</li>"
					+ "<li>You'll receive a confirmation email once approved.</li>"
					+ "<li>You can log in after your shop is verified.</li>" + "</ul>" + "</div>"

					+ "<p style='color: #555;'>If you have any questions, feel free to reach out to our support team.</p>"
					+ "<p style='margin-top: 30px; color: #999;'>Thank you for choosing ShopOnline!</p>"
					+ "<div style='margin-top: 20px; font-size: 12px; color: #aaa;'>© 2025 ShopOnline. All rights reserved.</div>"

					+ "</div></div>";

			message.setContent(htmlContent, "text/html; charset=utf-8");
			sender.send(message);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void generateSellerApprovalMail(String name, String email, String password, String subject) {
		MimeMessage message = sender.createMimeMessage();
		try {
			message.setFrom(new InternetAddress("mk84661@gmail.com"));
			message.setRecipients(MimeMessage.RecipientType.TO, email);
			message.setSubject(subject + " - Shop Verified & Approved");

			String htmlContent = "<div style='font-family: Arial, sans-serif; background-color: #f9f9f9; padding: 20px;'>"
					+ "<div style='max-width: 600px; margin: auto; background-color: #ffffff; border-radius: 8px; "
					+ "box-shadow: 0 0 10px rgba(0,0,0,0.1); padding: 20px;'>"

					+ "<div style='display: flex; align-items: center; gap: 10px; margin-bottom: 20px;'>"
					+ "<span style='font-size: 28px; color: #7cfc00;'>🚚</span>" + "<div>"
					+ "<div style='font-size: 24px; font-weight: bold; color: #7cfc00;'>ShopOnline</div>"
					+ "<div style='font-size: 14px; font-style: italic; color: orange;'>EXPLORE MORE</div>"
					+ "</div></div>"

					+ "<h2 style='color: #0d47a1;'>Your Shop is Now Verified!</h2>"
					+ "<p style='color: #212121;'>Hello <strong>" + name + "</strong>,</p>"
					+ "<p style='color: #212121;'>We’re happy to let you know that your shop registration has been <strong>approved</strong> by our admin team.</p>"

					+ "<div style='margin: 20px 0; padding: 15px; background-color: #e8f5e9; border-radius: 6px;'>"
					+ "<p style='margin: 5px 0;'><strong>Status:</strong> ✅ Approved</p>"
					+ "<p style='margin: 5px 0;'><strong>Email:</strong> " + email + "</p>"
					+ "<p style='margin: 5px 0'><strong>Password:</strong>" + password + "</p>" + "</div>"

					+ "<p style='color: #212121;'>You can now <a href='https://yourshopurl.com/login' style='color: #1e88e5; text-decoration: none;'>log in</a> and start managing your shop, products, and orders.</p>"

					+ "<p style='margin-top: 30px; color: #999;'>If you have any questions or need help, feel free to contact our support team.</p>"
					+ "<div style='margin-top: 20px; font-size: 12px; color: #aaa;'>© 2025 ShopOnline. All rights reserved.</div>"

					+ "</div></div>";

			message.setContent(htmlContent, "text/html; charset=utf-8");
			sender.send(message);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

}
