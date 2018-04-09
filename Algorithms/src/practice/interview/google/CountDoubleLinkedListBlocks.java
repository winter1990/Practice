package practice.interview.google;

import java.util.HashSet;
import java.util.Set;

/**
 * given double linked list and array of references to nodes on linked list
 * count how many blocks are there present in the linked list
 *
 * n1 <-> n2 <-> n3 <-> n4 <-> n5 <-> n6
 * nodes[] = {n2 n6 n4 n3}
 * there are two blocks
 *
 * the condition that we can count it as block:
 * iterate the array of nodes:
 * head
 * tail
 * middle node
 */
public class CountDoubleLinkedListBlocks {
    public int countBlocks(DoubleListNode[] nodes) {
        if (nodes == null || nodes.length == 0) {
            return 0;
        }
        Set<DoubleListNode> set = new HashSet<>();
        int cnt = 0;
        for (DoubleListNode node : nodes) {
            cnt++;
            if (node.previous != null) {
                cnt--;
            }
            if (node.next != null) {
                cnt--;
            }
        }
        return cnt;
    }
}
