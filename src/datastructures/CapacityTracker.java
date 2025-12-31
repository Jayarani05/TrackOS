package datastructures;

import java.util.HashMap;
import java.util.Map;

public class CapacityTracker {
    private Map<String, Map<Long, Integer>> usage = new HashMap<>();
    private long bucketSize;
    private int maxPerBucket;
    
    public CapacityTracker(long bucketMinutes, int max) {
        this.bucketSize = bucketMinutes * 60 * 1000;
        this.maxPerBucket = max;
    }
    
    public void record(String trackId, long time) {
        long bucket = time / bucketSize;
        usage.computeIfAbsent(trackId, k -> new HashMap<>());
        Map<Long, Integer> m = usage.get(trackId);
        m.put(bucket, m.getOrDefault(bucket, 0) + 1);
    }
    
    public int getUsage(String trackId, long time) {
        long bucket = time / bucketSize;
        Map<Long, Integer> m = usage.get(trackId);
        if (m == null) return 0;
        return m.getOrDefault(bucket, 0);
    }
    
    public boolean isNearFull(String trackId, long time) {
        return getUsage(trackId, time) >= maxPerBucket * 0.8;
    }
    
    public boolean isFull(String trackId, long time) {
        return getUsage(trackId, time) >= maxPerBucket;
    }
}
