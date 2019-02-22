package practice.leetcode.ez;

/**
 * @linkedlist
 *
 * method 1
 * use set to store the nodes that have been visited - O(n) time, O(n) space
 *
 * method 2
 * two runners method
 * A from headA, B from headB. each of then moves one step at a time, so one of them will arrive the end
 * if A arrives first, let it start with headB, otherwise
 * so when they meet each other again
 * when the node is null, we reset the node to the other head
 */
public class IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        if (headA == null && headB == null) {
            return null;
        } else if (headA == null || headB == null) {
            return null;
        }
        ListNode a = headA;
        ListNode b = headB;
        while (a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }
        return a;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null && headB == null) {
            return null;
        } else if (headA == null || headB == null) {
            return null;
        } else if (headA == headB) {
            return headA;
        }
        ListNode a = headA;
        ListNode b = headB;

        int m = getLength(headA);
        int n = getLength(headB);

        while (m > n) {
            a = a.next;
            m--;
        }
        while (m < n) {
            b = b.next;
            n--;
        }

        while (a != b) {
            a = a.next;
            b = b.next;
        }
        return a;
    }

    public int getLength(ListNode n) {
        int c = 0;
        while (n != null) {
            n = n.next;
            c++;
        }
        return c;
    }
}
