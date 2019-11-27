package AOP;

public class Performance implements Perform{
    private String name;

    public Performance(String name) {
        this.name = name;
    }

    public boolean play() {
        boolean ret = false;
        if(name=="Dot"){
            ret = true;
        }
        System.out.println("Performance is playing ...");
        return true;
    }
}
