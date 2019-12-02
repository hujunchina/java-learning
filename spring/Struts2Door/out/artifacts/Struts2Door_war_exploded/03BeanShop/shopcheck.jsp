<%@ page import="java.net.URLDecoder" %><%--
  Created by IntelliJ IDEA.
  User: Alice
  Date: 2019/12/2
  Time: 9:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<html>
<head>
    <title>SHOP CHECK</title>
    <meta http-equiv="content-type" content="text/html; charset=utf-8">
</head>
<body>
<jsp:useBean id="cart" scope="session" class="Bean.Shop.Shop"/>
<jsp:setProperty name="cart" property="*"/>
<%
    request.setCharacterEncoding("UTF-8");
    response.setCharacterEncoding("UTF-8");
    response.setContentType("text/html;utf-8");
    cart.processRequest(request);
%>
<br>
<ol>
    <%
        String[] books = cart.getItems();
        for(String book : books){
    %>
    <li><%=URLDecoder.decode(book, "utf-8")%></li>
    <%
        }
    %>
</ol>
<br><hr>
<%@include file="shop.jsp"%>
</body>
</html>
