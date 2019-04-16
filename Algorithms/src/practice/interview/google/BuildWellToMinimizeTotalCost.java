package practice.interview.google;

import java.util.*;

/**
 * cost[][], houses[][3] houses[i][0] -> houses[i][1], with cost/weight houses[i][2]
 *
 * problem to solve:
 * 1. multiple path to different houses -> get the minimum
 * 2. total cost
 *
 * for each house, h[0], h[1], h[2], map<integer, map<integer, int>>
 * for each cost[i][0], bfs, get minimum cost to each
 * track the total cost and get minimum
 */
public class BuildWellToMinimizeTotalCost {
    public int totalCost(int[][] wellCost, int[][] houses) {
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for (int[] h : houses) {
            int from = h[0], to = h[1], cost = h[2];
            if (!map.containsKey(from)) {
                map.put(from, new HashMap<>());
            }
            if (!map.containsKey(to)) {
                map.put(to, new HashMap<>());
            }
            map.get(from).put(to, cost);
            map.get(to).put(from, cost);
        }
        int min = Integer.MAX_VALUE;
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> (a[1] - b[1]));
        for (int[] w : wellCost) {
            int start = w[0], c = w[1], sum = 0;
            q.offer(new int[]{start, 0});
            int[] total = new int[map.size()];
            Arrays.fill(total, Integer.MAX_VALUE);
            while (!q.isEmpty()) {
                int[] in = q.poll();
                int cur = in[0];
                int cost = in[1];
                for (int nei : map.get(cur).keySet()) {
                    if (nei == start) continue;
                    int v = cost + map.get(cur).get(nei);
                    if (v < total[nei]) {
                        q.offer(new int[]{nei, v});
                        total[nei] = Math.min(total[nei], v);
                    }
                }
            }

            PriorityQueue<int[]> pq = new PriorityQueue<>();
            pq.offer(new int[]{start, 0});
            Set<Integer> set = new HashSet<>();
            set.add(start);
            while (!pq.isEmpty()) {
                int[] next = pq.poll();

            }
            sum += c;
            min = Math.min(min, sum);
        }
        return min;
    }

    public static void main(String[] args) {
        BuildWellToMinimizeTotalCost b = new BuildWellToMinimizeTotalCost();
        int[][] well = {{6,10},{1,1}};
        int[][] houses = {{0,1,2},{1,2,10},{1,3,5},{3,4,25},{2,4,10},{3,5,9},{5,4,6},{4,6,3}};
        System.out.println(b.totalCost(well, houses));
    }
}
