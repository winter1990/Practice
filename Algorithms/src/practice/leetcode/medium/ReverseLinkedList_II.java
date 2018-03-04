package practice.leetcode.medium;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

/**
 * 1->2->3->4->5->NULL, m = 2 and n = 4,
 * 1->4->3->2->5->NULL
 * 1 ≤ m ≤ n ≤ length of list
 * Do it in-place and in one-pass.
 *
 * swap nodes from m to n
 * head might be changed so dummy node needed
 *
 * 0-1-2-3
 */
public class ReverseLinkedList_II {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        for (int i = 1; i < m; i++) {
            cur = cur.next;
        }
        cur.next = reverse(cur.next, n - m);
        return dummy.next;
    }

    private ListNode reverse(ListNode head, int n) {
        ListNode pre = null, cur = head, next = null;
        while (n-- >= 0) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        head.next = cur;
        return pre;
    }

}
