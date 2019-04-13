package practice.leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @array
 *
 * The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 * assume that the array is non-empty and the majority element always exist in the array.
 *
 * use a hash map to store the number and freq, O(n), O(n)
 */

public class MajorityElement {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            } else {
                int freq = map.get(nums[i]);
                map.put(nums[i], freq + 1);
            }
            if (map.get(nums[i]) > nums.length / 2) {
                return nums[i];
            }
        }
        return Integer.MIN_VALUE;
    }

    /**
     * more than n/2 times - 1 2 3 3 3 or 1 2 3 4 4 4 4
     * 1 2 1 2 1
     *
     * use a counter
     * when to update, when ++ when -- when update maj
     * O(n) time, O(1) space
     */
    public int majorityElement1(int[] nums) {
        int count = 0, maj = 0;
        for (int n : nums) {
            if (count == 0) {
                maj = n;
            }
            if (n == maj) {
                count++;
            } else {
                count--;
            }
        }
        return maj;
    }

    /**
     * sort the array and get the element in the middle
     * time O(nlogn)
     */
    public int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}
