# ShopOnline – An E-Commerce Web Application

## Technologies Used [Java + Spring-boot-MVC + Spring JPA + JSP]
**Java + Spring Boot MVC:** Core backend framework for building a modular and scalable application.

**Spring JPA:** For ORM-based database operations and entity management.

**JSP (JavaServer Pages):** To render dynamic content on the User, Seller, and Admin interfaces.

**MySQL:** Relational database for structured data storage and retrieval.

**HTML/CSS:** To design and style the frontend UI.

**JavaScript:** To enhance interactivity and support dynamic frontend behavior.

### Security Measures
Passwords are stored in encrypted format using Java's Base64.

OTP-based registration ensures only valid and verified accounts are created.

Access controls prevent unauthorized login attempts across all modules.


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

<img width="1912" height="966" alt="image" src="https://github.com/user-attachments/assets/7782b970-9138-46d8-931e-5df7949de646" />
    
<img width="1919" height="951" alt="image" src="https://github.com/user-attachments/assets/011e845f-a4d4-4a02-9fb1-921d214aef69" />
    
<img width="1919" height="962" alt="image" src="https://github.com/user-attachments/assets/4f53e7c1-8b13-49bf-965a-ef524f3a877f" />

<img width="1911" height="951" alt="image" src="https://github.com/user-attachments/assets/5b09b2b3-d862-4ee9-800d-1bf1a695f052" />

![WhatsApp Image 2025-08-08 at 12 03 09_e0ad8594](https://github.com/user-attachments/assets/61a0e5e3-2fe9-4b17-a79a-2eddfdd6f442)

<img width="1919" height="966" alt="image" src="https://github.com/user-attachments/assets/90770628-3ac5-476f-b25b-b2eb8c879cd3" />

![WhatsApp Image 2025-08-08 at 12 08 50_8aab939d](https://github.com/user-attachments/assets/39cbc6e3-c9d7-4c8a-834a-5c1ba34f3fee)

<img width="1919" height="960" alt="image" src="https://github.com/user-attachments/assets/0b35efec-831e-4cae-a15d-e88e3998e9f2" />


#### Features Available After Login
##### Profile Management: 
    * Update shop details, address, profile picture, and password.

<img width="1919" height="657" alt="image" src="https://github.com/user-attachments/assets/3e0b7504-f92e-4e14-99df-b5d5f7561001" />

<img width="1908" height="670" alt="image" src="https://github.com/user-attachments/assets/1b74cf01-766e-4897-bcdb-23bc4edf0349" />


##### Product Management:
    * Add new products with images and details.
    * Edit or delete existing products.

<img width="1919" height="956" alt="image" src="https://github.com/user-attachments/assets/78f83f70-049a-4e86-9abd-7f0eb0778763" />


<img width="1919" height="959" alt="image" src="https://github.com/user-attachments/assets/42e2a180-6649-4c31-9447-dca3387fad98" />


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

<img width="1915" height="969" alt="image" src="https://github.com/user-attachments/assets/9d3bf8f9-3964-40fd-9984-5102fc294633" />

<img width="1919" height="950" alt="image" src="https://github.com/user-attachments/assets/e8bd5424-a373-479c-b3bf-c87fc9b8bad6" />

<img width="1919" height="947" alt="image" src="https://github.com/user-attachments/assets/49983a3c-e02d-42a8-953a-1b1005e027be" />

<img width="1919" height="953" alt="image" src="https://github.com/user-attachments/assets/51a70cca-eb11-482d-9548-310ebd204630" />

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




