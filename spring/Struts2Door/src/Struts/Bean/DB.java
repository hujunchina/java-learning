package Struts.Bean;

import org.apache.struts2.interceptor.ServletRequestAware;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.*;
import java.util.ArrayList;

// using ioc way to servlet, get session object by request
public class DB implements ServletRequestAware {
    private String driverName = "oracle.jdbc.driver.OracleDriver";
    private String url = "jdbc:oracle:thin:@localhost:1521:xe";
    private String user = "HR";
    private String password = "hujun";
    private Connection conn = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }

    public void setStatement(Statement statement) {
        this.statement = statement;
    }

    public PreparedStatement getPreparedStatement() {
        return preparedStatement;
    }

    public void setPreparedStatement(PreparedStatement preparedStatement) {
        this.preparedStatement = preparedStatement;
    }

    public ResultSet getResultSet() {
        return resultSet;
    }

    public void setResultSet(ResultSet resultSet) {
        this.resultSet = resultSet;
    }

    public HttpServletRequest getRequest() {
        return request;
    }

    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    private HttpServletRequest request = null;

//    db connect and return statement
    public Statement getStatement() throws ClassNotFoundException {
        try {
            Class.forName(getDriverName());
            conn = DriverManager.getConnection(getUrl(), getUser(), getPassword());
            return conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String insertRegister(HttpServletRequest request, String username, String password){
        try{
            String sure = null;
            resultSet = selectRegister(request, username);
            if(resultSet.next()){
                sure = "one";
            }else{
                String sql = String.format("insert into struts_user values(%s,%s)", username, password);
                statement = getStatement();
                int row = statement.executeUpdate(sql);
                if(row==1){
                    String mess = myMessage(request, username);
                    if(mess.equals("ok")){
                        sure="ok";
                    }else{
                        sure = null;
                    }
                }else{
                    sure = null;
                }
            }
            return sure;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
    public ResultSet selectRegister(HttpServletRequest request, String userName){
        try{
            String sql = String.format("select * from user where username=%s",userName);
            statement = getStatement();
            return statement.executeQuery(sql);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    public String myMessage(HttpServletRequest request, String username){
        try {
            ArrayList listName = null;
            HttpSession session = request.getSession();
            listName = new ArrayList();
            resultSet = selectRegister(request, username);
            while(resultSet.next()){
                MyMessageBean mess = new MyMessageBean();
                mess.setUsername(username);
                mess.setPasswd(resultSet.getString("passwd"));
                listName.add(mess);
                session.setAttribute("MyMess", listName);
            }
            return "ok";
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    public Connection getConnecion(){
        try{
            Class.forName(driverName);
            return DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void setServletRequest(HttpServletRequest httpServletRequest) {

    }

    public ResultSet selectLogin(HttpServletRequest request, String username, String password) {
        try{
            String sql = String.format("select * from struts_user where username=%s and passwd=%s", username, password);
            statement = getStatement();
            return statement.executeQuery(sql);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
