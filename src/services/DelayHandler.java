package services;

import events.DelayEvent;
import models.Train;

public class DelayHandler {
    
    public void handleDelay(DelayEvent event) {
        Train t = event.train;
        t.delayMinutes += event.delayMinutes;
        System.out.println(t.name + " delayed by " + event.delayMinutes + " min");
    }
}
