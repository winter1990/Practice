package practice.leetcode.medium;

import java.util.Arrays;

/**
 * @array
 *
 * You are given n pairs of numbers. In every pair, the first number is always smaller than the second number.
 *
 * Now, we define a pair (c, d) can follow another pair (a, b) if and only if b < c. Chain of pairs can be formed
 * in this fashion.
 *
 * Given a set of pairs, find the length longest chain which can be formed. You needn't use up all the given pairs.
 * You can select pairs in any order.
 *
 * [1 25] [2 3] [4 10] [5 6] [7 9]
 * sort the pairs based on start
 * use a heap to store when it ends and count
 */
public class MaximumLengthOfPairChain {
    public int findLongestChain(int[][] pairs) {
        if (pairs == null || pairs.length == 0) return 0;
        Arrays.sort(pairs, (p1, p2) -> p1[1] - p2[1]);
        int count = 1;
        int[] cur = pairs[0];
        for (int i = 1; i < pairs.length; i++) {
            if (cur[1] < pairs[i][0]) {
                count++;
                cur = pairs[i];
            }
        }
        return count;
    }
}
