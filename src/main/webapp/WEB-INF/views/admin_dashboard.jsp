<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Admin Dashboard Page</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css" />

<link rel="stylesheet" href="/css/index_header.css" />
<link rel="stylesheet" href="/css/admin_dashboard.css" />
<link rel="stylesheet" href="/css/footer.css" />

</head>
<body>
	<%@include file="index_header.jsp"%>

	<section>
		<div class="dashboard-container">
			<!-- Row 1 -->
			<div class="dashboard-row">
				<div class="card" onclick="location.href='manage-products.html'">
					<i class="fa-brands fa-product-hunt"></i>
					<div class="card-title">Manage Product</div>
					<div class="card-count">120</div>
				</div>

				<div class="card" onclick="location.href='add-category.html'">
					<i class="fa-solid fa-list"></i>
					<div class="card-title">Add Category</div>
					<div class="card-count">12</div>
				</div>

				<div class="card" onclick="location.href='orders.html'">
					<i class="fa-solid fa-box-open"></i>
					<div class="card-title">Orders</div>
					<div class="card-count">305</div>
				</div>
			</div>

			<!-- Row 2 -->
			<div class="dashboard-row">
				<div class="card" onclick="location.href='usersPage?role=User'">
					<i class="fa-solid fa-users"></i>
					<div class="card-title">Users</div>
					<%
					Integer userCount = (Integer) request.getAttribute("userCount");
					%>
					<div class="card-count"><%=userCount%></div>
				</div>

				<div class="card" onclick="location.href='shopkeepersPage?role=Seller'">
					<i class="fa-solid fa-shop"></i>
					<div class="card-title">Shopkeepers</div>
					<%
					Integer sellerCount = (Integer) request.getAttribute("sellerCount");
					%>
					<div class="card-count"><%=sellerCount%></div>
				</div>

				<div class="card" onclick="location.href='add-admin.html'">
					<i class="fa-solid fa-user-plus"></i>
					<div class="card-title">Add Admin</div>
					<div class="card-count">6</div>
				</div>
			</div>
		</div>
	</section>
	<%@include file="footer.jsp"%>

	<script type="text/javascript" src="/js/index_navbar.js"></script>

</body>
</html>
