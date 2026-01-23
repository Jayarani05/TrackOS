package com.TrackOSProject.TrackOS.services;

public class DelayHandler {

    public void handleDelay(Long trainId, int delayMinutes) {
        System.out.println("Train " + trainId + " delayed by " + delayMinutes + " min");
    }
}
