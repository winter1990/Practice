package practice.leetcode.question;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 *
 * dynamic programming:
 * build up the 2d array
 * [[0,1,100],[1,2,100],[0,2,500]]
 * 0 100 500
 * 0  0  100
 * 0  0
 * k stops - not good
 *
 * Graph:
 * find shortest distance
 * but limitation - k stops
 */
public class CheapestFlightsWithinKStops {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        if (flights == null || flights.length == 0) {
            return 0;
        }
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for (int[] a : flights) {
            map.put(a[0], map.getOrDefault(a[0], new HashMap<>()));
            map.put(a[1], map.getOrDefault(a[1], new HashMap<>()));
            map.get(a[0]).put(a[1], a[2]);
        }
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> (Integer.compare(a[0], b[0])));
        pq.add(new int[]{0, src, K + 1});
        while (!pq.isEmpty()) {
            int[] top = pq.remove();
            int price = top[0];
            int city = top[1];
            int stops = top[2];
            if (city == dst) return price;
            if(stops > 0) {
                Map<Integer, Integer> adj = map.get(city);
                for(int a : adj.keySet()){
                    pq.add(new int[]{price+adj.get(a), a, stops - 1});
                }
            }
        }
        return -1;
    }
}
