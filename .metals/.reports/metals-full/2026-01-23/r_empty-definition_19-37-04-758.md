error id: file:///C:/Projects/TrackOS/src/main/java/com/TrackOSProject/TrackOS/controller/TrainController.java:Train#
file:///C:/Projects/TrackOS/src/main/java/com/TrackOSProject/TrackOS/controller/TrainController.java
empty definition using pc, found symbol in pc: 
empty definition using semanticdb
empty definition using fallback
non-local guesses:

offset: 1403
uri: file:///C:/Projects/TrackOS/src/main/java/com/TrackOSProject/TrackOS/controller/TrainController.java
text:
```scala
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

import com.TrackOSProject.TrackOS.Entity.Train;
import com.TrackOSProject.TrackOS.service.TrainService;

@RestController
@RequestMapping("/api/trains")
public class TrainController {

    private final TrainService trainService;

    public TrainController(TrainService trainService) {
        this.trainService = trainService;
    }

    @GetMapping
    public List<Train> getAllTrains() {
        return trainService.getAllTrains();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Train> getTrainById(@PathVariable Long id) {
        return trainService.getTrainById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Train createTrain(@RequestBody Train@@ train) {
        return trainService.saveTrain(train);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Train> updateTrain(@PathVariable Long id, @RequestBody Train train) {
        return trainService.getTrainById(id)
                .map(existing -> {
                    train.setId(id);
                    return ResponseEntity.ok(trainService.saveTrain(train));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTrain(@PathVariable Long id) {
        trainService.deleteTrain(id);
        return ResponseEntity.noContent().build();
    }
}

```


#### Short summary: 

empty definition using pc, found symbol in pc: 