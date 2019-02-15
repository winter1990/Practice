package practice.leetcode.medium;

import java.util.LinkedList;
import java.util.List;

/**
 * @recursion
 * @backtracking
 *
 * Given a collection of distinct numbers, return all possible permutations.
 *
 * recursion:
 * base case - list.len=num.len
 * insert into each position
 * [123]->[1],[21][12],[321][231][213] [312][132][123]
 */
public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        List<Integer> init = new LinkedList<>();
        init.add(nums[0]);
        res.add(init);
        for (int i = 1; i < nums.length; i++) {
            int val = res.size();
            for (int j = 0; j < val; j++) {
                List<Integer> list = res.get(0);
                for (int k = 0; k <= list.size(); k++) {
                    list.add(k, nums[i]);
                    res.add(new LinkedList<>(list));
                    list.remove(k);
                }
                res.remove(0);
            }
        }
        return res;
    }

    public List<List<Integer>> permute1(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        helper(nums, new LinkedList<>(), res);
        return res;
    }

    private void helper(int[] nums, LinkedList<Integer> list, List<List<Integer>> res) {
        if (list.size() == nums.length) {
            res.add(new LinkedList<>(list));
        }
        for (int i = 0; i < nums.length; i++) {
            if (list.contains(nums[i])) continue;
            list.add(nums[i]);
            helper(nums, list, res);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        Permutations p = new Permutations();
        int[] in = {1,2,3};
        System.out.println(p.permute(in));
    }
}
