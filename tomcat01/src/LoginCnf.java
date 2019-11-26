import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginCnf extends HttpServlet{
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String name = request.getParameter("uname");
        String passwd = request.getParameter("passwd");
        Login login = new Login();
        if(login.isLogin(name, passwd)){
            request.setAttribute("login", "true");
            request.getRequestDispatcher("login-sucess.jsp").forward(request, response);
        }else{
            request.getRequestDispatcher("login-failure.jsp").forward(request, response);
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        doGet(request, response);
    }
}