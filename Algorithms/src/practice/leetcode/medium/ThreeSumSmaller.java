package practice.leetcode.medium;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * sort first
 * 3 pointers
 * fix one, and move
 */
public class ThreeSumSmaller {
    public int threeSumSmaller(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        Arrays.sort(nums);
        int res = 0;
        int len = nums.length;
        for (int i = 0; i < len - 2; i++) {
            int left = i + 1;
            int right = nums[len - 1];
            while (left < right) {
                if (nums[i] + nums[left] + nums[right] < target) {
                    res += (right - left);
                    left++;
                } else {
                    right--;
                }
            }
        }
        return res;
    }
}
