package models;

public class TimeSlot {
    public long startTime;
    public long endTime;
    
    public TimeSlot(long start, long end) {
        this.startTime = start;
        this.endTime = end;
    }
}
