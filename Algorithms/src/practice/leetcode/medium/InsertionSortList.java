package practice.leetcode.medium;

/**
 * @sort
 * @linkedlist
 *
 * dummy-2-3-5-4-1
 * try to run some basic simple cases and for the while or for loop, quickly go through at least two iterations
 * determine and check when and where we should update and set/reset the index
 */
public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy, cur = head;
        while (cur.next != null) {
            pre = dummy;
            if (cur.val > cur.next.val) {
                while (pre.next.val < cur.next.val) {
                    pre = pre.next;
                }
                ListNode tmp = pre.next;
                pre.next = cur.next;
                cur.next = cur.next.next;
                pre.next.next = tmp;
            } else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}
