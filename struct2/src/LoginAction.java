import com.opensymphony.xwork2.ActionContext;

public class LoginAction {
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

    public String execute() throws Exception{
        username = getUsername();
        passwd = getPasswd();
        try {
            if(username!=null && !username.equals("") && passwd!=null&& !passwd.equals("")){
                ActionContext.getContext().getSession().put("user", getUsername());
                FORWRAD = "success";
            }else{
                FORWRAD = "input";
            }
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return FORWRAD;
    }
}
