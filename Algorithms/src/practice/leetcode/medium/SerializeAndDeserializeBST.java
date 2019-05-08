package practice.leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @tree
 * @design
 * @string
 *
 * You may serialize the following tree:
   1
  / \
 2   3
    / \
   4   5
as "[1,2,3,null,null,4,5]"

 *          4
          2   5
        1  3   6
        pre-order:
        4,2,1,#,#,3,#,#,5,#,6
 *
 * for serialization:
 * order traversal - select between preorder inorder and postorder
 * for in order, we do not know the root from the string
 * for post order, the same problem for subtree
 * preorder is the selection
 * we need separator between two nodes, and special character for null -> , #
 * start with root node, recursively traverse down the tree. left child first, then right child.
 * base case: if node is null, append @ and separatpr
 * otherwise, append current node value
 * next call with left chilld
 * next call with right child
 *
 * for deserialization:
 * split by separator to get string array
 * recursively assign child:
 *
 */
public class SerializeAndDeserializeBST {
    public static void main(String[] args) {

    }
}

class Codec3 {
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

    public TreeNode deserialize(String data) {
        if (data == null) {
            return null;
        }
        String[] nodes = data.split(separator);
        Queue<String> q = new LinkedList<>();
        for (String s : nodes) q.offer(s);
        return deserialize(q);
    }

    private TreeNode deserialize(Queue<String> q) {
        if (q.isEmpty()) return null;
        String val = q.poll();
        if (val.equals(N)) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.valueOf(val));
        node.left = deserialize(q);
        node.right = deserialize(q);
        return node;
    }
}