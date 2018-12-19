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

            <% if(request.getAttribute("scab0name") != null) { %>
            <div class="container" id="scab-pick">
                <div class="row">
                    <div class="col-md-4">
                        <div class="bg-info mr-md-2">
                            <img src="assets/img/scabs/<%= request.getAttribute("scab0name") %>.png"
                                 alt="<%= request.getAttribute("scab0name") %>" style="width:100%">
                            <h1><%= request.getAttribute("scab0name") %></h1>
                            <h2>Strength: <%= request.getAttribute("scab0str") %><br>
                                Luck: <%= request.getAttribute("scab0luck") %></h2>
                            <form action="catchScab" method="POST">
                                <input type="hidden" name="scabName" value="<%= request.getAttribute("scab0name") %>">
                                <input type="hidden" name="scabStr" value="<%= request.getAttribute("scab0str") %>">
                                <input type="hidden" name="scabLuck" value="<%= request.getAttribute("scab0luck") %>">
                                <input type="submit" value="Catch"/>
                            </form>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="bg-info mr-md-2">
                            <img src="assets/img/scabs/<%= request.getAttribute("scab1name") %>.png"
                                 alt="<%= request.getAttribute("scab1name") %>" style="width:100%">
                            <h1><%= request.getAttribute("scab1name") %></h1>
                            <h2>Strength: <%= request.getAttribute("scab1str") %><br>
                                Luck: <%= request.getAttribute("scab1luck") %></h2>
                            <form action="catchScab" method="POST">
                                <input type="hidden" name="scabName" value="<%= request.getAttribute("scab1name") %>">
                                <input type="hidden" name="scabStr" value="<%= request.getAttribute("scab1str") %>">
                                <input type="hidden" name="scabLuck" value="<%= request.getAttribute("scab1luck") %>">
                                <input type="submit" value="Catch"/>
                            </form>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="bg-info mr-md-2">
                            <img src="assets/img/scabs/<%= request.getAttribute("scab2name") %>.png"
                                 alt="<%= request.getAttribute("scab2name") %>" style="width:100%">
                            <h1><%= request.getAttribute("scab2name") %></h1>
                            <h2>Strength: <%= request.getAttribute("scab2str") %><br>
                                Luck: <%= request.getAttribute("scab2luck") %></h2>
                            <form action="catchScab" method="POST">
                                <input type="hidden" name="scabName" value="<%= request.getAttribute("scab2name") %>">
                                <input type="hidden" name="scabStr" value="<%= request.getAttribute("scab2str") %>">
                                <input type="hidden" name="scabLuck" value="<%= request.getAttribute("scab2luck") %>">
                                <input type="submit" value="Catch"/>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            <% } %>
        </div>

    </body>
</html>
