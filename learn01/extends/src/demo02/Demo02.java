package demo02;

public class Demo02 {
    public static void WhichEat(Animal a){
        a.eat();
    }
    public static void main(String[] args) {
        Animal d = new Dog();
        Animal c = new Cat();
        d.eat();
        c.eat();
        WhichEat(d);
        WhichEat(c);
    }
}
