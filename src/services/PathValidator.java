package services;

import datastructures.RailNetwork;
import models.Station;
import models.Track;
import java.util.List;

public class PathValidator {
    private RailNetwork network;
    
    public PathValidator(RailNetwork network) {
        this.network = network;
    }
    
    public boolean isValid(Station from, Station to) {
        List<Track> path = network.findPath(from, to);
        return !path.isEmpty();
    }
    
    public List<Track> getRoute(Station from, Station to) {
        return network.findPath(from, to);
    }
}
