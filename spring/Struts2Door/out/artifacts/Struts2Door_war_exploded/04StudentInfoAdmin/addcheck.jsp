<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.PreparedStatement" %><%--
  Created by IntelliJ IDEA.
  User: Alice
  Date: 2019/12/2
  Time: 11:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student Admin</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/stylesheets/studentadmin.css">
</head>
<body>
<%@include file="pagetop.jsp"%>
<%@include file="pageleft.jsp"%>
<section class="page-right">
    <container>
        <jsp:useBean id="db" class="Bean.DataBase.DBConnectionManager"/>
        <%
            String snd = request.getParameter("snd");
            String sno = new String(request.getParameter("sno").getBytes("ISO-8859-1"),"UTF-8");
            String sname = request.getParameter("sname");
            String sgender = new String(request.getParameter("sgender").getBytes("ISO-8859-1"),"UTF-8");
            String sage = new String(request.getParameter("sage").getBytes("ISO-8859-1"),"UTF-8");
            String sclass = new String(request.getParameter("sclass").getBytes("ISO-8859-1"),"UTF-8");
            String shome = request.getParameter("shome");
            Connection conn = db.getConnecion();
            PreparedStatement preparedStatement = conn.prepareStatement("insert into student values (?,?,?,?,?,?,?)");
            preparedStatement.setInt(1, Integer.parseInt(snd));
            preparedStatement.setString(2, sname);
            preparedStatement.setInt(3, Integer.parseInt(sno));
            preparedStatement.setString(4, sgender);
            preparedStatement.setInt(5, Integer.parseInt(sage));
            preparedStatement.setInt(6, Integer.parseInt(sclass));
            preparedStatement.setString(7, shome);
            preparedStatement.execute();
            preparedStatement.close();
            conn.close();
        %>
        <h1><%=sno%><%=sname%>学生信息添加成功</h1>
        <form action="select.jsp"><input type="submit" value="返 回"></form>
    </container>
</section>
</body>
</html>