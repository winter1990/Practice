package practice.leetcode.question;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @graph
 * @dp
 * @heap
 *
 * There are n cities connected by m flights. Each fight starts from city u and arrives at v with a price w.
 * Now given all the cities and flights, together with starting city src and the destination dst, your task is to find
 * the cheapest price from src to dst with up to k stops. If there is no such route, output -1.
 *
 * dynamic programming:
 * build up the 2d array
 * [[0,1,100],[1,2,100],[0,2,500]]
 * 0 100 500
 * 0  0  100
 * 0  0
 * k stops - not good
 *
 * problems to solve:
 * 1. build the graph between cities, with the weight between two cities
 * 2. find the most light weight from start to destination within k stops
 *
 * because it is directed map, for quick look up, we can use a map to track from->to->cost
 * because of the limitation of k stops:
 * -> use a queue to bfs
 * -> priority queue to handle the minimum cost
 */
public class CheapestFlightsWithinKStops {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for (int[] f : flights) map.computeIfAbsent(f[0], m -> new HashMap<>()).put(f[1], f[2]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        pq.offer(new int[]{0, src, K + 1});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            if (cur[1] == dst) return cur[0];
            if (cur[2] > 0) {
                Map<Integer, Integer> nei = map.getOrDefault(cur[1], new HashMap<>());
                for (int nextStop : nei.keySet()) {
                    pq.offer(new int[]{cur[0] + nei.get(nextStop), nextStop, cur[2] - 1});
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
            for (int[] flight : flights) {
                cur[flight[1]] = Math.min(cur[flight[1]], cost[flight[0]] + flight[2]);
            }
            cost = cur;
            ans = Math.min(ans, cost[dst]);
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
