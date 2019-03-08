package practice.leetcode.ez;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @tree
 *
 * the root node is at depth 0, and children of each depth k node are at depth k+1.
 * Two nodes of a binary tree are cousins if they have the same depth, but have different parents.
 * Each node has a unique integer value
 *
 * need to make sure the two nodes are in the same level -> BFS
 * if their parents are not the same -> there must be at least one node between them / empty node
 * for level order traversal, i = 0 i < q.size() i++, if node = target, we store the index
 * then we have two index of the target two nodes
 * node index a and b, if they have same parent -> a % 2 = 0 && b = a + 1, or b % 2 = 0 && a = b + 1 -> false
 * same level -> index = [0, 2^level], initialize two index as -1, check at last both of them are non-neg
 */
public class CousinsInBinaryTree {
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size(), xx = -1, yy = -1;
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                if (cur == null) continue;
                if (cur.val == x) {
                    xx = i;
                } else if (cur.val == y) {
                    yy = i;
                }
                q.offer(cur.left);
                q.offer(cur.right);
            }
            if ((xx % 2 == 0 && yy == xx + 1) || (yy % 2 == 0 && xx == yy + 1)) return false;
            if (xx != -1 && yy != -1) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        n1.left = n2;
        n1.right = n3;
        n2.right = n4;
        n3.right = n5;
        CousinsInBinaryTree c = new CousinsInBinaryTree();
        System.out.println(c.isCousins(n1, 4, 5));
    }
}
