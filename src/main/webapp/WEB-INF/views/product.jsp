<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Product Login Page</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css" />

<link rel="stylesheet" href="/css/index_header.css" />
<link rel="stylesheet" href="/css/products.css" />
<link rel="stylesheet" href="/css/footer.css" />

</head>
<body>
	<%@include file="index_header.jsp"%>

	<section>
		<div id="product-container">
			<!-- Filter Sidebar -->
			<div id="filter-product">
				<form action="" method="post">
					<h3>Filter by Price</h3>
					<label><input type="checkbox" name="price" value="asc" />
						Sort by Ascending</label> <label><input type="checkbox"
						name="price" value="desc" /> Sort by Descending</label>
					<h3>Filter by Ratings</h3>
					<label><input type="checkbox" name="star4" value="star4" />
						⭐⭐⭐⭐ & Above</label> <label><input type="checkbox" name="star3"
						value="star3" /> ⭐⭐⭐ & Above</label> <label><input
						type="checkbox" name="star2" value="star2" /> ⭐⭐ & Above</label> <label><input
						type="checkbox" name="star1" value="star1" /> ⭐ & Above</label> <input
						type="submit" value="Apply-Filter" style="background-color: blue"
						class="btn" /> <input type="reset" value="Clear-Filter"
						style="background-color: red" class="btn" />
				</form>
			</div>
			<!-- Product Display Area -->
			<div id="product-display">
				<div class="product-card">
					<img src="/image/appliaences.jpg" alt="Product 1" />
					<p>Smartphone XYZ</p>
					<p style="font-size: .75rem;">
						<span
							style="background-color: green; border-radius: 3px; color: white; padding: 2px 5px;">3.9<i
							class="fa-solid fa-star"></i></span> 566 Ratings
					</p>
					<span style="color: var(--primary-color); margin-right: 10px">&#8377;299
						<span>5%off</span>
					</span><s><p>&#8377;599</p></s> <a href="#"><button id="view">View
							Details</button></a>
				</div>
				<!-- Add -->
			</div>
		</div>
	</section>

	<%@include file="footer.jsp"%>

	<script type="text/javascript" src="/js/index_navbar.js"></script>
</body>
</html>
