package practice.leetcode.question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @string
 * @tsp
 *
 * Given an array A of strings, find any smallest string that contains each string in A as a substring.
 * We may assume that no string in A is substring of another string in A.
 * 1 <= A.length <= 12
 * 1 <= A[i].length <= 20
 *
 * Input: ["alex","loves","leetcode"]
 * Output: "alexlovesleetcode"
 *
 * Input: ["catg","ctaagt","gcta","ttca","atgcatc"]
 * Output: "gctaagttcatgcatc"
 *
 * --------------------
 *
 * problem to solve:
 * 1. each string in A appears once in res
 * 2. reuse as much as possible of the tailing characters for next string
 *
 * https://github.com/Sinclert/Heuristics-TSP/blob/master/HK_Optimal.java
 *
 * start with two strings
 *   abcd cde, two options to concatenate two string: [s1 s2] [s2 s1], the overlapped chars of [s1 s2] is more
 *   so for each pair of strings in the given array
 *   compare and calculate the number of chars need to be appended
 *   and the pair [s1 s2] is the 'cost' from s1 to s2
 *   then the relation between strings can be treated as a graph
 *   we want to visit all the nodes
 *   and minimize the total cost
 *
 * define graph
 *   graph[i][j] represents the number of characters to append to A[i] if followed by A[j]
 *
 * target
 *   find the shortest cost to visit all the nodes in graph
 *
 * travel the nodes
 *   greedy? find the most overlapped chars?
 *   example: ab bcd cde def -> bcdefab
 *   use dp to find minimum hamiltonian cycle - traveling salesman problem
 *
 * as length of A is [1,10], so we can use a single integer to represents nodes we want to travel
 * dp[i][j] means the minimum cost to travel i (in 1/0 sequence) nodes, ending with node j
 * path[i][j] means the last node before traveling to node j
 * we also need to keep track of the path, which indicates the order of the strings
 */
public class FindTheShortestSuperstring {
    public static void main(String[] args) {
//        String[] s = {"iamzihan","hiiam","zihanwang","coding"};
        String[] s = {"ab","bcd","cde","def"};
        FindTheShortestSuperstring f = new FindTheShortestSuperstring();
        System.out.println(f.shortestSuperstring(s));
        System.out.println(f.shortestSuperstring1(s));
    }

    int optimalDistance = Integer.MAX_VALUE;
    String optimalPath = "";
    List<Integer> list = new ArrayList<>();
    public String shortestSuperstring1(String[] A) {
        int n = A.length;
        int[][] graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j == i) continue;
                graph[i][j] = calc(A[i], A[j]);
                graph[j][i] = calc(A[j], A[i]);
            }
        }
        String path = "";
        int[] vertices = new int[n - 1];
        for (int i = 1; i < n; i++) {
            vertices[i - 1] = i;
        }
        traverse(0, vertices, path, 0, graph);
        System.out.println(list);
        return optimalPath;
    }

    private int traverse(int start, int vertices[], String path, int curCost, int[][] graph) {
        path = path + start + " ";
        int n = vertices.length;
        int newCostUntilHere;
        // base case, no more node to visit
        if (n == 0) {
            newCostUntilHere = curCost + graph[start][0];
            // If its cost is lower than the stored one
            if (newCostUntilHere < optimalDistance){
                optimalDistance = newCostUntilHere;
                optimalPath = path;
            }
            return (graph[start][0]);
        } else if (curCost > optimalDistance){
            return 0;
        }
        int[][] newVertices = new int[n][(n - 1)];
        int costCurrentNode, costChild;
        int bestCost = Integer.MAX_VALUE;
        // For each node
        for (int i = 0; i < n; i++) {
            // Each recursion new vertices list is constructed
            for (int j = 0, k = 0; j < n; j++, k++) {
                // The current child is not stored in the new vertices array
                if (j == i) {
                    k--;
                    continue;
                }
                newVertices[i][k] = vertices[j];
            }
            // Cost of arriving the current node from its parent
            costCurrentNode = graph[start][vertices[i]];
            // Here the cost to be passed to the recursive function is computed
            newCostUntilHere = costCurrentNode + curCost;
            // RECURSIVE CALLS TO THE FUNCTION IN ORDER TO COMPUTE THE COSTS
            costChild = traverse(vertices[i], newVertices[i], path, newCostUntilHere, graph);
            // The cost of every child + the current node cost is computed
            int totalCost = costChild + costCurrentNode;
            // Finally we select from the minimum from all possible children costs
            if (totalCost < bestCost) {
                bestCost = totalCost;
            }
        }
        return bestCost;
    }

    public String shortestSuperstring(String[] A) {
        int n = A.length;
        int[][] graph = new int[n][n];
        // build the graph by calculating number of chars in a[j] should be appended to a[i]
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = calc(A[i], A[j]);
                graph[j][i] = calc(A[j], A[i]);
            }
        }
        int[][] dp = new int[1 << n][n];  // min length to travel i nodes, ending with j
        int[][] path = new int[1 << n][n]; // the previous node before traveling to node j
        int last = -1, min = Integer.MAX_VALUE;

        for (int i = 1; i < (1 << n); i++) { // i = the set of nodes
            Arrays.fill(dp[i], Integer.MAX_VALUE);
            for (int j = 0; j < n; j++) {    // for each node
                if ((i & (1 << j)) > 0) {    // j = the node in the set of i
                    int prev = i - (1 << j); // the set without j
                    if (prev == 0) {         // j is the only node in current i set
                        dp[i][j] = A[j].length();  // the whole word
                    } else {
                        for (int k = 0; k < n; k++) { // try all the possible nodes as ending node
                            if (dp[prev][k] < Integer.MAX_VALUE && dp[prev][k] + graph[k][j] < dp[i][j]) { // if k is valid and the length could be reduced
                                dp[i][j] = dp[prev][k] + graph[k][j];
                                path[i][j] = k; // the node before j
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
                return i + b.length() - a.length();
            }
        }
        return b.length();
    }

}
