package practice.leetcode.medium;

/**
 * @search
 *
 * search the boarder and dfs to change the 1 to 0
 * scan again to get the number of 1s
 */
public class NumberOfEnclaves {
    public int numEnclaves(int[][] A) {
        int res = 0, m = A.length, n = A[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0 || i == m - 1 || j == n - 1) {
                    dfs(A, i, j, m, n);
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (A[i][j] == 1) res++;
            }
        }
        return res;
    }

    private void dfs(int[][] arr, int i, int j, int m, int n) {
        if (i < 0 || i >= m || j < 0 || j >= n || arr[i][j] == 0) return;
        arr[i][j] = 0;
        dfs(arr, i - 1, j, m, n);
        dfs(arr, i + 1, j, m, n);
        dfs(arr, i, j - 1, m, n);
        dfs(arr, i, j + 1, m, n);
    }

    public static void main(String[] args) {
        NumberOfEnclaves n = new NumberOfEnclaves();
        int[][] in = {{0,1,1,0},{0,0,1,0}, {0,0,1,0},{0,0,0,0}};
        System.out.println(n.numEnclaves(in));
    }
}
