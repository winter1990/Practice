package practice.leetcode.medium;

import java.util.*;

/**
 * @graph
 *
 * Nodes are labeled uniquely
 * deep clone
 * it has label and neighbors
 *
 * multiple neighbors
 * node->label
 * Map<Int,List>
 *
 * need a queue to traverse
 */
public class CloneGraph {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }
        Queue<UndirectedGraphNode> q = new LinkedList<>();
        Map<Integer, UndirectedGraphNode> map = new HashMap<>();
        q.add(node);
        UndirectedGraphNode newHead = new UndirectedGraphNode(node.label);
        map.put(newHead.label, newHead);

        while (!q.isEmpty()) {
            UndirectedGraphNode cur = q.poll();
            for (UndirectedGraphNode neighbor : cur.neighbors) {
                if (!map.containsKey(neighbor.label)) {
                    map.put(neighbor.label, new UndirectedGraphNode(neighbor.label));
                    q.add(neighbor);
                }
                map.get(cur.label).neighbors.add(map.get(neighbor.label));
            }
        }
        return newHead;
    }

    public static void main(String[] args) {
        CloneGraph cg = new CloneGraph();

    }
}
