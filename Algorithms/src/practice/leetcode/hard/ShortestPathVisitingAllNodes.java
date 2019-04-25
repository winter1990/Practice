package practice.leetcode.hard;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @graph
 *
 * An undirected, connected graph of N nodes (labeled 0, 1, 2, ..., N-1) is given as graph.
 * graph.length = N, and j != i is in the list graph[i] exactly once, if and only if nodes i and j are connected.
 * Return the length of the shortest path that visits every node. You may start and stop at any node,
 * you may revisit nodes multiple times, and you may reuse edges.
 *
 * Input: [[1,2,3],[0],[0],[0]], Output: 4, Explanation: One possible path is [1,0,2,0,3]
 * Input: [[1],[0,2,4],[1,3,4],[2],[1,2]], Output: 4, Explanation: One possible path is [0,1,4,2,3]
 *
 * some key points:
 * 1. we can start from any node
 * 2. there are 1 <= graph.length <= 12 number of nodes
 * 3. the cost/weight between two adjacent nodes is 1
 * 4. we must visit all the nodes in traversal
 * 5. same node can be visited multiple times
 *
 * problems to solve:
 * 1. which node to start with - or consider about all the options [0, N]
 * 2. if we consider multiple nodes, need to keep track for each path
 * 3. for each path, keep track of the number of steps
 *
 * as there are totally at most 12 nodes, we can use a single integer
 *   mask = (1 << n) - 1 -> 1111...11 (n 1s)
 *   bfs each node
 */
public class ShortestPathVisitingAllNodes {
    public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        int bitMask = (1 << n) - 1;
        Set<String> visited = new HashSet<>();
        Queue<Node> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            Node node = new Node(i, (1 << i));
            q.offer(node);
            visited.add(node.toString());
        }
        int level = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Node cur =  q.poll();
                if (cur.mask == bitMask) return level;
                for (int next : graph[cur.id]) {
                    Node nextNode = new Node(next, cur.mask | (1 << next));
                    if (visited.contains(nextNode.toString())) continue;
                    visited.add(nextNode.toString());
                    q.offer(nextNode);
                }
            }
            level++;
        }
        return level;
    }

    class Node {
        int mask;
        int id;
        public Node(int id, int mask) {
            this.id = id;
            this.mask = mask;
        }

        public String toString() {
            return id + " " + mask;
        }
    }
}
