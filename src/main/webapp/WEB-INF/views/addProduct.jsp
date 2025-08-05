<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Add Product Page</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css" />

<link rel="stylesheet" href="/css/index_header.css" />
<link rel="stylesheet" href="/css/add_product.css" />
<link rel="stylesheet" href="/css/footer.css" />

</head>
<body>
	<%@include file="index_header.jsp"%>

	<section>

		<h2 align="center">Add New Product</h2>

		<form method="post" action="addProductData"
			enctype="multipart/form-data">
			<input type="hidden" name="sellerEmail" value=<%=sessionEmail%>>
			<div class="addProduct-form-group">
				<input type="text" name="name" id="name" placeholder=" " required />
				<label for="name">Product Name</label>
			</div>

			<div class="addProduct-form-group">
				<input type="number" step="0.01" name="actualPrice" id="actualPrice"
					placeholder=" " required /> <label for="actualPrice">Actual
					Price</label>
			</div>

			<div class="addProduct-form-group">
				<input type="number" name="quantity" id="quantity" placeholder=" "
					required /> <label for="quantity">Quantity</label>
			</div>

			<div class="addProduct-form-group">
				<select name="category" id="category" required>
					<option value="" disabled selected hidden></option>
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
					<option value="stationary">Stationary Product</option>
					<option value="health">Health & Nutrition</option>
				</select> <label for="category">Category</label>
			</div>

			<div class="addProduct-form-group">
				<textarea name="description" id="description" rows="4"
					placeholder="Give the details in the Key-value pair. Like Fetures: value"
					required></textarea>
				<label for="description">Description</label>
			</div>

			<div class="addProduct-form-group">
				<input type="number" step="0.01" name="discountPercentage"
					id="discountPercentage" placeholder=" " /> <label
					for="discountPercentage">Discount (%)</label>
			</div>

			<label for="imageFile" style="font-weight: 500">Product Image</label>
			<input type="file" name="imageFile" id="imageFile" accept="image/*"
				required />

			<button id="addProduct-button" type="submit">Add Product</button>
		</form>

	</section>
	<%@include file="footer.jsp"%>

	<script type="text/javascript" src="/js/index_navbar.js"></script>
</body>
</html>
