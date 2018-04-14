package practice.leetcode.medium;

import com.sun.tools.corba.se.idl.constExpr.Plus;

/**
 * @linkedlist
 * @recursion
 *
 * 2-5-6-9-9-9
 * 9-9
 */
public class PlusOneLinkedList {
    public ListNode plusOne(ListNode head) {
        if (head == null) {
            return new ListNode(1);
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        while (fast.next != null) {
            if (fast.val != 9) {
                slow = fast;
            }
            fast = fast.next;
        }
        if (fast.val != 9) {
            fast.val++;
            return head;
        } else {
            slow.val++;
            slow = slow.next;
        }
        while (slow != null) {
            slow.val = 0;
            slow = slow.next;
        }
        return dummy.val == 0 ? dummy.next : dummy;
    }
}
