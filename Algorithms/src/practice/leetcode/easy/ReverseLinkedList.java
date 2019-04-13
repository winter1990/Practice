package practice.leetcode.easy;

/**
 * @linkedlist
 *
 * Reverse a singly linked list.
 * [1 2 3 4 null] -> [4 3 2 1 null]
 *
 * take 1 add to the tail, take 2 add to previous node of 1, take 3 add to previous node to 2...
 * what we need to track in this list:
 * previous node, current (take this node to become new head node), next (when we move the current node, we lose ref)
 * start with the first node in the list, while cur != null
 * 1 2 3 4 null
 * pre cur next
 * null 1  2    1-null
 * 1    2  3    1-2-null
 * eventually pre is the first node in the new list, return pre
 */
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null;
        ListNode cur = head;
        ListNode next = cur.next;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
