package practice.leetcode.medium;

/**
 * @linkedlist
 *
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 *
 * problem to solve:
 * 1. get value for the two nodes, calculate sum, keep track of the carry value for next
 * 2. two lists might be in different length - handle null pointer
 * 3. might have 1 digit left over at the end
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        int c = 0;
        while (l1 != null || l2 != null) {
            int m = l1 == null ? 0 : l1.val;
            int n = l2 == null ? 0 : l2.val;
            int val = m + n + c;
            c = val / 10;
            val %= 10;
            cur.next = new ListNode(val);
            cur = cur.next;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        if (c != 0) {
            cur.next = new ListNode(c);
        }
        return dummy.next;
    }
}
