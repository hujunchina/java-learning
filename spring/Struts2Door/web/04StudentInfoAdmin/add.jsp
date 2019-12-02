<%--
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
        <h1>添加学生信息</h1>
        <form action="addcheck.jsp" border="0">
                <table>
                    <tr align="ceter">
                        <td>ID</td>
                        <td><input type="text" name="snd" placeholder="学号后三位"></td>
                    </tr>
                    <tr align="ceter">
                        <td>学  号</td>
                        <td><input type="text" name="sno"></td>
                    </tr>
                    <tr align="ceter">
                        <td>姓  名</td>
                        <td><input type="text" name="sname"></td>
                    </tr>
                    <tr align="ceter">
                        <td>性  别</td>
                        <td><input type="text" name="sgender" placeholder="男：b， 女：g"></td>
                    </tr>
                    <tr align="ceter">
                        <td>年  龄</td>
                        <td><input type="text" name="sage"></td>
                    </tr>
                    <tr align="ceter">
                        <td>班  级</td>
                        <td><input type="text" name="sclass" placeholder="5班请填5"></td>
                    </tr>
                    <tr align="ceter">
                        <td>家庭籍贯</td>
                        <td><input type="text" name="shome"></td>
                    </tr>
                    <tr align="center">
                        <td>
                            <input type="submit" name="submit" value="提 交">
                            <input type="reset" name="clear" value="取 消">
                        </td>
                    </tr>
                </table>
        </form>
    </container>
</section>
</body>
</html>
