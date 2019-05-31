package practice.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @array
 *
 * Given a sorted integer array nums, where the range of elements are in the inclusive range [lower, upper],
 * return its missing ranges.
 *
 * Example:
 * Input: nums = [0, 1, 3, 50, 75], lower = 0 and upper = 99,
 * Output: ["2", "4->49", "51->74", "76->99"]
 *
 * problems to solve:
 * 1. find the non-consecutive ranges
 * 2. two format of outputs: single number or a->b
 * 3. bound is defined in input
 *
 * format of input - provide range [a,b], a == b single digit, otherwise a->b
 * start with lower bound, for each n in nums:
 *   s < n [lo,n) lo = n+1
 *   s = n continue lo++
 *   s > n impossible
 */
public class MissingRanges {
    public List<String> findMissingRanges(int[] nums, int lo, int hi) {
        List<String> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            addRange(lo, hi, res);
            return res;
        }
        int s = lo;
        for (int n : nums) {
            if (n == Integer.MIN_VALUE) {
                s = n + 1;
                continue;
            }
            if (s == n) {
                s++;
                continue;
            }
            addRange(s, n - 1, res);
            if (n == Integer.MAX_VALUE) return res;
            s = n + 1;
        }
        addRange(s, hi, res);
        return res;
    }

    private void addRange(int a, int b, List<String> res) {
        if (a > b) return;
        res.add(a == b ? "" + a : a + "->" + b);
    }

    public static void main(String[] args) {
        int[] arr = {-2147483648,2147483647};//{0,1,3,50,75};
        MissingRanges mr = new MissingRanges();
        System.out.println(mr.findMissingRanges(arr,-2147483648,2147483647));
    }
}
