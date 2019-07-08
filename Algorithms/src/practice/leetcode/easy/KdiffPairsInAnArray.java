package practice.leetcode.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @array
 *
 * Given an array of integers and an integer k, you need to find the number of unique k-diff pairs in the array.
 * Here a k-diff pair is defined as an integer pair (i, j), where i and j are both numbers in the array and their
 * absolute difference is k.
 *
 * problems to solve:
 * 1. abs() = k
 * 2. we do not consider the duplicates
 * 3. same number can be used for smaller or larger in the pairs - [1 3 5] k = 2
 *
 * method 1
 * sort the array
 * skip the same elements and find the difference
 *
 *
 * method 2
 * without sorting
 * Input: [3 1 4 1 5 3], k = 2, Output: 2, [1 3] and [3 5]
 * for any element, there are two cases:
 *   exists in previous sub array
 *   not exists in previous sub array
 * if exists
 *   there is only one case that it should be counted - k = 0
 *   to avoid duplicates for [1 1 1 1], we count the frequency of the number and if k = 0 and occurrence = 1, res++
 * else
 *   two cases should be counted
 *     a[i] + k, check if exists
 *     a[i] - k, check if exists
 *   put (a[i],1) in the map
 *
 */
public class KdiffPairsInAnArray {
    public int findPairs(int[] nums, int k) {
        if (k < 0) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int i : nums) {
            if (map.containsKey(i)) {
                if (k == 0 && map.get(i) == 1) res++;
                map.put(i, map.get(i) + 1);
            } else {
                if (map.containsKey(i + k)) res++;
                if (map.containsKey(i - k)) res++;
                map.put(i, 1);
            }
        }
        return res;
    }

    public int findPairs1(int[] nums, int k) {
        if (k < 0) return 0;
        Set<Integer> seen = new HashSet<>();
        Set<String> pair = new HashSet<>();
        for (int i : nums) {
            if (seen.contains(i + k)) {
                pair.add(i + " " + (i + k));
            }
            if (seen.contains(i - k)) {
                pair.add(i - k + " " + i);
            }
            seen.add(i);
        }
        return pair.size();
    }

    public static void main(String[] args) {
        int[] in = //{1,1,1,1,1};
        {1, 3, 1, 5, 4};
//         {3, 1, 4, 1, 5, 3, 5};
//         {1, 2, 3, 4, 5};
        int d = 2;
        KdiffPairsInAnArray k = new KdiffPairsInAnArray();
        System.out.println(k.findPairs1(in, d));
    }
}
