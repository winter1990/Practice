package practice.leetcode.medium;

import java.util.Stack;

/**
 * @linkedlist
 *
 * Input: [2,1,5] Output: [5,5,0]
 * Input: [2,7,4,3,5] Output: [7,0,5,5,0]
 * Input: [1,7,5,1,9,2,5,1] Output: [7,9,9,9,0,5,0,0]
 *
 * count the length of the list
 * if first node or smaller than the last node, push into the stack [index, value]
 * if larger than
 */
public class NextGreaterNodeInLinkedList {
    public int[] nextLargerNodes(ListNode head) {
        Stack<int[]> stack = new Stack<>();
        int len = getLen(head);
        int[] res = new int[len];
        ListNode cur = head;
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && cur.val > stack.peek()[1]) {
                res[stack.pop()[0]] = cur.val;
            }
            stack.push(new int[]{i, cur.val});
            cur = cur.next;
        }
        return res;
    }

    private int getLen(ListNode head) {
        int count = 0;
        ListNode cur = head;
        while (cur != null) {
            cur = cur.next;
            count++;
        }
        return count;
    }
}
