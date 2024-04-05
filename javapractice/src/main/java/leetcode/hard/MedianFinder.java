package main.java.leetcode.hard;


import java.util.Collections;
import java.util.PriorityQueue;

// https://leetcode.com/problems/find-median-from-data-stream/description/
class MedianFinder {
    // stores the larger half of the elements, always keeps the min element of that larger half
    PriorityQueue<Integer> largerHalfMinHeap = new PriorityQueue<>();
    // stores the smaller half of the elements, always keeps the max element of that smaller half
    PriorityQueue<Integer> smallerHalfMaxHeap = new PriorityQueue<>(Collections.reverseOrder());

    // together, the heads of these two heaps can give median in constant time

    public MedianFinder() {

    }

    public void addNum(int num) {
        // Add to min or max heap
        // then poll for the head of that heap and add to the other heap for balancing

        if (smallerHalfMaxHeap.size() == largerHalfMinHeap.size()) {
            // adding first ensures queue is never empty when we use remove()
            largerHalfMinHeap.add(num);
            smallerHalfMaxHeap.add(largerHalfMinHeap.remove());
        } else {
            // adding first ensures queue is never empty when we use remove()
            smallerHalfMaxHeap.add(num);
            largerHalfMinHeap.add(smallerHalfMaxHeap.remove());
        }
    }

    public double findMedian() {
        if (smallerHalfMaxHeap.size() == largerHalfMinHeap.size()) {
            return (smallerHalfMaxHeap.peek() + largerHalfMinHeap.peek()) / 2.0;
        }
        return smallerHalfMaxHeap.peek() / 1.0;
    }
}
