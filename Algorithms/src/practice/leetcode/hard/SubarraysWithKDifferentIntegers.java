package practice.leetcode.hard;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @array Input: A = [1,2,1,2,3], K = 2, Output: 7
 * [1,2], [2,1], [1,2], [2,3], [1,2,1], [2,1,2], [1,2,1,2]
 * <p>
 * when see word "distinct", Set comes to my mind naturally
 */
public class SubarraysWithKDifferentIntegers {
    public int subarraysWithKDistinct(int[] A, int K) {
        int ret = 0, l = 0, r = 0, accumu = 0;
        Map<Integer, Integer> map = new HashMap<>(K);
        while (r < A.length) {
            map.put(A[r], map.getOrDefault(A[r], 0) + 1);
            if (map.size() > K) {
                map.remove(A[l]);
                accumu = 0;
                l++;
            }
            while (map.get(A[l]) > 1) {
                accumu++;
                map.put(A[l], map.get(A[l]) - 1);
                l++;
            }
            if (map.size() == K) {
                ret += accumu + 1;
            }
            r++;
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] in = new int[]{1, 2, 1, 3, 4};
        SubarraysWithKDifferentIntegers sd = new SubarraysWithKDifferentIntegers();
        System.out.println(sd.subarraysWithKDistinct(in, 3));
    }

    // solution is correct but time limit exceeded for large input
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
