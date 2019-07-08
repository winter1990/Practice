package practice.leetcode.medium;

/**
 * @greedy
 *
 * A move consists of choosing any row or column, and toggling each value in that row or column: changing all 0s to 1s,
 * and all 1s to 0s.
 * After making any number of moves, every row of this matrix is interpreted as a binary number, and the score of the
 * matrix is the sum of these numbers.
 * Return the highest possible score.
 *
 * [0,0,1,1]    [1,1,1,1]
 * [1,0,1,0] => [1,0,0,1]
 * [1,1,0,0]    [1,1,1,1]
 *
 * we can change the whole row OR column
 * we definitely need to think about most significant digit, change all of it to 1
 * and think about second column, and third
 * if we want to change first column to all 1s, change the rows, because if we change column, will impact other elements
 * for the rest of columns, count 1s and 0s, if 0s > 1s, change
 */
public class ScoreAfterFlippingMatrix {
    public int matrixScore1(int[][] A) {
        int m = A.length, n = A[0].length;
        int res = m * (1 << (n - 1));
        for (int j = 1; j < n; j++) {
            int cur = 0;
            for (int i = 0; i < m; i++) {
                cur += A[i][j] == A[i][0] ? 1 : 0;
            }
            res += Math.max(cur, m - cur) * (1 << (n - j - 1));
        }
        return res;
    }

    /**
     * initial solution
     * flip the columns to make all the elements in first column 1 for maximum
     * then deal with the column [1, n)
     * count 0s and 1s for each column
     */
    public int matrixScore(int[][] A) {
        if (A == null || A.length == 0 || A[0].length == 0) return 0;
        int m = A.length, n = A[0].length;
        for (int i = 0; i < m; i++) {
            if (A[i][0] == 0) flipRow(A[i]);
        }
        int res = m * (1 << (n - 1));
        for (int j = 1; j < n; j++) {
            int count = 0;
            for (int i = 0; i < m; i++) {
                if (A[i][j] == 0) count++;
            }
            res += Math.max(m - count, count) * (1 << (n - j - 1));
        }
        return res;
    }

    private void flipRow(int[] a) {
        for (int j = 0; j < a.length; j++) a[j] ^= 1;
    }

    public static void main(String[] args) {
        ScoreAfterFlippingMatrix sa = new ScoreAfterFlippingMatrix();
        int[][] in = {{0,0,1,1},{1,0,1,0},{1,1,0,0}};
        System.out.println(sa.matrixScore(in));
    }
}
