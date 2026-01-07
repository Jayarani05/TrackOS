package services;

import datastructures.RailNetwork;

public class SchedulingEngine {
    private ConflictDetector detector;
    private PriorityResolver resolver;
    private RailNetwork network;
    
    public SchedulingEngine(RailNetwork network) {
        this.network = network;
        this.detector = new ConflictDetector();
        this.resolver = new PriorityResolver();
    }
}
