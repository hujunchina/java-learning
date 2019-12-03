<%--
  Created by IntelliJ IDEA.
  User: Alice
  Date: 2019/12/2
  Time: 16:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <s:form action="loginAction" method="post">
        <p><span>UserName:</span><input type="text" name="username"></p>
        <p><span>Password:</span><input type="text" name="password"></p>
        <input type="submit" value="Submit"><input type="reset" value="Reset">
    </s:form>
    <p><span><a href="0register.jsp">Register</a></span></p>
</body>
</html>
