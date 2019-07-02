package practice.leetcode.hard;

import java.util.*;

/**
 * @tree
 *
 * get two lists of leaves and compare values one by one
 * list of leaf:
 * recursive traverse the tree, left subtree first
 * base case: 1. null return 2. leaf node (left&right child null)
 *
 */
public class LeafSimilarTrees {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        } else if (root1 == null || root2 == null) {
            return false;
        }

        List<Integer> list1 = new ArrayList<>();
        getLeafList(root1, list1);
        List<Integer> list2 = new ArrayList<>();
        getLeafList(root2, list2);

        if (list1.size() != list2.size()) return false;
        for (int i = 0; i < list1.size(); i++) {
            if (list1.get(i) != list2.get(i)) return false;
        }
        return true;
    }

    private void getLeafList(TreeNode node, List<Integer> list) {
        if (node == null) return;
        if (node.left == null && node.right == null) list.add(node.val);
        getLeafList(node.left, list);
        getLeafList(node.right, list);
    }

    public boolean leafSimilar1(TreeNode root1, TreeNode root2) {
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        getLeaves(root1, q1);
        getLeaves(root2, q2);
        while (!q1.isEmpty() && !q2.isEmpty()) {
            if (q1.poll().val != q2.poll().val) {
                return false;
            }
        }
        if (q1.isEmpty() && q2.isEmpty()) {
            return true;
        }
        return false;
    }

    private void getLeaves(TreeNode node, Queue<TreeNode> q) {
        if (node == null) return;
        if (node.left == null && node.right == null) q.offer(node);
        getLeaves(node.left, q);
        getLeaves(node.right, q);
    }

    /**
     * for time complexity, O(N) is the optimal
     * but for space, we do not need to store all the nodes
     * need to keep track of the parent, and go to left subtree, iteratively
     */
    public boolean leafSimilar2(TreeNode root1, TreeNode root2) {
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.push(root1);
        s2.push(root2);
        while (!s1.isEmpty() && !s2.isEmpty()) {
            if (dfs(s1) != dfs(s2)) return false;
        }
        return s1.isEmpty() && s2.isEmpty();
    }

    private int dfs(Stack<TreeNode> stack) {
        while (true) {
            TreeNode cur = stack.pop();
            if (cur.right != null) stack.push(cur.right);
            if (cur.left != null) stack.push(cur.left);
            if (cur.left == null && cur.right == null) return cur.val;
        }
    }
}
