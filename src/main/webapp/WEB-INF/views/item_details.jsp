<%@page import="com.onlineshop.E_Commerce.model.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Products Details</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css" />

<link rel="stylesheet" href="/css/index_header.css" />
<link rel="stylesheet" href="/css/item_details.css" />
<link rel="stylesheet" href="/css/footer.css" />

</head>
<body>
	<%
	List<Product> products = (List<Product>) session.getAttribute("products");
	%>
	<%@include file="index_header.jsp"%>

	<section id="itemDetails-section">
		<%
		if (products != null) {
			for (Product p : products) {
		%>
		<div id="itemDetails-container">
			<div id="itemDetails-img-container">
				<img src="<%="fetchProductImage"%>?id=<%=p.getId()%>" alt="Profile"
					class="product-pic" />
			</div>
			<div id="itemDetails-details">
				<ul>
					<h2>Smartphone XYZ</h2>
					<li>8GB RAM</li>
					<li>128GB Storage</li>
					<li>Snapdragon Processor</li>
					<li>5000mAh Battery</li>
				</ul>
				<button id="add-itemDetails-to-cart">ADD TO CART</button>
			</div>
		</div>
		<%
		}
		}
		%>
	</section>

	<%@include file="footer.jsp"%>

	<script type="text/javascript" src="/js/index_navbar.js"></script>
</body>
</html>
