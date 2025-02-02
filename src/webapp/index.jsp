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
<h1>Welcome to the shop!</h1>
    <% if (request.getSession().getAttribute("username") != null){ %>
       <p>Hello <%= request.getSession().getAttribute("username") %>! (<a href="./logout">Logout</a> )</p>
    <% } else { %>
        <p><a href="login.jsp">Login</a></p>
    <% } %>
<div id="navigation">
    <% String role = (String) request.getSession().getAttribute("role");
        if (role != null){
        if (role.equalsIgnoreCase("admin")){ %>
        <form action="./createAccount.jsp">
            <input type="submit" value="Create Account">
        </form>
        <form action="./createProduct.jsp">
            <input type="submit" value="Create Product">
        </form>
        <% } %>
        <% if (role.equalsIgnoreCase("worker") || role.equalsIgnoreCase("admin")){ %>
        <form action="./manageProduct">
            <input type="submit" value="Manage Products">
        </form>
        <% } %>
        <% if (role.equalsIgnoreCase("customer") || role.equalsIgnoreCase("worker") || role.equalsIgnoreCase("admin")){ %>
        <form action="./product">
            <input type="submit" value="Get products">
        </form>
        <form action="./index.jsp">
            <input type="submit" value="Start page">
        </form>
        <% }
    } %>
</div>

</body>
</html>
