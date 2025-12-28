package datastructures;

import models.Station;
import models.Track;
import java.util.*;

public class RailNetwork {
    private Map<String, Station> stations = new HashMap<>();
    private Map<String, List<Track>> connections = new HashMap<>();
    
    public void addStation(Station s) {
        stations.put(s.id, s);
        connections.put(s.id, new ArrayList<>());
    }
    
    public void addTrack(Track t) {
        connections.get(t.from.id).add(t);
    }
    
    public List<Track> getTracksFrom(String stationId) {
        return connections.getOrDefault(stationId, new ArrayList<>());
    }
}
