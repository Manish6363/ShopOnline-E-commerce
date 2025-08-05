<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Admin-Users Page</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css" />

<link rel="stylesheet" href="/css/index_header.css" />
<link rel="stylesheet" href="/css/admin_users.css" />
<link rel="stylesheet" href="/css/footer.css" />

</head>
<body>
	<%@include file="index_header.jsp"%>
	<%
	List<User> users = (List<User>) request.getAttribute("users");
	String role = (String) request.getAttribute("role");
	%>
	<section>
		<div class="users-container">
			<table id="tables">
				<thead id="theads">
					<tr>
						<th class="table-heading">ID & Profile</th>
						<th class="table-heading">NAME</th>
						<th class="table-heading">EMAIL</th>
						<th class="table-heading">PHONE</th>
						<th class="table-heading">GENDER</th>
						<th class="table-heading">DOB</th>
						<th class="table-heading">ADDRESS</th>
						<th class="table-heading">IS BLOCKED</th>
						<th class="table-heading">ORDERS</th>
						<th class="table-heading">DELETE</th>
					</tr>
				</thead>
				<tbody>
					<!-- Example row -->
					<%
					if (users != null) {
						for (User u : users) {
							List<Address> ads = u.getAddress();
					%>
					<tr>
						<td class="table-data">ID: <%=u.getId()%><br> <img
							src="fetchUserImage?email=<%=u.getEmail()%>&role=User"
							alt="Profile" class="user-profile-pic"></td>
						<td><%=u.getName()%></td>
						<td class="email-col"><%=u.getEmail()%></td>
						<td><%=u.getPhone()%></td>
						<td><%=u.getGender()%></td>
						<td><%=u.getDob()%></td>
						<%
						if (ads != null) {
						%>
						<td class="address-col">
							<%
							for (Address a : ads) {
							%>
							<p style="border: 1px solid; margin: 2px;"><%=a.getLocal() + ", " + a.getDistrict() + ", " + a.getState() + ", " + a.getPinCode()%></p>
							<br> <%
 }
 %>
						</td>
						<%
						}
						%>
						<td>
							<%
							if (u.getIsBlocked()) {
							%>
							<p style="color: red;"><%=u.getUnblockMessage()%></p> <a
							href="unblockUserPage?email=<%=u.getEmail()%>&role=User"><button
									class="btn btn-unblock">UNBLOCK</button></a> <%
 } else {
 %> <a href="blockUserPage?email=<%=u.getEmail()%>&role=User"><button
									class="btn btn-block">BLOCK</button></a> <%
 }
 %>
						</td>

						<td>
							<button class="btn btn-orders">ORDERS</button>
						</td>
						<td>
							<button class="btn btn-delete" onclick="confirmDelete()">DELETE</button>
						</td>
					</tr>
					<%
					}
					}
					%>
				</tbody>
			</table>
		</div>

	</section>

	<%@include file="footer.jsp"%>

	<script type="text/javascript" src="/js/index_navbar.js"></script>
	<script type="text/javascript" src="/js/admin_users.js"></script>
</body>
</html>
