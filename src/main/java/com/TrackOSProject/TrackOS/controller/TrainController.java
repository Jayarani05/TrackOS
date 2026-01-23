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

import com.TrackOSProject.TrackOS.Entity.Train;
import com.TrackOSProject.TrackOS.service.TrainService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/trains")
public class TrainController {

    @Autowired
    private TrainService trainService;

    @GetMapping
    public ResponseEntity<List<Train>> getAllTrains() {
        return ResponseEntity.ok(trainService.getAllTrains());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTrainById(@PathVariable Long id) {
        try {
            return trainService.getTrainById(id)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> createTrain(@Valid @RequestBody Train train) {
        try {
            Train savedTrain = trainService.saveTrain(train);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedTrain);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTrain(@PathVariable Long id, @Valid @RequestBody Train train) {
        try {
            Train updatedTrain = trainService.updateTrain(id, train);
            return ResponseEntity.ok(updatedTrain);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTrain(@PathVariable Long id) {
        try {
            trainService.deleteTrain(id);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
