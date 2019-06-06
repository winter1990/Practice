package practice.leetcode.medium;

import java.util.Random;

/**
 * @linkedlist
 * @reservoir
 *
 * Given a singly linked list, return a random node's value from the linked list.
 * Each node must have the same probability of being chosen.
 *
 * Follow up:
 * What if the linked list is extremely large and its length is unknown to you?
 * Could you solve this efficiently without using extra space?
 *
 * intuitive solution
 * count the total length of the linked list - n
 * get a random number r = [0,n)
 * move cur = head r times and return
 *
 * large list with unknown length
 * we traverse the list and get the random at the same time
 *
 */
public class LinkedListRandomNode {
    class Solution {
        ListNode head;
        Random random;
        public Solution(ListNode head) {
            this.head = head;
            random = new Random();
        }

        public int getRandom() {
            ListNode node = head;
            int res = head.val;
            for (int i = 1; node.next != null; i++) {
                node = node.next;
                if (random.nextInt(i + 1) == i) res = node.val;
            }
            return res;
        }
    }

    class Solution1 {
        int n;
        Random random;
        ListNode head;
        public Solution1(ListNode head) {
            this.head = head;
            int len = 1;
            ListNode cur = head;
            while (cur.next != null) {
                len++;
                cur = cur.next;
            }
            n = len;
            random = new Random();
        }

        /** Returns a random node's value. */
        public int getRandom() {
            int r = random.nextInt(n);
            ListNode node = head;
            while (r > 0) {
                node = node.next;
                r--;
            }
            return node.val;
        }
    }
}