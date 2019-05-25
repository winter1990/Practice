package practice.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @array
 * @backtracking
 * @recursion
 *
 * Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9
 * can be used and each combination should be a unique set of numbers.
 *
 * chosen from [1,9]
 * number can not be re-used
 * must be k numbers in the list
 *
 * dfs recursion
 * based case
 *   target < 0, return
 *   target == 0 && list size = k, add to result
 * recursive call
 *   (k, target, index/start value, list, result)
 *   i = [index,9]
 *     if cur list size < k
 *       add
 *       next call
 *       delete
 */
public class CombinationSum_III {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(k, 1, n, new ArrayList<>(), res);
        return res;
    }

    private void dfs(int k, int index, int target, List<Integer> list, List<List<Integer>> res) {
        if (target == 0 && list.size() == k) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i <= 9; i++) {
            if (list.size() < k && i <= target) {
                list.add(i);
                dfs(k, i + 1, target - i, list, res);
                list.remove(list.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        CombinationSum_III cs = new CombinationSum_III();
        System.out.println(cs.combinationSum3(1, 10));
    }
}
