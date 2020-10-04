<%@ page import="java.util.Collection" %>
<%@ page import="Entities.Product" %>
<%@ page import="java.util.ArrayList" %><%--
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
<h1>Welcome to the shop!</h1>
    <% if (request.getSession().getAttribute("username") != null){ %>
       <p>Hello <%= request.getSession().getAttribute("username") %>! (<a href="./logout">Logout</a> )</p>
        <p>Token: <%=request.getSession().getAttribute("token")%></p>
        <p>Username: <%=request.getSession().getAttribute("username")%></p>
        <p>Role: <%=request.getSession().getAttribute("role")%></p>
    <% } else { %>
        <p><a href="login.jsp">Login</a></p>
    <% } %>

<form action="./product">
    <input type="submit" value="Get products">
</form>


</body>
</html>
