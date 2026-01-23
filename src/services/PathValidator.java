package com.TrackOSProject.TrackOS.services;

public class PathValidator {

    public boolean isValid(String fromStation, String toStation) {
        // Simplified validation
        return fromStation != null && toStation != null && !fromStation.equals(toStation);
    }
}
