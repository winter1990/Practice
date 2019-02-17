package practice.leetcode.medium;

import java.util.Arrays;

/**
 * @array
 * @math
 * @pointer
 *
 * Input: [2,2,3,4] Output: 3
 * Explanation:
 * Valid combinations are:
 * 2,3,4 (using the first 2)
 * 2,3,4 (using the second 2)
 * 2,2,3
 *
 * condition to make triangle:
 * for the sides a < b < c, a + b > c
 *
 * to design the loop:
 * i=[0,n-3] l=i+1 r=n-1, if i+l>r, then all the elements from l to r-1 are ok, r-- and reset l to i + 1
 */
public class ValidTriangleNumber {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        int n = nums.length;
        for (int i = n - 1; i > 1; i--) {
            int l = 0;
            int r = i - 1;
            while (l < r) {
                if (nums[l] + nums[r] > nums[i]) {
                    count += r - l;
                    r--;
                } else {
                    l++;
                }
            }
        }
        return count;
    }
    /* biggest problem of the solution is if i + l < r
     * how we should move the pointer, we can move both left and right
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        int n = nums.length;
        for (int i = 0; i < n - 2; i++) {
            int l = i + 1;
            int r = n - 1;
            while (l < r) {
                if (nums[i] + nums[l] > nums[r]) {
                    count += r - l;
                    l = i + 1;
                    r--;
                } else {
                    l++;
                }
            }
        }
        return count;
    }
    */

    public static void main(String[] args) {
        ValidTriangleNumber v = new ValidTriangleNumber();
        int[] in = {24,3,82,22,35,84,19};
        System.out.println(v.triangleNumber(in));
    }
}
