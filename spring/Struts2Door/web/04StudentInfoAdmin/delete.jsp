<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %><%--
  Created by IntelliJ IDEA.
  User: Alice
  Date: 2019/12/2
  Time: 10:47
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
            Statement statement = conn.createStatement();
        %>
        <h1>删除学生信息</h1>
        <form action="deletecheck.jsp" method="post">
            <p>请选择删除学生学号<select name="sno">
                <%
                    String sql = "select * from student";
                    ResultSet resultSet = statement.executeQuery(sql);
                    while(resultSet.next()){
                %>
                <option value="<%=resultSet.getInt("sno")%>"><%=resultSet.getInt("sno")%></option>
                <%
                    }
                    resultSet.close();
                    statement.close();
                    conn.close();
                %>
            </select></p>
            <input type="submit" name="submit" value="确 定">
            <input type="reset" value="返 回" onclick="javascript:history.go(-1)">
        </form>
    </container>
</section>
</body>
</html>
