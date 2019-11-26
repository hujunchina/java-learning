package WareBean;

public class DanceJuggle extends Juggle {
    private Poem poem;
    public DanceJuggle(Poem poem){
        super();
        this.poem = poem;
    }
    public DanceJuggle(int beanBags, Poem poem){
        super(beanBags);
        this.poem = poem;
    }
    public void perform() throws PerformanceException{
        super.perform();
        System.out.println("while reciting...");
        poem.recite();
    }
}
