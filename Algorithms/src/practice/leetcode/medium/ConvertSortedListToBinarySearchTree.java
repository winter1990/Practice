package practice.leetcode.medium;

/**
 * the limitation is can not access to element based on index
 * convert to an array, convert
 *
 * recursion:
 * get length, set up left right node based on the number
 */
public class ConvertSortedListToBinarySearchTree {
    ListNode cur;
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        cur = head;
        int len = getLen(head);
        return helper(0, len - 1);
    }

    private TreeNode helper(int s, int e) {
        if (s > e) {
            return null;
        }
        int mid = (s + e) / 2;
        TreeNode left = helper(s, mid - 1);
        TreeNode root = new TreeNode(cur.val);
        cur = cur.next;
        TreeNode right = helper(mid + 1, e);
        root.left = left;
        root.right = right;
        return root;
    }


    private int getLen(ListNode head) {
        ListNode cur = head;
        int count = 1;
        while (cur.next != null) {
            cur = cur.next;
            count++;
        }
        return count;
    }
}
