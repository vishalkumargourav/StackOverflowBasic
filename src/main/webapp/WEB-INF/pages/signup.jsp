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
<spring:url value="/resources/bootstrap-3.3.0/dist/js/bootstrap.min.js"
	var="mainJs" />
<script src="${mainJs}" type="text/javascript"></script>


<!-- Stylesheets -->
<spring:url value="/resources/css/login.css" var="loginCss" />
<link href="${loginCss}" rel="stylesheet" />



<!--  Javascript -->
<spring:url value="/resources/js/login.js" var="loginJs" />
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
								<a href="login.htm" id="login-form-link">Login</a>
							</div>
							<div class="col-xs-6">
								<a href="#" class="active" id="register-form-link">Register</a>
							</div>
						</div>
						<hr>
					</div>
					<div class="panel-body">
						<div class="row">
							<div class="col-lg-12">
								<f:form id="signup-form" role="form" style="display: block;"
									action="signupSave.htm" method="POST" commandName="userCommand">
									<div class="form-group">
										<f:input type="text" id="displayName" path="displayName"
											tabindex="1" class="form-control"
											placeholder="Your name buddy" required="true" />
									</div>
									<div class="form-group">
										<f:input type="email" id="emailHash" path="emailHash"
											tabindex="1" class="form-control" placeholder="Enter Email"
											required="true" />
									</div>
									<div class="form-group">
										<f:input type="text" id="websiteUrl" path="websiteUrl"
											tabindex="1" class="form-control" placeholder="Your Website"
											required="true" />
									</div>
									<div class="form-group">
										<f:input type="text" id="location" path="location"
											tabindex="1" class="form-control"
											placeholder="Department(Tech/Services)" required="true" />
									</div>
									<div class="form-group">
										<f:input type="text" id="aboutMe" path="aboutMe" tabindex="1"
											class="form-control" placeholder="About You" required="true" />
									</div>
									<%-- <div class="form-group">
										<f:input type="text" id="profileImageUrl"
											path="profileImageUrl" tabindex="1" class="form-control"
											placeholder="Your Image URL" required="true" />
									</div> --%>
									<%-- <div class="form-group">
										<f:input type="text" id="age" path="age" tabindex="1"
											class="form-control" placeholder="Your Age" required="true" />
									</div> --%>
									<div class="form-group">
										<f:input type="password" id="password" path="password"
											tabindex="1" class="form-control"
											placeholder="Enter Password" required="true" />
									</div>
									<div class="form-group">
										<input type="password" id="password" tabindex="1"
											class="form-control" placeholder="Re-Enter Password"
											required="true" />
									</div>

									<div class="form-group">
										<div class="row">
											<div class="col-sm-6 col-sm-offset-3">
												<input type="submit" name="register-submit"
													id="register-submit" tabindex="4"
													class="form-control btn btn-login" value="Register Now">
											</div>
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