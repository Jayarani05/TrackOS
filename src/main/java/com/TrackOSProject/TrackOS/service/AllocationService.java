package com.TrackOSProject.TrackOS.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TrackOSProject.TrackOS.Entity.Allocation;
import com.TrackOSProject.TrackOS.Repository.AllocationRepository;

@Service
public class AllocationService {

    @Autowired
    private AllocationRepository allocationRepository;

    public List<Allocation> getAllAllocations() {
        return allocationRepository.findAll();
    }

    public Optional<Allocation> getAllocationById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Allocation ID cannot be null");
        }
        return allocationRepository.findById(id);
    }

    public List<Allocation> getAllocationsByTrainId(Long trainId) {
        return allocationRepository.findByTrainId(trainId);
    }

    public Allocation saveAllocation(Allocation allocation) {
        validateAllocation(allocation);
        return allocationRepository.save(allocation);
    }

    public Allocation updateAllocation(Long id, Allocation allocationDetails) {
        if (id == null) {
            throw new IllegalArgumentException("Allocation ID cannot be null");
        }
        validateAllocation(allocationDetails);

        Allocation allocation = allocationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Allocation not found with id: " + id));

        allocation.setTrainId(allocationDetails.getTrainId());
        allocation.setTrackName(allocationDetails.getTrackName());
        allocation.setStartTime(allocationDetails.getStartTime());
        allocation.setEndTime(allocationDetails.getEndTime());
        allocation.setStatus(allocationDetails.getStatus());
        allocation.setSource(allocationDetails.getSource());
        allocation.setDestination(allocationDetails.getDestination());
        allocation.setPlatformNumber(allocationDetails.getPlatformNumber());
        allocation.setPriority(allocationDetails.getPriority());
        allocation.setRemarks(allocationDetails.getRemarks());
        allocation.setAllocatedBy(allocationDetails.getAllocatedBy());

        return allocationRepository.save(allocation);
    }

    public void deleteAllocation(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Allocation ID cannot be null");
        }
        if (!allocationRepository.existsById(id)) {
            throw new RuntimeException("Allocation not found with id: " + id);
        }
        allocationRepository.deleteById(id);
    }

    private void validateAllocation(Allocation allocation) {
        if (allocation == null) {
            throw new IllegalArgumentException("Allocation cannot be null");
        }
        if (allocation.getTrainId() == null) {
            throw new IllegalArgumentException("Train ID is required");
        }
        if (allocation.getTrackName() == null || allocation.getTrackName().trim().isEmpty()) {
            throw new IllegalArgumentException("Track name is required");
        }
        if (allocation.getStartTime() == null) {
            throw new IllegalArgumentException("Start time is required");
        }
        if (allocation.getEndTime() == null) {
            throw new IllegalArgumentException("End time is required");
        }
        if (allocation.getEndTime().isBefore(allocation.getStartTime())) {
            throw new IllegalArgumentException("End time must be after start time");
        }
        if (allocation.getStatus() == null || allocation.getStatus().trim().isEmpty()) {
            throw new IllegalArgumentException("Status is required");
        }
        if (allocation.getSource() == null || allocation.getSource().trim().isEmpty()) {
            throw new IllegalArgumentException("Source station is required");
        }
        if (allocation.getDestination() == null || allocation.getDestination().trim().isEmpty()) {
            throw new IllegalArgumentException("Destination station is required");
        }
        if (allocation.getPlatformNumber() != null && allocation.getPlatformNumber() < 1) {
            throw new IllegalArgumentException("Platform number must be at least 1");
        }
        if (allocation.getPriority() != null && allocation.getPriority() < 1) {
            throw new IllegalArgumentException("Priority must be at least 1");
        }
    }
}
