package demo01;

public class Man implements Fly {
    @Override
    public void Flyon() {
        System.out.println("Fly on");
    }

    public static void main(String[] args) {
        Man m = new Man();
        m.Flyon();
        Fly.Flynow();

    }
}
