package practice.leetcode.medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * no duplicates
 * same number can be repeated
 *
 * recursion:
 * base case 1.num[i]=target res.add 2.num[i]>target, return and remove
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new LinkedList<>();
        if (candidates == null || candidates.length == 0) {
            return res;
        }
        Arrays.sort(candidates);
        helper(candidates, 0, target, new LinkedList<>(), res);
        return res;
    }

    private void helper(int[] candidates, int index, int target, LinkedList<Integer> list, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new LinkedList<Integer>(list));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (candidates[i] > target) return;
            list.add(candidates[i]);
            helper(candidates, i, target - candidates[i], list, res);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        CombinationSum cs = new CombinationSum();
        int[] in = {2,3,6,7};
        System.out.println(cs.combinationSum(in, 7));
    }

}
