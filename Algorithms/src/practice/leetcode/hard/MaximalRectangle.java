package practice.leetcode.hard;

import java.util.Stack;

public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        // similar with max rectangle, using a dp array to store the max height of current position

        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int max = 0;
        int[][] dp = new int[m][n];
        for (int i = 0; i < n; i++) {
            if (matrix[0][i] == '1') {
                dp[0][i] = 1;
            }
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
        Stack<Integer> stack = new Stack<Integer>();
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


    public int maximalRectangle1(char[][] matrix) {
        if (matrix==null||matrix.length==0||matrix[0].length==0)
            return 0;
        int cLen = matrix[0].length;    // column length
        int rLen = matrix.length;       // row length
        // height array
        int[] h = new int[cLen+1];
        h[cLen]=0;
        int max = 0;


        for (int row=0;row<rLen;row++) {
            Stack<Integer> s = new Stack<Integer>();
            for (int i=0;i<cLen+1;i++) {
                if (i<cLen)
                    if(matrix[row][i]=='1')
                        h[i]+=1;
                    else h[i]=0;

                if (s.isEmpty()||h[s.peek()]<=h[i])
                    s.push(i);
                else {
                    while(!s.isEmpty()&&h[i]<h[s.peek()]){
                        int top = s.pop();
                        int area = h[top]*(s.isEmpty()?i:(i-s.peek()-1));
                        if (area>max)
                            max = area;
                    }
                    s.push(i);
                }
            }
        }
        return max;
    }
}
