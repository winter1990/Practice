package practice.leetcode.hard;

import java.util.*;

/**
 * @tree
 * @search
 * @graph
 *
 * translation:
 * find the lowest common ancestor
 * use map to store the node and all its ancestors -> ordered
 * any node can be the root as it is undirected
 *
 * 1. use set[] to store all the neighbors for each node
 *    use an array to store the count of tree[i]
 *    use an array to store sum of distances of tree[i]
 * 2. traverse the tree: post-order
 *    update count[root] = sum of count[subtrees] + 1
 *    update res[root] = sum(res[subtree]) + sum(count[i])
 * 3. traver the tree:
 *    if move to child i, count[i] distance in total will be closer to root
 *    at the same time, all other nodes move longer
 */
public class SumOfDistancesInTree {
    public int[] sumOfDistancesInTree(int N, int[][] edges) {
        Set<Integer>[] tree = new Set[N];
        for (int i = 0; i < N; i++) tree[i] = new HashSet<>();
        int[] count = new int[N], res = new int[N];
        for (int[] e : edges) {
            tree[e[0]].add(e[1]);
            tree[e[1]].add(e[0]);
        }
        inorder(tree, 0, -1, count, res);
        preorder(tree, 0, -1, count, res);
        return res;
    }

    private void preorder(Set<Integer>[] tree, int node, int pre, int[] count, int[] res) {
        for (int neighbor : tree[node]) {
            if (neighbor == pre) continue;
            res[neighbor] = res[node] - count[neighbor] + count.length - count[neighbor];
            preorder(tree, neighbor, node, count, res);
        }
    }

    private void inorder(Set<Integer>[] tree, int node, int pre, int[] count, int[] res) {
        for (int neighbor : tree[node]) {
            if (neighbor == pre) continue; // reach the leaf node
            inorder(tree, neighbor, node, count, res);
            count[node] += count[neighbor]; // add total number of tree nodes in the subtree
            res[node] += res[neighbor] + count[neighbor];
        }
        count[node]++;
    }
}
