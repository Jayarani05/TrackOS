package datastructures;

import models.Train;
import java.util.ArrayList;
import java.util.List;

public class TrainPriorityQueue {
    private List<Train> heap = new ArrayList<>();
    
    public void add(Train train) {
        heap.add(train);
        bubbleUp(heap.size() - 1);
    }
    
    public Train poll() {
        if (heap.isEmpty()) return null;
        Train top = heap.get(0);
        Train last = heap.remove(heap.size() - 1);
        if (!heap.isEmpty()) {
            heap.set(0, last);
            bubbleDown(0);
        }
        return top;
    }
    
    private void bubbleUp(int i) {
        // TODO: implement
    }
    
    private void bubbleDown(int i) {
        // TODO: implement
    }
}
