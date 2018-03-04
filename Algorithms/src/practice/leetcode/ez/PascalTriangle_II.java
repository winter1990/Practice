package practice.leetcode.ez;

/**
 *          1
 *        1   1
 *      1   2   1
 *    1   3   3   1
 *  1   4   6   4   1
 *  k=3, [1 3 3 1]
 *
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PascalTriangle_II {
    public List<Integer> getRow(int rowIndex) {
        if (rowIndex < 0) {
            return new LinkedList<>();
        }
        int[] nums = new int[rowIndex + 1];
        nums[0] = 1;
        if (rowIndex == 0) {
            return getList(nums);
        }
        for (int i = 1; i <= rowIndex; i++) {
            for (int j = i - 1; j > 0; j--) {
                nums[j] += nums[j - 1];
            }
            nums[i] = 1;
        }
        return getList(nums);
    }

    public List<Integer> getList(int[] nums) {
        List<Integer> list = new LinkedList<>();
        int index = 0;
        while (index < nums.length && nums[index] != 0) {
            list.add(nums[index]);
            index++;
        }
        return list;
    }


    public List<Integer> optimized(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        if (rowIndex < 0) {
            return res;
        }
        for (int i = 0; i <= rowIndex; i++) {
            res.add(0, 1);
            for (int j = 1; j < i; j++) {
                res.set(j, res.get(j) + res.get(j + 1));
            }
        }
        return res;
    }


    public static void main(String[] args) {
        PascalTriangle_II ps = new PascalTriangle_II();
        List<Integer> list = ps.optimized(5);
        System.out.println(list);
    }
}
