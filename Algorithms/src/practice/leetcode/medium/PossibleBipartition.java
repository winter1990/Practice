package practice.leetcode.medium;

import java.util.*;

/**
 * @graph
 * @unionfind
 *
 */
public class PossibleBipartition {
    public boolean possibleBipartition(int N, int[][] dislikes) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] d : dislikes) {
            map.computeIfAbsent(d[0], s -> new ArrayList<>()).add(d[1]);
            map.computeIfAbsent(d[1], s -> new ArrayList<>()).add(d[0]);
        }
        int[] parent = new int[N + 1];
        for (int i = 1; i <= N; i++) parent[i] = i;
        for (int i : map.keySet()) {
            int pi = find(parent, i);
            List<Integer> list = map.get(i);
            if (find(parent, list.get(0)) == pi) return false;
            for (int j = 1; j < list.size(); j++) {
                int pj = find(parent, list.get(j));
                if (pi == pj) return false;
                parent[pj] = find(parent, list.get(0));
            }
        }
        return true;
    }

    private int find(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }

    // dfs solution
    public boolean possibleBipartition1(int N, int[][] dislikes) {
        int[][] graph = new int[N][N];
        for (int[] d : dislikes) {
            graph[d[0] - 1][d[1] - 1] = 1;
            graph[d[1] - 1][d[0] - 1] = 1;
        }
        int[] group = new int[N];
        for (int i = 0; i < N; i++) {
            if (group[i] == 0 && !dfs(graph, group, i, 1)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int[][] graph, int[] group, int index, int g) {
        group[index] = g;
        for (int i = 0; i < graph.length; i++) {
            if (graph[index][i] == 1) {
                if (group[i] == g) return false;
                if (group[i] == 0 && !dfs(graph, group, i, -g)) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        int[][] in = {{1,2},{1,3},{2,4}};
//        int[][] in = {{1,2},{1,3},{2,3}};
//        int[][] in = {{1,2},{2,3},{3,4},{4,5},{5,1}};
        int[][] in = {{1,2},{1,3},{1,4},{5, 6},{5,7},{4,6},{1,5}};
        PossibleBipartition p = new PossibleBipartition();
        System.out.println(p.possibleBipartition1(7, in));
    }
}
