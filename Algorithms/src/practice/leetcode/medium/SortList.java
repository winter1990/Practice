package practice.leetcode.medium;

/**
 * @linkedlist
 * @sort
 * @daq
 *
 * Sort a linked list in O(n log n) time using constant space complexity.
 *
 * 4-2-1-5-3 -> 1-2-3-4-5
 * divide and conquer thinking:
 * divide into two linked list until only 1/2 elements left
 * merge the lists recursively
 * for above case, divide the list into
 * 4-2-1, 5-3 (first half is always longer or equal to second half)
 * 4-2, 1 | 5, 3
 * 4, 2, 1 | 5, 3
 * merge 4 and 2 to 2-4, then merge with 1, becomes 1-2-4
 * merge 5 and 3 to 3-5
 * at last merge two 1-2-3-4-5
 */
public class SortList {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode l1 = head;
        ListNode l2 = head;
        while (l2.next != null && l2.next.next != null) {
            l1 = l1.next;
            l2 = l2.next.next;
        }
        l2 = l1.next;
        l1.next = null;

        l1 = sortList(head);
        l2 = sortList(l2);
        return merge(l1, l2);
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next= l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 == null ? l2 : l1;
        return dummy.next;
    }

}
