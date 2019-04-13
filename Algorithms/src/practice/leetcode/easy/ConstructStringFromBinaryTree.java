package practice.leetcode.easy;

/**
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

 * all the leaf node has independent left and right parenthesis
 * pre-order traversal:
 * recursion
 * if null, return empty string
 * recursively go to left node
 * recursively go to right node
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

    public String helper(TreeNode t) {
        if (t == null) {
            return "";
        }
        String l = helper(t.left);
        String r = helper(t.right);

        String res = "" + t.val;
        if (l == "") {
            if (r != "") res += "()";
        } else {
            res += "(" + l + ")";
        }
        if (r != "") {
            res += "(" + r + ")";
        }
        return res;
    }

    /**
     * @daq
     *
     * bottom up recursion
     */
    public String tree2str1(TreeNode t) {
        if (t == null) {
            return "";
        }
        String value = t.val + "";

        String left = tree2str1(t.left);
        String right = tree2str1(t.right);

        if (left == "" && right == "") return value;
        if (left == "") return value + "()" + "(" + right + ")";
        if (right == "") return value + "(" + left + ")";
        return value + "(" + left + ")" + "(" + right + ")";
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
