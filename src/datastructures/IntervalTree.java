package datastructures;

import models.TimeSlot;

public class IntervalTree {
    private Node root;
    
    private static class Node {
        TimeSlot slot;
        Node left, right;
        
        Node(TimeSlot slot) {
            this.slot = slot;
        }
    }
}
