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
<link rel="stylesheet" href="/css/admin_shopkeepers.css" />
<link rel="stylesheet" href="/css/footer.css" />

</head>
<body>
	<%@include file="index_header.jsp"%>

	<section>
		<div id="shops">
			<%
			String role = (String) request.getAttribute("role");
			List<Seller> shops = (List<Seller>) request.getAttribute("shops");
			if (shops != null) {
				for (Seller s : shops) {
					Address ad = s.getShopAddress();
			%>

			<div class="shop-container" <%if (!s.getIsApproved()) {%>
				style="background-color: orange;" <%}%> onclick="location.href='shopDetailsPage?email=<%=s.getEmail()%>&role=<%=role%>'">
				<div id="shop-image">
					<img src="fetchSellerImage?email=<%=s.getEmail()%>&role=<%=role%>"
						alt="Shop-pic" />
				</div>
				<h2><%=s.getShopName()%></h2>
				<h3><%=s.getSellerName()%></h3>
				<%
				if (!s.getIsApproved()) {
				%>
				<h2 style="color: white">Waiting for Approval</h2>
				<%
				}
				%>
				<%
				if (ad != null) {
				%>
				<p><%=ad.getLocal() + ", " + ad.getDistrict() + ", " + ad.getState() + ", " + ad.getPinCode()%></p>
				<%
				}
				%>
			</div>

			<%
			}
			}
			%>
		</div>
	</section>
	<%@include file="footer.jsp"%>

	<script type="text/javascript" src="/js/index_navbar.js"></script>


</body>
</html>
