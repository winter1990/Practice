package practice.leetcode.hard;

import java.util.Stack;

/**
 * @tree
 *
 * Input: "1-2--3--4-5--6--7", Output: [1,2,5,3,4,6,7]
 * Input: "1-2--3---4-5--6---7", Output: [1,2,5,3,null,6,null,4,null,7]
 * Input: "1-401--349---90--88", Output: [1,401,null,349,88,90]
 *
 * use a stack, to track the previous nodes/level
 *
 */
public class RecoverATreeFromPreorderTraversal {
    public TreeNode recoverFromPreorder(String S) {
        int i = S.indexOf('-');
        if (i == -1) return new TreeNode(Integer.valueOf(S));
        TreeNode root = new TreeNode(Integer.valueOf(S.substring(0, i)));
        Stack<TreeNode> stack = new Stack();
        stack.push(root);
        int n = S.length(), level, val;
        while (i < n) {
            level = 0;
            val = 0;
            while (S.charAt(i) == '-') {
                level++;
                i++;
            }
            while (i < n && Character.isDigit(S.charAt(i))) {
                val *= 10;
                val += (S.charAt(i) - '0');
                i++;
            }
            TreeNode node = new TreeNode(val);
            if (level == stack.size()) {
                stack.peek().left = node;
            } else if (level < stack.size()) {
                while (stack.size() > level) {
                    stack.pop();
                }
                stack.peek().right = node;
            }
            stack.push(node);
        }
        return root;
    }

    public static void main(String[] args) {
        RecoverATreeFromPreorderTraversal r = new RecoverATreeFromPreorderTraversal();
        String s = "1-401--349---90--88";
        r.recoverFromPreorder(s);
    }
}
