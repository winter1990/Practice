package practice.leetcode.medium;

/**
 * @binarysearch
 *
 * 1  2  3  4
 * 5  6  7  8
 * 9 10 11 12
 * start = 0, end = m * n - 1
 * mid / n = row, mid % n = col
 */
public class Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int s = 0;
        int e = m * n - 1;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (matrix[mid / n][mid % n] == target) {
                return true;
            } else if (matrix[mid / n][mid % n] < target) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        return false;
    }
}
