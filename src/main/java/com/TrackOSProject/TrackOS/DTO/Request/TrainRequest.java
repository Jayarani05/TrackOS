package com.TrackOSProject.TrackOS.DTO.Request;

/**
 * Request to register a new train.
 */
public class TrainRequest {

    private String trainId;
    private String name;
    private String type;
    private int passengerCount;

    public TrainRequest() {
    }

    public TrainRequest(String trainId, String name, String type, int passengerCount) {
        this.trainId = trainId;
        this.name = name;
        this.type = type;
        this.passengerCount = passengerCount;
    }

    // Getters and Setters
    public String getTrainId() {
        return trainId;
    }

    public void setTrainId(String trainId) {
        this.trainId = trainId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPassengerCount() {
        return passengerCount;
    }

    public void setPassengerCount(int passengerCount) {
        this.passengerCount = passengerCount;
    }
}
