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
 min path - 2351,total 11
 */

/**
 * start with 0
 * adjacent nums - i i+1
 * for each layer, depends on above one
 * backtrace dp
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
            for (int j = 0; j < triangle.get(i).size(); j++) {
                dp[n - 1 - j] = (Math.min(dp[n - 1 - j], dp[n - 2 - j])
                        + triangle.get(i).get(triangle.get(i).size() - 1 - j));
            }
        }
        return dp[n - 1];
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
