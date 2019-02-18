package practice.leetcode.medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @recursion
 *
 * collection of integers that might contain duplicates
 * [1 2 2 2 3] we want to add 2, 2 2, and 2 2 2 to the sub-list [1] once only
 * so for each recursive call, add to resat the beginning of the recursion
 * for each number in the array, check and compare with previous number
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

    /**
     * iterative solution
     * [1 2 2 3], [], [1], [2] [1 2], [2 2][1 2 2]
     * need to keep track where we need to start and get sub-list in result list
     * for duplicate numbers, we need to skip the sub-list that already traversed in last iteration
     */
    public List<List<Integer>> subsetsWithDup1(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        Arrays.sort(nums);
        int pre = 0;
        res.add(new LinkedList<>());
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                pre = 0;
            }
            int start = res.size();
            for (int j = pre; j < start; j++) {
                List<Integer> list = new LinkedList<>(res.get(j));
                list.add(nums[i]);
                res.add(list);
            }
            pre = start;
        }
        return res;
    }
}