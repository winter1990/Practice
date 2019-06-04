package practice.leetcode.easy;

import java.util.Arrays;

/**
 * @array
 *
 * Given an integer array, you need to find one continuous subarray that if you only sort this subarray in
 * ascending order, then the whole array will be sorted in ascending order, too.
 * You need to find the shortest such subarray and output its length.
 *
 * method 1
 * sort the whole array
 * two pointers l = 0, r = n - 1, move two pointers when the sorted[i] = arr[i]
 * return r - l + 1
 * O(NlogN + N), O(N)
 *
 * method 2
 * optimization
 * partition the array into three parts:
 *   left middle and right
 *   the largest in left <= smallest in the middle
 *   largest in the middle <= smallest in the right part
 * [2 6 9 8 16 4 15 18], output 6, the subarray [6 9 8 16 4 15]
 * scan from left to right
 *   keep track of the maximum value
 *   if a[i] is the maximum, it means all the elements after i should be larger than a[i]
 *   if there is an element a[j] which is smaller than maximum, then all elements in range [i, j] should be sorted
 * scan from right to left
 *   keep track of the minimum
 *   if a[j] is minimum, all the elements before j should be smaller
 *   if a[k] > a[j], then all elements between [k, j] should be sorted
 */
public class ShortestUnsortedContinuousSubarray {
    public int findUnsortedSubarray1(int[] nums) {
        int n = nums.length, r = -1, l = 0, max = nums[0], min = nums[n - 1];
        for (int i = 0; i < n; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[n - 1 - i]);
            if (nums[i] < max) r = i;
            if (nums[n - 1 - i] > min) l = n - 1 - i;
        }
        return r - l + 1;
    }

    public int findUnsortedSubarray(int[] nums) {
        int[] copy = nums.clone();
        Arrays.sort(copy);
        int l = 0, r = nums.length - 1;
        while (l <= r && nums[l] == copy[l]) l++;
        while (l <= r && nums[r] == copy[r]) r--;
        return r - l + 1;
    }

    public static void main(String[] args) {
        int[] input = {1,2,3,4};
        ShortestUnsortedContinuousSubarray s = new ShortestUnsortedContinuousSubarray();
        System.out.println(s.findUnsortedSubarray(input));
    }
}
