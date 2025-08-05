<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Congratulations Page</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css" />

<link rel="stylesheet" href="/css/index_header.css" />
<link rel="stylesheet" href="/css/congratulation.css" />
<link rel="stylesheet" href="/css/footer.css" />

</head>
<body>
	<%@ include file="index_header.jsp"%>

	<%
	String names = (String) request.getAttribute("names");
	String email = (String) request.getAttribute("email");
	String password = (String) request.getAttribute("password");
	String role = (String) request.getAttribute("role");

	if (names == null || email == null || password == null || role == null) {
		response.sendRedirect(request.getContextPath() + "/");
		return;
	}
	%>


	<section id="congrats-section">
		<div class="container-congrats">
			<h1 id="h">
				🎉 Congratulations
				<%=names%></h1>
			<p id="para">Your registration was successful.</p>

			<div class="credentials">
				<span>👤 Username: <%=email%></span> <span>🔒 Password: <%=password%></span>
			</div>

			<a href="<%=role.toLowerCase() + "Login"%>" class="login-link">Click
				here to Login</a>
		</div>

		<!-- Confetti container inside the section -->
		<div id="confetti-container"></div>
	</section>

	<%@ include file="footer.jsp"%>

	<script type="text/javascript" src="/js/index_navbar.js"></script>
	<script type="text/javascript" src="/js/congratulation.js"></script>

</body>
</html>
