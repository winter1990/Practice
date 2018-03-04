package practice.leetcode.medium;

import java.util.TreeSet;

/**
 * abs(nums[i]-nums[j]) <= t
 * abs(i-j) <= k
 *
 * maintain the window size k - BST
 *
 * TreeSet ceiling:
 * Returns the least element in this set greater than or equal to the given element, or null if there is no such element.
 * TreeSet floor:
 * Returns the greatest element in this set less than or equal to the given element, or null if there is no such element.
 *
 */
public class ContainsDuplicate_III {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length < 2 || k == 0) {
            return false;
        }
        TreeSet<Long> set = new TreeSet<>();
        int i = 0;
        while (i < nums.length) {
            Long floor = set.floor((long) nums[i]);
            Long ceiling = set.ceiling((long) nums[i]);
            if ((floor != null && nums[i] - floor <= t ) || (ceiling != null && ceiling - nums[i] <= t)) {
                return true;
            }
            set.add((long) nums[i++]);
            if (i > k) {
                set.remove((long) nums[i - k - 1]);
            }
        }
        return false;
    }
}
