package com.TrackOSProject.TrackOS.observability;

import java.util.ArrayList;
import java.util.List;

public class LatencyTracker {
    private List<Long> samples = new ArrayList<>();
    private long threshold;
    private int violations = 0;

    public LatencyTracker(long thresholdMs) {
        this.threshold = thresholdMs;
    }

    public void record(long ms) {
        samples.add(ms);
        if (ms > threshold)
            violations++;
    }

    public long getMin() {
        return samples.stream().min(Long::compare).orElse(0L);
    }

    public long getMax() {
        return samples.stream().max(Long::compare).orElse(0L);
    }

    public long getAvg() {
        if (samples.isEmpty())
            return 0;
        return samples.stream().mapToLong(x -> x).sum() / samples.size();
    }

    public int getViolations() {
        return violations;
    }

    public double getSLACompliance() {
        if (samples.isEmpty())
            return 100.0;
        return ((samples.size() - violations) * 100.0) / samples.size();
    }
}




