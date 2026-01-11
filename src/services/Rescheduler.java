package services;

import models.*;

public class Rescheduler {
    private SchedulingEngine engine;
    
    public Rescheduler(SchedulingEngine engine) {
        this.engine = engine;
    }
    
    public SchedulingResult reschedule(TimeSlot oldSlot, long newStart, long newEnd) {
        TimeSlot newSlot = new TimeSlot(newStart, newEnd, oldSlot.train, oldSlot.track);
        return engine.schedule(newSlot);
    }
}
