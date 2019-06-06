package practice.leetcode.hard;

import java.util.PriorityQueue;

/**
 * @array
 *
 * Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the
 * very right. You can only see the k numbers in the window.
 *
 * Each time the sliding window moves right by one position.
 * Your job is to output the median array for each window in the original array.
 *
 * use two priority queue to keep track of the median
 * divide the numbers in the window into half
 * maintain two heaps
 *   to make sure they both have the same size if even
 *   OR
 *   lo.size - hi.size = 1, if k is odd
 *
 * Window position                Median
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       1
 *  1 [3  -1  -3] 5  3  6  7       -1
 *  1  3 [-1  -3  5] 3  6  7       -1
 *  1  3  -1 [-3  5  3] 6  7       3
 *  1  3  -1  -3 [5  3  6] 7       5
 *  1  3  -1  -3  5 [3  6  7]      6
 */
public class SlidingWindowMedian {
    public double[] medianSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> hi = new PriorityQueue<>();
        PriorityQueue<Integer> lo = new PriorityQueue<>((a, b) -> (b.compareTo(a)));
        for (int i = 0; i < k; i++) {
            lo.offer(nums[i]);
            hi.offer(lo.poll());
            if (hi.size() > lo.size()) lo.offer(hi.poll());
        }
        double[] res = new double[nums.length - k + 1];
        res[0] = k % 2 == 0 ? (double) ((long) lo.peek() + hi.peek()) / 2 : (double) lo.peek();
        for (int i = 1; i < res.length; i++) {
            lo.offer(nums[i + k - 1]);
            if (lo.contains(nums[i - 1])) {
                lo.remove(nums[i - 1]);
                hi.offer(lo.poll());
                lo.offer(hi.poll());
            } else {
                hi.remove(nums[i - 1]);
                hi.offer(lo.poll());
            }
            res[i] = k % 2 == 0 ? (double) ((long) lo.peek() + hi.peek()) / 2 : (double) lo.peek();
        }
        return res;
    }

    public static void main(String[] args) {
        SlidingWindowMedian s = new SlidingWindowMedian();
        int[] in = {-2147483648,-2147483648,2147483647,-2147483648,-2147483648,-2147483648,2147483647,
                2147483647,2147483647,2147483647,-2147483648,2147483647,-2147483648};
        s.medianSlidingWindow(in, 3);
    }
}
