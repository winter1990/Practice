package practice.interview.google;

import java.util.*;

/**
 * deep copy a graph
 * also change the undirected to directed
 * directed means the id of node is larger than its parent
 *
 *  1 - 3 - 4
 *   \   \ /
 *    2 - 5
 *
 *  1<-3<-4
 *   \   /
 *   2 <-5
 */
public class CloneGraph {
    public void cloneGraph(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        Map<Integer, Node> map = new HashMap<>();
        Node newRoot = new Node(root.id);
        map.put(newRoot.id, newRoot);

        while (!q.isEmpty()) {
            Node cur = q.poll();
            for (Node node : cur.neighbor) {
                if (!map.containsKey(node.id)) {
                    Node n = new Node(node.id);
                    map.put(n.id, n);
                    q.offer(node);
                }
                if (cur.id > node.id) {
                    map.get(cur.id).neighbor.add(map.get(node.id));
                } else {
                    map.get(node.id).neighbor.add(map.get(cur.id));
                }
            }
        }
    }

    class Node {
        int id;
        List<Node> neighbor;
        public Node(int id) {
            this.id = id;
            neighbor = new ArrayList<>();
        }
    }
}


