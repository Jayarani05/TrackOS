package observability;

import java.util.ArrayList;
import java.util.List;

public class LatencyTracker {
    private List<Long> samples = new ArrayList<>();
    private long threshold;
    
    public LatencyTracker(long thresholdMs) {
        this.threshold = thresholdMs;
    }
    
    public void record(long ms) {
        samples.add(ms);
    }
    
    public int getCount() {
        return samples.size();
    }
}
