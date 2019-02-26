package practice.leetcode.hard;

import java.util.PriorityQueue;

/**
 * @design
 * @heap
 *
 * addNum(1), addNum(2), findMedian() -> 1.5, addNum(3), findMedian() -> 2
 *
 * find the median in stream
 * the new value keeps coming, we need to maintain the median as it might be changed any time we put new number
 * we can use heap -> priority queue
 * median -> two priority queues:
 * one in increasing -> min heap (higher)
 * one in decreasing -> max heap (lower)
 * we need to make sure all the min values in higher q > max lower q
 * and also size diff of two queues should be <= 1
 */
public class FindMedianFromDataStream {
}

class MedianFinder {
    PriorityQueue<Integer> higher;
    PriorityQueue<Integer> lower;
    /** initialize your data structure here. */
    public MedianFinder() {
        higher = new PriorityQueue<>();
        lower = new PriorityQueue<>((a, b) -> b - a);
    }

    public void addNum(int num) {
        lower.offer(num);
        higher.offer(lower.poll());
        if (lower.size() < higher.size()) {
            lower.offer(higher.poll());
        }
    }

    public double findMedian() {
        if (lower.size() == higher.size()) {
            return (double) (lower.peek() + higher.peek()) / 2;
        }
        return (double)lower.peek();
    }

    public static void main(String[] args) {
        MedianFinder m = new MedianFinder();
        m.addNum(1);
        m.addNum(2);
        m.findMedian();
        m.addNum(3);
        m.findMedian();
    }
}