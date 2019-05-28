package practice.leetcode.medium;

/**
 * @array
 *
 * define 4 pointers, xs xe ys ye
 * row by row, col by col, fill in the value, starting from 1 to n^2
 */
public class SpiralMatrix_II {
    public int[][] generateMatrix(int n) {
        int xs = 0, xe = n - 1, ys = 0, ye = n - 1;
        int val = 1;
        int[][] res = new int[n][n];
        while (xs <= xe && ys <= ye) {
            for (int j = ys; j <= ye; j++) res[xs][j] = val++;
            xs++;
            for (int i = xs; i <= xe; i++) res[i][ye] = val++;
            ye--;
            for (int j = ye; j >= ys; j--) res[xe][j] = val++;
            xe--;
            for (int i = xe; i >= xs; i--) res[i][ys] = val++;
            ys++;
        }
        return res;
    }
}
