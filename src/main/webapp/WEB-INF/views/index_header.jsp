
<%@page import="com.onlineshop.E_Commerce.service.impl.UserServiceImpl"%>
<%@page import="com.onlineshop.E_Commerce.model.User"%>
<%@page import="com.onlineshop.E_Commerce.repository.UserRepo"%>
<%@page import="com.onlineshop.E_Commerce.service.UserService"%>
<%@page import="com.onlineshop.E_Commerce.model.Address"%>
<%@page import="java.util.List"%>
<%
String sessionEmail = (String) session.getAttribute("sessionEmail");
String name = (String) session.getAttribute("name");
String roles = (String) session.getAttribute("role");
%>
<header>
	<div id="sub-head-container">
		<div class="logo">
			<i class="fa-solid fa-truck-fast"></i>
			<div class="text-box">
				<div class="brand-name">ShopOnline</div>
				<div class="tagline">EXPLORE MORE</div>
			</div>
		</div>

		<div id="search-container">
			<i class="fa-solid fa-magnifying-glass search-icon"></i> <input
				type="search" id="search-box"
				placeholder="Search for products, brands and more" />
		</div>

		<nav id="navbar">
			<a href="/">Home</a> <a href="productPage">Product</a>
			<div>
				<select name="products-list" id="products-list"
					onchange="redirectToCategory(this)">
					<option value="" disabled selected align="center">Select
						Category</option>
					<option value="mobile">Mobile Phones</option>
					<option value="laptop">Laptop/Desktop</option>
					<option value="electronics">Electronic Appliances</option>
					<option value="gadgets">Gadgets</option>
					<option value="kitchen">Kitchen Appliances</option>
					<option value="men">Men's Fashion</option>
					<option value="women">Women's Fashion</option>
					<option value="kid">Kid's Fashion</option>
					<option value="beauty">Beauty Products</option>
					<option value="footwear">Footwear</option>
					<option value="bedroom">Home Decors</option>
					<option value="toys">Toy & Games</option>
					<option value="trolley">Trolley Bags</option>
					<option value="trolley">Stationary Product</option>
					<option value="health">Health & Nutrition</option>
				</select>
			</div>
			<%
			if (sessionEmail == null) {
			%>
			<a href="userLogin">User Login</a>
			<div class="dropdown">
				<select name="login-as" onchange="redirectToLogin(this)">
					<option value="" disabled selected>Login As</option>
					<option value="admin">Admin Login</option>
					<option value="seller">Seller Login</option>
				</select>
			</div>
			<%
			} else if (roles != null && roles.equalsIgnoreCase("User")) {
			%>
			<a href="cart">Cart</a>
			<%
			} else if (roles != null && roles.equalsIgnoreCase("Seller")) {
			%>
			<a href="addProductPage">Add Product</a>
			<%
			} else if (roles != null && roles.equalsIgnoreCase("Admin")) {
			%>
			<a href="dashboardPage">Dashboard</a>
			<%
			}
			if (roles != null) {
			%>

			<div class="profile-icon" onclick="toggleProfileOptions()">
				<img
					src="<%="fetch" + roles + "Image"%>?email=<%=sessionEmail%>&role=<%=roles%>"
					alt="Profile" class="profile-pic" /> <span><%=name.split(" ")[0]%></span>
				<div class="profile-options" id="profileOptions">
					<a href="#" onclick="openImageUploadModal()">Change Picture</a> <a
						href="updateProfile">Update Profile</a> <a href="#"
						onclick="openChangePasswordModal()">Change Password</a>
					<%
					if (roles != null && (roles.equalsIgnoreCase("User") || roles.equalsIgnoreCase("Seller"))) {
					%>
					<a href="#" onclick="openWalletModal()">Wallet</a> <a href="#"
						onclick="openAddressModal()">Address</a>
					<%
					}
					%>
					<a href="logout">Logout</a>
				</div>
			</div>
			<%
			}
			%>
		</nav>

		<div class="hamburger" onclick="toggleDrawer()">
			<%
			if (sessionEmail != null && roles != null) {
			%>
			<img
				src="<%="fetch" + roles + "Image"%>?email=<%=sessionEmail%>&role=<%=roles%>"
				alt="Profile" class="profile-pic" />
			<%
			} else {
			%>
			<i class="fa fa-bars"></i>
			<%
			}
			%>
		</div>
	</div>

	<div class="drawer" id="drawer">
		<div class="close-btn" onclick="toggleDrawer()">
			<i class="fa fa-times"></i>
		</div>

		<div class="profile-section">
			<%
			if (sessionEmail != null && roles != null) {
			%>
			<img
				src="<%="fetch" + roles + "Image"%>?email=<%=sessionEmail%>&role=<%=roles%>"
				alt="Profile" class="profile-pic" /> <span><%=name.split(" ")[0]%></span>
			<%
			}
			%>
		</div>

		<div id="drawer-search-container">
			<i class="fa-solid fa-magnifying-glass search-icon"></i> <input
				type="search" id="drawer-search-box"
				placeholder="Search for products, brands and more" />
		</div>

		<a href="/">Home</a> <a href="productPage">Product</a>
		<div>
			<select name="products-list" id="products-list-drawer"
				style="color: var(--text-dark);" onchange="redirectToCategory(this)">
				<option disabled selected>Select Category</option>
				<option value="mobile">Mobile Phones</option>
				<option value="laptop">Laptop/Desktop</option>
				<option value="electronics">Electronic Appliances</option>
				<option value="gadgets">Gadgets</option>
				<option value="kitchen">Kitchen Appliances</option>
				<option value="men">Men's Fashion</option>
				<option value="women">Women's Fashion</option>
				<option value="kid">Kid's Fashion</option>
				<option value="beauty">Beauty Products</option>
				<option value="footwear">Footwear</option>
				<option value="bedroom">Home Decors</option>
				<option value="toys">Toy & Games</option>
				<option value="trolley">Trolley Bags</option>
				<option value="trolley">Stationary Product</option>
				<option value="health">Health & Nutrition</option>
			</select>
		</div>

		<%
		if (sessionEmail == null) {
		%>
		<a href="userLogin">User Login</a>
		<div class="dropdown">
			<select name="login-as" onchange="redirectToLogin(this)">
				<option value="" disabled selected>Login As</option>
				<option value="admin">Admin Login</option>
				<option value="seller">Seller Login</option>
			</select>
		</div>

		<%
		} else if (roles != null && roles.equalsIgnoreCase("User")) {
		%>
		<a href="cart">Cart</a>
		<%
		} else if (roles != null && roles.equalsIgnoreCase("Seller")) {
		%>
		<a href="cart">Add Product</a>
		<%
		} else if (roles != null && roles.equalsIgnoreCase("Admin")) {
		%>
		<a href="dashboardPage">Dashboard</a>
		<%
		}
		if (roles != null) {
		%>
		<a href="#" onclick="openImageUploadModal()">Change Picture</a> <a
			href="updateProfile">Update Profile</a> <a href="#"
			onclick="openChangePasswordModal()">Change Password</a>
		<%
		if (roles != null && (roles.equalsIgnoreCase("User") || roles.equalsIgnoreCase("Seller"))) {
		%>
		<a href="#" onclick="openWalletModal()">Wallet</a> <a href="#"
			onclick="openAddressModal()">Address</a>
		<%
		}
		%>
		<a href="logout">Logout</a>
		<%
		}
		%>
		</nav>


		<!-- Image Upload Modal -->
		<div id="imageUploadModal" class="modal">
			<div class="modal-content">
				<span class="close" onclick="closeImageUploadModal()">&times;</span>
				<h3>Upload Profile Picture</h3>
				<form action="<%="change" + roles + "Picture"%>" method="post"
					enctype="multipart/form-data">
					<input type="hidden" name="email" value="<%=sessionEmail%>">
					<input type="hidden" name="role" value="<%=roles%>"> <input
						type="file" name="image" accept="image/*" required /> <br /> <br />
					<button type="submit">Upload</button>
				</form>
			</div>
		</div>

		<!-- Change Password Modal -->
		<div id="changePasswordModal" class="modal">
			<div class="modal-content">
				<span class="close" onclick="closeChangePasswordModal()">&times;</span>
				<h3>Change Password</h3>
				<form action="<%=roles + "-forget-pass"%>" method="post">
					<input type="hidden" name="email" value="<%=sessionEmail%>">
					<input type="hidden" name="role" value="<%=roles%>"> <br>
					<input type="password" name="password"
						placeholder="Enter new Password"> <br /> <br />
					<button type="submit">Change Password</button>
				</form>
			</div>
		</div>


		<!-- Wallet Modal -->
		<div id="walletModal" class="modal">
			<div class="modal-content address-modal">
				<span class="close" onclick="closeWalletModal()">&times;</span>
				<h3>Your Wallet</h3>
				<div id="addressList"></div>
				<br />
				<button onclick="openTransactionModal()" class="add-address-btn">
					View Transactions</button>
			</div>
		</div>



		<!-- Transaction Modal -->
		<div id="transactionModal" class="modal">
			<div class="modal-content"
				style="width: 330px; background-color: blue;">
				<span class="close" onclick="closeTransactionModal()">&times;</span>
				<h3>Transactions</h3>
				<form action="#" method="post">
					<input type="hidden" name="email" value="<%=sessionEmail%>">
					<input type="hidden" name="role" value="<%=roles%>"> <br>
					<br />
					<h1>Hi</h1>
				</form>
			</div>
		</div>


		<!-- Address Modal -->
		<div id="addressModal" class="modal">
			<div class="modal-content address-modal">
				<span class="close" onclick="closeAddressModal()">&times;</span>
				<h3>Your Addresses</h3>
				<div id="addressList">
					<!-- Dynamically load address entries here -->
					<%
					if (roles != null && roles.equalsIgnoreCase("User")) {
						List<Address> add = (List<Address>) session.getAttribute("address");
						if (add != null) {
							for (Address a : add) {
					%>
					<ul>
						<li align="left">Type: <span
							style="color: black; font-weight: 700;"><%=a.getType()%></span>
							<div class="address-item"
								style="background-color: white; color: black;">
								<p><%=a.getLocal() + ", " + a.getDistrict() + ", " + a.getState() + ", " + a.getPinCode()%></p>
							</div>
						</li>
						<a
							href="<%="remove" + roles + "Address"%>?id=<%=a.getId()%>&email=<%=sessionEmail%>"><button>Remove</button></a>
					</ul>
					<%
					}
					} else {
					%>
					<p>No addresses found.</p>
					<%
					}
					} else if (roles != null && roles.equalsIgnoreCase("Seller")) {
					Address a = (Address) session.getAttribute("address");
					if (a != null) {
					%>
					<ul>
						<li align="left">Type: <span
							style="color: black; font-weight: 700;"><%=a.getType()%></span>
							<div class="address-item"
								style="background-color: white; color: black;">
								<p><%=a.getLocal() + ", " + a.getDistrict() + ", " + a.getState() + ", " + a.getPinCode()%></p>
							</div>
						</li>
						<a
							href="<%="remove" + roles + "Address"%>?id=<%=a.getId()%>&email=<%=sessionEmail%>"><button>Remove</button></a>
					</ul>
					<%
					}
					} else {
					%>
					<p>No addresses found.</p>
					<%
					}
					%>
				</div>
				<br />
				<button onclick="openAddAddressModal()" class="add-address-btn">
					<%
					if (roles != null && roles.equalsIgnoreCase("User")) {
					%>
					+ Add Address
					<%
					} else {
					%>
					Update Address
					<%
					}
					%>
				</button>
			</div>
		</div>



		<!-- Add Address Modal -->
		<div id="addAddressModal" class="modal">
			<div class="modal-content"
				style="width: 330px; background-color: blue;">
				<span class="close" onclick="closeAddAddressModal()">&times;</span>
				<h3>Add Address</h3>
				<form action="<%="add" + roles + "Address"%>" method="post">
					<input type="hidden" name="email" value="<%=sessionEmail%>">
					<input type="hidden" name="role" value="<%=roles%>"> <br>
					Type: <input type="text" name="type" required
						style="font-size: 15px; margin-bottom: 10px;"
						placeholder="Address type: Home, Office"> <br>
					Address: <br>
					<textarea rows="2" cols="20" name="local" required
						style="font-size: 18px; margin-bottom: 10px;"></textarea>
					<br> District: <input type="text" name="district" required
						style="font-size: 18px; margin-bottom: 10px;"> <br>
					State: <input type="text" name="state" required
						style="font-size: 18px;"> <br> Pin-Code: <input
						type="number" name="pinCode" required style="font-size: 18px;">
					<br /> <br />
					<button type="submit">Add Address</button>
				</form>
			</div>
		</div>
</header>
