<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %><%--
  Created by IntelliJ IDEA.
  User: Alice
  Date: 2019/12/1
  Time: 20:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>DataBase Connection Manager</title>
</head>
<body>
<h5>DataBase Connection Manager by JavaBean</h5>
<jsp:useBean id="dbcon" class="Bean.DataBase.DBConnectionManager"/>
<jsp:getProperty name="dbcon" property="connecion"/>
<%
    Connection con = dbcon.getConnecion();
    Statement statement = con.createStatement();
    ResultSet resultSet = statement.executeQuery("select * from goods where gno=2");
    resultSet.next();
%>
<ul>
    <li><span><%=resultSet.getString(2)%></span></li>
    <li><span><%=resultSet.getDouble(3)%></span></li>
    <li><span><%=resultSet.getString(7)%></span></li>
</ul>

<% con.close(); %>
</body>
</html>
