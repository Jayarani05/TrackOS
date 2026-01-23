package observability;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;

public class MemoryMonitor {
    private MemoryMXBean bean;
    
    public MemoryMonitor() {
        this.bean = ManagementFactory.getMemoryMXBean();
    }
    
    public long getHeapUsedMB() {
        return bean.getHeapMemoryUsage().getUsed() / (1024*1024);
    }
    
    public long getHeapMaxMB() {
        return bean.getHeapMemoryUsage().getMax() / (1024*1024);
    }
    
    public double getHeapPercent() {
        MemoryUsage h = bean.getHeapMemoryUsage();
        return (h.getUsed() * 100.0) / h.getMax();
    }
    
    public boolean hasPressure() {
        return getHeapPercent() > 80;
    }
}
