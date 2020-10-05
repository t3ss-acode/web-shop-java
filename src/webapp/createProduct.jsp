<%--
  Created by IntelliJ IDEA.
  User: Rasmus
  Date: 2020-10-05
  Time: 04:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript">
        function checkFields(){
            if (!document.getElementById("name").value.isEmpty())
                if (!document.getElementById("cost").value.isEmpty())
                    if (!document.getElementById("description").value.isEmpty())
                        return true;
            return false;
        }
    </script>
</head>
<body>
<h1>Create product!</h1>
<p>This is where you create a new product to the system.</p>

<form id="product" onsubmit="return checkFields()" action="./createProduct" method="post">
    </hr>
    <span>Name: </span>
    <input type="text" name="name" id="name" required><br>
    <span>Cost: </span>
    <input type="text" name="cost" id="cost" required><br>
    <span>Description: </span>
    <input type="text" name="description" id="description" required><br>
    <input type="submit" name="submit">
</form>
<form action="./index.jsp">
    <input type="submit" value="Start page">
</form>
</body>
</html>
