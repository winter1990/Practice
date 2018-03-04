package practice.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * with data structure:
 * one loop,map node->new node,all nodes are created
 * set the next and random
 */
public class CopyListWithRandomPointer {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode node = head;
        while (node != null) {
            map.put(node, new RandomListNode(node.label));
            node = node.next;
        }

        node = head;
        while (node != null) {
            map.get(node).next = map.get(node.next);
            map.get(node).random = map.get(node.random);
            node = node.next;
        }
        return map.get(head);
    }

    /**
     * without data structure
     */
    public RandomListNode copyRandomList1(RandomListNode head) {
        if (head == null) {
            return null;
        }
        RandomListNode node = head;
        while (node != null) {
            RandomListNode copy = new RandomListNode(node.label);
            copy.next = node.next;
            node.next = copy;
            node = copy.next;
        }
        node = head;
        while (node != null) {
            if (node.random != null) {
                node.next.random = node.random.next;
            }
            node = node.next.next;
        }

        node = head;
        RandomListNode newHead = node.next;
        while (node != null) {
            RandomListNode tmp = node.next;
            node.next = tmp.next;
            if (tmp.next != null) {
                tmp.next = tmp.next.next;
            }
            node = node.next;
        }
        return newHead;
    }
}
