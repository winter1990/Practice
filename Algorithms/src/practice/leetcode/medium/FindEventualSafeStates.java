package practice.leetcode.medium;

import java.util.*;


public class FindEventualSafeStates {
    /**
     * dfs
     * detect loop? "for any choice of where to walk"
     */
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> res = new ArrayList<>();
        if (graph == null || graph.length == 0) {
            return res;
        }
        int n = graph.length;
        int[] checker = new int[n];
        for (int i = 0; i < n; i++) {
            if (graph[i].length == 0) {
                checker[i] = 1;
            }
        }
        for (int i = 0; i < n; i++) {
            if (dfs(graph, i, checker)) {
                res.add(i);
            }
        }
        return res;
    }
    // recursively check
    // 0 - not visited, 1 - safe, 2 - unsafe
    private boolean dfs(int[][] graph, int i, int[] checker) {
        if (checker[i] != 0) {
            return checker[i] == 1;
        }
        checker[i] = 2;
        for (int neightbor : graph[i]) {
            if (!dfs(graph, neightbor, checker)) {
                return false;
            }
        }
        checker[i] = 1;
        return true;
    }

    

    public static void main(String[] args) {
        int[][] in = {{},{0,2,3,4},{3},{4},{}};
                //{{1,2},{2,3},{5},{0},{5},{},{}};
        FindEventualSafeStates f = new FindEventualSafeStates();
        System.out.println(f.eventualSafeNodes(in));
    }
}
