package practice.leetcode.question;

import java.util.Arrays;

/**
 * @dp
 *
 * We are given an array A of N lowercase letter strings, all of the same length.
 *
 * Now, we may choose any set of deletion indices, and for each string, we delete all the characters in those indices.
 *
 * Suppose we chose a set of deletion indices D such that after deletions, the final array has every element (row) in
 * lexicographic order.
 *
 * Return the minimum possible value of D.length.
 *
 * fdgh    two options: delete 0 or delete 1
 * cnef    one option: delete 1
 *
 * we delete some columns
 * final string is increasing
 * the problems is translated to 'find sub sequence' of all the strings
 *
 * there might be overlapped and non overlapped columns to be deleted
 *
 * need to get the minimum columns to delete
 * use an array to keep track of the longest sub sequence ending at index i
 *
 * for each string in the array
 *   we can use O(N^2) to find the maximum increasing sub sequence
 *   the maximum sub sequence means we are deleting least number of columns
 *   for one string, s.charAt(j) < s.charAt(i) then dp[i] = dp[j+1]
 *
 */
public class DeleteColumnsToMakeSorted_III {
    public int minDeletionSize(String[] A) {
        int m = A.length, n = A[0].length();
        int res = n - 1;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < j; i++) {
                int k;
                for (k = 0; k < m; k++) {
                    if (A[k].charAt(i) > A[k].charAt(j)) {
                        break;
                    }
                }
                if (k == m && dp[i] + 1 > dp[j]) {
                    dp[j] = dp[i] + 1;
                }
            }
            res = Math.min(res, n - dp[j]);
        }
        return res;
    }
}
