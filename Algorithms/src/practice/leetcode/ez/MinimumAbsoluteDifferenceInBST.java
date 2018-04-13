package practice.leetcode.ez;

import java.util.Stack;
import java.util.TreeSet;

/**
 * @tree
 * @recursion
 *
 * inorder traversal
 * pass the previous value in recursive call
 *
 * [236,104,701,null,227,null,911]
 *          236
 *      104     701
 *         227     911
 */
public class MinimumAbsoluteDifferenceInBST {
    int min = Integer.MAX_VALUE;
    TreeNode pre = null;
    public int getMinimumDifference(TreeNode root) {
        inorderTraversal(root);
        return min;
    }

    private void inorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        getMinimumDifference(root.left);
        if (pre != null) {
            min = Math.min(min, Math.abs(root.val - pre.val));
        }
        pre = root;
        getMinimumDifference(root.right);
    }


    public int getMinimumDifference1(TreeNode root) {
        int min = Integer.MAX_VALUE;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root, pre = null;
        while (cur != null || !stack.empty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                if (pre != null)
                    min = Math.min(min, cur.val - pre.val);
                pre = cur;
                cur = cur.right;
            }
        }
        return min;
    }


    TreeSet<Integer> set = new TreeSet<>();
    int minValue = Integer.MAX_VALUE;
    public int getMinimumDifference3(TreeNode root) {
        if (root == null) return minValue;

        if (!set.isEmpty()) {
            if (set.floor(root.val) != null) {
                minValue = Math.min(minValue, root.val - set.floor(root.val));
            }
            if (set.ceiling(root.val) != null) {
                minValue = Math.min(minValue, set.ceiling(root.val) - root.val);
            }
        }
        set.add(root.val);
        getMinimumDifference3(root.left);
        getMinimumDifference3(root.right);
        return minValue;
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(236);
        TreeNode n2 = new TreeNode(104);
        TreeNode n3 = new TreeNode(227);
        TreeNode n4 = new TreeNode(701);
        TreeNode n5 = new TreeNode(911);
        n1.left = n2;
        n2.right = n3;
        n1.right = n4;
        n4.right = n5;
        MinimumAbsoluteDifferenceInBST m = new MinimumAbsoluteDifferenceInBST();
        System.out.println(m.getMinimumDifference(n1));
    }
}
