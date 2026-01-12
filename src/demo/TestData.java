package demo;

import models.*;

public class TestData {
    
    public static Train expressA() {
        Train t = new Train("T1", "Express 101", TrainType.EXPRESS);
        t.passengerCount = 500;
        return t;
    }
    
    public static Train localA() {
        Train t = new Train("T2", "Local 201", TrainType.LOCAL);
        t.passengerCount = 200;
        return t;
    }
    
    public static Train cargoA() {
        return new Train("T3", "Cargo 301", TrainType.CARGO);
    }
}
