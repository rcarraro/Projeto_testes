<%@page import="com.finalproject.ecommerceapp.pojos.ProductBean"%>
<%@page import="com.finalproject.ecommerceapp.pojos.CategoryBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	//get the category list
	com.finalproject.ecommerceapp.dao.CategoryDao categorydao = new com.finalproject.ecommerceapp.dao.CategoryDao();
	java.util.List<CategoryBean> categoryList = categorydao.list();
	pageContext.setAttribute("categories", categoryList);

	//get the product list
	com.finalproject.ecommerceapp.dao.ProductDao productDao = new com.finalproject.ecommerceapp.dao.ProductDao();
	java.util.List<ProductBean> productList = productDao.list();
	pageContext.setAttribute("products", productList);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>E-Commerce Site</title>
<link rel="icon" type="image/png"
	href="http://www.beerwear.net/images/icon_cart.png" />
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

.pagination {
	position: absolute;
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

					<div class="dropdown">
						<a class="dropdown-toggle" data-toggle="dropdown" href="#"> <i
							class="icon-shopping-cart"></i> Cart Items <b class="caret"></b></a>
						</a>
						<div class="dropdown-menu well" role="menu"
							aria-labelledby="dLabel">
							<c:forEach var="cartItem" items="${customerBean.cartItems}">
								<p>
									${cartItem.productBean.name} <span class="pull-right">$${cartItem.productBean.price}</span>
								</p>
							</c:forEach> <a
								href="/ecommerceapp/cart.htm" class="btn btn-primary">View
								Cart</a>

						</div>
					</div>

				</div>

				<div class="well">
					<ul class="nav nav-list">
						<li class="nav-header">Category</li>
						<c:forEach var="category" items="${categories}">
							<li><a
								href="/ecommerceapp/categoryOption.htm?categoryChoice=${category.category}">${category.category}</a></li>
						</c:forEach>
						<li class="nav-header">Selected Category</li>
						<li class="active"><a>${selectedCategory}</a></li>

					</ul>
				</div>
				<div align="right">
					<li><a  class="btn btn-primary"href="<c:url value='/j_spring_security_logout'/>">Logout</a></li>
				</div>
			</div>
			<div class="span9">
				<div id="tooltips">
					<ul class="thumbnails">
						<c:forEach var="product" items="${searchList}">
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
										<a href="/ecommerceapp/addToCart.htm?prodID=${product.productId}"
									class="btn btn-primary">Add to Cart</a>
									</div>
								</div>
							</li>
						</c:forEach>
					</ul>
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
					<i class="icon-map-marker"></i>&nbsp;15 Shepherd Ave, Boston, MA, USA, 02215
				</p>
				<p>
					<i class="icon-phone"></i>&nbsp;Phone: 607 542 6682
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
					&copy; Copyright 2014.&nbsp;<a href="#">Privacy</a>&nbsp;&amp;&nbsp;<a
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

</body>
</html>