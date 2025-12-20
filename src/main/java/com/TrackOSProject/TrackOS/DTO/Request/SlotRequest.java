package com.TrackOSProject.TrackOS.DTO.Request;

import java.time.LocalDateTime;

/**
 * Request to allocate a time slot on a track.
 */
public class SlotRequest {

    private String trainId;
    private String trackId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public SlotRequest() {
    }

    public SlotRequest(String trainId, String trackId, LocalDateTime startTime, LocalDateTime endTime) {
        this.trainId = trainId;
        this.trackId = trackId;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    // Getters and Setters
    public String getTrainId() {
        return trainId;
    }

    public void setTrainId(String trainId) {
        this.trainId = trainId;
    }

    public String getTrackId() {
        return trackId;
    }

    public void setTrackId(String trackId) {
        this.trackId = trackId;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }
}
