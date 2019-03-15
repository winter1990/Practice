package practice.leetcode.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * @linkedlist
 *
 * We are given head, the head node of a linked list containing unique integer values.
 * We are also given the list G, a subset of the values in the linked list.
 * Return the number of connected components in G, where two values are connected if they appear consecutively
 * in the linked list.
 *
 * for quick look up, need extra data structure to store all the values in the G
 * scan through the list and find the connected ones, remove from Set (because unique values in the list)
 */
public class LinkedListComponents {
    public int numComponents(ListNode head, int[] G) {
        Set<Integer> set = new HashSet<>();
        for (int i : G) set.add(i);
        ListNode cur = head;
        int res = 0;
        while (cur != null) {
            if (set.contains(cur.val) && (cur.next == null || !set.contains(cur.next.val))) res++;
            cur = cur.next;
        }
        return res;
    }
}
