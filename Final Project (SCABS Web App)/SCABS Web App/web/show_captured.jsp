<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.cit360projectmark4.pojo.CapturedEntity" %>
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

            <%--<c:forEach var="CapturedEntity" items="${scabList}">--%>
                <%--<c:out value="${CapturedEntity}" /><br/>--%>
            <%--</c:forEach>--%>

            <table class="container" id="scab-view">
                <thread>
                    <tr>
                        <th><h2>Scab</h2></th>
                        <th><h2>Name</h2></th>
                        <th><h2>Strength</h2></th>
                        <th><h2>Luck</h2></th>
                    </tr>
                </thread>
                <tbody>
                    <c:forEach items="${scabList}" var="element">
                        <tr>
                        <td><img src="assets/img/scabs/${element.scab}.png"
                                 alt="<%= request.getAttribute("scab0name") %>" style="width:50%"></td>
                            <td>${element.scab}</td>
                            <td>${element.capturedStr}</td>
                            <td>${element.capturedLuck}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>

            <form action="home.jsp">
                <input type="submit" value="Back" />
            </form>
        </div>

    </body>
</html>
