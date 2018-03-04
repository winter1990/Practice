package practice.leetcode.medium;

/**
 *
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

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        ReorderList rl = new ReorderList();
        rl.reorderList(l1);
        System.out.println(l1.val + " " + l1.next.val + " " + l1.next.next.val + " " + l1.next.next.next.val);
    }
}
