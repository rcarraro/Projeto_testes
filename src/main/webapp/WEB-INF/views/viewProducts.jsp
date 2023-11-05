<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="tab" uri="http://ditchnet.org/jsp-tabs-taglib"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>User Registration</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link href="/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<link href="/css/bootstrap-responsive.min.css" rel="stylesheet"
	type="text/css" />
<link href="/css/custom.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
<!-- Optional theme -->
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap-theme.min.css">
<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
<style type="text/css">
 body { 
 	background: url(http://mymaplist.com/img/parallax/back.png); */
 	background-color: #444; */
 	background: url(http://mymaplist.com/img/parallax/pinlayer2.png), */
 		url(http://mymaplist.com/img/parallax/pinlayer1.png), */
 		url(http://mymaplist.com/img/parallax/back.png); */
 }
</style>
</head>
<body>
	<div id="signupbox" style="margin-top: 50px"
		class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
		<div class="panel panel-info">
			<nav class="navbar navbar-default" role="navigation">
			<ul class="nav navbar-nav">
				<li><a href="/ecommerceapp/welcomeSupplier.htm">Home</a></li>
				<li><a href="/ecommerceapp/addProduct.htm">Add Products</a></li>
				<li ><a>View Products</a></li>
				<li><a >Update Products</a></li>
				<li><a  class="btn btn-primary"href="<c:url value='/j_spring_security_logout'/>">Logout</a></li>
			</ul>
			</nav>
			<div class="panel-body">
				<table class="table table-striped table-hover ">
					<thead>
						<tr>
							<th>#</th>
							<th>Product Name</th>
							<th>Price</th>
							<th>Availability</th>
							<th>Description</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="product" items="${products}">
							<tr class="info">
								<td>${product.productId}</td>
								<td><a href="/ecommerceapp/updateProduct.htm?productId=${product.productId}">${product.name}</a></td>
								<td>${product.price}</td>
								<td>${product.availability}</td>
								<td>${product.description}</td>
							</tr>
							</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>
