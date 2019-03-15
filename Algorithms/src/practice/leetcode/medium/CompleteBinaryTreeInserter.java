package practice.leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

public class CompleteBinaryTreeInserter {
}

/**
 * A complete binary tree is a binary tree in which every level, except possibly the last, is completely filled,
 * and all nodes are as far left as possible.
 * CBTInserter(TreeNode root) initializes the data structure on a given tree with head node root;
 * CBTInserter.insert(int v) will insert a TreeNode into the tree with value node.val = v so that the tree remains
 * complete, and returns the value of the parent of the inserted TreeNode;
 * CBTInserter.get_root() will return the head node of the tree.
 */

/**
 * get root is straightforward
 * for insert, we need to insert the node to:
 * 1.lowest level, initialize a queue, level order traversal
 * 2. as left as possible, check left, and right (go next)
 * 3. if full, go to next level, when insert, also push to queue, automatically goes to next level
 */
class CBTInserter {
    TreeNode root;
    Queue<TreeNode> q;
    public CBTInserter(TreeNode root) {
        this.root = root;
        q = new LinkedList<>();
        q.offer(root);
        while (true) {
            TreeNode cur = q.peek();
            if (cur.left != null) {
                q.offer(cur.left);
            } else {
                break;
            }
            if (cur.right != null) {
                q.offer(cur.right);
            } else {
                break;
            }
            q.poll();
        }
    }

    public int insert(int v) {
        TreeNode cur = q.peek();
        TreeNode node = new TreeNode(v);
        if (cur.left == null) {
            cur.left = node;
        } else if (cur.right == null) {
            cur.right = node;
            q.poll();
        }
        q.offer(node);
        return cur.val;
    }

    public TreeNode get_root() {
        return root;
    }
}