package practice.leetcode.medium;


/**
 * [2,3,-2,4]->6
 * even number of negatives
 * [-2,-1,-3,-2]->12
 * [-1,-2,-3]->6
 *
 * if positive,go on
 * if negative,save min,because next neg will be largest
 * max,min store values of max/min by index i
 *
 */
public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = nums[0], min = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int tmpMax = max * nums[i];
            int tmpMin = min * nums[i];
            max = Math.max(Math.max(tmpMax, tmpMin), nums[i]);
            min = Math.min(Math.min(tmpMax, tmpMin), nums[i]);
            if (max > res) {
                res = max;
            }
        }
        return res;
    }
}
