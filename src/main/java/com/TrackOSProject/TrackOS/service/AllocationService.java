package com.TrackOSProject.TrackOS.service;

import com.TrackOSProject.TrackOS.Entity.Allocation;
import com.TrackOSProject.TrackOS.Repository.AllocationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AllocationService {

    private final AllocationRepository allocationRepository;

    public AllocationService(AllocationRepository allocationRepository) {
        this.allocationRepository = allocationRepository;
    }

    public List<Allocation> getAllAllocations() {
        return allocationRepository.findAll();
    }

    public Optional<Allocation> getAllocationById(Long id) {
        return allocationRepository.findById(id);
    }

    public List<Allocation> getAllocationsByTrainId(Long trainId) {
        return allocationRepository.findByTrainId(trainId);
    }

    public Allocation saveAllocation(Allocation allocation) {
        return allocationRepository.save(allocation);
    }

    public void deleteAllocation(Long id) {
        allocationRepository.deleteById(id);
    }
}
