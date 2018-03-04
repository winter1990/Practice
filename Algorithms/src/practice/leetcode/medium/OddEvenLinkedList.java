package practice.leetcode.medium;

/*
group all odd nodes together followed by the even nodes.
Please note here we are talking about the node number and not the value in the nodes.
Given  1->2->3->4->5->NULL
return 1->3->5->2->4->NULL
 */

/**
 * odd first,even after
 *
 */
public class OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode odd = head;
        ListNode even = head.next;
        ListNode headEven = even;
        while (odd.next != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = headEven;
        return head;
    }
}
