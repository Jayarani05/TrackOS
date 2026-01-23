package com.TrackOSProject.TrackOS.services;

// This file is no longer needed - use SchedulingEngine instead
// Keeping for backwards compatibility

@Deprecated
public class SlotAllocator {

    public boolean allocate(Long trainId, String trackName, long startTime, long endTime) {
        long start = System.currentTimeMillis();
        // Simplified allocation logic
        long ms = System.currentTimeMillis() - start;
        System.out.println("Allocated slot for train " + trainId + " in " + ms + "ms");
        return true;
    }
}
