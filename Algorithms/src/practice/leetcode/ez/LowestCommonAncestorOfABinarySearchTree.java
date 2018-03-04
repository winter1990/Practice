package practice.leetcode.ez;

/**
 * basic scenarios:
 * 1. null
 * 2. p
 * 3. q
 * 4. ancestor
 *
 * method 1: p and q should be in left branch and right branch
 * method 2: search tree once, find earlier nodes in stack
 * - return p if root subtree includes p (not q)
 * - return q if root subtree includes q (not p)
 * - return null if neither p and q are in root subtree
 * - else return common ancestor
 */
public class LowestCommonAncestorOfABinarySearchTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root == p && root == q) {
            return root;
        }
        TreeNode x = lowestCommonAncestor(root.left, p, q);
        if (x != null && x != p && x != q) {
            return x;
        }
        TreeNode y = lowestCommonAncestor(root.right, p, q);
        if (y != null && y != p && y != q) {
            return y;
        }
        if (x != null && y != null) {
            return root;
        } else if (root == p || root == q) {
            return root;
        } else {
            return x == null ? y : x;
        }
    }

    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if (!containsNode(root, p) || !containsNode(root, q)) {
            return null;
        }
        return helper(root, p, q);
    }

    private TreeNode helper(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        boolean pLeft = containsNode(root.left, p);
        boolean qLeft = containsNode(root.left, q);
        if (pLeft != qLeft) {
            return root;
        }
        TreeNode node = pLeft ? root.left : root.right;
        return helper(node, p, q);

    }

    private boolean containsNode(TreeNode root, TreeNode n) {
        if (root == null) {
            return false;
        }
        if (root == n) {
            return true;
        }
        return containsNode(root.left, n) || containsNode(root.right, n);
    }


}
