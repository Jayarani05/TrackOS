package services;

import models.Train;

public class PriorityResolver {
    
    public Train resolve(Train a, Train b) {
        // Higher priority wins
        return a;  // TODO: implement comparison
    }
}
