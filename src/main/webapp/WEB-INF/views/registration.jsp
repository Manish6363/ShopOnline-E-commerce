<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String role = (String) request.getAttribute("role");
%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title><%=role%> Registration Page</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css" />
<link rel="stylesheet" href="/css/index_header.css" />
<link rel="stylesheet" href="/css/user_registration.css" />
<link rel="stylesheet" href="/css/footer.css" />
</head>
<body>
	<%@include file="index_header.jsp"%>

	<section>
		<div class="container">
			<h2 class="heading"><%=role%>
				Registration
			</h2>
			<%
			String emailMsg = (String) request.getAttribute("emailMsg");
			String email = (String) request.getAttribute("email");
			Integer otpObj = (Integer) request.getAttribute("otp");
			int otp = (otpObj != null) ? otpObj.intValue() : 0;
			%>

			<div class="form-group">

				<div class="form-inline">
					<form action="<%=role + "SendOTP"%>" method="post" id="otp-section">
						<input type="hidden" name="subject"
							value="<%="New " + role + " Registration"%>"> <input
							type="hidden" name="role" value="<%=role%>">
						<%
						if (emailMsg != null || email == null || email.isEmpty()) {
							if (emailMsg != null) {
						%>
						<p style="color: red;"><%=emailMsg%></p>
						<a href="<%=role.toLowerCase() + "Login"%>?role=<%=role%>"
							style="text-decoration: none; font-size: 18px;">Click here to
							Login</a> <br>
						<%
						request.removeAttribute("emailMsg");
						} else {
						%>
						<label for="email" class="form-label">Email</label> <input
							type="email" name="email" id="email" class="form-input"
							placeholder="Enter email" required /> <input type="submit"
							id="sendOtpBtn" class="btn" value="Send OTP" disabled />
						<%
						}
						} else {
						%>
						<input type="email" name="email" id="email" class="form-input"
							value="<%=email%>" readonly /> <input type="submit" class="btn"
							value="Send OTP" disabled />
						<%
						}
						%>
					</form>
				</div>
				<div id="emailMessage" class="message"></div>
			</div>

			<div class="form-group <%=(otp > 0) ? "" : "hidden"%>"
				id="otpSection">
				<label for="otpInput" class="form-label">Enter OTP</label>
				<div class="form-inline">
					<input type="number" id="otpInput" class="form-input"
						placeholder="Enter OTP" required />
					<button id="verifyOtpBtn" class="btn" type="button"
						onclick="verifyOtp()">Submit OTP</button>
				</div>
				<div id="otpMessage" class="message"></div>
			</div>

			<form id="registerForm" class="hidden" method="post"
				action="<%=role + "-Registration"%>">
				<input type="hidden" name="email" id="hiddenEmail"
					value="<%=email != null ? email : ""%>" /> <input type="hidden"
					name="role" value="<%=role%>">

				<%
				if ("User".equalsIgnoreCase(role)) {
				%>
				<div class="form-group">
					<label for="name" class="form-label">Full Name</label> <input
						type="text" name="name" id="name" class="form-input" />
					<div id="nameError" class="error-msg"></div>
				</div>
				<div class="form-group">
					<label for="dob" class="form-label">Date of Birth</label> <input
						type="date" name="dob" id="dob" class="form-input" />
				</div>

				<div class="form-group">
					<label class="form-label">Gender</label>
					<div class="gender-group">
						<label><input type="radio" name="gender" value="Male" />
							Male</label> <label><input type="radio" name="gender"
							value="Female" /> Female</label> <label><input type="radio"
							name="gender" value="Transgender" /> Transgender</label>
					</div>
				</div>

				<%
				} else {
				%>
				<div class="form-group">
					<label for="sellerName" class="form-label">Seller Name</label> <input
						type="text" name="sellerName" id="sellerName" class="form-input" />
					<div id="sellerNameError" class="error-msg"></div>
				</div>
				<div class="form-group">
					<label for="gstNo" class="form-label">GST No.</label> <input
						type="text" name="gstNo" id="gstNo" class="form-input" />
					<div id="gstNoError" class="error-msg"></div>
				</div>
				<div class="form-group">
					<label for="shopName" class="form-label">Shop Name</label> <input
						type="text" name="shopName" id="shopName" class="form-input" />
					<div id="shopNameError" class="error-msg"></div>
				</div>
				<%
				}
				%>
				<div class="form-group">
					<label for="mobile" class="form-label">Mobile Number</label> <input
						type="tel" name="phone" id="mobile" class="form-input"
						pattern="[6-9][0-9]{9}" />
					<div id="mobileError" class="error-msg"></div>
				</div>


				<div class="form-group">
					<label for="password" class="form-label">Password</label> <input
						type="password" name="password" id="password" class="form-input" />
					<div id="passwordError" class="error-msg"></div>
				</div>

				<div class="form-group">
					<label for="confirmPassword" class="form-label">Confirm
						Password</label> <input type="password" name="confirmPassword"
						id="confirmPassword" class="form-input" />
					<div id="confirmPasswordError" class="error-msg"></div>
				</div>

				<button type="submit" id="registerBtn" class="btn btn-full" disabled>Register</button>
			</form>
		</div>
	</section>

	<%@include file="footer.jsp"%>

	<script type="text/javascript" src="/js/index_navbar.js"></script>
	<script type="text/javascript">
		const actualOtp = <%=otp%>;
		const role = "<%=role%>";
	</script>
	<script type="text/javascript" src="/js/registration.js"></script>
</body>
</html>