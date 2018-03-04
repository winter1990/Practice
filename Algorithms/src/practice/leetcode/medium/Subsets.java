package practice.leetcode.medium;

import java.util.LinkedList;
import java.util.List;

/**
 * Given a set of distinct integers, nums, return all possible subsets (the power set).
 *
 * n! subset total
 * 1 2 3
 * .
 *   .
 *     .
 * . .
 * .   .
 *   . .
 * . . .
 */
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        double n = Math.pow(2, nums.length);
        for (int i = 0; i < n; i++) {
            List<Integer> list = new LinkedList<>();
            for (int j = 0; j < nums.length; j++) {
                if ((i >> j & 1) == 1) {
                    list.add(nums[j]);
                }
            }
            res.add(list);
        }
        return res;
    }

    public List<List<Integer>> subsets1(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        res.add(new LinkedList<>());
        for (int i = 0; i < nums.length; i++) {
            int size = res.size();
            while (size-- > 0) {
                List<Integer> list = new LinkedList<>(res.get(size));
                list.add(nums[i]);
                res.add(list);
            }
        }
        return res;
    }
}
