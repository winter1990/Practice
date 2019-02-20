package practice.leetcode.medium;

import java.util.Arrays;
import java.util.List;

/*
[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
 min path: 2 3 5 1, total 11
 */

/**
 * @array
 * @dp
 *
 * find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below
 *
 * backtrace dp problem
 * make sure when we update the value in dp array, it does not affect for the next iteration
 */
public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }
        int n = triangle.size();
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = triangle.get(n - 1).get(i);
        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        Triangle t = new Triangle();
        List<Integer> l1 = Arrays.asList(-1);
        List<Integer> l2 = Arrays.asList(2,3);
        List<Integer> l3 = Arrays.asList(1,-1,-3);
        List<List<Integer>> in = Arrays.asList(l1,l2,l3);
        System.out.println(t.minimumTotal(in));
    }
}
