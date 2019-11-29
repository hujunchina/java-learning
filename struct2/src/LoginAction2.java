import com.opensymphony.xwork2.ActionSupport;

public class LoginAction2 extends ActionSupport {
    private static String FORWRAD = null;
    private String username;
    private String passwd;
    public String getUsername(){
        return username;
    }
    public void setUsername(String username){
        this.username = username;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
    public void validate(){
        if(getUsername()==null || getUsername().trim().equals("")){
            addFieldError("username", getText("user.required"));
        }
        if(getPasswd()==null || getPasswd().trim().equals("")){
            addFieldError("passwd", getText("pass.required"));
        }
    }
}
