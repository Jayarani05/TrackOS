package services;

// This file is no longer needed - use SchedulingEngine instead
// Keeping for backwards compatibility

import models.TimeSlot;
import models.SchedulingResult;

@Deprecated
public class SlotAllocator {
    private ConflictDetector detector;
    
    public SlotAllocator(ConflictDetector detector) {
        this.detector = detector;
    }
    
    public SchedulingResult allocate(TimeSlot slot) {
        long start = System.currentTimeMillis();
        
        if (detector.hasConflict(slot)) {
            long ms = System.currentTimeMillis() - start;
            return SchedulingResult.fail("Conflict detected", ms);
        }
        
        detector.register(slot);
        long ms = System.currentTimeMillis() - start;
        return SchedulingResult.ok(slot, ms);
    }
}
