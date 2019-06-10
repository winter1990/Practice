package practice.leetcode.question;

import java.util.Arrays;
import java.util.Stack;

/**
 * @string
 * @travellingsalesman
 *
 * Given an array A of strings, find any smallest string that contains each string in A as a substring.
 *
 * problem to solve:
 * 1. each string in A appears once in res
 * 2. reuse as much as possible of the tailing characters for next string: iamzihan hanna zihaniscooking
 * 3. a string may consist of other multiple strings: cat fish catfish
 *
 * https://leetcode.com/problems/find-the-shortest-superstring/discuss/194932/Travelling-Salesman-Problem
 * graph[i][j] means the length of string to append to A[i] followed by A[j].
 * eg. A[i] = abcd, A[j] = bcde, then graph[i][j] = 1
 *
 * Then the problem becomes to: find the shortest path in this graph which visits every node exactly once.
 *
 * The i of dp[i][j] and path[i][j] represents the set of nodes we want to travel
 * Assume we want to travel nodes: {n1, n2, n3, n4}
 * i = 2 ^ n1 + 2 ^ n2 + 2 ^ n3 + 2 ^ n4;
 * In other words, we use every bit of a binary number(this number is i) to represent the status of each node
 * if i = 10011 (binary number), it means the node set = {0,1,4});
 * j of dp[i][j] and path[i][j] means the last node we travelled.
 * dp[i][j] = the min length if we travel all nodes in the node set i and the last travelled node is j.
 * path[i][j] = the node before j (j is the last one).
 *
 * Example:
 * Assume we want to travel points:{0,2,3,5}
 * i = (2^0+ 2^2 +2^3 + 2^5) = 44;
 * dp[44][2] means "the min length when we travel the points{0,2,3,5} and the last one is 2";
 * path[44][2] means "the last node before we travelled 2. In other words,the last node when travelling{0,3,5}"
 * Assume path[44][2] = 3, then path[44 - 2^2][3] = "the last node before we travelled 3.
 * Also, the last one of {0,5}"
 */
public class FindTheShortestSuperstring {

    public static void main(String[] args) {
        String[] s = {"iamzihan","hiiam","zihanwang","coding"};
        FindTheShortestSuperstring f = new FindTheShortestSuperstring();
        System.out.println(f.shortestSuperstring(s));
    }
    public String shortestSuperstring(String[] A) {
        int n = A.length;
        int[][] graph = new int[n][n];
        // build the graph
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = calc(A[i], A[j]);
                graph[j][i] = calc(A[j], A[i]);
            }
        }
        int[][] dp = new int[1 << n][n];
        int[][] path = new int[1 << n][n];
        int last = -1, min = Integer.MAX_VALUE;

        // start TSP
        for (int i = 1; i < (1 << n); i++) { // for all the combinations of the nodes
            Arrays.fill(dp[i], Integer.MAX_VALUE);
            for (int j = 0; j < n; j++) { //for each node
                if ((i & (1 << j)) > 0) {      // if the node is in the set. Assume i = 10010(18), j = 100(4), then set={1,4}, the node is 2. The node is not in this set
                    int prev = i - (1 << j);      // the set without j. Assume i = 10010, j = 10 then pre = 10000
                    if (prev == 0) {            // if j is the only one
                        dp[i][j] = A[j].length();  // the whole word
                    } else {
                        for (int k = 0; k < n; k++) {    //try all the possible nodes before j
                            if (dp[prev][k] < Integer.MAX_VALUE && dp[prev][k] + graph[k][j] < dp[i][j]) { // if k is valid and the length could be reduced
                                dp[i][j] = dp[prev][k] + graph[k][j];   //update the result
                                path[i][j] = k; // update the node before j
                            }
                        }
                    }
                }
                if (i == (1 << n) - 1 && dp[i][j] < min) {  // if i == 11...1111 means the node set contains all the nodes, and the length is smaller
                    min = dp[i][j];  //update the result
                    last = j;   //update the last node
                }
            }
        }

        // build the path
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

    private int calc(String a, String b) {
        for (int i = 1; i < a.length(); i++) {
            if (b.startsWith(a.substring(i))) {
                return b.length() - a.length() + i;
            }
        }
        return b.length();
    }
}
