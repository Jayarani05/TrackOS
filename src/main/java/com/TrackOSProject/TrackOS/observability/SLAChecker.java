package com.TrackOSProject.TrackOS.observability;

public class SLAChecker {
    private SLAConfig config;
    private LatencyTracker tracker;

    public SLAChecker(SLAConfig config, LatencyTracker tracker) {
        this.config = config;
        this.tracker = tracker;
    }

    public boolean isMeetingSLA() {
        return tracker.getSLACompliance() >= config.minCompliance;
    }

    public boolean isLatencyOk(long ms) {
        return ms <= config.maxLatencyMs;
    }
}
