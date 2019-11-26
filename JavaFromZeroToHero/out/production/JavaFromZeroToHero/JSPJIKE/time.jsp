<html>
<body>
<%@ page import="java.io.*,java.util.*" %>
<%
    response.setIntHeader("Refresh", 5);
    Calendar c = new GregorianCalendar();
    String am_pm;
    int hour = c.get(Calendar.HOUR);
    int minute = c.get(Calendar.MINUTE);
    int sec = c.get(Calendar.SECOND);
    if( c.get(Calendar.AM_PM)==0 ){
        am_pm = "AM";
    } else{
        am_pm = "PM";
    }
    String ctime = hour+":"+minute+":"+sec+" "+am_pm;
    out.println(ctime);
%>
</body>

</html>