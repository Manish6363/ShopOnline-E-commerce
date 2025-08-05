<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String email = (String) request.getAttribute("email");
String names = (String) request.getAttribute("names");
String role = (String) request.getAttribute("role");
String msg = (String) request.getAttribute("msg");
%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title><%=role%> Blocked Page</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css" />

<link rel="stylesheet" href="/css/index_header.css" />
<link rel="stylesheet" href="/css/blockedPage.css" />
<link rel="stylesheet" href="/css/footer.css" />

</head>
<body>
	<%@include file="index_header.jsp"%>

	<section>
		<div class="blocked-container">
			<i class="fas fa-user-lock"></i>
			<h2><%=role%>
				Access Denied
			</h2>
			<p>
				Oops! Dear <b> <%=names%></b>, your account has been <strong
					style="color: red;"><%=msg%></strong> by the admin.<br> You
				cannot perform any actions right now.
			</p>
			<%
			if (msg != null && msg.split(" ")[0].equals("Blocked")) {
			%>
			<button class="request-button" onclick="openModal()">Request
				to Unblock</button>
			<%
			} else {
			%>
			<p><b>Please wait, until your shop is verified and approved by our team.</b></p>
			<%
			}
			%>
		</div>
	</section>

	<!-- Modal -->
	<div class="modal" id="unblockModal">
		<div class="modal-content">
			<h3>Request Unblock</h3>
			<form action="<%=role + "UnblockRequest"%>" method="post">
				<input type="hidden" name="email" value="<%=email%>" /> <input
					type="hidden" name="role" value="<%=role%>" /> <input
					type="hidden" name="unblockRequested" value="true" /> <label
					for="unblockMessage">Why should we unblock your account?</label>
				<textarea name="unblockMessage" required
					placeholder="Enter your message here..."></textarea>

				<div class="modal-actions">
					<button type="button" class="cancel-btn" onclick="closeModal()">Cancel</button>
					<button type="submit" class="submit-btn">Submit Request</button>
				</div>
			</form>
		</div>
	</div>


	<%@include file="footer.jsp"%>

	<script type="text/javascript" src="/js/index_navbar.js"></script>
	<script type="text/javascript" src="/js/blockedPage.js"></script>
</body>
</html>
