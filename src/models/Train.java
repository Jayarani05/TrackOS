package models;

public class Train {
    public String id;
    public String name;
    public TrainType type;
    public int passengerCount;
    public int delayMinutes;
    
    public Train(String id, String name, TrainType type) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.passengerCount = 0;
        this.delayMinutes = 0;
    }
    
    public int getPriority() {
        int score = getBaseScore();
        score += getPassengerBonus();
        score += getDelayBonus();
        return score;
    }
    
    private int getBaseScore() {
        switch (type) {
            case EXPRESS: return 100;
            case LOCAL: return 50;
            case CARGO: return 25;
            default: return 0;
        }
    }
    
    private int getPassengerBonus() {
        return passengerCount / 10;
    }
    
    private int getDelayBonus() {
        return delayMinutes * 2;
    }
    
    @Override
    public String toString() {
        return name + " (" + type + ", priority=" + getPriority() + ")";
    }
}
