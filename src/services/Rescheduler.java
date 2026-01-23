package com.TrackOSProject.TrackOS.services;

public class Rescheduler {

    public boolean reschedule(Long trainId, String trackName, long newStart, long newEnd) {
        System.out.println("Rescheduling train " + trainId + " on track " + trackName);
        return true;
    }
}
