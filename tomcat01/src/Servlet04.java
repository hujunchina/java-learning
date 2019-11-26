import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Servlet04 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
        String name = req.getParameter("name");
        String passwd = req.getParameter("passwd");
        if(name.equals(passwd)){
            resp.sendRedirect("/hello?name="+name);
        }else{
            resp.getWriter().println("登录失败");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
        String name = req.getParameter("name");
        String passwd = req.getParameter("passwd");
        if(name.equals(passwd)){
            resp.sendRedirect("/hello?name="+name);
        }else{
            resp.getWriter().println("登录失败");
        }
    }

}
