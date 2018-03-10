package practice.leetcode.medium;

/**
 * root = [1, 2, 3], k = 5
 * Output: [[1],[2],[3],[],[]]
 * root = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10], k = 3
 * Output: [[1, 2, 3, 4], [5, 6, 7], [8, 9, 10]]
 *
 * for each sub list,the length len/k(+1 if remain > 0)
 */
public class SplitLinkedListInParts {
    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode[] res = new ListNode[k];
        if (root == null) {
            return res;
        }
        int len = getLength(root);
        int remain = len % k;
        int sublist = len / k;
        ListNode cur = root;
        ListNode pre = null;
        for (int i = 0; i < res.length; i++) {
            res[i] = cur;
            for (int j = 0; j < sublist + (remain > 0 ? 1 : 0); j++) {
                pre = cur;
                cur = cur.next;
            }
            pre.next = null;
            remain--;
        }
        return res;
    }

    /** mess up code. never create while in while look
    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode[] res = new ListNode[k];
        if (root == null) {
            return res;
        }
        int total = getLength(root);
        int remain = total % k;
        int len = total / k;
        int index = 0;
        ListNode cur = root;
        ListNode next, pre = cur;
        while (cur != null) {
            int count = 1;
            res[index] = cur;
            while (count < len) {
                pre = cur;
                cur = cur.next;
            }
            if (pre != cur && remain-- > 0) {
                cur = cur.next;
            }
            if (cur == null) {
                continue;
            } else {
                next = cur.next;
            }
            cur.next = null;
            cur = next;
            index++;
        }
        return res;
    }
     */

    private int getLength(ListNode node) {
        int count = 1;
        while (node.next != null) {
            count++;
            node = node.next;
        }
        return count;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;

        SplitLinkedListInParts ap = new SplitLinkedListInParts();
        ap.splitListToParts(l1, 5);
    }
}
