package models;

public class Track {
    public String id;
    public Station from;
    public Station to;
    public int lengthKm;
    public boolean blocked;
    
    public Track(String id, Station from, Station to, int km) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.lengthKm = km;
        this.blocked = false;
    }
}
