<%@include file="common/header.jsp"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<section>
	<div class="container">
		<div class="row">
			<div class="panel panel-default">
				<div class="panel-body">
					<f:form method="POST" action="searchQuestion.htm" id="search"
						commandName="postCommand">
						<div class="form-group">
							<f:textarea class="form-control" name="q"
								placeholder="Search Again" path="title" required="true"></f:textarea>
						</div>
						<button type="submit" class="btn btn-default">Search</button>
					</f:form>
				</div>
			</div>
		</div>
	</div>
</section>

<section>
	<div class="container">
		<div class="row">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title">Search Results</h3>
				</div>

				<div class="panel-body">
					<c:set var="count_i" value="0" scope="page" />
					<ul>
						<c:forEach var="searchResult" items="${searchResultsList}">
							<li class="comment"><strong><a
									href="viewPost.htm?postId=${searchResult.postId}">&nbsp;-&nbsp;${searchResult.title}</a></strong><br />
								${searchResult.description}</li>
							<c:set var="count_i" value="${count_i + 1}" scope="page" />
						</c:forEach>
					</ul>
				</div>
			</div>
		</div>
	</div>
</section>

<%@include file="common/footer.jsp"%>