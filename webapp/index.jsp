<%--
  Created by IntelliJ IDEA.
  User: Rasmus
  Date: 2020-09-25
  Time: 21:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hello, i am a Java web app!</title>
</head>
<body>
    <% if (request.getSession().getAttribute("user") != null){ %>
       <p>Hello <%= request.getSession().getAttribute("user") %>!</p>
    <% } else { %>
        <p><a href="login.jsp">Login</a></p>
    <% } %>
    <h1>Welcome to the shop!</h1>
</body>
</html>
