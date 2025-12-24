package services;

import datastructures.IntervalTree;
import models.TimeSlot;
import java.util.List;

public class ConflictDetector {
    private IntervalTree tree = new IntervalTree();
    
    public boolean hasConflict(TimeSlot slot) {
        return !tree.findOverlapping(slot).isEmpty();
    }
    
    public List<TimeSlot> getConflicts(TimeSlot slot) {
        return tree.findOverlapping(slot);
    }
    
    public void register(TimeSlot slot) {
        tree.insert(slot);
    }
}
