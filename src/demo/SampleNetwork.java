package demo;

import datastructures.RailNetwork;
import models.*;

public class SampleNetwork {
    
    public static RailNetwork create() {
        RailNetwork net = new RailNetwork();
        
        Station central = new Station("S1", "Central", 4);
        Station north = new Station("S2", "North", 2);
        Station south = new Station("S3", "South", 2);
        Station east = new Station("S4", "East", 3);
        
        net.addStation(central);
        net.addStation(north);
        net.addStation(south);
        net.addStation(east);
        
        net.addTrack(new Track("T1", central, north, 10));
        net.addTrack(new Track("T2", central, south, 8));
        net.addTrack(new Track("T3", central, east, 12));
        
        return net;
    }
}
