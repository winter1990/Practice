package practice.leetcode.hard;

import java.util.*;

/**
 * @bfs
 *
 * We have a list of bus routes. Each routes[i] is a bus route that the i-th bus repeats forever.
 * For example if routes[0] = [1, 5, 7], this means that the first bus (0-th indexed) travels in the sequence
 * 1->5->7->1->5->7->1->... forever.
 *
 * We start at bus stop S (initially not on a bus), and we want to go to bus stop T.
 * Travelling by buses only, what is the least number of buses we must take to reach our destination?
 * Return -1 if it is not possible.
 *
 * problems to solve:
 * 1. find the path from start to end
 * 2. besides considering the path and distances, we also need to keep track of the transition / change paths
 * 3. build the routes
 *
 * to build the routes
 *   map
 *     stop id
 *     next stop id and routes id
 * bfs
 *   use a queue, start with s, with all potential paths
 *   int[3] [next, route id, transitions]
 */
public class BusRoutes {
    public int numBusesToDestination(int[][] routes, int S, int T) {
        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int i = 0; i < routes.length; i++) {
            int[] route = routes[i];
            for (int j = 0; j < route.length; j++) {
                if (!map.containsKey(route[j])) map.put(route[j], new ArrayList<>());
                if (j == route.length - 1) {
                    map.get(route[j]).add(new int[]{route[0], i});
                    break;
                }
                map.get(route[j]).add(new int[]{route[j + 1], i});
            }
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[2] - b[2]));
        int[] cur = new int[]{S, -1, 0};
        pq.offer(cur);
        Set<String> visited = new HashSet<>();
        while (!pq.isEmpty()) {
            cur = pq.poll();
            int curStop = cur[0], routeId = cur[1], transitions = cur[2];
            if (curStop == T) break;
            if (!visited.add(curStop + " " + routeId)) continue;
            for (int[] next : map.get(curStop)) {
                if (routeId == -1) {
                    pq.offer(new int[]{next[0], next[1], 1});
                    continue;
                }
                pq.offer(new int[]{next[0], next[1], routeId == next[1] ? transitions : transitions + 1});
            }
        }
        return cur[0] == T ? cur[2] : -1;
    }

    public static void main(String[] args) {
        BusRoutes b = new BusRoutes();
        int[][] in = {{1, 2, 7}, {3, 6, 7}};
        System.out.println(b.numBusesToDestination(in,1,6));
    }
}
