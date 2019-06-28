package practice.leetcode.medium;

import java.util.*;

/**
 * @graph
 * @tree
 * @bfs
 *
 * For an undirected graph with tree characteristics
 * we can choose any node as the root
 * all the edges are undirected
 * those with minimum height are called minimum height trees (MHTs)
 * The graph contains n nodes which are labeled from 0 to n - 1
 * The height of a rooted tree is the number of edges on the longest downward path between the root and a leaf
 *
 * it is a graph with tree characteristics
 * to get the minimum height tree:
 *   we can start from each node and get the height, but time complexity will be high
 *   OR
 *   start from leaf/leaves, layer by layer to go to the center area
 *
 * build the graph
 *   node -> neighbors, map Integer -> set<Integer>
 * start with leaves
 *   case 1 - to the center, which is one node
 *   case 2 - multiple nodes
 *
 */
public class MinimumHeightTrees {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) {
            List<Integer> res = new ArrayList<>();
            res.add(0);
            return res;
        }
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) map.put(i, new HashSet<>());
        for (int[] e : edges) {
            map.get(e[0]).add(e[1]);
            map.get(e[1]).add(e[0]);
        }
        List<Integer> leaves = new ArrayList<>();
        for (int k : map.keySet()) {
            if (map.get(k).size() == 1) leaves.add(k);
        }
        while (n > 2) {
            List<Integer> set = new ArrayList<>();
            for (int leaf : leaves) {
                int parent = map.get(leaf).iterator().next();
                map.get(parent).remove(leaf);
                if (map.get(parent).size() == 1) {
                    set.add(parent);
                }
            }
            n -= leaves.size();
            leaves = set;
        }
        return leaves;
    }

    public List<Integer> findMinHeightTrees1(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();
        if (n == 1) {
            res.add(0);
            return res;
        }
        int[] degree = new int[n];
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) map.put(i, new HashSet<>());
        for (int[] e : edges) {
            map.get(e[0]).add(e[1]);
            map.get(e[1]).add(e[0]);
            degree[e[0]]++;
            degree[e[1]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (degree[i] == 1) q.offer(i);
        }
        while (!q.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int cur = q.poll();
                list.add(cur);
                for (int parent : map.get(cur)) {
                    degree[parent]--;
                    if (degree[parent]== 1) q.offer(parent);
                }
            }
            res = list;
        }
        return res;
    }

    public static void main(String[] args) {
        MinimumHeightTrees mh = new MinimumHeightTrees();
        int[][] in = new int[][]{{0, 3}, {1, 3}, {2, 3}, {4, 3}, {5, 4}}; //new int[][]{{1,0}, {1,2},{1,3}}
        System.out.println(mh.findMinHeightTrees(6, in));
    }
}
