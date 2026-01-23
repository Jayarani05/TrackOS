package com.TrackOSProject.TrackOS.controller;

import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.ThreadMXBean;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/observability")
public class ObservabilityController {

    @GetMapping("/health")
    public Map<String, Object> getHealth() {
        Map<String, Object> health = new HashMap<>();
        Runtime runtime = Runtime.getRuntime();
        long usedMemory = runtime.totalMemory() - runtime.freeMemory();
        long maxMemory = runtime.maxMemory();
        double memoryUsage = (double) usedMemory / maxMemory * 100;

        health.put("status", memoryUsage < 85 ? "healthy" : "unhealthy");
        health.put("memoryUsagePercent", Math.round(memoryUsage * 100.0) / 100.0);
        return health;
    }

    @GetMapping("/memory")
    public Map<String, Object> getMemory() {
        Map<String, Object> memory = new HashMap<>();
        Runtime runtime = Runtime.getRuntime();
        MemoryMXBean memoryBean = ManagementFactory.getMemoryMXBean();

        memory.put("heapUsed", memoryBean.getHeapMemoryUsage().getUsed());
        memory.put("heapMax", memoryBean.getHeapMemoryUsage().getMax());
        memory.put("heapCommitted", memoryBean.getHeapMemoryUsage().getCommitted());
        memory.put("nonHeapUsed", memoryBean.getNonHeapMemoryUsage().getUsed());
        memory.put("freeMemory", runtime.freeMemory());
        memory.put("totalMemory", runtime.totalMemory());
        memory.put("maxMemory", runtime.maxMemory());
        return memory;
    }

    @GetMapping("/threads")
    public Map<String, Object> getThreads() {
        Map<String, Object> threads = new HashMap<>();
        ThreadMXBean threadBean = ManagementFactory.getThreadMXBean();

        threads.put("threadCount", threadBean.getThreadCount());
        threads.put("peakThreadCount", threadBean.getPeakThreadCount());
        threads.put("daemonThreadCount", threadBean.getDaemonThreadCount());
        threads.put("totalStartedThreadCount", threadBean.getTotalStartedThreadCount());
        return threads;
    }

    @GetMapping("/gc")
    public Map<String, Object> getGc() {
        Map<String, Object> gc = new HashMap<>();
        List<GarbageCollectorMXBean> gcBeans = ManagementFactory.getGarbageCollectorMXBeans();

        long totalCollections = 0;
        long totalTime = 0;
        for (GarbageCollectorMXBean bean : gcBeans) {
            totalCollections += bean.getCollectionCount();
            totalTime += bean.getCollectionTime();
            gc.put(bean.getName() + "_count", bean.getCollectionCount());
            gc.put(bean.getName() + "_timeMs", bean.getCollectionTime());
        }
        gc.put("totalCollections", totalCollections);
        gc.put("totalTimeMs", totalTime);
        return gc;
    }

    @GetMapping("/runtime")
    public Map<String, Object> getRuntime() {
        Map<String, Object> runtime = new HashMap<>();
        runtime.put("availableProcessors", Runtime.getRuntime().availableProcessors());
        runtime.put("javaVersion", System.getProperty("java.version"));
        runtime.put("jvmName", System.getProperty("java.vm.name"));
        runtime.put("osName", System.getProperty("os.name"));
        runtime.put("uptimeMs", ManagementFactory.getRuntimeMXBean().getUptime());
        return runtime;
    }

    @GetMapping("/metrics")
    public Map<String, Object> getMetrics() {
        Map<String, Object> metrics = new HashMap<>();

        // Memory metrics
        Runtime runtime = Runtime.getRuntime();
        MemoryMXBean memoryBean = ManagementFactory.getMemoryMXBean();
        metrics.put("heapUsed", memoryBean.getHeapMemoryUsage().getUsed());
        metrics.put("heapMax", memoryBean.getHeapMemoryUsage().getMax());

        // Thread metrics
        ThreadMXBean threadBean = ManagementFactory.getThreadMXBean();
        metrics.put("threadCount", threadBean.getThreadCount());

        // GC metrics
        List<GarbageCollectorMXBean> gcBeans = ManagementFactory.getGarbageCollectorMXBeans();
        long totalCollections = 0;
        long totalGcTime = 0;
        for (GarbageCollectorMXBean bean : gcBeans) {
            totalCollections += bean.getCollectionCount();
            totalGcTime += bean.getCollectionTime();
        }
        metrics.put("gcCollections", totalCollections);
        metrics.put("gcTimeMs", totalGcTime);

        // Runtime metrics
        metrics.put("uptimeMs", ManagementFactory.getRuntimeMXBean().getUptime());
        metrics.put("availableProcessors", runtime.availableProcessors());

        return metrics;
    }
}
