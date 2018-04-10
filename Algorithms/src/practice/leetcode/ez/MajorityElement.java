package practice.leetcode.ez;

import java.util.HashMap;
import java.util.Map;

/**
 * The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 * assume that the array is non-empty and the majority element always exist in the array.
 *
 * use map to store the number and freq, O(n), O(n)
 */

public class MajorityElement {
    public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Integer.MIN_VALUE;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            } else {
                int freq = map.get(nums[i]);
                map.put(nums[i], freq + 1);
            }
            if (map.get(nums[i]) > (nums.length / 2)) {
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
     */
    public int majorityElement1(int[] nums) {
        int maj = nums[0];
        int count = 1;

        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                maj = nums[i];
                count++;
            } else if (nums[i] == maj) {
                count++;
            } else {
                count--;
            }
        }
        return maj;
    }
}
