package practice.leetcode.medium;

import java.util.Arrays;

/**
 * @dp
 *
 * create a 2 dimension array and assign the mines as 0
 * search in 4 directions, get the minimum value of 4 directions
 * one matrix for original array, another 1 for each direction -> get the smallest value
 * row by row, column by column
 * for row -> start from left most and right most
 * for col -> start from top and bottom
 * if mine is seen, assign to 0
 * initialize all the elements in the grid as N as it is tha largest it can be
 * always get the minimum
 */
public class LargestPlusSign {
    public int orderOfLargestPlusSign(int N, int[][] mines) {
        int[][] grid = new int[N][N];
        for (int[] arr : grid) Arrays.fill(arr, N);
        for (int[] mine : mines) grid[mine[0]][mine[1]] = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0, k = N - 1, l = 0, r = 0, u = 0, d = 0; j < N; j++, k--) {
                grid[i][j] = Math.min(grid[i][j], l = (grid[i][j] == 0 ? 0 : l + 1));
                grid[i][k] = Math.min(grid[i][k], r = (grid[i][k] == 0 ? 0 : r + 1));
                grid[j][i] = Math.min(grid[j][i], u = (grid[j][i] == 0 ? 0 : u + 1));
                grid[k][i] = Math.min(grid[k][i], d = (grid[k][i] == 0 ? 0 : d + 1));
            }
        }
        int res = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                res = Math.max(res, grid[i][j]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LargestPlusSign l = new LargestPlusSign();
        int n = 5;
        int[][] m = new int[][]{{4,2}};
        System.out.println(l.orderOfLargestPlusSign(n, m));
    }
}
