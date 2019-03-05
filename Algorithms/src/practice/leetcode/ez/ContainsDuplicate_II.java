package practice.leetcode.ez;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @array
 * @slidingwindow
 *
 * Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array
 * such that nums[i] = nums[j] and the absolute difference between i and j is at most k.
 *
 * method 1: use a hash map to store the last index. if not found, put value-index. otherwise get index and i-lastIndex
 *
 * method 2: sliding window. use a set to store all the numbers in the window. maintain all the numbers within the window
 * start from 0, if (i < k) put visited numbers in set,
 */
public class ContainsDuplicate_II {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length < 2) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                if (i - map.get(nums[i]) <= k) {
                    return true;
                }
            }
            map.put(nums[i], i);
        }
        return false;
    }

    /**
     * @slidingwindow
     */
    public boolean containsNearbyDuplicate1(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > k)
                set.remove(nums[i - k - 1]);
            if (!set.add(nums[i]))
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] in1 = {1,2,1};
        ContainsDuplicate_II app = new ContainsDuplicate_II();
    }
    /*
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length < 2) {
            return false;
        }
        Map<Integer, Integer> left = new HashMap<>();
        Map<Integer, Integer> right = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (!left.containsKey(nums[i])) {
                left.put(nums[i], i);
            }
            right.put(nums[i], i);
            int diff = right.get(nums[i]) - left.get(nums[i]);
            if (diff > 0 && diff <= k) {
                return true;
            }
        }
        return false;
    }
    */
}
