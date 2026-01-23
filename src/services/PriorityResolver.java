package com.TrackOSProject.TrackOS.services;

public class PriorityResolver {

    public Long resolve(int priorityA, int priorityB, Long trainIdA, Long trainIdB) {
        return priorityA >= priorityB ? trainIdA : trainIdB;
    }
}
