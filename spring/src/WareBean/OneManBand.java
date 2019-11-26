package WareBean;

import java.util.List;

public class OneManBand implements Performer {
    public void setSong(String song) {
        this.song = song;
    }

    private String song;

    public void setInstruments(List<Instrument> instruments) {
        this.instruments = instruments;
    }

    private List<Instrument> instruments;

    @Override
    public void perform() throws PerformanceException {
        System.out.print("Playing "+song+" : ");
        for(Instrument i : instruments){
            i.play();
        }
    }
}
