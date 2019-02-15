package practice.leetcode.medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @recursion
 *
 * Each number in C may only be used once in the combination
 * there might have duplicate numbers
 */
public class CombinationSum_II {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new LinkedList<>();
        if (candidates == null || candidates.length == 0) {
            return res;
        }
        Arrays.sort(candidates);
        helper(candidates, 0, new LinkedList<Integer>(), target, res);
        return res;
    }

    private void helper(int[] candidates, int index, LinkedList<Integer> list, int target, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new LinkedList<>(list));
            return;
        }
//        if (candidates[index] > target) { out of boundary when index = length
//            return;
//        }
        for (int i = index; i < candidates.length; i++) {
            if (candidates[i] > target) {
                return;
            }
            if (i != index && candidates[i] == candidates[i - 1]) {
                continue;
            }
            list.add(candidates[i]);
            helper(candidates, i + 1, list, target - candidates[i], res);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] in = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        CombinationSum_II cs = new CombinationSum_II();
        System.out.println(cs.combinationSum2(in, target));
    }

}
