# ShopOnline – An E-Commerce Web Application
ShopOnline is a comprehensive e-commerce web application inspired by leading platforms such as Amazon, Flipkart, and Myntra. It is designed to provide a seamless online shopping experience to users, while also offering secure modules for sellers and administrators. The application features a robust navigation system with intuitive UI elements like search functionality, product categorization, and product highlights (e.g., top-rated and latest arrivals) on the homepage.

**The application is divided into three secure modules:**
  1. Admin Module
  2. Seller Module
  3. User Module

All modules are protected against unauthorized access using secure login mechanisms. Sensitive information like passwords is encrypted using Java’s Base64 encoding. OTP-based verification is used during registration to prevent fraudulent entries.

User Module
Registration & Authentication
Users must register using a valid email ID.

The system validates the email to prevent duplicate accounts.

If the email is not already registered, an OTP is sent for verification.

Upon successful OTP verification and submission of basic details, the user is registered.

A confirmation email is sent automatically.

Users cannot log in without completing the registration and verification process.

Login
Registered users log in using their email and password.

Unregistered users are prompted to register before proceeding.

Features Available After Login
Profile Management: Update profile picture, personal information, address, and password.

Wallet Management: Manage wallet balance and transactions.

Product Browsing:

View products by category.

Use filters for price, rating, and more.

Cart Functionality:

Add or remove products.

Proceed to checkout by selecting an address and completing payment.

Order Management:

View order status and details.

Receive automatic order-related email notifications.

Product Review:

Rate and review purchased products to help improve the platform.

Order Flow
When a user places an order, the admin is notified.

The admin then communicates packing and shipping details to the appropriate seller.

The seller ships the product.

Users can track shipment updates within the app and through emails.

Seller Module
Registration & Approval
Sellers must register using a valid email address.

An OTP is sent for verification.

After successful OTP validation and form submission, the seller receives a confirmation email.

The seller cannot log in until approved by an admin.

Upon approval, an email is sent notifying the seller of access.

Login
Verified sellers can log in using their email and password.

Features Available After Login
Profile Management: Update shop details, address, profile picture, and password.

Product Management:

Add new products with images and details.

Edit or delete existing products.

Order Fulfillment:

View shipment requests from users.

Pack and ship ordered products as per admin instructions.

Admin Module
Access & Control
The admin has full control over the application and its users.

Admin can manage users, sellers, products, and orders.

Key Features
User & Seller Management:

View, block, unblock, or permanently delete users and sellers.

Approve newly registered sellers.

Product Management:

Manage product listings.

Apply discounts.

Remove inappropriate or duplicate listings.

Order & Shipment Management:

Monitor all user orders.

Assign shipment requests to sellers.

Track product delivery progress.

Admin Management:

Create and manage additional admin accounts for platform maintenance.

Security Measures
Passwords are stored in encrypted format using Java's Base64.

OTP-based registration ensures only valid and verified accounts are created.

Access controls prevent unauthorized login attempts across all modules.
