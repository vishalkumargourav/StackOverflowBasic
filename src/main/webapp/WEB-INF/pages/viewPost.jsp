<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@include file="common/header.jsp"%>
<section>
	<div class="container">
		<div class="row">
			<div class="col-md-8">
				<div class="panel panel-default post">
					<div class="panel-body">
						<div class="row">
							<div class="col-sm-2">
								<a href="#" class="post-avatar thumbnail"><img
									src="img/user.png" alt="">
									<div class="text-center">${postQuest.ownerDisplayName}</div></a>
								<div class="likes text-center">${postQuest.score}&nbsp;Votes</div>
							</div>
							<div class="col-sm-10">
								<div class="bubble">
									<div class="pointer">
										<strong><p>${postQuest.title}</p></strong><br />
										<p>${postQuest.description}</p>
									</div>
									<div class="pointer-border"></div>
								</div>
								<c:set var="userId" value="${user.id}" />
								<c:set var="questionOwnerId" value="${postQuest.ownerUserId}" />

								<p class="post-actions">
									<a href="votePost.htm?postId=${postQuest.postId}&vote=1">Upvote</a>
									- <a href="votePost.htm?postId=${postQuest.postId}&vote=-1">DownVote</a>&nbsp;
									<c:choose>
										<c:when test="${userId == questionOwnerId}">
											<a href="deleteQuestion.htm?postQuestId=${postQuest.postId}">-&nbsp;Delete
												this question</a>
										</c:when>
									</c:choose>
								</p>
								<div class="comment-form">
									<f:form action="commentSave.htm?postId=${postQuest.postId}"
										method="POST" commandName="commentCommand" class="form-inline">
										<div class="form-group">
											<f:input type="text" path="text" class="form-control"
												placeholder="enter comment" />
										</div>
										<button type="submit" class="btn btn-default">Add</button>
									</f:form>
								</div>

								<div class="clearfix"></div>

								<div class="comments">
									<c:forEach var="comment" items="${allComments}">
										<div class="comment">
											<div class="comment-text">
												<p>${comment.text}</p>
											</div>
										</div>
										<div class="clearfix"></div>
									</c:forEach>
								</div>
							</div>
						</div>
					</div>
				</div>
				<c:forEach var="answer" items="${allAnswers}">
					<div class="container">
						<div class="row">
							<div class="col-md-8">
								<div class="row">
									<div class="col-sm-2">
										<a href="#" class="post-avatar thumbnail"><img
											src="img/user.png" alt="">
											<div class="text-center">${answer.ownerDisplayName}</div></a>
										<div class="likes text-center">${answer.score}&nbsp;Votes</div>
									</div>
									<div class="panel panel-default post">
										<div class="panel-body">
											<div class="row">

												<div class="col-sm-10">
													<div class="bubble">
														<div class="pointer">
															<p>${answer.description}</p>
														</div>

														<div class="pointer-border"></div>
														<c:set var="userId" value="${user.id}" />
														<c:set var="answerOwnerId" value="${answer.ownerUserId}" />
													</div>
													<p class="post-actions">
														<a
															href="voteAnswer.htm?answerPostId=${answer.postId}&vote=1">Upvote</a>
														- <a
															href="voteAnswer.htm?answerPostId=${answer.postId}&vote=-1">DownVote</a>&nbsp;
														<c:choose>
															<c:when test="${userId == answerOwnerId}">
																<td style="border-bottom: 1px solid #000;"><a
																	href="deleteAnswer.htm?answerPostId=${answer.postId}">-&nbsp;Delete
																		this answer</a></td>
															</c:when>
														</c:choose>
													</p>
													<div class="clearfix"></div>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</c:forEach>
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">Got any better answer?</h3>
					</div>
					<div class="panel-body">
						<f:form action="answerSave.htm?postId=${postQuest.postId}"
							method="POST" commandName="answerCommand">
							<div class="form-group">
								<f:textarea class="form-control" name="q"
									placeholder="Write your answer here" path="description"
									required="true"></f:textarea>
							</div>
							<button type="submit" class="btn btn-default">SHOOT</button>
						</f:form>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>




<%@include file="common/footer.jsp"%>
