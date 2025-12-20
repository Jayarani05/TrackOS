package com.TrackOSProject.TrackOS.DTO.Response;

import java.util.List;
import java.util.Map;

/**
 * Response for system health and observability data.
 */
public class HealthResponse {

    private String status; // HEALTHY, WARNING, CRITICAL
    private double slaCompliancePercent;
    private ThreadInfo threads;
    private MemoryInfo memory;
    private GCInfo gc;
    private PredictionInfo prediction;
    private Map<String, LatencyInfo> latencies;

    public HealthResponse() {
    }

    // Getters and Setters
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getSlaCompliancePercent() {
        return slaCompliancePercent;
    }

    public void setSlaCompliancePercent(double slaCompliancePercent) {
        this.slaCompliancePercent = slaCompliancePercent;
    }

    public ThreadInfo getThreads() {
        return threads;
    }

    public void setThreads(ThreadInfo threads) {
        this.threads = threads;
    }

    public MemoryInfo getMemory() {
        return memory;
    }

    public void setMemory(MemoryInfo memory) {
        this.memory = memory;
    }

    public GCInfo getGc() {
        return gc;
    }

    public void setGc(GCInfo gc) {
        this.gc = gc;
    }

    public PredictionInfo getPrediction() {
        return prediction;
    }

    public void setPrediction(PredictionInfo prediction) {
        this.prediction = prediction;
    }

    public Map<String, LatencyInfo> getLatencies() {
        return latencies;
    }

    public void setLatencies(Map<String, LatencyInfo> latencies) {
        this.latencies = latencies;
    }

    // Nested classes for different health aspects

    public static class ThreadInfo {
        private int total;
        private int runnable;
        private int blocked;
        private int waiting;
        private String healthStatus;

        public ThreadInfo() {
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public int getRunnable() {
            return runnable;
        }

        public void setRunnable(int runnable) {
            this.runnable = runnable;
        }

        public int getBlocked() {
            return blocked;
        }

        public void setBlocked(int blocked) {
            this.blocked = blocked;
        }

        public int getWaiting() {
            return waiting;
        }

        public void setWaiting(int waiting) {
            this.waiting = waiting;
        }

        public String getHealthStatus() {
            return healthStatus;
        }

        public void setHealthStatus(String healthStatus) {
            this.healthStatus = healthStatus;
        }
    }

    public static class MemoryInfo {
        private long heapUsedMB;
        private long heapMaxMB;
        private double utilizationPercent;
        private boolean highPressure;

        public MemoryInfo() {
        }

        public long getHeapUsedMB() {
            return heapUsedMB;
        }

        public void setHeapUsedMB(long heapUsedMB) {
            this.heapUsedMB = heapUsedMB;
        }

        public long getHeapMaxMB() {
            return heapMaxMB;
        }

        public void setHeapMaxMB(long heapMaxMB) {
            this.heapMaxMB = heapMaxMB;
        }

        public double getUtilizationPercent() {
            return utilizationPercent;
        }

        public void setUtilizationPercent(double utilizationPercent) {
            this.utilizationPercent = utilizationPercent;
        }

        public boolean isHighPressure() {
            return highPressure;
        }

        public void setHighPressure(boolean highPressure) {
            this.highPressure = highPressure;
        }
    }

    public static class GCInfo {
        private long youngGenCollections;
        private long youngGenTimeMs;
        private long oldGenCollections;
        private long oldGenTimeMs;
        private String healthStatus;

        public GCInfo() {
        }

        public long getYoungGenCollections() {
            return youngGenCollections;
        }

        public void setYoungGenCollections(long youngGenCollections) {
            this.youngGenCollections = youngGenCollections;
        }

        public long getYoungGenTimeMs() {
            return youngGenTimeMs;
        }

        public void setYoungGenTimeMs(long youngGenTimeMs) {
            this.youngGenTimeMs = youngGenTimeMs;
        }

        public long getOldGenCollections() {
            return oldGenCollections;
        }

        public void setOldGenCollections(long oldGenCollections) {
            this.oldGenCollections = oldGenCollections;
        }

        public long getOldGenTimeMs() {
            return oldGenTimeMs;
        }

        public void setOldGenTimeMs(long oldGenTimeMs) {
            this.oldGenTimeMs = oldGenTimeMs;
        }

        public String getHealthStatus() {
            return healthStatus;
        }

        public void setHealthStatus(String healthStatus) {
            this.healthStatus = healthStatus;
        }
    }

    public static class PredictionInfo {
        private String riskLevel;
        private String prediction;
        private List<String> riskFactors;

        public PredictionInfo() {
        }

        public String getRiskLevel() {
            return riskLevel;
        }

        public void setRiskLevel(String riskLevel) {
            this.riskLevel = riskLevel;
        }

        public String getPrediction() {
            return prediction;
        }

        public void setPrediction(String prediction) {
            this.prediction = prediction;
        }

        public List<String> getRiskFactors() {
            return riskFactors;
        }

        public void setRiskFactors(List<String> riskFactors) {
            this.riskFactors = riskFactors;
        }
    }

    public static class LatencyInfo {
        private long avgMs;
        private long p50Ms;
        private long p95Ms;
        private long p99Ms;
        private long totalOperations;

        public LatencyInfo() {
        }

        public long getAvgMs() {
            return avgMs;
        }

        public void setAvgMs(long avgMs) {
            this.avgMs = avgMs;
        }

        public long getP50Ms() {
            return p50Ms;
        }

        public void setP50Ms(long p50Ms) {
            this.p50Ms = p50Ms;
        }

        public long getP95Ms() {
            return p95Ms;
        }

        public void setP95Ms(long p95Ms) {
            this.p95Ms = p95Ms;
        }

        public long getP99Ms() {
            return p99Ms;
        }

        public void setP99Ms(long p99Ms) {
            this.p99Ms = p99Ms;
        }

        public long getTotalOperations() {
            return totalOperations;
        }

        public void setTotalOperations(long totalOperations) {
            this.totalOperations = totalOperations;
        }
    }
}
