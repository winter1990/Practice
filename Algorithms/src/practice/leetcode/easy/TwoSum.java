package practice.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @array
 *
 * brute force:
 * i = [0, n - 2]
 *   j = [i + 1, n]
 *     sum = a[i] + a[j]
 *     if sum = target, then return the indices
 * time O(N^2), space O(1)
 *
 * the problem of brute force solution is:
 *   the same value is added multiple (N) times to calculate the sum
 *   in this problem, target value is fixed, so for each element in array, we keep track of the subtraction
 *   x + a[i] = target, then x = target - a[i] and x is our next target
 * as we need to return the index, use a map to track the new target and index
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return new int[] {map.get(nums[i]), i};
            }
            map.put(target - nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
