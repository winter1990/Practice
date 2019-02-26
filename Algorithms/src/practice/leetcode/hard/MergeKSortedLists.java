package practice.leetcode.hard;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @heap
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
        if (lists == null || lists.length == 0) {
            return null;
        }
        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode l1, ListNode l2) {
                return l1.val - l2.val;
            }
        });
        for (ListNode n : lists) {
            if (n != null) {
                pq.offer(n);
            }
        }
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            if (node.next != null) {
                pq.offer(node.next);
            }
            cur.next = node;
            cur = cur.next;
        }
        return dummy.next;
    }
}
