package practice.leetcode.hard;

import java.util.Stack;

/**
 * @linkedlist
 *
 * method 1: brute force
 * because two linked lists are not perfectly aligned, so need get length, start with last, second to last...
 * scan the two lists n times. because we can not go back
 *
 * method 2: reverse the two lists
 * so it's aligned from least significant digits
 * add two linked lists, and reverse again
 *
 * method 3:
 * reverse order of a linked list -> stack
 *
 *
 *
 *
 *
 * recursively add two nodes until reaching the tails
 * need to keep track of the carry
 * need to align the nodes - getLength
 *
 */
public class AddTwoNumbers_II {
    // iterative solution
    // for any problem that requires back tracking, use Stack
    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        while (l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }
        int sum = 0;
        ListNode newHead = new ListNode(1);
        while (!s1.isEmpty() || !s2.isEmpty()) {
            if (!s1.isEmpty()) sum += s1.pop();
            if (!s2.isEmpty()) sum += s2.pop();
            ListNode next = newHead.next;
            newHead.next = new ListNode(sum % 10);
            sum /= 10;
            newHead.next.next = next;
        }
        if (sum == 1) {
            return newHead;
        }
        return newHead.next;
    }

    // recursive solution
    int carry = 0;
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return null;
        } else if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }
        int len1 = getLength(l1);
        int len2 = getLength(l2);
        ListNode newHead = new ListNode(1);
        if (len1 > len2) {
            newHead.next = helper(l1, l2, len1 - len2);
        } else {
            newHead.next = helper(l2, l1, len2 - len1);
        }
        if (carry == 1) {
            return newHead;
        }
        return newHead.next;
    }

    // len(l1) > len(l2)
    private ListNode helper(ListNode l1, ListNode l2, int diff) {
        if (l1.next == null && l2.next == null) {
            int sum = l1.val + l2.val;
            carry = sum / 10;
            return new ListNode(sum % 10);
        }
        int sum;
        ListNode next;
        if (diff == 0) {
            next = helper(l1.next, l2.next, 0);
            sum  = l1.val + l2.val + carry;
        } else {
            next = helper(l1.next, l2, diff - 1);
            sum = l1.val + carry;
        }
        carry = sum / 10;
        ListNode cur = new ListNode(sum % 10);
        cur.next = next;
        return cur;
    }

    private int getLength(ListNode node) {
        int count = 1;
        while (node.next != null) {
            node = node.next;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(3);
        ListNode n2 = new ListNode(7); //   3-7
        ListNode n3 = new ListNode(8); // 8-6-9
        ListNode n4 = new ListNode(6); // 9-0-6
        ListNode n5 = new ListNode(9);
        n1.next = n2;
        n3.next = n4;
        n4.next = n5;
        AddTwoNumbers_II a = new AddTwoNumbers_II();
        System.out.println(a.addTwoNumbers(n1, n3));
    }
}
