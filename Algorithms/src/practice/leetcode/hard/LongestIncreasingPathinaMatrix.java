package practice.leetcode.hard;

/**
 * @search
 * @array
 *
 * dfs
 * 4 directions
 * no need extra space, just compare value
 * optimization: use extra space to track of the longest at (i,j)
 * arr[i][j] is the array to track the longest length start from (i,j)
 *
 * base case:
 * arr[i][j]!=0, return value
 * recursion:
 * for each direction, check boundary first, and then 1+dfs(...), compare and update current max
 */
public class LongestIncreasingPathinaMatrix {
    final int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] arr = new int[m][n];
        int max = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int cur = dfs(matrix, i, j, m, n, arr);
                max = Math.max(max, cur);
            }
        }
        return max;
    }

    private int dfs(int[][] matrix, int i, int j, int m, int n, int[][] arr) {
        if (arr[i][j] != 0) {
            return arr[i][j];
        }
        int max = 1;
        for (int[] dir : dirs) {
            int x = j + dir[0];
            int y = i + dir[1];
            if (x < 0 || x >= n || y < 0 || y >= m || matrix[y][x] <= matrix[i][j]) {
                continue;
            }
            int len = 1 + dfs(matrix, y, x, m, n, arr);
            max = Math.max(max, len);
        }
        arr[i][j] = max;
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
