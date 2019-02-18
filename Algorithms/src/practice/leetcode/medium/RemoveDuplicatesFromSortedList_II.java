package practice.leetcode.medium;

/**
 * @linkedlist
 *
 * 1-2-3-3-4, 1-2-4
 * 1-1-2-3, 2-3
 *
 * one pointer is not enough as we need to track the previous node and use another pointer to traverse the list
 * pre = dummy and cur = head
 * while cur != null, while cur = next then move cur, pre = cur.next
 * when we need to update pre? if we remove nodes, no need to
 * so need to check if we have removed some nodes - pre.next ? cur
 */
public class RemoveDuplicatesFromSortedList_II {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        while (cur != null) {
            while (cur.next != null && cur.val == cur.next.val) {
                cur = cur.next;
            }
            if (pre.next == cur) {
                pre = cur;
            } else {
                pre.next = cur.next;
            }
            cur = cur.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(1);
        n1.next = n2;
        RemoveDuplicatesFromSortedList_II rd = new RemoveDuplicatesFromSortedList_II();
        System.out.println(rd.deleteDuplicates(n1));
    }
}
