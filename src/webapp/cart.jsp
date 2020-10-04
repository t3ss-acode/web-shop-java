<%--
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
    </style>
</head>
<body>
    <div class="header">
        <h1>The website</h1>
        <p>Website with stuff you can put in a shopping cart</p>
    </div>

    <%
        if (request.getSession().getAttribute("username") != null){
            String testCart = (String) request.getSession().getAttribute("testParameter");
            %><p><%=testCart%></p><%
        } else
            response.sendRedirect("./login.jsp");%>
    <form action="./index.jsp">
        <input type="submit" value="Start page">
    </form>

</body>
</html>
