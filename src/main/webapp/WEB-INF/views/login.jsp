<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String role = (String) request.getAttribute("role");

String formAction = "";
if ("User".equalsIgnoreCase(role)) {
	formAction = "user-sign-in";
} else if ("Seller".equalsIgnoreCase(role)) {
	formAction = "seller-sign-in";
} else if ("Admin".equalsIgnoreCase(role)) {
	formAction = "admin-sign-in";
}

String emailMsg = (String) request.getAttribute("emailMsg");
String passMsg = (String) request.getAttribute("passMsg");
%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title><%=role%> Login Page</title>

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css" />
<link rel="stylesheet" href="/css/index_header.css" />
<link rel="stylesheet" href="/css/login.css" />
<link rel="stylesheet" href="/css/footer.css" />
</head>

<body>
	<%@ include file="index_header.jsp"%>

	<section>
		<div id="login-container">
			<div id="login-video">
				<video autoplay muted loop disablePictureInPicture playsinline>
					<source src="/video/Ecommerce Promotions.mp4" type="video/mp4" />
					Your browser does not support HTML5 video.
				</video>
			</div>

			<div id="login-sub-container">
				<h1 id="heading-name"><%=role%>
					Login
				</h1>

				<form id="login-form" action="<%=formAction%>" method="post">
					<input type="hidden" name="role" value="<%=role%>" />
					<%
					if (emailMsg != null) {
					%>
					<p style="color: red;"><%=emailMsg%></p>
					<%
					}
					%>
					<input type="email" id="email" name="email" placeholder="Email ID"
						required />
					<%
					if (passMsg != null) {
					%>
					<p style="color: red;"><%=passMsg%></p>
					<%
					}
					%>
					<input type="password" id="password" name="password"
						placeholder="Password" required />

					<button class="login-btn" id="login-btn" type="submit">Login</button>

					<div class="links">
						<a href="forgetPassPage?role=<%=role%>">Forgot Password?</a>
						<%
						if (role!=null && !"admin".equalsIgnoreCase(role)) {
							String registerPath = role.toLowerCase() + "RegisterPage";
						%>
						<p>
							New User? <a href="<%=registerPath%>?role=<%=role%>">Register</a>
						</p>
						<%
						}
						%>
					</div>
				</form>
			</div>
		</div>
	</section>

	<%@ include file="footer.jsp"%>

	<script type="text/javascript" src="/js/index_navbar.js"></script>
	<script type="text/javascript" src="/js/login.js"></script>
</body>
</html>
