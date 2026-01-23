package com.TrackOSProject.TrackOS.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TrackOSProject.TrackOS.Entity.Train;
import com.TrackOSProject.TrackOS.Repository.TrainRepository;

@Service
public class TrainService {

    @Autowired
    private TrainRepository trainRepository;

    public List<Train> getAllTrains() {
        return trainRepository.findAll();
    }

    public Optional<Train> getTrainById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Train ID cannot be null");
        }
        return trainRepository.findById(id);
    }

    public Train saveTrain(Train train) {
        validateTrain(train);
        return trainRepository.save(train);
    }

    public Train updateTrain(Long id, Train trainDetails) {
        if (id == null) {
            throw new IllegalArgumentException("Train ID cannot be null");
        }
        validateTrain(trainDetails);

        Train train = trainRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Train not found with id: " + id));

        train.setTrainNumber(trainDetails.getTrainNumber());
        train.setName(trainDetails.getName());
        train.setType(trainDetails.getType());
        train.setCapacity(trainDetails.getCapacity());
        train.setSource(trainDetails.getSource());
        train.setDestination(trainDetails.getDestination());
        train.setDepartureTime(trainDetails.getDepartureTime());
        train.setArrivalTime(trainDetails.getArrivalTime());
        train.setMaxSpeed(trainDetails.getMaxSpeed());
        train.setStatus(trainDetails.getStatus());
        train.setRoute(trainDetails.getRoute());

        return trainRepository.save(train);
    }

    public void deleteTrain(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Train ID cannot be null");
        }
        if (!trainRepository.existsById(id)) {
            throw new RuntimeException("Train not found with id: " + id);
        }
        trainRepository.deleteById(id);
    }

    private void validateTrain(Train train) {
        if (train == null) {
            throw new IllegalArgumentException("Train cannot be null");
        }
        if (train.getTrainNumber() == null || train.getTrainNumber().trim().isEmpty()) {
            throw new IllegalArgumentException("Train number is required");
        }
        if (train.getName() == null || train.getName().trim().isEmpty()) {
            throw new IllegalArgumentException("Train name is required");
        }
        if (train.getType() == null || train.getType().trim().isEmpty()) {
            throw new IllegalArgumentException("Train type is required");
        }
        if (train.getCapacity() == null || train.getCapacity() < 1) {
            throw new IllegalArgumentException("Capacity must be at least 1");
        }
        if (train.getSource() == null || train.getSource().trim().isEmpty()) {
            throw new IllegalArgumentException("Source station is required");
        }
        if (train.getDestination() == null || train.getDestination().trim().isEmpty()) {
            throw new IllegalArgumentException("Destination station is required");
        }
        if (train.getDepartureTime() != null && train.getArrivalTime() != null
                && train.getArrivalTime().isBefore(train.getDepartureTime())) {
            throw new IllegalArgumentException("Arrival time must be after departure time");
        }
        if (train.getMaxSpeed() != null && train.getMaxSpeed() < 0) {
            throw new IllegalArgumentException("Speed cannot be negative");
        }
    }
}
