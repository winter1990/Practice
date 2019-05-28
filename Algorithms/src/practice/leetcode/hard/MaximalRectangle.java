package practice.leetcode.hard;

import java.util.Stack;

/**
 * @array
 * @dp
 * @stack
 *
 * Given a 2D matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.
 *
 * for each row, get the maximum height in direction vertical
 * and this problems is converted to
 * "largest rectangle in histogram"
 * use a dp[][] to store the maximal height for each cell
 * for each row, get the largest rectangle
 */
public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int max = 0;
        int[][] dp = new int[m][n];
        for (int i = 0; i < n; i++) {
            if (matrix[0][i] == '1') dp[0][i] = 1;
        }
        max = Math.max(max, getLargest(dp[0]));
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '0') {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i - 1][j] + 1;
                }
            }
            max = Math.max(max, getLargest(dp[i]));
        }
        return max;
    }

    private int getLargest(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        for (int i = 0; i <= arr.length; i++) {
            int cur = i == arr.length ? -1 : arr[i];
            while (!stack.isEmpty() && cur <= arr[stack.peek()]) {
                int h = arr[stack.pop()];
                int w = stack.isEmpty() ? i : i - stack.peek() - 1;
                max = Math.max(max, h * w);
            }
            stack.push(i);
        }
        return max;
    }

    /**
     * optimization:
     * use one dimension array to store the height
     */
    public int maximalRectangle1(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int m = matrix.length, n = matrix[0].length, max = 0;
        int[] h = new int[n + 1];
        h[n] = 0;
        for (int row = 0; row < m; row++) {
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i <= n; i++) {
                if (i < n) {
                    if (matrix[row][i] == '1') {
                        h[i] += 1;
                    } else {
                        h[i] = 0;
                    }
                }
                while (!stack.isEmpty() && h[i] < h[stack.peek()]) {
                    int top = stack.pop();
                    int area = h[top] * (stack.isEmpty() ? i : (i - stack.peek() - 1));
                    if (area > max)
                        max = area;
                }
                stack.push(i);
            }
        }
        return max;
    }
}
