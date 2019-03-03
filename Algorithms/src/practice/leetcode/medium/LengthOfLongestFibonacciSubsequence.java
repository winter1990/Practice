package practice.leetcode.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * @array
 *
 * Given a strictly increasing array A of positive integers forming a sequence, find the length of the longest
 * fibonacci-like subsequence of A.  If one does not exist, return 0.
 *
 * Input: [1,2,3,4,5,6,8], Output: 5, [1,2,3,5,8]
 * Input: [1,3,7,11,12,14,18], Output: 3, [1,11,12], [3,11,14] or [7,11,18]
 *
 * two pointers
 * i [0,n-2, j [i+1,n-1]
 * sum up and check whether the sum exists in the array -> for quick look up, add all numbers in a set
 *
 */
public class LengthOfLongestFibonacciSubsequence {
    public int lenLongestFibSubseq(int[] A) {
        Set<Integer> set = new HashSet<>();
        for (int a : A) {
            set.add(a);
        }
        int maxLen = 2;
        for (int i = 0; i < A.length - 1; i++) {
            for (int j = i + 1; j < A.length; j++) {
                int a = A[i], b = A[j], curLen = 2;
                while (set.contains(a + b)) {
                    curLen++;
                    b += a;
                    a = b - a;
                }
                maxLen = Math.max(maxLen, curLen);
            }
        }
        return maxLen > 2 ? maxLen : 0;
    }
}
