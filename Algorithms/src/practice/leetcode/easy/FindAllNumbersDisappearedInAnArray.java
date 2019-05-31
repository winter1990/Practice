package practice.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @array
 *
 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once
 * Find all the elements of [1, n] inclusive that do not appear in this array.
 * Could you do it without extra space and in O(n) runtime?
 * You may assume the returned list does not count as extra space.
 *
 * [4,3,2,7,8,2,3,1], Output: [5,6]
 *
 * keep swap the a[i] to the index i - 1, until all the elements are "sorted"
 * another pass of the array to check if a[i] = i + 1
 *
 * or mark the element as negative which means it is not missing
 */
public class FindAllNumbersDisappearedInAnArray {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0) nums[index] = -nums[index];
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) res.add(i + 1);
        }
        return res;
    }
}
