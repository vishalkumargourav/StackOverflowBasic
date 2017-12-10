<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<!-- Bootstrap Core CSS -->
<spring:url
	value="/resources/bootstrap-3.3.0/dist/css/bootstrap.min.css"
	var="mainCss" />
<link href="${mainCss}" rel="stylesheet" />

<!-- Bootstrap Core JS -->
<spring:url
    value="/resources/bootstrap-3.3.0/dist/js/bootstrap.min.js"
    var="mainJs" />
<script src="${mainJs}" type="text/javascript"></script>


<!-- Stylesheets -->
<spring:url
    value="/resources/css/login.css"
    var="loginCss" />
<link href="${loginCss}" rel="stylesheet" />



<!--  Javascript -->
<spring:url
    value="/resources/js/login.js"
    var="loginJs" />
<script src="${loginJs}" type="text/javascript"></script>


<!-- End of resources -->
<title>ArcTrace Login</title>
</head>

<body>
	<div class="container">
		<div class="row">
			<div class="col-md-6 col-md-offset-3">
				<div class="panel panel-login">
					<div class="panel-heading">
						<div class="row">
							<div class="col-xs-6">
								<a href="#" class="active" id="login-form-link">Login</a>
							</div>
							<div class="col-xs-6">
								<a href="signup.htm" id="register-form-link">Register</a>
							</div>
						</div>
						<hr>
					</div>
					<div class="panel-body">
						<div class="row">
							<div class="col-lg-12">
								<f:form id="login-form" role="form" style="display: block;"
									action="loginCheck.htm" method="POST" commandName="userCommand">
									<div class="form-group">
										<f:input type="text" id="username" path="emailHash"
											tabindex="1" class="form-control" placeholder="Username" />
									</div>
									<div class="form-group">
										<f:input type="password" path="password" id="password"
											tabindex="2" class="form-control" placeholder="Password" />
									</div>
									<div class="form-group">
										<div class="row">
											<div class="col-sm-6 col-sm-offset-3">
												<input type="submit" name="login-submit" id="login-submit"
													tabindex="4" class="form-control btn btn-login"
													value="Log In">
											</div>
										</div>
										<div>
											<font color="red"> <span>${credError}</span></font>
										</div>
									</div>
								</f:form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>