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
        if (head == null || head.next == null) return head;
        ListNode n = head.next;
        head.next = swapPairs(head.next.next);
        n.next = head;
        return n;
    }

    public ListNode swapPairs1(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            ListNode tmp = cur.next.next;
            cur.next.next = cur.next.next.next;
            tmp.next = cur.next;
            cur.next = tmp;
            cur = cur.next.next;
        }
        return dummy.next;
    }

}
