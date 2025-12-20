package com.TrackOSProject.TrackOS.DTO.Request;

import com.TrackOSProject.TrackOS.model.Train;

/**
 * Request to register a new train.
 */
public class TrainRequest {

    private String trainId;
    private String name;
    private Train.TrainType type;
    private int passengerCount;

    public TrainRequest() {
    }

    public TrainRequest(String trainId, String name, Train.TrainType type, int passengerCount) {
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

    public Train.TrainType getType() {
        return type;
    }

    public void setType(Train.TrainType type) {
        this.type = type;
    }

    public int getPassengerCount() {
        return passengerCount;
    }

    public void setPassengerCount(int passengerCount) {
        this.passengerCount = passengerCount;
    }
}
