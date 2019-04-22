package practice.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @array
 * @dp
 *
 * Given an array A of integers, return the length of the longest arithmetic subsequence in A.
 * Input: [3,6,9,12] Output: 4 -> [3 6 9 12]
 * Input: [9,4,7,2,10] Output: 3 -> [4 7 10]
 * Input: [20,1,15,3,10,5,8] Output: 4 -> [20 15 10 5]
 *
 * problems to solve:
 * 1. keep track of the difference between two values
 * 2. find the longest
 *
 * [9,4,6,7,4,10,2,0]
 * the length of array must be larger than 1
 * two pointers:
 * i = 0, j = [1,n-1] -> -5 -3 -2 -5  1 -7 -9
 * i = 1, j = [2,n-1] ->  2  3  0  6 -2 -4
 * i = 2, j ] [3,n-1] ->  1 -2  4 -4 -6
 * ...
 *
 * dynamic programming
 * need to track:
 *   the difference compared to previous elements
 *   the longest length so far
 *
 * difference between putIfAbsent() and computeIfAbsent()
 * computeIfAbsent takes a mapping function, that is called to obtain the value if the key is missing
 * putIfAbsent takes the value directly.
 * computeIfAbsent returns "the current (existing or computed) value associated with the specified key,
 * or null if the computed value is null".
 * putIfAbsent returns "the previous value associated with the specified key, or null if there was no mapping for the key".
 *
 */
public class LongestArithmeticSequence {
    public int longestArithSeqLength(int[] A) {
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        int res = 1;
        for (int i = 0; i < A.length - 1; i++) {
            for (int j = i + 1; j < A.length; j++) {
                int diff = A[j] - A[i];
                Map<Integer, Integer> path = map.get(diff);
                if (path == null) {
                    path = new HashMap<Integer, Integer>();
                    path.put(j, 1);
                    map.put(diff, path);
                } else {
                    int c = path.getOrDefault(i, 0) + 1;
                    path.put(j, c);
                    res = Math.max(c, res);
                }
            }
        }
        return res + 1;
    }

    public static void main(String[] args) {
        LongestArithmeticSequence l = new LongestArithmeticSequence();
        int[] in = {25,78,45,27,75,10,90,77,60,8,43,5,55,47,57,17,8,63,18,69,63,87,35,19,78,42,25,27,24,23,88,56,14,42,16,64,8,62,48,76,66,75,59,43,16,11,15,41,20,34,69,69,58,42,22,27,79,81,63,59,57,51,11,48,89,29,30,79,40,87,17,24,16,82,18,9,86,9,90,74,17,21,8,18,24,62,8,31,84,56,70,59,55,22,44,31,11,82,80,38};
        System.out.println(l.longestArithSeqLength(in));
    }
}
