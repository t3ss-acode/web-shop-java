<%--
  Created by IntelliJ IDEA.
  User: Rasmus
  Date: 2020-10-05
  Time: 00:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript">
        function encrypt(){
            var name = document.getElementById("username").value;
            var email = document.getElementById("email").value;
            var card = document.getElementById("card").value;
            var pass = document.getElementById("password").value;
            var rPass = document.getElementById("rePassword").value;
            var authString = name + ":"+email+":"+card+":"+pass+":"+rPass;
            var encodedAuth = btoa(authString);
            var authHeader = "Basic " + encodedAuth;
            var hiddenEncoded = document.getElementById("authorization");
            hiddenEncoded.value = authHeader;
            name.value = "-";
            email.value = "-";
            card.value = "-";
            pass.value = "-";
            rPass.value = "-";
        }
    </script>
</head>
<body>
<H1>Account creation!</H1>
<p>Create a account!</p>

<form id="account" onsubmit="return encrypt();" action="./createAccount" method="post">
    <hr/>
    <span>Username:         </span>
    <input type="text" name="username" id="username" required><br>
    <span>Email:            </span>
    <input type="email" name="email" id="email" required><br>
    <span>Card:             </span>
    <input type="text" name="card" id="card" required><br>
    <span>Password:         </span>
    <input type="password" name="password" id="password" required><br>
    <span>Re-type Password: </span>
    <input type="password" name="rePassword" id="rePassword" required><br>
    <% if (request.getSession().getAttribute("role") != null)
        if(request.getSession().getAttribute("role").toString().equalsIgnoreCase("admin")) { %>
    <input type="radio" name="role" id="worker" value="worker">
    <label for="worker">Worker</label>
    <input type="radio" name="role" id="admin" value="admin">
    <label for="admin">Admin</label>
    <br>
    <% } %>
    <input type="hidden" name="authorization" id="authorization">
    <input type="submit" name="submit">
</form>
<form action="./index.jsp">
    <input type="submit" value="Start page">
</form>
</body>
</html>
