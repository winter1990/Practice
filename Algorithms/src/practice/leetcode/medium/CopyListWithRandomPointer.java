package practice.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @linkedlist
 * @hashmap
 * @clone
 *
 * A linked list is given such that each node contains an additional random pointer
 * which could point to any node in the list or null.
 *
 * problems to solve:
 * 1. deep clone the same list of nodes with the original one
 * 2. add the reference for next and random pointer
 * 3. look up the nodes in the list
 *
 * make a copy is straightforward
 * adding the reference for next node is straightforward
 * adding the reference for random pointer, the node may :
 *   may be created already (before the node)
 *   may not be created yet (after the node)
 *
 * extra space allowed:
 * first pass to create all the nodes in the map
 *   node -> deep copied node
 * second pass, add reference for next and random pointer
 */
public class CopyListWithRandomPointer {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return null;
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
     * if no extra space is allowed:
     * scan once and create a new list, with same label/value and next node reference
     * for random pointer:
     *   it might be before or after the current node - start from head to find the target, time consuming O(n^n)
     *   if we need direct lookup in the list, try to concatenate/combine the two lists as one first
     *     original  1  2  3  4  5
     *     copied     1' 2' 3' 4' 5'
     *     1-1'-2-2'-...-5-5'
     * for random,  original.next.random = original.random.next
     * at last, separate the new list from original list
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
