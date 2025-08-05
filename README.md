# ShopOnline – An E-Commerce Web Application

## Technologies Used [Java + Spring-boot-MVC + Spring JPA + JSP]
**Java + Spring Boot MVC:** Core backend framework for building a modular and scalable application.

**Spring JPA:** For ORM-based database operations and entity management.

**JSP (JavaServer Pages):** To render dynamic content on the User, Seller, and Admin interfaces.

**MySQL:** Relational database for structured data storage and retrieval.

**HTML/CSS:** To design and style the frontend UI.

**JavaScript:** To enhance interactivity and support dynamic frontend behavior.


## Objective
ShopOnline is a comprehensive e-commerce web application inspired by leading platforms such as Amazon, Flipkart, and Myntra. It is designed to provide a seamless online shopping experience to users, while also offering secure modules for sellers and administrators. The application features a robust navigation system with intuitive UI elements like search functionality, product categorization, and product highlights (e.g., top-rated and latest arrivals) on the homepage.

**The application is divided into three secure modules:**
  1. Admin Module
  2. Seller Module
  3. User Module

All modules are protected against unauthorized access using secure login mechanisms. Sensitive information like passwords is encrypted using Java’s Base64 encoding. OTP-based verification is used during registration to prevent fraudulent entries.


## User Module
#### Registration & Authentication: 
    * Users must register using a valid email ID.
    * The application validates the email to prevent duplicate accounts.
    * If the email is not already registered, an OTP is sent for verification.
    * Upon successful OTP verification and submission of basic details, the user is registered and a confirmation email is sent automatically.
    * Users cannot log in without completing the registration and verification process.

#### Login
    * Registered users log in using their email and password.
    * Unregistered users are prompted to register before proceeding.
#### Features Available After Login
##### Profile Management: 
    * Update profile picture, personal information, address, and password.
##### Wallet Management: 
    * Manage wallet balance and transactions.
##### Product Browsing:
    * View products by category.
    * Use filters for price, rating, and more.
##### Cart Functionality:
    * Add or remove products.
    * Proceed to checkout by selecting an address and completing payment.
##### Order Management:
    * View order status and details.
    * Receive automatic order-related email notifications.
##### Product Review:
    * Rate and review purchased products to help improve the platform.
##### Order Flow
    * When a user places an order, the admin is notified.
    * The admin then communicates packing and shipping details to the appropriate seller.
    * The seller ships the product.
    * Users can track shipment updates within the app and through emails.


## Seller Module
#### Registration & Approval
    * Sellers must register using a valid email address.
    * An OTP is sent for verification.
    * After successful OTP validation and form submission, the seller receives a confirmation email.
    * The seller cannot log in until approved by an admin.
    * Upon approval, an email is sent to notify the seller to access.

#### Login
    * Verified sellers can log in using their email and password.
#### Features Available After Login
##### Profile Management: 
    * Update shop details, address, profile picture, and password.
##### Product Management:
    * Add new products with images and details.
    * Edit or delete existing products.
##### Order Fulfillment:
    * View user ordered product shipment requests from admin.
    * Pack and ship ordered products as per admin instructions.


## Admin Module
All the Access & Controls are perserved.
The admin has full control over the application and its users.
Admin can manage users, sellers, products, and orders.

#### Features
##### User & Seller Management:
    * View, block, unblock, or permanently delete users and sellers.
    * Verify and approve newly registered sellers.
##### Product Management:
    * Manage product listings.
    * Apply discounts on the any of seller products.
    * Remove inappropriate or duplicate listings.
##### Order & Shipment Management:
    * Monitor all user orders.
    * Assign shipment requests to sellers.
    * Track product delivery progress.
##### Admin Management:
    * Create and manage additional admin accounts for platform maintenance.


## Security Measures
Passwords are stored in encrypted format using Java's Base64.

OTP-based registration ensures only valid and verified accounts are created.

Access controls prevent unauthorized login attempts across all modules.
