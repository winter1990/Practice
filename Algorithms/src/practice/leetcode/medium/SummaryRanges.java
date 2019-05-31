package practice.leetcode.medium;

import java.util.LinkedList;
import java.util.List;

/**
 * @array
 *
 * Given a sorted integer array without duplicates, return the summary of its ranges.
 * Input:  [0,1,2,4,5,7] Output: ["0->2","4->5","7"]
 * Input:  [0,2,3,4,6,8,9] Output: ["0","2->4","6","8->9"]
 *
 * two pointers:
 * i = 0, j = 1
 * keep moving right pointer until not contiguous
 * when j stops, there are two cases:
 *   j = i + 1, means a[i] is a single interval, i++ j++ -> there might one single number left over
 *   otherwise, a[i]->a[j], i = j j++
 * check at last if i = len - 1
 */
public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new LinkedList<>();
        if (nums == null || nums.length == 0) return res;
        int n = nums.length, i = 0, j = 1;
        while (j < n) {
            while (j < n && nums[j] == (nums[j - 1] + 1)) j++;
            if (i == j - 1) {
                res.add("" + nums[i]);
                i++;
            } else {
                res.add(nums[i] + "->" + nums[j - 1]);
                i = j;
            }
            j++;
        }
        if (i == n - 1) res.add("" + nums[i]);
        return res;
    }
}
