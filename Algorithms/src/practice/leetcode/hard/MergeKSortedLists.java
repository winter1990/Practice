package practice.leetcode.hard;

import java.util.PriorityQueue;

/**
 * @heap
 * @daq
 * @mergesort
 *
 * Merge k sorted linked lists and return it as one sorted list.
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * Output: 1->1->2->3->4->4->5->6
 *
 * method 1 - heap
 * put all the lists in a min heap, sort in ascending order
 * each time we:
 *   poll() from the queue
 *   add to new list
 *   update node
 *   if not null, then add back to the heap
 *   repeat the process until queue is empty
 *
 * method 2 - divide and conquer
 * merge sort
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
        return mergeSort(lists, 0, lists.length - 1);
    }

    private ListNode mergeSort(ListNode[] lists, int lo, int hi) {
        if (lo == hi) return lists[lo];
        int mid = lo + (hi - lo) / 2;
        ListNode l1 = mergeSort(lists, lo, mid);
        ListNode l2 = mergeSort(lists, mid + 1, hi);
        return merge(l1, l2);
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = merge(l1.next, l2);
            return l1;
        } else {
            l2.next = merge(l1, l2.next);
            return l2;
        }
    }

}
