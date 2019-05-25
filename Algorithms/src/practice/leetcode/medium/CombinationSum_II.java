package practice.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @dfs
 * @array
 * @backtracking
 *
 * Given a collection of candidate numbers (candidates) and a target number (target), find all unique
 * combinations in candidates where the candidate numbers sums to target.
 * Each number in candidates may only be used once in the combination.
 *
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 *
 * problems to solve:
 * 1. find the combinations sum up to target
 * 2. no duplicate combination
 *
 * sort the array, in order to:
 *   stop continue searching when element is larger than target
 *   skip the duplicate elements
 *
 * [1 1 1 2 3], 4 -> [1 1 2] [1 3]
 */
public class CombinationSum_II {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) return res;
        Arrays.sort(candidates);
        dfs(candidates, 0, new ArrayList<>(), target, res);
        return res;
    }

    private void dfs(int[] a, int index, List<Integer> list, int target, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i < a.length; i++) {
            if (a[i] > target) return;
            if (i != index && a[i] == a[i - 1]) continue;
            list.add(a[i]);
            dfs(a, i + 1, list, target - a[i], res);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] in = {1, 1, 6, 1, 5};
        int target = 7;
        CombinationSum_II cs = new CombinationSum_II();
        System.out.println(cs.combinationSum2(in, target));
    }

}
