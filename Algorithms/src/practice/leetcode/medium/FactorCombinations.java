package practice.leetcode.medium;

import java.util.*;

/**
 *
 */
public class FactorCombinations {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> res = new LinkedList<>();
        if (n <= 3) {
            return res;
        }
        helper(n, 2, new ArrayList<Integer>(), res);
        return res;
    }

    private void helper(int n, int start, ArrayList<Integer> list, List<List<Integer>> res) {
        if (n == 1) {
            if (list.size() > 1) {
                res.add(new ArrayList<Integer>(list));
            }
            return;
        }
        for (int i = start; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                list.add(i);
                helper(n / i, i, list, res);
                list.remove(list.size() - 1);
            }
        }
        int i = n;
        list.add(i);
        helper(n / i, i, list, res);
        list.remove(list.size() - 1);
    }

    // adding two numbers for each recursive call
    // remove part becomes tricky
    // also need to sort to avoid 223 322
    public List<List<Integer>> getFactors1(int n) {
        List<List<Integer>> res = new LinkedList<>();
        if (n <= 1) {
            return res;
        }
        Set<List<Integer>> set = new HashSet<>();
        helper(n, new ArrayList<Integer>(), set);
        res.addAll(set);
        return res;
    }

    private void helper(int n, ArrayList<Integer> list, Set<List<Integer>> res) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                list.add(i);
                list.add(n / i);
                List<Integer> newList = new ArrayList<>(list);
                Collections.sort(newList);
                res.add(new ArrayList<>(newList));
                list.remove(list.size() - 1);
                helper(n / i, list, res);
                list.remove(list.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        FactorCombinations fc = new FactorCombinations();
        System.out.println(fc.getFactors(6));
    }
}
