import javax.servlet.http.HttpServlet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyDatabase extends HttpServlet {
    private static String driver;
    private static String url;
    private static String user;
    private static String pass;

    public void init(){
        driver = this.getInitParameter("driver");
        url = this.getInitParameter("url");
        user = this.getInitParameter("user");
        pass = this.getInitParameter("pass");
    }

    public static Connection getConnnection(){
        Connection cn = null;
        try{
            Class.forName(driver);
            cn = DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cn;
    }
}
