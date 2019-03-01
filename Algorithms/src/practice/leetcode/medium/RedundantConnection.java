package practice.leetcode.medium;

/**
 * @graph
 * @tree
 * n this problem, a tree is an undirected graph that is connected and has no cycles.
 * The given input is a graph that started as a tree with N nodes (with distinct values 1, 2, ..., N),
 * with one additional edge added. The added edge has two different vertices chosen from 1 to N,
 * and was not an edge that already existed.
 * The resulting graph is given as a 2D-array of edges. Each element of edges is a pair [u, v] with u < v,
 * that represents an undirected edge connecting nodes u and v.
 * Return an edge that can be removed so that the resulting graph is a tree of N nodes. If there are multiple answers,
 * return the answer that occurs last in the given 2D-array.
 *
 *
 */
public class RedundantConnection {
    public int[] findRedundantConnection(int[][] edges) {
        int[] parent = new int[2001];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        for (int[] edge: edges){
            int from = edge[0], to = edge[1];
            if (find(parent, from) == find(parent, to)) {
                return edge;
            } else {
                parent[find(parent, from)] = find(parent, to);
            }
        }

        return new int[2];
    }

    private int find(int[] parent, int f) {
        if (f != parent[f]) {
            parent[f] = find(parent, parent[f]);
        }
        return parent[f];
    }

    public static void main(String[] args) {
        int[][] in = new int[][]{{1,2},{2,3},{3,4},{1,4},{1,5}};
        RedundantConnection rc = new RedundantConnection();
        rc.findRedundantConnection(in);
    }
}
