package practice.interview.google;

/**
 * 一个矩阵里面有个square，这个square全是1，返回square的topleft坐标和square的length
 */
public class LargestSquare {
    public int[] getSquare(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return new int[0];
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        int[] res = new int[3];
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 1) {
                dp[i][0] = 1;
            }
        }
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 1) {
                dp[0][j] = 1;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 1) {
                    dp[i][j] = 1 + Math.min(dp[i -1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
                    if (dp[i][j] > res[2]) {
                        res[2] = dp[i][j];
                        res[0] = i - res[2] + 1;
                        res[1] = j - res[2] + 1;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] in = {
                {1,0,1,0,0},
                {1,1,1,1,1},
                {1,1,1,1,1},
                {1,0,1,1,1}};
        LargestSquare l = new LargestSquare();
        int[] res = l.getSquare(in);
        System.out.println();
    }
}
