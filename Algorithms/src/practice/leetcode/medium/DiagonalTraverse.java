package practice.leetcode.medium;

/**
 * @array
 *
 * total element - m*n
 * two directions - [1,-1][-1,1]
 * when out of up border    - row=0
 * when out of bottom border- row=m-1 col+=2
 * when out of left border  - col=0
 * when out of right border - col=n-1 row+=2
 */
public class DiagonalTraverse {
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[] res = new int[m * n];
        int row = 0;
        int col = 0;
        int direction = 0;
        int[][] dirs = {{-1, 1}, {1, -1}};
        for (int i = 0; i < m * n; i++) {
            res[i] = matrix[row][col];
            row += dirs[direction][0];
            col += dirs[direction][1];
            if (row >= m) {
                row = m - 1;
                col += 2;
                direction = 1 - direction;
            }
            if (col >= n) {
                col = n - 1;
                row += 2;
                direction = 1 - direction;
            }
            if (row < 0) {
                row = 0;
                direction = 1 - direction;
            }
            if (col < 0) {
                col = 0;
                direction = 1 - direction;
            }
        }
        return res;
    }
}
