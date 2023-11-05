<%@page import="com.finalproject.ecommerceapp.pojos.ProductBean"%>
<%@page import="com.finalproject.ecommerceapp.pojos.CategoryBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	//get the category list
// 	com.finalproject.ecommerceapp.dao.CategoryDao categorydao = new com.finalproject.ecommerceapp.dao.CategoryDao();
//  	java.util.List<CategoryBean> categoryList = categorydao.list();
//  	pageContext.setAttribute("categories", categoryList);

// 	//get the product list
// 	com.finalproject.ecommerceapp.dao.ProductDao productDao = new com.finalproject.ecommerceapp.dao.ProductDao();
//  	java.util.List<ProductBean> productList = productDao.list();
//  	pageContext.setAttribute("products", productList);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>E-Commerce Site</title>
<link rel="icon" type="image/png"
	href="http://www.beerwear.net/images/icon_cart.png" />
<!-- JQUERY -->
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jqueryui/1/jquery-ui.min.js"></script>
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.8.18/jquery-ui.min.js"></script>
<!-- Included Bootstrap CSS Files -->
<link rel="stylesheet"
	href="<c:url value="/resources/bootstrap/js/bootstrap/css/bootstrap.min.css"/>" />
<link rel="stylesheet"
	href="<c:url value="/resources/bootstrap/js/bootstrap/css/bootstrap-responsive.min.css"/>" />

<!-- Includes FontAwesome -->
<link rel="stylesheet"
	href="<c:url value="/resources/bootstrap/css/font-awesome/css/font-awesome.min.css"/>" />

<!-- Css -->
<link rel="stylesheet"
	href="<c:url value="/resources/bootstrap/css/style.css" />" />
<style type="text/css">
.thumbnail {
	border: 0 none;
	box-shadow: none;
}
</style>
</head>
<body>
	<div class="navbar navbar-inverse navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container">
				<button class="btn btn-navbar" data-target=".nav-collapse"
					data-toggle="collapse" type="button">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="brand" href="/ecommerceapp/storeHome.htm">MY ECOMMERCE
					SITE</a>
					
				<div class="nav-collapse collapse">
					<form class="navbar-form form-search pull-right"
						action="/ecommerceapp/searchResults.htm?searchKey='searchKey'">
						<input id="searchKey" name="searchKey" type="text"
							placeholder="type text to search for"
							class="input-medium search-query">
						<button type="submit" class="btn">Search</button>
					</form>
				</div>
			</div>
		</div>
	</div>

	<div class="container">
		<div class="row">
			<div class="span3">
				<div class="well">
					<ul class="nav nav-list">
						<li class="nav-header"><h4>WELCOME
								${customer.customerfirstname}</h4></li>
								<li><a  class="btn btn-primary"href="<c:url value='/j_spring_security_logout'/>">Logout</a></li>
					</ul>
				</div>
				
				<div class="well">
					<ul class="nav nav-list">
						<li class="nav-header">Category</li>
						<c:forEach var="category" items="${categories}">
							<li><a
								href="/ecommerceapp/categoryOption.htm?categoryChoice=${category.category}">${category.category}</a></li>
						</c:forEach>
					</ul>
				</div>
				<div class="well">

					<div class="dropdown">
						<a class="dropdown-toggle" data-toggle="dropdown" href="#"> <i
							class="icon-shopping-cart"></i> Cart Items <b class="caret"></b></a>
						</a>
						<div class="dropdown-menu well" role="menu"
							aria-labelledby="dLabel">
							<c:forEach var="cartItem" items="${customer.cartItems}">
								<p>
									${cartItem.productBean.name} <span class="pull-right">$${cartItem.productBean.price}</span>
								</p>
							</c:forEach> <a
								href="/ecommerceapp/cart.htm" class="btn btn-primary">View
								Cart</a>

						</div>
					</div>

				</div>
<!-- 				<div align="right"> -->
<%-- 				<li><a  class="btn btn-primary"href="<c:url value='/j_spring_security_logout'/>">Logout</a></li> --%>
<!-- 				</div> -->

			</div>

			<div class="span9">

				<div id="carousel-example-generic" class="carousel slide">
					<!-- Indicators -->
					<ol class="carousel-indicators">
						<li data-target="#carousel-example-generic" data-slide-to="0"
							class="active"></li>
						<li data-target="#carousel-example-generic" data-slide-to="1"></li>
						<li data-target="#carousel-example-generic" data-slide-to="2"></li>
					</ol>

					<!-- Wrapper for slides -->
					<div class="carousel-inner">
						<div class="item active">
							<img src="http://i58.tinypic.com/k2kb55.jpg" alt="">
							<div class="carousel-caption">Samsung Tab</div>
						</div>
						<div class="item">
							<img src="http://i62.tinypic.com/4gitd1.jpg" alt="">
							<div class="carousel-caption">Hp Notbooks</div>
						</div>
						<div class="item">
							<img src="http://i58.tinypic.com/fxdqme.jpg" alt="">
							<div class="carousel-caption">Nikon Cameras</div>
						</div>
					</div>
					<div id="tooltips">
						<ul class="thumbnails">
							<c:forEach var="product" items="${products}">
								<li class="span3">
									<div class="thumbnail">

										<img style="width: 300px; height: 200px;"
											class="img-responsive"
											src="${product.productPictureUrlString}" alt="" id="popover"
											rel="popover" data-content="${product.description}"
											title="${product.name}">
										<div class="caption">
											<h4 style:"color=black;">${product.name}</h4>
											<p>${product.price}$</p>
											<a class="btn btn-primary"
												href="/ecommerceapp/productDetails.htm?productId=${product.productId}">View</a>
											<a class="btn btn-success"
												href="/ecommerceapp/addToCart.htm?prodID=${product.productId}">Add
												to Cart</a>
										</div>
									</div>
								</li>
							</c:forEach>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>

	<hr />

	<footer id="footer" class="vspace20">
	<div class="container">
		<div class="row">
			<div class="span4">
				<h4>Info</h4>
				<ul class="nav nav-stacked">
					<li><a href="#">Sell Conditions</a>
					<li><a href="#">Shipping Costs</a>
					<li><a href="#">Shipping Conditions</a>
					<li><a href="#">Returns</a>
					<li><a href="#">About Us</a>
				</ul>
			</div>

			<div class="span4">
				<h4>Location and Contacts</h4>
				<p>
					<i class="icon-map-marker"></i>&nbsp;15 shepherd ave, Boston, MA, USA, 02215
				</p>
				<p>
					<i class="icon-phone"></i>&nbsp;Phone: 617 372 1284
				</p>
	
				<p>
					<i class="icon-envelope"></i>&nbsp;Email: singh.si@husky.neu.edu
				</p>
				<p>
					<i class="icon-globe"></i>&nbsp;Web: http://www.mydomain.com
				</p>
			</div>

			<div class="span4">
				<h4>Newsletter</h4>
				<p>Write you email to subscribe to our Newsletter service.
					Thanks!</p>
				<form class="form-newsletter">
					<div class="input-append">
						<input type="email" class="span2" placeholder="your email">
						<button type="submit" class="btn">Subscribe</button>
					</div>
				</form>
			</div>
		</div>

		<div class="row">
			<div class="span6">
				<p>
					&copy; Copyright 2015.&nbsp;<a href="#">Privacy</a>&nbsp;&amp;&nbsp;<a
						href="#">Terms and Conditions</a>
				</p>
			</div>
			<div class="span6">
				<a class="pull-right" href="http://www.neu.edu"
					target="_blank">credits by Web Tools</a>
			</div>
		</div>
	</div>
	</footer>

	<script
		src="<c:url value="/resources/bootstrap/js/jquery-1.10.0.min.js"/>"></script>
	<script
		src="<c:url value="/resources/bootstrap/js/bootstrap/js/bootstrap.min.js"/>"></script>
	<script src="<c:url value="/resources/bootstrap/js/holder.js"/>"></script>
	<script src="<c:url value="/resources/bootstrap/js/script.js"/>"></script>
	<script type="text/javascript">
 		var searchKey = document.getElementById('Search').value;
	</script>
	<script>
 		$(function() {
 			$("#tooltips #popover").popover();

 		});
	</script>
	<script type="text/javascript">
 		$(document)
 				.ready(
 						function() {
 							$('#searchKey')
 									.autocomplete(
 											{
 												serviceUrl : '${pageContext.request.contextPath}/getProducts',
 												paramName : "productName",
 												delimiter : ",",
 												transformResult : function(
 														response) {
 													return {
 														//must convert json to javascript object before process
 														suggestions : $
 																.map(
 																		$
 																				.parseJSON(response),
 																		function(
 																				item) {
 																			return {
 																				value : item.name,
 																				data : item.productId

 																			};
 																		})
 													};
 												}
 											});
 						});
	</script>
</body>
</html>