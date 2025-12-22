package models;

public class Station {
    public String id;
    public String name;
    public int platformCount;
    
    public Station(String id, String name, int platforms) {
        this.id = id;
        this.name = name;
        this.platformCount = platforms;
    }
}
