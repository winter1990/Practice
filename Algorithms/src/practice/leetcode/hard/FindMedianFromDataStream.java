package practice.leetcode.hard;

import java.util.PriorityQueue;

/**
 * @design
 * @heap
 *
 * addNum(1), addNum(2), findMedian() -> 1.5, addNum(3), findMedian() -> 2
 *
 * intuition
 * save into an array list, the size the dynamic, when call find medium, sort and get medium based on size odd/even
 * space O(N), time O(NlogN) for each call
 *
 * optimization
 * no matter what data structure used, need to store all the numbers because when new number comes in may change
 *
 * heap is used for getting largest/smallest in O(1) time
 * median -> two heaps, one max heap and one min heap
 * all values in min heap are larger than max heap, then medium is average of two peaks or the peak of larger size
 * maintain the two heaps, size difference must be smaller/equal to 1
 * add():
 * add to max/low heap
 * min.offer(max.poll) because the peek of lower heap might be larger than minimum of higher heap
 * if size of higher is larger than lower, lower.offer(higher.poll)
 * getMedium();
 * check size difference, if not lower.peek, otherwise, calculate
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