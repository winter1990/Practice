package practice.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @linkedlist
 *
 * Given 1->2->3->4, reorder it to 1->4->2->3.
 * Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
 *
 * get the first half and last half of the list
 * reverse the second half and merge the two lists
 */
public class ReorderList {
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode mid = getMid(head);
        ListNode newHead = reverser(mid.next);
        mid.next = null;
        merge(head, newHead);
    }

    private void merge(ListNode l1, ListNode l2) {
        ListNode cur = new ListNode(0);
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                cur.next = l1;
                l1 = l1.next;
                cur = cur.next;
            }
            if (l2 != null) {
                cur.next = l2;
                l2 = l2.next;
                cur = cur.next;
            }
        }
    }

    private ListNode reverser(ListNode mid) {
        ListNode pre = null, next = null, cur = mid;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    private ListNode getMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    /**
     * use a map to have the direct access to each node
     * we need to find the proper key, which can be 1, 2,...n
     * define two pointers left 1 and right n
     * while l < r, think about 1-2-3-4 and 1-2-3-4-5
     * use a dummy and current node
     * 0-1-4-2-3 -4
     * 0-1-5-2-4-5
     */
    public void reorderList1(ListNode head) {
        Map<Integer, ListNode> map = new HashMap<>();
        int label = 1;
        ListNode cur = head;
        while (cur != null) {
            map.put(label, cur);
            label++;
            cur = cur.next;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        cur = dummy;
        int left = 1, right = map.size();
        while (left < right) {
            cur.next = map.get(left);
            cur.next.next = map.get(right);
            left++;
            right--;
            cur = cur.next.next;
        }
        if (left == right) {
            cur.next = map.get(left);
            cur.next.next = null;
        } else {
            cur.next = null;
        }
    }
}
