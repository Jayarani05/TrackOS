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
    
    public Station getStation(String id) {
        return stations.get(id);
    }
    
    public List<Track> findPath(Station from, Station to) {
        Queue<String> queue = new LinkedList<>();
        Map<String, Track> cameFrom = new HashMap<>();
        
        queue.add(from.id);
        cameFrom.put(from.id, null);
        
        while (!queue.isEmpty()) {
            String current = queue.poll();
            if (current.equals(to.id)) {
                return buildPath(from.id, to.id, cameFrom);
            }
            
            for (Track t : getTracksFrom(current)) {
                if (!t.blocked && !cameFrom.containsKey(t.to.id)) {
                    queue.add(t.to.id);
                    cameFrom.put(t.to.id, t);
                }
            }
        }
        return new ArrayList<>();
    }
    
    private List<Track> buildPath(String from, String to, Map<String, Track> cameFrom) {
        List<Track> path = new ArrayList<>();
        String cur = to;
        while (!cur.equals(from)) {
            Track t = cameFrom.get(cur);
            path.add(0, t);
            cur = t.from.id;
        }
        return path;
    }
}
