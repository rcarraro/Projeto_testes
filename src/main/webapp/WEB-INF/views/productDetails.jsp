<%@page import="com.finalproject.ecommerceapp.pojos.ProductBean"%>
<%@page import="com.finalproject.ecommerceapp.pojos.CategoryBean"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	//get the product list
	com.finalproject.ecommerceapp.dao.ProductDao productDao = new com.finalproject.ecommerceapp.dao.ProductDao();
	java.util.List<ProductBean> productList = productDao.list();
	pageContext.setAttribute("products", productList);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MY ECOMMERCE SITE: ${product.name}</title>
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
<link rel="shortcut icon" type="image/x-icon" href="favicon.ico" />
<style type="text/css">
</style>

</head>
<body>

	<div class="navbar navbar-inverse navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container">
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
							</c:forEach>
							 <a
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
					</ul>
				</div>
				
			</div>

			<div class="span9">
				<div class="row">
					<div class="span5">
						<div id="items-carousel" class="carousel slide mbottom0">
							<div class="carousel-inner">
								<div class="active item">
									<img class="media-object"
										src="${product.productPictureUrlString}" alt="" />
								</div>
							</div>

						</div>
					</div>

					<div class="span4">
						<div class="well">
							<form>
								<h4>Item Brand and Category</h4>
								<h5>${product.name}</h5>
								<p>${product.description}</p>
								<h4>${product.price}$</h4>
								<a
									href="/ecommerceapp/addToCart.htm?prodID=${product.productId}"
									class="btn btn-primary">Add to Cart</a>
							</form>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="span9">
						<div class="container">
							<div class="span9">
								<ul class="nav nav-tabs">
									<li class="active"><a href="#description"
										data-toggle="tab">Description</a></li>
									<li><a href="#reviews" data-toggle="tab">Reviews</a></li>
									<li><a href="#writereview" data-toggle="tab">Write
											Review</a></li>
								</ul>
							</div>
							<div class="span9">
								<div class="well">
									<div class="tab-content">
										<div class="tab-pane active" id="description">
											<h4>Description</h4>
											<p>${product.description}</p>
										</div>
										<div class="tab-pane" id="reviews">
											<h4>Reviews</h4>

											<table class="table table-striped table-hover ">
												<thead>
													<tr>
														<th>#</th>
														<th>Customer Name</th>
														<th>Review</th>
													</tr>
												</thead>
												<tbody>
													<c:forEach var="review" items="${product.reviews}">
														<tr class="info">
															<td>${review.reviewId}</td>
															<td>${review.customerBean.customerfirstname}</td>
															<td>${review.review}</td>
														</tr>
													</c:forEach>
												</tbody>
											</table>

										</div>
										<div class="tab-pane" id="writereview">
											<form:form class="form-horizontal" commandName="reviewBean">
												<fieldset>
													<div class="form-group">
														<h4>Write a review</h4>
														<div class="col-lg-10">
															<form:textarea class="form-control" rows="3" cols="50"
																id="textArea" placeholder="Product Review" path="review" />
														</div>
													</div>
													<br />
													<div class="form-group" align="left">
														<button id="btn-signup" type="submit" class="btn btn-info">
															<i class="icon-hand-right"></i>Add Review
														</button>

													</div>
												</fieldset>
											</form:form>
										</div>
									</div>
								</div>
							</div>
						</div>
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
</body>
</html>