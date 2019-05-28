package practice.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @array
 * @backtracking
 *
 * Given a set of distinct integers, nums, return all possible subsets (the power set).
 *
 * [1 2 3]
 * [][1][2][1 2][3][1 3][2 3][1 2 3]
 *
 * for each number in the input, we have two options, select or not select
 * so, consider about all the different combinations of the elements in the input array
 * we have 2^len subsets
 * 0, 1, 2,...,len-1
 * if we use bit manipulation, from 0 to len-1, it contains all different combinations
 *
 * iterative solution:
 * initialize res with [[]]
 * for each number in array, get each subsset in result set, make a copy and add number in the new sublist
 */
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        long total = (long) Math.pow(2, nums.length);
        for (int i = 0; i < total; i++) {
            List<Integer> list = new ArrayList<>();
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
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        res.add(new ArrayList<>());
        for (int n : nums) {
            int size = res.size();
            for (int i = 0; i < size; i++) {
                List<Integer> list = new ArrayList<>(res.get(i));
                list.add(n);
                res.add(list);
            }
        }
        return res;
    }

    public List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        getSubsets(nums, 0, new ArrayList<>(), res);
        return res;
    }

    private void getSubsets(int[] a, int index, List<Integer> list, List<List<Integer>> res) {
        res.add(new ArrayList<>(list));
        for (int i = index; i < a.length; i++) {
            list.add(a[i]);
            getSubsets(a, i + 1, list, res);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        Subsets s = new Subsets();
        System.out.println(s.subsets2(new int[]{1,2,3}));
    }
}
