package practice.leetcode.medium;

import java.util.*;

/**
 * @backtracking
 *
 * might contain duplicates
 *
 * [1 1 2] -> [1 1 2] [2 1 1] [1 2 1]
 *
 * impact of the duplicates:
 * affect the insertion, while to skip
 */
public class Permutations_II {
    public List<List<Integer>> permuteUnique1(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        res.add(new LinkedList<>());

        for (int i = 0; i < nums.length; i++) {
            Set<List<Integer>> currentSet = new HashSet<List<Integer>>();
            for (List<Integer> l : res) {
                for (int j = 0; j < l.size() + 1; j++) {
                    l.add(j, nums[i]);
                    List<Integer> T = new LinkedList<>(l);
                    l.remove(j);
                    currentSet.add(T);
                }
            }
            res = new LinkedList<>(currentSet);
        }
        return res;
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        boolean[] isUsed = new boolean[nums.length];
        Arrays.sort(nums);
        helper(nums, isUsed, new LinkedList<Integer>(), res);
        return res;
    }

    private void helper(int[] nums, boolean[] isUsed, LinkedList<Integer> list, List<List<Integer>> res) {
        if (list.size() == nums.length) {
            res.add(new LinkedList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (isUsed[i]) {
                continue;
            }
            if (i != 0 && nums[i - 1] == nums[i] && !isUsed[i - 1]) {
                continue;
            }
            list.add(nums[i]);
            isUsed[i] = true;
            helper(nums, isUsed, list, res);
            isUsed[i] = false;
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        Set<List<Integer>> set = new HashSet<>();
        List<Integer> l1 = new LinkedList<Integer>();
        List<Integer> l2 = new LinkedList<Integer>();
        l1.add(1);
        l1.add(2);
        l2.add(1);
        l2.add(2);
        set.add(l1);
        set.add(l2);
        System.out.println(set);
    }
}
