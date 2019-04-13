package practice.leetcode.easy;

public class ReshapeTheMatrix {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        int m = nums.length;
        int n = nums[0].length;
        if (m * n != r * c) return nums;
        int index = 0;
        int[][] res = new int[r][c];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[index / c][index % c] = nums[i][j];
                index++;
            }
        }
        return res;
    }
}
