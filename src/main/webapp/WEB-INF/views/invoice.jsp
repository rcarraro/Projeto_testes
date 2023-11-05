<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Order Placed Successfully</title>
</head>
<body>
	
	
	Order Details : ${order.orderID}
	
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
						<c:forEach var="cartItem" items="${order.items}">
						<tr>
							<td>${cartItem.product.name}</td>
							<td>${cartItem.quantity}</td>
							<td>$${cartItem.product.price}</td>
							<td>$${cartItem.price}
							&nbsp;&nbsp;<a href="/spring/updateCart.htm?cartItemId=${cartItem.id}"><i class="icon-trash"></i></a></td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
</body>
</html>