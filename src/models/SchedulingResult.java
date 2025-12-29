package models;

public class SchedulingResult {
    public boolean success;
    public String message;
    public long latencyMs;
    public TimeSlot slot;
    
    public static SchedulingResult ok(TimeSlot slot, long ms) {
        SchedulingResult r = new SchedulingResult();
        r.success = true;
        r.slot = slot;
        r.latencyMs = ms;
        return r;
    }
    
    public static SchedulingResult fail(String msg, long ms) {
        SchedulingResult r = new SchedulingResult();
        r.success = false;
        r.message = msg;
        r.latencyMs = ms;
        return r;
    }
}
