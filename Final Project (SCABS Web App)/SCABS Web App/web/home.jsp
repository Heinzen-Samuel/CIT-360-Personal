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
            <form action="calories.jsp">
                <input type="submit" value="Record Calories" />
            </form>
            <form action="capture_load.jsp">
                <input type="submit" value="Capture a Scab!" />
            </form>
            <form action="showScabs" method="POST">
                <input type="submit" value="View Captured Scabs">
            </form>
            <form action="logout" method="POST">
                <input type="submit" value="Logout">
            </form>
        </h1>
    </div>

    </body>
</html>
