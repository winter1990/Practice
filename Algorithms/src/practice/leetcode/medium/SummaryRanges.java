package practice.leetcode.medium;

import java.util.LinkedList;
import java.util.List;

/**
 * find the consequence numbers
 * track head and tail
 */
public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new LinkedList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        int i = 0, j = 1;
        while (j < nums.length) {
            while (j < nums.length && nums[j] == (nums[j - 1] + 1)) {
                j++;
            }
            if (i == j - 1) {
                res.add("" + nums[i]);
                i++;
                j++;
            } else {
                res.add(nums[i] + "->" + nums[j - 1]);
                i = j;
                j++;
            }
        }
        if (i == nums.length - 1) {
            res.add("" + nums[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        SummaryRanges sr = new SummaryRanges();
        int[] in = {0,2,3,4,6,8,9};
        System.out.println(sr.summaryRanges(in));
    }
}
