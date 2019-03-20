package practice.leetcode.hard;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @array
 * @slidingwindow
 *
 * Given an array A of positive integers, call a (contiguous, not necessarily distinct) subarray of A good if
 * the number of different integers in that subarray is exactly K.
 * Input: A = [1,2,1,2,3], K = 2, Output: 7
 * [1,2], [2,1], [1,2], [2,3], [1,2,1], [2,1,2], [1,2,1,2]
 * <p>
 * when see word "distinct", Set comes to my mind naturally
 */
public class SubarraysWithKDifferentIntegers {
    /**
     * optimization
     * use hash map to track the occurrences and two pointers
     * the right pointer starts from 0 to n-1
     * how to maintain the window and its size
     * maintain the window before window contains more than k different chars
     * 1 2 1 2 3, total 7 [1 2] [1 2 1] [2 1] [1 2 1 2] [2 1 2] [1 2] [2 3]
     * [1 2 1 2 3 4 4 5] k = 4, we need to count the subarray before we see k different chars
     * if char occurrence is 1, cannot update the window's left bound
     * maintain the window size, we want the occurrences of each char as small as possible
     * when moving the left pointer, update the sub total
     * example 1 2 1 2 -> 1 2 (each char appears once) -> 1 2 1, remove a 1 as it appears more than once
     * -> 2 1 and subtotal = 1 -> 2 1 2, remove leftmost 2 -> 2 1, subtotal = 2
     * when we see the map size = k, result += subtotal + 1
     * if more than k diff chars in the window, remove a[l] in the map, update subtotal to 0
     */
    public int subarraysWithKDistinct(int[] A, int K) {
        if (A == null || A.length == 0) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        int l = 0, r = 0, res = 0, total = 0;
        while (r < A.length) {
            map.put(A[r], map.getOrDefault(A[r], 0) + 1);
            if (map.size() > K) {
                map.remove(A[l]);
                l++;
                total = 0;
            }
            while (map.get(A[l]) > 1) {
                total++;
                map.put(A[l], map.get(A[l]) - 1);
                l++;
            }
            if (map.size() == K) {
                res += (total + 1);
            }
            r++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] in = new int[]{1, 2, 1, 2, 3, 4,4,5};
        SubarraysWithKDifferentIntegers sd = new SubarraysWithKDifferentIntegers();
        System.out.println(sd.subarraysWithKDistinct(in, 4));
    }

    /**
     * solution is correct but time limit exceeded for large input
     * O(N^2)
     */
    public int subarraysWithKDistinct1(int[] A, int K) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int n = A.length;
        int count = 0;
        Set<Integer> set;
        for (int i = 0; i < n; i++) {
            set = new HashSet<>();
            set.add(A[i]);
            for (int j = i; j < n; j++) {
                set.add(A[j]);
                if (set.size() == K) {
                    count++;
                } else if (set.size() > K) {
                    break;
                }
            }
        }
        return count;
    }

}
