package practice.leetcode.hard;

/**
 * @graph
 * @unionfind
 * @tree
 *
 * In this problem, a rooted tree is a directed graph such that, there is exactly one node (the root) for which all
 * other nodes are descendants of this node, plus every node has exactly one parent, except for the root node which
 * has no parents.
 * Return an edge that can be removed so that the resulting graph is a rooted tree of N nodes.
 *
 * for normal union find (redundant connect I) solution, it can help to detect the cycle
 * but cannot determine the DIRECTED graph is a tree-like structure
 * because the root must be the node without parent
 *
 * if there is an edge making invalid tree, there are three cases:
 *   case 1 - cycle - [1 2][2 3][3 1] - remove last, [3 1]
 *   case 2 - a node has multiple parent - [1 2][1 3][2 3]
 *   case 3 - multiple parents and cycle both exist - [1 2][2 3][3 1][4 3]
 *
 * for each case:
 *   case 1 - remove the last edge that causes cycle
 *   case 2 - remove the last edge that causes multiple parent
 *   case 3 - two scenarios
 *     multi parent detected first, then cycle - if remove the edge causes multi parent - cycle still exists
 *     cycle detected first, then multi parent - remove the one that causes the cycle
 */
public class RedundantConnection_II {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n + 1];
        for (int i = 1; i <= n; i++) parent[i] = i;
        int[] c1 = null, c2 = null;
        for (int[] e : edges) {
            int p1 = find(parent, e[0]);
            int p2 = find(parent, e[1]);
            if (p1 != p2) {
                if (p2 != e[1]) { // the edge that causes multiple parent
                    c1 = e;
                } else {
                    parent[p2] = p1;
                }
            } else {
                c2 = e; // the edge that causes cycle
            }
        }
        if (c1 == null || c2 == null) return c1 == null ? c2 : c1;
        for (int[] e : edges) {
            if (e[1] == c1[1]) return e;
        }
        return new int[2];
    }

    public int find(int[] root, int node) {
        if (root[node] != node) {
            root[node] = find(root, root[node]);
        }
        return root[node];
    }

    public static void main(String[] args) {
        int[][] in = {{2,1},{3,1},{4,2},{1,4}};
        RedundantConnection_II r =  new RedundantConnection_II();
        int[] res = r.findRedundantDirectedConnection(in);
        System.out.println(res[0] + " " + res[1]);
    }
}
