<%--
  Created by IntelliJ IDEA.
  User: Samuel Heinzen
  Date: 11/2/2018
  Time: 7:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <%@include file="header.html"%>
  </head>
  <body>
    <%@include file="jumbotron.html"%>

    <div class="container">
        <h4 class="rcorners1">It cannot be seen, cannot be felt,<br>
            Cannot be heard, cannot be smelt.<br>
            It lies behind stars and under hills,<br>
            And empty holes it fills.<br>
            It comes out first and follows after,<br>
            Ends life, kills laughter.<br>
        </h4>
    </div>

  <div class="answer">
    <form name="AnswerForm" method="post" action="AnswerServlet">
      Answer: <input type="text" name="answer"/> <br/>
      <input type="submit"/>
    </form>
  </div>

  </body>
</html>
