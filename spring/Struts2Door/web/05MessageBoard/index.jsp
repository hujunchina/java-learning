<%--
  Created by IntelliJ IDEA.
  User: Alice
  Date: 2019/12/2
  Time: 14:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Message Board</title>
</head>
<body>
<form action="http://localhost:9092/Struts2Door_war_exploded/MessageServlet" method="post">
    <p>Your Name:</p>
    <input type="text" name="name">
    <p>Message Title:</p>
    <input type="text" name="title">
    <p>Message Content:</p>
    <input type="text" name="content">
    <input type="submit" name="submit" value="Submit">
    <input type="reset" value="Reset">
    <span><a href="show.jsp">Check Message</a></span>
</form>
</body>
</html>
