package WareBean;

import java.util.Map;

public class OneManPlay implements Performer {
    public void setInstrumentMap(Map<String, Instrument> instrumentMap) {
        this.instrumentMap = instrumentMap;
    }

    private Map<String, Instrument> instrumentMap;

    @Override
    public void perform() throws PerformanceException {
        for(String song : instrumentMap.keySet()){
            System.out.println(song+" : ");
            Instrument instrument = instrumentMap.get(song);
            instrument.play();
        }
    }
}
