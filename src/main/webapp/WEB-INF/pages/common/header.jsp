<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<style>
.my_text {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 30px;
	font-weight: bold;
}
</style>

<!-- Bootstrap Core CSS -->
<spring:url
	value="/resources/bootstrap-3.3.0/dist/css/bootstrap.min.css"
	var="mainCss" />
<link href="${mainCss}" rel="stylesheet" />

<!-- Stylesheets -->
<spring:url value="/resources/css/style.css" var="styleCss" />
<link href="${styleCss}" rel="stylesheet" />

<spring:url value="/resources/css/footer.css" var="footerCss" />
<link href="${footerCss}" rel="stylesheet" />

<div class="panel-heading" width="100%">
	<h3 class="my_text">ArcTrace</h3>
</div>

<nav class="navbar navbar-default">
	<div class="container">
		<div id="navbar" class="collapse navbar-collapse">
			<ul class="nav navbar-nav">
				<li><a href="backHome.htm">Home</a></li>
				<li><a href="ask.htm">Ask Question</a></li>
				<li><a href="yourQuestions.htm">Your Questions</a></li>
				<!-- <li><a href="contact.html">Contact</a></li>
            <li><a href="groups.html">Groups</a></li>
            <li><a href="photos.html">Photos</a></li>
            <li><a href="profile.html">Profile</a></li> -->
			</ul>
		</div>
		<!--/.nav-collapse -->
	</div>
</nav>