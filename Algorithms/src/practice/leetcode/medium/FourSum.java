package practice.leetcode.medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * similar to 3sum
 * i=0,j=i+1
 * left & right
 */
public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new LinkedList<>();
        if (nums == null || nums.length < 4) {
            return res;
        }
        int len = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < len - 3; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < len - 2; j++) {
                if (j != i + 1 && nums[j] == nums[j - 1]) continue;
                int m = j + 1;
                int n = len - 1;
                while (m < n) {
                    int sum = nums[i] + nums[j] + nums[m] + nums[n];
                    if (sum == target) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[m], nums[n]));
                        m++;
                        n--;
                        while (m < n && nums[m] == nums[m - 1]) m++;
                        while (m < n && nums[n] == nums[n + 1]) n--;
                    } else if (sum > target) {
                        n--;
                    } else {
                        m++;
                    }
                }
            }
        }
        return res;
    }
}
