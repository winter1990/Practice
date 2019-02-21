package practice.leetcode.medium;

import java.util.*;

/**
 * @graph
 * @bfs
 * @clone
 *
 * Given the head of a graph, return a deep copy (clone) of the graph.
 * Each node in the graph contains a label (int) and a list (List[UndirectedGraphNode]) of its neighbors
 * Nodes are labeled uniquely
 *
 * multiple neighbors
 * node -> label
 *
 * start with root node, check all neighbors, then neighbors's neighbors -> breadth search (queue)
 * two scenarios: if node created already, add to neib list, if not, create a new node
 * need some DS to store the nodes created - Set<Node> set is to check dup, we also need to add the node to neighbor list
 * use map <Integer, Node> label as key to store all the new created nodes
 */
public class CloneGraph {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }
        UndirectedGraphNode newHead = new UndirectedGraphNode(node.label);
        Queue<UndirectedGraphNode> q = new LinkedList<>();
        q.add(node);
        Map<Integer, UndirectedGraphNode> map = new HashMap<>();
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

    public UndirectedGraphNode cloneGraph1(UndirectedGraphNode node) {
        Map<Integer, UndirectedGraphNode> map = new HashMap<>();
        return clone(node, map);
    }

    private UndirectedGraphNode clone(UndirectedGraphNode node, Map<Integer, UndirectedGraphNode> map) {
        if (node == null) {
            return null;
        }
        if (map.containsKey(node.label)) {
            return map.get(node.label);
        }
        UndirectedGraphNode copy = new UndirectedGraphNode(node.label);
        map.put(copy.label, copy);
        for (UndirectedGraphNode neighbor : node.neighbors) {
            copy.neighbors.add(clone(neighbor, map));
        }
        return copy;
    }
}
