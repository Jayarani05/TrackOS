package observability;

import java.util.HashMap;
import java.util.Map;

public class MetricsCollector {
    private Map<String, Long> counters = new HashMap<>();
    private Map<String, Long> gauges = new HashMap<>();
    
    public void increment(String name) {
        counters.put(name, counters.getOrDefault(name, 0L) + 1);
    }
    
    public void setGauge(String name, long value) {
        gauges.put(name, value);
    }
    
    public long getCounter(String name) {
        return counters.getOrDefault(name, 0L);
    }
    
    public long getGauge(String name) {
        return gauges.getOrDefault(name, 0L);
    }
}
