package practice.leetcode.medium;


/**
 * @array
 * @math
 *
 * [2, 3, -2, 4]->6
 * as many positive numbers as possible
 * if negative number, even number of negatives are ok
 * key problem becomes, when we see only one negative, should we skip and reset the product as zero?
 * a positive multiply a negative, and this minimum number is potentially becoming the largest if there is a second neg
 * [-2,-1,-3,-2] -> 12
 * [-1,-2,-3]->6
 * [2 3 -2 4 -1] -> product [2 6 -12 -48 48]
 * [-1 2 3 -2 4] -> product [-1 -2 -6 12 48]
 * we do not ignore the negative value
 * [-1 2 2 -1 -2]
 * when to start a new subarray
 * [-1 2 5]
 * [1 -5 2 -1]
 * need to compare with the current element
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
