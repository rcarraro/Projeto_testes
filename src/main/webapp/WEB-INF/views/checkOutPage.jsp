<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
				<a class="brand" href="/ecommerceapp/storeHome.htm">MY ECOMMERCE SITE</a>
			</div>
		</div>
	</div>
	<div class="container">
		<div class="row">
			<div class="span12">
				<h2>Checkout Process</h2>
				<div class="accordion" id="accordion2">
					<div class="accordion-group">
						<div class="accordion-heading">
							<a class="accordion-toggle" data-toggle="collapse"
								data-parent="#accordion2" href="#collapseOne"> STEP 1: Check
								Order </a>
						</div>
						<div id="collapseOne" class="accordion-body collapse">
							<div class="accordion-inner">
								<table class="table table-striped table-hover">
									<thead>
										<tr>
											<th>Item Name</th>
											<th>Qty</th>
											<th>Unit Price</th>
											<th>Total</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="cartItem" items="${customer.cartItems}">
											<tr>
												<td>${cartItem.productBean.name}</td>
												<td>${cartItem.quantity}</td>
												<td>$${cartItem.productBean.price}</td>
												<td>$${cartItem.price}</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>

								<dl class="dl-horizontal pull-right">
									<dt>Sub-total:</dt>
									<dd>$${price}</dd>

									<dt>Tax:</dt>
									<dd>$${tax}</dd>

									<dt>Total:</dt>
									<dd>$${totalPrice}</dd>
								</dl>
								<div class="clearfix"></div>
								<form>
									<a class="btn btn-primary" class="accordion-toggle"
										data-toggle="collapse" data-parent="#accordion2"
										href="#collapseTwo">Continue</a>
								</form>

							</div>
						</div>
					</div>

					<div class="accordion-group">
						<div class="accordion-heading">
							<a class="accordion-toggle" data-toggle="collapse"
								data-parent="#accordion2" href="#collapseTwo"> STEP 2: Make
								Payment using credit card </a>
						</div>
						<div id="collapseTwo" class="accordion-body collapse">
							<div class="accordion-inner">
								<form:form id="form" class="form-horizontal" role="form"
									commandName="paymentBean">

									<label> Card Number:</label>
									<form:input type="text" class="large-field" value=""
										name="cardNumber" path="cardNumber"></form:input>
									<label> Name on Card:</label>
									<form:input type="text" class="large-field" value=""
										name="name" path="name"></form:input>
									<label>Expiry Month:</label>
									<form:input type="text" class="large-field" value=""
										name="expiryMonth" path="expiryMonth"></form:input>
									<label> Expiry Year:</label>
									<form:input type="text" class="large-field" value=""
										name="expiryYear" path="expiryYear"></form:input>
									<label> CVV:</label>
									<form:input type="text" class="large-field" value="" name="cvv"
										path="cvv"></form:input>
									<label>Billing Zip:</label>
									<form:input type="text" class="large-field" value="" name="zip"
										path="zip"></form:input>
									<br />
									<button type="submit" class="btn btn-success pull-right">Make
										Payment</button>
								</form:form>

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
					<i class="icon-map-marker"></i>&nbsp;15 shepherd ave, Boston, MA, USA, 02215
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
</body>
</html>