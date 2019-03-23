package practice.leetcode.hard;

/**
 * @search
 * @array
 *
 * Given an integer matrix, find the length of the longest increasing path.
 * From each cell, you can either move to four directions: left, right, up or down.
 * You may NOT move diagonally or move outside of the boundary (i.e. wrap-around is not allowed).
 *
 * dfs
 * 4 directions
 * when we visit some element, compare with adjacent neighbors
 * 5 6 7 8
 * 4 3 8 9
 * 3 4 2 1
 * 2 1 2 3
 * if we visit each element and dfs, we visit the same path multiple times
 *
 * optimization:
 * use extra space dp[][] to track of the longest increasing path at (i,j)
 *
 * base case:
 * arr[i][j] != 0, return value
 * recursion:
 * for each direction, check boundary first, and then
 * 1 + dfs(...), compare and update current max
 */
public class LongestIncreasingPathinaMatrix {
    int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int max = 1;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dp[i][j] == 0) max = Math.max(max, dfs(matrix, i, j, m, n, dp));
            }
        }
        return max;
    }

    private int dfs(int[][] matrix, int i, int j, int m, int n, int[][] dp) {
        if (dp[i][j] != 0) return dp[i][j];
        int max = 1;
        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (x < 0 || x >= m || y < 0 || y >= n || matrix[x][y] <= matrix[i][j]) continue;
            int len = 1 + dfs(matrix, x, y, m, n, dp);
            max = Math.max(max, len);
        }
        dp[i][j] = max;
        return max;
    }

    public static void main(String[] args) {
        int[][] in = {{5,3,6,7},
                      {7,6,5,8},
                      {1,9,2,1}};
        LongestIncreasingPathinaMatrix l = new LongestIncreasingPathinaMatrix();
        System.out.println(l.longestIncreasingPath(in));
    }
}
