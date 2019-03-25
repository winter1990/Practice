package practice.leetcode.hard;

import java.util.*;

/**
 * @tree
 *
 * Serialization is the process of converting a data structure or object into a sequence of bits so that it can be
 * stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in
 * the same or another computer environment.
 * Design an algorithm to serialize and deserialize a binary tree.
 *
 *      1
 *   2    3
 *  5    6
 *        7
 * 1 2 5 # # # 3 6 # 7 # # #
 * serialization:
 * preorder, inorder, postorder
 * use preorder, because the other two, we do not know which is the root (not BST)
 * define separator (,) and null node (as long as not number, use a special character)
 * recursively traverse down
 * if null, append # and separator
 * otherwise append node value and separator
 *
 * deserialization:
 * split by separator -> string[]
 * recursively recover the tree
 * base case: if #, return null
 * create new tree node
 * recursively assign left & right child -> which one to assign, not index based
 * put all ndoes in a queue, poll from it 1 by 1
 */
public class SerializeAndDeserializeBinaryTree {
    public class Codec {
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
        // 1 2 5 # # # 3 6 # 7 # # #
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
}
