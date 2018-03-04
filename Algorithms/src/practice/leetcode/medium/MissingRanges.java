package practice.leetcode.medium;

import java.util.LinkedList;
import java.util.List;

/**
 * [0, 1, 3, 50, 75], lower = 0 and upper = 99, return ["2", "4->49", "51->74", "76->99"]
 * two formats: single number & range
 * for single number,i-j=2
 * for range,numbers+->
 * lower&upper - i=0,i=len-1
 */
public class MissingRanges {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new LinkedList<>();
        if (nums == null || nums.length == 0) {
            addToResult(lower - 1, upper + 1, res);
            return res;
        }
        int l;
        int r;
        for (int i = 0; i <= nums.length; i++) {
            if (i == 0) {
                l = lower;
            } else {
                if (nums[i - 1] == Integer.MAX_VALUE) {
                    continue;
                }
                l = nums[i - 1] + 1;
            }

            if (i == nums.length) {
                r = upper;
            } else {
                if (nums[i] == Integer.MIN_VALUE) {
                    continue;
                }
                r = nums[i] - 1;
            }
            addToResult(l, r, res);
        }
        return res;
    }

    private void addToResult(int i, int j, List<String> res) {
        if (i > j) {
            return;
        } else if (i == j) {
            res.add(i + "");
        } else {
            res.add(i + "->" + j);
        }
    }

    public static void main(String[] args) {
        int[] arr = {-2147483648,2147483647};//{0,1,3,50,75};
        MissingRanges mr = new MissingRanges();
        System.out.println(mr.findMissingRanges(arr,-2147483648,2147483647));
    }
}
