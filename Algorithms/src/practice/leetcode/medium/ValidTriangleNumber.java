package practice.leetcode.medium;

import java.util.Arrays;

/**
 * @array
 * @math
 *
 * Given an array consists of non-negative integers, your task is to count the number of triplets chosen from the
 * array that can make triangles if we take them as side lengths of a triangle.
 *
 * Input: [2,2,3,4] Output: 3
 * Explanation:
 * Valid combinations are:
 * 2,3,4 (using the first 2)
 * 2,3,4 (using the second 2)
 * 2,2,3
 *
 * condition to make triangle:
 *   for the sides a < b < c, a + b > c
 * one element can only be used for on triangle
 *
 * compared with the 3 sum, we have 3 pointers i < j < l, and fix the i and check j & k
 *   target = a[i] + a[j] + a[k]
 *   if larger than target, then k--, otherwise j++
 *
 * the difference of this problem is:
 *   if we fix i, a[i] + a[j] > a[k], then all the values between j = [j, k-1] are valid combinations
 *   but if a[i] + a[j] <= a[k], there are two options move j to right and move k to left
 *   if we do not know which pointer to move, we can only use brute force method which is O(N^3)
 *
 * instead, we fix a[k]:
 *   if a[i] + a[j] <= a[k], we can only move i to right
 *   if a[i] + a[j] > a[k], then all the elements between [i, j-1] are valid
 */
public class ValidTriangleNumber {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length, count = 0;
        for (int i = n - 1; i > 1; i--) {
            int l = 0, r = i - 1;
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

    /**
     * because of the condition of a + b > c, we need to sort the array first
     * find the triplets
     *   i = [0, n-3]
     *   j = i + 1
     *   k = n - 1
     *   if i + j > k, then all the elements from j to k-1 meet the condition
     *   r-- and reset l to i + 1
     *
     * wrong solution:
     * biggest problem of the solution is if i + l < r
     * we can move both left and right pointers
     * [3 22 19 24 35 82 84]
     */
    public int triangleNumber1(int[] nums) {
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

    public static void main(String[] args) {
        ValidTriangleNumber v = new ValidTriangleNumber();
        int[] in = {24,3,82,22,35,84,19};
        System.out.println(v.triangleNumber1(in));
    }
}
