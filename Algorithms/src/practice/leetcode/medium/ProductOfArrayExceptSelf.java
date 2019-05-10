package practice.leetcode.medium;

/**
 * @math
 * @array
 *
 * Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the
 * product of all the elements of nums except nums[i].
 *
 * Note: Please solve it without division and in O(n).
 * Follow up:
 * Could you solve it with constant space complexity?
 * (The output array does not count as extra space for the purpose of space complexity analysis.)
 *
 * define result array, res[i] represents the product value without the nums[i] element
 * for i = [1, n-1], res[i] = res[i-1]*nums[i-1]
 * for i = [
 */
public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        int m = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= m;
            m *= nums[i];
        }
        return res;
    }

    public int[] productExceptSelf1(int[] nums) {
        int n = nums.length;
        int[] ltr = new int[n], rtl = new int[n];
        ltr[0] = 1;
        for (int i = 1; i < n; i++) ltr[i] = ltr[i - 1] * nums[i - 1];
        rtl[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) rtl[i] = rtl[i + 1] * nums[i + 1];
        int[] res = new int[n];
        for (int i = 0; i < n; i++) res[i] = ltr[i] * rtl[i];
        return res;
    }

    public static void main(String[] args) {
        ProductOfArrayExceptSelf p = new ProductOfArrayExceptSelf();
        int[] in = {2,3};
        p.productExceptSelf1(in);
    }
}
