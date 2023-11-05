<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tab" uri="http://ditchnet.org/jsp-tabs-taglib"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="com.finalproject.ecommerceapp.dao.CategoryDao"%>
<%@page import="com.finalproject.ecommerceapp.pojos.CategoryBean"%>
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
				<li class="active"><a href="/ecommerceapp/addProduct.htm">Add Product</a></li>
				<li><a href="/ecommerceapp/viewProducts.htm">View Products</a></li>
				<li class="active"><a href="/ecommerceapp/updateProduct.htm">Update Products</a></li>
				<li><a  class="btn btn-primary"href="<c:url value='/j_spring_security_logout'/>">Logout</a></li>
				
			</ul>
			</nav>
			<div class="panel-body">
				<form:form id="addproducform" class="form-horizontal" role="form"
					commandName="productBean">

					<div id="signupalert" style="display: none"
						class="alert alert-danger">
						<p>Error:</p>
						<span></span>
					</div>
					<div class="form-group">
						<label for="productname" class="col-md-3 control-label">Product
							Name</label>
						<div class="col-md-9">
							<form:input type="text" class="form-control" name="productname"
								placeholder="Product Name" path="name" />
						</div>
					</div>
					<div class="form-group">
						<label for="Price" class="col-md-3 control-label">Price</label>
						<div class="col-md-9">
							<form:input type="text" class="form-control" name="price"
								placeholder="Price(eg:0$)" path="price" />
						</div>
					</div>
					<div class="form-group">
						<label for="categpry" class="col-md-3 control-label">Category</label>
						<div class="col-md-9">
							<form:select path="CategoryBean.category" class="form-control"
								name="category">
								<c:forEach var="category" items="${categories}">
									<form:option value="${category.category}" />
								</c:forEach>
							</form:select>
						</div>
					</div>
					<div class="form-group">
						<label for="availability" class="col-md-3 control-label">Availability</label>
						<div class="col-md-9">
							<form:input type="text" class="form-control" name="availability"
								placeholder="Availability (eg: 20,30,etc)" path="availability" />
						</div>
					</div>
					<div class="form-group">
						<label for="pictureurl" class="col-md-3 control-label">Picture
							Url</label>
						<div class="col-md-9">
							<form:input type="text" class="form-control" name="country"
								placeholder="Picture URL" path="productPictureUrlString" />
						</div>
					</div>
					<div class="form-group">
						<label for="productdescription" class="col-md-3 control-label">Description</label>
						<div class="col-md-9">
							<form:input type="textarea" class="form-control"
								name="description" placeholder="Product Description"
								path="description" />
						</div>
					</div>
					<div class="form-group">
						<!-- Button -->
						<div class="col-md-offset-3 col-md-9" align="right">
							<button id="btn-signup" type="submit" class="btn btn-info">
								<i class="icon-hand-right"></i>Add Product
							</button>
						</div>
					</div>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>
