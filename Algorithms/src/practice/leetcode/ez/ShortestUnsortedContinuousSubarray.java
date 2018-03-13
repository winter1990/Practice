package practice.leetcode.ez;

import java.util.Arrays;

public class ShortestUnsortedContinuousSubarray {
    public int findUnsortedSubarray(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }
        int[] copy = nums.clone();
        Arrays.sort(copy);
        int left = 0;
        int right = nums.length - 1;
        while (left <= right && nums[left] == copy[left]) left++;
        while (left <= right && nums[right] == copy[right]) right--;
        return right - left + 1;
    }

    // to optimize the solution in time
    public int findUnsortedSubarray1(int[] nums) {
        int n = nums.length;
        int min = nums[n - 1];
        int max = nums[0];
        int start = -1;
        int end = -2;
        for (int i = 1; i < n; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[n - 1 - i]);
            if (max > nums[i]) {
                end = i;
            }
            if (nums[n - 1 - i] > min) {
                start = n - 1 - i;
            }
        }
        return end - start + 1;
    }

    public static void main(String[] args) {
        int[] input = {1,2,3,4};
        ShortestUnsortedContinuousSubarray s = new ShortestUnsortedContinuousSubarray();
        System.out.println(s.findUnsortedSubarray(input));
    }
}
