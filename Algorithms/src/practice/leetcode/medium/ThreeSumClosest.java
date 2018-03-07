package practice.leetcode.medium;

import java.util.Arrays;

/**
 * sort the array
 * the range of i: [0,n-2)
 * j=i+1,k=len-1 start and end index
 * sum up the 3 numbers and compare with target, calculate absolute value
 *
 * initial value of res
 * if res=MAX, res-target>MAX easy to get overflow.
 * can choose some big number, MAX/2
 *
 */
public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return Integer.MIN_VALUE;
        }
        Arrays.sort(nums);
        int len = nums.length;
        int res = nums[0] + nums[1] + nums[len - 1];
        for (int i = 0; i < len - 2; i++) {
            int j = i + 1;
            int k = len - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == target) {
                    return target;
                } else if (sum > target) {
                    k--;
                    while (j < k && nums[k] == nums[k + 1]) k--;
                } else {
                    j++;
                    while (j < k && nums[j] == nums[j - 1]) j++;
                }
                res = Math.abs(sum - target) < Math.abs(res - target) ? sum : res;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] in = {-3, -2, -5, 3, -4};
        ThreeSumClosest ts = new ThreeSumClosest();
        System.out.println(ts.threeSumClosest(in, -1));
    }
}
