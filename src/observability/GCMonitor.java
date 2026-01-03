package observability;

import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.List;

public class GCMonitor {
    private List<GarbageCollectorMXBean> beans;
    
    public GCMonitor() {
        this.beans = ManagementFactory.getGarbageCollectorMXBeans();
    }
    
    public long getTotalCollections() {
        long total = 0;
        for (GarbageCollectorMXBean b : beans) {
            if (b.getCollectionCount() > 0) {
                total += b.getCollectionCount();
            }
        }
        return total;
    }
    
    public long getTotalTimeMs() {
        long total = 0;
        for (GarbageCollectorMXBean b : beans) {
            if (b.getCollectionTime() > 0) {
                total += b.getCollectionTime();
            }
        }
        return total;
    }
}
