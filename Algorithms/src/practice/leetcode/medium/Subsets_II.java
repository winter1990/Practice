package practice.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Array
 *
 * Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).
 * Note: The solution set must not contain duplicate subsets.
 *
 * [1 2 2 2 3]
 * [] initial status
 * [1]
 * [2][1 2]
 * [2 2][1 2 2] if duplicate with previous element, only get the last subset in result set
 * [2 2 2][1 2 2 2]
 * [3][1 3][2 3][1 2 3][2 2 3][1 2 2 3][2 2 2 3][1 2 2 2 3]
 * the given input array is not sorted, and may contain duplicates
 * in order to check the duplicates, we should sort the array first
 *   [1 2 2 2 3]
 *   for each recursive call
 *     add current list to result
 *     from start to n-1
 *       because another recursive call already added when i=index
 *       so remove duplicates by skipping i!=index and a[i]=a[i-1]
 */
public class Subsets_II {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        if (nums == null || nums.length == 0) return res;
        Arrays.sort(nums);
        getSubsets(nums, 0, new ArrayList<>(), res);
        return res;
    }

    private void getSubsets(int[] a, int index, List<Integer> list, List<List<Integer>> res) {
        res.add(new ArrayList<>(list));
        for (int i = index; i < a.length; i++) {
            if (i != index && a[i] == a[i - 1]) continue;
            list.add(a[i]);
            getSubsets(a, i + 1, list, res);
            list.remove(list.size() - 1);
        }
    }

    /**
     * iterative solution
     * [1 2 2 3]
     * []
     * [1]
     * [2][1 2]
     * [2 2][1 2 2]  <- if same with previous element, we only consider the result set in last iteration
     * [3][1 3][2 3][1 2 3][2 2 3][1 2 2 3] <- not duplicate, start from 0
     * need to keep track where we need to start and get sub-list in result list
     * for duplicate numbers, we need to skip the sub-list that already traversed in last iteration
     *
     * need to variable to store which index to start with for each iteration - start = 0
     * when we need to start at 0:
     *   a[i] = a[i-1]
     *   i = 0
     *   then start = 0
     * otherwise start = the size of result in LAST iteration
     */
    public List<List<Integer>> subsetsWithDup1(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        Arrays.sort(nums);
        int start = 0;
        res.add(new ArrayList<>());
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) start = 0;
            int size = res.size();
            for (int j = start; j < size; j++) {
                List<Integer> list = new ArrayList<>(res.get(j));
                list.add(nums[i]);
                res.add(list);
            }
            start = size;
        }
        return res;
    }
}