package events;

import models.Train;

public class DelayEvent {
    public Train train;
    public int delayMinutes;
    public String reason;
    public long timestamp;
    
    public DelayEvent(Train train, int minutes, String reason) {
        this.train = train;
        this.delayMinutes = minutes;
        this.reason = reason;
        this.timestamp = System.currentTimeMillis();
    }
}
