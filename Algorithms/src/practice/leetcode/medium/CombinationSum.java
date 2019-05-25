package practice.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @array
 * @dfs
 * @backtracking
 *
 * Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique
 * combinations in candidates where the candidate numbers sums to target.
 *
 * problems to solve:
 * 1. sum up to target
 * 2. same element can be re-used
 *
 * recursively sum up the element in array:
 * sort the array, so that we know when to stop when searching
 *
 * base case:
 *   one solution is found: num[i]=target res.add(new list)
 *   value is larger than target: num[i]>target, return and remove
 * recursion:
 *   (arr, target, current index, cur list, result set)
 *   i = [index, n-1]
 *     add current element to list
 *     go to next recursive call - target-val
 *     delete the last element in list
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) return res;
        Arrays.sort(candidates);
        dfs(candidates, 0, target, new LinkedList<>(), res);
        return res;
    }

    private void dfs(int[] a, int index, int target, List<Integer> list, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new LinkedList<>(list));
            return;
        }
        if (a[index] > target) return;

        for (int i = index; i < a.length; i++) {
            list.add(a[i]);
            dfs(a, i, target - a[i], list, res);
            list.remove(list.size() - 1);
        }
    }

    // this helper method is wrong as when add 223 in the list and continue the next stack call, the target is 0
    private void helper1(int[] candidates, int index, int target, List<Integer> list, List<List<Integer>> res) {
        if (target == candidates[index]) {
            list.add(candidates[index]);
            res.add(new ArrayList<>(list));
            return;
        }
        if (candidates[index] > target) return;

        for (int i = index; i < candidates.length; i++) {
            list.add(candidates[i]);
            helper1(candidates, i, target - candidates[i], list, res);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        CombinationSum cs = new CombinationSum();
        int[] in = {2,3,7};
        System.out.println(cs.combinationSum(in, 7));
    }

}
