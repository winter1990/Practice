package practice.leetcode.easy;

import java.util.Stack;

/**
 * @linkedlist
 *
 * 1-2-3-2-1
 * 1-2-3-4
 * reverse half and compare with the other half
 * slow and fast runner
 */
public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if (head == null) return true;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast != null) {
            slow = slow.next;
        }
        slow = reverse(slow);
        fast = head;
        while (slow != null) {
            if (slow.val != fast.val) return false;
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }

    private ListNode reverse(ListNode node) {
        ListNode pre = null;
        ListNode next;
        while (node != null) {
            next = node.next;
            node.next = pre;
            pre = node;
            node = next;
        }
        return pre;
    }

    // recursion
    ListNode node;
    public boolean isPalindrome1(ListNode head) {
        node = head;
        return isPalin(head);
    }

    private boolean isPalin(ListNode cur) {
        if (cur == null) {
            return true;
        }
        boolean isPalin = isPalin(cur.next);
        boolean isSameVal = node.val == cur.val;
        node = node.next;
        return isPalin && isSameVal;
    }

    public boolean isPalindrome2(ListNode head) {
        if (head == null) return true;
        int n = 0;
        ListNode cur = head;
        while (cur != null) {
            cur = cur.next;
            n++;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast == null) {
            fast = slow;
        } else {
            fast = slow.next;
        }
        Stack<ListNode> stack = new Stack<>();
        while (fast != null) {
            stack.push(fast);
            fast = fast.next;
        }
        slow = head;
        while (!stack.isEmpty()) {
            if (slow.val != stack.pop().val) return false;
            slow = slow.next;
        }
        return true;
    }
}
