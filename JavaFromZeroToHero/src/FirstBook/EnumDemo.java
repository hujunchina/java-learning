package FirstBook;

public class EnumDemo {
    public enum WEEK{
        Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday;
    }
    public EnumDemo(int i){
        WEEK t = WEEK.Monday;
        if(t.ordinal()==(i-1)){
            System.out.println("ok");
        }
        System.out.println(WEEK.values()[i]);
    }

    public static void main(String[] args) {
        EnumDemo e = new EnumDemo(1);
    }
}
