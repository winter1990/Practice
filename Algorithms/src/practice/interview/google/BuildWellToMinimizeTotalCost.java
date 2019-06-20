package practice.interview.google;

import java.util.*;

/**
 * 第一轮建水井，一个村庄里有很多房子，有的房子旁边能建水井，有的房子只能通过与其他房子建立管道获得供水。给出了在不同房子旁边建水井的花费，
 * 已及两个房子间建管道的花费，要求结果给出一份竞价，使得总花费尽可能少
 *
 * pipe cost[][], pipe[n][3], pipe[i][0] -> pipe[i][1], with cost/weight houses[i][2]
 * well cost[][], well[][2], the cost if we build the well at house i, with the cost well[i][1]
 *
 * for each house, h[0], h[1], h[2], map<integer, map<integer, int>>
 * for each cost[i][0], bfs, get minimum cost to each
 * track the total cost and get minimum
 */
public class BuildWellToMinimizeTotalCost {
    public int totalCost(int[][] wells, int[][] houses) {
        Set<Integer> set = new HashSet<>();
        for (int[] h : houses) {
            set.add(h[0]);
            set.add(h[1]);
        }
        int minWell = Integer.MAX_VALUE;
        for (int[] w : wells) {
            minWell = Math.min(minWell, w[1]);
        }
        int cost = calculateCost(houses, set.size());
        return cost + minWell;
    }

    private int calculateCost(int[][] houses, int n) {
        int total = 0;
        int[] parent = new int[n];
        for (int i = 1; i < n; i++) parent[i] = i;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        for (int[] h : houses) pq.offer(h);
        for (int i = 0; i < n; i++) {
            int[] p = pq.poll();
            int from = p[0], to = p[1], cost = p[2];
            int pf = find(parent, from);
            int pt = find(parent, to);
            if (pf != pt) {
                parent[pt] = pf;
                total += cost;
            }
        }
        return total;
    }

    private int find(int[] parent, int i) {
        while (parent[i] != i) {
            i = parent[i];
        }
        return i;
    }

    public static void main(String[] args) {
        BuildWellToMinimizeTotalCost b = new BuildWellToMinimizeTotalCost();
        int[][] well = {{6,1},{1,5}};
        int[][] houses = {{0,1,2},{1,2,10},{1,3,5},{3,4,25},{2,4,10},{3,5,9},{5,4,6},{4,6,3}};
        System.out.println(b.totalCost(well, houses));
    }
}
