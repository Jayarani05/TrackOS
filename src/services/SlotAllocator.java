package services;

import models.TimeSlot;

public class SlotAllocator {
    private ConflictDetector detector;
    
    public SlotAllocator(ConflictDetector detector) {
        this.detector = detector;
    }
    
    public boolean allocate(TimeSlot slot) {
        if (detector.hasConflict(slot)) {
            return false;
        }
        detector.register(slot);
        return true;
    }
}
