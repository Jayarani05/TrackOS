package com.TrackOSProject.TrackOS.observability;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
import java.lang.management.ThreadInfo;

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

    public ThreadStats getStats() {
        ThreadStats s = new ThreadStats();
        s.total = bean.getThreadCount();

        ThreadInfo[] infos = bean.getThreadInfo(bean.getAllThreadIds());
        for (ThreadInfo i : infos) {
            if (i == null)
                continue;
            switch (i.getThreadState()) {
                case RUNNABLE:
                    s.runnable++;
                    break;
                case BLOCKED:
                    s.blocked++;
                    break;
                case WAITING:
                case TIMED_WAITING:
                    s.waiting++;
                    break;
                case NEW:
                case TERMINATED:
                default:
                    break;
            }
        }
        return s;
    }

    public static class ThreadStats {
        public int total, runnable, blocked, waiting;
    }
}
