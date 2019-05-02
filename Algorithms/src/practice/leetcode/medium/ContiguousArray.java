package practice.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @array
 *
 * Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.
 * Input: [0,1], Output: 2
 * Input: [0,1,0], Output: 2
 *
 * [1 0 0 1 1 0 0 1 1 1]
 *  1 1 1 2 3 3 3 4 5 6
 *
 * 0 and 1 must be paired and continuous
 * keep track of the preSum
 * if we want the subarray "balanced" which means same 0s and 1s:
 *   all number of 1s = length / 2
 *   but if preSum=n, we are looking for another n 0s in the array and we do not know where are they
 *   so, another way to make it balanced is counting each of them. if 1, sum++ else if 0 sum--
 *     if presum = k > 0, then it means there are k more 1s than 0s
 *     otherwise k < 0, k more 0s than 1s
 *   we need to find the index that last time preSum = k occurs, so the subarray between is balanced
 *     use a map to track
 */
public class ContiguousArray {
    public int findMaxLength(int[] nums) {
        int sum = 0, max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                sum++;
            } else {
                sum--;
            }
            if (map.containsKey(sum)) {
                max = Math.max(max, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }
        return max;
    }
}
