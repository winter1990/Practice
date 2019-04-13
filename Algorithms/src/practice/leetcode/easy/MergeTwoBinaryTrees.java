package practice.leetcode.easy;

/*
Input:
	Tree 1                     Tree 2
          1                         2
         / \                       / \
        3   2                     1   3
       /                           \   \
      5                             4   7
Output:
Merged tree:
	     3
	    / \
	   4   5
	  / \   \
	 5   4   7
 */


/**
 * recursively traverse two trees
 * if both null, null
 * if one is null, the other
 * if both not null, add
 */
public class MergeTwoBinaryTrees {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        } else if (t2 == null) {
            return t1;
        }
        return helper(t1, t2);
    }

    private TreeNode helper(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return null;
        } else if (t1 == null || t2 == null) {
            return t1 == null ? t2 : t1;
        }
        TreeNode node = new TreeNode(t1.val + t2.val);
        node.left = helper(t1.left, t2.left);
        node.right = helper(t1.right, t2.right);
        return node;
    }
}
