package practice.leetcode.medium;

/**
 * 1-2-3-4-5,2
 * 4-5-1-2-3
 *
 * fast and slow runner
 * use dummy node
 * k>length? get length first and k=k%len
 */
public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;

        int len = 0;
        while (fast.next != null) {
            len++;
            fast = fast.next;
        }
        fast = dummy;
        k = k % len;
        if (k == 0) {
            return head;
        }
        while (k-- > 0) {
            fast = fast.next;
        }
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        dummy.next = slow.next;
        slow.next = null;
        fast.next = head;
        return dummy.next;
    }
}
