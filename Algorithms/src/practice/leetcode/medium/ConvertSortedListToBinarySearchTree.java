package practice.leetcode.medium;

/**
 * @linkedlist
 *
 * the limitation of a linked list is we can not access to element directly based on index
 *
 * recursion:
 * get length, set up left right node based on the number
 */
public class ConvertSortedListToBinarySearchTree {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        return helper(head, null);
    }

    private TreeNode helper(ListNode head, ListNode tail) {
        if (head == tail) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != tail && fast.next != tail) {
            slow = slow.next;
            fast = fast.next.next;
        }
        TreeNode node = new TreeNode(slow.val);
        node.left = helper(head, slow);
        node.right = helper(slow.next, tail);
        return node;
    }

    ListNode cur;
    public TreeNode sortedListToBST1(ListNode head) {
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
