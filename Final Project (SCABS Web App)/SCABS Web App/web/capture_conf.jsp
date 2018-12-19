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
        <meta name="viewport" content="width=device-width, initial-scale=1">
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
            </h1>

            <div class="container" id="scab-conf">
                <div class="col-md-4">
                    <div class="bg-info mr-md-2">
                        <img src="assets/img/scabs/<%= request.getAttribute("confScabName") %>.png"
                             alt="<%= request.getAttribute("confScabName") %>" style="width:100%">
                        <h1><%= request.getAttribute("confScabName") %></h1>
                        <h2>Strength: <%= request.getAttribute("confScabStr") %><br>
                            Luck: <%= request.getAttribute("confScabLuck") %></h2>
                    </div>
                </div>
            </div>

            <form action="home.jsp">
                <input type="submit" value="Home" />
            </form>
        </div>

    </body>
</html>
