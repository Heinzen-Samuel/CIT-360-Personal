<%--
  Created by IntelliJ IDEA.
  User: Samuel Heinzen
  Date: 12/10/2018
  Time: 8:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
      <meta charset="ISO-8859-1">
      <%@include file="commons/links.jspf"%>
    </head>

    <body>
      <%@include file="commons/scabs_logo.jspf"%>

        <div align="center">
            <h1>
                <% if(request.getAttribute("msg") != null) { %>
              <p style="color: red">
                <%= request.getAttribute("msg") %>
              </p>
                <% } %>
                <% if(request.getAttribute("msg2") != null) { %>
              <p style="color: green;">
                <%= request.getAttribute("msg2") %>
              </p>
                <% } %>

                <form action="login" method="POST">
                    <label>Username</label>
                    <input type="text" name="username" required="required"> <br> <br>
                    <label>Password</label>
                    <input type="password" name="password" required="required"> <br> <br>
                    <input type="submit" value="Login">
                </form>

                <form action="userRegistration.jsp">
                    <input type="submit" value="Create an Account!" />
                </form>

            </h1>
        </div>

    </body>
</html>
