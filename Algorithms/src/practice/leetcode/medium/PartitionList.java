package practice.leetcode.medium;

/**
 * @linkedlist
 *
 * all nodes less than x come before nodes greater than or equal to x
 * 1->4->3->2->5->2 and x = 3,1->2->2->4->3->5
 *
 * two Lists two pointers
 * if smaller, concatenate to first list, if equal or larger, concatenate to second list
 * at last we have two linked lists, link them together tail to head
 * check leftover nodes, unlinked nodes, or wrong next reference node
 */
public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode d1 = new ListNode(0);
        ListNode d2 = new ListNode(0);
        ListNode l1 = d1, l2 = d2;
        while (head != null) {
            if (head.val < x) {
                l1.next = head;
                l1 = l1.next;
            } else {
                l2.next = head;
                l2 = l2.next;
            }
            head = head.next;
        }
        l1.next = d2.next;
        l2.next = null;
        return d1.next;
    }
}
