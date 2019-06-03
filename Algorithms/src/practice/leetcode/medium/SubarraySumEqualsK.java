package practice.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @array
 *
 * Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose
 * sum equals to k.
 *
 * our target is to total number of subarrays
 *
 * brute force
 * i = [0 n-2]
 *   j = [i+1 n-1]
 *     get sum and check if equals to k
 *
 * optimization
 * we are calculate the sum of sub array multiple times
 * if we calculate the pre sum
 * [1 3 2 -1 4 -2 6] target = 4, [1 3] [3 2 -1] [4] [-2 6]
 *  1 4 6  5 9  7 13
 * we are looking for the number of pairs of (i,j) where i < j
 *   so that sum[j]-sum[i]=target
 *   sum[j]-target=sum[i]
 * keep track of sum[i] when traversing the array, and count the pre sum
 * find if map has (sum - target), res += value, add sum to map
 */
public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)) count += map.get(sum - k);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        SubarraySumEqualsK s = new SubarraySumEqualsK();
        int[] in = {0,0,0,0};
        int k = 0;
        System.out.println(s.subarraySum(in, k));
    }
}