package WareBean;

public class Juggle implements Performer {
    private int beanBags = 3;
    public Juggle(){
    }
    public Juggle(int beanBags){
        this.beanBags = beanBags;
    }
    @Override
    public void perform() throws PerformanceException {
        System.out.println("Juggle "+beanBags+" BeanBags");
    }
}
