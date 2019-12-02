<%--
  Created by IntelliJ IDEA.
  User: Alice
  Date: 2019/12/2
  Time: 9:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<html>
<head>
    <title>SHOP for item</title>
    <meta http-equiv="content-type" content="text/html; charset=utf-8">
</head>
<body>
<%
    request.setCharacterEncoding("UTF-8");
    response.setCharacterEncoding("UTF-8");
    response.setContentType("text/html;charset=utf-8");
%>
<form action="shopcheck.jsp" method="post">
    <span>Choose book you wanted</span>
    <hr>
    <span>Book list:</span>
    <br>
    <select name="item" id="item">
        <option>《大数据系统构建：可扩展实时数据系统构建原理与最佳实践》</option>
        <option>《Hadoop技术内幕：深入解析MapReduce架构设计与实现原理》</option>
        <option>《Go程序设计语言》</option>
        <option>《深入理解Java虚拟机：JVM高级特性与最佳实践（第2版）》</option>
        <option>《响应式架构：消息模式Actor实现与Scala、Akka应用集成》</option>
        <option>《实战Java虚拟机：JVM故障诊断与性能优化》</option>
    </select>
    <hr>
    <input type="submit" name="submit" value="add">
    <input type="submit" name="submit" value="delete">
</form>
</body>
</html>
