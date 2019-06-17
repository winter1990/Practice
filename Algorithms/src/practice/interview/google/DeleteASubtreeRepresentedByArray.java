package practice.interview.google;

import java.util.ArrayList;
import java.util.List;

/**
 * 给一个数组表示森林，数组中是树节点，每个节点含有自己的index和该节点的父节点index，根节点的父节点index是自己的index。
 * 然后给一个index，从数组中删除该节点以及以其为父节点的树，返回新的森林数组
 *
 *
 */
public class DeleteASubtreeRepresentedByArray {
    public int[][] deleteSubtree(int[][] tree, int target) {
        int n = tree.length;
        int[] parent = new int[n + 1];
        for (int i = 1; i <= n; i++) parent[i] = i;
        for (int[] node : tree) {
            if (node[0] == node[1]) continue;
            int p1 = find(parent, node[0]);
            int p2 = find(parent, node[1]);
            if (p1 != p2) {
                parent[p1] = p2;
            }
        }
        parent[target] = -1;
        List<int[]> res = new ArrayList<>();
        for (int[] node : tree) {
            int p1 = find(parent, node[0]);
            int p2 = find(parent, node[1]);
            if (p1 != -1 && p2 != -1) {
                res.add(node);
            }
        }
        int[][] newTree = new int[res.size()][2];
        for (int i = 0; i < res.size(); i++) {
            newTree[i] = res.get(i);
        }
        return newTree;
    }

    private int find(int[] parent, int x) {
        if (parent[x] == -1) return -1;
        if (parent[x] != x) {
            x = find(parent, parent[x]);
        }
        return x;
    }

    public static void main(String[] args) {
        int[][] in = {{5,4},{4,2},{2,1},{6,3},{7,3},{3,1},{1,1}};
        DeleteASubtreeRepresentedByArray d = new DeleteASubtreeRepresentedByArray();
        d.deleteSubtree(in, 2);
    }
}
