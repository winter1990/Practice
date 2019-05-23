package practice.leetcode.medium;

/**
 * @dp
 * @daq
 *
 * Input: [1,2,3], Output: 6
 * Input: [3,7,4,5], Output: 144, scores: 3*7*5 + 4*5*7 = 245, or 3*4*5 + 3*4*7 = 144. The minimum score is 144.
 * Input: [1,3,1,4,1,5], Output: 13, score 1*1*3 + 1*1*4 + 1*1*5 + 1*1*1 = 13.
 *
 * totally n vertices
 * if we pick one side in the polygon, there are n-2 options to form a triangle
 * and this triangle divide the polygon into another two (or one) polygons
 */
public class MinimumScoreTriangulationOfPolygon {
    public int minScoreTriangulation(int[] A) {
        Integer[][] dp = new Integer[50][50];
        return dfs(A, 0, A.length - 1, dp);
    }

    private int dfs(int[] a, int i, int j, Integer[][] dp) {
        if (i + 2 > j) return 0;
        if (dp[i][j] != null) return dp[i][j];
        int res = Integer.MAX_VALUE;
        for (int k = i + 1; k < j; k++) {
            res = Math.min(res, dfs(a, k, j, dp) + dfs(a, i, k, dp) + a[i] * a[j] * a[k]);
        }
        dp[i][j] = res;
        return res;
    }
}
