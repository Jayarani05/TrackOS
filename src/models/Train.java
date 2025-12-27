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
    }
    
    public int getPriority() {
        int score = 0;
        if (type == TrainType.EXPRESS) score += 100;
        else if (type == TrainType.LOCAL) score += 50;
        else score += 25;
        
        score += passengerCount / 10;
        score += delayMinutes * 2;
        return score;
    }
}
