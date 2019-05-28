package practice.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @array
 *
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 *
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * Output: [1,2,3,6,9,8,7,4,5]
 *
 * [
 *   [1, 2, 3, 4],
 *   [5, 6, 7, 8],
 *   [9,10,11,12]
 * ]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 *
 * totally 4 directions:
 * [0,1][1,0][0,-1][[-1,0]
 */
public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0) return res;
        int m = matrix.length, n = matrix[0].length;
        int xs = 0, xe = m - 1, ys = 0, ye = n - 1;
        while (xs <= xe && ys <= ye) {
            for (int j = ys; j <= ye; j++) res.add(matrix[xs][j]);
            xs++;
            for (int i = xs; i <= xe; i++) res.add(matrix[i][ye]);
            ye--;
            if (xs > xe || ys > ye) break;
            for (int j = ye; j >= ys; j--) res.add(matrix[xe][j]);
            xe--;
            for (int i = xe; i >= xs; i--) res.add(matrix[i][ys]);
            ys++;
        }
        return res;
    }

    public static void main(String[] args) {
        SpiralMatrix s = new SpiralMatrix();
        int[][] in = {{1, 2, 3, 4}, // xs 0, xe 2, ys 0, ye 3 | 1 1 1 2 | 2 1 1 2
                      {5, 6, 7, 8},
                      {9,10,11,12}};
        System.out.println(s.spiralOrder(in));
    }
}
