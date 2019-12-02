<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %><%--
  Created by IntelliJ IDEA.
  User: Alice
  Date: 2019/12/2
  Time: 13:46
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
            Connection conn = db.getConnecion();
            PreparedStatement preparedStatement = conn.prepareStatement("delete from student where sno=?");
            String sno = request.getParameter("sno");
            preparedStatement.setInt(1,Integer.parseInt(sno));
            boolean ret = preparedStatement.execute();
            preparedStatement.close();
            conn.close();
        %>
        <h1>删除学号<%=sno%>成功</h1>
        <form action="select.jsp"><input type="submit" value="返 回" name="submit"></form>
    </container>
</section>
</body>
</html>
