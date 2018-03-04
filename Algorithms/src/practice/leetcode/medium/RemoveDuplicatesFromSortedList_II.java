package practice.leetcode.medium;

/**
 * 1-2-3-3-4, 1-2-4
 * 1-1-2-3, 2-3
 */
public class RemoveDuplicatesFromSortedList_II {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode n1 = dummy;
        ListNode n2 = head;
        while (true) {
            if (n2 == null || n2.next == null) {
                break;
            }
            while (n2.next != null && n2.val == n2.next.val) {
                n2 = n2.next;
            }
            if (n1.next != n2) {
                n2 = n2.next;
                n1.next = n2;
            } else {
                n1 = n1.next;
                n2 = n2.next;
            }
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
