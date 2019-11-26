package demo01;

public class Demo01 {
    public static void main(String[] args){
        Sun s = new Sun();
        s.say(); //overwritten father method, so it is sun's method
        s.say("hj");
    }
}
