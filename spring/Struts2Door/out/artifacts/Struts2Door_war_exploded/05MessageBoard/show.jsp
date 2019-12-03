<%@ page import="java.util.ArrayList" %>
<%@ page import="Bean.DataBase.MessageBean" %><%--
  Created by IntelliJ IDEA.
  User: Alice
  Date: 2019/12/2
  Time: 14:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Show Message</title>
</head>
<body>
<%
    ArrayList messagelist = (ArrayList) application.getAttribute("messagelist");
    if(messagelist==null || messagelist.size()==0){
        out.print("No message left");
    }else {
        for (Object mo : messagelist) {
            MessageBean mb = (MessageBean) mo;
 %>
            <hr>
            <p>Name: <%=mb.getName()%></p>
            <p>Title: <%=mb.getTitle()%></p>
            <p>Content: <%=mb.getContent()%></p>
            <p>Time: <%=mb.getTime()%></p>
<%
        }
    }
%>
<hr>
<span><a href="index.jsp">I want to leave message</a></span>
</body>
</html>
