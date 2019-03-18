package practice.leetcode.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @search
 * @graph
 *
 * There are n cities connected by m flights. Each fight starts from city u and arrives at v with a price w.
 * Now given all the cities and flights, together with starting city src and the destination dst, your task is to
 * find the cheapest price from src to dst with up to k stops. If there is no such route, output -1.
 *
 * bfs
 * Dijkstra's algorithm
 * need to consider all the possible paths
 */
public class CheapestFlightsWithinKStops {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for (int[] flight : flights) {
            if (!map.containsKey(flight[0])) map.put(flight[0], new HashMap<>());
            map.get(flight[0]).put(flight[1], flight[2]);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{0, src, K + 1});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            if (cur[1] == dst) return cur[0];
            if (cur[2] > 0) {
                Map<Integer, Integer> next = map.getOrDefault(cur[1], new HashMap<>());
                for (int nextStop : next.keySet()) {
                    pq.offer(new int[]{cur[0] + next.get(nextStop), nextStop, cur[2] - 1});
                }
            }
        }
        return -1;
    }
}
