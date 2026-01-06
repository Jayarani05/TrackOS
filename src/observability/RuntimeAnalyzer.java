package observability;

public class RuntimeAnalyzer {
    private ThreadMonitor threads;
    private GCMonitor gc;
    private MemoryMonitor memory;
    private LatencyTracker latency;
    
    public RuntimeAnalyzer(long slaMs) {
        this.threads = new ThreadMonitor();
        this.gc = new GCMonitor();
        this.memory = new MemoryMonitor();
        this.latency = new LatencyTracker(slaMs);
    }
    
    public void recordLatency(long ms) {
        latency.record(ms);
    }
    
    public boolean isHealthy() {
        return !memory.hasPressure() && latency.getSLACompliance() >= 99.0;
    }
}
