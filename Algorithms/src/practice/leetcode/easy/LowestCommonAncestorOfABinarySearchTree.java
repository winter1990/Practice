package practice.leetcode.easy;

/*
        _______3______
       /              \
    ___5__          ___1__
   /      \        /      \
   6      _2       0       8
         /  \
         7   4
 */

/**
 * basic scenarios:
 * 1. null
 * 2. p
 * 3. q
 * 4. ancestor
 *
 * method 1: p and q should be in left branch and right branch
 * method 2: search tree once, find earlier nodes in recursive call
 * - return p if root subtree includes p (not q)
 * - return q if root subtree includes q (not p)
 * - return null if neither p and q are in root subtree
 * - else return common ancestor
 */
public class LowestCommonAncestorOfABinarySearchTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        return left == null ? right : left;
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        n1.left=n2;
        n1.right=n3;
        n2.left=n4;
        n2.right=n5;
        n5.right=n6;
        LowestCommonAncestorOfABinarySearchTree l = new LowestCommonAncestorOfABinarySearchTree();
        l.lowestCommonAncestor(n1,n4,n6);
    }

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
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
