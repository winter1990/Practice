package practice.leetcode.question;

import practice.leetcode.medium.TreeNode;

/**
 * one subtree has nodes that are all smaller or equal to the target value
 * the other subtree has all nodes that are greater than the target value
 *
 *           6
 *         /   \
 *       3      10
 *      / \    / \
 *     1   5  8   12
 * pre-order traversal
 * no matter what, root will be returned
 * when to cut, cur.val <= V, and check right child
 * too compelx to implement, always need to discuss the relationship between V, cur, left and right
 *
 * in-order traversal
 *
 */
public class SplitBST {
    public TreeNode[] splitBST(TreeNode root, int V) {
        if (root == null) {
            return new TreeNode[]{null, null};
        }
        if (root.val <= V) {
            TreeNode[] tmp = splitBST(root.right, V);
            root.right = tmp[0];
            tmp[0] = root;
            return tmp;
        } else {
            TreeNode[] tmp = splitBST(root.left, V);
            root.left = tmp[1];
            tmp[1] = root;
            return tmp;
        }
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(4);
        n2.left = n1;
        n2.right = n3;
        SplitBST s = new SplitBST();
        s.splitBST(n2, 1);

    }
    /*
    public TreeNode[] splitBST(TreeNode root, int V) {
        TreeNode[] res = new TreeNode[2];
        if (root == null) {
            return res;
        }
        res[0] = root;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null) {
            stack.push(cur);
            if (cur.val == V) {
                res[1] = cur;
                stack.pop();
                if (cur.val < stack.peek().val) {
                    stack.peek().left = cur.right;
                } else {
                    stack.peek().right = cur.right;
                }
                cur.right = null;
            } else if (cur.val < V) {
                cur = cur.right;
            } else {
                if (cur.left != null && cur.left.val < V) {
                    res[1] = cur;
                    stack.pop();

                }
                cur = cur.left;
            }
        }
        return res;
    }
    */
}
