package datastructures;

import models.TimeSlot;

public class IntervalTree {
    private Node root;
    
    private static class Node {
        TimeSlot slot;
        long maxEnd;
        Node left, right;
        
        Node(TimeSlot slot) {
            this.slot = slot;
            this.maxEnd = slot.endTime;
        }
    }
    
    public void insert(TimeSlot slot) {
        root = insertHelper(root, slot);
    }
    
    private Node insertHelper(Node node, TimeSlot slot) {
        if (node == null) return new Node(slot);
        
        if (slot.startTime < node.slot.startTime) {
            node.left = insertHelper(node.left, slot);
        } else {
            node.right = insertHelper(node.right, slot);
        }
        
        if (slot.endTime > node.maxEnd) {
            node.maxEnd = slot.endTime;
        }
        return node;
    }
}
