package practice.leetcode.medium;

import java.util.Arrays;
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
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for (int[] f : flights) map.computeIfAbsent(f[0], m -> new HashMap<>()).put(f[1], f[2]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{0, src, 0});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            if (cur[1] == dst) return cur[0];
            if (cur[2] <= k) {
                Map<Integer, Integer> neighbors = map.getOrDefault(cur[1], new HashMap<>());
                for (int next : neighbors.keySet()) {
                    pq.offer(new int[]{cur[0] + neighbors.get(next), next, cur[2] + 1});
                }
            }
        }
        return -1;
    }

    public int findCheapestPrice1(int n, int[][] flights, int src, int dst, int k) {
        int[] cost = new int[n];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[src] = 0;
        int ans = cost[dst];
        for (int i = k; i >= 0; i--) {
            int[] cur = new int[n];
            Arrays.fill(cur, Integer.MAX_VALUE);
            for (int[] f : flights) {
                cur[f[1]] = Math.min(cur[f[1]], cost[f[0]] + f[2]);
            }
            cost = cur;
            ans = Math.min(ans, cost[dst]);
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}