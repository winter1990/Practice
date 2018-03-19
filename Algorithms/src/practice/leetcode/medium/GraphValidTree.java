package practice.leetcode.medium;

import java.util.*;

/**
 * n nodes labeled from 0 to n - 1 and a list of undirected edges
 * n = 5 and edges = [[0, 1], [0, 2], [0, 3], [1, 4]], return true
 * n = 5 and edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]], return false
 *
 * a node can have multiple children
 * a node can have one parent
 */
public class GraphValidTree {
    // https://leetcode.com/problems/graph-valid-tree/discuss/69018/AC-Java-Union-Find-solution
    public boolean validTree(int n, int[][] edges) {
        // initialize n isolated islands
        int[] nums = new int[n];
        Arrays.fill(nums, -1);
        // perform union find
        for (int i = 0; i < edges.length; i++) {
            int x = find(nums, edges[i][0]);
            int y = find(nums, edges[i][1]);
            // if two vertices happen to be in the same set
            // then there's a cycle
            if (x == y) return false;
            // union
            nums[x] = y;
        }
        return edges.length == n - 1;
    }

    private int find(int[] nums, int i) {
        if (nums[i] == -1) {
            return i;
        }
        return find(nums, nums[i]);
    }

    // dfs solution
    public boolean validTree1(int n, int[][] edges) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i, new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int p = edges[i][0];
            int q = edges[i][1];
            list.get(p).add(q);
            list.get(q).add(p);
        }
        boolean[] checker = new boolean[n];
        if (hasCycle(list, 0, checker, -1)) {
            return false;
        }
        for (int i = 0; i < n; i++) {
            if (!checker[i]) {
                return false;
            }
        }
        return true;
    }

    // check if there is a cycle start from node u
    private boolean hasCycle(List<List<Integer>> list, int u, boolean[] checker, int parent) {
        checker[u] = true;
        for (int i = 0; i < list.get(u).size(); i++) { // get neighbor one by one
            int v = list.get(u).get(i);
            if ((checker[v] && parent != v) || (!checker[v] && hasCycle(list, v, checker, u))) {
                return true;
            }
        }
        return false;
    }
}
