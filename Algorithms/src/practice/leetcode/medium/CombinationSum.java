package practice.leetcode.medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @recursion
 *
 * no duplicates
 * same number can be repeated
 *
 * recursion:
 * sort the array
 * base case:
 * - sub list found: num[i]=target res.add(new list)
 * - no need to proceed: num[i]>target, return and remove
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
        if (candidates[index] > target) {
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            list.add(candidates[i]);
            helper(candidates, i, target - candidates[i], list, res);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        CombinationSum cs = new CombinationSum();
        int[] in = {2,3,6,7};
        System.out.println(cs.combinationSum(in, 6));
    }

}
