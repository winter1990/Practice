package practice.leetcode.medium;

/**
 * @linkedlist
 *
 * head changed, need dummy node
 * .next and .next.next
 *
 * 1-2-3-4-5
 * 2-1-4-3-5
 */
public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        if (head == null) {
            return null;
        }
        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            ListNode n = cur.next;
            cur.next = cur.next.next;
            n.next = n.next.next;
            cur.next.next = n;
            cur = cur.next.next;
        }
        return dummy.next;
    }

    public ListNode swapPairs1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode n = head.next;
        head.next = swapPairs1(head.next.next);
        n.next = head;
        return n;
    }
}
