<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="tab" uri="http://ditchnet.org/jsp-tabs-taglib"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Login</title>
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
	<div class="container">
		<div id="loginbox" style="margin-top: 50px;"
			class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
			<div class="panel panel-info">
				<div class="panel-heading">
					<div class="panel-title">Sign In</div>
<!-- 					<div -->
<!-- 						style="float: right; font-size: 80%; position: relative; top: -10px"> -->
<!-- 						<a href="#">Forgot password?</a> -->
<!-- 					</div> -->
				</div>

				<div style="padding-top: 30px" class="panel-body">

					<div style="display: none" id="login-alert"
						class="alert alert-danger col-sm-12"></div>

 					<form id="loginform" method="POST" action="<c:url value='/j_spring_security_check'/>" class="form-horizontal">
 						<div style="margin-bottom: 25px" class="input-group">
 						     <span class="input-group-addon">
 						   			<i class="glyphicon glyphicon-user"></i></span>
 									<input id="login-username" type="text" name="username" class="form-control" />
 						</div>
 						
 						<div style="margin-bottom: 25px" class="input-group">
 							<span class="input-group-addon">
 							<i class="glyphicon glyphicon-lock"></i></span>
							<input id="login-password" type="password" name="password" class="form-control" /> 
 						</div>
 						
<!--  						<input id="btn-login" type="submit" value="Signin" class="btn btn-success" />  -->
 						
 						
 						
 						
<%--  						<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" /> --%>
<%--  								name="username" value="" placeholder="username" path="username" /> --%> 
<%-- 						commandName="userLogin"> --%>

<!-- 						<div style="margin-bottom: 25px" class="input-group"> -->
<!-- 							<span class="input-group-addon"><i -->
<!-- 								class="glyphicon glyphicon-user"></i></span> -->
<%-- 							<form:input id="login-username" type="text" class="form-control" --%> 
<%--  								name="username" value="" placeholder="username" path="username" /> --%> 
<!-- 						</div> -->

<!-- 						<div style="margin-bottom: 25px" class="input-group"> -->
<!-- 							<span class="input-group-addon"><i -->
<!-- 								class="glyphicon glyphicon-lock"></i></span> -->
<%-- 							<form:input id="login-password" type="password" --%>
<%-- 								class="form-control" name="password" placeholder="password" --%>
<%-- 								path="password" /> --%>
<!-- 						</div> -->
<!-- 						<div class="input-group"> -->
<!-- 							<div class="checkbox"> -->
<!-- 								<label> <input id="login-remember" type="checkbox" -->
<!-- 									name="remember" value="1"> Remember me -->
<!-- 								</label> -->
<!-- 							</div> -->
<!-- 						</div> -->


						<div style="margin-top: 10px" class="form-group">
<!--Button -->

							<div class="col-sm-12 controls">
								<a id="btn-login" href="#" class="btn btn-success"><input
									type="submit" value="Login" style="color: green;"></a>

							</div>
						</div>


						<div class="form-group">
							<div class="col-md-12 control">
								<div
									style="border-top: 1px solid #888; padding-top: 15px; font-size: 85%">
									Don't have an account! <a href="registration.htm">
										Sign Up Here </a>
								</div>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>