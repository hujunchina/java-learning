<%--
  Created by IntelliJ IDEA.
  User: Alice
  Date: 2019/12/1
  Time: 20:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>scope 1</title>
</head>
<body>
<h5>第3个页面被访问</h5>
<jsp:useBean id="counter" class="Bean.Scope.BeanScope" scope="application"/>
<br>
<p><a href="scope1.jsp"><span>scope 1</span></a></p>
<p><a href="scope2.jsp"><span>scope 2</span></a></p>
<p>scope3.jsp</p>
<p>The three pages visited <jsp:getProperty name="counter" property="accessCounter"/></p>
<p>由于javabean作用域是Application，所以三个页面共享一个scopebean</p>
</body>
</html>
