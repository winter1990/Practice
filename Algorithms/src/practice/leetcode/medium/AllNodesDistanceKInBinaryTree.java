package practice.leetcode.medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @tree
 *          1
 *      2       3
 *    4  5    8  9
 *  6     7       10
 *      11       12
 * target = 3, distance = 3
 * output should be [12 4 5]
 *
 * we need the reference to parent first -> use a hashmap to store all the child-parent relation
 * bfs
 */
public class AllNodesDistanceKInBinaryTree {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        Map<TreeNode, TreeNode> map = new HashMap<>();
        buildChildParentMap(root, null, map);
        List<Integer> res = new LinkedList<>();

        Set<TreeNode> visited = new HashSet<>();
        visited.add(target);

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(target);
        while (!q.isEmpty()) {
            if (K == 0) {
                while (!q.isEmpty()) {
                    res.add(q.poll().val);
                }
                return res;
            }
            int size = q.size();
            while (size-- > 0) {
                TreeNode cur = q.poll();
                if (map.get(cur) != null && !visited.contains(map.get(cur))) {
                    q.offer(map.get(cur));
                }
                if (cur.left != null && !visited.contains(cur.left)) q.offer(cur.left);
                if (cur.right != null && !visited.contains(cur.right)) q.offer(cur.right);
                visited.add(cur);
            }
            K -= 1;
        }
        return res;
    }

    private void buildChildParentMap(TreeNode child, TreeNode parent, Map<TreeNode, TreeNode> map) {
        if (child == null) {
            return;
        }
        if (!map.containsKey(child)) {
            if (parent != null) {
                map.put(child, parent);
            }
            buildChildParentMap(child.left, child, map);
            buildChildParentMap(child.right, child, map);
        }
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        n1.left = n2;
        n1.right = n3;
        AllNodesDistanceKInBinaryTree an = new AllNodesDistanceKInBinaryTree();
        System.out.println(an.distanceK(n1, n1, 0));
    }
}

