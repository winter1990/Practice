package practice.interview.google;

import java.util.*;

/**
 * 1. 从左上角走到右上角
 * 2. 要求每一步只能向正右、右上或右下走，即 →↗↘
 *
 *   0 1 2 3 4 5
 * 0 1 1 2 4 9 21
 * 1   1 2 5 12
 * 2     1 3
 * 3       1
 *
 * m = 4, n = 6
 * current status depends on dp[i-1][j-1], dp[i][j-1] and dp[i+1][j-1]
 * define dp[m+1][n+1]
 */
public class UniquePath_III {
    public int allPaths(int m, int n) {
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for (int j = 1; j < n; j++) {
            for (int i = 0; i <= Math.min(m - 1, j); i++) {
                dp[i][j] = dp[i][j - 1];
                if (i > 0) dp[i][j] += dp[i - 1][j - 1];
                if (i < m - 1) dp[i][j] += dp[i + 1][j - 1];
            }
        }
        return dp[0][n - 1];
    }

    public int allPaths1(int m, int n) {
        int[] dp = new int[m];
        dp[0] = 1;
        int pre = 0, cur = 0;
        for (int j = 1; j < n; j++) {
            cur = 0;
            for (int i = 0; i < m; i++) {
                pre = cur;
                cur = dp[i];
                if (i > 0) dp[i] += pre;
                if (i < m - 1) dp[i] += dp[i + 1];
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        UniquePath_III u = new UniquePath_III();
        System.out.println(u.allPaths(18,116));
        System.out.println(u.allPaths1(18,116));
    }

    public int uniquePaths(int rows, int cols) {
        int[] dp = new int[rows];
        int[] tmp = new int[rows];
        dp[0] = 1;
        for(int j = 1 ; j  < cols ; j++) {
            for(int i = 0 ; i < rows ; i++) {
                int val1 = i - 1 >= 0 ? dp[i - 1] : 0;
                int val2 = dp[i];
                int val3 = i + 1 < rows ? dp[i + 1] : 0;
                tmp[i] = val1 + val2 + val3;
            }
            System.arraycopy(tmp, 0, dp, 0, tmp.length);
        }
        return dp[0];
    }

    public boolean canReach(int[][] points) {
        List<int[]> list = new ArrayList<>();
        list.add(new int[] {0, 0});
        for(int[] point : points) list.add(point);
        Collections.sort(list, (a, b) -> {
            return a[1] - b[1];
        });
        for(int i = 1 ; i < list.size() ; i++) {
            int[] curr = list.get(i);
            int[] prev = list.get(i-1);
            if(curr[1] == prev[1]) return false;
            int len = curr[1] - prev[1];
            int upper = prev[0] - len;
            int lower = prev[0] + len;
            if(curr[0] <= lower && curr[0] >= upper) continue;
            else return false;
        }
        return true;
    }

    public int uniquePaths(int rows, int cols, int[][] points) {
        int[] dp = new int[rows];
        int[] tmp = new int[rows];
        Map<Integer, Integer> map = new HashMap<>();
        for(int[] point : points) {
            if(map.containsKey(point[1])) {
                return 0;
            } else {
                map.put(point[1], point[0]);
            }
        }
        int res = 0;
        dp[0] = 1;

        for(int j = 1 ; j  < cols ; j++) {
            for(int i = 0 ; i < rows ; i++) {
                int val1 = i - 1 >= 0 ? dp[i - 1] : 0;
                int val2 = dp[i];
                int val3 = i + 1 < rows ? dp[i + 1] : 0;
                tmp[i] = val1 + val2 + val3;
            }
            System.arraycopy(tmp, 0, dp, 0, tmp.length);
            if(map.containsKey(j)) {
                int row = map.get(j);
                for(int i = 0 ; i < rows ; i++) {
                    if(i != row) dp[i] = 0;
                    else res = dp[i];
                }
            }
        }
        return res;
    }


}
