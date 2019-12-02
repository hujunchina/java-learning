package Bean.Scope;

public class BeanScope {
    private int accessCounter = 1;
    public int getAccessCounter(){
        return accessCounter++;
    }
}
