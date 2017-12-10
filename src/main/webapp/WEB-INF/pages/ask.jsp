<%@include file="common/header.jsp" %>
    <section>
      <div class="container">
        <div class="row">
            <div class="panel panel-default">
              <div class="panel-heading">
                <h3 class="panel-title">Does your question already exist?</h3>
              </div>
              <div>
                    <p>The last thing you would want to do is to repeat already
                    answered question!<br>
                    We recommend that you search once again if your question has already been
                    asked before.</p>
              </div>

              <div class="panel-body">
                <f:form method="POST" action="searchQuestion.htm" id="search" commandName="postCommand">
                  <div class="form-group">
                    <f:textarea class="form-control" name = "q" placeholder="Write your question here" path="title" required="true"></f:textarea>
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
                <h3 class="panel-title">Ask your question if its new!</h3>
              </div>

              <div class="panel-body">
                <f:form action="askQuestionSave.htm" method="POST" commandName="postCommand" id="search">
                    <div class="form-group"><f:textarea class="form-control" name = "q" placeholder="Your question in one sentence" path="title" required="true"></f:textarea></div>
                    <div class="form-group"><f:textarea path="description" class="form-control" name = "q" placeholder="Description" required="true"></f:textarea></div>
                    <div class="form-group"><f:textarea class="form-control" name = "q" placeholder="Tags (semicolon separated) to make search easy" path="tags" required="true"></f:textarea></div>
                    <button type="submit" class="btn btn-default">Shoot!</button>
                </f:form>
              </div>
            </div>
        </div>
      </div>
    </section>
<%@include file="common/footer.jsp" %>