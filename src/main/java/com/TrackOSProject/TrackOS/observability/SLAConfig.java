package com.TrackOSProject.TrackOS.observability;

public class SLAConfig {
    public long maxLatencyMs;
    public double minCompliance;

    public SLAConfig(long maxMs, double minPct) {
        this.maxLatencyMs = maxMs;
        this.minCompliance = minPct;
    }

    public static SLAConfig defaultConfig() {
        return new SLAConfig(100, 99.0);
    }
}
