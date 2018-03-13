package practice.leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class SerializeAndDeserializeBST {
}

/**
 * tree traversal:
 * in, pre and post
 */
/*
         4
       2   5
     1  3   6
     level order: [4] [2 5] [1 3 # 6] [# # # # # #], more space, straightforward
     pre 4#2#1#3#5#6
 */
class Codec3 {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            sb.append(cur.val);
            sb.append('#');
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null) {
            return null;
        }
        String[] nodes = data.split("#");
        Queue<Integer> q = new LinkedList<>();
        for (String n : nodes) {
            q.offer(Integer.valueOf(n));
        }
        return helper(q);
    }

    private TreeNode helper(Queue<Integer> q) {
        if (q.isEmpty()) {
            return null;
        }
        TreeNode root = new TreeNode(q.poll());
        Queue<Integer> left = new LinkedList<>();
        while (!q.isEmpty() && q.peek() < root.val) {
            left.offer(q.poll());
        }
        root.left = helper(left);
        root.right = helper(q);
        return root;
    }
}