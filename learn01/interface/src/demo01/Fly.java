package demo01;

public interface Fly {
    public void Flyon();

    private static void Flyhight(){
        System.out.println("5 m");
    }
    public static void Flynow() {
        Fly.Flyhight();
        System.out.println("Fly ... ");
    }

}
