package practice.leetcode.medium;

/**
 * @linkedlist
 *
 * 1-2-3-4-5,2
 * 4-5-1-2-3
 *
 * fast and slow runner
 * use dummy node because we need to concatenate the tail to the head
 * k > length? get length first and k = k % len
 * k = 0? no rotation
 */
public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        int len = getLength(head);
        k = k % len;
        if (k == 0) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = head;
        ListNode fast = head;
        while (k-- > 0) {
            fast = fast.next;
        }
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        dummy.next = slow.next;
        fast.next = head;
        slow.next = null;
        return dummy.next;
    }

    private int getLength(ListNode head) {
        ListNode cur = head;
        int len = 1;
        while (cur.next != null) {
            cur = cur.next;
            len++;
        }
        return len;
    }
}
