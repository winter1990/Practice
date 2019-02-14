package practice.leetcode.medium;

/**
 * @linkedlist
 *
 * get len, move and delete
 *
 * optimized:
 * one pass. fast and slow runners
 *
 * 1-2-3-4-5, 2 => 1-2-3-5
 */
public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        while (n-- > 0) {
            fast = fast.next;
        }
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}
