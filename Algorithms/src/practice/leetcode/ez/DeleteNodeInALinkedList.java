package practice.leetcode.ez;

/**
 * in place
 */
public class DeleteNodeInALinkedList {
    public void deleteNode(ListNode node) {
        if (node == null) {
            return;
        }
        ListNode cur = node;
        cur.val = cur.next.val;
        cur.next = cur.next.next;
    }
}
