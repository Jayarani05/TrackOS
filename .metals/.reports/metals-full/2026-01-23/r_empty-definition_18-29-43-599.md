error id: file:///C:/Projects/TrackOS/src/services/SchedulingEngine.java:_empty_/SchedulingResult#
file:///C:/Projects/TrackOS/src/services/SchedulingEngine.java
empty definition using pc, found symbol in pc: _empty_/SchedulingResult#
empty definition using semanticdb
empty definition using fallback
non-local guesses:

offset: 807
uri: file:///C:/Projects/TrackOS/src/services/SchedulingEngine.java
text:
```scala
package services;

import datastructures.RailNetwork;
import datastructures.CapacityTracker;
import models.*;
import java.util.List;

public class SchedulingEngine {
    private ConflictDetector detector;
    private PriorityResolver resolver;
    private CapacityTracker capacity;
    private RailNetwork network;
    
    public SchedulingEngine(RailNetwork network) {
        this.network = network;
        this.detector = new ConflictDetector();
        this.resolver = new PriorityResolver();
        this.capacity = new CapacityTracker(30, 5);
    }
    
    public SchedulingResult schedule(TimeSlot slot) {
        long start = System.currentTimeMillis();
        
        try {
            // Check capacity
            if (capacity.isFull(slot.track.id, slot.startTime)) {
                return @@SchedulingResult.fail("Track full", elapsed(start));
            }
            
            // Check conflicts
            List<TimeSlot> conflicts = detector.getConflicts(slot);
            if (!conflicts.isEmpty()) {
                Train winner = resolver.resolveConflict(slot, conflicts);
                if (!winner.id.equals(slot.train.id)) {
                    return SchedulingResult.fail("Lower priority", elapsed(start));
                }
            }
            
            // Commit
            detector.register(slot);
            capacity.record(slot.track.id, slot.startTime);
            return SchedulingResult.ok(slot, elapsed(start));
            
        } catch (Exception e) {
            return SchedulingResult.fail("Error: " + e.getMessage(), elapsed(start));
        }
    }
    
    private long elapsed(long start) {
        return System.currentTimeMillis() - start;
    }
}

```


#### Short summary: 

empty definition using pc, found symbol in pc: _empty_/SchedulingResult#