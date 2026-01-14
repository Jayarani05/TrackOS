package demo;

import models.*;

public class TestData {
    
    public static Train expressA() {
        Train t = new Train("T1", "Express 101", TrainType.EXPRESS);
        t.passengerCount = 500;
        return t;
    }
    
    public static Train expressB() {
        Train t = new Train("T4", "Express 102", TrainType.EXPRESS);
        t.passengerCount = 450;
        t.delayMinutes = 10;
        return t;
    }
    
    public static Train localA() {
        Train t = new Train("T2", "Local 201", TrainType.LOCAL);
        t.passengerCount = 200;
        return t;
    }
    
    public static Train localB() {
        Train t = new Train("T5", "Local 202", TrainType.LOCAL);
        t.passengerCount = 150;
        return t;
    }
    
    public static Train cargoA() {
        return new Train("T3", "Cargo 301", TrainType.CARGO);
    }
    
    public static Train cargoB() {
        return new Train("T6", "Cargo 302", TrainType.CARGO);
    }
}
