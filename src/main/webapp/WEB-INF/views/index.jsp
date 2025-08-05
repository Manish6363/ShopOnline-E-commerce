<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>ShopOnline Index Page</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css" />

<link rel="stylesheet" href="/css/index_header.css" />
<link rel="stylesheet" href="/css/carousel.css" />
<link rel="stylesheet" href="/css/category.css" />
<link rel="stylesheet" href="/css/dynamic_product.css" />
<link rel="stylesheet" href="/css/footer.css" />

</head>
<body>
	<%@include file="index_header.jsp"%>

	<section>
		<%@include file="carousel.jsp"%>
		<%@include file="category.jsp"%>
		<%@include file="dynamic_product.jsp"%>
	</section>
	<%@include file="footer.jsp"%>

	<script type="text/javascript" src="/js/index_navbar.js"></script>
	<script type="text/javascript" src="/js/carousel.js"></script>
</body>
</html>
