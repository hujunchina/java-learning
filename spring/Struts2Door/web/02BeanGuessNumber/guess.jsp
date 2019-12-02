<%--
  Created by IntelliJ IDEA.
  User: Alice
  Date: 2019/12/1
  Time: 20:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>guess number</title>
</head>
<body>
<jsp:useBean id="guess" class="Bean.Game.GuessNumber" scope="session"/>
<%
    String str = response.encodeRedirectURL("guess.jsp");
    String strGetNumber = response.encodeRedirectURL("getNumber.jsp");
%>
<jsp:setProperty name="guess" property="guessNumber" param="guessNumber"/>
<p>This is <%=guess.getGuessCount()%> times.</p>
<%=guess.getResult()%>
Your number is <%=guess.getGuessNumber()%>
<%
    if(!guess.isRight()){
%>
<form action="<%=str%>" method="get"><input type="text" name="guessNumber"><input type="submit" value="ok"></form>
<%
    }
%>
<p><a href="<%=strGetNumber%>">Restart</a></p>
</body>
</html>
