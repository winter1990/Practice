package practice.leetcode.medium;

import java.util.Arrays;

/**
 * @dp
 * @binarysearch
 *
 * Given an unsorted array of integers, find the length of longest increasing subsequence.
 *
 * [10, 9, 2, 5, 3, 7, 18] -> 2 3 7 18. len = 4
 * Could you improve it to O(n log n) time complexity?
 *
 * method 1 - dp solution
 * dp[i] represents the longest subsequence ending with nums[i]
 *
 * initial states
 *   all dp[i] = 1
 * transition function
 * i = [1 n-1]
 *   j = [0 i)
 *     nums[i] > nums[j]
 *       compare and update dp[i]
 *
 * method 2 - optimization, binary search
 * keep track of smallest tail of all increasing sub-sequences
 * len = 1, 2 (3 5 7 are also longest subsequence but tails are larger)
 * len = 2, 3 (2,5 2,7...)
 * len = 3, 7
 * len = 4, 18
 * len = 5, NA
 * tails must be increasing array. Binary Search tail arr to see which value/sub-sequence needs to be updated
 *
 * use an array to store the smallest tail element with the length i+1
 * search the tail element in the array and update the smallest tail at i
 * for each element in array
 *   if element is larger than any of the tails, then we find a longer one
 *   if tails[i-1] < element < tails[i], then we update the tails[i] as we find a smaller one
 *
 */
public class LongestIncreasingSubsequence {
    public int lengthOfLIS1(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] tails = new int[nums.length];
        int res = 0;
        for (int n : nums) {
            int start = 0, end = res;
            while (start < end) {
                int mid = start + (end - start) / 2;
                if (n > tails[mid]) {
                    start = mid + 1;
                } else {
                    end = mid;
                }
            }
            tails[start] = n;
            if (start == res) res++;
        }
        return res;
    }

    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int max = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] ar = {10, 9, 2, 5, 3, 7, 18};
                //{3,5,6,2,5,4,19,5,6,7,12};
        LongestIncreasingSubsequence li = new LongestIncreasingSubsequence();
        System.out.println(li.lengthOfLIS1(ar));
    }
}
