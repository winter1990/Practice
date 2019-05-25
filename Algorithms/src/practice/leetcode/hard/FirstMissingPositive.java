package practice.leetcode.hard;

/**
 * @array
 *
 * Given an unsorted integer array, find the smallest missing positive integer.
 *
 * problems to solve:
 * 1. unsorted
 * 2. smallest missing positive
 * 3. handle the negative numbers
 *
 * brute force:
 * arrays.sort(arr) - O(nlogn)
 * iterate the array and find the first missing - O(n)
 *
 * we are looking for FIRST missing POSITIVE
 * [1,2,0] return 3
 * [3,4,-1,1] return 2
 * [2,-1,-3,4,3] return 1
 * [2,-3,-1,10,4,1],[-3,2,-1,10,4,1],[-3,2,-1,4,10,1],[1,2,-1,4,10,-3], output: 3
 *
 * because the target is the positive numbers
 * we can sort the positive elements and put them to a[i]-1 index
 *   if a[i] <= len, swap it to the index a[i]-1
 *   [10 2 3 -1] 10 is out of bound, skip it as the missing value must be smaller than
 *   [4 3 2 1] the threshold is a.length
 *     if larger, the missing value must be smaller than that
 * the conditions for swapping:
 *   element not at position a[i] != i + 1
 *   a[i] > 0
 *   a[i] <= n
 *     if position is taken a[i] = a[a[i]-1], break
 * scan the array again to get the first missing a[i] ? (i+1)
 */
public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) return 1;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] != i + 1 && nums[i] <= n) {
                if (nums[i] == nums[nums[i] - 1]) break;
                int tmp = nums[i];
                nums[i] = nums[tmp - 1];
                nums[tmp - 1] = tmp;
            }
        }
        int i = 0;
        for (; i < n; i++) {
            if (nums[i] != i + 1) break;
        }
        return i + 1;
    }
}
