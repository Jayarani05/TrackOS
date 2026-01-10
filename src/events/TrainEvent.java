package events;

import models.Train;
import models.Station;

public class TrainEvent {
    public String type;
    public Train train;
    public Station station;
    public long timestamp;
    
    public TrainEvent(String type, Train train, Station station) {
        this.type = type;
        this.train = train;
        this.station = station;
        this.timestamp = System.currentTimeMillis();
    }
    
    public static TrainEvent arrival(Train t, Station s) {
        return new TrainEvent("ARRIVAL", t, s);
    }
    
    public static TrainEvent departure(Train t, Station s) {
        return new TrainEvent("DEPARTURE", t, s);
    }
}
