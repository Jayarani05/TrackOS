package services;

import models.Train;
import models.TimeSlot;
import java.util.List;

public class PriorityResolver {
    
    public Train resolve(Train a, Train b) {
        return a.getPriority() >= b.getPriority() ? a : b;
    }
    
    public Train resolveConflict(TimeSlot newSlot, List<TimeSlot> conflicts) {
        Train winner = newSlot.train;
        for (TimeSlot c : conflicts) {
            winner = resolve(winner, c.train);
        }
        return winner;
    }
}
