package practice.leetcode.medium;

/**
 * @slidingwindow
 * @array
 *
 * Input: A = [1,1,1,0,0,0,1,1,1,1,0], K = 2, Output: 6, Explanation: [1,1,1,0,0,1,1,1,1,1,1]
 * Input: A = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3, Output: 10
 * Explanation: [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
 *
 * sliding window:
 * the longest subarray that contains at most K 0s
 */
public class MaxConsecutiveOnes_III {
    public int longestOnes(int[] A, int K) {
        int i = 0;
        int j;
        for (j = 0; j < A.length; j++) {
            if (A[j] == 0) K--;
            if (K < 0 && A[i++] == 0) K++;
//            if (K < 0 && A[i] == 0) {
//                K++;
//                i++;
//            }
        }
        return j - i;
    }
}
