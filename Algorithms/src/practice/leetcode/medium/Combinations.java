package practice.leetcode.medium;

import java.util.LinkedList;
import java.util.List;

/**
 * n=4 k=2, 12 13 14 23 24 34
 *
 * recursion:
 * base sublist size=k
 * need index to set the lower bound
 *
 */
public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new LinkedList<>();
        if (n <= 0 || k <= 0) {
            return res;
        }
        helper(n, k, 1, new LinkedList<Integer>(), res);
        return res;
    }

    private void helper(int n, int k, int index, LinkedList<Integer> list, List<List<Integer>> res) {
        if (list.size() == k) {
            res.add(new LinkedList<>(list));
            return;
        }
        for (int i = index; i <= n; i++) {
            list.add(i);
            helper(n, k, i + 1, list, res);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        Combinations c = new Combinations();
        System.out.println(c.combine(3,2));
    }
}
