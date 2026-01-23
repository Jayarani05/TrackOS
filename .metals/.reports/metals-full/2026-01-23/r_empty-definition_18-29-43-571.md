error id: file:///C:/Projects/TrackOS/src/services/ConflictDetector.java:models/TimeSlot#
file:///C:/Projects/TrackOS/src/services/ConflictDetector.java
empty definition using pc, found symbol in pc: models/TimeSlot#
empty definition using semanticdb
empty definition using fallback
non-local guesses:

offset: 69
uri: file:///C:/Projects/TrackOS/src/services/ConflictDetector.java
text:
```scala
package services;

import datastructures.IntervalTree;
import models.@@TimeSlot;
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

```


#### Short summary: 

empty definition using pc, found symbol in pc: models/TimeSlot#