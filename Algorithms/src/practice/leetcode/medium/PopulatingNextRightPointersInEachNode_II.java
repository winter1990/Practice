package practice.leetcode.medium;

/*
         1
       /  \
      2    3
     / \    \
    4   5    7
After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \    \
    4-> 5 -> 7 -> NULL
 */


/**
 * method 1: use a queue to store the upper level nodes. extra space needed
 * method 2: use constant space to traverse the upper layer
 */
public class PopulatingNextRightPointersInEachNode_II {
    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        } else if (root.left == null && root.right == null) {
            return;
        }
        TreeLinkNode node = root;
        TreeLinkNode pre = null;
        TreeLinkNode head = null;
        while (node != null) {
            while (node != null) {
                if (node.left != null) {
                    if (pre != null) {
                        pre.next = node.left;
                    } else {
                        head = node.left;
                    }
                    pre = node.left;
                }
                if (node.right != null) {
                    if (pre != null) {
                        pre.next = node.right;
                    } else {
                        head = node.right;
                    }
                    pre = node.right;
                }
                node = node.next;
            }
            node = head;
            pre = null;
            head = null;
        }
    }
}
