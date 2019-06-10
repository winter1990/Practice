package practice.leetcode.hard;

/**
 * @array
 * @knapsack
 * @dp
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
 * average = sum / # of elements
 * n1 into B, n2 numbers into C, then avg * n1 + avg * n2 = total
 * sum1 / n1 = sum2 / n2
 *
 * define dp[len/2+1][sum+1]
 * dp[i][j] denotes we can use i numbers to form the sum j
 * i = [1, len/2], assume the calculate the smaller list
 * j = [1, sum]
 * for each number, we can:
 *   add it to B set - dp[i-1][j-num]
 *   not add it to B set - dp[i][j]
 * avg = sum / len
 * for i = [1,sum]
 *   if sumB % avg == 0, and dp[i][sumB / avg], then true
 * initial status
 *   dp[0][0] = 0
 */
public class SplitArrayWithSameAverage {
    public boolean splitArraySameAverage1(int[] A) {
        int sum = 0, n = A.length;
        for (int a : A) sum += a;
        boolean[][] dp = new boolean[n / 2 + 1][sum + 1];
        dp[0][0] = true;
        for (int a : A) {
            for (int i = n / 2; i >= 1; i--) {
                for (int j = a; j <= sum; j++) {
                    dp[i][j] = (dp[i][j] || dp[i - 1][j - a]);
                }
            }
        }
        for (int i = 1; i <= n / 2; i++) {
            if (sum * i % n == 0 && dp[i][sum * i / n])
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        SplitArrayWithSameAverage s = new SplitArrayWithSameAverage();
        System.out.println(s.splitArraySameAverage1(new int[]{2,12,18,16,19,3}));
        System.out.println(s.splitArraySameAverage(new int[]{2,12,18,16,19,3}));
    }

    // TLE
    public boolean splitArraySameAverage(int[] A) {
        int n = A.length;
        int sum = 0;
        for (int a : A) sum += a;
        for (int i = 1; i <= n / 2; ++i) {
            if (sum * i % n == 0 && find(A, sum * i / n, i, 0)) return true;
        }
        return false;
    }

    public boolean find(int[] A, int target, int k, int i) {
        if (k == 0) return target == 0;
        if (k + i > A.length) return false;
        return find(A, target - A[i], k - 1, i + 1) || find(A, target, k, i + 1);
    }


}
