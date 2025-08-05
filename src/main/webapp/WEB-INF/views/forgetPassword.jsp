<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String role = (String) request.getAttribute("role");
String emailMsg = (String) request.getAttribute("emailMsg");
%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title><%=role%> Forget Password Page</title>
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
				Forget Password
			</h2>
			<%
			String email = (String) request.getAttribute("email");
			Integer otpObj = (Integer) request.getAttribute("otp");
			int otp = (otpObj != null) ? otpObj.intValue() : 0;
			%>

			<div class="form-group">
				<div class="form-inline">
					<form action="<%=role + "SendOtpToForgetPass"%>" method="post"
						id="otp-section">
						<input type="hidden" name="subject"
							value="<%=role%> - Forget Password"> <input type="hidden"
							name="role" value="<%=role%>">
						<%
						if (email == null || email.isEmpty()) {
							if (emailMsg != null) {
						%>
						<p style="color: red;"><%=emailMsg%></p>
						<a href="<%=role.toLowerCase() + "RegisterPage"%>?role=<%=role%>"
							style="text-decoration: none; font-size: 18px;">Click here to
							Register</a> <br>
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
				action="<%=role + "-forget-pass"%>">
				<input type="hidden" name="email" id="hiddenEmail"
					value="<%=email != null ? email : ""%>" /> <input type="hidden"
					name="role" value="<%=role%>" />
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

				<button type="submit" id="registerBtn" class="btn btn-full" disabled>Change
					Password</button>
			</form>
		</div>
	</section>

	<%@include file="footer.jsp"%>

	<script type="text/javascript" src="/js/index_navbar.js"></script>
	<script type="text/javascript">
		const actualOtp =
	<%=otp%>
		;
	</script>
	<script type="text/javascript" src="/js/forgetPassword.js"></script>
</body>
</html>
