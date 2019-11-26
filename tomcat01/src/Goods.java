import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Goods  extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection cn = MyDatabase.getConnnection();
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("select * from goods");
            PrintWriter out = resp.getWriter();
            while(rs.next()){
                out.print(rs.getInt(1));
                out.print("\t\t");
                out.print(rs.getString(2));
                out.print("\t\t");
                out.print(rs.getDouble(3));
                out.print("\t\t");
                out.print("<img src='img/");
                out.print(rs.getString(6));
                out.print("' >");
                out.print("\t\t");
                out.print(rs.getString(7));
                out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp);
    }

    public static class LoginCnf extends HttpServlet{
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

    public static class Login{
        public boolean isLogin(String name, String passwd){
            if("hujun".equals(name) && "hujun".equals(passwd)){
                return true;
            }else{
                return false;
            }
        }
    }
}
