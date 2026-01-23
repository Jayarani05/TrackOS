package com.TrackOSProject.TrackOS.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.TrackOSProject.TrackOS.Entity.Allocation;
import com.TrackOSProject.TrackOS.service.AllocationService;

@RestController
@RequestMapping("/api/allocations")
public class AllocationController {

    private final AllocationService allocationService;

    public AllocationController(AllocationService allocationService) {
        this.allocationService = allocationService;
    }

    @GetMapping
    public List<Allocation> getAllAllocations() {
        return allocationService.getAllAllocations();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Allocation> getAllocationById(@PathVariable Long id) {
        return allocationService.getAllocationById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/train/{trainId}")
    public List<Allocation> getAllocationsByTrain(@PathVariable Long trainId) {
        return allocationService.getAllocationsByTrainId(trainId);
    }

    @PostMapping
    public Allocation createAllocation(@RequestBody Allocation allocation) {
        return allocationService.saveAllocation(allocation);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Allocation> updateAllocation(@PathVariable Long id, @RequestBody Allocation allocation) {
        return allocationService.getAllocationById(id)
                .map(existing -> {
                    allocation.setId(id);
                    return ResponseEntity.ok(allocationService.saveAllocation(allocation));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAllocation(@PathVariable Long id) {
        allocationService.deleteAllocation(id);
        return ResponseEntity.noContent().build();
    }
}
