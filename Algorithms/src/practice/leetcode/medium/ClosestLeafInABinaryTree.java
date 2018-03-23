package practice.leetcode.medium;

import java.util.*;

/**
 * tree structure, always need to consider about its parent, and all ancestors
 * use two maps:
 * one is to build the child->parent
 * one is to get height
 *
 */
public class ClosestLeafInABinaryTree {
    public int findClosestLeaf(TreeNode root, int k) {
        if ((root.left == null && root.right == null)) {
            return root.val;
        }
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        TreeNode target = getParent(root, parent, k);
        TreeNode nearest = getNearest(target, parent);
        return nearest.val;
    }

    private TreeNode getNearest(TreeNode target, Map<TreeNode, TreeNode> parent) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(target);
        Set<TreeNode> visited = new HashSet<>();
        while (!q.isEmpty()) {
            TreeNode cur = q.poll();
            if (cur.left == null && cur.right == null) {
                return cur;
            }
            if (cur.left != null && visited.add(cur.left)) {
                q.offer(cur.left);
            }
            if (cur.right != null && visited.add(cur.right)) {
                q.offer(cur.right);
            }
            if (parent.containsKey(cur) && visited.add(parent.get(cur))) {
                q.offer(parent.get(cur));
            }
        }
        return null;
    }

    private TreeNode getParent(TreeNode root, Map<TreeNode, TreeNode> parent, int k) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        TreeNode target = null;
        while (!q.isEmpty()) {
            TreeNode cur = q.poll();
            if (cur.val == k) {
                target = cur;
            }
            if (cur.left != null) {
                q.offer(cur.left);
                parent.put(cur.left, cur);
            }
            if (cur.right != null) {
                q.offer(cur.right);
                parent.put(cur.right, cur);
            }
        }
        return target;
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(8);
        TreeNode n9 = new TreeNode(9);
        TreeNode n12 = new TreeNode(12);
        TreeNode n13= new TreeNode(13);
        TreeNode n14= new TreeNode(14);
        n1.left = n2; n1.right=n3;n3.right=n7;n2.left = n4; n4.left = n8; n4.right=n9;n8.left=n12;n12.left=n13;n13.left=n14;
        ClosestLeafInABinaryTree c = new ClosestLeafInABinaryTree();
        System.out.println(c.findClosestLeaf(n1, 8));
    }
}
