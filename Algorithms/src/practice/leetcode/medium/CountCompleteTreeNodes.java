package practice.leetcode.medium;

/**
 * 1.full on all levels
 * 2.last level may not
 * 3.left on last level
 * if there is one null,last level
 *
 * level by level - use queue to store nodes
 * determine last level - left/right child null
 * if null found - all the rest nodes' children null
 * at last check q is empty
 */

/**
 * above is for 'check if tree is complete tree'
 *
 * Given a complete binary tree, count the number of nodes
 * compare the height of left and right subtree
 * if same height,left are complete,left+root=1<<h,go to right
 * if not same,right subtree is complete,right+root1<<h-1,go to left
 */
public class CountCompleteTreeNodes {
    public int countNodes(TreeNode root) {
        int res = 0;
        int h = getHeight(root);
        while (root != null) {
            if (getHeight(root.right) == h - 1) {
                res += 1 << h;
                root = root.right;
            } else {
                res += 1 << h - 1;
                root = root.left;
            }
            h--;
        }
        return res;
    }

    private int getHeight(TreeNode root) {
        return root == null ? -1 : 1 + getHeight(root.left);
    }
}
