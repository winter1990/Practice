package practice.leetcode.hard;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 0 1  2  3  4 5 6  7  8
 * 2,1,10, 5, 9,6,7,12,14, 2 window size 3
 *     10 10 10 9 9 12 14 14
 * 0 0  2  2  2 4 4  7  8  8
 *
 * maintain the k size data structure - if the index is out side the range of [i-k+1,i] remove it
 */
public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k <= 0) {
            return new int[0];
        }
        int n = nums.length;
        int[] res = new int[n - k + 1];
        int index = 0;
        // store index
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            // remove numbers out of range k
            if (!q.isEmpty() && q.peek() < i - k + 1) {
                q.poll();
            }
            // remove smaller numbers in k range as they are useless
            while (!q.isEmpty() && nums[q.peekLast()] < nums[i]) {
                q.pollLast();
            }
            // q contains index... r contains content
            q.offer(i);
            if (i >= k - 1) {
                res[index++] = nums[q.peek()];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {2,1,10, 5, 9,6,7,12,14,2};
        SlidingWindowMaximum sw = new SlidingWindowMaximum();
        for (int i : sw.maxSlidingWindow(arr,3)) {
            System.out.print(i + " ");
        }
    }
}
