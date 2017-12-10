<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<title>ArcTrace - One stop solution</title>

<spring:url value="/resources/css/footer.css" var="footerCss" />
<link href="${footerCss}" rel="stylesheet" />

<spring:url value="/resources/bootstrap-3.3.0/dist/css/bootstrap.css"
	var="mainCss" />
<link href="${mainCss}" rel="stylesheet" />
<spring:url value="/resources/css/style.css" var="secondaryCss" />
<link href="${secondaryCss}" rel="stylesheet" />
<spring:url value="/resources/bootstrap-3.3.0/dist/css/font-awesome.css"
	var="thirdCss" />
<link href="${thirdCss}" rel="stylesheet" />
<style>
input[type=text] {
	width: 130px;
	box-sizing: border-box;
	border: 2px solid #ccc;
	border-radius: 4px;
	font-size: 16px;
	background-color: white;
	background-image: url('searchicon.png');
	background-position: 10px 10px;
	background-repeat: no-repeat;
	padding: 12px 20px 12px 40px;
	-webkit-transition: width 0.4s ease-in-out;
	transition: width 0.4s ease-in-out;
}

input[type=text]:focus {
	width: 100%;
}
</style>
<style>
.my_text {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 30px;
	font-weight: bold;
}
</style>
<style>
body {
	margin: 0;
	padding: 0;
}
</style>
</head>
<body>
	<div class="panel-heading" width="100%">
		<h3 class="my_text">ArcTrace</h3>
	</div>
	<nav class="navbar navbar-default">
		<div class="container">

			<div class="navbar-header">

				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
			</div>
			<div id="navbar" class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li class="active"><a href="backHome.htm">Home</a></li>
					<li><a href="ask.htm">Ask Question</a></li>
					<li><a href="yourQuestions.htm">Your Questions</a></li>
					<!-- <li><a href="groups.html">Groups</a></li>
					<li><a href="photos.html">Photos</a></li>
					<li><a href="profile.html">Profile</a></li> -->
				</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
	</nav>
	<section>
		<div class="container">
			<div class="row">
				<div class="col-md-8">
					<div class="panel panel-default">
						<div class="panel-heading">
							<h3 class="panel-title">Search</h3>
						</div>
						<div class="panel-body">
							<f:form method="POST" action="searchQuestion.htm" id="search"
								commandName="postCommand">
								<div class="form-group">
									<f:textarea class="form-control" name="q"
										placeholder="Write your question here" path="title"
										required="true"></f:textarea>
								</div>
								<button type="submit" class="btn btn-default">Search</button>
							</f:form>
						</div>
					</div>
					<div class="panel-heading">
						<h3 class="panel-title">Top Un-Answered</h3>
					</div>
					<c:forEach var="post" items="${topPostsUnAnswered}">
						<div class="panel panel-default post">
							<div class="panel-body">
								<div class="row">
									<div class="col-sm-2">
										<a href="profile.html" class="post-avatar thumbnail"><img
											src="img/user.png" alt="">
											<div class="text-center">${post.ownerDisplayName}</div></a>
										<div class="likes text-center">${post.score}</div>
									</div>
									<div class="col-sm-10">
										<div class="bubble">
											<div class="pointer">
												<strong><p>
														<a href="viewPost.htm?postId=${post.postId}">${post.title}</a>
													</p></strong> <br />
												<p>${post.description}</p>
											</div>
											<div class="pointer-border"></div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
				<div class="col-md-4">
					<div class="panel panel-default friends">
						<div class="panel-heading">
							<h3 class="panel-title">Top answers</h3>
						</div>
						<div class="panel-body">
							<ol>
								<c:forEach var="post" items="${topPosts}">
									<li><a href="viewPost.htm?postId=${post.postId}">${post.title}</a><br />----------<br /></li>
								</c:forEach>
							</ol>
							<div class="clearfix"></div>
						</div>
					</div>

				</div>
			</div>
		</div>
	</section>
	<footer class="footer1">
		<div class="container">
			<p>ArcTrace Copyright &copy, 2017</p>
		</div>
	</footer>
	<spring:url value="/resources/js/jquery.min.js" var="jqueryJs" />
	<script src="${jqueryJs}" type="text/javascript"></script>

	<spring:url value="/resources/bootstrap-3.3.0/dist/js/bootstrap.js"
		var="bootJs" />
	<script src="${bootJs}" type="text/javascript"></script>
</body>
</html>