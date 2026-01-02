package observability;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;

public class ThreadMonitor {
    private ThreadMXBean bean;
    
    public ThreadMonitor() {
        this.bean = ManagementFactory.getThreadMXBean();
    }
    
    public int getThreadCount() {
        return bean.getThreadCount();
    }
    
    public int getPeakCount() {
        return bean.getPeakThreadCount();
    }
}
