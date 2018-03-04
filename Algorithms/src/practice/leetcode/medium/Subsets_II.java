package practice.leetcode.medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * collection of integers that might contain duplicates
 *
 * every time, at the beginning of the recursion
 * add number to list
 * duplicates:
 * in for loop, check if a[i]=a[i-1], skip
 */
public class Subsets_II {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        Arrays.sort(nums);
        helper(nums, 0, new LinkedList<Integer>(), res);
        return res;
    }

    private void helper(int[] nums, int index, LinkedList<Integer> list, List<List<Integer>> res) {
        res.add(new LinkedList<>(list));
        for (int i = index; i < nums.length; i++) {
            if (i != index && nums[i] == nums[i - 1]) {
                continue;
            }
            list.add(nums[i]);
            helper(nums, i + 1, list, res);
            list.remove(list.size() - 1);
        }
    }
}
