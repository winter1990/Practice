package practice.leetcode.ez;

/**
 * @linkedlist
 *
 * 1 - 2 - 3 - 4 -> 4 - 3 - 2 - 1
 * current, next, previous
 */
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null;
        ListNode cur = head;
        ListNode next = cur.next;
        while (cur != null && next != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;
        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
        ListNode n4 = reverseLinkedList.reverseList(n1);
        System.out.println(n4.val);
    }
}
