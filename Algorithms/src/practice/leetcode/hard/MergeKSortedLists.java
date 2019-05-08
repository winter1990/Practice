package practice.leetcode.hard;

import java.util.PriorityQueue;

/**
 * @heap
 * @daq
 *
 * 1-5-7
 * 2-3-6
 * 4
 * (1 2 4) 1, (5 2 4) 1-2, (5 3 4) 1-2-3, (5 6 4) 1-2-3-4
 * start with a list of heads
 * find the smallest of ALL heads
 * maintain the new head
 * ds choose need to get smallest, remove, add
 * priority queue
 */
public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, (a, b) -> (a.val - b.val));
        for (ListNode n : lists) {
            if (n != null) pq.offer(n);
        }
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            if (node.next != null) pq.offer(node.next);
            cur.next = node;
            cur = cur.next;
        }
        return dummy.next;
    }

    /**
     * divide and conquer
     * recursively divide the list of nodes into sub lists until lo == hi
     * merge two lists
     */
    public ListNode mergeKLists1(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        return mergeLists(lists, 0, lists.length - 1);
    }

    private ListNode mergeLists(ListNode[] lists, int lo, int hi) {
        if (lo == hi) {
            return lists[lo];
        }
        int mid = lo + (hi - lo) / 2;
        ListNode l1 = mergeLists(lists, lo, mid);
        ListNode l2 = mergeLists(lists, mid + 1, hi);
        return merge(l1, l2);
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val) {
            l1.next = merge(l1.next, l2);
            return l1;
        } else {
            l2.next = merge(l1, l2.next);
            return l2;
        }
    }

}
