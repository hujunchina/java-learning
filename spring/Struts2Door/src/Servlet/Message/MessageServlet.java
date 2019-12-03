package Servlet.Message;

import Bean.DataBase.MessageBean;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MessageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String title = req.getParameter("title");
        String content = req.getParameter("content");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String today = sdf.format(new Date());
        MessageBean mb = new MessageBean();
        mb.setName(name);
        mb.setTitle(title);
        mb.setContent(content);
        mb.setTime(today);

//        get session object
        HttpSession session = req.getSession();
//        get app context object by session
        ServletContext scx = session.getServletContext();
//        get array object by context
        ArrayList messagelist = (ArrayList)scx.getAttribute("messagelist");
        if(messagelist==null){
            messagelist = new ArrayList();
        }
//        get-set-put, get it, add new data set it, and put it in original place
        messagelist.add(mb);
        scx.setAttribute("messagelist", messagelist);
        resp.sendRedirect("05MessageBoard/show.jsp");
    }
}
