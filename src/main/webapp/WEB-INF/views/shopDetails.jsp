<%@page import="com.onlineshop.E_Commerce.model.Product"%>
<%@page import="com.onlineshop.E_Commerce.model.Seller"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Admin-Shop's Detail Page</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css" />

<link rel="stylesheet" href="/css/index_header.css" />
<link rel="stylesheet" href="/css/shopDetails.css" />
<link rel="stylesheet" href="/css/footer.css" />

</head>
<body>
	<%@include file="index_header.jsp"%>
	<%
	Seller s = (Seller) request.getAttribute("seller");
	String role = (String) request.getAttribute("role");
	%>
	<section>
		<%
		if (s != null) {
			Address a = s.getShopAddress();
			List<Product> proucts = s.getProducts();
		%>
		<div class="card">
			<div class="shop-name"><%=s.getShopName()%></div>
			<div class="shop-image">
				<img src="fetchSellerImage?email=<%=s.getEmail()%>&role=<%=role%>"
					alt="Shopkeeper Image">
			</div>
			<div class="details-grid">
				<div class="detail-item">
					<strong>ID:</strong>
					<%=s.getId()%>
				</div>
				<div class="detail-item">
					<strong>GST No:</strong>
					<%=s.getGstNo()%>
				</div>
				<div class="detail-item">
					<strong>Shopkeeper Name:</strong>
					<%=s.getSellerName()%>
				</div>
				<div class="detail-item">
					<strong>Email:</strong>
					<%=s.getEmail()%>
				</div>
				<div class="detail-item">
					<strong>Phone:</strong>
					<%=s.getPhone()%>
				</div>
				<div class="detail-item">
					<strong>Address:</strong>
					<%=a != null ? a.getLocal() + ", " + a.getDistrict() + ", " + a.getState() + ", " + a.getPinCode()
		: "No Address Found"%>
				</div>
			</div>
			<%
			int count = proucts != null ? proucts.size() : 0;
			%>
			<div class="product-section">
				<span><strong>Total Products:</strong> <%=count%></span>
				<%
				if (count > 0) {
				%>
				<a href="#"><button class="view-products">View Products</button></a>
				<%
				}
				%>
			</div>

			<div class="buttons">
				<%
				if (!s.getIsApproved()) {
				%>
				<a href="approveShopPage?email=<%=s.getEmail()%>"><button
						class="approve">Approve</button></a>
				<%
				}
				%>
				<a href="#"><button class="delete">Delete</button></a>
				<button class="action" onclick="openModal()">
					<%
					if (s.getUnblockRequested()) {
					%><i class="fa-solid fa-bell"
						style="color: orange; font-size: 16px;"> </i>
					<%
					}
					%>
					Action
				</button>
			</div>
		</div>

		<!-- Modal -->
		<div id="actionModal" class="modal">
			<div class="modal-content">
				<span class="close" onclick="closeModal()">&times;</span>
				<%
				if (s.getIsBlocked()) {
				%>
				<h3>Request Message</h3>
				<p style="color: red;"><%=s.getUnblockMessage() != null ? s.getUnblockMessage() : "No message found"%></p>
				<div class="modal-buttons">
					<a href="<%="unblockSellerPage"%>?email=<%=s.getEmail()%>&role=Seller"><button
							class="unblock">Unblock</button></a>
				</div>
				<%
				} else {
				%>
				<div class="modal-buttons">
					<p>
						Do you want to Block <b><%=s.getShopName() + "-" + s.getSellerName()%></b>.
					</p>
					<a href="blockSellerPage?email=<%=s.getEmail()%>&role=Seller"><button
							class="block">Block</button></a>
				</div>
				<%
				}
				%>
			</div>
		</div>
		<%
		}
		%>
	</section>
	<%@include file="footer.jsp"%>

	<script type="text/javascript" src="/js/index_navbar.js"></script>
	<script type="text/javascript" src="/js/shopDetails.js"></script>

</body>
</html>
