<%--
  Created by IntelliJ IDEA.
  User: Samuel Heinzen
  Date: 12/10/2018
  Time: 9:45 PM
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

            <form action="recordCalories" method="POST">
                <label>Input your calories for the day!</label>
                <input type="text" name="calories" required="required"> <br> <br>
                <input type="submit" value="Save Calories">
            </form>

            <form action="home.jsp">
                <input type="submit" value="Back" />
            </form>
        </h1>
    </div>

    </body>
</html>
