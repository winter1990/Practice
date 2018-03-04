package practice.leetcode.medium;

/**
 * all nodes less than x come before nodes greater than or equal to x
 * 1->4->3->2->5->2 and x = 3,1->2->2->4->3->5
 *
 * two Lists two pointers
 *
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
        l2.next = null; // 1-2-3-1,2
        return d1.next;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(1);
        n1.next = n2;
        PartitionList rd = new PartitionList();
        System.out.println(rd.partition(n1,2).next.next.val);
    }
}
