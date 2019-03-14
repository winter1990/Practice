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
        int M = A.length, N = A[0].length, res = (1 << (N - 1)) * M;
        for (int j = 1; j < N; j++) {
            int cur = 0;
            for (int i = 0; i < M; i++) cur += A[i][j] == A[i][0] ? 1 : 0;
            res += Math.max(cur, M - cur) * (1 << (N - j - 1));
        }
        return res;
    }

    public int matrixScore(int[][] A) {
        if (A == null || A.length == 0 || A[0].length == 0) {
            return 0;
        }
        int m = A.length;
        int n = A[0].length;
        for (int i = 0; i < m; i++) {
            if (A[i][0] == 0) {
                for (int j = 0; j < n; j++) {
                    A[i][j] ^= 1;
                }
            }
        }
        for (int j = 1; j < n; j++) {
            if (countDiff(A, j) > 0) {
                flipWholeColumn(A, j);
            }
        }

        int sum = 0;
        int factor = 0;
        for (int j = n - 1; j >= 0; j--) {
            int count = 0;
            for (int i = 0; i < m; i++) {
                if (A[i][j] == 1) count++;
            }
            sum += count * Math.pow(2, factor);
            factor++;
        }
        return sum;
    }

    private void flipWholeColumn(int[][] a, int j) {
        for (int i = 0; i < a.length; i++) {
            a[i][j] ^= 1;
        }
    }

    private int countDiff(int[][] a, int j) {
        int count0 = 0;
        int count1 = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i][j] == 0) count0++;
            else count1++;
        }
        return count0 - count1;
    }

    public static void main(String[] args) {
        ScoreAfterFlippingMatrix sa = new ScoreAfterFlippingMatrix();
        int[][] in = {{0,0,1,1},{1,0,1,0},{1,1,0,0}};
        System.out.println(sa.matrixScore(in));
    }
}
