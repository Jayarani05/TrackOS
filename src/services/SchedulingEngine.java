package services;

import datastructures.RailNetwork;
import models.TimeSlot;
import java.util.List;

public class SchedulingEngine {
    private ConflictDetector detector;
    private PriorityResolver resolver;
    private RailNetwork network;
    
    public SchedulingEngine(RailNetwork network) {
        this.network = network;
        this.detector = new ConflictDetector();
        this.resolver = new PriorityResolver();
    }
    
    public List<TimeSlot> checkConflicts(TimeSlot slot) {
        return detector.getConflicts(slot);
    }
}
