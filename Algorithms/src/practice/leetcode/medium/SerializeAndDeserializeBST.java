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
     pre-order:
     # as null and , separates the ndoes
     4,2,1,#,#,3,#,#,5,#,6
 */
class Codec3 {
    // Encodes a tree to a single string.
    final String N = "#";
    final String separator = ",";
    public String serialize(TreeNode root) {
        if (root == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        buildTree(root, sb);
        return sb.toString();
    }

    private void buildTree(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append(N).append(separator);
            return;
        }
        sb.append(root.val).append(separator);
        buildTree(root.left, sb);
        buildTree(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null) {
            return null;
        }
        String[] nodes = data.split(separator);
        Queue<String> q = new LinkedList<>();
        for (String s : nodes) {
            q.offer(s);
        }
        return helper(q);
    }

    private TreeNode helper(Queue<String> q) {
        String val = q.poll();
        if (val.equals(N)) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.valueOf(val));
        node.left = helper(q);
        node.right = helper(q);
        return node;
    }
}