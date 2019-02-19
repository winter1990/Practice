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
 * cut the leaves layer by layer
 * build a map to store all nodes and the adjacent neighbors
 */
public class MinimumHeightTrees {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) {
            List<Integer> res = new LinkedList<>();
            res.add(0);
            return res;
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i, new LinkedList<>());
        }
        for (int[] edge : edges) {
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        List<Integer> leaves = new LinkedList<>();
        for (int i : map.keySet()) {
            if (map.get(i).size() == 1) {
                leaves.add(i);
            }
        }
        while (n > 2) {
            List<Integer> newLeaves = new LinkedList<>();
            for (int i : leaves) {
                int j = map.get(i).get(0);
                map.get(j).remove((Integer)i);
                if (map.get(j).size() == 1) {
                    newLeaves.add(j);
                }
            }
            n -= leaves.size();
            leaves = newLeaves;
        }
        return leaves;
    }

    public static void main(String[] args) {
        MinimumHeightTrees mh = new MinimumHeightTrees();
        int[][] in = new int[][]{{0, 3}, {1, 3}, {2, 3}, {4, 3}, {5, 4}}; //new int[][]{{1,0}, {1,2},{1,3}}
        System.out.println(mh.findMinHeightTrees(6, in));
    }
}
