package com.onlineshop.E_Commerce.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.onlineshop.E_Commerce.model.Image;
import com.onlineshop.E_Commerce.model.Product;
import com.onlineshop.E_Commerce.model.Seller;
import com.onlineshop.E_Commerce.model.User;
import com.onlineshop.E_Commerce.model.Address;
import com.onlineshop.E_Commerce.model.Admin;
import com.onlineshop.E_Commerce.service.ImageService;
import com.onlineshop.E_Commerce.service.MailSenderService;
import com.onlineshop.E_Commerce.service.ProductService;
import com.onlineshop.E_Commerce.service.SellerService;
import com.onlineshop.E_Commerce.service.AddressService;
import com.onlineshop.E_Commerce.service.AdminService;
import com.onlineshop.E_Commerce.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {

	@Autowired
	private MailSenderService mailService;

	@Autowired
	private UserService userService;

	@Autowired
	private AddressService addService;

	@Autowired
	private SellerService sellerService;

	@Autowired
	private AdminService adminService;

	@Autowired
	private ProductService productService;

	@Autowired
	private ImageService imgService;

	@GetMapping("/")
	public String indexPage(HttpServletRequest req) {
		List<Product> allProducts = productService.findAllProduct();
		HttpSession session = req.getSession();
		session.setAttribute("products", allProducts);
		return "index";
	}

	@GetMapping({ "/userRegisterPage", "/sellerRegisterPage" })
	public String registrationPage(@RequestParam String role, HttpServletRequest req) {
		req.setAttribute("role", role);
		return "registration";
	}

	@GetMapping("/productPage")
	public String productPage() {
		return "product";
	}

	@GetMapping("/addProductPage")
	public String addProductPage() {
		return "addProduct";
	}

	@GetMapping("/dashboardPage")
	public String dashboardPage(Model m) {
		List<Seller> sellers = sellerService.fetchAllSeller();
		List<User> users = userService.fetchAllUser();
		m.addAttribute("sellerCount", sellers.size());
		m.addAttribute("userCount", users.size());
		return "admin_dashboard";
	}

	@GetMapping("/shopkeepersPage")
	public String shopkeepersPage(@RequestParam String role, Model m) {
		List<Seller> shops = sellerService.fetchAllByOrderByIsApprovedAsc();
		m.addAttribute("shops", shops);
		m.addAttribute("role", role);
		return "admin_shopkeepers";
	}

	@PostMapping("/addProductData")
	public String addProductData(@ModelAttribute Product product, @RequestParam String sellerEmail,
			@RequestParam MultipartFile imageFile, Model model) {
		Seller seller = sellerService.fetchSellerByEmail(sellerEmail);
		product.setSeller(seller);
		Product saveProduct = productService.saveProduct(product);
		if (imageFile != null && !imageFile.isEmpty()) {
			try {
				byte[] bytes = imageFile.getBytes();
				Image img = new Image();
				img.setName(imageFile.getOriginalFilename());
				img.setImage(bytes);
				img.setProduct(saveProduct); // associate with product
				// Image is saved to database
				imgService.setImage(img);
				product.setProductImage(img);
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		List<Product> productList = seller.getProducts();
		if (productList == null) {
			productList = new ArrayList<Product>();
		}
		productList.add(product);
		seller.setProducts(productList);
		sellerService.saveSellerData(seller);
		return "index"; // redirect or JSP page
	}

	@GetMapping("/usersPage")
	public String usersPage(@RequestParam String role, Model m) {
		List<User> users = userService.fetchAllUser();
		m.addAttribute("users", users);
		m.addAttribute("role", role);
		return "admin_users";
	}

	@GetMapping("/shopDetailsPage")
	public String shopDetailsPage(@RequestParam String email, @RequestParam String role, Model m) {
		Seller s = sellerService.fetchSellerByEmail(email);
		m.addAttribute("seller", s);
		m.addAttribute("role", role);
		return "shopDetails";
	}

	@GetMapping("/approveShopPage")
	public String approveShopPage(@RequestParam String email, Model m) {
		Seller s = sellerService.fetchSellerByEmail(email);
		boolean approve = true;
		s.setIsApproved(approve);
		sellerService.saveSellerData(s);
		String pass = new String(Base64.getDecoder().decode(s.getPassword()));
		mailService.generateSellerApprovalMail(s.getShopName() + "-" + s.getSellerName(), email, pass, "Congrats💐");
		List<Seller> shops = sellerService.fetchAllByOrderByIsApprovedAsc();
		m.addAttribute("shops", shops);
		return "admin_shopkeepers";
	}

	@GetMapping({ "/blockUserPage", "/blockSellerPage" })
	public String blockSellerPage(@RequestParam String email, @RequestParam String role, Model m) {
		m.addAttribute("role", role);
		if (role.equalsIgnoreCase("User")) {
			User user = userService.fetchUserByEmail(email);
			user.setIsBlocked(true);
			User u = userService.saveUserData(user);
			List<User> users = userService.fetchAllUser();
			m.addAttribute("users", users);
			m.addAttribute("role", role);
			return "admin_users";
		} else {
			Seller seller = sellerService.fetchSellerByEmail(email);
			seller.setIsBlocked(true);
			Seller s = sellerService.saveSellerData(seller);
			m.addAttribute("seller", s);
			return "shopDetails";
		}

	}

	@GetMapping({ "/unblockUserPage", "/unblockSellerPage" })
	public String unblockSellerPage(@RequestParam String email, @RequestParam String role, Model m) {
		m.addAttribute("role", role);
		if (role.equalsIgnoreCase("User")) {
			User user = userService.fetchUserByEmail(email);
			user.setIsBlocked(false);
			user.setUnblockRequested(false);
			user.setUnblockMessage(null);
			userService.saveUserData(user);
			List<User> users = userService.fetchAllUser();
			m.addAttribute("users", users);
			m.addAttribute("role", role);
			return "admin_users";
		} else {
			Seller seller = sellerService.fetchSellerByEmail(email);
			seller.setIsBlocked(false);
			seller.setUnblockRequested(false);
			seller.setUnblockMessage(null);
			Seller s = sellerService.saveSellerData(seller);
			m.addAttribute("seller", s);
		}
		return "shopDetails";
	}

	@PostMapping({ "/UserUnblockRequest", "/SellerUnblockRequest" })
	public String submitRequestPage(@RequestParam String email, @RequestParam String role,
			@RequestParam String unblockMessage, Model m) {
		if (role.equalsIgnoreCase("User")) {
			User u = userService.fetchUserByEmail(email);
			u.setUnblockRequested(true);
			u.setUnblockMessage(unblockMessage);
			userService.saveUserData(u);
		} else {
			Seller s = sellerService.fetchSellerByEmail(email);
			s.setUnblockRequested(true);
			s.setUnblockMessage(unblockMessage);
			sellerService.saveSellerData(s);
		}
		return "index";
	}

	@GetMapping("/forgetPassPage")
	public String forgetPassPage(@RequestParam String role, HttpServletRequest req) {
		req.setAttribute("role", role);
		return "forgetPassword";
	}

	@GetMapping({ "/userLogin", "/adminLogin", "/sellerLogin" })
	public String loginPage(Model m, HttpServletRequest request) {
		String path = request.getRequestURI();
		if (path.contains("admin")) {
			m.addAttribute("role", "Admin");
		} else if (path.contains("user")) {
			m.addAttribute("role", "User");
		} else {
			m.addAttribute("role", "Seller");
		}
		return "login";
	}

	@PostMapping({ "/UserSendOTP", "/SellerSendOTP" })
	public String sendOtpGeneration(@RequestParam String email, @RequestParam String subject, @RequestParam String role,
			Model m) {
		User user = null;
		Seller seller = null;

		if (role.equalsIgnoreCase("User")) {
			user = userService.fetchUserByEmail(email);
		} else {
			seller = sellerService.fetchSellerByEmail(email);
		}
		m.addAttribute("role", role);

		if (user != null || seller != null) {
			m.addAttribute("emailMsg", "Oh! Already registered.");
			return "registration";
		} else {
			Integer otp = mailService.generateRegOTPCode(email, subject);
			m.addAttribute("email", email);
			m.addAttribute("otp", otp);
			return "registration";
		}
	}

	@PostMapping("/User-Registration")
	public String registerUser(@ModelAttribute User u, @RequestParam String role, Model m) {
		String pass = Base64.getEncoder().encodeToString(u.getPassword().getBytes());
		mailService.generateSuccessMail(u.getName(), u.getEmail(), u.getPassword(), "User Registration Success");
		m.addAttribute("password", u.getPassword());
		u.setPassword(pass);
		userService.saveUserData(u);
		m.addAttribute("names", u.getName());
		m.addAttribute("email", u.getEmail());
		m.addAttribute("role", role);
		return "congratulation";
	}

	@PostMapping("/Seller-Registration")
	public String registerSeller(@ModelAttribute Seller s, @RequestParam String role, Model m) {
		String pass = Base64.getEncoder().encodeToString(s.getPassword().getBytes());
		m.addAttribute("password", s.getPassword());
		s.setPassword(pass);
		sellerService.saveSellerData(s);
		mailService.generateSellerRegistrationMail(s.getShopName() + "-" + s.getSellerName().split(" ")[0],
				s.getEmail(), "Seller Registration Success");
		m.addAttribute("names", s.getShopName() + "-" + s.getSellerName().split(" ")[0]);
		m.addAttribute("email", s.getEmail());
		m.addAttribute("role", role);
		return "congratulation";
	}
	
	@GetMapping("/fetchProductImage")
	public void loadProductImage(@RequestParam int id, HttpServletResponse resp) {
		try {
			Product product = productService.getById(id);
			byte[] imageData=product.getProductImage().getImage();
			resp.setContentType("image/jpeg");
			resp.getOutputStream().write(imageData);
			resp.getOutputStream().flush();
		} catch (Exception e) {
			resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}
	}

	@GetMapping({ "/fetchUserImage", "/fetchSellerImage", "/fetchAdminImage" })
	public void loadImage(@RequestParam String email, @RequestParam String role, HttpServletResponse resp) {
		try {
			byte[] imageData;
			if (role.equalsIgnoreCase("User")) {
				User user = userService.fetchUserByEmail(email);
				imageData = (user != null && user.getUserImage() != null) ? user.getUserImage().getImage()
						: getDefaultImage();
			} else if (role.equalsIgnoreCase("Seller")) {
				Seller seller = sellerService.fetchSellerByEmail(email);
				imageData = (seller != null && seller.getSellerImage() != null) ? seller.getSellerImage().getImage()
						: getDefaultImage();
			} else {
				Admin admin = adminService.fetchAdminByEmail(email);
				imageData = (admin != null && admin.getAdminImage() != null) ? admin.getAdminImage().getImage()
						: getDefaultImage();
			}

			resp.setContentType("image/jpeg");
			resp.getOutputStream().write(imageData);
			resp.getOutputStream().flush();
		} catch (IOException e) {
			resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}
	}

	private byte[] getDefaultImage() throws IOException {
		ClassPathResource imgFile = new ClassPathResource("static/image/pic.jpg");
		return Files.readAllBytes(imgFile.getFile().toPath());
	}

	@PostMapping({ "/User-forget-pass", "/Seller-forget-pass" })
	public String forgetPass(@RequestParam String email, @RequestParam String role, @RequestParam String password,
			HttpServletRequest req) {
		String pass = Base64.getEncoder().encodeToString(password.getBytes());
		if (role.equalsIgnoreCase("User")) {
			User user = userService.fetchUserByEmail(email);
			if (user != null) {
				user.setPassword(pass);
				userService.saveUserData(user);
			}
		} else {
			Seller seller = sellerService.fetchSellerByEmail(email);
			if (seller != null) {
				seller.setPassword(pass);
				sellerService.saveSellerData(seller);
			}
		}
		req.setAttribute("role", role);
		return "index";
	}

	@PostMapping({ "/changeUserPicture", "/changeSellerPicture" })
	public String changePhoto(@RequestParam String email, @RequestParam String role, @RequestPart MultipartFile image) {
		if (image != null && !image.isEmpty()) {
			try {
				byte[] bytes = image.getBytes();
				Image img = new Image();
				img.setImage(bytes);

				if (role.equalsIgnoreCase("User")) {
					User user = userService.fetchUserByEmail(email);
					if (user != null) {
						img.setName(user.getName() + "-Photo");
						img.setUser(user);
						imgService.setImage(img);
						user.setUserImage(img);
						userService.saveUserData(user);
					}
				} else {
					Seller seller = sellerService.fetchSellerByEmail(email);
					if (seller != null) {
						img.setName(seller.getShopName() + "-Photo");
						img.setSeller(seller);
						imgService.setImage(img);
						seller.setSellerImage(img);
						sellerService.saveSellerData(seller);
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return "index";
	}

	@PostMapping({ "/addUserAddress", "/addSellerAddress" })
	public String addAddress(@RequestParam String email, @RequestParam String role, @ModelAttribute Address address,
			Model m, HttpServletRequest req) {
		m.addAttribute("role", role);
		req.getSession().removeAttribute("address");
		if (role.equalsIgnoreCase("User")) {
			User user = userService.fetchUserByEmail(email);
			if (user != null) {
				address.setUser(user);
				addService.saveAddress(address);
				List<Address> existing = user.getAddress();
				if (existing == null) {
					existing = new ArrayList<>();
				}
				existing.add(address);
				user.setAddress(existing);
				userService.saveUserData(user);
				req.getSession().setAttribute("address", user.getAddress());
			}
		} else {
			Seller seller = sellerService.fetchSellerByEmail(email);
			if (seller != null) {
				address.setSeller(seller);
				addService.saveAddress(address);
				seller.setShopAddress(address);
				sellerService.saveSellerData(seller);
				req.getSession().setAttribute("address", seller.getShopAddress());
			}
		}
		return "index";
	}

	@GetMapping("/removeUserAddress")
	public String removeUserAddress(@RequestParam int id, @RequestParam String email, HttpServletRequest req) {
		addService.deleteAddressById(id);
		User user = userService.fetchUserByEmail(email);
		req.getSession().setAttribute("address", user.getAddress());
		return "index";
	}

	@PostMapping("/admin-sign-in")
	public String adminSignin(@RequestParam String role, @RequestParam String email, @RequestParam String password,
			HttpServletRequest req) {
		System.out.println(email + "======" + password);
		if (!email.equals("mk84661@gmail.com")) {
			req.setAttribute("emailMsg", "Given email is not registered or invalid!");
			req.setAttribute("role", role);
			return "login";
		} else {
			System.out.println("Else cond..");
			if (password.equals("123")) {
				System.out.println("Admin success");
				req.getSession().setAttribute("sessionEmail", email);
				req.getSession().setAttribute("name", "Man");
				req.getSession().setAttribute("role", role);
				List<Seller> sellers = sellerService.fetchAllSeller();
				List<User> users = userService.fetchAllUser();
				req.setAttribute("sellerCount", sellers.size());
				req.setAttribute("userCount", users.size());
				return "admin_dashboard";
			} else {
				req.setAttribute("passMsg", "Password is Incorrect!");
				req.setAttribute("role", role);
				return "login";
			}
		}
	}

	@PostMapping({ "/user-sign-in", "/seller-sign-in" })
	public String signin(@RequestParam String role, @RequestParam String email, @RequestParam String password,
			HttpServletRequest req) {
		User user = null;
		Seller seller = null;
		if (role.equalsIgnoreCase("User")) {
			user = userService.fetchUserByEmail(email);
		} else {
			seller = sellerService.fetchSellerByEmail(email);
		}

		if ((role.equalsIgnoreCase("User") && user == null) || (role.equalsIgnoreCase("Seller") && seller == null)) {
			req.setAttribute("emailMsg", "Given email is not registered or invalid!");
			req.setAttribute("role", role);
			return "login";
		} else {
			String storedPass = role.equalsIgnoreCase("User") ? user.getPassword() : seller.getPassword();
			String decodedPass = new String(Base64.getDecoder().decode(storedPass));

			if (password.equals(decodedPass)) {
				if (role != null && role.equalsIgnoreCase("Seller") && !seller.getIsApproved()) {
					req.setAttribute("email", email);
					String name = role.equalsIgnoreCase("User") ? user.getName()
							: (seller.getShopName() + "-" + seller.getSellerName().split(" ")[0]);
					req.setAttribute("names", name);
					req.setAttribute("role", role);
					req.setAttribute("msg", "Not Approved");
					return "blockedPage";
				}
				if ((user != null && user.getIsBlocked()) || (seller != null && seller.getIsBlocked())) {
					req.setAttribute("email", email);
					String name = role.equalsIgnoreCase("User") ? user.getName()
							: (seller.getShopName() + "-" + seller.getSellerName().split(" ")[0]);
					req.setAttribute("names", name);
					req.setAttribute("role", role);
					req.setAttribute("msg", "Blocked due to violating the Company Standards");
					return "blockedPage";
				} else {
					req.getSession().setAttribute("sessionEmail", email);
					String name = role.equalsIgnoreCase("User") ? user.getName()
							: (seller.getShopName() + "-" + seller.getSellerName().split(" ")[0]);
					req.getSession().setAttribute("name", name);
					req.getSession().setAttribute("address",
							role.equalsIgnoreCase("User") ? user.getAddress() : seller.getShopAddress());
					req.getSession().setAttribute("role", role);
					return "index";
				}
			} else {
				req.setAttribute("passMsg", "Password is Incorrect!");
				req.setAttribute("role", role);
				return "login";
			}
		}

	}

	@PostMapping({ "/UserSendOtpToForgetPass", "/SellerSendOtpToForgetPass" })
	public String otpGenerationToForgetPass(@RequestParam String subject, @RequestParam String role,
			@RequestParam String email, Model m) {
		User user = null;
		Seller seller = null;

		if (role.equalsIgnoreCase("User")) {
			user = userService.fetchUserByEmail(email);
		} else {
			seller = sellerService.fetchSellerByEmail(email);
		}

		m.addAttribute("role", role);

		if ((role.equalsIgnoreCase("User") && user == null) || (role.equalsIgnoreCase("Seller") && seller == null)) {
			m.addAttribute("emailMsg", "You have not an account.");
			return "forgetPassword";
		} else {
			Integer otp = mailService.generateOtpCodeForgetPass(email, subject);
			m.addAttribute("email", email);
			m.addAttribute("otp", otp);
			return "forgetPassword";
		}
	}

	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return "index";
	}
}
