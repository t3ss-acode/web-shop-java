<%@ page import="Entities.Product" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.net.HttpURLConnection" %>
<%@ page import="java.net.URL" %><%--
  Created by IntelliJ IDEA.
  User: Rasmus
  Date: 2020-10-04
  Time: 15:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>Press button for products</p>
<form action="./product">
    <input type="submit" value="Get products">
</form>
<% if (request.getSession().getAttribute("username") != null){
    //System.out.println(request.getSession().getAttribute("username"));
    //System.out.println("Inside if");
    ArrayList<Product> productList = (ArrayList<Product>) request.getSession().getAttribute("productList");
    for (int i = 0; i < productList.size(); i++) {
        String list = "";
        list +=  productList.get(i).getId();
        list +=  " | "+productList.get(i).getName();
        list +=  " | "+productList.get(i).getCost();
        list +=  " | "+productList.get(i).getDescription();
        list +=  " | "+productList.get(i).getAmount();
        %><p><%=list%></p> <%
    }

} else
    response.sendRedirect("./login.jsp");%>
<form action="./index.jsp">
    <input type="submit" value="Start page">
</form>
</body>
</html>
