package practice.leetcode.medium;

import java.util.*;

/**
 * @graph
 * @Djikstra
 *
 * There are N network nodes, labelled 1 to N.
 * Given times, a list of travel times as directed edges times[i] = (u, v, w), where u is the source node,
 * v is the target node, and w is the time it takes for a signal to travel from source to target.
 * Now, we send a signal from a certain node K. How long will it take for all nodes to receive the signal?
 * If it is impossible, return -1.
 *
 * there might be multiple paths between nodes
 * need to track the lowest time to reach each node
 * 1. build the graph -> List<int[]>[] size of n+1
 * 2. pq [node, cost]
 * start from K with cost 0
 * poll from queue, check each neighbor and add to queue
 *
 */
public class NetworkDelayTime {
    public int networkDelayTime(int[][] times, int N, int K) {
        List<int[]>[] graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();
        for (int[] t : times) graph[t[0]].add(new int[]{t[1], t[2]});
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{K, 0});
        int time = 0;
        Set<Integer> visited = new HashSet<>();
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            if (!visited.add(cur[0])) continue;
            time = cur[1];
            for (int[] neighbor : graph[cur[0]]) {
                if (!visited.contains(neighbor[0])) pq.offer(new int[]{neighbor[0], neighbor[1] + time});
            }
        }
        return visited.size() == N ? time : -1;
    }
}
