package datastructures;

public class TimeBucket {
    public long startTime;
    public long endTime;
    public int count;
    
    public TimeBucket(long start, long end) {
        this.startTime = start;
        this.endTime = end;
        this.count = 0;
    }
    
    public void increment() {
        count++;
    }
    
    public boolean contains(long time) {
        return time >= startTime && time < endTime;
    }
}
