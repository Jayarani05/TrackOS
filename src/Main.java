import demo.*;
import models.*;
import services.*;
import datastructures.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("TrackOS Demo");
        System.out.println("============");
        
        RailNetwork network = SampleNetwork.create();
        SchedulingEngine engine = new SchedulingEngine(network);
        
        Train express = TestData.expressA();
        Train local = TestData.localA();
        
        System.out.println("Trains: " + express.name + ", " + local.name);
    }
}
