package practice.leetcode.hard;

/**
 * @array
 * @knapsack
 *
 * In a given integer array A, we must move every element of A to either list B or list C.
 * (B and C initially start empty.)
 *
 * Return true if and only if after such a move, it is possible that the average value of B is equal to the average
 * value of C, and B and C are both non-empty.
 *
 * Input:
 * [1,2,3,4,5,6,7,8]
 * Output: true
 * Explanation: We can split the array into [1,4,5,8] and [2,3,6,7], and both of them have the average of 4.5
 *
 * if the set B is the smaller list
 *   the size of B can be [1, length/2]
 * define dp array dp[sum+1][length/2+1]
 * dp[i][j] represents sum i with length j of list B is doable
 *
 * initial status
 *   dp[0][0] = true
 *
 * avg * size of b + avg * size of c = sum
 * avg * n = sum
 * sum / n = avg = bsum / k = csum / (n-k)
 * bsum = sum * k / n, which is an integer
 * so sum * k % n == 0
 *
 * transition function
 *
 */
public class SplitArrayWithSameAverage {
    public boolean splitArraySameAverage(int[] A) {
        int sum = 0;
        for (int a : A) sum += a;
        boolean[][] dp = new boolean[sum + 1][A.length / 2 + 1];
        dp[0][0] = true;
        for (int a : A ) {
            for (int i = sum; i >= a; i--) {
                for (int j = 1; j <= A.length / 2; j++) {
                    dp[i][j] = dp[i][j] || dp[i - a][j - 1];
                }
            }
        }
        for (int i = 1; i <= A.length / 2; i++) {
            if (sum * i % A.length == 0 && dp[sum * i / A.length][i]) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        SplitArrayWithSameAverage s = new SplitArrayWithSameAverage();
        System.out.println(s.splitArraySameAverage(new int[]{5,3,11,19,2}));
    }
}
