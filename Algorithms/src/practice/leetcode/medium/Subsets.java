package practice.leetcode.medium;

import java.util.LinkedList;
import java.util.List;

/**
 * Given a set of distinct integers, nums, return all possible subsets (the power set).
 */
public class Subsets {
    /*
     * for each number in the input, we have two options, select it, or not
     * so, consider about all the different combinations of the elements in input array
     * we have 2^len subsets
     * 0, 1, 2,...,len-1
     * if we use bit manipulation, from 0 to len-1, it contains all different combinations
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        long n = (long) Math.pow(2, nums.length);
        for (int i = 0; i < n; i++) {
            List<Integer> list = new LinkedList<>();
            for (int j = 0; j < nums.length; j++) {
                if ((i >> j & 1) == 1) {
                    list.add(nums[j]);
                }
            }
            res.add(list);
        }
        return res;
    }

    public List<List<Integer>> subsets1(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        res.add(new LinkedList<>());
        for (int i = 0; i < nums.length; i++) {
            int size = res.size();
            while (size-- > 0) {
                List<Integer> list = new LinkedList<>(res.get(size));
                list.add(nums[i]);
                res.add(list);
            }
        }
        return res;
    }
}
