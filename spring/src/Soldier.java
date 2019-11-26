public class Soldier {
    private Weapon w;
    public Soldier(Weapon w){
        this.w = w;
    }
    public void showWeapon(){
        System.out.println("I'm using "+w.getName());
    }
}
