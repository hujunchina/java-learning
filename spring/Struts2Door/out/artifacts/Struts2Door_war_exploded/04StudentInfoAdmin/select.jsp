<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %><%--
  Created by IntelliJ IDEA.
  User: Alice
  Date: 2019/12/2
  Time: 10:45
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
            Statement statement = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            String sql = "select * from student";
            ResultSet resultSet = statement.executeQuery(sql);
            resultSet.last();           // move to last record
        %>
        <h1>共查询到： <%=resultSet.getRow()%>条学生信息</h1>
        <table border="1" width="800">
            <tr align="center">
                <th width="1em">ID</th>
                <th width="3em">学号</th>
                <th width="2em">姓名</th>
                <th width="2em">性别</th>
                <th width="2em">年龄</th>
                <th width="2em">班级</th>
                <th width="5em">籍贯</th>
            </tr>
            <%
                resultSet.beforeFirst();
                while(resultSet.next()){
            %>
            <tr>
                <td><%=resultSet.getInt("snd")%></td>
                <td><%=resultSet.getInt("sno")%></td>
                <td><%=resultSet.getString("sname")%></td>
                <td><%
                    String gender = resultSet.getString("sgender");
                    if(gender.equals("b")){
                        out.print("男");
                    }else{
                        out.print("女");
                    }
                %></td>
                <td><%=resultSet.getInt("sage")%>岁</td>
                <td><%=resultSet.getInt("sclass")%>班</td>
                <td><%=resultSet.getString("shome")%></td>
            </tr>
            <%
                }
                resultSet.close();
                statement.close();
                conn.close();
            %>
        </table>
    </container>
</section>
</body>
</html>
