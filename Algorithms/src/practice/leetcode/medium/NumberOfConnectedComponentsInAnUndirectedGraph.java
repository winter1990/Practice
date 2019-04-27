package practice.leetcode.medium;

/**
 * @graph
 * @unionfind
 */
public class NumberOfConnectedComponentsInAnUndirectedGraph {
    public int countComponents(int n, int[][] edges) {
        int[] parent = new int[n];
        for (int i = 1; i < n; i++) parent[i] = i;
        for (int[] e : edges) {
            int from = find(parent, e[0]);
            int to = find(parent, e[1]);
            if (from != to) parent[from] = to;
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (parent[i] == i) res++;
        }
        return res;
    }

    private int find(int[] p, int i) {
        if (p[i] != i) p[i] = find(p, p[i]);
        return p[i];
    }

    public static void main(String[] args) {
        NumberOfConnectedComponentsInAnUndirectedGraph nc = new NumberOfConnectedComponentsInAnUndirectedGraph();
        int n = 5;
        int[][] in = {{0,1},{1,2},{2,3},{3,4}};
        System.out.println(nc.countComponents(n,in));
    }
}
