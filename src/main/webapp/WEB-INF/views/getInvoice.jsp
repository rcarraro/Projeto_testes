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
				<a class="brand" href="/ecommerceapp/storeHome.htm">MY ECOMMERCE
					SITE</a>
				<div class="nav-collapse collapse">

					<form class="navbar-form form-search pull-right">
						<input id="Search" name="Search" type="text"
							placeholder="type text to search for"
							class="input-medium search-query">
						<button type="submit" class="btn">Search</button>
					</form>
				</div>
			</div>
		</div>
	</div>

	<div class="container">
		<div class="span9">
			<h2>My Order</h2>
			<h4>Order was placed successfully and details below :</h4>
			<form>
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
						<c:forEach var="orderItem" items="${orderBean.orderItems}">
							<tr>
								<td>${orderItem.product.name}</td>
								<td>${orderItem.quantity}</td>
								<td>$${orderItem.product.price}</td>
								<td>$${orderItem.price}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</form>

			<dl class="dl-horizontal pull-right">
				<dt>Sub-total:</dt>
				<dd>$${orderBean.totalPrice}</dd>

				<dt>Tax:</dt>
				<dd>$${orderBean.invoiceBean.taxDue}</dd>

				<dt>Total:</dt>
				<dd>$${orderBean.invoiceBean.totalAmount}</dd>
			</dl>
			<div class="clearfix"></div>
			Order Date : ${orderBean.orderDate}
				<a href="/ecommerceapp/invoice.htm?orderID=${orderBean.orderID}" target="_blank" class="btn btn-success pull-right">Print Invoice</a>
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
					<i class="icon-map-marker"></i>&nbsp;!5 Shepherd Ave, Boston, MA, USA, 02215
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
</body>
</html>