package practice.leetcode.ez;

import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * @tree
 * @array
 * @slidingwindow
 *
 * Given an array of integers, find out whether there are two distinct indices i and j in the array
 * such that the absolute difference between nums[i] and nums[j] is at most t and the absolute difference
 * between i and j is at most k
 *
 * a[i] - a[j] <= t, and i - j <= k, abs
 * TreeMap, can provide floor / roof value for given key value
 * key - a[i], value - index
 * if we maintain the window size of k, then we do not need to keep track of the value
 * so, use tree set as the ds to store the values
 *
 *
 */
public class ContainsDuplicate_III {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length ==0 || k <= 0 || t < 0) {
            return false;
        }
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            long n = nums[i];
            Long floor = set.floor(n + t);
            Long ceiling = set.ceiling(n - t);
            if ((floor != null && floor >= n) || (ceiling != null && ceiling <= n)) {
                return true;
            }
            set.add(n);
            if (i >= k) {
                set.remove((long)nums[i - k]);
            }
        }
        return false;
    }
}
