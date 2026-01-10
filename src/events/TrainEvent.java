package events;

import models.Train;

public class TrainEvent {
    public String type;
    public Train train;
    public long timestamp;
    
    public TrainEvent(String type, Train train) {
        this.type = type;
        this.train = train;
        this.timestamp = System.currentTimeMillis();
    }
}
