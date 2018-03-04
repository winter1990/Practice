package practice.leetcode.medium;

import java.util.Arrays;

/**
 * sort the array
 * i [0,n-3]
 * j,k start and end
 * update res
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
        int res = Integer.MAX_VALUE / 2;
        for (int i = 0; i < len - 2; i++) {
            int j = i + 1;
            int k = len - 1;
            while (j < k) {
                int val = nums[i] + nums[j] + nums[k];
                if (val == target) {
                    return target;
                } else if (val > target) {
                    k--;
                } else {
                    j++;
                }
                res = Math.abs(val - target) < Math.abs(res - target) ? val : res;
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
