package practice.leetcode.question;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @array
 * @deque
 *
 * Return the length of the shortest, non-empty, contiguous subarray of A with sum at least K.
 *
 * intuition:
 * pre sum of the array - preSum[i] represents the sum of first i elements
 * preSum[j]-preSum[i] = the sum of [i, j-1]
 *
 * [1 2 3 -1 4  2  3 -2  6  2], k = 7
 *  1 3 6  5 9 11 14 12 18 20  <- pre sum
 *
 * we want to keep track of the indexes that makes the pre sum increasing
 * -> preSum[q.back()] >= preSum[i]
 */
public class ShortestSubarrayWithSumAtLeastK {
    public int shortestSubarray(int[] A, int K) {
        int[] sum = new int[A.length + 1];
        for (int i = 0; i < A.length; i++) {
            sum[i + 1] = sum[i] + A[i];
        }
        Deque<Integer> deque = new LinkedList<Integer>();
        deque.offer(0);
        int minLen = Integer.MAX_VALUE;
        for (int i = 1; i < sum.length; i++) {
            if (!deque.isEmpty() && sum[i] <= sum[deque.peekFirst()]) {
                deque.offerFirst(i);
            } else {
                while (!deque.isEmpty() && sum[i] - sum[deque.peekFirst()] >= K) {
                    minLen = Math.min(minLen, i - deque.pollFirst());
                }
                if (deque.isEmpty()) {
                    deque.offerLast(i);
                } else if (sum[deque.peekFirst()] >= sum[i]) {
                    deque.offerFirst(i);
                } else {
                    while (!deque.isEmpty() && sum[i] <= sum[deque.peekLast()]) {
                        deque.pollLast();
                    }
                    deque.offerLast(i);
                }
            }
        }
        return minLen == Integer.MAX_VALUE ? -1 : minLen;
    }

    public static void main(String[] args) {
        int[] in = {1, 2, 3, -1, 4, 2, 3, -2, 6, 2};
        ShortestSubarrayWithSumAtLeastK s = new ShortestSubarrayWithSumAtLeastK();
        System.out.println(s.shortestSubarray(in, 7));
    }
}
