package practice.leetcode.easy;

import java.util.PriorityQueue;

/**
 * @heap
 *
 * Design a class to find the kth largest element in a stream.
 * Note that it is the kth largest element in the sorted order, not the kth distinct element
 *
 * intuition:
 * use heap as we want the data in order
 *
 * max or min heap? what is the size we need to maintain
 * for max heap, the peek is always the largest
 * if we want k-th largest, min heap with size k, so the peak would be result
 * we have nums and k give, initially the heap might not be full
 * if size < k, offer and return peek
 * otherwise compare the value with peek, if value > peek, poll and offer, otherwise do nothing
 */
public class KthLargestElementInAStream {
    public static void main(String[] args) {
        KthLargest a = new KthLargest(2, new int[]{1,2,3,4});
        System.out.println(a.add(1));
    }
}
class KthLargest {
    PriorityQueue<Integer> pq;
    int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        pq = new PriorityQueue<>(k);
        for (int n : nums) add(n);
    }

    public int add(int val) {
        if (pq.size() < k) {
            pq.offer(val);
        } else {
            if (pq.peek() < val) {
                pq.poll();
                pq.offer(val);
            }
        }
        return pq.peek();
    }
}