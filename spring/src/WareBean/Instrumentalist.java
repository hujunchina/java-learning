package WareBean;

public class Instrumentalist implements Performer {
    private String song;

    public void setSong(String song) {
        this.song = song;
    }

    public String screamSong(){
        return song;
    }

    public Instrumentalist() {
    }

    @Override
    public void perform() throws PerformanceException {
        System.out.println("Playing "+song+" : ");
        instrument.play();
    }

    private Instrument instrument;

    public void setInstrument(Instrument instrument) {
        this.instrument = instrument;
    }
}
