package Bean.Shop;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.Vector;

public class Shop {
    private Vector v = new Vector();
    private String submit = null;
    private String item = null;
    private void addItem(String name){
        v.addElement(name);
    }
    private void removeItem(String name){
        v.removeElement(name);
    }
    public void setItem(String name){
        item = name;
    }
    public void setSubmit(String s){
        submit = s;
    }
    public String[] getItems(){
        String[] ret = new String[v.size()];
        v.copyInto(ret);
        return ret;
    }
    public String getItem(){
        return item;
    }
    public String getSubmit(){
        return submit;
    }
//    判断绑定的item和submit来操作非持久化数据vector
    public void processRequest(HttpServletRequest request) throws UnsupportedEncodingException {
        item = new String(request.getParameter("item").getBytes("ISO-8859-1"),"UTF-8");
        if(submit == null){
            addItem(item);
        }
        if(submit.equals("add")){
            addItem(item);
        }else if(submit.equals("delete")){
            removeItem(item);
        }
        reset();
    }
    private void reset(){
        setItem(null);
        setSubmit(null);
    }
}
