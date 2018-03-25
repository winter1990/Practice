package practice.leetcode.medium;

import practice.leetcode.ez.ConstructStringFromBinaryTree;

import java.util.Stack;

/**
 * There will only be '(', ')', '-' and '0' ~ '9' in the input string.
 * You always start to construct the left child node of the parent first if it exists
 *
 * recursion:
 * start with index 0
 * get number (check "-")
 *
 */
public class ConstructBinaryTreeFromString {
    public TreeNode str2tree1(String s) {
        if (s.equals("")) {
            return null;
        }
        int i = 0;
        char[] cs = s.toCharArray();
        Stack<TreeNode> stack = new Stack<>();
        while (i < s.length()) {
            int j = i;
            char c = cs[i];
            if (c == ')') { // done for current node
                stack.pop();
            } else {
                if (c == '-' || Character.isDigit(c)) {
                    while (i < s.length() - 1 && Character.isDigit(cs[i + 1])) {
                        i++;
                    }
                    TreeNode node = new TreeNode(Integer.valueOf(s.substring(j, i + 1)));
                    if (!stack.isEmpty()) {
                        TreeNode parent = stack.peek();
                        if (parent.left == null) {
                            parent.left = node;
                        } else {
                            parent.right = node;
                        }
                    }
                    stack.push(node);
                }
            }
            i++;
        }
        return stack.peek();
    }

    public TreeNode str2tree(String s) {
        if (s.equals("")) {
            return null;
        }
        return helper(s);
    }

    private TreeNode helper(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }
        int left = s.indexOf('(');
        if (left == -1) {
            return new TreeNode(Integer.valueOf(s));
        }
        int val = Integer.valueOf(s.substring(0, left));
        TreeNode node = new TreeNode(val);
        // get the string for left subtree
        int checker = 0;
        int index = left;
        while (index < s.length()) {
            char c = s.charAt(index);
            if (c == '(') {
                checker++;
            } else if (c == ')') {
                checker--;
            }
            if (checker == 0) {
                node.left = helper(s.substring(left + 1, index));
                break;
            }
            index++;
        }
        if (index < s.length() - 1) { // chars left for right tree
            node.right = helper(s.substring(index + 2, s.length() - 1));
        }
        return node;
    }
}
