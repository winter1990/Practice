package practice.leetcode.medium;
/*
Input: arr = [4,3,2,1,0]
Output: 1, [4,3,2,1,0]

Input: arr = [1,0,2,3,4]
Output: 4, [0,1] [2] [3] [4]
 */

/**
 * [2 0 1 4 3] => 2 [2 0 1][4 3]
 */
public class MaxChunksToMakeSorted {
    public int maxChunksToSorted(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return 1;
        }
        int n = arr.length;
        int cnt = 1;
        int max = arr[0];
        for (int i = 1; i < n; i++) {
            if (i <= max) {
                max = Math.max(max, arr[i]);
            } else {
                max = arr[i];
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[] in = {2,0,1,4,3};
                // {1,0,2,3,4};
                // {4,3,2,1,0};
                // {0,1,2,3};
                // {0,4,2,3,1};
        MaxChunksToMakeSorted m = new MaxChunksToMakeSorted();
        System.out.println(m.maxChunksToSorted(in));
    }
}
