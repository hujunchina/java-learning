package Struts.Action;

import Struts.Bean.DB;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.ServletRequestAware;

import javax.servlet.ServletRequestWrapper;
import javax.servlet.http.HttpServletRequest;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginAction extends ActionSupport implements ServletRequestAware {
    private String username;
    private String password;
    private ResultSet resultSet = null;
    private String message = ERROR;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ResultSet getResultSet() {
        return resultSet;
    }

    public void setResultSet(ResultSet resultSet) {
        this.resultSet = resultSet;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HttpServletRequest getRequest() {
        return request;
    }

    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    private HttpServletRequest request;

    public void validate(){
        if(this.getUsername()==null || this.getUsername().length()==0){
            addFieldError("username", "Input user name");
        }else{
            try {
                DB oracle = new DB();
                resultSet = oracle.selectRegister(request, this.getUsername());
                if(!resultSet.next()){
                    addFieldError("username", "Your are not register yet!");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(this.getPassword()==null || this.getPassword().length()==0){
            addFieldError("password", "Input your password");
        }else{
            try {
                DB oracle = new DB();
                resultSet = oracle.selectRegister(request, this.getUsername());
                if(resultSet.next()){
                    resultSet = oracle.selectLogin(request, this.getUsername(), this.getPassword());
                    if(!resultSet.next()){
                        addFieldError("password", "Password Error!");
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    @Override
    public void setServletRequest(HttpServletRequest httpServletRequest) {

    }
}
