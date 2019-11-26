import javax.servlet.*;
import java.io.IOException;

public class Servlet02 implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        servletResponse.setContentType("text/html; charset=utf-8");
        String name = servletRequest.getParameter("name");
        String passwd = servletRequest.getParameter("passwd");
        if(name == passwd){
            servletResponse.getWriter().println("登录成功");
        }else{
            servletResponse.getWriter().println("登录失败");
        }
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
