<%@ page import="java.net.HttpURLConnection" %>
<%@ page import="java.net.URL" %>
<%@ page import="java.util.Base64" %>
<%@ page import="java.util.Scanner" %><%--
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
</head>
<body>
<h1>This is login page</h1>
<p>This is where you login</p>
<div id ="login">
    <p>Name: <input type="text" value="" id="name"></p>
    <p>Password: <input type="password" id="password"></p>
    <p><button type="button" onclick="">Login</button> </p>
</div>
    <%
        String urlLogin = "http://localhost:8080/web_shop_java_war_exploded/auth";
        HttpURLConnection connection = (HttpURLConnection) new URL(urlLogin).openConnection();
        connection.setRequestMethod("POST");
        String authString = "admin" + ":" + "password";
        String encodedAuth = Base64.getEncoder().encodeToString(authString.getBytes());
        String authHeader = "Basic " + encodedAuth;
        connection.setRequestProperty ("Authorization", authHeader);
        /*String resp = "";
        Scanner scanner = new Scanner(connection.getInputStream());
        while(scanner.hasNextLine())
            resp += scanner.nextLine();
        scanner.close();*/
        int responseCode = connection.getResponseCode();
        if (responseCode == 200)
            System.out.println("Login was successful.");
        else if (responseCode == 401)
            System.out.println("Wrong password.");
        //System.out.println(resp);
    %>
</body>
</html>
