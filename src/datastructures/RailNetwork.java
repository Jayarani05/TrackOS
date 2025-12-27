package datastructures;

import models.Station;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

public class RailNetwork {
    private Map<String, Station> stations = new HashMap<>();
    private Map<String, List<String>> connections = new HashMap<>();
    
    public void addStation(Station s) {
        stations.put(s.id, s);
        connections.put(s.id, new ArrayList<>());
    }
}
