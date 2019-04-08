package practice.leetcode.hard;

public class RangeSumQuery2D_Mutable {
}

/**
 * @array
 * @math
 *
 * Given a 2D matrix matrix, find the sum of the elements inside the rectangle defined by its
 * upper left corner (row1, col1) and lower right corner (row2, col2).
 *
 * two operations:
 * 1. update
 * 2. get sum in given rectangle
 */
class NumMatrix {
    int[][] mMatrix;
    int m;
    int n;
    public NumMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return;
        mMatrix = matrix;
        m = matrix.length;
        n = matrix[0].length;
        // rowSums[i][j] = rowSums[i][0] + rowSums[i][1] + ... + rowSums[i][j]
        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                matrix[i][j] += matrix[i][j - 1];
            }
        }
    }
    // O(n)
    public void update(int row, int col, int val) {
        // handle col = 0 differently
        int originalValue = col == 0 ? mMatrix[row][0] : mMatrix[row][col] - mMatrix[row][col - 1];
        int diff = val - originalValue;
        for (int j = col; j < n; j++) {
            mMatrix[row][j] += diff;
        }
    }
    // O(m)
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int result = 0;
        for (int i = row1; i <= row2; i++) {
            // handle col = 0 differently
            result += col1 == 0 ? mMatrix[i][col2] : mMatrix[i][col2] - mMatrix[i][col1 - 1];
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] in = {{1}};
        NumMatrix n = new NumMatrix(in);
        System.out.println(n.sumRegion(0,0,0,0));
        n.update(0,0,-1);
        System.out.println(n.sumRegion(0,0,0,0));
    }

    /**
     * https://leetcode.com/problems/range-sum-query-2d-mutable/discuss/75870/Java-2D-Binary-Indexed-Tree-Solution-clean-and-short-17ms
     *
     * tree-like data structure
     * time: O(logm * logn)
     */
    public class NumMatrix1 {
        int[][] tree;
        int[][] nums;
        int m;
        int n;
        public NumMatrix1(int[][] matrix) {
            if (matrix.length == 0 || matrix[0].length == 0) return;
            m = matrix.length;
            n = matrix[0].length;
            tree = new int[m + 1][n + 1];
            nums = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    update(i, j, matrix[i][j]);
                }
            }
        }

        public void update(int row, int col, int val) {
            int delta = val - nums[row][col];
            nums[row][col] = val;
            for (int i = row + 1; i <= m; i += i & (-i)) {
                for (int j = col + 1; j <= n; j += j & (-j)) {
                    tree[i][j] += delta;
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            if (m == 0 || n == 0) return 0;
            return sum(row2 + 1, col2 + 1) + sum(row1, col1) - sum(row1, col2 + 1) - sum(row2 + 1, col1);
        }

        public int sum(int row, int col) {
            int sum = 0;
            for (int i = row; i > 0; i -= i & (-i)) {
                for (int j = col; j > 0; j -= j & (-j)) {
                    sum += tree[i][j];
                }
            }
            return sum;
        }
    }
}