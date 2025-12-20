package com.TrackOSProject.TrackOS.DTO.Request;

/**
 * Request to find a route between two stations.
 */
public class RouteRequest {

    private String fromStationId;
    private String toStationId;

    public RouteRequest() {
    }

    public RouteRequest(String fromStationId, String toStationId) {
        this.fromStationId = fromStationId;
        this.toStationId = toStationId;
    }

    // Getters and Setters
    public String getFromStationId() {
        return fromStationId;
    }

    public void setFromStationId(String fromStationId) {
        this.fromStationId = fromStationId;
    }

    public String getToStationId() {
        return toStationId;
    }

    public void setToStationId(String toStationId) {
        this.toStationId = toStationId;
    }
}
