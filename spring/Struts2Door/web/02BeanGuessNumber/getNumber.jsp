<%@ page import="java.util.Random" %><%--
  Created by IntelliJ IDEA.
  User: Alice
  Date: 2019/12/1
  Time: 20:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>get number</title>
</head>
<body>
<jsp:useBean id="guess" class="Bean.Game.GuessNumber" scope="session"/>
<%
    Random random = new Random();
    int answer = random.nextInt(100);
    guess.setAnswer(answer);
    String str = response.encodeRedirectURL("guess.jsp");
%>
<h5>Please input a int number: <%=guess.getAnswer()%></h5>
<form action="guess.jsp" method="get"><input type="text" name="guessNumber"><input type="submit" value="ok"></form>
</body>
</html>
