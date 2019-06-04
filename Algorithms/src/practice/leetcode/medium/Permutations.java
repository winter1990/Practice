package practice.leetcode.medium;

import java.util.ArrayList;
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
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0) return res;
        List<Integer> init = new ArrayList<>();
        init.add(nums[0]);
        res.add(init);
        for (int i = 1; i < nums.length; i++) {
            int size = res.size();
            List<List<Integer>> tmp = new ArrayList<>();
            for (int j = 0; j < size; j++) {
                List<Integer> list = res.get(j);
                for (int pos = 0; pos <= list.size(); pos++) {
                    list.add(pos, nums[i]);
                    tmp.add(new ArrayList<>(list));
                    list.remove(pos);
                }
            }
            res = tmp;
        }
        return res;
    }

    public List<List<Integer>> permute1(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0) return res;
        permutation(nums, new ArrayList<>(), res);
        return res;
    }

    private void permutation(int[] a, List<Integer> list, List<List<Integer>> res) {
        if (list.size() == a.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < a.length; i++) {
            if (list.contains(a[i])) continue;
            list.add(a[i]);
            permutation(a, list, res);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        Permutations p = new Permutations();
        int[] in = {1,2,3};
        System.out.println(p.permute(in));
    }
}
