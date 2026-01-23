package com.TrackOSProject.TrackOS.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/allocations")
public class AllocationController {

    @Autowired
    private AllocationService allocationService;

    @GetMapping
    public ResponseEntity<List<Allocation>> getAllAllocations() {
        return ResponseEntity.ok(allocationService.getAllAllocations());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getAllocationById(@PathVariable Long id) {
        try {
            return allocationService.getAllocationById(id)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> createAllocation(@Valid @RequestBody Allocation allocation) {
        try {
            Allocation savedAllocation = allocationService.saveAllocation(allocation);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedAllocation);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateAllocation(@PathVariable Long id, @Valid @RequestBody Allocation allocation) {
        try {
            Allocation updatedAllocation = allocationService.updateAllocation(id, allocation);
            return ResponseEntity.ok(updatedAllocation);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAllocation(@PathVariable Long id) {
        try {
            allocationService.deleteAllocation(id);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
