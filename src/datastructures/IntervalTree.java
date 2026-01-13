package datastructures;

import models.TimeSlot;
import java.util.ArrayList;
import java.util.List;

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
        if (slot == null) return;  // Fix: null check
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
    
    public List<TimeSlot> findOverlapping(TimeSlot slot) {
        List<TimeSlot> results = new ArrayList<>();
        if (slot == null) return results;  // Fix: null check
        findOverlaps(root, slot, results);
        return results;
    }
    
    private void findOverlaps(Node node, TimeSlot slot, List<TimeSlot> results) {
        if (node == null) return;
        
        if (overlaps(node.slot, slot)) {
            results.add(node.slot);
        }
        
        if (node.left != null && node.left.maxEnd > slot.startTime) {
            findOverlaps(node.left, slot, results);
        }
        
        if (node.slot.startTime < slot.endTime) {
            findOverlaps(node.right, slot, results);
        }
    }
    
    private boolean overlaps(TimeSlot a, TimeSlot b) {
        return a.startTime < b.endTime && b.startTime < a.endTime;
    }
    
    public List<TimeSlot> getAll() {
        List<TimeSlot> all = new ArrayList<>();
        collectAll(root, all);
        return all;
    }
    
    private void collectAll(Node n, List<TimeSlot> list) {
        if (n == null) return;
        collectAll(n.left, list);
        list.add(n.slot);
        collectAll(n.right, list);
    }
}
