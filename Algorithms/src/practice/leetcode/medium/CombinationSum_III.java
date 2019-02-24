package practice.leetcode.medium;

import java.util.LinkedList;
import java.util.List;

/**
 * @array
 * @backtracking
 * @recursion
 *
 * Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9
 * can be used and each combination should be a unique set of numbers.
 *
 *
 */
public class CombinationSum_III {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new LinkedList<>();
        helper(k, 1, n, new LinkedList<Integer>(), res);
        return res;
    }

    private void helper(int k, int index, int target, LinkedList<Integer> list, List<List<Integer>> res) {
        if (target < 0) {
            return;
        } else if (target == 0 && list.size() == k) {
            res.add(new LinkedList<>(list));
        }
        for (int i = index; i <= 9; i++) {
            if (list.size() < k) {
                list.add(i);
                helper(k, i + 1, target - i, list, res);
                list.remove(list.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        CombinationSum_III cs = new CombinationSum_III();
        System.out.println(cs.combinationSum3(3, 9));
    }
}
