<%--
  Created by IntelliJ IDEA.
  User: Rasmus
  Date: 2020-10-03
  Time: 15:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <script type="text/javascript">
    function login(){
        var name = document.getElementById("username").value;
        var pass = document.getElementById("password").value;
        var authString = name + ":"+pass;
        var encodedAuth = btoa(authString);
        var authHeader = "Basic " + encodedAuth;
        var hiddenEncoded = document.getElementById("authorization");
        hiddenEncoded.value = authHeader;
        document.getElementById("username").value = "-";
        document.getElementById("password").value = "-";
    }
</script>
</head>
<body>
<h1>This is login page!</h1>
<p>This is where you login</p>

<form id="request" onsubmit="login()" action="./auth" method="POST">
    <hr/>
    <span>Username: </span>
    <input type="text" name="username" id="username">
    <span>Password: </span>
    <input type="password" name="password" id="password">
    <input type="hidden" name="authorization" id="authorization">
    <input type="submit" name="submit">
</form>
<form action="./index.jsp">
    <input type="submit" value="Start page">
</form>
<form action="./createAccount.jsp">
    <input type="submit" value="Create Account">
</form>

</body>
</html>
