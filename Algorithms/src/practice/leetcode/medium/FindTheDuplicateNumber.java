package practice.leetcode.medium;

/*
n + 1 integers where each integer is between 1 and n (inclusive)

You must not modify the array (assume the array is read only).
You must use only constant, O(1) extra space.
Your runtime complexity should be less than O(n^2).
There is only one duplicate number in the array, but it could be repeated more than once.
 */

/**
 * bit? not work if n>32
 * normal searching alg not work, can not sort
 *
 * add all
 * 1234,2234 2224
 * 10   11   10
 * no
 *
 * 1223
 */
public class FindTheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int slow = nums[0];
        int fast = nums[nums[0]];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        fast = 0;
        while (fast != slow) {
            fast = nums[fast];
            slow = nums[slow];
        }
        return slow;
    }
}
