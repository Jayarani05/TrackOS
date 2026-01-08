package models;

public class TimeSlot {
    public long startTime;
    public long endTime;
    public Train train;
    public Track track;
    
    public TimeSlot(long start, long end, Train train, Track track) {
        this.startTime = start;
        this.endTime = end;
        this.train = train;
        this.track = track;
    }
    
    public boolean overlaps(TimeSlot other) {
        return startTime < other.endTime && other.startTime < endTime;
    }
}
