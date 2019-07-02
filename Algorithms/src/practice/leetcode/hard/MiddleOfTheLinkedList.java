package practice.leetcode.hard;

/**
 * @linkedlist
 *
 * Input: [1,2,3,4,5], Output: Node 3 from this list
 * Input: [1,2,3,4,5,6], Output: Node 4 from this list
 *
 * slow and fast runner
 * if only one/two nodes in the list
 *
 */
public class MiddleOfTheLinkedList {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
