package practice.leetcode.hard;

import java.util.Arrays;
import java.util.Stack;

/**
 * @travellingsalesman
 * @dp
 *
 * Given an array A of strings, find any smallest string that contains each string in A as a substring.
 * We may assume that no string in A is substring of another string in A.
 *
 * use a dp array to store the minimum substring need to append
 * dp[i][j] represents the length of string need to be appended to string i
 * all the string in array appears ONLY ONCE
 *
 * each string is a node
 */
public class FindTheShortestSuperstring {
    public String shortestSuperstring(String[] A) {
        int n = A.length;
        int[][] graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                graph[i][j] = getLengthToAppend(A[i], A[j]);
                graph[j][i] = getLengthToAppend(A[j], A[i]);
            }
        }
        int[][] dp = new int[1 << n][n];
        int[][] path = new int[1 << n][n];
        int min = Integer.MAX_VALUE, last = -1;
        for (int i = 1; i < (1 << n); i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) > 0) {
                    int prev = i - (1 << j);
                    if (prev == 0) {
                        dp[i][j] = A[j].length();
                    } else {
                        for (int k = 0; k < n; k++) {
                            if (dp[prev][k] < Integer.MAX_VALUE && dp[prev][k] + graph[k][j] < dp[i][j]) {
                                dp[i][j] = dp[prev][k] + graph[k][j];
                                path[i][j] = k;
                            }
                        }
                    }
                }
                if (i == (1 << n) - 1 && dp[i][j] < min) {
                    min = dp[i][j];
                    last = j;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        int cur = (1 << n) - 1;
        Stack<Integer> stack = new Stack<>();
        while (cur > 0) {
            stack.push(last);
            int temp = cur;
            cur -= (1 << last);
            last = path[temp][last];
        }

        // build the result
        int i = stack.pop();
        sb.append(A[i]);
        while (!stack.isEmpty()) {
            int j = stack.pop();
            sb.append(A[j].substring(A[j].length() - graph[i][j]));
            i = j;
        }
        return sb.toString();
    }

    private int getLengthToAppend(String s1, String s2) {
        for (int i = 1; i < s1.length(); i++) {
            String prefix = s1.substring(i);
            if (s1.startsWith(prefix)) {
                return s2.length() - prefix.length();
            }
        }
        return s1.length();
    }
}
