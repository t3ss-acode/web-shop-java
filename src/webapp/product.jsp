<%@ page import="java.util.ArrayList" %>
<%@ page import="java.net.HttpURLConnection" %>
<%@ page import="java.net.URL" %>
<%@ page import="EntitiesInfo.ProductInfo" %><%--
  Created by IntelliJ IDEA.
  User: Rasmus
  Date: 2020-10-04
  Time: 15:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Start page</title>

    <style>
        * {
            box-sizing: border-box;
        }
        body {
            font-family: Arial, Helvetica, sans-serif;
            margin: 0;
        }

        .header {
            padding: 10px;
            text-align: center;
            background: #0E816A;
            color: white;
        }
        .productText {
            background-color: #D9ECE7;
            width: 90%;
            margin: 30px;
            border: 5px solid;
            border-color: #5CAD9D;
            padding-left: 30px;
            text-align: left;
        }
        .button {
            border: none;
            color: white;
            padding: 10px 20px;
            text-align: center;
            display: inline-block;
            font-size: 16px;
            margin-bottom: 5px;
            cursor: pointer;
            background-color: #0E816A;
        }
        input[type=submit] {
            width: 300px;
            background-color: #0E816A;
            color: white;
            font-size: large;
            padding: 20px 20px;
            margin-left: 30px;
            margin-top: 30px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
    </style>
</head>
<body>

    <div class="header">
        <h1>The website</h1>
        <p>Website with stuff you can put in a shopping cart</p>
    </div>

    <form action="./cart">
        <input type="submit" value="View shopping cart">
    </form>
    <% if (request.getSession().getAttribute("username") != null){
        //System.out.println(request.getSession().getAttribute("username"));
        //System.out.println("Inside if");
        ArrayList<ProductInfo> productInfoList = (ArrayList<ProductInfo>) request.getSession().getAttribute("productList");
        for (int i = 0; i < productInfoList.size(); i++) {

            %><div class="productText">
                <h2><%=productInfoList.get(i).getName()%></h2>
                <p><%=productInfoList.get(i).getCost()%> kr &nbsp&nbsp&nbsp&nbsp
                    Antal i lager: <%=productInfoList.get(i).getAmount()%></p>
                <p><%=productInfoList.get(i).getDescription()%></p>
                <%request.getSession().setAttribute(String.valueOf(i), productInfoList.get(i));%>
                <form action="./addtocart">
                    <input type="submit" name="productId" value="<%=i%>">
                </form>
            </div><%
        }

    } else
        response.sendRedirect("./login.jsp");%>
    <form action="./index.jsp">
        <input type="submit" value="Start page">
    </form>
</body>
</html>
