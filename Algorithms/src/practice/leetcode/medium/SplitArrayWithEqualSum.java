package practice.leetcode.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * @array
 * @dfs
 *
 * Given an array with n integers, you need to find if there are triplets (i, j, k) which satisfies conditions:
 *   0 < i, i + 1 < j, j + 1 < k < n - 1
 *   Sum of subarrays (0, i - 1), (i + 1, j - 1), (j + 1, k - 1) and (k + 1, n - 1) should be equal.
 * Index:  0 1 2 3 4 5 6
 * Input: [1,2,1,2,1,2,1]
 * Output: True
 * Explanation:
 * i = 1, j = 3, k = 5.
 *
 * the array should be divided into 4 parts:
 * [0,i) (i,j) (j,k) (k,n-1]
 *
 * use a pre sum array to store the sum of sub array
 * preSum[i] = the total sum of [0, i) in array
 */
public class SplitArrayWithEqualSum {
    public boolean splitArray(int[] nums) {
        if (nums == null || nums.length < 7) return false;
        int n = nums.length;
        int[] preSum = new int[n];
        preSum[0] = nums[0];
        for (int i = 1; i < n; i++) preSum[i] = preSum[i - 1] + nums[i];
        for (int j = 3; j < n - 3; j++) {
            Set<Integer> set = new HashSet<>();
            for (int i = 1; i < j - 1; i++) {
                if (preSum[i - 1] == preSum[j - 1] - preSum[i]) set.add(preSum[i - 1]);
            }
            for (int k = j + 2; k < n - 1; k++) {
                if (preSum[n - 1] - preSum[k] == preSum[k - 1] - preSum[j] && set.contains(preSum[k - 1] - preSum[j])) {
                    return true;
                }
            }
        }
        return false;
    }

    // some issue with it
    public boolean splitArray1(int[] nums) {
        if (nums == null || nums.length < 7) return false;
        int n = nums.length, preSum[] = new int[n + 1];
        for (int i = 1; i <= n; i++) preSum[i] = preSum[i - 1] + nums[i - 1];
        for (int i = 1; i < n - 5; i++) {
            if (dfs(nums, i + 1, preSum[i], preSum, 1)) return true;
        }
        return false;
    }

    private boolean dfs(int[] a, int start, int target, int[] preSum, int level) {
        if (level == 4 && start >= a.length) return true;
        for (int i = start + 1; i <= a.length - 2 * (3 - level) ; i++) {
            if (preSum[i] - preSum[start] == target) {
                if (dfs(a, i + 1, target, preSum, level + 1)) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        SplitArrayWithEqualSum s = new SplitArrayWithEqualSum();
        int[] in = {1,1,2,1,1,2,1,1,1,2,1,1,1};
        System.out.println(s.splitArray(in));
    }
}
