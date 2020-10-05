<%@ page import="Entities.Product" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: T3ss
  Date: 2020-10-04
  Time: 21:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Shopping cart</title>

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
        input[type=submit] {
            width: 300px;
            background-color: #0E816A;
            color: white;
            font-size: large;
            padding: 20px 20px;
            margin-left: 30px;
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

    <% if (request.getSession().getAttribute("username") != null){
        ArrayList<Product> shoppingCart = (ArrayList<Product>) request.getSession().getAttribute("shoppingcart");
        for (int i = 0; i < shoppingCart.size(); i++) {
            %><div class="productText">
                <h2><%=shoppingCart.get(i).getName()%></h2>
                <p><%=shoppingCart.get(i).getCost()%> kr &nbsp&nbsp&nbsp&nbsp
                    Antal i lager: <%=shoppingCart.get(i).getAmount()%></p>
                <p><%=shoppingCart.get(i).getDescription()%></p>
                <form action="./removefromcart">
                    <input type="submit" name="listId" value="<%=i%>">
                </form>
            </div><%
            }
        } else
            response.sendRedirect("./login.jsp");%>
    <form action="./product.jsp">
        <input type="submit" value="Back to products">
    </form>

</body>
</html>
