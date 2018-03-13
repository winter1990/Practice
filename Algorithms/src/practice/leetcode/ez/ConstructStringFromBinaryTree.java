package practice.leetcode.ez;
/*
Input: Binary tree: [1,2,3,4]
       1
     /   \
    2     3
   /
  4

Output: "1(2(4))(3)"

Input: Binary tree: [1,2,3,null,4]
       1
     /  \
    2    3
     \
      4

Output: "1(2()(4))(3)"
 */

/**
 * preorder traversal:
 * recursively add to result
 * when we go down to left add '('
 * if go right, check if left null
 */
public class ConstructStringFromBinaryTree {
    public String tree2str(TreeNode t) {
        if (t == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(t.val);
        helper(t, sb);
        return sb.toString();
    }

    private void helper(TreeNode n, StringBuilder sb) {
        if (n.left == null && n.right == null) {
            return;
        }
        if (n.left != null) {
            sb.append("(").append(n.left.val);
            helper(n.left, sb);
            sb.append(")");
        } else if (n.right != null) {
            sb.append("()").append("(").append(n.right.val);
            helper(n.right, sb);
            sb.append(")");
        }
        if (n.left != null && n.right != null) {
            sb.append("(").append(n.right.val);
            helper(n.right, sb);
            sb.append(")");
        }
    }

    public static void main(String[] args) {
        ConstructStringFromBinaryTree c = new ConstructStringFromBinaryTree();
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        t1.left = t2;
        t2.left = t3;
        t2.right= t4;
        System.out.println(c.tree2str(t1));
    }
}
